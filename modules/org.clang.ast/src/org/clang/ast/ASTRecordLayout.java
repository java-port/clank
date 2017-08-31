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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.aliases.*;
import static org.clang.ast.ASTContextGlobals.*;


/// ASTRecordLayout -
/// This class contains layout information for one RecordDecl,
/// which is a struct/union/class.  The decl represented must be a definition,
/// not a forward declaration.
/// This class is also used to contain layout information for one
/// ObjCInterfaceDecl. FIXME - Find appropriate name.
/// These objects are managed by ASTContext.
//<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 34,
 FQN="clang::ASTRecordLayout", NM="_ZN5clang15ASTRecordLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayoutE")
//</editor-fold>
public class ASTRecordLayout implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::VBaseInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 36,
   FQN="clang::ASTRecordLayout::VBaseInfo", NM="_ZN5clang15ASTRecordLayout9VBaseInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout9VBaseInfoE")
  //</editor-fold>
  public static class/*struct*/ VBaseInfo implements NativeCloneable<VBaseInfo> {
    /// The offset to this virtual base in the complete-object layout
    /// of this class.
    public CharUnits VBaseOffset;
  /*private:*/
    /// Whether this virtual base requires a vtordisp field in the
    /// Microsoft ABI.  These fields are required for certain operations
    /// in constructors and destructors.
    private boolean HasVtorDisp;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::VBaseInfo::hasVtorDisp">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 48,
     FQN="clang::ASTRecordLayout::VBaseInfo::hasVtorDisp", NM="_ZNK5clang15ASTRecordLayout9VBaseInfo11hasVtorDispEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout9VBaseInfo11hasVtorDispEv")
    //</editor-fold>
    public boolean hasVtorDisp() /*const*/ {
      return HasVtorDisp;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::VBaseInfo::VBaseInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 50,
     FQN="clang::ASTRecordLayout::VBaseInfo::VBaseInfo", NM="_ZN5clang15ASTRecordLayout9VBaseInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout9VBaseInfoC1Ev")
    //</editor-fold>
    public VBaseInfo() {
      // : VBaseOffset(), HasVtorDisp(false) 
      //START JInit
      this.VBaseOffset = new CharUnits();
      this.HasVtorDisp = false;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::VBaseInfo::VBaseInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 52,
     FQN="clang::ASTRecordLayout::VBaseInfo::VBaseInfo", NM="_ZN5clang15ASTRecordLayout9VBaseInfoC1ENS_9CharUnitsEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout9VBaseInfoC1ENS_9CharUnitsEb")
    //</editor-fold>
    public VBaseInfo(CharUnits VBaseOffset, boolean hasVtorDisp) {
      // : VBaseOffset(VBaseOffset), HasVtorDisp(hasVtorDisp) 
      //START JInit
      this.VBaseOffset = new CharUnits(VBaseOffset);
      this.HasVtorDisp = hasVtorDisp;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::VBaseInfo::VBaseInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 36,
     FQN="clang::ASTRecordLayout::VBaseInfo::VBaseInfo", NM="_ZN5clang15ASTRecordLayout9VBaseInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout9VBaseInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ VBaseInfo(final /*const*/ VBaseInfo /*&*/ $Prm0) {
      // : VBaseOffset(.VBaseOffset), HasVtorDisp(.HasVtorDisp) 
      //START JInit
      this.VBaseOffset = new CharUnits($Prm0.VBaseOffset);
      this.HasVtorDisp = $Prm0.HasVtorDisp;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::VBaseInfo::VBaseInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 36,
     FQN="clang::ASTRecordLayout::VBaseInfo::VBaseInfo", NM="_ZN5clang15ASTRecordLayout9VBaseInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout9VBaseInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ VBaseInfo(JD$Move _dparam, final VBaseInfo /*&&*/$Prm0) {
      // : VBaseOffset(static_cast<VBaseInfo &&>().VBaseOffset), HasVtorDisp(static_cast<VBaseInfo &&>().HasVtorDisp) 
      //START JInit
      this.VBaseOffset = new CharUnits(JD$Move.INSTANCE, $Prm0.VBaseOffset);
      this.HasVtorDisp = $Prm0.HasVtorDisp;
      //END JInit
    }

    @Override public VBaseInfo clone() { return new VBaseInfo(this); }
    
    @Override public String toString() {
      return "" + "VBaseOffset=" + VBaseOffset // NOI18N
                + ", HasVtorDisp=" + HasVtorDisp; // NOI18N
    }
  };
  
  /*typedef llvm::DenseMap<const CXXRecordDecl *, VBaseInfo> VBaseOffsetsMapTy*/
//  public final class VBaseOffsetsMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , VBaseInfo>{ };
/*private:*/
  /// Size - Size of record in characters.
  private CharUnits Size;
  
  /// DataSize - Size of record in characters without tail padding.
  private CharUnits DataSize;
  
  // Alignment - Alignment of record in characters.
  private CharUnits Alignment;
  
  /// RequiredAlignment - The required alignment of the object.  In the MS-ABI
  /// the __declspec(align()) trumps #pramga pack and must always be obeyed.
  private CharUnits RequiredAlignment;
  
  /// FieldOffsets - Array of field offsets in bits.
  private ASTVectorULong FieldOffsets;
  
  /// CXXRecordLayoutInfo - Contains C++ specific layout information.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::CXXRecordLayoutInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 77,
   FQN="clang::ASTRecordLayout::CXXRecordLayoutInfo", NM="_ZN5clang15ASTRecordLayout19CXXRecordLayoutInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout19CXXRecordLayoutInfoE")
  //</editor-fold>
  private static class/*struct*/ CXXRecordLayoutInfo implements Destructors.ClassWithDestructor {
    /// NonVirtualSize - The non-virtual size (in chars) of an object, which is
    /// the size of the object without virtual bases.
    public CharUnits NonVirtualSize;
    
    /// NonVirtualAlignment - The non-virtual alignment (in chars) of an object,
    /// which is the alignment of the object without virtual bases.
    public CharUnits NonVirtualAlignment;
    
    /// SizeOfLargestEmptySubobject - The size of the largest empty subobject
    /// (either a base or a member). Will be zero if the class doesn't contain
    /// any empty subobjects.
    public CharUnits SizeOfLargestEmptySubobject;
    
    /// VBPtrOffset - Virtual base table offset (Microsoft-only).
    public CharUnits VBPtrOffset;
    
    /// HasOwnVFPtr - Does this class provide a virtual function table
    /// (vtable in Itanium, vftbl in Microsoft) that is independent from
    /// its base classes?
    public /*JBIT bool*/ boolean HasOwnVFPtr /*: 1*/;
    
    /// HasVFPtr - Does this class have a vftable that could be extended by
    /// a derived class.  The class may have inherited this pointer from
    /// a primary base class.
    public /*JBIT bool*/ boolean HasExtendableVFPtr /*: 1*/;
    
    /// EndsWithZeroSizedObject - True if this class contains a zero sized
    /// member or base or a base with a zero sized member or base.
    /// Only used for MS-ABI.
    public /*JBIT bool*/ boolean EndsWithZeroSizedObject /*: 1*/;
    
    /// \brief True if this class is zero sized or first base is zero sized or
    /// has this property.  Only used for MS-ABI.
    public /*JBIT bool*/ boolean LeadsWithZeroSizedBase /*: 1*/;
    
    /// PrimaryBase - The primary base info for this record.
    public PointerBoolPair</*const*/ CXXRecordDecl /*P*/ > PrimaryBase;
    
    /// BaseSharingVBPtr - The base we share vbptr with.
    public /*const*/ CXXRecordDecl /*P*/ BaseSharingVBPtr;
    
    /// FIXME: This should really use a SmallPtrMap, once we have one in LLVM :)
    /*typedef llvm::DenseMap<const CXXRecordDecl *, CharUnits> BaseOffsetsMapTy*/
//    public final class BaseOffsetsMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>{ };
    
    /// BaseOffsets - Contains a map from base classes to their offset.
    public DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> BaseOffsets;
    
    /// VBaseOffsets - Contains a map from vbase classes to their offset.
    public DenseMap</*const*/ CXXRecordDecl /*P*/ , VBaseInfo> VBaseOffsets;
    //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::CXXRecordLayoutInfo::~CXXRecordLayoutInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 77,
     FQN="clang::ASTRecordLayout::CXXRecordLayoutInfo::~CXXRecordLayoutInfo", NM="_ZN5clang15ASTRecordLayout19CXXRecordLayoutInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout19CXXRecordLayoutInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      VBaseOffsets.$destroy();
      BaseOffsets.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::CXXRecordLayoutInfo::CXXRecordLayoutInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 77,
     FQN="clang::ASTRecordLayout::CXXRecordLayoutInfo::CXXRecordLayoutInfo", NM="_ZN5clang15ASTRecordLayout19CXXRecordLayoutInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout19CXXRecordLayoutInfoC1Ev")
    //</editor-fold>
    public /*inline*/ CXXRecordLayoutInfo() {
      // : NonVirtualSize(), NonVirtualAlignment(), SizeOfLargestEmptySubobject(), VBPtrOffset(), PrimaryBase(), BaseOffsets(), VBaseOffsets() 
      //START JInit
      this.NonVirtualSize = new CharUnits();
      this.NonVirtualAlignment = new CharUnits();
      this.SizeOfLargestEmptySubobject = new CharUnits();
      this.VBPtrOffset = new CharUnits();
      this.PrimaryBase = new PointerBoolPair</*const*/ CXXRecordDecl /*P*/ >();
      this.BaseOffsets = new DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>(DenseMapInfo$LikePtr.$Info(), new CharUnits());
      this.VBaseOffsets = new DenseMap</*const*/ CXXRecordDecl /*P*/ , VBaseInfo>(DenseMapInfo$LikePtr.$Info(), new VBaseInfo());
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "NonVirtualSize=" + NonVirtualSize // NOI18N
                + ", NonVirtualAlignment=" + NonVirtualAlignment // NOI18N
                + ", SizeOfLargestEmptySubobject=" + SizeOfLargestEmptySubobject // NOI18N
                + ", VBPtrOffset=" + VBPtrOffset // NOI18N
                + ", HasOwnVFPtr=" + HasOwnVFPtr // NOI18N
                + ", HasExtendableVFPtr=" + HasExtendableVFPtr // NOI18N
                + ", EndsWithZeroSizedObject=" + EndsWithZeroSizedObject // NOI18N
                + ", LeadsWithZeroSizedBase=" + LeadsWithZeroSizedBase // NOI18N
                + ", PrimaryBase=" + PrimaryBase // NOI18N
                + ", BaseSharingVBPtr=" + BaseSharingVBPtr // NOI18N
                + ", BaseOffsets=" + BaseOffsets // NOI18N
                + ", VBaseOffsets=" + VBaseOffsets; // NOI18N
    }
  };
  
  /// CXXInfo - If the record layout is for a C++ record, this will have
  /// C++ specific information about the record.
  private CXXRecordLayoutInfo /*P*/ CXXInfo;
  
  /*friend  class ASTContext*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::ASTRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp", line = 29,
   FQN="clang::ASTRecordLayout::ASTRecordLayout", NM="_ZN5clang15ASTRecordLayoutC1ERKNS_10ASTContextENS_9CharUnitsES4_S4_S4_N4llvm8ArrayRefIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayoutC1ERKNS_10ASTContextENS_9CharUnitsES4_S4_S4_N4llvm8ArrayRefIyEE")
  //</editor-fold>
  /*friend*/public/*private*/ ASTRecordLayout(final /*const*/ ASTContext /*&*/ Ctx, CharUnits size, 
      CharUnits alignment, 
      CharUnits requiredAlignment, 
      CharUnits datasize, 
      ArrayRefULong fieldoffsets) {
    // : Size(size), DataSize(datasize), Alignment(alignment), RequiredAlignment(requiredAlignment), FieldOffsets(), CXXInfo(null) 
    //START JInit
    this.Size = new CharUnits(size);
    this.DataSize = new CharUnits(datasize);
    this.Alignment = new CharUnits(alignment);
    this.RequiredAlignment = new CharUnits(requiredAlignment);
    this.FieldOffsets = new ASTVectorULong();
    this.CXXInfo = null;
    //END JInit
    FieldOffsets.append_ASTContext$C_T(Ctx, fieldoffsets.begin(), fieldoffsets.end());
  }

  
  // Constructor for C++ records.
  /*typedef CXXRecordLayoutInfo::BaseOffsetsMapTy BaseOffsetsMapTy*/
//  public final class BaseOffsetsMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>{ };
  
  // Constructor for C++ records.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::ASTRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp", line = 40,
   FQN="clang::ASTRecordLayout::ASTRecordLayout", NM="_ZN5clang15ASTRecordLayoutC1ERKNS_10ASTContextENS_9CharUnitsES4_S4_bbS4_S4_N4llvm8ArrayRefIyEES4_S4_S4_PKNS_13CXXRecordDeclEbSA_bbRKNS5_8DenseMapISA_S4_NS5_12DenseMapInfoISA_EENS5_6detail12DenseMapPairISA_S4_EEEERKNSB_ISA_NS0_9VBaseInfoESD_NSF_ISA_SK_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayoutC1ERKNS_10ASTContextENS_9CharUnitsES4_S4_bbS4_S4_N4llvm8ArrayRefIyEES4_S4_S4_PKNS_13CXXRecordDeclEbSA_bbRKNS5_8DenseMapISA_S4_NS5_12DenseMapInfoISA_EENS5_6detail12DenseMapPairISA_S4_EEEERKNSB_ISA_NS0_9VBaseInfoESD_NSF_ISA_SK_EEEE")
  //</editor-fold>
  /*friend*/public/*private*/ ASTRecordLayout(final /*const*/ ASTContext /*&*/ Ctx, 
      CharUnits size, CharUnits alignment, 
      CharUnits requiredAlignment, 
      boolean hasOwnVFPtr, boolean hasExtendableVFPtr, 
      CharUnits vbptroffset, 
      CharUnits datasize, 
      ArrayRefULong fieldoffsets, 
      CharUnits nonvirtualsize, 
      CharUnits nonvirtualalignment, 
      CharUnits SizeOfLargestEmptySubobject, 
      /*const*/ CXXRecordDecl /*P*/ PrimaryBase, 
      boolean IsPrimaryBaseVirtual, 
      /*const*/ CXXRecordDecl /*P*/ BaseSharingVBPtr, 
      boolean EndsWithZeroSizedObject, 
      boolean LeadsWithZeroSizedBase, 
      final /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ BaseOffsets, 
      final /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , VBaseInfo> /*&*/ VBaseOffsets) {
    // : Size(size), DataSize(datasize), Alignment(alignment), RequiredAlignment(requiredAlignment), FieldOffsets(), CXXInfo(new (Ctx) new CXXRecordLayoutInfo) 
    //START JInit
    this.Size = new CharUnits(size);
    this.DataSize = new CharUnits(datasize);
    this.Alignment = new CharUnits(alignment);
    this.RequiredAlignment = new CharUnits(requiredAlignment);
    this.FieldOffsets = new ASTVectorULong();
    this.CXXInfo = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (Ctx)*/ $new_uint_ASTContext$C_uint(Ctx, (type$ptr<?> New$Mem)->{
        return new CXXRecordLayoutInfo();
     });
    //END JInit
    FieldOffsets.append_ASTContext$C_T(Ctx, fieldoffsets.begin(), fieldoffsets.end());
    
    CXXInfo.PrimaryBase.setPointer(PrimaryBase);
    CXXInfo.PrimaryBase.setInt(IsPrimaryBaseVirtual);
    CXXInfo.NonVirtualSize.$assign(nonvirtualsize);
    CXXInfo.NonVirtualAlignment.$assign(nonvirtualalignment);
    CXXInfo.SizeOfLargestEmptySubobject.$assign(SizeOfLargestEmptySubobject);
    CXXInfo.BaseOffsets.$assign(BaseOffsets);
    CXXInfo.VBaseOffsets.$assign(VBaseOffsets);
    CXXInfo.HasOwnVFPtr = hasOwnVFPtr;
    CXXInfo.VBPtrOffset.$assign(vbptroffset);
    CXXInfo.HasExtendableVFPtr = hasExtendableVFPtr;
    CXXInfo.BaseSharingVBPtr = BaseSharingVBPtr;
    CXXInfo.EndsWithZeroSizedObject = EndsWithZeroSizedObject;
    CXXInfo.LeadsWithZeroSizedBase = LeadsWithZeroSizedBase;
    {
      /*const*/ CXXRecordDecl /*P*/ PrimaryBase$1 = getPrimaryBase();
      if ((PrimaryBase$1 != null)) {
        if (isPrimaryBaseVirtual()) {
          if (Ctx.getTargetInfo().getCXXABI().hasPrimaryVBases()) {
            assert (getVBaseClassOffset(PrimaryBase$1).isZero()) : "Primary virtual base must be at offset 0!";
          }
        } else {
          assert (getBaseClassOffset(PrimaryBase$1).isZero()) : "Primary base must be at offset 0!";
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::~ASTRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 158,
   FQN="clang::ASTRecordLayout::~ASTRecordLayout", NM="_ZN5clang15ASTRecordLayoutD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayoutD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    //START JDestroy
    FieldOffsets.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::Destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp", line = 20,
   FQN="clang::ASTRecordLayout::Destroy", NM="_ZN5clang15ASTRecordLayout7DestroyERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayout7DestroyERNS_10ASTContextE")
  //</editor-fold>
  /*friend*//*private*/ void Destroy(final ASTContext /*&*/ Ctx) {
    if ((CXXInfo != null)) {
      CXXInfo.$destroy();
      Ctx.Deallocate(CXXInfo);
    }
    this.$destroy();
    Ctx.Deallocate(this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::ASTRecordLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 162,
   FQN="clang::ASTRecordLayout::ASTRecordLayout", NM="_ZN5clang15ASTRecordLayoutC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayoutC1ERKS0_")
  //</editor-fold>
  private ASTRecordLayout(final /*const*/ ASTRecordLayout /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 163,
   FQN="clang::ASTRecordLayout::operator=", NM="_ZN5clang15ASTRecordLayoutaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZN5clang15ASTRecordLayoutaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ ASTRecordLayout /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  
  /// getAlignment - Get the record alignment in characters.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 167,
   FQN="clang::ASTRecordLayout::getAlignment", NM="_ZNK5clang15ASTRecordLayout12getAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout12getAlignmentEv")
  //</editor-fold>
  public CharUnits getAlignment() /*const*/ {
    return new CharUnits(Alignment);
  }

  
  /// getSize - Get the record size in characters.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 170,
   FQN="clang::ASTRecordLayout::getSize", NM="_ZNK5clang15ASTRecordLayout7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout7getSizeEv")
  //</editor-fold>
  public CharUnits getSize() /*const*/ {
    return new CharUnits(Size);
  }

  
  /// getFieldCount - Get the number of fields in the layout.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getFieldCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 173,
   FQN="clang::ASTRecordLayout::getFieldCount", NM="_ZNK5clang15ASTRecordLayout13getFieldCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout13getFieldCountEv")
  //</editor-fold>
  public /*uint*/int getFieldCount() /*const*/ {
    return FieldOffsets.size();
  }

  
  /// getFieldOffset - Get the offset of the given field index, in
  /// bits.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getFieldOffset">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 177,
   FQN="clang::ASTRecordLayout::getFieldOffset", NM="_ZNK5clang15ASTRecordLayout14getFieldOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout14getFieldOffsetEj")
  //</editor-fold>
  public long/*uint64_t*/ getFieldOffset(/*uint*/int FieldNo) /*const*/ {
    return FieldOffsets.$at$Const(FieldNo);
  }

  
  /// getDataSize() - Get the record data size, which is the record size
  /// without tail padding, in characters.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 183,
   FQN="clang::ASTRecordLayout::getDataSize", NM="_ZNK5clang15ASTRecordLayout11getDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout11getDataSizeEv")
  //</editor-fold>
  public CharUnits getDataSize() /*const*/ {
    return new CharUnits(DataSize);
  }

  
  /// getNonVirtualSize - Get the non-virtual size (in chars) of an object,
  /// which is the size of the object without virtual bases.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getNonVirtualSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 189,
   FQN="clang::ASTRecordLayout::getNonVirtualSize", NM="_ZNK5clang15ASTRecordLayout17getNonVirtualSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout17getNonVirtualSizeEv")
  //</editor-fold>
  public CharUnits getNonVirtualSize() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    
    return new CharUnits(CXXInfo.NonVirtualSize);
  }

  
  /// getNonVirtualSize - Get the non-virtual alignment (in chars) of an object,
  /// which is the alignment of the object without virtual bases.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getNonVirtualAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 197,
   FQN="clang::ASTRecordLayout::getNonVirtualAlignment", NM="_ZNK5clang15ASTRecordLayout22getNonVirtualAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout22getNonVirtualAlignmentEv")
  //</editor-fold>
  public CharUnits getNonVirtualAlignment() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    
    return new CharUnits(CXXInfo.NonVirtualAlignment);
  }

  
  /// getPrimaryBase - Get the primary base for this record.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getPrimaryBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 204,
   FQN="clang::ASTRecordLayout::getPrimaryBase", NM="_ZNK5clang15ASTRecordLayout14getPrimaryBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout14getPrimaryBaseEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getPrimaryBase() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    
    return CXXInfo.PrimaryBase.getPointer();
  }

  
  /// isPrimaryBaseVirtual - Get whether the primary base for this record
  /// is virtual or not.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::isPrimaryBaseVirtual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 212,
   FQN="clang::ASTRecordLayout::isPrimaryBaseVirtual", NM="_ZNK5clang15ASTRecordLayout20isPrimaryBaseVirtualEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout20isPrimaryBaseVirtualEv")
  //</editor-fold>
  public boolean isPrimaryBaseVirtual() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    
    return CXXInfo.PrimaryBase.getInt();
  }

  
  /// getBaseClassOffset - Get the offset, in chars, for the given base class.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getBaseClassOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 219,
   FQN="clang::ASTRecordLayout::getBaseClassOffset", NM="_ZNK5clang15ASTRecordLayout18getBaseClassOffsetEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout18getBaseClassOffsetEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public CharUnits getBaseClassOffset(/*const*/ CXXRecordDecl /*P*/ Base) /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    assert ((CXXInfo.BaseOffsets.count(Base) != 0)) : "Did not find base!";
    
    return new CharUnits(CXXInfo.BaseOffsets.$at_T1$C$R(Base));
  }

  
  /// getVBaseClassOffset - Get the offset, in chars, for the given base class.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getVBaseClassOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 227,
   FQN="clang::ASTRecordLayout::getVBaseClassOffset", NM="_ZNK5clang15ASTRecordLayout19getVBaseClassOffsetEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout19getVBaseClassOffsetEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public CharUnits getVBaseClassOffset(/*const*/ CXXRecordDecl /*P*/ VBase) /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    assert ((CXXInfo.VBaseOffsets.count(VBase) != 0)) : "Did not find base!";
    
    return new CharUnits(CXXInfo.VBaseOffsets.$at_T1$C$R(VBase).VBaseOffset);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getSizeOfLargestEmptySubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 234,
   FQN="clang::ASTRecordLayout::getSizeOfLargestEmptySubobject", NM="_ZNK5clang15ASTRecordLayout30getSizeOfLargestEmptySubobjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout30getSizeOfLargestEmptySubobjectEv")
  //</editor-fold>
  public CharUnits getSizeOfLargestEmptySubobject() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return new CharUnits(CXXInfo.SizeOfLargestEmptySubobject);
  }

  
  /// hasOwnVFPtr - Does this class provide its own virtual-function
  /// table pointer, rather than inheriting one from a primary base
  /// class?  If so, it is at offset zero.
  ///
  /// This implies that the ABI has no primary base class, meaning
  /// that it has no base classes that are suitable under the conditions
  /// of the ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::hasOwnVFPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 246,
   FQN="clang::ASTRecordLayout::hasOwnVFPtr", NM="_ZNK5clang15ASTRecordLayout11hasOwnVFPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout11hasOwnVFPtrEv")
  //</editor-fold>
  public boolean hasOwnVFPtr() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return CXXInfo.HasOwnVFPtr;
  }

  
  /// hasVFPtr - Does this class have a virtual function table pointer
  /// that can be extended by a derived class?  This is synonymous with
  /// this class having a VFPtr at offset zero.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::hasExtendableVFPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 254,
   FQN="clang::ASTRecordLayout::hasExtendableVFPtr", NM="_ZNK5clang15ASTRecordLayout18hasExtendableVFPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout18hasExtendableVFPtrEv")
  //</editor-fold>
  public boolean hasExtendableVFPtr() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return CXXInfo.HasExtendableVFPtr;
  }

  
  /// hasOwnVBPtr - Does this class provide its own virtual-base
  /// table pointer, rather than inheriting one from a primary base
  /// class?
  ///
  /// This implies that the ABI has no primary base class, meaning
  /// that it has no base classes that are suitable under the conditions
  /// of the ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::hasOwnVBPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 266,
   FQN="clang::ASTRecordLayout::hasOwnVBPtr", NM="_ZNK5clang15ASTRecordLayout11hasOwnVBPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout11hasOwnVBPtrEv")
  //</editor-fold>
  public boolean hasOwnVBPtr() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return hasVBPtr() && !(CXXInfo.BaseSharingVBPtr != null);
  }

  
  /// hasVBPtr - Does this class have a virtual function table pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::hasVBPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 272,
   FQN="clang::ASTRecordLayout::hasVBPtr", NM="_ZNK5clang15ASTRecordLayout8hasVBPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout8hasVBPtrEv")
  //</editor-fold>
  public boolean hasVBPtr() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return !CXXInfo.VBPtrOffset.isNegative();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getRequiredAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 277,
   FQN="clang::ASTRecordLayout::getRequiredAlignment", NM="_ZNK5clang15ASTRecordLayout20getRequiredAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout20getRequiredAlignmentEv")
  //</editor-fold>
  public CharUnits getRequiredAlignment() /*const*/ {
    return new CharUnits(RequiredAlignment);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::endsWithZeroSizedObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 281,
   FQN="clang::ASTRecordLayout::endsWithZeroSizedObject", NM="_ZNK5clang15ASTRecordLayout23endsWithZeroSizedObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout23endsWithZeroSizedObjectEv")
  //</editor-fold>
  public boolean endsWithZeroSizedObject() /*const*/ {
    return (CXXInfo != null) && CXXInfo.EndsWithZeroSizedObject;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::leadsWithZeroSizedBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 285,
   FQN="clang::ASTRecordLayout::leadsWithZeroSizedBase", NM="_ZNK5clang15ASTRecordLayout22leadsWithZeroSizedBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout22leadsWithZeroSizedBaseEv")
  //</editor-fold>
  public boolean leadsWithZeroSizedBase() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return CXXInfo.LeadsWithZeroSizedBase;
  }

  
  /// getVBPtrOffset - Get the offset for virtual base table pointer.
  /// This is only meaningful with the Microsoft ABI.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getVBPtrOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 292,
   FQN="clang::ASTRecordLayout::getVBPtrOffset", NM="_ZNK5clang15ASTRecordLayout14getVBPtrOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout14getVBPtrOffsetEv")
  //</editor-fold>
  public CharUnits getVBPtrOffset() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return new CharUnits(CXXInfo.VBPtrOffset);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getBaseSharingVBPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 297,
   FQN="clang::ASTRecordLayout::getBaseSharingVBPtr", NM="_ZNK5clang15ASTRecordLayout19getBaseSharingVBPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout19getBaseSharingVBPtrEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getBaseSharingVBPtr() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return CXXInfo.BaseSharingVBPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTRecordLayout::getVBaseOffsetsMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RecordLayout.h", line = 302,
   FQN="clang::ASTRecordLayout::getVBaseOffsetsMap", NM="_ZNK5clang15ASTRecordLayout18getVBaseOffsetsMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayout.cpp -nm=_ZNK5clang15ASTRecordLayout18getVBaseOffsetsMapEv")
  //</editor-fold>
  public /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , VBaseInfo> /*&*/ getVBaseOffsetsMap() /*const*/ {
    assert ((CXXInfo != null)) : "Record layout does not have C++ specific info!";
    return CXXInfo.VBaseOffsets;
  }

  
  @Override public String toString() {
    return "" + "Size=" + Size // NOI18N
              + ", DataSize=" + DataSize // NOI18N
              + ", Alignment=" + Alignment // NOI18N
              + ", RequiredAlignment=" + RequiredAlignment // NOI18N
              + ", FieldOffsets=" + FieldOffsets // NOI18N
              + ", CXXInfo=" + CXXInfo; // NOI18N
  }
}
