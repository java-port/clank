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

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.basic.BasicClangGlobals.*;


/// PragmaDiagnosticHandler - e.g. '\#pragma GCC diagnostic ignored "-Wformat"'
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDiagnosticHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 967,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 965,
 FQN="(anonymous namespace)::PragmaDiagnosticHandler", NM="_ZN12_GLOBAL__N_123PragmaDiagnosticHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_123PragmaDiagnosticHandlerE")
//</editor-fold>
public class/*struct*/ PragmaDiagnosticHandler extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
/*private:*/
  private /*const*/String/*char P*/ Namespace;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDiagnosticHandler::PragmaDiagnosticHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 971,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 969,
   FQN="(anonymous namespace)::PragmaDiagnosticHandler::PragmaDiagnosticHandler", NM="_ZN12_GLOBAL__N_123PragmaDiagnosticHandlerC1EPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_123PragmaDiagnosticHandlerC1EPKc")
  //</editor-fold>
  public /*explicit*/ PragmaDiagnosticHandler(/*const*/String/*char P*/ NS) {
    /* : PragmaHandler("diagnostic"), Namespace(NS)*/ 
    //START JInit
    super(/*STRINGREF_STR*/"diagnostic");
    this.Namespace = $tryClone(NS);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDiagnosticHandler::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*diag.Severity.Uncomputed*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 973,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 971,
   FQN="(anonymous namespace)::PragmaDiagnosticHandler::HandlePragma", NM="_ZN12_GLOBAL__N_123PragmaDiagnosticHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_123PragmaDiagnosticHandler12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, PragmaIntroducerKind Introducer, 
              Token /*&*/ DiagToken)/* override*/ {
    SourceLocation DiagLoc = DiagToken.getLocation();
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
    PPCallbacks /*P*/ Callbacks = PP.getPPCallbacks();
    if (II.isStr(/*KEEP_STR*/"pop")) {
      if (!PP.getDiagnostics().popMappings(/*NO_COPY*/DiagLoc)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(PP.Diag(Tok, diag.warn_pragma_diagnostic_cannot_pop)));
        } finally {
          $c$.$destroy();
        }
      } else if ((Callbacks != null)) {
        Callbacks.PragmaDiagnosticPop(/*NO_COPY*/DiagLoc, new StringRef(Namespace));
      }
      return;
    } else if (II.isStr(/*KEEP_STR*/"push")) {
      PP.getDiagnostics().pushMappings(/*NO_COPY*/DiagLoc);
      if ((Callbacks != null)) {
        Callbacks.PragmaDiagnosticPush(/*NO_COPY*/DiagLoc, new StringRef(Namespace));
      }
      return;
    }
    
    diag.Severity SV = new StringSwitch<diag.Severity>(II.getName()).
        Case(/*KEEP_STR*/"ignored", diag.Severity.Ignored).
        Case(/*KEEP_STR*/"warning", diag.Severity.Warning).
        Case(/*KEEP_STR*/"error", diag.Severity.Error).
        Case(/*KEEP_STR*/"fatal", diag.Severity.Fatal).
        Default(diag.Severity.Uncomputed);
    if (SV == diag.Severity.Uncomputed) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok, diag.warn_pragma_diagnostic_invalid)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    PP.LexUnexpandedToken(Tok);
    SourceLocation StringLoc = Tok.getLocation();
    
    std.string WarningName/*J*/= new std.string();
    if (!PP.FinishLexStringLiteral(Tok, WarningName, /*KEEP_STR*/"pragma diagnostic", 
        /*MacroExpansion=*/ false)) {
      return;
    }
    if (Tok.isNot(tok.TokenKind.eod)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_diagnostic_invalid_token)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if ($less_uint(WarningName.size(), 3) || WarningName.$at(0) != $$MINUS
       || (WarningName.$at(1) != $$W && WarningName.$at(1) != $$R)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(PP.Diag(/*NO_COPY*/StringLoc, diag.warn_pragma_diagnostic_invalid_option)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    diag.Flavor Flavor = WarningName.$at(1) == $$W ? diag.Flavor.WarningOrError : diag.Flavor.Remark;
    StringRef Group = new StringRef(WarningName).substr(2);
    boolean unknownDiag = false;
    if ($eq_StringRef(/*NO_COPY*/Group, /*STRINGREF_STR*/"everything")) {
      // Special handling for pragma clang diagnostic ... "-Weverything".
      // There is no formal group named "everything", so there has to be a
      // special case for it.
      PP.getDiagnostics().setSeverityForAll(Flavor, SV, /*NO_COPY*/DiagLoc);
    } else {
      unknownDiag = PP.getDiagnostics().setSeverityForGroup(Flavor, /*NO_COPY*/Group, SV, 
          /*NO_COPY*/DiagLoc);
    }
    if (unknownDiag) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(/*NO_COPY*/StringLoc, diag.warn_pragma_diagnostic_unknown_warning)), 
            new StringRef(WarningName)));
      } finally {
        $c$.$destroy();
      }
    } else if ((Callbacks != null)) {
      Callbacks.PragmaDiagnostic(/*NO_COPY*/DiagLoc, new StringRef(Namespace), SV, new StringRef(WarningName));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaDiagnosticHandler::~PragmaDiagnosticHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 967,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 965,
   FQN="(anonymous namespace)::PragmaDiagnosticHandler::~PragmaDiagnosticHandler", NM="_ZN12_GLOBAL__N_123PragmaDiagnosticHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN12_GLOBAL__N_123PragmaDiagnosticHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "Namespace=" + Namespace // NOI18N
              + super.toString(); // NOI18N
  }
}
