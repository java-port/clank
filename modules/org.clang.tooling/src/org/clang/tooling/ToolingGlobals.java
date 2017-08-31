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
package org.clang.tooling;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.rewrite.core.*;
import org.clang.frontend.*;
import org.clang.basic.vfs.*;
import org.clang.tooling.core.*;
import org.clang.ast.*;
import org.llvm.option.*;
import org.clang.tooling.*;
import org.clang.tooling.core.impl.MergedReplacement;
import static org.clang.tooling.impl.ToolingStatics.*;
import static org.clang.tooling.java.ToolingFunctionPointers.*;
import org.clank.java.stdimpl.StdSetType;
import static org.llvm.support.AdtsupportLlvmGlobals.*;



//<editor-fold defaultstate="collapsed" desc="static type ToolingGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Lookup.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN5clang7tooling24newFrontendActionFactoryEPT_PNS0_19SourceFileCallbacksE;Tpl__ZN5clang7tooling24newFrontendActionFactoryEv;_ZN5clang7tooling11deduplicateERSt6vectorINS0_11ReplacementESaIS2_EERS1_INS0_5RangeESaIS6_EE;_ZN5clang7tooling13newInvocationEPNS_17DiagnosticsEngineERKN4llvm11SmallVectorIPKcLj16EEE;_ZN5clang7tooling13runToolOnCodeEPNS_14FrontendActionERKN4llvm5TwineES6_St10shared_ptrINS_22PCHContainerOperationsEE;_ZN5clang7tooling15getAbsolutePathEN4llvm9StringRefE;_ZN5clang7tooling16buildASTFromCodeERKN4llvm5TwineES4_St10shared_ptrINS_22PCHContainerOperationsEE;_ZN5clang7tooling16combineAdjustersESt8functionIFSt6vectorISsSaISsEERKS4_N4llvm9StringRefEEESA_;_ZN5clang7tooling17mergeReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EES8_;_ZN5clang7tooling17replaceNestedNameEPKNS_19NestedNameSpecifierEPKNS_11DeclContextEPKNS_9NamedDeclEN4llvm9StringRefE;_ZN5clang7tooling19shiftedCodePositionERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EEj;_ZN5clang7tooling19shiftedCodePositionERKSt6vectorINS0_11ReplacementESaIS2_EEj;_ZN5clang7tooling20applyAllReplacementsEN4llvm9StringRefERKSt3setINS0_11ReplacementESt4lessIS4_ESaIS4_EE;_ZN5clang7tooling20applyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterE;_ZN5clang7tooling20applyAllReplacementsERKSt6vectorINS0_11ReplacementESaIS2_EERNS_8RewriterE;_ZN5clang7tooling21runToolOnCodeWithArgsEPNS_14FrontendActionERKN4llvm5TwineERKSt6vectorISsSaISsEES6_S6_St10shared_ptrINS_22PCHContainerOperationsEERKS7_ISt4pairISsSsESaISG_EE;_ZN5clang7tooling22calculateChangedRangesERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE;_ZN5clang7tooling23groupReplacementsByFileERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE;_ZN5clang7tooling24buildASTFromCodeWithArgsERKN4llvm5TwineERKSt6vectorISsSaISsEES4_S4_St10shared_ptrINS_22PCHContainerOperationsEE;_ZN5clang7tooling25getInsertArgumentAdjusterEPKcNS0_22ArgumentInsertPositionE;_ZN5clang7tooling25getInsertArgumentAdjusterERKSt6vectorISsSaISsEENS0_22ArgumentInsertPositionE;_ZN5clang7tooling26getClangSyntaxOnlyAdjusterEv;_ZN5clang7tooling27getClangStripOutputAdjusterEv;_ZN5clang7tooling29formatAndApplyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterEN4llvm9StringRefE;_ZN5clang7tooling30addTargetAndModeForProgramNameERSt6vectorISsSaISsEEN4llvm9StringRefE;_ZN5clang7tooling32calculateRangesAfterReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERKSt6vectorINS0_5RangeESaISA_EE;_ZN5clang7toolingeqERKNS0_11ReplacementES3_;_ZN5clang7toolingltERKNS0_11ReplacementES3_; -static-type=ToolingGlobals -package=org.clang.tooling -empty-body")
//</editor-fold>
public final class ToolingGlobals {


/// \brief Gets an argument adjuster that converts input command line arguments
/// to the "syntax check only" variant.

/// Add -fsyntax-only option to the commnand line arguments.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getClangSyntaxOnlyAdjuster">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp", line = 21,
 FQN="clang::tooling::getClangSyntaxOnlyAdjuster", NM="_ZN5clang7tooling26getClangSyntaxOnlyAdjusterEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp -nm=_ZN5clang7tooling26getClangSyntaxOnlyAdjusterEv")
//</editor-fold>
public static ArgumentsAdjuster getClangSyntaxOnlyAdjuster() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Gets an argument adjuster which removes output-related command line
/// arguments.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getClangStripOutputAdjuster">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp", line = 36,
 FQN="clang::tooling::getClangStripOutputAdjuster", NM="_ZN5clang7tooling27getClangStripOutputAdjusterEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp -nm=_ZN5clang7tooling27getClangStripOutputAdjusterEv")
//</editor-fold>
public static ArgumentsAdjuster getClangStripOutputAdjuster() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Gets an argument adjuster which inserts \p Extra arguments in the
/// specified position.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getInsertArgumentAdjuster">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp", line = 54,
 FQN="clang::tooling::getInsertArgumentAdjuster", NM="_ZN5clang7tooling25getInsertArgumentAdjusterERKSt6vectorISsSaISsEENS0_22ArgumentInsertPositionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp -nm=_ZN5clang7tooling25getInsertArgumentAdjusterERKSt6vectorISsSaISsEENS0_22ArgumentInsertPositionE")
//</editor-fold>
public static ArgumentsAdjuster getInsertArgumentAdjuster(final /*const*/std.vectorString/*&*/ Extra, 
                         ArgumentInsertPosition Pos) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Gets an argument adjuster which inserts an \p Extra argument in the
/// specified position.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getInsertArgumentAdjuster">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp", line = 72,
 FQN="clang::tooling::getInsertArgumentAdjuster", NM="_ZN5clang7tooling25getInsertArgumentAdjusterEPKcNS0_22ArgumentInsertPositionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp -nm=_ZN5clang7tooling25getInsertArgumentAdjusterEPKcNS0_22ArgumentInsertPositionE")
//</editor-fold>
public static ArgumentsAdjuster getInsertArgumentAdjuster(/*const*/char$ptr/*char P*/ Extra) {
  return getInsertArgumentAdjuster(Extra, 
                         ArgumentInsertPosition.END);
}
public static ArgumentsAdjuster getInsertArgumentAdjuster(/*const*/char$ptr/*char P*/ Extra, 
                         ArgumentInsertPosition Pos/*= ArgumentInsertPosition::END*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Gets an argument adjuster which adjusts the arguments in sequence
/// with the \p First adjuster and then with the \p Second one.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::combineAdjusters">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp", line = 77,
 FQN="clang::tooling::combineAdjusters", NM="_ZN5clang7tooling16combineAdjustersESt8functionIFSt6vectorISsSaISsEERKS4_N4llvm9StringRefEEESA_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp -nm=_ZN5clang7tooling16combineAdjustersESt8functionIFSt6vectorISsSaISsEERKS4_N4llvm9StringRefEEESA_")
//</editor-fold>
public static ArgumentsAdjuster combineAdjusters(ArgumentsAdjuster First, 
                ArgumentsAdjuster Second) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emulate a lookup to replace one nested name specifier with another using as
/// few additional namespace qualifications as possible.
///
/// This does not perform a full C++ lookup so ADL will not work.
///
/// \param Use The nested name to be replaced.
/// \param UseContext The context in which the nested name is contained. This
///                   will be used to minimize namespace qualifications.
/// \param FromDecl The declaration to which the nested name points.
/// \param ReplacementString The replacement nested name. Must be fully
///                          qualified including a leading "::".
/// \returns The new name to be inserted in place of the current nested name.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::replaceNestedName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Lookup.cpp", line = 85,
 FQN="clang::tooling::replaceNestedName", NM="_ZN5clang7tooling17replaceNestedNameEPKNS_19NestedNameSpecifierEPKNS_11DeclContextEPKNS_9NamedDeclEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Lookup.cpp -nm=_ZN5clang7tooling17replaceNestedNameEPKNS_19NestedNameSpecifierEPKNS_11DeclContextEPKNS_9NamedDeclEN4llvm9StringRefE")
//</editor-fold>
public static std.string replaceNestedName(/*const*/ NestedNameSpecifier /*P*/ Use, 
                 /*const*/ DeclContext /*P*/ UseContext, 
                 /*const*/ NamedDecl /*P*/ FromDecl, 
                 StringRef ReplacementString) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns a new FrontendActionFactory for a given type.
///
/// T must derive from clang::FrontendAction.
///
/// Example:
/// FrontendActionFactory *Factory =
///   newFrontendActionFactory<clang::SyntaxOnlyAction>();
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::newFrontendActionFactory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 353,
 FQN="clang::tooling::newFrontendActionFactory", NM="Tpl__ZN5clang7tooling24newFrontendActionFactoryEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=Tpl__ZN5clang7tooling24newFrontendActionFactoryEv")
//</editor-fold>
public static </*typename*/ T> std.unique_ptr<FrontendActionFactory> newFrontendActionFactory() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns a new FrontendActionFactory for any type that provides an
/// implementation of newASTConsumer().
///
/// FactoryT must implement: ASTConsumer *newASTConsumer().
///
/// Example:
/// struct ProvidesASTConsumers {
///   clang::ASTConsumer *newASTConsumer();
/// } Factory;
/// std::unique_ptr<FrontendActionFactory> FactoryAdapter(
///   newFrontendActionFactory(&Factory));
/*template <typename FactoryT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::newFrontendActionFactory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 364,
 FQN="clang::tooling::newFrontendActionFactory", NM="Tpl__ZN5clang7tooling24newFrontendActionFactoryEPT_PNS0_19SourceFileCallbacksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=Tpl__ZN5clang7tooling24newFrontendActionFactoryEPT_PNS0_19SourceFileCallbacksE")
//</editor-fold>
public static /*inline*/ </*typename*/ FactoryT> std.unique_ptr<FrontendActionFactory> newFrontendActionFactory(FactoryT /*P*/ ConsumerFactory) {
  return newFrontendActionFactory(ConsumerFactory, (SourceFileCallbacks /*P*/ )null);
}
public static /*inline*/ </*typename*/ FactoryT> std.unique_ptr<FrontendActionFactory> newFrontendActionFactory(FactoryT /*P*/ ConsumerFactory, SourceFileCallbacks /*P*/ Callbacks/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Groups \p Replaces by the file path and applies each group of
/// Replacements on the related file in \p Rewriter. In addition to applying
/// given Replacements, this function also formats the changed code.
///
/// \pre Replacements must be conflict-free.
///
/// Replacement applications happen independently of the success of other
/// applications.
///
/// \param[in] Replaces Replacements to apply.
/// \param[in] Rewrite The `Rewritter` to apply replacements on.
/// \param[in] Style The style name used for reformatting. See ```getStyle``` in
/// "include/clang/Format/Format.h" for all possible style forms.
///
/// \returns true if all replacements applied and formatted. false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::formatAndApplyAllReplacements">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp", line = 65,
 FQN="clang::tooling::formatAndApplyAllReplacements", NM="_ZN5clang7tooling29formatAndApplyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling29formatAndApplyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterEN4llvm9StringRefE")
//</editor-fold>
public static boolean formatAndApplyAllReplacements(final /*const*/ std.setType<Replacement> /*&*/ Replaces, 
                             final Rewriter /*&*/ Rewrite) {
  return formatAndApplyAllReplacements(Replaces, 
                             Rewrite, new StringRef(/*KEEP_STR*/"file"));
}
public static boolean formatAndApplyAllReplacements(final /*const*/ std.setType<Replacement> /*&*/ Replaces, 
                             final Rewriter /*&*/ Rewrite, StringRef Style/*= "file"*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Less-than operator between two Replacements.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::operator<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 83,
 FQN="clang::tooling::operator<", NM="_ZN5clang7toolingltERKNS0_11ReplacementES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7toolingltERKNS0_11ReplacementES3_")
//</editor-fold>
public static boolean $less_Replacement$C(final /*const*/ Replacement /*&*/ LHS, final /*const*/ Replacement /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Equal-to operator between two Replacements.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::operator==">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 98,
 FQN="clang::tooling::operator==", NM="_ZN5clang7toolingeqERKNS0_11ReplacementES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7toolingeqERKNS0_11ReplacementES3_")
//</editor-fold>
public static boolean $eq_Replacement$C(final /*const*/ Replacement /*&*/ LHS, final /*const*/ Replacement /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Apply all replacements in \p Replaces to the Rewriter \p Rewrite.
///
/// Replacement applications happen independently of the success of
/// other applications.
///
/// \returns true if all replacements apply. false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::applyAllReplacements">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 221,
 FQN="clang::tooling::applyAllReplacements", NM="_ZN5clang7tooling20applyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling20applyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterE")
//</editor-fold>
public static boolean applyAllReplacements(final /*const*/ std.setType<Replacement> /*&*/ Replaces, final Rewriter /*&*/ Rewrite) {
  boolean Result = true;
  for (StdSetType.iterator<Replacement> I = Replaces.begin(), 
      E = Replaces.end();
       I.$noteq(E); I.$preInc()) {
    if (I.$arrow().isApplicable()) {
      Result = I.$arrow().apply(Rewrite) && Result;
    } else {
      Result = false;
    }
  }
  return Result;
}


/// \brief Apply all replacements in \p Replaces to the Rewriter \p Rewrite.
///
/// Replacement applications happen independently of the success of
/// other applications.
///
/// \returns true if all replacements apply. false otherwise.

// FIXME: Remove this function when Replacements is implemented as std::vector
// instead of std::set.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::applyAllReplacements">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 237,
 FQN="clang::tooling::applyAllReplacements", NM="_ZN5clang7tooling20applyAllReplacementsERKSt6vectorINS0_11ReplacementESaIS2_EERNS_8RewriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling20applyAllReplacementsERKSt6vectorINS0_11ReplacementESaIS2_EERNS_8RewriterE")
//</editor-fold>
public static boolean applyAllReplacements(final /*const*/std.vector<Replacement> /*&*/ Replaces, 
                    final Rewriter /*&*/ Rewrite) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Applies all replacements in \p Replaces to \p Code.
///
/// This completely ignores the path stored in each replacement. If all
/// replacements are applied successfully, this returns the code with
/// replacements applied; otherwise, an llvm::Error carrying llvm::StringError
/// is returned (the Error message can be converted to string using
/// `llvm::toString()` and 'std::error_code` in the `Error` should be ignored).
//<editor-fold defaultstate="collapsed" desc="clang::tooling::applyAllReplacements">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 252,
 FQN="clang::tooling::applyAllReplacements", NM="_ZN5clang7tooling20applyAllReplacementsEN4llvm9StringRefERKSt3setINS0_11ReplacementESt4lessIS4_ESaIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling20applyAllReplacementsEN4llvm9StringRefERKSt3setINS0_11ReplacementESt4lessIS4_ESaIS4_EE")
//</editor-fold>
public static Expected<std.string> applyAllReplacements(StringRef Code, 
                    final /*const*/ std.setType<Replacement> /*&*/ Replaces) {
  IntrusiveRefCntPtr<InMemoryFileSystem> InMemoryFileSystem = null;
  FileManager Files = null;
  DiagnosticsEngine Diagnostics = null;
  SourceManager SourceMgr = null;
  Rewriter Rewrite = null;
  raw_string_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Replaces.empty()) {
      return new Expected<std.string>(JD$Convertible.INSTANCE, Code.str());
    }
    
    InMemoryFileSystem/*J*/= new IntrusiveRefCntPtr<InMemoryFileSystem>(new InMemoryFileSystem());
    Files/*J*/= $c$.clean(new FileManager(new FileSystemOptions(), $c$.track(new IntrusiveRefCntPtr<FileSystem>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, InMemoryFileSystem))));
    Diagnostics/*J*/= $c$.clean(new DiagnosticsEngine($c$.track(new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs())), 
        new DiagnosticOptions()));
    SourceMgr/*J*/= new SourceManager(Diagnostics, Files);
    Rewrite/*J*/= new Rewriter(SourceMgr, new LangOptions());
    $c$.clean(InMemoryFileSystem.$arrow().addFile(new Twine(/*KEEP_STR*/"<stdin>"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(Code), new StringRef(/*KEEP_STR*/"<stdin>")))));
    FileID ID = SourceMgr.createFileID(Files.getFile(new StringRef(/*KEEP_STR*/"<stdin>")), new SourceLocation(), 
        SrcMgr.CharacteristicKind.C_User);
    for (StdSetType.iterator<Replacement> I = Replaces.begin(), E = Replaces.end();
         I.$noteq(E); I.$preInc()) {
      Replacement Replace = null;
      try {
        Replace/*J*/= new Replacement(new StringRef(/*KEEP_STR*/"<stdin>"), I.$arrow().getOffset(), I.$arrow().getLength(), 
            I.$arrow().getReplacementText());
        if (!Replace.apply(Rewrite)) {
          return $c$.clean(new Expected<std.string>($c$.track(AdtsupportLlvmGlobals.make_error(
                  $add_T$C$P_string(/*KEEP_STR*/"Failed to apply replacement: ", Replace.__toString()), 
                  inconvertibleErrorCode()
          ))));
        }
      } finally {
        if (Replace != null) { Replace.$destroy(); }
      }
    }
    std.string Result/*J*/= new std.string();
    OS/*J*/= new raw_string_ostream(Result);
    Rewrite.getEditBuffer(new FileID(ID)).write(OS);
    OS.flush();
    return new Expected<std.string>(JD$Convertible.INSTANCE, Result);
  } finally {
    if (OS != null) { OS.$destroy(); }
    if (Rewrite != null) { Rewrite.$destroy(); }
    if (SourceMgr != null) { SourceMgr.$destroy(); }
    if (Diagnostics != null) { Diagnostics.$destroy(); }
    if (Files != null) { Files.$destroy(); }
    if (InMemoryFileSystem != null) { InMemoryFileSystem.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Calculates how a code \p Position is shifted when \p Replaces are
/// applied.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::shiftedCodePosition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 158,
 FQN="clang::tooling::shiftedCodePosition", NM="_ZN5clang7tooling19shiftedCodePositionERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling19shiftedCodePositionERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EEj")
//</editor-fold>
public static /*uint*/int shiftedCodePosition(final /*const*/ std.setType<Replacement> /*&*/ Replaces, /*uint*/int Position) {
  return shiftedCodePositionInternal(Replaces, Position);
}


/// \brief Calculates how a code \p Position is shifted when \p Replaces are
/// applied.
///
/// \pre Replaces[i].getOffset() <= Replaces[i+1].getOffset().

/// \brief Calculates how a code \p Position is shifted when \p Replaces are
/// applied.
///
/// \pre Replaces[i].getOffset() <= Replaces[i+1].getOffset().

// FIXME: Remove this function when Replacements is implemented as std::vector
// instead of std::set.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::shiftedCodePosition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 164,
 FQN="clang::tooling::shiftedCodePosition", NM="_ZN5clang7tooling19shiftedCodePositionERKSt6vectorINS0_11ReplacementESaIS2_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling19shiftedCodePositionERKSt6vectorINS0_11ReplacementESaIS2_EEj")
//</editor-fold>
public static /*uint*/int shiftedCodePosition(final /*const*/std.vector<Replacement> /*&*/ Replaces, 
                   /*uint*/int Position) {
  return shiftedCodePositionInternal(Replaces, Position);
}


/// \brief Removes duplicate Replacements and reports if Replacements conflict
/// with one another. All Replacements are assumed to be in the same file.
///
/// \post Replaces[i].getOffset() <= Replaces[i+1].getOffset().
///
/// This function sorts \p Replaces so that conflicts can be reported simply by
/// offset into \p Replaces and number of elements in the conflict.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::deduplicate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 169,
 FQN="clang::tooling::deduplicate", NM="_ZN5clang7tooling11deduplicateERSt6vectorINS0_11ReplacementESaIS2_EERS1_INS0_5RangeESaIS6_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling11deduplicateERSt6vectorINS0_11ReplacementESaIS2_EERS1_INS0_5RangeESaIS6_EE")
//</editor-fold>
public static void deduplicate(final std.vector<Replacement> /*&*/ Replaces, 
           final std.vector<Range> /*&*/ Conflicts) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Calculates the ranges in a single file that are affected by the
/// Replacements. Overlapping ranges will be merged.
///
/// \pre Replacements must be for the same file.
///
/// \returns a non-overlapping and sorted ranges.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::calculateChangedRanges">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 309,
 FQN="clang::tooling::calculateChangedRanges", NM="_ZN5clang7tooling22calculateChangedRangesERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling22calculateChangedRangesERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE")
//</editor-fold>
public static std.vector<Range> calculateChangedRanges(final /*const*/ std.setType<Replacement> /*&*/ Replaces) {
  std.vector<Range> ChangedRanges = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ChangedRanges/*J*/= new std.vector<Range>(new Range());
    int Shift = 0;
    for (final /*const*/ Replacement /*&*/ R : Replaces) {
      /*uint*/int Offset = R.getOffset() + Shift;
      /*uint*/int Length = R.getReplacementText().size();
      Shift += Length - R.getLength();
      ChangedRanges.push_back_T$RR(new Range(Offset, Length));
    }
    return $c$.clean(mergeAndSortRanges($c$.track(new std.vector<Range>(ChangedRanges))));
  } finally {
    if (ChangedRanges != null) { ChangedRanges.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Calculates the new ranges after \p Replaces are applied. These
/// include both the original \p Ranges and the affected ranges of \p Replaces
/// in the new code.
///
/// \pre Replacements must be for the same file.
///
/// \return The new ranges after \p Replaces are applied. The new ranges will be
/// sorted and non-overlapping.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::calculateRangesAfterReplacements">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 321,
 FQN="clang::tooling::calculateRangesAfterReplacements", NM="_ZN5clang7tooling32calculateRangesAfterReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERKSt6vectorINS0_5RangeESaISA_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling32calculateRangesAfterReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERKSt6vectorINS0_5RangeESaISA_EE")
//</editor-fold>
public static std.vector<Range> calculateRangesAfterReplacements(final /*const*/ std.setType<Replacement> /*&*/ Replaces, 
                                final /*const*/std.vector<Range> /*&*/ Ranges) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Groups a random set of replacements by file path. Replacements
/// related to the same file entry are put into the same vector.
// namespace
//<editor-fold defaultstate="collapsed" desc="clang::tooling::groupReplacementsByFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 430,
 FQN="clang::tooling::groupReplacementsByFile", NM="_ZN5clang7tooling23groupReplacementsByFileERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling23groupReplacementsByFileERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE")
//</editor-fold>
public static std.mapTypeType<std.string, std.setType<Replacement>> groupReplacementsByFile(final /*const*/ std.setType<Replacement> /*&*/ Replaces) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Merges two sets of replacements with the second set referring to the
/// code after applying the first set. Within both 'First' and 'Second',
/// replacements must not overlap.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::mergeReplacements">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 439,
 FQN="clang::tooling::mergeReplacements", NM="_ZN5clang7tooling17mergeReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling17mergeReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EES8_")
//</editor-fold>
public static std.setType<Replacement> mergeReplacements(final /*const*/ std.setType<Replacement> /*&*/ First, 
                 final /*const*/ std.setType<Replacement> /*&*/ Second) {
  std.setType<Replacement> Result = null;
  try {
    if (First.empty() || Second.empty()) {
      return new std.setType<Replacement>(First.empty() ? Second : First);
    }
    
    // Delta is the amount of characters that replacements from 'Second' need to
    // be shifted so that their offsets refer to the original text.
    int Delta = 0;
    Result/*J*/= new std.setType<Replacement>();
    
    // Iterate over both sets and always add the next element (smallest total
    // Offset) from either 'First' or 'Second'. Merge that element with
    // subsequent replacements as long as they overlap. See more details in the
    // comment on MergedReplacement.
    for (StdSetType.iterator<Replacement> FirstI = First.begin(), SecondI = Second.begin();
         FirstI.$noteq(First.end()) || SecondI.$noteq(Second.end());) {
      MergedReplacement Merged = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        boolean NextIsFirst = SecondI.$eq(Second.end())
           || (FirstI.$noteq(First.end())
           && $less_uint(FirstI.$arrow().getOffset(), SecondI.$arrow().getOffset() + Delta));
        Merged/*J*/= new MergedReplacement(NextIsFirst ? FirstI.$star() : SecondI.$star(), NextIsFirst, 
            Delta);
        (NextIsFirst ? FirstI : SecondI).$preInc();
        while ((Merged.mergeSecond() && SecondI.$noteq(Second.end()))
           || (!Merged.mergeSecond() && FirstI.$noteq(First.end()))) {
          final StdSetType.iterator<Replacement> /*&*/ I = Merged.mergeSecond() ? SecondI : FirstI;
          if (Merged.endsBefore(I.$star())) {
            break;
          }
          Merged.merge(I.$star());
          I.$preInc();
        }
        Delta -= Merged.deltaFirst();
        $c$.clean(Result.insert_T$RR($c$.track(Merged.asReplacement())));
      } finally {
        if (Merged != null) { Merged.$destroy(); }
        $c$.$destroy();
      }
    }
    return new std.setType<Replacement>(JD$Move.INSTANCE, Result);
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}


/// \brief Runs (and deletes) the tool on 'Code' with the -fsyntax-only flag.
///
/// \param ToolAction The action to run over the code.
/// \param Code C++ code.
/// \param FileName The file name which 'Code' will be mapped as.
/// \param PCHContainerOps  The PCHContainerOperations for loading and creating
///                         clang modules.
///
/// \return - True if 'ToolAction' was successfully executed.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::runToolOnCode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 104,
 FQN="clang::tooling::runToolOnCode", NM="_ZN5clang7tooling13runToolOnCodeEPNS_14FrontendActionERKN4llvm5TwineES6_St10shared_ptrINS_22PCHContainerOperationsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling13runToolOnCodeEPNS_14FrontendActionERKN4llvm5TwineES6_St10shared_ptrINS_22PCHContainerOperationsEE")
//</editor-fold>
public static boolean runToolOnCode(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code) {
  return runToolOnCode(ToolAction, Code, 
             new Twine(/*KEEP_STR*/"input.cc"), 
             std.make_shared(new PCHContainerOperations()));
}
public static boolean runToolOnCode(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
             final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/) {
  return runToolOnCode(ToolAction, Code, 
             FileName, 
             std.make_shared(new PCHContainerOperations()));
}
public static boolean runToolOnCode(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
             final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
             std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Runs (and deletes) the tool on 'Code' with the -fsyntax-only flag and
///        with additional other flags.
///
/// \param ToolAction The action to run over the code.
/// \param Code C++ code.
/// \param Args Additional flags to pass on.
/// \param FileName The file name which 'Code' will be mapped as.
/// \param ToolName The name of the binary running the tool. Standard library
///                 header paths will be resolved relative to this.
/// \param PCHContainerOps   The PCHContainerOperations for loading and creating
///                          clang modules.
///
/// \return - True if 'ToolAction' was successfully executed.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::runToolOnCodeWithArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 124,
 FQN="clang::tooling::runToolOnCodeWithArgs", NM="_ZN5clang7tooling21runToolOnCodeWithArgsEPNS_14FrontendActionERKN4llvm5TwineERKSt6vectorISsSaISsEES6_S6_St10shared_ptrINS_22PCHContainerOperationsEERKS7_ISt4pairISsSsESaISG_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling21runToolOnCodeWithArgsEPNS_14FrontendActionERKN4llvm5TwineERKSt6vectorISsSaISsEES6_S6_St10shared_ptrINS_22PCHContainerOperationsEERKS7_ISt4pairISsSsESaISG_EE")
//</editor-fold>
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args) {
  return runToolOnCodeWithArgs(ToolAction, Code, 
                     Args, new Twine(/*KEEP_STR*/"input.cc"), 
                     new Twine(/*KEEP_STR*/"clang-tool"), 
                     std.make_shared(new PCHContainerOperations()), 
                     new std.vector<std.pair<std.string, std.string>>(new pairTypeType<std.string, std.string>(new std.string(), new std.string())));
}
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/) {
  return runToolOnCodeWithArgs(ToolAction, Code, 
                     Args, FileName, 
                     new Twine(/*KEEP_STR*/"clang-tool"), 
                     std.make_shared(new PCHContainerOperations()), 
                     new std.vector<std.pair<std.string, std.string>>(new pairTypeType<std.string, std.string>(new std.string(), new std.string())));
}
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
                     final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/) {
  return runToolOnCodeWithArgs(ToolAction, Code, 
                     Args, FileName, 
                     ToolName, 
                     std.make_shared(new PCHContainerOperations()), 
                     new std.vector<std.pair<std.string, std.string>>(new pairTypeType<std.string, std.string>(new std.string(), new std.string())));
}
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
                     final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
  return runToolOnCodeWithArgs(ToolAction, Code, 
                     Args, FileName, 
                     ToolName, 
                     PCHContainerOps, 
                     new std.vector<std.pair<std.string, std.string>>(new pairTypeType<std.string, std.string>(new std.string(), new std.string())));
}
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
                     final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/, 
                     final /*const*/std.vector<std.pair<std.string, std.string>> /*&*/ VirtualMappedFiles/*= FileContentMappings()*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Builds an AST for 'Code'.
///
/// \param Code C++ code.
/// \param FileName The file name which 'Code' will be mapped as.
/// \param PCHContainerOps The PCHContainerOperations for loading and creating
/// clang modules.
///
/// \return The resulting AST or null if an error occurred.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::buildASTFromCode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 492,
 FQN="clang::tooling::buildASTFromCode", NM="_ZN5clang7tooling16buildASTFromCodeERKN4llvm5TwineES4_St10shared_ptrINS_22PCHContainerOperationsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling16buildASTFromCodeERKN4llvm5TwineES4_St10shared_ptrINS_22PCHContainerOperationsEE")
//</editor-fold>
public static std.unique_ptr<ASTUnit> buildASTFromCode(final /*const*/ Twine /*&*/ Code) {
  return buildASTFromCode(Code, new Twine(/*KEEP_STR*/"input.cc"), 
                std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCode(final /*const*/ Twine /*&*/ Code, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/) {
  return buildASTFromCode(Code, FileName, 
                std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCode(final /*const*/ Twine /*&*/ Code, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
                std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Builds an AST for 'Code' with additional flags.
///
/// \param Code C++ code.
/// \param Args Additional flags to pass on.
/// \param FileName The file name which 'Code' will be mapped as.
/// \param ToolName The name of the binary running the tool. Standard library
///                 header paths will be resolved relative to this.
/// \param PCHContainerOps The PCHContainerOperations for loading and creating
/// clang modules.
///
/// \return The resulting AST or null if an error occurred.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::buildASTFromCodeWithArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 499,
 FQN="clang::tooling::buildASTFromCodeWithArgs", NM="_ZN5clang7tooling24buildASTFromCodeWithArgsERKN4llvm5TwineERKSt6vectorISsSaISsEES4_S4_St10shared_ptrINS_22PCHContainerOperationsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling24buildASTFromCodeWithArgsERKN4llvm5TwineERKSt6vectorISsSaISsEES4_S4_St10shared_ptrINS_22PCHContainerOperationsEE")
//</editor-fold>
public static std.unique_ptr<ASTUnit> buildASTFromCodeWithArgs(final /*const*/ Twine /*&*/ Code, final /*const*/std.vectorString/*&*/ Args) {
  return buildASTFromCodeWithArgs(Code, Args, 
                        new Twine(/*KEEP_STR*/"input.cc"), new Twine(/*KEEP_STR*/"clang-tool"), 
                        std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCodeWithArgs(final /*const*/ Twine /*&*/ Code, final /*const*/std.vectorString/*&*/ Args, 
                        final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/) {
  return buildASTFromCodeWithArgs(Code, Args, 
                        FileName, new Twine(/*KEEP_STR*/"clang-tool"), 
                        std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCodeWithArgs(final /*const*/ Twine /*&*/ Code, final /*const*/std.vectorString/*&*/ Args, 
                        final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/) {
  return buildASTFromCodeWithArgs(Code, Args, 
                        FileName, ToolName, 
                        std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCodeWithArgs(final /*const*/ Twine /*&*/ Code, final /*const*/std.vectorString/*&*/ Args, 
                        final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/, 
                        std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns the absolute path of \c File, by prepending it with
/// the current directory if \c File is not absolute.
///
/// Otherwise returns \c File.
/// If 'File' starts with "./", the returned path will not contain the "./".
/// Otherwise, the returned path will contain the literal path-concatenation of
/// the current directory and \c File.
///
/// The difference to llvm::sys::fs::make_absolute is the canonicalization this
/// does by removing "./" and computing native paths.
///
/// \param File Either an absolute or relative path.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getAbsolutePath">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 158,
 FQN="clang::tooling::getAbsolutePath", NM="_ZN5clang7tooling15getAbsolutePathEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling15getAbsolutePathEN4llvm9StringRefE")
//</editor-fold>
public static std.string getAbsolutePath(StringRef File) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Changes CommandLine to contain implicit flags that would have been
/// defined had the compiler driver been invoked through the path InvokedAs.
///
/// For example, when called with \c InvokedAs set to `i686-linux-android-g++`,
/// the arguments '-target', 'i686-linux-android`, `--driver-mode=g++` will
/// be inserted after the first argument in \c CommandLine.
///
/// This function will not add new `-target` or `--driver-mode` flags if they
/// are already present in `CommandLine` (even if they have different settings
/// than would have been inserted).
///
/// \pre `llvm::InitializeAllTargets()` has been called.
///
/// \param CommandLine the command line used to invoke the compiler driver or
/// Clang tool, including the path to the executable as \c CommandLine[0].
/// \param InvokedAs the path to the driver used to infer implicit flags.
///
/// \note This will not set \c CommandLine[0] to \c InvokedAs. The tooling
/// infrastructure expects that CommandLine[0] is a tool path relative to which
/// the builtin headers can be found.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::addTargetAndModeForProgramName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 173,
 FQN="clang::tooling::addTargetAndModeForProgramName", NM="_ZN5clang7tooling30addTargetAndModeForProgramNameERSt6vectorISsSaISsEEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling30addTargetAndModeForProgramNameERSt6vectorISsSaISsEEN4llvm9StringRefE")
//</editor-fold>
public static void addTargetAndModeForProgramName(final std.vectorString/*&*/ CommandLine, 
                              StringRef InvokedAs) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Creates a \c CompilerInvocation.

/// \brief Returns a clang build invocation initialized from the CC1 flags.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::newInvocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 90,
 FQN="clang::tooling::newInvocation", NM="_ZN5clang7tooling13newInvocationEPNS_17DiagnosticsEngineERKN4llvm11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling13newInvocationEPNS_17DiagnosticsEngineERKN4llvm11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static CompilerInvocation /*P*/ newInvocation(DiagnosticsEngine /*P*/ Diagnostics, 
             final /*const*/ArgStringList/*&*/ CC1Args) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ToolingGlobals
