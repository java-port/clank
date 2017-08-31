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


//===----------------------------------------------------------------------===//
/// @brief A pass that runs on each Region in a function.
///
/// RegionPass is managed by RGPassManager.
//<editor-fold defaultstate="collapsed" desc="llvm::RegionPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 34,
 FQN="llvm::RegionPass", NM="_ZN4llvm10RegionPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm10RegionPassE")
//</editor-fold>
public abstract class RegionPass extends /*public*/ Pass implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::RegionPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 36,
   FQN="llvm::RegionPass::RegionPass", NM="_ZN4llvm10RegionPassC1ERc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm10RegionPassC1ERc")
  //</editor-fold>
  public /*explicit*/ RegionPass(final Class<? extends RegionPass>/*char &*/ pid) {
    // : Pass(PT_Region, pid) 
    super(PassKind.PT_Region, pid);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //===--------------------------------------------------------------------===//
  /// @name To be implemented by every RegionPass
  ///
  //@{
  /// @brief Run the pass on a specific Region
  ///
  /// Accessing regions not contained in the current region is not allowed.
  ///
  /// @param R The region this pass is run on.
  /// @param RGM The RegionPassManager that manages this Pass.
  ///
  /// @return True if the pass modifies this Region.
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::runOnRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 50,
   FQN="llvm::RegionPass::runOnRegion", NM="_ZN4llvm10RegionPass11runOnRegionEPNS_6RegionERNS_13RGPassManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm10RegionPass11runOnRegionEPNS_6RegionERNS_13RGPassManagerE")
  //</editor-fold>
  public abstract /*virtual*/ boolean runOnRegion(Region /*P*/ R, final RGPassManager /*&*/ RGM)/* = 0*/;

  
  /// @brief Get a pass to print the LLVM IR in the region.
  ///
  /// @param O      The output stream to print the Region.
  /// @param Banner The banner to separate different printed passes.
  ///
  /// @return The pass to print the LLVM IR in the region.
  
  /// Get the printer pass
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::createPrinterPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp", line = 279,
   FQN="llvm::RegionPass::createPrinterPass", NM="_ZNK4llvm10RegionPass17createPrinterPassERNS_11raw_ostreamERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZNK4llvm10RegionPass17createPrinterPassERNS_11raw_ostreamERKSs")
  //</editor-fold>
  @Override public Pass /*P*/ createPrinterPass(final raw_ostream /*&*/ O, 
                   final /*const*/std.string/*&*/ Banner) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //JAVA: using llvm::Pass::doInitialization;
  //JAVA: using llvm::Pass::doFinalization;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::doInitialization">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 64,
   FQN="llvm::RegionPass::doInitialization", NM="_ZN4llvm10RegionPass16doInitializationEPNS_6RegionERNS_13RGPassManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm10RegionPass16doInitializationEPNS_6RegionERNS_13RGPassManagerE")
  //</editor-fold>
  public /*virtual*/ boolean doInitialization(Region /*P*/ R, final RGPassManager /*&*/ RGM) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::doFinalization">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 65,
   FQN="llvm::RegionPass::doFinalization", NM="_ZN4llvm10RegionPass14doFinalizationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm10RegionPass14doFinalizationEv")
  //</editor-fold>
  public /*virtual*/ boolean doFinalization() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //@}
  
  //===--------------------------------------------------------------------===//
  /// @name PassManager API
  ///
  //@{
  //end anonymous namespace
  
  //===----------------------------------------------------------------------===//
  // RegionPass
  
  // Check if this pass is suitable for the current RGPassManager, if
  // available. This pass P is not suitable for a RGPassManager if P
  // is not preserving higher level analysis info used by other
  // RGPassManager passes. In such case, pop RGPassManager from the
  // stack. This will force assignPassManager() to create new
  // LPPassManger as expected.
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::preparePassManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp", line = 225,
   FQN="llvm::RegionPass::preparePassManager", NM="_ZN4llvm10RegionPass18preparePassManagerERNS_7PMStackE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm10RegionPass18preparePassManagerERNS_7PMStackE")
  //</editor-fold>
  @Override public void preparePassManager(final PMStack /*&*/ PMS)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// Assign pass manager to manage this pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::assignPassManager">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp", line = 242,
   FQN="llvm::RegionPass::assignPassManager", NM="_ZN4llvm10RegionPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm10RegionPass17assignPassManagerERNS_7PMStackENS_15PassManagerTypeE")
  //</editor-fold>
  public void assignPassManager(final PMStack /*&*/ PMS)/* override*/ {
    assignPassManager(PMS, 
                   PassManagerType.PMT_RegionPassManager);
  }
  @Override public void assignPassManager(final PMStack /*&*/ PMS, 
                   PassManagerType PreferredType/*= PMT_RegionPassManager*/)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::getPotentialPassManagerType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 77,
   FQN="llvm::RegionPass::getPotentialPassManagerType", NM="_ZNK4llvm10RegionPass27getPotentialPassManagerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZNK4llvm10RegionPass27getPotentialPassManagerTypeEv")
  //</editor-fold>
  @Override public PassManagerType getPotentialPassManagerType() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionPass::~RegionPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionPass.h", line = 34,
   FQN="llvm::RegionPass::~RegionPass", NM="_ZN4llvm10RegionPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPass.cpp -nm=_ZN4llvm10RegionPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
//@}
}
