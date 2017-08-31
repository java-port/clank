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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.impl.VTableBuilderStatics.*;


/// FinalOverriders - Contains the final overrider member functions for all
/// member functions in the base subobjects of a class.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 62,
 FQN="(anonymous namespace)::FinalOverriders", NM="_ZN12_GLOBAL__N_115FinalOverridersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverridersE")
//</editor-fold>
public class FinalOverriders implements Destructors.ClassWithDestructor {
/*public:*/
  /// OverriderInfo - Information about a final overrider.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::OverriderInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 65,
   FQN="(anonymous namespace)::FinalOverriders::OverriderInfo", NM="_ZN12_GLOBAL__N_115FinalOverriders13OverriderInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverriders13OverriderInfoE")
  //</editor-fold>
  public static class/*struct*/ OverriderInfo implements NativeCloneable<OverriderInfo>, NativeMoveable<OverriderInfo> {
    /// Method - The method decl of the overrider.
    public /*const*/ CXXMethodDecl /*P*/ Method;
    
    /// VirtualBase - The virtual base class subobject of this overrider.
    /// Note that this records the closest derived virtual base class subobject.
    public /*const*/ CXXRecordDecl /*P*/ VirtualBase;
    
    /// Offset - the base offset of the overrider's parent in the layout class.
    public CharUnits Offset;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::OverriderInfo::OverriderInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 76,
     FQN="(anonymous namespace)::FinalOverriders::OverriderInfo::OverriderInfo", NM="_ZN12_GLOBAL__N_115FinalOverriders13OverriderInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverriders13OverriderInfoC1Ev")
    //</editor-fold>
    public OverriderInfo() {
      // : Method(null), VirtualBase(null), Offset(CharUnits::Zero()) 
      //START JInit
      this.Method = null;
      this.VirtualBase = null;
      this.Offset = CharUnits.Zero();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::OverriderInfo::OverriderInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 65,
     FQN="(anonymous namespace)::FinalOverriders::OverriderInfo::OverriderInfo", NM="_ZN12_GLOBAL__N_115FinalOverriders13OverriderInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverriders13OverriderInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ OverriderInfo(final /*const*/ OverriderInfo /*&*/ $Prm0) {
      // : Method(.Method), VirtualBase(.VirtualBase), Offset(.Offset) 
      //START JInit
      this.Method = $Prm0.Method;
      this.VirtualBase = $Prm0.VirtualBase;
      this.Offset = new CharUnits($Prm0.Offset);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::OverriderInfo::OverriderInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 65,
     FQN="(anonymous namespace)::FinalOverriders::OverriderInfo::OverriderInfo", NM="_ZN12_GLOBAL__N_115FinalOverriders13OverriderInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverriders13OverriderInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ OverriderInfo(JD$Move _dparam, final OverriderInfo /*&&*/$Prm0) {
      // : Method(static_cast<OverriderInfo &&>().Method), VirtualBase(static_cast<OverriderInfo &&>().VirtualBase), Offset(static_cast<OverriderInfo &&>().Offset) 
      //START JInit
      this.Method = $Prm0.Method;
      this.VirtualBase = $Prm0.VirtualBase;
      this.Offset = new CharUnits(JD$Move.INSTANCE, $Prm0.Offset);
      //END JInit
    }

    @Override public OverriderInfo clone() {
      return new OverriderInfo(this);
    }

    @Override public OverriderInfo move() {
      return new OverriderInfo(JD$Move.INSTANCE, this);
    }

    
    @Override public String toString() {
      return "" + "Method=" + Method // NOI18N
                + ", VirtualBase=" + VirtualBase // NOI18N
                + ", Offset=" + Offset; // NOI18N
    }
  };
/*private:*/
  /// MostDerivedClass - The most derived class for which the final overriders
  /// are stored.
  private /*const*/ CXXRecordDecl /*P*/ MostDerivedClass;
  
  /// MostDerivedClassOffset - If we're building final overriders for a 
  /// construction vtable, this holds the offset from the layout class to the
  /// most derived class.
  private /*const*/ CharUnits MostDerivedClassOffset;
  
  /// LayoutClass - The class we're using for layout information. Will be 
  /// different than the most derived class if the final overriders are for a
  /// construction vtable.  
  private /*const*/ CXXRecordDecl /*P*/ LayoutClass;
  
  private final ASTContext /*&*/ Context;
  
  /// MostDerivedClassLayout - the AST record layout of the most derived class.
  private final /*const*/ ASTRecordLayout /*&*/ MostDerivedClassLayout;
  
  /// MethodBaseOffsetPairTy - Uniquely identifies a member function
  /// in a base subobject.
  /*typedef std::pair<const CXXMethodDecl *, CharUnits> MethodBaseOffsetPairTy*/
//  public final class MethodBaseOffsetPairTy extends std.pair</*const*/ CXXMethodDecl /*P*/ , CharUnits>{ };
  
  /*typedef llvm::DenseMap<MethodBaseOffsetPairTy, OverriderInfo> OverridersMapTy*/
//  public final class OverridersMapTy extends DenseMap<std.pair</*const*/ CXXMethodDecl /*P*/ , CharUnits>, OverriderInfo>{ };
  
  /// OverridersMap - The final overriders for all virtual member functions of 
  /// all the base subobjects of the most derived class.
  private DenseMap<std.pair</*const*/ CXXMethodDecl /*P*/ , CharUnits>, OverriderInfo> OverridersMap;
  
  /// SubobjectsToOffsetsMapTy - A mapping from a base subobject (represented
  /// as a record decl and a subobject number) and its offsets in the most
  /// derived class as well as the layout class.
  /*typedef llvm::DenseMap<std::pair<const CXXRecordDecl *, unsigned int>, CharUnits> SubobjectOffsetMapTy*/
//  public final class SubobjectOffsetMapTy extends DenseMap<std.pairTypeUInt</*const*/ CXXRecordDecl /*P*/ >, CharUnits>{ };
  
  /*typedef llvm::DenseMap<const CXXRecordDecl *, unsigned int> SubobjectCountMapTy*/
//  public final class SubobjectCountMapTy extends DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ >{ };
  
  /// ComputeBaseOffsets - Compute the offsets for all base subobjects of the
  /// given base.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::ComputeBaseOffsets">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 324,
   FQN="(anonymous namespace)::FinalOverriders::ComputeBaseOffsets", NM="_ZN12_GLOBAL__N_115FinalOverriders18ComputeBaseOffsetsEN5clang13BaseSubobjectEbNS1_9CharUnitsERN4llvm8DenseMapISt4pairIPKNS1_13CXXRecordDeclEjES3_NS4_12DenseMapInfoISA_EENS4_6detail12DenseMapPairISA_S3_EEEESH_RNS5_IS9_jNSB_IS9_EENSE_IS9_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverriders18ComputeBaseOffsetsEN5clang13BaseSubobjectEbNS1_9CharUnitsERN4llvm8DenseMapISt4pairIPKNS1_13CXXRecordDeclEjES3_NS4_12DenseMapInfoISA_EENS4_6detail12DenseMapPairISA_S3_EEEESH_RNS5_IS9_jNSB_IS9_EENSE_IS9_jEEEE")
  //</editor-fold>
  private void ComputeBaseOffsets(BaseSubobject Base, boolean IsVirtual, 
                    CharUnits OffsetInLayoutClass, 
                    final DenseMap<std.pairTypeUInt</*const*/ CXXRecordDecl /*P*/ >, CharUnits> /*&*/ SubobjectOffsets, 
                    final DenseMap<std.pairTypeUInt</*const*/ CXXRecordDecl /*P*/ >, CharUnits> /*&*/ SubobjectLayoutClassOffsets, 
                    final DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ > /*&*/ SubobjectCounts) {
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    
    /*uint*/int SubobjectNumber = 0;
    if (!IsVirtual) {
      SubobjectNumber = SubobjectCounts.ref$at(RD).$set$preInc();
    }
    
    // Set up the subobject to offset mapping.
    assert (!(SubobjectOffsets.count(std.make_pair_Ptr_uint(RD, SubobjectNumber)) != 0)) : "Subobject offset already exists!";
    assert (!(SubobjectLayoutClassOffsets.count(std.make_pair_Ptr_uint(RD, SubobjectNumber)) != 0)) : "Subobject offset already exists!";
    
    SubobjectOffsets.$at_T1$RR(std.make_pair_Ptr_uint(RD, SubobjectNumber)).$assignMove(Base.getBaseOffset());
    SubobjectLayoutClassOffsets.$at_T1$RR(std.make_pair_Ptr_uint(RD, SubobjectNumber)).$assign(
        OffsetInLayoutClass
    );
    
    // Traverse our bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = B.getType().$arrow().getAsCXXRecordDecl();
      
      CharUnits BaseOffset/*J*/= new CharUnits();
      CharUnits BaseOffsetInLayoutClass/*J*/= new CharUnits();
      if (B.isVirtual()) {
        // Check if we've visited this virtual base before.
        if ((SubobjectOffsets.count(std.make_pair_Ptr_uint(BaseDecl, 0)) != 0)) {
          continue;
        }
        
        final /*const*/ ASTRecordLayout /*&*/ LayoutClassLayout = Context.getASTRecordLayout(LayoutClass);
        
        BaseOffset.$assignMove(MostDerivedClassLayout.getVBaseClassOffset(BaseDecl));
        BaseOffsetInLayoutClass.$assignMove(
            LayoutClassLayout.getVBaseClassOffset(BaseDecl)
        );
      } else {
        final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
        CharUnits Offset = Layout.getBaseClassOffset(BaseDecl);
        
        BaseOffset.$assignMove(Base.getBaseOffset().$add(Offset));
        BaseOffsetInLayoutClass.$assignMove(OffsetInLayoutClass.$add(Offset));
      }
      
      ComputeBaseOffsets(new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), 
          B.isVirtual(), new CharUnits(BaseOffsetInLayoutClass), 
          SubobjectOffsets, SubobjectLayoutClassOffsets, 
          SubobjectCounts);
    }
  }

  
  /*typedef llvm::SmallPtrSet<const CXXRecordDecl *, 4> VisitedVirtualBasesSetTy*/
//  public final class VisitedVirtualBasesSetTy extends SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >{ };
  
  /// dump - dump the final overriders for a base subobject, and all its direct
  /// and indirect base subobjects.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 378,
   FQN="(anonymous namespace)::FinalOverriders::dump", NM="_ZN12_GLOBAL__N_115FinalOverriders4dumpERN4llvm11raw_ostreamEN5clang13BaseSubobjectERNS1_11SmallPtrSetIPKNS4_13CXXRecordDeclELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverriders4dumpERN4llvm11raw_ostreamEN5clang13BaseSubobjectERNS1_11SmallPtrSetIPKNS4_13CXXRecordDeclELj4EEE")
  //</editor-fold>
  private void dump(final raw_ostream /*&*/ Out, BaseSubobject Base, 
      final SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > /*&*/ VisitedVirtualBases) {
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = B.getType().$arrow().getAsCXXRecordDecl();
      
      // Ignore bases that don't have any virtual member functions.
      if (!BaseDecl.isPolymorphic()) {
        continue;
      }
      
      CharUnits BaseOffset/*J*/= new CharUnits();
      if (B.isVirtual()) {
        if (!VisitedVirtualBases.insert(BaseDecl).second) {
          // We've visited this base before.
          continue;
        }
        
        BaseOffset.$assignMove(MostDerivedClassLayout.getVBaseClassOffset(BaseDecl));
      } else {
        BaseOffset.$assignMove(Layout.getBaseClassOffset(BaseDecl).$add(Base.getBaseOffset()));
      }
      
      dump(Out, new BaseSubobject(BaseDecl, new CharUnits(BaseOffset)), VisitedVirtualBases);
    }
    
    Out.$out(/*KEEP_STR*/"Final overriders for (");
    RD.printQualifiedName(Out);
    Out.$out(/*KEEP_STR*/$COMMA_SPACE);
    Out.$out_llong(Base.getBaseOffset().getQuantity()).$out(/*KEEP_STR*/")\n");
    
    // Now dump the overriders for this base subobject.
    for (/*const*/ CXXMethodDecl /*P*/ MD : RD.methods()) {
      if (!MD.isVirtual()) {
        continue;
      }
      MD = MD.getCanonicalDecl$Const();
      
      OverriderInfo Overrider = getOverrider(MD, Base.getBaseOffset());
      
      Out.$out(/*KEEP_STR*/"  ");
      MD.printQualifiedName(Out);
      Out.$out(/*KEEP_STR*/" - (");
      Overrider.Method.printQualifiedName(Out);
      Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_llong(Overrider.Offset.getQuantity()).$out_char($$RPAREN);
      
      BaseOffset Offset/*J*/= new BaseOffset();
      if (!Overrider.Method.isPure()) {
        Offset.$assignMove(ComputeReturnAdjustmentBaseOffset(Context, Overrider.Method, MD));
      }
      if (!Offset.isEmpty()) {
        Out.$out(/*KEEP_STR*/" [ret-adj: ");
        if ((Offset.VirtualBase != null)) {
          Offset.VirtualBase.printQualifiedName(Out);
          Out.$out(/*KEEP_STR*/" vbase, ");
        }
        
        Out.$out_llong(Offset.NonVirtualOffset.getQuantity()).$out(/*KEEP_STR*/" nv]");
      }
      
      Out.$out(/*KEEP_STR*/$LF);
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::FinalOverriders">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 158,
   FQN="(anonymous namespace)::FinalOverriders::FinalOverriders", NM="_ZN12_GLOBAL__N_115FinalOverridersC1EPKN5clang13CXXRecordDeclENS1_9CharUnitsES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverridersC1EPKN5clang13CXXRecordDeclENS1_9CharUnitsES4_")
  //</editor-fold>
  public FinalOverriders(/*const*/ CXXRecordDecl /*P*/ MostDerivedClass, 
      CharUnits MostDerivedClassOffset, 
      /*const*/ CXXRecordDecl /*P*/ LayoutClass) {
    // : MostDerivedClass(MostDerivedClass), MostDerivedClassOffset(MostDerivedClassOffset), LayoutClass(LayoutClass), Context(MostDerivedClass->getASTContext()), MostDerivedClassLayout(Context.getASTRecordLayout(MostDerivedClass)), OverridersMap() 
    //START JInit
    this.MostDerivedClass = MostDerivedClass;
    this.MostDerivedClassOffset = new CharUnits(MostDerivedClassOffset);
    this.LayoutClass = LayoutClass;
    this./*&*/Context=/*&*/MostDerivedClass.getASTContext();
    this./*&*/MostDerivedClassLayout=/*&*/Context.getASTRecordLayout(MostDerivedClass);
    this.OverridersMap = new DenseMap<std.pair</*const*/ CXXMethodDecl /*P*/ , CharUnits>, OverriderInfo>(
            new DenseMapInfoPair(DenseMapInfo$LikePtr.$Info(), DenseMapInfoCharUnits.$Info()), new OverriderInfo());
    //END JInit
    CXXFinalOverriderMap FinalOverriders = null;
    try {
      
      // Compute base offsets.
      DenseMap<std.pairTypeUInt</*const*/ CXXRecordDecl /*P*/ >, CharUnits> SubobjectOffsets/*J*/= new DenseMap<std.pairTypeUInt</*const*/ CXXRecordDecl /*P*/ >, CharUnits>(DenseMapInfoPairTypePtrUInt.$Info(), new CharUnits());
      DenseMap<std.pairTypeUInt</*const*/ CXXRecordDecl /*P*/ >, CharUnits> SubobjectLayoutClassOffsets/*J*/= new DenseMap<std.pairTypeUInt</*const*/ CXXRecordDecl /*P*/ >, CharUnits>(DenseMapInfoPairTypePtrUInt.$Info(), new CharUnits());
      DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ > SubobjectCounts/*J*/= new DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
      ComputeBaseOffsets(new BaseSubobject(MostDerivedClass, CharUnits.Zero()), 
          /*IsVirtual=*/ false, 
          new CharUnits(MostDerivedClassOffset), 
          SubobjectOffsets, SubobjectLayoutClassOffsets, 
          SubobjectCounts);
      
      // Get the final overriders.
      FinalOverriders/*J*/= new CXXFinalOverriderMap();
      MostDerivedClass.getFinalOverriders(FinalOverriders);
      
      for (final /*const*/ pair</*const*/ CXXMethodDecl /*P*/ , OverridingMethods> /*&*/ Overrider : FinalOverriders) {
        /*const*/ CXXMethodDecl /*P*/ MD = Overrider.first;
        final /*const*/ OverridingMethods /*&*/ Methods = Overrider.second;
        
        for (final /*const*/std.pairUIntType<SmallVector<UniqueVirtualMethod>> /*&*/ M : Methods) {
          /*uint*/int SubobjectNumber = M.first;
          assert ((SubobjectOffsets.count(std.make_pair_Ptr_uint(MD.getParent$Const(), SubobjectNumber)) != 0)) : "Did not find subobject offset!";
          
          CharUnits BaseOffset = new CharUnits(SubobjectOffsets.$at_T1$RR(std.make_pair_Ptr_uint(MD.getParent$Const(), 
                      SubobjectNumber)));
          assert (M.second.size() == 1) : "Final overrider is not unique!";
          final /*const*/ UniqueVirtualMethod /*&*/ Method = M.second.front$Const();
          
          /*const*/ CXXRecordDecl /*P*/ OverriderRD = Method.Method.getParent();
          assert ((SubobjectLayoutClassOffsets.count(std.make_pair_Ptr_uint(OverriderRD, Method.Subobject)) != 0)) : "Did not find subobject offset!";
          CharUnits OverriderOffset = new CharUnits(SubobjectLayoutClassOffsets.$at_T1$RR(std.make_pair_Ptr_uint(OverriderRD, 
                      Method.Subobject)));
          
          final OverriderInfo /*&*/ Overrider$1 = OverridersMap.$at_T1$RR(std.make_pair_Ptr_T(MD, BaseOffset));
          assert (!(Overrider$1.Method != null)) : "Overrider should not exist yet!";
          
          Overrider$1.Offset.$assign(OverriderOffset);
          Overrider$1.Method = Method.Method;
          Overrider$1.VirtualBase = Method.InVirtualSubobject;
        }
      }
    } finally {
      if (FinalOverriders != null) { FinalOverriders.$destroy(); }
    }
  }

  
  /// getOverrider - Get the final overrider for the given method declaration in
  /// the subobject with the given base offset. 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::getOverrider">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 141,
   FQN="(anonymous namespace)::FinalOverriders::getOverrider", NM="_ZNK12_GLOBAL__N_115FinalOverriders12getOverriderEPKN5clang13CXXMethodDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_115FinalOverriders12getOverriderEPKN5clang13CXXMethodDeclENS1_9CharUnitsE")
  //</editor-fold>
  public OverriderInfo getOverrider(/*const*/ CXXMethodDecl /*P*/ MD, 
              CharUnits BaseOffset) /*const*/ {
    assert ((OverridersMap.count(std.make_pair_Ptr_T(MD, BaseOffset)) != 0)) : "Did not find overrider!";
    
    return OverridersMap.lookup(std.make_pair_Ptr_T(MD, BaseOffset));
  }

  
  /// dump - dump the final overriders.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 150,
   FQN="(anonymous namespace)::FinalOverriders::dump", NM="_ZN12_GLOBAL__N_115FinalOverriders4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverriders4dumpEv")
  //</editor-fold>
  public void dump() {
    SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VisitedVirtualBases/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    dump(llvm.errs(), new BaseSubobject(MostDerivedClass, CharUnits.Zero()), 
        VisitedVirtualBases);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FinalOverriders::~FinalOverriders">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 62,
   FQN="(anonymous namespace)::FinalOverriders::~FinalOverriders", NM="_ZN12_GLOBAL__N_115FinalOverridersD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_115FinalOverridersD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    OverridersMap.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "MostDerivedClass=" + MostDerivedClass // NOI18N
              + ", MostDerivedClassOffset=" + MostDerivedClassOffset // NOI18N
              + ", LayoutClass=" + LayoutClass // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", MostDerivedClassLayout=" + MostDerivedClassLayout // NOI18N
              + ", OverridersMap=" + OverridersMap; // NOI18N
  }
}
