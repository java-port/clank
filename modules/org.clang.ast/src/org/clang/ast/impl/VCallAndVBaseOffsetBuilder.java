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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;


/// VCallAndVBaseOffsetBuilder - Class for building vcall and vbase offsets.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 533,
 FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder", NM="_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilderE")
//</editor-fold>
public class VCallAndVBaseOffsetBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef llvm::DenseMap<const CXXRecordDecl *, CharUnits> VBaseOffsetOffsetsMapTy*/
//  public final class VBaseOffsetOffsetsMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>{ };
/*private:*/
  /// MostDerivedClass - The most derived class for which we're building vcall
  /// and vbase offsets.
  private /*const*/ CXXRecordDecl /*P*/ MostDerivedClass;
  
  /// LayoutClass - The class we're using for layout information. Will be 
  /// different than the most derived class if we're building a construction
  /// vtable.
  private /*const*/ CXXRecordDecl /*P*/ LayoutClass;
  
  /// Context - The ASTContext which we will use for layout information.
  private final ASTContext /*&*/ Context;
  
  /// Components - vcall and vbase offset components
  /*typedef SmallVector<VTableComponent, 64> VTableComponentVectorTy*/
//  public final class VTableComponentVectorTy extends SmallVector<VTableComponent>{ };
  private SmallVector<VTableComponent> Components;
  
  /// VisitedVirtualBases - Visited virtual bases.
  private SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VisitedVirtualBases;
  
  /// VCallOffsets - Keeps track of vcall offsets.
  private VCallOffsetMap VCallOffsets;
  
  /// VBaseOffsetOffsets - Contains the offsets of the virtual base offsets,
  /// relative to the address point.
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> VBaseOffsetOffsets;
  
  /// FinalOverriders - The final overriders of the most derived class.
  /// (Can be null when we're not building a vtable of the most derived class).
  private /*const*/ FinalOverriders /*P*/ Overriders;
  
  /// AddVCallAndVBaseOffsets - Add vcall offsets and vbase offsets for the
  /// given base subobject.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::AddVCallAndVBaseOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 610,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::AddVCallAndVBaseOffsets", NM="_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilder23AddVCallAndVBaseOffsetsEN5clang13BaseSubobjectEbNS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilder23AddVCallAndVBaseOffsetsEN5clang13BaseSubobjectEbNS1_9CharUnitsE")
  //</editor-fold>
  private void AddVCallAndVBaseOffsets(BaseSubobject Base, 
                         boolean BaseIsVirtual, 
                         CharUnits RealBaseOffset) {
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(Base.getBase());
    {
      
      // Itanium C++ ABI 2.5.2:
      //   ..in classes sharing a virtual table with a primary base class, the vcall
      //   and vbase offsets added by the derived class all come before the vcall
      //   and vbase offsets required by the base class, so that the latter may be
      //   laid out as required by the base class without regard to additions from
      //   the derived class(es).
      
      // (Since we're emitting the vcall and vbase offsets in reverse order, we'll
      // emit them for the primary base first).
      /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
      if ((PrimaryBase != null)) {
        boolean PrimaryBaseIsVirtual = Layout.isPrimaryBaseVirtual();
        
        CharUnits PrimaryBaseOffset/*J*/= new CharUnits();
        
        // Get the base offset of the primary base.
        if (PrimaryBaseIsVirtual) {
          assert (Layout.getVBaseClassOffset(PrimaryBase).isZero()) : "Primary vbase should have a zero offset!";
          
          final /*const*/ ASTRecordLayout /*&*/ MostDerivedClassLayout = Context.getASTRecordLayout(MostDerivedClass);
          
          PrimaryBaseOffset.$assignMove(
              MostDerivedClassLayout.getVBaseClassOffset(PrimaryBase)
          );
        } else {
          assert (Layout.getBaseClassOffset(PrimaryBase).isZero()) : "Primary base should have a zero offset!";
          
          PrimaryBaseOffset.$assignMove(Base.getBaseOffset());
        }
        
        AddVCallAndVBaseOffsets(new BaseSubobject(PrimaryBase, new CharUnits(PrimaryBaseOffset)), 
            PrimaryBaseIsVirtual, new CharUnits(RealBaseOffset));
      }
    }
    
    AddVBaseOffsets(Base.getBase(), new CharUnits(RealBaseOffset));
    
    // We only want to add vcall offsets for virtual bases.
    if (BaseIsVirtual) {
      AddVCallOffsets(new BaseSubobject(Base), new CharUnits(RealBaseOffset));
    }
  }

  
  /// AddVCallOffsets - Add vcall offsets for the given base subobject.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::AddVCallOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 672,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::AddVCallOffsets", NM="_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilder15AddVCallOffsetsEN5clang13BaseSubobjectENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilder15AddVCallOffsetsEN5clang13BaseSubobjectENS1_9CharUnitsE")
  //</editor-fold>
  private void AddVCallOffsets(BaseSubobject Base, 
                 CharUnits VBaseOffset) {
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    
    /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
    
    // Handle the primary base first.
    // We only want to add vcall offsets if the base is non-virtual; a virtual
    // primary base will have its vcall and vbase offsets emitted already.
    if ((PrimaryBase != null) && !Layout.isPrimaryBaseVirtual()) {
      // Get the base offset of the primary base.
      assert (Layout.getBaseClassOffset(PrimaryBase).isZero()) : "Primary base should have a zero offset!";
      
      AddVCallOffsets(new BaseSubobject(PrimaryBase, Base.getBaseOffset()), 
          new CharUnits(VBaseOffset));
    }
    
    // Add the vcall offsets.
    for (/*const*/ CXXMethodDecl /*P*/ MD : RD.methods()) {
      if (!MD.isVirtual()) {
        continue;
      }
      MD = MD.getCanonicalDecl$Const();
      
      CharUnits OffsetOffset = getCurrentOffsetOffset();
      
      // Don't add a vcall offset if we already have one for this member function
      // signature.
      if (!VCallOffsets.AddVCallOffset(MD, new CharUnits(OffsetOffset))) {
        continue;
      }
      
      CharUnits Offset = CharUnits.Zero();
      if ((Overriders != null)) {
        // Get the final overrider.
        FinalOverriders.OverriderInfo Overrider = Overriders.getOverrider(MD, Base.getBaseOffset());
        
        /// The vcall offset is the offset from the virtual base to the object 
        /// where the function was overridden.
        Offset.$assignMove(Overrider.Offset.$sub(VBaseOffset));
      }
      
      Components.push_back(VTableComponent.MakeVCallOffset(new CharUnits(Offset)));
    }
    
    // And iterate over all non-virtual bases (ignoring the primary base).
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
      if (B.isVirtual()) {
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = B.getType().$arrow().getAsCXXRecordDecl();
      if (BaseDecl == PrimaryBase) {
        continue;
      }
      
      // Get the base offset of this base.
      CharUnits BaseOffset = Base.getBaseOffset().$add(
          Layout.getBaseClassOffset(BaseDecl)
      );
      
      AddVCallOffsets(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), 
          new CharUnits(VBaseOffset));
    }
  }

  
  /// AddVBaseOffsets - Add vbase offsets for the given class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::AddVBaseOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 738,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::AddVBaseOffsets", NM="_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilder15AddVBaseOffsetsEPKN5clang13CXXRecordDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilder15AddVBaseOffsetsEPKN5clang13CXXRecordDeclENS1_9CharUnitsE")
  //</editor-fold>
  private void AddVBaseOffsets(/*const*/ CXXRecordDecl /*P*/ RD, 
                 CharUnits OffsetInLayoutClass) {
    final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
    
    // Add vbase offsets.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = B.getType().$arrow().getAsCXXRecordDecl();
      
      // Check if this is a virtual base that we haven't visited before.
      if (B.isVirtual() && VisitedVirtualBases.insert(BaseDecl).second) {
        CharUnits Offset = LayoutClassLayout.getVBaseClassOffset(BaseDecl).$sub(OffsetInLayoutClass);
        
        // Add the vbase offset offset.
        assert (!(VBaseOffsetOffsets.count(BaseDecl) != 0)) : "vbase offset offset already exists!";
        
        CharUnits VBaseOffsetOffset = getCurrentOffsetOffset();
        VBaseOffsetOffsets.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(BaseDecl, VBaseOffsetOffset));
        
        Components.push_back(VTableComponent.MakeVBaseOffset(new CharUnits(Offset)));
      }
      
      // Check the base class looking for more vbase offsets.
      AddVBaseOffsets(BaseDecl, new CharUnits(OffsetInLayoutClass));
    }
  }

  
  /// getCurrentOffsetOffset - Get the current vcall or vbase offset offset in
  /// chars, relative to the vtable address point.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::getCurrentOffsetOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 659,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::getCurrentOffsetOffset", NM="_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder22getCurrentOffsetOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder22getCurrentOffsetOffsetEv")
  //</editor-fold>
  private CharUnits getCurrentOffsetOffset() /*const*/ {
    // OffsetIndex is the index of this vcall or vbase offset, relative to the 
    // vtable address point. (We subtract 3 to account for the information just
    // above the address point, the RTTI info, the offset to top, and the
    // vcall offset itself).
    long/*int64_t*/ OffsetIndex = -(long/*int64_t*/)$uint2long((3 + Components.size()));
    
    CharUnits PointerWidth = Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerWidth(0));
    CharUnits OffsetOffset = PointerWidth.$star(OffsetIndex);
    return OffsetOffset;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::VCallAndVBaseOffsetBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 587,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::VCallAndVBaseOffsetBuilder", NM="_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilderC1EPKN5clang13CXXRecordDeclES4_PKNS_15FinalOverridersENS1_13BaseSubobjectEbNS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilderC1EPKN5clang13CXXRecordDeclES4_PKNS_15FinalOverridersENS1_13BaseSubobjectEbNS1_9CharUnitsE")
  //</editor-fold>
  public VCallAndVBaseOffsetBuilder(/*const*/ CXXRecordDecl /*P*/ MostDerivedClass, 
      /*const*/ CXXRecordDecl /*P*/ LayoutClass, 
      /*const*/ FinalOverriders /*P*/ Overriders, 
      BaseSubobject Base, boolean BaseIsVirtual, 
      CharUnits OffsetInLayoutClass) {
    // : MostDerivedClass(MostDerivedClass), LayoutClass(LayoutClass), Context(MostDerivedClass->getASTContext()), Components(), VisitedVirtualBases(), VCallOffsets(), VBaseOffsetOffsets(), Overriders(Overriders) 
    //START JInit
    this.MostDerivedClass = MostDerivedClass;
    this.LayoutClass = LayoutClass;
    this./*&*/Context=/*&*/MostDerivedClass.getASTContext();
    this.Components = new SmallVector<VTableComponent>(64, new VTableComponent());
    this.VisitedVirtualBases = new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.VCallOffsets = new VCallOffsetMap();
    this.VBaseOffsetOffsets = new DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>(DenseMapInfo$LikePtr.$Info(), new CharUnits());
    this.Overriders = Overriders;
    //END JInit
    
    // Add vcall and vbase offsets.
    AddVCallAndVBaseOffsets(new BaseSubobject(Base), BaseIsVirtual, new CharUnits(OffsetInLayoutClass));
  }

  
  /// Methods for iterating over the components.
  /*typedef VTableComponentVectorTy::const_reverse_iterator const_iterator*/
//  public final class const_iterator extends std.reverse_iterator</*const*/ VTableComponent>{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::components_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 601,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::components_begin", NM="_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder16components_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder16components_beginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ VTableComponent> components_begin() /*const*/ {
    return Components.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::components_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 602,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::components_end", NM="_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder14components_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder14components_endEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ VTableComponent> components_end() /*const*/ {
    return Components.rend$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::getVCallOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 604,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::getVCallOffsets", NM="_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder15getVCallOffsetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder15getVCallOffsetsEv")
  //</editor-fold>
  public /*const*/ VCallOffsetMap /*&*/ getVCallOffsets() /*const*/ {
    return VCallOffsets;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::getVBaseOffsetOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 605,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::getVBaseOffsetOffsets", NM="_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder21getVBaseOffsetOffsetsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_126VCallAndVBaseOffsetBuilder21getVBaseOffsetOffsetsEv")
  //</editor-fold>
  public /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ getVBaseOffsetOffsets() /*const*/ {
    return VBaseOffsetOffsets;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallAndVBaseOffsetBuilder::~VCallAndVBaseOffsetBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 533,
   FQN="(anonymous namespace)::VCallAndVBaseOffsetBuilder::~VCallAndVBaseOffsetBuilder", NM="_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_126VCallAndVBaseOffsetBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VBaseOffsetOffsets.$destroy();
    VCallOffsets.$destroy();
    VisitedVirtualBases.$destroy();
    Components.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "MostDerivedClass=" + MostDerivedClass // NOI18N
              + ", LayoutClass=" + LayoutClass // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", Components=" + Components // NOI18N
              + ", VisitedVirtualBases=" + VisitedVirtualBases // NOI18N
              + ", VCallOffsets=" + VCallOffsets // NOI18N
              + ", VBaseOffsetOffsets=" + VBaseOffsetOffsets // NOI18N
              + ", Overriders=" + Overriders; // NOI18N
  }
}
