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


/// \brief Matcher that works on a \c DynTypedNode.
///
/// It is constructed from a \c Matcher<T> object and redirects most calls to
/// underlying matcher.
/// It checks whether the \c DynTypedNode is convertible into the type of the
/// underlying matcher and then do the actual match on the actual node, or
/// return false if it is not convertible.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 315,
 FQN="clang::ast_matchers::internal::DynTypedMatcher", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcherE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcherE")
//</editor-fold>
public class DynTypedMatcher implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Takes ownership of the provided implementation pointer.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::DynTypedMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 319,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::DynTypedMatcher", NM="Tpl__ZN5clang12ast_matchers8internal15DynTypedMatcherC1EPNS1_16MatcherInterfaceIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZN5clang12ast_matchers8internal15DynTypedMatcherC1EPNS1_16MatcherInterfaceIT_EE")
  //</editor-fold>
  public </*typename*/ T> DynTypedMatcher(MatcherInterface<T> /*P*/ Implementation) {
    // : AllowBind(false), SupportedKind(ASTNodeKind::getFromNodeKind<T>()), RestrictKind(SupportedKind), Implementation(Implementation) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Construct from a variadic function.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::VariadicOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 325,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::VariadicOperator", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcher16VariadicOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcher16VariadicOperatorE")
  //</editor-fold>
  public enum VariadicOperator implements Native.ComparableLower {
    /// \brief Matches nodes for which all provided matchers match.
    VO_AllOf(0),
    /// \brief Matches nodes for which at least one of the provided matchers
    /// matches.
    VO_AnyOf(VO_AllOf.getValue() + 1),
    /// \brief Matches nodes for which at least one of the provided matchers
    /// matches, but doesn't stop at the first match.
    VO_EachOf(VO_AnyOf.getValue() + 1),
    /// \brief Matches nodes that do not match the provided matcher.
    ///
    /// Uses the variadic matcher interface, but fails if
    /// InnerMatchers.size() != 1.
    VO_UnaryNot(VO_EachOf.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VariadicOperator valueOf(int val) {
      VariadicOperator out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VariadicOperator[] VALUES;
      private static final VariadicOperator[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VariadicOperator kind : VariadicOperator.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VariadicOperator[min < 0 ? (1-min) : 0];
        VALUES = new VariadicOperator[max >= 0 ? (1+max) : 0];
        for (VariadicOperator kind : VariadicOperator.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private VariadicOperator(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((VariadicOperator)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((VariadicOperator)obj).value);}
    //</editor-fold>
  };
  // namespace
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::constructVariadic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 112,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::constructVariadic", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcher17constructVariadicENS2_16VariadicOperatorENS_15ast_type_traits11ASTNodeKindESt6vectorIS2_SaIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcher17constructVariadicENS2_16VariadicOperatorENS_15ast_type_traits11ASTNodeKindESt6vectorIS2_SaIS2_EE")
  //</editor-fold>
  public static DynTypedMatcher constructVariadic(DynTypedMatcher.VariadicOperator Op, 
                   ASTNodeKind SupportedKind, 
                   std.vector<DynTypedMatcher> InnerMatchers) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get a "true" matcher for \p NodeKind.
  ///
  /// It only checks that the node is of the right kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::trueMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 163,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::trueMatcher", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcher11trueMatcherENS_15ast_type_traits11ASTNodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcher11trueMatcherENS_15ast_type_traits11ASTNodeKindE")
  //</editor-fold>
  public static DynTypedMatcher trueMatcher(ASTNodeKind NodeKind) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::setAllowBind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 350,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::setAllowBind", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcher12setAllowBindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcher12setAllowBindEb")
  //</editor-fold>
  public void setAllowBind(boolean AB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Check whether this matcher could ever match a node of kind \p Kind.
  /// \return \c false if this matcher will never match such a node. Otherwise,
  /// return \c true.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::canMatchNodesOfKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 168,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::canMatchNodesOfKind", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher19canMatchNodesOfKindENS_15ast_type_traits11ASTNodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher19canMatchNodesOfKindENS_15ast_type_traits11ASTNodeKindE")
  //</editor-fold>
  public boolean canMatchNodesOfKind(ASTNodeKind Kind) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return a matcher that points to the same implementation, but
  ///   restricts the node types for \p Kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::dynCastTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 173,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::dynCastTo", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher9dynCastToENS_15ast_type_traits11ASTNodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher9dynCastToENS_15ast_type_traits11ASTNodeKindE")
  //</editor-fold>
  public DynTypedMatcher dynCastTo(/*const*/ ASTNodeKind Kind) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns true if the matcher matches the given \c DynNode.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::matches">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 182,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::matches", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher7matchesERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher7matchesERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE")
  //</editor-fold>
  public boolean matches(final /*const*/ DynTypedNode /*&*/ DynNode, 
         ASTMatchFinder /*P*/ Finder, 
         BoundNodesTreeBuilder /*P*/ Builder) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Same as matches(), but skips the kind check.
  ///
  /// It is faster, but the caller must ensure the node is valid for the
  /// kind of this matcher.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::matchesNoKindCheck">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 196,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::matchesNoKindCheck", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher18matchesNoKindCheckERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher18matchesNoKindCheckERKNS_15ast_type_traits12DynTypedNodeEPNS1_14ASTMatchFinderEPNS1_21BoundNodesTreeBuilderE")
  //</editor-fold>
  public boolean matchesNoKindCheck(final /*const*/ DynTypedNode /*&*/ DynNode, ASTMatchFinder /*P*/ Finder, 
                    BoundNodesTreeBuilder /*P*/ Builder) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Bind the specified \p ID to the matcher.
  /// \return A new matcher with the \p ID bound to it if this matcher supports
  ///   binding. Otherwise, returns an empty \c Optional<>.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::tryBind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 210,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::tryBind", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher7tryBindEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher7tryBindEN4llvm9StringRefE")
  //</editor-fold>
  public Optional<DynTypedMatcher> tryBind(StringRef ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns a unique \p ID for the matcher.
  ///
  /// Casting a Matcher<T> to Matcher<U> creates a matcher that has the
  /// same \c Implementation pointer, but different \c RestrictKind. We need to
  /// include both in the ID to make it unique.
  ///
  /// \c MatcherIDType supports operator< and provides strict weak ordering.
  /*typedef std::pair<ast_type_traits::ASTNodeKind, uint64_t> MatcherIDType*/
//  public final class MatcherIDType extends std.pairTypeULong<ASTNodeKind>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::getID">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 386,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::getID", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher5getIDEv")
  //</editor-fold>
  public std.pairTypeULong<ASTNodeKind> getID() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the type this matcher works on.
  ///
  /// \c matches() will always return false unless the node passed is of this
  /// or a derived type.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::getSupportedKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 397,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::getSupportedKind", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher16getSupportedKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher16getSupportedKindEv")
  //</editor-fold>
  public ASTNodeKind getSupportedKind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns \c true if the passed \c DynTypedMatcher can be converted
  ///   to a \c Matcher<T>.
  ///
  /// This method verifies that the underlying matcher in \c Other can process
  /// nodes of types T.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::canConvertTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 406,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::canConvertTo", NM="Tpl__ZNK5clang12ast_matchers8internal15DynTypedMatcher12canConvertToEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZNK5clang12ast_matchers8internal15DynTypedMatcher12canConvertToEv")
  //</editor-fold>
  public </*typename*/ T> boolean canConvertTo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::canConvertTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp", line = 217,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::canConvertTo", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher12canConvertToENS_15ast_type_traits11ASTNodeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher12canConvertToENS_15ast_type_traits11ASTNodeKindE")
  //</editor-fold>
  public boolean canConvertTo(ASTNodeKind To) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Construct a \c Matcher<T> interface around the dynamic matcher.
  ///
  /// This method asserts that \c canConvertTo() is \c true. Callers
  /// should call \c canConvertTo() first to make sure that \c this is
  /// compatible with T.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::convertTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 416,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::convertTo", NM="Tpl__ZNK5clang12ast_matchers8internal15DynTypedMatcher9convertToEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZNK5clang12ast_matchers8internal15DynTypedMatcher9convertToEv")
  //</editor-fold>
  public </*typename*/ T> Matcher<T> convertTo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Same as \c convertTo(), but does not check that the underlying
  ///   matcher can handle a value of T.
  ///
  /// If it is not compatible, then this matcher will never match anything.
  /*template <typename T> TEMPLATE*/
  
  /// @}
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::unconditionalConvertTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 1264,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::unconditionalConvertTo", NM="Tpl__ZNK5clang12ast_matchers8internal15DynTypedMatcher22unconditionalConvertToEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZNK5clang12ast_matchers8internal15DynTypedMatcher22unconditionalConvertToEv")
  //</editor-fold>
  public /*inline*/ </*typename*/ T> Matcher<T> unconditionalConvertTo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::DynTypedMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 428,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::DynTypedMatcher", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcherC1ENS_15ast_type_traits11ASTNodeKindES4_N4llvm18IntrusiveRefCntPtrINS1_19DynMatcherInterfaceEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcherC1ENS_15ast_type_traits11ASTNodeKindES4_N4llvm18IntrusiveRefCntPtrINS1_19DynMatcherInterfaceEEE")
  //</editor-fold>
  private DynTypedMatcher(ASTNodeKind SupportedKind, 
      ASTNodeKind RestrictKind, 
      IntrusiveRefCntPtr<DynMatcherInterface> Implementation) {
    // : AllowBind(false), SupportedKind(SupportedKind), RestrictKind(RestrictKind), Implementation(std::move(Implementation)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private boolean AllowBind;
  private ASTNodeKind SupportedKind;
  /// \brief A potentially stricter node kind.
  ///
  /// It allows to perform implicit and dynamic cast of matchers without
  /// needing to change \c Implementation.
  private ASTNodeKind RestrictKind;
  private IntrusiveRefCntPtr<DynMatcherInterface> Implementation;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::DynTypedMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 315,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::DynTypedMatcher", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcherC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcherC1EOS2_")
  //</editor-fold>
  public /*inline*/ DynTypedMatcher(JD$Move _dparam, final DynTypedMatcher /*&&*/$Prm0) {
    // : AllowBind(static_cast<DynTypedMatcher &&>().AllowBind), SupportedKind(static_cast<DynTypedMatcher &&>().SupportedKind), RestrictKind(static_cast<DynTypedMatcher &&>().RestrictKind), Implementation(static_cast<DynTypedMatcher &&>().Implementation) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::~DynTypedMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 315,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::~DynTypedMatcher", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcherD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcherD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::DynTypedMatcher">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 315,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::DynTypedMatcher", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcherC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcherC1ERKS2_")
  //</editor-fold>
  public /*inline*/ DynTypedMatcher(final /*const*/ DynTypedMatcher /*&*/ $Prm0) {
    // : AllowBind(.AllowBind), SupportedKind(.SupportedKind), RestrictKind(.RestrictKind), Implementation(.Implementation) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Specialization of the conversion functions for QualType.
  ///
  /// This specialization provides the Matcher<Type>->Matcher<QualType>
  /// conversion that the static API does.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::convertTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 575,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::convertTo", NM="_ZNK5clang12ast_matchers8internal15DynTypedMatcher9convertToINS_8QualTypeEEENS1_7MatcherIT_EEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal15DynTypedMatcher9convertToINS_8QualTypeEEENS1_7MatcherIT_EEv")
  //</editor-fold>
  public /*inline*/ Matcher<QualType> convertTo$QualType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::DynTypedMatcher::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 315,
   FQN="clang::ast_matchers::internal::DynTypedMatcher::operator=", NM="_ZN5clang12ast_matchers8internal15DynTypedMatcheraSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/performance/FasterStringFindCheck.cpp -nm=_ZN5clang12ast_matchers8internal15DynTypedMatcheraSERKS2_")
  //</editor-fold>
  public /*inline*/ DynTypedMatcher /*&*/ $assign(final /*const*/ DynTypedMatcher /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "AllowBind=" + AllowBind // NOI18N
              + ", SupportedKind=" + SupportedKind // NOI18N
              + ", RestrictKind=" + RestrictKind // NOI18N
              + ", Implementation=" + Implementation; // NOI18N
  }
}
