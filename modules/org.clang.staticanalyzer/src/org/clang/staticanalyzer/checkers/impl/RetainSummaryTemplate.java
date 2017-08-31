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
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clang.staticanalyzer.checkers.impl.*;


// Used to avoid allocating long-term (BPAlloc'd) memory for default retain
// summaries. If a function or method looks like it has a default summary, but
// it has annotations, the annotations are added to the stack-based template
// and then copied into managed memory.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 820,
 FQN="(anonymous namespace)::RetainSummaryTemplate", NM="_ZN12_GLOBAL__N_121RetainSummaryTemplateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_121RetainSummaryTemplateE")
//</editor-fold>
public class RetainSummaryTemplate implements Destructors.ClassWithDestructor {
  private final RetainSummaryManager /*&*/ Manager;
  private final type$ref</*const*/ RetainSummary /*P*/ /*&*/> RealSummary;
  private RetainSummary ScratchSummary;
  private boolean Accessed;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryTemplate::RetainSummaryTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 826,
   FQN="(anonymous namespace)::RetainSummaryTemplate::RetainSummaryTemplate", NM="_ZN12_GLOBAL__N_121RetainSummaryTemplateC1ERPKNS_13RetainSummaryERNS_20RetainSummaryManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_121RetainSummaryTemplateC1ERPKNS_13RetainSummaryERNS_20RetainSummaryManagerE")
  //</editor-fold>
  public RetainSummaryTemplate(final type$ref</*const*/ RetainSummary /*P*/ /*&*/> real, final RetainSummaryManager /*&*/ mgr) {
    // : Manager(mgr), RealSummary(real), ScratchSummary(*real), Accessed(false) 
    //START JInit
    this./*&*/Manager=/*&*/mgr;
    this./*&*/RealSummary=/*&*/real;
    this.ScratchSummary = new RetainSummary($Deref(real.$deref()));
    this.Accessed = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryTemplate::~RetainSummaryTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 829,
   FQN="(anonymous namespace)::RetainSummaryTemplate::~RetainSummaryTemplate", NM="_ZN12_GLOBAL__N_121RetainSummaryTemplateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_121RetainSummaryTemplateD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (Accessed) {
      RealSummary.$set(Manager.getPersistentSummary(ScratchSummary));
    }
    //START JDestroy
    ScratchSummary.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryTemplate::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 834,
   FQN="(anonymous namespace)::RetainSummaryTemplate::operator*", NM="_ZN12_GLOBAL__N_121RetainSummaryTemplatedeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_121RetainSummaryTemplatedeEv")
  //</editor-fold>
  public RetainSummary /*&*/ $star() {
    Accessed = true;
    return ScratchSummary;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RetainSummaryTemplate::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 839,
   FQN="(anonymous namespace)::RetainSummaryTemplate::operator->", NM="_ZN12_GLOBAL__N_121RetainSummaryTemplateptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_121RetainSummaryTemplateptEv")
  //</editor-fold>
  public RetainSummary /*P*/ $arrow() {
    Accessed = true;
    return $AddrOf(ScratchSummary);
  }

  
  @Override public String toString() {
    return "" + "Manager=" + "[RetainSummaryManager]" // NOI18N
              + ", RealSummary=" + RealSummary // NOI18N
              + ", ScratchSummary=" + ScratchSummary // NOI18N
              + ", Accessed=" + Accessed; // NOI18N
  }
}
