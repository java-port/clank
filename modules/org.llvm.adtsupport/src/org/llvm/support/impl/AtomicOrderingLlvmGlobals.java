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
package org.llvm.support.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type AtomicOrderingLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=Tpl__ZN4llvmL21isValidAtomicOrderingET_;Tpl__ZN4llvmL25isValidAtomicOrderingCABIET_;_ZN4llvmL10toIRStringENS_14AtomicOrderingE;_ZN4llvmL14isStrongerThanENS_14AtomicOrderingES0_;_ZN4llvmL19isAcquireOrStrongerENS_14AtomicOrderingE;_ZN4llvmL19isReleaseOrStrongerENS_14AtomicOrderingE;_ZN4llvmL23isAtLeastOrStrongerThanENS_14AtomicOrderingES0_;_ZN4llvmL23isStrongerThanMonotonicENS_14AtomicOrderingE;_ZN4llvmL23isStrongerThanUnorderedENS_14AtomicOrderingE;_ZN4llvmL6toCABIENS_14AtomicOrderingE; -static-type=AtomicOrderingLlvmGlobals -package=org.llvm.support.impl")
//</editor-fold>
public final class AtomicOrderingLlvmGlobals {


// Validate an integral value which isn't known to fit within the enum's range
// is a valid AtomicOrderingCABI.
/*template <typename Int> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isValidAtomicOrderingCABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 45,
 FQN="llvm::isValidAtomicOrderingCABI", NM="Tpl__ZN4llvmL25isValidAtomicOrderingCABIET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=Tpl__ZN4llvmL25isValidAtomicOrderingCABIET_")
//</editor-fold>
public static /*inline*/ boolean isValidAtomicOrderingCABI(long/*int64*/ I) {
  return Native.$bool(Native.$lesseq((AtomicOrderingCABI.relaxed.getValue()), I))
     && Native.$bool(Native.$lesseq(I, (AtomicOrderingCABI.seq_cst.getValue())));
}


// Validate an integral value which isn't known to fit within the enum's range
// is a valid AtomicOrdering.
/*template <typename Int> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::isValidAtomicOrdering">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 75,
 FQN="llvm::isValidAtomicOrdering", NM="Tpl__ZN4llvmL21isValidAtomicOrderingET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=Tpl__ZN4llvmL21isValidAtomicOrderingET_")
//</editor-fold>
public static /*inline*/ boolean isValidAtomicOrdering(long/*int64*/ I) {
  return Native.$bool(Native.$lesseq((AtomicOrdering.NotAtomic.getValue()), I))
     && Native.$bool(Native.$lesseq(I, (AtomicOrdering.SequentiallyConsistent.getValue())));
}


/// String used by LLVM IR to represent atomic ordering.
//<editor-fold defaultstate="collapsed" desc="llvm::toIRString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 81,
 FQN="llvm::toIRString", NM="_ZN4llvmL10toIRStringENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN4llvmL10toIRStringENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ /*const*/char$ptr/*char P*/ toIRString(AtomicOrdering ao) {
  final/*static*/ /*const*/char$ptr/*char P*/ names[/*8*/] = toIRString$$.names;
  return names[((/*size_t*/int)ao.getValue())];
}
private static final class toIRString$$ {
  static final/*static*/ /*const*/char$ptr/*char P*/ names[/*8*/] = (new /*const*/char$ptr/*char P*/ [/*8*/] {
  $("not_atomic"), $("unordered"), $("monotonic"), 
  $("consume"), $("acquire"), $("release"), 
  $("acq_rel"), $("seq_cst")});
}


/// Returns true if ao is stronger than other as defined by the AtomicOrdering
/// lattice, which is based on C++'s definition.
//<editor-fold defaultstate="collapsed" desc="llvm::isStrongerThan">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 90,
 FQN="llvm::isStrongerThan", NM="_ZN4llvmL14isStrongerThanENS_14AtomicOrderingES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN4llvmL14isStrongerThanENS_14AtomicOrderingES0_")
//</editor-fold>
public static /*inline*/ boolean isStrongerThan(AtomicOrdering ao, AtomicOrdering other) {
  final/*static*/ /*const*/boolean lookup[/*8*/][/*8*/] = isStrongerThan$$.lookup;
  return lookup[((/*size_t*/int)ao.getValue())][((/*size_t*/int)other.getValue())];
}
private static final class isStrongerThan$$ {
  static final/*static*/ /*const*/boolean lookup[/*8*/][/*8*/] = new /*const*/boolean [/*8*/][/*8*/] {
  //               NA UN RX CO AC RE AR SC
  /* NotAtomic */ new /*const*/boolean [/*8*/] {false, false, false, false, false, false, false, false}, 
  /* Unordered */ new /*const*/boolean [/*8*/] {true, false, false, false, false, false, false, false}, 
  /* relaxed   */ new /*const*/boolean [/*8*/] {true, true, false, false, false, false, false, false}, 
  /* consume   */ new /*const*/boolean [/*8*/] {true, true, true, false, false, false, false, false}, 
  /* acquire   */ new /*const*/boolean [/*8*/] {true, true, true, true, false, false, false, false}, 
  /* release   */ new /*const*/boolean [/*8*/] {true, true, true, false, false, false, false, false}, 
  /* acq_rel   */ new /*const*/boolean [/*8*/] {true, true, true, true, true, true, false, false}, 
  /* seq_cst   */ new /*const*/boolean [/*8*/] {true, true, true, true, true, true, true, false}
};
}

//<editor-fold defaultstate="collapsed" desc="llvm::isAtLeastOrStrongerThan">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 105,
 FQN="llvm::isAtLeastOrStrongerThan", NM="_ZN4llvmL23isAtLeastOrStrongerThanENS_14AtomicOrderingES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN4llvmL23isAtLeastOrStrongerThanENS_14AtomicOrderingES0_")
//</editor-fold>
public static /*inline*/ boolean isAtLeastOrStrongerThan(AtomicOrdering ao, 
                       AtomicOrdering other) {
  final/*static*/ /*const*/boolean lookup[/*8*/][/*8*/] = isAtLeastOrStrongerThan$$.lookup;
  return lookup[((/*size_t*/int)ao.getValue())][((/*size_t*/int)other.getValue())];
}
private static final class isAtLeastOrStrongerThan$$ {
  static final/*static*/ /*const*/boolean lookup[/*8*/][/*8*/] = new /*const*/boolean [/*8*/][/*8*/] {
  //               NA UN RX CO AC RE AR SC
  /* NotAtomic */ new /*const*/boolean [/*8*/] {true, false, false, false, false, false, false, false}, 
  /* Unordered */ new /*const*/boolean [/*8*/] {true, true, false, false, false, false, false, false}, 
  /* relaxed   */ new /*const*/boolean [/*8*/] {true, true, true, false, false, false, false, false}, 
  /* consume   */ new /*const*/boolean [/*8*/] {true, true, true, true, false, false, false, false}, 
  /* acquire   */ new /*const*/boolean [/*8*/] {true, true, true, true, true, false, false, false}, 
  /* release   */ new /*const*/boolean [/*8*/] {true, true, true, false, false, true, false, false}, 
  /* acq_rel   */ new /*const*/boolean [/*8*/] {true, true, true, true, true, true, true, false}, 
  /* seq_cst   */ new /*const*/boolean [/*8*/] {true, true, true, true, true, true, true, true}
};
}

//<editor-fold defaultstate="collapsed" desc="llvm::isStrongerThanUnordered">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 121,
 FQN="llvm::isStrongerThanUnordered", NM="_ZN4llvmL23isStrongerThanUnorderedENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN4llvmL23isStrongerThanUnorderedENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ boolean isStrongerThanUnordered(AtomicOrdering ao) {
  return isStrongerThan(ao, AtomicOrdering.Unordered);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isStrongerThanMonotonic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 125,
 FQN="llvm::isStrongerThanMonotonic", NM="_ZN4llvmL23isStrongerThanMonotonicENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN4llvmL23isStrongerThanMonotonicENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ boolean isStrongerThanMonotonic(AtomicOrdering ao) {
  return isStrongerThan(ao, AtomicOrdering.Monotonic);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isAcquireOrStronger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 129,
 FQN="llvm::isAcquireOrStronger", NM="_ZN4llvmL19isAcquireOrStrongerENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN4llvmL19isAcquireOrStrongerENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ boolean isAcquireOrStronger(AtomicOrdering ao) {
  return isAtLeastOrStrongerThan(ao, AtomicOrdering.Acquire);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isReleaseOrStronger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 133,
 FQN="llvm::isReleaseOrStronger", NM="_ZN4llvmL19isReleaseOrStrongerENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN4llvmL19isReleaseOrStrongerENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ boolean isReleaseOrStronger(AtomicOrdering ao) {
  return isAtLeastOrStrongerThan(ao, AtomicOrdering.Release);
}

//<editor-fold defaultstate="collapsed" desc="llvm::toCABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/AtomicOrdering.h", line = 137,
 FQN="llvm::toCABI", NM="_ZN4llvmL6toCABIENS_14AtomicOrderingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/LoopWidening.cpp -nm=_ZN4llvmL6toCABIENS_14AtomicOrderingE")
//</editor-fold>
public static /*inline*/ AtomicOrderingCABI toCABI(AtomicOrdering ao) {
  final/*static*/ /*const*/ AtomicOrderingCABI lookup[/*8*/] = toCABI$$.lookup;
  return lookup[((/*size_t*/int)ao.getValue())];
}
private static final class toCABI$$ {
  static final/*static*/ /*const*/ AtomicOrderingCABI lookup[/*8*/] = new /*const*/ AtomicOrderingCABI [/*8*/] {
  /* NotAtomic */ AtomicOrderingCABI.relaxed, 
  /* Unordered */ AtomicOrderingCABI.relaxed, 
  /* relaxed   */ AtomicOrderingCABI.relaxed, 
  /* consume   */ AtomicOrderingCABI.consume, 
  /* acquire   */ AtomicOrderingCABI.acquire, 
  /* release   */ AtomicOrderingCABI.release, 
  /* acq_rel   */ AtomicOrderingCABI.acq_rel, 
  /* seq_cst   */ AtomicOrderingCABI.seq_cst
};
}

} // END OF class AtomicOrderingLlvmGlobals
