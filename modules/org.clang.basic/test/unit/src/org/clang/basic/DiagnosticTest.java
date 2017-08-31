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

package org.clang.basic;

import org.junit.Test;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type DiagnosticTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/DiagnosticTest.cpp -test=DiagnosticTest")
//</editor-fold>
public final class DiagnosticTest extends ADTSupportTestBase {

//JAVA: using namespace llvm
//JAVA: using namespace clang
//JAVA: namespace (anonymous) {

// Check that DiagnosticErrorTrap works with SuppressAllDiagnostics.
;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagnosticTest_suppressAndTrap_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/DiagnosticTest.cpp", line = 20,
 FQN="(anonymous namespace)::DiagnosticTest_suppressAndTrap_Test::TestBody", NM="_ZN12_GLOBAL__N_135DiagnosticTest_suppressAndTrap_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/DiagnosticTest.cpp -nm=_ZN12_GLOBAL__N_135DiagnosticTest_suppressAndTrap_Test8TestBodyEv")
//</editor-fold>
public void test_suppressAndTrap() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  DiagnosticsEngine Diags = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Diags/*J*/= $c$.clean(new DiagnosticsEngine($c$.track(new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs())), 
        new DiagnosticOptions(), 
        new IgnoringDiagConsumer()));
    Diags.setSuppressAllDiagnostics(true);
    {
      DiagnosticErrorTrap trap/*J*/= new DiagnosticErrorTrap(Diags);
      
      // Diag that would set UncompilableErrorOccurred and ErrorOccurred.
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_target_unknown_triple)), /*KEEP_STR*/$unknown));
      
      // Diag that would set UnrecoverableErrorOccurred and ErrorOccurred.
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_cannot_open_file)), /*KEEP_STR*/"file"), /*KEEP_STR*/$error));
      
      // Diag that would set FatalErrorOccurred
      // (via non-note following a fatal error).
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.warn_mt_message)), /*KEEP_STR*/$warning));
    EXPECT_TRUE(trap.hasErrorOccurred());
    EXPECT_TRUE(trap.hasUnrecoverableErrorOccurred());
    }
    EXPECT_FALSE(Diags.hasErrorOccurred());
    EXPECT_FALSE(Diags.hasFatalErrorOccurred());
    EXPECT_FALSE(Diags.hasUncompilableErrorOccurred());
    EXPECT_FALSE(Diags.hasUnrecoverableErrorOccurred());
  } finally {
    if (Diags != null) { Diags.$destroy(); }
    $c$.$destroy();
  }
}


// Check that FatalsAsErrors works as intended
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagnosticTest_fatalsAsErrors_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/DiagnosticTest.cpp", line = 50,
 FQN="(anonymous namespace)::DiagnosticTest_fatalsAsErrors_Test::TestBody", NM="_ZN12_GLOBAL__N_134DiagnosticTest_fatalsAsErrors_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/DiagnosticTest.cpp -nm=_ZN12_GLOBAL__N_134DiagnosticTest_fatalsAsErrors_Test8TestBodyEv")
//</editor-fold>
public void test_fatalsAsErrors() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  DiagnosticsEngine Diags = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Diags/*J*/= $c$.clean(new DiagnosticsEngine($c$.track(new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs())), 
        new DiagnosticOptions(), 
        new IgnoringDiagConsumer()));
    Diags.setFatalsAsError(true);
    
    // Diag that would set UncompilableErrorOccurred and ErrorOccurred.
    $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_target_unknown_triple)), /*KEEP_STR*/$unknown));
    
    // Diag that would set UnrecoverableErrorOccurred and ErrorOccurred.
    $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_cannot_open_file)), /*KEEP_STR*/"file"), /*KEEP_STR*/$error));
    
    // Diag that would set FatalErrorOccurred
    // (via non-note following a fatal error).
    $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.warn_mt_message)), /*KEEP_STR*/$warning));
    EXPECT_TRUE(Diags.hasErrorOccurred());
    EXPECT_FALSE(Diags.hasFatalErrorOccurred());
    EXPECT_TRUE(Diags.hasUncompilableErrorOccurred());
    EXPECT_TRUE(Diags.hasUnrecoverableErrorOccurred());
  } finally {
    if (Diags != null) { Diags.$destroy(); }
    $c$.$destroy();
  }
}

//} JAVA: end of namespace (anonymous)
//JAVA: using namespace 
} // END OF class DiagnosticTest
