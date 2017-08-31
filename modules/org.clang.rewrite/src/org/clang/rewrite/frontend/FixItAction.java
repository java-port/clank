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

package org.clang.rewrite.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.rewrite.frontend.*;
import org.clang.rewrite.frontend.impl.*;
import org.clang.frontend.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="clang::FixItAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FrontendActions.h", line = 29,
 FQN="clang::FixItAction", NM="_ZN5clang11FixItActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang11FixItActionE")
//</editor-fold>
public class FixItAction extends /*public*/ ASTFrontendAction implements Destructors.ClassWithDestructor {
/*protected:*/
  protected std.unique_ptr<FixItRewriter> Rewriter;
  protected std.unique_ptr<FixItOptions> FixItOpts;
  
  //<editor-fold defaultstate="collapsed" desc="clang::FixItAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 45,
   FQN="clang::FixItAction::CreateASTConsumer", NM="_ZN5clang11FixItAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang11FixItAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, StringRef InFile)/* override*/ {
    return llvm.make_unique(new ASTConsumer());
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::FixItAction::BeginSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 90,
   FQN="clang::FixItAction::BeginSourceFileAction", NM="_ZN5clang11FixItAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang11FixItAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected boolean BeginSourceFileAction(CompilerInstance /*&*/ CI, 
                       StringRef Filename)/* override*/ {
    /*const*/ FrontendOptions /*&*/ FEOpts = getCompilerInstance().getFrontendOpts();
    if (!FEOpts.FixItSuffix.empty()) {
      FixItOpts.reset(new FixItActionSuffixInserter(new std.string(FEOpts.FixItSuffix), 
              FEOpts.FixWhatYouCan));
    } else {
      FixItOpts.reset(new FixItRewriteInPlace());
      FixItOpts.$arrow().FixWhatYouCan = FEOpts.FixWhatYouCan;
    }
    Rewriter.reset(new FixItRewriter(CI.getDiagnostics(), CI.getSourceManager(), 
            CI.getLangOpts(), FixItOpts.get()));
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FixItAction::EndSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 105,
   FQN="clang::FixItAction::EndSourceFileAction", NM="_ZN5clang11FixItAction19EndSourceFileActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang11FixItAction19EndSourceFileActionEv")
  //</editor-fold>
  @Override protected void EndSourceFileAction()/* override*/ {
    // Otherwise rewrite all files.
    Rewriter.$arrow().WriteFixedFiles();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FixItAction::hasASTFileSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FrontendActions.h", line = 42,
   FQN="clang::FixItAction::hasASTFileSupport", NM="_ZNK5clang11FixItAction17hasASTFileSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZNK5clang11FixItAction17hasASTFileSupportEv")
  //</editor-fold>
  @Override public/*protected*/ boolean hasASTFileSupport() /*const*//* override*/ {
    return false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FixItAction::FixItAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 42,
   FQN="clang::FixItAction::FixItAction", NM="_ZN5clang11FixItActionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang11FixItActionC1Ev")
  //</editor-fold>
  public FixItAction() {
    // : ASTFrontendAction(), Rewriter(), FixItOpts() 
    //START JInit
    super();
    this.Rewriter = new std.unique_ptr<FixItRewriter>();
    this.FixItOpts = new std.unique_ptr<FixItOptions>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItAction::~FixItAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 43,
   FQN="clang::FixItAction::~FixItAction", NM="_ZN5clang11FixItActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang11FixItActionD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    FixItOpts.$destroy();
    Rewriter.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Rewriter=" + Rewriter // NOI18N
              + ", FixItOpts=" + FixItOpts // NOI18N
              + super.toString(); // NOI18N
  }
}
