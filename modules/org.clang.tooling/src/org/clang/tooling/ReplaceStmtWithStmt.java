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

package org.clang.tooling;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.astmatchers.ast_matchers.*;
import org.clang.tooling.*;


/// \brief Replace the text of the statement bound to \c FromId with the text of
/// the statement bound to \c ToId.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::ReplaceStmtWithStmt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/RefactoringCallbacks.h", line = 64,
 FQN="clang::tooling::ReplaceStmtWithStmt", NM="_ZN5clang7tooling19ReplaceStmtWithStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp -nm=_ZN5clang7tooling19ReplaceStmtWithStmtE")
//</editor-fold>
public class ReplaceStmtWithStmt extends /*public*/ RefactoringCallback implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ReplaceStmtWithStmt::ReplaceStmtWithStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp", line = 50,
   FQN="clang::tooling::ReplaceStmtWithStmt::ReplaceStmtWithStmt", NM="_ZN5clang7tooling19ReplaceStmtWithStmtC1EN4llvm9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp -nm=_ZN5clang7tooling19ReplaceStmtWithStmtC1EN4llvm9StringRefES3_")
  //</editor-fold>
  public ReplaceStmtWithStmt(StringRef FromId, StringRef ToId) {
    // : RefactoringCallback(), FromId(FromId.operator basic_string()), ToId(ToId.operator basic_string()) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ReplaceStmtWithStmt::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp", line = 53,
   FQN="clang::tooling::ReplaceStmtWithStmt::run", NM="_ZN5clang7tooling19ReplaceStmtWithStmt3runERKNS_12ast_matchers11MatchFinder11MatchResultE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp -nm=_ZN5clang7tooling19ReplaceStmtWithStmt3runERKNS_12ast_matchers11MatchFinder11MatchResultE")
  //</editor-fold>
  @Override public void run(final /*const*/ MatchFinder.MatchResult /*&*/ Result)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private std.string FromId;
  private std.string ToId;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ReplaceStmtWithStmt::~ReplaceStmtWithStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/RefactoringCallbacks.h", line = 64,
   FQN="clang::tooling::ReplaceStmtWithStmt::~ReplaceStmtWithStmt", NM="_ZN5clang7tooling19ReplaceStmtWithStmtD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/RefactoringCallbacks.cpp -nm=_ZN5clang7tooling19ReplaceStmtWithStmtD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "FromId=" + FromId // NOI18N
              + ", ToId=" + ToId // NOI18N
              + super.toString(); // NOI18N
  }
}
