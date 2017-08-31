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
import org.clang.ast.java.AstJavaDifferentiators.*;
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


/// \brief Wrapper of a MatcherInterface<T> *that allows copying.
///
/// A Matcher<Base> can be used anywhere a Matcher<Derived> is
/// required. This establishes an is-a relationship which is reverse
/// to the AST hierarchy. In other words, Matcher<T> is contravariant
/// with respect to T. The relationship is built via a type conversion
/// operator rather than a type hierarchy to be able to templatize the
/// type hierarchy instead of spelling it out.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 467,
 FQN="clang::ast_matchers::internal::Matcher", NM="_ZN5clang12ast_matchers8internal7MatcherE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal7MatcherE")
//</editor-fold>
public class Matcher</*typename*/ T>  implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Takes ownership of the provided implementation pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::Matcher<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 471,
   FQN="clang::ast_matchers::internal::Matcher::Matcher<type-parameter-0-0>", NM="_ZN5clang12ast_matchers8internal7MatcherC1EPNS1_16MatcherInterfaceIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal7MatcherC1EPNS1_16MatcherInterfaceIT_EE")
  //</editor-fold>
  public /*explicit*/ Matcher(MatcherInterface<T> /*P*/ Implementation) {
    // : Implementation(Implementation) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Implicitly converts \c Other to a Matcher<T>.
  ///
  /// Requires \c T to be derived from \c From.
  /*template <typename From> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::Matcher<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 478,
   FQN="clang::ast_matchers::internal::Matcher::Matcher<type-parameter-0-0>", NM="Tpl__ZN5clang12ast_matchers8internal7MatcherC1ERKNS1_7MatcherIT_EEPNSt9enable_ifIXaasr3std10is_base_ofIS4_T_EE5valuentsr3std7is_sameIS4_S9_EE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal7MatcherC1ERKNS1_7MatcherIT_EEPNSt9enable_ifIXaasr3std10is_base_ofIS4_T_EE5valuentsr3std7is_sameIS4_S9_EE5valueEvE4typeE")
  //</editor-fold>
  public </*typename*/ From> Matcher(JD$BaseOfButNotSame _dparam, final /*const*/ Matcher<From> /*&*/ Other) {
    // : Implementation(restrictMatcher(Other.Implementation)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Implicitly converts \c Matcher<Type> to \c Matcher<QualType>.
  ///
  /// The resulting matcher is not strict, i.e. ignores qualifiers.
  /*template <typename TypeT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::Matcher<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 490,
   FQN="clang::ast_matchers::internal::Matcher::Matcher<type-parameter-0-0>", NM="Tpl__ZN5clang12ast_matchers8internal7MatcherC1ERKNS1_7MatcherIT_EEPNSt9enable_ifIXaasr3std7is_sameIT_NS_8QualTypeEEE5valuesr3std7is_sameIS4_NS_4TypeEEE5valueEvE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal7MatcherC1ERKNS1_7MatcherIT_EEPNSt9enable_ifIXaasr3std7is_sameIT_NS_8QualTypeEEE5valuesr3std7is_sameIS4_NS_4TypeEEE5valueEvE4typeE")
  //</editor-fold>
  public </*typename*/ TypeT> Matcher(JD$SameQualTypeAndType _dparam, final /*const*/ Matcher<TypeT> /*&*/ Other) {
    // : Implementation(new TypeToQualType<TypeT>(( Other ))) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Convert \c this into a \c Matcher<T> by applying dyn_cast<> to the
  /// argument.
  /// \c To must be a base class of \c T.
  /*template <typename To> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::dynCastTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 500,
   FQN="clang::ast_matchers::internal::Matcher::dynCastTo", NM="Tpl__ZNK5clang12ast_matchers8internal7Matcher9dynCastToEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZNK5clang12ast_matchers8internal7Matcher9dynCastToEv")
  //</editor-fold>
  public </*typename*/ To> Matcher<To> dynCastTo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Forwards the call to the underlying MatcherInterface<T> pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::matches">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 506,
   FQN="clang::ast_matchers::internal::Matcher::matches", NM="_ZNK5clang12ast_matchers8internal7Matcher7matchesERKT_PNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal7Matcher7matchesERKT_PNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE")
  //</editor-fold>
  public boolean matches(final /*const*/ T /*&*/ Node, 
         ASTMatchFinder /*P*/ Finder, 
         BoundNodesTreeBuilder /*P*/ Builder) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns an ID that uniquely identifies the matcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::getID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 514,
   FQN="clang::ast_matchers::internal::Matcher::getID", NM="_ZNK5clang12ast_matchers8internal7Matcher5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal7Matcher5getIDEv")
  //</editor-fold>
  public std.pairTypeULong<ASTNodeKind> getID() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Extract the dynamic matcher.
  ///
  /// The returned matcher keeps the same restrictions as \c this and remembers
  /// that it is meant to support nodes of type \c T.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::operator DynTypedMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 522,
   FQN="clang::ast_matchers::internal::Matcher::operator DynTypedMatcher", NM="_ZNK5clang12ast_matchers8internal7MatchercvNS1_15DynTypedMatcherEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal7MatchercvNS1_15DynTypedMatcherEEv")
  //</editor-fold>
  public DynTypedMatcher $DynTypedMatcher() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Allows the conversion of a \c Matcher<Type> to a \c
  /// Matcher<QualType>.
  ///
  /// Depending on the constructor argument, the matcher is either strict, i.e.
  /// does only matches in the absence of qualifiers, or not, i.e. simply
  /// ignores any qualifiers.
  /*template <typename TypeT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::TypeToQualType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 530,
   FQN="clang::ast_matchers::internal::Matcher::TypeToQualType", NM="_ZN5clang12ast_matchers8internal7Matcher14TypeToQualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal7Matcher14TypeToQualTypeE")
  //</editor-fold>
  public static class TypeToQualType</*typename*/ TypeT>  extends /*public*/ WrapperMatcherInterface<QualType> implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::TypeToQualType::TypeToQualType<TypeT>">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 533,
     FQN="clang::ast_matchers::internal::Matcher::TypeToQualType::TypeToQualType<TypeT>", NM="_ZN5clang12ast_matchers8internal7Matcher14TypeToQualTypeC1ERKNS1_7MatcherIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal7Matcher14TypeToQualTypeC1ERKNS1_7MatcherIT_EE")
    //</editor-fold>
    public TypeToQualType(final /*const*/ Matcher<TypeT> /*&*/ InnerMatcher) {
      // : TypeToQualType<TypeT>::WrapperMatcherInterface<QualType>(InnerMatcher) 
      /*ParenListExpr*/super(InnerMatcher.$DynTypedMatcher());
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::TypeToQualType::matches">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 536,
     FQN="clang::ast_matchers::internal::Matcher::TypeToQualType::matches", NM="_ZNK5clang12ast_matchers8internal7Matcher14TypeToQualType7matchesERKNS_8QualTypeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal7Matcher14TypeToQualType7matchesERKNS_8QualTypeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE")
    //</editor-fold>
    @Override public boolean matches(final /*const*/ QualType /*&*/ Node, ASTMatchFinder /*P*/ Finder, 
           BoundNodesTreeBuilder /*P*/ Builder) /*const*//* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
/*private:*/
  // For Matcher<T> <=> Matcher<U> conversions.
  /*friend template <typename U> class Matcher*/
  // For DynTypedMatcher::unconditionalConvertTo<T>.
  /*friend  class DynTypedMatcher*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::restrictMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 551,
   FQN="clang::ast_matchers::internal::Matcher::restrictMatcher", NM="_ZN5clang12ast_matchers8internal7Matcher15restrictMatcherERKNS1_15DynTypedMatcherE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal7Matcher15restrictMatcherERKNS1_15DynTypedMatcherE")
  //</editor-fold>
  private static DynTypedMatcher restrictMatcher(final /*const*/ DynTypedMatcher /*&*/ Other) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::Matcher::Matcher<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 555,
   FQN="clang::ast_matchers::internal::Matcher::Matcher<type-parameter-0-0>", NM="_ZN5clang12ast_matchers8internal7MatcherC1ERKNS1_15DynTypedMatcherE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal7MatcherC1ERKNS1_15DynTypedMatcherE")
  //</editor-fold>
  private /*explicit*/ Matcher(final /*const*/ DynTypedMatcher /*&*/ Implementation) {
    // : Implementation(restrictMatcher(Implementation)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  @Override
  public void $destroy() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  
  private DynTypedMatcher Implementation;
  
  @Override public String toString() {
    return "" + "Implementation=" + Implementation; // NOI18N
  }
}
