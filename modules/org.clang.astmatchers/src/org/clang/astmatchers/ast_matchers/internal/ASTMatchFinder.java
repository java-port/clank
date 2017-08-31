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


/// \brief Interface that allows matchers to traverse the AST.
/// FIXME: Find a better name.
///
/// This provides three entry methods for each base node type in the AST:
/// - \c matchesChildOf:
///   Matches a matcher on every child node of the given node. Returns true
///   if at least one child node could be matched.
/// - \c matchesDescendantOf:
///   Matches a matcher on all descendant nodes of the given node. Returns true
///   if at least one descendant matched.
/// - \c matchesAncestorOf:
///   Matches a matcher on all ancestors of the given node. Returns true if
///   at least one ancestor matched.
///
/// FIXME: Currently we only allow Stmt and Decl nodes to start a traversal.
/// In the future, we want to implement this for all nodes for which it makes
/// sense. In the case of matchesAncestorOf, we'll want to implement it for
/// all nodes, as all nodes have ancestors.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 851,
 FQN="clang::ast_matchers::internal::ASTMatchFinder", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinderE")
//</editor-fold>
public abstract class ASTMatchFinder implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Defines how we descend a level in the AST when we pass
  /// through expressions.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::TraversalKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 855,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::TraversalKind", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinder13TraversalKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinder13TraversalKindE")
  //</editor-fold>
  public enum TraversalKind implements Native.ComparableLower {
    /// Will traverse any child nodes.
    TK_AsIs(0),
    /// Will not traverse implicit casts and parentheses.
    TK_IgnoreImplicitCastsAndParentheses(TK_AsIs.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static TraversalKind valueOf(int val) {
      TraversalKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final TraversalKind[] VALUES;
      private static final TraversalKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (TraversalKind kind : TraversalKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new TraversalKind[min < 0 ? (1-min) : 0];
        VALUES = new TraversalKind[max >= 0 ? (1+max) : 0];
        for (TraversalKind kind : TraversalKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private TraversalKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TraversalKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TraversalKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Defines how bindings are processed on recursive matches.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::BindKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 863,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::BindKind", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinder8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinder8BindKindE")
  //</editor-fold>
  public enum BindKind implements Native.ComparableLower {
    /// Stop at the first match and only bind the first match.
    BK_First(0),
    /// Create results for all combinations of bindings that match.
    BK_All(BK_First.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BindKind valueOf(int val) {
      BindKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BindKind[] VALUES;
      private static final BindKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BindKind kind : BindKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BindKind[min < 0 ? (1-min) : 0];
        VALUES = new BindKind[max >= 0 ? (1+max) : 0];
        for (BindKind kind : BindKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private BindKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((BindKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((BindKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Defines which ancestors are considered for a match.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::AncestorMatchMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 871,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::AncestorMatchMode", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinder17AncestorMatchModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinder17AncestorMatchModeE")
  //</editor-fold>
  public enum AncestorMatchMode implements Native.ComparableLower {
    /// All ancestors.
    AMM_All(0),
    /// Direct parent only.
    AMM_ParentOnly(AMM_All.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AncestorMatchMode valueOf(int val) {
      AncestorMatchMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AncestorMatchMode[] VALUES;
      private static final AncestorMatchMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AncestorMatchMode kind : AncestorMatchMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AncestorMatchMode[min < 0 ? (1-min) : 0];
        VALUES = new AncestorMatchMode[max >= 0 ? (1+max) : 0];
        for (AncestorMatchMode kind : AncestorMatchMode.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private AncestorMatchMode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AncestorMatchMode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AncestorMatchMode)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::~ASTMatchFinder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 878,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::~ASTMatchFinder", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinderD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns true if the given class is directly or indirectly derived
  /// from a base type matching \c base.
  ///
  /// A class is considered to be also derived from itself.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::classIsDerivedFrom">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 884,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::classIsDerivedFrom", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinder18classIsDerivedFromEPKNS_13CXXRecordDeclERKNS1_7MatcherINS_9NamedDeclEEEPNS1_21BoundNodesTreeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinder18classIsDerivedFromEPKNS_13CXXRecordDeclERKNS1_7MatcherINS_9NamedDeclEEEPNS1_21BoundNodesTreeBuilderE")
  //</editor-fold>
  public abstract /*virtual*/ boolean classIsDerivedFrom(/*const*/ CXXRecordDecl /*P*/ Declaration, 
                    final /*const*/ Matcher<NamedDecl> /*&*/ Base, 
                    BoundNodesTreeBuilder /*P*/ Builder)/* = 0*/;

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::matchesChildOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 889,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::matchesChildOf", NM="Tpl__ZN5clang12ast_matchers8internal14ASTMatchFinder14matchesChildOfERKT_RKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_13TraversalKindENS2_8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers8internal14ASTMatchFinder14matchesChildOfERKT_RKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_13TraversalKindENS2_8BindKindE")
  //</editor-fold>
  public </*typename*/ T> boolean matchesChildOf$T(final /*const*/ T /*&*/ Node, 
                  final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                  BoundNodesTreeBuilder /*P*/ Builder, 
                  TraversalKind Traverse, 
                  BindKind Bind) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::matchesDescendantOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 906,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::matchesDescendantOf", NM="Tpl__ZN5clang12ast_matchers8internal14ASTMatchFinder19matchesDescendantOfERKT_RKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers8internal14ASTMatchFinder19matchesDescendantOfERKT_RKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_8BindKindE")
  //</editor-fold>
  public </*typename*/ T> boolean matchesDescendantOf$T(final /*const*/ T /*&*/ Node, 
                       final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                       BoundNodesTreeBuilder /*P*/ Builder, 
                       BindKind Bind) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // FIXME: Implement support for BindKind.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::matchesAncestorOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 923,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::matchesAncestorOf", NM="Tpl__ZN5clang12ast_matchers8internal14ASTMatchFinder17matchesAncestorOfERKT_RKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_17AncestorMatchModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=Tpl__ZN5clang12ast_matchers8internal14ASTMatchFinder17matchesAncestorOfERKT_RKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_17AncestorMatchModeE")
  //</editor-fold>
  public </*typename*/ T> boolean matchesAncestorOf$T(final /*const*/ T /*&*/ Node, 
                     final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                     BoundNodesTreeBuilder /*P*/ Builder, 
                     AncestorMatchMode MatchMode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::getASTContext">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 936,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::getASTContext", NM="_ZNK5clang12ast_matchers8internal14ASTMatchFinder13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZNK5clang12ast_matchers8internal14ASTMatchFinder13getASTContextEv")
  //</editor-fold>
  public abstract /*virtual*/ ASTContext /*&*/ getASTContext() /*const*//* = 0*/;

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::matchesChildOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 939,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::matchesChildOf", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinder14matchesChildOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_13TraversalKindENS2_8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinder14matchesChildOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_13TraversalKindENS2_8BindKindE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean matchesChildOf(final /*const*/ DynTypedNode /*&*/ Node, 
                final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                BoundNodesTreeBuilder /*P*/ Builder, 
                TraversalKind Traverse, 
                BindKind Bind)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::matchesDescendantOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 945,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::matchesDescendantOf", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinder19matchesDescendantOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_8BindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinder19matchesDescendantOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_8BindKindE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean matchesDescendantOf(final /*const*/ DynTypedNode /*&*/ Node, 
                     final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                     BoundNodesTreeBuilder /*P*/ Builder, 
                     BindKind Bind)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::matchesAncestorOf">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 950,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::matchesAncestorOf", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinder17matchesAncestorOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_17AncestorMatchModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinder17matchesAncestorOfERKNS_15ast_type_traits12DynTypedNodeERKNS1_15DynTypedMatcherEPNS1_21BoundNodesTreeBuilderENS2_17AncestorMatchModeE")
  //</editor-fold>
  protected abstract /*virtual*/ boolean matchesAncestorOf(final /*const*/ DynTypedNode /*&*/ Node, 
                   final /*const*/ DynTypedMatcher /*&*/ Matcher, 
                   BoundNodesTreeBuilder /*P*/ Builder, 
                   AncestorMatchMode MatchMode)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::ASTMatchFinder::ASTMatchFinder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 851,
   FQN="clang::ast_matchers::internal::ASTMatchFinder::ASTMatchFinder", NM="_ZN5clang12ast_matchers8internal14ASTMatchFinderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchFinder.cpp -nm=_ZN5clang12ast_matchers8internal14ASTMatchFinderC1Ev")
  //</editor-fold>
  public /*inline*/ ASTMatchFinder() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
