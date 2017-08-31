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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/OptimizationDiagnosticInfo.h", line = 32,
 FQN="llvm::OptimizationRemarkEmitter", NM="_ZN4llvm25OptimizationRemarkEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitterE")
//</editor-fold>
public class OptimizationRemarkEmitter {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter::OptimizationRemarkEmitter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/OptimizationDiagnosticInfo.h", line = 34,
   FQN="llvm::OptimizationRemarkEmitter::OptimizationRemarkEmitter", NM="_ZN4llvm25OptimizationRemarkEmitterC1EPNS_8FunctionEPNS_18BlockFrequencyInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitterC1EPNS_8FunctionEPNS_18BlockFrequencyInfoE")
  //</editor-fold>
  public OptimizationRemarkEmitter(Function /*P*/ F, BlockFrequencyInfo /*P*/ BFI) {
    // : F(F), BFI(BFI) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter::OptimizationRemarkEmitter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/OptimizationDiagnosticInfo.h", line = 37,
   FQN="llvm::OptimizationRemarkEmitter::OptimizationRemarkEmitter", NM="_ZN4llvm25OptimizationRemarkEmitterC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitterC1EOS0_")
  //</editor-fold>
  public OptimizationRemarkEmitter(JD$Move _dparam, final OptimizationRemarkEmitter /*&&*/Arg) {
    // : F(Arg.F), BFI(Arg.BFI) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/OptimizationDiagnosticInfo.h", line = 40,
   FQN="llvm::OptimizationRemarkEmitter::operator=", NM="_ZN4llvm25OptimizationRemarkEmitteraSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitteraSEOS0_")
  //</editor-fold>
  public OptimizationRemarkEmitter /*&*/ $assignMove(final OptimizationRemarkEmitter /*&&*/RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emit an optimization-missed message.
  ///
  /// \p PassName is the name of the pass emitting the message. If
  /// -Rpass-missed= is given and the name matches the regular expression in
  /// -Rpass, then the remark will be emitted. \p Fn is the function triggering
  /// the remark, \p DLoc is the debug location where the diagnostic is
  /// generated. \p V is the IR Value that identifies the code region. \p Msg is
  /// the message string to use.
  //<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter::emitOptimizationRemarkMissed">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp", line = 30,
   FQN="llvm::OptimizationRemarkEmitter::emitOptimizationRemarkMissed", NM="_ZN4llvm25OptimizationRemarkEmitter28emitOptimizationRemarkMissedEPKcRKNS_8DebugLocEPNS_5ValueERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitter28emitOptimizationRemarkMissedEPKcRKNS_8DebugLocEPNS_5ValueERKNS_5TwineE")
  //</editor-fold>
  public void emitOptimizationRemarkMissed(/*const*/char$ptr/*char P*/ PassName, final /*const*/ DebugLoc /*&*/ DLoc, Value /*P*/ V, final /*const*/ Twine /*&*/ Msg) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Same as above but derives the IR Value for the code region and the
  /// debug location from the Loop parameter \p L.
  //<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter::emitOptimizationRemarkMissed">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp", line = 37,
   FQN="llvm::OptimizationRemarkEmitter::emitOptimizationRemarkMissed", NM="_ZN4llvm25OptimizationRemarkEmitter28emitOptimizationRemarkMissedEPKcPNS_4LoopERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitter28emitOptimizationRemarkMissedEPKcPNS_4LoopERKNS_5TwineE")
  //</editor-fold>
  public void emitOptimizationRemarkMissed(/*const*/char$ptr/*char P*/ PassName, Loop /*P*/ L, final /*const*/ Twine /*&*/ Msg) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private Function /*P*/ F;
  
  private BlockFrequencyInfo /*P*/ BFI;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter::computeHotness">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp", line = 23,
   FQN="llvm::OptimizationRemarkEmitter::computeHotness", NM="_ZN4llvm25OptimizationRemarkEmitter14computeHotnessEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitter14computeHotnessEPNS_5ValueE")
  //</editor-fold>
  private OptionalULong computeHotness(Value /*P*/ V) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter::OptimizationRemarkEmitter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/OptimizationDiagnosticInfo.h", line = 69,
   FQN="llvm::OptimizationRemarkEmitter::OptimizationRemarkEmitter", NM="_ZN4llvm25OptimizationRemarkEmitterC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitterC1ERKS0_")
  //</editor-fold>
  protected/*private*/ OptimizationRemarkEmitter(final /*const*/ OptimizationRemarkEmitter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::OptimizationRemarkEmitter::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/OptimizationDiagnosticInfo.h", line = 70,
   FQN="llvm::OptimizationRemarkEmitter::operator=", NM="_ZN4llvm25OptimizationRemarkEmitteraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm25OptimizationRemarkEmitteraSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ OptimizationRemarkEmitter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  @Override public String toString() {
    return "" + "F=" + F // NOI18N
              + ", BFI=" + BFI; // NOI18N
  }
}
