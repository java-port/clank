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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.basic.BasicClangGlobals.*;


/// PragmaARCCFCodeAuditedHandler - 
///   \#pragma clang arc_cf_code_audited begin/end
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaARCCFCodeAuditedHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1325,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1314,
 FQN="(anonymous namespace)::PragmaARCCFCodeAuditedHandler", NM="_ZN12_GLOBAL__N_129PragmaARCCFCodeAuditedHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_129PragmaARCCFCodeAuditedHandlerE")
//</editor-fold>
public class/*struct*/ PragmaARCCFCodeAuditedHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaARCCFCodeAuditedHandler::PragmaARCCFCodeAuditedHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1326,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1315,
   FQN="(anonymous namespace)::PragmaARCCFCodeAuditedHandler::PragmaARCCFCodeAuditedHandler", NM="_ZN12_GLOBAL__N_129PragmaARCCFCodeAuditedHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_129PragmaARCCFCodeAuditedHandlerC1Ev")
  //</editor-fold>
  public PragmaARCCFCodeAuditedHandler() {
    /* : PragmaHandler("arc_cf_code_audited")*/ 
    //START JInit
    super(/*STRINGREF_STR*/"arc_cf_code_audited");
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaARCCFCodeAuditedHandler::HandlePragma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1327,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1316,
   FQN="(anonymous namespace)::PragmaARCCFCodeAuditedHandler::HandlePragma", NM="_ZN12_GLOBAL__N_129PragmaARCCFCodeAuditedHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_129PragmaARCCFCodeAuditedHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, PragmaIntroducerKind Introducer, 
              Token /*&*/ NameTok)/* override*/ {
    SourceLocation Loc = NameTok.getLocation();
    boolean IsBegin;
    
    Token Tok/*J*/= new Token();
    
    // Lex the 'begin' or 'end'.
    PP.LexUnexpandedToken(Tok);
    /*const*/ IdentifierInfo /*P*/ BeginEnd = Tok.getIdentifierInfo();
    if ((BeginEnd != null) && BeginEnd.isStr(/*KEEP_STR*/"begin")) {
      IsBegin = true;
    } else if ((BeginEnd != null) && BeginEnd.isStr(/*KEEP_STR*/"end")) {
      IsBegin = false;
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.err_pp_arc_cf_code_audited_syntax)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Verify that this is followed by EOD.
    PP.LexUnexpandedToken(Tok);
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok, diag.ext_pp_extra_tokens_at_eol)), /*KEEP_STR*/$pragma));
      } finally {
        $c$.$destroy();
      }
    }
    
    // The start location of the active audit.
    SourceLocation BeginLoc = PP.getPragmaARCCFCodeAuditedLoc();
    
    // The start location we want after processing this.
    SourceLocation NewLoc/*J*/= new SourceLocation();
    if (IsBegin) {
      // Complain about attempts to re-enter an audit.
      if (BeginLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(new SourceLocation(Loc), diag.err_pp_double_begin_of_arc_cf_code_audited)));
          $c$.clean($c$.track(PP.Diag(new SourceLocation(BeginLoc), diag.note_pragma_entered_here)));
        } finally {
          $c$.$destroy();
        }
      }
      NewLoc.$assign(Loc);
    } else {
      // Complain about attempts to leave an audit that doesn't exist.
      if (!BeginLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(new SourceLocation(Loc), diag.err_pp_unmatched_end_of_arc_cf_code_audited)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      NewLoc.$assignMove(new SourceLocation());
    }
    
    PP.setPragmaARCCFCodeAuditedLoc(new SourceLocation(NewLoc));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaARCCFCodeAuditedHandler::~PragmaARCCFCodeAuditedHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 1325,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 1314,
   FQN="(anonymous namespace)::PragmaARCCFCodeAuditedHandler::~PragmaARCCFCodeAuditedHandler", NM="_ZN12_GLOBAL__N_129PragmaARCCFCodeAuditedHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_129PragmaARCCFCodeAuditedHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
