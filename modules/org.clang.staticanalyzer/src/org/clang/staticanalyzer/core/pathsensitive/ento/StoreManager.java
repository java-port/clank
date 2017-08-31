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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.QualType.*;
import org.clang.staticanalyzer.core.impl.StoreStatics;

//<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 40,
 FQN="clang::ento::StoreManager", NM="_ZN5clang4ento12StoreManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManagerE")
//</editor-fold>
public abstract class StoreManager implements Native.Native$Bool, Destructors.ClassWithDestructor {
/*protected:*/
  protected final SValBuilder /*&*/ svalBuilder;
  protected final ProgramStateManager /*&*/ StateMgr;
  
  /// MRMgr - Manages region objects associated with this StoreManager.
  protected final MemRegionManager /*&*/ MRMgr;
  protected final ASTContext /*&*/ Ctx;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::StoreManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 24,
   FQN="clang::ento::StoreManager::StoreManager", NM="_ZN5clang4ento12StoreManagerC1ERNS0_19ProgramStateManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManagerC1ERNS0_19ProgramStateManagerE")
  //</editor-fold>
  protected StoreManager(final ProgramStateManager /*&*/ stateMgr) {
    // : svalBuilder(stateMgr.getSValBuilder()), StateMgr(stateMgr), MRMgr(svalBuilder.getRegionManager()), Ctx(stateMgr.getContext()) 
    //START JInit
    this./*&*/svalBuilder=/*&*/stateMgr.getSValBuilder();
    this./*&*/StateMgr=/*&*/stateMgr;
    this./*&*/MRMgr=/*&*/svalBuilder.getRegionManager();
    this./*&*/Ctx=/*&*/stateMgr.getContext();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::~StoreManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 52,
   FQN="clang::ento::StoreManager::~StoreManager", NM="_ZN5clang4ento12StoreManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManagerD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// Return the value bound to specified location in a given state.
  /// \param[in] store The analysis state.
  /// \param[in] loc The symbolic memory location.
  /// \param[in] T An optional type that provides a hint indicating the
  ///   expected type of the returned value.  This is used if the value is
  ///   lazily computed.
  /// \return The value bound to the location \c loc.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 61,
   FQN="clang::ento::StoreManager::getBinding", NM="_ZN5clang4ento12StoreManager10getBindingEPKvNS0_3LocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager10getBindingEPKvNS0_3LocENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SVal getBinding(/*const*/Object/*void P*/ store, Loc loc, QualType T/*= QualType()*/)/* = 0*/;

  
  /// Return a state with the specified value bound to the given location.
  /// \param[in] store The analysis state.
  /// \param[in] loc The symbolic memory location.
  /// \param[in] val The value to bind to location \c loc.
  /// \return A pointer to a ProgramState object that contains the same
  ///   bindings as \c state with the addition of having the value specified
  ///   by \c val bound to the location given for \c loc.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::Bind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 70,
   FQN="clang::ento::StoreManager::Bind", NM="_ZN5clang4ento12StoreManager4BindEPKvNS0_3LocENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager4BindEPKvNS0_3LocENS0_4SValE")
  //</editor-fold>
  public abstract /*virtual*/ StoreRef Bind(/*const*/Object/*void P*/ store, Loc loc, SVal val)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::BindDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 51,
   FQN="clang::ento::StoreManager::BindDefault", NM="_ZN5clang4ento12StoreManager11BindDefaultEPKvPKNS0_9MemRegionENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager11BindDefaultEPKvPKNS0_9MemRegionENS0_4SValE")
  //</editor-fold>
  public StoreRef BindDefault(/*const*/Object/*void P*/ store, /*const*/ MemRegion /*P*/ R, SVal V) {
    return new StoreRef(store, /*Deref*/this);
  }

  
  /// \brief Create a new store with the specified binding removed.
  /// \param ST the original store, that is the basis for the new store.
  /// \param L the location whose binding should be removed.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::killBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 77,
   FQN="clang::ento::StoreManager::killBinding", NM="_ZN5clang4ento12StoreManager11killBindingEPKvNS0_3LocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager11killBindingEPKvNS0_3LocE")
  //</editor-fold>
  public abstract /*virtual*/ StoreRef killBinding(/*const*/Object/*void P*/ ST, Loc L)/* = 0*/;

  
  /// getInitialStore - Returns the initial "empty" store representing the
  ///  value bindings upon entry to an analyzed function.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getInitialStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 81,
   FQN="clang::ento::StoreManager::getInitialStore", NM="_ZN5clang4ento12StoreManager15getInitialStoreEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager15getInitialStoreEPKNS_15LocationContextE")
  //</editor-fold>
  public abstract /*virtual*/ StoreRef getInitialStore(/*const*/ LocationContext /*P*/ InitLoc)/* = 0*/;

  
  /// getRegionManager - Returns the internal RegionManager object that is
  ///  used to query and manipulate MemRegion objects.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 85,
   FQN="clang::ento::StoreManager::getRegionManager", NM="_ZN5clang4ento12StoreManager16getRegionManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager16getRegionManagerEv")
  //</editor-fold>
  public MemRegionManager /*&*/ getRegionManager() {
    return MRMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getLValueVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 87,
   FQN="clang::ento::StoreManager::getLValueVar", NM="_ZN5clang4ento12StoreManager12getLValueVarEPKNS_7VarDeclEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager12getLValueVarEPKNS_7VarDeclEPKNS_15LocationContextE")
  //</editor-fold>
  public /*virtual*/ Loc getLValueVar(/*const*/ VarDecl /*P*/ VD, /*const*/ LocationContext /*P*/ LC) {
    return svalBuilder.makeLoc(MRMgr.getVarRegion(VD, LC));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getLValueCompoundLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 91,
   FQN="clang::ento::StoreManager::getLValueCompoundLiteral", NM="_ZN5clang4ento12StoreManager24getLValueCompoundLiteralEPKNS_19CompoundLiteralExprEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager24getLValueCompoundLiteralEPKNS_19CompoundLiteralExprEPKNS_15LocationContextE")
  //</editor-fold>
  public Loc getLValueCompoundLiteral(/*const*/ CompoundLiteralExpr /*P*/ CL, 
                          /*const*/ LocationContext /*P*/ LC) {
    return new Loc(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MRMgr.getCompoundLiteralRegion(CL, LC)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getLValueIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 423,
   FQN="clang::ento::StoreManager::getLValueIvar", NM="_ZN5clang4ento12StoreManager13getLValueIvarEPKNS_12ObjCIvarDeclENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager13getLValueIvarEPKNS_12ObjCIvarDeclENS0_4SValE")
  //</editor-fold>
  public SVal getLValueIvar(/*const*/ ObjCIvarDecl /*P*/ decl, SVal base) {
    return getLValueFieldOrIvar(decl, new SVal(base));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getLValueField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 98,
   FQN="clang::ento::StoreManager::getLValueField", NM="_ZN5clang4ento12StoreManager14getLValueFieldEPKNS_9FieldDeclENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager14getLValueFieldEPKNS_9FieldDeclENS0_4SValE")
  //</editor-fold>
  public /*virtual*/ SVal getLValueField(/*const*/ FieldDecl /*P*/ D, SVal Base) {
    return getLValueFieldOrIvar(D, new SVal(Base));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getLValueElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 427,
   FQN="clang::ento::StoreManager::getLValueElement", NM="_ZN5clang4ento12StoreManager16getLValueElementENS_8QualTypeENS0_6NonLocENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager16getLValueElementENS_8QualTypeENS0_6NonLocENS0_4SValE")
  //</editor-fold>
  public SVal getLValueElement(QualType elementType, NonLoc Offset, 
                  SVal Base) {
    
    // If the base is an unknown or undefined value, just return it back.
    // FIXME: For absolute pointer addresses, we just return that value back as
    //  well, although in reality we should return the offset added to that
    //  value.
    if (Base.isUnknownOrUndef$SVal() || Base.getAs(NsLoc.ConcreteInt.class).$bool()) {
      return new SVal(JD$Move.INSTANCE, Base);
    }
    
    /*const*/ MemRegion /*P*/ BaseRegion = Base.castAs(NsLoc.MemRegionVal.class).getRegion();
    
    // Pointer of any type can be cast and used as array base.
    /*const*/ ElementRegion /*P*/ ElemR = dyn_cast_ElementRegion(BaseRegion);
    
    // Convert the offset to the appropriate size and signedness.
    Offset.$assignMove(svalBuilder.convertToArrayIndex(new SVal(Offset)).castAs(NonLoc.class));
    if (!(ElemR != null)) {
      //
      // If the base region is not an ElementRegion, create one.
      // This can happen in the following example:
      //
      //   char *p = __builtin_alloc(10);
      //   p[1] = 8;
      //
      //  Observe that 'p' binds to an AllocaRegion.
      //
      return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MRMgr.getElementRegion(new QualType(elementType), new NonLoc(Offset), 
                  BaseRegion, Ctx)));
    }
    
    SVal BaseIdx = new SVal(JD$Move.INSTANCE, ElemR.getIndex());
    if (!BaseIdx.getAs(NsNonloc.ConcreteInt.class).$bool()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    final /*const*/ APSInt /*&*/ BaseIdxI = BaseIdx.castAs(NsNonloc.ConcreteInt.class).getValue();
    
    // Only allow non-integer offsets if the base region has no offset itself.
    // FIXME: This is a somewhat arbitrary restriction. We should be using
    // SValBuilder here to add the two offsets without checking their types.
    if (!Offset.getAs(NsNonloc.ConcreteInt.class).$bool()) {
      if (isa_ElementRegion(BaseRegion.StripCasts())) {
        return new SVal(JD$Move.INSTANCE, new UnknownVal());
      }
      
      return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MRMgr.getElementRegion(new QualType(elementType), new NonLoc(Offset), 
                  ElemR.getSuperRegion(), 
                  Ctx)));
    }
    
    final /*const*/ APSInt /*&*/ OffI = Offset.castAs(NsNonloc.ConcreteInt.class).getValue();
    assert (BaseIdxI.isSigned());
    
    // Compute the new index.
    NsNonloc.ConcreteInt NewIdx/*J*/= new NsNonloc.ConcreteInt(svalBuilder.getBasicValueFactory().getValue(BaseIdxI.$add(
                OffI
            )));
    
    // Construct the new ElementRegion.
    /*const*/ MemRegion /*P*/ ArrayR = ElemR.getSuperRegion();
    return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MRMgr.getElementRegion(new QualType(elementType), new NonLoc(NewIdx), ArrayR, 
                Ctx)));
  }

  
  // FIXME: This should soon be eliminated altogether; clients should deal with
  // region extents directly.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getSizeInElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 106,
   FQN="clang::ento::StoreManager::getSizeInElements", NM="_ZN5clang4ento12StoreManager17getSizeInElementsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17getSizeInElementsEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS_8QualTypeE")
  //</editor-fold>
  public /*virtual*/ DefinedOrUnknownSVal getSizeInElements(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                   /*const*/ MemRegion /*P*/ region, 
                   QualType EleTy) {
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  /// ArrayToPointer - Used by ExprEngine::VistCast to handle implicit
  ///  conversions between arrays and pointers.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::ArrayToPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 114,
   FQN="clang::ento::StoreManager::ArrayToPointer", NM="_ZN5clang4ento12StoreManager14ArrayToPointerENS0_3LocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager14ArrayToPointerENS0_3LocENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ SVal ArrayToPointer(Loc Array, QualType ElementTy)/* = 0*/;

  
  /// Evaluates a chain of derived-to-base casts through the path specified in
  /// \p Cast.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::evalDerivedToBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 235,
   FQN="clang::ento::StoreManager::evalDerivedToBase", NM="_ZN5clang4ento12StoreManager17evalDerivedToBaseENS0_4SValEPKNS_8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17evalDerivedToBaseENS0_4SValEPKNS_8CastExprE")
  //</editor-fold>
  public SVal evalDerivedToBase(SVal Derived, /*const*/ CastExpr /*P*/ Cast) {
    // Sanity check to avoid doing the wrong thing in the face of
    // reinterpret_cast.
    if (!StoreStatics.regionMatchesCXXRecordType(new SVal(Derived), Cast.getSubExpr$Const().getType())) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    // Walk through the cast path to create nested CXXBaseRegions.
    SVal Result = new SVal(Derived);
    for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> I = $tryClone(Cast.path_begin$Const()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(Cast.path_end$Const());
         $noteq_ptr(I, E); I.$preInc()) {
      Result.$assignMove(evalDerivedToBase(new SVal(Result), (I.$star()).getType(), (I.$star()).isVirtual()));
    }
    return Result;
  }

  
  /// Evaluates a chain of derived-to-base casts through the specified path.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::evalDerivedToBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 251,
   FQN="clang::ento::StoreManager::evalDerivedToBase", NM="_ZN5clang4ento12StoreManager17evalDerivedToBaseENS0_4SValERKNS_11CXXBasePathE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17evalDerivedToBaseENS0_4SValERKNS_11CXXBasePathE")
  //</editor-fold>
  public SVal evalDerivedToBase(SVal Derived, final /*const*/ CXXBasePath /*&*/ Path) {
    // Walk through the path to create nested CXXBaseRegions.
    SVal Result = new SVal(Derived);
    for (type$ptr</*const*/ CXXBasePathElement /*P*/ > I = $tryClone(Path.begin$Const()), /*P*/ E = $tryClone(Path.end$Const());
         $noteq_ptr(I, E); I.$preInc()) {
      Result.$assignMove(evalDerivedToBase(new SVal(Result), I./*->*/$star().Base.getType(), 
              I./*->*/$star().Base.isVirtual()));
    }
    return Result;
  }

  
  /// Evaluates a derived-to-base cast through a single level of derivation.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::evalDerivedToBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 262,
   FQN="clang::ento::StoreManager::evalDerivedToBase", NM="_ZN5clang4ento12StoreManager17evalDerivedToBaseENS0_4SValENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17evalDerivedToBaseENS0_4SValENS_8QualTypeEb")
  //</editor-fold>
  public SVal evalDerivedToBase(SVal Derived, QualType BaseType, 
                   boolean IsVirtual) {
    Optional<NsLoc.MemRegionVal> DerivedRegVal = Derived.getAs(NsLoc.MemRegionVal.class);
    if (!DerivedRegVal.$bool()) {
      return new SVal(JD$Move.INSTANCE, Derived);
    }
    
    /*const*/ CXXRecordDecl /*P*/ BaseDecl = BaseType.$arrow().getPointeeCXXRecordDecl();
    if (!(BaseDecl != null)) {
      BaseDecl = BaseType.$arrow().getAsCXXRecordDecl();
    }
    assert ((BaseDecl != null)) : "not a C++ object?";
    
    /*const*/ MemRegion /*P*/ BaseReg = MRMgr.getCXXBaseObjectRegion(BaseDecl, DerivedRegVal.$arrow().getRegion(), 
        IsVirtual);
    
    return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(BaseReg));
  }

  
  /// \brief Evaluates C++ dynamic_cast cast.
  /// The callback may result in the following 3 scenarios:
  ///  - Successful cast (ex: derived is subclass of base).
  ///  - Failed cast (ex: derived is definitely not a subclass of base).
  ///  - We don't know (base is a symbolic region and we don't have 
  ///    enough info to determine if the cast will succeed at run time).
  /// The function returns an SVal representing the derived class; it's
  /// valid only if Failed flag is set to false.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::evalDynamicCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 295,
   FQN="clang::ento::StoreManager::evalDynamicCast", NM="_ZN5clang4ento12StoreManager15evalDynamicCastENS0_4SValENS_8QualTypeERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager15evalDynamicCastENS0_4SValENS_8QualTypeERb")
  //</editor-fold>
  public SVal evalDynamicCast(SVal Base, QualType TargetType, 
                 final bool$ref/*bool &*/ Failed) {
    Failed.$set(false);
    
    /*const*/ MemRegion /*P*/ MR = Base.getAsRegion();
    if (!(MR != null)) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    // Assume the derived class is a pointer or a reference to a CXX record.
    TargetType.$assignMove(TargetType.$arrow().getPointeeType());
    assert (!TargetType.isNull());
    /*const*/ CXXRecordDecl /*P*/ TargetClass = TargetType.$arrow().getAsCXXRecordDecl();
    if (!(TargetClass != null) && !TargetType.$arrow().isVoidType()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    {
      
      // Drill down the CXXBaseObject chains, which represent upcasts (casts from
      // derived to base).
      /*const*/ CXXRecordDecl /*P*/ MRClass;
      while (((/*P*/ MRClass = StoreStatics.getCXXRecordType(MR)) != null)) {
        // If found the derived class, the cast succeeds.
        if (MRClass == TargetClass) {
          return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MR));
        }
        
        // We skip over incomplete types. They must be the result of an earlier
        // reinterpret_cast, as one can only dynamic_cast between types in the same
        // class hierarchy.
        if (!TargetType.$arrow().isVoidType() && MRClass.hasDefinition()) {
          CXXBasePaths Paths = null;
          try {
            // Static upcasts are marked as DerivedToBase casts by Sema, so this will
            // only happen when multiple or virtual inheritance is involved.
            Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ false, /*RecordPaths=*/ true, 
                /*DetectVirtual=*/ false);
            if (MRClass.isDerivedFrom(TargetClass, Paths)) {
              return evalDerivedToBase(new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MR)), Paths.front());
            }
          } finally {
            if (Paths != null) { Paths.$destroy(); }
          }
        }
        {
          
          /*const*/ CXXBaseObjectRegion /*P*/ BaseR = dyn_cast_CXXBaseObjectRegion(MR);
          if ((BaseR != null)) {
            // Drill down the chain to get the derived classes.
            MR = BaseR.getSuperRegion();
            continue;
          }
        }
        
        // If this is a cast to void*, return the region.
        if (TargetType.$arrow().isVoidType()) {
          return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MR));
        }
        
        // Strange use of reinterpret_cast can give us paths we don't reason
        // about well, by putting in ElementRegions where we'd expect
        // CXXBaseObjectRegions. If it's a valid reinterpret_cast (i.e. if the
        // derived class has a zero offset from the base class), then it's safe
        // to strip the cast; if it's invalid, -Wreinterpret-base-class should
        // catch it. In the interest of performance, the analyzer will silently
        // do the wrong thing in the invalid case (because offsets for subregions
        // will be wrong).
        /*const*/ MemRegion /*P*/ Uncasted = MR.StripCasts(/*IncludeBaseCasts=*/ false);
        if (Uncasted == MR) {
          // We reached the bottom of the hierarchy and did not find the derived
          // class. We we must be casting the base to derived, so the cast should
          // fail.
          break;
        }
        
        MR = Uncasted;
      }
    }
    
    // We failed if the region we ended up with has perfect type info.
    Failed.$set(isa_TypedValueRegion(MR));
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::GetElementZeroRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 55,
   FQN="clang::ento::StoreManager::GetElementZeroRegion", NM="_ZN5clang4ento12StoreManager20GetElementZeroRegionEPKNS0_9MemRegionENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager20GetElementZeroRegionEPKNS0_9MemRegionENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ ElementRegion /*P*/ GetElementZeroRegion(/*const*/ MemRegion /*P*/ R, 
                      QualType T) {
    NonLoc idx = svalBuilder.makeZeroArrayIndex();
    assert (!T.isNull());
    return MRMgr.getElementRegion(new QualType(T), new NonLoc(idx), R, Ctx);
  }

  
  /// castRegion - Used by ExprEngine::VisitCast to handle casts from
  ///  a MemRegion* to a specific location type.  'R' is the region being
  ///  casted and 'CastToTy' the result type of the cast.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::castRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 62,
   FQN="clang::ento::StoreManager::castRegion", NM="_ZN5clang4ento12StoreManager10castRegionEPKNS0_9MemRegionENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager10castRegionEPKNS0_9MemRegionENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ castRegion(/*const*/ MemRegion /*P*/ R, QualType CastToTy) {
    
    final ASTContext /*&*/ Ctx = StateMgr.getContext();
    
    // Handle casts to Objective-C objects.
    if (CastToTy.$arrow().isObjCObjectPointerType()) {
      return R.StripCasts();
    }
    if (CastToTy.$arrow().isBlockPointerType()) {
      // FIXME: We may need different solutions, depending on the symbol
      // involved.  Blocks can be casted to/from 'id', as they can be treated
      // as Objective-C objects.  This could possibly be handled by enhancing
      // our reasoning of downcasts of symbolic objects.
      if (isa_CodeTextRegion(R) || isa_SymbolicRegion(R)) {
        return R;
      }
      
      // We don't know what to make of it.  Return a NULL region, which
      // will be interpretted as UnknownVal.
      return null;
    }
    
    // Now assume we are casting from pointer to pointer. Other cases should
    // already be handled.
    QualType PointeeTy = CastToTy.$arrow().getPointeeType();
    QualType CanonPointeeTy = Ctx.getCanonicalType(/*NO_COPY*/PointeeTy).$QualType();
    
    // Handle casts to void*.  We just pass the region through.
    if (QualType.$eq_QualType$C(CanonPointeeTy.getLocalUnqualifiedType(), Ctx.VoidTy.$QualType())) {
      return R;
    }
    
    // Handle casts from compatible types.
    if (R.isBoundable()) {
      {
        /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_TypedValueRegion(R);
        if ((TR != null)) {
          QualType ObjTy = Ctx.getCanonicalType(TR.getValueType()).$QualType();
          if (QualType.$eq_QualType$C(CanonPointeeTy, ObjTy)) {
            return R;
          }
        }
      }
    }
    
    // Process region cast according to the kind of the region being cast.
    switch (R.getKind()) {
     case CXXThisRegionKind:
     case CodeSpaceRegionKind:
     case StackLocalsSpaceRegionKind:
     case StackArgumentsSpaceRegionKind:
     case HeapSpaceRegionKind:
     case UnknownSpaceRegionKind:
     case StaticGlobalSpaceRegionKind:
     case GlobalInternalSpaceRegionKind:
     case GlobalSystemSpaceRegionKind:
     case GlobalImmutableSpaceRegionKind:
      {
        throw new llvm_unreachable("Invalid region cast");
      }
     case FunctionCodeRegionKind:
     case BlockCodeRegionKind:
     case BlockDataRegionKind:
     case StringRegionKind:
     case SymbolicRegionKind:
     case AllocaRegionKind:
     case CompoundLiteralRegionKind:
     case FieldRegionKind:
     case ObjCIvarRegionKind:
     case ObjCStringRegionKind:
     case VarRegionKind:
     case CXXTempObjectRegionKind:
     case CXXBaseObjectRegionKind:
      // FIXME: Need to handle arbitrary downcasts.
      return MakeElementRegion(R, new QualType(PointeeTy));
     case ElementRegionKind:
      {
        // If we are casting from an ElementRegion to another type, the
        // algorithm is as follows:
        //
        // (1) Compute the "raw offset" of the ElementRegion from the
        //     base region.  This is done by calling 'getAsRawOffset()'.
        //
        // (2a) If we get a 'RegionRawOffset' after calling
        //      'getAsRawOffset()', determine if the absolute offset
        //      can be exactly divided into chunks of the size of the
        //      casted-pointee type.  If so, create a new ElementRegion with
        //      the pointee-cast type as the new ElementType and the index
        //      being the offset divded by the chunk size.  If not, create
        //      a new ElementRegion at offset 0 off the raw offset region.
        //
        // (2b) If we don't a get a 'RegionRawOffset' after calling
        //      'getAsRawOffset()', it means that we are at offset 0.
        //
        // FIXME: Handle symbolic raw offsets.
        /*const*/ ElementRegion /*P*/ elementR = cast_ElementRegion(R);
        final /*const*/ RegionRawOffset /*&*/ rawOff = elementR.getAsArrayOffset();
        /*const*/ MemRegion /*P*/ baseR = rawOff.getRegion();
        
        // If we cannot compute a raw offset, throw up our hands and return
        // a NULL MemRegion*.
        if (!(baseR != null)) {
          return null;
        }
        
        CharUnits off = rawOff.getOffset();
        if (off.isZero()) {
          {
            // Edge case: we are at 0 bytes off the beginning of baseR.  We
            // check to see if type we are casting to is the same as the base
            // region.  If so, just return the base region.
            /*const*/ TypedValueRegion /*P*/ TR = dyn_cast_TypedValueRegion(baseR);
            if ((TR != null)) {
              QualType ObjTy = Ctx.getCanonicalType(TR.getValueType()).$QualType();
              QualType CanonPointeeTy$1 = Ctx.getCanonicalType(/*NO_COPY*/PointeeTy).$QualType();
              if (QualType.$eq_QualType$C(CanonPointeeTy$1, ObjTy)) {
                return baseR;
              }
            }
          }
          
          // Otherwise, create a new ElementRegion at offset 0.
          return MakeElementRegion(baseR, new QualType(PointeeTy));
        }
        
        // We have a non-zero offset from the base region.  We want to determine
        // if the offset can be evenly divided by sizeof(PointeeTy).  If so,
        // we create an ElementRegion whose index is that value.  Otherwise, we
        // create two ElementRegions, one that reflects a raw offset and the other
        // that reflects the cast.
        
        // Compute the index for the new ElementRegion.
        long/*int64_t*/ newIndex = 0;
        /*const*/ MemRegion /*P*/ newSuperR = null;
        
        // We can only compute sizeof(PointeeTy) if it is a complete type.
        if (!PointeeTy.$arrow().isIncompleteType()) {
          // Compute the size in **bytes**.
          CharUnits pointeeTySize = Ctx.getTypeSizeInChars(/*NO_COPY*/PointeeTy);
          if (!pointeeTySize.isZero()) {
            // Is the offset a multiple of the size?  If so, we can layer the
            // ElementRegion (with elementType == PointeeTy) directly on top of
            // the base region.
            if (off.$mod(pointeeTySize) == 0) {
              newIndex = off.$slash(pointeeTySize);
              newSuperR = baseR;
            }
          }
        }
        if (!(newSuperR != null)) {
          // Create an intermediate ElementRegion to represent the raw byte.
          // This will be the super region of the final ElementRegion.
          newSuperR = MakeElementRegion(baseR, Ctx.CharTy.$QualType(), off.getQuantity());
        }
        
        return MakeElementRegion(newSuperR, new QualType(PointeeTy), newIndex);
      }
    }
    throw new llvm_unreachable("unreachable");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::removeDeadBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 144,
   FQN="clang::ento::StoreManager::removeDeadBindings", NM="_ZN5clang4ento12StoreManager18removeDeadBindingsEPKvPKNS_17StackFrameContextERNS0_12SymbolReaperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager18removeDeadBindingsEPKvPKNS_17StackFrameContextERNS0_12SymbolReaperE")
  //</editor-fold>
  public abstract /*virtual*/ StoreRef removeDeadBindings(/*const*/Object/*void P*/ store, /*const*/ StackFrameContext /*P*/ LCtx, 
                    final SymbolReaper /*&*/ SymReaper)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::includedInBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 147,
   FQN="clang::ento::StoreManager::includedInBindings", NM="_ZNK5clang4ento12StoreManager18includedInBindingsEPKvPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZNK5clang4ento12StoreManager18includedInBindingsEPKvPKNS0_9MemRegionE")
  //</editor-fold>
  public abstract /*virtual*/ boolean includedInBindings(/*const*/Object/*void P*/ store, 
                    /*const*/ MemRegion /*P*/ region) /*const*//* = 0*/;

  
  /// If the StoreManager supports it, increment the reference count of
  /// the specified Store object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::incrementReferenceCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 152,
   FQN="clang::ento::StoreManager::incrementReferenceCount", NM="_ZN5clang4ento12StoreManager23incrementReferenceCountEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager23incrementReferenceCountEPKv")
  //</editor-fold>
  public /*virtual*/ void incrementReferenceCount(/*const*/Object/*void P*/ store) {
  }

  
  /// If the StoreManager supports it, decrement the reference count of
  /// the specified Store object.  If the reference count hits 0, the memory
  /// associated with the object is recycled.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::decrementReferenceCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 157,
   FQN="clang::ento::StoreManager::decrementReferenceCount", NM="_ZN5clang4ento12StoreManager23decrementReferenceCountEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager23decrementReferenceCountEPKv")
  //</editor-fold>
  public /*virtual*/ void decrementReferenceCount(/*const*/Object/*void P*/ store) {
  }

  
  // JAVA: typedef SmallVector<const MemRegion *, 8> InvalidatedRegions
//  public final class InvalidatedRegions extends SmallVector</*const*/ MemRegion /*P*/ >{ };
  
  /// invalidateRegions - Clears out the specified regions from the store,
  ///  marking their values as unknown. Depending on the store, this may also
  ///  invalidate additional regions that may have changed based on accessing
  ///  the given regions. Optionally, invalidates non-static globals as well.
  /// \param[in] store The initial store
  /// \param[in] Values The values to invalidate.
  /// \param[in] E The current statement being evaluated. Used to conjure
  ///   symbols to mark the values of invalidated regions.
  /// \param[in] Count The current block count. Used to conjure
  ///   symbols to mark the values of invalidated regions.
  /// \param[in] Call The call expression which will be used to determine which
  ///   globals should get invalidated.
  /// \param[in,out] IS A set to fill with any symbols that are no longer
  ///   accessible. Pass \c NULL if this information will not be used.
  /// \param[in] ITraits Information about invalidation for a particular 
  ///   region/symbol.
  /// \param[in,out] InvalidatedTopLevel A vector to fill with regions
  ////  explicitly being invalidated. Pass \c NULL if this
  ///   information will not be used.
  /// \param[in,out] Invalidated A vector to fill with any regions being
  ///   invalidated. This should include any regions explicitly invalidated
  ///   even if they do not currently have bindings. Pass \c NULL if this
  ///   information will not be used.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::invalidateRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 184,
   FQN="clang::ento::StoreManager::invalidateRegions", NM="_ZN5clang4ento12StoreManager17invalidateRegionsEPKvN4llvm8ArrayRefINS0_4SValEEEPKNS_4ExprEjPKNS_15LocationContextEPKNS0_9CallEventERNS4_8DenseSetIPKNS0_7SymExprENS4_12DenseMapInfoISK_EEEERNS0_33RegionAndSymbolInvalidationTraitsEPNS4_11SmallVectorIPKNS0_9MemRegionELj8EEESW_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17invalidateRegionsEPKvN4llvm8ArrayRefINS0_4SValEEEPKNS_4ExprEjPKNS_15LocationContextEPKNS0_9CallEventERNS4_8DenseSetIPKNS0_7SymExprENS4_12DenseMapInfoISK_EEEERNS0_33RegionAndSymbolInvalidationTraitsEPNS4_11SmallVectorIPKNS0_9MemRegionELj8EEESW_")
  //</editor-fold>
  public abstract /*virtual*/ StoreRef invalidateRegions(/*const*/Object/*void P*/ store, 
                   ArrayRef<SVal> Values, 
                   /*const*/ Expr /*P*/ E, /*uint*/int Count, 
                   /*const*/ LocationContext /*P*/ LCtx, 
                   /*const*/ CallEvent /*P*/ Call, 
                   final DenseSet</*const*/ SymExpr /*P*/ > /*&*/ IS, 
                   final RegionAndSymbolInvalidationTraits /*&*/ ITraits, 
                   SmallVector</*const*/ MemRegion /*P*/ > /*P*/ InvalidatedTopLevel, 
                   SmallVector</*const*/ MemRegion /*P*/ > /*P*/ Invalidated)/* = 0*/;

  
  /// enterStackFrame - Let the StoreManager to do something when execution
  /// engine is about to execute into a callee.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::enterStackFrame">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 28,
   FQN="clang::ento::StoreManager::enterStackFrame", NM="_ZN5clang4ento12StoreManager15enterStackFrameEPKvRKNS0_9CallEventEPKNS_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager15enterStackFrameEPKvRKNS0_9CallEventEPKNS_17StackFrameContextE")
  //</editor-fold>
  public StoreRef enterStackFrame(/*const*/Object/*void P*/ OldStore, 
                 final /*const*/ CallEvent /*&*/ Call, 
                 /*const*/ StackFrameContext /*P*/ LCtx) {
    StoreRef Store = null;
    try {
      Store = new StoreRef(OldStore, /*Deref*/this);
      
      SmallVector<std.pairTypeType<Loc, SVal>> InitialBindings/*J*/= new SmallVector<std.pairTypeType<Loc, SVal>>(16, new std.pairTypeType<Loc, SVal>(new Loc(), new SVal()));
      Call.getInitialStackFrameContents(LCtx, InitialBindings);
      
      for (type$ptr<std.pairTypeType<Loc, SVal> /*P*/> I = $tryClone(InitialBindings.begin()), 
          /*P*/ E = $tryClone(InitialBindings.end());
           $noteq_ptr(I, E); I.$preInc()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Store.$assign($c$.track(Bind(Store.getStore(), new Loc(I./*->*/$star().first), new SVal(I./*->*/$star().second)))));
        } finally {
          $c$.$destroy();
        }
      }
      
      return new StoreRef(Store);
    } finally {
      if (Store != null) { Store.$destroy(); }
    }
  }

  
  /// Finds the transitive closure of symbols within the given region.
  ///
  /// Returns false if the visitor aborted the scan.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::scanReachableSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 203,
   FQN="clang::ento::StoreManager::scanReachableSymbols", NM="_ZN5clang4ento12StoreManager20scanReachableSymbolsEPKvPKNS0_9MemRegionERNS0_20ScanReachableSymbolsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager20scanReachableSymbolsEPKvPKNS0_9MemRegionERNS0_20ScanReachableSymbolsE")
  //</editor-fold>
  public abstract /*virtual*/ boolean scanReachableSymbols(/*const*/Object/*void P*/ S, /*const*/ MemRegion /*P*/ R, 
                      final ScanReachableSymbols /*&*/ Visitor)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 206,
   FQN="clang::ento::StoreManager::print", NM="_ZN5clang4ento12StoreManager5printEPKvRN4llvm11raw_ostreamEPKcS8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager5printEPKvRN4llvm11raw_ostreamEPKcS8_")
  //</editor-fold>
  public abstract /*virtual*/ void print(/*const*/Object/*void P*/ store, final raw_ostream /*&*/ Out, 
       /*const*/char$ptr/*char P*/ nl, /*const*/char$ptr/*char P*/ sep)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::BindingsHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 209,
   FQN="clang::ento::StoreManager::BindingsHandler", NM="_ZN5clang4ento12StoreManager15BindingsHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager15BindingsHandlerE")
  //</editor-fold>
  public abstract static class BindingsHandler implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::BindingsHandler::~BindingsHandler">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 492,
     FQN="clang::ento::StoreManager::BindingsHandler::~BindingsHandler", NM="_ZN5clang4ento12StoreManager15BindingsHandlerD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager15BindingsHandlerD0Ev")
    //</editor-fold>
    public void $destroy() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::BindingsHandler::HandleBinding">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 212,
     FQN="clang::ento::StoreManager::BindingsHandler::HandleBinding", NM="_ZN5clang4ento12StoreManager15BindingsHandler13HandleBindingERS1_PKvPKNS0_9MemRegionENS0_4SValE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager15BindingsHandler13HandleBindingERS1_PKvPKNS0_9MemRegionENS0_4SValE")
    //</editor-fold>
    public abstract /*virtual*/ boolean HandleBinding(final StoreManager /*&*/ SMgr, /*const*/Object/*void P*/ store, 
                 /*const*/ MemRegion /*P*/ region, SVal val)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::BindingsHandler::BindingsHandler">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 209,
     FQN="clang::ento::StoreManager::BindingsHandler::BindingsHandler", NM="_ZN5clang4ento12StoreManager15BindingsHandlerC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager15BindingsHandlerC1Ev")
    //</editor-fold>
    public /*inline*/ BindingsHandler() {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::FindUniqueBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 216,
   FQN="clang::ento::StoreManager::FindUniqueBinding", NM="_ZN5clang4ento12StoreManager17FindUniqueBindingE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17FindUniqueBindingE")
  //</editor-fold>
  public static class FindUniqueBinding extends /*public*/ BindingsHandler implements Destructors.ClassWithDestructor, Native.Native$Bool {
    private /*const*/ SymExpr /*P*/ Sym;
    private /*const*/ MemRegion /*P*/ Binding;
    private boolean First;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::FindUniqueBinding::FindUniqueBinding">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 223,
     FQN="clang::ento::StoreManager::FindUniqueBinding::FindUniqueBinding", NM="_ZN5clang4ento12StoreManager17FindUniqueBindingC1EPKNS0_7SymExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17FindUniqueBindingC1EPKNS0_7SymExprE")
    //</editor-fold>
    public FindUniqueBinding(/*const*/ SymExpr /*P*/ sym) {
      // : BindingsHandler(), Sym(sym), Binding(null), First(true) 
      //START JInit
      super();
      this.Sym = sym;
      this.Binding = null;
      this.First = true;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::FindUniqueBinding::HandleBinding">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 494,
     FQN="clang::ento::StoreManager::FindUniqueBinding::HandleBinding", NM="_ZN5clang4ento12StoreManager17FindUniqueBinding13HandleBindingERS1_PKvPKNS0_9MemRegionENS0_4SValE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17FindUniqueBinding13HandleBindingERS1_PKvPKNS0_9MemRegionENS0_4SValE")
    //</editor-fold>
    @Override public boolean HandleBinding(final StoreManager /*&*/ SMgr, 
                 /*const*/Object/*void P*/ store, 
                 /*const*/ MemRegion /*P*/ R, 
                 SVal val)/* override*/ {
      /*const*/ SymExpr /*P*/ SymV = val.getAsLocSymbol();
      if (!(SymV != null) || SymV != Sym) {
        return true;
      }
      if ((Binding != null)) {
        First = false;
        return false;
      } else {
        Binding = R;
      }
      
      return true;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::FindUniqueBinding::operator bool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 228,
     FQN="clang::ento::StoreManager::FindUniqueBinding::operator bool", NM="_ZN5clang4ento12StoreManager17FindUniqueBindingcvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17FindUniqueBindingcvbEv")
    //</editor-fold>
    public boolean $bool() {
      return First && (Binding != null);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::FindUniqueBinding::getRegion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 229,
     FQN="clang::ento::StoreManager::FindUniqueBinding::getRegion", NM="_ZN5clang4ento12StoreManager17FindUniqueBinding9getRegionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17FindUniqueBinding9getRegionEv")
    //</editor-fold>
    public /*const*/ MemRegion /*P*/ getRegion() {
      return Binding;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::FindUniqueBinding::~FindUniqueBinding">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 216,
     FQN="clang::ento::StoreManager::FindUniqueBinding::~FindUniqueBinding", NM="_ZN5clang4ento12StoreManager17FindUniqueBindingD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17FindUniqueBindingD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + "Sym=" + "[SymExpr]" // NOI18N
                + ", Binding=" + Binding // NOI18N
                + ", First=" + First // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// iterBindings - Iterate over the bindings in the Store.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::iterBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 233,
   FQN="clang::ento::StoreManager::iterBindings", NM="_ZN5clang4ento12StoreManager12iterBindingsEPKvRNS1_15BindingsHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager12iterBindingsEPKvRNS1_15BindingsHandlerE")
  //</editor-fold>
  public abstract /*virtual*/ void iterBindings(/*const*/Object/*void P*/ store, final BindingsHandler /*&*/ f)/* = 0*/;

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::MakeElementRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 45,
   FQN="clang::ento::StoreManager::MakeElementRegion", NM="_ZN5clang4ento12StoreManager17MakeElementRegionEPKNS0_9MemRegionENS_8QualTypeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager17MakeElementRegionEPKNS0_9MemRegionENS_8QualTypeEy")
  //</editor-fold>
  protected /*const*/ MemRegion /*P*/ MakeElementRegion(/*const*/ MemRegion /*P*/ Base, 
                   QualType EleTy) {
    return MakeElementRegion(Base, 
                   EleTy, $int2ulong(0));
  }
  protected /*const*/ MemRegion /*P*/ MakeElementRegion(/*const*/ MemRegion /*P*/ Base, 
                   QualType EleTy, long/*uint64_t*/ index/*= 0*/) {
    NonLoc idx = svalBuilder.makeArrayIndex(index);
    return MRMgr.getElementRegion(new QualType(EleTy), new NonLoc(idx), Base, svalBuilder.getContext());
  }

  
  /// CastRetrievedVal - Used by subclasses of StoreManager to implement
  ///  implicit casts that arise from loads from regions that are reinterpreted
  ///  as another region.
  
  /// CastRetrievedVal - Used by subclasses of StoreManager to implement
  ///  implicit casts that arise from loads from regions that are reinterpreted
  ///  as another region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::CastRetrievedVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 367,
   FQN="clang::ento::StoreManager::CastRetrievedVal", NM="_ZN5clang4ento12StoreManager16CastRetrievedValENS0_4SValEPKNS0_16TypedValueRegionENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager16CastRetrievedValENS0_4SValEPKNS0_16TypedValueRegionENS_8QualTypeEb")
  //</editor-fold>
  protected SVal CastRetrievedVal(SVal V, /*const*/ TypedValueRegion /*P*/ R, 
                  QualType castTy) {
    return CastRetrievedVal(V, R, 
                  castTy, true);
  }
  protected SVal CastRetrievedVal(SVal V, /*const*/ TypedValueRegion /*P*/ R, 
                  QualType castTy, boolean performTestOnly/*= true*/) {
    if (castTy.isNull() || V.isUnknownOrUndef$SVal()) {
      return new SVal(JD$Move.INSTANCE, V);
    }
    
    final ASTContext /*&*/ Ctx = svalBuilder.getContext();
    if (performTestOnly) {
      // Automatically translate references to pointers.
      QualType T = R.getValueType();
      {
        /*const*/ ReferenceType /*P*/ RT = T.$arrow().getAs(ReferenceType.class);
        if ((RT != null)) {
          T.$assignMove(Ctx.getPointerType(RT.getPointeeType()));
        }
      }
      assert (svalBuilder.getContext().hasSameUnqualifiedType(new QualType(castTy), new QualType(T)));
      return new SVal(JD$Move.INSTANCE, V);
    }
    
    return svalBuilder.dispatchCast(new SVal(V), new QualType(castTy));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreManager::getLValueFieldOrIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 388,
   FQN="clang::ento::StoreManager::getLValueFieldOrIvar", NM="_ZN5clang4ento12StoreManager20getLValueFieldOrIvarEPKNS_4DeclENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento12StoreManager20getLValueFieldOrIvarEPKNS_4DeclENS0_4SValE")
  //</editor-fold>
  private SVal getLValueFieldOrIvar(/*const*/ Decl /*P*/ D, SVal Base) {
    if (Base.isUnknownOrUndef$SVal()) {
      return new SVal(JD$Move.INSTANCE, Base);
    }
    
    Loc BaseL = Base.castAs(Loc.class);
    /*const*/ MemRegion /*P*/ BaseR = null;
    switch (NsLoc.Kind.valueOf(BaseL.getSubKind())) {
     case MemRegionValKind:
      BaseR = BaseL.castAs(NsLoc.MemRegionVal.class).getRegion();
      break;
     case GotoLabelKind:
      // These are anormal cases. Flag an undefined value.
      return new SVal(JD$Move.INSTANCE, new UndefinedVal());
     case ConcreteIntKind:
      // While these seem funny, this can happen through casts.
      // FIXME: What we should return is the field offset.  For example,
      //  add the field offset to the integer value.  That way funny things
      //  like this work properly:  &(((struct foo *) 0xa)->f)
      return new SVal(JD$Move.INSTANCE, Base);
     default:
      throw new llvm_unreachable("Unhandled Base.");
    }
    {
      
      // NOTE: We must have this check first because ObjCIvarDecl is a subclass
      // of FieldDecl.
      /*const*/ ObjCIvarDecl /*P*/ ID = dyn_cast_ObjCIvarDecl(D);
      if ((ID != null)) {
        return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MRMgr.getObjCIvarRegion(ID, BaseR)));
      }
    }
    
    return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(MRMgr.getFieldRegion(cast_FieldDecl(D), BaseR)));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public final /*virtual*/ SVal getBinding(/*const*/Object/*void P*/ store, Loc loc)/* = 0*/ { return getBinding(store, loc, new QualType()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "svalBuilder=" + "[SValBuilder]" // NOI18N
              + ", StateMgr=" + "[ProgramStateManager]" // NOI18N
              + ", MRMgr=" + "[MemRegionManager]" // NOI18N
              + ", Ctx=" + "[ASTContext]"; // NOI18N
  }
}
