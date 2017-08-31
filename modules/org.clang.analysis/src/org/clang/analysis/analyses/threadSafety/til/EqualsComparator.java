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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.analysis.analyses.threadSafety.til.*;

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 302,
 FQN="clang::threadSafety::til::EqualsComparator", NM="_ZN5clang12threadSafety3til16EqualsComparatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparatorE")
//</editor-fold>
public class EqualsComparator extends /*public*/ Comparator<EqualsComparator> {
/*public:*/
  // Result type for the comparison, e.g. bool for simple equality,
  // or int for lexigraphic comparison (-1, 0, 1).  Must have one value which
  // denotes "true".
  /*typedef bool CType*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::trueResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 309,
   FQN="clang::threadSafety::til::EqualsComparator::trueResult", NM="_ZN5clang12threadSafety3til16EqualsComparator10trueResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator10trueResultEv")
  //</editor-fold>
  public boolean trueResult() {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::notTrue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 310,
   FQN="clang::threadSafety::til::EqualsComparator::notTrue", NM="_ZN5clang12threadSafety3til16EqualsComparator7notTrueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator7notTrueEb")
  //</editor-fold>
  public boolean notTrue(boolean ct) {
    return !ct;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::compareIntegers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 312,
   FQN="clang::threadSafety::til::EqualsComparator::compareIntegers", NM="_ZN5clang12threadSafety3til16EqualsComparator15compareIntegersEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator15compareIntegersEjj")
  //</editor-fold>
  public boolean compareIntegers(/*uint*/int i, /*uint*/int j) {
    return i == j;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::compareStrings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 313,
   FQN="clang::threadSafety::til::EqualsComparator::compareStrings", NM="_ZN5clang12threadSafety3til16EqualsComparator14compareStringsEN4llvm9StringRefES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator14compareStringsEN4llvm9StringRefES4_")
  //</editor-fold>
  public boolean compareStrings(StringRef s, StringRef r) {
    return $eq_StringRef(/*NO_COPY*/s, /*NO_COPY*/r);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::comparePointers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 314,
   FQN="clang::threadSafety::til::EqualsComparator::comparePointers", NM="_ZN5clang12threadSafety3til16EqualsComparator15comparePointersEPKvS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator15comparePointersEPKvS4_")
  //</editor-fold>
  public boolean comparePointers(/*const*/Object/*void P*/ P, /*const*/Object/*void P*/ Q) {
    return $eq_ptr(P, Q);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::compare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 316,
   FQN="clang::threadSafety::til::EqualsComparator::compare", NM="_ZN5clang12threadSafety3til16EqualsComparator7compareEPKNS1_5SExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator7compareEPKNS1_5SExprES5_")
  //</editor-fold>
  public boolean compare(/*const*/ SExpr /*P*/ E1, /*const*/ SExpr /*P*/ E2) {
    if (E1.opcode() != E2.opcode()) {
      return false;
    }
    return compareByCase(E1, E2);
  }

  
  // TODO -- handle alpha-renaming of variables
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::enterScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 323,
   FQN="clang::threadSafety::til::EqualsComparator::enterScope", NM="_ZN5clang12threadSafety3til16EqualsComparator10enterScopeEPKNS1_8VariableES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator10enterScopeEPKNS1_8VariableES5_")
  //</editor-fold>
  public void enterScope(/*const*/ Variable /*P*/ V1, /*const*/ Variable /*P*/ V2) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::leaveScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 324,
   FQN="clang::threadSafety::til::EqualsComparator::leaveScope", NM="_ZN5clang12threadSafety3til16EqualsComparator10leaveScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator10leaveScopeEv")
  //</editor-fold>
  public void leaveScope() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::compareVariableRefs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 326,
   FQN="clang::threadSafety::til::EqualsComparator::compareVariableRefs", NM="_ZN5clang12threadSafety3til16EqualsComparator19compareVariableRefsEPKNS1_8VariableES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator19compareVariableRefsEPKNS1_8VariableES5_")
  //</editor-fold>
  public boolean compareVariableRefs(/*const*/ Variable /*P*/ V1, /*const*/ Variable /*P*/ V2) {
    return V1 == V2;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::compareExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 330,
   FQN="clang::threadSafety::til::EqualsComparator::compareExprs", NM="_ZN5clang12threadSafety3til16EqualsComparator12compareExprsEPKNS1_5SExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparator12compareExprsEPKNS1_5SExprES5_")
  //</editor-fold>
  public static boolean compareExprs(/*const*/ SExpr /*P*/ E1, /*const*/ SExpr /*P*/ E2) {
    EqualsComparator Eq/*J*/= new EqualsComparator();
    return Eq.compare(E1, E2);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::EqualsComparator::EqualsComparator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTraverse.h", line = 302,
   FQN="clang::threadSafety::til::EqualsComparator::EqualsComparator", NM="_ZN5clang12threadSafety3til16EqualsComparatorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til16EqualsComparatorC1Ev")
  //</editor-fold>
  public /*inline*/ EqualsComparator() {
    // : Comparator<EqualsComparator>() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
