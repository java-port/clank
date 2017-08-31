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
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native.NativePOD;

// BaseSubobject - Uniquely identifies a direct or indirect base class. 
// Stores both the base class decl and the offset from the most derived class to
// the base class. Used for vtable and VTT generation.
//<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 27,
 FQN="clang::BaseSubobject", NM="_ZN5clang13BaseSubobjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang13BaseSubobjectE")
//</editor-fold>
public class BaseSubobject implements NativePOD<BaseSubobject> {
  /// Base - The base class declaration.
  private /*const*/ CXXRecordDecl /*P*/ Base;
  
  /// BaseOffset - The offset from the most derived class to the base class.
  private CharUnits BaseOffset;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject::BaseSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 35,
   FQN="clang::BaseSubobject::BaseSubobject", NM="_ZN5clang13BaseSubobjectC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang13BaseSubobjectC1Ev")
  //</editor-fold>
  public BaseSubobject() {
    // : BaseOffset() 
    //START JInit
    this.BaseOffset = new CharUnits();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject::BaseSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 36,
   FQN="clang::BaseSubobject::BaseSubobject", NM="_ZN5clang13BaseSubobjectC1EPKNS_13CXXRecordDeclENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang13BaseSubobjectC1EPKNS_13CXXRecordDeclENS_9CharUnitsE")
  //</editor-fold>
  public BaseSubobject(/*const*/ CXXRecordDecl /*P*/ Base, CharUnits BaseOffset) {
    // : Base(Base), BaseOffset(BaseOffset) 
    //START JInit
    this.Base = Base;
    this.BaseOffset = new CharUnits(BaseOffset);
    //END JInit
  }

  
  /// getBase - Returns the base class declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject::getBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 40,
   FQN="clang::BaseSubobject::getBase", NM="_ZNK5clang13BaseSubobject7getBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZNK5clang13BaseSubobject7getBaseEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getBase() /*const*/ {
    return Base;
  }

  
  /// getBaseOffset - Returns the base class offset.
  //<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject::getBaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 43,
   FQN="clang::BaseSubobject::getBaseOffset", NM="_ZNK5clang13BaseSubobject13getBaseOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZNK5clang13BaseSubobject13getBaseOffsetEv")
  //</editor-fold>
  public CharUnits getBaseOffset() /*const*/ {
    return new CharUnits(BaseOffset);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 45,
   FQN="clang::operator==", NM="_ZN5clangeqERKNS_13BaseSubobjectES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clangeqERKNS_13BaseSubobjectES2_")
  //</editor-fold>
  public static boolean $eq_BaseSubobject$C(final /*const*/ BaseSubobject /*&*/ LHS, final /*const*/ BaseSubobject /*&*/ RHS) {
    return LHS.Base == RHS.Base && LHS.BaseOffset.$eq(RHS.BaseOffset);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject::BaseSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 27,
   FQN="clang::BaseSubobject::BaseSubobject", NM="_ZN5clang13BaseSubobjectC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang13BaseSubobjectC1ERKS0_")
  //</editor-fold>
  public /*inline*/ BaseSubobject(final /*const*/ BaseSubobject /*&*/ $Prm0) {
    // : Base(.Base), BaseOffset(.BaseOffset) 
    //START JInit
    this.Base = $Prm0.Base;
    this.BaseOffset = new CharUnits($Prm0.BaseOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject::BaseSubobject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 27,
   FQN="clang::BaseSubobject::BaseSubobject", NM="_ZN5clang13BaseSubobjectC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang13BaseSubobjectC1EOS0_")
  //</editor-fold>
  public /*inline*/ BaseSubobject(JD$Move _dparam, final BaseSubobject /*&&*/$Prm0) {
    // : Base(static_cast<BaseSubobject &&>().Base), BaseOffset(static_cast<BaseSubobject &&>().BaseOffset) 
    //START JInit
    this.Base = $Prm0.Base;
    this.BaseOffset = new CharUnits(JD$Move.INSTANCE, $Prm0.BaseOffset);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 27,
   FQN="clang::BaseSubobject::operator=", NM="_ZN5clang13BaseSubobjectaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang13BaseSubobjectaSERKS0_")
  //</editor-fold>
  public /*inline*/ BaseSubobject /*&*/ $assign(final /*const*/ BaseSubobject /*&*/ $Prm0) {
    this.Base = $Prm0.Base;
    this.BaseOffset.$assign($Prm0.BaseOffset);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BaseSubobject::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/BaseSubobject.h", line = 27,
   FQN="clang::BaseSubobject::operator=", NM="_ZN5clang13BaseSubobjectaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN5clang13BaseSubobjectaSEOS0_")
  //</editor-fold>
  public /*inline*/ BaseSubobject /*&*/ $assignMove(final BaseSubobject /*&&*/$Prm0) {
    this.Base = $Prm0.Base;
    this.BaseOffset.$assignMove($Prm0.BaseOffset);
    return /*Deref*/this;
  }

  @Override public BaseSubobject clone() { return new BaseSubobject(this); }

  @Override public String toString() {
    return "" + "Base=" + Base // NOI18N
              + ", BaseOffset=" + BaseOffset; // NOI18N
  }
}
