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
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.*;
import org.clang.basic.target.TargetOptions;

//<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 53,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 52,
 FQN="clang::CompilerInvocationBase", NM="_ZN5clang22CompilerInvocationBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBaseE")
//</editor-fold>
public class CompilerInvocationBase extends /*public*/ RefCountedBase<CompilerInvocation> implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 53,
   FQN="clang::CompilerInvocationBase::operator=", NM="_ZN5clang22CompilerInvocationBaseaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBaseaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ CompilerInvocationBase /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  /// Options controlling the language variant.
  public std.shared_ptr<LangOptions> LangOpts;
  
  /// Options controlling the target.
  public std.shared_ptr<TargetOptions> TargetOpts;
  
  /// Options controlling the diagnostic engine.
  public IntrusiveRefCntPtr<DiagnosticOptions> DiagnosticOpts;
  
  /// Options controlling the \#include directive.
  public IntrusiveRefCntPtr<HeaderSearchOptions> HeaderSearchOpts;
  
  /// Options controlling the preprocessor (aside from \#include handling).
  public IntrusiveRefCntPtr<PreprocessorOptions> PreprocessorOpts;
  
  
  //===----------------------------------------------------------------------===//
  // Initialization.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::CompilerInvocationBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 55,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 53,
   FQN="clang::CompilerInvocationBase::CompilerInvocationBase", NM="_ZN5clang22CompilerInvocationBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBaseC1Ev")
  //</editor-fold>
  public CompilerInvocationBase() {
    // : RefCountedBase<CompilerInvocation>(), LangOpts(new LangOptions()), TargetOpts(new TargetOptions()), DiagnosticOpts(new DiagnosticOptions()), HeaderSearchOpts(new HeaderSearchOptions()), PreprocessorOpts(new PreprocessorOptions()) 
    //START JInit
    super();
    this.LangOpts = new std.shared_ptr<LangOptions>(new LangOptions());
    this.TargetOpts = new std.shared_ptr<TargetOptions>(new TargetOptions());
    this.DiagnosticOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions());
    this.HeaderSearchOpts = new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions());
    this.PreprocessorOpts = new IntrusiveRefCntPtr<PreprocessorOptions>(new PreprocessorOptions());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::~CompilerInvocationBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 69,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 67,
   FQN="clang::CompilerInvocationBase::~CompilerInvocationBase", NM="_ZN5clang22CompilerInvocationBaseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBaseD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    PreprocessorOpts.$destroy();
    HeaderSearchOpts.$destroy();
    DiagnosticOpts.$destroy();
    TargetOpts.$destroy();
    LangOpts.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::CompilerInvocationBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 61,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 59,
   FQN="clang::CompilerInvocationBase::CompilerInvocationBase", NM="_ZN5clang22CompilerInvocationBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBaseC1ERKS0_")
  //</editor-fold>
  public CompilerInvocationBase(/*const*/ CompilerInvocationBase /*&*/ X) {
    // : RefCountedBase<CompilerInvocation>(), LangOpts(new LangOptions(*X.getLangOpts())), TargetOpts(new TargetOptions(X.getTargetOpts())), DiagnosticOpts(new DiagnosticOptions(X.getDiagnosticOpts())), HeaderSearchOpts(new HeaderSearchOptions(X.getHeaderSearchOpts())), PreprocessorOpts(new PreprocessorOptions(X.getPreprocessorOpts())) 
    //START JInit
    super();
    this.LangOpts = new std.shared_ptr<LangOptions>(new LangOptions(/*Deref*/X.getLangOpts$Const()));
    this.TargetOpts = new std.shared_ptr<TargetOptions>(new TargetOptions(X.getTargetOpts$Const()));
    this.DiagnosticOpts = new IntrusiveRefCntPtr<DiagnosticOptions>(new DiagnosticOptions(X.getDiagnosticOpts()));
    this.HeaderSearchOpts = new IntrusiveRefCntPtr<HeaderSearchOptions>(new HeaderSearchOptions(X.getHeaderSearchOpts$Const()));
    this.PreprocessorOpts = new IntrusiveRefCntPtr<PreprocessorOptions>(new PreprocessorOptions(X.getPreprocessorOpts$Const()));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 77,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 76,
   FQN="clang::CompilerInvocationBase::getLangOpts", NM="_ZN5clang22CompilerInvocationBase11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBase11getLangOptsEv")
  //</editor-fold>
  public LangOptions /*P*/ getLangOpts() {
    return LangOpts.get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 77,
   FQN="clang::CompilerInvocationBase::getLangOpts", NM="_ZNK5clang22CompilerInvocationBase11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang22CompilerInvocationBase11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*P*/ getLangOpts$Const() /*const*/ {
    return LangOpts.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getTargetOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 79,
   FQN="clang::CompilerInvocationBase::getTargetOpts", NM="_ZN5clang22CompilerInvocationBase13getTargetOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBase13getTargetOptsEv")
  //</editor-fold>
  public TargetOptions /*&*/ getTargetOpts() {
    return /*Deref*/TargetOpts.get();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getTargetOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 80,
   FQN="clang::CompilerInvocationBase::getTargetOpts", NM="_ZNK5clang22CompilerInvocationBase13getTargetOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang22CompilerInvocationBase13getTargetOptsEv")
  //</editor-fold>
  public /*const*/ TargetOptions /*&*/ getTargetOpts$Const() /*const*/ {
    return /*Deref*/TargetOpts.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getDiagnosticOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 85,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 84,
   FQN="clang::CompilerInvocationBase::getDiagnosticOpts", NM="_ZNK5clang22CompilerInvocationBase17getDiagnosticOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang22CompilerInvocationBase17getDiagnosticOptsEv")
  //</editor-fold>
  public DiagnosticOptions /*&*/ getDiagnosticOpts() /*const*/ {
    return DiagnosticOpts.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getHeaderSearchOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 86,
   FQN="clang::CompilerInvocationBase::getHeaderSearchOpts", NM="_ZN5clang22CompilerInvocationBase19getHeaderSearchOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBase19getHeaderSearchOptsEv")
  //</editor-fold>
  public HeaderSearchOptions /*&*/ getHeaderSearchOpts() {
    return HeaderSearchOpts.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getHeaderSearchOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 88,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 87,
   FQN="clang::CompilerInvocationBase::getHeaderSearchOpts", NM="_ZNK5clang22CompilerInvocationBase19getHeaderSearchOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang22CompilerInvocationBase19getHeaderSearchOptsEv")
  //</editor-fold>
  public /*const*/ HeaderSearchOptions /*&*/ getHeaderSearchOpts$Const() /*const*/ {
    return HeaderSearchOpts.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getPreprocessorOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 92,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 91,
   FQN="clang::CompilerInvocationBase::getPreprocessorOpts", NM="_ZN5clang22CompilerInvocationBase19getPreprocessorOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang22CompilerInvocationBase19getPreprocessorOptsEv")
  //</editor-fold>
  public PreprocessorOptions /*&*/ getPreprocessorOpts() {
    return PreprocessorOpts.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CompilerInvocationBase::getPreprocessorOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", line = 93,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/CompilerInvocation.h", old_line = 92,
   FQN="clang::CompilerInvocationBase::getPreprocessorOpts", NM="_ZNK5clang22CompilerInvocationBase19getPreprocessorOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZNK5clang22CompilerInvocationBase19getPreprocessorOptsEv")
  //</editor-fold>
  public /*const*/ PreprocessorOptions /*&*/ getPreprocessorOpts$Const() /*const*/ {
    return PreprocessorOpts.$star();
  }

  
  @Override public String toString() {
    return "" + "LangOpts=" + LangOpts // NOI18N
              + ", TargetOpts=" + TargetOpts // NOI18N
              + ", DiagnosticOpts=" + DiagnosticOpts // NOI18N
              + ", HeaderSearchOpts=" + HeaderSearchOpts // NOI18N
              + ", PreprocessorOpts=" + PreprocessorOpts // NOI18N
              + super.toString(); // NOI18N
  }
}
