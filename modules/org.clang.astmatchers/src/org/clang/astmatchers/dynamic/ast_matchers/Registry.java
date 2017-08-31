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

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Registry">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 62,
 FQN="clang::ast_matchers::dynamic::Registry", NM="_ZN5clang12ast_matchers7dynamic8RegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8RegistryE")
//</editor-fold>
public class Registry {
/*public:*/
  /// \brief Look up a matcher in the registry by name,
  ///
  /// \return An opaque value which may be used to refer to the matcher
  /// constructor, or Optional<MatcherCtor>() if not found.
  // anonymous namespace
  
  // static
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Registry::lookupMatcherCtor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 433,
   FQN="clang::ast_matchers::dynamic::Registry::lookupMatcherCtor", NM="_ZN5clang12ast_matchers7dynamic8Registry17lookupMatcherCtorEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8Registry17lookupMatcherCtorEN4llvm9StringRefE")
  //</editor-fold>
  public static OptionalPtr</*const*/ MatcherDescriptor /*P*/ > lookupMatcherCtor(StringRef MatcherName) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Compute the list of completion types for \p Context.
  ///
  /// Each element of \p Context represents a matcher invocation, going from
  /// outermost to innermost. Elements are pairs consisting of a reference to
  /// the matcher constructor and the index of the next element in the
  /// argument list of that matcher (or for the last element, the index of
  /// the completion point in the argument list). An empty list requests
  /// completion for the root matcher.
  // namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Registry::getAcceptedCompletionTypes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 461,
   FQN="clang::ast_matchers::dynamic::Registry::getAcceptedCompletionTypes", NM="_ZN5clang12ast_matchers7dynamic8Registry26getAcceptedCompletionTypesEN4llvm8ArrayRefISt4pairIPKNS1_8internal17MatcherDescriptorEjEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8Registry26getAcceptedCompletionTypesEN4llvm8ArrayRefISt4pairIPKNS1_8internal17MatcherDescriptorEjEEE")
  //</editor-fold>
  public static std.vector<ArgKind> getAcceptedCompletionTypes(ArrayRef<std.pairTypeUInt</*const*/ MatcherDescriptor /*P*/ >> Context) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Compute the list of completions that match any of
  /// \p AcceptedTypes.
  ///
  /// \param AcceptedTypes All types accepted for this completion.
  ///
  /// \return All completions for the specified types.
  /// Completions should be valid when used in \c lookupMatcherCtor().
  /// The matcher constructed from the return of \c lookupMatcherCtor()
  /// should be convertible to some type in \p AcceptedTypes.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Registry::getMatcherCompletions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 491,
   FQN="clang::ast_matchers::dynamic::Registry::getMatcherCompletions", NM="_ZN5clang12ast_matchers7dynamic8Registry21getMatcherCompletionsEN4llvm8ArrayRefINS1_7ArgKindEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8Registry21getMatcherCompletionsEN4llvm8ArrayRefINS1_7ArgKindEEE")
  //</editor-fold>
  public static std.vector<MatcherCompletion> getMatcherCompletions(ArrayRef<ArgKind> AcceptedTypes) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Construct a matcher from the registry.
  ///
  /// \param Ctor The matcher constructor to instantiate.
  ///
  /// \param NameRange The location of the name in the matcher source.
  ///   Useful for error reporting.
  ///
  /// \param Args The argument list for the matcher. The number and types of the
  ///   values must be valid for the matcher requested. Otherwise, the function
  ///   will return an error.
  ///
  /// \return The matcher object constructed if no error was found.
  ///   A null matcher if the number of arguments or argument types do not match
  ///   the signature.  In that case \c Error will contain the description of
  ///   the error.
  
  // static
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Registry::constructMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 571,
   FQN="clang::ast_matchers::dynamic::Registry::constructMatcher", NM="_ZN5clang12ast_matchers7dynamic8Registry16constructMatcherEPKNS1_8internal17MatcherDescriptorENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8Registry16constructMatcherEPKNS1_8internal17MatcherDescriptorENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
  //</editor-fold>
  public static VariantMatcher constructMatcher(/*const*/ MatcherDescriptor /*P*/ Ctor, 
                  SourceRange NameRange, 
                  ArrayRef<ParserValue> Args, 
                  Diagnostics /*P*/ Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Construct a matcher from the registry and bind it.
  ///
  /// Similar the \c constructMatcher() above, but it then tries to bind the
  /// matcher to the specified \c BindID.
  /// If the matcher is not bindable, it sets an error in \c Error and returns
  /// a null matcher.
  
  // static
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Registry::constructBoundMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 579,
   FQN="clang::ast_matchers::dynamic::Registry::constructBoundMatcher", NM="_ZN5clang12ast_matchers7dynamic8Registry21constructBoundMatcherEPKNS1_8internal17MatcherDescriptorENS1_11SourceRangeEN4llvm9StringRefENS8_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8Registry21constructBoundMatcherEPKNS1_8internal17MatcherDescriptorENS1_11SourceRangeEN4llvm9StringRefENS8_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
  //</editor-fold>
  public static VariantMatcher constructBoundMatcher(/*const*/ MatcherDescriptor /*P*/ Ctor, 
                       SourceRange NameRange, 
                       StringRef BindID, 
                       ArrayRef<ParserValue> Args, 
                       Diagnostics /*P*/ Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Registry::Registry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Registry.h", line = 126,
   FQN="clang::ast_matchers::dynamic::Registry::Registry", NM="_ZN5clang12ast_matchers7dynamic8RegistryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8RegistryC1Ev")
  //</editor-fold>
  private Registry() { throw new UnsupportedOperationException("Deleted");}

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
