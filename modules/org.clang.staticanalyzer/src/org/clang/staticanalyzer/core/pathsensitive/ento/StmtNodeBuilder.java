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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;


/// \class StmtNodeBuilder
/// \brief This builder class is useful for generating nodes that resulted from
/// visiting a statement. The main difference from its parent NodeBuilder is
/// that it creates a statement specific ProgramPoint.
//<editor-fold defaultstate="collapsed" desc="clang::ento::StmtNodeBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 348,
 FQN="clang::ento::StmtNodeBuilder", NM="_ZN5clang4ento15StmtNodeBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento15StmtNodeBuilderE")
//</editor-fold>
public class StmtNodeBuilder extends /*public*/ NodeBuilder implements Destructors.ClassWithDestructor {
  private NodeBuilder /*P*/ EnclosingBldr;
/*public:*/
  
  /// \brief Constructs a StmtNodeBuilder. If the builder is going to process
  /// nodes currently owned by another builder(with larger scope), use
  /// Enclosing builder to transfer ownership.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StmtNodeBuilder::StmtNodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 355,
   FQN="clang::ento::StmtNodeBuilder::StmtNodeBuilder", NM="_ZN5clang4ento15StmtNodeBuilderC1EPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS0_18NodeBuilderContextEPNS0_11NodeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento15StmtNodeBuilderC1EPNS0_12ExplodedNodeERNS0_15ExplodedNodeSetERKNS0_18NodeBuilderContextEPNS0_11NodeBuilderE")
  //</editor-fold>
  public StmtNodeBuilder(ExplodedNode /*P*/ SrcNode, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ Ctx) {
    this(SrcNode, DstSet, 
      Ctx, 
      (NodeBuilder /*P*/ )null);
  }
  public StmtNodeBuilder(ExplodedNode /*P*/ SrcNode, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ Ctx, 
      NodeBuilder /*P*/ Enclosing/*= null*/) {
    // : NodeBuilder(SrcNode, DstSet, Ctx), EnclosingBldr(Enclosing) 
    //START JInit
    super(SrcNode, DstSet, Ctx);
    this.EnclosingBldr = Enclosing;
    //END JInit
    if ((EnclosingBldr != null)) {
      EnclosingBldr.takeNodes(SrcNode);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StmtNodeBuilder::StmtNodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 363,
   FQN="clang::ento::StmtNodeBuilder::StmtNodeBuilder", NM="_ZN5clang4ento15StmtNodeBuilderC1ERNS0_15ExplodedNodeSetES3_RKNS0_18NodeBuilderContextEPNS0_11NodeBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento15StmtNodeBuilderC1ERNS0_15ExplodedNodeSetES3_RKNS0_18NodeBuilderContextEPNS0_11NodeBuilderE")
  //</editor-fold>
  public StmtNodeBuilder(final ExplodedNodeSet /*&*/ SrcSet, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ Ctx) {
    this(SrcSet, DstSet, 
      Ctx, 
      (NodeBuilder /*P*/ )null);
  }
  public StmtNodeBuilder(final ExplodedNodeSet /*&*/ SrcSet, final ExplodedNodeSet /*&*/ DstSet, 
      final /*const*/ NodeBuilderContext /*&*/ Ctx, 
      NodeBuilder /*P*/ Enclosing/*= null*/) {
    // : NodeBuilder(SrcSet, DstSet, Ctx), EnclosingBldr(Enclosing) 
    //START JInit
    super(SrcSet, DstSet, Ctx);
    this.EnclosingBldr = Enclosing;
    //END JInit
    if ((EnclosingBldr != null)) {
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = SrcSet.begin(), 
          E = SrcSet.end(); I.$noteq(E); I.$preInc())  {
        EnclosingBldr.takeNodes(I.$star());
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StmtNodeBuilder::~StmtNodeBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp", line = 663,
   FQN="clang::ento::StmtNodeBuilder::~StmtNodeBuilder", NM="_ZN5clang4ento15StmtNodeBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento15StmtNodeBuilderD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    if ((EnclosingBldr != null)) {
      for (SmallPtrSetIterator<ExplodedNode /*P*/ > I = Frontier.begin(), 
          E = Frontier.end(); I.$noteq(E); I.$preInc())  {
        EnclosingBldr.addNodes(I.$star());
      }
    }
    super.$destroy();
  }

  
  //JAVA: using NodeBuilder::generateNode;
  //JAVA: using NodeBuilder::generateSink;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StmtNodeBuilder::generateNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 378,
   FQN="clang::ento::StmtNodeBuilder::generateNode", NM="_ZN5clang4ento15StmtNodeBuilder12generateNodeEPKNS_4StmtEPNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagENS_12ProgramPoint4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento15StmtNodeBuilder12generateNodeEPKNS_4StmtEPNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagENS_12ProgramPoint4KindE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateNode(/*const*/ Stmt /*P*/ S, 
              ExplodedNode /*P*/ Pred, 
              IntrusiveRefCntPtr</*const*/ ProgramState> St) {
    return generateNode(S, 
              Pred, 
              St, 
              (/*const*/ ProgramPointTag /*P*/ )null, 
              ProgramPoint.Kind.PostStmtKind);
  }
  public ExplodedNode /*P*/ generateNode(/*const*/ Stmt /*P*/ S, 
              ExplodedNode /*P*/ Pred, 
              IntrusiveRefCntPtr</*const*/ ProgramState> St, 
              /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    return generateNode(S, 
              Pred, 
              St, 
              tag, 
              ProgramPoint.Kind.PostStmtKind);
  }
  public ExplodedNode /*P*/ generateNode(/*const*/ Stmt /*P*/ S, 
              ExplodedNode /*P*/ Pred, 
              IntrusiveRefCntPtr</*const*/ ProgramState> St, 
              /*const*/ ProgramPointTag /*P*/ tag/*= null*/, 
              ProgramPoint.Kind K/*= ProgramPoint::PostStmtKind*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final /*const*/ ProgramPoint /*&*/ L = ProgramPoint.getProgramPoint(S, K, 
          Pred.getLocationContext(), tag);
      return $c$.clean(super.generateNode(L, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Pred));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StmtNodeBuilder::generateSink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CoreEngine.h", line = 388,
   FQN="clang::ento::StmtNodeBuilder::generateSink", NM="_ZN5clang4ento15StmtNodeBuilder12generateSinkEPKNS_4StmtEPNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagENS_12ProgramPoint4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento15StmtNodeBuilder12generateSinkEPKNS_4StmtEPNS0_12ExplodedNodeEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15ProgramPointTagENS_12ProgramPoint4KindE")
  //</editor-fold>
  public ExplodedNode /*P*/ generateSink(/*const*/ Stmt /*P*/ S, 
              ExplodedNode /*P*/ Pred, 
              IntrusiveRefCntPtr</*const*/ ProgramState> St) {
    return generateSink(S, 
              Pred, 
              St, 
              (/*const*/ ProgramPointTag /*P*/ )null, 
              ProgramPoint.Kind.PostStmtKind);
  }
  public ExplodedNode /*P*/ generateSink(/*const*/ Stmt /*P*/ S, 
              ExplodedNode /*P*/ Pred, 
              IntrusiveRefCntPtr</*const*/ ProgramState> St, 
              /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    return generateSink(S, 
              Pred, 
              St, 
              tag, 
              ProgramPoint.Kind.PostStmtKind);
  }
  public ExplodedNode /*P*/ generateSink(/*const*/ Stmt /*P*/ S, 
              ExplodedNode /*P*/ Pred, 
              IntrusiveRefCntPtr</*const*/ ProgramState> St, 
              /*const*/ ProgramPointTag /*P*/ tag/*= null*/, 
              ProgramPoint.Kind K/*= ProgramPoint::PostStmtKind*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final /*const*/ ProgramPoint /*&*/ L = ProgramPoint.getProgramPoint(S, K, 
          Pred.getLocationContext(), tag);
      return $c$.clean(super.generateSink(L, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Pred));
    } finally {
      $c$.$destroy();
    }
  }

  
  @Override public String toString() {
    return "" + "EnclosingBldr=" + "[NodeBuilder]" // NOI18N
              + super.toString(); // NOI18N
  }
}
