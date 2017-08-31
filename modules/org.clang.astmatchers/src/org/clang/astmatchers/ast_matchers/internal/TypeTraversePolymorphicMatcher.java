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


/// \brief Converts a \c Matcher<InnerT> to a \c Matcher<OuterT>, where
/// \c OuterT is any type that is supported by \c Getter.
///
/// \code Getter<OuterT>::value() \endcode returns a
/// \code InnerTBase (OuterT::*)() \endcode, which is used to adapt a \c OuterT
/// object into a \c InnerT
/*template <typename InnerTBase, template <typename OuterT> class Getter, template <typename OuterT> class MatcherImpl, typename ReturnTypesF> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1569,
 FQN="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher", NM="_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcherE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcherE")
//</editor-fold>
public class TypeTraversePolymorphicMatcher</*typename*/ InnerTBase, /*template <typename OuterT> TEMPLATE*/
/*class*/ Getter, /*template <typename OuterT> TEMPLATE*/
/*class*/ MatcherImpl, /*typename*/ ReturnTypesF>  {
/*private:*/
  /*typedef TypeTraversePolymorphicMatcher<InnerTBase, Getter, MatcherImpl, ReturnTypesF> Self*/
//  public final class Self extends TypeTraversePolymorphicMatcher<InnerTBase, Getter, MatcherImpl, ReturnTypesF>{ };
  
  // Define the create() method out of line to silence a GCC warning about
  // the struct "Func" having greater visibility than its base, which comes from
  // using the flag -fvisibility-inlines-hidden.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::create">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1620,
   FQN="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::create", NM="_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcher6createEN4llvm8ArrayRefIPKNS1_7MatcherIT_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcher6createEN4llvm8ArrayRefIPKNS1_7MatcherIT_EEEE")
  //</editor-fold>
  private static <InnerTBase, Getter, MatcherImpl, ReturnTypesF> TypeTraversePolymorphicMatcher<InnerTBase, Getter, MatcherImpl, ReturnTypesF> create(ArrayRef</*const*/ Matcher<InnerTBase> /*P*/ > InnerMatchers) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /*typedef typename ExtractFunctionArgMeta<ReturnTypesF>::type ReturnTypes*/
//  public final class ReturnTypes extends  ExtractFunctionArgMeta<ReturnTypesF>.type{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::TypeTraversePolymorphicMatcher<InnerTBase, Getter, MatcherImpl, ReturnTypesF>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1582,
   FQN="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::TypeTraversePolymorphicMatcher<InnerTBase, Getter, MatcherImpl, ReturnTypesF>", NM="_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcherC1EN4llvm8ArrayRefIPKNS1_7MatcherIT_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcherC1EN4llvm8ArrayRefIPKNS1_7MatcherIT_EEEE")
  //</editor-fold>
  public /*explicit*/ TypeTraversePolymorphicMatcher(ArrayRef</*const*/ Matcher<InnerTBase> /*P*/ > InnerMatchers) {
    // : InnerMatcher(makeAllOfComposite(InnerMatchers)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename OuterT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::operator Matcher<type-parameter-1-0>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1586,
   FQN="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::operator Matcher<type-parameter-1-0>", NM="Tpl__ZNK5clang12ast_matchers8internal30TypeTraversePolymorphicMatchercvNS1_7MatcherIT_EEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZNK5clang12ast_matchers8internal30TypeTraversePolymorphicMatchercvNS1_7MatcherIT_EEEv")
  //</editor-fold>
  public </*typename*/ OuterT> Matcher<OuterT> $Matcher$OuterT() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::Func">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1591,
   FQN="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::Func", NM="_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcher4FuncE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcher4FuncE")
  //</editor-fold>
  public static class/*struct*/ Func<InnerTBase, Getter, MatcherImpl, ReturnTypesF> extends /*public*/ VariadicFunction<TypeTraversePolymorphicMatcher<InnerTBase, Getter, MatcherImpl, ReturnTypesF>, Matcher<InnerTBase>/*, Native.$bitand(TypeTraversePolymorphicMatcher<InnerTBase, Getter, MatcherImpl, ReturnTypesF>.create)*/> {
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::Func::Func">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1593,
     FQN="clang::ast_matchers::internal::TypeTraversePolymorphicMatcher::Func::Func", NM="_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcher4FuncC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal30TypeTraversePolymorphicMatcher4FuncC1Ev")
    //</editor-fold>
    public Func() {
      super(/*???*//*, Native.$bitand(TypeTraversePolymorphicMatcher<InnerTBase, Getter, MatcherImpl, ReturnTypesF>.create)*/TypeTraversePolymorphicMatcher::create);
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
/*private:*/
  private /*const*/ Matcher<InnerTBase> InnerMatcher;
  
  @Override public String toString() {
    return "" + "InnerMatcher=" + InnerMatcher; // NOI18N
  }
}
