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
package org.clang.frontendtool;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.cl.ClGlobals;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.frontend.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import org.clang.frontend.llvm.FrontendPluginRegistry;
import org.clang.frontendtool.impl.ExecuteCompilerInvocationStatics;
import org.llvm.support.sys.DynamicLibrary;
import org.clang.frontendtool.java.FrontendtoolJava;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;


//<editor-fold defaultstate="collapsed" desc="static type FrontendtoolClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.frontendtool.FrontendtoolClangGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontendtool/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang25ExecuteCompilerInvocationEPNS_16CompilerInstanceE; -static-type=FrontendtoolClangGlobals -package=org.clang.frontendtool")
//</editor-fold>
public final class FrontendtoolClangGlobals {


/// ExecuteCompilerInvocation - Execute the given actions described by the
/// compiler invocation object in the given compiler instance.
///
/// \return - True on success.
//<editor-fold defaultstate="collapsed" desc="clang::ExecuteCompilerInvocation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*clear stat*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp", line = 171,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp", old_line = 164,
 FQN="clang::ExecuteCompilerInvocation", NM="_ZN5clang25ExecuteCompilerInvocationEPNS_16CompilerInstanceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontendtool/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang25ExecuteCompilerInvocationEPNS_16CompilerInstanceE")
//</editor-fold>
public static boolean ExecuteCompilerInvocation(CompilerInstance /*P*/ Clang) {
  // JAVA: clear statistics
  FrontendtoolJava.clearStatistics();    
  std.unique_ptr<FrontendAction> Act = null;
  try {
    // Honor -help.
    if (Clang.getFrontendOpts().ShowHelp) {
      std.unique_ptr<OptTable> Opts = null;
      try {
        Opts/*J*/= new std.unique_ptr<OptTable>(DriverGlobals.createDriverOptTable());
        Opts.$arrow().PrintHelp(llvm.outs(), $("clang -cc1"), 
            $("LLVM 'Clang' Compiler: http://clang.llvm.org"), 
            /*Include=*/ options.ClangFlags.CC1Option, /*Exclude=*/ 0);
        return true;
      } finally {
        if (Opts != null) { Opts.$destroy(); }
      }
    }
    
    // Honor -version.
    //
    // FIXME: Use a better -version message?
    if (Clang.getFrontendOpts().ShowVersion) {
      ClGlobals.PrintVersionMessage();
      return true;
    }
    
    // Load any requested plugins.
    for (/*uint*/int i = 0, 
        e = Clang.getFrontendOpts().Plugins.size(); i != e; ++i) {
      final /*const*/std.string/*&*/ Path = Clang.getFrontendOpts().Plugins.$at(i);
      std.string Error/*J*/= new std.string();
      if (DynamicLibrary.LoadLibraryPermanently(Path.c_str(), $AddrOf(Error))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Clang.getDiagnostics().Report(diag.err_fe_unable_to_load_plugin)), 
                  new StringRef(Path)), new StringRef(Error)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Check if any of the loaded plugins replaces the main AST action
    for (FrontendPluginRegistry.iterator<PluginASTAction> it = FrontendPluginRegistry.begin(), 
        ie = FrontendPluginRegistry.end();
         it.$noteq(ie); it.$preInc()) {
      std.unique_ptr<PluginASTAction> P = null;
      try {
        P/*J*/= it.$arrow().instantiate();
        if (P.$arrow().getActionType() == PluginASTAction.ActionType.ReplaceAction) {
          Clang.getFrontendOpts().ProgramAction = frontend.ActionKind.PluginAction;
          Clang.getFrontendOpts().ActionName.$assign_T$C$P(it.$arrow().getName());
          break;
        }
      } finally {
        if (P != null) { P.$destroy(); }
      }
    }
    
    // Honor -mllvm.
    //
    // FIXME: Remove this, one day.
    // This should happen AFTER plugins have been loaded!
    if (!Clang.getFrontendOpts().LLVMArgs.empty()) {
      unique_ptr_array</*const*/char$ptr/*char P*/ /*[]*/> Args = null;
      try {
        /*uint*/int NumArgs = Clang.getFrontendOpts().LLVMArgs.size();
        Args = llvm.make_unique(new /*const*/char$ptr/*char P*/ [NumArgs + 2]);
        Args.$set(0, $("clang (LLVM option parsing)"));
        for (/*uint*/int i = 0; i != NumArgs; ++i)  {
          Args.$set(i + 1, Clang.getFrontendOpts().LLVMArgs.$at(i).c_str());
        }
        Args.$set(NumArgs + 1, null);
        ClGlobals.ParseCommandLineOptions(NumArgs + 1, Args.get());
      } finally {
        if (Args != null) { Args.$destroy(); }
      }
    }
    // Honor -analyzer-checker-help.
    // This should happen AFTER plugins have been loaded!
    if (Clang.getAnalyzerOpts().$arrow().ShowCheckerHelp) {
      EntoGlobals.printCheckerHelp(llvm.outs(), new ArrayRef<std.string>(Clang.getFrontendOpts().Plugins, false));
      return true;
    }
    
    // If there were errors in processing arguments, don't do anything else.
    if (Clang.getDiagnostics().hasErrorOccurred()) {
      return false;
    }
    // Create and execute the frontend action.
    Act/*J*/= ExecuteCompilerInvocationStatics.CreateFrontendAction($Deref(Clang));
    if (!Act.$bool()) {
      return false;
    }
    boolean Success = Clang.ExecuteAction(Act.$star());
    if (Clang.getFrontendOpts().DisableFree) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        BuryPointer$T($c$.track(new std.unique_ptr<FrontendAction>(JD$Move.INSTANCE, std.move(Act)))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    return Success;
  } finally {
    if (Act != null) { Act.$destroy(); }
  }
}

} // END OF class FrontendtoolClangGlobals
