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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// \brief Create a verifier pass.
///
/// Check a module or function for validity. This is essentially a pass wrapped
/// around the above verifyFunction and verifyModule routines and
/// functionality. When the pass detects a verification error it is always
/// printed to stderr, and by default they are fatal. You can override that by
/// passing \c false to \p FatalErrors.
///
/// Note that this creates a pass suitable for the legacy pass manager. It has
/// nothing to do with \c VerifierPass.
//<editor-fold defaultstate="collapsed" desc="llvm::VerifierPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 87,
 FQN="llvm::VerifierPass", NM="_ZN4llvm12VerifierPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm12VerifierPassE")
//</editor-fold>
public class VerifierPass implements /*public*/ PassInfoMixin<VerifierPass>, IPassModule<PreservedAnalyses>, IPassFunction<PreservedAnalyses> {
  private boolean FatalErrors;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierPass::VerifierPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 91,
   FQN="llvm::VerifierPass::VerifierPass", NM="_ZN4llvm12VerifierPassC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm12VerifierPassC1Eb")
  //</editor-fold>
  public /*explicit*/ VerifierPass() {
    this(true);
  }
  public /*explicit*/ VerifierPass(boolean FatalErrors/*= true*/) {
    // : PassInfoMixin<VerifierPass>(), FatalErrors(FatalErrors)
    //START JInit
    $PassInfoMixin();
    this.FatalErrors = FatalErrors;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierPass::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4387,
   FQN="llvm::VerifierPass::run", NM="_ZN4llvm12VerifierPass3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12VerifierPass3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Module /*&*/ M, final AnalysisManager<Module> /*&*/ AM) {
    VerifierAnalysis.Result Res = new VerifierAnalysis.Result(AM.getResult(VerifierAnalysis.class, M));
    if (FatalErrors) {
      if (Res.IRBroken) {
        report_fatal_error($("Broken module found, compilation aborted!"));
      }
      assert (!Res.DebugInfoBroken) : "Module contains invalid debug info";
    }

    // Strip broken debug info.
    if (Res.DebugInfoBroken) {
      DiagnosticInfoIgnoringInvalidDebugMetadata DiagInvalid = null;
      try {
        DiagInvalid/*J*/= new DiagnosticInfoIgnoringInvalidDebugMetadata(M);
        M.getContext().diagnose(DiagInvalid);
        if (!IrLlvmGlobals.StripDebugInfo(M)) {
          report_fatal_error($("Failed to strip malformed debug info"));
        }
      } finally {
        if (DiagInvalid != null) { DiagInvalid.$destroy(); }
      }
    }
    return PreservedAnalyses.all();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierPass::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4405,
   FQN="llvm::VerifierPass::run", NM="_ZN4llvm12VerifierPass3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12VerifierPass3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Function /*&*/ F, final AnalysisManager<Function> /*&*/ AM) {
    VerifierAnalysis.Result res = new VerifierAnalysis.Result(AM.getResult(VerifierAnalysis.class, F));
    if (res.IRBroken && FatalErrors) {
      report_fatal_error($("Broken function found, compilation aborted!"));
    }

    return PreservedAnalyses.all();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierPass::VerifierPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 87,
   FQN="llvm::VerifierPass::VerifierPass", NM="_ZN4llvm12VerifierPassC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm12VerifierPassC1EOS0_")
  //</editor-fold>
  public /*inline*/ VerifierPass(JD$Move _dparam, final VerifierPass /*&&*/$Prm0) {
    // : PassInfoMixin<VerifierPass>(static_cast<VerifierPass &&>()), FatalErrors(static_cast<VerifierPass &&>().FatalErrors)
    //START JInit
    $PassInfoMixin(JD$Move.INSTANCE, $Prm0);
    this.FatalErrors = $Prm0.FatalErrors;
    //END JInit
  }


  @Override public String toString() {
    return "" + "FatalErrors=" + FatalErrors // NOI18N
              + super.toString(); // NOI18N
  }
}
