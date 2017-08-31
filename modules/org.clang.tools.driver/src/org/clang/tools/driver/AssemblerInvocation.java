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

package org.clang.tools.driver;

import org.llvm.support.sys.sys;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.driver.DriverGlobals.*;
import org.clang.driver.options;
import org.llvm.option.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import static org.llvm.option.arg_iterator.*;
import org.clang.driver.options.ID;

/// \brief Helper class for representing a single invocation of the assembler.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblerInvocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 65,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", old_line = 67,
 FQN="(anonymous namespace)::AssemblerInvocation", NM="_ZN12_GLOBAL__N_119AssemblerInvocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZN12_GLOBAL__N_119AssemblerInvocationE")
//</editor-fold>
public class/*struct*/ AssemblerInvocation implements Destructors.ClassWithDestructor {
  /// @name Target Options
  /// @{
  
  /// The name of the target triple to assemble for.
  public std.string Triple;
  
  /// If given, the name of the target CPU to determine which instructions
  /// are legal.
  public std.string CPU;
  
  /// The list of target specific features to enable or disable -- this should
  /// be a list of strings starting with '+' or '-'.
  public std.vectorString Features;
  
  /// @}
  /// @name Language Options
  /// @{
  public std.vectorString IncludePaths;
  public /*JBIT unsigned int*/ boolean NoInitialTextSection /*: 1*/;
  public /*JBIT unsigned int*/ boolean SaveTemporaryLabels /*: 1*/;
  public /*JBIT unsigned int*/ boolean GenDwarfForAssembly /*: 1*/;
  public /*JBIT unsigned int*/ boolean CompressDebugSections /*: 1*/;
  public /*JBIT unsigned int*/ boolean RelaxELFRelocations /*: 1*/;
  public /*uint*/int DwarfVersion;
  public std.string DwarfDebugFlags;
  public std.string DwarfDebugProducer;
  public std.string DebugCompilationDir;
  public std.string MainFileName;
  
  /// @}
  /// @name Frontend Options
  /// @{
  public std.string InputFile;
  public std.vectorString LLVMArgs;
  public std.string OutputPath;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblerInvocation::FileType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", old_line = 104,
   FQN="(anonymous namespace)::AssemblerInvocation::FileType", NM="_ZN12_GLOBAL__N_119AssemblerInvocation8FileTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZN12_GLOBAL__N_119AssemblerInvocation8FileTypeE")
  //</editor-fold>
  public enum FileType implements Native.ComparableLower {
    FT_Asm(0), ///< Assembly (.s) output, transliterate mode.
    FT_Null(FT_Asm.getValue() + 1), ///< No output, for timing purposes.
    FT_Obj(FT_Null.getValue() + 1); ///< Object file output.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FileType valueOf(int val) {
      FileType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FileType[] VALUES;
      private static final FileType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FileType kind : FileType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FileType[min < 0 ? (1-min) : 0];
        VALUES = new FileType[max >= 0 ? (1+max) : 0];
        for (FileType kind : FileType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FileType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FileType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FileType)obj).value);}
    //</editor-fold>
  };
  public FileType OutputType;
  public /*JBIT unsigned int*/ boolean ShowHelp /*: 1*/;
  public /*JBIT unsigned int*/ boolean ShowVersion /*: 1*/;
  
  /// @}
  /// @name Transliterate Options
  /// @{
  public /*uint*/int OutputAsmVariant;
  public /*JBIT unsigned int*/ boolean ShowEncoding /*: 1*/;
  public /*JBIT unsigned int*/ boolean ShowInst /*: 1*/;
  
  /// @}
  /// @name Assembler Options
  /// @{
  public /*JBIT unsigned int*/ boolean RelaxAll /*: 1*/;
  public /*JBIT unsigned int*/ boolean NoExecStack /*: 1*/;
  public /*JBIT unsigned int*/ boolean FatalWarnings /*: 1*/;
  public /*JBIT unsigned int*/ boolean IncrementalLinkerCompatible /*: 1*/;
  
  /// The name of the relocation model to use.
  public std.string RelocationModel;

  /// @}
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblerInvocation::AssemblerInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", old_line = 136,
   FQN="(anonymous namespace)::AssemblerInvocation::AssemblerInvocation", NM="_ZN12_GLOBAL__N_119AssemblerInvocationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZN12_GLOBAL__N_119AssemblerInvocationC1Ev")
  //</editor-fold>
  public AssemblerInvocation() {
    /* : Triple(), CPU(), Features(), IncludePaths(), DwarfDebugFlags(), DwarfDebugProducer(), DebugCompilationDir(), MainFileName(), InputFile(), LLVMArgs(), OutputPath(), RelocationModel()*/ 
    //START JInit
    this.Triple = new std.string();
    this.CPU = new std.string();
    this.Features = new std.vectorString(std.string.EMPTY);
    this.IncludePaths = new std.vectorString(std.string.EMPTY);
    this.DwarfDebugFlags = new std.string();
    this.DwarfDebugProducer = new std.string();
    this.DebugCompilationDir = new std.string();
    this.MainFileName = new std.string();
    this.InputFile = new std.string();
    this.LLVMArgs = new std.vectorString(std.string.EMPTY);
    this.OutputPath = new std.string();
    this.RelocationModel = new std.string();
    //END JInit
    Triple.$assign(/*KEEP_STR*/"");
    NoInitialTextSection = false;
    InputFile.$assign(/*KEEP_STR*/"-");
    OutputPath.$assign(/*KEEP_STR*/"-");
    OutputType = FileType.FT_Asm;
    OutputAsmVariant = 0;
    ShowInst = false;
    ShowEncoding = false;
    RelaxAll = false;
    NoExecStack = false;
    FatalWarnings = false;
    IncrementalLinkerCompatible = false;
    DwarfVersion = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblerInvocation::CreateFromArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 158,
   old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", old_line = 159,
   FQN="(anonymous namespace)::AssemblerInvocation::CreateFromArgs", NM="_ZN12_GLOBAL__N_119AssemblerInvocation14CreateFromArgsERS0_N4llvm8ArrayRefIPKcEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZN12_GLOBAL__N_119AssemblerInvocation14CreateFromArgsERS0_N4llvm8ArrayRefIPKcEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  public static boolean CreateFromArgs(AssemblerInvocation /*&*/ Opts, 
                ArrayRef</*const*/char$ptr/*char P*/ > Argv, 
                DiagnosticsEngine /*&*/ Diags) {
    std.unique_ptr<OptTable> OptTbl = null;
    InputArgList Args = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean Success = true;
      
      // Parse the arguments.
      OptTbl/*J*/= new std.unique_ptr<OptTable>(createDriverOptTable());
      
      /*const*//*uint*/int IncludedFlagsBitmask = options.ClangFlags.CC1AsOption;
      /*uint*/uint$ref MissingArgIndex = create_uint$ref(), MissingArgCount = create_uint$ref();
      Args = OptTbl.$arrow().ParseArgs(new ArrayRef</*const*/char$ptr/*char P*/ >(Argv), MissingArgIndex, MissingArgCount, 
          IncludedFlagsBitmask);
      
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
      
      // Construct the invocation.
      
      // Target Options
      Opts.Triple.$assignMove(org.llvm.adt.Triple.normalize(Args.getLastArgValue(new OptSpecifier(ID.OPT_triple.getValue()))));
      Opts.CPU.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_target_cpu.getValue())).$string());
      $c$.clean(Opts.Features.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_target_feature.getValue())))));
      
      // Use the default target triple if unspecified.
      if (Opts.Triple.empty()) {
        Opts.Triple.$assignMove(sys.getDefaultTargetTriple());
      }
      
      // Language Options
      $c$.clean(Opts.IncludePaths.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_I.getValue())))));
      Opts.NoInitialTextSection = Args.hasArg(new OptSpecifier(ID.OPT_n.getValue()));
      Opts.SaveTemporaryLabels = Args.hasArg(new OptSpecifier(ID.OPT_msave_temp_labels.getValue()));
      // Any DebugInfoKind implies GenDwarfForAssembly.
      Opts.GenDwarfForAssembly = Args.hasArg(new OptSpecifier(ID.OPT_debug_info_kind_EQ.getValue()));
      Opts.CompressDebugSections = Args.hasArg(new OptSpecifier(ID.OPT_compress_debug_sections.getValue()));
      Opts.RelaxELFRelocations = Args.hasArg(new OptSpecifier(ID.OPT_mrelax_relocations.getValue()));
      Opts.DwarfVersion = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_dwarf_version_EQ.getValue()), 2, Diags);
      Opts.DwarfDebugFlags.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_dwarf_debug_flags.getValue())).$string());
      Opts.DwarfDebugProducer.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_dwarf_debug_producer.getValue())).$string());
      Opts.DebugCompilationDir.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_fdebug_compilation_dir.getValue())).$string());
      Opts.MainFileName.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_main_file_name.getValue())).$string());
      
      // Frontend Options
      if (Args.hasArg(new OptSpecifier(ID.OPT_INPUT.getValue()))) {
        boolean First = true;
        for (arg_iterator it = Args.filtered_begin(new OptSpecifier(ID.OPT_INPUT.getValue())), 
            ie = Args.filtered_end();
             $noteq_arg_iterator(/*NO_COPY*/it, /*NO_COPY*/ie); it.$preInc() , First = false) {
          /*const*/ Arg /*P*/ A = it.$ArgPtr();
          if (First) {
            Opts.InputFile.$assign(A.getValue());
          } else {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_unknown_argument)), new StringRef(A.getAsString(Args))));
            Success = false;
          }
        }
      }
      $c$.clean(Opts.LLVMArgs.$assignMove($c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_mllvm.getValue())))));
      Opts.OutputPath.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_o.getValue())).$string());
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_filetype.getValue()));
        if ((A != null)) {
          StringRef Name = new StringRef(A.getValue());
          /*uint*/int OutputType = new StringSwitchUInt(/*NO_COPY*/Name).
              Case(/*KEEP_STR*/"asm", FileType.FT_Asm.getValue()).
              Case(/*KEEP_STR*/"null", FileType.FT_Null.getValue()).
              Case(/*KEEP_STR*/"obj", FileType.FT_Obj.getValue()).
              Default(~0/*U*/);
          if (OutputType == ~0/*U*/) {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), new StringRef(A.getAsString(Args))), /*NO_COPY*/Name));
            Success = false;
          } else {
            Opts.OutputType = FileType.valueOf(OutputType);
          }
        }
      }
      Opts.ShowHelp = Args.hasArg(new OptSpecifier(ID.OPT_help.getValue()));
      Opts.ShowVersion = Args.hasArg(new OptSpecifier(ID.OPT_version.getValue()));
      
      // Transliterate Options
      Opts.OutputAsmVariant
         = getLastArgIntValue$R(Args, new OptSpecifier(ID.OPT_output_asm_variant.getValue()), 0, Diags);
      Opts.ShowEncoding = Args.hasArg(new OptSpecifier(ID.OPT_show_encoding.getValue()));
      Opts.ShowInst = Args.hasArg(new OptSpecifier(ID.OPT_show_inst.getValue()));
      
      // Assemble Options
      Opts.RelaxAll = Args.hasArg(new OptSpecifier(ID.OPT_mrelax_all.getValue()));
      Opts.NoExecStack = Args.hasArg(new OptSpecifier(ID.OPT_mno_exec_stack.getValue()));
      Opts.FatalWarnings = Args.hasArg(new OptSpecifier(ID.OPT_massembler_fatal_warnings.getValue()));
      Opts.RelocationModel.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_mrelocation_model.getValue()), new StringRef(/*KEEP_STR*/"pic")).$string());
      Opts.IncrementalLinkerCompatible
         = Args.hasArg(new OptSpecifier(ID.OPT_mincremental_linker_compatible.getValue()));
      
      return Success;
    } finally {
      if (Args != null) { Args.$destroy(); }
      if (OptTbl != null) { OptTbl.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblerInvocation::~AssemblerInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 65,
   old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", old_line = 67,
   FQN="(anonymous namespace)::AssemblerInvocation::~AssemblerInvocation", NM="_ZN12_GLOBAL__N_119AssemblerInvocationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZN12_GLOBAL__N_119AssemblerInvocationD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    RelocationModel.$destroy();
    OutputPath.$destroy();
    LLVMArgs.$destroy();
    InputFile.$destroy();
    MainFileName.$destroy();
    DebugCompilationDir.$destroy();
    DwarfDebugProducer.$destroy();
    DwarfDebugFlags.$destroy();
    IncludePaths.$destroy();
    Features.$destroy();
    CPU.$destroy();
    Triple.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "Triple=" + Triple // NOI18N
              + ", CPU=" + CPU // NOI18N
              + ", Features=" + Features // NOI18N
              + ", IncludePaths=" + IncludePaths // NOI18N
              + ", NoInitialTextSection=" + NoInitialTextSection // NOI18N
              + ", SaveTemporaryLabels=" + SaveTemporaryLabels // NOI18N
              + ", GenDwarfForAssembly=" + GenDwarfForAssembly // NOI18N
              + ", CompressDebugSections=" + CompressDebugSections // NOI18N
              + ", RelaxELFRelocations=" + RelaxELFRelocations // NOI18N
              + ", DwarfVersion=" + DwarfVersion // NOI18N
              + ", DwarfDebugFlags=" + DwarfDebugFlags // NOI18N
              + ", DwarfDebugProducer=" + DwarfDebugProducer // NOI18N
              + ", DebugCompilationDir=" + DebugCompilationDir // NOI18N
              + ", MainFileName=" + MainFileName // NOI18N
              + ", InputFile=" + InputFile // NOI18N
              + ", LLVMArgs=" + LLVMArgs // NOI18N
              + ", OutputPath=" + OutputPath // NOI18N
              + ", OutputType=" + OutputType // NOI18N
              + ", ShowHelp=" + ShowHelp // NOI18N
              + ", ShowVersion=" + ShowVersion // NOI18N
              + ", OutputAsmVariant=" + OutputAsmVariant // NOI18N
              + ", ShowEncoding=" + ShowEncoding // NOI18N
              + ", ShowInst=" + ShowInst // NOI18N
              + ", RelaxAll=" + RelaxAll // NOI18N
              + ", NoExecStack=" + NoExecStack // NOI18N
              + ", FatalWarnings=" + FatalWarnings // NOI18N
              + ", IncrementalLinkerCompatible=" + IncrementalLinkerCompatible // NOI18N
              + ", RelocationModel=" + RelocationModel; // NOI18N
  }
}
