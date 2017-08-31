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
package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


//<editor-fold defaultstate="collapsed" desc="static type SimpleSValBuilderStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZL31evalBinOpFieldRegionFieldRegionPKN5clang4ento11FieldRegionES3_NS_18BinaryOperatorKindENS_8QualTypeERN12_GLOBAL__N_117SimpleSValBuilderE; -static-type=SimpleSValBuilderStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class SimpleSValBuilderStatics {

//<editor-fold defaultstate="collapsed" desc="evalBinOpFieldRegionFieldRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp", line = 536,
 FQN="evalBinOpFieldRegionFieldRegion", NM="_ZL31evalBinOpFieldRegionFieldRegionPKN5clang4ento11FieldRegionES3_NS_18BinaryOperatorKindENS_8QualTypeERN12_GLOBAL__N_117SimpleSValBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SimpleSValBuilder.cpp -nm=_ZL31evalBinOpFieldRegionFieldRegionPKN5clang4ento11FieldRegionES3_NS_18BinaryOperatorKindENS_8QualTypeERN12_GLOBAL__N_117SimpleSValBuilderE")
//</editor-fold>
public static SVal evalBinOpFieldRegionFieldRegion(/*const*/ FieldRegion /*P*/ LeftFR, 
                               /*const*/ FieldRegion /*P*/ RightFR, 
                               BinaryOperatorKind op, 
                               QualType resultTy, 
                               final SimpleSValBuilder /*&*/ SVB) {
  // Only comparisons are meaningful here!
  if (!BinaryOperator.isComparisonOp(op)) {
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }
  
  // Next, see if the two FRs have the same super-region.
  // FIXME: This doesn't handle casts yet, and simply stripping the casts
  // doesn't help.
  if (LeftFR.getSuperRegion() != RightFR.getSuperRegion()) {
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }
  
  /*const*/ FieldDecl /*P*/ LeftFD = LeftFR.getDecl();
  /*const*/ FieldDecl /*P*/ RightFD = RightFR.getDecl();
  /*const*/ RecordDecl /*P*/ RD = LeftFD.getParent$Const();
  
  // Make sure the two FRs are from the same kind of record. Just in case!
  // FIXME: This is probably where inheritance would be a problem.
  if (RD != RightFD.getParent$Const()) {
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }
  
  // We know for sure that the two fields are not the same, since that
  // would have given us the same SVal.
  if (op == BinaryOperatorKind.BO_EQ) {
    return new SVal(JD$Move.INSTANCE, SVB.makeTruthVal(false, new QualType(resultTy)));
  }
  if (op == BinaryOperatorKind.BO_NE) {
    return new SVal(JD$Move.INSTANCE, SVB.makeTruthVal(true, new QualType(resultTy)));
  }
  
  // Iterate through the fields and see which one comes first.
  // [C99 6.7.2.1.13] "Within a structure object, the non-bit-field
  // members and the units in which bit-fields reside have addresses that
  // increase in the order in which they are declared."
  boolean leftFirst = (op == BinaryOperatorKind.BO_LT || op == BinaryOperatorKind.BO_LE);
  for (/*const*/ FieldDecl /*P*/ I : RD.fields()) {
    if (I == LeftFD) {
      return new SVal(JD$Move.INSTANCE, SVB.makeTruthVal(leftFirst, new QualType(resultTy)));
    }
    if (I == RightFD) {
      return new SVal(JD$Move.INSTANCE, SVB.makeTruthVal(!leftFirst, new QualType(resultTy)));
    }
  }
  throw new llvm_unreachable("Fields not found in parent record's definition");
}

} // END OF class SimpleSValBuilderStatics
