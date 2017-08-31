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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import org.clang.staticanalyzer.java.CheckBase;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 70,
 FQN="(anonymous namespace)::CallDumper", NM="_ZN12_GLOBAL__N_110CallDumperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN12_GLOBAL__N_110CallDumperE")
//</editor-fold>
public class CallDumper extends /*public*/ Checker/*<PreCall, PostCall> */
        implements org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostCallChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDumper::checkPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 78,
   FQN="(anonymous namespace)::CallDumper::checkPreCall", NM="_ZNK12_GLOBAL__N_110CallDumper12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZNK12_GLOBAL__N_110CallDumper12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, final CheckerContext /*&*/ C) /*const*/ {
    /*uint*/int Indentation = 0;
    for (/*const*/ LocationContext /*P*/ LC = C.getLocationContext().getParent();
         LC != null; LC = LC.getParent())  {
      ++Indentation;
    }
    
    // It is mildly evil to print directly to llvm::outs() rather than emitting
    // warnings, but this ensures things do not get filtered out by the rest of
    // the static analyzer machinery.
    llvm.outs().indent(Indentation);
    Call.dump(llvm.outs());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDumper::checkPostCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 91,
   FQN="(anonymous namespace)::CallDumper::checkPostCall", NM="_ZNK12_GLOBAL__N_110CallDumper13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZNK12_GLOBAL__N_110CallDumper13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ Call, final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ Expr /*P*/ CallE = Call.getOriginExpr();
    if (!(CallE != null)) {
      return;
    }
    
    /*uint*/int Indentation = 0;
    for (/*const*/ LocationContext /*P*/ LC = C.getLocationContext().getParent();
         LC != null; LC = LC.getParent())  {
      ++Indentation;
    }
    
    // It is mildly evil to print directly to llvm::outs() rather than emitting
    // warnings, but this ensures things do not get filtered out by the rest of
    // the static analyzer machinery.
    llvm.outs().indent(Indentation);
    if (Call.getResultType().$arrow().isVoidType()) {
      llvm.outs().$out(/*KEEP_STR*/"Returning void\n");
    } else {
      $out_raw_ostream_SVal(llvm.outs().$out(/*KEEP_STR*/"Returning "), C.getSVal(CallE)).$out(/*KEEP_STR*/$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDumper::~CallDumper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 70,
   FQN="(anonymous namespace)::CallDumper::~CallDumper", NM="_ZN12_GLOBAL__N_110CallDumperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN12_GLOBAL__N_110CallDumperD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallDumper::CallDumper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp", line = 70,
   FQN="(anonymous namespace)::CallDumper::CallDumper", NM="_ZN12_GLOBAL__N_110CallDumperC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/TraversalChecker.cpp -nm=_ZN12_GLOBAL__N_110CallDumperC1Ev")
  //</editor-fold>
  public /*inline*/ CallDumper() {
    // : Checker<PreCall, PostCall>() 
    //START JInit
    super();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new PreCall(),
    new PostCall()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
