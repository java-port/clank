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
package org.clang.tooling.core.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.rewrite.core.*;
import org.clang.tooling.core.*;


//<editor-fold defaultstate="collapsed" desc="static type ReplacementToolingGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling11deduplicateERSt6vectorINS0_11ReplacementESaIS2_EERS1_INS0_5RangeESaIS6_EE;_ZN5clang7tooling17mergeReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EES8_;_ZN5clang7tooling19shiftedCodePositionERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EEj;_ZN5clang7tooling19shiftedCodePositionERKSt6vectorINS0_11ReplacementESaIS2_EEj;_ZN5clang7tooling20applyAllReplacementsEN4llvm9StringRefERKSt3setINS0_11ReplacementESt4lessIS4_ESaIS4_EE;_ZN5clang7tooling20applyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterE;_ZN5clang7tooling20applyAllReplacementsERKSt6vectorINS0_11ReplacementESaIS2_EERNS_8RewriterE;_ZN5clang7tooling22calculateChangedRangesERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE;_ZN5clang7tooling23groupReplacementsByFileERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE;_ZN5clang7tooling32calculateRangesAfterReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERKSt6vectorINS0_5RangeESaISA_EE;_ZN5clang7toolingeqERKNS0_11ReplacementES3_;_ZN5clang7toolingltERKNS0_11ReplacementES3_; -static-type=ReplacementToolingGlobals -package=org.clang.tooling.core.impl")
//</editor-fold>
public final class ReplacementToolingGlobals {


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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 221,
 FQN="clang::tooling::applyAllReplacements", NM="_ZN5clang7tooling20applyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling20applyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterE")
//</editor-fold>
public static boolean applyAllReplacements(final /*const*/ std.setType<Replacement> /*&*/ Replaces, final Rewriter /*&*/ Rewrite) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 252,
 FQN="clang::tooling::applyAllReplacements", NM="_ZN5clang7tooling20applyAllReplacementsEN4llvm9StringRefERKSt3setINS0_11ReplacementESt4lessIS4_ESaIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling20applyAllReplacementsEN4llvm9StringRefERKSt3setINS0_11ReplacementESt4lessIS4_ESaIS4_EE")
//</editor-fold>
public static Expected<std.string> applyAllReplacements(StringRef Code, 
                    final /*const*/ std.setType<Replacement> /*&*/ Replaces) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Calculates how a code \p Position is shifted when \p Replaces are
/// applied.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::shiftedCodePosition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 158,
 FQN="clang::tooling::shiftedCodePosition", NM="_ZN5clang7tooling19shiftedCodePositionERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling19shiftedCodePositionERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EEj")
//</editor-fold>
public static /*uint*/int shiftedCodePosition(final /*const*/ std.setType<Replacement> /*&*/ Replaces, /*uint*/int Position) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Calculates how a code \p Position is shifted when \p Replaces are
/// applied.
///
/// \pre Replaces[i].getOffset() <= Replaces[i+1].getOffset().

// FIXME: Remove this function when Replacements is implemented as std::vector
// instead of std::set.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::shiftedCodePosition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 164,
 FQN="clang::tooling::shiftedCodePosition", NM="_ZN5clang7tooling19shiftedCodePositionERKSt6vectorINS0_11ReplacementESaIS2_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling19shiftedCodePositionERKSt6vectorINS0_11ReplacementESaIS2_EEj")
//</editor-fold>
public static /*uint*/int shiftedCodePosition(final /*const*/std.vector<Replacement> /*&*/ Replaces, 
                   /*uint*/int Position) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 309,
 FQN="clang::tooling::calculateChangedRanges", NM="_ZN5clang7tooling22calculateChangedRangesERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling22calculateChangedRangesERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EE")
//</editor-fold>
public static std.vector<Range> calculateChangedRanges(final /*const*/ std.setType<Replacement> /*&*/ Replaces) {
  throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp", line = 439,
 FQN="clang::tooling::mergeReplacements", NM="_ZN5clang7tooling17mergeReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/Replacement.cpp -nm=_ZN5clang7tooling17mergeReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EES8_")
//</editor-fold>
public static std.setType<Replacement> mergeReplacements(final /*const*/ std.setType<Replacement> /*&*/ First, 
                 final /*const*/ std.setType<Replacement> /*&*/ Second) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ReplacementToolingGlobals
