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

import org.clank.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagsUninitializedSeveretyRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8277,
 FQN="(anonymous namespace)::DiagsUninitializedSeveretyRAII", NM="_ZN12_GLOBAL__N_130DiagsUninitializedSeveretyRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_130DiagsUninitializedSeveretyRAIIE")
//</editor-fold>
public class DiagsUninitializedSeveretyRAII implements Destructors.ClassWithDestructor {
/*private:*/
  private final DiagnosticsEngine /*&*/ Diags;
  private SourceLocation SavedLoc;
  private boolean IsIgnored;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagsUninitializedSeveretyRAII::DiagsUninitializedSeveretyRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8284,
   FQN="(anonymous namespace)::DiagsUninitializedSeveretyRAII::DiagsUninitializedSeveretyRAII", NM="_ZN12_GLOBAL__N_130DiagsUninitializedSeveretyRAIIC1ERN5clang17DiagnosticsEngineENS1_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_130DiagsUninitializedSeveretyRAIIC1ERN5clang17DiagnosticsEngineENS1_14SourceLocationEb")
  //</editor-fold>
  public DiagsUninitializedSeveretyRAII(final DiagnosticsEngine /*&*/ Diags, SourceLocation Loc, 
      boolean IsIgnored) {
    // : Diags(Diags), SavedLoc(Loc), IsIgnored(IsIgnored) 
    //START JInit
    this./*&*/Diags=/*&*/Diags;
    this.SavedLoc = new SourceLocation(Loc);
    this.IsIgnored = IsIgnored;
    //END JInit
    if (!IsIgnored) {
      Diags.setSeverity(/*Diag*/ diag.warn_uninit_self_reference_in_init, 
          /*Map*/ diag.Severity.Ignored, /*NO_COPY*/Loc);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagsUninitializedSeveretyRAII::~DiagsUninitializedSeveretyRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8292,
   FQN="(anonymous namespace)::DiagsUninitializedSeveretyRAII::~DiagsUninitializedSeveretyRAII", NM="_ZN12_GLOBAL__N_130DiagsUninitializedSeveretyRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_130DiagsUninitializedSeveretyRAIID0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!IsIgnored) {
      Diags.popMappings(/*NO_COPY*/SavedLoc);
    }
  }

  
  @Override public String toString() {
    return "" + "Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", SavedLoc=" + SavedLoc // NOI18N
              + ", IsIgnored=" + IsIgnored; // NOI18N
  }
}
