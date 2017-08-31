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


package org.clang.sema.java;

import org.clang.ast.Decl;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.basic.target.TargetInfo;
import org.clang.edit.Commit;
import org.clang.sema.Sema_NestedEnums.CUDAFunctionPreference;
import org.clang.sema.impl.SimplePointerKind;

/**
 *
 * @author vkvashin
 */
public class SemaFunctionPointers {

  public static @FunctionalInterface
  interface SemaAttributeListDecl2Bool {
    boolean $call(Sema /*&*/ sema, /*const*/ AttributeList /*&*/ attributeList, /*const*/ Decl decl);
  }

  public static @FunctionalInterface
  interface SemaAttributeList2Bool {
    boolean $call(Sema /*&*/ sema, /*const*/ AttributeList /*&*/ attributeList);
  }

  public static @FunctionalInterface
  interface TargetInfo2Bool {
    boolean $call(TargetInfo targetInfo);
  }

  public static @FunctionalInterface
  interface AttributeList2Int {
    int $call(AttributeList attributeList);
  }

  // from Sema class
  //  public final class LateTemplateParserCB extends void (Object/*void P*/ , LateParsedTemplate /*&*/ ){ };
  public @FunctionalInterface interface LateTemplateParserCB {
    public void $call(Object/*void P*/ Obj, LateParsedTemplate /*&*/ LPT);
  }

  // from Sema class
  //  public final class LateTemplateParserCleanupCB extends void (Object/*void P*/ ){ };
  public @FunctionalInterface interface LateTemplateParserCleanupCB {
    public void $call(Object/*void P*/ Obj);
  }

  // from ConversionFixItGenerator class
  public @FunctionalInterface interface TypeComparisonFuncTy {
    public boolean $call(CanQual<Type> FromTy, /*const*/ CanQual<Type> ToTy, Sema /*&*/ S, SourceLocation Loc, ExprValueKind FromVK);
  }

  // from Sema  (Sema::CorrectDelayedTyposInExpr)
  public @FunctionalInterface interface QualType2Bool {
    public boolean $call(QualType qualType);
  }

  // from Sema
  public @FunctionalInterface interface TypoRecoveryCallback {
    public ActionResultTTrue<Expr> $call(final Sema/*&*/ S, TypoExpr TE, TypoCorrection TC);
  }

  // from Sema
  public @FunctionalInterface interface TypoDiagnosticGenerator {
    public void $call(TypoCorrection TC);
  }

  // from Sema
  public @FunctionalInterface interface Expr2ExprResult {
    public ActionResultTTrue<Expr> $call(Expr E);
  }
  
  public @FunctionalInterface interface TPToFunctionDecl<T> {
    public FunctionDecl $call(T t);
  }
  
  public @FunctionalInterface interface ValueDecl2T<T> {
    public T $call(ValueDecl VD);
  }  

  public @FunctionalInterface interface ExprUnsigned2Expr<T extends Expr> {
    public T $call(Expr e, /*uint*/int l);
  }  

  public @FunctionalInterface interface ObjCMessageExprNSAPICommit2Bool {
    public boolean $call(ObjCMessageExpr expr, NSAPI nsapi, Commit commit);
  }   
  
  // function_ref<void (CXXScopeSpec /*&*/ , DeclarationNameInfo)>
  public @FunctionalInterface interface CXXScopeSpec$RefDeclarationNameInfo2Void {
    void $call(CXXScopeSpec /*&*/scopeSpec, DeclarationNameInfo declNameInfo);
  }
  
  ///
  public @FunctionalInterface interface DeclSpecTQStrSLocUIntRef2Void {
    void $call(DeclSpec.TQ TypeQual, /*const*/ String /*P*/FixItName, SourceLocation SpecLoc, uint$ref QualifierLoc);
  }
  
  public @FunctionalInterface interface DeclaratorChunkBool2Bool {
    boolean $call(DeclaratorChunk chunk, boolean inFunction);
  }
  
  public @FunctionalInterface interface SemaSourceLocationUnsignedQualType2Void {
    void $call(Sema S, SourceLocation loc, int diagnostic, QualType type);
  }
  
  public @FunctionalInterface interface CheckForSwiftCCUnsigned2Void {
    void $call(int paramIndex);
  }
  
  public @FunctionalInterface interface AttributeList2Bool {
    boolean $call(AttributeList /*P*/ NextAttr);
  }
  
  public @FunctionalInterface interface SimplePointerKindSourceLocationAttributeList2AttributeList {
    AttributeList $call(SimplePointerKind pointerKind, SourceLocation pointerLoc, type$ref<AttributeList> /*&*/ attrs);
  }

  public @FunctionalInterface interface T2CUDAFunctionPreference<T> {
    CUDAFunctionPreference $call(T t);
  }
  
  public @FunctionalInterface interface SemaExprQualType2ExprResult {
    ActionResultTTrue<Expr> $call(Sema /*&*/ S, Expr /*P*/ E, QualType T);
  }
  
  public @FunctionalInterface interface DeducedTemplateArgumentUint2Bool {
    boolean $call(DeducedTemplateArgument A, int I);
  }

  public @FunctionalInterface interface OpenMPDirectiveKindDeclarationNameInfoSourceLocation2Bool {
    boolean $call(OpenMPDirectiveKind kind, DeclarationNameInfo dn, SourceLocation isl);
  }
  
  @FunctionalInterface
  public interface PointerUnionSourceLocation2ActionResult {
    ActionResult<OpaquePtr<QualType> > $call(/*const*/ PointerUnion<TypeDecl /*P*/ , ObjCInterfaceDecl /*P*/ > D, SourceLocation /*&*/ S);
  }
}
