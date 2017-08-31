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

//<editor-fold defaultstate="collapsed" desc="llvm::LoopPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 29,
 FQN="llvm::LoopPass", NM="_ZN4llvm8LoopPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPassE")
//</editor-fold>
public abstract class LoopPass extends /*public*/ Pass implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::LoopPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 31,
   FQN="llvm::LoopPass::LoopPass", NM="_ZN4llvm8LoopPassC1ERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPassC1ERc")
  //</editor-fold>
  public /*explicit*/ LoopPass(final Class<? extends LoopPass>/*char &*/ pid) {
    // : Pass(PT_Loop, pid) 
    super(PassKind.PT_Loop, pid);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getPrinterPass - Get a pass to print the function corresponding
  /// to a Loop.
  
  //===----------------------------------------------------------------------===//
  // LoopPass
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 278,
   FQN="llvm::LoopPass::createPrinterPass", NM="_ZNK4llvm8LoopPass17createPrinterPassERNS_11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZNK4llvm8LoopPass17createPrinterPassERNS_11raw_ostreamERKSs")
  //</editor-fold>
  @Override public Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O, 
                   final /*const*/std.string/*&*/ Banner) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // runOnLoop - This method should be implemented by the subclass to perform
  // whatever action is necessary for the specified Loop.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::runOnLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 40,
   FQN="llvm::LoopPass::runOnLoop", NM="_ZN4llvm8LoopPass9runOnLoopEPNS_4LoopERNS_13LPPassManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPass9runOnLoopEPNS_4LoopERNS_13LPPassManagerE")
  //</editor-fold>
  public abstract /*virtual*/ boolean runOnLoop(Loop /*P*/ L, final LPPassManager /*&*/ LPM)/* = 0*/;

  
  //JAVA: using llvm::Pass::doInitialization;
  //JAVA: using llvm::Pass::doFinalization;
  
  // Initialization and finalization hooks.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::doInitialization">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 46,
   FQN="llvm::LoopPass::doInitialization", NM="_ZN4llvm8LoopPass16doInitializationEPNS_4LoopERNS_13LPPassManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPass16doInitializationEPNS_4LoopERNS_13LPPassManagerE")
  //</editor-fold>
  public /*virtual*/ boolean doInitialization(Loop /*P*/ L, final LPPassManager /*&*/ LPM) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Finalization hook does not supply Loop because at this time
  // loop nest is completely different.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::doFinalization">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 52,
   FQN="llvm::LoopPass::doFinalization", NM="_ZN4llvm8LoopPass14doFinalizationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPass14doFinalizationEv")
  //</editor-fold>
  public /*virtual*/ boolean doFinalization() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Check if this pass is suitable for the current LPPassManager, if
  // available. This pass P is not suitable for a LPPassManager if P
  // is not preserving higher level analysis info used by other
  // LPPassManager passes. In such case, pop LPPassManager from the
  // stack. This will force assignPassManager() to create new
  // LPPassManger as expected.
  
  // Check if this pass is suitable for the current LPPassManager, if
  // available. This pass P is not suitable for a LPPassManager if P
  // is not preserving higher level analysis info used by other
  // LPPassManager passes. In such case, pop LPPassManager from the
  // stack. This will force assignPassManager() to create new
  // LPPassManger as expected.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::preparePassManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 289,
   FQN="llvm::LoopPass::preparePassManager", NM="_ZN4llvm8LoopPass18preparePassManagerERNS_7PMStackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPass18preparePassManagerERNS_7PMStackE")
  //</editor-fold>
  @Override public void preparePassManager(final PMStack /*&*/ PMS)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Assign pass manager to manage this pass
  
  /// Assign pass manager to manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::assignPassManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 305,
   FQN="llvm::LoopPass::assignPassManager", NM="_ZN4llvm8LoopPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE")
  //</editor-fold>
  @Override public void assignPassManager(final PMStack /*&*/ PMS, 
                   PassManagerType PreferredType)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  ///  Return what kind of Pass Manager can manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::getPotentialPassManagerType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 66,
   FQN="llvm::LoopPass::getPotentialPassManagerType", NM="_ZNK4llvm8LoopPass27getPotentialPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZNK4llvm8LoopPass27getPotentialPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPotentialPassManagerType() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  /// SimpleAnalysis - Provides simple interface to update analysis info
  /// maintained by various passes. Note, if required this interface can
  /// be extracted into a separate abstract class but it would require
  /// additional use of multiple inheritance in Pass class hierarchy, something
  /// we are trying to avoid.
  
  /// Each loop pass can override these simple analysis hooks to update
  /// desired analysis information.
  /// cloneBasicBlockAnalysis - Clone analysis info associated with basic block.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::cloneBasicBlockAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 80,
   FQN="llvm::LoopPass::cloneBasicBlockAnalysis", NM="_ZN4llvm8LoopPass23cloneBasicBlockAnalysisEPNS_10BasicBlockES2_PNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPass23cloneBasicBlockAnalysisEPNS_10BasicBlockES2_PNS_4LoopE")
  //</editor-fold>
  public /*virtual*/ void cloneBasicBlockAnalysis(BasicBlock /*P*/ F, BasicBlock /*P*/ T, Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// deleteAnalysisValue - Delete analysis info associated with value V.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::deleteAnalysisValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 83,
   FQN="llvm::LoopPass::deleteAnalysisValue", NM="_ZN4llvm8LoopPass19deleteAnalysisValueEPNS_5ValueEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPass19deleteAnalysisValueEPNS_5ValueEPNS_4LoopE")
  //</editor-fold>
  public /*virtual*/ void deleteAnalysisValue(Value /*P*/ V, Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Delete analysis info associated with Loop L.
  /// Called to notify a Pass that a loop has been deleted and any
  /// associated analysis values can be deleted.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::deleteAnalysisLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 88,
   FQN="llvm::LoopPass::deleteAnalysisLoop", NM="_ZN4llvm8LoopPass18deleteAnalysisLoopEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPass18deleteAnalysisLoopEPNS_4LoopE")
  //</editor-fold>
  public /*virtual*/ void deleteAnalysisLoop(Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*protected:*/
  /// Optional passes call this function to check whether the pass should be
  /// skipped. This is the case when Attribute::OptimizeNone is set or when
  /// optimization bisect is over the limit.
  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::skipLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 340,
   FQN="llvm::LoopPass::skipLoop", NM="_ZNK4llvm8LoopPass8skipLoopEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZNK4llvm8LoopPass8skipLoopEPKNS_4LoopE")
  //</editor-fold>
  protected boolean skipLoop(/*const*/ Loop /*P*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LoopPass::~LoopPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 29,
   FQN="llvm::LoopPass::~LoopPass", NM="_ZN4llvm8LoopPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm8LoopPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
