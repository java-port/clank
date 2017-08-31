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
import org.llvm.support.*;
import org.llvm.ir.java.*;
import org.llvm.ir.PassManagerGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type PassManagerGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="PassManagerGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxyE;_ZN4llvm25InnerAnalysisManagerProxyINS_15AnalysisManagerINS_8FunctionEEENS_6ModuleEEE;_ZN4llvm25OuterAnalysisManagerProxyE;_ZN4llvm25OuterAnalysisManagerProxyINS_15AnalysisManagerINS_6ModuleEEENS_8FunctionEEE; -static-type=PassManagerGlobals")
//</editor-fold>
public final class PassManagerGlobals {


/// \brief A module analysis which acts as a proxy for a function analysis
/// manager.
///
/// This primarily proxies invalidation information from the module analysis
/// manager and module pass manager to a function analysis manager. You should
/// never use a function analysis manager from within (transitively) a module
/// pass manager unless your parent module pass has received a proxy result
/// object for it.
///
/// Note that the proxy's result is a move-only object and represents ownership
/// of the validity of the analyses in the \c FunctionAnalysisManager it
/// provides.
/*template <typename AnalysisManagerT, typename IRUnitT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 671,
 FQN="llvm::InnerAnalysisManagerProxy", NM="_ZN4llvm25InnerAnalysisManagerProxyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxyE")
//</editor-fold>
public static class InnerAnalysisManagerProxy</*typename*/ AnalysisManagerT extends AnalysisManager, /*typename*/ IRUnitT>  implements /*public*/ AnalysisInfoMixin<InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT> > {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::Result">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 676,
   FQN="llvm::InnerAnalysisManagerProxy::Result", NM="_ZN4llvm25InnerAnalysisManagerProxy6ResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxy6ResultE")
  //</editor-fold>
  public static class Result</*typename*/ AnalysisManagerT extends AnalysisManager, /*typename*/ IRUnitT> implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::Result::Result">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 678,
     FQN="llvm::InnerAnalysisManagerProxy::Result::Result", NM="_ZN4llvm25InnerAnalysisManagerProxy6ResultC1ERT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxy6ResultC1ERT_")
    //</editor-fold>
    public /*explicit*/ Result(final AnalysisManagerT /*&*/ AM) {
      // : AM(&AM) 
      //START JInit
      this.AM = /*ParenListExpr*/$AddrOf(AM);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::Result::Result">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 679,
     FQN="llvm::InnerAnalysisManagerProxy::Result::Result", NM="_ZN4llvm25InnerAnalysisManagerProxy6ResultC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxy6ResultC1EOS1_")
    //</editor-fold>
    public Result(JD$Move _dparam, final Result /*&&*/Arg) {
      // : AM(std::move(Arg.AM)) 
      //START JInit
      this.AM = (AnalysisManagerT)/*ParenListExpr*/std.move(Arg.AM);
      //END JInit
      // We have to null out the analysis manager in the moved-from state
      // because we are taking ownership of the responsibilty to clear the
      // analysis state.
      Arg.AM = null;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::Result::operator=">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 685,
     FQN="llvm::InnerAnalysisManagerProxy::Result::operator=", NM="_ZN4llvm25InnerAnalysisManagerProxy6ResultaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxy6ResultaSEOS1_")
    //</editor-fold>
    public Result /*&*/ $assignMove(final Result /*&&*/RHS) {
      AM = (AnalysisManagerT) RHS.AM;
      // We have to null out the analysis manager in the moved-from state
      // because we are taking ownership of the responsibilty to clear the
      // analysis state.
      RHS.AM = null;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::Result::~Result">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 693,
     FQN="llvm::InnerAnalysisManagerProxy::Result::~Result", NM="_ZN4llvm25InnerAnalysisManagerProxy6ResultD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxy6ResultD0Ev")
    //</editor-fold>
    public void $destroy() {
      // AM is cleared in a moved from state where there is nothing to do.
      if (Native.$not(AM)) {
        return;
      }
      
      // Clear out the analysis manager if we're being destroyed -- it means we
      // didn't even see an invalidate call when we got invalidated.
      AM.clear();
    }

    
    /// \brief Accessor for the analysis manager.
    //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::Result::getManager">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 704,
     FQN="llvm::InnerAnalysisManagerProxy::Result::getManager", NM="_ZN4llvm25InnerAnalysisManagerProxy6Result10getManagerEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxy6Result10getManagerEv")
    //</editor-fold>
    public AnalysisManagerT /*&*/ getManager() {
      return $Deref(AM);
    }

    
    /// \brief Handler for invalidation of the module.
    ///
    /// If this analysis itself is preserved, then we assume that the set of \c
    /// Function objects in the \c Module hasn't changed and thus we don't need
    /// to invalidate *all* cached data associated with a \c Function* in the \c
    /// FunctionAnalysisManager.
    ///
    /// Regardless of whether this analysis is marked as preserved, all of the
    /// analyses in the \c FunctionAnalysisManager are potentially invalidated
    /// based on the set of preserved analyses.
    //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::Result::invalidate">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 716,
     FQN="llvm::InnerAnalysisManagerProxy::Result::invalidate", NM="_ZN4llvm25InnerAnalysisManagerProxy6Result10invalidateERT0_RKNS_17PreservedAnalysesE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxy6Result10invalidateERT0_RKNS_17PreservedAnalysesE")
    //</editor-fold>
    public boolean invalidate(final IRUnitT /*&*/ IR, final /*const*/ PreservedAnalyses /*&*/ PA) {
      // If this proxy isn't marked as preserved, then we can't even invalidate
      // individual function analyses, there may be an invalid set of Function
      // objects in the cache making it impossible to incrementally preserve
      // them. Just clear the entire manager.
      if (Native.$not(PA.preserved(InnerAnalysisManagerProxy.class))) {//<AnalysisManagerT, IRUnitT>ID()))) {
        AM.clear();
      }
      
      // Return false to indicate that this result is still a valid proxy.
      return false;
    }

  /*private:*/
    private AnalysisManagerT /*P*/ AM;
    
    @Override public String toString() {
      return "" + "AM=" + AM; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 732,
   FQN="llvm::InnerAnalysisManagerProxy::InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT>", NM="_ZN4llvm25InnerAnalysisManagerProxyC1ERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxyC1ERT_")
  //</editor-fold>
  public /*explicit*/ InnerAnalysisManagerProxy(final AnalysisManagerT /*&*/ AM) {
    // : AM(&AM) 
    //START JInit
    this.AM = /*ParenListExpr*/$AddrOf(AM);
    //END JInit
  }

  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 735,
   FQN="llvm::InnerAnalysisManagerProxy::InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT>", NM="_ZN4llvm25InnerAnalysisManagerProxyC1ERKNS_25InnerAnalysisManagerProxyIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxyC1ERKNS_25InnerAnalysisManagerProxyIT_T0_EE")
  //</editor-fold>
  public InnerAnalysisManagerProxy(final /*const*/ InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT> /*&*/ Arg) {
    // : AM(Arg.AM) 
    //START JInit
    this.AM = /*ParenListExpr*/Arg.AM;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 737,
   FQN="llvm::InnerAnalysisManagerProxy::InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT>", NM="_ZN4llvm25InnerAnalysisManagerProxyC1EONS_25InnerAnalysisManagerProxyIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxyC1EONS_25InnerAnalysisManagerProxyIT_T0_EE")
  //</editor-fold>
  public InnerAnalysisManagerProxy(JD$Move _dparam, final InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT> /*&&*/Arg) {
    // : AM(std::move(Arg.AM)) 
    //START JInit
    this.AM = /*ParenListExpr*/std.move(Arg.AM);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 739,
   FQN="llvm::InnerAnalysisManagerProxy::operator=", NM="_ZN4llvm25InnerAnalysisManagerProxyaSENS_25InnerAnalysisManagerProxyIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxyaSENS_25InnerAnalysisManagerProxyIT_T0_EE")
  //</editor-fold>
  public InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT> /*&*/ $assign(InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT> RHS) {
    AnalysisManagerT tmp = AM;
    AM = RHS.AM;
    RHS.AM =tmp;
    //std.swap(AM, RHS.AM);
    return /*Deref*/this;
  }

  
  /// \brief Run the analysis pass and create our proxy result object.
  ///
  /// This doesn't do any interesting work, it is primarily used to insert our
  /// proxy result object into the module analysis cache so that we can proxy
  /// invalidation to the function analysis manager.
  ///
  /// In debug builds, it will also assert that the analysis manager is empty
  /// as no queries should arrive at the function analysis manager prior to
  /// this analysis being requested.
  //<editor-fold defaultstate="collapsed" desc="llvm::InnerAnalysisManagerProxy::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 753,
   FQN="llvm::InnerAnalysisManagerProxy::run", NM="_ZN4llvm25InnerAnalysisManagerProxy3runERT0_RNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25InnerAnalysisManagerProxy3runERT0_RNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public Result run(final IRUnitT /*&*/ IR, final AnalysisManager<IRUnitT> /*&*/ $Prm1) {
    return new Result($Deref(AM));
  }

/*private:*/
  /*friend  AnalysisInfoMixin<InnerAnalysisManagerProxy<AnalysisManagerT, IRUnitT> >*/
  private static /*char*/byte PassID;
  
  private AnalysisManagerT /*P*/ AM;
  
  @Override public String toString() {
    return "" + "AM=" + AM // NOI18N
              + super.toString(); // NOI18N
  }
}

/// \brief A function analysis which acts as a proxy for a module analysis
/// manager.
///
/// This primarily provides an accessor to a parent module analysis manager to
/// function passes. Only the const interface of the module analysis manager is
/// provided to indicate that once inside of a function analysis pass you
/// cannot request a module analysis to actually run. Instead, the user must
/// rely on the \c getCachedResult API.
///
/// This proxy *doesn't* manage the invalidation in any way. That is handled by
/// the recursive return path of each layer of the pass manager and the
/// returned PreservedAnalysis set.
/*template <typename AnalysisManagerT, typename IRUnitT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 784,
 FQN="llvm::OuterAnalysisManagerProxy", NM="_ZN4llvm25OuterAnalysisManagerProxyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxyE")
//</editor-fold>
public static class OuterAnalysisManagerProxy</*typename*/ AnalysisManagerT extends AnalysisManager, /*typename*/ IRUnitT>  implements /*public*/ AnalysisInfoMixin<OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT> > {
/*public:*/
  /// \brief Result proxy object for \c OuterAnalysisManagerProxy.
  //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::Result">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 790,
   FQN="llvm::OuterAnalysisManagerProxy::Result", NM="_ZN4llvm25OuterAnalysisManagerProxy6ResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxy6ResultE")
  //</editor-fold>
  public static class Result</*typename*/ AnalysisManagerT extends AnalysisManager, /*typename*/ IRUnitT> implements IAnalysisResult {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::Result::Result">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 792,
     FQN="llvm::OuterAnalysisManagerProxy::Result::Result", NM="_ZN4llvm25OuterAnalysisManagerProxy6ResultC1ERKT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxy6ResultC1ERKT_")
    //</editor-fold>
    public /*explicit*/ Result(final /*const*/ AnalysisManagerT /*&*/ AM) {
      // : AM(&AM) 
      //START JInit
      this.AM = /*ParenListExpr*/$AddrOf(AM);
      //END JInit
    }

    // We have to explicitly define all the special member functions because
    // MSVC refuses to generate them.
    //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::Result::Result">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 795,
     FQN="llvm::OuterAnalysisManagerProxy::Result::Result", NM="_ZN4llvm25OuterAnalysisManagerProxy6ResultC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxy6ResultC1ERKS1_")
    //</editor-fold>
    public Result(final /*const*/ Result /*&*/ Arg) {
      // : AM(Arg.AM) 
      //START JInit
      this.AM = (AnalysisManagerT) Arg.AM;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::Result::Result">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 796,
     FQN="llvm::OuterAnalysisManagerProxy::Result::Result", NM="_ZN4llvm25OuterAnalysisManagerProxy6ResultC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxy6ResultC1EOS1_")
    //</editor-fold>
    public Result(JD$Move _dparam, final Result /*&&*/Arg) {
      // : AM(std::move(Arg.AM)) 
      //START JInit
      this.AM = (AnalysisManagerT)/*ParenListExpr*/std.move(Arg.AM);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::Result::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 797,
     FQN="llvm::OuterAnalysisManagerProxy::Result::operator=", NM="_ZN4llvm25OuterAnalysisManagerProxy6ResultaSES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxy6ResultaSES1_")
    //</editor-fold>
    public Result /*&*/ $assign(Result RHS) {
      AnalysisManagerT tmp = AM;
      AM = (AnalysisManagerT) RHS.AM;
      RHS.AM = tmp;
      //std.swap(AM, RHS.AM);
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::Result::getManager">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 802,
     FQN="llvm::OuterAnalysisManagerProxy::Result::getManager", NM="_ZNK4llvm25OuterAnalysisManagerProxy6Result10getManagerEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZNK4llvm25OuterAnalysisManagerProxy6Result10getManagerEv")
    //</editor-fold>
    public /*const*/ AnalysisManagerT /*&*/ getManager() /*const*/ {
      return $Deref(AM);
    }

    
    /// \brief Handle invalidation by ignoring it, this pass is immutable.
    //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::Result::invalidate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 805,
     FQN="llvm::OuterAnalysisManagerProxy::Result::invalidate", NM="_ZN4llvm25OuterAnalysisManagerProxy6Result10invalidateERT0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxy6Result10invalidateERT0_")
    //</editor-fold>
    public boolean invalidate(final IRUnitT /*&*/ $Prm0) {
      return false;
    }

  /*private:*/
    private /*const*/ AnalysisManagerT /*P*/ AM;
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public void print(raw_ostream OS) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void verifyDomTree() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void swap(NativeSwappable RHS) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "AM=" + AM; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 811,
   FQN="llvm::OuterAnalysisManagerProxy::OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT>", NM="_ZN4llvm25OuterAnalysisManagerProxyC1ERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxyC1ERKT_")
  //</editor-fold>
  public OuterAnalysisManagerProxy(final /*const*/ AnalysisManagerT /*&*/ AM) {
    // : AM(&AM) 
    //START JInit
    this.AM = /*ParenListExpr*/$AddrOf(AM);
    //END JInit
  }

  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 814,
   FQN="llvm::OuterAnalysisManagerProxy::OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT>", NM="_ZN4llvm25OuterAnalysisManagerProxyC1ERKNS_25OuterAnalysisManagerProxyIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxyC1ERKNS_25OuterAnalysisManagerProxyIT_T0_EE")
  //</editor-fold>
  public OuterAnalysisManagerProxy(final /*const*/ OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT> /*&*/ Arg) {
    // : AM(Arg.AM) 
    //START JInit
    this.AM = /*ParenListExpr*/Arg.AM;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 816,
   FQN="llvm::OuterAnalysisManagerProxy::OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT>", NM="_ZN4llvm25OuterAnalysisManagerProxyC1EONS_25OuterAnalysisManagerProxyIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxyC1EONS_25OuterAnalysisManagerProxyIT_T0_EE")
  //</editor-fold>
  public OuterAnalysisManagerProxy(JD$Move _dparam, final OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT> /*&&*/Arg) {
    // : AM(std::move(Arg.AM)) 
    //START JInit
    this.AM = /*ParenListExpr*/std.move(Arg.AM);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 818,
   FQN="llvm::OuterAnalysisManagerProxy::operator=", NM="_ZN4llvm25OuterAnalysisManagerProxyaSENS_25OuterAnalysisManagerProxyIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxyaSENS_25OuterAnalysisManagerProxyIT_T0_EE")
  //</editor-fold>
  public OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT> /*&*/ $assign(OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT> RHS) {
    AnalysisManagerT tmp = AM;
    AM = RHS.AM;
    RHS.AM = tmp;
    //std.swap(AM, RHS.AM);
    return /*Deref*/this;
  }

  
  /// \brief Run the analysis pass and create our proxy result object.
  /// Nothing to see here, it just forwards the \c AM reference into the
  /// result.
  //<editor-fold defaultstate="collapsed" desc="llvm::OuterAnalysisManagerProxy::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 826,
   FQN="llvm::OuterAnalysisManagerProxy::run", NM="_ZN4llvm25OuterAnalysisManagerProxy3runERT0_RNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm25OuterAnalysisManagerProxy3runERT0_RNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public Result run(final IRUnitT /*&*/ $Prm0, final AnalysisManager<IRUnitT> /*&*/ $Prm1) {
    return new Result($Deref(AM));
  }

/*private:*/
  /*friend  AnalysisInfoMixin<OuterAnalysisManagerProxy<AnalysisManagerT, IRUnitT> >*/
  private static /*char*/byte PassID;
  
  private /*const*/ AnalysisManagerT /*P*/ AM;
  
  @Override public String toString() {
    return "" + "AM=" + AM // NOI18N
              + super.toString(); // NOI18N
  }
}
} // END OF class PassManagerGlobals
