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
import static org.clank.java.std.*;
import org.llvm.adt.*;
import org.clang.tooling.*;


//<editor-fold defaultstate="collapsed" desc="static type CompilationDatabaseStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZL19stripPositionalArgsSt6vectorIPKcSaIS1_EERS_ISsSaISsEE;_ZL36findCompilationDatabaseFromDirectoryN4llvm9StringRefERSs; -static-type=CompilationDatabaseStatics -package=org.clang.tooling.impl")
//</editor-fold>
public final class CompilationDatabaseStatics {

//<editor-fold defaultstate="collapsed" desc="findCompilationDatabaseFromDirectory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 56,
 FQN="findCompilationDatabaseFromDirectory", NM="_ZL36findCompilationDatabaseFromDirectoryN4llvm9StringRefERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZL36findCompilationDatabaseFromDirectoryN4llvm9StringRefERSs")
//</editor-fold>
public static std.unique_ptr<CompilationDatabase> findCompilationDatabaseFromDirectory(StringRef Directory, 
                                    final std.string/*&*/ ErrorMessage) {
  throw new UnsupportedOperationException("EmptyBody");
}

// namespace

/// \brief Strips any positional args and possible argv[0] from a command-line
/// provided by the user to construct a FixedCompilationDatabase.
///
/// FixedCompilationDatabase requires a command line to be in this format as it
/// constructs the command line for each file by appending the name of the file
/// to be compiled. FixedCompilationDatabase also adds its own argv[0] to the
/// start of the command line although its value is not important as it's just
/// ignored by the Driver invoked by the ClangTool using the
/// FixedCompilationDatabase.
///
/// FIXME: This functionality should probably be made available by
/// clang::driver::Driver although what the interface should look like is not
/// clear.
///
/// \param[in] Args Args as provided by the user.
/// \return Resulting stripped command line.
///          \li true if successful.
///          \li false if \c Args cannot be used for compilation jobs (e.g.
///          contains an option like -E or -version).
//<editor-fold defaultstate="collapsed" desc="stripPositionalArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 206,
 FQN="stripPositionalArgs", NM="_ZL19stripPositionalArgsSt6vectorIPKcSaIS1_EERS_ISsSaISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZL19stripPositionalArgsSt6vectorIPKcSaIS1_EERS_ISsSaISsEE")
//</editor-fold>
public static boolean stripPositionalArgs(vectorCharPtr Args, 
                   final std.vectorString/*&*/ Result) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class CompilationDatabaseStatics
