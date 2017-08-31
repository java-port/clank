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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.basic.target.TargetInfo;
import org.clang.basic.target.TargetOptions;
import org.clang.lex.*;
import org.clang.serialization.*;


/// \brief Gathers information from ASTReader that will be used to initialize
/// a Preprocessor.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTInfoCollector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 490,
 FQN="(anonymous namespace)::ASTInfoCollector", NM="_ZN12_GLOBAL__N_116ASTInfoCollectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_116ASTInfoCollectorE")
//</editor-fold>
public class ASTInfoCollector extends /*public*/ ASTReaderListener implements Destructors.ClassWithDestructor {
  private Preprocessor /*&*/ PP;
  private ASTContext /*&*/ Context;
  private LangOptions /*&*/ LangOpt;
  private std.shared_ptr<TargetOptions> /*&*/ TargetOpts;
  private IntrusiveRefCntPtr<TargetInfo> /*&*/ Target;
  private uint$ref/*uint &*/ Counter;
  
  private boolean InitializedLanguage;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTInfoCollector::ASTInfoCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 500,
   FQN="(anonymous namespace)::ASTInfoCollector::ASTInfoCollector", NM="_ZN12_GLOBAL__N_116ASTInfoCollectorC1ERN5clang12PreprocessorERNS1_10ASTContextERNS1_11LangOptionsERSt10shared_ptrINS1_13TargetOptionsEERN4llvm18IntrusiveRefCntPtrINS1_10TargetInfoEEERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_116ASTInfoCollectorC1ERN5clang12PreprocessorERNS1_10ASTContextERNS1_11LangOptionsERSt10shared_ptrINS1_13TargetOptionsEERN4llvm18IntrusiveRefCntPtrINS1_10TargetInfoEEERj")
  //</editor-fold>
  public ASTInfoCollector(Preprocessor /*&*/ PP, ASTContext /*&*/ Context, LangOptions /*&*/ LangOpt, 
      std.shared_ptr<TargetOptions> /*&*/ TargetOpts, 
      IntrusiveRefCntPtr<TargetInfo> /*&*/ Target, uint$ref/*uint &*/ Counter) {
    // : ASTReaderListener(), PP(PP), Context(Context), LangOpt(LangOpt), TargetOpts(TargetOpts), Target(Target), Counter(Counter), InitializedLanguage(false) 
    //START JInit
    super();
    this./*&*/PP=/*&*/PP;
    this./*&*/Context=/*&*/Context;
    this./*&*/LangOpt=/*&*/LangOpt;
    this./*&*/TargetOpts=/*&*/TargetOpts;
    this./*&*/Target=/*&*/Target;
    this./*&*/Counter=/*&*/Counter;
    this.InitializedLanguage = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTInfoCollector::ReadLanguageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 506,
   FQN="(anonymous namespace)::ASTInfoCollector::ReadLanguageOptions", NM="_ZN12_GLOBAL__N_116ASTInfoCollector19ReadLanguageOptionsERKN5clang11LangOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_116ASTInfoCollector19ReadLanguageOptionsERKN5clang11LangOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadLanguageOptions(/*const*/ LangOptions /*&*/ LangOpts, boolean Complain, 
                     boolean AllowCompatibleDifferences)/* override*/ {
    if (InitializedLanguage) {
      return false;
    }
    
    LangOpt.$assign(LangOpts);
    InitializedLanguage = true;
    
    updated();
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTInfoCollector::ReadTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 518,
   FQN="(anonymous namespace)::ASTInfoCollector::ReadTargetOptions", NM="_ZN12_GLOBAL__N_116ASTInfoCollector17ReadTargetOptionsERKN5clang13TargetOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_116ASTInfoCollector17ReadTargetOptionsERKN5clang13TargetOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadTargetOptions(/*const*/ TargetOptions /*&*/ TargetOpts, boolean Complain, 
                   boolean AllowCompatibleDifferences)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If we've already initialized the target, don't do it again.
      if (Target.$bool()) {
        return false;
      }
      
      $c$.clean(this.TargetOpts.$assignMove($c$.track(std.make_shared(new TargetOptions(TargetOpts)))));
      $c$.clean(Target.$assign(
          $c$.track(new IntrusiveRefCntPtr<TargetInfo>(TargetInfo.CreateTargetInfo(PP.getDiagnostics(), this.TargetOpts)))
      ));
      
      updated();
      return false;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTInfoCollector::ReadCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 532,
   FQN="(anonymous namespace)::ASTInfoCollector::ReadCounter", NM="_ZN12_GLOBAL__N_116ASTInfoCollector11ReadCounterERKN5clang13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_116ASTInfoCollector11ReadCounterERKN5clang13serialization10ModuleFileEj")
  //</editor-fold>
  @Override public void ReadCounter(/*const*/ ModuleFile /*&*/ M, 
             /*uint*/int Value)/* override*/ {
    Counter.$set(Value);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTInfoCollector::updated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 538,
   FQN="(anonymous namespace)::ASTInfoCollector::updated", NM="_ZN12_GLOBAL__N_116ASTInfoCollector7updatedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_116ASTInfoCollector7updatedEv")
  //</editor-fold>
  private void updated() {
    if (!Target.$bool() || !InitializedLanguage) {
      return;
    }
    
    // Inform the target of the language options.
    //
    // FIXME: We shouldn't need to do this, the target should be immutable once
    // created. This complexity should be lifted elsewhere.
    Target.$arrow().adjust(LangOpt);
    
    // Initialize the preprocessor.
    PP.Initialize(Target.$star());
    
    // Initialize the ASTContext
    Context.InitBuiltinTypes(Target.$star());
    
    // We didn't have access to the comment options when the ASTContext was
    // constructed, so register them now.
    Context.getCommentCommandTraits().registerCommentOptions(LangOpt.CommentOpts);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTInfoCollector::~ASTInfoCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 490,
   FQN="(anonymous namespace)::ASTInfoCollector::~ASTInfoCollector", NM="_ZN12_GLOBAL__N_116ASTInfoCollectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_116ASTInfoCollectorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "PP=" + PP // NOI18N
              + ", Context=" + Context // NOI18N
              + ", LangOpt=" + LangOpt // NOI18N
              + ", TargetOpts=" + TargetOpts // NOI18N
              + ", Target=" + Target // NOI18N
              + ", Counter=" + Counter // NOI18N
              + ", InitializedLanguage=" + InitializedLanguage // NOI18N
              + super.toString(); // NOI18N
  }
}
