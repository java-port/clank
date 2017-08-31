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
package org.clang.basic.impl;

import org.clank.support.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type LinkageClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang10minLinkageENS_7LinkageES0_;_ZN5clang16getFormalLinkageENS_7LinkageE;_ZN5clang19isExternallyVisibleENS_7LinkageE;_ZN5clang23isExternalFormalLinkageENS_7LinkageE; -static-type=LinkageClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class LinkageClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::isExternallyVisible">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 72,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", old_line = 68,
 FQN="clang::isExternallyVisible", NM="_ZN5clang19isExternallyVisibleENS_7LinkageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang19isExternallyVisibleENS_7LinkageE")
//</editor-fold>
public static /*inline*/ boolean isExternallyVisible(Linkage L) {
  return L == Linkage.ExternalLinkage || L == Linkage.VisibleNoLinkage;
}

//<editor-fold defaultstate="collapsed" desc="clang::getFormalLinkage">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 76,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", old_line = 72,
 FQN="clang::getFormalLinkage", NM="_ZN5clang16getFormalLinkageENS_7LinkageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang16getFormalLinkageENS_7LinkageE")
//</editor-fold>
public static /*inline*/ Linkage getFormalLinkage(Linkage L) {
  if (L == Linkage.UniqueExternalLinkage) {
    return Linkage.ExternalLinkage;
  }
  if (L == Linkage.VisibleNoLinkage) {
    return Linkage.NoLinkage;
  }
  return L;
}

//<editor-fold defaultstate="collapsed" desc="clang::isExternalFormalLinkage">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 84,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", old_line = 80,
 FQN="clang::isExternalFormalLinkage", NM="_ZN5clang23isExternalFormalLinkageENS_7LinkageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang23isExternalFormalLinkageENS_7LinkageE")
//</editor-fold>
public static /*inline*/ boolean isExternalFormalLinkage(Linkage L) {
  return getFormalLinkage(L) == Linkage.ExternalLinkage;
}


/// \brief Compute the minimum linkage given two linkages.
///
/// The linkage can be interpreted as a pair formed by the formal linkage and
/// a boolean for external visibility. This is just what getFormalLinkage and
/// isExternallyVisible return. We want the minimum of both components. The
/// Linkage enum is defined in an order that makes this simple, we just need
/// special cases for when VisibleNoLinkage would lose the visible bit and
/// become NoLinkage.
//<editor-fold defaultstate="collapsed" desc="clang::minLinkage">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 96,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", old_line = 92,
 FQN="clang::minLinkage", NM="_ZN5clang10minLinkageENS_7LinkageES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN5clang10minLinkageENS_7LinkageES0_")
//</editor-fold>
public static /*inline*/ Linkage minLinkage(Linkage L1, Linkage L2) {
  if (L2 == Linkage.VisibleNoLinkage) {
    // JAVA: swap(L1, L2);
    Linkage tmp = L1;
    L1 = L2;
    L2 = tmp;
  }
  if (L1 == Linkage.VisibleNoLinkage) {
    if (L2 == Linkage.InternalLinkage) {
      return Linkage.NoLinkage;
    }
    if (L2 == Linkage.UniqueExternalLinkage) {
      return Linkage.NoLinkage;
    }
  }
  return L1.getValue() < L2.getValue() ? L1 : L2;
}

} // END OF class LinkageClangGlobals
