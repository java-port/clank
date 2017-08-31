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

package org.clang.lex.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clang.lex.llvm.SmallVectorToken;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.SanitizerKind;
import org.clang.lex.*;
import org.clang.lex.java.LexFunctionPointers;
import org.clank.java.std;
import static org.clank.java.std.*;
import org.clank.java.std.tm;
import org.clank.support.*;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTAliases.OptionalInt;
import org.llvm.adt.aliases.SmallVectorImpl;
import org.llvm.adt.aliases.SmallVectorInt;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type PPMacroExpansionStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL10HasFeatureRKN5clang12PreprocessorEPKNS_14IdentifierInfoE;_ZL12HasExtensionRKN5clang12PreprocessorEPKNS_14IdentifierInfoE;_ZL16ComputeDATE_TIMERN5clang14SourceLocationES1_RNS_12PreprocessorE;_ZL18EvaluateHasIncludeRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorE;_ZL20CheckMatchedBracketsRKN4llvm15SmallVectorImplIN5clang5TokenEEE;_ZL20GenerateNewArgTokensRN5clang12PreprocessorERN4llvm15SmallVectorImplINS_5TokenEEES6_RjRNS3_INS_11SourceRangeEEESA_;_ZL20RegisterBuiltinMacroRN5clang12PreprocessorEPKc;_ZL22EvaluateBuildingModuleRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorE;_ZL22EvaluateHasIncludeNextRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorE;_ZL24EvaluateHasIncludeCommonRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorEPKNS_15DirectoryLookupEPKNS_9FileEntryE;_ZL29isTrivialSingleTokenExpansionPKN5clang9MacroInfoEPKNS_14IdentifierInfoERNS_12PreprocessorE; -static-type=PPMacroExpansionStatics -package=org.clang.lex.impl")
//</editor-fold>
public final class PPMacroExpansionStatics {


/// RegisterBuiltinMacro - Register the specified identifier in the identifier
/// table and mark it as a builtin macro to be expanded.
//<editor-fold defaultstate="collapsed" desc="RegisterBuiltinMacro">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*String as param*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 278,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 271,
 FQN="RegisterBuiltinMacro", NM="_ZL20RegisterBuiltinMacroRN5clang12PreprocessorEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL20RegisterBuiltinMacroRN5clang12PreprocessorEPKc")
//</editor-fold>
public static IdentifierInfo /*P*/ RegisterBuiltinMacro(Preprocessor /*&*/ PP, /*const*/String/*char P*/ Name) {
  // Get the identifier.
  IdentifierInfo /*P*/ Id = PP.getIdentifierInfo(new StringRef(Name));
  
  // Mark it as being a macro that is builtin.
  MacroInfo /*P*/ MI = PP.AllocateMacroInfo(SourceLocation.getInvalid());
  MI.setIsBuiltinMacro();
  PP.appendDefMacroDirective(Id, MI);
  return Id;
}


/// isTrivialSingleTokenExpansion - Return true if MI, which has a single token
/// in its expansion, currently expands to that token literally.
//<editor-fold defaultstate="collapsed" desc="isTrivialSingleTokenExpansion">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 342,
 FQN="isTrivialSingleTokenExpansion", NM="_ZL29isTrivialSingleTokenExpansionPKN5clang9MacroInfoEPKNS_14IdentifierInfoERNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL29isTrivialSingleTokenExpansionPKN5clang9MacroInfoEPKNS_14IdentifierInfoERNS_12PreprocessorE")
//</editor-fold>
public static boolean isTrivialSingleTokenExpansion(/*const*/ MacroInfo /*P*/ MI,
        /*const*/ IdentifierInfo /*P*/ MacroIdent, 
        Preprocessor /*&*/ PP) {
  IdentifierInfo /*P*/ II = MI.getReplacementToken(0).getIdentifierInfo();
  
  // If the token isn't an identifier, it's always literally expanded.
  if (II == null) {
    return true;
  }
  
  // If the information about this identifier is out of date, update it from
  // the external source.
  if (II.isOutOfDate()) {
    PP.getExternalSource().updateOutOfDateIdentifier($Deref(II));
  }
  {
  
  // If the identifier is a macro, and if that macro is enabled, it may be
  // expanded so it's not a trivial expansion.
    MacroInfo /*P*/ ExpansionMI = PP.getMacroInfo(II);
    if ((ExpansionMI != null)) {
      if (ExpansionMI.isEnabled()
        // Fast expanding "#define X X" is ok, because X would be disabled.
         && II != MacroIdent) {
        return false;
      }
    }
  }
  
  // If this is an object-like macro invocation, it is safe to trivially expand
  // it.
  if (MI.isObjectLike()) {
    return true;
  }
  
  // If this is a function-like macro invocation, it's safe to trivially expand
  // as long as the identifier is not a macro argument.
  int End = MI.getNumArgs();
  return std.find(MI.$args(), 0, End, II) == End; // PERF: can compare with passed End pointer
}


/// CheckMatchedBrackets - Returns true if the braces and parentheses in the
/// token vector are properly nested.
//<editor-fold defaultstate="collapsed" desc="CheckMatchedBrackets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 581,
 FQN="CheckMatchedBrackets", NM="_ZL20CheckMatchedBracketsRKN4llvm15SmallVectorImplIN5clang5TokenEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL20CheckMatchedBracketsRKN4llvm15SmallVectorImplIN5clang5TokenEEE")
//</editor-fold>
public static boolean CheckMatchedBrackets(/*const*/SmallVectorToken /*&*/ Tokens) {
  SmallVectorInt/*<Bracket>*/ Brackets/*J*/= new SmallVectorInt/*<Bracket>*/(8, Bracket.Brace);
  for (SmallVectorToken.iterator I = Tokens.begin(), 
       /*P*/E = Tokens.end(); 
        $noteq_ptr(I, E); I.$preInc()) {
    if (I./*->*/$star().is(tok.TokenKind.l_paren)) {
      Brackets.push_back(Bracket.Paren);
    } else if (I./*->*/$star().is(tok.TokenKind.r_paren)) {
      if (Brackets.empty() || Brackets.back() == Bracket.Brace) {
        return false;
      }
      Brackets.pop_back();
    } else if (I./*->*/$star().is(tok.TokenKind.l_brace)) {
      Brackets.push_back(Bracket.Brace);
    } else if (I./*->*/$star().is(tok.TokenKind.r_brace)) {
      if (Brackets.empty() || Brackets.back() == Bracket.Paren) {
        return false;
      }
      Brackets.pop_back();
    }
  }
  return Brackets.empty();
}


/// GenerateNewArgTokens - Returns true if OldTokens can be converted to a new
/// vector of tokens in NewTokens.  The new number of arguments will be placed
/// in NumArgs and the ranges which need to surrounded in parentheses will be
/// in ParenHints.
/// Returns false if the token stream cannot be changed.  If this is because
/// of an initializer list starting a macro argument, the range of those
/// initializer lists will be place in InitLists.
//<editor-fold defaultstate="collapsed" desc="GenerateNewArgTokens">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 610,
 FQN="GenerateNewArgTokens", NM="_ZL20GenerateNewArgTokensRN5clang12PreprocessorERN4llvm15SmallVectorImplINS_5TokenEEES6_RjRNS3_INS_11SourceRangeEEESA_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL20GenerateNewArgTokensRN5clang12PreprocessorERN4llvm15SmallVectorImplINS_5TokenEEES6_RjRNS3_INS_11SourceRangeEEESA_")
//</editor-fold>
public static boolean GenerateNewArgTokens(Preprocessor /*&*/ PP, 
        SmallVectorToken/*&*/ OldTokens, 
        SmallVectorToken/*&*/ NewTokens, 
        uint$ref/*uint &*/ NumArgs, 
        SmallVectorImpl<SourceRange> /*&*/ ParenHints, 
        SmallVectorImpl<SourceRange> /*&*/ InitLists) {
  if (!CheckMatchedBrackets(OldTokens)) {
    return false;
  }
  
  // Once it is known that the brackets are matched, only a simple count of the
  // braces is needed.
  /*uint*/int Braces = 0;
  
  // First token of a new macro argument.
  SmallVectorToken.iterator ArgStartIterator = OldTokens.begin();
  
  // First closing brace in a new macro argument.  Used to generate
  // SourceRanges for InitLists.
  SmallVectorToken.iterator ClosingBrace = OldTokens.end();
  NumArgs.$set(0);
  Token TempToken/*J*/= new Token();
  // Set to true when a macro separator token is found inside a braced list.
  // If true, the fixed argument spans multiple old arguments and ParenHints
  // will be updated.
  boolean FoundSeparatorToken = false;
  for (SmallVectorToken.iterator I = OldTokens.begin(), 
      /*P*/E = OldTokens.end(); 
       $noteq_ptr(I, E); I.$preInc()) {
    if (I./*->*/$star().is(tok.TokenKind.l_brace)) {
      ++Braces;
    } else if (I./*->*/$star().is(tok.TokenKind.r_brace)) {
      --Braces;
      if (Braces == 0 && $eq_ptr(ClosingBrace, E) && FoundSeparatorToken) {
        ClosingBrace = $tryClone(I);
      }
    } else if (I./*->*/$star().is(tok.TokenKind.eof)) {
      // EOF token is used to separate macro arguments
      if (Braces != 0) {
        // Assume comma separator is actually braced list separator and change
        // it back to a comma.
        FoundSeparatorToken = true;
        I./*->*/$star().setKind(tok.TokenKind.comma);
        I./*->*/$star().setLength(1);
      } else { // Braces == 0
// Separator token still separates arguments.
        NumArgs.$set$preInc();
        
        // If the argument starts with a brace, it can't be fixed with
        // parentheses.  A different diagnostic will be given.
        if (FoundSeparatorToken && ArgStartIterator./*->*/$star().is(tok.TokenKind.l_brace)) {
          InitLists.push_back(new SourceRange(ArgStartIterator./*->*/$star().$getLocation(), 
                  PP.getLocForEndOfToken(ClosingBrace./*->*/$star().$getLocation())));
          ClosingBrace = $noClone(E);
        }
        
        // Add left paren
        if (FoundSeparatorToken) {
          TempToken.startToken();
          TempToken.setKind(tok.TokenKind.l_paren);
          TempToken.setLocation(ArgStartIterator./*->*/$star().$getLocation());
          TempToken.setLength(0);
          NewTokens.push_back(TempToken);
        }
        
        // Copy over argument tokens
        NewTokens.insert(NewTokens.end(), ArgStartIterator.toPointer(), I.toPointer());
        
        // Add right paren and store the paren locations in ParenHints
        if (FoundSeparatorToken) {
          /*SourceLocation*/int Loc = PP.getLocForEndOfToken((I.$sub(1)).$star().$getLocation());
          TempToken.startToken();
          TempToken.setKind(tok.TokenKind.r_paren);
          TempToken.setLocation(/*NO_COPY*/Loc);
          TempToken.setLength(0);
          NewTokens.push_back(TempToken);
          ParenHints.push_back(new SourceRange(ArgStartIterator./*->*/$star().$getLocation(), 
                  /*NO_COPY*/Loc));
        }
        
        // Copy separator token
        NewTokens.push_back(I.$star());
        
        // Reset values
        ArgStartIterator = $noClone(I.$add(1));
        FoundSeparatorToken = false;
      }
    }
  }
  
  return !ParenHints.empty() && InitLists.empty();
}


/// ComputeDATE_TIME - Compute the current time, enter it into the specified
/// scratch buffer, then return DATELoc/TIMELoc locations with the position of
/// the identifier tokens inserted.
//<editor-fold defaultstate="collapsed" desc="ComputeDATE_TIME">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1014,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 1010,
 FQN="ComputeDATE_TIME", NM="_ZL16ComputeDATE_TIMERN5clang14SourceLocationES1_RNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL16ComputeDATE_TIMERN5clang14SourceLocationES1_RNS_12PreprocessorE")
//</editor-fold>
public static void ComputeDATE_TIME(SourceLocation /*&*/ DATELoc, SourceLocation /*&*/ TIMELoc, 
        Preprocessor /*&*/ PP) {
  long/*time_t*/ TT = time(/*(time_t * )*/null);
   tm /*P*/ TM = localtime($AddrOf(TT));
  
  final/*static*/ /*const*/String/*char P*//*const*/ Months[/*12*/] = ComputeDATE_TIME$$.Months;
  {
    raw_svector_ostream TmpStream = null;
    try {
      SmallString/*32*/ TmpBuffer/*J*/= new SmallString/*32*/(32);
      TmpStream/*J*/= new raw_svector_ostream(TmpBuffer);
      TmpStream.$out(String.format("\"%s %2d %4d\"", Months[TM.tm_mon], 
              TM.tm_mday, TM.tm_year + 1900));
      Token TmpTok/*J*/= new Token();
      TmpTok.startToken();
      PP.CreateString(TmpStream.str(), TmpTok);
      DATELoc.$assignMove(TmpTok.$getLocation());
    } finally {
      if (TmpStream != null) { TmpStream.$destroy(); }
    }
  }
  {
    raw_svector_ostream TmpStream = null;
    try {
      SmallString/*32*/ TmpBuffer/*J*/= new SmallString/*32*/(32);
      TmpStream/*J*/= new raw_svector_ostream(TmpBuffer);
      TmpStream.$out(String.format("\"%02d:%02d:%02d\"", 
              TM.tm_hour, TM.tm_min, TM.tm_sec));
      Token TmpTok/*J*/= new Token();
      TmpTok.startToken();
      PP.CreateString(TmpStream.str(), TmpTok);
      TIMELoc.$assignMove(TmpTok.$getLocation());
    } finally {
      if (TmpStream != null) { TmpStream.$destroy(); }
    }
  }
}
private static final class ComputeDATE_TIME$$ {
  private static final String Months[/*12*/] = new String [/*12*/] {
    "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
  };
}


/// HasFeature - Return true if we recognize and implement the feature
/// specified by the identifier as a standard language feature.
//<editor-fold defaultstate="collapsed" desc="HasFeature">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed for no-copy of param*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1049,
 FQN="HasFeature", NM="_ZL10HasFeatureRKN5clang12PreprocessorEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL10HasFeatureRKN5clang12PreprocessorEN4llvm9StringRefE")
//</editor-fold>
public static boolean HasFeature(/*const*/ Preprocessor /*&*/ PP, StringRef Feature) {
  /*const*/ LangOptions /*&*/ LangOpts = PP.getLangOpts();
  
  // Normalize the feature name, __foo__ becomes foo.
  if (Feature.startswith(/*STRINGREF_STR*/"__") && Feature.endswith(/*STRINGREF_STR*/"__") && $greatereq_uint(Feature.size(), 4)) {
    // JAVA: removed assign to allow NO_COPY for param
    Feature = (Feature.substr(2, Feature.size() - 4));
  }
  
  return new StringSwitchBool(/*NO_COPY*/Feature).
      Case(/*KEEP_STR*/"address_sanitizer", 
      LangOpts.Sanitize.hasOneOf(SanitizerKind.Address
             | SanitizerKind.KernelAddress)).
      Case(/*KEEP_STR*/"assume_nonnull", true).
      Case(/*KEEP_STR*/"attribute_analyzer_noreturn", true).
      Case(/*KEEP_STR*/"attribute_availability", true).
      Case(/*KEEP_STR*/"attribute_availability_with_message", true).
      Case(/*KEEP_STR*/"attribute_availability_app_extension", true).
      Case(/*KEEP_STR*/"attribute_availability_with_version_underscores", true).
      Case(/*KEEP_STR*/"attribute_availability_tvos", true).
      Case(/*KEEP_STR*/"attribute_availability_watchos", true).
      Case(/*KEEP_STR*/"attribute_availability_with_strict", true).
      Case(/*KEEP_STR*/"attribute_availability_with_replacement", true).
      Case(/*KEEP_STR*/"attribute_availability_in_templates", true).
      Case(/*KEEP_STR*/"attribute_cf_returns_not_retained", true).
      Case(/*KEEP_STR*/"attribute_cf_returns_retained", true).
      Case(/*KEEP_STR*/"attribute_cf_returns_on_parameters", true).
      Case(/*KEEP_STR*/"attribute_deprecated_with_message", true).
      Case(/*KEEP_STR*/"attribute_deprecated_with_replacement", true).
      Case(/*KEEP_STR*/"attribute_ext_vector_type", true).
      Case(/*KEEP_STR*/"attribute_ns_returns_not_retained", true).
      Case(/*KEEP_STR*/"attribute_ns_returns_retained", true).
      Case(/*KEEP_STR*/"attribute_ns_consumes_self", true).
      Case(/*KEEP_STR*/"attribute_ns_consumed", true).
      Case(/*KEEP_STR*/"attribute_cf_consumed", true).
      Case(/*KEEP_STR*/"attribute_objc_ivar_unused", true).
      Case(/*KEEP_STR*/"attribute_objc_method_family", true).
      Case(/*KEEP_STR*/"attribute_overloadable", true).
      Case(/*KEEP_STR*/"attribute_unavailable_with_message", true).
      Case(/*KEEP_STR*/"attribute_unused_on_fields", true).
      Case(/*KEEP_STR*/"blocks", LangOpts.Blocks).
      Case(/*KEEP_STR*/"c_thread_safety_attributes", true).
      Case(/*KEEP_STR*/"cxx_exceptions", LangOpts.CXXExceptions).
      Case(/*KEEP_STR*/"cxx_rtti", LangOpts.RTTI && LangOpts.RTTIData).
      Case(/*KEEP_STR*/"enumerator_attributes", true).
      Case(/*KEEP_STR*/"nullability", true).
      Case(/*KEEP_STR*/"memory_sanitizer", LangOpts.Sanitize.has(SanitizerKind.Memory)).
      Case(/*KEEP_STR*/"thread_sanitizer", LangOpts.Sanitize.has(SanitizerKind.Thread)).
      Case(/*KEEP_STR*/"dataflow_sanitizer", LangOpts.Sanitize.has(SanitizerKind.DataFlow)).
      Case(/*KEEP_STR*/"efficiency_sanitizer", 
      LangOpts.Sanitize.hasOneOf(SanitizerKind.Efficiency)).
      // Objective-C features
      Case(/*KEEP_STR*/"objc_arr", LangOpts.ObjCAutoRefCount). // FIXME: REMOVE?
      Case(/*KEEP_STR*/"objc_arc", LangOpts.ObjCAutoRefCount).
      Case(/*KEEP_STR*/"objc_arc_weak", LangOpts.ObjCWeak).
      Case(/*KEEP_STR*/"objc_default_synthesize_properties", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_fixed_enum", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_instancetype", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_kindof", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_modules", LangOpts.ObjC2 && LangOpts.Modules).
      Case(/*KEEP_STR*/"objc_nonfragile_abi", LangOpts.ObjCRuntime.isNonFragile()).
      Case(/*KEEP_STR*/"objc_property_explicit_atomic", 
      true). // Does clang support explicit "atomic" keyword?
      Case(/*KEEP_STR*/"objc_protocol_qualifier_mangling", true).
      Case(/*KEEP_STR*/"objc_weak_class", LangOpts.ObjCRuntime.hasWeakClassImport()).
      Case(/*KEEP_STR*/"ownership_holds", true).
      Case(/*KEEP_STR*/"ownership_returns", true).
      Case(/*KEEP_STR*/"ownership_takes", true).
      Case(/*KEEP_STR*/"objc_bool", true).
      Case(/*KEEP_STR*/"objc_subscripting", LangOpts.ObjCRuntime.isNonFragile()).
      Case(/*KEEP_STR*/"objc_array_literals", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_dictionary_literals", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_boxed_expressions", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_boxed_nsvalue_expressions", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"arc_cf_code_audited", true).
      Case(/*KEEP_STR*/"objc_bridge_id", true).
      Case(/*KEEP_STR*/"objc_bridge_id_on_typedefs", true).
      Case(/*KEEP_STR*/"objc_generics", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_generics_variance", LangOpts.ObjC2).
      Case(/*KEEP_STR*/"objc_class_property", LangOpts.ObjC2).
      // C11 features
      Case(/*KEEP_STR*/"c_alignas", LangOpts.C11).
      Case(/*KEEP_STR*/"c_alignof", LangOpts.C11).
      Case(/*KEEP_STR*/"c_atomic", LangOpts.C11).
      Case(/*KEEP_STR*/"c_generic_selections", LangOpts.C11).
      Case(/*KEEP_STR*/"c_static_assert", LangOpts.C11).
      Case(/*KEEP_STR*/"c_thread_local", 
      LangOpts.C11 && PP.getTargetInfo().isTLSSupported()).
      // C++11 features
      Case(/*KEEP_STR*/"cxx_access_control_sfinae", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_alias_templates", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_alignas", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_alignof", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_atomic", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_attributes", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_auto_type", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_constexpr", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_decltype", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_decltype_incomplete_return_types", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_default_function_template_args", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_defaulted_functions", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_delegating_constructors", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_deleted_functions", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_explicit_conversions", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_generalized_initializers", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_implicit_moves", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_inheriting_constructors", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_inline_namespaces", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_lambdas", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_local_type_template_args", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_nonstatic_member_init", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_noexcept", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_nullptr", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_override_control", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_range_for", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_raw_string_literals", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_reference_qualified_functions", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_rvalue_references", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_strong_enums", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_static_assert", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_thread_local", 
      LangOpts.CPlusPlus11 && PP.getTargetInfo().isTLSSupported()).
      Case(/*KEEP_STR*/"cxx_trailing_return", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_unicode_literals", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_unrestricted_unions", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_user_literals", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_variadic_templates", LangOpts.CPlusPlus11).
      // C++1y features
      Case(/*KEEP_STR*/"cxx_aggregate_nsdmi", LangOpts.CPlusPlus14).
      Case(/*KEEP_STR*/"cxx_binary_literals", LangOpts.CPlusPlus14).
      Case(/*KEEP_STR*/"cxx_contextual_conversions", LangOpts.CPlusPlus14).
      Case(/*KEEP_STR*/"cxx_decltype_auto", LangOpts.CPlusPlus14).
      Case(/*KEEP_STR*/"cxx_generic_lambdas", LangOpts.CPlusPlus14).
      Case(/*KEEP_STR*/"cxx_init_captures", LangOpts.CPlusPlus14).
      Case(/*KEEP_STR*/"cxx_relaxed_constexpr", LangOpts.CPlusPlus14).
      Case(/*KEEP_STR*/"cxx_return_type_deduction", LangOpts.CPlusPlus14).
      Case(/*KEEP_STR*/"cxx_variable_templates", LangOpts.CPlusPlus14).
      // C++ TSes
      //.Case("cxx_runtime_arrays", LangOpts.CPlusPlusTSArrays)
      //.Case("cxx_concepts", LangOpts.CPlusPlusTSConcepts)
      // FIXME: Should this be __has_feature or __has_extension?
      //.Case("raw_invocation_type", LangOpts.CPlusPlus)
      // Type traits
      // N.B. Additional type traits should not be added to the following list.
      // Instead, they should be detected by has_extension.
      Case(/*KEEP_STR*/"has_nothrow_assign", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"has_nothrow_copy", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"has_nothrow_constructor", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"has_trivial_assign", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"has_trivial_copy", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"has_trivial_constructor", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"has_trivial_destructor", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"has_virtual_destructor", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_abstract", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_base_of", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_class", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_constructible", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_convertible_to", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_empty", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_enum", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_final", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_literal", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_standard_layout", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_pod", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_polymorphic", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_sealed", LangOpts.CPlusPlus && LangOpts.MicrosoftExt).
      Case(/*KEEP_STR*/"is_trivial", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_trivially_assignable", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_trivially_constructible", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_trivially_copyable", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"is_union", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"modules", LangOpts.Modules).
      Case(/*KEEP_STR*/"safe_stack", LangOpts.Sanitize.has(SanitizerKind.SafeStack)).
      Case(/*KEEP_STR*/"tls", PP.getTargetInfo().isTLSSupported()).
      Case(/*KEEP_STR*/"underlying_type", LangOpts.CPlusPlus).
      Default(false);
}


/// HasExtension - Return true if we recognize and implement the feature
/// specified by the identifier, either as an extension or a standard language
/// feature.
//<editor-fold defaultstate="collapsed" desc="HasExtension">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed for no-copy of param*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1228,
 FQN="HasExtension", NM="_ZL12HasExtensionRKN5clang12PreprocessorEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL12HasExtensionRKN5clang12PreprocessorEN4llvm9StringRefE")
//</editor-fold>
public static boolean HasExtension(/*const*/ Preprocessor /*&*/ PP, /*NO_COPY*/StringRef Extension) {
  if (HasFeature(PP, Extension)) {
    return true;
  }
  
  // If the use of an extension results in an error diagnostic, extensions are
  // effectively unavailable, so just return false here.
  if (PP.getDiagnostics().getExtensionHandlingBehavior().getValue()
     >= diag.Severity.Error.getValue()) {
    return false;
  }
  
  /*const*/ LangOptions /*&*/ LangOpts = PP.getLangOpts();
  
  // Normalize the extension name, __foo__ becomes foo.
  if (Extension.startswith(/*STRINGREF_STR*/"__") && Extension.endswith(/*STRINGREF_STR*/"__")
     && $greatereq_uint(Extension.size(), 4)) {
    // JAVA: removed assign to allow NO_COPY for param
    Extension = (Extension.substr(2, Extension.size() - 4));
  }
  
  // Because we inherit the feature list from HasFeature, this string switch
  // must be less restrictive than HasFeature's.
  return new StringSwitchBool(/*NO_COPY*/Extension).
      // C11 features supported by other languages as extensions.
      Case(/*KEEP_STR*/"c_alignas", true).
      Case(/*KEEP_STR*/"c_alignof", true).
      Case(/*KEEP_STR*/"c_atomic", true).
      Case(/*KEEP_STR*/"c_generic_selections", true).
      Case(/*KEEP_STR*/"c_static_assert", true).
      Case(/*KEEP_STR*/"c_thread_local", PP.getTargetInfo().isTLSSupported()).
      // C++11 features supported by other languages as extensions.
      Case(/*KEEP_STR*/"cxx_atomic", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_deleted_functions", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_explicit_conversions", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_inline_namespaces", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_local_type_template_args", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_nonstatic_member_init", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_override_control", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_range_for", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_reference_qualified_functions", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_rvalue_references", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cxx_variadic_templates", LangOpts.CPlusPlus).
      // C++1y features supported by other languages as extensions.
      Case(/*KEEP_STR*/"cxx_binary_literals", true).
      Case(/*KEEP_STR*/"cxx_init_captures", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"cxx_variable_templates", LangOpts.CPlusPlus).
      Default(false);
}


/// EvaluateHasIncludeCommon - Process a '__has_include("path")'
/// or '__has_include_next("path")' expression.
/// Returns true if successful.
//<editor-fold defaultstate="collapsed" desc="EvaluateHasIncludeCommon">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*support for incomplete tokens*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1277,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 1266,
 FQN="EvaluateHasIncludeCommon", NM="_ZL24EvaluateHasIncludeCommonRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorEPKNS_15DirectoryLookupEPKNS_9FileEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL24EvaluateHasIncludeCommonRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorEPKNS_15DirectoryLookupEPKNS_9FileEntryE")
//</editor-fold>
public static boolean EvaluateHasIncludeCommon(Token /*&*/ Tok, 
                        IdentifierInfo /*P*/ II, Preprocessor /*&*/ PP, 
                        /*const*/type$ptr<DirectoryLookup> /*P*/ LookupFrom, 
                        /*const*/ FileEntry /*P*/ LookupFromFile) {
  // Save the location of the current token.  If a '(' is later found, use
  // that location.  If not, use the end of this location instead.
  SourceLocation LParenLoc = Tok.getLocation();

  // These expressions are only allowed within a preprocessor directive.
  if (!PP.isParsingIfOrElifDirective()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(/*NO_COPY*/LParenLoc, diag.err_pp_directive_required)), II.getName()));
      // Return a valid identifier token.
      assert (Tok.is(tok.TokenKind.identifier));
      Tok.setIdentifierInfo(II);
      return false;
    } finally {
      $c$.$destroy();
    }
  }

  // Get '('.
  PP.LexNonComment(Tok);

  // Ensure we have a '('.
  if (Tok.isNot(tok.TokenKind.l_paren)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {      
      // No '(', use end of last token.
      LParenLoc.$assignMove(PP.getLocForEndOfToken(/*NO_COPY*/LParenLoc));
      $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(PP.Diag(/*NO_COPY*/LParenLoc, diag.err_pp_expected_after)), II), tok.TokenKind.l_paren));
      // If the next token looks like a filename or the start of one,
      // assume it is and process it as such.
      if (!Tok.is(tok.TokenKind.angle_string_literal) && !Tok.is(tok.TokenKind.string_literal)
         && !Tok.is(tok.TokenKind.less)) {
        return false;
      }
    } finally {
      $c$.$destroy();
    }      
  } else {
    // Save '(' location for possible missing ')' message.
    LParenLoc.$assignMove(Tok.getLocation());
    if ((PP.getCurrentLexer() != null)) {
      // Get the file name.
      PP.getCurrentLexer().LexIncludeFilename(Tok);
    } else {
      // We're in a macro, so we can't use LexIncludeFilename; just
      // grab the next token.
      PP.Lex(Tok);
    }
  }

  // Reserve a buffer to get the spelling.
  SmallString/*128*/ FilenameBuffer/*J*/= new SmallString/*128*/(128);
  StringRef Filename/*J*/= new StringRef();
  SourceLocation EndLoc/*J*/= new SourceLocation();
  switch (Tok.getKind()) {
   case tok.TokenKind.eod:
    // If the token kind is EOD, the error has already been diagnosed.
    return false;
   case tok.TokenKind.angle_string_literal:
   case tok.TokenKind.string_literal:
    {
      if (Tok.isIncomplete()) { // JAVA FIX: support incomplete filename tokens
        // copied Diagnostics from default branch to fix test test_has_include_c 
        // Preprocessor/has_include.c: line 140
        // #if __has_include("stdint.h)
        // #endif
        PP.Diag(Tok.getLocation(), diag.err_pp_expects_filename).$destroy();
        return false;
      } else {
        bool$ptr Invalid = create_bool$ptr(false);
        Filename.$assignMove(PP.getSpelling(Tok, FilenameBuffer, $AddrOf(Invalid)));
        if (Invalid.$star()) {
          return false;
        }
      }
      break;
    }
   case tok.TokenKind.less:
    // This could be a <foo/bar.h> file coming from a macro expansion.  In this
    // case, glue the tokens together into FilenameBuffer and interpret those.
    FilenameBuffer.push_back($$LT);
    if (PP.ConcatenateIncludeName(FilenameBuffer, EndLoc)) {
      // Let the caller know a <eod> was found by changing the Token kind.
      Tok.setKind(tok.TokenKind.eod);
      return false; // Found <eod> but no ">"?  Diagnostic already emitted.
    }
    Filename.$assignMove(FilenameBuffer.$StringRef());
    break;
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_pp_expects_filename)));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
  }

  SourceLocation FilenameLoc = Tok.getLocation();

  // Get ')'.
  PP.LexNonComment(Tok);

  // Ensure we have a trailing ).
  if (Tok.isNot(tok.TokenKind.r_paren)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {      
      $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(PP.Diag(PP.getLocForEndOfToken(/*NO_COPY*/FilenameLoc), diag.err_pp_expected_after)), 
              II), tok.TokenKind.r_paren));
      $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(/*NO_COPY*/LParenLoc, diag.note_matching)), tok.TokenKind.l_paren));
      return false;
    } finally {
      $c$.$destroy();
    }      
  }

  boolean isAngled = PP.GetIncludeFilenameSpelling(Tok.$getLocation(), Filename);
  // If GetIncludeFilenameSpelling set the start ptr to null, there was an
  // error.
  if (Filename.empty()) {
    return false;
  }

  // Search include directories.
  /*const*/type$ref<type$ptr<DirectoryLookup>> /*P*/ CurDir = create_type$ref(null);
  /*const*/ FileEntry /*P*/ File = PP.LookupFile(/*NO_COPY*/FilenameLoc, /*NO_COPY*/Filename, isAngled, LookupFrom, LookupFromFile, 
      CurDir, (SmallString/*P*/ )null, (SmallString/*P*/ )null, (ModuleMap.KnownHeader /*P*/ )null);

  // Get the result value.  A result of true means the file exists.
  return File != null;
}


/// EvaluateHasInclude - Process a '__has_include("path")' expression.
/// Returns true if successful.
//<editor-fold defaultstate="collapsed" desc="EvaluateHasInclude">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1387,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 1376,
 FQN="EvaluateHasInclude", NM="_ZL18EvaluateHasIncludeRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL18EvaluateHasIncludeRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorE")
//</editor-fold>
public static boolean EvaluateHasInclude(Token /*&*/ Tok, IdentifierInfo /*P*/ II, 
        Preprocessor /*&*/ PP) {
  return EvaluateHasIncludeCommon(Tok, II, PP, (/*const*/type$ptr<DirectoryLookup> /*P*/ )null, (/*const*/ FileEntry /*P*/ )null);
}


/// EvaluateHasIncludeNext - Process '__has_include_next("path")' expression.
/// Returns true if successful.
//<editor-fold defaultstate="collapsed" desc="EvaluateHasIncludeNext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1394,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", old_line = 1383,
 FQN="EvaluateHasIncludeNext", NM="_ZL22EvaluateHasIncludeNextRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL22EvaluateHasIncludeNextRN5clang5TokenEPNS_14IdentifierInfoERNS_12PreprocessorE")
//</editor-fold>
public static boolean EvaluateHasIncludeNext(Token /*&*/ Tok, 
                      IdentifierInfo /*P*/ II, Preprocessor /*&*/ PP) {
  // __has_include_next is like __has_include, except that we start
  // searching after the current found directory.  If we can't do this,
  // issue a diagnostic.
  // FIXME: Factor out duplication with 
  // Preprocessor::HandleIncludeNextDirective.
  /*const*/type$ptr<DirectoryLookup> /*P*/ Lookup = $tryClone(PP.GetCurDirLookup());
  /*const*/ FileEntry /*P*/ LookupFromFile = null;
  if (PP.isInPrimaryFile()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Lookup = null;
      $c$.clean($c$.track(PP.Diag(Tok, diag.pp_include_next_in_primary)));
    } finally {
      $c$.$destroy();
    }
  } else if ((PP.getCurrentSubmodule() != null)) {
    // Start looking up in the directory *after* the one in which the current
    // file would be found, if any.
    assert ((PP.getCurrentLexer() != null)) : "#include_next directive in macro?";
    LookupFromFile = PP.getCurrentLexer().getFileEntry();
    Lookup = null;
  } else if (!(Lookup != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(PP.Diag(Tok, diag.pp_include_next_absolute_path)));
    } finally {
      $c$.$destroy();
    }
  } else {
    // Start looking up in the next directory.
    Lookup.$preInc();
  }

  return EvaluateHasIncludeCommon(Tok, II, PP, Lookup, LookupFromFile);
}


/// \brief Process single-argument builtin feature-like macros that return
/// integer values.
//<editor-fold defaultstate="collapsed" desc="EvaluateFeatureLikeBuiltinMacro">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*fixed goto statements*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1424,
 FQN="EvaluateFeatureLikeBuiltinMacro", NM="_ZL31EvaluateFeatureLikeBuiltinMacroRN4llvm19raw_svector_ostreamERN5clang5TokenEPNS2_14IdentifierInfoERNS2_12PreprocessorENS_12function_refIFiS4_RbEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL31EvaluateFeatureLikeBuiltinMacroRN4llvm19raw_svector_ostreamERN5clang5TokenEPNS2_14IdentifierInfoERNS2_12PreprocessorENS_12function_refIFiS4_RbEEE")
//</editor-fold>
public static void EvaluateFeatureLikeBuiltinMacro(raw_svector_ostream /*&*/ OS, 
                               Token /*&*/ Tok, IdentifierInfo /*P*/ II, 
                               Preprocessor /*&*/ PP, 
                               LexFunctionPointers.TokenBoolRef2Int Op) {
  // Parse the initial '('.
  PP.LexUnexpandedToken(Tok);
  if (Tok.isNot(tok.TokenKind.l_paren)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(PP.Diag(Tok.getLocation(), diag.err_pp_expected_after)), II), 
          tok.TokenKind.l_paren));
      
      // Provide a dummy '0' value on output stream to elide further errors.
      if (!Tok.isOneOf(tok.TokenKind.eof, tok.TokenKind.eod)) {
        OS.$out_int(0);
        Tok.setKind(tok.TokenKind.numeric_constant);
      }
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*uint*/int ParenDepth = 1;
  SourceLocation LParenLoc = Tok.getLocation();
  OptionalInt Result/*J*/= new OptionalInt();
  
  Token ResultTok/*J*/= new Token();
  boolean SuppressDiagnostic = false;
  JAVA$OUTER: while (true) {// JAVA: added OUTER lable for 'continue OUTER' statements
    // Parse next token.
    PP.LexUnexpandedToken(Tok);
   already_lexed:while(true) { // JAVA: added while(true) to fix 'goto already_lexed', changed all continue to 'continue OUTER'
    switch (Tok.getKind()) {
     case tok.TokenKind.eof:
     case tok.TokenKind.eod:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Don't provide even a dummy value if the eod or eof marker is
          // reached.  Simply provide a diagnostic.
          $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_unterm_macro_invoc)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
     case tok.TokenKind.comma:
      if (!SuppressDiagnostic) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_too_many_args_in_macro_invoc)));
          SuppressDiagnostic = true;
        } finally {
          $c$.$destroy();
        }
      }
      continue JAVA$OUTER;// JAVA: added OUTER
     case tok.TokenKind.l_paren:
      ++ParenDepth;
      if (Result.hasValue()) {
        break;
      }
      if (!SuppressDiagnostic) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(PP.Diag(Tok.getLocation(), diag.err_pp_nested_paren)), II));
          SuppressDiagnostic = true;
        } finally {
          $c$.$destroy();
        }
      }
      continue JAVA$OUTER;// JAVA: added OUTER
     case tok.TokenKind.r_paren:
      if ($greater_uint(--ParenDepth, 0)) {
        continue JAVA$OUTER; // JAVA: added OUTER
      }
      
      // The last ')' has been reached; return the value if one found or
      // a diagnostic and a dummy value.
      if (Result.hasValue()) {
        OS.$out_int(Result.getValue());
      } else {
        OS.$out_int(0);
        if (!SuppressDiagnostic) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_too_few_args_in_macro_invoc)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      Tok.setKind(tok.TokenKind.numeric_constant);
      return;
     default:
      {
        // Parse the macro argument, if one not found so far.
        if (Result.hasValue()) {
          break;
        }
        
        bool$ref HasLexedNextToken = create_bool$ref(false);
        Result.$assign(Op.$call(Tok, /*KEEP_BOOL*/HasLexedNextToken));
        ResultTok.$assign(Tok);
        if (HasLexedNextToken.$deref()) {
          continue already_lexed;
        }
        continue JAVA$OUTER;// JAVA: added OUTER
      }
    }
    break already_lexed;
   } // JAVA: end of already_lexed lable loop
   
    // Diagnose missing ')'.
    if (!SuppressDiagnostic) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        {
          DiagnosticBuilder Diag = null;
          try {
            Diag = PP.Diag(Tok.getLocation(), diag.err_pp_expected_after);
            if (Diag.$bool()) {
              {
                IdentifierInfo /*P*/ LastII = ResultTok.getIdentifierInfo();
                if ((LastII != null)) {
                  $out_DiagnosticBuilder$C_IdentifierInfo$C$P(Diag, LastII);
                } else {
                  $out_DiagnosticBuilder$C_TokenKind(Diag, ResultTok.getKind());
                }
              }
              $out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_TokenKind(Diag, tok.TokenKind.r_paren), new SourceRange(ResultTok.getLocation()));
            }
          } finally {
            if (Diag != null) { Diag.$destroy(); }
          }
        }
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(/*NO_COPY*/LParenLoc, diag.note_matching)), tok.TokenKind.l_paren));
        SuppressDiagnostic = true;
      } finally {
        $c$.$destroy();
      }
    }
  }
}

/// \brief Helper function to return the IdentifierInfo structure of a Token
/// or generate a diagnostic if none available.
//<editor-fold defaultstate="collapsed" desc="ExpectFeatureIdentifierInfo">
@Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp", line = 1527,
 FQN="ExpectFeatureIdentifierInfo", NM="_ZL27ExpectFeatureIdentifierInfoRN5clang5TokenERNS_12PreprocessorEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZL27ExpectFeatureIdentifierInfoRN5clang5TokenERNS_12PreprocessorEi")
//</editor-fold>
public static IdentifierInfo /*P*/ ExpectFeatureIdentifierInfo(Token /*&*/ Tok, 
                           Preprocessor /*&*/ PP, 
                           int DiagID) {
  // JAVA: moved cleaner close to Diag
  IdentifierInfo /*P*/ II;
  if (!Tok.isAnnotation() && ((II = Tok.getIdentifierInfo()) != null)) {
    return II;
  }
    
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($c$.track(PP.Diag(Tok.getLocation(), DiagID)));
    return null;
  } finally {
    $c$.$destroy();
  }
}

} // END OF class PPMacroExpansionStatics
