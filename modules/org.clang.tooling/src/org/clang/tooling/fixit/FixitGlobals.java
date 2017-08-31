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
package org.clang.tooling.fixit;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type FixitGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FixIt.cpp -nm=Tpl__ZN5clang7tooling5fixit13createRemovalERKT_;Tpl__ZN5clang7tooling5fixit17createReplacementERKT_RKT0_RKNS_10ASTContextE;Tpl__ZN5clang7tooling5fixit7getTextERKT_RKNS_10ASTContextE; -static-type=FixitGlobals -package=org.clang.tooling.fixit")
//</editor-fold>
public final class FixitGlobals {

// end namespace internal

// \brief Returns a textual representation of \p Node.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::fixit::getText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/FixIt.h", line = 50,
 FQN="clang::tooling::fixit::getText", NM="Tpl__ZN5clang7tooling5fixit7getTextERKT_RKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FixIt.cpp -nm=Tpl__ZN5clang7tooling5fixit7getTextERKT_RKNS_10ASTContextE")
//</editor-fold>
public static </*typename*/ T> StringRef getText(final /*const*/ T /*&*/ Node, final /*const*/ ASTContext /*&*/ Context) {
  throw new UnsupportedOperationException("EmptyBody");
}


// \brief Returns a FixItHint to remove \p Node.
// TODO: Add support for related syntactical elements (i.e. comments, ...).
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::fixit::createRemoval">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/FixIt.h", line = 56,
 FQN="clang::tooling::fixit::createRemoval", NM="Tpl__ZN5clang7tooling5fixit13createRemovalERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FixIt.cpp -nm=Tpl__ZN5clang7tooling5fixit13createRemovalERKT_")
//</editor-fold>
public static </*typename*/ T> FixItHint createRemoval(final /*const*/ T /*&*/ Node) {
  throw new UnsupportedOperationException("EmptyBody");
}


// \brief Returns a FixItHint to replace \p Destination by \p Source.
/*template <typename D, typename S> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::fixit::createReplacement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/FixIt.h", line = 62,
 FQN="clang::tooling::fixit::createReplacement", NM="Tpl__ZN5clang7tooling5fixit17createReplacementERKT_RKT0_RKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FixIt.cpp -nm=Tpl__ZN5clang7tooling5fixit17createReplacementERKT_RKT0_RKNS_10ASTContextE")
//</editor-fold>
public static </*typename*/ D, /*typename*/ S> FixItHint createReplacement(final /*const*/ D /*&*/ Destination, final /*const*/ S /*&*/ Source, 
                 final /*const*/ ASTContext /*&*/ Context) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class FixitGlobals
