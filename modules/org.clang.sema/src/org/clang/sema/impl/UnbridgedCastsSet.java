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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnbridgedCastsSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 821,
 FQN="(anonymous namespace)::UnbridgedCastsSet", NM="_ZN12_GLOBAL__N_117UnbridgedCastsSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_117UnbridgedCastsSetE")
//</editor-fold>
public class UnbridgedCastsSet implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnbridgedCastsSet::Entry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use type$ref*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 822,
   FQN="(anonymous namespace)::UnbridgedCastsSet::Entry", NM="_ZN12_GLOBAL__N_117UnbridgedCastsSet5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_117UnbridgedCastsSet5EntryE")
  //</editor-fold>
  private static class/*struct*/ Entry {
    public final type$ref<Expr/*P*/> Addr;
    public Expr /*P*/ Saved;

    public Entry(final type$ref<Expr> Addr, Expr Saved) {
      assert Addr != null;
      assert Addr.$deref() == Saved;
      this.Addr = Addr;
      this.Saved = Saved;
    }

    @Override public String toString() {
      return "" + "Addr=" + Addr // NOI18N
                + ", Saved=" + Saved; // NOI18N
    }
  };
  private SmallVector<Entry> Entries;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnbridgedCastsSet::save">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 829,
   FQN="(anonymous namespace)::UnbridgedCastsSet::save", NM="_ZN12_GLOBAL__N_117UnbridgedCastsSet4saveERN5clang4SemaERPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_117UnbridgedCastsSet4saveERN5clang4SemaERPNS1_4ExprE")
  //</editor-fold>
  public void save(final Sema /*&*/ S, final type$ref<Expr /*P*/ /*&*/> E) {
    assert (E.$deref().hasPlaceholderType(BuiltinType.Kind.ARCUnbridgedCast));
    Entry entry = new Entry(E, E.$deref());
    Entries.push_back(entry);
    E.$set(S.stripARCUnbridgedCast(E.$deref()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnbridgedCastsSet::restore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 836,
   FQN="(anonymous namespace)::UnbridgedCastsSet::restore", NM="_ZN12_GLOBAL__N_117UnbridgedCastsSet7restoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_117UnbridgedCastsSet7restoreEv")
  //</editor-fold>
  public void restore() {
    for (type$ptr<Entry> i = $tryClone(Entries.begin()), /*P*/ e = $tryClone(Entries.end()); $noteq_iter(i, e); i.$preInc())  {
      i./*->*/$star().Addr.$set(i./*->*/$star().Saved);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnbridgedCastsSet::UnbridgedCastsSet">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 821,
   FQN="(anonymous namespace)::UnbridgedCastsSet::UnbridgedCastsSet", NM="_ZN12_GLOBAL__N_117UnbridgedCastsSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_117UnbridgedCastsSetC1Ev")
  //</editor-fold>
  public /*inline*/ UnbridgedCastsSet() {
    // : Entries() 
    //START JInit
    this.Entries = new SmallVector<Entry>(2, (Entry)null/*new Entry(null, null)*/);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnbridgedCastsSet::~UnbridgedCastsSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 821,
   FQN="(anonymous namespace)::UnbridgedCastsSet::~UnbridgedCastsSet", NM="_ZN12_GLOBAL__N_117UnbridgedCastsSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_117UnbridgedCastsSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Entries.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Entries=" + Entries; // NOI18N
  }
}
