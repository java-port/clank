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

package org.llvm.analysis.target;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;


/// \brief This pass provides access to the codegen interfaces that are needed
/// for IR-level transformations.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 61,
 FQN="llvm::TargetTransformInfo", NM="_ZN4llvm19TargetTransformInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfoE")
//</editor-fold>
public class TargetTransformInfo implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Construct a TTI object using a type implementing the \c Concept
  /// API below.
  ///
  /// This is used by targets to construct a TTI wrapping their target-specific
  /// implementaion that encodes appropriate costs for their target.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::TargetTransformInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 984,
   FQN="llvm::TargetTransformInfo::TargetTransformInfo", NM="Tpl__ZN4llvm19TargetTransformInfoC1ET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=Tpl__ZN4llvm19TargetTransformInfoC1ET_")
  //</editor-fold>
  public </*typename*/ T> TargetTransformInfo(T Impl) {
    // : TTIImpl(new Model<T>(( Impl ))) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Construct a baseline TTI object using a minimal implementation of
  /// the \c Concept API below.
  ///
  /// The TTI implementation will reflect the information in the DataLayout
  /// provided if non-null.
  
  /// \brief Construct a baseline TTI object using a minimal implementation of
  /// the \c Concept API below.
  ///
  /// The TTI implementation will reflect the information in the DataLayout
  /// provided if non-null.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::TargetTransformInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 37,
   FQN="llvm::TargetTransformInfo::TargetTransformInfo", NM="_ZN4llvm19TargetTransformInfoC1ERKNS_10DataLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm19TargetTransformInfoC1ERKNS_10DataLayoutE")
  //</editor-fold>
  public TargetTransformInfo(final /*const*/ DataLayout /*&*/ DL) {
    // : TTIImpl(new Model<NoTTIImpl>(NoTTIImpl(DL))) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Provide move semantics.
  
  // Provide move semantics.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::TargetTransformInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 42,
   FQN="llvm::TargetTransformInfo::TargetTransformInfo", NM="_ZN4llvm19TargetTransformInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm19TargetTransformInfoC1EOS0_")
  //</editor-fold>
  public TargetTransformInfo(JD$Move _dparam, final TargetTransformInfo /*&&*/Arg) {
    // : TTIImpl(std::move(Arg.TTIImpl)) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 45,
   FQN="llvm::TargetTransformInfo::operator=", NM="_ZN4llvm19TargetTransformInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm19TargetTransformInfoaSEOS0_")
  //</editor-fold>
  public TargetTransformInfo /*&*/ $assignMove(final TargetTransformInfo /*&&*/RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // We need to define the destructor out-of-line to define our sub-classes
  // out-of-line.
  
  // We need to define the destructor out-of-line to define our sub-classes
  // out-of-line.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::~TargetTransformInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 40,
   FQN="llvm::TargetTransformInfo::~TargetTransformInfo", NM="_ZN4llvm19TargetTransformInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm19TargetTransformInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Handle the invalidation of this information.
  ///
  /// When used as a result of \c TargetIRAnalysis this method will be called
  /// when the function this was computed for changes. When it returns false,
  /// the information is preserved across those changes.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::invalidate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 90,
   FQN="llvm::TargetTransformInfo::invalidate", NM="_ZN4llvm19TargetTransformInfo10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo10invalidateERNS_8FunctionERKNS_17PreservedAnalysesE")
  //</editor-fold>
  public boolean invalidate(final Function /*&*/ $Prm0, final /*const*/ PreservedAnalyses /*&*/ $Prm1) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \name Generic Target Information
  /// @{
  
  /// \brief Underlying constants for 'cost' values in this interface.
  ///
  /// Many APIs in this interface return a cost. This enum defines the
  /// fundamental values that should be used to interpret (and produce) those
  /// costs. The costs are returned as an int rather than a member of this
  /// enumeration because it is expected that the cost of one IR instruction
  /// may have a multiplicative factor to it or otherwise won't fit directly
  /// into the enum. Moreover, it is common to sum or average costs which works
  /// better as simple integral values. Thus this enum only provides constants.
  /// Also note that the returned costs are signed integers to make it natural
  /// to add, subtract, and test with zero (a common boundary condition). It is
  /// not expected that 2^32 is a realistic cost to be modeling at any point.
  ///
  /// Note that these costs should usually reflect the intersection of code-size
  /// cost and execution cost. A free instruction is typically one that folds
  /// into another instruction. For example, reg-to-reg moves can often be
  /// skipped by renaming the registers in the CPU, but they still are encoded
  /// and thus wouldn't be considered 'free' here.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::TargetCostConstants">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 117,
   FQN="llvm::TargetTransformInfo::TargetCostConstants", NM="_ZN4llvm19TargetTransformInfo19TargetCostConstantsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo19TargetCostConstantsE")
  //</editor-fold>
  public enum TargetCostConstants implements Native.NativeUIntEnum {
    TCC_Free(0), ///< Expected to fold away in lowering.
    TCC_Basic(1), ///< The cost of a typical 'add' instruction.
    TCC_Expensive(4); ///< The cost of a 'div' instruction on x86.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TargetCostConstants valueOf(int val) {
      TargetCostConstants out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TargetCostConstants[] VALUES;
      private static final TargetCostConstants[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TargetCostConstants kind : TargetCostConstants.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TargetCostConstants[min < 0 ? (1-min) : 0];
        VALUES = new TargetCostConstants[max >= 0 ? (1+max) : 0];
        for (TargetCostConstants kind : TargetCostConstants.values()) {
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
    private TargetCostConstants(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Estimate the cost of a specific operation when lowered.
  ///
  /// Note that this is designed to work on an arbitrary synthetic opcode, and
  /// thus work for hypothetical queries before an instruction has even been
  /// formed. However, this does *not* work for GEPs, and must not be called
  /// for a GEP instruction. Instead, use the dedicated getGEPCost interface as
  /// analyzing a GEP's cost required more information.
  ///
  /// Typically only the result type is required, and the operand type can be
  /// omitted. However, if the opcode is one of the cast instructions, the
  /// operand type is required.
  ///
  /// The returned cost is defined in terms of \c TargetCostConstants, see its
  /// comments for a detailed explanation of the cost values.
  
  /// \brief Estimate the cost of a specific operation when lowered.
  ///
  /// Note that this is designed to work on an arbitrary synthetic opcode, and
  /// thus work for hypothetical queries before an instruction has even been
  /// formed. However, this does *not* work for GEPs, and must not be called
  /// for a GEP instruction. Instead, use the dedicated getGEPCost interface as
  /// analyzing a GEP's cost required more information.
  ///
  /// Typically only the result type is required, and the operand type can be
  /// omitted. However, if the opcode is one of the cast instructions, the
  /// operand type is required.
  ///
  /// The returned cost is defined in terms of \c TargetCostConstants, see its
  /// comments for a detailed explanation of the cost values.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getOperationCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 50,
   FQN="llvm::TargetTransformInfo::getOperationCost", NM="_ZNK4llvm19TargetTransformInfo16getOperationCostEjPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo16getOperationCostEjPNS_4TypeES2_")
  //</editor-fold>
  public int getOperationCost(/*uint*/int Opcode, Type /*P*/ Ty) /*const*/ {
    return getOperationCost(Opcode, Ty, 
                  (Type /*P*/ )null);
  }
  public int getOperationCost(/*uint*/int Opcode, Type /*P*/ Ty, 
                  Type /*P*/ OpTy/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Estimate the cost of a GEP operation when lowered.
  ///
  /// The contract for this function is the same as \c getOperationCost except
  /// that it supports an interface that provides extra information specific to
  /// the GEP operation.
  
  /// \brief Estimate the cost of a GEP operation when lowered.
  ///
  /// The contract for this function is the same as \c getOperationCost except
  /// that it supports an interface that provides extra information specific to
  /// the GEP operation.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getGEPCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 74,
   FQN="llvm::TargetTransformInfo::getGEPCost", NM="_ZNK4llvm19TargetTransformInfo10getGEPCostEPNS_4TypeEPKNS_5ValueENS_8ArrayRefIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo10getGEPCostEPNS_4TypeEPKNS_5ValueENS_8ArrayRefIS5_EE")
  //</editor-fold>
  public int getGEPCost(Type /*P*/ PointeeType, /*const*/ Value /*P*/ Ptr, 
            ArrayRef</*const*/ Value /*P*/ > Operands) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Estimate the cost of a function call when lowered.
  ///
  /// The contract for this is the same as \c getOperationCost except that it
  /// supports an interface that provides extra information specific to call
  /// instructions.
  ///
  /// This is the most basic query for estimating call cost: it only knows the
  /// function type and (potentially) the number of arguments at the call site.
  /// The latter is only interesting for varargs function types.
  
  /// \brief Estimate the cost of a function call when lowered.
  ///
  /// The contract for this is the same as \c getOperationCost except that it
  /// supports an interface that provides extra information specific to call
  /// instructions.
  ///
  /// This is the most basic query for estimating call cost: it only knows the
  /// function type and (potentially) the number of arguments at the call site.
  /// The latter is only interesting for varargs function types.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCallCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 57,
   FQN="llvm::TargetTransformInfo::getCallCost", NM="_ZNK4llvm19TargetTransformInfo11getCallCostEPNS_12FunctionTypeEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo11getCallCostEPNS_12FunctionTypeEi")
  //</editor-fold>
  public int getCallCost(FunctionType /*P*/ FTy) /*const*/ {
    return getCallCost(FTy, -1);
  }
  public int getCallCost(FunctionType /*P*/ FTy, int NumArgs/*= -1*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Estimate the cost of calling a specific function when lowered.
  ///
  /// This overload adds the ability to reason about the particular function
  /// being called in the event it is a library call with special lowering.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCallCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 162,
   FQN="llvm::TargetTransformInfo::getCallCost", NM="_ZNK4llvm19TargetTransformInfo11getCallCostEPKNS_8FunctionEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZNK4llvm19TargetTransformInfo11getCallCostEPKNS_8FunctionEi")
  //</editor-fold>
  public int getCallCost(/*const*/ Function /*P*/ F) /*const*/ {
    return getCallCost(F, -1);
  }
  public int getCallCost(/*const*/ Function /*P*/ F, int NumArgs/*= -1*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Estimate the cost of calling a specific function when lowered.
  ///
  /// This overload allows specifying a set of candidate argument values.
  
  /// \brief Estimate the cost of calling a specific function when lowered.
  ///
  /// This overload allows specifying a set of candidate argument values.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCallCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 63,
   FQN="llvm::TargetTransformInfo::getCallCost", NM="_ZNK4llvm19TargetTransformInfo11getCallCostEPKNS_8FunctionENS_8ArrayRefIPKNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo11getCallCostEPKNS_8FunctionENS_8ArrayRefIPKNS_5ValueEEE")
  //</editor-fold>
  public int getCallCost(/*const*/ Function /*P*/ F, 
             ArrayRef</*const*/ Value /*P*/ > Arguments) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns A value by which our inlining threshold should be multiplied.
  /// This is primarily used to bump up the inlining threshold wholesale on
  /// targets where calls are unusually expensive.
  ///
  /// TODO: This is a rather blunt instrument.  Perhaps altering the costs of
  /// individual classes of instructions would be better.
  
  /// \returns A value by which our inlining threshold should be multiplied.
  /// This is primarily used to bump up the inlining threshold wholesale on
  /// targets where calls are unusually expensive.
  ///
  /// TODO: This is a rather blunt instrument.  Perhaps altering the costs of
  /// individual classes of instructions would be better.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getInliningThresholdMultiplier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 70,
   FQN="llvm::TargetTransformInfo::getInliningThresholdMultiplier", NM="_ZNK4llvm19TargetTransformInfo30getInliningThresholdMultiplierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo30getInliningThresholdMultiplierEv")
  //</editor-fold>
  public /*uint*/int getInliningThresholdMultiplier() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Estimate the cost of an intrinsic when lowered.
  ///
  /// Mirrors the \c getCallCost method but uses an intrinsic identifier.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getIntrinsicCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 180,
   FQN="llvm::TargetTransformInfo::getIntrinsicCost", NM="_ZNK4llvm19TargetTransformInfo16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZNK4llvm19TargetTransformInfo16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public int getIntrinsicCost_ID_Type$P_ArrayRef$Type$P(/*Intrinsic.ID*/int IID, Type /*P*/ RetTy, 
                                            ArrayRef<Type /*P*/ > ParamTys) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Estimate the cost of an intrinsic when lowered.
  ///
  /// Mirrors the \c getCallCost method but uses an intrinsic identifier.
  
  /// \brief Estimate the cost of an intrinsic when lowered.
  ///
  /// Mirrors the \c getCallCost method but uses an intrinsic identifier.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getIntrinsicCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 79,
   FQN="llvm::TargetTransformInfo::getIntrinsicCost", NM="_ZNK4llvm19TargetTransformInfo16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPKNS_5ValueEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPKNS_5ValueEEE")
  //</editor-fold>
  public int getIntrinsicCost_ID_Type$P_ArrayRef$Value$C$P(/*Intrinsic.ID*/int IID, Type /*P*/ RetTy, ArrayRef</*const*/ Value /*P*/ > Arguments) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Estimate the cost of a given IR user when lowered.
  ///
  /// This can estimate the cost of either a ConstantExpr or Instruction when
  /// lowered. It has two primary advantages over the \c getOperationCost and
  /// \c getGEPCost above, and one significant disadvantage: it can only be
  /// used when the IR construct has already been formed.
  ///
  /// The advantages are that it can inspect the SSA use graph to reason more
  /// accurately about the cost. For example, all-constant-GEPs can often be
  /// folded into a load or other instruction, but if they are used in some
  /// other context they may not be folded. This routine can distinguish such
  /// cases.
  ///
  /// The returned cost is defined in terms of \c TargetCostConstants, see its
  /// comments for a detailed explanation of the cost values.
  
  /// \brief Estimate the cost of a given IR user when lowered.
  ///
  /// This can estimate the cost of either a ConstantExpr or Instruction when
  /// lowered. It has two primary advantages over the \c getOperationCost and
  /// \c getGEPCost above, and one significant disadvantage: it can only be
  /// used when the IR construct has already been formed.
  ///
  /// The advantages are that it can inspect the SSA use graph to reason more
  /// accurately about the cost. For example, all-constant-GEPs can often be
  /// folded into a load or other instruction, but if they are used in some
  /// other context they may not be folded. This routine can distinguish such
  /// cases.
  ///
  /// The returned cost is defined in terms of \c TargetCostConstants, see its
  /// comments for a detailed explanation of the cost values.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getUserCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 86,
   FQN="llvm::TargetTransformInfo::getUserCost", NM="_ZNK4llvm19TargetTransformInfo11getUserCostEPKNS_4UserE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo11getUserCostEPKNS_4UserE")
  //</editor-fold>
  public int getUserCost(/*const*/ User /*P*/ U) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if branch divergence exists.
  ///
  /// Branch divergence has a significantly negative impact on GPU performance
  /// when threads in the same wavefront take different paths due to conditional
  /// branches.
  
  /// \brief Return true if branch divergence exists.
  ///
  /// Branch divergence has a significantly negative impact on GPU performance
  /// when threads in the same wavefront take different paths due to conditional
  /// branches.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::hasBranchDivergence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 92,
   FQN="llvm::TargetTransformInfo::hasBranchDivergence", NM="_ZNK4llvm19TargetTransformInfo19hasBranchDivergenceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo19hasBranchDivergenceEv")
  //</editor-fold>
  public boolean hasBranchDivergence() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Returns whether V is a source of divergence.
  ///
  /// This function provides the target-dependent information for
  /// the target-independent DivergenceAnalysis. DivergenceAnalysis first
  /// builds the dependency graph, and then runs the reachability algorithm
  /// starting with the sources of divergence.
  
  /// \brief Returns whether V is a source of divergence.
  ///
  /// This function provides the target-dependent information for
  /// the target-independent DivergenceAnalysis. DivergenceAnalysis first
  /// builds the dependency graph, and then runs the reachability algorithm
  /// starting with the sources of divergence.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isSourceOfDivergence">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 96,
   FQN="llvm::TargetTransformInfo::isSourceOfDivergence", NM="_ZNK4llvm19TargetTransformInfo20isSourceOfDivergenceEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo20isSourceOfDivergenceEPKNS_5ValueE")
  //</editor-fold>
  public boolean isSourceOfDivergence(/*const*/ Value /*P*/ V) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Test whether calls to a function lower to actual program function
  /// calls.
  ///
  /// The idea is to test whether the program is likely to require a 'call'
  /// instruction or equivalent in order to call the given function.
  ///
  /// FIXME: It's not clear that this is a good or useful query API. Client's
  /// should probably move to simpler cost metrics using the above.
  /// Alternatively, we could split the cost interface into distinct code-size
  /// and execution-speed costs. This would allow modelling the core of this
  /// query more accurately as a call is a single small instruction, but
  /// incurs significant execution cost.
  
  /// \brief Test whether calls to a function lower to actual program function
  /// calls.
  ///
  /// The idea is to test whether the program is likely to require a 'call'
  /// instruction or equivalent in order to call the given function.
  ///
  /// FIXME: It's not clear that this is a good or useful query API. Client's
  /// should probably move to simpler cost metrics using the above.
  /// Alternatively, we could split the cost interface into distinct code-size
  /// and execution-speed costs. This would allow modelling the core of this
  /// query more accurately as a call is a single small instruction, but
  /// incurs significant execution cost.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isLoweredToCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 100,
   FQN="llvm::TargetTransformInfo::isLoweredToCall", NM="_ZNK4llvm19TargetTransformInfo15isLoweredToCallEPKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo15isLoweredToCallEPKNS_8FunctionE")
  //</editor-fold>
  public boolean isLoweredToCall(/*const*/ Function /*P*/ F) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Parameters that control the generic loop unrolling transformation.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::UnrollingPreferences">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 236,
   FQN="llvm::TargetTransformInfo::UnrollingPreferences", NM="_ZN4llvm19TargetTransformInfo20UnrollingPreferencesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo20UnrollingPreferencesE")
  //</editor-fold>
  public static class/*struct*/ UnrollingPreferences {
    /// The cost threshold for the unrolled loop. Should be relative to the
    /// getUserCost values returned by this API, and the expectation is that
    /// the unrolled loop's instructions when run through that interface should
    /// not exceed this cost. However, this is only an estimate. Also, specific
    /// loops may be unrolled even with a cost above this threshold if deemed
    /// profitable. Set this to UINT_MAX to disable the loop body cost
    /// restriction.
    public /*uint*/int Threshold;
    /// If complete unrolling will reduce the cost of the loop below its
    /// expected dynamic cost while rolled by this percentage, apply a discount
    /// (below) to its unrolled cost.
    public /*uint*/int PercentDynamicCostSavedThreshold;
    /// The discount applied to the unrolled cost when the *dynamic* cost
    /// savings of unrolling exceed the \c PercentDynamicCostSavedThreshold.
    public /*uint*/int DynamicCostSavingsDiscount;
    /// The cost threshold for the unrolled loop when optimizing for size (set
    /// to UINT_MAX to disable).
    public /*uint*/int OptSizeThreshold;
    /// The cost threshold for the unrolled loop, like Threshold, but used
    /// for partial/runtime unrolling (set to UINT_MAX to disable).
    public /*uint*/int PartialThreshold;
    /// The cost threshold for the unrolled loop when optimizing for size, like
    /// OptSizeThreshold, but used for partial/runtime unrolling (set to
    /// UINT_MAX to disable).
    public /*uint*/int PartialOptSizeThreshold;
    /// A forced unrolling factor (the number of concatenated bodies of the
    /// original loop in the unrolled loop body). When set to 0, the unrolling
    /// transformation will select an unrolling factor based on the current cost
    /// threshold and other factors.
    public /*uint*/int Count;
    // Set the maximum unrolling factor. The unrolling factor may be selected
    // using the appropriate cost threshold, but may not exceed this number
    // (set to UINT_MAX to disable). This does not apply in cases where the
    // loop is being fully unrolled.
    public /*uint*/int MaxCount;
    /// Set the maximum unrolling factor for full unrolling. Like MaxCount, but
    /// applies even if full unrolling is selected. This allows a target to fall
    /// back to Partial unrolling if full unrolling is above FullUnrollMaxCount.
    public /*uint*/int FullUnrollMaxCount;
    /// Allow partial unrolling (unrolling of loops to expand the size of the
    /// loop body, not only to eliminate small constant-trip-count loops).
    public boolean Partial;
    /// Allow runtime unrolling (unrolling of loops to expand the size of the
    /// loop body even when the number of loop iterations is not known at
    /// compile time).
    public boolean Runtime;
    /// Allow generation of a loop remainder (extra iterations after unroll).
    public boolean AllowRemainder;
    /// Allow emitting expensive instructions (such as divisions) when computing
    /// the trip count of a loop for runtime unrolling.
    public boolean AllowExpensiveTripCount;
    /// Apply loop unroll on any kind of loop
    /// (mainly to loops that fail runtime unrolling).
    public boolean Force;
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::UnrollingPreferences::UnrollingPreferences">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 236,
     FQN="llvm::TargetTransformInfo::UnrollingPreferences::UnrollingPreferences", NM="_ZN4llvm19TargetTransformInfo20UnrollingPreferencesC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo20UnrollingPreferencesC1Ev")
    //</editor-fold>
    public /*inline*/ UnrollingPreferences() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::UnrollingPreferences::UnrollingPreferences">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 236,
     FQN="llvm::TargetTransformInfo::UnrollingPreferences::UnrollingPreferences", NM="_ZN4llvm19TargetTransformInfo20UnrollingPreferencesC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo20UnrollingPreferencesC1EOS1_")
    //</editor-fold>
    public /*inline*/ UnrollingPreferences(JD$Move _dparam, final UnrollingPreferences /*&&*/$Prm0) {
      // : Threshold(static_cast<UnrollingPreferences &&>().Threshold), PercentDynamicCostSavedThreshold(static_cast<UnrollingPreferences &&>().PercentDynamicCostSavedThreshold), DynamicCostSavingsDiscount(static_cast<UnrollingPreferences &&>().DynamicCostSavingsDiscount), OptSizeThreshold(static_cast<UnrollingPreferences &&>().OptSizeThreshold), PartialThreshold(static_cast<UnrollingPreferences &&>().PartialThreshold), PartialOptSizeThreshold(static_cast<UnrollingPreferences &&>().PartialOptSizeThreshold), Count(static_cast<UnrollingPreferences &&>().Count), MaxCount(static_cast<UnrollingPreferences &&>().MaxCount), FullUnrollMaxCount(static_cast<UnrollingPreferences &&>().FullUnrollMaxCount), Partial(static_cast<UnrollingPreferences &&>().Partial), Runtime(static_cast<UnrollingPreferences &&>().Runtime), AllowRemainder(static_cast<UnrollingPreferences &&>().AllowRemainder), AllowExpensiveTripCount(static_cast<UnrollingPreferences &&>().AllowExpensiveTripCount), Force(static_cast<UnrollingPreferences &&>().Force) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Threshold=" + Threshold // NOI18N
                + ", PercentDynamicCostSavedThreshold=" + PercentDynamicCostSavedThreshold // NOI18N
                + ", DynamicCostSavingsDiscount=" + DynamicCostSavingsDiscount // NOI18N
                + ", OptSizeThreshold=" + OptSizeThreshold // NOI18N
                + ", PartialThreshold=" + PartialThreshold // NOI18N
                + ", PartialOptSizeThreshold=" + PartialOptSizeThreshold // NOI18N
                + ", Count=" + Count // NOI18N
                + ", MaxCount=" + MaxCount // NOI18N
                + ", FullUnrollMaxCount=" + FullUnrollMaxCount // NOI18N
                + ", Partial=" + Partial // NOI18N
                + ", Runtime=" + Runtime // NOI18N
                + ", AllowRemainder=" + AllowRemainder // NOI18N
                + ", AllowExpensiveTripCount=" + AllowExpensiveTripCount // NOI18N
                + ", Force=" + Force; // NOI18N
    }
  };
  
  /// \brief Get target-customized preferences for the generic loop unrolling
  /// transformation. The caller will initialize UP with the current
  /// target-independent defaults.
  
  /// \brief Get target-customized preferences for the generic loop unrolling
  /// transformation. The caller will initialize UP with the current
  /// target-independent defaults.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getUnrollingPreferences">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 104,
   FQN="llvm::TargetTransformInfo::getUnrollingPreferences", NM="_ZNK4llvm19TargetTransformInfo23getUnrollingPreferencesEPNS_4LoopERNS0_20UnrollingPreferencesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo23getUnrollingPreferencesEPNS_4LoopERNS0_20UnrollingPreferencesE")
  //</editor-fold>
  public void getUnrollingPreferences(Loop /*P*/ L, final UnrollingPreferences /*&*/ UP) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// @}
  
  /// \name Scalar Target Information
  /// @{
  
  /// \brief Flags indicating the kind of support for population count.
  ///
  /// Compared to the SW implementation, HW support is supposed to
  /// significantly boost the performance when the population is dense, and it
  /// may or may not degrade performance if the population is sparse. A HW
  /// support is considered as "Fast" if it can outperform, or is on a par
  /// with, SW implementation when the population is sparse; otherwise, it is
  /// considered as "Slow".
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::PopcntSupportKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 311,
   FQN="llvm::TargetTransformInfo::PopcntSupportKind", NM="_ZN4llvm19TargetTransformInfo17PopcntSupportKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo17PopcntSupportKindE")
  //</editor-fold>
  public enum PopcntSupportKind implements Native.NativeUIntEnum {
    PSK_Software(0),
    PSK_SlowHardware(PSK_Software.getValue() + 1),
    PSK_FastHardware(PSK_SlowHardware.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PopcntSupportKind valueOf(int val) {
      PopcntSupportKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PopcntSupportKind[] VALUES;
      private static final PopcntSupportKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PopcntSupportKind kind : PopcntSupportKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PopcntSupportKind[min < 0 ? (1-min) : 0];
        VALUES = new PopcntSupportKind[max >= 0 ? (1+max) : 0];
        for (PopcntSupportKind kind : PopcntSupportKind.values()) {
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
    private PopcntSupportKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Return true if the specified immediate is legal add immediate, that
  /// is the target has add instructions which can add a register with the
  /// immediate without having to materialize the immediate into a register.
  
  /// \brief Return true if the specified immediate is legal add immediate, that
  /// is the target has add instructions which can add a register with the
  /// immediate without having to materialize the immediate into a register.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isLegalAddImmediate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 109,
   FQN="llvm::TargetTransformInfo::isLegalAddImmediate", NM="_ZNK4llvm19TargetTransformInfo19isLegalAddImmediateEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo19isLegalAddImmediateEx")
  //</editor-fold>
  public boolean isLegalAddImmediate(long/*int64_t*/ Imm) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if the specified immediate is legal icmp immediate,
  /// that is the target has icmp instructions which can compare a register
  /// against the immediate without having to materialize the immediate into a
  /// register.
  
  /// \brief Return true if the specified immediate is legal icmp immediate,
  /// that is the target has icmp instructions which can compare a register
  /// against the immediate without having to materialize the immediate into a
  /// register.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isLegalICmpImmediate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 113,
   FQN="llvm::TargetTransformInfo::isLegalICmpImmediate", NM="_ZNK4llvm19TargetTransformInfo20isLegalICmpImmediateEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo20isLegalICmpImmediateEx")
  //</editor-fold>
  public boolean isLegalICmpImmediate(long/*int64_t*/ Imm) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if the addressing mode represented by AM is legal for
  /// this target, for a load/store of the specified type.
  /// The type may be VoidTy, in which case only return true if the addressing
  /// mode is legal for a load/store of any legal type.
  /// TODO: Handle pre/postinc as well.
  
  /// \brief Return true if the addressing mode represented by AM is legal for
  /// this target, for a load/store of the specified type.
  /// The type may be VoidTy, in which case only return true if the addressing
  /// mode is legal for a load/store of any legal type.
  /// TODO: Handle pre/postinc as well.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isLegalAddressingMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 117,
   FQN="llvm::TargetTransformInfo::isLegalAddressingMode", NM="_ZNK4llvm19TargetTransformInfo21isLegalAddressingModeEPNS_4TypeEPNS_11GlobalValueExbxj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo21isLegalAddressingModeEPNS_4TypeEPNS_11GlobalValueExbxj")
  //</editor-fold>
  public boolean isLegalAddressingMode(Type /*P*/ Ty, GlobalValue /*P*/ BaseGV, 
                       long/*int64_t*/ BaseOffset, 
                       boolean HasBaseReg, 
                       long/*int64_t*/ Scale) /*const*/ {
    return isLegalAddressingMode(Ty, BaseGV, 
                       BaseOffset, 
                       HasBaseReg, 
                       Scale, 
                       0);
  }
  public boolean isLegalAddressingMode(Type /*P*/ Ty, GlobalValue /*P*/ BaseGV, 
                       long/*int64_t*/ BaseOffset, 
                       boolean HasBaseReg, 
                       long/*int64_t*/ Scale, 
                       /*uint*/int AddrSpace/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if the target supports masked load/store
  /// AVX2 and AVX-512 targets allow masks for consecutive load and store
  
  /// \brief Return true if the target supports masked load/store
  /// AVX2 and AVX-512 targets allow masks for consecutive load and store
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isLegalMaskedStore">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 126,
   FQN="llvm::TargetTransformInfo::isLegalMaskedStore", NM="_ZNK4llvm19TargetTransformInfo18isLegalMaskedStoreEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo18isLegalMaskedStoreEPNS_4TypeE")
  //</editor-fold>
  public boolean isLegalMaskedStore(Type /*P*/ DataType) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isLegalMaskedLoad">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 130,
   FQN="llvm::TargetTransformInfo::isLegalMaskedLoad", NM="_ZNK4llvm19TargetTransformInfo17isLegalMaskedLoadEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo17isLegalMaskedLoadEPNS_4TypeE")
  //</editor-fold>
  public boolean isLegalMaskedLoad(Type /*P*/ DataType) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if the target supports masked gather/scatter
  /// AVX-512 fully supports gather and scatter for vectors with 32 and 64
  /// bits scalar type.
  
  /// \brief Return true if the target supports masked gather/scatter
  /// AVX-512 fully supports gather and scatter for vectors with 32 and 64
  /// bits scalar type.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isLegalMaskedScatter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 138,
   FQN="llvm::TargetTransformInfo::isLegalMaskedScatter", NM="_ZNK4llvm19TargetTransformInfo20isLegalMaskedScatterEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo20isLegalMaskedScatterEPNS_4TypeE")
  //</editor-fold>
  public boolean isLegalMaskedScatter(Type /*P*/ DataType) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isLegalMaskedGather">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 134,
   FQN="llvm::TargetTransformInfo::isLegalMaskedGather", NM="_ZNK4llvm19TargetTransformInfo19isLegalMaskedGatherEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo19isLegalMaskedGatherEPNS_4TypeE")
  //</editor-fold>
  public boolean isLegalMaskedGather(Type /*P*/ DataType) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return the cost of the scaling factor used in the addressing
  /// mode represented by AM for this target, for a load/store
  /// of the specified type.
  /// If the AM is supported, the return value must be >= 0.
  /// If the AM is not supported, it returns a negative value.
  /// TODO: Handle pre/postinc as well.
  
  /// \brief Return the cost of the scaling factor used in the addressing
  /// mode represented by AM for this target, for a load/store
  /// of the specified type.
  /// If the AM is supported, the return value must be >= 0.
  /// If the AM is not supported, it returns a negative value.
  /// TODO: Handle pre/postinc as well.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getScalingFactorCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 142,
   FQN="llvm::TargetTransformInfo::getScalingFactorCost", NM="_ZNK4llvm19TargetTransformInfo20getScalingFactorCostEPNS_4TypeEPNS_11GlobalValueExbxj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo20getScalingFactorCostEPNS_4TypeEPNS_11GlobalValueExbxj")
  //</editor-fold>
  public int getScalingFactorCost(Type /*P*/ Ty, GlobalValue /*P*/ BaseGV, 
                      long/*int64_t*/ BaseOffset, 
                      boolean HasBaseReg, 
                      long/*int64_t*/ Scale) /*const*/ {
    return getScalingFactorCost(Ty, BaseGV, 
                      BaseOffset, 
                      HasBaseReg, 
                      Scale, 
                      0);
  }
  public int getScalingFactorCost(Type /*P*/ Ty, GlobalValue /*P*/ BaseGV, 
                      long/*int64_t*/ BaseOffset, 
                      boolean HasBaseReg, 
                      long/*int64_t*/ Scale, 
                      /*uint*/int AddrSpace/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if it's free to truncate a value of type Ty1 to type
  /// Ty2. e.g. On x86 it's free to truncate a i32 value in register EAX to i16
  /// by referencing its sub-register AX.
  
  /// \brief Return true if it's free to truncate a value of type Ty1 to type
  /// Ty2. e.g. On x86 it's free to truncate a i32 value in register EAX to i16
  /// by referencing its sub-register AX.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isTruncateFree">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 153,
   FQN="llvm::TargetTransformInfo::isTruncateFree", NM="_ZNK4llvm19TargetTransformInfo14isTruncateFreeEPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo14isTruncateFreeEPNS_4TypeES2_")
  //</editor-fold>
  public boolean isTruncateFree(Type /*P*/ Ty1, Type /*P*/ Ty2) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if it is profitable to hoist instruction in the
  /// then/else to before if.
  
  /// \brief Return true if it is profitable to hoist instruction in the
  /// then/else to before if.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isProfitableToHoist">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 157,
   FQN="llvm::TargetTransformInfo::isProfitableToHoist", NM="_ZNK4llvm19TargetTransformInfo19isProfitableToHoistEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo19isProfitableToHoistEPNS_11InstructionE")
  //</editor-fold>
  public boolean isProfitableToHoist(Instruction /*P*/ I) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if this type is legal.
  
  /// \brief Return true if this type is legal.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isTypeLegal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 161,
   FQN="llvm::TargetTransformInfo::isTypeLegal", NM="_ZNK4llvm19TargetTransformInfo11isTypeLegalEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo11isTypeLegalEPNS_4TypeE")
  //</editor-fold>
  public boolean isTypeLegal(Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Returns the target's jmp_buf alignment in bytes.
  
  /// \brief Returns the target's jmp_buf alignment in bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getJumpBufAlignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 165,
   FQN="llvm::TargetTransformInfo::getJumpBufAlignment", NM="_ZNK4llvm19TargetTransformInfo19getJumpBufAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo19getJumpBufAlignmentEv")
  //</editor-fold>
  public /*uint*/int getJumpBufAlignment() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Returns the target's jmp_buf size in bytes.
  
  /// \brief Returns the target's jmp_buf size in bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getJumpBufSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 169,
   FQN="llvm::TargetTransformInfo::getJumpBufSize", NM="_ZNK4llvm19TargetTransformInfo14getJumpBufSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo14getJumpBufSizeEv")
  //</editor-fold>
  public /*uint*/int getJumpBufSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if switches should be turned into lookup tables for the
  /// target.
  
  /// \brief Return true if switches should be turned into lookup tables for the
  /// target.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::shouldBuildLookupTables">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 173,
   FQN="llvm::TargetTransformInfo::shouldBuildLookupTables", NM="_ZNK4llvm19TargetTransformInfo23shouldBuildLookupTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo23shouldBuildLookupTablesEv")
  //</editor-fold>
  public boolean shouldBuildLookupTables() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Don't restrict interleaved unrolling to small loops.
  
  /// \brief Don't restrict interleaved unrolling to small loops.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::enableAggressiveInterleaving">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 177,
   FQN="llvm::TargetTransformInfo::enableAggressiveInterleaving", NM="_ZNK4llvm19TargetTransformInfo28enableAggressiveInterleavingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo28enableAggressiveInterleavingEb")
  //</editor-fold>
  public boolean enableAggressiveInterleaving(boolean LoopHasReductions) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Enable matching of interleaved access groups.
  
  /// \brief Enable matching of interleaved access groups.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::enableInterleavedAccessVectorization">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 181,
   FQN="llvm::TargetTransformInfo::enableInterleavedAccessVectorization", NM="_ZNK4llvm19TargetTransformInfo36enableInterleavedAccessVectorizationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo36enableInterleavedAccessVectorizationEv")
  //</editor-fold>
  public boolean enableInterleavedAccessVectorization() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Indicate that it is potentially unsafe to automatically vectorize
  /// floating-point operations because the semantics of vector and scalar
  /// floating-point semantics may differ. For example, ARM NEON v7 SIMD math
  /// does not support IEEE-754 denormal numbers, while depending on the
  /// platform, scalar floating-point math does.
  /// This applies to floating-point math operations and calls, not memory
  /// operations, shuffles, or casts.
  
  /// \brief Indicate that it is potentially unsafe to automatically vectorize
  /// floating-point operations because the semantics of vector and scalar
  /// floating-point semantics may differ. For example, ARM NEON v7 SIMD math
  /// does not support IEEE-754 denormal numbers, while depending on the
  /// platform, scalar floating-point math does.
  /// This applies to floating-point math operations and calls, not memory
  /// operations, shuffles, or casts.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::isFPVectorizationPotentiallyUnsafe">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 185,
   FQN="llvm::TargetTransformInfo::isFPVectorizationPotentiallyUnsafe", NM="_ZNK4llvm19TargetTransformInfo34isFPVectorizationPotentiallyUnsafeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo34isFPVectorizationPotentiallyUnsafeEv")
  //</editor-fold>
  public boolean isFPVectorizationPotentiallyUnsafe() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Determine if the target supports unaligned memory accesses.
  
  /// \brief Determine if the target supports unaligned memory accesses.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::allowsMisalignedMemoryAccesses">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 189,
   FQN="llvm::TargetTransformInfo::allowsMisalignedMemoryAccesses", NM="_ZNK4llvm19TargetTransformInfo30allowsMisalignedMemoryAccessesEjjjPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo30allowsMisalignedMemoryAccessesEjjjPb")
  //</editor-fold>
  public boolean allowsMisalignedMemoryAccesses(/*uint*/int BitWidth) /*const*/ {
    return allowsMisalignedMemoryAccesses(BitWidth, 
                                0, 
                                1, 
                                (bool$ptr/*bool P*/ )null);
  }
  public boolean allowsMisalignedMemoryAccesses(/*uint*/int BitWidth, 
                                /*uint*/int AddressSpace/*= 0*/) /*const*/ {
    return allowsMisalignedMemoryAccesses(BitWidth, 
                                AddressSpace, 
                                1, 
                                (bool$ptr/*bool P*/ )null);
  }
  public boolean allowsMisalignedMemoryAccesses(/*uint*/int BitWidth, 
                                /*uint*/int AddressSpace/*= 0*/, 
                                /*uint*/int Alignment/*= 1*/) /*const*/ {
    return allowsMisalignedMemoryAccesses(BitWidth, 
                                AddressSpace, 
                                Alignment, 
                                (bool$ptr/*bool P*/ )null);
  }
  public boolean allowsMisalignedMemoryAccesses(/*uint*/int BitWidth, 
                                /*uint*/int AddressSpace/*= 0*/, 
                                /*uint*/int Alignment/*= 1*/, 
                                bool$ptr/*bool P*/ Fast/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return hardware support for population count.
  
  /// \brief Return hardware support for population count.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getPopcntSupport">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 197,
   FQN="llvm::TargetTransformInfo::getPopcntSupport", NM="_ZNK4llvm19TargetTransformInfo16getPopcntSupportEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo16getPopcntSupportEj")
  //</editor-fold>
  public TargetTransformInfo.PopcntSupportKind getPopcntSupport(/*uint*/int IntTyWidthInBit) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return true if the hardware has a fast square-root instruction.
  
  /// \brief Return true if the hardware has a fast square-root instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::haveFastSqrt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 202,
   FQN="llvm::TargetTransformInfo::haveFastSqrt", NM="_ZNK4llvm19TargetTransformInfo12haveFastSqrtEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo12haveFastSqrtEPNS_4TypeE")
  //</editor-fold>
  public boolean haveFastSqrt(Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return the expected cost of supporting the floating point operation
  /// of the specified type.
  
  /// \brief Return the expected cost of supporting the floating point operation
  /// of the specified type.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getFPOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 206,
   FQN="llvm::TargetTransformInfo::getFPOpCost", NM="_ZNK4llvm19TargetTransformInfo11getFPOpCostEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo11getFPOpCostEPNS_4TypeE")
  //</editor-fold>
  public int getFPOpCost(Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return the expected cost of materializing for the given integer
  /// immediate of the specified type.
  
  /// \brief Return the expected cost of materializing for the given integer
  /// immediate of the specified type.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getIntImmCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 220,
   FQN="llvm::TargetTransformInfo::getIntImmCost", NM="_ZNK4llvm19TargetTransformInfo13getIntImmCostERKNS_5APIntEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo13getIntImmCostERKNS_5APIntEPNS_4TypeE")
  //</editor-fold>
  public int getIntImmCost(final /*const*/ APInt /*&*/ Imm, Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Return the expected cost of materialization for the given integer
  /// immediate of the specified type for a given instruction. The cost can be
  /// zero if the immediate can be folded into the specified instruction.
  
  /// \brief Return the expected cost of materialization for the given integer
  /// immediate of the specified type for a given instruction. The cost can be
  /// zero if the immediate can be folded into the specified instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getIntImmCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 226,
   FQN="llvm::TargetTransformInfo::getIntImmCost", NM="_ZNK4llvm19TargetTransformInfo13getIntImmCostEjjRKNS_5APIntEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo13getIntImmCostEjjRKNS_5APIntEPNS_4TypeE")
  //</editor-fold>
  public int getIntImmCost(/*uint*/int Opcode, /*uint*/int Idx, 
               final /*const*/ APInt /*&*/ Imm, Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getIntImmCost">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 233,
//   FQN="llvm::TargetTransformInfo::getIntImmCost", NM="_ZNK4llvm19TargetTransformInfo13getIntImmCostENS_9Intrinsic2IDEjRKNS_5APIntEPNS_4TypeE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo13getIntImmCostENS_9Intrinsic2IDEjRKNS_5APIntEPNS_4TypeE")
//  //</editor-fold>
//  public int getIntImmCost(/*Intrinsic.ID*/int IID, /*uint*/int Idx, 
//               final /*const*/ APInt /*&*/ Imm, Type /*P*/ Ty) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }


  
  /// \brief Return the expected cost for the given integer when optimising
  /// for size. This is different than the other integer immediate cost
  /// functions in that it is subtarget agnostic. This is useful when you e.g.
  /// target one ISA such as Aarch32 but smaller encodings could be possible
  /// with another such as Thumb. This return value is used as a penalty when
  /// the total costs for a constant is calculated (the bigger the cost, the
  /// more beneficial constant hoisting is).
  
  /// \brief Return the expected cost for the given integer when optimising
  /// for size. This is different than the other integer immediate cost
  /// functions in that it is subtarget agnostic. This is useful when you e.g.
  /// target one ISA such as Aarch32 but smaller encodings could be possible
  /// with another such as Thumb. This return value is used as a penalty when
  /// the total costs for a constant is calculated (the bigger the cost, the
  /// more beneficial constant hoisting is).
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getIntImmCodeSizeCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 212,
   FQN="llvm::TargetTransformInfo::getIntImmCodeSizeCost", NM="_ZNK4llvm19TargetTransformInfo21getIntImmCodeSizeCostEjjRKNS_5APIntEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo21getIntImmCodeSizeCostEjjRKNS_5APIntEPNS_4TypeE")
  //</editor-fold>
  public int getIntImmCodeSizeCost(/*uint*/int Opcode, /*uint*/int Idx, 
                       final /*const*/ APInt /*&*/ Imm, 
                       Type /*P*/ Ty) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// @}
  
  /// \name Vector Target Information
  /// @{
  
  /// \brief The various kinds of shuffle patterns for vector queries.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::ShuffleKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 433,
   FQN="llvm::TargetTransformInfo::ShuffleKind", NM="_ZN4llvm19TargetTransformInfo11ShuffleKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo11ShuffleKindE")
  //</editor-fold>
  public enum ShuffleKind implements Native.NativeUIntEnum {
    SK_Broadcast(0), ///< Broadcast element 0 to all other elements.
    SK_Reverse(SK_Broadcast.getValue() + 1), ///< Reverse the order of the vector.
    SK_Alternate(SK_Reverse.getValue() + 1), ///< Choose alternate elements from vector.
    SK_InsertSubvector(SK_Alternate.getValue() + 1), ///< InsertSubvector. Index indicates start offset.
    SK_ExtractSubvector(SK_InsertSubvector.getValue() + 1); ///< ExtractSubvector Index indicates start offset.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ShuffleKind valueOf(int val) {
      ShuffleKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ShuffleKind[] VALUES;
      private static final ShuffleKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ShuffleKind kind : ShuffleKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ShuffleKind[min < 0 ? (1-min) : 0];
        VALUES = new ShuffleKind[max >= 0 ? (1+max) : 0];
        for (ShuffleKind kind : ShuffleKind.values()) {
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
    private ShuffleKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Additional information about an operand's possible values.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::OperandValueKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 442,
   FQN="llvm::TargetTransformInfo::OperandValueKind", NM="_ZN4llvm19TargetTransformInfo16OperandValueKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo16OperandValueKindE")
  //</editor-fold>
  public enum OperandValueKind implements Native.NativeUIntEnum {
    OK_AnyValue(0), // Operand can have any value.
    OK_UniformValue(OK_AnyValue.getValue() + 1), // Operand is uniform (splat of a value).
    OK_UniformConstantValue(OK_UniformValue.getValue() + 1), // Operand is uniform constant.
    OK_NonUniformConstantValue(OK_UniformConstantValue.getValue() + 1); // Operand is a non uniform constant value.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OperandValueKind valueOf(int val) {
      OperandValueKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OperandValueKind[] VALUES;
      private static final OperandValueKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OperandValueKind kind : OperandValueKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OperandValueKind[min < 0 ? (1-min) : 0];
        VALUES = new OperandValueKind[max >= 0 ? (1+max) : 0];
        for (OperandValueKind kind : OperandValueKind.values()) {
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
    private OperandValueKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \brief Additional properties of an operand's values.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::OperandValueProperties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 450,
   FQN="llvm::TargetTransformInfo::OperandValueProperties", NM="_ZN4llvm19TargetTransformInfo22OperandValuePropertiesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo22OperandValuePropertiesE")
  //</editor-fold>
  public enum OperandValueProperties implements Native.NativeUIntEnum {
    OP_None(0),
    OP_PowerOf2(1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OperandValueProperties valueOf(int val) {
      OperandValueProperties out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OperandValueProperties[] VALUES;
      private static final OperandValueProperties[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OperandValueProperties kind : OperandValueProperties.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OperandValueProperties[min < 0 ? (1-min) : 0];
        VALUES = new OperandValueProperties[max >= 0 ? (1+max) : 0];
        for (OperandValueProperties kind : OperandValueProperties.values()) {
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
    private OperandValueProperties(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// \return The number of scalar or vector registers that the target has.
  /// If 'Vectors' is true, it returns the number of vector registers. If it is
  /// set to false, it returns the number of scalar registers.
  
  /// \return The number of scalar or vector registers that the target has.
  /// If 'Vectors' is true, it returns the number of vector registers. If it is
  /// set to false, it returns the number of scalar registers.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getNumberOfRegisters">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 240,
   FQN="llvm::TargetTransformInfo::getNumberOfRegisters", NM="_ZNK4llvm19TargetTransformInfo20getNumberOfRegistersEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo20getNumberOfRegistersEb")
  //</editor-fold>
  public /*uint*/int getNumberOfRegisters(boolean Vector) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The width of the largest scalar or vector register type.
  
  /// \return The width of the largest scalar or vector register type.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getRegisterBitWidth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 244,
   FQN="llvm::TargetTransformInfo::getRegisterBitWidth", NM="_ZNK4llvm19TargetTransformInfo19getRegisterBitWidthEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo19getRegisterBitWidthEb")
  //</editor-fold>
  public /*uint*/int getRegisterBitWidth(boolean Vector) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The bitwidth of the largest vector type that should be used to
  /// load/store in the given address space.
  
  /// \return The bitwidth of the largest vector type that should be used to
  /// load/store in the given address space.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getLoadStoreVecRegBitWidth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 248,
   FQN="llvm::TargetTransformInfo::getLoadStoreVecRegBitWidth", NM="_ZNK4llvm19TargetTransformInfo26getLoadStoreVecRegBitWidthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo26getLoadStoreVecRegBitWidthEj")
  //</editor-fold>
  public /*uint*/int getLoadStoreVecRegBitWidth(/*uint*/int AS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The size of a cache line in bytes.
  
  /// \return The size of a cache line in bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCacheLineSize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 252,
   FQN="llvm::TargetTransformInfo::getCacheLineSize", NM="_ZNK4llvm19TargetTransformInfo16getCacheLineSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo16getCacheLineSizeEv")
  //</editor-fold>
  public /*uint*/int getCacheLineSize() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return How much before a load we should place the prefetch instruction.
  /// This is currently measured in number of instructions.
  
  /// \return How much before a load we should place the prefetch instruction.
  /// This is currently measured in number of instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getPrefetchDistance">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 256,
   FQN="llvm::TargetTransformInfo::getPrefetchDistance", NM="_ZNK4llvm19TargetTransformInfo19getPrefetchDistanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo19getPrefetchDistanceEv")
  //</editor-fold>
  public /*uint*/int getPrefetchDistance() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return Some HW prefetchers can handle accesses up to a certain constant
  /// stride.  This is the minimum stride in bytes where it makes sense to start
  /// adding SW prefetches.  The default is 1, i.e. prefetch with any stride.
  
  /// \return Some HW prefetchers can handle accesses up to a certain constant
  /// stride.  This is the minimum stride in bytes where it makes sense to start
  /// adding SW prefetches.  The default is 1, i.e. prefetch with any stride.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getMinPrefetchStride">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 260,
   FQN="llvm::TargetTransformInfo::getMinPrefetchStride", NM="_ZNK4llvm19TargetTransformInfo20getMinPrefetchStrideEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo20getMinPrefetchStrideEv")
  //</editor-fold>
  public /*uint*/int getMinPrefetchStride() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The maximum number of iterations to prefetch ahead.  If the
  /// required number of iterations is more than this number, no prefetching is
  /// performed.
  
  /// \return The maximum number of iterations to prefetch ahead.  If the
  /// required number of iterations is more than this number, no prefetching is
  /// performed.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getMaxPrefetchIterationsAhead">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 264,
   FQN="llvm::TargetTransformInfo::getMaxPrefetchIterationsAhead", NM="_ZNK4llvm19TargetTransformInfo29getMaxPrefetchIterationsAheadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo29getMaxPrefetchIterationsAheadEv")
  //</editor-fold>
  public /*uint*/int getMaxPrefetchIterationsAhead() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The maximum interleave factor that any transform should try to
  /// perform for this target. This number depends on the level of parallelism
  /// and the number of execution units in the CPU.
  
  /// \return The maximum interleave factor that any transform should try to
  /// perform for this target. This number depends on the level of parallelism
  /// and the number of execution units in the CPU.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getMaxInterleaveFactor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 268,
   FQN="llvm::TargetTransformInfo::getMaxInterleaveFactor", NM="_ZNK4llvm19TargetTransformInfo22getMaxInterleaveFactorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo22getMaxInterleaveFactorEj")
  //</editor-fold>
  public /*uint*/int getMaxInterleaveFactor(/*uint*/int VF) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The expected cost of arithmetic ops, such as mul, xor, fsub, etc.
  
  /// \return The expected cost of arithmetic ops, such as mul, xor, fsub, etc.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getArithmeticInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 272,
   FQN="llvm::TargetTransformInfo::getArithmeticInstrCost", NM="_ZNK4llvm19TargetTransformInfo22getArithmeticInstrCostEjPNS_4TypeENS0_16OperandValueKindES3_NS0_22OperandValuePropertiesES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo22getArithmeticInstrCostEjPNS_4TypeENS0_16OperandValueKindES3_NS0_22OperandValuePropertiesES4_")
  //</editor-fold>
  public int getArithmeticInstrCost(/*uint*/int Opcode, Type /*P*/ Ty) /*const*/ {
    return getArithmeticInstrCost(Opcode, Ty, OperandValueKind.OK_AnyValue, 
                        OperandValueKind.OK_AnyValue, OperandValueProperties.OP_None, 
                        OperandValueProperties.OP_None);
  }
  public int getArithmeticInstrCost(/*uint*/int Opcode, Type /*P*/ Ty, OperandValueKind Opd1Info/*= OK_AnyValue*/) /*const*/ {
    return getArithmeticInstrCost(Opcode, Ty, Opd1Info, 
                        OperandValueKind.OK_AnyValue, OperandValueProperties.OP_None, 
                        OperandValueProperties.OP_None);
  }
  public int getArithmeticInstrCost(/*uint*/int Opcode, Type /*P*/ Ty, OperandValueKind Opd1Info/*= OK_AnyValue*/, 
                        OperandValueKind Opd2Info/*= OK_AnyValue*/) /*const*/ {
    return getArithmeticInstrCost(Opcode, Ty, Opd1Info, 
                        Opd2Info, OperandValueProperties.OP_None, 
                        OperandValueProperties.OP_None);
  }
  public int getArithmeticInstrCost(/*uint*/int Opcode, Type /*P*/ Ty, OperandValueKind Opd1Info/*= OK_AnyValue*/, 
                        OperandValueKind Opd2Info/*= OK_AnyValue*/, OperandValueProperties Opd1PropInfo/*= OP_None*/) /*const*/ {
    return getArithmeticInstrCost(Opcode, Ty, Opd1Info, 
                        Opd2Info, Opd1PropInfo, 
                        OperandValueProperties.OP_None);
  }
  public int getArithmeticInstrCost(/*uint*/int Opcode, Type /*P*/ Ty, OperandValueKind Opd1Info/*= OK_AnyValue*/, 
                        OperandValueKind Opd2Info/*= OK_AnyValue*/, OperandValueProperties Opd1PropInfo/*= OP_None*/, 
                        OperandValueProperties Opd2PropInfo/*= OP_None*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The cost of a shuffle instruction of kind Kind and of type Tp.
  /// The index and subtype parameters are used by the subvector insertion and
  /// extraction shuffle kinds.
  
  /// \return The cost of a shuffle instruction of kind Kind and of type Tp.
  /// The index and subtype parameters are used by the subvector insertion and
  /// extraction shuffle kinds.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getShuffleCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 282,
   FQN="llvm::TargetTransformInfo::getShuffleCost", NM="_ZNK4llvm19TargetTransformInfo14getShuffleCostENS0_11ShuffleKindEPNS_4TypeEiS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo14getShuffleCostENS0_11ShuffleKindEPNS_4TypeEiS3_")
  //</editor-fold>
  public int getShuffleCost(ShuffleKind Kind, Type /*P*/ Ty) /*const*/ {
    return getShuffleCost(Kind, Ty, 0, 
                (Type /*P*/ )null);
  }
  public int getShuffleCost(ShuffleKind Kind, Type /*P*/ Ty, int Index/*= 0*/) /*const*/ {
    return getShuffleCost(Kind, Ty, Index, 
                (Type /*P*/ )null);
  }
  public int getShuffleCost(ShuffleKind Kind, Type /*P*/ Ty, int Index/*= 0*/, 
                Type /*P*/ SubTp/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The expected cost of cast instructions, such as bitcast, trunc,
  /// zext, etc.
  
  /// \return The expected cost of cast instructions, such as bitcast, trunc,
  /// zext, etc.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCastInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 289,
   FQN="llvm::TargetTransformInfo::getCastInstrCost", NM="_ZNK4llvm19TargetTransformInfo16getCastInstrCostEjPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo16getCastInstrCostEjPNS_4TypeES2_")
  //</editor-fold>
  public int getCastInstrCost(/*uint*/int Opcode, Type /*P*/ Dst, 
                  Type /*P*/ Src) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The expected cost of a sign- or zero-extended vector extract. Use
  /// -1 to indicate that there is no information about the index value.
  
  /// \return The expected cost of a sign- or zero-extended vector extract. Use
  /// -1 to indicate that there is no information about the index value.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getExtractWithExtendCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 296,
   FQN="llvm::TargetTransformInfo::getExtractWithExtendCost", NM="_ZNK4llvm19TargetTransformInfo24getExtractWithExtendCostEjPNS_4TypeEPNS_10VectorTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo24getExtractWithExtendCostEjPNS_4TypeEPNS_10VectorTypeEj")
  //</editor-fold>
  public int getExtractWithExtendCost(/*uint*/int Opcode, Type /*P*/ Dst, 
                          VectorType /*P*/ VecTy) /*const*/ {
    return getExtractWithExtendCost(Opcode, Dst, 
                          VecTy, 
                          -1);
  }
  public int getExtractWithExtendCost(/*uint*/int Opcode, Type /*P*/ Dst, 
                          VectorType /*P*/ VecTy, 
                          /*uint*/int Index/*= -1*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The expected cost of control-flow related instructions such as
  /// Phi, Ret, Br.
  
  /// \return The expected cost of control-flow related instructions such as
  /// Phi, Ret, Br.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCFInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 304,
   FQN="llvm::TargetTransformInfo::getCFInstrCost", NM="_ZNK4llvm19TargetTransformInfo14getCFInstrCostEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo14getCFInstrCostEj")
  //</editor-fold>
  public int getCFInstrCost(/*uint*/int Opcode) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns The expected cost of compare and select instructions.
  
  /// \returns The expected cost of compare and select instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCmpSelInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 310,
   FQN="llvm::TargetTransformInfo::getCmpSelInstrCost", NM="_ZNK4llvm19TargetTransformInfo18getCmpSelInstrCostEjPNS_4TypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo18getCmpSelInstrCostEjPNS_4TypeES2_")
  //</editor-fold>
  public int getCmpSelInstrCost(/*uint*/int Opcode, Type /*P*/ ValTy) /*const*/ {
    return getCmpSelInstrCost(Opcode, ValTy, 
                    (Type /*P*/ )null);
  }
  public int getCmpSelInstrCost(/*uint*/int Opcode, Type /*P*/ ValTy, 
                    Type /*P*/ CondTy/*= null*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The expected cost of vector Insert and Extract.
  /// Use -1 to indicate that there is no information on the index value.
  
  /// \return The expected cost of vector Insert and Extract.
  /// Use -1 to indicate that there is no information on the index value.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getVectorInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 317,
   FQN="llvm::TargetTransformInfo::getVectorInstrCost", NM="_ZNK4llvm19TargetTransformInfo18getVectorInstrCostEjPNS_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo18getVectorInstrCostEjPNS_4TypeEj")
  //</editor-fold>
  public int getVectorInstrCost(/*uint*/int Opcode, Type /*P*/ Val) /*const*/ {
    return getVectorInstrCost(Opcode, Val, 
                    -1);
  }
  public int getVectorInstrCost(/*uint*/int Opcode, Type /*P*/ Val, 
                    /*uint*/int Index/*= -1*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The cost of Load and Store instructions.
  
  /// \return The cost of Load and Store instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getMemoryOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 324,
   FQN="llvm::TargetTransformInfo::getMemoryOpCost", NM="_ZNK4llvm19TargetTransformInfo15getMemoryOpCostEjPNS_4TypeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo15getMemoryOpCostEjPNS_4TypeEjj")
  //</editor-fold>
  public int getMemoryOpCost(/*uint*/int Opcode, Type /*P*/ Src, 
                 /*uint*/int Alignment, 
                 /*uint*/int AddressSpace) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The cost of masked Load and Store instructions.
  
  /// \return The cost of masked Load and Store instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getMaskedMemoryOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 332,
   FQN="llvm::TargetTransformInfo::getMaskedMemoryOpCost", NM="_ZNK4llvm19TargetTransformInfo21getMaskedMemoryOpCostEjPNS_4TypeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo21getMaskedMemoryOpCostEjPNS_4TypeEjj")
  //</editor-fold>
  public int getMaskedMemoryOpCost(/*uint*/int Opcode, Type /*P*/ Src, 
                       /*uint*/int Alignment, 
                       /*uint*/int AddressSpace) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The cost of Gather or Scatter operation
  /// \p Opcode - is a type of memory access Load or Store
  /// \p DataTy - a vector type of the data to be loaded or stored
  /// \p Ptr - pointer [or vector of pointers] - address[es] in memory
  /// \p VariableMask - true when the memory access is predicated with a mask
  ///                   that is not a compile-time constant
  /// \p Alignment - alignment of single element
  
  /// \return The cost of Gather or Scatter operation
  /// \p Opcode - is a type of memory access Load or Store
  /// \p DataTy - a vector type of the data to be loaded or stored
  /// \p Ptr - pointer [or vector of pointers] - address[es] in memory
  /// \p VariableMask - true when the memory access is predicated with a mask
  ///                   that is not a compile-time constant
  /// \p Alignment - alignment of single element
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getGatherScatterOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 341,
   FQN="llvm::TargetTransformInfo::getGatherScatterOpCost", NM="_ZNK4llvm19TargetTransformInfo22getGatherScatterOpCostEjPNS_4TypeEPNS_5ValueEbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo22getGatherScatterOpCostEjPNS_4TypeEPNS_5ValueEbj")
  //</editor-fold>
  public int getGatherScatterOpCost(/*uint*/int Opcode, Type /*P*/ DataTy, 
                        Value /*P*/ Ptr, boolean VariableMask, 
                        /*uint*/int Alignment) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \return The cost of the interleaved memory operation.
  /// \p Opcode is the memory operation code
  /// \p VecTy is the vector type of the interleaved access.
  /// \p Factor is the interleave factor
  /// \p Indices is the indices for interleaved load members (as interleaved
  ///    load allows gaps)
  /// \p Alignment is the alignment of the memory operation
  /// \p AddressSpace is address space of the pointer.
  
  /// \return The cost of the interleaved memory operation.
  /// \p Opcode is the memory operation code
  /// \p VecTy is the vector type of the interleaved access.
  /// \p Factor is the interleave factor
  /// \p Indices is the indices for interleaved load members (as interleaved
  ///    load allows gaps)
  /// \p Alignment is the alignment of the memory operation
  /// \p AddressSpace is address space of the pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getInterleavedMemoryOpCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 350,
   FQN="llvm::TargetTransformInfo::getInterleavedMemoryOpCost", NM="_ZNK4llvm19TargetTransformInfo26getInterleavedMemoryOpCostEjPNS_4TypeEjNS_8ArrayRefIjEEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo26getInterleavedMemoryOpCostEjPNS_4TypeEjNS_8ArrayRefIjEEjj")
  //</editor-fold>
  public int getInterleavedMemoryOpCost(/*uint*/int Opcode, Type /*P*/ VecTy, /*uint*/int Factor, ArrayRefUInt Indices, 
                            /*uint*/int Alignment, /*uint*/int AddressSpace) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Calculate the cost of performing a vector reduction.
  ///
  /// This is the cost of reducing the vector value of type \p Ty to a scalar
  /// value using the operation denoted by \p Opcode. The form of the reduction
  /// can either be a pairwise reduction or a reduction that splits the vector
  /// at every reduction level.
  ///
  /// Pairwise:
  ///  (v0, v1, v2, v3)
  ///  ((v0+v1), (v2, v3), undef, undef)
  /// Split:
  ///  (v0, v1, v2, v3)
  ///  ((v0+v2), (v1+v3), undef, undef)
  
  /// \brief Calculate the cost of performing a vector reduction.
  ///
  /// This is the cost of reducing the vector value of type \p Ty to a scalar
  /// value using the operation denoted by \p Opcode. The form of the reduction
  /// can either be a pairwise reduction or a reduction that splits the vector
  /// at every reduction level.
  ///
  /// Pairwise:
  ///  (v0, v1, v2, v3)
  ///  ((v0+v1), (v2, v3), undef, undef)
  /// Split:
  ///  (v0, v1, v2, v3)
  ///  ((v0+v2), (v1+v3), undef, undef)
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getReductionCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 393,
   FQN="llvm::TargetTransformInfo::getReductionCost", NM="_ZNK4llvm19TargetTransformInfo16getReductionCostEjPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo16getReductionCostEjPNS_4TypeEb")
  //</editor-fold>
  public int getReductionCost(/*uint*/int Opcode, Type /*P*/ Ty, 
                  boolean IsPairwiseForm) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns The cost of Intrinsic instructions. Types analysis only.
  
  /// \returns The cost of Intrinsic instructions. Types analysis only.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getIntrinsicInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 359,
   FQN="llvm::TargetTransformInfo::getIntrinsicInstrCost", NM="_ZNK4llvm19TargetTransformInfo21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS4_EENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS4_EENS_13FastMathFlagsE")
  //</editor-fold>
  public int getIntrinsicInstrCost_ID_Type$P_ArrayRef$Type$P_FastMathFlags(/*Intrinsic.ID*/int ID, Type /*P*/ RetTy, 
                                                               ArrayRef<Type /*P*/ > Tys, 
                                                               FastMathFlags FMF) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns The cost of Intrinsic instructions. Analyses the real arguments.
  
  /// \returns The cost of Intrinsic instructions. Analyses the real arguments.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getIntrinsicInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 367,
   FQN="llvm::TargetTransformInfo::getIntrinsicInstrCost", NM="_ZNK4llvm19TargetTransformInfo21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEENS_13FastMathFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEENS_13FastMathFlagsE")
  //</editor-fold>
  public int getIntrinsicInstrCost_ID_Type$P_ArrayRef$Value$P_FastMathFlags(/*Intrinsic.ID*/int ID, Type /*P*/ RetTy, 
                                                                ArrayRef<Value /*P*/ > Args, 
                                                                FastMathFlags FMF) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns The cost of Call instructions.
  
  /// \returns The cost of Call instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCallInstrCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 375,
   FQN="llvm::TargetTransformInfo::getCallInstrCost", NM="_ZNK4llvm19TargetTransformInfo16getCallInstrCostEPNS_8FunctionEPNS_4TypeENS_8ArrayRefIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo16getCallInstrCostEPNS_8FunctionEPNS_4TypeENS_8ArrayRefIS4_EE")
  //</editor-fold>
  public int getCallInstrCost(Function /*P*/ F, Type /*P*/ RetTy, 
                  ArrayRef<Type /*P*/ > Tys) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns The number of pieces into which the provided type must be
  /// split during legalization. Zero is returned when the answer is unknown.
  
  /// \returns The number of pieces into which the provided type must be
  /// split during legalization. Zero is returned when the answer is unknown.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getNumberOfParts">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 382,
   FQN="llvm::TargetTransformInfo::getNumberOfParts", NM="_ZNK4llvm19TargetTransformInfo16getNumberOfPartsEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo16getNumberOfPartsEPNS_4TypeE")
  //</editor-fold>
  public /*uint*/int getNumberOfParts(Type /*P*/ Tp) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns The cost of the address computation. For most targets this can be
  /// merged into the instruction indexing mode. Some targets might want to
  /// distinguish between address computation for memory operations on vector
  /// types and scalar types. Such targets should override this function.
  /// The 'IsComplex' parameter is a hint that the address computation is likely
  /// to involve multiple instructions and as such unlikely to be merged into
  /// the address indexing mode.
  
  /// \returns The cost of the address computation. For most targets this can be
  /// merged into the instruction indexing mode. Some targets might want to
  /// distinguish between address computation for memory operations on vector
  /// types and scalar types. Such targets should override this function.
  /// The 'IsComplex' parameter is a hint that the address computation is likely
  /// to involve multiple instructions and as such unlikely to be merged into
  /// the address indexing mode.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getAddressComputationCost">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 386,
   FQN="llvm::TargetTransformInfo::getAddressComputationCost", NM="_ZNK4llvm19TargetTransformInfo25getAddressComputationCostEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo25getAddressComputationCostEPNS_4TypeEb")
  //</editor-fold>
  public int getAddressComputationCost(Type /*P*/ Tp) /*const*/ {
    return getAddressComputationCost(Tp, 
                           false);
  }
  public int getAddressComputationCost(Type /*P*/ Tp, 
                           boolean IsComplex/*= false*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns The cost, if any, of keeping values of the given types alive
  /// over a callsite.
  ///
  /// Some types may require the use of register classes that do not have
  /// any callee-saved registers, so would require a spill and fill.
  
  /// \returns The cost, if any, of keeping values of the given types alive
  /// over a callsite.
  ///
  /// Some types may require the use of register classes that do not have
  /// any callee-saved registers, so would require a spill and fill.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getCostOfKeepingLiveOverCall">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 400,
   FQN="llvm::TargetTransformInfo::getCostOfKeepingLiveOverCall", NM="_ZNK4llvm19TargetTransformInfo28getCostOfKeepingLiveOverCallENS_8ArrayRefIPNS_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo28getCostOfKeepingLiveOverCallENS_8ArrayRefIPNS_4TypeEEE")
  //</editor-fold>
  public /*uint*/int getCostOfKeepingLiveOverCall(ArrayRef<Type /*P*/ > Tys) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns True if the intrinsic is a supported memory intrinsic.  Info
  /// will contain additional information - whether the intrinsic may write
  /// or read to memory, volatility and the pointer.  Info is undefined
  /// if false is returned.
  
  /// \returns True if the intrinsic is a supported memory intrinsic.  Info
  /// will contain additional information - whether the intrinsic may write
  /// or read to memory, volatility and the pointer.  Info is undefined
  /// if false is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getTgtMemIntrinsic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 405,
   FQN="llvm::TargetTransformInfo::getTgtMemIntrinsic", NM="_ZNK4llvm19TargetTransformInfo18getTgtMemIntrinsicEPNS_13IntrinsicInstERNS_16MemIntrinsicInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo18getTgtMemIntrinsicEPNS_13IntrinsicInstERNS_16MemIntrinsicInfoE")
  //</editor-fold>
  public boolean getTgtMemIntrinsic(IntrinsicInst /*P*/ Inst, 
                    final MemIntrinsicInfo /*&*/ Info) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns A value which is the result of the given memory intrinsic.  New
  /// instructions may be created to extract the result from the given intrinsic
  /// memory operation.  Returns nullptr if the target cannot create a result
  /// from the given intrinsic.
  
  /// \returns A value which is the result of the given memory intrinsic.  New
  /// instructions may be created to extract the result from the given intrinsic
  /// memory operation.  Returns nullptr if the target cannot create a result
  /// from the given intrinsic.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::getOrCreateResultFromMemIntrinsic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 410,
   FQN="llvm::TargetTransformInfo::getOrCreateResultFromMemIntrinsic", NM="_ZNK4llvm19TargetTransformInfo33getOrCreateResultFromMemIntrinsicEPNS_13IntrinsicInstEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo33getOrCreateResultFromMemIntrinsicEPNS_13IntrinsicInstEPNS_4TypeE")
  //</editor-fold>
  public Value /*P*/ getOrCreateResultFromMemIntrinsic(IntrinsicInst /*P*/ Inst, Type /*P*/ ExpectedType) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \returns True if the two functions have compatible attributes for inlining
  /// purposes.
  
  /// \returns True if the two functions have compatible attributes for inlining
  /// purposes.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::areInlineCompatible">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 415,
   FQN="llvm::TargetTransformInfo::areInlineCompatible", NM="_ZNK4llvm19TargetTransformInfo19areInlineCompatibleEPKNS_8FunctionES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZNK4llvm19TargetTransformInfo19areInlineCompatibleEPKNS_8FunctionES3_")
  //</editor-fold>
  public boolean areInlineCompatible(/*const*/ Function /*P*/ Caller, 
                     /*const*/ Function /*P*/ Callee) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }



  /// @}
  /*private:*/
  /// \brief The abstract base class used to type erase specific TTI
  /// implementations.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 628,
   FQN="llvm::TargetTransformInfo::Concept", NM="_ZN4llvm19TargetTransformInfo7ConceptE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7ConceptE")
  //</editor-fold>
  private abstract static class Concept implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::~Concept">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 630,
     FQN="llvm::TargetTransformInfo::Concept::~Concept", NM="_ZN4llvm19TargetTransformInfo7ConceptD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7ConceptD0Ev")
    //</editor-fold>
    public abstract /*virtual*/ void $destroy()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getDataLayout">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 631,
     FQN="llvm::TargetTransformInfo::Concept::getDataLayout", NM="_ZNK4llvm19TargetTransformInfo7Concept13getDataLayoutEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZNK4llvm19TargetTransformInfo7Concept13getDataLayoutEv")
    //</editor-fold>
    public abstract /*virtual*/ /*const*/ DataLayout /*&*/ getDataLayout() /*const*//* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getOperationCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 632,
     FQN="llvm::TargetTransformInfo::Concept::getOperationCost", NM="_ZN4llvm19TargetTransformInfo7Concept16getOperationCostEjPNS_4TypeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getOperationCostEjPNS_4TypeES3_")
    //</editor-fold>
    public abstract /*virtual*/ int getOperationCost(/*uint*/int Opcode, Type /*P*/ Ty, Type /*P*/ OpTy)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getGEPCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 633,
     FQN="llvm::TargetTransformInfo::Concept::getGEPCost", NM="_ZN4llvm19TargetTransformInfo7Concept10getGEPCostEPNS_4TypeEPKNS_5ValueENS_8ArrayRefIS6_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept10getGEPCostEPNS_4TypeEPKNS_5ValueENS_8ArrayRefIS6_EE")
    //</editor-fold>
    public abstract /*virtual*/ int getGEPCost(Type /*P*/ PointeeType, /*const*/ Value /*P*/ Ptr, 
              ArrayRef</*const*/ Value /*P*/ > Operands)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCallCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 635,
     FQN="llvm::TargetTransformInfo::Concept::getCallCost", NM="_ZN4llvm19TargetTransformInfo7Concept11getCallCostEPNS_12FunctionTypeEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept11getCallCostEPNS_12FunctionTypeEi")
    //</editor-fold>
    public abstract /*virtual*/ int getCallCost(FunctionType /*P*/ FTy, int NumArgs)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCallCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 636,
     FQN="llvm::TargetTransformInfo::Concept::getCallCost", NM="_ZN4llvm19TargetTransformInfo7Concept11getCallCostEPKNS_8FunctionEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept11getCallCostEPKNS_8FunctionEi")
    //</editor-fold>
    public abstract /*virtual*/ int getCallCost(/*const*/ Function /*P*/ F, int NumArgs)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCallCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 637,
     FQN="llvm::TargetTransformInfo::Concept::getCallCost", NM="_ZN4llvm19TargetTransformInfo7Concept11getCallCostEPKNS_8FunctionENS_8ArrayRefIPKNS_5ValueEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept11getCallCostEPKNS_8FunctionENS_8ArrayRefIPKNS_5ValueEEE")
    //</editor-fold>
    public abstract /*virtual*/ int getCallCost(/*const*/ Function /*P*/ F, 
               ArrayRef</*const*/ Value /*P*/ > Arguments)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getInliningThresholdMultiplier">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 639,
     FQN="llvm::TargetTransformInfo::Concept::getInliningThresholdMultiplier", NM="_ZN4llvm19TargetTransformInfo7Concept30getInliningThresholdMultiplierEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept30getInliningThresholdMultiplierEv")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getInliningThresholdMultiplier()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getIntrinsicCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 640,
     FQN="llvm::TargetTransformInfo::Concept::getIntrinsicCost", NM="_ZN4llvm19TargetTransformInfo7Concept16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS5_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS5_EE")
    //</editor-fold>
    public abstract /*virtual*/ int getIntrinsicCost_ID_Type$P_ArrayRef$Type$P(/*Intrinsic.ID*/int IID, Type /*P*/ RetTy, 
                                              ArrayRef<Type /*P*/ > ParamTys)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getIntrinsicCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 642,
     FQN="llvm::TargetTransformInfo::Concept::getIntrinsicCost", NM="_ZN4llvm19TargetTransformInfo7Concept16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPKNS_5ValueEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getIntrinsicCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPKNS_5ValueEEE")
    //</editor-fold>
    public abstract /*virtual*/ int getIntrinsicCost_ID_Type$P_ArrayRef$Value$C$P(/*Intrinsic.ID*/int IID, Type /*P*/ RetTy, 
                                                 ArrayRef</*const*/ Value /*P*/ > Arguments)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getUserCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 644,
     FQN="llvm::TargetTransformInfo::Concept::getUserCost", NM="_ZN4llvm19TargetTransformInfo7Concept11getUserCostEPKNS_4UserE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept11getUserCostEPKNS_4UserE")
    //</editor-fold>
    public abstract /*virtual*/ int getUserCost(/*const*/ User /*P*/ U)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::hasBranchDivergence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 645,
     FQN="llvm::TargetTransformInfo::Concept::hasBranchDivergence", NM="_ZN4llvm19TargetTransformInfo7Concept19hasBranchDivergenceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept19hasBranchDivergenceEv")
    //</editor-fold>
    public abstract /*virtual*/ boolean hasBranchDivergence()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isSourceOfDivergence">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 646,
     FQN="llvm::TargetTransformInfo::Concept::isSourceOfDivergence", NM="_ZN4llvm19TargetTransformInfo7Concept20isSourceOfDivergenceEPKNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept20isSourceOfDivergenceEPKNS_5ValueE")
    //</editor-fold>
    public abstract /*virtual*/ boolean isSourceOfDivergence(/*const*/ Value /*P*/ V)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isLoweredToCall">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 647,
     FQN="llvm::TargetTransformInfo::Concept::isLoweredToCall", NM="_ZN4llvm19TargetTransformInfo7Concept15isLoweredToCallEPKNS_8FunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept15isLoweredToCallEPKNS_8FunctionE")
    //</editor-fold>
    public abstract /*virtual*/ boolean isLoweredToCall(/*const*/ Function /*P*/ F)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getUnrollingPreferences">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 648,
     FQN="llvm::TargetTransformInfo::Concept::getUnrollingPreferences", NM="_ZN4llvm19TargetTransformInfo7Concept23getUnrollingPreferencesEPNS_4LoopERNS0_20UnrollingPreferencesE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept23getUnrollingPreferencesEPNS_4LoopERNS0_20UnrollingPreferencesE")
    //</editor-fold>
    public abstract /*virtual*/ void getUnrollingPreferences(Loop /*P*/ L, final UnrollingPreferences /*&*/ UP)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isLegalAddImmediate">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 649,
     FQN="llvm::TargetTransformInfo::Concept::isLegalAddImmediate", NM="_ZN4llvm19TargetTransformInfo7Concept19isLegalAddImmediateEx",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept19isLegalAddImmediateEx")
    //</editor-fold>
    public abstract /*virtual*/ boolean isLegalAddImmediate(long/*int64_t*/ Imm)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isLegalICmpImmediate">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 650,
     FQN="llvm::TargetTransformInfo::Concept::isLegalICmpImmediate", NM="_ZN4llvm19TargetTransformInfo7Concept20isLegalICmpImmediateEx",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept20isLegalICmpImmediateEx")
    //</editor-fold>
    public abstract /*virtual*/ boolean isLegalICmpImmediate(long/*int64_t*/ Imm)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isLegalAddressingMode">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 651,
     FQN="llvm::TargetTransformInfo::Concept::isLegalAddressingMode", NM="_ZN4llvm19TargetTransformInfo7Concept21isLegalAddressingModeEPNS_4TypeEPNS_11GlobalValueExbxj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept21isLegalAddressingModeEPNS_4TypeEPNS_11GlobalValueExbxj")
    //</editor-fold>
    public abstract /*virtual*/ boolean isLegalAddressingMode(Type /*P*/ Ty, GlobalValue /*P*/ BaseGV, 
                         long/*int64_t*/ BaseOffset, boolean HasBaseReg, 
                         long/*int64_t*/ Scale, 
                         /*uint*/int AddrSpace)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isLegalMaskedStore">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 655,
     FQN="llvm::TargetTransformInfo::Concept::isLegalMaskedStore", NM="_ZN4llvm19TargetTransformInfo7Concept18isLegalMaskedStoreEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept18isLegalMaskedStoreEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ boolean isLegalMaskedStore(Type /*P*/ DataType)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isLegalMaskedLoad">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 656,
     FQN="llvm::TargetTransformInfo::Concept::isLegalMaskedLoad", NM="_ZN4llvm19TargetTransformInfo7Concept17isLegalMaskedLoadEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept17isLegalMaskedLoadEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ boolean isLegalMaskedLoad(Type /*P*/ DataType)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isLegalMaskedScatter">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 657,
     FQN="llvm::TargetTransformInfo::Concept::isLegalMaskedScatter", NM="_ZN4llvm19TargetTransformInfo7Concept20isLegalMaskedScatterEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept20isLegalMaskedScatterEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ boolean isLegalMaskedScatter(Type /*P*/ DataType)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isLegalMaskedGather">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 658,
     FQN="llvm::TargetTransformInfo::Concept::isLegalMaskedGather", NM="_ZN4llvm19TargetTransformInfo7Concept19isLegalMaskedGatherEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept19isLegalMaskedGatherEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ boolean isLegalMaskedGather(Type /*P*/ DataType)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getScalingFactorCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 659,
     FQN="llvm::TargetTransformInfo::Concept::getScalingFactorCost", NM="_ZN4llvm19TargetTransformInfo7Concept20getScalingFactorCostEPNS_4TypeEPNS_11GlobalValueExbxj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept20getScalingFactorCostEPNS_4TypeEPNS_11GlobalValueExbxj")
    //</editor-fold>
    public abstract /*virtual*/ int getScalingFactorCost(Type /*P*/ Ty, GlobalValue /*P*/ BaseGV, 
                        long/*int64_t*/ BaseOffset, boolean HasBaseReg, 
                        long/*int64_t*/ Scale, /*uint*/int AddrSpace)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isTruncateFree">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 662,
     FQN="llvm::TargetTransformInfo::Concept::isTruncateFree", NM="_ZN4llvm19TargetTransformInfo7Concept14isTruncateFreeEPNS_4TypeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept14isTruncateFreeEPNS_4TypeES3_")
    //</editor-fold>
    public abstract /*virtual*/ boolean isTruncateFree(Type /*P*/ Ty1, Type /*P*/ Ty2)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isProfitableToHoist">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 663,
     FQN="llvm::TargetTransformInfo::Concept::isProfitableToHoist", NM="_ZN4llvm19TargetTransformInfo7Concept19isProfitableToHoistEPNS_11InstructionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept19isProfitableToHoistEPNS_11InstructionE")
    //</editor-fold>
    public abstract /*virtual*/ boolean isProfitableToHoist(Instruction /*P*/ I)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isTypeLegal">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 664,
     FQN="llvm::TargetTransformInfo::Concept::isTypeLegal", NM="_ZN4llvm19TargetTransformInfo7Concept11isTypeLegalEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept11isTypeLegalEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ boolean isTypeLegal(Type /*P*/ Ty)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getJumpBufAlignment">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 665,
     FQN="llvm::TargetTransformInfo::Concept::getJumpBufAlignment", NM="_ZN4llvm19TargetTransformInfo7Concept19getJumpBufAlignmentEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept19getJumpBufAlignmentEv")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getJumpBufAlignment()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getJumpBufSize">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 666,
     FQN="llvm::TargetTransformInfo::Concept::getJumpBufSize", NM="_ZN4llvm19TargetTransformInfo7Concept14getJumpBufSizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept14getJumpBufSizeEv")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getJumpBufSize()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::shouldBuildLookupTables">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 667,
     FQN="llvm::TargetTransformInfo::Concept::shouldBuildLookupTables", NM="_ZN4llvm19TargetTransformInfo7Concept23shouldBuildLookupTablesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept23shouldBuildLookupTablesEv")
    //</editor-fold>
    public abstract /*virtual*/ boolean shouldBuildLookupTables()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::enableAggressiveInterleaving">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 668,
     FQN="llvm::TargetTransformInfo::Concept::enableAggressiveInterleaving", NM="_ZN4llvm19TargetTransformInfo7Concept28enableAggressiveInterleavingEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept28enableAggressiveInterleavingEb")
    //</editor-fold>
    public abstract /*virtual*/ boolean enableAggressiveInterleaving(boolean LoopHasReductions)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::enableInterleavedAccessVectorization">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 669,
     FQN="llvm::TargetTransformInfo::Concept::enableInterleavedAccessVectorization", NM="_ZN4llvm19TargetTransformInfo7Concept36enableInterleavedAccessVectorizationEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept36enableInterleavedAccessVectorizationEv")
    //</editor-fold>
    public abstract /*virtual*/ boolean enableInterleavedAccessVectorization()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::isFPVectorizationPotentiallyUnsafe">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 670,
     FQN="llvm::TargetTransformInfo::Concept::isFPVectorizationPotentiallyUnsafe", NM="_ZN4llvm19TargetTransformInfo7Concept34isFPVectorizationPotentiallyUnsafeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept34isFPVectorizationPotentiallyUnsafeEv")
    //</editor-fold>
    public abstract /*virtual*/ boolean isFPVectorizationPotentiallyUnsafe()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::allowsMisalignedMemoryAccesses">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 671,
     FQN="llvm::TargetTransformInfo::Concept::allowsMisalignedMemoryAccesses", NM="_ZN4llvm19TargetTransformInfo7Concept30allowsMisalignedMemoryAccessesEjjjPb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept30allowsMisalignedMemoryAccessesEjjjPb")
    //</editor-fold>
    public abstract /*virtual*/ boolean allowsMisalignedMemoryAccesses(/*uint*/int BitWidth, 
                                  /*uint*/int AddressSpace, 
                                  /*uint*/int Alignment, 
                                  bool$ptr/*bool P*/ Fast)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getPopcntSupport">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 675,
     FQN="llvm::TargetTransformInfo::Concept::getPopcntSupport", NM="_ZN4llvm19TargetTransformInfo7Concept16getPopcntSupportEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getPopcntSupportEj")
    //</editor-fold>
    public abstract /*virtual*/ PopcntSupportKind getPopcntSupport(/*uint*/int IntTyWidthInBit)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::haveFastSqrt">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 676,
     FQN="llvm::TargetTransformInfo::Concept::haveFastSqrt", NM="_ZN4llvm19TargetTransformInfo7Concept12haveFastSqrtEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept12haveFastSqrtEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ boolean haveFastSqrt(Type /*P*/ Ty)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getFPOpCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 677,
     FQN="llvm::TargetTransformInfo::Concept::getFPOpCost", NM="_ZN4llvm19TargetTransformInfo7Concept11getFPOpCostEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept11getFPOpCostEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ int getFPOpCost(Type /*P*/ Ty)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getIntImmCodeSizeCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 678,
     FQN="llvm::TargetTransformInfo::Concept::getIntImmCodeSizeCost", NM="_ZN4llvm19TargetTransformInfo7Concept21getIntImmCodeSizeCostEjjRKNS_5APIntEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept21getIntImmCodeSizeCostEjjRKNS_5APIntEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ int getIntImmCodeSizeCost(/*uint*/int Opc, /*uint*/int Idx, final /*const*/ APInt /*&*/ Imm, 
                         Type /*P*/ Ty)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getIntImmCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 680,
     FQN="llvm::TargetTransformInfo::Concept::getIntImmCost", NM="_ZN4llvm19TargetTransformInfo7Concept13getIntImmCostERKNS_5APIntEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept13getIntImmCostERKNS_5APIntEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ int getIntImmCost(final /*const*/ APInt /*&*/ Imm, Type /*P*/ Ty)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getIntImmCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 681,
     FQN="llvm::TargetTransformInfo::Concept::getIntImmCost", NM="_ZN4llvm19TargetTransformInfo7Concept13getIntImmCostEjjRKNS_5APIntEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept13getIntImmCostEjjRKNS_5APIntEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ int getIntImmCost(/*uint*/int Opc, /*uint*/int Idx, final /*const*/ APInt /*&*/ Imm, 
                 Type /*P*/ Ty)/* = 0*/;

//    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getIntImmCost">
//    @Converted(kind = Converted.Kind.DELETED,
//     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 683,
//     FQN="llvm::TargetTransformInfo::Concept::getIntImmCost", NM="_ZN4llvm19TargetTransformInfo7Concept13getIntImmCostENS_9Intrinsic2IDEjRKNS_5APIntEPNS_4TypeE",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept13getIntImmCostENS_9Intrinsic2IDEjRKNS_5APIntEPNS_4TypeE")
//    //</editor-fold>
//    public abstract /*virtual*/ int getIntImmCost(/*Intrinsic.ID*/int IID, /*uint*/int Idx, final /*const*/ APInt /*&*/ Imm, 
//                 Type /*P*/ Ty)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getNumberOfRegisters">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 685,
     FQN="llvm::TargetTransformInfo::Concept::getNumberOfRegisters", NM="_ZN4llvm19TargetTransformInfo7Concept20getNumberOfRegistersEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept20getNumberOfRegistersEb")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getNumberOfRegisters(boolean Vector)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getRegisterBitWidth">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 686,
     FQN="llvm::TargetTransformInfo::Concept::getRegisterBitWidth", NM="_ZN4llvm19TargetTransformInfo7Concept19getRegisterBitWidthEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept19getRegisterBitWidthEb")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getRegisterBitWidth(boolean Vector)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getLoadStoreVecRegBitWidth">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 687,
     FQN="llvm::TargetTransformInfo::Concept::getLoadStoreVecRegBitWidth", NM="_ZN4llvm19TargetTransformInfo7Concept26getLoadStoreVecRegBitWidthEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept26getLoadStoreVecRegBitWidthEj")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getLoadStoreVecRegBitWidth(/*uint*/int AddrSpace)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCacheLineSize">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 688,
     FQN="llvm::TargetTransformInfo::Concept::getCacheLineSize", NM="_ZN4llvm19TargetTransformInfo7Concept16getCacheLineSizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getCacheLineSizeEv")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getCacheLineSize()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getPrefetchDistance">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 689,
     FQN="llvm::TargetTransformInfo::Concept::getPrefetchDistance", NM="_ZN4llvm19TargetTransformInfo7Concept19getPrefetchDistanceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept19getPrefetchDistanceEv")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getPrefetchDistance()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getMinPrefetchStride">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 690,
     FQN="llvm::TargetTransformInfo::Concept::getMinPrefetchStride", NM="_ZN4llvm19TargetTransformInfo7Concept20getMinPrefetchStrideEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept20getMinPrefetchStrideEv")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getMinPrefetchStride()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getMaxPrefetchIterationsAhead">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 691,
     FQN="llvm::TargetTransformInfo::Concept::getMaxPrefetchIterationsAhead", NM="_ZN4llvm19TargetTransformInfo7Concept29getMaxPrefetchIterationsAheadEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept29getMaxPrefetchIterationsAheadEv")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getMaxPrefetchIterationsAhead()/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getMaxInterleaveFactor">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 692,
     FQN="llvm::TargetTransformInfo::Concept::getMaxInterleaveFactor", NM="_ZN4llvm19TargetTransformInfo7Concept22getMaxInterleaveFactorEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept22getMaxInterleaveFactorEj")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getMaxInterleaveFactor(/*uint*/int VF)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getArithmeticInstrCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 693,
     FQN="llvm::TargetTransformInfo::Concept::getArithmeticInstrCost", NM="_ZN4llvm19TargetTransformInfo7Concept22getArithmeticInstrCostEjPNS_4TypeENS0_16OperandValueKindES4_NS0_22OperandValuePropertiesES5_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept22getArithmeticInstrCostEjPNS_4TypeENS0_16OperandValueKindES4_NS0_22OperandValuePropertiesES5_")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getArithmeticInstrCost(/*uint*/int Opcode, Type /*P*/ Ty, OperandValueKind Opd1Info, 
                          OperandValueKind Opd2Info, 
                          OperandValueProperties Opd1PropInfo, 
                          OperandValueProperties Opd2PropInfo)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getShuffleCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 698,
     FQN="llvm::TargetTransformInfo::Concept::getShuffleCost", NM="_ZN4llvm19TargetTransformInfo7Concept14getShuffleCostENS0_11ShuffleKindEPNS_4TypeEiS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept14getShuffleCostENS0_11ShuffleKindEPNS_4TypeEiS4_")
    //</editor-fold>
    public abstract /*virtual*/ int getShuffleCost(ShuffleKind Kind, Type /*P*/ Tp, int Index, 
                  Type /*P*/ SubTp)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCastInstrCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 700,
     FQN="llvm::TargetTransformInfo::Concept::getCastInstrCost", NM="_ZN4llvm19TargetTransformInfo7Concept16getCastInstrCostEjPNS_4TypeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getCastInstrCostEjPNS_4TypeES3_")
    //</editor-fold>
    public abstract /*virtual*/ int getCastInstrCost(/*uint*/int Opcode, Type /*P*/ Dst, Type /*P*/ Src)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getExtractWithExtendCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 701,
     FQN="llvm::TargetTransformInfo::Concept::getExtractWithExtendCost", NM="_ZN4llvm19TargetTransformInfo7Concept24getExtractWithExtendCostEjPNS_4TypeEPNS_10VectorTypeEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept24getExtractWithExtendCostEjPNS_4TypeEPNS_10VectorTypeEj")
    //</editor-fold>
    public abstract /*virtual*/ int getExtractWithExtendCost(/*uint*/int Opcode, Type /*P*/ Dst, 
                            VectorType /*P*/ VecTy, /*uint*/int Index)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCFInstrCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 703,
     FQN="llvm::TargetTransformInfo::Concept::getCFInstrCost", NM="_ZN4llvm19TargetTransformInfo7Concept14getCFInstrCostEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept14getCFInstrCostEj")
    //</editor-fold>
    public abstract /*virtual*/ int getCFInstrCost(/*uint*/int Opcode)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCmpSelInstrCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 704,
     FQN="llvm::TargetTransformInfo::Concept::getCmpSelInstrCost", NM="_ZN4llvm19TargetTransformInfo7Concept18getCmpSelInstrCostEjPNS_4TypeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept18getCmpSelInstrCostEjPNS_4TypeES3_")
    //</editor-fold>
    public abstract /*virtual*/ int getCmpSelInstrCost(/*uint*/int Opcode, Type /*P*/ ValTy, 
                      Type /*P*/ CondTy)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getVectorInstrCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 706,
     FQN="llvm::TargetTransformInfo::Concept::getVectorInstrCost", NM="_ZN4llvm19TargetTransformInfo7Concept18getVectorInstrCostEjPNS_4TypeEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept18getVectorInstrCostEjPNS_4TypeEj")
    //</editor-fold>
    public abstract /*virtual*/ int getVectorInstrCost(/*uint*/int Opcode, Type /*P*/ Val, 
                      /*uint*/int Index)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getMemoryOpCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 708,
     FQN="llvm::TargetTransformInfo::Concept::getMemoryOpCost", NM="_ZN4llvm19TargetTransformInfo7Concept15getMemoryOpCostEjPNS_4TypeEjj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept15getMemoryOpCostEjPNS_4TypeEjj")
    //</editor-fold>
    public abstract /*virtual*/ int getMemoryOpCost(/*uint*/int Opcode, Type /*P*/ Src, /*uint*/int Alignment, 
                   /*uint*/int AddressSpace)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getMaskedMemoryOpCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 710,
     FQN="llvm::TargetTransformInfo::Concept::getMaskedMemoryOpCost", NM="_ZN4llvm19TargetTransformInfo7Concept21getMaskedMemoryOpCostEjPNS_4TypeEjj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept21getMaskedMemoryOpCostEjPNS_4TypeEjj")
    //</editor-fold>
    public abstract /*virtual*/ int getMaskedMemoryOpCost(/*uint*/int Opcode, Type /*P*/ Src, 
                         /*uint*/int Alignment, 
                         /*uint*/int AddressSpace)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getGatherScatterOpCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 713,
     FQN="llvm::TargetTransformInfo::Concept::getGatherScatterOpCost", NM="_ZN4llvm19TargetTransformInfo7Concept22getGatherScatterOpCostEjPNS_4TypeEPNS_5ValueEbj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept22getGatherScatterOpCostEjPNS_4TypeEPNS_5ValueEbj")
    //</editor-fold>
    public abstract /*virtual*/ int getGatherScatterOpCost(/*uint*/int Opcode, Type /*P*/ DataTy, 
                          Value /*P*/ Ptr, boolean VariableMask, 
                          /*uint*/int Alignment)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getInterleavedMemoryOpCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 716,
     FQN="llvm::TargetTransformInfo::Concept::getInterleavedMemoryOpCost", NM="_ZN4llvm19TargetTransformInfo7Concept26getInterleavedMemoryOpCostEjPNS_4TypeEjNS_8ArrayRefIjEEjj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept26getInterleavedMemoryOpCostEjPNS_4TypeEjNS_8ArrayRefIjEEjj")
    //</editor-fold>
    public abstract /*virtual*/ int getInterleavedMemoryOpCost(/*uint*/int Opcode, Type /*P*/ VecTy, 
                              /*uint*/int Factor, 
                              ArrayRefUInt Indices, 
                              /*uint*/int Alignment, 
                              /*uint*/int AddressSpace)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getReductionCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 721,
     FQN="llvm::TargetTransformInfo::Concept::getReductionCost", NM="_ZN4llvm19TargetTransformInfo7Concept16getReductionCostEjPNS_4TypeEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getReductionCostEjPNS_4TypeEb")
    //</editor-fold>
    public abstract /*virtual*/ int getReductionCost(/*uint*/int Opcode, Type /*P*/ Ty, 
                    boolean IsPairwiseForm)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getIntrinsicInstrCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 723,
     FQN="llvm::TargetTransformInfo::Concept::getIntrinsicInstrCost", NM="_ZN4llvm19TargetTransformInfo7Concept21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS5_EENS_13FastMathFlagsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIS5_EENS_13FastMathFlagsE")
    //</editor-fold>
    public abstract /*virtual*/ int getIntrinsicInstrCost_ID_Type$P_ArrayRef$Type$P_FastMathFlags(/*Intrinsic.ID*/int ID, Type /*P*/ RetTy, 
                                                                 ArrayRef<Type /*P*/ > Tys, 
                                                                 FastMathFlags FMF)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getIntrinsicInstrCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 726,
     FQN="llvm::TargetTransformInfo::Concept::getIntrinsicInstrCost", NM="_ZN4llvm19TargetTransformInfo7Concept21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEENS_13FastMathFlagsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept21getIntrinsicInstrCostENS_9Intrinsic2IDEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEENS_13FastMathFlagsE")
    //</editor-fold>
    public abstract /*virtual*/ int getIntrinsicInstrCost_ID_Type$P_ArrayRef$Value$P_FastMathFlags(/*Intrinsic.ID*/int ID, Type /*P*/ RetTy, 
                                                                  ArrayRef<Value /*P*/ > Args, 
                                                                  FastMathFlags FMF)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCallInstrCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 729,
     FQN="llvm::TargetTransformInfo::Concept::getCallInstrCost", NM="_ZN4llvm19TargetTransformInfo7Concept16getCallInstrCostEPNS_8FunctionEPNS_4TypeENS_8ArrayRefIS5_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getCallInstrCostEPNS_8FunctionEPNS_4TypeENS_8ArrayRefIS5_EE")
    //</editor-fold>
    public abstract /*virtual*/ int getCallInstrCost(Function /*P*/ F, Type /*P*/ RetTy, 
                    ArrayRef<Type /*P*/ > Tys)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getNumberOfParts">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 731,
     FQN="llvm::TargetTransformInfo::Concept::getNumberOfParts", NM="_ZN4llvm19TargetTransformInfo7Concept16getNumberOfPartsEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept16getNumberOfPartsEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getNumberOfParts(Type /*P*/ Tp)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getAddressComputationCost">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 732,
     FQN="llvm::TargetTransformInfo::Concept::getAddressComputationCost", NM="_ZN4llvm19TargetTransformInfo7Concept25getAddressComputationCostEPNS_4TypeEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept25getAddressComputationCostEPNS_4TypeEb")
    //</editor-fold>
    public abstract /*virtual*/ int getAddressComputationCost(Type /*P*/ Ty, boolean IsComplex)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getCostOfKeepingLiveOverCall">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 733,
     FQN="llvm::TargetTransformInfo::Concept::getCostOfKeepingLiveOverCall", NM="_ZN4llvm19TargetTransformInfo7Concept28getCostOfKeepingLiveOverCallENS_8ArrayRefIPNS_4TypeEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept28getCostOfKeepingLiveOverCallENS_8ArrayRefIPNS_4TypeEEE")
    //</editor-fold>
    public abstract /*virtual*/ /*uint*/int getCostOfKeepingLiveOverCall(ArrayRef<Type /*P*/ > Tys)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getTgtMemIntrinsic">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 734,
     FQN="llvm::TargetTransformInfo::Concept::getTgtMemIntrinsic", NM="_ZN4llvm19TargetTransformInfo7Concept18getTgtMemIntrinsicEPNS_13IntrinsicInstERNS_16MemIntrinsicInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept18getTgtMemIntrinsicEPNS_13IntrinsicInstERNS_16MemIntrinsicInfoE")
    //</editor-fold>
    public abstract /*virtual*/ boolean getTgtMemIntrinsic(IntrinsicInst /*P*/ Inst, 
                      final MemIntrinsicInfo /*&*/ Info)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::getOrCreateResultFromMemIntrinsic">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 736,
     FQN="llvm::TargetTransformInfo::Concept::getOrCreateResultFromMemIntrinsic", NM="_ZN4llvm19TargetTransformInfo7Concept33getOrCreateResultFromMemIntrinsicEPNS_13IntrinsicInstEPNS_4TypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm19TargetTransformInfo7Concept33getOrCreateResultFromMemIntrinsicEPNS_13IntrinsicInstEPNS_4TypeE")
    //</editor-fold>
    public abstract /*virtual*/ Value /*P*/ getOrCreateResultFromMemIntrinsic(IntrinsicInst /*P*/ Inst, 
                                     Type /*P*/ ExpectedType)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfo::Concept::areInlineCompatible">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 738,
     FQN="llvm::TargetTransformInfo::Concept::areInlineCompatible", NM="_ZNK4llvm19TargetTransformInfo7Concept19areInlineCompatibleEPKNS_8FunctionES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZNK4llvm19TargetTransformInfo7Concept19areInlineCompatibleEPKNS_8FunctionES4_")
    //</editor-fold>
    public abstract /*virtual*/ boolean areInlineCompatible(/*const*/ Function /*P*/ Caller, 
                       /*const*/ Function /*P*/ Callee) /*const*//* = 0*/;

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  private std.unique_ptr<Concept> TTIImpl;
  
  @Override public String toString() {
    return "" + "TTIImpl=" + TTIImpl; // NOI18N
  }
}
