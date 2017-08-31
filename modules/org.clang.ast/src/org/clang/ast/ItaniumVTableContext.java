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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.impl.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.VTableBuilderStatics.CreateVTableLayout;

//<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 334,
 FQN="clang::ItaniumVTableContext", NM="_ZN5clang20ItaniumVTableContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContextE")
//</editor-fold>
public class ItaniumVTableContext extends /*public*/ VTableContextBase implements Destructors.ClassWithDestructor {
/*private:*/
  
  /// \brief Contains the index (relative to the vtable address point)
  /// where the function pointer for a virtual function is stored.
  /*typedef llvm::DenseMap<GlobalDecl, int64_t> MethodVTableIndicesTy*/
//  public final class MethodVTableIndicesTy extends DenseMapTypeLong<GlobalDecl>{ };
  private DenseMapTypeLong<GlobalDecl> MethodVTableIndices;
  
  /*typedef llvm::DenseMap<const CXXRecordDecl *, const VTableLayout *> VTableLayoutMapTy*/
//  public final class VTableLayoutMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , /*const*/ VTableLayout /*P*/ >{ };
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , /*const*/ VTableLayout /*P*/ > VTableLayouts;
  
  /*typedef std::pair<const CXXRecordDecl *, const CXXRecordDecl *> ClassPairTy*/
//  public final class ClassPairTy extends std.pair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >{ };
  
  /// \brief vtable offsets for offsets of virtual bases of a class.
  ///
  /// Contains the vtable offset (relative to the address point) in chars
  /// where the offsets for virtual bases of a class are stored.
  /*typedef llvm::DenseMap<ClassPairTy, CharUnits> VirtualBaseClassOffsetOffsetsMapTy*/
//  public final class VirtualBaseClassOffsetOffsetsMapTy extends DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >, CharUnits>{ };
  private DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >, CharUnits> VirtualBaseClassOffsetOffsets;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext::computeVTableRelatedInformation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2295,
   FQN="clang::ItaniumVTableContext::computeVTableRelatedInformation", NM="_ZN5clang20ItaniumVTableContext31computeVTableRelatedInformationEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContext31computeVTableRelatedInformationEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  @Override protected/*private*/ void computeVTableRelatedInformation(/*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    ItaniumVTableBuilder Builder = null;
    try {
      final type$ref</*const*/ VTableLayout /*P*/ /*&*/> Entry = VTableLayouts.ref$at(RD);
      
      // Check if we've computed this information before.
      if ((Entry.$deref() != null)) {
        return;
      }
      
      Builder/*J*/= new ItaniumVTableBuilder(/*Deref*/this, RD, CharUnits.Zero(), 
          /*MostDerivedClassIsVirtual=*/ false, RD);
      Entry.$set(CreateVTableLayout(Builder));
      
      MethodVTableIndices.insert(Builder.vtable_indices_begin(), 
          Builder.vtable_indices_end());
      
      // Add the known thunks.
      Thunks.insert(Builder.thunks_begin(), Builder.thunks_end());
      
      // If we don't have the vbase information for this class, insert it.
      // getVirtualBaseOffsetOffset will compute it separately without computing
      // the rest of the vtable related information.
      if (!(RD.getNumVBases() != 0)) {
        return;
      }
      
      /*const*/ CXXRecordDecl /*P*/ VBase = RD.vbases_begin$Const().$star().getType().$arrow().getAsCXXRecordDecl();
      if ((VirtualBaseClassOffsetOffsets.count(std.make_pair_Ptr_Ptr(RD, VBase)) != 0)) {
        return;
      }
      
      for (final /*const*/std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ I : Builder.getVBaseOffsetOffsets()) {
        // Insert all types.
        std.pair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ > ClassPair/*J*/= new std.pairPtrPtr</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >(JD$T$RR_T1$C$R.INSTANCE, RD, I.first);
        
        VirtualBaseClassOffsetOffsets.insert_pair$KeyT$ValueT(std.make_pair(ClassPair, I.second));
      }
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext::ItaniumVTableContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2234,
   FQN="clang::ItaniumVTableContext::ItaniumVTableContext", NM="_ZN5clang20ItaniumVTableContextC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContextC1ERNS_10ASTContextE")
  //</editor-fold>
  public ItaniumVTableContext(final ASTContext /*&*/ Context) {
    // : VTableContextBase(/*MS=*/ false), MethodVTableIndices(), VTableLayouts(), VirtualBaseClassOffsetOffsets() 
    //START JInit
    super(false);
    this.MethodVTableIndices = new DenseMapTypeLong<GlobalDecl>(DenseMapInfoGlobalDecl.$Info(), 0);
    this.VTableLayouts = new DenseMap</*const*/ CXXRecordDecl /*P*/ , /*const*/ VTableLayout /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ VTableLayout /*P*/ )null);
    this.VirtualBaseClassOffsetOffsets = new DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >, CharUnits>(new DenseMapInfoPair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), DenseMapInfo$LikePtr.$Info()), new CharUnits());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext::~ItaniumVTableContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2237,
   FQN="clang::ItaniumVTableContext::~ItaniumVTableContext", NM="_ZN5clang20ItaniumVTableContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContextD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    llvm.DeleteContainerSeconds(VTableLayouts);
    //START JDestroy
    VirtualBaseClassOffsetOffsets.$destroy();
    VTableLayouts.$destroy();
    MethodVTableIndices.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext::getVTableLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 363,
   FQN="clang::ItaniumVTableContext::getVTableLayout", NM="_ZN5clang20ItaniumVTableContext15getVTableLayoutEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContext15getVTableLayoutEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*const*/ VTableLayout /*&*/ getVTableLayout(/*const*/ CXXRecordDecl /*P*/ RD) {
    computeVTableRelatedInformation(RD);
    assert ((VTableLayouts.count(RD) != 0)) : "No layout for this record decl!";
    
    return $Deref(VTableLayouts.$at_T1$C$R(RD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext::createConstructionVTableLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2333,
   FQN="clang::ItaniumVTableContext::createConstructionVTableLayout", NM="_ZN5clang20ItaniumVTableContext30createConstructionVTableLayoutEPKNS_13CXXRecordDeclENS_9CharUnitsEbS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContext30createConstructionVTableLayoutEPKNS_13CXXRecordDeclENS_9CharUnitsEbS3_")
  //</editor-fold>
  public VTableLayout /*P*/ createConstructionVTableLayout(/*const*/ CXXRecordDecl /*P*/ MostDerivedClass, CharUnits MostDerivedClassOffset, 
                                boolean MostDerivedClassIsVirtual, /*const*/ CXXRecordDecl /*P*/ LayoutClass) {
    ItaniumVTableBuilder Builder = null;
    try {
      Builder/*J*/= new ItaniumVTableBuilder(/*Deref*/this, MostDerivedClass, new CharUnits(MostDerivedClassOffset), 
          MostDerivedClassIsVirtual, LayoutClass);
      return CreateVTableLayout(Builder);
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  /// \brief Locate a virtual function in the vtable.
  ///
  /// Return the index (relative to the vtable address point) where the
  /// function pointer for the given virtual function is stored.
  //<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext::getMethodVTableIndex">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2241,
   FQN="clang::ItaniumVTableContext::getMethodVTableIndex", NM="_ZN5clang20ItaniumVTableContext20getMethodVTableIndexENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContext20getMethodVTableIndexENS_10GlobalDeclE")
  //</editor-fold>
  public long/*uint64_t*/ getMethodVTableIndex(GlobalDecl GD) {
    DenseMapIteratorTypeLong<GlobalDecl> I = MethodVTableIndices.find(GD);
    if (I.$noteq(/*NO_ITER_COPY*/MethodVTableIndices.end())) {
      return I.$arrow().second;
    }
    
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXMethodDecl(GD.getDecl()).getParent$Const();
    
    computeVTableRelatedInformation(RD);
    
    I.$assignMove(MethodVTableIndices.find(GD));
    assert (I.$noteq(/*NO_ITER_COPY*/MethodVTableIndices.end())) : "Did not find index!";
    return I.$arrow().second;
  }

  
  /// Return the offset in chars (relative to the vtable address point) where
  /// the offset of the virtual base that contains the given base is stored,
  /// otherwise, if no virtual base contains the given class, return 0. 
  ///
  /// Base must be a virtual base class or an unambiguous base.
  //<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext::getVirtualBaseOffsetOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2255,
   FQN="clang::ItaniumVTableContext::getVirtualBaseOffsetOffset", NM="_ZN5clang20ItaniumVTableContext26getVirtualBaseOffsetOffsetEPKNS_13CXXRecordDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContext26getVirtualBaseOffsetOffsetEPKNS_13CXXRecordDeclES3_")
  //</editor-fold>
  public CharUnits getVirtualBaseOffsetOffset(/*const*/ CXXRecordDecl /*P*/ RD, 
                            /*const*/ CXXRecordDecl /*P*/ VBase) {
    VCallAndVBaseOffsetBuilder Builder = null;
    try {
      std.pair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ > ClassPair/*J*/= new std.pairPtrPtr</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, RD, VBase);
      
      DenseMapIterator<pair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >, CharUnits> I = VirtualBaseClassOffsetOffsets.find(ClassPair);
      if (I.$noteq(/*NO_ITER_COPY*/VirtualBaseClassOffsetOffsets.end())) {
        return new CharUnits(I.$arrow().second);
      }
      
      Builder/*J*/= new VCallAndVBaseOffsetBuilder(RD, RD, /*FinalOverriders=*/ (/*const*/ FinalOverriders /*P*/ )null, 
          new BaseSubobject(RD, CharUnits.Zero()), 
          /*BaseIsVirtual=*/ false, 
          /*OffsetInLayoutClass=*/ CharUnits.Zero());
      
      for (final /*const*/std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ I$1 : Builder.getVBaseOffsetOffsets()) {
        // Insert all types.
        std.pair</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ > ClassPair$1/*J*/= new std.pairPtrPtr</*const*/ CXXRecordDecl /*P*/ , /*const*/ CXXRecordDecl /*P*/ >(JD$T$RR_T1$C$R.INSTANCE, RD, I$1.first);
        
        VirtualBaseClassOffsetOffsets.insert_pair$KeyT$ValueT(std.make_pair(ClassPair$1, I$1.second));
      }
      
      I.$assignMove(VirtualBaseClassOffsetOffsets.find(ClassPair));
      assert (I.$noteq(/*NO_ITER_COPY*/VirtualBaseClassOffsetOffsets.end())) : "Did not find index!";
      
      return new CharUnits(I.$arrow().second);
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ItaniumVTableContext::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 390,
   FQN="clang::ItaniumVTableContext::classof", NM="_ZN5clang20ItaniumVTableContext7classofEPKNS_17VTableContextBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang20ItaniumVTableContext7classofEPKNS_17VTableContextBaseE")
  //</editor-fold>
  public static boolean classof(/*const*/ VTableContextBase /*P*/ VT) {
    return !VT.isMicrosoft();
  }

  
  @Override public String toString() {
    return "" + "MethodVTableIndices=" + MethodVTableIndices // NOI18N
              + ", VTableLayouts=" + VTableLayouts // NOI18N
              + ", VirtualBaseClassOffsetOffsets=" + VirtualBaseClassOffsetOffsets // NOI18N
              + super.toString(); // NOI18N
  }
}
