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

package org.llvm.support;

import org.clank.java.*;
import static org.clank.java.std.$eq___normal_iterator$C;
import static org.clank.java.std.$noteq___normal_iterator$C;
import org.clank.java.std_ptr.unique_ptr;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$Move;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.Unsigned.$greater_uint;
import org.clank.support.aliases.type$iterator;
import static org.clank.support.literal_constants.$LF;
import org.llvm.adt.Inverse;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.aliases.*;
import org.llvm.adt.java.ADTFunctionPointers.NodeType$GetParent;
import org.llvm.adt.java.ADTFunctionPointers.NodeType$GetParent$FrontEntry;
import org.llvm.adt.java.GraphTraits;
import static org.llvm.support.AdtsupportLlvmGlobals.PrintDomTree;


/// \brief Core dominator tree base class.
///
/// This class is a generic template over graph nodes. It is instantiated for
/// various graphs in the LLVM IR or in the code generator.
/*template <class NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*this class is based on DominatorTreeBase$BasicBlock instantiation*/,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 187,
 FQN="llvm::DominatorTreeBase<NodeT>", NM="_ZN4llvm17DominatorTreeBaseINS_10NodeTEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm17DominatorTreeBaseINS_10NodeTEEE")
//</editor-fold>
public class DominatorTreeBase</*class*/ NodeT>  extends /*public*/ DominatorBase<NodeT> implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::DominatorTreeBase<N>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", old_line = 187,
   FQN="llvm::DominatorTreeBase::DominatorTreeBase<N>", NM="_ZN4llvm17DominatorTreeBaseC1ERKNS_17DominatorTreeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBaseC1ERKNS_17DominatorTreeBaseIT_EE")
  //</editor-fold>
  protected/*private*/ DominatorTreeBase(final /*const*/DominatorTreeBase<NodeT> /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 189,
   FQN="llvm::DominatorTreeBase::operator=", NM="_ZN4llvm17DominatorTreeBaseaSERKNS_17DominatorTreeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBaseaSERKNS_17DominatorTreeBaseIT_EE")
  //</editor-fold>
  protected/*private*/ DominatorTreeBase<NodeT> /*&*/ $assign(final /*const*/DominatorTreeBase<NodeT> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::dominatedBySlowTreeWalk">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 191,
   FQN="llvm::DominatorTreeBase::dominatedBySlowTreeWalk", NM="_ZNK4llvm17DominatorTreeBase23dominatedBySlowTreeWalkEPKNS_15DomTreeNodeBaseIT_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase23dominatedBySlowTreeWalkEPKNS_15DomTreeNodeBaseIT_EES5_")
  //</editor-fold>
  private boolean dominatedBySlowTreeWalk(/*const*/DomTreeNodeBase<NodeT> /*P*/ A,
                         /*const*/DomTreeNodeBase<NodeT> /*P*/ B) /*const*/ {
    assert (A != B);
    assert (isReachableFromEntry(B));
    assert (isReachableFromEntry(A));

    /*const*/DomTreeNodeBase<NodeT> /*P*/ IDom;
    while ((IDom = B.getIDom()) != null && IDom != A && IDom != B) {
      B = IDom; // Walk up the tree
    }
    return IDom != null;
  }

  
  /// \brief Wipe this tree's state without releasing any resources.
  ///
  /// This is essentially a post-move helper only. It leaves the object in an
  /// assignable and destroyable state, but otherwise invalid.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::wipe">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 207,
   FQN="llvm::DominatorTreeBase::wipe", NM="_ZN4llvm17DominatorTreeBase4wipeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase4wipeEv")
  //</editor-fold>
  private void wipe() {
    DomTreeNodes.clear();
    IDoms.clear();
    Vertex.clear();
    Info.clear();
    RootNode = null;
  }

/*protected:*/
  // JAVA: typedef DenseMap<NodeT *, std::unique_ptr<DomTreeNodeBase<NodeT> > > DomTreeNodeMapType
//  public final class DomTreeNodeMapType extends DenseMap<NodeT /*P*/ , std.unique_ptr<DomTreeNodeBase<NodeT>>>{ };
  /*friend*/public final DenseMap<NodeT /*P*/ , std.unique_ptr<DomTreeNodeBase<NodeT>>> DomTreeNodes;
  /*friend*/public DomTreeNodeBase<NodeT> /*P*/ RootNode;
  
  protected /*mutable */boolean DFSInfoValid;
  protected /*mutable *//*uint*/int SlowQueries;
  // Information record used during immediate dominators computation.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::InfoRec">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 224,
   FQN="llvm::DominatorTreeBase::InfoRec", NM="_ZN4llvm17DominatorTreeBase7InfoRecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase7InfoRecE")
  //</editor-fold>
  public static class/*struct*/ InfoRec<NodeT> implements NativeCloneable<InfoRec<NodeT>>, NativeMoveable<InfoRec<NodeT>> {
    public /*uint*/int DFSNum;
    public /*uint*/int Parent;
    public /*uint*/int Semi;
    public NodeT /*P*/ Label;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::InfoRec::InfoRec">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 230,
     FQN="llvm::DominatorTreeBase::InfoRec::InfoRec", NM="_ZN4llvm17DominatorTreeBase7InfoRecC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase7InfoRecC1Ev")
    //</editor-fold>
    public InfoRec() {
      // : DFSNum(0), Parent(0), Semi(0), Label(null) 
      //START JInit
      this.DFSNum = 0;
      this.Parent = 0;
      this.Semi = 0;
      this.Label = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase<NodeT>::InfoRec::InfoRec">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 224,
     FQN="llvm::DominatorTreeBase<NodeT>::InfoRec::InfoRec", NM="_ZN4llvm17DominatorTreeBaseINS_10NodeTEE7InfoRecC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm17DominatorTreeBaseINS_10NodeTEE7InfoRecC1EOS3_")
    //</editor-fold>
    public /*inline*/ InfoRec(JD$Move _dparam, final InfoRec<NodeT> /*&&*/$Prm0) {
      // : DFSNum(static_cast<InfoRec &&>().DFSNum), Parent(static_cast<InfoRec &&>().Parent), Semi(static_cast<InfoRec &&>().Semi), Label(static_cast<InfoRec &&>().Label)
      //START JInit
      this.DFSNum = $Prm0.DFSNum;
      this.Parent = $Prm0.Parent;
      this.Semi = $Prm0.Semi;
      this.Label = $Prm0.Label;
      //END JInit
    }
    
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN
    
    //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase<NodeT>::InfoRec::InfoRec">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 224,
     FQN="llvm::DominatorTreeBase<NodeT>::InfoRec::InfoRec", NM="_ZN4llvm17DominatorTreeBaseINS_10NodeTEE7InfoRecC1ERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm17DominatorTreeBaseINS_10NodeTEE7InfoRecC1ERKS3_")
    //</editor-fold>
    public /*inline*/ InfoRec(final /*const*/ InfoRec<NodeT> /*&*/ $Prm0) {
      // : DFSNum(.DFSNum), Parent(.Parent), Semi(.Semi), Label(.Label)
      //START JInit
      this.DFSNum = $Prm0.DFSNum;
      this.Parent = $Prm0.Parent;
      this.Semi = $Prm0.Semi;
      this.Label = $Prm0.Label;
      //END JInit
    }
    
    @Override public InfoRec<NodeT> clone() {
      return new InfoRec(this);
    }
    
    @Override public InfoRec<NodeT> move() {
      return new InfoRec(JD$Move.INSTANCE, this);
    }
    
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "DFSNum=" + DFSNum // NOI18N
                + ", Parent=" + Parent // NOI18N
                + ", Semi=" + Semi // NOI18N
                + ", Label=" + Label; // NOI18N
    }
  };
  
  /*friend*/public final DenseMap<NodeT /*P*/ , NodeT /*P*/ > IDoms;
  
  // Vertex - Map the DFS number to the NodeT*
  /*friend*/public final std.vector<NodeT /*P*/ > Vertex;
  
  // Info - Collection of information used during the computation of idoms.
  /*friend*/public final DenseMap<NodeT /*P*/ , InfoRec<NodeT>> Info;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::reset">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 241,
   FQN="llvm::DominatorTreeBase::reset", NM="_ZN4llvm17DominatorTreeBase5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase5resetEv")
  //</editor-fold>
  protected void reset() {
    DomTreeNodes.clear();
    IDoms.clear();
    /*J:ToBase*/super.Roots.clear();
    Vertex.clear();
    RootNode = null;
    DFSInfoValid = false;
    SlowQueries = 0;
  }

  
  // NewBB is split and now it has one successor. Update dominator tree to
  // reflect this change.
  /*template <class N, class GraphT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::Split">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 254,
   FQN="llvm::DominatorTreeBase::Split", NM="Tpl__ZN4llvm17DominatorTreeBase5SplitERNS_17DominatorTreeBaseINT0_8NodeTypeEEEPS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=Tpl__ZN4llvm17DominatorTreeBase5SplitERNS_17DominatorTreeBaseINT0_8NodeTypeEEEPS3_")
  //</editor-fold>
  protected </*class*/ N extends NodeT, /*class*/ NodeType extends NodeT> void Split(
          GraphTraits<?, NodeType, NodeType> GraphT,
          final DominatorTreeBase<NodeT> /*&*/ DT,
        NodeType /*P*/ NewBB) {
    assert Native.$bool(Native.$eq(std.distance(GraphT.child_begin(NewBB), GraphT.child_end(NewBB)), 1)) : "NewBB should have a single successor!";
     NodeType /*P*/ NewBBSucc = $Deref(GraphT.child_begin(NewBB));

    std.vector< NodeT /*P*/ > PredBlocks = new std.vector<NodeT /*P*/ >((NodeT /*P*/)null);
    // JAVA: typedef GraphTraits<Inverse<N> > InvTraits
//    final class InvTraits extends GraphTraits<Inverse<N> >{ };
    for ( type$iterator<? extends type$iterator, NodeT /*P*/> PI = GraphTraits_InverseNodeT.child_begin(NewBB),
        PE = GraphTraits_InverseNodeT.child_end(NewBB);
         Native.$noteq(PI, PE); PI.$preInc())  {
      PredBlocks.push_back(PI.$star());
    }
    assert Native.$bool(Native.$not(PredBlocks.empty())) : "No predblocks?";

    boolean NewBBDominatesNewBBSucc = true;
    for ( type$iterator<? extends type$iterator, NodeT /*P*/> PI = GraphTraits_InverseNodeT.child_begin(NewBBSucc),
        E = GraphTraits_InverseNodeT.child_end(NewBBSucc);
         Native.$noteq(PI, E); PI.$preInc()) {
      NodeT /*P*/ ND = PI.$star();
      if (Native.$bool(Native.$bool(Native.$noteq(ND, NewBB)) && Native.$not(DT.dominates(NewBBSucc, ND)))
         && Native.$bool(DT.isReachableFromEntry(ND))) {
        NewBBDominatesNewBBSucc = false;
        break;
      }
    }

    // Find NewBB's immediate dominator and create new dominator tree node for
    // NewBB.
    NodeT /*P*/ NewBBIDom = null;
    /*uint*/int i = 0;
    for (i = 0; Native.$less(i, PredBlocks.size()); ++i)  {
      if (DT.isReachableFromEntry(PredBlocks.$at(i))) {
        NewBBIDom = PredBlocks.$at(i);
        break;
      }
    }

    // It's possible that none of the predecessors of NewBB are reachable;
    // in that case, NewBB itself is unreachable, so nothing needs to be
    // changed.
    if (Native.$not(NewBBIDom)) {
      return;
    }

    for (i = i + 1; Native.$less(i, PredBlocks.size()); ++i) {
      if (DT.isReachableFromEntry(PredBlocks.$at(i))) {
        NewBBIDom = DT.findNearestCommonDominator_T$P(NewBBIDom, PredBlocks.$at(i));
      }
    }

    // Create the new dominator tree node... and set the idom of NewBB.
    DomTreeNodeBase<NodeT> /*P*/ NewBBNode = DT.addNewBlock(NewBB, NewBBIDom);

    // If NewBB strictly dominates other blocks, then it is now the immediate
    // dominator of NewBBSucc.  Update the dominator tree as appropriate.
    if (NewBBDominatesNewBBSucc) {
      DomTreeNodeBase<NodeT> /*P*/ NewBBSuccNode = DT.getNode(NewBBSucc);
      DT.changeImmediateDominator(NewBBSuccNode, NewBBNode);
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::DominatorTreeBase<N>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 317,
   FQN="llvm::DominatorTreeBase::DominatorTreeBase<N>", NM="_ZN4llvm17DominatorTreeBaseC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBaseC1Eb")
  //</editor-fold>
  public /*explicit*/ DominatorTreeBase(GraphTraits GraphTraits_NodeT, GraphTraits GraphTraits_InverseNodeT, NodeType$GetParent<NodeT, ?> GetParent, NodeType$GetParent$FrontEntry<NodeT, NodeT> GetParent$FrontEntry,
          boolean isPostDom) {
    // : DominatorBase<NodeT>(isPostDom), DomTreeNodes(), DFSInfoValid(false), SlowQueries(0), IDoms(), Vertex(), Info()
    //START JInit
    super(isPostDom);
    this.DomTreeNodes = new DenseMap<NodeT /*P*/ , std.unique_ptr<DomTreeNodeBase<NodeT>>>(DenseMapInfo$LikePtr.$Info(), new std.unique_ptr<DomTreeNodeBase<NodeT>>());
    this.DFSInfoValid = false;
    this.SlowQueries = 0;
    this.IDoms = new DenseMap<NodeT /*P*/ , NodeT /*P*/ >(DenseMapInfo$LikePtr.$Info(), (NodeT /*P*/ )null);
    this.Vertex = new std.vector<NodeT /*P*/ >((NodeT /*P*/ )null);
    this.Info = new DenseMap<NodeT /*P*/ , InfoRec<NodeT>>(DenseMapInfo$LikePtr.$Info(), new InfoRec<>());
    //END JInit
    this.GraphTraits_NodeT = GraphTraits_NodeT;
    this.GraphTraits_InverseNodeT = GraphTraits_InverseNodeT;    
    this.$getParent = GetParent;
    this.$getParent$FrontEntry = GetParent$FrontEntry;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::DominatorTreeBase<N>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 320,
   FQN="llvm::DominatorTreeBase::DominatorTreeBase<N>", NM="_ZN4llvm17DominatorTreeBaseC1EONS_17DominatorTreeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBaseC1EONS_17DominatorTreeBaseIT_EE")
  //</editor-fold>
  public DominatorTreeBase(JD$Move _dparam, final DominatorTreeBase<NodeT> /*&*/ Arg) {
    // : DominatorBase<NodeT>(std::move(static_cast<DominatorBase<NodeT> & >(Arg))), DomTreeNodes(std::move(Arg.DomTreeNodes)), RootNode(std::move(Arg.RootNode)), DFSInfoValid(std::move(Arg.DFSInfoValid)), SlowQueries(std::move(Arg.SlowQueries)), IDoms(std::move(Arg.IDoms)), Vertex(std::move(Arg.Vertex)), Info(std::move(Arg.Info)) 
    //START JInit
    super(JD$Move.INSTANCE, std.move(((/*static_cast*/DominatorBase<NodeT> /*&*/ )(Arg))));
    this.DomTreeNodes = new DenseMap<NodeT /*P*/ , std.unique_ptr<DomTreeNodeBase<NodeT>>>(JD$Move.INSTANCE, std.move(Arg.DomTreeNodes));
    this.RootNode = std.move(Arg.RootNode);
    this.DFSInfoValid = std.move(Arg.DFSInfoValid);
    this.SlowQueries = std.move(Arg.SlowQueries);
    this.IDoms = new DenseMap<NodeT /*P*/ , NodeT /*P*/ >(JD$Move.INSTANCE, std.move(Arg.IDoms));
    this.Vertex = new std.vector<NodeT /*P*/ >(JD$Move.INSTANCE, std.move(Arg.Vertex));
    this.Info = new DenseMap<NodeT /*P*/ , InfoRec<NodeT>>(JD$Move.INSTANCE, std.move(Arg.Info));
    //END JInit
    this.GraphTraits_NodeT = Arg.GraphTraits_NodeT;
    this.GraphTraits_InverseNodeT = Arg.GraphTraits_InverseNodeT;
    this.$getParent = Arg.$getParent;
    this.$getParent$FrontEntry = Arg.$getParent$FrontEntry;
    Arg.wipe();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 330,
   FQN="llvm::DominatorTreeBase::operator=", NM="_ZN4llvm17DominatorTreeBaseaSEONS_17DominatorTreeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBaseaSEONS_17DominatorTreeBaseIT_EE")
  //</editor-fold>
  public DominatorTreeBase<NodeT> /*&*/ $assignMove(final DominatorTreeBase<NodeT> /*&*/ RHS) {
    super.$assignMove(std.move(((/*static_cast*/DominatorBase<NodeT> /*&*/ )(RHS))));
    assert this.GraphTraits_NodeT == RHS.GraphTraits_NodeT;
    assert this.GraphTraits_InverseNodeT == RHS.GraphTraits_InverseNodeT;
    assert this.$getParent == RHS.$getParent;
    assert this.$getParent$FrontEntry == RHS.$getParent$FrontEntry;
    DomTreeNodes.$assignMove(std.move(RHS.DomTreeNodes));
    RootNode = std.move(RHS.RootNode);
    DFSInfoValid = std.move(RHS.DFSInfoValid);
    SlowQueries = std.move(RHS.SlowQueries);
    IDoms.$assignMove(std.move(RHS.IDoms));
    Vertex.$assignMove(std.move(RHS.Vertex));
    Info.$assignMove(std.move(RHS.Info));
    RHS.wipe();
    return /*Deref*/this;
  }

  
  /// compare - Return false if the other dominator tree base matches this
  /// dominator tree base. Otherwise return true.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 346,
   FQN="llvm::DominatorTreeBase::compare", NM="_ZNK4llvm17DominatorTreeBase7compareERKNS_17DominatorTreeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase7compareERKNS_17DominatorTreeBaseIT_EE")
  //</editor-fold>
  public boolean compare(final /*const*/DominatorTreeBase<NodeT> /*&*/ Other) /*const*/ {

    final /*const*/DenseMap<NodeT /*P*/ , std.unique_ptr<DomTreeNodeBase<NodeT>>> /*&*/ OtherDomTreeNodes = Other.DomTreeNodes;
    if (DomTreeNodes.size() != OtherDomTreeNodes.size()) {
      return true;
    }

    for (final /*const*/std.pair<NodeT /*P*/ , unique_ptr<DomTreeNodeBase<NodeT>>> /*&*/ DomTreeNode : this.DomTreeNodes) {
      NodeT /*P*/ BB = DomTreeNode.first;
      DenseMapIterator<NodeT /*P*/ , unique_ptr<DomTreeNodeBase<NodeT>>> OI = OtherDomTreeNodes.find$Const(BB);
      if (OI.$eq(OtherDomTreeNodes.end$Const())) {
        return true;
      }

      final DomTreeNodeBase<NodeT> /*&*/ MyNd = DomTreeNode.second.$star();
      final DomTreeNodeBase<NodeT> /*&*/ OtherNd = OI.$arrow().second.$star();
      if (MyNd.compare($AddrOf(OtherNd))) {
        return true;
      }
    }

    return false;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 369,
   FQN="llvm::DominatorTreeBase::releaseMemory", NM="_ZN4llvm17DominatorTreeBase13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    reset();
  }

  
  /// getNode - return the (Post)DominatorTree node for the specified basic
  /// block.  This is the same as using operator[] on this class.  The result
  /// may (but is not required to) be null for a forward (backwards)
  /// statically unreachable block.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::getNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 375,
   FQN="llvm::DominatorTreeBase::getNode", NM="_ZNK4llvm17DominatorTreeBase7getNodeEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase7getNodeEPT_")
  //</editor-fold>
  public DomTreeNodeBase<NodeT> /*P*/ getNode(NodeT /*P*/ BB) /*const*/ {
    DenseMapIterator<NodeT /*P*/ , unique_ptr<DomTreeNodeBase<NodeT>>> I = DomTreeNodes.find$Const(BB);
    if (I.$noteq(DomTreeNodes.end$Const())) {
      return I.$arrow().second.get();
    }
    return null;
  }

  
  /// See getNode.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 383,
   FQN="llvm::DominatorTreeBase::operator[]", NM="_ZNK4llvm17DominatorTreeBaseixEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBaseixEPT_")
  //</editor-fold>
  public DomTreeNodeBase<NodeT> /*P*/ $at(NodeT /*P*/ BB) /*const*/ {
    return getNode(BB);
  }

  
  /// getRootNode - This returns the entry node for the CFG of the function.  If
  /// this tree represents the post-dominance relations for a function, however,
  /// this root may be a node with the block == NULL.  This is the case when
  /// there are multiple exit nodes from a particular function.  Consumers of
  /// post-dominance information must be capable of dealing with this
  /// possibility.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::getRootNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 392,
   FQN="llvm::DominatorTreeBase::getRootNode", NM="_ZN4llvm17DominatorTreeBase11getRootNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase11getRootNodeEv")
  //</editor-fold>
  public DomTreeNodeBase<NodeT> /*P*/ getRootNode() {
    return RootNode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::getRootNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 393,
   FQN="llvm::DominatorTreeBase::getRootNode", NM="_ZNK4llvm17DominatorTreeBase11getRootNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase11getRootNodeEv")
  //</editor-fold>
  public /*const*/DomTreeNodeBase<NodeT> /*P*/ getRootNode$Const() /*const*/ {
    return RootNode;
  }

  
  /// Get all nodes dominated by R, including R itself.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::getDescendants">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 396,
   FQN="llvm::DominatorTreeBase::getDescendants", NM="_ZNK4llvm17DominatorTreeBase14getDescendantsEPT_RNS_15SmallVectorImplIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase14getDescendantsEPT_RNS_15SmallVectorImplIS2_EE")
  //</editor-fold>
  public void getDescendants(NodeT /*P*/ R, final SmallVectorImpl<NodeT /*P*/ > /*&*/ Result) /*const*/ {
    Result.clear();
    /*const*/DomTreeNodeBase<NodeT> /*P*/ RN = getNode(R);
    if (!(RN != null)) {
      return; // If R is unreachable, it will not be present in the DOM tree.
    }
    SmallVector</*const*/DomTreeNodeBase<NodeT> /*P*/> WL/*J*/= new SmallVector</*const*/DomTreeNodeBase<NodeT> /*P*/>(8, (/*const*/DomTreeNodeBase<NodeT> /*P*/)null);
    WL.push_back(RN);
    while (!WL.empty()) {
      /*const*/DomTreeNodeBase<NodeT> /*P*/ N = WL.pop_back_val();
      Result.push_back(N.getBlock());
      WL.append_T(N.begin$Const(), N.end$Const());
    }
  }

  
  /// properlyDominates - Returns true iff A dominates B and A != B.
  /// Note that this is not a constant time operation!
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::properlyDominates">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 414,
   FQN="llvm::DominatorTreeBase::properlyDominates", NM="_ZNK4llvm17DominatorTreeBase17properlyDominatesEPKNS_15DomTreeNodeBaseIT_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase17properlyDominatesEPKNS_15DomTreeNodeBaseIT_EES5_")
  //</editor-fold>
  public boolean properlyDominates(/*const*/DomTreeNodeBase<NodeT> /*P*/ A,
                   /*const*/DomTreeNodeBase<NodeT> /*P*/ B) /*const*/ {
    if (!(A != null) || !(B != null)) {
      return false;
    }
    if (A == B) {
      return false;
    }
    return dominates(A, B);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::properlyDominates">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 754,
   FQN="llvm::DominatorTreeBase::properlyDominates", NM="_ZNK4llvm17DominatorTreeBase17properlyDominatesEPKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase17properlyDominatesEPKT_S3_")
  //</editor-fold>
  public boolean properlyDominates(/*const*/ NodeT /*P*/ A, /*const*/ NodeT /*P*/ B) /*const*/ {
    if (A == B) {
      return false;
    }

    // Cast away the const qualifiers here. This is ok since
    // this function doesn't actually return the values returned
    // from getNode.
    return dominates(getNode(((/*const_cast*/NodeT /*P*/ )(A))),
        getNode(((/*const_cast*/NodeT /*P*/ )(B))));
  }
  

  /// isReachableFromEntry - Return true if A is dominated by the entry
  /// block of the function containing it.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::isReachableFromEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 427,
   FQN="llvm::DominatorTreeBase::isReachableFromEntry", NM="_ZNK4llvm17DominatorTreeBase20isReachableFromEntryEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase20isReachableFromEntryEPKT_")
  //</editor-fold>
  public boolean isReachableFromEntry(/*const*/ NodeT /*P*/ A) /*const*/ {
    assert (!/*J:ToBase*/super.isPostDominator()) : "This is not implemented for post dominators";
    return isReachableFromEntry(getNode(((/*const_cast*/NodeT /*P*/ )(A))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::isReachableFromEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 433,
   FQN="llvm::DominatorTreeBase::isReachableFromEntry", NM="_ZNK4llvm17DominatorTreeBase20isReachableFromEntryEPKNS_15DomTreeNodeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase20isReachableFromEntryEPKNS_15DomTreeNodeBaseIT_EE")
  //</editor-fold>
  public boolean isReachableFromEntry(/*const*/DomTreeNodeBase<NodeT> /*P*/ A) /*const*/ {
    return (A != null);
  }

  
  /// dominates - Returns true iff A dominates B.  Note that this is not a
  /// constant time operation!
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::dominates">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 438,
   FQN="llvm::DominatorTreeBase::dominates", NM="_ZNK4llvm17DominatorTreeBase9dominatesEPKNS_15DomTreeNodeBaseIT_EES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase9dominatesEPKNS_15DomTreeNodeBaseIT_EES5_")
  //</editor-fold>
  public boolean dominates(/*const*/DomTreeNodeBase<NodeT> /*P*/ A,
           /*const*/DomTreeNodeBase<NodeT> /*P*/ B) /*const*/ {
    // A node trivially dominates itself.
    if (B == A) {
      return true;
    }

    // An unreachable node is dominated by anything.
    if (!isReachableFromEntry(B)) {
      return true;
    }
  
    // And dominates nothing.
    if (!isReachableFromEntry(A)) {
      return false;
    }
    if (DFSInfoValid) {
      return B.DominatedBy(A);
    }
  
    // If we end up with too many slow queries, just update the
    // DFS numbers on the theory that we are going to keep querying.
    SlowQueries++;
    if ($greater_uint(SlowQueries, 32)) {
      updateDFSNumbers();
      return B.DominatedBy(A);
    }

    return dominatedBySlowTreeWalk(A, B);
  }


  // These two functions are declared out of line as a workaround for building
  // with old (< r147295) versions of clang because of pr11642.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::dominates">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 743,
   FQN="llvm::DominatorTreeBase::dominates", NM="_ZNK4llvm17DominatorTreeBase9dominatesEPKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase9dominatesEPKT_S3_")
  //</editor-fold>
  public boolean dominates(/*const*/ NodeT /*P*/ A, /*const*/ NodeT /*P*/ B) /*const*/ {
    if (A == B) {
      return true;
    }

    // Cast away the const qualifiers here. This is ok since
    // this function doesn't actually return the values returned
    // from getNode.
    return dominates(getNode(((/*const_cast*/NodeT /*P*/ )(A))),
        getNode(((/*const_cast*/NodeT /*P*/ )(B))));
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::getRoot">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 476,
   FQN="llvm::DominatorTreeBase::getRoot", NM="_ZNK4llvm17DominatorTreeBase7getRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase7getRootEv")
  //</editor-fold>
  public NodeT /*P*/ getRoot() /*const*/ {
    assert (/*J:ToBase*/super.Roots.size() == 1) : "Should always have entry node!";
    return /*J:ToBase*/super.Roots.$at$Const(0);
  }

  
  /// findNearestCommonDominator - Find nearest common dominator basic block
  /// for basic block A and B. If there is no such block then return NULL.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::findNearestCommonDominator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 483,
   FQN="llvm::DominatorTreeBase::findNearestCommonDominator", NM="_ZN4llvm17DominatorTreeBase26findNearestCommonDominatorEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase26findNearestCommonDominatorEPT_S2_")
  //</editor-fold>
  public NodeT /*P*/ findNearestCommonDominator_T$P(NodeT /*P*/ A, NodeT /*P*/ B) {
    assert ($getParent.$call(A) == $getParent.$call(B)) : "Two blocks are not in same function";

    // If either A or B is a entry block then it is nearest common dominator
    // (for forward-dominators).
    if (!/*J:ToBase*/super.isPostDominator()) {
      final NodeT /*&*/ Entry = $getParent$FrontEntry.$call(A);
      if (A == $AddrOf(Entry) || B == $AddrOf(Entry)) {
        return $AddrOf(Entry);
      }
    }

    // If B dominates A then B is nearest common dominator.
    if (dominates(B, A)) {
      return B;
    }

    // If A dominates B then A is nearest common dominator.
    if (dominates(A, B)) {
      return A;
    }

    DomTreeNodeBase<NodeT> /*P*/ NodeA = getNode(A);
    DomTreeNodeBase<NodeT> /*P*/ NodeB = getNode(B);

    // If we have DFS info, then we can avoid all allocations by just querying
    // it from each IDom. Note that because we call 'dominates' twice above, we
    // expect to call through this code at most 16 times in a row without
    // building valid DFS information. This is important as below is a *very*
    // slow tree walk.
    if (DFSInfoValid) {
      DomTreeNodeBase<NodeT> /*P*/ IDomA = NodeA.getIDom();
      while ((IDomA != null)) {
        if (NodeB.DominatedBy(IDomA)) {
          return IDomA.getBlock();
        }
        IDomA = IDomA.getIDom();
      }
      return null;
    }

    // Collect NodeA dominators set.
    SmallPtrSet<DomTreeNodeBase<NodeT> /*P*/> NodeADoms/*J*/= new SmallPtrSet<DomTreeNodeBase<NodeT> /*P*/>(DenseMapInfo$LikePtr.$Info(), 16);
    NodeADoms.insert(NodeA);
    DomTreeNodeBase<NodeT> /*P*/ IDomA = NodeA.getIDom();
    while ((IDomA != null)) {
      NodeADoms.insert(IDomA);
      IDomA = IDomA.getIDom();
    }

    // Walk NodeB immediate dominators chain and find common dominator node.
    DomTreeNodeBase<NodeT> /*P*/ IDomB = NodeB.getIDom();
    while ((IDomB != null)) {
      if (NodeADoms.count(IDomB) != 0) {
        return IDomB.getBlock();
      }

      IDomB = IDomB.getIDom();
    }

    return null;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::findNearestCommonDominator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 542,
   FQN="llvm::DominatorTreeBase::findNearestCommonDominator", NM="_ZN4llvm17DominatorTreeBase26findNearestCommonDominatorEPKT_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase26findNearestCommonDominatorEPKT_S3_")
  //</editor-fold>
  public /*const*/ NodeT /*P*/ findNearestCommonDominator_T$C$P(/*const*/ NodeT /*P*/ A, /*const*/ NodeT /*P*/ B) {
    // Cast away the const qualifiers here. This is ok since
    // const is re-introduced on the return type.
    return findNearestCommonDominator_T$P(((/*const_cast*/NodeT /*P*/ )(A)),
        ((/*const_cast*/NodeT /*P*/ )(B)));
  }

  
  //===--------------------------------------------------------------------===//
  // API to update (Post)DominatorTree information based on modifications to
  // the CFG...
  
  /// addNewBlock - Add a new node to the dominator tree information.  This
  /// creates a new node as a child of DomBB dominator node,linking it into
  /// the children list of the immediate dominator.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::addNewBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 556,
   FQN="llvm::DominatorTreeBase::addNewBlock", NM="_ZN4llvm17DominatorTreeBase11addNewBlockEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase11addNewBlockEPT_S2_")
  //</editor-fold>
  public DomTreeNodeBase<NodeT> /*P*/ addNewBlock(NodeT /*P*/ BB, NodeT /*P*/ DomBB) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (getNode(BB) == null) : "Block already in dominator tree!";
      DomTreeNodeBase<NodeT> /*P*/ IDomNode = getNode(DomBB);
      assert ((IDomNode != null)) : "Not immediate dominator specified for block!";
      DFSInfoValid = false;
      return $c$.clean((DomTreeNodes.$at_T1$C$R(BB).$assignMove($c$.track(IDomNode.addChild($c$.track(llvm.make_unique(new DomTreeNodeBase<NodeT>(BB, IDomNode))))))).get());
    } finally {
      $c$.$destroy();
    }
  }

  
  /// changeImmediateDominator - This method is used to update the dominator
  /// tree information when a node's immediate dominator changes.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::changeImmediateDominator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 568,
   FQN="llvm::DominatorTreeBase::changeImmediateDominator", NM="_ZN4llvm17DominatorTreeBase24changeImmediateDominatorEPNS_15DomTreeNodeBaseIT_EES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase24changeImmediateDominatorEPNS_15DomTreeNodeBaseIT_EES4_")
  //</editor-fold>
  public void changeImmediateDominator(DomTreeNodeBase<NodeT> /*P*/ N, 
                          DomTreeNodeBase<NodeT> /*P*/ NewIDom) {
    assert ((N != null) && (NewIDom != null)) : "Cannot change null node pointers!";
    DFSInfoValid = false;
    N.setIDom(NewIDom);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::changeImmediateDominator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 575,
   FQN="llvm::DominatorTreeBase::changeImmediateDominator", NM="_ZN4llvm17DominatorTreeBase24changeImmediateDominatorEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase24changeImmediateDominatorEPT_S2_")
  //</editor-fold>
  public void changeImmediateDominator(NodeT /*P*/ BB, NodeT /*P*/ NewBB) {
    changeImmediateDominator(getNode(BB), getNode(NewBB));
  }

  
  /// eraseNode - Removes a node from the dominator tree. Block must not
  /// dominate any other blocks. Removes node from its immediate dominator's
  /// children list. Deletes dominator node associated with basic block BB.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::eraseNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 582,
   FQN="llvm::DominatorTreeBase::eraseNode", NM="_ZN4llvm17DominatorTreeBase9eraseNodeEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase9eraseNodeEPT_")
  //</editor-fold>
  public void eraseNode(NodeT /*P*/ BB) {
    DomTreeNodeBase<NodeT> /*P*/ Node = getNode(BB);
    assert ((Node != null)) : "Removing node that isn't in dominator tree.";
    assert (Node.getChildren().empty()) : "Node is not a leaf node.";

    // Remove node from immediate dominator's children list.
    DomTreeNodeBase<NodeT> /*P*/ IDom = Node.getIDom();
    if ((IDom != null)) {
      std.vector.iterator<DomTreeNodeBase<NodeT> /*P*/> I = std.find(IDom.Children.begin(), IDom.Children.end(), Node);
      assert ($noteq___normal_iterator$C(I, IDom.Children.end())) : "Not in immediate dominator children set!";
      // I am no longer your child...
      IDom.Children.erase(new std.vector.iterator</*const*/DomTreeNodeBase<NodeT> /*P*/>(I));
    }

    DomTreeNodes.erase(BB);
  }
  

  /// splitBlock - BB is split and now it has one successor. Update dominator
  /// tree to reflect this change.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::splitBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 603,
   FQN="llvm::DominatorTreeBase::splitBlock", NM="_ZN4llvm17DominatorTreeBase10splitBlockEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase10splitBlockEPT_")
  //</editor-fold>
  public void splitBlock(NodeT /*P*/ NewBB) {
    if (/*J:ToBase*/super.IsPostDominators) {
      this.Split(GraphTraits_InverseNodeT, /*Deref*/this,
          NewBB);
    } else {
      this.Split(GraphTraits_NodeT, /*Deref*/this, NewBB);
    }
  }

  
  /// print - Convert to human readable form
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 613,
   FQN="llvm::DominatorTreeBase::print", NM="_ZNK4llvm17DominatorTreeBase5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ o) /*const*/ {
    o.$out(/*KEEP_STR*/"=============================--------------------------------\n");
    if (/*J:ToBase*/super.isPostDominator()) {
      o.$out(/*KEEP_STR*/"Inorder PostDominator Tree: ");
    } else {
      o.$out(/*KEEP_STR*/"Inorder Dominator Tree: ");
    }
    if (!this.DFSInfoValid) {
      o.$out(/*KEEP_STR*/"DFSNumbers invalid: ").$out_uint(SlowQueries).$out(/*KEEP_STR*/" slow queries.");
    }
    o.$out(/*KEEP_STR*/$LF);

    // The postdom tree can have a null root if there are no returns.
    if ((getRootNode$Const() != null)) {
      PrintDomTree(getRootNode$Const(), o, 1);
    }
  }

/*protected:*/
  /*friend template <class GraphT> typename GraphT::NodeType *Eval(DominatorTreeBase<typename GraphT::NodeType> &DT, 
  typename GraphT::NodeType *V, unsigned int LastLinked)*/
  
  /*friend template <class GraphT> unsigned int DFSPass(DominatorTreeBase<typename GraphT::NodeType> &DT, 
  typename GraphT::NodeType *V, unsigned int N)*/
  
  /*friend template <class FuncT, class N> void Calculate(DominatorTreeBase<typename GraphTraits<N>::NodeType> &DT, FuncT &F)*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::getNodeForBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 643,
   FQN="llvm::DominatorTreeBase::getNodeForBlock", NM="_ZN4llvm17DominatorTreeBase15getNodeForBlockEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase15getNodeForBlockEPT_")
  //</editor-fold>
  /*friend*/public DomTreeNodeBase<NodeT> /*P*/ getNodeForBlock(NodeT /*P*/ BB) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        DomTreeNodeBase<NodeT> /*P*/ Node = getNode(BB);
        if ((Node != null)) {
          return Node;
        }
      }

      // Haven't calculated this node yet?  Get or calculate the node for the
      // immediate dominator.
      NodeT /*P*/ IDom = getIDom(BB);
      assert ((IDom != null) || this.DomTreeNodes.$at_T1$RR((NodeT /*P*/ )null).$bool());
      DomTreeNodeBase<NodeT> /*P*/ IDomNode = getNodeForBlock(IDom);

      // Add a new tree node for this NodeT, and link it as a child of
      // IDomNode
      return $c$.clean((this.DomTreeNodes.$at_T1$C$R(BB).$assignMove($c$.track(IDomNode.addChild($c$.track(llvm.make_unique(new DomTreeNodeBase<NodeT>(BB, IDomNode))))))).get());
    } finally {
      $c$.$destroy();
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::getIDom">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 660,
   FQN="llvm::DominatorTreeBase::getIDom", NM="_ZNK4llvm17DominatorTreeBase7getIDomEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase7getIDomEPT_")
  //</editor-fold>
  /*friend*/public NodeT /*P*/ getIDom(NodeT /*P*/ BB) /*const*/ {
    return IDoms.lookup(BB);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::addRoot">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 662,
   FQN="llvm::DominatorTreeBase::addRoot", NM="_ZN4llvm17DominatorTreeBase7addRootEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17DominatorTreeBase7addRootEPT_")
  //</editor-fold>
  protected void addRoot(NodeT /*P*/ BB) {
    /*J:ToBase*/super.Roots.push_back_T$C$R(BB);
  }

/*public:*/
  /// updateDFSNumbers - Assign In and Out numbers to the nodes while walking
  /// dominator tree in dfs order.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::updateDFSNumbers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 667,
   FQN="llvm::DominatorTreeBase::updateDFSNumbers", NM="_ZNK4llvm17DominatorTreeBase16updateDFSNumbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZNK4llvm17DominatorTreeBase16updateDFSNumbersEv")
  //</editor-fold>
  public void updateDFSNumbers() /*const*/ {
    if (DFSInfoValid) {
      SlowQueries = 0;
      return;
  }

    /*uint*/int DFSNum = 0;

    SmallVector<std.pairPtrType</*const*/DomTreeNodeBase<NodeT> /*P*/, std.vector.iterator</*const*/DomTreeNodeBase<NodeT> /*P*/>>> WorkStack/*J*/= new SmallVector<std.pairPtrType</*const*/DomTreeNodeBase<NodeT> /*P*/, std.vector.iterator</*const*/DomTreeNodeBase<NodeT> /*P*/>>>(32, new std.pairPtrType</*const*/DomTreeNodeBase<NodeT> /*P*/, std.vector.iterator</*const*/DomTreeNodeBase<NodeT> /*P*/>>());

    /*const*/DomTreeNodeBase<NodeT> /*P*/ ThisRoot = getRootNode$Const();
    if (!(ThisRoot != null)) {
      return;
    }

    // Even in the case of multiple exits that form the post dominator root
    // nodes, do not iterate over all exits, but start from the virtual root
    // node. Otherwise bbs, that are not post dominated by any exit but by the
    // virtual root node, will never be assigned a DFS number.
    WorkStack.push_back(std.make_pair_Ptr_T(ThisRoot, $Move(ThisRoot.begin$Const())));
    ThisRoot.DFSNumIn = DFSNum++;
    while (!WorkStack.empty()) {
      /*const*/DomTreeNodeBase<NodeT> /*P*/ Node = WorkStack.back().first;
      std.vector.iterator</*const*/DomTreeNodeBase<NodeT> /*P*/> ChildIt = new std.vector.iterator</*const*/DomTreeNodeBase<NodeT> /*P*/>(WorkStack.back().second);

      // If we visited all of the children of this node, "recurse" back up the
      // stack setting the DFOutNum.
      if ($eq___normal_iterator$C(ChildIt, Node.end$Const())) {
        Node.DFSNumOut = DFSNum++;
        WorkStack.pop_back();
      } else {
        // Otherwise, recursively visit this child.
        /*const*/DomTreeNodeBase<NodeT> /*P*/ Child = ChildIt.$star();
        WorkStack.back().second.$preInc();

        WorkStack.push_back(std.make_pair_Ptr_T(Child, $Move(Child.begin$Const())));
        Child.DFSNumIn = DFSNum++;
      }
    }

    SlowQueries = 0;
    DFSInfoValid = true;
  }

  
  /// recalculate - compute a dominator tree for the given function
  /*template <class FT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase::recalculate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 717,
   FQN="llvm::DominatorTreeBase::recalculate", NM="Tpl__ZN4llvm17DominatorTreeBase11recalculateERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=Tpl__ZN4llvm17DominatorTreeBase11recalculateERT_")
  //</editor-fold>
  public </*class*/ FT, ChildNode> void recalculate(GraphTraits<FT, NodeT, ChildNode> GraphTraits$FT, final FT /*&*/ F) {
    // JAVA: typedef GraphTraits<Function *> TraitsTy
  //  final class TraitsTy extends GraphTraitsFunction$P{ };
    reset();
    this.Vertex.push_back_T$RR((NodeT)null);
    if (!/*J:ToBase*/super.IsPostDominators) {
      // Initialize root
      NodeT /*P*/ entry = GraphTraits$FT.getEntryNode($AddrOf(F));
      addRoot(entry);

      AdtsupportLlvmGlobals.<FT, NodeT /*P*/ >Calculate(GraphTraits$FT, GraphTraits_NodeT, GraphTraits_InverseNodeT, /*Deref*/this, F);
    } else {
      // Initialize the roots list
      for (type$iterator<?, NodeT> I = GraphTraits$FT.nodes_begin($AddrOf(F)), 
          E = GraphTraits$FT.nodes_end($AddrOf(F));
           I.$noteq(E); I.$preInc())  {
        if (GraphTraits$FT.child_begin($AddrOf(I.$star())).$eq(GraphTraits$FT.child_end($AddrOf(I.$star())))) {
          addRoot($AddrOf(I.$star()));
        }
      }
      if (true) throw new UnsupportedOperationException("Debug from here with Native and fix Inverse<NodeT> call below");
      // JAVA: FIXME how to specify inverse here? Let's pass both GraphTraits_InverseNodeT
      AdtsupportLlvmGlobals.<FT, /*Inverse<*/NodeT /*P>*/ >Calculate(GraphTraits$FT, GraphTraits_InverseNodeT, GraphTraits_InverseNodeT, /*Deref*/this, F);
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //<editor-fold defaultstate="collapsed" desc="llvm::DominatorTreeBase<NodeT>::~DominatorTreeBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 33,
   FQN="llvm::DominatorTreeBase<NodeT>::~DominatorTreeBase", NM="_ZN4llvm17DominatorTreeBaseINS_10NodeTEED0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm17DominatorTreeBaseINS_10NodeTEED0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Info.$destroy();
    Vertex.$destroy();
    IDoms.$destroy();
    DomTreeNodes.$destroy();
    super.$destroy();
    //END JDestroy
  }
  
  private final GraphTraits GraphTraits_NodeT;
  private final GraphTraits GraphTraits_InverseNodeT;
  private final NodeType$GetParent<NodeT, ?> $getParent;
  private final NodeType$GetParent$FrontEntry<NodeT, NodeT> $getParent$FrontEntry;
          
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "DomTreeNodes=" + DomTreeNodes // NOI18N
              + ", RootNode=" + RootNode // NOI18N
              + ", DFSInfoValid=" + DFSInfoValid // NOI18N
              + ", SlowQueries=" + SlowQueries // NOI18N
              + ", IDoms=" + IDoms // NOI18N
              + ", Vertex=" + Vertex // NOI18N
              + ", Info=" + Info // NOI18N
              + super.toString(); // NOI18N
  }
}
