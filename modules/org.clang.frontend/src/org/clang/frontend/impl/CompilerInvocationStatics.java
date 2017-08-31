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
package org.clang.frontend.impl;

import org.clang.driver.frontend.CodeGenOptions;
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
import org.llvm.support.Error;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import org.llvm.option.*;
import org.clang.lex.*;
import org.clang.lex.frontend.*;
import org.clang.serialization.*;
import static org.clang.frontend.impl.CompilerInvocationStatics.*;
import org.clang.frontend.*;
import org.clang.driver.options;
import org.clang.driver.options.ID;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;
import org.clang.frontend.frontend.ActionKind;
import org.clang.frontend.staticanalyzer.*;
import org.llvm.linker.Linker;
import org.llvm.profiledata.IndexedInstrProfReader;
import org.llvm.target.target.*;
import org.llvm.target.target.DebuggerKind;
import org.llvm.support.sys.Process;
import org.clang.basic.target.TargetOptions;


//<editor-fold defaultstate="collapsed" desc="static type CompilerInvocationStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.frontend.impl.CompilerInvocationStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_Z8isOpenCLN5clang12LangStandard4KindE;_ZL12getCodeModelRN4llvm3opt7ArgListERN5clang17DiagnosticsEngineE;_ZL13ParseLangArgsRN5clang11LangOptionsERN4llvm3opt7ArgListENS_9InputKindERKNS_13TargetOptionsERNS_19PreprocessorOptionsERNS_17DiagnosticsEngineE;_ZL15ParseTargetArgsRN5clang13TargetOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE;_ZL15parseVisibilityPN4llvm3opt3ArgERNS0_7ArgListERN5clang17DiagnosticsEngineE;_ZL16ParseCodeGenArgsRN5clang14CodeGenOptionsERN4llvm3opt7ArgListENS_9InputKindERNS_17DiagnosticsEngineERKNS_13TargetOptionsE;_ZL16ParseCommentArgsRN5clang14CommentOptionsERN4llvm3opt7ArgListE;_ZL17ParseAnalyzerArgsRN5clang15AnalyzerOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE;_ZL17ParseFrontendArgsRN5clang15FrontendOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE;_ZL17ParseMigratorArgsRN5clang15MigratorOptionsERN4llvm3opt7ArgListE;_ZL17addDiagnosticArgsRN4llvm3opt7ArgListENS0_12OptSpecifierES3_RSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaISA_EE;_ZL18setPGOInstrumentorRN5clang14CodeGenOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE;_ZL19ParseFileSystemArgsRN5clang17FileSystemOptionsERN4llvm3opt7ArgListE;_ZL19parseSanitizerKindsN4llvm9StringRefERKSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS7_EERN5clang17DiagnosticsEngineERNSC_12SanitizerSetE;_ZL19parseShowColorsArgsRKN4llvm3opt7ArgListEb;_ZL20getOptimizationLevelRN4llvm3opt7ArgListEN5clang9InputKindERNS3_17DiagnosticsEngineE;_ZL21ParseHeaderSearchArgsRN5clang19HeaderSearchOptionsERN4llvm3opt7ArgListE;_ZL21ParsePreprocessorArgsRN5clang19PreprocessorOptionsERN4llvm3opt7ArgListERNS_11FileManagerERNS_17DiagnosticsEngineE;_ZL21setPGOUseInstrumentorRN5clang14CodeGenOptionsERKN4llvm5TwineE;_ZL24getOptimizationLevelSizeRN4llvm3opt7ArgListE;_ZL24parseDiagnosticLevelMaskN4llvm9StringRefERKSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS7_EEPN5clang17DiagnosticsEngineERNSC_19DiagnosticLevelMaskE;_ZL25ParseDependencyOutputArgsRN5clang23DependencyOutputOptionsERN4llvm3opt7ArgListE;_ZL25getAllNoBuiltinFuncValuesRN4llvm3opt7ArgListERSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS9_EE;_ZL27ParsePreprocessorOutputArgsRN5clang25PreprocessorOutputOptionsERN4llvm3opt7ArgListENS_8frontend10ActionKindE;_ZL31GenerateOptimizationRemarkRegexRN5clang17DiagnosticsEngineERN4llvm3opt7ArgListEPNS3_3ArgE;_ZL31parseTestModuleFileExtensionArgN4llvm9StringRefERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERjS8_RbS7_; -static-type=CompilerInvocationStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class CompilerInvocationStatics {


//
//<editor-fold defaultstate="collapsed" desc="getOptimizationLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 81,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 79,
 FQN="getOptimizationLevel", NM="_ZL20getOptimizationLevelRN4llvm3opt7ArgListEN5clang9InputKindERNS3_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL20getOptimizationLevelRN4llvm3opt7ArgListEN5clang9InputKindERNS3_17DiagnosticsEngineE")
//</editor-fold>
public static /*uint*/int getOptimizationLevel(final ArgList /*&*/ Args, InputKind IK, 
                    final DiagnosticsEngine /*&*/ Diags) {
  /*uint*/int DefaultOpt = 0;
  if (IK == InputKind.IK_OpenCL && !Args.hasArg(new OptSpecifier(ID.OPT_cl_opt_disable.getValue()))) {
    DefaultOpt = 2;
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O_Group.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O0.getValue()))) {
        return 0;
      }
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_Ofast.getValue()))) {
        return 3;
      }
      assert (A.getOption().matches(new OptSpecifier(options.ID.OPT_O.getValue())));
      
      StringRef S/*J*/= new StringRef(A.getValue());
      if ($eq_StringRef(/*NO_COPY*/S, /*STRINGREF_STR*/"s") || $eq_StringRef(/*NO_COPY*/S, /*STRINGREF_STR*/"z") || S.empty()) {
        return 2;
      }
      
      return getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_O.getValue()), DefaultOpt, Diags);
    }
  }
  
  return DefaultOpt;
}

//<editor-fold defaultstate="collapsed" desc="getOptimizationLevelSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 106,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 104,
 FQN="getOptimizationLevelSize", NM="_ZL24getOptimizationLevelSizeRN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL24getOptimizationLevelSizeRN4llvm3opt7ArgListE")
//</editor-fold>
public static /*uint*/int getOptimizationLevelSize(final ArgList /*&*/ Args) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O_Group.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O.getValue()))) {
        switch (A.getValue().$at(0)) {
         default:
          return 0;
         case 's':
          return 1;
         case 'z':
          return 2;
        }
      }
    }
  }
  return 0;
}

//<editor-fold defaultstate="collapsed" desc="addDiagnosticArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 122,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 120,
 FQN="addDiagnosticArgs", NM="_ZL17addDiagnosticArgsRN4llvm3opt7ArgListENS0_12OptSpecifierES3_RSt6vectorISsSaISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL17addDiagnosticArgsRN4llvm3opt7ArgListENS0_12OptSpecifierES3_RSt6vectorISsSaISsEE")
//</editor-fold>
public static void addDiagnosticArgs(final ArgList /*&*/ Args, OptSpecifier Group, 
                 OptSpecifier GroupWithValue, 
                 final std.vectorString/*&*/ Diagnostics) {
  for (Arg /*P*/ A : Args.filtered(/*NO_COPY*/Group)) {
    if (A.getOption().getKind() == Option.OptionClass.FlagClass) {
      // The argument is a pure flag (such as OPT_Wall or OPT_Wdeprecated). Add
      // its name (minus the "W" or "R" at the beginning) to the warning list.
      Diagnostics.push_back_T$RR(A.getOption().getName().drop_front(1).$string());
    } else if (A.getOption().matches(/*NO_COPY*/GroupWithValue)) {
      // This is -Wfoo= or -Rfoo=, where foo is the name of the diagnostic group.
      Diagnostics.push_back_T$RR(A.getOption().getName().drop_front(1).rtrim(/*STRINGREF_STR*/"=-").$string());
    } else {
      // Otherwise, add its value (for OPT_W_Joined and similar).
      for (/*const*/char$ptr/*char P*/ Arg : A.getValues())  {
        Diagnostics.emplace_back(Arg);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getAllNoBuiltinFuncValues">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 141,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 139,
 FQN="getAllNoBuiltinFuncValues", NM="_ZL25getAllNoBuiltinFuncValuesRN4llvm3opt7ArgListERSt6vectorISsSaISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL25getAllNoBuiltinFuncValuesRN4llvm3opt7ArgListERSt6vectorISsSaISsEE")
//</editor-fold>
public static void getAllNoBuiltinFuncValues(final ArgList /*&*/ Args, 
                         final std.vectorString/*&*/ Funcs) {
  SmallVector</*const*/char$ptr/*char P*//*,  8*/> Values/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  8*/>(8, null);
  for (final Arg /*P*/ /*const*/ /*&*/ $Arg : Args) {
    final /*const*/ Option /*&*/ O = $Arg.getOption();
    if (O.matches(new OptSpecifier(options.ID.OPT_fno_builtin_.getValue()))) {
      /*const*/char$ptr/*char P*/ FuncName = $tryClone($Arg.getValue());
      if (Builtin.Context.isBuiltinFunc(FuncName)) {
        Values.push_back(FuncName);
      }
    }
  }
  Funcs.insertChar$ptrs(Funcs.end(), Values.begin(), Values.end());
}

//<editor-fold defaultstate="collapsed" desc="ParseAnalyzerArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*unfold tie*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 155,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 153,
 FQN="ParseAnalyzerArgs", NM="_ZL17ParseAnalyzerArgsRN5clang15AnalyzerOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL17ParseAnalyzerArgsRN5clang15AnalyzerOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE")
//</editor-fold>
public static boolean ParseAnalyzerArgs(final AnalyzerOptions /*&*/ Opts, final ArgList /*&*/ Args, 
                 final DiagnosticsEngine /*&*/ Diags) {
  //JAVA: using namespace options;
  boolean Success = true;
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_analyzer_store.getValue()));
    if ((A != null)) {
      StringRef Name = new StringRef(A.getValue());
      AnalysisStores Value = new StringSwitch<AnalysisStores>(/*NO_COPY*/Name).Case(/*KEEP_STR*/"region", AnalysisStores.RegionStoreModel).
          Default(AnalysisStores.NumStores);
      if (Value == AnalysisStores.NumStores) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), /*NO_COPY*/Name));
          Success = false;
        } finally {
          $c$.$destroy();
        }
      } else {
        Opts.AnalysisStoreOpt = Value;
      }
    }
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_analyzer_constraints.getValue()));
    if ((A != null)) {
      StringRef Name = new StringRef(A.getValue());
      AnalysisConstraints Value = new StringSwitch<AnalysisConstraints>(/*NO_COPY*/Name).Case(/*KEEP_STR*/"range", AnalysisConstraints.RangeConstraintsModel).
          Default(AnalysisConstraints.NumConstraints);
      if (Value == AnalysisConstraints.NumConstraints) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), /*NO_COPY*/Name));
          Success = false;
        } finally {
          $c$.$destroy();
        }
      } else {
        Opts.AnalysisConstraintsOpt = Value;
      }
    }
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_analyzer_output.getValue()));
    if ((A != null)) {
      StringRef Name = new StringRef(A.getValue());
      AnalysisDiagClients Value = new StringSwitch<AnalysisDiagClients>(/*NO_COPY*/Name).Case(/*KEEP_STR*/"html", AnalysisDiagClients.PD_HTML).
          Case(/*KEEP_STR*/"plist", AnalysisDiagClients.PD_PLIST).
          Case(/*KEEP_STR*/"plist-multi-file", AnalysisDiagClients.PD_PLIST_MULTI_FILE).
          Case(/*KEEP_STR*/"plist-html", AnalysisDiagClients.PD_PLIST_HTML).
          Case(/*KEEP_STR*/"text", AnalysisDiagClients.PD_TEXT).
          Default(AnalysisDiagClients.NUM_ANALYSIS_DIAG_CLIENTS);
      if (Value == AnalysisDiagClients.NUM_ANALYSIS_DIAG_CLIENTS) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), /*NO_COPY*/Name));
          Success = false;
        } finally {
          $c$.$destroy();
        }
      } else {
        Opts.AnalysisDiagOpt = Value;
      }
    }
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_analyzer_purge.getValue()));
    if ((A != null)) {
      StringRef Name = new StringRef(A.getValue());
      AnalysisPurgeMode Value = new StringSwitch<AnalysisPurgeMode>(/*NO_COPY*/Name).Case(/*KEEP_STR*/"statement", AnalysisPurgeMode.PurgeStmt).
          Case(/*KEEP_STR*/"block", AnalysisPurgeMode.PurgeBlock).
          Case(/*KEEP_STR*/"none", AnalysisPurgeMode.PurgeNone).
          Default(AnalysisPurgeMode.NumPurgeModes);
      if (Value == AnalysisPurgeMode.NumPurgeModes) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), /*NO_COPY*/Name));
          Success = false;
        } finally {
          $c$.$destroy();
        }
      } else {
        Opts.AnalysisPurgeOpt = Value;
      }
    }
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_analyzer_inlining_mode.getValue()));
    if ((A != null)) {
      StringRef Name = new StringRef(A.getValue());
      AnalysisInliningMode Value = new StringSwitch<AnalysisInliningMode>(/*NO_COPY*/Name).Case(/*KEEP_STR*/"all", AnalysisInliningMode.All).
          Case(/*KEEP_STR*/"noredundancy", AnalysisInliningMode.NoRedundancy).
          Default(AnalysisInliningMode.NumInliningModes);
      if (Value == AnalysisInliningMode.NumInliningModes) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), /*NO_COPY*/Name));
          Success = false;
        } finally {
          $c$.$destroy();
        }
      } else {
        Opts.InliningMode = Value;
      }
    }
  }
  
  Opts.ShowCheckerHelp = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_checker_help.getValue()));
  Opts.DisableAllChecks = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_disable_all_checks.getValue()));
  
  Opts.visualizeExplodedGraphWithGraphViz
     = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_viz_egraph_graphviz.getValue()));
  Opts.visualizeExplodedGraphWithUbiGraph
     = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_viz_egraph_ubigraph.getValue()));
  Opts.NoRetryExhausted = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_disable_retry_exhausted.getValue()));
  Opts.AnalyzeAll = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_opt_analyze_headers.getValue()));
  Opts.AnalyzerDisplayProgress = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_display_progress.getValue()));
  Opts.AnalyzeNestedBlocks
     = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_opt_analyze_nested_blocks.getValue()));
  Opts.eagerlyAssumeBinOpBifurcation = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_eagerly_assume.getValue()));
  Opts.AnalyzeSpecificFunction.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_analyze_function.getValue())).$string());
  Opts.UnoptimizedCFG = Args.hasArg(new OptSpecifier(ID.OPT_analysis_UnoptimizedCFG.getValue()));
  Opts.TrimGraph = Args.hasArg(new OptSpecifier(ID.OPT_trim_egraph.getValue()));
  Opts.maxBlockVisitOnPath
     = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_analyzer_max_loop.getValue()), 4, Diags);
  Opts.PrintStats = Args.hasArg(new OptSpecifier(ID.OPT_analyzer_stats.getValue()));
  Opts.InlineMaxStackDepth
     = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_analyzer_inline_max_stack_depth.getValue()), 
      Opts.InlineMaxStackDepth, Diags);
  
  Opts.CheckersControlList.clear();
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_analyzer_checker.getValue()), new OptSpecifier(ID.OPT_analyzer_disable_checker.getValue()))) {
    A.claim();
    boolean enable = (A.getOption().getID() == ID.OPT_analyzer_checker.getValue());
    // We can have a list of comma separated checker names, e.g:
    // '-analyzer-checker=cocoa,unix'
    StringRef checkerList = new StringRef(A.getValue());
    SmallVector<StringRef> checkers/*J*/= new SmallVector<StringRef>(4, new StringRef());
    checkerList.split(checkers, /*STRINGREF_STR*/",");
    for (StringRef checker : checkers)  {
      Opts.CheckersControlList.emplace_back(std.make_pair_T_bool(checker.str(), enable));
    }
  }
  
  // Go through the analyzer configuration options.
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_analyzer_config.getValue()))) {
    A.claim();
    // We can have a list of comma separated config names, e.g:
    // '-analyzer-config key1=val1,key2=val2'
    StringRef configList = new StringRef(A.getValue());
    SmallVector<StringRef> configVals/*J*/= new SmallVector<StringRef>(4, new StringRef());
    configList.split(configVals, /*STRINGREF_STR*/",");
    for (/*uint*/int i = 0, e = configVals.size(); i != e; ++i) {
      // JAVA: unfold tie
      pair<StringRef, StringRef> $split = configVals.$at(i).split(/*STRINGREF_STR*/"=");
      StringRef key/*J*/= $split.first, val/*J*/= $split.second;
//      std.tie(key, val).$assign_pair$_U1$_U2(configVals.$at(i).split(/*STRINGREF_STR*/"="));
      if (val.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(new SourceLocation(), 
                  diag.err_analyzer_config_no_value)), /*NO_COPY*/configVals.$at(i)));
          Success = false;
          break;
        } finally {
          $c$.$destroy();
        }
      }
      if (val.find($$EQ) != StringRef.npos) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(new SourceLocation(), 
                  diag.err_analyzer_config_multiple_values)), 
              /*NO_COPY*/configVals.$at(i)));
          Success = false;
          break;
        } finally {
          $c$.$destroy();
        }
      }
      Opts.Config.$at(/*NO_COPY*/key).$assignMove(val.$string());
    }
  }
  
  return Success;
}

//<editor-fold defaultstate="collapsed" desc="ParseMigratorArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 307,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 305,
 FQN="ParseMigratorArgs", NM="_ZL17ParseMigratorArgsRN5clang15MigratorOptionsERN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL17ParseMigratorArgsRN5clang15MigratorOptionsERN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean ParseMigratorArgs(final MigratorOptions /*&*/ Opts, final ArgList /*&*/ Args) {
  Opts.NoNSAllocReallocError = Args.hasArg(new OptSpecifier(ID.OPT_migrator_no_nsalloc_error.getValue()));
  Opts.NoFinalizeRemoval = Args.hasArg(new OptSpecifier(ID.OPT_migrator_no_finalize_removal.getValue()));
  return true;
}

//<editor-fold defaultstate="collapsed" desc="ParseCommentArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 313,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 311,
 FQN="ParseCommentArgs", NM="_ZL16ParseCommentArgsRN5clang14CommentOptionsERN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL16ParseCommentArgsRN5clang14CommentOptionsERN4llvm3opt7ArgListE")
//</editor-fold>
public static void ParseCommentArgs(final CommentOptions /*&*/ Opts, final ArgList /*&*/ Args) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean(Opts.BlockCommandNames.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fcomment_block_commands.getValue())))));
    Opts.ParseAllComments = Args.hasArg(new OptSpecifier(ID.OPT_fparse_all_comments.getValue()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="getCodeModel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 318,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 316,
 FQN="getCodeModel", NM="_ZL12getCodeModelRN4llvm3opt7ArgListERN5clang17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL12getCodeModelRN4llvm3opt7ArgListERN5clang17DiagnosticsEngineE")
//</editor-fold>
public static StringRef getCodeModel(final ArgList /*&*/ Args, final DiagnosticsEngine /*&*/ Diags) {
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_mcode_model.getValue()));
    if ((A != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        StringRef Value = new StringRef(A.getValue());
        if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"small") || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"kernel") || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"medium")
           || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"large")) {
          return Value;
        }
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), /*NO_COPY*/Value));
      } finally {
        $c$.$destroy();
      }
    }
  }
  return new StringRef(/*KEEP_STR*/$default);
}


/// \brief Create a new Regex instance out of the string value in \p RpassArg.
/// It returns a pointer to the newly generated Regex instance.
//<editor-fold defaultstate="collapsed" desc="GenerateOptimizationRemarkRegex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 331,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 329,
 FQN="GenerateOptimizationRemarkRegex", NM="_ZL31GenerateOptimizationRemarkRegexRN5clang17DiagnosticsEngineERN4llvm3opt7ArgListEPNS3_3ArgE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL31GenerateOptimizationRemarkRegexRN5clang17DiagnosticsEngineERN4llvm3opt7ArgListEPNS3_3ArgE")
//</editor-fold>
public static std.shared_ptr<Regex> GenerateOptimizationRemarkRegex(final DiagnosticsEngine /*&*/ Diags, final ArgList /*&*/ Args, 
                               Arg /*P*/ RpassArg) {
  std.shared_ptr<Regex> Pattern = null;
  try {
    StringRef Val = new StringRef(RpassArg.getValue());
    std.string RegexError/*J*/= new std.string();
    Pattern = std.make_shared(new Regex(Val));
    if (!Pattern.$arrow().isValid(RegexError)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_optimization_remark_pattern)), 
                new StringRef(RegexError)), new StringRef(RpassArg.getAsString(Args))));
        Pattern.reset();
      } finally {
        $c$.$destroy();
      }
    }
    return new std.shared_ptr<Regex>(JD$Move.INSTANCE, Pattern);
  } finally {
    if (Pattern != null) { Pattern.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="parseDiagnosticLevelMask">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 345,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 343,
 FQN="parseDiagnosticLevelMask", NM="_ZL24parseDiagnosticLevelMaskN4llvm9StringRefERKSt6vectorISsSaISsEEPN5clang17DiagnosticsEngineERNS6_19DiagnosticLevelMaskE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL24parseDiagnosticLevelMaskN4llvm9StringRefERKSt6vectorISsSaISsEEPN5clang17DiagnosticsEngineERNS6_19DiagnosticLevelMaskE")
//</editor-fold>
public static boolean parseDiagnosticLevelMask(StringRef FlagName, 
                        final /*const*/std.vectorString/*&*/ Levels, 
                        DiagnosticsEngine /*P*/ Diags, 
                        final /*DiagnosticLevelMask &*/uint$ref M) {
  boolean Success = true;
  for (final /*const*/std.string/*&*/ Level : Levels) {
    /*const DiagnosticLevelMask*//*uint*/int PM = new StringSwitchUInt/*DiagnosticLevelMask*/(new StringRef(Level)).
        Case(/*KEEP_STR*/"note", DiagnosticLevelMask.Note).
        Case(/*KEEP_STR*/"remark", DiagnosticLevelMask.Remark).
        Case(/*KEEP_STR*/"warning", DiagnosticLevelMask.Warning).
        Case(/*KEEP_STR*/"error", DiagnosticLevelMask.Error).
        Default(DiagnosticLevelMask.None);
    if (PM == DiagnosticLevelMask.None) {
      Success = false;
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), /*NO_COPY*/FlagName), new StringRef(Level)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    M.$set($bitor_DiagnosticLevelMask(/*KEEP_ENUM*/M.$deref(), /*KEEP_ENUM*/PM));
  }
  return Success;
}

//<editor-fold defaultstate="collapsed" desc="parseSanitizerKinds">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 368,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 366,
 FQN="parseSanitizerKinds", NM="_ZL19parseSanitizerKindsN4llvm9StringRefERKSt6vectorISsSaISsEERN5clang17DiagnosticsEngineERNS6_12SanitizerSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL19parseSanitizerKindsN4llvm9StringRefERKSt6vectorISsSaISsEERN5clang17DiagnosticsEngineERNS6_12SanitizerSetE")
//</editor-fold>
public static void parseSanitizerKinds(StringRef FlagName, 
                   final /*const*/std.vectorString/*&*/ Sanitizers, 
                   final DiagnosticsEngine /*&*/ Diags, final SanitizerSet /*&*/ S) {
  for (final /*const*/std.string/*&*/ Sanitizer : Sanitizers) {
    long/*uint64_t*/ K = parseSanitizerValue(new StringRef(Sanitizer), /*AllowGroups=*/ false);
    if (K == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), /*NO_COPY*/FlagName), new StringRef(Sanitizer)));
      } finally {
        $c$.$destroy();
      }
    } else {
      S.set(K, true);
    }
  }
}


// Set the profile kind for fprofile-instrument.
//<editor-fold defaultstate="collapsed" desc="setPGOInstrumentor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 381,
 FQN="setPGOInstrumentor", NM="_ZL18setPGOInstrumentorRN5clang14CodeGenOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL18setPGOInstrumentorRN5clang14CodeGenOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE")
//</editor-fold>
public static void setPGOInstrumentor(final CodeGenOptions /*&*/ Opts, final ArgList /*&*/ Args, 
                  final DiagnosticsEngine /*&*/ Diags) {
  Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_fprofile_instrument_EQ.getValue()));
  if (A == null) {
    return;
  }
  StringRef S = new StringRef(A.getValue());
  /*uint*/int I = new StringSwitchUInt(/*NO_COPY*/S).
      Case(/*KEEP_STR*/"none", CodeGenOptions.ProfileInstrKind.ProfileNone.getValue()).
      Case(/*KEEP_STR*/"clang", CodeGenOptions.ProfileInstrKind.ProfileClangInstr.getValue()).
      Case(/*KEEP_STR*/"llvm", CodeGenOptions.ProfileInstrKind.ProfileIRInstr.getValue()).
      Default(~0/*U*/);
  if (I == ~0/*U*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_pgo_instrumentor)), new StringRef(A.getAsString(Args))), 
          /*NO_COPY*/S));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  CodeGenOptions.ProfileInstrKind Instrumentor = /*static_cast*/CodeGenOptions.ProfileInstrKind.valueOf(I);
  Opts.setProfileInstr(Instrumentor);
}


// Set the profile kind using fprofile-instrument-use-path.
//<editor-fold defaultstate="collapsed" desc="setPGOUseInstrumentor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 403,
 FQN="setPGOUseInstrumentor", NM="_ZL21setPGOUseInstrumentorRN5clang14CodeGenOptionsERKN4llvm5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL21setPGOUseInstrumentorRN5clang14CodeGenOptionsERKN4llvm5TwineE")
//</editor-fold>
public static void setPGOUseInstrumentor(final CodeGenOptions /*&*/ Opts, 
                     final /*const*/ Twine /*&*/ ProfileName) {
  Expected<unique_ptr<IndexedInstrProfReader> > ReaderOrErr = null;
  std.unique_ptr<IndexedInstrProfReader> PGOReader = null;
  try {
    ReaderOrErr = IndexedInstrProfReader.create_IndexedInstrProfReader(ProfileName);
    {
      Error E = null;
      try {
        // In error, return silently and let Clang PGOUse report the error message.
        E = ReaderOrErr.takeError();
        if (E.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            llvm.consumeError($c$.track(new Error(JD$Move.INSTANCE, std.move(E)))); $c$.clean();
            Opts.setProfileUse(CodeGenOptions.ProfileInstrKind.ProfileClangInstr);
            return;
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
      }
    }
    PGOReader = new std.unique_ptr<IndexedInstrProfReader>(JD$Move.INSTANCE, std.move(ReaderOrErr.get()));
    if (PGOReader.$arrow().isIRLevelProfile()) {
      Opts.setProfileUse(CodeGenOptions.ProfileInstrKind.ProfileIRInstr);
    } else {
      Opts.setProfileUse(CodeGenOptions.ProfileInstrKind.ProfileClangInstr);
    }
  } finally {
    if (PGOReader != null) { PGOReader.$destroy(); }
    if (ReaderOrErr != null) { ReaderOrErr.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="ParseCodeGenArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 420,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 378,
 FQN="ParseCodeGenArgs", NM="_ZL16ParseCodeGenArgsRN5clang14CodeGenOptionsERN4llvm3opt7ArgListENS_9InputKindERNS_17DiagnosticsEngineERKNS_13TargetOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL16ParseCodeGenArgsRN5clang14CodeGenOptionsERN4llvm3opt7ArgListENS_9InputKindERNS_17DiagnosticsEngineERKNS_13TargetOptionsE")
//</editor-fold>
public static boolean ParseCodeGenArgs(final CodeGenOptions /*&*/ Opts, final ArgList /*&*/ Args, InputKind IK, 
                final DiagnosticsEngine /*&*/ Diags, 
                final /*const*/ TargetOptions /*&*/ TargetOpts) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //JAVA: using namespace options;
    boolean Success = true;
    Triple $Triple = new Triple(new Twine(TargetOpts.Triple));
    
    /*uint*/int OptimizationLevel = getOptimizationLevel(Args, IK, Diags);
    // TODO: This could be done in Driver
    /*uint*/int MaxOptLevel = 3;
    if ($greater_uint(OptimizationLevel, MaxOptLevel)) {
      // If the optimization level is not supported, fall back on the default
      // optimization
      $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.warn_drv_optimization_value)), 
                  new StringRef(Args.getLastArg(new OptSpecifier(ID.OPT_O.getValue())).getAsString(Args))), /*KEEP_STR*/"-O"), MaxOptLevel));
      OptimizationLevel = MaxOptLevel;
    }
    Opts.OptimizationLevel = $uint2uint_2bits(OptimizationLevel);
    
    // We must always run at least the always inlining pass.
    Opts.setInlining(($2bits_uint2uint(Opts.OptimizationLevel) > 1) ? CodeGenOptions.InliningMethod.NormalInlining : CodeGenOptions.InliningMethod.OnlyAlwaysInlining);
    // -fno-inline-functions overrides OptimizationLevel > 1.
    Opts.NoInline = Args.hasArg(new OptSpecifier(ID.OPT_fno_inline.getValue()));
    {
      Arg /*P*/ InlineArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_finline_functions.getValue()), 
          new OptSpecifier(options.ID.OPT_finline_hint_functions.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_inline_functions.getValue()));
      if ((InlineArg != null)) {
        final /*const*/ Option /*&*/ InlineOpt = InlineArg.getOption();
        if (InlineOpt.matches(new OptSpecifier(options.ID.OPT_finline_functions.getValue()))) {
          Opts.setInlining(CodeGenOptions.InliningMethod.NormalInlining);
        } else if (InlineOpt.matches(new OptSpecifier(options.ID.OPT_finline_hint_functions.getValue()))) {
          Opts.setInlining(CodeGenOptions.InliningMethod.OnlyHintInlining);
        } else {
          Opts.setInlining(CodeGenOptions.InliningMethod.OnlyAlwaysInlining);
        }
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_fveclib.getValue()));
      if ((A != null)) {
        StringRef Name = new StringRef(A.getValue());
        if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"Accelerate")) {
          Opts.setVecLib(CodeGenOptions.VectorLibrary.Accelerate);
        } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"none")) {
          Opts.setVecLib(CodeGenOptions.VectorLibrary.NoLibrary);
        } else {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), /*NO_COPY*/Name));
        }
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_debug_info_kind_EQ.getValue()));
      if ((A != null)) {
        /*uint*/int Val = new StringSwitchUInt(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"line-tables-only", DebugInfoKind.DebugLineTablesOnly.getValue()).
            Case(/*KEEP_STR*/"limited", DebugInfoKind.LimitedDebugInfo.getValue()).
            Case(/*KEEP_STR*/"standalone", DebugInfoKind.FullDebugInfo.getValue()).
            Default(~0/*U*/);
        if (Val == ~0/*U*/) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), 
              A.getValue()));
        } else {
          Opts.setDebugInfo(/*static_cast*/DebugInfoKind.valueOf(Val));
        }
      }
    }
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_debugger_tuning_EQ.getValue()));
      if ((A != null)) {
        /*uint*/int Val = new StringSwitchUInt(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"gdb", ((/*uint*/int)(DebuggerKind.GDB.getValue()))).
            Case(/*KEEP_STR*/"lldb", ((/*uint*/int)(DebuggerKind.LLDB.getValue()))).
            Case(/*KEEP_STR*/"sce", ((/*uint*/int)(DebuggerKind.SCE.getValue()))).
            Default(~0/*U*/);
        if (Val == ~0/*U*/) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), 
              A.getValue()));
        } else {
          Opts.setDebuggerTuning(/*static_cast*/DebuggerKind.valueOf(Val));
        }
      }
    }
    Opts.DwarfVersion = $uint2uint_3bits(getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_dwarf_version_EQ.getValue()), 0, Diags));
    Opts.DebugColumnInfo = Args.hasArg(new OptSpecifier(ID.OPT_dwarf_column_info.getValue()));
    Opts.EmitCodeView = Args.hasArg(new OptSpecifier(ID.OPT_gcodeview.getValue()));
    Opts.WholeProgramVTables = Args.hasArg(new OptSpecifier(ID.OPT_fwhole_program_vtables.getValue()));
    Opts.LTOVisibilityPublicStd = Args.hasArg(new OptSpecifier(ID.OPT_flto_visibility_public_std.getValue()));
    Opts.SplitDwarfFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_split_dwarf_file.getValue())).$string());
    Opts.DebugTypeExtRefs = Args.hasArg(new OptSpecifier(ID.OPT_dwarf_ext_refs.getValue()));
    Opts.DebugExplicitImport = $Triple.isPS4CPU();
    
    for (/*const*/std.string/*&*/ Arg : Args.getAllArgValues(new OptSpecifier(ID.OPT_fdebug_prefix_map_EQ.getValue())))  {
      // JAVA: manually created pair<string, string> from pair<StringRef, StringRef>
      pair<StringRef, StringRef> $split = new StringRef(Arg).split($$EQ);       
      Opts.DebugPrefixMap.insert(std.make_pair($split.first.$string(), $split.second.$string()));
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_emit_llvm_uselists.getValue()), new OptSpecifier(ID.OPT_no_emit_llvm_uselists.getValue()));
      if ((A != null)) {
        Opts.EmitLLVMUseLists = A.getOption().getID() == ID.OPT_emit_llvm_uselists.getValue();
      }
    }
    
    Opts.DisableLLVMOpts = Args.hasArg(new OptSpecifier(ID.OPT_disable_llvm_optzns.getValue()));
    Opts.DisableLLVMPasses = Args.hasArg(new OptSpecifier(ID.OPT_disable_llvm_passes.getValue()));
    Opts.DisableRedZone = Args.hasArg(new OptSpecifier(ID.OPT_disable_red_zone.getValue()));
    Opts.ForbidGuardVariables = Args.hasArg(new OptSpecifier(ID.OPT_fforbid_guard_variables.getValue()));
    Opts.UseRegisterSizedBitfieldAccess = Args.hasArg(new OptSpecifier(ID.OPT_fuse_register_sized_bitfield_access.getValue()));
    Opts.RelaxedAliasing = Args.hasArg(new OptSpecifier(ID.OPT_relaxed_aliasing.getValue()));
    Opts.StructPathTBAA = !Args.hasArg(new OptSpecifier(ID.OPT_no_struct_path_tbaa.getValue()));
    Opts.DwarfDebugFlags.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_dwarf_debug_flags.getValue())).$string());
    Opts.MergeAllConstants = !Args.hasArg(new OptSpecifier(ID.OPT_fno_merge_all_constants.getValue()));
    Opts.NoCommon = Args.hasArg(new OptSpecifier(ID.OPT_fno_common.getValue()));
    Opts.NoImplicitFloat = Args.hasArg(new OptSpecifier(ID.OPT_no_implicit_float.getValue()));
    Opts.OptimizeSize = $uint2uint_2bits(getOptimizationLevelSize(Args));
    Opts.SimplifyLibCalls = !(Args.hasArg(new OptSpecifier(ID.OPT_fno_builtin.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_ffreestanding.getValue())));
    if (Opts.SimplifyLibCalls) {
      getAllNoBuiltinFuncValues(Args, Opts.NoBuiltinFuncs);
    }
    Opts.UnrollLoops
       = Args.hasFlag(new OptSpecifier(ID.OPT_funroll_loops.getValue()), new OptSpecifier(ID.OPT_fno_unroll_loops.getValue()), 
        ($2bits_uint2uint(Opts.OptimizationLevel) > 1));
    Opts.RerollLoops = Args.hasArg(new OptSpecifier(ID.OPT_freroll_loops.getValue()));
    
    Opts.DisableIntegratedAS = Args.hasArg(new OptSpecifier(ID.OPT_fno_integrated_as.getValue()));
    Opts.Autolink = !Args.hasArg(new OptSpecifier(ID.OPT_fno_autolink.getValue()));
    Opts.SampleProfileFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_fprofile_sample_use_EQ.getValue())).$string());
    
    setPGOInstrumentor(Opts, Args, Diags);
    Opts.InstrProfileOutput.$assignMove(
        Args.getLastArgValue(new OptSpecifier(ID.OPT_fprofile_instrument_path_EQ.getValue())).$string()
    );
    Opts.ProfileInstrumentUsePath.$assignMove(
        Args.getLastArgValue(new OptSpecifier(ID.OPT_fprofile_instrument_use_path_EQ.getValue())).$string()
    );
    if (!Opts.ProfileInstrumentUsePath.empty()) {
      setPGOUseInstrumentor(Opts, new Twine(Opts.ProfileInstrumentUsePath));
    }
    
    Opts.CoverageMapping
       = Args.hasFlag(new OptSpecifier(ID.OPT_fcoverage_mapping.getValue()), new OptSpecifier(ID.OPT_fno_coverage_mapping.getValue()), false);
    Opts.DumpCoverageMapping = Args.hasArg(new OptSpecifier(ID.OPT_dump_coverage_mapping.getValue()));
    Opts.AsmVerbose = Args.hasArg(new OptSpecifier(ID.OPT_masm_verbose.getValue()));
    Opts.AssumeSaneOperatorNew = !Args.hasArg(new OptSpecifier(ID.OPT_fno_assume_sane_operator_new.getValue()));
    Opts.ObjCAutoRefCountExceptions = Args.hasArg(new OptSpecifier(ID.OPT_fobjc_arc_exceptions.getValue()));
    Opts.CXAAtExit = !Args.hasArg(new OptSpecifier(ID.OPT_fno_use_cxa_atexit.getValue()));
    Opts.CXXCtorDtorAliases = Args.hasArg(new OptSpecifier(ID.OPT_mconstructor_aliases.getValue()));
    Opts.CodeModel.$assignMove(getCodeModel(Args, Diags).$string());
    Opts.DebugPass.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_mdebug_pass.getValue())).$string());
    Opts.DisableFPElim
       = (Args.hasArg(new OptSpecifier(ID.OPT_mdisable_fp_elim.getValue())) || Args.hasArg(new OptSpecifier(ID.OPT_pg.getValue())));
    Opts.DisableFree = Args.hasArg(new OptSpecifier(ID.OPT_disable_free.getValue()));
    Opts.DiscardValueNames = Args.hasArg(new OptSpecifier(ID.OPT_discard_value_names.getValue()));
    Opts.DisableTailCalls = Args.hasArg(new OptSpecifier(ID.OPT_mdisable_tail_calls.getValue()));
    Opts.FloatABI.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_mfloat_abi.getValue())).$string());
    Opts.LessPreciseFPMAD = Args.hasArg(new OptSpecifier(ID.OPT_cl_mad_enable.getValue()));
    Opts.LimitFloatPrecision.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_mlimit_float_precision.getValue())).$string());
    Opts.NoInfsFPMath = (Args.hasArg(new OptSpecifier(ID.OPT_menable_no_infinities.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_finite_math_only.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_fast_relaxed_math.getValue())));
    Opts.NoNaNsFPMath = (Args.hasArg(new OptSpecifier(ID.OPT_menable_no_nans.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_unsafe_math_optimizations.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_finite_math_only.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_fast_relaxed_math.getValue())));
    Opts.NoSignedZeros = (Args.hasArg(new OptSpecifier(ID.OPT_fno_signed_zeros.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_no_signed_zeros.getValue())));
    Opts.ReciprocalMath = Args.hasArg(new OptSpecifier(ID.OPT_freciprocal_math.getValue()));
    Opts.NoZeroInitializedInBSS = Args.hasArg(new OptSpecifier(ID.OPT_mno_zero_initialized_in_bss.getValue()));
    $c$.clean(Opts.BackendOptions.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_backend_option.getValue())))));
    Opts.NumRegisterParameters = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_mregparm.getValue()), 0, Diags);
    Opts.NoExecStack = Args.hasArg(new OptSpecifier(ID.OPT_mno_exec_stack.getValue()));
    Opts.FatalWarnings = Args.hasArg(new OptSpecifier(ID.OPT_massembler_fatal_warnings.getValue()));
    Opts.EnableSegmentedStacks = Args.hasArg(new OptSpecifier(ID.OPT_split_stacks.getValue()));
    Opts.RelaxAll = Args.hasArg(new OptSpecifier(ID.OPT_mrelax_all.getValue()));
    Opts.IncrementalLinkerCompatible
       = Args.hasArg(new OptSpecifier(ID.OPT_mincremental_linker_compatible.getValue()));
    Opts.OmitLeafFramePointer = Args.hasArg(new OptSpecifier(ID.OPT_momit_leaf_frame_pointer.getValue()));
    Opts.SaveTempLabels = Args.hasArg(new OptSpecifier(ID.OPT_msave_temp_labels.getValue()));
    Opts.NoDwarfDirectoryAsm = Args.hasArg(new OptSpecifier(ID.OPT_fno_dwarf_directory_asm.getValue()));
    Opts.SoftFloat = Args.hasArg(new OptSpecifier(ID.OPT_msoft_float.getValue()));
    Opts.StrictEnums = Args.hasArg(new OptSpecifier(ID.OPT_fstrict_enums.getValue()));
    Opts.StrictVTablePointers = Args.hasArg(new OptSpecifier(ID.OPT_fstrict_vtable_pointers.getValue()));
    Opts.UnsafeFPMath = Args.hasArg(new OptSpecifier(ID.OPT_menable_unsafe_fp_math.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_unsafe_math_optimizations.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_fast_relaxed_math.getValue()));
    Opts.UnwindTables = Args.hasArg(new OptSpecifier(ID.OPT_munwind_tables.getValue()));
    Opts.RelocationModel.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_mrelocation_model.getValue()), new StringRef(/*KEEP_STR*/"pic")).$string());
    Opts.ThreadModel.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_mthread_model.getValue()), new StringRef(/*KEEP_STR*/"posix")).$string());
    if ($noteq_string$C_T$C$P(Opts.ThreadModel, /*KEEP_STR*/"posix") && $noteq_string$C_T$C$P(Opts.ThreadModel, /*KEEP_STR*/"single")) {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
              new StringRef(Args.getLastArg(new OptSpecifier(ID.OPT_mthread_model.getValue())).getAsString(Args))), 
          new StringRef(Opts.ThreadModel)));
    }
    Opts.TrapFuncName.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_ftrap_function_EQ.getValue())).$string());
    Opts.UseInitArray = Args.hasArg(new OptSpecifier(ID.OPT_fuse_init_array.getValue()));
    
    Opts.FunctionSections = Args.hasFlag(new OptSpecifier(ID.OPT_ffunction_sections.getValue()), 
        new OptSpecifier(ID.OPT_fno_function_sections.getValue()), false);
    Opts.DataSections = Args.hasFlag(new OptSpecifier(ID.OPT_fdata_sections.getValue()), 
        new OptSpecifier(ID.OPT_fno_data_sections.getValue()), false);
    Opts.UniqueSectionNames = Args.hasFlag(new OptSpecifier(ID.OPT_funique_section_names.getValue()), 
        new OptSpecifier(ID.OPT_fno_unique_section_names.getValue()), true);
    
    Opts.MergeFunctions = Args.hasArg(new OptSpecifier(ID.OPT_fmerge_functions.getValue()));
    
    Opts.NoUseJumpTables = Args.hasArg(new OptSpecifier(ID.OPT_fno_jump_tables.getValue()));
    
    Opts.PrepareForLTO = Args.hasArg(new OptSpecifier(ID.OPT_flto.getValue()), new OptSpecifier(ID.OPT_flto_EQ.getValue()));
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_flto.getValue()), new OptSpecifier(ID.OPT_flto_EQ.getValue()));
    Opts.EmitSummaryIndex = (A != null) && A.containsValue(new StringRef(/*KEEP_STR*/"thin"));
    {
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_fthinlto_index_EQ.getValue()));
      if ((A$1 != null)) {
        if (IK != InputKind.IK_LLVM_IR) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_argument_only_allowed_with)), 
                  new StringRef(A$1.getAsString(Args))), /*KEEP_STR*/"-x ir"));
        }
        Opts.ThinLTOIndexFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_fthinlto_index_EQ.getValue())).$string());
      }
    }
    
    Opts.MSVolatile = Args.hasArg(new OptSpecifier(ID.OPT_fms_volatile.getValue()));
    
    Opts.VectorizeBB = Args.hasArg(new OptSpecifier(ID.OPT_vectorize_slp_aggressive.getValue()));
    Opts.VectorizeLoop = Args.hasArg(new OptSpecifier(ID.OPT_vectorize_loops.getValue()));
    Opts.VectorizeSLP = Args.hasArg(new OptSpecifier(ID.OPT_vectorize_slp.getValue()));
    
    Opts.MainFileName.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_main_file_name.getValue())).$string());
    Opts.VerifyModule = !Args.hasArg(new OptSpecifier(ID.OPT_disable_llvm_verifier.getValue()));
    
    Opts.DisableGCov = Args.hasArg(new OptSpecifier(ID.OPT_test_coverage.getValue()));
    Opts.EmitGcovArcs = Args.hasArg(new OptSpecifier(ID.OPT_femit_coverage_data.getValue()));
    Opts.EmitGcovNotes = Args.hasArg(new OptSpecifier(ID.OPT_femit_coverage_notes.getValue()));
    if (Opts.EmitGcovArcs || Opts.EmitGcovNotes) {
      Opts.CoverageFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_coverage_file.getValue())).$string());
      Opts.CoverageExtraChecksum = Args.hasArg(new OptSpecifier(ID.OPT_coverage_cfg_checksum.getValue()));
      Opts.CoverageNoFunctionNamesInData
         = Args.hasArg(new OptSpecifier(ID.OPT_coverage_no_function_names_in_data.getValue()));
      Opts.CoverageExitBlockBeforeBody
         = Args.hasArg(new OptSpecifier(ID.OPT_coverage_exit_block_before_body.getValue()));
      if (Args.hasArg(new OptSpecifier(ID.OPT_coverage_version_EQ.getValue()))) {
        StringRef CoverageVersion = Args.getLastArgValue(new OptSpecifier(ID.OPT_coverage_version_EQ.getValue()));
        if (CoverageVersion.size() != 4) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(Args.getLastArg(new OptSpecifier(ID.OPT_coverage_version_EQ.getValue())).getAsString(Args))), 
              /*NO_COPY*/CoverageVersion));
        } else {
          memcpy(Opts.CoverageVersion, CoverageVersion.data(), 4);
        }
      }
    }
    {
      // Handle -fembed-bitcode option.
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_fembed_bitcode_EQ.getValue()));
      if ((A$1 != null)) {
        StringRef Name = new StringRef(A$1.getValue());
        /*uint*/int Model = new StringSwitchUInt(/*NO_COPY*/Name).
            Case(/*KEEP_STR*/"off", CodeGenOptions.EmbedBitcodeKind.Embed_Off.getValue()).
            Case(/*KEEP_STR*/"all", CodeGenOptions.EmbedBitcodeKind.Embed_All.getValue()).
            Case(/*KEEP_STR*/"bitcode", CodeGenOptions.EmbedBitcodeKind.Embed_Bitcode.getValue()).
            Case(/*KEEP_STR*/"marker", CodeGenOptions.EmbedBitcodeKind.Embed_Marker.getValue()).
            Default(~0/*U*/);
        if (Model == ~0/*U*/) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A$1.getAsString(Args))), /*NO_COPY*/Name));
          Success = false;
        } else {
          Opts.setEmbedBitcode(/*static_cast*/CodeGenOptions.EmbedBitcodeKind.valueOf(Model));
        }
      }
    }
    // FIXME: For backend options that are not yet recorded as function
    // attributes in the IR, keep track of them so we can embed them in a
    // separate data section and use them when building the bitcode.
    if (Opts.getEmbedBitcode() == CodeGenOptions.EmbedBitcodeKind.Embed_All) {
      for (Arg /*P*/ /*const*/ /*&*/ A$1 : Args) {
        // Do not encode output and input.
        if (A$1.getOption().getID() == options.ID.OPT_o.getValue()
           || A$1.getOption().getID() == options.ID.OPT_INPUT.getValue()
           || A$1.getOption().getID() == options.ID.OPT_x.getValue()
           || A$1.getOption().getID() == options.ID.OPT_fembed_bitcode.getValue()
           || (A$1.getOption().getGroup().isValid()
           && A$1.getOption().getGroup().getID() == options.ID.OPT_W_Group.getValue())) {
          continue;
        }
        ArgStringList ASL/*J*/= new ArgStringList();
        A$1.render(Args, ASL);
        for (final /*const*/char$ptr/*char P*//*const*/ /*&*/ arg : ASL) {
          StringRef ArgStr/*J*/= new StringRef(arg);
          Opts.CmdArgs.insert$T((Opts.CmdArgs.end()), ArgStr.begin(), ArgStr.end());
          // using \00 to seperate each commandline options.
          Opts.CmdArgs.push_back_T$RR($$TERM);
        }
      }
    }
    
    Opts.InstrumentFunctions = Args.hasArg(new OptSpecifier(ID.OPT_finstrument_functions.getValue()));
    Opts.XRayInstrumentFunctions = Args.hasArg(new OptSpecifier(ID.OPT_fxray_instrument.getValue()));
    Opts.XRayInstructionThreshold
       = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fxray_instruction_threshold_.getValue()), 200, Diags);
    Opts.InstrumentForProfiling = Args.hasArg(new OptSpecifier(ID.OPT_pg.getValue()));
    Opts.EmitOpenCLArgMetadata = Args.hasArg(new OptSpecifier(ID.OPT_cl_kernel_arg_info.getValue()));
    Opts.CompressDebugSections = Args.hasArg(new OptSpecifier(ID.OPT_compress_debug_sections.getValue()));
    Opts.RelaxELFRelocations = Args.hasArg(new OptSpecifier(ID.OPT_mrelax_relocations.getValue()));
    Opts.DebugCompilationDir.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_fdebug_compilation_dir.getValue())).$string());
    for (Arg /*P*/ A$1 : Args.filtered(new OptSpecifier(ID.OPT_mlink_bitcode_file.getValue()), new OptSpecifier(ID.OPT_mlink_cuda_bitcode.getValue()))) {
      /*uint*/int LinkFlags = Linker.Flags.None;
      if (A$1.getOption().matches(new OptSpecifier(ID.OPT_mlink_cuda_bitcode.getValue()))) {
        LinkFlags = Linker.Flags.LinkOnlyNeeded
           | Linker.Flags.InternalizeLinkedSymbols;
      }
      Opts.LinkBitcodeFiles.push_back_T$RR(std.make_pair_uint_Ptr(LinkFlags, new std.string(A$1.getValue())));
    }
    Opts.SanitizeCoverageType
       = $uint2uint_2bits(getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fsanitize_coverage_type.getValue()), 0, Diags));
    Opts.SanitizeCoverageIndirectCalls
       = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_coverage_indirect_calls.getValue()));
    Opts.SanitizeCoverageTraceBB = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_coverage_trace_bb.getValue()));
    Opts.SanitizeCoverageTraceCmp = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_coverage_trace_cmp.getValue()));
    Opts.SanitizeCoverage8bitCounters
       = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_coverage_8bit_counters.getValue()));
    Opts.SanitizeCoverageTracePC = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_coverage_trace_pc.getValue()));
    Opts.SanitizeMemoryTrackOrigins
       = $uint2uint_2bits(getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fsanitize_memory_track_origins_EQ.getValue()), 0, Diags));
    Opts.SanitizeMemoryUseAfterDtor
       = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_memory_use_after_dtor.getValue()));
    Opts.SanitizeCfiCrossDso = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_cfi_cross_dso.getValue()));
    Opts.SanitizeStats = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_stats.getValue()));
    Opts.SanitizeAddressUseAfterScope
       = Args.hasArg(new OptSpecifier(ID.OPT_fsanitize_address_use_after_scope.getValue()));
    Opts.SSPBufferSize
       = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_stack_protector_buffer_size.getValue()), 8, Diags);
    Opts.StackRealignment = Args.hasArg(new OptSpecifier(ID.OPT_mstackrealign.getValue()));
    {
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_mstack_alignment.getValue()));
      if ((A$1 != null)) {
        StringRef Val = new StringRef(A$1.getValue());
        uint$ref StackAlignment = create_uint$ref(Opts.StackAlignment);
        Val.getAsInteger$NotSigned(10, StackAlignment);
        Opts.StackAlignment = StackAlignment.$deref();
      }
    }
    {
      
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_mstack_probe_size.getValue()));
      if ((A$1 != null)) {
        StringRef Val = new StringRef(A$1.getValue());
        uint$ref StackProbeSize = create_uint$ref(Opts.StackProbeSize);
        Val.getAsInteger$NotSigned(0, StackProbeSize);
        Opts.StackProbeSize = StackProbeSize.$deref();
      }
    }
    {
      
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_fobjc_dispatch_method_EQ.getValue()));
      if ((A$1 != null)) {
        StringRef Name = new StringRef(A$1.getValue());
        /*uint*/int Method = new StringSwitchUInt(/*NO_COPY*/Name).
            Case(/*KEEP_STR*/"legacy", CodeGenOptions.ObjCDispatchMethodKind.Legacy.getValue()).
            Case(/*KEEP_STR*/"non-legacy", CodeGenOptions.ObjCDispatchMethodKind.NonLegacy.getValue()).
            Case(/*KEEP_STR*/"mixed", CodeGenOptions.ObjCDispatchMethodKind.Mixed.getValue()).
            Default(~0/*U*/);
        if (Method == ~0/*U*/) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A$1.getAsString(Args))), /*NO_COPY*/Name));
          Success = false;
        } else {
          Opts.setObjCDispatchMethod(/*static_cast*/CodeGenOptions.ObjCDispatchMethodKind.valueOf(Method));
        }
      }
    }
    
    Opts.EmulatedTLS
       = Args.hasFlag(new OptSpecifier(ID.OPT_femulated_tls.getValue()), new OptSpecifier(ID.OPT_fno_emulated_tls.getValue()), false);
    {
      
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_ftlsmodel_EQ.getValue()));
      if ((A$1 != null)) {
        StringRef Name = new StringRef(A$1.getValue());
        /*uint*/int Model = new StringSwitchUInt(/*NO_COPY*/Name).
            Case(/*KEEP_STR*/"global-dynamic", CodeGenOptions.TLSModel.GeneralDynamicTLSModel.getValue()).
            Case(/*KEEP_STR*/"local-dynamic", CodeGenOptions.TLSModel.LocalDynamicTLSModel.getValue()).
            Case(/*KEEP_STR*/"initial-exec", CodeGenOptions.TLSModel.InitialExecTLSModel.getValue()).
            Case(/*KEEP_STR*/"local-exec", CodeGenOptions.TLSModel.LocalExecTLSModel.getValue()).
            Default(~0/*U*/);
        if (Model == ~0/*U*/) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A$1.getAsString(Args))), /*NO_COPY*/Name));
          Success = false;
        } else {
          Opts.setDefaultTLSModel(/*static_cast*/CodeGenOptions.TLSModel.valueOf(Model));
        }
      }
    }
    {
      
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_ffp_contract.getValue()));
      if ((A$1 != null)) {
        StringRef Val = new StringRef(A$1.getValue());
        if ($eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"fast")) {
          Opts.setFPContractMode(CodeGenOptions.FPContractModeKind.FPC_Fast);
        } else if ($eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"on")) {
          Opts.setFPContractMode(CodeGenOptions.FPContractModeKind.FPC_On);
        } else if ($eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"off")) {
          Opts.setFPContractMode(CodeGenOptions.FPContractModeKind.FPC_Off);
        } else {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A$1.getAsString(Args))), /*NO_COPY*/Val));
        }
      }
    }
    {
      
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_fpcc_struct_return.getValue()), new OptSpecifier(ID.OPT_freg_struct_return.getValue()));
      if ((A$1 != null)) {
        if (A$1.getOption().matches(new OptSpecifier(ID.OPT_fpcc_struct_return.getValue()))) {
          Opts.setStructReturnConvention(CodeGenOptions.StructReturnConventionKind.SRCK_OnStack);
        } else {
          assert (A$1.getOption().matches(new OptSpecifier(ID.OPT_freg_struct_return.getValue())));
          Opts.setStructReturnConvention(CodeGenOptions.StructReturnConventionKind.SRCK_InRegs);
        }
      }
    }
    
    $c$.clean(Opts.DependentLibraries.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_dependent_lib.getValue())))));
    $c$.clean(Opts.LinkerOptions.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_linker_option.getValue())))));
    boolean NeedLocTracking = false;
    {
      
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_Rpass_EQ.getValue()));
      if ((A$1 != null)) {
        $c$.clean(Opts.OptimizationRemarkPattern.$assignMove(
            $c$.track(GenerateOptimizationRemarkRegex(Diags, Args, A$1))
        ));
        NeedLocTracking = true;
      }
    }
    {
      
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_Rpass_missed_EQ.getValue()));
      if ((A$1 != null)) {
        $c$.clean(Opts.OptimizationRemarkMissedPattern.$assignMove(
            $c$.track(GenerateOptimizationRemarkRegex(Diags, Args, A$1))
        ));
        NeedLocTracking = true;
      }
    }
    {
      
      Arg /*P*/ A$1 = Args.getLastArg(new OptSpecifier(ID.OPT_Rpass_analysis_EQ.getValue()));
      if ((A$1 != null)) {
        $c$.clean(Opts.OptimizationRemarkAnalysisPattern.$assignMove(
            $c$.track(GenerateOptimizationRemarkRegex(Diags, Args, A$1))
        ));
        NeedLocTracking = true;
      }
    }
    
    // If the user requested to use a sample profile for PGO, then the
    // backend will need to track source location information so the profile
    // can be incorporated into the IR.
    if (!Opts.SampleProfileFile.empty()) {
      NeedLocTracking = true;
    }
    
    // If the user requested a flag that requires source locations available in
    // the backend, make sure that the backend tracks source location information.
    if (NeedLocTracking && Opts.getDebugInfo() == DebugInfoKind.NoDebugInfo) {
      Opts.setDebugInfo(DebugInfoKind.LocTrackingOnly);
    }
    
    $c$.clean(Opts.RewriteMapFiles.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_frewrite_map_file.getValue())))));
    
    // Parse -fsanitize-recover= arguments.
    // FIXME: Report unrecoverable sanitizers incorrectly specified here.
    parseSanitizerKinds(new StringRef(/*KEEP_STR*/"-fsanitize-recover="), 
        $c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fsanitize_recover_EQ.getValue()))), Diags, 
        Opts.SanitizeRecover); $c$.clean();
    parseSanitizerKinds(new StringRef(/*KEEP_STR*/"-fsanitize-trap="), 
        $c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fsanitize_trap_EQ.getValue()))), Diags, 
        Opts.SanitizeTrap); $c$.clean();
    
    $c$.clean(Opts.CudaGpuBinaryFileNames.$assignMove(
        $c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fcuda_include_gpubinary.getValue())))
    ));
    
    Opts.Backchain = Args.hasArg(new OptSpecifier(ID.OPT_mbackchain.getValue()));
    
    Opts.EmitCheckPathComponentsToStrip = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fsanitize_undefined_strip_path_components_EQ.getValue()), 0, Diags);
    
    return Success;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="ParseDependencyOutputArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 850,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 748,
 FQN="ParseDependencyOutputArgs", NM="_ZL25ParseDependencyOutputArgsRN5clang23DependencyOutputOptionsERN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL25ParseDependencyOutputArgsRN5clang23DependencyOutputOptionsERN4llvm3opt7ArgListE")
//</editor-fold>
public static void ParseDependencyOutputArgs(final DependencyOutputOptions /*&*/ Opts, 
                         final ArgList /*&*/ Args) {
  std.vectorString ModuleFiles = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //JAVA: using namespace options;
    Opts.OutputFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_dependency_file.getValue())).$string());
    $c$.clean(Opts.Targets.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_MT.getValue())))));
    Opts.IncludeSystemHeaders = Args.hasArg(new OptSpecifier(ID.OPT_sys_header_deps.getValue()));
    Opts.IncludeModuleFiles = Args.hasArg(new OptSpecifier(ID.OPT_module_file_deps.getValue()));
    Opts.UsePhonyTargets = Args.hasArg(new OptSpecifier(ID.OPT_MP.getValue()));
    Opts.ShowHeaderIncludes = Args.hasArg(new OptSpecifier(ID.OPT_H.getValue()));
    Opts.HeaderIncludeOutputFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_header_include_file.getValue())).$string());
    Opts.AddMissingHeaderDeps = Args.hasArg(new OptSpecifier(ID.OPT_MG.getValue()));
    Opts.PrintShowIncludes = Args.hasArg(new OptSpecifier(ID.OPT_show_includes.getValue()));
    Opts.DOTOutputFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_dependency_dot.getValue())).$string());
    Opts.ModuleDependencyOutputDir.$assignMove(
        Args.getLastArgValue(new OptSpecifier(ID.OPT_module_dependency_dir.getValue())).$string()
    );
    if (Args.hasArg(new OptSpecifier(ID.OPT_MV.getValue()))) {
      Opts.OutputFormat = DependencyOutputFormat.NMake;
    }
    // Add sanitizer blacklists as extra dependencies.
    // They won't be discovered by the regular preprocessor, so
    // we let make / ninja to know about this implicit dependency.
    $c$.clean(Opts.ExtraDeps.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fdepfile_entry.getValue())))));
    ModuleFiles = Args.getAllArgValues(new OptSpecifier(ID.OPT_fmodule_file.getValue()));
    Opts.ExtraDeps.insert((Opts.ExtraDeps.end()), ModuleFiles.begin(), 
        ModuleFiles.end());
  } finally {
    if (ModuleFiles != null) { ModuleFiles.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="parseShowColorsArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 876,
 FQN="parseShowColorsArgs", NM="_ZL19parseShowColorsArgsRKN4llvm3opt7ArgListEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL19parseShowColorsArgsRKN4llvm3opt7ArgListEb")
//</editor-fold>
public static boolean parseShowColorsArgs(final /*const*/ ArgList /*&*/ Args, boolean DefaultColor) {
  // Color diagnostics default to auto ("on" if terminal supports) in the driver
  // but default to off in cc1, needing an explicit OPT_fdiagnostics_color.
  // Support both clang's -f[no-]color-diagnostics and gcc's
  // -f[no-]diagnostics-colors[=never|always|auto].
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    final /*uint*/int Colors_On = 0;
    final /*uint*/int Colors_Off = Colors_On + 1;
    final /*uint*/int Colors_Auto = Colors_Off + 1;
  /*}*//*Unnamed enum*//*uint*/int ShowColors = DefaultColor ? Colors_Auto : Colors_Off;
  for (Arg /*P*/ A : Args) {
    final /*const*/ Option /*&*/ O = A.getOption();
    if (!O.matches(new OptSpecifier(options.ID.OPT_fcolor_diagnostics.getValue()))
       && !O.matches(new OptSpecifier(options.ID.OPT_fdiagnostics_color.getValue()))
       && !O.matches(new OptSpecifier(options.ID.OPT_fno_color_diagnostics.getValue()))
       && !O.matches(new OptSpecifier(options.ID.OPT_fno_diagnostics_color.getValue()))
       && !O.matches(new OptSpecifier(options.ID.OPT_fdiagnostics_color_EQ.getValue()))) {
      continue;
    }
    if (O.matches(new OptSpecifier(options.ID.OPT_fcolor_diagnostics.getValue()))
       || O.matches(new OptSpecifier(options.ID.OPT_fdiagnostics_color.getValue()))) {
      ShowColors = Colors_On;
    } else if (O.matches(new OptSpecifier(options.ID.OPT_fno_color_diagnostics.getValue()))
       || O.matches(new OptSpecifier(options.ID.OPT_fno_diagnostics_color.getValue()))) {
      ShowColors = Colors_Off;
    } else {
      assert (O.matches(new OptSpecifier(options.ID.OPT_fdiagnostics_color_EQ.getValue())));
      StringRef Value/*J*/= new StringRef(A.getValue());
      if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"always")) {
        ShowColors = Colors_On;
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"never")) {
        ShowColors = Colors_Off;
      } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"auto")) {
        ShowColors = Colors_Auto;
      }
    }
  }
  if (ShowColors == Colors_On
     || (ShowColors == Colors_Auto && Process.StandardErrHasColors())) {
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="ParseFileSystemArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1040,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 895,
 FQN="ParseFileSystemArgs", NM="_ZL19ParseFileSystemArgsRN5clang17FileSystemOptionsERN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL19ParseFileSystemArgsRN5clang17FileSystemOptionsERN4llvm3opt7ArgListE")
//</editor-fold>
public static void ParseFileSystemArgs(final FileSystemOptions /*&*/ Opts, final ArgList /*&*/ Args) {
  Opts.WorkingDir.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_working_directory.getValue())).$string());
}


/// Parse the argument to the -ftest-module-file-extension
/// command-line argument.
///
/// \returns true on error, false on success.
//<editor-fold defaultstate="collapsed" desc="parseTestModuleFileExtensionArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1048,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 903,
 FQN="parseTestModuleFileExtensionArg", NM="_ZL31parseTestModuleFileExtensionArgN4llvm9StringRefERSsRjS2_RbS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL31parseTestModuleFileExtensionArgN4llvm9StringRefERSsRjS2_RbS1_")
//</editor-fold>
public static boolean parseTestModuleFileExtensionArg(StringRef Arg, 
                               final std.string/*&*/ BlockName, 
                               final uint$ref/*uint &*/ MajorVersion, 
                               final uint$ref/*uint &*/ MinorVersion, 
                               final bool$ref/*bool &*/ Hashed, 
                               final std.string/*&*/ UserInfo) {
  SmallVector<StringRef> Args/*J*/= new SmallVector<StringRef>(5, new StringRef());
  Arg.split(Args, $$COLON, 5);
  if ($less_uint(Args.size(), 5)) {
    return true;
  }
  
  BlockName.$assignMove(Args.$at(0).$string());
  if (Args.$at(1).getAsInteger$NotSigned(10, MajorVersion)) {
    return true;
  }
  if (Args.$at(2).getAsInteger$NotSigned(10, MinorVersion)) {
    return true;
  }
  if (Args.$at(3).getAsInteger$NotSigned(2, /*KEEP_BOOL*/Hashed)) {
    return true;
  }
  if ($greater_uint(Args.size(), 4)) {
    UserInfo.$assignMove(Args.$at(4).$string());
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="ParseFrontendArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1068,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 923,
 FQN="ParseFrontendArgs", NM="_ZL17ParseFrontendArgsRN5clang15FrontendOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL17ParseFrontendArgsRN5clang15FrontendOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE")
//</editor-fold>
public static InputKind ParseFrontendArgs(final FrontendOptions /*&*/ Opts, final ArgList /*&*/ Args, 
                 final DiagnosticsEngine /*&*/ Diags) {
  std.vectorString Inputs = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //JAVA: using namespace options;
    Opts.ProgramAction = frontend.ActionKind.ParseSyntaxOnly;
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_Action_Group.getValue()));
      if ((A != null)) {
        switch (ID.valueOf(A.getOption().getID())) {
         default:
          throw new llvm_unreachable("Invalid option in group!");
         case OPT_ast_list:
          Opts.ProgramAction = frontend.ActionKind.ASTDeclList;
          break;
         case OPT_ast_dump:
         case OPT_ast_dump_lookups:
          Opts.ProgramAction = frontend.ActionKind.ASTDump;
          break;
         case OPT_ast_print:
          Opts.ProgramAction = frontend.ActionKind.ASTPrint;
          break;
         case OPT_ast_view:
          Opts.ProgramAction = frontend.ActionKind.ASTView;
          break;
         case OPT_dump_raw_tokens:
          Opts.ProgramAction = frontend.ActionKind.DumpRawTokens;
          break;
         case OPT_dump_tokens:
          Opts.ProgramAction = frontend.ActionKind.DumpTokens;
          break;
         case OPT_S:
          Opts.ProgramAction = frontend.ActionKind.EmitAssembly;
          break;
         case OPT_emit_llvm_bc:
          Opts.ProgramAction = frontend.ActionKind.EmitBC;
          break;
         case OPT_emit_html:
          Opts.ProgramAction = frontend.ActionKind.EmitHTML;
          break;
         case OPT_emit_llvm:
          Opts.ProgramAction = frontend.ActionKind.EmitLLVM;
          break;
         case OPT_emit_llvm_only:
          Opts.ProgramAction = frontend.ActionKind.EmitLLVMOnly;
          break;
         case OPT_emit_codegen_only:
          Opts.ProgramAction = frontend.ActionKind.EmitCodeGenOnly;
          break;
         case OPT_emit_obj:
          Opts.ProgramAction = frontend.ActionKind.EmitObj;
          break;
         case OPT_fixit_EQ:
          Opts.FixItSuffix.$assign_T$C$P(A.getValue());
         case OPT_fixit:
          // fall-through!
          Opts.ProgramAction = frontend.ActionKind.FixIt;
          break;
         case OPT_emit_module:
          Opts.ProgramAction = frontend.ActionKind.GenerateModule;
          break;
         case OPT_emit_pch:
          Opts.ProgramAction = frontend.ActionKind.GeneratePCH;
          break;
         case OPT_emit_pth:
          Opts.ProgramAction = frontend.ActionKind.GeneratePTH;
          break;
         case OPT_init_only:
          Opts.ProgramAction = frontend.ActionKind.InitOnly;
          break;
         case OPT_fsyntax_only:
          Opts.ProgramAction = frontend.ActionKind.ParseSyntaxOnly;
          break;
         case OPT_module_file_info:
          Opts.ProgramAction = frontend.ActionKind.ModuleFileInfo;
          break;
         case OPT_verify_pch:
          Opts.ProgramAction = frontend.ActionKind.VerifyPCH;
          break;
         case OPT_print_decl_contexts:
          Opts.ProgramAction = frontend.ActionKind.PrintDeclContext;
          break;
         case OPT_print_preamble:
          Opts.ProgramAction = frontend.ActionKind.PrintPreamble;
          break;
         case OPT_E:
          Opts.ProgramAction = frontend.ActionKind.PrintPreprocessedInput;
          break;
         case OPT_rewrite_macros:
          Opts.ProgramAction = frontend.ActionKind.RewriteMacros;
          break;
         case OPT_rewrite_objc:
          Opts.ProgramAction = frontend.ActionKind.RewriteObjC;
          break;
         case OPT_rewrite_test:
          Opts.ProgramAction = frontend.ActionKind.RewriteTest;
          break;
         case OPT_analyze:
          Opts.ProgramAction = frontend.ActionKind.RunAnalysis;
          break;
         case OPT_migrate:
          Opts.ProgramAction = frontend.ActionKind.MigrateSource;
          break;
         case OPT_Eonly:
          Opts.ProgramAction = frontend.ActionKind.RunPreprocessorOnly;
          break;
        }
      }
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_plugin.getValue()));
      if ((A != null)) {
        Opts.Plugins.emplace_back(A.getValue(0));
        Opts.ProgramAction = frontend.ActionKind.PluginAction;
        Opts.ActionName.$assign_T$C$P(A.getValue());
      }
    }
    $c$.clean(Opts.AddPluginActions.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_add_plugin.getValue())))));
    for (/*const*/ Arg /*P*/ AA : Args.filtered(new OptSpecifier(ID.OPT_plugin_arg.getValue())))  {
      Opts.PluginArgs.$at(new std.string(AA.getValue(0))).emplace_back(AA.getValue(1));
    }
    
    for (final /*const*/std.string/*&*/ Arg : Args.getAllArgValues(new OptSpecifier(ID.OPT_ftest_module_file_extension_EQ.getValue()))) {
      std.string BlockName/*J*/= new std.string();
      uint$ref MajorVersion = create_uint$ref();
      uint$ref MinorVersion = create_uint$ref();
      bool$ref Hashed = create_bool$ref();
      std.string UserInfo/*J*/= new std.string();
      if (parseTestModuleFileExtensionArg(new StringRef(Arg), BlockName, MajorVersion, 
          MinorVersion, Hashed, UserInfo)) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_test_module_file_extension_format)), new StringRef(Arg)));
        
        continue;
      }
      
      // Add the testing module file extension.
      Opts.ModuleFileExtensions.push_back_T$RR($c$.track(new IntrusiveRefCntPtr<ModuleFileExtension>(new TestModuleFileExtension(new StringRef(BlockName), MajorVersion.$deref(), MinorVersion.$deref(), 
                  Hashed.$deref(), new StringRef(UserInfo))))); $c$.clean();
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_code_completion_at.getValue()));
      if ((A != null)) {
        Opts.CodeCompletionAt.$assignMove(
            ParsedSourceLocation.FromString(new StringRef(A.getValue()))
        );
        if (Opts.CodeCompletionAt.FileName.empty()) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), A.getValue()));
        }
      }
    }
    Opts.DisableFree = Args.hasArg(new OptSpecifier(ID.OPT_disable_free.getValue()));
    
    Opts.OutputFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_o.getValue())).$string());
    $c$.clean(Opts.Plugins.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_load.getValue())))));
    Opts.RelocatablePCH = Args.hasArg(new OptSpecifier(ID.OPT_relocatable_pch.getValue()));
    Opts.ShowHelp = Args.hasArg(new OptSpecifier(ID.OPT_help.getValue()));
    Opts.ShowStats = Args.hasArg(new OptSpecifier(ID.OPT_print_stats.getValue()));
    Opts.ShowTimers = Args.hasArg(new OptSpecifier(ID.OPT_ftime_report.getValue()));
    Opts.ShowVersion = Args.hasArg(new OptSpecifier(ID.OPT_version.getValue()));
    $c$.clean(Opts.ASTMergeFiles.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_ast_merge.getValue())))));
    $c$.clean(Opts.LLVMArgs.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_mllvm.getValue())))));
    Opts.FixWhatYouCan = Args.hasArg(new OptSpecifier(ID.OPT_fix_what_you_can.getValue()));
    Opts.FixOnlyWarnings = Args.hasArg(new OptSpecifier(ID.OPT_fix_only_warnings.getValue()));
    Opts.FixAndRecompile = Args.hasArg(new OptSpecifier(ID.OPT_fixit_recompile.getValue()));
    Opts.FixToTemporaries = Args.hasArg(new OptSpecifier(ID.OPT_fixit_to_temp.getValue()));
    Opts.ASTDumpDecls = Args.hasArg(new OptSpecifier(ID.OPT_ast_dump.getValue()));
    Opts.ASTDumpFilter.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_ast_dump_filter.getValue())).$string());
    Opts.ASTDumpLookups = Args.hasArg(new OptSpecifier(ID.OPT_ast_dump_lookups.getValue()));
    Opts.UseGlobalModuleIndex = !Args.hasArg(new OptSpecifier(ID.OPT_fno_modules_global_index.getValue()));
    Opts.GenerateGlobalModuleIndex = Opts.UseGlobalModuleIndex;
    $c$.clean(Opts.ModuleMapFiles.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fmodule_map_file.getValue())))));
    $c$.clean(Opts.ModuleFiles.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fmodule_file.getValue())))));
    $c$.clean(Opts.ModulesEmbedFiles.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fmodules_embed_file_EQ.getValue())))));
    Opts.ModulesEmbedAllFiles = Args.hasArg(new OptSpecifier(ID.OPT_fmodules_embed_all_files.getValue()));
    Opts.IncludeTimestamps = !Args.hasArg(new OptSpecifier(ID.OPT_fno_pch_timestamp.getValue()));
    
    Opts.CodeCompleteOpts.IncludeMacros
       = Args.hasArg(new OptSpecifier(ID.OPT_code_completion_macros.getValue()));
    Opts.CodeCompleteOpts.IncludeCodePatterns
       = Args.hasArg(new OptSpecifier(ID.OPT_code_completion_patterns.getValue()));
    Opts.CodeCompleteOpts.IncludeGlobals
       = !Args.hasArg(new OptSpecifier(ID.OPT_no_code_completion_globals.getValue()));
    Opts.CodeCompleteOpts.IncludeBriefComments
       = Args.hasArg(new OptSpecifier(ID.OPT_code_completion_brief_comments.getValue()));
    
    Opts.OverrideRecordLayoutsFile.$assignMove(
        Args.getLastArgValue(new OptSpecifier(ID.OPT_foverride_record_layout_EQ.getValue())).$string()
    );
    Opts.AuxTriple.$assignMove(
        Triple.normalize(Args.getLastArgValue(new OptSpecifier(ID.OPT_aux_triple.getValue())))
    );
    Opts.FindPchSource.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_find_pch_source_EQ.getValue())).$string());
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_arcmt_check.getValue()), 
          new OptSpecifier(ID.OPT_arcmt_modify.getValue()), 
          new OptSpecifier(ID.OPT_arcmt_migrate.getValue()));
      if ((A != null)) {
        switch (ID.valueOf(A.getOption().getID())) {
         default:
          throw new llvm_unreachable("missed a case");
         case OPT_arcmt_check:
          Opts.ARCMTAction = FrontendOptions.Unnamed_enum.ARCMT_Check;
          break;
         case OPT_arcmt_modify:
          Opts.ARCMTAction = FrontendOptions.Unnamed_enum.ARCMT_Modify;
          break;
         case OPT_arcmt_migrate:
          Opts.ARCMTAction = FrontendOptions.Unnamed_enum.ARCMT_Migrate;
          break;
        }
      }
    }
    Opts.MTMigrateDir.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_mt_migrate_directory.getValue())).$string());
    Opts.ARCMTMigrateReportOut.$assignMove(
        Args.getLastArgValue(new OptSpecifier(ID.OPT_arcmt_migrate_report_output.getValue())).$string()
    );
    Opts.ARCMTMigrateEmitARCErrors
       = Args.hasArg(new OptSpecifier(ID.OPT_arcmt_migrate_emit_arc_errors.getValue()));
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_literals.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_Literals;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_subscripting.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_Subscripting;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_property_dot_syntax.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_PropertyDotSyntax;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_property.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_Property;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_readonly_property.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_ReadonlyProperty;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_readwrite_property.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_ReadwriteProperty;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_annotation.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_Annotation;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_returns_innerpointer_property.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_ReturnsInnerPointerProperty;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_instancetype.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_Instancetype;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_nsmacros.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_NsMacros;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_protocol_conformance.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_ProtocolConformance;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_atomic_property.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_AtomicProperty;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_ns_nonatomic_iosonly.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_NsAtomicIOSOnlyProperty;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_designated_init.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_DesignatedInitializer;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_objcmt_migrate_all.getValue()))) {
      Opts.ObjCMTAction |= FrontendOptions.ObjCMT_MigrateDecls;
    }
    
    Opts.ObjCMTWhiteListPath.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_objcmt_whitelist_dir_path.getValue())).$string());
    if (Opts.ARCMTAction != FrontendOptions.Unnamed_enum.ARCMT_None
       && Opts.ObjCMTAction != FrontendOptions.ObjCMT_None) {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
              /*KEEP_STR*/"ARC migration"), /*KEEP_STR*/"ObjC migration"));
    }
    
    InputKind DashX = InputKind.IK_None;
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_x.getValue()));
      if ((A != null)) {
        DashX = new StringSwitch<InputKind>(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"c", InputKind.IK_C).
            Case(/*KEEP_STR*/"cl", InputKind.IK_OpenCL).
            Case(/*KEEP_STR*/"cuda", InputKind.IK_CUDA).
            Case(/*KEEP_STR*/"c++", InputKind.IK_CXX).
            Case(/*KEEP_STR*/"objective-c", InputKind.IK_ObjC).
            Case(/*KEEP_STR*/"objective-c++", InputKind.IK_ObjCXX).
            Case(/*KEEP_STR*/"cpp-output", InputKind.IK_PreprocessedC).
            Case(/*KEEP_STR*/"assembler-with-cpp", InputKind.IK_Asm).
            Case(/*KEEP_STR*/"c++-cpp-output", InputKind.IK_PreprocessedCXX).
            Case(/*KEEP_STR*/"cuda-cpp-output", InputKind.IK_PreprocessedCuda).
            Case(/*KEEP_STR*/"objective-c-cpp-output", InputKind.IK_PreprocessedObjC).
            Case(/*KEEP_STR*/"objc-cpp-output", InputKind.IK_PreprocessedObjC).
            Case(/*KEEP_STR*/"objective-c++-cpp-output", InputKind.IK_PreprocessedObjCXX).
            Case(/*KEEP_STR*/"objc++-cpp-output", InputKind.IK_PreprocessedObjCXX).
            Case(/*KEEP_STR*/"c-header", InputKind.IK_C).
            Case(/*KEEP_STR*/"cl-header", InputKind.IK_OpenCL).
            Case(/*KEEP_STR*/"objective-c-header", InputKind.IK_ObjC).
            Case(/*KEEP_STR*/"c++-header", InputKind.IK_CXX).
            Case(/*KEEP_STR*/"objective-c++-header", InputKind.IK_ObjCXX).
            Cases(/*KEEP_STR*/"ast", /*KEEP_STR*/"pcm", InputKind.IK_AST).
            Case(/*KEEP_STR*/"ir", InputKind.IK_LLVM_IR).
            Case(/*KEEP_STR*/"renderscript", InputKind.IK_RenderScript).
            Default(InputKind.IK_None);
        if (DashX == InputKind.IK_None) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), A.getValue()));
        }
      }
    }
    
    // '-' is the default input if none is given.
    Inputs = Args.getAllArgValues(new OptSpecifier(ID.OPT_INPUT.getValue()));
    Opts.Inputs.clear();
    if (Inputs.empty()) {
      Inputs.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$MINUS));
    }
    for (/*uint*/int i = 0, e = Inputs.size(); i != e; ++i) {
      InputKind IK = DashX;
      if (IK == InputKind.IK_None) {
        IK = FrontendOptions.getInputKindForExtension(new StringRef(JD$Move.INSTANCE, new StringRef(Inputs.$at(i)).rsplit($$DOT).second));
        // FIXME: Remove this hack.
        if (i == 0) {
          DashX = IK;
        }
      }
      Opts.Inputs.emplace_back(new FrontendInputFile(new StringRef(Inputs.$at(i)), IK));
    }
    
    return DashX;
  } finally {
    if (Inputs != null) { Inputs.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="ParseHeaderSearchArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1351,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 1211,
 FQN="ParseHeaderSearchArgs", NM="_ZL21ParseHeaderSearchArgsRN5clang19HeaderSearchOptionsERN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL21ParseHeaderSearchArgsRN5clang19HeaderSearchOptionsERN4llvm3opt7ArgListE")
//</editor-fold>
public static void ParseHeaderSearchArgs(final HeaderSearchOptions /*&*/ Opts, final ArgList /*&*/ Args) {
  //JAVA: using namespace options;
  Opts.Sysroot.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_isysroot.getValue()), new StringRef(/*KEEP_STR*/$SLASH)).$string());
  Opts.Verbose = Args.hasArg(new OptSpecifier(ID.OPT_v.getValue()));
  Opts.UseBuiltinIncludes = !Args.hasArg(new OptSpecifier(ID.OPT_nobuiltininc.getValue()));
  Opts.UseStandardSystemIncludes = !Args.hasArg(new OptSpecifier(ID.OPT_nostdsysteminc.getValue()));
  Opts.UseStandardCXXIncludes = !Args.hasArg(new OptSpecifier(ID.OPT_nostdincxx.getValue()));
  {
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_stdlib_EQ.getValue()));
    if ((A != null)) {
      Opts.UseLibcxx = (strcmp(A.getValue(), /*KEEP_STR*/"libc++") == 0);
    }
  }
  Opts.ResourceDir.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_resource_dir.getValue())).$string());
  Opts.ModuleCachePath.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_fmodules_cache_path.getValue())).$string());
  Opts.ModuleUserBuildPath.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_fmodules_user_build_path.getValue())).$string());
  Opts.DisableModuleHash = Args.hasArg(new OptSpecifier(ID.OPT_fdisable_module_hash.getValue()));
  Opts.ImplicitModuleMaps = Args.hasArg(new OptSpecifier(ID.OPT_fimplicit_module_maps.getValue()));
  Opts.ModuleMapFileHomeIsCwd = Args.hasArg(new OptSpecifier(ID.OPT_fmodule_map_file_home_is_cwd.getValue()));
  Opts.ModuleCachePruneInterval
     = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_fmodules_prune_interval.getValue()), 7 * 24 * 60 * 60);
  Opts.ModuleCachePruneAfter
     = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_fmodules_prune_after.getValue()), 31 * 24 * 60 * 60);
  Opts.ModulesValidateOncePerBuildSession
     = Args.hasArg(new OptSpecifier(ID.OPT_fmodules_validate_once_per_build_session.getValue()));
  Opts.BuildSessionTimestamp
     = getLastArgUInt64Value$P(Args, new OptSpecifier(ID.OPT_fbuild_session_timestamp.getValue()), 0);
  Opts.ModulesValidateSystemHeaders
     = Args.hasArg(new OptSpecifier(ID.OPT_fmodules_validate_system_headers.getValue()));
  {
    /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_fmodule_format_EQ.getValue()));
    if ((A != null)) {
      Opts.ModuleFormat.$assign_T$C$P(A.getValue());
    }
  }
  
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_fmodules_ignore_macro.getValue()))) {
    StringRef MacroDef = new StringRef(A.getValue());
    Opts.ModulesIgnoreMacros.insert(MacroDef.split($$EQ).first.$string());
  }
  
  // Add -I..., -F..., and -index-header-map options in order.
  boolean IsIndexHeaderMap = false;
  boolean IsSysrootSpecified = Args.hasArg(new OptSpecifier(ID.OPT__sysroot_EQ.getValue())) || Args.hasArg(new OptSpecifier(ID.OPT_isysroot.getValue()));
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_I.getValue()), new OptSpecifier(ID.OPT_F.getValue()), new OptSpecifier(ID.OPT_index_header_map.getValue()))) {
    if (A.getOption().matches(new OptSpecifier(ID.OPT_index_header_map.getValue()))) {
      // -index-header-map applies to the next -I or -F.
      IsIndexHeaderMap = true;
      continue;
    }
    
    IncludeDirGroup Group = IsIndexHeaderMap ? IncludeDirGroup.IndexHeaderMap : IncludeDirGroup.Angled;
    
    boolean IsFramework = A.getOption().matches(new OptSpecifier(ID.OPT_F.getValue()));
    std.string Path = new std.string(JD$T$C$P_T2$C$R.INSTANCE, A.getValue());
    if (IsSysrootSpecified && !IsFramework && A.getValue().$at(0) == $$EQ) {
      SmallString/*32*/ Buffer/*J*/= new SmallString/*32*/(32);
      path.append(Buffer, new Twine(Opts.Sysroot), 
          new Twine(new StringRef(A.getValue()).substr(1)));
      Path.$assignMove(Buffer.str().$string());
    }
    
    Opts.AddPath(new StringRef(Path.c_str()), Group, IsFramework, 
        /*IgnoreSysroot*/ true);
    IsIndexHeaderMap = false;
  }
  
  // Add -iprefix/-iwithprefix/-iwithprefixbefore options.
  StringRef Prefix = new StringRef(/*KEEP_STR*/$EMPTY); // FIXME: This isn't the correct default prefix.
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_iprefix.getValue()), new OptSpecifier(ID.OPT_iwithprefix.getValue()), new OptSpecifier(ID.OPT_iwithprefixbefore.getValue()))) {
    if (A.getOption().matches(new OptSpecifier(ID.OPT_iprefix.getValue()))) {
      Prefix.$assignMove(/*STRINGREF_STR*/A.getValue());
    } else if (A.getOption().matches(new OptSpecifier(ID.OPT_iwithprefix.getValue()))) {
      Opts.AddPath(new StringRef($add_string_T$C$P(Prefix.str(), A.getValue())), IncludeDirGroup.After, false, true);
    } else {
      Opts.AddPath(new StringRef($add_string_T$C$P(Prefix.str(), A.getValue())), IncludeDirGroup.Angled, false, true);
    }
  }
  
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_idirafter.getValue())))  {
    Opts.AddPath(new StringRef(A.getValue()), IncludeDirGroup.After, false, true);
  }
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_iquote.getValue())))  {
    Opts.AddPath(new StringRef(A.getValue()), IncludeDirGroup.Quoted, false, true);
  }
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_isystem.getValue()), new OptSpecifier(ID.OPT_iwithsysroot.getValue())))  {
    Opts.AddPath(new StringRef(A.getValue()), IncludeDirGroup.System, false, 
        !A.getOption().matches(new OptSpecifier(ID.OPT_iwithsysroot.getValue())));
  }
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_iframework.getValue())))  {
    Opts.AddPath(new StringRef(A.getValue()), IncludeDirGroup.System, true, true);
  }
  
  // Add the paths for the various language specific isystem flags.
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_c_isystem.getValue())))  {
    Opts.AddPath(new StringRef(A.getValue()), IncludeDirGroup.CSystem, false, true);
  }
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_cxx_isystem.getValue())))  {
    Opts.AddPath(new StringRef(A.getValue()), IncludeDirGroup.CXXSystem, false, true);
  }
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_objc_isystem.getValue())))  {
    Opts.AddPath(new StringRef(A.getValue()), IncludeDirGroup.ObjCSystem, false, true);
  }
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_objcxx_isystem.getValue())))  {
    Opts.AddPath(new StringRef(A.getValue()), IncludeDirGroup.ObjCXXSystem, false, true);
  }
  
  // Add the internal paths from a driver that detects standard include paths.
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_internal_isystem.getValue()), new OptSpecifier(ID.OPT_internal_externc_isystem.getValue()))) {
    IncludeDirGroup Group = IncludeDirGroup.System;
    if (A.getOption().matches(new OptSpecifier(ID.OPT_internal_externc_isystem.getValue()))) {
      Group = IncludeDirGroup.ExternCSystem;
    }
    Opts.AddPath(new StringRef(A.getValue()), Group, false, true);
  }
  
  // Add the path prefixes which are implicitly treated as being system headers.
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_system_header_prefix.getValue()), new OptSpecifier(ID.OPT_no_system_header_prefix.getValue())))  {
    Opts.AddSystemHeaderPrefix(new StringRef(A.getValue()), A.getOption().matches(new OptSpecifier(ID.OPT_system_header_prefix.getValue())));
  }
  
  for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_ivfsoverlay.getValue())))  {
    Opts.AddVFSOverlayFile(new StringRef(A.getValue()));
  }
}

//<editor-fold defaultstate="collapsed" desc="isOpenCL">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1464,
 FQN="isOpenCL", NM="_Z8isOpenCLN5clang12LangStandard4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_Z8isOpenCLN5clang12LangStandard4KindE")
//</editor-fold>
public static boolean isOpenCL(LangStandard.Kind LangStd) {
  return LangStd == LangStandard.Kind.lang_opencl
     || LangStd == LangStandard.Kind.lang_opencl11
     || LangStd == LangStandard.Kind.lang_opencl12
     || LangStd == LangStandard.Kind.lang_opencl20;
}


/// Attempt to parse a visibility value out of the given argument.
//<editor-fold defaultstate="collapsed" desc="parseVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1589,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 1410,
 FQN="parseVisibility", NM="_ZL15parseVisibilityPN4llvm3opt3ArgERNS0_7ArgListERN5clang17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL15parseVisibilityPN4llvm3opt3ArgERNS0_7ArgListERN5clang17DiagnosticsEngineE")
//</editor-fold>
public static Visibility parseVisibility(Arg /*P*/ arg, final ArgList /*&*/ args, 
               final DiagnosticsEngine /*&*/ diags) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    StringRef value = new StringRef(arg.getValue());
    if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"default")) {
      return Visibility.DefaultVisibility;
    } else if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"hidden") || $eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"internal")) {
      return Visibility.HiddenVisibility;
    } else if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"protected")) {
      // FIXME: diagnose if target does not support protected visibility
      return Visibility.ProtectedVisibility;
    }
    
    $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(diags.Report(diag.err_drv_invalid_value)), 
            new StringRef(arg.getAsString(args))), /*NO_COPY*/value));
    return Visibility.DefaultVisibility;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="ParseLangArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1606,
 FQN="ParseLangArgs", NM="_ZL13ParseLangArgsRN5clang11LangOptionsERN4llvm3opt7ArgListENS_9InputKindERKNS_13TargetOptionsERNS_19PreprocessorOptionsERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL13ParseLangArgsRN5clang11LangOptionsERN4llvm3opt7ArgListENS_9InputKindERKNS_13TargetOptionsERNS_19PreprocessorOptionsERNS_17DiagnosticsEngineE")
//</editor-fold>
public static void ParseLangArgs(final LangOptions /*&*/ Opts, final ArgList /*&*/ Args, InputKind IK, 
             final /*const*/ TargetOptions /*&*/ TargetOpts, 
             final PreprocessorOptions /*&*/ PPOpts, 
             final DiagnosticsEngine /*&*/ Diags) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // FIXME: Cleanup per-file based stuff.
    LangStandard.Kind LangStd = LangStandard.Kind.lang_unspecified;
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_std_EQ.getValue()));
      if ((A != null)) {
        LangStd = new StringSwitch<LangStandard.Kind>(/*STRINGREF_STR*/A.getValue()).
            // C89-ish modes.
            Case(/*KEEP_STR*/"c89", LangStandard.Kind.lang_c89).
            Case(/*KEEP_STR*/"c90", LangStandard.Kind.lang_c90).
            Case(/*KEEP_STR*/"iso9899:1990", LangStandard.Kind.lang_iso9899_1990).
            Case(/*KEEP_STR*/"iso9899:199409", LangStandard.Kind.lang_c94).
            Case(/*KEEP_STR*/"gnu89", LangStandard.Kind.lang_gnu89).
            Case(/*KEEP_STR*/"gnu90", LangStandard.Kind.lang_gnu90).
            
            // C99-ish modes
            Case(/*KEEP_STR*/"c99", LangStandard.Kind.lang_c99).
            Case(/*KEEP_STR*/"c9x", LangStandard.Kind.lang_c9x).
            Case(/*KEEP_STR*/"iso9899:1999", LangStandard.Kind.lang_iso9899_1999).
            Case(/*KEEP_STR*/"iso9899:199x", LangStandard.Kind.lang_iso9899_199x).
            Case(/*KEEP_STR*/"gnu99", LangStandard.Kind.lang_gnu99).
            Case(/*KEEP_STR*/"gnu9x", LangStandard.Kind.lang_gnu9x).
            
            // C11 modes
            Case(/*KEEP_STR*/"c11", LangStandard.Kind.lang_c11).
            Case(/*KEEP_STR*/"c1x", LangStandard.Kind.lang_c1x).
            Case(/*KEEP_STR*/"iso9899:2011", LangStandard.Kind.lang_iso9899_2011).
            Case(/*KEEP_STR*/"iso9899:2011", LangStandard.Kind.lang_iso9899_201x).
            Case(/*KEEP_STR*/"gnu11", LangStandard.Kind.lang_gnu11).
            Case(/*KEEP_STR*/"gnu1x", LangStandard.Kind.lang_gnu1x).
            
            // C++ modes
            Case(/*KEEP_STR*/"c++98", LangStandard.Kind.lang_cxx98).
            Case(/*KEEP_STR*/"c++03", LangStandard.Kind.lang_cxx03).
            Case(/*KEEP_STR*/"gnu++98", LangStandard.Kind.lang_gnucxx98).
            Case(/*KEEP_STR*/"c++0x", LangStandard.Kind.lang_cxx0x).
            Case(/*KEEP_STR*/"c++11", LangStandard.Kind.lang_cxx11).
            Case(/*KEEP_STR*/"gnu++0x", LangStandard.Kind.lang_gnucxx0x).
            Case(/*KEEP_STR*/"gnu++11", LangStandard.Kind.lang_gnucxx11).
            Case(/*KEEP_STR*/"c++1y", LangStandard.Kind.lang_cxx1y).
            Case(/*KEEP_STR*/"c++14", LangStandard.Kind.lang_cxx14).
            Case(/*KEEP_STR*/"gnu++1y", LangStandard.Kind.lang_gnucxx1y).
            Case(/*KEEP_STR*/"gnu++14", LangStandard.Kind.lang_gnucxx14).
            Case(/*KEEP_STR*/"c++1z", LangStandard.Kind.lang_cxx1z).
            Case(/*KEEP_STR*/"gnu++1z", LangStandard.Kind.lang_gnucxx1z).
            
            // OpenCL
            Case(/*KEEP_STR*/"cl", LangStandard.Kind.lang_opencl).
            Case(/*KEEP_STR*/"cl1.1", LangStandard.Kind.lang_opencl11).
            Case(/*KEEP_STR*/"cl1.2", LangStandard.Kind.lang_opencl12).
            Case(/*KEEP_STR*/"cl2.0", LangStandard.Kind.lang_opencl20).
            Case(/*KEEP_STR*/"CL", LangStandard.Kind.lang_opencl).
            Case(/*KEEP_STR*/"CL1.1", LangStandard.Kind.lang_opencl11).
            Case(/*KEEP_STR*/"CL1.2", LangStandard.Kind.lang_opencl12).
            Case(/*KEEP_STR*/"CL2.0", LangStandard.Kind.lang_opencl20).
            
            // CUDA
            Case(/*KEEP_STR*/"cuda", LangStandard.Kind.lang_cuda).
            Default(LangStandard.Kind.lang_unspecified);
        if (LangStd == LangStandard.Kind.lang_unspecified) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), A.getValue()));
        } else {
          // Valid standard, check to make sure language and standard are
          // compatible.
          final /*const*/ LangStandard /*&*/ Std = LangStandard.getLangStandardForKind(LangStd);
          switch (IK) {
           case IK_C:
           case IK_ObjC:
           case IK_PreprocessedC:
           case IK_PreprocessedObjC:
            if (!(Std.isC89() || Std.isC99())) {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
                      new StringRef(A.getAsString(Args))), /*KEEP_STR*/"C/ObjC"));
            }
            break;
           case IK_CXX:
           case IK_ObjCXX:
           case IK_PreprocessedCXX:
           case IK_PreprocessedObjCXX:
            if (!Std.isCPlusPlus()) {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
                      new StringRef(A.getAsString(Args))), /*KEEP_STR*/"C++/ObjC++"));
            }
            break;
           case IK_OpenCL:
            if (!isOpenCL(LangStd)) {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
                      new StringRef(A.getAsString(Args))), /*KEEP_STR*/"OpenCL"));
            }
            break;
           case IK_CUDA:
           case IK_PreprocessedCuda:
            if (!Std.isCPlusPlus()) {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
                      new StringRef(A.getAsString(Args))), /*KEEP_STR*/"CUDA"));
            }
            break;
           default:
            break;
          }
        }
      }
    }
    {
      
      // -cl-std only applies for OpenCL language standards.
      // Override the -std option in this case.
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_cl_std_EQ.getValue()));
      if ((A != null)) {
        LangStandard.Kind OpenCLLangStd = new StringSwitch<LangStandard.Kind>(/*STRINGREF_STR*/A.getValue()).
            Cases(/*KEEP_STR*/"cl", /*KEEP_STR*/"CL", LangStandard.Kind.lang_opencl).
            Cases(/*KEEP_STR*/"cl1.1", /*KEEP_STR*/"CL1.1", LangStandard.Kind.lang_opencl11).
            Cases(/*KEEP_STR*/"cl1.2", /*KEEP_STR*/"CL1.2", LangStandard.Kind.lang_opencl12).
            Cases(/*KEEP_STR*/"cl2.0", /*KEEP_STR*/"CL2.0", LangStandard.Kind.lang_opencl20).
            Default(LangStandard.Kind.lang_unspecified);
        if (OpenCLLangStd == LangStandard.Kind.lang_unspecified) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  new StringRef(A.getAsString(Args))), A.getValue()));
        } else {
          LangStd = OpenCLLangStd;
        }
      }
    }
    
    Opts.IncludeDefaultHeader = Args.hasArg(new OptSpecifier(ID.OPT_finclude_default_header.getValue()));
    
    Triple T/*J*/= new Triple(new Twine(TargetOpts.Triple));
    CompilerInvocation.setLangDefaults(Opts, IK, T, PPOpts, LangStd);
    
    // -cl-strict-aliasing needs to emit diagnostic in the case where CL > 1.0.
    // This option should be deprecated for CL > 1.0 because
    // this option was added for compatibility with OpenCL 1.0.
    if ((Args.getLastArg(new OptSpecifier(ID.OPT_cl_strict_aliasing.getValue())) != null)
       && $greater_uint(Opts.OpenCLVersion, 100)) {
      std.string VerSpec = $add_string_string$C($add_string$C_string(llvm.to_string($div_uint(Opts.OpenCLVersion, 100)), 
              new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$DOT)), 
          llvm.to_string($div_uint(($rem_uint(Opts.OpenCLVersion, 100)), 10)));
      $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.warn_option_invalid_ocl_version)), 
              new StringRef(VerSpec)), new StringRef(Args.getLastArg(new OptSpecifier(ID.OPT_cl_strict_aliasing.getValue())).getAsString(Args))));
    }
    
    // We abuse '-f[no-]gnu-keywords' to force overriding all GNU-extension
    // keywords. This behavior is provided by GCC's poorly named '-fasm' flag,
    // while a subset (the non-C++ GNU keywords) is provided by GCC's
    // '-fgnu-keywords'. Clang conflates the two for simplicity under the single
    // name, as it doesn't seem a useful distinction.
    Opts.GNUKeywords = Args.hasFlag(new OptSpecifier(ID.OPT_fgnu_keywords.getValue()), new OptSpecifier(ID.OPT_fno_gnu_keywords.getValue()), 
        Opts.GNUKeywords);
    if (Args.hasArg(new OptSpecifier(ID.OPT_fno_operator_names.getValue()))) {
      Opts.CXXOperatorNames = false;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fcuda_is_device.getValue()))) {
      Opts.CUDAIsDevice = true;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fcuda_allow_variadic_functions.getValue()))) {
      Opts.CUDAAllowVariadicFunctions = true;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fno_cuda_host_device_constexpr.getValue()))) {
      Opts.CUDAHostDeviceConstexpr = false;
    }
    if (Opts.CUDAIsDevice && Args.hasArg(new OptSpecifier(ID.OPT_fcuda_flush_denormals_to_zero.getValue()))) {
      Opts.CUDADeviceFlushDenormalsToZero = true;
    }
    if (Opts.CUDAIsDevice && Args.hasArg(new OptSpecifier(ID.OPT_fcuda_approx_transcendentals.getValue()))) {
      Opts.CUDADeviceApproxTranscendentals = true;
    }
    if (Opts.ObjC1) {
      {
        Arg /*P*/ arg = Args.getLastArg(new OptSpecifier(ID.OPT_fobjc_runtime_EQ.getValue()));
        if ((arg != null)) {
          StringRef value = new StringRef(arg.getValue());
          if (Opts.ObjCRuntime.tryParse(new StringRef(value))) {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_unknown_objc_runtime)), /*NO_COPY*/value));
          }
        }
      }
      if (Args.hasArg(new OptSpecifier(ID.OPT_fobjc_gc_only.getValue()))) {
        Opts.setGC(LangOptions.GCMode.GCOnly);
      } else if (Args.hasArg(new OptSpecifier(ID.OPT_fobjc_gc.getValue()))) {
        Opts.setGC(LangOptions.GCMode.HybridGC);
      } else if (Args.hasArg(new OptSpecifier(ID.OPT_fobjc_arc.getValue()))) {
        Opts.ObjCAutoRefCount = true;
        if (!Opts.ObjCRuntime.allowsARC()) {
          $c$.clean($c$.track(Diags.Report(diag.err_arc_unsupported_on_runtime)));
        }
      }
      
      // ObjCWeakRuntime tracks whether the runtime supports __weak, not
      // whether the feature is actually enabled.  This is predominantly
      // determined by -fobjc-runtime, but we allow it to be overridden
      // from the command line for testing purposes.
      if (Args.hasArg(new OptSpecifier(ID.OPT_fobjc_runtime_has_weak.getValue()))) {
        Opts.ObjCWeakRuntime = true;
      } else {
        Opts.ObjCWeakRuntime = Opts.ObjCRuntime.allowsWeak();
      }
      {
        
        // ObjCWeak determines whether __weak is actually enabled.
        // Note that we allow -fno-objc-weak to disable this even in ARC mode.
        Arg /*P*/ weakArg = Args.getLastArg(new OptSpecifier(ID.OPT_fobjc_weak.getValue()), new OptSpecifier(ID.OPT_fno_objc_weak.getValue()));
        if ((weakArg != null)) {
          if (!weakArg.getOption().matches(new OptSpecifier(ID.OPT_fobjc_weak.getValue()))) {
            assert (!Opts.ObjCWeak);
          } else if (Opts.getGC() != LangOptions.GCMode.NonGC) {
            $c$.clean($c$.track(Diags.Report(diag.err_objc_weak_with_gc)));
          } else if (!Opts.ObjCWeakRuntime) {
            $c$.clean($c$.track(Diags.Report(diag.err_objc_weak_unsupported)));
          } else {
            Opts.ObjCWeak = true;
          }
        } else if (Opts.ObjCAutoRefCount) {
          Opts.ObjCWeak = Opts.ObjCWeakRuntime;
        }
      }
      if (Args.hasArg(new OptSpecifier(ID.OPT_fno_objc_infer_related_result_type.getValue()))) {
        Opts.ObjCInferRelatedResultType = false;
      }
      if (Args.hasArg(new OptSpecifier(ID.OPT_fobjc_subscripting_legacy_runtime.getValue()))) {
        Opts.ObjCSubscriptingLegacyRuntime
           = (Opts.ObjCRuntime.getKind() == ObjCRuntime.Kind.FragileMacOSX);
      }
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fgnu89_inline.getValue()))) {
      if (Opts.CPlusPlus) {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), /*KEEP_STR*/"-fgnu89-inline"), 
            /*KEEP_STR*/"C++/ObjC++"));
      } else {
        Opts.GNUInline = true;
      }
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fapple_kext.getValue()))) {
      if (!Opts.CPlusPlus) {
        $c$.clean($c$.track(Diags.Report(diag.warn_c_kext)));
      } else {
        Opts.AppleKext = true;
      }
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_print_ivar_layout.getValue()))) {
      Opts.ObjCGCBitmapPrint = true;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fno_constant_cfstrings.getValue()))) {
      Opts.NoConstantCFStrings = true;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_faltivec.getValue()))) {
      Opts.AltiVec = true;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fzvector.getValue()))) {
      Opts.ZVector = true;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_pthread.getValue()))) {
      Opts.POSIXThreads = true;
    }
    {
      
      // The value-visibility mode defaults to "default".
      Arg /*P*/ visOpt = Args.getLastArg(new OptSpecifier(ID.OPT_fvisibility.getValue()));
      if ((visOpt != null)) {
        Opts.setValueVisibilityMode(parseVisibility(visOpt, Args, Diags));
      } else {
        Opts.setValueVisibilityMode(Visibility.DefaultVisibility);
      }
    }
    {
      
      // The type-visibility mode defaults to the value-visibility mode.
      Arg /*P*/ typeVisOpt = Args.getLastArg(new OptSpecifier(ID.OPT_ftype_visibility.getValue()));
      if ((typeVisOpt != null)) {
        Opts.setTypeVisibilityMode(parseVisibility(typeVisOpt, Args, Diags));
      } else {
        Opts.setTypeVisibilityMode(Opts.getValueVisibilityMode());
      }
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fvisibility_inlines_hidden.getValue()))) {
      Opts.InlineVisibilityHidden = true;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_ftrapv.getValue()))) {
      Opts.setSignedOverflowBehavior(LangOptions.SignedOverflowBehaviorTy.SOB_Trapping);
      // Set the handler, if one is specified.
      Opts.OverflowHandler.$assignMove(
          Args.getLastArgValue(new OptSpecifier(ID.OPT_ftrapv_handler.getValue())).$string()
      );
    } else if (Args.hasArg(new OptSpecifier(ID.OPT_fwrapv.getValue()))) {
      Opts.setSignedOverflowBehavior(LangOptions.SignedOverflowBehaviorTy.SOB_Defined);
    }
    
    Opts.MSVCCompat = Args.hasArg(new OptSpecifier(ID.OPT_fms_compatibility.getValue()));
    Opts.MicrosoftExt = Opts.MSVCCompat || Args.hasArg(new OptSpecifier(ID.OPT_fms_extensions.getValue()));
    Opts.AsmBlocks = Args.hasArg(new OptSpecifier(ID.OPT_fasm_blocks.getValue())) || Opts.MicrosoftExt;
    Opts.MSCompatibilityVersion = 0;
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_fms_compatibility_version.getValue()));
      if ((A != null)) {
        VersionTuple VT/*J*/= new VersionTuple();
        if (VT.tryParse(/*STRINGREF_STR*/A.getValue())) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), 
              A.getValue()));
        }
        Opts.MSCompatibilityVersion = VT.getMajor() * 10000000
           + VT.getMinor().getValueOr_T$RR(0) * 100000
           + VT.getSubminor().getValueOr_T$RR(0);
      }
    }
    
    // Mimicing gcc's behavior, trigraphs are only enabled if -trigraphs
    // is specified, or -std is set to a conforming mode.
    // Trigraphs are disabled by default in c++1z onwards.
    Opts.Trigraphs = !Opts.GNUMode && !Opts.MSVCCompat && !Opts.CPlusPlus1z;
    Opts.Trigraphs
       = Args.hasFlag(new OptSpecifier(ID.OPT_ftrigraphs.getValue()), new OptSpecifier(ID.OPT_fno_trigraphs.getValue()), Opts.Trigraphs);
    
    Opts.DollarIdents = Args.hasFlag(new OptSpecifier(ID.OPT_fdollars_in_identifiers.getValue()), 
        new OptSpecifier(ID.OPT_fno_dollars_in_identifiers.getValue()), 
        Opts.DollarIdents);
    Opts.PascalStrings = Args.hasArg(new OptSpecifier(ID.OPT_fpascal_strings.getValue()));
    Opts.VtorDispMode = $uint2uint_2bits(getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_vtordisp_mode_EQ.getValue()), 1, Diags));
    Opts.Borland = Args.hasArg(new OptSpecifier(ID.OPT_fborland_extensions.getValue()));
    Opts.WritableStrings = Args.hasArg(new OptSpecifier(ID.OPT_fwritable_strings.getValue()));
    Opts.ConstStrings = Args.hasFlag(new OptSpecifier(ID.OPT_fconst_strings.getValue()), new OptSpecifier(ID.OPT_fno_const_strings.getValue()), 
        Opts.ConstStrings);
    if (Args.hasArg(new OptSpecifier(ID.OPT_fno_lax_vector_conversions.getValue()))) {
      Opts.LaxVectorConversions = false;
    }
    if (Args.hasArg(new OptSpecifier(ID.OPT_fno_threadsafe_statics.getValue()))) {
      Opts.ThreadsafeStatics = false;
    }
    Opts.Exceptions = Args.hasArg(new OptSpecifier(ID.OPT_fexceptions.getValue()));
    Opts.ObjCExceptions = Args.hasArg(new OptSpecifier(ID.OPT_fobjc_exceptions.getValue()));
    Opts.CXXExceptions = Args.hasArg(new OptSpecifier(ID.OPT_fcxx_exceptions.getValue()));
    Opts.SjLjExceptions = Args.hasArg(new OptSpecifier(ID.OPT_fsjlj_exceptions.getValue()));
    Opts.ExternCNoUnwind = Args.hasArg(new OptSpecifier(ID.OPT_fexternc_nounwind.getValue()));
    Opts.TraditionalCPP = Args.hasArg(new OptSpecifier(ID.OPT_traditional_cpp.getValue()));
    
    Opts.RTTI = Opts.CPlusPlus && !Args.hasArg(new OptSpecifier(ID.OPT_fno_rtti.getValue()));
    Opts.RTTIData = Opts.RTTI && !Args.hasArg(new OptSpecifier(ID.OPT_fno_rtti_data.getValue()));
    Opts.Blocks = Args.hasArg(new OptSpecifier(ID.OPT_fblocks.getValue())) || (Opts.OpenCL
       && $greatereq_uint(Opts.OpenCLVersion, 200));
    Opts.BlocksRuntimeOptional = Args.hasArg(new OptSpecifier(ID.OPT_fblocks_runtime_optional.getValue()));
    Opts.Coroutines = Args.hasArg(new OptSpecifier(ID.OPT_fcoroutines.getValue()));
    Opts.Modules = Args.hasArg(new OptSpecifier(ID.OPT_fmodules.getValue()));
    Opts.ModulesStrictDeclUse = Args.hasArg(new OptSpecifier(ID.OPT_fmodules_strict_decluse.getValue()));
    Opts.ModulesDeclUse
       = Args.hasArg(new OptSpecifier(ID.OPT_fmodules_decluse.getValue())) || Opts.ModulesStrictDeclUse;
    Opts.ModulesLocalVisibility
       = Args.hasArg(new OptSpecifier(ID.OPT_fmodules_local_submodule_visibility.getValue()));
    Opts.ModulesSearchAll = Opts.Modules
       && !Args.hasArg(new OptSpecifier(ID.OPT_fno_modules_search_all.getValue()))
       && Args.hasArg(new OptSpecifier(ID.OPT_fmodules_search_all.getValue()));
    Opts.ModulesErrorRecovery = !Args.hasArg(new OptSpecifier(ID.OPT_fno_modules_error_recovery.getValue()));
    Opts.ImplicitModules = !Args.hasArg(new OptSpecifier(ID.OPT_fno_implicit_modules.getValue()));
    Opts.CharIsSigned = Opts.OpenCL || !Args.hasArg(new OptSpecifier(ID.OPT_fno_signed_char.getValue()));
    Opts.WChar = Opts.CPlusPlus && !Args.hasArg(new OptSpecifier(ID.OPT_fno_wchar.getValue()));
    Opts.ShortWChar = Args.hasFlag(new OptSpecifier(ID.OPT_fshort_wchar.getValue()), new OptSpecifier(ID.OPT_fno_short_wchar.getValue()), false);
    Opts.ShortEnums = Args.hasArg(new OptSpecifier(ID.OPT_fshort_enums.getValue()));
    Opts.Freestanding = Args.hasArg(new OptSpecifier(ID.OPT_ffreestanding.getValue()));
    Opts.NoBuiltin = Args.hasArg(new OptSpecifier(ID.OPT_fno_builtin.getValue())) || Opts.Freestanding;
    if (!Opts.NoBuiltin) {
      getAllNoBuiltinFuncValues(Args, Opts.NoBuiltinFuncs);
    }
    Opts.NoMathBuiltin = Args.hasArg(new OptSpecifier(ID.OPT_fno_math_builtin.getValue()));
    Opts.SizedDeallocation = Args.hasArg(new OptSpecifier(ID.OPT_fsized_deallocation.getValue()));
    Opts.ConceptsTS = Args.hasArg(new OptSpecifier(ID.OPT_fconcepts_ts.getValue()));
    Opts.HeinousExtensions = Args.hasArg(new OptSpecifier(ID.OPT_fheinous_gnu_extensions.getValue()));
    Opts.AccessControl = !Args.hasArg(new OptSpecifier(ID.OPT_fno_access_control.getValue()));
    Opts.ElideConstructors = !Args.hasArg(new OptSpecifier(ID.OPT_fno_elide_constructors.getValue()));
    Opts.MathErrno = !Opts.OpenCL && Args.hasArg(new OptSpecifier(ID.OPT_fmath_errno.getValue()));
    Opts.InstantiationDepth
       = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_ftemplate_depth.getValue()), 256, Diags);
    Opts.ArrowDepth
       = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_foperator_arrow_depth.getValue()), 256, Diags);
    Opts.ConstexprCallDepth
       = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fconstexpr_depth.getValue()), 512, Diags);
    Opts.ConstexprStepLimit
       = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fconstexpr_steps.getValue()), 1048576, Diags);
    Opts.BracketDepth = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fbracket_depth.getValue()), 256, Diags);
    Opts.DelayedTemplateParsing = Args.hasArg(new OptSpecifier(ID.OPT_fdelayed_template_parsing.getValue()));
    Opts.NumLargeByValueCopy
       = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_Wlarge_by_value_copy_EQ.getValue()), 0, Diags);
    Opts.MSBitfields = Args.hasArg(new OptSpecifier(ID.OPT_mms_bitfields.getValue()));
    Opts.ObjCConstantStringClass.$assignMove(
        Args.getLastArgValue(new OptSpecifier(ID.OPT_fconstant_string_class.getValue())).$string()
    );
    Opts.ObjCDefaultSynthProperties
       = !Args.hasArg(new OptSpecifier(ID.OPT_disable_objc_default_synthesize_properties.getValue()));
    Opts.EncodeExtendedBlockSig
       = Args.hasArg(new OptSpecifier(ID.OPT_fencode_extended_block_signature.getValue()));
    Opts.EmitAllDecls = Args.hasArg(new OptSpecifier(ID.OPT_femit_all_decls.getValue()));
    Opts.PackStruct = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fpack_struct_EQ.getValue()), 0, Diags);
    Opts.MaxTypeAlign = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fmax_type_align_EQ.getValue()), 0, Diags);
    Opts.AlignDouble = Args.hasArg(new OptSpecifier(ID.OPT_malign_double.getValue()));
    Opts.PICLevel = $uint2uint_2bits(getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_pic_level.getValue()), 0, Diags));
    Opts.PIE = Args.hasArg(new OptSpecifier(ID.OPT_pic_is_pie.getValue()));
    Opts.Static = Args.hasArg(new OptSpecifier(ID.OPT_static_define.getValue()));
    Opts.DumpRecordLayoutsSimple = Args.hasArg(new OptSpecifier(ID.OPT_fdump_record_layouts_simple.getValue()));
    Opts.DumpRecordLayouts = Opts.DumpRecordLayoutsSimple
       || Args.hasArg(new OptSpecifier(ID.OPT_fdump_record_layouts.getValue()));
    Opts.DumpVTableLayouts = Args.hasArg(new OptSpecifier(ID.OPT_fdump_vtable_layouts.getValue()));
    Opts.SpellChecking = !Args.hasArg(new OptSpecifier(ID.OPT_fno_spell_checking.getValue()));
    Opts.NoBitFieldTypeAlign = Args.hasArg(new OptSpecifier(ID.OPT_fno_bitfield_type_align.getValue()));
    Opts.SinglePrecisionConstants = Args.hasArg(new OptSpecifier(ID.OPT_cl_single_precision_constant.getValue()));
    Opts.FastRelaxedMath = Args.hasArg(new OptSpecifier(ID.OPT_cl_fast_relaxed_math.getValue()));
    Opts.HexagonQdsp6Compat = Args.hasArg(new OptSpecifier(ID.OPT_mqdsp6_compat.getValue()));
    Opts.FakeAddressSpaceMap = Args.hasArg(new OptSpecifier(ID.OPT_ffake_address_space_map.getValue()));
    Opts.ParseUnknownAnytype = Args.hasArg(new OptSpecifier(ID.OPT_funknown_anytype.getValue()));
    Opts.DebuggerSupport = Args.hasArg(new OptSpecifier(ID.OPT_fdebugger_support.getValue()));
    Opts.DebuggerCastResultToId = Args.hasArg(new OptSpecifier(ID.OPT_fdebugger_cast_result_to_id.getValue()));
    Opts.DebuggerObjCLiteral = Args.hasArg(new OptSpecifier(ID.OPT_fdebugger_objc_literal.getValue()));
    Opts.ApplePragmaPack = Args.hasArg(new OptSpecifier(ID.OPT_fapple_pragma_pack.getValue()));
    Opts.CurrentModule.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_fmodule_name_EQ.getValue())).$string());
    Opts.AppExt = Args.hasArg(new OptSpecifier(ID.OPT_fapplication_extension.getValue()));
    $c$.clean(Opts.ModuleFeatures.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fmodule_feature.getValue())))));
    std.sort(Opts.ModuleFeatures.begin(), Opts.ModuleFeatures.end());
    Opts.NativeHalfType |= Args.hasArg(new OptSpecifier(ID.OPT_fnative_half_type.getValue()));
    Opts.NativeHalfArgsAndReturns |= Args.hasArg(new OptSpecifier(ID.OPT_fnative_half_arguments_and_returns.getValue()));
    // Enable HalfArgsAndReturns if present in Args or if NativeHalfArgsAndReturns
    // is enabled.
    Opts.HalfArgsAndReturns = $uint2uint_1bit(Args.hasArg(new OptSpecifier(ID.OPT_fallow_half_arguments_and_returns.getValue()))
       | Opts.NativeHalfArgsAndReturns);
    Opts.GNUAsm = !Args.hasArg(new OptSpecifier(ID.OPT_fno_gnu_inline_asm.getValue()));
    
    // __declspec is enabled by default for the PS4 by the driver, and also
    // enabled for Microsoft Extensions or Borland Extensions, here.
    //
    // FIXME: __declspec is also currently enabled for CUDA, but isn't really a
    // CUDA extension, however it is required for supporting cuda_builtin_vars.h,
    // which uses __declspec(property). Once that has been rewritten in terms of
    // something more generic, remove the Opts.CUDA term here.
    Opts.DeclSpecKeyword
       = Args.hasFlag(new OptSpecifier(ID.OPT_fdeclspec.getValue()), new OptSpecifier(ID.OPT_fno_declspec.getValue()), 
        (Opts.MicrosoftExt || Opts.Borland || Opts.CUDA));
    
    // For now, we only support local submodule visibility in C++ (because we
    // heavily depend on the ODR for merging redefinitions).
    if (Opts.ModulesLocalVisibility && !Opts.CPlusPlus) {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
              /*KEEP_STR*/"-fmodules-local-submodule-visibility"), /*KEEP_STR*/$C));
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_faddress_space_map_mangling_EQ.getValue()));
      if ((A != null)) {
        switch (LangOptions.AddrSpaceMapMangling.valueOf(new StringSwitchUInt(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"target", LangOptions.AddrSpaceMapMangling.ASMM_Target.getValue()).
            Case(/*KEEP_STR*/"no", LangOptions.AddrSpaceMapMangling.ASMM_Off.getValue()).
            Case(/*KEEP_STR*/"yes", LangOptions.AddrSpaceMapMangling.ASMM_On.getValue()).
            Default(255))) {
         default:
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  /*KEEP_STR*/"-faddress-space-map-mangling="), A.getValue()));
          break;
         case ASMM_Target:
          Opts.setAddressSpaceMapMangling(LangOptions.AddrSpaceMapMangling.ASMM_Target);
          break;
         case ASMM_On:
          Opts.setAddressSpaceMapMangling(LangOptions.AddrSpaceMapMangling.ASMM_On);
          break;
         case ASMM_Off:
          Opts.setAddressSpaceMapMangling(LangOptions.AddrSpaceMapMangling.ASMM_Off);
          break;
        }
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_fms_memptr_rep_EQ.getValue()));
      if ((A != null)) {
        LangOptions.PragmaMSPointersToMembersKind InheritanceModel = new StringSwitch<LangOptions.PragmaMSPointersToMembersKind>(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"single", 
            LangOptions.PragmaMSPointersToMembersKind.PPTMK_FullGeneralitySingleInheritance).
            Case(/*KEEP_STR*/"multiple", 
            LangOptions.PragmaMSPointersToMembersKind.PPTMK_FullGeneralityMultipleInheritance).
            Case(/*KEEP_STR*/"virtual", 
            LangOptions.PragmaMSPointersToMembersKind.PPTMK_FullGeneralityVirtualInheritance).
            Default(LangOptions.PragmaMSPointersToMembersKind.PPTMK_BestCase);
        if (InheritanceModel == LangOptions.PragmaMSPointersToMembersKind.PPTMK_BestCase) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  /*KEEP_STR*/"-fms-memptr-rep="), A.getValue()));
        }
        
        Opts.setMSPointerToMemberRepresentationMethod(InheritanceModel);
      }
    }
    {
      
      // Check for MS default calling conventions being specified.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_fdefault_calling_conv_EQ.getValue()));
      if ((A != null)) {
        LangOptions.DefaultCallingConvention DefaultCC = new StringSwitch<LangOptions.DefaultCallingConvention>(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"cdecl", LangOptions.DefaultCallingConvention.DCC_CDecl).
            Case(/*KEEP_STR*/"fastcall", LangOptions.DefaultCallingConvention.DCC_FastCall).
            Case(/*KEEP_STR*/"stdcall", LangOptions.DefaultCallingConvention.DCC_StdCall).
            Case(/*KEEP_STR*/"vectorcall", LangOptions.DefaultCallingConvention.DCC_VectorCall).
            Default(LangOptions.DefaultCallingConvention.DCC_None);
        if (DefaultCC == LangOptions.DefaultCallingConvention.DCC_None) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                  /*KEEP_STR*/"-fdefault-calling-conv="), A.getValue()));
        }
        
        Triple T$1/*J*/= new Triple(new Twine(TargetOpts.Triple));
        Triple.ArchType Arch = T$1.getArch();
        boolean emitError = (DefaultCC == LangOptions.DefaultCallingConvention.DCC_FastCall
           || DefaultCC == LangOptions.DefaultCallingConvention.DCC_StdCall)
           && Arch != Triple.ArchType.x86;
        emitError |= DefaultCC == LangOptions.DefaultCallingConvention.DCC_VectorCall
           && !(Arch == Triple.ArchType.x86 || Arch == Triple.ArchType.x86_64);
        if (emitError) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
                  A.getSpelling()), new StringRef(T$1.getTriple())));
        } else {
          Opts.setDefaultCallingConv(DefaultCC);
        }
      }
    }
    {
      
      // -mrtd option
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_mrtd.getValue()));
      if ((A != null)) {
        if (Opts.getDefaultCallingConv() != LangOptions.DefaultCallingConvention.DCC_None) {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
                  A.getSpelling()), /*KEEP_STR*/"-fdefault-calling-conv"));
        } else {
          Triple T$1/*J*/= new Triple(new Twine(TargetOpts.Triple));
          if (T$1.getArch() != Triple.ArchType.x86) {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_argument_not_allowed_with)), 
                    A.getSpelling()), new StringRef(T$1.getTriple())));
          } else {
            Opts.setDefaultCallingConv(LangOptions.DefaultCallingConvention.DCC_StdCall);
          }
        }
      }
    }
    
    // Check if -fopenmp is specified.
    Opts.OpenMP = Args.hasArg(new OptSpecifier(options.ID.OPT_fopenmp.getValue())) ? 1 : 0;
    Opts.OpenMPUseTLS
       = (Opts.OpenMP != 0) && !Args.hasArg(new OptSpecifier(options.ID.OPT_fnoopenmp_use_tls.getValue()));
    Opts.OpenMPIsDevice
       = (Opts.OpenMP != 0) && Args.hasArg(new OptSpecifier(options.ID.OPT_fopenmp_is_device.getValue()));
    if ((Opts.OpenMP != 0)) {
      int Version = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fopenmp_version_EQ.getValue()), Opts.OpenMP, Diags);
      if (Version != 0) {
        Opts.OpenMP = Version;
      }
      // Provide diagnostic when a given target is not expected to be an OpenMP
      // device or host.
      if (!Opts.OpenMPIsDevice) {
        switch (T.getArch()) {
         default:
          break;
         case nvptx:
         case nvptx64:
          // Add unsupported host targets here:
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_omp_host_target_not_supported)), 
              new StringRef(TargetOpts.Triple)));
          break;
        }
      }
    }
    {
      
      // Get the OpenMP target triples if any.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fopenmp_targets_EQ.getValue()));
      if ((A != null)) {
        
        for (/*uint*/int i = 0; $less_uint(i, A.getNumValues()); ++i) {
          Triple TT/*J*/= new Triple(new Twine(A.getValue(i)));
          if (TT.getArch() == Triple.ArchType.UnknownArch) {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_invalid_omp_target)), A.getValue(i)));
          } else {
            Opts.OMPTargetTriples.push_back_T$C$R(TT);
          }
        }
      }
    }
    {
      
      // Get OpenMP host file path if any and report if a non existent file is
      // found
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fopenmp_host_ir_file_path.getValue()));
      if ((A != null)) {
        Opts.OMPHostIRFile.$assign_T$C$P(A.getValue());
        if (!fs.exists(new Twine(Opts.OMPHostIRFile))) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_omp_host_ir_file_not_found)), 
              new StringRef(Opts.OMPHostIRFile)));
        }
      }
    }
    
    // Record whether the __DEPRECATED define was requested.
    Opts.Deprecated = Args.hasFlag(new OptSpecifier(ID.OPT_fdeprecated_macro.getValue()), 
        new OptSpecifier(ID.OPT_fno_deprecated_macro.getValue()), 
        Opts.Deprecated);
    
    // FIXME: Eliminate this dependency.
    /*uint*/int Opt = getOptimizationLevel(Args, IK, Diags);
    /*uint*/int OptSize = getOptimizationLevelSize(Args);
    Opts.Optimize = Opt != 0;
    Opts.OptimizeSize = OptSize != 0;
    
    // This is the __NO_INLINE__ define, which just depends on things like the
    // optimization level and -fno-inline, not actually whether the backend has
    // inlining enabled.
    Opts.NoInlineDefine = !(Opt != 0) || Args.hasArg(new OptSpecifier(ID.OPT_fno_inline.getValue()));
    
    Opts.FastMath = Args.hasArg(new OptSpecifier(ID.OPT_ffast_math.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_fast_relaxed_math.getValue()));
    Opts.FiniteMathOnly = Args.hasArg(new OptSpecifier(ID.OPT_ffinite_math_only.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_finite_math_only.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_fast_relaxed_math.getValue()));
    Opts.UnsafeFPMath = Args.hasArg(new OptSpecifier(ID.OPT_menable_unsafe_fp_math.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_unsafe_math_optimizations.getValue()))
       || Args.hasArg(new OptSpecifier(ID.OPT_cl_fast_relaxed_math.getValue()));
    
    Opts.RetainCommentsFromSystemHeaders
       = Args.hasArg(new OptSpecifier(ID.OPT_fretain_comments_from_system_headers.getValue()));
    
    /*uint*/int SSP = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_stack_protector.getValue()), 0, Diags);
    switch (SSP) {
     default:
      $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
              new StringRef(Args.getLastArg(new OptSpecifier(ID.OPT_stack_protector.getValue())).getAsString(Args))), SSP));
      break;
     case 0:
      Opts.setStackProtector(LangOptions.StackProtectorMode.SSPOff);
      break;
     case 1:
      Opts.setStackProtector(LangOptions.StackProtectorMode.SSPOn);
      break;
     case 2:
      Opts.setStackProtector(LangOptions.StackProtectorMode.SSPStrong);
      break;
     case 3:
      Opts.setStackProtector(LangOptions.StackProtectorMode.SSPReq);
      break;
    }
    
    // Parse -fsanitize= arguments.
    parseSanitizerKinds(new StringRef(/*KEEP_STR*/"-fsanitize="), $c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fsanitize_EQ.getValue()))), 
        Diags, Opts.Sanitize); $c$.clean();
    // -fsanitize-address-field-padding=N has to be a LangOpt, parse it here.
    Opts.SanitizeAddressFieldPadding
       = $uint2uint_2bits(getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_fsanitize_address_field_padding.getValue()), 0, Diags));
    $c$.clean(Opts.SanitizerBlacklistFiles.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fsanitize_blacklist.getValue())))));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="ParsePreprocessorArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2153,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 1891,
 FQN="ParsePreprocessorArgs", NM="_ZL21ParsePreprocessorArgsRN5clang19PreprocessorOptionsERN4llvm3opt7ArgListERNS_11FileManagerERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL21ParsePreprocessorArgsRN5clang19PreprocessorOptionsERN4llvm3opt7ArgListERNS_11FileManagerERNS_17DiagnosticsEngineE")
//</editor-fold>
public static void ParsePreprocessorArgs(final PreprocessorOptions /*&*/ Opts, final ArgList /*&*/ Args, 
                     final FileManager /*&*/ FileMgr, 
                     final DiagnosticsEngine /*&*/ Diags) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //JAVA: using namespace options;
    Opts.ImplicitPCHInclude.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_include_pch.getValue())).$string());
    Opts.ImplicitPTHInclude.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_include_pth.getValue())).$string());
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_token_cache.getValue()));
      if ((A != null)) {
        Opts.TokenCache.$assign_T$C$P(A.getValue());
      } else {
        Opts.TokenCache.$assign(Opts.ImplicitPTHInclude);
      }
    }
    Opts.UsePredefines = !Args.hasArg(new OptSpecifier(ID.OPT_undef.getValue()));
    Opts.DetailedRecord = Args.hasArg(new OptSpecifier(ID.OPT_detailed_preprocessing_record.getValue()));
    Opts.DisablePCHValidation = Args.hasArg(new OptSpecifier(ID.OPT_fno_validate_pch.getValue()));
    
    Opts.DumpDeserializedPCHDecls = Args.hasArg(new OptSpecifier(ID.OPT_dump_deserialized_pch_decls.getValue()));
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_error_on_deserialized_pch_decl.getValue())))  {
      Opts.DeserializedPCHDeclsToErrorOn.insert_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, A.getValue()));
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_preamble_bytes_EQ.getValue()));
      if ((A != null)) {
        StringRef Value/*J*/= new StringRef(A.getValue());
        /*size_t*/int Comma = Value.find($$COMMA);
        uint$ref Bytes = create_uint$ref(0);
        uint$ref EndOfLine = create_uint$ref(0);
        if (Comma == StringRef.npos
           || Value.substr(0, Comma).getAsInteger$NotSigned(10, Bytes)
           || Value.substr(Comma + 1).getAsInteger$NotSigned(10, EndOfLine)) {
          $c$.clean($c$.track(Diags.Report(diag.err_drv_preamble_format)));
        } else {
          Opts.PrecompiledPreambleBytes.first = Bytes.$deref();
          Opts.PrecompiledPreambleBytes.second = (EndOfLine.$deref() != 0);
        }
      }
    }
    
    // Add macros from the command line.
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_D.getValue()), new OptSpecifier(ID.OPT_U.getValue()))) {
      if (A.getOption().matches(new OptSpecifier(ID.OPT_D.getValue()))) {
        Opts.addMacroDef(new StringRef(A.getValue()));
      } else {
        Opts.addMacroUndef(new StringRef(A.getValue()));
      }
    }
    
    $c$.clean(Opts.MacroIncludes.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_imacros.getValue())))));
    
    // Add the ordered list of -includes.
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_include.getValue())))  {
      Opts.Includes.emplace_back(A.getValue());
    }
    
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_chain_include.getValue())))  {
      Opts.ChainedIncludes.emplace_back(A.getValue());
    }
    
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_remap_file.getValue()))) {
      std.pair<StringRef, StringRef> Split = new StringRef(A.getValue()).split($$SEMI);
      if (Split.second.empty()) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_remap_file)), new StringRef(A.getAsString(Args))));
        continue;
      }
      
      Opts.addRemappedFile(new StringRef(Split.first), new StringRef(Split.second));
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_fobjc_arc_cxxlib_EQ.getValue()));
      if ((A != null)) {
        StringRef Name = new StringRef(A.getValue());
        /*uint*/int Library = new StringSwitchUInt(/*NO_COPY*/Name).
            Case(/*KEEP_STR*/"libc++", ObjCXXARCStandardLibraryKind.ARCXX_libcxx.getValue()).
            Case(/*KEEP_STR*/"libstdc++", ObjCXXARCStandardLibraryKind.ARCXX_libstdcxx.getValue()).
            Case(/*KEEP_STR*/"none", ObjCXXARCStandardLibraryKind.ARCXX_nolib.getValue()).
            Default(~0/*U*/);
        if (Library == ~0/*U*/) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), /*NO_COPY*/Name));
        } else {
          Opts.ObjCXXARCStandardLibrary = ObjCXXARCStandardLibraryKind.valueOf(Library);
        }
      }
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="ParsePreprocessorOutputArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2229,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 1971,
 FQN="ParsePreprocessorOutputArgs", NM="_ZL27ParsePreprocessorOutputArgsRN5clang25PreprocessorOutputOptionsERN4llvm3opt7ArgListENS_8frontend10ActionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL27ParsePreprocessorOutputArgsRN5clang25PreprocessorOutputOptionsERN4llvm3opt7ArgListENS_8frontend10ActionKindE")
//</editor-fold>
public static void ParsePreprocessorOutputArgs(final PreprocessorOutputOptions /*&*/ Opts, 
                           final ArgList /*&*/ Args, 
                           ActionKind Action) {
  //JAVA: using namespace options;
  switch (Action) {
   case ASTDeclList:
   case ASTDump:
   case ASTPrint:
   case ASTView:
   case EmitAssembly:
   case EmitBC:
   case EmitHTML:
   case EmitLLVM:
   case EmitLLVMOnly:
   case EmitCodeGenOnly:
   case EmitObj:
   case FixIt:
   case GenerateModule:
   case GeneratePCH:
   case GeneratePTH:
   case ParseSyntaxOnly:
   case ModuleFileInfo:
   case VerifyPCH:
   case PluginAction:
   case PrintDeclContext:
   case RewriteObjC:
   case RewriteTest:
   case RunAnalysis:
   case MigrateSource:
    Opts.ShowCPP = false;
    break;
   case DumpRawTokens:
   case DumpTokens:
   case InitOnly:
   case PrintPreamble:
   case PrintPreprocessedInput:
   case RewriteMacros:
   case RunPreprocessorOnly:
    Opts.ShowCPP = !Args.hasArg(new OptSpecifier(ID.OPT_dM.getValue()));
    break;
  }
  
  Opts.ShowComments = Args.hasArg(new OptSpecifier(ID.OPT_C.getValue()));
  Opts.ShowLineMarkers = !Args.hasArg(new OptSpecifier(ID.OPT_P.getValue()));
  Opts.ShowMacroComments = Args.hasArg(new OptSpecifier(ID.OPT_CC.getValue()));
  Opts.ShowMacros = Args.hasArg(new OptSpecifier(ID.OPT_dM.getValue())) || Args.hasArg(new OptSpecifier(ID.OPT_dD.getValue()));
  Opts.RewriteIncludes = Args.hasArg(new OptSpecifier(ID.OPT_frewrite_includes.getValue()));
  Opts.UseLineDirectives = Args.hasArg(new OptSpecifier(ID.OPT_fuse_line_directives.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="ParseTargetArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2281,
 FQN="ParseTargetArgs", NM="_ZL15ParseTargetArgsRN5clang13TargetOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZL15ParseTargetArgsRN5clang13TargetOptionsERN4llvm3opt7ArgListERNS_17DiagnosticsEngineE")
//</editor-fold>
public static void ParseTargetArgs(final TargetOptions /*&*/ Opts, final ArgList /*&*/ Args, 
               final DiagnosticsEngine /*&*/ Diags) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //JAVA: using namespace options;
    Opts.ABI.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_target_abi.getValue())).$string());
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_meabi.getValue()));
      if ((A != null)) {
        StringRef Value = new StringRef(A.getValue());
        EABI EABIVersion = new StringSwitch<EABI>(/*NO_COPY*/Value).
            Case(/*KEEP_STR*/"default", EABI.Default).
            Case(/*KEEP_STR*/"4", EABI.EABI4).
            Case(/*KEEP_STR*/"5", EABI.EABI5).
            Case(/*KEEP_STR*/"gnu", EABI.GNU).
            Default(EABI.Unknown);
        if (EABIVersion == EABI.Unknown) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), 
              /*NO_COPY*/Value));
        } else {
          Opts.EABIVersion.$assignMove(Value.$string());
        }
      }
    }
    Opts.CPU.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_target_cpu.getValue())).$string());
    Opts.FPMath.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_mfpmath.getValue())).$string());
    $c$.clean(Opts.FeaturesAsWritten.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_target_feature.getValue())))));
    Opts.LinkerVersion.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_target_linker_version.getValue())).$string());
    Opts.Triple.$assignMove(Triple.normalize(Args.getLastArgValue(new OptSpecifier(ID.OPT_triple.getValue()))));
    $c$.clean(Opts.Reciprocals.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_mrecip_EQ.getValue())))));
    // Use the default target triple if unspecified.
    if (Opts.Triple.empty()) {
      Opts.Triple.$assignMove(sys.getDefaultTargetTriple());
    }
  } finally {
    $c$.$destroy();
  }
}

} // END OF class CompilerInvocationStatics
