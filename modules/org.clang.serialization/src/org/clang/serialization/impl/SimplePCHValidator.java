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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import static org.clang.serialization.impl.ASTReaderStatics.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimplePCHValidator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4147,
 FQN="(anonymous namespace)::SimplePCHValidator", NM="_ZN12_GLOBAL__N_118SimplePCHValidatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_118SimplePCHValidatorE")
//</editor-fold>
public class SimplePCHValidator extends /*public*/ ASTReaderListener implements Destructors.ClassWithDestructor {
  private final /*const*/ LangOptions /*&*/ ExistingLangOpts;
  private final /*const*/ TargetOptions /*&*/ ExistingTargetOpts;
  private final /*const*/ PreprocessorOptions /*&*/ ExistingPPOpts;
  private std.string ExistingModuleCachePath;
  private final FileManager /*&*/ FileMgr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimplePCHValidator::SimplePCHValidator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4155,
   FQN="(anonymous namespace)::SimplePCHValidator::SimplePCHValidator", NM="_ZN12_GLOBAL__N_118SimplePCHValidatorC1ERKN5clang11LangOptionsERKNS1_13TargetOptionsERKNS1_19PreprocessorOptionsEN4llvm9StringRefERNS1_11FileManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_118SimplePCHValidatorC1ERKN5clang11LangOptionsERKNS1_13TargetOptionsERKNS1_19PreprocessorOptionsEN4llvm9StringRefERNS1_11FileManagerE")
  //</editor-fold>
  public SimplePCHValidator(final /*const*/ LangOptions /*&*/ ExistingLangOpts, 
      final /*const*/ TargetOptions /*&*/ ExistingTargetOpts, 
      final /*const*/ PreprocessorOptions /*&*/ ExistingPPOpts, 
      StringRef ExistingModuleCachePath, 
      final FileManager /*&*/ FileMgr) {
    // : ASTReaderListener(), ExistingLangOpts(ExistingLangOpts), ExistingTargetOpts(ExistingTargetOpts), ExistingPPOpts(ExistingPPOpts), ExistingModuleCachePath(ExistingModuleCachePath.operator basic_string()), FileMgr(FileMgr) 
    //START JInit
    super();
    this./*&*/ExistingLangOpts=/*&*/ExistingLangOpts;
    this./*&*/ExistingTargetOpts=/*&*/ExistingTargetOpts;
    this./*&*/ExistingPPOpts=/*&*/ExistingPPOpts;
    this.ExistingModuleCachePath = ExistingModuleCachePath.$string();
    this./*&*/FileMgr=/*&*/FileMgr;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimplePCHValidator::ReadLanguageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4168,
   FQN="(anonymous namespace)::SimplePCHValidator::ReadLanguageOptions", NM="_ZN12_GLOBAL__N_118SimplePCHValidator19ReadLanguageOptionsERKN5clang11LangOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_118SimplePCHValidator19ReadLanguageOptionsERKN5clang11LangOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadLanguageOptions(final /*const*/ LangOptions /*&*/ LangOpts, boolean Complain, 
                     boolean AllowCompatibleDifferences)/* override*/ {
    return checkLanguageOptions(ExistingLangOpts, LangOpts, (DiagnosticsEngine /*P*/ )null, 
        AllowCompatibleDifferences);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimplePCHValidator::ReadTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4173,
   FQN="(anonymous namespace)::SimplePCHValidator::ReadTargetOptions", NM="_ZN12_GLOBAL__N_118SimplePCHValidator17ReadTargetOptionsERKN5clang13TargetOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_118SimplePCHValidator17ReadTargetOptionsERKN5clang13TargetOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadTargetOptions(final /*const*/ TargetOptions /*&*/ TargetOpts, boolean Complain, 
                   boolean AllowCompatibleDifferences)/* override*/ {
    return checkTargetOptions(ExistingTargetOpts, TargetOpts, (DiagnosticsEngine /*P*/ )null, 
        AllowCompatibleDifferences);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimplePCHValidator::ReadHeaderSearchOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4178,
   FQN="(anonymous namespace)::SimplePCHValidator::ReadHeaderSearchOptions", NM="_ZN12_GLOBAL__N_118SimplePCHValidator23ReadHeaderSearchOptionsERKN5clang19HeaderSearchOptionsEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_118SimplePCHValidator23ReadHeaderSearchOptionsERKN5clang19HeaderSearchOptionsEN4llvm9StringRefEb")
  //</editor-fold>
  @Override public boolean ReadHeaderSearchOptions(final /*const*/ HeaderSearchOptions /*&*/ HSOpts, 
                         StringRef SpecificModuleCachePath, 
                         boolean Complain)/* override*/ {
    return checkHeaderSearchOptions(HSOpts, new StringRef(SpecificModuleCachePath), 
        new StringRef(ExistingModuleCachePath), 
        (DiagnosticsEngine /*P*/ )null, ExistingLangOpts);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimplePCHValidator::ReadPreprocessorOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4185,
   FQN="(anonymous namespace)::SimplePCHValidator::ReadPreprocessorOptions", NM="_ZN12_GLOBAL__N_118SimplePCHValidator23ReadPreprocessorOptionsERKN5clang19PreprocessorOptionsEbRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_118SimplePCHValidator23ReadPreprocessorOptionsERKN5clang19PreprocessorOptionsEbRSs")
  //</editor-fold>
  @Override public boolean ReadPreprocessorOptions(final /*const*/ PreprocessorOptions /*&*/ PPOpts, 
                         boolean Complain, 
                         final std.string/*&*/ SuggestedPredefines)/* override*/ {
    return checkPreprocessorOptions(ExistingPPOpts, PPOpts, (DiagnosticsEngine /*P*/ )null, FileMgr, 
        SuggestedPredefines, ExistingLangOpts);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimplePCHValidator::~SimplePCHValidator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4147,
   FQN="(anonymous namespace)::SimplePCHValidator::~SimplePCHValidator", NM="_ZN12_GLOBAL__N_118SimplePCHValidatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_118SimplePCHValidatorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ExistingModuleCachePath.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ExistingLangOpts=" + ExistingLangOpts // NOI18N
              + ", ExistingTargetOpts=" + ExistingTargetOpts // NOI18N
              + ", ExistingPPOpts=" + ExistingPPOpts // NOI18N
              + ", ExistingModuleCachePath=" + ExistingModuleCachePath // NOI18N
              + ", FileMgr=" + "[FileManager]" // NOI18N
              + super.toString(); // NOI18N
  }
}
