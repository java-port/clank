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

package org.clang.staticanalyzer.core.ento.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.analysis.*;


/// While alive, includes the current analysis stack in a crash trace.
///
/// Example:
/// \code
/// 0.     Program arguments: ...
/// 1.     <eof> parser at end of file
/// 2.     While analyzing stack:
///        #0 void inlined()
///        #1 void test()
/// 3.     crash-trace.c:6:3: Error evaluating statement
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ento::PrettyStackTraceLocationContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PrettyStackTraceLocationContext.h", line = 29,
 FQN="clang::ento::PrettyStackTraceLocationContext", NM="_ZN5clang4ento31PrettyStackTraceLocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento31PrettyStackTraceLocationContextE")
//</editor-fold>
public class PrettyStackTraceLocationContext extends /*public*/ PrettyStackTraceEntry implements Destructors.ClassWithDestructor {
  private /*const*/ LocationContext /*P*/ LCtx;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PrettyStackTraceLocationContext::PrettyStackTraceLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PrettyStackTraceLocationContext.h", line = 32,
   FQN="clang::ento::PrettyStackTraceLocationContext::PrettyStackTraceLocationContext", NM="_ZN5clang4ento31PrettyStackTraceLocationContextC1EPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento31PrettyStackTraceLocationContextC1EPKNS_15LocationContextE")
  //</editor-fold>
  public PrettyStackTraceLocationContext(/*const*/ LocationContext /*P*/ LC) {
    // : PrettyStackTraceEntry(), LCtx(LC) 
    //START JInit
    super();
    this.LCtx = LC;
    //END JInit
    assert Native.$bool(LCtx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::PrettyStackTraceLocationContext::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PrettyStackTraceLocationContext.h", line = 36,
   FQN="clang::ento::PrettyStackTraceLocationContext::print", NM="_ZNK5clang4ento31PrettyStackTraceLocationContext5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang4ento31PrettyStackTraceLocationContext5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void print(final raw_ostream /*&*/ OS) /*const*//* override*/ {
    OS.$out(/*KEEP_STR*/"While analyzing stack: \n");
    LCtx.dumpStack(OS, new StringRef(/*KEEP_STR*/$TAB));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::PrettyStackTraceLocationContext::~PrettyStackTraceLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PrettyStackTraceLocationContext.h", line = 29,
   FQN="clang::ento::PrettyStackTraceLocationContext::~PrettyStackTraceLocationContext", NM="_ZN5clang4ento31PrettyStackTraceLocationContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang4ento31PrettyStackTraceLocationContextD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "LCtx=" + "[LocationContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
