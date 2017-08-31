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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.yaml.*;
import org.clang.tooling.*;


/// \brief A JSON based compilation database.
///
/// JSON compilation database files must contain a list of JSON objects which
/// provide the command lines in the attributes 'directory', 'command',
/// 'arguments' and 'file':
/// [
///   { "directory": "<working directory of the compile>",
///     "command": "<compile command line>",
///     "file": "<path to source file>"
///   },
///   { "directory": "<working directory of the compile>",
///     "arguments": ["<raw>", "<command>" "<line>" "<parameters>"],
///     "file": "<path to source file>"
///   },
///   ...
/// ]
/// Each object entry defines one compile action. The specified file is
/// considered to be the main source file for the translation unit.
///
/// 'command' is a full command line that will be unescaped.
///
/// 'arguments' is a list of command line arguments that will not be unescaped.
///
/// JSON compilation databases can for example be generated in CMake projects
/// by setting the flag -DCMAKE_EXPORT_COMPILE_COMMANDS.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/JSONCompilationDatabase.h", line = 58,
 FQN="clang::tooling::JSONCompilationDatabase", NM="_ZN5clang7tooling23JSONCompilationDatabaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling23JSONCompilationDatabaseE")
//</editor-fold>
public class JSONCompilationDatabase extends /*public*/ CompilationDatabase implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Loads a JSON compilation database from the specified file.
  ///
  /// Returns NULL and sets ErrorMessage if the database could not be
  /// loaded from the given file.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::loadFromFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 144,
   FQN="clang::tooling::JSONCompilationDatabase::loadFromFile", NM="_ZN5clang7tooling23JSONCompilationDatabase12loadFromFileEN4llvm9StringRefERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling23JSONCompilationDatabase12loadFromFileEN4llvm9StringRefERSs")
  //</editor-fold>
  public static std.unique_ptr<JSONCompilationDatabase> loadFromFile(StringRef FilePath, 
              final std.string/*&*/ ErrorMessage) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Loads a JSON compilation database from a data buffer.
  ///
  /// Returns NULL and sets ErrorMessage if the database could not be loaded.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::loadFromBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 160,
   FQN="clang::tooling::JSONCompilationDatabase::loadFromBuffer", NM="_ZN5clang7tooling23JSONCompilationDatabase14loadFromBufferEN4llvm9StringRefERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling23JSONCompilationDatabase14loadFromBufferEN4llvm9StringRefERSs")
  //</editor-fold>
  public static std.unique_ptr<JSONCompilationDatabase> loadFromBuffer(StringRef DatabaseString, 
                final std.string/*&*/ ErrorMessage) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns all compile comamnds in which the specified file was
  /// compiled.
  ///
  /// FIXME: Currently FilePath must be an absolute path inside the
  /// source directory which does not have symlinks resolved.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::getCompileCommands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 172,
   FQN="clang::tooling::JSONCompilationDatabase::getCompileCommands", NM="_ZNK5clang7tooling23JSONCompilationDatabase18getCompileCommandsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZNK5clang7tooling23JSONCompilationDatabase18getCompileCommandsEN4llvm9StringRefE")
  //</editor-fold>
  @Override public std.vector<CompileCommand> getCompileCommands(StringRef FilePath) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the list of all files available in the compilation database.
  ///
  /// These are the 'file' entries of the JSON objects.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::getAllFiles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 191,
   FQN="clang::tooling::JSONCompilationDatabase::getAllFiles", NM="_ZNK5clang7tooling23JSONCompilationDatabase11getAllFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZNK5clang7tooling23JSONCompilationDatabase11getAllFilesEv")
  //</editor-fold>
  @Override public std.vectorString getAllFiles() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns all compile commands for all the files in the compilation
  /// database.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::getAllCompileCommands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 206,
   FQN="clang::tooling::JSONCompilationDatabase::getAllCompileCommands", NM="_ZNK5clang7tooling23JSONCompilationDatabase21getAllCompileCommandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZNK5clang7tooling23JSONCompilationDatabase21getAllCompileCommandsEv")
  //</editor-fold>
  @Override public std.vector<CompileCommand> getAllCompileCommands() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// \brief Constructs a JSON compilation database on a memory buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::JSONCompilationDatabase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/JSONCompilationDatabase.h", line = 92,
   FQN="clang::tooling::JSONCompilationDatabase::JSONCompilationDatabase", NM="_ZN5clang7tooling23JSONCompilationDatabaseC1ESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS4_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling23JSONCompilationDatabaseC1ESt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS4_EE")
  //</editor-fold>
  private JSONCompilationDatabase(std.unique_ptr<MemoryBuffer> Database) {
    // : CompilationDatabase(), IndexByFile(), AllCommands(), MatchTrie(), Database(std::move(Database)), SM(), YAMLStream(this->Database->getBuffer(), SM) 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Parses the database file and creates the index.
  ///
  /// Returns whether parsing succeeded. Sets ErrorMessage if parsing
  /// failed.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::parse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 239,
   FQN="clang::tooling::JSONCompilationDatabase::parse", NM="_ZN5clang7tooling23JSONCompilationDatabase5parseERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling23JSONCompilationDatabase5parseERSs")
  //</editor-fold>
  private boolean parse(final std.string/*&*/ ErrorMessage) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Tuple (directory, filename, commandline) where 'commandline' points to the
  // corresponding scalar nodes in the YAML stream.
  // If the command line contains a single argument, it is a shell-escaped
  // command line.
  // Otherwise, each entry in the command line vector is a literal
  // argument to the compiler.
  /*typedef std::tuple<llvm::yaml::ScalarNode *, llvm::yaml::ScalarNode *, std::vector<llvm::yaml::ScalarNode *> > CompileCommandRef*/
//  public final class CompileCommandRef extends std.tuple<ScalarNode /*P*/ , ScalarNode /*P*/ , std.vector<ScalarNode /*P*/ > >{ };
  
  /// \brief Converts the given array of CompileCommandRefs to CompileCommands.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::getCommands">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp", line = 226,
   FQN="clang::tooling::JSONCompilationDatabase::getCommands", NM="_ZNK5clang7tooling23JSONCompilationDatabase11getCommandsEN4llvm8ArrayRefISt5tupleIJPNS2_4yaml10ScalarNodeES7_St6vectorIS7_SaIS7_EEEEEERS8_INS0_14CompileCommandESaISD_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZNK5clang7tooling23JSONCompilationDatabase11getCommandsEN4llvm8ArrayRefISt5tupleIJPNS2_4yaml10ScalarNodeES7_St6vectorIS7_SaIS7_EEEEEERS8_INS0_14CompileCommandESaISD_EE")
  //</editor-fold>
  private void getCommands(ArrayRef<std.tuple/*<ScalarNode*, ScalarNode*, std.vector<ScalarNode*>>*/> CommandsRef, 
             final std.vector<CompileCommand> /*&*/ Commands) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Maps file paths to the compile command lines for that file.
  private StringMap<std.vector<std.tuple/*<ScalarNode*, ScalarNode*, std.vector<ScalarNode*>>*/>> IndexByFile;
  
  /// All the compile commands in the order that they were provided in the
  /// JSON stream.
  private std.vector<std.tuple/*<ScalarNode*, ScalarNode*, std.vector<ScalarNode*>>*/> AllCommands;
  
  private FileMatchTrie MatchTrie;
  
  private std.unique_ptr<MemoryBuffer> Database;
  private SourceMgr SM;
  private Stream YAMLStream;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::JSONCompilationDatabase::~JSONCompilationDatabase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/JSONCompilationDatabase.h", line = 58,
   FQN="clang::tooling::JSONCompilationDatabase::~JSONCompilationDatabase", NM="_ZN5clang7tooling23JSONCompilationDatabaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/JSONCompilationDatabase.cpp -nm=_ZN5clang7tooling23JSONCompilationDatabaseD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "IndexByFile=" + IndexByFile // NOI18N
              + ", AllCommands=" + AllCommands // NOI18N
              + ", MatchTrie=" + MatchTrie // NOI18N
              + ", Database=" + Database // NOI18N
              + ", SM=" + SM // NOI18N
              + ", YAMLStream=" + YAMLStream // NOI18N
              + super.toString(); // NOI18N
  }
}
