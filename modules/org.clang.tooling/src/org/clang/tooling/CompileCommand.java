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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.tooling.*;


/// \brief Specifies the working directory and command of a compilation.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::CompileCommand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 43,
 FQN="clang::tooling::CompileCommand", NM="_ZN5clang7tooling14CompileCommandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling14CompileCommandE")
//</editor-fold>
public class/*struct*/ CompileCommand implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompileCommand::CompileCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 44,
   FQN="clang::tooling::CompileCommand::CompileCommand", NM="_ZN5clang7tooling14CompileCommandC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling14CompileCommandC1Ev")
  //</editor-fold>
  public CompileCommand() {
    // : Directory(), Filename(), CommandLine(), MappedSources() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompileCommand::CompileCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 45,
   FQN="clang::tooling::CompileCommand::CompileCommand", NM="_ZN5clang7tooling14CompileCommandC1EN4llvm5TwineES3_St6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling14CompileCommandC1EN4llvm5TwineES3_St6vectorISsSaISsEE")
  //</editor-fold>
  public CompileCommand(Twine Directory, Twine Filename, 
      std.vectorString CommandLine) {
    // : Directory(Directory.str()), Filename(Filename.str()), CommandLine(std::move(CommandLine)), MappedSources() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief The working directory the command was executed from.
  public std.string Directory;
  
  /// The source file associated with the command.
  public std.string Filename;
  
  /// \brief The command line that was executed.
  public std.vectorString CommandLine;
  
  /// \brief An optional mapping from each file's path to its content for all
  /// files needed for the compilation that are not available via the file
  /// system.
  ///
  /// Note that a tool implementation is required to fall back to the file
  /// system if a source file is not provided in the mapped sources, as
  /// compilation databases will usually not provide all files in mapped sources
  /// for performance reasons.
  public std.vector<std.pair<std.string, std.string>> MappedSources;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompileCommand::CompileCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 43,
   FQN="clang::tooling::CompileCommand::CompileCommand", NM="_ZN5clang7tooling14CompileCommandC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling14CompileCommandC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CompileCommand(final /*const*/ CompileCommand /*&*/ $Prm0) {
    // : Directory(.Directory), Filename(.Filename), CommandLine(.CommandLine), MappedSources(.MappedSources) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompileCommand::CompileCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 43,
   FQN="clang::tooling::CompileCommand::CompileCommand", NM="_ZN5clang7tooling14CompileCommandC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling14CompileCommandC1EOS1_")
  //</editor-fold>
  public /*inline*/ CompileCommand(JD$Move _dparam, final CompileCommand /*&&*/$Prm0) {
    // : Directory(static_cast<CompileCommand &&>().Directory), Filename(static_cast<CompileCommand &&>().Filename), CommandLine(static_cast<CompileCommand &&>().CommandLine), MappedSources(static_cast<CompileCommand &&>().MappedSources) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompileCommand::~CompileCommand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 43,
   FQN="clang::tooling::CompileCommand::~CompileCommand", NM="_ZN5clang7tooling14CompileCommandD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling14CompileCommandD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Directory=" + Directory // NOI18N
              + ", Filename=" + Filename // NOI18N
              + ", CommandLine=" + CommandLine // NOI18N
              + ", MappedSources=" + MappedSources; // NOI18N
  }
}
