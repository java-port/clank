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
package org.clang.parse;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import org.clang.parse.java.ParseMemberPointers.*;
import org.clang.parse.java.ParseFunctionPointers.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParseDeclStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseCXXInlineMethods ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser13ParseEnumBodyENS_14SourceLocationEPNS_4DeclE;_ZN5clang6Parser13ParseTypeNameEPNS_11SourceRangeENS_10Declarator10TheContextENS_15AccessSpecifierEPPNS_4DeclEPNS_16ParsedAttributesE;_ZN5clang6Parser14ParseDeclGroupERNS_15ParsingDeclSpecEjPNS_14SourceLocationEPNS0_12ForRangeInitE;_ZN5clang6Parser15ParseDeclaratorERNS_10DeclaratorE;_ZN5clang6Parser16ParseDeclarationEjRNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE;_ZN5clang6Parser16ParseImplicitIntERNS_8DeclSpecEPNS_12CXXScopeSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeE;_ZN5clang6Parser17MightBeDeclaratorEj;_ZN5clang6Parser17ParseRefQualifierERbRNS_14SourceLocationE;_ZN5clang6Parser17ParseVersionTupleERNS_11SourceRangeE;_ZN5clang6Parser17SkipMalformedDeclEv;_ZN5clang6Parser18ParseAlignArgumentENS_14SourceLocationERS1_;_ZN5clang6Parser18ParseEnumSpecifierENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextE;_ZN5clang6Parser18ParseGNUAttributesERNS_16ParsedAttributesEPNS_14SourceLocationEPNS0_18LateParsedAttrListEPNS_10DeclaratorE;_ZN5clang6Parser18ParseIdentifierLocEv;_ZN5clang6Parser19ParseLexedAttributeERNS0_19LateParsedAttributeEbb;_ZN5clang6Parser20ParseAtomicSpecifierERNS_8DeclSpecE;_ZN5clang6Parser20ParseLexedAttributesERNS0_12ParsingClassE;_ZN5clang6Parser20ParseParenDeclaratorERNS_10DeclaratorE;_ZN5clang6Parser20ParseStructUnionBodyENS_14SourceLocationEjPNS_4DeclE;_ZN5clang6Parser20ParseTypeofSpecifierERNS_8DeclSpecE;_ZN5clang6Parser21ParseDirectDeclaratorERNS_10DeclaratorE;_ZN5clang6Parser21ParseGNUAttributeArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_NS_13AttributeList6SyntaxEPNS_10DeclaratorE;_ZN5clang6Parser21ParseOpenCLQualifiersERNS_16ParsedAttributesE;_ZN5clang6Parser22ParseBracketDeclaratorERNS_10DeclaratorE;_ZN5clang6Parser22ParseSimpleDeclarationEjRNS_14SourceLocationERNS0_25ParsedAttributesWithRangeEbPNS0_12ForRangeInitE;_ZN5clang6Parser22ParseStructDeclarationERNS_15ParsingDeclSpecEN4llvm12function_refIFvRNS_22ParsingFieldDeclaratorEEEE;_ZN5clang6Parser22isDeclarationSpecifierEb;_ZN5clang6Parser23ParseAlignmentSpecifierERNS_16ParsedAttributesEPNS_14SourceLocationE;_ZN5clang6Parser23ParseDeclaratorInternalERNS_10DeclaratorEMS0_FvS2_E;_ZN5clang6Parser23ParseFunctionDeclaratorERNS_10DeclaratorERNS_16ParsedAttributesERNS_24BalancedDelimiterTrackerEbb;_ZN5clang6Parser23ParseLexedAttributeListERNS0_18LateParsedAttrListEPNS_4DeclEbb;_ZN5clang6Parser23ParseMicrosoftDeclSpecsERNS_16ParsedAttributesEPNS_14SourceLocationE;_ZN5clang6Parser23ProhibitCXX11AttributesERNS0_25ParsedAttributesWithRangeE;_ZN5clang6Parser23isConstructorDeclaratorEb;_ZN5clang6Parser24ParseAttributeArgsCommonEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_NS_13AttributeList6SyntaxE;_ZN5clang6Parser24TryAltiVecTokenOutOfLineERNS_8DeclSpecENS_14SourceLocationERPKcRjRb;_ZN5clang6Parser24isTypeSpecifierQualifierEv;_ZN5clang6Parser25ParseAttributeWithTypeArgERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE;_ZN5clang6Parser25ParseTypeQualifierListOptERNS_8DeclSpecEjbb;_ZN5clang6Parser26ParseAvailabilityAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE;_ZN5clang6Parser26ParseBorlandTypeAttributesERNS_16ParsedAttributesE;_ZN5clang6Parser26ParseDeclarationSpecifiersERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextEPNS0_18LateParsedAttrListE;_ZN5clang6Parser26ParseMicrosoftDeclSpecArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesE;_ZN5clang6Parser27ParseOpenCLKernelAttributesERNS_16ParsedAttributesE;_ZN5clang6Parser27ParseSpecifierQualifierListERNS_8DeclSpecENS_15AccessSpecifierENS0_15DeclSpecContextE;_ZN5clang6Parser28DiagnoseProhibitedAttributesERNS0_25ParsedAttributesWithRangeE;_ZN5clang6Parser28ParseMicrosoftTypeAttributesERNS_16ParsedAttributesE;_ZN5clang6Parser30ParseNullabilityTypeSpecifiersERNS_16ParsedAttributesE;_ZN5clang6Parser30TryAltiVecVectorTokenOutOfLineEv;_ZN5clang6Parser31DiagnoseMisplacedCXX11AttributeERNS0_25ParsedAttributesWithRangeENS_14SourceLocationE;_ZN5clang6Parser31ParseDeclarationAfterDeclaratorERNS_10DeclaratorERKNS0_18ParsedTemplateInfoE;_ZN5clang6Parser31ParseMisplacedBracketDeclaratorERNS_10DeclaratorE;_ZN5clang6Parser31ParseObjCBridgeRelatedAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE;_ZN5clang6Parser31ParseParameterDeclarationClauseERNS_10DeclaratorERNS_16ParsedAttributesERN4llvm15SmallVectorImplINS_15DeclaratorChunk9ParamInfoEEERNS_14SourceLocationE;_ZN5clang6Parser32DiagnoseProhibitedCXX11AttributeEv;_ZN5clang6Parser32ParseTypeTagForDatatypeAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE;_ZN5clang6Parser33ParseAsmAttributesAfterDeclaratorERNS_10DeclaratorE;_ZN5clang6Parser33handleDeclspecAlignBeforeClassKeyERNS0_25ParsedAttributesWithRangeERNS_8DeclSpecENS_4Sema10TagUseKindE;_ZN5clang6Parser34isFunctionDeclaratorIdentifierListEv;_ZN5clang6Parser35SkipExtendedMicrosoftTypeAttributesEv;_ZN5clang6Parser37DiagnoseMissingSemiAfterTagDefinitionERNS_8DeclSpecENS_15AccessSpecifierENS0_15DeclSpecContextEPNS0_18LateParsedAttrListE;_ZN5clang6Parser37ParseFunctionDeclaratorIdentifierListERNS_10DeclaratorERN4llvm15SmallVectorImplINS_15DeclaratorChunk9ParamInfoEEE;_ZN5clang6Parser39getDeclSpecContextFromDeclaratorContextEj;_ZN5clang6Parser44ParseDeclarationAfterDeclaratorAndAttributesERNS_10DeclaratorERKNS0_18ParsedTemplateInfoEPNS0_12ForRangeInitE;_ZN5clang6Parser46DiagnoseAndSkipExtendedMicrosoftTypeAttributesEv;_ZNK5clang6Parser24isKnownToBeTypeSpecifierERKNS_5TokenE; -static-type=Parser_ParseDecl -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseDecl extends Parser_ParseCXXInlineMethods {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// TryAltiVecVectorTokenOutOfLine - Out of line body that should only be called
/// from TryAltiVecVectorToken.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryAltiVecVectorTokenOutOfLine">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 6359,
   FQN="clang::Parser::TryAltiVecVectorTokenOutOfLine", NM="_ZN5clang6Parser30TryAltiVecVectorTokenOutOfLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser30TryAltiVecVectorTokenOutOfLineEv")
  //</editor-fold>
  protected /*private*/ boolean TryAltiVecVectorTokenOutOfLine() {
    Token Next = new Token($this().NextToken());
    switch (Next.getKind()) {
     default:
      return false;
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw_bool:
     case tok.TokenKind.kw___bool:
     case tok.TokenKind.kw___pixel:
      $this().Tok.setKind(tok.TokenKind.kw___vector);
      return true;
     case tok.TokenKind.identifier:
      if (Next.getIdentifierInfo() == $this().Ident_pixel) {
        $this().Tok.setKind(tok.TokenKind.kw___vector);
        return true;
      }
      if (Next.getIdentifierInfo() == $this().Ident_bool) {
        $this().Tok.setKind(tok.TokenKind.kw___vector);
        return true;
      }
      return false;
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryAltiVecTokenOutOfLine">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 6390,
   FQN="clang::Parser::TryAltiVecTokenOutOfLine", NM="_ZN5clang6Parser24TryAltiVecTokenOutOfLineERNS_8DeclSpecENS_14SourceLocationERPKcRjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser24TryAltiVecTokenOutOfLineERNS_8DeclSpecENS_14SourceLocationERPKcRjRb")
  //</editor-fold>
  protected /*private*/ boolean TryAltiVecTokenOutOfLine(final DeclSpec /*&*/ DS, SourceLocation Loc, 
                          final char$ptr/*const char P &*/ PrevSpec, final uint$ref/*uint &*/ DiagID, 
                          final bool$ref/*bool &*/ isInvalid) {
    final /*const*/ PrintingPolicy /*&*/ Policy = $this().Actions.getASTContext().getPrintingPolicy();
    if ($this().Tok.getIdentifierInfo() == $this().Ident_vector) {
      Token Next = new Token($this().NextToken());
      switch (Next.getKind()) {
       case tok.TokenKind.kw_short:
       case tok.TokenKind.kw_long:
       case tok.TokenKind.kw_signed:
       case tok.TokenKind.kw_unsigned:
       case tok.TokenKind.kw_void:
       case tok.TokenKind.kw_char:
       case tok.TokenKind.kw_int:
       case tok.TokenKind.kw_float:
       case tok.TokenKind.kw_double:
       case tok.TokenKind.kw_bool:
       case tok.TokenKind.kw___bool:
       case tok.TokenKind.kw___pixel:
        isInvalid.$set(DS.SetTypeAltiVecVector(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
        return true;
       case tok.TokenKind.identifier:
        if (Next.getIdentifierInfo() == $this().Ident_pixel) {
          isInvalid.$set(DS.SetTypeAltiVecVector(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          return true;
        }
        if (Next.getIdentifierInfo() == $this().Ident_bool) {
          isInvalid.$set(DS.SetTypeAltiVecVector(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          return true;
        }
        break;
       default:
        break;
      }
    } else if (($this().Tok.getIdentifierInfo() == $this().Ident_pixel)
       && DS.isTypeAltiVecVector()) {
      isInvalid.$set(DS.SetTypeAltiVecPixel(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
      return true;
    } else if (($this().Tok.getIdentifierInfo() == $this().Ident_bool)
       && DS.isTypeAltiVecVector()) {
      isInvalid.$set(DS.SetTypeAltiVecBool(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
      return true;
    }
    return false;
  }


/// SkipMalformedDecl - Read tokens until we get to some likely good stopping
/// point for skipping past a simple-declaration.

/// Skip until we reach something which seems like a sensible place to pick
/// up parsing after a malformed declaration. This will sometimes stop sooner
/// than SkipUntil(tok::r_brace) would, but will never stop later.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipMalformedDecl">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1648,
   FQN="clang::Parser::SkipMalformedDecl", NM="_ZN5clang6Parser17SkipMalformedDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser17SkipMalformedDeclEv")
  //</editor-fold>
  public void SkipMalformedDecl() {
    while (true) {
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.l_brace:
        // Skip until matching }, then stop. We've probably skipped over
        // a malformed class or function definition or similar.
        $this().ConsumeBrace();
        $this().SkipUntil(tok.TokenKind.r_brace);
        if ($this().Tok.isOneOf$T(tok.TokenKind.comma, tok.TokenKind.l_brace, tok.TokenKind.kw_try)) {
          // This declaration isn't over yet. Keep skipping.
          continue;
        }
        $this().TryConsumeToken(tok.TokenKind.semi);
        return;
       case tok.TokenKind.l_square:
        $this().ConsumeBracket();
        $this().SkipUntil(tok.TokenKind.r_square);
        continue;
       case tok.TokenKind.l_paren:
        $this().ConsumeParen();
        $this().SkipUntil(tok.TokenKind.r_paren);
        continue;
       case tok.TokenKind.r_brace:
        return;
       case tok.TokenKind.semi:
        $this().ConsumeToken();
        return;
       case tok.TokenKind.kw_inline:
        // 'inline namespace' at the start of a line is almost certainly
        // a good place to pick back up parsing, except in an Objective-C
        // @interface context.
        if ($this().Tok.isAtStartOfLine() && $this().NextToken().is(tok.TokenKind.kw_namespace)
           && (!$this().ParsingInObjCContainer || ($this().CurParsedObjCImpl != null))) {
          return;
        }
        break;
       case tok.TokenKind.kw_namespace:
        // 'namespace' at the start of a line is almost certainly a good
        // place to pick back up parsing, except in an Objective-C
        // @interface context.
        if ($this().Tok.isAtStartOfLine()
           && (!$this().ParsingInObjCContainer || ($this().CurParsedObjCImpl != null))) {
          return;
        }
        break;
       case tok.TokenKind.at:
        // @end is very much like } in Objective-C contexts.
        if ($this().NextToken().isObjCAtKeyword(tok.ObjCKeywordKind.objc_end)
           && $this().ParsingInObjCContainer) {
          return;
        }
        break;
       case tok.TokenKind.minus:
       case tok.TokenKind.plus:
        // - and + probably start new method declarations in Objective-C contexts.
        if ($this().Tok.isAtStartOfLine() && $this().ParsingInObjCContainer) {
          return;
        }
        break;
       case tok.TokenKind.eof:
       case tok.TokenKind.annot_module_begin:
       case tok.TokenKind.annot_module_end:
       case tok.TokenKind.annot_module_include:
        return;
       default:
        break;
      }
      
      $this().ConsumeAnyToken();
    }
  }


/// Wrapper class which calls ParseLexedAttribute, after setting up the
/// scope appropriately.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1158,
   FQN="clang::Parser::ParseLexedAttributes", NM="_ZN5clang6Parser20ParseLexedAttributesERNS0_12ParsingClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser20ParseLexedAttributesERNS0_12ParsingClassE")
  //</editor-fold>
  protected /*private*/ void ParseLexedAttributes(final ParsingClass /*&*/ Class) {
    ParseScope ClassTemplateScope = null;
    ParseScope ClassScope = null;
    ParseScopeFlags ClassScopeFlags = null;
    try {
      // Deal with templates
      // FIXME: Test cases to make sure this does the right thing for templates.
      boolean HasTemplateScope = !Class.TopLevelClass && Class.TemplateScope;
      ClassTemplateScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope, 
          HasTemplateScope);
      if (HasTemplateScope) {
        $this().Actions.ActOnReenterTemplateScope($this().getCurScope(), Class.TagOrTemplate);
      }
      
      // Set or update the scope flags.
      boolean AlreadyHasClassScope = Class.TopLevelClass;
      /*uint*/int ScopeFlags = Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.DeclScope;
      ClassScope/*J*/= new ParseScope($this(), ScopeFlags, !AlreadyHasClassScope);
      ClassScopeFlags/*J*/= new ParseScopeFlags($this(), ScopeFlags, AlreadyHasClassScope);
      
      // Enter the scope of nested classes
      if (!AlreadyHasClassScope) {
        $this().Actions.ActOnStartDelayedMemberDeclarations($this().getCurScope(), 
            Class.TagOrTemplate);
      }
      if (!Class.LateParsedDeclarations.empty()) {
        for (/*uint*/int i = 0, ni = Class.LateParsedDeclarations.size(); $less_uint(i, ni); ++i) {
          Class.LateParsedDeclarations.$at(i).ParseLexedAttributes();
        }
      }
      if (!AlreadyHasClassScope) {
        $this().Actions.ActOnFinishDelayedMemberDeclarations($this().getCurScope(), 
            Class.TagOrTemplate);
      }
    } finally {
      if (ClassScopeFlags != null) { ClassScopeFlags.$destroy(); }
      if (ClassScope != null) { ClassScope.$destroy(); }
      if (ClassTemplateScope != null) { ClassTemplateScope.$destroy(); }
    }
  }


/// \brief Parse all attributes in LAs, and attach them to Decl D.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedAttributeList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1189,
   FQN="clang::Parser::ParseLexedAttributeList", NM="_ZN5clang6Parser23ParseLexedAttributeListERNS0_18LateParsedAttrListEPNS_4DeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser23ParseLexedAttributeListERNS0_18LateParsedAttrListEPNS_4DeclEbb")
  //</editor-fold>
  protected /*private*/ void ParseLexedAttributeList(final LateParsedAttrList /*&*/ LAs, Decl /*P*/ D, 
                         boolean EnterScope, boolean OnDefinition) {
    assert (LAs.parseSoon()) : "Attribute list should be marked for immediate parsing.";
    for (/*uint*/int i = 0, ni = LAs.size(); $less_uint(i, ni); ++i) {
      if ((D != null)) {
        LAs.$at(i).addDecl(D);
      }
      $this().ParseLexedAttribute($Deref(LAs.$at(i)), EnterScope, OnDefinition);
      if (LAs.$at(i) != null) { LAs.$at(i).$destroy();};
    }
    LAs.clear();
  }


/// \brief Finish parsing an attribute for which parsing was delayed.
/// This will be called at the end of parsing a class declaration
/// for each LateParsedAttribute. We consume the saved tokens and
/// create an attribute with the arguments filled in. We add this
/// to the Attribute list for the decl.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLexedAttribute">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1207,
   FQN="clang::Parser::ParseLexedAttribute", NM="_ZN5clang6Parser19ParseLexedAttributeERNS0_19LateParsedAttributeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser19ParseLexedAttributeERNS0_19LateParsedAttributeEbb")
  //</editor-fold>
  protected /*private*/ void ParseLexedAttribute(final LateParsedAttribute /*&*/ LA, 
                     boolean EnterScope, boolean OnDefinition) {
    ParsedAttributes Attrs = null;
    try {
      // Create a fake EOF so that attribute parsing won't go off the end of the
      // attribute.
      Token AttrEnd/*J*/= new Token();
      AttrEnd.startToken();
      AttrEnd.setKind(tok.TokenKind.eof);
      AttrEnd.setLocation($this().Tok.getLocation());
      AttrEnd.setEofData(LA.Toks.data());
      LA.Toks.push_back(AttrEnd);
      
      // Append the current token at the end of the new token stream so that it
      // doesn't get lost.
      LA.Toks.push_back($this().Tok);
      $this().PP.EnterTokenStream(new ArrayRefToken(LA.Toks), true);
      // Consume the previously pushed token.
      $this().ConsumeAnyToken(/*ConsumeCodeCompletionTok=*/ true);
      
      Attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      SourceLocation endLoc/*J*/= new SourceLocation();
      if ($greater_uint(LA.Decls.size(), 0)) {
        Sema.CXXThisScopeRAII ThisScope = null;
        try {
          Decl /*P*/ D = LA.Decls.$at(0);
          NamedDecl /*P*/ ND = dyn_cast(NamedDecl.class, D);
          RecordDecl /*P*/ RD = dyn_cast_or_null(RecordDecl.class, D.getDeclContext());
          
          // Allow 'this' within late-parsed attributes.
          ThisScope/*J*/= new Sema.CXXThisScopeRAII($this().Actions, RD, /*TypeQuals=*/ 0, 
              (ND != null) && ND.isCXXInstanceMember());
          if (LA.Decls.size() == 1) {
            ParseScope TempScope = null;
            ParseScope FnScope = null;
            try {
              // If the Decl is templatized, add template parameters to scope.
              boolean HasTemplateScope = EnterScope && D.isTemplateDecl();
              TempScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.TemplateParamScope, HasTemplateScope);
              if (HasTemplateScope) {
                $this().Actions.ActOnReenterTemplateScope($this().Actions.CurScope, D);
              }
              
              // If the Decl is on a function, add function parameters to the scope.
              boolean HasFunScope = EnterScope && D.isFunctionOrFunctionTemplate();
              FnScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope, HasFunScope);
              if (HasFunScope) {
                $this().Actions.ActOnReenterFunctionContext($this().Actions.CurScope, D);
              }
              
              $this().ParseGNUAttributeArgs($AddrOf(LA.AttrName), new SourceLocation(LA.AttrNameLoc), Attrs, $AddrOf(endLoc), 
                  (IdentifierInfo /*P*/ )null, new SourceLocation(), AttributeList.Syntax.AS_GNU, 
                  (Declarator /*P*/ )null);
              if (HasFunScope) {
                $this().Actions.ActOnExitFunctionContext();
                FnScope.Exit(); // Pop scope, and remove Decls from IdResolver
              }
              if (HasTemplateScope) {
                TempScope.Exit();
              }
            } finally {
              if (FnScope != null) { FnScope.$destroy(); }
              if (TempScope != null) { TempScope.$destroy(); }
            }
          } else {
            // If there are multiple decls, then the decl cannot be within the
            // function scope.
            $this().ParseGNUAttributeArgs($AddrOf(LA.AttrName), new SourceLocation(LA.AttrNameLoc), Attrs, $AddrOf(endLoc), 
                (IdentifierInfo /*P*/ )null, new SourceLocation(), AttributeList.Syntax.AS_GNU, 
                (Declarator /*P*/ )null);
          }
        } finally {
          if (ThisScope != null) { ThisScope.$destroy(); }
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok, diag.warn_attribute_no_decl)), LA.AttrName.getName()));
        } finally {
          $c$.$destroy();
        }
      }
      
      /*const*/ AttributeList /*P*/ AL = Attrs.getList();
      if (OnDefinition && (AL != null) && !AL.isCXX11Attribute()
         && AL.isKnownToGCC()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().Tok, diag.warn_attribute_on_function_definition)), 
              $AddrOf(LA.AttrName)));
        } finally {
          $c$.$destroy();
        }
      }
      
      for (/*uint*/int i = 0, ni = LA.Decls.size(); $less_uint(i, ni); ++i)  {
        $this().Actions.ActOnFinishDelayedAttribute($this().getCurScope(), LA.Decls.$at(i), Attrs);
      }
      
      // Due to a parsing error, we either went over the cached tokens or
      // there are still cached tokens left, so we skip the leftover tokens.
      while ($this().Tok.isNot(tok.TokenKind.eof)) {
        $this().ConsumeAnyToken();
      }
      if ($this().Tok.is(tok.TokenKind.eof) && $eq_ptr($this().Tok.getEofData(), AttrEnd.getEofData())) {
        $this().ConsumeAnyToken();
      }
    } finally {
      if (Attrs != null) { Attrs.$destroy(); }
    }
  }


/// ParseDeclaration - Parse a full 'declaration', which consists of
/// declaration-specifiers, some number of declarators, and a semicolon.
/// 'Context' should be a Declarator::TheContext value.  This returns the
/// location of the semicolon in DeclEnd.
///
///       declaration: [C99 6.7]
///         block-declaration ->
///           simple-declaration
///           others                   [FIXME]
/// [C++]   template-declaration
/// [C++]   namespace-definition
/// [C++]   using-directive
/// [C++]   using-declaration
/// [C++11/C11] static_assert-declaration
///         others... [FIXME]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1478,
   FQN="clang::Parser::ParseDeclaration", NM="_ZN5clang6Parser16ParseDeclarationEjRNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser16ParseDeclarationEjRNS_14SourceLocationERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseDeclaration(/*uint*/int Context, 
                  final SourceLocation /*&*/ DeclEnd, 
                  final ParsedAttributesWithRange /*&*/ attrs) {
    ParenBraceBracketBalancer BalancerRAIIObj = null;
    ObjCDeclContextSwitch ObjCDC = null;
    try {
      BalancerRAIIObj/*J*/= new ParenBraceBracketBalancer(/*Deref*/$this());
      // Must temporarily exit the objective-c container scope for
      // parsing c none objective-c decls.
      ObjCDC/*J*/= new ObjCDeclContextSwitch(/*Deref*/$this());
      
      Decl /*P*/ SingleDecl = null;
      // JAVA: use single pointer here
      type$ptr<Decl /*P*/> OwnedType = create_type$ptr((Decl /*P*/)null);
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.kw_template:
       case tok.TokenKind.kw_export:
        $this().ProhibitAttributes(attrs);
        SingleDecl = $this().ParseDeclarationStartingWithTemplate(Context, DeclEnd);
        break;
       case tok.TokenKind.kw_inline:
        // Could be the start of an inline namespace. Allowed as an ext in C++03.
        if ($this().getLangOpts().CPlusPlus && $this().NextToken().is(tok.TokenKind.kw_namespace)) {
          $this().ProhibitAttributes(attrs);
          SourceLocation InlineLoc = $this().ConsumeToken();
          return $this().ParseNamespace(Context, DeclEnd, new SourceLocation(InlineLoc));
        }
        return $this().ParseSimpleDeclaration(Context, DeclEnd, attrs, 
            true);
       case tok.TokenKind.kw_namespace:
        $this().ProhibitAttributes(attrs);
        return $this().ParseNamespace(Context, DeclEnd);
       case tok.TokenKind.kw_using:
        SingleDecl = $this().ParseUsingDirectiveOrDeclaration(Context, new ParsedTemplateInfo(), 
            DeclEnd, attrs, $AddrOf(OwnedType));
        break;
       case tok.TokenKind.kw_static_assert:
       case tok.TokenKind.kw__Static_assert:
        $this().ProhibitAttributes(attrs);
        SingleDecl = $this().ParseStaticAssertDeclaration(DeclEnd);
        break;
       default:
        return $this().ParseSimpleDeclaration(Context, DeclEnd, attrs, true);
      }
      
      // This routine returns a DeclGroup, if the thing we parsed only contains a
      // single decl, convert it now. Alias declarations can also declare a type;
      // include that too if it is present.
      return $this().Actions.ConvertDeclToDeclGroup(SingleDecl, OwnedType.$star());
    } finally {
      if (ObjCDC != null) { ObjCDC.$destroy(); }
      if (BalancerRAIIObj != null) { BalancerRAIIObj.$destroy(); }
    }
  }


///       simple-declaration: [C99 6.7: declaration] [C++ 7p1: dcl.dcl]
///         declaration-specifiers init-declarator-list[opt] ';'
/// [C++11] attribute-specifier-seq decl-specifier-seq[opt]
///             init-declarator-list ';'
///[C90/C++]init-declarator-list ';'                             [TODO]
/// [OMP]   threadprivate-directive                              [TODO]
///
///       for-range-declaration: [C++11 6.5p1: stmt.ranged]
///         attribute-specifier-seq[opt] type-specifier-seq declarator
///
/// If RequireSemi is false, this does not check for a ';' at the end of the
/// declaration.  If it is true, it checks for and eats it.
///
/// If FRI is non-null, we might be parsing a for-range-declaration instead
/// of a simple-declaration. If we find that we are, we also parse the
/// for-range-initializer, and place it here.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSimpleDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1541,
   FQN="clang::Parser::ParseSimpleDeclaration", NM="_ZN5clang6Parser22ParseSimpleDeclarationEjRNS_14SourceLocationERNS0_25ParsedAttributesWithRangeEbPNS0_12ForRangeInitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser22ParseSimpleDeclarationEjRNS_14SourceLocationERNS0_25ParsedAttributesWithRangeEbPNS0_12ForRangeInitE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseSimpleDeclaration(/*uint*/int Context, 
                        final SourceLocation /*&*/ DeclEnd, 
                        final ParsedAttributesWithRange /*&*/ Attrs, 
                        boolean RequireSemi) {
    return $this().ParseSimpleDeclaration(Context, 
                        DeclEnd, 
                        Attrs, 
                        RequireSemi, (ForRangeInit /*P*/ )null);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseSimpleDeclaration(/*uint*/int Context, 
                        final SourceLocation /*&*/ DeclEnd, 
                        final ParsedAttributesWithRange /*&*/ Attrs, 
                        boolean RequireSemi, ForRangeInit /*P*/ FRI/*= null*/) {
    ParsingDeclSpec DS = null;
    try {
      // Parse the common declaration-specifiers piece.
      DS/*J*/= new ParsingDeclSpec(/*Deref*/$this());
      
      DeclSpecContext DSContext = $this().getDeclSpecContextFromDeclaratorContext(Context);
      $this().ParseDeclarationSpecifiers(DS, new ParsedTemplateInfo(), AccessSpecifier.AS_none, DSContext);
      
      // If we had a free-standing type definition with a missing semicolon, we
      // may get this far before the problem becomes obvious.
      if (DS.hasTagDefinition()
         && $this().DiagnoseMissingSemiAfterTagDefinition(DS, AccessSpecifier.AS_none, DSContext)) {
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      // C99 6.7.2.3p6: Handle "struct-or-union identifier;", "enum { X };"
      // declaration-specifiers init-declarator-list[opt] ';'
      if ($this().Tok.is(tok.TokenKind.semi)) {
        $this().ProhibitAttributes(Attrs);
        DeclEnd.$assignMove($this().Tok.getLocation());
        if (RequireSemi) {
          $this().ConsumeToken();
        }
        type$ref<RecordDecl> /*P*/ AnonRecord = create_type$ref((RecordDecl) null);
        Decl /*P*/ TheDecl = $this().Actions.ParsedFreeStandingDeclSpec($this().getCurScope(), AccessSpecifier.AS_none, 
            DS, AnonRecord);
        DS.complete(TheDecl);
        if (AnonRecord.$bool()) {
          Decl /*P*/ decls[/*2*/] = new Decl /*P*/ [/*2*/] {AnonRecord.$deref(), TheDecl};
          return $this().Actions.BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >(decls, true), /*TypeMayContainAuto=*/ false);
        }
        return $this().Actions.ConvertDeclToDeclGroup(TheDecl);
      }
      
      DS.takeAttributesFrom(Attrs);
      return $this().ParseDeclGroup(DS, Context, $AddrOf(DeclEnd), FRI);
    } finally {
      if (DS != null) { DS.$destroy(); }
    }
  }


/// Returns true if this might be the start of a declarator, or a common typo
/// for a declarator.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::MightBeDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1581,
   FQN="clang::Parser::MightBeDeclarator", NM="_ZN5clang6Parser17MightBeDeclaratorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser17MightBeDeclaratorEj")
  //</editor-fold>
  protected /*private*/ boolean MightBeDeclarator(/*uint*/int Context) {
    switch ($this().Tok.getKind()) {
     case tok.TokenKind.annot_cxxscope:
     case tok.TokenKind.annot_template_id:
     case tok.TokenKind.caret:
     case tok.TokenKind.code_completion:
     case tok.TokenKind.coloncolon:
     case tok.TokenKind.ellipsis:
     case tok.TokenKind.kw___attribute:
     case tok.TokenKind.kw_operator:
     case tok.TokenKind.l_paren:
     case tok.TokenKind.star:
      return true;
     case tok.TokenKind.amp:
     case tok.TokenKind.ampamp:
      return $this().getLangOpts().CPlusPlus;
     case tok.TokenKind.l_square: // Might be an attribute on an unnamed bit-field.
      return Context == Declarator.TheContext.MemberContext.getValue() && $this().getLangOpts().CPlusPlus11
         && $this().NextToken().is(tok.TokenKind.l_square);
     case tok.TokenKind.colon: // Might be a typo for '::' or an unnamed bit-field.
      return Context == Declarator.TheContext.MemberContext.getValue() || $this().getLangOpts().CPlusPlus;
     case tok.TokenKind.identifier:
      switch ($this().NextToken().getKind()) {
       case tok.TokenKind.code_completion:
       case tok.TokenKind.coloncolon:
       case tok.TokenKind.comma:
       case tok.TokenKind.equal:
       case tok.TokenKind.equalequal: // Might be a typo for '='.
       case tok.TokenKind.kw_alignas:
       case tok.TokenKind.kw_asm:
       case tok.TokenKind.kw___attribute:
       case tok.TokenKind.l_brace:
       case tok.TokenKind.l_paren:
       case tok.TokenKind.l_square:
       case tok.TokenKind.less:
       case tok.TokenKind.r_brace:
       case tok.TokenKind.r_paren:
       case tok.TokenKind.r_square:
       case tok.TokenKind.semi:
        return true;
       case tok.TokenKind.colon:
        // At namespace scope, 'identifier:' is probably a typo for 'identifier::'
        // and in block scope it's probably a label. Inside a class definition,
        // this is a bit-field.
        return Context == Declarator.TheContext.MemberContext.getValue()
           || ($this().getLangOpts().CPlusPlus && Context == Declarator.TheContext.FileContext.getValue());
       case tok.TokenKind.identifier: // Possible virt-specifier.
        return $this().getLangOpts().CPlusPlus11 && $bool2uint_1bit(($this().isCXX11VirtSpecifier($this().NextToken()).getValue() != 0));
       default:
        return false;
      }
     default:
      return false;
    }
  }


/// ParseDeclGroup - Having concluded that this is either a function
/// definition or a group of object declarations, actually parse the
/// result.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclGroup">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1729,
   FQN="clang::Parser::ParseDeclGroup", NM="_ZN5clang6Parser14ParseDeclGroupERNS_15ParsingDeclSpecEjPNS_14SourceLocationEPNS0_12ForRangeInitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser14ParseDeclGroupERNS_15ParsingDeclSpecEjPNS_14SourceLocationEPNS0_12ForRangeInitE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseDeclGroup(final ParsingDeclSpec /*&*/ DS, 
                /*uint*/int Context) {
    return $this().ParseDeclGroup(DS, 
                Context, 
                (SourceLocation /*P*/ )null, 
                (ForRangeInit /*P*/ )null);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseDeclGroup(final ParsingDeclSpec /*&*/ DS, 
                /*uint*/int Context, 
                final SourceLocation /*P*/ DeclEnd/*= null*/) {
    return $this().ParseDeclGroup(DS, 
                Context, 
                DeclEnd, 
                (ForRangeInit /*P*/ )null);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseDeclGroup(final ParsingDeclSpec /*&*/ DS, 
                /*uint*/int Context, 
                final SourceLocation /*P*/ DeclEnd/*= null*/, 
                ForRangeInit /*P*/ FRI/*= null*/) {
    ParsingDeclarator D = null;
    try {
      // Parse the first declarator.
      D/*J*/= new ParsingDeclarator(/*Deref*/$this(), DS, /*static_cast*/Declarator.TheContext.valueOf(Context));
      $this().ParseDeclarator(D);
      
      // Bail out if the first declarator didn't seem well-formed.
      if (!D.hasName() && !D.mayOmitIdentifier()) {
        $this().SkipMalformedDecl();
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      // Save late-parsed attributes for now; they need to be parsed in the
      // appropriate function scope after the function Decl has been constructed.
      // These will be parsed in ParseFunctionDefinition or ParseLexedAttrList.
      LateParsedAttrList LateParsedAttrs/*J*/= new LateParsedAttrList(true);
      if (D.isFunctionDeclarator()) {
        $this().MaybeParseGNUAttributes(D, $AddrOf(LateParsedAttrs));
        
        // The _Noreturn keyword can't appear here, unlike the GNU noreturn
        // attribute. If we find the keyword here, tell the user to put it
        // at the start instead.
        if ($this().Tok.is(tok.TokenKind.kw__Noreturn)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation Loc = $this().ConsumeToken();
            /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
            /*uint*/uint$ref DiagID = create_uint$ref();
            
            // We can offer a fixit if it's valid to mark this function as _Noreturn
            // and we don't have any other declarators in this declaration.
            boolean Fixit = !DS.setFunctionSpecNoreturn(new SourceLocation(Loc), PrevSpec, DiagID);
            $this().MaybeParseGNUAttributes(D, $AddrOf(LateParsedAttrs));
            Fixit &= $this().Tok.isOneOf$T(tok.TokenKind.semi, tok.TokenKind.l_brace, tok.TokenKind.kw_try);
            
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_c11_noreturn_misplaced)), 
                    (Fixit ? FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/Loc)) : new FixItHint())), 
                (Fixit ? FixItHint.CreateInsertion(D.getLocStart(), new StringRef(/*KEEP_STR*/"_Noreturn ")) : new FixItHint())));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Check to see if we have a function *definition* which must have a body.
      if (D.isFunctionDeclarator()
        // Look at the next token to make sure that this isn't a function
        // declaration.  We have to check this because __attribute__ might be the
        // start of a function definition in GCC-extended K&R C.
         && !$this().isDeclarationAfterDeclarator()) {
        
        // Function definitions are only allowed at file scope and in C++ classes.
        // The C++ inline method definition case is handled elsewhere, so we only
        // need to handle the file scope definition case.
        if (Context == Declarator.TheContext.FileContext.getValue()) {
          if ($this().isStartOfFunctionDefinition(D)) {
            if (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag($this().Tok, diag.err_function_declared_typedef)));
                
                // Recover by treating the 'typedef' as spurious.
                DS.ClearStorageClassSpecs();
              } finally {
                $c$.$destroy();
              }
            }
            
            Decl /*P*/ TheDecl = $this().ParseFunctionDefinition(D, new ParsedTemplateInfo(), $AddrOf(LateParsedAttrs));
            return $this().Actions.ConvertDeclToDeclGroup(TheDecl);
          }
          if ($this().isDeclarationSpecifier()) {
            // If there is an invalid declaration specifier right after the
            // function prototype, then we must be in a missing semicolon case
            // where this isn't actually a body.  Just fall through into the code
            // that handles it as a prototype, and let the top-level code handle
            // the erroneous declspec where it would otherwise expect a comma or
            // semicolon.
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_fn_body)));
              $this().SkipUntil(tok.TokenKind.semi);
              return new OpaquePtr<DeclGroupRef>(null);
            } finally {
              $c$.$destroy();
            }
          }
        } else {
          if ($this().Tok.is(tok.TokenKind.l_brace)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_function_definition_not_allowed)));
              $this().SkipMalformedDecl();
              return new OpaquePtr<DeclGroupRef>(null);
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      if ($this().ParseAsmAttributesAfterDeclarator(D)) {
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      // C++0x [stmt.iter]p1: Check if we have a for-range-declarator. If so, we
      // must parse and analyze the for-range-initializer before the declaration is
      // analyzed.
      //
      // Handle the Objective-C for-in loop variable similarly, although we
      // don't need to parse the container in advance.
      if ((FRI != null) && ($this().Tok.is(tok.TokenKind.colon) || $this().isTokIdentifier_in())) {
        boolean IsForRangeLoop = false;
        if ($this().TryConsumeToken(tok.TokenKind.colon, FRI.ColonLoc)) {
          IsForRangeLoop = true;
          if ($this().Tok.is(tok.TokenKind.l_brace)) {
            FRI.RangeExpr.$assignMove($this().ParseBraceInitializer());
          } else {
            FRI.RangeExpr.$assignMove($this().ParseExpression());
          }
        }
        
        Decl /*P*/ ThisDecl = $this().Actions.ActOnDeclarator($this().getCurScope(), D);
        if (IsForRangeLoop) {
          $this().Actions.ActOnCXXForRangeDecl(ThisDecl);
        }
        $this().Actions.FinalizeDeclaration(ThisDecl);
        D.complete(ThisDecl);
        return $this().Actions.FinalizeDeclaratorGroup($this().getCurScope(), DS, new ArrayRef<Decl /*P*/ >(ThisDecl));
      }
      
      SmallVector<Decl /*P*/> DeclsInGroup/*J*/= new SmallVector<Decl /*P*/>(8, null);
      Decl /*P*/ FirstDecl = $this().ParseDeclarationAfterDeclaratorAndAttributes(D, new ParsedTemplateInfo(), FRI);
      if ($greater_uint(LateParsedAttrs.size(), 0)) {
        $this().ParseLexedAttributeList(LateParsedAttrs, FirstDecl, true, false);
      }
      D.complete(FirstDecl);
      if ((FirstDecl != null)) {
        DeclsInGroup.push_back(FirstDecl);
      }
      
      boolean ExpectSemi = Context != Declarator.TheContext.ForContext.getValue();
      
      // If we don't have a comma, it is either the end of the list (a ';') or an
      // error, bail out.
      SourceLocation CommaLoc/*J*/= new SourceLocation();
      while ($this().TryConsumeToken(tok.TokenKind.comma, CommaLoc)) {
        if ($this().Tok.isAtStartOfLine() && ExpectSemi && !$this().MightBeDeclarator(Context)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // This comma was followed by a line-break and something which can't be
            // the start of a declarator. The comma was probably a typo for a
            // semicolon.
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(CommaLoc), diag.err_expected_semi_declaration)), 
                FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/CommaLoc), new StringRef(/*KEEP_STR*/$SEMI))));
            ExpectSemi = false;
            break;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Parse the next declarator.
        D.clear$ParsingDeclarator();
        D.setCommaLoc(new SourceLocation(CommaLoc));
        
        // Accept attributes in an init-declarator.  In the first declarator in a
        // declaration, these would be part of the declspec.  In subsequent
        // declarators, they become part of the declarator itself, so that they
        // don't apply to declarators after *this* one.  Examples:
        //    short __attribute__((common)) var;    -> declspec
        //    short var __attribute__((common));    -> declarator
        //    short x, __attribute__((common)) var;    -> declarator
        $this().MaybeParseGNUAttributes(D);
        
        // MSVC parses but ignores qualifiers after the comma as an extension.
        if ($this().getLangOpts().MicrosoftExt) {
          $this().DiagnoseAndSkipExtendedMicrosoftTypeAttributes();
        }
        
        $this().ParseDeclarator(D);
        if (!D.isInvalidType()) {
          Decl /*P*/ ThisDecl = $this().ParseDeclarationAfterDeclarator(D);
          D.complete(ThisDecl);
          if ((ThisDecl != null)) {
            DeclsInGroup.push_back(ThisDecl);
          }
        }
      }
      if ((DeclEnd != null)) {
        DeclEnd.$assignMove($this().Tok.getLocation());
      }
      if (ExpectSemi
         && $this().ExpectAndConsumeSemi(Context == Declarator.TheContext.FileContext.getValue() ? diag.err_invalid_token_after_toplevel_declarator : diag.err_expected_semi_declaration)) {
        // Okay, there was no semicolon and one was expected.  If we see a
        // declaration specifier, just assume it was missing and continue parsing.
        // Otherwise things are very confused and we skip to recover.
        if (!$this().isDeclarationSpecifier()) {
          $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          $this().TryConsumeToken(tok.TokenKind.semi);
        }
      }
      
      return $this().Actions.FinalizeDeclaratorGroup($this().getCurScope(), DS, new ArrayRef<Decl /*P*/ >(DeclsInGroup));
    } finally {
      if (D != null) { D.$destroy(); }
    }
  }


/// \brief Parse 'declaration' after parsing 'declaration-specifiers
/// declarator'. This method parses the remainder of the declaration
/// (including any attributes or initializer, among other things) and
/// finalizes the declaration.
///
///       init-declarator: [C99 6.7]
///         declarator
///         declarator '=' initializer
/// [GNU]   declarator simple-asm-expr[opt] attributes[opt]
/// [GNU]   declarator simple-asm-expr[opt] attributes[opt] '=' initializer
/// [C++]   declarator initializer[opt]
///
/// [C++] initializer:
/// [C++]   '=' initializer-clause
/// [C++]   '(' expression-list ')'
/// [C++0x] '=' 'default'                                                [TODO]
/// [C++0x] '=' 'delete'
/// [C++0x] braced-init-list
///
/// According to the standard grammar, =default and =delete are function
/// definitions, but that definitely doesn't fit with the parser here.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclarationAfterDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1955,
   FQN="clang::Parser::ParseDeclarationAfterDeclarator", NM="_ZN5clang6Parser31ParseDeclarationAfterDeclaratorERNS_10DeclaratorERKNS0_18ParsedTemplateInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser31ParseDeclarationAfterDeclaratorERNS_10DeclaratorERKNS0_18ParsedTemplateInfoE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseDeclarationAfterDeclarator(final Declarator /*&*/ D) {
    return $this().ParseDeclarationAfterDeclarator(D, new ParsedTemplateInfo());
  }
  protected /*private*/ Decl /*P*/ ParseDeclarationAfterDeclarator(final Declarator /*&*/ D, final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/) {
    if ($this().ParseAsmAttributesAfterDeclarator(D)) {
      return null;
    }
    
    return $this().ParseDeclarationAfterDeclaratorAndAttributes(D, TemplateInfo);
  }


/// Parse an optional simple-asm-expr and attributes, and attach them to a
/// declarator. Returns true on an error.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAsmAttributesAfterDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1915,
   FQN="clang::Parser::ParseAsmAttributesAfterDeclarator", NM="_ZN5clang6Parser33ParseAsmAttributesAfterDeclaratorERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser33ParseAsmAttributesAfterDeclaratorERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ boolean ParseAsmAttributesAfterDeclarator(final Declarator /*&*/ D) {
    // If a simple-asm-expr is present, parse it.
    if ($this().Tok.is(tok.TokenKind.kw_asm)) {
      SourceLocation Loc/*J*/= new SourceLocation();
      ActionResultTTrue<Expr /*P*/ > AsmLabel/*J*/= $this().ParseSimpleAsm($AddrOf(Loc));
      if (AsmLabel.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
        return true;
      }
      
      D.setAsmLabel(AsmLabel.get());
      D.SetRangeEnd(new SourceLocation(Loc));
    }
    
    $this().MaybeParseGNUAttributes(D);
    return false;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclarationAfterDeclaratorAndAttributes">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1963,
   FQN="clang::Parser::ParseDeclarationAfterDeclaratorAndAttributes", NM="_ZN5clang6Parser44ParseDeclarationAfterDeclaratorAndAttributesERNS_10DeclaratorERKNS0_18ParsedTemplateInfoEPNS0_12ForRangeInitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser44ParseDeclarationAfterDeclaratorAndAttributesERNS_10DeclaratorERKNS0_18ParsedTemplateInfoEPNS0_12ForRangeInitE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseDeclarationAfterDeclaratorAndAttributes(final Declarator /*&*/ D) {
    return $this().ParseDeclarationAfterDeclaratorAndAttributes(D, new ParsedTemplateInfo(), (ForRangeInit /*P*/ )null);
  }
  protected /*private*/ Decl /*P*/ ParseDeclarationAfterDeclaratorAndAttributes(final Declarator /*&*/ D, final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/) {
    return $this().ParseDeclarationAfterDeclaratorAndAttributes(D, TemplateInfo, (ForRangeInit /*P*/ )null);
  }
  protected /*private*/ Decl /*P*/ ParseDeclarationAfterDeclaratorAndAttributes(final Declarator /*&*/ D, final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/, ForRangeInit /*P*/ FRI/*= null*/) {
    // Inform the current actions module that we just parsed this declarator.
    Decl /*P*/ ThisDecl = null;
    switch (TemplateInfo.Kind) {
     case NonTemplate:
      ThisDecl = $this().Actions.ActOnDeclarator($this().getCurScope(), D);
      break;
     case Template:
     case ExplicitSpecialization:
      {
        ThisDecl = $this().Actions.ActOnTemplateDeclarator($this().getCurScope(), 
            new MutableArrayRef<TemplateParameterList /*P*/ >($Deref(TemplateInfo.TemplateParams)), 
            D);
        {
          VarTemplateDecl /*P*/ VT = dyn_cast_or_null(VarTemplateDecl.class, ThisDecl);
          if ((VT != null)) {
            // Re-direct this decl to refer to the templated decl so that we can
            // initialize it.
            ThisDecl = VT.getTemplatedDecl();
          }
        }
        break;
      }
     case ExplicitInstantiation:
      {
        if ($this().Tok.is(tok.TokenKind.semi)) {
          ActionResult<Decl /*P*/ > ThisRes = $this().Actions.ActOnExplicitInstantiation($this().getCurScope(), new SourceLocation(TemplateInfo.ExternLoc), new SourceLocation(TemplateInfo.TemplateLoc), D);
          if (ThisRes.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
            return null;
          }
          ThisDecl = ThisRes.get();
        } else {
          // FIXME: This check should be for a variable template instantiation only.
          
          // Check that this is a valid instantiation
          if (D.getName().getKind() != UnqualifiedId.IdKind.IK_TemplateId) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // If the declarator-id is not a template-id, issue a diagnostic and
              // recover by ignoring the 'template' keyword.
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_template_defn_explicit_instantiation)), 
                      2), FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TemplateInfo.TemplateLoc))));
              ThisDecl = $this().Actions.ActOnDeclarator($this().getCurScope(), D);
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              SourceLocation LAngleLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/TemplateInfo.TemplateLoc);
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(D.getIdentifierLoc(), 
                          diag.err_explicit_instantiation_with_definition)), 
                      new SourceRange(/*NO_COPY*/TemplateInfo.TemplateLoc)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/LAngleLoc, new StringRef(/*KEEP_STR*/"<>"))));
              
              // Recover as if it were an explicit specialization.
              SmallVector<TemplateParameterList /*P*/> FakedParamLists/*J*/= new SmallVector<TemplateParameterList /*P*/>(4, null);
              FakedParamLists.push_back($this().Actions.ActOnTemplateParameterList(0, new SourceLocation(), new SourceLocation(TemplateInfo.TemplateLoc), new SourceLocation(LAngleLoc), new ArrayRef<Decl /*P*/ >(None), 
                      new SourceLocation(LAngleLoc), (Expr /*P*/ )null));
              
              ThisDecl
                 = $this().Actions.ActOnTemplateDeclarator($this().getCurScope(), new MutableArrayRef<TemplateParameterList /*P*/ >(FakedParamLists), D);
            } finally {
              $c$.$destroy();
            }
          }
        }
        break;
      }
    }
    
    boolean TypeContainsAuto = D.getDeclSpec().containsPlaceholderType();
    
    // Parse declarator '=' initializer.
    // If a '==' or '+=' is found, suggest a fixit to '='.
    if ($this().isTokenEqualOrEqualTypo()) {
      SourceLocation EqualLoc = $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.kw_delete)) {
        if (D.isFunctionDeclarator()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().ConsumeToken(), diag.err_default_delete_in_multiple_declaration)), 
                1/* delete */));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().ConsumeToken(), diag.err_deleted_non_function)));
          } finally {
            $c$.$destroy();
          }
        }
      } else if ($this().Tok.is(tok.TokenKind.kw_default)) {
        if (D.isFunctionDeclarator()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().ConsumeToken(), diag.err_default_delete_in_multiple_declaration)), 
                0/* default */));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().ConsumeToken(), diag.err_default_special_members)));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        if ($this().getLangOpts().CPlusPlus && D.getCXXScopeSpec().isSet()) {
          $this().EnterScope(0);
          $this().Actions.ActOnCXXEnterDeclInitializer($this().getCurScope(), ThisDecl);
        }
        if ($this().Tok.is(tok.TokenKind.code_completion)) {
          $this().Actions.CodeCompleteInitializer($this().getCurScope(), ThisDecl);
          $this().Actions.FinalizeDeclaration(ThisDecl);
          $this().cutOffParsing();
          return null;
        }
        
        ActionResultTTrue<Expr /*P*/ > Init/*J*/= $this().ParseInitializer();
        
        // If this is the only decl in (possibly) range based for statement,
        // our best guess is that the user meant ':' instead of '='.
        if ($this().Tok.is(tok.TokenKind.r_paren) && (FRI != null) && D.isFirstDeclarator()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(EqualLoc), diag.err_single_decl_assign_in_for_range)), 
                FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/EqualLoc), new StringRef(/*KEEP_STR*/$COLON))));
            // We are trying to stop parser from looking for ';' in this for
            // statement, therefore preventing spurious errors to be issued.
            FRI.ColonLoc.$assign(EqualLoc);
            Init.$assignMove(ExprError());
            FRI.RangeExpr.$assign(Init);
          } finally {
            $c$.$destroy();
          }
        }
        if ($this().getLangOpts().CPlusPlus && D.getCXXScopeSpec().isSet()) {
          $this().Actions.ActOnCXXExitDeclInitializer($this().getCurScope(), ThisDecl);
          $this().ExitScope();
        }
        if (Init.isInvalid()) {
          SmallVectorUShort/*tok.TokenKind*/ StopTokens/*J*/= new SmallVectorUShort/*tok.TokenKind*/(2);
          StopTokens.push_back(tok.TokenKind.comma);
          if (D.getContext() == Declarator.TheContext.ForContext
             || D.getContext() == Declarator.TheContext.InitStmtContext) {
            StopTokens.push_back(tok.TokenKind.r_paren);
          }
          $this().SkipUntil(new ArrayRefUShort/*<tok.TokenKind>*/(StopTokens), $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          $this().Actions.ActOnInitializerError(ThisDecl);
        } else {
          $this().Actions.AddInitializerToDecl(ThisDecl, Init.get(), 
              /*DirectInit=*/ false, TypeContainsAuto);
        }
      }
    } else if ($this().Tok.is(tok.TokenKind.l_paren)) {
      BalancedDelimiterTracker T = null;
      try {
        // Parse C++ direct initializer: '(' expression-list ')'
        T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
        T.consumeOpen();
        
        SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
        SmallVector<SourceLocation> CommaLocs/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
        if ($this().getLangOpts().CPlusPlus && D.getCXXScopeSpec().isSet()) {
          $this().EnterScope(0);
          $this().Actions.ActOnCXXEnterDeclInitializer($this().getCurScope(), ThisDecl);
        }
        // JAVA: introduce copy for [&] lambda 
        final Decl/*P*/ $ThisDecl = ThisDecl;
        boolean $result = $this().ParseExpressionList(Exprs, CommaLocs, (/*[&]*/()->
                  {
                    $this().Actions.CodeCompleteConstructor($this().getCurScope(), 
                        cast(VarDecl.class, $ThisDecl).getType().$arrow().getCanonicalTypeInternal(), 
                        $ThisDecl.getLocation(), new ArrayRef<Expr /*P*/ >(Exprs));
                  }
            ));
        assert $ThisDecl == ThisDecl;
        if ($result) {
          $this().Actions.ActOnInitializerError(ThisDecl);
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          if ($this().getLangOpts().CPlusPlus && D.getCXXScopeSpec().isSet()) {
            $this().Actions.ActOnCXXExitDeclInitializer($this().getCurScope(), ThisDecl);
            $this().ExitScope();
          }
        } else {
          // Match the ')'.
          T.consumeClose();
          assert (!Exprs.empty() && Exprs.size() - 1 == CommaLocs.size()) : "Unexpected number of commas!";
          if ($this().getLangOpts().CPlusPlus && D.getCXXScopeSpec().isSet()) {
            $this().Actions.ActOnCXXExitDeclInitializer($this().getCurScope(), ThisDecl);
            $this().ExitScope();
          }
          
          ActionResultTTrue<Expr /*P*/ > Initializer = $this().Actions.ActOnParenListExpr(T.getOpenLocation(), 
              T.getCloseLocation(), 
              new MutableArrayRef<Expr /*P*/ >(Exprs));
          $this().Actions.AddInitializerToDecl(ThisDecl, Initializer.get(), 
              /*DirectInit=*/ true, TypeContainsAuto);
        }
      } finally {
        if (T != null) { T.$destroy(); }
      }
    } else if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)
       && (!($this().CurParsedObjCImpl != null) || !D.isFunctionDeclarator())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Parse C++0x braced-init-list.
        $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_generalized_initializer_lists)));
        if (D.getCXXScopeSpec().isSet()) {
          $this().EnterScope(0);
          $this().Actions.ActOnCXXEnterDeclInitializer($this().getCurScope(), ThisDecl);
        }
        
        ActionResultTTrue<Expr /*P*/ > Init/*J*/= $this().ParseBraceInitializer();
        if (D.getCXXScopeSpec().isSet()) {
          $this().Actions.ActOnCXXExitDeclInitializer($this().getCurScope(), ThisDecl);
          $this().ExitScope();
        }
        if (Init.isInvalid()) {
          $this().Actions.ActOnInitializerError(ThisDecl);
        } else {
          $this().Actions.AddInitializerToDecl(ThisDecl, Init.get(), 
              /*DirectInit=*/ true, TypeContainsAuto);
        }
      } finally {
        $c$.$destroy();
      }
    } else {
      $this().Actions.ActOnUninitializedDecl(ThisDecl, TypeContainsAuto);
    }
    
    $this().Actions.FinalizeDeclaration(ThisDecl);
    
    return ThisDecl;
  }


/// ParseImplicitInt - This method is called when we have an non-typename
/// identifier in a declspec (which normally terminates the decl spec) when
/// the declspec has no type specifier.  In this case, the declspec is either
/// malformed or is "implicit int" (in K&R and C89).
///
/// This method handles diagnosing this prettily and returns false if the
/// declspec is done being processed.  If it recovers and thinks there may be
/// other pieces of declspec after it, it returns true.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseImplicitInt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 2247,
   FQN="clang::Parser::ParseImplicitInt", NM="_ZN5clang6Parser16ParseImplicitIntERNS_8DeclSpecEPNS_12CXXScopeSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser16ParseImplicitIntERNS_8DeclSpecEPNS_12CXXScopeSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ boolean ParseImplicitInt(final DeclSpec /*&*/ DS, CXXScopeSpec /*P*/ SS, 
                  final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                  AccessSpecifier AS, DeclSpecContext DSC, 
                  final ParsedAttributesWithRange /*&*/ Attrs) {
    assert ($this().Tok.is(tok.TokenKind.identifier)) : "should have identifier";
    
    SourceLocation Loc = $this().Tok.getLocation();
    // If we see an identifier that is not a type name, we normally would
    // parse it as the identifer being declared.  However, when a typename
    // is typo'd or the definition is not included, this will incorrectly
    // parse the typename as the identifier name and fall over misparsing
    // later parts of the diagnostic.
    //
    // As such, we try to do some look-ahead in cases where this would
    // otherwise be an "implicit-int" case to see if this is invalid.  For
    // example: "static foo_t x = 4;"  In this case, if we parsed foo_t as
    // an identifier with implicit int, we'd get a parse error because the
    // next token is obviously invalid for a type.  Parse these as a case
    // with an invalid type specifier.
    assert (!DS.hasTypeSpecifier()) : "Type specifier checked above";
    
    // Since we know that this either implicit int (which is rare) or an
    // error, do lookahead to try to do better recovery. This never applies
    // within a type specifier. Outside of C++, we allow this even if the
    // language doesn't "officially" support implicit int -- we support
    // implicit int as an extension in C99 and C11.
    if (!isTypeSpecifier(DSC) && !$this().getLangOpts().CPlusPlus
       && isValidAfterIdentifierInDeclarator($this().NextToken())) {
      // If this token is valid for implicit int, e.g. "static x = 4", then
      // we just avoid eating the identifier, so it will be parsed as the
      // identifier in the declarator.
      return false;
    }
    if ($this().getLangOpts().CPlusPlus
       && DS.getStorageClassSpec() == DeclSpec.SCS.SCS_auto) {
      // Don't require a type specifier if we have the 'auto' storage class
      // specifier in C++98 -- we'll promote it to a type specifier.
      if ((SS != null)) {
        $this().AnnotateScopeToken($Deref(SS), /*IsNewAnnotation*/ false);
      }
      return false;
    }
    if ($this().getLangOpts().CPlusPlus && (!(SS != null) || SS.isEmpty())
       && $this().getLangOpts().MSVCCompat) {
      {
        // Lookup of an unqualified type name has failed in MSVC compatibility mode.
        // Give Sema a chance to recover if we are in a template with dependent base
        // classes.
        OpaquePtr<QualType> T = $this().Actions.ActOnMSVCUnknownTypeName($Deref($this().Tok.getIdentifierInfo()), $this().Tok.getLocation(), 
            DSC == DeclSpecContext.DSC_template_type_arg);
        if (T.$bool()) {
          /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
          /*uint*/uint$ref DiagID = create_uint$ref();
          DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(Loc), PrevSpec, DiagID, new OpaquePtr<QualType>(T), 
              $this().Actions.getASTContext().getPrintingPolicy());
          DS.SetRangeEnd($this().Tok.getLocation());
          $this().ConsumeToken();
          return false;
        }
      }
    }
    
    // Otherwise, if we don't consume this token, we are going to emit an
    // error anyway.  Try to recover from various common problems.  Check
    // to see if this was a reference to a tag name without a tag specified.
    // This is a common problem in C (saying 'foo' instead of 'struct foo').
    //
    // C++ doesn't need this, and isTagName doesn't take SS.
    if (SS == null) {
      /*const*/char$ptr/*char P*/ TagName = null, /*P*/ FixitTagName = null;
      /*tok.TokenKind*/char TagKind = tok.TokenKind.unknown;
      switch ($this().Actions.isTagName($Deref($this().Tok.getIdentifierInfo()), $this().getCurScope())) {
       default:
        break;
       case TST_enum:
        TagName = $tryClone($enum);
        FixitTagName = $tryClone($("enum "));
        TagKind = tok.TokenKind.kw_enum;
        break;
       case TST_union:
        TagName = $tryClone($union);
        FixitTagName = $tryClone($("union "));
        TagKind = tok.TokenKind.kw_union;
        break;
       case TST_struct:
        TagName = $tryClone($struct);
        FixitTagName = $tryClone($("struct "));
        TagKind = tok.TokenKind.kw_struct;
        break;
       case TST_interface:
        TagName = $tryClone($__interface);
        FixitTagName = $tryClone($("__interface "));
        TagKind = tok.TokenKind.kw___interface;
        break;
       case TST_class:
        TagName = $tryClone($class);
        FixitTagName = $tryClone($("class "));
        TagKind = tok.TokenKind.kw_class;
        break;
      }
      if ((TagName != null)) {
        LookupResult R = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          IdentifierInfo /*P*/ TokenName = $this().Tok.getIdentifierInfo();
          R/*J*/= new LookupResult($this().Actions, new DeclarationName(TokenName), new SourceLocation(), 
              Sema.LookupNameKind.LookupOrdinaryName);
          
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(Loc), diag.err_use_of_tag_name_without_tag)), 
                          TokenName), TagName), $this().getLangOpts().CPlusPlus), 
              FixItHint.CreateInsertion($this().Tok.getLocation(), new StringRef(FixitTagName))));
          if ($this().Actions.LookupParsedName(R, $this().getCurScope(), SS)) {
            for (UnresolvedSetIterator I = R.begin(), IEnd = R.end();
                 I.$noteq(IEnd); I.$preInc())  {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag((I.$star()).getLocation(), diag.note_decl_hiding_tag_type)), 
                      TokenName), TagName));
            }
          }
          
          // Parse this as a tag as if the missing tag were present.
          if (TagKind == tok.TokenKind.kw_enum) {
            $this().ParseEnumSpecifier(new SourceLocation(Loc), DS, TemplateInfo, AS, DeclSpecContext.DSC_normal);
          } else {
            $this().ParseClassSpecifier(TagKind, new SourceLocation(Loc), DS, TemplateInfo, AS, 
                /*EnteringContext*/ false, DeclSpecContext.DSC_normal, Attrs);
          }
          return true;
        } finally {
          if (R != null) { R.$destroy(); }
          $c$.$destroy();
        }
      }
    }
    
    // Determine whether this identifier could plausibly be the name of something
    // being declared (with a missing type).
    if (!isTypeSpecifier(DSC)
       && (!(SS != null) || DSC == DeclSpecContext.DSC_top_level || DSC == DeclSpecContext.DSC_class)) {
      // Look ahead to the next token to try to figure out what this declaration
      // was supposed to be.
      switch ($this().NextToken().getKind()) {
       case tok.TokenKind.l_paren:
        {
          TentativeParsingAction PA = null;
          try {
            // static x(4); // 'x' is not a type
            // x(int n);    // 'x' is not a type
            // x (*p)[];    // 'x' is a type
            //
            // Since we're in an error case, we can afford to perform a tentative
            // parse to determine which case we're in.
            PA/*J*/= new TentativeParsingAction(/*Deref*/$this());
            $this().ConsumeToken();
            TPResult TPR = $this().TryParseDeclarator(/*mayBeAbstract*/ false);
            PA.Revert();
            if (TPR != TPResult.False) {
              // The identifier is followed by a parenthesized declarator.
              // It's supposed to be a type.
              break;
            }
            
            // If we're in a context where we could be declaring a constructor,
            // check whether this is a constructor declaration with a bogus name.
            if (DSC == DeclSpecContext.DSC_class || (DSC == DeclSpecContext.DSC_top_level && (SS != null))) {
              type$ref<IdentifierInfo> /*P*/ II = create_type$ref($this().Tok.getIdentifierInfo());
              if ($this().Actions.isCurrentClassNameTypo(II, SS)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_IdentifierInfo$C$P($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(Loc), diag.err_constructor_bad_name)), 
                              $this().Tok.getIdentifierInfo()), II.$deref()), 
                      FixItHint.CreateReplacement(new SourceRange($this().Tok.getLocation()), II.$deref().getName())));
                  $this().Tok.setIdentifierInfo(II.$deref());
                } finally {
                  $c$.$destroy();
                }
              }
            }
          } finally {
            if (PA != null) { PA.$destroy(); }
          }
          // Fall through.
        }
       case tok.TokenKind.comma:
       case tok.TokenKind.equal:
       case tok.TokenKind.kw_asm:
       case tok.TokenKind.l_brace:
       case tok.TokenKind.l_square:
       case tok.TokenKind.semi:
        // This looks like a variable or function declaration. The type is
        // probably missing. We're done parsing decl-specifiers.
        if ((SS != null)) {
          $this().AnnotateScopeToken($Deref(SS), /*IsNewAnnotation*/ false);
        }
        return false;
       default:
        // This is probably supposed to be a type. This includes cases like:
        //   int f(itn);
        //   struct S { unsinged : 4; };
        break;
      }
    }
    
    // This is almost certainly an invalid type name. Let Sema emit a diagnostic
    // and attempt to recover.
    OpaquePtr<QualType> T/*J*/= new OpaquePtr<QualType>();
    type$ref<IdentifierInfo> /*P*/ II = create_type$ref($this().Tok.getIdentifierInfo());
    $this().Actions.DiagnoseUnknownTypeName(II, new SourceLocation(Loc), $this().getCurScope(), SS, T, 
        $this().getLangOpts().CPlusPlus
           && $this().NextToken().is(tok.TokenKind.less));
    if (T.$bool()) {
      // The action has suggested that the type T could be used. Set that as
      // the type in the declaration specifiers, consume the would-be type
      // name token, and we're done.
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref();
      DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(Loc), PrevSpec, DiagID, new OpaquePtr<QualType>(T), 
          $this().Actions.getASTContext().getPrintingPolicy());
      DS.SetRangeEnd($this().Tok.getLocation());
      $this().ConsumeToken();
      // There may be other declaration specifiers after this.
      return true;
    } else if (II.$deref() != $this().Tok.getIdentifierInfo()) {
      // If no type was suggested, the correction is to a keyword
      $this().Tok.setKind(II.$deref().getTokenID());
      // There may be other declaration specifiers after this.
      return true;
    }
    
    // Otherwise, the action had no suggestion for us.  Mark this as an error.
    DS.SetTypeSpecError();
    DS.SetRangeEnd($this().Tok.getLocation());
    $this().ConsumeToken();
    
    // TODO: Could inject an invalid typedef decl in an enclosing scope to
    // avoid rippling error messages on subsequent uses of the same type,
    // could be useful if #include was forgotten.
    return false;
  }


/// \brief Determine the declaration specifier context from the declarator
/// context.
///
/// \param Context the declarator context, which is one of the
/// Declarator::TheContext enumerator values.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::getDeclSpecContextFromDeclaratorContext">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 2459,
   FQN="clang::Parser::getDeclSpecContextFromDeclaratorContext", NM="_ZN5clang6Parser39getDeclSpecContextFromDeclaratorContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser39getDeclSpecContextFromDeclaratorContextEj")
  //</editor-fold>
  protected /*private*/ Parser.DeclSpecContext getDeclSpecContextFromDeclaratorContext(/*uint*/int Context) {
    if (Context == Declarator.TheContext.MemberContext.getValue()) {
      return DeclSpecContext.DSC_class;
    }
    if (Context == Declarator.TheContext.FileContext.getValue()) {
      return DeclSpecContext.DSC_top_level;
    }
    if (Context == Declarator.TheContext.TemplateTypeArgContext.getValue()) {
      return DeclSpecContext.DSC_template_type_arg;
    }
    if (Context == Declarator.TheContext.TrailingReturnContext.getValue()) {
      return DeclSpecContext.DSC_trailing;
    }
    if (Context == Declarator.TheContext.AliasDeclContext.getValue()
       || Context == Declarator.TheContext.AliasTemplateContext.getValue()) {
      return DeclSpecContext.DSC_alias_declaration;
    }
    return DeclSpecContext.DSC_normal;
  }


/// ParseDeclarationSpecifiers
///       declaration-specifiers: [C99 6.7]
///         storage-class-specifier declaration-specifiers[opt]
///         type-specifier declaration-specifiers[opt]
/// [C99]   function-specifier declaration-specifiers[opt]
/// [C11]   alignment-specifier declaration-specifiers[opt]
/// [GNU]   attributes declaration-specifiers[opt]
/// [Clang] '__module_private__' declaration-specifiers[opt]
/// [ObjC1] '__kindof' declaration-specifiers[opt]
///
///       storage-class-specifier: [C99 6.7.1]
///         'typedef'
///         'extern'
///         'static'
///         'auto'
///         'register'
/// [C++]   'mutable'
/// [C++11] 'thread_local'
/// [C11]   '_Thread_local'
/// [GNU]   '__thread'
///       function-specifier: [C99 6.7.4]
/// [C99]   'inline'
/// [C++]   'virtual'
/// [C++]   'explicit'
/// [OpenCL] '__kernel'
///       'friend': [C++ dcl.friend]
///       'constexpr': [C++0x dcl.constexpr]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclarationSpecifiers">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*goto*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 2673,
   FQN="clang::Parser::ParseDeclarationSpecifiers", NM="_ZN5clang6Parser26ParseDeclarationSpecifiersERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextEPNS0_18LateParsedAttrListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser26ParseDeclarationSpecifiersERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextEPNS0_18LateParsedAttrListE")
  //</editor-fold>
  protected /*private*/ void ParseDeclarationSpecifiers(final DeclSpec /*&*/ DS) {
    $this().ParseDeclarationSpecifiers(DS, 
                            new ParsedTemplateInfo(), 
                            AccessSpecifier.AS_none, 
                            DeclSpecContext.DSC_normal, 
                            (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ void ParseDeclarationSpecifiers(final DeclSpec /*&*/ DS, 
                            final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/) {
    $this().ParseDeclarationSpecifiers(DS, 
                            TemplateInfo, 
                            AccessSpecifier.AS_none, 
                            DeclSpecContext.DSC_normal, 
                            (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ void ParseDeclarationSpecifiers(final DeclSpec /*&*/ DS, 
                            final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/, 
                            AccessSpecifier AS/*= AS_none*/) {
    $this().ParseDeclarationSpecifiers(DS, 
                            TemplateInfo, 
                            AS, 
                            DeclSpecContext.DSC_normal, 
                            (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ void ParseDeclarationSpecifiers(final DeclSpec /*&*/ DS, 
                            final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/, 
                            AccessSpecifier AS/*= AS_none*/, 
                            DeclSpecContext DSContext/*= DSC_normal*/) {
    $this().ParseDeclarationSpecifiers(DS, 
                            TemplateInfo, 
                            AS, 
                            DSContext, 
                            (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ void ParseDeclarationSpecifiers(final DeclSpec /*&*/ DS, 
                            final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/, 
                            AccessSpecifier AS/*= AS_none*/, 
                            DeclSpecContext DSContext/*= DSC_normal*/, 
                            LateParsedAttrList /*P*/ LateAttrs/*= null*/) {
    ParsedAttributesWithRange attrs = null;
    try {
      if (DS.getSourceRange().isInvalid()) {
        // Start the range at the current token but make the end of the range
        // invalid.  This will make the entire range invalid unless we successfully
        // consume a token.
        DS.SetRangeStart($this().Tok.getLocation());
        DS.SetRangeEnd(new SourceLocation());
      }
      
      boolean EnteringContext = (DSContext == DeclSpecContext.DSC_class || DSContext == DeclSpecContext.DSC_top_level);
      boolean AttrsLastTime = false;
      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      // We use Sema's policy to get bool macros right.
      PrintingPolicy Policy = $this().Actions.getPrintingPolicy();
      while (true) {
        final bool$ref isInvalid = create_bool$ref(false);
        boolean isStorageClass = false;
        final /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
        final /*uint*/uint$ref DiagID = create_uint$ref(0);
        
        // HACK: MSVC doesn't consider _Atomic to be a keyword and its STL
        // implementation for VS2013 uses _Atomic as an identifier for one of the
        // classes in <atomic>.
        //
        // A typedef declaration containing _Atomic<...> is among the places where
        // the class is used.  If we are currently parsing such a declaration, treat
        // the token as an identifier.
        if ($this().getLangOpts().MSVCCompat && $this().Tok.is(tok.TokenKind.kw__Atomic)
           && DS.getStorageClassSpec() == DeclSpec.SCS.SCS_typedef
           && !DS.hasTypeSpecifier() && $this().GetLookAheadToken(1).is(tok.TokenKind.less)) {
          $this().Tok.setKind(tok.TokenKind.identifier);
        }
        
        SourceLocation Loc = $this().Tok.getLocation();
        boolean $DoneWithDeclSpec = false;
        switch ($this().Tok.getKind()) {
         default:
         $DoneWithDeclSpec = true;
         if (false) { // JAVA: moved out of switch to replace go_to
          if (!AttrsLastTime) {
            $this().ProhibitAttributes(attrs);
          } else {
            // Reject C++11 attributes that appertain to decl specifiers as
            // we don't support any C++11 attributes that appertain to decl
            // specifiers. This also conforms to what g++ 4.8 is doing.
            $this().ProhibitCXX11Attributes(attrs);
            
            DS.takeAttributesFrom(attrs);
          }
          
          // If this is not a declaration specifier token, we're done reading decl
          // specifiers.  First verify that DeclSpec's are consistent.
          DS.Finish($this().Actions, Policy);
          return;
         } 
          break;
         case tok.TokenKind.l_square:
         case tok.TokenKind.kw_alignas:
          if (!$this().getLangOpts().CPlusPlus11 || !($this().isCXX11AttributeSpecifier().getValue() != 0)) {
            $DoneWithDeclSpec=true; break/*switch*/;
          }
          
          $this().ProhibitAttributes(attrs);
          // FIXME: It would be good to recover by accepting the attributes,
          //        but attempting to do that now would cause serious
          //        madness in terms of diagnostics.
          attrs.clear();
          attrs.Range.$assignMove(new SourceRange());
          
          $this().ParseCXX11Attributes(attrs);
          AttrsLastTime = true;
          continue;
         case tok.TokenKind.code_completion:
          {
            Sema.ParserCompletionContext CCC = Sema.ParserCompletionContext.PCC_Namespace;
            if (DS.hasTypeSpecifier()) {
              boolean AllowNonIdentifiers = ($this().getCurScope().getFlags() & (Scope.ScopeFlags.ControlScope
                 | Scope.ScopeFlags.BlockScope
                 | Scope.ScopeFlags.TemplateParamScope
                 | Scope.ScopeFlags.FunctionPrototypeScope
                 | Scope.ScopeFlags.AtCatchScope)) == 0;
              boolean AllowNestedNameSpecifiers = DSContext == DeclSpecContext.DSC_top_level
                 || (DSContext == DeclSpecContext.DSC_class && DS.isFriendSpecified());
              
              $this().Actions.CodeCompleteDeclSpec($this().getCurScope(), DS, 
                  AllowNonIdentifiers, 
                  AllowNestedNameSpecifiers);
              $this().cutOffParsing();
              return;
            }
            if (($this().getCurScope().getFnParent() != null) || ($this().getCurScope().getBlockParent() != null)) {
              CCC = Sema.ParserCompletionContext.PCC_LocalDeclarationSpecifiers;
            } else if (TemplateInfo.Kind != ParsedTemplateInfo.Unnamed_enum.NonTemplate) {
              CCC = DSContext == DeclSpecContext.DSC_class ? Sema.ParserCompletionContext.PCC_MemberTemplate : Sema.ParserCompletionContext.PCC_Template;
            } else if (DSContext == DeclSpecContext.DSC_class) {
              CCC = Sema.ParserCompletionContext.PCC_Class;
            } else if (($this().CurParsedObjCImpl != null)) {
              CCC = Sema.ParserCompletionContext.PCC_ObjCImplementation;
            }
            
            $this().Actions.CodeCompleteOrdinaryName($this().getCurScope(), CCC);
            $this().cutOffParsing();
            return;
          }
         case tok.TokenKind.coloncolon: // ::foo::bar
          // C++ scope specifier.  Annotate and loop, or bail out on error.
          if ($this().TryAnnotateCXXScopeToken(EnteringContext)) {
            if (!DS.hasTypeSpecifier()) {
              DS.SetTypeSpecError();
            }
            $DoneWithDeclSpec=true; break/*switch*/;
          }
          if ($this().Tok.is(tok.TokenKind.coloncolon)) { // ::new or ::delete
            $DoneWithDeclSpec=true; break/*switch*/;
          }
          continue;
         case tok.TokenKind.annot_cxxscope:
          {
            CXXScopeSpec SS = null;
            try {
              if (DS.hasTypeSpecifier() || DS.isTypeAltiVecVector()) {
                $DoneWithDeclSpec=true; break/*switch*/;
              }
              
              SS/*J*/= new CXXScopeSpec();
              $this().Actions.RestoreNestedNameSpecifierAnnotation($this().Tok.getAnnotationValue(), 
                  $this().Tok.getAnnotationRange(), 
                  SS);
              
              // We are looking for a qualified typename.
              Token Next = new Token($this().NextToken());
              if (Next.is(tok.TokenKind.annot_template_id)
                 && ((/*static_cast*/TemplateIdAnnotation /*P*/ )(Next.getAnnotationValue())).
                  Kind == TemplateNameKind.TNK_Type_template) {
                // We have a qualified template-id, e.g., N::A<int>
                
                // C++ [class.qual]p2:
                //   In a lookup in which the constructor is an acceptable lookup
                //   result and the nested-name-specifier nominates a class C:
                //
                //     - if the name specified after the
                //       nested-name-specifier, when looked up in C, is the
                //       injected-class-name of C (Clause 9), or
                //
                //     - if the name specified after the nested-name-specifier
                //       is the same as the identifier or the
                //       simple-template-id's template-name in the last
                //       component of the nested-name-specifier,
                //
                //   the name is instead considered to name the constructor of
                //   class C.
                //
                // Thus, if the template-name is actually the constructor
                // name, then the code is ill-formed; this interpretation is
                // reinforced by the NAD status of core issue 635.
                TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation(Next);
                if ((DSContext == DeclSpecContext.DSC_top_level || DSContext == DeclSpecContext.DSC_class)
                   && (TemplateId.Name != null)
                   && $this().Actions.isCurrentClassName($Deref(TemplateId.Name), $this().getCurScope(), $AddrOf(SS))) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    if ($this().isConstructorDeclarator(/*Unqualified*/ false)) {
                      // The user meant this to be an out-of-line constructor
                      // definition, but template arguments are not allowed
                      // there.  Just allow this as a constructor; we'll
                      // complain about it later.
                      $DoneWithDeclSpec=true; break/*switch*/;
                    }
                    
                    // The user meant this to name a type, but it actually names
                    // a constructor with some extraneous template
                    // arguments. Complain, then parse it as a type as the user
                    // intended.
                    $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(TemplateId.TemplateNameLoc), 
                                diag.err_out_of_line_template_id_type_names_constructor)), 
                            TemplateId.Name), 0/* template name */));
                  } finally {
                    $c$.$destroy();
                  }
                }
                
                DS.getTypeSpecScope().$assign(SS);
                $this().ConsumeToken(); // The C++ scope.
                assert ($this().Tok.is(tok.TokenKind.annot_template_id)) : "ParseOptionalCXXScopeSpecifier not working";
                $this().AnnotateTemplateIdTokenAsType();
                continue;
              }
              if (Next.is(tok.TokenKind.annot_typename)) {
                DS.getTypeSpecScope().$assign(SS);
                $this().ConsumeToken(); // The C++ scope.
                if (($this().Tok.getAnnotationValue() != null)) {
                  OpaquePtr<QualType> T = getTypeAnnotation($this().Tok);
                  isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_typename, 
                      $this().Tok.getAnnotationEndLoc(), 
                      PrevSpec, DiagID, new OpaquePtr<QualType>(T), Policy));
                  if (isInvalid.$deref()) {
                    break;
                  }
                } else {
                  DS.SetTypeSpecError();
                }
                DS.SetRangeEnd($this().Tok.getAnnotationEndLoc());
                $this().ConsumeToken(); // The typename
              }
              if (Next.isNot(tok.TokenKind.identifier)) {
                $DoneWithDeclSpec=true; break/*switch*/;
              }
              
              // If we're in a context where the identifier could be a class name,
              // check whether this is a constructor declaration.
              if ((DSContext == DeclSpecContext.DSC_top_level || DSContext == DeclSpecContext.DSC_class)
                 && $this().Actions.isCurrentClassName($Deref(Next.getIdentifierInfo()), $this().getCurScope(), 
                  $AddrOf(SS))) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  if ($this().isConstructorDeclarator(/*Unqualified*/ false)) {
                    $DoneWithDeclSpec=true; break/*switch*/;
                  }
                  
                  // As noted in C++ [class.qual]p2 (cited above), when the name
                  // of the class is qualified in a context where it could name
                  // a constructor, its a constructor name. However, we've
                  // looked at the declarator, and the user probably meant this
                  // to be a type. Complain that it isn't supposed to be treated
                  // as a type, then proceed to parse it as a type.
                  $c$.clean($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(Next.getLocation(), 
                              diag.err_out_of_line_template_id_type_names_constructor)), 
                          Next.getIdentifierInfo()), 1/* type */));
                } finally {
                  $c$.$destroy();
                }
              }
              
              OpaquePtr<QualType> TypeRep = $this().Actions.getTypeName($Deref(Next.getIdentifierInfo()), Next.getLocation(), 
                  $this().getCurScope(), $AddrOf(SS), false, false, new OpaquePtr<QualType>(null), 
                  /*IsCtorOrDtorName=*/ false, 
                  /*NonTrivialSourceInfo=*/ true);
              
              // If the referenced identifier is not a type, then this declspec is
              // erroneous: We already checked about that it has no type specifier, and
              // C++ doesn't have implicit int.  Diagnose it as a typo w.r.t. to the
              // typename.
              if (!TypeRep.$bool()) {
                ParsedAttributesWithRange Attrs = null;
                try {
                  $this().ConsumeToken(); // Eat the scope spec so the identifier is current.
                  Attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
                  if ($this().ParseImplicitInt(DS, $AddrOf(SS), TemplateInfo, AS, DSContext, Attrs)) {
                    if (!Attrs.empty()) {
                      AttrsLastTime = true;
                      attrs.takeAllFrom(Attrs);
                    }
                    continue;
                  }
                  $DoneWithDeclSpec=true; break/*switch*/;
                } finally {
                  if (Attrs != null) { Attrs.$destroy(); }
                }
              }
              
              DS.getTypeSpecScope().$assign(SS);
              $this().ConsumeToken(); // The C++ scope.
              
              isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(Loc), PrevSpec, 
                  DiagID, new OpaquePtr<QualType>(TypeRep), Policy));
              if (isInvalid.$deref()) {
                break;
              }
              
              DS.SetRangeEnd($this().Tok.getLocation());
              $this().ConsumeToken(); // The typename.
              
              continue;
            } finally {
              if (SS != null) { SS.$destroy(); }
            }
          }
         case tok.TokenKind.annot_typename:
          {
            // If we've previously seen a tag definition, we were almost surely
            // missing a semicolon after it.
            if (DS.hasTypeSpecifier() && DS.hasTagDefinition()) {
              $DoneWithDeclSpec=true; break/*switch*/;
            }
            if (($this().Tok.getAnnotationValue() != null)) {
              OpaquePtr<QualType> T = getTypeAnnotation($this().Tok);
              isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(Loc), PrevSpec, 
                  DiagID, new OpaquePtr<QualType>(T), Policy));
            } else {
              DS.SetTypeSpecError();
            }
            if (isInvalid.$deref()) {
              break;
            }
            
            DS.SetRangeEnd($this().Tok.getAnnotationEndLoc());
            $this().ConsumeToken(); // The typename
            
            continue;
          }
         case tok.TokenKind.kw___is_signed:
          // GNU libstdc++ 4.4 uses __is_signed as an identifier, but Clang
          // typically treats it as a trait. If we see __is_signed as it appears
          // in libstdc++, e.g.,
          //
          //   static const bool __is_signed;
          //
          // then treat __is_signed as an identifier rather than as a keyword.
          if (DS.getTypeSpecType() == TypeSpecifierType.TST_bool
             && DS.getTypeQualifiers() == DeclSpec.TQ.TQ_const.getValue()
             && DS.getStorageClassSpec() == DeclSpec.SCS.SCS_static) {
            $this().TryKeywordIdentFallback(true);
          }
          
          // We're done with the declaration-specifiers.
          $DoneWithDeclSpec=true; break/*switch*/;
         case tok.TokenKind.kw___super:
         case tok.TokenKind.kw_decltype:
         case tok.TokenKind.identifier:
          {
            // This identifier can only be a typedef name if we haven't already seen
            // a type-specifier.  Without this check we misparse:
            //  typedef int X; struct Y { short X; };  as 'short int'.
            if (DS.hasTypeSpecifier()) {
              $DoneWithDeclSpec=true; break/*switch*/;
            }
            
            // In C++, check to see if this is a scope specifier like foo::bar::, if
            // so handle it as such.  This is important for ctor parsing.
            if ($this().getLangOpts().CPlusPlus) {
              if ($this().TryAnnotateCXXScopeToken(EnteringContext)) {
                DS.SetTypeSpecError();
                $DoneWithDeclSpec=true; break/*switch*/;
              }
              if (!$this().Tok.is(tok.TokenKind.identifier)) {
                continue;
              }
            }
            
            // Check for need to substitute AltiVec keyword tokens.
            if ($this().TryAltiVecToken(DS, new SourceLocation(Loc), PrevSpec, DiagID, isInvalid)) {
              break;
            }
            
            // [AltiVec] 2.2: [If the 'vector' specifier is used] The syntax does not
            //                allow the use of a typedef name as a type specifier.
            if (DS.isTypeAltiVecVector()) {
              $DoneWithDeclSpec=true; break/*switch*/;
            }
            if (DSContext == DeclSpecContext.DSC_objc_method_result && $this().isObjCInstancetype()) {
              OpaquePtr<QualType> TypeRep = $this().Actions.ActOnObjCInstanceType(new SourceLocation(Loc));
              assert ((TypeRep).$bool());
              isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(Loc), PrevSpec, 
                  DiagID, new OpaquePtr<QualType>(TypeRep), Policy));
              if (isInvalid.$deref()) {
                break;
              }
              
              DS.SetRangeEnd(new SourceLocation(Loc));
              $this().ConsumeToken();
              continue;
            }
            
            OpaquePtr<QualType> TypeRep = $this().Actions.getTypeName($Deref($this().Tok.getIdentifierInfo()), 
                $this().Tok.getLocation(), $this().getCurScope());
            
            // If this is not a typedef name, don't parse it as part of the declspec,
            // it must be an implicit int or an error.
            if (!TypeRep.$bool()) {
              ParsedAttributesWithRange Attrs = null;
              try {
                Attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
                if ($this().ParseImplicitInt(DS, (CXXScopeSpec /*P*/ )null, TemplateInfo, AS, DSContext, Attrs)) {
                  if (!Attrs.empty()) {
                    AttrsLastTime = true;
                    attrs.takeAllFrom(Attrs);
                  }
                  continue;
                }
                $DoneWithDeclSpec=true; break/*switch*/;
              } finally {
                if (Attrs != null) { Attrs.$destroy(); }
              }
            }
            
            // If we're in a context where the identifier could be a class name,
            // check whether this is a constructor declaration.
            if ($this().getLangOpts().CPlusPlus && DSContext == DeclSpecContext.DSC_class
               && $this().Actions.isCurrentClassName($Deref($this().Tok.getIdentifierInfo()), $this().getCurScope())
               && $this().isConstructorDeclarator(/*Unqualified*/ true)) {
              $DoneWithDeclSpec=true; break/*switch*/;
            }
            
            isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(Loc), PrevSpec, 
                DiagID, new OpaquePtr<QualType>(TypeRep), Policy));
            if (isInvalid.$deref()) {
              break;
            }
            
            DS.SetRangeEnd($this().Tok.getLocation());
            $this().ConsumeToken(); // The identifier
            
            // Objective-C supports type arguments and protocol references
            // following an Objective-C object or object pointer
            // type. Handle either one of them.
            if ($this().Tok.is(tok.TokenKind.less) && $this().getLangOpts().ObjC1) {
              SourceLocation NewEndLoc/*J*/= new SourceLocation();
              ActionResult<OpaquePtr<QualType> > NewTypeRep = $this().parseObjCTypeArgsAndProtocolQualifiers(new SourceLocation(Loc), new OpaquePtr<QualType>(TypeRep), /*consumeLastToken=*/ true, 
                  NewEndLoc);
              if (NewTypeRep.isUsable()) {
                DS.UpdateTypeRep(NewTypeRep.get());
                DS.SetRangeEnd(new SourceLocation(NewEndLoc));
              }
            }
            
            // Need to support trailing type qualifiers (e.g. "id<p> const").
            // If a type specifier follows, it will be diagnosed elsewhere.
            continue;
          }
         case tok.TokenKind.annot_template_id:
          {
            TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
            if (TemplateId.Kind != TemplateNameKind.TNK_Type_template) {
              // This template-id does not refer to a type name, so we're
              // done with the type-specifiers.
              $DoneWithDeclSpec=true; break/*switch*/;
            }
            
            // If we're in a context where the template-id could be a
            // constructor name or specialization, check whether this is a
            // constructor declaration.
            if ($this().getLangOpts().CPlusPlus && DSContext == DeclSpecContext.DSC_class
               && $this().Actions.isCurrentClassName($Deref(TemplateId.Name), $this().getCurScope())
               && $this().isConstructorDeclarator(TemplateId.SS.isEmpty())) {
              $DoneWithDeclSpec=true; break/*switch*/;
            }
            
            // Turn the template-id annotation token into a type annotation
            // token, then try again to parse it as a type-specifier.
            $this().AnnotateTemplateIdTokenAsType();
            continue;
          }
         case tok.TokenKind.kw___attribute:
          
          // GNU attributes support.
          $this().ParseGNUAttributes(DS.getAttributes(), (SourceLocation /*P*/ )null, LateAttrs);
          continue;
         case tok.TokenKind.kw___declspec:
          
          // Microsoft declspec support.
          $this().ParseMicrosoftDeclSpecs(DS.getAttributes());
          continue;
         case tok.TokenKind.kw___forceinline:
          {
            isInvalid.$set(DS.setFunctionSpecForceInline(new SourceLocation(Loc), PrevSpec, DiagID));
            IdentifierInfo /*P*/ AttrName = $this().Tok.getIdentifierInfo();
            SourceLocation AttrNameLoc = $this().Tok.getLocation();
            DS.getAttributes().addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), 
                (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, AttributeList.Syntax.AS_Keyword);
            break;
          }
         case tok.TokenKind.kw___unaligned:
          isInvalid.$set(DS.SetTypeQual(DeclSpec.TQ.TQ_unaligned, new SourceLocation(Loc), PrevSpec, DiagID, 
              $this().getLangOpts()));
          break;
         case tok.TokenKind.kw___sptr:
         case tok.TokenKind.kw___uptr:
         case tok.TokenKind.kw___ptr64:
         case tok.TokenKind.kw___ptr32:
         case tok.TokenKind.kw___w64:
         case tok.TokenKind.kw___cdecl:
         case tok.TokenKind.kw___stdcall:
         case tok.TokenKind.kw___fastcall:
         case tok.TokenKind.kw___thiscall:
         case tok.TokenKind.kw___vectorcall:
          $this().ParseMicrosoftTypeAttributes(DS.getAttributes());
          continue;
         case tok.TokenKind.kw___pascal:
          
          // Borland single token adornments.
          $this().ParseBorlandTypeAttributes(DS.getAttributes());
          continue;
         case tok.TokenKind.kw___kernel:
          
          // OpenCL single token adornments.
          $this().ParseOpenCLKernelAttributes(DS.getAttributes());
          continue;
         case tok.TokenKind.kw__Nonnull:
         case tok.TokenKind.kw__Nullable:
         case tok.TokenKind.kw__Null_unspecified:
          
          // Nullability type specifiers.
          $this().ParseNullabilityTypeSpecifiers(DS.getAttributes());
          continue;
         case tok.TokenKind.kw___kindof:
          
          // Objective-C 'kindof' types.
          DS.getAttributes().addNew($this().Tok.getIdentifierInfo(), new SourceRange(/*NO_COPY*/Loc), (IdentifierInfo /*P*/ )null, new SourceLocation(Loc), 
              (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >> /*P*/ )null, 0, AttributeList.Syntax.AS_Keyword);
          /*(void)*/$this().ConsumeToken();
          continue;
         case tok.TokenKind.kw_typedef:
          
          // storage-class-specifier
          isInvalid.$set(DS.SetStorageClassSpec($this().Actions, DeclSpec.SCS.SCS_typedef, new SourceLocation(Loc), 
              PrevSpec, DiagID, Policy));
          isStorageClass = true;
          break;
         case tok.TokenKind.kw_extern:
          if (DS.getThreadStorageClassSpec() == DeclSpec.TSCS___thread) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.ext_thread_before)), /*KEEP_STR*/$extern));
            } finally {
              $c$.$destroy();
            }
          }
          isInvalid.$set(DS.SetStorageClassSpec($this().Actions, DeclSpec.SCS.SCS_extern, new SourceLocation(Loc), 
              PrevSpec, DiagID, Policy));
          isStorageClass = true;
          break;
         case tok.TokenKind.kw___private_extern__:
          isInvalid.$set(DS.SetStorageClassSpec($this().Actions, DeclSpec.SCS.SCS_private_extern, 
              new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          isStorageClass = true;
          break;
         case tok.TokenKind.kw_static:
          if (DS.getThreadStorageClassSpec() == DeclSpec.TSCS___thread) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.ext_thread_before)), /*KEEP_STR*/$static));
            } finally {
              $c$.$destroy();
            }
          }
          isInvalid.$set(DS.SetStorageClassSpec($this().Actions, DeclSpec.SCS.SCS_static, new SourceLocation(Loc), 
              PrevSpec, DiagID, Policy));
          isStorageClass = true;
          break;
         case tok.TokenKind.kw_auto:
          if ($this().getLangOpts().CPlusPlus11) {
            if ($this().isKnownToBeTypeSpecifier($this().GetLookAheadToken(1))) {
              isInvalid.$set(DS.SetStorageClassSpec($this().Actions, DeclSpec.SCS.SCS_auto, new SourceLocation(Loc), 
                  PrevSpec, DiagID, Policy));
              if (!isInvalid.$deref()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok, diag.ext_auto_storage_class)), 
                      FixItHint.CreateRemoval(new SourceRange(DS.getStorageClassSpecLoc()))));
                } finally {
                  $c$.$destroy();
                }
              }
            } else {
              isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_auto, new SourceLocation(Loc), PrevSpec, 
                  DiagID, Policy));
            }
          } else {
            isInvalid.$set(DS.SetStorageClassSpec($this().Actions, DeclSpec.SCS.SCS_auto, new SourceLocation(Loc), 
                PrevSpec, DiagID, Policy));
          }
          isStorageClass = true;
          break;
         case tok.TokenKind.kw___auto_type:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.ext_auto_type)));
              isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_auto_type, new SourceLocation(Loc), PrevSpec, 
                  DiagID, Policy));
              break;
            } finally {
              $c$.$destroy();
            }
          }
         case tok.TokenKind.kw_register:
          isInvalid.$set(DS.SetStorageClassSpec($this().Actions, DeclSpec.SCS.SCS_register, new SourceLocation(Loc), 
              PrevSpec, DiagID, Policy));
          isStorageClass = true;
          break;
         case tok.TokenKind.kw_mutable:
          isInvalid.$set(DS.SetStorageClassSpec($this().Actions, DeclSpec.SCS.SCS_mutable, new SourceLocation(Loc), 
              PrevSpec, DiagID, Policy));
          isStorageClass = true;
          break;
         case tok.TokenKind.kw___thread:
          isInvalid.$set(DS.SetStorageClassSpecThread(DeclSpec.TSCS___thread, new SourceLocation(Loc), 
              PrevSpec, DiagID));
          isStorageClass = true;
          break;
         case tok.TokenKind.kw_thread_local:
          isInvalid.$set(DS.SetStorageClassSpecThread(DeclSpec.TSCS_thread_local, new SourceLocation(Loc), 
              PrevSpec, DiagID));
          break;
         case tok.TokenKind.kw__Thread_local:
          isInvalid.$set(DS.SetStorageClassSpecThread(DeclSpec.TSCS__Thread_local, 
              new SourceLocation(Loc), PrevSpec, DiagID));
          isStorageClass = true;
          break;
         case tok.TokenKind.kw_inline:
          
          // function-specifier
          isInvalid.$set(DS.setFunctionSpecInline(new SourceLocation(Loc), PrevSpec, DiagID));
          break;
         case tok.TokenKind.kw_virtual:
          isInvalid.$set(DS.setFunctionSpecVirtual(new SourceLocation(Loc), PrevSpec, DiagID));
          break;
         case tok.TokenKind.kw_explicit:
          isInvalid.$set(DS.setFunctionSpecExplicit(new SourceLocation(Loc), PrevSpec, DiagID));
          break;
         case tok.TokenKind.kw__Noreturn:
          if (!$this().getLangOpts().C11) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_c11_noreturn)));
            } finally {
              $c$.$destroy();
            }
          }
          isInvalid.$set(DS.setFunctionSpecNoreturn(new SourceLocation(Loc), PrevSpec, DiagID));
          break;
         case tok.TokenKind.kw__Alignas:
          
          // alignment-specifier
          if (!$this().getLangOpts().C11) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.ext_c11_alignment)), $this().Tok.getName()));
            } finally {
              $c$.$destroy();
            }
          }
          $this().ParseAlignmentSpecifier(DS.getAttributes());
          continue;
         case tok.TokenKind.kw_friend:
          
          // friend
          if (DSContext == DeclSpecContext.DSC_class) {
            isInvalid.$set(DS.SetFriendSpec(new SourceLocation(Loc), PrevSpec, DiagID));
          } else {
            PrevSpec.$assign($EMPTY); // not actually used by the diagnostic
            DiagID.$set(diag.err_friend_invalid_in_context);
            isInvalid.$set(true);
          }
          break;
         case tok.TokenKind.kw___module_private__:
          
          // Modules
          isInvalid.$set(DS.setModulePrivateSpec(new SourceLocation(Loc), PrevSpec, DiagID));
          break;
         case tok.TokenKind.kw_constexpr:
          
          // constexpr
          isInvalid.$set(DS.SetConstexprSpec(new SourceLocation(Loc), PrevSpec, DiagID));
          break;
         case tok.TokenKind.kw_concept:
          
          // concept
          isInvalid.$set(DS.SetConceptSpec(new SourceLocation(Loc), PrevSpec, DiagID));
          break;
         case tok.TokenKind.kw_short:
          
          // type-specifier
          isInvalid.$set(DS.SetTypeSpecWidth(DeclSpec.TSW_short, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_long:
          if (DS.getTypeSpecWidth() != DeclSpec.TSW_long) {
            isInvalid.$set(DS.SetTypeSpecWidth(DeclSpec.TSW_long, new SourceLocation(Loc), PrevSpec, 
                DiagID, Policy));
          } else {
            isInvalid.$set(DS.SetTypeSpecWidth(DeclSpec.TSW_longlong, new SourceLocation(Loc), PrevSpec, 
                DiagID, Policy));
          }
          break;
         case tok.TokenKind.kw___int64:
          isInvalid.$set(DS.SetTypeSpecWidth(DeclSpec.TSW_longlong, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_signed:
          isInvalid.$set(DS.SetTypeSpecSign(DeclSpec.TSS_signed, new SourceLocation(Loc), PrevSpec, 
              DiagID));
          break;
         case tok.TokenKind.kw_unsigned:
          isInvalid.$set(DS.SetTypeSpecSign(DeclSpec.TSS_unsigned, new SourceLocation(Loc), PrevSpec, 
              DiagID));
          break;
         case tok.TokenKind.kw__Complex:
          isInvalid.$set(DS.SetTypeSpecComplex(DeclSpec.TSC.TSC_complex, new SourceLocation(Loc), PrevSpec, 
              DiagID));
          break;
         case tok.TokenKind.kw__Imaginary:
          isInvalid.$set(DS.SetTypeSpecComplex(DeclSpec.TSC.TSC_imaginary, new SourceLocation(Loc), PrevSpec, 
              DiagID));
          break;
         case tok.TokenKind.kw_void:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_void, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_char:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_char, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_int:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_int, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw___int128:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_int128, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_half:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_half, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_float:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_float, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_double:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_double, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw___float128:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_float128, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_wchar_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_wchar, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_char16_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_char16, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_char32_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_char32, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw_bool:
         case tok.TokenKind.kw__Bool:
          if ($this().Tok.is(tok.TokenKind.kw_bool)
             && DS.getTypeSpecType() != DeclSpec.TST_unspecified
             && DS.getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
            PrevSpec.$assign($EMPTY); // Not used by the diagnostic.
            DiagID.$set(diag.err_bool_redeclaration);
            // For better error recovery.
            $this().Tok.setKind(tok.TokenKind.identifier);
            isInvalid.$set(true);
          } else {
            isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_bool, new SourceLocation(Loc), PrevSpec, 
                DiagID, Policy));
          }
          break;
         case tok.TokenKind.kw__Decimal32:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_decimal32, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw__Decimal64:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_decimal64, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw__Decimal128:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_decimal128, new SourceLocation(Loc), PrevSpec, 
              DiagID, Policy));
          break;
         case tok.TokenKind.kw___vector:
          isInvalid.$set(DS.SetTypeAltiVecVector(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw___pixel:
          isInvalid.$set(DS.SetTypeAltiVecPixel(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw___bool:
          isInvalid.$set(DS.SetTypeAltiVecBool(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_pipe:
          if (!$this().getLangOpts().OpenCL || ($less_uint($this().getLangOpts().OpenCLVersion, 200))) {
            // OpenCL 2.0 defined this keyword. OpenCL 1.2 and earlier should
            // support the "pipe" word as identifier.
            $this().Tok.getIdentifierInfo().revertTokenIDToIdentifier();
            $DoneWithDeclSpec=true; break/*switch*/;
          }
          isInvalid.$set(DS.SetTypePipe(true, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image1d_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image1d_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image1d_array_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image1d_array_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image1d_buffer_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image1d_buffer_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image2d_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image2d_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image2d_array_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image2d_array_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image2d_depth_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image2d_depth_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image2d_array_depth_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image2d_array_depth_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image2d_msaa_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image2d_msaa_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image2d_array_msaa_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image2d_array_msaa_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image2d_msaa_depth_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image2d_msaa_depth_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image2d_array_msaa_depth_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image2d_array_msaa_depth_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_image3d_t:
          isInvalid.$set(DS.SetTypeSpecType(DeclSpec.TST_image3d_t, new SourceLocation(Loc), PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw___unknown_anytype:
          isInvalid.$set(DS.SetTypeSpecType(TypeSpecifierType.TST_unknown_anytype, new SourceLocation(Loc), 
              PrevSpec, DiagID, Policy));
          break;
         case tok.TokenKind.kw_class:
         case tok.TokenKind.kw_struct:
         case tok.TokenKind.kw___interface:
         case tok.TokenKind.kw_union:
          {
            ParsedAttributesWithRange Attributes = null;
            try {
              /*tok.TokenKind*/char Kind = $this().Tok.getKind();
              $this().ConsumeToken();
              
              // These are attributes following class specifiers.
              // To produce better diagnostic, we parse them when
              // parsing class specifier.
              Attributes/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
              $this().ParseClassSpecifier(Kind, new SourceLocation(Loc), DS, TemplateInfo, AS, 
                  EnteringContext, DSContext, Attributes);
              
              // If there are attributes following class specifier,
              // take them over and handle them here.
              if (!Attributes.empty()) {
                AttrsLastTime = true;
                attrs.takeAllFrom(Attributes);
              }
              continue;
            } finally {
              if (Attributes != null) { Attributes.$destroy(); }
            }
          }
         case tok.TokenKind.kw_enum:
          
          // enum-specifier:
          $this().ConsumeToken();
          $this().ParseEnumSpecifier(new SourceLocation(Loc), DS, TemplateInfo, AS, DSContext);
          continue;
         case tok.TokenKind.kw_const:
          
          // cv-qualifier:
          isInvalid.$set(DS.SetTypeQual(DeclSpec.TQ.TQ_const, new SourceLocation(Loc), PrevSpec, DiagID, 
              $this().getLangOpts()));
          break;
         case tok.TokenKind.kw_volatile:
          isInvalid.$set(DS.SetTypeQual(DeclSpec.TQ.TQ_volatile, new SourceLocation(Loc), PrevSpec, DiagID, 
              $this().getLangOpts()));
          break;
         case tok.TokenKind.kw_restrict:
          isInvalid.$set(DS.SetTypeQual(DeclSpec.TQ.TQ_restrict, new SourceLocation(Loc), PrevSpec, DiagID, 
              $this().getLangOpts()));
          break;
         case tok.TokenKind.kw_typename:
          
          // C++ typename-specifier:
          if ($this().TryAnnotateTypeOrScopeToken()) {
            DS.SetTypeSpecError();
            $DoneWithDeclSpec=true; break/*switch*/;
          }
          if (!$this().Tok.is(tok.TokenKind.kw_typename)) {
            continue;
          }
          break;
         case tok.TokenKind.kw_typeof:
          
          // GNU typeof support.
          $this().ParseTypeofSpecifier(DS);
          continue;
         case tok.TokenKind.annot_decltype:
          $this().ParseDecltypeSpecifier(DS);
          continue;
         case tok.TokenKind.annot_pragma_pack:
          $this().HandlePragmaPack();
          continue;
         case tok.TokenKind.annot_pragma_ms_pragma:
          $this().HandlePragmaMSPragma();
          continue;
         case tok.TokenKind.annot_pragma_ms_vtordisp:
          $this().HandlePragmaMSVtorDisp();
          continue;
         case tok.TokenKind.annot_pragma_ms_pointers_to_members:
          $this().HandlePragmaMSPointersToMembers();
          continue;
         case tok.TokenKind.kw___underlying_type:
          $this().ParseUnderlyingTypeSpecifier(DS);
          continue;
         case tok.TokenKind.kw__Atomic:
          // C11 6.7.2.4/4:
          //   If the _Atomic keyword is immediately followed by a left parenthesis,
          //   it is interpreted as a type specifier (with a type name), not as a
          //   type qualifier.
          if ($this().NextToken().is(tok.TokenKind.l_paren)) {
            $this().ParseAtomicSpecifier(DS);
            continue;
          }
          isInvalid.$set(DS.SetTypeQual(DeclSpec.TQ.TQ_atomic, new SourceLocation(Loc), PrevSpec, DiagID, 
              $this().getLangOpts()));
          break;
         case tok.TokenKind.kw___generic:
          // generic address space is introduced only in OpenCL v2.0
          // see OpenCL C Spec v2.0 s6.5.5
          if ($less_uint($this().Actions.getLangOpts().OpenCLVersion, 200)) {
            DiagID.$set(diag.err_opencl_unknown_type_specifier);
            PrevSpec.$assign($this().Tok.getIdentifierInfo().getNameStart());
            isInvalid.$set(true);
            break;
          }
          ;
         case tok.TokenKind.kw___private:
         case tok.TokenKind.kw___global:
         case tok.TokenKind.kw___local:
         case tok.TokenKind.kw___constant:
         case tok.TokenKind.kw___read_only:
         case tok.TokenKind.kw___write_only:
         case tok.TokenKind.kw___read_write:
          $this().ParseOpenCLQualifiers(DS.getAttributes());
          break;
         case tok.TokenKind.less:
          // GCC ObjC supports types like "<SomeProtocol>" as a synonym for
          // "id<SomeProtocol>".  This is hopelessly old fashioned and dangerous,
          // but we support it.
          if (DS.hasTypeSpecifier() || !$this().getLangOpts().ObjC1) {
            $DoneWithDeclSpec=true; break/*switch*/;
          }
          
          SourceLocation StartLoc = $this().Tok.getLocation();
          SourceLocation EndLoc/*J*/= new SourceLocation();
          ActionResult<OpaquePtr<QualType> > Type = $this().parseObjCProtocolQualifierType(EndLoc);
          if (Type.isUsable()) {
            if (DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(StartLoc), new SourceLocation(StartLoc), 
                PrevSpec, DiagID, Type.get(), 
                $this().Actions.getASTContext().getPrintingPolicy())) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
              } finally {
                $c$.$destroy();
              }
            }
            
            DS.SetRangeEnd(new SourceLocation(EndLoc));
          } else {
            DS.SetTypeSpecError();
          }
          
          // Need to support trailing type qualifiers (e.g. "id<p> const").
          // If a type specifier follows, it will be diagnosed elsewhere.
          continue;
        }
        if ($DoneWithDeclSpec) { // JAVA: moved out of switch/default to replace go_to
         if (!AttrsLastTime) {
           $this().ProhibitAttributes(attrs);
         } else {
           // Reject C++11 attributes that appertain to decl specifiers as
           // we don't support any C++11 attributes that appertain to decl
           // specifiers. This also conforms to what g++ 4.8 is doing.
           $this().ProhibitCXX11Attributes(attrs);

           DS.takeAttributesFrom(attrs);
         }

         // If this is not a declaration specifier token, we're done reading decl
         // specifiers.  First verify that DeclSpec's are consistent.
         DS.Finish($this().Actions, Policy);
         return;
        }        
        // If the specifier wasn't legal, issue a diagnostic.
        if (isInvalid.$deref()) {
          assert (Native.$bool(PrevSpec)) : "Method did not return previous specifier!";
          assert (DiagID.$deref() != 0);
          if (DiagID.$deref() == diag.ext_duplicate_declspec) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, DiagID)), 
                      PrevSpec), FixItHint.CreateRemoval(new SourceRange($this().Tok.getLocation()))));
            } finally {
              $c$.$destroy();
            }
          } else if (DiagID.$deref() == diag.err_opencl_unknown_type_specifier) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              /*const*/int OpenCLVer = $this().getLangOpts().OpenCLVersion;
              std.string VerSpec = $add_string_string$C($add_string$C_string(llvm.to_string(OpenCLVer / 100), 
                      new std.string(/*KEEP_STR*/$DOT)), 
                  llvm.to_string((OpenCLVer % 100) / 10));
              $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok, DiagID)), new StringRef(VerSpec)), PrevSpec), isStorageClass));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, DiagID)), PrevSpec));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        DS.SetRangeEnd($this().Tok.getLocation());
        if (DiagID.$deref() != diag.err_bool_redeclaration) {
          $this().ConsumeToken();
        }
        
        AttrsLastTime = false;
      }
    } finally {
      if (attrs != null) { attrs.$destroy(); }
    }
  }


/// Determine whether we're looking at something that might be a declarator
/// in a simple-declaration. If it can't possibly be a declarator, maybe
/// diagnose a missing semicolon after a prior tag definition in the decl
/// specifier.
///
/// \return \c true if an error occurred and this can't be any kind of
/// declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseMissingSemiAfterTagDefinition">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 2546,
   FQN="clang::Parser::DiagnoseMissingSemiAfterTagDefinition", NM="_ZN5clang6Parser37DiagnoseMissingSemiAfterTagDefinitionERNS_8DeclSpecENS_15AccessSpecifierENS0_15DeclSpecContextEPNS0_18LateParsedAttrListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser37DiagnoseMissingSemiAfterTagDefinitionERNS_8DeclSpecENS_15AccessSpecifierENS0_15DeclSpecContextEPNS0_18LateParsedAttrListE")
  //</editor-fold>
  protected /*private*/ boolean DiagnoseMissingSemiAfterTagDefinition(final DeclSpec /*&*/ DS, AccessSpecifier AS, 
                                       DeclSpecContext DSContext) {
    return $this().DiagnoseMissingSemiAfterTagDefinition(DS, AS, 
                                       DSContext, 
                                       (LateParsedAttrList /*P*/ )null);
  }
  protected /*private*/ boolean DiagnoseMissingSemiAfterTagDefinition(final DeclSpec /*&*/ DS, AccessSpecifier AS, 
                                       DeclSpecContext DSContext, 
                                       LateParsedAttrList /*P*/ LateAttrs/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (DS.hasTagDefinition()) : "shouldn't call this";
      
      boolean EnteringContext = (DSContext == DeclSpecContext.DSC_class || DSContext == DeclSpecContext.DSC_top_level);
      if ($this().getLangOpts().CPlusPlus
         && $this().Tok.isOneOf$T(tok.TokenKind.identifier, tok.TokenKind.coloncolon, tok.TokenKind.kw_decltype, 
          tok.TokenKind.annot_template_id)
         && $this().TryAnnotateCXXScopeToken(EnteringContext)) {
        $this().SkipMalformedDecl();
        return true;
      }
      
      boolean HasScope = $this().Tok.is(tok.TokenKind.annot_cxxscope);
      // Make a copy in case GetLookAheadToken invalidates the result of NextToken.
      Token AfterScope = new Token(HasScope ? $this().NextToken() : $this().Tok);
      
      // Determine whether the following tokens could possibly be a
      // declarator.
      boolean MightBeDeclarator = true;
      if ($this().Tok.isOneOf(tok.TokenKind.kw_typename, tok.TokenKind.annot_typename)) {
        // A declarator-id can't start with 'typename'.
        MightBeDeclarator = false;
      } else if (AfterScope.is(tok.TokenKind.annot_template_id)) {
        // If we have a type expressed as a template-id, this cannot be a
        // declarator-id (such a type cannot be redeclared in a simple-declaration).
        TemplateIdAnnotation /*P*/ Annot = ((/*static_cast*/TemplateIdAnnotation /*P*/ )(AfterScope.getAnnotationValue()));
        if (Annot.Kind == TemplateNameKind.TNK_Type_template) {
          MightBeDeclarator = false;
        }
      } else if (AfterScope.is(tok.TokenKind.identifier)) {
        final /*const*/ Token /*&*/ Next = HasScope ? $this().GetLookAheadToken(2) : $this().NextToken();
        
        // These tokens cannot come after the declarator-id in a
        // simple-declaration, and are likely to come after a type-specifier.
        if (Next.isOneOf$T(tok.TokenKind.star, tok.TokenKind.amp, tok.TokenKind.ampamp, tok.TokenKind.identifier, 
            tok.TokenKind.annot_cxxscope, tok.TokenKind.coloncolon)) {
          // Missing a semicolon.
          MightBeDeclarator = false;
        } else if (HasScope) {
          CXXScopeSpec SS = null;
          try {
            // If the declarator-id has a scope specifier, it must redeclare a
            // previously-declared entity. If that's a type (and this is not a
            // typedef), that's an error.
            SS/*J*/= new CXXScopeSpec();
            $this().Actions.RestoreNestedNameSpecifierAnnotation($this().Tok.getAnnotationValue(), $this().Tok.getAnnotationRange(), SS);
            final type$ref<IdentifierInfo> /*P*/ Name = create_type$ref(AfterScope.getIdentifierInfo());
            Sema.NameClassification Classification = $this().Actions.ClassifyName($this().getCurScope(), SS, Name, AfterScope.getLocation(), Next, 
                /*IsAddressOfOperand*/ false);
            switch (Classification.getKind()) {
             case NC_Error:
              $this().SkipMalformedDecl();
              return true;
             case NC_Keyword:
             case NC_NestedNameSpecifier:
              throw new llvm_unreachable("typo correction and nested name specifiers not possible here");
             case NC_Type:
             case NC_TypeTemplate:
              // Not a previously-declared non-type entity.
              MightBeDeclarator = false;
              break;
             case NC_Unknown:
             case NC_Expression:
             case NC_VarTemplate:
             case NC_FunctionTemplate:
              // Might be a redeclaration of a prior entity.
              break;
            }
          } finally {
            if (SS != null) { SS.$destroy(); }
          }
        }
      }
      if (MightBeDeclarator) {
        return false;
      }
      
      final /*const*/ PrintingPolicy /*&*/ PPol = $this().Actions.getASTContext().getPrintingPolicy();
      $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().PP.getLocForEndOfToken(DS.getRepAsDecl().getLocEnd()), 
                  diag.err_expected_after)), 
              DeclSpec.getSpecifierName(DS.getTypeSpecType(), PPol)), tok.TokenKind.semi));
      
      // Try to recover from the typo, by dropping the tag definition and parsing
      // the problematic tokens as a type.
      //
      // FIXME: Split the DeclSpec into pieces for the standalone
      // declaration and pieces for the following declaration, instead
      // of assuming that all the other pieces attach to new declaration,
      // and call ParsedFreeStandingDeclSpec as appropriate.
      DS.ClearTypeSpecType();
      ParsedTemplateInfo NotATemplate/*J*/= new ParsedTemplateInfo();
      $this().ParseDeclarationSpecifiers(DS, NotATemplate, AS, DSContext, LateAttrs);
      return false;
    } finally {
      $c$.$destroy();
    }
  }


/// ParseSpecifierQualifierList
///        specifier-qualifier-list:
///          type-specifier specifier-qualifier-list[opt]
///          type-qualifier specifier-qualifier-list[opt]
/// [GNU]    attributes     specifier-qualifier-list[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseSpecifierQualifierList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 2168,
   FQN="clang::Parser::ParseSpecifierQualifierList", NM="_ZN5clang6Parser27ParseSpecifierQualifierListERNS_8DeclSpecENS_15AccessSpecifierENS0_15DeclSpecContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser27ParseSpecifierQualifierListERNS_8DeclSpecENS_15AccessSpecifierENS0_15DeclSpecContextE")
  //</editor-fold>
  protected /*private*/ void ParseSpecifierQualifierList(final DeclSpec /*&*/ DS) {
    $this().ParseSpecifierQualifierList(DS, AccessSpecifier.AS_none, 
                             DeclSpecContext.DSC_normal);
  }
  protected /*private*/ void ParseSpecifierQualifierList(final DeclSpec /*&*/ DS, AccessSpecifier AS/*= AS_none*/) {
    $this().ParseSpecifierQualifierList(DS, AS, 
                             DeclSpecContext.DSC_normal);
  }
  protected /*private*/ void ParseSpecifierQualifierList(final DeclSpec /*&*/ DS, AccessSpecifier AS/*= AS_none*/, 
                             DeclSpecContext DSC/*= DSC_normal*/) {
    /// specifier-qualifier-list is a subset of declaration-specifiers.  Just
    /// parse declaration-specifiers and complain about extra stuff.
    /// TODO: diagnose attribute-specifiers and alignment-specifiers.
    $this().ParseDeclarationSpecifiers(DS, new ParsedTemplateInfo(), AS, DSC);
    
    // Validate declspec for type-name.
    /*uint*/int Specs = DS.getParsedSpecifiers();
    if (isTypeSpecifier(DSC) && !DS.hasTypeSpecifier()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_type)));
        DS.SetTypeSpecError();
      } finally {
        $c$.$destroy();
      }
    } else if (Specs == DeclSpec.ParsedSpecifiers.PQ_None.getValue() && !DS.hasAttributes()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_typename_requires_specqual)));
        if (!DS.hasTypeSpecifier()) {
          DS.SetTypeSpecError();
        }
      } finally {
        $c$.$destroy();
      }
    }
    
    // Issue diagnostic and remove storage class if present.
    if (((Specs & DeclSpec.ParsedSpecifiers.PQ_StorageClassSpecifier.getValue()) != 0)) {
      if (DS.getStorageClassSpecLoc().isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(DS.getStorageClassSpecLoc(), diag.err_typename_invalid_storageclass)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(DS.getThreadStorageClassSpecLoc(), 
              diag.err_typename_invalid_storageclass)));
        } finally {
          $c$.$destroy();
        }
      }
      DS.ClearStorageClassSpecs();
    }
    
    // Issue diagnostic and remove function specifier if present.
    if (((Specs & DeclSpec.ParsedSpecifiers.PQ_FunctionSpecifier.getValue()) != 0)) {
      if (DS.isInlineSpecified()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(DS.getInlineSpecLoc(), diag.err_typename_invalid_functionspec)));
        } finally {
          $c$.$destroy();
        }
      }
      if (DS.isVirtualSpecified()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(DS.getVirtualSpecLoc(), diag.err_typename_invalid_functionspec)));
        } finally {
          $c$.$destroy();
        }
      }
      if (DS.isExplicitSpecified()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(DS.getExplicitSpecLoc(), diag.err_typename_invalid_functionspec)));
        } finally {
          $c$.$destroy();
        }
      }
      DS.ClearFunctionSpecs();
    }
    
    // Issue diagnostic and remove constexpr specfier if present.
    if (DS.isConstexprSpecified() && DSC != DeclSpecContext.DSC_condition) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(DS.getConstexprSpecLoc(), diag.err_typename_invalid_constexpr)));
        DS.ClearConstexprSpec();
      } finally {
        $c$.$destroy();
      }
    }
  }


/// ParseEnumSpecifier
///       enum-specifier: [C99 6.7.2.2]
///         'enum' identifier[opt] '{' enumerator-list '}'
///[C99/C++]'enum' identifier[opt] '{' enumerator-list ',' '}'
/// [GNU]   'enum' attributes[opt] identifier[opt] '{' enumerator-list ',' [opt]
///                                                 '}' attributes[opt]
/// [MS]    'enum' __declspec[opt] identifier[opt] '{' enumerator-list ',' [opt]
///                                                 '}'
///         'enum' identifier
/// [GNU]   'enum' attributes[opt] identifier
///
/// [C++11] enum-head '{' enumerator-list[opt] '}'
/// [C++11] enum-head '{' enumerator-list ','  '}'
///
///       enum-head: [C++11]
///         enum-key attribute-specifier-seq[opt] identifier[opt] enum-base[opt]
///         enum-key attribute-specifier-seq[opt] nested-name-specifier
///             identifier enum-base[opt]
///
///       enum-key: [C++11]
///         'enum'
///         'enum' 'class'
///         'enum' 'struct'
///
///       enum-base: [C++11]
///         ':' type-specifier-seq
///
/// [C++] elaborated-type-specifier:
/// [C++]   'enum' '::'[opt] nested-name-specifier[opt] identifier
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseEnumSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 3809,
   FQN="clang::Parser::ParseEnumSpecifier", NM="_ZN5clang6Parser18ParseEnumSpecifierENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser18ParseEnumSpecifierENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierENS0_15DeclSpecContextE")
  //</editor-fold>
  protected /*private*/ void ParseEnumSpecifier(SourceLocation StartLoc, final DeclSpec /*&*/ DS, 
                    final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                    AccessSpecifier AS, DeclSpecContext DSC) {
    ParsedAttributesWithRange attrs = null;
    SuppressAccessChecks diagsFromTag = null;
    try {
      // Parse the tag portion of this.
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        // Code completion for an enum name.
        $this().Actions.CodeCompleteTag($this().getCurScope(), DeclSpec.TST_enum.getValue());
        $this().cutOffParsing();
        return;
      }
      
      // If attributes exist after tag, parse them.
      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseGNUAttributes(attrs);
      $this().MaybeParseCXX11Attributes(attrs);
      $this().MaybeParseMicrosoftDeclSpecs(attrs);
      
      SourceLocation ScopedEnumKWLoc/*J*/= new SourceLocation();
      boolean IsScopedUsingClassTag = false;
      
      // In C++11, recognize 'enum class' and 'enum struct'.
      if ($this().Tok.isOneOf(tok.TokenKind.kw_class, tok.TokenKind.kw_struct)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_scoped_enum : diag.ext_scoped_enum)));
          IsScopedUsingClassTag = $this().Tok.is(tok.TokenKind.kw_class);
          ScopedEnumKWLoc.$assignMove($this().ConsumeToken());
          
          // Attributes are not allowed between these keywords.  Diagnose,
          // but then just treat them like they appeared in the right place.
          $this().ProhibitAttributes(attrs);
          
          // They are allowed afterwards, though.
          $this().MaybeParseGNUAttributes(attrs);
          $this().MaybeParseCXX11Attributes(attrs);
          $this().MaybeParseMicrosoftDeclSpecs(attrs);
        } finally {
          $c$.$destroy();
        }
      }
      
      // C++11 [temp.explicit]p12:
      //   The usual access controls do not apply to names used to specify
      //   explicit instantiations.
      // We extend this to also cover explicit specializations.  Note that
      // we don't suppress if this turns out to be an elaborated type
      // specifier.
      boolean shouldDelayDiagsInTag = (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation
         || TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitSpecialization);
      diagsFromTag/*J*/= new SuppressAccessChecks(/*Deref*/$this(), shouldDelayDiagsInTag);
      
      // Enum definitions should not be parsed in a trailing-return-type.
      boolean AllowDeclaration = DSC != DeclSpecContext.DSC_trailing;
      
      boolean AllowFixedUnderlyingType = AllowDeclaration
         && ($this().getLangOpts().CPlusPlus11 || $this().getLangOpts().MicrosoftExt
         || $this().getLangOpts().ObjC2);
      
      final CXXScopeSpec /*&*/ SS = DS.getTypeSpecScope();
      if ($this().getLangOpts().CPlusPlus) {
        ColonProtectionRAIIObject X = null;
        CXXScopeSpec Spec = null;
        try {
          // "enum foo : bar;" is not a potential typo for "enum foo::bar;"
          // if a fixed underlying type is allowed.
          X/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this(), AllowFixedUnderlyingType);
          
          Spec/*J*/= new CXXScopeSpec();
          if ($this().ParseOptionalCXXScopeSpecifier(Spec, new OpaquePtr<QualType>(null), 
              /*EnteringContext=*/ true)) {
            return;
          }
          if (Spec.isSet() && $this().Tok.isNot(tok.TokenKind.identifier)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
              if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
                // Has no name and is not a definition.
                // Skip the rest of this declarator, up until the comma or semicolon.
                $this().SkipUntil(tok.TokenKind.comma, SkipUntilFlags.StopAtSemi);
                return;
              }
            } finally {
              $c$.$destroy();
            }
          }
          
          SS.$assign(Spec);
        } finally {
          if (Spec != null) { Spec.$destroy(); }
          if (X != null) { X.$destroy(); }
        }
      }
      
      // Must have either 'enum name' or 'enum {...}'.
      if ($this().Tok.isNot(tok.TokenKind.identifier) && $this().Tok.isNot(tok.TokenKind.l_brace)
         && !(AllowFixedUnderlyingType && $this().Tok.is(tok.TokenKind.colon))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected_either)), tok.TokenKind.identifier), tok.TokenKind.l_brace));
          
          // Skip the rest of this declarator, up until the comma or semicolon.
          $this().SkipUntil(tok.TokenKind.comma, SkipUntilFlags.StopAtSemi);
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // If an identifier is present, consume and remember it.
      IdentifierInfo /*P*/ Name = null;
      SourceLocation NameLoc/*J*/= new SourceLocation();
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        Name = $this().Tok.getIdentifierInfo();
        NameLoc.$assignMove($this().ConsumeToken());
      }
      if (!(Name != null) && ScopedEnumKWLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++0x 7.2p2: The optional identifier shall not be omitted in the
          // declaration of a scoped enumeration.
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_scoped_enum_missing_identifier)));
          ScopedEnumKWLoc.$assignMove(new SourceLocation());
          IsScopedUsingClassTag = false;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Okay, end the suppression area.  We'll decide whether to emit the
      // diagnostics in a second.
      if (shouldDelayDiagsInTag) {
        diagsFromTag.done();
      }
      
      ActionResult<OpaquePtr<QualType> > BaseType/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
      
      // Parse the fixed underlying type.
      boolean CanBeBitfield = (($this().getCurScope().getFlags() & Scope.ScopeFlags.ClassScope) != 0);
      if (AllowFixedUnderlyingType && $this().Tok.is(tok.TokenKind.colon)) {
        boolean PossibleBitfield = false;
        if (CanBeBitfield) {
          EnterExpressionEvaluationContext Unevaluated = null;
          try {
            // If we're in class scope, this can either be an enum declaration with
            // an underlying type, or a declaration of a bitfield member. We try to
            // use a simple disambiguation scheme first to catch the common cases
            // (integer literal, sizeof); if it's still ambiguous, we then consider
            // anything that's a simple-type-specifier followed by '(' as an
            // expression. This suffices because function types are not valid
            // underlying types anyway.
            Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, 
                Sema.ExpressionEvaluationContext.ConstantEvaluated);
            TPResult TPR = $this().isExpressionOrTypeSpecifierSimple($this().NextToken().getKind());
            // If the next token starts an expression, we know we're parsing a
            // bit-field. This is the common case.
            if (TPR == TPResult.True) {
              PossibleBitfield = true;
            } else // If the next token starts a type-specifier-seq, it may be either a
            // a fixed underlying type or the start of a function-style cast in C++;
            // lookahead one more token to see if it's obvious that we have a
            // fixed underlying type.
            if (TPR == TPResult.False
               && $this().GetLookAheadToken(2).getKind() == tok.TokenKind.semi) {
              // Consume the ':'.
              $this().ConsumeToken();
            } else {
              TentativeParsingAction TPA = null;
              try {
                // We have the start of a type-specifier-seq, so we have to perform
                // tentative parsing to determine whether we have an expression or a
                // type.
                TPA/*J*/= new TentativeParsingAction(/*Deref*/$this());
                
                // Consume the ':'.
                $this().ConsumeToken();
                
                // If we see a type specifier followed by an open-brace, we have an
                // ambiguity between an underlying type and a C++11 braced
                // function-style cast. Resolve this by always treating it as an
                // underlying type.
                // FIXME: The standard is not entirely clear on how to disambiguate in
                // this case.
                if (($this().getLangOpts().CPlusPlus
                   && $this().isCXXDeclarationSpecifier(TPResult.True) != TPResult.True)
                   || (!$this().getLangOpts().CPlusPlus && !$this().isDeclarationSpecifier(true))) {
                  // We'll parse this as a bitfield later.
                  PossibleBitfield = true;
                  TPA.Revert();
                } else {
                  // We have a type-specifier-seq.
                  TPA.Commit();
                }
              } finally {
                if (TPA != null) { TPA.$destroy(); }
              }
            }
          } finally {
            if (Unevaluated != null) { Unevaluated.$destroy(); }
          }
        } else {
          // Consume the ':'.
          $this().ConsumeToken();
        }
        if (!PossibleBitfield) {
          SourceRange Range/*J*/= new SourceRange();
          BaseType.$assignMove($this().ParseTypeName($AddrOf(Range)));
          if ($this().getLangOpts().CPlusPlus11) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(new SourceLocation(StartLoc), diag.warn_cxx98_compat_enum_fixed_underlying_type)));
            } finally {
              $c$.$destroy();
            }
          } else if (!$this().getLangOpts().ObjC2) {
            if ($this().getLangOpts().CPlusPlus) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(StartLoc), diag.ext_cxx11_enum_fixed_underlying_type)), /*NO_COPY*/Range));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(StartLoc), diag.ext_c_enum_fixed_underlying_type)), /*NO_COPY*/Range));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
      
      // There are four options here.  If we have 'friend enum foo;' then this is a
      // friend declaration, and cannot have an accompanying definition. If we have
      // 'enum foo;', then this is a forward declaration.  If we have
      // 'enum foo {...' then this is a definition. Otherwise we have something
      // like 'enum foo xyz', a reference.
      //
      // This is needed to handle stuff like this right (C99 6.7.2.3p11):
      // enum foo {..};  void bar() { enum foo; }    <- new foo in bar.
      // enum foo {..};  void bar() { enum foo x; }  <- use of old foo.
      //
      Sema.TagUseKind TUK;
      if (!AllowDeclaration) {
        TUK = Sema.TagUseKind.TUK_Reference;
      } else if ($this().Tok.is(tok.TokenKind.l_brace)) {
        if (DS.isFriendSpecified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok.getLocation(), diag.err_friend_decl_defines_type)), 
                new SourceRange(DS.getFriendSpecLoc())));
            $this().ConsumeBrace();
            $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtSemi);
            TUK = Sema.TagUseKind.TUK_Friend;
          } finally {
            $c$.$destroy();
          }
        } else {
          TUK = Sema.TagUseKind.TUK_Definition;
        }
      } else if (!isTypeSpecifier(DSC)
         && ($this().Tok.is(tok.TokenKind.semi)
         || ($this().Tok.isAtStartOfLine()
         && !$this().isValidAfterTypeSpecifier(CanBeBitfield)))) {
        TUK = DS.isFriendSpecified() ? Sema.TagUseKind.TUK_Friend : Sema.TagUseKind.TUK_Declaration;
        if ($this().Tok.isNot(tok.TokenKind.semi)) {
          // A semicolon was missing after this declaration. Diagnose and recover.
          $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, new StringRef(/*KEEP_STR*/$enum));
          $this().PP.EnterToken($this().Tok);
          $this().Tok.setKind(tok.TokenKind.semi);
        }
      } else {
        TUK = Sema.TagUseKind.TUK_Reference;
      }
      
      // If this is an elaborated type specifier, and we delayed
      // diagnostics before, just merge them into the current pool.
      if (TUK == Sema.TagUseKind.TUK_Reference && shouldDelayDiagsInTag) {
        diagsFromTag.redelay();
      }
      
      MutableArrayRef<TemplateParameterList /*P*/ > TParams/*J*/= new MutableArrayRef<TemplateParameterList /*P*/ >(true);
      if (TemplateInfo.Kind != ParsedTemplateInfo.Unnamed_enum.NonTemplate
         && TUK != Sema.TagUseKind.TUK_Reference) {
        if (!$this().getLangOpts().CPlusPlus11 || !SS.isSet()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Skip the rest of this declarator, up until the comma or semicolon.
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_enum_template)));
            $this().SkipUntil(tok.TokenKind.comma, SkipUntilFlags.StopAtSemi);
            return;
          } finally {
            $c$.$destroy();
          }
        }
        if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Enumerations can't be explicitly instantiated.
            DS.SetTypeSpecError();
            $c$.clean($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_explicit_instantiation_enum)));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        assert ((TemplateInfo.TemplateParams != null)) : "no template parameters";
        TParams.$assignMove(new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateInfo.TemplateParams.data(), 
                TemplateInfo.TemplateParams.size(), true));
      }
      if (TUK == Sema.TagUseKind.TUK_Reference) {
        $this().ProhibitAttributes(attrs);
      }
      if (!(Name != null) && TUK != Sema.TagUseKind.TUK_Definition) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_enumerator_unnamed_no_def)));
          
          // Skip the rest of this declarator, up until the comma or semicolon.
          $this().SkipUntil(tok.TokenKind.comma, SkipUntilFlags.StopAtSemi);
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      $this().handleDeclspecAlignBeforeClassKey(attrs, DS, TUK);
      
      Sema.SkipBodyInfo SkipBody/*J*/= new Sema.SkipBodyInfo();
      if (!(Name != null) && TUK == Sema.TagUseKind.TUK_Definition && $this().Tok.is(tok.TokenKind.l_brace)
         && $this().NextToken().is(tok.TokenKind.identifier)) {
        SkipBody.$assignMove($this().Actions.shouldSkipAnonEnumBody($this().getCurScope(), 
                $this().NextToken().getIdentifierInfo(), 
                $this().NextToken().getLocation()));
      }
      
      bool$ref Owned = create_bool$ref(false);
      bool$ref IsDependent = create_bool$ref(false);
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref();
      Decl /*P*/ TagDecl = $this().Actions.ActOnTag($this().getCurScope(), DeclSpec.TST_enum.getValue(), TUK, 
          new SourceLocation(StartLoc), SS, Name, new SourceLocation(NameLoc), attrs.getList(), 
          AS, DS.getModulePrivateSpecLoc(), new MutableArrayRef<TemplateParameterList /*P*/ >(TParams), 
          Owned, IsDependent, new SourceLocation(ScopedEnumKWLoc), 
          IsScopedUsingClassTag, new ActionResult<OpaquePtr<QualType> >(BaseType), 
          DSC == DeclSpecContext.DSC_type_specifier, $AddrOf(SkipBody));
      if (SkipBody.ShouldSkip) {
        BalancedDelimiterTracker T = null;
        try {
          assert (TUK == Sema.TagUseKind.TUK_Definition) : "can only skip a definition";
          
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
          T.consumeOpen();
          T.skipToEnd();
          if (DS.SetTypeSpecType(DeclSpec.TST_enum, new SourceLocation(StartLoc), 
              new SourceLocation(NameLoc.isValid() ? NameLoc : StartLoc), 
              PrevSpec, DiagID, TagDecl, Owned.$deref(), 
              $this().Actions.getASTContext().getPrintingPolicy())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
            } finally {
              $c$.$destroy();
            }
          }
          return;
        } finally {
          if (T != null) { T.$destroy(); }
        }
      }
      if (IsDependent.$deref()) {
        // This enum has a dependent nested-name-specifier. Handle it as a
        // dependent tag.
        if (!(Name != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            DS.SetTypeSpecError();
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_type_name_after_typename)));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        ActionResult<OpaquePtr<QualType> > Type = $this().Actions.ActOnDependentTag($this().getCurScope(), DeclSpec.TST_enum.getValue(), TUK, SS, Name, new SourceLocation(StartLoc), new SourceLocation(NameLoc));
        if (Type.isInvalid()) {
          DS.SetTypeSpecError();
          return;
        }
        if (DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(StartLoc), 
            new SourceLocation(NameLoc.isValid() ? NameLoc : StartLoc), 
            PrevSpec, DiagID, Type.get(), 
            $this().Actions.getASTContext().getPrintingPolicy())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
          } finally {
            $c$.$destroy();
          }
        }
        
        return;
      }
      if (!(TagDecl != null)) {
        // The action failed to produce an enumeration tag. If this is a
        // definition, consume the entire definition.
        if ($this().Tok.is(tok.TokenKind.l_brace) && TUK != Sema.TagUseKind.TUK_Reference) {
          $this().ConsumeBrace();
          $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtSemi);
        }
        
        DS.SetTypeSpecError();
        return;
      }
      if ($this().Tok.is(tok.TokenKind.l_brace) && TUK != Sema.TagUseKind.TUK_Reference) {
        $this().ParseEnumBody(new SourceLocation(StartLoc), TagDecl);
      }
      if (DS.SetTypeSpecType(DeclSpec.TST_enum, new SourceLocation(StartLoc), 
          new SourceLocation(NameLoc.isValid() ? NameLoc : StartLoc), 
          PrevSpec, DiagID, TagDecl, Owned.$deref(), 
          $this().Actions.getASTContext().getPrintingPolicy())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (diagsFromTag != null) { diagsFromTag.$destroy(); }
      if (attrs != null) { attrs.$destroy(); }
    }
  }


/// ParseEnumBody - Parse a {} enclosed enumerator-list.
///       enumerator-list:
///         enumerator
///         enumerator-list ',' enumerator
///       enumerator:
///         enumeration-constant attributes[opt]
///         enumeration-constant attributes[opt] '=' constant-expression
///       enumeration-constant:
///         identifier
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseEnumBody">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use null as default SuppressAccessChecks*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4162,
   FQN="clang::Parser::ParseEnumBody", NM="_ZN5clang6Parser13ParseEnumBodyENS_14SourceLocationEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser13ParseEnumBodyENS_14SourceLocationEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void ParseEnumBody(SourceLocation StartLoc, Decl /*P*/ EnumDecl) {
    ParseScope EnumScope = null;
    BalancedDelimiterTracker T = null;
    SmallVector<SuppressAccessChecks> EnumAvailabilityDiags = null;
    ParsedAttributes attrs = null;
    try {
      // Enter the scope of the enum body and start the definition.
      EnumScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope | Scope.ScopeFlags.EnumScope);
      $this().Actions.ActOnTagStartDefinition($this().getCurScope(), EnumDecl);
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      T.consumeOpen();
      
      // C does not allow an empty enumerator-list, C++ does [dcl.enum].
      if ($this().Tok.is(tok.TokenKind.r_brace) && !$this().getLangOpts().CPlusPlus) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.error_empty_enum)));
        } finally {
          $c$.$destroy();
        }
      }
      
      SmallVector<Decl /*P*/> EnumConstantDecls/*J*/= new SmallVector<Decl /*P*/>(32, null);
      EnumAvailabilityDiags/*J*/= new SmallVector<SuppressAccessChecks>(32, new SuppressAccessChecks());
      
      Decl /*P*/ LastEnumConstDecl = null;
      
      // Parse the enumerator-list.
      while ($this().Tok.isNot(tok.TokenKind.r_brace)) {
        ParsedAttributesWithRange _attrs = null;
        try {
          // Parse enumerator. If failed, try skipping till the start of the next
          // enumerator definition.
          if ($this().Tok.isNot(tok.TokenKind.identifier)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.identifier));
              if ($this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_brace, SkipUntilFlags.StopBeforeMatch)
                 && $this().TryConsumeToken(tok.TokenKind.comma)) {
                continue;
              }
              break;
            } finally {
              $c$.$destroy();
            }
          }
          IdentifierInfo /*P*/ Ident = $this().Tok.getIdentifierInfo();
          SourceLocation IdentLoc = $this().ConsumeToken();
          
          // If attributes exist after the enumerator, parse them.
          _attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
          $this().MaybeParseGNUAttributes(_attrs);
          $this().ProhibitAttributes(_attrs); // GNU-style attributes are prohibited.
          if ($this().getLangOpts().CPlusPlus11 && $bool2uint_1bit(($this().isCXX11AttributeSpecifier().getValue() != 0))) {
            if (!$this().getLangOpts().CPlusPlus1z) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok.getLocation(), diag.warn_cxx14_compat_attribute)), 
                    1/*enumerator*/));
              } finally {
                $c$.$destroy();
              }
            }
            $this().ParseCXX11Attributes(_attrs);
          }
          
          SourceLocation EqualLoc/*J*/= new SourceLocation();
          ActionResultTTrue<Expr /*P*/ > AssignedVal/*J*/= new ActionResultTTrue<Expr /*P*/ >();
          EnumAvailabilityDiags.emplace_back(new SuppressAccessChecks(/*Deref*/$this()));
          if ($this().TryConsumeToken(tok.TokenKind.equal, EqualLoc)) {
            AssignedVal.$assignMove($this().ParseConstantExpression());
            if (AssignedVal.isInvalid()) {
              $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_brace, SkipUntilFlags.StopBeforeMatch);
            }
          }
          
          // Install the enumerator constant into EnumDecl.
          Decl /*P*/ EnumConstDecl = $this().Actions.ActOnEnumConstant($this().getCurScope(), EnumDecl, 
              LastEnumConstDecl, 
              new SourceLocation(IdentLoc), Ident, 
              _attrs.getList(), new SourceLocation(EqualLoc), 
              AssignedVal.get());
          EnumAvailabilityDiags.back().done();
          
          EnumConstantDecls.push_back(EnumConstDecl);
          LastEnumConstDecl = EnumConstDecl;
          if ($this().Tok.is(tok.TokenKind.identifier)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // We're missing a comma between enumerators.
              SourceLocation Loc = $this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation);
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_enumerator_list_missing_comma)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/$COMMA_SPACE))));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          
          // Emumerator definition must be finished, only comma or r_brace are
          // allowed here.
          SourceLocation CommaLoc/*J*/= new SourceLocation();
          if ($this().Tok.isNot(tok.TokenKind.r_brace) && !$this().TryConsumeToken(tok.TokenKind.comma, CommaLoc)) {
            if (EqualLoc.isValid()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_either)), tok.TokenKind.r_brace), 
                    tok.TokenKind.comma));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_end_of_enumerator)));
              } finally {
                $c$.$destroy();
              }
            }
            if ($this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_brace, SkipUntilFlags.StopBeforeMatch)) {
              if ($this().TryConsumeToken(tok.TokenKind.comma, CommaLoc)) {
                continue;
              }
            } else {
              break;
            }
          }
          
          // If comma is followed by r_brace, emit appropriate warning.
          if ($this().Tok.is(tok.TokenKind.r_brace) && CommaLoc.isValid()) {
            if (!$this().getLangOpts().C99 && !$this().getLangOpts().CPlusPlus11) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(CommaLoc), $this().getLangOpts().CPlusPlus ? diag.ext_enumerator_list_comma_cxx : diag.ext_enumerator_list_comma_c)), 
                    FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/CommaLoc))));
              } finally {
                $c$.$destroy();
              }
            } else if ($this().getLangOpts().CPlusPlus11) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(CommaLoc), diag.warn_cxx98_compat_enumerator_list_comma)), 
                    FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/CommaLoc))));
              } finally {
                $c$.$destroy();
              }
            }
            break;
          }
        } finally {
          if (_attrs != null) { _attrs.$destroy(); }
        }
      }
      
      // Eat the }.
      T.consumeClose();
      
      // If attributes exist after the identifier list, parse them.
      attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      $this().MaybeParseGNUAttributes(attrs);
      
      $this().Actions.ActOnEnumBody(new SourceLocation(StartLoc), T.getRange(), 
          EnumDecl, new ArrayRef<Decl /*P*/ >(EnumConstantDecls), 
          $this().getCurScope(), 
          attrs.getList());
      
      // Now handle enum constant availability diagnostics.
      assert (EnumConstantDecls.size() == EnumAvailabilityDiags.size());
      for (/*size_t*/int i = 0, e = EnumConstantDecls.size(); i != e; ++i) {
        ParsingDeclRAIIObject PD = null;
        try {
          PD/*J*/= new ParsingDeclRAIIObject(/*Deref*/$this(), ParsingDeclRAIIObject.NoParent_t.NoParent);
          EnumAvailabilityDiags.$at(i).redelay();
          PD.complete(EnumConstantDecls.$at(i));
        } finally {
          if (PD != null) { PD.$destroy(); }
        }
      }
      
      EnumScope.Exit();
      $this().Actions.ActOnTagFinishDefinition($this().getCurScope(), EnumDecl, T.getRange());
      
      // The next token must be valid after an enum definition. If not, a ';'
      // was probably forgotten.
      boolean CanBeBitfield = (($this().getCurScope().getFlags() & Scope.ScopeFlags.ClassScope) != 0);
      if (!$this().isValidAfterTypeSpecifier(CanBeBitfield)) {
        $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, new StringRef(/*KEEP_STR*/$enum));
        // Push this token back into the preprocessor and change our current token
        // to ';' so that the rest of the code recovers as though there were an
        // ';' after the definition.
        $this().PP.EnterToken($this().Tok);
        $this().Tok.setKind(tok.TokenKind.semi);
      }
    } finally {
      if (attrs != null) { attrs.$destroy(); }
      if (EnumAvailabilityDiags != null) { EnumAvailabilityDiags.$destroy(); }
      if (T != null) { T.$destroy(); }
      if (EnumScope != null) { EnumScope.$destroy(); }
    }
  }


/// ParseStructUnionBody
///       struct-contents:
///         struct-declaration-list
/// [EXT]   empty
/// [GNU]   "struct-declaration-list" without terminatoring ';'
///       struct-declaration-list:
///         struct-declaration
///         struct-declaration-list struct-declaration
/// [OBC]   '@' 'defs' '(' class-name ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseStructUnionBody">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 3663,
   FQN="clang::Parser::ParseStructUnionBody", NM="_ZN5clang6Parser20ParseStructUnionBodyENS_14SourceLocationEjPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser20ParseStructUnionBodyENS_14SourceLocationEjPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void ParseStructUnionBody(SourceLocation RecordLoc, 
                      /*uint*/int TagType, Decl /*P*/ TagDecl) {
    PrettyDeclStackTraceEntry CrashInfo = null;
    BalancedDelimiterTracker T = null;
    ParseScope StructScope = null;
    ParsedAttributes attrs = null;
    try {
      CrashInfo/*J*/= new PrettyDeclStackTraceEntry($this().Actions, TagDecl, new SourceLocation(RecordLoc), 
          $("parsing struct/union body"));
      assert (!$this().getLangOpts().CPlusPlus) : "C++ declarations not supported";
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      if (T.consumeOpen()) {
        return;
      }
      
      StructScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.DeclScope);
      $this().Actions.ActOnTagStartDefinition($this().getCurScope(), TagDecl);
      
      SmallVector<Decl /*P*/> FieldDecls/*J*/= new SmallVector<Decl /*P*/>(32, null);
      
      // While we still have something to read, read the declarations in the struct.
      while (!$this().tryParseMisplacedModuleImport() && $this().Tok.isNot(tok.TokenKind.r_brace)
         && $this().Tok.isNot(tok.TokenKind.eof)) {
        // Each iteration of this loop reads one struct-declaration.
        
        // Check for extraneous top-level semicolon.
        if ($this().Tok.is(tok.TokenKind.semi)) {
          $this().ConsumeExtraSemi(ExtraSemiKind.InsideStruct, TagType);
          continue;
        }
        
        // Parse _Static_assert declaration.
        if ($this().Tok.is(tok.TokenKind.kw__Static_assert)) {
          SourceLocation DeclEnd/*J*/= new SourceLocation();
          $this().ParseStaticAssertDeclaration(DeclEnd);
          continue;
        }
        if ($this().Tok.is(tok.TokenKind.annot_pragma_pack)) {
          $this().HandlePragmaPack();
          continue;
        }
        if ($this().Tok.is(tok.TokenKind.annot_pragma_align)) {
          $this().HandlePragmaAlign();
          continue;
        }
        if ($this().Tok.is(tok.TokenKind.annot_pragma_openmp)) {
          ParsedAttributesWithRange Attrs = null;
          try {
            // Result can be ignored, because it must be always empty.
            type$ref<AccessSpecifier> AS = create_type$ref(AccessSpecifier.AS_none);
            Attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
            /*(void)*/$this().ParseOpenMPDeclarativeDirectiveWithExtDecl(AS, Attrs);
            continue;
          } finally {
            if (Attrs != null) { Attrs.$destroy(); }
          }
        }
        if (!$this().Tok.is(tok.TokenKind.at)) {
          ParsingDeclSpec DS = null;
          try {
            ParsingFieldDeclarator$Ref2Void CFieldCallback =  /*[&]*/(ParsingFieldDeclarator /*&*/FD) -> 
              {
                // Install the declarator into the current TagDecl.
                Decl /*P*/ Field = $this().Actions.ActOnField($this().getCurScope(), TagDecl, 
                    FD.D.getDeclSpec().getSourceRange().getBegin(), 
                    FD.D, FD.BitfieldSize);
                FieldDecls.push_back(Field);
                FD.complete(Field);
              }
  ;
            
            // Parse all the comma separated declarators.
            DS/*J*/= new ParsingDeclSpec(/*Deref*/$this());
            $this().ParseStructDeclaration(DS, CFieldCallback);
          } finally {
            if (DS != null) { DS.$destroy(); }
          }
        } else { // Handle @defs
          $this().ConsumeToken();
          if (!$this().Tok.isObjCAtKeyword(tok.ObjCKeywordKind.objc_defs)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_unexpected_at)));
              $this().SkipUntil(tok.TokenKind.semi);
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          $this().ConsumeToken();
          $this().ExpectAndConsume(tok.TokenKind.l_paren);
          if (!$this().Tok.is(tok.TokenKind.identifier)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
              $this().SkipUntil(tok.TokenKind.semi);
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          SmallVector<Decl /*P*/> Fields/*J*/= new SmallVector<Decl /*P*/>(16, null);
          $this().Actions.ActOnDefs($this().getCurScope(), TagDecl, $this().Tok.getLocation(), 
              $this().Tok.getIdentifierInfo(), Fields);
          FieldDecls.insert$T(FieldDecls.end(), Fields.begin(), Fields.end());
          $this().ConsumeToken();
          $this().ExpectAndConsume(tok.TokenKind.r_paren);
        }
        if ($this().TryConsumeToken(tok.TokenKind.semi)) {
          continue;
        }
        if ($this().Tok.is(tok.TokenKind.r_brace)) {
          $this().ExpectAndConsume(tok.TokenKind.semi, diag.ext_expected_semi_decl_list);
          break;
        }
        
        $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_semi_decl_list);
        // Skip to end of block or statement to avoid ext-warning on extra ';'.
        $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
        // If we stopped at a ';', eat it.
        $this().TryConsumeToken(tok.TokenKind.semi);
      }
      
      T.consumeClose();
      
      attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      // If attributes exist after struct contents, parse them.
      $this().MaybeParseGNUAttributes(attrs);
      
      $this().Actions.ActOnFields($this().getCurScope(), 
          new SourceLocation(RecordLoc), TagDecl, new ArrayRef<Decl /*P*/ >(FieldDecls), 
          T.getOpenLocation(), T.getCloseLocation(), 
          attrs.getList());
      StructScope.Exit();
      $this().Actions.ActOnTagFinishDefinition($this().getCurScope(), TagDecl, T.getRange());
    } finally {
      if (attrs != null) { attrs.$destroy(); }
      if (StructScope != null) { StructScope.$destroy(); }
      if (T != null) { T.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }


/// ParseStructDeclaration - Parse a struct declaration without the terminating
/// semicolon.
///
///       struct-declaration:
///         specifier-qualifier-list struct-declarator-list
/// [GNU]   __extension__ struct-declaration
/// [GNU]   specifier-qualifier-list
///       struct-declarator-list:
///         struct-declarator
///         struct-declarator-list ',' struct-declarator
/// [GNU]   struct-declarator-list ',' attributes[opt] struct-declarator
///       struct-declarator:
///         declarator
/// [GNU]   declarator attributes[opt]
///         declarator[opt] ':' constant-expression
/// [GNU]   declarator[opt] ':' constant-expression attributes[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseStructDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 3585,
   FQN="clang::Parser::ParseStructDeclaration", NM="_ZN5clang6Parser22ParseStructDeclarationERNS_15ParsingDeclSpecEN4llvm12function_refIFvRNS_22ParsingFieldDeclaratorEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser22ParseStructDeclarationERNS_15ParsingDeclSpecEN4llvm12function_refIFvRNS_22ParsingFieldDeclaratorEEEE")
  //</editor-fold>
  protected /*private*/ void ParseStructDeclaration(final ParsingDeclSpec /*&*/ DS, 
                        ParsingFieldDeclarator$Ref2Void FieldsCallback) {
    if ($this().Tok.is(tok.TokenKind.kw___extension__)) {
      ExtensionRAIIObject O = null;
      try {
        // __extension__ silences extension warnings in the subexpression.
        O/*J*/= new ExtensionRAIIObject($this().Diags); // Use RAII to do this.
        $this().ConsumeToken();
        $this().ParseStructDeclaration(DS, FieldsCallback);
        return;
      } finally {
        if (O != null) { O.$destroy(); }
      }
    }
    
    // Parse the common specifier-qualifiers-list piece.
    $this().ParseSpecifierQualifierList(DS);
    
    // If there are no declarators, this is a free-standing declaration
    // specifier. Let the actions module cope with it.
    if ($this().Tok.is(tok.TokenKind.semi)) {
      type$ref<RecordDecl> /*P*/ AnonRecord = create_type$ref((RecordDecl) null);
      Decl /*P*/ TheDecl = $this().Actions.ParsedFreeStandingDeclSpec($this().getCurScope(), AccessSpecifier.AS_none, 
          DS, AnonRecord);
      assert (!AnonRecord.$bool()) : "Did not expect anonymous struct or union here";
      DS.complete(TheDecl);
      return;
    }
    
    // Read struct-declarators until we find the semicolon.
    boolean FirstDeclarator = true;
    SourceLocation CommaLoc/*J*/= new SourceLocation();
    while (true) {
      ParsingFieldDeclarator DeclaratorInfo = null;
      try {
        DeclaratorInfo/*J*/= new ParsingFieldDeclarator(/*Deref*/$this(), DS);
        DeclaratorInfo.D.setCommaLoc(new SourceLocation(CommaLoc));
        
        // Attributes are only allowed here on successive declarators.
        if (!FirstDeclarator) {
          $this().MaybeParseGNUAttributes(DeclaratorInfo.D);
        }
        
        /// struct-declarator: declarator
        /// struct-declarator: declarator[opt] ':' constant-expression
        if ($this().Tok.isNot(tok.TokenKind.colon)) {
          ColonProtectionRAIIObject X = null;
          try {
            // Don't parse FOO:BAR as if it were a typo for FOO::BAR.
            X/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
            $this().ParseDeclarator(DeclaratorInfo.D);
          } finally {
            if (X != null) { X.$destroy(); }
          }
        } else {
          DeclaratorInfo.D.SetIdentifier((IdentifierInfo /*P*/ )null, $this().Tok.getLocation());
        }
        if ($this().TryConsumeToken(tok.TokenKind.colon)) {
          ActionResultTTrue<Expr /*P*/ > Res/*J*/= $this().ParseConstantExpression();
          if (Res.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
          } else {
            DeclaratorInfo.BitfieldSize = Res.get();
          }
        }
        
        // If attributes exist after the declarator, parse them.
        $this().MaybeParseGNUAttributes(DeclaratorInfo.D);
        
        // We're done with this declarator;  invoke the callback.
        FieldsCallback.$call(DeclaratorInfo);
        
        // If we don't have a comma, it is either the end of the list (a ';')
        // or an error, bail out.
        if (!$this().TryConsumeToken(tok.TokenKind.comma, CommaLoc)) {
          return;
        }
        
        FirstDeclarator = false;
      } finally {
        if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      }
    }
  }


/// isDeclarationSpecifier() - Return true if the current token is part of a
/// declaration specifier.
///
/// \param DisambiguatingWithExpression True to indicate that the purpose of
/// this check is to disambiguate between an expression and a declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isDeclarationSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4472,
   FQN="clang::Parser::isDeclarationSpecifier", NM="_ZN5clang6Parser22isDeclarationSpecifierEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser22isDeclarationSpecifierEb")
  //</editor-fold>
  protected /*private*/ boolean isDeclarationSpecifier() {
    return $this().isDeclarationSpecifier(false);
  }
  protected /*private*/ boolean isDeclarationSpecifier(boolean DisambiguatingWithExpression/*= false*/) {
    switch ($this().Tok.getKind()) {
     default:
      return false;
     case tok.TokenKind.kw_pipe:
      return $this().getLangOpts().OpenCL && ($greatereq_uint($this().getLangOpts().OpenCLVersion, 200));
     case tok.TokenKind.identifier: // foo::bar
      // Unfortunate hack to support "Class.factoryMethod" notation.
      if ($this().getLangOpts().ObjC1 && $this().NextToken().is(tok.TokenKind.period)) {
        return false;
      }
      if ($this().TryAltiVecVectorToken()) {
        return true;
      }
     case tok.TokenKind.kw_decltype: // decltype(T())::type
     case tok.TokenKind.kw_typename: // typename T::type
      // Annotate typenames and C++ scope specifiers.  If we get one, just
      // recurse to handle whatever we get.
      if ($this().TryAnnotateTypeOrScopeToken()) {
        return true;
      }
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        return false;
      }
      
      // If we're in Objective-C and we have an Objective-C class type followed
      // by an identifier and then either ':' or ']', in a place where an
      // expression is permitted, then this is probably a class message send
      // missing the initial '['. In this case, we won't consider this to be
      // the start of a declaration.
      if (DisambiguatingWithExpression
         && $this().isStartOfObjCClassMessageMissingOpenBracket()) {
        return false;
      }
      
      return $this().isDeclarationSpecifier();
     case tok.TokenKind.coloncolon: // ::foo::bar
      if ($this().NextToken().is(tok.TokenKind.kw_new) // ::new
         || $this().NextToken().is(tok.TokenKind.kw_delete)) { // ::delete
        return false;
      }
      
      // Annotate typenames and C++ scope specifiers.  If we get one, just
      // recurse to handle whatever we get.
      if ($this().TryAnnotateTypeOrScopeToken()) {
        return true;
      }
      return $this().isDeclarationSpecifier();
     case tok.TokenKind.kw_typedef:
     case tok.TokenKind.kw_extern:
     case tok.TokenKind.kw___private_extern__:
     case tok.TokenKind.kw_static:
     case tok.TokenKind.kw_auto:
     case tok.TokenKind.kw___auto_type:
     case tok.TokenKind.kw_register:
     case tok.TokenKind.kw___thread:
     case tok.TokenKind.kw_thread_local:
     case tok.TokenKind.kw__Thread_local:
     case tok.TokenKind.kw___module_private__:
     case tok.TokenKind.kw___unknown_anytype:
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw___int64:
     case tok.TokenKind.kw___int128:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw__Complex:
     case tok.TokenKind.kw__Imaginary:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_wchar_t:
     case tok.TokenKind.kw_char16_t:
     case tok.TokenKind.kw_char32_t:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_half:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw___float128:
     case tok.TokenKind.kw_bool:
     case tok.TokenKind.kw__Bool:
     case tok.TokenKind.kw__Decimal32:
     case tok.TokenKind.kw__Decimal64:
     case tok.TokenKind.kw__Decimal128:
     case tok.TokenKind.kw___vector:
     case tok.TokenKind.kw_class:
     case tok.TokenKind.kw_struct:
     case tok.TokenKind.kw_union:
     case tok.TokenKind.kw___interface:
     case tok.TokenKind.kw_enum:
     case tok.TokenKind.kw_const:
     case tok.TokenKind.kw_volatile:
     case tok.TokenKind.kw_restrict:
     case tok.TokenKind.kw_inline:
     case tok.TokenKind.kw_virtual:
     case tok.TokenKind.kw_explicit:
     case tok.TokenKind.kw__Noreturn:
     case tok.TokenKind.kw__Alignas:
     case tok.TokenKind.kw_friend:
     case tok.TokenKind.kw__Static_assert:
     case tok.TokenKind.kw_typeof:
     case tok.TokenKind.kw___attribute:
     case tok.TokenKind.annot_decltype:
     case tok.TokenKind.kw_constexpr:
     case tok.TokenKind.kw_concept:
     case tok.TokenKind.kw__Atomic:
      
      // C11 _Atomic
      return true;
     case tok.TokenKind.less:
      
      // GNU ObjC bizarre protocol extension: <proto1,proto2> with implicit 'id'.
      return $this().getLangOpts().ObjC1;
     case tok.TokenKind.annot_typename:
      
      // typedef-name
      return !DisambiguatingWithExpression
         || !$this().isStartOfObjCClassMessageMissingOpenBracket();
     case tok.TokenKind.kw___declspec:
     case tok.TokenKind.kw___cdecl:
     case tok.TokenKind.kw___stdcall:
     case tok.TokenKind.kw___fastcall:
     case tok.TokenKind.kw___thiscall:
     case tok.TokenKind.kw___vectorcall:
     case tok.TokenKind.kw___w64:
     case tok.TokenKind.kw___sptr:
     case tok.TokenKind.kw___uptr:
     case tok.TokenKind.kw___ptr64:
     case tok.TokenKind.kw___ptr32:
     case tok.TokenKind.kw___forceinline:
     case tok.TokenKind.kw___pascal:
     case tok.TokenKind.kw___unaligned:
     case tok.TokenKind.kw__Nonnull:
     case tok.TokenKind.kw__Nullable:
     case tok.TokenKind.kw__Null_unspecified:
     case tok.TokenKind.kw___kindof:
     case tok.TokenKind.kw___private:
     case tok.TokenKind.kw___local:
     case tok.TokenKind.kw___global:
     case tok.TokenKind.kw___constant:
     case tok.TokenKind.kw___generic:
     case tok.TokenKind.kw___read_only:
     case tok.TokenKind.kw___read_write:
     case tok.TokenKind.kw___write_only:
     case tok.TokenKind.kw_image1d_t:
     case tok.TokenKind.kw_image1d_array_t:
     case tok.TokenKind.kw_image1d_buffer_t:
     case tok.TokenKind.kw_image2d_t:
     case tok.TokenKind.kw_image2d_array_t:
     case tok.TokenKind.kw_image2d_depth_t:
     case tok.TokenKind.kw_image2d_array_depth_t:
     case tok.TokenKind.kw_image2d_msaa_t:
     case tok.TokenKind.kw_image2d_array_msaa_t:
     case tok.TokenKind.kw_image2d_msaa_depth_t:
     case tok.TokenKind.kw_image2d_array_msaa_depth_t:
     case tok.TokenKind.kw_image3d_t:
      
      return true;
    }
  }


/// isTypeSpecifierQualifier - Return true if the current token could be the
/// start of a specifier-qualifier-list.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isTypeSpecifierQualifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4350,
   FQN="clang::Parser::isTypeSpecifierQualifier", NM="_ZN5clang6Parser24isTypeSpecifierQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser24isTypeSpecifierQualifierEv")
  //</editor-fold>
  protected /*private*/ boolean isTypeSpecifierQualifier() {
    switch ($this().Tok.getKind()) {
     default:
      return false;
     case tok.TokenKind.identifier: // foo::bar
      if ($this().TryAltiVecVectorToken()) {
        return true;
      }
     case tok.TokenKind.kw_typename: // typename T::type
      // Annotate typenames and C++ scope specifiers.  If we get one, just
      // recurse to handle whatever we get.
      if ($this().TryAnnotateTypeOrScopeToken()) {
        return true;
      }
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        return false;
      }
      return $this().isTypeSpecifierQualifier();
     case tok.TokenKind.coloncolon: // ::foo::bar
      if ($this().NextToken().is(tok.TokenKind.kw_new) // ::new
         || $this().NextToken().is(tok.TokenKind.kw_delete)) { // ::delete
        return false;
      }
      if ($this().TryAnnotateTypeOrScopeToken()) {
        return true;
      }
      return $this().isTypeSpecifierQualifier();
     case tok.TokenKind.kw___attribute:
     case tok.TokenKind.kw_typeof:
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw___int64:
     case tok.TokenKind.kw___int128:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw__Complex:
     case tok.TokenKind.kw__Imaginary:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_wchar_t:
     case tok.TokenKind.kw_char16_t:
     case tok.TokenKind.kw_char32_t:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_half:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw___float128:
     case tok.TokenKind.kw_bool:
     case tok.TokenKind.kw__Bool:
     case tok.TokenKind.kw__Decimal32:
     case tok.TokenKind.kw__Decimal64:
     case tok.TokenKind.kw__Decimal128:
     case tok.TokenKind.kw___vector:
     case tok.TokenKind.kw_image1d_t:
     case tok.TokenKind.kw_image1d_array_t:
     case tok.TokenKind.kw_image1d_buffer_t:
     case tok.TokenKind.kw_image2d_t:
     case tok.TokenKind.kw_image2d_array_t:
     case tok.TokenKind.kw_image2d_depth_t:
     case tok.TokenKind.kw_image2d_array_depth_t:
     case tok.TokenKind.kw_image2d_msaa_t:
     case tok.TokenKind.kw_image2d_array_msaa_t:
     case tok.TokenKind.kw_image2d_msaa_depth_t:
     case tok.TokenKind.kw_image2d_array_msaa_depth_t:
     case tok.TokenKind.kw_image3d_t:
     case tok.TokenKind.kw_class:
     case tok.TokenKind.kw_struct:
     case tok.TokenKind.kw___interface:
     case tok.TokenKind.kw_union:
     case tok.TokenKind.kw_enum:
     case tok.TokenKind.kw_const:
     case tok.TokenKind.kw_volatile:
     case tok.TokenKind.kw_restrict:
     case tok.TokenKind.kw___unknown_anytype:
     case tok.TokenKind.annot_typename:
      
      // typedef-name
      return true;
     case tok.TokenKind.less:
      
      // GNU ObjC bizarre protocol extension: <proto1,proto2> with implicit 'id'.
      return $this().getLangOpts().ObjC1;
     case tok.TokenKind.kw___cdecl:
     case tok.TokenKind.kw___stdcall:
     case tok.TokenKind.kw___fastcall:
     case tok.TokenKind.kw___thiscall:
     case tok.TokenKind.kw___vectorcall:
     case tok.TokenKind.kw___w64:
     case tok.TokenKind.kw___ptr64:
     case tok.TokenKind.kw___ptr32:
     case tok.TokenKind.kw___pascal:
     case tok.TokenKind.kw___unaligned:
     case tok.TokenKind.kw__Nonnull:
     case tok.TokenKind.kw__Nullable:
     case tok.TokenKind.kw__Null_unspecified:
     case tok.TokenKind.kw___kindof:
     case tok.TokenKind.kw___private:
     case tok.TokenKind.kw___local:
     case tok.TokenKind.kw___global:
     case tok.TokenKind.kw___constant:
     case tok.TokenKind.kw___generic:
     case tok.TokenKind.kw___read_only:
     case tok.TokenKind.kw___read_write:
     case tok.TokenKind.kw___write_only:
      
      return true;
     case tok.TokenKind.kw__Atomic:
      
      // C11 _Atomic
      return true;
    }
  }


/// isKnownToBeTypeSpecifier - Return true if we know that the specified token
/// is definitely a type-specifier.  Return false if it isn't part of a type
/// specifier or if we're not sure.

/// isKnownToBeTypeSpecifier - Return true if we know that the specified token
/// is definitely a type-specifier.  Return false if it isn't part of a type
/// specifier or if we're not sure.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isKnownToBeTypeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4303,
   FQN="clang::Parser::isKnownToBeTypeSpecifier", NM="_ZNK5clang6Parser24isKnownToBeTypeSpecifierERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang6Parser24isKnownToBeTypeSpecifierERKNS_5TokenE")
  //</editor-fold>
  protected /*private*/ boolean isKnownToBeTypeSpecifier(final /*const*/ Token /*&*/ Tok) /*const*/ {
    switch (Tok.getKind()) {
     default:
      return false;
     case tok.TokenKind.kw_short:
     case tok.TokenKind.kw_long:
     case tok.TokenKind.kw___int64:
     case tok.TokenKind.kw___int128:
     case tok.TokenKind.kw_signed:
     case tok.TokenKind.kw_unsigned:
     case tok.TokenKind.kw__Complex:
     case tok.TokenKind.kw__Imaginary:
     case tok.TokenKind.kw_void:
     case tok.TokenKind.kw_char:
     case tok.TokenKind.kw_wchar_t:
     case tok.TokenKind.kw_char16_t:
     case tok.TokenKind.kw_char32_t:
     case tok.TokenKind.kw_int:
     case tok.TokenKind.kw_half:
     case tok.TokenKind.kw_float:
     case tok.TokenKind.kw_double:
     case tok.TokenKind.kw___float128:
     case tok.TokenKind.kw_bool:
     case tok.TokenKind.kw__Bool:
     case tok.TokenKind.kw__Decimal32:
     case tok.TokenKind.kw__Decimal64:
     case tok.TokenKind.kw__Decimal128:
     case tok.TokenKind.kw___vector:
     case tok.TokenKind.kw_image1d_t:
     case tok.TokenKind.kw_image1d_array_t:
     case tok.TokenKind.kw_image1d_buffer_t:
     case tok.TokenKind.kw_image2d_t:
     case tok.TokenKind.kw_image2d_array_t:
     case tok.TokenKind.kw_image2d_depth_t:
     case tok.TokenKind.kw_image2d_array_depth_t:
     case tok.TokenKind.kw_image2d_msaa_t:
     case tok.TokenKind.kw_image2d_array_msaa_t:
     case tok.TokenKind.kw_image2d_msaa_depth_t:
     case tok.TokenKind.kw_image2d_array_msaa_depth_t:
     case tok.TokenKind.kw_image3d_t:
     case tok.TokenKind.kw_class:
     case tok.TokenKind.kw_struct:
     case tok.TokenKind.kw___interface:
     case tok.TokenKind.kw_union:
     case tok.TokenKind.kw_enum:
     case tok.TokenKind.annot_typename:
      
      // typedef-name
      return true;
    }
  }


/// \brief Starting with a scope specifier, identifier, or
/// template-id that refers to the current class, determine whether
/// this is a constructor declarator.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isConstructorDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4652,
   FQN="clang::Parser::isConstructorDeclarator", NM="_ZN5clang6Parser23isConstructorDeclaratorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser23isConstructorDeclaratorEb")
  //</editor-fold>
  protected /*private*/ boolean isConstructorDeclarator(boolean IsUnqualified) {
    TentativeParsingAction TPA = null;
    CXXScopeSpec SS = null;
    DeclaratorScopeObj DeclScopeObj = null;
    ParsedAttributes Attrs = null;
    try {
      TPA/*J*/= new TentativeParsingAction(/*Deref*/$this());
      
      // Parse the C++ scope specifier.
      SS/*J*/= new CXXScopeSpec();
      if ($this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), 
          /*EnteringContext=*/ true)) {
        TPA.Revert();
        return false;
      }
      
      // Parse the constructor name.
      if ($this().Tok.isOneOf(tok.TokenKind.identifier, tok.TokenKind.annot_template_id)) {
        // We already know that we have a constructor name; just consume
        // the token.
        $this().ConsumeToken();
      } else {
        TPA.Revert();
        return false;
      }
      
      // Current class name must be followed by a left parenthesis.
      if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
        TPA.Revert();
        return false;
      }
      $this().ConsumeParen();
      
      // A right parenthesis, or ellipsis followed by a right parenthesis signals
      // that we have a constructor.
      if ($this().Tok.is(tok.TokenKind.r_paren)
         || ($this().Tok.is(tok.TokenKind.ellipsis) && $this().NextToken().is(tok.TokenKind.r_paren))) {
        TPA.Revert();
        return true;
      }
      
      // A C++11 attribute here signals that we have a constructor, and is an
      // attribute on the first constructor parameter.
      if ($this().getLangOpts().CPlusPlus11
         && $bool2uint_1bit(($this().isCXX11AttributeSpecifier(/*Disambiguate*/ false, 
          /*OuterMightBeMessageSend*/ true).getValue() != 0))) {
        TPA.Revert();
        return true;
      }
      
      // If we need to, enter the specified scope.
      DeclScopeObj/*J*/= new DeclaratorScopeObj(/*Deref*/$this(), SS);
      if (SS.isSet() && $this().Actions.ShouldEnterDeclaratorScope($this().getCurScope(), SS)) {
        DeclScopeObj.EnterDeclaratorScope();
      }
      
      // Optionally skip Microsoft attributes.
      Attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      $this().MaybeParseMicrosoftAttributes(Attrs);
      
      // Check whether the next token(s) are part of a declaration
      // specifier, in which case we have the start of a parameter and,
      // therefore, we know that this is a constructor.
      boolean IsConstructor = false;
      if ($this().isDeclarationSpecifier()) {
        IsConstructor = true;
      } else if ($this().Tok.is(tok.TokenKind.identifier)
         || ($this().Tok.is(tok.TokenKind.annot_cxxscope) && $this().NextToken().is(tok.TokenKind.identifier))) {
        // We've seen "C ( X" or "C ( X::Y", but "X" / "X::Y" is not a type.
        // This might be a parenthesized member name, but is more likely to
        // be a constructor declaration with an invalid argument type. Keep
        // looking.
        if ($this().Tok.is(tok.TokenKind.annot_cxxscope)) {
          $this().ConsumeToken();
        }
        $this().ConsumeToken();
        
        // If this is not a constructor, we must be parsing a declarator,
        // which must have one of the following syntactic forms (see the
        // grammar extract at the start of ParseDirectDeclarator):
        switch ($this().Tok.getKind()) {
         case tok.TokenKind.l_paren:
         case tok.TokenKind.l_square:
         case tok.TokenKind.coloncolon:
          // C(X   ::   Y);
          // C(X   ::   *p);
          // Assume this isn't a constructor, rather than assuming it's a
          // constructor with an unnamed parameter of an ill-formed type.
          break;
         case tok.TokenKind.r_paren:
          // C(X   )
          if ($this().NextToken().is(tok.TokenKind.colon) || $this().NextToken().is(tok.TokenKind.kw_try)) {
            // Assume these were meant to be constructors:
            //   C(X)   :    (the name of a bit-field cannot be parenthesized).
            //   C(X)   try  (this is otherwise ill-formed).
            IsConstructor = true;
          }
          if ($this().NextToken().is(tok.TokenKind.semi) || $this().NextToken().is(tok.TokenKind.l_brace)) {
            // If we have a constructor name within the class definition,
            // assume these were meant to be constructors:
            //   C(X)   {
            //   C(X)   ;
            // ... because otherwise we would be declaring a non-static data
            // member that is ill-formed because it's of the same type as its
            // surrounding class.
            //
            // FIXME: We can actually do this whether or not the name is qualified,
            // because if it is qualified in this context it must be being used as
            // a constructor name. However, we do not implement that rule correctly
            // currently, so we're somewhat conservative here.
            IsConstructor = IsUnqualified;
          }
          break;
         default:
          IsConstructor = true;
          break;
        }
      }
      
      TPA.Revert();
      return IsConstructor;
    } finally {
      if (Attrs != null) { Attrs.$destroy(); }
      if (DeclScopeObj != null) { DeclScopeObj.$destroy(); }
      if (SS != null) { SS.$destroy(); }
      if (TPA != null) { TPA.$destroy(); }
    }
  }


//===----------------------------------------------------------------------===//
// C99 6.7: Declarations.
//===----------------------------------------------------------------------===//

/// ParseTypeName
///       type-name: [C99 6.7.6]
///         specifier-qualifier-list abstract-declarator[opt]
///
/// Called type-id in C++.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTypeName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 44,
   FQN="clang::Parser::ParseTypeName", NM="_ZN5clang6Parser13ParseTypeNameEPNS_11SourceRangeENS_10Declarator10TheContextENS_15AccessSpecifierEPPNS_4DeclEPNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser13ParseTypeNameEPNS_11SourceRangeENS_10Declarator10TheContextENS_15AccessSpecifierEPPNS_4DeclEPNS_16ParsedAttributesE")
  //</editor-fold>
  public ActionResult<OpaquePtr<QualType> > ParseTypeName() {
    return $this().ParseTypeName((SourceRange /*P*/ )null, 
               Declarator.TheContext.TypeNameContext, 
               AccessSpecifier.AS_none, 
               (type$ptr<Decl /*P*/>/*P*/)null, 
               (ParsedAttributes /*P*/ )null);
  }
  public ActionResult<OpaquePtr<QualType> > ParseTypeName(SourceRange /*P*/ Range/*= null*/) {
    return $this().ParseTypeName(Range, 
               Declarator.TheContext.TypeNameContext, 
               AccessSpecifier.AS_none, 
               (type$ptr<Decl /*P*/>/*P*/)null, 
               (ParsedAttributes /*P*/ )null);
  }
  public ActionResult<OpaquePtr<QualType> > ParseTypeName(SourceRange /*P*/ Range/*= null*/, 
               Declarator.TheContext Context/*= Declarator::TypeNameContext*/) {
    return $this().ParseTypeName(Range, 
               Context, 
               AccessSpecifier.AS_none, 
               (type$ptr<Decl /*P*/>/*P*/)null, 
               (ParsedAttributes /*P*/ )null);
  }
  public ActionResult<OpaquePtr<QualType> > ParseTypeName(SourceRange /*P*/ Range/*= null*/, 
               Declarator.TheContext Context/*= Declarator::TypeNameContext*/, 
               AccessSpecifier AS/*= AS_none*/) {
    return $this().ParseTypeName(Range, 
               Context, 
               AS, 
               (type$ptr<Decl /*P*/>/*P*/)null, 
               (ParsedAttributes /*P*/ )null);
  }
  public ActionResult<OpaquePtr<QualType> > ParseTypeName(SourceRange /*P*/ Range/*= null*/, 
               Declarator.TheContext Context/*= Declarator::TypeNameContext*/, 
               AccessSpecifier AS/*= AS_none*/, 
               type$ptr<Decl /*P*/>/*P*/OwnedType/*= null*/) {
    return $this().ParseTypeName(Range, 
               Context, 
               AS, 
               OwnedType, 
               (ParsedAttributes /*P*/ )null);
  }
  public ActionResult<OpaquePtr<QualType> > ParseTypeName(SourceRange /*P*/ Range/*= null*/, 
               Declarator.TheContext Context/*= Declarator::TypeNameContext*/, 
               AccessSpecifier AS/*= AS_none*/, 
               type$ptr<Decl /*P*/>/*P*/OwnedType/*= null*/, 
               ParsedAttributes /*P*/ Attrs/*= null*/) {
    DeclSpec DS = null;
    Declarator DeclaratorInfo = null;
    try {
      DeclSpecContext DSC = $this().getDeclSpecContextFromDeclaratorContext(Context.getValue());
      if (DSC == DeclSpecContext.DSC_normal) {
        DSC = DeclSpecContext.DSC_type_specifier;
      }
      
      // Parse the common declaration-specifiers piece.
      DS/*J*/= new DeclSpec($this().AttrFactory);
      if ((Attrs != null)) {
        DS.addAttributes(Attrs.getList());
      }
      $this().ParseSpecifierQualifierList(DS, AS, DSC);
      if ((OwnedType != null)) {
        OwnedType.$set(DS.isTypeSpecOwned() ? DS.getRepAsDecl() : null);
      }
      
      // Parse the abstract-declarator, if present.
      DeclaratorInfo/*J*/= new Declarator(DS, Context);
      $this().ParseDeclarator(DeclaratorInfo);
      if ((Range != null)) {
        /*Deref*/Range.$assignMove(DeclaratorInfo.getSourceRange());
      }
      if (DeclaratorInfo.isInvalidType()) {
        return new ActionResult<OpaquePtr<QualType>>(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
      }
      
      return $this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo);
    } finally {
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
    }
  }


/// DiagnoseProhibitedCXX11Attribute - We have found the opening square brackets
/// of a C++11 attribute-specifier in a location where an attribute is not
/// permitted. By C++11 [dcl.attr.grammar]p6, this is ill-formed. Diagnose this
/// situation.
///
/// \return \c true if we skipped an attribute-like chunk of tokens, \c false if
/// this doesn't appear to actually be an attribute-specifier, and the caller
/// should try to parse it.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseProhibitedCXX11Attribute">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1360,
   FQN="clang::Parser::DiagnoseProhibitedCXX11Attribute", NM="_ZN5clang6Parser32DiagnoseProhibitedCXX11AttributeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser32DiagnoseProhibitedCXX11AttributeEv")
  //</editor-fold>
  protected /*private*/ boolean DiagnoseProhibitedCXX11Attribute() {
    assert ($this().Tok.is(tok.TokenKind.l_square) && $this().NextToken().is(tok.TokenKind.l_square));
    switch ($this().isCXX11AttributeSpecifier(/*Disambiguate*/ true)) {
     case CAK_NotAttributeSpecifier:
      // No diagnostic: we're in Obj-C++11 and this is not actually an attribute.
      return false;
     case CAK_InvalidAttributeSpecifier:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_l_square_l_square_not_attribute)));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
     case CAK_AttributeSpecifier:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Parse and discard the attributes.
          SourceLocation BeginLoc = $this().ConsumeBracket();
          $this().ConsumeBracket();
          $this().SkipUntil(tok.TokenKind.r_square);
          assert ($this().Tok.is(tok.TokenKind.r_square)) : "isCXX11AttributeSpecifier lied";
          SourceLocation EndLoc = $this().ConsumeBracket();
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(BeginLoc), diag.err_attributes_not_allowed)), 
              new SourceRange(/*NO_COPY*/BeginLoc, /*NO_COPY*/EndLoc)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    throw new llvm_unreachable("All cases handled above.");
  }


/// \brief We have found the opening square brackets of a C++11
/// attribute-specifier in a location where an attribute is not permitted, but
/// we know where the attributes ought to be written. Parse them anyway, and
/// provide a fixit moving them to the right place.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseMisplacedCXX11Attribute">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1390,
   FQN="clang::Parser::DiagnoseMisplacedCXX11Attribute", NM="_ZN5clang6Parser31DiagnoseMisplacedCXX11AttributeERNS0_25ParsedAttributesWithRangeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser31DiagnoseMisplacedCXX11AttributeERNS0_25ParsedAttributesWithRangeENS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void DiagnoseMisplacedCXX11Attribute(final ParsedAttributesWithRange /*&*/ Attrs, 
                                 SourceLocation CorrectLocation) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (($this().Tok.is(tok.TokenKind.l_square) && $this().NextToken().is(tok.TokenKind.l_square)) || $this().Tok.is(tok.TokenKind.kw_alignas));
      
      // Consume the attributes.
      SourceLocation Loc = $this().Tok.getLocation();
      $this().ParseCXX11Attributes(Attrs);
      CharSourceRange AttrRange/*J*/= new CharSourceRange(new SourceRange(/*NO_COPY*/Loc, Attrs.Range.getEnd()), true);
      
      $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_attributes_not_allowed)), 
              FixItHint.CreateInsertionFromRange(/*NO_COPY*/CorrectLocation, /*NO_COPY*/AttrRange)), 
          FixItHint.CreateRemoval(/*NO_COPY*/AttrRange)));
    } finally {
      $c$.$destroy();
    }
  }


// As an exception to the rule, __declspec(align(...)) before the
// class-key affects the type instead of the variable.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::handleDeclspecAlignBeforeClassKey">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1424,
   FQN="clang::Parser::handleDeclspecAlignBeforeClassKey", NM="_ZN5clang6Parser33handleDeclspecAlignBeforeClassKeyERNS0_25ParsedAttributesWithRangeERNS_8DeclSpecENS_4Sema10TagUseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser33handleDeclspecAlignBeforeClassKeyERNS0_25ParsedAttributesWithRangeERNS_8DeclSpecENS_4Sema10TagUseKindE")
  //</editor-fold>
  protected /*private*/ void handleDeclspecAlignBeforeClassKey(final ParsedAttributesWithRange /*&*/ Attrs, 
                                   final DeclSpec /*&*/ DS, 
                                   Sema.TagUseKind TUK) {
    if (TUK == Sema.TagUseKind.TUK_Reference) {
      return;
    }
    
    final ParsedAttributes /*&*/ PA = DS.getAttributes();
    AttributeList /*P*/ AL = PA.getList();
    AttributeList /*P*/ Prev = null;
    while ((AL != null)) {
      AttributeList /*P*/ Next = AL.getNext();
      
      // We only consider attributes using the appropriate '__declspec' spelling.
      // This behavior doesn't extend to any other spellings.
      if (AL.getKind() == AttributeList.Kind.AT_Aligned
         && AL.isDeclspecAttribute()) {
        // Stitch the attribute into the tag's attribute list.
        AL.setNext((AttributeList /*P*/ )null);
        Attrs.add(AL);
        
        // Remove the attribute from the variable's attribute list.
        if ((Prev != null)) {
          // Set the last variable attribute's next attribute to be the attribute
          // after the current one.
          Prev.setNext(Next);
        } else {
          // Removing the head of the list requires us to reset the head to the
          // next attribute.
          PA.set(Next);
        }
      } else {
        Prev = AL;
      }
      
      AL = Next;
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseProhibitedAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1405,
   FQN="clang::Parser::DiagnoseProhibitedAttributes", NM="_ZN5clang6Parser28DiagnoseProhibitedAttributesERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser28DiagnoseProhibitedAttributesERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ void DiagnoseProhibitedAttributes(final ParsedAttributesWithRange /*&*/ attrs) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(attrs.Range.getBegin(), diag.err_attributes_not_allowed)), 
          /*NO_COPY*/attrs.Range));
    } finally {
      $c$.$destroy();
    }
  }


// Forbid C++11 attributes that appear on certain syntactic 
// locations which standard permits but we don't supported yet, 
// for example, attributes appertain to decl specifiers.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ProhibitCXX11Attributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1410,
   FQN="clang::Parser::ProhibitCXX11Attributes", NM="_ZN5clang6Parser23ProhibitCXX11AttributesERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser23ProhibitCXX11AttributesERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ void ProhibitCXX11Attributes(final ParsedAttributesWithRange /*&*/ attrs) {
    AttributeList /*P*/ AttrList = attrs.getList();
    while ((AttrList != null)) {
      if (AttrList.isCXX11Attribute()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(AttrList.getLoc(), diag.err_attribute_not_type_attr)), 
              AttrList.getName()));
          AttrList.setInvalid();
        } finally {
          $c$.$destroy();
        }
      }
      AttrList = AttrList.getNext();
    }
  }


/// \brief Parses syntax-generic attribute arguments for attributes which are
/// known to the implementation, and adds them to the given ParsedAttributes
/// list with the given attribute syntax. Returns the number of arguments
/// parsed for the attribute.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAttributeArgsCommon">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed EndLoc to final ref*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 271,
   FQN="clang::Parser::ParseAttributeArgsCommon", NM="_ZN5clang6Parser24ParseAttributeArgsCommonEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser24ParseAttributeArgsCommonEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  protected /*private*/ /*uint*/int ParseAttributeArgsCommon(IdentifierInfo /*P*/ AttrName, SourceLocation AttrNameLoc, 
                          final ParsedAttributes /*&*/ Attrs, final SourceLocation /*P*/ EndLoc, IdentifierInfo /*P*/ ScopeName, 
                          SourceLocation ScopeLoc, AttributeList.Syntax Syntax) {
    // Ignore the left paren location for now.
    $this().ConsumeParen();
    
    SmallVector<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >> ArgExprs/*J*/= new SmallVector<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>(12, new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(Expr /*P*/.class));
    if ($this().Tok.is(tok.TokenKind.identifier)) {
      // If this attribute wants an 'identifier' argument, make it so.
      boolean IsIdentifierArg = attributeHasIdentifierArg($Deref(AttrName));
      AttributeList.Kind AttrKind = AttributeList.getKind(AttrName, ScopeName, Syntax);
      
      // If we don't know how to parse this attribute, but this is the only
      // token in this argument, assume it's meant to be an identifier.
      if (AttrKind == AttributeList.Kind.UnknownAttribute
         || AttrKind == AttributeList.Kind.IgnoredAttribute) {
        final /*const*/ Token /*&*/ Next = $this().NextToken();
        IsIdentifierArg = Next.isOneOf(tok.TokenKind.r_paren, tok.TokenKind.comma);
      }
      if (IsIdentifierArg) {
        ArgExprs.push_back(new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(JD$T1.INSTANCE, IdentifierLoc /*P*/ .class, $this().ParseIdentifierLoc()));
      }
    }
    if (!ArgExprs.empty() ? $this().Tok.is(tok.TokenKind.comma) : $this().Tok.isNot(tok.TokenKind.r_paren)) {
      // Eat the comma.
      if (!ArgExprs.empty()) {
        $this().ConsumeToken();
      }
      
      // Parse the non-empty comma-separated list of expressions.
      do {
        std.unique_ptr<EnterExpressionEvaluationContext> Unevaluated = null;
        try {
          Unevaluated/*J*/= new std.unique_ptr<EnterExpressionEvaluationContext>();
          if (attributeParsedArgsUnevaluated($Deref(AttrName))) {
            Unevaluated.reset(new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated));
          }
          
          ActionResultTTrue<Expr /*P*/ > ArgExpr/*J*/= $this().Actions.CorrectDelayedTyposInExpr($this().ParseAssignmentExpression());
          if (ArgExpr.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return 0;
          }
          ArgExprs.push_back(new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(JD$T.INSTANCE, Expr /*P*/ .class, ArgExpr.get()));
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
        // Eat the comma, move to the next argument
      } while ($this().TryConsumeToken(tok.TokenKind.comma));
    }
    
    SourceLocation RParen = $this().Tok.getLocation();
    if (!$this().ExpectAndConsume(tok.TokenKind.r_paren)) {
      SourceLocation AttrLoc = new SourceLocation(ScopeLoc.isValid() ? ScopeLoc : AttrNameLoc);
      Attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrLoc, /*NO_COPY*/RParen), ScopeName, new SourceLocation(ScopeLoc), 
          ArgExprs.data(), ArgExprs.size(), Syntax);
    }
    if ((EndLoc != null)) {
      EndLoc.$assign(RParen);
    }
    
    return ((/*static_cast*//*uint*/int)(ArgExprs.size()));
  }


/// ParseGNUAttributes - Parse a non-empty attributes list.
///
/// [GNU] attributes:
///         attribute
///         attributes attribute
///
/// [GNU]  attribute:
///          '__attribute__' '(' '(' attribute-list ')' ')'
///
/// [GNU]  attribute-list:
///          attrib
///          attribute_list ',' attrib
///
/// [GNU]  attrib:
///          empty
///          attrib-name
///          attrib-name '(' identifier ')'
///          attrib-name '(' identifier ',' nonempty-expr-list ')'
///          attrib-name '(' argument-expression-list [C99 6.5.2] ')'
///
/// [GNU]  attrib-name:
///          identifier
///          typespec
///          typequal
///          storageclass
///
/// Whether an attribute takes an 'identifier' is determined by the
/// attrib-name. GCC's behavior here is not worth imitating:
///
///  * In C mode, if the attribute argument list starts with an identifier
///    followed by a ',' or an ')', and the identifier doesn't resolve to
///    a type, it is parsed as an identifier. If the attribute actually
///    wanted an expression, it's out of luck (but it turns out that no
///    attributes work that way, because C constant expressions are very
///    limited).
///  * In C++ mode, if the attribute argument list starts with an identifier,
///    and the attribute *wants* an identifier, it is parsed as an identifier.
///    At block scope, any additional tokens between the identifier and the
///    ',' or ')' are ignored, otherwise they produce a parse error.
///
/// We follow the C++ model, but don't allow junk after the identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseGNUAttributes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 124,
   FQN="clang::Parser::ParseGNUAttributes", NM="_ZN5clang6Parser18ParseGNUAttributesERNS_16ParsedAttributesEPNS_14SourceLocationEPNS0_18LateParsedAttrListEPNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser18ParseGNUAttributesERNS_16ParsedAttributesEPNS_14SourceLocationEPNS0_18LateParsedAttrListEPNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseGNUAttributes(final ParsedAttributes /*&*/ attrs) {
    $this().ParseGNUAttributes(attrs, 
                    (SourceLocation /*P*/ )null, 
                    (LateParsedAttrList /*P*/ )null, 
                    (Declarator /*P*/ )null);
  }
  protected /*private*/ void ParseGNUAttributes(final ParsedAttributes /*&*/ attrs, 
                    final SourceLocation /*P*/ endLoc/*= null*/) {
    $this().ParseGNUAttributes(attrs, 
                    endLoc, 
                    (LateParsedAttrList /*P*/ )null, 
                    (Declarator /*P*/ )null);
  }
  protected /*private*/ void ParseGNUAttributes(final ParsedAttributes /*&*/ attrs, 
                    final SourceLocation /*P*/ endLoc/*= null*/, 
                    LateParsedAttrList /*P*/ LateAttrs/*= null*/) {
    $this().ParseGNUAttributes(attrs, 
                    endLoc, 
                    LateAttrs, 
                    (Declarator /*P*/ )null);
  }
  protected /*private*/ void ParseGNUAttributes(final ParsedAttributes /*&*/ attrs, 
                    final SourceLocation /*P*/ endLoc/*= null*/, 
                    LateParsedAttrList /*P*/ LateAttrs/*= null*/, 
                    Declarator /*P*/ D/*= null*/) {
    assert ($this().Tok.is(tok.TokenKind.kw___attribute)) : "Not a GNU attribute list!";
    while ($this().Tok.is(tok.TokenKind.kw___attribute)) {
      $this().ConsumeToken();
      if ($this().ExpectAndConsume(tok.TokenKind.l_paren, diag.err_expected_lparen_after, 
          new StringRef(/*KEEP_STR*/"attribute"))) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi); // skip until ) or ;
        return;
      }
      if ($this().ExpectAndConsume(tok.TokenKind.l_paren, diag.err_expected_lparen_after, new StringRef(/*KEEP_STR*/$LPAREN))) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi); // skip until ) or ;
        return;
      }
      // Parse the attribute-list. e.g. __attribute__(( weak, alias("__f") ))
      while (true) {
        // Allow empty/non-empty attributes. ((__vector_size__(16),,,,))
        if ($this().TryConsumeToken(tok.TokenKind.comma)) {
          continue;
        }
        
        // Expect an identifier or declaration specifier (const, int, etc.)
        if ($this().Tok.isAnnotation()) {
          break;
        }
        IdentifierInfo /*P*/ AttrName = $this().Tok.getIdentifierInfo();
        if (!(AttrName != null)) {
          break;
        }
        
        SourceLocation AttrNameLoc = $this().ConsumeToken();
        if ($this().Tok.isNot(tok.TokenKind.l_paren)) {
          attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, 
              AttributeList.Syntax.AS_GNU);
          continue;
        }
        
        // Handle "parameterized" attributes
        if (!(LateAttrs != null) || !isAttributeLateParsed($Deref(AttrName))) {
          $this().ParseGNUAttributeArgs(AttrName, new SourceLocation(AttrNameLoc), attrs, endLoc, (IdentifierInfo /*P*/ )null, 
              new SourceLocation(), AttributeList.Syntax.AS_GNU, D);
          continue;
        }
        
        // Handle attributes with arguments that require late parsing.
        LateParsedAttribute /*P*/ LA = new LateParsedAttribute($this(), $Deref(AttrName), new SourceLocation(AttrNameLoc));
        LateAttrs.push_back(LA);
        
        // Attributes in a class are parsed at the end of the class, along
        // with other late-parsed declarations.
        if (!$this().ClassStack.empty() && !LateAttrs.parseSoon()) {
          $this().getCurrentClass().LateParsedDeclarations.push_back(LA);
        }
        
        // consume everything up to and including the matching right parens
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_paren, LA.Toks, true, false);
        
        Token Eof/*J*/= new Token();
        Eof.startToken();
        Eof.setLocation($this().Tok.getLocation());
        LA.Toks.push_back(Eof);
      }
      if ($this().ExpectAndConsume(tok.TokenKind.r_paren)) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
      }
      SourceLocation Loc = $this().Tok.getLocation();
      if ($this().ExpectAndConsume(tok.TokenKind.r_paren)) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
      }
      if ((endLoc != null)) {
        endLoc.$assign(Loc);
      }
    }
  }


/// Parse the arguments to a parameterized GNU attribute or
/// a C++11 attribute in "gnu" namespace.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseGNUAttributeArgs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed EndLoc to final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 335,
   FQN="clang::Parser::ParseGNUAttributeArgs", NM="_ZN5clang6Parser21ParseGNUAttributeArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_NS_13AttributeList6SyntaxEPNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser21ParseGNUAttributeArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_NS_13AttributeList6SyntaxEPNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseGNUAttributeArgs(IdentifierInfo /*P*/ AttrName, 
                       SourceLocation AttrNameLoc, 
                       final ParsedAttributes /*&*/ Attrs, 
                       final SourceLocation /*P*/ EndLoc, 
                       IdentifierInfo /*P*/ ScopeName, 
                       SourceLocation ScopeLoc, 
                       AttributeList.Syntax Syntax, 
                       Declarator /*P*/ D) {
    std.unique_ptr<ParseScope> PrototypeScope = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.l_paren)) : "Attribute arg list not starting with '('";
      
      AttributeList.Kind AttrKind = AttributeList.getKind(AttrName, ScopeName, Syntax);
      if (AttrKind == AttributeList.Kind.AT_Availability) {
        $this().ParseAvailabilityAttribute($Deref(AttrName), new SourceLocation(AttrNameLoc), Attrs, EndLoc, ScopeName, 
            new SourceLocation(ScopeLoc), Syntax);
        return;
      } else if (AttrKind == AttributeList.Kind.AT_ObjCBridgeRelated) {
        $this().ParseObjCBridgeRelatedAttribute($Deref(AttrName), new SourceLocation(AttrNameLoc), Attrs, EndLoc, 
            ScopeName, new SourceLocation(ScopeLoc), Syntax);
        return;
      } else if (AttrKind == AttributeList.Kind.AT_TypeTagForDatatype) {
        $this().ParseTypeTagForDatatypeAttribute($Deref(AttrName), new SourceLocation(AttrNameLoc), Attrs, EndLoc, 
            ScopeName, new SourceLocation(ScopeLoc), Syntax);
        return;
      } else if (attributeIsTypeArgAttr($Deref(AttrName))) {
        $this().ParseAttributeWithTypeArg($Deref(AttrName), new SourceLocation(AttrNameLoc), Attrs, EndLoc, ScopeName, 
            new SourceLocation(ScopeLoc), Syntax);
        return;
      }
      
      // These may refer to the function arguments, but need to be parsed early to
      // participate in determining whether it's a redeclaration.
      PrototypeScope/*J*/= new std.unique_ptr<ParseScope>();
      if ($eq_StringRef(normalizeAttrName(AttrName.getName()), /*STRINGREF_STR*/"enable_if")
         && (D != null) && D.isFunctionDeclarator()) {
        DeclaratorChunk.FunctionTypeInfo FTI = new DeclaratorChunk.FunctionTypeInfo(D.getFunctionTypeInfo());
        PrototypeScope.reset(new ParseScope($this(), Scope.ScopeFlags.FunctionPrototypeScope
                   | Scope.ScopeFlags.FunctionDeclarationScope
                   | Scope.ScopeFlags.DeclScope));
        for (/*uint*/int i = 0; i != FTI.NumParams; ++i) {
          ParmVarDecl /*P*/ Param = cast(ParmVarDecl.class, FTI.Params.$at(i).Param);
          $this().Actions.ActOnReenterCXXMethodParameter($this().getCurScope(), Param);
        }
      }
      
      $this().ParseAttributeArgsCommon(AttrName, new SourceLocation(AttrNameLoc), Attrs, EndLoc, ScopeName, 
          new SourceLocation(ScopeLoc), Syntax);
    } finally {
      if (PrototypeScope != null) { PrototypeScope.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseIdentifierLoc">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 233,
   FQN="clang::Parser::ParseIdentifierLoc", NM="_ZN5clang6Parser18ParseIdentifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser18ParseIdentifierLocEv")
  //</editor-fold>
  protected /*private*/ IdentifierLoc /*P*/ ParseIdentifierLoc() {
    assert ($this().Tok.is(tok.TokenKind.identifier)) : "expected an identifier";
    IdentifierLoc /*P*/ IL = IdentifierLoc.create($this().Actions.Context, 
        $this().Tok.getLocation(), 
        $this().Tok.getIdentifierInfo());
    $this().ConsumeToken();
    return IL;
  }


/// [MS] decl-specifier:
///             __declspec ( extended-decl-modifier-seq )
///
/// [MS] extended-decl-modifier-seq:
///             extended-decl-modifier[opt]
///             extended-decl-modifier extended-decl-modifier-seq
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftDeclSpecs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   optimized = Converted.Optimization.VALUE_TYPE,     
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 535,
   FQN="clang::Parser::ParseMicrosoftDeclSpecs", NM="_ZN5clang6Parser23ParseMicrosoftDeclSpecsERNS_16ParsedAttributesEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser23ParseMicrosoftDeclSpecsERNS_16ParsedAttributesEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseMicrosoftDeclSpecs(final ParsedAttributes /*&*/ Attrs) {
    $this().ParseMicrosoftDeclSpecs(Attrs, 
                         (SourceLocation /*P*/ )null);
  }
  protected /*private*/ void ParseMicrosoftDeclSpecs(final ParsedAttributes /*&*/ Attrs, 
                         final SourceLocation /*P*/ End/*= null*/) {
    assert ($this().getLangOpts().DeclSpecKeyword) : "__declspec keyword is not enabled";
    assert ($this().Tok.is(tok.TokenKind.kw___declspec)) : "Not a declspec!";
    while ($this().Tok.is(tok.TokenKind.kw___declspec)) {
      BalancedDelimiterTracker T = null;
      try {
        $this().ConsumeToken();
        T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
        if (T.expectAndConsume(diag.err_expected_lparen_after, $__declspec, 
            tok.TokenKind.r_paren)) {
          return;
        }
        
        // An empty declspec is perfectly legal and should not warn.  Additionally,
        // you can specify multiple attributes per declspec.
        while ($this().Tok.isNot(tok.TokenKind.r_paren)) {
          // Attribute not present.
          if ($this().TryConsumeToken(tok.TokenKind.comma)) {
            continue;
          }
          
          // We expect either a well-known identifier or a generic string.  Anything
          // else is a malformed declspec.
          boolean IsString = $this().Tok.getKind() == tok.TokenKind.string_literal;
          if (!IsString && $this().Tok.getKind() != tok.TokenKind.identifier
             && $this().Tok.getKind() != tok.TokenKind.kw_restrict) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_ms_declspec_type)));
              T.skipToEnd();
              return;
            } finally {
              $c$.$destroy();
            }
          }
          
          IdentifierInfo /*P*/ AttrName;
          SourceLocation AttrNameLoc/*J*/= new SourceLocation();
          if (IsString) {
            SmallString/*8*/ StrBuffer/*J*/= new SmallString/*8*/(8);
            bool$ptr Invalid = create_bool$ptr(false);
            StringRef Str = $this().PP.getSpelling($this().Tok, StrBuffer, $AddrOf(Invalid));
            if (Invalid.$star()) {
              T.skipToEnd();
              return;
            }
            /*JAVA: PERF*/char$ptr $data = Str.data();
            AttrName = $this().PP.getIdentifierInfo($data.$array(), $data.$index(), Str.size());
            AttrNameLoc.$assignMove($this().ConsumeStringToken());
          } else {
            AttrName = $this().Tok.getIdentifierInfo();
            AttrNameLoc.$assignMove($this().ConsumeToken());
          }
          
          boolean AttrHandled = false;
          
          // Parse attribute arguments.
          if ($this().Tok.is(tok.TokenKind.l_paren)) {
            AttrHandled = $this().ParseMicrosoftDeclSpecArgs(AttrName, new SourceLocation(AttrNameLoc), Attrs);
          } else if ($eq_StringRef(AttrName.getName(), /*STRINGREF_STR*/"property")) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // The property attribute must have an argument list.
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_lparen_after)), 
                  AttrName.getName()));
            } finally {
              $c$.$destroy();
            }
          }
          if (!AttrHandled) {
            Attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, 
                AttributeList.Syntax.AS_Declspec);
          }
        }
        T.consumeClose();
        if ((End != null)) {
          End.$assignMove(T.getCloseLocation());
        }
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftDeclSpecArgs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*GO TO && Default init value for AccessorKind Kind*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 386,
   FQN="clang::Parser::ParseMicrosoftDeclSpecArgs", NM="_ZN5clang6Parser26ParseMicrosoftDeclSpecArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser26ParseMicrosoftDeclSpecArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ boolean ParseMicrosoftDeclSpecArgs(IdentifierInfo /*P*/ AttrName, 
                            SourceLocation AttrNameLoc, 
                            final ParsedAttributes /*&*/ Attrs) {
    // If the attribute isn't known, we will not attempt to parse any
    // arguments.
    if (!(hasAttribute(AttrSyntax.Declspec, (/*const*/ IdentifierInfo /*P*/ )null, AttrName, 
        $this().getTargetInfo(), $this().getLangOpts()) != 0)) {
      // Eat the left paren, then skip to the ending right paren.
      $this().ConsumeParen();
      $this().SkipUntil(tok.TokenKind.r_paren);
      return false;
    }
    
    SourceLocation OpenParenLoc = $this().Tok.getLocation();
    if ($eq_StringRef(AttrName.getName(), /*STRINGREF_STR*/"property")) {
      BalancedDelimiterTracker T = null;
      try {
        // The property declspec is more complex in that it can take one or two
        // assignment expressions as a parameter, but the lhs of the assignment
        // must be named get or put.
        T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
        T.expectAndConsume(diag.err_expected_lparen_after, 
            AttrName.getNameStart(), tok.TokenKind.r_paren);
        
        //<editor-fold defaultstate="collapsed" desc="AccessorKind">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 410,
         FQN="AccessorKind", NM="_ZZN5clang6Parser26ParseMicrosoftDeclSpecArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEE12AccessorKind",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZZN5clang6Parser26ParseMicrosoftDeclSpecArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEE12AccessorKind")
        //</editor-fold>
        final class/*enum*/ AccessorKind {
          private static final int AK_Invalid = -1;
          private static final int AK_Put = 0;
          private static final int AK_Get = 1; // indices into AccessorNames
        };
        IdentifierInfo /*P*/ AccessorNames[/*2*/] = new IdentifierInfo /*P*/ [/*2*/] {(IdentifierInfo /*P*/ )null, (IdentifierInfo /*P*/ )null};
        boolean HasInvalidAccessor = false;
        
        // Parse the accessor specifications.
        while (true) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Stop if this doesn't look like an accessor spec.
            if (!$this().Tok.is(tok.TokenKind.identifier)) {
              // If the user wrote a completely empty list, use a special diagnostic.
              if ($this().Tok.is(tok.TokenKind.r_paren) && !HasInvalidAccessor
                 && AccessorNames[AccessorKind.AK_Put] == null
                 && AccessorNames[AccessorKind.AK_Get] == null) {
                $c$.clean($c$.track($this().Diag(new SourceLocation(AttrNameLoc), diag.err_ms_property_no_getter_or_putter)));
                break;
              }
              
              $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_ms_property_unknown_accessor)));
              break;
            }
            
            /*AccessorKind*/int Kind = /*JAVA WHICH VALUE TO USE?*/AccessorKind.AK_Invalid;
            SourceLocation KindLoc = $this().Tok.getLocation();
            StringRef KindStr = $this().Tok.getIdentifierInfo().getName();
            boolean $next_property_accessor = false;
            if ($eq_StringRef(/*NO_COPY*/KindStr, /*STRINGREF_STR*/"get")) {
              Kind = AccessorKind.AK_Get;
            } else if ($eq_StringRef(/*NO_COPY*/KindStr, /*STRINGREF_STR*/"put")) {
              Kind = AccessorKind.AK_Put;
              // Recover from the common mistake of using 'set' instead of 'put'.
            } else if ($eq_StringRef(/*NO_COPY*/KindStr, /*STRINGREF_STR*/"set")) {
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(KindLoc), diag.err_ms_property_has_set_accessor)), 
                  FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/KindLoc), new StringRef(/*KEEP_STR*/"put"))));
              Kind = AccessorKind.AK_Put;
              // Handle the mistake of forgetting the accessor kind by skipping
              // this accessor.
            } else if ($this().NextToken().is(tok.TokenKind.comma) || $this().NextToken().is(tok.TokenKind.r_paren)) {
              $c$.clean($c$.track($this().Diag(new SourceLocation(KindLoc), diag.err_ms_property_missing_accessor_kind)));
              $this().ConsumeToken();
              HasInvalidAccessor = true;
              $next_property_accessor = true;// JAVA goto next_property_accessor;
              // Otherwise, complain about the unknown accessor kind.
            } else {
              $c$.clean($c$.track($this().Diag(new SourceLocation(KindLoc), diag.err_ms_property_unknown_accessor)));
              HasInvalidAccessor = true;
              Kind = AccessorKind.AK_Invalid;
              
              // Try to keep parsing unless it doesn't look like an accessor spec.
              if (!$this().NextToken().is(tok.TokenKind.equal)) {
                break;
              }
            }
          if (!$next_property_accessor) {
            // Consume the identifier.
            $this().ConsumeToken();
            
            // Consume the '='.
            if (!$this().TryConsumeToken(tok.TokenKind.equal)) {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok.getLocation(), diag.err_ms_property_expected_equal)), 
                  /*NO_COPY*/KindStr));
              break;
            }
            
            // Expect the method name.
            if (!$this().Tok.is(tok.TokenKind.identifier)) {
              $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_ms_property_expected_accessor_name)));
              break;
            }
            if (Kind == AccessorKind.AK_Invalid) {
              // Just drop invalid accessors.
            } else if (AccessorNames[Kind] != null) {
              // Complain about the repeated accessor, ignore it, and keep parsing.
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag(new SourceLocation(KindLoc), diag.err_ms_property_duplicate_accessor)), /*NO_COPY*/KindStr));
            } else {
              AccessorNames[Kind] = $this().Tok.getIdentifierInfo();
            }
            $this().ConsumeToken();
          }
          /*JAVA: next_property_accessor:*/
            // Keep processing accessors until we run out.
            if ($this().TryConsumeToken(tok.TokenKind.comma)) {
              continue;
            }
            
            // If we run into the ')', stop without consuming it.
            if ($this().Tok.is(tok.TokenKind.r_paren)) {
              break;
            }
            
            $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_ms_property_expected_comma_or_rparen)));
            break;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Only add the property attribute if it was well-formed.
        if (!HasInvalidAccessor) {
          Attrs.addNewPropertyAttr(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(), 
              AccessorNames[AccessorKind.AK_Get], AccessorNames[AccessorKind.AK_Put], 
              AttributeList.Syntax.AS_Declspec);
        }
        T.skipToEnd();
        return !HasInvalidAccessor;
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
    
    /*uint*/int NumArgs = $this().ParseAttributeArgsCommon(AttrName, new SourceLocation(AttrNameLoc), Attrs, (SourceLocation /*P*/ )null, (IdentifierInfo /*P*/ )null, 
        new SourceLocation(), AttributeList.Syntax.AS_Declspec);
    
    // If this attribute's args were parsed, and it was expected to have
    // arguments but none were provided, emit a diagnostic.
    /*const*/ AttributeList /*P*/ Attr = Attrs.getList();
    if ((Attr != null) && (Attr.getMaxArgs() != 0) && !(NumArgs != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(OpenParenLoc), diag.err_attribute_requires_arguments)), AttrName));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftTypeAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 601,
   FQN="clang::Parser::ParseMicrosoftTypeAttributes", NM="_ZN5clang6Parser28ParseMicrosoftTypeAttributesERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser28ParseMicrosoftTypeAttributesERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ void ParseMicrosoftTypeAttributes(final ParsedAttributes /*&*/ attrs) {
    // Treat these like attributes
    while (true) {
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.kw___fastcall:
       case tok.TokenKind.kw___stdcall:
       case tok.TokenKind.kw___thiscall:
       case tok.TokenKind.kw___cdecl:
       case tok.TokenKind.kw___vectorcall:
       case tok.TokenKind.kw___ptr64:
       case tok.TokenKind.kw___w64:
       case tok.TokenKind.kw___ptr32:
       case tok.TokenKind.kw___sptr:
       case tok.TokenKind.kw___uptr:
        {
          IdentifierInfo /*P*/ AttrName = $this().Tok.getIdentifierInfo();
          SourceLocation AttrNameLoc = $this().ConsumeToken();
          attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, 
              AttributeList.Syntax.AS_Keyword);
          break;
        }
       default:
        return;
      }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseAndSkipExtendedMicrosoftTypeAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 627,
   FQN="clang::Parser::DiagnoseAndSkipExtendedMicrosoftTypeAttributes", NM="_ZN5clang6Parser46DiagnoseAndSkipExtendedMicrosoftTypeAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser46DiagnoseAndSkipExtendedMicrosoftTypeAttributesEv")
  //</editor-fold>
  protected /*private*/ void DiagnoseAndSkipExtendedMicrosoftTypeAttributes() {
    SourceLocation StartLoc = $this().Tok.getLocation();
    SourceLocation EndLoc = $this().SkipExtendedMicrosoftTypeAttributes();
    if (EndLoc.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceRange Range/*J*/= new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/EndLoc);
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(StartLoc), diag.warn_microsoft_qualifiers_ignored)), /*NO_COPY*/Range));
      } finally {
        $c$.$destroy();
      }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipExtendedMicrosoftTypeAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 637,
   FQN="clang::Parser::SkipExtendedMicrosoftTypeAttributes", NM="_ZN5clang6Parser35SkipExtendedMicrosoftTypeAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser35SkipExtendedMicrosoftTypeAttributesEv")
  //</editor-fold>
  protected /*private*/ SourceLocation SkipExtendedMicrosoftTypeAttributes() {
    SourceLocation EndLoc/*J*/= new SourceLocation();
    while (true) {
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.kw_const:
       case tok.TokenKind.kw_volatile:
       case tok.TokenKind.kw___fastcall:
       case tok.TokenKind.kw___stdcall:
       case tok.TokenKind.kw___thiscall:
       case tok.TokenKind.kw___cdecl:
       case tok.TokenKind.kw___vectorcall:
       case tok.TokenKind.kw___ptr32:
       case tok.TokenKind.kw___ptr64:
       case tok.TokenKind.kw___w64:
       case tok.TokenKind.kw___unaligned:
       case tok.TokenKind.kw___sptr:
       case tok.TokenKind.kw___uptr:
        EndLoc.$assignMove($this().ConsumeToken());
        break;
       default:
        return EndLoc;
      }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBorlandTypeAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 663,
   FQN="clang::Parser::ParseBorlandTypeAttributes", NM="_ZN5clang6Parser26ParseBorlandTypeAttributesERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser26ParseBorlandTypeAttributesERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ void ParseBorlandTypeAttributes(final ParsedAttributes /*&*/ attrs) {
    // Treat these like attributes
    while ($this().Tok.is(tok.TokenKind.kw___pascal)) {
      IdentifierInfo /*P*/ AttrName = $this().Tok.getIdentifierInfo();
      SourceLocation AttrNameLoc = $this().ConsumeToken();
      attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, 
          AttributeList.Syntax.AS_Keyword);
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenCLKernelAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 673,
   FQN="clang::Parser::ParseOpenCLKernelAttributes", NM="_ZN5clang6Parser27ParseOpenCLKernelAttributesERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser27ParseOpenCLKernelAttributesERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ void ParseOpenCLKernelAttributes(final ParsedAttributes /*&*/ attrs) {
    // Treat these like attributes
    while ($this().Tok.is(tok.TokenKind.kw___kernel)) {
      IdentifierInfo /*P*/ AttrName = $this().Tok.getIdentifierInfo();
      SourceLocation AttrNameLoc = $this().ConsumeToken();
      attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, 
          AttributeList.Syntax.AS_Keyword);
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOpenCLQualifiers">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 683,
   FQN="clang::Parser::ParseOpenCLQualifiers", NM="_ZN5clang6Parser21ParseOpenCLQualifiersERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser21ParseOpenCLQualifiersERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ void ParseOpenCLQualifiers(final ParsedAttributes /*&*/ Attrs) {
    IdentifierInfo /*P*/ AttrName = $this().Tok.getIdentifierInfo();
    SourceLocation AttrNameLoc = $this().Tok.getLocation();
    Attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, 
        AttributeList.Syntax.AS_Keyword);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseNullabilityTypeSpecifiers">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 690,
   FQN="clang::Parser::ParseNullabilityTypeSpecifiers", NM="_ZN5clang6Parser30ParseNullabilityTypeSpecifiersERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser30ParseNullabilityTypeSpecifiersERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ void ParseNullabilityTypeSpecifiers(final ParsedAttributes /*&*/ attrs) {
    // Treat these like attributes, even though they're type specifiers.
    while (true) {
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.kw__Nonnull:
       case tok.TokenKind.kw__Nullable:
       case tok.TokenKind.kw__Null_unspecified:
        {
          IdentifierInfo /*P*/ AttrName = $this().Tok.getIdentifierInfo();
          SourceLocation AttrNameLoc = $this().ConsumeToken();
          if (!$this().getLangOpts().ObjC1) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(AttrNameLoc), diag.ext_nullability)), 
                  AttrName));
            } finally {
              $c$.$destroy();
            }
          }
          attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, 
              AttributeList.Syntax.AS_Keyword);
          break;
        }
       default:
        return;
      }
    }
  }


/// \brief Parse a version number.
///
/// version:
///   simple-integer
///   simple-integer ',' simple-integer
///   simple-integer ',' simple-integer ',' simple-integer
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseVersionTuple">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 722,
   FQN="clang::Parser::ParseVersionTuple", NM="_ZN5clang6Parser17ParseVersionTupleERNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser17ParseVersionTupleERNS_11SourceRangeE")
  //</editor-fold>
  protected /*private*/ VersionTuple ParseVersionTuple(final SourceRange /*&*/ Range) {
    Range.$assignMove(new SourceRange($this().Tok.getLocation(), $this().Tok.getEndLoc()));
    if (!$this().Tok.is(tok.TokenKind.numeric_constant)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_version)));
        $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, 
            $bitor_SkipUntilFlags($bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch), /*KEEP_ENUM*/SkipUntilFlags.StopAtCodeCompletion));
        return new VersionTuple();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Parse the major (and possibly minor and subminor) versions, which
    // are stored in the numeric constant. We utilize a quirk of the
    // lexer, which is that it handles something like 1.2.3 as a single
    // numeric constant, rather than two separate tokens.
    SmallString/*512*/ Buffer/*J*/= new SmallString/*512*/(512);
    Buffer.resize($this().Tok.getLength() + 1);
    /*const*/char$ptr/*char P*/ ThisTokBegin = $tryClone($AddrOf(Buffer.data()));
    
    // Get the spelling of the token, which eliminates trigraphs, etc.
    bool$ptr Invalid = create_bool$ptr(false);
    /*uint*/int ActualLength = $this().PP.getSpelling($this().Tok, ThisTokBegin, $AddrOf(Invalid));
    if (Invalid.$star()) {
      return new VersionTuple();
    }
    
    // Parse the major version.
    /*uint*/int AfterMajor = 0;
    /*uint*/int Major = 0;
    while ($less_uint(AfterMajor, ActualLength) && isDigit(ThisTokBegin.$at(AfterMajor))) {
      Major = Major * 10 + $char2uint(ThisTokBegin.$at(AfterMajor)) - $$0;
      ++AfterMajor;
    }
    if (AfterMajor == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_version)));
        $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, 
            $bitor_SkipUntilFlags($bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch), /*KEEP_ENUM*/SkipUntilFlags.StopAtCodeCompletion));
        return new VersionTuple();
      } finally {
        $c$.$destroy();
      }
    }
    if (AfterMajor == ActualLength) {
      $this().ConsumeToken();
      
      // We only had a single version component.
      if (Major == 0) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_zero_version)));
          return new VersionTuple();
        } finally {
          $c$.$destroy();
        }
      }
      
      return new VersionTuple(Major);
    }
    
    /*const*//*char*/byte AfterMajorSeparator = ThisTokBegin.$at(AfterMajor);
    if (!VersionNumberSeparator(AfterMajorSeparator)
       || (AfterMajor + 1 == ActualLength)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_version)));
        $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, 
            $bitor_SkipUntilFlags($bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch), /*KEEP_ENUM*/SkipUntilFlags.StopAtCodeCompletion));
        return new VersionTuple();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Parse the minor version.
    /*uint*/int AfterMinor = AfterMajor + 1;
    /*uint*/int Minor = 0;
    while ($less_uint(AfterMinor, ActualLength) && isDigit(ThisTokBegin.$at(AfterMinor))) {
      Minor = Minor * 10 + $char2uint(ThisTokBegin.$at(AfterMinor)) - $$0;
      ++AfterMinor;
    }
    if (AfterMinor == ActualLength) {
      $this().ConsumeToken();
      
      // We had major.minor.
      if (Major == 0 && Minor == 0) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_zero_version)));
          return new VersionTuple();
        } finally {
          $c$.$destroy();
        }
      }
      
      return new VersionTuple(Major, Minor, (AfterMajorSeparator == $$UNDERSCORE));
    }
    
    /*const*//*char*/byte AfterMinorSeparator = ThisTokBegin.$at(AfterMinor);
    // If what follows is not a '.' or '_', we have a problem.
    if (!VersionNumberSeparator(AfterMinorSeparator)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_version)));
        $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, 
            $bitor_SkipUntilFlags($bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch), /*KEEP_ENUM*/SkipUntilFlags.StopAtCodeCompletion));
        return new VersionTuple();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Warn if separators, be it '.' or '_', do not match.
    if (AfterMajorSeparator != AfterMinorSeparator) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_expected_consistent_version_separator)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Parse the subminor version.
    /*uint*/int AfterSubminor = AfterMinor + 1;
    /*uint*/int Subminor = 0;
    while ($less_uint(AfterSubminor, ActualLength) && isDigit(ThisTokBegin.$at(AfterSubminor))) {
      Subminor = Subminor * 10 + $char2uint(ThisTokBegin.$at(AfterSubminor)) - $$0;
      ++AfterSubminor;
    }
    if (AfterSubminor != ActualLength) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_version)));
        $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, 
            $bitor_SkipUntilFlags($bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch), /*KEEP_ENUM*/SkipUntilFlags.StopAtCodeCompletion));
        return new VersionTuple();
      } finally {
        $c$.$destroy();
      }
    }
    $this().ConsumeToken();
    return new VersionTuple(Major, Minor, Subminor, (AfterMajorSeparator == $$UNDERSCORE));
  }


/// \brief Parse the contents of the "availability" attribute.
///
/// availability-attribute:
///   'availability' '(' platform ',' opt-strict version-arg-list,
///                      opt-replacement, opt-message')'
///
/// platform:
///   identifier
///
/// opt-strict:
///   'strict' ','
///
/// version-arg-list:
///   version-arg
///   version-arg ',' version-arg-list
///
/// version-arg:
///   'introduced' '=' version
///   'deprecated' '=' version
///   'obsoleted' = version
///   'unavailable'
/// opt-replacement:
///   'replacement' '=' <string>
/// opt-message:
///   'message' '=' <string>
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAvailabilityAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed EndLoc to final ref*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 858,
   FQN="clang::Parser::ParseAvailabilityAttribute", NM="_ZN5clang6Parser26ParseAvailabilityAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser26ParseAvailabilityAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  protected /*private*/ void ParseAvailabilityAttribute(final IdentifierInfo /*&*/ Availability, 
                            SourceLocation AvailabilityLoc, 
                            final ParsedAttributes /*&*/ attrs, 
                            final SourceLocation /*P*/ endLoc, 
                            IdentifierInfo /*P*/ ScopeName, 
                            SourceLocation ScopeLoc, 
                            AttributeList.Syntax Syntax) {
    BalancedDelimiterTracker T = null;
    try {
//      //<editor-fold defaultstate="collapsed" desc="">
//      @Converted(kind = Converted.Kind.AUTO,
//       source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 865,
//       FQN="", NM="_ZN5clang6Parser26ParseAvailabilityAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE_Unnamed_enum",
//       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser26ParseAvailabilityAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE_Unnamed_enum")
//      //</editor-fold>
      /*enum ANONYMOUS_INT_CONSTANTS {*/
        final /*uint*/int Introduced = 0;
        final /*uint*/int Deprecated = Introduced + 1;
        final /*uint*/int Obsoleted = Deprecated + 1;
        final /*uint*/int Unknown = Obsoleted + 1;
      /*}*/;
      AvailabilityChange Changes[/*3*/]/*J*/= new$T(new AvailabilityChange [3], ()->new AvailabilityChange());
      ActionResultTTrue<Expr /*P*/ > MessageExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >(), ReplacementExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      
      // Opening '('.
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_paren));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse the platform name.
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_availability_expected_platform)));
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return;
        } finally {
          $c$.$destroy();
        }
      }
      IdentifierLoc /*P*/ Platform = $this().ParseIdentifierLoc();
      // Canonicalize platform name from "macosx" to "macos".
      if ((Platform.Ident != null) && $eq_StringRef(Platform.Ident.getName(), /*STRINGREF_STR*/"macosx")) {
        Platform.Ident = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"macos"));
      }
      // Canonicalize platform name from "macosx_app_extension" to
      // "macos_app_extension".
      if ((Platform.Ident != null) && $eq_StringRef(Platform.Ident.getName(), /*STRINGREF_STR*/"macosx_app_extension")) {
        Platform.Ident = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"macos_app_extension"));
      }
      
      // Parse the ',' following the platform name.
      if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        return;
      }
      
      // If we haven't grabbed the pointers for the identifiers
      // "introduced", "deprecated", and "obsoleted", do so now.
      if (!($this().Ident_introduced != null)) {
        $this().Ident_introduced = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"introduced"));
        $this().Ident_deprecated = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"deprecated"));
        $this().Ident_obsoleted = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"obsoleted"));
        $this().Ident_unavailable = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"unavailable"));
        $this().Ident_message = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"message"));
        $this().Ident_strict = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"strict"));
        $this().Ident_replacement = $this().PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"replacement"));
      }
      
      // Parse the optional "strict", the optional "replacement" and the set of
      // introductions/deprecations/removals.
      SourceLocation UnavailableLoc/*J*/= new SourceLocation(), StrictLoc/*J*/= new SourceLocation();
      do {
        if ($this().Tok.isNot(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_availability_expected_change)));
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return;
          } finally {
            $c$.$destroy();
          }
        }
        IdentifierInfo /*P*/ Keyword = $this().Tok.getIdentifierInfo();
        SourceLocation KeywordLoc = $this().ConsumeToken();
        if (Keyword == $this().Ident_strict) {
          if (StrictLoc.isValid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(KeywordLoc), diag.err_availability_redundant)), 
                      Keyword), new SourceRange(/*NO_COPY*/StrictLoc)));
            } finally {
              $c$.$destroy();
            }
          }
          StrictLoc.$assign(KeywordLoc);
          continue;
        }
        if (Keyword == $this().Ident_unavailable) {
          if (UnavailableLoc.isValid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(KeywordLoc), diag.err_availability_redundant)), 
                      Keyword), new SourceRange(/*NO_COPY*/UnavailableLoc)));
            } finally {
              $c$.$destroy();
            }
          }
          UnavailableLoc.$assign(KeywordLoc);
          continue;
        }
        if ($this().Tok.isNot(tok.TokenKind.equal)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().Tok, diag.err_expected_after)), Keyword), tok.TokenKind.equal));
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return;
          } finally {
            $c$.$destroy();
          }
        }
        $this().ConsumeToken();
        if (Keyword == $this().Ident_message || Keyword == $this().Ident_replacement) {
          if ($this().Tok.isNot(tok.TokenKind.string_literal)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_expected_string_literal)), 
                  /*Source='availability attribute'*/ 2));
              $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
              return;
            } finally {
              $c$.$destroy();
            }
          }
          if (Keyword == $this().Ident_message) {
            MessageExpr.$assignMove($this().ParseStringLiteralExpression());
          } else {
            ReplacementExpr.$assignMove($this().ParseStringLiteralExpression());
          }
          {
            // Also reject wide string literals.
            StringLiteral /*P*/ MessageStringLiteral = cast_or_null(StringLiteral.class, MessageExpr.get());
            if ((MessageStringLiteral != null)) {
              if (MessageStringLiteral.getCharByteWidth() != 1) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag(MessageStringLiteral.getSourceRange().getBegin(), 
                          diag.err_expected_string_literal)), 
                      /*Source='availability attribute'*/ 2));
                  $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
                  return;
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
          if (Keyword == $this().Ident_message) {
            break;
          } else {
            continue;
          }
        }
        
        // Special handling of 'NA' only when applied to introduced or
        // deprecated.
        if ((Keyword == $this().Ident_introduced || Keyword == $this().Ident_deprecated)
           && $this().Tok.is(tok.TokenKind.identifier)) {
          IdentifierInfo /*P*/ NA = $this().Tok.getIdentifierInfo();
          if ($eq_StringRef(NA.getName(), /*STRINGREF_STR*/"NA")) {
            $this().ConsumeToken();
            if (Keyword == $this().Ident_introduced) {
              UnavailableLoc.$assign(KeywordLoc);
            }
            continue;
          }
        }
        
        SourceRange VersionRange/*J*/= new SourceRange();
        VersionTuple Version = $this().ParseVersionTuple(VersionRange);
        if (Version.empty()) {
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return;
        }
        
        /*uint*/int Index;
        if (Keyword == $this().Ident_introduced) {
          Index = Introduced;
        } else if (Keyword == $this().Ident_deprecated) {
          Index = Deprecated;
        } else if (Keyword == $this().Ident_obsoleted) {
          Index = Obsoleted;
        } else {
          Index = Unknown;
        }
        if ($less_uint(Index, Unknown)) {
          if (!Changes[Index].KeywordLoc.isInvalid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(KeywordLoc), diag.err_availability_redundant)), 
                      Keyword), 
                  new SourceRange(/*NO_COPY*/Changes[Index].KeywordLoc, 
                      Changes[Index].VersionRange.getEnd())));
            } finally {
              $c$.$destroy();
            }
          }
          
          Changes[Index].KeywordLoc.$assign(KeywordLoc);
          Changes[Index].Version.$assign(Version);
          Changes[Index].VersionRange.$assign(VersionRange);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(KeywordLoc), diag.err_availability_unknown_change)), 
                    Keyword), /*NO_COPY*/VersionRange));
          } finally {
            $c$.$destroy();
          }
        }
      } while ($this().TryConsumeToken(tok.TokenKind.comma));
      
      // Closing ')'.
      if (T.consumeClose()) {
        return;
      }
      if ((endLoc != null)) {
        endLoc.$assignMove(T.getCloseLocation());
      }
      
      // The 'unavailable' availability cannot be combined with any other
      // availability changes. Make sure that hasn't happened.
      if (UnavailableLoc.isValid()) {
        boolean Complained = false;
        for (/*uint*/int Index = Introduced; Index != Unknown; ++Index) {
          if (Changes[Index].KeywordLoc.isValid()) {
            if (!Complained) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(UnavailableLoc), diag.warn_availability_and_unavailable)), 
                    new SourceRange(/*NO_COPY*/Changes[Index].KeywordLoc, 
                        Changes[Index].VersionRange.getEnd())));
                Complained = true;
              } finally {
                $c$.$destroy();
              }
            }
            
            // Clear out the availability.
            Changes[Index].$assignMove(new AvailabilityChange());
          }
        }
      }
      
      // Record this attribute
      attrs.addNew($AddrOf(Availability), 
          new SourceRange(/*NO_COPY*/AvailabilityLoc, T.getCloseLocation()), 
          ScopeName, new SourceLocation(ScopeLoc), 
          Platform, 
          Changes[Introduced], 
          Changes[Deprecated], 
          Changes[Obsoleted], 
          new SourceLocation(UnavailableLoc), MessageExpr.get(), 
          Syntax, new SourceLocation(StrictLoc), ReplacementExpr.get());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// \brief Parse the contents of the "objc_bridge_related" attribute.
/// objc_bridge_related '(' related_class ',' opt-class_method ',' opt-instance_method ')'
/// related_class:
///     Identifier
///
/// opt-class_method:
///     Identifier: | <empty>
///
/// opt-instance_method:
///     Identifier | <empty>
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseObjCBridgeRelatedAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed EndLoc to final ref*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1071,
   FQN="clang::Parser::ParseObjCBridgeRelatedAttribute", NM="_ZN5clang6Parser31ParseObjCBridgeRelatedAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser31ParseObjCBridgeRelatedAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  protected /*private*/ void ParseObjCBridgeRelatedAttribute(final IdentifierInfo /*&*/ ObjCBridgeRelated, 
                                 SourceLocation ObjCBridgeRelatedLoc, 
                                 final ParsedAttributes /*&*/ attrs, 
                                 final SourceLocation /*P*/ endLoc, 
                                 IdentifierInfo /*P*/ ScopeName, 
                                 SourceLocation ScopeLoc, 
                                 AttributeList.Syntax Syntax) {
    BalancedDelimiterTracker T = null;
    try {
      // Opening '('.
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_paren));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse the related class name.
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objcbridge_related_expected_related_class)));
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return;
        } finally {
          $c$.$destroy();
        }
      }
      IdentifierLoc /*P*/ RelatedClass = $this().ParseIdentifierLoc();
      if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        return;
      }
      
      // Parse optional class method name.
      IdentifierLoc /*P*/ ClassMethod = null;
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        ClassMethod = $this().ParseIdentifierLoc();
        if (!$this().TryConsumeToken(tok.TokenKind.colon)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objcbridge_related_selector_name)));
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
        if ($this().Tok.is(tok.TokenKind.colon)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_objcbridge_related_selector_name)));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.comma));
          } finally {
            $c$.$destroy();
          }
        }
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        return;
      }
      
      // Parse optional instance method name.
      IdentifierLoc /*P*/ InstanceMethod = null;
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        InstanceMethod = $this().ParseIdentifierLoc();
      } else if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.r_paren));
          $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Closing ')'.
      if (T.consumeClose()) {
        return;
      }
      if ((endLoc != null)) {
        endLoc.$assignMove(T.getCloseLocation());
      }
      
      // Record this attribute
      attrs.addNew($AddrOf(ObjCBridgeRelated), 
          new SourceRange(/*NO_COPY*/ObjCBridgeRelatedLoc, T.getCloseLocation()), 
          ScopeName, new SourceLocation(ScopeLoc), 
          RelatedClass, 
          ClassMethod, 
          InstanceMethod, 
          Syntax);
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTypeTagForDatatypeAttribute">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed EndLoc to final ref*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1290,
   FQN="clang::Parser::ParseTypeTagForDatatypeAttribute", NM="_ZN5clang6Parser32ParseTypeTagForDatatypeAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser32ParseTypeTagForDatatypeAttributeERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  protected /*private*/ void ParseTypeTagForDatatypeAttribute(final IdentifierInfo /*&*/ AttrName, 
                                  SourceLocation AttrNameLoc, 
                                  final ParsedAttributes /*&*/ Attrs, 
                                  final SourceLocation /*P*/ EndLoc, 
                                  IdentifierInfo /*P*/ ScopeName, 
                                  SourceLocation ScopeLoc, 
                                  AttributeList.Syntax Syntax) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.l_paren)) : "Attribute arg list not starting with '('";
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
          T.skipToEnd();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      IdentifierLoc /*P*/ ArgumentKind = $this().ParseIdentifierLoc();
      if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
        T.skipToEnd();
        return;
      }
      
      SourceRange MatchingCTypeRange/*J*/= new SourceRange();
      ActionResult<OpaquePtr<QualType> > MatchingCType = $this().ParseTypeName($AddrOf(MatchingCTypeRange));
      if (MatchingCType.isInvalid()) {
        T.skipToEnd();
        return;
      }
      
      boolean LayoutCompatible = false;
      boolean MustBeNull = false;
      while ($this().TryConsumeToken(tok.TokenKind.comma)) {
        if ($this().Tok.isNot(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
            T.skipToEnd();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        IdentifierInfo /*P*/ Flag = $this().Tok.getIdentifierInfo();
        if (Flag.isStr(/*KEEP_STR*/"layout_compatible")) {
          LayoutCompatible = true;
        } else if (Flag.isStr(/*KEEP_STR*/"must_be_null")) {
          MustBeNull = true;
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().Tok, diag.err_type_safety_unknown_flag)), Flag));
            T.skipToEnd();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        $this().ConsumeToken(); // consume flag
      }
      if (!T.consumeClose()) {
        Attrs.addNewTypeTagForDatatype($AddrOf(AttrName), new SourceRange(/*NO_COPY*/AttrNameLoc), ScopeName, new SourceLocation(ScopeLoc), 
            ArgumentKind, MatchingCType.get(), 
            LayoutCompatible, MustBeNull, Syntax);
      }
      if ((EndLoc != null)) {
        EndLoc.$assignMove(T.getCloseLocation());
      }
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAttributeWithTypeArg">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed EndLoc to final ref*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 242,
   FQN="clang::Parser::ParseAttributeWithTypeArg", NM="_ZN5clang6Parser25ParseAttributeWithTypeArgERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser25ParseAttributeWithTypeArgERNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_PS1_S3_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  protected /*private*/ void ParseAttributeWithTypeArg(final IdentifierInfo /*&*/ AttrName, 
                           SourceLocation AttrNameLoc, 
                           final ParsedAttributes /*&*/ Attrs, 
                           final SourceLocation /*P*/ EndLoc, 
                           IdentifierInfo /*P*/ ScopeName, 
                           SourceLocation ScopeLoc, 
                           AttributeList.Syntax Syntax) {
    BalancedDelimiterTracker Parens = null;
    try {
      Parens/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      Parens.consumeOpen();
      
      ActionResult<OpaquePtr<QualType> > T/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
      if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
        T.$assignMove($this().ParseTypeName());
      }
      if (Parens.consumeClose()) {
        return;
      }
      if (T.isInvalid()) {
        return;
      }
      if (T.isUsable()) {
        Attrs.addNewTypeAttr($AddrOf(AttrName), 
            new SourceRange(/*NO_COPY*/AttrNameLoc, Parens.getCloseLocation()), 
            ScopeName, new SourceLocation(ScopeLoc), T.get(), Syntax);
      } else {
        Attrs.addNew($AddrOf(AttrName), new SourceRange(/*NO_COPY*/AttrNameLoc, Parens.getCloseLocation()), 
            ScopeName, new SourceLocation(ScopeLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, Syntax);
      }
    } finally {
      if (Parens != null) { Parens.$destroy(); }
    }
  }


/// [GNU]   typeof-specifier:
///           typeof ( expressions )
///           typeof ( type-name )
/// [GNU/C++] typeof unary-expression
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTypeofSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 6260,
   FQN="clang::Parser::ParseTypeofSpecifier", NM="_ZN5clang6Parser20ParseTypeofSpecifierERNS_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser20ParseTypeofSpecifierERNS_8DeclSpecE")
  //</editor-fold>
  protected /*private*/ void ParseTypeofSpecifier(final DeclSpec /*&*/ DS) {
    EnterExpressionEvaluationContext Unevaluated = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_typeof)) : "Not a typeof specifier";
      Token OpTok = new Token($this().Tok);
      SourceLocation StartLoc = $this().ConsumeToken();
      
      /*const*/boolean hasParens = $this().Tok.is(tok.TokenKind.l_paren);
      
      Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated, 
          Sema.ReuseLambdaContextDecl_t.ReuseLambdaContextDecl);
      
      bool$ref isCastExpr = create_bool$ref();
      OpaquePtr<QualType> CastTy/*J*/= new OpaquePtr<QualType>();
      SourceRange CastRange/*J*/= new SourceRange();
      ActionResultTTrue<Expr /*P*/ > Operand = $this().Actions.CorrectDelayedTyposInExpr($this().ParseExprAfterUnaryExprOrTypeTrait(OpTok, isCastExpr, CastTy, CastRange));
      if (hasParens) {
        DS.setTypeofParensRange(new SourceRange(CastRange));
      }
      if (CastRange.getEnd().isInvalid()) {
        // FIXME: Not accurate, the range gets one token more than it should.
        DS.SetRangeEnd($this().Tok.getLocation());
      } else {
        DS.SetRangeEnd(CastRange.getEnd());
      }
      if (isCastExpr.$deref()) {
        if (!CastTy.$bool()) {
          DS.SetTypeSpecError();
          return;
        }
        
        /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
        /*uint*/uint$ref DiagID = create_uint$ref();
        // Check for duplicate type specifiers (e.g. "int typeof(int)").
        if (DS.SetTypeSpecType(DeclSpec.TST_typeofType, new SourceLocation(StartLoc), PrevSpec, 
            DiagID, new OpaquePtr<QualType>(CastTy), 
            $this().Actions.getASTContext().getPrintingPolicy())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
          } finally {
            $c$.$destroy();
          }
        }
        return;
      }
      
      // If we get here, the operand to the typeof was an expresion.
      if (Operand.isInvalid()) {
        DS.SetTypeSpecError();
        return;
      }
      
      // We might need to transform the operand if it is potentially evaluated.
      Operand.$assignMove($this().Actions.HandleExprEvaluationContextForTypeof(Operand.get()));
      if (Operand.isInvalid()) {
        DS.SetTypeSpecError();
        return;
      }
      
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref();
      // Check for duplicate type specifiers (e.g. "int typeof(int)").
      if (DS.SetTypeSpecType(DeclSpec.TST_typeofExpr, new SourceLocation(StartLoc), PrevSpec, 
          DiagID, Operand.get(), 
          $this().Actions.getASTContext().getPrintingPolicy())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (Unevaluated != null) { Unevaluated.$destroy(); }
    }
  }


/// [C11]   atomic-specifier:
///           _Atomic ( type-name )
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAtomicSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 6325,
   FQN="clang::Parser::ParseAtomicSpecifier", NM="_ZN5clang6Parser20ParseAtomicSpecifierERNS_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser20ParseAtomicSpecifierERNS_8DeclSpecE")
  //</editor-fold>
  protected /*private*/ void ParseAtomicSpecifier(final DeclSpec /*&*/ DS) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw__Atomic) && $this().NextToken().is(tok.TokenKind.l_paren)) : "Not an atomic specifier";
      
      SourceLocation StartLoc = $this().ConsumeToken();
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.consumeOpen()) {
        return;
      }
      
      ActionResult<OpaquePtr<QualType> > Result = $this().ParseTypeName();
      if (Result.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
        return;
      }
      
      // Match the ')'
      T.consumeClose();
      if (T.getCloseLocation().isInvalid()) {
        return;
      }
      
      DS.setTypeofParensRange(T.getRange());
      DS.SetRangeEnd(T.getCloseLocation());
      
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref();
      if (DS.SetTypeSpecType(DeclSpec.TST_atomic, new SourceLocation(StartLoc), PrevSpec, 
          DiagID, Result.get(), 
          $this().Actions.getASTContext().getPrintingPolicy())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseAlignArgument - Parse the argument to an alignment-specifier.
///
/// FIXME: Simply returns an alignof() expression if the argument is a
/// type. Ideally, the type should be propagated directly into Sema.
///
/// [C11]   type-id
/// [C11]   constant-expression
/// [C++0x] type-id ...[opt]
/// [C++0x] assignment-expression ...[opt]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAlignArgument">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 2484,
   FQN="clang::Parser::ParseAlignArgument", NM="_ZN5clang6Parser18ParseAlignArgumentENS_14SourceLocationERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser18ParseAlignArgumentENS_14SourceLocationERS1_")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseAlignArgument(SourceLocation Start, 
                    final SourceLocation /*&*/ EllipsisLoc) {
    ActionResultTTrue<Expr /*P*/ > ER/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ($this().isTypeIdInParens()) {
      SourceLocation TypeLoc = $this().Tok.getLocation();
      OpaquePtr<QualType> Ty = $this().ParseTypeName().get();
      SourceRange TypeRange/*J*/= new SourceRange(/*NO_COPY*/Start, $this().Tok.getLocation());
      ER.$assignMove($this().Actions.ActOnUnaryExprOrTypeTraitExpr(new SourceLocation(TypeLoc), UnaryExprOrTypeTrait.UETT_AlignOf, true, 
              Ty.getAsOpaquePtr(), new SourceRange(TypeRange)));
    } else {
      ER.$assignMove($this().ParseConstantExpression());
    }
    if ($this().getLangOpts().CPlusPlus11) {
      $this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc);
    }
    
    return ER;
  }


/// ParseAlignmentSpecifier - Parse an alignment-specifier, and add the
/// attribute to Attrs.
///
/// alignment-specifier:
/// [C11]   '_Alignas' '(' type-id ')'
/// [C11]   '_Alignas' '(' constant-expression ')'
/// [C++11] 'alignas' '(' type-id ...[opt] ')'
/// [C++11] 'alignas' '(' assignment-expression ...[opt] ')'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseAlignmentSpecifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 2510,
   FQN="clang::Parser::ParseAlignmentSpecifier", NM="_ZN5clang6Parser23ParseAlignmentSpecifierERNS_16ParsedAttributesEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser23ParseAlignmentSpecifierERNS_16ParsedAttributesEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseAlignmentSpecifier(final ParsedAttributes /*&*/ Attrs) {
    $this().ParseAlignmentSpecifier(Attrs, 
                         (SourceLocation /*P*/ )null);
  }
  protected /*private*/ void ParseAlignmentSpecifier(final ParsedAttributes /*&*/ Attrs, 
                         final SourceLocation /*P*/ EndLoc/*= null*/) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.isOneOf(tok.TokenKind.kw_alignas, tok.TokenKind.kw__Alignas)) : "Not an alignment-specifier!";
      
      IdentifierInfo /*P*/ KWName = $this().Tok.getIdentifierInfo();
      SourceLocation KWLoc = $this().ConsumeToken();
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.expectAndConsume()) {
        return;
      }
      
      SourceLocation EllipsisLoc/*J*/= new SourceLocation();
      ActionResultTTrue<Expr /*P*/ > ArgExpr = $this().ParseAlignArgument(T.getOpenLocation(), EllipsisLoc);
      if (ArgExpr.isInvalid()) {
        T.skipToEnd();
        return;
      }
      
      T.consumeClose();
      if ((EndLoc != null)) {
        EndLoc.$assignMove(T.getCloseLocation());
      }
      
      SmallVector<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >> ArgExprs/*J*/= new SmallVector<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>(12, new PointerUnion<>(Expr /*P*/.class));
      ArgExprs.push_back(new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(JD$T.INSTANCE, Expr /*P*/ /*P*/.class, ArgExpr.get()));
      Attrs.addNew(KWName, new SourceRange(/*NO_COPY*/KWLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(KWLoc), ArgExprs.data(), 1, 
          AttributeList.Syntax.AS_Keyword, new SourceLocation(EllipsisLoc));
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseDeclarator - Parse and verify a newly-initialized declarator.

/// ParseDeclarator - Parse and verify a newly-initialized declarator.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4920,
   FQN="clang::Parser::ParseDeclarator", NM="_ZN5clang6Parser15ParseDeclaratorERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser15ParseDeclaratorERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseDeclarator(final Declarator /*&*/ D) {
    /// This implements the 'declarator' production in the C grammar, then checks
    /// for well-formedness and issues diagnostics.
    $this().ParseDeclaratorInternal(D, /*AddrOf*//*FPtr*/Parser::ParseDirectDeclarator);
  }


/// ParseDeclaratorInternal - Parse a C or C++ declarator. The direct-declarator
/// is parsed by the function passed to it. Pass null, and the direct-declarator
/// isn't parsed at all, making this function effectively parse the C++
/// ptr-operator production.
///
/// If the grammar of this construct is extended, matching changes must also be
/// made to TryParseDeclarator and MightBeDeclarator, and possibly to
/// isConstructorDeclarator.
///
///       declarator: [C99 6.7.5] [C++ 8p4, dcl.decl]
/// [C]     pointer[opt] direct-declarator
/// [C++]   direct-declarator
/// [C++]   ptr-operator declarator
///
///       pointer: [C99 6.7.5]
///         '*' type-qualifier-list[opt]
///         '*' type-qualifier-list[opt] pointer
///
///       ptr-operator:
///         '*' cv-qualifier-seq[opt]
///         '&'
/// [C++0x] '&&'
/// [GNU]   '&' restrict[opt] attributes[opt]
/// [GNU?]  '&&' restrict[opt] attributes[opt]
///         '::'[opt] nested-name-specifier '*' cv-qualifier-seq[opt]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDeclaratorInternal">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4988,
   FQN="clang::Parser::ParseDeclaratorInternal", NM="_ZN5clang6Parser23ParseDeclaratorInternalERNS_10DeclaratorEMS0_FvS2_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser23ParseDeclaratorInternalERNS_10DeclaratorEMS0_FvS2_E")
  //</editor-fold>
  protected /*private*/ void ParseDeclaratorInternal(final Declarator /*&*/ D, 
                         Parser$Declarator2Void DirectDeclParser) {
    if ($this().Diags.hasAllExtensionsSilenced()) {
      D.setExtension();
    }
    
    // C++ member pointers start with a '::' or a nested-name.
    // Member pointers get special handling, since there's no place for the
    // scope spec in the generic path below.
    if ($this().getLangOpts().CPlusPlus
       && ($this().Tok.is(tok.TokenKind.coloncolon) || $this().Tok.is(tok.TokenKind.kw_decltype)
       || ($this().Tok.is(tok.TokenKind.identifier)
       && ($this().NextToken().is(tok.TokenKind.coloncolon) || $this().NextToken().is(tok.TokenKind.less)))
       || $this().Tok.is(tok.TokenKind.annot_cxxscope))) {
      CXXScopeSpec SS = null;
      try {
        boolean EnteringContext = D.getContext() == Declarator.TheContext.FileContext
           || D.getContext() == Declarator.TheContext.MemberContext;
        SS/*J*/= new CXXScopeSpec();
        $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), EnteringContext);
        if (SS.isNotEmpty()) {
          DeclSpec DS = null;
          try {
            if ($this().Tok.isNot(tok.TokenKind.star)) {
              // The scope spec really belongs to the direct-declarator.
              if (D.mayHaveIdentifier()) {
                D.getCXXScopeSpec().$assign(SS);
              } else {
                $this().AnnotateScopeToken(SS, true);
              }
              if ((DirectDeclParser != null)) {
                DirectDeclParser.$call(/*PtrMemI*/$this(), D);
              }
              return;
            }
            
            SourceLocation Loc = $this().ConsumeToken();
            D.SetRangeEnd(new SourceLocation(Loc));
            DS/*J*/= new DeclSpec($this().AttrFactory);
            $this().ParseTypeQualifierListOpt(DS);
            D.ExtendWithDeclSpec(DS);
            
            // Recurse to parse whatever is left.
            $this().ParseDeclaratorInternal(D, DirectDeclParser);
            
            // Sema will have to catch (syntactically invalid) pointers into global
            // scope. It has to catch pointers into namespace scope anyway.
            D.AddTypeInfo(DeclaratorChunk.getMemberPointer(SS, DS.getTypeQualifiers(), 
                    DS.getLocEnd()), 
                DS.getAttributes(), 
                /* Don't replace range end. */ new SourceLocation());
            return;
          } finally {
            if (DS != null) { DS.$destroy(); }
          }
        }
      } finally {
        if (SS != null) { SS.$destroy(); }
      }
    }
    
    /*tok.TokenKind*/char Kind = $this().Tok.getKind();
    if (D.getDeclSpec().isTypeSpecPipe() && !isPipeDeclerator(D)) {
      DeclSpec DS = null;
      try {
        DS/*J*/= new DeclSpec($this().AttrFactory);
        $this().ParseTypeQualifierListOpt(DS);
        
        D.AddTypeInfo(DeclaratorChunk.getPipe(DS.getTypeQualifiers(), DS.getPipeLoc()), 
            DS.getAttributes(), new SourceLocation());
      } finally {
        if (DS != null) { DS.$destroy(); }
      }
    }
    
    // Not a pointer, C++ reference, or block.
    if (!isPtrOperatorToken(Kind, $this().getLangOpts(), D.getContext().getValue())) {
      if ((DirectDeclParser != null)) {
        DirectDeclParser.$call(/*PtrMemI*/$this(), D);
      }
      return;
    }
    
    // Otherwise, '*' -> pointer, '^' -> block, '&' -> lvalue reference,
    // '&&' -> rvalue reference
    SourceLocation Loc = $this().ConsumeToken(); // Eat the *, ^, & or &&.
    D.SetRangeEnd(new SourceLocation(Loc));
    if (Kind == tok.TokenKind.star || Kind == tok.TokenKind.caret) {
      DeclSpec DS = null;
      try {
        // Is a pointer.
        DS/*J*/= new DeclSpec($this().AttrFactory);
        
        // GNU attributes are not allowed here in a new-type-id, but Declspec and
        // C++11 attributes are allowed.
        /*uint*/int Reqs = AttrRequirements.AR_CXX11AttributesParsed | AttrRequirements.AR_DeclspecAttributesParsed
           | ((D.getContext() != Declarator.TheContext.CXXNewContext) ? AttrRequirements.AR_GNUAttributesParsed : AttrRequirements.AR_GNUAttributesParsedAndRejected);
        $this().ParseTypeQualifierListOpt(DS, Reqs, true, !D.mayOmitIdentifier());
        D.ExtendWithDeclSpec(DS);
        
        // Recursively parse the declarator.
        $this().ParseDeclaratorInternal(D, DirectDeclParser);
        if (Kind == tok.TokenKind.star) {
          // Remember that we parsed a pointer type, and remember the type-quals.
          D.AddTypeInfo(DeclaratorChunk.getPointer(DS.getTypeQualifiers(), new SourceLocation(Loc), 
                  DS.getConstSpecLoc(), 
                  DS.getVolatileSpecLoc(), 
                  DS.getRestrictSpecLoc(), 
                  DS.getAtomicSpecLoc(), 
                  DS.getUnalignedSpecLoc()), 
              DS.getAttributes(), 
              new SourceLocation());
        } else {
          // Remember that we parsed a Block type, and remember the type-quals.
          D.AddTypeInfo(DeclaratorChunk.getBlockPointer(DS.getTypeQualifiers(), 
                  new SourceLocation(Loc)), 
              DS.getAttributes(), 
              new SourceLocation());
        }
      } finally {
        if (DS != null) { DS.$destroy(); }
      }
    } else {
      DeclSpec DS = null;
      try {
        // Is a reference
        DS/*J*/= new DeclSpec($this().AttrFactory);
        
        // Complain about rvalue references in C++03, but then go on and build
        // the declarator.
        if (Kind == tok.TokenKind.ampamp) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_rvalue_reference : diag.ext_rvalue_reference)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // GNU-style and C++11 attributes are allowed here, as is restrict.
        $this().ParseTypeQualifierListOpt(DS);
        D.ExtendWithDeclSpec(DS);
        
        // C++ 8.3.2p1: cv-qualified references are ill-formed except when the
        // cv-qualifiers are introduced through the use of a typedef or of a
        // template type argument, in which case the cv-qualifiers are ignored.
        if (DS.getTypeQualifiers() != DeclSpec.TQ.TQ_unspecified.getValue()) {
          if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_const.getValue()) != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(DS.getConstSpecLoc(), 
                      diag.err_invalid_reference_qualifier_application)), /*KEEP_STR*/$const));
            } finally {
              $c$.$destroy();
            }
          }
          if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_volatile.getValue()) != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(DS.getVolatileSpecLoc(), 
                      diag.err_invalid_reference_qualifier_application)), /*KEEP_STR*/$volatile));
            } finally {
              $c$.$destroy();
            }
          }
          // 'restrict' is permitted as an extension.
          if (((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_atomic.getValue()) != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(DS.getAtomicSpecLoc(), 
                      diag.err_invalid_reference_qualifier_application)), /*KEEP_STR*/$_Atomic));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        // Recursively parse the declarator.
        $this().ParseDeclaratorInternal(D, DirectDeclParser);
        if ($greater_uint(D.getNumTypeObjects(), 0)) {
          // C++ [dcl.ref]p4: There shall be no references to references.
          final DeclaratorChunk /*&*/ InnerChunk = D.getTypeObject(D.getNumTypeObjects() - 1);
          if (InnerChunk.Kind == DeclaratorChunk.Unnamed_enum.Reference) {
            {
              /*const*/ IdentifierInfo /*P*/ II = D.getIdentifier();
              if ((II != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(InnerChunk.Loc), diag.err_illegal_decl_reference_to_reference)), 
                      II));
                } finally {
                  $c$.$destroy();
                }
              } else {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(InnerChunk.Loc), diag.err_illegal_decl_reference_to_reference)), 
                      /*KEEP_STR*/"type name"));
                } finally {
                  $c$.$destroy();
                }
              }
            }
            // Once we've complained about the reference-to-reference, we
            // can go ahead and build the (technically ill-formed)
            // declarator: reference collapsing will take care of it.
          }
        }
        
        // Remember that we parsed a reference type.
        D.AddTypeInfo(DeclaratorChunk.getReference(DS.getTypeQualifiers(), new SourceLocation(Loc), 
                Kind == tok.TokenKind.amp), 
            DS.getAttributes(), 
            new SourceLocation());
      } finally {
        if (DS != null) { DS.$destroy(); }
      }
    }
  }


/// ParseTypeQualifierListOpt
///          type-qualifier-list: [C99 6.7.5]
///            type-qualifier
/// [vendor]   attributes
///              [ only if AttrReqs & AR_VendorAttributesParsed ]
///            type-qualifier-list type-qualifier
/// [vendor]   type-qualifier-list attributes
///              [ only if AttrReqs & AR_VendorAttributesParsed ]
/// [C++0x]    attribute-specifier[opt] is allowed before cv-qualifier-seq
///              [ only if AttReqs & AR_CXX11AttributesParsed ]
/// Note: vendor can be GNU, MS, etc and can be explicitly controlled via
/// AttrRequirements bitmask values.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTypeQualifierListOpt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*GO TO*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 4785,
   FQN="clang::Parser::ParseTypeQualifierListOpt", NM="_ZN5clang6Parser25ParseTypeQualifierListOptERNS_8DeclSpecEjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser25ParseTypeQualifierListOptERNS_8DeclSpecEjbb")
  //</editor-fold>
  protected /*private*/ void ParseTypeQualifierListOpt(final DeclSpec /*&*/ DS) {
    $this().ParseTypeQualifierListOpt(DS, AttrRequirements.AR_AllAttributesParsed, 
                           true, 
                           false);
  }
  protected /*private*/ void ParseTypeQualifierListOpt(final DeclSpec /*&*/ DS, /*uint*/int AttrReqs/*= AR_AllAttributesParsed*/) {
    $this().ParseTypeQualifierListOpt(DS, AttrReqs, 
                           true, 
                           false);
  }
  protected /*private*/ void ParseTypeQualifierListOpt(final DeclSpec /*&*/ DS, /*uint*/int AttrReqs/*= AR_AllAttributesParsed*/, 
                           boolean AtomicAllowed/*= true*/) {
    $this().ParseTypeQualifierListOpt(DS, AttrReqs, 
                           AtomicAllowed, 
                           false);
  }
  protected /*private*/ void ParseTypeQualifierListOpt(final DeclSpec /*&*/ DS, /*uint*/int AttrReqs/*= AR_AllAttributesParsed*/, 
                           boolean AtomicAllowed/*= true*/, 
                           boolean IdentifierRequired/*= false*/) {
    if ($this().getLangOpts().CPlusPlus11 && $bool2uint_1bit(((AttrReqs & AttrRequirements.AR_CXX11AttributesParsed)))
       && ($this().isCXX11AttributeSpecifier().getValue() != 0)) {
      ParsedAttributesWithRange attrs = null;
      try {
        attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
        $this().ParseCXX11Attributes(attrs);
        DS.takeAttributesFrom(attrs);
      } finally {
        if (attrs != null) { attrs.$destroy(); }
      }
    }
    
    SourceLocation EndLoc/*J*/= new SourceLocation();
    while (true) {
      boolean isInvalid = false;
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref(0);
      SourceLocation Loc = $this().Tok.getLocation();
      boolean $DoneWithTypeQuals = false;
      switch ($this().Tok.getKind()) {
       case tok.TokenKind.code_completion:
        $this().Actions.CodeCompleteTypeQualifiers(DS);
        $this().cutOffParsing();
        return;
       case tok.TokenKind.kw_const:
        isInvalid = DS.SetTypeQual(DeclSpec.TQ.TQ_const, new SourceLocation(Loc), PrevSpec, DiagID, 
            $this().getLangOpts());
        break;
       case tok.TokenKind.kw_volatile:
        isInvalid = DS.SetTypeQual(DeclSpec.TQ.TQ_volatile, new SourceLocation(Loc), PrevSpec, DiagID, 
            $this().getLangOpts());
        break;
       case tok.TokenKind.kw_restrict:
        isInvalid = DS.SetTypeQual(DeclSpec.TQ.TQ_restrict, new SourceLocation(Loc), PrevSpec, DiagID, 
            $this().getLangOpts());
        break;
       case tok.TokenKind.kw__Atomic:
        if (!AtomicAllowed) {
          $DoneWithTypeQuals=true; break/*switch*/;
        }
        isInvalid = DS.SetTypeQual(DeclSpec.TQ.TQ_atomic, new SourceLocation(Loc), PrevSpec, DiagID, 
            $this().getLangOpts());
        break;
       case tok.TokenKind.kw___private:
       case tok.TokenKind.kw___global:
       case tok.TokenKind.kw___local:
       case tok.TokenKind.kw___constant:
       case tok.TokenKind.kw___generic:
       case tok.TokenKind.kw___read_only:
       case tok.TokenKind.kw___write_only:
       case tok.TokenKind.kw___read_write:
        
        // OpenCL qualifiers:
        $this().ParseOpenCLQualifiers(DS.getAttributes());
        break;
       case tok.TokenKind.kw___unaligned:
        isInvalid = DS.SetTypeQual(DeclSpec.TQ.TQ_unaligned, new SourceLocation(Loc), PrevSpec, DiagID, 
            $this().getLangOpts());
        break;
       case tok.TokenKind.kw___uptr:
        // GNU libc headers in C mode use '__uptr' as an identifer which conflicts
        // with the MS modifier keyword.
        if (((AttrReqs & AttrRequirements.AR_DeclspecAttributesParsed) != 0) && !$this().getLangOpts().CPlusPlus
           && IdentifierRequired && DS.isEmpty() && $this().NextToken().is(tok.TokenKind.semi)) {
          if ($this().TryKeywordIdentFallback(false)) {
            continue;
          }
        }
       case tok.TokenKind.kw___sptr:
       case tok.TokenKind.kw___w64:
       case tok.TokenKind.kw___ptr64:
       case tok.TokenKind.kw___ptr32:
       case tok.TokenKind.kw___cdecl:
       case tok.TokenKind.kw___stdcall:
       case tok.TokenKind.kw___fastcall:
       case tok.TokenKind.kw___thiscall:
       case tok.TokenKind.kw___vectorcall:
        if (((AttrReqs & AttrRequirements.AR_DeclspecAttributesParsed) != 0)) {
          $this().ParseMicrosoftTypeAttributes(DS.getAttributes());
          continue;
        }
        $DoneWithTypeQuals=true; break/*switch*/;
       case tok.TokenKind.kw___pascal:
        if (((AttrReqs & AttrRequirements.AR_VendorAttributesParsed) != 0)) {
          $this().ParseBorlandTypeAttributes(DS.getAttributes());
          continue;
        }
        $DoneWithTypeQuals=true; break/*switch*/;
       case tok.TokenKind.kw__Nonnull:
       case tok.TokenKind.kw__Nullable:
       case tok.TokenKind.kw__Null_unspecified:
        
        // Nullability type specifiers.
        $this().ParseNullabilityTypeSpecifiers(DS.getAttributes());
        continue;
       case tok.TokenKind.kw___kindof:
        
        // Objective-C 'kindof' types.
        DS.getAttributes().addNew($this().Tok.getIdentifierInfo(), new SourceRange(/*NO_COPY*/Loc), (IdentifierInfo /*P*/ )null, new SourceLocation(Loc), 
            (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, AttributeList.Syntax.AS_Keyword);
        /*(void)*/$this().ConsumeToken();
        continue;
       case tok.TokenKind.kw___attribute:
        if (((AttrReqs & AttrRequirements.AR_GNUAttributesParsedAndRejected) != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // When GNU attributes are expressly forbidden, diagnose their usage.
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_attributes_not_allowed)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Parse the attributes even if they are rejected to ensure that error
        // recovery is graceful.
        if (((AttrReqs & AttrRequirements.AR_GNUAttributesParsed) != 0)
           || ((AttrReqs & AttrRequirements.AR_GNUAttributesParsedAndRejected) != 0)) {
          $this().ParseGNUAttributes(DS.getAttributes());
          continue; // do *not* consume the next token!
        }
       default:
       /*DoneWithTypeQuals:*/$DoneWithTypeQuals=true; 
       if (false) {// JAVA: CODE WAS MOVED BELOW
        // If this is not a type-qualifier token, we're done reading type
        // qualifiers.  First verify that DeclSpec's are consistent.
        DS.Finish($this().Actions, $this().Actions.getASTContext().getPrintingPolicy());
        if (EndLoc.isValid()) {
          DS.SetRangeEnd(new SourceLocation(EndLoc));
        }
        return;
       }
       break/*switch*/;
      }
      if ($DoneWithTypeQuals) {
        // If this is not a type-qualifier token, we're done reading type
        // qualifiers.  First verify that DeclSpec's are consistent.
        DS.Finish($this().Actions, $this().Actions.getASTContext().getPrintingPolicy());
        if (EndLoc.isValid()) {
          DS.SetRangeEnd(new SourceLocation(EndLoc));
        }
        return;        
      }
      // If the specifier combination wasn't legal, issue a diagnostic.
      if (isInvalid) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          assert ((PrevSpec != null)) : "Method did not return previous specifier!";
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, DiagID)), PrevSpec));
        } finally {
          $c$.$destroy();
        }
      }
      EndLoc.$assignMove($this().ConsumeToken());
    }
  }


/// ParseDirectDeclarator
///       direct-declarator: [C99 6.7.5]
/// [C99]   identifier
///         '(' declarator ')'
/// [GNU]   '(' attributes declarator ')'
/// [C90]   direct-declarator '[' constant-expression[opt] ']'
/// [C99]   direct-declarator '[' type-qual-list[opt] assignment-expr[opt] ']'
/// [C99]   direct-declarator '[' 'static' type-qual-list[opt] assign-expr ']'
/// [C99]   direct-declarator '[' type-qual-list 'static' assignment-expr ']'
/// [C99]   direct-declarator '[' type-qual-list[opt] '*' ']'
/// [C++11] direct-declarator '[' constant-expression[opt] ']'
///                    attribute-specifier-seq[opt]
///         direct-declarator '(' parameter-type-list ')'
///         direct-declarator '(' identifier-list[opt] ')'
/// [GNU]   direct-declarator '(' parameter-forward-declarations
///                    parameter-type-list[opt] ')'
/// [C++]   direct-declarator '(' parameter-declaration-clause ')'
///                    cv-qualifier-seq[opt] exception-specification[opt]
/// [C++11] direct-declarator '(' parameter-declaration-clause ')'
///                    attribute-specifier-seq[opt] cv-qualifier-seq[opt]
///                    ref-qualifier[opt] exception-specification[opt]
/// [C++]   declarator-id
/// [C++11] declarator-id attribute-specifier-seq[opt]
///
///       declarator-id: [C++ 8]
///         '...'[opt] id-expression
///         '::'[opt] nested-name-specifier[opt] type-name
///
///       id-expression: [C++ 5.1]
///         unqualified-id
///         qualified-id
///
///       unqualified-id: [C++ 5.1]
///         identifier
///         operator-function-id
///         conversion-function-id
///          '~' class-name
///         template-id
///
/// Note, any additional constructs added here may need corresponding changes
/// in isConstructorDeclarator.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDirectDeclarator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*GO TO*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 5205,
   FQN="clang::Parser::ParseDirectDeclarator", NM="_ZN5clang6Parser21ParseDirectDeclaratorERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser21ParseDirectDeclaratorERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseDirectDeclarator(final Declarator /*&*/ D) {
    DeclaratorScopeObj DeclScopeObj = null;
    try {
      DeclScopeObj/*J*/= new DeclaratorScopeObj(/*Deref*/$this(), D.getCXXScopeSpec());
    $PastIdentifier: do {
      if ($this().getLangOpts().CPlusPlus && D.mayHaveIdentifier()) {
        ColonProtectionRAIIObject X = null;
        try {
          // Don't parse FOO:BAR as if it were a typo for FOO::BAR inside a class, in
          // this context it is a bitfield. Also in range-based for statement colon
          // may delimit for-range-declaration.
          X/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this(), 
              D.getContext() == Declarator.TheContext.MemberContext
                 || (D.getContext() == Declarator.TheContext.ForContext
                 && $this().getLangOpts().CPlusPlus11));
          
          // ParseDeclaratorInternal might already have parsed the scope.
          if (D.getCXXScopeSpec().isEmpty()) {
            boolean EnteringContext = D.getContext() == Declarator.TheContext.FileContext
               || D.getContext() == Declarator.TheContext.MemberContext;
            $this().ParseOptionalCXXScopeSpecifier(D.getCXXScopeSpec(), new OpaquePtr<QualType>(null), 
                EnteringContext);
          }
          if (D.getCXXScopeSpec().isValid()) {
            if ($this().Actions.ShouldEnterDeclaratorScope($this().getCurScope(), 
                D.getCXXScopeSpec())) {
              // Change the declaration context for name lookup, until this function
              // is exited (and the declarator has been parsed).
              DeclScopeObj.EnterDeclaratorScope();
            }
          }
          
          // C++0x [dcl.fct]p14:
          //   There is a syntactic ambiguity when an ellipsis occurs at the end of a
          //   parameter-declaration-clause without a preceding comma. In this case,
          //   the ellipsis is parsed as part of the abstract-declarator if the type
          //   of the parameter either names a template parameter pack that has not
          //   been expanded or contains auto; otherwise, it is parsed as part of the
          //   parameter-declaration-clause.
          if ($this().Tok.is(tok.TokenKind.ellipsis) && D.getCXXScopeSpec().isEmpty()
             && !((D.getContext() == Declarator.TheContext.PrototypeContext
             || D.getContext() == Declarator.TheContext.LambdaExprParameterContext
             || D.getContext() == Declarator.TheContext.BlockLiteralContext)
             && $this().NextToken().is(tok.TokenKind.r_paren)
             && !D.hasGroupingParens()
             && !$this().Actions.containsUnexpandedParameterPacks(D)
             && D.getDeclSpec().getTypeSpecType() != TypeSpecifierType.TST_auto)) {
            SourceLocation EllipsisLoc = $this().ConsumeToken();
            if (isPtrOperatorToken($this().Tok.getKind(), $this().getLangOpts(), D.getContext().getValue())) {
              // The ellipsis was put in the wrong place. Recover, and explain to
              // the user what they should have done.
              $this().ParseDeclarator(D);
              if (EllipsisLoc.isValid()) {
                $this().DiagnoseMisplacedEllipsisInDeclarator(new SourceLocation(EllipsisLoc), D);
              }
              return;
            } else {
              D.setEllipsisLoc(new SourceLocation(EllipsisLoc));
            }
            // The ellipsis can't be followed by a parenthesized declarator. We
            // check for that in ParseParenDeclarator, after we have disambiguated
            // the l_paren token.
          }
          if ($this().Tok.isOneOf$T(tok.TokenKind.identifier, tok.TokenKind.kw_operator, tok.TokenKind.annot_template_id, 
              tok.TokenKind.tilde)) {
            // We found something that indicates the start of an unqualified-id.
            // Parse that unqualified-id.
            boolean AllowConstructorName;
            if (D.getDeclSpec().hasTypeSpecifier()) {
              AllowConstructorName = false;
            } else if (D.getCXXScopeSpec().isSet()) {
              AllowConstructorName
                 = (D.getContext() == Declarator.TheContext.FileContext
                 || D.getContext() == Declarator.TheContext.MemberContext);
            } else {
              AllowConstructorName = (D.getContext() == Declarator.TheContext.MemberContext);
            }
            
            SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
            boolean HadScope = D.getCXXScopeSpec().isValid();
            if ($this().ParseUnqualifiedId(D.getCXXScopeSpec(), 
                /*EnteringContext=*/ true, 
                /*AllowDestructorName=*/ true, AllowConstructorName, 
                new OpaquePtr<QualType>(null), TemplateKWLoc, D.getName())
              // Once we're past the identifier, if the scope was bad, mark the
              // whole declarator bad.
               || D.getCXXScopeSpec().isInvalid()) {
              D.SetIdentifier((IdentifierInfo /*P*/ )null, $this().Tok.getLocation());
              D.setInvalidType(true);
            } else {
              // ParseUnqualifiedId might have parsed a scope specifier during error
              // recovery. If it did so, enter that scope.
              if (!HadScope && D.getCXXScopeSpec().isValid()
                 && $this().Actions.ShouldEnterDeclaratorScope($this().getCurScope(), 
                  D.getCXXScopeSpec())) {
                DeclScopeObj.EnterDeclaratorScope();
              }
              
              // Parsed the unqualified-id; update range information and move along.
              if (D.getSourceRange().getBegin().isInvalid()) {
                D.SetRangeBegin(D.getName().getSourceRange().getBegin());
              }
              D.SetRangeEnd(D.getName().getSourceRange().getEnd());
            }
            break $PastIdentifier;
          }
          if (D.getCXXScopeSpec().isNotEmpty()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // We have a scope specifier but no following unqualified-id.
              $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().PP.getLocForEndOfToken(D.getCXXScopeSpec().getEndLoc()), 
                      diag.err_expected_unqualified_id)), 
                  /*C++*/ 1));
              D.SetIdentifier((IdentifierInfo /*P*/ )null, $this().Tok.getLocation());
              break $PastIdentifier;
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (X != null) { X.$destroy(); }
        }
      } else if ($this().Tok.is(tok.TokenKind.identifier) && D.mayHaveIdentifier()) {
        assert (!$this().getLangOpts().CPlusPlus) : "There's a C++-specific check for tok::identifier above";
        assert (($this().Tok.getIdentifierInfo() != null)) : "Not an identifier?";
        D.SetIdentifier($this().Tok.getIdentifierInfo(), $this().Tok.getLocation());
        D.SetRangeEnd($this().Tok.getLocation());
        $this().ConsumeToken();
        break $PastIdentifier;
      } else if ($this().Tok.is(tok.TokenKind.identifier) && D.diagnoseIdentifier()) {
        // A virt-specifier isn't treated as an identifier if it appears after a
        // trailing-return-type.
        if (D.getContext() != Declarator.TheContext.TrailingReturnContext
           || !($this().isCXX11VirtSpecifier($this().Tok).getValue() != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok.getLocation(), diag.err_unexpected_unqualified_id)), 
                FixItHint.CreateRemoval(new SourceRange($this().Tok.getLocation()))));
            D.SetIdentifier((IdentifierInfo /*P*/ )null, $this().Tok.getLocation());
            $this().ConsumeToken();
            break $PastIdentifier;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        // direct-declarator: '(' declarator ')'
        // direct-declarator: '(' attributes declarator ')'
        // Example: 'char (*X)'   or 'int (*XX)(void)'
        $this().ParseParenDeclarator(D);
        
        // If the declarator was parenthesized, we entered the declarator
        // scope when parsing the parenthesized declarator, then exited
        // the scope already. Re-enter the scope, if we need to.
        if (D.getCXXScopeSpec().isSet()) {
          // If there was an error parsing parenthesized declarator, declarator
          // scope may have been entered before. Don't do it again.
          if (!D.isInvalidType()
             && $this().Actions.ShouldEnterDeclaratorScope($this().getCurScope(), 
              D.getCXXScopeSpec())) {
            // Change the declaration context for name lookup, until this function
            // is exited (and the declarator has been parsed).
            DeclScopeObj.EnterDeclaratorScope();
          }
        }
      } else if (D.mayOmitIdentifier()) {
        // This could be something simple like "int" (in which case the declarator
        // portion is empty), if an abstract-declarator is allowed.
        D.SetIdentifier((IdentifierInfo /*P*/ )null, $this().Tok.getLocation());
        
        // The grammar for abstract-pack-declarator does not allow grouping parens.
        // FIXME: Revisit this once core issue 1488 is resolved.
        if (D.hasEllipsis() && D.hasGroupingParens()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().PP.getLocForEndOfToken(D.getEllipsisLoc()), 
                diag.ext_abstract_pack_declarator_parens)));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        if ($this().Tok.getKind() == tok.TokenKind.annot_pragma_parser_crash) {
          __builtin_trap();
        }
        if ($this().Tok.is(tok.TokenKind.l_square)) {
          $this().ParseMisplacedBracketDeclarator(D);
          return;
        }
        if (D.getContext() == Declarator.TheContext.MemberContext) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(getMissingDeclaratorIdLoc(D, $this().Tok.getLocation()), 
                    diag.err_expected_member_name_or_semi)), 
                (D.getDeclSpec().isEmpty() ? new SourceRange() : D.getDeclSpec().getSourceRange())));
          } finally {
            $c$.$destroy();
          }
        } else if ($this().getLangOpts().CPlusPlus) {
          if ($this().Tok.isOneOf(tok.TokenKind.period, tok.TokenKind.arrow)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out$Same2Bool($c$.track($this().Diag($this().Tok, diag.err_invalid_operator_on_type)), $this().Tok.is(tok.TokenKind.arrow)));
            } finally {
              $c$.$destroy();
            }
          } else {
            SourceLocation Loc = D.getCXXScopeSpec().getEndLoc();
            if ($this().Tok.isAtStartOfLine() && Loc.isValid()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_uint($c$.track($this().Diag($this().PP.getLocForEndOfToken(/*NO_COPY*/Loc), diag.err_expected_unqualified_id)), 
                    $this().getLangOpts().CPlusPlus));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_uint($c$.track($this().Diag(getMissingDeclaratorIdLoc(D, $this().Tok.getLocation()), 
                        diag.err_expected_unqualified_id)), 
                    $this().getLangOpts().CPlusPlus));
              } finally {
                $c$.$destroy();
              }
            }
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(getMissingDeclaratorIdLoc(D, $this().Tok.getLocation()), 
                        diag.err_expected_either)), 
                    tok.TokenKind.identifier), tok.TokenKind.l_paren));
          } finally {
            $c$.$destroy();
          }
        }
        D.SetIdentifier((IdentifierInfo /*P*/ )null, $this().Tok.getLocation());
        D.setInvalidType(true);
      }
     } while (false); // JAVA for goto PastIdentifier
     /*PastIdentifier:*/
      assert (D.isPastIdentifier()) : "Haven't past the location of the identifier yet?";
      
      // Don't parse attributes unless we have parsed an unparenthesized name.
      if (D.hasName() && !(D.getNumTypeObjects() != 0)) {
        $this().MaybeParseCXX11Attributes(D);
      }
      while (true) {
        if ($this().Tok.is(tok.TokenKind.l_paren)) {
          ParseScope PrototypeScope = null;
          ParsedAttributes attrs = null;
          BalancedDelimiterTracker T = null;
          try {
            // Enter function-declaration scope, limiting any declarators to the
            // function prototype scope, including parameter declarators.
            PrototypeScope/*J*/= new ParseScope($this(), 
                Scope.ScopeFlags.FunctionPrototypeScope | Scope.ScopeFlags.DeclScope
                   | (D.isFunctionDeclaratorAFunctionDeclaration() ? Scope.ScopeFlags.FunctionDeclarationScope : 0));
            
            // The paren may be part of a C++ direct initializer, eg. "int x(1);".
            // In such a case, check if we actually have a function declarator; if it
            // is not, the declarator has been fully parsed.
            bool$ptr IsAmbiguous = create_bool$ptr(false);
            if ($this().getLangOpts().CPlusPlus && D.mayBeFollowedByCXXDirectInit()) {
              // The name of the declarator, if any, is tentatively declared within
              // a possible direct initializer.
              $this().TentativelyDeclaredIdentifiers.push_back(D.getIdentifier());
              boolean IsFunctionDecl = $this().isCXXFunctionDeclarator($AddrOf(IsAmbiguous));
              $this().TentativelyDeclaredIdentifiers.pop_back();
              if (!IsFunctionDecl) {
                break;
              }
            }
            attrs/*J*/= new ParsedAttributes($this().AttrFactory);
            T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
            T.consumeOpen();
            $this().ParseFunctionDeclarator(D, attrs, T, IsAmbiguous.$star());
            PrototypeScope.Exit();
          } finally {
            if (T != null) { T.$destroy(); }
            if (attrs != null) { attrs.$destroy(); }
            if (PrototypeScope != null) { PrototypeScope.$destroy(); }
          }
        } else if ($this().Tok.is(tok.TokenKind.l_square)) {
          $this().ParseBracketDeclarator(D);
        } else {
          break;
        }
      }
    } finally {
      if (DeclScopeObj != null) { DeclScopeObj.$destroy(); }
    }
  }


/// ParseParenDeclarator - We parsed the declarator D up to a paren.  This is
/// only called before the identifier, so these are most likely just grouping
/// parens for precedence.  If we find that these are actually function
/// parameter parens in an abstract-declarator, we call ParseFunctionDeclarator.
///
///       direct-declarator:
///         '(' declarator ')'
/// [GNU]   '(' attributes declarator ')'
///         direct-declarator '(' parameter-type-list ')'
///         direct-declarator '(' identifier-list[opt] ')'
/// [GNU]   direct-declarator '(' parameter-forward-declarations
///                    parameter-type-list[opt] ')'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseParenDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 5451,
   FQN="clang::Parser::ParseParenDeclarator", NM="_ZN5clang6Parser20ParseParenDeclaratorERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser20ParseParenDeclaratorERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseParenDeclarator(final Declarator /*&*/ D) {
    BalancedDelimiterTracker T = null;
    ParsedAttributes attrs = null;
    ParseScope PrototypeScope = null;
    try {
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      T.consumeOpen();
      assert (!D.isPastIdentifier()) : "Should be called before passing identifier";
      
      // Eat any attributes before we look at whether this is a grouping or function
      // declarator paren.  If this is a grouping paren, the attribute applies to
      // the type being built up, for example:
      //     int (__attribute__(()) *x)(long y)
      // If this ends up not being a grouping paren, the attribute applies to the
      // first argument, for example:
      //     int (__attribute__(()) int x)
      // In either case, we need to eat any attributes to be able to determine what
      // sort of paren this is.
      //
      attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      boolean RequiresArg = false;
      if ($this().Tok.is(tok.TokenKind.kw___attribute)) {
        $this().ParseGNUAttributes(attrs);
        
        // We require that the argument list (if this is a non-grouping paren) be
        // present even if the attribute list was empty.
        RequiresArg = true;
      }
      
      // Eat any Microsoft extensions.
      $this().ParseMicrosoftTypeAttributes(attrs);
      
      // Eat any Borland extensions.
      if ($this().Tok.is(tok.TokenKind.kw___pascal)) {
        $this().ParseBorlandTypeAttributes(attrs);
      }
      
      // If we haven't past the identifier yet (or where the identifier would be
      // stored, if this is an abstract declarator), then this is probably just
      // grouping parens. However, if this could be an abstract-declarator, then
      // this could also be the start of function arguments (consider 'void()').
      boolean isGrouping;
      if (!D.mayOmitIdentifier()) {
        // If this can't be an abstract-declarator, this *must* be a grouping
        // paren, because we haven't seen the identifier yet.
        isGrouping = true;
      } else if ($this().Tok.is(tok.TokenKind.r_paren) // 'int()' is a function.
         || ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.ellipsis)
         && $this().NextToken().is(tok.TokenKind.r_paren)) // C++ int(...)
         || $this().isDeclarationSpecifier() // 'int(int)' is a function.
         || ($this().isCXX11AttributeSpecifier().getValue() != 0)) { // 'int([[]]int)' is a function.
  // This handles C99 6.7.5.3p11: in "typedef int X; void foo(X)", X is
  // considered to be a type, not a K&R identifier-list.
        isGrouping = false;
      } else {
        // Otherwise, this is a grouping paren, e.g. 'int (*X)' or 'int(X)'.
        isGrouping = true;
      }
      
      // If this is a grouping paren, handle:
      // direct-declarator: '(' declarator ')'
      // direct-declarator: '(' attributes declarator ')'
      if (isGrouping) {
        SourceLocation EllipsisLoc = D.getEllipsisLoc();
        D.setEllipsisLoc(new SourceLocation());
        
        boolean hadGroupingParens = D.hasGroupingParens();
        D.setGroupingParens(true);
        $this().ParseDeclaratorInternal(D, /*AddrOf*//*FPtr*/Parser::ParseDirectDeclarator);
        // Match the ')'.
        T.consumeClose();
        D.AddTypeInfo(DeclaratorChunk.getParen(T.getOpenLocation(), 
                T.getCloseLocation()), 
            attrs, T.getCloseLocation());
        
        D.setGroupingParens(hadGroupingParens);
        
        // An ellipsis cannot be placed outside parentheses.
        if (EllipsisLoc.isValid()) {
          $this().DiagnoseMisplacedEllipsisInDeclarator(new SourceLocation(EllipsisLoc), D);
        }
        
        return;
      }
      
      // Okay, if this wasn't a grouping paren, it must be the start of a function
      // argument list.  Recognize that this declarator will never have an
      // identifier (and remember where it would have been), then call into
      // ParseFunctionDeclarator to handle of argument list.
      D.SetIdentifier((IdentifierInfo /*P*/ )null, $this().Tok.getLocation());
      
      // Enter function-declaration scope, limiting any declarators to the
      // function prototype scope, including parameter declarators.
      PrototypeScope/*J*/= new ParseScope($this(), 
          Scope.ScopeFlags.FunctionPrototypeScope | Scope.ScopeFlags.DeclScope
             | (D.isFunctionDeclaratorAFunctionDeclaration() ? Scope.ScopeFlags.FunctionDeclarationScope : 0));
      $this().ParseFunctionDeclarator(D, attrs, T, false, RequiresArg);
      PrototypeScope.Exit();
    } finally {
      if (PrototypeScope != null) { PrototypeScope.$destroy(); }
      if (attrs != null) { attrs.$destroy(); }
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseFunctionDeclarator - We are after the identifier and have parsed the
/// declarator D up to a paren, which indicates that we are parsing function
/// arguments.
///
/// If FirstArgAttrs is non-null, then the caller parsed those arguments
/// immediately after the open paren - they should be considered to be the
/// first argument of a parameter.
///
/// If RequiresArg is true, then the first argument of the function is required
/// to be present and required to not be an identifier list.
///
/// For C++, after the parameter-list, it also parses the cv-qualifier-seq[opt],
/// (C++11) ref-qualifier[opt], exception-specification[opt],
/// (C++11) attribute-specifier-seq[opt], and (C++11) trailing-return-type[opt].
///
/// [C++11] exception-specification:
///           dynamic-exception-specification
///           noexcept-specification
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseFunctionDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 5567,
   FQN="clang::Parser::ParseFunctionDeclarator", NM="_ZN5clang6Parser23ParseFunctionDeclaratorERNS_10DeclaratorERNS_16ParsedAttributesERNS_24BalancedDelimiterTrackerEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser23ParseFunctionDeclaratorERNS_10DeclaratorERNS_16ParsedAttributesERNS_24BalancedDelimiterTrackerEbb")
  //</editor-fold>
  protected /*private*/ void ParseFunctionDeclarator(final Declarator /*&*/ D, 
                         final ParsedAttributes /*&*/ FirstArgAttrs, 
                         final BalancedDelimiterTracker /*&*/ Tracker, 
                         boolean IsAmbiguous) {
    $this().ParseFunctionDeclarator(D, 
                         FirstArgAttrs, 
                         Tracker, 
                         IsAmbiguous, 
                         false);
  }
  protected /*private*/ void ParseFunctionDeclarator(final Declarator /*&*/ D, 
                         final ParsedAttributes /*&*/ FirstArgAttrs, 
                         final BalancedDelimiterTracker /*&*/ Tracker, 
                         boolean IsAmbiguous, 
                         boolean RequiresArg/*= false*/) {
    DeclSpec DS = null;
    ParsedAttributes FnAttrs = null;
    try {
      assert ($this().getCurScope().isFunctionPrototypeScope()) : "Should call from a Function scope";
      // lparen is already consumed!
      assert (D.isPastIdentifier()) : "Should not call before identifier!";
      
      // This should be true when the function has typed arguments.
      // Otherwise, it is treated as a K&R-style function.
      boolean HasProto = false;
      // Build up an array of information about the parsed arguments.
      SmallVector<DeclaratorChunk.ParamInfo> ParamInfo/*J*/= new SmallVector<DeclaratorChunk.ParamInfo>(16, new DeclaratorChunk.ParamInfo());
      // Remember where we see an ellipsis, if any.
      SourceLocation EllipsisLoc/*J*/= new SourceLocation();
      
      DS/*J*/= new DeclSpec($this().AttrFactory);
      bool$ref RefQualifierIsLValueRef = create_bool$ref(true);
      SourceLocation RefQualifierLoc/*J*/= new SourceLocation();
      SourceLocation ConstQualifierLoc/*J*/= new SourceLocation();
      SourceLocation VolatileQualifierLoc/*J*/= new SourceLocation();
      SourceLocation RestrictQualifierLoc/*J*/= new SourceLocation();
      ExceptionSpecificationType ESpecType = ExceptionSpecificationType.EST_None;
      SourceRange ESpecRange/*J*/= new SourceRange();
      SmallVector<OpaquePtr<QualType>> DynamicExceptions/*J*/= new SmallVector<OpaquePtr<QualType>>(2, new OpaquePtr<QualType>());
      SmallVector<SourceRange> DynamicExceptionRanges/*J*/= new SmallVector<SourceRange>(2, SourceRange.EMPTY);
      ActionResultTTrue<Expr /*P*/ > NoexceptExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      type$ref<SmallVectorToken /*P*/> ExceptionSpecTokens = create_type$null$ref(null);
      FnAttrs/*J*/= new ParsedAttributes($this().AttrFactory);
      ActionResult<OpaquePtr<QualType> > TrailingReturnType/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
      
      /* LocalEndLoc is the end location for the local FunctionTypeLoc.
      EndLoc is the end location for the function declarator.
      They differ for trailing return types. */
      SourceLocation StartLoc/*J*/= new SourceLocation();
      SourceLocation LocalEndLoc/*J*/= new SourceLocation();
      SourceLocation EndLoc/*J*/= new SourceLocation();
      SourceLocation LParenLoc/*J*/= new SourceLocation();
      SourceLocation RParenLoc/*J*/= new SourceLocation();
      LParenLoc.$assignMove(Tracker.getOpenLocation());
      StartLoc.$assign(LParenLoc);
      if ($this().isFunctionDeclaratorIdentifierList()) {
        if (RequiresArg) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_argument_required_after_attribute)));
          } finally {
            $c$.$destroy();
          }
        }
        
        $this().ParseFunctionDeclaratorIdentifierList(D, ParamInfo);
        
        Tracker.consumeClose();
        RParenLoc.$assignMove(Tracker.getCloseLocation());
        LocalEndLoc.$assign(RParenLoc);
        EndLoc.$assign(RParenLoc);
      } else {
        if ($this().Tok.isNot(tok.TokenKind.r_paren)) {
          $this().ParseParameterDeclarationClause(D, FirstArgAttrs, ParamInfo, 
              EllipsisLoc);
        } else if (RequiresArg) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_argument_required_after_attribute)));
          } finally {
            $c$.$destroy();
          }
        }
        
        HasProto = (ParamInfo.size() != 0) || $this().getLangOpts().CPlusPlus;
        
        // If we have the closing ')', eat it.
        Tracker.consumeClose();
        RParenLoc.$assignMove(Tracker.getCloseLocation());
        LocalEndLoc.$assign(RParenLoc);
        EndLoc.$assign(RParenLoc);
        if ($this().getLangOpts().CPlusPlus) {
          Sema.CXXThisScopeRAII ThisScope = null;
          try {
            // FIXME: Accept these components in any order, and produce fixits to
            // correct the order if the user gets it wrong. Ideally we should deal
            // with the pure-specifier in the same way.
            
            // Parse cv-qualifier-seq[opt].
            $this().ParseTypeQualifierListOpt(DS, AttrRequirements.AR_NoAttributesParsed, 
                /*AtomicAllowed*/ false);
            if (!DS.getSourceRange().getEnd().isInvalid()) {
              EndLoc.$assignMove(DS.getSourceRange().getEnd());
              ConstQualifierLoc.$assignMove(DS.getConstSpecLoc());
              VolatileQualifierLoc.$assignMove(DS.getVolatileSpecLoc());
              RestrictQualifierLoc.$assignMove(DS.getRestrictSpecLoc());
            }
            
            // Parse ref-qualifier[opt].
            if ($this().ParseRefQualifier(RefQualifierIsLValueRef, RefQualifierLoc)) {
              EndLoc.$assign(RefQualifierLoc);
            }
            
            // C++11 [expr.prim.general]p3:
            //   If a declaration declares a member function or member function
            //   template of a class X, the expression this is a prvalue of type
            //   "pointer to cv-qualifier-seq X" between the optional cv-qualifer-seq
            //   and the end of the function-definition, member-declarator, or
            //   declarator.
            // FIXME: currently, "static" case isn't handled correctly.
            boolean IsCXX11MemberFunction = $this().getLangOpts().CPlusPlus11
               && D.getDeclSpec().getStorageClassSpec() != DeclSpec.SCS.SCS_typedef
               && (D.getContext() == Declarator.TheContext.MemberContext ? !D.getDeclSpec().isFriendSpecified() : D.getContext() == Declarator.TheContext.FileContext
               && D.getCXXScopeSpec().isValid()
               && $this().Actions.CurContext.isRecord());
            ThisScope/*J*/= new Sema.CXXThisScopeRAII($this().Actions, 
                dyn_cast_CXXRecordDecl($this().Actions.CurContext), 
                DS.getTypeQualifiers()
                   | (D.getDeclSpec().isConstexprSpecified()
                   && !$this().getLangOpts().CPlusPlus14 ? Qualifiers.TQ.Const : 0), 
                IsCXX11MemberFunction);
            
            // Parse exception-specification[opt].
            boolean Delayed = D.isFirstDeclarationOfMember()
               && D.isFunctionDeclaratorAFunctionDeclaration();
            if (Delayed && $this().Actions.isLibstdcxxEagerExceptionSpecHack(D)
               && $this().GetLookAheadToken(0).is(tok.TokenKind.kw_noexcept)
               && $this().GetLookAheadToken(1).is(tok.TokenKind.l_paren)
               && $this().GetLookAheadToken(2).is(tok.TokenKind.kw_noexcept)
               && $this().GetLookAheadToken(3).is(tok.TokenKind.l_paren)
               && $this().GetLookAheadToken(4).is(tok.TokenKind.identifier)
               && $this().GetLookAheadToken(4).getIdentifierInfo().isStr(/*KEEP_STR*/"swap")) {
              // HACK: We've got an exception-specification
              //   noexcept(noexcept(swap(...)))
              // or
              //   noexcept(noexcept(swap(...)) && noexcept(swap(...)))
              // on a 'swap' member function. This is a libstdc++ bug; the lookup
              // for 'swap' will only find the function we're currently declaring,
              // whereas it expects to find a non-member swap through ADL. Turn off
              // delayed parsing to give it a chance to find what it expects.
              Delayed = false;
            }
            ESpecType = $this().tryParseExceptionSpecification(Delayed, 
                ESpecRange, 
                DynamicExceptions, 
                DynamicExceptionRanges, 
                NoexceptExpr, 
                ExceptionSpecTokens);
            if (ESpecType != ExceptionSpecificationType.EST_None) {
              EndLoc.$assignMove(ESpecRange.getEnd());
            }
            
            // Parse attribute-specifier-seq[opt]. Per DR 979 and DR 1297, this goes
            // after the exception-specification.
            $this().MaybeParseCXX11Attributes(FnAttrs);
            
            // Parse trailing-return-type[opt].
            LocalEndLoc.$assign(EndLoc);
            if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.arrow)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_trailing_return_type)));
                if (D.getDeclSpec().getTypeSpecType() == TypeSpecifierType.TST_auto) {
                  StartLoc.$assignMove(D.getDeclSpec().getTypeSpecTypeLoc());
                }
                LocalEndLoc.$assignMove($this().Tok.getLocation());
                SourceRange Range/*J*/= new SourceRange();
                TrailingReturnType.$assignMove($this().ParseTrailingReturnType(Range));
                EndLoc.$assignMove(Range.getEnd());
              } finally {
                $c$.$destroy();
              }
            }
          } finally {
            if (ThisScope != null) { ThisScope.$destroy(); }
          }
        }
      }
      
      // Remember that we parsed a function type, and remember the attributes.
      D.AddTypeInfo(DeclaratorChunk.getFunction(HasProto, 
              IsAmbiguous, 
              new SourceLocation(LParenLoc), 
              ParamInfo.data(), ParamInfo.size(), 
              new SourceLocation(EllipsisLoc), new SourceLocation(RParenLoc), 
              DS.getTypeQualifiers(), 
              RefQualifierIsLValueRef.$deref(), 
              new SourceLocation(RefQualifierLoc), new SourceLocation(ConstQualifierLoc), 
              new SourceLocation(VolatileQualifierLoc), 
              new SourceLocation(RestrictQualifierLoc), 
              /*MutableLoc=*/ new SourceLocation(), 
              ESpecType, new SourceRange(ESpecRange), 
              DynamicExceptions.data(), 
              DynamicExceptionRanges.data(), 
              DynamicExceptions.size(), 
              NoexceptExpr.isUsable() ? NoexceptExpr.get() : (Expr /*P*/ )null, 
              ExceptionSpecTokens.$deref(), 
              new SourceLocation(StartLoc), new SourceLocation(LocalEndLoc), D, 
              new ActionResult<OpaquePtr<QualType> >(TrailingReturnType)), 
          FnAttrs, new SourceLocation(EndLoc));
    } finally {
      if (FnAttrs != null) { FnAttrs.$destroy(); }
      if (DS != null) { DS.$destroy(); }
    }
  }


/// ParseRefQualifier - Parses a member function ref-qualifier. Returns
/// true if a ref-qualifier is found.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseRefQualifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 5748,
   FQN="clang::Parser::ParseRefQualifier", NM="_ZN5clang6Parser17ParseRefQualifierERbRNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser17ParseRefQualifierERbRNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ boolean ParseRefQualifier(final bool$ref/*bool &*/ RefQualifierIsLValueRef, 
                   final SourceLocation /*&*/ RefQualifierLoc) {
    if ($this().Tok.isOneOf(tok.TokenKind.amp, tok.TokenKind.ampamp)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag($this().Tok, $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_ref_qualifier : diag.ext_ref_qualifier)));
        
        RefQualifierIsLValueRef.$set($this().Tok.is(tok.TokenKind.amp));
        RefQualifierLoc.$assignMove($this().ConsumeToken());
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }


/// isFunctionDeclaratorIdentifierList - This parameter list may have an
/// identifier list form for a K&R-style function:  void foo(a,b,c)
///
/// Note that identifier-lists are only allowed for normal declarators, not for
/// abstract-declarators.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isFunctionDeclaratorIdentifierList">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 5767,
   FQN="clang::Parser::isFunctionDeclaratorIdentifierList", NM="_ZN5clang6Parser34isFunctionDeclaratorIdentifierListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser34isFunctionDeclaratorIdentifierListEv")
  //</editor-fold>
  protected /*private*/ boolean isFunctionDeclaratorIdentifierList() {
    return !$this().getLangOpts().CPlusPlus
       && $this().Tok.is(tok.TokenKind.identifier)
       && !$this().TryAltiVecVectorToken()
      // K&R identifier lists can't have typedefs as identifiers, per C99
      // 6.7.5.3p11.
       && ($this().TryAnnotateTypeOrScopeToken() || !$this().Tok.is(tok.TokenKind.annot_typename))
      // Identifier lists follow a really simple grammar: the identifiers can
      // be followed *only* by a ", identifier" or ")".  However, K&R
      // identifier lists are really rare in the brave new modern world, and
      // it is very common for someone to typo a type in a non-K&R style
      // list.  If we are presented with something like: "void foo(intptr x,
      // float y)", we don't want to start parsing the function declarator as
      // though it is a K&R style declarator just because intptr is an
      // invalid type.
      //
      // To handle this, we check to see if the token after the first
      // identifier is a "," or ")".  Only then do we parse it as an
      // identifier list.
       && ($this().NextToken().is(tok.TokenKind.comma) || $this().NextToken().is(tok.TokenKind.r_paren));
  }


/// ParseFunctionDeclaratorIdentifierList - While parsing a function declarator
/// we found a K&R-style identifier list instead of a typed parameter list.
///
/// After returning, ParamInfo will hold the parsed parameters.
///
///       identifier-list: [C99 6.7.5]
///         identifier
///         identifier-list ',' identifier
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseFunctionDeclaratorIdentifierList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 5798,
   FQN="clang::Parser::ParseFunctionDeclaratorIdentifierList", NM="_ZN5clang6Parser37ParseFunctionDeclaratorIdentifierListERNS_10DeclaratorERN4llvm15SmallVectorImplINS_15DeclaratorChunk9ParamInfoEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser37ParseFunctionDeclaratorIdentifierListERNS_10DeclaratorERN4llvm15SmallVectorImplINS_15DeclaratorChunk9ParamInfoEEE")
  //</editor-fold>
  protected /*private*/ void ParseFunctionDeclaratorIdentifierList(final Declarator /*&*/ D, 
                                       final SmallVectorImpl<DeclaratorChunk.ParamInfo> /*&*/ ParamInfo) {
    SmallSetT$PLess$T$P</*const*/ IdentifierInfo /*P*/ > ParamsSoFar = null;
    try {
      // If there was no identifier specified for the declarator, either we are in
      // an abstract-declarator, or we are in a parameter declarator which was found
      // to be abstract.  In abstract-declarators, identifier lists are not valid:
      // diagnose this.
      if (!(D.getIdentifier() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.ext_ident_list_in_param)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Maintain an efficient lookup of params we have seen so far.
      ParamsSoFar/*J*/= new SmallSetT$PLess$T$P</*const*/ IdentifierInfo /*P*/ >(IdentifierInfo.DMI$IdentifierInfoPtr, 16);
      
      do {
        // If this isn't an identifier, report the error and skip until ')'.
        if ($this().Tok.isNot(tok.TokenKind.identifier)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
            $this().SkipUntil(tok.TokenKind.r_paren, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            // Forget we parsed anything.
            ParamInfo.clear();
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        IdentifierInfo /*P*/ ParmII = $this().Tok.getIdentifierInfo();
        
        // Reject 'typedef int y; int test(x, y)', but continue parsing.
        if ($this().Actions.getTypeName($Deref(ParmII), $this().Tok.getLocation(), $this().getCurScope()).$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().Tok, diag.err_unexpected_typedef_ident)), ParmII));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Verify that the argument identifier has not already been mentioned.
        if (!ParamsSoFar.insert(ParmII).second) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag($this().Tok, diag.err_param_redefinition)), ParmII));
          } finally {
            $c$.$destroy();
          }
        } else {
          // Remember this identifier in ParamInfo.
          ParamInfo.push_back(new DeclaratorChunk.ParamInfo(ParmII, 
                  $this().Tok.getLocation(), 
                  (Decl /*P*/ )null));
        }
        
        // Eat the identifier.
        $this().ConsumeToken();
        // The list continues if we see a comma.
      } while ($this().TryConsumeToken(tok.TokenKind.comma));
    } finally {
      if (ParamsSoFar != null) { ParamsSoFar.$destroy(); }
    }
  }


/// ParseParameterDeclarationClause - Parse a (possibly empty) parameter-list
/// after the opening parenthesis. This function will not parse a K&R-style
/// identifier list.
///
/// D is the declarator being parsed.  If FirstArgAttrs is non-null, then the
/// caller parsed those arguments immediately after the open paren - they should
/// be considered to be part of the first parameter.
///
/// After returning, ParamInfo will hold the parsed parameters. EllipsisLoc will
/// be the location of the ellipsis, if any was parsed.
///
///       parameter-type-list: [C99 6.7.5]
///         parameter-list
///         parameter-list ',' '...'
/// [C++]   parameter-list '...'
///
///       parameter-list: [C99 6.7.5]
///         parameter-declaration
///         parameter-list ',' parameter-declaration
///
///       parameter-declaration: [C99 6.7.5]
///         declaration-specifiers declarator
/// [C++]   declaration-specifiers declarator '=' assignment-expression
/// [C++11]                                       initializer-clause
/// [GNU]   declaration-specifiers declarator attributes
///         declaration-specifiers abstract-declarator[opt]
/// [C++]   declaration-specifiers abstract-declarator[opt]
///           '=' assignment-expression
/// [GNU]   declaration-specifiers abstract-declarator[opt] attributes
/// [C++11] attribute-specifier-seq parameter-declaration
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseParameterDeclarationClause">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 5874,
   FQN="clang::Parser::ParseParameterDeclarationClause", NM="_ZN5clang6Parser31ParseParameterDeclarationClauseERNS_10DeclaratorERNS_16ParsedAttributesERN4llvm15SmallVectorImplINS_15DeclaratorChunk9ParamInfoEEERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser31ParseParameterDeclarationClauseERNS_10DeclaratorERNS_16ParsedAttributesERN4llvm15SmallVectorImplINS_15DeclaratorChunk9ParamInfoEEERNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseParameterDeclarationClause(final Declarator /*&*/ D, 
                                 final ParsedAttributes /*&*/ FirstArgAttrs, 
                                 final SmallVectorImpl<DeclaratorChunk.ParamInfo> /*&*/ ParamInfo, 
                                 final SourceLocation /*&*/ EllipsisLoc) {
    do {
      DeclSpec DS = null;
      Declarator ParmDeclarator = null;
      try {
        // FIXME: Issue a diagnostic if we parsed an attribute-specifier-seq
        // before deciding this was a parameter-declaration-clause.
        if ($this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc)) {
          break;
        }
        
        // Parse the declaration-specifiers.
        // Just use the ParsingDeclaration "scope" of the declarator.
        DS/*J*/= new DeclSpec($this().AttrFactory);
        
        // Parse any C++11 attributes.
        $this().MaybeParseCXX11Attributes(DS.getAttributes());
        
        // Skip any Microsoft attributes before a param.
        $this().MaybeParseMicrosoftAttributes(DS.getAttributes());
        
        SourceLocation DSStart = $this().Tok.getLocation();
        
        // If the caller parsed attributes for the first argument, add them now.
        // Take them so that we only apply the attributes to the first parameter.
        // FIXME: If we can leave the attributes in the token stream somehow, we can
        // get rid of a parameter (FirstArgAttrs) and this statement. It might be
        // too much hassle.
        DS.takeAttributesFrom(FirstArgAttrs);
        
        $this().ParseDeclarationSpecifiers(DS);
        
        // Parse the declarator.  This is "PrototypeContext" or 
        // "LambdaExprParameterContext", because we must accept either 
        // 'declarator' or 'abstract-declarator' here.
        ParmDeclarator/*J*/= new Declarator(DS, 
            D.getContext() == Declarator.TheContext.LambdaExprContext ? Declarator.TheContext.LambdaExprParameterContext : Declarator.TheContext.PrototypeContext);
        $this().ParseDeclarator(ParmDeclarator);
        
        // Parse GNU attributes, if present.
        $this().MaybeParseGNUAttributes(ParmDeclarator);
        
        // Remember this parsed parameter in ParamInfo.
        IdentifierInfo /*P*/ ParmII = ParmDeclarator.getIdentifier();
        
        // DefArgToks is used when the parsing of default arguments needs
        // to be delayed.
        SmallVectorToken /*P*/ DefArgToks = null;
        
        // If no parameter was specified, verify that *something* was specified,
        // otherwise we have a missing type and identifier.
        if (DS.isEmpty() && ParmDeclarator.getIdentifier() == null
           && ParmDeclarator.getNumTypeObjects() == 0) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Completely missing, emit error.
            $c$.clean($c$.track($this().Diag(new SourceLocation(DSStart), diag.err_missing_param)));
          } finally {
            $c$.$destroy();
          }
        } else {
          // Otherwise, we have something.  Add it and let semantic analysis try
          // to grok it and add the result to the ParamInfo we are building.
          
          // Last chance to recover from a misplaced ellipsis in an attempted
          // parameter pack declaration.
          if ($this().Tok.is(tok.TokenKind.ellipsis)
             && ($this().NextToken().isNot(tok.TokenKind.r_paren)
             || (!ParmDeclarator.getEllipsisLoc().isValid()
             && !$this().Actions.isUnexpandedParameterPackPermitted()))
             && $this().Actions.containsUnexpandedParameterPacks(ParmDeclarator)) {
            $this().DiagnoseMisplacedEllipsisInDeclarator($this().ConsumeToken(), ParmDeclarator);
          }
          
          // Inform the actions module about the parameter declarator, so it gets
          // added to the current scope.
          Decl /*P*/ Param = $this().Actions.ActOnParamDeclarator($this().getCurScope(), ParmDeclarator);
          // Parse the default argument, if any. We parse the default
          // arguments in all dialects; the semantic analysis in
          // ActOnParamDefaultArgument will reject the default argument in
          // C.
          if ($this().Tok.is(tok.TokenKind.equal)) {
            SourceLocation EqualLoc = $this().Tok.getLocation();
            
            // Parse the default argument
            if (D.getContext() == Declarator.TheContext.MemberContext) {
              // If we're inside a class definition, cache the tokens
              // corresponding to the default argument. We'll actually parse
              // them when we see the end of the class definition.
              // FIXME: Can we use a smart pointer for Toks?
              DefArgToks = new SmallVectorToken(4, /*new Token()*/(Token)null);
              
              SourceLocation ArgStartLoc = $this().NextToken().getLocation();
              if (!$this().ConsumeAndStoreInitializer($Deref(DefArgToks), CachedInitKind.CIK_DefaultArgument)) {
                if (DefArgToks != null) { DefArgToks.$destroy();};
                DefArgToks = null;
                $this().Actions.ActOnParamDefaultArgumentError(Param, new SourceLocation(EqualLoc));
              } else {
                $this().Actions.ActOnParamUnparsedDefaultArgument(Param, new SourceLocation(EqualLoc), 
                    new SourceLocation(ArgStartLoc));
              }
            } else {
              EnterExpressionEvaluationContext Eval = null;
              try {
                // Consume the '='.
                $this().ConsumeToken();
                
                // The argument isn't actually potentially evaluated unless it is
                // used.
                Eval/*J*/= new EnterExpressionEvaluationContext($this().Actions, 
                    Sema.ExpressionEvaluationContext.PotentiallyEvaluatedIfUsed, 
                    Param);
                
                ActionResultTTrue<Expr /*P*/ > DefArgResult/*J*/= new ActionResultTTrue<Expr /*P*/ >();
                if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_generalized_initializer_lists)));
                    DefArgResult.$assignMove($this().ParseBraceInitializer());
                  } finally {
                    $c$.$destroy();
                  }
                } else {
                  DefArgResult.$assignMove($this().ParseAssignmentExpression());
                }
                DefArgResult.$assignMove($this().Actions.CorrectDelayedTyposInExpr(new ActionResultTTrue<Expr /*P*/ >(DefArgResult)));
                if (DefArgResult.isInvalid()) {
                  $this().Actions.ActOnParamDefaultArgumentError(Param, new SourceLocation(EqualLoc));
                  $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.r_paren, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
                } else {
                  // Inform the actions module about the default argument
                  $this().Actions.ActOnParamDefaultArgument(Param, new SourceLocation(EqualLoc), 
                      DefArgResult.get());
                }
              } finally {
                if (Eval != null) { Eval.$destroy(); }
              }
            }
          }
          
          ParamInfo.push_back(new DeclaratorChunk.ParamInfo(ParmII, 
                  ParmDeclarator.getIdentifierLoc(), 
                  Param, DefArgToks));
        }
        if ($this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc)) {
          if (!$this().getLangOpts().CPlusPlus) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // We have ellipsis without a preceding ',', which is ill-formed
              // in C. Complain and provide the fix.
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.err_missing_comma_before_ellipsis)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/EllipsisLoc, new StringRef(/*KEEP_STR*/$COMMA_SPACE))));
            } finally {
              $c$.$destroy();
            }
          } else if (ParmDeclarator.getEllipsisLoc().isValid()
             || $this().Actions.containsUnexpandedParameterPacks(ParmDeclarator)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // It looks like this was supposed to be a parameter pack. Warn and
              // point out where the ellipsis should have gone.
              SourceLocation ParmEllipsis = ParmDeclarator.getEllipsisLoc();
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out$Same2Bool($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.warn_misplaced_ellipsis_vararg)), 
                      ParmEllipsis.isValid()), new SourceRange(/*NO_COPY*/ParmEllipsis)));
              if (ParmEllipsis.isValid()) {
                $c$.clean($c$.track($this().Diag(new SourceLocation(ParmEllipsis), 
                    diag.note_misplaced_ellipsis_vararg_existing_ellipsis)));
              } else {
                $c$.clean($out$Same2Bool($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(ParmDeclarator.getIdentifierLoc(), 
                            diag.note_misplaced_ellipsis_vararg_add_ellipsis)), 
                        FixItHint.CreateInsertion(ParmDeclarator.getIdentifierLoc(), 
                            new StringRef(/*KEEP_STR*/$ELLIPSIS))), 
                    !ParmDeclarator.hasName()));
              }
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.note_misplaced_ellipsis_vararg_add_comma)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/EllipsisLoc, new StringRef(/*KEEP_STR*/$COMMA_SPACE))));
            } finally {
              $c$.$destroy();
            }
          }
          
          // We can't have any more parameters after an ellipsis.
          break;
        }
      } finally {
        if (ParmDeclarator != null) { ParmDeclarator.$destroy(); }
        if (DS != null) { DS.$destroy(); }
      }
      // If the next token is a comma, consume it and keep reading arguments.
    } while ($this().TryConsumeToken(tok.TokenKind.comma));
  }


/// [C90]   direct-declarator '[' constant-expression[opt] ']'
/// [C99]   direct-declarator '[' type-qual-list[opt] assignment-expr[opt] ']'
/// [C99]   direct-declarator '[' 'static' type-qual-list[opt] assign-expr ']'
/// [C99]   direct-declarator '[' type-qual-list 'static' assignment-expr ']'
/// [C99]   direct-declarator '[' type-qual-list[opt] '*' ']'
/// [C++11] direct-declarator '[' constant-expression[opt] ']'
///                           attribute-specifier-seq[opt]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBracketDeclarator">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 6047,
   FQN="clang::Parser::ParseBracketDeclarator", NM="_ZN5clang6Parser22ParseBracketDeclaratorERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser22ParseBracketDeclaratorERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseBracketDeclarator(final Declarator /*&*/ D) {
    BalancedDelimiterTracker T = null;
    DeclSpec DS = null;
    ParsedAttributes attrs = null;
    try {
      if ($this().CheckProhibitedCXX11Attribute()) {
        return;
      }
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
      T.consumeOpen();
      
      // C array syntax has many features, but by-far the most common is [] and [4].
      // This code does a fast path to handle some of the most obvious cases.
      if ($this().Tok.getKind() == tok.TokenKind.r_square) {
        ParsedAttributes _attrs = null;
        try {
          T.consumeClose();
          _attrs/*J*/= new ParsedAttributes($this().AttrFactory);
          $this().MaybeParseCXX11Attributes(_attrs);
          
          // Remember that we parsed the empty array type.
          D.AddTypeInfo(DeclaratorChunk.getArray(0, false, false, (Expr /*P*/ )null, 
                  T.getOpenLocation(), 
                  T.getCloseLocation()), 
              _attrs, T.getCloseLocation());
          return;
        } finally {
          if (_attrs != null) { _attrs.$destroy(); }
        }
      } else if ($this().Tok.getKind() == tok.TokenKind.numeric_constant
         && $this().GetLookAheadToken(1).is(tok.TokenKind.r_square)) {
        ParsedAttributes _attrs = null;
        try {
          // [4] is very common.  Parse the numeric constant expression.
          ActionResultTTrue<Expr /*P*/ > ExprRes/*J*/= $this().Actions.ActOnNumericConstant($this().Tok, $this().getCurScope());
          $this().ConsumeToken();
          
          T.consumeClose();
          _attrs/*J*/= new ParsedAttributes($this().AttrFactory);
          $this().MaybeParseCXX11Attributes(_attrs);
          
          // Remember that we parsed a array type, and remember its features.
          D.AddTypeInfo(DeclaratorChunk.getArray(0, false, false, 
                  ExprRes.get(), 
                  T.getOpenLocation(), 
                  T.getCloseLocation()), 
              _attrs, T.getCloseLocation());
          return;
        } finally {
          if (_attrs != null) { _attrs.$destroy(); }
        }
      } else if ($this().Tok.getKind() == tok.TokenKind.code_completion) {
        $this().Actions.CodeCompleteBracketDeclarator($this().getCurScope());
        $this().cutOffParsing();
        return;
      }
      
      // If valid, this location is the position where we read the 'static' keyword.
      SourceLocation StaticLoc/*J*/= new SourceLocation();
      $this().TryConsumeToken(tok.TokenKind.kw_static, StaticLoc);
      
      // If there is a type-qualifier-list, read it now.
      // Type qualifiers in an array subscript are a C99 feature.
      DS/*J*/= new DeclSpec($this().AttrFactory);
      $this().ParseTypeQualifierListOpt(DS, AttrRequirements.AR_CXX11AttributesParsed);
      
      // If we haven't already read 'static', check to see if there is one after the
      // type-qualifier-list.
      if (!StaticLoc.isValid()) {
        $this().TryConsumeToken(tok.TokenKind.kw_static, StaticLoc);
      }
      
      // Handle "direct-declarator [ type-qual-list[opt] * ]".
      boolean isStar = false;
      ActionResultTTrue<Expr /*P*/ > NumElements/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      
      // Handle the case where we have '[*]' as the array size.  However, a leading
      // star could be the start of an expression, for example 'X[*p + 4]'.  Verify
      // the token after the star is a ']'.  Since stars in arrays are
      // infrequent, use of lookahead is not costly here.
      if ($this().Tok.is(tok.TokenKind.star) && $this().GetLookAheadToken(1).is(tok.TokenKind.r_square)) {
        $this().ConsumeToken(); // Eat the '*'.
        if (StaticLoc.isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(StaticLoc), diag.err_unspecified_vla_size_with_static)));
            StaticLoc.$assignMove(new SourceLocation()); // Drop the static.
          } finally {
            $c$.$destroy();
          }
        }
        isStar = true;
      } else if ($this().Tok.isNot(tok.TokenKind.r_square)) {
        // Note, in C89, this production uses the constant-expr production instead
        // of assignment-expr.  The only difference is that assignment-expr allows
        // things like '=' and '*='.  Sema rejects these in C89 mode because they
        // are not i-c-e's, so we don't need to distinguish between the two here.
        
        // Parse the constant-expression or assignment-expression now (depending
        // on dialect).
        if ($this().getLangOpts().CPlusPlus) {
          NumElements.$assignMove($this().ParseConstantExpression());
        } else {
          EnterExpressionEvaluationContext Unevaluated = null;
          try {
            Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, 
                Sema.ExpressionEvaluationContext.ConstantEvaluated);
            NumElements.$assignMove(
                $this().Actions.CorrectDelayedTyposInExpr($this().ParseAssignmentExpression())
            );
          } finally {
            if (Unevaluated != null) { Unevaluated.$destroy(); }
          }
        }
      } else {
        if (StaticLoc.isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(StaticLoc), diag.err_unspecified_size_with_static)));
            StaticLoc.$assignMove(new SourceLocation()); // Drop the static.
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // If there was an error parsing the assignment-expression, recover.
      if (NumElements.isInvalid()) {
        D.setInvalidType(true);
        // If the expression was invalid, skip it.
        $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
        return;
      }
      
      T.consumeClose();
      
      attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(attrs);
      
      // Remember that we parsed a array type, and remember its features.
      D.AddTypeInfo(DeclaratorChunk.getArray(DS.getTypeQualifiers(), 
              StaticLoc.isValid(), isStar, 
              NumElements.get(), 
              T.getOpenLocation(), 
              T.getCloseLocation()), 
          attrs, T.getCloseLocation());
    } finally {
      if (attrs != null) { attrs.$destroy(); }
      if (DS != null) { DS.$destroy(); }
      if (T != null) { T.$destroy(); }
    }
  }


/// Diagnose brackets before an identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMisplacedBracketDeclarator">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 6165,
   FQN="clang::Parser::ParseMisplacedBracketDeclarator", NM="_ZN5clang6Parser31ParseMisplacedBracketDeclaratorERNS_10DeclaratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser31ParseMisplacedBracketDeclaratorERNS_10DeclaratorE")
  //</editor-fold>
  protected /*private*/ void ParseMisplacedBracketDeclarator(final Declarator /*&*/ D) {
    Declarator TempDeclarator = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.l_square)) : "Missing opening bracket";
      assert (!D.mayOmitIdentifier()) : "Declarator cannot omit identifier";
      
      SourceLocation StartBracketLoc = $this().Tok.getLocation();
      TempDeclarator/*J*/= new Declarator(D.getDeclSpec(), D.getContext());
      while ($this().Tok.is(tok.TokenKind.l_square)) {
        $this().ParseBracketDeclarator(TempDeclarator);
      }
      
      // Stuff the location of the start of the brackets into the Declarator.
      // The diagnostics from ParseDirectDeclarator will make more sense if
      // they use this location instead.
      if ($this().Tok.is(tok.TokenKind.semi)) {
        D.getName().EndLocation.$assign(StartBracketLoc);
      }
      
      SourceLocation SuggestParenLoc = $this().Tok.getLocation();
      
      // Now that the brackets are removed, try parsing the declarator again.
      $this().ParseDeclaratorInternal(D, /*AddrOf*//*FPtr*/Parser::ParseDirectDeclarator);
      
      // Something went wrong parsing the brackets, in which case,
      // ParseBracketDeclarator has emitted an error, and we don't need to emit
      // one here.
      if (TempDeclarator.getNumTypeObjects() == 0) {
        return;
      }
      
      // Determine if parens will need to be suggested in the diagnostic.
      boolean NeedParens = false;
      if (D.getNumTypeObjects() != 0) {
        switch (D.getTypeObject(D.getNumTypeObjects() - 1).Kind) {
         case Pointer:
         case Reference:
         case BlockPointer:
         case MemberPointer:
         case Pipe:
          NeedParens = true;
          break;
         case Array:
         case Function:
         case Paren:
          break;
        }
      }
      if (NeedParens) {
        ParsedAttributes attrs = null;
        try {
          // Create a DeclaratorChunk for the inserted parens.
          attrs/*J*/= new ParsedAttributes($this().AttrFactory);
          SourceLocation EndLoc = $this().PP.getLocForEndOfToken(D.getLocEnd());
          D.AddTypeInfo(DeclaratorChunk.getParen(new SourceLocation(SuggestParenLoc), new SourceLocation(EndLoc)), attrs, 
              new SourceLocation());
        } finally {
          if (attrs != null) { attrs.$destroy(); }
        }
      }
      
      // Adding back the bracket info to the end of the Declarator.
      for (/*uint*/int i = 0, e = TempDeclarator.getNumTypeObjects(); $less_uint(i, e); ++i) {
        ParsedAttributes attrs = null;
        try {
          final /*const*/ DeclaratorChunk /*&*/ Chunk = TempDeclarator.getTypeObject(i);
          attrs/*J*/= new ParsedAttributes($this().AttrFactory);
          attrs.set(Chunk.Unnamed_field3.Common.AttrList);
          D.AddTypeInfo(Chunk, attrs, new SourceLocation());
        } finally {
          if (attrs != null) { attrs.$destroy(); }
        }
      }
      
      // The missing identifier would have been diagnosed in ParseDirectDeclarator.
      // If parentheses are required, always suggest them.
      if (!(D.getIdentifier() != null) && !NeedParens) {
        return;
      }
      
      SourceLocation EndBracketLoc = TempDeclarator.getLocEnd();
      
      // Generate the move bracket error message.
      SourceRange BracketRange/*J*/= new SourceRange(/*NO_COPY*/StartBracketLoc, /*NO_COPY*/EndBracketLoc);
      SourceLocation EndLoc = $this().PP.getLocForEndOfToken(D.getLocEnd());
      if (NeedParens) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_uint($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_brackets_go_after_unqualified_id)), 
                              $this().getLangOpts().CPlusPlus), 
                          FixItHint.CreateInsertion(/*NO_COPY*/SuggestParenLoc, new StringRef(/*KEEP_STR*/$LPAREN))), 
                      FixItHint.CreateInsertion(/*NO_COPY*/EndLoc, new StringRef(/*KEEP_STR*/$RPAREN))), 
                  FixItHint.CreateInsertionFromRange(/*NO_COPY*/EndLoc, new CharSourceRange(/*NO_COPY*/BracketRange, true))), 
              FixItHint.CreateRemoval(/*NO_COPY*/BracketRange)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_uint($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_brackets_go_after_unqualified_id)), 
                      $this().getLangOpts().CPlusPlus), 
                  FixItHint.CreateInsertionFromRange(/*NO_COPY*/EndLoc, new CharSourceRange(/*NO_COPY*/BracketRange, true))), 
              FixItHint.CreateRemoval(/*NO_COPY*/BracketRange)));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (TempDeclarator != null) { TempDeclarator.$destroy(); }
    }
  }

} // END OF class Parser_ParseDecl
