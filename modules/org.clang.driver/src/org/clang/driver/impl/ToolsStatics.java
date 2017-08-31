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
package org.clang.driver.impl;

import org.llvm.support.target.ARM;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import static org.clang.config.config.ENABLE_X86_RELAX_RELOCATIONS;
import static org.clang.driver.impl.ToolsStatics.*;
import static org.clang.driver.java.JavaDriverSupport.*;
import org.llvm.support.zlib.ZlibGlobals;
import org.llvm.target.target.DebuggerKind;

//<editor-fold defaultstate="collapsed" desc="static type ToolsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL10addClangRTRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE;_ZL10getCPUNameRKN4llvm3opt7ArgListERKNS_6TripleEb;_ZL11ParseMRecipRKN5clang6driver6DriverERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE;_ZL11QuoteTargetN4llvm9StringRefERNS_15SmallVectorImplIcEE;_ZL11UseRelaxAllRN5clang6driver11CompilationERKN4llvm3opt7ArgListE;_ZL12ParsePICArgsRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListE;_ZL12forwardToGCCRKN4llvm3opt6OptionE;_ZL12getLDMOptionRKN4llvm6TripleERKNS_3opt7ArgListE;_ZL13AddGoldPluginRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEEb;_ZL13isARMMProfileRKN4llvm6TripleE;_ZL14AddRunTimeLibsRKN5clang6driver9ToolChainERKNS0_6DriverERN4llvm11SmallVectorIPKcLj16EEERKNS7_3opt7ArgListE;_ZL14SplitDebugInfoRKN5clang6driver9ToolChainERNS0_11CompilationERKNS0_4ToolERKNS0_9JobActionERKN4llvm3opt7ArgListERKNS0_9InputInfoEPKc;_ZL14SplitDebugNameRKN4llvm3opt7ArgListERKN5clang6driver9InputInfoE;_ZL14addXRayRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE;_ZL15AddLinkerInputsRKN5clang6driver9ToolChainERKN4llvm11SmallVectorINS0_9InputInfoELj4EEERKNS4_3opt7ArgListERNS5_IPKcLj16EEE;_ZL15DwarfVersionNumN4llvm9StringRefE;_ZL15checkARMCPUNameRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefESC_RSt6vectorIPKcSaISF_EERKNS4_6TripleE;_ZL15claimNoWarnArgsRKN4llvm3opt7ArgListE;_ZL15getMipsFloatABIRKN5clang6driver6DriverERKN4llvm3opt7ArgListE;_ZL15getPPCTargetCPURKN4llvm3opt7ArgListE;_ZL15getX86TargetCPURKN4llvm3opt7ArgListERKNS_6TripleE;_ZL16AddAssemblerKPICRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE;_ZL16AddTargetFeatureRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EENS0_12OptSpecifierESA_NS_9StringRefE;_ZL16addDashXForInputRKN4llvm3opt7ArgListERKN5clang6driver9InputInfoERNS_11SmallVectorIPKcLj16EEE;_ZL16addDirectoryListRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEES6_S6_;_ZL16addExceptionArgsRKN4llvm3opt7ArgListEN5clang6driver5types2IDERKNS5_9ToolChainEbRKNS4_11ObjCRuntimeERNS_11SmallVectorIPKcLj16EEE;_ZL16addOpenMPRuntimeRN4llvm11SmallVectorIPKcLj16EEERKN5clang6driver9ToolChainERKNS_3opt7ArgListE;_ZL16appendUserToPathRN4llvm15SmallVectorImplIcEE;_ZL16checkARMArchNameRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EERKNS4_6TripleE;_ZL16getOpenMPRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListE;_ZL16getR600TargetGPURKN4llvm3opt7ArgListE;_ZL16maybeConsumeDashRKSsRj;_ZL16useAAPCSForMachORKN4llvm6TripleE;_ZL17DecodeAArch64McpuRKN5clang6driver6DriverEN4llvm9StringRefERS5_RSt6vectorIPKcSaIS9_EE;_ZL17DecodeARMFeaturesRKN5clang6driver6DriverEN4llvm9StringRefERSt6vectorIPKcSaIS8_EE;_ZL17getARMFPUFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EE;_ZL17getLanaiTargetCPURKN4llvm3opt7ArgListE;_ZL17getRefinementStepN4llvm9StringRefERKN5clang6driver6DriverERKNS_3opt3ArgERj;_ZL17getTargetFeaturesRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListERNS4_11SmallVectorIPKcLj16EEEb;_ZL17isNoCommonDefaultRKN4llvm6TripleE;_ZL18addDebugCompDirArgRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEE;_ZL18isObjCAutoRefCountRKN4llvm3opt7ArgListE;_ZL19AddPS4SanitizerArgsRKN5clang6driver9ToolChainERN4llvm11SmallVectorIPKcLj16EEE;_ZL19ConstructPS4LinkJobRKN5clang6driver4ToolERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc;_ZL19RelocationModelNameN4llvm5Reloc5ModelE;_ZL19addPS4ProfileRTArgsRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE;_ZL19addSanitizerRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefEbb;_ZL19getAArch64TargetCPURKN4llvm3opt7ArgListE;_ZL19getARMHWDivFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EE;_ZL19getSystemZTargetCPURKN4llvm3opt7ArgListE;_ZL19isObjCRuntimeLinkedRKN4llvm3opt7ArgListE;_ZL19isSignedCharDefaultRKN4llvm6TripleE;_ZL19linkXRayRuntimeDepsRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE;_ZL19parseClangCLEHFlagsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE;_ZL20ConstructGoldLinkJobRKN5clang6driver4ToolERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc;_ZL20DebugLevelToInfoKindRKN4llvm3opt3ArgE;_ZL20addSanitizerRuntimesRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE;_ZL20getARMTargetFeaturesRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EEb;_ZL20getPPCTargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE;_ZL20getX86TargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE;_ZL21ContainsCompileActionPKN5clang6driver6ActionE;_ZL21DecodeAArch64FeaturesRKN5clang6driver6DriverEN4llvm9StringRefERSt6vectorIPKcSaIS8_EE;_ZL21ShouldDisableAutolinkRKN4llvm3opt7ArgListERKN5clang6driver9ToolChainE;_ZL21getARMArchCPUFromArgsRKN4llvm3opt7ArgListERNS_9StringRefES5_b;_ZL21getMIPSTargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE;_ZL21getSparcAsmModeForCPUN4llvm9StringRefERKNS_6TripleE;_ZL21shouldUseFramePointerRKN4llvm3opt7ArgListERKNS_6TripleE;_ZL22addPGOAndCoverageFlagsRN5clang6driver11CompilationERKNS0_6DriverERKNS0_9InputInfoERKN4llvm3opt7ArgListERNS9_11SmallVectorIPKcLj16EEE;_ZL22getSparcTargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE;_ZL23RenderDebugEnablingArgsRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEEN5clang14codegenoptions13DebugInfoKindEjNS_12DebuggerKindE;_ZL23addSanitizerDynamicListRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefE;_ZL23areOptimizationsEnabledRKN4llvm3opt7ArgListE;_ZL23getAMDGPUTargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE;_ZL23getWebAssemblyTargetCPURKN4llvm3opt7ArgListE;_ZL24collectSanitizerRuntimesRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_15SmallVectorImplINS4_9StringRefEEESC_SC_SC_SC_;_ZL24constructHexagonLinkArgsRN5clang6driver11CompilationERKNS0_9JobActionERKNS0_10toolchains16HexagonToolChainERKNS0_9InputInfoERKN4llvm11SmallVectorISA_Lj4EEERKNSD_3opt7ArgListERNSE_IPKcLj16EEESN_;_ZL24getAArch64TargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE;_ZL24getHexagonTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE;_ZL24getSystemZTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE;_ZL24linkSanitizerRuntimeDepsRKN5clang6driver9ToolChainERN4llvm11SmallVectorIPKcLj16EEE;_ZL25CheckPreprocessingOptionsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE;_ZL25getMSCompatibilityVersionj;_ZL25handleTargetFeaturesGroupRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EENS0_12OptSpecifierE;_ZL25shouldUseLeafFramePointerRKN4llvm3opt7ArgListERKNS_6TripleE;_ZL26CheckCodeGenerationOptionsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE;_ZL26EscapeSpacesAndBackslashesPKcRN4llvm15SmallVectorImplIcEE;_ZL26FindVisualStudioExecutableRKN5clang6driver9ToolChainEPKcS5_;_ZL26getARMSubArchVersionNumberRKN4llvm6TripleE;_ZL27ShouldDisableDwarfDirectoryRKN4llvm3opt7ArgListERKN5clang6driver9ToolChainE;_ZL27getGnuCompatibleMipsABINameN4llvm9StringRefE;_ZL28getWebAssemblyTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE;_ZL30getAArch64ArchFeaturesFromMcpuRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE;_ZL30shouldEnableVectorizerAtOLevelRKN4llvm3opt7ArgListEb;_ZL30shouldUseFramePointerForTargetRKN4llvm3opt7ArgListERKNS_6TripleE;_ZL31getAArch64ArchFeaturesFromMarchRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE;_ZL33CollectArgsForIntegratedAssemblerRN5clang6driver11CompilationERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEERKNS0_6DriverE;_ZL34addExtraOffloadSpecificIncludeArgsRN5clang6driver11CompilationERKNS0_9JobActionERKN4llvm3opt7ArgListERNS6_11SmallVectorIPKcLj16EEE;_ZL35addExtraOffloadCXXStdlibIncludeArgsRN5clang6driver11CompilationERKNS0_9JobActionERKN4llvm3opt7ArgListERNS6_11SmallVectorIPKcLj16EEE;_ZL35getAArch64MicroArchFeaturesFromMcpuRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE;_ZL36getAArch64MicroArchFeaturesFromMtuneRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE;_ZL41shouldUseExceptionTablesForObjCExceptionsRKN5clang11ObjCRuntimeERKN4llvm6TripleE;_ZL9AddLibgccRKN4llvm6TripleERKN5clang6driver6DriverERNS_11SmallVectorIPKcLj16EEERKNS_3opt7ArgListE; -static-type=ToolsStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class ToolsStatics {

//<editor-fold defaultstate="collapsed" desc="handleTargetFeaturesGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 55,
 FQN="handleTargetFeaturesGroup", NM="_ZL25handleTargetFeaturesGroupRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EENS0_12OptSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL25handleTargetFeaturesGroupRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EENS0_12OptSpecifierE")
//</editor-fold>
public static void handleTargetFeaturesGroup(/*const*/ ArgList /*&*/ Args, 
                         vectorCharPtr/*&*/ Features, 
                         OptSpecifier Group) {
  for (/*const*/ Arg /*P*/ A : Args.filtered(/*NO_COPY*/Group)) {
    StringRef Name = A.getOption().getName();
    A.claim();
    
    // Skip over "-m".
    assert (Name.startswith(/*STRINGREF_STR*/"m")) : "Invalid feature name.";
    Name.$assignMove(Name.substr(1));
    
    boolean IsNegative = Name.startswith(/*STRINGREF_STR*/"no-");
    if (IsNegative) {
      Name.$assignMove(Name.substr(3));
    }
    Features.push_back(Args.MakeArgString($add_char$ptr$C_StringRef((IsNegative ? $MINUS : $PLUS), Name)));
  }
}

//<editor-fold defaultstate="collapsed" desc="getSparcAsmModeForCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 73,
 FQN="getSparcAsmModeForCPU", NM="_ZL21getSparcAsmModeForCPUN4llvm9StringRefERKNS_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL21getSparcAsmModeForCPUN4llvm9StringRefERKNS_6TripleE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getSparcAsmModeForCPU(StringRef Name, 
                     /*const*/ Triple /*&*/ _Triple) {
  if (_Triple.getArch() == Triple.ArchType.sparcv9) {
    return new StringSwitchCharPtr(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"niagara", /*KEEP_STR*/"-Av9b").
        Case(/*KEEP_STR*/"niagara2", /*KEEP_STR*/"-Av9b").
        Case(/*KEEP_STR*/"niagara3", /*KEEP_STR*/"-Av9d").
        Case(/*KEEP_STR*/"niagara4", /*KEEP_STR*/"-Av9d").
        Default(/*KEEP_STR*/"-Av9");
  } else {
    return new StringSwitchCharPtr(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"v8", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"supersparc", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"sparclite", /*KEEP_STR*/"-Asparclite").
        Case(/*KEEP_STR*/"f934", /*KEEP_STR*/"-Asparclite").
        Case(/*KEEP_STR*/"hypersparc", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"sparclite86x", /*KEEP_STR*/"-Asparclite").
        Case(/*KEEP_STR*/"sparclet", /*KEEP_STR*/"-Asparclet").
        Case(/*KEEP_STR*/"tsc701", /*KEEP_STR*/"-Asparclet").
        Case(/*KEEP_STR*/"v9", /*KEEP_STR*/"-Av8plus").
        Case(/*KEEP_STR*/"ultrasparc", /*KEEP_STR*/"-Av8plus").
        Case(/*KEEP_STR*/"ultrasparc3", /*KEEP_STR*/"-Av8plus").
        Case(/*KEEP_STR*/"niagara", /*KEEP_STR*/"-Av8plusb").
        Case(/*KEEP_STR*/"niagara2", /*KEEP_STR*/"-Av8plusb").
        Case(/*KEEP_STR*/"niagara3", /*KEEP_STR*/"-Av8plusd").
        Case(/*KEEP_STR*/"niagara4", /*KEEP_STR*/"-Av8plusd").
        Case(/*KEEP_STR*/"leon2", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"at697e", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"at697f", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"leon3", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"ut699", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"gr712rc", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"leon4", /*KEEP_STR*/"-Av8").
        Case(/*KEEP_STR*/"gr740", /*KEEP_STR*/"-Av8").
        Default(/*KEEP_STR*/"-Av8");
  }
}


/// CheckPreprocessingOptions - Perform some validation of preprocessing
/// arguments that is shared with gcc.
//<editor-fold defaultstate="collapsed" desc="CheckPreprocessingOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 113,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 105,
 FQN="CheckPreprocessingOptions", NM="_ZL25CheckPreprocessingOptionsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL25CheckPreprocessingOptionsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE")
//</editor-fold>
public static void CheckPreprocessingOptions(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_C.getValue()), new OptSpecifier(options.ID.OPT_CC.getValue()));
    if ((A != null)) {
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_E.getValue())) && !Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_P.getValue()))
         && !Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_EP.getValue())) && !D.CCCIsCPP()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), 
                  new StringRef(A.getBaseArg().getAsString(Args))), 
              (D.IsCLMode() ? $("/E, /P or /EP") : $("-E"))));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


/// CheckCodeGenerationOptions - Perform some validation of code generation
/// arguments that is shared with gcc.
//<editor-fold defaultstate="collapsed" desc="CheckCodeGenerationOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 126,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 118,
 FQN="CheckCodeGenerationOptions", NM="_ZL26CheckCodeGenerationOptionsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL26CheckCodeGenerationOptionsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE")
//</editor-fold>
public static void CheckCodeGenerationOptions(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args) {
  // In gcc, only ARM checks this, but it seems reasonable to check universally.
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_dynamic.getValue()), new OptSpecifier(options.ID.OPT_mdynamic_no_pic.getValue()));
      if ((A != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), new StringRef(A.getAsString(Args))), 
              /*KEEP_STR*/"-static"));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


// Add backslashes to escape spaces and other backslashes.
// This is used for the space-separated argument list specified with
// the -dwarf-debug-flags option.
//<editor-fold defaultstate="collapsed" desc="EscapeSpacesAndBackslashes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*perf*/,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 138,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 130,
 FQN="EscapeSpacesAndBackslashes", NM="_ZL26EscapeSpacesAndBackslashesPKcRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL26EscapeSpacesAndBackslashesPKcRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void EscapeSpacesAndBackslashes(/*const*/char$ptr/*char P*/ Arg, 
                          SmallString/*&*/ Res) {
  int idx = 0;
  /*char*/byte cur;
  for (; ((cur = Arg.$at(idx)) != $$TERM); ++idx) {
    switch (cur) {
     default:
      break;
     case ' ':
     case '\\':
      Res.push_back($$BACK_SLASH);
      break;
    }
    Res.push_back(cur);
  }
}


// Quote target names for inclusion in GNU Make dependency files.
// Only the characters '$', '#', ' ', '\t' are quoted.
//<editor-fold defaultstate="collapsed" desc="QuoteTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 155,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 147,
 FQN="QuoteTarget", NM="_ZL11QuoteTargetN4llvm9StringRefERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL11QuoteTargetN4llvm9StringRefERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static void QuoteTarget(StringRef Target, SmallString/*&*/ Res) {
  for (/*uint*/int i = 0, e = Target.size(); i != e; ++i) {
    switch (Target.$at(i)) {
     case ' ':
     case '\t':
      // Escape the preceding backslashes
      for (int j = i - 1; j >= 0 && Target.$at(j) == $$BACK_SLASH; --j)  {
        Res.push_back($$BACK_SLASH);
      }
      
      // Escape the space/tab
      Res.push_back($$BACK_SLASH);
      break;
     case '$':
      Res.push_back($$DOLLAR);
      break;
     case '#':
      Res.push_back($$BACK_SLASH);
      break;
     default:
      break;
    }
    
    Res.push_back(Target.$at(i));
  }
}

//<editor-fold defaultstate="collapsed" desc="addDirectoryList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 181,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 173,
 FQN="addDirectoryList", NM="_ZL16addDirectoryListRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16addDirectoryListRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEES6_S6_")
//</editor-fold>
public static void addDirectoryList(/*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs, 
                /*const*/char$ptr/*char P*/ ArgName, /*const*/char$ptr/*char P*/ EnvVar) {
  /*const*/char$ptr/*char P*/ DirList = $tryClone(/*::*/getenv(EnvVar));
  boolean CombinedArg = false;
  if (!(DirList != null)) {
    return; // Nothing to do.
  }
  
  StringRef Name/*J*/= new StringRef(ArgName);
  if (Name.equals(/*STRINGREF_STR*/"-I") || Name.equals(/*STRINGREF_STR*/"-L")) {
    CombinedArg = true;
  }
  
  StringRef Dirs/*J*/= new StringRef(DirList);
  if (Dirs.empty()) { // Empty string should not add '.'.
    return;
  }
  
  /*size_t*/int Delim;
  while ((Delim = Dirs.find(sys.EnvPathSeparator)) != StringRef.npos) {
    if (Delim == 0) { // Leading colon.
      if (CombinedArg) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(ArgName), /*KEEP_STR*/"."))));
      } else {
        CmdArgs.push_back(ArgName);
        CmdArgs.push_back($DOT);
      }
    } else {
      if (CombinedArg) {
        CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(new std.string(ArgName)), new Twine(Dirs.substr(0, Delim)))));
      } else {
        CmdArgs.push_back(ArgName);
        CmdArgs.push_back(Args.MakeArgString(new Twine(Dirs.substr(0, Delim))));
      }
    }
    Dirs.$assignMove(Dirs.substr(Delim + 1));
  }
  if (Dirs.empty()) { // Trailing colon.
    if (CombinedArg) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(ArgName), /*KEEP_STR*/"."))));
    } else {
      CmdArgs.push_back(ArgName);
      CmdArgs.push_back($DOT);
    }
  } else { // Add the last path.
    if (CombinedArg) {
      CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(new std.string(ArgName)), new Twine(Dirs))));
    } else {
      CmdArgs.push_back(ArgName);
      CmdArgs.push_back(Args.MakeArgString(new Twine(Dirs)));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="AddLinkerInputs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 235,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 227,
 FQN="AddLinkerInputs", NM="_ZL15AddLinkerInputsRKN5clang6driver9ToolChainERKN4llvm11SmallVectorINS0_9InputInfoELj4EEERKNS4_3opt7ArgListERNS5_IPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL15AddLinkerInputsRKN5clang6driver9ToolChainERKN4llvm11SmallVectorINS0_9InputInfoELj4EEERKNS4_3opt7ArgListERNS5_IPKcLj16EEE")
//</editor-fold>
public static void AddLinkerInputs(/*const*/ ToolChain /*&*/ TC, /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
               /*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs) {
  /*const*/ Driver /*&*/ D = TC.getDriver();
  
  // Add extra linker input arguments which are not treated as inputs
  // (constructed via -Xarch_).
  Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Zlinker_input.getValue()));
  
  for (/*const*/ InputInfo /*&*/ II : Inputs) {
    if (!TC.HasNativeLLVMSupport() && types.isLLVMIR(II.getType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Don't try to pass LLVM inputs unless we have native support.
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_linker_llvm_support)), new StringRef(TC.getTripleString())));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Add filenames immediately.
    if (II.isFilename()) {
      CmdArgs.push_back(II.getFilename());
      continue;
    }
    
    // Otherwise, this is a linker input argument.
    /*const*/ Arg /*&*/ A = II.getInputArg();
    
    // Handle reserved library options.
    if (A.getOption().matches(new OptSpecifier(options.ID.OPT_Z_reserved_lib_stdcxx.getValue()))) {
      TC.AddCXXStdlibLibArgs(Args, CmdArgs);
    } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_Z_reserved_lib_cckext.getValue()))) {
      TC.AddCCKextLibArgs(Args, CmdArgs);
    } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_z.getValue()))) {
      // Pass -z prefix for gcc linker compatibility.
      A.claim();
      A.render(Args, CmdArgs);
    } else {
      A.renderAsInput(Args, CmdArgs);
    }
  }
  
  // LIBRARY_PATH - included following the user specified library paths.
  //                and only supported on native toolchains.
  if (!TC.isCrossCompiling()) {
    addDirectoryList(Args, CmdArgs, $("-L"), $("LIBRARY_PATH"));
  }
}


/// \brief Determine whether Objective-C automated reference counting is
/// enabled.
//<editor-fold defaultstate="collapsed" desc="isObjCAutoRefCount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 279,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 271,
 FQN="isObjCAutoRefCount", NM="_ZL18isObjCAutoRefCountRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL18isObjCAutoRefCountRKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean isObjCAutoRefCount(/*const*/ ArgList /*&*/ Args) {
  return Args.hasFlag(new OptSpecifier(options.ID.OPT_fobjc_arc.getValue()), new OptSpecifier(options.ID.OPT_fno_objc_arc.getValue()), false);
}


/// \brief Determine whether we are linking the ObjC runtime.
//<editor-fold defaultstate="collapsed" desc="isObjCRuntimeLinked">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 284,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 276,
 FQN="isObjCRuntimeLinked", NM="_ZL19isObjCRuntimeLinkedRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19isObjCRuntimeLinkedRKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean isObjCRuntimeLinked(/*const*/ ArgList /*&*/ Args) {
  if (isObjCAutoRefCount(Args)) {
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fobjc_link_runtime.getValue()));
    return true;
  }
  return Args.hasArg(new OptSpecifier(options.ID.OPT_fobjc_link_runtime.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="forwardToGCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 292,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 284,
 FQN="forwardToGCC", NM="_ZL12forwardToGCCRKN4llvm3opt6OptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL12forwardToGCCRKN4llvm3opt6OptionE")
//</editor-fold>
public static boolean forwardToGCC(/*const*/ Option /*&*/ O) {
  // Don't forward inputs from the original command line.  They are added from
  // InputInfoList.
  return O.getKind() != Option.OptionClass.InputClass
     && !O.hasFlag(options.ClangFlags.DriverOption) && !O.hasFlag(options.ClangFlags.LinkerInput);
}


/// Add the C++ include args of other offloading toolchains. If this is a host
/// job, the device toolchains are added. If this is a device job, the host
/// toolchains will be added.
//<editor-fold defaultstate="collapsed" desc="addExtraOffloadCXXStdlibIncludeArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 302,
 FQN="addExtraOffloadCXXStdlibIncludeArgs", NM="_ZL35addExtraOffloadCXXStdlibIncludeArgsRN5clang6driver11CompilationERKNS0_9JobActionERKN4llvm3opt7ArgListERNS6_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL35addExtraOffloadCXXStdlibIncludeArgsRN5clang6driver11CompilationERKNS0_9JobActionERKN4llvm3opt7ArgListERNS6_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void addExtraOffloadCXXStdlibIncludeArgs(Compilation /*&*/ C, 
                                   /*const*/ JobAction /*&*/ JA, 
                                   /*const*/ ArgList /*&*/ Args, 
                                   ArgStringList/*&*/ CmdArgs) {
  if (JA.isHostOffloading(Action.OffloadKind.OFK_Cuda)) {
    C.getSingleOffloadToolChain(Action.OffloadKind.OFK_Cuda).
        AddClangCXXStdlibIncludeArgs(Args, CmdArgs);
  } else if (JA.isDeviceOffloading(Action.OffloadKind.OFK_Cuda)) {
    C.getSingleOffloadToolChain(Action.OffloadKind.OFK_Host).
        AddClangCXXStdlibIncludeArgs(Args, CmdArgs);
  }
  // TODO: Add support for other programming models here.
}


/// Add the include args that are specific of each offloading programming model.
//<editor-fold defaultstate="collapsed" desc="addExtraOffloadSpecificIncludeArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 318,
 FQN="addExtraOffloadSpecificIncludeArgs", NM="_ZL34addExtraOffloadSpecificIncludeArgsRN5clang6driver11CompilationERKNS0_9JobActionERKN4llvm3opt7ArgListERNS6_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL34addExtraOffloadSpecificIncludeArgsRN5clang6driver11CompilationERKNS0_9JobActionERKN4llvm3opt7ArgListERNS6_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void addExtraOffloadSpecificIncludeArgs(Compilation /*&*/ C, 
                                  /*const*/ JobAction /*&*/ JA, 
                                  /*const*/ ArgList /*&*/ Args, 
                                  ArgStringList/*&*/ CmdArgs) {
  if (JA.isHostOffloading(Action.OffloadKind.OFK_Cuda)) {
    C.getSingleOffloadToolChain(Action.OffloadKind.OFK_Host).AddCudaIncludeArgs(Args, CmdArgs);
  } else if (JA.isDeviceOffloading(Action.OffloadKind.OFK_Cuda)) {
    C.getSingleOffloadToolChain(Action.OffloadKind.OFK_Cuda).AddCudaIncludeArgs(Args, CmdArgs);
  }
  // TODO: Add support for other programming models here.
}


// FIXME: Move to target hook.
//<editor-fold defaultstate="collapsed" desc="isSignedCharDefault">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 626,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 511,
 FQN="isSignedCharDefault", NM="_ZL19isSignedCharDefaultRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19isSignedCharDefaultRKN4llvm6TripleE")
//</editor-fold>
public static boolean isSignedCharDefault(/*const*/ Triple /*&*/ _Triple) {
  switch (_Triple.getArch()) {
   default:
    return true;
   case aarch64:
   case aarch64_be:
   case arm:
   case armeb:
   case thumb:
   case thumbeb:
    if (_Triple.isOSDarwin() || _Triple.isOSWindows()) {
      return true;
    }
    return false;
   case ppc:
   case ppc64:
    if (_Triple.isOSDarwin()) {
      return true;
    }
    return false;
   case hexagon:
   case ppc64le:
   case systemz:
   case xcore:
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="isNoCommonDefault">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 655,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 540,
 FQN="isNoCommonDefault", NM="_ZL17isNoCommonDefaultRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL17isNoCommonDefaultRKN4llvm6TripleE")
//</editor-fold>
public static boolean isNoCommonDefault(/*const*/ Triple /*&*/ _Triple) {
  switch (_Triple.getArch()) {
   default:
    return false;
   case xcore:
   case wasm32:
   case wasm64:
    return true;
  }
}


// ARM tools start.

// Get SubArch (vN).
//<editor-fold defaultstate="collapsed" desc="getARMSubArchVersionNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 670,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 555,
 FQN="getARMSubArchVersionNumber", NM="_ZL26getARMSubArchVersionNumberRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL26getARMSubArchVersionNumberRKN4llvm6TripleE")
//</editor-fold>
public static int getARMSubArchVersionNumber(/*const*/ Triple /*&*/ _Triple) {
  StringRef Arch = _Triple.getArchName();
  return ARM.parseArchVersion(/*NO_COPY*/Arch);
}


// True if M-profile.
//<editor-fold defaultstate="collapsed" desc="isARMMProfile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 676,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 561,
 FQN="isARMMProfile", NM="_ZL13isARMMProfileRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL13isARMMProfileRKN4llvm6TripleE")
//</editor-fold>
public static boolean isARMMProfile(/*const*/ Triple /*&*/ _Triple) {
  StringRef Arch = _Triple.getArchName();
  /*uint*/int Profile = ARM.parseArchProfile(/*NO_COPY*/Arch);
  return Profile == ARM.ProfileKind.PK_M.getValue();
}


// Get Arch/CPU from args.
//<editor-fold defaultstate="collapsed" desc="getARMArchCPUFromArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 683,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 568,
 FQN="getARMArchCPUFromArgs", NM="_ZL21getARMArchCPUFromArgsRKN4llvm3opt7ArgListERNS_9StringRefES5_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL21getARMArchCPUFromArgsRKN4llvm3opt7ArgListERNS_9StringRefES5_b")
//</editor-fold>
public static void getARMArchCPUFromArgs(/*const*/ ArgList /*&*/ Args, StringRef /*&*/ Arch, 
                     StringRef /*&*/ CPU) {
  getARMArchCPUFromArgs(Args, Arch, 
                     CPU, false);
}
public static void getARMArchCPUFromArgs(/*const*/ ArgList /*&*/ Args, StringRef /*&*/ Arch, 
                     StringRef /*&*/ CPU, boolean FromAs/*= false*/) {
  {
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
    if ((A != null)) {
      CPU.$assignMove(/*STRINGREF_STR*/A.getValue());
    }
  }
  {
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
    if ((A != null)) {
      Arch.$assignMove(/*STRINGREF_STR*/A.getValue());
    }
  }
  if (!FromAs) {
    return;
  }
  
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()))) {
    StringRef Value = new StringRef(A.getValue());
    if (Value.startswith(/*STRINGREF_STR*/"-mcpu=")) {
      CPU.$assignMove(Value.substr(6));
    }
    if (Value.startswith(/*STRINGREF_STR*/"-march=")) {
      Arch.$assignMove(Value.substr(7));
    }
  }
}


// Handle -mhwdiv=.
// FIXME: Use ARMTargetParser.
//<editor-fold defaultstate="collapsed" desc="getARMHWDivFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 704,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 589,
 FQN="getARMHWDivFeatures", NM="_ZL19getARMHWDivFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19getARMHWDivFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EE")
//</editor-fold>
public static void getARMHWDivFeatures(/*const*/ Driver /*&*/ D, /*const*/ Arg /*P*/ A, 
                   /*const*/ ArgList /*&*/ Args, StringRef HWDiv, 
                   vectorCharPtr/*&*/ Features) {
  /*uint*/int HWDivID = ARM.parseHWDiv(/*NO_COPY*/HWDiv);
  if (!ARM.getHWDivFeatures(HWDivID, Features)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported)), new StringRef(A.getAsString(Args))));
    } finally {
      $c$.$destroy();
    }
  }
}


// Handle -mfpu=.
//<editor-fold defaultstate="collapsed" desc="getARMFPUFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 713,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 598,
 FQN="getARMFPUFeatures", NM="_ZL17getARMFPUFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL17getARMFPUFeaturesRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EE")
//</editor-fold>
public static void getARMFPUFeatures(/*const*/ Driver /*&*/ D, /*const*/ Arg /*P*/ A, 
                 /*const*/ ArgList /*&*/ Args, StringRef FPU, 
                 vectorCharPtr/*&*/ Features) {
  /*uint*/int FPUID = ARM.parseFPU(/*NO_COPY*/FPU);
  if (!ARM.getFPUFeatures(FPUID, Features)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported)), new StringRef(A.getAsString(Args))));
    } finally {
      $c$.$destroy();
    }
  }
}


// Decode ARM features from string like +[no]featureA+[no]featureB+...
//<editor-fold defaultstate="collapsed" desc="DecodeARMFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 722,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 607,
 FQN="DecodeARMFeatures", NM="_ZL17DecodeARMFeaturesRKN5clang6driver6DriverEN4llvm9StringRefERSt6vectorIPKcSaIS8_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL17DecodeARMFeaturesRKN5clang6driver6DriverEN4llvm9StringRefERSt6vectorIPKcSaIS8_EE")
//</editor-fold>
public static boolean DecodeARMFeatures(/*const*/ Driver /*&*/ D, StringRef text, 
                 vectorCharPtr/*&*/ Features) {
  SmallVector<StringRef> Split/*J*/= new SmallVector<StringRef>(8, new StringRef());
  text.split(Split, /*STRINGREF_STR*/"+", -1, /*KEEP_BOOL*/false);
  
  for (StringRef Feature : Split) {
    /*const*/char$ptr/*char P*/ FeatureName = $tryClone(ARM.getArchExtFeature(/*NO_COPY*/Feature));
    if ((FeatureName != null)) {
      Features.push_back(FeatureName);
    } else {
      return false;
    }
  }
  return true;
}


// Check if -march is valid by checking if it can be canonicalised and parsed.
// getARMArch is used here instead of just checking the -march value in order
// to handle -march=native correctly.
//<editor-fold defaultstate="collapsed" desc="checkARMArchName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 740,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 625,
 FQN="checkARMArchName", NM="_ZL16checkARMArchNameRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EERKNS4_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16checkARMArchNameRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefERSt6vectorIPKcSaISF_EERKNS4_6TripleE")
//</editor-fold>
public static void checkARMArchName(/*const*/ Driver /*&*/ D, /*const*/ Arg /*P*/ A, /*const*/ ArgList /*&*/ Args, 
                StringRef ArchName, 
                vectorCharPtr/*&*/ Features, 
                /*const*/ Triple /*&*/ _Triple) {
  std.pair<StringRef, StringRef> Split = ArchName.split(/*STRINGREF_STR*/"+");
  
  std.string MArch = ArmStatics.getARMArch(new StringRef(ArchName), _Triple);
  if (ARM.parseArch(new StringRef(MArch)) == ARM.ArchKind.AK_INVALID.getValue()
     || ((Split.second.size() != 0) && !DecodeARMFeatures(D, new StringRef(Split.second), Features))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported)), new StringRef(A.getAsString(Args))));
    } finally {
      $c$.$destroy();
    }
  }
}


// Check -mcpu=. Needs ArchName to handle -mcpu=generic.
//<editor-fold defaultstate="collapsed" desc="checkARMCPUName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 753,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 638,
 FQN="checkARMCPUName", NM="_ZL15checkARMCPUNameRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefESC_RSt6vectorIPKcSaISF_EERKNS4_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL15checkARMCPUNameRKN5clang6driver6DriverEPKN4llvm3opt3ArgERKNS5_7ArgListENS4_9StringRefESC_RSt6vectorIPKcSaISF_EERKNS4_6TripleE")
//</editor-fold>
public static void checkARMCPUName(/*const*/ Driver /*&*/ D, /*const*/ Arg /*P*/ A, /*const*/ ArgList /*&*/ Args, 
               StringRef CPUName, StringRef ArchName, 
               vectorCharPtr/*&*/ Features, 
               /*const*/ Triple /*&*/ _Triple) {
  std.pair<StringRef, StringRef> Split = CPUName.split(/*STRINGREF_STR*/"+");
  
  std.string CPU = ArmStatics.getARMTargetCPU(new StringRef(CPUName), new StringRef(ArchName), _Triple);
  if (ArmStatics.getLLVMArchSuffixForARM(new StringRef(CPU), new StringRef(ArchName), _Triple).empty()
     || ((Split.second.size() != 0) && !DecodeARMFeatures(D, new StringRef(Split.second), Features))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported)), new StringRef(A.getAsString(Args))));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="useAAPCSForMachO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 765,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 650,
 FQN="useAAPCSForMachO", NM="_ZL16useAAPCSForMachORKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16useAAPCSForMachORKN4llvm6TripleE")
//</editor-fold>
public static boolean useAAPCSForMachO(/*const*/ Triple /*&*/ T) {
  // The backend is hardwired to assume AAPCS for M-class processors, ensure
  // the frontend matches that.
  return T.getEnvironment() == Triple.EnvironmentType.EABI
     || T.getOS() == Triple.OSType.UnknownOS || isARMMProfile(T);
}

//<editor-fold defaultstate="collapsed" desc="getARMTargetFeatures">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 876,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 753,
 FQN="getARMTargetFeatures", NM="_ZL20getARMTargetFeaturesRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL20getARMTargetFeaturesRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EEb")
//</editor-fold>
public static void getARMTargetFeatures(/*const*/ ToolChain /*&*/ TC, 
                    /*const*/ Triple /*&*/ _Triple, 
                    /*const*/ ArgList /*&*/ Args, 
                    vectorCharPtr/*&*/ Features, 
                    boolean ForAS) {
  /*const*/ Driver /*&*/ D = TC.getDriver();
  
  boolean KernelOrKext = Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()), new OptSpecifier(options.ID.OPT_fapple_kext.getValue()));
  ArmStatics.FloatABI ABI = ArmStatics.getARMFloatABI(TC, Args);
  /*const*/ Arg /*P*/ WaCPU = null, /*P*/ WaFPU = null;
  /*const*/ Arg /*P*/ WaHDiv = null, /*P*/ WaArch = null;
  if (!ForAS) {
    // FIXME: Note, this is a hack, the LLVM backend doesn't actually use these
    // yet (it uses the -mfloat-abi and -msoft-float options), and it is
    // stripped out by the ARM target. We should probably pass this a new
    // -target-option, which is handled by the -cc1/-cc1as invocation.
    //
    // FIXME2:  For consistency, it would be ideal if we set up the target
    // machine state the same when using the frontend or the assembler. We don't
    // currently do that for the assembler, we pass the options directly to the
    // backend and never even instantiate the frontend TargetInfo. If we did,
    // and used its handleTargetFeatures hook, then we could ensure the
    // assembler and the frontend behave the same.
    
    // Use software floating point operations?
    if (ABI == ArmStatics.FloatABI.Soft) {
      Features.push_back($("+soft-float"));
    }
    
    // Use software floating point argument passing?
    if (ABI != ArmStatics.FloatABI.Hard) {
      Features.push_back($("+soft-float-abi"));
    }
  } else {
    // Here, we make sure that -Wa,-mfpu/cpu/arch/hwdiv will be passed down
    // to the assembler correctly.
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()))) {
      StringRef Value = new StringRef(A.getValue());
      if (Value.startswith(/*STRINGREF_STR*/"-mfpu=")) {
        WaFPU = A;
      } else if (Value.startswith(/*STRINGREF_STR*/"-mcpu=")) {
        WaCPU = A;
      } else if (Value.startswith(/*STRINGREF_STR*/"-mhwdiv=")) {
        WaHDiv = A;
      } else if (Value.startswith(/*STRINGREF_STR*/"-march=")) {
        WaArch = A;
      }
    }
  }
  
  // Check -march. ClangAs gives preference to -Wa,-march=.
  /*const*/ Arg /*P*/ ArchArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
  StringRef ArchName/*J*/= new StringRef();
  if ((WaArch != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ((ArchArg != null)) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_unused_argument)), 
            new StringRef(ArchArg.getAsString(Args))));
      }
      ArchName.$assignMove(new StringRef(WaArch.getValue()).substr(7));
      checkARMArchName(D, WaArch, Args, new StringRef(ArchName), Features, _Triple);
      // FIXME: Set Arch.
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_unused_argument)), new StringRef(WaArch.getAsString(Args))));
    } finally {
      $c$.$destroy();
    }
  } else if ((ArchArg != null)) {
    ArchName.$assignMove(/*STRINGREF_STR*/ArchArg.getValue());
    checkARMArchName(D, ArchArg, Args, new StringRef(ArchName), Features, _Triple);
  }
  
  // Check -mcpu. ClangAs gives preference to -Wa,-mcpu=.
  /*const*/ Arg /*P*/ CPUArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
  StringRef CPUName/*J*/= new StringRef();
  if ((WaCPU != null)) {
    if ((CPUArg != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_unused_argument)), 
            new StringRef(CPUArg.getAsString(Args))));
      } finally {
        $c$.$destroy();
      }
    }
    CPUName.$assignMove(new StringRef(WaCPU.getValue()).substr(6));
    checkARMCPUName(D, WaCPU, Args, new StringRef(CPUName), new StringRef(ArchName), Features, _Triple);
  } else if ((CPUArg != null)) {
    CPUName.$assignMove(/*STRINGREF_STR*/CPUArg.getValue());
    checkARMCPUName(D, CPUArg, Args, new StringRef(CPUName), new StringRef(ArchName), Features, _Triple);
  }
  
  // Add CPU features for generic CPUs
  if ($eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"native")) {
    StringMapBool HostFeatures = null;
    try {
      HostFeatures/*J*/= new StringMapBool(false);
      if (sys.getHostCPUFeatures(HostFeatures)) {
        for (StringMapEntryBool/*&*/ F : HostFeatures)  {
          Features.push_back(Args.MakeArgString($add_char$ptr$C_StringRef((F.second ? $PLUS : $MINUS), F.first())));
        }
      }
    } finally {
      if (HostFeatures != null) { HostFeatures.$destroy(); }
    }
  }
  
  // Honor -mfpu=. ClangAs gives preference to -Wa,-mfpu=.
  /*const*/ Arg /*P*/ FPUArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_mfpu_EQ.getValue()));
  if ((WaFPU != null)) {
    if ((FPUArg != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_unused_argument)), 
            new StringRef(FPUArg.getAsString(Args))));
      } finally {
        $c$.$destroy();
      }
    }
    getARMFPUFeatures(D, WaFPU, Args, new StringRef(WaFPU.getValue()).substr(6), 
        Features);
  } else if ((FPUArg != null)) {
    getARMFPUFeatures(D, FPUArg, Args, new StringRef(FPUArg.getValue()), Features);
  }
  
  // Honor -mhwdiv=. ClangAs gives preference to -Wa,-mhwdiv=.
  /*const*/ Arg /*P*/ HDivArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_mhwdiv_EQ.getValue()));
  if ((WaHDiv != null)) {
    if ((HDivArg != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_unused_argument)), 
            new StringRef(HDivArg.getAsString(Args))));
      } finally {
        $c$.$destroy();
      }
    }
    getARMHWDivFeatures(D, WaHDiv, Args, 
        new StringRef(WaHDiv.getValue()).substr(8), Features);
  } else if ((HDivArg != null)) {
    getARMHWDivFeatures(D, HDivArg, Args, new StringRef(HDivArg.getValue()), Features);
  }
  
  // Setting -msoft-float effectively disables NEON because of the GCC
  // implementation, although the same isn't true of VFP or VFP3.
  if (ABI == ArmStatics.FloatABI.Soft) {
    Features.push_back($("-neon"));
    // Also need to explicitly disable features which imply NEON.
    Features.push_back($("-crypto"));
  }
  {
    
    // En/disable crc code generation.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcrc.getValue()), new OptSpecifier(options.ID.OPT_mnocrc.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mcrc.getValue()))) {
        Features.push_back($("+crc"));
      } else {
        Features.push_back($("-crc"));
      }
    }
  }
  {
    
    // Look for the last occurrence of -mlong-calls or -mno-long-calls. If
    // neither options are specified, see if we are compiling for kernel/kext and
    // decide whether to pass "+long-calls" based on the OS and its version.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mlong_calls.getValue()), 
        new OptSpecifier(options.ID.OPT_mno_long_calls.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mlong_calls.getValue()))) {
        Features.push_back($("+long-calls"));
      }
    } else if (KernelOrKext && (!_Triple.isiOS() || _Triple.isOSVersionLT(6))
       && !_Triple.isWatchOS()) {
      Features.push_back($("+long-calls"));
    }
  }
  
  // Kernel code has more strict alignment requirements.
  if (KernelOrKext) {
    Features.push_back($("+strict-align"));
  } else {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mno_unaligned_access.getValue()), 
        new OptSpecifier(options.ID.OPT_munaligned_access.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_munaligned_access.getValue()))) {
        // No v6M core supports unaligned memory access (v6M ARM ARM A3.2).
        if (_Triple.getSubArch() == Triple.SubArchType.ARMSubArch_v6m) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_target_unsupported_unaligned)), /*KEEP_STR*/"v6m"));
          } finally {
            $c$.$destroy();
          }
        } else // v8M Baseline follows on from v6M, so doesn't support unaligned memory
        // access either.
        if (_Triple.getSubArch() == Triple.SubArchType.ARMSubArch_v8m_baseline) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_target_unsupported_unaligned)), /*KEEP_STR*/"v8m.base"));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        Features.push_back($("+strict-align"));
      }
    } else {
      // Assume pre-ARMv6 doesn't support unaligned accesses.
      //
      // ARMv6 may or may not support unaligned accesses depending on the
      // SCTLR.U bit, which is architecture-specific. We assume ARMv6
      // Darwin and NetBSD targets support unaligned accesses, and others don't.
      //
      // ARMv7 always has SCTLR.U set to 1, but it has a new SCTLR.A bit
      // which raises an alignment fault on unaligned accesses. Linux
      // defaults this bit to 0 and handles it as a system-wide (not
      // per-process) setting. It is therefore safe to assume that ARMv7+
      // Linux targets support unaligned accesses. The same goes for NaCl.
      //
      // The above behavior is consistent with GCC.
      int VersionNum = getARMSubArchVersionNumber(_Triple);
      if (_Triple.isOSDarwin() || _Triple.isOSNetBSD()) {
        if (VersionNum < 6
           || _Triple.getSubArch() == Triple.SubArchType.ARMSubArch_v6m) {
          Features.push_back($("+strict-align"));
        }
      } else if (_Triple.isOSLinux() || _Triple.isOSNaCl()) {
        if (VersionNum < 7) {
          Features.push_back($("+strict-align"));
        }
      } else {
        Features.push_back($("+strict-align"));
      }
    }
  }
  
  // llvm does not support reserving registers in general. There is support
  // for reserving r9 on ARM though (defined as a platform-specific register
  // in ARM EABI).
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_ffixed_r9.getValue()))) {
    Features.push_back($("+reserve-r9"));
  }
  
  // The kext linker doesn't know how to deal with movw/movt.
  if (KernelOrKext || Args.hasArg(new OptSpecifier(options.ID.OPT_mno_movt.getValue()))) {
    Features.push_back($("+no-movt"));
  }
}

// ARM tools end.

/// getAArch64TargetCPU - Get the (LLVM) name of the AArch64 cpu we are
/// targeting.
//<editor-fold defaultstate="collapsed" desc="getAArch64TargetCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1150,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1025,
 FQN="getAArch64TargetCPU", NM="_ZL19getAArch64TargetCPURKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19getAArch64TargetCPURKN4llvm3opt7ArgListE")
//</editor-fold>
public static std.string getAArch64TargetCPU(/*const*/ ArgList /*&*/ Args) {
  Arg /*P*/ A;
  std.string CPU/*J*/= new std.string();
  // If we have -mtune or -mcpu, use that.
  if (((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mtune_EQ.getValue()))) != null)) {
    CPU.$assignMove(new StringRef(A.getValue()).lower());
  } else if (((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()))) != null)) {
    StringRef Mcpu = new StringRef(A.getValue());
    CPU.$assignMove(Mcpu.split(/*STRINGREF_STR*/"+").first.lower());
  }
  
  // Handle CPU name is 'native'.
  if ($eq_string$C_T(CPU, /*KEEP_STR*/"native")) {
    return sys.getHostCPUName().$string();
  } else if ((CPU.size() != 0)) {
    return CPU;
  }
  
  // Make sure we pick "cyclone" if -arch is used.
  // FIXME: Should this be picked by checking the target triple instead?
  if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_arch.getValue())) != null)) {
    return new std.string(/*KEEP_STR*/"cyclone");
  }
  
  return new std.string(/*KEEP_STR*/$generic);
}


// Convert ABI name to the GNU tools acceptable variant.
//<editor-fold defaultstate="collapsed" desc="getGnuCompatibleMipsABIName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1333,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1182,
 FQN="getGnuCompatibleMipsABIName", NM="_ZL27getGnuCompatibleMipsABINameN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL27getGnuCompatibleMipsABINameN4llvm9StringRefE")
//</editor-fold>
public static StringRef getGnuCompatibleMipsABIName(StringRef ABI) {
  return new StringSwitchStringRef(/*NO_COPY*/ABI).
      Case(/*KEEP_STR*/"o32", /*STRINGREF_STR*/"32").
      Case(/*KEEP_STR*/"n64", /*STRINGREF_STR*/"64").
      Default(ABI);
}


// Select the MIPS float ABI as determined by -msoft-float, -mhard-float,
// and -mfloat-abi=.
//<editor-fold defaultstate="collapsed" desc="getMipsFloatABI">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1342,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1191,
 FQN="getMipsFloatABI", NM="_ZL15getMipsFloatABIRKN5clang6driver6DriverERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL15getMipsFloatABIRKN5clang6driver6DriverERKN4llvm3opt7ArgListE")
//</editor-fold>
public static MipsStatics.FloatABI getMipsFloatABI(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args) {
  MipsStatics.FloatABI ABI = MipsStatics.FloatABI.Invalid;
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_msoft_float.getValue()), new OptSpecifier(options.ID.OPT_mhard_float.getValue()), 
        new OptSpecifier(options.ID.OPT_mfloat_abi_EQ.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_msoft_float.getValue()))) {
        ABI = MipsStatics.FloatABI.Soft;
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mhard_float.getValue()))) {
        ABI = MipsStatics.FloatABI.Hard;
      } else {
        ABI = new StringSwitch<MipsStatics.FloatABI>(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"soft", MipsStatics.FloatABI.Soft).
            Case(/*KEEP_STR*/"hard", MipsStatics.FloatABI.Hard).
            Default(MipsStatics.FloatABI.Invalid);
        if (ABI == MipsStatics.FloatABI.Invalid && !new StringRef(A.getValue()).empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_mfloat_abi)), new StringRef(A.getAsString(Args))));
            ABI = MipsStatics.FloatABI.Hard;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // If unspecified, choose the default based on the platform.
  if (ABI == MipsStatics.FloatABI.Invalid) {
    // Assume "hard", because it's a default value used by gcc.
    // When we start to recognize specific target MIPS processors,
    // we will be able to select the default more correctly.
    ABI = MipsStatics.FloatABI.Hard;
  }
  assert (ABI != MipsStatics.FloatABI.Invalid) : "must select an ABI";
  return ABI;
}

//<editor-fold defaultstate="collapsed" desc="AddTargetFeature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1375,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1224,
 FQN="AddTargetFeature", NM="_ZL16AddTargetFeatureRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EENS0_12OptSpecifierESA_NS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16AddTargetFeatureRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EENS0_12OptSpecifierESA_NS_9StringRefE")
//</editor-fold>
public static void AddTargetFeature(/*const*/ ArgList /*&*/ Args, 
                vectorCharPtr/*&*/ Features, 
                OptSpecifier OnOpt, OptSpecifier OffOpt, 
                StringRef FeatureName) {
  {
    Arg /*P*/ A = Args.getLastArg(/*NO_COPY*/OnOpt, /*NO_COPY*/OffOpt);
    if ((A != null)) {
      if (A.getOption().matches(/*NO_COPY*/OnOpt)) {
        Features.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/$PLUS, FeatureName)));
      } else {
        Features.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/$MINUS, FeatureName)));
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getMIPSTargetFeatures">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1387,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1236,
 FQN="getMIPSTargetFeatures", NM="_ZL21getMIPSTargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL21getMIPSTargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE")
//</editor-fold>
public static void getMIPSTargetFeatures(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ _Triple, 
                     /*const*/ ArgList /*&*/ Args, 
                     vectorCharPtr/*&*/ Features) {
  StringRef CPUName/*J*/= new StringRef();
  StringRef ABIName/*J*/= new StringRef();
  MipsStatics.getMipsCPUAndABI(Args, _Triple, CPUName, ABIName);
  ABIName.$assignMove(getGnuCompatibleMipsABIName(/*NO_COPY*/ABIName));
  
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_mno_abicalls.getValue()), 
      new OptSpecifier(options.ID.OPT_mabicalls.getValue()), new StringRef(/*KEEP_STR*/"noabicalls"));
  
  MipsStatics.FloatABI FloatABI = getMipsFloatABI(D, Args);
  if (FloatABI == MipsStatics.FloatABI.Soft) {
    // FIXME: Note, this is a hack. We need to pass the selected float
    // mode to the MipsTargetInfoBase to define appropriate macros there.
    // Now it is the only method.
    Features.push_back($("+soft-float"));
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mnan_EQ.getValue()));
    if ((A != null)) {
      StringRef Val = new StringRef(A.getValue());
      if ($eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"2008")) {
        if (((MipsStatics.getSupportedNanEncoding(CPUName) & MipsStatics.NanEncoding.Nan2008) != 0)) {
          Features.push_back($("+nan2008"));
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Features.push_back($("-nan2008"));
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_target_unsupported_nan2008)), /*NO_COPY*/CPUName));
          } finally {
            $c$.$destroy();
          }
        }
      } else if ($eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"legacy")) {
        if (((MipsStatics.getSupportedNanEncoding(CPUName) & MipsStatics.NanEncoding.NanLegacy) != 0)) {
          Features.push_back($("-nan2008"));
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Features.push_back($("+nan2008"));
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_target_unsupported_nanlegacy)), /*NO_COPY*/CPUName));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_option_argument)), 
                  A.getOption().getName()), /*NO_COPY*/Val));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_msingle_float.getValue()), 
      new OptSpecifier(options.ID.OPT_mdouble_float.getValue()), new StringRef(/*KEEP_STR*/"single-float"));
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_mips16.getValue()), new OptSpecifier(options.ID.OPT_mno_mips16.getValue()), 
      new StringRef(/*KEEP_STR*/"mips16"));
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_mmicromips.getValue()), 
      new OptSpecifier(options.ID.OPT_mno_micromips.getValue()), new StringRef(/*KEEP_STR*/"micromips"));
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_mdsp.getValue()), new OptSpecifier(options.ID.OPT_mno_dsp.getValue()), 
      new StringRef(/*KEEP_STR*/"dsp"));
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_mdspr2.getValue()), new OptSpecifier(options.ID.OPT_mno_dspr2.getValue()), 
      new StringRef(/*KEEP_STR*/"dspr2"));
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_mmsa.getValue()), new OptSpecifier(options.ID.OPT_mno_msa.getValue()), 
      new StringRef(/*KEEP_STR*/"msa"));
  {
    
    // Add the last -mfp32/-mfpxx/-mfp64, if none are given and the ABI is O32
    // pass -mfpxx, or if none are given and fp64a is default, pass fp64 and
    // nooddspreg.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mfp32.getValue()), new OptSpecifier(options.ID.OPT_mfpxx.getValue()), 
        new OptSpecifier(options.ID.OPT_mfp64.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mfp32.getValue()))) {
        Features.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-fp64")));
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mfpxx.getValue()))) {
        Features.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"+fpxx")));
        Features.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"+nooddspreg")));
      } else {
        Features.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"+fp64")));
      }
    } else if (MipsStatics.shouldUseFPXX(Args, _Triple, new StringRef(CPUName), new StringRef(ABIName), FloatABI)) {
      Features.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"+fpxx")));
      Features.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"+nooddspreg")));
    } else if (MipsStatics.isFP64ADefault(_Triple, new StringRef(CPUName))) {
      Features.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"+fp64")));
      Features.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"+nooddspreg")));
    }
  }
  
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_mno_odd_spreg.getValue()), 
      new OptSpecifier(options.ID.OPT_modd_spreg.getValue()), new StringRef(/*KEEP_STR*/"nooddspreg"));
}


/// getPPCTargetCPU - Get the (LLVM) name of the PowerPC cpu we are targeting.
//<editor-fold defaultstate="collapsed" desc="getPPCTargetCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1533,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1365,
 FQN="getPPCTargetCPU", NM="_ZL15getPPCTargetCPURKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL15getPPCTargetCPURKN4llvm3opt7ArgListE")
//</editor-fold>
public static std.string getPPCTargetCPU(/*const*/ ArgList /*&*/ Args) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
    if ((A != null)) {
      StringRef CPUName = new StringRef(A.getValue());
      if ($eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"native")) {
        std.string CPU = sys.getHostCPUName().$string();
        if (!CPU.empty() && $noteq_string$C_T(CPU, /*KEEP_STR*/"generic")) {
          return CPU;
        } else {
          return new std.string(/*KEEP_STR*/$EMPTY);
        }
      }
      
      return new std.string(new StringSwitchCharPtr(/*NO_COPY*/CPUName).
              Case(/*KEEP_STR*/"common", /*KEEP_STR*/$generic).
              Case(/*KEEP_STR*/"440", /*KEEP_STR*/"440").
              Case(/*KEEP_STR*/"440fp", /*KEEP_STR*/"440").
              Case(/*KEEP_STR*/"450", /*KEEP_STR*/"450").
              Case(/*KEEP_STR*/"601", /*KEEP_STR*/"601").
              Case(/*KEEP_STR*/"602", /*KEEP_STR*/"602").
              Case(/*KEEP_STR*/"603", /*KEEP_STR*/"603").
              Case(/*KEEP_STR*/"603e", /*KEEP_STR*/"603e").
              Case(/*KEEP_STR*/"603ev", /*KEEP_STR*/"603ev").
              Case(/*KEEP_STR*/"604", /*KEEP_STR*/"604").
              Case(/*KEEP_STR*/"604e", /*KEEP_STR*/"604e").
              Case(/*KEEP_STR*/"620", /*KEEP_STR*/"620").
              Case(/*KEEP_STR*/"630", /*KEEP_STR*/"pwr3").
              Case(/*KEEP_STR*/"G3", /*KEEP_STR*/"g3").
              Case(/*KEEP_STR*/"7400", /*KEEP_STR*/"7400").
              Case(/*KEEP_STR*/"G4", /*KEEP_STR*/"g4").
              Case(/*KEEP_STR*/"7450", /*KEEP_STR*/"7450").
              Case(/*KEEP_STR*/"G4+", /*KEEP_STR*/"g4+").
              Case(/*KEEP_STR*/"750", /*KEEP_STR*/"750").
              Case(/*KEEP_STR*/"970", /*KEEP_STR*/"970").
              Case(/*KEEP_STR*/"G5", /*KEEP_STR*/"g5").
              Case(/*KEEP_STR*/"a2", /*KEEP_STR*/"a2").
              Case(/*KEEP_STR*/"a2q", /*KEEP_STR*/"a2q").
              Case(/*KEEP_STR*/"e500mc", /*KEEP_STR*/"e500mc").
              Case(/*KEEP_STR*/"e5500", /*KEEP_STR*/"e5500").
              Case(/*KEEP_STR*/"power3", /*KEEP_STR*/"pwr3").
              Case(/*KEEP_STR*/"power4", /*KEEP_STR*/"pwr4").
              Case(/*KEEP_STR*/"power5", /*KEEP_STR*/"pwr5").
              Case(/*KEEP_STR*/"power5x", /*KEEP_STR*/"pwr5x").
              Case(/*KEEP_STR*/"power6", /*KEEP_STR*/"pwr6").
              Case(/*KEEP_STR*/"power6x", /*KEEP_STR*/"pwr6x").
              Case(/*KEEP_STR*/"power7", /*KEEP_STR*/"pwr7").
              Case(/*KEEP_STR*/"power8", /*KEEP_STR*/"pwr8").
              Case(/*KEEP_STR*/"power9", /*KEEP_STR*/"pwr9").
              Case(/*KEEP_STR*/"pwr3", /*KEEP_STR*/"pwr3").
              Case(/*KEEP_STR*/"pwr4", /*KEEP_STR*/"pwr4").
              Case(/*KEEP_STR*/"pwr5", /*KEEP_STR*/"pwr5").
              Case(/*KEEP_STR*/"pwr5x", /*KEEP_STR*/"pwr5x").
              Case(/*KEEP_STR*/"pwr6", /*KEEP_STR*/"pwr6").
              Case(/*KEEP_STR*/"pwr6x", /*KEEP_STR*/"pwr6x").
              Case(/*KEEP_STR*/"pwr7", /*KEEP_STR*/"pwr7").
              Case(/*KEEP_STR*/"pwr8", /*KEEP_STR*/"pwr8").
              Case(/*KEEP_STR*/"pwr9", /*KEEP_STR*/"pwr9").
              Case(/*KEEP_STR*/"powerpc", /*KEEP_STR*/"ppc").
              Case(/*KEEP_STR*/"powerpc64", /*KEEP_STR*/"ppc64").
              Case(/*KEEP_STR*/"powerpc64le", /*KEEP_STR*/"ppc64le").
              Default(/*KEEP_STR*/$EMPTY));
    }
  }
  
  return new std.string(/*KEEP_STR*/$EMPTY);
}

//<editor-fold defaultstate="collapsed" desc="getPPCTargetFeatures">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1598,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1428,
 FQN="getPPCTargetFeatures", NM="_ZL20getPPCTargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL20getPPCTargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE")
//</editor-fold>
public static void getPPCTargetFeatures(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ _Triple, 
                    /*const*/ ArgList /*&*/ Args, 
                    vectorCharPtr/*&*/ Features) {
  handleTargetFeaturesGroup(Args, Features, new OptSpecifier(options.ID.OPT_m_ppc_Features_Group.getValue()));
  
  PpcStatics.FloatABI FloatABI = PpcStatics.getPPCFloatABI(D, Args);
  if (FloatABI == PpcStatics.FloatABI.Soft
     && !(_Triple.getArch() == Triple.ArchType.ppc64
     || _Triple.getArch() == Triple.ArchType.ppc64le)) {
    Features.push_back($("+soft-float"));
  } else if (FloatABI == PpcStatics.FloatABI.Soft
     && (_Triple.getArch() == Triple.ArchType.ppc64
     || _Triple.getArch() == Triple.ArchType.ppc64le)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_invalid_mfloat_abi)), 
          /*KEEP_STR*/"soft float is not supported for ppc64"));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Altivec is a bit weird, allow overriding of the Altivec feature here.
  AddTargetFeature(Args, Features, new OptSpecifier(options.ID.OPT_faltivec.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_altivec.getValue()), new StringRef(/*KEEP_STR*/"altivec"));
}


/// Get the (LLVM) name of the R600 gpu we are targeting.
//<editor-fold defaultstate="collapsed" desc="getR600TargetGPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1711,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1541,
 FQN="getR600TargetGPU", NM="_ZL16getR600TargetGPURKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16getR600TargetGPURKN4llvm3opt7ArgListE")
//</editor-fold>
public static std.string getR600TargetGPU(/*const*/ ArgList /*&*/ Args) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
    if ((A != null)) {
      /*const*/char$ptr/*char P*/ GPUName = $tryClone(A.getValue());
      return new std.string(new StringSwitchCharPtr(/*STRINGREF_STR*/GPUName).
              Cases(/*KEEP_STR*/"rv630", /*KEEP_STR*/"rv635", /*KEEP_STR*/"r600").
              Cases(/*KEEP_STR*/"rv610", /*KEEP_STR*/"rv620", /*KEEP_STR*/"rs780", /*KEEP_STR*/"rs880").
              Case(/*KEEP_STR*/"rv740", /*KEEP_STR*/"rv770").
              Case(/*KEEP_STR*/"palm", /*KEEP_STR*/"cedar").
              Cases(/*KEEP_STR*/"sumo", /*KEEP_STR*/"sumo2", /*KEEP_STR*/"sumo").
              Case(/*KEEP_STR*/"hemlock", /*KEEP_STR*/"cypress").
              Case(/*KEEP_STR*/"aruba", /*KEEP_STR*/"cayman").
              Default(GPUName));
    }
  }
  return new std.string(/*KEEP_STR*/$EMPTY);
}

//<editor-fold defaultstate="collapsed" desc="getLanaiTargetCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1727,
 FQN="getLanaiTargetCPU", NM="_ZL17getLanaiTargetCPURKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL17getLanaiTargetCPURKN4llvm3opt7ArgListE")
//</editor-fold>
public static std.string getLanaiTargetCPU(/*const*/ ArgList /*&*/ Args) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
    if ((A != null)) {
      return new std.string(A.getValue());
    }
  }
  return new std.string(/*KEEP_STR*/$EMPTY);
}

//<editor-fold defaultstate="collapsed" desc="getSparcTargetFeatures">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1769,
 FQN="getSparcTargetFeatures", NM="_ZL22getSparcTargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL22getSparcTargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE")
//</editor-fold>
public static void getSparcTargetFeatures(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args, 
                      vectorCharPtr/*&*/ Features) {
  SparcStatics.FloatABI FloatABI = SparcStatics.getSparcFloatABI(D, Args);
  if (FloatABI == SparcStatics.FloatABI.Soft) {
    Features.push_back($("+soft-float"));
  }
}

//<editor-fold defaultstate="collapsed" desc="getSystemZTargetCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1800,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1580,
 FQN="getSystemZTargetCPU", NM="_ZL19getSystemZTargetCPURKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19getSystemZTargetCPURKN4llvm3opt7ArgListE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getSystemZTargetCPU(/*const*/ ArgList /*&*/ Args) {
  {
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
    if ((A != null)) {
      return A.getValue();
    }
  }
  return $("z10");
}

//<editor-fold defaultstate="collapsed" desc="getSystemZTargetFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1806,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1586,
 FQN="getSystemZTargetFeatures", NM="_ZL24getSystemZTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL24getSystemZTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE")
//</editor-fold>
public static void getSystemZTargetFeatures(/*const*/ ArgList /*&*/ Args, 
                        vectorCharPtr/*&*/ Features) {
  {
    // -m(no-)htm overrides use of the transactional-execution facility.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mhtm.getValue()), new OptSpecifier(options.ID.OPT_mno_htm.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mhtm.getValue()))) {
        Features.push_back($("+transactional-execution"));
      } else {
        Features.push_back($("-transactional-execution"));
      }
    }
  }
  {
    // -m(no-)vx overrides use of the vector facility.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mvx.getValue()), new OptSpecifier(options.ID.OPT_mno_vx.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mvx.getValue()))) {
        Features.push_back($("+vector"));
      } else {
        Features.push_back($("-vector"));
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getX86TargetCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1824,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1604,
 FQN="getX86TargetCPU", NM="_ZL15getX86TargetCPURKN4llvm3opt7ArgListERKNS_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL15getX86TargetCPURKN4llvm3opt7ArgListERKNS_6TripleE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getX86TargetCPU(/*const*/ ArgList /*&*/ Args, 
               /*const*/ Triple /*&*/ _Triple) {
  {
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
    if ((A != null)) {
      if ($noteq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/"native")) {
        if (_Triple.isOSDarwin() && $eq_StringRef(_Triple.getArchName(), /*STRINGREF_STR*/"x86_64h")) {
          return $("core-avx2");
        }
        
        return A.getValue();
      }
      
      // FIXME: Reject attempts to use -march=native unless the target matches
      // the host.
      //
      // FIXME: We should also incorporate the detected target features for use
      // with -native.
      std.string CPU = sys.getHostCPUName().$string();
      if (!CPU.empty() && $noteq_string$C_T(CPU, /*KEEP_STR*/"generic")) {
        return Args.MakeArgString(new Twine(CPU));
      }
    }
  }
  {
    
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_arch.getValue()));
    if ((A != null)) {
      // Mapping built by referring to X86TargetInfo::getDefaultFeatures().
      StringRef Arch = new StringRef(A.getValue());
      /*const*/char$ptr/*char P*/ CPU;
      if (_Triple.getArch() == Triple.ArchType.x86) {
        CPU = $tryClone(new StringSwitchCharPtr(/*NO_COPY*/Arch).
            Case(/*KEEP_STR*/"IA32", /*KEEP_STR*/"i386").
            Case(/*KEEP_STR*/"SSE", /*KEEP_STR*/"pentium3").
            Case(/*KEEP_STR*/"SSE2", /*KEEP_STR*/"pentium4").
            Case(/*KEEP_STR*/"AVX", /*KEEP_STR*/"sandybridge").
            Case(/*KEEP_STR*/"AVX2", /*KEEP_STR*/"haswell").
            Default(/*NULL*/(/*const*/char$ptr/*char P*//*const*/)null));
      } else {
        CPU = $tryClone(new StringSwitchCharPtr(/*NO_COPY*/Arch).
            Case(/*KEEP_STR*/"AVX", /*KEEP_STR*/"sandybridge").
            Case(/*KEEP_STR*/"AVX2", /*KEEP_STR*/"haswell").
            Default(/*NULL*/(/*const*/char$ptr/*char P*//*const*/)null));
      }
      if ((CPU != null)) {
        return CPU;
      }
    }
  }
  
  // Select the default CPU if none was given (or detection failed).
  if (_Triple.getArch() != Triple.ArchType.x86_64
     && _Triple.getArch() != Triple.ArchType.x86) {
    return null; // This routine is only handling x86 targets.
  }
  
  boolean Is64Bit = _Triple.getArch() == Triple.ArchType.x86_64;
  
  // FIXME: Need target hooks.
  if (_Triple.isOSDarwin()) {
    if ($eq_StringRef(_Triple.getArchName(), /*STRINGREF_STR*/"x86_64h")) {
      return $("core-avx2");
    }
    return Is64Bit ? $("core2") : $("yonah");
  }
  
  // Set up default CPU name for PS4 compilers.
  if (_Triple.isPS4CPU()) {
    return $("btver2");
  }
  
  // On Android use targets compatible with gcc
  if (_Triple.isAndroid()) {
    return Is64Bit ? $("x86-64") : $("i686");
  }
  
  // Everything else goes to x86-64 in 64-bit mode.
  if (Is64Bit) {
    return $("x86-64");
  }
  switch (_Triple.getOS()) {
   case FreeBSD:
   case NetBSD:
   case OpenBSD:
    return $("i486");
   case Haiku:
    return $("i586");
   case Bitrig:
    return $("i686");
   default:
    // Fallback to p4.
    return $("pentium4");
  }
}


/// Get the (LLVM) name of the WebAssembly cpu we are targeting.
//<editor-fold defaultstate="collapsed" desc="getWebAssemblyTargetCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1909,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1689,
 FQN="getWebAssemblyTargetCPU", NM="_ZL23getWebAssemblyTargetCPURKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL23getWebAssemblyTargetCPURKN4llvm3opt7ArgListE")
//</editor-fold>
public static StringRef getWebAssemblyTargetCPU(/*const*/ ArgList /*&*/ Args) {
  {
    // If we have -mcpu=, use that.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
    if ((A != null)) {
      StringRef CPU = new StringRef(A.getValue());
      
      return CPU;
    }
  }
  
  return new StringRef(/*KEEP_STR*/$generic);
}

//<editor-fold defaultstate="collapsed" desc="getCPUName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1927,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1707,
 FQN="getCPUName", NM="_ZL10getCPUNameRKN4llvm3opt7ArgListERKNS_6TripleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL10getCPUNameRKN4llvm3opt7ArgListERKNS_6TripleEb")
//</editor-fold>
public static std.string getCPUName(/*const*/ ArgList /*&*/ Args, /*const*/ Triple /*&*/ T) {
  return getCPUName(Args, T, 
          false);
}
public static std.string getCPUName(/*const*/ ArgList /*&*/ Args, /*const*/ Triple /*&*/ T, 
          boolean FromAs/*= false*/) {
  switch (T.getArch()) {
   default:
    return new std.string(/*KEEP_STR*/$EMPTY);
   case aarch64:
   case aarch64_be:
    return getAArch64TargetCPU(Args);
   case arm:
   case armeb:
   case thumb:
   case thumbeb:
    {
      StringRef MArch/*J*/= new StringRef(), MCPU/*J*/= new StringRef();
      getARMArchCPUFromArgs(Args, MArch, MCPU, FromAs);
      return ArmStatics.getARMTargetCPU(new StringRef(MCPU), new StringRef(MArch), T);
    }
   case mips:
   case mipsel:
   case mips64:
   case mips64el:
    {
      StringRef CPUName/*J*/= new StringRef();
      StringRef ABIName/*J*/= new StringRef();
      MipsStatics.getMipsCPUAndABI(Args, T, CPUName, ABIName);
      return CPUName.$string();
    }
   case nvptx:
   case nvptx64:
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
      if ((A != null)) {
        return new std.string(A.getValue());
      }
    }
    return new std.string(/*KEEP_STR*/$EMPTY);
   case ppc:
   case ppc64:
   case ppc64le:
    {
      std.string TargetCPUName = getPPCTargetCPU(Args);
      // LLVM may default to generating code for the native CPU,
      // but, like gcc, we default to a more generic option for
      // each architecture. (except on Darwin)
      if (TargetCPUName.empty() && !T.isOSDarwin()) {
        if (T.getArch() == Triple.ArchType.ppc64) {
          TargetCPUName.$assign(/*KEEP_STR*/"ppc64");
        } else if (T.getArch() == Triple.ArchType.ppc64le) {
          TargetCPUName.$assign(/*KEEP_STR*/"ppc64le");
        } else {
          TargetCPUName.$assign(/*KEEP_STR*/"ppc");
        }
      }
      return TargetCPUName;
    }
   case sparc:
   case sparcel:
   case sparcv9:
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
      if ((A != null)) {
        return new std.string(A.getValue());
      }
    }
    return new std.string(/*KEEP_STR*/$EMPTY);
   case x86:
   case x86_64:
    return new std.string(getX86TargetCPU(Args, T));
   case hexagon:
    return $add_T_string(/*KEEP_STR*/"hexagon", 
        HexagonToolChain.GetTargetCPUVersion(Args).str());
   case lanai:
    return getLanaiTargetCPU(Args);
   case systemz:
    return new std.string(getSystemZTargetCPU(Args));
   case r600:
   case amdgcn:
    return getR600TargetGPU(Args);
   case wasm32:
   case wasm64:
    return getWebAssemblyTargetCPU(Args).$string();
  }
}

//<editor-fold defaultstate="collapsed" desc="AddGoldPlugin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2010,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1787,
 FQN="AddGoldPlugin", NM="_ZL13AddGoldPluginRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL13AddGoldPluginRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEEb")
//</editor-fold>
public static void AddGoldPlugin(/*const*/ ToolChain /*&*/ ToolChain, /*const*/ ArgList /*&*/ Args, 
             ArgStringList/*&*/ CmdArgs, boolean IsThinLTO) {
  // Tell the linker to load the plugin. This has to come before AddLinkerInputs
  // as gold requires -plugin to come before any -plugin-opt that -Wl might
  // forward.
  CmdArgs.push_back($("-plugin"));
  std.string Plugin = $add_string$C_T(ToolChain.getDriver().Dir, /*KEEP_STR*/"/../lib/LLVMgold.so");
  CmdArgs.push_back(Args.MakeArgString(new Twine(Plugin)));
  
  // Try to pass driver level flags relevant to LTO code generation down to
  // the plugin.
  
  // Handle flags for selecting CPU variants.
  std.string CPU = getCPUName(Args, ToolChain.getTriple());
  if (!CPU.empty()) {
    CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-plugin-opt=mcpu="), new Twine(CPU))));
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O_Group.getValue()));
    if ((A != null)) {
      StringRef OOpt/*J*/= new StringRef();
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O4.getValue()))
         || A.getOption().matches(new OptSpecifier(options.ID.OPT_Ofast.getValue()))) {
        OOpt.$assignMove(/*STRINGREF_STR*/$3);
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O.getValue()))) {
        OOpt.$assignMove(/*STRINGREF_STR*/A.getValue());
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O0.getValue()))) {
        OOpt.$assignMove(/*STRINGREF_STR*/$0);
      }
      if (!OOpt.empty()) {
        CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-plugin-opt=O"), new Twine(OOpt))));
      }
    }
  }
  if (IsThinLTO) {
    CmdArgs.push_back($("-plugin-opt=thinlto"));
  }
  {
    
    // If an explicit debugger tuning argument appeared, pass it along.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_gTune_Group.getValue()), 
        new OptSpecifier(options.ID.OPT_ggdbN_Group.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_glldb.getValue()))) {
        CmdArgs.push_back($("-plugin-opt=-debugger-tune=lldb"));
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_gsce.getValue()))) {
        CmdArgs.push_back($("-plugin-opt=-debugger-tune=sce"));
      } else {
        CmdArgs.push_back($("-plugin-opt=-debugger-tune=gdb"));
      }
    }
  }
}


/// This is a helper function for validating the optional refinement step
/// parameter in reciprocal argument strings. Return false if there is an error
/// parsing the refinement step. Otherwise, return true and set the Position
/// of the refinement step in the input string.
//<editor-fold defaultstate="collapsed" desc="getRefinementStep">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2060,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1826,
 FQN="getRefinementStep", NM="_ZL17getRefinementStepN4llvm9StringRefERKN5clang6driver6DriverERKNS_3opt3ArgERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL17getRefinementStepN4llvm9StringRefERKN5clang6driver6DriverERKNS_3opt3ArgERj")
//</editor-fold>
public static boolean getRefinementStep(StringRef In, /*const*/ Driver /*&*/ D, 
                 /*const*/ Arg /*&*/ A, uint$ref/*size_t &*/ Position) {
  /*const*//*char*/byte RefinementStepToken = $$COLON;
  Position.$set(In.find(RefinementStepToken));
  if (Position.$deref() != StringRef.npos) {
    StringRef Option = A.getOption().getName();
    StringRef RefStep = In.substr(Position.$deref() + 1);
    // Allow exactly one numeric character for the additional refinement
    // step parameter. This is reasonable for all currently-supported
    // operations and architectures because we would expect that a larger value
    // of refinement steps would cause the estimate "optimization" to
    // under-perform the native operation. Also, if the estimate does not
    // converge quickly, it probably will not ever converge, so further
    // refinement steps will not produce a better answer.
    if (RefStep.size() != 1) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), /*NO_COPY*/Option), /*NO_COPY*/RefStep));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    /*char*/byte RefStepChar = RefStep.$at(0);
    if (RefStepChar < $$0 || RefStepChar > $$9) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), /*NO_COPY*/Option), /*NO_COPY*/RefStep));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
  }
  return true;
}


/// The -mrecip flag requires processing of many optional parameters.
//<editor-fold defaultstate="collapsed" desc="ParseMRecip">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2088,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1854,
 FQN="ParseMRecip", NM="_ZL11ParseMRecipRKN5clang6driver6DriverERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL11ParseMRecipRKN5clang6driver6DriverERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void ParseMRecip(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args, 
           ArgStringList/*&*/ OutStrings) {
  StringMapBool OptionStrings = null;
  try {
    StringRef DisabledPrefixIn = new StringRef(/*KEEP_STR*/$EXCLAIM);
    StringRef DisabledPrefixOut = new StringRef(/*KEEP_STR*/$EXCLAIM);
    StringRef EnabledPrefixOut = new StringRef(/*KEEP_STR*/$EMPTY);
    StringRef Out = new StringRef(/*KEEP_STR*/"-mrecip=");
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mrecip.getValue()), new OptSpecifier(options.ID.OPT_mrecip_EQ.getValue()));
    if (!(A != null)) {
      return;
    }
    
    /*uint*/int NumOptions = A.getNumValues();
    if (NumOptions == 0) {
      // No option is the same as "all".
      OutStrings.push_back(Args.MakeArgString($add_StringRef_char$ptr$C(Out, /*KEEP_STR*/"all")));
      return;
    }
    
    // Pass through "all", "none", or "default" with an optional refinement step.
    if (NumOptions == 1) {
      StringRef Val = new StringRef(A.getValue(0));
      /*size_t*/uint$ref RefStepLoc = create_uint$ref();
      if (!getRefinementStep(new StringRef(Val), D, /*Deref*/A, RefStepLoc)) {
        return;
      }
      StringRef ValBase = Val.slice(0, RefStepLoc.$deref());
      if ($eq_StringRef(/*NO_COPY*/ValBase, /*STRINGREF_STR*/"all") || $eq_StringRef(/*NO_COPY*/ValBase, /*STRINGREF_STR*/"none") || $eq_StringRef(/*NO_COPY*/ValBase, /*STRINGREF_STR*/"default")) {
        OutStrings.push_back(Args.MakeArgString($add_Twine(new Twine(Out), new Twine(Val))));
        return;
      }
    }
    
    // Each reciprocal type may be enabled or disabled individually.
    // Check each input value for validity, concatenate them all back together,
    // and pass through.
    OptionStrings/*J*/= new StringMapBool(false);
    OptionStrings.$set("divd", false);
    OptionStrings.$set("divf", false);
    OptionStrings.$set("vec-divd", false);
    OptionStrings.$set("vec-divf", false);
    OptionStrings.$set("sqrtd", false);
    OptionStrings.$set("sqrtf", false);
    OptionStrings.$set("vec-sqrtd", false);
    OptionStrings.$set("vec-sqrtf", false);
    
    for (/*uint*/int i = 0; i != NumOptions; ++i) {
      StringRef Val = new StringRef(A.getValue(i));
      
      boolean IsDisabled = Val.startswith(/*NO_COPY*/DisabledPrefixIn);
      // Ignore the disablement token for string matching.
      if (IsDisabled) {
        Val.$assignMove(Val.substr(1));
      }
      
      /*size_t*/uint$ref RefStep = create_uint$ref();
      if (!getRefinementStep(new StringRef(Val), D, /*Deref*/A, RefStep)) {
        return;
      }
      
      StringRef ValBase = Val.slice(0, RefStep.$deref());
      StringMapIteratorBool OptionIter = OptionStrings.find(/*NO_COPY*/ValBase);
      if (OptionIter.$eq(OptionStrings.end())) {
        // Try again specifying float suffix.
        OptionIter.$assignMove(OptionStrings.find(new StringRef($add_string_T(ValBase.str(), $$f))));
        if (OptionIter.$eq(OptionStrings.end())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // The input name did not match any known option string.
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unknown_argument)), /*NO_COPY*/Val));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        // The option was specified without a float or double suffix.
        // Make sure that the double entry was not already specified.
        // The float entry will be checked below.
        if (OptionStrings.$at(new StringRef($add_string_T(ValBase.str(), $$d)))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), A.getOption().getName()), /*NO_COPY*/Val));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (OptionIter.$arrow().second == true) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Duplicate option specified.
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), A.getOption().getName()), /*NO_COPY*/Val));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Mark the matched option as found. Do not allow duplicate specifiers.
      OptionIter.$arrow().second = true;
      
      // If the precision was not specified, also mark the double entry as found.
      if (ValBase.back() != $$f && ValBase.back() != $$d) {
        OptionStrings.$set(new StringRef($add_string_T(ValBase.str(), $$d)), true);
      }
      
      // Build the output string.
      StringRef Prefix = new StringRef(IsDisabled ? DisabledPrefixOut : EnabledPrefixOut);
      Out.$assignMove(/*STRINGREF_STR*/Args.MakeArgString($add_Twine($add_Twine(new Twine(Out), new Twine(Prefix)), new Twine(Val))));
      if (i != NumOptions - 1) {
        Out.$assignMove(/*STRINGREF_STR*/Args.MakeArgString($add_StringRef_char$ptr$C(Out, /*KEEP_STR*/$COMMA)));
      }
    }
    
    OutStrings.push_back(Args.MakeArgString(new Twine(Out)));
  } finally {
    if (OptionStrings != null) { OptionStrings.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getX86TargetFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2187,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1953,
 FQN="getX86TargetFeatures", NM="_ZL20getX86TargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL20getX86TargetFeaturesRKN5clang6driver6DriverERKN4llvm6TripleERKNS4_3opt7ArgListERSt6vectorIPKcSaISE_EE")
//</editor-fold>
public static void getX86TargetFeatures(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ _Triple, 
                    /*const*/ ArgList /*&*/ Args, 
                    vectorCharPtr/*&*/ Features) {
  {
    // If -march=native, autodetect the feature list.
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
    if ((A != null)) {
      if ($eq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/"native")) {
        StringMapBool HostFeatures = null;
        try {
          HostFeatures/*J*/= new StringMapBool(false);
          if (sys.getHostCPUFeatures(HostFeatures)) {
            for (StringMapEntryBool/*&*/ F : HostFeatures)  {
              Features.push_back(Args.MakeArgString($add_char$ptr$C_StringRef((F.second ? $PLUS : $MINUS), F.first())));
            }
          }
        } finally {
          if (HostFeatures != null) { HostFeatures.$destroy(); }
        }
      }
    }
  }
  if ($eq_StringRef(_Triple.getArchName(), /*STRINGREF_STR*/"x86_64h")) {
    // x86_64h implies quite a few of the more modern subtarget features
    // for Haswell class CPUs, but not all of them. Opt-out of a few.
    Features.push_back($("-rdrnd"));
    Features.push_back($("-aes"));
    Features.push_back($("-pclmul"));
    Features.push_back($("-rtm"));
    Features.push_back($("-hle"));
    Features.push_back($("-fsgsbase"));
  }
  
  /*const*/ Triple.ArchType _ArchType = _Triple.getArch();
  // Add features to be compatible with gcc for Android.
  if (_Triple.isAndroid()) {
    if (_ArchType == Triple.ArchType.x86_64) {
      Features.push_back($("+sse4.2"));
      Features.push_back($("+popcnt"));
    } else {
      Features.push_back($("+ssse3"));
    }
  }
  {
    
    // Set features according to the -arch flag on MSVC.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_arch.getValue()));
    if ((A != null)) {
      StringRef Arch = new StringRef(A.getValue());
      boolean ArchUsed = false;
      // First, look for flags that are shared in x86 and x86-64.
      if (_ArchType == Triple.ArchType.x86_64 || _ArchType == Triple.ArchType.x86) {
        if ($eq_StringRef(/*NO_COPY*/Arch, /*STRINGREF_STR*/"AVX") || $eq_StringRef(/*NO_COPY*/Arch, /*STRINGREF_STR*/"AVX2")) {
          ArchUsed = true;
          Features.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"+", Arch.lower()))));
        }
      }
      // Then, look for x86-specific flags.
      if (_ArchType == Triple.ArchType.x86) {
        if ($eq_StringRef(/*NO_COPY*/Arch, /*STRINGREF_STR*/"IA32")) {
          ArchUsed = true;
        } else if ($eq_StringRef(/*NO_COPY*/Arch, /*STRINGREF_STR*/"SSE") || $eq_StringRef(/*NO_COPY*/Arch, /*STRINGREF_STR*/"SSE2")) {
          ArchUsed = true;
          Features.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"+", Arch.lower()))));
        }
      }
      if (!ArchUsed) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_unused_argument)), new StringRef(A.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Now add any that the user explicitly requested on the command line,
  // which may override the defaults.
  handleTargetFeaturesGroup(Args, Features, new OptSpecifier(options.ID.OPT_m_x86_Features_Group.getValue()));
}


// Decode AArch64 features from string like +[no]featureA+[no]featureB+...
//<editor-fold defaultstate="collapsed" desc="DecodeAArch64Features">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2347,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2083,
 FQN="DecodeAArch64Features", NM="_ZL21DecodeAArch64FeaturesRKN5clang6driver6DriverEN4llvm9StringRefERSt6vectorIPKcSaIS8_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL21DecodeAArch64FeaturesRKN5clang6driver6DriverEN4llvm9StringRefERSt6vectorIPKcSaIS8_EE")
//</editor-fold>
public static boolean DecodeAArch64Features(/*const*/ Driver /*&*/ D, StringRef text, 
                     vectorCharPtr/*&*/ Features) {
  SmallVector<StringRef> Split/*J*/= new SmallVector<StringRef>(8, new StringRef());
  text.split(Split, /*STRINGREF_STR*/"+", -1, /*KEEP_BOOL*/false);
  
  for (StringRef Feature : Split) {
    /*const*/char$ptr/*char P*/ result = $tryClone(new StringSwitchCharPtr(/*NO_COPY*/Feature).
        Case(/*KEEP_STR*/"fp", /*KEEP_STR*/"+fp-armv8").
        Case(/*KEEP_STR*/"simd", /*KEEP_STR*/"+neon").
        Case(/*KEEP_STR*/"crc", /*KEEP_STR*/"+crc").
        Case(/*KEEP_STR*/"crypto", /*KEEP_STR*/"+crypto").
        Case(/*KEEP_STR*/"fp16", /*KEEP_STR*/"+fullfp16").
        Case(/*KEEP_STR*/"profile", /*KEEP_STR*/"+spe").
        Case(/*KEEP_STR*/"ras", /*KEEP_STR*/"+ras").
        Case(/*KEEP_STR*/"nofp", /*KEEP_STR*/"-fp-armv8").
        Case(/*KEEP_STR*/"nosimd", /*KEEP_STR*/"-neon").
        Case(/*KEEP_STR*/"nocrc", /*KEEP_STR*/"-crc").
        Case(/*KEEP_STR*/"nocrypto", /*KEEP_STR*/"-crypto").
        Case(/*KEEP_STR*/"nofp16", /*KEEP_STR*/"-fullfp16").
        Case(/*KEEP_STR*/"noprofile", /*KEEP_STR*/"-spe").
        Case(/*KEEP_STR*/"noras", /*KEEP_STR*/"-ras").
        Default(/*NULL*/(/*const*/char$ptr/*char P*//*const*/)null));
    if ((result != null)) {
      Features.push_back(result);
    } else if ($eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"neon") || $eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"noneon")) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(D.Diag(diag.err_drv_no_neon_modifier)));
      } finally {
        $c$.$destroy();
      }
    } else {
      return false;
    }
  }
  return true;
}


// Check if the CPU name and feature modifiers in -mcpu are legal. If yes,
// decode CPU and feature.
//<editor-fold defaultstate="collapsed" desc="DecodeAArch64Mcpu">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2381,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2115,
 FQN="DecodeAArch64Mcpu", NM="_ZL17DecodeAArch64McpuRKN5clang6driver6DriverEN4llvm9StringRefERS5_RSt6vectorIPKcSaIS9_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL17DecodeAArch64McpuRKN5clang6driver6DriverEN4llvm9StringRefERS5_RSt6vectorIPKcSaIS9_EE")
//</editor-fold>
public static boolean DecodeAArch64Mcpu(/*const*/ Driver /*&*/ D, StringRef Mcpu, StringRef /*&*/ CPU, 
                 vectorCharPtr/*&*/ Features) {
  std.pair<StringRef, StringRef> Split = Mcpu.split(/*STRINGREF_STR*/"+");
  CPU.$assign(Split.first);
  if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"cortex-a53") || $eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"cortex-a57")
     || $eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"cortex-a72") || $eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"cortex-a35") || $eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"exynos-m1")
     || $eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"kryo") || $eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"cortex-a73") || $eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"vulcan")) {
    Features.push_back($("+neon"));
    Features.push_back($("+crc"));
    Features.push_back($("+crypto"));
  } else if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"cyclone")) {
    Features.push_back($("+neon"));
    Features.push_back($("+crypto"));
  } else if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"generic")) {
    Features.push_back($("+neon"));
  } else {
    return false;
  }
  if ((Split.second.size() != 0) && !DecodeAArch64Features(D, new StringRef(Split.second), Features)) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="getAArch64ArchFeaturesFromMarch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2406,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2136,
 FQN="getAArch64ArchFeaturesFromMarch", NM="_ZL31getAArch64ArchFeaturesFromMarchRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL31getAArch64ArchFeaturesFromMarchRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE")
//</editor-fold>
public static boolean getAArch64ArchFeaturesFromMarch(/*const*/ Driver /*&*/ D, StringRef March, 
                               /*const*/ ArgList /*&*/ Args, 
                               vectorCharPtr/*&*/ Features) {
  std.string MarchLowerCase = March.lower();
  std.pair<StringRef, StringRef> Split = new StringRef(MarchLowerCase).split(/*STRINGREF_STR*/"+");
  if ($eq_StringRef(/*NO_COPY*/Split.first, /*STRINGREF_STR*/"armv8-a") || $eq_StringRef(/*NO_COPY*/Split.first, /*STRINGREF_STR*/"armv8a")) {
    // ok, no additional features.
  } else if ($eq_StringRef(/*NO_COPY*/Split.first, /*STRINGREF_STR*/"armv8.1-a") || $eq_StringRef(/*NO_COPY*/Split.first, /*STRINGREF_STR*/"armv8.1a")) {
    Features.push_back($("+v8.1a"));
  } else if ($eq_StringRef(/*NO_COPY*/Split.first, /*STRINGREF_STR*/"armv8.2-a") || $eq_StringRef(/*NO_COPY*/Split.first, /*STRINGREF_STR*/"armv8.2a")) {
    Features.push_back($("+v8.2a"));
  } else {
    return false;
  }
  if ((Split.second.size() != 0) && !DecodeAArch64Features(D, new StringRef(Split.second), Features)) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="getAArch64ArchFeaturesFromMcpu">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2429,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2159,
 FQN="getAArch64ArchFeaturesFromMcpu", NM="_ZL30getAArch64ArchFeaturesFromMcpuRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL30getAArch64ArchFeaturesFromMcpuRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE")
//</editor-fold>
public static boolean getAArch64ArchFeaturesFromMcpu(/*const*/ Driver /*&*/ D, StringRef Mcpu, 
                              /*const*/ ArgList /*&*/ Args, 
                              vectorCharPtr/*&*/ Features) {
  StringRef CPU/*J*/= new StringRef();
  std.string McpuLowerCase = Mcpu.lower();
  if (!DecodeAArch64Mcpu(D, new StringRef(McpuLowerCase), CPU, Features)) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="getAArch64MicroArchFeaturesFromMtune">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2441,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2171,
 FQN="getAArch64MicroArchFeaturesFromMtune", NM="_ZL36getAArch64MicroArchFeaturesFromMtuneRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL36getAArch64MicroArchFeaturesFromMtuneRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE")
//</editor-fold>
public static boolean getAArch64MicroArchFeaturesFromMtune(/*const*/ Driver /*&*/ D, StringRef Mtune, 
                                    /*const*/ ArgList /*&*/ Args, 
                                    vectorCharPtr/*&*/ Features) {
  std.string MtuneLowerCase = Mtune.lower();
  // Handle CPU name is 'native'.
  if ($eq_string$C_T(MtuneLowerCase, /*KEEP_STR*/"native")) {
    MtuneLowerCase.$assignMove(sys.getHostCPUName().$string());
  }
  if ($eq_string$C_T(MtuneLowerCase, /*KEEP_STR*/"cyclone")) {
    Features.push_back($("+zcm"));
    Features.push_back($("+zcz"));
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="getAArch64MicroArchFeaturesFromMcpu">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2456,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2186,
 FQN="getAArch64MicroArchFeaturesFromMcpu", NM="_ZL35getAArch64MicroArchFeaturesFromMcpuRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL35getAArch64MicroArchFeaturesFromMcpuRKN5clang6driver6DriverEN4llvm9StringRefERKNS4_3opt7ArgListERSt6vectorIPKcSaISC_EE")
//</editor-fold>
public static boolean getAArch64MicroArchFeaturesFromMcpu(/*const*/ Driver /*&*/ D, StringRef Mcpu, 
                                   /*const*/ ArgList /*&*/ Args, 
                                   vectorCharPtr/*&*/ Features) {
  vectorCharPtr DecodedFeature = null;
  try {
    StringRef CPU/*J*/= new StringRef();
    DecodedFeature/*J*/= new vectorCharPtr();
    std.string McpuLowerCase = Mcpu.lower();
    if (!DecodeAArch64Mcpu(D, new StringRef(McpuLowerCase), CPU, DecodedFeature)) {
      return false;
    }
    
    return getAArch64MicroArchFeaturesFromMtune(D, new StringRef(CPU), Args, Features);
  } finally {
    if (DecodedFeature != null) { DecodedFeature.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getAArch64TargetFeatures">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*added extra compound*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2469,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2199,
 FQN="getAArch64TargetFeatures", NM="_ZL24getAArch64TargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL24getAArch64TargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE")
//</editor-fold>
public static void getAArch64TargetFeatures(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args, 
                        vectorCharPtr/*&*/ Features) {
  { // JAVA: added compound to resolve reuse of 'A' identifier
  Arg /*P*/ A;
  boolean success = true;
  // Enable NEON by default.
  Features.push_back($("+neon"));
  if (((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()))) != null)) {
    success = getAArch64ArchFeaturesFromMarch(D, new StringRef(A.getValue()), Args, Features);
  } else if (((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()))) != null)) {
    success = getAArch64ArchFeaturesFromMcpu(D, new StringRef(A.getValue()), Args, Features);
  } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_arch.getValue()))) {
    success = getAArch64ArchFeaturesFromMcpu(D, new StringRef(getAArch64TargetCPU(Args)), Args, 
        Features);
  }
  if (success && ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mtune_EQ.getValue()))) != null)) {
    success
       = getAArch64MicroArchFeaturesFromMtune(D, new StringRef(A.getValue()), Args, Features);
  } else if (success && ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()))) != null)) {
    success
       = getAArch64MicroArchFeaturesFromMcpu(D, new StringRef(A.getValue()), Args, Features);
  } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_arch.getValue()))) {
    success = getAArch64MicroArchFeaturesFromMcpu(D, new StringRef(getAArch64TargetCPU(Args)), 
        Args, Features);
  }
  if (!success) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported)), new StringRef(A.getAsString(Args))));
    } finally {
      $c$.$destroy();
    }
  }
  if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_mgeneral_regs_only.getValue())) != null)) {
    Features.push_back($("-fp-armv8"));
    Features.push_back($("-crypto"));
    Features.push_back($("-neon"));
  }
  } // JAVA: added compound
  {
    
    // En/disable crc
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcrc.getValue()), new OptSpecifier(options.ID.OPT_mnocrc.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mcrc.getValue()))) {
        Features.push_back($("+crc"));
      } else {
        Features.push_back($("-crc"));
      }
    }
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mno_unaligned_access.getValue()), 
        new OptSpecifier(options.ID.OPT_munaligned_access.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mno_unaligned_access.getValue()))) {
        Features.push_back($("+strict-align"));
      }
    }
  }
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_ffixed_x18.getValue()))) {
    Features.push_back($("+reserve-x18"));
  }
}

//<editor-fold defaultstate="collapsed" desc="getHexagonTargetFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2519,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2249,
 FQN="getHexagonTargetFeatures", NM="_ZL24getHexagonTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL24getHexagonTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE")
//</editor-fold>
public static void getHexagonTargetFeatures(/*const*/ ArgList /*&*/ Args, 
                        vectorCharPtr/*&*/ Features) {
  boolean HasHVX = false, HasHVXD = false;
  
  // FIXME: This should be able to use handleTargetFeaturesGroup except it is
  // doing dependent option handling here rather than in initFeatureMap or a
  // similar handler.
  for (Arg /*P*/ /*const*/ /*&*/ A : Args) {
    /*const*/ Option /*&*/ Opt = A.getOption();
    if (Opt.matches(new OptSpecifier(options.ID.OPT_mhexagon_hvx.getValue()))) {
      HasHVX = true;
    } else if (Opt.matches(new OptSpecifier(options.ID.OPT_mno_hexagon_hvx.getValue()))) {
      HasHVXD = HasHVX = false;
    } else if (Opt.matches(new OptSpecifier(options.ID.OPT_mhexagon_hvx_double.getValue()))) {
      HasHVXD = HasHVX = true;
    } else if (Opt.matches(new OptSpecifier(options.ID.OPT_mno_hexagon_hvx_double.getValue()))) {
      HasHVXD = false;
    } else {
      continue;
    }
    A.claim();
  }
  
  Features.push_back(HasHVX ? $("+hvx") : $("-hvx"));
  Features.push_back(HasHVXD ? $("+hvx-double") : $("-hvx-double"));
}

//<editor-fold defaultstate="collapsed" desc="getWebAssemblyTargetFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2545,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2275,
 FQN="getWebAssemblyTargetFeatures", NM="_ZL28getWebAssemblyTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL28getWebAssemblyTargetFeaturesRKN4llvm3opt7ArgListERSt6vectorIPKcSaIS6_EE")
//</editor-fold>
public static void getWebAssemblyTargetFeatures(/*const*/ ArgList /*&*/ Args, 
                            vectorCharPtr/*&*/ Features) {
  handleTargetFeaturesGroup(Args, Features, new OptSpecifier(options.ID.OPT_m_wasm_Features_Group.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="getAMDGPUTargetFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2550,
 FQN="getAMDGPUTargetFeatures", NM="_ZL23getAMDGPUTargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL23getAMDGPUTargetFeaturesRKN5clang6driver6DriverERKN4llvm3opt7ArgListERSt6vectorIPKcSaISB_EE")
//</editor-fold>
public static void getAMDGPUTargetFeatures(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args, 
                       vectorCharPtr/*&*/ Features) {
  {
    /*const*/ Arg /*P*/ dAbi = Args.getLastArg(new OptSpecifier(options.ID.OPT_mamdgpu_debugger_abi.getValue()));
    if ((dAbi != null)) {
      StringRef value = new StringRef(dAbi.getValue());
      if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"1.0")) {
        Features.push_back($("+amdgpu-debugger-insert-nops"));
        Features.push_back($("+amdgpu-debugger-reserve-regs"));
        Features.push_back($("+amdgpu-debugger-emit-prologue"));
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported)), new StringRef(dAbi.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  handleTargetFeaturesGroup(Args, Features, new OptSpecifier(options.ID.OPT_m_amdgpu_Features_Group.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="getTargetFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2567,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2280,
 FQN="getTargetFeatures", NM="_ZL17getTargetFeaturesRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListERNS4_11SmallVectorIPKcLj16EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL17getTargetFeaturesRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListERNS4_11SmallVectorIPKcLj16EEEb")
//</editor-fold>
public static void getTargetFeatures(/*const*/ ToolChain /*&*/ TC, /*const*/ Triple /*&*/ Triple, 
                 /*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs, 
                 boolean ForAS) {
  vectorCharPtr Features = null;
  StringMapUInt LastOpt = null;
  try {
    /*const*/ Driver /*&*/ D = TC.getDriver();
    Features/*J*/= new vectorCharPtr();
    switch (Triple.getArch()) {
     default:
      break;
     case mips:
     case mipsel:
     case mips64:
     case mips64el:
      getMIPSTargetFeatures(D, Triple, Args, Features);
      break;
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      getARMTargetFeatures(TC, Triple, Args, Features, ForAS);
      break;
     case ppc:
     case ppc64:
     case ppc64le:
      getPPCTargetFeatures(D, Triple, Args, Features);
      break;
     case systemz:
      getSystemZTargetFeatures(Args, Features);
      break;
     case aarch64:
     case aarch64_be:
      getAArch64TargetFeatures(D, Args, Features);
      break;
     case x86:
     case x86_64:
      getX86TargetFeatures(D, Triple, Args, Features);
      break;
     case hexagon:
      getHexagonTargetFeatures(Args, Features);
      break;
     case wasm32:
     case wasm64:
      getWebAssemblyTargetFeatures(Args, Features);
      break;
     case sparc:
     case sparcel:
     case sparcv9:
      getSparcTargetFeatures(D, Args, Features);
      break;
     case r600:
     case amdgcn:
      getAMDGPUTargetFeatures(D, Args, Features);
      break;
    }
    
    // Find the last of each feature.
    LastOpt/*J*/= new StringMapUInt(0);
    for (/*uint*/int I = 0, N = Features.size(); $less_uint(I, N); ++I) {
      /*const*/char$ptr/*char P*/ Name = $tryClone(Features.$at(I));
      assert (Name.$at(0) == $$MINUS || Name.$at(0) == $$PLUS);
      LastOpt.$set(/*STRINGREF_STR*/Name.$add(1), I);
    }
    
    for (/*uint*/int I = 0, N = Features.size(); $less_uint(I, N); ++I) {
      // If this feature was overridden, ignore it.
      /*const*/char$ptr/*char P*/ Name = $tryClone(Features.$at(I));
      StringMapIteratorUInt LastI = LastOpt.find(/*STRINGREF_STR*/Name.$add(1));
      assert (LastI.$noteq(LastOpt.end()));
      /*uint*/int Last = LastI.$arrow().second;
      if (Last != I) {
        continue;
      }
      
      CmdArgs.push_back($("-target-feature"));
      CmdArgs.push_back(Name);
    }
  } finally {
    if (LastOpt != null) { LastOpt.$destroy(); }
    if (Features != null) { Features.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="shouldUseExceptionTablesForObjCExceptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2645,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2349,
 FQN="shouldUseExceptionTablesForObjCExceptions", NM="_ZL41shouldUseExceptionTablesForObjCExceptionsRKN5clang11ObjCRuntimeERKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL41shouldUseExceptionTablesForObjCExceptionsRKN5clang11ObjCRuntimeERKN4llvm6TripleE")
//</editor-fold>
public static boolean shouldUseExceptionTablesForObjCExceptions(/*const*/ ObjCRuntime /*&*/ runtime, 
                                         /*const*/ Triple /*&*/ _Triple) {
  // We use the zero-cost exception tables for Objective-C if the non-fragile
  // ABI is enabled or when compiling for x86_64 and ARM on Snow Leopard and
  // later.
  if (runtime.isNonFragile()) {
    return true;
  }
  if (!_Triple.isMacOSX()) {
    return false;
  }
  
  return (!_Triple.isMacOSXVersionLT(10, 5)
     && (_Triple.getArch() == Triple.ArchType.x86_64
     || _Triple.getArch() == Triple.ArchType.arm));
}


/// Adds exception related arguments to the driver command arguments. There's a
/// master flag, -fexceptions and also language specific flags to enable/disable
/// C++ and Objective-C exceptions. This makes it possible to for example
/// disable C++ exceptions but enable Objective-C exceptions.
//<editor-fold defaultstate="collapsed" desc="addExceptionArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2666,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2370,
 FQN="addExceptionArgs", NM="_ZL16addExceptionArgsRKN4llvm3opt7ArgListEN5clang6driver5types2IDERKNS5_9ToolChainEbRKNS4_11ObjCRuntimeERNS_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16addExceptionArgsRKN4llvm3opt7ArgListEN5clang6driver5types2IDERKNS5_9ToolChainEbRKNS4_11ObjCRuntimeERNS_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void addExceptionArgs(/*const*/ ArgList /*&*/ Args, types.ID InputType, 
                /*const*/ ToolChain /*&*/ TC, boolean KernelOrKext, 
                /*const*/ ObjCRuntime /*&*/ objcRuntime, 
                ArgStringList/*&*/ CmdArgs) {
  /*const*/ Driver /*&*/ D = TC.getDriver();
  /*const*/ Triple /*&*/ _Triple = TC.getTriple();
  if (KernelOrKext) {
    // -mkernel and -fapple-kext imply no exceptions, so claim exception related
    // arguments now to avoid warnings about unused arguments.
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fexceptions.getValue()));
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fno_exceptions.getValue()));
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fobjc_exceptions.getValue()));
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fno_objc_exceptions.getValue()));
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fcxx_exceptions.getValue()));
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fno_cxx_exceptions.getValue()));
    return;
  }
  
  // See if the user explicitly enabled exceptions.
  boolean EH = Args.hasFlag(new OptSpecifier(options.ID.OPT_fexceptions.getValue()), new OptSpecifier(options.ID.OPT_fno_exceptions.getValue()), 
      false);
  
  // Obj-C exceptions are enabled by default, regardless of -fexceptions. This
  // is not necessarily sensible, but follows GCC.
  if (types.isObjC(InputType)
     && Args.hasFlag(new OptSpecifier(options.ID.OPT_fobjc_exceptions.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_objc_exceptions.getValue()), true)) {
    CmdArgs.push_back($("-fobjc-exceptions"));
    
    EH |= shouldUseExceptionTablesForObjCExceptions(objcRuntime, _Triple);
  }
  if (types.isCXX(InputType)) {
    // Disable C++ EH by default on XCore and PS4.
    boolean CXXExceptionsEnabled = _Triple.getArch() != Triple.ArchType.xcore && !_Triple.isPS4CPU();
    Arg /*P*/ ExceptionArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_fcxx_exceptions.getValue()), new OptSpecifier(options.ID.OPT_fno_cxx_exceptions.getValue()), 
        new OptSpecifier(options.ID.OPT_fexceptions.getValue()), new OptSpecifier(options.ID.OPT_fno_exceptions.getValue()));
    if ((ExceptionArg != null)) {
      CXXExceptionsEnabled
         = ExceptionArg.getOption().matches(new OptSpecifier(options.ID.OPT_fcxx_exceptions.getValue()))
         || ExceptionArg.getOption().matches(new OptSpecifier(options.ID.OPT_fexceptions.getValue()));
    }
    if (CXXExceptionsEnabled) {
      if (_Triple.isPS4CPU()) {
        ToolChain.RTTIMode RTTIMode = TC.getRTTIMode();
        assert ((ExceptionArg != null)) : "On the PS4 exceptions should only be enabled if passing an argument";
        if (RTTIMode == ToolChain.RTTIMode.RM_DisabledExplicitly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/ Arg /*P*/ RTTIArg = TC.getRTTIArg();
            assert ((RTTIArg != null)) : "RTTI disabled explicitly but no RTTIArg!";
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                    new StringRef(RTTIArg.getAsString(Args))), new StringRef(ExceptionArg.getAsString(Args))));
          } finally {
            $c$.$destroy();
          }
        } else if (RTTIMode == ToolChain.RTTIMode.RM_EnabledImplicitly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(D.Diag(diag.warn_drv_enabling_rtti_with_exceptions)));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        assert (TC.getRTTIMode() != ToolChain.RTTIMode.RM_DisabledImplicitly);
      }
      
      CmdArgs.push_back($("-fcxx-exceptions"));
      
      EH = true;
    }
  }
  if (EH) {
    CmdArgs.push_back($("-fexceptions"));
  }
}

//<editor-fold defaultstate="collapsed" desc="ShouldDisableAutolink">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2737,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2443,
 FQN="ShouldDisableAutolink", NM="_ZL21ShouldDisableAutolinkRKN4llvm3opt7ArgListERKN5clang6driver9ToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL21ShouldDisableAutolinkRKN4llvm3opt7ArgListERKN5clang6driver9ToolChainE")
//</editor-fold>
public static boolean ShouldDisableAutolink(/*const*/ ArgList /*&*/ Args, /*const*/ ToolChain /*&*/ TC) {
  boolean Default = true;
  if (TC.getTriple().isOSDarwin()) {
    // The native darwin assembler doesn't support the linker_option directives,
    // so we disable them if we think the .s file will be passed to it.
    Default = TC.useIntegratedAs();
  }
  return !Args.hasFlag(new OptSpecifier(options.ID.OPT_fautolink.getValue()), new OptSpecifier(options.ID.OPT_fno_autolink.getValue()), 
      Default);
}

//<editor-fold defaultstate="collapsed" desc="ShouldDisableDwarfDirectory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2748,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2454,
 FQN="ShouldDisableDwarfDirectory", NM="_ZL27ShouldDisableDwarfDirectoryRKN4llvm3opt7ArgListERKN5clang6driver9ToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL27ShouldDisableDwarfDirectoryRKN4llvm3opt7ArgListERKN5clang6driver9ToolChainE")
//</editor-fold>
public static boolean ShouldDisableDwarfDirectory(/*const*/ ArgList /*&*/ Args, 
                           /*const*/ ToolChain /*&*/ TC) {
  boolean UseDwarfDirectory = Args.hasFlag(new OptSpecifier(options.ID.OPT_fdwarf_directory_asm.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_dwarf_directory_asm.getValue()), TC.useIntegratedAs());
  return !UseDwarfDirectory;
}


/// \brief Check whether the given input tree contains any compilation actions.
//<editor-fold defaultstate="collapsed" desc="ContainsCompileAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2757,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2463,
 FQN="ContainsCompileAction", NM="_ZL21ContainsCompileActionPKN5clang6driver6ActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL21ContainsCompileActionPKN5clang6driver6ActionE")
//</editor-fold>
public static boolean ContainsCompileAction(/*const*/Action/*P*/ A) {
  if (isa(CompileJobAction.class, A) || isa(BackendJobAction.class, A)) {
    return true;
  }
  
  for (Action /*P*/ /*const*/ /*&*/ AI : A.inputs())  {
    if (ContainsCompileAction(AI)) {
      return true;
    }
  }
  
  return false;
}


/// \brief Check if -relax-all should be passed to the internal assembler.
/// This is done by default when compiling non-assembler source with -O0.
//<editor-fold defaultstate="collapsed" desc="UseRelaxAll">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2770,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2476,
 FQN="UseRelaxAll", NM="_ZL11UseRelaxAllRN5clang6driver11CompilationERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL11UseRelaxAllRN5clang6driver11CompilationERKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean UseRelaxAll(Compilation /*&*/ C, /*const*/ ArgList /*&*/ Args) {
  boolean RelaxDefault = true;
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O_Group.getValue()));
    if ((A != null)) {
      RelaxDefault = A.getOption().matches(new OptSpecifier(options.ID.OPT_O0.getValue()));
    }
  }
  if (RelaxDefault) {
    RelaxDefault = false;
    for (Action /*P*/ /*const*/ /*&*/ Act : C.getActions()) {
      if (ContainsCompileAction(Act)) {
        RelaxDefault = true;
        break;
      }
    }
  }
  
  return Args.hasFlag(new OptSpecifier(options.ID.OPT_mrelax_all.getValue()), new OptSpecifier(options.ID.OPT_mno_relax_all.getValue()), 
      RelaxDefault);
}


// Convert an arg of the form "-gN" or "-ggdbN" or one of their aliases
// to the corresponding DebugInfoKind.
//<editor-fold defaultstate="collapsed" desc="DebugLevelToInfoKind">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2792,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2498,
 FQN="DebugLevelToInfoKind", NM="_ZL20DebugLevelToInfoKindRKN4llvm3opt3ArgE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL20DebugLevelToInfoKindRKN4llvm3opt3ArgE")
//</editor-fold>
public static DebugInfoKind DebugLevelToInfoKind(/*const*/ Arg /*&*/ A) {
  assert (A.getOption().matches(new OptSpecifier(options.ID.OPT_gN_Group.getValue()))) : "Not a -g option that specifies a debug-info level";
  if (A.getOption().matches(new OptSpecifier(options.ID.OPT_g0.getValue()))
     || A.getOption().matches(new OptSpecifier(options.ID.OPT_ggdb0.getValue()))) {
    return DebugInfoKind.NoDebugInfo;
  }
  if (A.getOption().matches(new OptSpecifier(options.ID.OPT_gline_tables_only.getValue()))
     || A.getOption().matches(new OptSpecifier(options.ID.OPT_ggdb1.getValue()))) {
    return DebugInfoKind.DebugLineTablesOnly;
  }
  return DebugInfoKind.LimitedDebugInfo;
}


// Extract the integer N from a string spelled "-dwarf-N", returning 0
// on mismatch. The StringRef input (rather than an Arg) allows
// for use by the "-Xassembler" option parser.
//<editor-fold defaultstate="collapsed" desc="DwarfVersionNum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2807,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2513,
 FQN="DwarfVersionNum", NM="_ZL15DwarfVersionNumN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL15DwarfVersionNumN4llvm9StringRefE")
//</editor-fold>
public static /*uint*/int DwarfVersionNum(StringRef ArgValue) {
  return new StringSwitchUInt(/*NO_COPY*/ArgValue).
      Case(/*KEEP_STR*/"-gdwarf-2", 2).
      Case(/*KEEP_STR*/"-gdwarf-3", 3).
      Case(/*KEEP_STR*/"-gdwarf-4", 4).
      Case(/*KEEP_STR*/"-gdwarf-5", 5).
      Default(0);
}

//<editor-fold defaultstate="collapsed" desc="RenderDebugEnablingArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2816,
 FQN="RenderDebugEnablingArgs", NM="_ZL23RenderDebugEnablingArgsRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEEN5clang14codegenoptions13DebugInfoKindEjNS_12DebuggerKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL23RenderDebugEnablingArgsRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEEN5clang14codegenoptions13DebugInfoKindEjNS_12DebuggerKindE")
//</editor-fold>
public static void RenderDebugEnablingArgs(/*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs, 
                       DebugInfoKind DebugInfoKind, 
                       /*uint*/int DwarfVersion, 
                       DebuggerKind DebuggerTuning) {
  switch (DebugInfoKind) {
   case DebugLineTablesOnly:
    CmdArgs.push_back($("-debug-info-kind=line-tables-only"));
    break;
   case LimitedDebugInfo:
    CmdArgs.push_back($("-debug-info-kind=limited"));
    break;
   case FullDebugInfo:
    CmdArgs.push_back($("-debug-info-kind=standalone"));
    break;
   default:
    break;
  }
  if ($greater_uint(DwarfVersion, 0)) {
    CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-dwarf-version="), new Twine(JD$UInt.INSTANCE, DwarfVersion))));
  }
  switch (DebuggerTuning) {
   case GDB:
    CmdArgs.push_back($("-debugger-tuning=gdb"));
    break;
   case LLDB:
    CmdArgs.push_back($("-debugger-tuning=lldb"));
    break;
   case SCE:
    CmdArgs.push_back($("-debugger-tuning=sce"));
    break;
   default:
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="CollectArgsForIntegratedAssembler">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2851,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2557,
 FQN="CollectArgsForIntegratedAssembler", NM="_ZL33CollectArgsForIntegratedAssemblerRN5clang6driver11CompilationERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEERKNS0_6DriverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL33CollectArgsForIntegratedAssemblerRN5clang6driver11CompilationERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEERKNS0_6DriverE")
//</editor-fold>
public static void CollectArgsForIntegratedAssembler(Compilation /*&*/ C, 
                                 /*const*/ ArgList /*&*/ Args, 
                                 ArgStringList/*&*/ CmdArgs, 
                                 /*const*/ Driver /*&*/ D) {
  if (UseRelaxAll(C, Args)) {
    CmdArgs.push_back($("-mrelax-all"));
  }
  
  // Only default to -mincremental-linker-compatible if we think we are
  // targeting the MSVC linker.
  boolean DefaultIncrementalLinkerCompatible = C.getDefaultToolChain().getTriple().isWindowsMSVCEnvironment();
  if (Args.hasFlag(new OptSpecifier(options.ID.OPT_mincremental_linker_compatible.getValue()), 
      new OptSpecifier(options.ID.OPT_mno_incremental_linker_compatible.getValue()), 
      DefaultIncrementalLinkerCompatible)) {
    CmdArgs.push_back($("-mincremental-linker-compatible"));
  }
  
  // When passing -I arguments to the assembler we sometimes need to
  // unconditionally take the next argument.  For example, when parsing
  // '-Wa,-I -Wa,foo' we need to accept the -Wa,foo arg after seeing the
  // -Wa,-I arg and when parsing '-Wa,-I,foo' we need to accept the 'foo'
  // arg after parsing the '-I' arg.
  boolean TakeNextArg = false;
  
  // When using an integrated assembler, translate -Wa, and -Xassembler
  // options.
  boolean CompressDebugSections = false;
  
  boolean UseRelaxRelocations = ENABLE_X86_RELAX_RELOCATIONS;
  /*const*/char$ptr/*char P*/ MipsTargetFeature = null;
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()))) {
    A.claim();
    
    for (char$ptr _Value : A.getValues()) {
      StringRef Value = new StringRef(_Value);
      if (TakeNextArg) {
        CmdArgs.push_back(Value.data());
        TakeNextArg = false;
        continue;
      }
      switch (C.getDefaultToolChain().getArch()) {
       default:
        break;
       case mips:
       case mipsel:
       case mips64:
       case mips64el:
        if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"--trap")) {
          CmdArgs.push_back($("-target-feature"));
          CmdArgs.push_back($("+use-tcc-in-div"));
          continue;
        }
        if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"--break")) {
          CmdArgs.push_back($("-target-feature"));
          CmdArgs.push_back($("-use-tcc-in-div"));
          continue;
        }
        if (Value.startswith(/*STRINGREF_STR*/"-msoft-float")) {
          CmdArgs.push_back($("-target-feature"));
          CmdArgs.push_back($("+soft-float"));
          continue;
        }
        if (Value.startswith(/*STRINGREF_STR*/"-mhard-float")) {
          CmdArgs.push_back($("-target-feature"));
          CmdArgs.push_back($("-soft-float"));
          continue;
        }
        
        MipsTargetFeature = $tryClone(new StringSwitchCharPtr(/*NO_COPY*/Value).
            Case(/*KEEP_STR*/"-mips1", /*KEEP_STR*/"+mips1").
            Case(/*KEEP_STR*/"-mips2", /*KEEP_STR*/"+mips2").
            Case(/*KEEP_STR*/"-mips3", /*KEEP_STR*/"+mips3").
            Case(/*KEEP_STR*/"-mips4", /*KEEP_STR*/"+mips4").
            Case(/*KEEP_STR*/"-mips5", /*KEEP_STR*/"+mips5").
            Case(/*KEEP_STR*/"-mips32", /*KEEP_STR*/"+mips32").
            Case(/*KEEP_STR*/"-mips32r2", /*KEEP_STR*/"+mips32r2").
            Case(/*KEEP_STR*/"-mips32r3", /*KEEP_STR*/"+mips32r3").
            Case(/*KEEP_STR*/"-mips32r5", /*KEEP_STR*/"+mips32r5").
            Case(/*KEEP_STR*/"-mips32r6", /*KEEP_STR*/"+mips32r6").
            Case(/*KEEP_STR*/"-mips64", /*KEEP_STR*/"+mips64").
            Case(/*KEEP_STR*/"-mips64r2", /*KEEP_STR*/"+mips64r2").
            Case(/*KEEP_STR*/"-mips64r3", /*KEEP_STR*/"+mips64r3").
            Case(/*KEEP_STR*/"-mips64r5", /*KEEP_STR*/"+mips64r5").
            Case(/*KEEP_STR*/"-mips64r6", /*KEEP_STR*/"+mips64r6").
            Default(/*NULL*/(/*const*/char$ptr/*char P*//*const*/)null));
        if ((MipsTargetFeature != null)) {
          continue;
        }
      }
      if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"-force_cpusubtype_ALL")) {
        // Do nothing, this is the default and we don't support anything else.
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"-L")) {
        CmdArgs.push_back($("-msave-temp-labels"));
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"--fatal-warnings")) {
        CmdArgs.push_back($("-massembler-fatal-warnings"));
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"--noexecstack")) {
        CmdArgs.push_back($("-mnoexecstack"));
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"-compress-debug-sections")
         || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"--compress-debug-sections")) {
        CompressDebugSections = true;
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"-nocompress-debug-sections")
         || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"--nocompress-debug-sections")) {
        CompressDebugSections = false;
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"-mrelax-relocations=yes")
         || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"--mrelax-relocations=yes")) {
        UseRelaxRelocations = true;
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"-mrelax-relocations=no")
         || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"--mrelax-relocations=no")) {
        UseRelaxRelocations = false;
      } else if (Value.startswith(/*STRINGREF_STR*/"-I")) {
        CmdArgs.push_back(Value.data());
        // We need to consume the next argument if the current arg is a plain
        // -I. The next arg will be the include directory.
        if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"-I")) {
          TakeNextArg = true;
        }
      } else if (Value.startswith(/*STRINGREF_STR*/"-gdwarf-")) {
        // "-gdwarf-N" options are not cc1as options.
        /*uint*/int DwarfVersion = DwarfVersionNum(new StringRef(Value));
        if (DwarfVersion == 0) { // Send it onward, and let cc1as complain.
          CmdArgs.push_back(Value.data());
        } else {
          RenderDebugEnablingArgs(Args, CmdArgs, 
              DebugInfoKind.LimitedDebugInfo, 
              DwarfVersion, DebuggerKind.Default);
        }
      } else if (Value.startswith(/*STRINGREF_STR*/"-mcpu") || Value.startswith(/*STRINGREF_STR*/"-mfpu")
         || Value.startswith(/*STRINGREF_STR*/"-mhwdiv") || Value.startswith(/*STRINGREF_STR*/"-march")) {
        // Do nothing, we'll validate it later.
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_option_argument)), 
                  A.getOption().getName()), /*NO_COPY*/Value));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (CompressDebugSections) {
    if (ZlibGlobals.isAvailable()) {
      CmdArgs.push_back($("-compress-debug-sections"));
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(D.Diag(diag.warn_debug_compression_unavailable)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (UseRelaxRelocations) {
    CmdArgs.push_back($("--mrelax-relocations"));
  }
  if ($noteq_ptr(MipsTargetFeature, null)) {
    CmdArgs.push_back($("-target-feature"));
    CmdArgs.push_back(MipsTargetFeature);
  }
}


// This adds the static libclang_rt.builtins-arch.a directly to the command line
// FIXME: Make sure we can also emit shared objects if they're requested
// and available, check for possible errors, etc.
//<editor-fold defaultstate="collapsed" desc="addClangRT">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3002,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2674,
 FQN="addClangRT", NM="_ZL10addClangRTRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL10addClangRTRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void addClangRT(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
          ArgStringList/*&*/ CmdArgs) {
  CmdArgs.push_back(TC.getCompilerRTArgString(Args, new StringRef(/*KEEP_STR*/"builtins")));
}


/// Compute the desired OpenMP runtime from the flag provided.
//<editor-fold defaultstate="collapsed" desc="getOpenMPRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3030,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2702,
 FQN="getOpenMPRuntime", NM="_ZL16getOpenMPRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16getOpenMPRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListE")
//</editor-fold>
public static OpenMPRuntimeKind getOpenMPRuntime(/*const*/ ToolChain /*&*/ TC, 
                /*const*/ ArgList /*&*/ Args) {
  StringRef RuntimeName/*J*/= new StringRef(/*KEEP_STR*/"libomp");
  
  /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fopenmp_EQ.getValue()));
  if ((A != null)) {
    RuntimeName.$assignMove(/*STRINGREF_STR*/A.getValue());
  }
  
  OpenMPRuntimeKind RT = new StringSwitch<OpenMPRuntimeKind>(/*NO_COPY*/RuntimeName).
      Case(/*KEEP_STR*/"libomp", OpenMPRuntimeKind.OMPRT_OMP).
      Case(/*KEEP_STR*/"libgomp", OpenMPRuntimeKind.OMPRT_GOMP).
      Case(/*KEEP_STR*/"libiomp5", OpenMPRuntimeKind.OMPRT_IOMP5).
      Default(OpenMPRuntimeKind.OMPRT_Unknown);
  if (RT == OpenMPRuntimeKind.OMPRT_Unknown) {
    if ((A != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(TC.getDriver().Diag(diag.err_drv_unsupported_option_argument)), 
                A.getOption().getName()), A.getValue()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // FIXME: We could use a nicer diagnostic here.
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(TC.getDriver().Diag(diag.err_drv_unsupported_opt)), /*KEEP_STR*/"-fopenmp"));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return RT;
}

//<editor-fold defaultstate="collapsed" desc="addOpenMPRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3056,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2728,
 FQN="addOpenMPRuntime", NM="_ZL16addOpenMPRuntimeRN4llvm11SmallVectorIPKcLj16EEERKN5clang6driver9ToolChainERKNS_3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16addOpenMPRuntimeRN4llvm11SmallVectorIPKcLj16EEERKN5clang6driver9ToolChainERKNS_3opt7ArgListE")
//</editor-fold>
public static void addOpenMPRuntime(ArgStringList/*&*/ CmdArgs, /*const*/ ToolChain /*&*/ TC, 
                /*const*/ ArgList /*&*/ Args) {
  if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fopenmp.getValue()), new OptSpecifier(options.ID.OPT_fopenmp_EQ.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_openmp.getValue()), false)) {
    return;
  }
  switch (getOpenMPRuntime(TC, Args)) {
   case OMPRT_OMP:
    CmdArgs.push_back($("-lomp"));
    break;
   case OMPRT_GOMP:
    CmdArgs.push_back($("-lgomp"));
    break;
   case OMPRT_IOMP5:
    CmdArgs.push_back($("-liomp5"));
    break;
   case OMPRT_Unknown:
    // Already diagnosed.
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="addSanitizerRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3078,
 FQN="addSanitizerRuntime", NM="_ZL19addSanitizerRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19addSanitizerRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefEbb")
//</editor-fold>
public static void addSanitizerRuntime(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
                   ArgStringList/*&*/ CmdArgs, StringRef Sanitizer, 
                   boolean IsShared, boolean IsWhole) {
  // Wrap any static runtimes that must be forced into executable in
  // whole-archive.
  if (IsWhole) {
    CmdArgs.push_back($("-whole-archive"));
  }
  CmdArgs.push_back(TC.getCompilerRTArgString(Args, new StringRef(Sanitizer), IsShared));
  if (IsWhole) {
    CmdArgs.push_back($("-no-whole-archive"));
  }
}


// Tries to use a file with the list of dynamic symbols that need to be exported
// from the runtime library. Returns true if the file was found.
//<editor-fold defaultstate="collapsed" desc="addSanitizerDynamicList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3090,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2762,
 FQN="addSanitizerDynamicList", NM="_ZL23addSanitizerDynamicListRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL23addSanitizerDynamicListRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEENS4_9StringRefE")
//</editor-fold>
public static boolean addSanitizerDynamicList(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
                       ArgStringList/*&*/ CmdArgs, 
                       StringRef Sanitizer) {
  SmallString/*128*/ SanRT/*J*/= new SmallString/*128*/(new StringRef(TC.getCompilerRT(Args, new StringRef(Sanitizer))), 128);
  if (fs.exists($add_StringRef_char$ptr$C(SanRT.$StringRef(), /*KEEP_STR*/".syms"))) {
    CmdArgs.push_back(Args.MakeArgString($add_Twine($add_char$ptr$C_StringRef(/*KEEP_STR*/"--dynamic-list=", SanRT.$StringRef()), new Twine(/*KEEP_STR*/".syms"))));
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="linkSanitizerRuntimeDeps">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3101,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2773,
 FQN="linkSanitizerRuntimeDeps", NM="_ZL24linkSanitizerRuntimeDepsRKN5clang6driver9ToolChainERN4llvm11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL24linkSanitizerRuntimeDepsRKN5clang6driver9ToolChainERN4llvm11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void linkSanitizerRuntimeDeps(/*const*/ ToolChain /*&*/ TC, 
                        ArgStringList/*&*/ CmdArgs) {
  // Force linking against the system libraries sanitizers depends on
  // (see PR15823 why this is necessary).
  CmdArgs.push_back($("--no-as-needed"));
  CmdArgs.push_back($("-lpthread"));
  CmdArgs.push_back($("-lrt"));
  CmdArgs.push_back($("-lm"));
  // There's no libdl on FreeBSD.
  if (TC.getTriple().getOS() != Triple.OSType.FreeBSD) {
    CmdArgs.push_back($("-ldl"));
  }
}

//<editor-fold defaultstate="collapsed" desc="collectSanitizerRuntimes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3114,
 FQN="collectSanitizerRuntimes", NM="_ZL24collectSanitizerRuntimesRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_15SmallVectorImplINS4_9StringRefEEESC_SC_SC_SC_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL24collectSanitizerRuntimesRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_15SmallVectorImplINS4_9StringRefEEESC_SC_SC_SC_")
//</editor-fold>
public static void collectSanitizerRuntimes(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
                        SmallVectorImpl<StringRef> /*&*/ SharedRuntimes, 
                        SmallVectorImpl<StringRef> /*&*/ StaticRuntimes, 
                        SmallVectorImpl<StringRef> /*&*/ NonWholeStaticRuntimes, 
                        SmallVectorImpl<StringRef> /*&*/ HelperStaticRuntimes, 
                        SmallVectorImpl<StringRef> /*&*/ RequiredSymbols) {
  /*const*/ SanitizerArgs /*&*/ SanArgs = TC.getSanitizerArgs();
  // Collect shared runtimes.
  if (SanArgs.needsAsanRt() && SanArgs.needsSharedAsanRt()) {
    SharedRuntimes.push_back(new StringRef(/*KEEP_STR*/"asan"));
  }
  // The stats_client library is also statically linked into DSOs.
  if (SanArgs.needsStatsRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"stats_client"));
  }
  
  // Collect static runtimes.
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || TC.getTriple().isAndroid()) {
    // Don't link static runtimes into DSOs or if compiling for Android.
    return;
  }
  if (SanArgs.needsAsanRt()) {
    if (SanArgs.needsSharedAsanRt()) {
      HelperStaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"asan-preinit"));
    } else {
      StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"asan"));
      if (SanArgs.linkCXXRuntimes()) {
        StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"asan_cxx"));
      }
    }
  }
  if (SanArgs.needsDfsanRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"dfsan"));
  }
  if (SanArgs.needsLsanRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"lsan"));
  }
  if (SanArgs.needsMsanRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"msan"));
    if (SanArgs.linkCXXRuntimes()) {
      StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"msan_cxx"));
    }
  }
  if (SanArgs.needsTsanRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"tsan"));
    if (SanArgs.linkCXXRuntimes()) {
      StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"tsan_cxx"));
    }
  }
  if (SanArgs.needsUbsanRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"ubsan_standalone"));
    if (SanArgs.linkCXXRuntimes()) {
      StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"ubsan_standalone_cxx"));
    }
  }
  if (SanArgs.needsSafeStackRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"safestack"));
  }
  if (SanArgs.needsCfiRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"cfi"));
  }
  if (SanArgs.needsCfiDiagRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"cfi_diag"));
    if (SanArgs.linkCXXRuntimes()) {
      StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"ubsan_standalone_cxx"));
    }
  }
  if (SanArgs.needsStatsRt()) {
    NonWholeStaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"stats"));
    RequiredSymbols.push_back(new StringRef(/*KEEP_STR*/"__sanitizer_stats_register"));
  }
  if (SanArgs.needsEsanRt()) {
    StaticRuntimes.push_back(new StringRef(/*KEEP_STR*/"esan"));
  }
}


// Should be called before we add system libraries (C++ ABI, libstdc++/libc++,
// C runtime, etc). Returns true if sanitizer system deps need to be linked in.
//<editor-fold defaultstate="collapsed" desc="addSanitizerRuntimes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3182,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2840,
 FQN="addSanitizerRuntimes", NM="_ZL20addSanitizerRuntimesRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL20addSanitizerRuntimesRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static boolean addSanitizerRuntimes(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
                    ArgStringList/*&*/ CmdArgs) {
  SmallVector<StringRef> SharedRuntimes/*J*/= new SmallVector<StringRef>(4, new StringRef()), StaticRuntimes/*J*/= new SmallVector<StringRef>(4, new StringRef()), 
      NonWholeStaticRuntimes/*J*/= new SmallVector<StringRef>(4, new StringRef()), HelperStaticRuntimes/*J*/= new SmallVector<StringRef>(4, new StringRef()), RequiredSymbols/*J*/= new SmallVector<StringRef>(4, new StringRef());
  collectSanitizerRuntimes(TC, Args, SharedRuntimes, StaticRuntimes, 
      NonWholeStaticRuntimes, HelperStaticRuntimes, 
      RequiredSymbols);
  for (StringRef RT : SharedRuntimes)  {
    addSanitizerRuntime(TC, Args, CmdArgs, new StringRef(RT), true, false);
  }
  for (StringRef RT : HelperStaticRuntimes)  {
    addSanitizerRuntime(TC, Args, CmdArgs, new StringRef(RT), false, true);
  }
  boolean AddExportDynamic = false;
  for (StringRef RT : StaticRuntimes) {
    addSanitizerRuntime(TC, Args, CmdArgs, new StringRef(RT), false, true);
    AddExportDynamic |= !addSanitizerDynamicList(TC, Args, CmdArgs, new StringRef(RT));
  }
  for (StringRef RT : NonWholeStaticRuntimes) {
    addSanitizerRuntime(TC, Args, CmdArgs, new StringRef(RT), false, false);
    AddExportDynamic |= !addSanitizerDynamicList(TC, Args, CmdArgs, new StringRef(RT));
  }
  for (StringRef S : RequiredSymbols) {
    CmdArgs.push_back($("-u"));
    CmdArgs.push_back(Args.MakeArgString(new Twine(S)));
  }
  // If there is a static runtime with no dynamic list, force all the symbols
  // to be dynamic to be sure we export sanitizer interface functions.
  if (AddExportDynamic) {
    CmdArgs.push_back($("-export-dynamic"));
  }
  return !StaticRuntimes.empty();
}

//<editor-fold defaultstate="collapsed" desc="addXRayRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3213,
 FQN="addXRayRuntime", NM="_ZL14addXRayRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL14addXRayRuntimeRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static boolean addXRayRuntime(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
              ArgStringList/*&*/ CmdArgs) {
  if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fxray_instrument.getValue()), 
      new OptSpecifier(options.ID.OPT_fnoxray_instrument.getValue()), false)) {
    CmdArgs.push_back($("-whole-archive"));
    CmdArgs.push_back(TC.getCompilerRTArgString(Args, new StringRef(/*KEEP_STR*/"xray"), false));
    CmdArgs.push_back($("-no-whole-archive"));
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="linkXRayRuntimeDeps">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3225,
 FQN="linkXRayRuntimeDeps", NM="_ZL19linkXRayRuntimeDepsRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19linkXRayRuntimeDepsRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void linkXRayRuntimeDeps(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
                   ArgStringList/*&*/ CmdArgs) {
  CmdArgs.push_back($("--no-as-needed"));
  CmdArgs.push_back($("-lpthread"));
  CmdArgs.push_back($("-lrt"));
  CmdArgs.push_back($("-lm"));
  CmdArgs.push_back($("-latomic"));
  if (TC.GetCXXStdlibType(Args) == ToolChain.CXXStdlibType.CST_Libcxx) {
    CmdArgs.push_back($("-lc++"));
  } else {
    CmdArgs.push_back($("-lstdc++"));
  }
  if (TC.getTriple().getOS() != Triple.OSType.FreeBSD) {
    CmdArgs.push_back($("-ldl"));
  }
}

//<editor-fold defaultstate="collapsed" desc="areOptimizationsEnabled">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3240,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2862,
 FQN="areOptimizationsEnabled", NM="_ZL23areOptimizationsEnabledRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL23areOptimizationsEnabledRKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean areOptimizationsEnabled(/*const*/ ArgList /*&*/ Args) {
  {
    // Find the last -O arg and see if it is non-zero.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O_Group.getValue()));
    if ((A != null)) {
      return !A.getOption().matches(new OptSpecifier(options.ID.OPT_O0.getValue()));
    }
  }
  // Defaults to -O0.
  return false;
}

//<editor-fold defaultstate="collapsed" desc="shouldUseFramePointerForTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3248,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2870,
 FQN="shouldUseFramePointerForTarget", NM="_ZL30shouldUseFramePointerForTargetRKN4llvm3opt7ArgListERKNS_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL30shouldUseFramePointerForTargetRKN4llvm3opt7ArgListERKNS_6TripleE")
//</editor-fold>
public static boolean shouldUseFramePointerForTarget(/*const*/ ArgList /*&*/ Args, 
                              /*const*/ Triple /*&*/ _Triple) {
  switch (_Triple.getArch()) {
   case xcore:
   case wasm32:
   case wasm64:
    // XCore never wants frame pointers, regardless of OS.
    // WebAssembly never wants frame pointers.
    return false;
   default:
    break;
  }
  if (_Triple.isOSLinux() || _Triple.getOS() == Triple.OSType.CloudABI) {
    switch (_Triple.getArch()) {
     case mips64:
     case mips64el:
     case mips:
     case mipsel:
     case systemz:
     case x86:
     case x86_64:
      // Don't use a frame pointer on linux if optimizing for certain targets.
      return !areOptimizationsEnabled(Args);
     default:
      return true;
    }
  }
  if (_Triple.isOSWindows()) {
    switch (_Triple.getArch()) {
     case x86:
      return !areOptimizationsEnabled(Args);
     case x86_64:
      return _Triple.isOSBinFormatMachO();
     case arm:
     case thumb:
      // Windows on ARM builds with FPO disabled to aid fast stack walking
      return true;
     default:
      // All other supported Windows ISAs use xdata unwind information, so frame
      // pointers are not generally useful.
      return false;
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="shouldUseFramePointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3297,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2917,
 FQN="shouldUseFramePointer", NM="_ZL21shouldUseFramePointerRKN4llvm3opt7ArgListERKNS_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL21shouldUseFramePointerRKN4llvm3opt7ArgListERKNS_6TripleE")
//</editor-fold>
public static boolean shouldUseFramePointer(/*const*/ ArgList /*&*/ Args, 
                     /*const*/ Triple /*&*/ Triple) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fno_omit_frame_pointer.getValue()), 
        new OptSpecifier(options.ID.OPT_fomit_frame_pointer.getValue()));
    if ((A != null)) {
      return A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_omit_frame_pointer.getValue()));
    }
  }
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
    return true;
  }
  
  return shouldUseFramePointerForTarget(Args, Triple);
}

//<editor-fold defaultstate="collapsed" desc="shouldUseLeafFramePointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3308,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2928,
 FQN="shouldUseLeafFramePointer", NM="_ZL25shouldUseLeafFramePointerRKN4llvm3opt7ArgListERKNS_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL25shouldUseLeafFramePointerRKN4llvm3opt7ArgListERKNS_6TripleE")
//</editor-fold>
public static boolean shouldUseLeafFramePointer(/*const*/ ArgList /*&*/ Args, 
                         /*const*/ Triple /*&*/ Triple) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mno_omit_leaf_frame_pointer.getValue()), 
        new OptSpecifier(options.ID.OPT_momit_leaf_frame_pointer.getValue()));
    if ((A != null)) {
      return A.getOption().matches(new OptSpecifier(options.ID.OPT_mno_omit_leaf_frame_pointer.getValue()));
    }
  }
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
    return true;
  }
  if (Triple.isPS4CPU()) {
    return false;
  }
  
  return shouldUseFramePointerForTarget(Args, Triple);
}


/// Add a CC1 option to specify the debug compilation directory.
//<editor-fold defaultstate="collapsed" desc="addDebugCompDirArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3323,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2943,
 FQN="addDebugCompDirArg", NM="_ZL18addDebugCompDirArgRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL18addDebugCompDirArgRKN4llvm3opt7ArgListERNS_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void addDebugCompDirArg(/*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs) {
  SmallString/*128*/ cwd/*J*/= new SmallString/*128*/(128);
  if (!fs.current_path(cwd).$bool()) {
    CmdArgs.push_back($("-fdebug-compilation-dir"));
    CmdArgs.push_back(Args.MakeArgString(new Twine(cwd)));
  }
}

//<editor-fold defaultstate="collapsed" desc="SplitDebugName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3331,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2951,
 FQN="SplitDebugName", NM="_ZL14SplitDebugNameRKN4llvm3opt7ArgListERKN5clang6driver9InputInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL14SplitDebugNameRKN4llvm3opt7ArgListERKN5clang6driver9InputInfoE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ SplitDebugName(/*const*/ ArgList /*&*/ Args, /*const*/ InputInfo /*&*/ Input) {
  Arg /*P*/ FinalOutput = Args.getLastArg(new OptSpecifier(options.ID.OPT_o.getValue()));
  if ((FinalOutput != null) && Args.hasArg(new OptSpecifier(options.ID.OPT_c.getValue()))) {
    SmallString/*128*/ T/*J*/= new SmallString/*128*/(new StringRef(FinalOutput.getValue()), 128);
    path.replace_extension(T, new Twine(/*KEEP_STR*/"dwo"));
    return Args.MakeArgString(new Twine(T));
  } else {
    // Use the compilation dir.
    SmallString/*128*/ T/*J*/= new SmallString/*128*/(Args.getLastArgValue(new OptSpecifier(options.ID.OPT_fdebug_compilation_dir.getValue())), 128);
    SmallString/*128*/ F/*J*/= new SmallString/*128*/(path.stem(new StringRef(Input.getBaseInput())), 128);
    path.replace_extension(F, new Twine(/*KEEP_STR*/"dwo"));
    T.$addassign(F.$StringRef());
    return Args.MakeArgString(new Twine(F));
  }
}

//<editor-fold defaultstate="collapsed" desc="SplitDebugInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3348,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2968,
 FQN="SplitDebugInfo", NM="_ZL14SplitDebugInfoRKN5clang6driver9ToolChainERNS0_11CompilationERKNS0_4ToolERKNS0_9JobActionERKN4llvm3opt7ArgListERKNS0_9InputInfoEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL14SplitDebugInfoRKN5clang6driver9ToolChainERNS0_11CompilationERKNS0_4ToolERKNS0_9JobActionERKN4llvm3opt7ArgListERKNS0_9InputInfoEPKc")
//</editor-fold>
public static void SplitDebugInfo(/*const*/ ToolChain /*&*/ TC, Compilation /*&*/ C, /*const*/ Tool /*&*/ T, 
              /*const*/ JobAction /*&*/ JA, /*const*/ ArgList /*&*/ Args, 
              /*const*/ InputInfo /*&*/ Output, /*const*/char$ptr/*char P*/ OutFile) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ArgStringList ExtractArgs/*J*/= new ArgStringList();
    ExtractArgs.push_back($("--extract-dwo"));
    
    ArgStringList StripArgs/*J*/= new ArgStringList();
    StripArgs.push_back($("--strip-dwo"));
    
    // Grabbing the output of the earlier compile step.
    StripArgs.push_back(Output.getFilename());
    ExtractArgs.push_back(Output.getFilename());
    ExtractArgs.push_back(OutFile);
    
    /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(TC.GetProgramPath($("objcopy")))));
    InputInfo II/*J*/= new InputInfo(types.ID.TY_Object, Output.getFilename(), Output.getFilename());
    
    // First extract the dwo sections.
    C.addCommand($c$.track(llvm.make_unique(new Command(JA, T, Exec, ExtractArgs, II)))); $c$.clean();
    
    // Then remove them from the original .o file.
    C.addCommand($c$.track(llvm.make_unique(new Command(JA, T, Exec, StripArgs, II)))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// \brief Vectorize at all optimization levels greater than 1 except for -Oz.
/// For -Oz the loop vectorizer is disable, while the slp vectorizer is enabled.
//<editor-fold defaultstate="collapsed" desc="shouldEnableVectorizerAtOLevel">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3374,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2994,
 FQN="shouldEnableVectorizerAtOLevel", NM="_ZL30shouldEnableVectorizerAtOLevelRKN4llvm3opt7ArgListEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL30shouldEnableVectorizerAtOLevelRKN4llvm3opt7ArgListEb")
//</editor-fold>
public static boolean shouldEnableVectorizerAtOLevel(/*const*/ ArgList /*&*/ Args, boolean isSlpVec) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O_Group.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O4.getValue()))
         || A.getOption().matches(new OptSpecifier(options.ID.OPT_Ofast.getValue()))) {
        return true;
      }
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O0.getValue()))) {
        return false;
      }
      assert (A.getOption().matches(new OptSpecifier(options.ID.OPT_O.getValue()))) : "Must have a -O flag";
      
      // Vectorize -Os.
      StringRef S/*J*/= new StringRef(A.getValue());
      if ($eq_StringRef(/*NO_COPY*/S, /*STRINGREF_STR*/"s")) {
        return true;
      }
      
      // Don't vectorize -Oz, unless it's the slp vectorizer.
      if ($eq_StringRef(/*NO_COPY*/S, /*STRINGREF_STR*/"z")) {
        return isSlpVec;
      }
      
      /*uint*/uint$ref OptLevel = create_uint$ref(0);
      if (S.getAsInteger$NotSigned(10, OptLevel)) {
        return false;
      }
      
      return $greater_uint(OptLevel, 1);
    }
  }
  
  return false;
}


/// Add -x lang to \p CmdArgs for \p Input.
//<editor-fold defaultstate="collapsed" desc="addDashXForInput">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3405,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3025,
 FQN="addDashXForInput", NM="_ZL16addDashXForInputRKN4llvm3opt7ArgListERKN5clang6driver9InputInfoERNS_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16addDashXForInputRKN4llvm3opt7ArgListERKN5clang6driver9InputInfoERNS_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void addDashXForInput(/*const*/ ArgList /*&*/ Args, /*const*/ InputInfo /*&*/ Input, 
                ArgStringList/*&*/ CmdArgs) {
  // When using -verify-pch, we don't want to provide the type
  // 'precompiled-header' if it was inferred from the file extension
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_verify_pch.getValue())) && Input.getType() == types.ID.TY_PCH) {
    return;
  }
  
  CmdArgs.push_back($("-x"));
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_rewrite_objc.getValue()))) {
    CmdArgs.push_back(types.getTypeName(types.ID.TY_PP_ObjCXX));
  } else {
    CmdArgs.push_back(types.getTypeName(Input.getType()));
  }
}

//<editor-fold defaultstate="collapsed" desc="getMSCompatibilityVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3419,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3039,
 FQN="getMSCompatibilityVersion", NM="_ZL25getMSCompatibilityVersionj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL25getMSCompatibilityVersionj")
//</editor-fold>
public static VersionTuple getMSCompatibilityVersion(/*uint*/int Version) {
  if ($less_uint(Version, 100)) {
    return new VersionTuple(Version);
  }
  if ($less_uint(Version, 10000)) {
    return new VersionTuple(Version / 100, Version % 100);
  }
  
  /*uint*/int Build = 0, Factor = 1;
  for (; $greater_uint(Version, 10000); Version = Version / 10 , Factor = Factor * 10)  {
    Build = Build + (Version % 10) * Factor;
  }
  return new VersionTuple(Version / 100, Version % 100, Build);
}


// Claim options we don't want to warn if they are unused. We do this for
// options that build systems might add but are unused when assembling or only
// running the preprocessor for example.
//<editor-fold defaultstate="collapsed" desc="claimNoWarnArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3435,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3055,
 FQN="claimNoWarnArgs", NM="_ZL15claimNoWarnArgsRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL15claimNoWarnArgsRKN4llvm3opt7ArgListE")
//</editor-fold>
public static void claimNoWarnArgs(/*const*/ ArgList /*&*/ Args) {
  // Don't warn about unused -f(no-)?lto.  This can happen when we're
  // preprocessing, precompiling or assembling.
  Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_flto_EQ.getValue()));
  Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_flto.getValue()));
  Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fno_lto.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="appendUserToPath">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use user name*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3443,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3063,
 FQN="appendUserToPath", NM="_ZL16appendUserToPathRN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16appendUserToPathRN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void appendUserToPath(SmallString/*&*/ Result) {
  /*const*/char$ptr/*char P*/ Username = $tryClone(getenv($("LOGNAME")));
  // JAVA: use "user.name"
  if ((Username == null)) {
    Username = create_char$ptr_utf8(System.getProperty("user.name"));
  }
  if ((Username != null)) {
    // Validate that LoginName can be used in a path, and get its length.
    /*size_t*/int Len = 0;
    for (/*const*/char$ptr/*char P*/ P = $tryClone(Username); (P.$star() != 0); P.$preInc() , ++Len) {
      if (!isAlphanumeric(P.$star()) && P.$star() != $$UNDERSCORE) {
        Username = null;
        break;
      }
    }
    if ((Username != null) && $greater_uint(Len, 0)) {
      Result.append(Username, /*PERF*/Len);
      return;
    }
  }
  std.string UID = llvm.utostr($uid_t2ulong(getuid()));
  Result.append(UID.begin(), UID.size/*end*/()); // JAVA
}

//<editor-fold defaultstate="collapsed" desc="addPGOAndCoverageFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3529,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3142,
 FQN="addPGOAndCoverageFlags", NM="_ZL22addPGOAndCoverageFlagsRN5clang6driver11CompilationERKNS0_6DriverERKNS0_9InputInfoERKN4llvm3opt7ArgListERNS9_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL22addPGOAndCoverageFlagsRN5clang6driver11CompilationERKNS0_6DriverERKNS0_9InputInfoERKN4llvm3opt7ArgListERNS9_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void addPGOAndCoverageFlags(Compilation /*&*/ C, /*const*/ Driver /*&*/ D, 
                      /*const*/ InputInfo /*&*/ Output, /*const*/ ArgList /*&*/ Args, 
                      ArgStringList/*&*/ CmdArgs) {
  
  Arg /*P*/ PGOGenerateArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_fprofile_generate.getValue()), 
      new OptSpecifier(options.ID.OPT_fprofile_generate_EQ.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_profile_generate.getValue()));
  if ((PGOGenerateArg != null)
     && PGOGenerateArg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_profile_generate.getValue()))) {
    PGOGenerateArg = null;
  }
  
  Arg /*P*/ ProfileGenerateArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_fprofile_instr_generate.getValue()), 
      new OptSpecifier(options.ID.OPT_fprofile_instr_generate_EQ.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_profile_instr_generate.getValue()));
  if ((ProfileGenerateArg != null)
     && ProfileGenerateArg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_profile_instr_generate.getValue()))) {
    ProfileGenerateArg = null;
  }
  if ((PGOGenerateArg != null) && (ProfileGenerateArg != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
              PGOGenerateArg.getSpelling()), ProfileGenerateArg.getSpelling()));
    } finally {
      $c$.$destroy();
    }
  }
  
  Arg /*P*/ ProfileUseArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_fprofile_instr_use.getValue()), new OptSpecifier(options.ID.OPT_fprofile_instr_use_EQ.getValue()), 
      new OptSpecifier(options.ID.OPT_fprofile_use.getValue()), new OptSpecifier(options.ID.OPT_fprofile_use_EQ.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_profile_instr_use.getValue()));
  if ((ProfileUseArg != null)
     && ProfileUseArg.getOption().matches(new OptSpecifier(options.ID.OPT_fno_profile_instr_use.getValue()))) {
    ProfileUseArg = null;
  }
  if ((PGOGenerateArg != null) && (ProfileUseArg != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
              ProfileUseArg.getSpelling()), PGOGenerateArg.getSpelling()));
    } finally {
      $c$.$destroy();
    }
  }
  if ((ProfileGenerateArg != null) && (ProfileUseArg != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
              ProfileGenerateArg.getSpelling()), ProfileUseArg.getSpelling()));
    } finally {
      $c$.$destroy();
    }
  }
  if ((ProfileGenerateArg != null)) {
    if (ProfileGenerateArg.getOption().matches(new OptSpecifier(options.ID.OPT_fprofile_instr_generate_EQ.getValue()))) {
      CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-fprofile-instrument-path="), 
                  new Twine(ProfileGenerateArg.getValue()))));
    }
    // The default is to use Clang Instrumentation.
    CmdArgs.push_back($("-fprofile-instrument=clang"));
  }
  if ((PGOGenerateArg != null)) {
    CmdArgs.push_back($("-fprofile-instrument=llvm"));
    if (PGOGenerateArg.getOption().matches(new OptSpecifier(options.ID.OPT_fprofile_generate_EQ.getValue()))) {
      SmallString/*128*/ Path/*J*/= new SmallString/*128*/(new StringRef(PGOGenerateArg.getValue()), 128);
      path.append(Path, new Twine(/*KEEP_STR*/"default.profraw"));
      CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-fprofile-instrument-path="), new Twine(Path))));
    }
  }
  if ((ProfileUseArg != null)) {
    if (ProfileUseArg.getOption().matches(new OptSpecifier(options.ID.OPT_fprofile_instr_use_EQ.getValue()))) {
      CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-fprofile-instrument-use-path="), new Twine(ProfileUseArg.getValue()))));
    } else if ((ProfileUseArg.getOption().matches(new OptSpecifier(options.ID.OPT_fprofile_use_EQ.getValue()))
       || ProfileUseArg.getOption().matches(new OptSpecifier(options.ID.OPT_fprofile_instr_use.getValue())))) {
      SmallString/*128*/ Path/*J*/= new SmallString/*128*/(new StringRef(ProfileUseArg.getNumValues() == 0 ? $EMPTY : ProfileUseArg.getValue()), 128);
      if (Path.empty() || fs.is_directory(new Twine(Path))) {
        path.append(Path, new Twine(/*KEEP_STR*/"default.profdata"));
      }
      CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-fprofile-instrument-use-path="), new Twine(Path))));
    }
  }
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_ftest_coverage.getValue()))
     || Args.hasArg(new OptSpecifier(options.ID.OPT_coverage.getValue()))) {
    CmdArgs.push_back($("-femit-coverage-notes"));
  }
  if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fprofile_arcs.getValue()), new OptSpecifier(options.ID.OPT_fno_profile_arcs.getValue()), 
      false)
     || Args.hasArg(new OptSpecifier(options.ID.OPT_coverage.getValue()))) {
    CmdArgs.push_back($("-femit-coverage-data"));
  }
  if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fcoverage_mapping.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_coverage_mapping.getValue()), false)
     && !(ProfileGenerateArg != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), 
              /*KEEP_STR*/"-fcoverage-mapping"), 
          /*KEEP_STR*/"-fprofile-instr-generate"));
    } finally {
      $c$.$destroy();
    }
  }
  if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fcoverage_mapping.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_coverage_mapping.getValue()), false)) {
    CmdArgs.push_back($("-fcoverage-mapping"));
  }
  if (C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_c.getValue()))
     || C.getArgs().hasArg(new OptSpecifier(options.ID.OPT_S.getValue()))) {
    if (Output.isFilename()) {
      CmdArgs.push_back($("-coverage-file"));
      SmallString/*128*/ CoverageFilename/*J*/= new SmallString/*128*/(128);
      {
        Arg /*P*/ FinalOutput = C.getArgs().getLastArg(new OptSpecifier(options.ID.OPT_o.getValue()));
        if ((FinalOutput != null)) {
          CoverageFilename.$assign(/*STRINGREF_STR*/FinalOutput.getValue());
        } else {
          CoverageFilename.$assign(path.filename(new StringRef(Output.getBaseInput())));
        }
      }
      if (path.is_relative(new Twine(CoverageFilename))) {
        SmallString/*128*/ Pwd/*J*/= new SmallString/*128*/(128);
        if (!fs.current_path(Pwd).$bool()) {
          path.append(Pwd, new Twine(CoverageFilename));
          CoverageFilename.swap(Pwd);
        }
      }
      CmdArgs.push_back(Args.MakeArgString(new Twine(CoverageFilename)));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="addPS4ProfileRTArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3647,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3238,
 FQN="addPS4ProfileRTArgs", NM="_ZL19addPS4ProfileRTArgsRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19addPS4ProfileRTArgsRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void addPS4ProfileRTArgs(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args, 
                   ArgStringList/*&*/ CmdArgs) {
  if ((Args.hasFlag(new OptSpecifier(options.ID.OPT_fprofile_arcs.getValue()), new OptSpecifier(options.ID.OPT_fno_profile_arcs.getValue()), 
      false)
     || Args.hasFlag(new OptSpecifier(options.ID.OPT_fprofile_generate.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_profile_instr_generate.getValue()), false)
     || Args.hasFlag(new OptSpecifier(options.ID.OPT_fprofile_generate_EQ.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_profile_instr_generate.getValue()), false)
     || Args.hasFlag(new OptSpecifier(options.ID.OPT_fprofile_instr_generate.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_profile_instr_generate.getValue()), false)
     || Args.hasFlag(new OptSpecifier(options.ID.OPT_fprofile_instr_generate_EQ.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_profile_instr_generate.getValue()), false)
     || Args.hasArg(new OptSpecifier(options.ID.OPT_fcreate_profile.getValue()))
     || Args.hasArg(new OptSpecifier(options.ID.OPT_coverage.getValue())))) {
    CmdArgs.push_back($("--dependent-lib=libclang_rt.profile-x86_64.a"));
  }
}


/// Parses the various -fpic/-fPIC/-fpie/-fPIE arguments.  Then,
/// smooshes them together with platform defaults, to decide whether
/// this compile should be using PIC mode or not. Returns a tuple of
/// (RelocationModel, PICLevel, IsPIE).
//<editor-fold defaultstate="collapsed" desc="ParsePICArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3668,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3259,
 FQN="ParsePICArgs", NM="_ZL12ParsePICArgsRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL12ParsePICArgsRKN5clang6driver9ToolChainERKN4llvm6TripleERKNS4_3opt7ArgListE")
//</editor-fold>
public static std.tuple/*<Reloc.Model, uint, boolean>*/ ParsePICArgs(/*const*/ ToolChain /*&*/ ToolChain, /*const*/ Triple /*&*/ _Triple, 
            /*const*/ ArgList /*&*/ Args) {
  // FIXME: why does this code...and so much everywhere else, use both
  // ToolChain.getTriple() and Triple?
  boolean PIE = ToolChain.isPIEDefault();
  boolean PIC = PIE || ToolChain.isPICDefault();
  // The Darwin/MachO default to use PIC does not apply when using -static.
  if (ToolChain.getTriple().isOSBinFormatMachO()
     && Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
    PIE = PIC = false;
  }
  boolean IsPICLevelTwo = PIC;
  
  boolean KernelOrKext = Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()), new OptSpecifier(options.ID.OPT_fapple_kext.getValue()));
  
  // Android-specific defaults for PIC/PIE
  if (ToolChain.getTriple().isAndroid()) {
    switch (ToolChain.getArch()) {
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
     case aarch64:
     case mips:
     case mipsel:
     case mips64:
     case mips64el:
      PIC = true; // "-fpic"
      break;
     case x86:
     case x86_64:
      PIC = true; // "-fPIC"
      IsPICLevelTwo = true;
      break;
     default:
      break;
    }
  }
  
  // OpenBSD-specific defaults for PIE
  if (ToolChain.getTriple().getOS() == Triple.OSType.OpenBSD) {
    switch (ToolChain.getArch()) {
     case mips64:
     case mips64el:
     case sparcel:
     case x86:
     case x86_64:
      IsPICLevelTwo = false; // "-fpie"
      break;
     case ppc:
     case sparc:
     case sparcv9:
      IsPICLevelTwo = true; // "-fPIE"
      break;
     default:
      break;
    }
  }
  
  // The last argument relating to either PIC or PIE wins, and no
  // other argument is used. If the last argument is any flavor of the
  // '-fno-...' arguments, both PIC and PIE are disabled. Any PIE
  // option implicitly enables PIC at the same level.
  Arg /*P*/ LastPICArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_fPIC.getValue()), new OptSpecifier(options.ID.OPT_fno_PIC.getValue()), 
      new OptSpecifier(options.ID.OPT_fpic.getValue()), new OptSpecifier(options.ID.OPT_fno_pic.getValue()), 
      new OptSpecifier(options.ID.OPT_fPIE.getValue()), new OptSpecifier(options.ID.OPT_fno_PIE.getValue()), 
      new OptSpecifier(options.ID.OPT_fpie.getValue()), new OptSpecifier(options.ID.OPT_fno_pie.getValue()));
  // Check whether the tool chain trumps the PIC-ness decision. If the PIC-ness
  // is forced, then neither PIC nor PIE flags will have no effect.
  if (!ToolChain.isPICDefaultForced()) {
    if ((LastPICArg != null)) {
      Option O = new Option(LastPICArg.getOption());
      if (O.matches(new OptSpecifier(options.ID.OPT_fPIC.getValue())) || O.matches(new OptSpecifier(options.ID.OPT_fpic.getValue()))
         || O.matches(new OptSpecifier(options.ID.OPT_fPIE.getValue())) || O.matches(new OptSpecifier(options.ID.OPT_fpie.getValue()))) {
        PIE = O.matches(new OptSpecifier(options.ID.OPT_fPIE.getValue())) || O.matches(new OptSpecifier(options.ID.OPT_fpie.getValue()));
        PIC
           = PIE || O.matches(new OptSpecifier(options.ID.OPT_fPIC.getValue())) || O.matches(new OptSpecifier(options.ID.OPT_fpic.getValue()));
        IsPICLevelTwo
           = O.matches(new OptSpecifier(options.ID.OPT_fPIE.getValue())) || O.matches(new OptSpecifier(options.ID.OPT_fPIC.getValue()));
      } else {
        PIE = PIC = false;
        if (_Triple.isPS4CPU()) {
          Arg /*P*/ ModelArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcmodel_EQ.getValue()));
          StringRef Model = new StringRef((ModelArg != null) ? ModelArg.getValue() : $EMPTY);
          if ($noteq_StringRef(/*NO_COPY*/Model, /*STRINGREF_STR*/"kernel")) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              PIC = true;
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(ToolChain.getDriver().Diag(diag.warn_drv_ps4_force_pic)), 
                  LastPICArg.getSpelling()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  
  // Introduce a Darwin and PS4-specific hack. If the default is PIC, but the
  // PIC level would've been set to level 1, force it back to level 2 PIC
  // instead.
  if (PIC && (ToolChain.getTriple().isOSDarwin() || _Triple.isPS4CPU())) {
    IsPICLevelTwo |= ToolChain.isPICDefault();
  }
  
  // This kernel flags are a trump-card: they will disable PIC/PIE
  // generation, independent of the argument order.
  if (KernelOrKext && ((!_Triple.isiOS() || _Triple.isOSVersionLT(6))
     && !_Triple.isWatchOS())) {
    PIC = PIE = false;
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mdynamic_no_pic.getValue()));
    if ((A != null)) {
      // This is a very special mode. It trumps the other modes, almost no one
      // uses it, and it isn't even valid on any OS but Darwin.
      if (!ToolChain.getTriple().isOSDarwin()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(ToolChain.getDriver().Diag(diag.err_drv_unsupported_opt_for_target)), 
                  A.getSpelling()), new StringRef(ToolChain.getTriple().str())));
        } finally {
          $c$.$destroy();
        }
      }
      
      // FIXME: Warn when this flag trumps some other PIC or PIE flag.
      
      // Only a forced PIC mode can cause the actual compile to have PIC defines
      // etc., no flags are sufficient. This behavior was selected to closely
      // match that of llvm-gcc and Apple GCC before that.
      PIC = ToolChain.isPICDefault() && ToolChain.isPICDefaultForced();
      
      return new std.tuple/*<Reloc.Model, uint, boolean>*/(std.make_tuple(Reloc.Model.DynamicNoPIC, PIC ? 2 : 0, false));
    }
  }
  if (PIC) {
    return new std.tuple/*<Reloc.Model, uint, boolean>*/(std.make_tuple(Reloc.Model.PIC_, IsPICLevelTwo ? 2 : 1, PIE));
  }
  
  return new std.tuple/*<Reloc.Model, uint, boolean>*/(std.make_tuple(Reloc.Model.Static, 0, false));
}

//<editor-fold defaultstate="collapsed" desc="RelocationModelName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3802,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3393,
 FQN="RelocationModelName", NM="_ZL19RelocationModelNameN4llvm5Reloc5ModelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19RelocationModelNameN4llvm5Reloc5ModelE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ RelocationModelName(Reloc.Model Model) {
  switch (Model) {
   case Static:
    return $static;
   case PIC_:
    return $("pic");
   case DynamicNoPIC:
    return $("dynamic-no-pic");
  }
  throw new llvm_unreachable("Unknown Reloc::Model kind");
}

//<editor-fold defaultstate="collapsed" desc="AddAssemblerKPIC">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3814,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3407,
 FQN="AddAssemblerKPIC", NM="_ZL16AddAssemblerKPICRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16AddAssemblerKPICRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void AddAssemblerKPIC(/*const*/ ToolChain /*&*/ ToolChain, /*const*/ ArgList /*&*/ Args, 
                ArgStringList/*&*/ CmdArgs) {
  tuple/*<Reloc.Model, uint, boolean>*/ ParsePICArgs = ParsePICArgs(ToolChain, ToolChain.getTriple(), Args);
  Reloc.Model RelocationModel = (Reloc.Model) ParsePICArgs.$getAt(0);
  /*uint*/int PICLevel = (int) ParsePICArgs.$getAt(1);
  boolean IsPIE = (boolean) ParsePICArgs.$getAt(2);
  // JAVA: decompose above
  // std.tie(RelocationModel, PICLevel, IsPIE).$assign(ParsePICArgs(ToolChain, ToolChain.getTriple(), Args));
  if (RelocationModel != Reloc.Model.Static) {
    CmdArgs.push_back($("-KPIC"));
  }
}

//<editor-fold defaultstate="collapsed" desc="maybeConsumeDash">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6224,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 5706,
 FQN="maybeConsumeDash", NM="_ZL16maybeConsumeDashRKSsRj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL16maybeConsumeDashRKSsRj")
//</editor-fold>
public static boolean maybeConsumeDash(/*const*/std.string/*&*/ EH, uint$ref/*size_t &*/ I) {
  boolean HaveDash = ($less_uint(I.$deref() + 1, EH.size()) && EH.$at(I.$deref() + 1) == $$MINUS);
  I.$set$addassign((HaveDash ? 1 : 0));
  return !HaveDash;
}

// end anonymous namespace

/// /EH controls whether to run destructor cleanups when exceptions are
/// thrown.  There are three modifiers:
/// - s: Cleanup after "synchronous" exceptions, aka C++ exceptions.
/// - a: Cleanup after "asynchronous" exceptions, aka structured exceptions.
///      The 'a' modifier is unimplemented and fundamentally hard in LLVM IR.
/// - c: Assume that extern "C" functions are implicitly nounwind.
/// The default is /EHs-c-, meaning cleanups are disabled.
//<editor-fold defaultstate="collapsed" desc="parseClangCLEHFlags">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6245,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 5729,
 FQN="parseClangCLEHFlags", NM="_ZL19parseClangCLEHFlagsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19parseClangCLEHFlagsRKN5clang6driver6DriverERKN4llvm3opt7ArgListE")
//</editor-fold>
public static EHFlags parseClangCLEHFlags(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args) {
  std.vectorString EHArgs = null;
  try {
    EHFlags EH/*J*/= new EHFlags();
    
    EHArgs = Args.getAllArgValues(new OptSpecifier(options.ID.OPT__SLASH_EH.getValue()));
    for (std.string EHVal : EHArgs) {
//    JAVA: for (/*size_t*/int I = 0, E = EHVal.size(); I != E; ++I) {
      int E = EHVal.size();
      for (/*size_t*/final uint$ref I = create_uint$ref(0); I.$deref() != E; I.$set$preInc()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          switch (EHVal.$at(I.$deref())) {
           case 'a':
            EH.Asynch = maybeConsumeDash(EHVal, I);
            if (EH.Asynch) {
              EH.Synch = false;
            }
            continue;
           case 'c':
            EH.NoUnwindC = maybeConsumeDash(EHVal, I);
            continue;
           case 's':
            EH.Synch = maybeConsumeDash(EHVal, I);
            if (EH.Synch) {
              EH.Asynch = false;
            }
            continue;
           default:
            break;
          }
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_invalid_value)), /*KEEP_STR*/"/EH"), new StringRef(EHVal)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
    // The /GX, /GX- flags are only processed if there are not /EH flags.
    // The default is that /GX is not specified.
    if (EHArgs.empty()
       && Args.hasFlag(new OptSpecifier(options.ID.OPT__SLASH_GX.getValue()), new OptSpecifier(options.ID.OPT__SLASH_GX_.getValue()), 
        /*default=*/ false)) {
      EH.Synch = true;
      EH.NoUnwindC = true;
    }
    
    return EH;
  } finally {
    if (EHArgs != null) { EHArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="constructHexagonLinkArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6889,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6329,
 FQN="constructHexagonLinkArgs", NM="_ZL24constructHexagonLinkArgsRN5clang6driver11CompilationERKNS0_9JobActionERKNS0_10toolchains16HexagonToolChainERKNS0_9InputInfoERKN4llvm11SmallVectorISA_Lj4EEERKNSD_3opt7ArgListERNSE_IPKcLj16EEESN_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL24constructHexagonLinkArgsRN5clang6driver11CompilationERKNS0_9JobActionERKNS0_10toolchains16HexagonToolChainERKNS0_9InputInfoERKN4llvm11SmallVectorISA_Lj4EEERKNSD_3opt7ArgListERNSE_IPKcLj16EEESN_")
//</editor-fold>
public static void constructHexagonLinkArgs(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
                        /*const*/ HexagonToolChain /*&*/ HTC, 
                        /*const*/ InputInfo /*&*/ Output, /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
                        /*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs, 
                        /*const*/char$ptr/*char P*/ LinkingOutput) {
  std.vectorString OsLibs = null;
  try {
    
    /*const*/ Driver /*&*/ D = HTC.getDriver();
    
    //----------------------------------------------------------------------------
    //
    //----------------------------------------------------------------------------
    boolean IsStatic = Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()));
    boolean IsShared = Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()));
    boolean IsPIE = Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()));
    boolean IncStdLib = !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()));
    boolean IncStartFiles = !Args.hasArg(new OptSpecifier(options.ID.OPT_nostartfiles.getValue()));
    boolean IncDefLibs = !Args.hasArg(new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()));
    boolean UseG0 = false;
    boolean UseShared = IsShared && !IsStatic;
    
    //----------------------------------------------------------------------------
    // Silence warnings for various options
    //----------------------------------------------------------------------------
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue())); // Other warning options are already
    // handled somewhere else.
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_static_libgcc.getValue()));
    
    //----------------------------------------------------------------------------
    //
    //----------------------------------------------------------------------------
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_s.getValue()))) {
      CmdArgs.push_back($("-s"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_r.getValue()))) {
      CmdArgs.push_back($("-r"));
    }
    
    for (/*const*/std.string/*&*/ Opt : HTC.ExtraOpts)  {
      CmdArgs.push_back(Opt.c_str());
    }
    
    CmdArgs.push_back($("-march=hexagon"));
    std.string CpuVer = HexagonToolChain.GetTargetCPUVersion(Args).str();
    std.string MCpuString = $add_T_string$C(/*KEEP_STR*/"-mcpu=hexagon", CpuVer);
    CmdArgs.push_back(Args.MakeArgString(new Twine(MCpuString)));
    if (IsShared) {
      CmdArgs.push_back($("-shared"));
      // The following should be the default, but doing as hexagon-gcc does.
      CmdArgs.push_back($("-call_shared"));
    }
    if (IsStatic) {
      CmdArgs.push_back($("-static"));
    }
    if (IsPIE && !IsShared) {
      CmdArgs.push_back($("-pie"));
    }
    {
      
      OptionalUInt G = HexagonToolChain.getSmallDataThreshold(Args);
      if (G.$bool()) {
        std.string N = llvm.utostr($uint2ulong(G.getValue()));
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_string$C(new std.string(/*KEEP_STR*/"-G"), N))));
        UseG0 = G.getValue() == 0;
      }
    }
    
    //----------------------------------------------------------------------------
    //
    //----------------------------------------------------------------------------
    CmdArgs.push_back($("-o"));
    CmdArgs.push_back(Output.getFilename());
    
    //----------------------------------------------------------------------------
    // moslib
    //----------------------------------------------------------------------------
    OsLibs/*J*/= new std.vectorString(std.string.EMPTY);
    boolean HasStandalone = false;
    
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_moslib_EQ.getValue()))) {
      A.claim();
      OsLibs.emplace_back(A.getValue());
      HasStandalone = HasStandalone || ($eq_string$C_T(OsLibs.back(), /*KEEP_STR*/"standalone"));
    }
    if (OsLibs.empty()) {
      OsLibs.push_back(new std.string(/*KEEP_STR*/"standalone"));
      HasStandalone = true;
    }
    
    //----------------------------------------------------------------------------
    // Start Files
    //----------------------------------------------------------------------------
    /*const*/std.string MCpuSuffix = $add_T_string$C(/*KEEP_STR*/"/", CpuVer);
    /*const*/std.string MCpuG0Suffix = $add_string$C_T(MCpuSuffix, /*KEEP_STR*/"/G0");
    /*const*/std.string RootDir = $add_string_T(HTC.getHexagonTargetDir(D.InstalledDir, D.PrefixDirs), /*KEEP_STR*/"/");
    /*const*/std.string StartSubDir = $add_T_string$C(/*KEEP_STR*/"hexagon/lib", (UseG0 ? MCpuG0Suffix : MCpuSuffix));
    
    Find$Lambda Find =  (_RootDir, SubDir, Name) -> 
      {
        std.string RelName = $add_string$C_T(SubDir, Name);
        std.string P = HTC.GetFilePath(RelName.c_str());
        if (fs.exists(new Twine(P))) {
          return P;
        }
        return $add_string$C(_RootDir, RelName);
      }
    ;
    if (IncStdLib && IncStartFiles) {
      if (!IsShared) {
        if (HasStandalone) {
          std.string Crt0SA = Find.$call(RootDir, StartSubDir, /*KEEP_STR*/"/crt0_standalone.o");
          CmdArgs.push_back(Args.MakeArgString(new Twine(Crt0SA)));
        }
        std.string Crt0 = Find.$call(RootDir, StartSubDir, /*KEEP_STR*/"/crt0.o");
        CmdArgs.push_back(Args.MakeArgString(new Twine(Crt0)));
      }
      std.string Init = UseShared ? Find.$call(RootDir, $add_string$C_T(StartSubDir, /*KEEP_STR*/"/pic"), /*KEEP_STR*/"/initS.o") : Find.$call(RootDir, StartSubDir, /*KEEP_STR*/"/init.o");
      CmdArgs.push_back(Args.MakeArgString(new Twine(Init)));
    }
    
    //----------------------------------------------------------------------------
    // Library Search Paths
    //----------------------------------------------------------------------------
    /*const*/SmallVector<std.string> /*&*/ LibPaths = HTC.getFilePaths();
    for (/*const*/std.string/*&*/ LibPath : LibPaths)  {
      CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*STRINGREF_STR*/"-L"), new Twine(LibPath))));
    }
    
    //----------------------------------------------------------------------------
    //
    //----------------------------------------------------------------------------
    Args.AddAllArgs(CmdArgs, 
        /*{ */new ArrayRef<OptSpecifier>($IDsToOptSpecifiers(new /*const*/ options.ID [/*5*/] {
              options.ID.OPT_T_Group, options.ID.OPT_e, options.ID.OPT_s,
              options.ID.OPT_t, options.ID.OPT_u_Group}))/* }*/);
    
    AddLinkerInputs(HTC, Inputs, Args, CmdArgs);
    
    //----------------------------------------------------------------------------
    // Libraries
    //----------------------------------------------------------------------------
    if (IncStdLib && IncDefLibs) {
      if (D.CCCIsCXX()) {
        HTC.AddCXXStdlibLibArgs(Args, CmdArgs);
        CmdArgs.push_back($("-lm"));
      }
      
      CmdArgs.push_back($("--start-group"));
      if (!IsShared) {
        for (/*const*/std.string/*&*/ Lib : OsLibs)  {
          CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string$C(/*KEEP_STR*/"-l", Lib))));
        }
        CmdArgs.push_back($("-lc"));
      }
      CmdArgs.push_back($("-lgcc"));
      
      CmdArgs.push_back($("--end-group"));
    }
    
    //----------------------------------------------------------------------------
    // End files
    //----------------------------------------------------------------------------
    if (IncStdLib && IncStartFiles) {
      std.string Fini = UseShared ? Find.$call(RootDir, $add_string$C_T(StartSubDir, /*KEEP_STR*/"/pic"), /*KEEP_STR*/"/finiS.o") : Find.$call(RootDir, StartSubDir, /*KEEP_STR*/"/fini.o");
      CmdArgs.push_back(Args.MakeArgString(new Twine(Fini)));
    }
  } finally {
    if (OsLibs != null) { OsLibs.$destroy(); }
  }
}

  @FunctionalInterface
  interface Find$Lambda {
    default std.string $call(/*const*/ std.string /*&*/RootDir, /*const*/ std.string /*&*/SubDir, /*const char **/ String Name) {
      return $call(RootDir, SubDir, $(Name));
    }
    std.string $call(/*const*/ std.string /*&*/RootDir, /*const*/ std.string /*&*/SubDir, /*const char **/ char$ptr Name);
  }
    
//<editor-fold defaultstate="collapsed" desc="AddLibgcc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9229,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 8592,
 FQN="AddLibgcc", NM="_ZL9AddLibgccRKN4llvm6TripleERKN5clang6driver6DriverERNS_11SmallVectorIPKcLj16EEERKNS_3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL9AddLibgccRKN4llvm6TripleERKN5clang6driver6DriverERNS_11SmallVectorIPKcLj16EEERKNS_3opt7ArgListE")
//</editor-fold>
public static void AddLibgcc(/*const*/ Triple /*&*/ Triple, /*const*/ Driver /*&*/ D, 
         ArgStringList/*&*/ CmdArgs, /*const*/ ArgList /*&*/ Args) {
  boolean isAndroid = Triple.isAndroid();
  boolean isCygMing = Triple.isOSCygMing();
  boolean IsIAMCU = Triple.isOSIAMCU();
  boolean StaticLibgcc = Args.hasArg(new OptSpecifier(options.ID.OPT_static_libgcc.getValue()))
     || Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()));
  if (!D.CCCIsCXX()) {
    CmdArgs.push_back($("-lgcc"));
  }
  if (StaticLibgcc || isAndroid) {
    if (D.CCCIsCXX()) {
      CmdArgs.push_back($("-lgcc"));
    }
  } else {
    if (!D.CCCIsCXX() && !isCygMing) {
      CmdArgs.push_back($("--as-needed"));
    }
    CmdArgs.push_back($("-lgcc_s"));
    if (!D.CCCIsCXX() && !isCygMing) {
      CmdArgs.push_back($("--no-as-needed"));
    }
  }
  if (StaticLibgcc && !isAndroid && !IsIAMCU) {
    CmdArgs.push_back($("-lgcc_eh"));
  } else if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) && D.CCCIsCXX()) {
    CmdArgs.push_back($("-lgcc"));
  }
  
  // According to Android ABI, we have to link with libdl if we are
  // linking with non-static libgcc.
  //
  // NOTE: This fixes a link error on Android MIPS as well.  The non-static
  // libgcc for MIPS relies on _Unwind_Find_FDE and dl_iterate_phdr from libdl.
  if (isAndroid && !StaticLibgcc) {
    CmdArgs.push_back($("-ldl"));
  }
}

//<editor-fold defaultstate="collapsed" desc="AddRunTimeLibs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9264,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 8692,
 FQN="AddRunTimeLibs", NM="_ZL14AddRunTimeLibsRKN5clang6driver9ToolChainERKNS0_6DriverERN4llvm11SmallVectorIPKcLj16EEERKNS7_3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL14AddRunTimeLibsRKN5clang6driver9ToolChainERKNS0_6DriverERN4llvm11SmallVectorIPKcLj16EEERKNS7_3opt7ArgListE")
//</editor-fold>
public static void AddRunTimeLibs(/*const*/ ToolChain /*&*/ TC, /*const*/ Driver /*&*/ D, 
              ArgStringList/*&*/ CmdArgs, /*const*/ ArgList /*&*/ Args) {
  // Make use of compiler-rt if --rtlib option is used
  ToolChain.RuntimeLibType RLT = TC.GetRuntimeLibType(Args);
  switch (RLT) {
   case RLT_CompilerRT:
    switch (TC.getTriple().getOS()) {
     default:
      throw new llvm_unreachable("unsupported OS");
     case Win32:
     case Linux:
      addClangRT(TC, Args, CmdArgs);
      break;
    }
    break;
   case RLT_Libgcc:
    // Make sure libgcc is not used under MSVC environment by default
    if (TC.getTriple().isKnownWindowsMSVCEnvironment()) {
      // Issue error diagnostic if libgcc is explicitly specified
      // through command line as --rtlib option argument.
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_rtlib_EQ.getValue()))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(TC.getDriver().Diag(diag.err_drv_unsupported_rtlib_for_platform)), 
                  Args.getLastArg(new OptSpecifier(options.ID.OPT_rtlib_EQ.getValue())).getValue()), /*KEEP_STR*/"MSVC"));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      AddLibgcc(TC.getTriple(), D, CmdArgs, Args);
    }
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="getLDMOption">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9295,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 8714,
 FQN="getLDMOption", NM="_ZL12getLDMOptionRKN4llvm6TripleERKNS_3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL12getLDMOptionRKN4llvm6TripleERKNS_3opt7ArgListE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getLDMOption(/*const*/ Triple /*&*/ T, /*const*/ ArgList /*&*/ Args) {
  switch (T.getArch()) {
   case x86:
    if (T.isOSIAMCU()) {
      return $("elf_iamcu");
    }
    return $("elf_i386");
   case aarch64:
    return $("aarch64linux");
   case aarch64_be:
    return $("aarch64_be_linux");
   case arm:
   case thumb:
    return $("armelf_linux_eabi");
   case armeb:
   case thumbeb:
    return $("armelfb_linux_eabi");
   case ppc:
    return $("elf32ppclinux");
   case ppc64:
    return $("elf64ppc");
   case ppc64le:
    return $("elf64lppc");
   case sparc:
   case sparcel:
    return $("elf32_sparc");
   case sparcv9:
    return $("elf64_sparc");
   case mips:
    return $("elf32btsmip");
   case mipsel:
    return $("elf32ltsmip");
   case mips64:
    if (MipsStatics.hasMipsAbiArg(Args, $("n32"))) {
      return $("elf32btsmipn32");
    }
    return $("elf64btsmip");
   case mips64el:
    if (MipsStatics.hasMipsAbiArg(Args, $("n32"))) {
      return $("elf32ltsmipn32");
    }
    return $("elf64ltsmip");
   case systemz:
    return $("elf64_s390");
   case x86_64:
    if (T.getEnvironment() == Triple.EnvironmentType.GNUX32) {
      return $("elf32_x86_64");
    }
    return $("elf_x86_64");
   default:
    throw new llvm_unreachable("Unexpected arch");
  }
}


// Try to find Exe from a Visual Studio distribution.  This first tries to find
// an installed copy of Visual Studio and, failing that, looks in the PATH,
// making sure that whatever executable that's found is not a same-named exe
// from clang itself to prevent clang from falling back to itself.
//<editor-fold defaultstate="collapsed" desc="FindVisualStudioExecutable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9990,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9381,
 FQN="FindVisualStudioExecutable", NM="_ZL26FindVisualStudioExecutableRKN5clang6driver9ToolChainEPKcS5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL26FindVisualStudioExecutableRKN5clang6driver9ToolChainEPKcS5_")
//</editor-fold>
public static std.string FindVisualStudioExecutable(/*const*/ ToolChain /*&*/ TC, 
                          /*const*/char$ptr/*char P*/ Exe, 
                          /*const*/char$ptr/*char P*/ ClangProgramPath) {
  /*const*/ MSVCToolChain /*&*/ MSVC = ((/*static_cast*//*const*/ MSVCToolChain /*&*/ )(TC));
  std.string visualStudioBinDir/*J*/= new std.string();
  if (MSVC.getVisualStudioBinariesFolder(ClangProgramPath, 
      visualStudioBinDir)) {
    SmallString/*128*/ FilePath/*J*/= new SmallString/*128*/(new StringRef(visualStudioBinDir), 128);
    path.append(FilePath, new Twine(Exe));
    if (fs.can_execute(new Twine(FilePath.c_str()))) {
      return FilePath.str().$string();
    }
  }
  
  return new std.string(Exe);
}

//<editor-fold defaultstate="collapsed" desc="AddPS4SanitizerArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10967,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 10333,
 FQN="AddPS4SanitizerArgs", NM="_ZL19AddPS4SanitizerArgsRKN5clang6driver9ToolChainERN4llvm11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19AddPS4SanitizerArgsRKN5clang6driver9ToolChainERN4llvm11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static void AddPS4SanitizerArgs(/*const*/ ToolChain /*&*/ TC, ArgStringList/*&*/ CmdArgs) {
  /*const*/ SanitizerArgs /*&*/ SanArgs = TC.getSanitizerArgs();
  if (SanArgs.needsUbsanRt()) {
    CmdArgs.push_back($("-lSceDbgUBSanitizer_stub_weak"));
  }
  if (SanArgs.needsAsanRt()) {
    CmdArgs.push_back($("-lSceDbgAddressSanitizer_stub_weak"));
  }
}

//<editor-fold defaultstate="collapsed" desc="ConstructPS4LinkJob">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10977,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 10343,
 FQN="ConstructPS4LinkJob", NM="_ZL19ConstructPS4LinkJobRKN5clang6driver4ToolERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL19ConstructPS4LinkJobRKN5clang6driver4ToolERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
//</editor-fold>
public static void ConstructPS4LinkJob(/*const*/ Tool /*&*/ T, Compilation /*&*/ C, 
                   /*const*/ JobAction /*&*/ JA, /*const*/ InputInfo /*&*/ Output, 
                   /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
                   /*const*/ ArgList /*&*/ Args, 
                   /*const*/char$ptr/*char P*/ LinkingOutput) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ToolChain tmp = T.getToolChain();
    FreeBSD /*&*/ ToolChain;
    if (tmp instanceof FreeBSD) {
      ToolChain = (FreeBSD) tmp;
    } else {
      ToolChain = new FreeBSD(tmp.getDriver(), tmp.getTriple(), tmp.Args);
    }
    ///*const*/ FreeBSD /*&*/ ToolChain = ((/*static_cast*//*const*/ FreeBSD /*&*/ )(T.getToolChain()));
    /*const*/ Driver /*&*/ D = ToolChain.getDriver();
    ArgStringList CmdArgs/*J*/= new ArgStringList();
    
    // Silence warning for "clang -g foo.o -o foo"
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
    // and "clang -emit-llvm foo.o -o foo"
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
    // and for "clang -w foo.o -o foo". Other warning options are already
    // handled somewhere else.
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
    if (!D.SysRoot.empty()) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
      CmdArgs.push_back($("-pie"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
      CmdArgs.push_back($("-export-dynamic"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
      CmdArgs.push_back($("--oformat=so"));
    }
    if (Output.isFilename()) {
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
    } else {
      assert (Output.isNothing()) : "Invalid output.";
    }
    
    AddPS4SanitizerArgs(ToolChain, CmdArgs);
    
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_T_Group.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_e.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_s.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_t.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_r.getValue()));
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_Z_Xlinker__no_demangle.getValue()))) {
      CmdArgs.push_back($("--no-demangle"));
    }
    
    AddLinkerInputs(ToolChain, Inputs, Args, CmdArgs);
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))) {
      CmdArgs.push_back($("-lpthread"));
    }
    
    /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(ToolChain.GetProgramPath($("orbis-ld")))));
    
    C.addCommand($c$.track(llvm.make_unique(new Command(JA, T, Exec, CmdArgs, Inputs)))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="ConstructGoldLinkJob">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 11036,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 10402,
 FQN="ConstructGoldLinkJob", NM="_ZL20ConstructGoldLinkJobRKN5clang6driver4ToolERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZL20ConstructGoldLinkJobRKN5clang6driver4ToolERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
//</editor-fold>
public static void ConstructGoldLinkJob(/*const*/ Tool /*&*/ T, Compilation /*&*/ C, 
                    /*const*/ JobAction /*&*/ JA, /*const*/ InputInfo /*&*/ Output, 
                    /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
                    /*const*/ ArgList /*&*/ Args, 
                    /*const*/char$ptr/*char P*/ LinkingOutput) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ToolChain tmp = T.getToolChain();
    FreeBSD /*&*/ ToolChain;
    if (tmp instanceof FreeBSD) {
      ToolChain = (FreeBSD) tmp;
    } else {
      ToolChain = new FreeBSD(tmp.getDriver(), tmp.getTriple(), tmp.Args);
    }
    ///*const*/ FreeBSD /*&*/ ToolChain = ((/*static_cast*//*const*/ FreeBSD /*&*/ )(T.getToolChain()));
    /*const*/ Driver /*&*/ D = ToolChain.getDriver();
    ArgStringList CmdArgs/*J*/= new ArgStringList();
    
    // Silence warning for "clang -g foo.o -o foo"
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
    // and "clang -emit-llvm foo.o -o foo"
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
    // and for "clang -w foo.o -o foo". Other warning options are already
    // handled somewhere else.
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
    if (!D.SysRoot.empty()) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
      CmdArgs.push_back($("-pie"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
      CmdArgs.push_back($("-Bstatic"));
    } else {
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
        CmdArgs.push_back($("-export-dynamic"));
      }
      CmdArgs.push_back($("--eh-frame-hdr"));
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
        CmdArgs.push_back($("-Bshareable"));
      } else {
        CmdArgs.push_back($("-dynamic-linker"));
        CmdArgs.push_back($("/libexec/ld-elf.so.1"));
      }
      CmdArgs.push_back($("--enable-new-dtags"));
    }
    if (Output.isFilename()) {
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
    } else {
      assert (Output.isNothing()) : "Invalid output.";
    }
    
    AddPS4SanitizerArgs(ToolChain, CmdArgs);
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
      /*const*/char$ptr/*char P*/ crt1 = null;
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
          crt1 = $tryClone($("gcrt1.o"));
        } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
          crt1 = $tryClone($("Scrt1.o"));
        } else {
          crt1 = $tryClone($("crt1.o"));
        }
      }
      if ((crt1 != null)) {
        CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crt1))));
      }
      
      CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crti.o")))));
      
      /*const*/char$ptr/*char P*/ crtbegin = null;
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        crtbegin = $tryClone($("crtbeginT.o"));
      } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
        crtbegin = $tryClone($("crtbeginS.o"));
      } else {
        crtbegin = $tryClone($("crtbegin.o"));
      }
      
      CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crtbegin))));
    }
    
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
    ToolChain.AddFilePathLibArgs(Args, CmdArgs);
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_T_Group.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_e.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_s.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_t.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_r.getValue()));
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_Z_Xlinker__no_demangle.getValue()))) {
      CmdArgs.push_back($("--no-demangle"));
    }
    
    AddLinkerInputs(ToolChain, Inputs, Args, CmdArgs);
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
      // For PS4, we always want to pass libm, libstdc++ and libkernel
      // libraries for both C and C++ compilations.
      CmdArgs.push_back($("-lkernel"));
      if (D.CCCIsCXX()) {
        ToolChain.AddCXXStdlibLibArgs(Args, CmdArgs);
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
          CmdArgs.push_back($("-lm_p"));
        } else {
          CmdArgs.push_back($("-lm"));
        }
      }
      // FIXME: For some reason GCC passes -lgcc and -lgcc_s before adding
      // the default system libraries. Just mimic this for now.
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
        CmdArgs.push_back($("-lgcc_p"));
      } else {
        CmdArgs.push_back($("-lcompiler_rt"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        CmdArgs.push_back($("-lstdc++"));
      } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
        CmdArgs.push_back($("-lgcc_eh_p"));
      } else {
        CmdArgs.push_back($("--as-needed"));
        CmdArgs.push_back($("-lstdc++"));
        CmdArgs.push_back($("--no-as-needed"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
          CmdArgs.push_back($("-lpthread_p"));
        } else {
          CmdArgs.push_back($("-lpthread"));
        }
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back($("-lc"));
        } else {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
            CmdArgs.push_back($("--start-group"));
            CmdArgs.push_back($("-lc_p"));
            CmdArgs.push_back($("-lpthread_p"));
            CmdArgs.push_back($("--end-group"));
          } else {
            CmdArgs.push_back($("-lc_p"));
          }
        }
        CmdArgs.push_back($("-lgcc_p"));
      } else {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
          CmdArgs.push_back($("--start-group"));
          CmdArgs.push_back($("-lc"));
          CmdArgs.push_back($("-lpthread"));
          CmdArgs.push_back($("--end-group"));
        } else {
          CmdArgs.push_back($("-lc"));
        }
        CmdArgs.push_back($("-lcompiler_rt"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        CmdArgs.push_back($("-lstdc++"));
      } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
        CmdArgs.push_back($("-lgcc_eh_p"));
      } else {
        CmdArgs.push_back($("--as-needed"));
        CmdArgs.push_back($("-lstdc++"));
        CmdArgs.push_back($("--no-as-needed"));
      }
    }
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
        CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crtendS.o")))));
      } else {
        CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crtend.o")))));
      }
      CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crtn.o")))));
    }
    
    /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(ToolChain.GetProgramPath($("orbis-ld")))));
    
    C.addCommand($c$.track(llvm.make_unique(new Command(JA, T, Exec, CmdArgs, Inputs)))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

} // END OF class ToolsStatics
