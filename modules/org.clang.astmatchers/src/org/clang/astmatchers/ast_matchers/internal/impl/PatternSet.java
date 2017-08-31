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

package org.clang.astmatchers.ast_matchers.internal.impl;

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

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::PatternSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 362,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::PatternSet", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSetE")
//</editor-fold>
public class PatternSet implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::PatternSet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 364,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::PatternSet", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSetC1EN4llvm8ArrayRefISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSetC1EN4llvm8ArrayRefISsEE")
  //</editor-fold>
  public PatternSet(ArrayRef<std.string> Names) {
    // : Patterns() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Consumes the name suffix from each pattern in the set and removes the ones
  /// that didn't match.
  /// Return true if there are still any patterns left.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::consumeNameSuffix">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 372,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::consumeNameSuffix", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSet17consumeNameSuffixEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSet17consumeNameSuffixEN4llvm9StringRefEb")
  //</editor-fold>
  public boolean consumeNameSuffix(StringRef NodeName, boolean CanSkip) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Check if any of the patterns are a match.
  /// A match will be a pattern that was fully consumed, that also matches the
  /// 'fully qualified' requirement.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::foundMatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 387,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::foundMatch", NM="_ZNK5clang12ast_matchers8internal12_GLOBAL__N_110PatternSet10foundMatchEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal12_GLOBAL__N_110PatternSet10foundMatchEb")
  //</editor-fold>
  public boolean foundMatch(boolean AllowFullyQualified) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::Pattern">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 395,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::Pattern", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSet7PatternE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSet7PatternE")
  //</editor-fold>
  private static class/*struct*/ Pattern {
    public StringRef P;
    public boolean IsFullyQualified;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::Pattern::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 395,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::Pattern::operator=", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSet7PatternaSEOS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSet7PatternaSEOS4_")
    //</editor-fold>
    public /*inline*/ Pattern /*&*/ $assignMove(final Pattern /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "P=" + P // NOI18N
                + ", IsFullyQualified=" + IsFullyQualified; // NOI18N
    }
  };
  private SmallVector<Pattern> Patterns;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::~PatternSet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 362,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::PatternSet::~PatternSet", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_110PatternSetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Patterns=" + Patterns; // NOI18N
  }
}
