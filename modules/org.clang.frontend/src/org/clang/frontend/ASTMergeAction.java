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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.frontend.*;


/**
* \brief Frontend action adaptor that merges ASTs together.
*
* This action takes an existing AST file and "merges" it into the AST
* context, producing a merged context. This action is an action
* adaptor, which forwards most of its calls to another action that
* will consume the merged context.
*/
//<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 169,
 FQN="clang::ASTMergeAction", NM="_ZN5clang14ASTMergeActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZN5clang14ASTMergeActionE")
//</editor-fold>
public class ASTMergeAction extends /*public*/ FrontendAction implements Destructors.ClassWithDestructor {
  /// \brief The action that the merge action adapts.
  private std.unique_ptr<FrontendAction> AdaptedAction;
  
  /// \brief The set of AST files to merge.
  private std.vectorString ASTFiles;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 19,
   FQN="clang::ASTMergeAction::CreateASTConsumer", NM="_ZN5clang14ASTMergeAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZN5clang14ASTMergeAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, StringRef InFile)/* override*/ {
    return AdaptedAction.$arrow().CreateASTConsumer(CI, new StringRef(InFile));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::BeginSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 24,
   FQN="clang::ASTMergeAction::BeginSourceFileAction", NM="_ZN5clang14ASTMergeAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZN5clang14ASTMergeAction21BeginSourceFileActionERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected boolean BeginSourceFileAction(CompilerInstance /*&*/ CI, 
                       StringRef Filename)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // FIXME: This is a hack. We need a better way to communicate the
      // AST file, compiler instance, and file name than member variables
      // of FrontendAction.
      AdaptedAction.$arrow().setCurrentInput(getCurrentInput(), $c$.track(takeCurrentASTUnit())); $c$.clean();
      AdaptedAction.$arrow().setCompilerInstance(/*AddrOf*/CI);
      return AdaptedAction.$arrow().BeginSourceFileAction(CI, new StringRef(Filename));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::ExecuteAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 34,
   FQN="clang::ASTMergeAction::ExecuteAction", NM="_ZN5clang14ASTMergeAction13ExecuteActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZN5clang14ASTMergeAction13ExecuteActionEv")
  //</editor-fold>
  @Override protected void ExecuteAction()/* override*/ {
    IntrusiveRefCntPtr<DiagnosticIDs> DiagIDs = null;
    try {
      CompilerInstance /*&*/ CI = getCompilerInstance();
      CI.getDiagnostics().getClient().BeginSourceFile(CI.getASTContext().getLangOpts());
      CI.getDiagnostics().SetArgToStringFn(/*AddrOf*/AstClangGlobals::FormatASTNodeDiagnosticArgument, 
          /*AddrOf*/CI.getASTContext());
      DiagIDs/*J*/= new IntrusiveRefCntPtr<DiagnosticIDs>(CI.getDiagnostics().getDiagnosticIDs());
      for (/*uint*/int I = 0, N = ASTFiles.size(); I != N; ++I) {
        IntrusiveRefCntPtr<DiagnosticsEngine> Diags = null;
        std.unique_ptr<ASTUnit> Unit = null;
        ASTImporter Importer = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Diags/*J*/= new IntrusiveRefCntPtr<DiagnosticsEngine>(new DiagnosticsEngine(DiagIDs, /*AddrOf*/CI.getDiagnosticOpts(), 
                  new ForwardingDiagnosticConsumer(/*Deref*/CI.getDiagnostics().getClient()), 
                  /*ShouldOwnClient=*/ true));
          Unit = $c$.clean(ASTUnit.LoadFromASTFile(ASTFiles.$at(I), CI.getPCHContainerReader(), 
              $c$.track(new IntrusiveRefCntPtr<DiagnosticsEngine>(Diags)), CI.getFileSystemOpts(), false));
          if (!Unit.$bool()) {
            continue;
          }
          
          Importer/*J*/= new ASTImporter(CI.getASTContext(), 
              CI.getFileManager(), 
              Unit.$arrow().getASTContext(), 
              Unit.$arrow().getFileManager(), 
              /*MinimalImport=*/ false);
          
          TranslationUnitDecl /*P*/ TU = Unit.$arrow().getASTContext().getTranslationUnitDecl();
          for (Decl /*P*/ D : TU.decls()) {
            {
              // Don't re-import __va_list_tag, __builtin_va_list.
              /*const*/ NamedDecl /*P*/ ND = dyn_cast(NamedDecl.class, D);
              if ((ND != null)) {
                {
                  IdentifierInfo /*P*/ II = ND.getIdentifier();
                  if ((II != null)) {
                    if (II.isStr(/*KEEP_STR*/"__va_list_tag") || II.isStr(/*KEEP_STR*/"__builtin_va_list")) {
                      continue;
                    }
                  }
                }
              }
            }
            
            Decl /*P*/ ToD = Importer.Import(D);
            if ((ToD != null)) {
              DeclGroupRef DGR/*J*/= new DeclGroupRef(ToD);
              CI.getASTConsumer().HandleTopLevelDecl(new DeclGroupRef(DGR));
            }
          }
        } finally {
          if (Importer != null) { Importer.$destroy(); }
          if (Unit != null) { Unit.$destroy(); }
          if (Diags != null) { Diags.$destroy(); }
          $c$.$destroy();
        }
      }
      
      AdaptedAction.$arrow().ExecuteAction();
      CI.getDiagnostics().getClient().EndSourceFile();
    } finally {
      if (DiagIDs != null) { DiagIDs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::EndSourceFileAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 82,
   FQN="clang::ASTMergeAction::EndSourceFileAction", NM="_ZN5clang14ASTMergeAction19EndSourceFileActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZN5clang14ASTMergeAction19EndSourceFileActionEv")
  //</editor-fold>
  @Override protected void EndSourceFileAction()/* override*/ {
    AdaptedAction.$arrow().EndSourceFileAction();
    return;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::ASTMergeAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 86,
   FQN="clang::ASTMergeAction::ASTMergeAction", NM="_ZN5clang14ASTMergeActionC1ESt10unique_ptrINS_14FrontendActionESt14default_deleteIS2_EEN4llvm8ArrayRefISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZN5clang14ASTMergeActionC1ESt10unique_ptrINS_14FrontendActionESt14default_deleteIS2_EEN4llvm8ArrayRefISsEE")
  //</editor-fold>
  public ASTMergeAction(std.unique_ptr<FrontendAction> adaptedAction, 
      ArrayRef<std.string> ASTFiles) {
    // : FrontendAction(), AdaptedAction(std::move(adaptedAction)), ASTFiles(ASTFiles.begin(), ASTFiles.end()) 
    //START JInit
    super();
    this.AdaptedAction = new std.unique_ptr<FrontendAction>(JD$Move.INSTANCE, std.move(adaptedAction));
    this.ASTFiles = new std.vectorString(ASTFiles.begin(), ASTFiles.end(), std.string.EMPTY);
    //END JInit
    assert (AdaptedAction.$bool()) : "ASTMergeAction needs an action to adapt";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::~ASTMergeAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 92,
   FQN="clang::ASTMergeAction::~ASTMergeAction", NM="_ZN5clang14ASTMergeActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZN5clang14ASTMergeActionD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    ASTFiles.$destroy();
    AdaptedAction.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::usesPreprocessorOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 95,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", old_line = 96,
   FQN="clang::ASTMergeAction::usesPreprocessorOnly", NM="_ZNK5clang14ASTMergeAction20usesPreprocessorOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZNK5clang14ASTMergeAction20usesPreprocessorOnlyEv")
  //</editor-fold>
  @Override public boolean usesPreprocessorOnly() /*const*//* override*/ {
    return AdaptedAction.$arrow().usesPreprocessorOnly();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::getTranslationUnitKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 99,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", old_line = 100,
   FQN="clang::ASTMergeAction::getTranslationUnitKind", NM="_ZN5clang14ASTMergeAction22getTranslationUnitKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZN5clang14ASTMergeAction22getTranslationUnitKindEv")
  //</editor-fold>
  @Override public TranslationUnitKind getTranslationUnitKind()/* override*/ {
    return AdaptedAction.$arrow().getTranslationUnitKind();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::hasPCHSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", old_line = 104,
   FQN="clang::ASTMergeAction::hasPCHSupport", NM="_ZNK5clang14ASTMergeAction13hasPCHSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZNK5clang14ASTMergeAction13hasPCHSupportEv")
  //</editor-fold>
  @Override public boolean hasPCHSupport() /*const*//* override*/ {
    return AdaptedAction.$arrow().hasPCHSupport();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::hasASTFileSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 107,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", old_line = 108,
   FQN="clang::ASTMergeAction::hasASTFileSupport", NM="_ZNK5clang14ASTMergeAction17hasASTFileSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZNK5clang14ASTMergeAction17hasASTFileSupportEv")
  //</editor-fold>
  @Override public boolean hasASTFileSupport() /*const*//* override*/ {
    return AdaptedAction.$arrow().hasASTFileSupport();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTMergeAction::hasCodeCompletionSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", line = 111,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp", old_line = 112,
   FQN="clang::ASTMergeAction::hasCodeCompletionSupport", NM="_ZNK5clang14ASTMergeAction24hasCodeCompletionSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTMerge.cpp -nm=_ZNK5clang14ASTMergeAction24hasCodeCompletionSupportEv")
  //</editor-fold>
  @Override public boolean hasCodeCompletionSupport() /*const*//* override*/ {
    return AdaptedAction.$arrow().hasCodeCompletionSupport();
  }

  
  @Override public String toString() {
    return "" + "AdaptedAction=" + AdaptedAction // NOI18N
              + ", ASTFiles=" + ASTFiles // NOI18N
              + super.toString(); // NOI18N
  }
}
