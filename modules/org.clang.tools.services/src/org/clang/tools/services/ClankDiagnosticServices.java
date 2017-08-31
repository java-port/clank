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

package org.clang.tools.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clang.basic.DiagnosticIDs;
import org.clang.basic.DiagnosticOptions;
import org.clang.basic.DiagnosticsEngine;
import org.clang.driver.Compilation;
import org.clang.driver.Driver;
import org.clang.driver.ToolChain;
import org.clang.frontend.CompilerInstance;
import org.clang.frontend.CompilerInvocation;
import org.clang.frontend.PCHContainerOperations;
import static org.clang.frontendtool.FrontendtoolClangGlobals.ExecuteCompilerInvocation;
import org.clang.tools.driver.cc1_mainGlobals;
import static org.clang.tools.driver.driverGlobals.GetExecutablePathPtr;
import org.clang.tools.services.impl.ClankCheckerAccessor;
import org.clang.tools.services.impl.ClankCompilerInvokationInitializer;
import org.clang.tools.services.impl.ClankDiagnosticsConsumerImpl;
import org.clank.java.std;
import static org.clank.java.std.$eq_string$C_T;
import static org.clank.java.std.strcmp;
import org.clank.java.std_ptr;
import org.clank.support.CollectionUtils;
import org.clank.support.JavaCleaner;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.Native.$noteq_ptr;
import static org.clank.support.Native.$tryClone;
import org.clank.support.NativeCallback;
import org.clank.support.NativePointer;
import static org.clank.support.NativePointer.create_type$ptr;
import org.clank.support.NativeTrace;
import static org.clank.support.Unsigned.$greater_uint;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.type$ptr;
import static org.clank.support.literal_constants.$$LF;
import org.clank.support.void$ptr;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.adt.aliases.SmallVector;
import org.llvm.cl.ClGlobals;
import org.llvm.support.BumpPtrAllocatorImpl;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.PrettyStackTraceProgram;
import org.llvm.support.SpecificBumpPtrAllocator;
import org.llvm.support.StringSaver;
import org.llvm.support.TimerGroup;
import org.llvm.support.llvm;
import org.llvm.support.sys.sys;

/**
 * This service is created to provide diagnostics
 *
 * @author masha
 */
public final class ClankDiagnosticServices {
  public static boolean DEBUG_DIAGNOSTIC_SERVICES =  Boolean.valueOf(System.getProperty("org.clang.tools.services.debug", "false")); // NOI18N
  //private final NativeCallback.Converter<String, char$ptr> ExpandEnvMacrosToCharPtr = new StringToCharPtrArgumentsConverter();

  private ClankDiagnosticServices() {

  }

  public static boolean verify(ClankCompilationDataBase.Entry entry, ClankRunDiagnosticsSettings settings, 
          Map<String, MemoryBuffer> remappedBuffers) {
    ClankDiagnosticServices service = new ClankDiagnosticServices();
    
    try {
      //find -i
      ArrayList<String> args = new ArrayList<>();
      args.add("/home/masha/netbeans-src/LLVM39/build/bin/clang");
      args.add("-cc1");
      args.add("-triple");
      args.add("x86_64");
      for (String clArg : settings.clArgs) {
        args.add(clArg);
      }      
//      args.add("-nostdsysteminc");
      args.add("-fsyntax-only");
//      args.add("-fno-exceptions");
      if (!settings.checkers.isEmpty()) {
        //-analyze '-analyzer-checker=core' '-analyzer-output=text'
        args.add("-analyze");
        settings.checkers.forEach((checker) -> {
          args.add("-analyzer-checker="  + ClankCheckerAccessor.getDefault().getClankCheckerOption(checker));
        });
        args.add("-analyzer-output=text");
        args.add("-analyzer-config");
        args.add("prune-paths=false");
        args.add("-DNPRUNE=1");
//        args.add("'-analyzer-output=text'");        
      }
      args.add("-internal-isystem");
      args.add("/home/masha/netbeans-src/LLVM39/build/lib/clang/3.9.0/include");
      //args.add("/home/masha/netbeans-src/LLVM39/llvm/tools/clang/test/Parser/CompoundStmtScope.c");
      args.add(entry.getCompiledFiles().iterator().next().toString());
      service.invokeCompiler(false, args.toArray(new String[0]), settings, entry, remappedBuffers);
      if (DEBUG_DIAGNOSTIC_SERVICES) {
        System.out.println("ClankDiagnosticServices.verify return");
      }
      return true;
    } catch (Throwable ex) {
      //Logger.getLogger(ClankDiagnosticServices.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }
  private static final NativeCallback.Converter<String, char$ptr> ExpandEnvMacrosToCharPtr = new StringToCharPtrArgumentsConverter();

  private void invokeCompiler(boolean expectZeroExitCode, String args[],
          ClankRunDiagnosticsSettings settings,
          ClankCompilationDataBase.Entry entry, Map<String, MemoryBuffer> remappedBuffers) throws Throwable {
    try {
      char$ptr cppArgs[] = CollectionUtils.transform(args, ExpandEnvMacrosToCharPtr, true, true);
      cppArgs = Arrays.copyOf(cppArgs, cppArgs.length + 1);
      //int exitCode = sys.ExecuteAndWait(new StringRef(args[0]), create_type$ptr(cppArgs), null, null, 0, 0, null, null);
      main(args.length, create_type$ptr(cppArgs), settings, entry, remappedBuffers);
      //ASSERT_EXIT_CODE(expectZeroExitCode, exitCode, null);
    } finally {
      llvm.remove_fatal_error_handler();
      llvm.llvm_shutdown();
    }
  }

  private int main(int argc_, /*const*/ type$ptr<char$ptr>/*char PP*/ argv_,
          ClankRunDiagnosticsSettings settings,
          ClankCompilationDataBase.Entry entry, Map<String, MemoryBuffer> remappedBuffers) throws Throwable {
    PrettyStackTraceProgram X = null;
    llvm.llvm_shutdown_obj Y = null;
    SpecificBumpPtrAllocator/*<byte>*/ ArgAllocator = null;
    BumpPtrAllocatorImpl A = null;
    std.setType<std.string> SavedStrings = null;
    IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts = null;
    IntrusiveRefCntPtr<DiagnosticIDs> DiagID = null;
    DiagnosticsEngine Diags = null;
    Driver TheDriver = null;
    std.unique_ptr<Compilation> C = null;
    try {
      sys.PrintStackTraceOnErrorSignal(new StringRef(argv_.$at(0)));
      X/*J*/ = new PrettyStackTraceProgram(argc_, argv_);
      Y/*J*/ = new llvm.llvm_shutdown_obj(); // Call llvm_shutdown() on exit.
      if (org.llvm.support.sys.Process.FixupStandardFileDescriptors().$bool()) {
        return 1;
      }

      SmallVector</*const*/char$ptr/*char P*//*,  256*/> argv/*J*/ = new SmallVector</*const*/char$ptr/*char P*//*,  256*/>(256, null);
      ArgAllocator/*J*/ = new SpecificBumpPtrAllocator/*<byte>*/(byte.class);
      std.error_code EC = org.llvm.support.sys.Process.GetArgumentVector(argv, llvm.makeArrayRef(argv_, argc_), ArgAllocator);
      if (EC.$bool()) {
        llvm.errs().$out(/*KEEP_STR*/"error: couldn't get arguments: ").$out(EC.message()).$out_char($$LF);
        return 1;
      }

      llvm.InitializeAllTargets();
      std.string ProgName = new std.string(argv.$at(0));
      std.pair<std.string, std.string> TargetAndMode = ToolChain.getTargetAndModeFromProgramName(new StringRef(ProgName));

      A/*J*/ = new BumpPtrAllocatorImpl();
      StringSaver Saver/*J*/ = new StringSaver(A);

      // Parse response files using the GNU syntax, unless we're in CL mode. There
      // are two ways to put clang in CL compatibility mode: argv[0] is either
      // clang-cl or cl, or --driver-mode=cl is on the command line. The normal
      // command line parsing can't happen until after response file parsing, so we
      // have to manually search for a --driver-mode=cl argument the hard way.
      // Finally, our -cc1 tools don't care which tokenization mode we use because
      // response files written by clang will tokenize the same way in either mode.
      boolean ClangCLMode = false;
      if ($eq_string$C_T(TargetAndMode.second, /*KEEP_STR*/ "--driver-mode=cl")
              || $noteq_ptr(std.find_if(argv.begin(), argv.end(),
                      (F)
                      -> {
                return (F != null && !((char$ptr) F).$isNull()) && strcmp((char$ptr) F, /*KEEP_STR*/ "--driver-mode=cl") == 0;
              }
              ), argv.end())) {
        ClangCLMode = true;
      }
      /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/ int Default = 0;
      final /*uint*/ int POSIX = Default + 1;
      final /*uint*/ int Windows = POSIX + 1;
      /*}*/
      int RSPQuoting = Default;
      for (/*const*/char$ptr/*char P*/ F : argv) {
        if (strcmp(F, /*KEEP_STR*/ "--rsp-quoting=posix") == 0) {
          RSPQuoting = POSIX;
        } else if (strcmp(F, /*KEEP_STR*/ "--rsp-quoting=windows") == 0) {
          RSPQuoting = Windows;
        }
      }

      // Determines whether we want nullptr markers in argv to indicate response
      // files end-of-lines. We only use this for the /LINK driver argument with
      // clang-cl.exe on Windows.
      boolean MarkEOLs = ClangCLMode;

      ClGlobals.TokenizerCallback Tokenizer;
      if (RSPQuoting == Windows || (RSPQuoting == Default && ClangCLMode)) {
        Tokenizer = ClGlobals.TokenizeWindowsCommandLineCallback;
      } else {
        Tokenizer = ClGlobals.TokenizeGNUCommandLineCallback;
      }
      if (MarkEOLs && $greater_uint(argv.size(), 1) && new StringRef(argv.$at(1)).startswith(/*STRINGREF_STR*/"-cc1")) {
        MarkEOLs = false;
      }
      ClGlobals.ExpandResponseFiles(Saver, Tokenizer, argv, MarkEOLs);

      // Handle -cc1 integrated tools, even if -cc1 was expanded from a response
      // file.
      /*const*/
      type$ptr<char$ptr> FirstArg = std.find_if(argv.begin().$add(1), argv.end(),
              (_A)
              -> {
        return _A != null && !((char$ptr) _A).$isNull();
      }
      );
      if ($noteq_ptr(FirstArg, argv.end()) && new StringRef(FirstArg.$star()).startswith(/*STRINGREF_STR*/"-cc1")) {
        // If -cc1 came from a response file, remove the EOL sentinels.
        if (MarkEOLs) {
          /*const*/
          type$ptr<char$ptr> /*char PP*/ newEnd = $tryClone(std.remove(argv.begin(), argv.end(), null));
          argv.resize(newEnd.$sub(argv.begin()));
        }
        void$ptr/*void P*/ GetExecutablePathVP = create_type$ptr(GetExecutablePathPtr);
        final ArrayRef<char$ptr> argv__ = new ArrayRef</*const*/char$ptr/*char P*/>(argv);
        return cc1_main(argv__.slice(2), argv__.$at(0), GetExecutablePathVP, settings, entry, remappedBuffers);
      }
      return 0;
    } finally {
      if (C != null) {
        C.$destroy();
      }
      if (TheDriver != null) {
        TheDriver.$destroy();
      }
      if (Diags != null) {
        Diags.$destroy();
      }
      if (DiagID != null) {
        DiagID.$destroy();
      }
      if (DiagOpts != null) {
        DiagOpts.$destroy();
      }
      if (SavedStrings != null) {
        SavedStrings.$destroy();
      }
      if (A != null) {
        A.$destroy();
      }
      if (ArgAllocator != null) {
        ArgAllocator.$destroy();
      }
      if (Y != null) {
        Y.$destroy();
      }
      if (X != null) {
        X.$destroy();
      }
    }
  }

  private int cc1_main(ArrayRef</*const*/char$ptr/*char P*/> Argv,
          /*const*/ char$ptr/*char P*/ Argv0, Object/*void P*/ MainAddr,
          ClankRunDiagnosticsSettings settings,
          ClankCompilationDataBase.Entry entry, Map<String, MemoryBuffer> remappedBuffers)
          throws Throwable {
    // JAVA: dedicated exceptions for phases
    Throwable ExecuteCompilerInvocationException = null;
    Throwable CleanUpException = null;
    Throwable InitShutdownException = null;
    // JAVA: end of dedicated exceptions for phases
    std.unique_ptr<CompilerInstance> Clang = null;
    IntrusiveRefCntPtr<DiagnosticIDs> DiagID = null;
    std_ptr.shared_ptr<PCHContainerOperations> PCHOps = null;
    IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts = null;
    DiagnosticsEngine Diags = null;
    ClankDiagnosticsConsumerImpl clankDiagnosticsConsumerImpl = null;
//  CompilerInvokationInitializer initializer = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try { // JAVA: outer block to distinguish the best reason of exception
      try { // JAVA: init-shutdown block
        Clang/*J*/ = new std.unique_ptr<CompilerInstance>(new CompilerInstance());
        DiagID/*J*/ = new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());

        // Register the support for object-file-wrapped Clang modules.
        PCHOps = Clang.$arrow().getPCHContainerOperations();
//      PCHOps.$arrow().registerWriter($c$.track(new std.unique_ptr<PCHContainerWriter>(JavaDifferentiators.JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ObjectFilePCHContainerWriter()))))); $c$.clean();
        //     PCHOps.$arrow().registerReader($c$.track(new std.unique_ptr<PCHContainerReader>(JavaDifferentiators.JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ObjectFilePCHContainerReader()))))); $c$.clean();

        // Initialize targets first, so that --version shows registered targets.
        llvm.InitializeAllTargets();
        llvm.InitializeAllTargetMCs();
        llvm.InitializeAllAsmPrinters();
        llvm.InitializeAllAsmParsers();

        // Buffer diagnostics from argument parsing so that we can output them using a
        // well formed diagnostic object.
        DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions());
        clankDiagnosticsConsumerImpl = new ClankDiagnosticsConsumerImpl(llvm.outs(), DiagOpts.$star(),
                settings, entry);
        //TextDiagnosticBuffer /*P*/ DiagsBuffer = new TextDiagnosticBuffer();
        if (DEBUG_DIAGNOSTIC_SERVICES) {
          DiagOpts.$arrow().ShowParseableFixits = true;
        }
        Diags/*J*/ = new DiagnosticsEngine(DiagID, /*AddrOf*/ DiagOpts.$star(), clankDiagnosticsConsumerImpl);
        Diags.setEnableAllWarnings(settings.showAllWarning);
        //Diags.setWarningsAsErrors(true);
        //Diags.setE
        Clang.$arrow().setDiagnostics(Diags);
//      final CompilerInvocation createInvocationFromCommandLine = FrontendClangGlobals.createInvocationFromCommandLine(Argv, new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags));
//      Clang.$arrow().setInvocation(createInvocationFromCommandLine);
        //CompilerInvocation createInvocationFromCommandLine = ;
        // Clang = new std.unique_ptr<CompilerInstance>(createInvocationFromCommandLine);
        //CompilerInvocation.CreateFromArgs(Clang.$arrow().getInvocation(), Argv.begin(), Argv.end(), Diags);
        // Infer the builtin include path if unspecified.
        boolean Success = CompilerInvocation.CreateFromArgs(Clang.$arrow().getInvocation(), Argv.begin(), Argv.end(), Diags);
        ClankCompilerInvokationInitializer.fillInHeaderSearchOptions(Clang.$arrow().getInvocation().HeaderSearchOpts.$star(), entry);
        ClankCompilerInvokationInitializer.fillInCompilerInvokationOpts(Clang.$arrow().getInvocation(), entry, remappedBuffers);
//
//        // Create the actual diagnostics engine.
//        Clang.$arrow().createDiagnostics(new ClankDiagnosticsConsumerImpl(llvm.outs(), DiagOpts.$star(), 
//                response, entry));

        if (!Clang.$arrow().hasDiagnostics()) {
          return 1;
        }
        //diagnostics are created.now can initialize FileManager and SourceManager
        ClankCompilerInvokationInitializer.fillInCompilerInstance(Clang.$arrow(), entry);
//        Clang.$arrow().getInvocation().HeaderSearchOpts.$star().AddPath(StringRef.R$0, IncludeDirGroup.Quoted, Success, Success);
        if (Clang.$arrow().getHeaderSearchOpts().UseBuiltinIncludes
                && Clang.$arrow().getHeaderSearchOpts().ResourceDir.empty()) {
          Clang.$arrow().getHeaderSearchOpts().ResourceDir.$assignMove(
                  CompilerInvocation.GetResourcesPath(Argv0, MainAddr)
          );
        }

        // Set an error handler, so that any LLVM backend diagnostics go through our
        // error handler.
        //assertion will be thrown if error handler is set already
        llvm.install_fatal_error_handler(cc1_mainGlobals::LLVMErrorHandler,
                ((/*static_cast*/Object/*void P*/) (/*AddrOf*/Clang.$arrow().getDiagnostics())));

//        clankDiagnosticsConsumerImpl.FlushDiagnostics(Clang.$arrow().getDiagnostics());
//      if (!Success) {
//        return 1;
//      }
//        initializer = new CompilerInvokationInitializer(settings, entry);
//        
//        boolean Success = true;
        try {
          // Execute the frontend actions.
          Success = ExecuteCompilerInvocation(Clang.get());
        } catch (Throwable e) { // JAVA: separate ExecuteCompilerInvocation
          // remember here and allow the code below to make clean up
          ExecuteCompilerInvocationException = e;
          // print once and register reason 
          // NativeTrace.printStackTraceOnce(e, Level.SEVERE, true);
        }

        // If any timers were active but haven't been destroyed yet, print their
        // results now.  This happens in -disable-free mode.
        TimerGroup.printAll(llvm.errs());

        // Our error handler depends on the Diagnostics object, which we're
        // potentially about to delete. Uninstall the handler now so that any
        // later errors use the default handling behavior instead.
        llvm.remove_fatal_error_handler();

        // When running with -disable-free, don't do any destruction or shutdown.
//        if (Clang.$arrow().getFrontendOpts().DisableFree) {
//          BuryPointer$T($c$.track(new std.unique_ptr<CompilerInstance>(JavaDifferentiators.JD$Move.INSTANCE, std.move(Clang))));
//          $c$.clean();
//          return ((!Success) ? 1 : 0);
//        }

        return ((!Success) ? 1 : 0);
      } catch (Throwable e) {
        InitShutdownException = e;
        // print once and register reason 
        NativeTrace.printStackTraceOnce(e, Level.SEVERE, true);
      } finally {
        if (DiagOpts != null) {
          DiagOpts.$destroy();
        }
        if (PCHOps != null) {
          PCHOps.$destroy();
        }
        if (DiagID != null) {
          DiagID.$destroy();
        }
        if (Clang != null) {
          Clang.$destroy();
        }
//        if (Diags != null) {
//          Diags.$destroy();
//        }
      }
    } catch (Throwable e) {
      CleanUpException = e;
      // print once and register reason 
      NativeTrace.printStackTraceOnce(e, Level.SEVERE, true);
    } finally {
      $c$.$destroy();
      if (ExecuteCompilerInvocationException != null) {
        // delegate inner issue
        throw ExecuteCompilerInvocationException;
      } else if (InitShutdownException != null) {
        // delegate inner issue
        throw InitShutdownException;
      } else if (CleanUpException != null) {
        throw CleanUpException;
      }
    }
    assert (ExecuteCompilerInvocationException != null)
            || (InitShutdownException != null)
            || (CleanUpException != null);
    assert false : "there was an error and must be thrown above";
    return 1;
  }

  private static final class StringToCharPtrArgumentsConverter implements NativeCallback.Converter<String, char$ptr> {

    @Override
    public Class<char$ptr> getToClass() {
      return char$ptr.class;
    }

    @Override
    public char$ptr $call(String from) {
      //from = convertOneArgument(from);
      return NativePointer.create_char$ptr_utf8(from);
    }
  }

}
