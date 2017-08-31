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

package org.clang.driver.tools.impl;

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
import static org.clang.driver.DriverGlobals.*;
import static org.clang.driver.impl.ToolsStatics.*;
import static org.clang.driver.java.JavaDriverSupport.*;
import org.llvm.target.target.DebuggerKind;
import org.llvm.support.sys.Process;

/// \brief Clang compiler tool.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 46,
 FQN="clang::driver::tools::Clang", NM="_ZN5clang6driver5tools5ClangE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5ClangE")
//</editor-fold>
public class Clang extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::getBaseInputName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7410,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6788,
   FQN="clang::driver::tools::Clang::getBaseInputName", NM="_ZN5clang6driver5tools5Clang16getBaseInputNameERKN4llvm3opt7ArgListERKNS0_9InputInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5Clang16getBaseInputNameERKN4llvm3opt7ArgListERKNS0_9InputInfoE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getBaseInputName(/*const*/ ArgList /*&*/ Args, 
                  /*const*/ InputInfo /*&*/ Input) {
    return Args.MakeArgString(new Twine(path.filename(new StringRef(Input.getBaseInput()))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::getBaseInputStem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7415,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6793,
   FQN="clang::driver::tools::Clang::getBaseInputStem", NM="_ZN5clang6driver5tools5Clang16getBaseInputStemERKN4llvm3opt7ArgListERKNS3_11SmallVectorINS0_9InputInfoELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5Clang16getBaseInputStemERKN4llvm3opt7ArgListERKNS3_11SmallVectorINS0_9InputInfoELj4EEE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getBaseInputStem(/*const*/ ArgList /*&*/ Args, 
                  /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs) {
    /*const*/char$ptr/*char P*/ Str = $tryClone(getBaseInputName(Args, Inputs.$at(0)));
    {
      
      /*const*/char$ptr/*char P*/ End = $tryClone(strrchr(Str, $$DOT));
      if ((End != null)) {
        return Args.MakeArgString(new Twine(new std.string(Str, End)));
      }
    }
    
    return Str;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::getDependencyFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7425,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6803,
   FQN="clang::driver::tools::Clang::getDependencyFileName", NM="_ZN5clang6driver5tools5Clang21getDependencyFileNameERKN4llvm3opt7ArgListERKNS3_11SmallVectorINS0_9InputInfoELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5Clang21getDependencyFileNameERKN4llvm3opt7ArgListERKNS3_11SmallVectorINS0_9InputInfoELj4EEE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getDependencyFileName(/*const*/ ArgList /*&*/ Args, 
                       /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs) {
    // FIXME: Think about this more.
    std.string Res/*J*/= new std.string();
    {
      
      Arg /*P*/ OutputOpt = Args.getLastArg(new OptSpecifier(options.ID.OPT_o.getValue()));
      if ((OutputOpt != null)) {
        std.string Str/*J*/= new std.string(OutputOpt.getValue());
        Res.$assignMove(Str.substr(0, Str.rfind($$DOT)));
      } else {
        Res.$assign(getBaseInputStem(Args, Inputs));
      }
    }
    return Args.MakeArgString(new Twine($add_string$C_T(Res, /*KEEP_STR*/".d")));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddPreprocessingOptions">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*extra compounds*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 333,
   FQN="clang::driver::tools::Clang::AddPreprocessingOptions", NM="_ZNK5clang6driver5tools5Clang23AddPreprocessingOptionsERNS0_11CompilationERKNS0_9JobActionERKNS0_6DriverERKN4llvm3opt7ArgListERNSB_11SmallVectorIPKcLj16EEERKNS0_9InputInfoERKNSG_ISL_Lj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang23AddPreprocessingOptionsERNS0_11CompilationERKNS0_9JobActionERKNS0_6DriverERKN4llvm3opt7ArgListERNSB_11SmallVectorIPKcLj16EEERKNS0_9InputInfoERKNSG_ISL_Lj4EEE")
  //</editor-fold>
  private void AddPreprocessingOptions(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
                         /*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args, 
                         ArgStringList/*&*/ CmdArgs, 
                         /*const*/ InputInfo /*&*/ Output, 
                         /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs) /*const*/ {
    /*const*/boolean IsIAMCU = getToolChain().getTriple().isOSIAMCU();
    {// JAVA: extra compound
    Arg /*P*/ A;
    
    CheckPreprocessingOptions(D, Args);
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_C.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_CC.getValue()));
    
    // Handle dependency file generation.
    if (((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_M.getValue()), new OptSpecifier(options.ID.OPT_MM.getValue()))) != null)
       || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_MD.getValue()))) != null)
       || ((A = Args.getLastArg(new OptSpecifier(options.ID.OPT_MMD.getValue()))) != null)) {
      // Determine the output location.
      /*const*/char$ptr/*char P*/ DepFile;
      {
        Arg /*P*/ MF = Args.getLastArg(new OptSpecifier(options.ID.OPT_MF.getValue()));
        if ((MF != null)) {
          DepFile = $tryClone(MF.getValue());
          C.addFailureResultFile(DepFile, /*AddrOf*/JA);
        } else if (Output.getType() == types.ID.TY_Dependencies) {
          DepFile = $tryClone(Output.getFilename());
        } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_M.getValue()))
           || A.getOption().matches(new OptSpecifier(options.ID.OPT_MM.getValue()))) {
          DepFile = $tryClone($MINUS);
        } else {
          DepFile = $tryClone(getDependencyFileName(Args, Inputs));
          C.addFailureResultFile(DepFile, /*AddrOf*/JA);
        }
      }
      CmdArgs.push_back($("-dependency-file"));
      CmdArgs.push_back(DepFile);
      
      // Add a default target if one wasn't specified.
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_MT.getValue())) && !Args.hasArg(new OptSpecifier(options.ID.OPT_MQ.getValue()))) {
        /*const*/char$ptr/*char P*/ DepTarget;
        
        // If user provided -o, that is the dependency target, except
        // when we are only generating a dependency file.
        Arg /*P*/ OutputOpt = Args.getLastArg(new OptSpecifier(options.ID.OPT_o.getValue()));
        if ((OutputOpt != null) && Output.getType() != types.ID.TY_Dependencies) {
          DepTarget = $tryClone(OutputOpt.getValue());
        } else {
          // Otherwise derive from the base input.
          //
          // FIXME: This should use the computed output file location.
          SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef(Inputs.$at(0).getBaseInput()), 128);
          path.replace_extension(P, new Twine(/*KEEP_STR*/$o));
          DepTarget = $tryClone(Args.MakeArgString(new Twine(path.filename(P.$StringRef()))));
        }
        
        CmdArgs.push_back($("-MT"));
        SmallString/*128*/ Quoted/*J*/= new SmallString/*128*/(128);
        QuoteTarget(new StringRef(DepTarget), Quoted);
        CmdArgs.push_back(Args.MakeArgString(new Twine(Quoted)));
      }
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_M.getValue()))
         || A.getOption().matches(new OptSpecifier(options.ID.OPT_MD.getValue()))) {
        CmdArgs.push_back($("-sys-header-deps"));
      }
      if ((isa(PrecompileJobAction.class, JA)
         && !Args.hasArg(new OptSpecifier(options.ID.OPT_fno_module_file_deps.getValue())))
         || Args.hasArg(new OptSpecifier(options.ID.OPT_fmodule_file_deps.getValue()))) {
        CmdArgs.push_back($("-module-file-deps"));
      }
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_MG.getValue()))) {
      if (!(A != null) || A.getOption().matches(new OptSpecifier(options.ID.OPT_MD.getValue()))
         || A.getOption().matches(new OptSpecifier(options.ID.OPT_MMD.getValue()))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(D.Diag(diag.err_drv_mg_requires_m_or_mm)));
        } finally {
          $c$.$destroy();
        }
      }
      CmdArgs.push_back($("-MG"));
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_MP.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_MV.getValue()));
    }// JAVA: extra compound
    { // JAVA: extra compound
    // Convert all -MQ <target> args to -MT <quoted target>
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_MT.getValue()), new OptSpecifier(options.ID.OPT_MQ.getValue()))) {
      A.claim();
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_MQ.getValue()))) {
        CmdArgs.push_back($("-MT"));
        SmallString/*128*/ Quoted/*J*/= new SmallString/*128*/(128);
        QuoteTarget(new StringRef(A.getValue()), Quoted);
        CmdArgs.push_back(Args.MakeArgString(new Twine(Quoted)));
        // -MT flag - no change
      } else {
        A.render(Args, CmdArgs);
      }
    }
    } // JAVA: extra compound

    // Add -i* options, and automatically translate to
    // -include-pch/-include-pth for transparent PCH support. It's
    // wonky, but we include looking for .gch so we can support seamless
    // replacement into a build system already set up to be generating
    // .gch files.
    int YcIndex = -1, YuIndex = -1;
    {
      int AI = -1;
      /*const*/ Arg /*P*/ YcArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Yc.getValue()));
      /*const*/ Arg /*P*/ YuArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Yu.getValue()));
      for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_clang_i_Group.getValue()))) {
        // Walk the whole i_Group and skip non "-include" flags so that the index
        // here matches the index in the next loop below.
        ++AI;
        if (!A.getOption().matches(new OptSpecifier(options.ID.OPT_include.getValue()))) {
          continue;
        }
        if ((YcArg != null) && strcmp(A.getValue(), YcArg.getValue()) == 0) {
          YcIndex = AI;
        }
        if ((YuArg != null) && strcmp(A.getValue(), YuArg.getValue()) == 0) {
          YuIndex = AI;
        }
      }
    }
    if (isa(PrecompileJobAction.class, JA) && YcIndex != -1) {
      SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >> _Inputs/*J*/= new SmallVector<std.pairTypePtr<types.ID, /*const*/ Arg /*P*/ >>(16, new std.pairTypePtr(types.ID.TY_INVALID, null));
      D.BuildInputs(getToolChain(), C.getArgs(), _Inputs);
      assert (_Inputs.size() == 1) : "Need one input when building pch";
      CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-find-pch-source="), 
                  new Twine(_Inputs.$at(0).second.getValue()))));
    }
    
    boolean RenderedImplicitInclude = false;
    int AI = -1;
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_clang_i_Group.getValue()))) {
      ++AI;
      if (getToolChain().getDriver().IsCLMode()
         && A.getOption().matches(new OptSpecifier(options.ID.OPT_include.getValue()))) {
        // In clang-cl mode, /Ycfoo.h means that all code up to a foo.h
        // include is compiled into foo.h, and everything after goes into
        // the .obj file. /Yufoo.h means that all includes prior to and including
        // foo.h are completely skipped and replaced with a use of the pch file
        // for foo.h.  (Each flag can have at most one value, multiple /Yc flags
        // just mean that the last one wins.)  If /Yc and /Yu are both present
        // and refer to the same file, /Yc wins.
        // Note that OPT__SLASH_FI gets mapped to OPT_include.
        // FIXME: The code here assumes that /Yc and /Yu refer to the same file.
        // cl.exe seems to support both flags with different values, but that
        // seems strange (which flag does /Fp now refer to?), so don't implement
        // that until someone needs it.
        int PchIndex = YcIndex != -1 ? YcIndex : YuIndex;
        if (PchIndex != -1) {
          if (isa(PrecompileJobAction.class, JA)) {
            // When building the pch, skip all includes after the pch.
            assert (YcIndex != -1 && PchIndex == YcIndex);
            if (AI >= YcIndex) {
              continue;
            }
          } else {
            // When using the pch, skip all includes prior to the pch.
            if (AI < PchIndex) {
              A.claim();
              continue;
            }
            if (AI == PchIndex) {
              A.claim();
              CmdArgs.push_back($("-include-pch"));
              CmdArgs.push_back(Args.MakeArgString(new Twine(D.GetClPchPath(C, new StringRef(A.getValue())))));
              continue;
            }
          }
        }
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_include.getValue()))) {
        // Handling of gcc-style gch precompiled headers.
        boolean IsFirstImplicitInclude = !RenderedImplicitInclude;
        RenderedImplicitInclude = true;
        
        // Use PCH if the user requested it.
        boolean UsePCH = D.CCCUsePCH;
        
        boolean FoundPTH = false;
        boolean FoundPCH = false;
        SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef(A.getValue()), 128);
        // We want the files to have a name like foo.h.pch. Add a dummy extension
        // so that replace_extension does the right thing.
        P.$addassign(/*STRINGREF_STR*/".dummy");
        if (UsePCH) {
          path.replace_extension(P, new Twine(/*KEEP_STR*/"pch"));
          if (fs.exists(new Twine(P))) {
            FoundPCH = true;
          }
        }
        if (!FoundPCH) {
          path.replace_extension(P, new Twine(/*KEEP_STR*/"pth"));
          if (fs.exists(new Twine(P))) {
            FoundPTH = true;
          }
        }
        if (!FoundPCH && !FoundPTH) {
          path.replace_extension(P, new Twine(/*KEEP_STR*/"gch"));
          if (fs.exists(new Twine(P))) {
            FoundPCH = UsePCH;
            FoundPTH = !UsePCH;
          }
        }
        if (FoundPCH || FoundPTH) {
          if (IsFirstImplicitInclude) {
            A.claim();
            if (UsePCH) {
              CmdArgs.push_back($("-include-pch"));
            } else {
              CmdArgs.push_back($("-include-pth"));
            }
            CmdArgs.push_back(Args.MakeArgString(new Twine(P)));
            continue;
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Ignore the PCH if not first on command line and emit warning.
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_pch_not_first_include)), P.$StringRef()), 
                  new StringRef(A.getAsString(Args))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_isystem_after.getValue()))) {
        // Handling of paths which must come late.  These entries are handled by
        // the toolchain itself after the resource dir is inserted in the right
        // search order.
        // Do not claim the argument so that the use of the argument does not
        // silently go unnoticed on toolchains which do not honour the option.
        continue;
      }
      
      // Not translated, render as usual.
      A.claim();
      A.render(Args, CmdArgs);
    }
    
    Args.AddAllArgs(CmdArgs, 
        /*{ */new ArrayRef<OptSpecifier>($IDsToOptSpecifiers(new /*const*/ options.ID [/*5*/] {
              options.ID.OPT_D, options.ID.OPT_U, options.ID.OPT_I_Group, 
              options.ID.OPT_F, options.ID.OPT_index_header_map}))/* }*/);
    
    // Add -Wp, and -Xpreprocessor if using the preprocessor.
    
    // FIXME: There is a very unfortunate problem here, some troubled
    // souls abuse -Wp, to pass preprocessor options in gcc syntax. To
    // really support that we would have to parse and then translate
    // those options. :(
    Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wp_COMMA.getValue()), 
        new OptSpecifier(options.ID.OPT_Xpreprocessor.getValue()));
    {
      
      // -I- is a deprecated GCC feature, reject it.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_I_.getValue()));
      if ((A != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_I_dash_not_supported)), new StringRef(A.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // If we have a --sysroot, and don't have an explicit -isysroot flag, add an
    // -isysroot to the CC1 invocation.
    StringRef sysroot = C.getSysRoot();
    if ($noteq_StringRef(/*NO_COPY*/sysroot, /*STRINGREF_STR*/"")) {
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()))) {
        CmdArgs.push_back($("-isysroot"));
        CmdArgs.push_back(C.getArgs().MakeArgString(new Twine(sysroot)));
      }
    }
    
    // Parse additional include paths from environment variables.
    // FIXME: We should probably sink the logic for handling these from the
    // frontend into the driver. It will allow deleting 4 otherwise unused flags.
    // CPATH - included following the user specified includes (but prior to
    // builtin and standard includes).
    addDirectoryList(Args, CmdArgs, $("-I"), $("CPATH"));
    // C_INCLUDE_PATH - system includes enabled when compiling C.
    addDirectoryList(Args, CmdArgs, $("-c-isystem"), $("C_INCLUDE_PATH"));
    // CPLUS_INCLUDE_PATH - system includes enabled when compiling C++.
    addDirectoryList(Args, CmdArgs, $("-cxx-isystem"), $("CPLUS_INCLUDE_PATH"));
    // OBJC_INCLUDE_PATH - system includes enabled when compiling ObjC.
    addDirectoryList(Args, CmdArgs, $("-objc-isystem"), $("OBJC_INCLUDE_PATH"));
    // OBJCPLUS_INCLUDE_PATH - system includes enabled when compiling ObjC++.
    addDirectoryList(Args, CmdArgs, $("-objcxx-isystem"), $("OBJCPLUS_INCLUDE_PATH"));
    
    // While adding the include arguments, we also attempt to retrieve the
    // arguments of related offloading toolchains or arguments that are specific
    // of an offloading programming model.
    
    // Add C++ include arguments, if needed.
    if (types.isCXX(Inputs.$at(0).getType())) {
      getToolChain().AddClangCXXStdlibIncludeArgs(Args, CmdArgs);
      addExtraOffloadCXXStdlibIncludeArgs(C, JA, Args, CmdArgs);
    }
    
    // Add system include arguments for all targets but IAMCU.
    if (!IsIAMCU) {
      getToolChain().AddClangSystemIncludeArgs(Args, CmdArgs);
      addExtraOffloadCXXStdlibIncludeArgs(C, JA, Args, CmdArgs);
    } else {
      // For IAMCU add special include arguments.
      getToolChain().AddIAMCUIncludeArgs(Args, CmdArgs);
    }
    
    // Add offload include arguments, if needed.
    addExtraOffloadSpecificIncludeArgs(C, JA, Args, CmdArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddAArch64TargetArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1175,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1050,
   FQN="clang::driver::tools::Clang::AddAArch64TargetArgs", NM="_ZNK5clang6driver5tools5Clang20AddAArch64TargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang20AddAArch64TargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddAArch64TargetArgs(/*const*/ ArgList /*&*/ Args, 
                      ArgStringList/*&*/ CmdArgs) /*const*/ {
    std.string TripleStr = getToolChain().ComputeEffectiveClangTriple(Args);
    Triple Triple/*J*/= new Triple(new Twine(TripleStr));
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_mred_zone.getValue()), new OptSpecifier(options.ID.OPT_mno_red_zone.getValue()), true)
       || Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fapple_kext.getValue()))) {
      CmdArgs.push_back($("-disable-red-zone"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_mimplicit_float.getValue()), 
        new OptSpecifier(options.ID.OPT_mno_implicit_float.getValue()), true)) {
      CmdArgs.push_back($("-no-implicit-float"));
    }
    
    /*const*/char$ptr/*char P*/ ABIName = null;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mabi_EQ.getValue()));
      if ((A != null)) {
        ABIName = $tryClone(A.getValue());
      } else if (Triple.isOSDarwin()) {
        ABIName = $tryClone($("darwinpcs"));
      } else {
        ABIName = $tryClone($("aapcs"));
      }
    }
    
    CmdArgs.push_back($("-target-abi"));
    CmdArgs.push_back(ABIName);
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mfix_cortex_a53_835769.getValue()), 
          new OptSpecifier(options.ID.OPT_mno_fix_cortex_a53_835769.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-backend-option"));
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mfix_cortex_a53_835769.getValue()))) {
          CmdArgs.push_back($("-aarch64-fix-cortex-a53-835769=1"));
        } else {
          CmdArgs.push_back($("-aarch64-fix-cortex-a53-835769=0"));
        }
      } else if (Triple.isAndroid()) {
        // Enabled A53 errata (835769) workaround by default on android
        CmdArgs.push_back($("-backend-option"));
        CmdArgs.push_back($("-aarch64-fix-cortex-a53-835769=1"));
      }
    }
    {
      
      // Forward the -mglobal-merge option for explicit control over the pass.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mglobal_merge.getValue()), 
          new OptSpecifier(options.ID.OPT_mno_global_merge.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-backend-option"));
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mno_global_merge.getValue()))) {
          CmdArgs.push_back($("-aarch64-global-merge=false"));
        } else {
          CmdArgs.push_back($("-aarch64-global-merge=true"));
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddARMTargetArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1069,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 946,
   FQN="clang::driver::tools::Clang::AddARMTargetArgs", NM="_ZNK5clang6driver5tools5Clang16AddARMTargetArgsERKN4llvm6TripleERKNS3_3opt7ArgListERNS3_11SmallVectorIPKcLj16EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang16AddARMTargetArgsERKN4llvm6TripleERKNS3_3opt7ArgListERNS3_11SmallVectorIPKcLj16EEEb")
  //</editor-fold>
  private void AddARMTargetArgs(/*const*/ Triple /*&*/ _Triple, /*const*/ ArgList /*&*/ Args, 
                  ArgStringList/*&*/ CmdArgs, boolean KernelOrKext) /*const*/ {
    // Select the ABI to use.
    // FIXME: Support -meabi.
    // FIXME: Parts of this are duplicated in the backend, unify this somehow.
    /*const*/char$ptr/*char P*/ ABIName = null;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mabi_EQ.getValue()));
      if ((A != null)) {
        ABIName = $tryClone(A.getValue());
      } else if (_Triple.isOSBinFormatMachO()) {
        if (useAAPCSForMachO(_Triple)) {
          ABIName = $tryClone($("aapcs"));
        } else if (_Triple.isWatchABI()) {
          ABIName = $tryClone($("aapcs16"));
        } else {
          ABIName = $tryClone($("apcs-gnu"));
        }
      } else if (_Triple.isOSWindows()) {
        // FIXME: this is invalid for WindowsCE
        ABIName = $tryClone($("aapcs"));
      } else {
        // Select the default based on the platform.
        switch (_Triple.getEnvironment()) {
         case Android:
         case GNUEABI:
         case GNUEABIHF:
         case MuslEABI:
         case MuslEABIHF:
          ABIName = $tryClone($("aapcs-linux"));
          break;
         case EABIHF:
         case EABI:
          ABIName = $tryClone($("aapcs"));
          break;
         default:
          if (_Triple.getOS() == Triple.OSType.NetBSD) {
            ABIName = $tryClone($("apcs-gnu"));
          } else {
            ABIName = $tryClone($("aapcs"));
          }
          break;
        }
      }
    }
    CmdArgs.push_back($("-target-abi"));
    CmdArgs.push_back(ABIName);
    
    // Determine floating point ABI from the options & target defaults.
    ArmStatics.FloatABI ABI = ArmStatics.getARMFloatABI(getToolChain(), Args);
    if (ABI == ArmStatics.FloatABI.Soft) {
      // Floating point operations and argument passing are soft.
      // FIXME: This changes CPP defines, we need -target-soft-float.
      CmdArgs.push_back($("-msoft-float"));
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("soft"));
    } else if (ABI == ArmStatics.FloatABI.SoftFP) {
      // Floating point operations are hard, but argument passing is soft.
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("soft"));
    } else {
      // Floating point operations and argument passing are hard.
      assert (ABI == ArmStatics.FloatABI.Hard) : "Invalid float abi!";
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("hard"));
    }
    {
      
      // Forward the -mglobal-merge option for explicit control over the pass.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mglobal_merge.getValue()), 
          new OptSpecifier(options.ID.OPT_mno_global_merge.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-backend-option"));
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mno_global_merge.getValue()))) {
          CmdArgs.push_back($("-arm-global-merge=false"));
        } else {
          CmdArgs.push_back($("-arm-global-merge=true"));
        }
      }
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_mimplicit_float.getValue()), 
        new OptSpecifier(options.ID.OPT_mno_implicit_float.getValue()), true)) {
      CmdArgs.push_back($("-no-implicit-float"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddARM64TargetArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 69,
   FQN="clang::driver::tools::Clang::AddARM64TargetArgs", NM="_ZNK5clang6driver5tools5Clang18AddARM64TargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang18AddARM64TargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddARM64TargetArgs(/*const*/ ArgList /*&*/ Args, 
                    ArgStringList/*&*/ CmdArgs) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddMIPSTargetArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1464,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1309,
   FQN="clang::driver::tools::Clang::AddMIPSTargetArgs", NM="_ZNK5clang6driver5tools5Clang17AddMIPSTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang17AddMIPSTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddMIPSTargetArgs(/*const*/ ArgList /*&*/ Args, 
                   ArgStringList/*&*/ CmdArgs) /*const*/ {
    /*const*/ Driver /*&*/ D = getToolChain().getDriver();
    StringRef CPUName/*J*/= new StringRef();
    StringRef ABIName/*J*/= new StringRef();
    /*const*/ Triple /*&*/ Triple = getToolChain().getTriple();
    MipsStatics.getMipsCPUAndABI(Args, Triple, CPUName, ABIName);
    
    CmdArgs.push_back($("-target-abi"));
    CmdArgs.push_back(ABIName.data());
    
    MipsStatics.FloatABI ABI = getMipsFloatABI(D, Args);
    if (ABI == MipsStatics.FloatABI.Soft) {
      // Floating point operations and argument passing are soft.
      CmdArgs.push_back($("-msoft-float"));
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("soft"));
    } else {
      // Floating point operations and argument passing are hard.
      assert (ABI == MipsStatics.FloatABI.Hard) : "Invalid float abi!";
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("hard"));
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mxgot.getValue()), new OptSpecifier(options.ID.OPT_mno_xgot.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mxgot.getValue()))) {
          CmdArgs.push_back($("-mllvm"));
          CmdArgs.push_back($("-mxgot"));
        }
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mldc1_sdc1.getValue()), 
          new OptSpecifier(options.ID.OPT_mno_ldc1_sdc1.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mno_ldc1_sdc1.getValue()))) {
          CmdArgs.push_back($("-mllvm"));
          CmdArgs.push_back($("-mno-ldc1-sdc1"));
        }
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcheck_zero_division.getValue()), 
          new OptSpecifier(options.ID.OPT_mno_check_zero_division.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mno_check_zero_division.getValue()))) {
          CmdArgs.push_back($("-mllvm"));
          CmdArgs.push_back($("-mno-check-zero-division"));
        }
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_G.getValue()));
      if ((A != null)) {
        StringRef v = new StringRef(A.getValue());
        CmdArgs.push_back($("-mllvm"));
        CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-mips-ssection-threshold=", v)));
        A.claim();
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcompact_branches_EQ.getValue()));
      if ((A != null)) {
        StringRef Val = new StringRef(A.getValue());
        if (MipsStatics.hasCompactBranches(CPUName)) {
          if ($eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"never") || $eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"always") || $eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"optimal")) {
            CmdArgs.push_back($("-mllvm"));
            CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-mips-compact-branches=", Val)));
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_option_argument)), 
                      A.getOption().getName()), /*NO_COPY*/Val));
            } finally {
              $c$.$destroy();
            }
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_target_unsupported_compact_branches)), /*NO_COPY*/CPUName));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddPPCTargetArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1648,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1478,
   FQN="clang::driver::tools::Clang::AddPPCTargetArgs", NM="_ZNK5clang6driver5tools5Clang16AddPPCTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang16AddPPCTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddPPCTargetArgs(/*const*/ ArgList /*&*/ Args, 
                  ArgStringList/*&*/ CmdArgs) /*const*/ {
    // Select the ABI to use.
    /*const*/char$ptr/*char P*/ ABIName = null;
    if (getToolChain().getTriple().isOSLinux()) {
      switch (getToolChain().getArch()) {
       case ppc64:
        {
          // When targeting a processor that supports QPX, or if QPX is
          // specifically enabled, default to using the ABI that supports QPX (so
          // long as it is not specifically disabled).
          boolean HasQPX = false;
          {
            Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
            if ((A != null)) {
              HasQPX = $eq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/"a2q");
            }
          }
          HasQPX = Args.hasFlag(new OptSpecifier(options.ID.OPT_mqpx.getValue()), new OptSpecifier(options.ID.OPT_mno_qpx.getValue()), HasQPX);
          if (HasQPX) {
            ABIName = $tryClone($("elfv1-qpx"));
            break;
          }
          
          ABIName = $tryClone($("elfv1"));
          break;
        }
       case ppc64le:
        ABIName = $tryClone($("elfv2"));
        break;
       default:
        break;
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mabi_EQ.getValue()));
      if ((A != null)) {
        // The ppc64 linux abis are all "altivec" abis by default. Accept and ignore
        // the option if given as we don't have backend support for any targets
        // that don't use the altivec abi.
        if ($noteq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/"altivec")) {
          ABIName = $tryClone(A.getValue());
        }
      }
    }
    
    PpcStatics.FloatABI FloatABI = PpcStatics.getPPCFloatABI(getToolChain().getDriver(), Args);
    if (FloatABI == PpcStatics.FloatABI.Soft) {
      // Floating point operations and argument passing are soft.
      CmdArgs.push_back($("-msoft-float"));
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("soft"));
    } else {
      // Floating point operations and argument passing are hard.
      assert (FloatABI == PpcStatics.FloatABI.Hard) : "Invalid float abi!";
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("hard"));
    }
    if ((ABIName != null)) {
      CmdArgs.push_back($("-target-abi"));
      CmdArgs.push_back(ABIName);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddR600TargetArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 75,
   FQN="clang::driver::tools::Clang::AddR600TargetArgs", NM="_ZNK5clang6driver5tools5Clang17AddR600TargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang17AddR600TargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddR600TargetArgs(/*const*/ ArgList /*&*/ Args, 
                   ArgStringList/*&*/ CmdArgs) /*const*/ {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddSparcTargetArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1776,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1557,
   FQN="clang::driver::tools::Clang::AddSparcTargetArgs", NM="_ZNK5clang6driver5tools5Clang18AddSparcTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang18AddSparcTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddSparcTargetArgs(/*const*/ ArgList /*&*/ Args, 
                    ArgStringList/*&*/ CmdArgs) /*const*/ {
    SparcStatics.FloatABI FloatABI = SparcStatics.getSparcFloatABI(getToolChain().getDriver(), Args);
    if (FloatABI == SparcStatics.FloatABI.Soft) {
      // Floating point operations and argument passing are soft.
      CmdArgs.push_back($("-msoft-float"));
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("soft"));
    } else {
      // Floating point operations and argument passing are hard.
      assert (FloatABI == SparcStatics.FloatABI.Hard) : "Invalid float abi!";
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("hard"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddSystemZTargetArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1794,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 79,
   FQN="clang::driver::tools::Clang::AddSystemZTargetArgs", NM="_ZNK5clang6driver5tools5Clang20AddSystemZTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang20AddSystemZTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddSystemZTargetArgs(/*const*/ ArgList /*&*/ Args, 
                      ArgStringList/*&*/ CmdArgs) /*const*/ {
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_mbackchain.getValue()), new OptSpecifier(options.ID.OPT_mno_backchain.getValue()), false)) {
      CmdArgs.push_back($("-mbackchain"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddX86TargetArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2251,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2017,
   FQN="clang::driver::tools::Clang::AddX86TargetArgs", NM="_ZNK5clang6driver5tools5Clang16AddX86TargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang16AddX86TargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddX86TargetArgs(/*const*/ ArgList /*&*/ Args, 
                  ArgStringList/*&*/ CmdArgs) /*const*/ {
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_mred_zone.getValue()), new OptSpecifier(options.ID.OPT_mno_red_zone.getValue()), true)
       || Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fapple_kext.getValue()))) {
      CmdArgs.push_back($("-disable-red-zone"));
    }
    
    // Default to avoid implicit floating-point for kernel/kext code, but allow
    // that to be overridden with -mno-soft-float.
    boolean NoImplicitFloat = (Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fapple_kext.getValue())));
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_msoft_float.getValue()), new OptSpecifier(options.ID.OPT_mno_soft_float.getValue()), 
          new OptSpecifier(options.ID.OPT_mimplicit_float.getValue()), new OptSpecifier(options.ID.OPT_mno_implicit_float.getValue()));
      if ((A != null)) {
        /*const*/ Option /*&*/ O = A.getOption();
        NoImplicitFloat = (O.matches(new OptSpecifier(options.ID.OPT_mno_implicit_float.getValue()))
           || O.matches(new OptSpecifier(options.ID.OPT_msoft_float.getValue())));
      }
    }
    if (NoImplicitFloat) {
      CmdArgs.push_back($("-no-implicit-float"));
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_masm_EQ.getValue()));
      if ((A != null)) {
        StringRef Value = new StringRef(A.getValue());
        if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"intel") || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"att")) {
          CmdArgs.push_back($("-mllvm"));
          CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-x86-asm-syntax=", Value)));
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getToolChain().getDriver().Diag(diag.err_drv_unsupported_option_argument)), 
                    A.getOption().getName()), /*NO_COPY*/Value));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Set flags to support MCU ABI.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_miamcu.getValue()), new OptSpecifier(options.ID.OPT_mno_iamcu.getValue()), false)) {
      CmdArgs.push_back($("-mfloat-abi"));
      CmdArgs.push_back($("soft"));
      CmdArgs.push_back($("-mstack-alignment=4"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddHexagonTargetArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2291,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2050,
   FQN="clang::driver::tools::Clang::AddHexagonTargetArgs", NM="_ZNK5clang6driver5tools5Clang20AddHexagonTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang20AddHexagonTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddHexagonTargetArgs(/*const*/ ArgList /*&*/ Args, 
                      ArgStringList/*&*/ CmdArgs) /*const*/ {
    CmdArgs.push_back($("-mqdsp6-compat"));
    CmdArgs.push_back($("-Wreturn-type"));
    {
      
      OptionalUInt G = HexagonToolChain.getSmallDataThreshold(Args);
      if (G.$bool()) {
        std.string N = llvm.utostr($uint2ulong(G.getValue()));
        std.string Opt = $add_string_string$C(new std.string(/*KEEP_STR*/"-hexagon-small-data-threshold="), N);
        CmdArgs.push_back($("-mllvm"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(Opt)));
      }
    }
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_fno_short_enums.getValue()))) {
      CmdArgs.push_back($("-fshort-enums"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_mieee_rnd_near.getValue())) != null)) {
      CmdArgs.push_back($("-mllvm"));
      CmdArgs.push_back($("-enable-hexagon-ieee-rnd-near"));
    }
    CmdArgs.push_back($("-mllvm"));
    CmdArgs.push_back($("-machine-sink-split=0"));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddLanaiTargetArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2313,
   FQN="clang::driver::tools::Clang::AddLanaiTargetArgs", NM="_ZNK5clang6driver5tools5Clang18AddLanaiTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang18AddLanaiTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddLanaiTargetArgs(/*const*/ ArgList /*&*/ Args, 
                    ArgStringList/*&*/ CmdArgs) /*const*/ {
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
      if ((A != null)) {
        StringRef CPUName = new StringRef(A.getValue());
        
        CmdArgs.push_back($("-target-cpu"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(CPUName)));
      }
    }
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mregparm_EQ.getValue()));
      if ((A != null)) {
        StringRef Value = new StringRef(A.getValue());
        // Only support mregparm=4 to support old usage. Report error for all other
        // cases.
        int$ref Mregparm = create_int$ref();
        if (Value.getAsInteger$Signed(10, Mregparm)) {
          if (Mregparm.$deref() != 4) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getToolChain().getDriver().Diag(diag.err_drv_unsupported_option_argument)), 
                      A.getOption().getName()), /*NO_COPY*/Value));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddWebAssemblyTargetArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 2336,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 2072,
   FQN="clang::driver::tools::Clang::AddWebAssemblyTargetArgs", NM="_ZNK5clang6driver5tools5Clang24AddWebAssemblyTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang24AddWebAssemblyTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddWebAssemblyTargetArgs(/*const*/ ArgList /*&*/ Args, 
                          ArgStringList/*&*/ CmdArgs) /*const*/ {
    // Default to "hidden" visibility.
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_fvisibility_EQ.getValue()), 
        new OptSpecifier(options.ID.OPT_fvisibility_ms_compat.getValue()))) {
      CmdArgs.push_back($("-fvisibility"));
      CmdArgs.push_back($("hidden"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::RewriteKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 89,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 88,
   FQN="clang::driver::tools::Clang::RewriteKind", NM="_ZN5clang6driver5tools5Clang11RewriteKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5Clang11RewriteKindE")
  //</editor-fold>
  private enum RewriteKind implements Native.ComparableLower {
    RK_None(0),
    RK_Fragile(RK_None.getValue() + 1),
    RK_NonFragile(RK_Fragile.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RewriteKind valueOf(int val) {
      RewriteKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RewriteKind[] VALUES;
      private static final RewriteKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RewriteKind kind : RewriteKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RewriteKind[min < 0 ? (1-min) : 0];
        VALUES = new RewriteKind[max >= 0 ? (1+max) : 0];
        for (RewriteKind kind : RewriteKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private RewriteKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((RewriteKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((RewriteKind)obj).value);}
    //</editor-fold>
  };
  
  
  /// Add options related to the Objective-C runtime/ABI.
  ///
  /// Returns true if the runtime is non-fragile.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddObjCRuntimeArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 5585,
   FQN="clang::driver::tools::Clang::AddObjCRuntimeArgs", NM="_ZNK5clang6driver5tools5Clang18AddObjCRuntimeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEENS2_11RewriteKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang18AddObjCRuntimeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEENS2_11RewriteKindE")
  //</editor-fold>
  private ObjCRuntime AddObjCRuntimeArgs(/*const*/ ArgList /*&*/ args, 
                    ArgStringList/*&*/ cmdArgs, 
                    RewriteKind rewriteKind) /*const*/ {
    // Look for the controlling runtime option.
    Arg /*P*/ runtimeArg = args.getLastArg(new OptSpecifier(options.ID.OPT_fnext_runtime.getValue()), new OptSpecifier(options.ID.OPT_fgnu_runtime.getValue()), 
        new OptSpecifier(options.ID.OPT_fobjc_runtime_EQ.getValue()));
    
    // Just forward -fobjc-runtime= to the frontend.  This supercedes
    // options about fragility.
    if ((runtimeArg != null)
       && runtimeArg.getOption().matches(new OptSpecifier(options.ID.OPT_fobjc_runtime_EQ.getValue()))) {
      ObjCRuntime runtime/*J*/= new ObjCRuntime();
      StringRef value = new StringRef(runtimeArg.getValue());
      if (runtime.tryParse(new StringRef(value))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getToolChain().getDriver().Diag(diag.err_drv_unknown_objc_runtime)), 
              /*NO_COPY*/value));
        } finally {
          $c$.$destroy();
        }
      }
      
      runtimeArg.render(args, cmdArgs);
      return runtime;
    }
    
    // Otherwise, we'll need the ABI "version".  Version numbers are
    // slightly confusing for historical reasons:
    //   1 - Traditional "fragile" ABI
    //   2 - Non-fragile ABI, version 1
    //   3 - Non-fragile ABI, version 2
    /*uint*/int objcABIVersion = 1;
    {
      // If -fobjc-abi-version= is present, use that to set the version.
      Arg /*P*/ abiArg = args.getLastArg(new OptSpecifier(options.ID.OPT_fobjc_abi_version_EQ.getValue()));
      if ((abiArg != null)) {
        StringRef value = new StringRef(abiArg.getValue());
        if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"1")) {
          objcABIVersion = 1;
        } else if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"2")) {
          objcABIVersion = 2;
        } else if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"3")) {
          objcABIVersion = 3;
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getToolChain().getDriver().Diag(diag.err_drv_clang_unsupported)), /*NO_COPY*/value));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        // Otherwise, determine if we are using the non-fragile ABI.
        boolean nonFragileABIIsDefault = (rewriteKind == RewriteKind.RK_NonFragile
           || (rewriteKind == RewriteKind.RK_None
           && getToolChain().IsObjCNonFragileABIDefault()));
        if (args.hasFlag(new OptSpecifier(options.ID.OPT_fobjc_nonfragile_abi.getValue()), 
            new OptSpecifier(options.ID.OPT_fno_objc_nonfragile_abi.getValue()), 
            nonFragileABIIsDefault)) {
          /*uint*/int nonFragileABIVersion = 2;
          {
            
            Arg /*P*/ _abiArg = args.getLastArg(new OptSpecifier(options.ID.OPT_fobjc_nonfragile_abi_version_EQ.getValue()));
            if ((_abiArg != null)) {
              StringRef value = new StringRef(_abiArg.getValue());
              if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"1")) {
                nonFragileABIVersion = 1;
              } else if ($eq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"2")) {
                nonFragileABIVersion = 2;
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getToolChain().getDriver().Diag(diag.err_drv_clang_unsupported)), 
                      /*NO_COPY*/value));
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
          
          objcABIVersion = 1 + nonFragileABIVersion;
        } else {
          objcABIVersion = 1;
        }
      }
    }
    
    // We don't actually care about the ABI version other than whether
    // it's non-fragile.
    boolean isNonFragile = objcABIVersion != 1;
    
    // If we have no runtime argument, ask the toolchain for its default runtime.
    // However, the rewriter only really supports the Mac runtime, so assume that.
    ObjCRuntime runtime/*J*/= new ObjCRuntime();
    if (!(runtimeArg != null)) {
      switch (rewriteKind) {
       case RK_None:
        runtime.$assignMove(getToolChain().getDefaultObjCRuntime(isNonFragile));
        break;
       case RK_Fragile:
        runtime.$assignMove(new ObjCRuntime(ObjCRuntime.Kind.FragileMacOSX, new VersionTuple()));
        break;
       case RK_NonFragile:
        runtime.$assignMove(new ObjCRuntime(ObjCRuntime.Kind.MacOSX, new VersionTuple()));
        break;
      }
      // -fnext-runtime
    } else if (runtimeArg.getOption().matches(new OptSpecifier(options.ID.OPT_fnext_runtime.getValue()))) {
      // On Darwin, make this use the default behavior for the toolchain.
      if (getToolChain().getTriple().isOSDarwin()) {
        runtime.$assignMove(getToolChain().getDefaultObjCRuntime(isNonFragile));
        // Otherwise, build for a generic macosx port.
      } else {
        runtime.$assignMove(new ObjCRuntime(ObjCRuntime.Kind.MacOSX, new VersionTuple()));
      }
      // -fgnu-runtime
    } else {
      assert (runtimeArg.getOption().matches(new OptSpecifier(options.ID.OPT_fgnu_runtime.getValue())));
      // Legacy behaviour is to target the gnustep runtime if we are in
      // non-fragile mode or the GCC runtime in fragile mode.
      if (isNonFragile) {
        runtime.$assignMove(new ObjCRuntime(ObjCRuntime.Kind.GNUstep, new VersionTuple(1, 6)));
      } else {
        runtime.$assignMove(new ObjCRuntime(ObjCRuntime.Kind.GCC, new VersionTuple()));
      }
    }
    
    cmdArgs.push_back(args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"-fobjc-runtime=", runtime.getAsString()))));
    return runtime;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::AddClangCLArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6285,
   FQN="clang::driver::tools::Clang::AddClangCLArgs", NM="_ZNK5clang6driver5tools5Clang14AddClangCLArgsERKN4llvm3opt7ArgListENS0_5types2IDERNS3_11SmallVectorIPKcLj16EEEPNS_14codegenoptions13DebugInfoKindEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang14AddClangCLArgsERKN4llvm3opt7ArgListENS0_5types2IDERNS3_11SmallVectorIPKcLj16EEEPNS_14codegenoptions13DebugInfoKindEPb")
  //</editor-fold>
  private void AddClangCLArgs(/*const*/ ArgList /*&*/ Args, types.ID InputType, 
                ArgStringList/*&*/ CmdArgs, 
                type$ptr<DebugInfoKind> _DebugInfoKind, 
                bool$ptr/*bool P*/ EmitCodeView) /*const*/ {
    /*uint*/int RTOptionID = options.ID.OPT__SLASH_MT.getValue();
    if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_LDd.getValue()))) {
      // The /LDd option implies /MTd. The dependent lib part can be overridden,
      // but defining _DEBUG is sticky.
      RTOptionID = options.ID.OPT__SLASH_MTd.getValue();
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_M_Group.getValue()));
      if ((A != null)) {
        RTOptionID = A.getOption().getID();
      }
    }
    
    StringRef FlagForCRT/*J*/= new StringRef();
    switch (options.ID.valueOf(RTOptionID)) {
     case OPT__SLASH_MD:
      if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_LDd.getValue()))) {
        CmdArgs.push_back($("-D_DEBUG"));
      }
      CmdArgs.push_back($("-D_MT"));
      CmdArgs.push_back($("-D_DLL"));
      FlagForCRT.$assignMove(/*STRINGREF_STR*/"--dependent-lib=msvcrt");
      break;
     case OPT__SLASH_MDd:
      CmdArgs.push_back($("-D_DEBUG"));
      CmdArgs.push_back($("-D_MT"));
      CmdArgs.push_back($("-D_DLL"));
      FlagForCRT.$assignMove(/*STRINGREF_STR*/"--dependent-lib=msvcrtd");
      break;
     case OPT__SLASH_MT:
      if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_LDd.getValue()))) {
        CmdArgs.push_back($("-D_DEBUG"));
      }
      CmdArgs.push_back($("-D_MT"));
      CmdArgs.push_back($("-flto-visibility-public-std"));
      FlagForCRT.$assignMove(/*STRINGREF_STR*/"--dependent-lib=libcmt");
      break;
     case OPT__SLASH_MTd:
      CmdArgs.push_back($("-D_DEBUG"));
      CmdArgs.push_back($("-D_MT"));
      CmdArgs.push_back($("-flto-visibility-public-std"));
      FlagForCRT.$assignMove(/*STRINGREF_STR*/"--dependent-lib=libcmtd");
      break;
     default:
      throw new llvm_unreachable("Unexpected option ID.");
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_Zl.getValue()))) {
      CmdArgs.push_back($("-D_VC_NODEFAULTLIB"));
    } else {
      CmdArgs.push_back(FlagForCRT.data());
      
      // This provides POSIX compatibility (maps 'open' to '_open'), which most
      // users want.  The /Za flag to cl.exe turns this off, but it's not
      // implemented in clang.
      CmdArgs.push_back($("--dependent-lib=oldnames"));
    }
    
    // Both /showIncludes and /E (and /EP) write to stdout. Allowing both
    // would produce interleaved output, so ignore /showIncludes in such cases.
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_E.getValue())) && !Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_EP.getValue()))) {
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_show_includes.getValue()));
        if ((A != null)) {
          A.render(Args, CmdArgs);
        }
      }
    }
    
    // This controls whether or not we emit RTTI data for polymorphic types.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT__SLASH_GR_.getValue()), new OptSpecifier(options.ID.OPT__SLASH_GR.getValue()), 
        /*default=*/ false)) {
      CmdArgs.push_back($("-fno-rtti-data"));
    }
    
    // This controls whether or not we emit stack-protector instrumentation.
    // In MSVC, Buffer Security Check (/GS) is on by default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT__SLASH_GS.getValue()), new OptSpecifier(options.ID.OPT__SLASH_GS_.getValue()), 
        /*default=*/ true)) {
      CmdArgs.push_back($("-stack-protector"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(JD$Int.INSTANCE, LangOptions.StackProtectorMode.SSPStrong.getValue())));
    }
    {
      
      // Emit CodeView if -Z7, -Zd, or -gline-tables-only are present.
      Arg /*P*/ DebugInfoArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Z7.getValue()), new OptSpecifier(options.ID.OPT__SLASH_Zd.getValue()), 
          new OptSpecifier(options.ID.OPT_gline_tables_only.getValue()));
      if ((DebugInfoArg != null)) {
        EmitCodeView.$set(true);
        if (DebugInfoArg.getOption().matches(new OptSpecifier(options.ID.OPT__SLASH_Z7.getValue()))) {
          _DebugInfoKind.$set(DebugInfoKind.LimitedDebugInfo);
        } else {
          _DebugInfoKind.$set(DebugInfoKind.DebugLineTablesOnly);
        }
        CmdArgs.push_back($("-gcodeview"));
      } else {
        EmitCodeView.$set(false);
      }
    }
    
    /*const*/ Driver /*&*/ D = getToolChain().getDriver();
    EHFlags EH = parseClangCLEHFlags(D, Args);
    if (EH.Synch || EH.Asynch) {
      if (types.isCXX(InputType)) {
        CmdArgs.push_back($("-fcxx-exceptions"));
      }
      CmdArgs.push_back($("-fexceptions"));
    }
    if (types.isCXX(InputType) && EH.Synch && EH.NoUnwindC) {
      CmdArgs.push_back($("-fexternc-nounwind"));
    }
    
    // /EP should expand to -E -P.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_EP.getValue()))) {
      CmdArgs.push_back($("-E"));
      CmdArgs.push_back($("-P"));
    }
    
    /*uint*/int VolatileOptionID;
    if (getToolChain().getArch() == Triple.ArchType.x86_64
       || getToolChain().getArch() == Triple.ArchType.x86) {
      VolatileOptionID = options.ID.OPT__SLASH_volatile_ms.getValue();
    } else {
      VolatileOptionID = options.ID.OPT__SLASH_volatile_iso.getValue();
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_volatile_Group.getValue()));
      if ((A != null)) {
        VolatileOptionID = A.getOption().getID();
      }
    }
    if (VolatileOptionID == options.ID.OPT__SLASH_volatile_ms.getValue()) {
      CmdArgs.push_back($("-fms-volatile"));
    }
    
    Arg /*P*/ MostGeneralArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_vmg.getValue()));
    Arg /*P*/ BestCaseArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_vmb.getValue()));
    if ((MostGeneralArg != null) && (BestCaseArg != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                new StringRef(MostGeneralArg.getAsString(Args))), new StringRef(BestCaseArg.getAsString(Args))));
      } finally {
        $c$.$destroy();
      }
    }
    if ((MostGeneralArg != null)) {
      Arg /*P*/ SingleArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_vms.getValue()));
      Arg /*P*/ MultipleArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_vmm.getValue()));
      Arg /*P*/ VirtualArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_vmv.getValue()));
      
      Arg /*P*/ FirstConflict = (SingleArg != null) ? SingleArg : MultipleArg;
      Arg /*P*/ SecondConflict = (VirtualArg != null) ? VirtualArg : MultipleArg;
      if ((FirstConflict != null) && (SecondConflict != null) && FirstConflict != SecondConflict) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                  new StringRef(FirstConflict.getAsString(Args))), 
              new StringRef(SecondConflict.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
      if ((SingleArg != null)) {
        CmdArgs.push_back($("-fms-memptr-rep=single"));
      } else if ((MultipleArg != null)) {
        CmdArgs.push_back($("-fms-memptr-rep=multiple"));
      } else {
        CmdArgs.push_back($("-fms-memptr-rep=virtual"));
      }
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Gd.getValue())) != null)) {
      CmdArgs.push_back($("-fdefault-calling-conv=cdecl"));
    } else if ((Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Gr.getValue())) != null)) {
      CmdArgs.push_back($("-fdefault-calling-conv=fastcall"));
    } else if ((Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Gz.getValue())) != null)) {
      CmdArgs.push_back($("-fdefault-calling-conv=stdcall"));
    } else if ((Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_Gv.getValue())) != null)) {
      CmdArgs.push_back($("-fdefault-calling-conv=vectorcall"));
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_vtordisp_mode_EQ.getValue()));
      if ((A != null)) {
        A.render(Args, CmdArgs);
      }
    }
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_fdiagnostics_format_EQ.getValue()))) {
      CmdArgs.push_back($("-fdiagnostics-format"));
      if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_fallback.getValue()))) {
        CmdArgs.push_back($("msvc-fallback"));
      } else {
        CmdArgs.push_back($("msvc"));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::getCLFallback">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6451,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 5897,
   FQN="clang::driver::tools::Clang::getCLFallback", NM="_ZNK5clang6driver5tools5Clang13getCLFallbackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang13getCLFallbackEv")
  //</editor-fold>
  private VisualstudioStatics.Compiler /*P*/ getCLFallback() /*const*/ {
    if (!CLFallback.$bool()) {
      CLFallback.reset(new VisualstudioStatics.Compiler(getToolChain()));
    }
    return CLFallback.get();
  }

  
  private /*mutable */std.unique_ptr<VisualstudioStatics.Compiler> CLFallback;
/*public:*/
  // CAUTION! The first constructor argument ("clang") is not arbitrary,
  // as it is for other tools. Some operations on a Tool actually test
  // whether that tool is Clang based on the Tool's Name as a string.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::Clang">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 107,
   FQN="clang::driver::tools::Clang::Clang", NM="_ZN5clang6driver5tools5ClangC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5ClangC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Clang(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("clang", "clang frontend", TC, RF_Full), CLFallback()*/ 
    //START JInit
    super($("clang"), $("clang frontend"), TC, ResponseFileSupport.RF_Full);
    this.CLFallback = new std.unique_ptr<VisualstudioStatics.Compiler>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::hasGoodDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 110,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 109,
   FQN="clang::driver::tools::Clang::hasGoodDiagnostics", NM="_ZNK5clang6driver5tools5Clang18hasGoodDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang18hasGoodDiagnosticsEv")
  //</editor-fold>
  @Override public boolean hasGoodDiagnostics() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::hasIntegratedAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 111,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 110,
   FQN="clang::driver::tools::Clang::hasIntegratedAssembler", NM="_ZNK5clang6driver5tools5Clang22hasIntegratedAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang22hasIntegratedAssemblerEv")
  //</editor-fold>
  @Override public boolean hasIntegratedAssembler() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 111,
   FQN="clang::driver::tools::Clang::hasIntegratedCPP", NM="_ZNK5clang6driver5tools5Clang16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::canEmitIR">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 113,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 112,
   FQN="clang::driver::tools::Clang::canEmitIR", NM="_ZNK5clang6driver5tools5Clang9canEmitIREv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang9canEmitIREv")
  //</editor-fold>
  @Override public boolean canEmitIR() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*#ifdef NDEBUG*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3826,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 3419,
   FQN="clang::driver::tools::Clang::ConstructJob", NM="_ZNK5clang6driver5tools5Clang12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS8_Lj4EEERKNSB_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5Clang12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS8_Lj4EEERKNSB_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    std.string TripleStr = getToolChain().ComputeEffectiveClangTriple(Args);
    /*const*/ Triple _Triple/*J*/= new Triple(new Twine(TripleStr));
    
    boolean KernelOrKext = Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()), new OptSpecifier(options.ID.OPT_fapple_kext.getValue()));
    /*const*/ Driver /*&*/ D = getToolChain().getDriver();
    ArgStringList CmdArgs/*J*/= new ArgStringList();
    
    boolean IsWindowsGNU = getToolChain().getTriple().isWindowsGNUEnvironment();
    boolean IsWindowsCygnus = getToolChain().getTriple().isWindowsCygwinEnvironment();
    boolean IsWindowsMSVC = getToolChain().getTriple().isWindowsMSVCEnvironment();
    boolean IsPS4CPU = getToolChain().getTriple().isPS4CPU();
    boolean IsIAMCU = getToolChain().getTriple().isOSIAMCU();
    
    // Check number of inputs for sanity. We need at least one input.
    assert ($greatereq_uint(Inputs.size(), 1)) : "Must have at least one input.";
    /*const*/ InputInfo /*&*/ Input = Inputs.$at(0);
    // CUDA compilation may have multiple inputs (source file + results of
    // device-side compilations). All other jobs are expected to have exactly one
    // input.
    boolean IsCuda = JA.isOffloading(Action.OffloadKind.OFK_Cuda);
    assert ((IsCuda || Inputs.size() == 1)) : "Unable to handle multiple inputs.";
    
    // C++ is not supported for IAMCU.
    if (IsIAMCU && types.isCXX(Input.getType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_clang_unsupported)), /*KEEP_STR*/"C++ for IAMCU"));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Invoke ourselves in -cc1 mode.
    //
    // FIXME: Implement custom jobs for internal actions.
    CmdArgs.push_back($("-cc1"));
    
    // Add the "effective" target triple.
    CmdArgs.push_back($("-triple"));
    CmdArgs.push_back(Args.MakeArgString(new Twine(TripleStr)));
    if (IsCuda) {
      // We have to pass the triple of the host if compiling for a CUDA device and
      // vice-versa.
      std.string NormalizedTriple/*J*/= new std.string();
      if (JA.isDeviceOffloading(Action.OffloadKind.OFK_Cuda)) {
        NormalizedTriple.$assignMove(C.getSingleOffloadToolChain(Action.OffloadKind.OFK_Host).
                getTriple().
                normalize());
      } else {
        NormalizedTriple.$assignMove(C.getSingleOffloadToolChain(Action.OffloadKind.OFK_Cuda).
                getTriple().
                normalize());
      }
      
      CmdArgs.push_back($("-aux-triple"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(NormalizedTriple)));
    }
    if (_Triple.isOSWindows() && (_Triple.getArch() == Triple.ArchType.arm
       || _Triple.getArch() == Triple.ArchType.thumb)) {
      /*uint*/int Offset = _Triple.getArch() == Triple.ArchType.arm ? 4 : 6;
      /*uint*/uint$ref Version = create_uint$ref();
      _Triple.getArchName().substr(Offset).getAsInteger$NotSigned(10, Version);
      if ($less_uint(Version, 7)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_target_unsupported_arch)), _Triple.getArchName()), 
              new StringRef(TripleStr)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Push all default warning arguments that are specific to
    // the given target.  These come before user provided warning options
    // are provided.
    getToolChain().addClangWarningOptions(CmdArgs);
    
    // Select the appropriate action.
    RewriteKind rewriteKind = RewriteKind.RK_None;
    if (isa(AnalyzeJobAction.class, JA)) {
      assert (JA.getType() == types.ID.TY_Plist) : "Invalid output type.";
      CmdArgs.push_back($("-analyze"));
    } else if (isa(MigrateJobAction.class, JA)) {
      CmdArgs.push_back($("-migrate"));
    } else if (isa(PreprocessJobAction.class, JA)) {
      if (Output.getType() == types.ID.TY_Dependencies) {
        CmdArgs.push_back($("-Eonly"));
      } else {
        CmdArgs.push_back($("-E"));
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_rewrite_objc.getValue()))
           && !Args.hasArg(new OptSpecifier(options.ID.OPT_g_Group.getValue()))) {
          CmdArgs.push_back($("-P"));
        }
      }
    } else if (isa(AssembleJobAction.class, JA)) {
      CmdArgs.push_back($("-emit-obj"));
      
      CollectArgsForIntegratedAssembler(C, Args, CmdArgs, D);
      
      // Also ignore explicit -force_cpusubtype_ALL option.
      /*(void)*/Args.hasArg(new OptSpecifier(options.ID.OPT_force__cpusubtype__ALL.getValue()));
    } else if (isa(PrecompileJobAction.class, JA)) {
      // Use PCH if the user requested it.
      boolean UsePCH = D.CCCUsePCH;
      if (JA.getType() == types.ID.TY_Nothing) {
        CmdArgs.push_back($("-fsyntax-only"));
      } else if (UsePCH) {
        CmdArgs.push_back($("-emit-pch"));
      } else {
        CmdArgs.push_back($("-emit-pth"));
      }
    } else if (isa(VerifyPCHJobAction.class, JA)) {
      CmdArgs.push_back($("-verify-pch"));
    } else {
      assert ((isa(CompileJobAction.class, JA) || isa(BackendJobAction.class, JA))) : "Invalid action for clang tool.";
      if (JA.getType() == types.ID.TY_Nothing) {
        CmdArgs.push_back($("-fsyntax-only"));
      } else if (JA.getType() == types.ID.TY_LLVM_IR
         || JA.getType() == types.ID.TY_LTO_IR) {
        CmdArgs.push_back($("-emit-llvm"));
      } else if (JA.getType() == types.ID.TY_LLVM_BC
         || JA.getType() == types.ID.TY_LTO_BC) {
        CmdArgs.push_back($("-emit-llvm-bc"));
      } else if (JA.getType() == types.ID.TY_PP_Asm) {
        CmdArgs.push_back($("-S"));
      } else if (JA.getType() == types.ID.TY_AST) {
        CmdArgs.push_back($("-emit-pch"));
      } else if (JA.getType() == types.ID.TY_ModuleFile) {
        CmdArgs.push_back($("-module-file-info"));
      } else if (JA.getType() == types.ID.TY_RewrittenObjC) {
        CmdArgs.push_back($("-rewrite-objc"));
        rewriteKind = RewriteKind.RK_NonFragile;
      } else if (JA.getType() == types.ID.TY_RewrittenLegacyObjC) {
        CmdArgs.push_back($("-rewrite-objc"));
        rewriteKind = RewriteKind.RK_Fragile;
      } else {
        assert (JA.getType() == types.ID.TY_PP_Asm) : "Unexpected output type!";
      }
      
      // Preserve use-list order by default when emitting bitcode, so that
      // loading the bitcode up in 'opt' or 'llc' and running passes gives the
      // same result as running passes here.  For LTO, we don't need to preserve
      // the use-list order, since serialization to bitcode is part of the flow.
      if (JA.getType() == types.ID.TY_LLVM_BC) {
        CmdArgs.push_back($("-emit-llvm-uselists"));
      }
      if (D.isUsingLTO()) {
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_flto.getValue()), new OptSpecifier(options.ID.OPT_flto_EQ.getValue()));
      }
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fthinlto_index_EQ.getValue()));
      if ((A != null)) {
        if (!types.isLLVMIR(Input.getType())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), new StringRef(A.getAsString(Args))), 
                /*KEEP_STR*/"-x ir"));
          } finally {
            $c$.$destroy();
          }
        }
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fthinlto_index_EQ.getValue()));
      }
    }
    
    // Embed-bitcode option.
    if (C.getDriver().embedBitcodeEnabled()
       && (isa(BackendJobAction.class, JA) || isa(AssembleJobAction.class, JA))) {
      // Add flags implied by -fembed-bitcode.
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fembed_bitcode_EQ.getValue()));
      // Disable all llvm IR level optimizations.
      CmdArgs.push_back($("-disable-llvm-optzns"));
    }
    if (C.getDriver().embedBitcodeMarkerOnly()) {
      CmdArgs.push_back($("-fembed-bitcode=marker"));
    }
    
    // We normally speed up the clang process a bit by skipping destructors at
    // exit, but when we're generating diagnostics we can rely on some of the
    // cleanup.
    if (!C.isForDiagnostics()) {
      CmdArgs.push_back($("-disable-free"));
    }
    
    // JAVA: the following #ifdef was changed to runtime check
    // Disable the verification pass in -asserts builds.
    if (NativeTrace.NDEBUG()) {
//#ifdef NDEBUG
    CmdArgs.push_back("-disable-llvm-verifier");
    // Discard LLVM value names in -asserts builds.
    CmdArgs.push_back("-discard-value-names");
//#endif    
    }
    
    // Set the main file name, so that debug info works even with
    // -save-temps.
    CmdArgs.push_back($("-main-file-name"));
    CmdArgs.push_back(getBaseInputName(Args, Input));
    
    // Some flags which affect the language (via preprocessor
    // defines).
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
      CmdArgs.push_back($("-static-define"));
    }
    if (isa(AnalyzeJobAction.class, JA)) {
      // Enable region store model by default.
      CmdArgs.push_back($("-analyzer-store=region"));
      
      // Treat blocks as analysis entry points.
      CmdArgs.push_back($("-analyzer-opt-analyze-nested-blocks"));
      
      CmdArgs.push_back($("-analyzer-eagerly-assume"));
      
      // Add default argument set.
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT__analyzer_no_default_checks.getValue()))) {
        CmdArgs.push_back($("-analyzer-checker=core"));
        if (!IsWindowsMSVC) {
          CmdArgs.push_back($("-analyzer-checker=unix"));
        } else {
          // Enable "unix" checkers that also work on Windows.
          CmdArgs.push_back($("-analyzer-checker=unix.API"));
          CmdArgs.push_back($("-analyzer-checker=unix.Malloc"));
          CmdArgs.push_back($("-analyzer-checker=unix.MallocSizeof"));
          CmdArgs.push_back($("-analyzer-checker=unix.MismatchedDeallocator"));
          CmdArgs.push_back($("-analyzer-checker=unix.cstring.BadSizeArg"));
          CmdArgs.push_back($("-analyzer-checker=unix.cstring.NullArg"));
        }
        
        // Disable some unix checkers for PS4.
        if (IsPS4CPU) {
          CmdArgs.push_back($("-analyzer-disable-checker=unix.API"));
          CmdArgs.push_back($("-analyzer-disable-checker=unix.Vfork"));
        }
        if (getToolChain().getTriple().getVendor() == Triple.VendorType.Apple) {
          CmdArgs.push_back($("-analyzer-checker=osx"));
        }
        
        CmdArgs.push_back($("-analyzer-checker=deadcode"));
        if (types.isCXX(Input.getType())) {
          CmdArgs.push_back($("-analyzer-checker=cplusplus"));
        }
        if (!IsPS4CPU) {
          CmdArgs.push_back($("-analyzer-checker=security.insecureAPI.UncheckedReturn"));
          CmdArgs.push_back($("-analyzer-checker=security.insecureAPI.getpw"));
          CmdArgs.push_back($("-analyzer-checker=security.insecureAPI.gets"));
          CmdArgs.push_back($("-analyzer-checker=security.insecureAPI.mktemp"));
          CmdArgs.push_back($("-analyzer-checker=security.insecureAPI.mkstemp"));
          CmdArgs.push_back($("-analyzer-checker=security.insecureAPI.vfork"));
        }
        
        // Default nullability checks.
        CmdArgs.push_back($("-analyzer-checker=nullability.NullPassedToNonnull"));
        CmdArgs.push_back($("-analyzer-checker=nullability.NullReturnedFromNonnull"));
      }
      
      // Set the output format. The default is plist, for (lame) historical
      // reasons.
      CmdArgs.push_back($("-analyzer-output"));
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__analyzer_output.getValue()));
        if ((A != null)) {
          CmdArgs.push_back(A.getValue());
        } else {
          CmdArgs.push_back($("plist"));
        }
      }
      
      // Disable the presentation of standard compiler warnings when
      // using --analyze.  We only want to show static analyzer diagnostics
      // or frontend errors.
      CmdArgs.push_back($("-w"));
      
      // Add -Xanalyzer arguments when running as analyzer.
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Xanalyzer.getValue()));
    }
    
    CheckCodeGenerationOptions(D, Args);
    
    // JAVA: decompose std::tie
    tuple $ParsePICArgs = ParsePICArgs(getToolChain(), _Triple, Args);
    Reloc.Model RelocationModel = (Reloc.Model) $ParsePICArgs.$getAt(0);
    /*uint*/int PICLevel = (int) $ParsePICArgs.$getAt(1);
    boolean IsPIE = (boolean) $ParsePICArgs.$getAt(2);
    //std.tie(RelocationModel, PICLevel, IsPIE).$assign(ParsePICArgs(getToolChain(), _Triple, Args));
    
    /*const*/char$ptr/*char P*/ RMName = $tryClone(RelocationModelName(RelocationModel));
    if ((RMName != null)) {
      CmdArgs.push_back($("-mrelocation-model"));
      CmdArgs.push_back(RMName);
    }
    if ($greater_uint(PICLevel, 0)) {
      CmdArgs.push_back($("-pic-level"));
      CmdArgs.push_back(PICLevel == 1 ? $1 : $2);
      if (IsPIE) {
        CmdArgs.push_back($("-pic-is-pie"));
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_meabi.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-meabi"));
        CmdArgs.push_back(A.getValue());
      }
    }
    
    CmdArgs.push_back($("-mthread-model"));
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mthread_model.getValue()));
      if ((A != null)) {
        CmdArgs.push_back(A.getValue());
      } else {
        CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().getThreadModel())));
      }
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fveclib.getValue()));
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fmerge_all_constants.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_merge_all_constants.getValue()))) {
      CmdArgs.push_back($("-fno-merge-all-constants"));
    }
    
    // LLVM Code Generator Options.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_frewrite_map_file.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_frewrite_map_file_EQ.getValue()))) {
      for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_frewrite_map_file.getValue()), 
          new OptSpecifier(options.ID.OPT_frewrite_map_file_EQ.getValue()))) {
        CmdArgs.push_back($("-frewrite-map-file"));
        CmdArgs.push_back(A.getValue());
        A.claim();
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_Wframe_larger_than_EQ.getValue()));
      if ((A != null)) {
        StringRef v = new StringRef(A.getValue());
        CmdArgs.push_back($("-mllvm"));
        CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-warn-stack-size=", v)));
        A.claim();
      }
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fjump_tables.getValue()), new OptSpecifier(options.ID.OPT_fno_jump_tables.getValue()), 
        true)) {
      CmdArgs.push_back($("-fno-jump-tables"));
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mregparm_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-mregparm"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fpcc_struct_return.getValue()), 
          new OptSpecifier(options.ID.OPT_freg_struct_return.getValue()));
      if ((A != null)) {
        if (getToolChain().getArch() != Triple.ArchType.x86) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_opt_for_target)), 
                    A.getSpelling()), new StringRef(getToolChain().getTriple().str())));
          } finally {
            $c$.$destroy();
          }
        } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fpcc_struct_return.getValue()))) {
          CmdArgs.push_back($("-fpcc-struct-return"));
        } else {
          assert (A.getOption().matches(new OptSpecifier(options.ID.OPT_freg_struct_return.getValue())));
          CmdArgs.push_back($("-freg-struct-return"));
        }
      }
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_mrtd.getValue()), new OptSpecifier(options.ID.OPT_mno_rtd.getValue()), false)) {
      CmdArgs.push_back($("-fdefault-calling-conv=stdcall"));
    }
    if (shouldUseFramePointer(Args, getToolChain().getTriple())) {
      CmdArgs.push_back($("-mdisable-fp-elim"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fzero_initialized_in_bss.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_zero_initialized_in_bss.getValue()))) {
      CmdArgs.push_back($("-mno-zero-initialized-in-bss"));
    }
    
    boolean OFastEnabled = isOptimizationLevelFast(Args);
    // If -Ofast is the optimization level, then -fstrict-aliasing should be
    // enabled.  This alias option is being used to simplify the hasFlag logic.
    OptSpecifier StrictAliasingAliasOption = new OptSpecifier(OFastEnabled ? options.ID.OPT_Ofast.getValue() : options.ID.OPT_fstrict_aliasing.getValue());
    // We turn strict aliasing off by default if we're in CL mode, since MSVC
    // doesn't do any TBAA.
    boolean TBAAOnByDefault = !getToolChain().getDriver().IsCLMode();
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fstrict_aliasing.getValue()), /*NO_COPY*/StrictAliasingAliasOption, 
        new OptSpecifier(options.ID.OPT_fno_strict_aliasing.getValue()), TBAAOnByDefault)) {
      CmdArgs.push_back($("-relaxed-aliasing"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fstruct_path_tbaa.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_struct_path_tbaa.getValue()))) {
      CmdArgs.push_back($("-no-struct-path-tbaa"));
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fstrict_enums.getValue()), new OptSpecifier(options.ID.OPT_fno_strict_enums.getValue()), 
        false)) {
      CmdArgs.push_back($("-fstrict-enums"));
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fstrict_vtable_pointers.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_strict_vtable_pointers.getValue()), 
        false)) {
      CmdArgs.push_back($("-fstrict-vtable-pointers"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_foptimize_sibling_calls.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_optimize_sibling_calls.getValue()))) {
      CmdArgs.push_back($("-mdisable-tail-calls"));
    }
    
    // Handle segmented stacks.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_fsplit_stack.getValue()))) {
      CmdArgs.push_back($("-split-stacks"));
    }
    
    // If -Ofast is the optimization level, then -ffast-math should be enabled.
    // This alias option is being used to simplify the getLastArg logic.
    OptSpecifier FastMathAliasOption = new OptSpecifier(OFastEnabled ? options.ID.OPT_Ofast.getValue() : options.ID.OPT_ffast_math.getValue());
    {
      
      // Handle various floating point optimization flags, mapping them to the
      // appropriate LLVM code generation flags. The pattern for all of these is to
      // default off the codegen optimizations, and if any flag enables them and no
      // flag disables them after the flag enabling them, enable the codegen
      // optimization. This is complicated by several "umbrella" flags.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), new OptSpecifier(options.ID.OPT_ffinite_math_only.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_finite_math_only.getValue()), new OptSpecifier(options.ID.OPT_fhonor_infinities.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_honor_infinities.getValue()));
      if ((A != null)) {
        if (A.getOption().getID() != options.ID.OPT_fno_fast_math.getValue()
           && A.getOption().getID() != options.ID.OPT_fno_finite_math_only.getValue()
           && A.getOption().getID() != options.ID.OPT_fhonor_infinities.getValue()) {
          CmdArgs.push_back($("-menable-no-infs"));
        }
      }
    }
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), new OptSpecifier(options.ID.OPT_ffinite_math_only.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_finite_math_only.getValue()), new OptSpecifier(options.ID.OPT_fhonor_nans.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_honor_nans.getValue()));
      if ((A != null)) {
        if (A.getOption().getID() != options.ID.OPT_fno_fast_math.getValue()
           && A.getOption().getID() != options.ID.OPT_fno_finite_math_only.getValue()
           && A.getOption().getID() != options.ID.OPT_fhonor_nans.getValue()) {
          CmdArgs.push_back($("-menable-no-nans"));
        }
      }
    }
    
    // -fmath-errno is the default on some platforms, e.g. BSD-derived OSes.
    boolean MathErrno = getToolChain().IsMathErrnoDefault();
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), new OptSpecifier(options.ID.OPT_fmath_errno.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_math_errno.getValue()));
      if ((A != null)) {
        // Turning on -ffast_math (with either flag) removes the need for MathErrno.
        // However, turning *off* -ffast_math merely restores the toolchain default
        // (which may be false).
        if (A.getOption().getID() == options.ID.OPT_fno_math_errno.getValue()
           || A.getOption().getID() == options.ID.OPT_ffast_math.getValue()
           || A.getOption().getID() == options.ID.OPT_Ofast.getValue()) {
          MathErrno = false;
        } else if (A.getOption().getID() == options.ID.OPT_fmath_errno.getValue()) {
          MathErrno = true;
        }
      }
    }
    if (MathErrno) {
      CmdArgs.push_back($("-fmath-errno"));
    }
    
    // There are several flags which require disabling very specific
    // optimizations. Any of these being disabled forces us to turn off the
    // entire set of LLVM optimizations, so collect them through all the flag
    // madness.
    boolean AssociativeMath = false;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), new OptSpecifier(options.ID.OPT_funsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_unsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_fassociative_math.getValue()), new OptSpecifier(options.ID.OPT_fno_associative_math.getValue()));
      if ((A != null)) {
        if (A.getOption().getID() != options.ID.OPT_fno_fast_math.getValue()
           && A.getOption().getID() != options.ID.OPT_fno_unsafe_math_optimizations.getValue()
           && A.getOption().getID() != options.ID.OPT_fno_associative_math.getValue()) {
          AssociativeMath = true;
        }
      }
    }
    boolean ReciprocalMath = false;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), new OptSpecifier(options.ID.OPT_funsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_unsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_freciprocal_math.getValue()), new OptSpecifier(options.ID.OPT_fno_reciprocal_math.getValue()));
      if ((A != null)) {
        if (A.getOption().getID() != options.ID.OPT_fno_fast_math.getValue()
           && A.getOption().getID() != options.ID.OPT_fno_unsafe_math_optimizations.getValue()
           && A.getOption().getID() != options.ID.OPT_fno_reciprocal_math.getValue()) {
          ReciprocalMath = true;
        }
      }
    }
    boolean SignedZeros = true;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), new OptSpecifier(options.ID.OPT_funsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_unsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_fsigned_zeros.getValue()), new OptSpecifier(options.ID.OPT_fno_signed_zeros.getValue()));
      if ((A != null)) {
        if (A.getOption().getID() != options.ID.OPT_fno_fast_math.getValue()
           && A.getOption().getID() != options.ID.OPT_fno_unsafe_math_optimizations.getValue()
           && A.getOption().getID() != options.ID.OPT_fsigned_zeros.getValue()) {
          SignedZeros = false;
        }
      }
    }
    boolean TrappingMath = true;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), new OptSpecifier(options.ID.OPT_funsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_unsafe_math_optimizations.getValue()), 
          new OptSpecifier(options.ID.OPT_ftrapping_math.getValue()), new OptSpecifier(options.ID.OPT_fno_trapping_math.getValue()));
      if ((A != null)) {
        if (A.getOption().getID() != options.ID.OPT_fno_fast_math.getValue()
           && A.getOption().getID() != options.ID.OPT_fno_unsafe_math_optimizations.getValue()
           && A.getOption().getID() != options.ID.OPT_ftrapping_math.getValue()) {
          TrappingMath = false;
        }
      }
    }
    if (!MathErrno && AssociativeMath && ReciprocalMath && !SignedZeros
       && !TrappingMath) {
      CmdArgs.push_back($("-menable-unsafe-fp-math"));
    }
    if (!SignedZeros) {
      CmdArgs.push_back($("-fno-signed-zeros"));
    }
    if (ReciprocalMath) {
      CmdArgs.push_back($("-freciprocal-math"));
    }
    {
      
      // Validate and pass through -fp-contract option.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()), 
          new OptSpecifier(options.ID.OPT_ffp_contract.getValue()));
      if ((A != null)) {
        if (A.getOption().getID() == options.ID.OPT_ffp_contract.getValue()) {
          StringRef Val = new StringRef(A.getValue());
          if ($eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"fast") || $eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"on") || $eq_StringRef(/*NO_COPY*/Val, /*STRINGREF_STR*/"off")) {
            CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-ffp-contract=", Val)));
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_option_argument)), 
                      A.getOption().getName()), /*NO_COPY*/Val));
            } finally {
              $c$.$destroy();
            }
          }
        } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_ffast_math.getValue()))
           || (OFastEnabled && A.getOption().matches(new OptSpecifier(options.ID.OPT_Ofast.getValue())))) {
          // If fast-math is set then set the fp-contract mode to fast.
          CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-ffp-contract=fast")));
        }
      }
    }
    
    ParseMRecip(getToolChain().getDriver(), Args, CmdArgs);
    {
      
      // We separately look for the '-ffast-math' and '-ffinite-math-only' flags,
      // and if we find them, tell the frontend to provide the appropriate
      // preprocessor macros. This is distinct from enabling any optimizations as
      // these options induce language changes which must survive serialization
      // and deserialization, etc.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffast_math.getValue()), /*NO_COPY*/FastMathAliasOption, 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()));
      if ((A != null)) {
        if (!A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()))) {
          CmdArgs.push_back($("-ffast-math"));
        }
      }
    }
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffinite_math_only.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_fast_math.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_ffinite_math_only.getValue()))) {
          CmdArgs.push_back($("-ffinite-math-only"));
        }
      }
    }
    
    // Decide whether to use verbose asm. Verbose assembly is the default on
    // toolchains which have the integrated assembler on by default.
    boolean IsIntegratedAssemblerDefault = getToolChain().IsIntegratedAssemblerDefault();
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fverbose_asm.getValue()), new OptSpecifier(options.ID.OPT_fno_verbose_asm.getValue()), 
        IsIntegratedAssemblerDefault)
       || Args.hasArg(new OptSpecifier(options.ID.OPT_dA.getValue()))) {
      CmdArgs.push_back($("-masm-verbose"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fintegrated_as.getValue()), new OptSpecifier(options.ID.OPT_fno_integrated_as.getValue()), 
        IsIntegratedAssemblerDefault)) {
      CmdArgs.push_back($("-no-integrated-as"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_fdebug_pass_structure.getValue()))) {
      CmdArgs.push_back($("-mdebug-pass"));
      CmdArgs.push_back($("Structure"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_fdebug_pass_arguments.getValue()))) {
      CmdArgs.push_back($("-mdebug-pass"));
      CmdArgs.push_back($("Arguments"));
    }
    
    // Enable -mconstructor-aliases except on darwin, where we have to work around
    // a linker bug (see <rdar://problem/7651567>), and CUDA device code, where
    // aliases aren't supported.
    if (!getToolChain().getTriple().isOSDarwin()
       && !getToolChain().getTriple().isNVPTX()) {
      CmdArgs.push_back($("-mconstructor-aliases"));
    }
    
    // Darwin's kernel doesn't support guard variables; just die if we
    // try to use them.
    if (KernelOrKext && getToolChain().getTriple().isOSDarwin()) {
      CmdArgs.push_back($("-fforbid-guard-variables"));
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_mms_bitfields.getValue()), new OptSpecifier(options.ID.OPT_mno_ms_bitfields.getValue()), 
        false)) {
      CmdArgs.push_back($("-mms-bitfields"));
    }
    
    // This is a coarse approximation of what llvm-gcc actually does, both
    // -fasynchronous-unwind-tables and -fnon-call-exceptions interact in more
    // complicated ways.
    boolean AsynchronousUnwindTables = Args.hasFlag(new OptSpecifier(options.ID.OPT_fasynchronous_unwind_tables.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_asynchronous_unwind_tables.getValue()), 
        (getToolChain().IsUnwindTablesDefault()
           || getToolChain().getSanitizerArgs().needsUnwindTables())
           && !KernelOrKext);
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_funwind_tables.getValue()), new OptSpecifier(options.ID.OPT_fno_unwind_tables.getValue()), 
        AsynchronousUnwindTables)) {
      CmdArgs.push_back($("-munwind-tables"));
    }
    
    getToolChain().addClangTargetOptions(Args, CmdArgs);
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_flimited_precision_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-mlimit-float-precision"));
        CmdArgs.push_back(A.getValue());
      }
    }
    
    // FIXME: Handle -mtune=.
    /*(void)*/Args.hasArg(new OptSpecifier(options.ID.OPT_mtune_EQ.getValue()));
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcmodel_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-mcode-model"));
        CmdArgs.push_back(A.getValue());
      }
    }
    
    // Add the target cpu
    std.string CPU = getCPUName(Args, _Triple, /*FromAs*/ false);
    if (!CPU.empty()) {
      CmdArgs.push_back($("-target-cpu"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(CPU)));
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mfpmath_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-mfpmath"));
        CmdArgs.push_back(A.getValue());
      }
    }
    
    // Add the target features
    getTargetFeatures(getToolChain(), _Triple, Args, CmdArgs, false);
    
    // Add target specific flags.
    switch (getToolChain().getArch()) {
     default:
      break;
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      // Use the effective triple, which takes into account the deployment target.
      AddARMTargetArgs(_Triple, Args, CmdArgs, KernelOrKext);
      break;
     case aarch64:
     case aarch64_be:
      AddAArch64TargetArgs(Args, CmdArgs);
      break;
     case mips:
     case mipsel:
     case mips64:
     case mips64el:
      AddMIPSTargetArgs(Args, CmdArgs);
      break;
     case ppc:
     case ppc64:
     case ppc64le:
      AddPPCTargetArgs(Args, CmdArgs);
      break;
     case sparc:
     case sparcel:
     case sparcv9:
      AddSparcTargetArgs(Args, CmdArgs);
      break;
     case systemz:
      AddSystemZTargetArgs(Args, CmdArgs);
      break;
     case x86:
     case x86_64:
      AddX86TargetArgs(Args, CmdArgs);
      break;
     case lanai:
      AddLanaiTargetArgs(Args, CmdArgs);
      break;
     case hexagon:
      AddHexagonTargetArgs(Args, CmdArgs);
      break;
     case wasm32:
     case wasm64:
      AddWebAssemblyTargetArgs(Args, CmdArgs);
      break;
    }
    
    // The 'g' groups options involve a somewhat intricate sequence of decisions
    // about what to pass from the driver to the frontend, but by the time they
    // reach cc1 they've been factored into three well-defined orthogonal choices:
    //  * what level of debug info to generate
    //  * what dwarf version to write
    //  * what debugger tuning to use
    // This avoids having to monkey around further in cc1 other than to disable
    // codeview if not running in a Windows environment. Perhaps even that
    // decision should be made in the driver as well though.
    /*uint*/int DwarfVersion = 0;
    DebuggerKind DebuggerTuning = getToolChain().getDefaultDebuggerTuning();
    // These two are potentially updated by AddClangCLArgs.
    type$ptr<DebugInfoKind> _DebugInfoKind = create_type$ptr(DebugInfoKind.NoDebugInfo);
    bool$ptr EmitCodeView = create_bool$ptr(false);
    
    // Add clang-cl arguments.
    types.ID InputType = Input.getType();
    if (getToolChain().getDriver().IsCLMode()) {
      AddClangCLArgs(Args, InputType, CmdArgs, /*AddrOf*/_DebugInfoKind, /*AddrOf*/EmitCodeView);
    }
    {
      
      // Pass the linker version in use.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mlinker_version_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-target-linker-version"));
        CmdArgs.push_back(A.getValue());
      }
    }
    if (!shouldUseLeafFramePointer(Args, getToolChain().getTriple())) {
      CmdArgs.push_back($("-momit-leaf-frame-pointer"));
    }
    
    // Explicitly error on some things we know we don't support and can't just
    // ignore.
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_fallow_unsupported.getValue()))) {
      Arg /*P*/ Unsupported;
      if (types.isCXX(InputType) && getToolChain().getTriple().isOSDarwin()
         && getToolChain().getArch() == Triple.ArchType.x86) {
        if (((Unsupported = Args.getLastArg(new OptSpecifier(options.ID.OPT_fapple_kext.getValue()))) != null)
           || ((Unsupported = Args.getLastArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()))) != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported_opt_cxx_darwin_i386)), 
                Unsupported.getOption().getName()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_v.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_H.getValue()));
    if (D.CCPrintHeaders && !D.CCGenDiagnostics) {
      CmdArgs.push_back($("-header-include-file"));
      CmdArgs.push_back((D.CCPrintHeadersFilename != null) ? D.CCPrintHeadersFilename : $MINUS);
    }
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_P.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_print_ivar_layout.getValue()));
    if (D.CCLogDiagnostics && !D.CCGenDiagnostics) {
      CmdArgs.push_back($("-diagnostic-log-file"));
      CmdArgs.push_back((D.CCLogDiagnosticsFilename != null) ? D.CCLogDiagnosticsFilename : $MINUS);
    }
    
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
    Arg /*P*/ SplitDwarfArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_gsplit_dwarf.getValue()));
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      if ((A != null)) {
        // If the last option explicitly specified a debug-info level, use it.
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_gN_Group.getValue()))) {
          _DebugInfoKind.$set(DebugLevelToInfoKind(/*Deref*/A));
          // If you say "-gsplit-dwarf -gline-tables-only", -gsplit-dwarf loses.
          // But -gsplit-dwarf is not a g_group option, hence we have to check the
          // order explicitly. (If -gsplit-dwarf wins, we fix DebugInfoKind later.)
          if ((SplitDwarfArg != null) && _DebugInfoKind.$star().getValue() < DebugInfoKind.LimitedDebugInfo.getValue()
             && $greater_uint(A.getIndex(), SplitDwarfArg.getIndex())) {
            SplitDwarfArg = null;
          }
        } else {
          // For any other 'g' option, use Limited.
          _DebugInfoKind.$set(DebugInfoKind.LimitedDebugInfo);
        }
      }
    }
    {
      
      // If a debugger tuning argument appeared, remember it.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_gTune_Group.getValue()), 
          new OptSpecifier(options.ID.OPT_ggdbN_Group.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_glldb.getValue()))) {
          DebuggerTuning = DebuggerKind.LLDB;
        } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_gsce.getValue()))) {
          DebuggerTuning = DebuggerKind.SCE;
        } else {
          DebuggerTuning = DebuggerKind.GDB;
        }
      }
    }
    {
      
      // If a -gdwarf argument appeared, remember it.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_gdwarf_2.getValue()), new OptSpecifier(options.ID.OPT_gdwarf_3.getValue()), 
          new OptSpecifier(options.ID.OPT_gdwarf_4.getValue()), new OptSpecifier(options.ID.OPT_gdwarf_5.getValue()));
      if ((A != null)) {
        DwarfVersion = DwarfVersionNum(A.getSpelling());
      }
    }
    
    // Forward -gcodeview. EmitCodeView might have been set by CL-compatibility
    // argument parsing.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_gcodeview.getValue())) || EmitCodeView.$star()) {
      // DwarfVersion remains at 0 if no explicit choice was made.
      CmdArgs.push_back($("-gcodeview"));
    } else if (DwarfVersion == 0
       && _DebugInfoKind.$star() != DebugInfoKind.NoDebugInfo) {
      DwarfVersion = getToolChain().GetDefaultDwarfVersion();
    }
    
    // We ignore flags -gstrict-dwarf and -grecord-gcc-switches for now.
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_flags_Group.getValue()));
    
    // PS4 defaults to no column info
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_gcolumn_info.getValue()), new OptSpecifier(options.ID.OPT_gno_column_info.getValue()), 
        /*Default=*/ !IsPS4CPU)) {
      CmdArgs.push_back($("-dwarf-column-info"));
    }
    
    // FIXME: Move backend command line options to the module.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_gmodules.getValue()))) {
      _DebugInfoKind.$set(DebugInfoKind.LimitedDebugInfo);
      CmdArgs.push_back($("-dwarf-ext-refs"));
      CmdArgs.push_back($("-fmodule-format=obj"));
    }
    
    // -gsplit-dwarf should turn on -g and enable the backend dwarf
    // splitting and extraction.
    // FIXME: Currently only works on Linux.
    if (getToolChain().getTriple().isOSLinux() && (SplitDwarfArg != null)) {
      _DebugInfoKind.$set(DebugInfoKind.LimitedDebugInfo);
      CmdArgs.push_back($("-backend-option"));
      CmdArgs.push_back($("-split-dwarf=Enable"));
    }
    
    // After we've dealt with all combinations of things that could
    // make DebugInfoKind be other than None or DebugLineTablesOnly,
    // figure out if we need to "upgrade" it to standalone debug info.
    // We parse these two '-f' options whether or not they will be used,
    // to claim them even if you wrote "-fstandalone-debug -gline-tables-only"
    boolean NeedFullDebug = Args.hasFlag(new OptSpecifier(options.ID.OPT_fstandalone_debug.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_standalone_debug.getValue()), 
        getToolChain().GetDefaultStandaloneDebug());
    if (_DebugInfoKind.$star() == DebugInfoKind.LimitedDebugInfo && NeedFullDebug) {
      _DebugInfoKind.$set(DebugInfoKind.FullDebugInfo);
    }
    RenderDebugEnablingArgs(Args, CmdArgs, _DebugInfoKind.$star(), DwarfVersion, 
        DebuggerTuning);
    
    // -ggnu-pubnames turns on gnu style pubnames in the backend.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_ggnu_pubnames.getValue()))) {
      CmdArgs.push_back($("-backend-option"));
      CmdArgs.push_back($("-generate-gnu-dwarf-pub-sections"));
    }
    
    // -gdwarf-aranges turns on the emission of the aranges section in the
    // backend.
    // Always enabled on the PS4.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_gdwarf_aranges.getValue())) || IsPS4CPU) {
      CmdArgs.push_back($("-backend-option"));
      CmdArgs.push_back($("-generate-arange-section"));
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fdebug_types_section.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_debug_types_section.getValue()), false)) {
      CmdArgs.push_back($("-backend-option"));
      CmdArgs.push_back($("-generate-type-units"));
    }
    
    // CloudABI and WebAssembly use -ffunction-sections and -fdata-sections by
    // default.
    boolean UseSeparateSections = _Triple.getOS() == Triple.OSType.CloudABI
       || _Triple.getArch() == Triple.ArchType.wasm32
       || _Triple.getArch() == Triple.ArchType.wasm64;
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_ffunction_sections.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_function_sections.getValue()), UseSeparateSections)) {
      CmdArgs.push_back($("-ffunction-sections"));
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fdata_sections.getValue()), new OptSpecifier(options.ID.OPT_fno_data_sections.getValue()), 
        UseSeparateSections)) {
      CmdArgs.push_back($("-fdata-sections"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_funique_section_names.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_unique_section_names.getValue()), true)) {
      CmdArgs.push_back($("-fno-unique-section-names"));
    }
    
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_finstrument_functions.getValue()));
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fxray_instrument.getValue()), 
        new OptSpecifier(options.ID.OPT_fnoxray_instrument.getValue()), false)) {
      CmdArgs.push_back($("-fxray-instrument"));
      {
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fxray_instruction_threshold_.getValue()), 
            new OptSpecifier(options.ID.OPT_fxray_instruction_threshold_EQ.getValue()));
        if ((A != null)) {
          CmdArgs.push_back($("-fxray-instruction-threshold"));
          CmdArgs.push_back(A.getValue());
        }
      }
    }
    
    addPGOAndCoverageFlags(C, D, Output, Args, CmdArgs);
    
    // Add runtime flag for PS4 when PGO or Coverage are enabled.
    if (getToolChain().getTriple().isPS4CPU()) {
      addPS4ProfileRTArgs(getToolChain(), Args, CmdArgs);
    }
    
    // Pass options for controlling the default header search paths.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))) {
      CmdArgs.push_back($("-nostdsysteminc"));
      CmdArgs.push_back($("-nobuiltininc"));
    } else {
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
        CmdArgs.push_back($("-nostdsysteminc"));
      }
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_nostdincxx.getValue()));
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_nobuiltininc.getValue()));
    }
    
    // Pass the path to compiler resource files.
    CmdArgs.push_back($("-resource-dir"));
    CmdArgs.push_back(D.ResourceDir.c_str());
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_working_directory.getValue()));
    
    boolean ARCMTEnabled = false;
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_fno_objc_arc.getValue()), new OptSpecifier(options.ID.OPT_fobjc_arc.getValue()))) {
      {
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ccc_arcmt_check.getValue()), 
            new OptSpecifier(options.ID.OPT_ccc_arcmt_modify.getValue()), 
            new OptSpecifier(options.ID.OPT_ccc_arcmt_migrate.getValue()));
        if ((A != null)) {
          ARCMTEnabled = true;
          switch (options.ID.valueOf(A.getOption().getID())) {
           default:
            throw new llvm_unreachable("missed a case");
           case OPT_ccc_arcmt_check:
            CmdArgs.push_back($("-arcmt-check"));
            break;
           case OPT_ccc_arcmt_modify:
            CmdArgs.push_back($("-arcmt-modify"));
            break;
           case OPT_ccc_arcmt_migrate:
            CmdArgs.push_back($("-arcmt-migrate"));
            CmdArgs.push_back($("-mt-migrate-directory"));
            CmdArgs.push_back(A.getValue());
            
            Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_arcmt_migrate_report_output.getValue()));
            Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_arcmt_migrate_emit_arc_errors.getValue()));
            break;
          }
        }
      }
    } else {
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_ccc_arcmt_check.getValue()));
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_ccc_arcmt_modify.getValue()));
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_ccc_arcmt_migrate.getValue()));
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ccc_objcmt_migrate.getValue()));
      if ((A != null)) {
        if (ARCMTEnabled) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), new StringRef(A.getAsString(Args))), 
                /*KEEP_STR*/"-ccc-arcmt-migrate"));
          } finally {
            $c$.$destroy();
          }
        }
        CmdArgs.push_back($("-mt-migrate-directory"));
        CmdArgs.push_back(A.getValue());
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_objcmt_migrate_literals.getValue()), 
            new OptSpecifier(options.ID.OPT_objcmt_migrate_subscripting.getValue()), 
            new OptSpecifier(options.ID.OPT_objcmt_migrate_property.getValue()))) {
          // None specified, means enable them all.
          CmdArgs.push_back($("-objcmt-migrate-literals"));
          CmdArgs.push_back($("-objcmt-migrate-subscripting"));
          CmdArgs.push_back($("-objcmt-migrate-property"));
        } else {
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_literals.getValue()));
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_subscripting.getValue()));
          Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_property.getValue()));
        }
      } else {
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_literals.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_subscripting.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_property.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_all.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_readonly_property.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_readwrite_property.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_property_dot_syntax.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_annotation.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_instancetype.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_nsmacros.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_protocol_conformance.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_atomic_property.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_returns_innerpointer_property.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_ns_nonatomic_iosonly.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_migrate_designated_init.getValue()));
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_objcmt_whitelist_dir_path.getValue()));
      }
    }
    
    // Add preprocessing options like -I, -D, etc. if we are using the
    // preprocessor.
    //
    // FIXME: Support -fpreprocessed
    if (types.getPreprocessedType(InputType) != types.ID.TY_INVALID) {
      AddPreprocessingOptions(C, JA, D, Args, CmdArgs, Output, Inputs);
    }
    
    // Don't warn about "clang -c -DPIC -fPIC test.i" because libtool.m4 assumes
    // that "The compiler can only warn and ignore the option if not recognized".
    // When building with ccache, it will pass -D options to clang even on
    // preprocessed inputs and configure concludes that -fPIC is not supported.
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_D.getValue()));
    {
      
      // Manually translate -O4 to -O3; let clang reject others.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O_Group.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O4.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            CmdArgs.push_back($("-O3"));
            $c$.clean($c$.track(D.Diag(diag.warn_O4_is_O3)));
          } finally {
            $c$.$destroy();
          }
        } else {
          A.render(Args, CmdArgs);
        }
      }
    }
    
    // Warn about ignored options to clang.
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_clang_ignored_gcc_optimization_f_Group.getValue()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_ignored_gcc_optimization)), new StringRef(A.getAsString(Args))));
        A.claim();
      } finally {
        $c$.$destroy();
      }
    }
    
    claimNoWarnArgs(Args);
    
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_R_Group.getValue()));
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_W_Group.getValue()));
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_pedantic.getValue()), new OptSpecifier(options.ID.OPT_no_pedantic.getValue()), false)) {
      CmdArgs.push_back($("-pedantic"));
    }
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_pedantic_errors.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_w.getValue()));
    
    // Handle -{std, ansi, trigraphs} -- take the last of -{std, ansi}
    // (-ansi is equivalent to -std=c89 or -std=c++98).
    //
    // If a std is supplied, only add -trigraphs if it follows the
    // option.
    boolean ImplyVCPPCXXVer = false;
    {
      Arg /*P*/ Std = Args.getLastArg(new OptSpecifier(options.ID.OPT_std_EQ.getValue()), new OptSpecifier(options.ID.OPT_ansi.getValue()));
      if ((Std != null)) {
        if (Std.getOption().matches(new OptSpecifier(options.ID.OPT_ansi.getValue()))) {
          if (types.isCXX(InputType)) {
            CmdArgs.push_back($("-std=c++98"));
          } else {
            CmdArgs.push_back($("-std=c89"));
          }
        } else {
          Std.render(Args, CmdArgs);
        }
        {
          
          // If -f(no-)trigraphs appears after the language standard flag, honor it.
          Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_std_EQ.getValue()), new OptSpecifier(options.ID.OPT_ansi.getValue()), 
              new OptSpecifier(options.ID.OPT_ftrigraphs.getValue()), 
              new OptSpecifier(options.ID.OPT_fno_trigraphs.getValue()));
          if ((A != null)) {
            if (A != Std) {
              A.render(Args, CmdArgs);
            }
          }
        }
      } else {
        // Honor -std-default.
        //
        // FIXME: Clang doesn't correctly handle -std= when the input language
        // doesn't match. For the time being just ignore this for C++ inputs;
        // eventually we want to do all the standard defaulting here instead of
        // splitting it between the driver and clang -cc1.
        if (!types.isCXX(InputType)) {
          Args.AddAllArgsTranslated(CmdArgs, new OptSpecifier(options.ID.OPT_std_default_EQ.getValue()), $("-std="), 
              /*Joined=*/ true);
        } else if (IsWindowsMSVC) {
          ImplyVCPPCXXVer = true;
        }
        
        Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_ftrigraphs.getValue()), 
            new OptSpecifier(options.ID.OPT_fno_trigraphs.getValue()));
      }
    }
    
    // GCC's behavior for -Wwrite-strings is a bit strange:
    //  * In C, this "warning flag" changes the types of string literals from
    //    'char[N]' to 'const char[N]', and thus triggers an unrelated warning
    //    for the discarded qualifier.
    //  * In C++, this is just a normal warning flag.
    //
    // Implementing this warning correctly in C is hard, so we follow GCC's
    // behavior for now. FIXME: Directly diagnose uses of a string literal as
    // a non-const char* in C, rather than using this crude hack.
    if (!types.isCXX(InputType)) {
      // FIXME: This should behave just like a warning flag, and thus should also
      // respect -Weverything, -Wno-everything, -Werror=write-strings, and so on.
      Arg /*P*/ WriteStrings = Args.getLastArg(new OptSpecifier(options.ID.OPT_Wwrite_strings.getValue()), 
          new OptSpecifier(options.ID.OPT_Wno_write_strings.getValue()), new OptSpecifier(options.ID.OPT_w.getValue()));
      if ((WriteStrings != null)
         && WriteStrings.getOption().matches(new OptSpecifier(options.ID.OPT_Wwrite_strings.getValue()))) {
        CmdArgs.push_back($("-fconst-strings"));
      }
    }
    
    // GCC provides a macro definition '__DEPRECATED' when -Wdeprecated is active
    // during C++ compilation, which it is by default. GCC keeps this define even
    // in the presence of '-w', match this behavior bug-for-bug.
    if (types.isCXX(InputType)
       && Args.hasFlag(new OptSpecifier(options.ID.OPT_Wdeprecated.getValue()), new OptSpecifier(options.ID.OPT_Wno_deprecated.getValue()), 
        true)) {
      CmdArgs.push_back($("-fdeprecated-macro"));
    }
    {
      
      // Translate GCC's misnamer '-fasm' arguments to '-fgnu-keywords'.
      Arg /*P*/ Asm = Args.getLastArg(new OptSpecifier(options.ID.OPT_fasm.getValue()), new OptSpecifier(options.ID.OPT_fno_asm.getValue()));
      if ((Asm != null)) {
        if (Asm.getOption().matches(new OptSpecifier(options.ID.OPT_fasm.getValue()))) {
          CmdArgs.push_back($("-fgnu-keywords"));
        } else {
          CmdArgs.push_back($("-fno-gnu-keywords"));
        }
      }
    }
    if (ShouldDisableDwarfDirectory(Args, getToolChain())) {
      CmdArgs.push_back($("-fno-dwarf-directory-asm"));
    }
    if (ShouldDisableAutolink(Args, getToolChain())) {
      CmdArgs.push_back($("-fno-autolink"));
    }
    
    // Add in -fdebug-compilation-dir if necessary.
    addDebugCompDirArg(Args, CmdArgs);
    
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_fdebug_prefix_map_EQ.getValue()))) {
      StringRef Map = new StringRef(A.getValue());
      if (Map.find($$EQ) == StringRef.npos) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_argument_to_fdebug_prefix_map)), /*NO_COPY*/Map));
        } finally {
          $c$.$destroy();
        }
      } else {
        CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-fdebug-prefix-map=", Map)));
      }
      A.claim();
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ftemplate_depth_.getValue()), 
          new OptSpecifier(options.ID.OPT_ftemplate_depth_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-ftemplate-depth"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_foperator_arrow_depth_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-foperator-arrow-depth"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fconstexpr_depth_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fconstexpr-depth"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fconstexpr_steps_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fconstexpr-steps"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fbracket_depth_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fbracket-depth"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_Wlarge_by_value_copy_EQ.getValue()), 
          new OptSpecifier(options.ID.OPT_Wlarge_by_value_copy_def.getValue()));
      if ((A != null)) {
        if ((A.getNumValues() != 0)) {
          StringRef bytes = new StringRef(A.getValue());
          CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-Wlarge-by-value-copy=", bytes)));
        } else {
          CmdArgs.push_back($("-Wlarge-by-value-copy=64")); // default value
        }
      }
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_relocatable_pch.getValue()))) {
      CmdArgs.push_back($("-relocatable-pch"));
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fconstant_string_class_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fconstant-string-class"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ftabstop_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-ftabstop"));
        CmdArgs.push_back(A.getValue());
      }
    }
    
    CmdArgs.push_back($("-ferror-limit"));
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ferror_limit_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back(A.getValue());
      } else {
        CmdArgs.push_back($("19"));
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fmacro_backtrace_limit_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fmacro-backtrace-limit"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ftemplate_backtrace_limit_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-ftemplate-backtrace-limit"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fconstexpr_backtrace_limit_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fconstexpr-backtrace-limit"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fspell_checking_limit_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fspell-checking-limit"));
        CmdArgs.push_back(A.getValue());
      }
    }
    
    // Pass -fmessage-length=.
    CmdArgs.push_back($("-fmessage-length"));
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fmessage_length_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back(A.getValue());
      } else {
        // If -fmessage-length=N was not specified, determine whether this is a
        // terminal and, if so, implicitly define -fmessage-length appropriately.
        /*uint*/int N = Process.StandardErrColumns();
        CmdArgs.push_back(Args.MakeArgString(new Twine(JD$UInt.INSTANCE, N)));
      }
    }
    {
      
      // -fvisibility= and -fvisibility-ms-compat are of a piece.
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fvisibility_EQ.getValue()), 
          new OptSpecifier(options.ID.OPT_fvisibility_ms_compat.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fvisibility_EQ.getValue()))) {
          CmdArgs.push_back($("-fvisibility"));
          CmdArgs.push_back(A.getValue());
        } else {
          assert (A.getOption().matches(new OptSpecifier(options.ID.OPT_fvisibility_ms_compat.getValue())));
          CmdArgs.push_back($("-fvisibility"));
          CmdArgs.push_back($("hidden"));
          CmdArgs.push_back($("-ftype-visibility"));
          CmdArgs.push_back($default);
        }
      }
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fvisibility_inlines_hidden.getValue()));
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_ftlsmodel_EQ.getValue()));
    
    // -fhosted is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_ffreestanding.getValue()), new OptSpecifier(options.ID.OPT_fhosted.getValue()), false)
       || KernelOrKext) {
      CmdArgs.push_back($("-ffreestanding"));
    }
    
    // Forward -f (flag) options which we can pass directly.
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_femit_all_decls.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fheinous_gnu_extensions.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fno_operator_names.getValue()));
    // Emulated TLS is enabled by default on Android, and can be enabled manually
    // with -femulated-tls.
    boolean EmulatedTLSDefault = _Triple.isAndroid() || _Triple.isWindowsCygwinEnvironment();
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_femulated_tls.getValue()), new OptSpecifier(options.ID.OPT_fno_emulated_tls.getValue()), 
        EmulatedTLSDefault)) {
      CmdArgs.push_back($("-femulated-tls"));
    }
    // AltiVec-like language extensions aren't relevant for assembling.
    if (!isa(PreprocessJobAction.class, JA) || Output.getType() != types.ID.TY_PP_Asm) {
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_faltivec.getValue()));
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fzvector.getValue()));
    }
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fdiagnostics_show_template_tree.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fno_elide_type.getValue()));
    
    // Forward flags for OpenMP. We don't do this if the current action is an
    // device offloading action.
    //
    // TODO: Allow OpenMP offload actions when they become available.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fopenmp.getValue()), new OptSpecifier(options.ID.OPT_fopenmp_EQ.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_openmp.getValue()), false)
       && JA.isDeviceOffloading(Action.OffloadKind.OFK_None)) {
      switch (getOpenMPRuntime(getToolChain(), Args)) {
       case OMPRT_OMP:
       case OMPRT_IOMP5:
        // Clang can generate useful OpenMP code for these two runtime libraries.
        CmdArgs.push_back($("-fopenmp"));
        
        // If no option regarding the use of TLS in OpenMP codegeneration is
        // given, decide a default based on the target. Otherwise rely on the
        // options and pass the right information to the frontend.
        if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fopenmp_use_tls.getValue()), 
            new OptSpecifier(options.ID.OPT_fnoopenmp_use_tls.getValue()), /*Default=*/ true)) {
          CmdArgs.push_back($("-fnoopenmp-use-tls"));
        }
        Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_fopenmp_version_EQ.getValue()));
        break;
       default:
        // By default, if Clang doesn't know how to generate useful OpenMP code
        // for a specific runtime library, we just don't pass the '-fopenmp' flag
        // down to the actual compilation.
        // FIXME: It would be better to have a mode which *only* omits IR
        // generation based on the OpenMP support so that we get consistent
        // semantic analysis, etc.
        break;
      }
    }
    
    /*const*/ SanitizerArgs /*&*/ Sanitize = getToolChain().getSanitizerArgs();
    Sanitize.addArgs(getToolChain(), Args, CmdArgs, InputType);
    {
      
      // Report an error for -faltivec on anything other than PowerPC.
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_faltivec.getValue()));
      if ((A != null)) {
        /*const*/ Triple.ArchType Arch = getToolChain().getArch();
        if (!(Arch == Triple.ArchType.ppc || Arch == Triple.ArchType.ppc64
           || Arch == Triple.ArchType.ppc64le)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), new StringRef(A.getAsString(Args))), 
                /*KEEP_STR*/"ppc/ppc64/ppc64le"));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    {
      
      // -fzvector is incompatible with -faltivec.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fzvector.getValue()));
      if ((A != null)) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_faltivec.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), new StringRef(A.getAsString(Args))), 
                /*KEEP_STR*/"-faltivec"));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (getToolChain().SupportsProfiling()) {
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_pg.getValue()));
    }
    
    // -flax-vector-conversions is default.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_flax_vector_conversions.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_lax_vector_conversions.getValue()))) {
      CmdArgs.push_back($("-fno-lax-vector-conversions"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_fapple_kext.getValue())) != null)
       || (Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue())) && types.isCXX(InputType))) {
      CmdArgs.push_back($("-fapple-kext"));
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fobjc_sender_dependent_dispatch.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fdiagnostics_print_source_range_info.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fdiagnostics_parseable_fixits.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_ftime_report.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_ftrapv.getValue()));
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ftrapv_handler_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-ftrapv-handler"));
        CmdArgs.push_back(A.getValue());
      }
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_ftrap_function_EQ.getValue()));
    {
      
      // -fno-strict-overflow implies -fwrapv if it isn't disabled, but
      // -fstrict-overflow won't turn off an explicitly enabled -fwrapv.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fwrapv.getValue()), new OptSpecifier(options.ID.OPT_fno_wrapv.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fwrapv.getValue()))) {
          CmdArgs.push_back($("-fwrapv"));
        }
      } else {
        Arg /*P*/ _A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fstrict_overflow.getValue()), 
            new OptSpecifier(options.ID.OPT_fno_strict_overflow.getValue()));
        if ((_A != null)) {
          if (_A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_strict_overflow.getValue()))) {
            CmdArgs.push_back($("-fwrapv"));
          }
        }
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_freroll_loops.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_reroll_loops.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_freroll_loops.getValue()))) {
          CmdArgs.push_back($("-freroll-loops"));
        }
      }
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fwritable_strings.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_funroll_loops.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_unroll_loops.getValue()));
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_pthread.getValue()));
    
    // -stack-protector=0 is default.
    /*uint*/int StackProtectorLevel = 0;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fno_stack_protector.getValue()), 
          new OptSpecifier(options.ID.OPT_fstack_protector_all.getValue()), 
          new OptSpecifier(options.ID.OPT_fstack_protector_strong.getValue()), 
          new OptSpecifier(options.ID.OPT_fstack_protector.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fstack_protector.getValue()))) {
          StackProtectorLevel = std.max_uint(LangOptions.StackProtectorMode.SSPOn.getValue(), 
              getToolChain().GetDefaultStackProtectorLevel(KernelOrKext));
        } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fstack_protector_strong.getValue()))) {
          StackProtectorLevel = LangOptions.StackProtectorMode.SSPStrong.getValue();
        } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fstack_protector_all.getValue()))) {
          StackProtectorLevel = LangOptions.StackProtectorMode.SSPReq.getValue();
        }
      } else {
        StackProtectorLevel
           = getToolChain().GetDefaultStackProtectorLevel(KernelOrKext);
      }
    }
    if ((StackProtectorLevel != 0)) {
      CmdArgs.push_back($("-stack-protector"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(JD$UInt.INSTANCE, StackProtectorLevel)));
    }
    
    // --param ssp-buffer-size=
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT__param.getValue()))) {
      StringRef Str/*J*/= new StringRef(A.getValue());
      if (Str.startswith(/*STRINGREF_STR*/"ssp-buffer-size=")) {
        if ((StackProtectorLevel != 0)) {
          CmdArgs.push_back($("-stack-protector-buffer-size"));
          // FIXME: Verify the argument is a valid integer.
          CmdArgs.push_back(Args.MakeArgString(new Twine(Str.drop_front(16))));
        }
        A.claim();
      }
    }
    
    // Translate -mstackrealign
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_mstackrealign.getValue()), new OptSpecifier(options.ID.OPT_mno_stackrealign.getValue()), 
        false)) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-mstackrealign")));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_mstack_alignment.getValue()))) {
      StringRef alignment = Args.getLastArgValue(new OptSpecifier(options.ID.OPT_mstack_alignment.getValue()));
      CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-mstack-alignment=", alignment)));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_mstack_probe_size.getValue()))) {
      StringRef Size = Args.getLastArgValue(new OptSpecifier(options.ID.OPT_mstack_probe_size.getValue()));
      if (!Size.empty()) {
        CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-mstack-probe-size=", Size)));
      } else {
        CmdArgs.push_back($("-mstack-probe-size=0"));
      }
    }
    switch (getToolChain().getArch()) {
     case aarch64:
     case aarch64_be:
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      CmdArgs.push_back($("-fallow-half-arguments-and-returns"));
      break;
     default:
      break;
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mrestrict_it.getValue()), 
          new OptSpecifier(options.ID.OPT_mno_restrict_it.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mrestrict_it.getValue()))) {
          CmdArgs.push_back($("-backend-option"));
          CmdArgs.push_back($("-arm-restrict-it"));
        } else {
          CmdArgs.push_back($("-backend-option"));
          CmdArgs.push_back($("-arm-no-restrict-it"));
        }
      } else if (_Triple.isOSWindows()
         && (_Triple.getArch() == Triple.ArchType.arm
         || _Triple.getArch() == Triple.ArchType.thumb)) {
        // Windows on ARM expects restricted IT blocks
        CmdArgs.push_back($("-backend-option"));
        CmdArgs.push_back($("-arm-restrict-it"));
      }
    }
    
    // Forward -cl options to -cc1
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_opt_disable.getValue())) != null)) {
      CmdArgs.push_back($("-cl-opt-disable"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_strict_aliasing.getValue())) != null)) {
      CmdArgs.push_back($("-cl-strict-aliasing"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_single_precision_constant.getValue())) != null)) {
      CmdArgs.push_back($("-cl-single-precision-constant"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_finite_math_only.getValue())) != null)) {
      CmdArgs.push_back($("-cl-finite-math-only"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_kernel_arg_info.getValue())) != null)) {
      CmdArgs.push_back($("-cl-kernel-arg-info"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_unsafe_math_optimizations.getValue())) != null)) {
      CmdArgs.push_back($("-cl-unsafe-math-optimizations"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_fast_relaxed_math.getValue())) != null)) {
      CmdArgs.push_back($("-cl-fast-relaxed-math"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_mad_enable.getValue())) != null)) {
      CmdArgs.push_back($("-cl-mad-enable"));
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_no_signed_zeros.getValue())) != null)) {
      CmdArgs.push_back($("-cl-no-signed-zeros"));
    }
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_std_EQ.getValue()));
      if ((A != null)) {
        std.string CLStdStr = new std.string(/*KEEP_STR*/"-cl-std=");
        CLStdStr.$addassign(A.getValue());
        CmdArgs.push_back(Args.MakeArgString(new Twine(CLStdStr)));
      }
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_cl_denorms_are_zero.getValue())) != null)) {
      CmdArgs.push_back($("-cl-denorms-are-zero"));
    }
    {
      
      // Forward -f options with positive and negative forms; we translate
      // these by hand.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fprofile_sample_use_EQ.getValue()));
      if ((A != null)) {
        StringRef fname = new StringRef(A.getValue());
        if (!fs.exists(new Twine(fname))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_such_file)), /*NO_COPY*/fname));
          } finally {
            $c$.$destroy();
          }
        } else {
          A.render(Args, CmdArgs);
        }
      }
    }
    
    // -fbuiltin is default unless -mkernel is used.
    boolean UseBuiltins = Args.hasFlag(new OptSpecifier(options.ID.OPT_fbuiltin.getValue()), new OptSpecifier(options.ID.OPT_fno_builtin.getValue()), 
        !Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue())));
    if (!UseBuiltins) {
      CmdArgs.push_back($("-fno-builtin"));
    }
    
    // -ffreestanding implies -fno-builtin.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_ffreestanding.getValue()))) {
      UseBuiltins = false;
    }
    
    // Process the -fno-builtin-* options.
    for (Arg /*P*/ /*const*/ /*&*/ Arg : Args) {
      /*const*/ Option /*&*/ O = Arg.getOption();
      if (!O.matches(new OptSpecifier(options.ID.OPT_fno_builtin_.getValue()))) {
        continue;
      }
      
      Arg.claim();
      // If -fno-builtin is specified, then there's no need to pass the option to
      // the frontend.
      if (!UseBuiltins) {
        continue;
      }
      
      StringRef FuncName = new StringRef(Arg.getValue());
      CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-fno-builtin-", FuncName)));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fassume_sane_operator_new.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_assume_sane_operator_new.getValue()))) {
      CmdArgs.push_back($("-fno-assume-sane-operator-new"));
    }
    
    // -fblocks=0 is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fblocks.getValue()), new OptSpecifier(options.ID.OPT_fno_blocks.getValue()), 
        getToolChain().IsBlocksDefault())
       || (Args.hasArg(new OptSpecifier(options.ID.OPT_fgnu_runtime.getValue()))
       && Args.hasArg(new OptSpecifier(options.ID.OPT_fobjc_nonfragile_abi.getValue()))
       && !Args.hasArg(new OptSpecifier(options.ID.OPT_fno_blocks.getValue())))) {
      CmdArgs.push_back($("-fblocks"));
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_fgnu_runtime.getValue()))
         && !getToolChain().hasBlocksRuntime()) {
        CmdArgs.push_back($("-fblocks-runtime-optional"));
      }
    }
    
    // -fmodules enables the use of precompiled modules (off by default).
    // Users can pass -fno-cxx-modules to turn off modules support for
    // C++/Objective-C++ programs.
    boolean HaveModules = false;
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fmodules.getValue()), new OptSpecifier(options.ID.OPT_fno_modules.getValue()), false)) {
      boolean AllowedInCXX = Args.hasFlag(new OptSpecifier(options.ID.OPT_fcxx_modules.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_cxx_modules.getValue()), true);
      if (AllowedInCXX || !types.isCXX(InputType)) {
        CmdArgs.push_back($("-fmodules"));
        HaveModules = true;
      }
    }
    
    // -fmodule-maps enables implicit reading of module map files. By default,
    // this is enabled if we are using precompiled modules.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fimplicit_module_maps.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_implicit_module_maps.getValue()), HaveModules)) {
      CmdArgs.push_back($("-fimplicit-module-maps"));
    }
    
    // -fmodules-decluse checks that modules used are declared so (off by
    // default).
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fmodules_decluse.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_modules_decluse.getValue()), false)) {
      CmdArgs.push_back($("-fmodules-decluse"));
    }
    
    // -fmodules-strict-decluse is like -fmodule-decluse, but also checks that
    // all #included headers are part of modules.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fmodules_strict_decluse.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_modules_strict_decluse.getValue()), false)) {
      CmdArgs.push_back($("-fmodules-strict-decluse"));
    }
    
    // -fno-implicit-modules turns off implicitly compiling modules on demand.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fimplicit_modules.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_implicit_modules.getValue()))) {
      CmdArgs.push_back($("-fno-implicit-modules"));
    } else if (HaveModules) {
      // -fmodule-cache-path specifies where our implicitly-built module files
      // should be written.
      SmallString/*128*/ Path/*J*/= new SmallString/*128*/(128);
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fmodules_cache_path.getValue()));
        if ((A != null)) {
          Path.$assign(/*STRINGREF_STR*/A.getValue());
        }
      }
      if (C.isForDiagnostics()) {
        // When generating crash reports, we want to emit the modules along with
        // the reproduction sources, so we ignore any provided module path.
        Path.$assign(/*STRINGREF_STR*/Output.getFilename());
        path.replace_extension(Path, new Twine(/*KEEP_STR*/".cache"));
        path.append(Path, new Twine(/*KEEP_STR*/"modules"));
      } else if (Path.empty()) {
        // No module path was provided: use the default.
        path.system_temp_directory(/*erasedOnReboot=*/ false, Path);
        path.append(Path, new Twine(/*KEEP_STR*/"org.llvm.clang."));
        appendUserToPath(Path);
        path.append(Path, new Twine(/*KEEP_STR*/"ModuleCache"));
      }
      /*const*//*char*/char$ptr Arg/*[22]*/ = $("-fmodules-cache-path=");
      Path.insert(Path.begin(), Arg, Arg.$add(strlen(Arg)));
      CmdArgs.push_back(Args.MakeArgString(new Twine(Path)));
    }
    
    // -fmodule-name specifies the module that is currently being built (or
    // used for header checking by -fmodule-maps).
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fmodule_name_EQ.getValue()));
    
    // -fmodule-map-file can be used to specify files containing module
    // definitions.
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_fmodule_map_file.getValue()));
    
    // -fmodule-file can be used to specify files containing precompiled modules.
    if (HaveModules) {
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_fmodule_file.getValue()));
    } else {
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fmodule_file.getValue()));
    }
    
    // When building modules and generating crashdumps, we need to dump a module
    // dependency VFS alongside the output.
    if (HaveModules && C.isForDiagnostics()) {
      SmallString/*128*/ VFSDir/*J*/= new SmallString/*128*/(new StringRef(Output.getFilename()), 128);
      path.replace_extension(VFSDir, new Twine(/*KEEP_STR*/".cache"));
      // Add the cache directory as a temp so the crash diagnostics pick it up.
      C.addTempFile(Args.MakeArgString(new Twine(VFSDir)));
      
      path.append(VFSDir, new Twine(/*KEEP_STR*/"vfs"));
      CmdArgs.push_back($("-module-dependency-dir"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(VFSDir)));
    }
    if (HaveModules) {
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fmodules_user_build_path.getValue()));
    }
    
    // Pass through all -fmodules-ignore-macro arguments.
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_fmodules_ignore_macro.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fmodules_prune_interval.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fmodules_prune_after.getValue()));
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fbuild_session_timestamp.getValue()));
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fbuild_session_file.getValue()));
      if ((A != null)) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_fbuild_session_timestamp.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                    new StringRef(A.getAsString(Args))), /*KEEP_STR*/"-fbuild-session-timestamp"));
          } finally {
            $c$.$destroy();
          }
        }
        
        fs.file_status Status/*J*/= new fs.file_status();
        if (fs.status(new Twine(A.getValue()), Status).$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_no_such_file)), A.getValue()));
          } finally {
            $c$.$destroy();
          }
        }
        CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-fbuild-session-timestamp="), 
                    new Twine(JD$ULLong.INSTANCE, (long/*uint64_t*/)Status.getLastModificationTime().toEpochTime()))));
      }
    }
    if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_fmodules_validate_once_per_build_session.getValue())) != null)) {
      if (!(Args.getLastArg(new OptSpecifier(options.ID.OPT_fbuild_session_timestamp.getValue()), 
          new OptSpecifier(options.ID.OPT_fbuild_session_file.getValue())) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(D.Diag(diag.err_drv_modules_validate_once_requires_timestamp)));
        } finally {
          $c$.$destroy();
        }
      }
      
      Args.AddLastArg(CmdArgs, 
          new OptSpecifier(options.ID.OPT_fmodules_validate_once_per_build_session.getValue()));
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_fmodules_validate_system_headers.getValue()));
    
    // -faccess-control is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fno_access_control.getValue()), 
        new OptSpecifier(options.ID.OPT_faccess_control.getValue()), false)) {
      CmdArgs.push_back($("-fno-access-control"));
    }
    
    // -felide-constructors is the default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fno_elide_constructors.getValue()), 
        new OptSpecifier(options.ID.OPT_felide_constructors.getValue()), false)) {
      CmdArgs.push_back($("-fno-elide-constructors"));
    }
    
    ToolChain.RTTIMode RTTIMode = getToolChain().getRTTIMode();
    if (KernelOrKext || (types.isCXX(InputType)
       && (RTTIMode == ToolChain.RTTIMode.RM_DisabledExplicitly
       || RTTIMode == ToolChain.RTTIMode.RM_DisabledImplicitly))) {
      CmdArgs.push_back($("-fno-rtti"));
    }
    
    // -fshort-enums=0 is default for all architectures except Hexagon.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fshort_enums.getValue()), new OptSpecifier(options.ID.OPT_fno_short_enums.getValue()), 
        getToolChain().getArch() == Triple.ArchType.hexagon)) {
      CmdArgs.push_back($("-fshort-enums"));
    }
    {
      
      // -fsigned-char is default.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fsigned_char.getValue()), new OptSpecifier(options.ID.OPT_fno_signed_char.getValue()), 
          new OptSpecifier(options.ID.OPT_funsigned_char.getValue()), new OptSpecifier(options.ID.OPT_fno_unsigned_char.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_funsigned_char.getValue()))
           || A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_signed_char.getValue()))) {
          CmdArgs.push_back($("-fno-signed-char"));
        }
      } else if (!isSignedCharDefault(getToolChain().getTriple())) {
        CmdArgs.push_back($("-fno-signed-char"));
      }
    }
    
    // -fuse-cxa-atexit is default.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fuse_cxa_atexit.getValue()), new OptSpecifier(options.ID.OPT_fno_use_cxa_atexit.getValue()), 
        !IsWindowsCygnus && !IsWindowsGNU
           && getToolChain().getTriple().getOS() != Triple.OSType.Solaris
           && getToolChain().getArch() != Triple.ArchType.hexagon
           && getToolChain().getArch() != Triple.ArchType.xcore
           && ((getToolChain().getTriple().getVendor()
           != Triple.VendorType.MipsTechnologies)
           || getToolChain().getTriple().hasEnvironment()))
       || KernelOrKext) {
      CmdArgs.push_back($("-fno-use-cxa-atexit"));
    }
    
    // -fms-extensions=0 is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fms_extensions.getValue()), new OptSpecifier(options.ID.OPT_fno_ms_extensions.getValue()), 
        IsWindowsMSVC)) {
      CmdArgs.push_back($("-fms-extensions"));
    }
    
    // -fno-use-line-directives is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fuse_line_directives.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_use_line_directives.getValue()), false)) {
      CmdArgs.push_back($("-fuse-line-directives"));
    }
    
    // -fms-compatibility=0 is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fms_compatibility.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_ms_compatibility.getValue()), 
        (IsWindowsMSVC
           && Args.hasFlag(new OptSpecifier(options.ID.OPT_fms_extensions.getValue()), 
            new OptSpecifier(options.ID.OPT_fno_ms_extensions.getValue()), true)))) {
      CmdArgs.push_back($("-fms-compatibility"));
    }
    
    // -fms-compatibility-version=18.00 is default.
    VersionTuple MSVT = VisualstudioStatics.getMSVCVersion(/*AddrOf*/D, getToolChain(), getToolChain().getTriple(), Args, IsWindowsMSVC);
    if (!MSVT.empty()) {
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string(/*KEEP_STR*/"-fms-compatibility-version=", MSVT.getAsString()))));
    }
    
    boolean IsMSVC2015Compatible = $greatereq_uint(MSVT.getMajor(), 19);
    if (ImplyVCPPCXXVer) {
      StringRef LanguageStandard/*J*/= new StringRef();
      {
        /*const*/ Arg /*P*/ StdArg = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_std.getValue()));
        if ((StdArg != null)) {
          LanguageStandard.$assign(new StringSwitchStringRef(/*STRINGREF_STR*/StdArg.getValue()).
                  Case(/*KEEP_STR*/"c++14", /*STRINGREF_STR*/"-std=c++14").
                  Case(/*KEEP_STR*/"c++latest", /*STRINGREF_STR*/"-std=c++1z").
                  Default(/*KEEP_STR*/""));
          if (LanguageStandard.empty()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_unused_argument)), 
                  new StringRef(StdArg.getAsString(Args))));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      if (LanguageStandard.empty()) {
        if (IsMSVC2015Compatible) {
          LanguageStandard.$assignMove(/*STRINGREF_STR*/"-std=c++14");
        } else {
          LanguageStandard.$assignMove(/*STRINGREF_STR*/"-std=c++11");
        }
      }
      
      CmdArgs.push_back(LanguageStandard.data());
    }
    
    // -fno-borland-extensions is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fborland_extensions.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_borland_extensions.getValue()), false)) {
      CmdArgs.push_back($("-fborland-extensions"));
    }
    
    // -fno-declspec is default, except for PS4.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fdeclspec.getValue()), new OptSpecifier(options.ID.OPT_fno_declspec.getValue()), 
        getToolChain().getTriple().isPS4())) {
      CmdArgs.push_back($("-fdeclspec"));
    } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_fno_declspec.getValue()))) {
      CmdArgs.push_back($("-fno-declspec")); // Explicitly disabling __declspec.
    }
    
    // -fthreadsafe-static is default, except for MSVC compatibility versions less
    // than 19.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fthreadsafe_statics.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_threadsafe_statics.getValue()), 
        !IsWindowsMSVC || IsMSVC2015Compatible)) {
      CmdArgs.push_back($("-fno-threadsafe-statics"));
    }
    
    // -fno-delayed-template-parsing is default, except for Windows where MSVC STL
    // needs it.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fdelayed_template_parsing.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_delayed_template_parsing.getValue()), IsWindowsMSVC)) {
      CmdArgs.push_back($("-fdelayed-template-parsing"));
    }
    {
      
      // -fgnu-keywords default varies depending on language; only pass if
      // specified.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fgnu_keywords.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_gnu_keywords.getValue()));
      if ((A != null)) {
        A.render(Args, CmdArgs);
      }
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fgnu89_inline.getValue()), new OptSpecifier(options.ID.OPT_fno_gnu89_inline.getValue()), 
        false)) {
      CmdArgs.push_back($("-fgnu89-inline"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_fno_inline.getValue()))) {
      CmdArgs.push_back($("-fno-inline"));
    }
    {
      
      Arg /*P*/ InlineArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_finline_functions.getValue()), 
          new OptSpecifier(options.ID.OPT_finline_hint_functions.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_inline_functions.getValue()));
      if ((InlineArg != null)) {
        InlineArg.render(Args, CmdArgs);
      }
    }
    
    ObjCRuntime objcRuntime = AddObjCRuntimeArgs(Args, CmdArgs, rewriteKind);
    
    // -fobjc-dispatch-method is only relevant with the nonfragile-abi, and
    // legacy is the default. Except for deployment taget of 10.5,
    // next runtime is always legacy dispatch and -fno-objc-legacy-dispatch
    // gets ignored silently.
    if (objcRuntime.isNonFragile()) {
      if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fobjc_legacy_dispatch.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_objc_legacy_dispatch.getValue()), 
          objcRuntime.isLegacyDispatchDefaultForArch(getToolChain().getArch()))) {
        if (getToolChain().UseObjCMixedDispatch()) {
          CmdArgs.push_back($("-fobjc-dispatch-method=mixed"));
        } else {
          CmdArgs.push_back($("-fobjc-dispatch-method=non-legacy"));
        }
      }
    }
    
    // When ObjectiveC legacy runtime is in effect on MacOSX,
    // turn on the option to do Array/Dictionary subscripting
    // by default.
    if (getToolChain().getArch() == Triple.ArchType.x86
       && getToolChain().getTriple().isMacOSX()
       && !getToolChain().getTriple().isMacOSXVersionLT(10, 7)
       && objcRuntime.getKind() == ObjCRuntime.Kind.FragileMacOSX
       && objcRuntime.isNeXTFamily()) {
      CmdArgs.push_back($("-fobjc-subscripting-legacy-runtime"));
    }
    
    // -fencode-extended-block-signature=1 is default.
    if (getToolChain().IsEncodeExtendedBlockSignatureDefault()) {
      CmdArgs.push_back($("-fencode-extended-block-signature"));
    }
    
    // Allow -fno-objc-arr to trump -fobjc-arr/-fobjc-arc.
    // NOTE: This logic is duplicated in ToolChains.cpp.
    boolean ARC = ToolsStatics.isObjCAutoRefCount(Args);
    if (ARC) {
      getToolChain().CheckObjCARC();
      
      CmdArgs.push_back($("-fobjc-arc"));
      
      // FIXME: It seems like this entire block, and several around it should be
      // wrapped in isObjC, but for now we just use it here as this is where it
      // was being used previously.
      if (types.isCXX(InputType) && types.isObjC(InputType)) {
        if (getToolChain().GetCXXStdlibType(Args) == ToolChain.CXXStdlibType.CST_Libcxx) {
          CmdArgs.push_back($("-fobjc-arc-cxxlib=libc++"));
        } else {
          CmdArgs.push_back($("-fobjc-arc-cxxlib=libstdc++"));
        }
      }
      
      // Allow the user to enable full exceptions code emission.
      // We define off for Objective-CC, on for Objective-C++.
      if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fobjc_arc_exceptions.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_objc_arc_exceptions.getValue()), 
          /*default*/ types.isCXX(InputType))) {
        CmdArgs.push_back($("-fobjc-arc-exceptions"));
      }
    }
    
    // -fobjc-infer-related-result-type is the default, except in the Objective-C
    // rewriter.
    if (rewriteKind != RewriteKind.RK_None) {
      CmdArgs.push_back($("-fno-objc-infer-related-result-type"));
    }
    
    // Handle -fobjc-gc and -fobjc-gc-only. They are exclusive, and -fobjc-gc-only
    // takes precedence.
    /*const*/ Arg /*P*/ GCArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_fobjc_gc_only.getValue()));
    if (!(GCArg != null)) {
      GCArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_fobjc_gc.getValue()));
    }
    if ((GCArg != null)) {
      if (ARC) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_objc_gc_arr)), new StringRef(GCArg.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      } else if (getToolChain().SupportsObjCGC()) {
        GCArg.render(Args, CmdArgs);
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXME: We should move this to a hard error.
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_objc_gc_unsupported)), new StringRef(GCArg.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Pass down -fobjc-weak or -fno-objc-weak if present.
    if (types.isObjC(InputType)) {
      Arg /*P*/ WeakArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_fobjc_weak.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_objc_weak.getValue()));
      if (!(WeakArg != null)) {
        // nothing to do
      } else if ((GCArg != null)) {
        if (WeakArg.getOption().matches(new OptSpecifier(options.ID.OPT_fobjc_weak.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(D.Diag(diag.err_objc_weak_with_gc)));
          } finally {
            $c$.$destroy();
          }
        }
      } else if (!objcRuntime.allowsWeak()) {
        if (WeakArg.getOption().matches(new OptSpecifier(options.ID.OPT_fobjc_weak.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(D.Diag(diag.err_objc_weak_unsupported)));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        WeakArg.render(Args, CmdArgs);
      }
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fapplication_extension.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_application_extension.getValue()), false)) {
      CmdArgs.push_back($("-fapplication-extension"));
    }
    
    // Handle GCC-style exception args.
    if (!C.getDriver().IsCLMode()) {
      addExceptionArgs(Args, InputType, getToolChain(), KernelOrKext, objcRuntime, 
          CmdArgs);
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_fsjlj_exceptions.getValue()))
       || getToolChain().UseSjLjExceptions(Args)) {
      CmdArgs.push_back($("-fsjlj-exceptions"));
    }
    
    // C++ "sane" operator new.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fassume_sane_operator_new.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_assume_sane_operator_new.getValue()))) {
      CmdArgs.push_back($("-fno-assume-sane-operator-new"));
    }
    
    // -fsized-deallocation is off by default, as it is an ABI-breaking change for
    // most platforms.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fsized_deallocation.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_sized_deallocation.getValue()), false)) {
      CmdArgs.push_back($("-fsized-deallocation"));
    }
    
    // -fconstant-cfstrings is default, and may be subject to argument translation
    // on Darwin.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fconstant_cfstrings.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_constant_cfstrings.getValue()))
       || !Args.hasFlag(new OptSpecifier(options.ID.OPT_mconstant_cfstrings.getValue()), 
        new OptSpecifier(options.ID.OPT_mno_constant_cfstrings.getValue()))) {
      CmdArgs.push_back($("-fno-constant-cfstrings"));
    }
    {
      
      // -fshort-wchar default varies depending on platform; only
      // pass if specified.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fshort_wchar.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_short_wchar.getValue()));
      if ((A != null)) {
        A.render(Args, CmdArgs);
      }
    }
    
    // -fno-pascal-strings is default, only pass non-default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fpascal_strings.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_pascal_strings.getValue()), false)) {
      CmdArgs.push_back($("-fpascal-strings"));
    }
    {
      
      // Honor -fpack-struct= and -fpack-struct, if given. Note that
      // -fno-pack-struct doesn't apply to -fpack-struct=.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fpack_struct_EQ.getValue()));
      if ((A != null)) {
        std.string PackStructStr = new std.string(/*KEEP_STR*/"-fpack-struct=");
        PackStructStr.$addassign(A.getValue());
        CmdArgs.push_back(Args.MakeArgString(new Twine(PackStructStr)));
      } else if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fpack_struct.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_pack_struct.getValue()), false)) {
        CmdArgs.push_back($("-fpack-struct=1"));
      }
    }
    
    // Handle -fmax-type-align=N and -fno-type-align
    boolean SkipMaxTypeAlign = Args.hasArg(new OptSpecifier(options.ID.OPT_fno_max_type_align.getValue()));
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fmax_type_align_EQ.getValue()));
      if ((A != null)) {
        if (!SkipMaxTypeAlign) {
          std.string MaxTypeAlignStr = new std.string(/*KEEP_STR*/"-fmax-type-align=");
          MaxTypeAlignStr.$addassign(A.getValue());
          CmdArgs.push_back(Args.MakeArgString(new Twine(MaxTypeAlignStr)));
        }
      } else if (getToolChain().getTriple().isOSDarwin()) {
        if (!SkipMaxTypeAlign) {
          std.string MaxTypeAlignStr = new std.string(/*KEEP_STR*/"-fmax-type-align=16");
          CmdArgs.push_back(Args.MakeArgString(new Twine(MaxTypeAlignStr)));
        }
      }
    }
    
    // -fcommon is the default unless compiling kernel code or the target says so
    boolean NoCommonDefault = KernelOrKext || isNoCommonDefault(getToolChain().getTriple());
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fcommon.getValue()), new OptSpecifier(options.ID.OPT_fno_common.getValue()), 
        !NoCommonDefault)) {
      CmdArgs.push_back($("-fno-common"));
    }
    
    // -fsigned-bitfields is default, and clang doesn't yet support
    // -funsigned-bitfields.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fsigned_bitfields.getValue()), 
        new OptSpecifier(options.ID.OPT_funsigned_bitfields.getValue()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_clang_unsupported)), 
            new StringRef(Args.getLastArg(new OptSpecifier(options.ID.OPT_funsigned_bitfields.getValue())).getAsString(Args))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // -fsigned-bitfields is default, and clang doesn't support -fno-for-scope.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_ffor_scope.getValue()), new OptSpecifier(options.ID.OPT_fno_for_scope.getValue()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported)), 
            new StringRef(Args.getLastArg(new OptSpecifier(options.ID.OPT_fno_for_scope.getValue())).getAsString(Args))));
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      // -finput_charset=UTF-8 is default. Reject others
      Arg /*P*/ inputCharset = Args.getLastArg(new OptSpecifier(options.ID.OPT_finput_charset_EQ.getValue()));
      if ((inputCharset != null)) {
        StringRef value = new StringRef(inputCharset.getValue());
        if ($noteq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"UTF-8")) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), new StringRef(inputCharset.getAsString(Args))), 
                /*NO_COPY*/value));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    {
      
      // -fexec_charset=UTF-8 is default. Reject others
      Arg /*P*/ execCharset = Args.getLastArg(new OptSpecifier(options.ID.OPT_fexec_charset_EQ.getValue()));
      if ((execCharset != null)) {
        StringRef value = new StringRef(execCharset.getValue());
        if ($noteq_StringRef(/*NO_COPY*/value, /*STRINGREF_STR*/"UTF-8")) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), new StringRef(execCharset.getAsString(Args))), 
                /*NO_COPY*/value));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // -fcaret-diagnostics is default.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fcaret_diagnostics.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_caret_diagnostics.getValue()), true)) {
      CmdArgs.push_back($("-fno-caret-diagnostics"));
    }
    
    // -fdiagnostics-fixit-info is default, only pass non-default.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fdiagnostics_fixit_info.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_diagnostics_fixit_info.getValue()))) {
      CmdArgs.push_back($("-fno-diagnostics-fixit-info"));
    }
    
    // Enable -fdiagnostics-show-option by default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fdiagnostics_show_option.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_diagnostics_show_option.getValue()))) {
      CmdArgs.push_back($("-fdiagnostics-show-option"));
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fdiagnostics_show_category_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fdiagnostics-show-category"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fdiagnostics_format_EQ.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-fdiagnostics-format"));
        CmdArgs.push_back(A.getValue());
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fdiagnostics_show_note_include_stack.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_diagnostics_show_note_include_stack.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fdiagnostics_show_note_include_stack.getValue()))) {
          CmdArgs.push_back($("-fdiagnostics-show-note-include-stack"));
        } else {
          CmdArgs.push_back($("-fno-diagnostics-show-note-include-stack"));
        }
      }
    }
    
    // Color diagnostics are parsed by the driver directly from argv
    // and later re-parsed to construct this job; claim any possible
    // color diagnostic here to avoid warn_drv_unused_argument and
    // diagnose bad OPT_fdiagnostics_color_EQ values.
    for (Arg /*P*/ A : Args) {
      /*const*/ Option /*&*/ O = A.getOption();
      if (!O.matches(new OptSpecifier(options.ID.OPT_fcolor_diagnostics.getValue()))
         && !O.matches(new OptSpecifier(options.ID.OPT_fdiagnostics_color.getValue()))
         && !O.matches(new OptSpecifier(options.ID.OPT_fno_color_diagnostics.getValue()))
         && !O.matches(new OptSpecifier(options.ID.OPT_fno_diagnostics_color.getValue()))
         && !O.matches(new OptSpecifier(options.ID.OPT_fdiagnostics_color_EQ.getValue()))) {
        continue;
      }
      if (O.matches(new OptSpecifier(options.ID.OPT_fdiagnostics_color_EQ.getValue()))) {
        StringRef Value/*J*/= new StringRef(A.getValue());
        if ($noteq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"always") && $noteq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"never") && $noteq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"auto")) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getToolChain().getDriver().Diag(diag.err_drv_clang_unsupported)), 
                new StringRef(($add_char$ptr$C_StringRef(/*KEEP_STR*/"-fdiagnostics-color=", Value)).str())));
          } finally {
            $c$.$destroy();
          }
        }
      }
      A.claim();
    }
    if (D.getDiags().getDiagnosticOptions().ShowColors) {
      CmdArgs.push_back($("-fcolor-diagnostics"));
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_fansi_escape_codes.getValue()))) {
      CmdArgs.push_back($("-fansi-escape-codes"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fshow_source_location.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_show_source_location.getValue()))) {
      CmdArgs.push_back($("-fno-show-source-location"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fshow_column.getValue()), new OptSpecifier(options.ID.OPT_fno_show_column.getValue()), 
        true)) {
      CmdArgs.push_back($("-fno-show-column"));
    }
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fspell_checking.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_spell_checking.getValue()))) {
      CmdArgs.push_back($("-fno-spell-checking"));
    }
    
    // -fno-asm-blocks is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fasm_blocks.getValue()), new OptSpecifier(options.ID.OPT_fno_asm_blocks.getValue()), 
        false)) {
      CmdArgs.push_back($("-fasm-blocks"));
    }
    
    // -fgnu-inline-asm is default.
    if (!Args.hasFlag(new OptSpecifier(options.ID.OPT_fgnu_inline_asm.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_gnu_inline_asm.getValue()), true)) {
      CmdArgs.push_back($("-fno-gnu-inline-asm"));
    }
    
    // Enable vectorization per default according to the optimization level
    // selected. For optimization levels that want vectorization we use the alias
    // option to simplify the hasFlag logic.
    boolean EnableVec = shouldEnableVectorizerAtOLevel(Args, false);
    OptSpecifier VectorizeAliasOption = new OptSpecifier(EnableVec ? options.ID.OPT_O_Group.getValue() : options.ID.OPT_fvectorize.getValue());
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fvectorize.getValue()), /*NO_COPY*/VectorizeAliasOption, 
        new OptSpecifier(options.ID.OPT_fno_vectorize.getValue()), EnableVec)) {
      CmdArgs.push_back($("-vectorize-loops"));
    }
    
    // -fslp-vectorize is enabled based on the optimization level selected.
    boolean EnableSLPVec = shouldEnableVectorizerAtOLevel(Args, true);
    OptSpecifier SLPVectAliasOption = new OptSpecifier(EnableSLPVec ? options.ID.OPT_O_Group.getValue() : options.ID.OPT_fslp_vectorize.getValue());
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fslp_vectorize.getValue()), /*NO_COPY*/SLPVectAliasOption, 
        new OptSpecifier(options.ID.OPT_fno_slp_vectorize.getValue()), EnableSLPVec)) {
      CmdArgs.push_back($("-vectorize-slp"));
    }
    
    // -fno-slp-vectorize-aggressive is default.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fslp_vectorize_aggressive.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_slp_vectorize_aggressive.getValue()), false)) {
      CmdArgs.push_back($("-vectorize-slp-aggressive"));
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fshow_overloads_EQ.getValue()));
      if ((A != null)) {
        A.render(Args, CmdArgs);
      }
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fsanitize_undefined_strip_path_components_EQ.getValue()));
      if ((A != null)) {
        A.render(Args, CmdArgs);
      }
    }
    {
      
      // -fdollars-in-identifiers default varies depending on platform and
      // language; only pass if specified.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fdollars_in_identifiers.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_dollars_in_identifiers.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fdollars_in_identifiers.getValue()))) {
          CmdArgs.push_back($("-fdollars-in-identifiers"));
        } else {
          CmdArgs.push_back($("-fno-dollars-in-identifiers"));
        }
      }
    }
    {
      
      // -funit-at-a-time is default, and we don't support -fno-unit-at-a-time for
      // practical purposes.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_funit_at_a_time.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_unit_at_a_time.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_fno_unit_at_a_time.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.warn_drv_clang_unsupported)), new StringRef(A.getAsString(Args))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fapple_pragma_pack.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_apple_pragma_pack.getValue()), false)) {
      CmdArgs.push_back($("-fapple-pragma-pack"));
    }
    
    // le32-specific flags:
    //  -fno-math-builtin: clang should not convert math builtins to intrinsics
    //                     by default.
    if (getToolChain().getArch() == Triple.ArchType.le32) {
      CmdArgs.push_back($("-fno-math-builtin"));
    }
    
    // Enable rewrite includes if the user's asked for it or if we're generating
    // diagnostics.
    // TODO: Once -module-dependency-dir works with -frewrite-includes it'd be
    // nice to enable this when doing a crashdump for modules as well.
    if (Args.hasFlag(new OptSpecifier(options.ID.OPT_frewrite_includes.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_rewrite_includes.getValue()), false)
       || (C.isForDiagnostics() && !HaveModules)) {
      CmdArgs.push_back($("-frewrite-includes"));
    }
    {
      
      // Only allow -traditional or -traditional-cpp outside in preprocessing modes.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_traditional.getValue()), 
          new OptSpecifier(options.ID.OPT_traditional_cpp.getValue()));
      if ((A != null)) {
        if (isa(PreprocessJobAction.class, JA)) {
          CmdArgs.push_back($("-traditional-cpp"));
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_clang_unsupported)), new StringRef(A.getAsString(Args))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_dM.getValue()));
    Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_dD.getValue()));
    {
      
      // Handle serialized diagnostics.
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__serialize_diags.getValue()));
      if ((A != null)) {
        CmdArgs.push_back($("-serialize-diagnostic-file"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(A.getValue())));
      }
    }
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_fretain_comments_from_system_headers.getValue()))) {
      CmdArgs.push_back($("-fretain-comments-from-system-headers"));
    }
    
    // Forward -fcomment-block-commands to -cc1.
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_fcomment_block_commands.getValue()));
    // Forward -fparse-all-comments to -cc1.
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_fparse_all_comments.getValue()));
    
    // Turn -fplugin=name.so into -load name.so
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_fplugin_EQ.getValue()))) {
      CmdArgs.push_back($("-load"));
      CmdArgs.push_back(A.getValue());
      A.claim();
    }
    
    // Forward -Xclang arguments to -cc1, and -mllvm arguments to the LLVM option
    // parser.
    Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Xclang.getValue()));
    for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_mllvm.getValue()))) {
      A.claim();
      
      // We translate this by hand to the -cc1 argument, since nightly test uses
      // it and developers have been trained to spell it with -mllvm.
      if ($eq_StringRef(/*STRINGREF_STR*/A.getValue(0), /*STRINGREF_STR*/"-disable-llvm-optzns")) {
        CmdArgs.push_back($("-disable-llvm-optzns"));
      } else {
        A.render(Args, CmdArgs);
      }
    }
    
    // With -save-temps, we want to save the unoptimized bitcode output from the
    // CompileJobAction, use -disable-llvm-passes to get pristine IR generated
    // by the frontend.
    // When -fembed-bitcode is enabled, optimized bitcode is emitted because it
    // has slightly different breakdown between stages.
    // FIXME: -fembed-bitcode -save-temps will save optimized bitcode instead of
    // pristine IR generated by the frontend. Ideally, a new compile action should
    // be added so both IR can be captured.
    if (C.getDriver().isSaveTempsEnabled()
       && !C.getDriver().embedBitcodeEnabled() && isa(CompileJobAction.class, JA)) {
      CmdArgs.push_back($("-disable-llvm-passes"));
    }
    if (Output.getType() == types.ID.TY_Dependencies) {
      // Handled with other dependency code.
    } else if (Output.isFilename()) {
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
    } else {
      assert (Output.isNothing()) : "Invalid output.";
    }
    
    addDashXForInput(Args, Input, CmdArgs);
    if (Input.isFilename()) {
      CmdArgs.push_back(Input.getFilename());
    } else {
      Input.getInputArg().renderAsInput(Args, CmdArgs);
    }
    
    Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_undef.getValue()));
    
    /*const*/char$ptr/*char P*/ Exec = $tryClone(getToolChain().getDriver().getClangProgramPath());
    
    // Optionally embed the -cc1 level arguments into the debug info, for build
    // analysis.
    if (getToolChain().UseDwarfDebugFlags()) {
      ArgStringList OriginalArgs/*J*/= new ArgStringList();
      for (Arg /*P*/ /*const*/ /*&*/ Arg : Args)  {
        Arg.render(Args, OriginalArgs);
      }
      
      SmallString/*256*/ Flags/*J*/= new SmallString/*256*/(256);
      Flags.$addassign(/*STRINGREF_STR*/Exec);
      for (/*const*/char$ptr/*char P*/ OriginalArg : OriginalArgs) {
        SmallString/*128*/ EscapedArg/*J*/= new SmallString/*128*/(128);
        EscapeSpacesAndBackslashes(OriginalArg, EscapedArg);
        Flags.$addassign(/*STRINGREF_STR*/" ");
        Flags.$addassign(EscapedArg.$StringRef());
      }
      CmdArgs.push_back($("-dwarf-debug-flags"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(Flags)));
    }
    
    // Add the split debug info name to the command lines here so we
    // can propagate it to the backend.
    boolean SplitDwarf = (SplitDwarfArg != null) && getToolChain().getTriple().isOSLinux()
       && (isa(AssembleJobAction.class, JA) || isa(CompileJobAction.class, JA)
       || isa(BackendJobAction.class, JA));
    /*const*/char$ptr/*char P*/ SplitDwarfOut = create_char$null$ptr();
    if (SplitDwarf) {
      CmdArgs.push_back($("-split-dwarf-file"));
      SplitDwarfOut = $tryClone(SplitDebugName(Args, Input));
      CmdArgs.push_back(SplitDwarfOut);
    }
    
    // Host-side cuda compilation receives device-side outputs as Inputs[1...].
    // Include them with -fcuda-include-gpubinary.
    if (IsCuda && $greater_uint(Inputs.size(), 1)) {
      for (/*const*/ type$ptr<InputInfo> /*P*/ I = std.next(Inputs.begin()), /*P*/ E = Inputs.end(); I.$noteq(E); I.$preInc()) {
        CmdArgs.push_back($("-fcuda-include-gpubinary"));
        CmdArgs.push_back(I.$star().getFilename());
      }
    }
    
    boolean WholeProgramVTables = Args.hasFlag(new OptSpecifier(options.ID.OPT_fwhole_program_vtables.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_whole_program_vtables.getValue()), false);
    if (WholeProgramVTables) {
      if (!D.isUsingLTO()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_only_allowed_with)), 
                  /*KEEP_STR*/"-fwhole-program-vtables"), 
              /*KEEP_STR*/"-flto"));
        } finally {
          $c$.$destroy();
        }
      }
      CmdArgs.push_back($("-fwhole-program-vtables"));
    }
    
    // Finally add the compile command to the compilation.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_fallback.getValue()))
       && Output.getType() == types.ID.TY_Object
       && (InputType == types.ID.TY_C || InputType == types.ID.TY_CXX)) {
      unique_ptr<Command> CLCommand = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        CLCommand = getCLFallback().GetCommand(C, JA, Output, Inputs, Args, LinkingOutput);
        C.addCommand($c$.track(new std.unique_ptr<Command>($c$.track(llvm.make_unique(new FallbackCommand(JA, /*Deref*/this, Exec, CmdArgs, new ArrayRef(Inputs), std.move(CLCommand))))))); $c$.clean();
      } finally {
        if (CLCommand != null) { CLCommand.$destroy(); }
        $c$.$destroy();
      }
    } else if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_fallback.getValue()))
       && isa(PrecompileJobAction.class, JA)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // In /fallback builds, run the main compilation even if the pch generation
        // fails, so that the main compilation's fallback to cl.exe runs.
        C.addCommand($c$.track(new std.unique_ptr<Command>($c$.track(llvm.make_unique(new ForceSuccessCommand(JA, /*Deref*/this, Exec, 
                    CmdArgs, new ArrayRef(Inputs))))))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Handle the debug info splitting at object creation time if we're
    // creating an object.
    // TODO: Currently only works on linux with newer objcopy.
    if (SplitDwarf && Output.getType() == types.ID.TY_Object) {
      SplitDebugInfo(getToolChain(), C, /*Deref*/this, JA, Args, Output, SplitDwarfOut);
    }
    {
      
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_pg.getValue()));
      if ((A != null)) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_fomit_frame_pointer.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), /*KEEP_STR*/"-fomit-frame-pointer"), 
                new StringRef(A.getAsString(Args))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Claim some arguments which clang supports automatically.
    
    // -fpch-preprocess is used with gcc to add a special marker in the output to
    // include the PCH file. Clang's PTH solution is completely transparent, so we
    // do not need to deal with it at all.
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_fpch_preprocess.getValue()));
    
    // Claim some arguments which clang doesn't support, but we don't
    // care to warn the user about.
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_clang_ignored_f_Group.getValue()));
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_clang_ignored_m_Group.getValue()));
    
    // Disable warnings for clang -E -emit-llvm foo.c
    Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Clang::~Clang">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 46,
   FQN="clang::driver::tools::Clang::~Clang", NM="_ZN5clang6driver5tools5ClangD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5ClangD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CLFallback.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "CLFallback=" + CLFallback // NOI18N
              + super.toString(); // NOI18N
  }
}
