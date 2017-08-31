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

package org.clang.astmatchers.ast_matchers.internal;

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


/// \brief Creates BoundNodesTree objects.
///
/// The tree builder is used during the matching process to insert the bound
/// nodes from the Id matcher.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 185,
 FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderE")
//</editor-fold>
public class BoundNodesTreeBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief A visitor interface to visit all BoundNodes results for a
  /// BoundNodesTree.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::Visitor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 189,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::Visitor", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder7VisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder7VisitorE")
  //</editor-fold>
  public abstract static class Visitor implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::Visitor::~Visitor">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 191,
     FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::Visitor::~Visitor", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder7VisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder7VisitorD0Ev")
    //</editor-fold>
    public /*virtual*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// \brief Called multiple times during a single call to VisitMatches(...).
    ///
    /// 'BoundNodesView' contains the bound nodes for a single match.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::Visitor::visitMatch">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 196,
     FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::Visitor::visitMatch", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder7Visitor10visitMatchERKNS0_10BoundNodesE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder7Visitor10visitMatchERKNS0_10BoundNodesE")
    //</editor-fold>
    public abstract /*virtual*/ void visitMatch(final /*const*/ BoundNodes /*&*/ BoundNodesView)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::Visitor::Visitor">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 189,
     FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::Visitor::Visitor", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder7VisitorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder7VisitorC1Ev")
    //</editor-fold>
    public /*inline*/ Visitor() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// \brief Add a binding from an id to a node.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::setBinding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 200,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::setBinding", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder10setBindingEN4llvm9StringRefERKNS_15ast_type_traits12DynTypedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder10setBindingEN4llvm9StringRefERKNS_15ast_type_traits12DynTypedNodeE")
  //</editor-fold>
  public void setBinding(StringRef Id, final /*const*/ DynTypedNode /*&*/ DynNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Adds a branch in the tree.
  
  /// \brief Adds a branch in the tree.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::addMatch">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 228,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::addMatch", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder8addMatchERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder8addMatchERKS2_")
  //</editor-fold>
  public void addMatch(final /*const*/ BoundNodesTreeBuilder /*&*/ Other) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Visits all matches that this BoundNodesTree represents.
  ///
  /// The ownership of 'ResultVisitor' remains at the caller.
  
  /// \brief Visits all matches that this BoundNodesTree represents.
  ///
  /// The ownership of 'ResultVisitor' remains at the caller.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::visitMatches">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 44,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::visitMatches", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder12visitMatchesEPNS2_7VisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder12visitMatchesEPNS2_7VisitorE")
  //</editor-fold>
  public void visitMatches(Visitor /*P*/ ResultVisitor) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /*template <typename ExcludePredicate> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::removeBindings">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 216,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::removeBindings", NM="Tpl__ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder14removeBindingsERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers8internal21BoundNodesTreeBuilder14removeBindingsERKT_")
  //</editor-fold>
  public </*typename*/ ExcludePredicate> boolean removeBindings(final /*const*/ ExcludePredicate /*&*/ Predicate) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Imposes an order on BoundNodesTreeBuilders.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 223,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::operator<", NM="_ZNK5clang12ast_matchers8internal21BoundNodesTreeBuilderltERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal21BoundNodesTreeBuilderltERKS2_")
  //</editor-fold>
  public boolean $less(final /*const*/ BoundNodesTreeBuilder /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns \c true if this \c BoundNodesTreeBuilder can be compared,
  /// i.e. all stored node maps have memoization data.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::isComparable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 229,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::isComparable", NM="_ZNK5clang12ast_matchers8internal21BoundNodesTreeBuilder12isComparableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal21BoundNodesTreeBuilder12isComparableEv")
  //</editor-fold>
  public boolean isComparable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private SmallVector<BoundNodesMap> Bindings;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 185,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::operator=", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderaSEOS2_")
  //</editor-fold>
  public /*inline*/ BoundNodesTreeBuilder /*&*/ $assignMove(final BoundNodesTreeBuilder /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::BoundNodesTreeBuilder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 185,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::BoundNodesTreeBuilder", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderC1Ev")
  //</editor-fold>
  public /*inline*/ BoundNodesTreeBuilder() {
    // : Bindings() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::BoundNodesTreeBuilder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 185,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::BoundNodesTreeBuilder", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderC1ERKS2_")
  //</editor-fold>
  public /*inline*/ BoundNodesTreeBuilder(final /*const*/ BoundNodesTreeBuilder /*&*/ $Prm0) {
    // : Bindings(.Bindings) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::~BoundNodesTreeBuilder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 185,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::~BoundNodesTreeBuilder", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesTreeBuilder::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 185,
   FQN="clang::ast_matchers::internal::BoundNodesTreeBuilder::operator=", NM="_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal21BoundNodesTreeBuilderaSERKS2_")
  //</editor-fold>
  public /*inline*/ BoundNodesTreeBuilder /*&*/ $assign(final /*const*/ BoundNodesTreeBuilder /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Bindings=" + Bindings; // NOI18N
  }
}
