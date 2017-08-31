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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import static org.llvm.ir.impl.DiagnosticInfoStatics.PassRemarksAnalysisOptLoc;


/// Diagnostic information for optimization analysis remarks.
//<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 476,
 FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysis", NM="_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysisE")
//</editor-fold>
public class DiagnosticInfoOptimizationRemarkAnalysis extends /*public*/ DiagnosticInfoOptimizationBase implements Destructors.ClassWithDestructor {
/*public:*/
  /// \p PassName is the name of the pass emitting this diagnostic. If
  /// this name matches the regular expression given in -Rpass-analysis=, then
  /// the diagnostic will be emitted. \p Fn is the function where the diagnostic
  /// is being emitted. \p DLoc is the location information to use in the
  /// diagnostic. If line table information is available, the diagnostic will
  /// include the source code location. \p Msg is the message to show. Note that
  /// this class does not copy this message, so this reference must be valid for
  /// the whole life time of the diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysis::DiagnosticInfoOptimizationRemarkAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 487,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysis::DiagnosticInfoOptimizationRemarkAnalysis", NM="_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysisC1EPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysisC1EPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
  //</editor-fold>
  public DiagnosticInfoOptimizationRemarkAnalysis(/*const*/char$ptr/*char P*/ PassName,
      final /*const*/ Function /*&*/ Fn,
      final /*const*/ DebugLoc /*&*/ DLoc,
      final /*const*/ Twine /*&*/ Msg) {
    // : DiagnosticInfoOptimizationBase(DK_OptimizationRemarkAnalysis, DS_Remark, PassName, Fn, DLoc, Msg)
    //START JInit
    /*ExprWithCleanups*/super(DiagnosticKind.DK_OptimizationRemarkAnalysis, DiagnosticSeverity.DS_Remark,
        PassName, Fn, DLoc, Msg);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysis::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 494,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysis::classof", NM="_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysis7classofEPKNS_14DiagnosticInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysis7classofEPKNS_14DiagnosticInfoE")
  //</editor-fold>
  public static boolean classof(/*const*/ DiagnosticInfo /*P*/ DI) {
    return DI.getKind() == DiagnosticKind.DK_OptimizationRemarkAnalysis.getValue();
  }


  /// \see DiagnosticInfoOptimizationBase::isEnabled.
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysis::isEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp", line = 189,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysis::isEnabled", NM="_ZNK4llvm40DiagnosticInfoOptimizationRemarkAnalysis9isEnabledEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm40DiagnosticInfoOptimizationRemarkAnalysis9isEnabledEv")
  //</editor-fold>
  @Override public boolean isEnabled() /*const*//* override*/ {
    return shouldAlwaysPrint()
       || (PassRemarksAnalysisOptLoc.Pattern.$bool()
       && PassRemarksAnalysisOptLoc.Pattern.$arrow().match(/*STRINGREF_STR*/getPassName()));
  }


  public static /*const*/char$ptr/*char P*/ AlwaysPrint = $EMPTY;

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysis::shouldAlwaysPrint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 503,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysis::shouldAlwaysPrint", NM="_ZNK4llvm40DiagnosticInfoOptimizationRemarkAnalysis17shouldAlwaysPrintEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZNK4llvm40DiagnosticInfoOptimizationRemarkAnalysis17shouldAlwaysPrintEv")
  //</editor-fold>
  public boolean shouldAlwaysPrint() /*const*/ {
    return $eq_ptr(getPassName(), AlwaysPrint);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysis::DiagnosticInfoOptimizationRemarkAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 506,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysis::DiagnosticInfoOptimizationRemarkAnalysis", NM="_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysisC1ENS_14DiagnosticKindEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysisC1ENS_14DiagnosticKindEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
  //</editor-fold>
  protected DiagnosticInfoOptimizationRemarkAnalysis( DiagnosticKind Kind,
      /*const*/char$ptr/*char P*/ PassName,
      final /*const*/ Function /*&*/ Fn,
      final /*const*/ DebugLoc /*&*/ DLoc,
      final /*const*/ Twine /*&*/ Msg) {
    // : DiagnosticInfoOptimizationBase(Kind, DS_Remark, PassName, Fn, DLoc, Msg)
    //START JInit
    /*ExprWithCleanups*/super(Kind, DiagnosticSeverity.DS_Remark, PassName, Fn, DLoc,
        Msg);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DiagnosticInfoOptimizationRemarkAnalysis::~DiagnosticInfoOptimizationRemarkAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 476,
   FQN="llvm::DiagnosticInfoOptimizationRemarkAnalysis::~DiagnosticInfoOptimizationRemarkAnalysis", NM="_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DiagnosticInfo.cpp -nm=_ZN4llvm40DiagnosticInfoOptimizationRemarkAnalysisD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
