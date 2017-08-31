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

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.spi.PreprocessorImplementation;
import org.clang.lex.*;


/// \brief Diagnostic consumer that saves each diagnostic it is given.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StoredDiagnosticConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 562,
 FQN="(anonymous namespace)::StoredDiagnosticConsumer", NM="_ZN12_GLOBAL__N_124StoredDiagnosticConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124StoredDiagnosticConsumerE")
//</editor-fold>
public class StoredDiagnosticConsumer extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
  private SmallVectorImpl<StoredDiagnostic> /*&*/ StoredDiags;
  private SourceManager /*P*/ SourceMgr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StoredDiagnosticConsumer::StoredDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 567,
   FQN="(anonymous namespace)::StoredDiagnosticConsumer::StoredDiagnosticConsumer", NM="_ZN12_GLOBAL__N_124StoredDiagnosticConsumerC1ERN4llvm15SmallVectorImplIN5clang16StoredDiagnosticEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124StoredDiagnosticConsumerC1ERN4llvm15SmallVectorImplIN5clang16StoredDiagnosticEEE")
  //</editor-fold>
  public /*explicit*/ StoredDiagnosticConsumer(SmallVectorImpl<StoredDiagnostic> /*&*/ StoredDiags) {
    // : DiagnosticConsumer(), StoredDiags(StoredDiags), SourceMgr(null) 
    //START JInit
    super();
    this./*&*/StoredDiags=/*&*/StoredDiags;
    this.SourceMgr = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StoredDiagnosticConsumer::BeginSourceFile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PreprocessorImplementation*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 571,
   FQN="(anonymous namespace)::StoredDiagnosticConsumer::BeginSourceFile", NM="_ZN12_GLOBAL__N_124StoredDiagnosticConsumer15BeginSourceFileERKN5clang11LangOptionsEPKNS1_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124StoredDiagnosticConsumer15BeginSourceFileERKN5clang11LangOptionsEPKNS1_12PreprocessorE")
  //</editor-fold>
  @Override public void BeginSourceFile(/*const*/ LangOptions /*&*/ LangOpts)/* override*/ {
    BeginSourceFile(LangOpts, 
                 (/*const*/ Preprocessor /*P*/ )null);
  }
  @Override public void BeginSourceFile(/*const*/ LangOptions /*&*/ LangOpts, 
                 /*const*/ PreprocessorImplementation /*P*/ PP/*= null*/)/* override*/ {
    if ((PP != null)) {
      SourceMgr = /*AddrOf*/PP.getSourceManager();
    }
  }

  
  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StoredDiagnosticConsumer::HandleDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 609,
   FQN="(anonymous namespace)::StoredDiagnosticConsumer::HandleDiagnostic", NM="_ZN12_GLOBAL__N_124StoredDiagnosticConsumer16HandleDiagnosticEN5clang17DiagnosticsEngine5LevelERKNS1_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124StoredDiagnosticConsumer16HandleDiagnosticEN5clang17DiagnosticsEngine5LevelERKNS1_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level Level, 
                  /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    // Default implementation (Warnings/errors count).
    super.HandleDiagnostic(Level, Info);
    
    // Only record the diagnostic if it's part of the source manager we know
    // about. This effectively drops diagnostics from modules we're building.
    // FIXME: In the long run, ee don't want to drop source managers from modules.
    if (!Info.hasSourceManager() || /*AddrOf*/Info.getSourceManager() == SourceMgr) {
      StoredDiags.emplace_back(new StoredDiagnostic(Level, Info));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StoredDiagnosticConsumer::~StoredDiagnosticConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 562,
   FQN="(anonymous namespace)::StoredDiagnosticConsumer::~StoredDiagnosticConsumer", NM="_ZN12_GLOBAL__N_124StoredDiagnosticConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_124StoredDiagnosticConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "StoredDiags=" + StoredDiags // NOI18N
              + ", SourceMgr=" + SourceMgr // NOI18N
              + super.toString(); // NOI18N
  }
}
