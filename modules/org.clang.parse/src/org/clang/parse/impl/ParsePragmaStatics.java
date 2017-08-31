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
package org.clang.parse.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type ParsePragmaStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZL16ParseAlignPragmaRN5clang12PreprocessorERNS_5TokenEb;_ZL18ParseLoopHintValueRN5clang12PreprocessorERNS_5TokenES2_S2_bRN12_GLOBAL__N_118PragmaLoopHintInfoE;_ZL20PragmaLoopHintStringN5clang5TokenES0_; -static-type=ParsePragmaStatics -package=org.clang.parse.impl")
//</editor-fold>
public final class ParsePragmaStatics {

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="PragmaLoopHintString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 780,
 FQN="PragmaLoopHintString", NM="_ZL20PragmaLoopHintStringN5clang5TokenES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZL20PragmaLoopHintStringN5clang5TokenES0_")
//</editor-fold>
public static std.string PragmaLoopHintString(Token PragmaName, Token Option) {
  std.string PragmaString/*J*/= new std.string();
  if ($eq_StringRef(PragmaName.getIdentifierInfo().getName(), /*STRINGREF_STR*/"loop")) {
    PragmaString.$assign_T$C$P(/*KEEP_STR*/"clang loop ");
    $addassign_string_StringRef(PragmaString, Option.getIdentifierInfo().getName());
  } else {
    assert ($eq_StringRef(PragmaName.getIdentifierInfo().getName(), /*STRINGREF_STR*/"unroll")) : "Unexpected pragma name";
    PragmaString.$assign_T$C$P(/*KEEP_STR*/"unroll");
  }
  return PragmaString;
}


// #pragma 'align' '=' {'native','natural','mac68k','power','reset'}
// #pragma 'options 'align' '=' {'native','natural','mac68k','power','reset'}
//<editor-fold defaultstate="collapsed" desc="ParseAlignPragma">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed use of allocator*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1121,
 FQN="ParseAlignPragma", NM="_ZL16ParseAlignPragmaRN5clang12PreprocessorERNS_5TokenEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZL16ParseAlignPragmaRN5clang12PreprocessorERNS_5TokenEb")
//</editor-fold>
public static void ParseAlignPragma(Preprocessor /*&*/ PP, Token /*&*/ FirstTok, 
                boolean IsOptions) {
  Token Tok/*J*/= new Token();
  if (IsOptions) {
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.identifier)
       || !Tok.getIdentifierInfo().isStr(/*KEEP_STR*/"align")) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_options_expected_align)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  PP.Lex(Tok);
  if (Tok.isNot(tok.TokenKind.equal)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out$Same2Bool($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_align_expected_equal)), 
          IsOptions));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  PP.Lex(Tok);
  if (Tok.isNot(tok.TokenKind.identifier)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_identifier)), 
          (IsOptions ? $("options") : $("align"))));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  Sema.PragmaOptionsAlignKind Kind = Sema.PragmaOptionsAlignKind.POAK_Natural;
  /*const*/ IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
  if (II.isStr(/*KEEP_STR*/"native")) {
    Kind = Sema.PragmaOptionsAlignKind.POAK_Native;
  } else if (II.isStr(/*KEEP_STR*/"natural")) {
    Kind = Sema.PragmaOptionsAlignKind.POAK_Natural;
  } else if (II.isStr(/*KEEP_STR*/"packed")) {
    Kind = Sema.PragmaOptionsAlignKind.POAK_Packed;
  } else if (II.isStr(/*KEEP_STR*/"power")) {
    Kind = Sema.PragmaOptionsAlignKind.POAK_Power;
  } else if (II.isStr(/*KEEP_STR*/"mac68k")) {
    Kind = Sema.PragmaOptionsAlignKind.POAK_Mac68k;
  } else if (II.isStr(/*KEEP_STR*/"reset")) {
    Kind = Sema.PragmaOptionsAlignKind.POAK_Reset;
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out$Same2Bool($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_align_invalid_option)), 
          IsOptions));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  SourceLocation EndLoc = Tok.getLocation();
  PP.Lex(Tok);
  if (Tok.isNot(tok.TokenKind.eod)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_extra_tokens_at_eol)), 
          (IsOptions ? $("options") : $("align"))));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // JAVA:
  if (false) PP.getPreprocessorAllocator().<Token>Allocate(1);
//  MutableArrayRefToken Toks/*J*/= new MutableArrayRefToken(PP.getPreprocessorAllocator().<Token>Allocate$T(1), 
//      1);
  MutableArrayRefToken Toks/*J*/= new MutableArrayRefToken(new Token());
  Toks.$at(0).startToken();
  Toks.$at(0).setKind(tok.TokenKind.annot_pragma_align);
  Toks.$at(0).setLocation(FirstTok.getLocation());
  Toks.$at(0).setAnnotationEndLoc(/*NO_COPY*/EndLoc);
  Toks.$at(0).setAnnotationValue(reinterpret_cast(Object/*void P*/ .class, ((/*static_cast*/Object/*uintptr_t*/)(Kind.getValue()))));
  PP.EnterTokenStream(new ArrayRefToken(Toks), /*DisableMacroExpansion=*/ true);
}


/// \brief Parses loop or unroll pragma hint value and fills in Info.
//<editor-fold defaultstate="collapsed" desc="ParseLoopHintValue">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*don't use allocator*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1905,
 FQN="ParseLoopHintValue", NM="_ZL18ParseLoopHintValueRN5clang12PreprocessorERNS_5TokenES2_S2_bRN12_GLOBAL__N_118PragmaLoopHintInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZL18ParseLoopHintValueRN5clang12PreprocessorERNS_5TokenES2_S2_bRN12_GLOBAL__N_118PragmaLoopHintInfoE")
//</editor-fold>
public static boolean ParseLoopHintValue(Preprocessor /*&*/ PP, Token /*&*/ Tok, Token PragmaName, 
                  Token Option, boolean ValueInParens, 
                  PragmaLoopHintInfo /*&*/ Info) {
  SmallVectorToken ValueList/*J*/= new SmallVectorToken(1, /*PERF: new Token()*/null);
  int OpenParens = ValueInParens ? 1 : 0;
  // Read constant expression.
  while (Tok.isNot(tok.TokenKind.eod)) {
    if (Tok.is(tok.TokenKind.l_paren)) {
      OpenParens++;
    } else if (Tok.is(tok.TokenKind.r_paren)) {
      OpenParens--;
      if (OpenParens == 0 && ValueInParens) {
        break;
      }
    }
    
    ValueList.push_back(Tok);
    PP.Lex(Tok);
  }
  if (ValueInParens) {
    // Read ')'
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(Tok.getLocation(), diag.err_expected)), tok.TokenKind.r_paren));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    PP.Lex(Tok);
  }
  
  Token EOFTok/*J*/= new Token();
  EOFTok.startToken();
  EOFTok.setKind(tok.TokenKind.eof);
  EOFTok.setLocation(Tok.getLocation());
  ValueList.push_back(EOFTok); // Terminates expression for parsing.
  
  if (/*JAVA*/false) llvm.makeArrayRef(ValueList).copy(SmallVectorToken.class, PP.getPreprocessorAllocator());
  
  Info.Toks.$assignMove(new ArrayRefToken(ValueList));
  
  Info.PragmaName.$assign(PragmaName);
  Info.Option.$assign(Option);
  return false;
}

} // END OF class ParsePragmaStatics
