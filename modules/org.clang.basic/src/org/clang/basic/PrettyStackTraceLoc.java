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

package org.clang.basic;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// If a crash happens while one of these objects are live, the message
/// is printed out along with the specified source location.
//<editor-fold defaultstate="collapsed" desc="clang::PrettyStackTraceLoc">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PrettyStackTrace.h", line = 27,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PrettyStackTrace.h", old_line = 27,
 FQN = "clang::PrettyStackTraceLoc", NM = "_ZN5clang19PrettyStackTraceLocE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang19PrettyStackTraceLocE")
//</editor-fold>
public class PrettyStackTraceLoc extends /*public*/ PrettyStackTraceEntry implements Destructors.ClassWithDestructor {
  private SourceManager /*&*/ SM;
  private SourceLocation Loc;
  private /*const*/char$ptr/*char P*/ Message;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PrettyStackTraceLoc::PrettyStackTraceLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PrettyStackTrace.h", line = 32,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PrettyStackTrace.h", old_line = 32,
   FQN = "clang::PrettyStackTraceLoc::PrettyStackTraceLoc", NM = "_ZN5clang19PrettyStackTraceLocC1ERNS_13SourceManagerENS_14SourceLocationEPKc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang19PrettyStackTraceLocC1ERNS_13SourceManagerENS_14SourceLocationEPKc")
  //</editor-fold>
  public PrettyStackTraceLoc(SourceManager /*&*/ sm, SourceLocation L, /*const*/char$ptr/*char P*/ Msg) {
    /* : PrettyStackTraceEntry(), SM(sm), Loc(L), Message(Msg)*/ 
    //START JInit
    super();
    this.SM = sm;
    this.Loc = new SourceLocation(L);
    this.Message = Msg;
    //END JInit
  }

  
  //===----------------------------------------------------------------------===//
  // PrettyStackTraceLoc
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::PrettyStackTraceLoc::print">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", line = 26,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp", old_line = 26,
   FQN = "clang::PrettyStackTraceLoc::print", NM = "_ZNK5clang19PrettyStackTraceLoc5printERN4llvm11raw_ostreamE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZNK5clang19PrettyStackTraceLoc5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void print(raw_ostream /*&*/ OS) /*const*/ {
    if (Loc.isValid()) {
      Loc.print(OS, SM);
      OS.$out(": ");
    }
    OS.$out(Message).$out_char($$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrettyStackTraceLoc::~PrettyStackTraceLoc">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PrettyStackTrace.h", line = 27,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PrettyStackTrace.h", old_line = 27,
   FQN = "clang::PrettyStackTraceLoc::~PrettyStackTraceLoc", NM = "_ZN5clang19PrettyStackTraceLocD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN5clang19PrettyStackTraceLocD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

}
