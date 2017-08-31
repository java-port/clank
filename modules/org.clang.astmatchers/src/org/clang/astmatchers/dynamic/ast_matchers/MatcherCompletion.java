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

package org.clang.astmatchers.dynamic.ast_matchers;

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

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::MatcherCompletion">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 37,
 FQN="clang::ast_matchers::dynamic::MatcherCompletion", NM="_ZN5clang12ast_matchers7dynamic17MatcherCompletionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic17MatcherCompletionE")
//</editor-fold>
public class/*struct*/ MatcherCompletion implements Destructors.ClassWithDestructor, Native.NativeComparable<MatcherCompletion> {
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::MatcherCompletion::MatcherCompletion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 38,
   FQN="clang::ast_matchers::dynamic::MatcherCompletion::MatcherCompletion", NM="_ZN5clang12ast_matchers7dynamic17MatcherCompletionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic17MatcherCompletionC1Ev")
  //</editor-fold>
  public MatcherCompletion() {
    // : TypedText(), MatcherDecl() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::MatcherCompletion::MatcherCompletion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 39,
   FQN="clang::ast_matchers::dynamic::MatcherCompletion::MatcherCompletion", NM="_ZN5clang12ast_matchers7dynamic17MatcherCompletionC1EN4llvm9StringRefES4_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic17MatcherCompletionC1EN4llvm9StringRefES4_j")
  //</editor-fold>
  public MatcherCompletion(StringRef TypedText, StringRef MatcherDecl, 
      /*uint*/int Specificity) {
    // : TypedText(TypedText.operator basic_string()), MatcherDecl(MatcherDecl.operator basic_string()), Specificity(Specificity) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief The text to type to select this matcher.
  public std.string TypedText;
  
  /// \brief The "declaration" of the matcher, with type information.
  public std.string MatcherDecl;
  
  /// \brief Value corresponding to the "specificity" of the converted matcher.
  ///
  /// Zero specificity indicates that this conversion would produce a trivial
  /// matcher that will either always or never match.
  /// Such matchers are excluded from code completion results.
  public /*uint*/int Specificity;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::MatcherCompletion::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 57,
   FQN="clang::ast_matchers::dynamic::MatcherCompletion::operator==", NM="_ZNK5clang12ast_matchers7dynamic17MatcherCompletioneqERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZNK5clang12ast_matchers7dynamic17MatcherCompletioneqERKS2_")
  //</editor-fold>
  public boolean $eq(final /*const*/ MatcherCompletion /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::MatcherCompletion::MatcherCompletion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 37,
   FQN="clang::ast_matchers::dynamic::MatcherCompletion::MatcherCompletion", NM="_ZN5clang12ast_matchers7dynamic17MatcherCompletionC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic17MatcherCompletionC1ERKS2_")
  //</editor-fold>
  public /*inline*/ MatcherCompletion(final /*const*/ MatcherCompletion /*&*/ $Prm0) {
    // : TypedText(.TypedText), MatcherDecl(.MatcherDecl), Specificity(.Specificity) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::MatcherCompletion::MatcherCompletion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 37,
   FQN="clang::ast_matchers::dynamic::MatcherCompletion::MatcherCompletion", NM="_ZN5clang12ast_matchers7dynamic17MatcherCompletionC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic17MatcherCompletionC1EOS2_")
  //</editor-fold>
  public /*inline*/ MatcherCompletion(JD$Move _dparam, final MatcherCompletion /*&&*/$Prm0) {
    // : TypedText(static_cast<MatcherCompletion &&>().TypedText), MatcherDecl(static_cast<MatcherCompletion &&>().MatcherDecl), Specificity(static_cast<MatcherCompletion &&>().Specificity) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::MatcherCompletion::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 37,
   FQN="clang::ast_matchers::dynamic::MatcherCompletion::operator=", NM="_ZN5clang12ast_matchers7dynamic17MatcherCompletionaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic17MatcherCompletionaSEOS2_")
  //</editor-fold>
  public /*inline*/ MatcherCompletion /*&*/ $assignMove(final MatcherCompletion /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::MatcherCompletion::~MatcherCompletion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 37,
   FQN="clang::ast_matchers::dynamic::MatcherCompletion::~MatcherCompletion", NM="_ZN5clang12ast_matchers7dynamic17MatcherCompletionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic17MatcherCompletionD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "TypedText=" + TypedText // NOI18N
              + ", MatcherDecl=" + MatcherDecl // NOI18N
              + ", Specificity=" + Specificity; // NOI18N
  }
}
