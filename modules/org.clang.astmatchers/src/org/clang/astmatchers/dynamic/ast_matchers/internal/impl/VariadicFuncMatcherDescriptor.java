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
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;
import org.llvm.adt.ADTFunctionPointers.ArrayRefOfPtrs2ResultType;


/// \brief Matcher descriptor for variadic functions.
///
/// This class simply wraps a VariadicFunction with the right signature to export
/// it as a MatcherDescriptor.
/// This allows us to have one implementation of the interface for as many free
/// functions as we want, reducing the number of symbols and size of the
/// object file.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 341,
 FQN="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptorE")
//</editor-fold>
public class VariadicFuncMatcherDescriptor extends /*public*/ MatcherDescriptor implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef VariantMatcher (*RunFunc)(StringRef, SourceRange, ArrayRef<ParserValue>, Diagnostics *)*/
//  public final class RunFunc extends VariadicFuncMatcherDescriptor$RunFunc{ };
  
  /*template <typename ResultT, typename ArgT, ResultT (*)(ArrayRef<const ArgT *>) F> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::VariadicFuncMatcherDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 350,
   FQN="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::VariadicFuncMatcherDescriptor", NM="Tpl__ZN5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptorC1ENS0_8internal16VariadicFunctionIT_T0_XT1_EEEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=Tpl__ZN5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptorC1ENS0_8internal16VariadicFunctionIT_T0_XT1_EEEN4llvm9StringRefE")
  //</editor-fold>
  public </*typename*/ ResultT, /*typename*/ ArgT/*, F extends ArrayRefOfPtrs2ResultType<ArgT, ResultT>*/> VariadicFuncMatcherDescriptor(VariadicFunction<ResultT, ArgT/*, F*/> Func, 
      StringRef MatcherName) {
    // : Func(& variadicMatcherDescriptor<ResultT, ArgT, F>), MatcherName(MatcherName.str()), ArgsKind(ArgTypeTraits<ArgT>::getKind()) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 359,
   FQN="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::create", NM="_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor6createENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor6createENS1_11SourceRangeEN4llvm8ArrayRefINS1_11ParserValueEEEPNS1_11DiagnosticsE")
  //</editor-fold>
  @Override public VariantMatcher create(SourceRange NameRange, 
        ArrayRef<ParserValue> Args, 
        Diagnostics /*P*/ Error) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::isVariadic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 365,
   FQN="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::isVariadic", NM="_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor10isVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor10isVariadicEv")
  //</editor-fold>
  @Override public boolean isVariadic() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 366,
   FQN="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::getNumArgs", NM="_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor10getNumArgsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumArgs() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::getArgKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 367,
   FQN="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::getArgKinds", NM="_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor11getArgKindsENS_15ast_type_traits11ASTNodeKindEjRSt6vectorINS1_7ArgKindESaIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor11getArgKindsENS_15ast_type_traits11ASTNodeKindEjRSt6vectorINS1_7ArgKindESaIS7_EE")
  //</editor-fold>
  @Override public void getArgKinds(ASTNodeKind ThisKind, /*uint*/int ArgNo, 
             final std.vector<ArgKind> /*&*/ Kinds) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::isConvertibleTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 371,
   FQN="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::isConvertibleTo", NM="_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPjPS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZNK5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptor15isConvertibleToENS_15ast_type_traits11ASTNodeKindEPjPS5_")
  //</editor-fold>
  @Override public boolean isConvertibleTo(ASTNodeKind Kind, uint$ptr/*uint P*/ Specificity, 
                 ASTNodeKind /*P*/ LeastDerivedKind) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private /*const*/VariadicFuncMatcherDescriptor$RunFunc Func;
  private /*const*/std.string MatcherName;
  private std.vector<ASTNodeKind> RetKinds;
  private /*const*/ ArgKind ArgsKind;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::~VariadicFuncMatcherDescriptor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Marshallers.h", line = 341,
   FQN="clang::ast_matchers::dynamic::internal::VariadicFuncMatcherDescriptor::~VariadicFuncMatcherDescriptor", NM="_ZN5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic8internal29VariadicFuncMatcherDescriptorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Func=" + Func // NOI18N
              + ", MatcherName=" + MatcherName // NOI18N
              + ", RetKinds=" + RetKinds // NOI18N
              + ", ArgsKind=" + ArgsKind // NOI18N
              + super.toString(); // NOI18N
  }
}
