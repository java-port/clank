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

import org.clang.frontend.PCHContainerReader;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.target.TargetInfo;
import static org.clang.config.config.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import org.clang.frontend.*;


//<editor-fold defaultstate="collapsed" desc="static type InitPreprocessorStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=Tpl__ZL6PickFPPKN4llvm12fltSemanticsET_S3_S3_S3_S3_;_ZL10DefineTypeRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERNS3_12MacroBuilderE;_ZL14DefineTypeSizeRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERKS4_RNS3_12MacroBuilderE;_ZL14DefineTypeSizeRKN4llvm5TwineEjNS_9StringRefEbRN5clang12MacroBuilderE;_ZL15DefineTypeWidthN4llvm9StringRefEN5clang10TargetInfo7IntTypeERKS2_RNS1_12MacroBuilderE;_ZL16DefineTypeSizeofN4llvm9StringRefEjRKN5clang10TargetInfoERNS1_12MacroBuilderE;_ZL16getLockFreeValuejjj;_ZL17DefineFastIntTypejbRKN5clang10TargetInfoERNS_12MacroBuilderE;_ZL17DefineFloatMacrosRN5clang12MacroBuilderEN4llvm9StringRefEPKNS2_12fltSemanticsES3_;_ZL18AddImplicitIncludeRN5clang12MacroBuilderEN4llvm9StringRefE;_ZL18DefineBuiltinMacroRN5clang12MacroBuilderEN4llvm9StringRefERNS_17DiagnosticsEngineE;_ZL21AddImplicitIncludePCHRN5clang12MacroBuilderERNS_12PreprocessorERKNS_18PCHContainerReaderEN4llvm9StringRefE;_ZL21AddImplicitIncludePTHRN5clang12MacroBuilderERNS_12PreprocessorEN4llvm9StringRefE;_ZL23DefineExactWidthIntTypeN5clang10TargetInfo7IntTypeERKS0_RNS_12MacroBuilderE;_ZL23DefineLeastWidthIntTypejbRKN5clang10TargetInfoERNS_12MacroBuilderE;_ZL24AddImplicitIncludeMacrosRN5clang12MacroBuilderEN4llvm9StringRefE;_ZL24MacroBodyEndsInBackslashN4llvm9StringRefE;_ZL26InitializePredefinedMacrosRKN5clang10TargetInfoERKNS_11LangOptionsERKNS_15FrontendOptionsERNS_12MacroBuilderE;_ZL27DefineExactWidthIntTypeSizeN5clang10TargetInfo7IntTypeERKS0_RNS_12MacroBuilderE;_ZL28AddObjCXXARCLibstdcxxDefinesRKN5clang11LangOptionsERNS_12MacroBuilderE;_ZL34InitializeStandardPredefinedMacrosRKN5clang10TargetInfoERKNS_11LangOptionsERKNS_15FrontendOptionsERNS_12MacroBuilderE;_ZL36InitializeCPlusPlusFeatureTestMacrosRKN5clang11LangOptionsERNS_12MacroBuilderE;_ZL9DefineFmtRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERKS4_RNS3_12MacroBuilderE; -static-type=InitPreprocessorStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class InitPreprocessorStatics {

//<editor-fold defaultstate="collapsed" desc="MacroBodyEndsInBackslash">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 33,
 FQN="MacroBodyEndsInBackslash", NM="_ZL24MacroBodyEndsInBackslashN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL24MacroBodyEndsInBackslashN4llvm9StringRefE")
//</editor-fold>
public static boolean MacroBodyEndsInBackslash(StringRef MacroBody) {
  while (!MacroBody.empty() && isWhitespace(MacroBody.back())) {
    MacroBody.$assignMove(MacroBody.drop_back());
  }
  return !MacroBody.empty() && MacroBody.back() == $$BACK_SLASH;
}


// Append a #define line to Buf for Macro.  Macro should be of the form XXX,
// in which case we emit "#define XXX 1" or "XXX=Y z W" in which case we emit
// "#define XXX Y z W".  To get a #define with no value, use "XXX=".
//<editor-fold defaultstate="collapsed" desc="DefineBuiltinMacro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 42,
 FQN="DefineBuiltinMacro", NM="_ZL18DefineBuiltinMacroRN5clang12MacroBuilderEN4llvm9StringRefERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL18DefineBuiltinMacroRN5clang12MacroBuilderEN4llvm9StringRefERNS_17DiagnosticsEngineE")
//</editor-fold>
public static void DefineBuiltinMacro(MacroBuilder /*&*/ Builder, StringRef Macro, 
                  DiagnosticsEngine /*&*/ Diags) {
  std.pair<StringRef, StringRef> MacroPair = Macro.split($$EQ);
  StringRef MacroName = new StringRef(MacroPair.first);
  StringRef MacroBody = new StringRef(MacroPair.second);
  if (MacroName.size() != Macro.size()) {
    // Per GCC -D semantics, the macro ends at \n if it exists.
    /*size_t*/int End = MacroBody.find_first_of(/*STRINGREF_STR*/"\n\015");
    if (End != StringRef.npos) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.warn_fe_macro_contains_embedded_newline)), 
            /*NO_COPY*/MacroName));
      } finally {
        $c$.$destroy();
      }
    }
    MacroBody.$assignMove(MacroBody.substr(0, End));
    // We handle macro bodies which end in a backslash by appending an extra
    // backslash+newline.  This makes sure we don't accidentally treat the
    // backslash as a line continuation marker.
    if (MacroBodyEndsInBackslash(new StringRef(MacroBody))) {
      Builder.defineMacro(new Twine(MacroName), $add_Twine$C(new Twine(MacroBody), new Twine(/*KEEP_STR*/"\\\n")));
    } else {
      Builder.defineMacro(new Twine(MacroName), new Twine(MacroBody));
    }
  } else {
    // Push "macroname 1".
    Builder.defineMacro(new Twine(Macro));
  }
}


/// AddImplicitInclude - Add an implicit \#include of the specified file to the
/// predefines buffer.
/// As these includes are generated by -include arguments the header search
/// logic is going to search relatively to the current working directory.
//<editor-fold defaultstate="collapsed" desc="AddImplicitInclude">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 71,
 FQN="AddImplicitInclude", NM="_ZL18AddImplicitIncludeRN5clang12MacroBuilderEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL18AddImplicitIncludeRN5clang12MacroBuilderEN4llvm9StringRefE")
//</editor-fold>
public static void AddImplicitInclude(MacroBuilder /*&*/ Builder, StringRef File) {
  Builder.append($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"#include \""), new Twine(File)), new Twine(/*KEEP_STR*/$DBL_QUOTE)));
}

//<editor-fold defaultstate="collapsed" desc="AddImplicitIncludeMacros">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 75,
 FQN="AddImplicitIncludeMacros", NM="_ZL24AddImplicitIncludeMacrosRN5clang12MacroBuilderEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL24AddImplicitIncludeMacrosRN5clang12MacroBuilderEN4llvm9StringRefE")
//</editor-fold>
public static void AddImplicitIncludeMacros(MacroBuilder /*&*/ Builder, StringRef File) {
  Builder.append($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"#__include_macros \""), new Twine(File)), new Twine(/*KEEP_STR*/$DBL_QUOTE)));
  // Marker token to stop the __include_macros fetch loop.
  Builder.append(new Twine(/*KEEP_STR*/$HASH_HASH)); // ##?
}


/// AddImplicitIncludePTH - Add an implicit \#include using the original file
/// used to generate a PTH cache.
//<editor-fold defaultstate="collapsed" desc="AddImplicitIncludePTH">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 83,
 FQN="AddImplicitIncludePTH", NM="_ZL21AddImplicitIncludePTHRN5clang12MacroBuilderERNS_12PreprocessorEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL21AddImplicitIncludePTHRN5clang12MacroBuilderERNS_12PreprocessorEN4llvm9StringRefE")
//</editor-fold>
public static void AddImplicitIncludePTH(MacroBuilder /*&*/ Builder, Preprocessor /*&*/ PP, 
                     StringRef ImplicitIncludePTH) {
  PTHManager /*P*/ P = PP.getPTHManager();
  // Null check 'P' in the corner case where it couldn't be created.
  /*const*/char$ptr/*char P*/ OriginalFile = $tryClone((P != null) ? P.getOriginalSourceFile() : null);
  if (!(OriginalFile != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.getDiagnostics().Report(diag.err_fe_pth_file_has_no_source_header)), 
          /*NO_COPY*/ImplicitIncludePTH));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  AddImplicitInclude(Builder, new StringRef(OriginalFile));
}


/// \brief Add an implicit \#include using the original file used to generate
/// a PCH file.
//<editor-fold defaultstate="collapsed" desc="AddImplicitIncludePCH">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 100,
 FQN="AddImplicitIncludePCH", NM="_ZL21AddImplicitIncludePCHRN5clang12MacroBuilderERNS_12PreprocessorERKNS_18PCHContainerReaderEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL21AddImplicitIncludePCHRN5clang12MacroBuilderERNS_12PreprocessorERKNS_18PCHContainerReaderEN4llvm9StringRefE")
//</editor-fold>
public static void AddImplicitIncludePCH(MacroBuilder /*&*/ Builder, Preprocessor /*&*/ PP, 
                     /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                     StringRef ImplicitIncludePCH) {
  std.string OriginalFile = ASTReader.getOriginalSourceFile(ImplicitIncludePCH.$string(), PP.getFileManager(), 
      PCHContainerRdr, PP.getDiagnostics());
  if (OriginalFile.empty()) {
    return;
  }
  
  AddImplicitInclude(Builder, new StringRef(OriginalFile));
}


/// PickFP - This is used to pick a value based on the FP semantics of the
/// specified FP model.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="PickFP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 115,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", old_line = 114,
 FQN="PickFP", NM="Tpl__ZL6PickFPPKN4llvm12fltSemanticsET_S3_S3_S3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=Tpl__ZL6PickFPPKN4llvm12fltSemanticsET_S3_S3_S3_S3_")
//</editor-fold>
public static </*typename*/ T> T PickFP(/*const*/ fltSemantics /*P*/ Sem, T IEEESingleVal, 
      T IEEEDoubleVal, T X87DoubleExtendedVal, T PPCDoubleDoubleVal, 
      T IEEEQuadVal) {
  if (Sem == (/*const*/ fltSemantics /*P*/ )/*AddrOf*/APFloat.IEEEsingle) {
    return IEEESingleVal;
  }
  if (Sem == (/*const*/ fltSemantics /*P*/ )/*AddrOf*/APFloat.IEEEdouble) {
    return IEEEDoubleVal;
  }
  if (Sem == (/*const*/ fltSemantics /*P*/ )/*AddrOf*/APFloat.x87DoubleExtended) {
    return X87DoubleExtendedVal;
  }
  if (Sem == (/*const*/ fltSemantics /*P*/ )/*AddrOf*/APFloat.PPCDoubleDouble) {
    return PPCDoubleDoubleVal;
  }
  assert (Sem == (/*const*/ fltSemantics /*P*/ )/*AddrOf*/APFloat.IEEEquad);
  return IEEEQuadVal;
}

//<editor-fold defaultstate="collapsed" desc="DefineFloatMacros">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 130,
 FQN="DefineFloatMacros", NM="_ZL17DefineFloatMacrosRN5clang12MacroBuilderEN4llvm9StringRefEPKNS2_12fltSemanticsES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL17DefineFloatMacrosRN5clang12MacroBuilderEN4llvm9StringRefEPKNS2_12fltSemanticsES3_")
//</editor-fold>
public static void DefineFloatMacros(MacroBuilder /*&*/ Builder, StringRef Prefix, 
                 /*const*/ fltSemantics /*P*/ Sem, StringRef Ext) {
  /*const*/String/*char P*/ DenormMin, /*P*/ Epsilon, /*P*/ Max, /*P*/ Min;
  DenormMin = $tryClone(PickFP(Sem, /*KEEP_STR*/"1.40129846e-45", /*KEEP_STR*/"4.9406564584124654e-324", 
      /*KEEP_STR*/"3.64519953188247460253e-4951", 
      /*KEEP_STR*/"4.94065645841246544176568792868221e-324", 
      /*KEEP_STR*/"6.47517511943802511092443895822764655e-4966"));
  int Digits = PickFP(Sem, 6, 15, 18, 31, 33);
  int DecimalDigits = PickFP(Sem, 9, 17, 21, 33, 36);
  Epsilon = $tryClone(PickFP(Sem, /*KEEP_STR*/"1.19209290e-7", /*KEEP_STR*/"2.2204460492503131e-16", 
      /*KEEP_STR*/"1.08420217248550443401e-19", 
      /*KEEP_STR*/"4.94065645841246544176568792868221e-324", 
      /*KEEP_STR*/"1.92592994438723585305597794258492732e-34"));
  int MantissaDigits = PickFP(Sem, 24, 53, 64, 106, 113);
  int Min10Exp = PickFP(Sem, -37, -307, -4931, -291, -4931);
  int Max10Exp = PickFP(Sem, 38, 308, 4932, 308, 4932);
  int MinExp = PickFP(Sem, -125, -1021, -16381, -968, -16381);
  int MaxExp = PickFP(Sem, 128, 1024, 16384, 1024, 16384);
  Min = $tryClone(PickFP(Sem, /*KEEP_STR*/"1.17549435e-38", /*KEEP_STR*/"2.2250738585072014e-308", 
      /*KEEP_STR*/"3.36210314311209350626e-4932", 
      /*KEEP_STR*/"2.00416836000897277799610805135016e-292", 
      /*KEEP_STR*/"3.36210314311209350626267781732175260e-4932"));
  Max = $tryClone(PickFP(Sem, /*KEEP_STR*/"3.40282347e+38", /*KEEP_STR*/"1.7976931348623157e+308", 
      /*KEEP_STR*/"1.18973149535723176502e+4932", 
      /*KEEP_STR*/"1.79769313486231580793728971405301e+308", 
      /*KEEP_STR*/"1.18973149535723176508575932662800702e+4932"));
  
  SmallString/*32*/ DefPrefix/*J*/= new SmallString/*32*/(32);
  DefPrefix.$assign(/*STRINGREF_STR*/"__");
  DefPrefix.$addassign(/*NO_COPY*/Prefix);
  DefPrefix.$addassign(/*STRINGREF_STR*/"_");
  
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"DENORM_MIN__"), $add_Twine$C(new Twine(DenormMin), new Twine(Ext)));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"HAS_DENORM__"));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"DIG__"), new Twine(JD$Int.INSTANCE, Digits));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"DECIMAL_DIG__"), new Twine(JD$Int.INSTANCE, DecimalDigits));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"EPSILON__"), $add_Twine$C(new Twine(Epsilon), new Twine(Ext)));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"HAS_INFINITY__"));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"HAS_QUIET_NAN__"));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"MANT_DIG__"), new Twine(JD$Int.INSTANCE, MantissaDigits));
  
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"MAX_10_EXP__"), new Twine(JD$Int.INSTANCE, Max10Exp));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"MAX_EXP__"), new Twine(JD$Int.INSTANCE, MaxExp));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"MAX__"), $add_Twine$C(new Twine(Max), new Twine(Ext)));
  
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"MIN_10_EXP__"), $add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/$LPAREN), new Twine(JD$Int.INSTANCE, Min10Exp)), new Twine(/*KEEP_STR*/$RPAREN)));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"MIN_EXP__"), $add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/$LPAREN), new Twine(JD$Int.INSTANCE, MinExp)), new Twine(/*KEEP_STR*/$RPAREN)));
  Builder.defineMacro($add_StringRef$C_char$ptr$C(DefPrefix.$StringRef(), /*KEEP_STR*/"MIN__"), $add_Twine$C(new Twine(Min), new Twine(Ext)));
}


/// DefineTypeSize - Emit a macro to the predefines buffer that declares a macro
/// named MacroName with the max value for a type with width 'TypeWidth' a
/// signedness of 'isSigned' and with a value suffix of 'ValSuffix' (e.g. LL).
//<editor-fold defaultstate="collapsed" desc="DefineTypeSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 184,
 FQN="DefineTypeSize", NM="_ZL14DefineTypeSizeRKN4llvm5TwineEjNS_9StringRefEbRN5clang12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL14DefineTypeSizeRKN4llvm5TwineEjNS_9StringRefEbRN5clang12MacroBuilderE")
//</editor-fold>
public static void DefineTypeSize(/*const*/ Twine /*&*/ MacroName, /*uint*/int TypeWidth, 
              StringRef ValSuffix, boolean isSigned, 
              MacroBuilder /*&*/ Builder) {
  APInt MaxVal = isSigned ? APInt.getSignedMaxValue(TypeWidth) : APInt.getMaxValue(TypeWidth);
  Builder.defineMacro(MacroName, $add_Twine$C(new Twine(MaxVal.__toString(10, isSigned)), new Twine(ValSuffix)));
}


/// DefineTypeSize - An overloaded helper that uses TargetInfo to determine
/// the width, suffix, and signedness of the given type
//<editor-fold defaultstate="collapsed" desc="DefineTypeSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 194,
 FQN="DefineTypeSize", NM="_ZL14DefineTypeSizeRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERKS4_RNS3_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL14DefineTypeSizeRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERKS4_RNS3_12MacroBuilderE")
//</editor-fold>
public static void DefineTypeSize(/*const*/ Twine /*&*/ MacroName, TargetInfo.IntType Ty, 
              /*const*/ TargetInfo /*&*/ TI, MacroBuilder /*&*/ Builder) {
  DefineTypeSize(MacroName, TI.getTypeWidth(Ty), new StringRef(TI.getTypeConstantSuffix(Ty)), 
      TI.isTypeSigned(Ty), Builder);
}

//<editor-fold defaultstate="collapsed" desc="DefineFmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 200,
 FQN="DefineFmt", NM="_ZL9DefineFmtRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERKS4_RNS3_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL9DefineFmtRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERKS4_RNS3_12MacroBuilderE")
//</editor-fold>
public static void DefineFmt(/*const*/ Twine /*&*/ Prefix, TargetInfo.IntType Ty, 
         /*const*/ TargetInfo /*&*/ TI, MacroBuilder /*&*/ Builder) {
  boolean IsSigned = TI.isTypeSigned(Ty);
  StringRef FmtModifier = new StringRef(TI.getTypeFormatModifier(Ty));
  for (/*const*/char$ptr/*char P*/ Fmt = $tryClone(IsSigned ? $("di") : $("ouxX")); (Fmt.$star() != 0); Fmt.$preInc()) {
    Builder.defineMacro($add_Twine$C($add_Twine$C($add_Twine$C(Prefix, new Twine(/*KEEP_STR*/"_FMT")), new Twine(JD$Char.INSTANCE, Fmt.$star())), new Twine(/*KEEP_STR*/"__")), 
        $add_Twine$C($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/$DBL_QUOTE), new Twine(FmtModifier)), new Twine(JD$Char.INSTANCE, Fmt.$star())), new Twine(/*KEEP_STR*/$DBL_QUOTE)));
  }
}

//<editor-fold defaultstate="collapsed" desc="DefineType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 210,
 FQN="DefineType", NM="_ZL10DefineTypeRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERNS3_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL10DefineTypeRKN4llvm5TwineEN5clang10TargetInfo7IntTypeERNS3_12MacroBuilderE")
//</editor-fold>
public static void DefineType(/*const*/ Twine /*&*/ MacroName, TargetInfo.IntType Ty, 
          MacroBuilder /*&*/ Builder) {
  Builder.defineMacro(MacroName, new Twine(TargetInfo.getTypeName(Ty)));
}

//<editor-fold defaultstate="collapsed" desc="DefineTypeWidth">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 215,
 FQN="DefineTypeWidth", NM="_ZL15DefineTypeWidthN4llvm9StringRefEN5clang10TargetInfo7IntTypeERKS2_RNS1_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL15DefineTypeWidthN4llvm9StringRefEN5clang10TargetInfo7IntTypeERKS2_RNS1_12MacroBuilderE")
//</editor-fold>
public static void DefineTypeWidth(StringRef MacroName, TargetInfo.IntType Ty, 
               /*const*/ TargetInfo /*&*/ TI, MacroBuilder /*&*/ Builder) {
  Builder.defineMacro(new Twine(MacroName), new Twine(JD$UInt.INSTANCE, TI.getTypeWidth(Ty)));
}

//<editor-fold defaultstate="collapsed" desc="DefineTypeSizeof">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 220,
 FQN="DefineTypeSizeof", NM="_ZL16DefineTypeSizeofN4llvm9StringRefEjRKN5clang10TargetInfoERNS1_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL16DefineTypeSizeofN4llvm9StringRefEjRKN5clang10TargetInfoERNS1_12MacroBuilderE")
//</editor-fold>
public static void DefineTypeSizeof(StringRef MacroName, /*uint*/int BitWidth, 
                /*const*/ TargetInfo /*&*/ TI, MacroBuilder /*&*/ Builder) {
  Builder.defineMacro(new Twine(MacroName), 
      new Twine(JD$UInt.INSTANCE, BitWidth / TI.getCharWidth()));
}

//<editor-fold defaultstate="collapsed" desc="DefineExactWidthIntType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 226,
 FQN="DefineExactWidthIntType", NM="_ZL23DefineExactWidthIntTypeN5clang10TargetInfo7IntTypeERKS0_RNS_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL23DefineExactWidthIntTypeN5clang10TargetInfo7IntTypeERKS0_RNS_12MacroBuilderE")
//</editor-fold>
public static void DefineExactWidthIntType(TargetInfo.IntType Ty, 
                       /*const*/ TargetInfo /*&*/ TI, 
                       MacroBuilder /*&*/ Builder) {
  int TypeWidth = TI.getTypeWidth(Ty);
  boolean IsSigned = TI.isTypeSigned(Ty);
  
  // Use the target specified int64 type, when appropriate, so that [u]int64_t
  // ends up being defined in terms of the correct type.
  if (TypeWidth == 64) {
    Ty = IsSigned ? TI.getInt64Type() : TI.getUInt64Type();
  }
  
  /*const*/char$ptr/*char P*/ Prefix = $tryClone(IsSigned ? $("__INT") : $("__UINT"));
  
  DefineType($add_Twine$C($add_Twine$C(new Twine(Prefix), new Twine(JD$Int.INSTANCE, TypeWidth)), new Twine(/*KEEP_STR*/"_TYPE__")), Ty, Builder);
  DefineFmt($add_Twine$C(new Twine(Prefix), new Twine(JD$Int.INSTANCE, TypeWidth)), Ty, TI, Builder);
  
  StringRef ConstSuffix/*J*/= new StringRef(TI.getTypeConstantSuffix(Ty));
  Builder.defineMacro($add_Twine$C($add_Twine$C(new Twine(Prefix), new Twine(JD$Int.INSTANCE, TypeWidth)), new Twine(/*KEEP_STR*/"_C_SUFFIX__")), new Twine(ConstSuffix));
}

//<editor-fold defaultstate="collapsed" desc="DefineExactWidthIntTypeSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 246,
 FQN="DefineExactWidthIntTypeSize", NM="_ZL27DefineExactWidthIntTypeSizeN5clang10TargetInfo7IntTypeERKS0_RNS_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL27DefineExactWidthIntTypeSizeN5clang10TargetInfo7IntTypeERKS0_RNS_12MacroBuilderE")
//</editor-fold>
public static void DefineExactWidthIntTypeSize(TargetInfo.IntType Ty, 
                           /*const*/ TargetInfo /*&*/ TI, 
                           MacroBuilder /*&*/ Builder) {
  int TypeWidth = TI.getTypeWidth(Ty);
  boolean IsSigned = TI.isTypeSigned(Ty);
  
  // Use the target specified int64 type, when appropriate, so that [u]int64_t
  // ends up being defined in terms of the correct type.
  if (TypeWidth == 64) {
    Ty = IsSigned ? TI.getInt64Type() : TI.getUInt64Type();
  }
  
  /*const*/char$ptr/*char P*/ Prefix = $tryClone(IsSigned ? $("__INT") : $("__UINT"));
  DefineTypeSize($add_Twine$C($add_Twine$C(new Twine(Prefix), new Twine(JD$Int.INSTANCE, TypeWidth)), new Twine(/*KEEP_STR*/"_MAX__")), Ty, TI, Builder);
}

//<editor-fold defaultstate="collapsed" desc="DefineLeastWidthIntType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 261,
 FQN="DefineLeastWidthIntType", NM="_ZL23DefineLeastWidthIntTypejbRKN5clang10TargetInfoERNS_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL23DefineLeastWidthIntTypejbRKN5clang10TargetInfoERNS_12MacroBuilderE")
//</editor-fold>
public static void DefineLeastWidthIntType(/*uint*/int TypeWidth, boolean IsSigned, 
                       /*const*/ TargetInfo /*&*/ TI, 
                       MacroBuilder /*&*/ Builder) {
  TargetInfo.IntType Ty = TI.getLeastIntTypeByWidth(TypeWidth, IsSigned);
  if (Ty == TargetInfo.IntType.NoInt) {
    return;
  }
  
  /*const*/char$ptr/*char P*/ Prefix = $tryClone(IsSigned ? $("__INT_LEAST") : $("__UINT_LEAST"));
  DefineType($add_Twine$C($add_Twine$C(new Twine(Prefix), new Twine(JD$UInt.INSTANCE, TypeWidth)), new Twine(/*KEEP_STR*/"_TYPE__")), Ty, Builder);
  DefineTypeSize($add_Twine$C($add_Twine$C(new Twine(Prefix), new Twine(JD$UInt.INSTANCE, TypeWidth)), new Twine(/*KEEP_STR*/"_MAX__")), Ty, TI, Builder);
  DefineFmt($add_Twine$C(new Twine(Prefix), new Twine(JD$UInt.INSTANCE, TypeWidth)), Ty, TI, Builder);
}

//<editor-fold defaultstate="collapsed" desc="DefineFastIntType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 274,
 FQN="DefineFastIntType", NM="_ZL17DefineFastIntTypejbRKN5clang10TargetInfoERNS_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL17DefineFastIntTypejbRKN5clang10TargetInfoERNS_12MacroBuilderE")
//</editor-fold>
public static void DefineFastIntType(/*uint*/int TypeWidth, boolean IsSigned, 
                 /*const*/ TargetInfo /*&*/ TI, MacroBuilder /*&*/ Builder) {
  // stdint.h currently defines the fast int types as equivalent to the least
  // types.
  TargetInfo.IntType Ty = TI.getLeastIntTypeByWidth(TypeWidth, IsSigned);
  if (Ty == TargetInfo.IntType.NoInt) {
    return;
  }
  
  /*const*/char$ptr/*char P*/ Prefix = $tryClone(IsSigned ? $("__INT_FAST") : $("__UINT_FAST"));
  DefineType($add_Twine$C($add_Twine$C(new Twine(Prefix), new Twine(JD$UInt.INSTANCE, TypeWidth)), new Twine(/*KEEP_STR*/"_TYPE__")), Ty, Builder);
  DefineTypeSize($add_Twine$C($add_Twine$C(new Twine(Prefix), new Twine(JD$UInt.INSTANCE, TypeWidth)), new Twine(/*KEEP_STR*/"_MAX__")), Ty, TI, Builder);
  
  DefineFmt($add_Twine$C(new Twine(Prefix), new Twine(JD$UInt.INSTANCE, TypeWidth)), Ty, TI, Builder);
}


/// Get the value the ATOMIC_*_LOCK_FREE macro should have for a type with
/// the specified properties.
//<editor-fold defaultstate="collapsed" desc="getLockFreeValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 292,
 FQN="getLockFreeValue", NM="_ZL16getLockFreeValuejjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL16getLockFreeValuejjj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getLockFreeValue(/*uint*/int TypeWidth, /*uint*/int TypeAlign, 
                /*uint*/int InlineWidth) {
  // Fully-aligned, power-of-2 sizes no larger than the inline
  // width will be inlined as lock-free operations.
  if (TypeWidth == TypeAlign && (TypeWidth & (TypeWidth - 1)) == 0
     && $lesseq_uint(TypeWidth, InlineWidth)) {
    return $2; // "always lock free"
    // We cannot be certain what operations the lib calls might be
    // able to implement as lock-free on future processors.
  }
  return $1; // "sometimes lock free"
}


/// \brief Add definitions required for a smooth interaction between
/// Objective-C++ automated reference counting and libstdc++ (4.2).
//<editor-fold defaultstate="collapsed" desc="AddObjCXXARCLibstdcxxDefines">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 306,
 FQN="AddObjCXXARCLibstdcxxDefines", NM="_ZL28AddObjCXXARCLibstdcxxDefinesRKN5clang11LangOptionsERNS_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL28AddObjCXXARCLibstdcxxDefinesRKN5clang11LangOptionsERNS_12MacroBuilderE")
//</editor-fold>
public static void AddObjCXXARCLibstdcxxDefines(/*const*/ LangOptions /*&*/ LangOpts, 
                            MacroBuilder /*&*/ Builder) {
  Builder.defineMacro(new Twine(/*KEEP_STR*/"_GLIBCXX_PREDEFINED_OBJC_ARC_IS_SCALAR"));
  
  std.string Result/*J*/= new std.string();
  {
    raw_string_ostream Out = null;
    try {
      // Provide specializations for the __is_scalar type trait so that 
      // lifetime-qualified objects are not considered "scalar" types, which
      // libstdc++ uses as an indicator of the presence of trivial copy, assign,
      // default-construct, and destruct semantics (none of which hold for
      // lifetime-qualified objects in ARC).
      Out/*J*/= new raw_string_ostream(Result);
      
      Out.$out(/*KEEP_STR*/"namespace std {\n").$out(
          /*KEEP_STR*/$LF
      ).$out(
          /*KEEP_STR*/"struct __true_type;\n"
      ).$out(
          /*KEEP_STR*/"struct __false_type;\n"
      ).$out(
          /*KEEP_STR*/$LF
      );
      
      Out.$out(/*KEEP_STR*/"template<typename _Tp> struct __is_scalar;\n").$out(
          /*KEEP_STR*/$LF
      );
      if (LangOpts.ObjCAutoRefCount) {
        Out.$out(/*KEEP_STR*/"template<typename _Tp>\n").$out(
            /*KEEP_STR*/"struct __is_scalar<__attribute__((objc_ownership(strong))) _Tp> {\n"
        ).$out(
            /*KEEP_STR*/"  enum { __value = 0 };\n"
        ).$out(
            /*KEEP_STR*/"  typedef __false_type __type;\n"
        ).$out(
            /*KEEP_STR*/"};\n"
        ).$out(
            /*KEEP_STR*/$LF
        );
      }
      if (LangOpts.ObjCWeak) {
        Out.$out(/*KEEP_STR*/"template<typename _Tp>\n").$out(
            /*KEEP_STR*/"struct __is_scalar<__attribute__((objc_ownership(weak))) _Tp> {\n"
        ).$out(
            /*KEEP_STR*/"  enum { __value = 0 };\n"
        ).$out(
            /*KEEP_STR*/"  typedef __false_type __type;\n"
        ).$out(
            /*KEEP_STR*/"};\n"
        ).$out(
            /*KEEP_STR*/$LF
        );
      }
      if (LangOpts.ObjCAutoRefCount) {
        Out.$out(/*KEEP_STR*/"template<typename _Tp>\n").$out(
            /*KEEP_STR*/"struct __is_scalar<__attribute__((objc_ownership(autoreleasing)))"
        ).$out(
            /*KEEP_STR*/" _Tp> {\n"
        ).$out(
            /*KEEP_STR*/"  enum { __value = 0 };\n"
        ).$out(
            /*KEEP_STR*/"  typedef __false_type __type;\n"
        ).$out(
            /*KEEP_STR*/"};\n"
        ).$out(
            /*KEEP_STR*/$LF
        );
      }
      
      Out.$out(/*KEEP_STR*/"}\n");
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }
  Builder.append(new Twine(Result));
}

//<editor-fold defaultstate="collapsed" desc="InitializeStandardPredefinedMacros">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 361,
 FQN="InitializeStandardPredefinedMacros", NM="_ZL34InitializeStandardPredefinedMacrosRKN5clang10TargetInfoERKNS_11LangOptionsERKNS_15FrontendOptionsERNS_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL34InitializeStandardPredefinedMacrosRKN5clang10TargetInfoERKNS_11LangOptionsERKNS_15FrontendOptionsERNS_12MacroBuilderE")
//</editor-fold>
public static void InitializeStandardPredefinedMacros(/*const*/ TargetInfo /*&*/ TI, 
                                  /*const*/ LangOptions /*&*/ LangOpts, 
                                  /*const*/ FrontendOptions /*&*/ FEOpts, 
                                  MacroBuilder /*&*/ Builder) {
  if (!LangOpts.MSVCCompat && !LangOpts.TraditionalCPP) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__STDC__"));
  }
  if (LangOpts.Freestanding) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__STDC_HOSTED__"), new Twine(/*KEEP_STR*/$0));
  } else {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__STDC_HOSTED__"));
  }
  if (!LangOpts.CPlusPlus) {
    if (LangOpts.C11) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__STDC_VERSION__"), new Twine(/*KEEP_STR*/"201112L"));
    } else if (LangOpts.C99) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__STDC_VERSION__"), new Twine(/*KEEP_STR*/"199901L"));
    } else if (!LangOpts.GNUMode && LangOpts.Digraphs) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__STDC_VERSION__"), new Twine(/*KEEP_STR*/"199409L"));
    }
  } else {
    // FIXME: Use correct value for C++17.
    if (LangOpts.CPlusPlus1z) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__cplusplus"), new Twine(/*KEEP_STR*/"201406L"));
    } else // C++1y [cpp.predefined]p1:
    //   The name __cplusplus is defined to the value 201402L when compiling a
    //   C++ translation unit.
    if (LangOpts.CPlusPlus14) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__cplusplus"), new Twine(/*KEEP_STR*/"201402L"));
    } else // C++11 [cpp.predefined]p1:
    //   The name __cplusplus is defined to the value 201103L when compiling a
    //   C++ translation unit.
    if (LangOpts.CPlusPlus11) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__cplusplus"), new Twine(/*KEEP_STR*/"201103L"));
    } else {
      // C++03 [cpp.predefined]p1:
      //   The name __cplusplus is defined to the value 199711L when compiling a
      //   C++ translation unit.
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__cplusplus"), new Twine(/*KEEP_STR*/"199711L"));
    }
  }
  
  // In C11 these are environment macros. In C++11 they are only defined
  // as part of <cuchar>. To prevent breakage when mixing C and C++
  // code, define these macros unconditionally. We can define them
  // unconditionally, as Clang always uses UTF-16 and UTF-32 for 16-bit
  // and 32-bit character literals.
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__STDC_UTF_16__"), new Twine(/*KEEP_STR*/$1));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__STDC_UTF_32__"), new Twine(/*KEEP_STR*/$1));
  if (LangOpts.ObjC1) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__OBJC__"));
  }
  
  // OpenCL v1.0/1.1 s6.9, v1.2/2.0 s6.10: Preprocessor Directives and Macros.
  if (LangOpts.OpenCL) {
    // OpenCL v1.0 and v1.1 do not have a predefined macro to indicate the
    // language standard with which the program is compiled. __OPENCL_VERSION__
    // is for the OpenCL version supported by the OpenCL device, which is not
    // necessarily the language standard with which the program is compiled.
    // A shared OpenCL header file requires a macro to indicate the language
    // standard. As a workaround, __OPENCL_C_VERSION__ is defined for
    // OpenCL v1.0 and v1.1.
    switch (LangOpts.OpenCLVersion) {
     case 100:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__OPENCL_C_VERSION__"), new Twine(/*KEEP_STR*/"100"));
      break;
     case 110:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__OPENCL_C_VERSION__"), new Twine(/*KEEP_STR*/"110"));
      break;
     case 120:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__OPENCL_C_VERSION__"), new Twine(/*KEEP_STR*/"120"));
      break;
     case 200:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__OPENCL_C_VERSION__"), new Twine(/*KEEP_STR*/"200"));
      break;
     default:
      throw new llvm_unreachable("Unsupported OpenCL version");
    }
    Builder.defineMacro(new Twine(/*KEEP_STR*/"CL_VERSION_1_0"), new Twine(/*KEEP_STR*/"100"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"CL_VERSION_1_1"), new Twine(/*KEEP_STR*/"110"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"CL_VERSION_1_2"), new Twine(/*KEEP_STR*/"120"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"CL_VERSION_2_0"), new Twine(/*KEEP_STR*/"200"));
    if (LangOpts.FastRelaxedMath) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__FAST_RELAXED_MATH__"));
    }
  }
  // Not "standard" per se, but available even with the -undef flag.
  if (LangOpts.AsmPreprocessor) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ASSEMBLER__"));
  }
  if (LangOpts.CUDA) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__CUDA__"));
  }
}


/// Initialize the predefined C++ language feature test macros defined in
/// ISO/IEC JTC1/SC22/WG21 (C++) SD-6: "SG10 Feature Test Recommendations".
//<editor-fold defaultstate="collapsed" desc="InitializeCPlusPlusFeatureTestMacros">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 453,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", old_line = 420,
 FQN="InitializeCPlusPlusFeatureTestMacros", NM="_ZL36InitializeCPlusPlusFeatureTestMacrosRKN5clang11LangOptionsERNS_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL36InitializeCPlusPlusFeatureTestMacrosRKN5clang11LangOptionsERNS_12MacroBuilderE")
//</editor-fold>
public static void InitializeCPlusPlusFeatureTestMacros(/*const*/ LangOptions /*&*/ LangOpts, 
                                    MacroBuilder /*&*/ Builder) {
  // C++98 features.
  if (LangOpts.RTTI) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_rtti"), new Twine(/*KEEP_STR*/"199711"));
  }
  if (LangOpts.CXXExceptions) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_exceptions"), new Twine(/*KEEP_STR*/"199711"));
  }
  
  // C++11 features.
  if (LangOpts.CPlusPlus11) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_unicode_characters"), new Twine(/*KEEP_STR*/"200704"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_raw_strings"), new Twine(/*KEEP_STR*/"200710"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_unicode_literals"), new Twine(/*KEEP_STR*/"200710"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_user_defined_literals"), new Twine(/*KEEP_STR*/"200809"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_lambdas"), new Twine(/*KEEP_STR*/"200907"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_constexpr"), 
        new Twine(LangOpts.CPlusPlus14 ? $("201304") : $("200704")));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_range_based_for"), new Twine(/*KEEP_STR*/"200907"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_static_assert"), new Twine(/*KEEP_STR*/"200410"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_decltype"), new Twine(/*KEEP_STR*/"200707"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_attributes"), new Twine(/*KEEP_STR*/"200809"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_rvalue_references"), new Twine(/*KEEP_STR*/"200610"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_variadic_templates"), new Twine(/*KEEP_STR*/"200704"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_initializer_lists"), new Twine(/*KEEP_STR*/"200806"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_delegating_constructors"), new Twine(/*KEEP_STR*/"200604"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_nsdmi"), new Twine(/*KEEP_STR*/"200809"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_inheriting_constructors"), new Twine(/*KEEP_STR*/"200802"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_ref_qualifiers"), new Twine(/*KEEP_STR*/"200710"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_alias_templates"), new Twine(/*KEEP_STR*/"200704"));
  }
  
  // C++14 features.
  if (LangOpts.CPlusPlus14) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_binary_literals"), new Twine(/*KEEP_STR*/"201304"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_digit_separators"), new Twine(/*KEEP_STR*/"201309"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_init_captures"), new Twine(/*KEEP_STR*/"201304"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_generic_lambdas"), new Twine(/*KEEP_STR*/"201304"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_decltype_auto"), new Twine(/*KEEP_STR*/"201304"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_return_type_deduction"), new Twine(/*KEEP_STR*/"201304"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_aggregate_nsdmi"), new Twine(/*KEEP_STR*/"201304"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_variable_templates"), new Twine(/*KEEP_STR*/"201304"));
  }
  if (LangOpts.SizedDeallocation) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_sized_deallocation"), new Twine(/*KEEP_STR*/"201309"));
  }
  if (LangOpts.ConceptsTS) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_experimental_concepts"), new Twine(/*KEEP_STR*/$1));
  }
  if (LangOpts.Coroutines) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__cpp_coroutines"), new Twine(/*KEEP_STR*/$1));
  }
}

//<editor-fold defaultstate="collapsed" desc="InitializePredefinedMacros">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 503,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", old_line = 470,
 FQN="InitializePredefinedMacros", NM="_ZL26InitializePredefinedMacrosRKN5clang10TargetInfoERKNS_11LangOptionsERKNS_15FrontendOptionsERNS_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZL26InitializePredefinedMacrosRKN5clang10TargetInfoERKNS_11LangOptionsERKNS_15FrontendOptionsERNS_12MacroBuilderE")
//</editor-fold>
public static void InitializePredefinedMacros(/*const*/ TargetInfo /*&*/ TI, 
                          /*const*/ LangOptions /*&*/ LangOpts, 
                          /*const*/ FrontendOptions /*&*/ FEOpts, 
                          MacroBuilder /*&*/ Builder) {
  // Compiler version introspection macros.
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__llvm__")); // LLVM Backend
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__clang__")); // Clang Frontend
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__clang_major__"), new Twine(/*KEEP_STR*/CLANG_VERSION_MAJOR));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__clang_minor__"), new Twine(/*KEEP_STR*/CLANG_VERSION_MINOR));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__clang_patchlevel__"), new Twine(/*KEEP_STR*/CLANG_VERSION_PATCHLEVEL));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__clang_version__"), 
      new Twine($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"\"" + CLANG_VERSION_STRING + " ", 
                  getClangFullRepositoryVersion()), /*KEEP_STR*/"\"")));
  if (!LangOpts.MSVCCompat) {
    // Currently claim to be compatible with GCC 4.2.1-5621, but only if we're
    // not compiling for MSVC compatibility
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GNUC_MINOR__"), new Twine(/*KEEP_STR*/$2));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GNUC_PATCHLEVEL__"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GNUC__"), new Twine(/*KEEP_STR*/$4));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GXX_ABI_VERSION"), new Twine(/*KEEP_STR*/"1002"));
  }
  
  // Define macros for the C11 / C++11 memory orderings
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ATOMIC_RELAXED"), new Twine(/*KEEP_STR*/$0));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ATOMIC_CONSUME"), new Twine(/*KEEP_STR*/$1));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ATOMIC_ACQUIRE"), new Twine(/*KEEP_STR*/$2));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ATOMIC_RELEASE"), new Twine(/*KEEP_STR*/$3));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ATOMIC_ACQ_REL"), new Twine(/*KEEP_STR*/$4));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ATOMIC_SEQ_CST"), new Twine(/*KEEP_STR*/$5));
  
  // Support for #pragma redefine_extname (Sun compatibility)
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__PRAGMA_REDEFINE_EXTNAME"), new Twine(/*KEEP_STR*/$1));
  
  // As sad as it is, enough software depends on the __VERSION__ for version
  // checks that it is necessary to report 4.2.1 (the base GCC version we claim
  // compatibility with) first.
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__VERSION__"), $add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"\"4.2.1 Compatible "), 
              new Twine(getClangFullCPPVersion())), new Twine(/*KEEP_STR*/$DBL_QUOTE)));
  
  // Initialize language-specific preprocessor defines.
  
  // Standard conforming mode?
  if (!LangOpts.GNUMode && !LangOpts.MSVCCompat) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__STRICT_ANSI__"));
  }
  if (!LangOpts.MSVCCompat && LangOpts.CPlusPlus11) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GXX_EXPERIMENTAL_CXX0X__"));
  }
  if (LangOpts.ObjC1) {
    if (LangOpts.ObjCRuntime.isNonFragile()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__OBJC2__"));
      if (LangOpts.ObjCExceptions) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"OBJC_ZEROCOST_EXCEPTIONS"));
      }
    }
    if (LangOpts.getGC() != LangOptions.GCMode.NonGC) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__OBJC_GC__"));
    }
    if (LangOpts.ObjCRuntime.isNeXTFamily()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__NEXT_RUNTIME__"));
    }
    if (LangOpts.ObjCRuntime.getKind() == ObjCRuntime.Kind.ObjFW) {
      VersionTuple tuple = new VersionTuple(LangOpts.ObjCRuntime.getVersion());
      
      /*uint*/int minor = 0;
      if (tuple.getMinor().hasValue()) {
        minor = tuple.getMinor().getValue();
      }
      
      /*uint*/int subminor = 0;
      if (tuple.getSubminor().hasValue()) {
        subminor = tuple.getSubminor().getValue();
      }
      
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__OBJFW_RUNTIME_ABI__"), 
          new Twine(JD$UInt.INSTANCE, tuple.getMajor() * 10000 + minor * 100
                 + subminor));
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"IBOutlet"), new Twine(/*KEEP_STR*/"__attribute__((iboutlet))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"IBOutletCollection(ClassName)"), 
        new Twine(/*KEEP_STR*/"__attribute__((iboutletcollection(ClassName)))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"IBAction"), new Twine(/*KEEP_STR*/"void)__attribute__((ibaction)"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"IBInspectable"), new Twine(/*KEEP_STR*/$EMPTY));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"IB_DESIGNABLE"), new Twine(/*KEEP_STR*/$EMPTY));
  }
  if (LangOpts.CPlusPlus) {
    InitializeCPlusPlusFeatureTestMacros(LangOpts, Builder);
  }
  
  // darwin_constant_cfstrings controls this. This is also dependent
  // on other things like the runtime I believe.  This is set even for C code.
  if (!LangOpts.NoConstantCFStrings) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__CONSTANT_CFSTRINGS__"));
  }
  if (LangOpts.ObjC2) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"OBJC_NEW_PROPERTIES"));
  }
  if (LangOpts.PascalStrings) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__PASCAL_STRINGS__"));
  }
  if (LangOpts.Blocks) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__block"), new Twine(/*KEEP_STR*/"__attribute__((__blocks__(byref)))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__BLOCKS__"));
  }
  if (!LangOpts.MSVCCompat && LangOpts.Exceptions) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__EXCEPTIONS"));
  }
  if (!LangOpts.MSVCCompat && LangOpts.RTTI) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GXX_RTTI"));
  }
  if (LangOpts.SjLjExceptions) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__USING_SJLJ_EXCEPTIONS__"));
  }
  if (LangOpts.Deprecated) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__DEPRECATED"));
  }
  if (!LangOpts.MSVCCompat && LangOpts.CPlusPlus) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GNUG__"), new Twine(/*KEEP_STR*/$4));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GXX_WEAK__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/$__private_extern__), new Twine(/*KEEP_STR*/$extern));
  }
  if (LangOpts.MicrosoftExt) {
    if (LangOpts.WChar) {
      // wchar_t supported as a keyword.
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_WCHAR_T_DEFINED"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_NATIVE_WCHAR_T_DEFINED"));
    }
  }
  if (LangOpts.Optimize) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__OPTIMIZE__"));
  }
  if (LangOpts.OptimizeSize) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__OPTIMIZE_SIZE__"));
  }
  if (LangOpts.FastMath) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__FAST_MATH__"));
  }
  
  // Initialize target-specific preprocessor defines.
  
  // __BYTE_ORDER__ was added in GCC 4.6. It's analogous
  // to the macro __BYTE_ORDER (no trailing underscores)
  // from glibc's <endian.h> header.
  // We don't support the PDP-11 as a target, but include
  // the define so it can still be compared against.
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ORDER_LITTLE_ENDIAN__"), new Twine(/*KEEP_STR*/"1234"));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ORDER_BIG_ENDIAN__"), new Twine(/*KEEP_STR*/"4321"));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__ORDER_PDP_ENDIAN__"), new Twine(/*KEEP_STR*/"3412"));
  if (TI.isBigEndian()) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__BYTE_ORDER__"), new Twine(/*KEEP_STR*/"__ORDER_BIG_ENDIAN__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__BIG_ENDIAN__"));
  } else {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__BYTE_ORDER__"), new Twine(/*KEEP_STR*/"__ORDER_LITTLE_ENDIAN__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__LITTLE_ENDIAN__"));
  }
  if (TI.getPointerWidth(0) == 64 && TI.getLongWidth() == 64
     && TI.getIntWidth() == 32) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_LP64"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__LP64__"));
  }
  if (TI.getPointerWidth(0) == 32 && TI.getLongWidth() == 32
     && TI.getIntWidth() == 32) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_ILP32"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ILP32__"));
  }
  
  // Define type sizing macros based on the target properties.
  assert (TI.getCharWidth() == 8) : "Only support 8-bit char so far";
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__CHAR_BIT__"), new Twine(/*KEEP_STR*/$8));
  
  DefineTypeSize(new Twine(/*KEEP_STR*/"__SCHAR_MAX__"), TargetInfo.IntType.SignedChar, TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__SHRT_MAX__"), TargetInfo.IntType.SignedShort, TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__INT_MAX__"), TargetInfo.IntType.SignedInt, TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__LONG_MAX__"), TargetInfo.IntType.SignedLong, TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__LONG_LONG_MAX__"), TargetInfo.IntType.SignedLongLong, TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__WCHAR_MAX__"), TI.getWCharType(), TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__INTMAX_MAX__"), TI.getIntMaxType(), TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__SIZE_MAX__"), TI.getSizeType(), TI, Builder);
  
  DefineTypeSize(new Twine(/*KEEP_STR*/"__UINTMAX_MAX__"), TI.getUIntMaxType(), TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__PTRDIFF_MAX__"), TI.getPtrDiffType(0), TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__INTPTR_MAX__"), TI.getIntPtrType(), TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__UINTPTR_MAX__"), TI.getUIntPtrType(), TI, Builder);
  
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_DOUBLE__"), TI.getDoubleWidth(), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_FLOAT__"), TI.getFloatWidth(), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_INT__"), TI.getIntWidth(), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_LONG__"), TI.getLongWidth(), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_LONG_DOUBLE__"), TI.getLongDoubleWidth(), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_LONG_LONG__"), TI.getLongLongWidth(), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_POINTER__"), $ulong2uint(TI.getPointerWidth(0)), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_SHORT__"), TI.getShortWidth(), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_PTRDIFF_T__"), 
      TI.getTypeWidth(TI.getPtrDiffType(0)), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_SIZE_T__"), 
      TI.getTypeWidth(TI.getSizeType()), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_WCHAR_T__"), 
      TI.getTypeWidth(TI.getWCharType()), TI, Builder);
  DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_WINT_T__"), 
      TI.getTypeWidth(TI.getWIntType()), TI, Builder);
  if (TI.hasInt128Type()) {
    DefineTypeSizeof(new StringRef(/*KEEP_STR*/"__SIZEOF_INT128__"), 128, TI, Builder);
  }
  
  DefineType(new Twine(/*KEEP_STR*/"__INTMAX_TYPE__"), TI.getIntMaxType(), Builder);
  DefineFmt(new Twine(/*KEEP_STR*/"__INTMAX"), TI.getIntMaxType(), TI, Builder);
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__INTMAX_C_SUFFIX__"), 
      new Twine(TI.getTypeConstantSuffix(TI.getIntMaxType())));
  DefineType(new Twine(/*KEEP_STR*/"__UINTMAX_TYPE__"), TI.getUIntMaxType(), Builder);
  DefineFmt(new Twine(/*KEEP_STR*/"__UINTMAX"), TI.getUIntMaxType(), TI, Builder);
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__UINTMAX_C_SUFFIX__"), 
      new Twine(TI.getTypeConstantSuffix(TI.getUIntMaxType())));
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__INTMAX_WIDTH__"), TI.getIntMaxType(), TI, Builder);
  DefineType(new Twine(/*KEEP_STR*/"__PTRDIFF_TYPE__"), TI.getPtrDiffType(0), Builder);
  DefineFmt(new Twine(/*KEEP_STR*/"__PTRDIFF"), TI.getPtrDiffType(0), TI, Builder);
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__PTRDIFF_WIDTH__"), TI.getPtrDiffType(0), TI, Builder);
  DefineType(new Twine(/*KEEP_STR*/"__INTPTR_TYPE__"), TI.getIntPtrType(), Builder);
  DefineFmt(new Twine(/*KEEP_STR*/"__INTPTR"), TI.getIntPtrType(), TI, Builder);
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__INTPTR_WIDTH__"), TI.getIntPtrType(), TI, Builder);
  DefineType(new Twine(/*KEEP_STR*/"__SIZE_TYPE__"), TI.getSizeType(), Builder);
  DefineFmt(new Twine(/*KEEP_STR*/"__SIZE"), TI.getSizeType(), TI, Builder);
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__SIZE_WIDTH__"), TI.getSizeType(), TI, Builder);
  DefineType(new Twine(/*KEEP_STR*/"__WCHAR_TYPE__"), TI.getWCharType(), Builder);
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__WCHAR_WIDTH__"), TI.getWCharType(), TI, Builder);
  DefineType(new Twine(/*KEEP_STR*/"__WINT_TYPE__"), TI.getWIntType(), Builder);
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__WINT_WIDTH__"), TI.getWIntType(), TI, Builder);
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__SIG_ATOMIC_WIDTH__"), TI.getSigAtomicType(), TI, Builder);
  DefineTypeSize(new Twine(/*KEEP_STR*/"__SIG_ATOMIC_MAX__"), TI.getSigAtomicType(), TI, Builder);
  DefineType(new Twine(/*KEEP_STR*/"__CHAR16_TYPE__"), TI.getChar16Type(), Builder);
  DefineType(new Twine(/*KEEP_STR*/"__CHAR32_TYPE__"), TI.getChar32Type(), Builder);
  
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__UINTMAX_WIDTH__"), TI.getUIntMaxType(), TI, Builder);
  DefineType(new Twine(/*KEEP_STR*/"__UINTPTR_TYPE__"), TI.getUIntPtrType(), Builder);
  DefineFmt(new Twine(/*KEEP_STR*/"__UINTPTR"), TI.getUIntPtrType(), TI, Builder);
  DefineTypeWidth(new StringRef(/*KEEP_STR*/"__UINTPTR_WIDTH__"), TI.getUIntPtrType(), TI, Builder);
  
  DefineFloatMacros(Builder, new StringRef(/*KEEP_STR*/"FLT"), /*AddrOf*/TI.getFloatFormat(), new StringRef(/*KEEP_STR*/$F));
  DefineFloatMacros(Builder, new StringRef(/*KEEP_STR*/"DBL"), /*AddrOf*/TI.getDoubleFormat(), new StringRef(/*KEEP_STR*/$EMPTY));
  DefineFloatMacros(Builder, new StringRef(/*KEEP_STR*/"LDBL"), /*AddrOf*/TI.getLongDoubleFormat(), new StringRef(/*KEEP_STR*/$L));
  
  // Define a __POINTER_WIDTH__ macro for stdint.h.
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__POINTER_WIDTH__"), 
      new Twine(JD$Int.INSTANCE, (int)$ulong2int(TI.getPointerWidth(0))));
  
  // Define __BIGGEST_ALIGNMENT__ to be compatible with gcc.
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__BIGGEST_ALIGNMENT__"), 
      new Twine(JD$UInt.INSTANCE, TI.getSuitableAlign() / TI.getCharWidth()));
  if (!LangOpts.CharIsSigned) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__CHAR_UNSIGNED__"));
  }
  if (!TargetInfo.isTypeSigned(TI.getWCharType())) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__WCHAR_UNSIGNED__"));
  }
  if (!TargetInfo.isTypeSigned(TI.getWIntType())) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__WINT_UNSIGNED__"));
  }
  
  // Define exact-width integer types for stdint.h
  DefineExactWidthIntType(TargetInfo.IntType.SignedChar, TI, Builder);
  if ($greater_uint(TI.getShortWidth(), TI.getCharWidth())) {
    DefineExactWidthIntType(TargetInfo.IntType.SignedShort, TI, Builder);
  }
  if ($greater_uint(TI.getIntWidth(), TI.getShortWidth())) {
    DefineExactWidthIntType(TargetInfo.IntType.SignedInt, TI, Builder);
  }
  if ($greater_uint(TI.getLongWidth(), TI.getIntWidth())) {
    DefineExactWidthIntType(TargetInfo.IntType.SignedLong, TI, Builder);
  }
  if ($greater_uint(TI.getLongLongWidth(), TI.getLongWidth())) {
    DefineExactWidthIntType(TargetInfo.IntType.SignedLongLong, TI, Builder);
  }
  
  DefineExactWidthIntType(TargetInfo.IntType.UnsignedChar, TI, Builder);
  DefineExactWidthIntTypeSize(TargetInfo.IntType.UnsignedChar, TI, Builder);
  DefineExactWidthIntTypeSize(TargetInfo.IntType.SignedChar, TI, Builder);
  if ($greater_uint(TI.getShortWidth(), TI.getCharWidth())) {
    DefineExactWidthIntType(TargetInfo.IntType.UnsignedShort, TI, Builder);
    DefineExactWidthIntTypeSize(TargetInfo.IntType.UnsignedShort, TI, Builder);
    DefineExactWidthIntTypeSize(TargetInfo.IntType.SignedShort, TI, Builder);
  }
  if ($greater_uint(TI.getIntWidth(), TI.getShortWidth())) {
    DefineExactWidthIntType(TargetInfo.IntType.UnsignedInt, TI, Builder);
    DefineExactWidthIntTypeSize(TargetInfo.IntType.UnsignedInt, TI, Builder);
    DefineExactWidthIntTypeSize(TargetInfo.IntType.SignedInt, TI, Builder);
  }
  if ($greater_uint(TI.getLongWidth(), TI.getIntWidth())) {
    DefineExactWidthIntType(TargetInfo.IntType.UnsignedLong, TI, Builder);
    DefineExactWidthIntTypeSize(TargetInfo.IntType.UnsignedLong, TI, Builder);
    DefineExactWidthIntTypeSize(TargetInfo.IntType.SignedLong, TI, Builder);
  }
  if ($greater_uint(TI.getLongLongWidth(), TI.getLongWidth())) {
    DefineExactWidthIntType(TargetInfo.IntType.UnsignedLongLong, TI, Builder);
    DefineExactWidthIntTypeSize(TargetInfo.IntType.UnsignedLongLong, TI, Builder);
    DefineExactWidthIntTypeSize(TargetInfo.IntType.SignedLongLong, TI, Builder);
  }
  
  DefineLeastWidthIntType(8, true, TI, Builder);
  DefineLeastWidthIntType(8, false, TI, Builder);
  DefineLeastWidthIntType(16, true, TI, Builder);
  DefineLeastWidthIntType(16, false, TI, Builder);
  DefineLeastWidthIntType(32, true, TI, Builder);
  DefineLeastWidthIntType(32, false, TI, Builder);
  DefineLeastWidthIntType(64, true, TI, Builder);
  DefineLeastWidthIntType(64, false, TI, Builder);
  
  DefineFastIntType(8, true, TI, Builder);
  DefineFastIntType(8, false, TI, Builder);
  DefineFastIntType(16, true, TI, Builder);
  DefineFastIntType(16, false, TI, Builder);
  DefineFastIntType(32, true, TI, Builder);
  DefineFastIntType(32, false, TI, Builder);
  DefineFastIntType(64, true, TI, Builder);
  DefineFastIntType(64, false, TI, Builder);
  
  /*char*/byte UserLabelPrefix[/*2*/] = new$char(2, TI.getDataLayout().getGlobalPrefix(), $$TERM);
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__USER_LABEL_PREFIX__"), new Twine(UserLabelPrefix));
  if (LangOpts.FastMath || LangOpts.FiniteMathOnly) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__FINITE_MATH_ONLY__"), new Twine(/*KEEP_STR*/$1));
  } else {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__FINITE_MATH_ONLY__"), new Twine(/*KEEP_STR*/$0));
  }
  if (!LangOpts.MSVCCompat) {
    if (LangOpts.GNUInline || LangOpts.CPlusPlus) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GNUC_GNU_INLINE__"));
    } else {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GNUC_STDC_INLINE__"));
    }
    
    // The value written by __atomic_test_and_set.
    // FIXME: This is target-dependent.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_TEST_AND_SET_TRUEVAL"), new Twine(/*KEEP_STR*/$1));
    
    // Used by libc++ and libstdc++ to implement ATOMIC_<foo>_LOCK_FREE.
    /*uint*/int InlineWidthBits = TI.getMaxAtomicInlineWidth();
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_BOOL_LOCK_FREE"), new Twine(getLockFreeValue(TI.getBoolWidth(), TI.getBoolAlign(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_CHAR_LOCK_FREE"), new Twine(getLockFreeValue(TI.getCharWidth(), TI.getCharAlign(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_CHAR16_T_LOCK_FREE"), new Twine(getLockFreeValue(TI.getChar16Width(), TI.getChar16Align(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_CHAR32_T_LOCK_FREE"), new Twine(getLockFreeValue(TI.getChar32Width(), TI.getChar32Align(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_WCHAR_T_LOCK_FREE"), new Twine(getLockFreeValue(TI.getWCharWidth(), TI.getWCharAlign(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_SHORT_LOCK_FREE"), new Twine(getLockFreeValue(TI.getShortWidth(), TI.getShortAlign(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_INT_LOCK_FREE"), new Twine(getLockFreeValue(TI.getIntWidth(), TI.getIntAlign(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_LONG_LOCK_FREE"), new Twine(getLockFreeValue(TI.getLongWidth(), TI.getLongAlign(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_LLONG_LOCK_FREE"), new Twine(getLockFreeValue(TI.getLongLongWidth(), TI.getLongLongAlign(), InlineWidthBits)));
    ;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_ATOMIC_POINTER_LOCK_FREE"), 
        new Twine(getLockFreeValue($ulong2uint(TI.getPointerWidth(0)), 
                $ulong2uint(TI.getPointerAlign(0)), 
                InlineWidthBits)));
  }
  if (LangOpts.NoInlineDefine) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__NO_INLINE__"));
  }
  {
    
    /*uint*/int PICLevel = LangOpts.PICLevel;
    if ((PICLevel != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__PIC__"), new Twine(JD$UInt.INSTANCE, PICLevel));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__pic__"), new Twine(JD$UInt.INSTANCE, PICLevel));
      if (LangOpts.PIE) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__PIE__"), new Twine(JD$UInt.INSTANCE, PICLevel));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__pie__"), new Twine(JD$UInt.INSTANCE, PICLevel));
      }
    }
  }
  
  // Macros to control C99 numerics and <float.h>
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__FLT_EVAL_METHOD__"), new Twine(JD$UInt.INSTANCE, TI.getFloatEvalMethod()));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__FLT_RADIX__"), new Twine(/*KEEP_STR*/$2));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__DECIMAL_DIG__"), new Twine(/*KEEP_STR*/"__LDBL_DECIMAL_DIG__"));
  if (LangOpts.getStackProtector() == LangOptions.StackProtectorMode.SSPOn) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSP__"));
  } else if (LangOpts.getStackProtector() == LangOptions.StackProtectorMode.SSPStrong) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSP_STRONG__"), new Twine(/*KEEP_STR*/$2));
  } else if (LangOpts.getStackProtector() == LangOptions.StackProtectorMode.SSPReq) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSP_ALL__"), new Twine(/*KEEP_STR*/$3));
  }
  
  // Define a macro that exists only when using the static analyzer.
  if (FEOpts.ProgramAction == frontend.ActionKind.RunAnalysis) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__clang_analyzer__"));
  }
  if (LangOpts.FastRelaxedMath) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__FAST_RELAXED_MATH__"));
  }
  if (FEOpts.ProgramAction == frontend.ActionKind.RewriteObjC
     || LangOpts.getGC() != LangOptions.GCMode.NonGC) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__weak"), new Twine(/*KEEP_STR*/"__attribute__((objc_gc(weak)))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__strong"), new Twine(/*KEEP_STR*/"__attribute__((objc_gc(strong)))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__autoreleasing"), new Twine(/*KEEP_STR*/$EMPTY));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__unsafe_unretained"), new Twine(/*KEEP_STR*/$EMPTY));
  } else if (LangOpts.ObjC1) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__weak"), new Twine(/*KEEP_STR*/"__attribute__((objc_ownership(weak)))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__strong"), new Twine(/*KEEP_STR*/"__attribute__((objc_ownership(strong)))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__autoreleasing"), 
        new Twine(/*KEEP_STR*/"__attribute__((objc_ownership(autoreleasing)))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__unsafe_unretained"), 
        new Twine(/*KEEP_STR*/"__attribute__((objc_ownership(none)))"));
  }
  
  // On Darwin, there are __double_underscored variants of the type
  // nullability qualifiers.
  if (TI.getTriple().isOSDarwin()) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__nonnull"), new Twine(/*KEEP_STR*/$_Nonnull));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__null_unspecified"), new Twine(/*KEEP_STR*/$_Null_unspecified));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__nullable"), new Twine(/*KEEP_STR*/$_Nullable));
  }
  
  // OpenMP definition
  // OpenMP 2.2:
  //   In implementations that support a preprocessor, the _OPENMP
  //   macro name is defined to have the decimal value yyyymm where
  //   yyyy and mm are the year and the month designations of the
  //   version of the OpenMP API that the implementation support.
  switch (LangOpts.OpenMP) {
   case 0:
    break;
   case 40:
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_OPENMP"), new Twine(/*KEEP_STR*/"201307"));
    break;
   case 45:
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_OPENMP"), new Twine(/*KEEP_STR*/"201511"));
    break;
   default:
    // Default version is OpenMP 3.1
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_OPENMP"), new Twine(/*KEEP_STR*/"201107"));
    break;
  }
  
  // CUDA device path compilaton
  if (LangOpts.CUDAIsDevice) {
    // The CUDA_ARCH value is set for the GPU target specified in the NVPTX
    // backend's target defines.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__CUDA_ARCH__"));
  }
  
  // We need to communicate this to our CUDA header wrapper, which in turn
  // informs the proper CUDA headers of this choice.
  if (LangOpts.CUDADeviceApproxTranscendentals || LangOpts.FastMath) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__CLANG_CUDA_APPROX_TRANSCENDENTALS__"));
  }
  
  // OpenCL definitions.
  if (LangOpts.OpenCL) {
    // OPENCLEXT_INTERNAL
    
    // OpenCL 1.0.
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_3d_image_writes_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_3d_image_writes"));
    }
    // fprounding mode is special since it is not mentioned beyond 1.0
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_select_fprounding_mode_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_select_fprounding_mode"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_byte_addressable_store_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_byte_addressable_store"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_fp16_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_fp16"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_fp64_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_fp64"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_global_int32_base_atomics_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_global_int32_base_atomics"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_global_int32_extended_atomics_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_global_int32_extended_atomics"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_local_int32_base_atomics_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_local_int32_base_atomics"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_local_int32_extended_atomics_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_local_int32_extended_atomics"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_int64_base_atomics_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_int64_base_atomics"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_int64_extended_atomics_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_int64_extended_atomics"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_gl_sharing_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_gl_sharing"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_icd_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_icd"));
    }
    
    // OpenCL 1.1.
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_gl_event_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_gl_event"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_d3d10_sharing_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_d3d10_sharing"));
    }
    
    // OpenCL 1.2.
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_context_abort_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_context_abort"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_d3d11_sharing_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_d3d11_sharing"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_depth_images_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_depth_images"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_dx9_media_sharing_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_dx9_media_sharing"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_image2d_from_buffer_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_image2d_from_buffer"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_initialize_memory_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_initialize_memory"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_gl_depth_images_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_gl_depth_images"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_gl_msaa_sharing_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_gl_msaa_sharing"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_spir_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_spir"));
    }
    
    // OpenCL 2.0.
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_egl_event_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_egl_event"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_egl_image_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_egl_image"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_srgb_image_writes_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_srgb_image_writes"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_subgroups_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_subgroups"));
    }
    if (TI.getSupportedOpenCLOpts$Const().is_cl_khr_terminate_context_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_khr_terminate_context"));
    }
    
    // Clang Extensions.
    if (TI.getSupportedOpenCLOpts$Const().is_cl_clang_storage_class_specifiers_supported(LangOpts.OpenCLVersion)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"cl_clang_storage_class_specifiers"));
    }
  }
  
  // Get other target #defines.
  TI.getTargetDefines(LangOpts, Builder);
}

} // END OF class InitPreprocessorStatics
