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

package org.clang.ast.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.impl.VTableBuilderStatics.*;


/// ItaniumVTableBuilder - Class for building vtable layout information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 771,
 FQN="(anonymous namespace)::ItaniumVTableBuilder", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilderE")
//</editor-fold>
public class ItaniumVTableBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  /// PrimaryBasesSetVectorTy - A set vector of direct and indirect 
  /// primary bases.
  /*typedef llvm::SmallSetVector<const CXXRecordDecl *, 8> PrimaryBasesSetVectorTy*/
//  public final class PrimaryBasesSetVectorTy extends SmallSetVector</*const*/ CXXRecordDecl /*P*/ >{ };
  
  /*typedef llvm::DenseMap<const CXXRecordDecl *, CharUnits> VBaseOffsetOffsetsMapTy*/
//  public final class VBaseOffsetOffsetsMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>{ };
  
  /*typedef llvm::DenseMap<BaseSubobject, uint64_t> AddressPointsMapTy*/
//  public final class AddressPointsMapTy extends DenseMapTypeULong<BaseSubobject>{ };
  
  /*typedef llvm::DenseMap<GlobalDecl, int64_t> MethodVTableIndicesTy*/
//  public final class MethodVTableIndicesTy extends DenseMapTypeLong<GlobalDecl>{ };
/*private:*/
  /// VTables - Global vtable information.
  private final ItaniumVTableContext /*&*/ VTables;
  
  /// MostDerivedClass - The most derived class for which we're building this
  /// vtable.
  private /*const*/ CXXRecordDecl /*P*/ MostDerivedClass;
  
  /// MostDerivedClassOffset - If we're building a construction vtable, this
  /// holds the offset from the layout class to the most derived class.
  private /*const*/ CharUnits MostDerivedClassOffset;
  
  /// MostDerivedClassIsVirtual - Whether the most derived class is a virtual 
  /// base. (This only makes sense when building a construction vtable).
  private boolean MostDerivedClassIsVirtual;
  
  /// LayoutClass - The class we're using for layout information. Will be 
  /// different than the most derived class if we're building a construction
  /// vtable.
  private /*const*/ CXXRecordDecl /*P*/ LayoutClass;
  
  /// Context - The ASTContext which we will use for layout information.
  private final ASTContext /*&*/ Context;
  
  /// FinalOverriders - The final overriders of the most derived class.
  private /*const*/ FinalOverriders Overriders;
  
  /// VCallOffsetsForVBases - Keeps track of vcall offsets for the virtual
  /// bases in this vtable.
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , VCallOffsetMap> VCallOffsetsForVBases;
  
  /// VBaseOffsetOffsets - Contains the offsets of the virtual base offsets for
  /// the most derived class.
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> VBaseOffsetOffsets;
  
  /// Components - The components of the vtable being built.
  private SmallVector<VTableComponent> Components;
  
  /// AddressPoints - Address points for the vtable being built.
  private DenseMapTypeULong<BaseSubobject> AddressPoints;

  /// MethodInfo - Contains information about a method in a vtable.
  /// (Used for computing 'this' pointer adjustment thunks.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 829,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoE")
  //</editor-fold>
  private static class/*struct*/ MethodInfo {
    /// BaseOffset - The base offset of this method.
    public /*const*/ CharUnits BaseOffset;
    
    /// BaseOffsetInLayoutClass - The base offset in the layout class of this
    /// method.
    public /*const*/ CharUnits BaseOffsetInLayoutClass;
    
    /// VTableIndex - The index in the vtable that this method has.
    /// (For destructors, this is the index of the complete destructor).
    public /*const*/long/*uint64_t*/ VTableIndex;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo::MethodInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 841,
     FQN="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo::MethodInfo", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoC1EN5clang9CharUnitsES3_y",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoC1EN5clang9CharUnitsES3_y")
    //</editor-fold>
    public MethodInfo(CharUnits BaseOffset, CharUnits BaseOffsetInLayoutClass, 
        long/*uint64_t*/ VTableIndex) {
      // : BaseOffset(BaseOffset), BaseOffsetInLayoutClass(BaseOffsetInLayoutClass), VTableIndex(VTableIndex) 
      //START JInit
      this.BaseOffset = new CharUnits(BaseOffset);
      this.BaseOffsetInLayoutClass = new CharUnits(BaseOffsetInLayoutClass);
      this.VTableIndex = VTableIndex;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo::MethodInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 847,
     FQN="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo::MethodInfo", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoC1Ev")
    //</editor-fold>
    public MethodInfo() {
      // : BaseOffset(CharUnits::Zero()), BaseOffsetInLayoutClass(CharUnits::Zero()), VTableIndex(0) 
      //START JInit
      this.BaseOffset = CharUnits.Zero();
      this.BaseOffsetInLayoutClass = CharUnits.Zero();
      this.VTableIndex = $int2ulong(0);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo::MethodInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 829,
     FQN="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo::MethodInfo", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ MethodInfo(JD$Move _dparam, final MethodInfo /*&&*/$Prm0) {
      // : BaseOffset(static_cast<MethodInfo &&>().BaseOffset), BaseOffsetInLayoutClass(static_cast<MethodInfo &&>().BaseOffsetInLayoutClass), VTableIndex(static_cast<MethodInfo &&>().VTableIndex) 
      //START JInit
      this.BaseOffset = new CharUnits($Prm0.BaseOffset);
      this.BaseOffsetInLayoutClass = new CharUnits($Prm0.BaseOffsetInLayoutClass);
      this.VTableIndex = $Prm0.VTableIndex;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo::MethodInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 829,
     FQN="(anonymous namespace)::ItaniumVTableBuilder::MethodInfo::MethodInfo", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder10MethodInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ MethodInfo(final /*const*/ MethodInfo /*&*/ $Prm0) {
      // : BaseOffset(.BaseOffset), BaseOffsetInLayoutClass(.BaseOffsetInLayoutClass), VTableIndex(.VTableIndex) 
      //START JInit
      this.BaseOffset = new CharUnits($Prm0.BaseOffset);
      this.BaseOffsetInLayoutClass = new CharUnits($Prm0.BaseOffsetInLayoutClass);
      this.VTableIndex = $Prm0.VTableIndex;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "BaseOffset=" + BaseOffset // NOI18N
                + ", BaseOffsetInLayoutClass=" + BaseOffsetInLayoutClass // NOI18N
                + ", VTableIndex=" + VTableIndex; // NOI18N
    }
  };
  
  /*typedef llvm::DenseMap<const CXXMethodDecl *, MethodInfo> MethodInfoMapTy*/
//  public final class MethodInfoMapTy extends DenseMap</*const*/ CXXMethodDecl /*P*/ , MethodInfo>{ };
  
  /// MethodInfoMap - The information for all methods in the vtable we're
  /// currently building.
  private DenseMap</*const*/ CXXMethodDecl /*P*/ , MethodInfo> MethodInfoMap;
  
  /// MethodVTableIndices - Contains the index (relative to the vtable address
  /// point) where the function pointer for a virtual function is stored.
  private DenseMapTypeLong<GlobalDecl> MethodVTableIndices;
  
  /*typedef llvm::DenseMap<uint64_t, ThunkInfo> VTableThunksMapTy*/
//  public final class VTableThunksMapTy extends DenseMapULongType<ThunkInfo>{ };
  
  /// VTableThunks - The thunks by vtable index in the vtable currently being 
  /// built.
  private DenseMapULongType<ThunkInfo> VTableThunks;
  
  /*typedef SmallVector<ThunkInfo, 1> ThunkInfoVectorTy*/
//  public final class ThunkInfoVectorTy extends SmallVector<ThunkInfo>{ };
  /*typedef llvm::DenseMap<const CXXMethodDecl *, ThunkInfoVectorTy> ThunksMapTy*/
//  public final class ThunksMapTy extends DenseMap</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>>{ };
  
  /// Thunks - A map that contains all the thunks needed for all methods in the
  /// most derived class for which the vtable is currently being built.
  private DenseMap</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>> Thunks;
  
  /// AddThunk - Add a thunk for the given method.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::AddThunk">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*!=*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1065,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::AddThunk", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder8AddThunkEPKN5clang13CXXMethodDeclERKNS1_9ThunkInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder8AddThunkEPKN5clang13CXXMethodDeclERKNS1_9ThunkInfoE")
  //</editor-fold>
  private void AddThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
          final /*const*/ ThunkInfo /*&*/ Thunk) {
    assert (!isBuildingConstructorVTable()) : "Can't add thunks for construction vtable";
    
    final SmallVectorImpl<ThunkInfo> /*&*/ ThunksVector = Thunks.$at_T1$C$R(MD);
    
    // Check if we have this thunk already.
    if (std.find(ThunksVector.begin(), ThunksVector.end(), Thunk)
            .$noteq(ThunksVector.end())) {
      return;
    }
    
    ThunksVector.push_back(Thunk);
  }

  
  /// ComputeThisAdjustments - Compute the 'this' pointer adjustments for the
  /// part of the vtable we're currently building.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::ComputeThisAdjustments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1112,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::ComputeThisAdjustments", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder22ComputeThisAdjustmentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder22ComputeThisAdjustmentsEv")
  //</editor-fold>
  private void ComputeThisAdjustments() {
    // Now go through the method info map and see if any of the methods need
    // 'this' pointer adjustments.
    for (final /*const*/std.pair</*const*/ CXXMethodDecl /*P*/ , MethodInfo> /*&*/ MI : MethodInfoMap) {
      /*const*/ CXXMethodDecl /*P*/ MD = MI.first;
      final /*const*/ MethodInfo /*&*/ $MethodInfo = MI.second;
      
      // Ignore adjustments for unused function pointers.
      long/*uint64_t*/ VTableIndex = $MethodInfo.VTableIndex;
      if (Components.$at($ulong2uint(VTableIndex)).getKind()
         == VTableComponent.Kind.CK_UnusedFunctionPointer) {
        continue;
      }
      
      // Get the final overrider for this method.
      FinalOverriders.OverriderInfo Overrider = Overriders.getOverrider(MD, new CharUnits($MethodInfo.BaseOffset));
      
      // Check if we need an adjustment at all.
      if ($MethodInfo.BaseOffsetInLayoutClass.$eq(Overrider.Offset)) {
        // When a return thunk is needed by a derived class that overrides a
        // virtual base, gcc uses a virtual 'this' adjustment as well. 
        // While the thunk itself might be needed by vtables in subclasses or
        // in construction vtables, there doesn't seem to be a reason for using
        // the thunk in this vtable. Still, we do so to match gcc.
        if (VTableThunks.lookup(VTableIndex).Return.isEmpty()) {
          continue;
        }
      }
      
      ThisAdjustment $ThisAdjustment = ComputeThisAdjustment(MD, new CharUnits($MethodInfo.BaseOffsetInLayoutClass), new FinalOverriders.OverriderInfo(Overrider));
      if ($ThisAdjustment.isEmpty()) {
        continue;
      }
      
      // Add it.
      VTableThunks.$at_T1$C$R(VTableIndex).This.$assign($ThisAdjustment);
      if (isa_CXXDestructorDecl(MD)) {
        // Add an adjustment for the deleting destructor as well.
        VTableThunks.$at_T1$RR(VTableIndex + $int2ullong(1)).This.$assign($ThisAdjustment);
      }
    }
    
    /// Clear the method info map.
    MethodInfoMap.clear();
    if (isBuildingConstructorVTable()) {
      // We don't need to store thunk information for construction vtables.
      return;
    }
    
    for (final /*const*/std.pairULongType<ThunkInfo> /*&*/ TI : VTableThunks) {
      final /*const*/ VTableComponent /*&*/ Component = Components.$at($ullong2uint(TI.first));
      final /*const*/ ThunkInfo /*&*/ Thunk = TI.second;
      /*const*/ CXXMethodDecl /*P*/ MD;
      switch (Component.getKind()) {
       default:
        throw new llvm_unreachable("Unexpected vtable component kind!");
       case CK_FunctionPointer:
        MD = Component.getFunctionDecl();
        break;
       case CK_CompleteDtorPointer:
        MD = Component.getDestructorDecl();
        break;
       case CK_DeletingDtorPointer:
        // We've already added the thunk when we saw the complete dtor pointer.
        continue;
      }
      if (MD.getParent$Const() == MostDerivedClass) {
        AddThunk(MD, Thunk);
      }
    }
  }

  
  /*typedef llvm::SmallPtrSet<const CXXRecordDecl *, 4> VisitedVirtualBasesSetTy*/
//  public final class VisitedVirtualBasesSetTy extends SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >{ };
  
  /// PrimaryVirtualBases - All known virtual bases who are a primary base of
  /// some other base.
  private SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > PrimaryVirtualBases;
  
  /// ComputeReturnAdjustment - Compute the return adjustment given a return
  /// adjustment base offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::ComputeReturnAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1187,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::ComputeReturnAdjustment", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder23ComputeReturnAdjustmentENS_10BaseOffsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder23ComputeReturnAdjustmentENS_10BaseOffsetE")
  //</editor-fold>
  private ReturnAdjustment ComputeReturnAdjustment(BaseOffset Offset) {
    ReturnAdjustment Adjustment/*J*/= new ReturnAdjustment();
    if (!Offset.isEmpty()) {
      if ((Offset.VirtualBase != null)) {
        // Get the virtual base offset offset.
        if (Offset.DerivedClass == MostDerivedClass) {
          // We can get the offset offset directly from our map.
          Adjustment.Virtual.Itanium.VBaseOffsetOffset
             = VBaseOffsetOffsets.lookup(Offset.VirtualBase).getQuantity();
        } else {
          Adjustment.Virtual.Itanium.VBaseOffsetOffset
             = VTables.getVirtualBaseOffsetOffset(Offset.DerivedClass, 
              Offset.VirtualBase).getQuantity();
        }
      }
      
      Adjustment.NonVirtual = Offset.NonVirtualOffset.getQuantity();
    }
    
    return Adjustment;
  }

  
  /// ComputeThisAdjustmentBaseOffset - Compute the base offset for adjusting
  /// the 'this' pointer from the base subobject to the derived subobject.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::ComputeThisAdjustmentBaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1211,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::ComputeThisAdjustmentBaseOffset", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder31ComputeThisAdjustmentBaseOffsetEN5clang13BaseSubobjectES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder31ComputeThisAdjustmentBaseOffsetEN5clang13BaseSubobjectES2_")
  //</editor-fold>
  private BaseOffset ComputeThisAdjustmentBaseOffset(BaseSubobject Base, BaseSubobject Derived) /*const*/ {
    CXXBasePaths Paths = null;
    try {
      /*const*/ CXXRecordDecl /*P*/ BaseRD = Base.getBase();
      /*const*/ CXXRecordDecl /*P*/ DerivedRD = Derived.getBase();
      
      Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, 
          /*RecordPaths=*/ true, /*DetectVirtual=*/ true);
      if (!DerivedRD.isDerivedFrom(BaseRD, Paths)) {
        throw new llvm_unreachable("Class must be derived from the passed in base class!");
      }
      
      // We have to go through all the paths, and see which one leads us to the
      // right base subobject.
      for (final /*const*/ CXXBasePath /*&*/ Path : Paths) {
        BaseOffset Offset = ComputeBaseOffset(Context, DerivedRD, Path);
        
        CharUnits OffsetToBaseSubobject = new CharUnits(Offset.NonVirtualOffset);
        if ((Offset.VirtualBase != null)) {
          // If we have a virtual base class, the non-virtual offset is relative
          // to the virtual base class offset.
          final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
          
          /// Get the virtual base offset, relative to the most derived class 
          /// layout.
          OffsetToBaseSubobject.$addassign(
              LayoutClassLayout.getVBaseClassOffset(Offset.VirtualBase)
          );
        } else {
          // Otherwise, the non-virtual offset is relative to the derived class 
          // offset.
          OffsetToBaseSubobject.$addassign(Derived.getBaseOffset());
        }
        
        // Check if this path gives us the right base subobject.
        if (OffsetToBaseSubobject.$eq(Base.getBaseOffset())) {
          // Since we're going from the base class _to_ the derived class, we'll
          // invert the non-virtual offset here.
          Offset.NonVirtualOffset.$assignMove(Offset.NonVirtualOffset.$sub());
          return Offset;
        }
      }
      
      return new BaseOffset();
    } finally {
      if (Paths != null) { Paths.$destroy(); }
    }
  }

  
  /// ComputeThisAdjustment - Compute the 'this' pointer adjustment for the
  /// given virtual member function, its offset in the layout class and its
  /// final overrider.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::ComputeThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1257,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::ComputeThisAdjustment", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder21ComputeThisAdjustmentEPKN5clang13CXXMethodDeclENS1_9CharUnitsENS_15FinalOverriders13OverriderInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder21ComputeThisAdjustmentEPKN5clang13CXXMethodDeclENS1_9CharUnitsENS_15FinalOverriders13OverriderInfoE")
  //</editor-fold>
  private ThisAdjustment ComputeThisAdjustment(/*const*/ CXXMethodDecl /*P*/ MD, CharUnits BaseOffsetInLayoutClass, 
                       FinalOverriders.OverriderInfo Overrider) {
    // Ignore adjustments for pure virtual member functions.
    if (Overrider.Method.isPure()) {
      return new ThisAdjustment();
    }
    
    BaseSubobject OverriddenBaseSubobject/*J*/= new BaseSubobject(MD.getParent$Const(), 
        new CharUnits(BaseOffsetInLayoutClass));
    
    BaseSubobject OverriderBaseSubobject/*J*/= new BaseSubobject(Overrider.Method.getParent$Const(), 
        new CharUnits(Overrider.Offset));
    
    // Compute the adjustment offset.
    BaseOffset Offset = ComputeThisAdjustmentBaseOffset(new BaseSubobject(OverriddenBaseSubobject), 
        new BaseSubobject(OverriderBaseSubobject));
    if (Offset.isEmpty()) {
      return new ThisAdjustment();
    }
    
    ThisAdjustment Adjustment/*J*/= new ThisAdjustment();
    if ((Offset.VirtualBase != null)) {
      // Get the vcall offset map for this virtual base.
      final VCallOffsetMap /*&*/ VCallOffsets = VCallOffsetsForVBases.$at_T1$C$R(Offset.VirtualBase);
      if (VCallOffsets.empty()) {
        VCallAndVBaseOffsetBuilder Builder = null;
        try {
          // We don't have vcall offsets for this virtual base, go ahead and
          // build them.
          Builder/*J*/= new VCallAndVBaseOffsetBuilder(MostDerivedClass, MostDerivedClass, 
              /*FinalOverriders=*/ (/*const*/ FinalOverriders /*P*/ )null, 
              new BaseSubobject(Offset.VirtualBase, 
                  CharUnits.Zero()), 
              /*BaseIsVirtual=*/ true, 
              /*OffsetInLayoutClass=*/
              CharUnits.Zero());
          
          VCallOffsets.$assign(Builder.getVCallOffsets());
        } finally {
          if (Builder != null) { Builder.$destroy(); }
        }
      }
      
      Adjustment.Virtual.Itanium.VCallOffsetOffset
         = VCallOffsets.getVCallOffsetOffset(MD).getQuantity();
    }
    
    // Set the non-virtual part of the adjustment.
    Adjustment.NonVirtual = Offset.NonVirtualOffset.getQuantity();
    
    return Adjustment;
  }

  
  /// AddMethod - Add a single virtual member function to the vtable
  /// components vector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::AddMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1306,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::AddMethod", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder9AddMethodEPKN5clang13CXXMethodDeclENS1_16ReturnAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder9AddMethodEPKN5clang13CXXMethodDeclENS1_16ReturnAdjustmentE")
  //</editor-fold>
  private void AddMethod(/*const*/ CXXMethodDecl /*P*/ MD, 
           ReturnAdjustment $ReturnAdjustment) {
    {
      /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
      if ((DD != null)) {
        assert ($ReturnAdjustment.isEmpty()) : "Destructor can't have return adjustment!";
        
        // Add both the complete destructor and the deleting destructor.
        Components.push_back(VTableComponent.MakeCompleteDtor(DD));
        Components.push_back(VTableComponent.MakeDeletingDtor(DD));
      } else {
        // Add the return adjustment if necessary.
        if (!$ReturnAdjustment.isEmpty()) {
          VTableThunks.$at_T1$RR($uint2ullong(Components.size())).Return.$assign($ReturnAdjustment);
        }
        
        // Add the function.
        Components.push_back(VTableComponent.MakeFunction(MD));
      }
    }
  }

  
  /// IsOverriderUsed - Returns whether the overrider will ever be used in this
  /// part of the vtable. 
  ///
  /// Itanium C++ ABI 2.5.2:
  ///
  ///   struct A { virtual void f(); };
  ///   struct B : virtual public A { int i; };
  ///   struct C : virtual public A { int j; };
  ///   struct D : public B, public C {};
  ///
  ///   When B and C are declared, A is a primary base in each case, so although
  ///   vcall offsets are allocated in the A-in-B and A-in-C vtables, no this
  ///   adjustment is required and no thunk is generated. However, inside D
  ///   objects, A is no longer a primary base of C, so if we allowed calls to
  ///   C::f() to use the copy of A's vtable in the C subobject, we would need
  ///   to adjust this from C* to B::A*, which would require a third-party 
  ///   thunk. Since we require that a call to C::f() first convert to A*, 
  ///   C-in-D's copy of A's vtable is never referenced, so this is not 
  ///   necessary.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::IsOverriderUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1354,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::IsOverriderUsed", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder15IsOverriderUsedEPKN5clang13CXXMethodDeclENS1_9CharUnitsEPKNS1_13CXXRecordDeclES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder15IsOverriderUsedEPKN5clang13CXXMethodDeclENS1_9CharUnitsEPKNS1_13CXXRecordDeclES5_")
  //</editor-fold>
  private boolean IsOverriderUsed(/*const*/ CXXMethodDecl /*P*/ Overrider, CharUnits BaseOffsetInLayoutClass, 
                 /*const*/ CXXRecordDecl /*P*/ FirstBaseInPrimaryBaseChain, 
                 CharUnits FirstBaseOffsetInLayoutClass) /*const*/ {
    // If the base and the first base in the primary base chain have the same
    // offsets, then this overrider will be used.
    if (BaseOffsetInLayoutClass.$eq(FirstBaseOffsetInLayoutClass)) {
      return true;
    }
    
    // We know now that Base (or a direct or indirect base of it) is a primary
    // base in part of the class hierarchy, but not a primary base in the most 
    // derived class.
    
    // If the overrider is the first base in the primary base chain, we know
    // that the overrider will be used.
    if (Overrider.getParent$Const() == FirstBaseInPrimaryBaseChain) {
      return true;
    }
    
    SmallSetVector</*const*/ CXXRecordDecl /*P*/ > PrimaryBases/*J*/= new SmallSetVector</*const*/ CXXRecordDecl /*P*/ >(8, (/*const*/ CXXRecordDecl /*P*/ ) null);
    
    /*const*/ CXXRecordDecl /*P*/ RD = FirstBaseInPrimaryBaseChain;
    PrimaryBases.insert(RD);
    
    // Now traverse the base chain, starting with the first base, until we find
    // the base that is no longer a primary base.
    while (true) {
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
      /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
      if (!(PrimaryBase != null)) {
        break;
      }
      if (Layout.isPrimaryBaseVirtual()) {
        assert (Layout.getVBaseClassOffset(PrimaryBase).isZero()) : "Primary base should always be at offset 0!";
        
        final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
        
        // Now check if this is the primary base that is not a primary base in the
        // most derived class.
        if (LayoutClassLayout.getVBaseClassOffset(PrimaryBase).$noteq(
            FirstBaseOffsetInLayoutClass
        )) {
          // We found it, stop walking the chain.
          break;
        }
      } else {
        assert (Layout.getBaseClassOffset(PrimaryBase).isZero()) : "Primary base should always be at offset 0!";
      }
      if (!PrimaryBases.insert(PrimaryBase)) {
        throw new llvm_unreachable("Found a duplicate primary base!");
      }
      
      RD = PrimaryBase;
    }
    
    // If the final overrider is an override of one of the primary bases,
    // then we know that it will be used.
    return OverridesIndirectMethodInBases(Overrider, PrimaryBases);
  }

  
  /// AddMethods - Add the methods of this base subobject and all its
  /// primary bases to the vtable components vector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::AddMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1440,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::AddMethods", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder10AddMethodsEN5clang13BaseSubobjectENS1_9CharUnitsEPKNS1_13CXXRecordDeclES3_RN4llvm14SmallSetVectorIS6_Lj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder10AddMethodsEN5clang13BaseSubobjectENS1_9CharUnitsEPKNS1_13CXXRecordDeclES3_RN4llvm14SmallSetVectorIS6_Lj8EEE")
  //</editor-fold>
  private void AddMethods(BaseSubobject Base, CharUnits BaseOffsetInLayoutClass, 
            /*const*/ CXXRecordDecl /*P*/ FirstBaseInPrimaryBaseChain, 
            CharUnits FirstBaseOffsetInLayoutClass, 
            final SmallSetVector</*const*/ CXXRecordDecl /*P*/ > /*&*/ PrimaryBases) {
    // Itanium C++ ABI 2.5.2:
    //   The order of the virtual function pointers in a virtual table is the
    //   order of declaration of the corresponding member functions in the class.
    //
    //   There is an entry for any virtual function declared in a class,
    //   whether it is a new function or overrides a base class function,
    //   unless it overrides a function from the primary base, and conversion
    //   between their return types does not require an adjustment.
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    {
      
      /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
      if ((PrimaryBase != null)) {
        CharUnits PrimaryBaseOffset/*J*/= new CharUnits();
        CharUnits PrimaryBaseOffsetInLayoutClass/*J*/= new CharUnits();
        if (Layout.isPrimaryBaseVirtual()) {
          assert (Layout.getVBaseClassOffset(PrimaryBase).isZero()) : "Primary vbase should have a zero offset!";
          
          final /*const*/ ASTRecordLayout /*&*/ MostDerivedClassLayout = Context.getASTRecordLayout(MostDerivedClass);
          
          PrimaryBaseOffset.$assignMove(
              MostDerivedClassLayout.getVBaseClassOffset(PrimaryBase)
          );
          
          final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
          
          PrimaryBaseOffsetInLayoutClass.$assignMove(
              LayoutClassLayout.getVBaseClassOffset(PrimaryBase)
          );
        } else {
          assert (Layout.getBaseClassOffset(PrimaryBase).isZero()) : "Primary base should have a zero offset!";
          
          PrimaryBaseOffset.$assignMove(Base.getBaseOffset());
          PrimaryBaseOffsetInLayoutClass.$assign(BaseOffsetInLayoutClass);
        }
        
        AddMethods(new BaseSubobject(PrimaryBase, new CharUnits(PrimaryBaseOffset)), 
            new CharUnits(PrimaryBaseOffsetInLayoutClass), FirstBaseInPrimaryBaseChain, 
            new CharUnits(FirstBaseOffsetInLayoutClass), PrimaryBases);
        if (!PrimaryBases.insert(PrimaryBase)) {
          throw new llvm_unreachable("Found a duplicate primary base!");
        }
      }
    }
    
    /*const*/ CXXDestructorDecl /*P*/ ImplicitVirtualDtor = null;
    
    /*typedef llvm::SmallVector<const CXXMethodDecl *, 8> NewVirtualFunctionsTy*/
//    final class NewVirtualFunctionsTy extends SmallVector</*const*/ CXXMethodDecl /*P*/ >{ };
    SmallVector</*const*/ CXXMethodDecl /*P*/ > NewVirtualFunctions/*J*/= new SmallVector</*const*/ CXXMethodDecl /*P*/ >(8, (/*const*/ CXXMethodDecl /*P*/ )null);
    
    // Now go through all virtual member functions and add them.
    for (/*const*/ CXXMethodDecl /*P*/ MD : RD.methods()) {
      if (!MD.isVirtual()) {
        continue;
      }
      MD = MD.getCanonicalDecl$Const();
      
      // Get the final overrider.
      FinalOverriders.OverriderInfo Overrider = Overriders.getOverrider(MD, Base.getBaseOffset());
      {
        
        // Check if this virtual member function overrides a method in a primary
        // base. If this is the case, and the return type doesn't require adjustment
        // then we can just use the member function from the primary base.
        /*const*/ CXXMethodDecl /*P*/ OverriddenMD = FindNearestOverriddenMethod(MD, PrimaryBases);
        if ((OverriddenMD != null)) {
          if (ComputeReturnAdjustmentBaseOffset(Context, MD, 
              OverriddenMD).isEmpty()) {
            // Replace the method info of the overridden method with our own
            // method.
            assert ((MethodInfoMap.count(OverriddenMD) != 0)) : "Did not find the overridden method!";
            final MethodInfo /*&*/ OverriddenMethodInfo = MethodInfoMap.$at_T1$C$R(OverriddenMD);
            
            MethodInfo $MethodInfo/*J*/= new MethodInfo(Base.getBaseOffset(), new CharUnits(BaseOffsetInLayoutClass), 
                OverriddenMethodInfo.VTableIndex);
            assert (!(MethodInfoMap.count(MD) != 0)) : "Should not have method info for this method yet!";
            
            MethodInfoMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(MD, $MethodInfo));
            MethodInfoMap.erase(OverriddenMD);
            
            // If the overridden method exists in a virtual base class or a direct
            // or indirect base class of a virtual base class, we need to emit a
            // thunk if we ever have a class hierarchy where the base class is not
            // a primary base in the complete object.
            if (!isBuildingConstructorVTable() && OverriddenMD != MD) {
              // Compute the this adjustment.
              ThisAdjustment $ThisAdjustment = ComputeThisAdjustment(OverriddenMD, new CharUnits(BaseOffsetInLayoutClass), 
                  new FinalOverriders.OverriderInfo(Overrider));
              if (($ThisAdjustment.Virtual.Itanium.VCallOffsetOffset != 0)
                 && Overrider.Method.getParent$Const() == MostDerivedClass) {
                
                // There's no return adjustment from OverriddenMD and MD,
                // but that doesn't mean there isn't one between MD and
                // the final overrider.
                BaseOffset ReturnAdjustmentOffset = ComputeReturnAdjustmentBaseOffset(Context, Overrider.Method, MD);
                ReturnAdjustment $ReturnAdjustment = ComputeReturnAdjustment(new BaseOffset(ReturnAdjustmentOffset));
                
                // This is a virtual thunk for the most derived class, add it.
                AddThunk(Overrider.Method, 
                    new ThunkInfo($ThisAdjustment, $ReturnAdjustment));
              }
            }
            
            continue;
          }
        }
      }
      {
        
        /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
        if ((DD != null)) {
          if (MD.isImplicit()) {
            // Itanium C++ ABI 2.5.2:
            //   If a class has an implicitly-defined virtual destructor,
            //   its entries come after the declared virtual function pointers.
            assert (!(ImplicitVirtualDtor != null)) : "Did already see an implicit virtual dtor!";
            ImplicitVirtualDtor = DD;
            continue;
          }
        }
      }
      
      NewVirtualFunctions.push_back(MD);
    }
    if ((ImplicitVirtualDtor != null)) {
      NewVirtualFunctions.push_back(ImplicitVirtualDtor);
    }
    
    for (/*const*/ CXXMethodDecl /*P*/ MD : NewVirtualFunctions) {
      // Get the final overrider.
      FinalOverriders.OverriderInfo Overrider = Overriders.getOverrider(MD, Base.getBaseOffset());
      
      // Insert the method info for this method.
      MethodInfo $MethodInfo/*J*/= new MethodInfo(Base.getBaseOffset(), new CharUnits(BaseOffsetInLayoutClass), 
          $uint2ulong(Components.size()));
      assert (!(MethodInfoMap.count(MD) != 0)) : "Should not have method info for this method yet!";
      MethodInfoMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(MD, $MethodInfo));
      
      // Check if this overrider is going to be used.
      /*const*/ CXXMethodDecl /*P*/ OverriderMD = Overrider.Method;
      if (!IsOverriderUsed(OverriderMD, new CharUnits(BaseOffsetInLayoutClass), 
          FirstBaseInPrimaryBaseChain, 
          new CharUnits(FirstBaseOffsetInLayoutClass))) {
        Components.push_back(VTableComponent.MakeUnusedFunction(OverriderMD));
        continue;
      }
      
      // Check if this overrider needs a return adjustment.
      // We don't want to do this for pure virtual member functions.
      BaseOffset ReturnAdjustmentOffset/*J*/= new BaseOffset();
      if (!OverriderMD.isPure()) {
        ReturnAdjustmentOffset.$assignMove(
            ComputeReturnAdjustmentBaseOffset(Context, OverriderMD, MD)
        );
      }
      
      ReturnAdjustment $ReturnAdjustment = ComputeReturnAdjustment(new BaseOffset(ReturnAdjustmentOffset));
      
      AddMethod(Overrider.Method, new ReturnAdjustment($ReturnAdjustment));
    }
  }

  
  // LayoutVTable - Layout the vtable for the given base class, including its
  // secondary vtables and any vtables for virtual bases.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::LayoutVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1615,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::LayoutVTable", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder12LayoutVTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder12LayoutVTableEv")
  //</editor-fold>
  private void LayoutVTable() {
    LayoutPrimaryAndSecondaryVTables(new BaseSubobject(MostDerivedClass, 
            CharUnits.Zero()), 
        /*BaseIsMorallyVirtual=*/ false, 
        MostDerivedClassIsVirtual, 
        new CharUnits(MostDerivedClassOffset));
    
    SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VBases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    
    // Determine the primary virtual bases.
    DeterminePrimaryVirtualBases(MostDerivedClass, new CharUnits(MostDerivedClassOffset), 
        VBases);
    VBases.clear();
    
    LayoutVTablesForVirtualBases(MostDerivedClass, VBases);
    
    // -fapple-kext adds an extra entry at end of vtbl.
    boolean IsAppleKext = Context.getLangOpts().AppleKext;
    if (IsAppleKext) {
      Components.push_back(VTableComponent.MakeVCallOffset(CharUnits.Zero()));
    }
  }

  
  /// LayoutPrimaryAndSecondaryVTables - Layout the primary vtable for the
  /// given base subobject, as well as all its secondary vtables.
  ///
  /// \param BaseIsMorallyVirtual whether the base subobject is a virtual base
  /// or a direct or indirect base of a virtual base.
  ///
  /// \param BaseIsVirtualInLayoutClass - Whether the base subobject is virtual
  /// in the layout class. 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::LayoutPrimaryAndSecondaryVTables">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1637,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::LayoutPrimaryAndSecondaryVTables", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder32LayoutPrimaryAndSecondaryVTablesEN5clang13BaseSubobjectEbbNS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder32LayoutPrimaryAndSecondaryVTablesEN5clang13BaseSubobjectEbbNS1_9CharUnitsE")
  //</editor-fold>
  private void LayoutPrimaryAndSecondaryVTables(BaseSubobject Base, boolean BaseIsMorallyVirtual, 
                                  boolean BaseIsVirtualInLayoutClass, CharUnits OffsetInLayoutClass) {
    VCallAndVBaseOffsetBuilder Builder = null;
    try {
      assert (Base.getBase().isDynamicClass()) : "class does not have a vtable!";
      
      // Add vcall and vbase offsets for this vtable.
      Builder/*J*/= new VCallAndVBaseOffsetBuilder(MostDerivedClass, LayoutClass, $AddrOf(Overriders), 
          new BaseSubobject(Base), BaseIsVirtualInLayoutClass, 
          new CharUnits(OffsetInLayoutClass));
      Components.append_T(Builder.components_begin(), Builder.components_end());
      
      // Check if we need to add these vcall offsets.
      if (BaseIsVirtualInLayoutClass && !Builder.getVCallOffsets().empty()) {
        final VCallOffsetMap /*&*/ VCallOffsets = VCallOffsetsForVBases.$at_T1$RR(Base.getBase());
        if (VCallOffsets.empty()) {
          VCallOffsets.$assign(Builder.getVCallOffsets());
        }
      }
      
      // If we're laying out the most derived class we want to keep track of the
      // virtual base class offset offsets.
      if (Base.getBase() == MostDerivedClass) {
        VBaseOffsetOffsets.$assign(Builder.getVBaseOffsetOffsets());
      }
      
      // Add the offset to top.
      CharUnits OffsetToTop = MostDerivedClassOffset.$sub(OffsetInLayoutClass);
      Components.push_back(VTableComponent.MakeOffsetToTop(new CharUnits(OffsetToTop)));
      
      // Next, add the RTTI.
      Components.push_back(VTableComponent.MakeRTTI(MostDerivedClass));
      
      long/*uint64_t*/ AddressPoint = $uint2ulong(Components.size());
      
      // Now go through all virtual member functions and add them.
      SmallSetVector</*const*/ CXXRecordDecl /*P*/ > PrimaryBases/*J*/= new SmallSetVector</*const*/ CXXRecordDecl /*P*/ >(8, (/*const*/ CXXRecordDecl /*P*/ ) null);
      AddMethods(new BaseSubobject(Base), new CharUnits(OffsetInLayoutClass), 
          Base.getBase(), new CharUnits(OffsetInLayoutClass), 
          PrimaryBases);
      
      /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
      if (RD == MostDerivedClass) {
        assert (MethodVTableIndices.empty());
        for (final /*const*/std.pair</*const*/ CXXMethodDecl /*P*/ , MethodInfo> /*&*/ I : MethodInfoMap) {
          /*const*/ CXXMethodDecl /*P*/ MD = I.first;
          final /*const*/ MethodInfo /*&*/ MI = I.second;
          {
            /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
            if ((DD != null)) {
              MethodVTableIndices.$set(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Complete), 
                MI.VTableIndex - AddressPoint);
              MethodVTableIndices.$set(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Deleting), 
                MI.VTableIndex + $int2ullong(1) - AddressPoint);
            } else {
              MethodVTableIndices.$set(new GlobalDecl(MD), MI.VTableIndex - AddressPoint);
            }
          }
        }
      }
      
      // Compute 'this' pointer adjustments.
      ComputeThisAdjustments();
      
      // Add all address points.
      while (true) {
        AddressPoints.insert_pair$KeyT$ValueT(std.make_pair_T_ulong(new BaseSubobject(RD, new CharUnits(OffsetInLayoutClass)), 
                AddressPoint));
        
        final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
        /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
        if (!(PrimaryBase != null)) {
          break;
        }
        if (Layout.isPrimaryBaseVirtual()) {
          // Check if this virtual primary base is a primary base in the layout
          // class. If it's not, we don't want to add it.
          final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
          if (LayoutClassLayout.getVBaseClassOffset(PrimaryBase).$noteq(
              OffsetInLayoutClass
          )) {
            // We don't want to add this class (or any of its primary bases).
            break;
          }
        }
        
        RD = PrimaryBase;
      }
      
      // Layout secondary vtables.
      LayoutSecondaryVTables(new BaseSubobject(Base), BaseIsMorallyVirtual, new CharUnits(OffsetInLayoutClass));
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  /// LayoutSecondaryVTables - Layout the secondary vtables for the given base
  /// subobject.
  ///
  /// \param BaseIsMorallyVirtual whether the base subobject is a virtual base
  /// or a direct or indirect base of a virtual base.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::LayoutSecondaryVTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1728,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::LayoutSecondaryVTables", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder22LayoutSecondaryVTablesEN5clang13BaseSubobjectEbNS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder22LayoutSecondaryVTablesEN5clang13BaseSubobjectEbNS1_9CharUnitsE")
  //</editor-fold>
  private void LayoutSecondaryVTables(BaseSubobject Base, 
                        boolean BaseIsMorallyVirtual, 
                        CharUnits OffsetInLayoutClass) {
    // Itanium C++ ABI 2.5.2:
    //   Following the primary virtual table of a derived class are secondary 
    //   virtual tables for each of its proper base classes, except any primary
    //   base(s) with which it shares its primary virtual table.
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
      // Ignore virtual bases, we'll emit them later.
      if (B.isVirtual()) {
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = B.getType().$arrow().getAsCXXRecordDecl();
      
      // Ignore bases that don't have a vtable.
      if (!BaseDecl.isDynamicClass()) {
        continue;
      }
      if (isBuildingConstructorVTable()) {
        // Itanium C++ ABI 2.6.4:
        //   Some of the base class subobjects may not need construction virtual
        //   tables, which will therefore not be present in the construction
        //   virtual table group, even though the subobject virtual tables are
        //   present in the main virtual table group for the complete object.
        if (!BaseIsMorallyVirtual && !(BaseDecl.getNumVBases() != 0)) {
          continue;
        }
      }
      
      // Get the base offset of this base.
      CharUnits RelativeBaseOffset = Layout.getBaseClassOffset(BaseDecl);
      CharUnits BaseOffset = Base.getBaseOffset().$add(RelativeBaseOffset);
      
      CharUnits BaseOffsetInLayoutClass = OffsetInLayoutClass.$add(RelativeBaseOffset);
      
      // Don't emit a secondary vtable for a primary base. We might however want 
      // to emit secondary vtables for other bases of this base.
      if (BaseDecl == PrimaryBase) {
        LayoutSecondaryVTables(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), 
            BaseIsMorallyVirtual, new CharUnits(BaseOffsetInLayoutClass));
        continue;
      }
      
      // Layout the primary vtable (and any secondary vtables) for this base.
      LayoutPrimaryAndSecondaryVTables(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), 
          BaseIsMorallyVirtual, 
          /*BaseIsVirtualInLayoutClass=*/ false, 
          new CharUnits(BaseOffsetInLayoutClass));
    }
  }

  
  /// DeterminePrimaryVirtualBases - Determine the primary virtual bases in this
  /// class hierarchy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::DeterminePrimaryVirtualBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1786,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::DeterminePrimaryVirtualBases", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder28DeterminePrimaryVirtualBasesEPKN5clang13CXXRecordDeclENS1_9CharUnitsERN4llvm11SmallPtrSetIS4_Lj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder28DeterminePrimaryVirtualBasesEPKN5clang13CXXRecordDeclENS1_9CharUnitsERN4llvm11SmallPtrSetIS4_Lj4EEE")
  //</editor-fold>
  private void DeterminePrimaryVirtualBases(/*const*/ CXXRecordDecl /*P*/ RD, CharUnits OffsetInLayoutClass, 
                              final SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > /*&*/ VBases) {
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    {
      
      // Check if this base has a primary base.
      /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
      if ((PrimaryBase != null)) {
        
        // Check if it's virtual.
        if (Layout.isPrimaryBaseVirtual()) {
          boolean IsPrimaryVirtualBase = true;
          if (isBuildingConstructorVTable()) {
            // Check if the base is actually a primary base in the class we use for
            // layout.
            final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
            
            CharUnits PrimaryBaseOffsetInLayoutClass = LayoutClassLayout.getVBaseClassOffset(PrimaryBase);
            
            // We know that the base is not a primary base in the layout class if 
            // the base offsets are different.
            if (PrimaryBaseOffsetInLayoutClass.$noteq(OffsetInLayoutClass)) {
              IsPrimaryVirtualBase = false;
            }
          }
          if (IsPrimaryVirtualBase) {
            PrimaryVirtualBases.insert(PrimaryBase);
          }
        }
      }
    }
    
    // Traverse bases, looking for more primary virtual bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = B.getType().$arrow().getAsCXXRecordDecl();
      
      CharUnits BaseOffsetInLayoutClass/*J*/= new CharUnits();
      if (B.isVirtual()) {
        if (!VBases.insert(BaseDecl).second) {
          continue;
        }
        
        final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
        
        BaseOffsetInLayoutClass.$assignMove(
            LayoutClassLayout.getVBaseClassOffset(BaseDecl)
        );
      } else {
        BaseOffsetInLayoutClass.$assignMove(
            OffsetInLayoutClass.$add(Layout.getBaseClassOffset(BaseDecl))
        );
      }
      
      DeterminePrimaryVirtualBases(BaseDecl, new CharUnits(BaseOffsetInLayoutClass), VBases);
    }
  }

  
  /// LayoutVTablesForVirtualBases - Layout vtables for all virtual bases of the
  /// given base (excluding any primary bases).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::LayoutVTablesForVirtualBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1842,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::LayoutVTablesForVirtualBases", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder28LayoutVTablesForVirtualBasesEPKN5clang13CXXRecordDeclERN4llvm11SmallPtrSetIS4_Lj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder28LayoutVTablesForVirtualBasesEPKN5clang13CXXRecordDeclERN4llvm11SmallPtrSetIS4_Lj4EEE")
  //</editor-fold>
  private void LayoutVTablesForVirtualBases(/*const*/ CXXRecordDecl /*P*/ RD, final SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > /*&*/ VBases) {
    // Itanium C++ ABI 2.5.2:
    //   Then come the virtual base virtual tables, also in inheritance graph
    //   order, and again excluding primary bases (which share virtual tables with
    //   the classes for which they are primary).
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = B.getType().$arrow().getAsCXXRecordDecl();
      
      // Check if this base needs a vtable. (If it's virtual, not a primary base
      // of some other class, and we haven't visited it before).
      if (B.isVirtual() && BaseDecl.isDynamicClass()
         && !(PrimaryVirtualBases.count(BaseDecl) != 0)
         && VBases.insert(BaseDecl).second) {
        final /*const*/ ASTRecordLayout /*&*/ MostDerivedClassLayout = Context.getASTRecordLayout(MostDerivedClass);
        CharUnits BaseOffset = MostDerivedClassLayout.getVBaseClassOffset(BaseDecl);
        
        final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
        CharUnits BaseOffsetInLayoutClass = LayoutClassLayout.getVBaseClassOffset(BaseDecl);
        
        LayoutPrimaryAndSecondaryVTables(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), 
            /*BaseIsMorallyVirtual=*/ true, 
            /*BaseIsVirtualInLayoutClass=*/ true, 
            new CharUnits(BaseOffsetInLayoutClass));
      }
      
      // We only need to check the base for virtual base vtables if it actually
      // has virtual bases.
      if ((BaseDecl.getNumVBases() != 0)) {
        LayoutVTablesForVirtualBases(BaseDecl, VBases);
      }
    }
  }

  
  /// isBuildingConstructionVTable - Return whether this vtable builder is
  /// building a construction vtable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::isBuildingConstructorVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 980,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::isBuildingConstructorVTable", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder27isBuildingConstructorVTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder27isBuildingConstructorVTableEv")
  //</editor-fold>
  private boolean isBuildingConstructorVTable() /*const*/ {
    return MostDerivedClass != LayoutClass;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::ItaniumVTableBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 985,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::ItaniumVTableBuilder", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilderC1ERN5clang20ItaniumVTableContextEPKNS1_13CXXRecordDeclENS1_9CharUnitsEbS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilderC1ERN5clang20ItaniumVTableContextEPKNS1_13CXXRecordDeclENS1_9CharUnitsEbS6_")
  //</editor-fold>
  public ItaniumVTableBuilder(final ItaniumVTableContext /*&*/ VTables, 
      /*const*/ CXXRecordDecl /*P*/ MostDerivedClass, 
      CharUnits MostDerivedClassOffset, 
      boolean MostDerivedClassIsVirtual, 
      /*const*/ CXXRecordDecl /*P*/ LayoutClass) {
    // : VTables(VTables), MostDerivedClass(MostDerivedClass), MostDerivedClassOffset(MostDerivedClassOffset), MostDerivedClassIsVirtual(MostDerivedClassIsVirtual), LayoutClass(LayoutClass), Context(MostDerivedClass->getASTContext()), Overriders(MostDerivedClass, MostDerivedClassOffset, LayoutClass), VCallOffsetsForVBases(), VBaseOffsetOffsets(), Components(), AddressPoints(), MethodInfoMap(), MethodVTableIndices(), VTableThunks(), Thunks(), PrimaryVirtualBases() 
    //START JInit
    this./*&*/VTables=/*&*/VTables;
    this.MostDerivedClass = MostDerivedClass;
    this.MostDerivedClassOffset = new CharUnits(MostDerivedClassOffset);
    this.MostDerivedClassIsVirtual = MostDerivedClassIsVirtual;
    this.LayoutClass = LayoutClass;
    this./*&*/Context=/*&*/MostDerivedClass.getASTContext();
    this.Overriders = new FinalOverriders(MostDerivedClass, new CharUnits(MostDerivedClassOffset), LayoutClass);
    this.VCallOffsetsForVBases = new DenseMap</*const*/ CXXRecordDecl /*P*/ , VCallOffsetMap>(DenseMapInfo$LikePtr.$Info(), new VCallOffsetMap());
    this.VBaseOffsetOffsets = new DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>(DenseMapInfo$LikePtr.$Info(), new CharUnits());
    this.Components = new SmallVector<VTableComponent>(64, new VTableComponent());
    this.AddressPoints = new DenseMapTypeULong<BaseSubobject>(DenseMapInfoBaseSubobject.$Info(), 0);
    this.MethodInfoMap = new DenseMap</*const*/ CXXMethodDecl /*P*/ , MethodInfo>(DenseMapInfo$LikePtr.$Info(), new MethodInfo());
    this.MethodVTableIndices = new DenseMapTypeLong<GlobalDecl>(DenseMapInfoGlobalDecl.$Info(), 0);
    this.VTableThunks = new DenseMapULongType<ThunkInfo>(DenseMapInfoULong.$Info(), new ThunkInfo());
    this.Thunks = new DenseMap</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<ThunkInfo>(1));
    this.PrimaryVirtualBases = new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    //END JInit
    assert (!Context.getTargetInfo().getCXXABI().isMicrosoft());
    
    LayoutVTable();
    if (Context.getLangOpts().DumpVTableLayouts) {
      dumpLayout(llvm.outs());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::getNumThunks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1003,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::getNumThunks", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder12getNumThunksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder12getNumThunksEv")
  //</editor-fold>
  public long/*uint64_t*/ getNumThunks() /*const*/ {
    return $uint2ulong(Thunks.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::thunks_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1007,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::thunks_begin", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder12thunks_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder12thunks_beginEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>> thunks_begin() /*const*/ {
    return Thunks.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::thunks_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1011,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::thunks_end", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder10thunks_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder10thunks_endEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>> thunks_end() /*const*/ {
    return Thunks.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::getVBaseOffsetOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1015,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::getVBaseOffsetOffsets", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder21getVBaseOffsetOffsetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder21getVBaseOffsetOffsetsEv")
  //</editor-fold>
  public /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ getVBaseOffsetOffsets() /*const*/ {
    return VBaseOffsetOffsets;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::getAddressPoints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1019,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::getAddressPoints", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder16getAddressPointsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder16getAddressPointsEv")
  //</editor-fold>
  public /*const*/DenseMapTypeULong<BaseSubobject> /*&*/ getAddressPoints() /*const*/ {
    return AddressPoints;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::vtable_indices_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1023,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::vtable_indices_begin", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder20vtable_indices_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder20vtable_indices_beginEv")
  //</editor-fold>
  public DenseMapIteratorTypeLong<GlobalDecl> vtable_indices_begin() /*const*/ {
    return MethodVTableIndices.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::vtable_indices_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1027,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::vtable_indices_end", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder18vtable_indices_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder18vtable_indices_endEv")
  //</editor-fold>
  public DenseMapIteratorTypeLong<GlobalDecl> vtable_indices_end() /*const*/ {
    return MethodVTableIndices.end$Const();
  }

  
  /// getNumVTableComponents - Return the number of components in the vtable
  /// currently built.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::getNumVTableComponents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1033,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::getNumVTableComponents", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder22getNumVTableComponentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder22getNumVTableComponentsEv")
  //</editor-fold>
  public long/*uint64_t*/ getNumVTableComponents() /*const*/ {
    return $uint2ulong(Components.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::vtable_component_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1037,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::vtable_component_begin", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder22vtable_component_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder22vtable_component_beginEv")
  //</editor-fold>
  public /*const*/ type$ptr<VTableComponent> /*P*/ vtable_component_begin() /*const*/ {
    return Components.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::vtable_component_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1041,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::vtable_component_end", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder20vtable_component_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder20vtable_component_endEv")
  //</editor-fold>
  public /*const*/ type$ptr<VTableComponent> /*P*/ vtable_component_end() /*const*/ {
    return Components.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::address_points_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1045,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::address_points_begin", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder20address_points_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder20address_points_beginEv")
  //</editor-fold>
  public DenseMapIteratorTypeULong<BaseSubobject> address_points_begin() /*const*/ {
    return AddressPoints.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::address_points_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1049,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::address_points_end", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder18address_points_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder18address_points_endEv")
  //</editor-fold>
  public DenseMapIteratorTypeULong<BaseSubobject> address_points_end() /*const*/ {
    return AddressPoints.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::vtable_thunks_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1053,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::vtable_thunks_begin", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder19vtable_thunks_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder19vtable_thunks_beginEv")
  //</editor-fold>
  public DenseMapIteratorULongType<ThunkInfo> vtable_thunks_begin() /*const*/ {
    return VTableThunks.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::vtable_thunks_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1057,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::vtable_thunks_end", NM="_ZNK12_GLOBAL__N_120ItaniumVTableBuilder17vtable_thunks_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_120ItaniumVTableBuilder17vtable_thunks_endEv")
  //</editor-fold>
  public DenseMapIteratorULongType<ThunkInfo> vtable_thunks_end() /*const*/ {
    return VTableThunks.end$Const();
  }

  
  /// dumpLayout - Dump the vtable layout.
  
  /// dumpLayout - Dump the vtable layout.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::dumpLayout">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use make_pair_T_T vs std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1881,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::dumpLayout", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilder10dumpLayoutERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilder10dumpLayoutERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpLayout(final raw_ostream /*&*/ Out) {
    std.multimapULongType<BaseSubobject> AddressPointsByIndex = null;
    std.mapULongType<std.string> IndicesMap = null;
    try {
      // FIXME: write more tests that actually use the dumpLayout output to prevent
      // ItaniumVTableBuilder regressions.
      if (isBuildingConstructorVTable()) {
        Out.$out(/*KEEP_STR*/"Construction vtable for ('");
        MostDerivedClass.printQualifiedName(Out);
        Out.$out(/*KEEP_STR*/"', ");
        Out.$out_llong(MostDerivedClassOffset.getQuantity()).$out(/*KEEP_STR*/") in '");
        LayoutClass.printQualifiedName(Out);
      } else {
        Out.$out(/*KEEP_STR*/"Vtable for '");
        MostDerivedClass.printQualifiedName(Out);
      }
      Out.$out(/*KEEP_STR*/"' (").$out_uint(Components.size()).$out(/*KEEP_STR*/" entries).\n");
      
      // Iterate through the address points and insert them into a new map where
      // they are keyed by the index and not the base object.
      // Since an address point can be shared by multiple subobjects, we use an
      // STL multimap.
      AddressPointsByIndex/*J*/= new std.multimapULongType<BaseSubobject>(new BaseSubobject());
      for (final /*const*/std.pairTypeULong<BaseSubobject> /*&*/ AP : AddressPoints) {
        final /*const*/ BaseSubobject /*&*/ Base = AP.first;
        long/*uint64_t*/ Index = AP.second;
        
        AddressPointsByIndex.insert$T(std.make_pair_ullong_T(Index, Base));
      }
      
      for (/*uint*/int I = 0, E = Components.size(); I != E; ++I) {
        long/*uint64_t*/ Index = $uint2ulong(I);
        
        Out.$out(llvm.format($("%4d | "), I));
        
        final /*const*/ VTableComponent /*&*/ Component = Components.$at(I);
        
        // Dump the component.
        switch (Component.getKind()) {
         case CK_VCallOffset:
          Out.$out(/*KEEP_STR*/"vcall_offset (").$out_llong(
              Component.getVCallOffset().getQuantity()
          ).$out(
              /*KEEP_STR*/$RPAREN
          );
          break;
         case CK_VBaseOffset:
          Out.$out(/*KEEP_STR*/"vbase_offset (").$out_llong(
              Component.getVBaseOffset().getQuantity()
          ).$out(
              /*KEEP_STR*/$RPAREN
          );
          break;
         case CK_OffsetToTop:
          Out.$out(/*KEEP_STR*/"offset_to_top (").$out_llong(
              Component.getOffsetToTop().getQuantity()
          ).$out(
              /*KEEP_STR*/$RPAREN
          );
          break;
         case CK_RTTI:
          Component.getRTTIDecl().printQualifiedName(Out);
          Out.$out(/*KEEP_STR*/" RTTI");
          break;
         case CK_FunctionPointer:
          {
            /*const*/ CXXMethodDecl /*P*/ MD = Component.getFunctionDecl();
            
            std.string Str = PredefinedExpr.ComputeName(PredefinedExpr.IdentType.PrettyFunctionNoVirtual, 
                MD);
            Out.$out(Str);
            if (MD.isPure()) {
              Out.$out(/*KEEP_STR*/" [pure]");
            }
            if (MD.isDeleted()) {
              Out.$out(/*KEEP_STR*/" [deleted]");
            }
            
            ThunkInfo Thunk = VTableThunks.lookup($uint2ullong(I));
            if (!Thunk.isEmpty()) {
              // If this function pointer has a return adjustment, dump it.
              if (!Thunk.Return.isEmpty()) {
                Out.$out(/*KEEP_STR*/"\n       [return adjustment: ");
                Out.$out_llong(Thunk.Return.NonVirtual).$out(/*KEEP_STR*/" non-virtual");
                if ((Thunk.Return.Virtual.Itanium.VBaseOffsetOffset != 0)) {
                  Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_llong(Thunk.Return.Virtual.Itanium.VBaseOffsetOffset);
                  Out.$out(/*KEEP_STR*/" vbase offset offset");
                }
                
                Out.$out_char($$RSQUARE);
              }
              
              // If this function pointer has a 'this' pointer adjustment, dump it.
              if (!Thunk.This.isEmpty()) {
                Out.$out(/*KEEP_STR*/"\n       [this adjustment: ");
                Out.$out_llong(Thunk.This.NonVirtual).$out(/*KEEP_STR*/" non-virtual");
                if ((Thunk.This.Virtual.Itanium.VCallOffsetOffset != 0)) {
                  Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_llong(Thunk.This.Virtual.Itanium.VCallOffsetOffset);
                  Out.$out(/*KEEP_STR*/" vcall offset offset");
                }
                
                Out.$out_char($$RSQUARE);
              }
            }
            
            break;
          }
         case CK_CompleteDtorPointer:
         case CK_DeletingDtorPointer:
          {
            boolean IsComplete = Component.getKind() == VTableComponent.Kind.CK_CompleteDtorPointer;
            
            /*const*/ CXXDestructorDecl /*P*/ DD = Component.getDestructorDecl();
            
            DD.printQualifiedName(Out);
            if (IsComplete) {
              Out.$out(/*KEEP_STR*/"() [complete]");
            } else {
              Out.$out(/*KEEP_STR*/"() [deleting]");
            }
            if (DD.isPure()) {
              Out.$out(/*KEEP_STR*/" [pure]");
            }
            
            ThunkInfo Thunk = VTableThunks.lookup($uint2ullong(I));
            if (!Thunk.isEmpty()) {
              // If this destructor has a 'this' pointer adjustment, dump it.
              if (!Thunk.This.isEmpty()) {
                Out.$out(/*KEEP_STR*/"\n       [this adjustment: ");
                Out.$out_llong(Thunk.This.NonVirtual).$out(/*KEEP_STR*/" non-virtual");
                if ((Thunk.This.Virtual.Itanium.VCallOffsetOffset != 0)) {
                  Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_llong(Thunk.This.Virtual.Itanium.VCallOffsetOffset);
                  Out.$out(/*KEEP_STR*/" vcall offset offset");
                }
                
                Out.$out_char($$RSQUARE);
              }
            }
            
            break;
          }
         case CK_UnusedFunctionPointer:
          {
            /*const*/ CXXMethodDecl /*P*/ MD = Component.getUnusedFunctionDecl();
            
            std.string Str = PredefinedExpr.ComputeName(PredefinedExpr.IdentType.PrettyFunctionNoVirtual, 
                MD);
            Out.$out(/*KEEP_STR*/"[unused] ").$out(Str);
            if (MD.isPure()) {
              Out.$out(/*KEEP_STR*/" [pure]");
            }
          }
        }
        
        Out.$out_char($$LF);
        
        // Dump the next address point.
        long/*uint64_t*/ NextIndex = Index + $int2ullong(1);
        if ((AddressPointsByIndex.count(NextIndex) != 0)) {
          if (AddressPointsByIndex.count(NextIndex) == 1) {
            final /*const*/ BaseSubobject /*&*/ Base = AddressPointsByIndex.find(NextIndex).$star().second;
            
            Out.$out(/*KEEP_STR*/"       -- (");
            Base.getBase().printQualifiedName(Out);
            Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_llong(Base.getBaseOffset().getQuantity());
            Out.$out(/*KEEP_STR*/") vtable address --\n");
          } else {
            std.setType<std.string> ClassNames = null;
            try {
              CharUnits BaseOffset = AddressPointsByIndex.lower_bound(NextIndex).$arrow().second.getBaseOffset();
              
              // We store the class names in a set to get a stable order.
              ClassNames/*J*/= new std.setType<std.string>();
              for (final /*const*/std.pairULongType<BaseSubobject> /*&*/ I$1 : llvm.make_range(AddressPointsByIndex.equal_range(NextIndex))) {
                assert (I$1.second.getBaseOffset().$eq(BaseOffset)) : "Invalid base offset!";
                /*const*/ CXXRecordDecl /*P*/ RD = I$1.second.getBase();
                ClassNames.insert_T$RR(RD.getQualifiedNameAsString());
              }
              
              for (final /*const*/std.string/*&*/ Name : ClassNames) {
                Out.$out(/*KEEP_STR*/"       -- (").$out(Name);
                Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_llong(BaseOffset.getQuantity()).$out(/*KEEP_STR*/") vtable address --\n");
              }
            } finally {
              if (ClassNames != null) { ClassNames.$destroy(); }
            }
          }
        }
      }
      
      Out.$out_char($$LF);
      if (isBuildingConstructorVTable()) {
        return;
      }
      if ((MostDerivedClass.getNumVBases() != 0)) {
        std.mapTypeType<std.string, CharUnits> ClassNamesAndOffsets = null;
        try {
          // We store the virtual base class names and their offsets in a map to get
          // a stable order.
          ClassNamesAndOffsets/*J*/= new std.mapTypeType<std.string, CharUnits>(new CharUnits());
          for (final /*const*/std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ I : VBaseOffsetOffsets) {
            std.string ClassName = I.first.getQualifiedNameAsString();
            CharUnits OffsetOffset = new CharUnits(I.second);
            ClassNamesAndOffsets.insert$T(std.make_pair(ClassName, OffsetOffset));
          }
          
          Out.$out(/*KEEP_STR*/"Virtual base offset offsets for '");
          MostDerivedClass.printQualifiedName(Out);
          Out.$out(/*KEEP_STR*/"' (");
          Out.$out_uint(ClassNamesAndOffsets.size());
          Out.$out((ClassNamesAndOffsets.size() == 1 ? $(" entry") : $(" entries"))).$out(/*KEEP_STR*/").\n");
          
          for (final /*const*/ pair</*const*/std.string, CharUnits> /*&*/ I : ClassNamesAndOffsets)  {
            Out.$out(/*KEEP_STR*/"   ").$out(I.first).$out(/*KEEP_STR*/" | ").$out_llong(I.second.getQuantity()).$out_char($$LF);
          }
          
          Out.$out(/*KEEP_STR*/$LF);
        } finally {
          if (ClassNamesAndOffsets != null) { ClassNamesAndOffsets.$destroy(); }
        }
      }
      if (!Thunks.empty()) {
        std.mapTypePtr<std.string, /*const*/ CXXMethodDecl /*P*/ > MethodNamesAndDecls = null;
        try {
          // We store the method names in a map to get a stable order.
          MethodNamesAndDecls/*J*/= new std.mapTypePtr<std.string, /*const*/ CXXMethodDecl /*P*/ >();
          
          for (final /*const*/std.pair</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>> /*&*/ I : Thunks) {
            /*const*/ CXXMethodDecl /*P*/ MD = I.first;
            std.string MethodName = PredefinedExpr.ComputeName(PredefinedExpr.IdentType.PrettyFunctionNoVirtual, 
                MD);
            
            MethodNamesAndDecls.insert$T(std.make_pair_T_Ptr(MethodName, MD));
          }
          
          for (final /*const*/ pair</*const*/std.string, /*const*/ CXXMethodDecl /*P*/ > /*&*/ I : MethodNamesAndDecls) {
            final /*const*/std.string/*&*/ MethodName = I.first;
            /*const*/ CXXMethodDecl /*P*/ MD = I.second;
            
            SmallVector<ThunkInfo> ThunksVector = new SmallVector<ThunkInfo>(Thunks.$at_T1$C$R(MD));
            std.sort(ThunksVector.begin(), ThunksVector.end(), 
                /*[]*/ (final /*const*/ ThunkInfo /*&*/ LHS, final /*const*/ ThunkInfo /*&*/ RHS) -> {
                      assert (LHS.Method == (/*const*/ CXXMethodDecl /*P*/ )null && RHS.Method == (/*const*/ CXXMethodDecl /*P*/ )null);
                      return $less_tuple_T_T(/*JAVA*/std.make_pair_T_T(LHS.This, LHS.Return), std.make_pair_T_T(RHS.This, RHS.Return), 
                              ThisAdjustment::$less_ThisAdjustment$C, ReturnAdjustment::$less_ReturnAdjustment$C);
                    });
            
            Out.$out(/*KEEP_STR*/"Thunks for '").$out(MethodName).$out(/*KEEP_STR*/"' (").$out_uint(ThunksVector.size());
            Out.$out((ThunksVector.size() == 1 ? $(" entry") : $(" entries"))).$out(/*KEEP_STR*/").\n");
            
            for (/*uint*/int I$1 = 0, E = ThunksVector.size(); I$1 != E; ++I$1) {
              final /*const*/ ThunkInfo /*&*/ Thunk = ThunksVector.$at(I$1);
              
              Out.$out(llvm.format($("%4d | "), I$1));
              
              // If this function pointer has a return pointer adjustment, dump it.
              if (!Thunk.Return.isEmpty()) {
                Out.$out(/*KEEP_STR*/"return adjustment: ").$out_llong(Thunk.Return.NonVirtual);
                Out.$out(/*KEEP_STR*/" non-virtual");
                if ((Thunk.Return.Virtual.Itanium.VBaseOffsetOffset != 0)) {
                  Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_llong(Thunk.Return.Virtual.Itanium.VBaseOffsetOffset);
                  Out.$out(/*KEEP_STR*/" vbase offset offset");
                }
                if (!Thunk.This.isEmpty()) {
                  Out.$out(/*KEEP_STR*/"\n       ");
                }
              }
              
              // If this function pointer has a 'this' pointer adjustment, dump it.
              if (!Thunk.This.isEmpty()) {
                Out.$out(/*KEEP_STR*/"this adjustment: ");
                Out.$out_llong(Thunk.This.NonVirtual).$out(/*KEEP_STR*/" non-virtual");
                if ((Thunk.This.Virtual.Itanium.VCallOffsetOffset != 0)) {
                  Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_llong(Thunk.This.Virtual.Itanium.VCallOffsetOffset);
                  Out.$out(/*KEEP_STR*/" vcall offset offset");
                }
              }
              
              Out.$out_char($$LF);
            }
            
            Out.$out_char($$LF);
          }
        } finally {
          if (MethodNamesAndDecls != null) { MethodNamesAndDecls.$destroy(); }
        }
      }
      
      // Compute the vtable indices for all the member functions.
      // Store them in a map keyed by the index so we'll get a sorted table.
      IndicesMap/*J*/= new std.mapULongType<std.string>(new std.string());
      
      for (/*const*/ CXXMethodDecl /*P*/ MD : MostDerivedClass.methods()) {
        // We only want virtual member functions.
        if (!MD.isVirtual()) {
          continue;
        }
        MD = MD.getCanonicalDecl$Const();
        
        std.string MethodName = PredefinedExpr.ComputeName(PredefinedExpr.IdentType.PrettyFunctionNoVirtual, 
            MD);
        {
          
          /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
          if ((DD != null)) {
            GlobalDecl GD/*J*/= new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Complete);
            assert Native.$bool(MethodVTableIndices.count(GD));
            long/*uint64_t*/ VTableIndex = MethodVTableIndices.$at_T1$C$R(GD);
            IndicesMap.$at_T$C$R(VTableIndex).$assignMove($add_string$C_T$C$P(MethodName, /*KEEP_STR*/" [complete]"));
            IndicesMap.$at_T$RR(VTableIndex + $int2ullong(1)).$assignMove($add_string$C_T$C$P(MethodName, /*KEEP_STR*/" [deleting]"));
          } else {
            assert Native.$bool(MethodVTableIndices.count(new GlobalDecl(MD)));
            IndicesMap.$at_T$RR(MethodVTableIndices.$at_T1$RR(new GlobalDecl(MD))).$assign(MethodName);
          }
        }
      }
      
      // Print the vtable indices for all the member functions.
      if (!IndicesMap.empty()) {
        Out.$out(/*KEEP_STR*/"VTable indices for '");
        MostDerivedClass.printQualifiedName(Out);
        Out.$out(/*KEEP_STR*/"' (").$out_uint(IndicesMap.size()).$out(/*KEEP_STR*/" entries).\n");
        
        for (final /*const*/std.pairULongType<std.string> /*&*/ I : IndicesMap) {
          long/*uint64_t*/ VTableIndex = I.first;
          final /*const*/std.string/*&*/ MethodName = I.second;
          
          Out.$out(llvm.format($("%4llu | "), VTableIndex)).$out(MethodName).$out_char(
              $$LF
          );
        }
      }
      
      Out.$out_char($$LF);
    } finally {
      if (IndicesMap != null) { IndicesMap.$destroy(); }
      if (AddressPointsByIndex != null) { AddressPointsByIndex.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumVTableBuilder::~ItaniumVTableBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 771,
   FQN="(anonymous namespace)::ItaniumVTableBuilder::~ItaniumVTableBuilder", NM="_ZN12_GLOBAL__N_120ItaniumVTableBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_120ItaniumVTableBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PrimaryVirtualBases.$destroy();
    Thunks.$destroy();
    VTableThunks.$destroy();
    MethodVTableIndices.$destroy();
    MethodInfoMap.$destroy();
    AddressPoints.$destroy();
    Components.$destroy();
    VBaseOffsetOffsets.$destroy();
    VCallOffsetsForVBases.$destroy();
    Overriders.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "VTables=" + "[ItaniumVTableContext]" // NOI18N
              + ", MostDerivedClass=" + MostDerivedClass // NOI18N
              + ", MostDerivedClassOffset=" + MostDerivedClassOffset // NOI18N
              + ", MostDerivedClassIsVirtual=" + MostDerivedClassIsVirtual // NOI18N
              + ", LayoutClass=" + LayoutClass // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", Overriders=" + Overriders // NOI18N
              + ", VCallOffsetsForVBases=" + VCallOffsetsForVBases // NOI18N
              + ", VBaseOffsetOffsets=" + VBaseOffsetOffsets // NOI18N
              + ", Components=" + Components // NOI18N
              + ", AddressPoints=" + AddressPoints // NOI18N
              + ", MethodInfoMap=" + MethodInfoMap // NOI18N
              + ", MethodVTableIndices=" + MethodVTableIndices // NOI18N
              + ", VTableThunks=" + VTableThunks // NOI18N
              + ", Thunks=" + Thunks // NOI18N
              + ", PrimaryVirtualBases=" + PrimaryVirtualBases; // NOI18N
  }
}
