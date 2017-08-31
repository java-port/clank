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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;


/// EmptySubobjectMap - Keeps track of which empty subobjects exist at different
/// offsets while laying out a C++ class.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 105,
 FQN="(anonymous namespace)::EmptySubobjectMap", NM="_ZN12_GLOBAL__N_117EmptySubobjectMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMapE")
//</editor-fold>
public class EmptySubobjectMap implements Destructors.ClassWithDestructor {
  private final /*const*/ ASTContext /*&*/ Context;
  private long/*uint64_t*/ CharWidth;
  
  /// Class - The class whose empty entries we're keeping track of.
  private /*const*/ CXXRecordDecl /*P*/ Class;
  
  /// EmptyClassOffsets - A map from offsets to empty record decls.
  /*typedef llvm::TinyPtrVector<const CXXRecordDecl *> ClassVectorTy*/
//  public final class ClassVectorTy extends TinyPtrVector</*const*/ CXXRecordDecl /*P*/ >{ };
  /*typedef llvm::DenseMap<CharUnits, ClassVectorTy> EmptyClassOffsetsMapTy*/
//  public final class EmptyClassOffsetsMapTy extends DenseMap<CharUnits, TinyPtrVector</*const*/ CXXRecordDecl /*P*/ >>{ };
  private DenseMap<CharUnits, TinyPtrVector</*const*/ CXXRecordDecl /*P*/ >> EmptyClassOffsets;
  
  /// MaxEmptyClassOffset - The highest offset known to contain an empty
  /// base subobject.
  private CharUnits MaxEmptyClassOffset;
  
  /// ComputeEmptySubobjectSizes - Compute the size of the largest base or
  /// member subobject that is empty.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::ComputeEmptySubobjectSizes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 186,
   FQN="(anonymous namespace)::EmptySubobjectMap::ComputeEmptySubobjectSizes", NM="_ZN12_GLOBAL__N_117EmptySubobjectMap26ComputeEmptySubobjectSizesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMap26ComputeEmptySubobjectSizesEv")
  //</editor-fold>
  private void ComputeEmptySubobjectSizes() {
    // Check the bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : Class.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      
      CharUnits EmptySize/*J*/= new CharUnits();
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(BaseDecl);
      if (BaseDecl.isEmpty()) {
        // If the class decl is empty, get its size.
        EmptySize.$assignMove(Layout.getSize());
      } else {
        // Otherwise, we get the largest empty subobject for the decl.
        EmptySize.$assignMove(Layout.getSizeOfLargestEmptySubobject());
      }
      if (EmptySize.$greater(SizeOfLargestEmptySubobject)) {
        SizeOfLargestEmptySubobject.$assign(EmptySize);
      }
    }
    
    // Check the fields.
    for (/*const*/ FieldDecl /*P*/ FD : Class.fields()) {
      /*const*/ RecordType /*P*/ RT = Context.getBaseElementType(FD.getType()).$arrow().getAs$RecordType();
      
      // We only care about record types.
      if (!(RT != null)) {
        continue;
      }
      
      CharUnits EmptySize/*J*/= new CharUnits();
      /*const*/ CXXRecordDecl /*P*/ MemberDecl = RT.getAsCXXRecordDecl();
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(MemberDecl);
      if (MemberDecl.isEmpty()) {
        // If the class decl is empty, get its size.
        EmptySize.$assignMove(Layout.getSize());
      } else {
        // Otherwise, we get the largest empty subobject for the decl.
        EmptySize.$assignMove(Layout.getSizeOfLargestEmptySubobject());
      }
      if (EmptySize.$greater(SizeOfLargestEmptySubobject)) {
        SizeOfLargestEmptySubobject.$assign(EmptySize);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::AddSubobjectAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 249,
   FQN="(anonymous namespace)::EmptySubobjectMap::AddSubobjectAtOffset", NM="_ZN12_GLOBAL__N_117EmptySubobjectMap20AddSubobjectAtOffsetEPKN5clang13CXXRecordDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMap20AddSubobjectAtOffsetEPKN5clang13CXXRecordDeclENS1_9CharUnitsE")
  //</editor-fold>
  private void AddSubobjectAtOffset(/*const*/ CXXRecordDecl /*P*/ RD, 
                      CharUnits Offset) {
    // We only care about empty bases.
    if (!RD.isEmpty()) {
      return;
    }
    
    // If we have empty structures inside a union, we can assign both
    // the same offset. Just avoid pushing them twice in the list.
    final TinyPtrVector</*const*/ CXXRecordDecl /*P*/ > /*&*/ Classes = EmptyClassOffsets.$at_T1$C$R(Offset);
    if ($noteq_ptr(std.find(Classes.begin(), Classes.end(), RD, true), Classes.end())) {
      return;
    }
    
    Classes.push_back(RD);
    
    // Update the empty class offset.
    if (Offset.$greater(MaxEmptyClassOffset)) {
      MaxEmptyClassOffset.$assign(Offset);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::UpdateEmptyBaseSubobjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 315,
   FQN="(anonymous namespace)::EmptySubobjectMap::UpdateEmptyBaseSubobjects", NM="_ZN12_GLOBAL__N_117EmptySubobjectMap25UpdateEmptyBaseSubobjectsEPKNS_17BaseSubobjectInfoEN5clang9CharUnitsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMap25UpdateEmptyBaseSubobjectsEPKNS_17BaseSubobjectInfoEN5clang9CharUnitsEb")
  //</editor-fold>
  private void UpdateEmptyBaseSubobjects(/*const*/ BaseSubobjectInfo /*P*/ Info, 
                           CharUnits Offset, 
                           boolean PlacingEmptyBase) {
    if (!PlacingEmptyBase && Offset.$greatereq(SizeOfLargestEmptySubobject)) {
      // We know that the only empty subobjects that can conflict with empty
      // subobject of non-empty bases, are empty bases that can be placed at
      // offset zero. Because of this, we only need to keep track of empty base 
      // subobjects with offsets less than the size of the largest empty
      // subobject for our class.    
      return;
    }
    
    AddSubobjectAtOffset(Info.Class, new CharUnits(Offset));
    
    // Traverse all non-virtual bases.
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(Info.Class);
    for (/*const*/ BaseSubobjectInfo /*P*/ Base : Info.Bases) {
      if (Base.IsVirtual) {
        continue;
      }
      
      CharUnits BaseOffset = Offset.$add(Layout.getBaseClassOffset(Base.Class));
      UpdateEmptyBaseSubobjects(Base, new CharUnits(BaseOffset), PlacingEmptyBase);
    }
    if ((Info.PrimaryVirtualBaseInfo != null)) {
      BaseSubobjectInfo /*P*/ PrimaryVirtualBaseInfo = Info.PrimaryVirtualBaseInfo;
      if (Info == PrimaryVirtualBaseInfo.Derived) {
        UpdateEmptyBaseSubobjects(PrimaryVirtualBaseInfo, new CharUnits(Offset), 
            PlacingEmptyBase);
      }
    }
    
    // Traverse all member variables.
    /*uint*/int FieldNo = 0;
    for (DeclContext.specific_decl_iterator<FieldDecl> I = Info.Class.field_begin(), 
        E = Info.Class.field_end(); $noteq_specific_decl_iterator$SpecificDecl$C(I, E); I.$preInc() , ++FieldNo) {
      if (I.$arrow().isBitField()) {
        continue;
      }
      
      CharUnits FieldOffset = Offset.$add(getFieldOffset(Layout, FieldNo));
      UpdateEmptyFieldSubobjects(I.$star(), new CharUnits(FieldOffset));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::UpdateEmptyFieldSubobjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 480,
   FQN="(anonymous namespace)::EmptySubobjectMap::UpdateEmptyFieldSubobjects", NM="_ZN12_GLOBAL__N_117EmptySubobjectMap26UpdateEmptyFieldSubobjectsEPKN5clang13CXXRecordDeclES4_NS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMap26UpdateEmptyFieldSubobjectsEPKN5clang13CXXRecordDeclES4_NS1_9CharUnitsE")
  //</editor-fold>
  private void UpdateEmptyFieldSubobjects(/*const*/ CXXRecordDecl /*P*/ RD, 
                            /*const*/ CXXRecordDecl /*P*/ Class, 
                            CharUnits Offset) {
    // We know that the only empty subobjects that can conflict with empty
    // field subobjects are subobjects of empty bases that can be placed at offset
    // zero. Because of this, we only need to keep track of empty field 
    // subobjects with offsets less than the size of the largest empty
    // subobject for our class.
    if (Offset.$greatereq(SizeOfLargestEmptySubobject)) {
      return;
    }
    
    AddSubobjectAtOffset(RD, new CharUnits(Offset));
    
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    
    // Traverse all non-virtual bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      if (Base.isVirtual()) {
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      
      CharUnits BaseOffset = Offset.$add(Layout.getBaseClassOffset(BaseDecl));
      UpdateEmptyFieldSubobjects(BaseDecl, Class, new CharUnits(BaseOffset));
    }
    if (RD == Class) {
      // This is the most derived class, traverse virtual bases as well.
      for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.vbases$Const()) {
        /*const*/ CXXRecordDecl /*P*/ VBaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
        
        CharUnits VBaseOffset = Offset.$add(Layout.getVBaseClassOffset(VBaseDecl));
        UpdateEmptyFieldSubobjects(VBaseDecl, Class, new CharUnits(VBaseOffset));
      }
    }
    
    // Traverse all member variables.
    /*uint*/int FieldNo = 0;
    for (DeclContext.specific_decl_iterator<FieldDecl> I = RD.field_begin(), E = RD.field_end();
         $noteq_specific_decl_iterator$SpecificDecl$C(I, E); I.$preInc() , ++FieldNo) {
      if (I.$arrow().isBitField()) {
        continue;
      }
      
      CharUnits FieldOffset = Offset.$add(getFieldOffset(Layout, FieldNo));
      
      UpdateEmptyFieldSubobjects(I.$star(), new CharUnits(FieldOffset));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::UpdateEmptyFieldSubobjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 529,
   FQN="(anonymous namespace)::EmptySubobjectMap::UpdateEmptyFieldSubobjects", NM="_ZN12_GLOBAL__N_117EmptySubobjectMap26UpdateEmptyFieldSubobjectsEPKN5clang9FieldDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMap26UpdateEmptyFieldSubobjectsEPKN5clang9FieldDeclENS1_9CharUnitsE")
  //</editor-fold>
  private void UpdateEmptyFieldSubobjects(/*const*/ FieldDecl /*P*/ FD, 
                            CharUnits Offset) {
    QualType T = FD.getType();
    {
      /*const*/ CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        UpdateEmptyFieldSubobjects(RD, RD, new CharUnits(Offset));
        return;
      }
    }
    {
      
      // If we have an array type we need to update every element.
      /*const*/ ConstantArrayType /*P*/ AT = Context.getAsConstantArrayType(new QualType(T));
      if ((AT != null)) {
        QualType ElemTy = Context.getBaseElementType(AT);
        /*const*/ RecordType /*P*/ RT = ElemTy.$arrow().getAs$RecordType();
        if (!(RT != null)) {
          return;
        }
        
        /*const*/ CXXRecordDecl /*P*/ RD = RT.getAsCXXRecordDecl();
        final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
        
        long/*uint64_t*/ NumElements = Context.getConstantArrayElementCount(AT);
        CharUnits ElementOffset = new CharUnits(Offset);
        
        for (long/*uint64_t*/ I = $int2ulong(0); I != NumElements; ++I) {
          // We know that the only empty subobjects that can conflict with empty
          // field subobjects are subobjects of empty bases that can be placed at 
          // offset zero. Because of this, we only need to keep track of empty field
          // subobjects with offsets less than the size of the largest empty
          // subobject for our class.
          if (ElementOffset.$greatereq(SizeOfLargestEmptySubobject)) {
            return;
          }
          
          UpdateEmptyFieldSubobjects(RD, RD, new CharUnits(ElementOffset));
          ElementOffset.$addassign(Layout.getSize());
        }
      }
    }
  }

  
  /// AnyEmptySubobjectsBeyondOffset - Returns whether there are any empty
  /// subobjects beyond the given offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::AnyEmptySubobjectsBeyondOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 137,
   FQN="(anonymous namespace)::EmptySubobjectMap::AnyEmptySubobjectsBeyondOffset", NM="_ZNK12_GLOBAL__N_117EmptySubobjectMap30AnyEmptySubobjectsBeyondOffsetEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_117EmptySubobjectMap30AnyEmptySubobjectsBeyondOffsetEN5clang9CharUnitsE")
  //</editor-fold>
  private boolean AnyEmptySubobjectsBeyondOffset(CharUnits Offset) /*const*/ {
    return Offset.$lesseq(MaxEmptyClassOffset);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::getFieldOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 141,
   FQN="(anonymous namespace)::EmptySubobjectMap::getFieldOffset", NM="_ZNK12_GLOBAL__N_117EmptySubobjectMap14getFieldOffsetERKN5clang15ASTRecordLayoutEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_117EmptySubobjectMap14getFieldOffsetERKN5clang15ASTRecordLayoutEj")
  //</editor-fold>
  private CharUnits getFieldOffset(final /*const*/ ASTRecordLayout /*&*/ Layout, /*uint*/int FieldNo) /*const*/ {
    long/*uint64_t*/ FieldOffset = Layout.getFieldOffset(FieldNo);
    assert ($rem_ulong(FieldOffset, CharWidth) == $int2ullong(0)) : "Field offset not at char boundary!";
    
    return Context.toCharUnitsFromBits(FieldOffset);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::CanPlaceSubobjectAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 230,
   FQN="(anonymous namespace)::EmptySubobjectMap::CanPlaceSubobjectAtOffset", NM="_ZNK12_GLOBAL__N_117EmptySubobjectMap25CanPlaceSubobjectAtOffsetEPKN5clang13CXXRecordDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_117EmptySubobjectMap25CanPlaceSubobjectAtOffsetEPKN5clang13CXXRecordDeclENS1_9CharUnitsE")
  //</editor-fold>
  protected boolean CanPlaceSubobjectAtOffset(/*const*/ CXXRecordDecl /*P*/ RD, 
                           CharUnits Offset) /*const*/ {
    // We only need to check empty bases.
    if (!RD.isEmpty()) {
      return true;
    }
    
    DenseMapIterator<CharUnits, TinyPtrVector</*const*/ CXXRecordDecl /*P*/ >> I = EmptyClassOffsets.find$Const(Offset);
    if (I.$eq(EmptyClassOffsets.end$Const())) {
      return true;
    }
    
    final /*const*/ TinyPtrVector</*const*/ CXXRecordDecl /*P*/ > /*&*/ Classes = I.$arrow().second;
    if ($eq_ptr(std.find(Classes.begin$Const(), Classes.end$Const(), RD, true), Classes.end$Const())) {
      return true;
    }
    
    // There is already an empty class of the same type at this offset.
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::CanPlaceBaseSubobjectAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 268,
   FQN="(anonymous namespace)::EmptySubobjectMap::CanPlaceBaseSubobjectAtOffset", NM="_ZN12_GLOBAL__N_117EmptySubobjectMap29CanPlaceBaseSubobjectAtOffsetEPKNS_17BaseSubobjectInfoEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMap29CanPlaceBaseSubobjectAtOffsetEPKNS_17BaseSubobjectInfoEN5clang9CharUnitsE")
  //</editor-fold>
  protected boolean CanPlaceBaseSubobjectAtOffset(/*const*/ BaseSubobjectInfo /*P*/ Info, 
                               CharUnits Offset) {
    // We don't have to keep looking past the maximum offset that's known to
    // contain an empty class.
    if (!AnyEmptySubobjectsBeyondOffset(new CharUnits(Offset))) {
      return true;
    }
    if (!CanPlaceSubobjectAtOffset(Info.Class, new CharUnits(Offset))) {
      return false;
    }
    
    // Traverse all non-virtual bases.
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(Info.Class);
    for (/*const*/ BaseSubobjectInfo /*P*/ Base : Info.Bases) {
      if (Base.IsVirtual) {
        continue;
      }
      
      CharUnits BaseOffset = Offset.$add(Layout.getBaseClassOffset(Base.Class));
      if (!CanPlaceBaseSubobjectAtOffset(Base, new CharUnits(BaseOffset))) {
        return false;
      }
    }
    if ((Info.PrimaryVirtualBaseInfo != null)) {
      BaseSubobjectInfo /*P*/ PrimaryVirtualBaseInfo = Info.PrimaryVirtualBaseInfo;
      if (Info == PrimaryVirtualBaseInfo.Derived) {
        if (!CanPlaceBaseSubobjectAtOffset(PrimaryVirtualBaseInfo, new CharUnits(Offset))) {
          return false;
        }
      }
    }
    
    // Traverse all member variables.
    /*uint*/int FieldNo = 0;
    for (DeclContext.specific_decl_iterator<FieldDecl> I = Info.Class.field_begin(), 
        E = Info.Class.field_end(); $noteq_specific_decl_iterator$SpecificDecl$C(I, E); I.$preInc() , ++FieldNo) {
      if (I.$arrow().isBitField()) {
        continue;
      }
      
      CharUnits FieldOffset = Offset.$add(getFieldOffset(Layout, FieldNo));
      if (!CanPlaceFieldSubobjectAtOffset(I.$star(), new CharUnits(FieldOffset))) {
        return false;
      }
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::CanPlaceFieldSubobjectAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 375,
   FQN="(anonymous namespace)::EmptySubobjectMap::CanPlaceFieldSubobjectAtOffset", NM="_ZNK12_GLOBAL__N_117EmptySubobjectMap30CanPlaceFieldSubobjectAtOffsetEPKN5clang13CXXRecordDeclES4_NS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_117EmptySubobjectMap30CanPlaceFieldSubobjectAtOffsetEPKN5clang13CXXRecordDeclES4_NS1_9CharUnitsE")
  //</editor-fold>
  protected boolean CanPlaceFieldSubobjectAtOffset(/*const*/ CXXRecordDecl /*P*/ RD, 
                                /*const*/ CXXRecordDecl /*P*/ Class, 
                                CharUnits Offset) /*const*/ {
    // We don't have to keep looking past the maximum offset that's known to
    // contain an empty class.
    if (!AnyEmptySubobjectsBeyondOffset(new CharUnits(Offset))) {
      return true;
    }
    if (!CanPlaceSubobjectAtOffset(RD, new CharUnits(Offset))) {
      return false;
    }
    
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    
    // Traverse all non-virtual bases.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      if (Base.isVirtual()) {
        continue;
      }
      
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      
      CharUnits BaseOffset = Offset.$add(Layout.getBaseClassOffset(BaseDecl));
      if (!CanPlaceFieldSubobjectAtOffset(BaseDecl, Class, new CharUnits(BaseOffset))) {
        return false;
      }
    }
    if (RD == Class) {
      // This is the most derived class, traverse virtual bases as well.
      for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.vbases$Const()) {
        /*const*/ CXXRecordDecl /*P*/ VBaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
        
        CharUnits VBaseOffset = Offset.$add(Layout.getVBaseClassOffset(VBaseDecl));
        if (!CanPlaceFieldSubobjectAtOffset(VBaseDecl, Class, new CharUnits(VBaseOffset))) {
          return false;
        }
      }
    }
    
    // Traverse all member variables.
    /*uint*/int FieldNo = 0;
    for (DeclContext.specific_decl_iterator<FieldDecl> I = RD.field_begin(), E = RD.field_end();
         $noteq_specific_decl_iterator$SpecificDecl$C(I, E); I.$preInc() , ++FieldNo) {
      if (I.$arrow().isBitField()) {
        continue;
      }
      
      CharUnits FieldOffset = Offset.$add(getFieldOffset(Layout, FieldNo));
      if (!CanPlaceFieldSubobjectAtOffset(I.$star(), new CharUnits(FieldOffset))) {
        return false;
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::CanPlaceFieldSubobjectAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 428,
   FQN="(anonymous namespace)::EmptySubobjectMap::CanPlaceFieldSubobjectAtOffset", NM="_ZNK12_GLOBAL__N_117EmptySubobjectMap30CanPlaceFieldSubobjectAtOffsetEPKN5clang9FieldDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_117EmptySubobjectMap30CanPlaceFieldSubobjectAtOffsetEPKN5clang9FieldDeclENS1_9CharUnitsE")
  //</editor-fold>
  protected boolean CanPlaceFieldSubobjectAtOffset(/*const*/ FieldDecl /*P*/ FD, 
                                CharUnits Offset) /*const*/ {
    // We don't have to keep looking past the maximum offset that's known to
    // contain an empty class.
    if (!AnyEmptySubobjectsBeyondOffset(new CharUnits(Offset))) {
      return true;
    }
    
    QualType T = FD.getType();
    {
      /*const*/ CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        return CanPlaceFieldSubobjectAtOffset(RD, RD, new CharUnits(Offset));
      }
    }
    {
      
      // If we have an array type we need to look at every element.
      /*const*/ ConstantArrayType /*P*/ AT = Context.getAsConstantArrayType(new QualType(T));
      if ((AT != null)) {
        QualType ElemTy = Context.getBaseElementType(AT);
        /*const*/ RecordType /*P*/ RT = ElemTy.$arrow().getAs$RecordType();
        if (!(RT != null)) {
          return true;
        }
        
        /*const*/ CXXRecordDecl /*P*/ RD = RT.getAsCXXRecordDecl();
        final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
        
        long/*uint64_t*/ NumElements = Context.getConstantArrayElementCount(AT);
        CharUnits ElementOffset = new CharUnits(Offset);
        for (long/*uint64_t*/ I = $int2ulong(0); I != NumElements; ++I) {
          // We don't have to keep looking past the maximum offset that's known to
          // contain an empty class.
          if (!AnyEmptySubobjectsBeyondOffset(new CharUnits(ElementOffset))) {
            return true;
          }
          if (!CanPlaceFieldSubobjectAtOffset(RD, RD, new CharUnits(ElementOffset))) {
            return false;
          }
          
          ElementOffset.$addassign(Layout.getSize());
        }
      }
    }
    
    return true;
  }

/*public:*/
  /// This holds the size of the largest empty subobject (either a base
  /// or a member). Will be zero if the record being built doesn't contain
  /// any empty classes.
  public CharUnits SizeOfLargestEmptySubobject;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::EmptySubobjectMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 169,
   FQN="(anonymous namespace)::EmptySubobjectMap::EmptySubobjectMap", NM="_ZN12_GLOBAL__N_117EmptySubobjectMapC1ERKN5clang10ASTContextEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMapC1ERKN5clang10ASTContextEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  public EmptySubobjectMap(final /*const*/ ASTContext /*&*/ Context, /*const*/ CXXRecordDecl /*P*/ Class) {
    // : Context(Context), CharWidth(Context.getCharWidth()), Class(Class), EmptyClassOffsets(), MaxEmptyClassOffset(), SizeOfLargestEmptySubobject() 
    //START JInit
    this./*&*/Context=/*&*/Context;
    this.CharWidth = Context.getCharWidth();
    this.Class = Class;
    this.EmptyClassOffsets = new DenseMap<CharUnits, TinyPtrVector</*const*/ CXXRecordDecl /*P*/ >>(DenseMapInfoCharUnits.$Info(), new TinyPtrVector</*const*/ CXXRecordDecl /*P*/ >());
    this.MaxEmptyClassOffset = new CharUnits();
    this.SizeOfLargestEmptySubobject = new CharUnits();
    //END JInit
    ComputeEmptySubobjectSizes();
  }

  
  /// CanPlaceBaseAtOffset - Return whether the given base class can be placed
  /// at the given offset.
  /// Returns false if placing the record will result in two components
  /// (direct or indirect) of the same type having the same offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::CanPlaceBaseAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 359,
   FQN="(anonymous namespace)::EmptySubobjectMap::CanPlaceBaseAtOffset", NM="_ZN12_GLOBAL__N_117EmptySubobjectMap20CanPlaceBaseAtOffsetEPKNS_17BaseSubobjectInfoEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMap20CanPlaceBaseAtOffsetEPKNS_17BaseSubobjectInfoEN5clang9CharUnitsE")
  //</editor-fold>
  public boolean CanPlaceBaseAtOffset(/*const*/ BaseSubobjectInfo /*P*/ Info, 
                      CharUnits Offset) {
    // If we know this class doesn't have any empty subobjects we don't need to
    // bother checking.
    if (SizeOfLargestEmptySubobject.isZero()) {
      return true;
    }
    if (!CanPlaceBaseSubobjectAtOffset(Info, new CharUnits(Offset))) {
      return false;
    }
    
    // We are able to place the base at this offset. Make sure to update the
    // empty base subobject map.
    UpdateEmptyBaseSubobjects(Info, new CharUnits(Offset), Info.Class.isEmpty());
    return true;
  }

  
  /// CanPlaceFieldAtOffset - Return whether a field can be placed at the given
  /// offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::CanPlaceFieldAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 468,
   FQN="(anonymous namespace)::EmptySubobjectMap::CanPlaceFieldAtOffset", NM="_ZN12_GLOBAL__N_117EmptySubobjectMap21CanPlaceFieldAtOffsetEPKN5clang9FieldDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMap21CanPlaceFieldAtOffsetEPKN5clang9FieldDeclENS1_9CharUnitsE")
  //</editor-fold>
  public boolean CanPlaceFieldAtOffset(/*const*/ FieldDecl /*P*/ FD, 
                       CharUnits Offset) {
    if (!CanPlaceFieldSubobjectAtOffset(FD, new CharUnits(Offset))) {
      return false;
    }
    
    // We are able to place the member variable at this offset.
    // Make sure to update the empty base subobject map.
    UpdateEmptyFieldSubobjects(FD, new CharUnits(Offset));
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::EmptySubobjectMap::~EmptySubobjectMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 105,
   FQN="(anonymous namespace)::EmptySubobjectMap::~EmptySubobjectMap", NM="_ZN12_GLOBAL__N_117EmptySubobjectMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_117EmptySubobjectMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    EmptyClassOffsets.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", CharWidth=" + CharWidth // NOI18N
              + ", Class=" + Class // NOI18N
              + ", EmptyClassOffsets=" + EmptyClassOffsets // NOI18N
              + ", MaxEmptyClassOffset=" + MaxEmptyClassOffset // NOI18N
              + ", SizeOfLargestEmptySubobject=" + SizeOfLargestEmptySubobject; // NOI18N
  }
}
