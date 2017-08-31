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

package org.llvm.analysis.target;

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
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// \brief Analysis pass providing the \c TargetTransformInfo.
///
/// The core idea of the TargetIRAnalysis is to expose an interface through
/// which LLVM targets can analyze and provide information about the middle
/// end's target-independent IR. This supports use cases such as target-aware
/// cost modeling of IR constructs.
///
/// This is a function analysis because much of the cost modeling for targets
/// is done in a subtarget specific way and LLVM supports compiling different
/// functions targeting different subtargets in order to support runtime
/// dispatch according to the observed subtarget.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 998,
 FQN="llvm::TargetIRAnalysis", NM="_ZN4llvm16TargetIRAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysisE")
//</editor-fold>
public class TargetIRAnalysis implements /*public*/ AnalysisInfoMixin<TargetIRAnalysis>, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef TargetTransformInfo Result
//  public final class Result extends TargetTransformInfo{ };

  /// \brief Default construct a target IR analysis.
  ///
  /// This will use the module's datalayout to construct a baseline
  /// conservative TTI result.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::TargetIRAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 422,
   FQN="llvm::TargetIRAnalysis::TargetIRAnalysis", NM="_ZN4llvm16TargetIRAnalysisC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysisC1Ev")
  //</editor-fold>
  public TargetIRAnalysis() {
    // : AnalysisInfoMixin<TargetIRAnalysis>(), TTICallback(&FPtrTargetIRAnalysis::getDefaultTTI)
    //START JInit
    super();
    this.TTICallback = /*FuncArg*//*AddrOf*//*FPtr*/TargetIRAnalysis::getDefaultTTI;
    //END JInit
  }


  /// \brief Construct an IR analysis pass around a target-provide callback.
  ///
  /// The callback will be called with a particular function for which the TTI
  /// is needed and must return a TTI object for that function.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::TargetIRAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 424,
   FQN="llvm::TargetIRAnalysis::TargetIRAnalysis", NM="_ZN4llvm16TargetIRAnalysisC1ESt8functionIFNS_19TargetTransformInfoERKNS_8FunctionEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysisC1ESt8functionIFNS_19TargetTransformInfoERKNS_8FunctionEEE")
  //</editor-fold>
  public TargetIRAnalysis(Function2TargetTransformInfo TTICallback) {
    // : AnalysisInfoMixin<TargetIRAnalysis>(), TTICallback(std::move(TTICallback))
    //START JInit
    super();
    this.TTICallback = /*FuncArg*/std.move(TTICallback);
    //END JInit
  }


  // Value semantics. We spell out the constructors for MSVC.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::TargetIRAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 1015,
   FQN="llvm::TargetIRAnalysis::TargetIRAnalysis", NM="_ZN4llvm16TargetIRAnalysisC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysisC1ERKS0_")
  //</editor-fold>
  public TargetIRAnalysis(final /*const*/ TargetIRAnalysis /*&*/ Arg) {
    // : AnalysisInfoMixin<TargetIRAnalysis>(), TTICallback(Arg.TTICallback)
    //START JInit
    super();
    this.TTICallback = /*FuncArg*/Arg.TTICallback;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::TargetIRAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 1017,
   FQN="llvm::TargetIRAnalysis::TargetIRAnalysis", NM="_ZN4llvm16TargetIRAnalysisC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysisC1EOS0_")
  //</editor-fold>
  public TargetIRAnalysis(JD$Move _dparam, final TargetIRAnalysis /*&&*/Arg) {
    // : AnalysisInfoMixin<TargetIRAnalysis>(), TTICallback(std::move(Arg.TTICallback))
    //START JInit
    super();
    this.TTICallback = /*FuncArg*/std.move(Arg.TTICallback);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 1019,
   FQN="llvm::TargetIRAnalysis::operator=", NM="_ZN4llvm16TargetIRAnalysisaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysisaSERKS0_")
  //</editor-fold>
  public TargetIRAnalysis /*&*/ $assign(final /*const*/ TargetIRAnalysis /*&*/ RHS) {
    TTICallback = RHS.TTICallback;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 1023,
   FQN="llvm::TargetIRAnalysis::operator=", NM="_ZN4llvm16TargetIRAnalysisaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysisaSEOS0_")
  //</editor-fold>
  public TargetIRAnalysis /*&*/ $assignMove(final TargetIRAnalysis /*&&*/RHS) {
    TTICallback = std.move(RHS.TTICallback);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 428,
   FQN="llvm::TargetIRAnalysis::run", NM="_ZN4llvm16TargetIRAnalysis3runERKNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysis3runERKNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public TargetTransformInfo run(final /*const*/ Function /*&*/ F,
     final AnalysisManager<Function>/*&*/ $Prm1) {
    return TTICallback.$call(F);
  }

/*private:*/
  /*friend  AnalysisInfoMixin<TargetIRAnalysis>*/
  private static /*char*/byte PassID;

  /// \brief The callback used to produce a result.
  ///
  /// We use a completely opaque callback so that targets can provide whatever
  /// mechanism they desire for constructing the TTI for a given function.
  ///
  /// FIXME: Should we really use std::function? It's relatively inefficient.
  /// It might be possible to arrange for even stateful callbacks to outlive
  /// the analysis and thus use a function_ref which would be lighter weight.
  /// This may also be less error prone as the callback is likely to reference
  /// the external TargetMachine, and that reference needs to never dangle.
  private Function2TargetTransformInfo TTICallback;

  /// \brief Helper function used as the callback in the default constructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::getDefaultTTI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 435,
   FQN="llvm::TargetIRAnalysis::getDefaultTTI", NM="_ZN4llvm16TargetIRAnalysis13getDefaultTTIERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysis13getDefaultTTIERKNS_8FunctionE")
  //</editor-fold>
  private static TargetTransformInfo getDefaultTTI(final /*const*/ Function /*&*/ F) {
    return new TargetTransformInfo(F.getParent$Const().getDataLayout());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetIRAnalysis::~TargetIRAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 998,
   FQN="llvm::TargetIRAnalysis::~TargetIRAnalysis", NM="_ZN4llvm16TargetIRAnalysisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm16TargetIRAnalysisD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    if (TTICallback instanceof Destructors.ClassWithDestructor) {
      ((Destructors.ClassWithDestructor) TTICallback).$destroy();
    }
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "TTICallback=" + TTICallback // NOI18N
              + super.toString(); // NOI18N
  }
}
