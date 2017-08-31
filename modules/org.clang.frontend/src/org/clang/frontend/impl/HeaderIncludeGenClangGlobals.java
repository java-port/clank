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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;
import static org.clang.frontend.impl.HeaderIncludeGenStatics.PrintHeaderInfo;
import static org.llvm.support.sys.fs.*;


//<editor-fold defaultstate="collapsed" desc="static type HeaderIncludeGenClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp -nm=_ZN5clang22AttachHeaderIncludeGenERNS_12PreprocessorERKNS_23DependencyOutputOptionsEbN4llvm9StringRefEbb; -static-type=HeaderIncludeGenClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class HeaderIncludeGenClangGlobals {


/// AttachHeaderIncludeGen - Create a header include list generator, and attach
/// it to the given preprocessor.
///
/// \param DepOpts - Options controlling the output.
/// \param ShowAllHeaders - If true, show all header information instead of just
/// headers following the predefines buffer. This is useful for making sure
/// includes mentioned on the command line are also reported, but differs from
/// the default behavior used by -H.
/// \param OutputPath - If non-empty, a path to write the header include
/// information to, instead of writing to stderr.
/// \param ShowDepth - Whether to indent to show the nesting of the includes.
/// \param MSStyle - Whether to print in cl.exe /showIncludes style.
//<editor-fold defaultstate="collapsed" desc="clang::AttachHeaderIncludeGen">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", line = 79,
 FQN="clang::AttachHeaderIncludeGen", NM="_ZN5clang22AttachHeaderIncludeGenERNS_12PreprocessorERKNS_23DependencyOutputOptionsEbN4llvm9StringRefEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp -nm=_ZN5clang22AttachHeaderIncludeGenERNS_12PreprocessorERKNS_23DependencyOutputOptionsEbN4llvm9StringRefEbb")
//</editor-fold>
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts) {
  AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      false, new StringRef(/*KEEP_STR*/$EMPTY), 
                      true, false);
}
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
                      boolean ShowAllHeaders/*= false*/) {
  AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      ShowAllHeaders, new StringRef(/*KEEP_STR*/$EMPTY), 
                      true, false);
}
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
                      boolean ShowAllHeaders/*= false*/, StringRef OutputPath/*= ""*/) {
  AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      ShowAllHeaders, OutputPath, 
                      true, false);
}
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
                      boolean ShowAllHeaders/*= false*/, StringRef OutputPath/*= ""*/, 
                      boolean ShowDepth/*= true*/) {
  AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      ShowAllHeaders, OutputPath, 
                      ShowDepth, false);
}
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
                      boolean ShowAllHeaders/*= false*/, StringRef OutputPath/*= ""*/, 
                      boolean ShowDepth/*= true*/, boolean MSStyle/*= false*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    raw_ostream /*P*/ OutputFile = MSStyle ? /*AddrOf*/llvm.outs() : /*AddrOf*/llvm.errs();
    boolean OwnsOutputFile = false;
    
    // Open the output file, if used.
    if (!OutputPath.empty()) {
      std.error_code EC/*J*/= new std.error_code();
      raw_fd_ostream /*P*/ OS = new raw_fd_ostream(new StringRef(OutputPath.str()), EC, $bitor_OpenFlags(/*KEEP_ENUM*/fs.OpenFlags.F_Append, /*KEEP_ENUM*/fs.OpenFlags.F_Text));
      if (EC.$bool()) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.getDiagnostics().Report(diag.warn_fe_cc_print_header_failure)), 
            new StringRef(EC.message())));
        if (OS != null) { OS.$destroy();};
      } else {
        OS.SetUnbuffered();
        OutputFile = OS;
        OwnsOutputFile = true;
      }
    }
    
    // Print header info for extra headers, pretending they were discovered by
    // the regular preprocessor. The primary use case is to support proper
    // generation of Make / Ninja file dependencies for implicit includes, such
    // as sanitizer blacklists. It's only important for cl.exe compatibility,
    // the GNU way to generate rules is -M / -MM / -MD / -MMD.
    for (/*const*/std.string/*&*/ Header : DepOpts.ExtraDeps)  {
      PrintHeaderInfo(OutputFile, new StringRef(Header), ShowDepth, 2, MSStyle);
    }
    PP.addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new HeaderIncludesCallback(/*AddrOf*/PP, ShowAllHeaders, OutputFile, DepOpts, OwnsOutputFile, ShowDepth, 
                MSStyle)))))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

} // END OF class HeaderIncludeGenClangGlobals
