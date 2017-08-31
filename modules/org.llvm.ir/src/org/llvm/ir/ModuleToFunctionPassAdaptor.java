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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.ir.java.*;
import org.llvm.ir.PassManagerGlobals.*;


/// \brief Trivial adaptor that maps from a module to its functions.
///
/// Designed to allow composition of a FunctionPass(Manager) and
/// a ModulePassManager. Note that if this pass is constructed with a pointer
/// to a \c ModuleAnalysisManager it will run the
/// \c FunctionAnalysisManagerModuleProxy analysis prior to running the function
/// pass over the module to enable a \c FunctionAnalysisManager to be used
/// within this run safely.
///
/// Function passes run within this adaptor can rely on having exclusive access
/// to the function they are run over. They should not read or modify any other
/// functions! Other threads or systems may be manipulating other functions in
/// the module, and so their state should never be relied on.
/// FIXME: Make the above true for all of LLVM's actual passes, some still
/// violate this principle.
///
/// Function passes can also read the module containing the function, but they
/// should not modify that module outside of the use lists of various globals.
/// For example, a function pass is not permitted to add functions to the
/// module.
/// FIXME: Make the above true for all of LLVM's actual passes, some still
/// violate this principle.
/*template <typename FunctionPassT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ModuleToFunctionPassAdaptor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 867,
 FQN="llvm::ModuleToFunctionPassAdaptor", NM="_ZN4llvm27ModuleToFunctionPassAdaptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm27ModuleToFunctionPassAdaptorE")
//</editor-fold>
public class ModuleToFunctionPassAdaptor</*typename*/ FunctionPassT extends IPassFunction<PreservedAnalyses>>  implements /*public*/ PassInfoMixin<ModuleToFunctionPassAdaptor<FunctionPassT> >, IPassModule<PreservedAnalyses> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToFunctionPassAdaptor::ModuleToFunctionPassAdaptor<FunctionPassT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 871,
   FQN="llvm::ModuleToFunctionPassAdaptor::ModuleToFunctionPassAdaptor<FunctionPassT>", NM="_ZN4llvm27ModuleToFunctionPassAdaptorC1ET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm27ModuleToFunctionPassAdaptorC1ET_")
  //</editor-fold>
  public /*explicit*/ ModuleToFunctionPassAdaptor(FunctionPassT Pass) {
    // : Pass(std::move(Pass)) 
    //START JInit
    this.Pass = std.move(Pass);///*ParenListExpr*/new FunctionPassT(std.move(Pass));
    //END JInit
  }

  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToFunctionPassAdaptor::ModuleToFunctionPassAdaptor<FunctionPassT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 875,
   FQN="llvm::ModuleToFunctionPassAdaptor::ModuleToFunctionPassAdaptor<FunctionPassT>", NM="_ZN4llvm27ModuleToFunctionPassAdaptorC1ERKNS_27ModuleToFunctionPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm27ModuleToFunctionPassAdaptorC1ERKNS_27ModuleToFunctionPassAdaptorIT_EE")
  //</editor-fold>
  public ModuleToFunctionPassAdaptor(final /*const*/ ModuleToFunctionPassAdaptor<FunctionPassT> /*&*/ Arg) {
    // : Pass(Arg.Pass) 
    //START JInit
    this.Pass = Arg.Pass;///*ParenListExpr*/new FunctionPassT(Arg.Pass);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToFunctionPassAdaptor::ModuleToFunctionPassAdaptor<FunctionPassT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 877,
   FQN="llvm::ModuleToFunctionPassAdaptor::ModuleToFunctionPassAdaptor<FunctionPassT>", NM="_ZN4llvm27ModuleToFunctionPassAdaptorC1EONS_27ModuleToFunctionPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm27ModuleToFunctionPassAdaptorC1EONS_27ModuleToFunctionPassAdaptorIT_EE")
  //</editor-fold>
  public ModuleToFunctionPassAdaptor(JD$Move _dparam, final ModuleToFunctionPassAdaptor<FunctionPassT> /*&&*/Arg) {
    // : Pass(std::move(Arg.Pass)) 
    //START JInit
    this.Pass = std.move(Arg.Pass);///*ParenListExpr*/new FunctionPassT(std.move(Arg.Pass));
    //END JInit
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::swap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 879,
   FQN="llvm::swap", NM="_ZN4llvm4swapERNS_27ModuleToFunctionPassAdaptorIT_EES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm4swapERNS_27ModuleToFunctionPassAdaptorIT_EES4_")
  //</editor-fold>
  public static </*typename*/ FunctionPassT extends IPassFunction<PreservedAnalyses>> void swap(final ModuleToFunctionPassAdaptor<FunctionPassT> /*&*/ LHS, 
      final ModuleToFunctionPassAdaptor<FunctionPassT> /*&*/ RHS) {
    //JAVA: using std::swap;
    //swap(LHS.Pass, RHS.Pass);
    FunctionPassT tmp = LHS.Pass;
    LHS.Pass = RHS.Pass;
    RHS.Pass = tmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToFunctionPassAdaptor::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 884,
   FQN="llvm::ModuleToFunctionPassAdaptor::operator=", NM="_ZN4llvm27ModuleToFunctionPassAdaptoraSENS_27ModuleToFunctionPassAdaptorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm27ModuleToFunctionPassAdaptoraSENS_27ModuleToFunctionPassAdaptorIT_EE")
  //</editor-fold>
  public ModuleToFunctionPassAdaptor<FunctionPassT> /*&*/ $assign(ModuleToFunctionPassAdaptor<FunctionPassT> RHS) {
    swap(/*Deref*/this, RHS);
    return /*Deref*/this;
  }

  
  /// \brief Runs the function pass across every function in the module.
  //<editor-fold defaultstate="collapsed" desc="llvm::ModuleToFunctionPassAdaptor::run">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 890,
   FQN="llvm::ModuleToFunctionPassAdaptor::run", NM="_ZN4llvm27ModuleToFunctionPassAdaptor3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm27ModuleToFunctionPassAdaptor3runERNS_6ModuleERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public PreservedAnalyses run(final Module /*&*/ M, final AnalysisManager<Module> /*&*/ AM) {
    PreservedAnalyses PA = null;
    try {
      // Setup the function analysis manager from its proxy.
      final AnalysisManager<Function> /*&*/ FAM = AM.getResult((Class<InnerAnalysisManagerProxy<AnalysisManager<Function>, Module>>)(Class<?>)InnerAnalysisManagerProxy.class, M).getManager();
      
      PA = PreservedAnalyses.all();
      for (final Function /*&*/ F : M) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (F.isDeclaration()) {
            continue;
          }
          
          PreservedAnalyses PassPA = Pass.run(F, FAM);
          
          // We know that the function pass couldn't have invalidated any other
          // function's analyses (that's the contract of a function pass), so
          // directly handle the function analysis manager's invalidation here and
          // update our preserved set to reflect that these have already been
          // handled.
          $c$.clean(PassPA.$assign($c$.track(FAM.invalidate(F, $c$.track(new PreservedAnalyses(JD$Move.INSTANCE, std.move(PassPA)))))));
          
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
      PA.<InnerAnalysisManagerProxy<AnalysisManager<Function>, Module> >preserve(InnerAnalysisManagerProxy.class);
      return new PreservedAnalyses(JD$Move.INSTANCE, PA);
    } finally {
      if (PA != null) { PA.$destroy(); }
    }
  }

/*private:*/
  private FunctionPassT Pass;
  
  @Override public String toString() {
    return "" + "Pass=" + Pass // NOI18N
              + super.toString(); // NOI18N
  }
}
