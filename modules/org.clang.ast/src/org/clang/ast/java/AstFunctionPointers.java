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

package org.clang.ast.java;

import org.clang.ast.*;
import org.clang.ast.Decl;
import org.clang.ast.ParmVarDecl;
import org.clang.ast.comments.CommandInfo;
import org.clank.support.NativeCallback.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

/**
 *
 * @author vkvashin
 */
public class AstFunctionPointers {
  // bool (* )(const ObjCMethodDecl * )
  @FunctionalInterface
  public interface ObjCMethodDecl2Bool {
    boolean $call(/*const*/ObjCMethodDecl /*P*/decl);
  } 
  
  // bool (* )(const Decl * )
  @FunctionalInterface
  public interface Decl2Bool {
    boolean $call(/*const*/Decl /*P*/decl);
  } 
  
  // void (const Decl * )
  @FunctionalInterface
  public interface Decl2Void {
    void $call(/*const*/Decl /*P*/decl);
  } 
  
  // bool (* )(const Decl * )
  @FunctionalInterface
  public interface Stmt2Bool {
    boolean $call(/*const*/Stmt /*P*/decl);
  } 

  @FunctionalInterface
  public interface Stmt2Void {
    void $call(/*const*/Stmt /*P*/decl);
  } 
  
  /**bool (*DeclVisitorFn)(void * , const Decl * )*/
  @FunctionalInterface
  public interface DeclVisitorFn {
    boolean $call(Object context, /*const*/Decl /*P*/ decl);
  }

  /** llvm::function_ref<boolean (Decl::Kind) */
  @FunctionalInterface
  public interface DeclKind2Bool {
    boolean $call(Decl.Kind kind);
  }

  @FunctionalInterface
  public interface QualType2QualType extends java.util.function.Function<QualType, QualType> {
    QualType $call(QualType type);

    @Override
    public default QualType apply(QualType t) {
      return $call(t);
    }
    
  }
  
  @FunctionalInterface
  public interface T2FunctionDecl<T> {
    FunctionDecl $call(T t);
  }
  
  /** std::const_mem_fun_t<QualType, ParmVarDecl> */
  @FunctionalInterface
  public interface ParmVarDecl2QualType {
    QualType $call(ParmVarDecl param);
  }

  //llvm::function_ref<bool (const CXXBaseSpecifier *, CXXBasePath &)>
  @FunctionalInterface
  public interface BaseMatchesCallback {
    boolean $call(CXXBaseSpecifier/*P*/ spec, CXXBasePath /*&*/ path);
  }
  
  //llvm::function_ref<bool (const CXXRecordDecl *)> ForallBasesCallback
  @FunctionalInterface
  public interface ForallBasesCallback {
    boolean $call(CXXRecordDecl decl);
  }
  
  @FunctionalInterface
  public interface CommandInfo$P2Void {
    void $call(CommandInfo /*P*/cinfo);
  }
  
  private AstFunctionPointers() {
  }
  
  @FunctionalInterface
  public interface ParmVarDeclPtrParmVarDeclPtr2Bool extends TypeType2Bool<ParmVarDecl> {
    boolean $call(/*const*/ ParmVarDecl /*P*/ p1, /*const*/ ParmVarDecl /*P*/ p2);
  }
  
  @FunctionalInterface
  public interface CXXRecordDeclBoolRefBoolRef2Bool {
    boolean $call(CXXRecordDecl /*P*/ D, bool$ref/*bool &*/ B1, bool$ref/*bool &*/ B2);
  }

  @FunctionalInterface
  public interface CXXMethodDecl2Bool {
    boolean $call(CXXMethodDecl /*P*/ D);
  }
          
  @FunctionalInterface
  public interface ObjCPropertyDecl2Bool extends BoolPredicate<ObjCPropertyDecl> {
    boolean $call(ObjCPropertyDecl /*P*/ T);
  }
  
  @FunctionalInterface
  public interface FieldDeclBoolRef2Bool {
    boolean $call(FieldDecl /*P*/ F, bool$ref B);
  }
  
  @FunctionalInterface
  public interface Expr2Bool extends BoolPredicate<Expr> {
    boolean $call(Expr /*P*/ T);
  }

  @FunctionalInterface
  public interface Uint64Expr2Bool {
    boolean $call(long/*uint64_t*/ L, /*const*/ Expr /*P*/ T);
  }
  
  @FunctionalInterface
  public interface UniqueVirtualMethod2Bool extends BoolPredicate<UniqueVirtualMethod>{
    boolean $call(/*const*/ UniqueVirtualMethod /*&*/ D);
  }
  
  @FunctionalInterface
  public interface CXXBaseSpecifierCXXBasePath2Bool {
    boolean $call(/*const*/ CXXBaseSpecifier /*P*/ S, CXXBasePath /*&*/ P);
  }
  
  @FunctionalInterface
  public interface CXXRecordDecl2Bool extends BoolPredicate<CXXRecordDecl>{
    boolean $call(/*const*/ CXXRecordDecl /*P*/  D);
  }
  
  @FunctionalInterface
  public interface ObjCPropertyDecl2ObjCContainerDecl {
    ObjCPropertyDecl /*P*/ $call(/*const*/ ObjCContainerDecl /*P*/  D);
  }
  
  // interface to allow pass static functions
  // clang::VarTemplateSpecializationDecl::Profile
  // and clang::ClassTemplateSpecializationDecl::Profile 
  @FunctionalInterface
  public interface FoldingSet$Profile$ArrayRef_TemplateArguments {
    void Profile(final FoldingSetNodeID /*&*/ ID, 
         ArrayRef<TemplateArgument> TemplateArgs, 
         final ASTContext /*&*/ Context);
  }
  
  @FunctionalInterface
  public interface CXXBaseSpecifierCXXBasePathDeclarationName2Bool {
    boolean $call(/*const*/ CXXBaseSpecifier /*P*/ S, CXXBasePath /*&*/ P, DeclarationName D);
  }
  
  @FunctionalInterface
  public interface Bool2UsingDecl {
    UsingDecl $call(boolean B);
  }

  @FunctionalInterface
  public interface Void2UsingDecl {
    UsingDecl $call();
  }

  @FunctionalInterface
  public interface ASTContextFunctionDecl2Stmt {
    Stmt $call(ASTContext Ctx, FunctionDecl D);
  }

//////////////////////////////////////////////////////////////////////////////
  // marker for classes which have getTemplateArgs method returning TemplateArgumentList
  public interface HasGetTemplateArgs$TemplateArgumentList {
    /*const*/ TemplateArgumentList /*&*/ getTemplateArgs() /*const*/;
  }
  
  // marker for classes which have getSpecializedTemplate method
  public interface HasGetSpecializedTemplate<RetType extends RedeclarableTemplateDecl> {
    /*const*/ RetType /*&*/ getSpecializedTemplate() /*const*/;
  }
}
