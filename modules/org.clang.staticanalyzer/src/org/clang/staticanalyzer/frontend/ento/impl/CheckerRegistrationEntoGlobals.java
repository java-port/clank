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
package org.clang.staticanalyzer.frontend.ento.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.frontend.impl.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type CheckerRegistrationEntoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento16printCheckerHelpERN4llvm11raw_ostreamENS1_8ArrayRefINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEEE;_ZN5clang4ento16printCheckerHelpERN4llvm11raw_ostreamENS1_8ArrayRefISsEE;_ZN5clang4ento20createCheckerManagerERNS_15AnalyzerOptionsERKNS_11LangOptionsEN4llvm8ArrayRefINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEEERNS_17DiagnosticsEngineE;_ZN5clang4ento20createCheckerManagerERNS_15AnalyzerOptionsERKNS_11LangOptionsEN4llvm8ArrayRefISsEERNS_17DiagnosticsEngineE; -static-type=CheckerRegistrationEntoGlobals -package=org.clang.staticanalyzer.frontend.ento.impl")
//</editor-fold>
public final class CheckerRegistrationEntoGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::ento::createCheckerManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 104,
 FQN="clang::ento::createCheckerManager", NM="_ZN5clang4ento20createCheckerManagerERNS_15AnalyzerOptionsERKNS_11LangOptionsEN4llvm8ArrayRefISsEERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento20createCheckerManagerERNS_15AnalyzerOptionsERKNS_11LangOptionsEN4llvm8ArrayRefISsEERNS_17DiagnosticsEngineE")
//</editor-fold>
public static std.unique_ptr<CheckerManager> createCheckerManager(final AnalyzerOptions /*&*/ opts, final /*const*/ LangOptions /*&*/ langOpts, 
                    ArrayRef<std.string> plugins, 
                    final DiagnosticsEngine /*&*/ diags) {
  std.unique_ptr<CheckerManager> checkerMgr = null;
  ClangCheckerRegistry allCheckers = null;
  try {
    checkerMgr/*J*/= new std.unique_ptr<CheckerManager>(new CheckerManager(langOpts, new IntrusiveRefCntPtr<AnalyzerOptions>($AddrOf(opts))));
    
    SmallVector<CheckerOptInfo> checkerOpts/*J*/= new SmallVector<CheckerOptInfo>(8, new CheckerOptInfo());
    for (/*uint*/int i = 0, e = opts.CheckersControlList.size(); i != e; ++i) {
      final /*const*/std.pairTypeBool<std.string>/*&*/ opt = opts.CheckersControlList.$at(i);
      checkerOpts.push_back(new CheckerOptInfo(new StringRef(opt.first.c_str()), opt.second));
    }
    
    allCheckers/*J*/= new ClangCheckerRegistry(new ArrayRef<std.string>(plugins), $AddrOf(diags));
    allCheckers.initializeManager(checkerMgr.$star(), checkerOpts);
    allCheckers.validateCheckerOptions(opts, diags);
    checkerMgr.$arrow().finishedCheckerRegistration();
    
    for (/*uint*/int i = 0, e = checkerOpts.size(); i != e; ++i) {
      if (checkerOpts.$at(i).isUnclaimed()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(diags.Report(diag.err_unknown_analyzer_checker)), 
              checkerOpts.$at(i).getName()));
          $c$.clean($c$.track(diags.Report(diag.note_suggest_disabling_all_checkers)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return new std.unique_ptr<CheckerManager>(JD$Move.INSTANCE, checkerMgr);
  } finally {
    if (allCheckers != null) { allCheckers.$destroy(); }
    if (checkerMgr != null) { checkerMgr.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::printCheckerHelp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp", line = 134,
 FQN="clang::ento::printCheckerHelp", NM="_ZN5clang4ento16printCheckerHelpERN4llvm11raw_ostreamENS1_8ArrayRefISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/CheckerRegistration.cpp -nm=_ZN5clang4ento16printCheckerHelpERN4llvm11raw_ostreamENS1_8ArrayRefISsEE")
//</editor-fold>
public static void printCheckerHelp(final raw_ostream /*&*/ out, ArrayRef<std.string> plugins) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    out.$out(/*KEEP_STR*/"OVERVIEW: Clang Static Analyzer Checkers List\n\n");
    out.$out(/*KEEP_STR*/"USAGE: -analyzer-checker <CHECKER or PACKAGE,...>\n\n");
    
    $c$.track(new ClangCheckerRegistry(new ArrayRef<std.string>(plugins))).printHelp(out); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

} // END OF class CheckerRegistrationEntoGlobals
