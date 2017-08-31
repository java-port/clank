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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.DenseMapInfoPairPtrPtr;
import static org.llvm.support.llvm.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;

// End namespace detail

/// \brief A generic analysis pass manager with lazy running and caching of
/// results.
///
/// This analysis manager can be used for any IR unit where the address of the
/// IR unit sufficies as its identity. It manages the cache for a unit of IR via
/// the address of each unit of IR cached.
/*template <typename IRUnitT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 471,
 FQN="llvm::AnalysisManager", NM="_ZN4llvm15AnalysisManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManagerE")
//</editor-fold>
public class AnalysisManager</*typename*/ IRUnitT /*extends Named*/>  extends /*public*/ AnalysisManagerBase<AnalysisManager<IRUnitT>, IRUnitT> implements Destructors.ClassWithDestructor {
  /*friend  class detail::AnalysisManagerBase<AnalysisManager<IRUnitT>, IRUnitT>*/
  // JAVA: typedef detail::AnalysisManagerBase<AnalysisManager<IRUnitT>, IRUnitT> BaseT
//  public final class BaseT extends detail.AnalysisManagerBase<AnalysisManager<IRUnitT>, IRUnitT>{ };
  // JAVA: typedef typename BaseT::ResultConceptT ResultConceptT
//  public final class ResultConceptT extends AnalysisResultConcept<IRUnitT>{ };
  // JAVA: typedef typename BaseT::PassConceptT PassConceptT
//  public final class PassConceptT extends  detail.AnalysisManagerBase.PassConceptT<AnalysisManager<IRUnitT>, IRUnitT>{ };
/*public:*/
  // Most public APIs are inherited from the CRTP base class.

  /// \brief Construct an empty analysis manager.
  ///
  /// A flag can be passed to indicate that the manager should perform debug
  /// logging.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::AnalysisManager<IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 486,
   FQN="llvm::AnalysisManager::AnalysisManager<IRUnitT>", NM="_ZN4llvm15AnalysisManagerC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManagerC1Eb")
  //</editor-fold>
  public AnalysisManager() {
    this(false);
  }
  public AnalysisManager(boolean DebugLogging/*= false*/) {
    // : DebugLogging(DebugLogging)
    //START JInit
    this.AnalysisResultLists = new DenseMap<IRUnitT /*P*/ , std.list<std.pairPtrType<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> >>>>(DenseMapInfo$LikePtr.$Info(), new std.list<std.pairPtrType<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> >>>());
    this.AnalysisResults = new DenseMap<std.pairPtrPtr<Object/*void P*/ , IRUnitT /*P*/ >, std.list.iterator<std.pairPtrType<Object/*void P*/ , unique_ptr<AnalysisResultConcept<IRUnitT>>>>>(
              DenseMapInfoPairPtrPtr.</*void P*/ Object, IRUnitT /*P*/>$Info(),
              new std.list.iterator<std.pairPtrType<Object/*void P*/ , unique_ptr<AnalysisResultConcept<IRUnitT>>>>());
    this.DebugLogging = DebugLogging;
    //END JInit
  }


  // We have to explicitly define all the special member functions because MSVC
  // refuses to generate them.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::AnalysisManager<IRUnitT>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 490,
   FQN="llvm::AnalysisManager::AnalysisManager<IRUnitT>", NM="_ZN4llvm15AnalysisManagerC1EONS_15AnalysisManagerIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManagerC1EONS_15AnalysisManagerIT_EE")
  //</editor-fold>
  public AnalysisManager(JD$Move _dparam, final AnalysisManager<IRUnitT> /*&&*/Arg) {
    // : BaseT(std::move(static_cast<BaseT & >(Arg))), AnalysisResults(std::move(Arg.AnalysisResults)), DebugLogging(std::move(Arg.DebugLogging))
    //START JInit
    /*ParenListExpr*/super(std.move(((/*static_cast*/AnalysisManagerBase<AnalysisManager<IRUnitT>, IRUnitT> /*&*/ )(Arg))));
    this.AnalysisResults = /*ParenListExpr*/new DenseMap<std.pairPtrPtr<Object/*void P*/ , IRUnitT /*P*/ >, std.list.iterator<std.pairPtrType<Object/*void P*/ , unique_ptr<AnalysisResultConcept<IRUnitT>>>>>(JD$Move.INSTANCE, std.move(Arg.AnalysisResults));
    this.DebugLogging = Arg.DebugLogging;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::operator=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 494,
   FQN="llvm::AnalysisManager::operator=", NM="_ZN4llvm15AnalysisManageraSEONS_15AnalysisManagerIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManageraSEONS_15AnalysisManagerIT_EE")
  //</editor-fold>
  public AnalysisManager<IRUnitT> /*&*/ $assignMove(final AnalysisManager<IRUnitT> /*&&*/RHS) {
    super.$assignMove(std.move(((/*static_cast*/AnalysisManagerBase<AnalysisManager<IRUnitT>, IRUnitT> /*&*/ )(RHS))));
    AnalysisResults = std.move(RHS.AnalysisResults);
    DebugLogging = std.move(RHS.DebugLogging);
    return /*Deref*/this;
  }


  /// \brief Returns true if the analysis manager has an empty results cache.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 502,
   FQN="llvm::AnalysisManager::empty", NM="_ZNK4llvm15AnalysisManager5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZNK4llvm15AnalysisManager5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    assert Native.$bool(Native.$eq(AnalysisResults.empty(), AnalysisResultLists.empty())) : "The storage and index of analysis results disagree on how many there are!";
    return AnalysisResults.empty();
  }


  /// \brief Clear the analysis result cache.
  ///
  /// This routine allows cleaning up when the set of IR units itself has
  /// potentially changed, and thus we can't even look up a a result and
  /// invalidate it directly. Notably, this does *not* call invalidate functions
  /// as there is nothing to be done for them.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 515,
   FQN="llvm::AnalysisManager::clear", NM="_ZN4llvm15AnalysisManager5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManager5clearEv")
  //</editor-fold>
  public void clear() {
    AnalysisResults.clear();
    AnalysisResultLists.clear();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::AnalysisManager<IRUnitT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 521,
   FQN="llvm::AnalysisManager::AnalysisManager<IRUnitT>", NM="_ZN4llvm15AnalysisManagerC1ERKNS_15AnalysisManagerIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManagerC1ERKNS_15AnalysisManagerIT_EE")
  //</editor-fold>
  protected/*private*/ AnalysisManager(final /*const*/ AnalysisManager<IRUnitT> /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 522,
   FQN="llvm::AnalysisManager::operator=", NM="_ZN4llvm15AnalysisManageraSERKNS_15AnalysisManagerIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManageraSERKNS_15AnalysisManagerIT_EE")
  //</editor-fold>
  protected/*private*/ AnalysisManager<IRUnitT> /*&*/ $assign(final /*const*/ AnalysisManager<IRUnitT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}


  /// \brief Get an analysis result, running the pass if necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::getResultImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 525,
   FQN="llvm::AnalysisManager::getResultImpl", NM="_ZN4llvm15AnalysisManager13getResultImplEPvRT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManager13getResultImplEPvRT_")
  //</editor-fold>
  protected/*private*/ AnalysisResultConcept<IRUnitT> /*&*/ getResultImpl(Object/*void P*/ PassID, final IRUnitT /*&*/ IR) {
    DenseMapIterator<pairPtrPtr<Object/*void P*/ , IRUnitT /*P*/ >,  std.list.iterator<pairPtrType<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> > > > > RI;
    boolean Inserted = false;
    //std.tie(RI, Inserted) = AnalysisResults.insert(std.make_pair(std.make_pair(PassID, $AddrOf(IR)), new  std.list.iterator<pairPtrType<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> > > >()));
    pairTypeBool<DenseMapIterator<pairPtrPtr<Object, IRUnitT>, std_list.list.iterator<pairPtrType<Object, std_ptr.unique_ptr<AnalysisResultConcept<IRUnitT>>>>>> $pair = AnalysisResults.insert_pair$KeyT$ValueT(std.make_pair($Move(std.make_pair_Ptr_Ptr(PassID, $AddrOf(IR))), new std.list.iterator<std.pairPtrType<Object/*void P*/ , unique_ptr<AnalysisResultConcept<IRUnitT>>>>()));
    //JAVA: expand std.tie(RI, Inserted).$assign($pair);
    RI = $pair.first;
    Inserted = $pair.second;

    // If we don't have a cached result for this function, look up the pass and
    // run it to produce a result, which we then add to the cache.
    if (Inserted) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        final AnalysisPassConcept<IRUnitT> /*&*/ P = /*J:ToBase*/super.lookupPass(PassID);
        if (DebugLogging) {
          dbgs().$out(/*KEEP_STR*/"Running analysis: ").$out(P.name()).$out(/*KEEP_STR*/$LF);
        }
        final std.list<std.pairPtrType<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> >>> /*&*/ ResultList = AnalysisResultLists.$at_T1$RR($AddrOf(IR));
        ResultList.emplace_back(new std.pairPtrType<Object/*void P*/ , unique_ptr<AnalysisResultConcept<IRUnitT>>>(PassID, $Move($c$.track(P.run(IR, /*Deref*/this))))); $c$.clean();

        // P.run may have inserted elements into AnalysisResults and invalidated
        // RI.
        RI.$assignMove(AnalysisResults.find(std.make_pair_Ptr_Ptr(PassID, $AddrOf(IR))));
        assert (RI.$noteq(/*NO_ITER_COPY*/AnalysisResults.end())) : "we just inserted it!";

        RI.$arrow().second.$assignMove(std.prev(ResultList.end()));
      } finally {
        $c$.$destroy();
      }
    }

    return RI.$arrow().second.$arrow().second.$star();
  }


  /// \brief Get a cached analysis result or return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::getCachedResultImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 552,
   FQN="llvm::AnalysisManager::getCachedResultImpl", NM="_ZNK4llvm15AnalysisManager19getCachedResultImplEPvRT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZNK4llvm15AnalysisManager19getCachedResultImplEPvRT_")
  //</editor-fold>
  protected/*private*/ AnalysisResultConcept<IRUnitT> /*P*/ getCachedResultImpl(Object/*void P*/ PassID, final IRUnitT /*&*/ IR) /*const*/ {
    DenseMapIterator<pairPtrPtr<Object, IRUnitT>, std_list.list.iterator<pairPtrType<Object, std_ptr.unique_ptr<AnalysisResultConcept<IRUnitT>>>>> RI = AnalysisResults.find(std.make_pair_Ptr_Ptr(PassID, $AddrOf(IR)));
    return Native.$eq(RI, AnalysisResults.end()) ? null : $AddrOf(/*$Deref(*/RI.$arrow().second.$arrow().second.$star()/*)*/);
  }


  /// \brief Invalidate a function pass result.
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::invalidateImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 559,
   FQN="llvm::AnalysisManager::invalidateImpl", NM="_ZN4llvm15AnalysisManager14invalidateImplEPvRT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManager14invalidateImplEPvRT_")
  //</editor-fold>
  protected/*private*/ void invalidateImpl_voidPtr_T$R(Object/*void P*/ PassID, final IRUnitT /*&*/ IR) {
    DenseMapIterator<pairPtrPtr<Object, IRUnitT>, std_list.list.iterator<pairPtrType<Object, std_ptr.unique_ptr<AnalysisResultConcept<IRUnitT>>>>> RI = AnalysisResults.find(std.make_pair_Ptr_Ptr(PassID, $AddrOf(IR)));
    if (Native.$eq(RI, AnalysisResults.end())) {
      return;
    }
    if (DebugLogging) {
      dbgs().$out(/*KEEP_STR*/"Invalidating analysis: ").$out(this.lookupPass(PassID).name()).$out($LF);
    }
    AnalysisResultLists.$at($AddrOf(IR)).erase(RI.$arrow().second);
    AnalysisResults.erase(RI);
  }


  /// \brief Invalidate the results for a function..
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager::invalidateImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 573,
   FQN="llvm::AnalysisManager::invalidateImpl", NM="_ZN4llvm15AnalysisManager14invalidateImplERT_NS_17PreservedAnalysesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManager14invalidateImplERT_NS_17PreservedAnalysesE")
  //</editor-fold>
  protected/*private*/ PreservedAnalyses invalidateImpl_T$R_PreservedAnalyses(final IRUnitT /*&*/ IR, PreservedAnalyses PA) {
    // Short circuit for a common case of all analyses being preserved.
    if (PA.areAllPreserved()) {
      return new PreservedAnalyses(JD$Move.INSTANCE, PA);
    }
    if (DebugLogging) {
      dbgs().$out(/*KEEP_STR*/"Invalidating all non-preserved analyses for: ").$out(IR/*.getName()*/).$out($LF);
    }

    // Clear all the invalidated results associated specifically with this
    // function.
    SmallVector<Object/*void P*/> InvalidatedPassIDs/*J*/= new SmallVector<Object/*void P*/>(8, null);
    std_list.list<pairPtrType<Object, std_ptr.unique_ptr<AnalysisResultConcept<IRUnitT>>>> ResultsList = AnalysisResultLists.$at($AddrOf(IR));
    for ( std.list.iterator<pairPtrType<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> > > > I = ResultsList.begin(),
        E = ResultsList.end();
         Native.$noteq(I, E);) {
      Object/*void P*/ PassID = I.$arrow().first;

      // Pass the invalidation down to the pass itself to see if it thinks it is
      // necessary. The analysis pass can return false if no action on the part
      // of the analysis manager is required for this invalidation event.
      if (I.$arrow().second.$arrow().invalidate(IR, PA)) {
        if (DebugLogging) {
          dbgs().$out(/*KEEP_STR*/"Invalidating analysis: ").$out(this.lookupPass(PassID).name()).$out($LF);
        }

        InvalidatedPassIDs.push_back(I.$arrow().first);
        I = ResultsList.erase(I);
      } else {
        I.$preInc();
      }

      // After handling each pass, we mark it as preserved. Once we've
      // invalidated any stale results, the rest of the system is allowed to
      // start preserving this analysis again.
      PA.preserve(PassID);
    }
    while (!InvalidatedPassIDs.empty()) {
      AnalysisResults.erase(std.make_pair_Ptr_Ptr(InvalidatedPassIDs.pop_back_val(), $AddrOf(IR)));
    }
    if (ResultsList.empty()) {
      AnalysisResultLists.erase($AddrOf(IR));
    }

    return new PreservedAnalyses(JD$Move.INSTANCE, PA);
  }


  /// \brief List of function analysis pass IDs and associated concept pointers.
  ///
  /// Requires iterators to be valid across appending new entries and arbitrary
  /// erases. Provides both the pass ID and concept pointer such that it is
  /// half of a bijection and provides storage for the actual result concept.
  // JAVA: typedef std::list<std::pair<void *, std::unique_ptr<detail::AnalysisResultConcept<IRUnitT> > > > AnalysisResultListT
//  public final class AnalysisResultListT extends std.list<std.pair<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> > > >{ };

  /// \brief Map type from function pointer to our custom list type.
  // JAVA: typedef DenseMap<IRUnitT *, AnalysisResultListT> AnalysisResultListMapT
//  public final class AnalysisResultListMapT extends DenseMap<IRUnitT /*P*/ , std.list<std.pair<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> > > > >{ };

  /// \brief Map from function to a list of function analysis results.
  ///
  /// Provides linear time removal of all analysis results for a function and
  /// the ultimate storage for a particular cached analysis result.
  private DenseMap<IRUnitT /*P*/ , std.list<std.pairPtrType<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> > > > > AnalysisResultLists;

  /// \brief Map type from a pair of analysis ID and function pointer to an
  /// iterator into a particular result list.
  // JAVA: typedef DenseMap<std::pair<void *, IRUnitT *>, typename AnalysisResultListT::iterator> AnalysisResultMapT
//  public final class AnalysisResultMapT extends DenseMap<std.pair<Object/*void P*/ , IRUnitT /*P*/ >,  std.list.iterator<std.pair<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> > > > >{ };

  /// \brief Map from an analysis ID and function to a particular cached
  /// analysis result.
  private DenseMap<std.pairPtrPtr<Object/*void P*/ , IRUnitT /*P*/ >,  std.list.iterator<std.pairPtrType<Object/*void P*/ , std.unique_ptr<AnalysisResultConcept<IRUnitT> > > > > AnalysisResults;

  /// \brief A flag indicating whether debug logging is enabled.
  private boolean DebugLogging;
  //<editor-fold defaultstate="collapsed" desc="llvm::AnalysisManager<Function>::~AnalysisManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 655,
   FQN="llvm::AnalysisManager<Function>::~AnalysisManager", NM="_ZN4llvm15AnalysisManagerINS_8FunctionEED0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/PassManager.cpp -nm=_ZN4llvm15AnalysisManagerINS_8FunctionEED0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }



  @Override public String toString() {
    return "" + "AnalysisResultLists=" + AnalysisResultLists // NOI18N
              + ", AnalysisResults=" + AnalysisResults // NOI18N
              + ", DebugLogging=" + DebugLogging // NOI18N
              + super.toString(); // NOI18N
  }
}
