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

package org.llvm.target.target;

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
import org.llvm.analysis.*;
import org.llvm.mc.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::TargetOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetOptions.h", line = 92,
 FQN="llvm::TargetOptions", NM="_ZN4llvm13TargetOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetOptionsE")
//</editor-fold>
public class TargetOptions implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetOptions::TargetOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetOptions.h", line = 94,
   FQN="llvm::TargetOptions::TargetOptions", NM="_ZN4llvm13TargetOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetOptionsC1Ev")
  //</editor-fold>
  public TargetOptions() {
    // : PrintMachineCode(false), LessPreciseFPMADOption(false), UnsafeFPMath(false), NoInfsFPMath(false), NoNaNsFPMath(false), HonorSignDependentRoundingFPMathOption(false), NoZerosInBSS(false), GuaranteedTailCallOpt(false), StackAlignmentOverride(0), StackSymbolOrdering(true), EnableFastISel(false), UseInitArray(false), DisableIntegratedAS(false), CompressDebugSections(false), RelaxELFRelocations(false), FunctionSections(false), DataSections(false), UniqueSectionNames(true), TrapUnreachable(false), EmulatedTLS(false), EnableIPRA(false), FloatABIType(FloatABI::Default), AllowFPOpFusion(FPOpFusion::Standard), Reciprocals(TargetRecip()), JTType(JumpTable::Single), ThreadModel(ThreadModel::POSIX), EABIVersion(EABI::Default), DebuggerTuning(DebuggerKind::Default), ExceptionModel(ExceptionHandling::None), MCOptions() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// PrintMachineCode - This flag is enabled when the -print-machineinstrs
  /// option is specified on the command line, and should enable debugging
  /// output from the code generator.
  public /*JBIT unsigned int*/ boolean PrintMachineCode /*: 1*/;
  
  /// DisableFramePointerElim - This returns true if frame pointer elimination
  /// optimization should be disabled for the given machine function.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetOptions::DisableFramePointerElim">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetOptions.h", line = 117,
   FQN="llvm::TargetOptions::DisableFramePointerElim", NM="_ZNK4llvm13TargetOptions23DisableFramePointerElimERKNS_15MachineFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetOptions23DisableFramePointerElimERKNS_15MachineFunctionE")
  //</editor-fold>
  public boolean DisableFramePointerElim(final /*const*/ MachineFunction /*&*/ MF) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// LessPreciseFPMAD - This flag is enabled when the
  /// -enable-fp-mad is specified on the command line.  When this flag is off
  /// (the default), the code generator is not allowed to generate mad
  /// (multiply add) if the result is "less precise" than doing those
  /// operations individually.
  public /*JBIT unsigned int*/ boolean LessPreciseFPMADOption /*: 1*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetOptions::LessPreciseFPMAD">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetOptions.h", line = 125,
   FQN="llvm::TargetOptions::LessPreciseFPMAD", NM="_ZNK4llvm13TargetOptions16LessPreciseFPMADEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetOptions16LessPreciseFPMADEv")
  //</editor-fold>
  public boolean LessPreciseFPMAD() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// UnsafeFPMath - This flag is enabled when the
  /// -enable-unsafe-fp-math flag is specified on the command line.  When
  /// this flag is off (the default), the code generator is not allowed to
  /// produce results that are "less precise" than IEEE allows.  This includes
  /// use of X86 instructions like FSIN and FCOS instead of libcalls.
  /// UnsafeFPMath implies LessPreciseFPMAD.
  public /*JBIT unsigned int*/ boolean UnsafeFPMath /*: 1*/;
  
  /// NoInfsFPMath - This flag is enabled when the
  /// -enable-no-infs-fp-math flag is specified on the command line. When
  /// this flag is off (the default), the code generator is not allowed to
  /// assume the FP arithmetic arguments and results are never +-Infs.
  public /*JBIT unsigned int*/ boolean NoInfsFPMath /*: 1*/;
  
  /// NoNaNsFPMath - This flag is enabled when the
  /// -enable-no-nans-fp-math flag is specified on the command line. When
  /// this flag is off (the default), the code generator is not allowed to
  /// assume the FP arithmetic arguments and results are never NaNs.
  public /*JBIT unsigned int*/ boolean NoNaNsFPMath /*: 1*/;
  
  /// HonorSignDependentRoundingFPMath - This returns true when the
  /// -enable-sign-dependent-rounding-fp-math is specified.  If this returns
  /// false (the default), the code generator is allowed to assume that the
  /// rounding behavior is the default (round-to-zero for all floating point
  /// to integer conversions, and round-to-nearest for all other arithmetic
  /// truncations).  If this is enabled (set to true), the code generator must
  /// assume that the rounding mode may dynamically change.
  public /*JBIT unsigned int*/ boolean HonorSignDependentRoundingFPMathOption /*: 1*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetOptions::HonorSignDependentRoundingFPMath">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetOptions.h", line = 155,
   FQN="llvm::TargetOptions::HonorSignDependentRoundingFPMath", NM="_ZNK4llvm13TargetOptions32HonorSignDependentRoundingFPMathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm13TargetOptions32HonorSignDependentRoundingFPMathEv")
  //</editor-fold>
  public boolean HonorSignDependentRoundingFPMath() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// NoZerosInBSS - By default some codegens place zero-initialized data to
  /// .bss section. This flag disables such behaviour (necessary, e.g. for
  /// crt*.o compiling).
  public /*JBIT unsigned int*/ boolean NoZerosInBSS /*: 1*/;
  
  /// GuaranteedTailCallOpt - This flag is enabled when -tailcallopt is
  /// specified on the commandline. When the flag is on, participating targets
  /// will perform tail call optimization on all calls which use the fastcc
  /// calling convention and which satisfy certain target-independent
  /// criteria (being at the end of a function, having the same return type
  /// as their parent function, etc.), using an alternate ABI if necessary.
  public /*JBIT unsigned int*/ boolean GuaranteedTailCallOpt /*: 1*/;
  
  /// StackAlignmentOverride - Override default stack alignment for target.
  public /*uint*/int StackAlignmentOverride;
  
  /// StackSymbolOrdering - When true, this will allow CodeGen to order
  /// the local stack symbols (for code size, code locality, or any other
  /// heuristics). When false, the local symbols are left in whatever order
  /// they were generated. Default is true.
  public /*JBIT unsigned int*/ boolean StackSymbolOrdering /*: 1*/;
  
  /// EnableFastISel - This flag enables fast-path instruction selection
  /// which trades away generated code quality in favor of reducing
  /// compile time.
  public /*JBIT unsigned int*/ boolean EnableFastISel /*: 1*/;
  
  /// UseInitArray - Use .init_array instead of .ctors for static
  /// constructors.
  public /*JBIT unsigned int*/ boolean UseInitArray /*: 1*/;
  
  /// Disable the integrated assembler.
  public /*JBIT unsigned int*/ boolean DisableIntegratedAS /*: 1*/;
  
  /// Compress DWARF debug sections.
  public /*JBIT unsigned int*/ boolean CompressDebugSections /*: 1*/;
  
  public /*JBIT unsigned int*/ boolean RelaxELFRelocations /*: 1*/;
  
  /// Emit functions into separate sections.
  public /*JBIT unsigned int*/ boolean FunctionSections /*: 1*/;
  
  /// Emit data into separate sections.
  public /*JBIT unsigned int*/ boolean DataSections /*: 1*/;
  
  public /*JBIT unsigned int*/ boolean UniqueSectionNames /*: 1*/;
  
  /// Emit target-specific trap instruction for 'unreachable' IR instructions.
  public /*JBIT unsigned int*/ boolean TrapUnreachable /*: 1*/;
  
  /// EmulatedTLS - This flag enables emulated TLS model, using emutls
  /// function in the runtime library..
  public /*JBIT unsigned int*/ boolean EmulatedTLS /*: 1*/;
  
  /// This flag enables InterProcedural Register Allocation (IPRA).
  public /*JBIT unsigned int*/ boolean EnableIPRA /*: 1*/;
  
  /// FloatABIType - This setting is set by -float-abi=xxx option is specfied
  /// on the command line. This setting may either be Default, Soft, or Hard.
  /// Default selects the target's default behavior. Soft selects the ABI for
  /// software floating point, but does not indicate that FP hardware may not
  /// be used. Such a combination is unfortunately popular (e.g.
  /// arm-apple-darwin). Hard presumes that the normal FP ABI is used.
  public FloatABI.ABIType FloatABIType;
  
  /// AllowFPOpFusion - This flag is set by the -fuse-fp-ops=xxx option.
  /// This controls the creation of fused FP ops that store intermediate
  /// results in higher precision than IEEE allows (E.g. FMAs).
  ///
  /// Fast mode - allows formation of fused FP ops whenever they're
  /// profitable.
  /// Standard mode - allow fusion only for 'blessed' FP ops. At present the
  /// only blessed op is the fmuladd intrinsic. In the future more blessed ops
  /// may be added.
  /// Strict mode - allow fusion only if/when it can be proven that the excess
  /// precision won't effect the result.
  ///
  /// Note: This option only controls formation of fused ops by the
  /// optimizers.  Fused operations that are explicitly specified (e.g. FMA
  /// via the llvm.fma.* intrinsic) will always be honored, regardless of
  /// the value of this option.
  public FPOpFusion.FPOpFusionMode AllowFPOpFusion;
  
  /// This class encapsulates options for reciprocal-estimate code generation.
  public TargetRecip Reciprocals;
  
  /// JTType - This flag specifies the type of jump-instruction table to
  /// create for functions that have the jumptable attribute.
  public JumpTable.JumpTableType JTType;
  
  /// ThreadModel - This flag specifies the type of threading model to assume
  /// for things like atomics
  public ThreadModel.Model ThreadModel;
  
  /// EABIVersion - This flag specifies the EABI version
  public EABI EABIVersion;
  
  /// Which debugger to tune for.
  public DebuggerKind DebuggerTuning;
  
  /// What exception model to use
  public ExceptionHandling ExceptionModel;
  
  /// Machine level options.
  public MCTargetOptions MCOptions;
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetOptions::~TargetOptions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetOptions.h", line = 92,
   FQN="llvm::TargetOptions::~TargetOptions", NM="_ZN4llvm13TargetOptionsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm13TargetOptionsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "PrintMachineCode=" + PrintMachineCode // NOI18N
              + ", LessPreciseFPMADOption=" + LessPreciseFPMADOption // NOI18N
              + ", UnsafeFPMath=" + UnsafeFPMath // NOI18N
              + ", NoInfsFPMath=" + NoInfsFPMath // NOI18N
              + ", NoNaNsFPMath=" + NoNaNsFPMath // NOI18N
              + ", HonorSignDependentRoundingFPMathOption=" + HonorSignDependentRoundingFPMathOption // NOI18N
              + ", NoZerosInBSS=" + NoZerosInBSS // NOI18N
              + ", GuaranteedTailCallOpt=" + GuaranteedTailCallOpt // NOI18N
              + ", StackAlignmentOverride=" + StackAlignmentOverride // NOI18N
              + ", StackSymbolOrdering=" + StackSymbolOrdering // NOI18N
              + ", EnableFastISel=" + EnableFastISel // NOI18N
              + ", UseInitArray=" + UseInitArray // NOI18N
              + ", DisableIntegratedAS=" + DisableIntegratedAS // NOI18N
              + ", CompressDebugSections=" + CompressDebugSections // NOI18N
              + ", RelaxELFRelocations=" + RelaxELFRelocations // NOI18N
              + ", FunctionSections=" + FunctionSections // NOI18N
              + ", DataSections=" + DataSections // NOI18N
              + ", UniqueSectionNames=" + UniqueSectionNames // NOI18N
              + ", TrapUnreachable=" + TrapUnreachable // NOI18N
              + ", EmulatedTLS=" + EmulatedTLS // NOI18N
              + ", EnableIPRA=" + EnableIPRA // NOI18N
              + ", FloatABIType=" + FloatABIType // NOI18N
              + ", AllowFPOpFusion=" + AllowFPOpFusion // NOI18N
              + ", Reciprocals=" + Reciprocals // NOI18N
              + ", JTType=" + JTType // NOI18N
              + ", ThreadModel=" + ThreadModel // NOI18N
              + ", EABIVersion=" + EABIVersion // NOI18N
              + ", DebuggerTuning=" + DebuggerTuning // NOI18N
              + ", ExceptionModel=" + ExceptionModel // NOI18N
              + ", MCOptions=" + MCOptions; // NOI18N
  }
}
