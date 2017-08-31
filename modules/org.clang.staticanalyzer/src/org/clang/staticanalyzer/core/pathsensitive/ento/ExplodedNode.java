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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.support.*;
import static org.clang.staticanalyzer.core.impl.ExplodedGraphStatics.*;


//===----------------------------------------------------------------------===//
// ExplodedGraph "implementation" classes.  These classes are not typed to
// contain a specific kind of state.  Typed-specialized versions are defined
// on top of these classes.
//===----------------------------------------------------------------------===//

// ExplodedNode is not constified all over the engine because we need to add
// successors to it at any time after creating it.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*all methods assert checkAlive*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 55,
 FQN="clang::ento::ExplodedNode", NM="_ZN5clang4ento12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNodeE")
//</editor-fold>
public class ExplodedNode extends FoldingSetImpl.NodeImpl$Tracker implements /*public*/ FoldingSetImpl.Node, Destructors.ClassWithDestructor {
  /*friend  class ExplodedGraph*/
  /*friend  class CoreEngine*/
  /*friend  class NodeBuilder*/
  /*friend  class BranchNodeBuilder*/
  /*friend  class IndirectGotoNodeBuilder*/
  /*friend  class SwitchNodeBuilder*/
  /*friend  class EndOfFunctionNodeBuilder*/
  
  /// Efficiently stores a list of ExplodedNodes, or an optional flag.
  ///
  /// NodeGroup provides opaque storage for a list of ExplodedNodes, optimizing
  /// for the case when there is only one node in the group. This is a fairly
  /// common case in an ExplodedGraph, where most nodes have only one
  /// predecessor and many have only one successor. It can also be used to
  /// store a flag rather than a node list, which ExplodedNode uses to mark
  /// whether a node is a sink. If the flag is set, the group is implicitly
  /// empty and no nodes may be added.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 73,
   FQN="clang::ento::ExplodedNode::NodeGroup", NM="_ZN5clang4ento12ExplodedNode9NodeGroupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode9NodeGroupE")
  //</editor-fold>
  /*friend*/public/*private*/ static class NodeGroup {
    // Conceptually a discriminated union. If the low bit is set, the node is
    // a sink. If the low bit is not set, the pointer refers to the storage
    // for the nodes in the group.
    // This is not a PointerIntPair in order to keep the storage type opaque.
    private final PointerUnion<ExplodedNode /*P*/ , BumpVector<ExplodedNode /*P*/ > /*P*/ > P = new PointerUnion(ExplodedNode.class);
    private final boolean/*uintptr_t*/ Flag;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup::NodeGroup">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 81,
     FQN="clang::ento::ExplodedNode::NodeGroup::NodeGroup", NM="_ZN5clang4ento12ExplodedNode9NodeGroupC1Eb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode9NodeGroupC1Eb")
    //</editor-fold>
    public NodeGroup() {
      this(false);
    }
    public NodeGroup(boolean Flag/*= false*/) {
      // : P(Flag) 
      //START JInit
      this.Flag = Flag;//this.P = (Flag ? 1 : 0);
      //END JInit
      assert (getFlag() == Flag);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup::begin">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*work directly with P*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 277,
     FQN="clang::ento::ExplodedNode::NodeGroup::begin", NM="_ZNK5clang4ento12ExplodedNode9NodeGroup5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento12ExplodedNode9NodeGroup5beginEv")
    //</editor-fold>
    public type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/> begin() /*const*/ {
      if (getFlag()) {
        return null;
      }
      
      final /*const*/ PointerUnion<ExplodedNode /*P*/ , BumpVector<ExplodedNode /*P*/ > /*P*/ > /*&*/ Storage = P;
      if (Storage.isNull()) {
        return null;
      }
      {
        BumpVector<ExplodedNode /*P*/ > /*P*/ V = Storage.dyn_cast(BumpVector /*P*/.class);
        if ((V != null)) {
          return V.begin();
        }
      }
      return Storage.getAddrOfPtr1$Const(ExplodedNode /*P*/.class);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup::end">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*work directly with P*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 289,
     FQN="clang::ento::ExplodedNode::NodeGroup::end", NM="_ZNK5clang4ento12ExplodedNode9NodeGroup3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento12ExplodedNode9NodeGroup3endEv")
    //</editor-fold>
    public type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/> end() /*const*/ {
      if (getFlag()) {
        return null;
      }
      
      final /*const*/ PointerUnion<ExplodedNode /*P*/ , BumpVector<ExplodedNode /*P*/ > /*P*/ > /*&*/ Storage = P;
      if (Storage.isNull()) {
        return null;
      }
      {
        BumpVector<ExplodedNode /*P*/ > /*P*/ V = Storage.dyn_cast(BumpVector /*P*/.class);
        if ((V != null)) {
          return V.end();
        }
      }
      return Storage.getAddrOfPtr1$Const(ExplodedNode /*P*/.class).$add(1);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup::size">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*work directly with P*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 265,
     FQN="clang::ento::ExplodedNode::NodeGroup::size", NM="_ZNK5clang4ento12ExplodedNode9NodeGroup4sizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento12ExplodedNode9NodeGroup4sizeEv")
    //</editor-fold>
    public /*uint*/int size() /*const*/ {
      if (getFlag()) {
        return 0;
      }
      
      final /*const*/ PointerUnion<ExplodedNode /*P*/ , BumpVector<ExplodedNode /*P*/ > /*P*/ > /*&*/ Storage = P;
      if (Storage.isNull()) {
        return 0;
      }
      {
        BumpVector<ExplodedNode /*P*/ > /*P*/ V = Storage.dyn_cast(BumpVector /*P*/.class);
        if ((V != null)) {
          return V.size();
        }
      }
      return 1;
    }


    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup::empty">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 91,
     FQN="clang::ento::ExplodedNode::NodeGroup::empty", NM="_ZNK5clang4ento12ExplodedNode9NodeGroup5emptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode9NodeGroup5emptyEv")
    //</editor-fold>
    public boolean empty() /*const*/ {
      return P.isNull() || getFlag() != false;
    }

    
    /// Adds a node to the list.
    ///
    /// The group must not have been created with its flag set.
    
    /// Adds a node to the list.
    ///
    /// The group must not have been created with its flag set.
    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup::addNode">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*work directly with P*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 236,
     FQN="clang::ento::ExplodedNode::NodeGroup::addNode", NM="_ZN5clang4ento12ExplodedNode9NodeGroup7addNodeEPS1_RNS0_13ExplodedGraphE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento12ExplodedNode9NodeGroup7addNodeEPS1_RNS0_13ExplodedGraphE")
    //</editor-fold>
    public void addNode(ExplodedNode /*P*/ N, final ExplodedGraph /*&*/ G) {
      assert N.checkAlive();
      assert (!getFlag());
      
      final PointerUnion<ExplodedNode /*P*/ , BumpVector<ExplodedNode /*P*/ > /*P*/ > /*&*/ Storage = P;
      if (Storage.isNull()) {
        Storage.$assign_T$C$R(ExplodedNode /*P*/ /*const*/ /*&*/.class, N);
        assert Native.$bool(Storage.is(ExplodedNode /*P*/.class));
        return;
      }
      
      BumpVector<ExplodedNode /*P*/ > /*P*/ V = Storage.dyn_cast(BumpVector /*P*/.class);
      if (!(V != null)) {
        // Switch from single-node to multi-node representation.
        ExplodedNode /*P*/ Old = Storage.get(ExplodedNode /*P*/.class);
        
        final BumpVectorContext /*&*/ Ctx = G.getNodeAllocator();
        V = G.getAllocator().<BumpVector>Allocate$T(BumpVector.class);
        /*NEW_EXPR [System]*/V = /*new (V)*/ $new_uint_voidPtr(V, (type$ptr<?> New$Mem)->{
            return new BumpVector<ExplodedNode /*P*/ >(
                    new BumpVector.TypeAllocator<ExplodedNode>(
                    (int size)->{return new ExplodedNode[size];}), 
                    Ctx, 4);
         });
        V.push_back(Old, Ctx);
        
        Storage.$assign_T1$C$R((Class<BumpVector<ExplodedNode /*P*/ > /*P*/ /*const*/ /*&*/ >)(Class<?>)BumpVector /*P*/ /*const*/ /*&*/.class, V);
        assert (!getFlag());
        assert Native.$bool(Storage.is(BumpVector /*P*/.class));
      }
      
      V.push_back(N, G.getNodeAllocator());
    }


    
    /// Replaces the single node in this group with a new node.
    ///
    /// Note that this should only be used when you know the group was not
    /// created with its flag set, and that the group is empty or contains
    /// only a single node.
    
    /// Replaces the single node in this group with a new node.
    ///
    /// Note that this should only be used when you know the group was not
    /// created with its flag set, and that the group is empty or contains
    /// only a single node.
    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup::replaceNode">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*work directly with P*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 227,
     FQN="clang::ento::ExplodedNode::NodeGroup::replaceNode", NM="_ZN5clang4ento12ExplodedNode9NodeGroup11replaceNodeEPS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento12ExplodedNode9NodeGroup11replaceNodeEPS1_")
    //</editor-fold>
    public void replaceNode(ExplodedNode /*P*/ node) {
      assert node.checkAlive();
      assert (!getFlag());
      
      final PointerUnion<ExplodedNode /*P*/ , BumpVector<ExplodedNode /*P*/ > /*P*/ > /*&*/ Storage = P;
      assert Native.$bool(Storage.is(ExplodedNode /*P*/.class));
      Storage.$assign_T$C$R(ExplodedNode /*P*/ /*const*/ /*&*/.class, node);
      assert Native.$bool(Storage.is(ExplodedNode /*P*/.class));
    }


    
    /// Returns whether this group was created with its flag set.
    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::NodeGroup::getFlag">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 106,
     FQN="clang::ento::ExplodedNode::NodeGroup::getFlag", NM="_ZNK5clang4ento12ExplodedNode9NodeGroup7getFlagEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode9NodeGroup7getFlagEv")
    //</editor-fold>
    public boolean getFlag() /*const*/ {
      return Flag;//((P & 1) != 0);
    }

    
    @Override public String toString() {
      return "" + "P=" + NativeTrace.getIdentityStr(P.getOpaqueValue()); // NOI18N
    }
  };
  
  /// Location - The program location (within a function body) associated
  ///  with this node.
  private final/*const*/ ProgramPoint Location;
  
  /// State - The state associated with this node.
   /*friend*/public final /*private*/ IntrusiveRefCntPtr</*const*/ ProgramState> State;
  
  /// Preds - The predecessors of this node.
  /*friend*/public final/*private*/ NodeGroup Preds;
  
  /// Succs - The successors of this node.
  /*friend*/public final /*private*/ NodeGroup Succs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::ExplodedNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 125,
   FQN="clang::ento::ExplodedNode::ExplodedNode", NM="_ZN5clang4ento12ExplodedNodeC1ERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNodeC1ERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb")
  //</editor-fold>
  public /*explicit*/ ExplodedNode(final /*const*/ ProgramPoint /*&*/ loc, IntrusiveRefCntPtr</*const*/ ProgramState> state, 
      boolean IsSink) {
    // : FoldingSetNode(), Location(loc), State(std::move(state)), Preds(), Succs(IsSink) 
    //START JInit
    $Node();
    this.Location = new ProgramPoint(loc);
    this.State = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, std.move(state));
    this.Preds = new NodeGroup();
    this.Succs = new NodeGroup(IsSink);
    //END JInit
    assert (isSink() == IsSink);
  }

  
  /// getLocation - Returns the edge associated with the given node.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 132,
   FQN="clang::ento::ExplodedNode::getLocation", NM="_ZNK5clang4ento12ExplodedNode11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode11getLocationEv")
  //</editor-fold>
  public ProgramPoint getLocation() /*const*/ {
    assert checkAlive();
    return new ProgramPoint(Location);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 134,
   FQN="clang::ento::ExplodedNode::getLocationContext", NM="_ZNK5clang4ento12ExplodedNode18getLocationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode18getLocationContextEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getLocationContext() /*const*/ {
    assert checkAlive();
    return getLocation().getLocationContext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getStackFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 138,
   FQN="clang::ento::ExplodedNode::getStackFrame", NM="_ZNK5clang4ento12ExplodedNode13getStackFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode13getStackFrameEv")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getStackFrame() /*const*/ {
    assert checkAlive();
    return getLocationContext().getCurrentStackFrame();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getCodeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 142,
   FQN="clang::ento::ExplodedNode::getCodeDecl", NM="_ZNK5clang4ento12ExplodedNode11getCodeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode11getCodeDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*&*/ getCodeDecl() /*const*/ {
    assert checkAlive();
    return $Deref(getLocationContext().getDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 144,
   FQN="clang::ento::ExplodedNode::getCFG", NM="_ZNK5clang4ento12ExplodedNode6getCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode6getCFGEv")
  //</editor-fold>
  public CFG /*&*/ getCFG() /*const*/ {
    assert checkAlive();
    return $Deref(getLocationContext().getCFG());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getParentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 146,
   FQN="clang::ento::ExplodedNode::getParentMap", NM="_ZNK5clang4ento12ExplodedNode12getParentMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode12getParentMapEv")
  //</editor-fold>
  public ParentMap /*&*/ getParentMap() /*const*/ {
    assert checkAlive();
    return getLocationContext().getParentMap();
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 149,
   FQN="clang::ento::ExplodedNode::getAnalysis", NM="Tpl__ZNK5clang4ento12ExplodedNode11getAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=Tpl__ZNK5clang4ento12ExplodedNode11getAnalysisEv")
  //</editor-fold>
  public </*typename*/ T extends ManagedAnalysis> T /*&*/ getAnalysis(Class<T> clazz) /*const*/ {
    assert checkAlive();
    return Native.$star(getLocationContext().getAnalysis(clazz));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 153,
   FQN="clang::ento::ExplodedNode::getState", NM="_ZNK5clang4ento12ExplodedNode8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode8getStateEv")
  //</editor-fold>
  public /*const*/ IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ getState() /*const*/ {
    assert checkAlive();
    return State;
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getLocationAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 156,
   FQN="clang::ento::ExplodedNode::getLocationAs", NM="Tpl__ZNKR5clang4ento12ExplodedNode13getLocationAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=Tpl__ZNKR5clang4ento12ExplodedNode13getLocationAsEv")
  //</editor-fold>
  public </*typename*/ T extends ProgramPoint> Optional<T> getLocationAs(Class<T> clazz) /*const*/ {
    assert checkAlive();
    return Location.getAs(clazz);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 160,
   FQN="clang::ento::ExplodedNode::Profile", NM="_ZN5clang4ento12ExplodedNode7ProfileERN4llvm16FoldingSetNodeIDERKNS_12ProgramPointERKNS2_18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode7ProfileERN4llvm16FoldingSetNodeIDERKNS_12ProgramPointERKNS2_18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb")
  //</editor-fold>
  public/*public*/ static void Profile(final FoldingSetNodeID /*&*/ ID, 
         final /*const*/ ProgramPoint /*&*/ Loc, 
         final /*const*/ IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ state, 
         boolean IsSink) {
    ID.Add(Loc);
    ID.AddPointer(state.get());
    ID.AddBoolean(IsSink);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 169,
   FQN="clang::ento::ExplodedNode::Profile", NM="_ZNK5clang4ento12ExplodedNode7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public/*public*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    assert checkAlive();
    // We avoid copy constructors by not using accessors.
    ExplodedNode.Profile(ID, Location, State, isSink());
  }

  
  /// addPredeccessor - Adds a predecessor to the current node, and
  ///  in tandem add this node as a successor of the other node.
  
  /// addPredeccessor - Adds a predecessor to the current node, and
  ///  in tandem add this node as a successor of the other node.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::addPredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 218,
   FQN="clang::ento::ExplodedNode::addPredecessor", NM="_ZN5clang4ento12ExplodedNode14addPredecessorEPS1_RNS0_13ExplodedGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento12ExplodedNode14addPredecessorEPS1_RNS0_13ExplodedGraphE")
  //</editor-fold>
  public void addPredecessor(ExplodedNode /*P*/ V, final ExplodedGraph /*&*/ G) {
    assert checkAlive();
    assert V.checkAlive();
    assert (!V.isSink());
    Preds.addNode(V, G);
    V.Succs.addNode(this, G);
    if ((NodeAuditor != null)) {
      NodeAuditor.AddEdge(V, this);
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::succ_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 178,
   FQN="clang::ento::ExplodedNode::succ_size", NM="_ZNK5clang4ento12ExplodedNode9succ_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode9succ_sizeEv")
  //</editor-fold>
  public /*uint*/int succ_size() /*const*/ {
    assert checkAlive();
    return Succs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::pred_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 179,
   FQN="clang::ento::ExplodedNode::pred_size", NM="_ZNK5clang4ento12ExplodedNode9pred_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode9pred_sizeEv")
  //</editor-fold>
  public /*uint*/int pred_size() /*const*/ {
    assert checkAlive();
    return Preds.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::succ_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 180,
   FQN="clang::ento::ExplodedNode::succ_empty", NM="_ZNK5clang4ento12ExplodedNode10succ_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode10succ_emptyEv")
  //</editor-fold>
  public boolean succ_empty() /*const*/ {
    assert checkAlive();
    return Succs.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::pred_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 181,
   FQN="clang::ento::ExplodedNode::pred_empty", NM="_ZNK5clang4ento12ExplodedNode10pred_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode10pred_emptyEv")
  //</editor-fold>
  public boolean pred_empty() /*const*/ {
    assert checkAlive();
    return Preds.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::isSink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 183,
   FQN="clang::ento::ExplodedNode::isSink", NM="_ZNK5clang4ento12ExplodedNode6isSinkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode6isSinkEv")
  //</editor-fold>
  public boolean isSink() /*const*/ {
    assert checkAlive();
    return Succs.getFlag();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::hasSinglePred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 185,
   FQN="clang::ento::ExplodedNode::hasSinglePred", NM="_ZNK5clang4ento12ExplodedNode13hasSinglePredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode13hasSinglePredEv")
  //</editor-fold>
  public boolean hasSinglePred() /*const*/ {
    assert checkAlive();
    return (pred_size() == 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getFirstPred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 189,
   FQN="clang::ento::ExplodedNode::getFirstPred", NM="_ZN5clang4ento12ExplodedNode12getFirstPredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode12getFirstPredEv")
  //</editor-fold>
  public ExplodedNode /*P*/ getFirstPred() {
    assert checkAlive();
    return pred_empty() ? null : (pred_begin()).$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getFirstPred">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 193,
   FQN="clang::ento::ExplodedNode::getFirstPred", NM="_ZNK5clang4ento12ExplodedNode12getFirstPredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode12getFirstPredEv")
  //</editor-fold>
  public /*const*/ ExplodedNode /*P*/ getFirstPred$Const() /*const*/ {
    assert checkAlive();
    return ((/*const_cast*/ExplodedNode /*P*/ )(this)).getFirstPred();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::getFirstSucc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 197,
   FQN="clang::ento::ExplodedNode::getFirstSucc", NM="_ZNK5clang4ento12ExplodedNode12getFirstSuccEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode12getFirstSuccEv")
  //</editor-fold>
  public /*const*/ ExplodedNode /*P*/ getFirstSucc() /*const*/ {
    assert checkAlive();
    return succ_empty() ? null : (succ_begin$Const()).$star();
  }

  
  // Iterators over successor and predecessor vertices.
  // JAVA: typedef ExplodedNode *const *succ_iterator
//  public final class succ_iterator extends type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/>{ };
  // JAVA: typedef const ExplodedNode *const *const_succ_iterator
//  public final class const_succ_iterator extends type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/>{ };
  // JAVA: typedef ExplodedNode *const *pred_iterator
//  public final class pred_iterator extends type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/>{ };
  // JAVA: typedef const ExplodedNode *const *const_pred_iterator
//  public final class const_pred_iterator extends type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::pred_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 207,
   FQN="clang::ento::ExplodedNode::pred_begin", NM="_ZN5clang4ento12ExplodedNode10pred_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode10pred_beginEv")
  //</editor-fold>
  public type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/> pred_begin() {
    assert checkAlive();
    return Preds.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::pred_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 208,
   FQN="clang::ento::ExplodedNode::pred_end", NM="_ZN5clang4ento12ExplodedNode8pred_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode8pred_endEv")
  //</editor-fold>
  public type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/> pred_end() {
    assert checkAlive();
    return Preds.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::pred_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 210,
   FQN="clang::ento::ExplodedNode::pred_begin", NM="_ZNK5clang4ento12ExplodedNode10pred_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode10pred_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/> pred_begin$Const() /*const*/ {
    assert checkAlive();
    return ((/*const_cast*/ExplodedNode /*P*/ )(this)).pred_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::pred_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 213,
   FQN="clang::ento::ExplodedNode::pred_end", NM="_ZNK5clang4ento12ExplodedNode8pred_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode8pred_endEv")
  //</editor-fold>
  public type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/> pred_end$Const() /*const*/ {
    assert checkAlive();
    return ((/*const_cast*/ExplodedNode /*P*/ )(this)).pred_end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::succ_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 217,
   FQN="clang::ento::ExplodedNode::succ_begin", NM="_ZN5clang4ento12ExplodedNode10succ_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode10succ_beginEv")
  //</editor-fold>
  public type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/> succ_begin() {
    assert checkAlive();
    return Succs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::succ_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 218,
   FQN="clang::ento::ExplodedNode::succ_end", NM="_ZN5clang4ento12ExplodedNode8succ_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode8succ_endEv")
  //</editor-fold>
  public type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/> succ_end() {
    assert checkAlive();
    return Succs.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::succ_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 220,
   FQN="clang::ento::ExplodedNode::succ_begin", NM="_ZNK5clang4ento12ExplodedNode10succ_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode10succ_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/> succ_begin$Const() /*const*/ {
    assert checkAlive();
    return ((/*const_cast*/ExplodedNode /*P*/ )(this)).succ_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::succ_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 223,
   FQN="clang::ento::ExplodedNode::succ_end", NM="_ZNK5clang4ento12ExplodedNode8succ_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZNK5clang4ento12ExplodedNode8succ_endEv")
  //</editor-fold>
  public type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/> succ_end$Const() /*const*/ {
    assert checkAlive();
    return ((/*const_cast*/ExplodedNode /*P*/ )(this)).succ_end();
  }


  // For debugging.
  /*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::Auditor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 231,
   FQN="clang::ento::ExplodedNode::Auditor", NM="_ZN5clang4ento12ExplodedNode7AuditorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode7AuditorE")
  //</editor-fold>
  public abstract static class Auditor implements Destructors.ClassWithDestructor {
  /*public:*/
    
    //===----------------------------------------------------------------------===//
    // Node auditing.
    //===----------------------------------------------------------------------===//
    
    // An out of line virtual method to provide a home for the class vtable.
    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::Auditor::~Auditor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 34,
     FQN="clang::ento::ExplodedNode::Auditor::~Auditor", NM="_ZN5clang4ento12ExplodedNode7AuditorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento12ExplodedNode7AuditorD0Ev")
    //</editor-fold>
    public void $destroy() {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::Auditor::AddEdge">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 234,
     FQN="clang::ento::ExplodedNode::Auditor::AddEdge", NM="_ZN5clang4ento12ExplodedNode7Auditor7AddEdgeEPS1_S3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode7Auditor7AddEdgeEPS1_S3_")
    //</editor-fold>
    public abstract /*virtual*/ void AddEdge(ExplodedNode /*P*/ Src, ExplodedNode /*P*/ Dst)/* = 0*/;

    //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::Auditor::Auditor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 231,
     FQN="clang::ento::ExplodedNode::Auditor::Auditor", NM="_ZN5clang4ento12ExplodedNode7AuditorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode7AuditorC1Ev")
    //</editor-fold>
    public /*inline*/ Auditor() {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::SetAuditor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 40,
   FQN="clang::ento::ExplodedNode::SetAuditor", NM="_ZN5clang4ento12ExplodedNode10SetAuditorEPNS1_7AuditorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento12ExplodedNode10SetAuditorEPNS1_7AuditorE")
  //</editor-fold>
  public static void SetAuditor(ExplodedNode.Auditor /*P*/ A) {
    NodeAuditor = A;
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::replaceSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 240,
   FQN="clang::ento::ExplodedNode::replaceSuccessor", NM="_ZN5clang4ento12ExplodedNode16replaceSuccessorEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode16replaceSuccessorEPS1_")
  //</editor-fold>
  /*friend*/public/*private*/ void replaceSuccessor(ExplodedNode /*P*/ node) {
    assert checkAlive();
    Succs.replaceNode(node);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::replacePredecessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 241,
   FQN="clang::ento::ExplodedNode::replacePredecessor", NM="_ZN5clang4ento12ExplodedNode18replacePredecessorEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/AnalysisConsumer.cpp -nm=_ZN5clang4ento12ExplodedNode18replacePredecessorEPS1_")
  //</editor-fold>
  /*friend*/public/*private*/ void replacePredecessor(ExplodedNode /*P*/ node) {
    assert checkAlive();
    Preds.replaceNode(node);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedNode::~ExplodedNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 55,
   FQN="clang::ento::ExplodedNode::~ExplodedNode", NM="_ZN5clang4ento12ExplodedNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento12ExplodedNodeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    State.$destroy();
    FoldingSetImpl.Node.super.$destroy$Node();
    //END JDestroy
  }

  
  
  @Override public String toString() {
    return "" + "Location=" + Location // NOI18N
              + ", State=" + State // NOI18N
              + ", Preds=" + Preds // NOI18N
              + ", Succs=" + Succs // NOI18N
              + super.toString(); // NOI18N
  }
}
