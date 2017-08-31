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
import org.clang.ast.comments.Comment;
import org.clang.basic.java.BasicMemberPointers.*;
import org.llvm.adt.aliases.SmallVectorImpl;
import org.clank.support.aliases.*;
import org.llvm.adt.iterator_range;
/**
 *
 * @author petrk
 */
public interface AstMemberPointers {
  
  // bool (VisitorBase::*)(T * )
  @FunctionalInterface
  public interface VisitorBase$Ptr2Bool<VisitorBase, T> {
    boolean $call(VisitorBase $this, T/*P*/ ptr);
  }
  
  //Stmt::child_range children_t()
  // children_t T::*
  @FunctionalInterface
  public interface T$getChildrenStmts<T> {
    iterator_range<Stmt/*P*/> $call(T $this);
  }
  // children_t Stmt::*
  @FunctionalInterface
  public interface Stmt$getChildrenStmts extends T$getChildrenStmts<Stmt> {
  }

  // SourceLocation (Stmt::*v)()
  @FunctionalInterface 
  public interface Stmt$getLocStart extends T$getLocStart<Stmt>{
  }

  // SourceLocation (Stmt::*v)()
  @FunctionalInterface 
  public interface Stmt$getLocEnd extends T$getLocEnd<Stmt> {
  }

  // SourceRange (Stmt::*v)()
  @FunctionalInterface 
  public interface Stmt$getSourceRange extends T$getSourceRange<Stmt> {
  }
  
  // TypeLoc (T::*)()
  // TypeLoc (T::*)() const
  @FunctionalInterface
  public interface T$getTypeLoc<T> {
    TypeLoc $call(T $this);
  }
          
  // QualType (T::*)()
  // QualType (T::*)() const
  @FunctionalInterface
  public interface T$getQualType<T> {
    QualType $call(T $this);
  }
          
  //void (ExternalASTSource::*)(Owner)
  //void (ExternalASTSource::*)(Decl*)
  @FunctionalInterface
  public interface ExternalASTSource$Decl2Void {
    void $call(ExternalASTSource $this, /*const*/ Decl /*P*/ D);
  }
  
  //T * (ExternalASTSource::*)(OffsT)
  //@FunctionalInterface
  //public interface ExternalASTSource$OffsT2T<T> {
  //  T $call(ExternalASTSource $this, /*size_t*/int OffsT);
  //}
  @FunctionalInterface
  public interface ExternalASTSource$OffsT2T<T> {
    T $call(ExternalASTSource $this, long/*uint64_t*/ Offset);
  }

  // SourceLocation (Expr::*)() const
  @FunctionalInterface
  public interface Expr$getSourceLocation extends T$getSourceLocation<Expr> {
  }

  //void (Source::*)(SmallVectorImpl<T> & )
  @FunctionalInterface
  public interface Source$SmallVector2Void<Source, T> {
    void $call(Source $this, SmallVectorImpl<T> OffsT);
  }

  @FunctionalInterface
  public interface SourceLoader<Source extends ExternalASTSource, T> extends Source$SmallVector2Void<Source, T> {
  }

  // Comment::child_iterator (T::*)() const
  @FunctionalInterface
  public interface T$getChildrenCommentsIterator<T> {
    type$ptr<Comment> $call(T $this);
  }
  @FunctionalInterface
  // Comment::child_iterator (Comment::*)() const
  public interface Comment$getChildrenCommentsIterator extends T$getChildrenCommentsIterator<Comment> {
  }
  
  // bool (SpecificDecl::*)()
  @FunctionalInterface
  public interface SpecificDecl$BoolPredicate<SpecificDecl> {
    boolean $call(SpecificDecl $this);
  }
  
  // bool (CXXRecordDecl::*)() const 
  @FunctionalInterface
  public interface CXXRecordDecl$BoolPredicate {
    boolean $call(CXXRecordDecl $this);
  }
  
  // bool (CXXMethodDecl::*)() const 
  @FunctionalInterface
  public interface CXXMethodDecl$BoolPredicate {
    boolean $call(CXXMethodDecl $this);
  }
}
