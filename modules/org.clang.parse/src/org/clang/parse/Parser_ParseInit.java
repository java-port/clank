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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.parse.impl.ParseInitStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_ParseInit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_ParseExprCXX ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang6Parser21MayBeDesignationStartEv;_ZN5clang6Parser21ParseBraceInitializerEv;_ZN5clang6Parser38ParseMicrosoftIfExistsBraceInitializerERN4llvm11SmallVectorIPNS_4ExprELj12EEERb;_ZN5clang6Parser39ParseInitializerWithPotentialDesignatorEv; -static-type=Parser_ParseInit -package=org.clang.parse")
//</editor-fold>
public class Parser_ParseInit extends Parser_ParseExprCXX {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// MayBeDesignationStart - Return true if the current token might be the start 
/// of a designator.  If we can tell it is impossible that it is a designator, 
/// return false.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::MayBeDesignationStart">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp", line = 27,
   FQN="clang::Parser::MayBeDesignationStart", NM="_ZN5clang6Parser21MayBeDesignationStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang6Parser21MayBeDesignationStartEv")
  //</editor-fold>
  protected /*private*/ boolean MayBeDesignationStart() {
    TentativeParsingAction Tentative = null;
    LambdaIntroducer Intro = null;
    try {
      switch ($this().Tok.getKind()) {
       default:
        return false;
       case tok.TokenKind.period: // designator: '.' identifier
        return true;
       case tok.TokenKind.l_square:
        { // designator: array-designator
          if (!$this().PP.getLangOpts().CPlusPlus11) {
            return true;
          }
          
          // C++11 lambda expressions and C99 designators can be ambiguous all the
          // way through the closing ']' and to the next character. Handle the easy
          // cases here, and fall back to tentative parsing if those fail.
          switch ($this().PP.LookAhead(0).getKind()) {
           case tok.TokenKind.equal:
           case tok.TokenKind.r_square:
            // Definitely starts a lambda expression.
            return false;
           case tok.TokenKind.amp:
           case tok.TokenKind.kw_this:
           case tok.TokenKind.identifier:
            // We have to do additional analysis, because these could be the
            // start of a constant expression or a lambda capture list.
            break;
           default:
            // Anything not mentioned above cannot occur following a '[' in a 
            // lambda expression.
            return true;
          }
          
          // Handle the complicated case below.
          break;
        }
       case tok.TokenKind.identifier: // designation: identifier ':'
        return $this().PP.LookAhead(0).is(tok.TokenKind.colon);
      }
      
      // Parse up to (at most) the token after the closing ']' to determine 
      // whether this is a C99 designator or a lambda.
      Tentative/*J*/= new TentativeParsingAction(/*Deref*/$this());
      
      Intro/*J*/= new LambdaIntroducer();
      bool$ptr SkippedInits = create_bool$ptr(false);
      OptionalUInt DiagID/*J*/= $this().ParseLambdaIntroducer(Intro, $AddrOf(SkippedInits));
      if (DiagID.$bool()) {
        // If this can't be a lambda capture list, it's a designator.
        Tentative.Revert();
        return true;
      }
      
      // Once we hit the closing square bracket, we look at the next
      // token. If it's an '=', this is a designator. Otherwise, it's a
      // lambda expression. This decision favors lambdas over the older
      // GNU designator syntax, which allows one to omit the '=', but is
      // consistent with GCC.
      /*tok.TokenKind*/char Kind = $this().Tok.getKind();
      // FIXME: If we didn't skip any inits, parse the lambda from here
      // rather than throwing away then reparsing the LambdaIntroducer.
      Tentative.Revert();
      return Kind == tok.TokenKind.equal;
    } finally {
      if (Intro != null) { Intro.$destroy(); }
      if (Tentative != null) { Tentative.$destroy(); }
    }
  }


/// ParseBraceInitializer - Called when parsing an initializer that has a
/// leading open brace.
///
///       initializer: [C99 6.7.8]
///         '{' initializer-list '}'
///         '{' initializer-list ',' '}'
/// [GNU]   '{' '}'
///
///       initializer-list:
///         designation[opt] initializer ...[opt]
///         initializer-list ',' designation[opt] initializer ...[opt]
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseBraceInitializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp", line = 389,
   FQN="clang::Parser::ParseBraceInitializer", NM="_ZN5clang6Parser21ParseBraceInitializerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang6Parser21ParseBraceInitializerEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseBraceInitializer() {
    InMessageExpressionRAIIObject InMessage = null;
    BalancedDelimiterTracker T = null;
    try {
      InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), false);
      
      T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      T.consumeOpen();
      SourceLocation LBraceLoc = T.getOpenLocation();
      
      /// InitExprs - This is the actual list of expressions contained in the
      /// initializer.
      SmallVector<Expr /*P*/ > InitExprs/*J*/= new SmallVector<Expr /*P*/ >(12, (Expr /*P*/ )null);
      if ($this().Tok.is(tok.TokenKind.r_brace)) {
        // Empty initializers are a C++ feature and a GNU extension to C.
        if (!$this().getLangOpts().CPlusPlus) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(LBraceLoc), diag.ext_gnu_empty_initializer)));
          } finally {
            $c$.$destroy();
          }
        }
        // Match the '}'.
        return $this().Actions.ActOnInitList(new SourceLocation(LBraceLoc), MutableArrayRef.<Expr /*P*/ >None(), $this().ConsumeBrace());
      }
      
      bool$ref InitExprsOk = create_bool$ref(true);
      while (true) {
        // Handle Microsoft __if_exists/if_not_exists if necessary.
        if ($this().getLangOpts().MicrosoftExt && ($this().Tok.is(tok.TokenKind.kw___if_exists)
           || $this().Tok.is(tok.TokenKind.kw___if_not_exists))) {
          if ($this().ParseMicrosoftIfExistsBraceInitializer(InitExprs, InitExprsOk)) {
            if ($this().Tok.isNot(tok.TokenKind.comma)) {
              break;
            }
            $this().ConsumeToken();
          }
          if ($this().Tok.is(tok.TokenKind.r_brace)) {
            break;
          }
          continue;
        }
        
        // Parse: designation[opt] initializer
        
        // If we know that this cannot be a designation, just parse the nested
        // initializer directly.
        ActionResultTTrue<Expr /*P*/ > SubElt/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if ($this().MayBeDesignationStart()) {
          SubElt.$assignMove($this().ParseInitializerWithPotentialDesignator());
        } else {
          SubElt.$assignMove($this().ParseInitializer());
        }
        if ($this().Tok.is(tok.TokenKind.ellipsis)) {
          SubElt.$assignMove($this().Actions.ActOnPackExpansion(SubElt.get(), $this().ConsumeToken()));
        }
        
        SubElt.$assignMove($this().Actions.CorrectDelayedTyposInExpr(SubElt.get()));
        
        // If we couldn't parse the subelement, bail out.
        if (SubElt.isUsable()) {
          InitExprs.push_back(SubElt.get());
        } else {
          InitExprsOk.$set(false);
          
          // We have two ways to try to recover from this error: if the code looks
          // grammatically ok (i.e. we have a comma coming up) try to continue
          // parsing the rest of the initializer.  This allows us to emit
          // diagnostics for later elements that we find.  If we don't see a comma,
          // assume there is a parse error, and just skip to recover.
          // FIXME: This comment doesn't sound right. If there is a r_brace
          // immediately, it can't be an error, since there is no other way of
          // leaving this loop except through this if.
          if ($this().Tok.isNot(tok.TokenKind.comma)) {
            $this().SkipUntil(tok.TokenKind.r_brace, SkipUntilFlags.StopBeforeMatch);
            break;
          }
        }
        
        // If we don't have a comma continued list, we're done.
        if ($this().Tok.isNot(tok.TokenKind.comma)) {
          break;
        }
        
        // TODO: save comma locations if some client cares.
        $this().ConsumeToken();
        
        // Handle trailing comma.
        if ($this().Tok.is(tok.TokenKind.r_brace)) {
          break;
        }
      }
      
      boolean closed = !T.consumeClose();
      if (InitExprsOk.$deref() && closed) {
        return $this().Actions.ActOnInitList(new SourceLocation(LBraceLoc), new MutableArrayRef<Expr /*P*/ >(InitExprs), 
            T.getCloseLocation());
      }
      
      return ExprError(); // an error occurred.
    } finally {
      if (T != null) { T.$destroy(); }
      if (InMessage != null) { InMessage.$destroy(); }
    }
  }


/// ParseInitializerWithPotentialDesignator - Parse the 'initializer' production
/// checking to see if the token stream starts with a designator.
///
///       designation:
///         designator-list '='
/// [GNU]   array-designator
/// [GNU]   identifier ':'
///
///       designator-list:
///         designator
///         designator-list designator
///
///       designator:
///         array-designator
///         '.' identifier
///
///       array-designator:
///         '[' constant-expression ']'
/// [GNU]   '[' constant-expression '...' constant-expression ']'
///
/// NOTE: [OBC] allows '[ objc-receiver objc-message-args ]' as an
/// initializer (because it is an expression).  We need to consider this case
/// when parsing array designators.
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseInitializerWithPotentialDesignator">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp", line = 131,
   FQN="clang::Parser::ParseInitializerWithPotentialDesignator", NM="_ZN5clang6Parser39ParseInitializerWithPotentialDesignatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang6Parser39ParseInitializerWithPotentialDesignatorEv")
  //</editor-fold>
  protected /*private*/ ActionResultTTrue<Expr /*P*/ > ParseInitializerWithPotentialDesignator() {
    Designation Desig = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // If this is the old-style GNU extension:
      //   designation ::= identifier ':'
      // Handle it as a field designator.  Otherwise, this must be the start of a
      // normal expression.
      if ($this().Tok.is(tok.TokenKind.identifier)) {
        Designation D = null;
        try {
          /*const*/ IdentifierInfo /*P*/ FieldName = $this().Tok.getIdentifierInfo();
          
          SmallString/*256*/ NewSyntax/*J*/= new SmallString/*256*/(256);
          $c$.clean($c$.track(new raw_svector_ostream(NewSyntax)).$out_char($$DOT).$out(FieldName.getName()).$out(
              /*KEEP_STR*/" = "
          ));
          
          SourceLocation NameLoc = $this().ConsumeToken(); // Eat the identifier.
          assert ($this().Tok.is(tok.TokenKind.colon)) : "MayBeDesignationStart not working properly!";
          SourceLocation ColonLoc = $this().ConsumeToken();
          
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag(new SourceLocation(NameLoc), diag.ext_gnu_old_style_field_designator)), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/NameLoc, /*NO_COPY*/ColonLoc), 
                  NewSyntax.$StringRef())));
          
          D/*J*/= new Designation();
          D.AddDesignator(Designator.getField(FieldName, new SourceLocation(), new SourceLocation(NameLoc)));
          return $this().Actions.ActOnDesignatedInitializer(D, new SourceLocation(ColonLoc), true, 
              $this().ParseInitializer());
        } finally {
          if (D != null) { D.$destroy(); }
        }
      }
      
      // Desig - This is initialized when we see our first designator.  We may have
      // an objc message send with no designator, so we don't want to create this
      // eagerly.
      Desig/*J*/= new Designation();
      
      // Parse each designator in the designator list until we find an initializer.
      while ($this().Tok.is(tok.TokenKind.period) || $this().Tok.is(tok.TokenKind.l_square)) {
        InMessageExpressionRAIIObject InMessage = null;
        BalancedDelimiterTracker T = null;
        try {
          if ($this().Tok.is(tok.TokenKind.period)) {
            // designator: '.' identifier
            SourceLocation DotLoc = $this().ConsumeToken();
            if ($this().Tok.isNot(tok.TokenKind.identifier)) {
              $c$.clean($c$.track($this().Diag($this().Tok.getLocation(), diag.err_expected_field_designator)));
              return ExprError();
            }
            
            Desig.AddDesignator(Designator.getField($this().Tok.getIdentifierInfo(), new SourceLocation(DotLoc), 
                    $this().Tok.getLocation()));
            $this().ConsumeToken(); // Eat the identifier.
            continue;
          }
          
          // We must have either an array designator now or an objc message send.
          assert ($this().Tok.is(tok.TokenKind.l_square)) : "Unexpected token!";
          
          // Handle the two forms of array designator:
          //   array-designator: '[' constant-expression ']'
          //   array-designator: '[' constant-expression '...' constant-expression ']'
          //
          // Also, we have to handle the case where the expression after the
          // designator an an objc message send: '[' objc-message-expr ']'.
          // Interesting cases are:
          //   [foo bar]         -> objc message send
          //   [foo]             -> array designator
          //   [foo ... bar]     -> array designator
          //   [4][foo bar]      -> obsolete GNU designation with objc message send.
          //
          // We do not need to check for an expression starting with [[ here. If it
          // contains an Objective-C message send, then it is not an ill-formed
          // attribute. If it is a lambda-expression within an array-designator, then
          // it will be rejected because a constant-expression cannot begin with a
          // lambda-expression.
          InMessage/*J*/= new InMessageExpressionRAIIObject(/*Deref*/$this(), true);
          
          T/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_square);
          T.consumeOpen();
          SourceLocation StartLoc = T.getOpenLocation();
          
          ActionResultTTrue<Expr /*P*/ > Idx/*J*/= new ActionResultTTrue<Expr /*P*/ >();
          
          // If Objective-C is enabled and this is a typename (class message
          // send) or send to 'super', parse this as a message send
          // expression.  We handle C++ and C separately, since C++ requires
          // much more complicated parsing.
          if ($this().getLangOpts().ObjC1 && $this().getLangOpts().CPlusPlus) {
            // Send to 'super'.
            if ($this().Tok.is(tok.TokenKind.identifier) && $this().Tok.getIdentifierInfo() == $this().Ident_super
               && $this().NextToken().isNot(tok.TokenKind.period)
               && $this().getCurScope().isInObjcMethodScope()) {
              CheckArrayDesignatorSyntax(/*Deref*/$this(), new SourceLocation(StartLoc), Desig);
              return $this().ParseAssignmentExprWithObjCMessageExprStart(new SourceLocation(StartLoc), $this().ConsumeToken(), new OpaquePtr<QualType>(null), (Expr /*P*/ )null);
            }
            
            // Parse the receiver, which is either a type or an expression.
            bool$ref IsExpr = create_bool$ref();
            type$ref<Object/*void P*/> TypeOrExpr = create_type$ref(null);
            if ($this().ParseObjCXXMessageReceiver(IsExpr, TypeOrExpr)) {
              $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
              return ExprError();
            }
            
            // If the receiver was a type, we have a class message; parse
            // the rest of it.
            if (!IsExpr.$deref()) {
              CheckArrayDesignatorSyntax(/*Deref*/$this(), new SourceLocation(StartLoc), Desig);
              return $this().ParseAssignmentExprWithObjCMessageExprStart(new SourceLocation(StartLoc), 
                  new SourceLocation(), 
                  OpaquePtr.<QualType>getFromOpaquePtr((QualType)TypeOrExpr.$deref()), 
                  (Expr /*P*/ )null);
            }
            
            // If the receiver was an expression, we still don't know
            // whether we have a message send or an array designator; just
            // adopt the expression for further analysis below.
            // FIXME: potentially-potentially evaluated expression above?
            Idx.$assignMove(new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ((/*static_cast*/Expr /*P*/ )(TypeOrExpr.$deref()))));
          } else if ($this().getLangOpts().ObjC1 && $this().Tok.is(tok.TokenKind.identifier)) {
            IdentifierInfo /*P*/ II = $this().Tok.getIdentifierInfo();
            SourceLocation IILoc = $this().Tok.getLocation();
            OpaquePtr<QualType> ReceiverType/*J*/= new OpaquePtr<QualType>();
            // Three cases. This is a message send to a type: [type foo]
            // This is a message send to super:  [super foo]
            // This is a message sent to an expr:  [super.bar foo]
            switch ($this().Actions.getObjCMessageKind($this().getCurScope(), II, new SourceLocation(IILoc), II == $this().Ident_super, 
                $this().NextToken().is(tok.TokenKind.period), ReceiverType)) {
             case ObjCSuperMessage:
              CheckArrayDesignatorSyntax(/*Deref*/$this(), new SourceLocation(StartLoc), Desig);
              return $this().ParseAssignmentExprWithObjCMessageExprStart(new SourceLocation(StartLoc), $this().ConsumeToken(), new OpaquePtr<QualType>(null), (Expr /*P*/ )null);
             case ObjCClassMessage:
              CheckArrayDesignatorSyntax(/*Deref*/$this(), new SourceLocation(StartLoc), Desig);
              $this().ConsumeToken(); // the identifier
              if (!ReceiverType.$bool()) {
                $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
                return ExprError();
              }
              
              // Parse type arguments and protocol qualifiers.
              if ($this().Tok.is(tok.TokenKind.less)) {
                SourceLocation NewEndLoc/*J*/= new SourceLocation();
                ActionResult<OpaquePtr<QualType> > NewReceiverType = $this().parseObjCTypeArgsAndProtocolQualifiers(new SourceLocation(IILoc), new OpaquePtr<QualType>(ReceiverType), 
                    /*consumeLastToken=*/ true, 
                    NewEndLoc);
                if (!NewReceiverType.isUsable()) {
                  $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
                  return ExprError();
                }
                
                ReceiverType.$assignMove(NewReceiverType.get());
              }
              
              return $this().ParseAssignmentExprWithObjCMessageExprStart(new SourceLocation(StartLoc), 
                  new SourceLocation(), 
                  new OpaquePtr<QualType>(ReceiverType), 
                  (Expr /*P*/ )null);
             case ObjCInstanceMessage:
              // Fall through; we'll just parse the expression and
              // (possibly) treat this like an Objective-C message send
              // later.
              break;
            }
          }
          
          // Parse the index expression, if we haven't already gotten one
          // above (which can only happen in Objective-C++).
          // Note that we parse this as an assignment expression, not a constant
          // expression (allowing *=, =, etc) to handle the objc case.  Sema needs
          // to validate that the expression is a constant.
          // FIXME: We also need to tell Sema that we're in a
          // potentially-potentially evaluated context.
          if (!(Idx.get() != null)) {
            Idx.$assignMove($this().ParseAssignmentExpression());
            if (Idx.isInvalid()) {
              $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
              return Idx;
            }
          }
          
          // Given an expression, we could either have a designator (if the next
          // tokens are '...' or ']' or an objc message send.  If this is an objc
          // message send, handle it now.  An objc-message send is the start of
          // an assignment-expression production.
          if ($this().getLangOpts().ObjC1 && $this().Tok.isNot(tok.TokenKind.ellipsis)
             && $this().Tok.isNot(tok.TokenKind.r_square)) {
            CheckArrayDesignatorSyntax(/*Deref*/$this(), $this().Tok.getLocation(), Desig);
            return $this().ParseAssignmentExprWithObjCMessageExprStart(new SourceLocation(StartLoc), new SourceLocation(), new OpaquePtr<QualType>(null), Idx.get());
          }
          
          // If this is a normal array designator, remember it.
          if ($this().Tok.isNot(tok.TokenKind.ellipsis)) {
            Desig.AddDesignator(Designator.getArray(Idx.get(), new SourceLocation(StartLoc)));
          } else {
            // Handle the gnu array range extension.
            $c$.clean($c$.track($this().Diag($this().Tok, diag.ext_gnu_array_range)));
            SourceLocation EllipsisLoc = $this().ConsumeToken();
            
            ActionResultTTrue<Expr /*P*/ > RHS/*J*/= $this().ParseConstantExpression();
            if (RHS.isInvalid()) {
              $this().SkipUntil(tok.TokenKind.r_square, SkipUntilFlags.StopAtSemi);
              return RHS;
            }
            Desig.AddDesignator(Designator.getArrayRange(Idx.get(), 
                    RHS.get(), 
                    new SourceLocation(StartLoc), new SourceLocation(EllipsisLoc)));
          }
          
          T.consumeClose();
          Desig.getDesignator(Desig.getNumDesignators() - 1).setRBracketLoc(T.getCloseLocation());
        } finally {
          if (T != null) { T.$destroy(); }
          if (InMessage != null) { InMessage.$destroy(); }
        }
      }
      
      // Okay, we're done with the designator sequence.  We know that there must be
      // at least one designator, because the only case we can get into this method
      // without a designator is when we have an objc message send.  That case is
      // handled and returned from above.
      assert (!Desig.empty()) : "Designator is empty?";
      
      // Handle a normal designator sequence end, which is an equal.
      if ($this().Tok.is(tok.TokenKind.equal)) {
        SourceLocation EqualLoc = $this().ConsumeToken();
        return $this().Actions.ActOnDesignatedInitializer(Desig, new SourceLocation(EqualLoc), false, 
            $this().ParseInitializer());
      }
      
      // We read some number of designators and found something that isn't an = or
      // an initializer.  If we have exactly one array designator, this
      // is the GNU 'designation: array-designator' extension.  Otherwise, it is a
      // parse error.
      if (Desig.getNumDesignators() == 1
         && (Desig.getDesignator(0).isArrayDesignator()
         || Desig.getDesignator(0).isArrayRangeDesignator())) {
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track($this().Diag($this().Tok, diag.ext_gnu_missing_equal_designator)), 
            FixItHint.CreateInsertion($this().Tok.getLocation(), new StringRef(/*KEEP_STR*/"= "))));
        return $this().Actions.ActOnDesignatedInitializer(Desig, $this().Tok.getLocation(), 
            true, $this().ParseInitializer());
      }
      
      $c$.clean($c$.track($this().Diag($this().Tok, diag.err_expected_equal_designator)));
      return ExprError();
    } finally {
      if (Desig != null) { Desig.$destroy(); }
      $c$.$destroy();
    }
  }


// Return true if a comma (or closing brace) is necessary after the
// __if_exists/if_not_exists statement.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseMicrosoftIfExistsBraceInitializer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp", line = 479,
   FQN="clang::Parser::ParseMicrosoftIfExistsBraceInitializer", NM="_ZN5clang6Parser38ParseMicrosoftIfExistsBraceInitializerERN4llvm11SmallVectorIPNS_4ExprELj12EEERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang6Parser38ParseMicrosoftIfExistsBraceInitializerERN4llvm11SmallVectorIPNS_4ExprELj12EEERb")
  //</editor-fold>
  protected /*private*/ boolean ParseMicrosoftIfExistsBraceInitializer(final SmallVector<Expr /*P*/ > /*&*/ InitExprs, 
                                        final bool$ref/*bool &*/ InitExprsOk) {
    IfExistsCondition Result = null;
    BalancedDelimiterTracker Braces = null;
    try {
      boolean trailingComma = false;
      Result/*J*/= new IfExistsCondition();
      if ($this().ParseMicrosoftIfExistsCondition(Result)) {
        return false;
      }
      
      Braces/*J*/= new BalancedDelimiterTracker(/*Deref*/$this(), tok.TokenKind.l_brace);
      if (Braces.consumeOpen()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_TokenKind($c$.track($this().Diag($this().Tok, diag.err_expected)), tok.TokenKind.l_brace));
          return false;
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
        return false;
      }
      while (!$this().isEofOrEom()) {
        trailingComma = false;
        // If we know that this cannot be a designation, just parse the nested
        // initializer directly.
        ActionResultTTrue<Expr /*P*/ > SubElt/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if ($this().MayBeDesignationStart()) {
          SubElt.$assignMove($this().ParseInitializerWithPotentialDesignator());
        } else {
          SubElt.$assignMove($this().ParseInitializer());
        }
        if ($this().Tok.is(tok.TokenKind.ellipsis)) {
          SubElt.$assignMove($this().Actions.ActOnPackExpansion(SubElt.get(), $this().ConsumeToken()));
        }
        
        // If we couldn't parse the subelement, bail out.
        if (!SubElt.isInvalid()) {
          InitExprs.push_back(SubElt.get());
        } else {
          InitExprsOk.$set(false);
        }
        if ($this().Tok.is(tok.TokenKind.comma)) {
          $this().ConsumeToken();
          trailingComma = true;
        }
        if ($this().Tok.is(tok.TokenKind.r_brace)) {
          break;
        }
      }
      
      Braces.consumeClose();
      
      return !trailingComma;
    } finally {
      if (Braces != null) { Braces.$destroy(); }
      if (Result != null) { Result.$destroy(); }
    }
  }

} // END OF class Parser_ParseInit
