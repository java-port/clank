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

import java.util.Iterator;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIterator;
import org.llvm.adt.ilist;
import org.llvm.adt.ilist_iterator;
import org.llvm.adt.ilist_traits;
import org.llvm.adt.ilist_traits_default_impl;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.isStrongerThanMonotonic;

//<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 291,
 FQN="llvm::AliasSetTracker", NM="_ZN4llvm15AliasSetTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTrackerE")
//</editor-fold>
public class AliasSetTracker implements Iterable<AliasSet>, Destructors.ClassWithDestructor {

  /// A CallbackVH to arrange for AliasSetTracker to be notified whenever a
  /// Value is deleted.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 294,
   FQN="llvm::AliasSetTracker::ASTCallbackVH", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVHE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVHE")
  //</editor-fold>
  /*friend*/public/*private*/ static final class ASTCallbackVH extends /*public*/ CallbackVH implements Destructors.ClassWithDestructor {
    private AliasSetTracker /*P*/ AST;
    
    //===----------------------------------------------------------------------===//
    //                     ASTCallbackVH Class Implementation
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::deleted">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 664,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::deleted", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVH7deletedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVH7deletedEv")
    //</editor-fold>
    @Override public/*private*/ void deleted()/* override*/ {
      assert ((AST != null)) : "ASTCallbackVH called with a null AliasSetTracker!";
      AST.deleteValue(getValPtr());
      // this now dangles!
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::allUsesReplacedWith">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 670,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::allUsesReplacedWith", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVH19allUsesReplacedWithEPNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVH19allUsesReplacedWithEPNS_5ValueE")
    //</editor-fold>
    @Override public/*private*/ void allUsesReplacedWith(Value /*P*/ V)/* override*/ {
      AST.copyValue(getValPtr(), V);
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::ASTCallbackVH">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 674,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::ASTCallbackVH", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVHC1EPNS_5ValueEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVHC1EPNS_5ValueEPS0_")
    //</editor-fold>
    public ASTCallbackVH(Value /*P*/ V) {
      this(V, (AliasSetTracker /*P*/ )null);
    }
    public ASTCallbackVH(Value /*P*/ V, AliasSetTracker /*P*/ ast/*= null*/) {
      // : CallbackVH(V), AST(ast) 
      //START JInit
      super(V);
      this.AST = ast;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 677,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::operator=", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVHaSEPNS_5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVHaSEPNS_5ValueE")
    //</editor-fold>
    public AliasSetTracker.ASTCallbackVH /*&*/ $assign_ASTCallbackVH(Value /*P*/ V) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(/*Deref*/this.$assignMove($c$.track(new ASTCallbackVH(V, AST))));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::ASTCallbackVH">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 294,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::ASTCallbackVH", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVHC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVHC1EOS1_")
    //</editor-fold>
    public /*inline*/ ASTCallbackVH(JD$Move _dparam, final ASTCallbackVH /*&&*/$Prm0) {
      // : CallbackVH(static_cast<ASTCallbackVH &&>()), AST(static_cast<ASTCallbackVH &&>().AST) 
      //START JInit
      super($Prm0);
      this.AST = $Prm0.AST;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 294,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::operator=", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVHaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVHaSERKS1_")
    //</editor-fold>
    public /*inline*/ ASTCallbackVH /*&*/ $assign(final /*const*/ ASTCallbackVH /*&*/ $Prm0) {
      /*J:ToBase*/super.$assign($Prm0);
      this.AST = $Prm0.AST;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 294,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::operator=", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVHaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVHaSEOS1_")
    //</editor-fold>
    public /*inline*/ ASTCallbackVH /*&*/ $assignMove(final ASTCallbackVH /*&&*/$Prm0) {
      /*J:ToBase*/super.$assign($Prm0);
      this.AST = $Prm0.AST;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::~ASTCallbackVH">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 294,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::~ASTCallbackVH", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVHD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVHD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVH::ASTCallbackVH">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 294,
     FQN="llvm::AliasSetTracker::ASTCallbackVH::ASTCallbackVH", NM="_ZN4llvm15AliasSetTracker13ASTCallbackVHC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13ASTCallbackVHC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ASTCallbackVH(final /*const*/ ASTCallbackVH /*&*/ $Prm0) {
      // : CallbackVH(), AST(.AST) 
      //START JInit
      super($Prm0);
      this.AST = $Prm0.AST;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "AST=" + AST // NOI18N
                + super.toString(); // NOI18N
    }
  };
  /// Traits to tell DenseMap that tell us how to compare and hash the value
  /// handle.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::ASTCallbackVHDenseMapInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 305,
   FQN="llvm::AliasSetTracker::ASTCallbackVHDenseMapInfo", NM="_ZN4llvm15AliasSetTracker25ASTCallbackVHDenseMapInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker25ASTCallbackVHDenseMapInfoE")
  //</editor-fold>
  private static class/*struct*/ ASTCallbackVHDenseMapInfo extends /*public*/ DenseMapInfo$LikePtr<Value> {
    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  private final AAResults /*&*/ AA;
  private ilist<AliasSet> AliasSets;
  
  // JAVA: typedef DenseMap<ASTCallbackVH, AliasSet::PointerRec *, ASTCallbackVHDenseMapInfo> PointerMapType
//  public final class PointerMapType extends DenseMap<ASTCallbackVH, AliasSet.PointerRec /*P*/ >{ };
  
  // Map from pointers to their node
  private DenseMap<ASTCallbackVH, AliasSet.PointerRec /*P*/ > PointerMap;
/*public:*/
  /// Create an empty collection of AliasSets, and use the specified alias
  /// analysis object to disambiguate load and store addresses.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::AliasSetTracker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 320,
   FQN="llvm::AliasSetTracker::AliasSetTracker", NM="_ZN4llvm15AliasSetTrackerC1ERNS_9AAResultsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTrackerC1ERNS_9AAResultsE")
  //</editor-fold>
  public /*explicit*/ AliasSetTracker(final AAResults /*&*/ aa) {
    // : AA(aa), AliasSets(), PointerMap() 
    //START JInit
    this./*&*/AA=/*&*/aa;
    this.AliasSets = new ilist<AliasSet>() {
      @Override
      protected ilist_traits<AliasSet> $createTraits() {
        return new ilist_traits_default_impl<AliasSet>(){
          @Override
          public AliasSet createSentinel() {
            return new AliasSet();
          }
        };
      }
    };
    this.PointerMap = new DenseMap<ASTCallbackVH, AliasSet.PointerRec /*P*/ >(ASTCallbackVHDenseMapInfo.$Info(), (AliasSet.PointerRec /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::~AliasSetTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 321,
   FQN="llvm::AliasSetTracker::~AliasSetTracker", NM="_ZN4llvm15AliasSetTrackerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTrackerD0Ev")
  //</editor-fold>
  public void $destroy() {
    clear();
    //START JDestroy
    PointerMap.$destroy();
    AliasSets.$destroy();
    //END JDestroy
  }

  
  /// These methods are used to add different types of instructions to the alias
  /// sets. Adding a new instruction can result in one of three actions
  /// happening:
  ///
  ///   1. If the instruction doesn't alias any other sets, create a new set.
  ///   2. If the instruction aliases exactly one set, add it to the set
  ///   3. If the instruction aliases multiple sets, merge the sets, and add
  ///      the instruction to the result.
  ///
  /// These methods return true if inserting the instruction resulted in the
  /// addition of a new alias set (i.e., the pointer did not alias anything).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 300,
   FQN="llvm::AliasSetTracker::add", NM="_ZN4llvm15AliasSetTracker3addEPNS_5ValueEyRKNS_9AAMDNodesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3addEPNS_5ValueEyRKNS_9AAMDNodesE")
  //</editor-fold>
  public boolean add(Value /*P*/ Ptr, long/*uint64_t*/ Size, final /*const*/ AAMDNodes /*&*/ AAInfo) {
    bool$ref NewPtr = create_bool$ref();
    addPointer(Ptr, Size, AAInfo, AliasSet.AccessLattice.NoAccess, NewPtr);
    return NewPtr.$deref();
  }
 // Add a loc.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::add">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 307,
   FQN="llvm::AliasSetTracker::add", NM="_ZN4llvm15AliasSetTracker3addEPNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3addEPNS_8LoadInstE")
  //</editor-fold>
  public boolean add(LoadInst /*P*/ LI) {
    if (AdtsupportLlvmGlobals.isStrongerThanMonotonic(LI.getOrdering())) {
      return addUnknown(LI);
    }
    
    AAMDNodes AAInfo/*J*/= new AAMDNodes();
    LI.getAAMetadata(AAInfo);
    
    AliasSet.AccessLattice Access = AliasSet.AccessLattice.RefAccess;
    bool$ref NewPtr = create_bool$ref();
    final /*const*/ DataLayout /*&*/ DL = LI.getModule().getDataLayout();
    final AliasSet /*&*/ AS = addPointer(LI.getOperand(0), 
        DL.getTypeStoreSize(LI.getType()), 
        AAInfo, Access, NewPtr);
    if (LI.isVolatile()) {
      AS.setVolatile();
    }
    return NewPtr.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 323,
   FQN="llvm::AliasSetTracker::add", NM="_ZN4llvm15AliasSetTracker3addEPNS_9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3addEPNS_9StoreInstE")
  //</editor-fold>
  public boolean add(StoreInst /*P*/ SI) {
    if (isStrongerThanMonotonic(SI.getOrdering())) {
      return addUnknown(SI);
    }
    
    AAMDNodes AAInfo/*J*/= new AAMDNodes();
    SI.getAAMetadata(AAInfo);
    
    AliasSet.AccessLattice Access = AliasSet.AccessLattice.ModAccess;
    bool$ref NewPtr = create_bool$ref();
    final /*const*/ DataLayout /*&*/ DL = SI.getModule().getDataLayout();
    Value /*P*/ Val = SI.getOperand(0);
    final AliasSet /*&*/ AS = addPointer(SI.getOperand(1), 
        DL.getTypeStoreSize(Val.getType()), 
        AAInfo, Access, NewPtr);
    if (SI.isVolatile()) {
      AS.setVolatile();
    }
    return NewPtr.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 340,
   FQN="llvm::AliasSetTracker::add", NM="_ZN4llvm15AliasSetTracker3addEPNS_9VAArgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3addEPNS_9VAArgInstE")
  //</editor-fold>
  public boolean add(VAArgInst /*P*/ VAAI) {
    AAMDNodes AAInfo/*J*/= new AAMDNodes();
    VAAI.getAAMetadata(AAInfo);
    
    bool$ref NewPtr = create_bool$ref();
    addPointer(VAAI.getOperand(0), MemoryLocation.UnknownSize, AAInfo, 
        AliasSet.AccessLattice.ModRefAccess, NewPtr);
    return NewPtr.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 350,
   FQN="llvm::AliasSetTracker::add", NM="_ZN4llvm15AliasSetTracker3addEPNS_10MemSetInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3addEPNS_10MemSetInstE")
  //</editor-fold>
  public boolean add(MemSetInst /*P*/ MSI) {
    AAMDNodes AAInfo/*J*/= new AAMDNodes();
    MSI.getAAMetadata(AAInfo);
    
    bool$ref NewPtr = create_bool$ref();
    long/*uint64_t*/ Len;
    {
      
      ConstantInt /*P*/ C = dyn_cast_ConstantInt(MSI.getLength());
      if ((C != null)) {
        Len = C.getZExtValue();
      } else {
        Len = MemoryLocation.UnknownSize;
      }
    }
    
    final AliasSet /*&*/ AS = addPointer(MSI.getRawDest(), Len, AAInfo, AliasSet.AccessLattice.ModAccess, NewPtr);
    if (MSI.isVolatile()) {
      AS.setVolatile();
    }
    return NewPtr.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 386,
   FQN="llvm::AliasSetTracker::add", NM="_ZN4llvm15AliasSetTracker3addEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3addEPNS_11InstructionE")
  //</editor-fold>
  public boolean add(Instruction /*P*/ I) {
    {
      // Dispatch to one of the other add methods.
      LoadInst /*P*/ LI = dyn_cast_LoadInst(I);
      if ((LI != null)) {
        return add(LI);
      }
    }
    {
      StoreInst /*P*/ SI = dyn_cast_StoreInst(I);
      if ((SI != null)) {
        return add(SI);
      }
    }
    {
      VAArgInst /*P*/ VAAI = dyn_cast_VAArgInst(I);
      if ((VAAI != null)) {
        return add(VAAI);
      }
    }
    {
      MemSetInst /*P*/ MSI = dyn_cast_MemSetInst(I);
      if ((MSI != null)) {
        return add(MSI);
      }
    }
    return addUnknown(I);
    // FIXME: add support of memcpy and memmove. 
  }
 // Dispatch to one of the other add methods...
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 400,
   FQN="llvm::AliasSetTracker::add", NM="_ZN4llvm15AliasSetTracker3addERNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3addERNS_10BasicBlockE")
  //</editor-fold>
  public void add(final BasicBlock /*&*/ BB) {
    for (final Instruction /*&*/ I : BB)  {
      add($AddrOf(I));
    }
  }
 // Add all instructions in basic block
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 405,
   FQN="llvm::AliasSetTracker::add", NM="_ZN4llvm15AliasSetTracker3addERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3addERKS0_")
  //</editor-fold>
  public void add(final /*const*/ AliasSetTracker /*&*/ AST) {
    assert ($AddrOf(AA) == $AddrOf(AST.AA)) : "Merging AliasSetTracker objects with different Alias Analyses!";
    
    // Loop over all of the alias sets in AST, adding the pointers contained
    // therein into the current alias sets.  This can cause alias sets to be
    // merged together in the current AST.
    for (final /*const*/ AliasSet /*&*/ AS : AST) {
      if ((AS.Forward != null)) {
        continue; // Ignore forwarding alias sets
      }
      
      // If there are any call sites in the alias set, add them to this AST.
      for (/*uint*/int i = 0, e = AS.UnknownInsts.size(); i != e; ++i)  {
        add(AS.UnknownInsts.$at$Const(i).$T$P());
      }
      
      // Loop over all of the pointers in this alias set.
      bool$ref X = create_bool$ref();
      for (AliasSet.iterator ASI = AS.begin(), E = AS.end(); ASI.$noteq(E); ASI.$preInc()) {
        final AliasSet /*&*/ NewAS = addPointer(ASI.getPointer(), ASI.getSize(), 
            ASI.getAAInfo(), 
            AliasSet.AccessLattice.valueOf($2bits_uint2uint(AS.Access)), X);
        if (AS.isVolatile()) {
          NewAS.setVolatile();
        }
      }
    }
  }
 // Add alias relations from another AST
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::addUnknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 369,
   FQN="llvm::AliasSetTracker::addUnknown", NM="_ZN4llvm15AliasSetTracker10addUnknownEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker10addUnknownEPNS_11InstructionE")
  //</editor-fold>
  public boolean addUnknown(Instruction /*P*/ Inst) {
    if (isa_DbgInfoIntrinsic(Inst)) {
      return true; // Ignore DbgInfo Intrinsics.
    }
    if (!Inst.mayReadOrWriteMemory()) {
      return true; // doesn't alias anything
    }
    
    AliasSet /*P*/ AS = findAliasSetForUnknownInst(Inst);
    if ((AS != null)) {
      AS.addUnknownInst(Inst, AA);
      return false;
    }
    AliasSets.push_back(new AliasSet());
    AS = $AddrOf(AliasSets.back());
    AS.addUnknownInst(Inst, AA);
    return true;
  }

  
  /// These methods are used to remove all entries that might be aliased by the
  /// specified instruction. These methods return true if any alias sets were
  /// eliminated.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 462,
   FQN="llvm::AliasSetTracker::remove", NM="_ZN4llvm15AliasSetTracker6removeEPNS_5ValueEyRKNS_9AAMDNodesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker6removeEPNS_5ValueEyRKNS_9AAMDNodesE")
  //</editor-fold>
  public boolean remove(Value /*P*/ Ptr, long/*uint64_t*/ Size, final /*const*/ AAMDNodes /*&*/ AAInfo) {
    AliasSet /*P*/ AS = mergeAliasSetsForPointer(Ptr, Size, AAInfo);
    if (!(AS != null)) {
      return false;
    }
    remove($Deref(AS));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 470,
   FQN="llvm::AliasSetTracker::remove", NM="_ZN4llvm15AliasSetTracker6removeEPNS_8LoadInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker6removeEPNS_8LoadInstE")
  //</editor-fold>
  public boolean remove(LoadInst /*P*/ LI) {
    final /*const*/ DataLayout /*&*/ DL = LI.getModule().getDataLayout();
    long/*uint64_t*/ Size = DL.getTypeStoreSize(LI.getType());
    
    AAMDNodes AAInfo/*J*/= new AAMDNodes();
    LI.getAAMetadata(AAInfo);
    
    AliasSet /*P*/ AS = mergeAliasSetsForPointer(LI.getOperand(0), Size, AAInfo);
    if (!(AS != null)) {
      return false;
    }
    remove($Deref(AS));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 483,
   FQN="llvm::AliasSetTracker::remove", NM="_ZN4llvm15AliasSetTracker6removeEPNS_9StoreInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker6removeEPNS_9StoreInstE")
  //</editor-fold>
  public boolean remove(StoreInst /*P*/ SI) {
    final /*const*/ DataLayout /*&*/ DL = SI.getModule().getDataLayout();
    long/*uint64_t*/ Size = DL.getTypeStoreSize(SI.getOperand(0).getType());
    
    AAMDNodes AAInfo/*J*/= new AAMDNodes();
    SI.getAAMetadata(AAInfo);
    
    AliasSet /*P*/ AS = mergeAliasSetsForPointer(SI.getOperand(1), Size, AAInfo);
    if (!(AS != null)) {
      return false;
    }
    remove($Deref(AS));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 496,
   FQN="llvm::AliasSetTracker::remove", NM="_ZN4llvm15AliasSetTracker6removeEPNS_9VAArgInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker6removeEPNS_9VAArgInstE")
  //</editor-fold>
  public boolean remove(VAArgInst /*P*/ VAAI) {
    AAMDNodes AAInfo/*J*/= new AAMDNodes();
    VAAI.getAAMetadata(AAInfo);
    
    AliasSet /*P*/ AS = mergeAliasSetsForPointer(VAAI.getOperand(0), 
        MemoryLocation.UnknownSize, AAInfo);
    if (!(AS != null)) {
      return false;
    }
    remove($Deref(AS));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 507,
   FQN="llvm::AliasSetTracker::remove", NM="_ZN4llvm15AliasSetTracker6removeEPNS_10MemSetInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker6removeEPNS_10MemSetInstE")
  //</editor-fold>
  public boolean remove(MemSetInst /*P*/ MSI) {
    AAMDNodes AAInfo/*J*/= new AAMDNodes();
    MSI.getAAMetadata(AAInfo);
    long/*uint64_t*/ Len;
    {
      
      ConstantInt /*P*/ C = dyn_cast_ConstantInt(MSI.getLength());
      if ((C != null)) {
        Len = C.getZExtValue();
      } else {
        Len = MemoryLocation.UnknownSize;
      }
    }
    
    AliasSet /*P*/ AS = mergeAliasSetsForPointer(MSI.getRawDest(), Len, AAInfo);
    if (!(AS != null)) {
      return false;
    }
    remove($Deref(AS));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 534,
   FQN="llvm::AliasSetTracker::remove", NM="_ZN4llvm15AliasSetTracker6removeEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker6removeEPNS_11InstructionE")
  //</editor-fold>
  public boolean remove(Instruction /*P*/ I) {
    {
      // Dispatch to one of the other remove methods...
      LoadInst /*P*/ LI = dyn_cast_LoadInst(I);
      if ((LI != null)) {
        return remove(LI);
      }
    }
    {
      StoreInst /*P*/ SI = dyn_cast_StoreInst(I);
      if ((SI != null)) {
        return remove(SI);
      }
    }
    {
      VAArgInst /*P*/ VAAI = dyn_cast_VAArgInst(I);
      if ((VAAI != null)) {
        return remove(VAAI);
      }
    }
    {
      MemSetInst /*P*/ MSI = dyn_cast_MemSetInst(I);
      if ((MSI != null)) {
        return remove(MSI);
      }
    }
    return removeUnknown(I);
    // FIXME: add support of memcpy and memmove. 
  }

  
  /// remove - Remove the specified (potentially non-empty) alias set from the
  /// tracker.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 433,
   FQN="llvm::AliasSetTracker::remove", NM="_ZN4llvm15AliasSetTracker6removeERNS_8AliasSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker6removeERNS_8AliasSetE")
  //</editor-fold>
  public void remove(final AliasSet /*&*/ AS) {
    // Drop all call sites.
    if (!AS.UnknownInsts.empty()) {
      AS.dropRef(/*Deref*/this);
    }
    AS.UnknownInsts.clear();
    
    // Clear the alias set.
    /*uint*/int NumRefs = 0;
    while (!AS.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        AliasSet.PointerRec /*P*/ P = AS.PtrList;
        
        Value /*P*/ ValToRemove = P.getValue();
        
        // Unlink and delete entry from the list of values.
        P.eraseFromList();
        
        // Remember how many references need to be dropped.
        ++NumRefs;
        
        // Finally, remove the entry.
        $c$.clean(PointerMap.erase($c$.track(new ASTCallbackVH(ValToRemove))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Stop using the alias set, removing it.
    AS.RefCount -= NumRefs;
    if (AS.RefCount == 0) {
      AS.removeFromTracker(/*Deref*/this);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::removeUnknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 524,
   FQN="llvm::AliasSetTracker::removeUnknown", NM="_ZN4llvm15AliasSetTracker13removeUnknownEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker13removeUnknownEPNS_11InstructionE")
  //</editor-fold>
  public boolean removeUnknown(Instruction /*P*/ I) {
    if (!I.mayReadOrWriteMemory()) {
      return false; // doesn't alias anything
    }
    
    AliasSet /*P*/ AS = findAliasSetForUnknownInst(I);
    if (!(AS != null)) {
      return false;
    }
    remove($Deref(AS));
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 198,
   FQN="llvm::AliasSetTracker::clear", NM="_ZN4llvm15AliasSetTracker5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker5clearEv")
  //</editor-fold>
  public void clear() {
    // Delete all the PointerRec entries.
    for (DenseMapIterator<ASTCallbackVH, AliasSet.PointerRec /*P*/ > I = PointerMap.begin(), E = PointerMap.end();
         I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
      I.$arrow().second.eraseFromList();
    }
    
    PointerMap.clear();
    
    // The alias sets should all be clear now.
    AliasSets.clear();
  }

  
  /// Return the alias sets that are active.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::getAliasSets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 360,
   FQN="llvm::AliasSetTracker::getAliasSets", NM="_ZNK4llvm15AliasSetTracker12getAliasSetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm15AliasSetTracker12getAliasSetsEv")
  //</editor-fold>
  public /*const*/ ilist<AliasSet> /*&*/ getAliasSets() /*const*/ {
    return AliasSets;
  }

  
  /// Return the alias set that the specified pointer lives in. If the New
  /// argument is non-null, this method sets the value to true if a new alias
  /// set is created to contain the pointer (because the pointer didn't alias
  /// anything).
  
  /// getAliasSetForPointer - Return the alias set that the specified pointer
  /// lives in.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::getAliasSetForPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 269,
   FQN="llvm::AliasSetTracker::getAliasSetForPointer", NM="_ZN4llvm15AliasSetTracker21getAliasSetForPointerEPNS_5ValueEyRKNS_9AAMDNodesEPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker21getAliasSetForPointerEPNS_5ValueEyRKNS_9AAMDNodesEPb")
  //</editor-fold>
  public AliasSet /*&*/ getAliasSetForPointer(Value /*P*/ Pointer, long/*uint64_t*/ Size, 
                       final /*const*/ AAMDNodes /*&*/ AAInfo) {
    return getAliasSetForPointer(Pointer, Size, 
                       AAInfo, 
                       (bool$ptr/*bool P*/ )null);
  }
  public AliasSet /*&*/ getAliasSetForPointer(Value /*P*/ Pointer, long/*uint64_t*/ Size, 
                       final /*const*/ AAMDNodes /*&*/ AAInfo, 
                       bool$ptr/*bool P*/ New/*= null*/) {
    final AliasSet.PointerRec /*&*/ Entry = getEntryFor(Pointer);
    
    // Check to see if the pointer is already known.
    if (Entry.hasAliasSet()) {
      // If the size changed, we may need to merge several alias sets.
      // Note that we can *not* return the result of mergeAliasSetsForPointer
      // due to a quirk of alias analysis behavior. Since alias(undef, undef)
      // is NoAlias, mergeAliasSetsForPointer(undef, ...) will not find the
      // the right set for undef, even if it exists.
      if (Entry.updateSizeAndAAInfo(Size, AAInfo)) {
        mergeAliasSetsForPointer(Pointer, Size, AAInfo);
      }
      // Return the set!
      return $Deref(Entry.getAliasSet(/*Deref*/this).getForwardedTarget(/*Deref*/this));
    }
    {
      
      AliasSet /*P*/ AS = mergeAliasSetsForPointer(Pointer, Size, AAInfo);
      if ((AS != null)) {
        // Add it to the alias set it aliases.
        AS.addPointer(/*Deref*/this, Entry, Size, AAInfo);
        return $Deref(AS);
      }
    }
    if (Native.$bool(New)) {
      New.$set(true);
    }
    // Otherwise create a new alias set to hold the loaded pointer.
    AliasSets.push_back(new AliasSet());
    AliasSets.back().addPointer(/*Deref*/this, Entry, Size, AAInfo);
    return AliasSets.back();
  }

  
  /// Return the alias set containing the location specified if one exists,
  /// otherwise return null.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::getAliasSetForPointerIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 372,
   FQN="llvm::AliasSetTracker::getAliasSetForPointerIfExists", NM="_ZN4llvm15AliasSetTracker29getAliasSetForPointerIfExistsEPKNS_5ValueEyRKNS_9AAMDNodesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker29getAliasSetForPointerIfExistsEPKNS_5ValueEyRKNS_9AAMDNodesE")
  //</editor-fold>
  public AliasSet /*P*/ getAliasSetForPointerIfExists(/*const*/ Value /*P*/ P, long/*uint64_t*/ Size, 
                               final /*const*/ AAMDNodes /*&*/ AAInfo) {
    return mergeAliasSetsForPointer(P, Size, AAInfo);
  }

  
  /// Return true if the specified location is represented by this alias set,
  /// false otherwise. This does not modify the AST object or alias sets.
  
  /// containsPointer - Return true if the specified location is represented by
  /// this alias set, false otherwise.  This does not modify the AST object or
  /// alias sets.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::containsPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 235,
   FQN="llvm::AliasSetTracker::containsPointer", NM="_ZNK4llvm15AliasSetTracker15containsPointerEPKNS_5ValueEyRKNS_9AAMDNodesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm15AliasSetTracker15containsPointerEPKNS_5ValueEyRKNS_9AAMDNodesE")
  //</editor-fold>
  public boolean containsPointer(/*const*/ Value /*P*/ Ptr, long/*uint64_t*/ Size, 
                 final /*const*/ AAMDNodes /*&*/ AAInfo) /*const*/ {
    for (final /*const*/ AliasSet /*&*/ AS : /*Deref*/this)  {
      if (!(AS.Forward != null) && AS.aliasesPointer(Ptr, Size, AAInfo, AA)) {
        return true;
      }
    }
    return false;
  }

  
  /// Return true if the specified instruction "may" (or must) alias one of the
  /// members in any of the sets.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::containsUnknown">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 243,
   FQN="llvm::AliasSetTracker::containsUnknown", NM="_ZNK4llvm15AliasSetTracker15containsUnknownEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm15AliasSetTracker15containsUnknownEPKNS_11InstructionE")
  //</editor-fold>
  public boolean containsUnknown(/*const*/ Instruction /*P*/ Inst) /*const*/ {
    for (final /*const*/ AliasSet /*&*/ AS : /*Deref*/this)  {
      if (!(AS.Forward != null) && AS.aliasesUnknownInst(Inst, AA)) {
        return true;
      }
    }
    return false;
  }

  
  /// Return the underlying alias analysis object used by this tracker.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::getAliasAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 387,
   FQN="llvm::AliasSetTracker::getAliasAnalysis", NM="_ZNK4llvm15AliasSetTracker16getAliasAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm15AliasSetTracker16getAliasAnalysisEv")
  //</editor-fold>
  public AAResults /*&*/ getAliasAnalysis() /*const*/ {
    return AA;
  }

  
  /// This method is used to remove a pointer value from the AliasSetTracker
  /// entirely. It should be used when an instruction is deleted from the
  /// program to update the AST. If you don't use this, you would have dangling
  /// pointers to deleted instructions.
  
  // deleteValue method - This method is used to remove a pointer value from the
  // AliasSetTracker entirely.  It should be used when an instruction is deleted
  // from the program to update the AST.  If you don't use this, you would have
  // dangling pointers to deleted instructions.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::deleteValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 554,
   FQN="llvm::AliasSetTracker::deleteValue", NM="_ZN4llvm15AliasSetTracker11deleteValueEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker11deleteValueEPNS_5ValueE")
  //</editor-fold>
  public void deleteValue(Value /*P*/ PtrVal) {
    {
      // If this is a call instruction, remove the callsite from the appropriate
      // AliasSet (if present).
      Instruction /*P*/ Inst = dyn_cast_Instruction(PtrVal);
      if ((Inst != null)) {
        if (Inst.mayReadOrWriteMemory()) {
          // Scan all the alias sets to see if this call site is contained.
          for (ilist_iterator<AliasSet> I = begin(), E = end(); I.$noteq(E);) {
            ilist_iterator<AliasSet> Cur = I.$postInc(0);
            if (!(Cur.$arrow().Forward != null)) {
              Cur.$arrow().removeUnknownInst(/*Deref*/this, Inst);
            }
          }
        }
      }
    }
    
    // First, look up the PointerRec for this pointer.
    DenseMapIterator<ASTCallbackVH, AliasSet.PointerRec /*P*/ > I = PointerMap.find_as_T$C$R(PtrVal);
    if (I.$eq(/*NO_ITER_COPY*/PointerMap.end())) {
      return; // Noop
    }
    
    // If we found one, remove the pointer from the alias set it is in.
    AliasSet.PointerRec /*P*/ PtrValEnt = I.$arrow().second;
    AliasSet /*P*/ AS = PtrValEnt.getAliasSet(/*Deref*/this);
    
    // Unlink and delete from the list of values.
    PtrValEnt.eraseFromList();
    
    // Stop using the alias set.
    AS.dropRef(/*Deref*/this);
    
    PointerMap.erase(new DenseMapIterator<ASTCallbackVH, AliasSet.PointerRec /*P*/ >(I));
  }

  
  /// This method should be used whenever a preexisting value in the program is
  /// copied or cloned, introducing a new value.  Note that it is ok for clients
  /// that use this method to introduce the same value multiple times: if the
  /// tracker already knows about a value, it will ignore the request.
  
  // copyValue - This method should be used whenever a preexisting value in the
  // program is copied or cloned, introducing a new value.  Note that it is ok for
  // clients that use this method to introduce the same value multiple times: if
  // the tracker already knows about a value, it will ignore the request.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::copyValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 590,
   FQN="llvm::AliasSetTracker::copyValue", NM="_ZN4llvm15AliasSetTracker9copyValueEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker9copyValueEPNS_5ValueES2_")
  //</editor-fold>
  public void copyValue(Value /*P*/ From, Value /*P*/ To) {
    // First, look up the PointerRec for this pointer.
    DenseMapIterator<ASTCallbackVH, AliasSet.PointerRec /*P*/ > I = PointerMap.find_as_T$C$R(From);
    if (I.$eq(/*NO_ITER_COPY*/PointerMap.end())) {
      return; // Noop
    }
    assert (I.$arrow().second.hasAliasSet()) : "Dead entry?";
    
    final AliasSet.PointerRec /*&*/ Entry = getEntryFor(To);
    if (Entry.hasAliasSet()) {
      return; // Already in the tracker!
    }
    
    // Add it to the alias set it aliases...
    I.$assignMove(PointerMap.find_as_T$C$R(From));
    AliasSet /*P*/ AS = I.$arrow().second.getAliasSet(/*Deref*/this);
    AS.addPointer(/*Deref*/this, Entry, I.$arrow().second.getSize(), 
        I.$arrow().second.getAAInfo(), 
        true);
  }

  
  // JAVA: typedef ilist<AliasSet>::iterator iterator
//  public final class iterator extends ilist_iterator<AliasSet>{ };
  // JAVA: typedef ilist<AliasSet>::const_iterator const_iterator
//  public final class const_iterator extends ilist_iterator</*const*/ AliasSet>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 404,
   FQN="llvm::AliasSetTracker::begin", NM="_ZNK4llvm15AliasSetTracker5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm15AliasSetTracker5beginEv")
  //</editor-fold>
  public ilist_iterator</*const*/ AliasSet> begin$Const() /*const*/ {
    return AliasSets.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 405,
   FQN="llvm::AliasSetTracker::end", NM="_ZNK4llvm15AliasSetTracker3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm15AliasSetTracker3endEv")
  //</editor-fold>
  public ilist_iterator</*const*/ AliasSet> end$Const() /*const*/ {
    return AliasSets.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 407,
   FQN="llvm::AliasSetTracker::begin", NM="_ZN4llvm15AliasSetTracker5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker5beginEv")
  //</editor-fold>
  public ilist_iterator<AliasSet> begin() {
    return AliasSets.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 408,
   FQN="llvm::AliasSetTracker::end", NM="_ZN4llvm15AliasSetTracker3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker3endEv")
  //</editor-fold>
  public ilist_iterator<AliasSet> end() {
    return AliasSets.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 647,
   FQN="llvm::AliasSetTracker::print", NM="_ZNK4llvm15AliasSetTracker5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm15AliasSetTracker5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    OS.$out(/*KEEP_STR*/"Alias Set Tracker: ").$out_uint(AliasSets.size()).$out(/*KEEP_STR*/" alias sets for ").$out_uint(
        PointerMap.size()
    ).$out(/*KEEP_STR*/" pointer values.\n");
    for (final /*const*/ AliasSet /*&*/ AS : /*Deref*/this)  {
      AS.print(OS);
    }
    OS.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 657,
   FQN="llvm::AliasSetTracker::dump", NM="_ZNK4llvm15AliasSetTracker4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZNK4llvm15AliasSetTracker4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }

/*private:*/
  /*friend  class AliasSet*/
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::removeAliasSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 83,
   FQN="llvm::AliasSetTracker::removeAliasSet", NM="_ZN4llvm15AliasSetTracker14removeAliasSetEPNS_8AliasSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker14removeAliasSetEPNS_8AliasSetE")
  //</editor-fold>
  /*friend*/public/*private*/ void removeAliasSet(AliasSet /*P*/ AS) {
    {
      AliasSet /*P*/ Fwd = AS.Forward;
      if ((Fwd != null)) {
        Fwd.dropRef(/*Deref*/this);
        AS.Forward = null;
      }
    }
    AliasSets.erase_T$P(AS);
  }

  
  /// Just like operator[] on the map, except that it creates an entry for the
  /// pointer if it doesn't already exist.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::getEntryFor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 419,
   FQN="llvm::AliasSetTracker::getEntryFor", NM="_ZN4llvm15AliasSetTracker11getEntryForEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker11getEntryForEPNS_5ValueE")
  //</editor-fold>
  private AliasSet.PointerRec /*&*/ getEntryFor(Value /*P*/ V) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final type$ref<AliasSet.PointerRec /*P*/ /*&*/> Entry = $c$.clean(PointerMap.ref$at($c$.track(new ASTCallbackVH(V, this))));
      if (!(Entry.$deref() != null)) {
        Entry.$set(new AliasSet.PointerRec(V));
      }
      return $Deref(Entry.$deref());
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::addPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 426,
   FQN="llvm::AliasSetTracker::addPointer", NM="_ZN4llvm15AliasSetTracker10addPointerEPNS_5ValueEyRKNS_9AAMDNodesENS_8AliasSet13AccessLatticeERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker10addPointerEPNS_5ValueEyRKNS_9AAMDNodesENS_8AliasSet13AccessLatticeERb")
  //</editor-fold>
  private AliasSet /*&*/ addPointer(Value /*P*/ P, long/*uint64_t*/ Size, final /*const*/ AAMDNodes /*&*/ AAInfo, 
            AliasSet.AccessLattice E, 
            final bool$ref/*bool &*/ NewSet) {
    NewSet.$set(false);
    final AliasSet /*&*/ AS = getAliasSetForPointer(P, Size, AAInfo, NewSet.deref$ptr());
    AS.Access |= $int2uint_2bits(E.getValue());
    return AS;
  }

  
  /// mergeAliasSetsForPointer - Given a pointer, merge all alias sets that may
  /// alias the pointer. Return the unified set, or nullptr if no set that aliases
  /// the pointer was found.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::mergeAliasSetsForPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 214,
   FQN="llvm::AliasSetTracker::mergeAliasSetsForPointer", NM="_ZN4llvm15AliasSetTracker24mergeAliasSetsForPointerEPKNS_5ValueEyRKNS_9AAMDNodesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker24mergeAliasSetsForPointerEPKNS_5ValueEyRKNS_9AAMDNodesE")
  //</editor-fold>
  private AliasSet /*P*/ mergeAliasSetsForPointer(/*const*/ Value /*P*/ Ptr, 
                          long/*uint64_t*/ Size, 
                          final /*const*/ AAMDNodes /*&*/ AAInfo) {
    AliasSet /*P*/ FoundSet = null;
    for (ilist_iterator<AliasSet> I = begin(), E = end(); I.$noteq(E);) {
      ilist_iterator<AliasSet> Cur = I.$postInc(0);
      if ((Cur.$arrow().Forward != null) || !Cur.$arrow().aliasesPointer(Ptr, Size, AAInfo, AA)) {
        continue;
      }
      if (!(FoundSet != null)) { // If this is the first alias set ptr can go into.
        FoundSet = $AddrOf(Cur.$star()); // Remember it.
      } else { // Otherwise, we must merge the sets.
        FoundSet.mergeSetIn(Cur.$star(), /*Deref*/this); // Merge in contents.
      }
    }
    
    return FoundSet;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSetTracker::findAliasSetForUnknownInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 250,
   FQN="llvm::AliasSetTracker::findAliasSetForUnknownInst", NM="_ZN4llvm15AliasSetTracker26findAliasSetForUnknownInstEPNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm15AliasSetTracker26findAliasSetForUnknownInstEPNS_11InstructionE")
  //</editor-fold>
  private AliasSet /*P*/ findAliasSetForUnknownInst(Instruction /*P*/ Inst) {
    AliasSet /*P*/ FoundSet = null;
    for (ilist_iterator<AliasSet> I = begin(), E = end(); I.$noteq(E);) {
      ilist_iterator<AliasSet> Cur = I.$postInc(0);
      if ((Cur.$arrow().Forward != null) || !Cur.$arrow().aliasesUnknownInst(Inst, AA)) {
        continue;
      }
      if (!(FoundSet != null)) { // If this is the first alias set ptr can go into.
        FoundSet = $AddrOf(Cur.$star()); // Remember it.
      } else if (!(Cur.$arrow().Forward != null)) { // Otherwise, we must merge the sets.
        FoundSet.mergeSetIn(Cur.$star(), /*Deref*/this); // Merge in contents.
      }
    }
    return FoundSet;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Iterator<AliasSet> iterator() {
    return new JavaIterator<>(begin(), end());
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "AA=" + AA // NOI18N
              + ", AliasSets=" + AliasSets // NOI18N
              + ", PointerMap=" + PointerMap; // NOI18N
  }
}
