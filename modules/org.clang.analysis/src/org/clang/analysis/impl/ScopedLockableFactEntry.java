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
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.threadSafety.til.*;
import org.clang.analysis.analyses.threadSafety.*;
import org.clang.analysis.analyses.threadSafety.sx.SxGlobals;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedLockableFactEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 844,
 FQN="(anonymous namespace)::ScopedLockableFactEntry", NM="_ZN12_GLOBAL__N_123ScopedLockableFactEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_123ScopedLockableFactEntryE")
//</editor-fold>
public class ScopedLockableFactEntry extends /*public*/ FactEntry implements Destructors.ClassWithDestructor {
/*private:*/
  private SmallVector</*const*/ SExpr /*P*/ > UnderlyingMutexes;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedLockableFactEntry::ScopedLockableFactEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 849,
   FQN="(anonymous namespace)::ScopedLockableFactEntry::ScopedLockableFactEntry", NM="_ZN12_GLOBAL__N_123ScopedLockableFactEntryC1ERKN5clang12threadSafety14CapabilityExprENS1_14SourceLocationERKNS_10CapExprSetES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_123ScopedLockableFactEntryC1ERKN5clang12threadSafety14CapabilityExprENS1_14SourceLocationERKNS_10CapExprSetES9_")
  //</editor-fold>
  public ScopedLockableFactEntry(final /*const*/ CapabilityExpr /*&*/ CE, SourceLocation Loc, 
      final /*const*/ CapExprSet /*&*/ Excl, final /*const*/ CapExprSet /*&*/ Shrd) {
    // : FactEntry(CE, LK_Exclusive, Loc, false), UnderlyingMutexes() 
    //START JInit
    super(CE, LockKind.LK_Exclusive, new SourceLocation(Loc), false);
    this.UnderlyingMutexes = new SmallVector</*const*/ SExpr /*P*/ >(4, (/*const*/ SExpr /*P*/ )null);
    //END JInit
    for (final /*const*/ CapabilityExpr /*&*/ M : Excl)  {
      UnderlyingMutexes.push_back(M.sexpr());
    }
    for (final /*const*/ CapabilityExpr /*&*/ M : Shrd)  {
      UnderlyingMutexes.push_back(M.sexpr());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedLockableFactEntry::handleRemovalFromIntersection">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 858,
   FQN="(anonymous namespace)::ScopedLockableFactEntry::handleRemovalFromIntersection", NM="_ZNK12_GLOBAL__N_123ScopedLockableFactEntry29handleRemovalFromIntersectionERKNS_7FactSetERNS_11FactManagerEN5clang14SourceLocationENS6_12threadSafety13LockErrorKindERNS8_19ThreadSafetyHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_123ScopedLockableFactEntry29handleRemovalFromIntersectionERKNS_7FactSetERNS_11FactManagerEN5clang14SourceLocationENS6_12threadSafety13LockErrorKindERNS8_19ThreadSafetyHandlerE")
  //</editor-fold>
  @Override public void handleRemovalFromIntersection(final /*const*/ FactSet /*&*/ FSet, final FactManager /*&*/ FactMan, 
                               SourceLocation JoinLoc, LockErrorKind LEK, 
                               final ThreadSafetyHandler /*&*/ Handler) /*const*//* override*/ {
    for (/*const*/ SExpr /*P*/ UnderlyingMutex : UnderlyingMutexes) {
      if ((FSet.findLock(FactMan, new CapabilityExpr(UnderlyingMutex, false)) != null)) {
        // If this scoped lock manages another mutex, and if the underlying
        // mutex is still held, then warn about the underlying mutex.
        Handler.handleMutexHeldEndOfScope(new StringRef(/*KEEP_STR*/"mutex"), new StringRef(SxGlobals.__toString(UnderlyingMutex)), loc(), new SourceLocation(JoinLoc), LEK);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedLockableFactEntry::handleUnlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 872,
   FQN="(anonymous namespace)::ScopedLockableFactEntry::handleUnlock", NM="_ZNK12_GLOBAL__N_123ScopedLockableFactEntry12handleUnlockERNS_7FactSetERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprENS5_14SourceLocationEbRNS6_19ThreadSafetyHandlerEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_123ScopedLockableFactEntry12handleUnlockERNS_7FactSetERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprENS5_14SourceLocationEbRNS6_19ThreadSafetyHandlerEN4llvm9StringRefE")
  //</editor-fold>
  @Override public void handleUnlock(final FactSet /*&*/ FSet, final FactManager /*&*/ FactMan, 
              final /*const*/ CapabilityExpr /*&*/ Cp, SourceLocation UnlockLoc, 
              boolean FullyRemove, final ThreadSafetyHandler /*&*/ Handler, 
              StringRef DiagKind) /*const*//* override*/ {
    assert (!Cp.negative()) : "Managing object cannot be negative.";
    for (/*const*/ SExpr /*P*/ UnderlyingMutex : UnderlyingMutexes) {
      unique_ptr<LockableFactEntry> UnderEntry = null;
      try {
        CapabilityExpr UnderCp/*J*/= new CapabilityExpr(UnderlyingMutex, false);
        UnderEntry = llvm.make_unique(new LockableFactEntry(UnderCp.$not(), LockKind.LK_Exclusive, UnlockLoc));
        if (FullyRemove) {
          // We're destroying the managing object.
          // Remove the underlying mutex if it exists; but don't warn.
          if ((FSet.findLock(FactMan, UnderCp) != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              FSet.removeLock(FactMan, UnderCp);
              $c$.clean(FSet.addLock(FactMan, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(UnderEntry)))));
            } finally {
              $c$.$destroy();
            }
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // We're releasing the underlying mutex, but not destroying the
            // managing object.  Warn on dual release.
            if (!(FSet.findLock(FactMan, UnderCp) != null)) {
              Handler.handleUnmatchedUnlock(new StringRef(DiagKind), new StringRef(UnderCp.__toString()), 
                  new SourceLocation(UnlockLoc));
            }
            FSet.removeLock(FactMan, UnderCp);
            $c$.clean(FSet.addLock(FactMan, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(UnderEntry)))));
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (UnderEntry != null) { UnderEntry.$destroy(); }
      }
    }
    if (FullyRemove) {
      FSet.removeLock(FactMan, Cp);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedLockableFactEntry::~ScopedLockableFactEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 844,
   FQN="(anonymous namespace)::ScopedLockableFactEntry::~ScopedLockableFactEntry", NM="_ZN12_GLOBAL__N_123ScopedLockableFactEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_123ScopedLockableFactEntryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    UnderlyingMutexes.$destroy();
    super.$destroy();
    //END JDestroy
  }

  public ScopedLockableFactEntry(ScopedLockableFactEntry $Prm0) {
    super($Prm0);
    this.UnderlyingMutexes = new SmallVector($Prm0.UnderlyingMutexes);
  }
  
  @Override public ScopedLockableFactEntry clone() { 
    return new ScopedLockableFactEntry(this); 
  }
  
  @Override public String toString() {
    return "" + "UnderlyingMutexes=" + UnderlyingMutexes // NOI18N
              + super.toString(); // NOI18N
  }
}
