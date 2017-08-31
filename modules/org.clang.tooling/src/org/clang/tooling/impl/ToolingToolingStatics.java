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
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.clang.driver.*;
import org.llvm.option.*;


//<editor-fold defaultstate="collapsed" desc="static type ToolingToolingStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL15getCC1ArgumentsEPNS_17DiagnosticsEngineEPNS_6driver11CompilationE;_ZN5clang7toolingL17injectResourceDirERSt6vectorISsSaISsEEPKcPv;_ZN5clang7toolingL21getSyntaxOnlyToolArgsERKN4llvm5TwineERKSt6vectorISsSaISsEENS1_9StringRefE;_ZN5clang7toolingL9newDriverEPNS_17DiagnosticsEngineEPKcN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE; -static-type=ToolingToolingStatics -package=org.clang.tooling.impl")
//</editor-fold>
public final class ToolingToolingStatics {


// FIXME: This file contains structural duplication with other parts of the
// code that sets up a compiler to run tools on it, and we should refactor
// it to be based on the same framework.

/// \brief Builds a clang driver initialized for running clang tools.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::newDriver">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 50,
 FQN="clang::tooling::newDriver", NM="_ZN5clang7toolingL9newDriverEPNS_17DiagnosticsEngineEPKcN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL9newDriverEPNS_17DiagnosticsEngineEPKcN4llvm18IntrusiveRefCntPtrINS_3vfs10FileSystemEEE")
//</editor-fold>
public static Driver /*P*/ newDriver(DiagnosticsEngine /*P*/ Diagnostics, /*const*/char$ptr/*char P*/ BinaryName, 
         IntrusiveRefCntPtr<FileSystem> VFS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Retrieves the clang CC1 specific flags out of the compilation's jobs.
///
/// Returns NULL on error.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getCC1Arguments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 63,
 FQN="clang::tooling::getCC1Arguments", NM="_ZN5clang7toolingL15getCC1ArgumentsEPNS_17DiagnosticsEngineEPNS_6driver11CompilationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL15getCC1ArgumentsEPNS_17DiagnosticsEngineEPNS_6driver11CompilationE")
//</editor-fold>
public static /*const*/ArgStringList/*P*/ getCC1Arguments(DiagnosticsEngine /*P*/ Diagnostics, 
               Compilation /*P*/ Compilation) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::tooling::getSyntaxOnlyToolArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 112,
 FQN="clang::tooling::getSyntaxOnlyToolArgs", NM="_ZN5clang7toolingL21getSyntaxOnlyToolArgsERKN4llvm5TwineERKSt6vectorISsSaISsEENS1_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL21getSyntaxOnlyToolArgsERKN4llvm5TwineERKSt6vectorISsSaISsEENS1_9StringRefE")
//</editor-fold>
public static std.vectorString getSyntaxOnlyToolArgs(final /*const*/ Twine /*&*/ ToolName, 
                     final /*const*/std.vectorString/*&*/ ExtraArgs, 
                     StringRef FileName) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::tooling::injectResourceDir">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 348,
 FQN="clang::tooling::injectResourceDir", NM="_ZN5clang7toolingL17injectResourceDirERSt6vectorISsSaISsEEPKcPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7toolingL17injectResourceDirERSt6vectorISsSaISsEEPKcPv")
//</editor-fold>
public static void injectResourceDir(final std.vectorString/*&*/ Args, /*const*/char$ptr/*char P*/ Argv0, 
                 Object/*void P*/ MainAddr) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ToolingToolingStatics
