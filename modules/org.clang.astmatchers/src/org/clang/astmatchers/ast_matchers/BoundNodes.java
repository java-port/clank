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

package org.clang.astmatchers.ast_matchers;

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


/// \brief Maps string IDs to AST nodes matched by parts of a matcher.
///
/// The bound nodes are generated by calling \c bind("id") on the node matchers
/// of the nodes we want to access later.
///
/// The instances of BoundNodes are created by \c MatchFinder when the user's
/// callbacks are executed every time a match is found.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 68,
 FQN="clang::ast_matchers::BoundNodes", NM="_ZN5clang12ast_matchers10BoundNodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=_ZN5clang12ast_matchers10BoundNodesE")
//</editor-fold>
public class BoundNodes implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Returns the AST node bound to \c ID.
  ///
  /// Returns NULL if there was no node bound to \c ID or if there is a node but
  /// it cannot be converted to the specified type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::getNodeAs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 75,
   FQN="clang::ast_matchers::BoundNodes::getNodeAs", NM="Tpl__ZNK5clang12ast_matchers10BoundNodes9getNodeAsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=Tpl__ZNK5clang12ast_matchers10BoundNodes9getNodeAsEN4llvm9StringRefE")
  //</editor-fold>
  public </*typename*/ T> /*const*/ T /*P*/ getNodeAs(StringRef ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Deprecated. Please use \c getNodeAs instead.
  /// @{
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::getDeclAs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 82,
   FQN="clang::ast_matchers::BoundNodes::getDeclAs", NM="Tpl__ZNK5clang12ast_matchers10BoundNodes9getDeclAsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=Tpl__ZNK5clang12ast_matchers10BoundNodes9getDeclAsEN4llvm9StringRefE")
  //</editor-fold>
  public </*typename*/ T> /*const*/ T /*P*/ getDeclAs(StringRef ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::getStmtAs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 86,
   FQN="clang::ast_matchers::BoundNodes::getStmtAs", NM="Tpl__ZNK5clang12ast_matchers10BoundNodes9getStmtAsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=Tpl__ZNK5clang12ast_matchers10BoundNodes9getStmtAsEN4llvm9StringRefE")
  //</editor-fold>
  public </*typename*/ T> /*const*/ T /*P*/ getStmtAs(StringRef ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// @}
  
  /// \brief Type of mapping from binding identifiers to bound nodes. This type
  /// is an associative container with a key type of \c std::string and a value
  /// type of \c clang::ast_type_traits::DynTypedNode
  /*typedef internal::BoundNodesMap::IDToNodeMap IDToNodeMap*/
//  public final class IDToNodeMap extends std.map<std.string, DynTypedNode>{ };
  
  /// \brief Retrieve mapping from binding identifiers to bound nodes.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::getMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 97,
   FQN="clang::ast_matchers::BoundNodes::getMap", NM="_ZNK5clang12ast_matchers10BoundNodes6getMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=_ZNK5clang12ast_matchers10BoundNodes6getMapEv")
  //</editor-fold>
  public /*const*/std.mapTypeType<std.string, DynTypedNode> /*&*/ getMap() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// \brief Create BoundNodes from a pre-filled map of bindings.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::BoundNodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 103,
   FQN="clang::ast_matchers::BoundNodes::BoundNodes", NM="_ZN5clang12ast_matchers10BoundNodesC1ERNS0_8internal13BoundNodesMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=_ZN5clang12ast_matchers10BoundNodesC1ERNS0_8internal13BoundNodesMapE")
  //</editor-fold>
  private BoundNodes(final BoundNodesMap /*&*/ MyBoundNodes) {
    // : MyBoundNodes(MyBoundNodes) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  private BoundNodesMap MyBoundNodes;
  
  /*friend  class internal::BoundNodesTreeBuilder*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::BoundNodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 68,
   FQN="clang::ast_matchers::BoundNodes::BoundNodes", NM="_ZN5clang12ast_matchers10BoundNodesC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=_ZN5clang12ast_matchers10BoundNodesC1ERKS1_")
  //</editor-fold>
  public /*inline*/ BoundNodes(final /*const*/ BoundNodes /*&*/ $Prm0) {
    // : MyBoundNodes(.MyBoundNodes) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::BoundNodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 68,
   FQN="clang::ast_matchers::BoundNodes::BoundNodes", NM="_ZN5clang12ast_matchers10BoundNodesC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=_ZN5clang12ast_matchers10BoundNodesC1EOS1_")
  //</editor-fold>
  public /*inline*/ BoundNodes(JD$Move _dparam, final BoundNodes /*&&*/$Prm0) {
    // : MyBoundNodes(static_cast<BoundNodes &&>().MyBoundNodes) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::~BoundNodes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 68,
   FQN="clang::ast_matchers::BoundNodes::~BoundNodes", NM="_ZN5clang12ast_matchers10BoundNodesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=_ZN5clang12ast_matchers10BoundNodesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::BoundNodes::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchers.h", line = 68,
   FQN="clang::ast_matchers::BoundNodes::operator=", NM="_ZN5clang12ast_matchers10BoundNodesaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/modernize/UseDefaultCheck.cpp -nm=_ZN5clang12ast_matchers10BoundNodesaSEOS1_")
  //</editor-fold>
  public /*inline*/ BoundNodes /*&*/ $assignMove(final BoundNodes /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "MyBoundNodes=" + MyBoundNodes; // NOI18N
  }
}
