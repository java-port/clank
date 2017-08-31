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
import static org.clank.java.std.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.lex.*;
import org.clang.frontend.*;

//<editor-fold defaultstate="collapsed" desc="clang::PrintPreambleAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 198,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 197,
 FQN="clang::PrintPreambleAction", NM="_ZN5clang19PrintPreambleActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang19PrintPreambleActionE")
//</editor-fold>
public class PrintPreambleAction extends /*public*/ FrontendAction implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreambleAction::ExecuteAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 729,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 721,
   FQN="clang::PrintPreambleAction::ExecuteAction", NM="_ZN5clang19PrintPreambleAction13ExecuteActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang19PrintPreambleAction13ExecuteActionEv")
  //</editor-fold>
  @Override protected void ExecuteAction()/* override*/ {
    ErrorOr<unique_ptr<MemoryBuffer> > Buffer = null;
    try {
      switch (getCurrentFileKind()) {
       case IK_C:
       case IK_CXX:
       case IK_ObjC:
       case IK_ObjCXX:
       case IK_OpenCL:
       case IK_CUDA:
        break;
       case IK_None:
       case IK_Asm:
       case IK_PreprocessedC:
       case IK_PreprocessedCuda:
       case IK_PreprocessedCXX:
       case IK_PreprocessedObjC:
       case IK_PreprocessedObjCXX:
       case IK_AST:
       case IK_LLVM_IR:
       case IK_RenderScript:
        // We can't do anything with these.
        return;
      }
      
      CompilerInstance /*&*/ CI = getCompilerInstance();
      Buffer = CI.getFileManager().getBufferForFile(getCurrentFile());
      if (Buffer.$bool()) {
        /*uint*/int Preamble = Lexer.ComputePreamble((Buffer.$star()).$arrow().getBuffer(), CI.getLangOpts()).first;
        llvm.outs().write((Buffer.$star()).$arrow().getBufferStart(), Preamble);
      }
    } finally {
      if (Buffer != null) { Buffer.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreambleAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 201,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 200,
   FQN="clang::PrintPreambleAction::CreateASTConsumer", NM="_ZN5clang19PrintPreambleAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang19PrintPreambleAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ $Prm0, 
                   StringRef $Prm1)/* override*/ {
    return new std.unique_ptr<ASTConsumer>((ASTConsumer)null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreambleAction::usesPreprocessorOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 206,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 205,
   FQN="clang::PrintPreambleAction::usesPreprocessorOnly", NM="_ZNK5clang19PrintPreambleAction20usesPreprocessorOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZNK5clang19PrintPreambleAction20usesPreprocessorOnlyEv")
  //</editor-fold>
  @Override public/*protected*/ boolean usesPreprocessorOnly() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreambleAction::~PrintPreambleAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 198,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 197,
   FQN="clang::PrintPreambleAction::~PrintPreambleAction", NM="_ZN5clang19PrintPreambleActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang19PrintPreambleActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreambleAction::PrintPreambleAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 198,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 197,
   FQN="clang::PrintPreambleAction::PrintPreambleAction", NM="_ZN5clang19PrintPreambleActionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang19PrintPreambleActionC1Ev")
  //</editor-fold>
  public /*inline*/ PrintPreambleAction() {
    // : FrontendAction() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
