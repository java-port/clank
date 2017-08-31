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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import org.clang.ast.ASTRecordLayout.VBaseInfo;
import static org.clang.ast.java.AstFunctionPointers.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.VTableBuilderStatics.*;


// Vtables in the Microsoft ABI are different from the Itanium ABI.
//
// The main differences are:
//  1. Separate vftable and vbtable.
//
//  2. Each subobject with a vfptr gets its own vftable rather than an address
//     point in a single vtable shared between all the subobjects.
//     Each vftable is represented by a separate section and virtual calls
//     must be done using the vftable which has a slot for the function to be
//     called.
//
//  3. Virtual method definitions expect their 'this' parameter to point to the
//     first vfptr whose table provides a compatible overridden method.  In many
//     cases, this permits the original vf-table entry to directly call
//     the method instead of passing through a thunk.
//     See example before VFTableBuilder::ComputeThisOffset below.
//
//     A compatible overridden method is one which does not have a non-trivial
//     covariant-return adjustment.
//
//     The first vfptr is the one with the lowest offset in the complete-object
//     layout of the defining class, and the method definition will subtract
//     that constant offset from the parameter value to get the real 'this'
//     value.  Therefore, if the offset isn't really constant (e.g. if a virtual
//     function defined in a virtual base is overridden in a more derived
//     virtual base and these bases have a reverse order in the complete
//     object), the vf-table may require a this-adjustment thunk.
//
//  4. vftables do not contain new entries for overrides that merely require
//     this-adjustment.  Together with #3, this keeps vf-tables smaller and
//     eliminates the need for this-adjustment thunks in many cases, at the cost
//     of often requiring redundant work to adjust the "this" pointer.
//
//  5. Instead of VTT and constructor vtables, vbtables and vtordisps are used.
//     Vtordisps are emitted into the class layout if a class has
//      a) a user-defined ctor/dtor
//     and
//      b) a method overriding a method in a virtual base.
//
//  To get a better understanding of this code,
//  you might want to see examples in test/CodeGenCXX/microsoft-abi-vtables-*.cpp
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2385,
 FQN="(anonymous namespace)::VFTableBuilder", NM="_ZN12_GLOBAL__N_114VFTableBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilderE")
//</editor-fold>
public class VFTableBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef MicrosoftVTableContext::MethodVFTableLocation MethodVFTableLocation*/
//  public final class MethodVFTableLocation extends MicrosoftVTableContext.MethodVFTableLocation{ };
  
  /*typedef llvm::DenseMap<GlobalDecl, MethodVFTableLocation> MethodVFTableLocationsTy*/
//  public final class MethodVFTableLocationsTy extends DenseMap<GlobalDecl, MicrosoftVTableContext.MethodVFTableLocation>{ };
  
  /*typedef llvm::iterator_range<MethodVFTableLocationsTy::const_iterator> method_locations_range*/
//  public final class method_locations_range extends iterator_range</*constconst*/std.pair<GlobalDecl, MethodVFTableLocation> /*&*/>{ };
/*private:*/
  /// VTables - Global vtable information.
  private final MicrosoftVTableContext /*&*/ VTables;
  
  /// Context - The ASTContext which we will use for layout information.
  private final ASTContext /*&*/ Context;
  
  /// MostDerivedClass - The most derived class for which we're building this
  /// vtable.
  private /*const*/ CXXRecordDecl /*P*/ MostDerivedClass;
  
  private final /*const*/ ASTRecordLayout /*&*/ MostDerivedClassLayout;
  
  private final /*const*/ VPtrInfo /*&*/ WhichVFPtr;
  
  /// FinalOverriders - The final overriders of the most derived class.
  private /*const*/ FinalOverriders Overriders;
  
  /// Components - The components of the vftable being built.
  private SmallVector<VTableComponent> Components;
  
  private DenseMap<GlobalDecl, MicrosoftVTableContext.MethodVFTableLocation> MethodVFTableLocations;
  
  /// \brief Does this class have an RTTI component?
  private boolean HasRTTIComponent/* = false*/;
  
  /// MethodInfo - Contains information about a method in a vtable.
  /// (Used for computing 'this' pointer adjustment thunks.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::MethodInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2423,
   FQN="(anonymous namespace)::VFTableBuilder::MethodInfo", NM="_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoE")
  //</editor-fold>
  private static class/*struct*/ MethodInfo {
    /// VBTableIndex - The nonzero index in the vbtable that
    /// this method's base has, or zero.
    public /*const*/long/*uint64_t*/ VBTableIndex;
    
    /// VFTableIndex - The index in the vftable that this method has.
    public /*const*/long/*uint64_t*/ VFTableIndex;
    
    /// Shadowed - Indicates if this vftable slot is shadowed by
    /// a slot for a covariant-return override. If so, it shouldn't be printed
    /// or used for vcalls in the most derived class.
    public boolean Shadowed;
    
    /// UsesExtraSlot - Indicates if this vftable slot was created because
    /// any of the overridden slots required a return adjusting thunk.
    public boolean UsesExtraSlot;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::MethodInfo::MethodInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2440,
     FQN="(anonymous namespace)::VFTableBuilder::MethodInfo::MethodInfo", NM="_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoC1Eyyb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoC1Eyyb")
    //</editor-fold>
    public MethodInfo(long/*uint64_t*/ VBTableIndex, long/*uint64_t*/ VFTableIndex) {
      this(VBTableIndex, VFTableIndex, 
        false);
    }
    public MethodInfo(long/*uint64_t*/ VBTableIndex, long/*uint64_t*/ VFTableIndex, 
        boolean UsesExtraSlot/*= false*/) {
      // : VBTableIndex(VBTableIndex), VFTableIndex(VFTableIndex), Shadowed(false), UsesExtraSlot(UsesExtraSlot) 
      //START JInit
      this.VBTableIndex = VBTableIndex;
      this.VFTableIndex = VFTableIndex;
      this.Shadowed = false;
      this.UsesExtraSlot = UsesExtraSlot;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::MethodInfo::MethodInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2445,
     FQN="(anonymous namespace)::VFTableBuilder::MethodInfo::MethodInfo", NM="_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoC1Ev")
    //</editor-fold>
    public MethodInfo() {
      // : VBTableIndex(0), VFTableIndex(0), Shadowed(false), UsesExtraSlot(false) 
      //START JInit
      this.VBTableIndex = $int2ulong(0);
      this.VFTableIndex = $int2ulong(0);
      this.Shadowed = false;
      this.UsesExtraSlot = false;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::MethodInfo::MethodInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2423,
     FQN="(anonymous namespace)::VFTableBuilder::MethodInfo::MethodInfo", NM="_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ MethodInfo(final /*const*/ MethodInfo /*&*/ $Prm0) {
      // : VBTableIndex(.VBTableIndex), VFTableIndex(.VFTableIndex), Shadowed(.Shadowed), UsesExtraSlot(.UsesExtraSlot) 
      //START JInit
      this.VBTableIndex = $Prm0.VBTableIndex;
      this.VFTableIndex = $Prm0.VFTableIndex;
      this.Shadowed = $Prm0.Shadowed;
      this.UsesExtraSlot = $Prm0.UsesExtraSlot;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::MethodInfo::MethodInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2423,
     FQN="(anonymous namespace)::VFTableBuilder::MethodInfo::MethodInfo", NM="_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder10MethodInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ MethodInfo(JD$Move _dparam, final MethodInfo /*&&*/$Prm0) {
      // : VBTableIndex(static_cast<MethodInfo &&>().VBTableIndex), VFTableIndex(static_cast<MethodInfo &&>().VFTableIndex), Shadowed(static_cast<MethodInfo &&>().Shadowed), UsesExtraSlot(static_cast<MethodInfo &&>().UsesExtraSlot) 
      //START JInit
      this.VBTableIndex = $Prm0.VBTableIndex;
      this.VFTableIndex = $Prm0.VFTableIndex;
      this.Shadowed = $Prm0.Shadowed;
      this.UsesExtraSlot = $Prm0.UsesExtraSlot;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "VBTableIndex=" + VBTableIndex // NOI18N
                + ", VFTableIndex=" + VFTableIndex // NOI18N
                + ", Shadowed=" + Shadowed // NOI18N
                + ", UsesExtraSlot=" + UsesExtraSlot; // NOI18N
    }
  };
  
  /*typedef llvm::DenseMap<const CXXMethodDecl *, MethodInfo> MethodInfoMapTy*/
//  public final class MethodInfoMapTy extends DenseMap</*const*/ CXXMethodDecl /*P*/ , MethodInfo>{ };
  
  /// MethodInfoMap - The information for all methods in the vftable we're
  /// currently building.
  private DenseMap</*const*/ CXXMethodDecl /*P*/ , MethodInfo> MethodInfoMap;
  
  /*typedef llvm::DenseMap<uint64_t, ThunkInfo> VTableThunksMapTy*/
//  public final class VTableThunksMapTy extends DenseMapULongType<ThunkInfo>{ };
  
  /// VTableThunks - The thunks by vftable index in the vftable currently being
  /// built.
  private DenseMapULongType<ThunkInfo> VTableThunks;
  
  /*typedef SmallVector<ThunkInfo, 1> ThunkInfoVectorTy*/
//  public final class ThunkInfoVectorTy extends SmallVector<ThunkInfo>{ };
  /*typedef llvm::DenseMap<const CXXMethodDecl *, ThunkInfoVectorTy> ThunksMapTy*/
//  public final class ThunksMapTy extends DenseMap</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>>{ };
  
  /// Thunks - A map that contains all the thunks needed for all methods in the
  /// most derived class for which the vftable is currently being built.
  private DenseMap</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>> Thunks;
  
  /// AddThunk - Add a thunk for the given method.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::AddThunk">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2470,
   FQN="(anonymous namespace)::VFTableBuilder::AddThunk", NM="_ZN12_GLOBAL__N_114VFTableBuilder8AddThunkEPKN5clang13CXXMethodDeclERKNS1_9ThunkInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder8AddThunkEPKN5clang13CXXMethodDeclERKNS1_9ThunkInfoE")
  //</editor-fold>
  private void AddThunk(/*const*/ CXXMethodDecl /*P*/ MD, final /*const*/ ThunkInfo /*&*/ Thunk) {
    final SmallVector<ThunkInfo> /*&*/ ThunksVector = Thunks.$at_T1$C$R(MD);
    
    // Check if we have this thunk already.
    if (std.find(ThunksVector.begin(), ThunksVector.end(), Thunk)
       .$noteq(ThunksVector.end())) {
      return;
    }
    
    ThunksVector.push_back(Thunk);
  }

  
  /// ComputeThisOffset - Returns the 'this' argument offset for the given
  /// method, relative to the beginning of the MostDerivedClass.
  // end namespace
  
  // Let's study one class hierarchy as an example:
  //   struct A {
  //     virtual void f();
  //     int x;
  //   };
  //
  //   struct B : virtual A {
  //     virtual void f();
  //   };
  //
  // Record layouts:
  //   struct A:
  //   0 |   (A vftable pointer)
  //   4 |   int x
  //
  //   struct B:
  //   0 |   (B vbtable pointer)
  //   4 |   struct A (virtual base)
  //   4 |     (A vftable pointer)
  //   8 |     int x
  //
  // Let's assume we have a pointer to the A part of an object of dynamic type B:
  //   B b;
  //   A *a = (A*)&b;
  //   a->f();
  //
  // In this hierarchy, f() belongs to the vftable of A, so B::f() expects
  // "this" parameter to point at the A subobject, which is B+4.
  // In the B::f() prologue, it adjusts "this" back to B by subtracting 4,
  // performed as a *static* adjustment.
  //
  // Interesting thing happens when we alter the relative placement of A and B
  // subobjects in a class:
  //   struct C : virtual B { };
  //
  //   C c;
  //   A *a = (A*)&c;
  //   a->f();
  //
  // Respective record layout is:
  //   0 |   (C vbtable pointer)
  //   4 |   struct A (virtual base)
  //   4 |     (A vftable pointer)
  //   8 |     int x
  //  12 |   struct B (virtual base)
  //  12 |     (B vbtable pointer)
  //
  // The final overrider of f() in class C is still B::f(), so B+4 should be
  // passed as "this" to that code.  However, "a" points at B-8, so the respective
  // vftable entry should hold a thunk that adds 12 to the "this" argument before
  // performing a tail call to B::f().
  //
  // With this example in mind, we can now calculate the 'this' argument offset
  // for the given method, relative to the beginning of the MostDerivedClass.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::ComputeThisOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2650,
   FQN="(anonymous namespace)::VFTableBuilder::ComputeThisOffset", NM="_ZN12_GLOBAL__N_114VFTableBuilder17ComputeThisOffsetENS_15FinalOverriders13OverriderInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder17ComputeThisOffsetENS_15FinalOverriders13OverriderInfoE")
  //</editor-fold>
  private CharUnits ComputeThisOffset(FinalOverriders.OverriderInfo Overrider) {
    CXXBasePaths Paths = null;
    try {
      SmallSetVector</*const*/ CXXRecordDecl /*P*/ > Bases/*J*/= new SmallSetVector</*const*/ CXXRecordDecl /*P*/ >(8, (/*const*/ CXXRecordDecl /*P*/ ) null);
      {
        // Find the set of least derived bases that define the given method.
        SmallPtrSet</*const*/ CXXMethodDecl /*P*/ > VisitedOverriddenMethods/*J*/= new SmallPtrSet</*const*/ CXXMethodDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
        CXXMethodDecl2Bool InitialOverriddenDefinitionCollector = /*[&, &Bases, &VisitedOverriddenMethods]*/ (/*const*/ CXXMethodDecl /*P*/ OverriddenMD) -> {
              if (OverriddenMD.size_overridden_methods() == 0) {
                Bases.insert(OverriddenMD.getParent$Const());
              }
              // Don't recurse on this method if we've already collected it.
              return VisitedOverriddenMethods.insert(OverriddenMD).second;
            };
        visitAllOverriddenMethods(Overrider.Method, 
            InitialOverriddenDefinitionCollector);
      }
      
      // If there are no overrides then 'this' is located
      // in the base that defines the method.
      if (Bases.size() == 0) {
        return new CharUnits(Overrider.Offset);
      }
      
      Paths/*J*/= new CXXBasePaths();
      Overrider.Method.getParent$Const().lookupInBases(/*FuncArg*//*[&Bases]*/ (/*const*/ CXXBaseSpecifier /*P*/ Specifier, final CXXBasePath /*&*/ $Prm1) -> {
                return Bases.count(Specifier.getType().$arrow().getAsCXXRecordDecl()) != 0;
              }, 
          Paths);
      
      // This will hold the smallest this offset among overridees of MD.
      // This implies that an offset of a non-virtual base will dominate an offset
      // of a virtual base to potentially reduce the number of thunks required
      // in the derived classes that inherit this method.
      CharUnits Ret/*J*/= new CharUnits();
      boolean First = true;
      
      final /*const*/ ASTRecordLayout /*&*/ OverriderRDLayout = Context.getASTRecordLayout(Overrider.Method.getParent$Const());
      for (final /*const*/ CXXBasePath /*&*/ Path : Paths) {
        CharUnits ThisOffset = new CharUnits(Overrider.Offset);
        CharUnits LastVBaseOffset/*J*/= new CharUnits();
        
        // For each path from the overrider to the parents of the overridden
        // methods, traverse the path, calculating the this offset in the most
        // derived class.
        for (final /*const*/ CXXBasePathElement /*&*/ Element : Path) {
          QualType CurTy = Element.Base.getType();
          /*const*/ CXXRecordDecl /*P*/ PrevRD = Element.Class;
          /*const*/ CXXRecordDecl /*P*/ CurRD = CurTy.$arrow().getAsCXXRecordDecl();
          final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(PrevRD);
          if (Element.Base.isVirtual()) {
            // The interesting things begin when you have virtual inheritance.
            // The final overrider will use a static adjustment equal to the offset
            // of the vbase in the final overrider class.
            // For example, if the final overrider is in a vbase B of the most
            // derived class and it overrides a method of the B's own vbase A,
            // it uses A* as "this".  In its prologue, it can cast A* to B* with
            // a static offset.  This offset is used regardless of the actual
            // offset of A from B in the most derived class, requiring an
            // this-adjusting thunk in the vftable if A and B are laid out
            // differently in the most derived class.
            LastVBaseOffset.$assign(ThisOffset.$assignMove(
                    Overrider.Offset.$add(OverriderRDLayout.getVBaseClassOffset(CurRD))
                ));
          } else {
            ThisOffset.$addassign(Layout.getBaseClassOffset(CurRD));
          }
        }
        if (isa_CXXDestructorDecl(Overrider.Method)) {
          if (LastVBaseOffset.isZero()) {
            // If a "Base" class has at least one non-virtual base with a virtual
            // destructor, the "Base" virtual destructor will take the address
            // of the "Base" subobject as the "this" argument.
            ThisOffset.$assign(Overrider.Offset);
          } else {
            // A virtual destructor of a virtual base takes the address of the
            // virtual base subobject as the "this" argument.
            ThisOffset.$assign(LastVBaseOffset);
          }
        }
        if (Ret.$greater(ThisOffset) || First) {
          First = false;
          Ret.$assign(ThisOffset);
        }
      }
      assert (!First) : "Method not found in the given subobject?";
      return Ret;
    } finally {
      if (Paths != null) { Paths.$destroy(); }
    }
  }

  
  
  // Things are getting even more complex when the "this" adjustment has to
  // use a dynamic offset instead of a static one, or even two dynamic offsets.
  // This is sometimes required when a virtual call happens in the middle of
  // a non-most-derived class construction or destruction.
  //
  // Let's take a look at the following example:
  //   struct A {
  //     virtual void f();
  //   };
  //
  //   void foo(A *a) { a->f(); }  // Knows nothing about siblings of A.
  //
  //   struct B : virtual A {
  //     virtual void f();
  //     B() {
  //       foo(this);
  //     }
  //   };
  //
  //   struct C : virtual B {
  //     virtual void f();
  //   };
  //
  // Record layouts for these classes are:
  //   struct A
  //   0 |   (A vftable pointer)
  //
  //   struct B
  //   0 |   (B vbtable pointer)
  //   4 |   (vtordisp for vbase A)
  //   8 |   struct A (virtual base)
  //   8 |     (A vftable pointer)
  //
  //   struct C
  //   0 |   (C vbtable pointer)
  //   4 |   (vtordisp for vbase A)
  //   8 |   struct A (virtual base)  // A precedes B!
  //   8 |     (A vftable pointer)
  //  12 |   struct B (virtual base)
  //  12 |     (B vbtable pointer)
  //
  // When one creates an object of type C, the C constructor:
  // - initializes all the vbptrs, then
  // - calls the A subobject constructor
  //   (initializes A's vfptr with an address of A vftable), then
  // - calls the B subobject constructor
  //   (initializes A's vfptr with an address of B vftable and vtordisp for A),
  //   that in turn calls foo(), then
  // - initializes A's vfptr with an address of C vftable and zeroes out the
  //   vtordisp
  //   FIXME: if a structor knows it belongs to MDC, why doesn't it use a vftable
  //   without vtordisp thunks?
  //   FIXME: how are vtordisp handled in the presence of nooverride/final?
  //
  // When foo() is called, an object with a layout of class C has a vftable
  // referencing B::f() that assumes a B layout, so the "this" adjustments are
  // incorrect, unless an extra adjustment is done.  This adjustment is called
  // "vtordisp adjustment".  Vtordisp basically holds the difference between the
  // actual location of a vbase in the layout class and the location assumed by
  // the vftable of the class being constructed/destructed.  Vtordisp is only
  // needed if "this" escapes a
  // structor (or we can't prove otherwise).
  // [i.e. vtordisp is a dynamic adjustment for a static adjustment, which is an
  // estimation of a dynamic adjustment]
  //
  // foo() gets a pointer to the A vbase and doesn't know anything about B or C,
  // so it just passes that pointer as "this" in a virtual call.
  // If there was no vtordisp, that would just dispatch to B::f().
  // However, B::f() assumes B+8 is passed as "this",
  // yet the pointer foo() passes along is B-4 (i.e. C+8).
  // An extra adjustment is needed, so we emit a thunk into the B vftable.
  // This vtordisp thunk subtracts the value of vtordisp
  // from the "this" argument (-12) before making a tailcall to B::f().
  //
  // Let's consider an even more complex example:
  //   struct D : virtual B, virtual C {
  //     D() {
  //       foo(this);
  //     }
  //   };
  //
  //   struct D
  //   0 |   (D vbtable pointer)
  //   4 |   (vtordisp for vbase A)
  //   8 |   struct A (virtual base)  // A precedes both B and C!
  //   8 |     (A vftable pointer)
  //  12 |   struct B (virtual base)  // B precedes C!
  //  12 |     (B vbtable pointer)
  //  16 |   struct C (virtual base)
  //  16 |     (C vbtable pointer)
  //
  // When D::D() calls foo(), we find ourselves in a thunk that should tailcall
  // to C::f(), which assumes C+8 as its "this" parameter.  This time, foo()
  // passes along A, which is C-8.  The A vtordisp holds
  //   "D.vbptr[index_of_A] - offset_of_A_in_D"
  // and we statically know offset_of_A_in_D, so can get a pointer to D.
  // When we know it, we can make an extra vbtable lookup to locate the C vbase
  // and one extra static adjustment to calculate the expected value of C+8.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::CalculateVtordispAdjustment">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2841,
   FQN="(anonymous namespace)::VFTableBuilder::CalculateVtordispAdjustment", NM="_ZN12_GLOBAL__N_114VFTableBuilder27CalculateVtordispAdjustmentENS_15FinalOverriders13OverriderInfoEN5clang9CharUnitsERNS3_14ThisAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder27CalculateVtordispAdjustmentENS_15FinalOverriders13OverriderInfoEN5clang9CharUnitsERNS3_14ThisAdjustmentE")
  //</editor-fold>
  private void CalculateVtordispAdjustment(FinalOverriders.OverriderInfo Overrider, CharUnits ThisOffset, 
                             final ThisAdjustment /*&*/ TA) {
    final /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , VBaseInfo> /*&*/ VBaseMap = MostDerivedClassLayout.getVBaseOffsetsMap();
    final /*const*/DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , VBaseInfo> /*&*/ VBaseMapEntry = VBaseMap.find$Const(WhichVFPtr.getVBaseWithVPtr());
    assert (VBaseMapEntry.$noteq(VBaseMap.end$Const()));
    
    // If there's no vtordisp or the final overrider is defined in the same vbase
    // as the initial declaration, we don't need any vtordisp adjustment.
    if (!VBaseMapEntry.$arrow().second.hasVtorDisp()
       || Overrider.VirtualBase == WhichVFPtr.getVBaseWithVPtr()) {
      return;
    }
    
    // OK, now we know we need to use a vtordisp thunk.
    // The implicit vtordisp field is located right before the vbase.
    CharUnits OffsetOfVBaseWithVFPtr = new CharUnits(VBaseMapEntry.$arrow().second.VBaseOffset);
    TA.Virtual.Microsoft.VtordispOffset
       = (int) (OffsetOfVBaseWithVFPtr.$sub(WhichVFPtr.FullOffsetInMDC)).getQuantity() - 4;
    
    // A simple vtordisp thunk will suffice if the final overrider is defined
    // in either the most derived class or its non-virtual base.
    if (Overrider.Method.getParent$Const() == MostDerivedClass
       || !(Overrider.VirtualBase != null)) {
      return;
    }
    
    // Otherwise, we need to do use the dynamic offset of the final overrider
    // in order to get "this" adjustment right.
    TA.Virtual.Microsoft.VBPtrOffset
       = (int) (OffsetOfVBaseWithVFPtr.$add(WhichVFPtr.NonVirtualOffset).$sub(
        MostDerivedClassLayout.getVBPtrOffset()
    )).getQuantity();
    TA.Virtual.Microsoft.VBOffsetOffset
       = (int) (Context.getTypeSizeInChars(Context.IntTy.$QualType()).getQuantity()
       * $uint2llong(VTables.getVBTableIndex(MostDerivedClass, Overrider.VirtualBase)));
    
    TA.NonVirtual = (ThisOffset.$sub(Overrider.Offset)).getQuantity();
  }

  
  /// AddMethod - Add a single virtual member function to the vftable
  /// components vector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::AddMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2490,
   FQN="(anonymous namespace)::VFTableBuilder::AddMethod", NM="_ZN12_GLOBAL__N_114VFTableBuilder9AddMethodEPKN5clang13CXXMethodDeclENS1_9ThunkInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder9AddMethodEPKN5clang13CXXMethodDeclENS1_9ThunkInfoE")
  //</editor-fold>
  private void AddMethod(/*const*/ CXXMethodDecl /*P*/ MD, ThunkInfo TI) {
    if (!TI.isEmpty()) {
      VTableThunks.$at_T1$RR($uint2ullong(Components.size())).$assign(TI);
      AddThunk(MD, TI);
    }
    {
      /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
      if ((DD != null)) {
        assert (TI.Return.isEmpty()) : "Destructor can't have return adjustment!";
        Components.push_back(VTableComponent.MakeDeletingDtor(DD));
      } else {
        Components.push_back(VTableComponent.MakeFunction(MD));
      }
    }
  }

  
  /// AddMethods - Add the methods of this base subobject and the relevant
  /// subbases to the vftable we're currently laying out.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::AddMethods">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2920,
   FQN="(anonymous namespace)::VFTableBuilder::AddMethods", NM="_ZN12_GLOBAL__N_114VFTableBuilder10AddMethodsEN5clang13BaseSubobjectEjPKNS1_13CXXRecordDeclERN4llvm14SmallSetVectorIS5_Lj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder10AddMethodsEN5clang13BaseSubobjectEjPKNS1_13CXXRecordDeclERN4llvm14SmallSetVectorIS5_Lj8EEE")
  //</editor-fold>
  private void AddMethods(BaseSubobject Base, /*uint*/int BaseDepth, 
            /*const*/ CXXRecordDecl /*P*/ LastVBase, 
            final SmallSetVector</*const*/ CXXRecordDecl /*P*/ > /*&*/ VisitedBases) {
    /*const*/ CXXRecordDecl /*P*/ RD = Base.getBase();
    if (!RD.isPolymorphic()) {
      return;
    }
    
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    
    // See if this class expands a vftable of the base we look at, which is either
    // the one defined by the vfptr base path or the primary base of the current
    // class.
    /*const*/ CXXRecordDecl /*P*/ NextBase = null;
    /*const*/ CXXRecordDecl /*P*/ NextLastVBase = LastVBase;
    CharUnits NextBaseOffset/*J*/= new CharUnits();
    if ($less_uint(BaseDepth, WhichVFPtr.PathToBaseWithVPtr.size())) {
      NextBase = WhichVFPtr.PathToBaseWithVPtr.$at$Const(BaseDepth);
      if (isDirectVBase(NextBase, RD)) {
        NextLastVBase = NextBase;
        NextBaseOffset.$assignMove(MostDerivedClassLayout.getVBaseClassOffset(NextBase));
      } else {
        NextBaseOffset.$assignMove(
            Base.getBaseOffset().$add(Layout.getBaseClassOffset(NextBase))
        );
      }
    } else {
      /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
      if ((PrimaryBase != null)) {
        assert (!Layout.isPrimaryBaseVirtual()) : "No primary virtual bases in this ABI";
        NextBase = PrimaryBase;
        NextBaseOffset.$assignMove(Base.getBaseOffset());
      }
    }
    if ((NextBase != null)) {
      AddMethods(new BaseSubobject(NextBase, new CharUnits(NextBaseOffset)), BaseDepth + 1, 
          NextLastVBase, VisitedBases);
      if (!VisitedBases.insert(NextBase)) {
        throw new llvm_unreachable("Found a duplicate primary base!");
      }
    }
    
    SmallVector</*const*/ CXXMethodDecl /*P*/ > VirtualMethods/*J*/= new SmallVector</*const*/ CXXMethodDecl /*P*/ >(10, (/*const*/ CXXMethodDecl /*P*/ )null);
    // Put virtual methods in the proper order.
    GroupNewVirtualOverloads(RD, VirtualMethods);
    
    // Now go through all virtual member functions and add them to the current
    // vftable. This is done by
    //  - replacing overridden methods in their existing slots, as long as they
    //    don't require return adjustment; calculating This adjustment if needed.
    //  - adding new slots for methods of the current base not present in any
    //    sub-bases;
    //  - adding new slots for methods that require Return adjustment.
    // We keep track of the methods visited in the sub-bases in MethodInfoMap.
    for (/*const*/ CXXMethodDecl /*P*/ MD : VirtualMethods) {
      FinalOverriders.OverriderInfo FinalOverrider = Overriders.getOverrider(MD, Base.getBaseOffset());
      /*const*/ CXXMethodDecl /*P*/ FinalOverriderMD = FinalOverrider.Method;
      /*const*/ CXXMethodDecl /*P*/ OverriddenMD = FindNearestOverriddenMethod(MD, VisitedBases);
      
      ThisAdjustment ThisAdjustmentOffset/*J*/= new ThisAdjustment();
      boolean ReturnAdjustingThunk = false;
      boolean ForceReturnAdjustmentMangling = false;
      CharUnits ThisOffset = ComputeThisOffset(new FinalOverriders.OverriderInfo(FinalOverrider));
      ThisAdjustmentOffset.NonVirtual
         = (ThisOffset.$sub(WhichVFPtr.FullOffsetInMDC)).getQuantity();
      if (((OverriddenMD != null) || FinalOverriderMD != MD)
         && (WhichVFPtr.getVBaseWithVPtr() != null)) {
        CalculateVtordispAdjustment(new FinalOverriders.OverriderInfo(FinalOverrider), new CharUnits(ThisOffset), 
            ThisAdjustmentOffset);
      }
      if ((OverriddenMD != null)) {
        // If MD overrides anything in this vftable, we need to update the
        // entries.
        DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , MethodInfo> OverriddenMDIterator = MethodInfoMap.find(OverriddenMD);
        
        // If the overridden method went to a different vftable, skip it.
        if (OverriddenMDIterator.$eq(/*NO_ITER_COPY*/MethodInfoMap.end())) {
          continue;
        }
        
        final MethodInfo /*&*/ OverriddenMethodInfo = OverriddenMDIterator.$arrow().second;
        
        // Let's check if the overrider requires any return adjustments.
        // We must create a new slot if the MD's return type is not trivially
        // convertible to the OverriddenMD's one.
        // Once a chain of method overrides adds a return adjusting vftable slot,
        // all subsequent overrides will also use an extra method slot.
        ReturnAdjustingThunk = !ComputeReturnAdjustmentBaseOffset(Context, MD, OverriddenMD).isEmpty()
           || OverriddenMethodInfo.UsesExtraSlot;
        if (!ReturnAdjustingThunk) {
          // No return adjustment needed - just replace the overridden method info
          // with the current info.
          MethodInfo MI/*J*/= new MethodInfo(OverriddenMethodInfo.VBTableIndex, 
              OverriddenMethodInfo.VFTableIndex);
          MethodInfoMap.erase(new DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , MethodInfo>(OverriddenMDIterator));
          assert (!(MethodInfoMap.count(MD) != 0)) : "Should not have method info for this method yet!";
          MethodInfoMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(MD, MI));
          continue;
        }
        
        // In case we need a return adjustment, we'll add a new slot for
        // the overrider. Mark the overriden method as shadowed by the new slot.
        OverriddenMethodInfo.Shadowed = true;
        
        // Force a special name mangling for a return-adjusting thunk
        // unless the method is the final overrider without this adjustment.
        ForceReturnAdjustmentMangling
           = !(MD == FinalOverriderMD && ThisAdjustmentOffset.isEmpty());
      } else if (Base.getBaseOffset().$noteq(WhichVFPtr.FullOffsetInMDC)
         || (MD.size_overridden_methods() != 0)) {
        // Skip methods that don't belong to the vftable of the current class,
        // e.g. each method that wasn't seen in any of the visited sub-bases
        // but overrides multiple methods of other sub-bases.
        continue;
      }
      
      // If we got here, MD is a method not seen in any of the sub-bases or
      // it requires return adjustment. Insert the method info for this method.
      /*uint*/int VBIndex = (LastVBase != null) ? VTables.getVBTableIndex(MostDerivedClass, LastVBase) : 0;
      MethodInfo MI/*J*/= new MethodInfo($uint2ulong(VBIndex), 
          $uint2ulong(HasRTTIComponent ? Components.size() - 1 : Components.size()), 
          ReturnAdjustingThunk);
      assert (!(MethodInfoMap.count(MD) != 0)) : "Should not have method info for this method yet!";
      MethodInfoMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(MD, MI));
      
      // Check if this overrider needs a return adjustment.
      // We don't want to do this for pure virtual member functions.
      BaseOffset ReturnAdjustmentOffset/*J*/= new BaseOffset();
      ReturnAdjustment $ReturnAdjustment/*J*/= new ReturnAdjustment();
      if (!FinalOverriderMD.isPure()) {
        ReturnAdjustmentOffset.$assignMove(
            ComputeReturnAdjustmentBaseOffset(Context, FinalOverriderMD, MD)
        );
      }
      if (!ReturnAdjustmentOffset.isEmpty()) {
        ForceReturnAdjustmentMangling = true;
        $ReturnAdjustment.NonVirtual
           = ReturnAdjustmentOffset.NonVirtualOffset.getQuantity();
        if ((ReturnAdjustmentOffset.VirtualBase != null)) {
          final /*const*/ ASTRecordLayout /*&*/ DerivedLayout = Context.getASTRecordLayout(ReturnAdjustmentOffset.DerivedClass);
          $ReturnAdjustment.Virtual.Microsoft.VBPtrOffset
             = $long2uint(DerivedLayout.getVBPtrOffset().getQuantity());
          $ReturnAdjustment.Virtual.Microsoft.VBIndex
             = VTables.getVBTableIndex(ReturnAdjustmentOffset.DerivedClass, 
              ReturnAdjustmentOffset.VirtualBase);
        }
      }
      
      AddMethod(FinalOverriderMD, 
          new ThunkInfo(ThisAdjustmentOffset, $ReturnAdjustment, 
              ForceReturnAdjustmentMangling ? MD : (/*const*/ CXXMethodDecl /*P*/ )null));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::LayoutVFTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2510,
   FQN="(anonymous namespace)::VFTableBuilder::LayoutVFTable", NM="_ZN12_GLOBAL__N_114VFTableBuilder13LayoutVFTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder13LayoutVFTableEv")
  //</editor-fold>
  private void LayoutVFTable() {
    SmallSetVector</*const*/ CXXRecordDecl /*P*/ > VisitedBases = null;
    try {
      // RTTI data goes before all other entries.
      if (HasRTTIComponent) {
        Components.push_back(VTableComponent.MakeRTTI(MostDerivedClass));
      }
      
      VisitedBases/*J*/= new SmallSetVector</*const*/ CXXRecordDecl /*P*/ >(8, (/*const*/ CXXRecordDecl /*P*/ ) null);
      AddMethods(new BaseSubobject(MostDerivedClass, CharUnits.Zero()), 0, (/*const*/ CXXRecordDecl /*P*/ )null, 
          VisitedBases);
      assert (((HasRTTIComponent ? Components.size() - 1 : Components.size()) != 0)) : "vftable can't be empty";
      assert (MethodVFTableLocations.empty());
      for (final /*const*/std.pair</*const*/ CXXMethodDecl /*P*/ , MethodInfo> /*&*/ I : MethodInfoMap) {
        /*const*/ CXXMethodDecl /*P*/ MD = I.first;
        final /*const*/ MethodInfo /*&*/ MI = I.second;
        // Skip the methods that the MostDerivedClass didn't override
        // and the entries shadowed by return adjusting thunks.
        if (MD.getParent$Const() != MostDerivedClass || MI.Shadowed) {
          continue;
        }
        MicrosoftVTableContext.MethodVFTableLocation Loc/*J*/= new MicrosoftVTableContext.MethodVFTableLocation(MI.VBTableIndex, WhichVFPtr.getVBaseWithVPtr(), 
            new CharUnits(WhichVFPtr.NonVirtualOffset), MI.VFTableIndex);
        {
          /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
          if ((DD != null)) {
            MethodVFTableLocations.$at_T1$RR(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Deleting)).$assign(Loc);
          } else {
            MethodVFTableLocations.$at_T1$RR(new GlobalDecl(MD)).$assign(Loc);
          }
        }
      }
    } finally {
      if (VisitedBases != null) { VisitedBases.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::VFTableBuilder">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2540,
   FQN="(anonymous namespace)::VFTableBuilder::VFTableBuilder", NM="_ZN12_GLOBAL__N_114VFTableBuilderC1ERN5clang22MicrosoftVTableContextEPKNS1_13CXXRecordDeclEPKNS1_8VPtrInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilderC1ERN5clang22MicrosoftVTableContextEPKNS1_13CXXRecordDeclEPKNS1_8VPtrInfoE")
  //</editor-fold>
  public VFTableBuilder(final MicrosoftVTableContext /*&*/ VTables, 
      /*const*/ CXXRecordDecl /*P*/ MostDerivedClass, /*const*/ VPtrInfo /*P*/ Which) {
    // : VTables(VTables), Context(MostDerivedClass->getASTContext()), MostDerivedClass(MostDerivedClass), MostDerivedClassLayout(Context.getASTRecordLayout(MostDerivedClass)), WhichVFPtr(*Which), Overriders(MostDerivedClass, CharUnits(), MostDerivedClass), Components(), MethodVFTableLocations(), HasRTTIComponent(false), MethodInfoMap(), VTableThunks(), Thunks() 
    //START JInit
    this./*&*/VTables=/*&*/VTables;
    this./*&*/Context=/*&*/MostDerivedClass.getASTContext();
    this.MostDerivedClass = MostDerivedClass;
    this./*&*/MostDerivedClassLayout=/*&*/Context.getASTRecordLayout(MostDerivedClass);
    this./*&*/WhichVFPtr=/*&*/$Deref(Which);
    this.Overriders = new FinalOverriders(MostDerivedClass, new CharUnits(), MostDerivedClass);
    this.Components = new SmallVector<VTableComponent>(64, new VTableComponent());
    this.MethodVFTableLocations = new DenseMap<GlobalDecl, MicrosoftVTableContext.MethodVFTableLocation>(DenseMapInfoGlobalDecl.$Info(), new MicrosoftVTableContext.MethodVFTableLocation());
    /*InClass*/this.HasRTTIComponent = false;
    this.MethodInfoMap = new DenseMap</*const*/ CXXMethodDecl /*P*/ , MethodInfo>(DenseMapInfo$LikePtr.$Info(), new MethodInfo());
    this.VTableThunks = new DenseMapULongType<ThunkInfo>(DenseMapInfoULong.$Info(), new ThunkInfo());
    this.Thunks = new DenseMap</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<ThunkInfo>(1));
    //END JInit
    // Provide the RTTI component if RTTIData is enabled. If the vftable would
    // be available externally, we should not provide the RTTI componenent. It
    // is currently impossible to get available externally vftables with either
    // dllimport or extern template instantiations, but eventually we may add a
    // flag to support additional devirtualization that needs this.
    if (Context.getLangOpts().RTTIData) {
      HasRTTIComponent = true;
    }
    
    LayoutVFTable();
    if (Context.getLangOpts().DumpVTableLayouts) {
      dumpLayout(llvm.outs());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::getNumThunks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2562,
   FQN="(anonymous namespace)::VFTableBuilder::getNumThunks", NM="_ZNK12_GLOBAL__N_114VFTableBuilder12getNumThunksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder12getNumThunksEv")
  //</editor-fold>
  public long/*uint64_t*/ getNumThunks() /*const*/ {
    return $uint2ulong(Thunks.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::thunks_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2564,
   FQN="(anonymous namespace)::VFTableBuilder::thunks_begin", NM="_ZNK12_GLOBAL__N_114VFTableBuilder12thunks_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder12thunks_beginEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>> thunks_begin() /*const*/ {
    return Thunks.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::thunks_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2566,
   FQN="(anonymous namespace)::VFTableBuilder::thunks_end", NM="_ZNK12_GLOBAL__N_114VFTableBuilder10thunks_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder10thunks_endEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>> thunks_end() /*const*/ {
    return Thunks.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::vtable_locations">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2568,
   FQN="(anonymous namespace)::VFTableBuilder::vtable_locations", NM="_ZNK12_GLOBAL__N_114VFTableBuilder16vtable_locationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder16vtable_locationsEv")
  //</editor-fold>
  public iterator_range</*constconst*/std.pair<GlobalDecl, MicrosoftVTableContext.MethodVFTableLocation> /*&*/> vtable_locations() /*const*/ {
    return new iterator_range</*constconst*/std.pair<GlobalDecl, MicrosoftVTableContext.MethodVFTableLocation> /*&*/>(MethodVFTableLocations.begin$Const(), 
        MethodVFTableLocations.end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::getNumVTableComponents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2573,
   FQN="(anonymous namespace)::VFTableBuilder::getNumVTableComponents", NM="_ZNK12_GLOBAL__N_114VFTableBuilder22getNumVTableComponentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder22getNumVTableComponentsEv")
  //</editor-fold>
  public long/*uint64_t*/ getNumVTableComponents() /*const*/ {
    return $uint2ulong(Components.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::vtable_component_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2575,
   FQN="(anonymous namespace)::VFTableBuilder::vtable_component_begin", NM="_ZNK12_GLOBAL__N_114VFTableBuilder22vtable_component_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder22vtable_component_beginEv")
  //</editor-fold>
  public /*const*/ type$ptr<VTableComponent> /*P*/ vtable_component_begin() /*const*/ {
    return Components.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::vtable_component_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2579,
   FQN="(anonymous namespace)::VFTableBuilder::vtable_component_end", NM="_ZNK12_GLOBAL__N_114VFTableBuilder20vtable_component_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder20vtable_component_endEv")
  //</editor-fold>
  public /*const*/ type$ptr<VTableComponent> /*P*/ vtable_component_end() /*const*/ {
    return Components.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::vtable_thunks_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2583,
   FQN="(anonymous namespace)::VFTableBuilder::vtable_thunks_begin", NM="_ZNK12_GLOBAL__N_114VFTableBuilder19vtable_thunks_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder19vtable_thunks_beginEv")
  //</editor-fold>
  public DenseMapIteratorULongType<ThunkInfo> vtable_thunks_begin() /*const*/ {
    return VTableThunks.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::vtable_thunks_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2587,
   FQN="(anonymous namespace)::VFTableBuilder::vtable_thunks_end", NM="_ZNK12_GLOBAL__N_114VFTableBuilder17vtable_thunks_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VFTableBuilder17vtable_thunks_endEv")
  //</editor-fold>
  public DenseMapIteratorULongType<ThunkInfo> vtable_thunks_end() /*const*/ {
    return VTableThunks.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::dumpLayout">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use make_pair_T_T vs std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3125,
   FQN="(anonymous namespace)::VFTableBuilder::dumpLayout", NM="_ZN12_GLOBAL__N_114VFTableBuilder10dumpLayoutERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilder10dumpLayoutERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpLayout(final raw_ostream /*&*/ Out) {
    Out.$out(/*KEEP_STR*/"VFTable for ");
    PrintBasePath(WhichVFPtr.PathToBaseWithVPtr, Out);
    Out.$out(/*KEEP_STR*/$SGL_QUOTE);
    MostDerivedClass.printQualifiedName(Out);
    Out.$out(/*KEEP_STR*/"' (").$out_uint(Components.size()).$out(
        (Components.size() == 1 ? $(" entry") : $(" entries"))
    ).$out(/*KEEP_STR*/").\n");
    
    for (/*uint*/int I = 0, E = Components.size(); I != E; ++I) {
      Out.$out(llvm.format($("%4d | "), I));
      
      final /*const*/ VTableComponent /*&*/ Component = Components.$at(I);
      
      // Dump the component.
      switch (Component.getKind()) {
       case CK_RTTI:
        Component.getRTTIDecl().printQualifiedName(Out);
        Out.$out(/*KEEP_STR*/" RTTI");
        break;
       case CK_FunctionPointer:
        {
          /*const*/ CXXMethodDecl /*P*/ MD = Component.getFunctionDecl();
          
          // FIXME: Figure out how to print the real thunk type, since they can
          // differ in the return type.
          std.string Str = PredefinedExpr.ComputeName(PredefinedExpr.IdentType.PrettyFunctionNoVirtual, MD);
          Out.$out(Str);
          if (MD.isPure()) {
            Out.$out(/*KEEP_STR*/" [pure]");
          }
          if (MD.isDeleted()) {
            Out.$out(/*KEEP_STR*/" [deleted]");
          }
          
          ThunkInfo Thunk = VTableThunks.lookup($uint2ullong(I));
          if (!Thunk.isEmpty()) {
            dumpMicrosoftThunkAdjustment(Thunk, Out, /*ContinueFirstLine=*/ false);
          }
          
          break;
        }
       case CK_DeletingDtorPointer:
        {
          /*const*/ CXXDestructorDecl /*P*/ DD = Component.getDestructorDecl();
          
          DD.printQualifiedName(Out);
          Out.$out(/*KEEP_STR*/"() [scalar deleting]");
          if (DD.isPure()) {
            Out.$out(/*KEEP_STR*/" [pure]");
          }
          
          ThunkInfo Thunk = VTableThunks.lookup($uint2ullong(I));
          if (!Thunk.isEmpty()) {
            assert (Thunk.Return.isEmpty()) : "No return adjustment needed for destructors!";
            dumpMicrosoftThunkAdjustment(Thunk, Out, /*ContinueFirstLine=*/ false);
          }
          
          break;
        }
       default:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            final DiagnosticsEngine /*&*/ Diags = Context.getDiagnostics();
            /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
                /*KEEP_STR*/"Unexpected vftable component type %0 for component number %1");
            $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_uint($c$.track(Diags.Report(MostDerivedClass.getLocation(), DiagID)), 
                    I), Component.getKind().getValue()));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      Out.$out_char($$LF);
    }
    
    Out.$out_char($$LF);
    if (!Thunks.empty()) {
      std.mapTypePtr<std.string, /*const*/ CXXMethodDecl /*P*/ > MethodNamesAndDecls = null;
      try {
        // We store the method names in a map to get a stable order.
        MethodNamesAndDecls/*J*/= new std.mapTypePtr<std.string, /*const*/ CXXMethodDecl /*P*/ >();
        
        for (final /*const*/std.pair</*const*/ CXXMethodDecl /*P*/ , SmallVector<ThunkInfo>> /*&*/ I : Thunks) {
          /*const*/ CXXMethodDecl /*P*/ MD = I.first;
          std.string MethodName = PredefinedExpr.ComputeName(PredefinedExpr.IdentType.PrettyFunctionNoVirtual, MD);
          
          MethodNamesAndDecls.insert$T(std.make_pair_T_Ptr(MethodName, MD));
        }
        
        for (final /*const*/ pair</*const*/std.string, /*const*/ CXXMethodDecl /*P*/ > /*&*/ MethodNameAndDecl : MethodNamesAndDecls) {
          final /*const*/std.string/*&*/ MethodName = MethodNameAndDecl.first;
          /*const*/ CXXMethodDecl /*P*/ MD = MethodNameAndDecl.second;
          
          SmallVector<ThunkInfo> ThunksVector = new SmallVector<ThunkInfo>(Thunks.$at_T1$C$R(MD));
          std.stable_sort(ThunksVector.begin(), ThunksVector.end(), 
              /*[]*/ (final /*const*/ ThunkInfo /*&*/ LHS, final /*const*/ ThunkInfo /*&*/ RHS) -> {
                    // Keep different thunks with the same adjustments in the order they
                    // were put into the vector.
                    return $less_tuple_T_T(/*JAVA*/std.make_pair_T_T(LHS.This, LHS.Return), std.make_pair_T_T(RHS.This, RHS.Return), 
                            ThisAdjustment::$less_ThisAdjustment$C, ReturnAdjustment::$less_ReturnAdjustment$C);
                  });
          
          Out.$out(/*KEEP_STR*/"Thunks for '").$out(MethodName).$out(/*KEEP_STR*/"' (").$out_uint(ThunksVector.size());
          Out.$out((ThunksVector.size() == 1 ? $(" entry") : $(" entries"))).$out(/*KEEP_STR*/").\n");
          
          for (/*uint*/int I = 0, E = ThunksVector.size(); I != E; ++I) {
            final /*const*/ ThunkInfo /*&*/ Thunk = ThunksVector.$at(I);
            
            Out.$out(llvm.format($("%4d | "), I));
            dumpMicrosoftThunkAdjustment(Thunk, Out, /*ContinueFirstLine=*/ true);
            Out.$out_char($$LF);
          }
          
          Out.$out_char($$LF);
        }
      } finally {
        if (MethodNamesAndDecls != null) { MethodNamesAndDecls.$destroy(); }
      }
    }
    
    Out.flush();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VFTableBuilder::~VFTableBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2385,
   FQN="(anonymous namespace)::VFTableBuilder::~VFTableBuilder", NM="_ZN12_GLOBAL__N_114VFTableBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VFTableBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Thunks.$destroy();
    VTableThunks.$destroy();
    MethodInfoMap.$destroy();
    MethodVFTableLocations.$destroy();
    Components.$destroy();
    Overriders.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "VTables=" + "[MicrosoftVTableContext]" // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", MostDerivedClass=" + MostDerivedClass // NOI18N
              + ", MostDerivedClassLayout=" + MostDerivedClassLayout // NOI18N
              + ", WhichVFPtr=" + WhichVFPtr // NOI18N
              + ", Overriders=" + Overriders // NOI18N
              + ", Components=" + Components // NOI18N
              + ", MethodVFTableLocations=" + MethodVFTableLocations // NOI18N
              + ", HasRTTIComponent=" + HasRTTIComponent // NOI18N
              + ", MethodInfoMap=" + MethodInfoMap // NOI18N
              + ", VTableThunks=" + VTableThunks // NOI18N
              + ", Thunks=" + Thunks; // NOI18N
  }
}
