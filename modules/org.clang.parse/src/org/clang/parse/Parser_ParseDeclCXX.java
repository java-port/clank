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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParseDeclCXXStatics.*;
import org.clang.sema.DeclaratorChunk.FunctionTypeInfo;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseDeclCXX">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseDecl ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser12ParseLinkageERNS_15ParsingDeclSpecEj;_ZN5clang6Parser14ParseNamespaceEjRNS_14SourceLocationES1_;_ZN5clang6Parser15ParseBaseClauseEPNS_4DeclE;_ZN5clang6Parser15PopParsingClassENS_4Sema23DelayedDiagnosticsStateE;_ZN5clang6Parser16PushParsingClassEPNS_4DeclEbb;_ZN5clang6Parser18ParseBaseSpecifierEPNS_4DeclE;_ZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeE;_ZN5clang6Parser19ParseInnerNamespaceERSt6vectorINS_14SourceLocationESaIS2_EERS1_IPNS_14IdentifierInfoESaIS7_EES5_jRS2_RNS_16ParsedAttributesERNS_24BalancedDelimiterTrackerE;_ZN5clang6Parser19ParseMemInitializerEPNS_4DeclE;_ZN5clang6Parser19ParseNamespaceAliasENS_14SourceLocationES1_PNS_14IdentifierInfoERS1_;_ZN5clang6Parser19ParseUsingDirectiveEjNS_14SourceLocationERS1_RNS_16ParsedAttributesE;_ZN5clang6Parser19SkipCXX11AttributesEv;_ZN5clang6Parser20ParseCXX11AttributesERNS0_25ParsedAttributesWithRangeEPNS_14SourceLocationE;_ZN5clang6Parser21ParseUsingDeclarationEjRKNS0_18ParsedTemplateInfoENS_14SourceLocationERS4_NS_15AccessSpecifierEPPNS_4DeclE;_ZN5clang6Parser22ParseBaseTypeSpecifierERNS_14SourceLocationES2_;_ZN5clang6Parser22ParseDecltypeSpecifierERNS_8DeclSpecE;_ZN5clang6Parser23DeallocateParsedClassesEPNS0_12ParsingClassE;_ZN5clang6Parser23ParseCXX11AttributeArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_;_ZN5clang6Parser23ParseTrailingReturnTypeERNS_11SourceRangeE;_ZN5clang6Parser24ParseMicrosoftAttributesERNS_16ParsedAttributesEPNS_14SourceLocationE;_ZN5clang6Parser25ParseCXXMemberInitializerEPNS_4DeclEbRNS_14SourceLocationE;_ZN5clang6Parser25isValidAfterTypeSpecifierEb;_ZN5clang6Parser26SkipCXXMemberSpecificationENS_14SourceLocationES1_jPNS_4DeclE;_ZN5clang6Parser27DiagnoseUnexpectedNamespaceEPNS_9NamedDeclE;_ZN5clang6Parser27ParseCXXMemberSpecificationENS_14SourceLocationES1_RNS0_25ParsedAttributesWithRangeEjPNS_4DeclE;_ZN5clang6Parser27ParseConstructorInitializerEPNS_4DeclE;_ZN5clang6Parser28ParseCXX11AttributeSpecifierERNS_16ParsedAttributesEPNS_14SourceLocationE;_ZN5clang6Parser28ParseStaticAssertDeclarationERNS_14SourceLocationE;_ZN5clang6Parser28ParseUnderlyingTypeSpecifierERNS_8DeclSpecE;_ZN5clang6Parser30DiagnoseAndSkipCXX11AttributesEv;_ZN5clang6Parser30HandleMemberFunctionDeclDelaysERNS_10DeclaratorEPNS_4DeclE;_ZN5clang6Parser30ParseCXXClassMemberDeclarationENS_15AccessSpecifierEPNS_13AttributeListERKNS0_18ParsedTemplateInfoEPNS_21ParsingDeclRAIIObjectE;_ZN5clang6Parser30tryParseExceptionSpecificationEbRNS_11SourceRangeERN4llvm15SmallVectorImplINS_9OpaquePtrINS_8QualTypeEEEEERNS4_IS1_EERNS_12ActionResultIPNS_4ExprELb1EEERPNS3_11SmallVectorINS_5TokenELj4EEE;_ZN5clang6Parser32ParseUsingDirectiveOrDeclarationEjRKNS0_18ParsedTemplateInfoERNS_14SourceLocationERNS0_25ParsedAttributesWithRangeEPPNS_4DeclE;_ZN5clang6Parser32TryParseCXX11AttributeIdentifierERNS_14SourceLocationE;_ZN5clang6Parser33AnnotateExistingDecltypeSpecifierERKNS_8DeclSpecENS_14SourceLocationES4_;_ZN5clang6Parser34ParseDynamicExceptionSpecificationERNS_11SourceRangeERN4llvm15SmallVectorImplINS_9OpaquePtrINS_8QualTypeEEEEERNS4_IS1_EE;_ZN5clang6Parser34ParseOptionalCXX11VirtSpecifierSeqERNS_14VirtSpecifiersEbNS_14SourceLocationE;_ZN5clang6Parser38ParseMicrosoftIfExistsClassDeclarationENS_17TypeSpecifierTypeERNS_15AccessSpecifierE;_ZN5clang6Parser40ParseMicrosoftInheritanceClassAttributesERNS_16ParsedAttributesE;_ZN5clang6Parser41ParseCXXClassMemberDeclarationWithPragmasERNS_15AccessSpecifierERNS0_25ParsedAttributesWithRangeENS_17TypeSpecifierTypeEPNS_4DeclE;_ZN5clang6Parser41ParseCXXMemberDeclaratorBeforeInitializerERNS_10DeclaratorERNS_14VirtSpecifiersERNS_12ActionResultIPNS_4ExprELb1EEERNS0_18LateParsedAttrListE;_ZN5clang6Parser55MaybeParseAndDiagnoseDeclSpecAfterCXX11VirtSpecifierSeqERNS_10DeclaratorERNS_14VirtSpecifiersE;_ZNK5clang6Parser19isCXX11FinalKeywordEv;_ZNK5clang6Parser20isCXX11VirtSpecifierERKNS_5TokenE;_ZNK5clang6Parser27getAccessSpecifierIfPresentEv; -static-type=Parser_ParseDeclCXX -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseDeclCXX extends Parser_ParseDecl {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// \brief We have just started parsing the definition of a new class,
/// so push that class onto our stack of classes that is currently
/// being parsed.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::PushParsingClass">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3546,
   FQN="clang::Parser::PushParsingClass", NM="_ZN5clang6Parser16PushParsingClassEPNS_4DeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser16PushParsingClassEPNS_4DeclEbb")
  //</editor-fold>
  protected /*private*/ Sema.DelayedDiagnosticsState PushParsingClass(Decl /*P*/ ClassDecl, boolean NonNestedClass, 
                  boolean IsInterface) {
    assert ((NonNestedClass || !$this().ClassStack.empty())) : "Nested class without outer class";
    $this().ClassStack.push_value_type(new ParsingClass(ClassDecl, NonNestedClass, IsInterface));
    return $this().Actions.PushParsingClass();
  }


/// \brief Deallocate the given parsed class and all of its nested
/// classes.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::DeallocateParsedClasses">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3557,
   FQN="clang::Parser::DeallocateParsedClasses", NM="_ZN5clang6Parser23DeallocateParsedClassesEPNS0_12ParsingClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser23DeallocateParsedClassesEPNS0_12ParsingClassE")
  //</editor-fold>
  protected /*private*/ void DeallocateParsedClasses(Parser.ParsingClass /*P*/ Class) {
    for (/*uint*/int I = 0, N = Class.LateParsedDeclarations.size(); I != N; ++I)  {
      if (Class.LateParsedDeclarations.$at(I) != null) { Class.LateParsedDeclarations.$at(I).$destroy();};
    }
    if (Class != null) { Class.$destroy();};
  }


/// \brief Pop the top class of the stack of classes that are
/// currently being parsed.
///
/// This routine should be called when we have finished parsing the
/// definition of a class, but have not yet popped the Scope
/// associated with the class's definition.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::PopParsingClass">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3569,
   FQN="clang::Parser::PopParsingClass", NM="_ZN5clang6Parser15PopParsingClassENS_4Sema23DelayedDiagnosticsStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser15PopParsingClassENS_4Sema23DelayedDiagnosticsStateE")
  //</editor-fold>
  protected /*private*/ void PopParsingClass(Sema.DelayedDiagnosticsState state) {
    assert (!$this().ClassStack.empty()) : "Mismatched push/pop for class parsing";
    
    $this().Actions.PopParsingClass(new Sema.DelayedDiagnosticsState(state));
    
    ParsingClass /*P*/ Victim = $this().ClassStack.top();
    $this().ClassStack.pop();
    if (Victim.TopLevelClass) {
      // Deallocate all of the nested classes of this class,
      // recursively: we don't need to keep any of this information.
      $this().DeallocateParsedClasses(Victim);
      return;
    }
    assert (!$this().ClassStack.empty()) : "Missing top-level class?";
    if (Victim.LateParsedDeclarations.empty()) {
      // The victim is a nested class, but we will not need to perform
      // any processing after the definition of this class since it has
      // no members whose handling was delayed. Therefore, we can just
      // remove this nested class.
      $this().DeallocateParsedClasses(Victim);
      return;
    }
    
    // This nested class has some members that will need to be processed
    // after the top-level class is completely defined. Therefore, add
    // it to the list of nested classes within its parent.
    assert ($this().getCurScope().isClassScope()) : "Nested class outside of class scope?";
    $this().ClassStack.top().LateParsedDeclarations.push_back(new LateParsedClass($this(), Victim));
    Victim.TemplateScope = $this().getCurScope().getParent().isTemplateParamScope();
  }


/// \brief Parse a C++ exception-specification if present (C++0x [except.spec]).
///
///       exception-specification:
///         dynamic-exception-specification
///         noexcept-specification
///
///       noexcept-specification:
///         'noexcept'
///         'noexcept' '(' constant-expression ')'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::tryParseExceptionSpecification">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3346,
   FQN="clang::Parser::tryParseExceptionSpecification", NM="_ZN5clang6Parser30tryParseExceptionSpecificationEbRNS_11SourceRangeERN4llvm15SmallVectorImplINS_9OpaquePtrINS_8QualTypeEEEEERNS4_IS1_EERNS_12ActionResultIPNS_4ExprELb1EEERPNS3_11SmallVectorINS_5TokenELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser30tryParseExceptionSpecificationEbRNS_11SourceRangeERN4llvm15SmallVectorImplINS_9OpaquePtrINS_8QualTypeEEEEERNS4_IS1_EERNS_12ActionResultIPNS_4ExprELb1EEERPNS3_11SmallVectorINS_5TokenELj4EEE")
  //</editor-fold>
  protected /*private*/ ExceptionSpecificationType tryParseExceptionSpecification(boolean Delayed, 
                                final SourceRange /*&*/ SpecificationRange, 
                                final SmallVectorImpl<OpaquePtr<QualType> > /*&*/ DynamicExceptions, 
                                final SmallVectorImpl<SourceRange> /*&*/ DynamicExceptionRanges, 
                                final ActionResultTTrue<Expr /*P*/ > /*&*/ NoexceptExpr, 
                                final type$ref<SmallVectorToken/*P*/>/*&*/ /*P*/ /*&*/ ExceptionSpecTokens) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ExceptionSpecificationType Result = ExceptionSpecificationType.EST_None;
      ExceptionSpecTokens.$set(null);
      
      // Handle delayed parsing of exception-specifications.
      if (Delayed) {
        if ($this().Tok.isNot(tok.TokenKind.kw_throw) && $this().Tok.isNot(tok.TokenKind.kw_noexcept)) {
          return ExceptionSpecificationType.EST_None;
        }
        
        // Consume and cache the starting token.
        boolean IsNoexcept = $this().Tok.is(tok.TokenKind.kw_noexcept);
        Token StartTok = new Token($this().Tok);
        SpecificationRange.$assignMove(new SourceRange($this().ConsumeToken()));
        
        // Check for a '('.
        if (!$this().Tok.is(tok.TokenKind.l_paren)) {
          // If this is a bare 'noexcept', we're done.
          if (IsNoexcept) {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_noexcept_decl)));
            NoexceptExpr.$assign((Expr /*P*/ )null);
            return ExceptionSpecificationType.EST_BasicNoexcept;
          }
          
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$throw));
          return ExceptionSpecificationType.EST_DynamicNone;
        }
        
        // Cache the tokens for the exception-specification.
        ExceptionSpecTokens.$set(new SmallVectorToken(4, /*PERF: new Token()*/null));
        ExceptionSpecTokens.$deref().push_back(StartTok); // 'throw' or 'noexcept'
        ExceptionSpecTokens.$deref().push_back($this().Tok); // '('
        SpecificationRange.setEnd($this().ConsumeParen()); // '('
        
        $this().ConsumeAndStoreUntil(tok.TokenKind.r_paren, $Deref(ExceptionSpecTokens.$deref()), 
            /*StopAtSemi=*/ true, 
            /*ConsumeFinalToken=*/ true);
        SpecificationRange.setEnd(ExceptionSpecTokens.$deref().back().getLocation());
        
        return ExceptionSpecificationType.EST_Unparsed;
      }
      
      // See if there's a dynamic specification.
      if ($this().Tok.is(tok.TokenKind.kw_throw)) {
        Result = $this().ParseDynamicExceptionSpecification(SpecificationRange, 
            DynamicExceptions, 
            DynamicExceptionRanges);
        assert (DynamicExceptions.size() == DynamicExceptionRanges.size()) : "Produced different number of exception types and ranges.";
      }
      
      // If there's no noexcept specification, we're done.
      if ($this().Tok.isNot(tok.TokenKind.kw_noexcept)) {
        return Result;
      }
      
      $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_noexcept_decl)));
      
      // If we already had a dynamic specification, parse the noexcept for,
      // recovery, but emit a diagnostic and don't store the results.
      SourceRange NoexceptRange/*J*/= new SourceRange();
      ExceptionSpecificationType NoexceptType = ExceptionSpecificationType.EST_None;
      
      SourceLocation KeywordLoc = $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.l_paren)) {
        BalancedDelimiterTracker T = null;
        try {
          // There is an argument.
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          T.consumeOpen();
          NoexceptType = ExceptionSpecificationType.EST_ComputedNoexcept;
          NoexceptExpr.$assignMove($this().ParseConstantExpression());
          T.consumeClose();
          // The argument must be contextually convertible to bool. We use
          // CheckBooleanCondition for this purpose.
          // FIXME: Add a proper Sema entry point for this.
          if (!NoexceptExpr.isInvalid()) {
            NoexceptExpr.$assignMove(
                $this().Actions.CheckBooleanCondition(new SourceLocation(KeywordLoc), NoexceptExpr.get())
            );
            NoexceptRange.$assignMove(new SourceRange(/*NO_COPY*/KeywordLoc, T.getCloseLocation()));
          } else {
            NoexceptType = ExceptionSpecificationType.EST_None;
          }
        } finally {
          if (T != null) { T.$destroy(); }
        }
      } else {
        // There is no argument.
        NoexceptType = ExceptionSpecificationType.EST_BasicNoexcept;
        NoexceptRange.$assignMove(new SourceRange(/*NO_COPY*/KeywordLoc, /*NO_COPY*/KeywordLoc));
      }
      if (Result == ExceptionSpecificationType.EST_None) {
        SpecificationRange.$assign(NoexceptRange);
        Result = NoexceptType;
        
        // If there's a dynamic specification after a noexcept specification,
        // parse that and ignore the results.
        if ($this().Tok.is(tok.TokenKind.kw_throw)) {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_dynamic_and_noexcept_specification)));
          $this().ParseDynamicExceptionSpecification(NoexceptRange, DynamicExceptions, 
              DynamicExceptionRanges);
        }
      } else {
        $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_dynamic_and_noexcept_specification)));
      }
      
      return Result;
    } finally {
      $c$.$destroy();
    }
  }


// EndLoc is filled with the location of the last token of the specification.

/// ParseDynamicExceptionSpecification - Parse a C++
/// dynamic-exception-specification (C++ [except.spec]).
///
///       dynamic-exception-specification:
///         'throw' '(' type-id-list [opt] ')'
/// [MS]    'throw' '(' '...' ')'
///
///       type-id-list:
///         type-id ... [opt]
///         type-id-list ',' type-id ... [opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDynamicExceptionSpecification">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3476,
   FQN="clang::Parser::ParseDynamicExceptionSpecification", NM="_ZN5clang6Parser34ParseDynamicExceptionSpecificationERNS_11SourceRangeERN4llvm15SmallVectorImplINS_9OpaquePtrINS_8QualTypeEEEEERNS4_IS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser34ParseDynamicExceptionSpecificationERNS_11SourceRangeERN4llvm15SmallVectorImplINS_9OpaquePtrINS_8QualTypeEEEEERNS4_IS1_EE")
  //</editor-fold>
  protected /*private*/ ExceptionSpecificationType ParseDynamicExceptionSpecification(final SourceRange /*&*/ SpecificationRange, 
                                    final SmallVectorImpl<OpaquePtr<QualType> > /*&*/ Exceptions, 
                                    final SmallVectorImpl<SourceRange> /*&*/ Ranges) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_throw)) : "expected throw";
      
      SpecificationRange.setBegin($this().ConsumeToken());
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok, diag.err_expected_lparen_after)), /*KEEP_STR*/$throw));
          SpecificationRange.setEnd(SpecificationRange.getBegin());
          return ExceptionSpecificationType.EST_DynamicNone;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse throw(...), a Microsoft extension that means "this function
      // can throw anything".
      if ($this().Tok.is(tok.TokenKind.ellipsis)) {
        SourceLocation EllipsisLoc = $this().ConsumeToken();
        if (!$this().getLangOpts().MicrosoftExt) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(EllipsisLoc), diag.ext_ellipsis_exception_spec)));
          } finally {
            $c$.$destroy();
          }
        }
        T.consumeClose();
        SpecificationRange.setEnd(T.getCloseLocation());
        diagnoseDynamicExceptionSpecification(/*Deref*/$this(), new SourceRange(SpecificationRange), false);
        return ExceptionSpecificationType.EST_MSAny;
      }
      
      // Parse the sequence of type-ids.
      SourceRange Range/*J*/= new SourceRange();
      while ($this().Tok.isNot(tok.TokenKind.r_paren)) {
        ActionResult<OpaquePtr<QualType> > Res/*J*/= $this().ParseTypeName($AddrOf(Range));
        if ($this().Tok.is(tok.TokenKind.ellipsis)) {
          // C++0x [temp.variadic]p5:
          //   - In a dynamic-exception-specification (15.4); the pattern is a 
          //     type-id.
          SourceLocation Ellipsis = $this().ConsumeToken();
          Range.setEnd(/*NO_COPY*/Ellipsis);
          if (!Res.isInvalid()) {
            Res.$assignMove($this().Actions.ActOnPackExpansion(Res.get(), new SourceLocation(Ellipsis)));
          }
        }
        if (!Res.isInvalid()) {
          Exceptions.push_back(Res.get());
          Ranges.push_back(Range);
        }
        if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
          break;
        }
      }
      
      T.consumeClose();
      SpecificationRange.setEnd(T.getCloseLocation());
      diagnoseDynamicExceptionSpecification(/*Deref*/$this(), new SourceRange(SpecificationRange), 
          Exceptions.empty());
      return Exceptions.empty() ? ExceptionSpecificationType.EST_DynamicNone : ExceptionSpecificationType.EST_Dynamic;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// C++0x 8: Function declaration trailing-return-type

/// ParseTrailingReturnType - Parse a trailing return type on a new-style
/// function declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseTrailingReturnType">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3535,
   FQN="clang::Parser::ParseTrailingReturnType", NM="_ZN5clang6Parser23ParseTrailingReturnTypeERNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser23ParseTrailingReturnTypeERNS_11SourceRangeE")
  //</editor-fold>
  protected /*private*/ ActionResult<OpaquePtr<QualType> > ParseTrailingReturnType(final SourceRange /*&*/ Range) {
    assert ($this().Tok.is(tok.TokenKind.arrow)) : "expected arrow";
    
    $this().ConsumeToken();
    
    return $this().ParseTypeName($AddrOf(Range), Declarator.TheContext.TrailingReturnContext);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftIfExistsClassDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3939,
   FQN="clang::Parser::ParseMicrosoftIfExistsClassDeclaration", NM="_ZN5clang6Parser38ParseMicrosoftIfExistsClassDeclarationENS_17TypeSpecifierTypeERNS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser38ParseMicrosoftIfExistsClassDeclarationENS_17TypeSpecifierTypeERNS_15AccessSpecifierE")
  //</editor-fold>
  protected /*private*/ void ParseMicrosoftIfExistsClassDeclaration(TypeSpecifierType TagType, 
                                        final type$ref<AccessSpecifier> /*&*/ CurAS) {
    IfExistsCondition Result = null;
    BalancedDelimiterTracker Braces = null;
    try {
      Result/*J*/= new IfExistsCondition();
      if ($this().ParseMicrosoftIfExistsCondition(Result)) {
        return;
      }
      
      Braces/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      if (Braces.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      switch (Result.Behavior) {
       case IEB_Parse:
        // Parse the declarations below.
        break;
       case IEB_Dependent:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out$Same2Bool($c$.track($this().Diag(new SourceLocation(Result.KeywordLoc), diag.warn_microsoft_dependent_exists)), 
                Result.IsIfExists));
          } finally {
            $c$.$destroy();
          }
        }
       case IEB_Skip:
        // Fall through to skip.
        Braces.skipToEnd();
        return;
      }
      while ($this().Tok.isNot(tok.TokenKind.r_brace) && !$this().isEofOrEom()) {
        // __if_exists, __if_not_exists can nest.
        if ($this().Tok.isOneOf(tok.TokenKind.kw___if_exists, tok.TokenKind.kw___if_not_exists)) {
          $this().ParseMicrosoftIfExistsClassDeclaration(TagType, CurAS);
          continue;
        }
        
        // Check for extraneous top-level semicolon.
        if ($this().Tok.is(tok.TokenKind.semi)) {
          $this().ConsumeExtraSemi(ExtraSemiKind.InsideStruct, TagType.getValue());
          continue;
        }
        
        AccessSpecifier AS = $this().getAccessSpecifierIfPresent();
        if (AS != AccessSpecifier.AS_none) {
          // Current token is a C++ access specifier.
          CurAS.$set(AS);
          SourceLocation ASLoc = $this().Tok.getLocation();
          $this().ConsumeToken();
          if ($this().Tok.is(tok.TokenKind.colon)) {
            $this().Actions.ActOnAccessSpecifier(AS, new SourceLocation(ASLoc), $this().Tok.getLocation());
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.colon));
            } finally {
              $c$.$destroy();
            }
          }
          $this().ConsumeToken();
          continue;
        }
        
        // Parse all the comma separated declarators.
        $this().ParseCXXClassMemberDeclaration(CurAS.$deref(), (AttributeList /*P*/ )null);
      }
      
      Braces.consumeClose();
    } finally {
      if (Braces != null) { Braces.$destroy(); }
      if (Result != null) { Result.$destroy(); }
    }
  }


/// \brief Skip C++11 attributes and return the end location of the last one.
/// \returns SourceLocation() if there are no attributes.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipCXX11Attributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3891,
   FQN="clang::Parser::SkipCXX11Attributes", NM="_ZN5clang6Parser19SkipCXX11AttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser19SkipCXX11AttributesEv")
  //</editor-fold>
  protected /*private*/ SourceLocation SkipCXX11Attributes() {
    SourceLocation EndLoc/*J*/= new SourceLocation();
    if (!($this().isCXX11AttributeSpecifier().getValue() != 0)) {
      return EndLoc;
    }
    
    do {
      if ($this().Tok.is(tok.TokenKind.l_square)) {
        BalancedDelimiterTracker T = null;
        try {
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
          T.consumeOpen();
          T.skipToEnd();
          EndLoc.$assignMove(T.getCloseLocation());
        } finally {
          if (T != null) { T.$destroy(); }
        }
      } else {
        BalancedDelimiterTracker T = null;
        try {
          assert ($this().Tok.is(tok.TokenKind.kw_alignas)) : "not an attribute specifier";
          $this().ConsumeToken();
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          if (!T.consumeOpen()) {
            T.skipToEnd();
          }
          EndLoc.$assignMove(T.getCloseLocation());
        } finally {
          if (T != null) { T.$destroy(); }
        }
      }
    } while (($this().isCXX11AttributeSpecifier().getValue() != 0));
    
    return EndLoc;
  }


/// \brief Diagnose and skip C++11 attributes that appear in syntactic
/// locations where attributes are not allowed.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseAndSkipCXX11Attributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3879,
   FQN="clang::Parser::DiagnoseAndSkipCXX11Attributes", NM="_ZN5clang6Parser30DiagnoseAndSkipCXX11AttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser30DiagnoseAndSkipCXX11AttributesEv")
  //</editor-fold>
  protected /*private*/ void DiagnoseAndSkipCXX11Attributes() {
    // Start and end location of an attribute or an attribute list.
    SourceLocation StartLoc = $this().Tok.getLocation();
    SourceLocation EndLoc = $this().SkipCXX11Attributes();
    if (EndLoc.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceRange Range/*J*/= new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/EndLoc);
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_attributes_not_allowed)), 
            /*NO_COPY*/Range));
      } finally {
        $c$.$destroy();
      }
    }
  }


/// ParseCXX11AttributeSpecifier - Parse a C++11 attribute-specifier.
///
/// [C++11] attribute-specifier:
///         '[' '[' attribute-list ']' ']'
///         alignment-specifier
///
/// [C++11] attribute-list:
///         attribute[opt]
///         attribute-list ',' attribute[opt]
///         attribute '...'
///         attribute-list ',' attribute '...'
///
/// [C++11] attribute:
///         attribute-token attribute-argument-clause[opt]
///
/// [C++11] attribute-token:
///         identifier
///         attribute-scoped-token
///
/// [C++11] attribute-scoped-token:
///         attribute-namespace '::' identifier
///
/// [C++11] attribute-namespace:
///         identifier
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXX11AttributeSpecifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3757,
   FQN="clang::Parser::ParseCXX11AttributeSpecifier", NM="_ZN5clang6Parser28ParseCXX11AttributeSpecifierERNS_16ParsedAttributesEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser28ParseCXX11AttributeSpecifierERNS_16ParsedAttributesEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseCXX11AttributeSpecifier(final ParsedAttributes /*&*/ attrs) {
    $this().ParseCXX11AttributeSpecifier(attrs, 
                              (SourceLocation /*P*/ )null);
  }
  protected /*private*/ void ParseCXX11AttributeSpecifier(final ParsedAttributes /*&*/ attrs, 
                              final SourceLocation /*P*/ endLoc/*= null*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if ($this().Tok.is(tok.TokenKind.kw_alignas)) {
        $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.warn_cxx98_compat_alignas)));
        $this().ParseAlignmentSpecifier(attrs, endLoc);
        return;
      }
      assert ($this().Tok.is(tok.TokenKind.l_square) && $this().NextToken().is(tok.TokenKind.l_square)) : "Not a C++11 attribute list";
      
      $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.warn_cxx98_compat_attribute)));
      
      $this().ConsumeBracket();
      $this().ConsumeBracket();
      
      SourceLocation CommonScopeLoc/*J*/= new SourceLocation();
      IdentifierInfo /*P*/ CommonScopeName = null;
      if ($this().Tok.is(tok.TokenKind.kw_using)) {
        $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), $this().getLangOpts().CPlusPlus1z ? diag.warn_cxx14_compat_using_attribute_ns : diag.ext_using_attribute_ns)));
        $this().ConsumeToken();
        
        CommonScopeName = $this().TryParseCXX11AttributeIdentifier(CommonScopeLoc);
        if (!(CommonScopeName != null)) {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.identifier));
          $this().SkipUntil(tok.TokenKind.r_square, tok.TokenKind.colon, SkipUntilFlags.StopBeforeMatch);
        }
        if (!$this().TryConsumeToken(tok.TokenKind.colon) && (CommonScopeName != null)) {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.colon));
        }
      }
      
      SmallDenseMap<IdentifierInfo /*P*/ , SourceLocation> SeenAttrs/*J*/= new SmallDenseMap<IdentifierInfo /*P*/ , SourceLocation>(DenseMapInfo$LikePtr.$Info(), 4, new SourceLocation());
      while ($this().Tok.isNot(tok.TokenKind.r_square)) {
        // attribute not present
        if ($this().TryConsumeToken(tok.TokenKind.comma)) {
          continue;
        }
        
        SourceLocation ScopeLoc/*J*/= new SourceLocation(), AttrLoc/*J*/= new SourceLocation();
        IdentifierInfo /*P*/ ScopeName = null, /*P*/ AttrName = null;
        
        AttrName = $this().TryParseCXX11AttributeIdentifier(AttrLoc);
        if (!(AttrName != null)) {
          // Break out to the "expected ']'" diagnostic.
          break;
        }
        
        // scoped attribute
        if ($this().TryConsumeToken(tok.TokenKind.coloncolon)) {
          ScopeName = AttrName;
          ScopeLoc.$assign(AttrLoc);
          
          AttrName = $this().TryParseCXX11AttributeIdentifier(AttrLoc);
          if (!(AttrName != null)) {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected)), tok.TokenKind.identifier));
            $this().SkipUntil(tok.TokenKind.r_square, tok.TokenKind.comma, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            continue;
          }
        }
        if ((CommonScopeName != null)) {
          if ((ScopeName != null)) {
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(ScopeLoc), diag.err_using_attribute_ns_conflict)), 
                new SourceRange(/*NO_COPY*/CommonScopeLoc)));
          } else {
            ScopeName = CommonScopeName;
            ScopeLoc.$assign(CommonScopeLoc);
          }
        }
        
        boolean StandardAttr = IsBuiltInOrStandardCXX11Attribute(AttrName, ScopeName);
        boolean AttrParsed = false;
        if (StandardAttr
           && !SeenAttrs.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(AttrName, AttrLoc)).second) {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_cxx11_attribute_repeated)), 
                  AttrName), new SourceRange(/*NO_COPY*/SeenAttrs.$at_T1$C$R(AttrName))));
        }
        
        // Parse attribute arguments
        if ($this().Tok.is(tok.TokenKind.l_paren)) {
          AttrParsed = $this().ParseCXX11AttributeArgs(AttrName, new SourceLocation(AttrLoc), attrs, endLoc, 
              ScopeName, new SourceLocation(ScopeLoc));
        }
        if (!AttrParsed) {
          attrs.addNew(AttrName, 
              new SourceRange(/*NO_COPY*/ScopeLoc.isValid() ? ScopeLoc : AttrLoc, 
                  /*NO_COPY*/AttrLoc), 
              ScopeName, new SourceLocation(ScopeLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, AttributeList.Syntax.AS_CXX11);
        }
        if ($this().TryConsumeToken(tok.TokenKind.ellipsis)) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track($this().Diag($this().Tok, diag.err_cxx11_attribute_forbids_ellipsis)), 
              AttrName.getName()));
        }
      }
      if ($this().ExpectAndConsume(tok.TokenKind.r_square)) {
        $this().SkipUntil(tok.TokenKind.r_square);
      }
      if ((endLoc != null)) {
        endLoc.$assignMove($this().Tok.getLocation());
      }
      if ($this().ExpectAndConsume(tok.TokenKind.r_square)) {
        $this().SkipUntil(tok.TokenKind.r_square);
      }
    } finally {
      $c$.$destroy();
    }
  }


/// ParseCXX11Attributes - Parse a C++11 attribute-specifier-seq.
///
/// attribute-specifier-seq:
///       attribute-specifier-seq[opt] attribute-specifier
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXX11Attributes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3864,
   FQN="clang::Parser::ParseCXX11Attributes", NM="_ZN5clang6Parser20ParseCXX11AttributesERNS0_25ParsedAttributesWithRangeEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser20ParseCXX11AttributesERNS0_25ParsedAttributesWithRangeEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseCXX11Attributes(final ParsedAttributesWithRange /*&*/ attrs) {
    $this().ParseCXX11Attributes(attrs, 
                      (SourceLocation /*P*/ )null);
  }
  protected /*private*/ void ParseCXX11Attributes(final ParsedAttributesWithRange /*&*/ attrs, 
                      final SourceLocation /*P*/ endLoc/*= null*/) {
    assert ($this().getLangOpts().CPlusPlus11);
    
    SourceLocation StartLoc = $this().Tok.getLocation(), Loc/*J*/= new SourceLocation();
    final SourceLocation $endLoc;//JAVA
    if (endLoc == null) {
      $endLoc = $AddrOf(Loc);
    } else {
      $endLoc = endLoc;
    }
    
    do {
      $this().ParseCXX11AttributeSpecifier(attrs, $endLoc);
    } while (($this().isCXX11AttributeSpecifier().getValue() != 0));
    attrs.Range.$assignMove(new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/$endLoc));
  }

/// \brief Parses a C++-style attribute argument list. Returns true if this
/// results in adding an attribute to the ParsedAttributes list.

/// ParseCXX11AttributeArgs -- Parse a C++11 attribute-argument-clause.
///
/// [C++11] attribute-argument-clause:
///         '(' balanced-token-seq ')'
///
/// [C++11] balanced-token-seq:
///         balanced-token
///         balanced-token-seq balanced-token
///
/// [C++11] balanced-token:
///         '(' balanced-token-seq ')'
///         '[' balanced-token-seq ']'
///         '{' balanced-token-seq '}'
///         any token but '(', ')', '[', ']', '{', or '}'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXX11AttributeArgs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3679,
   FQN="clang::Parser::ParseCXX11AttributeArgs", NM="_ZN5clang6Parser23ParseCXX11AttributeArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser23ParseCXX11AttributeArgsEPNS_14IdentifierInfoENS_14SourceLocationERNS_16ParsedAttributesEPS3_S2_S3_")
  //</editor-fold>
  protected /*private*/ boolean ParseCXX11AttributeArgs(IdentifierInfo /*P*/ AttrName, 
                         SourceLocation AttrNameLoc, 
                         final ParsedAttributes /*&*/ Attrs, 
                         final SourceLocation /*P*/ EndLoc, 
                         IdentifierInfo /*P*/ ScopeName, 
                         SourceLocation ScopeLoc) {
    assert ($this().Tok.is(tok.TokenKind.l_paren)) : "Not a C++11 attribute argument list";
    SourceLocation LParenLoc = $this().Tok.getLocation();
    
    // If the attribute isn't known, we will not attempt to parse any
    // arguments.
    if (!(hasAttribute(AttrSyntax.CXX, ScopeName, AttrName, 
        $this().getTargetInfo(), $this().getLangOpts()) != 0)) {
      // Eat the left paren, then skip to the ending right paren.
      $this().ConsumeParen();
      $this().SkipUntil(tok.TokenKind.r_paren);
      return false;
    }
    if ((ScopeName != null) && $eq_StringRef(ScopeName.getName(), /*STRINGREF_STR*/"gnu")) {
      // GNU-scoped attributes have some special cases to handle GNU-specific
      // behaviors.
      $this().ParseGNUAttributeArgs(AttrName, new SourceLocation(AttrNameLoc), Attrs, EndLoc, ScopeName, 
          new SourceLocation(ScopeLoc), AttributeList.Syntax.AS_CXX11, (Declarator /*P*/ )null);
    } else {
      /*uint*/int NumArgs = $this().ParseAttributeArgsCommon(AttrName, new SourceLocation(AttrNameLoc), Attrs, EndLoc, 
          ScopeName, new SourceLocation(ScopeLoc), AttributeList.Syntax.AS_CXX11);
      
      /*const*/ AttributeList /*P*/ Attr = Attrs.getList();
      if ((Attr != null) && IsBuiltInOrStandardCXX11Attribute(AttrName, ScopeName)) {
        // If the attribute is a standard or built-in attribute and we are
        // parsing an argument list, we need to determine whether this attribute
        // was allowed to have an argument list (such as [[deprecated]]), and how
        // many arguments were parsed (so we can diagnose on [[deprecated()]]).
        if ((Attr.getMaxArgs() != 0) && !(NumArgs != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // The attribute was allowed to have arguments, but none were provided
            // even though the attribute parsed successfully. This is an error.
            $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_attribute_requires_arguments)), AttrName));
            Attr.setInvalid(true);
          } finally {
            $c$.$destroy();
          }
        } else if (!(Attr.getMaxArgs() != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // The attribute parsed successfully, but was not allowed to have any
            // arguments. It doesn't matter whether any were provided -- the
            // presence of the argument list (even if empty) is diagnosed.
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_cxx11_attribute_forbids_arguments)), 
                    AttrName), 
                FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/EndLoc))));
            Attr.setInvalid(true);
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    return true;
  }


/// \brief Try to parse an 'identifier' which appears within an attribute-token.
///
/// \return the parsed identifier on success, and 0 if the next token is not an
/// attribute-token.
///
/// C++11 [dcl.attr.grammar]p3:
///   If a keyword or an alternative token that satisfies the syntactic
///   requirements of an identifier is contained in an attribute-token,
///   it is considered an identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TryParseCXX11AttributeIdentifier">
@Converted(kind = Converted.Kind.MANUAL/*PERF*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3610,
   FQN="clang::Parser::TryParseCXX11AttributeIdentifier", NM="_ZN5clang6Parser32TryParseCXX11AttributeIdentifierERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser32TryParseCXX11AttributeIdentifierERNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ IdentifierInfo /*P*/ TryParseCXX11AttributeIdentifier(final SourceLocation /*&*/ Loc) {
    switch ($this().Tok.getKind()) {
     default:
      // Identifiers and keywords have identifier info attached.
      if (!$this().Tok.isAnnotation()) {
        {
          IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
          if ((II != null)) {
            Loc.$assignMove($this().ConsumeToken());
            return II;
          }
        }
      }
      return null;
     case tok.TokenKind.ampamp: // 'and'
     case tok.TokenKind.pipe: // 'bitor'
     case tok.TokenKind.pipepipe: // 'or'
     case tok.TokenKind.caret: // 'xor'
     case tok.TokenKind.tilde: // 'compl'
     case tok.TokenKind.amp: // 'bitand'
     case tok.TokenKind.ampequal: // 'and_eq'
     case tok.TokenKind.pipeequal: // 'or_eq'
     case tok.TokenKind.caretequal: // 'xor_eq'
     case tok.TokenKind.exclaim: // 'not'
     case tok.TokenKind.exclaimequal: // 'not_eq'
      // Alternative tokens do not have identifier info, but their spelling
      // starts with an alphabetical character.
      SmallString/*8*/ SpellingBuf/*J*/= new SmallString/*8*/(8);
      SourceLocation SpellingLoc = $this().PP.getSourceManager().getSpellingLoc($this().Tok.getLocation());
      StringRef Spelling = $this().PP.getSpelling(new SourceLocation(SpellingLoc), SpellingBuf);
      if (isLetter(Spelling.$at(0))) {
        Loc.$assignMove($this().ConsumeToken());
        char$ptr $data = Spelling.data(); // JAVA PERF
        return $AddrOf($this().PP.getIdentifierTable().get(/*NO_COPY*/$data.$array(), $data.$index(), Spelling.size()));
      }
      return null;
    }
  }


/// ParseMicrosoftAttributes - Parse Microsoft attributes [Attr]
///
/// [MS] ms-attribute:
///             '[' token-seq ']'
///
/// [MS] ms-attribute-seq:
///             ms-attribute[opt]
///             ms-attribute ms-attribute-seq
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftAttributes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*endLoc as final pointer*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3924,
   FQN="clang::Parser::ParseMicrosoftAttributes", NM="_ZN5clang6Parser24ParseMicrosoftAttributesERNS_16ParsedAttributesEPNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser24ParseMicrosoftAttributesERNS_16ParsedAttributesEPNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseMicrosoftAttributes(final ParsedAttributes /*&*/ attrs) {
    $this().ParseMicrosoftAttributes(attrs, 
                          (SourceLocation /*P*/ )null);
  }
  protected /*private*/ void ParseMicrosoftAttributes(final ParsedAttributes /*&*/ attrs, 
                          final SourceLocation /*P*/ endLoc/*= null*/) {
    assert ($this().Tok.is(tok.TokenKind.l_square)) : "Not a Microsoft attribute list";
    
    do {
      BalancedDelimiterTracker T = null;
      try {
        // FIXME: If this is actually a C++11 attribute, parse it as one.
        T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
        T.consumeOpen();
        $this().SkipUntil(tok.TokenKind.r_square, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
        T.consumeClose();
        if ((endLoc != null)) {
          endLoc.$assignMove(T.getCloseLocation());
        }
      } finally {
        if (T != null) { T.$destroy(); }
      }
    } while ($this().Tok.is(tok.TokenKind.l_square));
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftInheritanceClassAttributes">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1067,
   FQN="clang::Parser::ParseMicrosoftInheritanceClassAttributes", NM="_ZN5clang6Parser40ParseMicrosoftInheritanceClassAttributesERNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser40ParseMicrosoftInheritanceClassAttributesERNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ void ParseMicrosoftInheritanceClassAttributes(final ParsedAttributes /*&*/ attrs) {
    while ($this().Tok.isOneOf$T(tok.TokenKind.kw___single_inheritance, 
        tok.TokenKind.kw___multiple_inheritance, 
        tok.TokenKind.kw___virtual_inheritance)) {
      IdentifierInfo /*P*/ AttrName = $this().Tok.getIdentifierInfo();
      SourceLocation AttrNameLoc = $this().ConsumeToken();
      attrs.addNew(AttrName, new SourceRange(/*NO_COPY*/AttrNameLoc), (IdentifierInfo /*P*/ )null, new SourceLocation(AttrNameLoc), (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, 
          AttributeList.Syntax.AS_Keyword);
    }
  }


/// ParseDecltypeSpecifier - Parse a C++11 decltype specifier.
///
/// 'decltype' ( expression )
/// 'decltype' ( 'auto' )      [C++1y]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseDecltypeSpecifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*GO TO*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 763,
   FQN="clang::Parser::ParseDecltypeSpecifier", NM="_ZN5clang6Parser22ParseDecltypeSpecifierERNS_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser22ParseDecltypeSpecifierERNS_8DeclSpecE")
  //</editor-fold>
  protected /*private*/ SourceLocation ParseDecltypeSpecifier(final DeclSpec /*&*/ DS) {
    assert ($this().Tok.isOneOf(tok.TokenKind.kw_decltype, tok.TokenKind.annot_decltype)) : "Not a decltype specifier";
    
    ActionResultTTrue<Expr /*P*/ > Result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    SourceLocation StartLoc = $this().Tok.getLocation();
    SourceLocation EndLoc/*J*/= new SourceLocation();
    if ($this().Tok.is(tok.TokenKind.annot_decltype)) {
      Result.$assignMove(getExprAnnotation($this().Tok));
      EndLoc.$assignMove($this().Tok.getAnnotationEndLoc());
      $this().ConsumeToken();
      if (Result.isInvalid()) {
        DS.SetTypeSpecError();
        return EndLoc;
      }
    } else {
      BalancedDelimiterTracker T = null;
      try {
        if ($this().Tok.getIdentifierInfo().isStr(/*KEEP_STR*/"decltype")) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_decltype)));
          } finally {
            $c$.$destroy();
          }
        }
        
        $this().ConsumeToken();
        
        T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
        if (T.expectAndConsume(diag.err_expected_lparen_after, 
            $decltype, tok.TokenKind.r_paren)) {
          DS.SetTypeSpecError();
          return $eq_SourceLocation$C(T.getOpenLocation(), $this().Tok.getLocation()) ? new SourceLocation(StartLoc) : T.getOpenLocation();
        }
        
        // Check for C++1y 'decltype(auto)'.
        if ($this().Tok.is(tok.TokenKind.kw_auto)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // No need to disambiguate here: an expression can't start with 'auto',
            // because the typename-specifier in a function-style cast operation can't
            // be 'auto'.
            $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), 
                $this().getLangOpts().CPlusPlus14 ? diag.warn_cxx11_compat_decltype_auto_type_specifier : diag.ext_decltype_auto_type_specifier)));
            $this().ConsumeToken();
          } finally {
            $c$.$destroy();
          }
        } else {
          EnterExpressionEvaluationContext Unevaluated = null;
          try {
            // Parse the expression
            
            // C++11 [dcl.type.simple]p4:
            //   The operand of the decltype specifier is an unevaluated operand.
            Unevaluated/*J*/= new EnterExpressionEvaluationContext($this().Actions, Sema.ExpressionEvaluationContext.Unevaluated, 
                (Decl /*P*/ )null, /*IsDecltype=*/ true);
            Result.$assignMove(
                $this().Actions.CorrectDelayedTyposInExpr($this().ParseExpression(), (Expr /*P*/ E) -> 
                          {
                            return E.hasPlaceholderType() ? ExprError() : new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
                          }
                        )
                );
            if (Result.isInvalid()) {
              DS.SetTypeSpecError();
              if ($this().SkipUntil(tok.TokenKind.r_paren, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch))) {
                EndLoc.$assignMove($this().ConsumeParen());
              } else {
                if ($this().PP.isBacktrackEnabled() && $this().Tok.is(tok.TokenKind.semi)) {
                  // Backtrack to get the location of the last token before the semi.
                  $this().PP.RevertCachedTokens(2);
                  $this().ConsumeToken(); // the semi.
                  EndLoc.$assignMove($this().ConsumeAnyToken());
                  assert ($this().Tok.is(tok.TokenKind.semi));
                } else {
                  EndLoc.$assignMove($this().Tok.getLocation());
                }
              }
              return EndLoc;
            }
            
            Result.$assignMove($this().Actions.ActOnDecltypeExpression(Result.get()));
          } finally {
            if (Unevaluated != null) { Unevaluated.$destroy(); }
          }
        }
        
        // Match the ')'
        T.consumeClose();
        if (T.getCloseLocation().isInvalid()) {
          DS.SetTypeSpecError();
          // FIXME: this should return the location of the last token
          //        that was consumed (by "consumeClose()")
          return T.getCloseLocation();
        }
        if (Result.isInvalid()) {
          DS.SetTypeSpecError();
          return T.getCloseLocation();
        }
        
        EndLoc.$assignMove(T.getCloseLocation());
      } finally {
        if (T != null) { T.$destroy(); }
      }
    }
    assert (!Result.isInvalid());
    
    /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
    /*uint*/uint$ref DiagID = create_uint$ref();
    final /*const*/ PrintingPolicy /*&*/ Policy = $this().Actions.getASTContext().getPrintingPolicy();
    // Check for duplicate type specifiers (e.g. "int decltype(a)").
    if ((Result.get() != null) ? DS.SetTypeSpecType(DeclSpec.TST_decltype, new SourceLocation(StartLoc), PrevSpec, 
        DiagID, Result.get(), Policy) : DS.SetTypeSpecType(DeclSpec.TST_decltype_auto, new SourceLocation(StartLoc), PrevSpec, 
        DiagID, Policy)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
        DS.SetTypeSpecError();
      } finally {
        $c$.$destroy();
      }
    }
    return EndLoc;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::AnnotateExistingDecltypeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 868,
   FQN="clang::Parser::AnnotateExistingDecltypeSpecifier", NM="_ZN5clang6Parser33AnnotateExistingDecltypeSpecifierERKNS_8DeclSpecENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser33AnnotateExistingDecltypeSpecifierERKNS_8DeclSpecENS_14SourceLocationES4_")
  //</editor-fold>
  protected /*private*/ void AnnotateExistingDecltypeSpecifier(final /*const*/ DeclSpec /*&*/ DS, 
                                   SourceLocation StartLoc, 
                                   SourceLocation EndLoc) {
    // make sure we have a token we can turn into an annotation token
    if ($this().PP.isBacktrackEnabled()) {
      $this().PP.RevertCachedTokens(1);
    } else {
      $this().PP.EnterToken($this().Tok);
    }
    
    $this().Tok.setKind(tok.TokenKind.annot_decltype);
    setExprAnnotation($this().Tok, 
        DS.getTypeSpecType() == TypeSpecifierType.TST_decltype ? new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, DS.getRepAsExpr()) : DS.getTypeSpecType() == TypeSpecifierType.TST_decltype_auto ? new ActionResultTTrue<Expr /*P*/ >() : ExprError());
    $this().Tok.setAnnotationEndLoc(/*NO_COPY*/EndLoc);
    $this().Tok.setLocation(/*NO_COPY*/StartLoc);
    $this().PP.AnnotateCachedTokens($this().Tok);
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseUnderlyingTypeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 887,
   FQN="clang::Parser::ParseUnderlyingTypeSpecifier", NM="_ZN5clang6Parser28ParseUnderlyingTypeSpecifierERNS_8DeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser28ParseUnderlyingTypeSpecifierERNS_8DeclSpecE")
  //</editor-fold>
  protected /*private*/ void ParseUnderlyingTypeSpecifier(final DeclSpec /*&*/ DS) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw___underlying_type)) : "Not an underlying type specifier";
      
      SourceLocation StartLoc = $this().ConsumeToken();
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.expectAndConsume(diag.err_expected_lparen_after, 
          $__underlying_type, tok.TokenKind.r_paren)) {
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
      
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref();
      if (DS.SetTypeSpecType(DeclSpec.TST_underlyingType, new SourceLocation(StartLoc), PrevSpec, 
          DiagID, Result.get(), 
          $this().Actions.getASTContext().getPrintingPolicy())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
        } finally {
          $c$.$destroy();
        }
      }
      DS.setTypeofParensRange(T.getRange());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// isCXX11VirtSpecifier - Determine whether the given token is a C++11
/// virt-specifier.
///
///       virt-specifier:
///         override
///         final
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXX11VirtSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2008,
   FQN="clang::Parser::isCXX11VirtSpecifier", NM="_ZNK5clang6Parser20isCXX11VirtSpecifierERKNS_5TokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZNK5clang6Parser20isCXX11VirtSpecifierERKNS_5TokenE")
  //</editor-fold>
  protected /*private*/ VirtSpecifiers.Specifier isCXX11VirtSpecifier(final /*const*/ Token /*&*/ Tok) /*const*/ {
    if (!$this().getLangOpts().CPlusPlus || Tok.isNot(tok.TokenKind.identifier)) {
      return VirtSpecifiers.Specifier.VS_None;
    }
    
    IdentifierInfo /*P*/ II = Tok.getIdentifierInfo();
    
    // Initialize the contextual keywords.
    if (!($this().Ident_final != null)) {
      $this().Ident_final = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"final")));
      if ($this().getLangOpts().MicrosoftExt) {
        $this().Ident_sealed = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"sealed")));
      }
      $this().Ident_override = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"override")));
    }
    if (II == $this().Ident_override) {
      return VirtSpecifiers.Specifier.VS_Override;
    }
    if (II == $this().Ident_sealed) {
      return VirtSpecifiers.Specifier.VS_Sealed;
    }
    if (II == $this().Ident_final) {
      return VirtSpecifiers.Specifier.VS_Final;
    }
    
    return VirtSpecifiers.Specifier.VS_None;
  }


/// ParseOptionalCXX11VirtSpecifierSeq - Parse a virt-specifier-seq.
///
///       virt-specifier-seq:
///         virt-specifier
///         virt-specifier-seq virt-specifier
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseOptionalCXX11VirtSpecifierSeq">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2039,
   FQN="clang::Parser::ParseOptionalCXX11VirtSpecifierSeq", NM="_ZN5clang6Parser34ParseOptionalCXX11VirtSpecifierSeqERNS_14VirtSpecifiersEbNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser34ParseOptionalCXX11VirtSpecifierSeqERNS_14VirtSpecifiersEbNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ void ParseOptionalCXX11VirtSpecifierSeq(final VirtSpecifiers /*&*/ VS, 
                                    boolean IsInterface, 
                                    SourceLocation FriendLoc) {
    while (true) {
      VirtSpecifiers.Specifier Specifier = $this().isCXX11VirtSpecifier();
      if (Specifier == VirtSpecifiers.Specifier.VS_None) {
        return;
      }
      if (FriendLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok.getLocation(), diag.err_friend_decl_spec)), 
                      VirtSpecifiers.getSpecifierName(Specifier)), 
                  FixItHint.CreateRemoval(new SourceRange($this().Tok.getLocation()))), 
              new SourceRange(/*NO_COPY*/FriendLoc, /*NO_COPY*/FriendLoc)));
          $this().ConsumeToken();
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // C++ [class.mem]p8:
      //   A virt-specifier-seq shall contain at most one of each virt-specifier.
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      if (VS.SetSpecifier(Specifier, $this().Tok.getLocation(), PrevSpec)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok.getLocation(), diag.err_duplicate_virt_specifier)), 
                  PrevSpec), 
              FixItHint.CreateRemoval(new SourceRange($this().Tok.getLocation()))));
        } finally {
          $c$.$destroy();
        }
      }
      if (IsInterface && (Specifier == VirtSpecifiers.Specifier.VS_Final
         || Specifier == VirtSpecifiers.Specifier.VS_Sealed)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok.getLocation(), diag.err_override_control_interface)), 
              VirtSpecifiers.getSpecifierName(Specifier)));
        } finally {
          $c$.$destroy();
        }
      } else if (Specifier == VirtSpecifiers.Specifier.VS_Sealed) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.ext_ms_sealed_keyword)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag($this().Tok.getLocation(), 
                  $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_override_control_keyword : diag.ext_override_control_keyword)), 
              VirtSpecifiers.getSpecifierName(Specifier)));
        } finally {
          $c$.$destroy();
        }
      }
      $this().ConsumeToken();
    }
  }


/// isCXX11FinalKeyword - Determine whether the next token is a C++11
/// 'final' or Microsoft 'sealed' contextual keyword.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isCXX11FinalKeyword">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2083,
   FQN="clang::Parser::isCXX11FinalKeyword", NM="_ZNK5clang6Parser19isCXX11FinalKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZNK5clang6Parser19isCXX11FinalKeywordEv")
  //</editor-fold>
  protected /*private*/ boolean isCXX11FinalKeyword() /*const*/ {
    VirtSpecifiers.Specifier Specifier = $this().isCXX11VirtSpecifier();
    return Specifier == VirtSpecifiers.Specifier.VS_Final
       || Specifier == VirtSpecifiers.Specifier.VS_Sealed;
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::DiagnoseUnexpectedNamespace">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3153,
   FQN="clang::Parser::DiagnoseUnexpectedNamespace", NM="_ZN5clang6Parser27DiagnoseUnexpectedNamespaceEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser27DiagnoseUnexpectedNamespaceEPNS_9NamedDeclE")
  //</editor-fold>
  protected /*private*/ void DiagnoseUnexpectedNamespace(NamedDecl /*P*/ D) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_namespace));
      
      // FIXME: Suggest where the close brace should have gone by looking
      // at indentation changes within the definition body.
      $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diag(D.getLocation(), 
              diag.err_missing_end_of_definition)), D));
      $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diag($this().Tok.getLocation(), 
              diag.note_missing_end_of_definition_before)), D));
      
      // Push '};' onto the token stream to recover.
      $this().PP.EnterToken($this().Tok);
      
      $this().Tok.startToken();
      $this().Tok.setLocation($this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation));
      $this().Tok.setKind(tok.TokenKind.semi);
      $this().PP.EnterToken($this().Tok);
      
      $this().Tok.setKind(tok.TokenKind.r_brace);
    } finally {
      $c$.$destroy();
    }
  }


/// ParseNamespace - We know that the current token is a namespace keyword. This
/// may either be a top level namespace or a block-level namespace alias. If
/// there was an inline keyword, it has already been parsed.
///
///       namespace-definition: [C++ 7.3: basic.namespace]
///         named-namespace-definition
///         unnamed-namespace-definition
///
///       unnamed-namespace-definition:
///         'inline'[opt] 'namespace' attributes[opt] '{' namespace-body '}'
///
///       named-namespace-definition:
///         original-namespace-definition
///         extension-namespace-definition
///
///       original-namespace-definition:
///         'inline'[opt] 'namespace' identifier attributes[opt]
///             '{' namespace-body '}'
///
///       extension-namespace-definition:
///         'inline'[opt] 'namespace' original-namespace-name
///             '{' namespace-body '}'
///
///       namespace-alias-definition:  [C++ 7.3.2: namespace.alias]
///         'namespace' identifier '=' qualified-namespace-specifier ';'
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseNamespace">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 58,
   FQN="clang::Parser::ParseNamespace", NM="_ZN5clang6Parser14ParseNamespaceEjRNS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser14ParseNamespaceEjRNS_14SourceLocationES1_")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseNamespace(/*uint*/int Context, 
                final SourceLocation /*&*/ DeclEnd) {
    return $this().ParseNamespace(Context, 
                DeclEnd, 
                new SourceLocation());
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseNamespace(/*uint*/int Context, 
                final SourceLocation /*&*/ DeclEnd, 
                SourceLocation InlineLoc/*= SourceLocation()*/) {
    ObjCDeclContextSwitch ObjCDC = null;
    std.vector<SourceLocation> ExtraIdentLoc = null;
    std.vector<IdentifierInfo /*P*/ > ExtraIdent = null;
    std.vector<SourceLocation> ExtraNamespaceLoc = null;
    ParsedAttributesWithRange attrs = null;
    BalancedDelimiterTracker T = null;
    ParseScope NamespaceScope = null;
    PrettyDeclStackTraceEntry CrashInfo = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_namespace)) : "Not a namespace!";
      SourceLocation NamespaceLoc = $this().ConsumeToken(); // eat the 'namespace'.
      ObjCDC/*J*/= new ObjCDeclContextSwitch(/*Deref*/$this());
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteNamespaceDecl($this().getCurScope());
        $this().cutOffParsing();
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      SourceLocation IdentLoc/*J*/= new SourceLocation();
      IdentifierInfo /*P*/ Ident = null;
      ExtraIdentLoc/*J*/= new std.vector<SourceLocation>(new SourceLocation());
      ExtraIdent/*J*/= new std.vector<IdentifierInfo /*P*/ >((IdentifierInfo /*P*/ )null);
      ExtraNamespaceLoc/*J*/= new std.vector<SourceLocation>(new SourceLocation());
      
      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      SourceLocation attrLoc/*J*/= new SourceLocation();
      if ($this().getLangOpts().CPlusPlus11 && $bool2uint_1bit(($this().isCXX11AttributeSpecifier().getValue() != 0))) {
        if (!$this().getLangOpts().CPlusPlus1z) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok.getLocation(), diag.warn_cxx14_compat_attribute)), 
                0/*namespace*/));
          } finally {
            $c$.$destroy();
          }
        }
        attrLoc.$assignMove($this().Tok.getLocation());
        $this().ParseCXX11Attributes(attrs);
      }
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        Ident = $this().Tok.getIdentifierInfo();
        IdentLoc.$assignMove($this().ConsumeToken()); // eat the identifier.
        while ($this().Tok.is(tok.TokenKind.coloncolon) && $this().NextToken().is(tok.TokenKind.identifier)) {
          ExtraNamespaceLoc.push_back_T$RR($this().ConsumeToken());
          ExtraIdent.push_back_T$RR($this().Tok.getIdentifierInfo());
          ExtraIdentLoc.push_back_T$RR($this().ConsumeToken());
        }
      }
      
      // A nested namespace definition cannot have attributes.
      if (!ExtraNamespaceLoc.empty() && attrLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(attrLoc), diag.err_unexpected_nested_namespace_attribute)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Read label attributes, if present.
      if ($this().Tok.is(tok.TokenKind.kw___attribute)) {
        attrLoc.$assignMove($this().Tok.getLocation());
        $this().ParseGNUAttributes(attrs);
      }
      if ($this().Tok.is(tok.TokenKind.equal)) {
        if (!(Ident != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
            // Skip to end of the definition and eat the ';'.
            $this().SkipUntil(tok.TokenKind.semi);
            return new OpaquePtr<DeclGroupRef>(null);
          } finally {
            $c$.$destroy();
          }
        }
        if (attrLoc.isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(attrLoc), diag.err_unexpected_namespace_attributes_alias)));
          } finally {
            $c$.$destroy();
          }
        }
        if (InlineLoc.isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(InlineLoc), diag.err_inline_namespace_alias)), 
                FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/InlineLoc))));
          } finally {
            $c$.$destroy();
          }
        }
        Decl /*P*/ NSAlias = $this().ParseNamespaceAlias(new SourceLocation(NamespaceLoc), new SourceLocation(IdentLoc), Ident, DeclEnd);
        return $this().Actions.ConvertDeclToDeclGroup(NSAlias);
      }
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      if (T.consumeOpen()) {
        if ((Ident != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected_either)), tok.TokenKind.identifier), tok.TokenKind.l_brace));
          } finally {
            $c$.$destroy();
          }
        }
        return new OpaquePtr<DeclGroupRef>(null);
      }
      if ($this().getCurScope().isClassScope() || $this().getCurScope().isTemplateParamScope()
         || $this().getCurScope().isInObjcMethodScope() || ($this().getCurScope().getBlockParent() != null)
         || ($this().getCurScope().getFnParent() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(T.getOpenLocation(), diag.err_namespace_nonnamespace_scope)));
          $this().SkipUntil(tok.TokenKind.r_brace);
          return new OpaquePtr<DeclGroupRef>(null);
        } finally {
          $c$.$destroy();
        }
      }
      if (ExtraIdent.empty()) {
        // Normal namespace definition, not a nested-namespace-definition.
      } else if (InlineLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(InlineLoc), diag.err_inline_nested_namespace_definition)));
        } finally {
          $c$.$destroy();
        }
      } else if ($this().getLangOpts().CPlusPlus1z) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(ExtraNamespaceLoc.$at(0)), 
              diag.warn_cxx14_compat_nested_namespace_definition)));
        } finally {
          $c$.$destroy();
        }
      } else {
        TentativeParsingAction TPA = null;
        try {
          TPA/*J*/= new TentativeParsingAction(/*Deref*/$this());
          $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopBeforeMatch);
          Token rBraceToken = new Token($this().Tok);
          TPA.Revert();
          if (!rBraceToken.is(tok.TokenKind.r_brace)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(ExtraNamespaceLoc.$at(0)), diag.ext_nested_namespace_definition)), 
                  new SourceRange(/*NO_COPY*/ExtraNamespaceLoc.front(), /*NO_COPY*/ExtraIdentLoc.back())));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              std.string NamespaceFix/*J*/= new std.string();
              for (std.vector.iterator<IdentifierInfo /*P*/ > I = ExtraIdent.begin(), 
                  E = ExtraIdent.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
                NamespaceFix.$addassign_T$C$P(/*KEEP_STR*/" { namespace ");
                $addassign_string_StringRef(NamespaceFix, (I.$star()).getName());
              }
              
              std.string RBraces/*J*/= new std.string();
              for (/*uint*/int i = 0, e = ExtraIdent.size(); i != e; ++i)  {
                RBraces.$addassign_T$C$P(/*KEEP_STR*/"} ");
              }
              
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(ExtraNamespaceLoc.$at(0)), diag.ext_nested_namespace_definition)), 
                      FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/ExtraNamespaceLoc.front(), 
                              /*NO_COPY*/ExtraIdentLoc.back()), 
                          new StringRef(NamespaceFix))), 
                  FixItHint.CreateInsertion(rBraceToken.getLocation(), new StringRef(RBraces))));
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (TPA != null) { TPA.$destroy(); }
        }
      }
      
      // If we're still good, complain about inline namespaces in non-C++0x now.
      if (InlineLoc.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(InlineLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_inline_namespace : diag.ext_inline_namespace)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Enter a scope for the namespace.
      NamespaceScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope);
      
      type$ref<UsingDirectiveDecl> /*P*/ ImplicitUsingDirectiveDecl = create_type$ref((UsingDirectiveDecl) null);
      Decl /*P*/ NamespcDecl = $this().Actions.ActOnStartNamespaceDef($this().getCurScope(), new SourceLocation(InlineLoc), new SourceLocation(NamespaceLoc), 
          new SourceLocation(IdentLoc), Ident, T.getOpenLocation(), 
          attrs.getList(), ImplicitUsingDirectiveDecl);
      
      CrashInfo/*J*/= new PrettyDeclStackTraceEntry($this().Actions, NamespcDecl, new SourceLocation(NamespaceLoc), 
          $("parsing namespace"));
      
      // Parse the contents of the namespace.  This includes parsing recovery on 
      // any improperly nested namespaces.
      $this().ParseInnerNamespace(ExtraIdentLoc, ExtraIdent, ExtraNamespaceLoc, 0, 
          InlineLoc, attrs, T);
      
      // Leave the namespace scope.
      NamespaceScope.Exit();
      
      DeclEnd.$assignMove(T.getCloseLocation());
      $this().Actions.ActOnFinishNamespaceDef(NamespcDecl, new SourceLocation(DeclEnd));
      
      return $this().Actions.ConvertDeclToDeclGroup(NamespcDecl, 
          ImplicitUsingDirectiveDecl.$deref());
    } finally {
      if (CrashInfo != null) { CrashInfo.$destroy(); }
      if (NamespaceScope != null) { NamespaceScope.$destroy(); }
      if (T != null) { T.$destroy(); }
      if (attrs != null) { attrs.$destroy(); }
      if (ExtraNamespaceLoc != null) { ExtraNamespaceLoc.$destroy(); }
      if (ExtraIdent != null) { ExtraIdent.$destroy(); }
      if (ExtraIdentLoc != null) { ExtraIdentLoc.$destroy(); }
      if (ObjCDC != null) { ObjCDC.$destroy(); }
    }
  }


/// ParseInnerNamespace - Parse the contents of a namespace.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseInnerNamespace">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 209,
   FQN="clang::Parser::ParseInnerNamespace", NM="_ZN5clang6Parser19ParseInnerNamespaceERSt6vectorINS_14SourceLocationESaIS2_EERS1_IPNS_14IdentifierInfoESaIS7_EES5_jRS2_RNS_16ParsedAttributesERNS_24BalancedDelimiterTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser19ParseInnerNamespaceERSt6vectorINS_14SourceLocationESaIS2_EERS1_IPNS_14IdentifierInfoESaIS7_EES5_jRS2_RNS_16ParsedAttributesERNS_24BalancedDelimiterTrackerE")
  //</editor-fold>
  protected /*private*/ void ParseInnerNamespace(final std.vector<SourceLocation> /*&*/ IdentLoc, 
                     final std.vector<IdentifierInfo /*P*/ > /*&*/ Ident, 
                     final std.vector<SourceLocation> /*&*/ NamespaceLoc, 
                     /*uint*/int index, final SourceLocation /*&*/ InlineLoc, 
                     final ParsedAttributes /*&*/ attrs, 
                     final BalancedDelimiterTracker /*&*/ Tracker) {
    ParseScope NamespaceScope = null;
    try {
      if (index == Ident.size()) {
        while (!$this().tryParseMisplacedModuleImport() && $this().Tok.isNot(tok.TokenKind.r_brace)
           && $this().Tok.isNot(tok.TokenKind.eof)) {
          ParsedAttributesWithRange _attrs = null;
          try {
            _attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
            $this().MaybeParseCXX11Attributes(_attrs);
            $this().MaybeParseMicrosoftAttributes(_attrs);
            $this().ParseExternalDeclaration(_attrs);
          } finally {
            if (_attrs != null) { _attrs.$destroy(); }
          }
        }
        
        // The caller is what called check -- we are simply calling
        // the close for it.
        Tracker.consumeClose();
        
        return;
      }
      
      // Handle a nested namespace definition.
      // FIXME: Preserve the source information through to the AST rather than
      // desugaring it here.
      NamespaceScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope);
      type$ref<UsingDirectiveDecl> /*P*/ ImplicitUsingDirectiveDecl = create_type$ref((UsingDirectiveDecl) null);
      Decl /*P*/ NamespcDecl = $this().Actions.ActOnStartNamespaceDef($this().getCurScope(), new SourceLocation(), 
          new SourceLocation(NamespaceLoc.$at(index)), new SourceLocation(IdentLoc.$at(index)), 
          Ident.$at(index), Tracker.getOpenLocation(), 
          attrs.getList(), ImplicitUsingDirectiveDecl);
      assert (!ImplicitUsingDirectiveDecl.$bool()) : "nested namespace definition cannot define anonymous namespace";
      
      $this().ParseInnerNamespace(IdentLoc, Ident, NamespaceLoc, ++index, InlineLoc, 
          attrs, Tracker);
      
      NamespaceScope.Exit();
      $this().Actions.ActOnFinishNamespaceDef(NamespcDecl, Tracker.getCloseLocation());
    } finally {
      if (NamespaceScope != null) { NamespaceScope.$destroy(); }
    }
  }


/// ParseLinkage - We know that the current token is a string_literal
/// and just before that, that extern was seen.
///
///       linkage-specification: [C++ 7.5p2: dcl.link]
///         'extern' string-literal '{' declaration-seq[opt] '}'
///         'extern' string-literal declaration
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseLinkage">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 299,
   FQN="clang::Parser::ParseLinkage", NM="_ZN5clang6Parser12ParseLinkageERNS_15ParsingDeclSpecEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser12ParseLinkageERNS_15ParsingDeclSpecEj")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseLinkage(final ParsingDeclSpec /*&*/ DS, /*uint*/int Context) {
    ParseScope LinkageScope = null;
    ParsedAttributesWithRange attrs = null;
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().isTokenStringLiteral()) : "Not a string literal!";
      ActionResultTTrue<Expr /*P*/ > Lang = $this().ParseStringLiteralExpression(false);
      
      LinkageScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.DeclScope);
      Decl /*P*/ LinkageSpec = Lang.isInvalid() ? null : $this().Actions.ActOnStartLinkageSpecification($this().getCurScope(), DS.getSourceRange().getBegin(), Lang.get(), 
          $this().Tok.is(tok.TokenKind.l_brace) ? $this().Tok.getLocation() : new SourceLocation());
      
      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(attrs);
      $this().MaybeParseMicrosoftAttributes(attrs);
      if ($this().Tok.isNot(tok.TokenKind.l_brace)) {
        // Reset the source range in DS, as the leading "extern"
        // does not really belong to the inner declaration ...
        DS.SetRangeStart(new SourceLocation());
        DS.SetRangeEnd(new SourceLocation());
        // ... but anyway remember that such an "extern" was seen.
        DS.setExternInLinkageSpec(true);
        $this().ParseExternalDeclaration(attrs, $AddrOf(DS));
        return (LinkageSpec != null) ? $this().Actions.ActOnFinishLinkageSpecification($this().getCurScope(), LinkageSpec, new SourceLocation()) : null;
      }
      
      DS.abort();
      
      $this().ProhibitAttributes(attrs);
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      T.consumeOpen();
      
      /*uint*/int NestedModules = 0;
      while (true) {
        switch ($this().Tok.getKind()) {
         case tok.TokenKind.annot_module_begin:
          ++NestedModules;
          $this().ParseTopLevelDecl();
          continue;
         case tok.TokenKind.annot_module_end:
          if (!(NestedModules != 0)) {
            break;
          }
          --NestedModules;
          $this().ParseTopLevelDecl();
          continue;
         case tok.TokenKind.annot_module_include:
          $this().ParseTopLevelDecl();
          continue;
         case tok.TokenKind.eof:
          break;
         case tok.TokenKind.r_brace:
          if (!(NestedModules != 0)) {
            break;
          }
         default:
          {
            ParsedAttributesWithRange _attrs = null;
            try {
              // Fall through.
              _attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
              $this().MaybeParseCXX11Attributes(_attrs);
              $this().MaybeParseMicrosoftAttributes(_attrs);
              $this().ParseExternalDeclaration(_attrs);
              continue;
            } finally {
              if (_attrs != null) { _attrs.$destroy(); }
            }
          }
        }
        
        break;
      }
      
      T.consumeClose();
      return (LinkageSpec != null) ? $this().Actions.ActOnFinishLinkageSpecification($this().getCurScope(), LinkageSpec, T.getCloseLocation()) : null;
    } finally {
      if (T != null) { T.$destroy(); }
      if (attrs != null) { attrs.$destroy(); }
      if (LinkageScope != null) { LinkageScope.$destroy(); }
    }
  }


/// ParseUsingDirectiveOrDeclaration - Parse C++ using using-declaration or
/// using-directive. Assumes that current token is 'using'.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseUsingDirectiveOrDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 380,
   FQN="clang::Parser::ParseUsingDirectiveOrDeclaration", NM="_ZN5clang6Parser32ParseUsingDirectiveOrDeclarationEjRKNS0_18ParsedTemplateInfoERNS_14SourceLocationERNS0_25ParsedAttributesWithRangeEPPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser32ParseUsingDirectiveOrDeclarationEjRKNS0_18ParsedTemplateInfoERNS_14SourceLocationERNS0_25ParsedAttributesWithRangeEPPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseUsingDirectiveOrDeclaration(/*uint*/int Context, 
                                  final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                                  final SourceLocation /*&*/ DeclEnd, 
                                  final ParsedAttributesWithRange /*&*/ attrs) {
    return $this().ParseUsingDirectiveOrDeclaration(Context, 
                                  TemplateInfo, 
                                  DeclEnd, 
                                  attrs, 
                                  (type$ptr<Decl /*P*/>/*P*/)null);
  }
  protected /*private*/ Decl /*P*/ ParseUsingDirectiveOrDeclaration(/*uint*/int Context, 
                                  final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                                  final SourceLocation /*&*/ DeclEnd, 
                                  final ParsedAttributesWithRange /*&*/ attrs, 
                                  type$ptr<Decl /*P*/>/*P*/OwnedType/*= null*/) {
    ObjCDeclContextSwitch ObjCDC = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_using)) : "Not using token";
      ObjCDC/*J*/= new ObjCDeclContextSwitch(/*Deref*/$this());
      
      // Eat 'using'.
      SourceLocation UsingLoc = $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteUsing($this().getCurScope());
        $this().cutOffParsing();
        return null;
      }
      
      // 'using namespace' means this is a using-directive.
      if ($this().Tok.is(tok.TokenKind.kw_namespace)) {
        // Template parameters are always an error here.
        if ((TemplateInfo.Kind.getValue() != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceRange R = TemplateInfo.getSourceRange();
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(UsingLoc), diag.err_templated_using_directive_declaration)), 
                        0/* directive */), /*NO_COPY*/R), FixItHint.CreateRemoval(/*NO_COPY*/R)));
          } finally {
            $c$.$destroy();
          }
        }
        
        return $this().ParseUsingDirective(Context, new SourceLocation(UsingLoc), DeclEnd, attrs);
      }
      
      // Otherwise, it must be a using-declaration or an alias-declaration.
      
      // Using declarations can't have attributes.
      $this().ProhibitAttributes(attrs);
      
      return $this().ParseUsingDeclaration(Context, TemplateInfo, new SourceLocation(UsingLoc), DeclEnd, 
          AccessSpecifier.AS_none, OwnedType);
    } finally {
      if (ObjCDC != null) { ObjCDC.$destroy(); }
    }
  }


/// ParseUsingDirective - Parse C++ using-directive, assumes
/// that current token is 'namespace' and 'using' was already parsed.
///
///       using-directive: [C++ 7.3.p4: namespace.udir]
///        'using' 'namespace' ::[opt] nested-name-specifier[opt]
///                 namespace-name ;
/// [GNU] using-directive:
///        'using' 'namespace' ::[opt] nested-name-specifier[opt]
///                 namespace-name attributes[opt] ;
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseUsingDirective">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 428,
   FQN="clang::Parser::ParseUsingDirective", NM="_ZN5clang6Parser19ParseUsingDirectiveEjNS_14SourceLocationERS1_RNS_16ParsedAttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser19ParseUsingDirectiveEjNS_14SourceLocationERS1_RNS_16ParsedAttributesE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseUsingDirective(/*uint*/int Context, 
                     SourceLocation UsingLoc, 
                     final SourceLocation /*&*/ DeclEnd, 
                     final ParsedAttributes /*&*/ attrs) {
    CXXScopeSpec SS = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.kw_namespace)) : "Not 'namespace' token";
      
      // Eat 'namespace'.
      SourceLocation NamespcLoc = $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteUsingDirective($this().getCurScope());
        $this().cutOffParsing();
        return null;
      }
      
      SS/*J*/= new CXXScopeSpec();
      // Parse (optional) nested-name-specifier.
      $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), /*EnteringContext=*/ false);
      
      IdentifierInfo /*P*/ NamespcName = null;
      SourceLocation IdentLoc = new SourceLocation();
      
      // Parse namespace-name.
      if (SS.isInvalid() || $this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_namespace_name)));
          // If there was invalid namespace name, skip to end of decl, and eat ';'.
          $this().SkipUntil(tok.TokenKind.semi);
          // FIXME: Are there cases, when we would like to call ActOnUsingDirective?
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse identifier.
      NamespcName = $this().Tok.getIdentifierInfo();
      IdentLoc.$assignMove($this().ConsumeToken());
      
      // Parse (optional) attributes (most likely GNU strong-using extension).
      boolean GNUAttr = false;
      if ($this().Tok.is(tok.TokenKind.kw___attribute)) {
        GNUAttr = true;
        $this().ParseGNUAttributes(attrs);
      }
      
      // Eat ';'.
      DeclEnd.$assignMove($this().Tok.getLocation());
      if ($this().ExpectAndConsume(tok.TokenKind.semi, 
          GNUAttr ? diag.err_expected_semi_after_attribute_list : diag.err_expected_semi_after_namespace_name)) {
        $this().SkipUntil(tok.TokenKind.semi);
      }
      
      return $this().Actions.ActOnUsingDirective($this().getCurScope(), new SourceLocation(UsingLoc), new SourceLocation(NamespcLoc), SS, 
          new SourceLocation(IdentLoc), NamespcName, attrs.getList());
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }


/// ParseUsingDeclaration - Parse C++ using-declaration or alias-declaration.
/// Assumes that 'using' was already seen.
///
///     using-declaration: [C++ 7.3.p3: namespace.udecl]
///       'using' 'typename'[opt] ::[opt] nested-name-specifier
///               unqualified-id
///       'using' :: unqualified-id
///
///     alias-declaration: C++11 [dcl.dcl]p1
///       'using' identifier attribute-specifier-seq[opt] = type-id ;
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseUsingDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 492,
   FQN="clang::Parser::ParseUsingDeclaration", NM="_ZN5clang6Parser21ParseUsingDeclarationEjRKNS0_18ParsedTemplateInfoENS_14SourceLocationERS4_NS_15AccessSpecifierEPPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser21ParseUsingDeclarationEjRKNS0_18ParsedTemplateInfoENS_14SourceLocationERS4_NS_15AccessSpecifierEPPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseUsingDeclaration(/*uint*/int Context, 
                       final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                       SourceLocation UsingLoc, 
                       final SourceLocation /*&*/ DeclEnd) {
    return $this().ParseUsingDeclaration(Context, 
                       TemplateInfo, 
                       UsingLoc, 
                       DeclEnd, 
                       AccessSpecifier.AS_none, 
                       (type$ptr<Decl /*P*/>/*P*/)null);
  }
  protected /*private*/ Decl /*P*/ ParseUsingDeclaration(/*uint*/int Context, 
                       final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                       SourceLocation UsingLoc, 
                       final SourceLocation /*&*/ DeclEnd, 
                       AccessSpecifier AS/*= AS_none*/) {
    return $this().ParseUsingDeclaration(Context, 
                       TemplateInfo, 
                       UsingLoc, 
                       DeclEnd, 
                       AS, 
                       (type$ptr<Decl /*P*/>/*P*/)null);
  }
  protected /*private*/ Decl /*P*/ ParseUsingDeclaration(/*uint*/int Context, 
                       final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                       SourceLocation UsingLoc, 
                       final SourceLocation /*&*/ DeclEnd, 
                       AccessSpecifier AS/*= AS_none*/, 
                       type$ptr<Decl /*P*/>/*P*/OwnedType/*= null*/) {
    CXXScopeSpec SS = null;
    ParsedAttributesWithRange MisplacedAttrs = null;
    ParsedAttributesWithRange Attrs = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      SourceLocation TypenameLoc/*J*/= new SourceLocation();
      boolean HasTypenameKeyword = false;
      
      // Check for misplaced attributes before the identifier in an
      // alias-declaration.
      MisplacedAttrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(MisplacedAttrs);
      
      // Ignore optional 'typename'.
      // FIXME: This is wrong; we should parse this as a typename-specifier.
      if ($this().TryConsumeToken(tok.TokenKind.kw_typename, TypenameLoc)) {
        HasTypenameKeyword = true;
      }
      if ($this().Tok.is(tok.TokenKind.kw___super)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_super_in_using_declaration)));
          $this().SkipUntil(tok.TokenKind.semi);
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse nested-name-specifier.
      type$ptr<IdentifierInfo /*P*/> LastII = create_type$null$ptr();
      $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), /*EnteringContext=*/ false, 
          /*MayBePseudoDtor=*/ (bool$ptr/*bool P*/ )null, 
          /*IsTypename=*/ false, 
          /*LastII=*/ $AddrOf(LastII));
      
      // Check nested-name specifier.
      if (SS.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.semi);
        return null;
      }
      
      SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
      UnqualifiedId Name/*J*/= new UnqualifiedId();
      
      // Parse the unqualified-id. We allow parsing of both constructor and
      // destructor names and allow the action module to diagnose any semantic
      // errors.
      //
      // C++11 [class.qual]p2:
      //   [...] in a using-declaration that is a member-declaration, if the name
      //   specified after the nested-name-specifier is the same as the identifier
      //   or the simple-template-id's template-name in the last component of the
      //   nested-name-specifier, the name is [...] considered to name the
      //   constructor.
      if ($this().getLangOpts().CPlusPlus11 && Context == Declarator.TheContext.MemberContext.getValue()
         && $this().Tok.is(tok.TokenKind.identifier) && $this().NextToken().is(tok.TokenKind.semi)
         && SS.isNotEmpty() && LastII.$star() == $this().Tok.getIdentifierInfo()
         && !(SS.getScopeRep().getAsNamespace() != null)
         && !(SS.getScopeRep().getAsNamespaceAlias() != null)) {
        SourceLocation IdLoc = $this().ConsumeToken();
        OpaquePtr<QualType> Type = $this().Actions.getInheritingConstructorName(SS, new SourceLocation(IdLoc), $Deref(LastII.$star()));
        Name.setConstructorName(new OpaquePtr<QualType>(Type), new SourceLocation(IdLoc), new SourceLocation(IdLoc));
      } else if ($this().ParseUnqualifiedId(SS, /*EnteringContext=*/ false, 
          /*AllowDestructorName=*/ true, 
          /*AllowConstructorName=*/ !($this().Tok.is(tok.TokenKind.identifier)
             && $this().NextToken().is(tok.TokenKind.equal)), 
          new OpaquePtr<QualType>(null), TemplateKWLoc, Name)) {
        $this().SkipUntil(tok.TokenKind.semi);
        return null;
      }
      
      Attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseGNUAttributes(Attrs);
      $this().MaybeParseCXX11Attributes(Attrs);
      
      // Maybe this is an alias-declaration.
      ActionResult<OpaquePtr<QualType> > TypeAlias/*J*/= new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>());
      boolean IsAliasDecl = $this().Tok.is(tok.TokenKind.equal);
      type$ptr<Decl /*P*/> DeclFromDeclSpec = create_type$null$ptr();
      if (IsAliasDecl) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // If we had any misplaced attributes from earlier, this is where they
          // should have been written.
          if (MisplacedAttrs.Range.isValid()) {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(MisplacedAttrs.Range.getBegin(), diag.err_attributes_not_allowed)), 
                    FixItHint.CreateInsertionFromRange($this().Tok.getLocation(), 
                        CharSourceRange.getTokenRange(/*NO_COPY*/MisplacedAttrs.Range))), 
                FixItHint.CreateRemoval(/*NO_COPY*/MisplacedAttrs.Range)));
            Attrs.takeAllFrom(MisplacedAttrs);
          }
          
          $this().ConsumeToken();
          
          $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_alias_declaration : diag.ext_alias_declaration)));
          
          // Type alias templates cannot be specialized.
          int SpecKind = -1;
          if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.Template
             && Name.getKind() == UnqualifiedId.IdKind.IK_TemplateId) {
            SpecKind = 0;
          }
          if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitSpecialization) {
            SpecKind = 1;
          }
          if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation) {
            SpecKind = 2;
          }
          if (SpecKind != -1) {
            SourceRange Range/*J*/= new SourceRange();
            if (SpecKind == 0) {
              Range.$assignMove(new SourceRange(/*NO_COPY*/Name.Unnamed_field1.TemplateId.LAngleLoc, 
                      /*NO_COPY*/Name.Unnamed_field1.TemplateId.RAngleLoc));
            } else {
              Range.$assignMove(TemplateInfo.getSourceRange());
            }
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($c$.track($this().Diag(Range.getBegin(), diag.err_alias_declaration_specialization)), 
                    SpecKind), /*NO_COPY*/Range));
            $this().SkipUntil(tok.TokenKind.semi);
            return null;
          }
          
          // Name must be an identifier.
          if (Name.getKind() != UnqualifiedId.IdKind.IK_Identifier) {
            $c$.clean($c$.track($this().Diag(new SourceLocation(Name.StartLocation), diag.err_alias_declaration_not_identifier)));
            // No removal fixit: can't recover from this.
            $this().SkipUntil(tok.TokenKind.semi);
            return null;
          } else if (HasTypenameKeyword) {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(TypenameLoc), diag.err_alias_declaration_not_identifier)), 
                FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TypenameLoc, 
                        SS.isNotEmpty() ? SS.getEndLoc() : new SourceLocation(TypenameLoc)))));
          } else if (SS.isNotEmpty()) {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(SS.getBeginLoc(), diag.err_alias_declaration_not_identifier)), 
                FixItHint.CreateRemoval(SS.getRange())));
          }
          
          TypeAlias.$assignMove($this().ParseTypeName((SourceRange /*P*/ )null, (TemplateInfo.Kind.getValue() != 0) ? Declarator.TheContext.AliasTemplateContext : Declarator.TheContext.AliasDeclContext, 
                  AS, $AddrOf(DeclFromDeclSpec), $AddrOf(Attrs)));
          if ((OwnedType != null)) {
            OwnedType.$set(DeclFromDeclSpec.$star());
          }
        } finally {
          $c$.$destroy();
        }
      } else {
        // C++11 attributes are not allowed on a using-declaration, but GNU ones
        // are.
        $this().ProhibitAttributes(MisplacedAttrs);
        $this().ProhibitAttributes(Attrs);
        
        // Parse (optional) attributes (most likely GNU strong-using extension).
        $this().MaybeParseGNUAttributes(Attrs);
      }
      
      // Eat ';'.
      DeclEnd.$assignMove($this().Tok.getLocation());
      if ($this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, 
          new StringRef(!Attrs.empty() ? $("attributes list") : IsAliasDecl ? $("alias declaration") : $("using declaration")))) {
        $this().SkipUntil(tok.TokenKind.semi);
      }
      
      // Diagnose an attempt to declare a templated using-declaration.
      // In C++11, alias-declarations can be templates:
      //   template <...> using id = type;
      if ((TemplateInfo.Kind.getValue() != 0) && !IsAliasDecl) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceRange R = TemplateInfo.getSourceRange();
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(UsingLoc), diag.err_templated_using_directive_declaration)), 
                      1/* declaration */), /*NO_COPY*/R), FixItHint.CreateRemoval(/*NO_COPY*/R)));
          
          // Unfortunately, we have to bail out instead of recovering by
          // ignoring the parameters, just in case the nested name specifier
          // depends on the parameters.
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // "typename" keyword is allowed for identifiers only,
      // because it may be a type definition.
      if (HasTypenameKeyword && Name.getKind() != UnqualifiedId.IdKind.IK_Identifier) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(Name.getSourceRange().getBegin(), diag.err_typename_identifiers_only)), 
              FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TypenameLoc))));
          // Proceed parsing, but reset the HasTypenameKeyword flag.
          HasTypenameKeyword = false;
        } finally {
          $c$.$destroy();
        }
      }
      if (IsAliasDecl) {
        SmallVector<TemplateParameterList /*P*/> /*P*/ TemplateParams = TemplateInfo.TemplateParams;
        MutableArrayRef<TemplateParameterList /*P*/ > TemplateParamsArg/*J*/= new MutableArrayRef<TemplateParameterList /*P*/ >((TemplateParams != null) ? TemplateParams.data() : create_type$ptr((TemplateParameterList /*P*/ )null), 
            (TemplateParams != null) ? TemplateParams.size() : 0, true);
        return $this().Actions.ActOnAliasDeclaration($this().getCurScope(), AS, new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParamsArg), 
            new SourceLocation(UsingLoc), Name, Attrs.getList(), 
            new ActionResult<OpaquePtr<QualType> >(TypeAlias), DeclFromDeclSpec.$star());
      }
      
      return $this().Actions.ActOnUsingDeclaration($this().getCurScope(), AS, 
          /* HasUsingKeyword */ true, new SourceLocation(UsingLoc), 
          SS, Name, Attrs.getList(), 
          HasTypenameKeyword, new SourceLocation(TypenameLoc));
    } finally {
      if (Attrs != null) { Attrs.$destroy(); }
      if (MisplacedAttrs != null) { MisplacedAttrs.$destroy(); }
      if (SS != null) { SS.$destroy(); }
    }
  }


/// ParseStaticAssertDeclaration - Parse C++0x or C11 static_assert-declaration.
///
/// [C++0x] static_assert-declaration:
///           static_assert ( constant-expression  ,  string-literal  ) ;
///
/// [C11]   static_assert-declaration:
///           _Static_assert ( constant-expression  ,  string-literal  ) ;
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseStaticAssertDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 695,
   FQN="clang::Parser::ParseStaticAssertDeclaration", NM="_ZN5clang6Parser28ParseStaticAssertDeclarationERNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser28ParseStaticAssertDeclarationERNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseStaticAssertDeclaration(final SourceLocation /*&*/ DeclEnd) {
    BalancedDelimiterTracker T = null;
    try {
      assert ($this().Tok.isOneOf(tok.TokenKind.kw_static_assert, tok.TokenKind.kw__Static_assert)) : "Not a static_assert declaration";
      if ($this().Tok.is(tok.TokenKind.kw__Static_assert) && !$this().getLangOpts().C11) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.ext_c11_static_assert)));
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().Tok.is(tok.TokenKind.kw_static_assert)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_static_assert)));
        } finally {
          $c$.$destroy();
        }
      }
      
      SourceLocation StaticAssertLoc = $this().ConsumeToken();
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
      if (T.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_paren));
          $this().SkipMalformedDecl();
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      ActionResultTTrue<Expr /*P*/ > AssertExpr/*J*/= $this().ParseConstantExpression();
      if (AssertExpr.isInvalid()) {
        $this().SkipMalformedDecl();
        return null;
      }
      
      ActionResultTTrue<Expr /*P*/ > AssertMessage/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if ($this().Tok.is(tok.TokenKind.r_paren)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok, $this().getLangOpts().CPlusPlus1z ? diag.warn_cxx14_compat_static_assert_no_message : diag.ext_static_assert_no_message)), 
              ($this().getLangOpts().CPlusPlus1z ? new FixItHint() : FixItHint.CreateInsertion($this().Tok.getLocation(), new StringRef(/*KEEP_STR*/", \"\"")))));
        } finally {
          $c$.$destroy();
        }
      } else {
        if ($this().ExpectAndConsume(tok.TokenKind.comma)) {
          $this().SkipUntil(tok.TokenKind.semi);
          return null;
        }
        if (!$this().isTokenStringLiteral()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_expected_string_literal)), 
                /*Source='static_assert'*/ 1));
            $this().SkipMalformedDecl();
            return null;
          } finally {
            $c$.$destroy();
          }
        }
        
        AssertMessage.$assignMove($this().ParseStringLiteralExpression());
        if (AssertMessage.isInvalid()) {
          $this().SkipMalformedDecl();
          return null;
        }
      }
      
      T.consumeClose();
      
      DeclEnd.$assignMove($this().Tok.getLocation());
      $this().ExpectAndConsumeSemi(diag.err_expected_semi_after_static_assert);
      
      return $this().Actions.ActOnStaticAssertDeclaration(new SourceLocation(StaticAssertLoc), 
          AssertExpr.get(), 
          AssertMessage.get(), 
          T.getCloseLocation());
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseNamespaceAlias - Parse the part after the '=' in a namespace
/// alias definition.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseNamespaceAlias">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 254,
   FQN="clang::Parser::ParseNamespaceAlias", NM="_ZN5clang6Parser19ParseNamespaceAliasENS_14SourceLocationES1_PNS_14IdentifierInfoERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser19ParseNamespaceAliasENS_14SourceLocationES1_PNS_14IdentifierInfoERS1_")
  //</editor-fold>
  protected /*private*/ Decl /*P*/ ParseNamespaceAlias(SourceLocation NamespaceLoc, 
                     SourceLocation AliasLoc, 
                     IdentifierInfo /*P*/ Alias, 
                     final SourceLocation /*&*/ DeclEnd) {
    CXXScopeSpec SS = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.equal)) : "Not equal token";
      
      $this().ConsumeToken(); // eat the '='.
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        $this().Actions.CodeCompleteNamespaceAliasDecl($this().getCurScope());
        $this().cutOffParsing();
        return null;
      }
      
      SS/*J*/= new CXXScopeSpec();
      // Parse (optional) nested-name-specifier.
      $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), /*EnteringContext=*/ false);
      if (SS.isInvalid() || $this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_namespace_name)));
          // Skip to end of the definition and eat the ';'.
          $this().SkipUntil(tok.TokenKind.semi);
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse identifier.
      IdentifierInfo /*P*/ Ident = $this().Tok.getIdentifierInfo();
      SourceLocation IdentLoc = $this().ConsumeToken();
      
      // Eat the ';'.
      DeclEnd.$assignMove($this().Tok.getLocation());
      if ($this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_semi_after_namespace_name)) {
        $this().SkipUntil(tok.TokenKind.semi);
      }
      
      return $this().Actions.ActOnNamespaceAliasDef($this().getCurScope(), new SourceLocation(NamespaceLoc), new SourceLocation(AliasLoc), 
          Alias, SS, new SourceLocation(IdentLoc), Ident);
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  }


//===--------------------------------------------------------------------===//
// C++ 9: classes [class] and C structs/unions.

/// Determine whether the following tokens are valid after a type-specifier
/// which could be a standalone declaration. This will conservatively return
/// true if there's any doubt, and is appropriate for insert-';' fixits.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::isValidAfterTypeSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1081,
   FQN="clang::Parser::isValidAfterTypeSpecifier", NM="_ZN5clang6Parser25isValidAfterTypeSpecifierEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser25isValidAfterTypeSpecifierEb")
  //</editor-fold>
  protected /*private*/ boolean isValidAfterTypeSpecifier(boolean CouldBeBitfield) {
    // This switch enumerates the valid "follow" set for type-specifiers.
    switch ($this().Tok.getKind()) {
     default:
      break;
     case tok.TokenKind.semi: // struct foo {...} ;
     case tok.TokenKind.star: // struct foo {...} *         P;
     case tok.TokenKind.amp: // struct foo {...} &         R = ...
     case tok.TokenKind.ampamp: // struct foo {...} &&        R = ...
     case tok.TokenKind.identifier: // struct foo {...} V         ;
     case tok.TokenKind.r_paren: //(struct foo {...} )         {4}
     case tok.TokenKind.annot_cxxscope: // struct foo {...} a::       b;
     case tok.TokenKind.annot_typename: // struct foo {...} a         ::b;
     case tok.TokenKind.annot_template_id: // struct foo {...} a<int>    ::b;
     case tok.TokenKind.l_paren: // struct foo {...} (         x);
     case tok.TokenKind.comma: // __builtin_offsetof(struct foo{...} ,
     case tok.TokenKind.kw_operator: // struct foo       operator  ++() {...}
     case tok.TokenKind.kw___declspec: // struct foo {...} __declspec(...)
     case tok.TokenKind.l_square: // void f(struct f  [         3])
     case tok.TokenKind.ellipsis: // void f(struct f  ...       [Ns])
      // FIXME: we should emit semantic diagnostic when declaration
      // attribute is in type attribute position.
     case tok.TokenKind.kw___attribute: // struct foo __attribute__((used)) x;
     case tok.TokenKind.annot_pragma_pack: // struct foo {...} _Pragma(pack(pop));
      // struct foo {...} _Pragma(section(...));
     case tok.TokenKind.annot_pragma_ms_pragma:
     case tok.TokenKind.annot_pragma_ms_vtordisp:
     case tok.TokenKind.annot_pragma_ms_pointers_to_members:
      // struct foo {...} _Pragma(pointers_to_members(...));
      return true;
     case tok.TokenKind.colon:
      return CouldBeBitfield; // enum E { ... }   :         2;
      // Microsoft compatibility
     case tok.TokenKind.kw___cdecl: // struct foo {...} __cdecl      x;
     case tok.TokenKind.kw___fastcall: // struct foo {...} __fastcall   x;
     case tok.TokenKind.kw___stdcall: // struct foo {...} __stdcall    x;
     case tok.TokenKind.kw___thiscall: // struct foo {...} __thiscall   x;
     case tok.TokenKind.kw___vectorcall: // struct foo {...} __vectorcall x;
      // We will diagnose these calling-convention specifiers on non-function
      // declarations later, so claim they are valid after a type specifier.
      return $this().getLangOpts().MicrosoftExt;
     case tok.TokenKind.kw_const: // struct foo {...} const     x;
     case tok.TokenKind.kw_volatile: // struct foo {...} volatile  x;
     case tok.TokenKind.kw_restrict: // struct foo {...} restrict  x;
     case tok.TokenKind.kw__Atomic: // struct foo {...} _Atomic   x;
     case tok.TokenKind.kw___unaligned: // struct foo {...} __unaligned *x;
      // Function specifiers
      // Note, no 'explicit'. An explicit function must be either a conversion
      // operator or a constructor. Either way, it can't have a return type.
     case tok.TokenKind.kw_inline: // struct foo       inline    f();
     case tok.TokenKind.kw_virtual: // struct foo       virtual   f();
     case tok.TokenKind.kw_friend: // struct foo       friend    f();
      // Storage-class specifiers
     case tok.TokenKind.kw_static: // struct foo {...} static    x;
     case tok.TokenKind.kw_extern: // struct foo {...} extern    x;
     case tok.TokenKind.kw_typedef: // struct foo {...} typedef   x;
     case tok.TokenKind.kw_register: // struct foo {...} register  x;
     case tok.TokenKind.kw_auto: // struct foo {...} auto      x;
     case tok.TokenKind.kw_mutable: // struct foo {...} mutable   x;
     case tok.TokenKind.kw_thread_local: // struct foo {...} thread_local x;
     case tok.TokenKind.kw_constexpr: // struct foo {...} constexpr x;
      // As shown above, type qualifiers and storage class specifiers absolutely
      // can occur after class specifiers according to the grammar.  However,
      // almost no one actually writes code like this.  If we see one of these,
      // it is much more likely that someone missed a semi colon and the
      // type/storage class specifier we're seeing is part of the *next*
      // intended declaration, as in:
      //
      //   struct foo { ... }
      //   typedef int X;
      //
      // We'd really like to emit a missing semicolon error instead of emitting
      // an error on the 'int' saying that you can't have two type specifiers in
      // the same declaration of X.  Because of this, we look ahead past this
      // token to see if it's a type specifier.  If so, we know the code is
      // otherwise invalid, so we can produce the expected semi error.
      if (!$this().isKnownToBeTypeSpecifier($this().NextToken())) {
        return true;
      }
      break;
     case tok.TokenKind.r_brace: // struct bar { struct foo {...} }
      // Missing ';' at end of struct is accepted as an extension in C mode.
      if (!$this().getLangOpts().CPlusPlus) {
        return true;
      }
      break;
     case tok.TokenKind.greater:
      // template<class T = class X>
      return $this().getLangOpts().CPlusPlus;
    }
    return false;
  }


/// ParseClassSpecifier - Parse a C++ class-specifier [C++ class] or
/// elaborated-type-specifier [C++ dcl.type.elab]; we can't tell which
/// until we reach the start of a definition or see a token that
/// cannot start a definition.
///
///       class-specifier: [C++ class]
///         class-head '{' member-specification[opt] '}'
///         class-head '{' member-specification[opt] '}' attributes[opt]
///       class-head:
///         class-key identifier[opt] base-clause[opt]
///         class-key nested-name-specifier identifier base-clause[opt]
///         class-key nested-name-specifier[opt] simple-template-id
///                          base-clause[opt]
/// [GNU]   class-key attributes[opt] identifier[opt] base-clause[opt]
/// [GNU]   class-key attributes[opt] nested-name-specifier
///                          identifier base-clause[opt]
/// [GNU]   class-key attributes[opt] nested-name-specifier[opt]
///                          simple-template-id base-clause[opt]
///       class-key:
///         'class'
///         'struct'
///         'union'
///
///       elaborated-type-specifier: [C++ dcl.type.elab]
///         class-key ::[opt] nested-name-specifier[opt] identifier
///         class-key ::[opt] nested-name-specifier[opt] 'template'[opt]
///                          simple-template-id
///
///  Note that the C++ class-specifier and elaborated-type-specifier,
///  together, subsume the C99 struct-or-union-specifier:
///
///       struct-or-union-specifier: [C99 6.7.2.1]
///         struct-or-union identifier[opt] '{' struct-contents '}'
///         struct-or-union identifier
/// [GNU]   struct-or-union attributes[opt] identifier[opt] '{' struct-contents
///                                                         '}' attributes[opt]
/// [GNU]   struct-or-union attributes[opt] identifier
///       struct-or-union:
///         'struct'
///         'union'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseClassSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1213,
   FQN="clang::Parser::ParseClassSpecifier", NM="_ZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ void ParseClassSpecifier(/*tok.TokenKind*/char TagTokKind, 
                     SourceLocation StartLoc, final DeclSpec /*&*/ DS, 
                     final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo, 
                     AccessSpecifier AS, 
                     boolean EnteringContext, DeclSpecContext DSC, 
                     final ParsedAttributesWithRange /*&*/ Attributes) {
    SuppressAccessChecks diagsFromTag = null;
    ParsedAttributesWithRange attrs = null;
    PreserveAtomicIdentifierInfoRAII AtomicTokenGuard = null;
    try {
      TypeSpecifierType TagType;
      if (TagTokKind == tok.TokenKind.kw_struct) {
        TagType = DeclSpec.TST_struct;
      } else if (TagTokKind == tok.TokenKind.kw___interface) {
        TagType = DeclSpec.TST_interface;
      } else if (TagTokKind == tok.TokenKind.kw_class) {
        TagType = DeclSpec.TST_class;
      } else {
        assert (TagTokKind == tok.TokenKind.kw_union) : "Not a class specifier";
        TagType = DeclSpec.TST_union;
      }
      if ($this().Tok.is(tok.TokenKind.code_completion)) {
        // Code completion for a struct, class, or union name.
        $this().Actions.CodeCompleteTag($this().getCurScope(), TagType.getValue());
        $this().cutOffParsing();
        return;
      }
      
      // C++03 [temp.explicit] 14.7.2/8:
      //   The usual access checking rules do not apply to names used to specify
      //   explicit instantiations.
      //
      // As an extension we do not perform access checking on the names used to
      // specify explicit specializations either. This is important to allow
      // specializing traits classes for private types.
      //
      // Note that we don't suppress if this turns out to be an elaborated
      // type specifier.
      boolean shouldDelayDiagsInTag = (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation
         || TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitSpecialization);
      diagsFromTag/*J*/= new SuppressAccessChecks(/*Deref*/$this(), shouldDelayDiagsInTag);
      
      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      // If attributes exist after tag, parse them.
      $this().MaybeParseGNUAttributes(attrs);
      $this().MaybeParseMicrosoftDeclSpecs(attrs);
      
      // Parse inheritance specifiers.
      if ($this().Tok.isOneOf$T(tok.TokenKind.kw___single_inheritance, 
          tok.TokenKind.kw___multiple_inheritance, 
          tok.TokenKind.kw___virtual_inheritance)) {
        $this().ParseMicrosoftInheritanceClassAttributes(attrs);
      }
      
      // If C++0x attributes exist here, parse them.
      // FIXME: Are we consistent with the ordering of parsing of different
      // styles of attributes?
      $this().MaybeParseCXX11Attributes(attrs);
      
      // Source location used by FIXIT to insert misplaced
      // C++11 attributes
      SourceLocation AttrFixitLoc = $this().Tok.getLocation();
      if (TagType == DeclSpec.TST_struct
         && $this().Tok.isNot(tok.TokenKind.identifier)
         && !$this().Tok.isAnnotation()
         && ($this().Tok.getIdentifierInfo() != null)
         && $this().Tok.isOneOf$T(tok.TokenKind.kw___is_abstract, 
          tok.TokenKind.kw___is_arithmetic, 
          tok.TokenKind.kw___is_array, 
          tok.TokenKind.kw___is_assignable, 
          tok.TokenKind.kw___is_base_of, 
          tok.TokenKind.kw___is_class, 
          tok.TokenKind.kw___is_complete_type, 
          tok.TokenKind.kw___is_compound, 
          tok.TokenKind.kw___is_const, 
          tok.TokenKind.kw___is_constructible, 
          tok.TokenKind.kw___is_convertible, 
          tok.TokenKind.kw___is_convertible_to, 
          tok.TokenKind.kw___is_destructible, 
          tok.TokenKind.kw___is_empty, 
          tok.TokenKind.kw___is_enum, 
          tok.TokenKind.kw___is_floating_point, 
          tok.TokenKind.kw___is_final, 
          tok.TokenKind.kw___is_function, 
          tok.TokenKind.kw___is_fundamental, 
          tok.TokenKind.kw___is_integral, 
          tok.TokenKind.kw___is_interface_class, 
          tok.TokenKind.kw___is_literal, 
          tok.TokenKind.kw___is_lvalue_expr, 
          tok.TokenKind.kw___is_lvalue_reference, 
          tok.TokenKind.kw___is_member_function_pointer, 
          tok.TokenKind.kw___is_member_object_pointer, 
          tok.TokenKind.kw___is_member_pointer, 
          tok.TokenKind.kw___is_nothrow_assignable, 
          tok.TokenKind.kw___is_nothrow_constructible, 
          tok.TokenKind.kw___is_nothrow_destructible, 
          tok.TokenKind.kw___is_object, 
          tok.TokenKind.kw___is_pod, 
          tok.TokenKind.kw___is_pointer, 
          tok.TokenKind.kw___is_polymorphic, 
          tok.TokenKind.kw___is_reference, 
          tok.TokenKind.kw___is_rvalue_expr, 
          tok.TokenKind.kw___is_rvalue_reference, 
          tok.TokenKind.kw___is_same, 
          tok.TokenKind.kw___is_scalar, 
          tok.TokenKind.kw___is_sealed, 
          tok.TokenKind.kw___is_signed, 
          tok.TokenKind.kw___is_standard_layout, 
          tok.TokenKind.kw___is_trivial, 
          tok.TokenKind.kw___is_trivially_assignable, 
          tok.TokenKind.kw___is_trivially_constructible, 
          tok.TokenKind.kw___is_trivially_copyable, 
          tok.TokenKind.kw___is_union, 
          tok.TokenKind.kw___is_unsigned, 
          tok.TokenKind.kw___is_void, 
          tok.TokenKind.kw___is_volatile)) {
        // GNU libstdc++ 4.2 and libc++ use certain intrinsic names as the
        // name of struct templates, but some are keywords in GCC >= 4.3
        // and Clang. Therefore, when we see the token sequence "struct
        // X", make X into a normal identifier rather than a keyword, to
        // allow libstdc++ 4.2 and libc++ to work properly.
        $this().TryKeywordIdentFallback(true);
      }
      
      // HACK: MSVC doesn't consider _Atomic to be a keyword and its STL
      // implementation for VS2013 uses _Atomic as an identifier for one of the
      // classes in <atomic>.  When we are parsing 'struct _Atomic', don't consider
      // '_Atomic' to be a keyword.  We are careful to undo this so that clang can
      // use '_Atomic' in its own header files.
      boolean ShouldChangeAtomicToIdentifier = $this().getLangOpts().MSVCCompat
         && $this().Tok.is(tok.TokenKind.kw__Atomic)
         && TagType == DeclSpec.TST_struct;
      AtomicTokenGuard/*J*/= new PreserveAtomicIdentifierInfoRAII($this().Tok, ShouldChangeAtomicToIdentifier);
      
      // Parse the (optional) nested-name-specifier.
      final CXXScopeSpec /*&*/ SS = DS.getTypeSpecScope();
      if ($this().getLangOpts().CPlusPlus) {
        ColonProtectionRAIIObject X = null;
        CXXScopeSpec Spec = null;
        try {
          // "FOO : BAR" is not a potential typo for "FOO::BAR".  In this context it
          // is a base-specifier-list.
          X/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
          
          Spec/*J*/= new CXXScopeSpec();
          boolean HasValidSpec = true;
          if ($this().ParseOptionalCXXScopeSpecifier(Spec, new OpaquePtr<QualType>(null), EnteringContext)) {
            DS.SetTypeSpecError();
            HasValidSpec = false;
          }
          if (Spec.isSet()) {
            if ($this().Tok.isNot(tok.TokenKind.identifier) && $this().Tok.isNot(tok.TokenKind.annot_template_id)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.identifier));
                HasValidSpec = false;
              } finally {
                $c$.$destroy();
              }
            }
          }
          if (HasValidSpec) {
            SS.$assign(Spec);
          }
        } finally {
          if (Spec != null) { Spec.$destroy(); }
          if (X != null) { X.$destroy(); }
        }
      }
      
      SmallVector<TemplateParameterList /*P*/> /*P*/ TemplateParams = TemplateInfo.TemplateParams;
      
      // Parse the (optional) class name or simple-template-id.
      IdentifierInfo /*P*/ Name = null;
      SourceLocation NameLoc/*J*/= new SourceLocation();
      TemplateIdAnnotation /*P*/ TemplateId = null;
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        Name = $this().Tok.getIdentifierInfo();
        NameLoc.$assignMove($this().ConsumeToken());
        if ($this().Tok.is(tok.TokenKind.less) && $this().getLangOpts().CPlusPlus) {
          SmallVector<ParsedTemplateArgument> TemplateArgs = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // The name was supposed to refer to a template, but didn't.
            // Eat the template argument list and try to continue parsing this as
            // a class (or template thereof).
            TemplateArgs/*J*/= new SmallVector<ParsedTemplateArgument>(16, new ParsedTemplateArgument());
            SourceLocation LAngleLoc/*J*/= new SourceLocation(), RAngleLoc/*J*/= new SourceLocation();
            if ($this().ParseTemplateIdAfterTemplateName(new OpaquePtr<TemplateName>(null), new SourceLocation(NameLoc), SS, true, LAngleLoc, TemplateArgs, RAngleLoc)) {
              // We couldn't parse the template argument list at all, so don't
              // try to give any location information for the list.
              LAngleLoc.$assign(RAngleLoc.$assignMove(new SourceLocation()));
            }
            
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_IdentifierInfo$C$P($out_DiagnosticBuilder$C_TokenKind($out$Same2Bool($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_explicit_spec_non_template)), 
                            (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation)), 
                        TagTokKind), Name), new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc)));
            
            // Strip off the last template parameter list if it was empty, since
            // we've removed its template argument list.
            if ((TemplateParams != null) && TemplateInfo.LastParameterListWasEmpty) {
              if ($greater_uint(TemplateParams.size(), 1)) {
                TemplateParams.pop_back();
              } else {
                TemplateParams = null;
                ((/*const_cast*/ParsedTemplateInfo /*&*/ )(TemplateInfo)).Kind
                   = ParsedTemplateInfo.Unnamed_enum.NonTemplate;
              }
            } else if (TemplateInfo.Kind
               == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation) {
              // Pretend this is just a forward declaration.
              TemplateParams = null;
              ((/*const_cast*/ParsedTemplateInfo /*&*/ )(TemplateInfo)).Kind
                 = ParsedTemplateInfo.Unnamed_enum.NonTemplate;
              ((/*const_cast*/ParsedTemplateInfo /*&*/ )(TemplateInfo)).TemplateLoc.$assignMove(
                  new SourceLocation()
              );
              ((/*const_cast*/ParsedTemplateInfo /*&*/ )(TemplateInfo)).ExternLoc.$assignMove(
                  new SourceLocation()
              );
            }
          } finally {
            if (TemplateArgs != null) { TemplateArgs.$destroy(); }
            $c$.$destroy();
          }
        }
      } else if ($this().Tok.is(tok.TokenKind.annot_template_id)) {
        TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
        NameLoc.$assignMove($this().ConsumeToken());
        if (TemplateId.Kind != TemplateNameKind.TNK_Type_template
           && TemplateId.Kind != TemplateNameKind.TNK_Dependent_template_name) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // The template-name in the simple-template-id refers to
            // something other than a class template. Give an appropriate
            // error message and skip to the ';'.
            SourceRange Range/*J*/= new SourceRange(/*NO_COPY*/NameLoc);
            if (SS.isNotEmpty()) {
              Range.setBegin(SS.getBeginLoc());
            }
            
            // FIXME: Name may be null here.
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(TemplateId.LAngleLoc), diag.err_template_spec_syntax_non_template)), 
                        TemplateId.Name), ((/*static_cast*/int)(TemplateId.Kind.getValue()))), /*NO_COPY*/Range));
            
            DS.SetTypeSpecError();
            $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // There are four options here.
      //  - If we are in a trailing return type, this is always just a reference,
      //    and we must not try to parse a definition. For instance,
      //      [] () -> struct S { };
      //    does not define a type.
      //  - If we have 'struct foo {...', 'struct foo :...',
      //    'struct foo final :' or 'struct foo final {', then this is a definition.
      //  - If we have 'struct foo;', then this is either a forward declaration
      //    or a friend declaration, which have to be treated differently.
      //  - Otherwise we have something like 'struct foo xyz', a reference.
      //
      //  We also detect these erroneous cases to provide better diagnostic for
      //  C++11 attributes parsing.
      //  - attributes follow class name:
      //    struct foo [[]] {};
      //  - attributes appear before or after 'final':
      //    struct foo [[]] final [[]] {};
      //
      // However, in type-specifier-seq's, things look like declarations but are
      // just references, e.g.
      //   new struct s;
      // or
      //   &T::operator struct s;
      // For these, DSC is DSC_type_specifier or DSC_alias_declaration.
      
      // If there are attributes after class name, parse them.
      $this().MaybeParseCXX11Attributes(Attributes);
      
      final /*const*/ PrintingPolicy /*&*/ Policy = $this().Actions.getASTContext().getPrintingPolicy();
      Sema.TagUseKind TUK;
      if (DSC == DeclSpecContext.DSC_trailing) {
        TUK = Sema.TagUseKind.TUK_Reference;
      } else if ($this().Tok.is(tok.TokenKind.l_brace)
         || ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.colon))
         || ($this().isCXX11FinalKeyword()
         && ($this().NextToken().is(tok.TokenKind.l_brace) || $this().NextToken().is(tok.TokenKind.colon)))) {
        if (DS.isFriendSpecified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // C++ [class.friend]p2:
            //   A class shall not be defined in a friend declaration.
            $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag($this().Tok.getLocation(), diag.err_friend_decl_defines_type)), 
                new SourceRange(DS.getFriendSpecLoc())));
            
            // Skip everything up to the semicolon, so that this looks like a proper
            // friend class (or template thereof) declaration.
            $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
            TUK = Sema.TagUseKind.TUK_Friend;
          } finally {
            $c$.$destroy();
          }
        } else {
          // Okay, this is a class definition.
          TUK = Sema.TagUseKind.TUK_Definition;
        }
      } else if ($this().isCXX11FinalKeyword() && ($this().NextToken().is(tok.TokenKind.l_square)
         || $this().NextToken().is(tok.TokenKind.kw_alignas))) {
        TentativeParsingAction PA = null;
        try {
          // We can't tell if this is a definition or reference
          // until we skipped the 'final' and C++11 attribute specifiers.
          PA/*J*/= new TentativeParsingAction(/*Deref*/$this());
          
          // Skip the 'final' keyword.
          $this().ConsumeToken();
          
          // Skip C++11 attribute specifiers.
          while (true) {
            if ($this().Tok.is(tok.TokenKind.l_square) && $this().NextToken().is(tok.TokenKind.l_square)) {
              $this().ConsumeBracket();
              if (!$this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi)) {
                break;
              }
            } else if ($this().Tok.is(tok.TokenKind.kw_alignas) && $this().NextToken().is(tok.TokenKind.l_paren)) {
              $this().ConsumeToken();
              $this().ConsumeParen();
              if (!$this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi)) {
                break;
              }
            } else {
              break;
            }
          }
          if ($this().Tok.isOneOf(tok.TokenKind.l_brace, tok.TokenKind.colon)) {
            TUK = Sema.TagUseKind.TUK_Definition;
          } else {
            TUK = Sema.TagUseKind.TUK_Reference;
          }
          
          PA.Revert();
        } finally {
          if (PA != null) { PA.$destroy(); }
        }
      } else if (!isTypeSpecifier(DSC)
         && ($this().Tok.is(tok.TokenKind.semi)
         || ($this().Tok.isAtStartOfLine() && !$this().isValidAfterTypeSpecifier(false)))) {
        TUK = DS.isFriendSpecified() ? Sema.TagUseKind.TUK_Friend : Sema.TagUseKind.TUK_Declaration;
        if ($this().Tok.isNot(tok.TokenKind.semi)) {
          final /*const*/ PrintingPolicy /*&*/ PPol = $this().Actions.getASTContext().getPrintingPolicy();
          // A semicolon was missing after this declaration. Diagnose and recover.
          $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, 
              new StringRef(DeclSpec.getSpecifierName(TagType, PPol)));
          $this().PP.EnterToken($this().Tok);
          $this().Tok.setKind(tok.TokenKind.semi);
        }
      } else {
        TUK = Sema.TagUseKind.TUK_Reference;
      }
      
      // Forbid misplaced attributes. In cases of a reference, we pass attributes
      // to caller to handle.
      if (TUK != Sema.TagUseKind.TUK_Reference) {
        // If this is not a reference, then the only possible
        // valid place for C++11 attributes to appear here
        // is between class-key and class-name. If there are
        // any attributes after class-name, we try a fixit to move
        // them to the right place.
        SourceRange AttrRange = new SourceRange(Attributes.Range);
        if (AttrRange.isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(AttrRange.getBegin(), diag.err_attributes_not_allowed)), 
                        /*NO_COPY*/AttrRange), 
                    FixItHint.CreateInsertionFromRange(/*NO_COPY*/AttrFixitLoc, 
                        new CharSourceRange(/*NO_COPY*/AttrRange, true))), 
                FixItHint.CreateRemoval(/*NO_COPY*/AttrRange)));
            
            // Recover by adding misplaced attributes to the attribute list
            // of the class so they can be applied on the class later.
            attrs.takeAllFrom(Attributes);
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // If this is an elaborated type specifier, and we delayed
      // diagnostics before, just merge them into the current pool.
      if (shouldDelayDiagsInTag) {
        diagsFromTag.done();
        if (TUK == Sema.TagUseKind.TUK_Reference) {
          diagsFromTag.redelay();
        }
      }
      if (!(Name != null) && !(TemplateId != null) && (DS.getTypeSpecType() == DeclSpec.TST_error
         || TUK != Sema.TagUseKind.TUK_Definition)) {
        if (DS.getTypeSpecType() != DeclSpec.TST_error) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // We have a declaration or reference to an anonymous class.
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_anon_type_definition)), 
                DeclSpec.getSpecifierName(TagType, Policy)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // If we are parsing a definition and stop at a base-clause, continue on
        // until the semicolon.  Continuing from the comma will just trick us into
        // thinking we are seeing a variable declaration.
        if (TUK == Sema.TagUseKind.TUK_Definition && $this().Tok.is(tok.TokenKind.colon)) {
          $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
        } else {
          $this().SkipUntil(tok.TokenKind.comma, SkipUntilFlags.StopAtSemi);
        }
        return;
      }
      
      // Create the tag portion of the class or class template.
      ActionResult<Decl /*P*/ > TagOrTempResult = new ActionResult<Decl /*P*/ >(true); // invalid
      ActionResult<OpaquePtr<QualType> > TypeResult = new ActionResult<OpaquePtr<QualType> >(true); // invalid
      
      bool$ref Owned = create_bool$ref(false);
      Sema.SkipBodyInfo SkipBody/*J*/= new Sema.SkipBodyInfo();
      if ((TemplateId != null)) {
        // Explicit specialization, class template partial specialization,
        // or explicit instantiation.
        MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateId.getTemplateArgs(), 
            TemplateId.NumArgs, false);
        if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation
           && TUK == Sema.TagUseKind.TUK_Declaration) {
          // This is an explicit instantiation of a class template.
          $this().ProhibitAttributes(attrs);
          
          TagOrTempResult.$assignMove(
              $this().Actions.ActOnExplicitInstantiation($this().getCurScope(), 
                  new SourceLocation(TemplateInfo.ExternLoc), 
                  new SourceLocation(TemplateInfo.TemplateLoc), 
                  TagType.getValue(), 
                  new SourceLocation(StartLoc), 
                  SS, 
                  new OpaquePtr<TemplateName>(TemplateId.Template), 
                  new SourceLocation(TemplateId.TemplateNameLoc), 
                  new SourceLocation(TemplateId.LAngleLoc), 
                  new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), 
                  new SourceLocation(TemplateId.RAngleLoc), 
                  attrs.getList())
          );
          // Friend template-ids are treated as references unless
          // they have template headers, in which case they're ill-formed
          // (FIXME: "template <class T> friend class A<T>::B<int>;").
          // We diagnose this error in ActOnClassTemplateSpecialization.
        } else if (TUK == Sema.TagUseKind.TUK_Reference
           || (TUK == Sema.TagUseKind.TUK_Friend
           && TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.NonTemplate)) {
          $this().ProhibitAttributes(attrs);
          TypeResult.$assignMove($this().Actions.ActOnTagTemplateIdType(TUK, TagType, new SourceLocation(StartLoc), 
                  TemplateId.SS, 
                  new SourceLocation(TemplateId.TemplateKWLoc), 
                  new OpaquePtr<TemplateName>(TemplateId.Template), 
                  new SourceLocation(TemplateId.TemplateNameLoc), 
                  new SourceLocation(TemplateId.LAngleLoc), 
                  new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), 
                  new SourceLocation(TemplateId.RAngleLoc)));
        } else {
          // This is an explicit specialization or a class template
          // partial specialization.
          SmallVector<TemplateParameterList /*P*/> FakedParamLists/*J*/= new SmallVector<TemplateParameterList /*P*/>(4, null);
          if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation) {
            // This looks like an explicit instantiation, because we have
            // something like
            //
            //   template class Foo<X>
            //
            // but it actually has a definition. Most likely, this was
            // meant to be an explicit specialization, but the user forgot
            // the '<>' after 'template'.
            // It this is friend declaration however, since it cannot have a
            // template header, it is most likely that the user meant to
            // remove the 'template' keyword.
            assert ((TUK == Sema.TagUseKind.TUK_Definition || TUK == Sema.TagUseKind.TUK_Friend)) : "Expected a definition here";
            if (TUK == Sema.TagUseKind.TUK_Friend) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(DS.getFriendSpecLoc(), diag.err_friend_explicit_instantiation)));
                TemplateParams = null;
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                SourceLocation LAngleLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/TemplateInfo.TemplateLoc);
                $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag(new SourceLocation(TemplateId.TemplateNameLoc), 
                            diag.err_explicit_instantiation_with_definition)), 
                        new SourceRange(/*NO_COPY*/TemplateInfo.TemplateLoc)), 
                    FixItHint.CreateInsertion(/*NO_COPY*/LAngleLoc, new StringRef(/*KEEP_STR*/"<>"))));
                
                // Create a fake template parameter list that contains only
                // "template<>", so that we treat this construct as a class
                // template specialization.
                FakedParamLists.push_back($this().Actions.ActOnTemplateParameterList(0, new SourceLocation(), new SourceLocation(TemplateInfo.TemplateLoc), new SourceLocation(LAngleLoc), new ArrayRef<Decl /*P*/ >(None), 
                        new SourceLocation(LAngleLoc), (Expr /*P*/ )null));
                TemplateParams = $AddrOf(FakedParamLists);
              } finally {
                $c$.$destroy();
              }
            }
          }
          
          // Build the class template specialization.
          TagOrTempResult.$assignMove($this().Actions.ActOnClassTemplateSpecialization($this().getCurScope(), TagType.getValue(), TUK, new SourceLocation(StartLoc), DS.getModulePrivateSpecLoc(), 
                  $Deref(TemplateId), attrs.getList(), 
                  new MutableArrayRef<TemplateParameterList /*P*/ >((TemplateParams != null) ? $AddrOf((/*Deref*/TemplateParams).data()) : create_type$ptr((TemplateParameterList /*P*/ /*P*/ )null), 
                      (TemplateParams != null) ? TemplateParams.size() : 0, true), 
                  $AddrOf(SkipBody)));
        }
      } else if (TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation
         && TUK == Sema.TagUseKind.TUK_Declaration) {
        // Explicit instantiation of a member of a class template
        // specialization, e.g.,
        //
        //   template struct Outer<int>::Inner;
        //
        $this().ProhibitAttributes(attrs);
        
        TagOrTempResult.$assignMove(
            $this().Actions.ActOnExplicitInstantiation($this().getCurScope(), 
                new SourceLocation(TemplateInfo.ExternLoc), 
                new SourceLocation(TemplateInfo.TemplateLoc), 
                TagType.getValue(), new SourceLocation(StartLoc), SS, Name, 
                new SourceLocation(NameLoc), attrs.getList())
        );
      } else if (TUK == Sema.TagUseKind.TUK_Friend
         && TemplateInfo.Kind != ParsedTemplateInfo.Unnamed_enum.NonTemplate) {
        $this().ProhibitAttributes(attrs);
        
        TagOrTempResult.$assign(
            $this().Actions.ActOnTemplatedFriendTag($this().getCurScope(), DS.getFriendSpecLoc(), 
                TagType.getValue(), new SourceLocation(StartLoc), SS, 
                Name, new SourceLocation(NameLoc), attrs.getList(), 
                new MutableArrayRef<TemplateParameterList /*P*/ >((TemplateParams != null) ? $AddrOf((/*Deref*/TemplateParams).data()) : create_type$ptr((TemplateParameterList /*P*/ /*P*/ )null), 
                    (TemplateParams != null) ? TemplateParams.size() : 0, true))
        );
      } else {
        if (TUK != Sema.TagUseKind.TUK_Declaration && TUK != Sema.TagUseKind.TUK_Definition) {
          $this().ProhibitAttributes(attrs);
        }
        if (TUK == Sema.TagUseKind.TUK_Definition
           && TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.ExplicitInstantiation) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If the declarator-id is not a template-id, issue a diagnostic and
            // recover by ignoring the 'template' keyword.
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_template_defn_explicit_instantiation)), 
                    1), FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TemplateInfo.TemplateLoc))));
            TemplateParams = null;
          } finally {
            $c$.$destroy();
          }
        }
        
        bool$ref IsDependent = create_bool$ref(false);
        
        // Don't pass down template parameter lists if this is just a tag
        // reference.  For example, we don't need the template parameters here:
        //   template <class T> class A *makeA(T t);
        MutableArrayRef<TemplateParameterList /*P*/ > TParams/*J*/= new MutableArrayRef<TemplateParameterList /*P*/ >(true);
        if (TUK != Sema.TagUseKind.TUK_Reference && (TemplateParams != null)) {
          TParams.$assignMove(
              new MutableArrayRef<TemplateParameterList /*P*/ >($AddrOf((/*Deref*/TemplateParams).data()), TemplateParams.size(), true)
          );
        }
        
        $this().handleDeclspecAlignBeforeClassKey(attrs, DS, TUK);
        
        // Declaration or definition of a class type
        TagOrTempResult.$assign($this().Actions.ActOnTag($this().getCurScope(), TagType.getValue(), TUK, new SourceLocation(StartLoc), 
                SS, Name, new SourceLocation(NameLoc), attrs.getList(), AS, 
                DS.getModulePrivateSpecLoc(), 
                new MutableArrayRef<TemplateParameterList /*P*/ >(TParams), Owned, IsDependent, 
                new SourceLocation(), false, 
                new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<>()), 
                DSC == DeclSpecContext.DSC_type_specifier, 
                $AddrOf(SkipBody)));
        
        // If ActOnTag said the type was dependent, try again with the
        // less common call.
        if (IsDependent.$deref()) {
          assert (TUK == Sema.TagUseKind.TUK_Reference || TUK == Sema.TagUseKind.TUK_Friend);
          TypeResult.$assignMove($this().Actions.ActOnDependentTag($this().getCurScope(), TagType.getValue(), TUK, 
                  SS, Name, new SourceLocation(StartLoc), new SourceLocation(NameLoc)));
        }
      }
      
      // If there is a body, parse it and inform the actions module.
      if (TUK == Sema.TagUseKind.TUK_Definition) {
        assert ($this().Tok.is(tok.TokenKind.l_brace) || ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.colon)) || $this().isCXX11FinalKeyword());
        if (SkipBody.ShouldSkip) {
          $this().SkipCXXMemberSpecification(new SourceLocation(StartLoc), new SourceLocation(AttrFixitLoc), TagType.getValue(), 
              TagOrTempResult.get());
        } else if ($this().getLangOpts().CPlusPlus) {
          $this().ParseCXXMemberSpecification(new SourceLocation(StartLoc), new SourceLocation(AttrFixitLoc), attrs, TagType.getValue(), 
              TagOrTempResult.get());
        } else {
          $this().ParseStructUnionBody(new SourceLocation(StartLoc), TagType.getValue(), TagOrTempResult.get());
        }
      }
      
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref();
      boolean Result;
      if (!TypeResult.isInvalid()) {
        Result = DS.SetTypeSpecType(DeclSpec.TST_typename, new SourceLocation(StartLoc), 
            new SourceLocation(NameLoc.isValid() ? NameLoc : StartLoc), 
            PrevSpec, DiagID, TypeResult.get(), Policy);
      } else if (!TagOrTempResult.isInvalid()) {
        Result = DS.SetTypeSpecType(TagType, new SourceLocation(StartLoc), 
            new SourceLocation(NameLoc.isValid() ? NameLoc : StartLoc), 
            PrevSpec, DiagID, TagOrTempResult.get(), Owned.$deref(), 
            Policy);
      } else {
        DS.SetTypeSpecError();
        return;
      }
      if (Result) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(StartLoc), DiagID)), PrevSpec));
        } finally {
          $c$.$destroy();
        }
      }
      
      // At this point, we've successfully parsed a class-specifier in 'definition'
      // form (e.g. "struct foo { int x; }".  While we could just return here, we're
      // going to look at what comes after it to improve error recovery.  If an
      // impossible token occurs next, we assume that the programmer forgot a ; at
      // the end of the declaration and recover that way.
      //
      // Also enforce C++ [temp]p3:
      //   In a template-declaration which defines a class, no declarator
      //   is permitted.
      //
      // After a type-specifier, we don't expect a semicolon. This only happens in
      // C, since definitions are not permitted in this context in C++.
      if (TUK == Sema.TagUseKind.TUK_Definition
         && ($this().getLangOpts().CPlusPlus || !isTypeSpecifier(DSC))
         && ((TemplateInfo.Kind.getValue() != 0) || !$this().isValidAfterTypeSpecifier(false))) {
        if ($this().Tok.isNot(tok.TokenKind.semi)) {
          final /*const*/ PrintingPolicy /*&*/ PPol = $this().Actions.getASTContext().getPrintingPolicy();
          $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, 
              new StringRef(DeclSpec.getSpecifierName(TagType, PPol)));
          // Push this token back into the preprocessor and change our current token
          // to ';' so that the rest of the code recovers as though there were an
          // ';' after the definition.
          $this().PP.EnterToken($this().Tok);
          $this().Tok.setKind(tok.TokenKind.semi);
        }
      }
    } finally {
      if (AtomicTokenGuard != null) { AtomicTokenGuard.$destroy(); }
      if (attrs != null) { attrs.$destroy(); }
      if (diagsFromTag != null) { diagsFromTag.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::SkipCXXMemberSpecification">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2787,
   FQN="clang::Parser::SkipCXXMemberSpecification", NM="_ZN5clang6Parser26SkipCXXMemberSpecificationENS_14SourceLocationES1_jPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser26SkipCXXMemberSpecificationENS_14SourceLocationES1_jPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void SkipCXXMemberSpecification(SourceLocation RecordLoc, 
                            SourceLocation AttrFixitLoc, 
                            /*uint*/int TagType, Decl /*P*/ TagDecl) {
    BalancedDelimiterTracker T = null;
    ParsedAttributes Attrs = null;
    try {
      // Skip the optional 'final' keyword.
      if ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.identifier)) {
        ParsedAttributesWithRange _Attrs = null;
        try {
          assert ($this().isCXX11FinalKeyword()) : "not a class definition";
          $this().ConsumeToken();
          
          // Diagnose any C++11 attributes after 'final' keyword.
          // We deliberately discard these attributes.
          _Attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
          $this().CheckMisplacedCXX11Attribute(_Attrs, new SourceLocation(AttrFixitLoc));
          
          // This can only happen if we had malformed misplaced attributes;
          // we only get called if there is a colon or left-brace after the
          // attributes.
          if ($this().Tok.isNot(tok.TokenKind.colon) && $this().Tok.isNot(tok.TokenKind.l_brace)) {
            return;
          }
        } finally {
          if (_Attrs != null) { _Attrs.$destroy(); }
        }
      }
      
      // Skip the base clauses. This requires actually parsing them, because
      // otherwise we can't be sure where they end (a left brace may appear
      // within a template argument).
      if ($this().Tok.is(tok.TokenKind.colon)) {
        ParseScope ClassScope = null;
        ParsingClassDefinition ParsingDef = null;
        try {
          // Enter the scope of the class so that we can correctly parse its bases.
          ClassScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.DeclScope);
          ParsingDef/*J*/= new ParsingClassDefinition(/*Deref*/$this(), TagDecl, /*NonNestedClass*/ true, 
              TagType == DeclSpec.TST_interface.getValue());
          Object/*void P*/ OldContext = $this().Actions.ActOnTagStartSkippedDefinition($this().getCurScope(), TagDecl);
          
          // Parse the bases but don't attach them to the class.
          $this().ParseBaseClause((Decl /*P*/ )null);
          
          $this().Actions.ActOnTagFinishSkippedDefinition(OldContext);
          if (!$this().Tok.is(tok.TokenKind.l_brace)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation), 
                  diag.err_expected_lbrace_after_base_specifiers)));
              return;
            } finally {
              $c$.$destroy();
            }
          }
        } finally {
          if (ParsingDef != null) { ParsingDef.$destroy(); }
          if (ClassScope != null) { ClassScope.$destroy(); }
        }
      }
      
      // Skip the body.
      assert ($this().Tok.is(tok.TokenKind.l_brace));
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      T.consumeOpen();
      T.skipToEnd();
      
      // Parse and discard any trailing attributes.
      Attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      if ($this().Tok.is(tok.TokenKind.kw___attribute)) {
        $this().MaybeParseGNUAttributes(Attrs);
      }
    } finally {
      if (Attrs != null) { Attrs.$destroy(); }
      if (T != null) { T.$destroy(); }
    }
  }


/// ParseCXXMemberSpecification - Parse the class definition.
///
///       member-specification:
///         member-declaration member-specification[opt]
///         access-specifier ':' member-specification[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXMemberSpecification">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2943,
   FQN="clang::Parser::ParseCXXMemberSpecification", NM="_ZN5clang6Parser27ParseCXXMemberSpecificationENS_14SourceLocationES1_RNS0_25ParsedAttributesWithRangeEjPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser27ParseCXXMemberSpecificationENS_14SourceLocationES1_RNS0_25ParsedAttributesWithRangeEjPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void ParseCXXMemberSpecification(SourceLocation RecordLoc, 
                             SourceLocation AttrFixitLoc, 
                             final ParsedAttributesWithRange /*&*/ Attrs, 
                             /*uint*/int TagType, Decl /*P*/ TagDecl) {
    PrettyDeclStackTraceEntry CrashInfo = null;
    ParseScope ClassScope = null;
    ParsingClassDefinition ParsingDef = null;
    BalancedDelimiterTracker T = null;
    ParsedAttributesWithRange AccessAttrs = null;
    ParsedAttributes attrs = null;
    try {
      assert ((TagType == DeclSpec.TST_struct.getValue() || TagType == DeclSpec.TST_interface.getValue() || TagType == DeclSpec.TST_union.getValue() || TagType == DeclSpec.TST_class.getValue())) : "Invalid TagType!";
      
      CrashInfo/*J*/= new PrettyDeclStackTraceEntry($this().Actions, TagDecl, new SourceLocation(RecordLoc), 
          $("parsing struct/union/class body"));
      
      // Determine whether this is a non-nested class. Note that local
      // classes are *not* considered to be nested classes.
      boolean NonNestedClass = true;
      if (!$this().ClassStack.empty()) {
        for (/*const*/ Scope /*P*/ S = $this().getCurScope(); (S != null); S = S.getParent$Const()) {
          if (S.isClassScope()) {
            // We're inside a class scope, so this is a nested class.
            NonNestedClass = false;
            
            // The Microsoft extension __interface does not permit nested classes.
            if ($this().getCurrentClass().IsInterface) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track($this().Diag(new SourceLocation(RecordLoc), diag.err_invalid_member_in_interface)), 
                        /*ErrorType=*/ 6), 
                    new StringRef((isa(NamedDecl.class, TagDecl) ? cast(NamedDecl.class, TagDecl).getQualifiedNameAsString() : new std.string(/*KEEP_STR*/"(anonymous)")))));
              } finally {
                $c$.$destroy();
              }
            }
            break;
          }
          if (((S.getFlags() & Scope.ScopeFlags.FnScope) != 0)) {
            // If we're in a function or function template then this is a local
            // class rather than a nested class.
            break;
          }
        }
      }
      
      // Enter a scope for the class.
      ClassScope/*J*/= new ParseScope($this(), Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.DeclScope);
      
      // Note that we are parsing a new (potentially-nested) class definition.
      ParsingDef/*J*/= new ParsingClassDefinition(/*Deref*/$this(), TagDecl, NonNestedClass, 
          TagType == DeclSpec.TST_interface.getValue());
      if ((TagDecl != null)) {
        $this().Actions.ActOnTagStartDefinition($this().getCurScope(), TagDecl);
      }
      
      SourceLocation FinalLoc/*J*/= new SourceLocation();
      boolean IsFinalSpelledSealed = false;
      
      // Parse the optional 'final' keyword.
      if ($this().getLangOpts().CPlusPlus && $this().Tok.is(tok.TokenKind.identifier)) {
        VirtSpecifiers.Specifier Specifier = $this().isCXX11VirtSpecifier($this().Tok);
        assert ((Specifier == VirtSpecifiers.Specifier.VS_Final || Specifier == VirtSpecifiers.Specifier.VS_Sealed)) : "not a class definition";
        FinalLoc.$assignMove($this().ConsumeToken());
        IsFinalSpelledSealed = Specifier == VirtSpecifiers.Specifier.VS_Sealed;
        if (TagType == DeclSpec.TST_interface.getValue()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(FinalLoc), diag.err_override_control_interface)), 
                VirtSpecifiers.getSpecifierName(Specifier)));
          } finally {
            $c$.$destroy();
          }
        } else if (Specifier == VirtSpecifiers.Specifier.VS_Final) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(FinalLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_override_control_keyword : diag.ext_override_control_keyword)), 
                VirtSpecifiers.getSpecifierName(Specifier)));
          } finally {
            $c$.$destroy();
          }
        } else if (Specifier == VirtSpecifiers.Specifier.VS_Sealed) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(FinalLoc), diag.ext_ms_sealed_keyword)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Parse any C++11 attributes after 'final' keyword.
        // These attributes are not allowed to appear here,
        // and the only possible place for them to appertain
        // to the class would be between class-key and class-name.
        $this().CheckMisplacedCXX11Attribute(Attrs, new SourceLocation(AttrFixitLoc));
        
        // ParseClassSpecifier() does only a superficial check for attributes before
        // deciding to call this method.  For example, for
        // `class C final alignas ([l) {` it will decide that this looks like a
        // misplaced attribute since it sees `alignas '(' ')'`.  But the actual
        // attribute parsing code will try to parse the '[' as a constexpr lambda
        // and consume enough tokens that the alignas parsing code will eat the
        // opening '{'.  So bail out if the next token isn't one we expect.
        if (!$this().Tok.is(tok.TokenKind.colon) && !$this().Tok.is(tok.TokenKind.l_brace)) {
          if ((TagDecl != null)) {
            $this().Actions.ActOnTagDefinitionError($this().getCurScope(), TagDecl);
          }
          return;
        }
      }
      if ($this().Tok.is(tok.TokenKind.colon)) {
        $this().ParseBaseClause(TagDecl);
        if (!$this().Tok.is(tok.TokenKind.l_brace)) {
          DiagnosticBuilder LBraceDiag = null;
          try {
            boolean SuggestFixIt = false;
            SourceLocation BraceLoc = $this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation);
            if ($this().Tok.isAtStartOfLine()) {
              switch ($this().Tok.getKind()) {
               case tok.TokenKind.kw_private:
               case tok.TokenKind.kw_protected:
               case tok.TokenKind.kw_public:
                SuggestFixIt = $this().NextToken().getKind() == tok.TokenKind.colon;
                break;
               case tok.TokenKind.kw_static_assert:
               case tok.TokenKind.r_brace:
               case tok.TokenKind.kw_using:
               case tok.TokenKind.kw_template:
                // base-clause can have simple-template-id; 'template' can't be there
                SuggestFixIt = true;
                break;
               case tok.TokenKind.identifier:
                SuggestFixIt = $this().isConstructorDeclarator(true);
                break;
               default:
                SuggestFixIt = $this().isCXXSimpleDeclaration(/*AllowForRangeDecl=*/ false);
                break;
              }
            }
            LBraceDiag = $this().Diag(new SourceLocation(BraceLoc), diag.err_expected_lbrace_after_base_specifiers);
            if (SuggestFixIt) {
              $out_DiagnosticBuilder$C_FixItHint$C(LBraceDiag, FixItHint.CreateInsertion(/*NO_COPY*/BraceLoc, new StringRef(/*KEEP_STR*/" {")));
              // Try recovering from missing { after base-clause.
              $this().PP.EnterToken($this().Tok);
              $this().Tok.setKind(tok.TokenKind.l_brace);
            } else {
              if ((TagDecl != null)) {
                $this().Actions.ActOnTagDefinitionError($this().getCurScope(), TagDecl);
              }
              return;
            }
          } finally {
            if (LBraceDiag != null) { LBraceDiag.$destroy(); }
          }
        }
      }
      assert ($this().Tok.is(tok.TokenKind.l_brace));
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      T.consumeOpen();
      if ((TagDecl != null)) {
        $this().Actions.ActOnStartCXXMemberDeclarations($this().getCurScope(), TagDecl, new SourceLocation(FinalLoc), 
            IsFinalSpelledSealed, 
            T.getOpenLocation());
      }
      
      // C++ 11p3: Members of a class defined with the keyword class are private
      // by default. Members of a class defined with the keywords struct or union
      // are public by default.
      type$ref<AccessSpecifier> CurAS = create_type$ref(null);
      if (TagType == DeclSpec.TST_class.getValue()) {
        CurAS.$set(AccessSpecifier.AS_private);
      } else {
        CurAS.$set(AccessSpecifier.AS_public);
      }
      AccessAttrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      if ((TagDecl != null)) {
        // While we still have something to read, read the member-declarations.
        while (!$this().tryParseMisplacedModuleImport() && $this().Tok.isNot(tok.TokenKind.r_brace)
           && $this().Tok.isNot(tok.TokenKind.eof)) {
          // Each iteration of this loop reads one member-declaration.
          $this().ParseCXXClassMemberDeclarationWithPragmas(CurAS, AccessAttrs, /*static_cast*/TypeSpecifierType.valueOf(TagType), TagDecl);
        }
        T.consumeClose();
      } else {
        $this().SkipUntil(tok.TokenKind.r_brace);
      }
      
      // If attributes exist after class contents, parse them.
      attrs/*J*/= new ParsedAttributes($this().AttrFactory);
      $this().MaybeParseGNUAttributes(attrs);
      if ((TagDecl != null)) {
        $this().Actions.ActOnFinishCXXMemberSpecification($this().getCurScope(), new SourceLocation(RecordLoc), TagDecl, 
            T.getOpenLocation(), 
            T.getCloseLocation(), 
            attrs.getList());
      }
      
      // C++11 [class.mem]p2:
      //   Within the class member-specification, the class is regarded as complete
      //   within function bodies, default arguments, exception-specifications, and
      //   brace-or-equal-initializers for non-static data members (including such
      //   things in nested classes).
      if ((TagDecl != null) && NonNestedClass) {
        // We are not inside a nested class. This class and its nested classes
        // are complete and we can parse the delayed portions of method
        // declarations and the lexed inline method definitions, along with any
        // delayed attributes.
        SourceLocation SavedPrevTokLocation = new SourceLocation($this().PrevTokLocation);
        $this().ParseLexedAttributes($this().getCurrentClass());
        $this().ParseLexedMethodDeclarations($this().getCurrentClass());
        
        // We've finished with all pending member declarations.
        $this().Actions.ActOnFinishCXXMemberDecls();
        
        $this().ParseLexedMemberInitializers($this().getCurrentClass());
        $this().ParseLexedMethodDefs($this().getCurrentClass());
        $this().PrevTokLocation.$assign(SavedPrevTokLocation);
        
        // We've finished parsing everything, including default argument
        // initializers.
        $this().Actions.ActOnFinishCXXNonNestedClass(TagDecl);
      }
      if ((TagDecl != null)) {
        $this().Actions.ActOnTagFinishDefinition($this().getCurScope(), TagDecl, T.getRange());
      }
      
      // Leave the class scope.
      ParsingDef.Pop();
      ClassScope.Exit();
    } finally {
      if (attrs != null) { attrs.$destroy(); }
      if (AccessAttrs != null) { AccessAttrs.$destroy(); }
      if (T != null) { T.$destroy(); }
      if (ParsingDef != null) { ParsingDef.$destroy(); }
      if (ClassScope != null) { ClassScope.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }


/// ParseCXXMemberInitializer - Parse the brace-or-equal-initializer.
/// Also detect and reject any attempted defaulted/deleted function definition.
/// The location of the '=', if any, will be placed in EqualLoc.
///
/// This does not check for a pure-specifier; that's handled elsewhere.
///
///   brace-or-equal-initializer:
///     '=' initializer-expression
///     braced-init-list
///
///   initializer-clause:
///     assignment-expression
///     braced-init-list
///
///   defaulted/deleted function-definition:
///     '=' 'default'
///     '=' 'delete'
///
/// Prior to C++0x, the assignment-expression in an initializer-clause must
/// be a constant-expression.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2747,
   FQN="clang::Parser::ParseCXXMemberInitializer", NM="_ZN5clang6Parser25ParseCXXMemberInitializerEPNS_4DeclEbRNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser25ParseCXXMemberInitializerEPNS_4DeclEbRNS_14SourceLocationE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseCXXMemberInitializer(Decl /*P*/ D, boolean IsFunction, 
                           final SourceLocation /*&*/ EqualLoc) {
    EnterExpressionEvaluationContext Context = null;
    try {
      assert ($this().Tok.isOneOf(tok.TokenKind.equal, tok.TokenKind.l_brace)) : "Data member initializer not starting with '=' or '{'";
      
      Context/*J*/= new EnterExpressionEvaluationContext($this().Actions, 
          Sema.ExpressionEvaluationContext.PotentiallyEvaluated, 
          D);
      if ($this().TryConsumeToken(tok.TokenKind.equal, EqualLoc)) {
        if ($this().Tok.is(tok.TokenKind.kw_delete)) {
          // In principle, an initializer of '= delete p;' is legal, but it will
          // never type-check. It's better to diagnose it as an ill-formed expression
          // than as an ill-formed deleted non-function member.
          // An initializer of '= delete p, foo' will never be parsed, because
          // a top-level comma always ends the initializer expression.
          final /*const*/ Token /*&*/ Next = $this().NextToken();
          if (IsFunction || Next.isOneOf$T(tok.TokenKind.semi, tok.TokenKind.comma, tok.TokenKind.eof)) {
            if (IsFunction) {
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
            return ExprError();
          }
        } else if ($this().Tok.is(tok.TokenKind.kw_default)) {
          if (IsFunction) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_int($c$.track($this().Diag($this().Tok, diag.err_default_delete_in_multiple_declaration)), 
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
          return ExprError();
        }
      }
      {
        /*const*/ MSPropertyDecl /*P*/ PD = dyn_cast_or_null(MSPropertyDecl.class, D);
        if ((PD != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track($this().Diag($this().Tok, diag.err_ms_property_initializer)), PD));
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
      }
      return $this().ParseInitializer();
    } finally {
      if (Context != null) { Context.$destroy(); }
    }
  }


/// \brief Parse a C++ member-declarator up to, but not including, the optional
/// brace-or-equal-initializer or pure-specifier.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXMemberDeclaratorBeforeInitializer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2091,
   FQN="clang::Parser::ParseCXXMemberDeclaratorBeforeInitializer", NM="_ZN5clang6Parser41ParseCXXMemberDeclaratorBeforeInitializerERNS_10DeclaratorERNS_14VirtSpecifiersERNS_12ActionResultIPNS_4ExprELb1EEERNS0_18LateParsedAttrListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser41ParseCXXMemberDeclaratorBeforeInitializerERNS_10DeclaratorERNS_14VirtSpecifiersERNS_12ActionResultIPNS_4ExprELb1EEERNS0_18LateParsedAttrListE")
  //</editor-fold>
  protected /*private*/ boolean ParseCXXMemberDeclaratorBeforeInitializer(final Declarator /*&*/ DeclaratorInfo, final VirtSpecifiers /*&*/ VS, final ActionResultTTrue<Expr /*P*/ > /*&*/ BitfieldSize, 
                                           final LateParsedAttrList /*&*/ LateParsedAttrs) {
    // member-declarator:
    //   declarator pure-specifier[opt]
    //   declarator brace-or-equal-initializer[opt]
    //   identifier[opt] ':' constant-expression
    if ($this().Tok.isNot(tok.TokenKind.colon)) {
      $this().ParseDeclarator(DeclaratorInfo);
    } else {
      DeclaratorInfo.SetIdentifier((IdentifierInfo /*P*/ )null, $this().Tok.getLocation());
    }
    if (!DeclaratorInfo.isFunctionDeclarator() && $this().TryConsumeToken(tok.TokenKind.colon)) {
      assert (DeclaratorInfo.isPastIdentifier()) : "don't know where identifier would go yet?";
      BitfieldSize.$assignMove($this().ParseConstantExpression());
      if (BitfieldSize.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.comma, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
      }
    } else {
      $this().ParseOptionalCXX11VirtSpecifierSeq(VS, $this().getCurrentClass().IsInterface, 
          DeclaratorInfo.getDeclSpec().getFriendSpecLoc());
      if (!VS.isUnset()) {
        $this().MaybeParseAndDiagnoseDeclSpecAfterCXX11VirtSpecifierSeq(DeclaratorInfo, VS);
      }
    }
    
    // If a simple-asm-expr is present, parse it.
    if ($this().Tok.is(tok.TokenKind.kw_asm)) {
      SourceLocation Loc/*J*/= new SourceLocation();
      ActionResultTTrue<Expr /*P*/ > AsmLabel/*J*/= $this().ParseSimpleAsm($AddrOf(Loc));
      if (AsmLabel.isInvalid()) {
        $this().SkipUntil(tok.TokenKind.comma, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
      }
      
      DeclaratorInfo.setAsmLabel(AsmLabel.get());
      DeclaratorInfo.SetRangeEnd(new SourceLocation(Loc));
    }
    
    // If attributes exist after the declarator, but before an '{', parse them.
    $this().MaybeParseGNUAttributes(DeclaratorInfo, $AddrOf(LateParsedAttrs));
    
    // For compatibility with code written to older Clang, also accept a
    // virt-specifier *after* the GNU attributes.
    if (BitfieldSize.isUnset() && VS.isUnset()) {
      $this().ParseOptionalCXX11VirtSpecifierSeq(VS, $this().getCurrentClass().IsInterface, 
          DeclaratorInfo.getDeclSpec().getFriendSpecLoc());
      if (!VS.isUnset()) {
        // If we saw any GNU-style attributes that are known to GCC followed by a
        // virt-specifier, issue a GCC-compat warning.
        /*const*/ AttributeList /*P*/ Attr = DeclaratorInfo.getAttributes();
        while ((Attr != null)) {
          if (Attr.isKnownToGCC() && !Attr.isCXX11Attribute()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(Attr.getLoc(), diag.warn_gcc_attribute_location)));
            } finally {
              $c$.$destroy();
            }
          }
          Attr = Attr.getNext();
        }
        $this().MaybeParseAndDiagnoseDeclSpecAfterCXX11VirtSpecifierSeq(DeclaratorInfo, VS);
      }
    }
    
    // If this has neither a name nor a bit width, something has gone seriously
    // wrong. Skip until the semi-colon or }.
    if (!DeclaratorInfo.hasName() && BitfieldSize.isUnset()) {
      // If so, skip until the semi-colon or a }.
      $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
      return true;
    }
    return false;
  }


/// \brief Look for declaration specifiers possibly occurring after C++11
/// virt-specifier-seq and diagnose them.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::MaybeParseAndDiagnoseDeclSpecAfterCXX11VirtSpecifierSeq">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2162,
   FQN="clang::Parser::MaybeParseAndDiagnoseDeclSpecAfterCXX11VirtSpecifierSeq", NM="_ZN5clang6Parser55MaybeParseAndDiagnoseDeclSpecAfterCXX11VirtSpecifierSeqERNS_10DeclaratorERNS_14VirtSpecifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser55MaybeParseAndDiagnoseDeclSpecAfterCXX11VirtSpecifierSeqERNS_10DeclaratorERNS_14VirtSpecifiersE")
  //</editor-fold>
  protected /*private*/ void MaybeParseAndDiagnoseDeclSpecAfterCXX11VirtSpecifierSeq(final Declarator /*&*/ D, 
                                                         final VirtSpecifiers /*&*/ VS) {
    final DeclSpec DS/*J*/= new DeclSpec($this().AttrFactory);
    try {
//      DS/*J*/= new DeclSpec(AttrFactory);
      
      // GNU-style and C++11 attributes are not allowed here, but they will be
      // handled by the caller.  Diagnose everything else.
      $this().ParseTypeQualifierListOpt(DS, AttrRequirements.AR_NoAttributesParsed, false);
      D.ExtendWithDeclSpec(DS);
      if (D.isFunctionDeclarator()) {
        final FunctionTypeInfo /*&*/ Function = D.getFunctionTypeInfo();
        if (DS.getTypeQualifiers() != DeclSpec.TQ.TQ_unspecified.getValue()) {
          DeclSpecTQStrSLocUIntRef2Void DeclSpecCheck =  /*[&]*/ (DeclSpec.TQ TypeQual,
                                /*const*/ String /*P*/FixItName,
                                SourceLocation SpecLoc,
                                uint$ref QualifierLoc) -> 
            {
              FixItHint Insertion/*J*/= new FixItHint();
              if (((DS.getTypeQualifiers() & TypeQual.getValue()) != 0)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  if (!((Function.TypeQuals & $int2uint_4bits(TypeQual.getValue())) != 0)) {
                    std.string Name/*J*/= new std.string(FixItName);
                    Name.$addassign_T$C$P(/*KEEP_STR*/" ");
                    Insertion.$assignMove(FixItHint.CreateInsertion(VS.getFirstLocation(), new StringRef(Name.c_str())));
                    Function.TypeQuals |= $int2uint_4bits(TypeQual.getValue());
                    QualifierLoc.$set(SpecLoc.getRawEncoding());
                  }
                  $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(SpecLoc), diag.err_declspec_after_virtspec)), 
                                  FixItName), 
                              VirtSpecifiers.getSpecifierName(VS.getLastSpecifier())), 
                          FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/SpecLoc))), 
                      Insertion));
                } finally {
                  $c$.$destroy();
                }
              }
            }
  ;
          DeclSpecCheck.$call(/*KEEP_ENUM*/DeclSpec.TQ.TQ_const, /*KEEP_STR*/"const", DS.getConstSpecLoc(), 
              $AddrOf(Function.ConstQualifierLoc$Ref)
          );
          DeclSpecCheck.$call(/*KEEP_ENUM*/DeclSpec.TQ.TQ_volatile, /*KEEP_STR*/"volatile", DS.getVolatileSpecLoc(), 
              $AddrOf(Function.VolatileQualifierLoc$Ref)
          );
          DeclSpecCheck.$call(/*KEEP_ENUM*/DeclSpec.TQ.TQ_restrict, /*KEEP_STR*/"restrict", DS.getRestrictSpecLoc(), 
              $AddrOf(Function.RestrictQualifierLoc$Ref)
          );
        }
        
        // Parse ref-qualifiers.
        bool$ref RefQualifierIsLValueRef = create_bool$ref(true);
        SourceLocation RefQualifierLoc/*J*/= new SourceLocation();
        if ($this().ParseRefQualifier(RefQualifierIsLValueRef, RefQualifierLoc)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/char$ptr/*char P*/ Name = $tryClone((RefQualifierIsLValueRef.$deref() ? $("& ") : $("&& ")));
            FixItHint Insertion = FixItHint.CreateInsertion(VS.getFirstLocation(), new StringRef(Name));
            Function.RefQualifierIsLValueRef = RefQualifierIsLValueRef.$deref();
            Function.RefQualifierLoc = RefQualifierLoc.getRawEncoding();
            
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track($this().Diag(new SourceLocation(RefQualifierLoc), diag.err_declspec_after_virtspec)), 
                            (RefQualifierIsLValueRef.$deref() ? $AMP : $AMP_AMP)), 
                        VirtSpecifiers.getSpecifierName(VS.getLastSpecifier())), 
                    FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/RefQualifierLoc))), 
                Insertion));
            D.SetRangeEnd(new SourceLocation(RefQualifierLoc));
          } finally {
            $c$.$destroy();
          }
        }
      }
    } finally {
      if (DS != null) { DS.$destroy(); }
    }
  }


/// ParseCXXClassMemberDeclaration - Parse a C++ class member declaration.
///
///       member-declaration:
///         decl-specifier-seq[opt] member-declarator-list[opt] ';'
///         function-definition ';'[opt]
///         ::[opt] nested-name-specifier template[opt] unqualified-id ';'[TODO]
///         using-declaration                                            [TODO]
/// [C++0x] static_assert-declaration
///         template-declaration
/// [GNU]   '__extension__' member-declaration
///
///       member-declarator-list:
///         member-declarator
///         member-declarator-list ',' member-declarator
///
///       member-declarator:
///         declarator virt-specifier-seq[opt] pure-specifier[opt]
///         declarator constant-initializer[opt]
/// [C++11] declarator brace-or-equal-initializer[opt]
///         identifier[opt] ':' constant-expression
///
///       virt-specifier-seq:
///         virt-specifier
///         virt-specifier-seq virt-specifier
///
///       virt-specifier:
///         override
///         final
/// [MS]    sealed
/// 
///       pure-specifier:
///         '= 0'
///
///       constant-initializer:
///         '=' constant-expression
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXClassMemberDeclaration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2258,
   FQN="clang::Parser::ParseCXXClassMemberDeclaration", NM="_ZN5clang6Parser30ParseCXXClassMemberDeclarationENS_15AccessSpecifierEPNS_13AttributeListERKNS0_18ParsedTemplateInfoEPNS_21ParsingDeclRAIIObjectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser30ParseCXXClassMemberDeclarationENS_15AccessSpecifierEPNS_13AttributeListERKNS0_18ParsedTemplateInfoEPNS_21ParsingDeclRAIIObjectE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseCXXClassMemberDeclaration(AccessSpecifier AS, 
                                AttributeList /*P*/ AccessAttrs) {
    return $this().ParseCXXClassMemberDeclaration(AS, 
                                AccessAttrs, 
                                new ParsedTemplateInfo(), 
                                (ParsingDeclRAIIObject /*P*/ )null);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseCXXClassMemberDeclaration(AccessSpecifier AS, 
                                AttributeList /*P*/ AccessAttrs, 
                                final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/) {
    return $this().ParseCXXClassMemberDeclaration(AS, 
                                AccessAttrs, 
                                TemplateInfo, 
                                (ParsingDeclRAIIObject /*P*/ )null);
  }
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseCXXClassMemberDeclaration(AccessSpecifier AS, 
                                AttributeList /*P*/ AccessAttrs, 
                                final /*const*/ ParsedTemplateInfo /*&*/ TemplateInfo/*= ParsedTemplateInfo()*/, 
                                ParsingDeclRAIIObject /*P*/ TemplateDiags/*= null*/) {
    ColonProtectionRAIIObject X = null;
    ParsedAttributesWithRange attrs = null;
    ParsedAttributesWithRange FnAttrs = null;
    ParsingDeclSpec DS = null;
    ParsingDeclarator DeclaratorInfo = null;
    try {
      if ($this().Tok.is(tok.TokenKind.at)) {
        if ($this().getLangOpts().ObjC1 && $this().NextToken().isObjCAtKeyword(tok.ObjCKeywordKind.objc_defs)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_at_defs_cxx)));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag($this().Tok, diag.err_at_in_class)));
          } finally {
            $c$.$destroy();
          }
        }
        
        $this().ConsumeToken();
        $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopAtSemi);
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      // Turn on colon protection early, while parsing declspec, although there is
      // nothing to protect there. It prevents from false errors if error recovery
      // incorrectly determines where the declspec ends, as in the example:
      //   struct A { enum class B { C }; };
      //   const int C = 4;
      //   struct D { A::B : C; };
      X/*J*/= new ColonProtectionRAIIObject(/*Deref*/$this());
      
      // Access declarations.
      boolean MalformedTypeSpec = false;
      if (!(TemplateInfo.Kind.getValue() != 0)
         && $this().Tok.isOneOf$T(tok.TokenKind.identifier, tok.TokenKind.coloncolon, tok.TokenKind.kw___super)) {
        if ($this().TryAnnotateCXXScopeToken()) {
          MalformedTypeSpec = true;
        }
        
        boolean isAccessDecl;
        if ($this().Tok.isNot(tok.TokenKind.annot_cxxscope)) {
          isAccessDecl = false;
        } else if ($this().NextToken().is(tok.TokenKind.identifier)) {
          isAccessDecl = $this().GetLookAheadToken(2).is(tok.TokenKind.semi);
        } else {
          isAccessDecl = $this().NextToken().is(tok.TokenKind.kw_operator);
        }
        if (isAccessDecl) {
          CXXScopeSpec SS = null;
          try {
            // Collect the scope specifier token we annotated earlier.
            SS/*J*/= new CXXScopeSpec();
            $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), 
                /*EnteringContext=*/ false);
            if (SS.isInvalid()) {
              $this().SkipUntil(tok.TokenKind.semi);
              return new OpaquePtr<DeclGroupRef>(null);
            }
            
            // Try to parse an unqualified-id.
            SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
            UnqualifiedId Name/*J*/= new UnqualifiedId();
            if ($this().ParseUnqualifiedId(SS, false, true, true, new OpaquePtr<QualType>(null), TemplateKWLoc, 
                Name)) {
              $this().SkipUntil(tok.TokenKind.semi);
              return new OpaquePtr<DeclGroupRef>(null);
            }
            
            // TODO: recover from mistakenly-qualified operator declarations.
            if ($this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_after, 
                new StringRef(/*KEEP_STR*/"access declaration"))) {
              $this().SkipUntil(tok.TokenKind.semi);
              return new OpaquePtr<DeclGroupRef>(null);
            }
            
            return OpaquePtr.<DeclGroupRef>make(new DeclGroupRef($this().Actions.ActOnUsingDeclaration($this().getCurScope(), AS, 
                        /* HasUsingKeyword */ false, new SourceLocation(), SS, Name, 
                        /* AttrList */ (AttributeList /*P*/ )null, 
                        /* HasTypenameKeyword */ false, new SourceLocation())));
          } finally {
            if (SS != null) { SS.$destroy(); }
          }
        }
      }
      
      // static_assert-declaration. A templated static_assert declaration is
      // diagnosed in Parser::ParseSingleDeclarationAfterTemplate.
      if (!(TemplateInfo.Kind.getValue() != 0)
         && $this().Tok.isOneOf(tok.TokenKind.kw_static_assert, tok.TokenKind.kw__Static_assert)) {
        SourceLocation DeclEnd/*J*/= new SourceLocation();
        return OpaquePtr.<DeclGroupRef>make(new DeclGroupRef($this().ParseStaticAssertDeclaration(DeclEnd)));
      }
      if ($this().Tok.is(tok.TokenKind.kw_template)) {
        assert (!(TemplateInfo.TemplateParams != null)) : "Nested template improperly parsed?";
        SourceLocation DeclEnd/*J*/= new SourceLocation();
        return OpaquePtr.<DeclGroupRef>make(new DeclGroupRef($this().ParseDeclarationStartingWithTemplate(Declarator.TheContext.MemberContext.getValue(), DeclEnd, AS, AccessAttrs)));
      }
      
      // Handle:  member-declaration ::= '__extension__' member-declaration
      if ($this().Tok.is(tok.TokenKind.kw___extension__)) {
        ExtensionRAIIObject O = null;
        try {
          // __extension__ silences extension warnings in the subexpression.
          O/*J*/= new ExtensionRAIIObject($this().Diags); // Use RAII to do this.
          $this().ConsumeToken();
          return $this().ParseCXXClassMemberDeclaration(AS, AccessAttrs, 
              TemplateInfo, TemplateDiags);
        } finally {
          if (O != null) { O.$destroy(); }
        }
      }
      
      attrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      FnAttrs/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      // Optional C++11 attribute-specifier
      $this().MaybeParseCXX11Attributes(attrs);
      // We need to keep these attributes for future diagnostic
      // before they are taken over by declaration specifier.
      FnAttrs.addAll(attrs.getList());
      FnAttrs.Range.$assign(attrs.Range);
      
      $this().MaybeParseMicrosoftAttributes(attrs);
      if ($this().Tok.is(tok.TokenKind.kw_using)) {
        $this().ProhibitAttributes(attrs);
        
        // Eat 'using'.
        SourceLocation UsingLoc = $this().ConsumeToken();
        if ($this().Tok.is(tok.TokenKind.kw_namespace)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(UsingLoc), diag.err_using_namespace_in_class)));
            $this().SkipUntil(tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
            return new OpaquePtr<DeclGroupRef>(null);
          } finally {
            $c$.$destroy();
          }
        }
        SourceLocation DeclEnd/*J*/= new SourceLocation();
        // Otherwise, it must be a using-declaration or an alias-declaration.
        return OpaquePtr.<DeclGroupRef>make(new DeclGroupRef($this().ParseUsingDeclaration(Declarator.TheContext.MemberContext.getValue(), TemplateInfo, new SourceLocation(UsingLoc), DeclEnd, AS)));
      }
      
      // Hold late-parsed attributes so we can attach a Decl to them later.
      LateParsedAttrList CommonLateParsedAttrs/*J*/= new LateParsedAttrList();
      
      // decl-specifier-seq:
      // Parse the common declaration-specifiers piece.
      DS/*J*/= new ParsingDeclSpec(/*Deref*/$this(), TemplateDiags);
      DS.takeAttributesFrom(attrs);
      if (MalformedTypeSpec) {
        DS.SetTypeSpecError();
      }
      
      $this().ParseDeclarationSpecifiers(DS, TemplateInfo, AS, DeclSpecContext.DSC_class, 
          $AddrOf(CommonLateParsedAttrs));
      
      // Turn off colon protection that was set for declspec.
      X.restore();
      
      // If we had a free-standing type definition with a missing semicolon, we
      // may get this far before the problem becomes obvious.
      if (DS.hasTagDefinition()
         && TemplateInfo.Kind == ParsedTemplateInfo.Unnamed_enum.NonTemplate
         && $this().DiagnoseMissingSemiAfterTagDefinition(DS, AS, DeclSpecContext.DSC_class, 
          $AddrOf(CommonLateParsedAttrs))) {
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      MutableArrayRef<TemplateParameterList /*P*/ > TemplateParams/*J*/= new MutableArrayRef<TemplateParameterList /*P*/ >((TemplateInfo.TemplateParams != null) ? TemplateInfo.TemplateParams.data() : create_type$ptr((TemplateParameterList /*P*/ )null), 
          (TemplateInfo.TemplateParams != null) ? TemplateInfo.TemplateParams.size() : 0, true);
      if ($this().TryConsumeToken(tok.TokenKind.semi)) {
        if (DS.isFriendSpecified()) {
          $this().ProhibitAttributes(FnAttrs);
        }
        
        type$ref<RecordDecl> /*P*/ AnonRecord = create_type$ref((RecordDecl)null);
        Decl /*P*/ TheDecl = $this().Actions.ParsedFreeStandingDeclSpec($this().getCurScope(), AS, DS, new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParams), false, AnonRecord);
        DS.complete(TheDecl);
        if (AnonRecord.$bool()) {
          Decl /*P*/ decls[/*2*/] = new Decl /*P*/ [/*2*/] {AnonRecord.$deref(), TheDecl};
          return $this().Actions.BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >(decls, true), /*TypeMayContainAuto=*/ false);
        }
        return $this().Actions.ConvertDeclToDeclGroup(TheDecl);
      }
      
      DeclaratorInfo/*J*/= new ParsingDeclarator(/*Deref*/$this(), DS, Declarator.TheContext.MemberContext);
      VirtSpecifiers VS/*J*/= new VirtSpecifiers();
      
      // Hold late-parsed attributes so we can attach a Decl to them later.
      LateParsedAttrList LateParsedAttrs/*J*/= new LateParsedAttrList();
      
      SourceLocation EqualLoc/*J*/= new SourceLocation();
      SourceLocation PureSpecLoc/*J*/= new SourceLocation();
      
      Bool2Bool TryConsumePureSpecifier =  /*[&]*/ (boolean AllowDefinition) -> 
        {
          if ($this().Tok.isNot(tok.TokenKind.equal)) {
            return false;
          }
          
          final /*const*/ Token /*&*/ Zero = $this().NextToken();
          SmallString/*8*/ Buffer/*J*/= new SmallString/*8*/(8);
          if (Zero.isNot(tok.TokenKind.numeric_constant) || Zero.getLength() != 1
             || $noteq_StringRef($this().PP.getSpelling(Zero, Buffer), /*STRINGREF_STR*/"0")) {
            return false;
          }
          
          final /*const*/ Token /*&*/ After = $this().GetLookAheadToken(2);
          if (!After.isOneOf(tok.TokenKind.semi, tok.TokenKind.comma)
             && !(AllowDefinition
             && After.isOneOf$T(tok.TokenKind.l_brace, tok.TokenKind.colon, tok.TokenKind.kw_try))) {
            return false;
          }
          
          EqualLoc.$assignMove($this().ConsumeToken());
          PureSpecLoc.$assignMove($this().ConsumeToken());
          return true;
        }
  ;
      
      SmallVector<Decl /*P*/> DeclsInGroup/*J*/= new SmallVector<Decl /*P*/>(8, null);
      ActionResultTTrue<Expr /*P*/ > BitfieldSize/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      boolean ExpectSemi = true;
      
      // Parse the first declarator.
      if ($this().ParseCXXMemberDeclaratorBeforeInitializer(DeclaratorInfo, VS, BitfieldSize, LateParsedAttrs)) {
        $this().TryConsumeToken(tok.TokenKind.semi);
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      // Check for a member function definition.
      if (BitfieldSize.isUnset()) {
        // MSVC permits pure specifier on inline functions defined at class scope.
        // Hence check for =0 before checking for function definition.
        if ($this().getLangOpts().MicrosoftExt && DeclaratorInfo.isDeclarationOfFunction()) {
          TryConsumePureSpecifier.$call(/*AllowDefinition*/ /*KEEP_BOOL*/true);
        }
        
        FunctionDefinitionKind DefinitionKind = FunctionDefinitionKind.FDK_Declaration;
        // function-definition:
        //
        // In C++11, a non-function declarator followed by an open brace is a
        // braced-init-list for an in-class member initialization, not an
        // erroneous function definition.
        if ($this().Tok.is(tok.TokenKind.l_brace) && !$this().getLangOpts().CPlusPlus11) {
          DefinitionKind = FunctionDefinitionKind.FDK_Definition;
        } else if (DeclaratorInfo.isFunctionDeclarator()) {
          if ($this().Tok.isOneOf$T(tok.TokenKind.l_brace, tok.TokenKind.colon, tok.TokenKind.kw_try)) {
            DefinitionKind = FunctionDefinitionKind.FDK_Definition;
          } else if ($this().Tok.is(tok.TokenKind.equal)) {
            final /*const*/ Token /*&*/ KW = $this().NextToken();
            if (KW.is(tok.TokenKind.kw_default)) {
              DefinitionKind = FunctionDefinitionKind.FDK_Defaulted;
            } else if (KW.is(tok.TokenKind.kw_delete)) {
              DefinitionKind = FunctionDefinitionKind.FDK_Deleted;
            }
          }
        }
        DeclaratorInfo.setFunctionDefinitionKind(DefinitionKind);
        
        // C++11 [dcl.attr.grammar] p4: If an attribute-specifier-seq appertains 
        // to a friend declaration, that declaration shall be a definition.
        if (DeclaratorInfo.isFunctionDeclarator()
           && DefinitionKind != FunctionDefinitionKind.FDK_Definition && DS.isFriendSpecified()) {
          // Diagnose attributes that appear before decl specifier:
          // [[]] friend int foo();
          $this().ProhibitAttributes(FnAttrs);
        }
        if (DefinitionKind != FunctionDefinitionKind.FDK_Declaration) {
          if (!DeclaratorInfo.isFunctionDeclarator()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(DeclaratorInfo.getIdentifierLoc(), diag.err_func_def_no_params)));
              $this().ConsumeBrace();
              $this().SkipUntil(tok.TokenKind.r_brace);
              
              // Consume the optional ';'
              $this().TryConsumeToken(tok.TokenKind.semi);
              
              return new OpaquePtr<DeclGroupRef>(null);
            } finally {
              $c$.$destroy();
            }
          }
          if (DS.getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(DeclaratorInfo.getIdentifierLoc(), 
                  diag.err_function_declared_typedef)));
              
              // Recover by treating the 'typedef' as spurious.
              DS.ClearStorageClassSpecs();
            } finally {
              $c$.$destroy();
            }
          }
          
          Decl /*P*/ FunDecl = $this().ParseCXXInlineMethodDef(AS, AccessAttrs, DeclaratorInfo, TemplateInfo, 
              VS, new SourceLocation(PureSpecLoc));
          if ((FunDecl != null)) {
            for (/*uint*/int i = 0, ni = CommonLateParsedAttrs.size(); $less_uint(i, ni); ++i) {
              CommonLateParsedAttrs.$at(i).addDecl(FunDecl);
            }
            for (/*uint*/int i = 0, ni = LateParsedAttrs.size(); $less_uint(i, ni); ++i) {
              LateParsedAttrs.$at(i).addDecl(FunDecl);
            }
          }
          LateParsedAttrs.clear();
          
          // Consume the ';' - it's optional unless we have a delete or default
          if ($this().Tok.is(tok.TokenKind.semi)) {
            $this().ConsumeExtraSemi(ExtraSemiKind.AfterMemberFunctionDefinition);
          }
          
          return OpaquePtr.<DeclGroupRef>make(new DeclGroupRef(FunDecl));
        }
      }
      
      // member-declarator-list:
      //   member-declarator
      //   member-declarator-list ',' member-declarator
      while (true) {
        InClassInitStyle HasInClassInit = InClassInitStyle.ICIS_NoInit;
        boolean HasStaticInitializer = false;
        if ($this().Tok.isOneOf(tok.TokenKind.equal, tok.TokenKind.l_brace) && PureSpecLoc.isInvalid()) {
          if ((BitfieldSize.get() != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_bitfield_member_init)));
              $this().SkipUntil(tok.TokenKind.comma, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
            } finally {
              $c$.$destroy();
            }
          } else if (DeclaratorInfo.isDeclarationOfFunction()) {
            // It's a pure-specifier.
            if (!TryConsumePureSpecifier.$call(/*AllowFunctionDefinition*/ /*KEEP_BOOL*/false)) {
              // Parse it as an expression so that Sema can diagnose it.
              HasStaticInitializer = true;
            }
          } else if (DeclaratorInfo.getDeclSpec().getStorageClassSpec()
             != DeclSpec.SCS.SCS_static
             && DeclaratorInfo.getDeclSpec().getStorageClassSpec()
             != DeclSpec.SCS.SCS_typedef
             && !DS.isFriendSpecified()) {
            // It's a default member initializer.
            HasInClassInit = $this().Tok.is(tok.TokenKind.equal) ? InClassInitStyle.ICIS_CopyInit : InClassInitStyle.ICIS_ListInit;
          } else {
            HasStaticInitializer = true;
          }
        }
        
        // NOTE: If Sema is the Action module and declarator is an instance field,
        // this call will *not* return the created decl; It will return null.
        // See Sema::ActOnCXXMemberDeclarator for details.
        NamedDecl /*P*/ ThisDecl = null;
        if (DS.isFriendSpecified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // C++11 [dcl.attr.grammar] p4: If an attribute-specifier-seq appertains
            // to a friend declaration, that declaration shall be a definition.
            //
            // Diagnose attributes that appear in a friend member function declarator:
            //   friend int foo [[]] ();
            SmallVector<SourceRange> Ranges/*J*/= new SmallVector<SourceRange>(4, SourceRange.EMPTY);
            DeclaratorInfo.getCXX11AttributeRanges(Ranges);
            for (type$ptr<SourceRange> I = $tryClone(Ranges.begin()), 
                /*P*/ E = $tryClone(Ranges.end()); $noteq_iter(I, E); I.$preInc())  {
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track($this().Diag((I.$star()).getBegin(), diag.err_attributes_not_allowed)), /*NO_COPY*/I.$star()));
            }
            
            ThisDecl = $this().Actions.ActOnFriendFunctionDecl($this().getCurScope(), DeclaratorInfo, 
                new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParams));
          } finally {
            $c$.$destroy();
          }
        } else {
          ThisDecl = $this().Actions.ActOnCXXMemberDeclarator($this().getCurScope(), AS, 
              DeclaratorInfo, 
              new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParams), 
              BitfieldSize.get(), 
              VS, HasInClassInit);
          {
            
            VarTemplateDecl /*P*/ VT = (ThisDecl != null) ? dyn_cast(VarTemplateDecl.class, ThisDecl) : null;
            if ((VT != null)) {
              // Re-direct this decl to refer to the templated decl so that we can
              // initialize it.
              ThisDecl = VT.getTemplatedDecl();
            }
          }
          if ((ThisDecl != null) && (AccessAttrs != null)) {
            $this().Actions.ProcessDeclAttributeList($this().getCurScope(), ThisDecl, AccessAttrs);
          }
        }
        
        // Error recovery might have converted a non-static member into a static
        // member.
        if (HasInClassInit != InClassInitStyle.ICIS_NoInit
           && DeclaratorInfo.getDeclSpec().getStorageClassSpec()
           == DeclSpec.SCS.SCS_static) {
          HasInClassInit = InClassInitStyle.ICIS_NoInit;
          HasStaticInitializer = true;
        }
        if ((ThisDecl != null) && PureSpecLoc.isValid()) {
          $this().Actions.ActOnPureSpecifier(ThisDecl, new SourceLocation(PureSpecLoc));
        }
        
        // Handle the initializer.
        if (HasInClassInit != InClassInitStyle.ICIS_NoInit) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // The initializer was deferred; parse it and cache the tokens.
            $c$.clean($c$.track($this().Diag($this().Tok, $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_nonstatic_member_init : diag.ext_nonstatic_member_init)));
            if (DeclaratorInfo.isArrayOfUnknownBound()) {
              // C++11 [dcl.array]p3: An array bound may also be omitted when the
              // declarator is followed by an initializer.
              //
              // A brace-or-equal-initializer for a member-declarator is not an
              // initializer in the grammar, so this is ill-formed.
              $c$.clean($c$.track($this().Diag($this().Tok, diag.err_incomplete_array_member_init)));
              $this().SkipUntil(tok.TokenKind.comma, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
              
              // Avoid later warnings about a class member of incomplete type.
              if ((ThisDecl != null)) {
                ThisDecl.setInvalidDecl();
              }
            } else {
              $this().ParseCXXNonStaticMemberInitializer(ThisDecl);
            }
          } finally {
            $c$.$destroy();
          }
        } else if (HasStaticInitializer) {
          // Normal initializer.
          ActionResultTTrue<Expr /*P*/ > Init = $this().ParseCXXMemberInitializer(ThisDecl, DeclaratorInfo.isDeclarationOfFunction(), EqualLoc);
          if (Init.isInvalid()) {
            $this().SkipUntil(tok.TokenKind.comma, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          } else if ((ThisDecl != null)) {
            $this().Actions.AddInitializerToDecl(ThisDecl, Init.get(), EqualLoc.isInvalid(), 
                DS.containsPlaceholderType());
          }
        } else if ((ThisDecl != null) && DS.getStorageClassSpec() == DeclSpec.SCS.SCS_static) {
          // No initializer.
          $this().Actions.ActOnUninitializedDecl(ThisDecl, DS.containsPlaceholderType());
        }
        if ((ThisDecl != null)) {
          if (!ThisDecl.isInvalidDecl()) {
            // Set the Decl for any late parsed attributes
            for (/*uint*/int i = 0, ni = CommonLateParsedAttrs.size(); $less_uint(i, ni); ++i)  {
              CommonLateParsedAttrs.$at(i).addDecl(ThisDecl);
            }
            
            for (/*uint*/int i = 0, ni = LateParsedAttrs.size(); $less_uint(i, ni); ++i)  {
              LateParsedAttrs.$at(i).addDecl(ThisDecl);
            }
          }
          $this().Actions.FinalizeDeclaration(ThisDecl);
          DeclsInGroup.push_back(ThisDecl);
          if (DeclaratorInfo.isFunctionDeclarator()
             && DeclaratorInfo.getDeclSpec().getStorageClassSpec()
             != DeclSpec.SCS.SCS_typedef) {
            $this().HandleMemberFunctionDeclDelays(DeclaratorInfo, ThisDecl);
          }
        }
        LateParsedAttrs.clear();
        
        DeclaratorInfo.complete(ThisDecl);
        
        // If we don't have a comma, it is either the end of the list (a ';')
        // or an error, bail out.
        SourceLocation CommaLoc/*J*/= new SourceLocation();
        if (!$this().TryConsumeToken(tok.TokenKind.comma, CommaLoc)) {
          break;
        }
        if ($this().Tok.isAtStartOfLine()
           && !$this().MightBeDeclarator(Declarator.TheContext.MemberContext.getValue())) {
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
        DeclaratorInfo.clear$ParsingDeclarator();
        VS.clear();
        BitfieldSize.$assignMove(new ActionResultTTrue<Expr /*P*/ >(/*Invalid=*/ false));
        EqualLoc.$assign(PureSpecLoc.$assignMove(new SourceLocation()));
        DeclaratorInfo.setCommaLoc(new SourceLocation(CommaLoc));
        
        // GNU attributes are allowed before the second and subsequent declarator.
        $this().MaybeParseGNUAttributes(DeclaratorInfo);
        if ($this().ParseCXXMemberDeclaratorBeforeInitializer(DeclaratorInfo, VS, BitfieldSize, LateParsedAttrs)) {
          break;
        }
      }
      if (ExpectSemi
         && $this().ExpectAndConsume(tok.TokenKind.semi, diag.err_expected_semi_decl_list)) {
        // Skip to end of block or statement.
        $this().SkipUntil(tok.TokenKind.r_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
        // If we stopped at a ';', eat it.
        $this().TryConsumeToken(tok.TokenKind.semi);
        return new OpaquePtr<DeclGroupRef>(null);
      }
      
      return $this().Actions.FinalizeDeclaratorGroup($this().getCurScope(), DS, new ArrayRef<Decl /*P*/ >(DeclsInGroup));
    } finally {
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
      if (FnAttrs != null) { FnAttrs.$destroy(); }
      if (attrs != null) { attrs.$destroy(); }
      if (X != null) { X.$destroy(); }
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseCXXClassMemberDeclarationWithPragmas">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 2842,
   FQN="clang::Parser::ParseCXXClassMemberDeclarationWithPragmas", NM="_ZN5clang6Parser41ParseCXXClassMemberDeclarationWithPragmasERNS_15AccessSpecifierERNS0_25ParsedAttributesWithRangeENS_17TypeSpecifierTypeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser41ParseCXXClassMemberDeclarationWithPragmasERNS_15AccessSpecifierERNS0_25ParsedAttributesWithRangeENS_17TypeSpecifierTypeEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ OpaquePtr<DeclGroupRef> ParseCXXClassMemberDeclarationWithPragmas(final type$ref<AccessSpecifier>/*&*/ AS, final ParsedAttributesWithRange /*&*/ AccessAttrs, 
                                           TypeSpecifierType TagType, Decl /*P*/ TagDecl) {
    if ($this().getLangOpts().MicrosoftExt
       && $this().Tok.isOneOf(tok.TokenKind.kw___if_exists, tok.TokenKind.kw___if_not_exists)) {
      $this().ParseMicrosoftIfExistsClassDeclaration(TagType, AS);
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    // Check for extraneous top-level semicolon.
    if ($this().Tok.is(tok.TokenKind.semi)) {
      $this().ConsumeExtraSemi(ExtraSemiKind.InsideStruct, TagType.getValue());
      return new OpaquePtr<DeclGroupRef>(null);
    }
    if ($this().Tok.is(tok.TokenKind.annot_pragma_vis)) {
      $this().HandlePragmaVisibility();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    if ($this().Tok.is(tok.TokenKind.annot_pragma_pack)) {
      $this().HandlePragmaPack();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    if ($this().Tok.is(tok.TokenKind.annot_pragma_align)) {
      $this().HandlePragmaAlign();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    if ($this().Tok.is(tok.TokenKind.annot_pragma_ms_pointers_to_members)) {
      $this().HandlePragmaMSPointersToMembers();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    if ($this().Tok.is(tok.TokenKind.annot_pragma_ms_pragma)) {
      $this().HandlePragmaMSPragma();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    if ($this().Tok.is(tok.TokenKind.annot_pragma_ms_vtordisp)) {
      $this().HandlePragmaMSVtorDisp();
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    // If we see a namespace here, a close brace was missing somewhere.
    if ($this().Tok.is(tok.TokenKind.kw_namespace)) {
      $this().DiagnoseUnexpectedNamespace(cast(NamedDecl.class, TagDecl));
      return new OpaquePtr<DeclGroupRef>(null);
    }
    
    AccessSpecifier NewAS = $this().getAccessSpecifierIfPresent();
    if (NewAS != AccessSpecifier.AS_none) {
      // Current token is a C++ access specifier.
      AS.$set(NewAS);
      SourceLocation ASLoc = $this().Tok.getLocation();
      /*uint*/int TokLength = $this().Tok.getLength();
      $this().ConsumeToken();
      AccessAttrs.clear();
      $this().MaybeParseGNUAttributes(AccessAttrs);
      
      SourceLocation EndLoc/*J*/= new SourceLocation();
      if ($this().TryConsumeToken(tok.TokenKind.colon, EndLoc)) {
      } else if ($this().TryConsumeToken(tok.TokenKind.semi, EndLoc)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_expected)), 
                  tok.TokenKind.colon), FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/EndLoc), new StringRef(/*KEEP_STR*/$COLON))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          EndLoc.$assignMove(ASLoc.getLocWithOffset(TokLength));
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_expected)), 
                  tok.TokenKind.colon), FixItHint.CreateInsertion(/*NO_COPY*/EndLoc, new StringRef(/*KEEP_STR*/$COLON))));
        } finally {
          $c$.$destroy();
        }
      }
      
      // The Microsoft extension __interface does not permit non-public
      // access specifiers.
      if (TagType == DeclSpec.TST_interface && AS.$deref() != AccessSpecifier.AS_public) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out$Same2Bool($c$.track($this().Diag(new SourceLocation(ASLoc), diag.err_access_specifier_interface)), (AS.$deref() == AccessSpecifier.AS_protected)));
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().Actions.ActOnAccessSpecifier(NewAS, new SourceLocation(ASLoc), new SourceLocation(EndLoc), 
          AccessAttrs.getList())) {
        // found another attribute than only annotations
        AccessAttrs.clear();
      }
      
      return new OpaquePtr<DeclGroupRef>(null);
    }
    if ($this().Tok.is(tok.TokenKind.annot_pragma_openmp)) {
      return $this().ParseOpenMPDeclarativeDirectiveWithExtDecl(AS, AccessAttrs, TagType, 
          TagDecl);
    }
    
    // Parse all the comma separated declarators.
    return $this().ParseCXXClassMemberDeclaration(AS.$deref(), AccessAttrs.getList());
  }


/// ParseConstructorInitializer - Parse a C++ constructor initializer,
/// which explicitly initializes the members or base classes of a
/// class (C++ [class.base.init]). For example, the three initializers
/// after the ':' in the Derived constructor below:
///
/// @code
/// class Base { };
/// class Derived : Base {
///   int x;
///   float f;
/// public:
///   Derived(float f) : Base(), x(17), f(f) { }
/// };
/// @endcode
///
/// [C++]  ctor-initializer:
///          ':' mem-initializer-list
///
/// [C++]  mem-initializer-list:
///          mem-initializer ...[opt]
///          mem-initializer ...[opt] , mem-initializer-list
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseConstructorInitializer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3195,
   FQN="clang::Parser::ParseConstructorInitializer", NM="_ZN5clang6Parser27ParseConstructorInitializerEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser27ParseConstructorInitializerEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void ParseConstructorInitializer(Decl /*P*/ ConstructorDecl) {
    PoisonSEHIdentifiersRAIIObject PoisonSEHIdentifiers = null;
    try {
      assert ($this().Tok.is(tok.TokenKind.colon)) : "Constructor initializer always starts with ':'";
      
      // Poison the SEH identifiers so they are flagged as illegal in constructor
      // initializers.
      PoisonSEHIdentifiers/*J*/= new PoisonSEHIdentifiersRAIIObject(/*Deref*/$this(), true);
      SourceLocation ColonLoc = $this().ConsumeToken();
      
      SmallVector<CXXCtorInitializer /*P*/ > MemInitializers/*J*/= new SmallVector<CXXCtorInitializer /*P*/ >(4, (CXXCtorInitializer /*P*/ )null);
      boolean AnyErrors = false;
      
      do {
        if ($this().Tok.is(tok.TokenKind.code_completion)) {
          $this().Actions.CodeCompleteConstructorInitializer(ConstructorDecl, 
              new ArrayRef<CXXCtorInitializer /*P*/ >(MemInitializers));
          $this().cutOffParsing();
          return;
        }
        
        ActionResultTTrue<CXXCtorInitializer /*P*/ > MemInit = $this().ParseMemInitializer(ConstructorDecl);
        if (!MemInit.isInvalid()) {
          MemInitializers.push_back(MemInit.get());
        } else {
          AnyErrors = true;
        }
        if ($this().Tok.is(tok.TokenKind.comma)) {
          $this().ConsumeToken();
        } else if ($this().Tok.is(tok.TokenKind.l_brace)) {
          break;
        } else // If the previous initializer was valid and the next token looks like a
        // base or member initializer, assume that we're just missing a comma.
        if (!MemInit.isInvalid()
           && $this().Tok.isOneOf(tok.TokenKind.identifier, tok.TokenKind.coloncolon)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation Loc = $this().PP.getLocForEndOfToken(/*NO_COPY*/$this().PrevTokLocation);
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_ctor_init_missing_comma)), 
                FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/$COMMA_SPACE))));
          } finally {
            $c$.$destroy();
          }
        } else {
          // Skip over garbage, until we get to '{'.  Don't eat the '{'.
          if (!MemInit.isInvalid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_either)), tok.TokenKind.l_brace), 
                  tok.TokenKind.comma));
            } finally {
              $c$.$destroy();
            }
          }
          $this().SkipUntil(tok.TokenKind.l_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
          break;
        }
      } while (true);
      
      $this().Actions.ActOnMemInitializers(ConstructorDecl, new SourceLocation(ColonLoc), new ArrayRef<CXXCtorInitializer /*P*/ >(MemInitializers), 
          AnyErrors);
    } finally {
      if (PoisonSEHIdentifiers != null) { PoisonSEHIdentifiers.$destroy(); }
    }
  }


/// ParseMemInitializer - Parse a C++ member initializer, which is
/// part of a constructor initializer that explicitly initializes one
/// member or base class (C++ [class.base.init]). See
/// ParseConstructorInitializer for an example.
///
/// [C++] mem-initializer:
///         mem-initializer-id '(' expression-list[opt] ')'
/// [C++0x] mem-initializer-id braced-init-list
///
/// [C++] mem-initializer-id:
///         '::'[opt] nested-name-specifier[opt] class-name
///         identifier
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMemInitializer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3257,
   FQN="clang::Parser::ParseMemInitializer", NM="_ZN5clang6Parser19ParseMemInitializerEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser19ParseMemInitializerEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<CXXCtorInitializer /*P*/ > ParseMemInitializer(Decl /*P*/ ConstructorDecl) {
    CXXScopeSpec SS = null;
    DeclSpec DS = null;
    try {
      // parse '::'[opt] nested-name-specifier[opt]
      SS/*J*/= new CXXScopeSpec();
      $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), /*EnteringContext=*/ false);
      OpaquePtr<QualType> TemplateTypeTy/*J*/= new OpaquePtr<QualType>();
      if ($this().Tok.is(tok.TokenKind.annot_template_id)) {
        TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
        if (TemplateId.Kind == TemplateNameKind.TNK_Type_template
           || TemplateId.Kind == TemplateNameKind.TNK_Dependent_template_name) {
          $this().AnnotateTemplateIdTokenAsType();
          assert ($this().Tok.is(tok.TokenKind.annot_typename)) : "template-id -> type failed";
          TemplateTypeTy.$assignMove(getTypeAnnotation($this().Tok));
        }
      }
      // Uses of decltype will already have been converted to annot_decltype by
      // ParseOptionalCXXScopeSpecifier at this point.
      if (!TemplateTypeTy.$bool() && $this().Tok.isNot(tok.TokenKind.identifier)
         && $this().Tok.isNot(tok.TokenKind.annot_decltype)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_member_or_base_name)));
          return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
        } finally {
          $c$.$destroy();
        }
      }
      
      IdentifierInfo /*P*/ II = null;
      DS/*J*/= new DeclSpec($this().AttrFactory);
      SourceLocation IdLoc = $this().Tok.getLocation();
      if ($this().Tok.is(tok.TokenKind.annot_decltype)) {
        // Get the decltype expression, if there is one.
        $this().ParseDecltypeSpecifier(DS);
      } else {
        if ($this().Tok.is(tok.TokenKind.identifier)) {
          // Get the identifier. This may be a member name or a class name,
          // but we'll let the semantic analysis determine which it is.
          II = $this().Tok.getIdentifierInfo();
        }
        $this().ConsumeToken();
      }
      
      // Parse the '('.
      if ($this().getLangOpts().CPlusPlus11 && $this().Tok.is(tok.TokenKind.l_brace)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.warn_cxx98_compat_generalized_initializer_lists)));
          
          ActionResultTTrue<Expr /*P*/ > InitList = $this().ParseBraceInitializer();
          if (InitList.isInvalid()) {
            return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
          }
          
          SourceLocation EllipsisLoc/*J*/= new SourceLocation();
          $this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc);
          
          return $this().Actions.ActOnMemInitializer(ConstructorDecl, $this().getCurScope(), SS, II, 
              new OpaquePtr<QualType>(TemplateTypeTy), DS, new SourceLocation(IdLoc), 
              InitList.get(), new SourceLocation(EllipsisLoc));
        } finally {
          $c$.$destroy();
        }
      } else if ($this().Tok.is(tok.TokenKind.l_paren)) {
        BalancedDelimiterTracker T = null;
        try {
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_paren);
          T.consumeOpen();
          
          // Parse the optional expression-list.
          SmallVector<Expr /*P*/ > ArgExprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
          SmallVector<SourceLocation> CommaLocs/*J*/= new SmallVector<SourceLocation>(20, new SourceLocation());
          if ($this().Tok.isNot(tok.TokenKind.r_paren) && $this().ParseExpressionList(ArgExprs, CommaLocs)) {
            $this().SkipUntil(tok.TokenKind.r_paren, SkipUntilFlags.StopAtSemi);
            return new ActionResultTTrue<CXXCtorInitializer /*P*/ >(true);
          }
          
          T.consumeClose();
          
          SourceLocation EllipsisLoc/*J*/= new SourceLocation();
          $this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc);
          
          return $this().Actions.ActOnMemInitializer(ConstructorDecl, $this().getCurScope(), SS, II, 
              new OpaquePtr<QualType>(TemplateTypeTy), DS, new SourceLocation(IdLoc), 
              T.getOpenLocation(), new ArrayRef<Expr /*P*/ >(ArgExprs), 
              T.getCloseLocation(), new SourceLocation(EllipsisLoc));
        } finally {
          if (T != null) { T.$destroy(); }
        }
      }
      if ($this().getLangOpts().CPlusPlus11) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new ActionResultTTrue<CXXCtorInitializer /*P*/ >($out_DiagnosticBuilder$C_TokenKind($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected_either)), tok.TokenKind.l_paren), tok.TokenKind.l_brace)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new ActionResultTTrue<CXXCtorInitializer /*P*/ >($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_paren)));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (DS != null) { DS.$destroy(); }
      if (SS != null) { SS.$destroy(); }
    }
  }


/// \brief If the given declarator has any parts for which parsing has to be
/// delayed, e.g., default arguments or an exception-specification, create a
/// late-parsed method declaration record to handle the parsing at the end of
/// the class definition.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::HandleMemberFunctionDeclDelays">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1963,
   FQN="clang::Parser::HandleMemberFunctionDeclDelays", NM="_ZN5clang6Parser30HandleMemberFunctionDeclDelaysERNS_10DeclaratorEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser30HandleMemberFunctionDeclDelaysERNS_10DeclaratorEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void HandleMemberFunctionDeclDelays(final Declarator /*&*/ DeclaratorInfo, 
                                Decl /*P*/ ThisDecl) {
    final DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = DeclaratorInfo.getFunctionTypeInfo();
    // If there was a late-parsed exception-specification, we'll need a
    // late parse
    boolean NeedLateParse = FTI.getExceptionSpecType() == ExceptionSpecificationType.EST_Unparsed;
    if (!NeedLateParse) {
      // Look ahead to see if there are any default args
      for (/*uint*/int ParamIdx = 0; $less_uint(ParamIdx, FTI.NumParams); ++ParamIdx) {
        ParmVarDecl /*P*/ Param = cast(ParmVarDecl.class, FTI.Params.$at(ParamIdx).Param);
        if (Param.hasUnparsedDefaultArg()) {
          NeedLateParse = true;
          break;
        }
      }
    }
    if (NeedLateParse) {
      // Push this method onto the stack of late-parsed method
      // declarations.
      LateParsedMethodDeclaration /*P*/ LateMethod = new LateParsedMethodDeclaration($this(), ThisDecl);
      $this().getCurrentClass().LateParsedDeclarations.push_back(LateMethod);
      LateMethod.TemplateScope = $this().getCurScope().isTemplateParamScope();
      
      // Stash the exception-specification tokens in the late-pased method.
      LateMethod.ExceptionSpecTokens = FTI.Unnamed_field21.ExceptionSpecTokens;
      FTI.Unnamed_field21.ExceptionSpecTokens = null;
      
      // Push tokens for each parameter.  Those that do not have
      // defaults will be NULL.
      LateMethod.DefaultArgs.reserve(FTI.NumParams);
      for (/*uint*/int ParamIdx = 0; $less_uint(ParamIdx, FTI.NumParams); ++ParamIdx)  {
        LateMethod.DefaultArgs.push_back(new LateParsedDefaultArgument(FTI.Params.$at(ParamIdx).Param, FTI.Params.$at(ParamIdx).DefaultArgTokens));
      }
    }
  }


//===--------------------------------------------------------------------===//
// C++ 10: Derived classes [class.derived]

/// ParseBaseTypeSpecifier - Parse a C++ base-type-specifier which is either a
/// class name or decltype-specifier. Note that we only check that the result 
/// names a type; semantic analysis will need to verify that the type names a 
/// class. The result is either a type or null, depending on whether a type 
/// name was found.
///
///       base-type-specifier: [C++11 class.derived]
///         class-or-decltype
///       class-or-decltype: [C++11 class.derived]
///         nested-name-specifier[opt] class-name
///         decltype-specifier
///       class-name: [C++ class.name]
///         identifier
///         simple-template-id
///
/// In C++98, instead of base-type-specifier, we have:
///
///         ::[opt] nested-name-specifier[opt] class-name
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBaseTypeSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 936,
   FQN="clang::Parser::ParseBaseTypeSpecifier", NM="_ZN5clang6Parser22ParseBaseTypeSpecifierERNS_14SourceLocationES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser22ParseBaseTypeSpecifierERNS_14SourceLocationES2_")
  //</editor-fold>
  protected /*private*/ ActionResult<OpaquePtr<QualType> > ParseBaseTypeSpecifier(final SourceLocation /*&*/ BaseLoc, 
                        final SourceLocation /*&*/ EndLocation) {
    CXXScopeSpec SS = null;
    DeclSpec DS = null;
    Declarator DeclaratorInfo = null;
    try {
      // Ignore attempts to use typename
      if ($this().Tok.is(tok.TokenKind.kw_typename)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok, diag.err_expected_class_name_not_template)), 
              FixItHint.CreateRemoval(new SourceRange($this().Tok.getLocation()))));
          $this().ConsumeToken();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Parse optional nested-name-specifier
      SS/*J*/= new CXXScopeSpec();
      $this().ParseOptionalCXXScopeSpecifier(SS, new OpaquePtr<QualType>(null), /*EnteringContext=*/ false);
      
      BaseLoc.$assignMove($this().Tok.getLocation());
      
      // Parse decltype-specifier
      // tok == kw_decltype is just error recovery, it can only happen when SS 
      // isn't empty
      if ($this().Tok.isOneOf(tok.TokenKind.kw_decltype, tok.TokenKind.annot_decltype)) {
        DeclSpec _DS = null;
        Declarator _DeclaratorInfo = null;
        try {
          if (SS.isNotEmpty()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(SS.getBeginLoc(), diag.err_unexpected_scope_on_base_decltype)), 
                  FixItHint.CreateRemoval(SS.getRange())));
            } finally {
              $c$.$destroy();
            }
          }
          // Fake up a Declarator to use with ActOnTypeName.
          _DS/*J*/= new DeclSpec($this().AttrFactory);
          
          EndLocation.$assignMove($this().ParseDecltypeSpecifier(_DS));
          
          _DeclaratorInfo/*J*/= new Declarator(_DS, Declarator.TheContext.TypeNameContext);
          return $this().Actions.ActOnTypeName($this().getCurScope(), _DeclaratorInfo);
        } finally {
          if (_DeclaratorInfo != null) { _DeclaratorInfo.$destroy(); }
          if (_DS != null) { _DS.$destroy(); }
        }
      }
      
      // Check whether we have a template-id that names a type.
      if ($this().Tok.is(tok.TokenKind.annot_template_id)) {
        TemplateIdAnnotation /*P*/ TemplateId = $this().takeTemplateIdAnnotation($this().Tok);
        if (TemplateId.Kind == TemplateNameKind.TNK_Type_template
           || TemplateId.Kind == TemplateNameKind.TNK_Dependent_template_name) {
          $this().AnnotateTemplateIdTokenAsType();
          assert ($this().Tok.is(tok.TokenKind.annot_typename)) : "template-id -> type failed";
          OpaquePtr<QualType> Type = getTypeAnnotation($this().Tok);
          EndLocation.$assignMove($this().Tok.getAnnotationEndLoc());
          $this().ConsumeToken();
          if (Type.$bool()) {
            return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<QualType>(Type));
          }
          return new ActionResult<OpaquePtr<QualType> >(true);
        }
        // Fall through to produce an error below.
      }
      if ($this().Tok.isNot(tok.TokenKind.identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_class_name)));
          return new ActionResult<OpaquePtr<QualType> >(true);
        } finally {
          $c$.$destroy();
        }
      }
      
      IdentifierInfo /*P*/ Id = $this().Tok.getIdentifierInfo();
      SourceLocation IdLoc = $this().ConsumeToken();
      if ($this().Tok.is(tok.TokenKind.less)) {
        // It looks the user intended to write a template-id here, but the
        // template-name was wrong. Try to fix that.
        type$ref<TemplateNameKind> TNK = create_type$ref(TemplateNameKind.TNK_Type_template);
        OpaquePtr<TemplateName> Template/*J*/= new OpaquePtr<TemplateName>();
        if (!$this().Actions.DiagnoseUnknownTemplateName($Deref(Id), new SourceLocation(IdLoc), $this().getCurScope(), 
            $AddrOf(SS), Template, TNK)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_IdentifierInfo$C$P($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_unknown_template_name)), 
                Id));
          } finally {
            $c$.$destroy();
          }
        }
        if (!Template.$bool()) {
          SmallVector<ParsedTemplateArgument> TemplateArgs = null;
          try {
            TemplateArgs/*J*/= new SmallVector<ParsedTemplateArgument>(16, new ParsedTemplateArgument());
            SourceLocation LAngleLoc/*J*/= new SourceLocation(), RAngleLoc/*J*/= new SourceLocation();
            $this().ParseTemplateIdAfterTemplateName(new OpaquePtr<TemplateName>(null), new SourceLocation(IdLoc), SS, true, LAngleLoc, 
                TemplateArgs, RAngleLoc);
            return new ActionResult<OpaquePtr<QualType> >(true);
          } finally {
            if (TemplateArgs != null) { TemplateArgs.$destroy(); }
          }
        }
        
        // Form the template name
        UnqualifiedId TemplateName/*J*/= new UnqualifiedId();
        TemplateName.setIdentifier(Id, new SourceLocation(IdLoc));
        
        // Parse the full template-id, then turn it into a type.
        if ($this().AnnotateTemplateIdToken(new OpaquePtr<TemplateName>(Template), TNK.$deref(), SS, new SourceLocation(), 
            TemplateName, true)) {
          return new ActionResult<OpaquePtr<QualType> >(true);
        }
        if (TNK.$deref() == TemplateNameKind.TNK_Dependent_template_name) {
          $this().AnnotateTemplateIdTokenAsType();
        }
        
        // If we didn't end up with a typename token, there's nothing more we
        // can do.
        if ($this().Tok.isNot(tok.TokenKind.annot_typename)) {
          return new ActionResult<OpaquePtr<QualType> >(true);
        }
        
        // Retrieve the type from the annotation token, consume that token, and
        // return.
        EndLocation.$assignMove($this().Tok.getAnnotationEndLoc());
        OpaquePtr<QualType> Type = getTypeAnnotation($this().Tok);
        $this().ConsumeToken();
        return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<QualType>(Type));
      }
      
      // We have an identifier; check whether it is actually a type.
      type$ptr<IdentifierInfo> /*P*/ CorrectedII = create_type$null$ptr();
      OpaquePtr<QualType> Type = $this().Actions.getTypeName($Deref(Id), new SourceLocation(IdLoc), $this().getCurScope(), $AddrOf(SS), true, false, new OpaquePtr<QualType>(null), 
          /*IsCtorOrDtorName=*/ false, 
          /*NonTrivialTypeSourceInfo=*/ true, $AddrOf(CorrectedII));
      if (!Type.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(IdLoc), diag.err_expected_class_name)));
          return new ActionResult<OpaquePtr<QualType> >(true);
        } finally {
          $c$.$destroy();
        }
      }
      
      // Consume the identifier.
      EndLocation.$assign(IdLoc);
      
      // Fake up a Declarator to use with ActOnTypeName.
      DS/*J*/= new DeclSpec($this().AttrFactory);
      DS.SetRangeStart(new SourceLocation(IdLoc));
      DS.SetRangeEnd(new SourceLocation(EndLocation));
      DS.getTypeSpecScope().$assign(SS);
      
      /*const*/char$ptr/*char P*/ PrevSpec = create_char$null$ptr();
      /*uint*/uint$ref DiagID = create_uint$ref();
      DS.SetTypeSpecType(TypeSpecifierType.TST_typename, new SourceLocation(IdLoc), PrevSpec, DiagID, new OpaquePtr<QualType>(Type), 
          $this().Actions.getASTContext().getPrintingPolicy());
      
      DeclaratorInfo/*J*/= new Declarator(DS, Declarator.TheContext.TypeNameContext);
      return $this().Actions.ActOnTypeName($this().getCurScope(), DeclaratorInfo);
    } finally {
      if (DeclaratorInfo != null) { DeclaratorInfo.$destroy(); }
      if (DS != null) { DS.$destroy(); }
      if (SS != null) { SS.$destroy(); }
    }
  }


/// ParseBaseClause - Parse the base-clause of a C++ class [C++ class.derived].
///
///       base-clause : [C++ class.derived]
///         ':' base-specifier-list
///       base-specifier-list:
///         base-specifier '...'[opt]
///         base-specifier-list ',' base-specifier '...'[opt]
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBaseClause">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1836,
   FQN="clang::Parser::ParseBaseClause", NM="_ZN5clang6Parser15ParseBaseClauseEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser15ParseBaseClauseEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ void ParseBaseClause(Decl /*P*/ ClassDecl) {
    assert ($this().Tok.is(tok.TokenKind.colon)) : "Not a base clause";
    $this().ConsumeToken();
    
    // Build up an array of parsed base specifiers.
    SmallVector<CXXBaseSpecifier /*P*/> BaseInfo/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(8, null);
    while (true) {
      // Parse a base-specifier.
      ActionResultTTrue<CXXBaseSpecifier /*P*/ > Result = $this().ParseBaseSpecifier(ClassDecl);
      if (Result.isInvalid()) {
        // Skip the rest of this base specifier, up until the comma or
        // opening brace.
        $this().SkipUntil(tok.TokenKind.comma, tok.TokenKind.l_brace, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
      } else {
        // Add this to our array of base specifiers.
        BaseInfo.push_back(Result.get());
      }
      
      // If the next token is a comma, consume it and keep reading
      // base-specifiers.
      if (!$this().TryConsumeToken(tok.TokenKind.comma)) {
        break;
      }
    }
    
    // Attach the base specifiers
    $this().Actions.ActOnBaseSpecifiers(ClassDecl, new MutableArrayRef<CXXBaseSpecifier /*P*/ >(BaseInfo));
  }


/// ParseBaseSpecifier - Parse a C++ base-specifier. A base-specifier is
/// one entry in the base class list of a class specifier, for example:
///    class foo : public bar, virtual private baz {
/// 'public bar' and 'virtual private baz' are each base-specifiers.
///
///       base-specifier: [C++ class.derived]
///         attribute-specifier-seq[opt] base-type-specifier
///         attribute-specifier-seq[opt] 'virtual' access-specifier[opt]
///                 base-type-specifier
///         attribute-specifier-seq[opt] access-specifier 'virtual'[opt]
///                 base-type-specifier
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBaseSpecifier">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1876,
   FQN="clang::Parser::ParseBaseSpecifier", NM="_ZN5clang6Parser18ParseBaseSpecifierEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser18ParseBaseSpecifierEPNS_4DeclE")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<CXXBaseSpecifier /*P*/ > ParseBaseSpecifier(Decl /*P*/ ClassDecl) {
    ParsedAttributesWithRange Attributes = null;
    try {
      boolean IsVirtual = false;
      SourceLocation StartLoc = $this().Tok.getLocation();
      
      Attributes/*J*/= new ParsedAttributesWithRange($this().AttrFactory);
      $this().MaybeParseCXX11Attributes(Attributes);
      
      // Parse the 'virtual' keyword.
      if ($this().TryConsumeToken(tok.TokenKind.kw_virtual)) {
        IsVirtual = true;
      }
      
      $this().CheckMisplacedCXX11Attribute(Attributes, new SourceLocation(StartLoc));
      
      // Parse an (optional) access specifier.
      AccessSpecifier Access = $this().getAccessSpecifierIfPresent();
      if (Access != AccessSpecifier.AS_none) {
        $this().ConsumeToken();
      }
      
      $this().CheckMisplacedCXX11Attribute(Attributes, new SourceLocation(StartLoc));
      
      // Parse the 'virtual' keyword (again!), in case it came after the
      // access specifier.
      if ($this().Tok.is(tok.TokenKind.kw_virtual)) {
        SourceLocation VirtualLoc = $this().ConsumeToken();
        if (IsVirtual) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Complain about duplicate 'virtual'
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(VirtualLoc), diag.err_dup_virtual)), 
                FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/VirtualLoc))));
          } finally {
            $c$.$destroy();
          }
        }
        
        IsVirtual = true;
      }
      
      $this().CheckMisplacedCXX11Attribute(Attributes, new SourceLocation(StartLoc));
      
      // Parse the class-name.
      
      // HACK: MSVC doesn't consider _Atomic to be a keyword and its STL
      // implementation for VS2013 uses _Atomic as an identifier for one of the
      // classes in <atomic>.  Treat '_Atomic' to be an identifier when we are
      // parsing the class-name for a base specifier.
      if ($this().getLangOpts().MSVCCompat && $this().Tok.is(tok.TokenKind.kw__Atomic)
         && $this().NextToken().is(tok.TokenKind.less)) {
        $this().Tok.setKind(tok.TokenKind.identifier);
      }
      
      SourceLocation EndLocation/*J*/= new SourceLocation();
      SourceLocation BaseLoc/*J*/= new SourceLocation();
      ActionResult<OpaquePtr<QualType> > BaseType = $this().ParseBaseTypeSpecifier(BaseLoc, EndLocation);
      if (BaseType.isInvalid()) {
        return new ActionResultTTrue<CXXBaseSpecifier /*P*/ >(true);
      }
      
      // Parse the optional ellipsis (for a pack expansion). The ellipsis is 
      // actually part of the base-specifier-list grammar productions, but we
      // parse it here for convenience.
      SourceLocation EllipsisLoc/*J*/= new SourceLocation();
      $this().TryConsumeToken(tok.TokenKind.ellipsis, EllipsisLoc);
      
      // Find the complete source range for the base-specifier.
      SourceRange Range/*J*/= new SourceRange(/*NO_COPY*/StartLoc, /*NO_COPY*/EndLocation);
      
      // Notify semantic analysis that we have parsed a complete
      // base-specifier.
      return $this().Actions.ActOnBaseSpecifier(ClassDecl, new SourceRange(Range), Attributes, IsVirtual, 
          Access, BaseType.get(), new SourceLocation(BaseLoc), 
          new SourceLocation(EllipsisLoc));
    } finally {
      if (Attributes != null) { Attributes.$destroy(); }
    }
  }


/// getAccessSpecifierIfPresent - Determine whether the next token is
/// a C++ access-specifier.
///
///       access-specifier: [C++ class.derived]
///         'private'
///         'protected'
///         'public'
//<editor-fold defaultstate="collapsed" desc="clang::Parser::getAccessSpecifierIfPresent">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1950,
   FQN="clang::Parser::getAccessSpecifierIfPresent", NM="_ZNK5clang6Parser27getAccessSpecifierIfPresentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZNK5clang6Parser27getAccessSpecifierIfPresentEv")
  //</editor-fold>
  protected /*private*/ AccessSpecifier getAccessSpecifierIfPresent() /*const*/ {
    switch ($this().Tok.getKind()) {
     default:
      return AccessSpecifier.AS_none;
     case tok.TokenKind.kw_private:
      return AccessSpecifier.AS_private;
     case tok.TokenKind.kw_protected:
      return AccessSpecifier.AS_protected;
     case tok.TokenKind.kw_public:
      return AccessSpecifier.AS_public;
    }
  }

} // END OF class Parser_ParseDeclCXX
