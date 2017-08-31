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

package org.clang.ast.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;

/// @}

/// \brief A \c RecursiveASTVisitor that builds a map from nodes to their
/// parents as defined by the \c RecursiveASTVisitor.
///
/// Note that the relationship described here is purely in terms of AST
/// traversal - there are other relationships (for example declaration context)
/// in the AST that are better modeled by special matchers.
///
/// FIXME: Currently only builds up the map using \c Stmt and \c Decl nodes.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8922,
 FQN="(anonymous namespace)::ParentMapASTVisitor", NM="_ZN12_GLOBAL__N_119ParentMapASTVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_119ParentMapASTVisitorE")
//</editor-fold>
public class ParentMapASTVisitor implements /*public*/ RecursiveASTVisitor<ParentMapASTVisitor>, Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Builds and returns the translation unit's parent map.
  ///
  ///  The caller takes ownership of the returned \c ParentMap.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::buildMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8927,
   FQN="(anonymous namespace)::ParentMapASTVisitor::buildMap", NM="_ZN12_GLOBAL__N_119ParentMapASTVisitor8buildMapERN5clang19TranslationUnitDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_119ParentMapASTVisitor8buildMapERN5clang19TranslationUnitDeclE")
  //</editor-fold>
  public static std.pair<ASTContext.ParentMapPointers/*P*/ , ASTContext.ParentMapOtherNodes/*P*/ > buildMap(final TranslationUnitDecl /*&*/ TU) {
    ParentMapASTVisitor Visitor = null;
    try {
      Visitor/*J*/= new ParentMapASTVisitor(new ASTContext.ParentMapPointers(), 
          new ASTContext.ParentMapOtherNodes());
      Visitor.TraverseDecl($AddrOf(TU));
      return std.make_pair_Ptr_Ptr(Visitor.Parents, Visitor.OtherParents);
    } finally {
      if (Visitor != null) { Visitor.$destroy(); }
    }
  }

/*private:*/
  /*typedef RecursiveASTVisitor<ParentMapASTVisitor> VisitorBase*/
//  public final class VisitorBase extends RecursiveASTVisitor<ParentMapASTVisitor>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::ParentMapASTVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8939,
   FQN="(anonymous namespace)::ParentMapASTVisitor::ParentMapASTVisitor", NM="_ZN12_GLOBAL__N_119ParentMapASTVisitorC1EPN4llvm8DenseMapIPKvNS1_13PointerUnion4IPKN5clang4DeclEPKNS6_4StmtEPNS6_15ast_type_traits12DynTypedNodeEPNS1_11SmallVectorISE_Lj2EEEEENS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_SJ_EEEEPNS2_ISE_SJ_NSK_ISE_EENSN_ISE_SJ_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_119ParentMapASTVisitorC1EPN4llvm8DenseMapIPKvNS1_13PointerUnion4IPKN5clang4DeclEPKNS6_4StmtEPNS6_15ast_type_traits12DynTypedNodeEPNS1_11SmallVectorISE_Lj2EEEEENS1_12DenseMapInfoIS4_EENS1_6detail12DenseMapPairIS4_SJ_EEEEPNS2_ISE_SJ_NSK_ISE_EENSN_ISE_SJ_EEEE")
  //</editor-fold>
  private ParentMapASTVisitor(ASTContext.ParentMapPointers/*P*/ Parents, 
      ASTContext.ParentMapOtherNodes/*P*/ OtherParents) {
    // : RecursiveASTVisitor<ParentMapASTVisitor>(), Parents(Parents), OtherParents(OtherParents), ParentStack() 
    //START JInit
    $RecursiveASTVisitor();
    this.Parents = Parents;
    this.OtherParents = OtherParents;
    this.ParentStack = new SmallVector<DynTypedNode>(16, new DynTypedNode());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::shouldVisitTemplateInstantiations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8943,
   FQN="(anonymous namespace)::ParentMapASTVisitor::shouldVisitTemplateInstantiations", NM="_ZNK12_GLOBAL__N_119ParentMapASTVisitor33shouldVisitTemplateInstantiationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK12_GLOBAL__N_119ParentMapASTVisitor33shouldVisitTemplateInstantiationsEv")
  //</editor-fold>
  public/*private*/ boolean shouldVisitTemplateInstantiations() /*const*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::shouldVisitImplicitCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8946,
   FQN="(anonymous namespace)::ParentMapASTVisitor::shouldVisitImplicitCode", NM="_ZNK12_GLOBAL__N_119ParentMapASTVisitor23shouldVisitImplicitCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZNK12_GLOBAL__N_119ParentMapASTVisitor23shouldVisitImplicitCodeEv")
  //</editor-fold>
  public/*private*/ boolean shouldVisitImplicitCode() /*const*/ {
    return true;
  }

  
  /*template <typename T, typename MapNodeTy, typename BaseTraverseFn, typename MapTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::TraverseNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8952,
   FQN="(anonymous namespace)::ParentMapASTVisitor::TraverseNode", NM="Tpl__ZN12_GLOBAL__N_119ParentMapASTVisitor12TraverseNodeET_T0_T1_PT2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN12_GLOBAL__N_119ParentMapASTVisitor12TraverseNodeET_T0_T1_PT2_")
  //</editor-fold>
  private </*typename*/ T, /*typename*/ MapNodeTy/*, typename BaseTraverseFn extends VoidBoolPredicate,*/ /*typename MapTy extends DenseMap*/> boolean 
        TraverseNode(T Node, MapNodeTy MapNode, 
              VoidBoolPredicate BaseTraverse, DenseMap /*P*/ Parents) {
    if (Native.$not(Node)) {
      return true;
    }
    if ($greater_uint(ParentStack.size(), 0)) {
      // FIXME: Currently we add the same parent multiple times, but only
      // when no memoization data is available for the type.
      // For example when we visit all subexpressions of template
      // instantiations; this is suboptimal, but benign: the only way to
      // visit those is with hasAncestor / hasParent, and those do not create
      // new matches.
      // The plan is to enable DynTypedNode to be storable in a map or hash
      // map. The main problem there is to implement hash functions /
      // comparison operators for all types that DynTypedNode supports that
      // do not have pointer identity.
      final PointerUnion4 /*&*/ NodeOrVector = (PointerUnion4)Parents.$at(MapNode);
      if (NodeOrVector.isNull()) {
        {
          /*const*/ Decl /*P*/ D = ParentStack.back().get$Decl();
          if ((D != null)) {
            NodeOrVector.$assign(D);
          } else {
            /*const*/ Stmt /*P*/ S = ParentStack.back().get$Stmt();
            if ((S != null)) {
              NodeOrVector.$assign(S);
            } else {
              NodeOrVector
                .$assign(new DynTypedNode(ParentStack.back()));
            }
          }
        }
      } else {
        if (Native.$not(NodeOrVector./*template */<SmallVector<DynTypedNode> /*P*/>is(SmallVector.class))) {
          SmallVector<DynTypedNode> /*P*/ Vector = new SmallVector<DynTypedNode>(1, ASTContextStatics.getSingleDynTypedNodeFromParentMap(NodeOrVector));
          {
            DynTypedNode /*P*/ Node$1 = (DynTypedNode)NodeOrVector./*template */<DynTypedNode /*P*/ >dyn_cast(DynTypedNode.class);
            if (Node$1 != null) {
              /*delete*/Destructors.$destroy(Node$1);
            }
          }
          NodeOrVector.$assign(Vector);
        }
        
        SmallVector<DynTypedNode> /*P*/ Vector = (SmallVector<DynTypedNode>)NodeOrVector./*template */<SmallVector<DynTypedNode> /*P*/>get(SmallVector.class);
        // Skip duplicates for types that have memoization data.
        // We must check that the type has memoization data before calling
        // std::find() because DynTypedNode::operator== can't compare all
        // types.
        boolean Found = Native.$bool(ParentStack.back().getMemoizationData())
           && Native.$bool(Native.$noteq_ptr(std.find(Vector.begin(), Vector.end(), 
                ParentStack.back()), Vector.end()));
        if (!Found) {
          Vector.push_back(ParentStack.back());
        }
      }
    }
    
    ParentStack.push_back(ASTContextStatics.createDynTypedNode(Node));
    boolean Result = BaseTraverse.$call();
    ParentStack.pop_back();
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::TraverseDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 9006,
   FQN="(anonymous namespace)::ParentMapASTVisitor::TraverseDecl", NM="_ZN12_GLOBAL__N_119ParentMapASTVisitor12TraverseDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_119ParentMapASTVisitor12TraverseDeclEPN5clang4DeclE")
  //</editor-fold>
  public/*private*/ boolean TraverseDecl(Decl /*P*/ DeclNode) {
    return TraverseNode(DeclNode, DeclNode, 
        /*[&, this, &DeclNode]*/() -> {
              return RecursiveASTVisitor.super.TraverseDecl(DeclNode);
            }, 
        Parents);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::TraverseStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 9012,
   FQN="(anonymous namespace)::ParentMapASTVisitor::TraverseStmt", NM="_ZN12_GLOBAL__N_119ParentMapASTVisitor12TraverseStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_119ParentMapASTVisitor12TraverseStmtEPN5clang4StmtE")
  //</editor-fold>
  public/*private*/ boolean TraverseStmt(Stmt /*P*/ StmtNode) {
    return TraverseNode(StmtNode, StmtNode, 
        /*[&, this, &StmtNode]*/() -> {
              return RecursiveASTVisitor.super.TraverseStmt(StmtNode);
            }, 
        Parents);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::TraverseTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 9018,
   FQN="(anonymous namespace)::ParentMapASTVisitor::TraverseTypeLoc", NM="_ZN12_GLOBAL__N_119ParentMapASTVisitor15TraverseTypeLocEN5clang7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_119ParentMapASTVisitor15TraverseTypeLocEN5clang7TypeLocE")
  //</editor-fold>
  public/*private*/ boolean TraverseTypeLoc(TypeLoc TypeLocNode) {
    return TraverseNode(new TypeLoc(TypeLocNode), DynTypedNode.create(TypeLocNode), 
        /*[&, this, &TypeLocNode]*/() -> {
              return RecursiveASTVisitor.super.TraverseTypeLoc(new TypeLoc(TypeLocNode));
            }, 
        OtherParents);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::TraverseNestedNameSpecifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 9025,
   FQN="(anonymous namespace)::ParentMapASTVisitor::TraverseNestedNameSpecifierLoc", NM="_ZN12_GLOBAL__N_119ParentMapASTVisitor30TraverseNestedNameSpecifierLocEN5clang22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_119ParentMapASTVisitor30TraverseNestedNameSpecifierLocEN5clang22NestedNameSpecifierLocE")
  //</editor-fold>
  public/*private*/ boolean TraverseNestedNameSpecifierLoc(NestedNameSpecifierLoc NNSLocNode) {
    return TraverseNode(new NestedNameSpecifierLoc(NNSLocNode), DynTypedNode.create(NNSLocNode), 
        /*[&, this, &NNSLocNode]*/() -> {
              return RecursiveASTVisitor.super.TraverseNestedNameSpecifierLoc(new NestedNameSpecifierLoc(NNSLocNode));
            }, 
        OtherParents);
  }

  
  private ASTContext.ParentMapPointers/*P*/ Parents;
  private ASTContext.ParentMapOtherNodes/*P*/ OtherParents;
  private SmallVector<DynTypedNode> ParentStack;
  
  /*friend  class RecursiveASTVisitor<ParentMapASTVisitor>*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ParentMapASTVisitor::~ParentMapASTVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8922,
   FQN="(anonymous namespace)::ParentMapASTVisitor::~ParentMapASTVisitor", NM="_ZN12_GLOBAL__N_119ParentMapASTVisitorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_119ParentMapASTVisitorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ParentStack.$destroy();
    RecursiveASTVisitor.super.$destroy$RecursiveASTVisitor();
    //END JDestroy
  }
  
  @Override public String toString() {
    return "" + "Parents=" + Parents // NOI18N
              + ", OtherParents=" + OtherParents // NOI18N
              + ", ParentStack=" + ParentStack // NOI18N
              + super.toString(); // NOI18N
  }
}
