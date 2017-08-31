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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import org.clang.basic.*;
import static org.clang.config.config.CLANG_VERSION_STRING;
import org.llvm.option.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import static org.clang.driver.DriverGlobals.*;
import static org.clang.frontend.impl.CompilerInvocationStatics.*;
import org.clang.frontend.*;
import org.clang.driver.options;
import org.clang.driver.options.ID;
import org.llvm.support.sys.*;
import org.clang.driver.frontend.*;
import org.clang.frontend.staticanalyzer.AnalyzerOptions;
import org.llvm.adt.HashingGlobals.*;
import static org.llvm.adt.HashingGlobals.*;


/// \brief Helper class for holding the data necessary to invoke the compiler.
///
/// This class is designed to represent an abstract "invocation" of the
/// compiler, including data such as the include paths, the code generation
/// options, the warning flags, and so on.
//<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 103,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 102,
 FQN="clang::CompilerInvocation", NM="_ZN5clang18CompilerInvocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocationE")
//</editor-fold>
public class CompilerInvocation extends /*public*/ CompilerInvocationBase implements Destructors.ClassWithDestructor {
  /// Options controlling the static analyzer.
  private IntrusiveRefCntPtr<AnalyzerOptions> AnalyzerOpts;
  
  private MigratorOptions MigratorOpts;
  
  /// Options controlling IRgen and the backend.
  private CodeGenOptions CodeGenOpts;
  
  /// Options controlling dependency output.
  private DependencyOutputOptions DependencyOutputOpts;
  
  /// Options controlling file system operations.
  private FileSystemOptions FileSystemOpts;
  
  /// Options controlling the frontend itself.
  private FrontendOptions FrontendOpts;
  
  /// Options controlling preprocessed output.
  private PreprocessorOutputOptions PreprocessorOutputOpts;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::CompilerInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 125,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 124,
   FQN="clang::CompilerInvocation::CompilerInvocation", NM="_ZN5clang18CompilerInvocationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocationC1Ev")
  //</editor-fold>
  public CompilerInvocation() {
    // : CompilerInvocationBase(), AnalyzerOpts(new AnalyzerOptions()), MigratorOpts(), CodeGenOpts(), DependencyOutputOpts(), FileSystemOpts(), FrontendOpts(), PreprocessorOutputOpts() 
    //START JInit
    super();
    this.AnalyzerOpts = new IntrusiveRefCntPtr<AnalyzerOptions>(new AnalyzerOptions());
    this.MigratorOpts = new MigratorOptions();
    this.CodeGenOpts = new CodeGenOptions();
    this.DependencyOutputOpts = new DependencyOutputOptions();
    this.FileSystemOpts = new FileSystemOptions();
    this.FrontendOpts = new FrontendOptions();
    this.PreprocessorOutputOpts = new PreprocessorOutputOptions();
    //END JInit
  }

  
  /// @name Utility Methods
  /// @{
  
  /// \brief Create a compiler invocation from a list of input options.
  /// \returns true on success.
  ///
  /// \param [out] Res - The resulting invocation.
  /// \param ArgBegin - The first element in the argument vector.
  /// \param ArgEnd - The last element in the argument vector.
  /// \param Diags - The diagnostic engine to use for errors.
  
  /// @name Utility Methods
  /// @{
  
  /// \brief Create a compiler invocation from a list of input options.
  /// \returns true on success.
  ///
  /// \param [out] Res - The resulting invocation.
  /// \param ArgBegin - The first element in the argument vector.
  /// \param ArgEnd - The last element in the argument vector.
  /// \param Diags - The diagnostic engine to use for errors.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::CreateFromArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2310,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2037,
   FQN="clang::CompilerInvocation::CreateFromArgs", NM="_ZN5clang18CompilerInvocation14CreateFromArgsERS0_PKPKcS5_RNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang18CompilerInvocation14CreateFromArgsERS0_PKPKcS5_RNS_17DiagnosticsEngineE")
  //</editor-fold>
  public static boolean CreateFromArgs(CompilerInvocation /*&*/ Res, 
                /*const*/type$ptr<char$ptr>/*char P const P*/ ArgBegin, 
                /*const*/type$ptr<char$ptr>/*char P const P*/ ArgEnd, 
                DiagnosticsEngine /*&*/ Diags) {
    std.unique_ptr<OptTable> Opts = null;
    InputArgList Args = null;
    FileManager FileMgr = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean Success = true;
      
      // Parse the arguments.
      Opts/*J*/= new std.unique_ptr<OptTable>(createDriverOptTable());
      /*const*//*uint*/int IncludedFlagsBitmask = options.ClangFlags.CC1Option;
      /*uint*/uint$ref MissingArgIndex = create_uint$ref(), MissingArgCount = create_uint$ref();
      Args = Opts.$arrow().ParseArgs(llvm.makeArrayRef(ArgBegin, ArgEnd), MissingArgIndex, 
          MissingArgCount, IncludedFlagsBitmask);
      LangOptions /*&*/ LangOpts = /*Deref*/Res.getLangOpts();
      
      // Check for missing argument error.
      if ((MissingArgCount.$deref() != 0)) {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_drv_missing_argument)), 
                Args.getArgString(MissingArgIndex.$deref())), MissingArgCount.$deref()));
        Success = false;
      }
      
      // Issue errors on unknown arguments.
      for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(ID.OPT_UNKNOWN.getValue()))) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_unknown_argument)), new StringRef(A.getAsString(Args))));
        Success = false;
      }
      
      $c$.clean(Success &= ParseAnalyzerArgs($c$.track(Res.getAnalyzerOpts()).$star(), Args, Diags));
      Success &= ParseMigratorArgs(Res.getMigratorOpts(), Args);
      ParseDependencyOutputArgs(Res.getDependencyOutputOpts(), Args);
      Success &= ParseDiagnosticArgs(Res.getDiagnosticOpts(), Args, /*AddrOf*/Diags, 
          false/*DefaultDiagColor*/);
      ParseCommentArgs(LangOpts.CommentOpts, Args);
      ParseFileSystemArgs(Res.getFileSystemOpts(), Args);
      // FIXME: We shouldn't have to pass the DashX option around here
      InputKind DashX = ParseFrontendArgs(Res.getFrontendOpts(), Args, Diags);
      ParseTargetArgs(Res.getTargetOpts(), Args, Diags);
      Success &= ParseCodeGenArgs(Res.getCodeGenOpts(), Args, DashX, Diags, 
          Res.getTargetOpts());
      ParseHeaderSearchArgs(Res.getHeaderSearchOpts(), Args);
      if (DashX == InputKind.IK_AST || DashX == InputKind.IK_LLVM_IR) {
        // ObjCAAutoRefCount and Sanitize LangOpts are used to setup the
        // PassManager in BackendUtil.cpp. They need to be initializd no matter
        // what the input type is.
        if (Args.hasArg(new OptSpecifier(ID.OPT_fobjc_arc.getValue()))) {
          LangOpts.ObjCAutoRefCount = true;
        }
        // PIClevel and PIELevel are needed during code generation and this should be
        // set regardless of the input type.
        LangOpts.PICLevel = (byte)getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_pic_level.getValue()), 0, Diags);
        LangOpts.PIE = Args.hasArg(new OptSpecifier(ID.OPT_pic_is_pie.getValue()));
        parseSanitizerKinds(new StringRef(/*KEEP_STR*/"-fsanitize="), $c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_fsanitize_EQ.getValue()))), 
            Diags, LangOpts.Sanitize); $c$.clean();
      } else {
        // Other LangOpts are only initialzed when the input is not AST or LLVM IR.
        ParseLangArgs(LangOpts, Args, DashX, Res.getTargetOpts(), 
            Res.getPreprocessorOpts(), Diags);
        if (Res.getFrontendOpts().ProgramAction == frontend.ActionKind.RewriteObjC) {
          LangOpts.ObjCExceptions = true;
        }
      }
      if (LangOpts.CUDA) {
        // During CUDA device-side compilation, the aux triple is the
        // triple used for host compilation.
        if (LangOpts.CUDAIsDevice) {
          Res.getTargetOpts().HostTriple.$assign(Res.getFrontendOpts().AuxTriple);
        }
        
        // Set default FP_CONTRACT to FAST.
        if (!Args.hasArg(new OptSpecifier(ID.OPT_ffp_contract.getValue()))) {
          Res.getCodeGenOpts().setFPContractMode(CodeGenOptions.FPContractModeKind.FPC_Fast);
        }
      }
      
      // FIXME: Override value name discarding when asan or msan is used because the
      // backend passes depend on the name of the alloca in order to print out
      // names.
      Res.getCodeGenOpts().DiscardValueNames &= !LangOpts.Sanitize.has(SanitizerKind.Address)
         && !LangOpts.Sanitize.has(SanitizerKind.Memory);
      
      // FIXME: ParsePreprocessorArgs uses the FileManager to read the contents of
      // PCH file and find the original header name. Remove the need to do that in
      // ParsePreprocessorArgs and remove the FileManager
      // parameters from the function and the "FileManager.h" #include.
      FileMgr/*J*/= new FileManager(Res.getFileSystemOpts());
      ParsePreprocessorArgs(Res.getPreprocessorOpts(), Args, FileMgr, Diags);
      ParsePreprocessorOutputArgs(Res.getPreprocessorOutputOpts(), Args, 
          Res.getFrontendOpts().ProgramAction);
      return Success;
    } finally {
      if (FileMgr != null) { FileMgr.$destroy(); }
      if (Args != null) { Args.$destroy(); }
      if (Opts != null) { Opts.$destroy(); }
      $c$.$destroy();
    }
  }


  
  /// \brief Get the directory where the compiler headers
  /// reside, relative to the compiler binary (found by the passed in
  /// arguments).
  ///
  /// \param Argv0 - The program path (from argv[0]), for finding the builtin
  /// compiler path.
  /// \param MainAddr - The address of main (or some other function in the main
  /// executable), for finding the builtin compiler path.
  
  /// \brief Get the directory where the compiler headers
  /// reside, relative to the compiler binary (found by the passed in
  /// arguments).
  ///
  /// \param Argv0 - The program path (from argv[0]), for finding the builtin
  /// compiler path.
  /// \param MainAddr - The address of main (or some other function in the main
  /// executable), for finding the builtin compiler path.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::GetResourcesPath">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1333,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 1193,
   FQN="clang::CompilerInvocation::GetResourcesPath", NM="_ZN5clang18CompilerInvocation16GetResourcesPathEPKcPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang18CompilerInvocation16GetResourcesPathEPKcPv")
  //</editor-fold>
  public static std.string GetResourcesPath(/*const*/char$ptr/*char P*/ Argv0, 
                  Object/*void P*/ MainAddr) {
    std.string ClangExecutable = fs.getMainExecutable(Argv0, MainAddr);
    StringRef Dir = path.parent_path(new StringRef(ClangExecutable));
    
    // Compute the path to the resource directory.
    StringRef ClangResourceDir/*J*/= new StringRef(/*KEEP_STR*/$EMPTY);
    SmallString/*<128>*/ P/*J*/= new SmallString/*<128>*/(128, new StringRef(Dir));
    if ($noteq_StringRef(/*NO_COPY*/ClangResourceDir, /*STRINGREF_STR*/"")) {
      path.append(P, new Twine(ClangResourceDir));
    } else {
      path.append(P, new Twine(/*KEEP_STR*/$DOT_DOT), $add_Twine$C(new Twine(/*KEEP_STR*/"lib"), new Twine(/*KEEP_STR*/$EMPTY)), 
          new Twine(/*KEEP_STR*/"clang"), new Twine(/*KEEP_STR*/CLANG_VERSION_STRING));
    }
    
    return P.str().$string();
  }


  
  /// \brief Set language defaults for the given input language and
  /// language standard in the given LangOptions object.
  ///
  /// \param Opts - The LangOptions object to set up.
  /// \param IK - The input language.
  /// \param T - The target triple.
  /// \param PPOpts - The PreprocessorOptions affected.
  /// \param LangStd - The input language standard.
  
  /// \brief Set language defaults for the given input language and
  /// language standard in the given LangOptions object.
  ///
  /// \param Opts - The LangOptions object to set up.
  /// \param IK - The input language.
  /// \param T - The target triple.
  /// \param PPOpts - The PreprocessorOptions affected.
  /// \param LangStd - The input language standard.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::setLangDefaults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 1471,
   FQN="clang::CompilerInvocation::setLangDefaults", NM="_ZN5clang18CompilerInvocation15setLangDefaultsERNS_11LangOptionsENS_9InputKindERKN4llvm6TripleERNS_19PreprocessorOptionsENS_12LangStandard4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang18CompilerInvocation15setLangDefaultsERNS_11LangOptionsENS_9InputKindERKN4llvm6TripleERNS_19PreprocessorOptionsENS_12LangStandard4KindE")
  //</editor-fold>
  public static void setLangDefaults(LangOptions /*&*/ Opts, InputKind IK, 
                 /*const*/ Triple /*&*/ T, 
                 PreprocessorOptions /*&*/ PPOpts) {
    setLangDefaults(Opts, IK, 
                 T, 
                 PPOpts, 
                 LangStandard.Kind.lang_unspecified);
  }
  public static void setLangDefaults(LangOptions /*&*/ Opts, InputKind IK, 
                 /*const*/ Triple /*&*/ T, 
                 PreprocessorOptions /*&*/ PPOpts, 
                 LangStandard.Kind LangStd/*= LangStandard::lang_unspecified*/) {
    // Set some properties which depend solely on the input kind; it would be nice
    // to move these to the language standard, and have the driver resolve the
    // input kind + language standard.
    if (IK == InputKind.IK_Asm) {
      Opts.AsmPreprocessor = true;
    } else if (IK == InputKind.IK_ObjC
       || IK == InputKind.IK_ObjCXX
       || IK == InputKind.IK_PreprocessedObjC
       || IK == InputKind.IK_PreprocessedObjCXX) {
      Opts.ObjC1 = Opts.ObjC2 = true;
    }
    if (LangStd == LangStandard.Kind.lang_unspecified) {
      // Based on the base language, pick one.
      switch (IK) {
       case IK_None:
       case IK_AST:
       case IK_LLVM_IR:
        throw new llvm_unreachable("Invalid input kind!");
       case IK_OpenCL:
        LangStd = LangStandard.Kind.lang_opencl;
        break;
       case IK_CUDA:
       case IK_PreprocessedCuda:
        LangStd = LangStandard.Kind.lang_cuda;
        break;
       case IK_Asm:
       case IK_C:
       case IK_PreprocessedC:
       case IK_ObjC:
       case IK_PreprocessedObjC:
        // The PS4 uses C99 as the default C standard.
        if (T.isPS4()) {
          LangStd = LangStandard.Kind.lang_gnu99;
        } else {
          LangStd = LangStandard.Kind.lang_gnu11;
        }
        break;
       case IK_CXX:
       case IK_PreprocessedCXX:
       case IK_ObjCXX:
       case IK_PreprocessedObjCXX:
        LangStd = LangStandard.Kind.lang_gnucxx98;
        break;
       case IK_RenderScript:
        LangStd = LangStandard.Kind.lang_c99;
        break;
      }
    }
    
    /*const*/ LangStandard /*&*/ Std = LangStandard.getLangStandardForKind(LangStd);
    Opts.LineComment = Std.hasLineComments();
    Opts.C99 = Std.isC99();
    Opts.C11 = Std.isC11();
    Opts.CPlusPlus = Std.isCPlusPlus();
    Opts.CPlusPlus11 = Std.isCPlusPlus11();
    Opts.CPlusPlus14 = Std.isCPlusPlus14();
    Opts.CPlusPlus1z = Std.isCPlusPlus1z();
    Opts.Digraphs = Std.hasDigraphs();
    Opts.GNUMode = Std.isGNUMode();
    Opts.GNUInline = Std.isC89();
    Opts.HexFloats = Std.hasHexFloats();
    Opts.ImplicitInt = Std.hasImplicitInt();
    
    // Set OpenCL Version.
    Opts.OpenCL = isOpenCL(LangStd) || IK == InputKind.IK_OpenCL;
    if (LangStd == LangStandard.Kind.lang_opencl) {
      Opts.OpenCLVersion = 100;
    } else if (LangStd == LangStandard.Kind.lang_opencl11) {
      Opts.OpenCLVersion = 110;
    } else if (LangStd == LangStandard.Kind.lang_opencl12) {
      Opts.OpenCLVersion = 120;
    } else if (LangStd == LangStandard.Kind.lang_opencl20) {
      Opts.OpenCLVersion = 200;
    }
    
    // OpenCL has some additional defaults.
    if (Opts.OpenCL) {
      Opts.AltiVec = false;
      Opts.ZVector = false;
      Opts.CXXOperatorNames = true;
      Opts.LaxVectorConversions = false;
      Opts.DefaultFPContract = true;
      Opts.NativeHalfType = true;
      Opts.NativeHalfArgsAndReturns = true;
      // Include default header file for OpenCL.
      if (Opts.IncludeDefaultHeader) {
        PPOpts.Includes.push_back_T$RR(new std.string(/*KEEP_STR*/"opencl-c.h"));
      }
    }
    
    Opts.CUDA = IK == InputKind.IK_CUDA || IK == InputKind.IK_PreprocessedCuda
       || LangStd == LangStandard.Kind.lang_cuda;
    
    Opts.RenderScript = IK == InputKind.IK_RenderScript;
    if (Opts.RenderScript) {
      Opts.NativeHalfType = true;
      Opts.NativeHalfArgsAndReturns = true;
    }
    
    // OpenCL and C++ both have bool, true, false keywords.
    Opts.Bool = Opts.OpenCL || Opts.CPlusPlus;
    
    // OpenCL has half keyword
    Opts.Half = Opts.OpenCL;
    
    // C++ has wchar_t keyword.
    Opts.WChar = Opts.CPlusPlus;
    
    Opts.GNUKeywords = Opts.GNUMode;
    Opts.CXXOperatorNames = Opts.CPlusPlus;
    
    Opts.DollarIdents = !Opts.AsmPreprocessor;
  }


  
  /// \brief Retrieve a module hash string that is suitable for uniquely 
  /// identifying the conditions under which the module was built.
  
  /// \brief Retrieve a module hash string that is suitable for uniquely 
  /// identifying the conditions under which the module was built.
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getModuleHash">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2400,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2154,
   FQN="clang::CompilerInvocation::getModuleHash", NM="_ZNK5clang18CompilerInvocation13getModuleHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang18CompilerInvocation13getModuleHashEv")
  //</editor-fold>
  public std.string getModuleHash() /*const*/ {
    // Note: For QoI reasons, the things we use as a hash here should all be
    // dumped via the -module-info flag.
    //JAVA: using llvm::hash_code;
    //JAVA: using llvm::hash_value;
    //JAVA: using llvm::hash_combine;
    
    // Start the signature with the compiler version.
    // FIXME: We'd rather use something more cryptographically sound than
    // CityHash, but this will do for now.
    hash_code code = hash_value(getClangFullRepositoryVersion());
    
    // FIXME: A lot of the BENIGN_ options should be COMPATIBLE_ instead.
    code.$assignMove(hash_combine(code, LangOpts.$arrow().C99));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().C11));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().MSVCCompat));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().MicrosoftExt));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().AsmBlocks));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Borland));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CPlusPlus));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CPlusPlus11));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CPlusPlus14));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CPlusPlus1z));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ObjC1));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ObjC2));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().AppExt));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Trigraphs));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().LineComment));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Bool));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Half));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().WChar));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().DeclSpecKeyword));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().GNUKeywords));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Digraphs));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CXXOperatorNames));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().AppleKext));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().WritableStrings));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ConstStrings));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().LaxVectorConversions));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().AltiVec));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ZVector));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Exceptions));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ObjCExceptions));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CXXExceptions));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().SjLjExceptions));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ExternCNoUnwind));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().TraditionalCPP));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().RTTI));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().RTTIData));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().MSBitfields));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Freestanding));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().NoBuiltin));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().NoMathBuiltin));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().GNUAsm));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Coroutines));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().POSIXThreads));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Blocks));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().MathErrno));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Modules));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ModulesDeclUse));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ModulesStrictDeclUse));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ModulesLocalVisibility));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Optimize));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().OptimizeSize));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Static));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().PackStruct));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().MaxTypeAlign));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().AlignDouble));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().PICLevel));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().PIE));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().GNUInline));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().NoInlineDefine));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().Deprecated));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().FastMath));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().FiniteMathOnly));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().UnsafeFPMath));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CharIsSigned));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ShortWChar));
    code.$assignMove(hash_combine(code, ((/*static_cast*//*uint*/int)(LangOpts.$arrow().getMSPointerToMemberRepresentationMethod().getValue()))));
    code.$assignMove(hash_combine(code, ((/*static_cast*//*uint*/int)(LangOpts.$arrow().getDefaultCallingConv().getValue()))));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ShortEnums));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().OpenCL));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().OpenCLVersion));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().NativeHalfType));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().NativeHalfArgsAndReturns));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().HalfArgsAndReturns));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CUDA));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().OpenMP));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().OpenMPUseTLS));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().OpenMPIsDevice));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().RenderScript));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CUDAIsDevice));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CUDAAllowVariadicFunctions));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CUDAHostDeviceConstexpr));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CUDADeviceFlushDenormalsToZero));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().CUDADeviceApproxTranscendentals));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().SizedDeallocation));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ConceptsTS));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().NoConstantCFStrings));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().SinglePrecisionConstants));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().FastRelaxedMath));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().DefaultFPContract));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().NoBitFieldTypeAlign));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().HexagonQdsp6Compat));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ObjCAutoRefCount));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ObjCWeakRuntime));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ObjCWeak));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ObjCSubscriptingLegacyRuntime));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().FakeAddressSpaceMap));
    code.$assignMove(hash_combine(code, ((/*static_cast*//*uint*/int)(LangOpts.$arrow().getAddressSpaceMapMangling().getValue()))));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().IncludeDefaultHeader));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().BlocksRuntimeOptional));
    code.$assignMove(hash_combine(code, ((/*static_cast*//*uint*/int)(LangOpts.$arrow().getGC().getValue()))));
    code.$assignMove(hash_combine(code, ((/*static_cast*//*uint*/int)(LangOpts.$arrow().getValueVisibilityMode().getValue()))));
    code.$assignMove(hash_combine(code, ((/*static_cast*//*uint*/int)(LangOpts.$arrow().getTypeVisibilityMode().getValue()))));
    code.$assignMove(hash_combine(code, ((/*static_cast*//*uint*/int)(LangOpts.$arrow().getStackProtector().getValue()))));
    code.$assignMove(hash_combine(code, ((/*static_cast*//*uint*/int)(LangOpts.$arrow().getSignedOverflowBehavior().getValue()))));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().MSCompatibilityVersion));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().VtorDispMode));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().ApplePragmaPack));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().RetainCommentsFromSystemHeaders));
    code.$assignMove(hash_combine(code, LangOpts.$arrow().SanitizeAddressFieldPadding));
    
    for (string Feature : LangOpts.$arrow().ModuleFeatures)  {
      code.$assignMove(hash_combine(code, Feature));
    }
    
    // Extend the signature with the target options.
    code.$assignMove(hash_combine(code, TargetOpts.$arrow().Triple, TargetOpts.$arrow().CPU, 
            TargetOpts.$arrow().ABI));
    for (/*uint*/int i = 0, n = TargetOpts.$arrow().FeaturesAsWritten.size(); i != n; ++i)  {
      code.$assignMove(hash_combine(code, TargetOpts.$arrow().FeaturesAsWritten.$at(i)));
    }
    
    // Extend the signature with preprocessor options.
    /*const*/ PreprocessorOptions /*&*/ ppOpts = getPreprocessorOpts$Const();
    /*const*/ HeaderSearchOptions /*&*/ hsOpts = getHeaderSearchOpts$Const();
    code.$assignMove(hash_combine(code, ppOpts.UsePredefines, ppOpts.DetailedRecord));
    
    for (std.vector.iterator<pairTypeBool<string>> I = /*isUndef*/
        getPreprocessorOpts$Const().Macros.begin$Const(), 
        IEnd = getPreprocessorOpts$Const().Macros.end$Const();
         $noteq___normal_iterator$C(I, IEnd); I.$preInc()) {
      // If we're supposed to ignore this macro for the purposes of modules,
      // don't put it into the hash.
      if (!hsOpts.ModulesIgnoreMacros.empty()) {
        // Check whether we're ignoring this macro.
        StringRef MacroDef = new StringRef(I.$arrow().first);
        if ((hsOpts.ModulesIgnoreMacros.count(MacroDef.split($$EQ).first.$string()) != 0)) {
          continue;
        }
      }
      
      code.$assignMove(hash_combine(code, I.$arrow().first, I.$arrow().second));
    }
    
    // Extend the signature with the sysroot and other header search options.
    code.$assignMove(hash_combine(code, hsOpts.Sysroot, 
            hsOpts.ModuleFormat, 
            hsOpts.UseDebugInfo, 
            hsOpts.UseBuiltinIncludes, 
            hsOpts.UseStandardSystemIncludes, 
            hsOpts.UseStandardCXXIncludes, 
            hsOpts.UseLibcxx));
    code.$assignMove(hash_combine(code, hsOpts.ResourceDir));
    
    // Extend the signature with the user build path.
    code.$assignMove(hash_combine(code, hsOpts.ModuleUserBuildPath));
    
    // Extend the signature with the module file extensions.
    /*const*/ FrontendOptions /*&*/ frontendOpts = getFrontendOpts$Const();
    for (/*const*/ IntrusiveRefCntPtr<ModuleFileExtension> /*&*/ ext : frontendOpts.ModuleFileExtensions) {
      code.$assignMove(ext.$arrow().hashExtension(new hash_code(code)));
    }
    
    // Darwin-specific hack: if we have a sysroot, use the contents and
    // modification time of
    //   $sysroot/System/Library/CoreServices/SystemVersion.plist
    // as part of the module hash.
    if (!hsOpts.Sysroot.empty()) {
      ErrorOr<std.unique_ptr<MemoryBuffer> > buffer = null;
      try {
        SmallString/*128*/ systemVersionFile/*J*/= new SmallString/*128*/(128);
        systemVersionFile.$addassign(new StringRef(hsOpts.Sysroot));
        path.append(systemVersionFile, new Twine(/*KEEP_STR*/"System"));
        path.append(systemVersionFile, new Twine(/*KEEP_STR*/"Library"));
        path.append(systemVersionFile, new Twine(/*KEEP_STR*/"CoreServices"));
        path.append(systemVersionFile, new Twine(/*KEEP_STR*/"SystemVersion.plist"));
        
        buffer = MemoryBuffer.getFile(new Twine(systemVersionFile));
        if (buffer.$bool()) {
          code.$assignMove(hash_combine(code, buffer.get().$arrow().getBuffer()));
          
           stat statBuf/*J*/= new  stat();
          if (stat(systemVersionFile.c_str(), /*AddrOf*/statBuf) == 0) {
            code.$assignMove(hash_combine(code, statBuf.st_mtim.tv_sec));
          }
        }
      } finally {
        if (buffer != null) { buffer.$destroy(); }
      }
    }
    
    return new APInt(64, $uint2ulong(code.$uint())).__toString(36, /*Signed=*/ false);
  }


  
  /// @}
  /// @name Option Subgroups
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getAnalyzerOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 172,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 168,
   FQN="clang::CompilerInvocation::getAnalyzerOpts", NM="_ZNK5clang18CompilerInvocation15getAnalyzerOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18CompilerInvocation15getAnalyzerOptsEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<AnalyzerOptions> getAnalyzerOpts() /*const*/ {
    return new IntrusiveRefCntPtr<AnalyzerOptions>(AnalyzerOpts);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getMigratorOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 172,
   FQN="clang::CompilerInvocation::getMigratorOpts", NM="_ZN5clang18CompilerInvocation15getMigratorOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocation15getMigratorOptsEv")
  //</editor-fold>
  public MigratorOptions /*&*/ getMigratorOpts() {
    return MigratorOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getMigratorOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 177,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 173,
   FQN="clang::CompilerInvocation::getMigratorOpts", NM="_ZNK5clang18CompilerInvocation15getMigratorOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18CompilerInvocation15getMigratorOptsEv")
  //</editor-fold>
  public /*const*/ MigratorOptions /*&*/ getMigratorOpts$Const() /*const*/ {
    return MigratorOpts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getCodeGenOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 181,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 177,
   FQN="clang::CompilerInvocation::getCodeGenOpts", NM="_ZN5clang18CompilerInvocation14getCodeGenOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocation14getCodeGenOptsEv")
  //</editor-fold>
  public CodeGenOptions /*&*/ getCodeGenOpts() {
    return CodeGenOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getCodeGenOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 178,
   FQN="clang::CompilerInvocation::getCodeGenOpts", NM="_ZNK5clang18CompilerInvocation14getCodeGenOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18CompilerInvocation14getCodeGenOptsEv")
  //</editor-fold>
  public /*const*/ CodeGenOptions /*&*/ getCodeGenOpts$Const() /*const*/ {
    return CodeGenOpts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getDependencyOutputOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 186,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 182,
   FQN="clang::CompilerInvocation::getDependencyOutputOpts", NM="_ZN5clang18CompilerInvocation23getDependencyOutputOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocation23getDependencyOutputOptsEv")
  //</editor-fold>
  public DependencyOutputOptions /*&*/ getDependencyOutputOpts() {
    return DependencyOutputOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getDependencyOutputOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 189,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 185,
   FQN="clang::CompilerInvocation::getDependencyOutputOpts", NM="_ZNK5clang18CompilerInvocation23getDependencyOutputOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18CompilerInvocation23getDependencyOutputOptsEv")
  //</editor-fold>
  public /*const*/ DependencyOutputOptions /*&*/ getDependencyOutputOpts$Const() /*const*/ {
    return DependencyOutputOpts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getFileSystemOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 189,
   FQN="clang::CompilerInvocation::getFileSystemOpts", NM="_ZN5clang18CompilerInvocation17getFileSystemOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocation17getFileSystemOptsEv")
  //</editor-fold>
  public FileSystemOptions /*&*/ getFileSystemOpts() {
    return FileSystemOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getFileSystemOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 194,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 190,
   FQN="clang::CompilerInvocation::getFileSystemOpts", NM="_ZNK5clang18CompilerInvocation17getFileSystemOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18CompilerInvocation17getFileSystemOptsEv")
  //</editor-fold>
  public /*const*/ FileSystemOptions /*&*/ getFileSystemOpts$Const() /*const*/ {
    return FileSystemOpts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getFrontendOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 198,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 194,
   FQN="clang::CompilerInvocation::getFrontendOpts", NM="_ZN5clang18CompilerInvocation15getFrontendOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocation15getFrontendOptsEv")
  //</editor-fold>
  public FrontendOptions /*&*/ getFrontendOpts() {
    return FrontendOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getFrontendOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 195,
   FQN="clang::CompilerInvocation::getFrontendOpts", NM="_ZNK5clang18CompilerInvocation15getFrontendOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18CompilerInvocation15getFrontendOptsEv")
  //</editor-fold>
  public /*const*/ FrontendOptions /*&*/ getFrontendOpts$Const() /*const*/ {
    return FrontendOpts;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getPreprocessorOutputOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 203,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 199,
   FQN="clang::CompilerInvocation::getPreprocessorOutputOpts", NM="_ZN5clang18CompilerInvocation25getPreprocessorOutputOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocation25getPreprocessorOutputOptsEv")
  //</editor-fold>
  public PreprocessorOutputOptions /*&*/ getPreprocessorOutputOpts() {
    return PreprocessorOutputOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::getPreprocessorOutputOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 206,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 202,
   FQN="clang::CompilerInvocation::getPreprocessorOutputOpts", NM="_ZNK5clang18CompilerInvocation25getPreprocessorOutputOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZNK5clang18CompilerInvocation25getPreprocessorOutputOptsEv")
  //</editor-fold>
  public /*const*/ PreprocessorOutputOptions /*&*/ getPreprocessorOutputOpts$Const() /*const*/ {
    return PreprocessorOutputOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::CompilerInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 102,
   FQN="clang::CompilerInvocation::CompilerInvocation", NM="_ZN5clang18CompilerInvocationC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocationC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CompilerInvocation(/*const*/ CompilerInvocation /*&*/ $Prm0) {
    // : CompilerInvocationBase(), AnalyzerOpts(.AnalyzerOpts), MigratorOpts(.MigratorOpts), CodeGenOpts(.CodeGenOpts), DependencyOutputOpts(.DependencyOutputOpts), FileSystemOpts(.FileSystemOpts), FrontendOpts(.FrontendOpts), PreprocessorOutputOpts(.PreprocessorOutputOpts) 
    //START JInit
    super($Prm0);
    this.AnalyzerOpts = new IntrusiveRefCntPtr<AnalyzerOptions>($Prm0.AnalyzerOpts);
    this.MigratorOpts = new MigratorOptions($Prm0.MigratorOpts);
    this.CodeGenOpts = new CodeGenOptions($Prm0.CodeGenOpts);
    this.DependencyOutputOpts = new DependencyOutputOptions($Prm0.DependencyOutputOpts);
    this.FileSystemOpts = new FileSystemOptions($Prm0.FileSystemOpts);
    this.FrontendOpts = new FrontendOptions($Prm0.FrontendOpts);
    this.PreprocessorOutputOpts = new PreprocessorOutputOptions($Prm0.PreprocessorOutputOpts);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocation::~CompilerInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 102,
   FQN="clang::CompilerInvocation::~CompilerInvocation", NM="_ZN5clang18CompilerInvocationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZN5clang18CompilerInvocationD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FrontendOpts.$destroy();
    FileSystemOpts.$destroy();
    DependencyOutputOpts.$destroy();
    CodeGenOpts.$destroy();
    AnalyzerOpts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "AnalyzerOpts=" + AnalyzerOpts // NOI18N
              + ", MigratorOpts=" + MigratorOpts // NOI18N
              + ", CodeGenOpts=" + CodeGenOpts // NOI18N
              + ", DependencyOutputOpts=" + DependencyOutputOpts // NOI18N
              + ", FileSystemOpts=" + FileSystemOpts // NOI18N
              + ", FrontendOpts=" + FrontendOpts // NOI18N
              + ", PreprocessorOutputOpts=" + PreprocessorOutputOpts // NOI18N
              + super.toString(); // NOI18N
  }
/// @}
}
