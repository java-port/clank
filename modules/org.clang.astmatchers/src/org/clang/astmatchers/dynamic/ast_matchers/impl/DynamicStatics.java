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
package org.clang.astmatchers.dynamic.ast_matchers.impl;

import org.clang.astmatchers.dynamic.ast_matchers.impl.llvm.ParserRegistrySemaInfo;
import org.clang.astmatchers.dynamic.ast_matchers.impl.llvm.RegistryMapsInfo;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import org.clang.astmatchers.ast_matchers.*;
import org.clang.astmatchers.ast_matchers.internal.*;
import org.clang.astmatchers.ast_matchers.internal.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import static org.clang.ast.ast_type_traits.Ast_type_traitsGlobals.*;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type DynamicStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_1L12RegistryDataE;_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_1lsERN4llvm11raw_ostreamERKSt3setINS_15ast_type_traits11ASTNodeKindESt4lessIS8_ESaIS8_EE;_ZN5clang12ast_matchers7dynamicL17formatErrorStringEN4llvm9StringRefENS2_8ArrayRefISsEERNS2_11raw_ostreamE;_ZN5clang12ast_matchers7dynamicL19DefaultRegistrySemaE;_ZN5clang12ast_matchers7dynamicL20printMessageToStreamERKNS1_11Diagnostics12ErrorContent7MessageEN4llvm5TwineERNS7_11raw_ostreamE;_ZN5clang12ast_matchers7dynamicL21maybeAddLineAndColumnENS1_11SourceRangeERN4llvm11raw_ostreamE;_ZN5clang12ast_matchers7dynamicL23errorTypeToFormatStringENS1_11Diagnostics9ErrorTypeE;_ZN5clang12ast_matchers7dynamicL25contextTypeToFormatStringENS1_11Diagnostics11ContextTypeE;_ZN5clang12ast_matchers7dynamicL25printContextFrameToStreamERKNS1_11Diagnostics12ContextFrameERN4llvm11raw_ostreamE;_ZN5clang12ast_matchers7dynamicL25printErrorContentToStreamERKNS1_11Diagnostics12ErrorContentERN4llvm11raw_ostreamE; -static-type=DynamicStatics -package=org.clang.astmatchers.dynamic.ast_matchers.impl")
//</editor-fold>
public final class DynamicStatics {

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::contextTypeToFormatString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 77,
 FQN="clang::ast_matchers::dynamic::contextTypeToFormatString", NM="_ZN5clang12ast_matchers7dynamicL25contextTypeToFormatStringENS1_11Diagnostics11ContextTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamicL25contextTypeToFormatStringENS1_11Diagnostics11ContextTypeE")
//</editor-fold>
public static StringRef contextTypeToFormatString(Diagnostics.ContextType Type) {
  switch (Type) {
   case CT_MatcherConstruct:
    return new StringRef(/*KEEP_STR*/"Error building matcher $0.");
   case CT_MatcherArg:
    return new StringRef(/*KEEP_STR*/"Error parsing argument $0 for matcher $1.");
  }
  throw new llvm_unreachable("Unknown ContextType value.");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::errorTypeToFormatString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 87,
 FQN="clang::ast_matchers::dynamic::errorTypeToFormatString", NM="_ZN5clang12ast_matchers7dynamicL23errorTypeToFormatStringENS1_11Diagnostics9ErrorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamicL23errorTypeToFormatStringENS1_11Diagnostics9ErrorTypeE")
//</editor-fold>
public static StringRef errorTypeToFormatString(Diagnostics.ErrorType Type) {
  switch (Type) {
   case ET_RegistryMatcherNotFound:
    return new StringRef(/*KEEP_STR*/"Matcher not found: $0");
   case ET_RegistryWrongArgCount:
    return new StringRef(/*KEEP_STR*/"Incorrect argument count. (Expected = $0) != (Actual = $1)");
   case ET_RegistryWrongArgType:
    return new StringRef(/*KEEP_STR*/"Incorrect type for arg $0. (Expected = $1) != (Actual = $2)");
   case ET_RegistryNotBindable:
    return new StringRef(/*KEEP_STR*/"Matcher does not support binding.");
   case ET_RegistryAmbiguousOverload:
    // TODO: Add type info about the overload error.
    return new StringRef(/*KEEP_STR*/"Ambiguous matcher overload.");
   case ET_RegistryValueNotFound:
    return new StringRef(/*KEEP_STR*/"Value not found: $0");
   case ET_ParserStringError:
    return new StringRef(/*KEEP_STR*/"Error parsing string token: <$0>");
   case ET_ParserNoOpenParen:
    return new StringRef(/*KEEP_STR*/"Error parsing matcher. Found token <$0> while looking for '('.");
   case ET_ParserNoCloseParen:
    return new StringRef(/*KEEP_STR*/"Error parsing matcher. Found end-of-code while looking for ')'.");
   case ET_ParserNoComma:
    return new StringRef(/*KEEP_STR*/"Error parsing matcher. Found token <$0> while looking for ','.");
   case ET_ParserNoCode:
    return new StringRef(/*KEEP_STR*/"End of code found while looking for token.");
   case ET_ParserNotAMatcher:
    return new StringRef(/*KEEP_STR*/"Input value is not a matcher expression.");
   case ET_ParserInvalidToken:
    return new StringRef(/*KEEP_STR*/"Invalid token <$0> found when looking for a value.");
   case ET_ParserMalformedBindExpr:
    return new StringRef(/*KEEP_STR*/"Malformed bind() expression.");
   case ET_ParserTrailingCode:
    return new StringRef(/*KEEP_STR*/"Expected end of code.");
   case ET_ParserUnsignedError:
    return new StringRef(/*KEEP_STR*/"Error parsing unsigned token: <$0>");
   case ET_ParserOverloadedType:
    return new StringRef(/*KEEP_STR*/"Input value has unresolved overloaded type: $0");
   case ET_None:
    return new StringRef(/*KEEP_STR*/"<N/A>");
  }
  throw new llvm_unreachable("Unknown ErrorType value.");
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::formatErrorString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 132,
 FQN="clang::ast_matchers::dynamic::formatErrorString", NM="_ZN5clang12ast_matchers7dynamicL17formatErrorStringEN4llvm9StringRefENS2_8ArrayRefISsEERNS2_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamicL17formatErrorStringEN4llvm9StringRefENS2_8ArrayRefISsEERNS2_11raw_ostreamE")
//</editor-fold>
public static void formatErrorString(StringRef FormatString, 
                 ArrayRef<std.string> Args, 
                 final raw_ostream /*&*/ OS) {
  while (!FormatString.empty()) {
    std.pair<StringRef, StringRef> Pieces = FormatString.split(/*STRINGREF_STR*/"$");
    OS.$out(Pieces.first.str());
    if (Pieces.second.empty()) {
      break;
    }
    
    /*const*//*char*/byte Next = Pieces.second.front();
    FormatString.$assignMove(Pieces.second.drop_front());
    if (Next >= $$0 && Next <= $$9) {
      /*const*//*uint*/int Index = Next - $$0;
      if ($less_uint(Index, Args.size())) {
        OS.$out(Args.$at(Index));
      } else {
        OS.$out(/*KEEP_STR*/"<Argument_Not_Provided>");
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::maybeAddLineAndColumn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 153,
 FQN="clang::ast_matchers::dynamic::maybeAddLineAndColumn", NM="_ZN5clang12ast_matchers7dynamicL21maybeAddLineAndColumnENS1_11SourceRangeERN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamicL21maybeAddLineAndColumnENS1_11SourceRangeERN4llvm11raw_ostreamE")
//</editor-fold>
public static void maybeAddLineAndColumn(SourceRange Range, 
                     final raw_ostream /*&*/ OS) {
  if ($greater_uint(Range.Start.Line, 0) && $greater_uint(Range.Start.Column, 0)) {
    OS.$out_uint(Range.Start.Line).$out(/*KEEP_STR*/$COLON).$out_uint(Range.Start.Column).$out(/*KEEP_STR*/": ");
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::printContextFrameToStream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 160,
 FQN="clang::ast_matchers::dynamic::printContextFrameToStream", NM="_ZN5clang12ast_matchers7dynamicL25printContextFrameToStreamERKNS1_11Diagnostics12ContextFrameERN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamicL25printContextFrameToStreamERKNS1_11Diagnostics12ContextFrameERN4llvm11raw_ostreamE")
//</editor-fold>
public static void printContextFrameToStream(final /*const*/ Diagnostics.ContextFrame /*&*/ Frame, 
                         final raw_ostream /*&*/ OS) {
  maybeAddLineAndColumn(new SourceRange(Frame.Range), OS);
  formatErrorString(contextTypeToFormatString(Frame.Type), new ArrayRef<std.string>(Frame.Args, false), OS);
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::printMessageToStream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 166,
 FQN="clang::ast_matchers::dynamic::printMessageToStream", NM="_ZN5clang12ast_matchers7dynamicL20printMessageToStreamERKNS1_11Diagnostics12ErrorContent7MessageEN4llvm5TwineERNS7_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamicL20printMessageToStreamERKNS1_11Diagnostics12ErrorContent7MessageEN4llvm5TwineERNS7_11raw_ostreamE")
//</editor-fold>
public static void printMessageToStream(final /*const*/ Diagnostics.ErrorContent.Message /*&*/ Message, 
                    /*const*/ Twine Prefix, final raw_ostream /*&*/ OS) {
  maybeAddLineAndColumn(new SourceRange(Message.Range), OS);
  $out_raw_ostream_Twine$C(OS, Prefix);
  formatErrorString(errorTypeToFormatString(Message.Type), new ArrayRef<std.string>(Message.Args, false), OS);
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::printErrorContentToStream">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp", line = 174,
 FQN="clang::ast_matchers::dynamic::printErrorContentToStream", NM="_ZN5clang12ast_matchers7dynamicL25printErrorContentToStreamERKNS1_11Diagnostics12ErrorContentERN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Diagnostics.cpp -nm=_ZN5clang12ast_matchers7dynamicL25printErrorContentToStreamERKNS1_11Diagnostics12ErrorContentERN4llvm11raw_ostreamE")
//</editor-fold>
public static void printErrorContentToStream(final /*const*/ Diagnostics.ErrorContent /*&*/ Content, 
                         final raw_ostream /*&*/ OS) {
  if (Content.Messages.size() == 1) {
    printMessageToStream(Content.Messages.$at$Const(0), new Twine(/*KEEP_STR*/$EMPTY), OS);
  } else {
    for (/*size_t*/int i = 0, e = Content.Messages.size(); i != e; ++i) {
      if (i != 0) {
        OS.$out(/*KEEP_STR*/$LF);
      }
      printMessageToStream(Content.Messages.$at$Const(i), 
          $add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"Candidate "), new Twine(JD$UInt.INSTANCE, i + 1)), new Twine(/*KEEP_STR*/": ")), OS);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::DefaultRegistrySema">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp", line = 522,
 FQN="clang::ast_matchers::dynamic::DefaultRegistrySema", NM="_ZN5clang12ast_matchers7dynamicL19DefaultRegistrySemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Parser.cpp -nm=_ZN5clang12ast_matchers7dynamicL19DefaultRegistrySemaE")
//</editor-fold>
public static ManagedStatic<Parser.RegistrySema> DefaultRegistrySema/*J*/= new ManagedStatic<Parser.RegistrySema>(new ParserRegistrySemaInfo());
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 428,
 FQN="clang::ast_matchers::dynamic::(anonymous namespace)::RegistryData", NM="_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_1L12RegistryDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_1L12RegistryDataE")
//</editor-fold>
public static ManagedStatic<RegistryMaps> RegistryData/*J*/= new ManagedStatic<RegistryMaps>(new RegistryMapsInfo());
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::dynamic::(anonymous namespace)::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp", line = 443,
 FQN="clang::ast_matchers::dynamic::(anonymous namespace)::operator<<", NM="_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_1lsERN4llvm11raw_ostreamERKSt3setINS_15ast_type_traits11ASTNodeKindESt4lessIS8_ESaIS8_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/Dynamic/Registry.cpp -nm=_ZN5clang12ast_matchers7dynamic12_GLOBAL__N_1lsERN4llvm11raw_ostreamERKSt3setINS_15ast_type_traits11ASTNodeKindESt4lessIS8_ESaIS8_EE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_set$ASTNodeKind$C(final raw_ostream /*&*/ OS, 
                                  final /*const*/ std.setType<ASTNodeKind> /*&*/ KS) {
  /*uint*/int Count = 0;
  for (std.setType.iterator<ASTNodeKind> I = KS.begin(), E = KS.end();
       I.$noteq(E); I.$preInc()) {
    if (I.$noteq(KS.begin())) {
      OS.$out(/*KEEP_STR*/$PIPE);
    }
    if (Count++ == 3) {
      OS.$out(/*KEEP_STR*/$ELLIPSIS);
      break;
    }
    $out_raw_ostream_ASTNodeKind(OS, /*NO_COPY*/I.$star());
  }
  return OS;
}

} // END OF class DynamicStatics
