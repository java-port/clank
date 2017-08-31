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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 899,
 FQN="(anonymous namespace)::PrecompilePreambleAction", NM="_ZN12_GLOBAL__N_124PrecompilePreambleActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124PrecompilePreambleActionE")
//</editor-fold>
public class PrecompilePreambleAction extends /*public*/ ASTFrontendAction implements Destructors.ClassWithDestructor {
  private ASTUnit /*&*/ Unit;
  private boolean HasEmittedPreamblePCH;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::PrecompilePreambleAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 904,
   FQN="(anonymous namespace)::PrecompilePreambleAction::PrecompilePreambleAction", NM="_ZN12_GLOBAL__N_124PrecompilePreambleActionC1ERN5clang7ASTUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124PrecompilePreambleActionC1ERN5clang7ASTUnitE")
  //</editor-fold>
  public /*explicit*/ PrecompilePreambleAction(ASTUnit /*&*/ Unit) {
    // : ASTFrontendAction(), Unit(Unit), HasEmittedPreamblePCH(false) 
    //START JInit
    super();
    this./*&*/Unit=/*&*/Unit;
    this.HasEmittedPreamblePCH = false;
    //END JInit
  }

  
  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::CreateASTConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 980,
   FQN="(anonymous namespace)::PrecompilePreambleAction::CreateASTConsumer", NM="_ZN12_GLOBAL__N_124PrecompilePreambleAction17CreateASTConsumerERN5clang16CompilerInstanceEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124PrecompilePreambleAction17CreateASTConsumerERN5clang16CompilerInstanceEN4llvm9StringRefE")
  //</editor-fold>
  @Override public std.unique_ptr<ASTConsumer> CreateASTConsumer(CompilerInstance /*&*/ CI, 
                   StringRef InFile)/* override*/ {
    std.unique_ptr<raw_ostream> OS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string Sysroot/*J*/= new std.string();
      std.string OutputFile/*J*/= new std.string();
      OS = $c$.clean(new std.unique_ptr<raw_ostream>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(GeneratePCHAction.ComputeASTConsumerArguments(CI, new StringRef(InFile), Sysroot, 
              OutputFile))));
      if (!OS.$bool()) {
        return new std.unique_ptr<ASTConsumer>(JD$NullPtr.INSTANCE, null);
      }
      if (!CI.getFrontendOpts().RelocatablePCH) {
        Sysroot.clear();
      }
      
      CI.getPreprocessor().addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new MacroDefinitionTrackerPPCallbacks(Unit.getCurrentTopLevelHashValue())))))); $c$.clean();
      return $c$.clean(new std.unique_ptr<ASTConsumer>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new PrecompilePreambleConsumer(Unit, this, CI.getPreprocessor(), new StringRef(Sysroot), std.move(OS))))));
    } finally {
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::hasEmittedPreamblePCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 909,
   FQN="(anonymous namespace)::PrecompilePreambleAction::hasEmittedPreamblePCH", NM="_ZNK12_GLOBAL__N_124PrecompilePreambleAction21hasEmittedPreamblePCHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK12_GLOBAL__N_124PrecompilePreambleAction21hasEmittedPreamblePCHEv")
  //</editor-fold>
  public boolean hasEmittedPreamblePCH() /*const*/ {
    return HasEmittedPreamblePCH;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::setHasEmittedPreamblePCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 910,
   FQN="(anonymous namespace)::PrecompilePreambleAction::setHasEmittedPreamblePCH", NM="_ZN12_GLOBAL__N_124PrecompilePreambleAction24setHasEmittedPreamblePCHEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124PrecompilePreambleAction24setHasEmittedPreamblePCHEv")
  //</editor-fold>
  public void setHasEmittedPreamblePCH() {
    HasEmittedPreamblePCH = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::shouldEraseOutputFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 911,
   FQN="(anonymous namespace)::PrecompilePreambleAction::shouldEraseOutputFiles", NM="_ZN12_GLOBAL__N_124PrecompilePreambleAction22shouldEraseOutputFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124PrecompilePreambleAction22shouldEraseOutputFilesEv")
  //</editor-fold>
  @Override public boolean shouldEraseOutputFiles()/* override*/ {
    return !hasEmittedPreamblePCH();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::hasCodeCompletionSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 913,
   FQN="(anonymous namespace)::PrecompilePreambleAction::hasCodeCompletionSupport", NM="_ZNK12_GLOBAL__N_124PrecompilePreambleAction24hasCodeCompletionSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK12_GLOBAL__N_124PrecompilePreambleAction24hasCodeCompletionSupportEv")
  //</editor-fold>
  @Override public boolean hasCodeCompletionSupport() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::hasASTFileSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 914,
   FQN="(anonymous namespace)::PrecompilePreambleAction::hasASTFileSupport", NM="_ZNK12_GLOBAL__N_124PrecompilePreambleAction17hasASTFileSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK12_GLOBAL__N_124PrecompilePreambleAction17hasASTFileSupportEv")
  //</editor-fold>
  @Override public boolean hasASTFileSupport() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::getTranslationUnitKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 915,
   FQN="(anonymous namespace)::PrecompilePreambleAction::getTranslationUnitKind", NM="_ZN12_GLOBAL__N_124PrecompilePreambleAction22getTranslationUnitKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124PrecompilePreambleAction22getTranslationUnitKindEv")
  //</editor-fold>
  @Override public TranslationUnitKind getTranslationUnitKind()/* override*/ {
    return TranslationUnitKind.TU_Prefix;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleAction::~PrecompilePreambleAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 899,
   FQN="(anonymous namespace)::PrecompilePreambleAction::~PrecompilePreambleAction", NM="_ZN12_GLOBAL__N_124PrecompilePreambleActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124PrecompilePreambleActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Unit=" + Unit // NOI18N
              + ", HasEmittedPreamblePCH=" + HasEmittedPreamblePCH // NOI18N
              + super.toString(); // NOI18N
  }
}
