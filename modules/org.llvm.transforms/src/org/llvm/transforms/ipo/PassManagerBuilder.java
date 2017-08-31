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

package org.llvm.transforms.ipo;

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
import org.llvm.adt.*;
import static org.llvm.analysis.AnalysisLlvmGlobals.*;
import org.llvm.analysis.target.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.llvmc.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;
import org.llvm.pass.*;
import static org.llvm.pass.IrLlvmGlobals.createVerifierPass;
import org.llvm.target.target.*;
import org.llvm.transforms.ipo.impl.*;
import static org.llvm.transforms.ipo.impl.PassManagerBuilderStatics.*;
import org.llvm.transforms.java.TransformDummies.*;


/// PassManagerBuilder - This class is used to set up a standard optimization
/// sequence for languages like C and C++, allowing some APIs to customize the
/// pass sequence in various ways. A simple example of using it would be:
///
///  PassManagerBuilder Builder;
///  Builder.OptLevel = 2;
///  Builder.populateFunctionPassManager(FPM);
///  Builder.populateModulePassManager(MPM);
///
/// In addition to setting up the basic passes, PassManagerBuilder allows
/// frontends to vend a plugin API, where plugins are allowed to add extensions
/// to the default pass manager.  They do this by specifying where in the pass
/// pipeline they want to be added, along with a callback function that adds
/// the pass(es).  For example, a plugin that wanted to add a loop optimization
/// could do something like this:
///
/// static void addMyLoopPass(const PMBuilder &Builder, PassManagerBase &PM) {
///   if (Builder.getOptLevel() > 2 && Builder.getOptSizeLevel() == 0)
///     PM.add(createMyAwesomePass());
/// }
///   ...
///   Builder.addExtension(PassManagerBuilder::EP_LoopOptimizerEnd,
///                        addMyLoopPass);
///   ...
//<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/IPO/PassManagerBuilder.h", line = 59,
 FQN="llvm::PassManagerBuilder", NM="_ZN4llvm18PassManagerBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilderE")
//</editor-fold>
public class PassManagerBuilder implements LLVMOpaquePassManagerBuilder, Destructors.ClassWithDestructor {
/*public:*/
  /// Extensions are passed the builder itself (so they can see how it is
  /// configured) as well as the pass manager to add stuff to.
  // JAVA: typedef std::function<void (const PassManagerBuilder &, legacy::PassManagerBase &)> ExtensionFn
//  public final class ExtensionFn extends ExtensionFn{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::ExtensionPointTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/IPO/PassManagerBuilder.h", line = 66,
   FQN="llvm::PassManagerBuilder::ExtensionPointTy", NM="_ZN4llvm18PassManagerBuilder16ExtensionPointTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder16ExtensionPointTyE")
  //</editor-fold>
  public enum ExtensionPointTy implements Native.NativeUIntEnum {
    /// EP_EarlyAsPossible - This extension point allows adding passes before
    /// any other transformations, allowing them to see the code as it is coming
    /// out of the frontend.
    EP_EarlyAsPossible(0),

    /// EP_ModuleOptimizerEarly - This extension point allows adding passes
    /// just before the main module-level optimization passes.
    EP_ModuleOptimizerEarly(EP_EarlyAsPossible.getValue() + 1),

    /// EP_LoopOptimizerEnd - This extension point allows adding loop passes to
    /// the end of the loop optimizer.
    EP_LoopOptimizerEnd(EP_ModuleOptimizerEarly.getValue() + 1),

    /// EP_ScalarOptimizerLate - This extension point allows adding optimization
    /// passes after most of the main optimizations, but before the last
    /// cleanup-ish optimizations.
    EP_ScalarOptimizerLate(EP_LoopOptimizerEnd.getValue() + 1),

    /// EP_OptimizerLast -- This extension point allows adding passes that
    /// run after everything else.
    EP_OptimizerLast(EP_ScalarOptimizerLate.getValue() + 1),

    /// EP_VectorizerStart - This extension point allows adding optimization
    /// passes before the vectorizer and other highly target specific
    /// optimization passes are executed.
    EP_VectorizerStart(EP_OptimizerLast.getValue() + 1),

    /// EP_EnabledOnOptLevel0 - This extension point allows adding passes that
    /// should not be disabled by O0 optimization level. The passes will be
    /// inserted after the inlining pass.
    EP_EnabledOnOptLevel0(EP_VectorizerStart.getValue() + 1),

    /// EP_Peephole - This extension point allows adding passes that perform
    /// peephole optimizations similar to the instruction combiner. These passes
    /// will be inserted after each instance of the instruction combiner pass.
    EP_Peephole(EP_EnabledOnOptLevel0.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ExtensionPointTy valueOf(int val) {
      ExtensionPointTy out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ExtensionPointTy[] VALUES;
      private static final ExtensionPointTy[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ExtensionPointTy kind : ExtensionPointTy.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ExtensionPointTy[min < 0 ? (1-min) : 0];
        VALUES = new ExtensionPointTy[max >= 0 ? (1+max) : 0];
        for (ExtensionPointTy kind : ExtensionPointTy.values()) {
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
    private ExtensionPointTy(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };

  /// The Optimization Level - Specify the basic optimization level.
  ///    0 = -O0, 1 = -O1, 2 = -O2, 3 = -O3
  public /*uint*/int OptLevel;

  /// SizeLevel - How much we're optimizing for size.
  ///    0 = none, 1 = -Os, 2 = -Oz
  public /*uint*/int SizeLevel;

  /// LibraryInfo - Specifies information about the runtime library for the
  /// optimizer.  If this is non-null, it is added to both the function and
  /// per-module pass pipeline.
  public TargetLibraryInfoImpl /*P*/ LibraryInfo;

  /// Inliner - Specifies the inliner to use.  If this is non-null, it is
  /// added to the per-module passes.
  public Pass /*P*/ Inliner;

  /// The module summary index to use for function importing.
  public /*const*/ ModuleSummaryIndex /*P*/ ModuleSummary;

  public boolean DisableTailCalls;
  public boolean DisableUnitAtATime;
  public boolean DisableUnrollLoops;
  public boolean BBVectorize;
  public boolean SLPVectorize;
  public boolean LoopVectorize;
  public boolean RerollLoops;
  public boolean LoadCombine;
  public boolean DisableGVNLoadPRE;
  public boolean VerifyInput;
  public boolean VerifyOutput;
  public boolean MergeFunctions;
  public boolean PrepareForLTO;
  public boolean PrepareForThinLTO;
  public boolean PerformThinLTO;

  /// Profile data file name that the instrumentation will be written to.
  public std.string PGOInstrGen;
  /// Path of the profile data file.
  public std.string PGOInstrUse;
/*private:*/
  /// ExtensionList - This is list of all of the extensions that are registered.
  private std.vector<std.pairTypeType<ExtensionPointTy, ExtensionFn>> Extensions;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::PassManagerBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 141,
   FQN="llvm::PassManagerBuilder::PassManagerBuilder", NM="_ZN4llvm18PassManagerBuilderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilderC1Ev")
  //</editor-fold>
  public PassManagerBuilder() {
    // : PGOInstrGen(), PGOInstrUse(), Extensions()
    //START JInit
    this.PGOInstrGen = new std.string();
    this.PGOInstrUse = new std.string();
    this.Extensions = new std.vector<std.pairTypeType<ExtensionPointTy, ExtensionFn>>(new std.pairTypeType<ExtensionPointTy, ExtensionFn>());
    //END JInit
    OptLevel = 2;
    SizeLevel = 0;
    LibraryInfo = null;
    Inliner = null;
    ModuleSummary = null;
    DisableUnitAtATime = false;
    DisableUnrollLoops = false;
    BBVectorize = PassManagerBuilderStatics.RunBBVectorization.$T();
    SLPVectorize = PassManagerBuilderStatics.RunSLPVectorization.$T();
    LoopVectorize = PassManagerBuilderStatics.RunLoopVectorization.$T();
    RerollLoops = PassManagerBuilderStatics.RunLoopRerolling.$T();
    LoadCombine = PassManagerBuilderStatics.RunLoadCombine.$T();
    DisableGVNLoadPRE = false;
    VerifyInput = false;
    VerifyOutput = false;
    MergeFunctions = false;
    PrepareForLTO = false;
    PGOInstrGen.$assign(RunPGOInstrGen.$DataType());
    PGOInstrUse.$assign(RunPGOInstrUse.$DataType());
    PrepareForThinLTO = false;
    PerformThinLTO = false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::~PassManagerBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 165,
   FQN="llvm::PassManagerBuilder::~PassManagerBuilder", NM="_ZN4llvm18PassManagerBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilderD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (LibraryInfo != null) { LibraryInfo.$destroy();};
    if (Inliner != null) { Inliner.$destroy();};
    //START JDestroy
    Extensions.$destroy();
    PGOInstrUse.$destroy();
    PGOInstrGen.$destroy();
    //END JDestroy
  }

  /// Adds an extension that will be used by all PassManagerBuilder instances.
  /// This is intended to be used by plugins, to register a set of
  /// optimisations to run automatically.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addGlobalExtension">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 174,
   FQN="llvm::PassManagerBuilder::addGlobalExtension", NM="_ZN4llvm18PassManagerBuilder18addGlobalExtensionENS0_16ExtensionPointTyESt8functionIFvRKS0_RNS_6legacy15PassManagerBaseEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder18addGlobalExtensionENS0_16ExtensionPointTyESt8functionIFvRKS0_RNS_6legacy15PassManagerBaseEEE")
  //</editor-fold>
  public static void addGlobalExtension(PassManagerBuilder.ExtensionPointTy Ty,
                    ExtensionFn Fn) {
    PassManagerBuilderStatics.GlobalExtensions.$arrow().push_back_T$RR(std.make_pair_E_T(Ty, std.move(Fn)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addExtension">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 180,
   FQN="llvm::PassManagerBuilder::addExtension", NM="_ZN4llvm18PassManagerBuilder12addExtensionENS0_16ExtensionPointTyESt8functionIFvRKS0_RNS_6legacy15PassManagerBaseEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder12addExtensionENS0_16ExtensionPointTyESt8functionIFvRKS0_RNS_6legacy15PassManagerBaseEEE")
  //</editor-fold>
  public void addExtension(ExtensionPointTy Ty, ExtensionFn Fn) {
    Extensions.push_back_T$RR(std.make_pair_E_T(Ty, std.move(Fn)));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addExtensionsToPM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 184,
   FQN="llvm::PassManagerBuilder::addExtensionsToPM", NM="_ZNK4llvm18PassManagerBuilder17addExtensionsToPMENS0_16ExtensionPointTyERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZNK4llvm18PassManagerBuilder17addExtensionsToPMENS0_16ExtensionPointTyERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  private void addExtensionsToPM(ExtensionPointTy ETy,
                   final PassManagerBase /*&*/ PM) /*const*/ {
    for (/*uint*/int i = 0, e = PassManagerBuilderStatics.GlobalExtensions.$arrow().size(); i != e; ++i)  {
      if ((PassManagerBuilderStatics.GlobalExtensions.$star()).$at(i).first == ETy) {
        (PassManagerBuilderStatics.GlobalExtensions.$star()).$at(i).second.$call(/*Deref*/this, PM);
      }
    }
    for (/*uint*/int i = 0, e = Extensions.size(); i != e; ++i)  {
      if (Extensions.$at$Const(i).first == ETy) {
        Extensions.$at$Const(i).second.$call(/*Deref*/this, PM);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addInitialAliasAnalysisPasses">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 194,
   FQN="llvm::PassManagerBuilder::addInitialAliasAnalysisPasses", NM="_ZNK4llvm18PassManagerBuilder29addInitialAliasAnalysisPassesERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZNK4llvm18PassManagerBuilder29addInitialAliasAnalysisPassesERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  private void addInitialAliasAnalysisPasses(final PassManagerBase /*&*/ PM) /*const*/ {
    switch (PassManagerBuilderStatics.UseCFLAA.$T()) {
     case Steensgaard:
      PM.add(createCFLSteensAAWrapperPass());
      break;
     case Andersen:
      PM.add(createCFLAndersAAWrapperPass());
      break;
     case Both:
      PM.add(createCFLSteensAAWrapperPass());
      PM.add(createCFLAndersAAWrapperPass());
      break;
     default:
      break;
    }

    // Add TypeBasedAliasAnalysis before BasicAliasAnalysis so that
    // BasicAliasAnalysis wins if they disagree. This is intended to help
    // support "obvious" type-punning idioms.
    PM.add(createTypeBasedAAWrapperPass());
    PM.add(createScopedNoAliasAAWrapperPass());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addLTOOptimizationPasses">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 615,
   FQN="llvm::PassManagerBuilder::addLTOOptimizationPasses", NM="_ZN4llvm18PassManagerBuilder24addLTOOptimizationPassesERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder24addLTOOptimizationPassesERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  private void addLTOOptimizationPasses(final PassManagerBase /*&*/ PM) {
    // Remove unused virtual tables to improve the quality of code generated by
    // whole-program devirtualization and bitset lowering.
    PM.add(TransformsLlvmGlobals.createGlobalDCEPass());

    // Provide AliasAnalysis services for optimizations.
    addInitialAliasAnalysisPasses(PM);
    if ((ModuleSummary != null)) {
      PM.add(TransformsLlvmGlobals.createFunctionImportPass(ModuleSummary));
    }

    // Allow forcing function attributes as a debugging and tuning aid.
    PM.add(TransformsLlvmGlobals.createForceFunctionAttrsLegacyPass());

    // Infer attributes about declarations if possible.
    PM.add(TransformsLlvmGlobals.createInferFunctionAttrsLegacyPass());
    if ($greater_uint(OptLevel, 1)) {
      // Indirect call promotion. This should promote all the targets that are
      // left by the earlier promotion pass that promotes intra-module targets.
      // This two-step promotion is to save the compile time. For LTO, it should
      // produce the same result as if we only do promotion here.
      PM.add(TransformsLlvmGlobals.createPGOIndirectCallPromotionLegacyPass(true));

      // Propagate constants at call sites into the functions they call.  This
      // opens opportunities for globalopt (and inlining) by substituting function
      // pointers passed as arguments to direct uses of functions.
      PM.add(TransformsLlvmGlobals.createIPSCCPPass());
    }

    // Infer attributes about definitions. The readnone attribute in particular is
    // required for virtual constant propagation.
    PM.add(TransformsLlvmGlobals.createPostOrderFunctionAttrsLegacyPass());
    PM.add(TransformsLlvmGlobals.createReversePostOrderFunctionAttrsPass());

    // Apply whole-program devirtualization and virtual constant propagation.
    PM.add(TransformsLlvmGlobals.createWholeProgramDevirtPass());

    // That's all we need at opt level 1.
    if (OptLevel == 1) {
      return;
    }

    // Now that we internalized some globals, see if we can hack on them!
    PM.add(TransformsLlvmGlobals.createGlobalOptimizerPass());
    // Promote any localized global vars.
    PM.add(TransformsLlvmGlobals.createPromoteMemoryToRegisterPass());

    // Linking modules together can lead to duplicated global constants, only
    // keep one copy of each constant.
    PM.add(TransformsLlvmGlobals.createConstantMergePass());

    // Remove unused arguments from functions.
    PM.add(TransformsLlvmGlobals.createDeadArgEliminationPass());

    // Reduce the code after globalopt and ipsccp.  Both can open up significant
    // simplification opportunities, and both can propagate functions through
    // function pointers.  When this happens, we often have to resolve varargs
    // calls, etc, so let instcombine do this.
    addInstructionCombiningPass(PM);
    addExtensionsToPM(ExtensionPointTy.EP_Peephole, PM);

    // Inline small functions
    boolean RunInliner = (Inliner != null);
    if (RunInliner) {
      PM.add(Inliner);
      Inliner = null;
    }

    PM.add(TransformsLlvmGlobals.createPruneEHPass()); // Remove dead EH info.

    // Optimize globals again if we ran the inliner.
    if (RunInliner) {
      PM.add(TransformsLlvmGlobals.createGlobalOptimizerPass());
    }
    PM.add(TransformsLlvmGlobals.createGlobalDCEPass()); // Remove dead functions.

    // If we didn't decide to inline a function, check to see if we can
    // transform it to pass arguments by value instead of by reference.
    PM.add(TransformsLlvmGlobals.createArgumentPromotionPass());

    // The IPO passes may leave cruft around.  Clean up after them.
    addInstructionCombiningPass(PM);
    addExtensionsToPM(ExtensionPointTy.EP_Peephole, PM);
    PM.add(TransformsLlvmGlobals.createJumpThreadingPass());

    // Break up allocas
    PM.add(TransformsLlvmGlobals.createSROAPass());

    // Run a few AA driven optimizations here and now, to cleanup the code.
    PM.add(TransformsLlvmGlobals.createPostOrderFunctionAttrsLegacyPass()); // Add nocapture.
    PM.add(createGlobalsAAWrapperPass()); // IP alias analysis.

    PM.add(TransformsLlvmGlobals.createLICMPass()); // Hoist loop invariants.
    if (PassManagerBuilderStatics.EnableMLSM.$T()) {
      PM.add(TransformsLlvmGlobals.createMergedLoadStoreMotionPass()); // Merge ld/st in diamonds.
    }
    PM.add(TransformsLlvmGlobals.createGVNPass(DisableGVNLoadPRE)); // Remove redundancies.
    PM.add(TransformsLlvmGlobals.createMemCpyOptPass()); // Remove dead memcpys.

    // Nuke dead stores.
    PM.add(TransformsLlvmGlobals.createDeadStoreEliminationPass());

    // More loops are countable; try to optimize them.
    PM.add(TransformsLlvmGlobals.createIndVarSimplifyPass());
    PM.add(TransformsLlvmGlobals.createLoopDeletionPass());
    if (PassManagerBuilderStatics.EnableLoopInterchange.$T()) {
      PM.add(TransformsLlvmGlobals.createLoopInterchangePass());
    }
    if (!DisableUnrollLoops) {
      PM.add(TransformsLlvmGlobals.createSimpleLoopUnrollPass()); // Unroll small loops
    }
    PM.add(TransformsLlvmGlobals.createLoopVectorizePass(true, LoopVectorize));
    // The vectorizer may have significantly shortened a loop body; unroll again.
    if (!DisableUnrollLoops) {
      PM.add(TransformsLlvmGlobals.createLoopUnrollPass());
    }

    // Now that we've optimized loops (in particular loop induction variables),
    // we may have exposed more scalar opportunities. Run parts of the scalar
    // optimizer again at this point.
    addInstructionCombiningPass(PM); // Initial cleanup
    PM.add(TransformsLlvmGlobals.createCFGSimplificationPass()); // if-convert
    PM.add(TransformsLlvmGlobals.createSCCPPass()); // Propagate exposed constants
    addInstructionCombiningPass(PM); // Clean up again
    PM.add(TransformsLlvmGlobals.createBitTrackingDCEPass());

    // More scalar chains could be vectorized due to more alias information
    if (PassManagerBuilderStatics.RunSLPAfterLoopVectorization.$T()) {
      if (SLPVectorize) {
        PM.add(TransformsLlvmGlobals.createSLPVectorizerPass()); // Vectorize parallel scalar chains.
      }
    }

    // After vectorization, assume intrinsics may tell us more about pointer
    // alignments.
    PM.add(TransformsLlvmGlobals.createAlignmentFromAssumptionsPass());
    if (LoadCombine) {
      PM.add(TransformsLlvmGlobals.createLoadCombinePass());
    }

    // Cleanup and simplify the code after the scalar optimizations.
    addInstructionCombiningPass(PM);
    addExtensionsToPM(ExtensionPointTy.EP_Peephole, PM);

    PM.add(TransformsLlvmGlobals.createJumpThreadingPass());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addLateLTOOptimizationPasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 756,
   FQN="llvm::PassManagerBuilder::addLateLTOOptimizationPasses", NM="_ZN4llvm18PassManagerBuilder28addLateLTOOptimizationPassesERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder28addLateLTOOptimizationPassesERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  private void addLateLTOOptimizationPasses(final PassManagerBase /*&*/ PM) {
    // Delete basic blocks, which optimization passes may have killed.
    PM.add(TransformsLlvmGlobals.createCFGSimplificationPass());

    // Drop bodies of available externally objects to improve GlobalDCE.
    PM.add(TransformsLlvmGlobals.createEliminateAvailableExternallyPass());

    // Now that we have optimized the program, discard unreachable functions.
    PM.add(TransformsLlvmGlobals.createGlobalDCEPass());

    // FIXME: this is profitable (for compiler time) to do at -O0 too, but
    // currently it damages debug info.
    if (MergeFunctions) {
      PM.add(TransformsLlvmGlobals.createMergeFunctionsPass());
    }
  }


  // Do PGO instrumentation generation or use pass as the option specified.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addPGOInstrPasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 245,
   FQN="llvm::PassManagerBuilder::addPGOInstrPasses", NM="_ZN4llvm18PassManagerBuilder17addPGOInstrPassesERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder17addPGOInstrPassesERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  private void addPGOInstrPasses(final PassManagerBase /*&*/ MPM) {
    if (PGOInstrGen.empty() && PGOInstrUse.empty()) {
      return;
    }
    // Perform the preinline and cleanup passes for O1 and above.
    // And avoid doing them if optimizing for size.
    if ($greater_uint(OptLevel, 0) && SizeLevel == 0 && !PassManagerBuilderStatics.DisablePreInliner.$T()) {
      // Create preinline pass.
      MPM.add(TransformsLlvmGlobals.createFunctionInliningPass(PassManagerBuilderStatics.PreInlineThreshold.$T()));
      MPM.add(TransformsLlvmGlobals.createSROAPass());
      MPM.add(TransformsLlvmGlobals.createEarlyCSEPass()); // Catch trivial redundancies
      MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass()); // Merge & remove BBs
      MPM.add(TransformsLlvmGlobals.createInstructionCombiningPass()); // Combine silly seq's
      addExtensionsToPM(ExtensionPointTy.EP_Peephole, MPM);
    }
    if (!PGOInstrGen.empty()) {
      InstrProfOptions Options = null;
      try {
        MPM.add(TransformsLlvmGlobals.createPGOInstrumentationGenLegacyPass());
        // Add the profile lowering pass.
        Options/*J*/= new InstrProfOptions();
        Options.InstrProfileOutput.$assign(PGOInstrGen);
        MPM.add(TransformsLlvmGlobals.createInstrProfilingLegacyPass(Options));
      } finally {
        if (Options != null) { Options.$destroy(); }
      }
    }
    if (!PGOInstrUse.empty()) {
      MPM.add(TransformsLlvmGlobals.createPGOInstrumentationUseLegacyPass(new StringRef(PGOInstrUse)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addFunctionSimplificationPasses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 269,
   FQN="llvm::PassManagerBuilder::addFunctionSimplificationPasses", NM="_ZN4llvm18PassManagerBuilder31addFunctionSimplificationPassesERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder31addFunctionSimplificationPassesERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  private void addFunctionSimplificationPasses(final PassManagerBase /*&*/ MPM) {
    // Start of function pass.
    // Break up aggregate allocas, using SSAUpdater.
    MPM.add(TransformsLlvmGlobals.createSROAPass());
    MPM.add(TransformsLlvmGlobals.createEarlyCSEPass()); // Catch trivial redundancies
    // Speculative execution if the target has divergent branches; otherwise nop.
    MPM.add(TransformsLlvmGlobals.createSpeculativeExecutionIfHasBranchDivergencePass());
    MPM.add(TransformsLlvmGlobals.createJumpThreadingPass()); // Thread jumps.
    MPM.add(TransformsLlvmGlobals.createCorrelatedValuePropagationPass()); // Propagate conditionals
    MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass()); // Merge & remove BBs
    // Combine silly seq's
    addInstructionCombiningPass(MPM);
    addExtensionsToPM(ExtensionPointTy.EP_Peephole, MPM);

    MPM.add(TransformsLlvmGlobals.createTailCallEliminationPass()); // Eliminate tail calls
    MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass()); // Merge & remove BBs
    MPM.add(TransformsLlvmGlobals.createReassociatePass()); // Reassociate expressions
    // Rotate Loop - disable header duplication at -Oz
    MPM.add(TransformsLlvmGlobals.createLoopRotatePass(SizeLevel == 2 ? 0 : -1));
    MPM.add(TransformsLlvmGlobals.createLICMPass()); // Hoist loop invariants
    MPM.add(TransformsLlvmGlobals.createLoopUnswitchPass((SizeLevel != 0) || $less_uint(OptLevel, 3)));
    MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass());
    addInstructionCombiningPass(MPM);
    MPM.add(TransformsLlvmGlobals.createIndVarSimplifyPass()); // Canonicalize indvars
    MPM.add(TransformsLlvmGlobals.createLoopIdiomPass()); // Recognize idioms like memset.
    MPM.add(TransformsLlvmGlobals.createLoopDeletionPass()); // Delete dead loops
    if (PassManagerBuilderStatics.EnableLoopInterchange.$T()) {
      MPM.add(TransformsLlvmGlobals.createLoopInterchangePass()); // Interchange loops
      MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass());
    }
    if (!DisableUnrollLoops) {
      MPM.add(TransformsLlvmGlobals.createSimpleLoopUnrollPass()); // Unroll small loops
    }
    addExtensionsToPM(ExtensionPointTy.EP_LoopOptimizerEnd, MPM);
    if ($greater_uint(OptLevel, 1)) {
      if (PassManagerBuilderStatics.EnableMLSM.$T()) {
        MPM.add(TransformsLlvmGlobals.createMergedLoadStoreMotionPass()); // Merge ld/st in diamonds
      }
      MPM.add(TransformsLlvmGlobals.createGVNPass(DisableGVNLoadPRE)); // Remove redundancies
    }
    MPM.add(TransformsLlvmGlobals.createMemCpyOptPass()); // Remove memcpy / form memset
    MPM.add(TransformsLlvmGlobals.createSCCPPass()); // Constant prop with SCCP

    // Delete dead bit computations (instcombine runs after to fold away the dead
    // computations, and then ADCE will run later to exploit any new DCE
    // opportunities that creates).
    MPM.add(TransformsLlvmGlobals.createBitTrackingDCEPass()); // Delete dead bit computations

    // Run instcombine after redundancy elimination to exploit opportunities
    // opened up by them.
    addInstructionCombiningPass(MPM);
    addExtensionsToPM(ExtensionPointTy.EP_Peephole, MPM);
    MPM.add(TransformsLlvmGlobals.createJumpThreadingPass()); // Thread jumps
    MPM.add(TransformsLlvmGlobals.createCorrelatedValuePropagationPass());
    MPM.add(TransformsLlvmGlobals.createDeadStoreEliminationPass()); // Delete dead stores
    MPM.add(TransformsLlvmGlobals.createLICMPass());

    addExtensionsToPM(ExtensionPointTy.EP_ScalarOptimizerLate, MPM);
    if (RerollLoops) {
      MPM.add(TransformsLlvmGlobals.createLoopRerollPass());
    }
    if (!PassManagerBuilderStatics.RunSLPAfterLoopVectorization.$T()) {
      if (SLPVectorize) {
        MPM.add(TransformsLlvmGlobals.createSLPVectorizerPass()); // Vectorize parallel scalar chains.
      }
      if (BBVectorize) {
        MPM.add(TransformsLlvmGlobals.createBBVectorizePass());
        addInstructionCombiningPass(MPM);
        addExtensionsToPM(ExtensionPointTy.EP_Peephole, MPM);
        if ($greater_uint(OptLevel, 1) && PassManagerBuilderStatics.UseGVNAfterVectorization.$T()) {
          MPM.add(TransformsLlvmGlobals.createGVNPass(DisableGVNLoadPRE)); // Remove redundancies
        } else {
          MPM.add(TransformsLlvmGlobals.createEarlyCSEPass()); // Catch trivial redundancies
        }

        // BBVectorize may have significantly shortened a loop body; unroll again.
        if (!DisableUnrollLoops) {
          MPM.add(TransformsLlvmGlobals.createLoopUnrollPass());
        }
      }
    }
    if (LoadCombine) {
      MPM.add(TransformsLlvmGlobals.createLoadCombinePass());
    }

    MPM.add(TransformsLlvmGlobals.createAggressiveDCEPass()); // Delete dead instructions
    MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass()); // Merge & remove BBs
    // Clean up after everything.
    addInstructionCombiningPass(MPM);
    addExtensionsToPM(ExtensionPointTy.EP_Peephole, MPM);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::addInstructionCombiningPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 218,
   FQN="llvm::PassManagerBuilder::addInstructionCombiningPass", NM="_ZNK4llvm18PassManagerBuilder27addInstructionCombiningPassERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZNK4llvm18PassManagerBuilder27addInstructionCombiningPassERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  private void addInstructionCombiningPass(final PassManagerBase /*&*/ PM) /*const*/ {
    boolean ExpensiveCombines = $greater_uint(OptLevel, 2);
    PM.add(TransformsLlvmGlobals.createInstructionCombiningPass(ExpensiveCombines));
  }

/*public:*/
  /// populateFunctionPassManager - This fills in the function pass manager,
  /// which is expected to be run on each function immediately as it is
  /// generated.  The idea is to reduce the size of the IR in memory.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::populateFunctionPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 224,
   FQN="llvm::PassManagerBuilder::populateFunctionPassManager", NM="_ZN4llvm18PassManagerBuilder27populateFunctionPassManagerERNS_6legacy19FunctionPassManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder27populateFunctionPassManagerERNS_6legacy19FunctionPassManagerE")
  //</editor-fold>
  public void populateFunctionPassManager(final FunctionPassManager /*&*/ FPM) {
    addExtensionsToPM(ExtensionPointTy.EP_EarlyAsPossible, FPM);

    // Add LibraryInfo if we have some.
    if ((LibraryInfo != null)) {
      FPM.add(new TargetLibraryInfoWrapperPass($Deref(LibraryInfo)));
    }
    if (OptLevel == 0) {
      return;
    }

    addInitialAliasAnalysisPasses(FPM);

    FPM.add(TransformsLlvmGlobals.createCFGSimplificationPass());
    FPM.add(TransformsLlvmGlobals.createSROAPass());
    FPM.add(TransformsLlvmGlobals.createEarlyCSEPass());
    if (PassManagerBuilderStatics.EnableGVNHoist.$T()) {
      FPM.add(TransformsLlvmGlobals.createGVNHoistPass());
    }
    FPM.add(TransformsLlvmGlobals.createLowerExpectIntrinsicPass());
  }


  /// populateModulePassManager - This sets up the primary pass manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::populateModulePassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 359,
   FQN="llvm::PassManagerBuilder::populateModulePassManager", NM="_ZN4llvm18PassManagerBuilder25populateModulePassManagerERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder25populateModulePassManagerERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  public void populateModulePassManager(final PassManagerBase /*&*/ MPM) {
    // Allow forcing function attributes as a debugging and tuning aid.
    MPM.add(TransformsLlvmGlobals.createForceFunctionAttrsLegacyPass());

    // If all optimizations are disabled, just run the always-inline pass and,
    // if enabled, the function merging pass.
    if (OptLevel == 0) {
      addPGOInstrPasses(MPM);
      if ((Inliner != null)) {
        MPM.add(Inliner);
        Inliner = null;
      }

      // FIXME: The BarrierNoopPass is a HACK! The inliner pass above implicitly
      // creates a CGSCC pass manager, but we don't want to add extensions into
      // that pass manager. To prevent this we insert a no-op module pass to reset
      // the pass manager to get the same behavior as EP_OptimizerLast in non-O0
      // builds. The function merging pass is
      if (MergeFunctions) {
        MPM.add(TransformsLlvmGlobals.createMergeFunctionsPass());
      } else if (!PassManagerBuilderStatics.GlobalExtensions.$arrow().empty() || !Extensions.empty()) {
        MPM.add(TransformsLlvmGlobals.createBarrierNoopPass());
      }

      addExtensionsToPM(ExtensionPointTy.EP_EnabledOnOptLevel0, MPM);
      return;
    }

    // Add LibraryInfo if we have some.
    if ((LibraryInfo != null)) {
      MPM.add(new TargetLibraryInfoWrapperPass($Deref(LibraryInfo)));
    }

    addInitialAliasAnalysisPasses(MPM);
    if (!DisableUnitAtATime) {
      // Infer attributes about declarations if possible.
      MPM.add(TransformsLlvmGlobals.createInferFunctionAttrsLegacyPass());

      addExtensionsToPM(ExtensionPointTy.EP_ModuleOptimizerEarly, MPM);

      MPM.add(TransformsLlvmGlobals.createIPSCCPPass()); // IP SCCP
      MPM.add(TransformsLlvmGlobals.createGlobalOptimizerPass()); // Optimize out global vars
      // Promote any localized global vars.
      MPM.add(TransformsLlvmGlobals.createPromoteMemoryToRegisterPass());

      MPM.add(TransformsLlvmGlobals.createDeadArgEliminationPass()); // Dead argument elimination

      addInstructionCombiningPass(MPM); // Clean up after IPCP & DAE
      addExtensionsToPM(ExtensionPointTy.EP_Peephole, MPM);
      MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass()); // Clean up after IPCP & DAE
    }
    if (!PerformThinLTO) {
      /// PGO instrumentation is added during the compile phase for ThinLTO, do
      /// not run it a second time
      addPGOInstrPasses(MPM);
    }

    // Indirect call promotion that promotes intra-module targets only.
    MPM.add(TransformsLlvmGlobals.createPGOIndirectCallPromotionLegacyPass());
    if (PassManagerBuilderStatics.EnableNonLTOGlobalsModRef.$T()) {
      // We add a module alias analysis pass here. In part due to bugs in the
      // analysis infrastructure this "works" in that the analysis stays alive
      // for the entire SCC pass run below.
      MPM.add(createGlobalsAAWrapperPass());
    }

    // Start of CallGraph SCC passes.
    if (!DisableUnitAtATime) {
      MPM.add(TransformsLlvmGlobals.createPruneEHPass()); // Remove dead EH info
    }
    if ((Inliner != null)) {
      MPM.add(Inliner);
      Inliner = null;
    }
    if (!DisableUnitAtATime) {
      MPM.add(TransformsLlvmGlobals.createPostOrderFunctionAttrsLegacyPass());
    }
    if ($greater_uint(OptLevel, 2)) {
      MPM.add(TransformsLlvmGlobals.createArgumentPromotionPass()); // Scalarize uninlined fn args
    }

    addFunctionSimplificationPasses(MPM);

    // FIXME: This is a HACK! The inliner pass above implicitly creates a CGSCC
    // pass manager that we are specifically trying to avoid. To prevent this
    // we must insert a no-op module pass to reset the pass manager.
    MPM.add(TransformsLlvmGlobals.createBarrierNoopPass());
    if (!DisableUnitAtATime && $greater_uint(OptLevel, 1) && !PrepareForLTO
       && !PrepareForThinLTO) {
      // Remove avail extern fns and globals definitions if we aren't
      // compiling an object file for later LTO. For LTO we want to preserve
      // these so they are eligible for inlining at link-time. Note if they
      // are unreferenced they will be removed by GlobalDCE later, so
      // this only impacts referenced available externally globals.
      // Eventually they will be suppressed during codegen, but eliminating
      // here enables more opportunity for GlobalDCE as it may make
      // globals referenced by available external functions dead
      // and saves running remaining passes on the eliminated functions.
      MPM.add(TransformsLlvmGlobals.createEliminateAvailableExternallyPass());
    }
    if (!DisableUnitAtATime) {
      MPM.add(TransformsLlvmGlobals.createReversePostOrderFunctionAttrsPass());
    }

    // If we are planning to perform ThinLTO later, let's not bloat the code with
    // unrolling/vectorization/... now. We'll first run the inliner + CGSCC passes
    // during ThinLTO and perform the rest of the optimizations afterward.
    if (PrepareForThinLTO) {
      // Reduce the size of the IR as much as possible.
      MPM.add(TransformsLlvmGlobals.createGlobalOptimizerPass());
      // Rename anon function to be able to export them in the summary.
      MPM.add(TransformsLlvmGlobals.createNameAnonFunctionPass());
      return;
    }
    if (PerformThinLTO) {
      // Optimize globals now when performing ThinLTO, this enables more
      // optimizations later.
      MPM.add(TransformsLlvmGlobals.createGlobalOptimizerPass());
    }

    // Scheduling LoopVersioningLICM when inlining is over, because after that
    // we may see more accurate aliasing. Reason to run this late is that too
    // early versioning may prevent further inlining due to increase of code
    // size. By placing it just after inlining other optimizations which runs
    // later might get benefit of no-alias assumption in clone loop.
    if (PassManagerBuilderStatics.UseLoopVersioningLICM.$T()) {
      MPM.add(TransformsLlvmGlobals.createLoopVersioningLICMPass()); // Do LoopVersioningLICM
      MPM.add(TransformsLlvmGlobals.createLICMPass()); // Hoist loop invariants
    }
    if (PassManagerBuilderStatics.EnableNonLTOGlobalsModRef.$T()) {
      // We add a fresh GlobalsModRef run at this point. This is particularly
      // useful as the above will have inlined, DCE'ed, and function-attr
      // propagated everything. We should at this point have a reasonably minimal
      // and richly annotated call graph. By computing aliasing and mod/ref
      // information for all local globals here, the late loop passes and notably
      // the vectorizer will be able to use them to help recognize vectorizable
      // memory operations.
      //
      // Note that this relies on a bug in the pass manager which preserves
      // a module analysis into a function pass pipeline (and throughout it) so
      // long as the first function pass doesn't invalidate the module analysis.
      // Thus both Float2Int and LoopRotate have to preserve AliasAnalysis for
      // this to work. Fortunately, it is trivial to preserve AliasAnalysis
      // (doing nothing preserves it as it is required to be conservatively
      // correct in the face of IR changes).
      MPM.add(createGlobalsAAWrapperPass());
    }
    if (PassManagerBuilderStatics.RunFloat2Int.$T()) {
      MPM.add(TransformsLlvmGlobals.createFloat2IntPass());
    }

    addExtensionsToPM(ExtensionPointTy.EP_VectorizerStart, MPM);

    // Re-rotate loops in all our loop nests. These may have fallout out of
    // rotated form due to GVN or other transformations, and the vectorizer relies
    // on the rotated form. Disable header duplication at -Oz.
    MPM.add(TransformsLlvmGlobals.createLoopRotatePass(SizeLevel == 2 ? 0 : -1));

    // Distribute loops to allow partial vectorization.  I.e. isolate dependences
    // into separate loop that would otherwise inhibit vectorization.  This is
    // currently only performed for loops marked with the metadata
    // llvm.loop.distribute=true or when -enable-loop-distribute is specified.
    MPM.add(TransformsLlvmGlobals.createLoopDistributePass(/*ProcessAllLoopsByDefault=*/ false));

    MPM.add(TransformsLlvmGlobals.createLoopVectorizePass(DisableUnrollLoops, LoopVectorize));

    // Eliminate loads by forwarding stores from the previous iteration to loads
    // of the current iteration.
    if (PassManagerBuilderStatics.EnableLoopLoadElim.$T()) {
      MPM.add(TransformsLlvmGlobals.createLoopLoadEliminationPass());
    }

    // FIXME: Because of #pragma vectorize enable, the passes below are always
    // inserted in the pipeline, even when the vectorizer doesn't run (ex. when
    // on -O1 and no #pragma is found). Would be good to have these two passes
    // as function calls, so that we can only pass them when the vectorizer
    // changed the code.
    addInstructionCombiningPass(MPM);
    if ($greater_uint(OptLevel, 1) && PassManagerBuilderStatics.ExtraVectorizerPasses.$T()) {
      // At higher optimization levels, try to clean up any runtime overlap and
      // alignment checks inserted by the vectorizer. We want to track correllated
      // runtime checks for two inner loops in the same outer loop, fold any
      // common computations, hoist loop-invariant aspects out of any outer loop,
      // and unswitch the runtime checks if possible. Once hoisted, we may have
      // dead (or speculatable) control flows or more combining opportunities.
      MPM.add(TransformsLlvmGlobals.createEarlyCSEPass());
      MPM.add(TransformsLlvmGlobals.createCorrelatedValuePropagationPass());
      addInstructionCombiningPass(MPM);
      MPM.add(TransformsLlvmGlobals.createLICMPass());
      MPM.add(TransformsLlvmGlobals.createLoopUnswitchPass((SizeLevel != 0) || $less_uint(OptLevel, 3)));
      MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass());
      addInstructionCombiningPass(MPM);
    }
    if (PassManagerBuilderStatics.RunSLPAfterLoopVectorization.$T()) {
      if (SLPVectorize) {
        MPM.add(TransformsLlvmGlobals.createSLPVectorizerPass()); // Vectorize parallel scalar chains.
        if ($greater_uint(OptLevel, 1) && PassManagerBuilderStatics.ExtraVectorizerPasses.$T()) {
          MPM.add(TransformsLlvmGlobals.createEarlyCSEPass());
        }
      }
      if (BBVectorize) {
        MPM.add(TransformsLlvmGlobals.createBBVectorizePass());
        addInstructionCombiningPass(MPM);
        addExtensionsToPM(ExtensionPointTy.EP_Peephole, MPM);
        if ($greater_uint(OptLevel, 1) && PassManagerBuilderStatics.UseGVNAfterVectorization.$T()) {
          MPM.add(TransformsLlvmGlobals.createGVNPass(DisableGVNLoadPRE)); // Remove redundancies
        } else {
          MPM.add(TransformsLlvmGlobals.createEarlyCSEPass()); // Catch trivial redundancies
        }

        // BBVectorize may have significantly shortened a loop body; unroll again.
        if (!DisableUnrollLoops) {
          MPM.add(TransformsLlvmGlobals.createLoopUnrollPass());
        }
      }
    }

    addExtensionsToPM(ExtensionPointTy.EP_Peephole, MPM);
    MPM.add(TransformsLlvmGlobals.createCFGSimplificationPass());
    addInstructionCombiningPass(MPM);
    if (!DisableUnrollLoops) {
      MPM.add(TransformsLlvmGlobals.createLoopUnrollPass()); // Unroll small loops

      // LoopUnroll may generate some redundency to cleanup.
      addInstructionCombiningPass(MPM);

      // Runtime unrolling will introduce runtime check in loop prologue. If the
      // unrolled loop is a inner loop, then the prologue will be inside the
      // outer loop. LICM pass can help to promote the runtime check out if the
      // checked value is loop invariant.
      MPM.add(TransformsLlvmGlobals.createLICMPass());

      // Get rid of LCSSA nodes.
      MPM.add(TransformsLlvmGlobals.createInstructionSimplifierPass());
    }

    // After vectorization and unrolling, assume intrinsics may tell us more
    // about pointer alignments.
    MPM.add(TransformsLlvmGlobals.createAlignmentFromAssumptionsPass());
    if (!DisableUnitAtATime) {
      // FIXME: We shouldn't bother with this anymore.
      MPM.add(TransformsLlvmGlobals.createStripDeadPrototypesPass()); // Get rid of dead prototypes

      // GlobalOpt already deletes dead functions and globals, at -O2 try a
      // late pass of GlobalDCE.  It is capable of deleting dead cycles.
      if ($greater_uint(OptLevel, 1)) {
        MPM.add(TransformsLlvmGlobals.createGlobalDCEPass()); // Remove dead fns and globals.
        MPM.add(TransformsLlvmGlobals.createConstantMergePass()); // Merge dup global constants
      }
    }
    if (MergeFunctions) {
      MPM.add(TransformsLlvmGlobals.createMergeFunctionsPass());
    }

    addExtensionsToPM(ExtensionPointTy.EP_OptimizerLast, MPM);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::populateLTOPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 790,
   FQN="llvm::PassManagerBuilder::populateLTOPassManager", NM="_ZN4llvm18PassManagerBuilder22populateLTOPassManagerERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder22populateLTOPassManagerERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  public void populateLTOPassManager(final PassManagerBase /*&*/ PM) {
    if ((LibraryInfo != null)) {
      PM.add(new TargetLibraryInfoWrapperPass($Deref(LibraryInfo)));
    }
    if (VerifyInput) {
      PM.add(createVerifierPass());
    }
    if (OptLevel != 0) {
      addLTOOptimizationPasses(PM);
    }

    // Create a function that performs CFI checks for cross-DSO calls with targets
    // in the current module.
    PM.add(TransformsLlvmGlobals.createCrossDSOCFIPass());

    // Lower type metadata and the type.test intrinsic. This pass supports Clang's
    // control flow integrity mechanisms (-fsanitize=cfi*) and needs to run at
    // link time if CFI is enabled. The pass does nothing if CFI is disabled.
    PM.add(TransformsLlvmGlobals.createLowerTypeTestsPass());
    if (OptLevel != 0) {
      addLateLTOOptimizationPasses(PM);
    }
    if (VerifyOutput) {
      PM.add(createVerifierPass());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PassManagerBuilder::populateThinLTOPassManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 773,
   FQN="llvm::PassManagerBuilder::populateThinLTOPassManager", NM="_ZN4llvm18PassManagerBuilder26populateThinLTOPassManagerERNS_6legacy15PassManagerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZN4llvm18PassManagerBuilder26populateThinLTOPassManagerERNS_6legacy15PassManagerBaseE")
  //</editor-fold>
  public void populateThinLTOPassManager(final PassManagerBase /*&*/ PM) {
    PerformThinLTO = true;
    if (VerifyInput) {
      PM.add(createVerifierPass());
    }
    if ((ModuleSummary != null)) {
      PM.add(TransformsLlvmGlobals.createFunctionImportPass(ModuleSummary));
    }

    populateModulePassManager(PM);
    if (VerifyOutput) {
      PM.add(createVerifierPass());
    }
    PerformThinLTO = false;
  }


  @Override public String toString() {
    return "" + "OptLevel=" + OptLevel // NOI18N
              + ", SizeLevel=" + SizeLevel // NOI18N
              + ", LibraryInfo=" + LibraryInfo // NOI18N
              + ", Inliner=" + Inliner // NOI18N
              + ", ModuleSummary=" + ModuleSummary // NOI18N
              + ", DisableTailCalls=" + DisableTailCalls // NOI18N
              + ", DisableUnitAtATime=" + DisableUnitAtATime // NOI18N
              + ", DisableUnrollLoops=" + DisableUnrollLoops // NOI18N
              + ", BBVectorize=" + BBVectorize // NOI18N
              + ", SLPVectorize=" + SLPVectorize // NOI18N
              + ", LoopVectorize=" + LoopVectorize // NOI18N
              + ", RerollLoops=" + RerollLoops // NOI18N
              + ", LoadCombine=" + LoadCombine // NOI18N
              + ", DisableGVNLoadPRE=" + DisableGVNLoadPRE // NOI18N
              + ", VerifyInput=" + VerifyInput // NOI18N
              + ", VerifyOutput=" + VerifyOutput // NOI18N
              + ", MergeFunctions=" + MergeFunctions // NOI18N
              + ", PrepareForLTO=" + PrepareForLTO // NOI18N
              + ", PrepareForThinLTO=" + PrepareForThinLTO // NOI18N
              + ", PerformThinLTO=" + PerformThinLTO // NOI18N
              + ", PGOInstrGen=" + PGOInstrGen // NOI18N
              + ", PGOInstrUse=" + PGOInstrUse // NOI18N
              + ", Extensions=" + Extensions; // NOI18N
  }
}
