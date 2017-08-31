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

package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;


/// \brief Dump information about the given module file, to be used for
/// basic debugging and discovery.
//<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 137,
 FQN="clang::DumpModuleInfoAction", NM="_ZN5clang20DumpModuleInfoActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang20DumpModuleInfoActionE")
//</editor-fold>
public class DumpModuleInfoAction extends /*public*/ ASTFrontendAction implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 421,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 416,
   FQN="clang::DumpModuleInfoAction::CreateASTConsumer", NM="_ZN5clang20DumpModuleInfoAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20DumpModuleInfoAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, 
                   StringRef InFile)/* override*/ {
    return llvm.make_unique(new ASTConsumer());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction::ExecuteAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 600,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 595,
   FQN="clang::DumpModuleInfoAction::ExecuteAction", NM="_ZN5clang20DumpModuleInfoAction13ExecuteActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang20DumpModuleInfoAction13ExecuteActionEv")
  //</editor-fold>
  @Override protected void ExecuteAction()/* override*/ {
    std.unique_ptr<raw_fd_ostream> OutFile = null;
    DumpModuleInfoListener Listener = null;
    try {
      // Set up the output file.
      OutFile/*J*/= new std.unique_ptr<raw_fd_ostream>();
      StringRef OutputFileName = new StringRef(getCompilerInstance().getFrontendOpts().OutputFile);
      if (!OutputFileName.empty() && $noteq_StringRef(/*NO_COPY*/OutputFileName, /*STRINGREF_STR*/"-")) {
        std.error_code EC/*J*/= new std.error_code();
        OutFile.reset(new raw_fd_ostream(new StringRef(OutputFileName.str()), EC, 
                fs.OpenFlags.F_Text));
      }
      raw_ostream /*&*/ Out = (OutFile.get() != null) ? /*Deref*/OutFile.get() : llvm.outs();
      
      Out.$out(/*KEEP_STR*/"Information for module file '").$out(getCurrentFile()).$out(/*KEEP_STR*/"':\n");
      Listener/*J*/= new DumpModuleInfoListener(Out);
      ASTReader.readASTFileControlBlock(getCurrentFile(), getCompilerInstance().getFileManager(), 
          getCompilerInstance().getPCHContainerReader(), 
          /*FindModuleFileExtensions=*/ true, Listener);
    } finally {
      if (Listener != null) { Listener.$destroy(); }
      if (OutFile != null) { OutFile.$destroy(); }
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction::hasPCHSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 144,
   FQN="clang::DumpModuleInfoAction::hasPCHSupport", NM="_ZNK5clang20DumpModuleInfoAction13hasPCHSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZNK5clang20DumpModuleInfoAction13hasPCHSupportEv")
  //</editor-fold>
  @Override public boolean hasPCHSupport() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction::hasASTFileSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 145,
   FQN="clang::DumpModuleInfoAction::hasASTFileSupport", NM="_ZNK5clang20DumpModuleInfoAction17hasASTFileSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZNK5clang20DumpModuleInfoAction17hasASTFileSupportEv")
  //</editor-fold>
  @Override public boolean hasASTFileSupport() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction::hasIRSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 146,
   FQN="clang::DumpModuleInfoAction::hasIRSupport", NM="_ZNK5clang20DumpModuleInfoAction12hasIRSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZNK5clang20DumpModuleInfoAction12hasIRSupportEv")
  //</editor-fold>
  @Override public boolean hasIRSupport() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction::hasCodeCompletionSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 147,
   FQN="clang::DumpModuleInfoAction::hasCodeCompletionSupport", NM="_ZNK5clang20DumpModuleInfoAction24hasCodeCompletionSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZNK5clang20DumpModuleInfoAction24hasCodeCompletionSupportEv")
  //</editor-fold>
  @Override public boolean hasCodeCompletionSupport() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction::~DumpModuleInfoAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 137,
   FQN="clang::DumpModuleInfoAction::~DumpModuleInfoAction", NM="_ZN5clang20DumpModuleInfoActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang20DumpModuleInfoActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DumpModuleInfoAction::DumpModuleInfoAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 137,
   FQN="clang::DumpModuleInfoAction::DumpModuleInfoAction", NM="_ZN5clang20DumpModuleInfoActionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang20DumpModuleInfoActionC1Ev")
  //</editor-fold>
  public /*inline*/ DumpModuleInfoAction() {
    // : ASTFrontendAction() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
