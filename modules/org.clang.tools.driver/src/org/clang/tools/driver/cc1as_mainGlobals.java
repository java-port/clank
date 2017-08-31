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
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.cl.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.frontend.*;
import org.llvm.mc.*;
import org.llvm.mc.mcparser.*;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.sys;
import org.llvm.support.target.TargetRegistry;

//<editor-fold defaultstate="collapsed" desc="static type cc1as_mainGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_Z10cc1as_mainN4llvm8ArrayRefIPKcEES2_Pv;_ZL15getOutputStreamRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineEb;_ZL16ExecuteAssemblerRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineE;_ZL16LLVMErrorHandlerPvRKSsb; -static-type=cc1as_mainGlobals -package=org.clang.tools.driver")
//</editor-fold>
public final class cc1as_mainGlobals {

//<editor-fold defaultstate="collapsed" desc="getOutputStream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 259,
 FQN="getOutputStream", NM="_ZL15getOutputStreamRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZL15getOutputStreamRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineEb")
//</editor-fold>
public static std.unique_ptr<raw_fd_ostream> getOutputStream(AssemblerInvocation /*&*/ Opts, DiagnosticsEngine /*&*/ Diags, 
               boolean Binary) {
  unique_ptr<raw_fd_ostream> Out = null;
  try {
    if (Opts.OutputPath.empty()) {
      Opts.OutputPath.$assign(/*KEEP_STR*/"-");
    }
    
    // Make sure that the Out file gets unlinked from the disk if we get a
    // SIGINT.
    if ($noteq_string$C_T(Opts.OutputPath, /*KEEP_STR*/"-")) {
      sys.RemoveFileOnSignal(new StringRef(Opts.OutputPath));
    }
    
    std.error_code EC/*J*/= new std.error_code();
    Out = llvm.make_unique(new raw_fd_ostream(Opts.OutputPath, EC, (Binary ? fs.OpenFlags.F_None : fs.OpenFlags.F_Text)));
    if (EC.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_unable_to_open_output)), new StringRef(Opts.OutputPath)), 
            new StringRef(EC.message())));
        return new std.unique_ptr<raw_fd_ostream>(JD$NullPtr.INSTANCE, null);
      } finally {
        $c$.$destroy();
      }
    }
    
    return new std.unique_ptr<raw_fd_ostream>(JD$Move.INSTANCE, Out);
  } finally {
    if (Out != null) { Out.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="ExecuteAssembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 282,
 FQN="ExecuteAssembler", NM="_ZL16ExecuteAssemblerRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZL16ExecuteAssemblerRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineE")
//</editor-fold>
public static boolean ExecuteAssembler(AssemblerInvocation /*&*/ Opts, 
                DiagnosticsEngine /*&*/ Diags) {
  ErrorOr<std.unique_ptr<MemoryBuffer> > Buffer = null;
  SourceMgr SrcMgr = null;
  std.unique_ptr<MCRegisterInfo> MRI = null;
  std.unique_ptr<MCAsmInfo> MAI = null;
  std.unique_ptr<raw_fd_ostream> FDOS = null;
  std.unique_ptr<MCObjectFileInfo> MOFI = null;
  MCContext Ctx = null;
  std.unique_ptr<MCStreamer> Str = null;
  std.unique_ptr<MCInstrInfo> MCII = null;
  std.unique_ptr<MCSubtargetInfo> STI = null;
  std.unique_ptr<buffer_ostream> BOS = null;
  std.unique_ptr<MCAsmParser> Parser = null;
  MCTargetOptions Options = null;
  std.unique_ptr<MCTargetAsmParser> TAP = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Get the target specific parser.
    std.string Error/*J*/= new std.string();
    /*const*/ Target /*P*/ TheTarget = TargetRegistry.lookupTarget(Opts.Triple, Error);
    if (!(TheTarget != null)) {
      return $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_target_unknown_triple)), new StringRef(Opts.Triple)).$bool());
    }
    
    Buffer = MemoryBuffer.getFileOrSTDIN(new Twine(Opts.InputFile));
    {
      
      std.error_code EC = Buffer.getError();
      if (EC.$bool()) {
        Error.$assignMove(EC.message());
        return $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_error_reading)), new StringRef(Opts.InputFile)).$bool());
      }
    }
    
    SrcMgr/*J*/= new SourceMgr();
    
    // Tell SrcMgr about this buffer, which is what the parser will pick up.
    $c$.clean(SrcMgr.AddNewSourceBuffer($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer.$star()))), new SMLoc()));
    
    // Record the location of the include directories so that the lexer can find
    // it later.
    SrcMgr.setIncludeDirs(Opts.IncludePaths);
    
    MRI/*J*/= new std.unique_ptr<MCRegisterInfo>(TheTarget.createMCRegInfo(new StringRef(Opts.Triple)));
    assert (MRI.$bool()) : "Unable to create target register info!";
    
    MAI/*J*/= new std.unique_ptr<MCAsmInfo>(TheTarget.createMCAsmInfo(MRI.$star(), new StringRef(Opts.Triple)));
    assert (MAI.$bool()) : "Unable to create target asm info!";
    
    // Ensure MCAsmInfo initialization occurs before any use, otherwise sections
    // may be created with a combination of default and explicit settings.
    if (Opts.CompressDebugSections) {
      MAI.$arrow().setCompressDebugSections(DebugCompressionType.DCT_ZlibGnu);
    }
    
    MAI.$arrow().setRelaxELFRelocations(Opts.RelaxELFRelocations);
    
    boolean IsBinary = Opts.OutputType == AssemblerInvocation.FileType.FT_Obj;
    FDOS = getOutputStream(Opts, Diags, IsBinary);
    if (!FDOS.$bool()) {
      return true;
    }
    
    // FIXME: This is not pretty. MCContext has a ptr to MCObjectFileInfo and
    // MCObjectFileInfo needs a MCContext reference in order to initialize itself.
    MOFI/*J*/= new std.unique_ptr<MCObjectFileInfo>(new MCObjectFileInfo());
    
    Ctx/*J*/= new MCContext(MAI.get(), MRI.get(), MOFI.get(), /*AddrOf*/SrcMgr);
    
    boolean PIC = false;
    if ($eq_string$C_T(Opts.RelocationModel, /*KEEP_STR*/"static")) {
      PIC = false;
    } else if ($eq_string$C_T(Opts.RelocationModel, /*KEEP_STR*/"pic")) {
      PIC = true;
    } else {
      assert ($eq_string$C_T(Opts.RelocationModel, /*KEEP_STR*/"dynamic-no-pic")) : "Invalid PIC model!";
      PIC = false;
    }
    
    MOFI.$arrow().InitMCObjectFileInfo(new Triple(new Twine(Opts.Triple)), PIC, CodeModel.Model.Default, Ctx);
    if (Opts.SaveTemporaryLabels) {
      Ctx.setAllowTemporaryLabels(false);
    }
    if (Opts.GenDwarfForAssembly) {
      Ctx.setGenDwarfForAssembly(true);
    }
    if (!Opts.DwarfDebugFlags.empty()) {
      Ctx.setDwarfDebugFlags(new StringRef(Opts.DwarfDebugFlags));
    }
    if (!Opts.DwarfDebugProducer.empty()) {
      Ctx.setDwarfDebugProducer(new StringRef(Opts.DwarfDebugProducer));
    }
    if (!Opts.DebugCompilationDir.empty()) {
      Ctx.setCompilationDir(new StringRef(Opts.DebugCompilationDir));
    }
    if (!Opts.MainFileName.empty()) {
      Ctx.setMainFileName(new StringRef(Opts.MainFileName));
    }
    Ctx.setDwarfVersion($uint2ushort(Opts.DwarfVersion));
    
    // Build up the feature string from the target feature list.
    std.string FS/*J*/= new std.string();
    if (!Opts.Features.empty()) {
      FS.$assign(Opts.Features.$at(0));
      for (/*uint*/int i = 1, e = Opts.Features.size(); i != e; ++i)  {
        FS.$addassign($add_T_string$C(/*KEEP_STR*/",", Opts.Features.$at(i)));
      }
    }
    
    Str/*J*/= new std.unique_ptr<MCStreamer>();
    
    MCII/*J*/= new std.unique_ptr<MCInstrInfo>(TheTarget.createMCInstrInfo());
    STI/*J*/= new std.unique_ptr<MCSubtargetInfo>(TheTarget.createMCSubtargetInfo(new StringRef(Opts.Triple), new StringRef(Opts.CPU), new StringRef(FS)));
    
    raw_pwrite_stream /*P*/ Out = FDOS.get();
    BOS/*J*/= new std.unique_ptr<buffer_ostream>();
    
    // FIXME: There is a bit of code duplication with addPassesToEmitFile.
    if (Opts.OutputType == AssemblerInvocation.FileType.FT_Asm) {
      unique_ptr<formatted_raw_ostream> FOut = null;
      try {
        MCInstPrinter /*P*/ IP = TheTarget.createMCInstPrinter(new Triple(new Twine(Opts.Triple)), Opts.OutputAsmVariant, MAI.$star(), MCII.$star(), MRI.$star());
        MCCodeEmitter /*P*/ CE = null;
        MCAsmBackend /*P*/ MAB = null;
        if (Opts.ShowEncoding) {
          CE = TheTarget.createMCCodeEmitter(MCII.$star(), MRI.$star(), Ctx);
          MAB = TheTarget.createMCAsmBackend(MRI.$star(), new StringRef(Opts.Triple), new StringRef(Opts.CPU));
        }
        FOut = llvm.make_unique(new formatted_raw_ostream(/*Deref*/Out));
        Str.reset(TheTarget.createAsmStreamer(Ctx, $c$.track(new std.unique_ptr<formatted_raw_ostream>(JD$Move.INSTANCE, std.move(FOut))), /*asmverbose*/ true, 
                /*useDwarfDirectory*/ true, IP, CE, MAB, Opts.ShowInst)); $c$.clean();
      } finally {
        if (FOut != null) { FOut.$destroy(); }
      }
    } else if (Opts.OutputType == AssemblerInvocation.FileType.FT_Null) {
      Str.reset(createNullStreamer(Ctx));
    } else {
      assert (Opts.OutputType == AssemblerInvocation.FileType.FT_Obj) : "Invalid file type!";
      if (!FDOS.$arrow().supportsSeeking()) {
        $c$.clean(BOS.$assignMove($c$.track(llvm.make_unique(new buffer_ostream(FDOS.$star())))));
        Out = BOS.get();
      }
      
      MCCodeEmitter /*P*/ CE = TheTarget.createMCCodeEmitter(MCII.$star(), MRI.$star(), Ctx);
      MCAsmBackend /*P*/ MAB = TheTarget.createMCAsmBackend(MRI.$star(), new StringRef(Opts.Triple), 
          new StringRef(Opts.CPU));
      Triple T/*J*/= new Triple(new Twine(Opts.Triple));
      Str.reset(TheTarget.createMCObjectStreamer(T, Ctx, /*Deref*/MAB, /*Deref*/Out, CE, STI.$star(), Opts.RelaxAll, 
              Opts.IncrementalLinkerCompatible, 
              /*DWARFMustBeAtTheEnd*/ true));
      Str.get().InitSections(Opts.NoExecStack);
    }
    
    boolean Failed = false;
    
    Parser/*J*/= new std.unique_ptr<MCAsmParser>(createMCAsmParser(SrcMgr, Ctx, /*Deref*/Str.get(), MAI.$star()));
    
    // FIXME: init MCTargetOptions from sanitizer flags here.
    Options/*J*/= new MCTargetOptions();
    TAP/*J*/= new std.unique_ptr<MCTargetAsmParser>(TheTarget.createMCAsmParser(STI.$star(), Parser.$star(), MCII.$star(), Options));
    if (!TAP.$bool()) {
      $c$.clean(Failed = $out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_target_unknown_triple)), new StringRef(Opts.Triple)).$bool());
    }
    if (!Failed) {
      Parser.$arrow().setTargetParser(/*Deref*/TAP.get());
      Failed = Parser.$arrow().Run(Opts.NoInitialTextSection);
    }
    
    // Close Streamer first.
    // It might have a reference to the output stream.
    Str.reset();
    // Close the output stream early.
    BOS.reset();
    FDOS.reset();
    
    // Delete output file if there were errors.
    if (Failed && $noteq_string$C_T(Opts.OutputPath, /*KEEP_STR*/"-")) {
      fs.remove(new Twine(Opts.OutputPath));
    }
    
    return Failed;
  } finally {
    if (TAP != null) { TAP.$destroy(); }
    if (Options != null) { Options.$destroy(); }
    if (Parser != null) { Parser.$destroy(); }
    if (BOS != null) { BOS.$destroy(); }
    if (STI != null) { STI.$destroy(); }
    if (MCII != null) { MCII.$destroy(); }
    if (Str != null) { Str.$destroy(); }
    if (Ctx != null) { Ctx.$destroy(); }
    if (MOFI != null) { MOFI.$destroy(); }
    if (FDOS != null) { FDOS.$destroy(); }
    if (MAI != null) { MAI.$destroy(); }
    if (MRI != null) { MRI.$destroy(); }
    if (SrcMgr != null) { SrcMgr.$destroy(); }
    if (Buffer != null) { Buffer.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="LLVMErrorHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 440,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp", old_line = 45,
 FQN="LLVMErrorHandler", NM="_ZL16LLVMErrorHandlerPvRKSsb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_ZL16LLVMErrorHandlerPvRKSsb")
//</editor-fold>
public static void LLVMErrorHandler(Object/*void P*/ UserData, /*const*/std.string/*&*/ Message, 
                boolean GenCrashDiag) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DiagnosticsEngine /*&*/ Diags = /*Deref*/((/*static_cast*/DiagnosticsEngine /*P*/ )(UserData));
    
    $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_error_backend)), new StringRef(Message)));
    
    // We cannot recover from llvm errors.
    exit(1);
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="cc1as_main">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp", line = 450,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", old_line = 201,
 FQN="cc1as_main", NM="_Z10cc1as_mainN4llvm8ArrayRefIPKcEES2_Pv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp -nm=_Z10cc1as_mainN4llvm8ArrayRefIPKcEES2_Pv")
//</editor-fold>
public static int cc1as_main(ArrayRef</*const*/char$ptr/*char P*/ > Argv, /*const*/char$ptr/*char P*/ Argv0, Object/*void P*/ MainAddr) {
  IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts = null;
  IntrusiveRefCntPtr<DiagnosticIDs> DiagID = null;
  DiagnosticsEngine Diags = null;
  ScopedFatalErrorHandler FatalErrorHandler = null;
  AssemblerInvocation Asm = null;
  try {
    // Initialize targets and assembly printers/parsers.
    InitializeAllTargetInfos();
    InitializeAllTargetMCs();
    InitializeAllAsmParsers();
    
    // Construct our diagnostic client.
    DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions());
    TextDiagnosticPrinter /*P*/ DiagClient = new TextDiagnosticPrinter(errs(), /*AddrOf*/DiagOpts.$star());
    DiagClient.setPrefix(new std.string(/*KEEP_STR*/"clang -cc1as"));
    DiagID/*J*/= new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
    Diags/*J*/= new DiagnosticsEngine(DiagID, /*AddrOf*/DiagOpts.$star(), DiagClient);
    
    // Set an error handler, so that any LLVM backend diagnostics go through our
    // error handler.
    FatalErrorHandler/*J*/= new ScopedFatalErrorHandler((user_data, reason, gen_crash_diag)->LLVMErrorHandler(user_data, reason, gen_crash_diag), ((/*static_cast*/Object/*void P*/ )(/*AddrOf*/Diags)));
    
    // Parse the arguments.
    Asm/*J*/= new AssemblerInvocation();
    if (!AssemblerInvocation.CreateFromArgs(Asm, new ArrayRef</*const*/char$ptr/*char P*/ >(Argv), Diags)) {
      return 1;
    }
    if (Asm.ShowHelp) {
      std.unique_ptr<OptTable> Opts = null;
      try {
        Opts/*J*/= new std.unique_ptr<OptTable>(DriverGlobals.createDriverOptTable());
        Opts.$arrow().PrintHelp(llvm.outs(), $("clang -cc1as"), $("Clang Integrated Assembler"), 
            /*Include=*/ options.ClangFlags.CC1AsOption, /*Exclude=*/ 0);
        return 0;
      } finally {
        if (Opts != null) { Opts.$destroy(); }
      }
    }
    
    // Honor -version.
    //
    // FIXME: Use a better -version message?
    if (Asm.ShowVersion) {
      ClGlobals.PrintVersionMessage();
      return 0;
    }
    
    // Honor -mllvm.
    //
    // FIXME: Remove this, one day.
    if (!Asm.LLVMArgs.empty()) {
      /*uint*/int NumArgs = Asm.LLVMArgs.size();
      /*const*/type$ptr<char$ptr>/*char PP*/ Args = create_type$ptr(new /*const*/char$ptr/*char P*/ [(int)(NumArgs + 2)]);
      Args.$set(0, $("clang (LLVM option parsing)"));
      for (/*uint*/int i = 0; i != NumArgs; ++i)  {
        Args.$set(i + 1, Asm.LLVMArgs.$at(i).c_str());
      }
      Args.$set(NumArgs + 1, null);
      ClGlobals.ParseCommandLineOptions(NumArgs + 1, Args);
    }
    
    // Execute the invocation, unless there were parsing errors.
    boolean Failed = Diags.hasErrorOccurred() || ExecuteAssembler(Asm, Diags);
    
    // If any timers were active but haven't been destroyed yet, print their
    // results now.
    TimerGroup.printAll(errs());
    
    return ((!!Failed) ? 1 : 0);
  } finally {
    if (Asm != null) { Asm.$destroy(); }
    if (FatalErrorHandler != null) { FatalErrorHandler.$destroy(); }
    if (Diags != null) { Diags.$destroy(); }
    if (DiagID != null) { DiagID.$destroy(); }
    if (DiagOpts != null) { DiagOpts.$destroy(); }
  }
}

} // END OF class cc1as_mainGlobals
