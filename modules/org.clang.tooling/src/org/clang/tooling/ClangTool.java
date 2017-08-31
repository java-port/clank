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
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.clang.basic.vfs.*;
import org.clang.tooling.*;
import static org.clang.tooling.java.ToolingFunctionPointers.*;


/// \brief Utility to run a FrontendAction over a set of files.
///
/// This class is written to be usable for command line utilities.
/// By default the class uses ClangSyntaxOnlyAdjuster to modify
/// command line arguments before the arguments are used to run
/// a frontend action. One could install an additional command line
/// arguments adjuster by calling the appendArgumentsAdjuster() method.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 284,
 FQN="clang::tooling::ClangTool", NM="_ZN5clang7tooling9ClangToolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangToolE")
//</editor-fold>
public class ClangTool implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Constructs a clang tool to run over a list of files.
  ///
  /// \param Compilations The CompilationDatabase which contains the compile
  ///        command lines for the given source paths.
  /// \param SourcePaths The source files to run over. If a source files is
  ///        not found in Compilations, it is skipped.
  /// \param PCHContainerOps The PCHContainerOperations for loading and creating
  /// clang modules.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::ClangTool">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 316,
   FQN="clang::tooling::ClangTool::ClangTool", NM="_ZN5clang7tooling9ClangToolC1ERKNS0_19CompilationDatabaseEN4llvm8ArrayRefISsEESt10shared_ptrINS_22PCHContainerOperationsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangToolC1ERKNS0_19CompilationDatabaseEN4llvm8ArrayRefISsEESt10shared_ptrINS_22PCHContainerOperationsEE")
  //</editor-fold>
  public ClangTool(final /*const*/ CompilationDatabase /*&*/ Compilations, 
      ArrayRef<std.string> SourcePaths) {
    this(Compilations, 
      SourcePaths, 
      std.make_shared(new PCHContainerOperations()));
  }
  public ClangTool(final /*const*/ CompilationDatabase /*&*/ Compilations, 
      ArrayRef<std.string> SourcePaths, 
      std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
    // : Compilations(Compilations), SourcePaths(SourcePaths.operator vector()), PCHContainerOps(std::move(PCHContainerOps)), OverlayFileSystem(new OverlayFileSystem(vfs::getRealFileSystem())), InMemoryFileSystem(new InMemoryFileSystem), Files(new FileManager(FileSystemOptions(), OverlayFileSystem)), MappedFileContents(), SeenWorkingDirectories(), ArgsAdjuster(), DiagConsumer(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::~ClangTool">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 330,
   FQN="clang::tooling::ClangTool::~ClangTool", NM="_ZN5clang7tooling9ClangToolD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangToolD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Set a \c DiagnosticConsumer to use during parsing.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::setDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 302,
   FQN="clang::tooling::ClangTool::setDiagnosticConsumer", NM="_ZN5clang7tooling9ClangTool21setDiagnosticConsumerEPNS_18DiagnosticConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangTool21setDiagnosticConsumerEPNS_18DiagnosticConsumerE")
  //</editor-fold>
  public void setDiagnosticConsumer(DiagnosticConsumer /*P*/ DiagConsumer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Map a virtual file to be used while running the tool.
  ///
  /// \param FilePath The path at which the content will be mapped.
  /// \param Content A null terminated buffer of the file's content.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::mapVirtualFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 332,
   FQN="clang::tooling::ClangTool::mapVirtualFile", NM="_ZN5clang7tooling9ClangTool14mapVirtualFileEN4llvm9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangTool14mapVirtualFileEN4llvm9StringRefES3_")
  //</editor-fold>
  public void mapVirtualFile(StringRef FilePath, StringRef Content) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Append a command line arguments adjuster to the adjuster chain.
  ///
  /// \param Adjuster An argument adjuster, which will be run on the output of
  ///        previous argument adjusters.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::appendArgumentsAdjuster">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 336,
   FQN="clang::tooling::ClangTool::appendArgumentsAdjuster", NM="_ZN5clang7tooling9ClangTool23appendArgumentsAdjusterESt8functionIFSt6vectorISsSaISsEERKS5_N4llvm9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangTool23appendArgumentsAdjusterESt8functionIFSt6vectorISsSaISsEERKS5_N4llvm9StringRefEEE")
  //</editor-fold>
  public void appendArgumentsAdjuster(ArgumentsAdjuster Adjuster) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Clear the command line arguments adjuster chain.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::clearArgumentsAdjusters">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 344,
   FQN="clang::tooling::ClangTool::clearArgumentsAdjusters", NM="_ZN5clang7tooling9ClangTool23clearArgumentsAdjustersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangTool23clearArgumentsAdjustersEv")
  //</editor-fold>
  public void clearArgumentsAdjusters() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Runs an action over all files specified in the command line.
  ///
  /// \param Action Tool action.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 360,
   FQN="clang::tooling::ClangTool::run", NM="_ZN5clang7tooling9ClangTool3runEPNS0_10ToolActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangTool3runEPNS0_10ToolActionE")
  //</editor-fold>
  public int run(ToolAction /*P*/ Action) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Create an AST for each file specified in the command line and
  /// append them to ASTs.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::buildASTs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 487,
   FQN="clang::tooling::ClangTool::buildASTs", NM="_ZN5clang7tooling9ClangTool9buildASTsERSt6vectorISt10unique_ptrINS_7ASTUnitESt14default_deleteIS4_EESaIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangTool9buildASTsERSt6vectorISt10unique_ptrINS_7ASTUnitESt14default_deleteIS4_EESaIS7_EE")
  //</editor-fold>
  public int buildASTs(final std.vector<std.unique_ptr<ASTUnit>> /*&*/ ASTs) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the file manager used in the tool.
  ///
  /// The file manager is shared between all translation units.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ClangTool::getFiles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 333,
   FQN="clang::tooling::ClangTool::getFiles", NM="_ZN5clang7tooling9ClangTool8getFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling9ClangTool8getFilesEv")
  //</editor-fold>
  public FileManager /*&*/ getFiles() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private final /*const*/ CompilationDatabase /*&*/ Compilations;
  private std.vectorString SourcePaths;
  private std.shared_ptr<PCHContainerOperations> PCHContainerOps;
  
  private IntrusiveRefCntPtr<OverlayFileSystem> OverlayFileSystem;
  private IntrusiveRefCntPtr<InMemoryFileSystem> InMemoryFileSystem;
  private IntrusiveRefCntPtr<FileManager> Files;
  // Contains a list of pairs (<file name>, <file content>).
  private std.vector<std.pair<StringRef, StringRef>> MappedFileContents;
  private StringSet/*<MallocAllocator>*/ SeenWorkingDirectories;
  
  private ArgumentsAdjuster ArgsAdjuster;
  
  private DiagnosticConsumer /*P*/ DiagConsumer;
  
  @Override public String toString() {
    return "" + "Compilations=" + Compilations // NOI18N
              + ", SourcePaths=" + SourcePaths // NOI18N
              + ", PCHContainerOps=" + PCHContainerOps // NOI18N
              + ", OverlayFileSystem=" + OverlayFileSystem // NOI18N
              + ", InMemoryFileSystem=" + InMemoryFileSystem // NOI18N
              + ", Files=" + "[IntrusiveRefCntPtr$FileManager]" // NOI18N
              + ", MappedFileContents=" + MappedFileContents // NOI18N
              + ", SeenWorkingDirectories=" + SeenWorkingDirectories // NOI18N
              + ", ArgsAdjuster=" + ArgsAdjuster // NOI18N
              + ", DiagConsumer=" + "[DiagnosticConsumer]"; // NOI18N
  }
}
