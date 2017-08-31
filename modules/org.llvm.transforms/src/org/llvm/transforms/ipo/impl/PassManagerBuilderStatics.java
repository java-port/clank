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
package org.llvm.transforms.ipo.impl;

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
import org.llvm.adt.aliases.SmallVector;
import org.llvm.cl.aliases.*;
import org.llvm.cl.desc;
import org.llvm.cl.*;
import static org.llvm.cl.ClGlobals.clEnumValEnd;
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
import org.llvm.support.sys.ManagedStaticInfoImpl;
import org.llvm.target.target.*;
import org.llvm.transforms.java.TransformDummies.*;
import org.llvm.cl.ClGlobals;


//<editor-fold defaultstate="collapsed" desc="static type PassManagerBuilderStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.transforms.ipo.impl.PassManagerBuilderStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z28LLVMPassManagerBuilderCreate;_Z29LLVMPassManagerBuilderDispose;_Z33LLVMPassManagerBuilderSetOptLevel;_Z34LLVMPassManagerBuilderSetSizeLevel;_Z43LLVMPassManagerBuilderSetDisableUnitAtATime;_Z43LLVMPassManagerBuilderSetDisableUnrollLoops;_Z44LLVMPassManagerBuilderPopulateLTOPassManager;_Z45LLVMPassManagerBuilderUseInlinerWithThreshold;_Z47LLVMPassManagerBuilderPopulateModulePassManager;_Z48LLVMPassManagerBuilderSetDisableSimplifyLibCalls;_Z49LLVMPassManagerBuilderPopulateFunctionPassManager;_Z4wrapPN4llvm18PassManagerBuilderE;_Z6unwrapP28LLVMOpaquePassManagerBuilder;_ZL10EnableMLSM;_ZL12RunFloat2Int;_ZL14EnableGVNHoist;_ZL14RunLoadCombine;_ZL14RunPGOInstrGenB5cxx11;_ZL14RunPGOInstrUseB5cxx11;_ZL16GlobalExtensions;_ZL16RunLoopRerolling;_ZL17DisablePreInliner;_ZL18EnableLoopLoadElim;_ZL18PreInlineThreshold;_ZL18RunBBVectorization;_ZL19RunSLPVectorization;_ZL20RunLoopVectorization;_ZL21EnableLoopInterchange;_ZL21ExtraVectorizerPasses;_ZL21UseLoopVersioningLICM;_ZL24UseGVNAfterVectorization;_ZL25EnableNonLTOGlobalsModRef;_ZL28RunSLPAfterLoopVectorization;_ZL8UseCFLAA; -static-type=PassManagerBuilderStatics -package=org.llvm.transforms.ipo.impl")
//</editor-fold>
public final class PassManagerBuilderStatics {


/**
* @defgroup LLVMCTransformsPassManagerBuilder Pass manager builder
* @ingroup LLVMCTransforms
*
* @{
*/

/** See llvm::PassManagerBuilder. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderCreate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 824,
 FQN="LLVMPassManagerBuilderCreate", NM="_Z28LLVMPassManagerBuilderCreate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z28LLVMPassManagerBuilderCreate")
//</editor-fold>
public static  LLVMOpaquePassManagerBuilder /*P*/ LLVMPassManagerBuilderCreate() {
  PassManagerBuilder /*P*/ PMB = new PassManagerBuilder();
  return wrap(PMB);
}

//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderDispose">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 829,
 FQN="LLVMPassManagerBuilderDispose", NM="_Z29LLVMPassManagerBuilderDispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z29LLVMPassManagerBuilderDispose")
//</editor-fold>
public static void LLVMPassManagerBuilderDispose( LLVMOpaquePassManagerBuilder /*P*/ PMB) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  if (Builder != null) { Builder.$destroy();};
}


/** See llvm::PassManagerBuilder::OptLevel. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetOptLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 834,
 FQN="LLVMPassManagerBuilderSetOptLevel", NM="_Z33LLVMPassManagerBuilderSetOptLevel",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z33LLVMPassManagerBuilderSetOptLevel")
//</editor-fold>
public static void LLVMPassManagerBuilderSetOptLevel( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                 /*uint*/int OptLevel) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  Builder.OptLevel = OptLevel;
}


/** See llvm::PassManagerBuilder::SizeLevel. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetSizeLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 841,
 FQN="LLVMPassManagerBuilderSetSizeLevel", NM="_Z34LLVMPassManagerBuilderSetSizeLevel",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z34LLVMPassManagerBuilderSetSizeLevel")
//</editor-fold>
public static void LLVMPassManagerBuilderSetSizeLevel( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                  /*uint*/int SizeLevel) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  Builder.SizeLevel = SizeLevel;
}


/** See llvm::PassManagerBuilder::DisableUnitAtATime. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetDisableUnitAtATime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 848,
 FQN="LLVMPassManagerBuilderSetDisableUnitAtATime", NM="_Z43LLVMPassManagerBuilderSetDisableUnitAtATime",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z43LLVMPassManagerBuilderSetDisableUnitAtATime")
//</editor-fold>
public static void LLVMPassManagerBuilderSetDisableUnitAtATime( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                           int Value) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  Builder.DisableUnitAtATime = (Value != 0);
}


/** See llvm::PassManagerBuilder::DisableUnrollLoops. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetDisableUnrollLoops">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 855,
 FQN="LLVMPassManagerBuilderSetDisableUnrollLoops", NM="_Z43LLVMPassManagerBuilderSetDisableUnrollLoops",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z43LLVMPassManagerBuilderSetDisableUnrollLoops")
//</editor-fold>
public static void LLVMPassManagerBuilderSetDisableUnrollLoops( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                           int Value) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  Builder.DisableUnrollLoops = (Value != 0);
}


/** See llvm::PassManagerBuilder::DisableSimplifyLibCalls */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderSetDisableSimplifyLibCalls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 862,
 FQN="LLVMPassManagerBuilderSetDisableSimplifyLibCalls", NM="_Z48LLVMPassManagerBuilderSetDisableSimplifyLibCalls",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z48LLVMPassManagerBuilderSetDisableSimplifyLibCalls")
//</editor-fold>
public static void LLVMPassManagerBuilderSetDisableSimplifyLibCalls( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                                int Value) {
  // NOTE: The simplify-libcalls pass has been removed.
}


/** See llvm::PassManagerBuilder::Inliner. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderUseInlinerWithThreshold">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 868,
 FQN="LLVMPassManagerBuilderUseInlinerWithThreshold", NM="_Z45LLVMPassManagerBuilderUseInlinerWithThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z45LLVMPassManagerBuilderUseInlinerWithThreshold")
//</editor-fold>
public static void LLVMPassManagerBuilderUseInlinerWithThreshold( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                             /*uint*/int Threshold) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  Builder.Inliner = TransformsLlvmGlobals.createFunctionInliningPass(Threshold);
}


/** See llvm::PassManagerBuilder::populateFunctionPassManager. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderPopulateFunctionPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 875,
 FQN="LLVMPassManagerBuilderPopulateFunctionPassManager", NM="_Z49LLVMPassManagerBuilderPopulateFunctionPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z49LLVMPassManagerBuilderPopulateFunctionPassManager")
//</editor-fold>
public static void LLVMPassManagerBuilderPopulateFunctionPassManager( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                                  LLVMOpaquePassManager /*P*/ PM) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  FunctionPassManager /*P*/ FPM = IrLlvmGlobals.unwrap$T(FunctionPassManager.class, PM);
  Builder.populateFunctionPassManager($Deref(FPM));
}


/** See llvm::PassManagerBuilder::populateModulePassManager. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderPopulateModulePassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 883,
 FQN="LLVMPassManagerBuilderPopulateModulePassManager", NM="_Z47LLVMPassManagerBuilderPopulateModulePassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z47LLVMPassManagerBuilderPopulateModulePassManager")
//</editor-fold>
public static void LLVMPassManagerBuilderPopulateModulePassManager( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                                LLVMOpaquePassManager /*P*/ PM) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  PassManagerBase /*P*/ MPM = IrLlvmGlobals.unwrap(PM);
  Builder.populateModulePassManager($Deref(MPM));
}


/** See llvm::PassManagerBuilder::populateLTOPassManager. */
//<editor-fold defaultstate="collapsed" desc="LLVMPassManagerBuilderPopulateLTOPassManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 891,
 FQN="LLVMPassManagerBuilderPopulateLTOPassManager", NM="_Z44LLVMPassManagerBuilderPopulateLTOPassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z44LLVMPassManagerBuilderPopulateLTOPassManager")
//</editor-fold>
public static void LLVMPassManagerBuilderPopulateLTOPassManager( LLVMOpaquePassManagerBuilder /*P*/ PMB,
                                             LLVMOpaquePassManager /*P*/ PM,
                                            int Internalize,
                                            int RunInliner) {
  PassManagerBuilder /*P*/ Builder = unwrap(PMB);
  PassManagerBase /*P*/ LPM = IrLlvmGlobals.unwrap(PM);

  // A small backwards compatibility hack. populateLTOPassManager used to take
  // an RunInliner option.
  if ((RunInliner != 0) && !(Builder.Inliner != null)) {
    Builder.Inliner = TransformsLlvmGlobals.createFunctionInliningPass();
  }

  Builder.populateLTOPassManager($Deref(LPM));
}

//<editor-fold defaultstate="collapsed" desc="RunLoopVectorization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 44,
 FQN="RunLoopVectorization", NM="_ZL20RunLoopVectorization",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL20RunLoopVectorization")
//</editor-fold>
public static optBool RunLoopVectorization/*J*/= new optBool($("vectorize-loops"), OptionHidden.Hidden,
    new desc($("Run the Loop vectorization passes")));
//<editor-fold defaultstate="collapsed" desc="RunSLPVectorization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 48,
 FQN="RunSLPVectorization", NM="_ZL19RunSLPVectorization",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL19RunSLPVectorization")
//</editor-fold>
public static optBool RunSLPVectorization/*J*/= new optBool($("vectorize-slp"), OptionHidden.Hidden,
    new desc($("Run the SLP vectorization passes")));
//<editor-fold defaultstate="collapsed" desc="RunBBVectorization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 52,
 FQN="RunBBVectorization", NM="_ZL18RunBBVectorization",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL18RunBBVectorization")
//</editor-fold>
public static optBool RunBBVectorization/*J*/= new optBool($("vectorize-slp-aggressive"), OptionHidden.Hidden,
    new desc($("Run the BB vectorization passes")));
//<editor-fold defaultstate="collapsed" desc="UseGVNAfterVectorization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 56,
 FQN="UseGVNAfterVectorization", NM="_ZL24UseGVNAfterVectorization",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL24UseGVNAfterVectorization")
//</editor-fold>
public static optBool UseGVNAfterVectorization/*J*/= new optBool($("use-gvn-after-vectorization"),
    ClGlobals.init$Bool(false), OptionHidden.Hidden,
    new desc($("Run GVN instead of Early CSE after vectorization passes")));
//<editor-fold defaultstate="collapsed" desc="ExtraVectorizerPasses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 61,
 FQN="ExtraVectorizerPasses", NM="_ZL21ExtraVectorizerPasses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL21ExtraVectorizerPasses")
//</editor-fold>
public static optBool ExtraVectorizerPasses/*J*/= new optBool($("extra-vectorizer-passes"), ClGlobals.init$Bool(false), OptionHidden.Hidden,
    new desc($("Run cleanup optimization passes after vectorization.")));
//<editor-fold defaultstate="collapsed" desc="RunLoopRerolling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 65,
 FQN="RunLoopRerolling", NM="_ZL16RunLoopRerolling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL16RunLoopRerolling")
//</editor-fold>
public static optBool RunLoopRerolling/*J*/= new optBool($("reroll-loops"), OptionHidden.Hidden,
    new desc($("Run the loop rerolling pass")));
//<editor-fold defaultstate="collapsed" desc="RunFloat2Int">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 69,
 FQN="RunFloat2Int", NM="_ZL12RunFloat2Int",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL12RunFloat2Int")
//</editor-fold>
public static optBool RunFloat2Int/*J*/= new optBool($("float-to-int"), OptionHidden.Hidden, ClGlobals.init$Bool(true),
    new desc($("Run the float2int (float demotion) pass")));
//<editor-fold defaultstate="collapsed" desc="RunLoadCombine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 73,
 FQN="RunLoadCombine", NM="_ZL14RunLoadCombine",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL14RunLoadCombine")
//</editor-fold>
public static optBool RunLoadCombine/*J*/= new optBool($("combine-loads"), ClGlobals.init$Bool(false),
    OptionHidden.Hidden,
    new desc($("Run the load combining pass")));
//<editor-fold defaultstate="collapsed" desc="RunSLPAfterLoopVectorization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 77,
 FQN="RunSLPAfterLoopVectorization", NM="_ZL28RunSLPAfterLoopVectorization",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL28RunSLPAfterLoopVectorization")
//</editor-fold>
public static optBool RunSLPAfterLoopVectorization/*J*/= new optBool($("run-slp-after-loop-vectorization"),
    ClGlobals.init$Bool(true), OptionHidden.Hidden,
    new desc($("Run the SLP vectorizer (and BB vectorizer) after the Loop vectorizer instead of before")));
//<editor-fold defaultstate="collapsed" desc="UseCFLAA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 85,
 FQN="UseCFLAA", NM="_ZL8UseCFLAA",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL8UseCFLAA")
//</editor-fold>
public static optEnum<CFLAAType> UseCFLAA/*J*/= new optEnum<CFLAAType>(CFLAAType::valueOf, $("use-cfl-aa"), ClGlobals.init(CFLAAType.None), OptionHidden.Hidden,
    new desc($("Enable the new, experimental CFL alias analysis")),
    ClGlobals.values($("none"), ((int)CFLAAType.None.getValue()), $("Disable CFL-AA"),
        $("steens"), ((int)CFLAAType.Steensgaard.getValue()), $("Enable unification-based CFL-AA"),
        $("anders"), ((int)CFLAAType.Andersen.getValue()), $("Enable inclusion-based CFL-AA"),
        $("both"), ((int)CFLAAType.Both.getValue()), $("Enable both variants of CFL-aa"),
        (reinterpret_cast(Object/*void P*/ .class, clEnumValEnd))));
//<editor-fold defaultstate="collapsed" desc="EnableMLSM">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 97,
 FQN="EnableMLSM", NM="_ZL10EnableMLSM",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL10EnableMLSM")
//</editor-fold>
public static optBool EnableMLSM/*J*/= new optBool($("mlsm"), ClGlobals.init$Bool(true), OptionHidden.Hidden,
    new desc($("Enable motion of merged load and store")));
//<editor-fold defaultstate="collapsed" desc="EnableLoopInterchange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 101,
 FQN="EnableLoopInterchange", NM="_ZL21EnableLoopInterchange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL21EnableLoopInterchange")
//</editor-fold>
public static optBool EnableLoopInterchange/*J*/= new optBool($("enable-loopinterchange"), ClGlobals.init$Bool(false), OptionHidden.Hidden,
    new desc($("Enable the new, experimental LoopInterchange Pass")));
//<editor-fold defaultstate="collapsed" desc="EnableNonLTOGlobalsModRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 105,
 FQN="EnableNonLTOGlobalsModRef", NM="_ZL25EnableNonLTOGlobalsModRef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL25EnableNonLTOGlobalsModRef")
//</editor-fold>
public static optBool EnableNonLTOGlobalsModRef/*J*/= new optBool($("enable-non-lto-gmr"), ClGlobals.init$Bool(true), OptionHidden.Hidden,
    new desc($("Enable the GlobalsModRef AliasAnalysis outside of the LTO pipeline.")));
//<editor-fold defaultstate="collapsed" desc="EnableLoopLoadElim">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 110,
 FQN="EnableLoopLoadElim", NM="_ZL18EnableLoopLoadElim",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL18EnableLoopLoadElim")
//</editor-fold>
public static optBool EnableLoopLoadElim/*J*/= new optBool($("enable-loop-load-elim"), ClGlobals.init$Bool(true), OptionHidden.Hidden,
    new desc($("Enable the LoopLoadElimination Pass")));
//<editor-fold defaultstate="collapsed" desc="RunPGOInstrGen">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 114,
 FQN="RunPGOInstrGen", NM="_ZL14RunPGOInstrGen",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL14RunPGOInstrGen")
//</editor-fold>
public static optString RunPGOInstrGen/*J*/= new optString(/*false, */$("profile-generate"), ClGlobals.init($EMPTY), OptionHidden.Hidden,
    new desc($("Enable generation phase of PGO instrumentation and specify the path of profile data file")));
//<editor-fold defaultstate="collapsed" desc="RunPGOInstrUse">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 119,
 FQN="RunPGOInstrUse", NM="_ZL14RunPGOInstrUse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL14RunPGOInstrUse")
//</editor-fold>
public static optString RunPGOInstrUse/*J*/= new optString(/*false, */$("profile-use"), ClGlobals.init($EMPTY), OptionHidden.Hidden, new value_desc($("filename")),
    new desc($("Enable use phase of PGO instrumentation and specify the path of profile data file")));
//<editor-fold defaultstate="collapsed" desc="UseLoopVersioningLICM">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 124,
 FQN="UseLoopVersioningLICM", NM="_ZL21UseLoopVersioningLICM",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL21UseLoopVersioningLICM")
//</editor-fold>
public static optBool UseLoopVersioningLICM/*J*/= new optBool($("enable-loop-versioning-licm"), ClGlobals.init$Bool(false), OptionHidden.Hidden,
    new desc($("Enable the experimental Loop Versioning LICM pass")));
//<editor-fold defaultstate="collapsed" desc="DisablePreInliner">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 128,
 FQN="DisablePreInliner", NM="_ZL17DisablePreInliner",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL17DisablePreInliner")
//</editor-fold>
public static optBool DisablePreInliner/*J*/= new optBool($("disable-preinline"), ClGlobals.init$Bool(false), OptionHidden.Hidden,
    new desc($("Disable pre-instrumentation inliner")));
//<editor-fold defaultstate="collapsed" desc="PreInlineThreshold">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 132,
 FQN="PreInlineThreshold", NM="_ZL18PreInlineThreshold",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL18PreInlineThreshold")
//</editor-fold>
public static optInt PreInlineThreshold/*J*/= new optInt(/*false, */$("preinline-threshold"), OptionHidden.Hidden, ClGlobals.init$Int(75), NumOccurrencesFlag.ZeroOrMore,
    new desc($("Control the amount of inlining in pre-instrumentation inliner (default = 75)")));
//<editor-fold defaultstate="collapsed" desc="EnableGVNHoist">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 137,
 FQN="EnableGVNHoist", NM="_ZL14EnableGVNHoist",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL14EnableGVNHoist")
//</editor-fold>
public static optBool EnableGVNHoist/*J*/= new optBool($("enable-gvn-hoist"), ClGlobals.init$Bool(false), OptionHidden.Hidden,
    new desc($("Enable the experimental GVN Hoisting pass")));

/// Set of global extensions, automatically added as part of the standard set.
//<editor-fold defaultstate="collapsed" desc="GlobalExtensions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 171,
 FQN="GlobalExtensions", NM="_ZL16GlobalExtensions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_ZL16GlobalExtensions")
//</editor-fold>
public static ManagedStatic<SmallVector<std.pairTypeType<PassManagerBuilder.ExtensionPointTy, ExtensionFn>>> GlobalExtensions/*J*/= new ManagedStatic<SmallVector<std.pairTypeType<PassManagerBuilder.ExtensionPointTy, ExtensionFn>>>(
new ManagedStaticInfoImpl<SmallVector<std.pairTypeType<PassManagerBuilder.ExtensionPointTy, ExtensionFn>>>() {
  @Override
  protected SmallVector<pairTypeType<PassManagerBuilder.ExtensionPointTy, ExtensionFn>> create() {
    return new SmallVector<std.pairTypeType<PassManagerBuilder.ExtensionPointTy, ExtensionFn>>(8, new std.pairTypeType<PassManagerBuilder.ExtensionPointTy, ExtensionFn>(PassManagerBuilder.ExtensionPointTy.EP_EarlyAsPossible, null));
  }
}) ;

//<editor-fold defaultstate="collapsed" desc="unwrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 816,
 FQN="unwrap", NM="_Z6unwrapP28LLVMOpaquePassManagerBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z6unwrapP28LLVMOpaquePassManagerBuilder")
//</editor-fold>
public static /*inline*/ PassManagerBuilder /*P*/ unwrap( LLVMOpaquePassManagerBuilder /*P*/ P) {
  return reinterpret_cast(PassManagerBuilder /*P*/ .class, P);
}

//<editor-fold defaultstate="collapsed" desc="wrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp", line = 820,
 FQN="wrap", NM="_Z4wrapPN4llvm18PassManagerBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PassManagerBuilder.cpp -nm=_Z4wrapPN4llvm18PassManagerBuilderE")
//</editor-fold>
public static /*inline*/  LLVMOpaquePassManagerBuilder /*P*/ wrap(PassManagerBuilder /*P*/ P) {
  return reinterpret_cast( LLVMOpaquePassManagerBuilder /*P*/ .class, P);
}

} // END OF class PassManagerBuilderStatics
