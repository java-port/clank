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
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.basic.BasicClangGlobals.*;


/// "\#pragma warning(...)".  MSVC's diagnostics do not map cleanly to clang's
/// diagnostics, so we don't really implement this pragma.  We parse it and
/// ignore it to avoid -Wunknown-pragma warnings.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaWarningHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1052,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1041,
 FQN="(anonymous namespace)::PragmaWarningHandler", NM="_ZN12_GLOBAL__N_120PragmaWarningHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaWarningHandlerE")
//</editor-fold>
public class/*struct*/ PragmaWarningHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaWarningHandler::PragmaWarningHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1053,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1042,
   FQN="(anonymous namespace)::PragmaWarningHandler::PragmaWarningHandler", NM="_ZN12_GLOBAL__N_120PragmaWarningHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaWarningHandlerC1Ev")
  //</editor-fold>
  public PragmaWarningHandler() {
    /* : PragmaHandler("warning")*/ 
    //START JInit
    super(/*STRINGREF_STR*/"warning");
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaWarningHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1055,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1044,
   FQN="(anonymous namespace)::PragmaWarningHandler::HandlePragma", NM="_ZN12_GLOBAL__N_120PragmaWarningHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaWarningHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    // Parse things like:
    // warning(push, 1)
    // warning(pop)
    // warning(disable : 1 2 3 ; error : 4 5 6 ; suppress : 7 8 9)
    SourceLocation DiagLoc = Tok.getLocation();
    PPCallbacks /*P*/ Callbacks = PP.getPPCallbacks();
    
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok, diag.warn_pragma_warning_expected)), /*KEEP_STR*/$LPAREN));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    PP.Lex(Tok);
    IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    if ((II != null) && II.isStr(/*KEEP_STR*/"push")) {
      // #pragma warning( push[ ,n ] )
      int Level = -1;
      PP.Lex(Tok);
      if (Tok.is(tok.TokenKind.comma)) {
        PP.Lex(Tok);
        ulong$ref/*uint64_t*/ Value = create_ulong$ref(0);
        if (Tok.is(tok.TokenKind.numeric_constant)
           && PP.parseSimpleIntegerLiteral(Tok, Value)) {
          Level = ((int)($ulong2int(Value)));
        }
        if (Level < 0 || Level > 4) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(PP.Diag(Tok, diag.warn_pragma_warning_push_level)));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if ((Callbacks != null)) {
        Callbacks.PragmaWarningPush(new SourceLocation(DiagLoc), Level);
      }
    } else if ((II != null) && II.isStr(/*KEEP_STR*/"pop")) {
      // #pragma warning( pop )
      PP.Lex(Tok);
      if ((Callbacks != null)) {
        Callbacks.PragmaWarningPop(new SourceLocation(DiagLoc));
      }
    } else {
      // #pragma warning( warning-specifier : warning-number-list
      //                  [; warning-specifier : warning-number-list...] )
      while (true) {
        II = Tok.getIdentifierInfo();
        if (!(II != null) && !Tok.is(tok.TokenKind.numeric_constant)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(PP.Diag(Tok, diag.warn_pragma_warning_spec_invalid)));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Figure out which warning specifier this is.
        boolean SpecifierValid;
        StringRef Specifier/*J*/= new StringRef();
        SmallString/*1*/ SpecifierBuf/*J*/= new SmallString/*1*/(1);
        if ((II != null)) {
          Specifier.$assignMove(II.getName());
          SpecifierValid = new StringSwitchBool(/*NO_COPY*/Specifier).
              Cases(/*KEEP_STR*/"default", /*KEEP_STR*/"disable", /*KEEP_STR*/"error", /*KEEP_STR*/"once", 
              /*KEEP_STR*/"suppress", true).
              Default(false);
          // If we read a correct specifier, snatch next token (that should be
          // ":", checked later).
          if (SpecifierValid) {
            PP.Lex(Tok);
          }
        } else {
          // Token is a numeric constant. It should be either 1, 2, 3 or 4.
          ulong$ref/*uint64_t*/ Value = create_ulong$ref(0);
          Specifier.$assignMove(PP.getSpelling(Tok, SpecifierBuf));
          if (PP.parseSimpleIntegerLiteral(Tok, Value)) {
            SpecifierValid = ($greatereq_ulong_ullong(Value, 1)) && ($lesseq_ulong_ullong(Value, 4));
          } else {
            SpecifierValid = false;
          }
          // Next token already snatched by parseSimpleIntegerLiteral.
        }
        if (!SpecifierValid) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(PP.Diag(Tok, diag.warn_pragma_warning_spec_invalid)));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        if (Tok.isNot(tok.TokenKind.colon)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok, diag.warn_pragma_warning_expected)), /*KEEP_STR*/$COLON));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Collect the warning ids.
        SmallVectorInt/*%i*/ Ids/*J*/= new SmallVectorInt/*%i*/(4);
        PP.Lex(Tok);
        while (Tok.is(tok.TokenKind.numeric_constant)) {
          ulong$ref/*uint64_t*/ Value = create_ulong$ref(0);
          if (!PP.parseSimpleIntegerLiteral(Tok, Value) || Value.$deref() == 0
             || $greater_ulong_ullong(Value, INT_MAX)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(PP.Diag(Tok, diag.warn_pragma_warning_expected_number)));
              return;
            } finally {
              $c$.$destroy();
            }
          }
          Ids.push_back(((int)($ulong2int(Value))));
        }
        if ((Callbacks != null)) {
          Callbacks.PragmaWarning(new SourceLocation(DiagLoc), new StringRef(Specifier), new ArrayRefInt(Ids));
        }
        
        // Parse the next specifier if there is a semicolon.
        if (Tok.isNot(tok.TokenKind.semi)) {
          break;
        }
        PP.Lex(Tok);
      }
    }
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok, diag.warn_pragma_warning_expected)), /*KEEP_STR*/$RPAREN));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok, diag.ext_pp_extra_tokens_at_eol)), /*KEEP_STR*/"pragma warning"));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaWarningHandler::~PragmaWarningHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1052,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1041,
   FQN="(anonymous namespace)::PragmaWarningHandler::~PragmaWarningHandler", NM="_ZN12_GLOBAL__N_120PragmaWarningHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_120PragmaWarningHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
