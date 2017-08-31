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

package org.clang.astmatchers.ast_matchers.internal.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import org.clang.astmatchers.ast_matchers.*;
import org.clang.astmatchers.ast_matchers.internal.*;
import org.clang.astmatchers.ast_matchers.internal.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.*;
import org.clang.astmatchers.dynamic.ast_matchers.impl.*;
import org.clang.astmatchers.dynamic.ast_matchers.internal.impl.*;
import org.clang.astmatchers.ast_matchers.java.AstMatchersFunctionPointers.*;
import org.clang.basic.java.*;
import org.clang.basic.llvm.*;
import org.clang.lex.*;
import org.clang.lex.java.*;
import org.clang.lex.llvm.*;


// A RecursiveASTVisitor that traverses all children or all descendants of
// a node.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 78,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitorE")
//</editor-fold>
public class MatchChildASTVisitor implements /*public*/ RecursiveASTVisitor<MatchChildASTVisitor>, Destructors.ClassWithDestructor {
/*public:*/
  /*typedef RecursiveASTVisitor<MatchChildASTVisitor> VisitorBase*/
//  public final class VisitorBase extends RecursiveASTVisitor<MatchChildASTVisitor>{ };
  
  // Creates an AST visitor that matches 'matcher' on all children or
  // descendants of a traversed node. max_depth is the maximum depth
  // to traverse: use 1 for matching the children and INT_MAX for
  // matching the descendants.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::MatchChildASTVisitor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 87,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::MatchChildASTVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitorC1EPKNS1_15DynTypedMatcherEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEiNS7_13TraversalKindENS7_8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitorC1EPKNS1_15DynTypedMatcherEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderEiNS7_13TraversalKindENS7_8BindKindE")
  //</editor-fold>
  public MatchChildASTVisitor(/*const*/ DynTypedMatcher /*P*/ Matcher, 
      ASTMatchFinder /*P*/ Finder, 
      BoundNodesTreeBuilder /*P*/ Builder, 
      int MaxDepth, 
      ASTMatchFinder.TraversalKind Traversal, 
      ASTMatchFinder.BindKind Bind) {
    // : RecursiveASTVisitor<MatchChildASTVisitor>(), Matcher(Matcher), Finder(Finder), Builder(Builder), ResultBindings(), CurrentDepth(0), MaxDepth(MaxDepth), Traversal(Traversal), Bind(Bind), Matches(false) 
    $RecursiveASTVisitor();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Returns true if a match is found in the subtree rooted at the
  // given AST node. This is done via a set of mutually recursive
  // functions. Here's how the recursion is done (the  *wildcard can
  // actually be Decl, Stmt, or Type):
  //
  //   - Traverse(node) calls BaseTraverse(node) when it needs
  //     to visit the descendants of node.
  //   - BaseTraverse(node) then calls (via VisitorBase::Traverse*(node))
  //     Traverse*(c) for each child c of 'node'.
  //   - Traverse*(c) in turn calls Traverse(c), completing the
  //     recursion.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::findMatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 113,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::findMatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor9findMatchERKNS_15ast_type_traits12DynTypedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor9findMatchERKNS_15ast_type_traits12DynTypedNodeE")
  //</editor-fold>
  public boolean findMatch(final /*const*/ DynTypedNode /*&*/ DynNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // The following are overriding methods from the base visitor class.
  // They are public only to allow CRTP to work. They are *not *part
  // of the public API of this class.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 142,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseDecl", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12TraverseDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12TraverseDeclEPNS_4DeclE")
  //</editor-fold>
  public boolean TraverseDecl(Decl /*P*/ DeclNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 146,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseStmt", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12TraverseStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12TraverseStmtEPNS_4StmtE")
  //</editor-fold>
  public boolean TraverseStmt(Stmt /*P*/ StmtNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // We assume that the QualType and the contained type are on the same
  // hierarchy level. Thus, we try to match either of them.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 160,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseType", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12TraverseTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12TraverseTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean TraverseType(QualType TypeNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // We assume that the TypeLoc, contained QualType and contained Type all are
  // on the same hierarchy level. Thus, we try to match all of them.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseTypeLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 172,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseTypeLoc", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor15TraverseTypeLocENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor15TraverseTypeLocENS_7TypeLocE")
  //</editor-fold>
  public boolean TraverseTypeLoc(TypeLoc TypeLocNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseNestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 185,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseNestedNameSpecifier", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor27TraverseNestedNameSpecifierEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor27TraverseNestedNameSpecifierEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  public boolean TraverseNestedNameSpecifier(NestedNameSpecifier /*P*/ NNS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseNestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 189,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::TraverseNestedNameSpecifierLoc", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor30TraverseNestedNameSpecifierLocENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor30TraverseNestedNameSpecifierLocENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public boolean TraverseNestedNameSpecifierLoc(NestedNameSpecifierLoc NNS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::shouldVisitTemplateInstantiations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 198,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::shouldVisitTemplateInstantiations", NM="_ZNK5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor33shouldVisitTemplateInstantiationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor33shouldVisitTemplateInstantiationsEv")
  //</editor-fold>
  public boolean shouldVisitTemplateInstantiations() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::shouldVisitImplicitCode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 199,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::shouldVisitImplicitCode", NM="_ZNK5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor23shouldVisitImplicitCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor23shouldVisitImplicitCodeEv")
  //</editor-fold>
  public boolean shouldVisitImplicitCode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  // Used for updating the depth during traversal.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::ScopedIncrement">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 203,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::ScopedIncrement", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor15ScopedIncrementE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor15ScopedIncrementE")
  //</editor-fold>
  private static class/*struct*/ ScopedIncrement implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::ScopedIncrement::ScopedIncrement">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 204,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::ScopedIncrement::ScopedIncrement", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor15ScopedIncrementC1EPi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor15ScopedIncrementC1EPi")
    //</editor-fold>
    public /*explicit*/ ScopedIncrement(int$ptr/*int P*/ Depth) {
      // : Depth(Depth) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::ScopedIncrement::~ScopedIncrement">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 205,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::ScopedIncrement::~ScopedIncrement", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor15ScopedIncrementD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor15ScopedIncrementD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private int$ptr/*int P*/ Depth;
    
    @Override public String toString() {
      return "" + "Depth=" + Depth; // NOI18N
    }
  };
  
  // Resets the state of this object.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::reset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 212,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::reset", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor5resetEv")
  //</editor-fold>
  private void reset() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Forwards the call to the corresponding Traverse*() method in the
  // base visitor class.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 219,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseERKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseERKNS_4DeclE")
  //</editor-fold>
  private boolean baseTraverse(final /*const*/ Decl /*&*/ DeclNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 222,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseERKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseERKNS_4StmtE")
  //</editor-fold>
  private boolean baseTraverse(final /*const*/ Stmt /*&*/ StmtNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 225,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseENS_8QualTypeE")
  //</editor-fold>
  private boolean baseTraverse(QualType TypeNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 228,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseENS_7TypeLocE")
  //</editor-fold>
  private boolean baseTraverse(TypeLoc TypeLocNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 231,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseERKNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseERKNS_19NestedNameSpecifierE")
  //</editor-fold>
  private boolean baseTraverse(final /*const*/ NestedNameSpecifier /*&*/ NNS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 235,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::baseTraverse", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor12baseTraverseENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  private boolean baseTraverse(NestedNameSpecifierLoc NNS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Sets 'Matched' to true if 'Matcher' matches 'Node' and:
  //   0 < CurrentDepth <= MaxDepth.
  //
  // Returns 'true' if traversal should continue after this function
  // returns, i.e. if no match is found or 'Bind' is 'BK_All'.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::match">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 245,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::match", NM="Tpl__ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor5matchERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor5matchERKT_")
  //</editor-fold>
  private </*typename*/ T> boolean match(final /*const*/ T /*&*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Traverses the subtree rooted at 'Node'; returns true if the
  // traversal should continue after this function returns.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::traverse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 272,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::traverse", NM="Tpl__ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor8traverseERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitor8traverseERKT_")
  //</editor-fold>
  private </*typename*/ T> boolean traverse(final /*const*/ T /*&*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private /*const*/ DynTypedMatcher /*P*/ /*const*/ Matcher;
  private ASTMatchFinder /*P*/ /*const*/ Finder;
  private BoundNodesTreeBuilder /*P*/ /*const*/ Builder;
  private BoundNodesTreeBuilder ResultBindings;
  private int CurrentDepth;
  private /*const*/int MaxDepth;
  private /*const*/ ASTMatchFinder.TraversalKind Traversal;
  private /*const*/ ASTMatchFinder.BindKind Bind;
  private boolean Matches;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::~MatchChildASTVisitor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 78,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchChildASTVisitor::~MatchChildASTVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_120MatchChildASTVisitorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Matcher=" + Matcher // NOI18N
              + ", Finder=" + Finder // NOI18N
              + ", Builder=" + "[BoundNodesTreeBuilder]" // NOI18N
              + ", ResultBindings=" + "[BoundNodesTreeBuilder]" // NOI18N
              + ", CurrentDepth=" + CurrentDepth // NOI18N
              + ", MaxDepth=" + MaxDepth // NOI18N
              + ", Traversal=" + Traversal // NOI18N
              + ", Bind=" + Bind // NOI18N
              + ", Matches=" + Matches // NOI18N
              + super.toString(); // NOI18N
  }
}
