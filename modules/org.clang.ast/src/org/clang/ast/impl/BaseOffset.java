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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;


/// BaseOffset - Represents an offset from a derived class to a direct or
/// indirect base class.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 35,
 FQN="(anonymous namespace)::BaseOffset", NM="_ZN12_GLOBAL__N_110BaseOffsetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_110BaseOffsetE")
//</editor-fold>
public class/*struct*/ BaseOffset {
  /// DerivedClass - The derived class.
  public /*const*/ CXXRecordDecl /*P*/ DerivedClass;
  
  /// VirtualBase - If the path from the derived class to the base class
  /// involves virtual base classes, this holds the declaration of the last
  /// virtual base in this path (i.e. closest to the base class).
  public /*const*/ CXXRecordDecl /*P*/ VirtualBase;
  
  /// NonVirtualOffset - The offset from the derived class to the base class.
  /// (Or the offset from the virtual base class to the base class, if the 
  /// path from the derived class to the base class involves a virtual base
  /// class.
  public CharUnits NonVirtualOffset;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseOffset::BaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 50,
   FQN="(anonymous namespace)::BaseOffset::BaseOffset", NM="_ZN12_GLOBAL__N_110BaseOffsetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_110BaseOffsetC1Ev")
  //</editor-fold>
  public BaseOffset() {
    // : DerivedClass(null), VirtualBase(null), NonVirtualOffset(CharUnits::Zero()) 
    //START JInit
    this.DerivedClass = null;
    this.VirtualBase = null;
    this.NonVirtualOffset = CharUnits.Zero();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseOffset::BaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 52,
   FQN="(anonymous namespace)::BaseOffset::BaseOffset", NM="_ZN12_GLOBAL__N_110BaseOffsetC1EPKN5clang13CXXRecordDeclES4_NS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_110BaseOffsetC1EPKN5clang13CXXRecordDeclES4_NS1_9CharUnitsE")
  //</editor-fold>
  public BaseOffset(/*const*/ CXXRecordDecl /*P*/ DerivedClass, 
      /*const*/ CXXRecordDecl /*P*/ VirtualBase, CharUnits NonVirtualOffset) {
    // : DerivedClass(DerivedClass), VirtualBase(VirtualBase), NonVirtualOffset(NonVirtualOffset) 
    //START JInit
    this.DerivedClass = DerivedClass;
    this.VirtualBase = VirtualBase;
    this.NonVirtualOffset = new CharUnits(NonVirtualOffset);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseOffset::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 57,
   FQN="(anonymous namespace)::BaseOffset::isEmpty", NM="_ZNK12_GLOBAL__N_110BaseOffset7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK12_GLOBAL__N_110BaseOffset7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return NonVirtualOffset.isZero() && !(VirtualBase != null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseOffset::BaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 35,
   FQN="(anonymous namespace)::BaseOffset::BaseOffset", NM="_ZN12_GLOBAL__N_110BaseOffsetC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_110BaseOffsetC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BaseOffset(final /*const*/ BaseOffset /*&*/ $Prm0) {
    // : DerivedClass(.DerivedClass), VirtualBase(.VirtualBase), NonVirtualOffset(.NonVirtualOffset) 
    //START JInit
    this.DerivedClass = $Prm0.DerivedClass;
    this.VirtualBase = $Prm0.VirtualBase;
    this.NonVirtualOffset = new CharUnits($Prm0.NonVirtualOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseOffset::BaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 35,
   FQN="(anonymous namespace)::BaseOffset::BaseOffset", NM="_ZN12_GLOBAL__N_110BaseOffsetC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_110BaseOffsetC1EOS0_")
  //</editor-fold>
  public /*inline*/ BaseOffset(JD$Move _dparam, final BaseOffset /*&&*/$Prm0) {
    // : DerivedClass(static_cast<BaseOffset &&>().DerivedClass), VirtualBase(static_cast<BaseOffset &&>().VirtualBase), NonVirtualOffset(static_cast<BaseOffset &&>().NonVirtualOffset) 
    //START JInit
    this.DerivedClass = $Prm0.DerivedClass;
    this.VirtualBase = $Prm0.VirtualBase;
    this.NonVirtualOffset = new CharUnits(JD$Move.INSTANCE, $Prm0.NonVirtualOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BaseOffset::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 35,
   FQN="(anonymous namespace)::BaseOffset::operator=", NM="_ZN12_GLOBAL__N_110BaseOffsetaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_110BaseOffsetaSEOS0_")
  //</editor-fold>
  public /*inline*/ BaseOffset /*&*/ $assignMove(final BaseOffset /*&&*/$Prm0) {
    this.DerivedClass = $Prm0.DerivedClass;
    this.VirtualBase = $Prm0.VirtualBase;
    this.NonVirtualOffset.$assignMove($Prm0.NonVirtualOffset);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "DerivedClass=" + DerivedClass // NOI18N
              + ", VirtualBase=" + VirtualBase // NOI18N
              + ", NonVirtualOffset=" + NonVirtualOffset; // NOI18N
  }
}
