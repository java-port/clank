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
import org.llvm.adt.aliases.*;
import org.llvm.ir.java.*;


/// \brief A CRTP base used to implement analysis managers.
///
/// This class template serves as the boiler plate of an analysis manager. Any
/// analysis manager can be implemented on top of this base class. Any
/// implementation will be required to provide specific hooks:
///
/// - getResultImpl
/// - getCachedResultImpl
/// - invalidateImpl
///
/// The details of the call pattern are within.
///
/// Note that there is also a generic analysis manager template which implements
/// the above required functions along with common datastructures used for
/// managing analyses. This base class is factored so that if you need to
/// customize the handling of a specific IR unit, you can do so without
/// replicating *all* of the boilerplate.
/*template <typename DerivedT, typename IRUnitT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 324,
 FQN="llvm::detail::AnalysisManagerBase", NM="_ZN4llvm6detail19AnalysisManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBaseE")
//</editor-fold>
public abstract class AnalysisManagerBase</*typename*/ DerivedT extends AnalysisManagerBase, /*typename*/ IRUnitT>  {
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::derived_this">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 325,
   FQN="llvm::detail::AnalysisManagerBase::derived_this", NM="_ZN4llvm6detail19AnalysisManagerBase12derived_thisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBase12derived_thisEv")
  //</editor-fold>
  private DerivedT /*P*/ derived_this() {
    return ((/*static_cast*/DerivedT /*P*/ )(this));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::derived_this">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 326,
   FQN="llvm::detail::AnalysisManagerBase::derived_this", NM="_ZNK4llvm6detail19AnalysisManagerBase12derived_thisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZNK4llvm6detail19AnalysisManagerBase12derived_thisEv")
  //</editor-fold>
  private /*const*/ DerivedT /*P*/ derived_this$Const() /*const*/ {
    return ((/*static_cast*//*const*/ DerivedT /*P*/ )(this));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::AnalysisManagerBase<DerivedT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 330,
   FQN="llvm::detail::AnalysisManagerBase::AnalysisManagerBase<DerivedT, IRUnitT>", NM="_ZN4llvm6detail19AnalysisManagerBaseC1ERKNS0_19AnalysisManagerBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBaseC1ERKNS0_19AnalysisManagerBaseIT_T0_EE")
  //</editor-fold>
  protected/*private*/ AnalysisManagerBase(final /*const*/ AnalysisManagerBase<DerivedT, IRUnitT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 331,
   FQN="llvm::detail::AnalysisManagerBase::operator=", NM="_ZN4llvm6detail19AnalysisManagerBaseaSERKNS0_19AnalysisManagerBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBaseaSERKNS0_19AnalysisManagerBaseIT_T0_EE")
  //</editor-fold>
  protected/*private*/ AnalysisManagerBase<DerivedT, IRUnitT> /*&*/ $assign(final /*const*/ AnalysisManagerBase<DerivedT, IRUnitT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // JAVA: typedef detail::AnalysisResultConcept<IRUnitT> ResultConceptT
//  public final class ResultConceptT extends detail.AnalysisResultConcept<IRUnitT>{ };
  // JAVA: typedef detail::AnalysisPassConcept<IRUnitT> PassConceptT
//  public final class PassConceptT extends AnalysisPassConcept<IRUnitT>{ };
  
  // FIXME: Provide template aliases for the models when we're using C++11 in
  // a mode supporting them.
  
  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::AnalysisManagerBase<DerivedT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 342,
   FQN="llvm::detail::AnalysisManagerBase::AnalysisManagerBase<DerivedT, IRUnitT>", NM="_ZN4llvm6detail19AnalysisManagerBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBaseC1Ev")
  //</editor-fold>
  protected AnalysisManagerBase() {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::AnalysisManagerBase<DerivedT, IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 343,
   FQN="llvm::detail::AnalysisManagerBase::AnalysisManagerBase<DerivedT, IRUnitT>", NM="_ZN4llvm6detail19AnalysisManagerBaseC1EONS0_19AnalysisManagerBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBaseC1EONS0_19AnalysisManagerBaseIT_T0_EE")
  //</editor-fold>
  protected AnalysisManagerBase(JD$Move _dparam, final AnalysisManagerBase<DerivedT, IRUnitT> /*&&*/Arg) {
    // : AnalysisPasses(std::move(Arg.AnalysisPasses)) 
    //START JInit
    this.AnalysisPasses = /*ParenListExpr*/new DenseMap<Object/*void P*/ , std.unique_ptr<AnalysisPassConcept<IRUnitT> > >(std.move(Arg.AnalysisPasses));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 345,
   FQN="llvm::detail::AnalysisManagerBase::operator=", NM="_ZN4llvm6detail19AnalysisManagerBaseaSEONS0_19AnalysisManagerBaseIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBaseaSEONS0_19AnalysisManagerBaseIT_T0_EE")
  //</editor-fold>
  protected AnalysisManagerBase<DerivedT, IRUnitT> /*&*/ $assignMove(final AnalysisManagerBase<DerivedT, IRUnitT> /*&&*/RHS) {
    AnalysisPasses = std.move(RHS.AnalysisPasses);
    return /*Deref*/this;
  }

/*public:*/
  /// \brief Get the result of an analysis pass for this module.
  ///
  /// If there is not a valid cached result in the manager already, this will
  /// re-run the analysis to produce a valid result.
  /*template <typename PassT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::getResult">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 355,
   FQN="llvm::detail::AnalysisManagerBase::getResult", NM="Tpl__ZN4llvm6detail19AnalysisManagerBase9getResultERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=Tpl__ZN4llvm6detail19AnalysisManagerBase9getResultERT0_")
  //</editor-fold>
  public </*typename*/ PassT extends AnalysisInfoMixin<PassT>, /*typename*/  Result extends IAnalysisResult>  Result /*&*/ getResult(Class<PassT> clazz, final IRUnitT /*&*/ IR) {
    assert Native.$bool(AnalysisPasses.count(PassT.ID(clazz))) : "This analysis pass was not registered prior to being queried";
    
    final AnalysisResultConcept<IRUnitT> /*&*/ ResultConcept = /*derived_this().*/getResultImpl(PassT.ID(clazz), IR);
    // JAVA: typedef detail::AnalysisResultModel<IRUnitT, PassT, typename PassT::Result> ResultModelT
//    final class ResultModelT extends AnalysisResultModelTT1T2T3False<IRUnitT, PassT, PassT.Result>{ };
    return ((/*static_cast*/AnalysisResultModelTT1T2T3False<IRUnitT, PassT, Result, PreservedAnalyses> /*&*/)(ResultConcept)).Result;
  }

  
  /// \brief Get the cached result of an analysis pass for this module.
  ///
  /// This method never runs the analysis.
  ///
  /// \returns null if there is no cached result.
  /*template <typename PassT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::getCachedResult">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 372,
   FQN="llvm::detail::AnalysisManagerBase::getCachedResult", NM="Tpl__ZNK4llvm6detail19AnalysisManagerBase15getCachedResultERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=Tpl__ZNK4llvm6detail19AnalysisManagerBase15getCachedResultERT0_")
  //</editor-fold>
  public </*typename*/ PassT extends AnalysisInfoMixin<PassT>, /*typename*/ Result extends IAnalysisResult>  Result /*P*/ getCachedResult(Class<PassT> clazz, final IRUnitT /*&*/ IR) /*const*/ {
    assert Native.$bool(AnalysisPasses.count(PassT.ID(clazz))) : "This analysis pass was not registered prior to being queried";
    
    AnalysisResultConcept<IRUnitT> /*P*/ ResultConcept = /*derived_this().*/getCachedResultImpl(PassT.ID(clazz), IR);
    if (Native.$not(ResultConcept)) {
      return null;
    }
    
    // JAVA: typedef detail::AnalysisResultModel<IRUnitT, PassT, typename PassT::Result> ResultModelT
//    final class ResultModelT extends AnalysisResultModelTT1T2T3False<IRUnitT, PassT, PassT.Result>{ };
    return /*AddrOf*/((/*static_cast*/AnalysisResultModelTT1T2T3False<IRUnitT, PassT, Result, PreservedAnalyses> /*P*/)(ResultConcept)).Result;
  }

  
  /// \brief Register an analysis pass with the manager.
  ///
  /// The argument is a callable whose result is a pass. This allows passing in
  /// a lambda to construct the pass.
  ///
  /// The pass type registered is the result type of calling the argument. If
  /// that pass has already been registered, then the argument will not be
  /// called and this function will return false. Otherwise, the pass type
  /// becomes registered, with the instance provided by calling the argument
  /// once, and this function returns true.
  ///
  /// While this returns whether or not the pass type was already registered,
  /// there in't an independent way to query that as that would be prone to
  /// risky use when *querying* the analysis manager. Instead, the only
  /// supported use case is avoiding duplicate registry of an analysis. This
  /// interface also lends itself to minimizing the number of times we have to
  /// do lookups for analyses or construct complex passes only to throw them
  /// away.
  /*template <typename PassBuilderT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::registerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 404,
   FQN="llvm::detail::AnalysisManagerBase::registerPass", NM="Tpl__ZN4llvm6detail19AnalysisManagerBase12registerPassET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=Tpl__ZN4llvm6detail19AnalysisManagerBase12registerPassET_")
  //</editor-fold>
  public <PassT extends AnalysisInfoMixin<PassT> & IPass<?, IRUnitT>> boolean registerPass(Class<PassT> cls, PassBuilderT<PassT> PassBuilder) {
    // JAVA: typedef decltype(PassBuilder()) PassT
//    final class PassT extends decltype(PassBuilder.$call()){ };
    // JAVA: typedef detail::AnalysisPassModel<IRUnitT, PassT> PassModelT
//    final class PassModelT extends detail.AnalysisPassModel<IRUnitT, decltype(PassBuilder.$call())>{ };
    final std.unique_ptr<AnalysisPassConcept<IRUnitT>> /*&*/ PassPtr = AnalysisPasses.$at(AnalysisInfoMixin.ID(cls));//decltype(PassBuilder.$call()).ID());
    if (PassPtr.$bool()) {
      // Already registered this pass type!
      return false;
    }
    
    // Construct a new model around the instance returned by the builder.
    PassPtr.reset(new AnalysisPassModel(PassBuilder.$call()));
    return true;
  }

  
  /// \brief Invalidate a specific analysis pass for an IR module.
  ///
  /// Note that the analysis result can disregard invalidation.
  /*template <typename PassT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::invalidate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 421,
   FQN="llvm::detail::AnalysisManagerBase::invalidate", NM="Tpl__ZN4llvm6detail19AnalysisManagerBase10invalidateERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=Tpl__ZN4llvm6detail19AnalysisManagerBase10invalidateERT0_")
  //</editor-fold>
  public </*typename*/ PassT extends AnalysisInfoMixin<PassT>> void invalidate$T(Class<PassT> clazz, final IRUnitT /*&*/ IR) {
    assert Native.$bool(AnalysisPasses.count(PassT.ID(clazz))) : "This analysis pass was not registered prior to being invalidated";
    /*derived_this().*/invalidateImpl_voidPtr_T$R(PassT.ID(clazz), IR);
  }

  
  /// \brief Invalidate analyses cached for an IR unit.
  ///
  /// Walk through all of the analyses pertaining to this unit of IR and
  /// invalidate them unless they are preserved by the PreservedAnalyses set.
  /// We accept the PreservedAnalyses set by value and update it with each
  /// analyis pass which has been successfully invalidated and thus can be
  /// preserved going forward. The updated set is returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::invalidate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 434,
   FQN="llvm::detail::AnalysisManagerBase::invalidate", NM="_ZN4llvm6detail19AnalysisManagerBase10invalidateERT0_NS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBase10invalidateERT0_NS_17PreservedAnalysesE")
  //</editor-fold>
  public PreservedAnalyses invalidate(final IRUnitT /*&*/ IR, PreservedAnalyses PA) {
    return /*derived_this().*/invalidateImpl_T$R_PreservedAnalyses(IR, std.move(PA));
  }

/*protected:*/
  /// \brief Lookup a registered analysis pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::lookupPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 440,
   FQN="llvm::detail::AnalysisManagerBase::lookupPass", NM="_ZN4llvm6detail19AnalysisManagerBase10lookupPassEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm6detail19AnalysisManagerBase10lookupPassEPv")
  //</editor-fold>
  protected AnalysisPassConcept<IRUnitT> /*&*/ lookupPass(Object/*void P*/ PassID) {
    DenseMapIterator<Object, std_ptr.unique_ptr<AnalysisPassConcept<IRUnitT>>> PI = AnalysisPasses.find(PassID);
    assert Native.$bool(Native.$noteq(PI, AnalysisPasses.end())) : "Analysis passes must be registered prior to being queried!";
    return /*Deref*/PI.$arrow().second.$star();
  }

  
  /// \brief Lookup a registered analysis pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::detail::AnalysisManagerBase::lookupPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 448,
   FQN="llvm::detail::AnalysisManagerBase::lookupPass", NM="_ZNK4llvm6detail19AnalysisManagerBase10lookupPassEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZNK4llvm6detail19AnalysisManagerBase10lookupPassEPv")
  //</editor-fold>
  protected /*const*/AnalysisPassConcept<IRUnitT> /*&*/ lookupPass$Const(Object/*void P*/ PassID) /*const*/ {
    DenseMapIterator<Object, std_ptr.unique_ptr<AnalysisPassConcept<IRUnitT>>> PI = AnalysisPasses.find(PassID);
    assert Native.$bool(Native.$noteq(PI, AnalysisPasses.end())) : "Analysis passes must be registered prior to being queried!";
    return /*Deref*/PI.$arrow().second.$star();
  }

/*private:*/
  /// \brief Map type from module analysis pass ID to pass concept pointer.
  // JAVA: typedef DenseMap<void *, std::unique_ptr<PassConceptT> > AnalysisPassMapT
//  public final class AnalysisPassMapT extends DenseMap<Object/*void P*/ , std.unique_ptr<AnalysisPassConcept<IRUnitT> > >{ };
  
  /// \brief Collection of module analysis passes, indexed by ID.
  private DenseMap<Object/*void P*/ , std.unique_ptr<AnalysisPassConcept<IRUnitT> > > AnalysisPasses;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected abstract AnalysisResultConcept<IRUnitT> /*P*/ getCachedResultImpl(Object/*void P*/ PassID, final IRUnitT /*&*/ IR);
  
  protected abstract AnalysisResultConcept<IRUnitT> /*&*/ getResultImpl(Object/*void P*/ PassID, final IRUnitT /*&*/ IR);
  
  protected abstract void invalidateImpl_voidPtr_T$R(Object/*void P*/ PassID, final IRUnitT /*&*/ IR);
  
  protected abstract PreservedAnalyses invalidateImpl_T$R_PreservedAnalyses(final IRUnitT /*&*/ IR, PreservedAnalyses PA);


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "AnalysisPasses=" + AnalysisPasses; // NOI18N
  }
}
