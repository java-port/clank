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


/// \brief Matcher expression parser.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 50,
 FQN="clang::ast_matchers::dynamic::Parser", NM="_ZN5clang12ast_matchers7dynamic6ParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6ParserE")
//</editor-fold>
public class Parser implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Interface to connect the parser with the registry and more.
  ///
  /// The parser uses the Sema instance passed into
  /// parseMatcherExpression() to handle all matcher tokens. The simplest
  /// processor implementation would simply call into the registry to create
  /// the matchers.
  /// However, a more complex processor might decide to intercept the matcher
  /// creation and do some extra work. For example, it could apply some
  /// transformation to the matcher by adding some id() nodes, or could detect
  /// specific matcher nodes for more efficient lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::Sema">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 62,
   FQN="clang::ast_matchers::dynamic::Parser::Sema", NM="_ZN5clang12ast_matchers7dynamic6Parser4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser4SemaE")
  //</editor-fold>
  public abstract static class Sema implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::Sema::~Sema">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 260,
     FQN="clang::ast_matchers::dynamic::Parser::Sema::~Sema", NM="_ZN5clang12ast_matchers7dynamic6Parser4SemaD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser4SemaD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Process a matcher expression.
    ///
    /// All the arguments passed here have already been processed.
    ///
    /// \param Ctor A matcher constructor looked up by lookupMatcherCtor.
    ///
    /// \param NameRange The location of the name in the matcher source.
    ///   Useful for error reporting.
    ///
    /// \param BindID The ID to use to bind the matcher, or a null \c StringRef
    ///   if no ID is specified.
    ///
    /// \param Args The argument list for the matcher.
    ///
    /// \return The matcher objects constructed by the processor, or a null
    ///   matcher if an error occurred. In that case, \c Error will contain a
    ///   description of the error.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::Sema::actOnMatcherExpression">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 83,
     FQN="clang::ast_matchers::dynamic::Parser::Sema::actOnMatcherExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser4Sema22actOnMatcherExpressionEPKNS1_8internal17MatcherDescriptorENS1_11SourceRangeEN4llvm9StringRefENS9_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser4Sema22actOnMatcherExpressionEPKNS1_8internal17MatcherDescriptorENS1_11SourceRangeEN4llvm9StringRefENS9_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
    //</editor-fold>
    public abstract /*virtual*/ VariantMatcher actOnMatcherExpression(/*const*/ MatcherDescriptor /*P*/ Ctor, 
                          SourceRange NameRange, 
                          StringRef BindID, 
                          ArrayRef<ParserValue> Args, 
                          Diagnostics /*P*/ Error)/* = 0*/;

    
    /// \brief Look up a matcher by name.
    ///
    /// \param MatcherName The matcher name found by the parser.
    ///
    /// \return The matcher constructor, or Optional<MatcherCtor>() if not
    /// found.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::Sema::lookupMatcherCtor">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 95,
     FQN="clang::ast_matchers::dynamic::Parser::Sema::lookupMatcherCtor", NM="_ZN5clang12ast_matchers7dynamic6Parser4Sema17lookupMatcherCtorEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser4Sema17lookupMatcherCtorEN4llvm9StringRefE")
    //</editor-fold>
    public abstract /*virtual*/ OptionalPtr</*const*/ MatcherDescriptor /*P*/ > lookupMatcherCtor(StringRef MatcherName)/* = 0*/;

    
    /// \brief Compute the list of completion types for \p Context.
    ///
    /// Each element of \p Context represents a matcher invocation, going from
    /// outermost to innermost. Elements are pairs consisting of a reference to
    /// the matcher constructor and the index of the next element in the
    /// argument list of that matcher (or for the last element, the index of
    /// the completion point in the argument list). An empty list requests
    /// completion for the root matcher.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::Sema::getAcceptedCompletionTypes">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 262,
     FQN="clang::ast_matchers::dynamic::Parser::Sema::getAcceptedCompletionTypes", NM="_ZN5clang12ast_matchers7dynamic6Parser4Sema26getAcceptedCompletionTypesEN4llvm8ArrayRefISt4pairIPKNS1_8internal17MatcherDescriptorEjEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser4Sema26getAcceptedCompletionTypesEN4llvm8ArrayRefISt4pairIPKNS1_8internal17MatcherDescriptorEjEEE")
    //</editor-fold>
    public std.vector<ArgKind> getAcceptedCompletionTypes(ArrayRef<std.pairTypeUInt</*const*/ MatcherDescriptor /*P*/ >> Context) {
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
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::Sema::getMatcherCompletions">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 267,
     FQN="clang::ast_matchers::dynamic::Parser::Sema::getMatcherCompletions", NM="_ZN5clang12ast_matchers7dynamic6Parser4Sema21getMatcherCompletionsEN4llvm8ArrayRefINS1_7ArgKindEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser4Sema21getMatcherCompletionsEN4llvm8ArrayRefINS1_7ArgKindEEE")
    //</editor-fold>
    public std.vector<MatcherCompletion> getMatcherCompletions(ArrayRef<ArgKind> AcceptedTypes) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::Sema::Sema">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 62,
     FQN="clang::ast_matchers::dynamic::Parser::Sema::Sema", NM="_ZN5clang12ast_matchers7dynamic6Parser4SemaC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser4SemaC1Ev")
    //</editor-fold>
    public /*inline*/ Sema() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// \brief Sema implementation that uses the matcher registry to process the
  ///   tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::RegistrySema">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 124,
   FQN="clang::ast_matchers::dynamic::Parser::RegistrySema", NM="_ZN5clang12ast_matchers7dynamic6Parser12RegistrySemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser12RegistrySemaE")
  //</editor-fold>
  public static class RegistrySema extends /*public*/ Parser.Sema implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::RegistrySema::~RegistrySema">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 529,
     FQN="clang::ast_matchers::dynamic::Parser::RegistrySema::~RegistrySema", NM="_ZN5clang12ast_matchers7dynamic6Parser12RegistrySemaD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser12RegistrySemaD0Ev")
    //</editor-fold>
    @Override public void $destroy()/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::RegistrySema::lookupMatcherCtor">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 531,
     FQN="clang::ast_matchers::dynamic::Parser::RegistrySema::lookupMatcherCtor", NM="_ZN5clang12ast_matchers7dynamic6Parser12RegistrySema17lookupMatcherCtorEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser12RegistrySema17lookupMatcherCtorEN4llvm9StringRefE")
    //</editor-fold>
    @Override public OptionalPtr</*const*/ MatcherDescriptor /*P*/ > lookupMatcherCtor(StringRef MatcherName)/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::RegistrySema::actOnMatcherExpression">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 536,
     FQN="clang::ast_matchers::dynamic::Parser::RegistrySema::actOnMatcherExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser12RegistrySema22actOnMatcherExpressionEPKNS1_8internal17MatcherDescriptorENS1_11SourceRangeEN4llvm9StringRefENS9_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser12RegistrySema22actOnMatcherExpressionEPKNS1_8internal17MatcherDescriptorENS1_11SourceRangeEN4llvm9StringRefENS9_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
    //</editor-fold>
    @Override public VariantMatcher actOnMatcherExpression(/*const*/ MatcherDescriptor /*P*/ Ctor, SourceRange NameRange, StringRef BindID, 
                          ArrayRef<ParserValue> Args, Diagnostics /*P*/ Error)/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::RegistrySema::getAcceptedCompletionTypes">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 547,
     FQN="clang::ast_matchers::dynamic::Parser::RegistrySema::getAcceptedCompletionTypes", NM="_ZN5clang12ast_matchers7dynamic6Parser12RegistrySema26getAcceptedCompletionTypesEN4llvm8ArrayRefISt4pairIPKNS1_8internal17MatcherDescriptorEjEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser12RegistrySema26getAcceptedCompletionTypesEN4llvm8ArrayRefISt4pairIPKNS1_8internal17MatcherDescriptorEjEEE")
    //</editor-fold>
    @Override public std.vector<ArgKind> getAcceptedCompletionTypes(ArrayRef<std.pairTypeUInt</*const*/ MatcherDescriptor /*P*/ >> Context)/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::RegistrySema::getMatcherCompletions">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 552,
     FQN="clang::ast_matchers::dynamic::Parser::RegistrySema::getMatcherCompletions", NM="_ZN5clang12ast_matchers7dynamic6Parser12RegistrySema21getMatcherCompletionsEN4llvm8ArrayRefINS1_7ArgKindEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser12RegistrySema21getMatcherCompletionsEN4llvm8ArrayRefINS1_7ArgKindEEE")
    //</editor-fold>
    @Override public std.vector<MatcherCompletion> getMatcherCompletions(ArrayRef<ArgKind> AcceptedTypes)/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::RegistrySema::RegistrySema">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 124,
     FQN="clang::ast_matchers::dynamic::Parser::RegistrySema::RegistrySema", NM="_ZN5clang12ast_matchers7dynamic6Parser12RegistrySemaC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser12RegistrySemaC1Ev")
    //</editor-fold>
    public /*inline*/ RegistrySema() {
      // : Parser::Sema() 
      super();
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  /*typedef llvm::StringMap<VariantValue> NamedValueMap*/
//  public final class NamedValueMap extends StringMap<VariantValue>{ };
  
  /// \brief Parse a matcher expression.
  ///
  /// \param MatcherCode The matcher expression to parse.
  ///
  /// \param S The Sema instance that will help the parser
  ///   construct the matchers. If null, it uses the default registry.
  ///
  /// \param NamedValues A map of precomputed named values.  This provides
  ///   the dictionary for the <NamedValue> rule of the grammar.
  ///   If null, it is ignored.
  ///
  /// \return The matcher object constructed by the processor, or an empty
  ///   Optional if an error occurred. In that case, \c Error will contain a
  ///   description of the error.
  ///   The caller takes ownership of the DynTypedMatcher object returned.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseMatcherExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 591,
   FQN="clang::ast_matchers::dynamic::Parser::parseMatcherExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser22parseMatcherExpressionEN4llvm9StringRefEPNS2_4SemaEPKNS3_9StringMapINS1_12VariantValueENS3_15MallocAllocatorEEEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser22parseMatcherExpressionEN4llvm9StringRefEPNS2_4SemaEPKNS3_9StringMapINS1_12VariantValueENS3_15MallocAllocatorEEEPNS1_11DiagnosticsE")
  //</editor-fold>
  public static Optional<DynTypedMatcher> parseMatcherExpression(StringRef Code, Sema /*P*/ S, 
                        /*const*/StringMap<VariantValue> /*P*/ NamedValues, 
                        Diagnostics /*P*/ Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseMatcherExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 165,
   FQN="clang::ast_matchers::dynamic::Parser::parseMatcherExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser22parseMatcherExpressionEN4llvm9StringRefEPNS2_4SemaEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser22parseMatcherExpressionEN4llvm9StringRefEPNS2_4SemaEPNS1_11DiagnosticsE")
  //</editor-fold>
  public static Optional<DynTypedMatcher> parseMatcherExpression(StringRef MatcherCode, Sema /*P*/ S, 
                        Diagnostics /*P*/ Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseMatcherExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 170,
   FQN="clang::ast_matchers::dynamic::Parser::parseMatcherExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser22parseMatcherExpressionEN4llvm9StringRefEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser22parseMatcherExpressionEN4llvm9StringRefEPNS1_11DiagnosticsE")
  //</editor-fold>
  public static Optional<DynTypedMatcher> parseMatcherExpression(StringRef MatcherCode, Diagnostics /*P*/ Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Parse an expression.
  ///
  /// Parses any expression supported by this parser. In general, the
  /// \c parseMatcherExpression function is a better approach to get a matcher
  /// object.
  ///
  /// \param S The Sema instance that will help the parser
  ///   construct the matchers. If null, it uses the default registry.
  ///
  /// \param NamedValues A map of precomputed named values.  This provides
  ///   the dictionary for the <NamedValue> rule of the grammar.
  ///   If null, it is ignored.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 557,
   FQN="clang::ast_matchers::dynamic::Parser::parseExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser15parseExpressionEN4llvm9StringRefEPNS2_4SemaEPKNS3_9StringMapINS1_12VariantValueENS3_15MallocAllocatorEEEPS8_PNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser15parseExpressionEN4llvm9StringRefEPNS2_4SemaEPKNS3_9StringMapINS1_12VariantValueENS3_15MallocAllocatorEEEPS8_PNS1_11DiagnosticsE")
  //</editor-fold>
  public static boolean parseExpression(StringRef Code, Sema /*P*/ S, 
                 /*const*/StringMap<VariantValue> /*P*/ NamedValues, 
                 VariantValue /*P*/ Value, Diagnostics /*P*/ Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 190,
   FQN="clang::ast_matchers::dynamic::Parser::parseExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser15parseExpressionEN4llvm9StringRefEPNS2_4SemaEPNS1_12VariantValueEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser15parseExpressionEN4llvm9StringRefEPNS2_4SemaEPNS1_12VariantValueEPNS1_11DiagnosticsE")
  //</editor-fold>
  public static boolean parseExpression(StringRef Code, Sema /*P*/ S, 
                 VariantValue /*P*/ Value, Diagnostics /*P*/ Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 194,
   FQN="clang::ast_matchers::dynamic::Parser::parseExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser15parseExpressionEN4llvm9StringRefEPNS1_12VariantValueEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser15parseExpressionEN4llvm9StringRefEPNS1_12VariantValueEPNS1_11DiagnosticsE")
  //</editor-fold>
  public static boolean parseExpression(StringRef Code, VariantValue /*P*/ Value, 
                 Diagnostics /*P*/ Error) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Complete an expression at the given offset.
  ///
  /// \param S The Sema instance that will help the parser
  ///   construct the matchers. If null, it uses the default registry.
  ///
  /// \param NamedValues A map of precomputed named values.  This provides
  ///   the dictionary for the <NamedValue> rule of the grammar.
  ///   If null, it is ignored.
  ///
  /// \return The list of completions, which may be empty if there are no
  /// available completions or if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::completeExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 571,
   FQN="clang::ast_matchers::dynamic::Parser::completeExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser18completeExpressionEN4llvm9StringRefEjPNS2_4SemaEPKNS3_9StringMapINS1_12VariantValueENS3_15MallocAllocatorEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser18completeExpressionEN4llvm9StringRefEjPNS2_4SemaEPKNS3_9StringMapINS1_12VariantValueENS3_15MallocAllocatorEEE")
  //</editor-fold>
  public static std.vector<MatcherCompletion> completeExpression(StringRef Code, /*uint*/int CompletionOffset, Sema /*P*/ S, 
                    /*const*/StringMap<VariantValue> /*P*/ NamedValues) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::completeExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 213,
   FQN="clang::ast_matchers::dynamic::Parser::completeExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser18completeExpressionEN4llvm9StringRefEjPNS2_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser18completeExpressionEN4llvm9StringRefEjPNS2_4SemaE")
  //</editor-fold>
  public static std.vector<MatcherCompletion> completeExpression(StringRef Code, /*uint*/int CompletionOffset, Sema /*P*/ S) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::completeExpression">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 217,
   FQN="clang::ast_matchers::dynamic::Parser::completeExpression", NM="_ZN5clang12ast_matchers7dynamic6Parser18completeExpressionEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser18completeExpressionEN4llvm9StringRefEj")
  //</editor-fold>
  public static std.vector<MatcherCompletion> completeExpression(StringRef Code, /*uint*/int CompletionOffset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  
  /// \brief Simple tokenizer for the parser.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 58,
   FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizerE")
  //</editor-fold>
  private static class CodeTokenizer implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::CodeTokenizer">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 60,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::CodeTokenizer", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizerC1EN4llvm9StringRefEPNS1_11DiagnosticsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizerC1EN4llvm9StringRefEPNS1_11DiagnosticsE")
    //</editor-fold>
    public /*explicit*/ CodeTokenizer(StringRef MatcherCode, Diagnostics /*P*/ Error) {
      // : Code(MatcherCode), StartOfLine(MatcherCode), Line(1), Error(Error), NextToken(), CodeCompletionLocation(null) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::CodeTokenizer">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 66,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::CodeTokenizer", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizerC1EN4llvm9StringRefEPNS1_11DiagnosticsEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizerC1EN4llvm9StringRefEPNS1_11DiagnosticsEj")
    //</editor-fold>
    public CodeTokenizer(StringRef MatcherCode, Diagnostics /*P*/ Error, 
        /*uint*/int CodeCompletionOffset) {
      // : Code(MatcherCode), StartOfLine(MatcherCode), Line(1), Error(Error), NextToken(), CodeCompletionLocation(MatcherCode.data() + CodeCompletionOffset) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Returns but doesn't consume the next token.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::peekNextToken">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 74,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::peekNextToken", NM="_ZNK5clang12ast_matchers7dynamic6Parser13CodeTokenizer13peekNextTokenEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZNK5clang12ast_matchers7dynamic6Parser13CodeTokenizer13peekNextTokenEv")
    //</editor-fold>
    public /*const*/ TokenInfo /*&*/ peekNextToken() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Consumes and returns the next token.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::consumeNextToken">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 77,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::consumeNextToken", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer16consumeNextTokenEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer16consumeNextTokenEv")
    //</editor-fold>
    public TokenInfo consumeNextToken() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::nextTokenKind">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 83,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::nextTokenKind", NM="_ZNK5clang12ast_matchers7dynamic6Parser13CodeTokenizer13nextTokenKindEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZNK5clang12ast_matchers7dynamic6Parser13CodeTokenizer13nextTokenKindEv")
    //</editor-fold>
    public TokenInfo.TokenKind nextTokenKind() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::getNextToken">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 86,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::getNextToken", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer12getNextTokenEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer12getNextTokenEv")
    //</editor-fold>
    private TokenInfo getNextToken() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Consume an unsigned literal.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::consumeUnsignedLiteral">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 173,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::consumeUnsignedLiteral", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer22consumeUnsignedLiteralEPNS2_9TokenInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer22consumeUnsignedLiteralEPNS2_9TokenInfoE")
    //</editor-fold>
    private void consumeUnsignedLiteral(TokenInfo /*P*/ Result) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Consume a string literal.
    ///
    /// \c Code must be positioned at the start of the literal (the opening
    /// quote). Consumed until it finds the same closing quote character.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::consumeStringLiteral">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 204,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::consumeStringLiteral", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer20consumeStringLiteralEPNS2_9TokenInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer20consumeStringLiteralEPNS2_9TokenInfoE")
    //</editor-fold>
    private void consumeStringLiteral(TokenInfo /*P*/ Result) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Consume all leading whitespace from \c Code.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::consumeWhitespace">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 235,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::consumeWhitespace", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer17consumeWhitespaceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer17consumeWhitespaceEv")
    //</editor-fold>
    private void consumeWhitespace() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::currentLocation">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 245,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::currentLocation", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer15currentLocationEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizer15currentLocationEv")
    //</editor-fold>
    private SourceLocation currentLocation() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    private StringRef Code;
    private StringRef StartOfLine;
    private /*uint*/int Line;
    private Diagnostics /*P*/ Error;
    private TokenInfo NextToken;
    private /*const*/char$ptr/*char P*/ CodeCompletionLocation;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::CodeTokenizer::~CodeTokenizer">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 58,
     FQN="clang::ast_matchers::dynamic::Parser::CodeTokenizer::~CodeTokenizer", NM="_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizerD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13CodeTokenizerD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Code=" + Code // NOI18N
                + ", StartOfLine=" + StartOfLine // NOI18N
                + ", Line=" + Line // NOI18N
                + ", Error=" + Error // NOI18N
                + ", NextToken=" + NextToken // NOI18N
                + ", CodeCompletionLocation=" + CodeCompletionLocation; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::ScopedContextEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 272,
   FQN="clang::ast_matchers::dynamic::Parser::ScopedContextEntry", NM="_ZN5clang12ast_matchers7dynamic6Parser18ScopedContextEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser18ScopedContextEntryE")
  //</editor-fold>
  private static class/*struct*/ ScopedContextEntry implements Destructors.ClassWithDestructor {
    public Parser /*P*/ P;
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::ScopedContextEntry::ScopedContextEntry">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 275,
     FQN="clang::ast_matchers::dynamic::Parser::ScopedContextEntry::ScopedContextEntry", NM="_ZN5clang12ast_matchers7dynamic6Parser18ScopedContextEntryC1EPS2_PKNS1_8internal17MatcherDescriptorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser18ScopedContextEntryC1EPS2_PKNS1_8internal17MatcherDescriptorE")
    //</editor-fold>
    public ScopedContextEntry(Parser /*P*/ P, /*const*/ MatcherDescriptor /*P*/ C) {
      // : P(P) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::ScopedContextEntry::~ScopedContextEntry">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 279,
     FQN="clang::ast_matchers::dynamic::Parser::ScopedContextEntry::~ScopedContextEntry", NM="_ZN5clang12ast_matchers7dynamic6Parser18ScopedContextEntryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser18ScopedContextEntryD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::ScopedContextEntry::nextArg">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 283,
     FQN="clang::ast_matchers::dynamic::Parser::ScopedContextEntry::nextArg", NM="_ZN5clang12ast_matchers7dynamic6Parser18ScopedContextEntry7nextArgEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser18ScopedContextEntry7nextArgEv")
    //</editor-fold>
    public void nextArg() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "P=" + "[Parser]"; // NOI18N
    }
  };
  
  /// \brief Simple structure to hold information for one token from the parser.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::TokenInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 29,
   FQN="clang::ast_matchers::dynamic::Parser::TokenInfo", NM="_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoE")
  //</editor-fold>
  private static class/*struct*/ TokenInfo implements Destructors.ClassWithDestructor {
    /// \brief Different possible tokens.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::TokenInfo::TokenKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 31,
     FQN="clang::ast_matchers::dynamic::Parser::TokenInfo::TokenKind", NM="_ZN5clang12ast_matchers7dynamic6Parser9TokenInfo9TokenKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser9TokenInfo9TokenKindE")
    //</editor-fold>
    public enum TokenKind implements Native.ComparableLower {
      TK_Eof(0),
      TK_OpenParen(TK_Eof.getValue() + 1),
      TK_CloseParen(TK_OpenParen.getValue() + 1),
      TK_Comma(TK_CloseParen.getValue() + 1),
      TK_Period(TK_Comma.getValue() + 1),
      TK_Literal(TK_Period.getValue() + 1),
      TK_Ident(TK_Literal.getValue() + 1),
      TK_InvalidChar(TK_Ident.getValue() + 1),
      TK_Error(TK_InvalidChar.getValue() + 1),
      TK_CodeCompletion(TK_Error.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static TokenKind valueOf(int val) {
        TokenKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final TokenKind[] VALUES;
        private static final TokenKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (TokenKind kind : TokenKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new TokenKind[min < 0 ? (1-min) : 0];
          VALUES = new TokenKind[max >= 0 ? (1+max) : 0];
          for (TokenKind kind : TokenKind.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private TokenKind(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TokenKind)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TokenKind)obj).value);}
      //</editor-fold>
    };
    
    /// \brief Some known identifiers.
    public static /*const*/char$ptr/*char P*//*const*/ ID_Bind = $("bind");
    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::TokenInfo::TokenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 47,
     FQN="clang::ast_matchers::dynamic::Parser::TokenInfo::TokenInfo", NM="_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoC1Ev")
    //</editor-fold>
    public TokenInfo() {
      // : Text(), Kind(TK_Eof), Range(), Value() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    public StringRef Text;
    public TokenKind Kind;
    public SourceRange Range;
    public VariantValue Value;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::TokenInfo::TokenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 29,
     FQN="clang::ast_matchers::dynamic::Parser::TokenInfo::TokenInfo", NM="_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoC1EOS3_")
    //</editor-fold>
    public /*inline*/ TokenInfo(JD$Move _dparam, final TokenInfo /*&&*/$Prm0) {
      // : Text(static_cast<TokenInfo &&>().Text), Kind(static_cast<TokenInfo &&>().Kind), Range(static_cast<TokenInfo &&>().Range), Value(static_cast<TokenInfo &&>().Value) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::TokenInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 29,
     FQN="clang::ast_matchers::dynamic::Parser::TokenInfo::operator=", NM="_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoaSEOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoaSEOS3_")
    //</editor-fold>
    public /*inline*/ TokenInfo /*&*/ $assignMove(final TokenInfo /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::TokenInfo::~TokenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 29,
     FQN="clang::ast_matchers::dynamic::Parser::TokenInfo::~TokenInfo", NM="_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::TokenInfo::TokenInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 29,
     FQN="clang::ast_matchers::dynamic::Parser::TokenInfo::TokenInfo", NM="_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoC1ERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser9TokenInfoC1ERKS3_")
    //</editor-fold>
    public /*inline*/ TokenInfo(final /*const*/ TokenInfo /*&*/ $Prm0) {
      // : Text(.Text), Kind(.Kind), Range(.Range), Value(.Value) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Text=" + Text // NOI18N
                + ", Kind=" + Kind // NOI18N
                + ", Range=" + Range // NOI18N
                + ", Value=" + Value; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::Parser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 524,
   FQN="clang::ast_matchers::dynamic::Parser::Parser", NM="_ZN5clang12ast_matchers7dynamic6ParserC1EPNS2_13CodeTokenizerEPNS2_4SemaEPKN4llvm9StringMapINS1_12VariantValueENS7_15MallocAllocatorEEEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6ParserC1EPNS2_13CodeTokenizerEPNS2_4SemaEPKN4llvm9StringMapINS1_12VariantValueENS7_15MallocAllocatorEEEPNS1_11DiagnosticsE")
  //</editor-fold>
  private Parser(CodeTokenizer /*P*/ Tokenizer, Sema /*P*/ S, 
      /*const*/StringMap<VariantValue> /*P*/ NamedValues, Diagnostics /*P*/ Error) {
    // : Tokenizer(Tokenizer), S(S ? S : &* DefaultRegistrySema), NamedValues(NamedValues), Error(Error), ContextStack(), Completions() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  /// \brief Parse an <Expresssion>
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseExpressionImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 487,
   FQN="clang::ast_matchers::dynamic::Parser::parseExpressionImpl", NM="_ZN5clang12ast_matchers7dynamic6Parser19parseExpressionImplEPNS1_12VariantValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser19parseExpressionImplEPNS1_12VariantValueE")
  //</editor-fold>
  private boolean parseExpressionImpl(VariantValue /*P*/ Value) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Parse and validate a matcher expression.
  /// \return \c true on success, in which case \c Value has the matcher parsed.
  ///   If the input is malformed, or some argument has an error, it
  ///   returns \c false.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseMatcherExpressionImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 325,
   FQN="clang::ast_matchers::dynamic::Parser::parseMatcherExpressionImpl", NM="_ZN5clang12ast_matchers7dynamic6Parser26parseMatcherExpressionImplERKNS2_9TokenInfoEPNS1_12VariantValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser26parseMatcherExpressionImplERKNS2_9TokenInfoEPNS1_12VariantValueE")
  //</editor-fold>
  private boolean parseMatcherExpressionImpl(final /*const*/ TokenInfo /*&*/ NameToken, 
                            VariantValue /*P*/ Value) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Parse expressions that start with an identifier.
  ///
  /// This function can parse named values and matchers.
  /// In case of failure it will try to determine the user's intent to give
  /// an appropriate error message.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::parseIdentifierPrefixImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 293,
   FQN="clang::ast_matchers::dynamic::Parser::parseIdentifierPrefixImpl", NM="_ZN5clang12ast_matchers7dynamic6Parser25parseIdentifierPrefixImplEPNS1_12VariantValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser25parseIdentifierPrefixImplEPNS1_12VariantValueE")
  //</editor-fold>
  private boolean parseIdentifierPrefixImpl(VariantValue /*P*/ Value) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  // If the prefix of this completion matches the completion token, add it to
  // Completions minus the prefix.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::addCompletion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 439,
   FQN="clang::ast_matchers::dynamic::Parser::addCompletion", NM="_ZN5clang12ast_matchers7dynamic6Parser13addCompletionERKNS2_9TokenInfoERKNS1_17MatcherCompletionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser13addCompletionERKNS2_9TokenInfoERKNS1_17MatcherCompletionE")
  //</editor-fold>
  private void addCompletion(final /*const*/ TokenInfo /*&*/ CompToken, 
               final /*const*/ MatcherCompletion /*&*/ Completion) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::addExpressionCompletions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 463,
   FQN="clang::ast_matchers::dynamic::Parser::addExpressionCompletions", NM="_ZN5clang12ast_matchers7dynamic6Parser24addExpressionCompletionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser24addExpressionCompletionsEv")
  //</editor-fold>
  private void addExpressionCompletions() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::getNamedValueCompletions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 448,
   FQN="clang::ast_matchers::dynamic::Parser::getNamedValueCompletions", NM="_ZN5clang12ast_matchers7dynamic6Parser24getNamedValueCompletionsEN4llvm8ArrayRefINS1_7ArgKindEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6Parser24getNamedValueCompletionsEN4llvm8ArrayRefINS1_7ArgKindEEE")
  //</editor-fold>
  private std.vector<MatcherCompletion> getNamedValueCompletions(ArrayRef<ArgKind> AcceptedTypes) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private CodeTokenizer /*P*/ /*const*/ Tokenizer;
  private Sema /*P*/ /*const*/ S;
  private /*const*/StringMap<VariantValue> /*P*/ NamedValues;
  private Diagnostics /*P*/ /*const*/ Error;
  
  /*typedef std::vector<std::pair<MatcherCtor, unsigned int> > ContextStackTy*/
//  public final class ContextStackTy extends std.vector<std.pairTypeUInt</*const*/ MatcherDescriptor /*P*/ >>{ };
  private std.vector<std.pairTypeUInt</*const*/ MatcherDescriptor /*P*/ >> ContextStack;
  private std.vector<MatcherCompletion> Completions;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::Parser::~Parser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/Dynamic/Parser.h", line = 50,
   FQN="clang::ast_matchers::dynamic::Parser::~Parser", NM="_ZN5clang12ast_matchers7dynamic6ParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamic6ParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Tokenizer=" + Tokenizer // NOI18N
              + ", S=" + "[Sema]" // NOI18N
              + ", NamedValues=" + NamedValues // NOI18N
              + ", Error=" + Error // NOI18N
              + ", ContextStack=" + ContextStack // NOI18N
              + ", Completions=" + Completions; // NOI18N
  }
}
