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
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContextLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 910,
 FQN="(anonymous namespace)::ContextLocation", NM="_ZN12_GLOBAL__N_115ContextLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_115ContextLocationE")
//</editor-fold>
public class ContextLocation extends /*public*/ PathDiagnosticLocation {
  private boolean IsDead;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContextLocation::ContextLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 913,
   FQN="(anonymous namespace)::ContextLocation::ContextLocation", NM="_ZN12_GLOBAL__N_115ContextLocationC1ERKN5clang4ento22PathDiagnosticLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_115ContextLocationC1ERKN5clang4ento22PathDiagnosticLocationEb")
  //</editor-fold>
  public ContextLocation(final /*const*/ PathDiagnosticLocation /*&*/ L) {
    this(L, false);
  }
  public ContextLocation(final /*const*/ PathDiagnosticLocation /*&*/ L, boolean isdead/*= false*/) {
    // : PathDiagnosticLocation(L), IsDead(isdead) 
    //START JInit
    super(L);
    this.IsDead = isdead;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContextLocation::markDead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 916,
   FQN="(anonymous namespace)::ContextLocation::markDead", NM="_ZN12_GLOBAL__N_115ContextLocation8markDeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_115ContextLocation8markDeadEv")
  //</editor-fold>
  public void markDead() {
    IsDead = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContextLocation::isDead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 917,
   FQN="(anonymous namespace)::ContextLocation::isDead", NM="_ZNK12_GLOBAL__N_115ContextLocation6isDeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK12_GLOBAL__N_115ContextLocation6isDeadEv")
  //</editor-fold>
  public boolean isDead() /*const*/ {
    return IsDead;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ContextLocation::ContextLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 910,
   FQN="(anonymous namespace)::ContextLocation::ContextLocation", NM="_ZN12_GLOBAL__N_115ContextLocationC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_115ContextLocationC1EOS0_")
  //</editor-fold>
  public /*inline*/ ContextLocation(JD$Move _dparam, final ContextLocation /*&&*/$Prm0) {
    // : PathDiagnosticLocation(static_cast<ContextLocation &&>()), IsDead(static_cast<ContextLocation &&>().IsDead) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.IsDead = $Prm0.IsDead;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public ContextLocation() {
    super();
    this.IsDead = false;
  }

  @Override public ContextLocation $assign(PathDiagnosticLocation $Prm0) {
    super.$assign($Prm0);
    this.IsDead = ((ContextLocation)$Prm0).IsDead;
    return this;
  }

  @Override public ContextLocation $assignMove(PathDiagnosticLocation $Prm0) {
    super.$assignMove($Prm0);
    this.IsDead = ((ContextLocation)$Prm0).IsDead;
    return this;
  }

  @Override public ContextLocation clone() {
    return new ContextLocation(this);
  }
  
  // Do not override $eq because ContextLocation is compared with pure PathDiagnosticLocation
  // i.e. in EdgeBuilder.addEdge method
  //@Override
  //public boolean $eq(PathDiagnosticLocation RHS) {
  //  if (this.IsDead != ((ContextLocation)RHS).IsDead) {
  //    return false;
  //  }
  //  return super.$eq(RHS);
  //}
  //
  //@Override
  //public boolean $noteq(PathDiagnosticLocation X) {
  //  return !$eq(X);
  //}
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "IsDead=" + IsDead // NOI18N
              + super.toString(); // NOI18N
  }
}
