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


/// \brief This is an alternative analysis pass to
/// BlockFrequencyInfoWrapperPass.  The difference is that with this pass the
/// block frequencies are not computed when the analysis pass is executed but
/// rather when the BFI results is explicitly requested by the analysis client.
///
/// There are some additional requirements for any client pass that wants to use
/// the analysis:
///
/// 1. The pass needs to initialize dependent passes with:
///
///   INITIALIZE_PASS_DEPENDENCY(LazyBFIPass)
///
/// 2. Similarly, getAnalysisUsage should call:
///
///   LazyBlockFrequencyInfoPass::getLazyBFIAnalysisUsage(AU)
///
/// 3. The computed BFI should be requested with
///    getAnalysis<LazyBlockFrequencyInfoPass>().getBFI() before either LoopInfo
///    or BPI could be invalidated for example by changing the CFG.
///
/// Note that it is expected that we wouldn't need this functionality for the
/// new PM since with the new PM, analyses are executed on demand.
//<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 51,
 FQN="llvm::LazyBlockFrequencyInfoPass", NM="_ZN4llvm26LazyBlockFrequencyInfoPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPassE")
//</editor-fold>
public class LazyBlockFrequencyInfoPass extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
  
  /// Wraps a BFI to allow lazy computation of the block frequencies.
  ///
  /// A pass that only conditionally uses BFI can uncondtionally require the
  /// analysis without paying for the overhead if BFI doesn't end up being used.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 57,
   FQN="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo", NM="_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfoE")
  //</editor-fold>
  private static class LazyBlockFrequencyInfo implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::LazyBlockFrequencyInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 59,
     FQN="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::LazyBlockFrequencyInfo", NM="_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfoC1Ev")
    //</editor-fold>
    public LazyBlockFrequencyInfo() {
      // : BFI(), Calculated(false), F(null), BPI(null), LI(null) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Set up the per-function input.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::setAnalysis">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 63,
     FQN="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::setAnalysis", NM="_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfo11setAnalysisEPKNS_8FunctionEPKNS_21BranchProbabilityInfoEPKNS_8LoopInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfo11setAnalysisEPKNS_8FunctionEPKNS_21BranchProbabilityInfoEPKNS_8LoopInfoE")
    //</editor-fold>
    public void setAnalysis(/*const*/ Function /*P*/ F, /*const*/ BranchProbabilityInfo /*P*/ BPI, 
               /*const*/ LoopInfo /*P*/ LI) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Retrieve the BFI with the block frequencies computed.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::getCalculated">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 71,
     FQN="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::getCalculated", NM="_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfo13getCalculatedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfo13getCalculatedEv")
    //</editor-fold>
    public BlockFrequencyInfo /*&*/ getCalculated() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::getCalculated">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 80,
     FQN="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::getCalculated", NM="_ZNK4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfo13getCalculatedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZNK4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfo13getCalculatedEv")
    //</editor-fold>
    public /*const*/ BlockFrequencyInfo /*&*/ getCalculated$Const() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::releaseMemory">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 84,
     FQN="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::releaseMemory", NM="_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfo13releaseMemoryEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfo13releaseMemoryEv")
    //</editor-fold>
    public void releaseMemory() {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private BlockFrequencyInfo BFI;
    private boolean Calculated;
    private /*const*/ Function /*P*/ F;
    private /*const*/ BranchProbabilityInfo /*P*/ BPI;
    private /*const*/ LoopInfo /*P*/ LI;
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::~LazyBlockFrequencyInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 57,
     FQN="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfo::~LazyBlockFrequencyInfo", NM="_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass22LazyBlockFrequencyInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "BFI=" + BFI // NOI18N
                + ", Calculated=" + Calculated // NOI18N
                + ", F=" + F // NOI18N
                + ", BPI=" + BPI // NOI18N
                + ", LI=" + LI; // NOI18N
    }
  };
  
  private LazyBlockFrequencyInfo LBFI;
/*public:*/
  public static final/*char*/Class<LazyBlockFrequencyInfoPass> ID = LazyBlockFrequencyInfoPass.class;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfoPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 34,
   FQN="llvm::LazyBlockFrequencyInfoPass::LazyBlockFrequencyInfoPass", NM="_ZN4llvm26LazyBlockFrequencyInfoPassC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPassC1Ev")
  //</editor-fold>
  public LazyBlockFrequencyInfoPass() {
    // : FunctionPass(ID), LBFI() 
    super(ID);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Compute and return the block frequencies.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::getBFI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 106,
   FQN="llvm::LazyBlockFrequencyInfoPass::getBFI", NM="_ZN4llvm26LazyBlockFrequencyInfoPass6getBFIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass6getBFIEv")
  //</editor-fold>
  public BlockFrequencyInfo /*&*/ getBFI() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Compute and return the block frequencies.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::getBFI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 109,
   FQN="llvm::LazyBlockFrequencyInfoPass::getBFI", NM="_ZNK4llvm26LazyBlockFrequencyInfoPass6getBFIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZNK4llvm26LazyBlockFrequencyInfoPass6getBFIEv")
  //</editor-fold>
  public /*const*/ BlockFrequencyInfo /*&*/ getBFI$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 42,
   FQN="llvm::LazyBlockFrequencyInfoPass::getAnalysisUsage", NM="_ZNK4llvm26LazyBlockFrequencyInfoPass16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZNK4llvm26LazyBlockFrequencyInfoPass16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Helper for client passes to set up the analysis usage on behalf of this
  /// pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::getLazyBFIAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 58,
   FQN="llvm::LazyBlockFrequencyInfoPass::getLazyBFIAnalysisUsage", NM="_ZN4llvm26LazyBlockFrequencyInfoPass23getLazyBFIAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass23getLazyBFIAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  public static void getLazyBFIAnalysisUsage(final AnalysisUsage /*&*/ AU) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 50,
   FQN="llvm::LazyBlockFrequencyInfoPass::runOnFunction", NM="_ZN4llvm26LazyBlockFrequencyInfoPass13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 48,
   FQN="llvm::LazyBlockFrequencyInfoPass::releaseMemory", NM="_ZN4llvm26LazyBlockFrequencyInfoPass13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPass13releaseMemoryEv")
  //</editor-fold>
  @Override public void releaseMemory()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 38,
   FQN="llvm::LazyBlockFrequencyInfoPass::print", NM="_ZNK4llvm26LazyBlockFrequencyInfoPass5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZNK4llvm26LazyBlockFrequencyInfoPass5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ $Prm1) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyBlockFrequencyInfoPass::~LazyBlockFrequencyInfoPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyBlockFrequencyInfo.h", line = 51,
   FQN="llvm::LazyBlockFrequencyInfoPass::~LazyBlockFrequencyInfoPass", NM="_ZN4llvm26LazyBlockFrequencyInfoPassD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm26LazyBlockFrequencyInfoPassD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "LBFI=" + LBFI // NOI18N
              + super.toString(); // NOI18N
  }
}
