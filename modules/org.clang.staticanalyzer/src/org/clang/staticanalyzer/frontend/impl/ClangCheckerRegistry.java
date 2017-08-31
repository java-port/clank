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

package org.clang.staticanalyzer.frontend.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.staticanalyzer.checkers.ento.EntoGlobals.*;
import org.clang.staticanalyzer.java.StaticAnalyzerFunctionPointers.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.support.sys.DynamicLibrary;
import org.llvm.support.sys.path;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangCheckerRegistry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 34,
 FQN="(anonymous namespace)::ClangCheckerRegistry", NM="_ZN12_GLOBAL__N_120ClangCheckerRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN12_GLOBAL__N_120ClangCheckerRegistryE")
//</editor-fold>
public class ClangCheckerRegistry extends /*public*/ CheckerRegistry implements Destructors.ClassWithDestructor {
  /*typedef void (*RegisterCheckersFn)(CheckerRegistry &)*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangCheckerRegistry::isCompatibleAPIVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 79,
   FQN="(anonymous namespace)::ClangCheckerRegistry::isCompatibleAPIVersion", NM="_ZN12_GLOBAL__N_120ClangCheckerRegistry22isCompatibleAPIVersionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN12_GLOBAL__N_120ClangCheckerRegistry22isCompatibleAPIVersionEPKc")
  //</editor-fold>
  private static boolean isCompatibleAPIVersion(/*const*/char$ptr/*char P*/ versionString) {
    // If the version string is null, it's not an analyzer plugin.
    if (!Native.$bool(versionString)) {
      return false;
    }
    
    // For now, none of the static analyzer API is considered stable.
    // Versions must match exactly.
    return strcmp(versionString, /*KEEP_STR*/"3.9.0") == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangCheckerRegistry::warnIncompatible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 89,
   FQN="(anonymous namespace)::ClangCheckerRegistry::warnIncompatible", NM="_ZN12_GLOBAL__N_120ClangCheckerRegistry16warnIncompatibleEPN5clang17DiagnosticsEngineEN4llvm9StringRefEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN12_GLOBAL__N_120ClangCheckerRegistry16warnIncompatibleEPN5clang17DiagnosticsEngineEN4llvm9StringRefEPKc")
  //</editor-fold>
  private static void warnIncompatible(DiagnosticsEngine /*P*/ diags, 
                  StringRef pluginPath, 
                  /*const*/char$ptr/*char P*/ pluginAPIVersion) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!(diags != null)) {
        return;
      }
      if (!Native.$bool(pluginAPIVersion)) {
        return;
      }
      
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(diags.Report(diag.warn_incompatible_analyzer_plugin_api)), 
          path.filename(/*NO_COPY*/pluginPath)));
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(diags.Report(diag.note_incompatible_analyzer_plugin_api)), 
              /*KEEP_STR*/"3.9.0"), 
          pluginAPIVersion));
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangCheckerRegistry::ClangCheckerRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 48,
   FQN="(anonymous namespace)::ClangCheckerRegistry::ClangCheckerRegistry", NM="_ZN12_GLOBAL__N_120ClangCheckerRegistryC1EN4llvm8ArrayRefISsEEPN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN12_GLOBAL__N_120ClangCheckerRegistryC1EN4llvm8ArrayRefISsEEPN5clang17DiagnosticsEngineE")
  //</editor-fold>
  public ClangCheckerRegistry(ArrayRef<std.string> plugins) {
    this(plugins, 
      (DiagnosticsEngine /*P*/ )null);
  }
  public ClangCheckerRegistry(ArrayRef<std.string> plugins, 
      DiagnosticsEngine /*P*/ diags/*= null*/) {
    // : CheckerRegistry() 
    //START JInit
    super();
    //END JInit
    registerBuiltinCheckers(/*Deref*/this);
    
    for (type$ptr<std.string> i = $tryClone(plugins.begin()), /*P*/ e = $tryClone(plugins.end());
         $noteq_ptr(i, e); i.$preInc()) {
      // Get access to the plugin.
      std.string err/*J*/= new std.string();
      DynamicLibrary lib = DynamicLibrary.getPermanentLibrary(i./*->*/$star().c_str(), $AddrOf(err));
      if (!lib.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(diags.Report(diag.err_fe_unable_to_load_plugin)), new StringRef(i.$star())), new StringRef(err)));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // See if it's compatible with this build of clang.
      /*const*/char$ptr/*char P*/ pluginAPIVersion = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, lib.getAddressOfSymbol($("clang_analyzerAPIVersionString"))));
      if (!isCompatibleAPIVersion(pluginAPIVersion)) {
        warnIncompatible(diags, new StringRef(i.$star()), pluginAPIVersion);
        continue;
      }
      
      // Register its checkers.
      CheckerRegistry2Void registerPluginCheckers = (CheckerRegistry2Void)(Object/*intptr_t*/)lib.getAddressOfSymbol($("clang_registerCheckers"));
      if ((registerPluginCheckers != null)) {
        registerPluginCheckers.$call(/*Deref*/this);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangCheckerRegistry::~ClangCheckerRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 34,
   FQN="(anonymous namespace)::ClangCheckerRegistry::~ClangCheckerRegistry", NM="_ZN12_GLOBAL__N_120ClangCheckerRegistryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN12_GLOBAL__N_120ClangCheckerRegistryD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
