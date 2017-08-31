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
import org.llvm.adt.*;
import org.clang.tooling.*;


/// \brief Interface for compilation databases.
///
/// A compilation database allows the user to retrieve all compile command lines
/// that a specified file is compiled with in a project.
/// The retrieved compile command lines can be used to run clang tools over
/// a subset of the files in a project.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 77,
 FQN="clang::tooling::CompilationDatabase", NM="_ZN5clang7tooling19CompilationDatabaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling19CompilationDatabaseE")
//</editor-fold>
public abstract class CompilationDatabase implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase::~CompilationDatabase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 35,
   FQN="clang::tooling::CompilationDatabase::~CompilationDatabase", NM="_ZN5clang7tooling19CompilationDatabaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling19CompilationDatabaseD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Loads a compilation database from a build directory.
  ///
  /// Looks at the specified 'BuildDirectory' and creates a compilation database
  /// that allows to query compile commands for source files in the
  /// corresponding source tree.
  ///
  /// Returns NULL and sets ErrorMessage if we were not able to build up a
  /// compilation database for the build directory.
  ///
  /// FIXME: Currently only supports JSON compilation databases, which
  /// are named 'compile_commands.json' in the given directory. Extend this
  /// for other build types (like ninja build files).
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase::loadFromDirectory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 37,
   FQN="clang::tooling::CompilationDatabase::loadFromDirectory", NM="_ZN5clang7tooling19CompilationDatabase17loadFromDirectoryEN4llvm9StringRefERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling19CompilationDatabase17loadFromDirectoryEN4llvm9StringRefERSs")
  //</editor-fold>
  public static std.unique_ptr<CompilationDatabase> loadFromDirectory(StringRef BuildDirectory, 
                   final std.string/*&*/ ErrorMessage) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Tries to detect a compilation database location and load it.
  ///
  /// Looks for a compilation database in all parent paths of file 'SourceFile'
  /// by calling loadFromDirectory.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase::autoDetectFromSource">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 80,
   FQN="clang::tooling::CompilationDatabase::autoDetectFromSource", NM="_ZN5clang7tooling19CompilationDatabase20autoDetectFromSourceEN4llvm9StringRefERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling19CompilationDatabase20autoDetectFromSourceEN4llvm9StringRefERSs")
  //</editor-fold>
  public static std.unique_ptr<CompilationDatabase> autoDetectFromSource(StringRef SourceFile, 
                      final std.string/*&*/ ErrorMessage) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Tries to detect a compilation database location and load it.
  ///
  /// Looks for a compilation database in directory 'SourceDir' and all
  /// its parent paths by calling loadFromDirectory.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase::autoDetectFromDirectory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 95,
   FQN="clang::tooling::CompilationDatabase::autoDetectFromDirectory", NM="_ZN5clang7tooling19CompilationDatabase23autoDetectFromDirectoryEN4llvm9StringRefERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling19CompilationDatabase23autoDetectFromDirectoryEN4llvm9StringRefERSs")
  //</editor-fold>
  public static std.unique_ptr<CompilationDatabase> autoDetectFromDirectory(StringRef SourceDir, 
                         final std.string/*&*/ ErrorMessage) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns all compile commands in which the specified file was
  /// compiled.
  ///
  /// This includes compile comamnds that span multiple source files.
  /// For example, consider a project with the following compilations:
  /// $ clang++ -o test a.cc b.cc t.cc
  /// $ clang++ -o production a.cc b.cc -DPRODUCTION
  /// A compilation database representing the project would return both command
  /// lines for a.cc and b.cc and only the first command line for t.cc.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase::getCompileCommands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 119,
   FQN="clang::tooling::CompilationDatabase::getCompileCommands", NM="_ZNK5clang7tooling19CompilationDatabase18getCompileCommandsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZNK5clang7tooling19CompilationDatabase18getCompileCommandsEN4llvm9StringRefE")
  //</editor-fold>
  public abstract /*virtual*/ std.vector<CompileCommand> getCompileCommands(StringRef FilePath) /*const*//* = 0*/;

  
  /// \brief Returns the list of all files available in the compilation database.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase::getAllFiles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 123,
   FQN="clang::tooling::CompilationDatabase::getAllFiles", NM="_ZNK5clang7tooling19CompilationDatabase11getAllFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZNK5clang7tooling19CompilationDatabase11getAllFilesEv")
  //</editor-fold>
  public abstract /*virtual*/ std.vectorString getAllFiles() /*const*//* = 0*/;

  
  /// \brief Returns all compile commands for all the files in the compilation
  /// database.
  ///
  /// FIXME: Add a layer in Tooling that provides an interface to run a tool
  /// over all files in a compilation database. Not all build systems have the
  /// ability to provide a feasible implementation for \c getAllCompileCommands.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase::getAllCompileCommands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 131,
   FQN="clang::tooling::CompilationDatabase::getAllCompileCommands", NM="_ZNK5clang7tooling19CompilationDatabase21getAllCompileCommandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZNK5clang7tooling19CompilationDatabase21getAllCompileCommandsEv")
  //</editor-fold>
  public abstract /*virtual*/ std.vector<CompileCommand> getAllCompileCommands() /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CompilationDatabase::CompilationDatabase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 77,
   FQN="clang::tooling::CompilationDatabase::CompilationDatabase", NM="_ZN5clang7tooling19CompilationDatabaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling19CompilationDatabaseC1Ev")
  //</editor-fold>
  public /*inline*/ CompilationDatabase() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
