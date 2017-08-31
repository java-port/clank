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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.clang.basic.*;
import org.clang.basic.java.OptionalNotes;

//<editor-fold defaultstate="collapsed" desc="clang::(anonymous namespace)::SortDiagBySourceLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1453,
 FQN="clang::(anonymous namespace)::SortDiagBySourceLocation", NM="_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationE")
//</editor-fold>
public class/*struct*/ SortDiagBySourceLocation implements Compare<std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes >> {
  public final SourceManager /*&*/ SM;
  //<editor-fold defaultstate="collapsed" desc="clang::(anonymous namespace)::SortDiagBySourceLocation::SortDiagBySourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1455,
   FQN="clang::(anonymous namespace)::SortDiagBySourceLocation::SortDiagBySourceLocation", NM="_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationC1ERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationC1ERNS_13SourceManagerE")
  //</editor-fold>
  public SortDiagBySourceLocation(final SourceManager /*&*/ SM) {
    // : SM(SM) 
    //START JInit
    this./*&*/SM=/*&*/SM;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::(anonymous namespace)::SortDiagBySourceLocation::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1457,
   FQN="clang::(anonymous namespace)::SortDiagBySourceLocation::operator()", NM="_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationclERKSt4pairIS2_INS_14SourceLocationENS_17PartialDiagnosticEEN4llvm11SmallVectorIS5_Lj1EEEESB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationclERKSt4pairIS2_INS_14SourceLocationENS_17PartialDiagnosticEEN4llvm11SmallVectorIS5_Lj1EEEESB_")
  //</editor-fold>
  public boolean $call(final /*const*/ std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes > /*&*/ left, final /*const*/ std.pairTypeType<std.pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes > /*&*/ right) {
    // Although this call will be slow, this is only called when outputting
    // multiple warnings.
    return SM.isBeforeInTranslationUnit(/*NO_COPY*/left.first.first, /*NO_COPY*/right.first.first);
  }

  @Override
  public boolean compare(pairTypeType<pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes> a, pairTypeType<pairTypeType<SourceLocation, PartialDiagnostic>, OptionalNotes> b) {
    return $call(a, b);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::(anonymous namespace)::SortDiagBySourceLocation::SortDiagBySourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1453,
   FQN="clang::(anonymous namespace)::SortDiagBySourceLocation::SortDiagBySourceLocation", NM="_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationC1ERKS1_")
  //</editor-fold>
  public /*inline*/ SortDiagBySourceLocation(final /*const*/ SortDiagBySourceLocation /*&*/ $Prm0) {
    // : SM(.SM) 
    //START JInit
    this./*&*/SM=/*&*/$Prm0.SM;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::(anonymous namespace)::SortDiagBySourceLocation::SortDiagBySourceLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1453,
   FQN="clang::(anonymous namespace)::SortDiagBySourceLocation::SortDiagBySourceLocation", NM="_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang12_GLOBAL__N_124SortDiagBySourceLocationC1EOS1_")
  //</editor-fold>
  public /*inline*/ SortDiagBySourceLocation(JD$Move _dparam, final SortDiagBySourceLocation /*&&*/$Prm0) {
    // : SM(static_cast<SortDiagBySourceLocation &&>().SM) 
    //START JInit
    this./*&*/SM=/*&*/$Prm0.SM;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "SM=" + "[SourceManager]"; // NOI18N
  }
}
