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

import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSPointersToMembers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 120,
 FQN="(anonymous namespace)::PragmaMSPointersToMembers", NM="_ZN12_GLOBAL__N_125PragmaMSPointersToMembersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_125PragmaMSPointersToMembersE")
//</editor-fold>
public class/*struct*/ PragmaMSPointersToMembers extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSPointersToMembers::PragmaMSPointersToMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 121,
   FQN="(anonymous namespace)::PragmaMSPointersToMembers::PragmaMSPointersToMembers", NM="_ZN12_GLOBAL__N_125PragmaMSPointersToMembersC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_125PragmaMSPointersToMembersC1Ev")
  //</editor-fold>
  public /*explicit*/ PragmaMSPointersToMembers() {
    // : PragmaHandler("pointers_to_members") 
    //START JInit
    super(/*STRINGREF_STR*/"pointers_to_members");
    //END JInit
  }

  
  /// \brief Handle '#pragma pointers_to_members'
  // The grammar for this pragma is as follows:
  //
  // <inheritance model> ::= ('single' | 'multiple' | 'virtual') '_inheritance'
  //
  // #pragma pointers_to_members '(' 'best_case' ')'
  // #pragma pointers_to_members '(' 'full_generality' [',' inheritance-model] ')'
  // #pragma pointers_to_members '(' inheritance-model ')'
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSPointersToMembers::HandlePragma">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init with INVALID*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 1513,
   FQN="(anonymous namespace)::PragmaMSPointersToMembers::HandlePragma", NM="_ZN12_GLOBAL__N_125PragmaMSPointersToMembers12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_125PragmaMSPointersToMembers12HandlePragmaERN5clang12PreprocessorENS1_20PragmaIntroducerKindERNS1_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, 
              PragmaIntroducerKind Introducer, 
              Token /*&*/ Tok)/* override*/ {
    SourceLocation PointersToMembersLoc = Tok.getLocation();
    PP.Lex(Tok);
    if (Tok.isNot(tok.TokenKind.l_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(/*NO_COPY*/PointersToMembersLoc, diag.warn_pragma_expected_lparen)), 
            /*KEEP_STR*/"pointers_to_members"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    PP.Lex(Tok);
    /*const*/ IdentifierInfo /*P*/ Arg = Tok.getIdentifierInfo();
    if (!(Arg != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.warn_pragma_expected_identifier)), 
            /*KEEP_STR*/"pointers_to_members"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    PP.Lex(Tok);
    
    // JAVA: initialize
    LangOptions.PragmaMSPointersToMembersKind RepresentationMethod = LangOptions.PragmaMSPointersToMembersKind.PPTMK_INVALID;
    if (Arg.isStr(/*KEEP_STR*/"best_case")) {
      RepresentationMethod = LangOptions.PragmaMSPointersToMembersKind.PPTMK_BestCase;
    } else {
      if (Arg.isStr(/*KEEP_STR*/"full_generality")) {
        if (Tok.is(tok.TokenKind.comma)) {
          PP.Lex(Tok);
          
          Arg = Tok.getIdentifierInfo();
          if (!(Arg != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_TokenKind($c$.track(PP.Diag(Tok.getLocation(), 
                          diag.err_pragma_pointers_to_members_unknown_kind)), 
                      Tok.getKind()), /*OnlyInheritanceModels*/ 0));
              return;
            } finally {
              $c$.$destroy();
            }
          }
          PP.Lex(Tok);
        } else if (Tok.is(tok.TokenKind.r_paren)) {
          // #pragma pointers_to_members(full_generality) implicitly specifies
          // virtual_inheritance.
          Arg = null;
          RepresentationMethod = LangOptions.PragmaMSPointersToMembersKind.PPTMK_FullGeneralityVirtualInheritance;
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(PP.Diag(Tok.getLocation(), diag.err_expected_punc)), 
                /*KEEP_STR*/"full_generality"));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if ((Arg != null)) {
        if (Arg.isStr(/*KEEP_STR*/"single_inheritance")) {
          RepresentationMethod
             = LangOptions.PragmaMSPointersToMembersKind.PPTMK_FullGeneralitySingleInheritance;
        } else if (Arg.isStr(/*KEEP_STR*/"multiple_inheritance")) {
          RepresentationMethod
             = LangOptions.PragmaMSPointersToMembersKind.PPTMK_FullGeneralityMultipleInheritance;
        } else if (Arg.isStr(/*KEEP_STR*/"virtual_inheritance")) {
          RepresentationMethod
             = LangOptions.PragmaMSPointersToMembersKind.PPTMK_FullGeneralityVirtualInheritance;
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track(PP.Diag(Tok.getLocation(), 
                        diag.err_pragma_pointers_to_members_unknown_kind)), 
                    Arg), /*HasPointerDeclaration*/ 1));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (Tok.isNot(tok.TokenKind.r_paren)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(PP.Diag(Tok.getLocation(), diag.err_expected_rparen_after)), 
            ((Arg != null) ? Arg.getName() : new StringRef(/*KEEP_STR*/"full_generality"))));
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
            /*KEEP_STR*/"pointers_to_members"));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    Token AnnotTok/*J*/= new Token();
    AnnotTok.startToken();
    AnnotTok.setKind(tok.TokenKind.annot_pragma_ms_pointers_to_members);
    AnnotTok.setLocation(/*NO_COPY*/PointersToMembersLoc);
    AnnotTok.setAnnotationEndLoc(/*NO_COPY*/EndLoc);
    AnnotTok.setAnnotationValue(reinterpret_cast(Object/*void P*/ .class, ((/*static_cast*/Object/*uintptr_t*/)(RepresentationMethod.getValue()))));
    PP.EnterToken(AnnotTok);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PragmaMSPointersToMembers::~PragmaMSPointersToMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp", line = 120,
   FQN="(anonymous namespace)::PragmaMSPointersToMembers::~PragmaMSPointersToMembers", NM="_ZN12_GLOBAL__N_125PragmaMSPointersToMembersD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp -nm=_ZN12_GLOBAL__N_125PragmaMSPointersToMembersD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
