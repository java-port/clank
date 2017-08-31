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

import org.llvm.support.target.Target;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.*;
import org.clang.driver.frontend.CodeGenOptions;
//import org.llvm.target.target.TargetOptions;
//import org.clang.basic.target.TargetOptions;
import static org.llvm.pass.IrLlvmGlobals.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import org.llvm.analysis.target.TargetIRAnalysis;
import org.llvm.ir.legacy.*;
import org.llvm.target.target.*;
import org.llvm.transforms.*;
import org.llvm.transforms.ipo.*;
import static org.clang.codegen.impl.BackendUtilStatics.*;
import static org.clang.frontend.FrontendClangGlobals.BuryPointer$T;
import org.llvm.cl.ClGlobals;
import org.llvm.mc.*;
import static org.llvm.transforms.utils.TransformsLlvmGlobals.*;
import static org.llvm.adt.java.ADTJavaDifferentiators.*;
import org.llvm.analysis.AnalysisLlvmGlobals;
import org.llvm.analysis.target.TargetLibraryInfoImpl;
import org.llvm.analysis.target.TargetLibraryInfoWrapperPass;
import org.llvm.bitcode.BitcodeLlvmGlobals;
import static org.llvm.pass.IrLlvmGlobals.createPrintModulePass;
import org.llvm.support.target.TargetRegistry;
import org.llvm.transforms.GCOVOptions;
import static org.llvm.transforms.java.TransformDummies.*;
import org.llvm.ir.legacy.PassManager;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 55,
 FQN="(anonymous namespace)::EmitAssemblyHelper", NM="_ZN12_GLOBAL__N_118EmitAssemblyHelperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_118EmitAssemblyHelperE")
//</editor-fold>
public class EmitAssemblyHelper implements Destructors.ClassWithDestructor {
  private final DiagnosticsEngine /*&*/ Diags;
  private final /*const*/ CodeGenOptions /*&*/ CodeGenOpts;
  private final /*const*/ org.clang.basic.target.TargetOptions /*&*/ TargetOpts;
  private final /*const*/ LangOptions /*&*/ LangOpts;
  private org.llvm.ir.Module /*P*/ TheModule;
  
  private Timer CodeGenerationTime;
  
  private std.unique_ptr<raw_pwrite_stream> OS;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper::getTargetIRAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 67,
   FQN="(anonymous namespace)::EmitAssemblyHelper::getTargetIRAnalysis", NM="_ZNK12_GLOBAL__N_118EmitAssemblyHelper19getTargetIRAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK12_GLOBAL__N_118EmitAssemblyHelper19getTargetIRAnalysisEv")
  //</editor-fold>
  private TargetIRAnalysis getTargetIRAnalysis() /*const*/ {
    if (TM.$bool()) {
      return TM.$arrow().getTargetIRAnalysis();
    }
    
    return new TargetIRAnalysis();
  }

  
  /// Set LLVM command line options passed through -backend-option.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper::setCommandLineOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 475,
   FQN="(anonymous namespace)::EmitAssemblyHelper::setCommandLineOpts", NM="_ZN12_GLOBAL__N_118EmitAssemblyHelper18setCommandLineOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_118EmitAssemblyHelper18setCommandLineOptsEv")
  //</editor-fold>
  private void setCommandLineOpts() {
    SmallVector</*const*/char$ptr/*char P*//*,  16*/> BackendArgs/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  16*/>(16, null);
    BackendArgs.push_back($("clang")); // Fake program name.
    if (!CodeGenOpts.DebugPass.empty()) {
      BackendArgs.push_back($("-debug-pass"));
      BackendArgs.push_back(CodeGenOpts.DebugPass.c_str());
    }
    if (!CodeGenOpts.LimitFloatPrecision.empty()) {
      BackendArgs.push_back($("-limit-float-precision"));
      BackendArgs.push_back(CodeGenOpts.LimitFloatPrecision.c_str());
    }
    for (final /*const*/std.string/*&*/ BackendOption : CodeGenOpts.BackendOptions)  {
      BackendArgs.push_back(BackendOption.c_str());
    }
    BackendArgs.push_back((/*const*/char$ptr/*char P*//*const*/)null);
    ClGlobals.ParseCommandLineOptions(BackendArgs.size() - 1, 
        BackendArgs.data());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper::CreatePasses">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 283,
   FQN="(anonymous namespace)::EmitAssemblyHelper::CreatePasses", NM="_ZN12_GLOBAL__N_118EmitAssemblyHelper12CreatePassesERN4llvm6legacy11PassManagerERNS2_19FunctionPassManagerEPNS1_18ModuleSummaryIndexE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_118EmitAssemblyHelper12CreatePassesERN4llvm6legacy11PassManagerERNS2_19FunctionPassManagerEPNS1_18ModuleSummaryIndexE")
  //</editor-fold>
  private void CreatePasses(final PassManager /*&*/ MPM, 
              final FunctionPassManager /*&*/ FPM, 
              ModuleSummaryIndex /*P*/ ModuleSummary) {
    PassManagerBuilderWrapper PMBuilder = null;
    try {
      if (CodeGenOpts.DisableLLVMPasses) {
        return;
      }
      
      /*uint*/int OptLevel = $2bits_uint2uint(CodeGenOpts.OptimizationLevel);
      CodeGenOptions.InliningMethod Inlining = CodeGenOpts.getInlining();
      
      // Handle disabling of LLVM optimization, where we want to preserve the
      // internal module before any optimization.
      if (CodeGenOpts.DisableLLVMOpts) {
        OptLevel = 0;
        Inlining = CodeGenOptions.InliningMethod.NoInlining;
      }
      
      PMBuilder/*J*/= new PassManagerBuilderWrapper(CodeGenOpts, LangOpts);
      
      // Figure out TargetLibraryInfo.
      Triple TargetTriple/*J*/= new Triple(new Twine(TheModule.getTargetTriple()));
      PMBuilder.LibraryInfo = createTLII(TargetTriple, CodeGenOpts);
      switch (Inlining) {
       case NoInlining:
        break;
       case NormalInlining:
       case OnlyHintInlining:
        {
          PMBuilder.Inliner
             = createFunctionInliningPass(OptLevel, $2bits_uint2uint(CodeGenOpts.OptimizeSize));
          break;
        }
       case OnlyAlwaysInlining:
        // Respect always_inline.
        if (OptLevel == 0) {
          // Do not insert lifetime intrinsics at -O0.
          PMBuilder.Inliner = createAlwaysInlinerPass(false);
        } else {
          PMBuilder.Inliner = createAlwaysInlinerPass();
        }
        break;
      }
      
      PMBuilder.OptLevel = OptLevel;
      PMBuilder.SizeLevel = $2bits_uint2uint(CodeGenOpts.OptimizeSize);
      PMBuilder.BBVectorize = CodeGenOpts.VectorizeBB;
      PMBuilder.SLPVectorize = CodeGenOpts.VectorizeSLP;
      PMBuilder.LoopVectorize = CodeGenOpts.VectorizeLoop;
      
      PMBuilder.DisableUnrollLoops = !CodeGenOpts.UnrollLoops;
      PMBuilder.MergeFunctions = CodeGenOpts.MergeFunctions;
      PMBuilder.PrepareForThinLTO = CodeGenOpts.EmitSummaryIndex;
      PMBuilder.PrepareForLTO = CodeGenOpts.PrepareForLTO;
      PMBuilder.RerollLoops = CodeGenOpts.RerollLoops;
      
      // If we are performing a ThinLTO importing compile, invoke the LTO
      // pipeline and pass down the in-memory module summary index.
      if ((ModuleSummary != null)) {
        PMBuilder.ModuleSummary = ModuleSummary;
        PMBuilder.populateThinLTOPassManager(MPM);
        return;
      }
      
      // Add target-specific passes that need to run as early as possible.
      if (TM.$bool()) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EarlyAsPossible, 
            /*FuncArg*//*[&, this]*/ (final /*const*/ PassManagerBuilder /*&*/ $Prm0, final PassManagerBase /*&*/ PM) -> {
                  TM.$arrow().addEarlyAsPossiblePasses(PM);
                });
      }
      
      PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EarlyAsPossible, 
          /*FuncArg*//*FuncRef*/BackendUtilStatics::addAddDiscriminatorsPass);
      
      // In ObjC ARC mode, add the main ARC optimization passes.
      if (LangOpts.ObjCAutoRefCount) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EarlyAsPossible, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addObjCARCExpandPass);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_ModuleOptimizerEarly, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addObjCARCAPElimPass);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_ScalarOptimizerLate, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addObjCARCOptPass);
      }
      if (LangOpts.Sanitize.has(SanitizerKind.LocalBounds)) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_ScalarOptimizerLate, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addBoundsCheckingPass);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EnabledOnOptLevel0, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addBoundsCheckingPass);
      }
      if (($2bits_uint2uint(CodeGenOpts.SanitizeCoverageType) != 0)
         || CodeGenOpts.SanitizeCoverageIndirectCalls
         || CodeGenOpts.SanitizeCoverageTraceCmp) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_OptimizerLast, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addSanitizerCoveragePass);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EnabledOnOptLevel0, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addSanitizerCoveragePass);
      }
      if (LangOpts.Sanitize.has(SanitizerKind.Address)) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_OptimizerLast, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addAddressSanitizerPasses);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EnabledOnOptLevel0, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addAddressSanitizerPasses);
      }
      if (LangOpts.Sanitize.has(SanitizerKind.KernelAddress)) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_OptimizerLast, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addKernelAddressSanitizerPasses);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EnabledOnOptLevel0, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addKernelAddressSanitizerPasses);
      }
      if (LangOpts.Sanitize.has(SanitizerKind.Memory)) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_OptimizerLast, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addMemorySanitizerPass);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EnabledOnOptLevel0, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addMemorySanitizerPass);
      }
      if (LangOpts.Sanitize.has(SanitizerKind.Thread)) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_OptimizerLast, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addThreadSanitizerPass);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EnabledOnOptLevel0, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addThreadSanitizerPass);
      }
      if (LangOpts.Sanitize.has(SanitizerKind.DataFlow)) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_OptimizerLast, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addDataFlowSanitizerPass);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EnabledOnOptLevel0, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addDataFlowSanitizerPass);
      }
      if (LangOpts.Sanitize.hasOneOf(SanitizerKind.Efficiency)) {
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_OptimizerLast, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addEfficiencySanitizerPass);
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EnabledOnOptLevel0, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addEfficiencySanitizerPass);
      }
      
      // Set up the per-function pass manager.
      if (CodeGenOpts.VerifyModule) {
        FPM.add(createVerifierPass());
      }
      
      // Set up the per-module pass manager.
      if (!CodeGenOpts.RewriteMapFiles.empty()) {
        addSymbolRewriterPass(CodeGenOpts, /*AddrOf*/MPM);
      }
      if (!CodeGenOpts.DisableGCov
         && (CodeGenOpts.EmitGcovArcs || CodeGenOpts.EmitGcovNotes)) {
        // Not using 'GCOVOptions::getDefault' allows us to avoid exiting if
        // LLVM's -default-gcov-version flag is set to something invalid.
        GCOVOptions Options/*J*/= new GCOVOptions();
        Options.EmitNotes = CodeGenOpts.EmitGcovNotes;
        Options.EmitData = CodeGenOpts.EmitGcovArcs;
        memcpy(Options.Version, CodeGenOpts.CoverageVersion, 4);
        Options.UseCfgChecksum = CodeGenOpts.CoverageExtraChecksum;
        Options.NoRedZone = CodeGenOpts.DisableRedZone;
        Options.FunctionNamesInData
           = !CodeGenOpts.CoverageNoFunctionNamesInData;
        Options.ExitBlockBeforeBody = CodeGenOpts.CoverageExitBlockBeforeBody;
        MPM.add(createGCOVProfilerPass(Options));
        if (CodeGenOpts.getDebugInfo() == DebugInfoKind.NoDebugInfo) {
          MPM.add(createStripSymbolsPass(true));
        }
      }
      if (CodeGenOpts.hasProfileClangInstr()) {
        InstrProfOptions Options2 = new InstrProfOptions();
        try {
          Options2/*J*/= new InstrProfOptions();
          Options2.NoRedZone = CodeGenOpts.DisableRedZone;
          Options2.InstrProfileOutput.$assign(CodeGenOpts.InstrProfileOutput);
          MPM.add(createInstrProfilingLegacyPass(Options2));
        } finally {
          if (Options2 != null) { Options2.$destroy(); }
        }
      }
      if (CodeGenOpts.hasProfileIRInstr()) {
        if (!CodeGenOpts.InstrProfileOutput.empty()) {
          PMBuilder.PGOInstrGen.$assign(CodeGenOpts.InstrProfileOutput);
        } else {
          PMBuilder.PGOInstrGen.$assign_T$C$P(/*KEEP_STR*/"default.profraw");
        }
      }
      if (CodeGenOpts.hasProfileIRUse()) {
        PMBuilder.PGOInstrUse.$assign(CodeGenOpts.ProfileInstrumentUsePath);
      }
      if (!CodeGenOpts.SampleProfileFile.empty()) {
        MPM.add(createPruneEHPass());
        MPM.add(createSampleProfileLoaderPass(new StringRef(CodeGenOpts.SampleProfileFile)));
        PMBuilder.addExtension(PassManagerBuilder.ExtensionPointTy.EP_EarlyAsPossible, 
            /*FuncArg*//*FuncRef*/BackendUtilStatics::addCleanupPassesForSampleProfiler);
      }
      
      PMBuilder.populateFunctionPassManager(FPM);
      PMBuilder.populateModulePassManager(MPM);
    } finally {
      if (PMBuilder != null) { PMBuilder.$destroy(); }
    }
  }

  
  /// Generates the TargetMachine.
  /// Leaves TM unchanged if it is unable to create the target machine.
  /// Some of our clang tests specify triples which are not built
  /// into clang. This is okay because these tests check the generated
  /// IR, and they require DataLayout which depends on the triple.
  /// In this case, we allow this method to fail and not report an error.
  /// When MustCreateTM is used, we print an error if we are unable to load
  /// the requested target.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper::CreateTargetMachine">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 493,
   FQN="(anonymous namespace)::EmitAssemblyHelper::CreateTargetMachine", NM="_ZN12_GLOBAL__N_118EmitAssemblyHelper19CreateTargetMachineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_118EmitAssemblyHelper19CreateTargetMachineEb")
  //</editor-fold>
  private void CreateTargetMachine(boolean MustCreateTM) {
    org.llvm.target.target.TargetOptions Options = null;
    try {
      // Create the TargetMachine for generating code.
      std.string Error/*J*/= new std.string();
      std.string Triple = new std.string(TheModule.getTargetTriple());
      /*const*/ Target /*P*/ TheTarget = TargetRegistry.lookupTarget(Triple, Error);
      if (!(TheTarget != null)) {
        if (MustCreateTM) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_unable_to_create_target)), new StringRef(Error)));
          } finally {
            $c$.$destroy();
          }
        }
        return;
      }
      
      /*uint*/int _CodeModel = new StringSwitchUInt(new StringRef(CodeGenOpts.CodeModel)).
          Case(/*KEEP_STR*/"small", CodeModel.Model.Small.getValue()).
          Case(/*KEEP_STR*/"kernel", CodeModel.Model.Kernel.getValue()).
          Case(/*KEEP_STR*/"medium", CodeModel.Model.Medium.getValue()).
          Case(/*KEEP_STR*/"large", CodeModel.Model.Large.getValue()).
          Case(/*KEEP_STR*/"default", CodeModel.Model.Default.getValue()).
          Default(~0/*U*/);
      assert (_CodeModel != ~0/*U*/) : "invalid code model!";
      CodeModel.Model CM = /*static_cast*/CodeModel.Model.valueOf(_CodeModel);
      
      std.string FeaturesStr = llvm.join(TargetOpts.Features.begin$Const(), TargetOpts.Features.end$Const(), new StringRef(/*KEEP_STR*/$COMMA));
      
      // Keep this synced with the equivalent code in tools/driver/cc1as_main.cpp.
      Optional<Reloc.Model> RM/*J*/= new Optional<Reloc.Model>();
      if ($eq_string$C_T$C$P(CodeGenOpts.RelocationModel, /*KEEP_STR*/"static")) {
        RM.$assign_T$RR(/*KEEP_ENUM*/Reloc.Model.Static);
      } else if ($eq_string$C_T$C$P(CodeGenOpts.RelocationModel, /*KEEP_STR*/"pic")) {
        RM.$assign_T$RR(/*KEEP_ENUM*/Reloc.Model.PIC_);
      } else {
        assert ($eq_string$C_T$C$P(CodeGenOpts.RelocationModel, /*KEEP_STR*/"dynamic-no-pic")) : "Invalid PIC model!";
        RM.$assign_T$RR(/*KEEP_ENUM*/Reloc.Model.DynamicNoPIC);
      }
      
      CodeGenOpt.Level OptLevel = CodeGenOpt.Level.Default;
      switch ($2bits_uint2uint(CodeGenOpts.OptimizationLevel)) {
       default:
        break;
       case 0:
        OptLevel = CodeGenOpt.Level.None;
        break;
       case 3:
        OptLevel = CodeGenOpt.Level.Aggressive;
        break;
      }
      
      Options/*J*/= new org.llvm.target.target.TargetOptions();
      if (!TargetOpts.Reciprocals.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Options.Reciprocals = new TargetRecip(TargetOpts.Reciprocals));
        } finally {
          $c$.$destroy();
        }
      }
      
      Options.ThreadModel
         = new StringSwitch<ThreadModel.Model>(new StringRef(CodeGenOpts.ThreadModel)).
          Case(/*KEEP_STR*/"posix", ThreadModel.Model.POSIX).
          Case(/*KEEP_STR*/"single", ThreadModel.Model.Single).$T1();
      
      // Set float ABI type.
      assert (($eq_string$C_T$C$P(CodeGenOpts.FloatABI, /*KEEP_STR*/"soft") || $eq_string$C_T$C$P(CodeGenOpts.FloatABI, /*KEEP_STR*/"softfp") || $eq_string$C_T$C$P(CodeGenOpts.FloatABI, /*KEEP_STR*/"hard") || CodeGenOpts.FloatABI.empty())) : "Invalid Floating Point ABI!";
      Options.FloatABIType
         = new StringSwitch<FloatABI.ABIType>(new StringRef(CodeGenOpts.FloatABI)).
          Case(/*KEEP_STR*/"soft", FloatABI.ABIType.Soft).
          Case(/*KEEP_STR*/"softfp", FloatABI.ABIType.Soft).
          Case(/*KEEP_STR*/"hard", FloatABI.ABIType.Hard).
          Default(FloatABI.ABIType.Default);
      
      // Set FP fusion mode.
      switch (CodeGenOpts.getFPContractMode()) {
       case FPC_Off:
        Options.AllowFPOpFusion = FPOpFusion.FPOpFusionMode.Strict;
        break;
       case FPC_On:
        Options.AllowFPOpFusion = FPOpFusion.FPOpFusionMode.Standard;
        break;
       case FPC_Fast:
        Options.AllowFPOpFusion = FPOpFusion.FPOpFusionMode.Fast;
        break;
      }
      
      Options.UseInitArray = CodeGenOpts.UseInitArray;
      Options.DisableIntegratedAS = CodeGenOpts.DisableIntegratedAS;
      Options.CompressDebugSections = CodeGenOpts.CompressDebugSections;
      Options.RelaxELFRelocations = CodeGenOpts.RelaxELFRelocations;
      
      // Set EABI version.
      Options.EABIVersion = new StringSwitch<EABI>(new StringRef(TargetOpts.EABIVersion)).
          Case(/*KEEP_STR*/"4", EABI.EABI4).
          Case(/*KEEP_STR*/"5", EABI.EABI5).
          Case(/*KEEP_STR*/"gnu", EABI.GNU).
          Default(EABI.Default);
      if (LangOpts.SjLjExceptions) {
        Options.ExceptionModel = ExceptionHandling.SjLj;
      }
      
      Options.LessPreciseFPMADOption = CodeGenOpts.LessPreciseFPMAD;
      Options.NoInfsFPMath = CodeGenOpts.NoInfsFPMath;
      Options.NoNaNsFPMath = CodeGenOpts.NoNaNsFPMath;
      Options.NoZerosInBSS = CodeGenOpts.NoZeroInitializedInBSS;
      Options.UnsafeFPMath = CodeGenOpts.UnsafeFPMath;
      Options.StackAlignmentOverride = CodeGenOpts.StackAlignment;
      Options.FunctionSections = CodeGenOpts.FunctionSections;
      Options.DataSections = CodeGenOpts.DataSections;
      Options.UniqueSectionNames = CodeGenOpts.UniqueSectionNames;
      Options.EmulatedTLS = CodeGenOpts.EmulatedTLS;
      Options.DebuggerTuning = CodeGenOpts.getDebuggerTuning();
      
      Options.MCOptions.MCRelaxAll = CodeGenOpts.RelaxAll;
      Options.MCOptions.MCSaveTempLabels = CodeGenOpts.SaveTempLabels;
      Options.MCOptions.MCUseDwarfDirectory = !CodeGenOpts.NoDwarfDirectoryAsm;
      Options.MCOptions.MCNoExecStack = CodeGenOpts.NoExecStack;
      Options.MCOptions.MCIncrementalLinkerCompatible
         = CodeGenOpts.IncrementalLinkerCompatible;
      Options.MCOptions.MCFatalWarnings = CodeGenOpts.FatalWarnings;
      Options.MCOptions.AsmVerbose = CodeGenOpts.AsmVerbose;
      Options.MCOptions.ABIName.$assign(TargetOpts.ABI);
      
      TM.reset((TargetMachine)TheTarget.createTargetMachine(new StringRef(Triple.c_str()), new StringRef(TargetOpts.CPU), new StringRef(FeaturesStr), 
              Options, RM.$star(), CM, OptLevel));
    } finally {
      if (Options != null) { Options.$destroy(); }
    }
  }

  
  /// Add passes necessary to emit assembly or LLVM IR.
  ///
  /// \return True on success.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper::AddEmitPasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 612,
   FQN="(anonymous namespace)::EmitAssemblyHelper::AddEmitPasses", NM="_ZN12_GLOBAL__N_118EmitAssemblyHelper13AddEmitPassesERN4llvm6legacy11PassManagerEN5clang13BackendActionERNS1_17raw_pwrite_streamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_118EmitAssemblyHelper13AddEmitPassesERN4llvm6legacy11PassManagerEN5clang13BackendActionERNS1_17raw_pwrite_streamE")
  //</editor-fold>
  private boolean AddEmitPasses(final PassManager /*&*/ CodeGenPasses, 
               BackendAction Action, 
               final raw_pwrite_stream /*&*/ OS) {
    std.unique_ptr<TargetLibraryInfoImpl> TLII = null;
    try {
      // Add LibraryInfo.
      Triple TargetTriple/*J*/= new Triple(new Twine(TheModule.getTargetTriple()));
      TLII/*J*/= new std.unique_ptr<TargetLibraryInfoImpl>(createTLII(TargetTriple, CodeGenOpts));
      CodeGenPasses.add(new TargetLibraryInfoWrapperPass(TLII.$star()));
      
      // Normal mode, emit a .s or .o file by running the code generator. Note,
      // this also adds codegenerator level optimization passes.
      TargetMachine.CodeGenFileType CGFT = TargetMachine.CodeGenFileType.CGFT_AssemblyFile;
      if (Action == BackendAction.Backend_EmitObj) {
        CGFT = TargetMachine.CodeGenFileType.CGFT_ObjectFile;
      } else if (Action == BackendAction.Backend_EmitMCNull) {
        CGFT = TargetMachine.CodeGenFileType.CGFT_Null;
      } else {
        assert (Action == BackendAction.Backend_EmitAssembly) : "Invalid action!";
      }
      
      // Add ObjC ARC final-cleanup optimizations. This is done as part of the
      // "codegen" passes so that it isn't run multiple times when there is
      // inlining happening.
      if ($2bits_uint2uint(CodeGenOpts.OptimizationLevel) > 0) {
        CodeGenPasses.add(createObjCARCContractPass());
      }
      if (TM.$arrow().addPassesToEmitFile(CodeGenPasses, OS, CGFT, 
          /*DisableVerify=*/ !CodeGenOpts.VerifyModule)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diags.Report(diag.err_fe_unable_to_interface_with_target)));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
      
      return true;
    } finally {
      if (TLII != null) { TLII.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper::EmitAssemblyHelper">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 97,
   FQN="(anonymous namespace)::EmitAssemblyHelper::EmitAssemblyHelper", NM="_ZN12_GLOBAL__N_118EmitAssemblyHelperC1ERN5clang17DiagnosticsEngineERKNS1_14CodeGenOptionsERKNS1_13TargetOptionsERKNS1_11LangOptionsEPN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_118EmitAssemblyHelperC1ERN5clang17DiagnosticsEngineERKNS1_14CodeGenOptionsERKNS1_13TargetOptionsERKNS1_11LangOptionsEPN4llvm6ModuleE")
  //</editor-fold>
  public EmitAssemblyHelper(final DiagnosticsEngine /*&*/ _Diags, final /*const*/ CodeGenOptions /*&*/ CGOpts, 
      final /*const*/ org.clang.basic.target.TargetOptions /*&*/ TOpts, 
      final /*const*/ LangOptions /*&*/ LOpts, org.llvm.ir.Module /*P*/ M) {
    // : Diags(_Diags), CodeGenOpts(CGOpts), TargetOpts(TOpts), LangOpts(LOpts), TheModule(M), CodeGenerationTime("Code Generation Time"), OS(), TM() 
    //START JInit
    this./*&*/Diags=/*&*/_Diags;
    this./*&*/CodeGenOpts=/*&*/CGOpts;
    this./*&*/TargetOpts=/*&*/TOpts;
    this./*&*/LangOpts=/*&*/LOpts;
    this.TheModule = M;
    this.CodeGenerationTime = new Timer(new StringRef(/*KEEP_STR*/"Code Generation Time"));
    this.OS = new std.unique_ptr<raw_pwrite_stream>();
    this.TM = new std.unique_ptr<TargetMachine>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper::~EmitAssemblyHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 103,
   FQN="(anonymous namespace)::EmitAssemblyHelper::~EmitAssemblyHelper", NM="_ZN12_GLOBAL__N_118EmitAssemblyHelperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_118EmitAssemblyHelperD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (CodeGenOpts.DisableFree) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        BuryPointer$T($c$.track(new std.unique_ptr<TargetMachine>(JD$Move.INSTANCE, std.move(TM)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    //START JDestroy
    TM.$destroy();
    OS.$destroy();
    CodeGenerationTime.$destroy();
    //END JDestroy
  }

  
  public std.unique_ptr<TargetMachine> TM;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmitAssemblyHelper::EmitAssembly">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 646,
   FQN="(anonymous namespace)::EmitAssemblyHelper::EmitAssembly", NM="_ZN12_GLOBAL__N_118EmitAssemblyHelper12EmitAssemblyEN5clang13BackendActionESt10unique_ptrIN4llvm17raw_pwrite_streamESt14default_deleteIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_118EmitAssemblyHelper12EmitAssemblyEN5clang13BackendActionESt10unique_ptrIN4llvm17raw_pwrite_streamESt14default_deleteIS5_EE")
  //</editor-fold>
  public void EmitAssembly(BackendAction Action, 
              std.unique_ptr<raw_pwrite_stream> OS) {
    TimeRegion Region = null;
    std.unique_ptr<ModuleSummaryIndex> ModuleSummary = null;
    PassManager PerModulePasses = null;
    FunctionPassManager PerFunctionPasses = null;
    PassManager CodeGenPasses = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Region/*J*/= new TimeRegion(JD$Timer$P.INSTANCE, TimePassesIsEnabled ? /*AddrOf*/CodeGenerationTime : (Timer /*P*/ )null);
      
      setCommandLineOpts();
      
      boolean UsesCodeGen = (Action != BackendAction.Backend_EmitNothing
         && Action != BackendAction.Backend_EmitBC
         && Action != BackendAction.Backend_EmitLL);
      CreateTargetMachine(UsesCodeGen);
      if (UsesCodeGen && !TM.$bool()) {
        return;
      }
      if (TM.$bool()) {
        TheModule.setDataLayout($c$.track(TM.$arrow().createDataLayout())); $c$.clean();
      }
      
      // If we are performing a ThinLTO importing compile, load the function
      // index into memory and pass it into CreatePasses, which will add it
      // to the PassManagerBuilder and invoke LTO passes.
      ModuleSummary/*J*/= new std.unique_ptr<ModuleSummaryIndex>();
      if (!CodeGenOpts.ThinLTOIndexFile.empty()) {
        ErrorOr<std.unique_ptr<ModuleSummaryIndex> > IndexOrErr = null;
        try {
          IndexOrErr = getModuleSummaryIndexForFile(new StringRef(CodeGenOpts.ThinLTOIndexFile), /*FuncArg*//*[&, this]*/ (final /*const*/ DiagnosticInfo /*&*/ DI) -> {
                    TheModule.getContext().diagnose(DI);
                  });
          {
            std.error_code EC = IndexOrErr.getError();
            if (EC.$bool()) {
              std.string Error = EC.message();
              errs().$out(/*KEEP_STR*/"Error loading index file '").$out(CodeGenOpts.ThinLTOIndexFile).$out(
                  /*KEEP_STR*/"': "
              ).$out(Error).$out(/*KEEP_STR*/$LF);
              return;
            }
          }
          ModuleSummary.$assignMove(std.move(IndexOrErr.get()));
          assert (ModuleSummary.$bool()) : "Expected non-empty module summary index";
        } finally {
          if (IndexOrErr != null) { IndexOrErr.$destroy(); }
        }
      }
      
      PerModulePasses/*J*/= new PassManager();
      PerModulePasses.add(AnalysisLlvmGlobals.createTargetTransformInfoWrapperPass($c$.track(getTargetIRAnalysis()))); $c$.clean();
      
      PerFunctionPasses/*J*/= new FunctionPassManager(TheModule);
      PerFunctionPasses.add(AnalysisLlvmGlobals.createTargetTransformInfoWrapperPass($c$.track(getTargetIRAnalysis()))); $c$.clean();
      
      CreatePasses(PerModulePasses, PerFunctionPasses, ModuleSummary.get());
      
      CodeGenPasses/*J*/= new PassManager();
      CodeGenPasses.add(AnalysisLlvmGlobals.createTargetTransformInfoWrapperPass($c$.track(getTargetIRAnalysis()))); $c$.clean();
      switch (Action) {
       case Backend_EmitNothing:
        break;
       case Backend_EmitBC:
        PerModulePasses.add(BitcodeLlvmGlobals.createBitcodeWriterPass(OS.$star(), CodeGenOpts.EmitLLVMUseLists, CodeGenOpts.EmitSummaryIndex, 
                CodeGenOpts.EmitSummaryIndex));
        break;
       case Backend_EmitLL:
        PerModulePasses.add(createPrintModulePass(OS.$star(), new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY), CodeGenOpts.EmitLLVMUseLists));
        break;
       default:
        if (!AddEmitPasses(CodeGenPasses, Action, OS.$star())) {
          return;
        }
      }
      
      // Before executing passes, print the final values of the LLVM options.
      ClGlobals.PrintOptionValues();
      {
        PrettyStackTraceString CrashInfo = null;
        try {
          CrashInfo/*J*/= new PrettyStackTraceString($("Per-function optimization"));
          
          PerFunctionPasses.doInitialization();
          for (final Function /*&*/ F : /*Deref*/TheModule)  {
            if (!F.isDeclaration()) {
              PerFunctionPasses.run(F);
            }
          }
          PerFunctionPasses.doFinalization();
        } finally {
          if (CrashInfo != null) { CrashInfo.$destroy(); }
        }
      }
      {
        PrettyStackTraceString CrashInfo = null;
        try {
          CrashInfo/*J*/= new PrettyStackTraceString($("Per-module optimization passes"));
          PerModulePasses.run(/*Deref*/TheModule);
        } finally {
          if (CrashInfo != null) { CrashInfo.$destroy(); }
        }
      }
      {
        PrettyStackTraceString CrashInfo = null;
        try {
          CrashInfo/*J*/= new PrettyStackTraceString($("Code generation"));
          CodeGenPasses.run(/*Deref*/TheModule);
        } finally {
          if (CrashInfo != null) { CrashInfo.$destroy(); }
        }
      }
    } finally {
      if (CodeGenPasses != null) { CodeGenPasses.$destroy(); }
      if (PerFunctionPasses != null) { PerFunctionPasses.$destroy(); }
      if (PerModulePasses != null) { PerModulePasses.$destroy(); }
      if (ModuleSummary != null) { ModuleSummary.$destroy(); }
      if (Region != null) { Region.$destroy(); }
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", CodeGenOpts=" + CodeGenOpts // NOI18N
              + ", TargetOpts=" + TargetOpts // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", TheModule=" + TheModule // NOI18N
              + ", CodeGenerationTime=" + CodeGenerationTime // NOI18N
              + ", OS=" + OS // NOI18N
              + ", TM=" + TM; // NOI18N
  }
}
