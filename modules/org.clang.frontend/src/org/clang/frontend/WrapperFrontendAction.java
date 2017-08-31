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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.frontend.*;


/// \brief A frontend action which simply wraps some other runtime-specified
/// frontend action.
///
/// Deriving from this class allows an action to inject custom logic around
/// some existing action's behavior. It implements every virtual method in
/// the FrontendAction interface by forwarding to the wrapped action.
//<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 285,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", old_line = 272,
 FQN="clang::WrapperFrontendAction", NM="_ZN5clang21WrapperFrontendActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendActionE")
//</editor-fold>
public class WrapperFrontendAction extends /*public*/ FrontendAction implements Destructors.ClassWithDestructor {
  private std.unique_ptr<FrontendAction> WrappedAction;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 568,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 550,
   FQN="clang::WrapperFrontendAction::CreateASTConsumer", NM="_ZN5clang21WrapperFrontendAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, 
                   StringRef InFile)/* override*/ {
    return WrappedAction.$arrow().CreateASTConsumer(CI, new StringRef(InFile));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::BeginInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 573,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 555,
   FQN="clang::WrapperFrontendAction::BeginInvocation", NM="_ZN5clang21WrapperFrontendAction15BeginInvocationERNS_16CompilerInstanceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendAction15BeginInvocationERNS_16CompilerInstanceE")
  //</editor-fold>
  @Override protected boolean BeginInvocation(CompilerInstance /*&*/ CI)/* override*/ {
    return WrappedAction.$arrow().BeginInvocation(CI);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::BeginSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 576,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 558,
   FQN="clang::WrapperFrontendAction::BeginSourceFileAction", NM="_ZN5clang21WrapperFrontendAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected boolean BeginSourceFileAction(CompilerInstance /*&*/ CI, 
                       StringRef Filename)/* override*/ {
    WrappedAction.$arrow().setCurrentInput(getCurrentInput());
    WrappedAction.$arrow().setCompilerInstance(/*AddrOf*/CI);
    boolean Ret = WrappedAction.$arrow().BeginSourceFileAction(CI, new StringRef(Filename));
    // BeginSourceFileAction may change CurrentInput, e.g. during module builds.
    setCurrentInput(WrappedAction.$arrow().getCurrentInput());
    return Ret;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::ExecuteAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 585,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 564,
   FQN="clang::WrapperFrontendAction::ExecuteAction", NM="_ZN5clang21WrapperFrontendAction13ExecuteActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendAction13ExecuteActionEv")
  //</editor-fold>
  @Override protected void ExecuteAction()/* override*/ {
    WrappedAction.$arrow().ExecuteAction();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::EndSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 588,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 567,
   FQN="clang::WrapperFrontendAction::EndSourceFileAction", NM="_ZN5clang21WrapperFrontendAction19EndSourceFileActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendAction19EndSourceFileActionEv")
  //</editor-fold>
  @Override protected void EndSourceFileAction()/* override*/ {
    WrappedAction.$arrow().EndSourceFileAction();
  }

/*public:*/
  /// Construct a WrapperFrontendAction from an existing action, taking
  /// ownership of it.
  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::WrapperFrontendAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 611,
   FQN="clang::WrapperFrontendAction::WrapperFrontendAction", NM="_ZN5clang21WrapperFrontendActionC1ESt10unique_ptrINS_14FrontendActionESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendActionC1ESt10unique_ptrINS_14FrontendActionESt14default_deleteIS2_EE")
  //</editor-fold>
  public WrapperFrontendAction(std.unique_ptr<FrontendAction> WrappedAction) {
    // : FrontendAction(), WrappedAction(std::move(WrappedAction)) 
    //START JInit
    super();
    this.WrappedAction = new std.unique_ptr<FrontendAction>(JD$Move.INSTANCE, std.move(WrappedAction));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::usesPreprocessorOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 592,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 571,
   FQN="clang::WrapperFrontendAction::usesPreprocessorOnly", NM="_ZNK5clang21WrapperFrontendAction20usesPreprocessorOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang21WrapperFrontendAction20usesPreprocessorOnlyEv")
  //</editor-fold>
  @Override public boolean usesPreprocessorOnly() /*const*//* override*/ {
    return WrappedAction.$arrow().usesPreprocessorOnly();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::getTranslationUnitKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 595,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 574,
   FQN="clang::WrapperFrontendAction::getTranslationUnitKind", NM="_ZN5clang21WrapperFrontendAction22getTranslationUnitKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendAction22getTranslationUnitKindEv")
  //</editor-fold>
  @Override public TranslationUnitKind getTranslationUnitKind()/* override*/ {
    return WrappedAction.$arrow().getTranslationUnitKind();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::hasPCHSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 598,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 577,
   FQN="clang::WrapperFrontendAction::hasPCHSupport", NM="_ZNK5clang21WrapperFrontendAction13hasPCHSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang21WrapperFrontendAction13hasPCHSupportEv")
  //</editor-fold>
  @Override public boolean hasPCHSupport() /*const*//* override*/ {
    return WrappedAction.$arrow().hasPCHSupport();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::hasASTFileSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 601,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 580,
   FQN="clang::WrapperFrontendAction::hasASTFileSupport", NM="_ZNK5clang21WrapperFrontendAction17hasASTFileSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang21WrapperFrontendAction17hasASTFileSupportEv")
  //</editor-fold>
  @Override public boolean hasASTFileSupport() /*const*//* override*/ {
    return WrappedAction.$arrow().hasASTFileSupport();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::hasIRSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 604,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 583,
   FQN="clang::WrapperFrontendAction::hasIRSupport", NM="_ZNK5clang21WrapperFrontendAction12hasIRSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang21WrapperFrontendAction12hasIRSupportEv")
  //</editor-fold>
  @Override public boolean hasIRSupport() /*const*//* override*/ {
    return WrappedAction.$arrow().hasIRSupport();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::hasCodeCompletionSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 607,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 586,
   FQN="clang::WrapperFrontendAction::hasCodeCompletionSupport", NM="_ZNK5clang21WrapperFrontendAction24hasCodeCompletionSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang21WrapperFrontendAction24hasCodeCompletionSupportEv")
  //</editor-fold>
  @Override public boolean hasCodeCompletionSupport() /*const*//* override*/ {
    return WrappedAction.$arrow().hasCodeCompletionSupport();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::WrapperFrontendAction::~WrapperFrontendAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 285,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", old_line = 272,
   FQN="clang::WrapperFrontendAction::~WrapperFrontendAction", NM="_ZN5clang21WrapperFrontendActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang21WrapperFrontendActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    WrappedAction.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "WrappedAction=" + WrappedAction // NOI18N
              + super.toString(); // NOI18N
  }
}
