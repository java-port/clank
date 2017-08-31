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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;


/// \brief A collection of diagnostics which were delayed.
//<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 239,
 FQN="clang::sema::DelayedDiagnosticPool", NM="_ZN5clang4sema21DelayedDiagnosticPoolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPoolE")
//</editor-fold>
public class DelayedDiagnosticPool implements Destructors.ClassWithDestructor, NativeMoveable<DelayedDiagnosticPool> {
  private /*const*/ DelayedDiagnosticPool /*P*/ Parent;
  private SmallVector<DelayedDiagnostic> Diagnostics;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::DelayedDiagnosticPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 243,
   FQN="clang::sema::DelayedDiagnosticPool::DelayedDiagnosticPool", NM="_ZN5clang4sema21DelayedDiagnosticPoolC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPoolC1ERKS1_")
  //</editor-fold>
  private DelayedDiagnosticPool(final /*const*/ DelayedDiagnosticPool /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 244,
   FQN="clang::sema::DelayedDiagnosticPool::operator=", NM="_ZN5clang4sema21DelayedDiagnosticPoolaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPoolaSERKS1_")
  //</editor-fold>
  private void $assign(final /*const*/ DelayedDiagnosticPool /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::DelayedDiagnosticPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 246,
   FQN="clang::sema::DelayedDiagnosticPool::DelayedDiagnosticPool", NM="_ZN5clang4sema21DelayedDiagnosticPoolC1EPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPoolC1EPKS1_")
  //</editor-fold>
  public DelayedDiagnosticPool(JD$DelayedDiagnosticPool$C$P _dparam, /*const*/ DelayedDiagnosticPool /*P*/ parent) {
    // : Parent(parent), Diagnostics() 
    //START JInit
    this.Parent = parent;
    this.Diagnostics = new SmallVector<DelayedDiagnostic>(4, new DelayedDiagnostic());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::~DelayedDiagnosticPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 247,
   FQN="clang::sema::DelayedDiagnosticPool::~DelayedDiagnosticPool", NM="_ZN5clang4sema21DelayedDiagnosticPoolD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPoolD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (type$ptr<DelayedDiagnostic> i = $tryClone(Diagnostics.begin()), /*P*/ e = $tryClone(Diagnostics.end()); $noteq_iter(i, e); i.$preInc())  {
      i./*->*/$star().Destroy();
    }
    //START JDestroy
    Diagnostics.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::DelayedDiagnosticPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 253,
   FQN="clang::sema::DelayedDiagnosticPool::DelayedDiagnosticPool", NM="_ZN5clang4sema21DelayedDiagnosticPoolC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPoolC1EOS1_")
  //</editor-fold>
  public DelayedDiagnosticPool(JD$Move _dparam, final DelayedDiagnosticPool /*&&*/Other) {
    // : Parent(Other.Parent), Diagnostics(std::move(Other.Diagnostics)) 
    //START JInit
    this.Parent = Other.Parent;
    this.Diagnostics = new SmallVector<DelayedDiagnostic>(JD$Move.INSTANCE, std.move(Other.Diagnostics));
    //END JInit
    Other.Diagnostics.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 257,
   FQN="clang::sema::DelayedDiagnosticPool::operator=", NM="_ZN5clang4sema21DelayedDiagnosticPoolaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPoolaSEOS1_")
  //</editor-fold>
  public DelayedDiagnosticPool /*&*/ $assignMove(final DelayedDiagnosticPool /*&&*/Other) {
    Parent = Other.Parent;
    Diagnostics.$assignMove(std.move(Other.Diagnostics));
    Other.Diagnostics.clear();
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 264,
   FQN="clang::sema::DelayedDiagnosticPool::getParent", NM="_ZNK5clang4sema21DelayedDiagnosticPool9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema21DelayedDiagnosticPool9getParentEv")
  //</editor-fold>
  public /*const*/ DelayedDiagnosticPool /*P*/ getParent() /*const*/ {
    return Parent;
  }

  
  /// Does this pool, or any of its ancestors, contain any diagnostics?
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 267,
   FQN="clang::sema::DelayedDiagnosticPool::empty", NM="_ZNK5clang4sema21DelayedDiagnosticPool5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema21DelayedDiagnosticPool5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return (Diagnostics.empty() && (!(Parent != null) || Parent.empty()));
  }

  
  /// Add a diagnostic to this pool.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 272,
   FQN="clang::sema::DelayedDiagnosticPool::add", NM="_ZN5clang4sema21DelayedDiagnosticPool3addERKNS0_17DelayedDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPool3addERKNS0_17DelayedDiagnosticE")
  //</editor-fold>
  public void add(final /*const*/ DelayedDiagnostic /*&*/ diag) {
    Diagnostics.push_back(diag);
  }

  
  /// Steal the diagnostics from the given pool.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::steal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 277,
   FQN="clang::sema::DelayedDiagnosticPool::steal", NM="_ZN5clang4sema21DelayedDiagnosticPool5stealERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema21DelayedDiagnosticPool5stealERS1_")
  //</editor-fold>
  public void steal(final DelayedDiagnosticPool /*&*/ pool) {
    if (pool.Diagnostics.empty()) {
      return;
    }
    if (Diagnostics.empty()) {
      Diagnostics.$assignMove(std.move(pool.Diagnostics));
    } else {
      Diagnostics.append_T(pool.pool_begin(), pool.pool_end());
    }
    pool.Diagnostics.clear();
  }

  
  /*typedef SmallVectorImpl<DelayedDiagnostic>::const_iterator pool_iterator*/
//  public final class pool_iterator extends type$ptr<DelayedDiagnostic>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::pool_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 289,
   FQN="clang::sema::DelayedDiagnosticPool::pool_begin", NM="_ZNK5clang4sema21DelayedDiagnosticPool10pool_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema21DelayedDiagnosticPool10pool_beginEv")
  //</editor-fold>
  public type$ptr<DelayedDiagnostic> pool_begin() /*const*/ {
    return Diagnostics.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::pool_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 290,
   FQN="clang::sema::DelayedDiagnosticPool::pool_end", NM="_ZNK5clang4sema21DelayedDiagnosticPool8pool_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema21DelayedDiagnosticPool8pool_endEv")
  //</editor-fold>
  public type$ptr<DelayedDiagnostic> pool_end() /*const*/ {
    return Diagnostics.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::DelayedDiagnosticPool::pool_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 291,
   FQN="clang::sema::DelayedDiagnosticPool::pool_empty", NM="_ZNK5clang4sema21DelayedDiagnosticPool10pool_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema21DelayedDiagnosticPool10pool_emptyEv")
  //</editor-fold>
  public boolean pool_empty() /*const*/ {
    return Diagnostics.empty();
  }

  @Override public DelayedDiagnosticPool move() { return new DelayedDiagnosticPool(JD$Move.INSTANCE, this); }
  
  @Override public String toString() {
    return "" + "Parent=" + Parent // NOI18N
              + ", Diagnostics=" + Diagnostics.size() + "[SmallVector$DelayedDiagnostic]"; // NOI18N
  }
}
