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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.frontend.*;


/// StandardDirective - Directive with string matching.
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StandardDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 161,
 FQN="(anonymous namespace)::StandardDirective", NM="_ZN12_GLOBAL__N_117StandardDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117StandardDirectiveE")
//</editor-fold>
public class StandardDirective extends /*public*/ VerifyDiagnosticConsumer.Directive implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StandardDirective::StandardDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 163,
   FQN="(anonymous namespace)::StandardDirective::StandardDirective", NM="_ZN12_GLOBAL__N_117StandardDirectiveC1EN5clang14SourceLocationES2_bN4llvm9StringRefEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117StandardDirectiveC1EN5clang14SourceLocationES2_bN4llvm9StringRefEjj")
  //</editor-fold>
  public StandardDirective(SourceLocation DirectiveLoc, SourceLocation DiagnosticLoc, 
      boolean MatchAnyLine, StringRef Text, /*uint*/int Min, 
      /*uint*/int Max) {
    // : Directive(DirectiveLoc, DiagnosticLoc, MatchAnyLine, Text, Min, Max) 
    //START JInit
    super(new SourceLocation(DirectiveLoc), new SourceLocation(DiagnosticLoc), MatchAnyLine, new StringRef(Text), Min, Max);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StandardDirective::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 168,
   FQN="(anonymous namespace)::StandardDirective::isValid", NM="_ZN12_GLOBAL__N_117StandardDirective7isValidERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117StandardDirective7isValidERSs")
  //</editor-fold>
  @Override public boolean isValid(std.string/*&*/ Error)/* override*/ {
    // all strings are considered valid; even empty ones
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StandardDirective::match">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PERF*/,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 173,
   FQN="(anonymous namespace)::StandardDirective::match", NM="_ZN12_GLOBAL__N_117StandardDirective5matchEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117StandardDirective5matchEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean match(StringRef S)/* override*/ {
    return S.find(Text) != StringRef.npos;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StandardDirective::~StandardDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp", line = 161,
   FQN="(anonymous namespace)::StandardDirective::~StandardDirective", NM="_ZN12_GLOBAL__N_117StandardDirectiveD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/VerifyDiagnosticConsumer.cpp -nm=_ZN12_GLOBAL__N_117StandardDirectiveD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
