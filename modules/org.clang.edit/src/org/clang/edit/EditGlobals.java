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
package org.clang.edit;

import org.clang.ast.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.clang.basic.*;
import org.clang.edit.*;
import static org.clang.edit.impl.RewriteObjCFoundationAPIStatics.*;

//<editor-fold defaultstate="collapsed" desc="static type EditGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZN5clang4edit26rewriteToObjCLiteralSyntaxEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitEPKNS_9ParentMapE;_ZN5clang4edit28rewriteToObjCSubscriptSyntaxEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitE;_ZN5clang4edit35rewriteObjCRedundantCallWithLiteralEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitE; -static-type=EditGlobals -package=org.clang.edit")
//</editor-fold>
public final class EditGlobals {


//===----------------------------------------------------------------------===//
// rewriteObjCRedundantCallWithLiteral.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::edit::rewriteObjCRedundantCallWithLiteral">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 59,
 FQN="clang::edit::rewriteObjCRedundantCallWithLiteral", NM="_ZN5clang4edit35rewriteObjCRedundantCallWithLiteralEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZN5clang4edit35rewriteObjCRedundantCallWithLiteralEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitE")
//</editor-fold>
public static boolean rewriteObjCRedundantCallWithLiteral(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                                   /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  type$ref<IdentifierInfo> /*P*/ $II = create_type$ref(null);
  if (!checkForLiteralCreation(Msg, $II, NS.getASTContext().getLangOpts())) {
    return false;
  }
  IdentifierInfo /*P*/ II = $II.$deref();
  if (Msg.getNumArgs() != 1) {
    return false;
  }
  
  /*const*/ Expr /*P*/ Arg = Msg.getArg$Const(0).IgnoreParenImpCasts$Const();
  Selector Sel = Msg.getSelector();
  if ((isa(ObjCStringLiteral.class, Arg)
     && NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSString) == II
     && (NS.getNSStringSelector(NSAPI.NSStringMethodKind.NSStr_stringWithString).$eq(/*NO_COPY*/Sel)
     || NS.getNSStringSelector(NSAPI.NSStringMethodKind.NSStr_initWithString).$eq(/*NO_COPY*/Sel)))
     || (isa(ObjCArrayLiteral.class, Arg)
     && NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSArray) == II
     && (NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_arrayWithArray).$eq(/*NO_COPY*/Sel)
     || NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_initWithArray).$eq(/*NO_COPY*/Sel)))
     || (isa(ObjCDictionaryLiteral.class, Arg)
     && NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSDictionary) == II
     && (NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_dictionaryWithDictionary).$eq(/*NO_COPY*/Sel)
     || NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_initWithDictionary).$eq(/*NO_COPY*/Sel)))) {
    
    commit.replaceWithInner(Msg.getSourceRange(), 
        Msg.getArg$Const(0).getSourceRange());
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::edit::rewriteToObjCLiteralSyntax">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 339,
 FQN="clang::edit::rewriteToObjCLiteralSyntax", NM="_ZN5clang4edit26rewriteToObjCLiteralSyntaxEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitEPKNS_9ParentMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZN5clang4edit26rewriteToObjCLiteralSyntaxEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitEPKNS_9ParentMapE")
//</editor-fold>
public static boolean rewriteToObjCLiteralSyntax(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                          /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit, 
                          /*const*/ ParentMap /*P*/ PMap) {
  type$ref<IdentifierInfo> /*P*/ $II = create_type$ref(null);
  if (!checkForLiteralCreation(Msg, $II, NS.getASTContext().getLangOpts())) {
    return false;
  }
  IdentifierInfo /*P*/ II = $II.$deref();
  if (II == NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSArray)) {
    return rewriteToArrayLiteral(Msg, NS, commit, PMap);
  }
  if (II == NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSDictionary)) {
    return rewriteToDictionaryLiteral(Msg, NS, commit);
  }
  if (II == NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSNumber)) {
    return rewriteToNumberLiteral(Msg, NS, commit);
  }
  if (II == NS.getNSClassId(NSAPI.NSClassIdKindKind.ClassId_NSString)) {
    return rewriteToStringBoxedExpression(Msg, NS, commit);
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::edit::rewriteToObjCSubscriptSyntax">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp", line = 290,
 FQN="clang::edit::rewriteToObjCSubscriptSyntax", NM="_ZN5clang4edit28rewriteToObjCSubscriptSyntaxEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/RewriteObjCFoundationAPI.cpp -nm=_ZN5clang4edit28rewriteToObjCSubscriptSyntaxEPKNS_15ObjCMessageExprERKNS_5NSAPIERNS0_6CommitE")
//</editor-fold>
public static boolean rewriteToObjCSubscriptSyntax(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                            /*const*/ NSAPI /*&*/ NS, Commit /*&*/ commit) {
  if (!(Msg != null) || Msg.isImplicit()
     || Msg.getReceiverKind() != ObjCMessageExpr.ReceiverKind.Instance) {
    return false;
  }
  /*const*/ ObjCMethodDecl /*P*/ Method = Msg.getMethodDecl$Const();
  if (!(Method != null)) {
    return false;
  }
  
  /*const*/ ObjCInterfaceDecl /*P*/ IFace = NS.getASTContext().getObjContainingInterface(Method);
  if (!(IFace != null)) {
    return false;
  }
  Selector Sel = Msg.getSelector();
  if (Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSArr_objectAtIndex))) {
    return rewriteToArraySubscriptGet(IFace, Msg, NS, commit);
  }
  if (Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSDict_objectForKey))) {
    return rewriteToDictionarySubscriptGet(IFace, Msg, NS, commit);
  }
  if (Msg.getNumArgs() != 2) {
    return false;
  }
  if (Sel.$eq(NS.getNSArraySelector(NSAPI.NSArrayMethodKind.NSMutableArr_replaceObjectAtIndex))) {
    return rewriteToArraySubscriptSet(IFace, Msg, NS, commit);
  }
  if (Sel.$eq(NS.getNSDictionarySelector(NSAPI.NSDictionaryMethodKind.NSMutableDict_setObjectForKey))) {
    return rewriteToDictionarySubscriptSet(IFace, Msg, NS, commit);
  }
  
  return false;
}

} // END OF class EditGlobals
