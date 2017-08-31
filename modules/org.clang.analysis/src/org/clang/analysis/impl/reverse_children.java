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

package org.clang.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::reverse_children">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 315,
 FQN="(anonymous namespace)::reverse_children", NM="_ZN12_GLOBAL__N_116reverse_childrenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_116reverse_childrenE")
//</editor-fold>
public class reverse_children implements Destructors.ClassWithDestructor {
  private SmallVector<Stmt /*P*/ > childrenBuf;
  private ArrayRef<Stmt /*P*/ > children;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::reverse_children::reverse_children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 327,
   FQN="(anonymous namespace)::reverse_children::reverse_children", NM="_ZN12_GLOBAL__N_116reverse_childrenC1EPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_116reverse_childrenC1EPN5clang4StmtE")
  //</editor-fold>
  public reverse_children(Stmt /*P*/ S) {
    // : childrenBuf(), children() 
    //START JInit
    this.childrenBuf = new SmallVector<Stmt /*P*/ >(12, (Stmt /*P*/ )null);
    this.children = new ArrayRef<Stmt /*P*/ >(true);
    //END JInit
    {
      CallExpr /*P*/ CE = dyn_cast_CallExpr(S);
      if ((CE != null)) {
        children.$assignMove(CE.getRawSubExprs());
        return;
      }
    }
    switch (S.getStmtClass()) {
     case InitListExprClass:
      {
        InitListExpr /*P*/ IE = cast_InitListExpr(S);
        children.$assignMove(llvm.makeArrayRef(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, IE.getInits())), 
                IE.getNumInits()));
        return;
      }
     default:
      break;
    }
    
    // Default case for all other statements.
    for (Stmt /*P*/ SubStmt : S.children())  {
      childrenBuf.push_back(SubStmt);
    }
    
    // This needs to be done *after* childrenBuf has been populated.
    children.$assignMove(new ArrayRef<Stmt /*P*/ >(childrenBuf, true));
  }

  
  /*typedef ArrayRef<Stmt *>::reverse_iterator iterator*/
//  public final class iterator extends std.reverse_iterator<Stmt /*P*/ /*const*/>{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::reverse_children::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 322,
   FQN="(anonymous namespace)::reverse_children::begin", NM="_ZNK12_GLOBAL__N_116reverse_children5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_116reverse_children5beginEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ /*const*/> begin() /*const*/ {
    return children.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::reverse_children::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 323,
   FQN="(anonymous namespace)::reverse_children::end", NM="_ZNK12_GLOBAL__N_116reverse_children3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_116reverse_children3endEv")
  //</editor-fold>
  public std.reverse_iterator<Stmt /*P*/ /*const*/> end() /*const*/ {
    return children.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::reverse_children::~reverse_children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 315,
   FQN="(anonymous namespace)::reverse_children::~reverse_children", NM="_ZN12_GLOBAL__N_116reverse_childrenD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_116reverse_childrenD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    childrenBuf.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "childrenBuf=" + childrenBuf // NOI18N
              + ", children=" + children; // NOI18N
  }
}
