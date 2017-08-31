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
package org.clang.edit.impl;

import org.clang.ast.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.edit.*;
import org.clang.lex.*;


//<editor-fold defaultstate="collapsed" desc="static type RewriteObjCFoundationAPIStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL13objectifyExprPKN5clang4ExprERNS_4edit6CommitE;_ZL14getLiteralInfoN5clang11SourceRangeEbbRNS_10ASTContextERN12_GLOBAL__N_111LiteralInfoE;_ZL14isEnumConstantPKN5clang4ExprE;_ZL17getNSArrayObjectsPKN5clang4ExprERKNS_5NSAPIERN4llvm15SmallVectorImplIS2_EE;_ZL20rewriteToBoolLiteralPKN5clang15ObjCMessageExprEPKNS_4ExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL20rewriteToCharLiteralPKN5clang15ObjCMessageExprEPKNS_16CharacterLiteralERKNS_5NSAPIERNS_4edit6CommitE;_ZL21rewriteToArrayLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitEPKNS_9ParentMapE;_ZL22rewriteToNumberLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL23castOperatorNeedsParensPKN5clang4ExprE;_ZL23checkForLiteralCreationPKN5clang15ObjCMessageExprERPNS_14IdentifierInfoERKNS_11LangOptionsE;_ZL24maybePutParensOnReceiverPKN5clang4ExprERNS_4edit6CommitE;_ZL26rewriteToArraySubscriptGetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL26rewriteToArraySubscriptSetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL26rewriteToDictionaryLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL27canRewriteToSubscriptSyntaxRPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERNS_10ASTContextENS_8SelectorE;_ZL27rewriteToSubscriptGetCommonPKN5clang15ObjCMessageExprERNS_4edit6CommitE;_ZL28subscriptOperatorNeedsParensPKN5clang4ExprE;_ZL30rewriteToStringBoxedExpressionPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL31rewriteToDictionarySubscriptGetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL31rewriteToDictionarySubscriptSetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL31rewriteToNumericBoxedExpressionPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE;_ZL36shouldNotRewriteImmediateMessageArgsPKN5clang15ObjCMessageExprERKNS_5NSAPIE;_ZL40maybeAdjustInterfaceForSubscriptingCheckPKN5clang17ObjCInterfaceDeclEPKNS_4ExprERNS_10ASTContextE;_ZL42doRewriteToUTF8StringBoxedExpressionHelperPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE; -static-type=RewriteObjCFoundationAPIStatics -package=org.clang.edit.impl")
//</editor-fold>
public final class RewriteObjCFoundationAPIStatics {

//<editor-fold defaultstate="collapsed" desc="checkForLiteralCreation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 26,
 FQN="checkForLiteralCreation", NM="_ZL23checkForLiteralCreationPKN5clang15ObjCMessageExprERPNS_14IdentifierInfoERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL23checkForLiteralCreationPKN5clang15ObjCMessageExprERPNS_14IdentifierInfoERKNS_11LangOptionsE")
//</editor-fold>
public static boolean checkForLiteralCreation(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                       type$ref<IdentifierInfo> ClassId, 
                       /*const*/ LangOptions /*&*/ LangOpts) {
  if (!(Msg != null) || Msg.isImplicit() || !(Msg.getMethodDecl$Const() != null)) {
    return false;
  }
  
  /*const*/ ObjCInterfaceDecl /*P*/ Receiver = Msg.getReceiverInterface();
  if (!(Receiver != null)) {
    return false;
  }
  ClassId.$set(Receiver.getIdentifier());
  if (Msg.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Class) {
    return true;
  }
  
  // When in ARC mode we also convert "[[.. alloc] init]" messages to literals,
  // since the change from +1 to +0 will be handled fine by ARC.
  if (LangOpts.ObjCAutoRefCount) {
    if (Msg.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Instance) {
      {
        /*const*/ ObjCMessageExpr /*P*/ Rec = dyn_cast(ObjCMessageExpr.class, Msg.getInstanceReceiver$Const().IgnoreParenImpCasts$Const());
        if ((Rec != null)) {
          if (Rec.getMethodFamily() == ObjCMethodFamily.OMF_alloc) {
            return true;
          }
        }
      }
    }
  }
  
  return false;
}


//===----------------------------------------------------------------------===//
// rewriteToObjCSubscriptSyntax.
//===----------------------------------------------------------------------===//

/// \brief Check for classes that accept 'objectForKey:' (or the other selectors
/// that the migrator handles) but return their instances as 'id', resulting
/// in the compiler resolving 'objectForKey:' as the method from NSDictionary.
///
/// When checking if we can convert to subscripting syntax, check whether
/// the receiver is a result of a class method from a hardcoded list of
/// such classes. In such a case return the specific class as the interface
/// of the receiver.
///
/// FIXME: Remove this when these classes start using 'instancetype'.
//<editor-fold defaultstate="collapsed" desc="maybeAdjustInterfaceForSubscriptingCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 108,
 FQN="maybeAdjustInterfaceForSubscriptingCheck", NM="_ZL40maybeAdjustInterfaceForSubscriptingCheckPKN5clang17ObjCInterfaceDeclEPKNS_4ExprERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL40maybeAdjustInterfaceForSubscriptingCheckPKN5clang17ObjCInterfaceDeclEPKNS_4ExprERNS_10ASTContextE")
//</editor-fold>
public static /*const*/ ObjCInterfaceDecl /*P*/ maybeAdjustInterfaceForSubscriptingCheck(/*const*/ ObjCInterfaceDecl /*P*/ IFace, 
                                        /*const*/ Expr /*P*/ Receiver, 
                                        ASTContext /*&*/ Ctx) {
  assert ((IFace != null) && (Receiver != null));
  
  // If the receiver has type 'id'...
  if (!Ctx.isObjCIdType(Receiver.getType().getUnqualifiedType())) {
    return IFace;
  }
  
  /*const*/ ObjCMessageExpr /*P*/ InnerMsg = dyn_cast(ObjCMessageExpr.class, Receiver.IgnoreParenCasts$Const());
  if (!(InnerMsg != null)) {
    return IFace;
  }
  
  QualType ClassRec/*J*/= new QualType();
  switch (InnerMsg.getReceiverKind()) {
   case Instance:
   case SuperInstance:
    return IFace;
   case Class:
    ClassRec.$assignMove(InnerMsg.getClassReceiver());
    break;
   case SuperClass:
    ClassRec.$assignMove(InnerMsg.getSuperType());
    break;
  }
  if (ClassRec.isNull()) {
    return IFace;
  }
  
  // ...and it is the result of a class message...
  /*const*/ ObjCObjectType /*P*/ ObjTy = ClassRec.$arrow().getAs(ObjCObjectType.class);
  if (!(ObjTy != null)) {
    return IFace;
  }
  /*const*/ ObjCInterfaceDecl /*P*/ OID = ObjTy.getInterface();
  
  // ...and the receiving class is NSMapTable or NSLocale, return that
  // class as the receiving interface.
  if ($eq_StringRef(OID.getName(), /*STRINGREF_STR*/"NSMapTable")
     || $eq_StringRef(OID.getName(), /*STRINGREF_STR*/"NSLocale")) {
    return OID;
  }
  
  return IFace;
}

//<editor-fold defaultstate="collapsed" desc="canRewriteToSubscriptSyntax">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 156,
 FQN="canRewriteToSubscriptSyntax", NM="_ZL27canRewriteToSubscriptSyntaxRPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERNS_10ASTContextENS_8SelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL27canRewriteToSubscriptSyntaxRPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERNS_10ASTContextENS_8SelectorE")
//</editor-fold>
public static boolean canRewriteToSubscriptSyntax(/*const*/ ObjCInterfaceDecl /*P*/ /*&*/ IFace, 
                           /*const*/ ObjCMessageExpr /*P*/ Msg, 
                           ASTContext /*&*/ Ctx, 
                           Selector subscriptSel) {
  /*const*/ Expr /*P*/ Rec = Msg.getInstanceReceiver$Const();
  if (!(Rec != null)) {
    return false;
  }
  IFace = maybeAdjustInterfaceForSubscriptingCheck(IFace, Rec, Ctx);
  {
    
    /*const*/ ObjCMethodDecl /*P*/ MD = IFace.lookupInstanceMethod(new Selector(subscriptSel));
    if ((MD != null)) {
      if (!MD.isUnavailable()) {
        return true;
      }
    }
  }
  return false;
}


// FIXME: Make determination of operator precedence more general and
// make it broadly available.
//<editor-fold defaultstate="collapsed" desc="subscriptOperatorNeedsParens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 889,
 FQN="subscriptOperatorNeedsParens", NM="_ZL28subscriptOperatorNeedsParensPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL28subscriptOperatorNeedsParensPKN5clang4ExprE")
//</editor-fold>
public static boolean subscriptOperatorNeedsParens(/*const*/ Expr /*P*/ FullExpr) {
  /*const*/ Expr /*P*/ Expr = FullExpr.IgnoreImpCasts$Const();
  if (isa(ArraySubscriptExpr.class, Expr)
     || isa(CallExpr.class, Expr)
     || isa(DeclRefExpr.class, Expr)
     || isa(CXXNamedCastExpr.class, Expr)
     || isa(CXXConstructExpr.class, Expr)
     || isa(CXXThisExpr.class, Expr)
     || isa(CXXTypeidExpr.class, Expr)
     || isa(CXXUnresolvedConstructExpr.class, Expr)
     || isa(ObjCMessageExpr.class, Expr)
     || isa(ObjCPropertyRefExpr.class, Expr)
     || isa(ObjCProtocolExpr.class, Expr)
     || isa(MemberExpr.class, Expr)
     || isa(ObjCIvarRefExpr.class, Expr)
     || isa(ParenExpr.class, FullExpr)
     || isa(ParenListExpr.class, Expr)
     || isa(SizeOfPackExpr.class, Expr)) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="maybePutParensOnReceiver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 174,
 FQN="maybePutParensOnReceiver", NM="_ZL24maybePutParensOnReceiverPKN5clang4ExprERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL24maybePutParensOnReceiverPKN5clang4ExprERNS_4edit6CommitE")
//</editor-fold>
public static void maybePutParensOnReceiver(/*const*/ Expr /*P*/ Receiver, Commit /*&*/ commit) {
  if (subscriptOperatorNeedsParens(Receiver)) {
    SourceRange RecRange = Receiver.getSourceRange();
    commit.insertWrap(new StringRef(/*KEEP_STR*/$LPAREN), new SourceRange(RecRange), new StringRef(/*KEEP_STR*/$RPAREN));
  }
}

//<editor-fold defaultstate="collapsed" desc="rewriteToSubscriptGetCommon">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 181,
 FQN="rewriteToSubscriptGetCommon", NM="_ZL27rewriteToSubscriptGetCommonPKN5clang15ObjCMessageExprERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL27rewriteToSubscriptGetCommonPKN5clang15ObjCMessageExprERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToSubscriptGetCommon(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                           Commit /*&*/ commit) {
  if (Msg.getNumArgs() != 1) {
    return false;
  }
  /*const*/ Expr /*P*/ Rec = Msg.getInstanceReceiver$Const();
  if (!(Rec != null)) {
    return false;
  }
  
  SourceRange MsgRange = Msg.getSourceRange();
  SourceRange RecRange = Rec.getSourceRange();
  SourceRange ArgRange = Msg.getArg$Const(0).getSourceRange();
  
  commit.replaceWithInner(CharSourceRange.getCharRange(MsgRange.getBegin(), 
          ArgRange.getBegin()), 
      CharSourceRange.getTokenRange(/*NO_COPY*/RecRange));
  commit.replaceWithInner(new SourceRange(ArgRange.getBegin(), MsgRange.getEnd()), 
      new SourceRange(ArgRange));
  commit.insertWrap(new StringRef(/*KEEP_STR*/$LSQUARE), new SourceRange(ArgRange), new StringRef(/*KEEP_STR*/$RSQUARE));
  maybePutParensOnReceiver(Rec, commit);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="rewriteToArraySubscriptGet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 203,
 FQN="rewriteToArraySubscriptGet", NM="_ZL26rewriteToArraySubscriptGetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL26rewriteToArraySubscriptGetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToArraySubscriptGet(/*const*/ ObjCInterfaceDecl /*P*/ IFace, 
                          /*const*/ ObjCMessageExpr /*P*/ Msg, 
                          /*const*/ NSAPI /*&*/ NS, 
                          Commit /*&*/ commit) {
  if (!canRewriteToSubscriptSyntax(IFace, Msg, NS.getASTContext(), 
      NS.getObjectAtIndexedSubscriptSelector())) {
    return false;
  }
  return rewriteToSubscriptGetCommon(Msg, commit);
}

//<editor-fold defaultstate="collapsed" desc="rewriteToDictionarySubscriptGet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 213,
 FQN="rewriteToDictionarySubscriptGet", NM="_ZL31rewriteToDictionarySubscriptGetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL31rewriteToDictionarySubscriptGetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToDictionarySubscriptGet(/*const*/ ObjCInterfaceDecl /*P*/ IFace, 
                               /*const*/ ObjCMessageExpr /*P*/ Msg, 
                               /*const*/ NSAPI /*&*/ NS, 
                               Commit /*&*/ commit) {
  if (!canRewriteToSubscriptSyntax(IFace, Msg, NS.getASTContext(), 
      NS.getObjectForKeyedSubscriptSelector())) {
    return false;
  }
  return rewriteToSubscriptGetCommon(Msg, commit);
}

//<editor-fold defaultstate="collapsed" desc="rewriteToArraySubscriptSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 223,
 FQN="rewriteToArraySubscriptSet", NM="_ZL26rewriteToArraySubscriptSetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL26rewriteToArraySubscriptSetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToArraySubscriptSet(/*const*/ ObjCInterfaceDecl /*P*/ IFace, 
                          /*const*/ ObjCMessageExpr /*P*/ Msg, 
                          /*const*/ NSAPI /*&*/ NS, 
                          Commit /*&*/ commit) {
  if (!canRewriteToSubscriptSyntax(IFace, Msg, NS.getASTContext(), 
      NS.getSetObjectAtIndexedSubscriptSelector())) {
    return false;
  }
  if (Msg.getNumArgs() != 2) {
    return false;
  }
  /*const*/ Expr /*P*/ Rec = Msg.getInstanceReceiver$Const();
  if (!(Rec != null)) {
    return false;
  }
  
  SourceRange MsgRange = Msg.getSourceRange();
  SourceRange RecRange = Rec.getSourceRange();
  SourceRange Arg0Range = Msg.getArg$Const(0).getSourceRange();
  SourceRange Arg1Range = Msg.getArg$Const(1).getSourceRange();
  
  commit.replaceWithInner(CharSourceRange.getCharRange(MsgRange.getBegin(), 
          Arg0Range.getBegin()), 
      CharSourceRange.getTokenRange(/*NO_COPY*/RecRange));
  commit.replaceWithInner(CharSourceRange.getCharRange(Arg0Range.getBegin(), 
          Arg1Range.getBegin()), 
      CharSourceRange.getTokenRange(/*NO_COPY*/Arg0Range));
  commit.replaceWithInner(new SourceRange(Arg1Range.getBegin(), MsgRange.getEnd()), 
      new SourceRange(Arg1Range));
  commit.insertWrap(new StringRef(/*KEEP_STR*/$LSQUARE), CharSourceRange.getCharRange(Arg0Range.getBegin(), 
          Arg1Range.getBegin()), 
      new StringRef(/*KEEP_STR*/"] = "));
  maybePutParensOnReceiver(Rec, commit);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="rewriteToDictionarySubscriptSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 257,
 FQN="rewriteToDictionarySubscriptSet", NM="_ZL31rewriteToDictionarySubscriptSetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL31rewriteToDictionarySubscriptSetPKN5clang17ObjCInterfaceDeclEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToDictionarySubscriptSet(/*const*/ ObjCInterfaceDecl /*P*/ IFace, 
                               /*const*/ ObjCMessageExpr /*P*/ Msg, 
                               /*const*/ NSAPI /*&*/ NS, 
                               Commit /*&*/ commit) {
  if (!canRewriteToSubscriptSyntax(IFace, Msg, NS.getASTContext(), 
      NS.getSetObjectForKeyedSubscriptSelector())) {
    return false;
  }
  if (Msg.getNumArgs() != 2) {
    return false;
  }
  /*const*/ Expr /*P*/ Rec = Msg.getInstanceReceiver$Const();
  if (!(Rec != null)) {
    return false;
  }
  
  SourceRange MsgRange = Msg.getSourceRange();
  SourceRange RecRange = Rec.getSourceRange();
  SourceRange Arg0Range = Msg.getArg$Const(0).getSourceRange();
  SourceRange Arg1Range = Msg.getArg$Const(1).getSourceRange();
  
  SourceLocation LocBeforeVal = Arg0Range.getBegin();
  commit.insertBefore(new SourceLocation(LocBeforeVal), new StringRef(/*KEEP_STR*/"] = "));
  commit.insertFromRange(new SourceLocation(LocBeforeVal), new SourceRange(Arg1Range), /*afterToken=*/ false, 
      /*beforePreviousInsertions=*/ true);
  commit.insertBefore(new SourceLocation(LocBeforeVal), new StringRef(/*KEEP_STR*/$LSQUARE));
  commit.replaceWithInner(CharSourceRange.getCharRange(MsgRange.getBegin(), 
          Arg0Range.getBegin()), 
      CharSourceRange.getTokenRange(/*NO_COPY*/RecRange));
  commit.replaceWithInner(new SourceRange(Arg0Range.getBegin(), MsgRange.getEnd()), 
      new SourceRange(Arg0Range));
  maybePutParensOnReceiver(Rec, commit);
  return true;
}


//===----------------------------------------------------------------------===//
// rewriteToObjCLiteralSyntax.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="rewriteToArrayLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 378,
 FQN="rewriteToArrayLiteral", NM="_ZL21rewriteToArrayLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitEPKNS_9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL21rewriteToArrayLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitEPKNS_9ParentMapE")
//</editor-fold>
public static boolean rewriteToArrayLiteral(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                     /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit, 
                     /*const*/ ParentMap /*P*/ PMap) {
  if ((PMap != null)) {
    /*const*/ ObjCMessageExpr /*P*/ ParentMsg = dyn_cast_or_null(ObjCMessageExpr.class, PMap.getParentIgnoreParenCasts_Stmt$C$P(Msg));
    if (shouldNotRewriteImmediateMessageArgs(ParentMsg, NS)) {
      return false;
    }
  }
  
  Selector Sel = Msg.getSelector();
  SourceRange MsgRange = Msg.getSourceRange();
  if (Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_array))) {
    if (Msg.getNumArgs() != 0) {
      return false;
    }
    commit.replace(new SourceRange(MsgRange), new StringRef(/*KEEP_STR*/"@[]"));
    return true;
  }
  if (Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_arrayWithObject))) {
    if (Msg.getNumArgs() != 1) {
      return false;
    }
    objectifyExpr(Msg.getArg$Const(0), commit);
    SourceRange ArgRange = Msg.getArg$Const(0).getSourceRange();
    commit.replaceWithInner(new SourceRange(MsgRange), new SourceRange(ArgRange));
    commit.insertWrap(new StringRef(/*KEEP_STR*/"@["), new SourceRange(ArgRange), new StringRef(/*KEEP_STR*/$RSQUARE));
    return true;
  }
  if (Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_arrayWithObjects))
     || Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_initWithObjects))) {
    if (Msg.getNumArgs() == 0) {
      return false;
    }
    /*const*/ Expr /*P*/ SentinelExpr = Msg.getArg$Const(Msg.getNumArgs() - 1);
    if (!NS.getASTContext().isSentinelNullExpr(SentinelExpr)) {
      return false;
    }
    
    for (/*uint*/int i = 0, e = Msg.getNumArgs() - 1; i != e; ++i)  {
      objectifyExpr(Msg.getArg$Const(i), commit);
    }
    if (Msg.getNumArgs() == 1) {
      commit.replace(new SourceRange(MsgRange), new StringRef(/*KEEP_STR*/"@[]"));
      return true;
    }
    SourceRange ArgRange/*J*/= new SourceRange(Msg.getArg$Const(0).getLocStart(), 
        Msg.getArg$Const(Msg.getNumArgs() - 2).getLocEnd());
    commit.replaceWithInner(new SourceRange(MsgRange), new SourceRange(ArgRange));
    commit.insertWrap(new StringRef(/*KEEP_STR*/"@["), new SourceRange(ArgRange), new StringRef(/*KEEP_STR*/$RSQUARE));
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="rewriteToDictionaryLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 490,
 FQN="rewriteToDictionaryLiteral", NM="_ZL26rewriteToDictionaryLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL26rewriteToDictionaryLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToDictionaryLiteral(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                          /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  Selector Sel = Msg.getSelector();
  SourceRange MsgRange = Msg.getSourceRange();
  if (Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_dictionary))) {
    if (Msg.getNumArgs() != 0) {
      return false;
    }
    commit.replace(new SourceRange(MsgRange), new StringRef(/*KEEP_STR*/"@{}"));
    return true;
  }
  if (Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_dictionaryWithObjectForKey))) {
    if (Msg.getNumArgs() != 2) {
      return false;
    }
    
    objectifyExpr(Msg.getArg$Const(0), commit);
    objectifyExpr(Msg.getArg$Const(1), commit);
    
    SourceRange ValRange = Msg.getArg$Const(0).getSourceRange();
    SourceRange KeyRange = Msg.getArg$Const(1).getSourceRange();
    // Insert key before the value.
    commit.insertBefore(ValRange.getBegin(), new StringRef(/*KEEP_STR*/": "));
    commit.insertFromRange(ValRange.getBegin(), 
        CharSourceRange.getTokenRange(/*NO_COPY*/KeyRange), 
        /*afterToken=*/ false, /*beforePreviousInsertions=*/ true);
    commit.insertBefore(ValRange.getBegin(), new StringRef(/*KEEP_STR*/"@{"));
    commit.insertAfterToken(ValRange.getEnd(), new StringRef(/*KEEP_STR*/$RCURLY));
    commit.replaceWithInner(new SourceRange(MsgRange), new SourceRange(ValRange));
    return true;
  }
  if (Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_dictionaryWithObjectsAndKeys))
     || Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_initWithObjectsAndKeys))) {
    if (Msg.getNumArgs() % 2 != 1) {
      return false;
    }
    /*uint*/int SentinelIdx = Msg.getNumArgs() - 1;
    /*const*/ Expr /*P*/ SentinelExpr = Msg.getArg$Const(SentinelIdx);
    if (!NS.getASTContext().isSentinelNullExpr(SentinelExpr)) {
      return false;
    }
    if (Msg.getNumArgs() == 1) {
      commit.replace(new SourceRange(MsgRange), new StringRef(/*KEEP_STR*/"@{}"));
      return true;
    }
    
    for (/*uint*/int i = 0; $less_uint(i, SentinelIdx); i += 2) {
      objectifyExpr(Msg.getArg$Const(i), commit);
      objectifyExpr(Msg.getArg$Const(i + 1), commit);
      
      SourceRange ValRange = Msg.getArg$Const(i).getSourceRange();
      SourceRange KeyRange = Msg.getArg$Const(i + 1).getSourceRange();
      // Insert value after key.
      commit.insertAfterToken(KeyRange.getEnd(), new StringRef(/*KEEP_STR*/": "));
      commit.insertFromRange(KeyRange.getEnd(), new SourceRange(ValRange), /*afterToken=*/ true);
      commit.remove(CharSourceRange.getCharRange(ValRange.getBegin(), 
              KeyRange.getBegin()));
    }
    // Range of arguments up until and including the last key.
    // The sentinel and first value are cut off, the value will move after the
    // key.
    SourceRange ArgRange/*J*/= new SourceRange(Msg.getArg$Const(1).getLocStart(), 
        Msg.getArg$Const(SentinelIdx - 1).getLocEnd());
    commit.insertWrap(new StringRef(/*KEEP_STR*/"@{"), new SourceRange(ArgRange), new StringRef(/*KEEP_STR*/$RCURLY));
    commit.replaceWithInner(new SourceRange(MsgRange), new SourceRange(ArgRange));
    return true;
  }
  if (Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_dictionaryWithObjectsForKeys))
     || Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_initWithObjectsForKeys))) {
    if (Msg.getNumArgs() != 2) {
      return false;
    }
    
    SmallVector</*const*/ Expr /*P*/ > Vals/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
    if (!getNSArrayObjects(Msg.getArg$Const(0), NS, Vals)) {
      return false;
    }
    
    SmallVector</*const*/ Expr /*P*/ > Keys/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
    if (!getNSArrayObjects(Msg.getArg$Const(1), NS, Keys)) {
      return false;
    }
    if (Vals.size() != Keys.size()) {
      return false;
    }
    if (Vals.empty()) {
      commit.replace(new SourceRange(MsgRange), new StringRef(/*KEEP_STR*/"@{}"));
      return true;
    }
    
    for (/*uint*/int i = 0, n = Vals.size(); $less_uint(i, n); ++i) {
      objectifyExpr(Vals.$at(i), commit);
      objectifyExpr(Keys.$at(i), commit);
      
      SourceRange ValRange = Vals.$at(i).getSourceRange();
      SourceRange KeyRange = Keys.$at(i).getSourceRange();
      // Insert value after key.
      commit.insertAfterToken(KeyRange.getEnd(), new StringRef(/*KEEP_STR*/": "));
      commit.insertFromRange(KeyRange.getEnd(), new SourceRange(ValRange), /*afterToken=*/ true);
    }
    // Range of arguments up until and including the last key.
    // The first value is cut off, the value will move after the key.
    SourceRange ArgRange/*J*/= new SourceRange(Keys.front().getLocStart(), 
        Keys.back().getLocEnd());
    commit.insertWrap(new StringRef(/*KEEP_STR*/"@{"), new SourceRange(ArgRange), new StringRef(/*KEEP_STR*/$RCURLY));
    commit.replaceWithInner(new SourceRange(MsgRange), new SourceRange(ArgRange));
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="rewriteToNumberLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 754,
 FQN="rewriteToNumberLiteral", NM="_ZL22rewriteToNumberLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL22rewriteToNumberLiteralPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToNumberLiteral(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                      /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  if (Msg.getNumArgs() != 1) {
    return false;
  }
  
  /*const*/ Expr /*P*/ Arg = Msg.getArg$Const(0).IgnoreParenImpCasts$Const();
  {
    /*const*/ CharacterLiteral /*P*/ CharE = dyn_cast(CharacterLiteral.class, Arg);
    if ((CharE != null)) {
      return rewriteToCharLiteral(Msg, CharE, NS, commit);
    }
  }
  {
    /*const*/ ObjCBoolLiteralExpr /*P*/ BE = dyn_cast(ObjCBoolLiteralExpr.class, Arg);
    if ((BE != null)) {
      return rewriteToBoolLiteral(Msg, BE, NS, commit);
    }
  }
  {
    /*const*/ CXXBoolLiteralExpr /*P*/ BE = dyn_cast(CXXBoolLiteralExpr.class, Arg);
    if ((BE != null)) {
      return rewriteToBoolLiteral(Msg, BE, NS, commit);
    }
  }
  
  /*const*/ Expr /*P*/ literalE = Arg;
  {
    /*const*/ UnaryOperator /*P*/ UOE = dyn_cast(UnaryOperator.class, literalE);
    if ((UOE != null)) {
      if (UOE.getOpcode() == UnaryOperatorKind.UO_Plus || UOE.getOpcode() == UnaryOperatorKind.UO_Minus) {
        literalE = UOE.getSubExpr();
      }
    }
  }
  
  // Only integer and floating literals, otherwise try to rewrite to boxed
  // expression.
  if (!isa(IntegerLiteral.class, literalE) && !isa(FloatingLiteral.class, literalE)) {
    return rewriteToNumericBoxedExpression(Msg, NS, commit);
  }
  
  ASTContext /*&*/ Ctx = NS.getASTContext();
  Selector Sel = Msg.getSelector();
  Optional<NSAPI.NSNumberLiteralMethodKind> MKOpt = NS.getNSNumberLiteralMethodKind(new Selector(Sel));
  if (!MKOpt.$bool()) {
    return false;
  }
  NSAPI.NSNumberLiteralMethodKind MK = MKOpt.$star();
  
  boolean CallIsUnsigned = false, CallIsLong = false, CallIsLongLong = false;
  boolean CallIsFloating = false, CallIsDouble = false;
  switch (MK) {
   case NSNumberWithChar:
   case NSNumberWithUnsignedChar:
   case NSNumberWithShort:
   case NSNumberWithUnsignedShort:
   case NSNumberWithBool:
    // We cannot have these calls with int/float literals.
    return rewriteToNumericBoxedExpression(Msg, NS, commit);
   case NSNumberWithUnsignedInt:
   case NSNumberWithUnsignedInteger:
    CallIsUnsigned = true;
   case NSNumberWithInt:
   case NSNumberWithInteger:
    break;
   case NSNumberWithUnsignedLong:
    CallIsUnsigned = true;
   case NSNumberWithLong:
    CallIsLong = true;
    break;
   case NSNumberWithUnsignedLongLong:
    CallIsUnsigned = true;
   case NSNumberWithLongLong:
    CallIsLongLong = true;
    break;
   case NSNumberWithDouble:
    CallIsDouble = true;
   case NSNumberWithFloat:
    CallIsFloating = true;
    break;
  }
  
  SourceRange ArgRange = Arg.getSourceRange();
  QualType ArgTy = Arg.getType();
  QualType CallTy = Msg.getArg$Const(0).getType();
  
  // Check for the easy case, the literal maps directly to the call.
  if (Ctx.hasSameType(new QualType(ArgTy), new QualType(CallTy))) {
    commit.replaceWithInner(Msg.getSourceRange(), new SourceRange(ArgRange));
    commit.insert(ArgRange.getBegin(), new StringRef(/*KEEP_STR*/$AT));
    return true;
  }
  
  // We will need to modify the literal suffix to get the same type as the call.
  // Try with boxed expression if it came from a macro.
  if (ArgRange.getBegin().isMacroID()) {
    return rewriteToNumericBoxedExpression(Msg, NS, commit);
  }
  
  boolean LitIsFloat = ArgTy.$arrow().isFloatingType();
  // For a float passed to integer call, don't try rewriting to objc literal.
  // It is difficult and a very uncommon case anyway.
  // But try with boxed expression.
  if (LitIsFloat && !CallIsFloating) {
    return rewriteToNumericBoxedExpression(Msg, NS, commit);
  }
  
  // Try to modify the literal make it the same type as the method call.
  // -Modify the suffix, and/or
  // -Change integer to float
  LiteralInfo LitInfo/*J*/= new LiteralInfo();
  boolean isIntZero = false;
  {
    /*const*/ IntegerLiteral /*P*/ IntE = dyn_cast(IntegerLiteral.class, literalE);
    if ((IntE != null)) {
      isIntZero = !IntE.getValue().getBoolValue();
    }
  }
  if (!getLiteralInfo(new SourceRange(ArgRange), LitIsFloat, isIntZero, Ctx, LitInfo)) {
    return rewriteToNumericBoxedExpression(Msg, NS, commit);
  }
  
  // Not easy to do int -> float with hex/octal and uncommon anyway.
  if (!LitIsFloat && CallIsFloating && (LitInfo.Hex || LitInfo.Octal)) {
    return rewriteToNumericBoxedExpression(Msg, NS, commit);
  }
  
  SourceLocation LitB = LitInfo.WithoutSuffRange.getBegin();
  SourceLocation LitE = LitInfo.WithoutSuffRange.getEnd();
  
  commit.replaceWithInner(CharSourceRange.getTokenRange(Msg.getSourceRange()), 
      new CharSourceRange(LitInfo.WithoutSuffRange));
  commit.insert(new SourceLocation(LitB), new StringRef(/*KEEP_STR*/$AT));
  if (!LitIsFloat && CallIsFloating) {
    commit.insert(new SourceLocation(LitE), new StringRef(/*KEEP_STR*/".0"));
  }
  if (CallIsFloating) {
    if (!CallIsDouble) {
      commit.insert(new SourceLocation(LitE), new StringRef(LitInfo.F));
    }
  } else {
    if (CallIsUnsigned) {
      commit.insert(new SourceLocation(LitE), new StringRef(LitInfo.U));
    }
    if (CallIsLong) {
      commit.insert(new SourceLocation(LitE), new StringRef(LitInfo.L));
    } else if (CallIsLongLong) {
      commit.insert(new SourceLocation(LitE), new StringRef(LitInfo.LL));
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="rewriteToNumericBoxedExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 973,
 FQN="rewriteToNumericBoxedExpression", NM="_ZL31rewriteToNumericBoxedExpressionPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL31rewriteToNumericBoxedExpressionPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToNumericBoxedExpression(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                               /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  if (Msg.getNumArgs() != 1) {
    return false;
  }
  
  /*const*/ Expr /*P*/ Arg = Msg.getArg$Const(0);
  if (Arg.isTypeDependent()) {
    return false;
  }
  
  ASTContext /*&*/ Ctx = NS.getASTContext();
  Selector Sel = Msg.getSelector();
  Optional<NSAPI.NSNumberLiteralMethodKind> MKOpt = NS.getNSNumberLiteralMethodKind(new Selector(Sel));
  if (!MKOpt.$bool()) {
    return false;
  }
  NSAPI.NSNumberLiteralMethodKind MK = MKOpt.$star();
  
  /*const*/ Expr /*P*/ OrigArg = Arg.IgnoreImpCasts$Const();
  QualType FinalTy = Arg.getType();
  QualType OrigTy = OrigArg.getType();
  long/*uint64_t*/ FinalTySize = Ctx.getTypeSize(new QualType(FinalTy));
  long/*uint64_t*/ OrigTySize = Ctx.getTypeSize(new QualType(OrigTy));
  
  boolean isTruncated = $less_ulong(FinalTySize, OrigTySize);
  boolean needsCast = false;
  {
    
    /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast(ImplicitCastExpr.class, Arg);
    if ((ICE != null)) {
      switch (ICE.getCastKind()) {
       case CK_LValueToRValue:
       case CK_NoOp:
       case CK_UserDefinedConversion:
        break;
       case CK_IntegralCast:
        {
          if (MK == NSAPI.NSNumberLiteralMethodKind.NSNumberWithBool && OrigTy.$arrow().isBooleanType()) {
            break;
          }
          // Be more liberal with Integer/UnsignedInteger which are very commonly
          // used.
          if ((MK == NSAPI.NSNumberLiteralMethodKind.NSNumberWithInteger
             || MK == NSAPI.NSNumberLiteralMethodKind.NSNumberWithUnsignedInteger)
             && !isTruncated) {
            if ((OrigTy.$arrow().<EnumType>getAs$EnumType() != null) || isEnumConstant(OrigArg)) {
              break;
            }
            if ((MK == NSAPI.NSNumberLiteralMethodKind.NSNumberWithInteger) == OrigTy.$arrow().isSignedIntegerType()
               && $greatereq_ulong(OrigTySize, Ctx.getTypeSize(Ctx.IntTy.$QualType()))) {
              break;
            }
          }
          
          needsCast = true;
          break;
        }
       case CK_PointerToBoolean:
       case CK_IntegralToBoolean:
       case CK_IntegralToFloating:
       case CK_FloatingToIntegral:
       case CK_FloatingToBoolean:
       case CK_FloatingCast:
       case CK_FloatingComplexToReal:
       case CK_FloatingComplexToBoolean:
       case CK_IntegralComplexToReal:
       case CK_IntegralComplexToBoolean:
       case CK_AtomicToNonAtomic:
       case CK_AddressSpaceConversion:
        needsCast = true;
        break;
       case CK_Dependent:
       case CK_BitCast:
       case CK_LValueBitCast:
       case CK_BaseToDerived:
       case CK_DerivedToBase:
       case CK_UncheckedDerivedToBase:
       case CK_Dynamic:
       case CK_ToUnion:
       case CK_ArrayToPointerDecay:
       case CK_FunctionToPointerDecay:
       case CK_NullToPointer:
       case CK_NullToMemberPointer:
       case CK_BaseToDerivedMemberPointer:
       case CK_DerivedToBaseMemberPointer:
       case CK_MemberPointerToBoolean:
       case CK_ReinterpretMemberPointer:
       case CK_ConstructorConversion:
       case CK_IntegralToPointer:
       case CK_PointerToIntegral:
       case CK_ToVoid:
       case CK_VectorSplat:
       case CK_CPointerToObjCPointerCast:
       case CK_BlockPointerToObjCPointerCast:
       case CK_AnyPointerToBlockPointerCast:
       case CK_ObjCObjectLValueCast:
       case CK_FloatingRealToComplex:
       case CK_FloatingComplexCast:
       case CK_FloatingComplexToIntegralComplex:
       case CK_IntegralRealToComplex:
       case CK_IntegralComplexCast:
       case CK_IntegralComplexToFloatingComplex:
       case CK_ARCProduceObject:
       case CK_ARCConsumeObject:
       case CK_ARCReclaimReturnedObject:
       case CK_ARCExtendBlockObject:
       case CK_NonAtomicToAtomic:
       case CK_CopyAndAutoreleaseBlockObject:
       case CK_BuiltinFnToFnPtr:
       case CK_ZeroToOCLEvent:
        return false;
       case CK_BooleanToSignedIntegral:
        throw new llvm_unreachable("OpenCL-specific cast in Objective-C?");
      }
    }
  }
  if (needsCast) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DiagnosticsEngine /*&*/ Diags = Ctx.getDiagnostics();
      // FIXME: Use a custom category name to distinguish migration diagnostics.
      /*uint*/int diagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Warning, 
          /*KEEP_STR*/"converting to boxing syntax requires casting %0 to %1");
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($c$.track(Diags.Report(Msg.getExprLoc(), diagID)), /*NO_COPY*/OrigTy), /*NO_COPY*/FinalTy), 
          Msg.getSourceRange()));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  SourceRange ArgRange = OrigArg.getSourceRange();
  commit.replaceWithInner(Msg.getSourceRange(), new SourceRange(ArgRange));
  if (isa(ParenExpr.class, OrigArg) || isa(IntegerLiteral.class, OrigArg)) {
    commit.insertBefore(ArgRange.getBegin(), new StringRef(/*KEEP_STR*/$AT));
  } else {
    commit.insertWrap(new StringRef(/*KEEP_STR*/"@("), new SourceRange(ArgRange), new StringRef(/*KEEP_STR*/$RPAREN));
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="rewriteToStringBoxedExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 1150,
 FQN="rewriteToStringBoxedExpression", NM="_ZL30rewriteToStringBoxedExpressionPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL30rewriteToStringBoxedExpressionPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToStringBoxedExpression(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                              /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  Selector Sel = Msg.getSelector();
  if (Sel.$eq(NS.getNSStringSelector(NSAPI.NSStringMethodKind.NSStr_stringWithUTF8String))
     || Sel.$eq(NS.getNSStringSelector(NSAPI.NSStringMethodKind.NSStr_stringWithCString))
     || Sel.$eq(NS.getNSStringSelector(NSAPI.NSStringMethodKind.NSStr_initWithUTF8String))) {
    if (Msg.getNumArgs() != 1) {
      return false;
    }
    return doRewriteToUTF8StringBoxedExpressionHelper(Msg, NS, commit);
  }
  if (Sel.$eq(NS.getNSStringSelector(NSAPI.NSStringMethodKind.NSStr_stringWithCStringEncoding))) {
    if (Msg.getNumArgs() != 2) {
      return false;
    }
    
    /*const*/ Expr /*P*/ encodingArg = Msg.getArg$Const(1);
    if (NS.isNSUTF8StringEncodingConstant(encodingArg)
       || NS.isNSASCIIStringEncodingConstant(encodingArg)) {
      return doRewriteToUTF8StringBoxedExpressionHelper(Msg, NS, commit);
    }
  }
  
  return false;
}


/// \brief Returns true if the immediate message arguments of \c Msg should not
/// be rewritten because it will interfere with the rewrite of the parent
/// message expression. e.g.
/// \code
///   [NSDictionary dictionaryWithObjects:
///                                 [NSArray arrayWithObjects:@"1", @"2", nil]
///                         forKeys:[NSArray arrayWithObjects:@"A", @"B", nil]];
/// \endcode
/// It will return true for this because we are going to rewrite this directly
/// to a dictionary literal without any array literals.
//<editor-fold defaultstate="collapsed" desc="shouldNotRewriteImmediateMessageArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 604,
 FQN="shouldNotRewriteImmediateMessageArgs", NM="_ZL36shouldNotRewriteImmediateMessageArgsPKN5clang15ObjCMessageExprERKNS_5NSAPIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL36shouldNotRewriteImmediateMessageArgsPKN5clang15ObjCMessageExprERKNS_5NSAPIE")
//</editor-fold>
public static boolean shouldNotRewriteImmediateMessageArgs(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                                    /*const*/ NSAPI /*&*/ NS) {
  if (!(Msg != null)) {
    return false;
  }
  
  type$ref<IdentifierInfo> /*P*/ $II = create_type$ref(null);
  if (!checkForLiteralCreation(Msg, $II, NS.getASTContext().getLangOpts())) {
    return false;
  }
  IdentifierInfo /*P*/ II = $II.$deref();
  if (II != NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSDictionary)) {
    return false;
  }
  
  Selector Sel = Msg.getSelector();
  if (Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_dictionaryWithObjectsForKeys))
     || Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_initWithObjectsForKeys))) {
    if (Msg.getNumArgs() != 2) {
      return false;
    }
    
    SmallVector</*const*/ Expr /*P*/ > Vals/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
    if (!getNSArrayObjects(Msg.getArg$Const(0), NS, Vals)) {
      return false;
    }
    
    SmallVector</*const*/ Expr /*P*/ > Keys/*J*/= new SmallVector</*const*/ Expr /*P*/ >(8, (/*const*/ Expr /*P*/ )null);
    if (!getNSArrayObjects(Msg.getArg$Const(1), NS, Keys)) {
      return false;
    }
    if (Vals.size() != Keys.size()) {
      return false;
    }
    
    return true;
  }
  
  return false;
}


//===----------------------------------------------------------------------===//
// rewriteToArrayLiteral.
//===----------------------------------------------------------------------===//

/// \brief Adds an explicit cast to 'id' if the type is not objc object.
//<editor-fold defaultstate="collapsed" desc="objectifyExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 940,
 FQN="objectifyExpr", NM="_ZL13objectifyExprPKN5clang4ExprERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL13objectifyExprPKN5clang4ExprERNS_4edit6CommitE")
//</editor-fold>
public static void objectifyExpr(/*const*/ Expr /*P*/ E, Commit /*&*/ commit) {
  if (!(E != null)) {
    return;
  }
  
  QualType T = E.getType();
  if (T.$arrow().isObjCObjectPointerType()) {
    {
      /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast(ImplicitCastExpr.class, E);
      if ((ICE != null)) {
        if (ICE.getCastKind() != CastKind.CK_CPointerToObjCPointerCast) {
          return;
        }
      } else {
        return;
      }
    }
  } else if (!T.$arrow().isPointerType()) {
    return;
  }
  
  SourceRange Range = E.getSourceRange();
  if (castOperatorNeedsParens(E)) {
    commit.insertWrap(new StringRef(/*KEEP_STR*/$LPAREN), new SourceRange(Range), new StringRef(/*KEEP_STR*/$RPAREN));
  }
  commit.insertBefore(Range.getBegin(), new StringRef(/*KEEP_STR*/"(id)"));
}


//===----------------------------------------------------------------------===//
// rewriteToDictionaryLiteral.
//===----------------------------------------------------------------------===//

/// \brief If \c Msg is an NSArray creation message or literal, this gets the
/// objects that were used to create it.
/// \returns true if it is an NSArray and we got objects, or false otherwise.
//<editor-fold defaultstate="collapsed" desc="getNSArrayObjects">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 440,
 FQN="getNSArrayObjects", NM="_ZL17getNSArrayObjectsPKN5clang4ExprERKNS_5NSAPIERN4llvm15SmallVectorImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL17getNSArrayObjectsPKN5clang4ExprERKNS_5NSAPIERN4llvm15SmallVectorImplIS2_EE")
//</editor-fold>
public static boolean getNSArrayObjects(/*const*/ Expr /*P*/ E, /*const*/ NSAPI /*&*/ NS, 
                 SmallVectorImpl</*const*/ Expr /*P*/ > /*&*/ Objs) {
  if (!(E != null)) {
    return false;
  }
  
  E = E.IgnoreParenCasts$Const();
  if (!(E != null)) {
    return false;
  }
  {
    
    /*const*/ ObjCMessageExpr /*P*/ Msg = dyn_cast(ObjCMessageExpr.class, E);
    if ((Msg != null)) {
      type$ref<IdentifierInfo> /*P*/ $Cls = create_type$ref(null);
      if (!checkForLiteralCreation(Msg, $Cls, NS.getASTContext().getLangOpts())) {
        return false;
      }
      IdentifierInfo /*P*/ Cls = $Cls.$deref();
      if (Cls != NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSArray)) {
        return false;
      }
      
      Selector Sel = Msg.getSelector();
      if (Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_array))) {
        return true; // empty array.
      }
      if (Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_arrayWithObject))) {
        if (Msg.getNumArgs() != 1) {
          return false;
        }
        Objs.push_back(Msg.getArg$Const(0));
        return true;
      }
      if (Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_arrayWithObjects))
         || Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_initWithObjects))) {
        if (Msg.getNumArgs() == 0) {
          return false;
        }
        /*const*/ Expr /*P*/ SentinelExpr = Msg.getArg$Const(Msg.getNumArgs() - 1);
        if (!NS.getASTContext().isSentinelNullExpr(SentinelExpr)) {
          return false;
        }
        
        for (/*uint*/int i = 0, e = Msg.getNumArgs() - 1; i != e; ++i)  {
          Objs.push_back(Msg.getArg$Const(i));
        }
        return true;
      }
    } else {
      /*const*/ ObjCArrayLiteral /*P*/ ArrLit = dyn_cast(ObjCArrayLiteral.class, E);
      if ((ArrLit != null)) {
        for (/*uint*/int i = 0, e = ArrLit.getNumElements(); i != e; ++i)  {
          Objs.push_back(ArrLit.getElement$Const(i));
        }
        return true;
      }
    }
  }
  
  return false;
}


//===----------------------------------------------------------------------===//
// rewriteToNumberLiteral.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="rewriteToCharLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 644,
 FQN="rewriteToCharLiteral", NM="_ZL20rewriteToCharLiteralPKN5clang15ObjCMessageExprEPKNS_16CharacterLiteralERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL20rewriteToCharLiteralPKN5clang15ObjCMessageExprEPKNS_16CharacterLiteralERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToCharLiteral(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                    /*const*/ CharacterLiteral /*P*/ Arg, 
                    /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  if (Arg.getKind() != CharacterLiteral.CharacterKind.Ascii) {
    return false;
  }
  if (NS.isNSNumberLiteralSelector(NSAPI.NSNumberLiteralMethodKind.NSNumberWithChar, 
      Msg.getSelector())) {
    SourceRange ArgRange = Arg.getSourceRange();
    commit.replaceWithInner(Msg.getSourceRange(), new SourceRange(ArgRange));
    commit.insert(ArgRange.getBegin(), new StringRef(/*KEEP_STR*/$AT));
    return true;
  }
  
  return rewriteToNumericBoxedExpression(Msg, NS, commit);
}

//<editor-fold defaultstate="collapsed" desc="rewriteToBoolLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 660,
 FQN="rewriteToBoolLiteral", NM="_ZL20rewriteToBoolLiteralPKN5clang15ObjCMessageExprEPKNS_4ExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL20rewriteToBoolLiteralPKN5clang15ObjCMessageExprEPKNS_4ExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean rewriteToBoolLiteral(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                    /*const*/ Expr /*P*/ Arg, 
                    /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  if (NS.isNSNumberLiteralSelector(NSAPI.NSNumberLiteralMethodKind.NSNumberWithBool, 
      Msg.getSelector())) {
    SourceRange ArgRange = Arg.getSourceRange();
    commit.replaceWithInner(Msg.getSourceRange(), new SourceRange(ArgRange));
    commit.insert(ArgRange.getBegin(), new StringRef(/*KEEP_STR*/$AT));
    return true;
  }
  
  return rewriteToNumericBoxedExpression(Msg, NS, commit);
}

  //<editor-fold defaultstate="collapsed" desc="Suff">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*extracted from method*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 699,
   FQN="Suff", NM="_ZZL14getLiteralInfoN5clang11SourceRangeEbbRNS_10ASTContextERN12_GLOBAL__N_111LiteralInfoEE4Suff",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZZL14getLiteralInfoN5clang11SourceRangeEbbRNS_10ASTContextERN12_GLOBAL__N_111LiteralInfoEE4Suff")
  //</editor-fold>
  private static final class/*struct*/ Suff {
    //<editor-fold defaultstate="collapsed" desc="getLiteralInfo(SourceRange, bool, bool, ASTContext & , LiteralInfo & )::Suff::has">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 700,
     FQN="getLiteralInfo(SourceRange, bool, bool, ASTContext & , LiteralInfo & )::Suff::has", NM="_ZZL14getLiteralInfoN5clang11SourceRangeEbbRNS_10ASTContextERN12_GLOBAL__N_111LiteralInfoEEN4Suff3hasEN4llvm9StringRefERS8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZZL14getLiteralInfoN5clang11SourceRangeEbbRNS_10ASTContextERN12_GLOBAL__N_111LiteralInfoEEN4Suff3hasEN4llvm9StringRefERS8_")
    //</editor-fold>
    public static boolean has(StringRef suff, StringRef /*&*/ text) {
      if (text.endswith(/*NO_COPY*/suff)) {
        text.$assignMove(text.substr(0, text.size() - suff.size()));
        return true;
      }
      return false;
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
//<editor-fold defaultstate="collapsed" desc="getLiteralInfo">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 684,
 FQN="getLiteralInfo", NM="_ZL14getLiteralInfoN5clang11SourceRangeEbbRNS_10ASTContextERN12_GLOBAL__N_111LiteralInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL14getLiteralInfoN5clang11SourceRangeEbbRNS_10ASTContextERN12_GLOBAL__N_111LiteralInfoE")
//</editor-fold>
public static boolean getLiteralInfo(SourceRange literalRange, 
              boolean isFloat, boolean isIntZero, 
              ASTContext /*&*/ Ctx, LiteralInfo /*&*/ Info) {
  if (literalRange.getBegin().isMacroID()
     || literalRange.getEnd().isMacroID()) {
    return false;
  }
  StringRef text = Lexer.getSourceText(CharSourceRange.getTokenRange(/*NO_COPY*/literalRange), 
      Ctx.getSourceManager(), Ctx.getLangOpts());
  if (text.empty()) {
    return false;
  }
  
  OptionalBool UpperU/*J*/= new OptionalBool(), UpperL/*J*/= new OptionalBool();
  boolean UpperF = false;
  
  while (true) {
    if (Suff.has(new StringRef(/*KEEP_STR*/$u), text)) {
      UpperU.$assign_T$RR(/*KEEP_BOOL*/false);
    } else if (Suff.has(new StringRef(/*KEEP_STR*/$U), text)) {
      UpperU.$assign_T$RR(/*KEEP_BOOL*/true);
    } else if (Suff.has(new StringRef(/*KEEP_STR*/$ll), text)) {
      UpperL.$assign_T$RR(/*KEEP_BOOL*/false);
    } else if (Suff.has(new StringRef(/*KEEP_STR*/$LL), text)) {
      UpperL.$assign_T$RR(/*KEEP_BOOL*/true);
    } else if (Suff.has(new StringRef(/*KEEP_STR*/$l), text)) {
      UpperL.$assign_T$RR(/*KEEP_BOOL*/false);
    } else if (Suff.has(new StringRef(/*KEEP_STR*/$L), text)) {
      UpperL.$assign_T$RR(/*KEEP_BOOL*/true);
    } else if (isFloat && Suff.has(new StringRef(/*KEEP_STR*/$f), text)) {
      UpperF = false;
    } else if (isFloat && Suff.has(new StringRef(/*KEEP_STR*/$F), text)) {
      UpperF = true;
    } else {
      break;
    }
  }
  if (!UpperU.hasValue() && !UpperL.hasValue()) {
    UpperU.$assign(UpperL.$assign_T$RR(/*KEEP_BOOL*/true));
  } else if (UpperU.hasValue() && !UpperL.hasValue()) {
    UpperL.$assign(UpperU);
  } else if (UpperL.hasValue() && !UpperU.hasValue()) {
    UpperU.$assign(UpperL);
  }
  
  Info.U.$assignMove(/*STRINGREF_STR*/UpperU.$star() ? $U : $u);
  Info.L.$assignMove(/*STRINGREF_STR*/UpperL.$star() ? $L : $l);
  Info.LL.$assignMove(/*STRINGREF_STR*/UpperL.$star() ? $LL : $ll);
  Info.F.$assignMove(/*STRINGREF_STR*/UpperF ? $F : $f);
  
  Info.Hex = Info.Octal = false;
  if (text.startswith(/*STRINGREF_STR*/"0x")) {
    Info.Hex = true;
  } else if (!isFloat && !isIntZero && text.startswith(/*STRINGREF_STR*/"0")) {
    Info.Octal = true;
  }
  
  SourceLocation B = literalRange.getBegin();
  Info.WithoutSuffRange.$assignMove(
      CharSourceRange.getCharRange(/*NO_COPY*/B, B.getLocWithOffset(text.size()))
  );
  return true;
}

//<editor-fold defaultstate="collapsed" desc="castOperatorNeedsParens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 911,
 FQN="castOperatorNeedsParens", NM="_ZL23castOperatorNeedsParensPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL23castOperatorNeedsParensPKN5clang4ExprE")
//</editor-fold>
public static boolean castOperatorNeedsParens(/*const*/ Expr /*P*/ FullExpr) {
  /*const*/ Expr /*P*/ Expr = FullExpr.IgnoreImpCasts$Const();
  if (isa(ArraySubscriptExpr.class, Expr)
     || isa(CallExpr.class, Expr)
     || isa(DeclRefExpr.class, Expr)
     || isa(CastExpr.class, Expr)
     || isa(CXXNewExpr.class, Expr)
     || isa(CXXConstructExpr.class, Expr)
     || isa(CXXDeleteExpr.class, Expr)
     || isa(CXXNoexceptExpr.class, Expr)
     || isa(CXXPseudoDestructorExpr.class, Expr)
     || isa(CXXScalarValueInitExpr.class, Expr)
     || isa(CXXThisExpr.class, Expr)
     || isa(CXXTypeidExpr.class, Expr)
     || isa(CXXUnresolvedConstructExpr.class, Expr)
     || isa(ObjCMessageExpr.class, Expr)
     || isa(ObjCPropertyRefExpr.class, Expr)
     || isa(ObjCProtocolExpr.class, Expr)
     || isa(MemberExpr.class, Expr)
     || isa(ObjCIvarRefExpr.class, Expr)
     || isa(ParenExpr.class, FullExpr)
     || isa(ParenListExpr.class, Expr)
     || isa(SizeOfPackExpr.class, Expr)
     || isa(UnaryOperator.class, Expr)) {
    return false;
  }
  
  return true;
}


//===----------------------------------------------------------------------===//
// rewriteToNumericBoxedExpression.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="isEnumConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 965,
 FQN="isEnumConstant", NM="_ZL14isEnumConstantPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL14isEnumConstantPKN5clang4ExprE")
//</editor-fold>
public static boolean isEnumConstant(/*const*/ Expr /*P*/ E) {
  {
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast(DeclRefExpr.class, E.IgnoreParenImpCasts$Const());
    if ((DRE != null)) {
      {
        /*const*/ ValueDecl /*P*/ VD = DRE.getDecl$Const();
        if ((VD != null)) {
          return isa(EnumConstantDecl.class, VD);
        }
      }
    }
  }
  
  return false;
}


//===----------------------------------------------------------------------===//
// rewriteToStringBoxedExpression.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="doRewriteToUTF8StringBoxedExpressionHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 1111,
 FQN="doRewriteToUTF8StringBoxedExpressionHelper", NM="_ZL42doRewriteToUTF8StringBoxedExpressionHelperPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZL42doRewriteToUTF8StringBoxedExpressionHelperPKN5clang15ObjCMessageExprERKNS_5NSAPIERNS_4edit6CommitE")
//</editor-fold>
public static boolean doRewriteToUTF8StringBoxedExpressionHelper(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                                          /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  /*const*/ Expr /*P*/ Arg = Msg.getArg$Const(0);
  if (Arg.isTypeDependent()) {
    return false;
  }
  
  ASTContext /*&*/ Ctx = NS.getASTContext();
  
  /*const*/ Expr /*P*/ OrigArg = Arg.IgnoreImpCasts$Const();
  QualType OrigTy = OrigArg.getType();
  if (OrigTy.$arrow().isArrayType()) {
    OrigTy.$assignMove(Ctx.getArrayDecayedType(new QualType(OrigTy)));
  }
  {
    
    /*const*/ StringLiteral /*P*/ StrE = dyn_cast(StringLiteral.class, OrigArg.IgnoreParens$Const());
    if ((StrE != null)) {
      commit.replaceWithInner(Msg.getSourceRange(), StrE.getSourceRange());
      commit.insert(StrE.getLocStart(), new StringRef(/*KEEP_STR*/$AT));
      return true;
    }
  }
  {
    
    /*const*/ PointerType /*P*/ PT = OrigTy.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      QualType PointeeType = PT.getPointeeType();
      if (Ctx.hasSameUnqualifiedType(new QualType(PointeeType), Ctx.CharTy.$QualType())) {
        SourceRange ArgRange = OrigArg.getSourceRange();
        commit.replaceWithInner(Msg.getSourceRange(), new SourceRange(ArgRange));
        if (isa(ParenExpr.class, OrigArg) || isa(IntegerLiteral.class, OrigArg)) {
          commit.insertBefore(ArgRange.getBegin(), new StringRef(/*KEEP_STR*/$AT));
        } else {
          commit.insertWrap(new StringRef(/*KEEP_STR*/"@("), new SourceRange(ArgRange), new StringRef(/*KEEP_STR*/$RPAREN));
        }
        
        return true;
      }
    }
  }
  
  return false;
}

} // END OF class RewriteObjCFoundationAPIStatics
