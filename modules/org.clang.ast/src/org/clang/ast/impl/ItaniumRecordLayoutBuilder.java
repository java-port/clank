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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.target.*;
import static org.clang.ast.impl.RecordLayoutBuilderStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 567,
 FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderE")
//</editor-fold>
public class ItaniumRecordLayoutBuilder implements Destructors.ClassWithDestructor {
/*protected:*/
  // FIXME: Remove this and make the appropriate fields public.
  /*friend  class clang::ASTContext*/
  
  protected final /*const*/ ASTContext /*&*/ Context;
  
  protected EmptySubobjectMap /*P*/ EmptySubobjects;
  
  /// Size - The current size of the record layout.
  protected long/*uint64_t*/ Size;
  
  /// Alignment - The current alignment of the record layout.
  /*friend*/public/*protected*/ CharUnits Alignment;
  
  /// \brief The alignment if attribute packed is not used.
  protected CharUnits UnpackedAlignment;
  
  /*friend*/public/*protected*/ SmallVectorULong FieldOffsets;
  
  /// \brief Whether the external AST source has provided a layout for this
  /// record.
  protected /*JBIT unsigned int*/ boolean UseExternalLayout /*: 1*/;
  
  /// \brief Whether we need to infer alignment, even when we have an 
  /// externally-provided layout.
  protected /*JBIT unsigned int*/ boolean InferAlignment /*: 1*/;
  
  /// Packed - Whether the record is packed or not.
  protected /*JBIT unsigned int*/ boolean Packed /*: 1*/;
  
  protected /*JBIT unsigned int*/ boolean IsUnion /*: 1*/;
  
  protected /*JBIT unsigned int*/ boolean IsMac68kAlign /*: 1*/;
  
  protected /*JBIT unsigned int*/ boolean IsMsStruct /*: 1*/;
  
  /// UnfilledBitsInLastUnit - If the last field laid out was a bitfield,
  /// this contains the number of bits in the last unit that can be used for
  /// an adjacent bitfield if necessary.  The unit in question is usually
  /// a byte, but larger units are used if IsMsStruct.
  protected /*uchar*/byte UnfilledBitsInLastUnit;
  /// LastBitfieldTypeSize - If IsMsStruct, represents the size of the type
  /// of the previous field if it was a bitfield.
  protected /*uchar*/byte LastBitfieldTypeSize;
  
  /// MaxFieldAlignment - The maximum allowed field alignment. This is set by
  /// #pragma pack.
  protected CharUnits MaxFieldAlignment;
  
  /// DataSize - The data size of the record being laid out.
  protected long/*uint64_t*/ DataSize;
  
  /*friend*/public CharUnits NonVirtualSize;
  /*friend*/public CharUnits NonVirtualAlignment;
  
  /// PrimaryBase - the primary base class (if one exists) of the class
  /// we're laying out.
  /*friend*/public  /*const*/ CXXRecordDecl /*P*/ PrimaryBase;
  
  /// PrimaryBaseIsVirtual - Whether the primary base of the class we're laying
  /// out is virtual.
  /*friend*/public boolean PrimaryBaseIsVirtual;
  
  /// HasOwnVFPtr - Whether the class provides its own vtable/vftbl
  /// pointer, as opposed to inheriting one from a primary base class.
  /*friend*/public boolean HasOwnVFPtr;
  
  /*typedef llvm::DenseMap<const CXXRecordDecl *, CharUnits> BaseOffsetsMapTy*/
//  public final class BaseOffsetsMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>{ };
  
  /// Bases - base classes and their offsets in the record.
  /*friend*/public DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> Bases;
  
  // VBases - virtual base classes and their offsets in the record.
  /*friend*/public DenseMap</*const*/ CXXRecordDecl /*P*/ , ASTRecordLayout.VBaseInfo> VBases;
  
  /// IndirectPrimaryBases - Virtual base classes, direct or indirect, that are
  /// primary base classes for some other direct or indirect base class.
  protected CXXIndirectPrimaryBaseSet IndirectPrimaryBases;
  
  /// FirstNearlyEmptyVBase - The first nearly empty virtual base class in
  /// inheritance graph order. Used for determining the primary base class.
  protected /*const*/ CXXRecordDecl /*P*/ FirstNearlyEmptyVBase;
  
  /// VisitedVirtualBases - A set of all the visited virtual bases, used to
  /// avoid visiting virtual bases more than once.
  protected SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VisitedVirtualBases;
  
  /// Valid if UseExternalLayout is true.
  protected ExternalLayout External;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::ItaniumRecordLayoutBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 658,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::ItaniumRecordLayoutBuilder", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderC1ERKN5clang10ASTContextEPNS_17EmptySubobjectMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderC1ERKN5clang10ASTContextEPNS_17EmptySubobjectMapE")
  //</editor-fold>
  /*friend*/public/*protected*/ ItaniumRecordLayoutBuilder(final /*const*/ ASTContext /*&*/ Context, 
      EmptySubobjectMap /*P*/ EmptySubobjects) {
    // : Context(Context), EmptySubobjects(EmptySubobjects), Size(0), Alignment(CharUnits::One()), UnpackedAlignment(CharUnits::One()), FieldOffsets(), UseExternalLayout(false), InferAlignment(false), Packed(false), IsUnion(false), IsMac68kAlign(false), IsMsStruct(false), UnfilledBitsInLastUnit(0), LastBitfieldTypeSize(0), MaxFieldAlignment(CharUnits::Zero()), DataSize(0), NonVirtualSize(CharUnits::Zero()), NonVirtualAlignment(CharUnits::One()), PrimaryBase(null), PrimaryBaseIsVirtual(false), HasOwnVFPtr(false), Bases(), VBases(), IndirectPrimaryBases(), FirstNearlyEmptyVBase(null), VisitedVirtualBases(), External(), BaseSubobjectInfoAllocator(), VirtualBaseInfo(), NonVirtualBaseInfo() 
    //START JInit
    this./*&*/Context=/*&*/Context;
    this.EmptySubobjects = EmptySubobjects;
    this.Size = $int2ulong(0);
    this.Alignment = CharUnits.One();
    this.UnpackedAlignment = CharUnits.One();
    this.FieldOffsets = new SmallVectorULong(16, 0);
    this.UseExternalLayout = false;
    this.InferAlignment = false;
    this.Packed = false;
    this.IsUnion = false;
    this.IsMac68kAlign = false;
    this.IsMsStruct = false;
    this.UnfilledBitsInLastUnit = $int2uchar(0);
    this.LastBitfieldTypeSize = $int2uchar(0);
    this.MaxFieldAlignment = CharUnits.Zero();
    this.DataSize = $int2ulong(0);
    this.NonVirtualSize = CharUnits.Zero();
    this.NonVirtualAlignment = CharUnits.One();
    this.PrimaryBase = null;
    this.PrimaryBaseIsVirtual = false;
    this.HasOwnVFPtr = false;
    this.Bases = new DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>(DenseMapInfo$LikePtr.$Info(), new CharUnits());
    this.VBases = new DenseMap</*const*/ CXXRecordDecl /*P*/ , ASTRecordLayout.VBaseInfo>(DenseMapInfo$LikePtr.$Info(), new ASTRecordLayout.VBaseInfo());
    this.IndirectPrimaryBases = new CXXIndirectPrimaryBaseSet();
    this.FirstNearlyEmptyVBase = null;
    this.VisitedVirtualBases = new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.External = new ExternalLayout();
    this.BaseSubobjectInfoAllocator = new SpecificBumpPtrAllocator<BaseSubobjectInfo>(BaseSubobjectInfo.class);
    this.VirtualBaseInfo = new DenseMap</*const*/ CXXRecordDecl /*P*/ , BaseSubobjectInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), (BaseSubobjectInfo /*P*/ )null);
    this.NonVirtualBaseInfo = new DenseMap</*const*/ CXXRecordDecl /*P*/ , BaseSubobjectInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), (BaseSubobjectInfo /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::Layout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1277,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::Layout", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder6LayoutEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder6LayoutEPKN5clang10RecordDeclE")
  //</editor-fold>
  /*friend*/public void Layout(/*const*/ RecordDecl /*P*/ D) {
    InitializeLayout(D);
    LayoutFields(D);
    
    // Finally, round the size of the total struct up to the alignment of the
    // struct itself.
    FinishLayout(D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::Layout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1286,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::Layout", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder6LayoutEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder6LayoutEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  /*friend*/public void Layout(/*const*/ CXXRecordDecl /*P*/ RD) {
    InitializeLayout(RD);
    
    // Lay out the vtable and the non-virtual bases.
    LayoutNonVirtualBases(RD);
    
    LayoutFields(RD);
    
    NonVirtualSize.$assignMove(Context.toCharUnitsFromBits(llvm.alignTo(getSizeInBits(), $uint2ulong(Context.getTargetInfo().getCharAlign()))));
    NonVirtualAlignment.$assign(Alignment);
    
    // Lay out the virtual bases and add the primary virtual base offsets.
    LayoutVirtualBases(RD, RD);
    
    // Finally, round the size of the total struct up to the alignment
    // of the struct itself.
    FinishLayout(RD);
    // Check that we have base offsets for all bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      if (Base.isVirtual()) {
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      assert ((Bases.count(BaseDecl) != 0)) : "Did not find base offset!";
    }
    
    // And all virtual bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      assert ((VBases.count(BaseDecl) != 0)) : "Did not find base offset!";
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::Layout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1325,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::Layout", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder6LayoutEPKN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder6LayoutEPKN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  /*friend*/public/*protected*/ void Layout(/*const*/ ObjCInterfaceDecl /*P*/ D) {
    {
      ObjCInterfaceDecl /*P*/ SD = D.getSuperClass();
      if ((SD != null)) {
        final /*const*/ ASTRecordLayout /*&*/ SL = Context.getASTObjCInterfaceLayout(SD);
        
        UpdateAlignment(SL.getAlignment());
        
        // We start laying out ivars not at the end of the superclass
        // structure, but at the next byte following the last field.
        setSize(SL.getDataSize());
        setDataSize(getSize());
      }
    }
    
    InitializeLayout(D);
    // Layout each ivar sequentially.
    for (/*const*/ ObjCIvarDecl /*P*/ IVD = D.all_declared_ivar_begin$Const(); (IVD != null);
         IVD = IVD.getNextIvar$Const())  {
      LayoutField(IVD, false);
    }
    
    // Finally, round the size of the total struct up to the alignment of the
    // struct itself.
    FinishLayout(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutFields">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1348,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutFields", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder12LayoutFieldsEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder12LayoutFieldsEPKN5clang10RecordDeclE")
  //</editor-fold>
  protected void LayoutFields(/*const*/ RecordDecl /*P*/ D) {
    // Layout each field, for now, just sequentially, respecting alignment.  In
    // the future, this will need to be tweakable by targets.
    boolean InsertExtraPadding = D.mayInsertExtraPadding(/*EmitRemark=*/ true);
    boolean HasFlexibleArrayMember = D.hasFlexibleArrayMember();
    for (DeclContext.specific_decl_iterator<FieldDecl> I = D.field_begin(), End = D.field_end(); $noteq_specific_decl_iterator$SpecificDecl$C(I, End); I.$preInc()) {
      DeclContext.specific_decl_iterator<FieldDecl> Next/*J*/= new DeclContext.specific_decl_iterator<FieldDecl>(I);
      Next.$preInc();
      LayoutField(I.$star(), 
          InsertExtraPadding && ($noteq_specific_decl_iterator$SpecificDecl$C(Next, End) || !HasFlexibleArrayMember));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1704,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutField", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder11LayoutFieldEPKN5clang9FieldDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder11LayoutFieldEPKN5clang9FieldDeclEb")
  //</editor-fold>
  protected void LayoutField(/*const*/ FieldDecl /*P*/ D, 
             boolean InsertExtraPadding) {
    if (D.isBitField()) {
      LayoutBitField(D);
      return;
    }
    
    long/*uint64_t*/ UnpaddedFieldOffset = getDataSizeInBits() - $uchar2ullong(UnfilledBitsInLastUnit);
    
    // Reset the unfilled bits.
    UnfilledBitsInLastUnit = $int2uchar(0);
    LastBitfieldTypeSize = $int2uchar(0);
    
    boolean FieldPacked = Packed || D.hasAttr(PackedAttr.class);
    CharUnits FieldOffset = IsUnion ? CharUnits.Zero() : getDataSize();
    CharUnits FieldSize/*J*/= new CharUnits();
    CharUnits FieldAlign/*J*/= new CharUnits();
    if (D.getType().$arrow().isIncompleteArrayType()) {
      // This is a flexible array member; we can't directly
      // query getTypeInfo about these, so we figure it out here.
      // Flexible array members don't have any size, but they
      // have to be aligned appropriately for their element type.
      FieldSize.$assignMove(CharUnits.Zero());
      /*const*/ ArrayType /*P*/ ATy = Context.getAsArrayType(D.getType());
      FieldAlign.$assignMove(Context.getTypeAlignInChars(ATy.getElementType()));
    } else {
      /*const*/ ReferenceType /*P*/ RT = D.getType().$arrow().getAs(ReferenceType.class);
      if ((RT != null)) {
        /*uint*/int AS = RT.getPointeeType().getAddressSpace();
        FieldSize.$assignMove(
            Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerWidth(AS))
        );
        FieldAlign.$assignMove(
            Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerAlign(AS))
        );
      } else {
        std.pair<CharUnits, CharUnits> FieldInfo = Context.getTypeInfoInChars(D.getType());
        FieldSize.$assign(FieldInfo.first);
        FieldAlign.$assign(FieldInfo.second);
        if (IsMsStruct) {
          // If MS bitfield layout is required, figure out what type is being
          // laid out and align the field to the width of that type.
          
          // Resolve all typedefs down to their base type and round up the field
          // alignment if necessary.
          QualType T = Context.getBaseElementType(D.getType());
          {
            /*const*/ BuiltinType /*P*/ BTy = T.$arrow().getAs$BuiltinType();
            if ((BTy != null)) {
              CharUnits TypeSize = Context.getTypeSizeInChars(BTy);
              if (TypeSize.$greater(FieldAlign)) {
                FieldAlign.$assign(TypeSize);
              }
            }
          }
        }
      }
    }
    
    // The align if the field is not packed. This is to check if the attribute
    // was unnecessary (-Wpacked).
    CharUnits UnpackedFieldAlign = new CharUnits(FieldAlign);
    CharUnits UnpackedFieldOffset = new CharUnits(FieldOffset);
    if (FieldPacked) {
      FieldAlign.$assignMove(CharUnits.One());
    }
    CharUnits MaxAlignmentInChars = Context.toCharUnitsFromBits($uint2long(D.getMaxAlignment()));
    FieldAlign.$assign(std.max(FieldAlign, MaxAlignmentInChars));
    UnpackedFieldAlign.$assign(std.max(UnpackedFieldAlign, MaxAlignmentInChars));
    
    // The maximum field alignment overrides the aligned attribute.
    if (!MaxFieldAlignment.isZero()) {
      FieldAlign.$assign(std.min(FieldAlign, MaxFieldAlignment));
      UnpackedFieldAlign.$assign(std.min(UnpackedFieldAlign, MaxFieldAlignment));
    }
    
    // Round up the current record size to the field's alignment boundary.
    FieldOffset.$assignMove(FieldOffset.alignTo(FieldAlign));
    UnpackedFieldOffset.$assignMove(UnpackedFieldOffset.alignTo(UnpackedFieldAlign));
    if (UseExternalLayout) {
      FieldOffset.$assignMove(Context.toCharUnitsFromBits(updateExternalFieldOffset(D, Context.toBits(new CharUnits(FieldOffset)))));
      if (!IsUnion && (EmptySubobjects != null)) {
        // Record the fact that we're placing a field at this offset.
        boolean Allowed = EmptySubobjects.CanPlaceFieldAtOffset(D, new CharUnits(FieldOffset));
        ///*J:(void)*/Allowed;
        assert (Allowed) : "Externally-placed field cannot be placed here";
      }
    } else {
      if (!IsUnion && (EmptySubobjects != null)) {
        // Check if we can place the field at this offset.
        while (!EmptySubobjects.CanPlaceFieldAtOffset(D, new CharUnits(FieldOffset))) {
          // We couldn't place the field at the offset. Try again at a new offset.
          FieldOffset.$addassign(FieldAlign);
        }
      }
    }
    
    // Place this field at the current location.
    FieldOffsets.push_back(Context.toBits(new CharUnits(FieldOffset)));
    if (!UseExternalLayout) {
      CheckFieldPadding(Context.toBits(new CharUnits(FieldOffset)), UnpaddedFieldOffset, 
          Context.toBits(new CharUnits(UnpackedFieldOffset)), 
          $long2uint(Context.toBits(new CharUnits(UnpackedFieldAlign))), FieldPacked, D);
    }
    if (InsertExtraPadding) {
      CharUnits ASanAlignment = CharUnits.fromQuantity(8);
      CharUnits ExtraSizeForAsan = new CharUnits(ASanAlignment);
      if ((FieldSize.$mod(ASanAlignment) != 0)) {
        ExtraSizeForAsan.$addassign(
            ASanAlignment.$sub(CharUnits.fromQuantity(FieldSize.$mod(ASanAlignment)))
        );
      }
      FieldSize.$addassign(ExtraSizeForAsan);
    }
    
    // Reserve space for this field.
    long/*uint64_t*/ FieldSizeInBits = Context.toBits(new CharUnits(FieldSize));
    if (IsUnion) {
      setDataSize(std.max(getDataSizeInBits(), FieldSizeInBits));
    } else {
      setDataSize(FieldOffset.$add(FieldSize));
    }
    
    // Update the size.
    setSize(std.max(getSizeInBits(), getDataSizeInBits()));
    
    // Remember max struct/class alignment.
    UpdateAlignment(new CharUnits(FieldAlign), new CharUnits(UnpackedFieldAlign));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutWideBitField">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1369,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutWideBitField", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder18LayoutWideBitFieldEyybPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder18LayoutWideBitFieldEyybPKN5clang9FieldDeclE")
  //</editor-fold>
  protected void LayoutWideBitField(long/*uint64_t*/ FieldSize, 
                    long/*uint64_t*/ TypeSize, 
                    boolean FieldPacked, 
                    /*const*/ FieldDecl /*P*/ D) {
    assert (Context.getLangOpts().CPlusPlus) : "Can only have wide bit-fields in C++!";
    
    // Itanium C++ ABI 2.4:
    //   If sizeof(T)*8 < n, let T' be the largest integral POD type with
    //   sizeof(T')*8 <= n.
    QualType IntegralPODTypes[/*5*/] = new QualType [/*5*/] {
      Context.UnsignedCharTy.$QualType(), Context.UnsignedShortTy.$QualType(), Context.UnsignedIntTy.$QualType(), 
      Context.UnsignedLongTy.$QualType(), Context.UnsignedLongLongTy.$QualType()
    };
    
    QualType Type/*J*/= new QualType();
    for (final /*const*/ QualType /*&*/ QT : IntegralPODTypes) {
      long/*uint64_t*/ Size = Context.getTypeSize(new QualType(QT));
      if ($greater_ulong(Size, FieldSize)) {
        break;
      }
      
      Type.$assign(QT);
    }
    assert (!Type.isNull()) : "Did not find a type!";
    
    CharUnits TypeAlign = Context.getTypeAlignInChars(new QualType(Type));
    
    // We're not going to use any of the unfilled bits in the last byte.
    UnfilledBitsInLastUnit = $int2uchar(0);
    LastBitfieldTypeSize = $int2uchar(0);
    
    long/*uint64_t*/ FieldOffset;
    long/*uint64_t*/ UnpaddedFieldOffset = getDataSizeInBits() - $uchar2ullong(UnfilledBitsInLastUnit);
    if (IsUnion) {
      long/*uint64_t*/ RoundedFieldSize = roundUpSizeToCharAlignment(FieldSize, 
          Context);
      setDataSize(std.max(getDataSizeInBits(), RoundedFieldSize));
      FieldOffset = $int2ulong(0);
    } else {
      // The bitfield is allocated starting at the next offset aligned 
      // appropriately for T', with length n bits.
      FieldOffset = llvm.alignTo(getDataSizeInBits(), Context.toBits(new CharUnits(TypeAlign)));
      
      long/*uint64_t*/ NewSizeInBits = FieldOffset + FieldSize;
      
      setDataSize(llvm.alignTo(NewSizeInBits, $uint2ulong(Context.getTargetInfo().getCharAlign())));
      UnfilledBitsInLastUnit = $ullong2uchar(getDataSizeInBits() - NewSizeInBits);
    }
    
    // Place this field at the current location.
    FieldOffsets.push_back(FieldOffset);
    
    CheckFieldPadding(FieldOffset, UnpaddedFieldOffset, FieldOffset, 
        $long2uint(Context.toBits(new CharUnits(TypeAlign))), FieldPacked, D);
    
    // Update the size.
    setSize(std.max(getSizeInBits(), getDataSizeInBits()));
    
    // Remember max struct/class alignment.
    UpdateAlignment(new CharUnits(TypeAlign));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1435,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutBitField", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder14LayoutBitFieldEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder14LayoutBitFieldEPKN5clang9FieldDeclE")
  //</editor-fold>
  protected void LayoutBitField(/*const*/ FieldDecl /*P*/ D) {
    boolean FieldPacked = Packed || D.hasAttr(PackedAttr.class);
    long/*uint64_t*/ FieldSize = $uint2ulong(D.getBitWidthValue(Context));
    TypeInfo FieldInfo = Context.getTypeInfo(D.getType());
    long/*uint64_t*/ TypeSize = FieldInfo.Width;
    /*uint*/int FieldAlign = FieldInfo.Align;
    
    // UnfilledBitsInLastUnit is the difference between the end of the
    // last allocated bitfield (i.e. the first bit offset available for
    // bitfields) and the end of the current data size in bits (i.e. the
    // first bit offset available for non-bitfields).  The current data
    // size in bits is always a multiple of the char size; additionally,
    // for ms_struct records it's also a multiple of the
    // LastBitfieldTypeSize (if set).
    
    // The struct-layout algorithm is dictated by the platform ABI,
    // which in principle could use almost any rules it likes.  In
    // practice, UNIXy targets tend to inherit the algorithm described
    // in the System V generic ABI.  The basic bitfield layout rule in
    // System V is to place bitfields at the next available bit offset
    // where the entire bitfield would fit in an aligned storage unit of
    // the declared type; it's okay if an earlier or later non-bitfield
    // is allocated in the same storage unit.  However, some targets
    // (those that !useBitFieldTypeAlignment(), e.g. ARM APCS) don't
    // require this storage unit to be aligned, and therefore always put
    // the bitfield at the next available bit offset.
    
    // ms_struct basically requests a complete replacement of the
    // platform ABI's struct-layout algorithm, with the high-level goal
    // of duplicating MSVC's layout.  For non-bitfields, this follows
    // the standard algorithm.  The basic bitfield layout rule is to
    // allocate an entire unit of the bitfield's declared type
    // (e.g. 'unsigned long'), then parcel it up among successive
    // bitfields whose declared types have the same size, making a new
    // unit as soon as the last can no longer store the whole value.
    // Since it completely replaces the platform ABI's algorithm,
    // settings like !useBitFieldTypeAlignment() do not apply.
    
    // A zero-width bitfield forces the use of a new storage unit for
    // later bitfields.  In general, this occurs by rounding up the
    // current size of the struct as if the algorithm were about to
    // place a non-bitfield of the field's formal type.  Usually this
    // does not change the alignment of the struct itself, but it does
    // on some targets (those that useZeroLengthBitfieldAlignment(),
    // e.g. ARM).  In ms_struct layout, zero-width bitfields are
    // ignored unless they follow a non-zero-width bitfield.
    
    // A field alignment restriction (e.g. from #pragma pack) or
    // specification (e.g. from __attribute__((aligned))) changes the
    // formal alignment of the field.  For System V, this alters the
    // required alignment of the notional storage unit that must contain
    // the bitfield.  For ms_struct, this only affects the placement of
    // new storage units.  In both cases, the effect of #pragma pack is
    // ignored on zero-width bitfields.
    
    // On System V, a packed field (e.g. from #pragma pack or
    // __attribute__((packed))) always uses the next available bit
    // offset.
    
    // In an ms_struct struct, the alignment of a fundamental type is
    // always equal to its size.  This is necessary in order to mimic
    // the i386 alignment rules on targets which might not fully align
    // all types (e.g. Darwin PPC32, where alignof(long long) == 4).
    
    // First, some simple bookkeeping to perform for ms_struct structs.
    if (IsMsStruct) {
      // The field alignment for integer types is always the size.
      FieldAlign = $ulong2uint(TypeSize);
      
      // If the previous field was not a bitfield, or was a bitfield
      // with a different storage unit size, we're done with that
      // storage unit.
      if ($uchar2ullong(LastBitfieldTypeSize) != TypeSize) {
        // Also, ignore zero-length bitfields after non-bitfields.
        if (!(LastBitfieldTypeSize != 0) && !(FieldSize != 0)) {
          FieldAlign = 1;
        }
        
        UnfilledBitsInLastUnit = $int2uchar(0);
        LastBitfieldTypeSize = $int2uchar(0);
      }
    }
    
    // If the field is wider than its declared type, it follows
    // different rules in all cases.
    if ($greater_ulong(FieldSize, TypeSize)) {
      LayoutWideBitField(FieldSize, TypeSize, FieldPacked, D);
      return;
    }
    
    // Compute the next available bit offset.
    long/*uint64_t*/ FieldOffset = IsUnion ? $int2ullong(0) : (getDataSizeInBits() - $uchar2ullong(UnfilledBitsInLastUnit));
    
    // Handle targets that don't honor bitfield type alignment.
    if (!IsMsStruct && !Context.getTargetInfo().useBitFieldTypeAlignment()) {
      // Some such targets do honor it on zero-width bitfields.
      if (FieldSize == $int2ullong(0)
         && Context.getTargetInfo().useZeroLengthBitfieldAlignment()) {
        // The alignment to round up to is the max of the field's natural
        // alignment and a target-specific fixed value (sometimes zero).
        /*uint*/int ZeroLengthBitfieldBoundary = Context.getTargetInfo().getZeroLengthBitfieldBoundary();
        FieldAlign = std.max(FieldAlign, ZeroLengthBitfieldBoundary);
        // If that doesn't apply, just ignore the field alignment.
      } else {
        FieldAlign = 1;
      }
    }
    
    // Remember the alignment we would have used if the field were not packed.
    /*uint*/int UnpackedFieldAlign = FieldAlign;
    
    // Ignore the field alignment if the field is packed unless it has zero-size.
    if (!IsMsStruct && FieldPacked && FieldSize != $int2ullong(0)) {
      FieldAlign = 1;
    }
    
    // But, if there's an 'aligned' attribute on the field, honor that.
    /*uint*/int ExplicitFieldAlign = D.getMaxAlignment();
    if ((ExplicitFieldAlign != 0)) {
      FieldAlign = std.max(FieldAlign, ExplicitFieldAlign);
      UnpackedFieldAlign = std.max(UnpackedFieldAlign, ExplicitFieldAlign);
    }
    
    // But, if there's a #pragma pack in play, that takes precedent over
    // even the 'aligned' attribute, for non-zero-width bitfields.
    /*uint*/int MaxFieldAlignmentInBits = $long2uint(Context.toBits(new CharUnits(MaxFieldAlignment)));
    if (!MaxFieldAlignment.isZero() && (FieldSize != 0)) {
      UnpackedFieldAlign = std.min_uint(UnpackedFieldAlign, MaxFieldAlignmentInBits);
      if (FieldPacked) {
        FieldAlign = UnpackedFieldAlign;
      } else {
        FieldAlign = std.min_uint(FieldAlign, MaxFieldAlignmentInBits);
      }
    }
    
    // But, ms_struct just ignores all of that in unions, even explicit
    // alignment attributes.
    if (IsMsStruct && IsUnion) {
      FieldAlign = UnpackedFieldAlign = 1;
    }
    
    // For purposes of diagnostics, we're going to simultaneously
    // compute the field offsets that we would have used if we weren't
    // adding any alignment padding or if the field weren't packed.
    long/*uint64_t*/ UnpaddedFieldOffset = FieldOffset;
    long/*uint64_t*/ UnpackedFieldOffset = FieldOffset;
    
    // Check if we need to add padding to fit the bitfield within an
    // allocation unit with the right size and alignment.  The rules are
    // somewhat different here for ms_struct structs.
    if (IsMsStruct) {
      // If it's not a zero-width bitfield, and we can fit the bitfield
      // into the active storage unit (and we haven't already decided to
      // start a new storage unit), just do so, regardless of any other
      // other consideration.  Otherwise, round up to the right alignment.
      if (FieldSize == $int2ullong(0) || $greater_ulong_uchar(FieldSize, UnfilledBitsInLastUnit)) {
        FieldOffset = llvm.alignTo(FieldOffset, $uint2ulong(FieldAlign));
        UnpackedFieldOffset
           = llvm.alignTo(UnpackedFieldOffset, $uint2ulong(UnpackedFieldAlign));
        UnfilledBitsInLastUnit = $int2uchar(0);
      }
    } else {
      // #pragma pack, with any value, suppresses the insertion of padding.
      boolean AllowPadding = MaxFieldAlignment.isZero();
      
      // Compute the real offset.
      if (FieldSize == $int2ullong(0)
         || (AllowPadding
         && $greater_ullong_ulong((FieldOffset & $uint2ullong((FieldAlign - 1))) + FieldSize, TypeSize))) {
        FieldOffset = llvm.alignTo(FieldOffset, $uint2ulong(FieldAlign));
      } else if ((ExplicitFieldAlign != 0)
         && (MaxFieldAlignmentInBits == 0
         || $lesseq_uint(ExplicitFieldAlign, MaxFieldAlignmentInBits))
         && Context.getTargetInfo().useExplicitBitFieldAlignment()) {
        // TODO: figure it out what needs to be done on targets that don't honor
        // bit-field type alignment like ARM APCS ABI.
        FieldOffset = llvm.alignTo(FieldOffset, $uint2ulong(ExplicitFieldAlign));
      }
      
      // Repeat the computation for diagnostic purposes.
      if (FieldSize == $int2ullong(0)
         || (AllowPadding
         && $greater_ullong_ulong((UnpackedFieldOffset & $uint2ullong((UnpackedFieldAlign - 1))) + FieldSize, TypeSize))) {
        UnpackedFieldOffset
           = llvm.alignTo(UnpackedFieldOffset, $uint2ulong(UnpackedFieldAlign));
      } else if ((ExplicitFieldAlign != 0)
         && (MaxFieldAlignmentInBits == 0
         || $lesseq_uint(ExplicitFieldAlign, MaxFieldAlignmentInBits))
         && Context.getTargetInfo().useExplicitBitFieldAlignment()) {
        UnpackedFieldOffset
           = llvm.alignTo(UnpackedFieldOffset, $uint2ulong(ExplicitFieldAlign));
      }
    }
    
    // If we're using external layout, give the external layout a chance
    // to override this information.
    if (UseExternalLayout) {
      FieldOffset = updateExternalFieldOffset(D, FieldOffset);
    }
    
    // Okay, place the bitfield at the calculated offset.
    FieldOffsets.push_back(FieldOffset);
    
    // Bookkeeping:
    
    // Anonymous members don't affect the overall record alignment,
    // except on targets where they do.
    if (!IsMsStruct
       && !Context.getTargetInfo().useZeroLengthBitfieldAlignment()
       && !(D.getIdentifier() != null)) {
      FieldAlign = UnpackedFieldAlign = 1;
    }
    
    // Diagnose differences in layout due to padding or packing.
    if (!UseExternalLayout) {
      CheckFieldPadding(FieldOffset, UnpaddedFieldOffset, UnpackedFieldOffset, 
          UnpackedFieldAlign, FieldPacked, D);
    }
    
    // Update DataSize to include the last byte containing (part of) the bitfield.
    
    // For unions, this is just a max operation, as usual.
    if (IsUnion) {
      // For ms_struct, allocate the entire storage unit --- unless this
      // is a zero-width bitfield, in which case just use a size of 1.
      long/*uint64_t*/ RoundedFieldSize;
      if (IsMsStruct) {
        RoundedFieldSize
           = ((FieldSize != 0) ? TypeSize : $uint2ullong(Context.getTargetInfo().getCharWidth()));
        // Otherwise, allocate just the number of bytes required to store
        // the bitfield.
      } else {
        RoundedFieldSize = roundUpSizeToCharAlignment(FieldSize, Context);
      }
      setDataSize(std.max(getDataSizeInBits(), RoundedFieldSize));
      // For non-zero-width bitfields in ms_struct structs, allocate a new
      // storage unit if necessary.
    } else if (IsMsStruct && (FieldSize != 0)) {
      // We should have cleared UnfilledBitsInLastUnit in every case
      // where we changed storage units.
      if (!(UnfilledBitsInLastUnit != 0)) {
        setDataSize(FieldOffset + TypeSize);
        UnfilledBitsInLastUnit = $ulong2uchar(TypeSize);
      }
      UnfilledBitsInLastUnit -= FieldSize;
      LastBitfieldTypeSize = $ulong2uchar(TypeSize);
      // Otherwise, bump the data size up to include the bitfield,
      // including padding up to char alignment, and then remember how
      // bits we didn't use.
    } else {
      long/*uint64_t*/ NewSizeInBits = FieldOffset + FieldSize;
      long/*uint64_t*/ CharAlignment = $uint2ulong(Context.getTargetInfo().getCharAlign());
      setDataSize(llvm.alignTo(NewSizeInBits, CharAlignment));
      UnfilledBitsInLastUnit = $ullong2uchar(getDataSizeInBits() - NewSizeInBits);
      
      // The only time we can get here for an ms_struct is if this is a
      // zero-width bitfield, which doesn't count as anything for the
      // purposes of unfilled bits.
      LastBitfieldTypeSize = $int2uchar(0);
    }
    
    // Update the size.
    setSize(std.max(getSizeInBits(), getDataSizeInBits()));
    
    // Remember max struct/class alignment.
    UpdateAlignment(Context.toCharUnitsFromBits($uint2long(FieldAlign)), 
        Context.toCharUnitsFromBits($uint2long(UnpackedFieldAlign)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::getCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 681,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::getCXXABI", NM="_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder9getCXXABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder9getCXXABIEv")
  //</editor-fold>
  protected TargetCXXABI getCXXABI() /*const*/ {
    return Context.getTargetInfo().getCXXABI();
  }

  
  /// BaseSubobjectInfoAllocator - Allocator for BaseSubobjectInfo objects.
  protected SpecificBumpPtrAllocator<BaseSubobjectInfo> BaseSubobjectInfoAllocator;
  
  /*typedef llvm::DenseMap<const CXXRecordDecl *, BaseSubobjectInfo *> BaseSubobjectInfoMapTy*/
//  public final class BaseSubobjectInfoMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , BaseSubobjectInfo /*P*/ >{ };
  
  /// VirtualBaseInfo - Map from all the (direct or indirect) virtual bases
  /// of the class we're laying out to their base subobject info.
  protected DenseMap</*const*/ CXXRecordDecl /*P*/ , BaseSubobjectInfo /*P*/ > VirtualBaseInfo;
  
  /// NonVirtualBaseInfo - Map from all the direct non-virtual bases of the
  /// class we're laying out to their base subobject info.
  protected DenseMap</*const*/ CXXRecordDecl /*P*/ , BaseSubobjectInfo /*P*/ > NonVirtualBaseInfo;
  
  /// ComputeBaseSubobjectInfo - Compute the base subobject information for the
  /// bases of the given class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::ComputeBaseSubobjectInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 941,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::ComputeBaseSubobjectInfo", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder24ComputeBaseSubobjectInfoEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder24ComputeBaseSubobjectInfoEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  protected void ComputeBaseSubobjectInfo(/*const*/ CXXRecordDecl /*P*/ RD) {
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      boolean IsVirtual = I.isVirtual();
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = I.getType().$arrow().getAsCXXRecordDecl();
      
      // Compute the base subobject info for this base.
      BaseSubobjectInfo /*P*/ Info = ComputeBaseSubobjectInfo(BaseDecl, IsVirtual, 
          (BaseSubobjectInfo /*P*/ )null);
      if (IsVirtual) {
        // ComputeBaseInfo has already added this base for us.
        assert ((VirtualBaseInfo.count(BaseDecl) != 0)) : "Did not add virtual base!";
      } else {
        // Add the base info to the map of non-virtual bases.
        assert (!(NonVirtualBaseInfo.count(BaseDecl) != 0)) : "Non-virtual base already exists!";
        NonVirtualBaseInfo.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(BaseDecl, Info));
      }
    }
  }

  
  /// ComputeBaseSubobjectInfo - Compute the base subobject information for a
  /// single class and all of its base classes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::ComputeBaseSubobjectInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 864,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::ComputeBaseSubobjectInfo", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder24ComputeBaseSubobjectInfoEPKN5clang13CXXRecordDeclEbPNS_17BaseSubobjectInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder24ComputeBaseSubobjectInfoEPKN5clang13CXXRecordDeclEbPNS_17BaseSubobjectInfoE")
  //</editor-fold>
  protected BaseSubobjectInfo /*P*/ ComputeBaseSubobjectInfo(/*const*/ CXXRecordDecl /*P*/ RD, boolean IsVirtual, BaseSubobjectInfo /*P*/ Derived) {
    BaseSubobjectInfo /*P*/ Info;
    if (IsVirtual) {
      // Check if we already have info about this virtual base.
      final type$ref<BaseSubobjectInfo /*P*/ /*&*/> InfoSlot = VirtualBaseInfo.ref$at(RD);
      if ((InfoSlot.$deref() != null)) {
        assert (InfoSlot.$deref().Class == RD) : "Wrong class for virtual base info!";
        return InfoSlot.$deref();
      }
      
      // We don't, create it.
      InfoSlot.$set(/*NEW_EXPR [System]*/$new_uint_voidPtr(BaseSubobjectInfoAllocator.Allocate(), (type$ptr<?> New$Mem)->{
          return new BaseSubobjectInfo();
       }));
      Info = InfoSlot.$deref();
    } else {
      Info = /*NEW_EXPR [System]*/$new_uint_voidPtr(BaseSubobjectInfoAllocator.Allocate(), (type$ptr<?> New$Mem)->{
          return new BaseSubobjectInfo();
       });
    }
    
    Info.Class = RD;
    Info.IsVirtual = IsVirtual;
    Info.Derived = null;
    Info.PrimaryVirtualBaseInfo = null;
    
    /*const*/ CXXRecordDecl /*P*/ PrimaryVirtualBase = null;
    BaseSubobjectInfo /*P*/ PrimaryVirtualBaseInfo = null;
    
    // Check if this base has a primary virtual base.
    if ((RD.getNumVBases() != 0)) {
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
      if (Layout.isPrimaryBaseVirtual()) {
        // This base does have a primary virtual base.
        PrimaryVirtualBase = Layout.getPrimaryBase();
        assert ((PrimaryVirtualBase != null)) : "Didn't have a primary virtual base!";
        
        // Now check if we have base subobject info about this primary base.
        PrimaryVirtualBaseInfo = VirtualBaseInfo.lookup(PrimaryVirtualBase);
        if ((PrimaryVirtualBaseInfo != null)) {
          if ((PrimaryVirtualBaseInfo.Derived != null)) {
            // We did have info about this primary base, and it turns out that it
            // has already been claimed as a primary virtual base for another
            // base.
            PrimaryVirtualBase = null;
          } else {
            // We can claim this base as our primary base.
            Info.PrimaryVirtualBaseInfo = PrimaryVirtualBaseInfo;
            PrimaryVirtualBaseInfo.Derived = Info;
          }
        }
      }
    }
    
    // Now go through all direct bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      boolean IsVirtual$1 = I.isVirtual();
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = I.getType().$arrow().getAsCXXRecordDecl();
      
      Info.Bases.push_back(ComputeBaseSubobjectInfo(BaseDecl, IsVirtual$1, Info));
    }
    if ((PrimaryVirtualBase != null) && !(PrimaryVirtualBaseInfo != null)) {
      // Traversing the bases must have created the base info for our primary
      // virtual base.
      PrimaryVirtualBaseInfo = VirtualBaseInfo.lookup(PrimaryVirtualBase);
      assert ((PrimaryVirtualBaseInfo != null)) : "Did not create a primary virtual base!";
      
      // Claim the primary virtual base as our primary virtual base.
      Info.PrimaryVirtualBaseInfo = PrimaryVirtualBaseInfo;
      PrimaryVirtualBaseInfo.Derived = Info;
    }
    
    return Info;
  }

  
  /// DeterminePrimaryBase - Determine the primary base of the given class.
  
  /// DeterminePrimaryBase - Determine the primary base of the given class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::DeterminePrimaryBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 817,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::DeterminePrimaryBase", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder20DeterminePrimaryBaseEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder20DeterminePrimaryBaseEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  protected void DeterminePrimaryBase(/*const*/ CXXRecordDecl /*P*/ RD) {
    // If the class isn't dynamic, it won't have a primary base.
    if (!RD.isDynamicClass()) {
      return;
    }
    
    // Compute all the primary virtual bases for all of our direct and
    // indirect bases, and record all their primary virtual base classes.
    RD.getIndirectPrimaryBases(IndirectPrimaryBases);
    
    // If the record has a dynamic base class, attempt to choose a primary base
    // class. It is the first (in direct base class order) non-virtual dynamic
    // base class, if one exists.
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      // Ignore virtual bases.
      if (I.isVirtual()) {
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ Base = I.getType().$arrow().getAsCXXRecordDecl();
      if (Base.isDynamicClass()) {
        // We found it.
        PrimaryBase = Base;
        PrimaryBaseIsVirtual = false;
        return;
      }
    }
    
    // Under the Itanium ABI, if there is no non-virtual primary base class,
    // try to compute the primary virtual base.  The primary virtual base is
    // the first nearly empty virtual base that is not an indirect primary
    // virtual base class, if one exists.
    if (RD.getNumVBases() != 0) {
      SelectPrimaryVBase(RD);
      if ((PrimaryBase != null)) {
        return;
      }
    }
    
    // Otherwise, it is the first indirect primary base class, if one exists.
    if ((FirstNearlyEmptyVBase != null)) {
      PrimaryBase = FirstNearlyEmptyVBase;
      PrimaryBaseIsVirtual = true;
      return;
    }
    assert (!(PrimaryBase != null)) : "Should not get here with a primary base!";
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::SelectPrimaryVBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 788,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::SelectPrimaryVBase", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder18SelectPrimaryVBaseEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder18SelectPrimaryVBaseEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  protected void SelectPrimaryVBase(/*const*/ CXXRecordDecl /*P*/ RD) {
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      assert (!I.getType().$arrow().isDependentType()) : "Cannot layout class with dependent bases.";
      
      /*const*/ CXXRecordDecl /*P*/ Base = I.getType().$arrow().getAsCXXRecordDecl();
      
      // Check if this is a nearly empty virtual base.
      if (I.isVirtual() && Context.isNearlyEmpty(Base)) {
        // If it's not an indirect primary base, then we've found our primary
        // base.
        if (!(IndirectPrimaryBases.count(Base) != 0)) {
          PrimaryBase = Base;
          PrimaryBaseIsVirtual = true;
          return;
        }
        
        // Is this the first nearly empty virtual base?
        if (!(FirstNearlyEmptyVBase != null)) {
          FirstNearlyEmptyVBase = Base;
        }
      }
      
      SelectPrimaryVBase(Base);
      if ((PrimaryBase != null)) {
        return;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::EnsureVTablePointerAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 965,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::EnsureVTablePointerAlignment", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder28EnsureVTablePointerAlignmentEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder28EnsureVTablePointerAlignmentEN5clang9CharUnitsE")
  //</editor-fold>
  protected void EnsureVTablePointerAlignment(CharUnits UnpackedBaseAlign) {
    CharUnits BaseAlign = (Packed) ? CharUnits.One() : new CharUnits(UnpackedBaseAlign);
    
    // The maximum field alignment overrides base align.
    if (!MaxFieldAlignment.isZero()) {
      BaseAlign.$assign(std.min(BaseAlign, MaxFieldAlignment));
      UnpackedBaseAlign.$assign(std.min(UnpackedBaseAlign, MaxFieldAlignment));
    }
    
    // Round up the current record size to pointer alignment.
    setSize(getSize().alignTo(BaseAlign));
    setDataSize(getSize());
    
    // Update the alignment.
    UpdateAlignment(new CharUnits(BaseAlign), new CharUnits(UnpackedBaseAlign));
  }

  
  /// LayoutNonVirtualBases - Determines the primary base class (if any) and
  /// lays it out. Will then proceed to lay out all non-virtual base clasess.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutNonVirtualBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 983,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutNonVirtualBases", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder21LayoutNonVirtualBasesEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder21LayoutNonVirtualBasesEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  protected void LayoutNonVirtualBases(/*const*/ CXXRecordDecl /*P*/ RD) {
    // Then, determine the primary base class.
    DeterminePrimaryBase(RD);
    
    // Compute base subobject info.
    ComputeBaseSubobjectInfo(RD);
    
    // If we have a primary base class, lay it out.
    if ((PrimaryBase != null)) {
      if (PrimaryBaseIsVirtual) {
        // If the primary virtual base was a primary virtual base of some other
        // base class we'll have to steal it.
        BaseSubobjectInfo /*P*/ PrimaryBaseInfo = VirtualBaseInfo.lookup(PrimaryBase);
        PrimaryBaseInfo.Derived = null;
        
        // We have a virtual primary base, insert it as an indirect primary base.
        IndirectPrimaryBases.insert(PrimaryBase);
        assert (!(VisitedVirtualBases.count(PrimaryBase) != 0)) : "vbase already visited!";
        VisitedVirtualBases.insert(PrimaryBase);
        
        LayoutVirtualBase(PrimaryBaseInfo);
      } else {
        BaseSubobjectInfo /*P*/ PrimaryBaseInfo = NonVirtualBaseInfo.lookup(PrimaryBase);
        assert ((PrimaryBaseInfo != null)) : "Did not find base info for non-virtual primary base!";
        
        LayoutNonVirtualBase(PrimaryBaseInfo);
      }
      // If this class needs a vtable/vf-table and didn't get one from a
      // primary base, add it in now.
    } else if (RD.isDynamicClass()) {
      assert (DataSize == $int2ullong(0)) : "Vtable pointer must be at offset zero!";
      CharUnits PtrWidth = Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerWidth(0));
      CharUnits PtrAlign = Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerAlign(0));
      EnsureVTablePointerAlignment(new CharUnits(PtrAlign));
      HasOwnVFPtr = true;
      setSize(getSize().$add(PtrWidth));
      setDataSize(getSize());
    }
    
    // Now lay out the non-virtual bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : RD.bases$Const()) {
      
      // Ignore virtual bases.
      if (I.isVirtual()) {
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = I.getType().$arrow().getAsCXXRecordDecl();
      
      // Skip the primary base, because we've already laid it out.  The
      // !PrimaryBaseIsVirtual check is required because we might have a
      // non-virtual base of the same type as a primary virtual base.
      if (BaseDecl == PrimaryBase && !PrimaryBaseIsVirtual) {
        continue;
      }
      
      // Lay out the base.
      BaseSubobjectInfo /*P*/ BaseInfo = NonVirtualBaseInfo.lookup(BaseDecl);
      assert ((BaseInfo != null)) : "Did not find base info for non-virtual base!";
      
      LayoutNonVirtualBase(BaseInfo);
    }
  }

  
  /// LayoutNonVirtualBase - Lays out a single non-virtual base.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutNonVirtualBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1053,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutNonVirtualBase", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder20LayoutNonVirtualBaseEPKNS_17BaseSubobjectInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder20LayoutNonVirtualBaseEPKNS_17BaseSubobjectInfoE")
  //</editor-fold>
  protected void LayoutNonVirtualBase(/*const*/ BaseSubobjectInfo /*P*/ Base) {
    // Layout the base.
    CharUnits Offset = LayoutBase(Base);
    
    // Add its base class offset.
    assert (!(Bases.count(Base.Class) != 0)) : "base offset already exists!";
    Bases.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(Base.Class, Offset));
    
    AddPrimaryVirtualBaseOffsets(Base, new CharUnits(Offset));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::AddPrimaryVirtualBaseOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1065,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::AddPrimaryVirtualBaseOffsets", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder28AddPrimaryVirtualBaseOffsetsEPKNS_17BaseSubobjectInfoEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder28AddPrimaryVirtualBaseOffsetsEPKNS_17BaseSubobjectInfoEN5clang9CharUnitsE")
  //</editor-fold>
  protected void AddPrimaryVirtualBaseOffsets(/*const*/ BaseSubobjectInfo /*P*/ Info, CharUnits Offset) {
    // This base isn't interesting, it has no virtual bases.
    if (!(Info.Class.getNumVBases() != 0)) {
      return;
    }
    
    // First, check if we have a virtual primary base to add offsets for.
    if ((Info.PrimaryVirtualBaseInfo != null)) {
      assert (Info.PrimaryVirtualBaseInfo.IsVirtual) : "Primary virtual base is not virtual!";
      if (Info.PrimaryVirtualBaseInfo.Derived == Info) {
        // Add the offset.
        assert (!(VBases.count(Info.PrimaryVirtualBaseInfo.Class) != 0)) : "primary vbase offset already exists!";
        VBases.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(Info.PrimaryVirtualBaseInfo.Class, 
                new ASTRecordLayout.VBaseInfo(new CharUnits(Offset), false)));
        
        // Traverse the primary virtual base.
        AddPrimaryVirtualBaseOffsets(Info.PrimaryVirtualBaseInfo, new CharUnits(Offset));
      }
    }
    
    // Now go through all direct non-virtual bases.
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(Info.Class);
    for (/*const*/ BaseSubobjectInfo /*P*/ Base : Info.Bases) {
      if (Base.IsVirtual) {
        continue;
      }
      
      CharUnits BaseOffset = Offset.$add(Layout.getBaseClassOffset(Base.Class));
      AddPrimaryVirtualBaseOffsets(Base, new CharUnits(BaseOffset));
    }
  }

  
  /// LayoutVirtualBases - Lays out all the virtual bases.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutVirtualBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1098,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutVirtualBases", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder18LayoutVirtualBasesEPKN5clang13CXXRecordDeclES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder18LayoutVirtualBasesEPKN5clang13CXXRecordDeclES4_")
  //</editor-fold>
  protected void LayoutVirtualBases(/*const*/ CXXRecordDecl /*P*/ RD, /*const*/ CXXRecordDecl /*P*/ MostDerivedClass) {
    /*const*/ CXXRecordDecl /*P*/ PrimaryBase;
    boolean PrimaryBaseIsVirtual;
    if (MostDerivedClass == RD) {
      PrimaryBase = this.PrimaryBase;
      PrimaryBaseIsVirtual = this.PrimaryBaseIsVirtual;
    } else {
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
      PrimaryBase = Layout.getPrimaryBase();
      PrimaryBaseIsVirtual = Layout.isPrimaryBaseVirtual();
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      assert (!Base.getType().$arrow().isDependentType()) : "Cannot layout class with dependent bases.";
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      if (Base.isVirtual()) {
        if (PrimaryBase != BaseDecl || !PrimaryBaseIsVirtual) {
          boolean IndirectPrimaryBase = (IndirectPrimaryBases.count(BaseDecl) != 0);
          
          // Only lay out the virtual base if it's not an indirect primary base.
          if (!IndirectPrimaryBase) {
            // Only visit virtual bases once.
            if (!VisitedVirtualBases.insert(BaseDecl).second) {
              continue;
            }
            
            /*const*/ BaseSubobjectInfo /*P*/ BaseInfo = VirtualBaseInfo.lookup(BaseDecl);
            assert ((BaseInfo != null)) : "Did not find virtual base info!";
            LayoutVirtualBase(BaseInfo);
          }
        }
      }
      if (!(BaseDecl.getNumVBases() != 0)) {
        // This base isn't interesting since it doesn't have any virtual bases.
        continue;
      }
      
      LayoutVirtualBases(BaseDecl, MostDerivedClass);
    }
  }

  
  /// LayoutVirtualBase - Lays out a single virtual base.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutVirtualBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1144,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutVirtualBase", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder17LayoutVirtualBaseEPKNS_17BaseSubobjectInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder17LayoutVirtualBaseEPKNS_17BaseSubobjectInfoE")
  //</editor-fold>
  protected void LayoutVirtualBase(/*const*/ BaseSubobjectInfo /*P*/ Base) {
    assert (!(Base.Derived != null)) : "Trying to lay out a primary virtual base!";
    
    // Layout the base.
    CharUnits Offset = LayoutBase(Base);
    
    // Add its base class offset.
    assert (!(VBases.count(Base.Class) != 0)) : "vbase offset already exists!";
    VBases.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(Base.Class, 
            new ASTRecordLayout.VBaseInfo(new CharUnits(Offset), false)));
    
    AddPrimaryVirtualBaseOffsets(Base, new CharUnits(Offset));
  }

  
  /// LayoutBase - Will lay out a base and return the offset where it was
  /// placed, in chars.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1159,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::LayoutBase", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder10LayoutBaseEPKNS_17BaseSubobjectInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder10LayoutBaseEPKNS_17BaseSubobjectInfoE")
  //</editor-fold>
  protected CharUnits LayoutBase(/*const*/ BaseSubobjectInfo /*P*/ Base) {
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(Base.Class);
    
    CharUnits Offset/*J*/= new CharUnits();
    
    // Query the external layout to see if it provides an offset.
    boolean HasExternalLayout = false;
    if (UseExternalLayout) {
      DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , CharUnits> Known/*J*/= new DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , CharUnits>();
      if (Base.IsVirtual) {
        HasExternalLayout = External.getExternalNVBaseOffset(Base.Class, Offset);
      } else {
        HasExternalLayout = External.getExternalVBaseOffset(Base.Class, Offset);
      }
    }
    
    CharUnits UnpackedBaseAlign = Layout.getNonVirtualAlignment();
    CharUnits BaseAlign = (Packed) ? CharUnits.One() : new CharUnits(UnpackedBaseAlign);
    
    // If we have an empty base class, try to place it at offset 0.
    if (Base.Class.isEmpty()
       && (!HasExternalLayout || Offset.$eq(CharUnits.Zero()))
       && EmptySubobjects.CanPlaceBaseAtOffset(Base, CharUnits.Zero())) {
      setSize(new CharUnits(std.max(getSize(), Layout.getSize())));
      UpdateAlignment(new CharUnits(BaseAlign), new CharUnits(UnpackedBaseAlign));
      
      return CharUnits.Zero();
    }
    
    // The maximum field alignment overrides base align.
    if (!MaxFieldAlignment.isZero()) {
      BaseAlign.$assign(std.min(BaseAlign, MaxFieldAlignment));
      UnpackedBaseAlign.$assign(std.min(UnpackedBaseAlign, MaxFieldAlignment));
    }
    if (!HasExternalLayout) {
      // Round up the current record size to the base's alignment boundary.
      Offset.$assignMove(getDataSize().alignTo(BaseAlign));
      
      // Try to place the base.
      while (!EmptySubobjects.CanPlaceBaseAtOffset(Base, new CharUnits(Offset))) {
        Offset.$addassign(BaseAlign);
      }
    } else {
      boolean Allowed = EmptySubobjects.CanPlaceBaseAtOffset(Base, new CharUnits(Offset));
      ///*J:(void)*/Allowed;
      assert (Allowed) : "Base subobject externally placed at overlapping offset";
      if (InferAlignment && Offset.$less(getDataSize().alignTo(BaseAlign))) {
        // The externally-supplied base offset is before the base offset we
        // computed. Assume that the structure is packed.
        Alignment.$assignMove(CharUnits.One());
        InferAlignment = false;
      }
    }
    if (!Base.Class.isEmpty()) {
      // Update the data size.
      setDataSize(Offset.$add(Layout.getNonVirtualSize()));
      
      setSize(new CharUnits(std.max(getSize(), getDataSize())));
    } else {
      setSize(new CharUnits(std.max(getSize(), Offset.$add(Layout.getSize()))));
    }
    
    // Remember max struct/class alignment.
    UpdateAlignment(new CharUnits(BaseAlign), new CharUnits(UnpackedBaseAlign));
    
    return Offset;
  }

  
  /// InitializeLayout - Initialize record layout for the given record decl.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::InitializeLayout">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1229,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::InitializeLayout", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder16InitializeLayoutEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder16InitializeLayoutEPKN5clang4DeclE")
  //</editor-fold>
  protected void InitializeLayout(/*const*/ Decl /*P*/ D) {
    {
      /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(D);
      if ((RD != null)) {
        IsUnion = RD.isUnion();
        IsMsStruct = RD.isMsStruct(Context);
      }
    }
    
    Packed = D.hasAttr(PackedAttr.class);
    {
      
      // Honor the default struct packing maximum alignment flag.
      /*uint*/int DefaultMaxFieldAlignment = Context.getLangOpts().PackStruct;
      if ((DefaultMaxFieldAlignment != 0)) {
        MaxFieldAlignment.$assignMove(CharUnits.fromQuantity($uint2long(DefaultMaxFieldAlignment)));
      }
    }
    
    // mac68k alignment supersedes maximum field alignment and attribute aligned,
    // and forces all structures to have 2-byte alignment. The IBM docs on it
    // allude to additional (more complicated) semantics, especially with regard
    // to bit-fields, but gcc appears not to follow that.
    if (D.hasAttr(AlignMac68kAttr.class)) {
      IsMac68kAlign = true;
      MaxFieldAlignment.$assignMove(CharUnits.fromQuantity(2));
      Alignment.$assignMove(CharUnits.fromQuantity(2));
    } else {
      {
        /*const*/ MaxFieldAlignmentAttr /*P*/ MFAA = D.getAttr(MaxFieldAlignmentAttr.class);
        if ((MFAA != null)) {
          MaxFieldAlignment.$assignMove(Context.toCharUnitsFromBits($uint2long(MFAA.getAlignment())));
        }
      }
      {
        
        /*uint*/int MaxAlign = D.getMaxAlignment();
        if ((MaxAlign != 0)) {
          UpdateAlignment(Context.toCharUnitsFromBits($uint2long(MaxAlign)));
        }
      }
    }
    {
      
      // If there is an external AST source, ask it for the various offsets.
      /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(D);
      if ((RD != null)) {
        {
          ExternalASTSource /*P*/ Source = Context.getExternalSource();
          if ((Source != null)) {
            ulong$ref $ExternalSize = create_ulong$ref(External.Size);
            ulong$ref $ExternalAlign = create_ulong$ref(External.Align);
            UseExternalLayout = Source.layoutRecordType(RD, $ExternalSize, $ExternalAlign, External.FieldOffsets, 
                External.BaseOffsets, External.VirtualBaseOffsets);
            External.Size = $ExternalSize.$deref();
            External.Align = $ExternalAlign.$deref();
            
            // Update based on external alignment.
            if (UseExternalLayout) {
              if ($greater_ulong_ullong(External.Align, $int2ullong(0))) {
                Alignment.$assignMove(Context.toCharUnitsFromBits(External.Align));
              } else {
                // The external source didn't have alignment information; infer it.
                InferAlignment = true;
              }
            }
          }
        }
      }
    }
  }

  
  /// FinishLayout - Finalize record layout. Adjust record size based on the
  /// alignment.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::FinishLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1831,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::FinishLayout", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder12FinishLayoutEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder12FinishLayoutEPKN5clang9NamedDeclE")
  //</editor-fold>
  protected void FinishLayout(/*const*/ NamedDecl /*P*/ D) {
    // In C++, records cannot be of size 0.
    if (Context.getLangOpts().CPlusPlus && getSizeInBits() == $int2ullong(0)) {
      {
        /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
        if ((RD != null)) {
          // Compatibility with gcc requires a class (pod or non-pod)
          // which is not empty but of size 0; such as having fields of
          // array of zero-length, remains of Size 0
          if (RD.isEmpty()) {
            setSize(CharUnits.One());
          }
        } else {
          setSize(CharUnits.One());
        }
      }
    }
    
    // Finally, round the size of the record up to the alignment of the
    // record itself.
    long/*uint64_t*/ UnpaddedSize = getSizeInBits() - $uchar2ullong(UnfilledBitsInLastUnit);
    long/*uint64_t*/ UnpackedSizeInBits = llvm.alignTo(getSizeInBits(), Context.toBits(new CharUnits(UnpackedAlignment)));
    CharUnits UnpackedSize = Context.toCharUnitsFromBits(UnpackedSizeInBits);
    long/*uint64_t*/ RoundedSize = llvm.alignTo(getSizeInBits(), Context.toBits(new CharUnits(Alignment)));
    if (UseExternalLayout) {
      // If we're inferring alignment, and the external size is smaller than
      // our size after we've rounded up to alignment, conservatively set the
      // alignment to 1.
      if (InferAlignment && $less_ulong(External.Size, RoundedSize)) {
        Alignment.$assignMove(CharUnits.One());
        InferAlignment = false;
      }
      setSize(External.Size);
      return;
    }
    
    // Set the size to the final size.
    setSize(RoundedSize);
    
    /*uint*/int CharBitNum = Context.getTargetInfo().getCharWidth();
    {
      /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(D);
      if ((RD != null)) {
        // Warn if padding was introduced to the struct/class/union.
        if ($greater_ulong(getSizeInBits(), UnpaddedSize)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int PadSize = $ullong2uint(getSizeInBits() - UnpaddedSize);
            boolean InBits = true;
            if ($rem_uint(PadSize, CharBitNum) == 0) {
              PadSize = $div_uint(PadSize, CharBitNum);
              InBits = false;
            }
            $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_QualType($c$.track(Diag(RD.getLocation(), diag.warn_padded_struct_size)), 
                        Context.getTypeDeclType(RD)), 
                    PadSize), 
                (InBits ? 1 : 0))); // (byte|bit)
          } finally {
            $c$.$destroy();
          }
        }
        
        // Warn if we packed it unnecessarily. If the alignment is 1 byte don't
        // bother since there won't be alignment issues.
        if (Packed && UnpackedAlignment.$greater(CharUnits.One())
           && getSize().$eq(UnpackedSize)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Diag(D.getLocation(), diag.warn_unnecessary_packed)), 
                Context.getTypeDeclType(RD)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::UpdateAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1894,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::UpdateAlignment", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder15UpdateAlignmentEN5clang9CharUnitsES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder15UpdateAlignmentEN5clang9CharUnitsES2_")
  //</editor-fold>
  protected void UpdateAlignment(CharUnits NewAlignment, CharUnits UnpackedNewAlignment) {
    // The alignment is not modified when using 'mac68k' alignment or when
    // we have an externally-supplied layout that also provides overall alignment.
    if (IsMac68kAlign || (UseExternalLayout && !InferAlignment)) {
      return;
    }
    if (NewAlignment.$greater(Alignment)) {
      assert (llvm.isPowerOf2_64(NewAlignment.getQuantity())) : "Alignment not a power of 2";
      Alignment.$assign(NewAlignment);
    }
    if (UnpackedNewAlignment.$greater(UnpackedAlignment)) {
      assert (llvm.isPowerOf2_64(UnpackedNewAlignment.getQuantity())) : "Alignment not a power of 2";
      UnpackedAlignment.$assign(UnpackedNewAlignment);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::UpdateAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 745,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::UpdateAlignment", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder15UpdateAlignmentEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder15UpdateAlignmentEN5clang9CharUnitsE")
  //</editor-fold>
  protected void UpdateAlignment(CharUnits NewAlignment) {
    UpdateAlignment(new CharUnits(NewAlignment), new CharUnits(NewAlignment));
  }

  
  /// \brief Retrieve the externally-supplied field offset for the given
  /// field.
  ///
  /// \param Field The field whose offset is being queried.
  /// \param ComputedOffset The offset that we've computed for this field.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::updateExternalFieldOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1914,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::updateExternalFieldOffset", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder25updateExternalFieldOffsetEPKN5clang9FieldDeclEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder25updateExternalFieldOffsetEPKN5clang9FieldDeclEy")
  //</editor-fold>
  protected long/*uint64_t*/ updateExternalFieldOffset(/*const*/ FieldDecl /*P*/ Field, 
                           long/*uint64_t*/ ComputedOffset) {
    long/*uint64_t*/ ExternalFieldOffset = External.getExternalFieldOffset(Field);
    if (InferAlignment && $less_ulong(ExternalFieldOffset, ComputedOffset)) {
      // The externally-supplied field offset is before the field offset we
      // computed. Assume that the structure is packed.
      Alignment.$assignMove(CharUnits.One());
      InferAlignment = false;
    }
    
    // Use the externally-supplied field offset.
    return ExternalFieldOffset;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::CheckFieldPadding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1944,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::CheckFieldPadding", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder17CheckFieldPaddingEyyyjbPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder17CheckFieldPaddingEyyyjbPKN5clang9FieldDeclE")
  //</editor-fold>
  protected void CheckFieldPadding(long/*uint64_t*/ Offset, long/*uint64_t*/ UnpaddedOffset, long/*uint64_t*/ UnpackedOffset, 
                   /*uint*/int UnpackedAlign, boolean isPacked, /*const*/ FieldDecl /*P*/ D) {
    // We let objc ivars without warning, objc interfaces generally are not used
    // for padding tricks.
    if (isa_ObjCIvarDecl(D)) {
      return;
    }
    
    // Don't warn about structs created without a SourceLocation.  This can
    // be done by clients of the AST, such as codegen.
    if (D.getLocation().isInvalid()) {
      return;
    }
    
    /*uint*/int CharBitNum = Context.getTargetInfo().getCharWidth();
    
    // Warn if padding was introduced to the struct/class.
    if (!IsUnion && $greater_ulong(Offset, UnpaddedOffset)) {
      /*uint*/int PadSize = $ullong2uint(Offset - UnpaddedOffset);
      boolean InBits = true;
      if ($rem_uint(PadSize, CharBitNum) == 0) {
        PadSize = $div_uint(PadSize, CharBitNum);
        InBits = false;
      }
      if ((D.getIdentifier() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_uint($c$.track(Diag(D.getLocation(), diag.warn_padded_struct_field)), 
                              getPaddingDiagFromTagKind(D.getParent$Const().getTagKind())), 
                          Context.getTypeDeclType(D.getParent$Const())), 
                      PadSize), 
                  (InBits ? 1 : 0)),  // (byte|bit)
              D.getIdentifier()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_uint($c$.track(Diag(D.getLocation(), diag.warn_padded_struct_anon_field)), 
                          getPaddingDiagFromTagKind(D.getParent$Const().getTagKind())), 
                      Context.getTypeDeclType(D.getParent$Const())), 
                  PadSize), 
              (InBits ? 1 : 0))); // (byte|bit)
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Warn if we packed it unnecessarily. If the alignment is 1 byte don't
    // bother since there won't be alignment issues.
    if (isPacked && $greater_uint(UnpackedAlign, CharBitNum) && Offset == UnpackedOffset) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(Diag(D.getLocation(), diag.warn_unnecessary_packed)), 
            D.getIdentifier()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2069,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::Diag", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder4DiagEN5clang14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder4DiagEN5clang14SourceLocationEj")
  //</editor-fold>
  protected DiagnosticBuilder Diag(SourceLocation Loc, 
      /*uint*/int DiagID) {
    return Context.getDiagnostics().Report(/*NO_COPY*/Loc, DiagID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 763,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::getSize", NM="_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder7getSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder7getSizeEv")
  //</editor-fold>
  /*friend*/public/*protected*/ CharUnits getSize() /*const*/ {
    assert ($rem_ulong(Size, Context.getCharWidth()) == $int2ullong(0));
    return Context.toCharUnitsFromBits(Size);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::getSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 767,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::getSizeInBits", NM="_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder13getSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder13getSizeInBitsEv")
  //</editor-fold>
  protected long/*uint64_t*/ getSizeInBits() /*const*/ {
    return Size;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::setSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 769,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::setSize", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder7setSizeEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder7setSizeEN5clang9CharUnitsE")
  //</editor-fold>
  protected void setSize(CharUnits NewSize) {
    Size = Context.toBits(new CharUnits(NewSize));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::setSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 770,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::setSize", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder7setSizeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder7setSizeEy")
  //</editor-fold>
  protected void setSize(long/*uint64_t*/ NewSize) {
    Size = NewSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::getAligment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 772,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::getAligment", NM="_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder11getAligmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder11getAligmentEv")
  //</editor-fold>
  protected CharUnits getAligment() /*const*/ {
    return new CharUnits(Alignment);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::getDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 774,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::getDataSize", NM="_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder11getDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder11getDataSizeEv")
  //</editor-fold>
  /*friend*/public/*protected*/ CharUnits getDataSize() /*const*/ {
    assert ($rem_ulong(DataSize, Context.getCharWidth()) == $int2ullong(0));
    return Context.toCharUnitsFromBits(DataSize);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::getDataSizeInBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 778,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::getDataSizeInBits", NM="_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder17getDataSizeInBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_126ItaniumRecordLayoutBuilder17getDataSizeInBitsEv")
  //</editor-fold>
  protected long/*uint64_t*/ getDataSizeInBits() /*const*/ {
    return DataSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::setDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 780,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::setDataSize", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder11setDataSizeEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder11setDataSizeEN5clang9CharUnitsE")
  //</editor-fold>
  protected void setDataSize(CharUnits NewSize) {
    DataSize = Context.toBits(new CharUnits(NewSize));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::setDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 781,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::setDataSize", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder11setDataSizeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilder11setDataSizeEy")
  //</editor-fold>
  protected void setDataSize(long/*uint64_t*/ NewSize) {
    DataSize = NewSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::ItaniumRecordLayoutBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 783,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::ItaniumRecordLayoutBuilder", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderC1ERKS0_")
  //</editor-fold>
  protected ItaniumRecordLayoutBuilder(final /*const*/ ItaniumRecordLayoutBuilder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 784,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::operator=", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderaSERKS0_")
  //</editor-fold>
  protected void $assign(final /*const*/ ItaniumRecordLayoutBuilder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRecordLayoutBuilder::~ItaniumRecordLayoutBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 567,
   FQN="(anonymous namespace)::ItaniumRecordLayoutBuilder::~ItaniumRecordLayoutBuilder", NM="_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_126ItaniumRecordLayoutBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NonVirtualBaseInfo.$destroy();
    VirtualBaseInfo.$destroy();
    BaseSubobjectInfoAllocator.$destroy();
    External.$destroy();
    VisitedVirtualBases.$destroy();
    IndirectPrimaryBases.$destroy();
    VBases.$destroy();
    Bases.$destroy();
    FieldOffsets.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", EmptySubobjects=" + EmptySubobjects // NOI18N
              + ", Size=" + Size // NOI18N
              + ", Alignment=" + Alignment // NOI18N
              + ", UnpackedAlignment=" + UnpackedAlignment // NOI18N
              + ", FieldOffsets=" + FieldOffsets // NOI18N
              + ", UseExternalLayout=" + UseExternalLayout // NOI18N
              + ", InferAlignment=" + InferAlignment // NOI18N
              + ", Packed=" + Packed // NOI18N
              + ", IsUnion=" + IsUnion // NOI18N
              + ", IsMac68kAlign=" + IsMac68kAlign // NOI18N
              + ", IsMsStruct=" + IsMsStruct // NOI18N
              + ", UnfilledBitsInLastUnit=" + $uchar2uint(UnfilledBitsInLastUnit) // NOI18N
              + ", LastBitfieldTypeSize=" + $uchar2uint(LastBitfieldTypeSize) // NOI18N
              + ", MaxFieldAlignment=" + MaxFieldAlignment // NOI18N
              + ", DataSize=" + DataSize // NOI18N
              + ", NonVirtualSize=" + NonVirtualSize // NOI18N
              + ", NonVirtualAlignment=" + NonVirtualAlignment // NOI18N
              + ", PrimaryBase=" + PrimaryBase // NOI18N
              + ", PrimaryBaseIsVirtual=" + PrimaryBaseIsVirtual // NOI18N
              + ", HasOwnVFPtr=" + HasOwnVFPtr // NOI18N
              + ", Bases=" + Bases // NOI18N
              + ", VBases=" + VBases // NOI18N
              + ", IndirectPrimaryBases=" + IndirectPrimaryBases // NOI18N
              + ", FirstNearlyEmptyVBase=" + FirstNearlyEmptyVBase // NOI18N
              + ", VisitedVirtualBases=" + VisitedVirtualBases // NOI18N
              + ", External=" + External // NOI18N
              + ", BaseSubobjectInfoAllocator=" + BaseSubobjectInfoAllocator // NOI18N
              + ", VirtualBaseInfo=" + VirtualBaseInfo // NOI18N
              + ", NonVirtualBaseInfo=" + NonVirtualBaseInfo; // NOI18N
  }
}
