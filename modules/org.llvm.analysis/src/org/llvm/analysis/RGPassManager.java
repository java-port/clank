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


/// @brief The pass manager to schedule RegionPasses.
//<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 84,
 FQN="llvm::RGPassManager", NM="_ZN4llvm13RGPassManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm13RGPassManagerE")
//</editor-fold>
public class RGPassManager extends /*public*/ FunctionPass implements /*public*/ PMDataManager, Destructors.ClassWithDestructor {
  private std.deque<Region /*P*/ > RQ;
  private boolean skipThisRegion;
  private boolean redoThisRegion;
  private RegionInfo /*P*/ RI;
  private Region /*P*/ CurrentRegion;
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // RGPassManager
  //
  public static final/*char*/Class<RGPassManager> ID = RGPassManager.class;
  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::RGPassManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp", line = 31,
   FQN="llvm::RGPassManager::RGPassManager", NM="_ZN4llvm13RGPassManagerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm13RGPassManagerC1Ev")
  //</editor-fold>
  public RGPassManager() {
    // : FunctionPass(ID), PMDataManager(), RQ() 
    super(ID);
    //this.PMDataManager$Flds = $PMDataManager();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Execute all of the passes scheduled for execution.
  ///
  /// @return True if any of the passes modifies the function.
  
  /// run - Execute all of the passes scheduled for execution.  Keep track of
  /// whether any of the passes modifies the function, and if so, return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp", line = 54,
   FQN="llvm::RGPassManager::runOnFunction", NM="_ZN4llvm13RGPassManager13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm13RGPassManager13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Pass Manager itself does not invalidate any analysis info.
  /// RGPassManager needs RegionInfo.
  
  /// Pass Manager itself does not invalidate any analysis info.
  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp", line = 47,
   FQN="llvm::RGPassManager::getAnalysisUsage", NM="_ZNK4llvm13RGPassManager16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZNK4llvm13RGPassManager16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ Info) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::getPassName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 104,
   FQN="llvm::RGPassManager::getPassName", NM="_ZNK4llvm13RGPassManager11getPassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZNK4llvm13RGPassManager11getPassNameEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getPassName() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::getAsPMDataManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 108,
   FQN="llvm::RGPassManager::getAsPMDataManager", NM="_ZN4llvm13RGPassManager18getAsPMDataManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm13RGPassManager18getAsPMDataManagerEv")
  //</editor-fold>
  @Override public PMDataManager /*P*/ getAsPMDataManager()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::getAsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 109,
   FQN="llvm::RGPassManager::getAsPass", NM="_ZN4llvm13RGPassManager9getAsPassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm13RGPassManager9getAsPassEv")
  //</editor-fold>
  @Override public Pass /*P*/ getAsPass()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Print passes managed by this manager.
  
  /// Print passes managed by this manager
  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::dumpPassStructure">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp", line = 174,
   FQN="llvm::RGPassManager::dumpPassStructure", NM="_ZN4llvm13RGPassManager17dumpPassStructureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm13RGPassManager17dumpPassStructureEj")
  //</editor-fold>
  @Override public void dumpPassStructure(/*uint*/int Offset)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Get passes contained by this manager.
  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::getContainedPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 115,
   FQN="llvm::RGPassManager::getContainedPass", NM="_ZN4llvm13RGPassManager16getContainedPassEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm13RGPassManager16getContainedPassEj")
  //</editor-fold>
  public Pass /*P*/ getContainedPass(/*uint*/int N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::getPassManagerType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 121,
   FQN="llvm::RGPassManager::getPassManagerType", NM="_ZNK4llvm13RGPassManager18getPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZNK4llvm13RGPassManager18getPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPassManagerType() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RGPassManager::~RGPassManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 84,
   FQN="llvm::RGPassManager::~RGPassManager", NM="_ZN4llvm13RGPassManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm13RGPassManagerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private final PMDataManager$Fields PMDataManager$Flds;// use return value of $PMDataManager();
  @Override public final PMDataManager$Fields $PMDataManager$Fields() { return PMDataManager$Flds; }
  
  @Override public String toString() {
    return "" + "RQ=" + RQ // NOI18N
              + ", skipThisRegion=" + skipThisRegion // NOI18N
              + ", redoThisRegion=" + redoThisRegion // NOI18N
              + ", RI=" + RI // NOI18N
              + ", CurrentRegion=" + CurrentRegion // NOI18N
              + super.toString(); // NOI18N
  }
}
