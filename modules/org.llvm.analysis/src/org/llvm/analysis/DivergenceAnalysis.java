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

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseSet;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.impl.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.pass.IrLlvmGlobals.$out_raw_ostream_Value$C;
import static org.llvm.pass.IrLlvmGlobals.instructions_Function$C$P;

//<editor-fold defaultstate="collapsed" desc="llvm::DivergenceAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DivergenceAnalysis.h", line = 23,
 FQN="llvm::DivergenceAnalysis", NM="_ZN4llvm18DivergenceAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN4llvm18DivergenceAnalysisE")
//</editor-fold>
public class DivergenceAnalysis extends /*public*/ FunctionPass implements Destructors.ClassWithDestructor {
/*public:*/
  /// end namespace anonymous
  
  // Register this pass.
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DivergenceAnalysis::DivergenceAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DivergenceAnalysis.h", line = 27,
   FQN="llvm::DivergenceAnalysis::DivergenceAnalysis", NM="_ZN4llvm18DivergenceAnalysisC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN4llvm18DivergenceAnalysisC1Ev")
  //</editor-fold>
  public DivergenceAnalysis() {
    // : FunctionPass(ID), DivergentValues() 
    //START JInit
    super(ID);
    this.DivergentValues = new DenseSet</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info());
    //END JInit
    DivergenceAnalysisLlvmStatics.initializeDivergenceAnalysisPass($Deref(PassRegistry.getPassRegistry()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DivergenceAnalysis::getAnalysisUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 279,
   FQN="llvm::DivergenceAnalysis::getAnalysisUsage", NM="_ZNK4llvm18DivergenceAnalysis16getAnalysisUsageERNS_13AnalysisUsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZNK4llvm18DivergenceAnalysis16getAnalysisUsageERNS_13AnalysisUsageE")
  //</editor-fold>
  @Override public void getAnalysisUsage(final AnalysisUsage /*&*/ AU) /*const*//* override*/ {
    AU.<DominatorTreeWrapperPass>addRequired(DominatorTreeWrapperPass.class);
    AU.<PostDominatorTreeWrapperPass>addRequired(PostDominatorTreeWrapperPass.class);
    AU.setPreservesAll();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DivergenceAnalysis::runOnFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 285,
   FQN="llvm::DivergenceAnalysis::runOnFunction", NM="_ZN4llvm18DivergenceAnalysis13runOnFunctionERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN4llvm18DivergenceAnalysis13runOnFunctionERNS_8FunctionE")
  //</editor-fold>
  @Override public boolean runOnFunction(final Function /*&*/ F)/* override*/ {
    DivergencePropagator DP = null;
    try {
      TargetTransformInfoWrapperPass /*P*/ TTIWP = this.<TargetTransformInfoWrapperPass>getAnalysisIfAvailable(TargetTransformInfoWrapperPass.class);
      if (TTIWP == null) {
        return false;
      }
      
      final TargetTransformInfo /*&*/ TTI = TTIWP.getTTI(F);
      // Fast path: if the target does not have branch divergence, we do not mark
      // any branch as divergent.
      if (!TTI.hasBranchDivergence()) {
        return false;
      }
      
      DivergentValues.clear();
      final PostDominatorTree /*&*/ PDT = this.<PostDominatorTreeWrapperPass>getAnalysis(PostDominatorTreeWrapperPass.class).getPostDomTree();
      DP/*J*/= new DivergencePropagator(F, TTI, 
          this.<DominatorTreeWrapperPass>getAnalysis(DominatorTreeWrapperPass.class).getDomTree(), 
          PDT, DivergentValues);
      DP.populateWithSourcesOfDivergence();
      DP.propagate();
      return false;
    } finally {
      if (DP != null) { DP.$destroy(); }
    }
  }

  
  // Print all divergent branches in the function.
  //<editor-fold defaultstate="collapsed" desc="llvm::DivergenceAnalysis::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 306,
   FQN="llvm::DivergenceAnalysis::print", NM="_ZNK4llvm18DivergenceAnalysis5printERNS_11raw_ostreamEPKNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZNK4llvm18DivergenceAnalysis5printERNS_11raw_ostreamEPKNS_6ModuleE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS, /*const*/ Module /*P*/ $Prm1) /*const*//* override*/ {
    if (DivergentValues.empty()) {
      return;
    }
    /*const*/ Value /*P*/ FirstDivergentValue = DivergentValues.begin$Const().$star();
    /*const*/ Function /*P*/ F;
    {
      /*const*/ Argument /*P*/ Arg = dyn_cast_Argument(FirstDivergentValue);
      if ((Arg != null)) {
        F = Arg.getParent$Const();
      } else {
        /*const*/ Instruction /*P*/ I = dyn_cast_Instruction(FirstDivergentValue);
        if ((I != null)) {
          F = I.getParent$Const().getParent$Const();
        } else {
          throw new llvm_unreachable("Only arguments and instructions can be divergent");
        }
      }
    }
    
    // Dumps all divergent values in F, arguments and then instructions.
    for (final /*const*/ Argument /*&*/ Arg : F.args$Const()) {
      if ((DivergentValues.count($AddrOf(Arg)) != 0)) {
        $out_raw_ostream_Value$C(OS.$out(/*KEEP_STR*/"DIVERGENT:  "), Arg).$out(/*KEEP_STR*/$LF);
      }
    }
    // Iterate instructions using instructions() to ensure a deterministic order.
    for (final /*const*/ Instruction /*&*/ I : instructions_Function$C$P(F)) {
      if ((DivergentValues.count($AddrOf(I)) != 0)) {
        $out_raw_ostream_Value$C(OS.$out(/*KEEP_STR*/"DIVERGENT:"), I).$out(/*KEEP_STR*/$LF);
      }
    }
  }

  
  // Returns true if V is divergent.
  //<editor-fold defaultstate="collapsed" desc="llvm::DivergenceAnalysis::isDivergent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DivergenceAnalysis.h", line = 39,
   FQN="llvm::DivergenceAnalysis::isDivergent", NM="_ZNK4llvm18DivergenceAnalysis11isDivergentEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZNK4llvm18DivergenceAnalysis11isDivergentEPKNS_5ValueE")
  //</editor-fold>
  public boolean isDivergent(/*const*/ Value /*P*/ V) /*const*/ {
    return (DivergentValues.count(V) != 0);
  }

  
  // Returns true if V is uniform/non-divergent.
  //<editor-fold defaultstate="collapsed" desc="llvm::DivergenceAnalysis::isUniform">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DivergenceAnalysis.h", line = 42,
   FQN="llvm::DivergenceAnalysis::isUniform", NM="_ZNK4llvm18DivergenceAnalysis9isUniformEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZNK4llvm18DivergenceAnalysis9isUniformEPKNS_5ValueE")
  //</editor-fold>
  public boolean isUniform(/*const*/ Value /*P*/ V) /*const*/ {
    return !isDivergent(V);
  }

/*private:*/
  // Stores all divergent values.
  private DenseSet</*const*/ Value /*P*/ > DivergentValues;
  //<editor-fold defaultstate="collapsed" desc="llvm::DivergenceAnalysis::~DivergenceAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DivergenceAnalysis.h", line = 23,
   FQN="llvm::DivergenceAnalysis::~DivergenceAnalysis", NM="_ZN4llvm18DivergenceAnalysisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN4llvm18DivergenceAnalysisD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DivergentValues.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<DivergenceAnalysis> ID = DivergenceAnalysis.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "DivergentValues=" + DivergentValues // NOI18N
              + super.toString(); // NOI18N
  }
}
