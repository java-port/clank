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

package org.clang.serialization;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import static org.clang.serialization.impl.ASTReaderStatics.*;
import org.llvm.adt.*;


/// \brief ASTReaderListener implementation to validate the information of
/// the PCH file against an initialized Preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::PCHValidator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 263,
 FQN="clang::PCHValidator", NM="_ZN5clang12PCHValidatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidatorE")
//</editor-fold>
public class PCHValidator extends /*public*/ ASTReaderListener implements Destructors.ClassWithDestructor {
  private final Preprocessor /*&*/ PP;
  private final ASTReader /*&*/ Reader;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::PCHValidator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 268,
   FQN="clang::PCHValidator::PCHValidator", NM="_ZN5clang12PCHValidatorC1ERNS_12PreprocessorERNS_9ASTReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidatorC1ERNS_12PreprocessorERNS_9ASTReaderE")
  //</editor-fold>
  public PCHValidator(final Preprocessor /*&*/ PP, final ASTReader /*&*/ Reader) {
    // : ASTReaderListener(), PP(PP), Reader(Reader) 
    //START JInit
    super();
    this./*&*/PP=/*&*/PP;
    this./*&*/Reader=/*&*/Reader;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::ReadLanguageOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 319,
   FQN="clang::PCHValidator::ReadLanguageOptions", NM="_ZN5clang12PCHValidator19ReadLanguageOptionsERKNS_11LangOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidator19ReadLanguageOptionsERKNS_11LangOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadLanguageOptions(final /*const*/ LangOptions /*&*/ LangOpts, 
                     boolean Complain, 
                     boolean AllowCompatibleDifferences)/* override*/ {
    final /*const*/ LangOptions /*&*/ ExistingLangOpts = PP.getLangOpts();
    return checkLanguageOptions(LangOpts, ExistingLangOpts, 
        Complain ? $AddrOf(Reader.Diags) : (DiagnosticsEngine /*P*/ )null, 
        AllowCompatibleDifferences);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::ReadTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 329,
   FQN="clang::PCHValidator::ReadTargetOptions", NM="_ZN5clang12PCHValidator17ReadTargetOptionsERKNS_13TargetOptionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidator17ReadTargetOptionsERKNS_13TargetOptionsEbb")
  //</editor-fold>
  @Override public boolean ReadTargetOptions(final /*const*/ TargetOptions /*&*/ TargetOpts, 
                   boolean Complain, 
                   boolean AllowCompatibleDifferences)/* override*/ {
    final /*const*/ TargetOptions /*&*/ ExistingTargetOpts = PP.getTargetInfo().getTargetOpts();
    return checkTargetOptions(TargetOpts, ExistingTargetOpts, 
        Complain ? $AddrOf(Reader.Diags) : (DiagnosticsEngine /*P*/ )null, 
        AllowCompatibleDifferences);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::ReadDiagnosticOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 420,
   FQN="clang::PCHValidator::ReadDiagnosticOptions", NM="_ZN5clang12PCHValidator21ReadDiagnosticOptionsEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticOptionsEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidator21ReadDiagnosticOptionsEN4llvm18IntrusiveRefCntPtrINS_17DiagnosticOptionsEEEb")
  //</editor-fold>
  @Override public boolean ReadDiagnosticOptions(IntrusiveRefCntPtr<DiagnosticOptions> DiagOpts, boolean Complain)/* override*/ {
    IntrusiveRefCntPtr<DiagnosticIDs> DiagIDs = null;
    IntrusiveRefCntPtr<DiagnosticsEngine> Diags = null;
    try {
      final DiagnosticsEngine /*&*/ ExistingDiags = PP.getDiagnostics();
      DiagIDs/*J*/= new IntrusiveRefCntPtr<DiagnosticIDs>(ExistingDiags.getDiagnosticIDs());
      Diags/*J*/= new IntrusiveRefCntPtr<DiagnosticsEngine>(new DiagnosticsEngine(DiagIDs, DiagOpts.get()));
      // This should never fail, because we would have processed these options
      // before writing them to an ASTFile.
      ProcessWarningOptions(Diags.$star(), DiagOpts.$star(), /*Report*/ false);
      
      final ModuleManager /*&*/ ModuleMgr = Reader.getModuleManager();
      assert ($greatereq_uint(ModuleMgr.size(), 1)) : "what ASTFile is this then";
      
      // If the original import came from a file explicitly generated by the user,
      // don't check the diagnostic mappings.
      // FIXME: currently this is approximated by checking whether this is not a
      // module import of an implicitly-loaded module file.
      // Note: ModuleMgr.rbegin() may not be the current module, but it must be in
      // the transitive closure of its imports, since unrelated modules cannot be
      // imported until after this module finishes validation.
      ModuleFile /*P*/ TopImport = ModuleMgr.rbegin().$star();
      while (!TopImport.ImportedBy.empty()) {
        TopImport = TopImport.ImportedBy.$at(0);
      }
      if (TopImport.Kind != ModuleKind.MK_ImplicitModule) {
        return false;
      }
      
      StringRef ModuleName = new StringRef(TopImport.ModuleName);
      assert (!ModuleName.empty()) : "diagnostic options read before module name";
      
      Module /*P*/ M = PP.getHeaderSearchInfo().lookupModule(new StringRef(ModuleName));
      assert ((M != null)) : "missing module";
      
      // FIXME: if the diagnostics are incompatible, save a DiagnosticOptions that
      // contains the union of their flags.
      return checkDiagnosticMappings(Diags.$star(), ExistingDiags, M.IsSystem, Complain);
    } finally {
      if (Diags != null) { Diags.$destroy(); }
      if (DiagIDs != null) { DiagIDs.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::ReadPreprocessorOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 609,
   FQN="clang::PCHValidator::ReadPreprocessorOptions", NM="_ZN5clang12PCHValidator23ReadPreprocessorOptionsERKNS_19PreprocessorOptionsEbRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidator23ReadPreprocessorOptionsERKNS_19PreprocessorOptionsEbRSs")
  //</editor-fold>
  @Override public boolean ReadPreprocessorOptions(final /*const*/ PreprocessorOptions /*&*/ PPOpts, 
                         boolean Complain, 
                         final std.string/*&*/ SuggestedPredefines)/* override*/ {
    final /*const*/ PreprocessorOptions /*&*/ ExistingPPOpts = PP.getPreprocessorOpts();
    
    return checkPreprocessorOptions(PPOpts, ExistingPPOpts, 
        Complain ? $AddrOf(Reader.Diags) : (DiagnosticsEngine /*P*/ )null, 
        PP.getFileManager(), 
        SuggestedPredefines, 
        PP.getLangOpts());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::ReadHeaderSearchOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 642,
   FQN="clang::PCHValidator::ReadHeaderSearchOptions", NM="_ZN5clang12PCHValidator23ReadHeaderSearchOptionsERKNS_19HeaderSearchOptionsEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidator23ReadHeaderSearchOptionsERKNS_19HeaderSearchOptionsEN4llvm9StringRefEb")
  //</editor-fold>
  @Override public boolean ReadHeaderSearchOptions(final /*const*/ HeaderSearchOptions /*&*/ HSOpts, 
                         StringRef SpecificModuleCachePath, 
                         boolean Complain)/* override*/ {
    return checkHeaderSearchOptions(HSOpts, new StringRef(SpecificModuleCachePath), 
        PP.getHeaderSearchInfo().getModuleCachePath(), 
        Complain ? $AddrOf(Reader.Diags) : (DiagnosticsEngine /*P*/ )null, 
        PP.getLangOpts());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::ReadCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 651,
   FQN="clang::PCHValidator::ReadCounter", NM="_ZN5clang12PCHValidator11ReadCounterERKNS_13serialization10ModuleFileEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidator11ReadCounterERKNS_13serialization10ModuleFileEj")
  //</editor-fold>
  @Override public void ReadCounter(final /*const*/ ModuleFile /*&*/ M, /*uint*/int Value)/* override*/ {
    PP.setCounterValue(Value);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 2172,
   FQN="clang::PCHValidator::Error", NM="_ZN5clang12PCHValidator5ErrorEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidator5ErrorEPKc")
  //</editor-fold>
  private /*inline*/ void Error(/*const*/char$ptr/*char P*/ Msg) {
    Reader.Error(new StringRef(Msg));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PCHValidator::~PCHValidator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTReader.h", line = 263,
   FQN="clang::PCHValidator::~PCHValidator", NM="_ZN5clang12PCHValidatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang12PCHValidatorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "PP=" + "[Preprocessor]" // NOI18N
              + ", Reader=" + Reader // NOI18N
              + super.toString(); // NOI18N
  }
}
