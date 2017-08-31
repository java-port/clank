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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.impl.*;
import org.clang.frontend.java.impl.PrintPPOutputHelper;
import org.clang.lex.Preprocessor_NestedClasses.MacroState;


//<editor-fold defaultstate="collapsed" desc="static type PrintPreprocessedOutputStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZL13DoPrintMacrosRN5clang12PreprocessorEPN4llvm11raw_ostreamE;_ZL14MacroIDComparePKSt4pairIPKN5clang14IdentifierInfoEPNS0_9MacroInfoEES8_;_ZL15outputPrintableRN4llvm11raw_ostreamENS_9StringRefE;_ZL20PrintMacroDefinitionRKN5clang14IdentifierInfoERKNS_9MacroInfoERNS_12PreprocessorERN4llvm11raw_ostreamE;_ZL23PrintPreprocessedTokensRN5clang12PreprocessorERNS_5TokenEPN12_GLOBAL__N_124PrintPPOutputPPCallbacksERN4llvm11raw_ostreamE; -static-type=PrintPreprocessedOutputStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class PrintPreprocessedOutputStatics {


/// PrintMacroDefinition - Print a macro definition in a form that will be
/// properly accepted back as a definition.
//<editor-fold defaultstate="collapsed" desc="PrintMacroDefinition">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 35,
 FQN="PrintMacroDefinition", NM="_ZL20PrintMacroDefinitionRKN5clang14IdentifierInfoERKNS_9MacroInfoERNS_12PreprocessorERN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZL20PrintMacroDefinitionRKN5clang14IdentifierInfoERKNS_9MacroInfoERNS_12PreprocessorERN4llvm11raw_ostreamE")
//</editor-fold>
public static void PrintMacroDefinition(/*const*/ IdentifierInfo /*&*/ II, /*const*/ MacroInfo /*&*/ MI, 
                    Preprocessor /*&*/ PP, raw_ostream /*&*/ OS) {
  OS.$out(/*KEEP_STR*/"#define ").$out(II.getName());
  if (MI.isFunctionLike()) {
    OS.$out_char($$LPAREN);
    if (!MI.arg_empty()) {
      IdentifierInfo[] ArgumentList = MI.$args();
      int/*arg_iterator*/ AI = 0, E = MI.getNumArgs();
      for (; (AI + 1) != E; ++AI) {
        OS.$out(ArgumentList[AI].getName());
        OS.$out_char($$COMMA);
      }
      
      // Last argument.
      if ($eq_StringRef(ArgumentList[AI].getName(), /*STRINGREF_STR*/"__VA_ARGS__")) {
        OS.$out(/*KEEP_STR*/$ELLIPSIS);
      } else {
        OS.$out(ArgumentList[AI].getName());
      }
    }
    if (MI.isGNUVarargs()) {
      OS.$out(/*KEEP_STR*/$ELLIPSIS); // #define foo(x...)
    }
    
    OS.$out_char($$RPAREN);
  }
  
  // GCC always emits a space, even if the macro body is empty.  However, do not
  // want to emit two spaces if the first token has a leading space.
  if (MI.tokens_empty() || !MI.tokens_begin().$star().hasLeadingSpace()) {
    OS.$out_char($$SPACE);
  }
  
  SmallString/*128*/ SpellingBuffer/*J*/= new SmallString/*128*/(128);
  for (/*const*/ Token /*&*/ T : MI.tokens()) {
    if (T.hasLeadingSpace()) {
      OS.$out_char($$SPACE);
    }
    
    OS.$out(PP.getSpelling(T, SpellingBuffer));
  }
}

//<editor-fold defaultstate="collapsed" desc="outputPrintable">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 384,
 FQN="outputPrintable", NM="_ZL15outputPrintableRN4llvm11raw_ostreamENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZL15outputPrintableRN4llvm11raw_ostreamENS_9StringRefE")
//</editor-fold>
public static void outputPrintable(raw_ostream /*&*/ OS, StringRef Str) {
  for (/*uint*/int i = 0, e = Str.size(); i != e; ++i) {
    /*uchar*/byte Char = Str.$at(i);
    if (isPrintable(Char) && $uchar2int(Char) != $$BACK_SLASH && $uchar2int(Char) != $$DBL_QUOTE) {
      OS.$out_char((/*char*/byte)Char);
    } else { // Output anything hard as an octal escape.
      OS.$out_char($$BACK_SLASH).$out_char(
          (/*char*/byte)($$0 + (($uchar2int(Char) >> 6) & 7))
      ).$out_char(
          (/*char*/byte)($$0 + (($uchar2int(Char) >> 3) & 7))
      ).$out_char(
          (/*char*/byte)($$0 + (($uchar2int(Char) >> 0) & 7))
      );
    }
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="PrintPreprocessedTokens">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.COMPLEX/*use helper*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 628,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 607,
 FQN="PrintPreprocessedTokens", NM="_ZL23PrintPreprocessedTokensRN5clang12PreprocessorERNS_5TokenEPN12_GLOBAL__N_124PrintPPOutputPPCallbacksERN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZL23PrintPreprocessedTokensRN5clang12PreprocessorERNS_5TokenEPN12_GLOBAL__N_124PrintPPOutputPPCallbacksERN4llvm11raw_ostreamE")
//</editor-fold>
public static void PrintPreprocessedTokens(Preprocessor /*&*/ PP, Token /*&*/ Tok, 
                       PrintPPOutputPPCallbacks /*P*/ Callbacks, 
                       raw_ostream /*&*/ OS) {
  boolean DropComments = PP.getLangOpts().TraditionalCPP
     && !PP.getCommentRetentionState();
// /*const*/char$ptr/*char P*/ Buffer = create_char$ptr(new$char(256));  
  PrintPPOutputHelper $Helper = Callbacks.$getPrintPPOutputHelper();
  Token PrevPrevTok/*J*/= $Helper.$PrevPrevTok(), PrevTok/*J*/= $Helper.$PrevTok();  
  PrevPrevTok.startToken();
  PrevTok.startToken();
  while (true) {
    if (Callbacks.hasEmittedDirectiveOnThisLine()) {
      Callbacks.startNewLineIfNeeded();
      Callbacks.MoveToLine(Tok.$getLocation());
    }
    
    // If this token is at the start of a line, emit newlines if needed.
    if (Tok.isAtStartOfLine() && Callbacks.HandleFirstTokOnLine(Tok)) {
      // done.
    } else if (Tok.hasLeadingSpace()
      // If we haven't emitted a token on this line yet, PrevTok isn't
      // useful to look at and no concatenation could happen anyway.
       || (Callbacks.hasEmittedTokensOnThisLine()
      // Don't print "-" next to "-", it would form "--".
       && Callbacks.AvoidConcat(PrevPrevTok, PrevTok, Tok))) {
      OS.$out_char($$SPACE);
    }
    if (DropComments && Tok.is(tok.TokenKind.comment)) {
      // Skip comments. Normally the preprocessor does not generate
      // tok::comment nodes at all when not keeping comments, but under
      // -traditional-cpp the lexer keeps /all/ whitespace, including comments.
      /*SourceLocation*/int StartLoc = Tok.$getLocation();
      Callbacks.MoveToLine(SourceLocation.$getLocWithOffset(StartLoc, Tok.getLength()));      
    } else if (Tok.is(tok.TokenKind.annot_module_include)
       || Tok.is(tok.TokenKind.annot_module_begin)
       || Tok.is(tok.TokenKind.annot_module_end)) {
      // PrintPPOutputPPCallbacks::InclusionDirective handles producing
      // appropriate output here. Ignore this token entirely.
      PP.Lex(Tok);
      continue;
    } else {
      IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
      if ((II != null)) {
        // JAVA PERF
        StringMapEntryBase entry = II.getEntry();
        assert entry != null;        
        OS.write(entry.getKeyArray(), entry.getKeyArrayIndex(), entry.getKeyLength());
      } else if (Tok.isLiteral() && !Tok.needsCleaning()
         && (Tok.getLiteralData() != null)) {
        // JAVA PERF
        OS.write(Tok.$CharPtrData(), Tok.$CharPtrDataIndex(), Tok.getLength());
      } else if (Tok.getLength() < 256) {
        // JAVA PERF
        /*char*/char$ptr TokPtr = $Helper.$CharBufPtr();
        /*uint*/int Len = PP.getSpelling(Tok, TokPtr);
        OS.write(TokPtr, Len);
        
        // Tokens that can contain embedded newlines need to adjust our current
        // line number.
        if (Tok.getKind() == tok.TokenKind.comment || Tok.getKind() == tok.TokenKind.unknown) {
          Callbacks.HandleNewlinesInToken(TokPtr, Len);
        }
        $Helper.$reset$CharBufPtr();// JAVA PERF
      } else {
        std.string S = PP.getSpelling(Tok);
        OS.write(/*AddrOf*/S.data(), S.size());
        
        // Tokens that can contain embedded newlines need to adjust our current
        // line number.
        if (Tok.getKind() == tok.TokenKind.comment || Tok.getKind() == tok.TokenKind.unknown) {
          Callbacks.HandleNewlinesInToken(/*AddrOf*/S.data(), S.size());
        }
      }
    }
    Callbacks.setEmittedTokensOnThisLine();
    if (Tok.is(tok.TokenKind.eof)) {
      break;
    }
    
    PrevPrevTok.$assign(PrevTok);
    PrevTok.$assign(Tok);
    PP.Lex(Tok);
  }
  Callbacks.$releasePrintPPOutputHelper($Helper);
}

//<editor-fold defaultstate="collapsed" desc="MacroIDCompare">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 703,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 682,
 FQN="MacroIDCompare", NM="_ZL14MacroIDComparePKSt4pairIPKN5clang14IdentifierInfoEPNS0_9MacroInfoEES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZL14MacroIDComparePKSt4pairIPKN5clang14IdentifierInfoEPNS0_9MacroInfoEES8_")
//</editor-fold>
public static int MacroIDCompare(/*const*/std.pair<IdentifierInfo /*P*/, MacroInfo /*P*/>/*P*/ LHS, /*const*/std.pair<IdentifierInfo /*P*/, MacroInfo /*P*/>/*P*/ RHS) {
  return LHS.first.getName().compare(RHS.first.getName());
}

//<editor-fold defaultstate="collapsed" desc="DoPrintMacros">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 707,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 686,
 FQN="DoPrintMacros", NM="_ZL13DoPrintMacrosRN5clang12PreprocessorEPN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZL13DoPrintMacrosRN5clang12PreprocessorEPN4llvm11raw_ostreamE")
//</editor-fold>
public static void DoPrintMacros(Preprocessor /*&*/ PP, raw_ostream /*P*/ OS) {
  // Ignore unknown pragmas.
  PP.IgnorePragmas();
  
  // -dM mode just scans and ignores all tokens in the files, then dumps out
  // the macro table at the end.
  PP.EnterMainSourceFile();
  
  Token Tok/*J*/= new Token();
  do  {
    PP.Lex(Tok);
  } while (Tok.isNot(tok.TokenKind.eof));
  
  SmallVector<std.pair<IdentifierInfo /*P*/, MacroInfo /*P*/>> MacrosByID/*J*/= new SmallVector<std.pair<IdentifierInfo /*P*/, MacroInfo /*P*/>>(128, new std.pairPtrPtr());
  for (DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> I = PP.macro_begin(), E = PP.macro_end();
       I.$noteq(E); I.$preInc()) {
    MacroDirective /*P*/ MD = I.$arrow().second.getLatest();
    if ((MD != null) && MD.isDefined()) {
      MacrosByID.push_back(new std.pairPtrPtr<IdentifierInfo /*P*/, MacroInfo /*P*/>(I.$arrow().first, MD.getMacroInfo()));
    }
  }
  llvm.array_pod_sort(MacrosByID.begin(), MacrosByID.end(), PrintPreprocessedOutputStatics::MacroIDCompare);
  
  for (/*uint*/int i = 0, e = MacrosByID.size(); i != e; ++i) {
    MacroInfo /*&*/ MI = /*Deref*/MacrosByID.$at(i).second;
    // Ignore computed macros like __LINE__ and friends.
    if (MI.isBuiltinMacro()) {
      continue;
    }
    
    PrintMacroDefinition(/*Deref*/MacrosByID.$at(i).first, MI, PP, /*Deref*/OS);
    /*Deref*/OS.$out_char($$LF);
  }
}

} // END OF class PrintPreprocessedOutputStatics
