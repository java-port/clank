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
import org.llvm.cl.*;
import org.clang.tooling.*;

/// \brief A parser for options common to all command-line Clang tools.
///
/// Parses a common subset of command-line arguments, locates and loads a
/// compilation commands database and runs a tool with user-specified action. It
/// also contains a help message for the common command-line options.
///
/// An example of usage:
/// \code
/// #include "clang/Frontend/FrontendActions.h"
/// #include "clang/Tooling/CommonOptionsParser.h"
/// #include "clang/Tooling/Tooling.h"
/// #include "llvm/Support/CommandLine.h"
///
/// using namespace clang::tooling;
/// using namespace llvm;
///
/// static cl::OptionCategory MyToolCategory("My tool options");
/// static cl::extrahelp CommonHelp(CommonOptionsParser::HelpMessage);
/// static cl::extrahelp MoreHelp("\nMore help text...");
/// static cl::opt<bool> YourOwnOption(...);
/// ...
///
/// int main(int argc, const char **argv) {
///   CommonOptionsParser OptionsParser(argc, argv, MyToolCategory);
///   ClangTool Tool(OptionsParser.getCompilations(),
///                  OptionsParser.getSourcePathList());
///   return Tool.run(newFrontendActionFactory<SyntaxOnlyAction>().get());
/// }
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::tooling::CommonOptionsParser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CommonOptionsParser.h", line = 64,
 FQN="clang::tooling::CommonOptionsParser", NM="_ZN5clang7tooling19CommonOptionsParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CommonOptionsParser.cpp -nm=_ZN5clang7tooling19CommonOptionsParserE")
//</editor-fold>
public class CommonOptionsParser implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Parses command-line, initializes a compilation database.
  ///
  /// This constructor can change argc and argv contents, e.g. consume
  /// command-line options used for creating FixedCompilationDatabase.
  ///
  /// All options not belonging to \p Category become hidden.
  ///
  /// This constructor exits program in case of error.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CommonOptionsParser::CommonOptionsParser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CommonOptionsParser.h", line = 74,
   FQN="clang::tooling::CommonOptionsParser::CommonOptionsParser", NM="_ZN5clang7tooling19CommonOptionsParserC1ERiPPKcRN4llvm2cl14OptionCategoryES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CommonOptionsParser.cpp -nm=_ZN5clang7tooling19CommonOptionsParserC1ERiPPKcRN4llvm2cl14OptionCategoryES4_")
  //</editor-fold>
  public CommonOptionsParser(final int$ref/*int &*/ argc, /*const*/type$ptr<char$ptr>/*char PP*/ argv, 
      final OptionCategory /*&*/ Category) {
    this(argc, argv, 
      Category, 
      (/*const*/char$ptr/*char P*/ )null);
  }
  public CommonOptionsParser(final int$ref/*int &*/ argc, /*const*/type$ptr<char$ptr>/*char PP*/ argv, 
      final OptionCategory /*&*/ Category, 
      /*const*/char$ptr/*char P*/ Overview/*= null*/) {
    // : CommonOptionsParser(argc, argv, Category, cl::OneOrMore, Overview) 
    this(argc, argv, Category, NumOccurrencesFlag.OneOrMore.getValue(), 
        Overview);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Parses command-line, initializes a compilation database.
  ///
  /// This constructor can change argc and argv contents, e.g. consume
  /// command-line options used for creating FixedCompilationDatabase.
  ///
  /// All options not belonging to \p Category become hidden.
  ///
  /// I also allows calls to set the required number of positional parameters.
  ///
  /// This constructor exits program in case of error.
  // namespace
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CommonOptionsParser::CommonOptionsParser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CommonOptionsParser.cpp", line = 95,
   FQN="clang::tooling::CommonOptionsParser::CommonOptionsParser", NM="_ZN5clang7tooling19CommonOptionsParserC1ERiPPKcRN4llvm2cl14OptionCategoryENS7_18NumOccurrencesFlagES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CommonOptionsParser.cpp -nm=_ZN5clang7tooling19CommonOptionsParserC1ERiPPKcRN4llvm2cl14OptionCategoryENS7_18NumOccurrencesFlagES4_")
  //</editor-fold>
  public CommonOptionsParser(final int$ref/*int &*/ argc, /*const*/type$ptr<char$ptr>/*char PP*/ argv, final OptionCategory /*&*/ Category, 
      /*NumOccurrencesFlag*//*uint*/int OccurrencesFlag) {
    this(argc, argv, Category, 
      OccurrencesFlag, (/*const*/char$ptr/*char P*/ )null);
  }
  public CommonOptionsParser(final int$ref/*int &*/ argc, /*const*/type$ptr<char$ptr>/*char PP*/ argv, final OptionCategory /*&*/ Category, 
      /*NumOccurrencesFlag*//*uint*/int OccurrencesFlag, /*const*/char$ptr/*char P*/ Overview/*= null*/) {
    // : Compilations(), SourcePathList(), ExtraArgsBefore(), ExtraArgsAfter() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns a reference to the loaded compilations database.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CommonOptionsParser::getCompilations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CommonOptionsParser.h", line = 96,
   FQN="clang::tooling::CommonOptionsParser::getCompilations", NM="_ZN5clang7tooling19CommonOptionsParser15getCompilationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CommonOptionsParser.cpp -nm=_ZN5clang7tooling19CommonOptionsParser15getCompilationsEv")
  //</editor-fold>
  public CompilationDatabase /*&*/ getCompilations() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns a list of source file paths to process.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CommonOptionsParser::getSourcePathList">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CommonOptionsParser.h", line = 101,
   FQN="clang::tooling::CommonOptionsParser::getSourcePathList", NM="_ZNK5clang7tooling19CommonOptionsParser17getSourcePathListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CommonOptionsParser.cpp -nm=_ZNK5clang7tooling19CommonOptionsParser17getSourcePathListEv")
  //</editor-fold>
  public /*const*/std.vectorString/*&*/ getSourcePathList() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  public static /*const*/char$ptr/*char P*//*const*/ HelpMessage = $("\n-p <build-path> is used to read a compile command database.\n\n\tFor example, it can be a CMake build directory in which a file named\n\tcompile_commands.json exists (use -DCMAKE_EXPORT_COMPILE_COMMANDS=ON\n\tCMake option to get this output). When no build path is specified,\n\ta search for compile_commands.json will be attempted through all\n\tparent paths of the first input file . See:\n\thttp://clang.llvm.org/docs/HowToSetupToolingForLLVM.html for an\n\texample of setting up Clang Tooling on a source tree.\n\n<source0> ... specify the paths of source files. These paths are\n\tlooked up in the compile command database. If the path of a file is\n\tabsolute, it needs to point into CMake's source tree. If the path is\n\trelative, the current working directory needs to be in the CMake\n\tsource tree and the file must be in a subdirectory of the current\n\tworking directory. \"./\" prefixes in the relative files will be\n\tautomatically removed, but the rest of a relative path must be a\n\tsuffix of a path in the compile command database.\n\n");
/*private:*/
  private std.unique_ptr<CompilationDatabase> Compilations;
  private std.vectorString SourcePathList;
  private std.vectorString ExtraArgsBefore;
  private std.vectorString ExtraArgsAfter;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::CommonOptionsParser::~CommonOptionsParser">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/CommonOptionsParser.h", line = 64,
   FQN="clang::tooling::CommonOptionsParser::~CommonOptionsParser", NM="_ZN5clang7tooling19CommonOptionsParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CommonOptionsParser.cpp -nm=_ZN5clang7tooling19CommonOptionsParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Compilations=" + Compilations // NOI18N
              + ", SourcePathList=" + SourcePathList // NOI18N
              + ", ExtraArgsBefore=" + ExtraArgsBefore // NOI18N
              + ", ExtraArgsAfter=" + ExtraArgsAfter; // NOI18N
  }
}
