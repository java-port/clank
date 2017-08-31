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

import org.clank.support.*;
import static org.clank.java.built_in.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDebugHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 859,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 857,
 FQN="(anonymous namespace)::PragmaDebugHandler", NM="_ZN12_GLOBAL__N_118PragmaDebugHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_118PragmaDebugHandlerE")
//</editor-fold>
public class/*struct*/ PragmaDebugHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDebugHandler::PragmaDebugHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 860,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 858,
   FQN="(anonymous namespace)::PragmaDebugHandler::PragmaDebugHandler", NM="_ZN12_GLOBAL__N_118PragmaDebugHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_118PragmaDebugHandlerC1Ev")
  //</editor-fold>
  public PragmaDebugHandler() {
    /* : PragmaHandler("__debug")*/ 
    //START JInit
    super(/*STRINGREF_STR*/"__debug");
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDebugHandler::HandlePragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 861,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 859,
   FQN="(anonymous namespace)::PragmaDebugHandler::HandlePragma", NM="_ZN12_GLOBAL__N_118PragmaDebugHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_118PragmaDebugHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, PragmaIntroducerKind Introducer, 
              Token /*&*/ DepToken)/* override*/ {
    Token Tok/*J*/= new Token();
    PP.LexUnexpandedToken(Tok);
    if (Tok.isNot(tok.TokenKind.identifier)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok, diag.warn_pragma_diagnostic_invalid)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    if (II.isStr(/*KEEP_STR*/"assert")) {
      throw new llvm_unreachable("This is an assertion!");
    } else if (II.isStr(/*KEEP_STR*/"crash")) {
      __builtin_trap();
    } else if (II.isStr(/*KEEP_STR*/"parser_crash")) {
      Token Crasher/*J*/= new Token();
      Crasher.startToken();
      Crasher.setKind(tok.TokenKind.annot_pragma_parser_crash);
      Crasher.setAnnotationRange(new SourceRange(Tok.getLocation()));
      PP.EnterToken(Crasher);
    } else if (II.isStr(/*KEEP_STR*/"dump")) {
      Token Identifier/*J*/= new Token();
      PP.LexUnexpandedToken(Identifier);
      {
        IdentifierInfo /*P*/ DumpII = Identifier.getIdentifierInfo();
        if ((DumpII != null)) {
          Token DumpAnnot/*J*/= new Token();
          DumpAnnot.startToken();
          DumpAnnot.setKind(tok.TokenKind.annot_pragma_dump);
          DumpAnnot.setAnnotationRange(new SourceRange(Tok.getLocation(), Identifier.getLocation()));
          DumpAnnot.setAnnotationValue(DumpII);
          PP.DiscardUntilEndOfDirective();
          PP.EnterToken(DumpAnnot);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(Identifier, diag.warn_pragma_debug_missing_argument)), 
                II.getName()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    } else if (II.isStr(/*KEEP_STR*/"llvm_fatal_error")) {
      llvm.report_fatal_error($("#pragma clang __debug llvm_fatal_error"));
    } else if (II.isStr(/*KEEP_STR*/"llvm_unreachable")) {
      throw new llvm_unreachable("#pragma clang __debug llvm_unreachable");
    } else if (II.isStr(/*KEEP_STR*/"macro")) {
      Token MacroName/*J*/= new Token();
      PP.LexUnexpandedToken(MacroName);
      IdentifierInfo /*P*/ MacroII = MacroName.getIdentifierInfo();
      if ((MacroII != null)) {
        PP.dumpMacroInfo(MacroII);
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(MacroName, diag.warn_pragma_debug_missing_argument)), 
              II.getName()));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (II.isStr(/*KEEP_STR*/"overflow_stack")) {
      DebugOverflowStack();
    } else if (II.isStr(/*KEEP_STR*/"handle_crash")) {
      CrashRecoveryContext /*P*/ CRC = CrashRecoveryContext.GetCurrent();
      if ((CRC != null)) {
        CRC.HandleCrash();
      }
    } else if (II.isStr(/*KEEP_STR*/"captured")) {
      HandleCaptured(PP);
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(Tok, diag.warn_pragma_debug_unexpected_command)), 
            II.getName()));
      } finally {
        $c$.$destroy();
      }
    }
    
    PPCallbacks /*P*/ Callbacks = PP.getPPCallbacks();
    if ((Callbacks != null)) {
      Callbacks.PragmaDebug(Tok.getLocation(), II.getName());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDebugHandler::HandleCaptured">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 928,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 926,
   FQN="(anonymous namespace)::PragmaDebugHandler::HandleCaptured", NM="_ZN12_GLOBAL__N_118PragmaDebugHandler14HandleCapturedERN5clang12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_118PragmaDebugHandler14HandleCapturedERN5clang12PreprocessorE")
  //</editor-fold>
  public void HandleCaptured(Preprocessor /*&*/ PP) {
    // Skip if emitting preprocessed output.
    if (PP.isPreprocessedOutput()) {
      return;
    }
    
    Token Tok/*J*/= new Token();
    PP.LexUnexpandedToken(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok, diag.ext_pp_extra_tokens_at_eol)), 
            /*KEEP_STR*/"pragma clang __debug captured"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    

    if (false) PP.getPreprocessorAllocator().Allocate(Token.class, 1); // leave it here for FindUsages
    SourceLocation NameLoc = Tok.getLocation();
    MutableArrayRefToken Toks/*J*/= new MutableArrayRefToken(new Token());
    Toks.$at(0).startToken();
    Toks.$at(0).setKind(tok.TokenKind.annot_pragma_captured);
    Toks.$at(0).setLocation(/*NO_COPY*/NameLoc);
    PP.EnterTokenStream(new ArrayRefToken(Toks), /*DisableMacroExpansion=*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDebugHandler::DebugOverflowStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 956,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 954,
   FQN="(anonymous namespace)::PragmaDebugHandler::DebugOverflowStack", NM="_ZN12_GLOBAL__N_118PragmaDebugHandler18DebugOverflowStackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_118PragmaDebugHandler18DebugOverflowStackEv")
  //</editor-fold>
  public static void DebugOverflowStack() {
    Void2Void Self = () -> DebugOverflowStack();
    Self.$call();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDebugHandler::~PragmaDebugHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 859,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 857,
   FQN="(anonymous namespace)::PragmaDebugHandler::~PragmaDebugHandler", NM="_ZN12_GLOBAL__N_118PragmaDebugHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_118PragmaDebugHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
