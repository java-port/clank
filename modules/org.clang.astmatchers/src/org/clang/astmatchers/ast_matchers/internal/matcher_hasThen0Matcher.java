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

package org.clang.astmatchers.ast_matchers.internal;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import org.clang.astmatchers.ast_matchers.*;
import org.clang.astmatchers.ast_matchers.internal.*;
import org.clang.astmatchers.ast_matchers.internal.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;


/// \brief Matches the then-statement of an if statement.
///
/// Examples matches the if statement
///   (matcher = ifStmt(hasThen(cxxBoolLiteral(equals(true)))))
/// \code
///   if (false) true; else false;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::matcher_hasThen0Matcher">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3424,
 FQN="clang::ast_matchers::internal::matcher_hasThen0Matcher", NM="_ZN5clang12ast_matchers8internal23matcher_hasThen0MatcherE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal23matcher_hasThen0MatcherE")
//</editor-fold>
public class matcher_hasThen0Matcher extends /*public*/ /*::*/MatcherInterface<IfStmt> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::matcher_hasThen0Matcher::matcher_hasThen0Matcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3424,
   FQN="clang::ast_matchers::internal::matcher_hasThen0Matcher::matcher_hasThen0Matcher", NM="_ZN5clang12ast_matchers8internal23matcher_hasThen0MatcherC1ERKNS1_7MatcherINS_4StmtEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal23matcher_hasThen0MatcherC1ERKNS1_7MatcherINS_4StmtEEE")
  //</editor-fold>
  public /*explicit*/ matcher_hasThen0Matcher(final /*const*/ Matcher<Stmt> /*&*/ AInnerMatcher) {
    // : ::MatcherInterface<IfStmt>(), InnerMatcher(AInnerMatcher) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::matcher_hasThen0Matcher::matches">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3424,
   FQN="clang::ast_matchers::internal::matcher_hasThen0Matcher::matches", NM="_ZNK5clang12ast_matchers8internal23matcher_hasThen0Matcher7matchesERKNS_6IfStmtEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal23matcher_hasThen0Matcher7matchesERKNS_6IfStmtEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE")
  //</editor-fold>
  @Override public /*inline*/ boolean matches(final /*const*/ IfStmt /*&*/ Node, /*::*/ASTMatchFinder /*P*/ Finder, /*::*/BoundNodesTreeBuilder /*P*/ Builder) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private /*const*/ Matcher<Stmt> InnerMatcher;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::matcher_hasThen0Matcher::~matcher_hasThen0Matcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 3424,
   FQN="clang::ast_matchers::internal::matcher_hasThen0Matcher::~matcher_hasThen0Matcher", NM="_ZN5clang12ast_matchers8internal23matcher_hasThen0MatcherD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal23matcher_hasThen0MatcherD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "InnerMatcher=" + InnerMatcher // NOI18N
              + super.toString(); // NOI18N
  }
}
