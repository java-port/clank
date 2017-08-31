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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.driver.*;
import org.llvm.option.*;
import org.clang.frontend.*;
import org.clang.driver.options;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type CreateInvocationFromCommandLineClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CreateInvocationFromCommandLine.cpp -nm=_ZN5clang31createInvocationFromCommandLineEN4llvm8ArrayRefIPKcEENS0_18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEE; -static-type=CreateInvocationFromCommandLineClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class CreateInvocationFromCommandLineClangGlobals {


/// createInvocationFromCommandLine - Construct a compiler invocation object for
/// a command line argument vector.
///
/// \return A CompilerInvocation, or 0 if none was built for the given
/// argument vector.

/// createInvocationFromCommandLine - Construct a compiler invocation object for
/// a command line argument vector.
///
/// \return A CompilerInvocation, or 0 if none was built for the given
/// argument vector.
//<editor-fold defaultstate="collapsed" desc="clang::createInvocationFromCommandLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CreateInvocationFromCommandLine.cpp", line = 33,
 FQN="clang::createInvocationFromCommandLine", NM="_ZN5clang31createInvocationFromCommandLineEN4llvm8ArrayRefIPKcEENS0_18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CreateInvocationFromCommandLine.cpp -nm=_ZN5clang31createInvocationFromCommandLineEN4llvm8ArrayRefIPKcEENS0_18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEE")
//</editor-fold>
public static CompilerInvocation /*P*/ createInvocationFromCommandLine(ArrayRef</*const*/char$ptr/*char P*/ > ArgList) {
  return createInvocationFromCommandLine(ArgList, 
                               new IntrusiveRefCntPtr<DiagnosticsEngine>());
}
public static CompilerInvocation /*P*/ createInvocationFromCommandLine(ArrayRef</*const*/char$ptr/*char P*/ > ArgList, 
                               IntrusiveRefCntPtr<DiagnosticsEngine> Diags/*= IntrusiveRefCntPtr<DiagnosticsEngine>()*/) {
  Driver TheDriver = null;
  std.unique_ptr<Compilation> C = null;
  std.unique_ptr<CompilerInvocation> CI = null;
  try {
    if (!(Diags.get() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // No diagnostics engine was provided, so create our own diagnostics object
        // with the default options.
        $c$.clean(Diags.$assign($c$.track(CompilerInstance.createDiagnostics(new DiagnosticOptions()))));
      } finally {
        $c$.$destroy();
      }
    }
    
    SmallVector</*const*/char$ptr/*char P*//*,  16*/> Args/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  16*/>(16, ArgList.begin(), ArgList.end(), null);
    
    // FIXME: Find a cleaner way to force the driver into restricted modes.
    Args.push_back($("-fsyntax-only"));
    
    // FIXME: We shouldn't have to pass in the path info.
    TheDriver/*J*/= new Driver(new StringRef(Args.$at(0)), new StringRef(sys.getDefaultTargetTriple()), 
        Diags.$star());
    
    // Don't check that inputs exist, they may have been remapped.
    TheDriver.setCheckInputsExist(false);
    
    C/*J*/= new std.unique_ptr<Compilation>(TheDriver.BuildCompilation(new ArrayRef</*const*/char$ptr/*char P*/ >(Args)));
    
    // Just print the cc1 options if -### was present.
    if (C.$arrow().getArgs().hasArg(new OptSpecifier(options.ID.OPT__HASH_HASH_HASH.getValue()))) {
      C.$arrow().getJobs().Print(llvm.errs(), $LF, true);
      return null;
    }
    
    // We expect to get back exactly one command job, if we didn't something
    // failed. Offload compilation is an exception as it creates multiple jobs. If
    // that's the case, we proceed with the first job. If caller needs a
    // particular job, it should be controlled via options (e.g.
    // --cuda-{host|device}-only for CUDA) passed to the driver.
    /*const*/ JobList /*&*/ Jobs = C.$arrow().getJobs();
    boolean OffloadCompilation = false;
    if ($greater_uint(Jobs.size(), 1)) {
      for (Action /*P*/ /*&*/ A : C.$arrow().getActions()) {
        // On MacOSX real actions may end up being wrapped in BindArchAction
        if (isa(BindArchAction.class, A)) {
          A = A.input_begin().$star();
        }
        if (isa(OffloadAction.class, A)) {
          OffloadCompilation = true;
          break;
        }
      }
    }
    if (Jobs.size() == 0 || !isa(Command.class, Jobs.begin$Const().$star())
       || ($greater_uint(Jobs.size(), 1) && !OffloadCompilation)) {
      raw_svector_ostream OS = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SmallString/*256*/ Msg/*J*/= new SmallString/*256*/(256);
        OS/*J*/= new raw_svector_ostream(Msg);
        Jobs.Print(OS, $("; "), true);
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.$arrow().Report(diag.err_fe_expected_compiler_job)), OS.str()));
        return null;
      } finally {
        if (OS != null) { OS.$destroy(); }
        $c$.$destroy();
      }
    }
    
    /*const*/ Command /*&*/ Cmd = cast(Command.class, Jobs.begin$Const().$star());
    if ($noteq_StringRef(/*STRINGREF_STR*/Cmd.getCreator().getName(), /*STRINGREF_STR*/"clang")) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.$arrow().Report(diag.err_fe_expected_clang_command)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    /*const*/ArgStringList/*&*/ CCArgs = Cmd.getArguments();
    CI/*J*/= new std.unique_ptr<CompilerInvocation>(new CompilerInvocation());
    if (!CompilerInvocation.CreateFromArgs(CI.$star(), 
        ((/*const_cast*//*const*/type$ptr<char$ptr>/*char PP*/ )(CCArgs.data$Const())), 
        ((/*const_cast*//*const*/type$ptr<char$ptr>/*char PP*/ )(CCArgs.data$Const())).$add(CCArgs.size()), 
        Diags.$star())) {
      return null;
    }
    return CI.release();
  } finally {
    if (CI != null) { CI.$destroy(); }
    if (C != null) { C.$destroy(); }
    if (TheDriver != null) { TheDriver.$destroy(); }
  }
}

} // END OF class CreateInvocationFromCommandLineClangGlobals
