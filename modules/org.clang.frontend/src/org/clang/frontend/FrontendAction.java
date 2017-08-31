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
import org.llvm.adt.java.ADTJavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import org.clang.serialization.GlobalModuleIndex;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;
import org.clang.frontend.llvm.*;


/// Abstract base class for actions which can be performed by the frontend.
//<editor-fold defaultstate="collapsed" desc="clang::FrontendAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 36,
 FQN="clang::FrontendAction", NM="_ZN5clang14FrontendActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendActionE")
//</editor-fold>
public abstract class FrontendAction implements Destructors.ClassWithDestructor {
  private FrontendInputFile CurrentInput;
  private std.unique_ptr<ASTUnit> CurrentASTUnit;
  private CompilerInstance /*P*/ Instance;
  /*friend  class ASTMergeAction*/
  /*friend  class WrapperFrontendAction*/
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::CreateWrappedASTConsumer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 137,
   FQN="clang::FrontendAction::CreateWrappedASTConsumer", NM="_ZN5clang14FrontendAction24CreateWrappedASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction24CreateWrappedASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  private std.unique_ptr<ASTConsumer> CreateWrappedASTConsumer(CompilerInstance /*&*/ CI, 
                          StringRef InFile) {
    std.unique_ptr<ASTConsumer> Consumer = null;
    std.vector<std.unique_ptr<ASTConsumer>> Consumers = null;
    std.vector<std.unique_ptr<ASTConsumer>> AfterConsumers = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Consumer = CreateASTConsumer(CI, new StringRef(InFile));
      if (!Consumer.$bool()) {
        return new std.unique_ptr<ASTConsumer>(JD$NullPtr.INSTANCE, null);
      }
      
      // If there are no registered plugins we don't need to wrap the consumer
      if (FrontendPluginRegistry.begin().$eq(FrontendPluginRegistry.end())) {
        return new std.unique_ptr<ASTConsumer>(JD$Move.INSTANCE, Consumer);
      }
      
      // Collect the list of plugins that go before the main action (in Consumers)
      // or after it (in AfterConsumers)
      Consumers/*J*/= new std.vector<std.unique_ptr<ASTConsumer>>(new std.unique_ptr<ASTConsumer>());
      AfterConsumers/*J*/= new std.vector<std.unique_ptr<ASTConsumer>>(new std.unique_ptr<ASTConsumer>());
      for (FrontendPluginRegistry.iterator<PluginASTAction> it = FrontendPluginRegistry.begin(), 
          ie = FrontendPluginRegistry.end();
           it.$noteq(ie); it.$preInc()) {
        std.unique_ptr<PluginASTAction> P = null;
        try {
          P = it.$arrow().instantiate();
          PluginASTAction.ActionType ActionType = P.$arrow().getActionType();
          if (ActionType == PluginASTAction.ActionType.Cmdline) {
            // This is O(|plugins| * |add_plugins|), but since both numbers are
            // way below 50 in practice, that's ok.
            for (/*size_t*/int i = 0, e = CI.getFrontendOpts().AddPluginActions.size();
                 i != e; ++i) {
              if ($eq_T$C$P_string$C(it.$arrow().getName(), CI.getFrontendOpts().AddPluginActions.$at(i))) {
                ActionType = PluginASTAction.ActionType.AddAfterMainAction;
                break;
              }
            }
          }
          if ((ActionType == PluginASTAction.ActionType.AddBeforeMainAction
             || ActionType == PluginASTAction.ActionType.AddAfterMainAction)
             && P.$arrow().ParseArgs(CI, CI.getFrontendOpts().PluginArgs.$at(new std.string(it.$arrow().getName())))) {
            std.unique_ptr<ASTConsumer> PluginConsumer = null;
            try {
              PluginConsumer = P.$arrow().CreateASTConsumer(CI, new StringRef(InFile));
              if (ActionType == PluginASTAction.ActionType.AddBeforeMainAction) {
                Consumers.push_back_T$RR(std.move(PluginConsumer));
              } else {
                AfterConsumers.push_back_T$RR(std.move(PluginConsumer));
              }
            } finally {
              if (PluginConsumer != null) { PluginConsumer.$destroy(); }
            }
          }
        } finally {
          if (P != null) { P.$destroy(); }
        }
      }
      
      // Add to Consumers the main consumer, then all the plugins that go after it
      Consumers.push_back_T$RR(std.move(Consumer));
      for (unique_ptr<ASTConsumer> /*&*/ C : AfterConsumers) {
        Consumers.push_back_T$RR(std.move(C));
      }
      
      return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MultiplexConsumer(std.move(Consumers))))));
    } finally {
      if (AfterConsumers != null) { AfterConsumers.$destroy(); }
      if (Consumers != null) { Consumers.$destroy(); }
      if (Consumer != null) { Consumer.$destroy(); }
      $c$.$destroy();
    }
  }

/*protected:*/
  /// @name Implementation Action Interface
  /// @{
  
  /// \brief Create the AST consumer object for this action, if supported.
  ///
  /// This routine is called as part of BeginSourceFile(), which will
  /// fail if the AST consumer cannot be created. This will not be called if the
  /// action has indicated that it only uses the preprocessor.
  ///
  /// \param CI - The current compiler instance, provided as a convenience, see
  /// getCompilerInstance().
  ///
  /// \param InFile - The current input file, provided as a convenience, see
  /// getCurrentFile().
  ///
  /// \return The new AST consumer, or null on failure.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 64,
   FQN="clang::FrontendAction::CreateASTConsumer", NM="_ZN5clang14FrontendAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  protected abstract /*virtual*/ std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, 
                   StringRef InFile)/* = 0*/;

  
  /// \brief Callback before starting processing a single input, giving the
  /// opportunity to modify the CompilerInvocation or do some other action
  /// before BeginSourceFileAction is called.
  ///
  /// \return True on success; on failure BeginSourceFileAction(),
  /// ExecuteAction() and EndSourceFileAction() will not be called.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::BeginInvocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 73,
   FQN="clang::FrontendAction::BeginInvocation", NM="_ZN5clang14FrontendAction15BeginInvocationERNS_16CompilerInstanceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction15BeginInvocationERNS_16CompilerInstanceE")
  //</editor-fold>
  protected /*virtual*/ boolean BeginInvocation(CompilerInstance /*&*/ CI) {
    return true;
  }

  
  /// \brief Callback at the start of processing a single input.
  ///
  /// \return True on success; on failure ExecutionAction() and
  /// EndSourceFileAction() will not be called.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::BeginSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 79,
   FQN="clang::FrontendAction::BeginSourceFileAction", NM="_ZN5clang14FrontendAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  protected /*virtual*/ boolean BeginSourceFileAction(CompilerInstance /*&*/ CI, 
                       StringRef Filename) {
    return true;
  }

  
  /// \brief Callback to run the program action, using the initialized
  /// compiler instance.
  ///
  /// This is guaranteed to only be called between BeginSourceFileAction()
  /// and EndSourceFileAction().
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::ExecuteAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 89,
   FQN="clang::FrontendAction::ExecuteAction", NM="_ZN5clang14FrontendAction13ExecuteActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction13ExecuteActionEv")
  //</editor-fold>
  protected abstract /*virtual*/ void ExecuteAction()/* = 0*/;

  
  /// \brief Callback at the end of processing a single input.
  ///
  /// This is guaranteed to only be called following a successful call to
  /// BeginSourceFileAction (and BeginSourceFile).
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::EndSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 95,
   FQN="clang::FrontendAction::EndSourceFileAction", NM="_ZN5clang14FrontendAction19EndSourceFileActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction19EndSourceFileActionEv")
  //</editor-fold>
  protected /*virtual*/ void EndSourceFileAction() {
  }

  
  /// \brief Callback at the end of processing a single input, to determine
  /// if the output files should be erased or not.
  ///
  /// By default it returns true if a compiler error occurred.
  /// This is guaranteed to only be called following a successful call to
  /// BeginSourceFileAction (and BeginSourceFile).
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::shouldEraseOutputFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 529,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 511,
   FQN="clang::FrontendAction::shouldEraseOutputFiles", NM="_ZN5clang14FrontendAction22shouldEraseOutputFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction22shouldEraseOutputFilesEv")
  //</editor-fold>
  protected boolean shouldEraseOutputFiles() {
    return getCompilerInstance().getDiagnostics().hasErrorOccurred();
  }


  /// @}
  /*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::FrontendAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 127,
   FQN="clang::FrontendAction::FrontendAction", NM="_ZN5clang14FrontendActionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendActionC1Ev")
  //</editor-fold>
  public FrontendAction() {
    // : CurrentInput(), CurrentASTUnit(), Instance(null) 
    //START JInit
    this.CurrentInput = new FrontendInputFile();
    this.CurrentASTUnit = new std.unique_ptr<ASTUnit>();
    this.Instance = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::~FrontendAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 129,
   FQN="clang::FrontendAction::~FrontendAction", NM="_ZN5clang14FrontendActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendActionD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    CurrentASTUnit.$destroy();
    CurrentInput.$destroy();
    //END JDestroy
  }

  
  /// @name Compiler Instance Access
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::getCompilerInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 114,
   FQN="clang::FrontendAction::getCompilerInstance", NM="_ZNK5clang14FrontendAction19getCompilerInstanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction19getCompilerInstanceEv")
  //</editor-fold>
  public CompilerInstance /*&*/ getCompilerInstance() /*const*/ {
    assert ((Instance != null)) : "Compiler instance not registered!";
    return /*Deref*/Instance;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::setCompilerInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 119,
   FQN="clang::FrontendAction::setCompilerInstance", NM="_ZN5clang14FrontendAction19setCompilerInstanceEPNS_16CompilerInstanceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction19setCompilerInstanceEPNS_16CompilerInstanceE")
  //</editor-fold>
  public void setCompilerInstance(CompilerInstance /*P*/ Value) {
    Instance = Value;
  }

  
  /// @}
  /// @name Current File Information
  /// @{
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::isCurrentFileAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 125,
   FQN="clang::FrontendAction::isCurrentFileAST", NM="_ZNK5clang14FrontendAction16isCurrentFileASTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction16isCurrentFileASTEv")
  //</editor-fold>
  public boolean isCurrentFileAST() /*const*/ {
    assert (!CurrentInput.isEmpty()) : "No current file!";
    return (boolean)CurrentASTUnit.$bool();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::getCurrentInput">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 130,
   FQN="clang::FrontendAction::getCurrentInput", NM="_ZNK5clang14FrontendAction15getCurrentInputEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction15getCurrentInputEv")
  //</editor-fold>
  public /*const*/ FrontendInputFile /*&*/ getCurrentInput() /*const*/ {
    return CurrentInput;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::getCurrentFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 134,
   FQN="clang::FrontendAction::getCurrentFile", NM="_ZNK5clang14FrontendAction14getCurrentFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction14getCurrentFileEv")
  //</editor-fold>
  public /*const*/ StringRef getCurrentFile() /*const*/ {
    assert (!CurrentInput.isEmpty()) : "No current file!";
    return CurrentInput.getFile();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::getCurrentFileKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 139,
   FQN="clang::FrontendAction::getCurrentFileKind", NM="_ZNK5clang14FrontendAction18getCurrentFileKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction18getCurrentFileKindEv")
  //</editor-fold>
  public InputKind getCurrentFileKind() /*const*/ {
    assert (!CurrentInput.isEmpty()) : "No current file!";
    return CurrentInput.getKind();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::getCurrentASTUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 144,
   FQN="clang::FrontendAction::getCurrentASTUnit", NM="_ZNK5clang14FrontendAction17getCurrentASTUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction17getCurrentASTUnitEv")
  //</editor-fold>
  public ASTUnit /*&*/ getCurrentASTUnit() /*const*/ {
    assert (CurrentASTUnit.$bool()) : "No current AST unit!";
    return CurrentASTUnit.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::takeCurrentASTUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 149,
   FQN="clang::FrontendAction::takeCurrentASTUnit", NM="_ZN5clang14FrontendAction18takeCurrentASTUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction18takeCurrentASTUnitEv")
  //</editor-fold>
  public std.unique_ptr<ASTUnit> takeCurrentASTUnit() {
    return new std.unique_ptr<ASTUnit>(JD$Move.INSTANCE, std.move(CurrentASTUnit));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::setCurrentInput">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 131,
   FQN="clang::FrontendAction::setCurrentInput", NM="_ZN5clang14FrontendAction15setCurrentInputERKNS_17FrontendInputFileESt10unique_ptrINS_7ASTUnitESt14default_deleteIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction15setCurrentInputERKNS_17FrontendInputFileESt10unique_ptrINS_7ASTUnitESt14default_deleteIS5_EE")
  //</editor-fold>
  public void setCurrentInput(/*const*/ FrontendInputFile /*&*/ CurrentInput) {
    setCurrentInput(CurrentInput, 
                 new std.unique_ptr<ASTUnit>(JD$NullPtr.INSTANCE, null));
  }
  public void setCurrentInput(/*const*/ FrontendInputFile /*&*/ CurrentInput, 
                 std.unique_ptr<ASTUnit> AST/*= null*/) {
    this.CurrentInput.$assign(CurrentInput);
    CurrentASTUnit.$assignMove(std.move(AST));
  }

  
  /// @}
  /// @name Supported Modes
  /// @{
  
  /// \brief Is this action invoked on a model file?
  ///
  /// Model files are incomplete translation units that relies on type
  /// information from another translation unit. Check ParseModelFileAction for
  /// details.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::isModelParsingAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 165,
   FQN="clang::FrontendAction::isModelParsingAction", NM="_ZNK5clang14FrontendAction20isModelParsingActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction20isModelParsingActionEv")
  //</editor-fold>
  public /*virtual*/ boolean isModelParsingAction() /*const*/ {
    return false;
  }

  
  /// \brief Does this action only use the preprocessor?
  ///
  /// If so no AST context will be created and this action will be invalid
  /// with AST file inputs.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::usesPreprocessorOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 171,
   FQN="clang::FrontendAction::usesPreprocessorOnly", NM="_ZNK5clang14FrontendAction20usesPreprocessorOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction20usesPreprocessorOnlyEv")
  //</editor-fold>
  public abstract /*virtual*/ boolean usesPreprocessorOnly() /*const*//* = 0*/;

  
  /// \brief For AST-based actions, the kind of translation unit we're handling.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::getTranslationUnitKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 174,
   FQN="clang::FrontendAction::getTranslationUnitKind", NM="_ZN5clang14FrontendAction22getTranslationUnitKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction22getTranslationUnitKindEv")
  //</editor-fold>
  public /*virtual*/ TranslationUnitKind getTranslationUnitKind() {
    return TranslationUnitKind.TU_Complete;
  }

  
  /// \brief Does this action support use with PCH?
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::hasPCHSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 177,
   FQN="clang::FrontendAction::hasPCHSupport", NM="_ZNK5clang14FrontendAction13hasPCHSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction13hasPCHSupportEv")
  //</editor-fold>
  public /*virtual*/ boolean hasPCHSupport() /*const*/ {
    return !usesPreprocessorOnly();
  }

  
  /// \brief Does this action support use with AST files?
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::hasASTFileSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 180,
   FQN="clang::FrontendAction::hasASTFileSupport", NM="_ZNK5clang14FrontendAction17hasASTFileSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction17hasASTFileSupportEv")
  //</editor-fold>
  public /*virtual*/ boolean hasASTFileSupport() /*const*/ {
    return !usesPreprocessorOnly();
  }

  
  /// \brief Does this action support use with IR files?
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::hasIRSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 183,
   FQN="clang::FrontendAction::hasIRSupport", NM="_ZNK5clang14FrontendAction12hasIRSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction12hasIRSupportEv")
  //</editor-fold>
  public /*virtual*/ boolean hasIRSupport() /*const*/ {
    return false;
  }

  
  /// \brief Does this action support use with code completion?
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::hasCodeCompletionSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendAction.h", line = 186,
   FQN="clang::FrontendAction::hasCodeCompletionSupport", NM="_ZNK5clang14FrontendAction24hasCodeCompletionSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZNK5clang14FrontendAction24hasCodeCompletionSupportEv")
  //</editor-fold>
  public /*virtual*/ boolean hasCodeCompletionSupport() /*const*/ {
    return false;
  }

  
  /// @}
  /// @name Public Action Interface
  /// @{
  
  /// \brief Prepare the action for processing the input file \p Input.
  ///
  /// This is run after the options and frontend have been initialized,
  /// but prior to executing any per-file processing.
  ///
  /// \param CI - The compiler instance this action is being run from. The
  /// action may store and use this object up until the matching EndSourceFile
  /// action.
  ///
  /// \param Input - The input filename and kind. Some input kinds are handled
  /// specially, for example AST inputs, since the AST file itself contains
  /// several objects which would normally be owned by the
  /// CompilerInstance. When processing AST input files, these objects should
  /// generally not be initialized in the CompilerInstance -- they will
  /// automatically be shared with the AST file in between
  /// BeginSourceFile() and EndSourceFile().
  ///
  /// \return True on success; on failure the compilation of this file should
  /// be aborted and neither Execute() nor EndSourceFile() should be called.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::BeginSourceFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*goto*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 189,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 171,
   FQN="clang::FrontendAction::BeginSourceFile", NM="_ZN5clang14FrontendAction15BeginSourceFileERNS_16CompilerInstanceERKNS_17FrontendInputFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction15BeginSourceFileERNS_16CompilerInstanceERKNS_17FrontendInputFileE")
  //</editor-fold>
  public boolean BeginSourceFile(CompilerInstance /*&*/ CI, 
                 /*const*/ FrontendInputFile /*&*/ Input) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (!(Instance != null)) : "Already processing a source file!";
      assert (!Input.isEmpty()) : "Unexpected empty filename!";
      setCurrentInput(Input);
      setCompilerInstance(/*AddrOf*/CI);
      
      StringRef InputFile = Input.getFile();
      boolean HasBegunSourceFile = false;
      TrueBlock:
      do {
      if (!BeginInvocation(CI)) {
        /*JAVA*/break TrueBlock; // goto failure;
      }
      
      // AST files follow a very different path, since they share objects via the
      // AST unit.
      if (Input.getKind() == InputKind.IK_AST) {
        IntrusiveRefCntPtr<DiagnosticsEngine> Diags = null;
        std.unique_ptr<ASTUnit> AST = null;
        try {
          assert (!usesPreprocessorOnly()) : "Attempt to pass AST file to preprocessor only action!";
          assert (hasASTFileSupport()) : "This action does not have AST file support!";
          
          Diags/*J*/= new IntrusiveRefCntPtr<DiagnosticsEngine>(/*AddrOf*/CI.getDiagnostics());
          
          AST = $c$.clean(ASTUnit.LoadFromASTFile(InputFile.$string(), CI.getPCHContainerReader(), $c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags)), CI.getFileSystemOpts(), 
              CI.getCodeGenOpts().DebugTypeExtRefs));
          if (!AST.$bool()) {
            /*JAVA*/break TrueBlock; // goto failure;
          }
          
          // Inform the diagnostic client we are processing a source file.
          CI.getDiagnosticClient().BeginSourceFile(CI.getLangOpts(), (/*const*/ Preprocessor /*P*/ )null);
          HasBegunSourceFile = true;
          
          // Set the shared objects, these are reset when we finish processing the
          // file, otherwise the CompilerInstance will happily destroy them.
          CI.setFileManager(/*AddrOf*/AST.$arrow().getFileManager());
          CI.setSourceManager(/*AddrOf*/AST.$arrow().getSourceManager());
          CI.setPreprocessor(/*AddrOf*/AST.$arrow().getPreprocessor());
          CI.setASTContext(/*AddrOf*/AST.$arrow().getASTContext());
          
          setCurrentInput(Input, $c$.track(new std.unique_ptr<ASTUnit>(JD$Move.INSTANCE, std.move(AST)))); $c$.clean();
          
          // Initialize the action.
          if (!BeginSourceFileAction(CI, new StringRef(InputFile))) {
            /*JAVA*/break TrueBlock; // goto failure;
          }
          
          // Create the AST consumer.
          CI.setASTConsumer($c$.track(CreateWrappedASTConsumer(CI, new StringRef(InputFile)))); $c$.clean();
          if (!CI.hasASTConsumer()) {
            /*JAVA*/break TrueBlock; // goto failure;
          }
          
          return true;
        } finally {
          if (AST != null) { AST.$destroy(); }
          if (Diags != null) { Diags.$destroy(); }
        }
      }
      if (!CI.hasVirtualFileSystem()) {
        {
          IntrusiveRefCntPtr<FileSystem> VFS = null;
          try {
            VFS = createVFSFromCompilerInvocation(CI.getInvocation(), 
                CI.getDiagnostics());
            if (VFS.$bool()) {
              CI.setVirtualFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(VFS))); $c$.clean();
            } else {
              /*JAVA*/break TrueBlock; // goto failure;
            }
          } finally {
            if (VFS != null) { VFS.$destroy(); }
          }
        }
      }
      
      // Set up the file and source managers, if needed.
      if (!CI.hasFileManager()) {
        CI.createFileManager();
      }
      if (!CI.hasSourceManager()) {
        CI.createSourceManager(CI.getFileManager());
      }
      
      // IR files bypass the rest of initialization.
      if (Input.getKind() == InputKind.IK_LLVM_IR) {
        assert (hasIRSupport()) : "This action does not have IR file support!";
        
        // Inform the diagnostic client we are processing a source file.
        CI.getDiagnosticClient().BeginSourceFile(CI.getLangOpts(), (/*const*/ Preprocessor /*P*/ )null);
        HasBegunSourceFile = true;
        
        // Initialize the action.
        if (!BeginSourceFileAction(CI, new StringRef(InputFile))) {
          /*JAVA*/break TrueBlock; // goto failure;
        }
        
        // Initialize the main file entry.
        if (!CI.InitializeSourceManager(CurrentInput)) {
          /*JAVA*/break TrueBlock; // goto failure;
        }
        
        return true;
      }
      
      // If the implicit PCH include is actually a directory, rather than
      // a single file, search for a suitable PCH file in that directory.
      if (!CI.getPreprocessorOpts().ImplicitPCHInclude.empty()) {
        FileManager /*&*/ FileMgr = CI.getFileManager();
        PreprocessorOptions /*&*/ PPOpts = CI.getPreprocessorOpts();
        StringRef PCHInclude = new StringRef(PPOpts.ImplicitPCHInclude);
        std.string SpecificModuleCachePath = CI.getSpecificModuleCachePath();
        {
          /*const*/ DirectoryEntry /*P*/ PCHDir = FileMgr.getDirectory(/*NO_COPY*/PCHInclude);
          if ((PCHDir != null)) {
            std.error_code EC/*J*/= new std.error_code();
            SmallString/*128*/ DirNative/*J*/= new SmallString/*128*/(128);
            path.__native(new Twine(PCHDir.getName()), DirNative);
            boolean Found = false;
            fs.directory_iterator Dir = null;
            fs.directory_iterator DirEnd = null;
            try {
              for (Dir/*J*/= new fs.directory_iterator(new Twine(DirNative), EC), DirEnd/*J*/= new fs.directory_iterator();
                   Dir.$noteq(DirEnd) && !EC.$bool(); Dir.increment(EC)) {
                // Check whether this is an acceptable AST file.
                if (ASTReader.isAcceptableASTFile(new StringRef(Dir.$arrow().getPath()), FileMgr, CI.getPCHContainerReader(), 
                    CI.getLangOpts(), CI.getTargetOpts(), CI.getPreprocessorOpts(), 
                    new std.string(SpecificModuleCachePath))) {
                  PPOpts.ImplicitPCHInclude.$assign(Dir.$arrow().getPath());
                  Found = true;
                  break;
                }
              }
            } finally {
              if (DirEnd != null) { DirEnd.$destroy(); }
              if (Dir != null) { Dir.$destroy(); }
            }
            if (!Found) {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_fe_no_pch_in_dir)), /*NO_COPY*/PCHInclude));
              /*JAVA*/break TrueBlock; // goto failure;
            }
          }
        }
      }
      
      // Set up the preprocessor if needed. When parsing model files the
      // preprocessor of the original source is reused.
      if (!isModelParsingAction()) {
        CI.createPreprocessor(getTranslationUnitKind());
      }
      
      // Inform the diagnostic client we are processing a source file.
      CI.getDiagnosticClient().BeginSourceFile(CI.getLangOpts(), 
          /*AddrOf*/CI.getPreprocessor());
      HasBegunSourceFile = true;
      
      // Initialize the action.
      if (!BeginSourceFileAction(CI, new StringRef(InputFile))) {
        /*JAVA*/break TrueBlock; // goto failure;
      }
      
      // Initialize the main file entry. It is important that this occurs after
      // BeginSourceFileAction, which may change CurrentInput during module builds.
      if (!CI.InitializeSourceManager(CurrentInput)) {
        /*JAVA*/break TrueBlock; // goto failure;
      }
      
      // Create the AST context and consumer unless this is a preprocessor only
      // action.
      if (!usesPreprocessorOnly()) {
        std.unique_ptr<ASTConsumer> Consumer = null;
        try {
          // Parsing a model file should reuse the existing ASTContext.
          if (!isModelParsingAction()) {
            CI.createASTContext();
          }
          
          Consumer = CreateWrappedASTConsumer(CI, new StringRef(InputFile));
          if (!Consumer.$bool()) {
            /*JAVA*/break TrueBlock; // goto failure;
          }
          
          // FIXME: should not overwrite ASTMutationListener when parsing model files?
          if (!isModelParsingAction()) {
            CI.getASTContext().setASTMutationListener(Consumer.$arrow().GetASTMutationListener());
          }
          if (!CI.getPreprocessorOpts().ChainedIncludes.empty()) {
            IntrusiveRefCntPtr<ExternalSemaSource> source = null;
            IntrusiveRefCntPtr<ExternalSemaSource> FinalReader = null;
            try {
              // Convert headers to PCH and chain them.
              source/*J*/= new IntrusiveRefCntPtr<ExternalSemaSource>();
              FinalReader/*J*/= new IntrusiveRefCntPtr<ExternalSemaSource>();
              $c$.clean(source.$assign($c$.track(createChainedIncludesSource(CI, FinalReader))));
              if (!source.$bool()) {
                /*JAVA*/break TrueBlock; // goto failure;
              }
              CI.setModuleManager($c$.track(new IntrusiveRefCntPtr<ASTReader>(((/*static_cast*/ASTReader /*P*/ )(FinalReader.get()))))); $c$.clean();
              CI.getASTContext().setExternalSource($c$.track(new IntrusiveRefCntPtr<ExternalASTSource>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, source))); $c$.clean();
            } finally {
              if (FinalReader != null) { FinalReader.$destroy(); }
              if (source != null) { source.$destroy(); }
            }
          } else if (!CI.getPreprocessorOpts().ImplicitPCHInclude.empty()) {
            // Use PCH.
            assert (hasPCHSupport()) : "This action does not have PCH support!";
            ASTDeserializationListener /*P*/ DeserialListener = (ASTDeserializationListener) Consumer.$arrow().GetASTDeserializationListener();
            boolean DeleteDeserialListener = false;
            if (CI.getPreprocessorOpts().DumpDeserializedPCHDecls) {
              DeserialListener = new DeserializedDeclsDumper(DeserialListener, 
                  DeleteDeserialListener);
              DeleteDeserialListener = true;
            }
            if (!CI.getPreprocessorOpts().DeserializedPCHDeclsToErrorOn.empty()) {
              DeserialListener = new DeserializedDeclsChecker(CI.getASTContext(), 
                  CI.getPreprocessorOpts().DeserializedPCHDeclsToErrorOn, 
                  DeserialListener, DeleteDeserialListener);
              DeleteDeserialListener = true;
            }
            CI.createPCHExternalASTSource(new StringRef(CI.getPreprocessorOpts().ImplicitPCHInclude), 
                CI.getPreprocessorOpts().DisablePCHValidation, 
                CI.getPreprocessorOpts().AllowPCHWithCompilerErrors, DeserialListener, 
                DeleteDeserialListener);
            if (!(CI.getASTContext().getExternalSource() != null)) {
              /*JAVA*/break TrueBlock; // goto failure;
            }
          }
          
          CI.setASTConsumer($c$.track(new std.unique_ptr<ASTConsumer>(JD$Move.INSTANCE, std.move(Consumer)))); $c$.clean();
          if (!CI.hasASTConsumer()) {
            /*JAVA*/break TrueBlock; // goto failure;
          }
        } finally {
          if (Consumer != null) { Consumer.$destroy(); }
        }
      }
      
      // Initialize built-in info as long as we aren't using an external AST
      // source.
      if (!CI.hasASTContext() || !(CI.getASTContext().getExternalSource() != null)) {
        Preprocessor /*&*/ PP = CI.getPreprocessor();
        
        // If modules are enabled, create the module manager before creating
        // any builtins, so that all declarations know that they might be
        // extended by an external source.
        if (CI.getLangOpts().Modules) {
          CI.createModuleManager();
        }
        
        PP.getBuiltinInfo().initializeBuiltins(PP.getIdentifierTable(), 
            PP.getLangOpts());
      } else {
        // FIXME: If this is a problem, recover from it by creating a multiplex
        // source.
        assert ((!CI.getLangOpts().Modules || $c$.track(CI.getModuleManager()).$bool())) : "modules enabled but created an external source that doesn't support modules"; $c$.clean();
      }
      
      // If we were asked to load any module map files, do so now.
      for (/*const*/std.string/*&*/ Filename : CI.getFrontendOpts().ModuleMapFiles) {
        {
          /*const*/ FileEntry /*P*/ File = CI.getFileManager().getFile(new StringRef(Filename));
          if ((File != null)) {
            CI.getPreprocessor().getHeaderSearchInfo().loadModuleMapFile(File, /*IsSystem*/ false);
          } else {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_module_map_not_found)), new StringRef(Filename)));
          }
        }
      }
      
      // If we were asked to load any module files, do so now.
      for (/*const*/std.string/*&*/ ModuleFile : CI.getFrontendOpts().ModuleFiles)  {
        if (!CI.loadModuleFile(new StringRef(ModuleFile))) {
          /*JAVA*/break TrueBlock; // goto failure;
        }
      }
      
      // If there is a layout overrides file, attach an external AST source that
      // provides the layouts from that file.
      if (!CI.getFrontendOpts().OverrideRecordLayoutsFile.empty()
         && CI.hasASTContext() && !(CI.getASTContext().getExternalSource() != null)) {
        IntrusiveRefCntPtr<ExternalASTSource> Override = null;
        try {
          Override/*J*/= new IntrusiveRefCntPtr<ExternalASTSource>(new LayoutOverrideSource(new StringRef(CI.getFrontendOpts().OverrideRecordLayoutsFile)));
          CI.getASTContext().setExternalSource($c$.track(new IntrusiveRefCntPtr<ExternalASTSource>(Override))); $c$.clean();
        } finally {
          if (Override != null) { Override.$destroy(); }
        }
      }
      
      return true;
     } while(false);
     failure:
      
      // If we failed, reset state since the client will not end up calling the
      // matching EndSourceFile().
      if (isCurrentFileAST()) {
        CI.setASTContext((ASTContext /*P*/ )null);
        CI.setPreprocessor((Preprocessor /*P*/ )null);
        CI.setSourceManager((SourceManager /*P*/ )null);
        CI.setFileManager((FileManager /*P*/ )null);
      }
      if (HasBegunSourceFile) {
        CI.getDiagnosticClient().EndSourceFile();
      }
      CI.clearOutputFiles(/*EraseFiles=*/ true);
      setCurrentInput($c$.track(new FrontendInputFile())); $c$.clean();
      setCompilerInstance((CompilerInstance /*P*/ )null);
      return false;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Set the source manager's main input file, and run the action.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::Execute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 450,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 432,
   FQN="clang::FrontendAction::Execute", NM="_ZN5clang14FrontendAction7ExecuteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction7ExecuteEv")
  //</editor-fold>
  public boolean Execute() {
    CompilerInstance /*&*/ CI = getCompilerInstance();
    if (CI.hasFrontendTimer()) {
      TimeRegion Timer = null;
      try {
        Timer/*J*/= new TimeRegion(JD$Timer.INSTANCE, CI.getFrontendTimer());
        ExecuteAction();
      } finally {
        if (Timer != null) { Timer.$destroy(); }
      }
    } else {
      ExecuteAction();
    }
    
    // If we are supposed to rebuild the global module index, do so now unless
    // there were any module-build failures.
    if (CI.shouldBuildGlobalModuleIndex() && CI.hasFileManager()
       && CI.hasPreprocessor()) {
      StringRef Cache = CI.getPreprocessor().getHeaderSearchInfo().getModuleCachePath();
      if (!Cache.empty()) {
        GlobalModuleIndex.writeIndex(CI.getFileManager(), 
            CI.getPCHContainerReader(), new StringRef(Cache));
      }
    }
    
    return true;
  }

  
  /// \brief Perform any per-file post processing, deallocate per-file
  /// objects, and run statistics and output file cleanup code.
  //<editor-fold defaultstate="collapsed" desc="clang::FrontendAction::EndSourceFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 473,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", old_line = 455,
   FQN="clang::FrontendAction::EndSourceFile", NM="_ZN5clang14FrontendAction13EndSourceFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN5clang14FrontendAction13EndSourceFileEv")
  //</editor-fold>
  public void EndSourceFile() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CompilerInstance /*&*/ CI = getCompilerInstance();
      
      // Inform the diagnostic client we are done with this source file.
      CI.getDiagnosticClient().EndSourceFile();
      
      // Inform the preprocessor we are done.
      if (CI.hasPreprocessor()) {
        CI.getPreprocessor().EndSourceFile();
      }
      
      // Finalize the action.
      EndSourceFileAction();
      
      // Sema references the ast consumer, so reset sema first.
      //
      // FIXME: There is more per-file stuff we could just drop here?
      boolean DisableFree = CI.getFrontendOpts().DisableFree;
      if (DisableFree) {
        CI.resetAndLeakSema();
        CI.resetAndLeakASTContext();
        BuryPointer($c$.track(CI.takeASTConsumer()).get()); $c$.clean();
      } else {
        CI.setSema((Sema /*P*/ )null);
        CI.setASTContext((ASTContext /*P*/ )null);
        CI.setASTConsumer($c$.track(new std.unique_ptr<ASTConsumer>(JD$NullPtr.INSTANCE, null))); $c$.clean();
      }
      if (CI.getFrontendOpts().ShowStats) {
        llvm.errs().$out(/*KEEP_STR*/"\nSTATISTICS FOR '").$out(getCurrentFile()).$out(/*KEEP_STR*/"':\n");
        CI.getPreprocessor().PrintStats();
        CI.getPreprocessor().getIdentifierTable().PrintStats();
        CI.getPreprocessor().getHeaderSearchInfo().PrintStats();
        CI.getSourceManager().PrintStats();
        llvm.errs().$out(/*KEEP_STR*/$LF);
      }
      
      // Cleanup the output streams, and erase the output files if instructed by the
      // FrontendAction.
      CI.clearOutputFiles(/*EraseFiles=*/ shouldEraseOutputFiles());
      if (isCurrentFileAST()) {
        if (DisableFree) {
          CI.resetAndLeakPreprocessor();
          CI.resetAndLeakSourceManager();
          CI.resetAndLeakFileManager();
        } else {
          CI.setPreprocessor((Preprocessor /*P*/ )null);
          CI.setSourceManager((SourceManager /*P*/ )null);
          CI.setFileManager((FileManager /*P*/ )null);
        }
      }
      
      setCompilerInstance((CompilerInstance /*P*/ )null);
      setCurrentInput($c$.track(new FrontendInputFile())); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "CurrentInput=" + CurrentInput // NOI18N
              + ", CurrentASTUnit=" + CurrentASTUnit // NOI18N
              + ", Instance=" + Instance; // NOI18N
  }
/// @}
}
