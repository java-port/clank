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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.codegen.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.llvm.analysis.target.TargetLibraryInfoImpl;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.SymbolRewriter.RewriteDescriptor;
import org.llvm.transforms.utils.SymbolRewriter.RewriteMapParser;
import org.llvm.transforms.utils.SymbolRewriter.iplistRewriteDescriptor;
import static org.llvm.transforms.utils.TransformsLlvmGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type BackendUtilStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.BackendUtilStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL10createTLIIRN4llvm6TripleERKN5clang14CodeGenOptionsE;_ZL17addObjCARCOptPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL20addObjCARCAPElimPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL20addObjCARCExpandPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL21addBoundsCheckingPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL21addSymbolRewriterPassRKN5clang14CodeGenOptionsEPN4llvm6legacy11PassManagerE;_ZL22addMemorySanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL22addThreadSanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL24addAddDiscriminatorsPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL24addDataFlowSanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL24addSanitizerCoveragePassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL24getSectionNameForBitcodeRKN4llvm6TripleE;_ZL25addAddressSanitizerPassesRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL26addEfficiencySanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL28getSectionNameForCommandlineRKN4llvm6TripleE;_ZL31addKernelAddressSanitizerPassesRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE;_ZL33addCleanupPassesForSampleProfilerRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE; -static-type=BackendUtilStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class BackendUtilStatics {

//<editor-fold defaultstate="collapsed" desc="addObjCARCAPElimPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 130,
 FQN="addObjCARCAPElimPass", NM="_ZL20addObjCARCAPElimPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL20addObjCARCAPElimPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addObjCARCAPElimPass(final /*const*/ PassManagerBuilder /*&*/ Builder, final PassManagerBase /*&*/ PM) {
  if ($greater_uint(Builder.OptLevel, 0)) {
    PM.add(createObjCARCAPElimPass());
  }
}

//<editor-fold defaultstate="collapsed" desc="addObjCARCExpandPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 135,
 FQN="addObjCARCExpandPass", NM="_ZL20addObjCARCExpandPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL20addObjCARCExpandPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addObjCARCExpandPass(final /*const*/ PassManagerBuilder /*&*/ Builder, final PassManagerBase /*&*/ PM) {
  if ($greater_uint(Builder.OptLevel, 0)) {
    PM.add(createObjCARCExpandPass());
  }
}

//<editor-fold defaultstate="collapsed" desc="addObjCARCOptPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 140,
 FQN="addObjCARCOptPass", NM="_ZL17addObjCARCOptPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL17addObjCARCOptPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addObjCARCOptPass(final /*const*/ PassManagerBuilder /*&*/ Builder, final PassManagerBase /*&*/ PM) {
  if ($greater_uint(Builder.OptLevel, 0)) {
    PM.add(createObjCARCOptPass());
  }
}

//<editor-fold defaultstate="collapsed" desc="addAddDiscriminatorsPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 145,
 FQN="addAddDiscriminatorsPass", NM="_ZL24addAddDiscriminatorsPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL24addAddDiscriminatorsPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addAddDiscriminatorsPass(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                        final PassManagerBase /*&*/ PM) {
  PM.add(createAddDiscriminatorsPass());
}

//<editor-fold defaultstate="collapsed" desc="addCleanupPassesForSampleProfiler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 150,
 FQN="addCleanupPassesForSampleProfiler", NM="_ZL33addCleanupPassesForSampleProfilerRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL33addCleanupPassesForSampleProfilerRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addCleanupPassesForSampleProfiler(final /*const*/ PassManagerBuilder /*&*/ Builder, final PassManagerBase /*&*/ PM) {
  // instcombine is needed before sample profile annotation because it converts
  // certain function calls to be inlinable. simplifycfg and sroa are needed
  // before instcombine for necessary preparation. E.g. load store is eliminated
  // properly so that instcombine will not introduce unecessary liverange.
  PM.add(createCFGSimplificationPass());
  PM.add(createSROAPass());
  PM.add(createInstructionCombiningPass());
}

//<editor-fold defaultstate="collapsed" desc="addBoundsCheckingPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 161,
 FQN="addBoundsCheckingPass", NM="_ZL21addBoundsCheckingPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL21addBoundsCheckingPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addBoundsCheckingPass(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                     final PassManagerBase /*&*/ PM) {
  PM.add(createBoundsCheckingPass());
}

//<editor-fold defaultstate="collapsed" desc="addSanitizerCoveragePass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 166,
 FQN="addSanitizerCoveragePass", NM="_ZL24addSanitizerCoveragePassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL24addSanitizerCoveragePassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addSanitizerCoveragePass(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                        final PassManagerBase /*&*/ PM) {
  final /*const*/ PassManagerBuilderWrapper /*&*/ BuilderWrapper = ((/*static_cast*//*const*/ PassManagerBuilderWrapper /*&*/ )(Builder));
  final /*const*/ CodeGenOptions /*&*/ CGOpts = BuilderWrapper.getCGOpts();
  SanitizerCoverageOptions Opts/*J*/= new SanitizerCoverageOptions();
  Opts.CoverageType
     = /*static_cast*/SanitizerCoverageOptions.Type.valueOf($2bits_uint2uint(CGOpts.SanitizeCoverageType));
  Opts.IndirectCalls = CGOpts.SanitizeCoverageIndirectCalls;
  Opts.TraceBB = CGOpts.SanitizeCoverageTraceBB;
  Opts.TraceCmp = CGOpts.SanitizeCoverageTraceCmp;
  Opts.Use8bitCounters = CGOpts.SanitizeCoverage8bitCounters;
  Opts.TracePC = CGOpts.SanitizeCoverageTracePC;
  PM.add(createSanitizerCoverageModulePass(Opts));
}

//<editor-fold defaultstate="collapsed" desc="addAddressSanitizerPasses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 182,
 FQN="addAddressSanitizerPasses", NM="_ZL25addAddressSanitizerPassesRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL25addAddressSanitizerPassesRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addAddressSanitizerPasses(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                         final PassManagerBase /*&*/ PM) {
  final /*const*/ PassManagerBuilderWrapper /*&*/ BuilderWrapper = ((/*static_cast*//*const*/ PassManagerBuilderWrapper /*&*/ )(Builder));
  final /*const*/ CodeGenOptions /*&*/ CGOpts = BuilderWrapper.getCGOpts();
  boolean Recover = CGOpts.SanitizeRecover.has(SanitizerKind.Address);
  boolean UseAfterScope = CGOpts.SanitizeAddressUseAfterScope;
  PM.add(createAddressSanitizerFunctionPass(/*CompileKernel*/ false, Recover, 
          UseAfterScope));
  PM.add(createAddressSanitizerModulePass(/*CompileKernel*/ false, Recover));
}

//<editor-fold defaultstate="collapsed" desc="addKernelAddressSanitizerPasses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 194,
 FQN="addKernelAddressSanitizerPasses", NM="_ZL31addKernelAddressSanitizerPassesRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL31addKernelAddressSanitizerPassesRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addKernelAddressSanitizerPasses(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                               final PassManagerBase /*&*/ PM) {
  PM.add(createAddressSanitizerFunctionPass(/*CompileKernel*/ true, 
          /*Recover*/ true, /*UseAfterScope*/ false));
  PM.add(createAddressSanitizerModulePass(/*CompileKernel*/ true, 
          /*Recover*/ true));
}

//<editor-fold defaultstate="collapsed" desc="addMemorySanitizerPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 203,
 FQN="addMemorySanitizerPass", NM="_ZL22addMemorySanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL22addMemorySanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addMemorySanitizerPass(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                      final PassManagerBase /*&*/ PM) {
  final /*const*/ PassManagerBuilderWrapper /*&*/ BuilderWrapper = ((/*static_cast*//*const*/ PassManagerBuilderWrapper /*&*/ )(Builder));
  final /*const*/ CodeGenOptions /*&*/ CGOpts = BuilderWrapper.getCGOpts();
  PM.add(createMemorySanitizerPass($2bits_uint2uint(CGOpts.SanitizeMemoryTrackOrigins)));
  
  // MemorySanitizer inserts complex instrumentation that mostly follows
  // the logic of the original code, but operates on "shadow" values.
  // It can benefit from re-running some general purpose optimization passes.
  if ($greater_uint(Builder.OptLevel, 0)) {
    PM.add(createEarlyCSEPass());
    PM.add(createReassociatePass());
    PM.add(createLICMPass());
    PM.add(createGVNPass());
    PM.add(createInstructionCombiningPass());
    PM.add(createDeadStoreEliminationPass());
  }
}

//<editor-fold defaultstate="collapsed" desc="addThreadSanitizerPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 223,
 FQN="addThreadSanitizerPass", NM="_ZL22addThreadSanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL22addThreadSanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addThreadSanitizerPass(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                      final PassManagerBase /*&*/ PM) {
  PM.add(createThreadSanitizerPass());
}

//<editor-fold defaultstate="collapsed" desc="addDataFlowSanitizerPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 228,
 FQN="addDataFlowSanitizerPass", NM="_ZL24addDataFlowSanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL24addDataFlowSanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addDataFlowSanitizerPass(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                        final PassManagerBase /*&*/ PM) {
  final /*const*/ PassManagerBuilderWrapper /*&*/ BuilderWrapper = ((/*static_cast*//*const*/ PassManagerBuilderWrapper /*&*/ )(Builder));
  final /*const*/ LangOptions /*&*/ LangOpts = BuilderWrapper.getLangOpts();
  PM.add(createDataFlowSanitizerPass(LangOpts.SanitizerBlacklistFiles));
}

//<editor-fold defaultstate="collapsed" desc="addEfficiencySanitizerPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 236,
 FQN="addEfficiencySanitizerPass", NM="_ZL26addEfficiencySanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL26addEfficiencySanitizerPassRKN4llvm18PassManagerBuilderERNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static void addEfficiencySanitizerPass(final /*const*/ PassManagerBuilder /*&*/ Builder, 
                          final PassManagerBase /*&*/ PM) {
  final /*const*/ PassManagerBuilderWrapper /*&*/ BuilderWrapper = ((/*static_cast*//*const*/ PassManagerBuilderWrapper /*&*/ )(Builder));
  final /*const*/ LangOptions /*&*/ LangOpts = BuilderWrapper.getLangOpts();
  EfficiencySanitizerOptions Opts/*J*/= new EfficiencySanitizerOptions();
  if (LangOpts.Sanitize.has(SanitizerKind.EfficiencyCacheFrag)) {
    Opts.ToolType = EfficiencySanitizerOptions.Type.ESAN_CacheFrag;
  } else if (LangOpts.Sanitize.has(SanitizerKind.EfficiencyWorkingSet)) {
    Opts.ToolType = EfficiencySanitizerOptions.Type.ESAN_WorkingSet;
  }
  PM.add(createEfficiencySanitizerPass(Opts));
}

//<editor-fold defaultstate="collapsed" desc="createTLII">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 249,
 FQN="createTLII", NM="_ZL10createTLIIRN4llvm6TripleERKN5clang14CodeGenOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL10createTLIIRN4llvm6TripleERKN5clang14CodeGenOptionsE")
//</editor-fold>
public static TargetLibraryInfoImpl /*P*/ createTLII(final Triple /*&*/ TargetTriple, 
          final /*const*/ CodeGenOptions /*&*/ CodeGenOpts) {
  TargetLibraryInfoImpl /*P*/ TLII = new TargetLibraryInfoImpl(TargetTriple);
  if (!CodeGenOpts.SimplifyLibCalls) {
    TLII.disableAllFunctions();
  } else {
    // Disable individual libc/libm calls in TargetLibraryInfo.
    type$ref<org.llvm.analysis.LibFunc.target.Func> F = create_type$ref();
    for (final /*const*/std.string/*&*/ FuncName : CodeGenOpts.getNoBuiltinFuncs())  {
      if (TLII.getLibFunc(new StringRef(FuncName), F)) {
        TLII.setUnavailable(F.$deref());
      }
    }
  }
  switch (CodeGenOpts.getVecLib()) {
   case Accelerate:
    TLII.addVectorizableFunctionsFromVecLib(TargetLibraryInfoImpl.VectorLibrary.Accelerate);
    break;
   default:
    break;
  }
  return TLII;
}

//<editor-fold defaultstate="collapsed" desc="addSymbolRewriterPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 272,
 FQN="addSymbolRewriterPass", NM="_ZL21addSymbolRewriterPassRKN5clang14CodeGenOptionsEPN4llvm6legacy11PassManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL21addSymbolRewriterPassRKN5clang14CodeGenOptionsEPN4llvm6legacy11PassManagerE")
//</editor-fold>
public static void addSymbolRewriterPass(final /*const*/ CodeGenOptions /*&*/ Opts, 
                     PassManager /*P*/ MPM) {
  iplist<RewriteDescriptor> DL = null;
  try {
    DL/*J*/= new iplistRewriteDescriptor();
    
    RewriteMapParser MapParser/*J*/= new RewriteMapParser();
    for (final /*const*/std.string/*&*/ MapFile : Opts.RewriteMapFiles)  {
      MapParser.parse(MapFile, /*AddrOf*/DL);
    }
    
    MPM.add(createRewriteSymbolsPass(DL));
  } finally {
    if (DL != null) { DL.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getSectionNameForBitcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 766,
 FQN="getSectionNameForBitcode", NM="_ZL24getSectionNameForBitcodeRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL24getSectionNameForBitcodeRKN4llvm6TripleE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getSectionNameForBitcode(final /*const*/ Triple /*&*/ T) {
  switch (T.getObjectFormat()) {
   case MachO:
    return $("__LLVM,__bitcode");
   case COFF:
   case ELF:
   case UnknownObjectFormat:
    return $(".llvmbc");
  }
  throw new llvm_unreachable("Unimplemented ObjectFormatType");
}

//<editor-fold defaultstate="collapsed" desc="getSectionNameForCommandline">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 778,
 FQN="getSectionNameForCommandline", NM="_ZL28getSectionNameForCommandlineRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZL28getSectionNameForCommandlineRKN4llvm6TripleE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getSectionNameForCommandline(final /*const*/ Triple /*&*/ T) {
  switch (T.getObjectFormat()) {
   case MachO:
    return $("__LLVM,__cmdline");
   case COFF:
   case ELF:
   case UnknownObjectFormat:
    return $(".llvmcmd");
  }
  throw new llvm_unreachable("Unimplemented ObjectFormatType");
}

} // END OF class BackendUtilStatics
