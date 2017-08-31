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

package org.clang.tooling;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.rewrite.core.*;
import org.clang.frontend.*;
import org.clang.tooling.core.*;
import org.clang.tooling.*;


/// \brief A tool to run refactorings.
///
/// This is a refactoring specific version of \see ClangTool. FrontendActions
/// passed to run() and runAndSave() should add replacements to
/// getReplacements().
//<editor-fold defaultstate="collapsed" desc="clang::tooling::RefactoringTool">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Refactoring.h", line = 37,
 FQN="clang::tooling::RefactoringTool", NM="_ZN5clang7tooling15RefactoringToolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling15RefactoringToolE")
//</editor-fold>
public class RefactoringTool extends /*public*/ ClangTool implements Destructors.ClassWithDestructor {
/*public:*/
  /// \see ClangTool::ClangTool.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::RefactoringTool::RefactoringTool">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp", line = 29,
   FQN="clang::tooling::RefactoringTool::RefactoringTool", NM="_ZN5clang7tooling15RefactoringToolC1ERKNS0_19CompilationDatabaseEN4llvm8ArrayRefISsEESt10shared_ptrINS_22PCHContainerOperationsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling15RefactoringToolC1ERKNS0_19CompilationDatabaseEN4llvm8ArrayRefISsEESt10shared_ptrINS_22PCHContainerOperationsEE")
  //</editor-fold>
  public RefactoringTool(final /*const*/ CompilationDatabase /*&*/ Compilations, ArrayRef<std.string> SourcePaths) {
    this(Compilations, SourcePaths, 
      std.make_shared(new PCHContainerOperations()));
  }
  public RefactoringTool(final /*const*/ CompilationDatabase /*&*/ Compilations, ArrayRef<std.string> SourcePaths, 
      std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
    // : ClangTool(Compilations, SourcePaths, PCHContainerOps), Replace() 
    /*ExprWithCleanups*/super(Compilations, new ArrayRef<std.string>(SourcePaths), new std.shared_ptr<PCHContainerOperations>(PCHContainerOps));
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the set of replacements to which replacements should
  /// be added during the run of the tool.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::RefactoringTool::getReplacements">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp", line = 34,
   FQN="clang::tooling::RefactoringTool::getReplacements", NM="_ZN5clang7tooling15RefactoringTool15getReplacementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling15RefactoringTool15getReplacementsEv")
  //</editor-fold>
  public std.setType<Replacement> /*&*/ getReplacements() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Call run(), apply all generated replacements, and immediately save
  /// the results to disk.
  ///
  /// \returns 0 upon success. Non-zero upon failure.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::RefactoringTool::runAndSave">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp", line = 36,
   FQN="clang::tooling::RefactoringTool::runAndSave", NM="_ZN5clang7tooling15RefactoringTool10runAndSaveEPNS0_21FrontendActionFactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling15RefactoringTool10runAndSaveEPNS0_21FrontendActionFactoryE")
  //</editor-fold>
  public int runAndSave(FrontendActionFactory /*P*/ ActionFactory) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Apply all stored replacements to the given Rewriter.
  ///
  /// Replacement applications happen independently of the success of other
  /// applications.
  ///
  /// \returns true if all replacements apply. false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::RefactoringTool::applyAllReplacements">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp", line = 57,
   FQN="clang::tooling::RefactoringTool::applyAllReplacements", NM="_ZN5clang7tooling15RefactoringTool20applyAllReplacementsERNS_8RewriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling15RefactoringTool20applyAllReplacementsERNS_8RewriterE")
  //</editor-fold>
  public boolean applyAllReplacements(final Rewriter /*&*/ Rewrite) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// \brief Write all refactored files to disk.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::RefactoringTool::saveRewrittenFiles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp", line = 61,
   FQN="clang::tooling::RefactoringTool::saveRewrittenFiles", NM="_ZN5clang7tooling15RefactoringTool18saveRewrittenFilesERNS_8RewriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling15RefactoringTool18saveRewrittenFilesERNS_8RewriterE")
  //</editor-fold>
  private int saveRewrittenFiles(final Rewriter /*&*/ Rewrite) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private std.setType<Replacement> Replace;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::RefactoringTool::~RefactoringTool">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Refactoring.h", line = 37,
   FQN="clang::tooling::RefactoringTool::~RefactoringTool", NM="_ZN5clang7tooling15RefactoringToolD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Refactoring.cpp -nm=_ZN5clang7tooling15RefactoringToolD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "Replace=" + Replace // NOI18N
              + super.toString(); // NOI18N
  }
}
