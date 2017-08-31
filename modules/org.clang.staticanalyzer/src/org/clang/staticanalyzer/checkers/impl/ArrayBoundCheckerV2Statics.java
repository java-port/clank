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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clank.support.Native.$createJavaCleaner;


//<editor-fold defaultstate="collapsed" desc="static type ArrayBoundCheckerV2Statics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.ArrayBoundCheckerV2Statics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZL10scaleValueN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_6NonLocENS1_9CharUnitsERNS2_11SValBuilderE;_ZL18computeExtentBeginRN5clang4ento11SValBuilderEPKNS0_9MemRegionE;_ZL8addValueN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValES6_RNS2_11SValBuilderE;_ZL8getValueN5clang4ento4SValERNS0_11SValBuilderE; -static-type=ArrayBoundCheckerV2Statics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class ArrayBoundCheckerV2Statics {

//<editor-fold defaultstate="collapsed" desc="computeExtentBegin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 68,
 FQN="computeExtentBegin", NM="_ZL18computeExtentBeginRN5clang4ento11SValBuilderEPKNS0_9MemRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZL18computeExtentBeginRN5clang4ento11SValBuilderEPKNS0_9MemRegionE")
//</editor-fold>
public static SVal computeExtentBegin(final SValBuilder /*&*/ svalBuilder, 
                  /*const*/ MemRegion /*P*/ region) {
  while (true) {
    switch (region.getKind()) {
     default:
      return new SVal(JD$Move.INSTANCE, svalBuilder.makeZeroArrayIndex());
     case SymbolicRegionKind:
      // FIXME: improve this later by tracking symbolic lower bounds
      // for symbolic regions.
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
     case ElementRegionKind:
      region = cast_SubRegion(region).getSuperRegion();
      continue;
    }
  }
}


// Lazily computes a value to be used by 'computeOffset'.  If 'val'
// is unknown or undefined, we lazily substitute '0'.  Otherwise,
// return 'val'.
//<editor-fold defaultstate="collapsed" desc="getValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 226,
 FQN="getValue", NM="_ZL8getValueN5clang4ento4SValERNS0_11SValBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZL8getValueN5clang4ento4SValERNS0_11SValBuilderE")
//</editor-fold>
public static /*inline*/ SVal getValue(SVal val, final SValBuilder /*&*/ svalBuilder) {
  return val.getAs(UndefinedVal.class).$bool() ? new SVal(JD$Move.INSTANCE, svalBuilder.makeArrayIndex($int2ulong(0))) : new SVal(val);
}


// Scale a base value by a scaling factor, and return the scaled
// value as an SVal.  Used by 'computeOffset'.
//<editor-fold defaultstate="collapsed" desc="scaleValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 232,
 FQN="scaleValue", NM="_ZL10scaleValueN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_6NonLocENS1_9CharUnitsERNS2_11SValBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZL10scaleValueN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_6NonLocENS1_9CharUnitsERNS2_11SValBuilderE")
//</editor-fold>
public static /*inline*/ SVal scaleValue(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
          NonLoc baseVal, CharUnits scaling, 
          final SValBuilder /*&*/ sb) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(sb.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Mul, new NonLoc(baseVal), 
        sb.makeArrayIndex(scaling.getQuantity()), 
        sb.getArrayIndexType()));
  } finally {
   $c$.$destroy();
  }
}


// Add an SVal to another, treating unknown and undefined values as
// summing to UnknownVal.  Used by 'computeOffset'.
//<editor-fold defaultstate="collapsed" desc="addValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 242,
 FQN="addValue", NM="_ZL8addValueN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValES6_RNS2_11SValBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZL8addValueN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValES6_RNS2_11SValBuilderE")
//</editor-fold>
public static SVal addValue(IntrusiveRefCntPtr</*const*/ ProgramState> state, SVal x, SVal y, 
        final SValBuilder /*&*/ svalBuilder) {
  JavaCleaner $c$ = $createJavaCleaner();
  try { 
    // We treat UnknownVals and UndefinedVals the same here because we
    // only care about computing offsets.
    if (x.isUnknownOrUndef$SVal() || y.isUnknownOrUndef$SVal()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }

    return $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Add, x.castAs(NonLoc.class), 
        y.castAs(NonLoc.class), 
        svalBuilder.getArrayIndexType()));
  } finally {
   $c$.$destroy();
  } 
}

} // END OF class ArrayBoundCheckerV2Statics
