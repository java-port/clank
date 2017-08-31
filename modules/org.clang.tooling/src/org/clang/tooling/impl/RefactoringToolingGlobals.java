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
package org.clang.tooling.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.rewrite.core.*;
import org.clang.tooling.core.*;


//<editor-fold defaultstate="collapsed" desc="static type RefactoringToolingGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling29formatAndApplyAllReplacementsERKSt3setINS0_11ReplacementESt4lessIS2_ESaIS2_EERNS_8RewriterEN4llvm9StringRefE; -static-type=RefactoringToolingGlobals -package=org.clang.tooling.impl")
//</editor-fold>
public final class RefactoringToolingGlobals {


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

} // END OF class RefactoringToolingGlobals
