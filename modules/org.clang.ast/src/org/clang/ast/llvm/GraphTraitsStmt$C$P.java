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

package org.clang.ast.llvm;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import org.llvm.adt.java.GraphTraits;
import static org.llvm.adt.java.GraphTraits.*;

//<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::Stmt * >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtGraphTraits.h", line = 55,
 FQN="llvm::GraphTraits<const clang::Stmt * >", NM="_ZN4llvm11GraphTraitsIPKN5clang4StmtEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4StmtEEE")
//</editor-fold>
public class/*struct*/ GraphTraitsStmt$C$P implements GraphTraits<Stmt, Stmt, Stmt> {
  /*typedef const clang::Stmt NodeType*/
//  public final class NodeType extends /*const*/ Stmt{ };
  /*typedef const clang::Stmt *NodeRef*/
//  public final class NodeRef extends /*const*/ Stmt /*P*/ { };
  /*typedef clang::Stmt::const_child_iterator ChildIteratorType*/
//  public final class ChildIteratorType extends ConstStmtIterator{ };
  /*typedef llvm::df_iterator<const clang::Stmt *> nodes_iterator*/
//  public final class nodes_iterator extends df_iterator</*const*/ Stmt /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::Stmt * >::getEntryNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtGraphTraits.h", line = 61,
   FQN="llvm::GraphTraits<const clang::Stmt * >::getEntryNode", NM="_ZN4llvm11GraphTraitsIPKN5clang4StmtEE12getEntryNodeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4StmtEE12getEntryNodeES4_")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getEntryNode(/*const*/ Stmt /*P*/ S) {
    return S;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::Stmt * >::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtGraphTraits.h", line = 63,
   FQN="llvm::GraphTraits<const clang::Stmt * >::child_begin", NM="_ZN4llvm11GraphTraitsIPKN5clang4StmtEE11child_beginES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4StmtEE11child_beginES4_")
  //</editor-fold>
  public /*inline*/ ConstStmtIterator child_begin(/*const*/ Stmt /*P*/ N) {
    if ((N != null)) {
      return N.child_begin$Const();
    } else {
      return new ConstStmtIterator();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::Stmt * >::child_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtGraphTraits.h", line = 68,
   FQN="llvm::GraphTraits<const clang::Stmt * >::child_end", NM="_ZN4llvm11GraphTraitsIPKN5clang4StmtEE9child_endES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4StmtEE9child_endES4_")
  //</editor-fold>
  public /*inline*/ ConstStmtIterator child_end(/*const*/ Stmt /*P*/ N) {
    if ((N != null)) {
      return N.child_end$Const();
    } else {
      return new ConstStmtIterator();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::Stmt * >::nodes_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtGraphTraits.h", line = 73,
   FQN="llvm::GraphTraits<const clang::Stmt * >::nodes_begin", NM="_ZN4llvm11GraphTraitsIPKN5clang4StmtEE11nodes_beginES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4StmtEE11nodes_beginES4_")
  //</editor-fold>
  public df_iterator</*const*/ Stmt /*P*/, Stmt, Stmt> nodes_begin(/*const*/ Stmt /*P*/ S) {
    return df_begin(this, S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::GraphTraits<const clang::Stmt * >::nodes_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtGraphTraits.h", line = 77,
   FQN="llvm::GraphTraits<const clang::Stmt * >::nodes_end", NM="_ZN4llvm11GraphTraitsIPKN5clang4StmtEE9nodes_endES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN4llvm11GraphTraitsIPKN5clang4StmtEE9nodes_endES4_")
  //</editor-fold>
  public df_iterator</*const*/ Stmt /*P*/, Stmt, Stmt> nodes_end(/*const*/ Stmt /*P*/ S) {
    return df_end(this, S);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final GraphTraitsStmt$C$P INSTANCE = new GraphTraitsStmt$C$P();
  
  public static GraphTraitsStmt$C$P $GTraits() {
  
    return INSTANCE;
  
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
