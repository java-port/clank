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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import org.clang.frontend.*;

//<editor-fold defaultstate="collapsed" desc="clang::GeneratePCHAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 72,
 FQN="clang::GeneratePCHAction", NM="_ZN5clang17GeneratePCHActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang17GeneratePCHActionE")
//</editor-fold>
public class GeneratePCHAction extends /*public*/ ASTFrontendAction implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GeneratePCHAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 79,
   FQN="clang::GeneratePCHAction::CreateASTConsumer", NM="_ZN5clang17GeneratePCHAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang17GeneratePCHAction17CreateASTConsumerERNS_16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override protected std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, StringRef InFile)/* override*/ {
    std.unique_ptr<raw_pwrite_stream> OS = null;
    shared_ptr<PCHBuffer> Buffer = null;
    std.vector<std.unique_ptr<ASTConsumer>> Consumers = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string Sysroot/*J*/= new std.string();
      std.string OutputFile/*J*/= new std.string();
      OS = ComputeASTConsumerArguments(CI, new StringRef(InFile), Sysroot, OutputFile);
      if (!OS.$bool()) {
        return new std.unique_ptr<ASTConsumer>(JD$NullPtr.INSTANCE, null);
      }
      if (!CI.getFrontendOpts().RelocatablePCH) {
        Sysroot.clear();
      }
      
      Buffer = std.make_shared(new PCHBuffer());
      Consumers/*J*/= new std.vector<std.unique_ptr<ASTConsumer>>(new std.unique_ptr<ASTConsumer>());
      Consumers.push_back_T$RR($c$.track(new unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new PCHGenerator(CI.getPreprocessor(), new StringRef(OutputFile), null, new StringRef(Sysroot), 
                  Buffer, new ArrayRef(CI.getFrontendOpts().ModuleFileExtensions), 
                  /*AllowASTWithErrors*/ false, 
                  /*IncludeTimestamps*/
                  /*+*/CI.getFrontendOpts().IncludeTimestamps)))))); $c$.clean();
      Consumers.push_back_T$RR($c$.track(CI.getPCHContainerWriter().CreatePCHContainerGenerator(CI, InFile.$string(), OutputFile, $c$.track(new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, std.move(OS))), $c$.track(new std.shared_ptr<PCHBuffer>(Buffer))))); $c$.clean();
      
      return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MultiplexConsumer(std.move(Consumers))))));
    } finally {
      if (Consumers != null) { Consumers.$destroy(); }
      if (Buffer != null) { Buffer.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::GeneratePCHAction::getTranslationUnitKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 77,
   FQN="clang::GeneratePCHAction::getTranslationUnitKind", NM="_ZN5clang17GeneratePCHAction22getTranslationUnitKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang17GeneratePCHAction22getTranslationUnitKindEv")
  //</editor-fold>
  @Override public/*protected*/ TranslationUnitKind getTranslationUnitKind()/* override*/ {
    return TranslationUnitKind.TU_Prefix;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GeneratePCHAction::hasASTFileSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 81,
   FQN="clang::GeneratePCHAction::hasASTFileSupport", NM="_ZNK5clang17GeneratePCHAction17hasASTFileSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZNK5clang17GeneratePCHAction17hasASTFileSupportEv")
  //</editor-fold>
  @Override public/*protected*/ boolean hasASTFileSupport() /*const*//* override*/ {
    return false;
  }

/*public:*/
  /// \brief Compute the AST consumer arguments that will be used to
  /// create the PCHGenerator instance returned by CreateASTConsumer.
  ///
  /// \returns true if an error occurred, false otherwise.
  /// \brief Compute the AST consumer arguments that will be used to
  /// create the PCHGenerator instance returned by CreateASTConsumer.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::GeneratePCHAction::ComputeASTConsumerArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 106,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 102,
   FQN="clang::GeneratePCHAction::ComputeASTConsumerArguments", NM="_ZN5clang17GeneratePCHAction27ComputeASTConsumerArgumentsERNS_16CompilerInstanceEN4llvm9StringRefERSsS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang17GeneratePCHAction27ComputeASTConsumerArgumentsERNS_16CompilerInstanceEN4llvm9StringRefERSsS5_")
  //</editor-fold>
  public static std.unique_ptr<raw_pwrite_stream> ComputeASTConsumerArguments(CompilerInstance /*&*/ CI, 
                             StringRef InFile, 
                             std.string/*&*/ Sysroot, 
                             std.string/*&*/ OutputFile) {
    std.unique_ptr<raw_pwrite_stream> OS = null;
    try {
      Sysroot.$assign(CI.getHeaderSearchOpts().Sysroot);
      if (CI.getFrontendOpts().RelocatablePCH && Sysroot.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(CI.getDiagnostics().Report(diag.err_relocatable_without_isysroot)));
          return new std.unique_ptr<raw_pwrite_stream>(JD$NullPtr.INSTANCE, null);
        } finally {
          $c$.$destroy();
        }
      }
      
      // We use createOutputFile here because this is exposed via libclang, and we
      // must disable the RemoveFileOnSignal behavior.
      // We use a temporary to avoid race conditions.
      OS = CI.createOutputFile(new StringRef(CI.getFrontendOpts().OutputFile), /*Binary=*/ true, 
          /*RemoveFileOnSignal=*/ false, new StringRef(InFile), 
          /*Extension=*/ new StringRef(/*KEEP_STR*/$EMPTY), /*useTemporary=*/ true);
      if (!OS.$bool()) {
        return new std.unique_ptr<raw_pwrite_stream>(JD$NullPtr.INSTANCE, null);
      }
      
      OutputFile.$assign(CI.getFrontendOpts().OutputFile);
      return new std.unique_ptr<raw_pwrite_stream>(JD$Move.INSTANCE, OS);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::GeneratePCHAction::~GeneratePCHAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 72,
   FQN="clang::GeneratePCHAction::~GeneratePCHAction", NM="_ZN5clang17GeneratePCHActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang17GeneratePCHActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GeneratePCHAction::GeneratePCHAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 72,
   FQN="clang::GeneratePCHAction::GeneratePCHAction", NM="_ZN5clang17GeneratePCHActionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang17GeneratePCHActionC1Ev")
  //</editor-fold>
  public /*inline*/ GeneratePCHAction() {
    // : ASTFrontendAction() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
