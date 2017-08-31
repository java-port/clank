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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.analyses.threadSafety.*;


/// \brief A FactSet is the set of facts that are known to be true at a
/// particular program point.  FactSets must be small, because they are
/// frequently copied, and are thus implemented as a set of indices into a
/// table maintained by a FactManager.  A typical FactSet only holds 1 or 2
/// locks, so we can get away with doing a linear search for lookup.  Note
/// that a hashtable or map is inappropriate in this case, because lookups
/// may involve partial pattern matches, rather than exact matches.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 161,
 FQN="(anonymous namespace)::FactSet", NM="_ZN12_GLOBAL__N_17FactSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSetE")
//</editor-fold>
public class FactSet implements Iterable<Character>, Destructors.ClassWithDestructor {
/*private:*/
  /*typedef SmallVector<FactID, 4> FactVec*/
//  public final class FactVec extends SmallVectorUShort{ };
  
  private SmallVectorUShort FactIDs;
/*public:*/
  /*typedef FactVec::iterator iterator*/;
  /*typedef FactVec::const_iterator const_iterator*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 171,
   FQN="(anonymous namespace)::FactSet::begin", NM="_ZN12_GLOBAL__N_17FactSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSet5beginEv")
  //</editor-fold>
  public ushort$ptr/*ushort P*/ begin() {
    return FactIDs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 172,
   FQN="(anonymous namespace)::FactSet::begin", NM="_ZNK12_GLOBAL__N_17FactSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_17FactSet5beginEv")
  //</editor-fold>
  public /*const*/ushort$ptr/*ushort P*/ begin$Const() /*const*/ {
    return FactIDs.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 174,
   FQN="(anonymous namespace)::FactSet::end", NM="_ZN12_GLOBAL__N_17FactSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSet3endEv")
  //</editor-fold>
  public ushort$ptr/*ushort P*/ end() {
    return FactIDs.end();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 175,
   FQN="(anonymous namespace)::FactSet::end", NM="_ZNK12_GLOBAL__N_17FactSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_17FactSet3endEv")
  //</editor-fold>
  public /*const*/ushort$ptr/*ushort P*/ end$Const() /*const*/ {
    return FactIDs.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 177,
   FQN="(anonymous namespace)::FactSet::isEmpty", NM="_ZNK12_GLOBAL__N_17FactSet7isEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_17FactSet7isEmptyEv")
  //</editor-fold>
  public boolean isEmpty() /*const*/ {
    return FactIDs.size() == 0;
  }

  
  // Return true if the set contains only negative facts
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::isEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 180,
   FQN="(anonymous namespace)::FactSet::isEmpty", NM="_ZNK12_GLOBAL__N_17FactSet7isEmptyERNS_11FactManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_17FactSet7isEmptyERNS_11FactManagerE")
  //</editor-fold>
  public boolean isEmpty(final FactManager /*&*/ FactMan) /*const*/ {
    for (/*ushort*/char FID : /*Deref*/this) {
      if (!FactMan.$at(FID).negative()) {
        return false;
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::addLockByID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 188,
   FQN="(anonymous namespace)::FactSet::addLockByID", NM="_ZN12_GLOBAL__N_17FactSet11addLockByIDEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSet11addLockByIDEt")
  //</editor-fold>
  public void addLockByID(/*ushort*/char ID) {
    FactIDs.push_back(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::addLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 190,
   FQN="(anonymous namespace)::FactSet::addLock", NM="_ZN12_GLOBAL__N_17FactSet7addLockERNS_11FactManagerESt10unique_ptrINS_9FactEntryESt14default_deleteIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSet7addLockERNS_11FactManagerESt10unique_ptrINS_9FactEntryESt14default_deleteIS4_EE")
  //</editor-fold>
  public /*ushort*/char addLock(final FactManager /*&*/ FM, std.unique_ptr<FactEntry> Entry) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*ushort*/char F = $c$.clean(FM.newFact($c$.track(new std.unique_ptr<FactEntry>(JD$Move.INSTANCE, std.move(Entry)))));
      FactIDs.push_back(F);
      return F;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::removeLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 196,
   FQN="(anonymous namespace)::FactSet::removeLock", NM="_ZN12_GLOBAL__N_17FactSet10removeLockERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSet10removeLockERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE")
  //</editor-fold>
  public boolean removeLock(final FactManager /*&*/ FM, final /*const*/ CapabilityExpr /*&*/ CapE) {
    /*uint*/int n = FactIDs.size();
    if (n == 0) {
      return false;
    }
    
    for (/*uint*/int i = 0; $less_uint(i, n - 1); ++i) {
      if (FM.$at(FactIDs.$at(i)).matches(CapE)) {
        FactIDs.$set(i, FactIDs.$at(n - 1));
        FactIDs.pop_back();
        return true;
      }
    }
    if (FM.$at(FactIDs.$at(n - 1)).matches(CapE)) {
      FactIDs.pop_back();
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::findLockIter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 215,
   FQN="(anonymous namespace)::FactSet::findLockIter", NM="_ZN12_GLOBAL__N_17FactSet12findLockIterERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSet12findLockIterERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE")
  //</editor-fold>
  public ushort$ptr/*ushort P*/ findLockIter(final FactManager /*&*/ FM, final /*const*/ CapabilityExpr /*&*/ CapE) {
    return std.find_if(begin(), end(), /*[&, &FM, &CapE]*/ (/*ushort*/char ID) -> {
              return FM.$at(ID).matches(CapE);
            });
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::findLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 221,
   FQN="(anonymous namespace)::FactSet::findLock", NM="_ZNK12_GLOBAL__N_17FactSet8findLockERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_17FactSet8findLockERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE")
  //</editor-fold>
  public FactEntry /*P*/ findLock(final FactManager /*&*/ FM, final /*const*/ CapabilityExpr /*&*/ CapE) /*const*/ {
    /*const*/ushort$ptr/*ushort P*/ I = $tryClone(std.find_if(begin$Const(), end$Const(), /*[&, &FM, &CapE]*/ (/*ushort*/char ID) -> {
              return FM.$at(ID).matches(CapE);
            }));
    return $noteq_ptr(I, end$Const()) ? $AddrOf(FM.$at(I.$star())) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::findLockUniv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 228,
   FQN="(anonymous namespace)::FactSet::findLockUniv", NM="_ZNK12_GLOBAL__N_17FactSet12findLockUnivERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_17FactSet12findLockUnivERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE")
  //</editor-fold>
  public FactEntry /*P*/ findLockUniv(final FactManager /*&*/ FM, final /*const*/ CapabilityExpr /*&*/ CapE) /*const*/ {
    /*const*/ushort$ptr/*ushort P*/ I = $tryClone(std.find_if(begin$Const(), end$Const(), /*[&, &FM, &CapE]*/ (/*ushort*/char ID) -> {
              return FM.$at(ID).matchesUniv(CapE);
            }));
    return $noteq_ptr(I, end$Const()) ? $AddrOf(FM.$at(I.$star())) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::findPartialMatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 235,
   FQN="(anonymous namespace)::FactSet::findPartialMatch", NM="_ZNK12_GLOBAL__N_17FactSet16findPartialMatchERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_17FactSet16findPartialMatchERNS_11FactManagerERKN5clang12threadSafety14CapabilityExprE")
  //</editor-fold>
  public FactEntry /*P*/ findPartialMatch(final FactManager /*&*/ FM, 
                  final /*const*/ CapabilityExpr /*&*/ CapE) /*const*/ {
    /*const*/ushort$ptr/*ushort P*/ I = $tryClone(std.find_if(begin$Const(), end$Const(), /*[&, &FM, &CapE]*/ (/*ushort*/char ID) -> {
              return FM.$at(ID).partiallyMatches(CapE);
            }));
    return $noteq_ptr(I, end$Const()) ? $AddrOf(FM.$at(I.$star())) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::containsMutexDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 243,
   FQN="(anonymous namespace)::FactSet::containsMutexDecl", NM="_ZNK12_GLOBAL__N_17FactSet17containsMutexDeclERNS_11FactManagerEPKN5clang9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_17FactSet17containsMutexDeclERNS_11FactManagerEPKN5clang9ValueDeclE")
  //</editor-fold>
  public boolean containsMutexDecl(final FactManager /*&*/ FM, /*const*/ ValueDecl /*P*/ Vd) /*const*/ {
    /*const*/ushort$ptr/*ushort P*/ I = $tryClone(std.find_if(begin$Const(), end$Const(), /*[&, &FM, &Vd]*/ (/*ushort*/char ID) -> {
              return FM.$at(ID).valueDecl() == Vd;
            }));
    return $noteq_ptr(I, end$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::FactSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 161,
   FQN="(anonymous namespace)::FactSet::FactSet", NM="_ZN12_GLOBAL__N_17FactSetC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSetC1EOS0_")
  //</editor-fold>
  public /*inline*/ FactSet(JD$Move _dparam, final FactSet /*&&*/$Prm0) {
    // : FactIDs(static_cast<FactSet &&>().FactIDs) 
    //START JInit
    this.FactIDs = new SmallVectorUShort(JD$Move.INSTANCE, $Prm0.FactIDs);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 161,
   FQN="(anonymous namespace)::FactSet::operator=", NM="_ZN12_GLOBAL__N_17FactSetaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSetaSEOS0_")
  //</editor-fold>
  public /*inline*/ FactSet /*&*/ $assignMove(final FactSet /*&&*/$Prm0) {
    this.FactIDs.$assignMove($Prm0.FactIDs);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::FactSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 161,
   FQN="(anonymous namespace)::FactSet::FactSet", NM="_ZN12_GLOBAL__N_17FactSetC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSetC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FactSet(final /*const*/ FactSet /*&*/ $Prm0) {
    // : FactIDs(.FactIDs) 
    //START JInit
    this.FactIDs = new SmallVectorUShort($Prm0.FactIDs);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::~FactSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 161,
   FQN="(anonymous namespace)::FactSet::~FactSet", NM="_ZN12_GLOBAL__N_17FactSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FactIDs.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 161,
   FQN="(anonymous namespace)::FactSet::operator=", NM="_ZN12_GLOBAL__N_17FactSetaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSetaSERKS0_")
  //</editor-fold>
  public /*inline*/ FactSet /*&*/ $assign(final /*const*/ FactSet /*&*/ $Prm0) {
    this.FactIDs.$assign($Prm0.FactIDs);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FactSet::FactSet">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 161,
   FQN="(anonymous namespace)::FactSet::FactSet", NM="_ZN12_GLOBAL__N_17FactSetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_17FactSetC1Ev")
  //</editor-fold>
  public /*inline*/ FactSet() {
    // : FactIDs() 
    //START JInit
    this.FactIDs = new SmallVectorUShort(4, (char)0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public JavaIteratorUShort iterator() { return new JavaIteratorUShort(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "FactIDs=" + FactIDs; // NOI18N
  }
}
