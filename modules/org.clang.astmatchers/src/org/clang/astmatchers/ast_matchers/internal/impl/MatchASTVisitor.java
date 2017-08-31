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


// Controls the outermost traversal of the AST and allows to match multiple
// matchers.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 293,
 FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitorE")
//</editor-fold>
public class MatchASTVisitor extends /*public*/ ASTMatchFinder implements /*public*/ RecursiveASTVisitor<MatchASTVisitor>, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchASTVisitor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 296,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchASTVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitorC1EPKNS0_11MatchFinder14MatchersByTypeERKNS4_18MatchFinderOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitorC1EPKNS0_11MatchFinder14MatchersByTypeERKNS4_18MatchFinderOptionsE")
  //</editor-fold>
  public MatchASTVisitor(/*const*/ MatchFinder.MatchersByType /*P*/ Matchers, 
      final /*const*/ MatchFinder.MatchFinderOptions /*&*/ Options) {
    // : RecursiveASTVisitor<MatchASTVisitor>(), ASTMatchFinder(), TimeByBucket(), Matchers(Matchers), MatcherFiltersMap(), Options(Options), ActiveASTContext(null), TypeAliases(), ResultCache() 
    super();
    $RecursiveASTVisitor();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::~MatchASTVisitor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 300,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::~MatchASTVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitorD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::onStartOfTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 306,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::onStartOfTranslationUnit", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor24onStartOfTranslationUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor24onStartOfTranslationUnitEv")
  //</editor-fold>
  public void onStartOfTranslationUnit() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::onEndOfTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 316,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::onEndOfTranslationUnit", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor22onEndOfTranslationUnitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor22onEndOfTranslationUnitEv")
  //</editor-fold>
  public void onEndOfTranslationUnit() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::set_active_ast_context">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 326,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::set_active_ast_context", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor22set_active_ast_contextEPNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor22set_active_ast_contextEPNS_10ASTContextE")
  //</editor-fold>
  public void set_active_ast_context(ASTContext /*P*/ NewActiveASTContext) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // The following Visit*() and Traverse*() functions "override"
  // methods in RecursiveASTVisitor.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::VisitTypedefNameDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 333,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::VisitTypedefNameDecl", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor20VisitTypedefNameDeclEPNS_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor20VisitTypedefNameDeclEPNS_15TypedefNameDeclE")
  //</editor-fold>
  public boolean VisitTypedefNameDecl(TypedefNameDecl /*P*/ DeclNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 815,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseDecl", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12TraverseDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12TraverseDeclEPNS_4DeclE")
  //</editor-fold>
  public boolean TraverseDecl(Decl /*P*/ DeclNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseStmt">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 823,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseStmt", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12TraverseStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12TraverseStmtEPNS_4StmtE")
  //</editor-fold>
  public boolean TraverseStmt(Stmt /*P*/ StmtNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 831,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseType", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12TraverseTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12TraverseTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean TraverseType(QualType TypeNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseTypeLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 836,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseTypeLoc", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor15TraverseTypeLocENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor15TraverseTypeLocENS_7TypeLocE")
  //</editor-fold>
  public boolean TraverseTypeLoc(TypeLoc TypeLocNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseNestedNameSpecifier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 847,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseNestedNameSpecifier", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor27TraverseNestedNameSpecifierEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor27TraverseNestedNameSpecifierEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  public boolean TraverseNestedNameSpecifier(NestedNameSpecifier /*P*/ NNS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseNestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 852,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TraverseNestedNameSpecifierLoc", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor30TraverseNestedNameSpecifierLocENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor30TraverseNestedNameSpecifierLocENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public boolean TraverseNestedNameSpecifierLoc(NestedNameSpecifierLoc NNS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Matches children or descendants of 'Node' with 'BaseMatcher'.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::memoizedMatchesRecursively">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 376,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::memoizedMatchesRecursively", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor26memoizedMatchesRecursivelyERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderEiNS1_14ASTMatchFinder13TraversalKindENSD_8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor26memoizedMatchesRecursivelyERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderEiNS1_14ASTMatchFinder13TraversalKindENSD_8BindKindE")
  //</editor-fold>
  public boolean memoizedMatchesRecursively(final /*const*/ DynTypedNode /*&*/ Node, 
                            final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                            BoundNodesTreeBuilder /*P*/ Builder, int MaxDepth, 
                            TraversalKind Traversal, BindKind Bind) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Matches children or descendants of 'Node' with 'BaseMatcher'.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesRecursively">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 410,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesRecursively", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor18matchesRecursivelyERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderEiNS1_14ASTMatchFinder13TraversalKindENSD_8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor18matchesRecursivelyERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderEiNS1_14ASTMatchFinder13TraversalKindENSD_8BindKindE")
  //</editor-fold>
  public boolean matchesRecursively(final /*const*/ DynTypedNode /*&*/ Node, 
                    final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                    BoundNodesTreeBuilder /*P*/ Builder, int MaxDepth, 
                    TraversalKind Traversal, BindKind Bind) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  
  // Returns true if the given class is directly or indirectly derived
  // from a base type with the given name.  A class is not considered to be
  // derived from itself.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::classIsDerivedFrom">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 782,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::classIsDerivedFrom", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor18classIsDerivedFromEPKNS_13CXXRecordDeclERKNS1_7MatcherINS_9NamedDeclEEEPNS1_21BoundNodesTreeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor18classIsDerivedFromEPKNS_13CXXRecordDeclERKNS1_7MatcherINS_9NamedDeclEEEPNS1_21BoundNodesTreeBuilderE")
  //</editor-fold>
  @Override public boolean classIsDerivedFrom(/*const*/ CXXRecordDecl /*P*/ Declaration, 
                    final /*const*/ Matcher<NamedDecl> /*&*/ Base, 
                    BoundNodesTreeBuilder /*P*/ Builder)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Implements ASTMatchFinder::matchesChildOf.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesChildOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 424,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesChildOf", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor14matchesChildOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder13TraversalKindENSD_8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor14matchesChildOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder13TraversalKindENSD_8BindKindE")
  //</editor-fold>
  @Override public boolean matchesChildOf(final /*const*/ DynTypedNode /*&*/ Node, 
                final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                BoundNodesTreeBuilder /*P*/ Builder, 
                TraversalKind Traversal, 
                BindKind Bind)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Implements ASTMatchFinder::matchesDescendantOf.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesDescendantOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 435,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesDescendantOf", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor19matchesDescendantOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor19matchesDescendantOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder8BindKindE")
  //</editor-fold>
  @Override public boolean matchesDescendantOf(final /*const*/ DynTypedNode /*&*/ Node, 
                     final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                     BoundNodesTreeBuilder /*P*/ Builder, 
                     BindKind Bind)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // Implements ASTMatchFinder::matchesAncestorOf.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesAncestorOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 445,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesAncestorOf", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor17matchesAncestorOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder17AncestorMatchModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor17matchesAncestorOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder17AncestorMatchModeE")
  //</editor-fold>
  @Override public boolean matchesAncestorOf(final /*const*/ DynTypedNode /*&*/ Node, 
                   final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                   BoundNodesTreeBuilder /*P*/ Builder, 
                   AncestorMatchMode MatchMode)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Matches all registered matchers on the given node and calls the
  // result callback for every node that matches.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::match">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 459,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::match", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor5matchERKNS_15ast_type_traits12DynTypedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor5matchERKNS_15ast_type_traits12DynTypedNodeE")
  //</editor-fold>
  public void match(final /*const*/ DynTypedNode /*&*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::match">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 478,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::match", NM="Tpl__ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor5matchERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor5matchERKT_")
  //</editor-fold>
  public </*typename*/ T> void match$T(final /*const*/ T /*&*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Implements ASTMatchFinder::getASTContext.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::getASTContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 483,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::getASTContext", NM="_ZNK5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13getASTContextEv")
  //</editor-fold>
  @Override public ASTContext /*&*/ getASTContext() /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::shouldVisitTemplateInstantiations">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 485,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::shouldVisitTemplateInstantiations", NM="_ZNK5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor33shouldVisitTemplateInstantiationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor33shouldVisitTemplateInstantiationsEv")
  //</editor-fold>
  public boolean shouldVisitTemplateInstantiations() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::shouldVisitImplicitCode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 486,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::shouldVisitImplicitCode", NM="_ZNK5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor23shouldVisitImplicitCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor23shouldVisitImplicitCodeEv")
  //</editor-fold>
  public boolean shouldVisitImplicitCode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TimeBucketRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 489,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TimeBucketRegion", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16TimeBucketRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16TimeBucketRegionE")
  //</editor-fold>
  private static class TimeBucketRegion implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TimeBucketRegion::TimeBucketRegion">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 491,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TimeBucketRegion::TimeBucketRegion", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16TimeBucketRegionC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16TimeBucketRegionC1Ev")
    //</editor-fold>
    public TimeBucketRegion() {
      // : Bucket(null) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TimeBucketRegion::~TimeBucketRegion">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 492,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TimeBucketRegion::~TimeBucketRegion", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16TimeBucketRegionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16TimeBucketRegionD0Ev")
    //</editor-fold>
    public void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Start timing for \p NewBucket.
    ///
    /// If there was a bucket already set, it will finish the timing for that
    /// other bucket.
    /// \p NewBucket will be timed until the next call to \c setBucket() or
    /// until the \c TimeBucketRegion is destroyed.
    /// If \p NewBucket is the same as the currently timed bucket, this call
    /// does nothing.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TimeBucketRegion::setBucket">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 502,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::TimeBucketRegion::setBucket", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16TimeBucketRegion9setBucketEPN4llvm10TimeRecordE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16TimeBucketRegion9setBucketEPN4llvm10TimeRecordE")
    //</editor-fold>
    public void setBucket(TimeRecord /*P*/ NewBucket) {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private TimeRecord /*P*/ Bucket;
    
    @Override public String toString() {
      return "" + "Bucket=" + Bucket; // NOI18N
    }
  };
  
  /// \brief Runs all the \p Matchers on \p Node.
  ///
  /// Used by \c matchDispatch() below.
  /*template <typename T, typename MC> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchWithoutFilter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 521,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchWithoutFilter", NM="Tpl__ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor18matchWithoutFilterERKT_RKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor18matchWithoutFilterERKT_RKT0_")
  //</editor-fold>
  private </*typename*/ T, /*typename*/ MC> void matchWithoutFilter(final /*const*/ T /*&*/ Node, final /*const*/ MC /*&*/ Matchers) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchWithFilter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 535,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchWithFilter", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor15matchWithFilterERKNS_15ast_type_traits12DynTypedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor15matchWithFilterERKNS_15ast_type_traits12DynTypedNodeE")
  //</editor-fold>
  private void matchWithFilter(final /*const*/ DynTypedNode /*&*/ DynNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::getFilterForKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 559,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::getFilterForKind", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16getFilterForKindENS_15ast_type_traits11ASTNodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor16getFilterForKindENS_15ast_type_traits11ASTNodeKindE")
  //</editor-fold>
  private /*const*/std.vectorUShort /*&*/ getFilterForKind(ASTNodeKind Kind) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @{
  /// \brief Overloads to pair the different node types to their matchers.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 574,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_4DeclE")
  //</editor-fold>
  private void matchDispatch(/*const*/ Decl /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 577,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_4StmtE")
  //</editor-fold>
  private void matchDispatch(/*const*/ Stmt /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 581,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_4TypeE")
  //</editor-fold>
  private void matchDispatch(/*const*/ Type /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 584,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_7TypeLocE")
  //</editor-fold>
  private void matchDispatch(/*const*/ TypeLoc /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 587,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_8QualTypeE")
  //</editor-fold>
  private void matchDispatch(/*const*/ QualType /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 590,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_19NestedNameSpecifierE")
  //</editor-fold>
  private void matchDispatch(/*const*/ NestedNameSpecifier /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 593,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKNS_22NestedNameSpecifierLocE")
  //</editor-fold>
  private void matchDispatch(/*const*/ NestedNameSpecifierLoc /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 596,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchDispatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor13matchDispatchEPKv")
  //</editor-fold>
  private void matchDispatch(/*const*/Object/*void P*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// @}
  
  // Returns whether an ancestor of \p Node matches \p Matcher.
  //
  // The order of matching ((which can lead to different nodes being bound in
  // case there are multiple matches) is breadth first search.
  //
  // To allow memoization in the very common case of having deeply nested
  // expressions inside a template function, we first walk up the AST, memoizing
  // the result of the match along the way, as long as there is only a single
  // parent.
  //
  // Once there are multiple parents, the breadth first search order does not
  // allow simple memoization on the ancestors. Thus, we only memoize as long
  // as there is a single parent.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::memoizedMatchesAncestorOfRecursively">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 612,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::memoizedMatchesAncestorOfRecursively", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor36memoizedMatchesAncestorOfRecursivelyERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder17AncestorMatchModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor36memoizedMatchesAncestorOfRecursivelyERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder17AncestorMatchModeE")
  //</editor-fold>
  private boolean memoizedMatchesAncestorOfRecursively(final /*const*/ DynTypedNode /*&*/ Node, final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                                      BoundNodesTreeBuilder /*P*/ Builder, AncestorMatchMode MatchMode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesAncestorOfRecursively">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 648,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::matchesAncestorOfRecursively", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor28matchesAncestorOfRecursivelyERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder17AncestorMatchModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor28matchesAncestorOfRecursivelyERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS1_14ASTMatchFinder17AncestorMatchModeE")
  //</editor-fold>
  private boolean matchesAncestorOfRecursively(final /*const*/ DynTypedNode /*&*/ Node, 
                              final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                              BoundNodesTreeBuilder /*P*/ Builder, 
                              AncestorMatchMode MatchMode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Implements a BoundNodesTree::Visitor that calls a MatchCallback with
  // the aggregated bound nodes for each match.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchVisitor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 697,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12MatchVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12MatchVisitorE")
  //</editor-fold>
  private static class MatchVisitor extends /*public*/ BoundNodesTreeBuilder.Visitor implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchVisitor::MatchVisitor">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 699,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchVisitor::MatchVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12MatchVisitorC1EPNS_10ASTContextEPNS0_11MatchFinder13MatchCallbackE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12MatchVisitorC1EPNS_10ASTContextEPNS0_11MatchFinder13MatchCallbackE")
    //</editor-fold>
    public MatchVisitor(ASTContext /*P*/ Context, 
        MatchFinder.MatchCallback /*P*/ Callback) {
      // : BoundNodesTreeBuilder::Visitor(), Context(Context), Callback(Callback) 
      super();
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchVisitor::visitMatch">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 704,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchVisitor::visitMatch", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12MatchVisitor10visitMatchERKNS0_10BoundNodesE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12MatchVisitor10visitMatchERKNS0_10BoundNodesE")
    //</editor-fold>
    @Override public void visitMatch(final /*const*/ BoundNodes /*&*/ BoundNodesView)/* override*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    private ASTContext /*P*/ Context;
    private MatchFinder.MatchCallback /*P*/ Callback;
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchVisitor::~MatchVisitor">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 697,
     FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::MatchVisitor::~MatchVisitor", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12MatchVisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor12MatchVisitorD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Context=" + Context // NOI18N
                + ", Callback=" + Callback // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  // Returns true if 'TypeNode' has an alias that matches the given matcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::typeHasMatchingAlias">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp", line = 714,
   FQN="clang::ast_matchers::internal::(anonymous namespace)::MatchASTVisitor::typeHasMatchingAlias", NM="_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor20typeHasMatchingAliasEPKNS_4TypeERKNS1_7MatcherINS_9NamedDeclEEEPNS1_21BoundNodesTreeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal12_GLOBAL__N_115MatchASTVisitor20typeHasMatchingAliasEPKNS_4TypeERKNS1_7MatcherINS_9NamedDeclEEEPNS1_21BoundNodesTreeBuilderE")
  //</editor-fold>
  private boolean typeHasMatchingAlias(/*const*/ Type /*P*/ TypeNode, 
                      final /*const*/ Matcher<NamedDecl> /*&*/ Matcher, 
                      BoundNodesTreeBuilder /*P*/ Builder) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Bucket to record map.
  ///
  /// Used to get the appropriate bucket for each matcher.
  private StringMap<TimeRecord> TimeByBucket;
  
  private /*const*/ MatchFinder.MatchersByType /*P*/ Matchers;
  
  /// \brief Filtered list of matcher indices for each matcher kind.
  ///
  /// \c Decl and \c Stmt toplevel matchers usually apply to a specific node
  /// kind (and derived kinds) so it is a waste to try every matcher on every
  /// node.
  /// We precalculate a list of matchers that pass the toplevel restrict check.
  /// This also allows us to skip the restrict check at matching time. See
  /// use \c matchesNoKindCheck() above.
  private DenseMap<ASTNodeKind, std.vectorUShort > MatcherFiltersMap;
  
  private final /*const*/ MatchFinder.MatchFinderOptions /*&*/ Options;
  private ASTContext /*P*/ ActiveASTContext;
  
  // Maps a canonical type to its TypedefDecls.
  private DenseMap</*const*/ Type /*P*/ , std.setPtr</*const*/ TypedefNameDecl /*P*/ >> TypeAliases;
  
  // Maps (matcher, node) -> the match result for memoization.
  /*typedef std::map<MatchKey, MemoizedMatchResult> MemoizationMap*/
//  public final class MemoizationMap extends std.map<MatchKey, MemoizedMatchResult>{ };
  private std.mapTypeType<MatchKey, MemoizedMatchResult> ResultCache;
  
  @Override public String toString() {
    return "" + "TimeByBucket=" + TimeByBucket // NOI18N
              + ", Matchers=" + Matchers // NOI18N
              + ", MatcherFiltersMap=" + MatcherFiltersMap // NOI18N
              + ", Options=" + Options // NOI18N
              + ", ActiveASTContext=" + ActiveASTContext // NOI18N
              + ", TypeAliases=" + TypeAliases // NOI18N
              + ", ResultCache=" + ResultCache // NOI18N
              + super.toString(); // NOI18N
  }
}
