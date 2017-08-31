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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
//<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 464,
 FQN="clang::MicrosoftVTableContext", NM="_ZN5clang22MicrosoftVTableContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContextE")
//</editor-fold>
public class MicrosoftVTableContext extends /*public*/ VTableContextBase implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::MethodVFTableLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 466,
   FQN="clang::MicrosoftVTableContext::MethodVFTableLocation", NM="_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationE")
  //</editor-fold>
  public static class/*struct*/ MethodVFTableLocation implements Native.NativePOD<MethodVFTableLocation> {
    /// If nonzero, holds the vbtable index of the virtual base with the vfptr.
    public long/*uint64_t*/ VBTableIndex;
    
    /// If nonnull, holds the last vbase which contains the vfptr that the
    /// method definition is adjusted to.
    public /*const*/ CXXRecordDecl /*P*/ VBase;
    
    /// This is the offset of the vfptr from the start of the last vbase, or the
    /// complete type if there are no virtual bases.
    public CharUnits VFPtrOffset;
    
    /// Method's index in the vftable.
    public long/*uint64_t*/ Index;
    
    //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::MethodVFTableLocation::MethodVFTableLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 481,
     FQN="clang::MicrosoftVTableContext::MethodVFTableLocation::MethodVFTableLocation", NM="_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationC1Ev")
    //</editor-fold>
    public MethodVFTableLocation() {
      // : VBTableIndex(0), VBase(null), VFPtrOffset(CharUnits::Zero()), Index(0) 
      //START JInit
      this.VBTableIndex = $int2ulong(0);
      this.VBase = null;
      this.VFPtrOffset = CharUnits.Zero();
      this.Index = $int2ulong(0);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::MethodVFTableLocation::MethodVFTableLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 485,
     FQN="clang::MicrosoftVTableContext::MethodVFTableLocation::MethodVFTableLocation", NM="_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationC1EyPKNS_13CXXRecordDeclENS_9CharUnitsEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationC1EyPKNS_13CXXRecordDeclENS_9CharUnitsEy")
    //</editor-fold>
    public MethodVFTableLocation(long/*uint64_t*/ VBTableIndex, /*const*/ CXXRecordDecl /*P*/ VBase, 
        CharUnits VFPtrOffset, long/*uint64_t*/ Index) {
      // : VBTableIndex(VBTableIndex), VBase(VBase), VFPtrOffset(VFPtrOffset), Index(Index) 
      //START JInit
      this.VBTableIndex = VBTableIndex;
      this.VBase = VBase;
      this.VFPtrOffset = new CharUnits(VFPtrOffset);
      this.Index = Index;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::MethodVFTableLocation::operator<">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 490,
     FQN="clang::MicrosoftVTableContext::MethodVFTableLocation::operator<", NM="_ZNK5clang22MicrosoftVTableContext21MethodVFTableLocationltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang22MicrosoftVTableContext21MethodVFTableLocationltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ MethodVFTableLocation /*&*/ other) /*const*/ {
      if (VBTableIndex != other.VBTableIndex) {
        assert (VBase != other.VBase);
        return $less_ulong(VBTableIndex, other.VBTableIndex);
      }
      return VFPtrOffset.$less(other.VFPtrOffset) || (!VFPtrOffset.$less(other.VFPtrOffset)  && Index < other.Index);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::MethodVFTableLocation::MethodVFTableLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 466,
     FQN="clang::MicrosoftVTableContext::MethodVFTableLocation::MethodVFTableLocation", NM="_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationC1ERKS1_")
    //</editor-fold>
    public /*inline*/ MethodVFTableLocation(final /*const*/ MethodVFTableLocation /*&*/ $Prm0) {
      // : VBTableIndex(.VBTableIndex), VBase(.VBase), VFPtrOffset(.VFPtrOffset), Index(.Index) 
      //START JInit
      this.VBTableIndex = $Prm0.VBTableIndex;
      this.VBase = $Prm0.VBase;
      this.VFPtrOffset = new CharUnits($Prm0.VFPtrOffset);
      this.Index = $Prm0.Index;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::MethodVFTableLocation::MethodVFTableLocation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 466,
     FQN="clang::MicrosoftVTableContext::MethodVFTableLocation::MethodVFTableLocation", NM="_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationC1EOS1_")
    //</editor-fold>
    public /*inline*/ MethodVFTableLocation(JD$Move _dparam, final MethodVFTableLocation /*&&*/$Prm0) {
      // : VBTableIndex(static_cast<MethodVFTableLocation &&>().VBTableIndex), VBase(static_cast<MethodVFTableLocation &&>().VBase), VFPtrOffset(static_cast<MethodVFTableLocation &&>().VFPtrOffset), Index(static_cast<MethodVFTableLocation &&>().Index) 
      //START JInit
      this.VBTableIndex = $Prm0.VBTableIndex;
      this.VBase = $Prm0.VBase;
      this.VFPtrOffset = new CharUnits(JD$Move.INSTANCE, $Prm0.VFPtrOffset);
      this.Index = $Prm0.Index;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::MethodVFTableLocation::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 466,
     FQN="clang::MicrosoftVTableContext::MethodVFTableLocation::operator=", NM="_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext21MethodVFTableLocationaSERKS1_")
    //</editor-fold>
    public /*inline*/ MethodVFTableLocation /*&*/ $assign(final /*const*/ MethodVFTableLocation /*&*/ $Prm0) {
      this.VBTableIndex = $Prm0.VBTableIndex;
      this.VBase = $Prm0.VBase;
      this.VFPtrOffset.$assign($Prm0.VFPtrOffset);
      this.Index = $Prm0.Index;
      return /*Deref*/this;
    }

    @Override
    public MethodVFTableLocation clone() {
      MethodVFTableLocation res = new MethodVFTableLocation(this);
      return res;
    }
    
    @Override public String toString() {
      return "" + "VBTableIndex=" + VBTableIndex // NOI18N
                + ", VBase=" + VBase // NOI18N
                + ", VFPtrOffset=" + VFPtrOffset // NOI18N
                + ", Index=" + Index; // NOI18N
    }
  };
/*private:*/
  private final ASTContext /*&*/ Context;
  
  /*typedef llvm::DenseMap<GlobalDecl, MethodVFTableLocation> MethodVFTableLocationsTy*/
//  public final class MethodVFTableLocationsTy extends DenseMap<GlobalDecl, MethodVFTableLocation>{ };
  private DenseMap<GlobalDecl, MethodVFTableLocation> MethodVFTableLocations;
  
  /*typedef llvm::DenseMap<const CXXRecordDecl *, VPtrInfoVector *> VFPtrLocationsMapTy*/
//  public final class VFPtrLocationsMapTy extends DenseMap</*const*/ CXXRecordDecl /*P*/ , SmallVector<VPtrInfo /*P*/ > /*P*/>{ };
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , SmallVector<VPtrInfo /*P*/ > /*P*/> VFPtrLocations;
  
  /*typedef std::pair<const CXXRecordDecl *, CharUnits> VFTableIdTy*/
//  public final class VFTableIdTy extends std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>{ };
  /*typedef llvm::DenseMap<VFTableIdTy, const VTableLayout *> VFTableLayoutMapTy*/
//  public final class VFTableLayoutMapTy extends DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>, /*const*/ VTableLayout /*P*/ >{ };
  private DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>, /*const*/ VTableLayout /*P*/ > VFTableLayouts;
  
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , VirtualBaseInfo /*P*/ > VBaseInfo;
  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::enumerateVFPtrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 517,
   FQN="clang::MicrosoftVTableContext::enumerateVFPtrs", NM="_ZN5clang22MicrosoftVTableContext15enumerateVFPtrsEPKNS_13CXXRecordDeclERN4llvm11SmallVectorIPNS_8VPtrInfoELj2EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext15enumerateVFPtrsEPKNS_13CXXRecordDeclERN4llvm11SmallVectorIPNS_8VPtrInfoELj2EEE")
  //</editor-fold>
  private void enumerateVFPtrs(/*const*/ CXXRecordDecl /*P*/ ForClass, final SmallVector<VPtrInfo /*P*/ > /*&*/ Result) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::computeVTableRelatedInformation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3571,
   FQN="clang::MicrosoftVTableContext::computeVTableRelatedInformation", NM="_ZN5clang22MicrosoftVTableContext31computeVTableRelatedInformationEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext31computeVTableRelatedInformationEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  @Override protected/*private*/ void computeVTableRelatedInformation(/*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    assert (RD.isDynamicClass());
    
    // Check if we've computed this information before.
    if ((VFPtrLocations.count(RD) != 0)) {
      return;
    }
    
    /*const*/DenseMapTypeULong<BaseSubobject> EmptyAddressPointsMap/*J*/= new DenseMapTypeULong<BaseSubobject>(DenseMapInfoBaseSubobject.$Info(), 0);
    
    SmallVector<VPtrInfo /*P*/ > /*P*/ VFPtrs = new SmallVector<VPtrInfo /*P*/ >(2, (VPtrInfo /*P*/ )null);
    computeVTablePaths(/*ForVBTables=*/ false, RD, $Deref(VFPtrs));
    VTableBuilderStatics.computeFullPathsForVFTables(Context, RD, $Deref(VFPtrs));
    VFPtrLocations.$set(RD, VFPtrs);
    
    DenseMap<GlobalDecl, MethodVFTableLocation> NewMethodLocations/*J*/= new DenseMap<GlobalDecl, MethodVFTableLocation>(DenseMapInfoGlobalDecl.$Info(), new MethodVFTableLocation());
    for (/*const*/ VPtrInfo /*P*/ VFPtr : $Deref(VFPtrs)) {
      VFTableBuilder Builder = null;
      try {
        Builder/*J*/= new VFTableBuilder(/*Deref*/this, RD, VFPtr);
        
        std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits> id/*J*/= new std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , CharUnits>(JD$T$RR_T1$C$R.INSTANCE, RD, VFPtr.FullOffsetInMDC);
        assert (VFTableLayouts.count(id) == 0);
        SmallVector<std.pairULongType<ThunkInfo>> VTableThunks/*J*/= new SmallVector<std.pairULongType<ThunkInfo>>(JD$T.INSTANCE, 1, Builder.vtable_thunks_begin(), Builder.vtable_thunks_end(), new std.pairULongType<ThunkInfo>(0, new ThunkInfo()));
        VFTableLayouts.$set(id, new VTableLayout(Builder.getNumVTableComponents(), Builder.vtable_component_begin(), 
            $uint2ulong(VTableThunks.size()), VTableThunks.data(), EmptyAddressPointsMap, true));
        Thunks.insert(Builder.thunks_begin(), Builder.thunks_end());
        
        for (final /*const*/std.pair<GlobalDecl, MethodVFTableLocation> /*&*/ Loc : Builder.vtable_locations()) {
          GlobalDecl GD = new GlobalDecl(Loc.first);
          MethodVFTableLocation NewLoc = new MethodVFTableLocation(Loc.second);
          DenseMapIterator<GlobalDecl, MethodVFTableLocation> M = NewMethodLocations.find(GD);
          if (M.$eq(/*NO_ITER_COPY*/NewMethodLocations.end()) || NewLoc.$less(M.$arrow().second)) {
            NewMethodLocations.$at_T1$C$R(GD).$assign(NewLoc);
          }
        }
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    }
    
    MethodVFTableLocations.insert(NewMethodLocations.begin(), 
        NewMethodLocations.end());
    if (Context.getLangOpts().DumpVTableLayouts) {
      dumpMethodLocations(RD, NewMethodLocations, llvm.outs());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::dumpMethodLocations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3614,
   FQN="clang::MicrosoftVTableContext::dumpMethodLocations", NM="_ZN5clang22MicrosoftVTableContext19dumpMethodLocationsEPKNS_13CXXRecordDeclERKN4llvm8DenseMapINS_10GlobalDeclENS0_21MethodVFTableLocationENS4_12DenseMapInfoIS6_EENS4_6detail12DenseMapPairIS6_S7_EEEERNS4_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext19dumpMethodLocationsEPKNS_13CXXRecordDeclERKN4llvm8DenseMapINS_10GlobalDeclENS0_21MethodVFTableLocationENS4_12DenseMapInfoIS6_EENS4_6detail12DenseMapPairIS6_S7_EEEERNS4_11raw_ostreamE")
  //</editor-fold>
  private void dumpMethodLocations(/*const*/ CXXRecordDecl /*P*/ RD, final /*const*/DenseMap<GlobalDecl, MethodVFTableLocation> /*&*/ NewMethods, 
                     final raw_ostream /*&*/ Out) {
    std.mapTypeType<MethodVFTableLocation, std.string> IndicesMap = null;
    try {
      // Compute the vtable indices for all the member functions.
      // Store them in a map keyed by the location so we'll get a sorted table.
      IndicesMap/*J*/= new std.mapTypeType<MethodVFTableLocation, std.string>(new std.string());
      boolean HasNonzeroOffset = false;
      
      for (final /*const*/std.pair<GlobalDecl, MethodVFTableLocation> /*&*/ I : NewMethods) {
        /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(I.first.getDecl());
        assert (MD.isVirtual());
        
        std.string MethodName = PredefinedExpr.ComputeName(PredefinedExpr.IdentType.PrettyFunctionNoVirtual, MD);
        if (isa_CXXDestructorDecl(MD)) {
          IndicesMap.$at_T$C$R(I.second).$assignMove($add_string$C_T$C$P(MethodName, /*KEEP_STR*/" [scalar deleting]"));
        } else {
          IndicesMap.$at_T$C$R(I.second).$assign(MethodName);
        }
        if (!I.second.VFPtrOffset.isZero() || I.second.VBTableIndex != $int2ullong(0)) {
          HasNonzeroOffset = true;
        }
      }
      
      // Print the vtable indices for all the member functions.
      if (!IndicesMap.empty()) {
        Out.$out(/*KEEP_STR*/"VFTable indices for ");
        Out.$out(/*KEEP_STR*/$SGL_QUOTE);
        RD.printQualifiedName(Out);
        Out.$out(/*KEEP_STR*/"' (").$out_uint(IndicesMap.size()).$out(
            (IndicesMap.size() == 1 ? $(" entry") : $(" entries"))
        ).$out(/*KEEP_STR*/").\n");
        
        CharUnits LastVFPtrOffset = CharUnits.fromQuantity(-1);
        long/*uint64_t*/ LastVBIndex = $int2ulong(0);
        for (final /*const*/ pair</*const*/ MethodVFTableLocation, std.string> /*&*/ I : IndicesMap) {
          CharUnits VFPtrOffset = new CharUnits(I.first.VFPtrOffset);
          long/*uint64_t*/ VBIndex = I.first.VBTableIndex;
          if (HasNonzeroOffset
             && (VFPtrOffset.$noteq(LastVFPtrOffset) || VBIndex != LastVBIndex)) {
            assert ($greater_ulong(VBIndex, LastVBIndex) || VFPtrOffset.$greater(LastVFPtrOffset));
            Out.$out(/*KEEP_STR*/" -- accessible via ");
            if ((VBIndex != 0)) {
              Out.$out(/*KEEP_STR*/"vbtable index ").$out_ullong(VBIndex).$out(/*KEEP_STR*/$COMMA_SPACE);
            }
            Out.$out(/*KEEP_STR*/"vfptr at offset ").$out_llong(VFPtrOffset.getQuantity()).$out(/*KEEP_STR*/" --\n");
            LastVFPtrOffset.$assign(VFPtrOffset);
            LastVBIndex = VBIndex;
          }
          
          long/*uint64_t*/ VTableIndex = I.first.Index;
          final /*const*/std.string/*&*/ MethodName = I.second;
          Out.$out(llvm.format($("%4llu | "), VTableIndex)).$out(MethodName).$out_char($$LF);
        }
        Out.$out_char($$LF);
      }
      
      Out.flush();
    } finally {
      if (IndicesMap != null) { IndicesMap.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::computeVBTableRelatedInformation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3673,
   FQN="clang::MicrosoftVTableContext::computeVBTableRelatedInformation", NM="_ZN5clang22MicrosoftVTableContext32computeVBTableRelatedInformationEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext32computeVBTableRelatedInformationEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  private /*const*/ VirtualBaseInfo /*P*/ computeVBTableRelatedInformation(/*const*/ CXXRecordDecl /*P*/ RD) {
    VirtualBaseInfo /*P*/ VBI;
    {
      // Get or create a VBI for RD.  Don't hold a reference to the DenseMap cell,
      // as it may be modified and rehashed under us.
      final type$ref<VirtualBaseInfo /*P*/ /*&*/> Entry = VBaseInfo.ref$at(RD);
      if ((Entry.$deref() != null)) {
        return Entry.$deref();
      }
      Entry.$set(VBI = new VirtualBaseInfo());
    }
    
    computeVTablePaths(/*ForVBTables=*/ true, RD, VBI.VBPtrPaths);
    
    // First, see if the Derived class shared the vbptr with a non-virtual base.
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    {
      /*const*/ CXXRecordDecl /*P*/ VBPtrBase = Layout.getBaseSharingVBPtr();
      if ((VBPtrBase != null)) {
        // If the Derived class shares the vbptr with a non-virtual base, the shared
        // virtual bases come first so that the layout is the same.
        /*const*/ VirtualBaseInfo /*P*/ BaseInfo = computeVBTableRelatedInformation(VBPtrBase);
        VBI.VBTableIndices.insert(BaseInfo.VBTableIndices.begin$Const(), 
            BaseInfo.VBTableIndices.end$Const());
      }
    }
    
    // New vbases are added to the end of the vbtable.
    // Skip the self entry and vbases visited in the non-virtual base, if any.
    /*uint*/int VBTableIndex = 1 + VBI.VBTableIndices.size();
    for (final /*const*/ CXXBaseSpecifier /*&*/ VB : RD.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ CurVBase = VB.getType().$arrow().getAsCXXRecordDecl();
      if (!(VBI.VBTableIndices.count(CurVBase) != 0)) {
        VBI.VBTableIndices.$set(CurVBase, VBTableIndex++);
      }
    }
    
    return VBI;
  }

  
  
  /// Produces MSVC-compatible vbtable data.  The symbols produced by this
  /// algorithm match those produced by MSVC 2012 and newer, which is different
  /// from MSVC 2010.
  ///
  /// MSVC 2012 appears to minimize the vbtable names using the following
  /// algorithm.  First, walk the class hierarchy in the usual order, depth first,
  /// left to right, to find all of the subobjects which contain a vbptr field.
  /// Visiting each class node yields a list of inheritance paths to vbptrs.  Each
  /// record with a vbptr creates an initially empty path.
  ///
  /// To combine paths from child nodes, the paths are compared to check for
  /// ambiguity.  Paths are "ambiguous" if multiple paths have the same set of
  /// components in the same order.  Each group of ambiguous paths is extended by
  /// appending the class of the base from which it came.  If the current class
  /// node produced an ambiguous path, its path is extended with the current class.
  /// After extending paths, MSVC again checks for ambiguity, and extends any
  /// ambiguous path which wasn't already extended.  Because each node yields an
  /// unambiguous set of paths, MSVC doesn't need to extend any path more than once
  /// to produce an unambiguous set of paths.
  ///
  /// TODO: Presumably vftables use the same algorithm.
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::computeVTablePaths">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3273,
   FQN="clang::MicrosoftVTableContext::computeVTablePaths", NM="_ZN5clang22MicrosoftVTableContext18computeVTablePathsEbPKNS_13CXXRecordDeclERN4llvm11SmallVectorIPNS_8VPtrInfoELj2EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext18computeVTablePathsEbPKNS_13CXXRecordDeclERN4llvm11SmallVectorIPNS_8VPtrInfoELj2EEE")
  //</editor-fold>
  private void computeVTablePaths(boolean ForVBTables, 
                    /*const*/ CXXRecordDecl /*P*/ RD, 
                    final SmallVector<VPtrInfo /*P*/ > /*&*/ Paths) {
    assert (Paths.empty());
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    
    // Base case: this subobject has its own vptr.
    if (ForVBTables ? Layout.hasOwnVBPtr() : Layout.hasOwnVFPtr()) {
      Paths.push_back(new VPtrInfo(RD));
    }
    
    // Recursive case: get all the vbtables from our bases and remove anything
    // that shares a virtual base.
    SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > VBasesSeen/*J*/= new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ Base = B.getType().$arrow().getAsCXXRecordDecl();
      if (B.isVirtual() && (VBasesSeen.count(Base) != 0)) {
        continue;
      }
      if (!Base.isDynamicClass()) {
        continue;
      }
      
      final /*const*/SmallVector<VPtrInfo /*P*/ > /*&*/ BasePaths = ForVBTables ? enumerateVBTables(Base) : getVFPtrOffsets(Base);
      
      for (VPtrInfo /*P*/ BaseInfo : BasePaths) {
        // Don't include the path if it goes through a virtual base that we've
        // already included.
        if (VTableBuilderStatics.setsIntersect(VBasesSeen, new ArrayRef</*const*/ CXXRecordDecl /*P*/ >(BaseInfo.ContainingVBases, true))) {
          continue;
        }
        
        // Copy the path and adjust it as necessary.
        VPtrInfo /*P*/ P = new VPtrInfo($Deref(BaseInfo));
        
        // We mangle Base into the path if the path would've been ambiguous and it
        // wasn't already extended with Base.
        if (P.MangledPath.empty() || P.MangledPath.back() != Base) {
          P.NextBaseToMangle = Base;
        }
        
        // Keep track of which vtable the derived class is going to extend with
        // new methods or bases.  We append to either the vftable of our primary
        // base, or the first non-virtual base that has a vbtable.
        if (P.ReusingBase == Base
           && Base == (ForVBTables ? Layout.getBaseSharingVBPtr() : Layout.getPrimaryBase())) {
          P.ReusingBase = RD;
        }
        
        // Keep track of the full adjustment from the MDC to this vtable.  The
        // adjustment is captured by an optional vbase and a non-virtual offset.
        if (B.isVirtual()) {
          P.ContainingVBases.push_back(Base);
        } else if (P.ContainingVBases.empty()) {
          P.NonVirtualOffset.$addassign(Layout.getBaseClassOffset(Base));
        }
        
        // Update the full offset in the MDC.
        P.FullOffsetInMDC.$assign(P.NonVirtualOffset);
        {
          /*const*/ CXXRecordDecl /*P*/ VB = P.getVBaseWithVPtr();
          if ((VB != null)) {
            P.FullOffsetInMDC.$addassign(Layout.getVBaseClassOffset(VB));
          }
        }
        
        Paths.push_back(P);
      }
      if (B.isVirtual()) {
        VBasesSeen.insert(Base);
      }
      
      // After visiting any direct base, we've transitively visited all of its
      // morally virtual bases.
      for (final /*const*/ CXXBaseSpecifier /*&*/ VB : Base.vbases$Const())  {
        VBasesSeen.insert(VB.getType().$arrow().getAsCXXRecordDecl());
      }
    }
    
    // Sort the paths into buckets, and if any of them are ambiguous, extend all
    // paths in ambiguous buckets.
    boolean Changed = true;
    while (Changed) {
      Changed = VTableBuilderStatics.rebucketPaths(Paths);
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::MicrosoftVTableContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 532,
   FQN="clang::MicrosoftVTableContext::MicrosoftVTableContext", NM="_ZN5clang22MicrosoftVTableContextC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContextC1ERNS_10ASTContextE")
  //</editor-fold>
  public MicrosoftVTableContext(final ASTContext /*&*/ Context) {
    // : VTableContextBase(/*MS=*/ true), Context(Context), MethodVFTableLocations(), VFPtrLocations(), VFTableLayouts(), VBaseInfo() 
    //START JInit
    super(true);
    this./*&*/Context=/*&*/Context;
    this.MethodVFTableLocations = new DenseMap<GlobalDecl, MethodVFTableLocation>(DenseMapInfoGlobalDecl.$Info(), new MethodVFTableLocation());
    this.VFPtrLocations = new DenseMap</*const*/ CXXRecordDecl /*P*/ , SmallVector<VPtrInfo /*P*/ > /*P*/>(DenseMapInfo$LikePtr.$Info(), (SmallVector<VPtrInfo /*P*/ > /*P*/)null);
    this.VFTableLayouts = new DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>, /*const*/ VTableLayout /*P*/ >(new DenseMapInfoPair</*const*/ CXXRecordDecl /*P*/ , CharUnits>(DenseMapInfo$LikePtr.$Info(), DenseMapInfoCharUnits.$Info()), (/*const*/ VTableLayout /*P*/ )null);
    this.VBaseInfo = new DenseMap</*const*/ CXXRecordDecl /*P*/ , VirtualBaseInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), (VirtualBaseInfo /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::~MicrosoftVTableContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3390,
   FQN="clang::MicrosoftVTableContext::~MicrosoftVTableContext", NM="_ZN5clang22MicrosoftVTableContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContextD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    for (final std.pair</*const*/ CXXRecordDecl /*P*/ , SmallVector<VPtrInfo /*P*/ > /*P*/> /*&*/ P : VFPtrLocations)  {
      llvm.DeleteContainerPointers($Deref(P.second));
    }
    llvm.DeleteContainerSeconds(VFPtrLocations);
    llvm.DeleteContainerSeconds(VFTableLayouts);
    llvm.DeleteContainerSeconds(VBaseInfo);
    //START JDestroy
    VBaseInfo.$destroy();
    VFTableLayouts.$destroy();
    VFPtrLocations.$destroy();
    MethodVFTableLocations.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::getVFPtrOffsets">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3723,
   FQN="clang::MicrosoftVTableContext::getVFPtrOffsets", NM="_ZN5clang22MicrosoftVTableContext15getVFPtrOffsetsEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext15getVFPtrOffsetsEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*const*/SmallVector<VPtrInfo /*P*/ > /*&*/ getVFPtrOffsets(/*const*/ CXXRecordDecl /*P*/ RD) {
    computeVTableRelatedInformation(RD);
    assert ((VFPtrLocations.count(RD) != 0)) : "Couldn't find vfptr locations";
    return $Deref(VFPtrLocations.$at_T1$C$R(RD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::getVFTableLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3731,
   FQN="clang::MicrosoftVTableContext::getVFTableLayout", NM="_ZN5clang22MicrosoftVTableContext16getVFTableLayoutEPKNS_13CXXRecordDeclENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext16getVFTableLayoutEPKNS_13CXXRecordDeclENS_9CharUnitsE")
  //</editor-fold>
  public /*const*/ VTableLayout /*&*/ getVFTableLayout(/*const*/ CXXRecordDecl /*P*/ RD, 
                  CharUnits VFPtrOffset) {
    computeVTableRelatedInformation(RD);
    
    std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits> id/*J*/= new std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , CharUnits>(JD$T$RR_T1$RR.INSTANCE, RD, VFPtrOffset);
    assert ((VFTableLayouts.count(id) != 0)) : "Couldn't find a VFTable at this offset";
    return $Deref(VFTableLayouts.$at_T1$C$R(id));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::getMethodVFTableLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3741,
   FQN="clang::MicrosoftVTableContext::getMethodVFTableLocation", NM="_ZN5clang22MicrosoftVTableContext24getMethodVFTableLocationENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext24getMethodVFTableLocationENS_10GlobalDeclE")
  //</editor-fold>
  public /*const*/ MicrosoftVTableContext.MethodVFTableLocation /*&*/ getMethodVFTableLocation(GlobalDecl GD) {
    assert (cast_CXXMethodDecl(GD.getDecl()).isVirtual()) : "Only use this method for virtual methods or dtors";
    if (isa_CXXDestructorDecl(GD.getDecl())) {
      assert (GD.getDtorType() == CXXDtorType.Dtor_Deleting);
    }
    
    DenseMapIterator<GlobalDecl, MethodVFTableLocation> I = MethodVFTableLocations.find(GD);
    if (I.$noteq(/*NO_ITER_COPY*/MethodVFTableLocations.end())) {
      return I.$arrow().second;
    }
    
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXMethodDecl(GD.getDecl()).getParent$Const();
    
    computeVTableRelatedInformation(RD);
    
    I.$assignMove(MethodVFTableLocations.find(GD));
    assert (I.$noteq(/*NO_ITER_COPY*/MethodVFTableLocations.end())) : "Did not find index!";
    return I.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::getThunkInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 544,
   FQN="clang::MicrosoftVTableContext::getThunkInfo", NM="_ZN5clang22MicrosoftVTableContext12getThunkInfoENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext12getThunkInfoENS_10GlobalDeclE")
  //</editor-fold>
  @Override public /*const*/SmallVector<ThunkInfo> /*P*/ getThunkInfo(GlobalDecl GD)/* override*/ {
    // Complete destructors don't have a slot in a vftable, so no thunks needed.
    if (isa_CXXDestructorDecl(GD.getDecl())
       && GD.getDtorType() == CXXDtorType.Dtor_Complete) {
      return null;
    }
    return super.getThunkInfo(new GlobalDecl(GD));
  }

  
  /// \brief Returns the index of VBase in the vbtable of Derived.
  /// VBase must be a morally virtual base of Derived.
  /// The vbtable is an array of i32 offsets.  The first entry is a self entry,
  /// and the rest are offsets from the vbptr to virtual bases.
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::getVBTableIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3711,
   FQN="clang::MicrosoftVTableContext::getVBTableIndex", NM="_ZN5clang22MicrosoftVTableContext15getVBTableIndexEPKNS_13CXXRecordDeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext15getVBTableIndexEPKNS_13CXXRecordDeclES3_")
  //</editor-fold>
  public /*uint*/int getVBTableIndex(/*const*/ CXXRecordDecl /*P*/ Derived, 
                 /*const*/ CXXRecordDecl /*P*/ VBase) {
    /*const*/ VirtualBaseInfo /*P*/ VBInfo = computeVBTableRelatedInformation(Derived);
    assert Native.$bool(VBInfo.VBTableIndices.count(VBase));
    return VBInfo.VBTableIndices.find$Const(VBase).$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::enumerateVBTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3718,
   FQN="clang::MicrosoftVTableContext::enumerateVBTables", NM="_ZN5clang22MicrosoftVTableContext17enumerateVBTablesEPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext17enumerateVBTablesEPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public /*const*/SmallVector<VPtrInfo /*P*/ > /*&*/ enumerateVBTables(/*const*/ CXXRecordDecl /*P*/ RD) {
    return computeVBTableRelatedInformation(RD).VBPtrPaths;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftVTableContext::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 561,
   FQN="clang::MicrosoftVTableContext::classof", NM="_ZN5clang22MicrosoftVTableContext7classofEPKNS_17VTableContextBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang22MicrosoftVTableContext7classofEPKNS_17VTableContextBaseE")
  //</editor-fold>
  public static boolean classof(/*const*/ VTableContextBase /*P*/ VT) {
    return VT.isMicrosoft();
  }


  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", MethodVFTableLocations=" + MethodVFTableLocations // NOI18N
              + ", VFPtrLocations=" + VFPtrLocations // NOI18N
              + ", VFTableLayouts=" + VFTableLayouts // NOI18N
              + ", VBaseInfo=" + VBaseInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
