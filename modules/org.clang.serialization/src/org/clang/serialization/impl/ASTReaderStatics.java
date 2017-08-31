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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.clang.ast.*;
import org.clang.ast.java.AstFunctionPointers.HasGetSpecializedTemplate;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.llvm.bitcode.*;
import org.clang.serialization.*;
import org.clang.serialization.aliases.ContinuousRangeMapUIntPtr;
import org.clang.serialization.aliases.ContinuousRangeMapULongPtr;
import static org.clang.serialization.impl.ASTReaderStatics.*;
import org.llvm.support.sys.path;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.sys.fs;


//<editor-fold defaultstate="collapsed" desc="static type ASTReaderStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.serialization.impl.ASTReaderStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZL15dumpModuleIDMapN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_PT0_XT1_EEE;Tpl__ZL44completeRedeclChainForTemplateSpecializationPN5clang4DeclE;_ZL16addMethodsToPoolRN5clang4SemaEN4llvm8ArrayRefIPNS_14ObjCMethodDeclEEERNS_14ObjCMethodListE;_ZL17SkipCursorToBlockRN4llvm15BitstreamCursorEj;_ZL17getPredefinedDeclRN5clang10ASTContextENS_13serialization17PredefinedDeclIDsE;_ZL17isDiagnosedResultN5clang9ASTReader13ASTReadResultEj;_ZL18checkTargetOptionsRKN5clang13TargetOptionsES2_PNS_17DiagnosticsEngineEb;_ZL20checkLanguageOptionsRKN5clang11LangOptionsES2_PNS_17DiagnosticsEngineEb;_ZL20readASTFileSignatureRN4llvm15BitstreamReaderE;_ZL21markIdentifierFromASTRN5clang9ASTReaderERNS_14IdentifierInfoE;_ZL21updateModuleTimestampRN5clang13serialization10ModuleFileE;_ZL22startsWithASTFileMagicRN4llvm15BitstreamCursorE;_ZL23checkDiagnosticMappingsRN5clang17DiagnosticsEngineES1_bb;_ZL23collectMacroDefinitionsRKN5clang19PreprocessorOptionsERN4llvm9StringMapISt4pairINS3_9StringRefEbENS3_15MallocAllocatorEEEPNS3_15SmallVectorImplIS6_EE;_ZL23isInterestingIdentifierRN5clang9ASTReaderERNS_14IdentifierInfoEb;_ZL23moduleKindForDiagnosticN5clang13serialization10ModuleKindE;_ZL24checkHeaderSearchOptionsRKN5clang19HeaderSearchOptionsEN4llvm9StringRefES4_PNS_17DiagnosticsEngineERKNS_11LangOptionsE;_ZL24checkPreprocessorOptionsRKN5clang19PreprocessorOptionsES2_PNS_17DiagnosticsEngineERNS_11FileManagerERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEERKNS_11LangOptionsE;_ZL26PassObjCImplDeclToConsumerPN5clang12ObjCImplDeclEPNS_11ASTConsumerE;_ZL27isExtHandlingFromDiagsErrorRN5clang17DiagnosticsEngineE;_ZL28checkDiagnosticGroupMappingsRN5clang17DiagnosticsEngineES1_b;_ZL28moveMethodToBackOfGlobalListRN5clang4SemaEPNS_14ObjCMethodDeclE;_ZL32parseModuleFileExtensionMetadataRKN4llvm15SmallVectorImplIyEENS_9StringRefERN5clang27ModuleFileExtensionMetadataE;_ZL32resolveFileRelativeToOriginalDirRKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEES6_S6_;_ZL7readBitRj; -static-type=ASTReaderStatics -package=org.clang.serialization.impl")
//</editor-fold>
public final class ASTReaderStatics {


/// \brief Compare the given set of language options against an existing set of
/// language options.
///
/// \param Diags If non-NULL, diagnostics will be emitted via this engine.
/// \param AllowCompatibleDifferences If true, differences between compatible
///        language options will be permitted.
///
/// \returns true if the languagae options mis-match, false otherwise.
//<editor-fold defaultstate="collapsed" desc="checkLanguageOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 184,
 FQN="checkLanguageOptions", NM="_ZL20checkLanguageOptionsRKN5clang11LangOptionsES2_PNS_17DiagnosticsEngineEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL20checkLanguageOptionsRKN5clang11LangOptionsES2_PNS_17DiagnosticsEngineEb")
//</editor-fold>
public static boolean checkLanguageOptions(final /*const*/ LangOptions /*&*/ LangOpts, 
                    final /*const*/ LangOptions /*&*/ ExistingLangOpts, 
                    DiagnosticsEngine /*P*/ Diags) {
  return checkLanguageOptions(LangOpts, 
                    ExistingLangOpts, 
                    Diags, 
                    true);
}
public static boolean checkLanguageOptions(final /*const*/ LangOptions /*&*/ LangOpts, 
                    final /*const*/ LangOptions /*&*/ ExistingLangOpts, 
                    DiagnosticsEngine /*P*/ Diags, 
                    boolean AllowCompatibleDifferences/*= true*/) {
  
  // FIXME: A lot of the BENIGN_ options should be COMPATIBLE_ instead.
  if (ExistingLangOpts.C99 != LangOpts.C99) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C99"), LangOpts.C99), ExistingLangOpts.C99));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.C11 != LangOpts.C11) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C11"), LangOpts.C11), ExistingLangOpts.C11));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.MSVCCompat != LangOpts.MSVCCompat) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Microsoft Visual C++ full compatibility mode"), LangOpts.MSVCCompat), ExistingLangOpts.MSVCCompat));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.MicrosoftExt != LangOpts.MicrosoftExt) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Microsoft C++ extensions"), LangOpts.MicrosoftExt), ExistingLangOpts.MicrosoftExt));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.AsmBlocks != LangOpts.AsmBlocks) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Microsoft inline asm blocks"), LangOpts.AsmBlocks), ExistingLangOpts.AsmBlocks));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Borland != LangOpts.Borland) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Borland extensions"), LangOpts.Borland), ExistingLangOpts.Borland));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CPlusPlus != LangOpts.CPlusPlus) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C++"), LangOpts.CPlusPlus), ExistingLangOpts.CPlusPlus));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CPlusPlus11 != LangOpts.CPlusPlus11) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C++11"), LangOpts.CPlusPlus11), ExistingLangOpts.CPlusPlus11));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CPlusPlus14 != LangOpts.CPlusPlus14) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C++14"), LangOpts.CPlusPlus14), ExistingLangOpts.CPlusPlus14));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CPlusPlus1z != LangOpts.CPlusPlus1z) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C++1z"), LangOpts.CPlusPlus1z), ExistingLangOpts.CPlusPlus1z));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ObjC1 != LangOpts.ObjC1) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Objective-C 1"), LangOpts.ObjC1), ExistingLangOpts.ObjC1));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ObjC2 != LangOpts.ObjC2) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Objective-C 2"), LangOpts.ObjC2), ExistingLangOpts.ObjC2));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.AppExt != LangOpts.AppExt) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Objective-C App Extension"), LangOpts.AppExt), ExistingLangOpts.AppExt));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Trigraphs != LangOpts.Trigraphs) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"trigraphs"), LangOpts.Trigraphs), ExistingLangOpts.Trigraphs));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.LineComment != LangOpts.LineComment) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"'//' comments"), LangOpts.LineComment), ExistingLangOpts.LineComment));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Bool != LangOpts.Bool) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"bool, true, and false keywords"), LangOpts.Bool), ExistingLangOpts.Bool));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Half != LangOpts.Half) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"half keyword"), LangOpts.Half), ExistingLangOpts.Half));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.WChar != LangOpts.WChar) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"wchar_t keyword"), LangOpts.WChar), ExistingLangOpts.WChar));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.DeclSpecKeyword != LangOpts.DeclSpecKeyword) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"__declspec keyword"), LangOpts.DeclSpecKeyword), ExistingLangOpts.DeclSpecKeyword));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.GNUKeywords != LangOpts.GNUKeywords) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"GNU keywords"), LangOpts.GNUKeywords), ExistingLangOpts.GNUKeywords));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Digraphs != LangOpts.Digraphs) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"digraphs"), LangOpts.Digraphs), ExistingLangOpts.Digraphs));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CXXOperatorNames != LangOpts.CXXOperatorNames) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C++ operator name keywords"), LangOpts.CXXOperatorNames), ExistingLangOpts.CXXOperatorNames));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.AppleKext != LangOpts.AppleKext) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Apple kext support"), LangOpts.AppleKext), ExistingLangOpts.AppleKext));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.WritableStrings != LangOpts.WritableStrings) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"writable string support"), LangOpts.WritableStrings), ExistingLangOpts.WritableStrings));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ConstStrings != LangOpts.ConstStrings) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"const-qualified string support"), LangOpts.ConstStrings), ExistingLangOpts.ConstStrings));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.LaxVectorConversions != LangOpts.LaxVectorConversions) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"lax vector conversions"), LangOpts.LaxVectorConversions), ExistingLangOpts.LaxVectorConversions));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.AltiVec != LangOpts.AltiVec) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"AltiVec-style vector initializers"), LangOpts.AltiVec), ExistingLangOpts.AltiVec));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ZVector != LangOpts.ZVector) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"System z vector extensions"), LangOpts.ZVector), ExistingLangOpts.ZVector));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Exceptions != LangOpts.Exceptions) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"exception handling"), LangOpts.Exceptions), ExistingLangOpts.Exceptions));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ObjCExceptions != LangOpts.ObjCExceptions) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Objective-C exceptions"), LangOpts.ObjCExceptions), ExistingLangOpts.ObjCExceptions));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CXXExceptions != LangOpts.CXXExceptions) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C++ exceptions"), LangOpts.CXXExceptions), ExistingLangOpts.CXXExceptions));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.SjLjExceptions != LangOpts.SjLjExceptions) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"setjmp-longjump exception handling"), LangOpts.SjLjExceptions), ExistingLangOpts.SjLjExceptions));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ExternCNoUnwind != LangOpts.ExternCNoUnwind) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Assume extern C functions don't unwind"), LangOpts.ExternCNoUnwind), ExistingLangOpts.ExternCNoUnwind));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.TraditionalCPP != LangOpts.TraditionalCPP) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"traditional CPP emulation"), LangOpts.TraditionalCPP), ExistingLangOpts.TraditionalCPP));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.RTTI != LangOpts.RTTI) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"run-time type information"), LangOpts.RTTI), ExistingLangOpts.RTTI));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.RTTIData != LangOpts.RTTIData) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"emit run-time type information data"), LangOpts.RTTIData), ExistingLangOpts.RTTIData));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.MSBitfields != LangOpts.MSBitfields) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Microsoft-compatible structure layout"), LangOpts.MSBitfields), ExistingLangOpts.MSBitfields));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Freestanding != LangOpts.Freestanding) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"freestanding implementation"), LangOpts.Freestanding), ExistingLangOpts.Freestanding));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.NoBuiltin != LangOpts.NoBuiltin) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"disable builtin functions"), LangOpts.NoBuiltin), ExistingLangOpts.NoBuiltin));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.NoMathBuiltin != LangOpts.NoMathBuiltin) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"disable math builtin functions"), LangOpts.NoMathBuiltin), ExistingLangOpts.NoMathBuiltin));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.GNUAsm != LangOpts.GNUAsm) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"GNU-style inline assembly"), LangOpts.GNUAsm), ExistingLangOpts.GNUAsm));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Coroutines != LangOpts.Coroutines) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"C++ coroutines"), LangOpts.Coroutines), ExistingLangOpts.Coroutines));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.POSIXThreads != LangOpts.POSIXThreads) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"POSIX thread support"), LangOpts.POSIXThreads), ExistingLangOpts.POSIXThreads));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Blocks != LangOpts.Blocks) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"blocks extension to C"), LangOpts.Blocks), ExistingLangOpts.Blocks));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.MathErrno != LangOpts.MathErrno) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"errno in math functions"), LangOpts.MathErrno), ExistingLangOpts.MathErrno));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.Modules != LangOpts.Modules) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"modules extension to C"), LangOpts.Modules), ExistingLangOpts.Modules));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.ModulesDeclUse != LangOpts.ModulesDeclUse) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"require declaration of module uses"), LangOpts.ModulesDeclUse), ExistingLangOpts.ModulesDeclUse));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.ModulesStrictDeclUse != LangOpts.ModulesStrictDeclUse) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"requiring declaration of module uses and all headers to be in modules"), LangOpts.ModulesStrictDeclUse), ExistingLangOpts.ModulesStrictDeclUse));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.ModulesLocalVisibility != LangOpts.ModulesLocalVisibility) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"local submodule visibility"), LangOpts.ModulesLocalVisibility), ExistingLangOpts.ModulesLocalVisibility));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.Optimize != LangOpts.Optimize) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"__OPTIMIZE__ predefined macro"), LangOpts.Optimize), ExistingLangOpts.Optimize));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.OptimizeSize != LangOpts.OptimizeSize) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"__OPTIMIZE_SIZE__ predefined macro"), LangOpts.OptimizeSize), ExistingLangOpts.OptimizeSize));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.Static != LangOpts.Static) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"__STATIC__ predefined macro (as opposed to __DYNAMIC__)"), LangOpts.Static), ExistingLangOpts.Static));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (ExistingLangOpts.PackStruct != LangOpts.PackStruct) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"default struct packing maximum alignment"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.MaxTypeAlign != LangOpts.MaxTypeAlign) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"default maximum alignment for types"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.AlignDouble != LangOpts.AlignDouble) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"Controls if doubles should be aligned to 8 bytes (x86 only)"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (!AllowCompatibleDifferences) {
    if ($2bits_uint2uint(ExistingLangOpts.PICLevel) != $2bits_uint2uint(LangOpts.PICLevel)) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"__PIC__ level"));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.PIE != LangOpts.PIE) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"is pie"));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.GNUInline != LangOpts.GNUInline) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"GNU inline semantics"), LangOpts.GNUInline), ExistingLangOpts.GNUInline));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.NoInlineDefine != LangOpts.NoInlineDefine) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"__NO_INLINE__ predefined macro"), LangOpts.NoInlineDefine), ExistingLangOpts.NoInlineDefine));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.Deprecated != LangOpts.Deprecated) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"__DEPRECATED predefined macro"), LangOpts.Deprecated), ExistingLangOpts.Deprecated));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.FastMath != LangOpts.FastMath) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"fast FP math optimizations, and __FAST_MATH__ predefined macro"), LangOpts.FastMath), ExistingLangOpts.FastMath));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.FiniteMathOnly != LangOpts.FiniteMathOnly) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"__FINITE_MATH_ONLY__ predefined macro"), LangOpts.FiniteMathOnly), ExistingLangOpts.FiniteMathOnly));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (!AllowCompatibleDifferences) {
    if (ExistingLangOpts.UnsafeFPMath != LangOpts.UnsafeFPMath) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Unsafe Floating Point Math"), LangOpts.UnsafeFPMath), ExistingLangOpts.UnsafeFPMath));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (ExistingLangOpts.CharIsSigned != LangOpts.CharIsSigned) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/$signed_char), LangOpts.CharIsSigned), ExistingLangOpts.CharIsSigned));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ShortWChar != LangOpts.ShortWChar) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"unsigned short wchar_t"), LangOpts.ShortWChar), ExistingLangOpts.ShortWChar));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.getMSPointerToMemberRepresentationMethod() != LangOpts.getMSPointerToMemberRepresentationMethod()) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"member-pointer representation method"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.getDefaultCallingConv() != LangOpts.getDefaultCallingConv()) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"default calling convention"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ShortEnums != LangOpts.ShortEnums) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"short enum types"), LangOpts.ShortEnums), ExistingLangOpts.ShortEnums));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.OpenCL != LangOpts.OpenCL) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"OpenCL"), LangOpts.OpenCL), ExistingLangOpts.OpenCL));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.OpenCLVersion != LangOpts.OpenCLVersion) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"OpenCL version"), LangOpts.OpenCLVersion), ExistingLangOpts.OpenCLVersion));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.NativeHalfType != LangOpts.NativeHalfType) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Native half type support"), LangOpts.NativeHalfType), ExistingLangOpts.NativeHalfType));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.NativeHalfArgsAndReturns != LangOpts.NativeHalfArgsAndReturns) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Native half args and returns"), LangOpts.NativeHalfArgsAndReturns), ExistingLangOpts.NativeHalfArgsAndReturns));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.HalfArgsAndReturns != LangOpts.HalfArgsAndReturns) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"half args and returns"), LangOpts.HalfArgsAndReturns), ExistingLangOpts.HalfArgsAndReturns));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CUDA != LangOpts.CUDA) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"CUDA"), LangOpts.CUDA), ExistingLangOpts.CUDA));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.OpenMP != LangOpts.OpenMP) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"OpenMP support and version of OpenMP (31, 40 or 45)"), LangOpts.OpenMP), ExistingLangOpts.OpenMP));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.OpenMPUseTLS != LangOpts.OpenMPUseTLS) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Use TLS for threadprivates or runtime calls"), LangOpts.OpenMPUseTLS), ExistingLangOpts.OpenMPUseTLS));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.OpenMPIsDevice != LangOpts.OpenMPIsDevice) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Generate code only for OpenMP target device"), LangOpts.OpenMPIsDevice), ExistingLangOpts.OpenMPIsDevice));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.RenderScript != LangOpts.RenderScript) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"RenderScript"), LangOpts.RenderScript), ExistingLangOpts.RenderScript));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CUDAIsDevice != LangOpts.CUDAIsDevice) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"compiling for CUDA device"), LangOpts.CUDAIsDevice), ExistingLangOpts.CUDAIsDevice));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CUDAAllowVariadicFunctions != LangOpts.CUDAAllowVariadicFunctions) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"allowing variadic functions in CUDA device code"), LangOpts.CUDAAllowVariadicFunctions), ExistingLangOpts.CUDAAllowVariadicFunctions));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CUDAHostDeviceConstexpr != LangOpts.CUDAHostDeviceConstexpr) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"treating unattributed constexpr functions as __host__ __device__"), LangOpts.CUDAHostDeviceConstexpr), ExistingLangOpts.CUDAHostDeviceConstexpr));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CUDADeviceFlushDenormalsToZero != LangOpts.CUDADeviceFlushDenormalsToZero) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"flushing denormals to zero"), LangOpts.CUDADeviceFlushDenormalsToZero), ExistingLangOpts.CUDADeviceFlushDenormalsToZero));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.CUDADeviceApproxTranscendentals != LangOpts.CUDADeviceApproxTranscendentals) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"using approximate transcendental functions"), LangOpts.CUDADeviceApproxTranscendentals), ExistingLangOpts.CUDADeviceApproxTranscendentals));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.SizedDeallocation != LangOpts.SizedDeallocation) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"enable sized deallocation functions"), LangOpts.SizedDeallocation), ExistingLangOpts.SizedDeallocation));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ConceptsTS != LangOpts.ConceptsTS) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"enable C++ Extensions for Concepts"), LangOpts.ConceptsTS), ExistingLangOpts.ConceptsTS));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.NoConstantCFStrings != LangOpts.NoConstantCFStrings) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"no constant CoreFoundation strings"), LangOpts.NoConstantCFStrings), ExistingLangOpts.NoConstantCFStrings));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.SinglePrecisionConstants != LangOpts.SinglePrecisionConstants) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"treating double-precision floating point constants as single precision constants"), LangOpts.SinglePrecisionConstants), ExistingLangOpts.SinglePrecisionConstants));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.FastRelaxedMath != LangOpts.FastRelaxedMath) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"OpenCL fast relaxed math"), LangOpts.FastRelaxedMath), ExistingLangOpts.FastRelaxedMath));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.DefaultFPContract != LangOpts.DefaultFPContract) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"FP_CONTRACT"), LangOpts.DefaultFPContract), ExistingLangOpts.DefaultFPContract));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.NoBitFieldTypeAlign != LangOpts.NoBitFieldTypeAlign) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"bit-field type alignment"), LangOpts.NoBitFieldTypeAlign), ExistingLangOpts.NoBitFieldTypeAlign));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.HexagonQdsp6Compat != LangOpts.HexagonQdsp6Compat) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"hexagon-qdsp6 backward compatibility"), LangOpts.HexagonQdsp6Compat), ExistingLangOpts.HexagonQdsp6Compat));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ObjCAutoRefCount != LangOpts.ObjCAutoRefCount) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Objective-C automated reference counting"), LangOpts.ObjCAutoRefCount), ExistingLangOpts.ObjCAutoRefCount));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ObjCWeakRuntime != LangOpts.ObjCWeakRuntime) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"__weak support in the ARC runtime"), LangOpts.ObjCWeakRuntime), ExistingLangOpts.ObjCWeakRuntime));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ObjCWeak != LangOpts.ObjCWeak) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Objective-C __weak in ARC and MRC files"), LangOpts.ObjCWeak), ExistingLangOpts.ObjCWeak));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ObjCSubscriptingLegacyRuntime != LangOpts.ObjCSubscriptingLegacyRuntime) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Subscripting support in legacy ObjectiveC runtime"), LangOpts.ObjCSubscriptingLegacyRuntime), ExistingLangOpts.ObjCSubscriptingLegacyRuntime));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.FakeAddressSpaceMap != LangOpts.FakeAddressSpaceMap) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"OpenCL fake address space map"), LangOpts.FakeAddressSpaceMap), ExistingLangOpts.FakeAddressSpaceMap));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.getAddressSpaceMapMangling() != LangOpts.getAddressSpaceMapMangling()) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"OpenCL address space map mangling mode"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.IncludeDefaultHeader != LangOpts.IncludeDefaultHeader) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Include default header file for OpenCL"), LangOpts.IncludeDefaultHeader), ExistingLangOpts.IncludeDefaultHeader));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.BlocksRuntimeOptional != LangOpts.BlocksRuntimeOptional) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"optional blocks runtime"), LangOpts.BlocksRuntimeOptional), ExistingLangOpts.BlocksRuntimeOptional));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.getGC() != LangOpts.getGC()) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"Objective-C Garbage Collection mode"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.getValueVisibilityMode() != LangOpts.getValueVisibilityMode()) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"value symbol visibility"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.getTypeVisibilityMode() != LangOpts.getTypeVisibilityMode()) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"type symbol visibility"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.getStackProtector() != LangOpts.getStackProtector()) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"stack protector mode"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.getSignedOverflowBehavior() != LangOpts.getSignedOverflowBehavior()) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"signed integer overflow handling"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.MSCompatibilityVersion != LangOpts.MSCompatibilityVersion) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"Microsoft Visual C/C++ Version"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if ($2bits_uint2uint(ExistingLangOpts.VtorDispMode) != $2bits_uint2uint(LangOpts.VtorDispMode)) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"How many vtordisps to insert"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.ApplePragmaPack != LangOpts.ApplePragmaPack) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"Apple gcc-compatible #pragma pack handling"), LangOpts.ApplePragmaPack), ExistingLangOpts.ApplePragmaPack));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ExistingLangOpts.RetainCommentsFromSystemHeaders != LangOpts.RetainCommentsFromSystemHeaders) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"retain documentation comments from system headers in the AST"), LangOpts.RetainCommentsFromSystemHeaders), ExistingLangOpts.RetainCommentsFromSystemHeaders));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if ($2bits_uint2uint(ExistingLangOpts.SanitizeAddressFieldPadding) != $2bits_uint2uint(LangOpts.SanitizeAddressFieldPadding)) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_mismatch)), /*KEEP_STR*/"controls how aggressive is ASan field padding (0: none, 1:least aggressive, 2: more aggressive)"), $2bits_uint2uint(LangOpts.SanitizeAddressFieldPadding)), $2bits_uint2uint(ExistingLangOpts.SanitizeAddressFieldPadding)));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (org.clank.java.std.$noteq_vector$_Tp$_Alloc$C(ExistingLangOpts.ModuleFeatures, LangOpts.ModuleFeatures)) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), /*KEEP_STR*/"module features"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (ObjCRuntime.$noteq_ObjCRuntime$C(ExistingLangOpts.ObjCRuntime, LangOpts.ObjCRuntime)) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), 
            /*KEEP_STR*/"target Objective-C runtime"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (org.clank.java.std.$noteq_vector$_Tp$_Alloc$C(ExistingLangOpts.CommentOpts.BlockCommandNames, 
      LangOpts.CommentOpts.BlockCommandNames)) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_langopt_value_mismatch)), 
            /*KEEP_STR*/"block command names"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  
  return false;
}


/// \brief Compare the given set of target options against an existing set of
/// target options.
///
/// \param Diags If non-NULL, diagnostics will be emitted via this engine.
///
/// \returns true if the target options mis-match, false otherwise.
//<editor-fold defaultstate="collapsed" desc="checkTargetOptions">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 259,
 FQN="checkTargetOptions", NM="_ZL18checkTargetOptionsRKN5clang13TargetOptionsES2_PNS_17DiagnosticsEngineEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL18checkTargetOptionsRKN5clang13TargetOptionsES2_PNS_17DiagnosticsEngineEb")
//</editor-fold>
public static boolean checkTargetOptions(final /*const*/ TargetOptions /*&*/ TargetOpts, 
                  final /*const*/ TargetOptions /*&*/ ExistingTargetOpts, 
                  DiagnosticsEngine /*P*/ Diags) {
  return checkTargetOptions(TargetOpts, 
                  ExistingTargetOpts, 
                  Diags, 
                  true);
}
public static boolean checkTargetOptions(final /*const*/ TargetOptions /*&*/ TargetOpts, 
                  final /*const*/ TargetOptions /*&*/ ExistingTargetOpts, 
                  DiagnosticsEngine /*P*/ Diags, 
                  boolean AllowCompatibleDifferences/*= true*/) {
  
  // The triple and ABI must match exactly.
  if ($noteq_string$C(TargetOpts.Triple, ExistingTargetOpts.Triple)) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_targetopt_mismatch)), /*KEEP_STR*/"target"), new StringRef(TargetOpts.Triple)), new StringRef(ExistingTargetOpts.Triple)));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  ;
  if ($noteq_string$C(TargetOpts.ABI, ExistingTargetOpts.ABI)) {
    if ((Diags != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_targetopt_mismatch)), /*KEEP_STR*/"target ABI"), new StringRef(TargetOpts.ABI)), new StringRef(ExistingTargetOpts.ABI)));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  ;
  
  // We can tolerate different CPUs in many cases, notably when one CPU
  // supports a strict superset of another. When allowing compatible
  // differences skip this check.
  if (!AllowCompatibleDifferences) {
    if ($noteq_string$C(TargetOpts.CPU, ExistingTargetOpts.CPU)) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_targetopt_mismatch)), /*KEEP_STR*/"target CPU"), new StringRef(TargetOpts.CPU)), new StringRef(ExistingTargetOpts.CPU)));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  ;
  
  // Compare feature sets.
  SmallVector<StringRef> ExistingFeatures/*J*/= new SmallVector<StringRef>(JD$T.INSTANCE, 4, ExistingTargetOpts.FeaturesAsWritten.begin$Const(), 
      ExistingTargetOpts.FeaturesAsWritten.end$Const(), new StringRef(), (string a) -> new StringRef(a));
  SmallVector<StringRef> ReadFeatures/*J*/= new SmallVector<StringRef>(JD$T.INSTANCE, 4, TargetOpts.FeaturesAsWritten.begin$Const(), 
      TargetOpts.FeaturesAsWritten.end$Const(), new StringRef(), (string a) -> new StringRef(a));
  std.sort(ExistingFeatures.begin(), ExistingFeatures.end());
  std.sort(ReadFeatures.begin(), ReadFeatures.end());
  
  // We compute the set difference in both directions explicitly so that we can
  // diagnose the differences differently.
  SmallVector<StringRef> UnmatchedExistingFeatures/*J*/= new SmallVector<StringRef>(4, new StringRef());
  SmallVector<StringRef> UnmatchedReadFeatures/*J*/= new SmallVector<StringRef>(4, new StringRef());
  std.set_difference(ExistingFeatures.begin(), ExistingFeatures.end(), ReadFeatures.begin(), 
      ReadFeatures.end(), std.back_inserter(UnmatchedExistingFeatures));
  std.set_difference(ReadFeatures.begin(), ReadFeatures.end(), 
      ExistingFeatures.begin(), ExistingFeatures.end(), 
      std.back_inserter(UnmatchedReadFeatures));
  
  // If we are allowing compatible differences and the read feature set is
  // a strict subset of the existing feature set, there is nothing to diagnose.
  if (AllowCompatibleDifferences && UnmatchedReadFeatures.empty()) {
    return false;
  }
  if ((Diags != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      for (StringRef Feature : UnmatchedReadFeatures)  {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track(Diags.Report(diag.err_pch_targetopt_feature_mismatch)), 
                /* is-existing-feature */ false), /*NO_COPY*/Feature));
      }
      for (StringRef Feature : UnmatchedExistingFeatures)  {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out$Same2Bool($c$.track(Diags.Report(diag.err_pch_targetopt_feature_mismatch)), 
                /* is-existing-feature */ true), /*NO_COPY*/Feature));
      }
    } finally {
      $c$.$destroy();
    }
  }
  
  return !UnmatchedReadFeatures.empty() || !UnmatchedExistingFeatures.empty();
}

//<editor-fold defaultstate="collapsed" desc="checkDiagnosticGroupMappings">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 345,
 FQN="checkDiagnosticGroupMappings", NM="_ZL28checkDiagnosticGroupMappingsRN5clang17DiagnosticsEngineES1_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL28checkDiagnosticGroupMappingsRN5clang17DiagnosticsEngineES1_b")
//</editor-fold>
public static boolean checkDiagnosticGroupMappings(final DiagnosticsEngine /*&*/ StoredDiags, 
                            final DiagnosticsEngine /*&*/ Diags, 
                            boolean Complain) {
  // JAVA: typedef DiagnosticsEngine::Level Level
//  final class Level extends DiagnosticsEngine.Level{ };
  
  // Check current mappings for new -Werror mappings, and the stored mappings
  // for cases that were explicitly mapped to *not* be errors that are now
  // errors because of options like -Werror.
  DiagnosticsEngine /*P*/ MappingSources[/*2*/] = new DiagnosticsEngine /*P*/  [/*2*/] {$AddrOf(Diags), $AddrOf(StoredDiags)};
  
  for (DiagnosticsEngine /*P*/ MappingSource : MappingSources) {
    for (std.pairUIntType<DiagnosticMapping> DiagIDMappingPair : MappingSource.getDiagnosticMappings()) {
      /*uint*/int DiagID = DiagIDMappingPair.first;
      DiagnosticsEngine.Level CurLevel = Diags.getDiagnosticLevel(DiagID, new SourceLocation());
      if (CurLevel.getValue() < DiagnosticsEngine.Level.Error.getValue()) {
        continue; // not significant
      }
      DiagnosticsEngine.Level StoredLevel = StoredDiags.getDiagnosticLevel(DiagID, new SourceLocation());
      if (StoredLevel.getValue() < DiagnosticsEngine.Level.Error.getValue()) {
        if (Complain) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_pch_diagopt_mismatch)), new StringRef($add_T$C$P_string(/*KEEP_STR*/"-Werror=", 
                        Diags.getDiagnosticIDs().$arrow().getWarningOptionForDiag(DiagID).str()))));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isExtHandlingFromDiagsError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 375,
 FQN="isExtHandlingFromDiagsError", NM="_ZL27isExtHandlingFromDiagsErrorRN5clang17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL27isExtHandlingFromDiagsErrorRN5clang17DiagnosticsEngineE")
//</editor-fold>
public static boolean isExtHandlingFromDiagsError(final DiagnosticsEngine /*&*/ Diags) {
  diag.Severity Ext = Diags.getExtensionHandlingBehavior();
  if (Ext == diag.Severity.Warning && Diags.getWarningsAsErrors()) {
    return true;
  }
  return Ext.getValue() >= diag.Severity.Error.getValue();
}

//<editor-fold defaultstate="collapsed" desc="checkDiagnosticMappings">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 382,
 FQN="checkDiagnosticMappings", NM="_ZL23checkDiagnosticMappingsRN5clang17DiagnosticsEngineES1_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL23checkDiagnosticMappingsRN5clang17DiagnosticsEngineES1_bb")
//</editor-fold>
public static boolean checkDiagnosticMappings(final DiagnosticsEngine /*&*/ StoredDiags, 
                       final DiagnosticsEngine /*&*/ Diags, 
                       boolean IsSystem, boolean Complain) {
  // Top-level options
  if (IsSystem) {
    if (Diags.getSuppressSystemWarnings()) {
      return false;
    }
    // If -Wsystem-headers was not enabled before, be conservative
    if (StoredDiags.getSuppressSystemWarnings()) {
      if (Complain) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_diagopt_mismatch)), /*KEEP_STR*/"-Wsystem-headers"));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  if (Diags.getWarningsAsErrors() && !StoredDiags.getWarningsAsErrors()) {
    if (Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_diagopt_mismatch)), /*KEEP_STR*/"-Werror"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (Diags.getWarningsAsErrors() && Diags.getEnableAllWarnings()
     && !StoredDiags.getEnableAllWarnings()) {
    if (Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_diagopt_mismatch)), /*KEEP_STR*/"-Weverything -Werror"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  if (isExtHandlingFromDiagsError(Diags)
     && !isExtHandlingFromDiagsError(StoredDiags)) {
    if (Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_pch_diagopt_mismatch)), /*KEEP_STR*/"-pedantic-errors"));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  
  return checkDiagnosticGroupMappings(StoredDiags, Diags, Complain);
}


/// \brief Collect the macro definitions provided by the given preprocessor
/// options.
//<editor-fold defaultstate="collapsed" desc="collectMacroDefinitions">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 459,
 FQN="collectMacroDefinitions", NM="_ZL23collectMacroDefinitionsRKN5clang19PreprocessorOptionsERN4llvm9StringMapISt4pairINS3_9StringRefEbENS3_15MallocAllocatorEEEPNS3_15SmallVectorImplIS6_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL23collectMacroDefinitionsRKN5clang19PreprocessorOptionsERN4llvm9StringMapISt4pairINS3_9StringRefEbENS3_15MallocAllocatorEEEPNS3_15SmallVectorImplIS6_EE")
//</editor-fold>
public static void collectMacroDefinitions(final /*const*/ PreprocessorOptions /*&*/ PPOpts, 
                       final StringMap<std.pairTypeBool<StringRef>> /*&*/ Macros) {
  collectMacroDefinitions(PPOpts, 
                       Macros, 
                       (SmallVectorImpl<StringRef> /*P*/ )null);
}
public static void collectMacroDefinitions(final /*const*/ PreprocessorOptions /*&*/ PPOpts, 
                       final StringMap<std.pairTypeBool<StringRef>> /*&*/ Macros, 
                       SmallVectorImpl<StringRef> /*P*/ MacroNames/*= null*/) {
  for (/*uint*/int I = 0, N = PPOpts.Macros.size(); I != N; ++I) {
    StringRef Macro = new StringRef(PPOpts.Macros.$at$Const(I).first);
    boolean IsUndef = PPOpts.Macros.$at$Const(I).second;
    
    std.pairTypeType<StringRef, StringRef> MacroPair = Macro.split($$EQ);
    StringRef MacroName = new StringRef(MacroPair.first);
    StringRef MacroBody = new StringRef(MacroPair.second);
    
    // For an #undef'd macro, we only care about the name.
    if (IsUndef) {
      if ((MacroNames != null) && !(Macros.count(/*NO_COPY*/MacroName) != 0)) {
        MacroNames.push_back(MacroName);
      }
      
      Macros.$at(/*NO_COPY*/MacroName).$assign(std.make_pair_T_bool(new StringRef(""), true));
      continue;
    }
    
    // For a #define'd macro, figure out the actual definition.
    if (MacroName.size() == Macro.size()) {
      MacroBody.$assignMove(/*STRINGREF_STR*/$1);
    } else {
      // Note: GCC drops anything following an end-of-line character.
      /*size_t*/int End = MacroBody.find_first_of(/*STRINGREF_STR*/"\n\015");
      MacroBody.$assignMove(MacroBody.substr(0, End));
    }
    if ((MacroNames != null) && !(Macros.count(/*NO_COPY*/MacroName) != 0)) {
      MacroNames.push_back(MacroName);
    }
    Macros.$at(/*NO_COPY*/MacroName).$assignMove(std.make_pair_T_bool($Clone(MacroBody), false));
  }
}


/// \brief Check the preprocessor options deserialized from the control block
/// against the preprocessor options in an existing preprocessor.
///
/// \param Diags If non-null, produce diagnostics for any mismatches incurred.
//<editor-fold defaultstate="collapsed" desc="checkPreprocessorOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 499,
 FQN="checkPreprocessorOptions", NM="_ZL24checkPreprocessorOptionsRKN5clang19PreprocessorOptionsES2_PNS_17DiagnosticsEngineERNS_11FileManagerERSsRKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL24checkPreprocessorOptionsRKN5clang19PreprocessorOptionsES2_PNS_17DiagnosticsEngineERNS_11FileManagerERSsRKNS_11LangOptionsE")
//</editor-fold>
public static boolean checkPreprocessorOptions(final /*const*/ PreprocessorOptions /*&*/ PPOpts, 
                        final /*const*/ PreprocessorOptions /*&*/ ExistingPPOpts, 
                        DiagnosticsEngine /*P*/ Diags, 
                        final FileManager /*&*/ FileMgr, 
                        final std.string/*&*/ SuggestedPredefines, 
                        final /*const*/ LangOptions /*&*/ LangOpts) {
  StringMap<std.pairTypeBool<StringRef>> ASTFileMacros = null;
  StringMap<std.pairTypeBool<StringRef>> ExistingMacros = null;
  try {
    // Check macro definitions.
    ASTFileMacros/*J*/= new StringMap<std.pairTypeBool<StringRef>>(new std.pairTypeBool<StringRef>());
    collectMacroDefinitions(PPOpts, ASTFileMacros);
    ExistingMacros/*J*/= new StringMap<std.pairTypeBool<StringRef>>(new std.pairTypeBool<StringRef>());
    SmallVector<StringRef> ExistingMacroNames/*J*/= new SmallVector<StringRef>(4, new StringRef());
    collectMacroDefinitions(ExistingPPOpts, ExistingMacros, $AddrOf(ExistingMacroNames));
    
    for (/*uint*/int I = 0, N = ExistingMacroNames.size(); I != N; ++I) {
      // Dig out the macro definition in the existing preprocessor options.
      StringRef MacroName = new StringRef(ExistingMacroNames.$at(I));
      std.pairTypeBool<StringRef> Existing = new std.pairTypeBool<StringRef>(ExistingMacros.$at(/*NO_COPY*/MacroName));
      
      // Check whether we know anything about this macro name or not.
      StringMapIterator<std.pairTypeBool<StringRef> > Known = ASTFileMacros./*IsUndef*/
          find(/*NO_COPY*/MacroName);
      if (Known.$eq(ASTFileMacros.end())) {
        // FIXME: Check whether this identifier was referenced anywhere in the
        // AST file. If so, we should reject the AST file. Unfortunately, this
        // information isn't in the control block. What shall we do about it?
        if (Existing.second) {
          SuggestedPredefines.$addassign_T$C$P(/*KEEP_STR*/"#undef ");
          SuggestedPredefines.$addassign(MacroName.str());
          SuggestedPredefines.$addassign_T($$LF);
        } else {
          SuggestedPredefines.$addassign_T$C$P(/*KEEP_STR*/"#define ");
          SuggestedPredefines.$addassign(MacroName.str());
          SuggestedPredefines.$addassign_T($$SPACE);
          SuggestedPredefines.$addassign(Existing.first.str());
          SuggestedPredefines.$addassign_T($$LF);
        }
        continue;
      }
      
      // If the macro was defined in one but undef'd in the other, we have a
      // conflict.
      if (Existing.second != Known.$arrow().second.second) {
        if ((Diags != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_pch_macro_def_undef)), 
                    /*NO_COPY*/MacroName), Known.$arrow().second.second));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
      
      // If the macro was #undef'd in both, or if the macro bodies are identical,
      // it's fine.
      if (Existing.second || $eq_StringRef(/*NO_COPY*/Existing.first, /*NO_COPY*/Known.$arrow().second.first)) {
        continue;
      }
      
      // The macro bodies differ; complain.
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_pch_macro_def_conflict)), 
                      /*NO_COPY*/MacroName), /*NO_COPY*/Known.$arrow().second.first), /*NO_COPY*/Existing.first));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    
    // Check whether we're using predefines.
    if (PPOpts.UsePredefines != ExistingPPOpts.UsePredefines) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($c$.track(Diags.Report(diag.err_pch_undef)), ExistingPPOpts.UsePredefines));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    
    // Detailed record is important since it is used for the module cache hash.
    if (LangOpts.Modules
       && PPOpts.DetailedRecord != ExistingPPOpts.DetailedRecord) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_uint($c$.track(Diags.Report(diag.err_pch_pp_detailed_record)), PPOpts.DetailedRecord));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    
    // Compute the #include and #include_macros lines we need.
    for (/*uint*/int I = 0, N = ExistingPPOpts.Includes.size(); I != N; ++I) {
      StringRef File = new StringRef(ExistingPPOpts.Includes.$at$Const(I));
      if ($eq_StringRef(/*NO_COPY*/File, new StringRef(ExistingPPOpts.ImplicitPCHInclude))) {
        continue;
      }
      if ($noteq___normal_iterator$C(std.find(PPOpts.Includes.begin$Const(), PPOpts.Includes.end$Const(), File), 
          PPOpts.Includes.end$Const())) {
        continue;
      }
      
      SuggestedPredefines.$addassign_T$C$P(/*KEEP_STR*/"#include \"");
      $addassign_string_StringRef(SuggestedPredefines, /*NO_COPY*/File);
      SuggestedPredefines.$addassign_T$C$P(/*KEEP_STR*/"\"\n");
    }
    
    for (/*uint*/int I = 0, N = ExistingPPOpts.MacroIncludes.size(); I != N; ++I) {
      StringRef File = new StringRef(ExistingPPOpts.MacroIncludes.$at$Const(I));
      if ($noteq___normal_iterator$C(std.find(PPOpts.MacroIncludes.begin$Const(), PPOpts.MacroIncludes.end$Const(), 
              File), 
          PPOpts.MacroIncludes.end$Const())) {
        continue;
      }
      
      SuggestedPredefines.$addassign_T$C$P(/*KEEP_STR*/"#__include_macros \"");
      $addassign_string_StringRef(SuggestedPredefines, /*NO_COPY*/File);
      SuggestedPredefines.$addassign_T$C$P(/*KEEP_STR*/"\"\n##\n");
    }
    
    return false;
  } finally {
    if (ExistingMacros != null) { ExistingMacros.$destroy(); }
    if (ASTFileMacros != null) { ASTFileMacros.$destroy(); }
  }
}


/// Check the header search options deserialized from the control block
/// against the header search options in an existing preprocessor.
///
/// \param Diags If non-null, produce diagnostics for any mismatches incurred.
//<editor-fold defaultstate="collapsed" desc="checkHeaderSearchOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 625,
 FQN="checkHeaderSearchOptions", NM="_ZL24checkHeaderSearchOptionsRKN5clang19HeaderSearchOptionsEN4llvm9StringRefES4_PNS_17DiagnosticsEngineERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL24checkHeaderSearchOptionsRKN5clang19HeaderSearchOptionsEN4llvm9StringRefES4_PNS_17DiagnosticsEngineERKNS_11LangOptionsE")
//</editor-fold>
public static boolean checkHeaderSearchOptions(final /*const*/ HeaderSearchOptions /*&*/ HSOpts, 
                        StringRef SpecificModuleCachePath, 
                        StringRef ExistingModuleCachePath, 
                        DiagnosticsEngine /*P*/ Diags, 
                        final /*const*/ LangOptions /*&*/ LangOpts) {
  if (LangOpts.Modules) {
    if ($noteq_StringRef(/*NO_COPY*/SpecificModuleCachePath, /*NO_COPY*/ExistingModuleCachePath)) {
      if ((Diags != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_pch_modulecache_mismatch)), 
                  /*NO_COPY*/SpecificModuleCachePath), /*NO_COPY*/ExistingModuleCachePath));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  }
  
  return false;
}


/// \brief Whether the given identifier is "interesting".
//<editor-fold defaultstate="collapsed" desc="isInterestingIdentifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 755,
 FQN="isInterestingIdentifier", NM="_ZL23isInterestingIdentifierRN5clang9ASTReaderERNS_14IdentifierInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL23isInterestingIdentifierRN5clang9ASTReaderERNS_14IdentifierInfoEb")
//</editor-fold>
public static boolean isInterestingIdentifier(final ASTReader /*&*/ Reader, final IdentifierInfo /*&*/ II, 
                       boolean IsModule) {
  return II.hadMacroDefinition()
     || II.isPoisoned()
     || ((IsModule ? (II.hasRevertedBuiltin() ? 1 : 0) : II.getObjCOrBuiltinID()) != 0)
     || II.hasRevertedTokenIDToIdentifier()
     || (!(IsModule && Reader.getContext().getLangOpts().CPlusPlus)
     && (II.<Object>getFETokenInfo() != null));
}

//<editor-fold defaultstate="collapsed" desc="readBit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 765,
 FQN="readBit", NM="_ZL7readBitRj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL7readBitRj")
//</editor-fold>
public static boolean readBit(final uint$ref/*uint &*/ Bits) {
  boolean Value = ((Bits.$deref() & 0x1) != 0);
  Bits.$set$rshiftassign(1);
  return Value;
}

//<editor-fold defaultstate="collapsed" desc="markIdentifierFromAST">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 777,
 FQN="markIdentifierFromAST", NM="_ZL21markIdentifierFromASTRN5clang9ASTReaderERNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL21markIdentifierFromASTRN5clang9ASTReaderERNS_14IdentifierInfoE")
//</editor-fold>
public static void markIdentifierFromAST(final ASTReader /*&*/ Reader, final IdentifierInfo /*&*/ II) {
  if (!II.isFromAST()) {
    II.setIsFromAST();
    boolean IsModule = Reader.getPreprocessor().getCurrentModule() != null;
    if (isInterestingIdentifier(Reader, II, IsModule)) {
      II.setChangedSinceDeserialization();
    }
  }
}


/// \brief If a header file is not found at the path that we expect it to be
/// and the PCH file was moved from its original location, try to resolve the
/// file by assuming that header+PCH were moved together and the header is in
/// the same place relative to the PCH.
//<editor-fold defaultstate="collapsed" desc="resolveFileRelativeToOriginalDir">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1174,
 FQN="resolveFileRelativeToOriginalDir", NM="_ZL32resolveFileRelativeToOriginalDirRKSsS0_S0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL32resolveFileRelativeToOriginalDirRKSsS0_S0_")
//</editor-fold>
public static std.string resolveFileRelativeToOriginalDir(final /*const*/std.string/*&*/ Filename, 
                                final /*const*/std.string/*&*/ OriginalDir, 
                                final /*const*/std.string/*&*/ CurrDir) {
  assert ($noteq_string$C(OriginalDir, CurrDir)) : "No point trying to resolve the file if the PCH dir didn't change";
  //JAVA: using namespace llvm::sys;
  SmallString/*<128>*/ filePath/*J*/= new SmallString/*<128>*/(128, new StringRef(Filename));
  fs.make_absolute(filePath);
  assert (path.is_absolute(new Twine(OriginalDir)));
  SmallString/*<128>*/ currPCHPath/*J*/= new SmallString/*<128>*/(128, new StringRef(CurrDir));
  
  path.const_iterator fileDirI = path.begin(path.parent_path(filePath.$StringRef()));
  path.const_iterator fileDirE = path.end(path.parent_path(filePath.$StringRef()));
  path.const_iterator origDirI = path.begin(new StringRef(OriginalDir));
  path.const_iterator origDirE = path.end(new StringRef(OriginalDir));
  // Skip the common path components from filePath and OriginalDir.
  while (fileDirI.$noteq(fileDirE) && origDirI.$noteq(origDirE)
     && $eq_StringRef(/*NO_COPY*/fileDirI.$star(), /*NO_COPY*/origDirI.$star())) {
    fileDirI.$preInc();
    origDirI.$preInc();
  }
  for (; origDirI.$noteq(origDirE); origDirI.$preInc())  {
    path.append(currPCHPath, new Twine(/*KEEP_STR*/$DOT_DOT));
  }
  path.append(currPCHPath, /*NO_COPY*/fileDirI, /*NO_COPY*/fileDirE);
  path.append(currPCHPath, new Twine(path.filename(new StringRef(Filename))));
  return currPCHPath.str().$string();
}

//<editor-fold defaultstate="collapsed" desc="isDiagnosedResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 2069,
 FQN="isDiagnosedResult", NM="_ZL17isDiagnosedResultN5clang9ASTReader13ASTReadResultEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL17isDiagnosedResultN5clang9ASTReader13ASTReadResultEj")
//</editor-fold>
public static boolean isDiagnosedResult(ASTReader.ASTReadResult ARR, /*uint*/int Caps) {
  switch (ARR) {
   case Failure:
    return true;
   case Missing:
    return !((Caps & ASTReader.LoadFailureCapabilities.ARR_Missing) != 0);
   case OutOfDate:
    return !((Caps & ASTReader.LoadFailureCapabilities.ARR_OutOfDate) != 0);
   case VersionMismatch:
    return !((Caps & ASTReader.LoadFailureCapabilities.ARR_VersionMismatch) != 0);
   case ConfigurationMismatch:
    return !((Caps & ASTReader.LoadFailureCapabilities.ARR_ConfigurationMismatch) != 0);
   case HadErrors:
    return true;
   case Success:
    return false;
  }
  throw new llvm_unreachable("unknown ASTReadResult");
}


/// \brief Move the given method to the back of the global list of methods.
//<editor-fold defaultstate="collapsed" desc="moveMethodToBackOfGlobalList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3319,
 FQN="moveMethodToBackOfGlobalList", NM="_ZL28moveMethodToBackOfGlobalListRN5clang4SemaEPNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL28moveMethodToBackOfGlobalListRN5clang4SemaEPNS_14ObjCMethodDeclE")
//</editor-fold>
public static void moveMethodToBackOfGlobalList(final Sema /*&*/ S, ObjCMethodDecl /*P*/ Method) {
  // Find the entry for this selector in the method pool.
  DenseMapIterator<Selector, std_pair.pair<ObjCMethodList, ObjCMethodList>> Known = S.MethodPool.find(Method.getSelector());
  if (Known.$eq(/*NO_ITER_COPY*/S.MethodPool.end())) {
    return;
  }
  
  // Retrieve the appropriate method list.
  final ObjCMethodList /*&*/ Start = Method.isInstanceMethod() ? Known.$arrow().second.first : Known.$arrow().second.second;
  boolean Found = false;
  for (ObjCMethodList /*P*/ List = $AddrOf(Start); (List != null); List = List.getNext()) {
    if (!Found) {
      if (List.getMethod() == Method) {
        Found = true;
      } else {
        // Keep searching.
        continue;
      }
    }
    if ((List.getNext() != null)) {
      List.setMethod(List.getNext().getMethod());
    } else {
      List.setMethod(Method);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="updateModuleTimestamp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3434,
 FQN="updateModuleTimestamp", NM="_ZL21updateModuleTimestampRN5clang13serialization10ModuleFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL21updateModuleTimestampRN5clang13serialization10ModuleFileE")
//</editor-fold>
public static void updateModuleTimestamp(final ModuleFile /*&*/ MF) {
  raw_fd_ostream OS = null;
  try {
    // Overwrite the timestamp file contents so that file's mtime changes.
    std.string TimestampFilename = MF.getTimestampFilename();
    std.error_code EC/*J*/= new std.error_code();
    OS/*J*/= new raw_fd_ostream(new StringRef(TimestampFilename), EC, fs.OpenFlags.F_Text);
    if (EC.$bool()) {
      return;
    }
    OS.$out(/*KEEP_STR*/"Timestamp file\n");
  } finally {
    if (OS != null) { OS.$destroy(); }
  }
}


/// \brief Given a cursor at the start of an AST file, scan ahead and drop the
/// cursor into the start of the given block ID, returning false on success and
/// true on failure.
//<editor-fold defaultstate="collapsed" desc="SkipCursorToBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3447,
 FQN="SkipCursorToBlock", NM="_ZL17SkipCursorToBlockRN4llvm15BitstreamCursorEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL17SkipCursorToBlockRN4llvm15BitstreamCursorEj")
//</editor-fold>
public static boolean SkipCursorToBlock(final BitstreamCursor /*&*/ Cursor, /*uint*/int BlockID) {
  while (true) {
    BitstreamEntry Entry = Cursor.advance();
    switch (Entry.Kind) {
     case Error:
     case EndBlock:
      return true;
     case Record:
      // Ignore top-level records.
      Cursor.skipRecord(Entry.ID);
      break;
     case SubBlock:
      if (Entry.ID == BlockID) {
        if (Cursor.EnterSubBlock(BlockID)) {
          return true;
        }
        // Found it!
        return false;
      }
      if (Cursor.SkipBlock()) {
        return true;
      }
    }
  }
}


/// \brief Reads and return the signature record from \p StreamFile's control
/// block, or else returns 0.
//<editor-fold defaultstate="collapsed" desc="readASTFileSignature">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 4072,
 FQN="readASTFileSignature", NM="_ZL20readASTFileSignatureRN4llvm15BitstreamReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL20readASTFileSignatureRN4llvm15BitstreamReaderE")
//</editor-fold>
public static /*uint*/int readASTFileSignature(final BitstreamReader /*&*/ StreamFile) {
  BitstreamCursor Stream = null;
  try {
    Stream/*J*/= new BitstreamCursor(StreamFile);
    if (!startsWithASTFileMagic(Stream)) {
      return 0;
    }
    
    // Scan for the CONTROL_BLOCK_ID block.
    if (SkipCursorToBlock(Stream, org.clang.serialization.BlockIDs.CONTROL_BLOCK_ID)) {
      return 0;
    }
    
    // Scan for SIGNATURE inside the control block.
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    while (true) {
      BitstreamEntry Entry = Stream.advanceSkippingSubblocks();
      if (Entry.Kind == BitstreamEntry.Unnamed_enum.EndBlock
         || Entry.Kind != BitstreamEntry.Unnamed_enum.Record) {
        return 0;
      }
      
      Record.clear();
      StringRef Blob/*J*/= new StringRef();
      if (ControlRecordTypes.SIGNATURE == Stream.readRecord(Entry.ID, Record, $AddrOf(Blob))) {
        return $ullong2uint(Record.$at(0));
      }
    }
  } finally {
    if (Stream != null) { Stream.$destroy(); }
  }
}


/// \brief Whether \p Stream starts with the AST/PCH file magic number 'CPCH'.
//<editor-fold defaultstate="collapsed" desc="startsWithASTFileMagic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3699,
 FQN="startsWithASTFileMagic", NM="_ZL22startsWithASTFileMagicRN4llvm15BitstreamCursorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL22startsWithASTFileMagicRN4llvm15BitstreamCursorE")
//</editor-fold>
public static boolean startsWithASTFileMagic(final BitstreamCursor /*&*/ Stream) {
  return Stream.Read(8) == $char2uint($$C)
     && Stream.Read(8) == $char2uint($$P)
     && Stream.Read(8) == $char2uint($$C)
     && Stream.Read(8) == $char2uint($$H);
}

//<editor-fold defaultstate="collapsed" desc="moduleKindForDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3706,
 FQN="moduleKindForDiagnostic", NM="_ZL23moduleKindForDiagnosticN5clang13serialization10ModuleKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL23moduleKindForDiagnosticN5clang13serialization10ModuleKindE")
//</editor-fold>
public static /*uint*/int moduleKindForDiagnostic(ModuleKind Kind) {
  switch (Kind) {
   case MK_PCH:
    return 0; // PCH
   case MK_ImplicitModule:
   case MK_ExplicitModule:
    return 1; // module
   case MK_MainFile:
   case MK_Preamble:
    return 2; // main source file
  }
  throw new llvm_unreachable("unknown module kind");
}


/// Parse a record and blob containing module file extension metadata.
//<editor-fold defaultstate="collapsed" desc="parseModuleFileExtensionMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 3860,
 FQN="parseModuleFileExtensionMetadata", NM="_ZL32parseModuleFileExtensionMetadataRKN4llvm15SmallVectorImplIyEENS_9StringRefERN5clang27ModuleFileExtensionMetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL32parseModuleFileExtensionMetadataRKN4llvm15SmallVectorImplIyEENS_9StringRefERN5clang27ModuleFileExtensionMetadataE")
//</editor-fold>
public static boolean parseModuleFileExtensionMetadata(final /*const*/SmallVectorImplULong /*&*/ Record, 
                                StringRef Blob, 
                                final ModuleFileExtensionMetadata /*&*/ Metadata) {
  if ($less_uint(Record.size(), 4)) {
    return true;
  }
  
  Metadata.MajorVersion = $ullong2uint(Record.$at$Const(0));
  Metadata.MinorVersion = $ullong2uint(Record.$at$Const(1));
  
  /*uint*/int BlockNameLen = $ullong2uint(Record.$at$Const(2));
  /*uint*/int UserInfoLen = $ullong2uint(Record.$at$Const(3));
  if ($greater_uint(BlockNameLen + UserInfoLen, Blob.size())) {
    return true;
  }
  
  Metadata.BlockName.$assignMove(new std.string(Blob.data(), Blob.data().$add(BlockNameLen)));
  Metadata.UserInfo.$assignMove(new std.string(Blob.data().$add(BlockNameLen), 
          Blob.data().$add(BlockNameLen).$add(UserInfoLen)));
  return false;
}

/*template <typename TemplateSpecializationDecl> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="completeRedeclChainForTemplateSpecialization">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6227,
 FQN="completeRedeclChainForTemplateSpecialization", NM="Tpl__ZL44completeRedeclChainForTemplateSpecializationPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZL44completeRedeclChainForTemplateSpecializationPN5clang4DeclE")
//</editor-fold>
public static </*typename*/ TemplateSpecializationDecl extends HasGetSpecializedTemplate<?>> void completeRedeclChainForTemplateSpecialization(Class<TemplateSpecializationDecl> clazz, Decl /*P*/ D) {
  {
    TemplateSpecializationDecl /*P*/ TSD = dyn_cast(clazz, D);
    if (TSD != null) {
      TSD.getSpecializedTemplate().LoadLazySpecializations();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getPredefinedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6376,
 FQN="getPredefinedDecl", NM="_ZL17getPredefinedDeclRN5clang10ASTContextENS_13serialization17PredefinedDeclIDsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL17getPredefinedDeclRN5clang10ASTContextENS_13serialization17PredefinedDeclIDsE")
//</editor-fold>
public static Decl /*P*/ getPredefinedDecl(final ASTContext /*&*/ Context, /*PredefinedDeclIDs*/int ID) {
  switch (ID) {
   case PredefinedDeclIDs.PREDEF_DECL_NULL_ID:
    return null;
   case PredefinedDeclIDs.PREDEF_DECL_TRANSLATION_UNIT_ID:
    return Context.getTranslationUnitDecl();
   case PredefinedDeclIDs.PREDEF_DECL_OBJC_ID_ID:
    return Context.getObjCIdDecl();
   case PredefinedDeclIDs.PREDEF_DECL_OBJC_SEL_ID:
    return Context.getObjCSelDecl();
   case PredefinedDeclIDs.PREDEF_DECL_OBJC_CLASS_ID:
    return Context.getObjCClassDecl();
   case PredefinedDeclIDs.PREDEF_DECL_OBJC_PROTOCOL_ID:
    return Context.getObjCProtocolDecl();
   case PredefinedDeclIDs.PREDEF_DECL_INT_128_ID:
    return Context.getInt128Decl();
   case PredefinedDeclIDs.PREDEF_DECL_UNSIGNED_INT_128_ID:
    return Context.getUInt128Decl();
   case PredefinedDeclIDs.PREDEF_DECL_OBJC_INSTANCETYPE_ID:
    return Context.getObjCInstanceTypeDecl();
   case PredefinedDeclIDs.PREDEF_DECL_BUILTIN_VA_LIST_ID:
    return Context.getBuiltinVaListDecl();
   case PredefinedDeclIDs.PREDEF_DECL_VA_LIST_TAG:
    return Context.getVaListTagDecl();
   case PredefinedDeclIDs.PREDEF_DECL_BUILTIN_MS_VA_LIST_ID:
    return Context.getBuiltinMSVaListDecl();
   case PredefinedDeclIDs.PREDEF_DECL_EXTERN_C_CONTEXT_ID:
    return Context.getExternCContextDecl();
   case PredefinedDeclIDs.PREDEF_DECL_MAKE_INTEGER_SEQ_ID:
    return Context.getMakeIntegerSeqDecl();
   case PredefinedDeclIDs.PREDEF_DECL_CF_CONSTANT_STRING_ID:
    return Context.getCFConstantStringDecl();
   case PredefinedDeclIDs.PREDEF_DECL_CF_CONSTANT_STRING_TAG_ID:
    return Context.getCFConstantStringTagDecl();
   case PredefinedDeclIDs.PREDEF_DECL_TYPE_PACK_ELEMENT_ID:
    return Context.getTypePackElementDecl();
  }
  throw new llvm_unreachable("PredefinedDeclIDs unknown enum value");
}


/// \brief Under non-PCH compilation the consumer receives the objc methods
/// before receiving the implementation, and codegen depends on this.
/// We simulate this by deserializing and passing to consumer the methods of the
/// implementation before passing the deserialized implementation decl.
//<editor-fold defaultstate="collapsed" desc="PassObjCImplDeclToConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6699,
 FQN="PassObjCImplDeclToConsumer", NM="_ZL26PassObjCImplDeclToConsumerPN5clang12ObjCImplDeclEPNS_11ASTConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL26PassObjCImplDeclToConsumerPN5clang12ObjCImplDeclEPNS_11ASTConsumerE")
//</editor-fold>
public static void PassObjCImplDeclToConsumer(ObjCImplDecl /*P*/ ImplD, 
                          ASTConsumer /*P*/ Consumer) {
  assert ((ImplD != null) && (Consumer != null));
  
  for (ObjCMethodDecl /*P*/ I : ImplD.methods())  {
    Consumer.HandleInterestingDecl(new DeclGroupRef(I));
  }
  
  Consumer.HandleInterestingDecl(new DeclGroupRef(ImplD));
}

//template <typename Key = unsigned long long, typename ModuleFile = ModuleFile, unsigned int InitialCapacity = 4> 
//<editor-fold defaultstate="collapsed" desc="dumpModuleIDMap">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6851,
 FQN="dumpModuleIDMap", NM="_ZL15dumpModuleIDMapIyN5clang13serialization10ModuleFileELj4EEvN4llvm9StringRefERKNS0_18ContinuousRangeMapIT_PT0_XT1_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL15dumpModuleIDMapIyN5clang13serialization10ModuleFileELj4EEvN4llvm9StringRefERKNS0_18ContinuousRangeMapIT_PT0_XT1_EEE")
//</editor-fold>
public static void dumpModuleIDMap(/*uint*/int InitialCapacity, StringRef Name, 
               final /*const*/ ContinuousRangeMapULongPtr<ModuleFile> Map) {
  if ($eq_ptr(Map.begin$Const(), Map.end$Const())) {
    return;
  }
  
  // JAVA: typedef ContinuousRangeMap<unsigned long long, ModuleFile *, InitialCapacityU> MapType
//  final class MapType extends ContinuousRangeMap/*<InitialCapacity</*ullong*/long, ModuleFile /*P*/ >/*U*/>*/{ };
  llvm.errs().$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/$COLON_LF);
  for (type$ptr</*const*/std.pairULongPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(Map.begin$Const()), /*P*/ IEnd = $tryClone(Map.end$Const());
       $noteq_ptr(I, IEnd); I.$preInc()) {
    llvm.errs().$out(/*KEEP_STR*/"  ").$out_ullong(I./*->*/$star().first).$out(/*KEEP_STR*/" -> ").$out(I./*->*/$star().second.FileName).$out(
        /*KEEP_STR*/$LF
    );
  }
}
//template <typename Key = unsigned int, typename ModuleFile = ModuleFile, unsigned int InitialCapacity = 64> 
//<editor-fold defaultstate="collapsed" desc="dumpModuleIDMap">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6851,
 FQN="dumpModuleIDMap", NM="_ZL15dumpModuleIDMapIjN5clang13serialization10ModuleFileELj64EEvN4llvm9StringRefERKNS0_18ContinuousRangeMapIT_PT0_XT1_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL15dumpModuleIDMapIjN5clang13serialization10ModuleFileELj64EEvN4llvm9StringRefERKNS0_18ContinuousRangeMapIT_PT0_XT1_EEE")
//</editor-fold>
public static void dumpModuleIDMap(/*uint*/int InitialCapacity, StringRef Name, 
               final /*const*/ ContinuousRangeMapUIntPtr<ModuleFile> Map) {
  if ($eq_ptr(Map.begin(), Map.end())) {
    return;
  }
  
  // JAVA: typedef ContinuousRangeMap<unsigned int, ModuleFile *, InitialCapacityU> MapType
//  final class MapType extends ContinuousRangeMap/*<InitialCapacity</*uint*/int, ModuleFile /*P*/ >/*U*/>*/{ };
  llvm.errs().$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/$COLON_LF);
  for (type$ptr</*const*/std.pairUIntPtr<ModuleFile /*P*/ > /*P*/> I = $tryClone(Map.begin$Const()), /*P*/ IEnd = $tryClone(Map.end$Const());
       $noteq_ptr(I, IEnd); I.$preInc()) {
    llvm.errs().$out(/*KEEP_STR*/"  ").$out_uint(I./*->*/$star().first).$out(/*KEEP_STR*/" -> ").$out(I./*->*/$star().second.FileName).$out(
        /*KEEP_STR*/$LF
    );
  }
}
/*template <typename Key, typename ModuleFile, unsigned int InitialCapacity> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="dumpModuleIDMap">
//@Converted(kind = Converted.Kind.DELETED,
// source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6851,
// FQN="dumpModuleIDMap", NM="Tpl__ZL15dumpModuleIDMapN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_PT0_XT1_EEE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZL15dumpModuleIDMapN4llvm9StringRefERKN5clang18ContinuousRangeMapIT_PT0_XT1_EEE")
////</editor-fold>
//public static </*typename*/ Key, /*typename*/ ModuleFile> void dumpModuleIDMap(/*uint*/int InitialCapacity, StringRef Name, 
//               final /*const*/ ContinuousRangeMap<Key, ModuleFile /*P*/ >/*<InitialCapacity>*/ /*&*/ Map) {
//  if (Native.$eq(Map.begin(), Map.end())) {
//    return;
//  }
//  
//  // JAVA: typedef ContinuousRangeMap<Key, ModuleFile *, InitialCapacity> MapType
////  final class MapType extends ContinuousRangeMap<Key, ModuleFile /*P*/ >/*<InitialCapacity>*/{ };
//  llvm.errs().$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/$COLON_LF);
//  for ( ContinuousRangeMap/*<InitialCapacity>*/.const_iterator<Key, ModuleFile /*P*/ > I = Map.begin(), IEnd = Map.end();
//       Native.$noteq(I, IEnd); I.$preInc()) {
//    Native.$out(Native.$out(Native.$out(Native.$out(llvm.errs().$out(/*KEEP_STR*/"  "), I.first), $(" -> ")), I.second.FileName), 
//        $LF);
//  }
//}


// end namespace clang::serialization

/// \brief Add the given set of methods to the method list.
//<editor-fold defaultstate="collapsed" desc="addMethodsToPool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 7173,
 FQN="addMethodsToPool", NM="_ZL16addMethodsToPoolRN5clang4SemaEN4llvm8ArrayRefIPNS_14ObjCMethodDeclEEERNS_14ObjCMethodListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZL16addMethodsToPoolRN5clang4SemaEN4llvm8ArrayRefIPNS_14ObjCMethodDeclEEERNS_14ObjCMethodListE")
//</editor-fold>
public static void addMethodsToPool(final Sema /*&*/ S, ArrayRef<ObjCMethodDecl /*P*/ > Methods, 
                final ObjCMethodList /*&*/ List) {
  for (/*uint*/int I = 0, N = Methods.size(); I != N; ++I) {
    S.addMethodToGlobalList($AddrOf(List), Methods.$at(I));
  }
}

} // END OF class ASTReaderStatics
