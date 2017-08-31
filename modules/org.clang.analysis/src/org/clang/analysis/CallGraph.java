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

package org.clang.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.llvm.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.support.AdtsupportLlvmGlobals.ViewGraph;


/// \brief The AST-based call graph.
///
/// The call graph extends itself with the given declarations by implementing
/// the recursive AST visitor, which constructs the graph by visiting the given
/// declarations.
//<editor-fold defaultstate="collapsed" desc="clang::CallGraph">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 34,
 FQN="clang::CallGraph", NM="_ZN5clang9CallGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraphE")
//</editor-fold>
public class CallGraph implements /*public*/ RecursiveASTVisitor<CallGraph>, Destructors.ClassWithDestructor {
  /*friend  class CallGraphNode*/
  
  /*typedef llvm::DenseMap<const Decl *, CallGraphNode *> FunctionMapTy*/
//  public final class FunctionMapTy extends DenseMap</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >{ };
  
  /// FunctionMap owns all CallGraphNodes.
  private DenseMap</*const*/ Decl /*P*/ , CallGraphNode /*P*/ > FunctionMap;
  
  /// This is a virtual root node that has edges to all the functions.
  private CallGraphNode /*P*/ Root;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::CallGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 103,
   FQN="clang::CallGraph::CallGraph", NM="_ZN5clang9CallGraphC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraphC1Ev")
  //</editor-fold>
  public CallGraph() {
    // : RecursiveASTVisitor<CallGraph>(), FunctionMap() 
    //START JInit
    $RecursiveASTVisitor();
    this.FunctionMap = new DenseMap</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CallGraphNode /*P*/ )null);
    //END JInit
    Root = getOrInsertNode((Decl /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::~CallGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 107,
   FQN="clang::CallGraph::~CallGraph", NM="_ZN5clang9CallGraphD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraphD0Ev")
  //</editor-fold>
  public void $destroy() {
    llvm.DeleteContainerSeconds(FunctionMap);
    //START JDestroy
    FunctionMap.$destroy();
    RecursiveASTVisitor.super.$destroy$RecursiveASTVisitor();
    //END JDestroy
  }

  
  /// \brief Populate the call graph with the functions in the given
  /// declaration.
  ///
  /// Recursively walks the declaration to find all the dependent Decls as well.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::addToCallGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 53,
   FQN="clang::CallGraph::addToCallGraph", NM="_ZN5clang9CallGraph14addToCallGraphEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph14addToCallGraphEPNS_4DeclE")
  //</editor-fold>
  public void addToCallGraph(Decl /*P*/ D) {
    TraverseDecl(D);
  }

  
  /// \brief Determine if a declaration should be included in the graph.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::includeInGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 111,
   FQN="clang::CallGraph::includeInGraph", NM="_ZN5clang9CallGraph14includeInGraphEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph14includeInGraphEPKNS_4DeclE")
  //</editor-fold>
  public static boolean includeInGraph(/*const*/ Decl /*P*/ D) {
    assert Native.$bool(D);
    if (!D.hasBody()) {
      return false;
    }
    {
      
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        // We skip function template definitions, as their semantics is
        // only determined when they are instantiated.
        if (FD.isDependentContext()) {
          return false;
        }
        
        IdentifierInfo /*P*/ II = FD.getIdentifier();
        if ((II != null) && II.getName().startswith(/*STRINGREF_STR*/"__inline")) {
          return false;
        }
      }
    }
    
    return true;
  }

  
  /// \brief Lookup the node for the given declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::getNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 142,
   FQN="clang::CallGraph::getNode", NM="_ZNK5clang9CallGraph7getNodeEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph7getNodeEPKNS_4DeclE")
  //</editor-fold>
  public CallGraphNode /*P*/ getNode(/*const*/ Decl /*P*/ F) /*const*/ {
    DenseMapIterator</*const*/ Decl /*P*/ , CallGraphNode /*P*/ > I = FunctionMap.find$Const(F);
    if (I.$eq(FunctionMap.end$Const())) {
      return null;
    }
    return I.$arrow().second;
  }

  
  /// \brief Lookup the node for the given declaration. If none found, insert
  /// one into the graph.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::getOrInsertNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 148,
   FQN="clang::CallGraph::getOrInsertNode", NM="_ZN5clang9CallGraph15getOrInsertNodeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph15getOrInsertNodeEPNS_4DeclE")
  //</editor-fold>
  public CallGraphNode /*P*/ getOrInsertNode(Decl /*P*/ F) {
    if ((F != null) && !isa_ObjCMethodDecl(F)) {
      F = F.getCanonicalDecl();
    }
    
    final type$ref<CallGraphNode /*P*/ /*&*/> Node = FunctionMap.ref$at(F);
    if ((Node.$deref() != null)) {
      return Node.$deref();
    }
    
    Node.$set(new CallGraphNode(F));
    // Make Root node a parent of all functions to make sure all are reachable.
    if ((F != null)) {
      Root.addCallee(Node.$deref(), this);
    }
    return Node.$deref();
  }

  
  /// Iterators through all the elements in the graph. Note, this gives
  /// non-deterministic order.
  /*typedef FunctionMapTy::iterator iterator*/
//  public final class iterator extends DenseMapIterator</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >{ };
  /*typedef FunctionMapTy::const_iterator const_iterator*/
//  public final class const_iterator extends DenseMapIterator</*const*/ Decl /*P*/ , CallGraphNode /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 71,
   FQN="clang::CallGraph::begin", NM="_ZN5clang9CallGraph5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph5beginEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ Decl /*P*/ , CallGraphNode /*P*/ > begin() {
    return FunctionMap.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 72,
   FQN="clang::CallGraph::end", NM="_ZN5clang9CallGraph3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph3endEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ Decl /*P*/ , CallGraphNode /*P*/ > end() {
    return FunctionMap.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 73,
   FQN="clang::CallGraph::begin", NM="_ZNK5clang9CallGraph5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph5beginEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ Decl /*P*/ , CallGraphNode /*P*/ > begin$Const() /*const*/ {
    return FunctionMap.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 74,
   FQN="clang::CallGraph::end", NM="_ZNK5clang9CallGraph3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph3endEv")
  //</editor-fold>
  public DenseMapIterator</*const*/ Decl /*P*/ , CallGraphNode /*P*/ > end$Const() /*const*/ {
    return FunctionMap.end$Const();
  }

  
  /// \brief Get the number of nodes in the graph.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 77,
   FQN="clang::CallGraph::size", NM="_ZNK5clang9CallGraph4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return FunctionMap.size();
  }

  
  /// \ brief Get the virtual root of the graph, all the functions available
  /// externally are represented as callees of the node.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::getRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 81,
   FQN="clang::CallGraph::getRoot", NM="_ZNK5clang9CallGraph7getRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph7getRootEv")
  //</editor-fold>
  public CallGraphNode /*P*/ getRoot() /*const*/ {
    return Root;
  }

  
  /// Iterators through all the nodes of the graph that have no parent. These
  /// are the unreachable nodes, which are either unused or are due to us
  /// failing to add a call edge due to the analysis imprecision.
  /*typedef llvm::SetVector<CallGraphNode *>::iterator nodes_iterator*/
//  public final class nodes_iterator extends __normal_iterator</*const*/ CallGraphNode /*P*/ , vector<CallGraphNode /*P*/ > >{ };
  /*typedef llvm::SetVector<CallGraphNode *>::const_iterator const_nodes_iterator*/
//  public final class const_nodes_iterator extends __normal_iterator</*const*/ CallGraphNode /*P*/ , vector<CallGraphNode /*P*/ > >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 163,
   FQN="clang::CallGraph::print", NM="_ZNK5clang9CallGraph5printERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph5printERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    ReversePostOrderTraversal</*const*/ CallGraph /*P*/, CallGraphNode> RPOT = null;
    try {
      OS.$out(/*KEEP_STR*/" --- Call graph Dump --- \n");
      
      // We are going to print the graph in reverse post order, partially, to make
      // sure the output is deterministic.
      RPOT/*J*/= new ReversePostOrderTraversal</*const*/ CallGraph /*P*/, CallGraphNode >(GraphTraitsCallGraph$P.$GTraits(), this);
      for (std.reverse_iterator</*const*/ CallGraphNode /*&*/ > I = RPOT.begin(), E = RPOT.end(); $noteq_reverse_iterator$C(I, E); I.$preInc()) {
        /*const*/ CallGraphNode /*P*/ N = I.$star();
        
        OS.$out(/*KEEP_STR*/"  Function: ");
        if (N == Root) {
          OS.$out(/*KEEP_STR*/"< root >");
        } else {
          N.print(OS);
        }
        
        OS.$out(/*KEEP_STR*/" calls: ");
        for (type$ptr<CallGraphNode/*P*/> CI = $tryClone(N.begin$Const()), 
            /*P*/ CE = $tryClone(N.end$Const()); $noteq_ptr(CI, CE); CI.$preInc()) {
          assert (CI.$star() != Root) : "No one can call the root node.";
          (CI.$star()).print(OS);
          OS.$out(/*KEEP_STR*/$SPACE);
        }
        OS.$out_char($$LF);
      }
      OS.flush();
    } finally {
      if (RPOT != null) { RPOT.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 191,
   FQN="clang::CallGraph::dump", NM="_ZNK5clang9CallGraph4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(llvm.errs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::viewGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 195,
   FQN="clang::CallGraph::viewGraph", NM="_ZNK5clang9CallGraph9viewGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph9viewGraphEv")
  //</editor-fold>
  public void viewGraph() /*const*/ {
    ViewGraph(this, new Twine(/*KEEP_STR*/"CallGraph"));
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::addNodesForBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 94,
   FQN="clang::CallGraph::addNodesForBlocks", NM="_ZN5clang9CallGraph17addNodesForBlocksEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph17addNodesForBlocksEPNS_11DeclContextE")
  //</editor-fold>
  public void addNodesForBlocks(DeclContext /*P*/ D) {
    {
      BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
      if ((BD != null)) {
        addNodeForDecl(BD, true);
      }
    }
    
    for (Decl /*P*/ I : D.decls())  {
      {
        DeclContext /*P*/ DC = dyn_cast_DeclContext(I);
        if ((DC != null)) {
          addNodesForBlocks(DC);
        }
      }
    }
  }

  
  /// Part of recursive declaration visitation. We recursively visit all the
  /// declarations to collect the root functions.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 97,
   FQN="clang::CallGraph::VisitFunctionDecl", NM="_ZN5clang9CallGraph17VisitFunctionDeclEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph17VisitFunctionDeclEPNS_12FunctionDeclE")
  //</editor-fold>
  public boolean VisitFunctionDecl(FunctionDecl /*P*/ FD) {
    // We skip function template definitions, as their semantics is
    // only determined when they are instantiated.
    if (includeInGraph(FD)) {
      // Add all blocks declared inside this function to the graph.
      addNodesForBlocks(FD);
      // If this function has external linkage, anything could call it.
      // Note, we are not precise here. For example, the function could have
      // its address taken.
      addNodeForDecl(FD, FD.isGlobal());
    }
    return true;
  }

  
  /// Part of recursive declaration visitation.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 112,
   FQN="clang::CallGraph::VisitObjCMethodDecl", NM="_ZN5clang9CallGraph19VisitObjCMethodDeclEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph19VisitObjCMethodDeclEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public boolean VisitObjCMethodDecl(ObjCMethodDecl /*P*/ MD) {
    if (includeInGraph(MD)) {
      addNodesForBlocks(MD);
      addNodeForDecl(MD, true);
    }
    return true;
  }

  
  // We are only collecting the declarations, so do not step into the bodies.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::TraverseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 121,
   FQN="clang::CallGraph::TraverseStmt", NM="_ZN5clang9CallGraph12TraverseStmtEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph12TraverseStmtEPNS_4StmtE")
  //</editor-fold>
  public boolean TraverseStmt(Stmt /*P*/ S) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::shouldWalkTypesOfTypeLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 123,
   FQN="clang::CallGraph::shouldWalkTypesOfTypeLocs", NM="_ZNK5clang9CallGraph25shouldWalkTypesOfTypeLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZNK5clang9CallGraph25shouldWalkTypesOfTypeLocsEv")
  //</editor-fold>
  public boolean shouldWalkTypesOfTypeLocs() /*const*/ {
    return false;
  }

/*private:*/
  /// \brief Add the given declaration to the call graph.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::addNodeForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp", line = 130,
   FQN="clang::CallGraph::addNodeForDecl", NM="_ZN5clang9CallGraph14addNodeForDeclEPNS_4DeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph14addNodeForDeclEPNS_4DeclEb")
  //</editor-fold>
  private void addNodeForDecl(Decl /*P*/ D, boolean IsGlobal) {
    assert Native.$bool(D);
    
    // Allocate a new node, mark it as root, and process it's calls.
    CallGraphNode /*P*/ Node = getOrInsertNode(D);
    
    // Process all the calls by this function as well.
    CGBuilder builder/*J*/= new CGBuilder(this, Node);
    {
      Stmt /*P*/ Body = D.getBody();
      if ((Body != null)) {
        builder.Visit(Body);
      }
    }
  }

  
  /// \brief Allocate a new node in the graph.
  //<editor-fold defaultstate="collapsed" desc="clang::CallGraph::allocateNewNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CallGraph.h", line = 130,
   FQN="clang::CallGraph::allocateNewNode", NM="_ZN5clang9CallGraph15allocateNewNodeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CallGraph.cpp -nm=_ZN5clang9CallGraph15allocateNewNodeEPNS_4DeclE")
  //</editor-fold>
  private CallGraphNode /*P*/ allocateNewNode(Decl /*P*/ $Prm0) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      print(OS);
      OS.flush();      
      return Buf.toJavaString();
    }    
    return "" + "FunctionMap=" + FunctionMap // NOI18N
              + ", Root=" + Root // NOI18N
              + super.toString(); // NOI18N
  }
}
