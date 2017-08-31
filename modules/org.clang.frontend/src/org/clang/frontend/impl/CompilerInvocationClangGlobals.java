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

import org.llvm.support.sys.Process;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.llvm.option.*;
import static org.clang.frontend.impl.CompilerInvocationStatics.*;
import org.clang.frontend.*;
import org.clang.driver.options.ID;
import static org.clang.frontend.impl.FrontendClangStatics.*;
import org.llvm.adt.ADTFunctionPointers.DiagHandlerTy;

//<editor-fold defaultstate="collapsed" desc="static type CompilerInvocationClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang11BuryPointerEPKv;_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiPNS_17DiagnosticsEngineE;_ZN5clang19ParseDiagnosticArgsERNS_17DiagnosticOptionsERN4llvm3opt7ArgListEPNS_17DiagnosticsEngineEb;_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyPNS_17DiagnosticsEngineE;_ZN5clang31createVFSFromCompilerInvocationERKNS_18CompilerInvocationERNS_17DiagnosticsEngineE; -static-type=CompilerInvocationClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class CompilerInvocationClangGlobals {


/// \brief Fill out Opts based on the options given in Args.
///
/// Args must have been created from the OptTable returned by
/// createCC1OptTable().
///
/// When errors are encountered, return false and, if Diags is non-null,
/// report the error(s).
//<editor-fold defaultstate="collapsed" desc="clang::ParseDiagnosticArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 918,
 FQN="clang::ParseDiagnosticArgs", NM="_ZN5clang19ParseDiagnosticArgsERNS_17DiagnosticOptionsERN4llvm3opt7ArgListEPNS_17DiagnosticsEngineEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19ParseDiagnosticArgsERNS_17DiagnosticOptionsERN4llvm3opt7ArgListEPNS_17DiagnosticsEngineEb")
//</editor-fold>
public static boolean ParseDiagnosticArgs(DiagnosticOptions /*&*/ Opts, ArgList /*&*/ Args) {
  return ParseDiagnosticArgs(Opts, Args, 
                   (DiagnosticsEngine /*P*/ )null, 
                   true);
}
public static boolean ParseDiagnosticArgs(DiagnosticOptions /*&*/ Opts, ArgList /*&*/ Args, 
                   DiagnosticsEngine /*P*/ Diags/*= null*/) {
  return ParseDiagnosticArgs(Opts, Args, 
                   Diags, 
                   true);
}
public static boolean ParseDiagnosticArgs(DiagnosticOptions /*&*/ Opts, ArgList /*&*/ Args, 
                   DiagnosticsEngine /*P*/ Diags/*= null*/, 
                   boolean DefaultDiagColor/*= true*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //JAVA: using namespace options;
    boolean Success = true;
    
    Opts.DiagnosticLogFile.$assignMove(Args.getLastArgValue(new OptSpecifier(ID.OPT_diagnostic_log_file.getValue())).$string());
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_diagnostic_serialized_file.getValue()), new OptSpecifier(ID.OPT__serialize_diags.getValue()));
      if ((A != null)) {
        Opts.DiagnosticSerializationFile.$assign_T$C$P(A.getValue());
      }
    }
    Opts.IgnoreWarnings = Args.hasArg(new OptSpecifier(ID.OPT_w.getValue()));
    Opts.NoRewriteMacros = Args.hasArg(new OptSpecifier(ID.OPT_Wno_rewrite_macros.getValue()));
    Opts.Pedantic = Args.hasArg(new OptSpecifier(ID.OPT_pedantic.getValue()));
    Opts.PedanticErrors = Args.hasArg(new OptSpecifier(ID.OPT_pedantic_errors.getValue()));
    Opts.ShowCarets = !Args.hasArg(new OptSpecifier(ID.OPT_fno_caret_diagnostics.getValue()));
    Opts.ShowColors = parseShowColorsArgs(Args, DefaultDiagColor);
    Opts.ShowColumn = Args.hasFlag(new OptSpecifier(ID.OPT_fshow_column.getValue()), 
        new OptSpecifier(ID.OPT_fno_show_column.getValue()), 
        /*Default=*/ true);
    Opts.ShowFixits = !Args.hasArg(new OptSpecifier(ID.OPT_fno_diagnostics_fixit_info.getValue()));
    Opts.ShowLocation = !Args.hasArg(new OptSpecifier(ID.OPT_fno_show_source_location.getValue()));
    Opts.ShowOptionNames = Args.hasArg(new OptSpecifier(ID.OPT_fdiagnostics_show_option.getValue()));
    
    Process.UseANSIEscapeCodes(Args.hasArg(new OptSpecifier(ID.OPT_fansi_escape_codes.getValue())));
    
    // Default behavior is to not to show note include stacks.
    Opts.ShowNoteIncludeStack = false;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(ID.OPT_fdiagnostics_show_note_include_stack.getValue()), 
          new OptSpecifier(ID.OPT_fno_diagnostics_show_note_include_stack.getValue()));
      if ((A != null)) {
        if (A.getOption().matches(new OptSpecifier(ID.OPT_fdiagnostics_show_note_include_stack.getValue()))) {
          Opts.ShowNoteIncludeStack = true;
        }
      }
    }
    
    StringRef ShowOverloads = Args.getLastArgValue(new OptSpecifier(ID.OPT_fshow_overloads_EQ.getValue()), new StringRef(/*KEEP_STR*/"all"));
    if ($eq_StringRef(/*NO_COPY*/ShowOverloads, /*STRINGREF_STR*/"best")) {
      Opts.setShowOverloads(OverloadsShown.Ovl_Best);
    } else if ($eq_StringRef(/*NO_COPY*/ShowOverloads, /*STRINGREF_STR*/"all")) {
      Opts.setShowOverloads(OverloadsShown.Ovl_All);
    } else {
      Success = false;
      if ((Diags != null)) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                new StringRef(Args.getLastArg(new OptSpecifier(ID.OPT_fshow_overloads_EQ.getValue())).getAsString(Args))), 
            /*NO_COPY*/ShowOverloads));
      }
    }
    
    StringRef ShowCategory = Args.getLastArgValue(new OptSpecifier(ID.OPT_fdiagnostics_show_category.getValue()), new StringRef(/*KEEP_STR*/"none"));
    if ($eq_StringRef(/*NO_COPY*/ShowCategory, /*STRINGREF_STR*/"none")) {
      Opts.ShowCategories = 0;
    } else if ($eq_StringRef(/*NO_COPY*/ShowCategory, /*STRINGREF_STR*/"id")) {
      Opts.ShowCategories = 1;
    } else if ($eq_StringRef(/*NO_COPY*/ShowCategory, /*STRINGREF_STR*/"name")) {
      Opts.ShowCategories = 2;
    } else {
      Success = false;
      if ((Diags != null)) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                new StringRef(Args.getLastArg(new OptSpecifier(ID.OPT_fdiagnostics_show_category.getValue())).getAsString(Args))), 
            /*NO_COPY*/ShowCategory));
      }
    }
    
    StringRef Format = Args.getLastArgValue(new OptSpecifier(ID.OPT_fdiagnostics_format.getValue()), new StringRef(/*KEEP_STR*/"clang"));
    if ($eq_StringRef(/*NO_COPY*/Format, /*STRINGREF_STR*/"clang")) {
      Opts.setFormat(DiagnosticOptions.TextDiagnosticFormat.Clang);
    } else if ($eq_StringRef(/*NO_COPY*/Format, /*STRINGREF_STR*/"msvc")) {
      Opts.setFormat(DiagnosticOptions.TextDiagnosticFormat.MSVC);
    } else if ($eq_StringRef(/*NO_COPY*/Format, /*STRINGREF_STR*/"msvc-fallback")) {
      Opts.setFormat(DiagnosticOptions.TextDiagnosticFormat.MSVC);
      Opts.CLFallbackMode = true;
    } else if ($eq_StringRef(/*NO_COPY*/Format, /*STRINGREF_STR*/"vi")) {
      Opts.setFormat(DiagnosticOptions.TextDiagnosticFormat.Vi);
    } else {
      Success = false;
      if ((Diags != null)) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_drv_invalid_value)), 
                new StringRef(Args.getLastArg(new OptSpecifier(ID.OPT_fdiagnostics_format.getValue())).getAsString(Args))), 
            /*NO_COPY*/Format));
      }
    }
    
    Opts.ShowSourceRanges = Args.hasArg(new OptSpecifier(ID.OPT_fdiagnostics_print_source_range_info.getValue()));
    Opts.ShowParseableFixits = Args.hasArg(new OptSpecifier(ID.OPT_fdiagnostics_parseable_fixits.getValue()));
    Opts.ShowPresumedLoc = !Args.hasArg(new OptSpecifier(ID.OPT_fno_diagnostics_use_presumed_location.getValue()));
    Opts.VerifyDiagnostics = Args.hasArg(new OptSpecifier(ID.OPT_verify.getValue()));
    /*DiagnosticLevelMask*//*uint*/uint$ref DiagMask = create_uint$ref(DiagnosticLevelMask.None);
    $c$.clean(Success &= parseDiagnosticLevelMask(new StringRef(/*KEEP_STR*/"-verify-ignore-unexpected="), 
        $c$.track(Args.getAllArgValues(new OptSpecifier(ID.OPT_verify_ignore_unexpected_EQ.getValue()))), 
        Diags, DiagMask));
    if (Args.hasArg(new OptSpecifier(ID.OPT_verify_ignore_unexpected.getValue()))) {
      DiagMask.$set(DiagnosticLevelMask.All);
    }
    Opts.setVerifyIgnoreUnexpected(DiagMask.$deref());
    Opts.ElideType = !Args.hasArg(new OptSpecifier(ID.OPT_fno_elide_type.getValue()));
    Opts.ShowTemplateTree = Args.hasArg(new OptSpecifier(ID.OPT_fdiagnostics_show_template_tree.getValue()));
    Opts.ErrorLimit = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_ferror_limit.getValue()), 0, Diags);
    Opts.MacroBacktraceLimit
       = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_fmacro_backtrace_limit.getValue()), 
        DiagnosticOptions.Unnamed_enum1.DefaultMacroBacktraceLimit.getValue(), Diags);
    Opts.TemplateBacktraceLimit = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_ftemplate_backtrace_limit.getValue()), 
        DiagnosticOptions.Unnamed_enum1.DefaultTemplateBacktraceLimit.getValue(), Diags);
    Opts.ConstexprBacktraceLimit = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_fconstexpr_backtrace_limit.getValue()), 
        DiagnosticOptions.Unnamed_enum1.DefaultConstexprBacktraceLimit.getValue(), Diags);
    Opts.SpellCheckingLimit = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_fspell_checking_limit.getValue()), 
        DiagnosticOptions.Unnamed_enum1.DefaultSpellCheckingLimit.getValue(), Diags);
    Opts.TabStop = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_ftabstop.getValue()), 
        DiagnosticOptions.Unnamed_enum1.DefaultTabStop.getValue(), Diags);
    if (Opts.TabStop == 0 || $greater_uint(Opts.TabStop, DiagnosticOptions.Unnamed_enum1.MaxTabStop.getValue())) {
      Opts.TabStop = DiagnosticOptions.Unnamed_enum1.DefaultTabStop.getValue();
      if ((Diags != null)) {
        $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($c$.track(Diags.Report(diag.warn_ignoring_ftabstop_value)), 
                Opts.TabStop), DiagnosticOptions.Unnamed_enum1.DefaultTabStop.getValue()));
      }
    }
    Opts.MessageLength = getLastArgIntValue$P(Args, new OptSpecifier(ID.OPT_fmessage_length.getValue()), 0, Diags);
    addDiagnosticArgs(Args, new OptSpecifier(ID.OPT_W_Group.getValue()), new OptSpecifier(ID.OPT_W_value_Group.getValue()), Opts.Warnings);
    addDiagnosticArgs(Args, new OptSpecifier(ID.OPT_R_Group.getValue()), new OptSpecifier(ID.OPT_R_value_Group.getValue()), Opts.Remarks);
    
    return Success;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::createVFSFromCompilerInvocation">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2541,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2295,
 FQN="clang::createVFSFromCompilerInvocation", NM="_ZN5clang31createVFSFromCompilerInvocationERKNS_18CompilerInvocationERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang31createVFSFromCompilerInvocationERKNS_18CompilerInvocationERNS_17DiagnosticsEngineE")
//</editor-fold>
public static IntrusiveRefCntPtr<FileSystem> createVFSFromCompilerInvocation(/*const*/ CompilerInvocation /*&*/ CI, 
                               DiagnosticsEngine /*&*/ Diags) {
  IntrusiveRefCntPtr<OverlayFileSystem> Overlay = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (CI.getHeaderSearchOpts$Const().VFSOverlayFiles.empty()) {
      return VfsGlobals.getRealFileSystem();
    }
    
    Overlay/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(VfsGlobals.getRealFileSystem()))));
    // earlier vfs files are on the bottom
    for (/*const*/std.string/*&*/ File : CI.getHeaderSearchOpts$Const().VFSOverlayFiles) {
      ErrorOr<std.unique_ptr<MemoryBuffer> > Buffer = null;
      IntrusiveRefCntPtr<FileSystem> FS = null;
      try {
        Buffer = MemoryBuffer.getFile(new Twine(File));
        if (!Buffer.$bool()) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_missing_vfs_overlay_file)), new StringRef(File)));
          return new IntrusiveRefCntPtr<FileSystem>();
        }
        
        FS = $c$.clean(VfsGlobals.getVFSFromYAML($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer.get()))), /*DiagHandler*/ (DiagHandlerTy)null, new StringRef(File)));
        if (!(FS.get() != null)) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_invalid_vfs_overlay)), new StringRef(File)));
          return new IntrusiveRefCntPtr<FileSystem>();
        }
        Overlay.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(FS))); $c$.clean();
      } finally {
        if (FS != null) { FS.$destroy(); }
        if (Buffer != null) { Buffer.$destroy(); }
      }
    }
    return new IntrusiveRefCntPtr<FileSystem>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, Overlay);
  } finally {
    if (Overlay != null) { Overlay.$destroy(); }
    $c$.$destroy();
  }
}


/// Return the value of the last argument as an integer, or a default. If Diags
/// is non-null, emits an error if the argument is given, but non-integral.

// Declared in clang/Frontend/Utils.h.
//<editor-fold defaultstate="collapsed" desc="clang::getLastArgIntValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2515,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2269,
 FQN="clang::getLastArgIntValue", NM="_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiPNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiPNS_17DiagnosticsEngineE")
//</editor-fold>
public static int getLastArgIntValue$P(/*const*/ ArgList /*&*/ Args, OptSpecifier Id, int Default) {
  return getLastArgIntValue$P(Args, Id, Default, 
                    (DiagnosticsEngine /*P*/ )null);
}
public static int getLastArgIntValue$P(/*const*/ ArgList /*&*/ Args, OptSpecifier Id, int Default, 
                    DiagnosticsEngine /*P*/ Diags/*= null*/) {
  return getLastArgIntValueImpl_32(Args, new OptSpecifier(Id), Default, Diags);
}

//<editor-fold defaultstate="collapsed" desc="clang::getLastArgUInt64Value">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2520,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2274,
 FQN="clang::getLastArgUInt64Value", NM="_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyPNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyPNS_17DiagnosticsEngineE")
//</editor-fold>
public static long/*uint64_t*/ getLastArgUInt64Value$P(/*const*/ ArgList /*&*/ Args, OptSpecifier Id, 
                       long/*uint64_t*/ Default) {
  return getLastArgUInt64Value$P(Args, Id, 
                       Default, 
                       (DiagnosticsEngine /*P*/ )null);
}
public static long/*uint64_t*/ getLastArgUInt64Value$P(/*const*/ ArgList /*&*/ Args, OptSpecifier Id, 
                       long/*uint64_t*/ Default, 
                       DiagnosticsEngine /*P*/ Diags/*= null*/) {
  return getLastArgIntValueImpl_64(Args, new OptSpecifier(Id), Default, Diags);
}


// When Clang->getFrontendOpts().DisableFree is set we don't delete some of the
// global objects, but we don't want LeakDetectors to complain, so we bury them
// in a globally visible array.
//<editor-fold defaultstate="collapsed" desc="clang::BuryPointer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*added sync*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2526,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2280,
 FQN="clang::BuryPointer", NM="_ZN5clang11BuryPointerEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang11BuryPointerEPKv")
//</editor-fold>
public static void BuryPointer(/*const*/Object/*void P*/ Ptr) {
  // This function may be called only a small fixed amount of times per each
  // invocation, otherwise we do actually have a leak which we want to report.
  // If this function is called more than kGraveYardMaxSize times, the pointers
  // will not be properly buried and a leak detector will report a leak, which
  // is what we want in such case.
  final/*static*/ /*const*//*size_t*/int kGraveYardMaxSize = BuryPointer$$.kGraveYardMaxSize;
  final/*static*/ /*const*/Object/*void P*/ GraveYard[/*16*/]/* __attribute__((unused))*/ = BuryPointer$$.GraveYard;
  final/*static*/ std.atomicUInt GraveYardSize = BuryPointer$$.GraveYardSize;
  synchronized (GraveYard) {
    /*uint*/int Idx = GraveYardSize.$postInc(0);
    if ($greatereq_uint(Idx, kGraveYardMaxSize)) {
      return;
    }
    GraveYard[Idx] = Ptr;
  }
}
private static final class BuryPointer$$ {
  static final/*static*/ /*const*//*size_t*/int kGraveYardMaxSize = 16;
  static final/*static*/ /*const*/Object/*void P*/ GraveYard[/*16*/] = new Object[kGraveYardMaxSize];/* __attribute__((unused))*/;
  static final/*static*/ std.atomicUInt GraveYardSize/*J*/= new std.atomicUInt();
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static void clearBuriedPointers() {
  // method introduced to allow use of clank for multiple TUs without memory leaks
  final/*static*/ /*const*/Object/*void P*/ GraveYard[/*16*/]/* __attribute__((unused))*/ = BuryPointer$$.GraveYard;
  final/*static*/ std.atomicUInt GraveYardSize = BuryPointer$$.GraveYardSize;  
  synchronized (GraveYard) {
    GraveYardSize.set(0);
    for (int i = 0; i < GraveYard.length; i++) {
      GraveYard[i] = null;
    }
  }
}

} // END OF class CompilerInvocationClangGlobals
