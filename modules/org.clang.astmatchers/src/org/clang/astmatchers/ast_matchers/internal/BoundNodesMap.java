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


/// \brief Internal version of BoundNodes. Holds all the bound nodes.
//<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 121,
 FQN="clang::ast_matchers::internal::BoundNodesMap", NM="_ZN5clang12ast_matchers8internal13BoundNodesMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal13BoundNodesMapE")
//</editor-fold>
public class BoundNodesMap implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Adds \c Node to the map with key \c ID.
  ///
  /// The node's base type should be in NodeBaseType or it will be unaccessible.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::addNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 126,
   FQN="clang::ast_matchers::internal::BoundNodesMap::addNode", NM="_ZN5clang12ast_matchers8internal13BoundNodesMap7addNodeEN4llvm9StringRefERKNS_15ast_type_traits12DynTypedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal13BoundNodesMap7addNodeEN4llvm9StringRefERKNS_15ast_type_traits12DynTypedNodeE")
  //</editor-fold>
  public void addNode(StringRef ID, final /*const*/ DynTypedNode /*&*/ DynNode) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the AST node bound to \c ID.
  ///
  /// Returns NULL if there was no node bound to \c ID or if there is a node but
  /// it cannot be converted to the specified type.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::getNodeAs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 135,
   FQN="clang::ast_matchers::internal::BoundNodesMap::getNodeAs", NM="Tpl__ZNK5clang12ast_matchers8internal13BoundNodesMap9getNodeAsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=Tpl__ZNK5clang12ast_matchers8internal13BoundNodesMap9getNodeAsEN4llvm9StringRefE")
  //</editor-fold>
  public </*typename*/ T> /*const*/ T /*P*/ getNodeAs(StringRef ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::getNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 143,
   FQN="clang::ast_matchers::internal::BoundNodesMap::getNode", NM="_ZNK5clang12ast_matchers8internal13BoundNodesMap7getNodeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal13BoundNodesMap7getNodeEN4llvm9StringRefE")
  //</editor-fold>
  public DynTypedNode getNode(StringRef ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Imposes an order on BoundNodesMaps.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::operator<">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 152,
   FQN="clang::ast_matchers::internal::BoundNodesMap::operator<", NM="_ZNK5clang12ast_matchers8internal13BoundNodesMapltERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal13BoundNodesMapltERKS2_")
  //</editor-fold>
  public boolean $less(final /*const*/ BoundNodesMap /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief A map from IDs to the bound nodes.
  ///
  /// Note that we're using std::map here, as for memoization:
  /// - we need a comparison operator
  /// - we need an assignment operator
  /*typedef std::map<std::string, ast_type_traits::DynTypedNode> IDToNodeMap*/
//  public final class IDToNodeMap extends std.map<std.string, DynTypedNode>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::getMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 163,
   FQN="clang::ast_matchers::internal::BoundNodesMap::getMap", NM="_ZNK5clang12ast_matchers8internal13BoundNodesMap6getMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal13BoundNodesMap6getMapEv")
  //</editor-fold>
  public /*const*/std.mapTypeType<std.string, DynTypedNode> /*&*/ getMap() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns \c true if this \c BoundNodesMap can be compared, i.e. all
  /// stored nodes have memoization data.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::isComparable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 169,
   FQN="clang::ast_matchers::internal::BoundNodesMap::isComparable", NM="_ZNK5clang12ast_matchers8internal13BoundNodesMap12isComparableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZNK5clang12ast_matchers8internal13BoundNodesMap12isComparableEv")
  //</editor-fold>
  public boolean isComparable() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private std.mapTypeType<std.string, DynTypedNode> NodeMap;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::BoundNodesMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 121,
   FQN="clang::ast_matchers::internal::BoundNodesMap::BoundNodesMap", NM="_ZN5clang12ast_matchers8internal13BoundNodesMapC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal13BoundNodesMapC1EOS2_")
  //</editor-fold>
  public /*inline*/ BoundNodesMap(JD$Move _dparam, final BoundNodesMap /*&&*/$Prm0) {
    // : NodeMap(static_cast<BoundNodesMap &&>().NodeMap) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 121,
   FQN="clang::ast_matchers::internal::BoundNodesMap::operator=", NM="_ZN5clang12ast_matchers8internal13BoundNodesMapaSEOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal13BoundNodesMapaSEOS2_")
  //</editor-fold>
  public /*inline*/ BoundNodesMap /*&*/ $assignMove(final BoundNodesMap /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::BoundNodesMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 121,
   FQN="clang::ast_matchers::internal::BoundNodesMap::BoundNodesMap", NM="_ZN5clang12ast_matchers8internal13BoundNodesMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal13BoundNodesMapC1Ev")
  //</editor-fold>
  public /*inline*/ BoundNodesMap() {
    // : NodeMap() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::BoundNodesMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 121,
   FQN="clang::ast_matchers::internal::BoundNodesMap::BoundNodesMap", NM="_ZN5clang12ast_matchers8internal13BoundNodesMapC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal13BoundNodesMapC1ERKS2_")
  //</editor-fold>
  public /*inline*/ BoundNodesMap(final /*const*/ BoundNodesMap /*&*/ $Prm0) {
    // : NodeMap(.NodeMap) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::~BoundNodesMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 121,
   FQN="clang::ast_matchers::internal::BoundNodesMap::~BoundNodesMap", NM="_ZN5clang12ast_matchers8internal13BoundNodesMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal13BoundNodesMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_matchers::internal::BoundNodesMap::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/ASTMatchers/ASTMatchersInternal.h", line = 121,
   FQN="clang::ast_matchers::internal::BoundNodesMap::operator=", NM="_ZN5clang12ast_matchers8internal13BoundNodesMapaSERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.astmatchers/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ASTMatchers/ASTMatchersInternal.cpp -nm=_ZN5clang12ast_matchers8internal13BoundNodesMapaSERKS2_")
  //</editor-fold>
  public /*inline*/ BoundNodesMap /*&*/ $assign(final /*const*/ BoundNodesMap /*&*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "NodeMap=" + NodeMap; // NOI18N
  }
}
