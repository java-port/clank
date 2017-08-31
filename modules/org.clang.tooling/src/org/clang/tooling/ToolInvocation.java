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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.clang.driver.*;
import org.clang.tooling.*;


/// \brief Utility to run a FrontendAction in a single clang invocation.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 211,
 FQN="clang::tooling::ToolInvocation", NM="_ZN5clang7tooling14ToolInvocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocationE")
//</editor-fold>
public class ToolInvocation implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Create a tool invocation.
  ///
  /// \param CommandLine The command line arguments to clang. Note that clang
  /// uses its binary name (CommandLine[0]) to locate its builtin headers.
  /// Callers have to ensure that they are installed in a compatible location
  /// (see clang driver implementation) or mapped in via mapVirtualFile.
  /// \param FAction The action to be executed. Class takes ownership.
  /// \param Files The FileManager used for the execution. Class does not take
  /// ownership.
  /// \param PCHContainerOps The PCHContainerOperations for loading and creating
  /// clang modules.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation::ToolInvocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 218,
   FQN="clang::tooling::ToolInvocation::ToolInvocation", NM="_ZN5clang7tooling14ToolInvocationC1ESt6vectorISsSaISsEEPNS_14FrontendActionEPNS_11FileManagerESt10shared_ptrINS_22PCHContainerOperationsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocationC1ESt6vectorISsSaISsEEPNS_14FrontendActionEPNS_11FileManagerESt10shared_ptrINS_22PCHContainerOperationsEE")
  //</editor-fold>
  public ToolInvocation(std.vectorString CommandLine, FrontendAction /*P*/ FAction, 
      FileManager /*P*/ Files) {
    this(CommandLine, FAction, 
      Files, std.make_shared(new PCHContainerOperations()));
  }
  public ToolInvocation(std.vectorString CommandLine, FrontendAction /*P*/ FAction, 
      FileManager /*P*/ Files, std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
    // : CommandLine(std::move(CommandLine)), Action(new SingleFrontendActionFactory(FAction)), OwnsAction(true), Files(Files), PCHContainerOps(std::move(PCHContainerOps)), MappedFileContents(), DiagConsumer(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Create a tool invocation.
  ///
  /// \param CommandLine The command line arguments to clang.
  /// \param Action The action to be executed.
  /// \param Files The FileManager used for the execution.
  /// \param PCHContainerOps The PCHContainerOperations for loading and creating
  /// clang modules.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation::ToolInvocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 211,
   FQN="clang::tooling::ToolInvocation::ToolInvocation", NM="_ZN5clang7tooling14ToolInvocationC1ESt6vectorISsSaISsEEPNS0_10ToolActionEPNS_11FileManagerESt10shared_ptrINS_22PCHContainerOperationsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocationC1ESt6vectorISsSaISsEEPNS0_10ToolActionEPNS_11FileManagerESt10shared_ptrINS_22PCHContainerOperationsEE")
  //</editor-fold>
  public ToolInvocation(std.vectorString CommandLine, ToolAction /*P*/ Action, 
      FileManager /*P*/ Files, std.shared_ptr<PCHContainerOperations> PCHContainerOps) {
    // : CommandLine(std::move(CommandLine)), Action(Action), OwnsAction(false), Files(Files), PCHContainerOps(std::move(PCHContainerOps)), MappedFileContents(), DiagConsumer(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation::~ToolInvocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 226,
   FQN="clang::tooling::ToolInvocation::~ToolInvocation", NM="_ZN5clang7tooling14ToolInvocationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocationD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Set a \c DiagnosticConsumer to use during parsing.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation::setDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 243,
   FQN="clang::tooling::ToolInvocation::setDiagnosticConsumer", NM="_ZN5clang7tooling14ToolInvocation21setDiagnosticConsumerEPNS_18DiagnosticConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocation21setDiagnosticConsumerEPNS_18DiagnosticConsumerE")
  //</editor-fold>
  public void setDiagnosticConsumer(DiagnosticConsumer /*P*/ DiagConsumer) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Map a virtual file to be used while running the tool.
  ///
  /// \param FilePath The path at which the content will be mapped.
  /// \param Content A null terminated buffer of the file's content.
  // FIXME: remove this when all users have migrated!
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation::mapVirtualFile">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 231,
   FQN="clang::tooling::ToolInvocation::mapVirtualFile", NM="_ZN5clang7tooling14ToolInvocation14mapVirtualFileEN4llvm9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocation14mapVirtualFileEN4llvm9StringRefES3_")
  //</editor-fold>
  public void mapVirtualFile(StringRef FilePath, StringRef Content) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Run the clang invocation.
  ///
  /// \returns True if there were no errors during execution.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation::run">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 237,
   FQN="clang::tooling::ToolInvocation::run", NM="_ZN5clang7tooling14ToolInvocation3runEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocation3runEv")
  //</editor-fold>
  public boolean run() {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation::addFileMappingsTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 260,
   FQN="clang::tooling::ToolInvocation::addFileMappingsTo", NM="_ZN5clang7tooling14ToolInvocation17addFileMappingsToERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocation17addFileMappingsToERNS_13SourceManagerE")
  //</editor-fold>
  private void addFileMappingsTo(final SourceManager /*&*/ SourceManager) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::ToolInvocation::runInvocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 274,
   FQN="clang::tooling::ToolInvocation::runInvocation", NM="_ZN5clang7tooling14ToolInvocation13runInvocationEPKcPNS_6driver11CompilationEPNS_18CompilerInvocationESt10shared_ptrINS_22PCHContainerOperationsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling14ToolInvocation13runInvocationEPKcPNS_6driver11CompilationEPNS_18CompilerInvocationESt10shared_ptrINS_22PCHContainerOperationsEE")
  //</editor-fold>
  private boolean runInvocation(/*const*/char$ptr/*char P*/ BinaryName, Compilation /*P*/ Compilation, 
               CompilerInvocation /*P*/ Invocation, 
               std.shared_ptr<PCHContainerOperations> PCHContainerOps) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private std.vectorString CommandLine;
  private ToolAction /*P*/ Action;
  private boolean OwnsAction;
  private FileManager /*P*/ Files;
  private std.shared_ptr<PCHContainerOperations> PCHContainerOps;
  // Maps <file name> -> <file content>.
  private StringMap<ToolChain/*, MallocAllocator*/> MappedFileContents;
  private DiagnosticConsumer /*P*/ DiagConsumer;
  
  @Override public String toString() {
    return "" + "CommandLine=" + CommandLine // NOI18N
              + ", Action=" + Action // NOI18N
              + ", OwnsAction=" + OwnsAction // NOI18N
              + ", Files=" + "[FileManager]" // NOI18N
              + ", PCHContainerOps=" + PCHContainerOps // NOI18N
              + ", MappedFileContents=" + MappedFileContents // NOI18N
              + ", DiagConsumer=" + "[DiagnosticConsumer]"; // NOI18N
  }
}
