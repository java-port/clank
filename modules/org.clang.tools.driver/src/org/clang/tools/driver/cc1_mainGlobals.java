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

import java.util.logging.Level;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.codegen.ObjectFilePCHContainerReader;
import org.clang.codegen.ObjectFilePCHContainerWriter;
import org.clang.frontend.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import static org.clang.frontendtool.FrontendtoolClangGlobals.ExecuteCompilerInvocation;
import org.llvm.support.sys.sys;


//<editor-fold defaultstate="collapsed" desc="static type cc1_mainGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_Z8cc1_mainN4llvm8ArrayRefIPKcEES2_Pv;_ZL16LLVMErrorHandlerPvRKSsb; -static-type=cc1_mainGlobals -package=org.clang.tools.driver")
//</editor-fold>
public final class cc1_mainGlobals {


//===----------------------------------------------------------------------===//
// Main driver
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="LLVMErrorHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp", line = 45,
 FQN="LLVMErrorHandler", NM="_ZL16LLVMErrorHandlerPvRKSsb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZL16LLVMErrorHandlerPvRKSsb")
//</editor-fold>
public static void LLVMErrorHandler(Object/*void P*/ UserData, /*const*/std.string/*&*/ Message, 
                boolean GenCrashDiag) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DiagnosticsEngine /*&*/ Diags = /*Deref*/((/*static_cast*/DiagnosticsEngine /*P*/ )(UserData));
    
    $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_fe_error_backend)), new StringRef(Message)));
    
    // Run the interrupt handlers to make sure any special cleanups get done, in
    // particular that we remove files registered with RemoveFileOnSignal.
    sys.RunInterruptHandlers();
    
    // We cannot recover from llvm errors.  When reporting a fatal error, exit
    // with status 70 to generate crash diagnostics.  For BSD systems this is
    // defined as an internal software error.  Otherwise, exit with status 1.
    exit(GenCrashDiag ? 70 : 1);
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="cc1_main">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, // JAVA: wrap in try/catch different blocks to distinguish exception reason
 source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp", line = 67,
 old_source = "${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp", old_line = 199,
 FQN="cc1_main", NM="_Z8cc1_mainN4llvm8ArrayRefIPKcEES2_Pv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_Z8cc1_mainN4llvm8ArrayRefIPKcEES2_Pv")
//</editor-fold>
public static int cc1_main(ArrayRef</*const*/char$ptr/*char P*/ > Argv, /*const*/char$ptr/*char P*/ Argv0, Object/*void P*/ MainAddr) 
throws Throwable {
  // JAVA: dedicated exceptions for phases
  Throwable ExecuteCompilerInvocationException = null;
  Throwable CleanUpException = null;
  Throwable InitShutdownException = null;  
  // JAVA: end of dedicated exceptions for phases
  std.unique_ptr<CompilerInstance> Clang = null;
  IntrusiveRefCntPtr<DiagnosticIDs> DiagID = null;
  shared_ptr<PCHContainerOperations> PCHOps = null;
  IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts = null;
  DiagnosticsEngine Diags = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try { // JAVA: outer block to distinguish the best reason of exception
    try { // JAVA: init-shutdown block
      Clang/*J*/= new std.unique_ptr<CompilerInstance>(new CompilerInstance());
      DiagID/*J*/= new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs());
      
      // Register the support for object-file-wrapped Clang modules.
      PCHOps = Clang.$arrow().getPCHContainerOperations();
      PCHOps.$arrow().registerWriter($c$.track(new std.unique_ptr<PCHContainerWriter>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ObjectFilePCHContainerWriter()))))); $c$.clean();
      PCHOps.$arrow().registerReader($c$.track(new std.unique_ptr<PCHContainerReader>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ObjectFilePCHContainerReader()))))); $c$.clean();
      
      // Initialize targets first, so that --version shows registered targets.
      llvm.InitializeAllTargets();
      llvm.InitializeAllTargetMCs();
      llvm.InitializeAllAsmPrinters();
      llvm.InitializeAllAsmParsers();
      
      // Buffer diagnostics from argument parsing so that we can output them using a
      // well formed diagnostic object.
      DiagOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions());
      TextDiagnosticBuffer /*P*/ DiagsBuffer = new TextDiagnosticBuffer();
      Diags/*J*/= new DiagnosticsEngine(DiagID, /*AddrOf*/DiagOpts.$star(), DiagsBuffer);
      boolean Success = CompilerInvocation.CreateFromArgs(Clang.$arrow().getInvocation(), Argv.begin(), Argv.end(), Diags);
      
      // Infer the builtin include path if unspecified.
      if (Clang.$arrow().getHeaderSearchOpts().UseBuiltinIncludes
         && Clang.$arrow().getHeaderSearchOpts().ResourceDir.empty()) {
        Clang.$arrow().getHeaderSearchOpts().ResourceDir.$assignMove(
            CompilerInvocation.GetResourcesPath(Argv0, MainAddr)
        );
      }
      
      // Create the actual diagnostics engine.
      Clang.$arrow().createDiagnostics();
      if (!Clang.$arrow().hasDiagnostics()) {
        return 1;
      }
      
      // Set an error handler, so that any LLVM backend diagnostics go through our
      // error handler.
      llvm.install_fatal_error_handler(cc1_mainGlobals::LLVMErrorHandler, 
          ((/*static_cast*/Object/*void P*/ )(/*AddrOf*/Clang.$arrow().getDiagnostics())));
      
      DiagsBuffer.FlushDiagnostics(Clang.$arrow().getDiagnostics());
      if (!Success) {
        return 1;
      }
      
      try {
        // Execute the frontend actions.
        Success = ExecuteCompilerInvocation(Clang.get());
      } catch (Throwable e) { // JAVA: separate ExecuteCompilerInvocation
        // remember here and allow the code below to make clean up
        ExecuteCompilerInvocationException = e;
        // print once and register reason 
        NativeTrace.printStackTraceOnce(e, Level.SEVERE, true);
      }
      
      // If any timers were active but haven't been destroyed yet, print their
      // results now.  This happens in -disable-free mode.
      TimerGroup.printAll(llvm.errs());
      
      // Our error handler depends on the Diagnostics object, which we're
      // potentially about to delete. Uninstall the handler now so that any
      // later errors use the default handling behavior instead.
      llvm.remove_fatal_error_handler();
      
      // When running with -disable-free, don't do any destruction or shutdown.
      if (Clang.$arrow().getFrontendOpts().DisableFree) {
        BuryPointer$T($c$.track(new std.unique_ptr<CompilerInstance>(JD$Move.INSTANCE, std.move(Clang)))); $c$.clean();
        return ((!Success) ? 1 : 0);
      }
      
      return ((!Success) ? 1 : 0);
    } catch (Throwable e) {
      InitShutdownException = e;
      // print once and register reason 
      NativeTrace.printStackTraceOnce(e, Level.SEVERE, true);    
    } finally {
      if (Diags != null) { Diags.$destroy(); }
      if (DiagOpts != null) { DiagOpts.$destroy(); }
      if (PCHOps != null) { PCHOps.$destroy(); }
      if (DiagID != null) { DiagID.$destroy(); }
      if (Clang != null) { Clang.$destroy(); }
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
  assert (ExecuteCompilerInvocationException != null) ||
         (InitShutdownException != null) || 
         (CleanUpException != null);
  assert false : "there was an error and must be thrown above";
  return 1;
}

} // END OF class cc1_mainGlobals
