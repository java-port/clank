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
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
//import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;


/// \brief Simple callback implementation. Marshaller and function are provided.
///
/// This class wraps a function of arbitrary signature and a marshaller
/// function into a MatcherDescriptor.
/// The marshaller is in charge of taking the VariantValue arguments, checking
/// their types, unpacking them and calling the underlying function.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 182,
 FQN="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptorE")
//</editor-fold>
public class FixedArgCountMatcherDescriptor extends /*public*/ MatcherDescriptor implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef VariantMatcher (*MarshallerType)(void (*)(), StringRef, SourceRange, ArrayRef<ParserValue>, Diagnostics *)*/
//  public final class MarshallerType extends MarshallerType$Fun{ };
  
  /// \param Marshaller Function to unpack the arguments and call \c Func
  /// \param Func Matcher construct function. This is the function that
  ///   compile-time matcher expressions would use to create the matcher.
  /// \param RetKinds The list of matcher types to which the matcher is
  ///   convertible.
  /// \param ArgKinds The types of the arguments this matcher takes.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::FixedArgCountMatcherDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 196,
   FQN="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::FixedArgCountMatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptorC1EPFNS1_14VariantMatcherEPFvvEN4llvm9StringRefENS1_11SourceRangeENS7_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsEES6_S8_NSA_INS_15ast_type_traits11ASTNodeKindEEENSA_INS1_7ArgKindEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptorC1EPFNS1_14VariantMatcherEPFvvEN4llvm9StringRefENS1_11SourceRangeENS7_8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsEES6_S8_NSA_INS_15ast_type_traits11ASTNodeKindEEENSA_INS1_7ArgKindEEE")
  //</editor-fold>
  public FixedArgCountMatcherDescriptor(MarshallerType$Fun Marshaller, Void2Void Func, StringRef MatcherName, 
      ArrayRef<ASTNodeKind> RetKinds, 
      ArrayRef<ArgKind> ArgKinds) {
    // : MatcherDescriptor(), Marshaller(Marshaller), Func(Func), MatcherName(MatcherName.operator basic_string()), RetKinds(RetKinds.begin(), RetKinds.end()), ArgKinds(ArgKinds.begin(), ArgKinds.end()) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 204,
   FQN="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::create", NM="_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor6createENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor6createENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
  //</editor-fold>
  @Override public VariantMatcher create(SourceRange NameRange, 
        ArrayRef<ParserValue> Args, 
        Diagnostics /*P*/ Error) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::isVariadic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 210,
   FQN="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::isVariadic", NM="_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor10isVariadicEv")
  //</editor-fold>
  @Override public boolean isVariadic() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 211,
   FQN="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::getNumArgs", NM="_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor10getNumArgsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumArgs() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::getArgKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 212,
   FQN="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::getArgKinds", NM="_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor11getArgKindsENS_15ast_type_traits11ASTNodeKindEjRSt6vectorINS1_7ArgKindESaIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor11getArgKindsENS_15ast_type_traits11ASTNodeKindEjRSt6vectorINS1_7ArgKindESaIS7_EE")
  //</editor-fold>
  @Override public void getArgKinds(ASTNodeKind ThisKind, /*uint*/int ArgNo, 
             final std.vector<ArgKind> /*&*/ Kinds) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::isConvertibleTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 216,
   FQN="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPjPS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptor15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPjPS5_")
  //</editor-fold>
  @Override public boolean isConvertibleTo(ASTNodeKind Kind, uint$ptr/*uint P*/ Specificity, 
                 ASTNodeKind /*P*/ LeastDerivedKind) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private /*const*/ MarshallerType$Fun Marshaller;
  private /*const*/Void2Void Func;
  private /*const*/std.string MatcherName;
  private /*const*/std.vector<ASTNodeKind> RetKinds;
  private /*const*/std.vector<ArgKind> ArgKinds;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::~FixedArgCountMatcherDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 182,
   FQN="clang::ast_matchers::dynamic::internal::FixedArgCountMatcherDescriptor::~FixedArgCountMatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal30FixedArgCountMatcherDescriptorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Marshaller=" + Marshaller // NOI18N
              + ", Func=" + Func // NOI18N
              + ", MatcherName=" + MatcherName // NOI18N
              + ", RetKinds=" + RetKinds // NOI18N
              + ", ArgKinds=" + ArgKinds // NOI18N
              + super.toString(); // NOI18N
  }
}
