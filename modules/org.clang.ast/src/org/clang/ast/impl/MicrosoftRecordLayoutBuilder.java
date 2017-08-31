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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ASTRecordLayout.VBaseInfo;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.impl.RecordLayoutBuilderStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2211,
 FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderE")
//</editor-fold>
public class/*struct*/ MicrosoftRecordLayoutBuilder implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::ElementInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2212,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::ElementInfo", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11ElementInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11ElementInfoE")
  //</editor-fold>
  public static class/*struct*/ ElementInfo {
    public CharUnits Size;
    public CharUnits Alignment;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::ElementInfo::ElementInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2212,
     FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::ElementInfo::ElementInfo", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11ElementInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11ElementInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ ElementInfo(JD$Move _dparam, final ElementInfo /*&&*/$Prm0) {
      // : Size(static_cast<ElementInfo &&>().Size), Alignment(static_cast<ElementInfo &&>().Alignment) 
      //START JInit
      this.Size = new CharUnits(JD$Move.INSTANCE, $Prm0.Size);
      this.Alignment = new CharUnits(JD$Move.INSTANCE, $Prm0.Alignment);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::ElementInfo::ElementInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2212,
     FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::ElementInfo::ElementInfo", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11ElementInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11ElementInfoC1Ev")
    //</editor-fold>
    public /*inline*/ ElementInfo() {
      // : Size(), Alignment() 
      //START JInit
      this.Size = new CharUnits();
      this.Alignment = new CharUnits();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Size=" + Size // NOI18N
                + ", Alignment=" + Alignment; // NOI18N
    }
  };
  /*typedef llvm::DenseMap<const CXXRecordDecl *, CharUnits> BaseOffsetsMapTy*/
//  public final class BaseOffsetsMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::MicrosoftRecordLayoutBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2217,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::MicrosoftRecordLayoutBuilder", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderC1ERKN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderC1ERKN5clang10ASTContextE")
  //</editor-fold>
  public MicrosoftRecordLayoutBuilder(final /*const*/ ASTContext /*&*/ Context) {
    // : Context(Context), Size(), NonVirtualSize(), DataSize(), Alignment(), MaxFieldAlignment(), RequiredAlignment(), CurrentBitfieldSize(), VBPtrOffset(), MinEmptyStructSize(), PointerInfo(), FieldOffsets(), Bases(), VBases(), External() 
    //START JInit
    this./*&*/Context=/*&*/Context;
    this.Size = new CharUnits();
    this.NonVirtualSize = new CharUnits();
    this.DataSize = new CharUnits();
    this.Alignment = new CharUnits();
    this.MaxFieldAlignment = new CharUnits();
    this.RequiredAlignment = new CharUnits();
    this.CurrentBitfieldSize = new CharUnits();
    this.VBPtrOffset = new CharUnits();
    this.MinEmptyStructSize = new CharUnits();
    this.PointerInfo = new ElementInfo();
    this.FieldOffsets = new SmallVectorULong(16, 0);
    this.Bases = new DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits>(DenseMapInfo$LikePtr.$Info(), new CharUnits());
    this.VBases = new DenseMap</*const*/ CXXRecordDecl /*P*/ , VBaseInfo>(DenseMapInfo$LikePtr.$Info(), new VBaseInfo());
    this.External = new ExternalLayout();
    //END JInit
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::MicrosoftRecordLayoutBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2219,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::MicrosoftRecordLayoutBuilder", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderC1ERKS0_")
  //</editor-fold>
  private MicrosoftRecordLayoutBuilder(final /*const*/ MicrosoftRecordLayoutBuilder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2220,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::operator=", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ MicrosoftRecordLayoutBuilder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2389,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layout", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder6layoutEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder6layoutEPKN5clang10RecordDeclE")
  //</editor-fold>
  public void layout(/*const*/ RecordDecl /*P*/ RD) {
    // For C record layout, zero-sized records always have size 4.
    MinEmptyStructSize.$assignMove(CharUnits.fromQuantity(4));
    initializeLayout(RD);
    layoutFields(RD);
    DataSize.$assign(Size.$assignMove(Size.alignTo(Alignment)));
    RequiredAlignment.$assign(std.max(RequiredAlignment, Context.toCharUnitsFromBits($uint2long(RD.getMaxAlignment()))));
    finalizeLayout(RD);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::cxxLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2400,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::cxxLayout", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder9cxxLayoutEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder9cxxLayoutEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public void cxxLayout(/*const*/ CXXRecordDecl /*P*/ RD) {
    // The C++ standard says that empty structs have size 1.
    MinEmptyStructSize.$assignMove(CharUnits.One());
    initializeLayout(RD);
    initializeCXXLayout(RD);
    layoutNonVirtualBases(RD);
    layoutFields(RD);
    injectVBPtr(RD);
    injectVFPtr(RD);
    if (HasOwnVFPtr || (HasVBPtr && !(SharedVBPtrBase != null))) {
      Alignment.$assign(std.max(Alignment, PointerInfo.Alignment));
    }
    CharUnits RoundingAlignment = new CharUnits(Alignment);
    if (!MaxFieldAlignment.isZero()) {
      RoundingAlignment.$assign(std.min(RoundingAlignment, MaxFieldAlignment));
    }
    NonVirtualSize.$assign(Size.$assignMove(Size.alignTo(RoundingAlignment)));
    RequiredAlignment.$assign(std.max(RequiredAlignment, Context.toCharUnitsFromBits($uint2long(RD.getMaxAlignment()))));
    layoutVirtualBases(RD);
    finalizeLayout(RD);
  }

  /// \brief Initializes size and alignment and honors some flags.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::initializeLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2421,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::initializeLayout", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder16initializeLayoutEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder16initializeLayoutEPKN5clang10RecordDeclE")
  //</editor-fold>
  public void initializeLayout(/*const*/ RecordDecl /*P*/ RD) {
    IsUnion = RD.isUnion();
    Size.$assignMove(CharUnits.Zero());
    Alignment.$assignMove(CharUnits.One());
    // In 64-bit mode we always perform an alignment step after laying out vbases.
    // In 32-bit mode we do not.  The check to see if we need to perform alignment
    // checks the RequiredAlignment field and performs alignment if it isn't 0.
    RequiredAlignment.$assignMove(Context.getTargetInfo().getTriple().isArch64Bit() ? CharUnits.One() : CharUnits.Zero());
    // Compute the maximum field alignment.
    MaxFieldAlignment.$assignMove(CharUnits.Zero());
    {
      // Honor the default struct packing maximum alignment flag.
      /*uint*/int DefaultMaxFieldAlignment = Context.getLangOpts().PackStruct;
      if ((DefaultMaxFieldAlignment != 0)) {
        MaxFieldAlignment.$assignMove(CharUnits.fromQuantity($uint2long(DefaultMaxFieldAlignment)));
      }
    }
    {
      // Honor the packing attribute.  The MS-ABI ignores pragma pack if its larger
      // than the pointer size.
      /*const*/ MaxFieldAlignmentAttr /*P*/ MFAA = RD.getAttr(MaxFieldAlignmentAttr.class);
      if ((MFAA != null)) {
        /*uint*/int PackedAlignment = MFAA.getAlignment();
        if ($lesseq_uint_ulong(PackedAlignment, Context.getTargetInfo().getPointerWidth(0))) {
          MaxFieldAlignment.$assignMove(Context.toCharUnitsFromBits($uint2long(PackedAlignment)));
        }
      }
    }
    // Packed attribute forces max field alignment to be 1.
    if (RD.hasAttr(PackedAttr.class)) {
      MaxFieldAlignment.$assignMove(CharUnits.One());
    }
    
    // Try to respect the external layout if present.
    UseExternalLayout = false;
    {
      ExternalASTSource /*P*/ Source = Context.getExternalSource();
      if ((Source != null)) {
        ulong$ref $ExternalSize = create_ulong$ref(External.Size); // JAVA
        ulong$ref $ExternalAlign = create_ulong$ref(External.Align); // JAVA
        UseExternalLayout = Source.layoutRecordType(RD, $ExternalSize, $ExternalAlign, External.FieldOffsets, 
            External.BaseOffsets, External.VirtualBaseOffsets);
        External.Size = $ExternalSize.$deref(); // JAVA
        External.Align = $ExternalAlign.$deref(); // JAVA
      }
    }
  }

  /// \brief Initialized C++ layout, compute alignment and virtual alignment and
  /// existence of vfptrs and vbptrs.  Alignment is needed before the vfptr is
  /// laid out.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::initializeCXXLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2455,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::initializeCXXLayout", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder19initializeCXXLayoutEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder19initializeCXXLayoutEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public void initializeCXXLayout(/*const*/ CXXRecordDecl /*P*/ RD) {
    EndsWithZeroSizedObject = false;
    LeadsWithZeroSizedBase = false;
    HasOwnVFPtr = false;
    HasVBPtr = false;
    PrimaryBase = null;
    SharedVBPtrBase = null;
    // Calculate pointer size and alignment.  These are used for vfptr and vbprt
    // injection.
    PointerInfo.Size.$assignMove(
        Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerWidth(0))
    );
    PointerInfo.Alignment.$assignMove(
        Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerAlign(0))
    );
    // Respect pragma pack.
    if (!MaxFieldAlignment.isZero()) {
      PointerInfo.Alignment.$assign(std.min(PointerInfo.Alignment, MaxFieldAlignment));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutNonVirtualBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2474,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutNonVirtualBases", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder21layoutNonVirtualBasesEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder21layoutNonVirtualBasesEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public void layoutNonVirtualBases(/*const*/ CXXRecordDecl /*P*/ RD) {
    // The MS-ABI lays out all bases that contain leading vfptrs before it lays
    // out any bases that do not contain vfptrs.  We implement this as two passes
    // over the bases.  This approach guarantees that the primary base is laid out
    // first.  We use these passes to calculate some additional aggregated
    // information about the bases, such as required alignment and the presence of
    // zero sized members.
    type$ref</*const*/ ASTRecordLayout /*P*/ > PreviousBaseLayout = create_type$null$ref(null);
    // Iterate through the bases and lay out the non-virtual ones.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      final /*const*/ ASTRecordLayout /*&*/ BaseLayout = Context.getASTRecordLayout(BaseDecl);
      // Mark and skip virtual bases.
      if (Base.isVirtual()) {
        HasVBPtr = true;
        continue;
      }
      // Check for a base to share a VBPtr with.
      if (!(SharedVBPtrBase != null) && BaseLayout.hasVBPtr()) {
        SharedVBPtrBase = BaseDecl;
        HasVBPtr = true;
      }
      // Only lay out bases with extendable VFPtrs on the first pass.
      if (!BaseLayout.hasExtendableVFPtr()) {
        continue;
      }
      // If we don't have a primary base, this one qualifies.
      if (!(PrimaryBase != null)) {
        PrimaryBase = BaseDecl;
        LeadsWithZeroSizedBase = BaseLayout.leadsWithZeroSizedBase();
      }
      // Lay out the base.
      layoutNonVirtualBase(RD, BaseDecl, BaseLayout, PreviousBaseLayout);
    }
    // Figure out if we need a fresh VFPtr for this class.
    if (!(PrimaryBase != null) && RD.isDynamicClass()) {
      for (specific_decl_iterator<CXXMethodDecl> i = RD.method_begin(), 
          e = RD.method_end();
           !HasOwnVFPtr && $noteq_specific_decl_iterator$SpecificDecl$C(i, e); i.$preInc())  {
        HasOwnVFPtr = i.$arrow().isVirtual() && i.$arrow().size_overridden_methods() == 0;
      }
    }
    // If we don't have a primary base then we have a leading object that could
    // itself lead with a zero-sized object, something we track.
    boolean CheckLeadingLayout = !(PrimaryBase != null);
    // Iterate through the bases and lay out the non-virtual ones.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      if (Base.isVirtual()) {
        continue;
      }
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      final /*const*/ ASTRecordLayout /*&*/ BaseLayout = Context.getASTRecordLayout(BaseDecl);
      // Only lay out bases without extendable VFPtrs on the second pass.
      if (BaseLayout.hasExtendableVFPtr()) {
        VBPtrOffset.$assignMove(Bases.$at_T1$C$R(BaseDecl).$add(BaseLayout.getNonVirtualSize()));
        continue;
      }
      // If this is the first layout, check to see if it leads with a zero sized
      // object.  If it does, so do we.
      if (CheckLeadingLayout) {
        CheckLeadingLayout = false;
        LeadsWithZeroSizedBase = BaseLayout.leadsWithZeroSizedBase();
      }
      // Lay out the base.
      layoutNonVirtualBase(RD, BaseDecl, BaseLayout, PreviousBaseLayout);
      VBPtrOffset.$assignMove(Bases.$at_T1$C$R(BaseDecl).$add(BaseLayout.getNonVirtualSize()));
    }
    // Set our VBPtroffset if we know it at this point.
    if (!HasVBPtr) {
      VBPtrOffset.$assignMove(CharUnits.fromQuantity(-1));
    } else if ((SharedVBPtrBase != null)) {
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(SharedVBPtrBase);
      VBPtrOffset.$assignMove(Bases.$at_T1$C$R(SharedVBPtrBase).$add(Layout.getVBPtrOffset()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutNonVirtualBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2562,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutNonVirtualBase", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder20layoutNonVirtualBaseEPKN5clang13CXXRecordDeclES4_RKNS1_15ASTRecordLayoutERPS6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder20layoutNonVirtualBaseEPKN5clang13CXXRecordDeclES4_RKNS1_15ASTRecordLayoutERPS6_")
  //</editor-fold>
  public void layoutNonVirtualBase(/*const*/ CXXRecordDecl /*P*/ RD, 
                      /*const*/ CXXRecordDecl /*P*/ BaseDecl, 
                      final /*const*/ ASTRecordLayout /*&*/ BaseLayout, 
                      final type$ref</*const*/ ASTRecordLayout /*P*/ /*&*/> PreviousBaseLayout) {
    // Insert padding between two bases if the left first one is zero sized or
    // contains a zero sized subobject and the right is zero sized or one leads
    // with a zero sized base.
    boolean MDCUsesEBO = recordUsesEBO(RD);
    if ((PreviousBaseLayout.$deref() != null) && PreviousBaseLayout.$deref().endsWithZeroSizedObject()
       && BaseLayout.leadsWithZeroSizedBase() && !MDCUsesEBO) {
      Size.$postInc(0);
    }
    ElementInfo Info = getAdjustedElementInfo(BaseLayout);
    CharUnits BaseOffset/*J*/= new CharUnits();
    
    // Respect the external AST source base offset, if present.
    boolean FoundBase = false;
    if (UseExternalLayout) {
      FoundBase = External.getExternalNVBaseOffset(BaseDecl, BaseOffset);
      if (FoundBase) {
        assert (BaseOffset.$greatereq(Size)) : "base offset already allocated";
        Size.$assign(BaseOffset);
      }
    }
    if (!FoundBase) {
      if (MDCUsesEBO && BaseDecl.isEmpty()
         && BaseLayout.getNonVirtualSize().$eq(CharUnits.Zero())) {
        BaseOffset.$assignMove(CharUnits.Zero());
      } else {
        // Otherwise, lay the base out at the end of the MDC.
        BaseOffset.$assign(Size.$assignMove(Size.alignTo(Info.Alignment)));
      }
    }
    Bases.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(BaseDecl, BaseOffset));
    Size.$addassign(BaseLayout.getNonVirtualSize());
    PreviousBaseLayout.$set($AddrOf(BaseLayout));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::injectVFPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2718,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::injectVFPtr", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11injectVFPtrEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11injectVFPtrEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public void injectVFPtr(/*const*/ CXXRecordDecl /*P*/ RD) {
    if (!HasOwnVFPtr) {
      return;
    }
    // Make sure that the amount we push the struct back by is a multiple of the
    // alignment.
    CharUnits Offset = PointerInfo.Size.alignTo(std.max(RequiredAlignment, Alignment));
    // Push back the vbptr, but increase the size of the object and push back
    // regular fields by the offset only if not using external record layout.
    if (HasVBPtr) {
      VBPtrOffset.$addassign(Offset);
    }
    if (UseExternalLayout) {
      return;
    }
    
    Size.$addassign(Offset);
    
    // If we're using an external layout, the fields offsets have already
    // accounted for this adjustment.
    // JAVA: for (final ulong$ref/*uint64_t &*/ FieldOffset : FieldOffsets)  {
    for(int i = 0; i < FieldOffsets.size(); i++) {
      FieldOffsets.ref$at(i).$set$addassign(Context.toBits(new CharUnits(Offset)));
    }
    for (final std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ Base : Bases)  {
      Base.second.$addassign(Offset);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::injectVBPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2693,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::injectVBPtr", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11injectVBPtrEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11injectVBPtrEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public void injectVBPtr(/*const*/ CXXRecordDecl /*P*/ RD) {
    if (!HasVBPtr || (SharedVBPtrBase != null)) {
      return;
    }
    // Inject the VBPointer at the injection site.
    CharUnits InjectionSite = new CharUnits(VBPtrOffset);
    // But before we do, make sure it's properly aligned.
    VBPtrOffset.$assignMove(VBPtrOffset.alignTo(PointerInfo.Alignment));
    // Shift everything after the vbptr down, unless we're using an external
    // layout.
    if (UseExternalLayout) {
      return;
    }
    // Determine where the first field should be laid out after the vbptr.
    CharUnits FieldStart = VBPtrOffset.$add(PointerInfo.Size);
    // Make sure that the amount we push the fields back by is a multiple of the
    // alignment.
    CharUnits Offset = (FieldStart.$sub(InjectionSite)).
        alignTo(std.max(RequiredAlignment, Alignment));
    Size.$addassign(Offset);
    // JAVA: for (final ulong$ref/*uint64_t &*/ FieldOffset : FieldOffsets)  {
    for(int i = 0; i < FieldOffsets.size(); i++) {
      FieldOffsets.ref$at(i).$set$addassign(Context.toBits(new CharUnits(Offset)));
    }
    for (final std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits> /*&*/ Base : Bases)  {
      if (Base.second.$greatereq(InjectionSite)) {
        Base.second.$addassign(Offset);
      }
    }
  }

  /// \brief Lays out the fields of the record.  Also rounds size up to
  /// alignment.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2601,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutFields", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder12layoutFieldsEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder12layoutFieldsEPKN5clang10RecordDeclE")
  //</editor-fold>
  public void layoutFields(/*const*/ RecordDecl /*P*/ RD) {
    LastFieldIsNonZeroWidthBitfield = false;
    for (/*const*/ FieldDecl /*P*/ Field : RD.fields())  {
      layoutField(Field);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2607,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutField", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11layoutFieldEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder11layoutFieldEPKN5clang9FieldDeclE")
  //</editor-fold>
  public void layoutField(/*const*/ FieldDecl /*P*/ FD) {
    if (FD.isBitField()) {
      layoutBitField(FD);
      return;
    }
    LastFieldIsNonZeroWidthBitfield = false;
    ElementInfo Info = getAdjustedElementInfo(FD);
    Alignment.$assign(std.max(Alignment, Info.Alignment));
    if (IsUnion) {
      placeFieldAtOffset(CharUnits.Zero());
      Size.$assign(std.max(Size, Info.Size));
    } else {
      CharUnits FieldOffset/*J*/= new CharUnits();
      if (UseExternalLayout) {
        FieldOffset.$assignMove(
            Context.toCharUnitsFromBits(External.getExternalFieldOffset(FD))
        );
        assert (FieldOffset.$greatereq(Size)) : "field offset already allocated";
      } else {
        FieldOffset.$assignMove(Size.alignTo(Info.Alignment));
      }
      placeFieldAtOffset(new CharUnits(FieldOffset));
      Size.$assignMove(FieldOffset.$add(Info.Size));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2632,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutBitField", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder14layoutBitFieldEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder14layoutBitFieldEPKN5clang9FieldDeclE")
  //</editor-fold>
  public void layoutBitField(/*const*/ FieldDecl /*P*/ FD) {
    /*uint*/int Width = FD.getBitWidthValue(Context);
    if (Width == 0) {
      layoutZeroWidthBitField(FD);
      return;
    }
    ElementInfo Info = getAdjustedElementInfo(FD);
    // Clamp the bitfield to a containable size for the sake of being able
    // to lay them out.  Sema will throw an error.
    if ($uint2llong(Width) > Context.toBits(new CharUnits(Info.Size))) {
      Width = $long2uint(Context.toBits(new CharUnits(Info.Size)));
    }
    // Check to see if this bitfield fits into an existing allocation.  Note:
    // MSVC refuses to pack bitfields of formal types with different sizes
    // into the same allocation.
    if (!IsUnion && LastFieldIsNonZeroWidthBitfield
       && CurrentBitfieldSize.$eq(Info.Size) && $lesseq_uint(Width, RemainingBitsInField)) {
      placeFieldAtBitOffset(Context.toBits(new CharUnits(Size)) - $uint2llong(RemainingBitsInField));
      RemainingBitsInField -= Width;
      return;
    }
    LastFieldIsNonZeroWidthBitfield = true;
    CurrentBitfieldSize.$assign(Info.Size);
    if (IsUnion) {
      placeFieldAtOffset(CharUnits.Zero());
      Size.$assign(std.max(Size, Info.Size));
      // TODO: Add a Sema warning that MS ignores bitfield alignment in unions.
    } else {
      // Allocate a new block of memory and place the bitfield in it.
      CharUnits FieldOffset = Size.alignTo(Info.Alignment);
      placeFieldAtOffset(new CharUnits(FieldOffset));
      Size.$assignMove(FieldOffset.$add(Info.Size));
      Alignment.$assign(std.max(Alignment, Info.Alignment));
      RemainingBitsInField = $llong2uint(Context.toBits(new CharUnits(Info.Size)) - $uint2llong(Width));
    }
  }

  /// \brief Lays out a single zero-width bit-field in the record and handles
  /// special cases associated with zero-width bit-fields.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutZeroWidthBitField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2668,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutZeroWidthBitField", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder23layoutZeroWidthBitFieldEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder23layoutZeroWidthBitFieldEPKN5clang9FieldDeclE")
  //</editor-fold>
  public void layoutZeroWidthBitField(/*const*/ FieldDecl /*P*/ FD) {
    // Zero-width bitfields are ignored unless they follow a non-zero-width
    // bitfield.
    if (!LastFieldIsNonZeroWidthBitfield) {
      placeFieldAtOffset(IsUnion ? CharUnits.Zero() : new CharUnits(Size));
      // TODO: Add a Sema warning that MS ignores alignment for zero
      // sized bitfields that occur after zero-size bitfields or non-bitfields.
      return;
    }
    LastFieldIsNonZeroWidthBitfield = false;
    ElementInfo Info = getAdjustedElementInfo(FD);
    if (IsUnion) {
      placeFieldAtOffset(CharUnits.Zero());
      Size.$assign(std.max(Size, Info.Size));
      // TODO: Add a Sema warning that MS ignores bitfield alignment in unions.
    } else {
      // Round up the current record size to the field's alignment boundary.
      CharUnits FieldOffset = Size.alignTo(Info.Alignment);
      placeFieldAtOffset(new CharUnits(FieldOffset));
      Size.$assign(FieldOffset);
      Alignment.$assign(std.max(Alignment, Info.Alignment));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutVirtualBases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2743,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::layoutVirtualBases", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder18layoutVirtualBasesEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder18layoutVirtualBasesEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public void layoutVirtualBases(/*const*/ CXXRecordDecl /*P*/ RD) {
    if (!HasVBPtr) {
      return;
    }
    // Vtordisps are always 4 bytes (even in 64-bit mode)
    CharUnits VtorDispSize = CharUnits.fromQuantity(4);
    CharUnits VtorDispAlignment = new CharUnits(VtorDispSize);
    // vtordisps respect pragma pack.
    if (!MaxFieldAlignment.isZero()) {
      VtorDispAlignment.$assign(std.min(VtorDispAlignment, MaxFieldAlignment));
    }
    // The alignment of the vtordisp is at least the required alignment of the
    // entire record.  This requirement may be present to support vtordisp
    // injection.
    for (final /*const*/ CXXBaseSpecifier /*&*/ VBase : RD.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = VBase.getType().$arrow().getAsCXXRecordDecl();
      final /*const*/ ASTRecordLayout /*&*/ BaseLayout = Context.getASTRecordLayout(BaseDecl);
      RequiredAlignment.$assign(
          std.max(RequiredAlignment, BaseLayout.getRequiredAlignment())
      );
    }
    VtorDispAlignment.$assign(std.max(VtorDispAlignment, RequiredAlignment));
    // Compute the vtordisp set.
    SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > HasVtorDispSet/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2);
    computeVtorDispSet(HasVtorDispSet, RD);
    // Iterate through the virtual bases and lay them out.
    /*const*/ ASTRecordLayout /*P*/ PreviousBaseLayout = null;
    for (final /*const*/ CXXBaseSpecifier /*&*/ VBase : RD.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = VBase.getType().$arrow().getAsCXXRecordDecl();
      final /*const*/ ASTRecordLayout /*&*/ BaseLayout = Context.getASTRecordLayout(BaseDecl);
      boolean HasVtordisp = $greater_uint(HasVtorDispSet.count(BaseDecl), 0);
      // Insert padding between two bases if the left first one is zero sized or
      // contains a zero sized subobject and the right is zero sized or one leads
      // with a zero sized base.  The padding between virtual bases is 4
      // bytes (in both 32 and 64 bits modes) and always involves rounding up to
      // the required alignment, we don't know why.
      if (((PreviousBaseLayout != null) && PreviousBaseLayout.endsWithZeroSizedObject()
         && BaseLayout.leadsWithZeroSizedBase() && !recordUsesEBO(RD))
         || HasVtordisp) {
        Size.$assignMove(Size.alignTo(VtorDispAlignment).$add(VtorDispSize));
        Alignment.$assign(std.max(VtorDispAlignment, Alignment));
      }
      // Insert the virtual base.
      ElementInfo Info = getAdjustedElementInfo(BaseLayout);
      CharUnits BaseOffset/*J*/= new CharUnits();
      
      // Respect the external AST source base offset, if present.
      boolean FoundBase = false;
      if (UseExternalLayout) {
        FoundBase = External.getExternalVBaseOffset(BaseDecl, BaseOffset);
        if (FoundBase) {
          assert (BaseOffset.$greatereq(Size)) : "base offset already allocated";
        }
      }
      if (!FoundBase) {
        BaseOffset.$assignMove(Size.alignTo(Info.Alignment));
      }
      
      VBases.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(BaseDecl, 
              new ASTRecordLayout.VBaseInfo(new CharUnits(BaseOffset), HasVtordisp)));
      Size.$assignMove(BaseOffset.$add(BaseLayout.getNonVirtualSize()));
      PreviousBaseLayout = $AddrOf(BaseLayout);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::finalizeLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2803,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::finalizeLayout", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder14finalizeLayoutEPKN5clang10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder14finalizeLayoutEPKN5clang10RecordDeclE")
  //</editor-fold>
  public void finalizeLayout(/*const*/ RecordDecl /*P*/ RD) {
    // Respect required alignment.  Note that in 32-bit mode Required alignment
    // may be 0 and cause size not to be updated.
    DataSize.$assign(Size);
    if (!RequiredAlignment.isZero()) {
      Alignment.$assign(std.max(Alignment, RequiredAlignment));
      CharUnits RoundingAlignment = new CharUnits(Alignment);
      if (!MaxFieldAlignment.isZero()) {
        RoundingAlignment.$assign(std.min(RoundingAlignment, MaxFieldAlignment));
      }
      RoundingAlignment.$assign(std.max(RoundingAlignment, RequiredAlignment));
      Size.$assignMove(Size.alignTo(RoundingAlignment));
    }
    if (Size.isZero()) {
      if (!recordUsesEBO(RD) || !cast_CXXRecordDecl(RD).isEmpty()) {
        EndsWithZeroSizedObject = true;
        LeadsWithZeroSizedBase = true;
      }
      // Zero-sized structures have size equal to their alignment if a
      // __declspec(align) came into play.
      if (RequiredAlignment.$greatereq(MinEmptyStructSize)) {
        Size.$assign(Alignment);
      } else {
        Size.$assign(MinEmptyStructSize);
      }
    }
    if (UseExternalLayout) {
      Size.$assignMove(Context.toCharUnitsFromBits(External.Size));
      if ((External.Align != 0)) {
        Alignment.$assignMove(Context.toCharUnitsFromBits(External.Align));
      }
    }
  }

  /// \brief Gets the size and alignment of a base taking pragma pack and
  /// __declspec(align) into account.
  // namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::getAdjustedElementInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2329,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::getAdjustedElementInfo", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder22getAdjustedElementInfoERKN5clang15ASTRecordLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder22getAdjustedElementInfoERKN5clang15ASTRecordLayoutE")
  //</editor-fold>
  public MicrosoftRecordLayoutBuilder.ElementInfo getAdjustedElementInfo(final /*const*/ ASTRecordLayout /*&*/ Layout) {
    ElementInfo Info/*J*/= new ElementInfo();
    Info.Alignment.$assignMove(Layout.getAlignment());
    // Respect pragma pack.
    if (!MaxFieldAlignment.isZero()) {
      Info.Alignment.$assign(std.min(Info.Alignment, MaxFieldAlignment));
    }
    // Track zero-sized subobjects here where it's already available.
    EndsWithZeroSizedObject = Layout.endsWithZeroSizedObject();
    // Respect required alignment, this is necessary because we may have adjusted
    // the alignment in the case of pragam pack.  Note that the required alignment
    // doesn't actually apply to the struct alignment at this point.
    Alignment.$assign(std.max(Alignment, Info.Alignment));
    RequiredAlignment.$assign(std.max(RequiredAlignment, Layout.getRequiredAlignment()));
    Info.Alignment.$assign(std.max(Info.Alignment, Layout.getRequiredAlignment()));
    Info.Size.$assignMove(Layout.getNonVirtualSize());
    return Info;
  }

  /// \brief Gets the size and alignment of a field taking pragma  pack and
  /// __declspec(align) into account.  It also updates RequiredAlignment as a
  /// side effect because it is most convenient to do so here.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::getAdjustedElementInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*unfold std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2349,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::getAdjustedElementInfo", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder22getAdjustedElementInfoEPKN5clang9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder22getAdjustedElementInfoEPKN5clang9FieldDeclE")
  //</editor-fold>
  public MicrosoftRecordLayoutBuilder.ElementInfo getAdjustedElementInfo(/*const*/ FieldDecl /*P*/ FD) {
    // Get the alignment of the field type's natural alignment, ignore any
    // alignment attributes.
    ElementInfo Info/*J*/= new ElementInfo();
//    std.tie(Info.Size, Info.Alignment).$assign(
//        Context.getTypeInfoInChars(FD.getType().$arrow().getUnqualifiedDesugaredType())
//    );
    // JAVA: unfold std.tie
    std.pair<CharUnits, CharUnits> $pair = Context.getTypeInfoInChars(FD.getType().$arrow().getUnqualifiedDesugaredType());
    Info.Size = $pair.first;
    Info.Alignment = $pair.second;
    
    // Respect align attributes on the field.
    CharUnits FieldRequiredAlignment = Context.toCharUnitsFromBits($uint2long(FD.getMaxAlignment()));
    // Respect align attributes on the type.
    if (Context.isAlignmentRequired(FD.getType())) {
      FieldRequiredAlignment.$assign(std.max(Context.getTypeAlignInChars(FD.getType()), FieldRequiredAlignment));
    }
    // Respect attributes applied to subobjects of the field.
    if (FD.isBitField()) {
      // For some reason __declspec align impacts alignment rather than required
      // alignment when it is applied to bitfields.
      Info.Alignment.$assign(std.max(Info.Alignment, FieldRequiredAlignment));
    } else {
      {
        /*const*/ RecordType /*P*/ RT = FD.getType().$arrow().getBaseElementTypeUnsafe().getAs$RecordType();
        if ((RT != null)) {
          final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RT.getDecl());
          EndsWithZeroSizedObject = Layout.endsWithZeroSizedObject();
          FieldRequiredAlignment.$assign(std.max(FieldRequiredAlignment, 
                  Layout.getRequiredAlignment()));
        }
      }
      // Capture required alignment as a side-effect.
      RequiredAlignment.$assign(std.max(RequiredAlignment, FieldRequiredAlignment));
    }
    // Respect pragma pack, attribute pack and declspec align
    if (!MaxFieldAlignment.isZero()) {
      Info.Alignment.$assign(std.min(Info.Alignment, MaxFieldAlignment));
    }
    if (FD.hasAttr(PackedAttr.class)) {
      Info.Alignment.$assignMove(CharUnits.One());
    }
    Info.Alignment.$assign(std.max(Info.Alignment, FieldRequiredAlignment));
    return Info;
  }

  /// \brief Places a field at an offset in CharUnits.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::placeFieldAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2255,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::placeFieldAtOffset", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder18placeFieldAtOffsetEN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder18placeFieldAtOffsetEN5clang9CharUnitsE")
  //</editor-fold>
  public void placeFieldAtOffset(CharUnits FieldOffset) {
    FieldOffsets.push_back(Context.toBits(new CharUnits(FieldOffset)));
  }

  /// \brief Places a bitfield at a bit offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::placeFieldAtBitOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2259,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::placeFieldAtBitOffset", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder21placeFieldAtBitOffsetEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilder21placeFieldAtBitOffsetEy")
  //</editor-fold>
  public void placeFieldAtBitOffset(long/*uint64_t*/ FieldOffset) {
    FieldOffsets.push_back(FieldOffset);
  }

  /// \brief Compute the set of virtual bases for which vtordisps are required.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::computeVtorDispSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2853,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::computeVtorDispSet", NM="_ZNK12_GLOBAL__N_128MicrosoftRecordLayoutBuilder18computeVtorDispSetERN4llvm15SmallPtrSetImplIPKN5clang13CXXRecordDeclEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZNK12_GLOBAL__N_128MicrosoftRecordLayoutBuilder18computeVtorDispSetERN4llvm15SmallPtrSetImplIPKN5clang13CXXRecordDeclEEES6_")
  //</editor-fold>
  public void computeVtorDispSet(final SmallPtrSetImpl</*const*/ CXXRecordDecl /*P*/ > /*&*/ HasVtordispSet, 
                    /*const*/ CXXRecordDecl /*P*/ RD) /*const*/ {
    // /vd2 or #pragma vtordisp(2): Always use vtordisps for virtual bases with
    // vftables.
    if (RD.getMSVtorDispMode() == MSVtorDispAttr.Mode.ForVFTable) {
      for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.vbases$Const()) {
        /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
        final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(BaseDecl);
        if (Layout.hasExtendableVFPtr()) {
          HasVtordispSet.insert(BaseDecl);
        }
      }
      return;
    }
    
    // If any of our bases need a vtordisp for this type, so do we.  Check our
    // direct bases for vtordisp requirements.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(BaseDecl);
      for (final /*const*/std.pair</*const*/ CXXRecordDecl /*P*/ , VBaseInfo> /*&*/ bi : Layout.getVBaseOffsetsMap())  {
        if (bi.second.hasVtorDisp()) {
          HasVtordispSet.insert(bi.first);
        }
      }
    }
    // We don't introduce any additional vtordisps if either:
    // * A user declared constructor or destructor aren't declared.
    // * #pragma vtordisp(0) or the /vd0 flag are in use.
    if ((!RD.hasUserDeclaredConstructor() && !RD.hasUserDeclaredDestructor())
       || RD.getMSVtorDispMode() == MSVtorDispAttr.Mode.Never) {
      return;
    }
    // /vd1 or #pragma vtordisp(1): Try to guess based on whether we think it's
    // possible for a partially constructed object with virtual base overrides to
    // escape a non-trivial constructor.
    assert (RD.getMSVtorDispMode() == MSVtorDispAttr.Mode.ForVBaseOverride);
    // Compute a set of base classes which define methods we override.  A virtual
    // base in this set will require a vtordisp.  A virtual base that transitively
    // contains one of these bases as a non-virtual base will also require a
    // vtordisp.
    SmallPtrSet</*const*/ CXXMethodDecl /*P*/ > Work/*J*/= new SmallPtrSet</*const*/ CXXMethodDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > BasesWithOverriddenMethods/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2);
    // Seed the working set with our non-destructor, non-pure virtual methods.
    for (/*const*/ CXXMethodDecl /*P*/ MD : RD.methods())  {
      if (MD.isVirtual() && !isa_CXXDestructorDecl(MD) && !MD.isPure()) {
        Work.insert(MD);
      }
    }
    while (!Work.empty()) {
      /*const*/ CXXMethodDecl /*P*/ MD = Work.begin().$star();
      type$ptr<CXXMethodDecl>/*method_iterator*/ i = $tryClone(MD.begin_overridden_methods());
      type$ptr<CXXMethodDecl>/*method_iterator*/ e = $tryClone(MD.end_overridden_methods());
      // If a virtual method has no-overrides it lives in its parent's vtable.
      if ($eq_ptr(i, e)) {
        BasesWithOverriddenMethods.insert(MD.getParent$Const());
      } else {
        Work.insert$T(i, e);
      }
      // We've finished processing this element, remove it from the working set.
      Work.erase(MD);
    }
    // For each of our virtual bases, check if it is in the set of overridden
    // bases or if it transitively contains a non-virtual base that is.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      if (!(HasVtordispSet.count(BaseDecl) != 0)
         && RequiresVtordisp(BasesWithOverriddenMethods, BaseDecl)) {
        HasVtordispSet.insert(BaseDecl);
      }
    }
  }

  public final /*const*/ ASTContext /*&*/ Context;
  /// \brief The size of the record being laid out.
  public CharUnits Size;
  /// \brief The non-virtual size of the record layout.
  public CharUnits NonVirtualSize;
  /// \brief The data size of the record layout.
  public CharUnits DataSize;
  /// \brief The current alignment of the record layout.
  public CharUnits Alignment;
  /// \brief The maximum allowed field alignment. This is set by #pragma pack.
  public CharUnits MaxFieldAlignment;
  /// \brief The alignment that this record must obey.  This is imposed by
  /// __declspec(align()) on the record itself or one of its fields or bases.
  public CharUnits RequiredAlignment;
  /// \brief The size of the allocation of the currently active bitfield.
  /// This value isn't meaningful unless LastFieldIsNonZeroWidthBitfield
  /// is true.
  public CharUnits CurrentBitfieldSize;
  /// \brief Offset to the virtual base table pointer (if one exists).
  public CharUnits VBPtrOffset;
  /// \brief Minimum record size possible.
  public CharUnits MinEmptyStructSize;
  /// \brief The size and alignment info of a pointer.
  public ElementInfo PointerInfo;
  /// \brief The primary base class (if one exists).
  public /*const*/ CXXRecordDecl /*P*/ PrimaryBase;
  /// \brief The class we share our vb-pointer with.
  public /*const*/ CXXRecordDecl /*P*/ SharedVBPtrBase;
  /// \brief The collection of field offsets.
  public SmallVectorULong FieldOffsets;
  /// \brief Base classes and their offsets in the record.
  public DenseMap</*const*/ CXXRecordDecl /*P*/ , CharUnits> Bases;
  /// \brief virtual base classes and their offsets in the record.
  public DenseMap</*const*/ CXXRecordDecl /*P*/ , VBaseInfo> VBases;
  /// \brief The number of remaining bits in our last bitfield allocation.
  /// This value isn't meaningful unless LastFieldIsNonZeroWidthBitfield is
  /// true.
  public /*uint*/int RemainingBitsInField;
  public /*JBIT bool*/ boolean IsUnion /*: 1*/;
  /// \brief True if the last field laid out was a bitfield and was not 0
  /// width.
  public /*JBIT bool*/ boolean LastFieldIsNonZeroWidthBitfield /*: 1*/;
  /// \brief True if the class has its own vftable pointer.
  public /*JBIT bool*/ boolean HasOwnVFPtr /*: 1*/;
  /// \brief True if the class has a vbtable pointer.
  public /*JBIT bool*/ boolean HasVBPtr /*: 1*/;
  /// \brief True if the last sub-object within the type is zero sized or the
  /// object itself is zero sized.  This *does not* count members that are not
  /// records.  Only used for MS-ABI.
  public /*JBIT bool*/ boolean EndsWithZeroSizedObject /*: 1*/;
  /// \brief True if this class is zero sized or first base is zero sized or
  /// has this property.  Only used for MS-ABI.
  public /*JBIT bool*/ boolean LeadsWithZeroSizedBase /*: 1*/;
  
  /// \brief True if the external AST source provided a layout for this record.
  public /*JBIT bool*/ boolean UseExternalLayout /*: 1*/;
  
  /// \brief The layout provided by the external AST source. Only active if
  /// UseExternalLayout is true.
  public ExternalLayout External;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftRecordLayoutBuilder::~MicrosoftRecordLayoutBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2211,
   FQN="(anonymous namespace)::MicrosoftRecordLayoutBuilder::~MicrosoftRecordLayoutBuilder", NM="_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZN12_GLOBAL__N_128MicrosoftRecordLayoutBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    External.$destroy();
    VBases.$destroy();
    Bases.$destroy();
    FieldOffsets.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", Size=" + Size // NOI18N
              + ", NonVirtualSize=" + NonVirtualSize // NOI18N
              + ", DataSize=" + DataSize // NOI18N
              + ", Alignment=" + Alignment // NOI18N
              + ", MaxFieldAlignment=" + MaxFieldAlignment // NOI18N
              + ", RequiredAlignment=" + RequiredAlignment // NOI18N
              + ", CurrentBitfieldSize=" + CurrentBitfieldSize // NOI18N
              + ", VBPtrOffset=" + VBPtrOffset // NOI18N
              + ", MinEmptyStructSize=" + MinEmptyStructSize // NOI18N
              + ", PointerInfo=" + PointerInfo // NOI18N
              + ", PrimaryBase=" + PrimaryBase // NOI18N
              + ", SharedVBPtrBase=" + SharedVBPtrBase // NOI18N
              + ", FieldOffsets=" + FieldOffsets // NOI18N
              + ", Bases=" + Bases // NOI18N
              + ", VBases=" + VBases // NOI18N
              + ", RemainingBitsInField=" + RemainingBitsInField // NOI18N
              + ", IsUnion=" + IsUnion // NOI18N
              + ", LastFieldIsNonZeroWidthBitfield=" + LastFieldIsNonZeroWidthBitfield // NOI18N
              + ", HasOwnVFPtr=" + HasOwnVFPtr // NOI18N
              + ", HasVBPtr=" + HasVBPtr // NOI18N
              + ", EndsWithZeroSizedObject=" + EndsWithZeroSizedObject // NOI18N
              + ", LeadsWithZeroSizedBase=" + LeadsWithZeroSizedBase // NOI18N
              + ", UseExternalLayout=" + UseExternalLayout // NOI18N
              + ", External=" + External; // NOI18N
  }
}
