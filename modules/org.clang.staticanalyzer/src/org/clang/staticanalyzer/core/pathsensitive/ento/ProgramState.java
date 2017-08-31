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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import static org.clang.staticanalyzer.checkers.ento.EntoGlobals.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.checkers.impl.MallocCheckerStatics;
import org.clang.staticanalyzer.checkers.impl.RetainCountCheckerStatics;
import org.clang.staticanalyzer.checkers.impl.SimpleStreamCheckerStatics;
import org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals;


/// \class ProgramState
/// ProgramState - This class encapsulates:
///
///    1. A mapping from expressions to values (Environment)
///    2. A mapping from locations to values (Store)
///    3. Constraints on symbolic values (GenericDataMap)
///
///  Together these represent the "abstract state" of a program.
///
///  ProgramState is intended to be used as a functional object; that is,
///  once it is created and made "persistent" in a FoldingSet, its
///  values will never change.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 74,
 FQN="clang::ento::ProgramState", NM="_ZN5clang4ento12ProgramStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento12ProgramStateE")
//</editor-fold>
public class ProgramState extends FoldingSetImpl.NodeImpl$Tracker implements /*public*/ FoldingSetImpl.Node, RefCountedBaseImplementation, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef llvm::ImmutableSet<llvm::APSInt *> IntSetTy
//  public final class IntSetTy extends ImmutableSetPtr<APSInt /*P*/ >{ };
  // JAVA: typedef llvm::ImmutableMap<void *, void *> GenericDataMap
//  public final class GenericDataMap extends ImmutableMap<Object/*void P*/ , Object/*void P*/ >{ };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 80,
   FQN="clang::ento::ProgramState::operator=", NM="_ZN5clang4ento12ProgramStateaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento12ProgramStateaSERKS1_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ ProgramState /*&*/ R) { throw new UnsupportedOperationException("Deleted");}

  
  /*friend  class ProgramStateManager*/
  /*friend  class ExplodedGraph*/
  /*friend  class ExplodedNode*/
  
  private ProgramStateManager /*P*/ stateMgr;
  /*friend*/public/*private*/ Environment Env; // Maps a Stmt to its current SVal.
  /*friend*/public/*private*/ /*const*/Object/*void P*/ store; // Maps a location to its current value.
  /*friend*/public/*private*/ ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ > GDM; // Custom data stored by a client of this class.
  /*friend*/public/*private*/ /*uint*/int refCount;
  
  /// makeWithStore - Return a ProgramState with the same values as the current
  ///  state with the exception of using the specified Store.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::makeWithStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 403,
   FQN="clang::ento::ProgramState::makeWithStore", NM="_ZNK5clang4ento12ProgramState13makeWithStoreERKNS0_8StoreRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState13makeWithStoreERKNS0_8StoreRefE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> makeWithStore(final /*const*/ StoreRef /*&*/ store) /*const*/ {
    ProgramState NewSt = null;
    try {
      NewSt/*J*/= new ProgramState(/*Deref*/this);
      NewSt.setStore(store);
      return getStateManager().getPersistentState(NewSt);
    } finally {
      if (NewSt != null) { NewSt.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::setStore">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 409,
   FQN="clang::ento::ProgramState::setStore", NM="_ZN5clang4ento12ProgramState8setStoreERKNS0_8StoreRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento12ProgramState8setStoreERKNS0_8StoreRefE")
  //</editor-fold>
  /*friend*/public/*private*/ void setStore(final /*const*/ StoreRef /*&*/ newStore) {
    assert checkAlive();
    /*const*/Object/*void P*/ newStoreStore = newStore.getStore();
    if ((newStoreStore != null)) {
      stateMgr.getStoreManager().incrementReferenceCount(newStoreStore);
    }
    if ((store != null)) {
      stateMgr.getStoreManager().decrementReferenceCount(store);
    }
    store = newStoreStore;
  }

/*public:*/
  /// This ctor is used when creating the first ProgramState object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::ProgramState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 45,
   FQN="clang::ento::ProgramState::ProgramState", NM="_ZN5clang4ento12ProgramStateC1EPNS0_19ProgramStateManagerERKNS0_11EnvironmentENS0_8StoreRefEN4llvm12ImmutableMapIPvSA_NS8_16ImutKeyValueInfoISA_SA_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento12ProgramStateC1EPNS0_19ProgramStateManagerERKNS0_11EnvironmentENS0_8StoreRefEN4llvm12ImmutableMapIPvSA_NS8_16ImutKeyValueInfoISA_SA_EEEE")
  //</editor-fold>
  public ProgramState(ProgramStateManager /*P*/ mgr, final /*const*/ Environment /*&*/ env, 
      StoreRef st, ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ > gdm) {
    // : FoldingSetNode(), stateMgr(mgr), Env(env), store(st.getStore()), GDM(gdm), refCount(0) 
    //START JInit
    $Node();
    this.stateMgr = mgr;
    this.Env = new Environment(env);
    this.store = st.getStore();
    this.GDM = new ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ >(gdm);
    this.refCount = 0;
    //END JInit
    stateMgr.getStoreManager().incrementReferenceCount(store);
  }

  
  /// Copy ctor - We must explicitly define this or else the "Next" ptr
  ///  in FoldingSetNode will also get copied.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::ProgramState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 55,
   FQN="clang::ento::ProgramState::ProgramState", NM="_ZN5clang4ento12ProgramStateC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento12ProgramStateC1ERKS1_")
  //</editor-fold>
  public ProgramState(final /*const*/ ProgramState /*&*/ RHS) {
    // : FoldingSetNode(), stateMgr(RHS.stateMgr), Env(RHS.Env), store(RHS.store), GDM(RHS.GDM), refCount(0) 
    //START JInit
    assert RHS.checkAlive();
    $Node();
    this.stateMgr = RHS.stateMgr;
    this.Env = new Environment(RHS.Env);
    this.store = RHS.store;
    this.GDM = new ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ >(RHS.GDM);
    this.refCount = 0;
    //END JInit
    stateMgr.getStoreManager().incrementReferenceCount(store);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::~ProgramState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 65,
   FQN="clang::ento::ProgramState::~ProgramState", NM="_ZN5clang4ento12ProgramStateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento12ProgramStateD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert checkAlive();
    if ((store != null)) {
      stateMgr.getStoreManager().decrementReferenceCount(store);
    }
    //START JDestroy
    GDM.$destroy();
    Env.$destroy();
    FoldingSetImpl.Node.super.$destroy$Node();
    //END JDestroy
  }

  
  /// Return the ProgramStateManager associated with this state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getStateManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 110,
   FQN="clang::ento::ProgramState::getStateManager", NM="_ZNK5clang4ento12ProgramState15getStateManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState15getStateManagerEv")
  //</editor-fold>
  public ProgramStateManager /*&*/ getStateManager() /*const*/ {
    assert checkAlive();
    return $Deref(stateMgr);
  }

  
  /// Return the ConstraintManager.
  
  //===----------------------------------------------------------------------===//
  // Out-of-line method definitions for ProgramState.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getConstraintManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 633,
   FQN="clang::ento::ProgramState::getConstraintManager", NM="_ZNK5clang4ento12ProgramState20getConstraintManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState20getConstraintManagerEv")
  //</editor-fold>
  public /*inline*/ ConstraintManager /*&*/ getConstraintManager() /*const*/ {
    assert checkAlive();
    return stateMgr.getConstraintManager();
  }

  
  /// getEnvironment - Return the environment associated with this state.
  ///  The environment is the mapping from expressions to values.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getEnvironment">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 119,
   FQN="clang::ento::ProgramState::getEnvironment", NM="_ZNK5clang4ento12ProgramState14getEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState14getEnvironmentEv")
  //</editor-fold>
  public /*const*/ Environment /*&*/ getEnvironment() /*const*/ {
    assert checkAlive();
    return Env;
  }

  
  /// Return the store associated with this state.  The store
  ///  is a mapping from locations to values.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getStore">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 123,
   FQN="clang::ento::ProgramState::getStore", NM="_ZNK5clang4ento12ProgramState8getStoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState8getStoreEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getStore() /*const*/ {
    assert checkAlive();
    return store;
  }

  
  /// getGDM - Return the generic data map associated with this state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getGDM">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 127,
   FQN="clang::ento::ProgramState::getGDM", NM="_ZNK5clang4ento12ProgramState6getGDMEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState6getGDMEv")
  //</editor-fold>
  public ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ > getGDM() /*const*/ {
    assert checkAlive();
    return new ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ >(GDM);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::setGDM">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 129,
   FQN="clang::ento::ProgramState::setGDM", NM="_ZN5clang4ento12ProgramState6setGDMEN4llvm12ImmutableMapIPvS4_NS2_16ImutKeyValueInfoIS4_S4_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento12ProgramState6setGDMEN4llvm12ImmutableMapIPvS4_NS2_16ImutKeyValueInfoIS4_S4_EEEE")
  //</editor-fold>
  public void setGDM(ImmutableMapPtrPtr<Object/*void P*/ , Object/*void P*/ > gdm) {
    assert checkAlive();
    GDM.$assign(gdm);
  }

  
  /// Profile - Profile the contents of a ProgramState object for use in a
  ///  FoldingSet.  Two ProgramState objects are considered equal if they
  ///  have the same Environment, Store, and GenericDataMap.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 134,
   FQN="clang::ento::ProgramState::Profile", NM="_ZN5clang4ento12ProgramState7ProfileERN4llvm16FoldingSetNodeIDEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento12ProgramState7ProfileERN4llvm16FoldingSetNodeIDEPKS1_")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, /*const*/ ProgramState /*P*/ V) {
    assert V.checkAlive();
    V.Env.Profile(ID);
    ID.AddPointer(V.store);
    V.GDM.Profile(ID);
  }

  
  /// Profile - Used to profile the contents of this object for inclusion
  ///  in a FoldingSet.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 142,
   FQN="clang::ento::ProgramState::Profile", NM="_ZNK5clang4ento12ProgramState7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public/*public*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    assert checkAlive();
    Profile(ID, this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getBasicVals">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 756,
   FQN="clang::ento::ProgramState::getBasicVals", NM="_ZNK5clang4ento12ProgramState12getBasicValsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState12getBasicValsEv")
  //</editor-fold>
  public /*inline*/ BasicValueFactory /*&*/ getBasicVals() /*const*/ {
    assert checkAlive();
    return getStateManager().getBasicVals();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getSymbolManager">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 760,
   FQN="clang::ento::ProgramState::getSymbolManager", NM="_ZNK5clang4ento12ProgramState16getSymbolManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState16getSymbolManagerEv")
  //</editor-fold>
  public /*inline*/ SymbolManager /*&*/ getSymbolManager() /*const*/ {
    assert checkAlive();
    return getStateManager().getSymbolManager();
  }

  
  //==---------------------------------------------------------------------==//
  // Constraints on values.
  //==---------------------------------------------------------------------==//
  //
  // Each ProgramState records constraints on symbolic values.  These constraints
  // are managed using the ConstraintManager associated with a ProgramStateManager.
  // As constraints gradually accrue on symbolic values, added constraints
  // may conflict and indicate that a state is infeasible (as no real values
  // could satisfy all the constraints).  This is the principal mechanism
  // for modeling path-sensitivity in ExprEngine/ProgramState.
  //
  // Various "assume" methods form the interface for adding constraints to
  // symbolic values.  A call to 'assume' indicates an assumption being placed
  // on one or symbolic values.  'assume' methods take the following inputs:
  //
  //  (1) A ProgramState object representing the current state.
  //
  //  (2) The assumed constraint (which is specific to a given "assume" method).
  //
  //  (3) A binary value "Assumption" that indicates whether the constraint is
  //      assumed to be true or false.
  //
  // The output of "assume*" is a new ProgramState object with the added constraints.
  // If no new state is feasible, NULL is returned.
  //
  
  /// Assumes that the value of \p cond is zero (if \p assumption is "false")
  /// or non-zero (if \p assumption is "true").
  ///
  /// This returns a new state with the added constraint on \p cond.
  /// If no new state is feasible, NULL is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::assume">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 643,
   FQN="clang::ento::ProgramState::assume", NM="_ZNK5clang4ento12ProgramState6assumeENS0_20DefinedOrUnknownSValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState6assumeENS0_20DefinedOrUnknownSValEb")
  //</editor-fold>
  public /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> assume(DefinedOrUnknownSVal Cond, 
        boolean Assumption) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Cond.isUnknown$SVal()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
      }
      
      return $c$.clean(getStateManager().ConstraintMgr.$arrow().
          assume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), Cond.castAs(DefinedSVal.class), Assumption));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Assumes both "true" and "false" for \p cond, and returns both
  /// corresponding states (respectively).
  ///
  /// This is more efficient than calling assume() twice. Note that one (but not
  /// both) of the returned states may be NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::assume">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 652,
   FQN="clang::ento::ProgramState::assume", NM="_ZNK5clang4ento12ProgramState6assumeENS0_20DefinedOrUnknownSValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState6assumeENS0_20DefinedOrUnknownSValE")
  //</editor-fold>
  public /*inline*/ std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> assume(DefinedOrUnknownSVal Cond) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Cond.isUnknown$SVal()) {
        return new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>(JD$Pair$_U1$_U2.INSTANCE, new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd2*//*Fwd*/this), new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd2*//*Fwd*/this));
      }
      
      return $c$.clean(getStateManager().ConstraintMgr.$arrow().
          assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), Cond.castAs(DefinedSVal.class)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::assumeInBound">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 304,
   FQN="clang::ento::ProgramState::assumeInBound", NM="_ZNK5clang4ento12ProgramState13assumeInBoundENS0_20DefinedOrUnknownSValES2_bNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState13assumeInBoundENS0_20DefinedOrUnknownSValES2_bNS_8QualTypeE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> assumeInBound(DefinedOrUnknownSVal Idx, 
               DefinedOrUnknownSVal UpperBound, 
               boolean Assumption) /*const*/ {
    return assumeInBound(Idx, 
               UpperBound, 
               Assumption, 
               new QualType());
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> assumeInBound(DefinedOrUnknownSVal Idx, 
               DefinedOrUnknownSVal UpperBound, 
               boolean Assumption, 
               QualType indexTy/*= QualType()*/) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Idx.isUnknown$SVal() || UpperBound.isUnknown$SVal()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
      }
      
      // Build an expression for 0 <= Idx < UpperBound.
      // This is the same as Idx + MIN < UpperBound + MIN, if overflow is allowed.
      // FIXME: This should probably be part of SValBuilder.
      final ProgramStateManager /*&*/ SM = getStateManager();
      final SValBuilder /*&*/ svalBuilder = SM.getSValBuilder();
      final ASTContext /*&*/ Ctx = svalBuilder.getContext();
      
      // Get the offset: the minimum value of the array index type.
      final BasicValueFactory /*&*/ BVF = svalBuilder.getBasicValueFactory();
      // FIXME: This should be using ValueManager::ArrayindexTy...somehow.
      if (indexTy.isNull()) {
        indexTy.$assignMove(Ctx.IntTy.$QualType());
      }
      NsNonloc.ConcreteInt Min/*J*/= new NsNonloc.ConcreteInt(BVF.getMinValue(new QualType(indexTy)));
      
      // Adjust the index.
      SVal newIdx = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), BinaryOperatorKind.BO_Add, 
          Idx.castAs(NonLoc.class), new NonLoc(Min), new QualType(indexTy)));
      if (newIdx.isUnknownOrUndef$SVal()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
      }
      
      // Adjust the upper bound.
      SVal newBound = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), BinaryOperatorKind.BO_Add, UpperBound.castAs(NonLoc.class), 
          new NonLoc(Min), new QualType(indexTy)));
      if (newBound.isUnknownOrUndef$SVal()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
      }
      
      // Build the actual comparison.
      SVal inBound = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), BinaryOperatorKind.BO_LT, newIdx.castAs(NonLoc.class), 
          newBound.castAs(NonLoc.class), Ctx.IntTy.$QualType()));
      if (inBound.isUnknownOrUndef$SVal()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
      }
      
      // Finally, let the constraint manager take care of it.
      final ConstraintManager /*&*/ CM = SM.getConstraintManager();
      return $c$.clean(CM.assume($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), inBound.castAs(DefinedSVal.class), Assumption));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Assumes that the value of \p Val is bounded with [\p From; \p To]
  /// (if \p assumption is "true") or it is fully out of this range
  /// (if \p assumption is "false").
  ///
  /// This returns a new state with the added constraint on \p cond.
  /// If no new state is feasible, NULL is returned.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::assumeWithinInclusiveRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 661,
   FQN="clang::ento::ProgramState::assumeWithinInclusiveRange", NM="_ZNK5clang4ento12ProgramState26assumeWithinInclusiveRangeENS0_20DefinedOrUnknownSValERKN4llvm6APSIntES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState26assumeWithinInclusiveRangeENS0_20DefinedOrUnknownSValERKN4llvm6APSIntES6_b")
  //</editor-fold>
  public /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> assumeWithinInclusiveRange(DefinedOrUnknownSVal Val, 
                            final /*const*/ APSInt /*&*/ From, 
                            final /*const*/ APSInt /*&*/ To, 
                            boolean Assumption) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Val.isUnknown$SVal()) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
      }
      assert (Val.getAs(NonLoc.class).$bool()) : "Only NonLocs are supported!";
      
      return $c$.clean(getStateManager().ConstraintMgr.$arrow().assumeWithinInclusiveRange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), Val.castAs(NonLoc.class), From, To, Assumption));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Assumes given range both "true" and "false" for \p Val, and returns both
  /// corresponding states (respectively).
  ///
  /// This is more efficient than calling assume() twice. Note that one (but not
  /// both) of the returned states may be NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::assumeWithinInclusiveRange">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair and other*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 675,
   FQN="clang::ento::ProgramState::assumeWithinInclusiveRange", NM="_ZNK5clang4ento12ProgramState26assumeWithinInclusiveRangeENS0_20DefinedOrUnknownSValERKN4llvm6APSIntES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState26assumeWithinInclusiveRangeENS0_20DefinedOrUnknownSValERKN4llvm6APSIntES6_")
  //</editor-fold>
  public /*inline*/ std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> assumeWithinInclusiveRange(DefinedOrUnknownSVal Val, 
                            final /*const*/ APSInt /*&*/ From, 
                            final /*const*/ APSInt /*&*/ To) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Val.isUnknown$SVal()) {
        return new std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>>(JD$Pair$_U1$_U2.INSTANCE, new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd2*//*Fwd*/this), new IntrusiveRefCntPtr</*const*/ ProgramState>(/*Fwd2*//*Fwd*/this));
      }
      assert (Val.getAs(NonLoc.class).$bool()) : "Only NonLocs are supported!";
      
      return $c$.clean(getStateManager().ConstraintMgr.$arrow().
          assumeWithinInclusiveRangeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), Val.castAs(NonLoc.class), From, To));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Check if the given SVal is constrained to zero or is a zero
  ///        constant.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::isNull">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 350,
   FQN="clang::ento::ProgramState::isNull", NM="_ZNK5clang4ento12ProgramState6isNullENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState6isNullENS0_4SValE")
  //</editor-fold>
  public ConditionTruthVal isNull(SVal V) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (V.isZeroConstant()) {
        return new ConditionTruthVal(true);
      }
      if (V.isConstant()) {
        return new ConditionTruthVal(false);
      }
      
      /*const*/ SymExpr /*P*/ Sym = V.getAsSymbol(/* IncludeBaseRegion */ true);
      if (!(Sym != null)) {
        return new ConditionTruthVal();
      }
      
      return $c$.clean(getStateManager().ConstraintMgr.$arrow().isNull($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), Sym));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Utility method for getting regions.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 637,
   FQN="clang::ento::ProgramState::getRegion", NM="_ZNK5clang4ento12ProgramState9getRegionEPKNS_7VarDeclEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9getRegionEPKNS_7VarDeclEPKNS_15LocationContextE")
  //</editor-fold>
  public /*inline*/ /*const*/ VarRegion /*P*/ getRegion(/*const*/ VarDecl /*P*/ D, 
           /*const*/ LocationContext /*P*/ LC) /*const*/ {
    assert checkAlive();
    return getStateManager().getRegionManager().getVarRegion(D, LC);
  }

  
  //==---------------------------------------------------------------------==//
  // Binding and retrieving values to/from the environment and symbolic store.
  //==---------------------------------------------------------------------==//
  
  /// Create a new state by binding the value 'V' to the statement 'S' in the
  /// state's environment.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::BindExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 290,
   FQN="clang::ento::ProgramState::BindExpr", NM="_ZNK5clang4ento12ProgramState8BindExprEPKNS_4StmtEPKNS_15LocationContextENS0_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState8BindExprEPKNS_4StmtEPKNS_15LocationContextENS0_4SValEb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> BindExpr(/*const*/ Stmt /*P*/ S, 
          /*const*/ LocationContext /*P*/ LCtx, 
          SVal V) /*const*/ {
    return BindExpr(S, 
          LCtx, 
          V, true);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> BindExpr(/*const*/ Stmt /*P*/ S, 
          /*const*/ LocationContext /*P*/ LCtx, 
          SVal V, boolean Invalidate/*= true*/) /*const*/ {
    assert checkAlive();
    Environment NewEnv = null;
    ProgramState NewSt = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      NewEnv = $c$.clean(getStateManager().EnvMgr.bindExpr($c$.track(new Environment(Env)), new EnvironmentEntry(S, LCtx), new SVal(V), 
          Invalidate));
      if (NewEnv.$eq(Env)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
      }
      
      NewSt = new ProgramState(/*Deref*/this);
      NewSt.Env.$assign(NewEnv);
      return getStateManager().getPersistentState(NewSt);
    } finally {
      if (NewSt != null) { NewSt.$destroy(); }
      if (NewEnv != null) { NewEnv.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::bindLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 114,
   FQN="clang::ento::ProgramState::bindLoc", NM="_ZNK5clang4ento12ProgramState7bindLocENS0_3LocENS0_4SValEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState7bindLocENS0_3LocENS0_4SValEb")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> bindLoc(Loc LV, SVal V) /*const*/ {
    return bindLoc(LV, V, true);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> bindLoc(Loc LV, SVal V, boolean notifyChanges/*= true*/) /*const*/ {
    assert checkAlive();
    IntrusiveRefCntPtr</*const*/ ProgramState> newState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final ProgramStateManager /*&*/ Mgr = getStateManager();
      newState = $c$.clean(makeWithStore($c$.track(Mgr.StoreMgr.$arrow().Bind(getStore(), 
              new Loc(LV), new SVal(V)))));
      /*const*/ MemRegion /*P*/ MR = LV.getAsRegion();
      if ((MR != null) && (Mgr.getOwningEngine() != null) && notifyChanges) {
        return $c$.clean(Mgr.getOwningEngine().processRegionChange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(newState)), MR));
      }
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, newState);
    } finally {
      if (newState != null) { newState.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::bindLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 688,
   FQN="clang::ento::ProgramState::bindLoc", NM="_ZNK5clang4ento12ProgramState7bindLocENS0_4SValES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState7bindLocENS0_4SValES2_")
  //</editor-fold>
  public /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> bindLoc(SVal LV, SVal V) /*const*/ {
    assert checkAlive();
    {
      Optional<Loc> L = LV.getAs(Loc.class);
      if (L.$bool()) {
        return bindLoc(new Loc(L.$star()), new SVal(V));
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::bindDefault">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 125,
   FQN="clang::ento::ProgramState::bindDefault", NM="_ZNK5clang4ento12ProgramState11bindDefaultENS0_4SValES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState11bindDefaultENS0_4SValES2_")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> bindDefault(SVal loc, SVal V) /*const*/ {
    assert checkAlive();
    /*const*/ StoreRef /*&*/  newStore = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> new_state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final ProgramStateManager /*&*/ Mgr = getStateManager();
      /*const*/ MemRegion /*P*/ R = loc.castAs(NsLoc.MemRegionVal.class).getRegion();
      /*final */ newStore = Mgr.StoreMgr.$arrow().BindDefault(getStore(), R, new SVal(V));
      new_state = makeWithStore(newStore);
      return $c$.clean((Mgr.getOwningEngine() != null) ? Mgr.getOwningEngine().processRegionChange($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(new_state)), R) : new IntrusiveRefCntPtr</*const*/ ProgramState>(new_state));
    } finally {
      if (new_state != null) { new_state.$destroy(); }
      if (newStore != null) { newStore.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::killBinding">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 214,
   FQN="clang::ento::ProgramState::killBinding", NM="_ZNK5clang4ento12ProgramState11killBindingENS0_3LocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState11killBindingENS0_3LocE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> killBinding(Loc LV) /*const*/ {
    assert checkAlive();
    /*const*/ StoreRef /*&*/  newStore = null;
    try {    
      assert (!LV.getAs(NsLoc.MemRegionVal.class).$bool()) : "Use invalidateRegion instead.";

      /*const*/Object/*void P*/ OldStore = getStore();
      /*final */ newStore = getStateManager().StoreMgr.$arrow().killBinding(OldStore, new Loc(LV));
      if ($eq_ptr(newStore.getStore(), OldStore)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
      }

      return makeWithStore(newStore);
    } finally {
      if (newStore != null) { newStore.$destroy(); }
    }      
  }

  
  /// \brief Returns the state with bindings for the given regions
  ///  cleared from the store.
  ///
  /// Optionally invalidates global regions as well.
  ///
  /// \param Regions the set of regions to be invalidated.
  /// \param E the expression that caused the invalidation.
  /// \param BlockCount The number of times the current basic block has been
  //         visited.
  /// \param CausesPointerEscape the flag is set to true when
  ///        the invalidation entails escape of a symbol (representing a
  ///        pointer). For example, due to it being passed as an argument in a
  ///        call.
  /// \param IS the set of invalidated symbols.
  /// \param Call if non-null, the invalidated regions represent parameters to
  ///        the call and should be considered directly invalidated.
  /// \param ITraits information about special handling for a particular 
  ///        region/symbol.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::invalidateRegions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 138,
   FQN="clang::ento::ProgramState::invalidateRegions", NM="_ZNK5clang4ento12ProgramState17invalidateRegionsEN4llvm8ArrayRefIPKNS0_9MemRegionEEEPKNS_4ExprEjPKNS_15LocationContextEbPNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISH_EEEEPKNS0_9CallEventEPNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState17invalidateRegionsEN4llvm8ArrayRefIPKNS0_9MemRegionEEEPKNS_4ExprEjPKNS_15LocationContextEbPNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISH_EEEEPKNS0_9CallEventEPNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions_ArrayRef1(ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                             /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                             /*const*/ LocationContext /*P*/ LCtx, 
                             boolean CausedByPointerEscape) /*const*/ {
    return invalidateRegions_ArrayRef1(Regions, 
                             E, Count, 
                             LCtx, 
                             CausedByPointerEscape, 
                             (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null, 
                             (/*const*/ CallEvent /*P*/ )null, 
                             (RegionAndSymbolInvalidationTraits /*P*/ )null);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions_ArrayRef1(ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                             /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                             /*const*/ LocationContext /*P*/ LCtx, 
                             boolean CausedByPointerEscape, 
                             DenseSet</*const*/ SymExpr /*P*/ > /*P*/ IS/*= null*/) /*const*/ {
    return invalidateRegions_ArrayRef1(Regions, 
                             E, Count, 
                             LCtx, 
                             CausedByPointerEscape, 
                             IS, 
                             (/*const*/ CallEvent /*P*/ )null, 
                             (RegionAndSymbolInvalidationTraits /*P*/ )null);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions_ArrayRef1(ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                             /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                             /*const*/ LocationContext /*P*/ LCtx, 
                             boolean CausedByPointerEscape, 
                             DenseSet</*const*/ SymExpr /*P*/ > /*P*/ IS/*= null*/, 
                             /*const*/ CallEvent /*P*/ Call/*= null*/) /*const*/ {
    return invalidateRegions_ArrayRef1(Regions, 
                             E, Count, 
                             LCtx, 
                             CausedByPointerEscape, 
                             IS, 
                             Call, 
                             (RegionAndSymbolInvalidationTraits /*P*/ )null);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions_ArrayRef1(ArrayRef</*const*/ MemRegion /*P*/ > Regions, 
                             /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                             /*const*/ LocationContext /*P*/ LCtx, 
                             boolean CausedByPointerEscape, 
                             DenseSet</*const*/ SymExpr /*P*/ > /*P*/ IS/*= null*/, 
                             /*const*/ CallEvent /*P*/ Call/*= null*/, 
                             RegionAndSymbolInvalidationTraits /*P*/ ITraits/*= null*/) /*const*/ {
    assert checkAlive();
    SmallVector<SVal> Values/*J*/= new SmallVector<SVal>(8, new SVal());
    for (type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> I = $tryClone(Regions.begin()), 
        /*P*/ End = $tryClone(Regions.end()); $noteq_ptr(I, End); I.$preInc())  {
      Values.push_back(new NsLoc.MemRegionVal(I.$star()));
    }
    
    return invalidateRegionsImpl(new ArrayRef<SVal>(Values, false), E, Count, LCtx, CausedByPointerEscape, 
        IS, ITraits, Call);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::invalidateRegions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 155,
   FQN="clang::ento::ProgramState::invalidateRegions", NM="_ZNK5clang4ento12ProgramState17invalidateRegionsEN4llvm8ArrayRefINS0_4SValEEEPKNS_4ExprEjPKNS_15LocationContextEbPNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISF_EEEEPKNS0_9CallEventEPNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState17invalidateRegionsEN4llvm8ArrayRefINS0_4SValEEEPKNS_4ExprEjPKNS_15LocationContextEbPNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISF_EEEEPKNS0_9CallEventEPNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions_ArrayRef2(ArrayRef<SVal> Values, 
                             /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                             /*const*/ LocationContext /*P*/ LCtx, 
                             boolean CausedByPointerEscape) /*const*/ {
    return invalidateRegions_ArrayRef2(Values, 
                             E, Count, 
                             LCtx, 
                             CausedByPointerEscape, 
                             (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null, 
                             (/*const*/ CallEvent /*P*/ )null, 
                             (RegionAndSymbolInvalidationTraits /*P*/ )null);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions_ArrayRef2(ArrayRef<SVal> Values, 
                             /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                             /*const*/ LocationContext /*P*/ LCtx, 
                             boolean CausedByPointerEscape, 
                             DenseSet</*const*/ SymExpr /*P*/ > /*P*/ IS/*= null*/) /*const*/ {
    return invalidateRegions_ArrayRef2(Values, 
                             E, Count, 
                             LCtx, 
                             CausedByPointerEscape, 
                             IS, 
                             (/*const*/ CallEvent /*P*/ )null, 
                             (RegionAndSymbolInvalidationTraits /*P*/ )null);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions_ArrayRef2(ArrayRef<SVal> Values, 
                             /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                             /*const*/ LocationContext /*P*/ LCtx, 
                             boolean CausedByPointerEscape, 
                             DenseSet</*const*/ SymExpr /*P*/ > /*P*/ IS/*= null*/, 
                             /*const*/ CallEvent /*P*/ Call/*= null*/) /*const*/ {
    return invalidateRegions_ArrayRef2(Values, 
                             E, Count, 
                             LCtx, 
                             CausedByPointerEscape, 
                             IS, 
                             Call, 
                             (RegionAndSymbolInvalidationTraits /*P*/ )null);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions_ArrayRef2(ArrayRef<SVal> Values, 
                             /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                             /*const*/ LocationContext /*P*/ LCtx, 
                             boolean CausedByPointerEscape, 
                             DenseSet</*const*/ SymExpr /*P*/ > /*P*/ IS/*= null*/, 
                             /*const*/ CallEvent /*P*/ Call/*= null*/, 
                             RegionAndSymbolInvalidationTraits /*P*/ ITraits/*= null*/) /*const*/ {
    assert checkAlive();
    return invalidateRegionsImpl(new ArrayRef<SVal>(Values), E, Count, LCtx, CausedByPointerEscape, 
        IS, ITraits, Call);
  }

  
  /// enterStackFrame - Returns the state for entry to the given stack frame,
  ///  preserving the current state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::enterStackFrame">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 227,
   FQN="clang::ento::ProgramState::enterStackFrame", NM="_ZNK5clang4ento12ProgramState15enterStackFrameERKNS0_9CallEventEPKNS_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState15enterStackFrameERKNS0_9CallEventEPKNS_17StackFrameContextE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> enterStackFrame(final /*const*/ CallEvent /*&*/ Call, 
                 /*const*/ StackFrameContext /*P*/ CalleeCtx) /*const*/ {
    assert checkAlive();
    /*const*/ StoreRef /*&*/  NewStore = null;
    try {
      /*final */ NewStore = getStateManager().StoreMgr.$arrow().enterStackFrame(getStore(), Call, CalleeCtx);
      return makeWithStore(NewStore);
    } finally {
      if (NewStore != null) { NewStore.$destroy(); }
    }
  }

  
  /// Get the lvalue for a variable reference.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getLValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 694,
   FQN="clang::ento::ProgramState::getLValue", NM="_ZNK5clang4ento12ProgramState9getLValueEPKNS_7VarDeclEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9getLValueEPKNS_7VarDeclEPKNS_15LocationContextE")
  //</editor-fold>
  public /*inline*/ Loc getLValue(/*const*/ VarDecl /*P*/ VD, 
           /*const*/ LocationContext /*P*/ LC) /*const*/ {
    assert checkAlive();
    return getStateManager().StoreMgr.$arrow().getLValueVar(VD, LC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getLValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 699,
   FQN="clang::ento::ProgramState::getLValue", NM="_ZNK5clang4ento12ProgramState9getLValueEPKNS_19CompoundLiteralExprEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9getLValueEPKNS_19CompoundLiteralExprEPKNS_15LocationContextE")
  //</editor-fold>
  public /*inline*/ Loc getLValue(/*const*/ CompoundLiteralExpr /*P*/ literal, 
           /*const*/ LocationContext /*P*/ LC) /*const*/ {
    assert checkAlive();
    return getStateManager().StoreMgr.$arrow().getLValueCompoundLiteral(literal, LC);
  }

  
  /// Get the lvalue for an ivar reference.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getLValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 704,
   FQN="clang::ento::ProgramState::getLValue", NM="_ZNK5clang4ento12ProgramState9getLValueEPKNS_12ObjCIvarDeclENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9getLValueEPKNS_12ObjCIvarDeclENS0_4SValE")
  //</editor-fold>
  public /*inline*/ SVal getLValue(/*const*/ ObjCIvarDecl /*P*/ D, SVal Base) /*const*/ {
    assert checkAlive();
    return getStateManager().StoreMgr.$arrow().getLValueIvar(D, new SVal(Base));
  }

  
  /// Get the lvalue for a field reference.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getLValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 708,
   FQN="clang::ento::ProgramState::getLValue", NM="_ZNK5clang4ento12ProgramState9getLValueEPKNS_9FieldDeclENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9getLValueEPKNS_9FieldDeclENS0_4SValE")
  //</editor-fold>
  public /*inline*/ SVal getLValue(/*const*/ FieldDecl /*P*/ D, SVal Base) /*const*/ {
    assert checkAlive();
    return getStateManager().StoreMgr.$arrow().getLValueField(D, new SVal(Base));
  }

  
  /// Get the lvalue for an indirect field reference.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getLValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 712,
   FQN="clang::ento::ProgramState::getLValue", NM="_ZNK5clang4ento12ProgramState9getLValueEPKNS_17IndirectFieldDeclENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9getLValueEPKNS_17IndirectFieldDeclENS0_4SValE")
  //</editor-fold>
  public /*inline*/ SVal getLValue(/*const*/ IndirectFieldDecl /*P*/ D, 
           SVal Base) /*const*/ {
    assert checkAlive();
    final StoreManager /*&*/ SM = getStateManager().StoreMgr.$star();
    for (/*const*/ NamedDecl /*P*/ I : D.chain()) {
      Base.$assignMove(SM.getLValueField(cast_FieldDecl(I), new SVal(Base)));
    }
    
    return new SVal(JD$Move.INSTANCE, Base);
  }

  
  /// Get the lvalue for an array index.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getLValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 722,
   FQN="clang::ento::ProgramState::getLValue", NM="_ZNK5clang4ento12ProgramState9getLValueENS_8QualTypeENS0_4SValES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9getLValueENS_8QualTypeENS0_4SValES3_")
  //</editor-fold>
  public /*inline*/ SVal getLValue(QualType ElementType, SVal Idx, SVal Base) /*const*/ {
    assert checkAlive();
    {
      Optional<NonLoc> N = Idx.getAs(NonLoc.class);
      if (N.$bool()) {
        return getStateManager().StoreMgr.$arrow().getLValueElement(new QualType(ElementType), new NonLoc(N.$star()), new SVal(Base));
      }
    }
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  /// Returns the SVal bound to the statement 'S' in the state's environment.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getSVal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 728,
   FQN="clang::ento::ProgramState::getSVal", NM="_ZNK5clang4ento12ProgramState7getSValEPKNS_4StmtEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState7getSValEPKNS_4StmtEPKNS_15LocationContextE")
  //</editor-fold>
  public /*inline*/ SVal getSVal(/*const*/ Stmt /*P*/ Ex, 
         /*const*/ LocationContext /*P*/ LCtx) /*const*/ {
    assert checkAlive();
    return Env.getSVal(new EnvironmentEntry(Ex, LCtx), 
        getStateManager().svalBuilder.$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getSValAsScalarOrLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 734,
   FQN="clang::ento::ProgramState::getSValAsScalarOrLoc", NM="_ZNK5clang4ento12ProgramState20getSValAsScalarOrLocEPKNS_4StmtEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState20getSValAsScalarOrLocEPKNS_4StmtEPKNS_15LocationContextE")
  //</editor-fold>
  public /*inline*/ SVal getSValAsScalarOrLoc(/*const*/ Stmt /*P*/ S, 
                      /*const*/ LocationContext /*P*/ LCtx) /*const*/ {
    assert checkAlive();
    {
      /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(S);
      if ((Ex != null)) {
        QualType T = Ex.getType();
        if (Ex.isGLValue() || Loc.isLocType(new QualType(T))
           || T.$arrow().isIntegralOrEnumerationType()) {
          return getSVal(S, LCtx);
        }
      }
    }
    
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  /// \brief Return the value bound to the specified location.
  /// Returns UnknownVal() if none found.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getSVal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 251,
   FQN="clang::ento::ProgramState::getSVal", NM="_ZNK5clang4ento12ProgramState7getSValENS0_3LocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState7getSValENS0_3LocENS_8QualTypeE")
  //</editor-fold>
  public SVal getSVal(Loc location) /*const*/ {
    return getSVal(location, new QualType());
  }
  public SVal getSVal(Loc location, QualType T/*= QualType()*/) /*const*/ {
    assert checkAlive();
    SVal V = getRawSVal(new Loc(/*cast_Loc(*/location/*)*/), new QualType(T)); //JAVA: we don't have cast_Loc and it is not needed here!
    
    // If 'V' is a symbolic value that is *perfectly* constrained to
    // be a constant value, use that value instead to lessen the burden
    // on later analysis stages (so we have less symbolic values to reason
    // about).
    if (!T.isNull()) {
      {
        /*const*/ SymExpr /*P*/ sym = V.getAsSymbol();
        if ((sym != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            {
              /*const*/ APSInt /*P*/ Int = $c$.clean(getStateManager().
                  getConstraintManager().
                  getSymVal($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), sym));
              if ((Int != null)) {
                // FIXME: Because we don't correctly model (yet) sign-extension
                // and truncation of symbolic values, we need to convert
                // the integer value to the correct signedness and bitwidth.
                //
                // This shows up in the following:
                //
                //   char foo();
                //   unsigned x = foo();
                //   if (x == 54)
                //     ...
                //
                //  The symbolic value stored to 'x' is actually the conjured
                //  symbol for the call to foo(); the type of that symbol is 'char',
                //  not unsigned.
                final /*const*/ APSInt /*&*/ NewV = getBasicVals().Convert(new QualType(T), $Deref(Int));
                if (V.getAs(Loc.class).$bool()) {
                  return new SVal(JD$Move.INSTANCE, new NsLoc.ConcreteInt(NewV));
                } else {
                  return new SVal(JD$Move.INSTANCE, new NsNonloc.ConcreteInt(NewV));
                }
              }
            }
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    return V;
  }

  
  /// Returns the "raw" SVal bound to LV before any value simplfication.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getRawSVal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 747,
   FQN="clang::ento::ProgramState::getRawSVal", NM="_ZNK5clang4ento12ProgramState10getRawSValENS0_3LocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState10getRawSValENS0_3LocENS_8QualTypeE")
  //</editor-fold>
  public /*inline*/ SVal getRawSVal(Loc LV) /*const*/ {
    return getRawSVal(LV, new QualType());
  }
  public /*inline*/ SVal getRawSVal(Loc LV, QualType T/*= QualType()*/) /*const*/ {
    assert checkAlive();
    return getStateManager().StoreMgr.$arrow().getBinding(getStore(), new Loc(LV), new QualType(T));
  }

  
  /// \brief Return the value bound to the specified location.
  /// Returns UnknownVal() if none found.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getSVal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 751,
   FQN="clang::ento::ProgramState::getSVal", NM="_ZNK5clang4ento12ProgramState7getSValEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState7getSValEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*inline*/ SVal getSVal(/*const*/ MemRegion /*P*/ R) /*const*/ {
    assert checkAlive();
    return getStateManager().StoreMgr.$arrow().getBinding(getStore(), 
        new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(R)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::getSValAsScalarOrLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 235,
   FQN="clang::ento::ProgramState::getSValAsScalarOrLoc", NM="_ZNK5clang4ento12ProgramState20getSValAsScalarOrLocEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState20getSValAsScalarOrLocEPKNS0_9MemRegionE")
  //</editor-fold>
  public SVal getSValAsScalarOrLoc(/*const*/ MemRegion /*P*/ R) /*const*/ {
    assert checkAlive();
    // We only want to do fetches from regions that we can actually bind
    // values.  For example, SymbolicRegions of type 'id<...>' cannot
    // have direct bindings (but their can be bindings on their subregions).
    if (!R.isBoundable()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    {
      
      /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_TypedValueRegion(R);
      if ((TR != null)) {
        QualType T = TR.getValueType();
        if (Loc.isLocType(new QualType(T)) || T.$arrow().isIntegralOrEnumerationType()) {
          return getSVal(R);
        }
      }
    }
    
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  /// \brief Visits the symbols reachable from the given SVal using the provided
  /// SymbolVisitor.
  ///
  /// This is a convenience API. Consider using ScanReachableSymbols class
  /// directly when making multiple scans on the same state with the same
  /// visitor to avoid repeated initialization cost.
  /// \sa ScanReachableSymbols
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::scanReachableSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 625,
   FQN="clang::ento::ProgramState::scanReachableSymbols", NM="_ZNK5clang4ento12ProgramState20scanReachableSymbolsENS0_4SValERNS0_13SymbolVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState20scanReachableSymbolsENS0_4SValERNS0_13SymbolVisitorE")
  //</editor-fold>
  public boolean scanReachableSymbols(SVal val, final SymbolVisitor /*&*/ visitor) /*const*/ {
    assert checkAlive();
    ScanReachableSymbols S = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      S/*J*/= $c$.clean(new ScanReachableSymbols($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), visitor));
      return S.scan(new SVal(val));
    } finally {
      if (S != null) { S.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Visits the symbols reachable from the SVals in the given range
  /// using the provided SymbolVisitor.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::scanReachableSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 630,
   FQN="clang::ento::ProgramState::scanReachableSymbols", NM="_ZNK5clang4ento12ProgramState20scanReachableSymbolsEPKNS0_4SValES4_RNS0_13SymbolVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState20scanReachableSymbolsEPKNS0_4SValES4_RNS0_13SymbolVisitorE")
  //</editor-fold>
  public boolean scanReachableSymbols(/*const*/ type$iterator<?, SVal> /*P*/ I, /*const*/ type$iterator<?, SVal> /*P*/ E, 
                      final SymbolVisitor /*&*/ visitor) /*const*/ {
    assert checkAlive();
    ScanReachableSymbols S = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      S/*J*/= $c$.clean(new ScanReachableSymbols($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), visitor));
      for (; Native.$noteq_iter(I, E); I.$preInc()) {
        if (!S.scan(new SVal($Deref(I)))) {
          return false;
        }
      }
      return true;
    } finally {
      if (S != null) { S.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Visits the symbols reachable from the regions in the given
  /// MemRegions range using the provided SymbolVisitor.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::scanReachableSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 640,
   FQN="clang::ento::ProgramState::scanReachableSymbols", NM="_ZNK5clang4ento12ProgramState20scanReachableSymbolsEPKPKNS0_9MemRegionES6_RNS0_13SymbolVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState20scanReachableSymbolsEPKPKNS0_9MemRegionES6_RNS0_13SymbolVisitorE")
  //</editor-fold>
  public boolean scanReachableSymbols2(type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> I, 
                       type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> E, 
                       final SymbolVisitor /*&*/ visitor) /*const*/ {
    assert checkAlive();
    ScanReachableSymbols S = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      S/*J*/= $c$.clean(new ScanReachableSymbols($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), visitor));
      for (; $noteq_ptr(I, E); I.$preInc()) {
        if (!S.scan(I.$star())) {
          return false;
        }
      }
      return true;
    } finally {
      if (S != null) { S.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /*template <typename CB> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::scanReachableSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 809,
   FQN="clang::ento::ProgramState::scanReachableSymbols", NM="Tpl__ZNK5clang4ento12ProgramState20scanReachableSymbolsENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState20scanReachableSymbolsENS0_4SValE")
  //</editor-fold>
  public </*typename*/ CB extends SymbolVisitor> CB scanReachableSymbols$T(Class<CB> clazz, SVal val) /*const*/ {
    assert checkAlive();
    CB cb/*J*/= $construct(clazz, this);
    scanReachableSymbols(val, cb);
    return cb;
  }
  
  /*template <typename CB> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::scanReachableSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 816,
   FQN="clang::ento::ProgramState::scanReachableSymbols", NM="Tpl__ZNK5clang4ento12ProgramState20scanReachableSymbolsEPKNS0_4SValES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState20scanReachableSymbolsEPKNS0_4SValES4_")
  //</editor-fold>
  public </*typename*/ CB extends SymbolVisitor> CB scanReachableSymbols$T(Class<CB> clazz, type$ptr</*const*/ SVal> beg, type$ptr</*const*/ SVal> /*P*/ end) /*const*/ {
    assert checkAlive();
    CB cb/*J*/= $construct(clazz, this);
    scanReachableSymbols(beg, end, cb);
    return cb;
  }

  
  /*template <typename CB> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::scanReachableSymbols">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 823,
   FQN="clang::ento::ProgramState::scanReachableSymbols", NM="Tpl__ZNK5clang4ento12ProgramState20scanReachableSymbolsEPKPKNS0_9MemRegionES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState20scanReachableSymbolsEPKPKNS0_9MemRegionES6_")
  //</editor-fold>
  public </*typename*/ CB extends SymbolVisitor> CB scanReachableSymbols$T2(Class<CB> clazz, type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> beg, 
                         type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> end) /*const*/ {
    assert checkAlive();
    CB cb/*J*/= $construct(clazz, this);
    scanReachableSymbols2(beg, end, cb);
    return cb;
  }

  
  /// Create a new state in which the statement is marked as tainted.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::addTaint">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 651,
   FQN="clang::ento::ProgramState::addTaint", NM="_ZNK5clang4ento12ProgramState8addTaintEPKNS_4StmtEPKNS_15LocationContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState8addTaintEPKNS_4StmtEPKNS_15LocationContextEj")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> addTaint(/*const*/ Stmt /*P*/ S, 
          /*const*/ LocationContext /*P*/ LCtx) /*const*/ {
    return addTaint(S, 
          LCtx, 
          TaintTagGeneric);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> addTaint(/*const*/ Stmt /*P*/ S, 
          /*const*/ LocationContext /*P*/ LCtx, 
          /*uint*/int Kind/*= TaintTagGeneric*/) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        /*const*/ Expr /*P*/ E = dyn_cast_or_null_Expr(S);
        if ((E != null)) {
          S = E.IgnoreParens$Const();
        }
      }
      
      /*const*/ SymExpr /*P*/ Sym = getSVal(S, LCtx).getAsSymbol();
      if ((Sym != null)) {
        return addTaint(Sym, Kind);
      }
      
      /*const*/ MemRegion /*P*/ R = getSVal(S, LCtx).getAsRegion();
      $c$.clean($c$.track(addTaint(R, Kind)));
      
      // Cannot add taint, so just return the state.
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Create a new state in which the symbol is marked as tainted.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::addTaint">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 675,
   FQN="clang::ento::ProgramState::addTaint", NM="_ZNK5clang4ento12ProgramState8addTaintEPKNS0_7SymExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState8addTaintEPKNS0_7SymExprEj")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> addTaint(/*const*/ SymExpr /*P*/ Sym) /*const*/ {
    return addTaint(Sym, 
          TaintTagGeneric);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> addTaint(/*const*/ SymExpr /*P*/ Sym, 
          /*uint*/int Kind/*= TaintTagGeneric*/) /*const*/ {
    assert checkAlive();
    IntrusiveRefCntPtr</*const*/ ProgramState> NewState = null;
    try {
      {
        // If this is a symbol cast, remove the cast before adding the taint. Taint
        // is cast agnostic.
        /*const*/ SymbolCast /*P*/ SC;
        while (((/*P*/ SC = dyn_cast_SymbolCast(Sym)) != null)) {
          Sym = SC.getOperand();
        }
      }

      NewState = this.set(ProgramStateTraitTaintMap.$Instance, Sym, Kind);
      assert ((NewState).$bool());
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, NewState);
    } finally {
      if (NewState != null) { NewState.$destroy(); }
    }
  }

  
  /// Create a new state in which the region symbol is marked as tainted.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::addTaint">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 668,
   FQN="clang::ento::ProgramState::addTaint", NM="_ZNK5clang4ento12ProgramState8addTaintEPKNS0_9MemRegionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState8addTaintEPKNS0_9MemRegionEj")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> addTaint(/*const*/ MemRegion /*P*/ R) /*const*/ {
    return addTaint(R, 
          TaintTagGeneric);
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> addTaint(/*const*/ MemRegion /*P*/ R, 
          /*uint*/int Kind/*= TaintTagGeneric*/) /*const*/ {
    assert checkAlive();
    {
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_or_null_SymbolicRegion(R);
      if ((SR != null)) {
        return addTaint(SR.getSymbol(), Kind);
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(this);
  }

  
  /// Check if the statement is tainted in the current state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::isTainted">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 687,
   FQN="clang::ento::ProgramState::isTainted", NM="_ZNK5clang4ento12ProgramState9isTaintedEPKNS_4StmtEPKNS_15LocationContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9isTaintedEPKNS_4StmtEPKNS_15LocationContextEj")
  //</editor-fold>
  public boolean isTainted(/*const*/ Stmt /*P*/ S, /*const*/ LocationContext /*P*/ LCtx) /*const*/ {
    return isTainted(S, LCtx, 
           TaintTagGeneric);
  }
  public boolean isTainted(/*const*/ Stmt /*P*/ S, /*const*/ LocationContext /*P*/ LCtx, 
           /*uint*/int Kind/*= TaintTagGeneric*/) /*const*/ {
    assert checkAlive();
    {
      /*const*/ Expr /*P*/ E = dyn_cast_or_null_Expr(S);
      if ((E != null)) {
        S = E.IgnoreParens$Const();
      }
    }
    
    SVal val = getSVal(S, LCtx);
    return isTainted(new SVal(val), Kind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::isTainted">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 696,
   FQN="clang::ento::ProgramState::isTainted", NM="_ZNK5clang4ento12ProgramState9isTaintedENS0_4SValEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9isTaintedENS0_4SValEj")
  //</editor-fold>
  public boolean isTainted(SVal V) /*const*/ {
    return isTainted(V, TaintTagGeneric);
  }
  public boolean isTainted(SVal V, /*uint*/int Kind/*= TaintTagGeneric*/) /*const*/ {
    assert checkAlive();
    {
      /*const*/ SymExpr /*P*/ Sym = V.getAsSymExpr();
      if ((Sym != null)) {
        return isTainted(Sym, Kind);
      }
    }
    {
      /*const*/ MemRegion /*P*/ Reg = V.getAsRegion();
      if ((Reg != null)) {
        return isTainted(Reg, Kind);
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::isTainted">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 722,
   FQN="clang::ento::ProgramState::isTainted", NM="_ZNK5clang4ento12ProgramState9isTaintedEPKNS0_7SymExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9isTaintedEPKNS0_7SymExprEj")
  //</editor-fold>
  public boolean isTainted(/*const*/ SymExpr /*P*/ Sym) /*const*/ {
    return isTainted(Sym, TaintTagGeneric);
  }
  public boolean isTainted(/*const*/ SymExpr /*P*/ Sym, /*uint*/int Kind/*= TaintTagGeneric*/) /*const*/ {
    assert checkAlive();
    if (!(Sym != null)) {
      return false;
    }
    
    // Traverse all the symbols this symbol depends on to see if any are tainted.
    boolean Tainted = false;
    SymExpr.symbol_iterator SI = null;
    SymExpr.symbol_iterator SE = null;
    try {
      for (SI = Sym.symbol_begin(), SE = Sym.symbol_end();
           SI.$noteq(SE); SI.$preInc()) {
        if (!isa_SymbolData(SI.$star())) {
          continue;
        }
                        
        /*const*/uint$ptr/*uint P*/ Tag = this.get(ProgramStateTraitTaintMap.$Instance, SI.$star());
        Tainted = (/*JAVA*/(Tag != null) && Tag.$star() == Kind);
        {
          
          // If this is a SymbolDerived with a tainted parent, it's also tainted.
          /*const*/ SymbolDerived /*P*/ SD = dyn_cast_SymbolDerived(SI.$star());
          if ((SD != null)) {
            Tainted = Tainted || isTainted(SD.getParentSymbol(), Kind);
          }
        }
        {
          
          // If memory region is tainted, data is also tainted.
          /*const*/ SymbolRegionValue /*P*/ SRV = dyn_cast_SymbolRegionValue(SI.$star());
          if ((SRV != null)) {
            Tainted = Tainted || isTainted(SRV.getRegion(), Kind);
          }
        }
        {
          
          // If If this is a SymbolCast from a tainted value, it's also tainted.
          /*const*/ SymbolCast /*P*/ SC = dyn_cast_SymbolCast(SI.$star());
          if ((SC != null)) {
            Tainted = Tainted || isTainted(SC.getOperand(), Kind);
          }
        }
        if (Tainted) {
          return true;
        }
      }
    } finally {
      if (SE != null) { SE.$destroy(); }
      if (SI != null) { SI.$destroy(); }
    }
    
    return Tainted;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::isTainted">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 704,
   FQN="clang::ento::ProgramState::isTainted", NM="_ZNK5clang4ento12ProgramState9isTaintedEPKNS0_9MemRegionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9isTaintedEPKNS0_9MemRegionEj")
  //</editor-fold>
  public boolean isTainted(/*const*/ MemRegion /*P*/ Reg) /*const*/ {
    return isTainted(Reg, TaintTagGeneric);
  }
  public boolean isTainted(/*const*/ MemRegion /*P*/ Reg, /*uint*/int K/*= TaintTagGeneric*/) /*const*/ {
    assert checkAlive();
    if (!(Reg != null)) {
      return false;
    }
    {
      
      // Element region (array element) is tainted if either the base or the offset
      // are tainted.
      /*const*/ ElementRegion /*P*/ ER = dyn_cast_ElementRegion(Reg);
      if ((ER != null)) {
        return isTainted(ER.getSuperRegion(), K) || isTainted(new SVal(JD$Move.INSTANCE, ER.getIndex()), K);
      }
    }
    {
      
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(Reg);
      if ((SR != null)) {
        return isTainted(SR.getSymbol(), K);
      }
    }
    {
      
      /*const*/ SubRegion /*P*/ ER = dyn_cast_SubRegion(Reg);
      if ((ER != null)) {
        return isTainted(ER.getSuperRegion(), K);
      }
    }
    
    return false;
  }

  
  //==---------------------------------------------------------------------==//
  // Accessing the Generic Data Map (GDM).
  //==---------------------------------------------------------------------==//
  
  //===----------------------------------------------------------------------===//
  // Generic Data Map.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::FindGDM">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 466,
   FQN="clang::ento::ProgramState::FindGDM", NM="_ZNK5clang4ento12ProgramState7FindGDMEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState7FindGDMEPv")
  //</editor-fold>
  public type$ptr<Object>/*void P const P*/ FindGDM(Object/*void P*/ K) /*const*/ {
    assert checkAlive();
    return GDM.lookup(K);
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::add">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 765,
   FQN="clang::ento::ProgramState::add", NM="Tpl__ZNK5clang4ento12ProgramState3addENS0_17ProgramStateTraitIT_E8key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState3addENS0_17ProgramStateTraitIT_E8key_typeE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> add(ProgramStatePartialTraitImmutableSetUInt $Trait, /*uint key_type*/int K) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().add($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public <key_type> IntrusiveRefCntPtr</*const*/ ProgramState> add(ProgramStatePartialTraitImmutableSet$T<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().add($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public <key_type> IntrusiveRefCntPtr</*const*/ ProgramState> add(ProgramStatePartialTraitImmutableSet$TP<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().add($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public <key_type> IntrusiveRefCntPtr</*const*/ ProgramState> add(ProgramStatePartialTraitImmutableList$T<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().add($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
          
  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 372,
   FQN="clang::ento::ProgramState::get", NM="Tpl__ZNK5clang4ento12ProgramState3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState3getEv")
  //</editor-fold>
  public </*typename*/ data_type>  data_type get(ProgramStateTrait<data_type> $Trait) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    return $Trait.MakeData(d);
  }
  public ImmutableSetUInt get(ProgramStatePartialTraitImmutableSetUInt $Trait) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    return $Trait.MakeData(d);
  }
  
  
  // JAVA: METHOD get below can return null. which means there is no value for Key
  // So, it must not be checked by Native.$bool(...), but must use "!= null" 
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 378,
   FQN="clang::ento::ProgramState::get", NM="Tpl__ZNK5clang4ento12ProgramState3getENS0_17ProgramStateTraitIT_E8key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState3getENS0_17ProgramStateTraitIT_E8key_typeE")
  //</editor-fold>
  public </*typename*/ key_type> /*uint*/uint$ptr get(ProgramStatePartialTraitImmutableMapPtrUInt<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    return $Trait.Lookup($Trait.MakeData(d), $Trait.$tryCloneKey(K));
  }
  public </*typename*/ key_type> bool$ptr get(ProgramStatePartialTraitImmutableMapPtrBool<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    return $Trait.Lookup($Trait.MakeData(d), $Trait.$tryCloneKey(K));
  }
  public </*typename*/ key_type, value_type extends FoldingSetTrait.Profilable> value_type get(ProgramStatePartialTraitImmutableMapPtrType<key_type, value_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    type$ptr<value_type> $Lookup = $Trait.Lookup($Trait.MakeData(d), $Trait.$tryCloneKey(K));
    assert $Lookup == null || $Lookup.$star() != null : "Must have value type at least as default value";
    return $Lookup == null ? null : $Lookup.$star();
  }
  public </*typename*/ key_type, value_type> type$ptr<value_type> get(ProgramStatePartialTraitImmutableMapPtrPtr<key_type, value_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    type$ptr<value_type> $Lookup = $Trait.Lookup($Trait.MakeData(d), $Trait.$tryCloneKey(K));
    // map of pointers can contain null pointer by key, so check to be done in caller
    return $Lookup;
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::get_context">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 770,
   FQN="clang::ento::ProgramState::get_context", NM="Tpl__ZNK5clang4ento12ProgramState11get_contextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState11get_contextEv")
  //</editor-fold>
  public ImmutableSetUInt.Factory get_context(ProgramStatePartialTraitImmutableSetUInt $Trait) /*const*/ {
    assert checkAlive();
    return getStateManager().get_context($Trait);
  }
  public </*typename*/ T> ImmutableSet.Factory<T> get_context(ProgramStatePartialTraitImmutableSet$T<T> $Trait) /*const*/ {
    assert checkAlive();
    return getStateManager().get_context($Trait);
  }
  public </*typename*/ T> ImmutableSetPtr.Factory<T> get_context(ProgramStatePartialTraitImmutableSet$TP<T> $Trait) /*const*/ {
    assert checkAlive();
    return getStateManager().get_context($Trait);
  }
  public </*typename*/ T> ImmutableListFactory<T> get_context(ProgramStatePartialTraitImmutableList$T<T> $Trait) /*const*/ {
    assert checkAlive();
    return getStateManager().get_context($Trait);
  }
  public </*typename*/ K, V extends FoldingSetTrait.Profilable> ImmutableMapPtrType.Factory<K, V> get_context(ProgramStatePartialTraitImmutableMapPtrType<K, V> $Trait) /*const*/ {
    assert checkAlive();
    return getStateManager().get_context($Trait);
  }
  public </*typename*/ K, V> ImmutableMapPtrPtr.Factory<K, V> get_context(ProgramStatePartialTraitImmutableMapPtrPtr<K, V> $Trait) /*const*/ {
    assert checkAlive();
    return getStateManager().get_context($Trait);
  }
  public </*typename*/ K> ImmutableMapPtrUInt.Factory<K> get_context(ProgramStatePartialTraitImmutableMapPtrUInt<K> $Trait) /*const*/ {
    assert checkAlive();
    return getStateManager().get_context($Trait);
  }
  public </*typename*/ K> ImmutableMapPtrBool.Factory<K> get_context(ProgramStatePartialTraitImmutableMapPtrBool<K> $Trait) /*const*/ {
    assert checkAlive();
    return getStateManager().get_context($Trait);
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::remove">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 775,
   FQN="clang::ento::ProgramState::remove", NM="Tpl__ZNK5clang4ento12ProgramState6removeENS0_17ProgramStateTraitIT_E8key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState6removeENS0_17ProgramStateTraitIT_E8key_typeE")
  //</editor-fold>
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableSet$T<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableSet$TP<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type, value_type extends FoldingSetTrait.Profilable> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableMapPtrType<key_type, value_type> $Trait, key_type K) {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type, value_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableMapPtrPtr<key_type, value_type> $Trait, key_type K) {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableMapPtrUInt<key_type> $Trait, key_type K) {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableMapPtrBool<key_type> $Trait, key_type K) {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  
  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::remove">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 780,
   FQN="clang::ento::ProgramState::remove", NM="Tpl__ZNK5clang4ento12ProgramState6removeENS0_17ProgramStateTraitIT_E8key_typeENS4_12context_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState6removeENS0_17ProgramStateTraitIT_E8key_typeENS4_12context_typeE")
  //</editor-fold>
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableSet$T<key_type> $Trait, key_type K, 
         ImmutableSet.Factory<key_type> C) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), C));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStatePartialTraitImmutableSet$TP<key_type> $Trait, key_type K, 
         ImmutableSetPtr.Factory<key_type> C) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), C));
    } finally {
      $c$.$destroy();
    }
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::remove">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 786,
   FQN="clang::ento::ProgramState::remove", NM="Tpl__ZNK5clang4ento12ProgramState6removeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState6removeEv")
  //</editor-fold>
  public </*typename*/ T> IntrusiveRefCntPtr</*const*/ ProgramState> remove(ProgramStateTrait<T> $Trait) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().remove($Trait, $c$.track(new IntrusiveRefCntPtr(this))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 791,
   FQN="clang::ento::ProgramState::set", NM="Tpl__ZNK5clang4ento12ProgramState3setENS0_17ProgramStateTraitIT_E9data_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState3setENS0_17ProgramStateTraitIT_E9data_typeE")
  //</editor-fold>
  public </*typename*/ data_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStateTrait<data_type> $Trait, data_type D) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().set($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneData($c$, D)));
    } finally {
      $c$.$destroy();
    }
  }
  
  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::set">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 796,
   FQN="clang::ento::ProgramState::set", NM="Tpl__ZNK5clang4ento12ProgramState3setENS0_17ProgramStateTraitIT_E8key_typeENS4_10value_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState3setENS0_17ProgramStateTraitIT_E8key_typeENS4_10value_typeE")
  //</editor-fold>
  public </*typename*/ key_type, value_type extends FoldingSetTrait.Profilable> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStatePartialTraitImmutableMapPtrType<key_type, value_type> $Trait, key_type K, 
      value_type E) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().set($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), $Trait.$tryCloneValue($c$, E), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type, value_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStatePartialTraitImmutableMapPtrPtr<key_type, value_type> $Trait, key_type K, 
      value_type E) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().set($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), $Trait.$tryCloneValue(E), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStatePartialTraitImmutableMapPtrUInt<key_type> $Trait, key_type K, 
      /*uint*/int E) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().set($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), $Trait.$tryCloneValue(E), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }  
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(
          ProgramStatePartialTraitImmutableMapPtrUInt<key_type> $Trait, key_type K, boolean E) {
    assert checkAlive();
    return set($Trait, $Trait.$tryCloneKey(K), $Trait.$tryCloneValue(E ? 1 : 0));
  }
  public </*typename*/ key_type> IntrusiveRefCntPtr</*const*/ ProgramState> set(ProgramStatePartialTraitImmutableMapPtrBool<key_type> $Trait, key_type K, 
      boolean E) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {    
      return $c$.clean(getStateManager().set($Trait, $c$.track(new IntrusiveRefCntPtr(this)), $Trait.$tryCloneKey(K), $Trait.$tryCloneValue(E), get_context($Trait)));
    } finally {
      $c$.$destroy();
    }
  }  

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::contains">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ProgramState.h", line = 410,
   FQN="clang::ento::ProgramState::contains", NM="Tpl__ZNK5clang4ento12ProgramState8containsENS0_17ProgramStateTraitIT_E8key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=Tpl__ZNK5clang4ento12ProgramState8containsENS0_17ProgramStateTraitIT_E8key_typeE")
  //</editor-fold>
  public </*typename*/ key_type> boolean contains(ProgramStatePartialTraitImmutableSet$T<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    return $Trait.Contains($Trait.MakeData(d), $Trait.$tryCloneKey(K));
  }
  public </*typename*/ key_type> boolean contains(ProgramStatePartialTraitImmutableSet$TP<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    return $Trait.Contains($Trait.MakeData(d), $Trait.$tryCloneKey(K));
  }
  public </*typename*/ key_type> boolean contains(ProgramStatePartialTraitImmutableList$T<key_type> $Trait, key_type K) /*const*/ {
    assert checkAlive();
    type$ptr<Object>/*void P const P*/ d = FindGDM($Trait.GDMIndex());
    return $Trait.Contains($Trait.MakeData(d), $Trait.$tryCloneKey(K));
  }

  
  // Pretty-printing.
  
  //===----------------------------------------------------------------------===//
  //  State pretty-printing.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 422,
   FQN="clang::ento::ProgramState::print", NM="_ZNK5clang4ento12ProgramState5printERN4llvm11raw_ostreamEPKcS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState5printERN4llvm11raw_ostreamEPKcS6_")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ Out) /*const*/ {
    assert checkAlive();
    print(Out, 
       $LF, $EMPTY);
  }
  public void print(final raw_ostream /*&*/ Out, 
       /*const*/char$ptr/*char P*/ NL/*= "\n"*/) /*const*/ {
    assert checkAlive();
    print(Out, 
       NL, $EMPTY);
  }
  public void print(final raw_ostream /*&*/ Out, 
       /*const*/char$ptr/*char P*/ NL/*= "\n"*/, /*const*/char$ptr/*char P*/ Sep/*= ""*/) /*const*/ {
    assert checkAlive();
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Print the store.
      final ProgramStateManager /*&*/ Mgr = getStateManager();
      Mgr.getStoreManager().print(getStore(), Out, NL, Sep);
      
      // Print out the environment.
      Env.print(Out, NL, Sep);
      
      // Print out the constraints.
      Mgr.getConstraintManager().print($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), Out, NL, Sep); $c$.clean();
      
      // Print checker-specific data.
      Mgr.getOwningEngine().printState(Out, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(this)), NL, Sep); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::printDOT">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 438,
   FQN="clang::ento::ProgramState::printDOT", NM="_ZNK5clang4ento12ProgramState8printDOTERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState8printDOTERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printDOT(final raw_ostream /*&*/ Out) /*const*/ {
    assert checkAlive();
    print(Out, $("\\l"), $("\\|"));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::printTaint">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 446,
   FQN="clang::ento::ProgramState::printTaint", NM="_ZNK5clang4ento12ProgramState10printTaintERN4llvm11raw_ostreamEPKcS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState10printTaintERN4llvm11raw_ostreamEPKcS6_")
  //</editor-fold>
  public void printTaint(final raw_ostream /*&*/ Out) /*const*/ {
    assert checkAlive();
    printTaint(Out, 
            $LF, $EMPTY);
  }
  public void printTaint(final raw_ostream /*&*/ Out, 
            /*const*/char$ptr/*char P*/ NL/*= "\n"*/) /*const*/ {
    assert checkAlive();
    printTaint(Out, 
            NL, $EMPTY);
  }
  public void printTaint(final raw_ostream /*&*/ Out, 
            /*const*/char$ptr/*char P*/ NL/*= "\n"*/, /*const*/char$ptr/*char P*/ Sep/*= ""*/) /*const*/ {
    assert checkAlive();
    ImmutableMapPtrUInt</*const*/ SymExpr /*P*/ > TM = null;
    try {
      TM = this.get(ProgramStateTraitTaintMap.$Instance);
      if (!TM.isEmpty()) {
        Out.$out(/*KEEP_STR*/"Tainted Symbols:").$out(NL);
      }
      ImmutableMapPtrUInt.iterator</*const*/ SymExpr /*P*/ > I = null;
      ImmutableMapPtrUInt.iterator</*const*/ SymExpr /*P*/ > E = null;
      try {
        
        for (I = TM.begin(), E = TM.end(); I.$noteq(E); I.$preInc()) {
          StaticanalyzerLlvmGlobals.$out_raw_ostream_SymExpr$C$P(Out, I.$arrow().first).$out(/*KEEP_STR*/" : ").$out_uint(I.$arrow().second).$out(NL);
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
    } finally {
      if (TM != null) { TM.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::dump">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 442,
   FQN="clang::ento::ProgramState::dump", NM="_ZNK5clang4ento12ProgramState4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    assert checkAlive();
    print(llvm.errs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::dumpTaint">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 458,
   FQN="clang::ento::ProgramState::dumpTaint", NM="_ZNK5clang4ento12ProgramState9dumpTaintEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState9dumpTaintEv")
  //</editor-fold>
  public void dumpTaint() /*const*/ {
    assert checkAlive();
    printTaint(llvm.errs());
  }

/*private:*/
  /*friend void ProgramStateRetain(const ProgramState *state)*/
  /*friend void ProgramStateRelease(const ProgramState *state)*/

  /// \sa invalidateValues()
  /// \sa invalidateRegions()
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ProgramState::invalidateRegionsImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp", line = 168,
   FQN="clang::ento::ProgramState::invalidateRegionsImpl", NM="_ZNK5clang4ento12ProgramState21invalidateRegionsImplEN4llvm8ArrayRefINS0_4SValEEEPKNS_4ExprEjPKNS_15LocationContextEbPNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISF_EEEEPNS0_33RegionAndSymbolInvalidationTraitsEPKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZNK5clang4ento12ProgramState21invalidateRegionsImplEN4llvm8ArrayRefINS0_4SValEEEPKNS_4ExprEjPKNS_15LocationContextEbPNS2_8DenseSetIPKNS0_7SymExprENS2_12DenseMapInfoISF_EEEEPNS0_33RegionAndSymbolInvalidationTraitsEPKNS0_9CallEventE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegionsImpl(ArrayRef<SVal> Values, 
                       /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                       /*const*/ LocationContext /*P*/ LCtx, 
                       boolean CausedByPointerEscape, 
                       DenseSet</*const*/ SymExpr /*P*/ > /*P*/ IS, 
                       RegionAndSymbolInvalidationTraits /*P*/ ITraits, 
                       /*const*/ CallEvent /*P*/ Call) /*const*/ {
    assert checkAlive();
    RegionAndSymbolInvalidationTraits ITraitsLocal = null;
    /*const*/ StoreRef /*&*/  newStore = null;
    try {
      final ProgramStateManager /*&*/ Mgr = getStateManager();
      SubEngine /*P*/ Eng = Mgr.getOwningEngine();
      
      DenseSet</*const*/ SymExpr /*P*/ > Invalidated/*J*/= new DenseSet</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info());
      if (!(IS != null)) {
        IS = $AddrOf(Invalidated);
      }
      
      ITraitsLocal/*J*/= new RegionAndSymbolInvalidationTraits();
      if (!(ITraits != null)) {
        ITraits = $AddrOf(ITraitsLocal);
      }
      if ((Eng != null)) {
        /*const*/ StoreRef /*&*/  newStore$1 = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> newState = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SmallVector</*const*/ MemRegion /*P*/ > TopLevelInvalidated/*J*/= new SmallVector</*const*/ MemRegion /*P*/ >(8, (/*const*/ MemRegion /*P*/ )null);
          SmallVector</*const*/ MemRegion /*P*/ > Invalidated$1/*J*/= new SmallVector</*const*/ MemRegion /*P*/ >(8, (/*const*/ MemRegion /*P*/ )null);
          /*final */ newStore$1 = Mgr.StoreMgr.$arrow().invalidateRegions(getStore(), new ArrayRef<SVal>(Values), E, Count, LCtx, Call, 
              $Deref(IS), $Deref(ITraits), $AddrOf(TopLevelInvalidated), 
              $AddrOf(Invalidated$1));
          
          newState = makeWithStore(newStore$1);
          if (CausedByPointerEscape) {
            $c$.clean(newState.$assign($c$.track(Eng.notifyCheckersOfPointerEscape($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(newState)), IS, 
                    new ArrayRef</*const*/ MemRegion /*P*/ >(TopLevelInvalidated, true), 
                    new ArrayRef</*const*/ MemRegion /*P*/ >(Invalidated$1, true), Call, 
                    $Deref(ITraits)))));
          }
          
          return $c$.clean(Eng.processRegionChanges($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(newState)), IS, new ArrayRef</*const*/ MemRegion /*P*/ >(TopLevelInvalidated, true), 
              new ArrayRef</*const*/ MemRegion /*P*/ >(Invalidated$1, true), Call));
        } finally {
          if (newState != null) { newState.$destroy(); }
          if (newStore$1 != null) { newStore$1.$destroy(); }
          $c$.$destroy();
        }
      }
      
      /*final */ newStore = Mgr.StoreMgr.$arrow().invalidateRegions(getStore(), new ArrayRef<SVal>(Values), E, Count, LCtx, Call, 
          $Deref(IS), $Deref(ITraits), (SmallVector</*const*/ MemRegion /*P*/ > /*P*/)null, (SmallVector</*const*/ MemRegion /*P*/ > /*P*/)null);
      return makeWithStore(newStore);
    } finally {
      if (newStore != null) { newStore.$destroy(); }
      if (ITraitsLocal != null) { ITraitsLocal.$destroy(); }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @FunctionalInterface
  private static interface $SymbolVisitorFactory<T extends SymbolVisitor> {
    T $call(IntrusiveRefCntPtr<ProgramState> p);
  }
  
  private static <T extends SymbolVisitor> T $construct(Class<T> clazz, ProgramState ps) {
    assert ps.checkAlive();
    $SymbolVisitorFactory factory = ctors.get(clazz);
    assert factory != null : "No factory for " + clazz;
    IntrusiveRefCntPtr<ProgramState> state = new IntrusiveRefCntPtr</*const*/ ProgramState>(ps);
    try {
      return (T) factory.$call(state);
    } finally {
      state.$destroy();
    }
  }

  private static <T extends SymbolVisitor> void $registerFactory(Class<T> clazz, $SymbolVisitorFactory<T> factory) {
    ctors.put(clazz, factory);
  }
  
  private static final java.util.Map<Class<? extends SymbolVisitor>, $SymbolVisitorFactory> ctors = new java.util.HashMap<>(64);

  static {
    $registerFactory(RetainCountCheckerStatics.StopTrackingCallback.class, (IntrusiveRefCntPtr<ProgramState> p) -> { return new RetainCountCheckerStatics.StopTrackingCallback(p); });
    $registerFactory(MallocCheckerStatics.StopTrackingCallback.class, (IntrusiveRefCntPtr<ProgramState> p) -> { return new MallocCheckerStatics.StopTrackingCallback(p); });
    $registerFactory(SimpleStreamCheckerStatics.StopTrackingCallback.class, (IntrusiveRefCntPtr<ProgramState> p) -> { return new SimpleStreamCheckerStatics.StopTrackingCallback(p); });
    $registerFactory(CollectReachableSymbolsCallback.class, (IntrusiveRefCntPtr<ProgramState> p) -> { return new CollectReachableSymbolsCallback(p); });
  }

  @Override
  public void Retain() {
    assert checkAlive();
    ProgramStateRetain(this);
  }

  @Override
  public void Release() {
    assert checkAlive();
    ProgramStateRelease(this);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if (false) { 
      // we must not use print method of this or copy of this
      // because it has side effects: refCount is changed, so release can be called
      int refCountPrev = this.refCount;
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      this.printTaint(OS, $LF, $SPACE);
      OS.flush();
      assert this.refCount == refCountPrev : this.refCount + " vs. " + refCountPrev;
      return Buf.toJavaString();
    }    
    return (super.is$destroyed()?"DESTROYED " :"") 
              + "stateMgr=" + "[ProgramStateManager]" // NOI18N
              + ", Env=" + Env // NOI18N
              + ", store=" + NativeTrace.getIdentityStr(store) // NOI18N
              + ", refCount=" + refCount // NOI18N
              + ",\nGDM=" + GDM // NOI18N
              + super.toString(); // NOI18N
  }
}
