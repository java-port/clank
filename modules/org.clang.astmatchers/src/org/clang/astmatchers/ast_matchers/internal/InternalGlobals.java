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


//<editor-fold defaultstate="collapsed" desc="static type InternalGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal11makeMatcherEPNS1_16MatcherInterfaceIT_EE;Tpl__ZN5clang12ast_matchers8internal18makeAllOfCompositeEN4llvm8ArrayRefIPKNS1_7MatcherIT_EEEE;Tpl__ZN5clang12ast_matchers8internal19matchesFirstInRangeERKT_T0_S5_PNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE;Tpl__ZN5clang12ast_matchers8internal25makeDynCastAllOfCompositeEN4llvm8ArrayRefIPKNS1_7MatcherIT0_EEEE;Tpl__ZN5clang12ast_matchers8internal26matchesFirstInPointerRangeERKT_T0_S5_PNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE;_ZN5clang12ast_matchers8internal14hasAnyNameFuncEN4llvm8ArrayRefIPKNS2_9StringRefEEE;_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_15TypedefNameDeclE;_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_4ExprE;_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_9ValueDeclE;_ZN5clang12ast_matchers8internal20getFunctionProtoTypeERKNS_12FunctionDeclE;_ZN5clang12ast_matchers8internal20getFunctionProtoTypeERKNS_17FunctionProtoTypeE;_ZN5clang12ast_matchers8internal29getTemplateSpecializationArgsERKNS_26TemplateSpecializationTypeE;_ZN5clang12ast_matchers8internal29getTemplateSpecializationArgsERKNS_31ClassTemplateSpecializationDeclE; -static-type=InternalGlobals -package=org.clang.astmatchers.ast_matchers.internal")
//</editor-fold>
public final class InternalGlobals {


/// \brief Unifies obtaining the underlying type of a regular node through
/// `getType` and a TypedefNameDecl node through `getUnderlyingType`.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::getUnderlyingType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 99,
 FQN="clang::ast_matchers::internal::getUnderlyingType", NM="_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_4ExprE")
//</editor-fold>
public static /*inline*/ QualType getUnderlyingType(final /*const*/ Expr /*&*/ Node) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::getUnderlyingType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 101,
 FQN="clang::ast_matchers::internal::getUnderlyingType", NM="_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_9ValueDeclE")
//</editor-fold>
public static /*inline*/ QualType getUnderlyingType(final /*const*/ ValueDecl /*&*/ Node) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::getUnderlyingType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 105,
 FQN="clang::ast_matchers::internal::getUnderlyingType", NM="_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_15TypedefNameDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal17getUnderlyingTypeERKNS_15TypedefNameDeclE")
//</editor-fold>
public static /*inline*/ QualType getUnderlyingType(final /*const*/ TypedefNameDecl /*&*/ Node) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Unifies obtaining the FunctionProtoType pointer from both
/// FunctionProtoType and FunctionDecl nodes..
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::getFunctionProtoType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 111,
 FQN="clang::ast_matchers::internal::getFunctionProtoType", NM="_ZN5clang12ast_matchers8internal20getFunctionProtoTypeERKNS_17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal20getFunctionProtoTypeERKNS_17FunctionProtoTypeE")
//</editor-fold>
public static /*inline*/ /*const*/ FunctionProtoType /*P*/ getFunctionProtoType(final /*const*/ FunctionProtoType /*&*/ Node) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::getFunctionProtoType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 116,
 FQN="clang::ast_matchers::internal::getFunctionProtoType", NM="_ZN5clang12ast_matchers8internal20getFunctionProtoTypeERKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal20getFunctionProtoTypeERKNS_12FunctionDeclE")
//</editor-fold>
public static /*inline*/ /*const*/ FunctionProtoType /*P*/ getFunctionProtoType(final /*const*/ FunctionDecl /*&*/ Node) {
  throw new UnsupportedOperationException("EmptyBody");
}

// class Matcher

/// \brief A convenient helper for creating a Matcher<T> without specifying
/// the template type argument.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::makeMatcher">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 567,
 FQN="clang::ast_matchers::internal::makeMatcher", NM="Tpl__ZN5clang12ast_matchers8internal11makeMatcherEPNS1_16MatcherInterfaceIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal11makeMatcherEPNS1_16MatcherInterfaceIT_EE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> Matcher<T> makeMatcher(MatcherInterface<T> /*P*/ Implementation) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Finds the first node in a range that matches the given matcher.
/*template <typename MatcherT, typename IteratorT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::matchesFirstInRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 589,
 FQN="clang::ast_matchers::internal::matchesFirstInRange", NM="Tpl__ZN5clang12ast_matchers8internal19matchesFirstInRangeERKT_T0_S5_PNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal19matchesFirstInRangeERKT_T0_S5_PNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE")
//</editor-fold>
public static </*typename*/ MatcherT, /*typename*/ IteratorT> boolean matchesFirstInRange(final /*const*/ MatcherT /*&*/ Matcher, IteratorT Start, 
                   IteratorT End, ASTMatchFinder /*P*/ Finder, 
                   BoundNodesTreeBuilder /*P*/ Builder) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Finds the first node in a pointer range that matches the given
/// matcher.
/*template <typename MatcherT, typename IteratorT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::matchesFirstInPointerRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 605,
 FQN="clang::ast_matchers::internal::matchesFirstInPointerRange", NM="Tpl__ZN5clang12ast_matchers8internal26matchesFirstInPointerRangeERKT_T0_S5_PNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal26matchesFirstInPointerRangeERKT_T0_S5_PNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE")
//</editor-fold>
public static </*typename*/ MatcherT, /*typename*/ IteratorT> boolean matchesFirstInPointerRange(final /*const*/ MatcherT /*&*/ Matcher, IteratorT Start, 
                          IteratorT End, ASTMatchFinder /*P*/ Finder, 
                          BoundNodesTreeBuilder /*P*/ Builder) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Trampoline function to use VariadicFunction<> to construct a
///        HasNameMatcher.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::hasAnyNameFunc">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 297,
 FQN="clang::ast_matchers::internal::hasAnyNameFunc", NM="_ZN5clang12ast_matchers8internal14hasAnyNameFuncEN4llvm8ArrayRefIPKNS2_9StringRefEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal14hasAnyNameFuncEN4llvm8ArrayRefIPKNS2_9StringRefEEE")
//</editor-fold>
public static Matcher<NamedDecl> hasAnyNameFunc(ArrayRef</*const*/ StringRef /*P*/ > NameRefs) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Creates a Matcher<T> that matches if all inner matchers match.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::makeAllOfComposite">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1270,
 FQN="clang::ast_matchers::internal::makeAllOfComposite", NM="Tpl__ZN5clang12ast_matchers8internal18makeAllOfCompositeEN4llvm8ArrayRefIPKNS1_7MatcherIT_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal18makeAllOfCompositeEN4llvm8ArrayRefIPKNS1_7MatcherIT_EEEE")
//</editor-fold>
public static </*typename*/ T> BindableMatcher<T> makeAllOfComposite(ArrayRef</*const*/ Matcher<T> /*P*/ > InnerMatchers) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Creates a Matcher<T> that matches if
/// T is dyn_cast'able into InnerT and all inner matchers match.
///
/// Returns BindableMatcher, as matchers that use dyn_cast have
/// the same object both to match on and to run submatchers on,
/// so there is no ambiguity with what gets bound.
/*template <typename T, typename InnerT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::makeDynCastAllOfComposite">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1300,
 FQN="clang::ast_matchers::internal::makeDynCastAllOfComposite", NM="Tpl__ZN5clang12ast_matchers8internal25makeDynCastAllOfCompositeEN4llvm8ArrayRefIPKNS1_7MatcherIT0_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal25makeDynCastAllOfCompositeEN4llvm8ArrayRefIPKNS1_7MatcherIT0_EEEE")
//</editor-fold>
public static </*typename*/ T, /*typename*/ InnerT> BindableMatcher<T> makeDynCastAllOfComposite(ArrayRef</*const*/ Matcher<InnerT> /*P*/ > InnerMatchers) {
  throw new UnsupportedOperationException("EmptyBody");
}


// FIXME: unify ClassTemplateSpecializationDecl and TemplateSpecializationType's
// APIs for accessing the template argument list.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::getTemplateSpecializationArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1631,
 FQN="clang::ast_matchers::internal::getTemplateSpecializationArgs", NM="_ZN5clang12ast_matchers8internal29getTemplateSpecializationArgsERKNS_31ClassTemplateSpecializationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal29getTemplateSpecializationArgsERKNS_31ClassTemplateSpecializationDeclE")
//</editor-fold>
public static /*inline*/ ArrayRef<TemplateArgument> getTemplateSpecializationArgs(final /*const*/ ClassTemplateSpecializationDecl /*&*/ D) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::getTemplateSpecializationArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1636,
 FQN="clang::ast_matchers::internal::getTemplateSpecializationArgs", NM="_ZN5clang12ast_matchers8internal29getTemplateSpecializationArgsERKNS_26TemplateSpecializationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal29getTemplateSpecializationArgsERKNS_26TemplateSpecializationTypeE")
//</editor-fold>
public static /*inline*/ ArrayRef<TemplateArgument> getTemplateSpecializationArgs(final /*const*/ TemplateSpecializationType /*&*/ T) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class InternalGlobals
