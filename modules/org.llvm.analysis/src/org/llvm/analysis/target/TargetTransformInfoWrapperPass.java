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
import org.llvm.adt.Optional;
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
import org.llvm.analysis.target.impl.TargetTransformInfoLlvmStatics;


/// \brief Wrapper pass for TargetTransformInfo.
///
/// This pass can be constructed from a TTI object which it stores internally
/// and is queried by passes.
//<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoWrapperPass">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 1054,
 FQN="llvm::TargetTransformInfoWrapperPass", NM="_ZN4llvm30TargetTransformInfoWrapperPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm30TargetTransformInfoWrapperPassE")
//</editor-fold>
public class TargetTransformInfoWrapperPass extends /*public*/ ImmutablePass implements Destructors.ClassWithDestructor {
  private TargetIRAnalysis TIRA;
  private Optional<TargetTransformInfo> TTI;

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoWrapperPass::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 444,
   FQN="llvm::TargetTransformInfoWrapperPass::anchor", NM="_ZN4llvm30TargetTransformInfoWrapperPass6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm30TargetTransformInfoWrapperPass6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  public static final/*char*/Class<TargetTransformInfoWrapperPass> ID = TargetTransformInfoWrapperPass.class;// it is effectively const in C++

  /// \brief We must provide a default constructor for the pass but it should
  /// never be used.
  ///
  /// Use the constructor below or call one of the creation routines.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoWrapperPass::TargetTransformInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 446,
   FQN="llvm::TargetTransformInfoWrapperPass::TargetTransformInfoWrapperPass", NM="_ZN4llvm30TargetTransformInfoWrapperPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm30TargetTransformInfoWrapperPassC1Ev")
  //</editor-fold>
  public TargetTransformInfoWrapperPass() {
    // : ImmutablePass(ID), TIRA(), TTI()
    //START JInit
    super(ID);
    this.TIRA = new TargetIRAnalysis();
    this.TTI = new Optional<TargetTransformInfo>();
    //END JInit
    TargetTransformInfoLlvmStatics.initializeTargetTransformInfoWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoWrapperPass::TargetTransformInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 452,
   FQN="llvm::TargetTransformInfoWrapperPass::TargetTransformInfoWrapperPass", NM="_ZN4llvm30TargetTransformInfoWrapperPassC1ENS_16TargetIRAnalysisE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm30TargetTransformInfoWrapperPassC1ENS_16TargetIRAnalysisE")
  //</editor-fold>
  public TargetTransformInfoWrapperPass(TargetIRAnalysis TIRA) {
    // : ImmutablePass(ID), TIRA(std::move(TIRA)), TTI()
    //START JInit
    super(ID);
    this.TIRA = new TargetIRAnalysis(JD$Move.INSTANCE, std.move(TIRA));
    this.TTI = new Optional<TargetTransformInfo>();
    //END JInit
    TargetTransformInfoLlvmStatics.initializeTargetTransformInfoWrapperPassPass($Deref(PassRegistry.getPassRegistry()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoWrapperPass::getTTI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 459,
   FQN="llvm::TargetTransformInfoWrapperPass::getTTI", NM="_ZN4llvm30TargetTransformInfoWrapperPass6getTTIERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm30TargetTransformInfoWrapperPass6getTTIERKNS_8FunctionE")
  //</editor-fold>
  public TargetTransformInfo /*&*/ getTTI(final /*const*/ Function /*&*/ F) {
    AnalysisManager<Function> DummyFAM = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DummyFAM/*J*/= new AnalysisManager<Function>();
      $c$.clean(TTI.$assign_T$RR($c$.track(TIRA.run(F, DummyFAM))));
      return TTI.$star();
    } finally {
      if (DummyFAM != null) { DummyFAM.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetTransformInfoWrapperPass::~TargetTransformInfoWrapperPass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 1054,
   FQN="llvm::TargetTransformInfoWrapperPass::~TargetTransformInfoWrapperPass", NM="_ZN4llvm30TargetTransformInfoWrapperPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm30TargetTransformInfoWrapperPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    TTI.$destroy();
    TIRA.$destroy();
    super.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "TIRA=" + TIRA // NOI18N
              + ", TTI=" + TTI // NOI18N
              + super.toString(); // NOI18N
  }
}
