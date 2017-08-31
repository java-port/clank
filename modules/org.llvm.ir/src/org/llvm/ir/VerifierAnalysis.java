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


/// Check a module for errors, and report separate error states for IR
/// and debug info errors.
//<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 59,
 FQN="llvm::VerifierAnalysis", NM="_ZN4llvm16VerifierAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm16VerifierAnalysisE")
//</editor-fold>
  public class VerifierAnalysis implements /*public*/ AnalysisInfoMixin<VerifierAnalysis> {
  /*friend  AnalysisInfoMixin<VerifierAnalysis>*/
  private static /*char*/byte PassID;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis::Result">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 64,
   FQN="llvm::VerifierAnalysis::Result", NM="_ZN4llvm16VerifierAnalysis6ResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm16VerifierAnalysis6ResultE")
  //</editor-fold>
  public static class/*struct*/ Result {
    public boolean IRBroken;
    public boolean DebugInfoBroken;
    //<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis::Result::Result">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 64,
     FQN="llvm::VerifierAnalysis::Result::Result", NM="_ZN4llvm16VerifierAnalysis6ResultC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm16VerifierAnalysis6ResultC1EOS1_")
    //</editor-fold>
    public /*inline*/ Result(JD$Move _dparam, final Result /*&&*/$Prm0) {
      // : IRBroken(static_cast<Result &&>().IRBroken), DebugInfoBroken(static_cast<Result &&>().DebugInfoBroken)
      //START JInit
      this.IRBroken = $Prm0.IRBroken;
      this.DebugInfoBroken = $Prm0.DebugInfoBroken;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis::Result::Result">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 64,
     FQN="llvm::VerifierAnalysis::Result::Result", NM="_ZN4llvm16VerifierAnalysis6ResultC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm16VerifierAnalysis6ResultC1Ev")
    //</editor-fold>
    public /*inline*/ Result() {
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis::Result::Result">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 64,
     FQN="llvm::VerifierAnalysis::Result::Result", NM="_ZN4llvm16VerifierAnalysis6ResultC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm16VerifierAnalysis6ResultC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Result(final /*const*/ Result /*&*/ $Prm0) {
      // : IRBroken(.IRBroken), DebugInfoBroken(.DebugInfoBroken)
      //START JInit
      this.IRBroken = $Prm0.IRBroken;
      this.DebugInfoBroken = $Prm0.DebugInfoBroken;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public Result(boolean IRBroken, boolean DebugInfoBroken) { this.IRBroken = IRBroken; this.DebugInfoBroken = DebugInfoBroken; }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "IRBroken=" + IRBroken // NOI18N
                + ", DebugInfoBroken=" + DebugInfoBroken; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis::ID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 67,
   FQN="llvm::VerifierAnalysis::ID", NM="_ZN4llvm16VerifierAnalysis2IDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm16VerifierAnalysis2IDEv")
  //</editor-fold>
  public static Object/*void P*/ ID() {
    return reinterpret_cast(Object/*void P*/ .class, $AddrOf(PassID));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4375,
   FQN="llvm::VerifierAnalysis::run", NM="_ZN4llvm16VerifierAnalysis3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm16VerifierAnalysis3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public VerifierAnalysis.Result run(final Module /*&*/ M,
     final AnalysisManager<Module> /*&*/ $Prm1) {
    Result Res/*J*/= new Result();
    bool$ptr DebugInfoBroken$Ptr = create_bool$ptr(Res.DebugInfoBroken);
    Res.IRBroken = VerifierLlvmGlobals.verifyModule(M, $AddrOf(dbgs()), DebugInfoBroken$Ptr);
    Res.DebugInfoBroken = DebugInfoBroken$Ptr.$star();
    return Res;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4382,
   FQN="llvm::VerifierAnalysis::run", NM="_ZN4llvm16VerifierAnalysis3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm16VerifierAnalysis3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public VerifierAnalysis.Result run(final Function /*&*/ F,
     final AnalysisManager<Function> /*&*/ $Prm1) {
    return /*JAVA:InitListExpr*/new VerifierAnalysis.Result(VerifierLlvmGlobals.verifyFunction(F, $AddrOf(dbgs())), false);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::VerifierAnalysis::VerifierAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Verifier.h", line = 59,
   FQN="llvm::VerifierAnalysis::VerifierAnalysis", NM="_ZN4llvm16VerifierAnalysisC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm16VerifierAnalysisC1EOS0_")
  //</editor-fold>
  public /*inline*/ VerifierAnalysis(JD$Move _dparam, final VerifierAnalysis /*&&*/$Prm0) {
    // : AnalysisInfoMixin<VerifierAnalysis>(static_cast<VerifierAnalysis &&>())
    //START JInit
    $AnalysisInfoMixin(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
