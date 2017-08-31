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
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;
import org.clang.rewrite.frontend.*;
import org.clang.rewrite.frontend.impl.*;
import org.clang.frontend.*;
import org.clang.lex.*;


/// \brief Emits changes to temporary files and uses them for the original
/// frontend action.
//<editor-fold defaultstate="collapsed" desc="clang::FixItRecompile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FrontendActions.h", line = 51,
 FQN="clang::FixItRecompile", NM="_ZN5clang14FixItRecompileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang14FixItRecompileE")
//</editor-fold>
public class FixItRecompile extends /*public*/ WrapperFrontendAction implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRecompile::FixItRecompile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FrontendActions.h", line = 53,
   FQN="clang::FixItRecompile::FixItRecompile", NM="_ZN5clang14FixItRecompileC1ESt10unique_ptrINS_14FrontendActionESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang14FixItRecompileC1ESt10unique_ptrINS_14FrontendActionESt14default_deleteIS2_EE")
  //</editor-fold>
  public FixItRecompile(std.unique_ptr<FrontendAction> WrappedAction) {
    // : WrapperFrontendAction(std::move(WrappedAction)) 
    //START JInit
    /*ExprWithCleanups*/super(new std.unique_ptr<FrontendAction>(JD$Move.INSTANCE, std.move(WrappedAction)));
    //END JInit
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FixItRecompile::BeginInvocation">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp", line = 110,
   FQN="clang::FixItRecompile::BeginInvocation", NM="_ZN5clang14FixItRecompile15BeginInvocationERNS_16CompilerInstanceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang14FixItRecompile15BeginInvocationERNS_16CompilerInstanceE")
  //</editor-fold>
  @Override protected boolean BeginInvocation(CompilerInstance /*&*/ CI)/* override*/ {
    std.vector<std.pair<std.string, std.string>> RewrittenFiles = null;
    try {
      
      RewrittenFiles/*J*/= new std.vector<std.pair<std.string, std.string>>(new std.pairTypeType<std.string, std.string>(new std.string(), new std.string()));
      boolean err = false;
      {
        std.unique_ptr<FrontendAction> FixAction = null;
        try {
          /*const*/ FrontendOptions /*&*/ FEOpts = CI.getFrontendOpts();
          FixAction/*J*/= new std.unique_ptr<FrontendAction>(new SyntaxOnlyAction());
          if (FixAction.$arrow().BeginSourceFile(CI, FEOpts.Inputs.$at$Const(0))) {
            std.unique_ptr<FixItOptions> FixItOpts = null;
            FixItRewriter Rewriter = null;
            try {
              FixItOpts/*J*/= new std.unique_ptr<FixItOptions>();
              if (FEOpts.FixToTemporaries) {
                FixItOpts.reset(new FixItRewriteToTemp());
              } else {
                FixItOpts.reset(new FixItRewriteInPlace());
              }
              FixItOpts.$arrow().Silent = true;
              FixItOpts.$arrow().FixWhatYouCan = FEOpts.FixWhatYouCan;
              FixItOpts.$arrow().FixOnlyWarnings = FEOpts.FixOnlyWarnings;
              Rewriter/*J*/= new FixItRewriter(CI.getDiagnostics(), CI.getSourceManager(), 
                  CI.getLangOpts(), FixItOpts.get());
              FixAction.$arrow().Execute();
              
              err = Rewriter.WriteFixedFiles(/*AddrOf*/RewrittenFiles);
              
              FixAction.$arrow().EndSourceFile();
              CI.setSourceManager((SourceManager /*P*/ )null);
              CI.setFileManager((FileManager /*P*/ )null);
            } finally {
              if (Rewriter != null) { Rewriter.$destroy(); }
              if (FixItOpts != null) { FixItOpts.$destroy(); }
            }
          } else {
            err = true;
          }
        } finally {
          if (FixAction != null) { FixAction.$destroy(); }
        }
      }
      if (err) {
        return false;
      }
      CI.getDiagnosticClient().clear();
      CI.getDiagnostics().Reset();
      
      PreprocessorOptions /*&*/ PPOpts = CI.getPreprocessorOpts();
      PPOpts.RemappedFiles.insert$T(PPOpts.RemappedFiles.end(), 
          RewrittenFiles.begin(), RewrittenFiles.end());
      PPOpts.RemappedFilesKeepOriginalName = false;
      
      return true;
    } finally {
      if (RewrittenFiles != null) { RewrittenFiles.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixItRecompile::~FixItRecompile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Frontend/FrontendActions.h", line = 51,
   FQN="clang::FixItRecompile::~FixItRecompile", NM="_ZN5clang14FixItRecompileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/FrontendActions.cpp -nm=_ZN5clang14FixItRecompileD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
