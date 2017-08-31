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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.*;


/// \brief A compilation database that returns a single compile command line.
///
/// Useful when we want a tool to behave more like a compiler invocation.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::FixedCompilationDatabase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 158,
 FQN="clang::tooling::FixedCompilationDatabase", NM="_ZN5clang7tooling24FixedCompilationDatabaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling24FixedCompilationDatabaseE")
//</editor-fold>
public class FixedCompilationDatabase extends /*public*/ CompilationDatabase implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Creates a FixedCompilationDatabase from the arguments after "--".
  ///
  /// Parses the given command line for "--". If "--" is found, the rest of
  /// the arguments will make up the command line in the returned
  /// FixedCompilationDatabase.
  /// The arguments after "--" must not include positional parameters or the
  /// argv[0] of the tool. Those will be added by the FixedCompilationDatabase
  /// when a CompileCommand is requested. The argv[0] of the returned command
  /// line will be "clang-tool".
  ///
  /// Returns NULL in case "--" is not found.
  ///
  /// The argument list is meant to be compatible with normal llvm command line
  /// parsing in main methods.
  /// int main(int argc, char **argv) {
  ///   std::unique_ptr<FixedCompilationDatabase> Compilations(
  ///     FixedCompilationDatabase::loadFromCommandLine(argc, argv));
  ///   cl::ParseCommandLineOptions(argc, argv);
  ///   ...
  /// }
  ///
  /// \param Argc The number of command line arguments - will be changed to
  /// the number of arguments before "--", if "--" was found in the argument
  /// list.
  /// \param Argv Points to the command line arguments.
  /// \param Directory The base directory used in the FixedCompilationDatabase.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FixedCompilationDatabase::loadFromCommandLine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 282,
   FQN="clang::tooling::FixedCompilationDatabase::loadFromCommandLine", NM="_ZN5clang7tooling24FixedCompilationDatabase19loadFromCommandLineERiPKPKcN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling24FixedCompilationDatabase19loadFromCommandLineERiPKPKcN4llvm5TwineE")
  //</editor-fold>
  public static FixedCompilationDatabase /*P*/ loadFromCommandLine(final int$ref/*int &*/ Argc, /*const*/type$ptr<char$ptr>/*char P const P*/ Argv) {
    return loadFromCommandLine(Argc, Argv, new Twine(/*KEEP_STR*/$DOT));
  }
  public static FixedCompilationDatabase /*P*/ loadFromCommandLine(final int$ref/*int &*/ Argc, /*const*/type$ptr<char$ptr>/*char P const P*/ Argv, Twine Directory/*= "."*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Constructs a compilation data base from a specified directory
  /// and command line.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FixedCompilationDatabase::FixedCompilationDatabase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 296,
   FQN="clang::tooling::FixedCompilationDatabase::FixedCompilationDatabase", NM="_ZN5clang7tooling24FixedCompilationDatabaseC1EN4llvm5TwineENS2_8ArrayRefISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling24FixedCompilationDatabaseC1EN4llvm5TwineENS2_8ArrayRefISsEE")
  //</editor-fold>
  public FixedCompilationDatabase(Twine Directory, ArrayRef<std.string> CommandLine) {
    // : CompilationDatabase(), CompileCommands() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the given compile command.
  ///
  /// Will always return a vector with one entry that contains the directory
  /// and command line specified at construction with "clang-tool" as argv[0]
  /// and 'FilePath' as positional argument.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FixedCompilationDatabase::getCompileCommands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 305,
   FQN="clang::tooling::FixedCompilationDatabase::getCompileCommands", NM="_ZNK5clang7tooling24FixedCompilationDatabase18getCompileCommandsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZNK5clang7tooling24FixedCompilationDatabase18getCompileCommandsEN4llvm9StringRefE")
  //</editor-fold>
  @Override public std.vector<CompileCommand> getCompileCommands(StringRef FilePath) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the list of all files available in the compilation database.
  ///
  /// Note: This is always an empty list for the fixed compilation database.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FixedCompilationDatabase::getAllFiles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 313,
   FQN="clang::tooling::FixedCompilationDatabase::getAllFiles", NM="_ZNK5clang7tooling24FixedCompilationDatabase11getAllFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZNK5clang7tooling24FixedCompilationDatabase11getAllFilesEv")
  //</editor-fold>
  @Override public std.vectorString getAllFiles() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns all compile commands for all the files in the compilation
  /// database.
  ///
  /// Note: This is always an empty list for the fixed compilation database.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FixedCompilationDatabase::getAllCompileCommands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 318,
   FQN="clang::tooling::FixedCompilationDatabase::getAllCompileCommands", NM="_ZNK5clang7tooling24FixedCompilationDatabase21getAllCompileCommandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZNK5clang7tooling24FixedCompilationDatabase21getAllCompileCommandsEv")
  //</editor-fold>
  @Override public std.vector<CompileCommand> getAllCompileCommands() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// This is built up to contain a single entry vector to be returned from
  /// getCompileCommands after adding the positional argument.
  private std.vector<CompileCommand> CompileCommands;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FixedCompilationDatabase::~FixedCompilationDatabase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CompilationDatabase.h", line = 158,
   FQN="clang::tooling::FixedCompilationDatabase::~FixedCompilationDatabase", NM="_ZN5clang7tooling24FixedCompilationDatabaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN5clang7tooling24FixedCompilationDatabaseD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "CompileCommands=" + CompileCommands // NOI18N
              + super.toString(); // NOI18N
  }
}
