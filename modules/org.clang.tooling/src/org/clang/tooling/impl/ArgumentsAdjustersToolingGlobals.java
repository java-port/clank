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
import org.clank.support.aliases.*;
import org.clang.tooling.*;
import static org.clang.tooling.java.ToolingFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type ArgumentsAdjustersToolingGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/ArgumentsAdjusters.cpp -nm=_ZN5clang7tooling16combineAdjustersESt8functionIFSt6vectorISsSaISsEERKS4_N4llvm9StringRefEEESA_;_ZN5clang7tooling25getInsertArgumentAdjusterEPKcNS0_22ArgumentInsertPositionE;_ZN5clang7tooling25getInsertArgumentAdjusterERKSt6vectorISsSaISsEENS0_22ArgumentInsertPositionE;_ZN5clang7tooling26getClangSyntaxOnlyAdjusterEv;_ZN5clang7tooling27getClangStripOutputAdjusterEv; -static-type=ArgumentsAdjustersToolingGlobals -package=org.clang.tooling.impl")
//</editor-fold>
public final class ArgumentsAdjustersToolingGlobals {


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

} // END OF class ArgumentsAdjustersToolingGlobals
