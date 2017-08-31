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

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.threadSafety.*;


/// \brief This is a helper class that stores a fact that is known at a
/// particular point in program execution.  Currently, a fact is a capability,
/// along with additional information, such as where it was acquired, whether
/// it is exclusive or shared, etc.
///
/// FIXME: this analysis does not currently support either re-entrant
/// locking or lock "upgrading" and "downgrading" between exclusive and
/// shared.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 97,
 FQN="(anonymous namespace)::FactEntry", NM="_ZN12_GLOBAL__N_19FactEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_19FactEntryE")
//</editor-fold>
public abstract class FactEntry extends /*public*/ CapabilityExpr implements Destructors.ClassWithDestructor {
/*private:*/
  private LockKind LKind; ///<  exclusive or shared
  private SourceLocation AcquireLoc; ///<  where it was acquired.
  private boolean Asserted; ///<  true if the lock was asserted
  private boolean Declared; ///<  true if the lock was declared
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::FactEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 105,
   FQN="(anonymous namespace)::FactEntry::FactEntry", NM="_ZN12_GLOBAL__N_19FactEntryC1ERKN5clang12threadSafety14CapabilityExprENS2_8LockKindENS1_14SourceLocationEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_19FactEntryC1ERKN5clang12threadSafety14CapabilityExprENS2_8LockKindENS1_14SourceLocationEbb")
  //</editor-fold>
  public FactEntry(final /*const*/ CapabilityExpr /*&*/ CE, LockKind LK, SourceLocation Loc, 
      boolean Asrt) {
    this(CE, LK, Loc, 
      Asrt, false);
  }
  public FactEntry(final /*const*/ CapabilityExpr /*&*/ CE, LockKind LK, SourceLocation Loc, 
      boolean Asrt, boolean Declrd/*= false*/) {
    // : CapabilityExpr(CE), LKind(LK), AcquireLoc(Loc), Asserted(Asrt), Declared(Declrd) 
    //START JInit
    super(CE);
    this.LKind = LK;
    this.AcquireLoc = new SourceLocation(Loc);
    this.Asserted = Asrt;
    this.Declared = Declrd;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::~FactEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 110,
   FQN="(anonymous namespace)::FactEntry::~FactEntry", NM="_ZN12_GLOBAL__N_19FactEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_19FactEntryD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 112,
   FQN="(anonymous namespace)::FactEntry::kind", NM="_ZNK12_GLOBAL__N_19FactEntry4kindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_19FactEntry4kindEv")
  //</editor-fold>
  public LockKind kind() /*const*/ {
    return LKind;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::loc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 113,
   FQN="(anonymous namespace)::FactEntry::loc", NM="_ZNK12_GLOBAL__N_19FactEntry3locEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_19FactEntry3locEv")
  //</editor-fold>
  public SourceLocation loc() /*const*/ {
    return new SourceLocation(AcquireLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::asserted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 114,
   FQN="(anonymous namespace)::FactEntry::asserted", NM="_ZNK12_GLOBAL__N_19FactEntry8assertedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_19FactEntry8assertedEv")
  //</editor-fold>
  public boolean asserted() /*const*/ {
    return Asserted;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::declared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 115,
   FQN="(anonymous namespace)::FactEntry::declared", NM="_ZNK12_GLOBAL__N_19FactEntry8declaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_19FactEntry8declaredEv")
  //</editor-fold>
  public boolean declared() /*const*/ {
    return Declared;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::setDeclared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 117,
   FQN="(anonymous namespace)::FactEntry::setDeclared", NM="_ZN12_GLOBAL__N_19FactEntry11setDeclaredEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_19FactEntry11setDeclaredEb")
  //</editor-fold>
  public void setDeclared(boolean D) {
    Declared = D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::handleRemovalFromIntersection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 119,
   FQN="(anonymous namespace)::FactEntry::handleRemovalFromIntersection", NM="_ZNK12_GLOBAL__N_19FactEntry29handleRemovalFromIntersectionERKNS_7FactSetERNS_11FactManagerEN5clang14SourceLocationENS6_12threadSafety13LockErrorKindERNS8_19ThreadSafetyHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_19FactEntry29handleRemovalFromIntersectionERKNS_7FactSetERNS_11FactManagerEN5clang14SourceLocationENS6_12threadSafety13LockErrorKindERNS8_19ThreadSafetyHandlerE")
  //</editor-fold>
  public abstract /*virtual*/ void handleRemovalFromIntersection(final /*const*/ FactSet /*&*/ FSet, final FactManager /*&*/ FactMan, 
                               SourceLocation JoinLoc, LockErrorKind LEK, 
                               final ThreadSafetyHandler /*&*/ Handler) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::handleUnlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 123,
   FQN="(anonymous namespace)::FactEntry::handleUnlock", NM="_ZNK12_GLOBAL__N_19FactEntry12handleUnlockERNS_7FactSetERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprENS5_14SourceLocationEbRNS6_19ThreadSafetyHandlerEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_19FactEntry12handleUnlockERNS_7FactSetERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprENS5_14SourceLocationEbRNS6_19ThreadSafetyHandlerEN4llvm9StringRefE")
  //</editor-fold>
  public abstract /*virtual*/ void handleUnlock(final FactSet /*&*/ FSet, final FactManager /*&*/ FactMan, 
              final /*const*/ CapabilityExpr /*&*/ Cp, SourceLocation UnlockLoc, 
              boolean FullyRemove, final ThreadSafetyHandler /*&*/ Handler, 
              StringRef DiagKind) /*const*//* = 0*/;

  
  // Return true if LKind >= LK, where exclusive > shared
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactEntry::isAtLeast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 129,
   FQN="(anonymous namespace)::FactEntry::isAtLeast", NM="_ZN12_GLOBAL__N_19FactEntry9isAtLeastEN5clang12threadSafety8LockKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_19FactEntry9isAtLeastEN5clang12threadSafety8LockKindE")
  //</editor-fold>
  public boolean isAtLeast(LockKind LK) {
    return (LKind == LockKind.LK_Exclusive) || (LK == LockKind.LK_Shared);
  }

  protected FactEntry(FactEntry $Prm0) {
    super($Prm0);
    this.LKind = $Prm0.LKind;
    this.AcquireLoc = new SourceLocation($Prm0.AcquireLoc);
    this.Asserted = $Prm0.Asserted;
    this.Declared = $Prm0.Declared;
  }
  
  @Override public abstract FactEntry clone();
  
  @Override public String toString() {
    return "" + "LKind=" + LKind // NOI18N
              + ", AcquireLoc=" + AcquireLoc // NOI18N
              + ", Asserted=" + Asserted // NOI18N
              + ", Declared=" + Declared // NOI18N
              + super.toString(); // NOI18N
  }
}
