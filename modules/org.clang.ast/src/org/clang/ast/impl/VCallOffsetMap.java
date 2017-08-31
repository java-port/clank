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
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.DeclarationName.*;
import static org.clang.ast.impl.VTableBuilderStatics.HasSameVirtualSignature;


/// VCallOffsetMap - Keeps track of vcall offsets when building a vtable.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 443,
 FQN="(anonymous namespace)::VCallOffsetMap", NM="_ZN12_GLOBAL__N_114VCallOffsetMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VCallOffsetMapE")
//</editor-fold>
public class/*struct*/ VCallOffsetMap implements Destructors.ClassWithDestructor {
  
  /*typedef std::pair<const CXXMethodDecl *, CharUnits> MethodAndOffsetPairTy*/
//  public final class MethodAndOffsetPairTy extends std.pair</*const*/ CXXMethodDecl /*P*/ , CharUnits>{ };
  
  /// Offsets - Keeps track of methods and their offsets.
  // FIXME: This should be a real map and not a vector.
  public SmallVector<std.pair</*const*/ CXXMethodDecl /*P*/ , CharUnits>> Offsets;
  
  /// MethodsCanShareVCallOffset - Returns whether two virtual member functions
  /// can share the same vcall offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap::MethodsCanShareVCallOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 488,
   FQN="(anonymous namespace)::VCallOffsetMap::MethodsCanShareVCallOffset", NM="_ZN12_GLOBAL__N_114VCallOffsetMap26MethodsCanShareVCallOffsetEPKN5clang13CXXMethodDeclES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VCallOffsetMap26MethodsCanShareVCallOffsetEPKN5clang13CXXMethodDeclES4_")
  //</editor-fold>
  public static boolean MethodsCanShareVCallOffset(/*const*/ CXXMethodDecl /*P*/ LHS, 
                            /*const*/ CXXMethodDecl /*P*/ RHS) {
    assert (LHS.isVirtual()) : "LHS must be virtual!";
    assert (RHS.isVirtual()) : "LHS must be virtual!";
    
    // A destructor can share a vcall offset with another destructor.
    if (isa_CXXDestructorDecl(LHS)) {
      return isa_CXXDestructorDecl(RHS);
    }
    
    // FIXME: We need to check more things here.
    
    // The methods must have the same name.
    DeclarationName LHSName = LHS.getDeclName();
    DeclarationName RHSName = RHS.getDeclName();
    if ($noteq_DeclarationName(/*NO_COPY*/LHSName, /*NO_COPY*/RHSName)) {
      return false;
    }
    
    // And the same signatures.
    return HasSameVirtualSignature(LHS, RHS);
  }

/*public:*/
  /// AddVCallOffset - Adds a vcall offset to the map. Returns true if the
  /// add was successful, or false if there was already a member function with
  /// the same signature in the map.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap::AddVCallOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 509,
   FQN="(anonymous namespace)::VCallOffsetMap::AddVCallOffset", NM="_ZN12_GLOBAL__N_114VCallOffsetMap14AddVCallOffsetEPKN5clang13CXXMethodDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VCallOffsetMap14AddVCallOffsetEPKN5clang13CXXMethodDeclENS1_9CharUnitsE")
  //</editor-fold>
  public boolean AddVCallOffset(/*const*/ CXXMethodDecl /*P*/ MD, 
                CharUnits OffsetOffset) {
    // Check if we can reuse an offset.
    for (final /*const*/ pair</*const*/ CXXMethodDecl /*P*/ , CharUnits> /*&*/ OffsetPair : Offsets) {
      if (MethodsCanShareVCallOffset(OffsetPair.first, MD)) {
        return false;
      }
    }
    
    // Add the offset.
    Offsets.push_back(new std.pairPtrType</*const*/ CXXMethodDecl /*P*/ , CharUnits>(JD$T$RR_T1$RR.INSTANCE, MD, OffsetOffset));
    return true;
  }

  
  /// getVCallOffsetOffset - Returns the vcall offset offset (relative to the
  /// vtable address point) for the given virtual member function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap::getVCallOffsetOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 522,
   FQN="(anonymous namespace)::VCallOffsetMap::getVCallOffsetOffset", NM="_ZN12_GLOBAL__N_114VCallOffsetMap20getVCallOffsetOffsetEPKN5clang13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VCallOffsetMap20getVCallOffsetOffsetEPKN5clang13CXXMethodDeclE")
  //</editor-fold>
  public CharUnits getVCallOffsetOffset(/*const*/ CXXMethodDecl /*P*/ MD) {
    // Look for an offset.
    for (final /*const*/ pair</*const*/ CXXMethodDecl /*P*/ , CharUnits> /*&*/ OffsetPair : Offsets) {
      if (MethodsCanShareVCallOffset(OffsetPair.first, MD)) {
        return new CharUnits(OffsetPair.second);
      }
    }
    throw new llvm_unreachable("Should always find a vcall offset offset!");
  }

  
  // empty - Return whether the offset map is empty or not.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 467,
   FQN="(anonymous namespace)::VCallOffsetMap::empty", NM="_ZNK12_GLOBAL__N_114VCallOffsetMap5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_114VCallOffsetMap5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Offsets.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap::VCallOffsetMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 443,
   FQN="(anonymous namespace)::VCallOffsetMap::VCallOffsetMap", NM="_ZN12_GLOBAL__N_114VCallOffsetMapC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VCallOffsetMapC1EOS0_")
  //</editor-fold>
  public /*inline*/ VCallOffsetMap(JD$Move _dparam, final VCallOffsetMap /*&&*/$Prm0) {
    // : Offsets(static_cast<VCallOffsetMap &&>().Offsets) 
    //START JInit
    this.Offsets = new SmallVector<std.pair</*const*/ CXXMethodDecl /*P*/ , CharUnits>>(JD$Move.INSTANCE, $Prm0.Offsets);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap::~VCallOffsetMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 443,
   FQN="(anonymous namespace)::VCallOffsetMap::~VCallOffsetMap", NM="_ZN12_GLOBAL__N_114VCallOffsetMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VCallOffsetMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Offsets.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap::VCallOffsetMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 443,
   FQN="(anonymous namespace)::VCallOffsetMap::VCallOffsetMap", NM="_ZN12_GLOBAL__N_114VCallOffsetMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VCallOffsetMapC1Ev")
  //</editor-fold>
  public /*inline*/ VCallOffsetMap() {
    // : Offsets() 
    //START JInit
    this.Offsets = new SmallVector<std.pair</*const*/ CXXMethodDecl /*P*/ , CharUnits>>(16, new std.pairPtrType</*const*/ CXXMethodDecl /*P*/ , CharUnits>(null, new CharUnits()));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VCallOffsetMap::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 443,
   FQN="(anonymous namespace)::VCallOffsetMap::operator=", NM="_ZN12_GLOBAL__N_114VCallOffsetMapaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_114VCallOffsetMapaSERKS0_")
  //</editor-fold>
  public /*inline*/ VCallOffsetMap /*&*/ $assign(final /*const*/ VCallOffsetMap /*&*/ $Prm0) {
    this.Offsets.$assign($Prm0.Offsets);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Offsets=" + Offsets; // NOI18N
  }
}
