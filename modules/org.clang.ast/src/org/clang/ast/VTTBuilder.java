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

package org.clang.ast;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;

/// \brief Class for building VTT layout information.
//<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTTBuilder.h", line = 67,
 FQN="clang::VTTBuilder", NM="_ZN5clang10VTTBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang10VTTBuilderE")
//</editor-fold>
public class VTTBuilder implements Destructors.ClassWithDestructor {
  
  private final ASTContext /*&*/ Ctx;
  
  /// \brief The most derived class for which we're building this vtable.
  private /*const*/ CXXRecordDecl /*P*/ MostDerivedClass;
  
  /*typedef SmallVector<VTTVTable, 64> VTTVTablesVectorTy*/
//  public final class VTTVTablesVectorTy extends SmallVector<VTTVTable>{ };
  
  /// \brief The VTT vtables.
  private SmallVector<VTTVTable> VTTVTables;
  
  /*typedef SmallVector<VTTComponent, 64> VTTComponentsVectorTy*/
//  public final class VTTComponentsVectorTy extends SmallVector<VTTComponent>{ };
  
  /// \brief The VTT components.
  private SmallVector<VTTComponent> VTTComponents;
  
  /// \brief The AST record layout of the most derived class.
  private final /*const*/ ASTRecordLayout /*&*/ MostDerivedClassLayout;
  
  /*typedef llvm::SmallPtrSet<const CXXRecordDecl *, 4> VisitedVirtualBasesSetTy*/
//  public final class VisitedVirtualBasesSetTy extends SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >{ };
  
  /*typedef llvm::DenseMap<BaseSubobject, uint64_t> AddressPointsMapTy*/
//  public final class AddressPointsMapTy extends DenseMapTypeULong<BaseSubobject>{ };
  
  /// \brief The sub-VTT indices for the bases of the most derived class.
  private DenseMapTypeULong<BaseSubobject> SubVTTIndicies;
  
  /// \brief The secondary virtual pointer indices of all subobjects of
  /// the most derived class.
  private DenseMapTypeULong<BaseSubobject> SecondaryVirtualPointerIndices;
  
  /// \brief Whether the VTT builder should generate LLVM IR for the VTT.
  private boolean GenerateDefinition;
  
  /// \brief Add a vtable pointer to the VTT currently being built.
  
  /// \brief Add a vtable pointer to the VTT currently being built.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::AddVTablePointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp", line = 39,
   FQN="clang::VTTBuilder::AddVTablePointer", NM="_ZN5clang10VTTBuilder16AddVTablePointerENS_13BaseSubobjectEyPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang10VTTBuilder16AddVTablePointerENS_13BaseSubobjectEyPKNS_13CXXRecordDeclE")
  //</editor-fold>
  private void AddVTablePointer(BaseSubobject Base, long/*uint64_t*/ VTableIndex, 
                  /*const*/ CXXRecordDecl /*P*/ VTableClass) {
    // Store the vtable pointer index if we're generating the primary VTT.
    if (VTableClass == MostDerivedClass) {
      assert (!(SecondaryVirtualPointerIndices.count(Base) != 0)) : "A virtual pointer index already exists for this base subobject!";
      SecondaryVirtualPointerIndices.$set(Base, $uint2ullong(VTTComponents.size()));
    }
    if (!GenerateDefinition) {
      VTTComponents.push_back(new VTTComponent());
      return;
    }
    
    VTTComponents.push_back(new VTTComponent(VTableIndex, new BaseSubobject(Base)));
  }


  
  /// \brief Lay out the secondary VTTs of the given base subobject.
  
  /// \brief Lay out the secondary VTTs of the given base subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::LayoutSecondaryVTTs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp", line = 56,
   FQN="clang::VTTBuilder::LayoutSecondaryVTTs", NM="_ZN5clang10VTTBuilder19LayoutSecondaryVTTsENS_13BaseSubobjectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang10VTTBuilder19LayoutSecondaryVTTsENS_13BaseSubobjectE")
  //</editor-fold>
  private void LayoutSecondaryVTTs(BaseSubobject Base) {
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      // Don't layout virtual bases.
      if (I.isVirtual()) {
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(I.getType().$arrow().getAs$RecordType().getDecl());
      
      final /*const*/ ASTRecordLayout /*&*/ Layout = Ctx.getASTRecordLayout(RD);
      CharUnits BaseOffset = Base.getBaseOffset().$add(
          Layout.getBaseClassOffset(BaseDecl)
      );
      
      // Layout the VTT for this base.
      LayoutVTT(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), /*BaseIsVirtual=*/ false);
    }
  }


  
  /// \brief Lay out the secondary virtual pointers for the given base
  /// subobject.
  ///
  /// \param BaseIsMorallyVirtual whether the base subobject is a virtual base
  /// or a direct or indirect base of a virtual base.
  
  /// \brief Lay out the secondary virtual pointers for the given base
  /// subobject.
  ///
  /// \param BaseIsMorallyVirtual whether the base subobject is a virtual base
  /// or a direct or indirect base of a virtual base.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::LayoutSecondaryVirtualPointers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp", line = 76,
   FQN="clang::VTTBuilder::LayoutSecondaryVirtualPointers", NM="_ZN5clang10VTTBuilder30LayoutSecondaryVirtualPointersENS_13BaseSubobjectEbyPKNS_13CXXRecordDeclERN4llvm11SmallPtrSetIS4_Lj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang10VTTBuilder30LayoutSecondaryVirtualPointersENS_13BaseSubobjectEbyPKNS_13CXXRecordDeclERN4llvm11SmallPtrSetIS4_Lj4EEE")
  //</editor-fold>
  private void LayoutSecondaryVirtualPointers(BaseSubobject Base, 
                                boolean BaseIsMorallyVirtual, 
                                long/*uint64_t*/ VTableIndex, 
                                /*const*/ CXXRecordDecl /*P*/ VTableClass, 
                                final SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > /*&*/ VBases) {
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    
    // We're not interested in bases that don't have virtual bases, and not
    // morally virtual bases.
    if (!(RD.getNumVBases() != 0) && !BaseIsMorallyVirtual) {
      return;
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(I.getType().$arrow().getAs$RecordType().getDecl());
      
      // Itanium C++ ABI 2.6.2:
      //   Secondary virtual pointers are present for all bases with either
      //   virtual bases or virtual function declarations overridden along a 
      //   virtual path.
      //
      // If the base class is not dynamic, we don't want to add it, nor any
      // of its base classes.
      if (!BaseDecl.isDynamicClass()) {
        continue;
      }
      
      boolean BaseDeclIsMorallyVirtual = BaseIsMorallyVirtual;
      boolean BaseDeclIsNonVirtualPrimaryBase = false;
      CharUnits BaseOffset/*J*/= new CharUnits();
      if (I.isVirtual()) {
        // Ignore virtual bases that we've already visited.
        if (!VBases.insert(BaseDecl).second) {
          continue;
        }
        
        BaseOffset.$assignMove(MostDerivedClassLayout.getVBaseClassOffset(BaseDecl));
        BaseDeclIsMorallyVirtual = true;
      } else {
        final /*const*/ ASTRecordLayout /*&*/ Layout = Ctx.getASTRecordLayout(RD);
        
        BaseOffset.$assignMove(Base.getBaseOffset().$add(
                Layout.getBaseClassOffset(BaseDecl)
            ));
        if (!Layout.isPrimaryBaseVirtual()
           && Layout.getPrimaryBase() == BaseDecl) {
          BaseDeclIsNonVirtualPrimaryBase = true;
        }
      }
      
      // Itanium C++ ABI 2.6.2:
      //   Secondary virtual pointers: for each base class X which (a) has virtual
      //   bases or is reachable along a virtual path from D, and (b) is not a
      //   non-virtual primary base, the address of the virtual table for X-in-D
      //   or an appropriate construction virtual table.
      if (!BaseDeclIsNonVirtualPrimaryBase
         && ((BaseDecl.getNumVBases() != 0) || BaseDeclIsMorallyVirtual)) {
        // Add the vtable pointer.
        AddVTablePointer(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), VTableIndex, 
            VTableClass);
      }
      
      // And lay out the secondary virtual pointers for the base class.
      LayoutSecondaryVirtualPointers(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), 
          BaseDeclIsMorallyVirtual, VTableIndex, 
          VTableClass, VBases);
    }
  }


  
  /// \brief Lay out the secondary virtual pointers for the given base
  /// subobject.
  
  /// \brief Lay out the secondary virtual pointers for the given base
  /// subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::LayoutSecondaryVirtualPointers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp", line = 143,
   FQN="clang::VTTBuilder::LayoutSecondaryVirtualPointers", NM="_ZN5clang10VTTBuilder30LayoutSecondaryVirtualPointersENS_13BaseSubobjectEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang10VTTBuilder30LayoutSecondaryVirtualPointersENS_13BaseSubobjectEy")
  //</editor-fold>
  private void LayoutSecondaryVirtualPointers(BaseSubobject Base, 
                                long/*uint64_t*/ VTableIndex) {
    SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VBases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    LayoutSecondaryVirtualPointers(new BaseSubobject(Base), /*BaseIsMorallyVirtual=*/ false, 
        VTableIndex, Base.getBase(), VBases);
  }


  
  /// \brief Lay out the VTTs for the virtual base classes of the given
  /// record declaration.
  
  /// \brief Lay out the VTTs for the virtual base classes of the given
  /// record declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::LayoutVirtualVTTs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp", line = 151,
   FQN="clang::VTTBuilder::LayoutVirtualVTTs", NM="_ZN5clang10VTTBuilder17LayoutVirtualVTTsEPKNS_13CXXRecordDeclERN4llvm11SmallPtrSetIS3_Lj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang10VTTBuilder17LayoutVirtualVTTsEPKNS_13CXXRecordDeclERN4llvm11SmallPtrSetIS3_Lj4EEE")
  //</editor-fold>
  private void LayoutVirtualVTTs(/*const*/ CXXRecordDecl /*P*/ RD, 
                   final SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > /*&*/ VBases) {
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(I.getType().$arrow().getAs$RecordType().getDecl());
      
      // Check if this is a virtual base.
      if (I.isVirtual()) {
        // Check if we've seen this base before.
        if (!VBases.insert(BaseDecl).second) {
          continue;
        }
        
        CharUnits BaseOffset = MostDerivedClassLayout.getVBaseClassOffset(BaseDecl);
        
        LayoutVTT(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), /*BaseIsVirtual=*/ true);
      }
      
      // We only need to layout virtual VTTs for this base if it actually has
      // virtual bases.
      if ((BaseDecl.getNumVBases() != 0)) {
        LayoutVirtualVTTs(BaseDecl, VBases);
      }
    }
  }


  
  /// \brief Lay out the VTT for the given subobject, including any
  /// secondary VTTs, secondary virtual pointers and virtual VTTs.
  
  /// \brief Lay out the VTT for the given subobject, including any
  /// secondary VTTs, secondary virtual pointers and virtual VTTs.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::LayoutVTT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp", line = 176,
   FQN="clang::VTTBuilder::LayoutVTT", NM="_ZN5clang10VTTBuilder9LayoutVTTENS_13BaseSubobjectEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang10VTTBuilder9LayoutVTTENS_13BaseSubobjectEb")
  //</editor-fold>
  private void LayoutVTT(BaseSubobject Base, boolean BaseIsVirtual) {
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    
    // Itanium C++ ABI 2.6.2:
    //   An array of virtual table addresses, called the VTT, is declared for 
    //   each class type that has indirect or direct virtual base classes.
    if (RD.getNumVBases() == 0) {
      return;
    }
    
    boolean IsPrimaryVTT = Base.getBase() == MostDerivedClass;
    if (!IsPrimaryVTT) {
      // Remember the sub-VTT index.
      SubVTTIndicies.$set(Base, $uint2ullong(VTTComponents.size()));
    }
    
    long/*uint64_t*/ VTableIndex = $uint2ulong(VTTVTables.size());
    VTTVTables.push_back(new VTTVTable(new BaseSubobject(Base), BaseIsVirtual));
    
    // Add the primary vtable pointer.
    AddVTablePointer(new BaseSubobject(Base), VTableIndex, RD);
    
    // Add the secondary VTTs.
    LayoutSecondaryVTTs(new BaseSubobject(Base));
    
    // Add the secondary virtual pointers.
    LayoutSecondaryVirtualPointers(new BaseSubobject(Base), VTableIndex);
    
    // If this is the primary VTT, we want to lay out virtual VTTs as well.
    if (IsPrimaryVTT) {
      SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VBases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
      LayoutVirtualVTTs(Base.getBase(), VBases);
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::VTTBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp", line = 28,
   FQN="clang::VTTBuilder::VTTBuilder", NM="_ZN5clang10VTTBuilderC1ERNS_10ASTContextEPKNS_13CXXRecordDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang10VTTBuilderC1ERNS_10ASTContextEPKNS_13CXXRecordDeclEb")
  //</editor-fold>
  public VTTBuilder(final ASTContext /*&*/ Ctx, 
      /*const*/ CXXRecordDecl /*P*/ MostDerivedClass, 
      boolean GenerateDefinition) {
    // : Ctx(Ctx), MostDerivedClass(MostDerivedClass), VTTVTables(), VTTComponents(), MostDerivedClassLayout(Ctx.getASTRecordLayout(MostDerivedClass)), SubVTTIndicies(), SecondaryVirtualPointerIndices(), GenerateDefinition(GenerateDefinition) 
    //START JInit
    this./*&*/Ctx=/*&*/Ctx;
    this.MostDerivedClass = MostDerivedClass;
    this.VTTVTables = new SmallVector<VTTVTable>(64, new VTTVTable());
    this.VTTComponents = new SmallVector<VTTComponent>(64, new VTTComponent());
    this./*&*/MostDerivedClassLayout=/*&*/Ctx.getASTRecordLayout(MostDerivedClass);
    this.SubVTTIndicies = new DenseMapTypeULong<BaseSubobject>(DenseMapInfoBaseSubobject.$Info(), 0);
    this.SecondaryVirtualPointerIndices = new DenseMapTypeULong<BaseSubobject>(DenseMapInfoBaseSubobject.$Info(), 0);
    this.GenerateDefinition = GenerateDefinition;
    //END JInit
    // Lay out this VTT.
    LayoutVTT(new BaseSubobject(MostDerivedClass, CharUnits.Zero()), 
        /*BaseIsVirtual=*/ false);
  }


  
  // \brief Returns a reference to the VTT components.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::getVTTComponents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTTBuilder.h", line = 138,
   FQN="clang::VTTBuilder::getVTTComponents", NM="_ZNK5clang10VTTBuilder16getVTTComponentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZNK5clang10VTTBuilder16getVTTComponentsEv")
  //</editor-fold>
  public /*const*/SmallVector<VTTComponent> /*&*/ getVTTComponents() /*const*/ {
    return VTTComponents;
  }

  
  // \brief Returns a reference to the VTT vtables.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::getVTTVTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTTBuilder.h", line = 143,
   FQN="clang::VTTBuilder::getVTTVTables", NM="_ZNK5clang10VTTBuilder13getVTTVTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZNK5clang10VTTBuilder13getVTTVTablesEv")
  //</editor-fold>
  public /*const*/SmallVector<VTTVTable> /*&*/ getVTTVTables() /*const*/ {
    return VTTVTables;
  }

  
  /// \brief Returns a reference to the sub-VTT indices.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::getSubVTTIndicies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTTBuilder.h", line = 148,
   FQN="clang::VTTBuilder::getSubVTTIndicies", NM="_ZNK5clang10VTTBuilder17getSubVTTIndiciesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZNK5clang10VTTBuilder17getSubVTTIndiciesEv")
  //</editor-fold>
  public /*const*/DenseMapTypeULong<BaseSubobject> /*&*/ getSubVTTIndicies() /*const*/ {
    return SubVTTIndicies;
  }

  
  /// \brief Returns a reference to the secondary virtual pointer indices.
  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::getSecondaryVirtualPointerIndices">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTTBuilder.h", line = 153,
   FQN="clang::VTTBuilder::getSecondaryVirtualPointerIndices", NM="_ZNK5clang10VTTBuilder33getSecondaryVirtualPointerIndicesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZNK5clang10VTTBuilder33getSecondaryVirtualPointerIndicesEv")
  //</editor-fold>
  public /*const*/DenseMapTypeULong<BaseSubobject> /*&*/ getSecondaryVirtualPointerIndices() /*const*/ {
    return SecondaryVirtualPointerIndices;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VTTBuilder::~VTTBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTTBuilder.h", line = 67,
   FQN="clang::VTTBuilder::~VTTBuilder", NM="_ZN5clang10VTTBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTT.cpp -nm=_ZN5clang10VTTBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SecondaryVirtualPointerIndices.$destroy();
    SubVTTIndicies.$destroy();
    VTTComponents.$destroy();
    VTTVTables.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", MostDerivedClass=" + MostDerivedClass // NOI18N
              + ", VTTVTables=" + VTTVTables // NOI18N
              + ", VTTComponents=" + VTTComponents // NOI18N
              + ", MostDerivedClassLayout=" + MostDerivedClassLayout // NOI18N
              + ", SubVTTIndicies=" + SubVTTIndicies // NOI18N
              + ", SecondaryVirtualPointerIndices=" + SecondaryVirtualPointerIndices // NOI18N
              + ", GenerateDefinition=" + GenerateDefinition; // NOI18N
  }
}
