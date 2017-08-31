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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.ir.*;
import static org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.IPassFunction;


/// \brief Adaptor that maps from a SCC to its functions.
///
/// Designed to allow composition of a FunctionPass(Manager) and
/// a CGSCCPassManager. Note that if this pass is constructed with a pointer
/// to a \c CGSCCAnalysisManager it will run the
/// \c FunctionAnalysisManagerCGSCCProxy analysis prior to running the function
/// pass over the SCC to enable a \c FunctionAnalysisManager to be used
/// within this run safely.
/*template <typename FunctionPassT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::CGSCCToFunctionPassAdaptor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 164,
 FQN="llvm::CGSCCToFunctionPassAdaptor", NM="_ZN4llvm26CGSCCToFunctionPassAdaptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm26CGSCCToFunctionPassAdaptorE")
//</editor-fold>
public class CGSCCToFunctionPassAdaptor</*typename*/ FunctionPassT extends IPassFunction<PreservedAnalyses>>  implements /*public*/ PassInfoMixin<CGSCCToFunctionPassAdaptor<FunctionPassT> > {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CGSCCToFunctionPassAdaptor::CGSCCToFunctionPassAdaptor<FunctionPassT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 168,
   FQN="llvm::CGSCCToFunctionPassAdaptor::CGSCCToFunctionPassAdaptor<FunctionPassT>", NM="_ZN4llvm26CGSCCToFunctionPassAdaptorC1ET_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm26CGSCCToFunctionPassAdaptorC1ET_b")
  //</editor-fold>
  public /*explicit*/ CGSCCToFunctionPassAdaptor(FunctionPassT Pass) {
    this(Pass, false);
  }
  public /*explicit*/ CGSCCToFunctionPassAdaptor(FunctionPassT Pass, boolean DebugLogging/*= false*/) {
    // : Pass(std::move(Pass)), DebugLogging(DebugLogging) 
    //START JInit
    this.Pass = std.move(Pass);///*ParenListExpr*/new FunctionPassT(std.move(Pass));
    this.DebugLogging = DebugLogging;
    //END JInit
  }

  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::CGSCCToFunctionPassAdaptor::CGSCCToFunctionPassAdaptor<FunctionPassT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 172,
   FQN="llvm::CGSCCToFunctionPassAdaptor::CGSCCToFunctionPassAdaptor<FunctionPassT>", NM="_ZN4llvm26CGSCCToFunctionPassAdaptorC1ERKNS_26CGSCCToFunctionPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm26CGSCCToFunctionPassAdaptorC1ERKNS_26CGSCCToFunctionPassAdaptorIT_EE")
  //</editor-fold>
  public CGSCCToFunctionPassAdaptor(final /*const*/ CGSCCToFunctionPassAdaptor<FunctionPassT> /*&*/ Arg) {
    // : Pass(Arg.Pass), DebugLogging(Arg.DebugLogging) 
    //START JInit
    this.Pass = Arg.Pass;///*ParenListExpr*/new FunctionPassT(Arg.Pass);
    this.DebugLogging = Arg.DebugLogging;///*ParenListExpr*/new boolean(Arg.DebugLogging);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CGSCCToFunctionPassAdaptor::CGSCCToFunctionPassAdaptor<FunctionPassT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 174,
   FQN="llvm::CGSCCToFunctionPassAdaptor::CGSCCToFunctionPassAdaptor<FunctionPassT>", NM="_ZN4llvm26CGSCCToFunctionPassAdaptorC1EONS_26CGSCCToFunctionPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm26CGSCCToFunctionPassAdaptorC1EONS_26CGSCCToFunctionPassAdaptorIT_EE")
  //</editor-fold>
  public CGSCCToFunctionPassAdaptor(JD$Move _dparam, final CGSCCToFunctionPassAdaptor<FunctionPassT> /*&&*/Arg) {
    // : Pass(std::move(Arg.Pass)), DebugLogging(Arg.DebugLogging) 
    //START JInit
    this.Pass = std.move(Arg.Pass);///*ParenListExpr*/new FunctionPassT(std.move(Arg.Pass));
    this.DebugLogging = Arg.DebugLogging;///*ParenListExpr*/new boolean(Arg.DebugLogging);
    //END JInit
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::swap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 176,
   FQN="llvm::swap", NM="_ZN4llvm4swapERNS_26CGSCCToFunctionPassAdaptorIT_EES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm4swapERNS_26CGSCCToFunctionPassAdaptorIT_EES4_")
  //</editor-fold>
  public static </*typename*/ FunctionPassT extends IPassFunction<PreservedAnalyses>> void swap(final CGSCCToFunctionPassAdaptor<FunctionPassT> /*&*/ LHS, 
      final CGSCCToFunctionPassAdaptor<FunctionPassT> /*&*/ RHS) {
    //JAVA: using std::swap;
    FunctionPassT tmp = LHS.Pass;
    LHS.Pass = RHS.Pass;
    RHS.Pass = tmp;
    //swap(LHS.Pass, RHS.Pass);
    boolean tmp2 = LHS.DebugLogging;
    LHS.DebugLogging = RHS.DebugLogging;
    RHS.DebugLogging = tmp2;
    //swap(LHS.DebugLogging, RHS.DebugLogging);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CGSCCToFunctionPassAdaptor::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 182,
   FQN="llvm::CGSCCToFunctionPassAdaptor::operator=", NM="_ZN4llvm26CGSCCToFunctionPassAdaptoraSENS_26CGSCCToFunctionPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm26CGSCCToFunctionPassAdaptoraSENS_26CGSCCToFunctionPassAdaptorIT_EE")
  //</editor-fold>
  public CGSCCToFunctionPassAdaptor<FunctionPassT> /*&*/ $assign(CGSCCToFunctionPassAdaptor<FunctionPassT> RHS) {
    swap(/*Deref*/this, RHS);
    return /*Deref*/this;
  }

  
  /// \brief Runs the function pass across every function in the module.
  //<editor-fold defaultstate="collapsed" desc="llvm::CGSCCToFunctionPassAdaptor::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 188,
   FQN="llvm::CGSCCToFunctionPassAdaptor::run", NM="_ZN4llvm26CGSCCToFunctionPassAdaptor3runERNS_13LazyCallGraph3SCCERNS_15AnalysisManagerIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=_ZN4llvm26CGSCCToFunctionPassAdaptor3runERNS_13LazyCallGraph3SCCERNS_15AnalysisManagerIS2_EE")
  //</editor-fold>
  public PreservedAnalyses run(final LazyCallGraph.SCC /*&*/ C, final AnalysisManager<LazyCallGraph.SCC> /*&*/ AM) {
    PreservedAnalyses PA = null;
    try {
      // Setup the function analysis manager from its proxy.
      final AnalysisManager<Function> /*&*/ FAM = AM.getResult((Class<InnerAnalysisManagerProxy<AnalysisManager<Function>, LazyCallGraph.SCC>>)(Class<?>)InnerAnalysisManagerProxy.class, C).getManager();
      if (DebugLogging) {
        LazyCallGraph.SCC.$out_raw_ostream_SCC$C(dbgs().$out(/*KEEP_STR*/"Running function passes across an SCC: "), C).$out(/*KEEP_STR*/$LF);
      }
      
      PA = PreservedAnalyses.all();
      for (final LazyCallGraph.Node /*&*/ N : C) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          PreservedAnalyses PassPA = Pass.run(N.getFunction(), FAM);
          
          // We know that the function pass couldn't have invalidated any other
          // function's analyses (that's the contract of a function pass), so
          // directly handle the function analysis manager's invalidation here.
          // Also, update the preserved analyses to reflect that once invalidated
          // these can again be preserved.
          $c$.clean(PassPA.$assign($c$.track(FAM.invalidate(N.getFunction(), $c$.track(new PreservedAnalyses(JD$Move.INSTANCE, std.move(PassPA)))))));
          
          // Then intersect the preserved set so that invalidation of module
          // analyses will eventually occur when the module pass completes.
          PA.intersect_PreservedAnalyses(std.move(PassPA));
        } finally {
          $c$.$destroy();
        }
      }
      
      // By definition we preserve the proxy. This precludes *any* invalidation
      // of function analyses by the proxy, but that's OK because we've taken
      // care to invalidate analyses in the function analysis manager
      // incrementally above.
      // FIXME: We need to update the call graph here to account for any deleted
      // edges!
      PA.<InnerAnalysisManagerProxy<AnalysisManager<Function>, LazyCallGraph.SCC> >preserve((Class<InnerAnalysisManagerProxy<AnalysisManager<Function>, LazyCallGraph.SCC>>)(Class<?>)InnerAnalysisManagerProxy.class);
      return new PreservedAnalyses(JD$Move.INSTANCE, PA);
    } finally {
      if (PA != null) { PA.$destroy(); }
    }
  }

/*private:*/
  private FunctionPassT Pass;
  private boolean DebugLogging;
  
  @Override public String toString() {
    return "" + "Pass=" + Pass // NOI18N
              + ", DebugLogging=" + DebugLogging // NOI18N
              + super.toString(); // NOI18N
  }
}
