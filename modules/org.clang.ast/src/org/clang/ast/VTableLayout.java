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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::VTableLayout">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 219,
 FQN="clang::VTableLayout", NM="_ZN5clang12VTableLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang12VTableLayoutE")
//</editor-fold>
public class VTableLayout implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef std::pair<uint64_t, ThunkInfo> VTableThunkTy*/
//  public final class VTableThunkTy extends std.pairULongType<ThunkInfo>{ };
  
  /*typedef const VTableComponent *vtable_component_iterator*/
//  public final class vtable_component_iterator extends /*const*/ VTableComponent /*P*/ { };
  /*typedef const VTableThunkTy *vtable_thunk_iterator*/
//  public final class vtable_thunk_iterator extends /*const*/std.pairULongType<ThunkInfo>/*P*/ { };
  /*typedef llvm::iterator_range<vtable_component_iterator> vtable_component_range*/
//  public final class vtable_component_range extends iterator_range</*const*/ VTableComponent>{ };
  
  /*typedef llvm::DenseMap<BaseSubobject, uint64_t> AddressPointsMapTy*/
//  public final class AddressPointsMapTy extends DenseMapTypeULong<BaseSubobject>{ };
/*private:*/
  private long/*uint64_t*/ NumVTableComponents;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private unique_ptr_array<VTableComponent> VTableComponents;
  
  /// \brief Contains thunks needed by vtables, sorted by indices.
  private long/*uint64_t*/ NumVTableThunks;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private unique_ptr_array<std.pairULongType<ThunkInfo>> VTableThunks;
  
  /// \brief Address points for all vtables.
  private DenseMapTypeULong<BaseSubobject> AddressPoints;
  
  private boolean IsMicrosoftABI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::VTableLayout">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2206,
   FQN="clang::VTableLayout::VTableLayout", NM="_ZN5clang12VTableLayoutC1EyPKNS_15VTableComponentEyPKSt4pairIyNS_9ThunkInfoEERKN4llvm8DenseMapINS_13BaseSubobjectEyNS9_12DenseMapInfoISB_EENS9_6detail12DenseMapPairISB_yEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang12VTableLayoutC1EyPKNS_15VTableComponentEyPKSt4pairIyNS_9ThunkInfoEERKN4llvm8DenseMapINS_13BaseSubobjectEyNS9_12DenseMapInfoISB_EENS9_6detail12DenseMapPairISB_yEEEEb")
  //</editor-fold>
  public VTableLayout(long/*uint64_t*/ NumVTableComponents, 
      /*const*/ type$ptr<VTableComponent /*P*/> VTableComponents, 
      long/*uint64_t*/ NumVTableThunks, 
      /*const*/type$ptr<std.pairULongType<ThunkInfo>/*P*/> VTableThunks, 
      final /*const*/DenseMapTypeULong<BaseSubobject> /*&*/ AddressPoints, 
      boolean IsMicrosoftABI) {
    // : NumVTableComponents(NumVTableComponents), VTableComponents(new VTableComponent [NumVTableComponents]), NumVTableThunks(NumVTableThunks), VTableThunks(new VTableThunkTy [NumVTableThunks]), AddressPoints(AddressPoints), IsMicrosoftABI(IsMicrosoftABI) 
    //START JInit
    this.NumVTableComponents = NumVTableComponents;
    this.VTableComponents = new unique_ptr_array<VTableComponent>(new VTableComponent [(int)NumVTableComponents]);
    this.NumVTableThunks = NumVTableThunks;
    this.VTableThunks = new unique_ptr_array<std.pairULongType<ThunkInfo>>(new std.pairULongType[(int)NumVTableThunks]);
    this.AddressPoints = new DenseMapTypeULong<BaseSubobject>(AddressPoints);
    this.IsMicrosoftABI = IsMicrosoftABI;
    //END JInit
    std.copy(VTableComponents, VTableComponents.$add((int)NumVTableComponents), 
        create_type$ptr(this.VTableComponents.get()));
    std.copy(VTableThunks, VTableThunks.$add((int)NumVTableThunks), 
        create_type$ptr(this.VTableThunks.get()));
    std.sort(create_type$ptr(this.VTableThunks.get()), 
        create_type$ptr(this.VTableThunks.get()).$add((int)NumVTableThunks), 
        /*[]*/ (final /*const*/std.pairULongType<ThunkInfo> /*&*/ LHS, final /*const*/std.pairULongType<ThunkInfo> /*&*/ RHS) -> {
              assert ((LHS.first != RHS.first || ThunkInfo.$eq_ThunkInfo$C(LHS.second, RHS.second))) : "Different thunks should have unique indices!";
              return $less_ulong(LHS.first, RHS.first);
            });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::~VTableLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2232,
   FQN="clang::VTableLayout::~VTableLayout", NM="_ZN5clang12VTableLayoutD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang12VTableLayoutD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    AddressPoints.$destroy();
    VTableThunks.$destroy();
    VTableComponents.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::getNumVTableComponents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 252,
   FQN="clang::VTableLayout::getNumVTableComponents", NM="_ZNK5clang12VTableLayout22getNumVTableComponentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout22getNumVTableComponentsEv")
  //</editor-fold>
  public long/*uint64_t*/ getNumVTableComponents() /*const*/ {
    return NumVTableComponents;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::vtable_components">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 256,
   FQN="clang::VTableLayout::vtable_components", NM="_ZNK5clang12VTableLayout17vtable_componentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout17vtable_componentsEv")
  //</editor-fold>
  public iterator_range</*const*/ VTableComponent> vtable_components() /*const*/ {
    return new iterator_range</*const*/ VTableComponent>(vtable_component_begin(), 
        vtable_component_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::vtable_component_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 261,
   FQN="clang::VTableLayout::vtable_component_begin", NM="_ZNK5clang12VTableLayout22vtable_component_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout22vtable_component_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ VTableComponent /*P*/ > vtable_component_begin() /*const*/ {
    return create_type$ptr(VTableComponents.get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::vtable_component_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 265,
   FQN="clang::VTableLayout::vtable_component_end", NM="_ZNK5clang12VTableLayout20vtable_component_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout20vtable_component_endEv")
  //</editor-fold>
  public type$ptr</*const*/ VTableComponent /*P*/ > vtable_component_end() /*const*/ {
    return create_type$ptr(VTableComponents.get()).$add((int)NumVTableComponents);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::getNumVTableThunks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 269,
   FQN="clang::VTableLayout::getNumVTableThunks", NM="_ZNK5clang12VTableLayout18getNumVTableThunksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout18getNumVTableThunksEv")
  //</editor-fold>
  public long/*uint64_t*/ getNumVTableThunks() /*const*/ {
    return NumVTableThunks;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::vtable_thunk_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 271,
   FQN="clang::VTableLayout::vtable_thunk_begin", NM="_ZNK5clang12VTableLayout18vtable_thunk_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout18vtable_thunk_beginEv")
  //</editor-fold>
  public type$ptr</*const*/std.pairULongType<ThunkInfo> /*P*/> vtable_thunk_begin() /*const*/ {
    return create_type$ptr(VTableThunks.get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::vtable_thunk_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 275,
   FQN="clang::VTableLayout::vtable_thunk_end", NM="_ZNK5clang12VTableLayout16vtable_thunk_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout16vtable_thunk_endEv")
  //</editor-fold>
  public type$ptr</*const*/std.pairULongType<ThunkInfo> /*P*/> vtable_thunk_end() /*const*/ {
    return create_type$ptr(VTableThunks.get()).$add((int)NumVTableThunks);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::getAddressPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 279,
   FQN="clang::VTableLayout::getAddressPoint", NM="_ZNK5clang12VTableLayout15getAddressPointENS_13BaseSubobjectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout15getAddressPointENS_13BaseSubobjectE")
  //</editor-fold>
  public long/*uint64_t*/ getAddressPoint(BaseSubobject Base) /*const*/ {
    assert ((AddressPoints.count(Base) != 0)) : "Did not find address point!";
    
    long/*uint64_t*/ AddressPoint = AddressPoints.lookup(Base);
    assert (AddressPoint != $int2ullong(0) || IsMicrosoftABI);
    ///*J:(void)*/IsMicrosoftABI;
    
    return AddressPoint;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VTableLayout::getAddressPoints">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 290,
   FQN="clang::VTableLayout::getAddressPoints", NM="_ZNK5clang12VTableLayout16getAddressPointsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang12VTableLayout16getAddressPointsEv")
  //</editor-fold>
  public /*const*/DenseMapTypeULong<BaseSubobject> /*&*/ getAddressPoints() /*const*/ {
    return AddressPoints;
  }

  
  @Override public String toString() {
    return "" + "NumVTableComponents=" + NumVTableComponents // NOI18N
              + ", VTableComponents=" + VTableComponents // NOI18N
              + ", NumVTableThunks=" + NumVTableThunks // NOI18N
              + ", VTableThunks=" + VTableThunks // NOI18N
              + ", AddressPoints=" + AddressPoints // NOI18N
              + ", IsMicrosoftABI=" + IsMicrosoftABI; // NOI18N
  }
}
