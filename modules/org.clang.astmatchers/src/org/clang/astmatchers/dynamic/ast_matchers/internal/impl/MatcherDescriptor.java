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

package org.clang.astmatchers.dynamic.ast_matchers.internal.impl;

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
//import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;


/// \brief Matcher descriptor interface.
///
/// Provides a \c create() method that constructs the matcher from the provided
/// arguments, and various other methods for type introspection.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 125,
 FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal17MatcherDescriptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal17MatcherDescriptorE")
//</editor-fold>
public abstract class MatcherDescriptor implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor::~MatcherDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 127,
   FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor::~MatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal17MatcherDescriptorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal17MatcherDescriptorD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 128,
   FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor::create", NM="_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor6createENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor6createENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
  //</editor-fold>
  public abstract /*virtual*/ VariantMatcher create(SourceRange NameRange, 
        ArrayRef<ParserValue> Args, 
        Diagnostics /*P*/ Error) /*const*//* = 0*/;

  
  /// Returns whether the matcher is variadic. Variadic matchers can take any
  /// number of arguments, but they must be of the same type.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor::isVariadic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 134,
   FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor::isVariadic", NM="_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor10isVariadicEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean isVariadic() /*const*//* = 0*/;

  
  /// Returns the number of arguments accepted by the matcher if not variadic.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 137,
   FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor::getNumArgs", NM="_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor10getNumArgsEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getNumArgs() /*const*//* = 0*/;

  
  /// Given that the matcher is being converted to type \p ThisKind, append the
  /// set of argument types accepted for argument \p ArgNo to \p ArgKinds.
  // FIXME: We should provide the ability to constrain the output of this
  // function based on the types of other matcher arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor::getArgKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 143,
   FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor::getArgKinds", NM="_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor11getArgKindsENS_15ast_type_traits11ASTNodeKindEjRSt6vectorINS1_7ArgKindESaIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor11getArgKindsENS_15ast_type_traits11ASTNodeKindEjRSt6vectorINS1_7ArgKindESaIS7_EE")
  //</editor-fold>
  public abstract /*virtual*/ void getArgKinds(ASTNodeKind ThisKind, /*uint*/int ArgNo, 
             final std.vector<ArgKind> /*&*/ ArgKinds) /*const*//* = 0*/;

  
  /// Returns whether this matcher is convertible to the given type.  If it is
  /// so convertible, store in *Specificity a value corresponding to the
  /// "specificity" of the converted matcher to the given context, and in
  /// *LeastDerivedKind the least derived matcher kind which would result in the
  /// same matcher overload.  Zero specificity indicates that this conversion
  /// would produce a trivial matcher that will either always or never match.
  /// Such matchers are excluded from code completion results.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor::isConvertibleTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 153,
   FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPjPS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPjPS5_")
  //</editor-fold>
  public /*virtual*/ boolean isConvertibleTo(ASTNodeKind Kind) /*const*//* = 0*/ {
    return isConvertibleTo(Kind, null);
  }
  public /*virtual*/ boolean isConvertibleTo(ASTNodeKind Kind, uint$ptr/*uint P*/ Specificity/*= null*/) /*const*//* = 0*/ {
    return isConvertibleTo(Kind, Specificity, null);
  }
  public abstract /*virtual*/ boolean isConvertibleTo(ASTNodeKind Kind, uint$ptr/*uint P*/ Specificity/*= null*/, 
                 ASTNodeKind /*P*/ LeastDerivedKind/*= null*/) /*const*//* = 0*/;

  
  /// Returns whether the matcher will, given a matcher of any type T, yield a
  /// matcher of type T.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor::isPolymorphic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 159,
   FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor::isPolymorphic", NM="_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor13isPolymorphicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal17MatcherDescriptor13isPolymorphicEv")
  //</editor-fold>
  public /*virtual*/ boolean isPolymorphic() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::MatcherDescriptor::MatcherDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 125,
   FQN="clang::ast_matchers::dynamic::internal::MatcherDescriptor::MatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal17MatcherDescriptorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal17MatcherDescriptorC1Ev")
  //</editor-fold>
  public /*inline*/ MatcherDescriptor() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
