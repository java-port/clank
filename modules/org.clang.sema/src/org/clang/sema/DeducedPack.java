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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;


/// A pack that we're currently deducing.
//<editor-fold defaultstate="collapsed" desc="clang::DeducedPack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 555,
 FQN="clang::DeducedPack", NM="_ZN5clang11DeducedPackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang11DeducedPackE")
//</editor-fold>
public class/*struct*/ DeducedPack implements Destructors.ClassWithDestructor, NativeCloneable<DeducedPack> {
  //<editor-fold defaultstate="collapsed" desc="clang::DeducedPack::DeducedPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 556,
   FQN="clang::DeducedPack::DeducedPack", NM="_ZN5clang11DeducedPackC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang11DeducedPackC1Ej")
  //</editor-fold>
  public DeducedPack(/*uint*/int Index) {
    // : Index(Index), Saved(), DeferredDeduction(), New(), Outer(null) 
    //START JInit
    this.Index = Index;
    this.Saved = new DeducedTemplateArgument();
    this.DeferredDeduction = new DeducedTemplateArgument();
    this.New = new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    this.Outer = null;
    //END JInit
  }

  
  // The index of the pack.
  public /*uint*/int Index;
  
  // The old value of the pack before we started deducing it.
  public DeducedTemplateArgument Saved;
  
  // A deferred value of this pack from an inner deduction, that couldn't be
  // deduced because this deduction hadn't happened yet.
  public DeducedTemplateArgument DeferredDeduction;
  
  // The new value of the pack.
  public SmallVector<DeducedTemplateArgument> New;
  
  // The outer deduction for this pack, if any.
  public DeducedPack /*P*/ Outer;
  //<editor-fold defaultstate="collapsed" desc="clang::DeducedPack::DeducedPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 555,
   FQN="clang::DeducedPack::DeducedPack", NM="_ZN5clang11DeducedPackC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang11DeducedPackC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeducedPack(JD$Move _dparam, final DeducedPack /*&&*/$Prm0) {
    // : Index(static_cast<DeducedPack &&>().Index), Saved(static_cast<DeducedPack &&>().Saved), DeferredDeduction(static_cast<DeducedPack &&>().DeferredDeduction), New(static_cast<DeducedPack &&>().New), Outer(static_cast<DeducedPack &&>().Outer) 
    //START JInit
    this.Index = $Prm0.Index;
    this.Saved = new DeducedTemplateArgument(JD$Move.INSTANCE, $Prm0.Saved);
    this.DeferredDeduction = new DeducedTemplateArgument(JD$Move.INSTANCE, $Prm0.DeferredDeduction);
    this.New = new SmallVector<DeducedTemplateArgument>(JD$Move.INSTANCE, $Prm0.New);
    this.Outer = $Prm0.Outer;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeducedPack::DeducedPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 555,
   FQN="clang::DeducedPack::DeducedPack", NM="_ZN5clang11DeducedPackC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang11DeducedPackC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeducedPack(final /*const*/ DeducedPack /*&*/ $Prm0) {
    // : Index(.Index), Saved(.Saved), DeferredDeduction(.DeferredDeduction), New(.New), Outer(.Outer) 
    //START JInit
    this.Index = $Prm0.Index;
    this.Saved = new DeducedTemplateArgument($Prm0.Saved);
    this.DeferredDeduction = new DeducedTemplateArgument($Prm0.DeferredDeduction);
    this.New = new SmallVector<DeducedTemplateArgument>($Prm0.New);
    this.Outer = $Prm0.Outer;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeducedPack::~DeducedPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 555,
   FQN="clang::DeducedPack::~DeducedPack", NM="_ZN5clang11DeducedPackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang11DeducedPackD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    New.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public DeducedPack() { this(0); }

  @Override
  public DeducedPack clone() {
    return new DeducedPack(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Index=" + Index // NOI18N
              + ", Saved=" + Saved // NOI18N
              + ", DeferredDeduction=" + DeferredDeduction // NOI18N
              + ", New=" + New // NOI18N
              + ", Outer=" + Outer; // NOI18N
  }
}
