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
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;


/// Builds a depdenency file when attached to a Preprocessor (for includes) and
/// ASTReader (for module imports), and writes it out at the end of processing
/// a source file.  Users should attach to the ast reader whenever a module is
/// loaded.
//<editor-fold defaultstate="collapsed" desc="clang::DependencyFileGenerator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 111,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 110,
 FQN="clang::DependencyFileGenerator", NM="_ZN5clang23DependencyFileGeneratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang23DependencyFileGeneratorE")
//</editor-fold>
public class DependencyFileGenerator {
  private Object/*void P*/ Impl; // Opaque implementation
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyFileGenerator::DependencyFileGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 230,
   FQN="clang::DependencyFileGenerator::DependencyFileGenerator", NM="_ZN5clang23DependencyFileGeneratorC1EPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang23DependencyFileGeneratorC1EPv")
  //</editor-fold>
  private DependencyFileGenerator(Object/*void P*/ Impl) {
    // : Impl(Impl) 
    //START JInit
    this.Impl = Impl;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependencyFileGenerator::CreateAndAttachToPreprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 233,
   FQN="clang::DependencyFileGenerator::CreateAndAttachToPreprocessor", NM="_ZN5clang23DependencyFileGenerator29CreateAndAttachToPreprocessorERNS_12PreprocessorERKNS_23DependencyOutputOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang23DependencyFileGenerator29CreateAndAttachToPreprocessorERNS_12PreprocessorERKNS_23DependencyOutputOptionsE")
  //</editor-fold>
  public static DependencyFileGenerator /*P*/ CreateAndAttachToPreprocessor(Preprocessor /*&*/ PP, /*const*/ DependencyOutputOptions /*&*/ Opts) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (Opts.Targets.empty()) {
        $c$.clean($c$.track(PP.getDiagnostics().Report(diag.err_fe_dependency_file_requires_MT)));
        return null;
      }
      
      // Disable the "file not found" diagnostic if the -MG option was given.
      if (Opts.AddMissingHeaderDeps) {
        PP.SetSuppressIncludeNotFoundError(true);
      }
      
      DFGImpl /*P*/ Callback = new DFGImpl(/*AddrOf*/PP, Opts);
      PP.addPPCallbacks($c$.track(new std.unique_ptr<PPCallbacks>(Callback))); $c$.clean();
      PP.getHeaderSearchInfo().getModuleMap().addModuleMapCallbacks($c$.track(new std.unique_ptr<ModuleMapCallbacks>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DFGMMCallback(/*Deref*/Callback)))))); $c$.clean();
      return new DependencyFileGenerator(Callback);
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependencyFileGenerator::AttachToASTReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp", line = 252,
   FQN="clang::DependencyFileGenerator::AttachToASTReader", NM="_ZN5clang23DependencyFileGenerator17AttachToASTReaderERNS_9ASTReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyFile.cpp -nm=_ZN5clang23DependencyFileGenerator17AttachToASTReaderERNS_9ASTReaderE")
  //</editor-fold>
  public void AttachToASTReader(ASTReader /*&*/ R) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DFGImpl /*P*/ I = reinterpret_cast(DFGImpl /*P*/ .class, Impl);
      assert ((I != null)) : "missing implementation";
      R.addListener($c$.track(new std.unique_ptr<ASTReaderListener>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DFGASTReaderListener(/*Deref*/I)))))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "Impl=" + Impl; // NOI18N
  }
}
