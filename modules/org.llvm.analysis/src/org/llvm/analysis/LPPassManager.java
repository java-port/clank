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

//<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 97,
 FQN="llvm::LPPassManager", NM="_ZN4llvm13LPPassManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManagerE")
//</editor-fold>
public class LPPassManager extends /*public*/ FunctionPass implements /*public*/ PMDataManager, Destructors.ClassWithDestructor {
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // LPPassManager
  //
  public static final/*char*/Class<LPPassManager> ID = LPPassManager.class;
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::LPPassManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 67,
   FQN="llvm::LPPassManager::LPPassManager", NM="_ZN4llvm13LPPassManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManagerC1Ev")
  //</editor-fold>
  public LPPassManager() {
    // : FunctionPass(ID), PMDataManager(), LQ() 
    super(ID);
    //this.PMDataManager$Flds = $PMDataManager();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// run - Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the module, and if so, return true.
  
  /// run - Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the function, and if so, return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 148,
   FQN="llvm::LPPassManager::runOnFunction", NM="_ZN4llvm13LPPassManager13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Pass Manager itself does not invalidate any analysis info.
  // LPPassManager needs LoopInfo.
  
  /// Pass Manager itself does not invalidate any analysis info.
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 139,
   FQN="llvm::LPPassManager::getAnalysisUsage", NM="_ZNK4llvm13LPPassManager16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZNK4llvm13LPPassManager16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ Info) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::getPassName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 110,
   FQN="llvm::LPPassManager::getPassName", NM="_ZNK4llvm13LPPassManager11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZNK4llvm13LPPassManager11getPassNameEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getPassName() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 114,
   FQN="llvm::LPPassManager::getAsPMDataManager", NM="_ZN4llvm13LPPassManager18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager18getAsPMDataManagerEv")
  //</editor-fold>
  @Override public PMDataManager /*P*/ getAsPMDataManager()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::getAsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 115,
   FQN="llvm::LPPassManager::getAsPass", NM="_ZN4llvm13LPPassManager9getAsPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager9getAsPassEv")
  //</editor-fold>
  @Override public Pass /*P*/ getAsPass()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Print passes managed by this manager
  
  /// Print passes managed by this manager
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::dumpPassStructure">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 265,
   FQN="llvm::LPPassManager::dumpPassStructure", NM="_ZN4llvm13LPPassManager17dumpPassStructureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager17dumpPassStructureEj")
  //</editor-fold>
  @Override public void dumpPassStructure(/*uint*/int Offset)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::getContainedPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 120,
   FQN="llvm::LPPassManager::getContainedPass", NM="_ZN4llvm13LPPassManager16getContainedPassEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager16getContainedPassEj")
  //</editor-fold>
  public LoopPass /*P*/ getContainedPass(/*uint*/int N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::getPassManagerType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 126,
   FQN="llvm::LPPassManager::getPassManagerType", NM="_ZNK4llvm13LPPassManager18getPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZNK4llvm13LPPassManager18getPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPassManagerType() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  // Add a new loop into the loop queue as a child of the given parent, or at
  // the top level if \c ParentLoop is null.
  
  // Inset loop into loop nest (LoopInfo) and loop queue (LQ).
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::addLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 74,
   FQN="llvm::LPPassManager::addLoop", NM="_ZN4llvm13LPPassManager7addLoopEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager7addLoopEPNS_4LoopE")
  //</editor-fold>
  public Loop /*&*/ addLoop(Loop /*P*/ ParentLoop) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  /// SimpleAnalysis - Provides simple interface to update analysis info
  /// maintained by various passes. Note, if required this interface can
  /// be extracted into a separate abstract class but it would require
  /// additional use of multiple inheritance in Pass class hierarchy, something
  /// we are trying to avoid.
  
  /// cloneBasicBlockSimpleAnalysis - Invoke cloneBasicBlockAnalysis hook for
  /// all passes that implement simple analysis interface.
  
  /// cloneBasicBlockSimpleAnalysis - Invoke cloneBasicBlockAnalysis hook for
  /// all loop passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::cloneBasicBlockSimpleAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 101,
   FQN="llvm::LPPassManager::cloneBasicBlockSimpleAnalysis", NM="_ZN4llvm13LPPassManager29cloneBasicBlockSimpleAnalysisEPNS_10BasicBlockES2_PNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager29cloneBasicBlockSimpleAnalysisEPNS_10BasicBlockES2_PNS_4LoopE")
  //</editor-fold>
  public void cloneBasicBlockSimpleAnalysis(BasicBlock /*P*/ From, 
                               BasicBlock /*P*/ To, Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// deleteSimpleAnalysisValue - Invoke deleteAnalysisValue hook for all passes
  /// that implement simple analysis interface.
  
  /// deleteSimpleAnalysisValue - Invoke deleteAnalysisValue hook for all passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::deleteSimpleAnalysisValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 110,
   FQN="llvm::LPPassManager::deleteSimpleAnalysisValue", NM="_ZN4llvm13LPPassManager25deleteSimpleAnalysisValueEPNS_5ValueEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager25deleteSimpleAnalysisValueEPNS_5ValueEPNS_4LoopE")
  //</editor-fold>
  public void deleteSimpleAnalysisValue(Value /*P*/ V, Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Invoke deleteAnalysisLoop hook for all passes that implement simple
  /// analysis interface.
  
  /// Invoke deleteAnalysisLoop hook for all passes.
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::deleteSimpleAnalysisLoop">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp", line = 123,
   FQN="llvm::LPPassManager::deleteSimpleAnalysisLoop", NM="_ZN4llvm13LPPassManager24deleteSimpleAnalysisLoopEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManager24deleteSimpleAnalysisLoopEPNS_4LoopE")
  //</editor-fold>
  public void deleteSimpleAnalysisLoop(Loop /*P*/ L) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private std.deque<Loop /*P*/ > LQ;
  private LoopInfo /*P*/ LI;
  private Loop /*P*/ CurrentLoop;
  //<editor-fold defaultstate="collapsed" desc="llvm::LPPassManager::~LPPassManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPass.h", line = 97,
   FQN="llvm::LPPassManager::~LPPassManager", NM="_ZN4llvm13LPPassManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopPass.cpp -nm=_ZN4llvm13LPPassManagerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private final PMDataManager$Fields PMDataManager$Flds;// use return value of $PMDataManager();
  @Override public final PMDataManager$Fields $PMDataManager$Fields() { return PMDataManager$Flds; }
  
  @Override public String toString() {
    return "" + "LQ=" + LQ // NOI18N
              + ", LI=" + LI // NOI18N
              + ", CurrentLoop=" + CurrentLoop // NOI18N
              + super.toString(); // NOI18N
  }
}
