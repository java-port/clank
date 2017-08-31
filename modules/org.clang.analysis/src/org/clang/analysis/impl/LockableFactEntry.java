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

package org.clang.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.threadSafety.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockableFactEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 813,
 FQN="(anonymous namespace)::LockableFactEntry", NM="_ZN12_GLOBAL__N_117LockableFactEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_117LockableFactEntryE")
//</editor-fold>
public class LockableFactEntry extends /*public*/ FactEntry implements Destructors.ClassWithDestructor {
/*private:*/
  private boolean Managed; ///<  managed by ScopedLockable object
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockableFactEntry::LockableFactEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 818,
   FQN="(anonymous namespace)::LockableFactEntry::LockableFactEntry", NM="_ZN12_GLOBAL__N_117LockableFactEntryC1ERKN5clang12threadSafety14CapabilityExprENS2_8LockKindENS1_14SourceLocationEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_117LockableFactEntryC1ERKN5clang12threadSafety14CapabilityExprENS2_8LockKindENS1_14SourceLocationEbb")
  //</editor-fold>
  public LockableFactEntry(final /*const*/ CapabilityExpr /*&*/ CE, LockKind LK, SourceLocation Loc) {
    this(CE, LK, Loc, 
      false, false);
  }
  public LockableFactEntry(final /*const*/ CapabilityExpr /*&*/ CE, LockKind LK, SourceLocation Loc, 
      boolean Mng/*= false*/) {
    this(CE, LK, Loc, 
      Mng, false);
  }
  public LockableFactEntry(final /*const*/ CapabilityExpr /*&*/ CE, LockKind LK, SourceLocation Loc, 
      boolean Mng/*= false*/, boolean Asrt/*= false*/) {
    // : FactEntry(CE, LK, Loc, Asrt), Managed(Mng) 
    //START JInit
    super(CE, LK, new SourceLocation(Loc), Asrt);
    this.Managed = Mng;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockableFactEntry::handleRemovalFromIntersection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 822,
   FQN="(anonymous namespace)::LockableFactEntry::handleRemovalFromIntersection", NM="_ZNK12_GLOBAL__N_117LockableFactEntry29handleRemovalFromIntersectionERKNS_7FactSetERNS_11FactManagerEN5clang14SourceLocationENS6_12threadSafety13LockErrorKindERNS8_19ThreadSafetyHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_117LockableFactEntry29handleRemovalFromIntersectionERKNS_7FactSetERNS_11FactManagerEN5clang14SourceLocationENS6_12threadSafety13LockErrorKindERNS8_19ThreadSafetyHandlerE")
  //</editor-fold>
  @Override public void handleRemovalFromIntersection(final /*const*/ FactSet /*&*/ FSet, final FactManager /*&*/ FactMan, 
                               SourceLocation JoinLoc, LockErrorKind LEK, 
                               final ThreadSafetyHandler /*&*/ Handler) /*const*//* override*/ {
    if (!Managed && !asserted() && !negative() && !isUniversal()) {
      Handler.handleMutexHeldEndOfScope(new StringRef(/*KEEP_STR*/"mutex"), new StringRef(__toString()), loc(), new SourceLocation(JoinLoc), 
          LEK);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockableFactEntry::handleUnlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 832,
   FQN="(anonymous namespace)::LockableFactEntry::handleUnlock", NM="_ZNK12_GLOBAL__N_117LockableFactEntry12handleUnlockERNS_7FactSetERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprENS5_14SourceLocationEbRNS6_19ThreadSafetyHandlerEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_117LockableFactEntry12handleUnlockERNS_7FactSetERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprENS5_14SourceLocationEbRNS6_19ThreadSafetyHandlerEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void handleUnlock(final FactSet /*&*/ FSet, final FactManager /*&*/ FactMan, 
              final /*const*/ CapabilityExpr /*&*/ Cp, SourceLocation UnlockLoc, 
              boolean FullyRemove, final ThreadSafetyHandler /*&*/ Handler, 
              StringRef DiagKind) /*const*//* override*/ {
    FSet.removeLock(FactMan, Cp);
    if (!Cp.negative()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(FSet.addLock(FactMan, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(Cp.$not(), LockKind.LK_Exclusive, UnlockLoc)))))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LockableFactEntry::~LockableFactEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 813,
   FQN="(anonymous namespace)::LockableFactEntry::~LockableFactEntry", NM="_ZN12_GLOBAL__N_117LockableFactEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_117LockableFactEntryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  public LockableFactEntry(LockableFactEntry $Prm0) {
    super($Prm0);
    this.Managed = $Prm0.Managed;
  }
  
  @Override public LockableFactEntry clone() { 
    return new LockableFactEntry(this); 
  }
  
  @Override public String toString() {
    return "" + "Managed=" + Managed // NOI18N
              + super.toString(); // NOI18N
  }
}
