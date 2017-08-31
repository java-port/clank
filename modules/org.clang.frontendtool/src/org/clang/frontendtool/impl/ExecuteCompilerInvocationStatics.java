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
package org.clang.frontendtool.impl;

import org.clang.frontend.llvm.FrontendPluginRegistry;
import org.clang.arcmigrate.*;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.codegen.*;
import org.clang.frontend.*;
import org.clang.rewrite.frontend.*;
import org.clang.staticanalyzer.frontend.ento.AnalysisAction;


//<editor-fold defaultstate="collapsed" desc="static type ExecuteCompilerInvocationStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontendtool/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZL20CreateFrontendActionRN5clang16CompilerInstanceE;_ZL24CreateFrontendBaseActionRN5clang16CompilerInstanceE; -static-type=ExecuteCompilerInvocationStatics -package=org.clang.frontendtool.impl")
//</editor-fold>
public final class ExecuteCompilerInvocationStatics {

//<editor-fold defaultstate="collapsed" desc="CreateFrontendBaseAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp", line = 34,
 FQN="CreateFrontendBaseAction", NM="_ZL24CreateFrontendBaseActionRN5clang16CompilerInstanceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontendtool/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZL24CreateFrontendBaseActionRN5clang16CompilerInstanceE")
//</editor-fold>
public static std.unique_ptr<FrontendAction> CreateFrontendBaseAction(CompilerInstance /*&*/ CI) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //JAVA: using namespace clang::frontend;
    StringRef Action/*J*/= new StringRef(/*KEEP_STR*/$unknown);
    //(void)Action;
    switch (CI.getFrontendOpts().ProgramAction) {
     case ASTDeclList:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new ASTDeclListAction()))));
     case ASTDump:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new ASTDumpAction()))));
     case ASTPrint:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new ASTPrintAction()))));
     case ASTView:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new ASTViewAction()))));
     case DumpRawTokens:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new DumpRawTokensAction()))));
     case DumpTokens:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new DumpTokensAction()))));
     case EmitAssembly:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new EmitAssemblyAction()))));
     case EmitBC:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new EmitBCAction()))));
     case EmitHTML:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new HTMLPrintAction()))));
     case EmitLLVM:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new EmitLLVMAction()))));
     case EmitLLVMOnly:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new EmitLLVMOnlyAction()))));
     case EmitCodeGenOnly:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new EmitCodeGenOnlyAction()))));
     case EmitObj:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new EmitObjAction()))));
     case FixIt:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new FixItAction()))));
     case GenerateModule:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new GenerateModuleAction()))));
     case GeneratePCH:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new GeneratePCHAction()))));
     case GeneratePTH:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new GeneratePTHAction()))));
     case InitOnly:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new InitOnlyAction()))));
     case ParseSyntaxOnly:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new SyntaxOnlyAction()))));
     case ModuleFileInfo:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new DumpModuleInfoAction()))));
     case VerifyPCH:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new VerifyPCHAction()))));
     case PluginAction:
      {
        for (FrontendPluginRegistry.iterator<PluginASTAction> it = FrontendPluginRegistry.begin(), ie = FrontendPluginRegistry.end();
             it.$noteq(ie); it.$preInc()) {
          if ($eq_T_string$C(it.$arrow().getName(), CI.getFrontendOpts().ActionName)) {
            std.unique_ptr<PluginASTAction> P = null;
            try {
              P/*J*/= it.$arrow().instantiate();
              if ((P.$arrow().getActionType() != PluginASTAction.ActionType.ReplaceAction
                 && P.$arrow().getActionType() != PluginASTAction.ActionType.Cmdline)
                 || !P.$arrow().ParseArgs(CI, CI.getFrontendOpts().PluginArgs.$at(new std.string(it.$arrow().getName())))) {
                return new std.unique_ptr<FrontendAction>(JD$NullPtr.INSTANCE, null);
              }
              return new std.unique_ptr<FrontendAction>(std.move(P));
            } finally {
              if (P != null) { P.$destroy(); }
            }
          }
        }
        
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_fe_invalid_plugin_name)), 
            new StringRef(CI.getFrontendOpts().ActionName)));
        return new std.unique_ptr<FrontendAction>(JD$NullPtr.INSTANCE, null);
      }
     case PrintDeclContext:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new DeclContextPrintAction()))));
     case PrintPreamble:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new PrintPreambleAction()))));
     case PrintPreprocessedInput:
      {
        if (CI.getPreprocessorOutputOpts().RewriteIncludes) {
          return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new RewriteIncludesAction()))));
        }
        return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new PrintPreprocessedAction()))));
      }
     case RewriteMacros:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new RewriteMacrosAction()))));
     case RewriteTest:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new RewriteTestAction()))));
     case RewriteObjC:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new RewriteObjCAction()))));
     case MigrateSource:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new MigrateSourceAction()))));
     case RunAnalysis:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new AnalysisAction()))));
     case RunPreprocessorOnly:
      return $c$.clean(new std.unique_ptr<FrontendAction>($c$.track(llvm.make_unique(new PreprocessOnlyAction()))));
    }
    $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(CI.getDiagnostics().Report(diag.err_fe_action_not_available)), /*NO_COPY*/Action));
    return new std.unique_ptr<FrontendAction>(JD$NullPtr.INSTANCE, (/*nullptr_t*/Object)null);
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="CreateFrontendAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp", line = 120,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp", old_line = 116,
 FQN="CreateFrontendAction", NM="_ZL20CreateFrontendActionRN5clang16CompilerInstanceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontendtool/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZL20CreateFrontendActionRN5clang16CompilerInstanceE")
//</editor-fold>
public static std.unique_ptr<FrontendAction> CreateFrontendAction(CompilerInstance /*&*/ CI) {
  std.unique_ptr<FrontendAction> Act = null;
  try {
    // Create the underlying action.
    Act = CreateFrontendBaseAction(CI);
    if (!Act.$bool()) {
      return new std.unique_ptr<FrontendAction>(JD$NullPtr.INSTANCE, null);
    }
    
    /*const*/ FrontendOptions /*&*/ FEOpts = CI.getFrontendOpts();
    if (FEOpts.FixAndRecompile) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Act.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new FixItRecompile(std.move(Act))))));
      } finally {
        $c$.$destroy();
      }
    }
    if (CI.getFrontendOpts().ProgramAction != frontend.ActionKind.MigrateSource
       && CI.getFrontendOpts().ProgramAction != frontend.ActionKind.GeneratePCH) {
      // Potentially wrap the base FE action in an ARC Migrate Tool action.
      switch (FEOpts.ARCMTAction) {
       case ARCMT_None:
        break;
       case ARCMT_Check:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(Act.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new CheckAction(std.move(Act))))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case ARCMT_Modify:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(Act.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new ModifyAction(std.move(Act))))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case ARCMT_Migrate:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(Act.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new MigrateAction(std.move(Act), 
                    FEOpts.MTMigrateDir, 
                    FEOpts.ARCMTMigrateReportOut, 
                    FEOpts.ARCMTMigrateEmitARCErrors)))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (FEOpts.ObjCMTAction != FrontendOptions.ObjCMT_None) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Act.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new ObjCMigrateAction(std.move(Act), 
                  FEOpts.MTMigrateDir, 
                  FEOpts.ObjCMTAction)))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // If there are any AST files to merge, create a frontend action
    // adaptor to perform the merge.
    if (!FEOpts.ASTMergeFiles.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Act.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new ASTMergeAction(std.move(Act), 
                new ArrayRef(FEOpts.ASTMergeFiles))))));
      } finally {
        $c$.$destroy();
      }
    }
    
    return new std.unique_ptr<FrontendAction>(JD$Move.INSTANCE, Act);
  } finally {
    if (Act != null) { Act.$destroy(); }
  }
}

} // END OF class ExecuteCompilerInvocationStatics
