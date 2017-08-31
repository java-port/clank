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
package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type UnixAPICheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZL20IsZeroByteAllocationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValEPS5_S7_; -static-type=UnixAPICheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class UnixAPICheckerStatics {


//===----------------------------------------------------------------------===//
// "calloc", "malloc", "realloc", "reallocf", "alloca" and "valloc"
// with allocation size 0
//===----------------------------------------------------------------------===//
// FIXME: Eventually these should be rolled into the MallocChecker, but right now
// they're more basic and valuable for widespread use.

// Returns true if we try to do a zero byte allocation, false otherwise.
// Fills in trueState and falseState.
//<editor-fold defaultstate="collapsed" desc="IsZeroByteAllocation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp", line = 217,
 FQN="IsZeroByteAllocation", NM="_ZL20IsZeroByteAllocationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValEPS5_S7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UnixAPIChecker.cpp -nm=_ZL20IsZeroByteAllocationN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValEPS5_S7_")
//</editor-fold>
public static boolean IsZeroByteAllocation(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
                    /*const*/ SVal argVal, 
                    IntrusiveRefCntPtr</*const*/ ProgramState> /*P*/ trueState, 
                    IntrusiveRefCntPtr</*const*/ ProgramState> /*P*/ falseState) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
//    $c$.clean(std.tie(/*Deref*/trueState, /*Deref*/falseState).$assign(
//        $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(JD$Move.INSTANCE, argVal.castAs(DefinedSVal.class))))
//    ));
    // JAVA: unfold std.tie
    std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
            $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(JD$Move.INSTANCE, argVal.castAs(DefinedSVal.class))));
    trueState.$assign($assume.first);
    falseState.$assign($assume.second);
    // states could swap here with input states, so no need for assert below, but need clean up to manage refCounts
    if (false) {
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
    }
    $c$.clean();
      
    return ($Deref(falseState).$bool() && !$Deref(trueState).$bool());
  } finally {
    $c$.$destroy();
  }
}

} // END OF class UnixAPICheckerStatics
