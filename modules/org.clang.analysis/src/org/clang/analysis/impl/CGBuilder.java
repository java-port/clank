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

import org.clank.support.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import static org.clang.analysis.impl.CallGraphStatics.*;

/// A helper class, which walks the AST and locates all the call sites in the
/// given function body.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 31,
 FQN="(anonymous namespace)::CGBuilder", NM="_ZN12_GLOBAL__N_19CGBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN12_GLOBAL__N_19CGBuilderE")
//</editor-fold>
public class CGBuilder implements /*public*/ StmtVisitorVoid<CGBuilder> {
  private CallGraph /*P*/ G;
  private CallGraphNode /*P*/ CallerNode;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGBuilder::CGBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 36,
   FQN="(anonymous namespace)::CGBuilder::CGBuilder", NM="_ZN12_GLOBAL__N_19CGBuilderC1EPN5clang9CallGraphEPNS1_13CallGraphNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN12_GLOBAL__N_19CGBuilderC1EPN5clang9CallGraphEPNS1_13CallGraphNodeE")
  //</editor-fold>
  public CGBuilder(CallGraph /*P*/ g, CallGraphNode /*P*/ N) {
    // : StmtVisitor<CGBuilder>(), G(g), CallerNode(N) 
    //START JInit
    $StmtVisitor();
    this.G = g;
    this.CallerNode = N;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGBuilder::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 39,
   FQN="(anonymous namespace)::CGBuilder::VisitStmt", NM="_ZN12_GLOBAL__N_19CGBuilder9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN12_GLOBAL__N_19CGBuilder9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    VisitChildren(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGBuilder::getDeclFromCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 41,
   FQN="(anonymous namespace)::CGBuilder::getDeclFromCall", NM="_ZN12_GLOBAL__N_19CGBuilder15getDeclFromCallEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN12_GLOBAL__N_19CGBuilder15getDeclFromCallEPN5clang8CallExprE")
  //</editor-fold>
  public Decl /*P*/ getDeclFromCall(CallExpr /*P*/ CE) {
    {
      FunctionDecl /*P*/ CalleeDecl = CE.getDirectCallee();
      if ((CalleeDecl != null)) {
        return CalleeDecl;
      }
    }
    
    // Simple detection of a call through a block.
    Expr /*P*/ CEE = CE.getCallee().IgnoreParenImpCasts();
    {
      BlockExpr /*P*/ Block = dyn_cast_BlockExpr(CEE);
      if ((Block != null)) {
        NumBlockCallEdges.$postInc(0);
        return Block.getBlockDecl();
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGBuilder::addCalledDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 55,
   FQN="(anonymous namespace)::CGBuilder::addCalledDecl", NM="_ZN12_GLOBAL__N_19CGBuilder13addCalledDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN12_GLOBAL__N_19CGBuilder13addCalledDeclEPN5clang4DeclE")
  //</editor-fold>
  public void addCalledDecl(Decl /*P*/ D) {
    if (G.includeInGraph(D)) {
      CallGraphNode /*P*/ CalleeNode = G.getOrInsertNode(D);
      CallerNode.addCallee(CalleeNode, G);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGBuilder::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 62,
   FQN="(anonymous namespace)::CGBuilder::VisitCallExpr", NM="_ZN12_GLOBAL__N_19CGBuilder13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN12_GLOBAL__N_19CGBuilder13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ CE) {
    {
      Decl /*P*/ D = getDeclFromCall(CE);
      if ((D != null)) {
        addCalledDecl(D);
      }
    }
  }

  
  // Adds may-call edges for the ObjC message sends.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGBuilder::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 68,
   FQN="(anonymous namespace)::CGBuilder::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_19CGBuilder20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN12_GLOBAL__N_19CGBuilder20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public void VisitObjCMessageExpr(ObjCMessageExpr /*P*/ ME) {
    {
      ObjCInterfaceDecl /*P*/ IDecl = ME.getReceiverInterface();
      if ((IDecl != null)) {
        Selector Sel = ME.getSelector();
        
        // Find the callee definition within the same translation unit.
        Decl /*P*/ D = null;
        if (ME.isInstanceMessage()) {
          D = IDecl.lookupPrivateMethod(Sel);
        } else {
          D = IDecl.lookupPrivateClassMethod(Sel);
        }
        if ((D != null)) {
          addCalledDecl(D);
          NumObjCCallEdges.$postInc(0);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGBuilder::VisitChildren">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 85,
   FQN="(anonymous namespace)::CGBuilder::VisitChildren", NM="_ZN12_GLOBAL__N_19CGBuilder13VisitChildrenEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN12_GLOBAL__N_19CGBuilder13VisitChildrenEPN5clang4StmtE")
  //</editor-fold>
  public void VisitChildren(Stmt /*P*/ S) {
    for (Stmt /*P*/ SubStmt : S.children())  {
      if ((SubStmt != null)) {
        /*J:ToBase*/StmtVisitorVoid /*P*/ .super.Visit(SubStmt);
      }
    }
  }

  
  @Override public String toString() {
    return "" + "G=" + G // NOI18N
              + ", CallerNode=" + CallerNode // NOI18N
              + super.toString(); // NOI18N
  }
}
