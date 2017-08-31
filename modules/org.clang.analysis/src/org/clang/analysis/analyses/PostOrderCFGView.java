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

package org.clang.analysis.analyses;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.llvm.GraphTraitsCFG$P;
import org.llvm.adt.java.Insertable;

//<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 29,
 FQN="clang::PostOrderCFGView", NM="_ZN5clang16PostOrderCFGViewE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGViewE")
//</editor-fold>
public class PostOrderCFGView extends /*public*/ ManagedAnalysis implements Iterable<CFGBlock>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp", line = 18,
   FQN="clang::PostOrderCFGView::anchor", NM="_ZN5clang16PostOrderCFGView6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN5clang16PostOrderCFGView6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }


/*public:*/
  /// \brief Implements a set of CFGBlocks using a BitVector.
  ///
  /// This class contains a minimal interface, primarily dictated by the SetType
  /// template parameter of the llvm::po_iterator template, as used with
  /// external storage. We also use this set to keep track of which CFGBlocks we
  /// visit during the analysis.
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::CFGBlockSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 38,
   FQN="clang::PostOrderCFGView::CFGBlockSet", NM="_ZN5clang16PostOrderCFGView11CFGBlockSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView11CFGBlockSetE")
  //</editor-fold>
  public static class CFGBlockSet implements Destructors.ClassWithDestructor, Insertable<NoneType, CFGBlock> {
    private BitVector VisitedBlockIDs;
  /*public:*/
    // po_iterator requires this iterator, but the only interface needed is the
    // value_type typedef.
    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::CFGBlockSet::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 43,
     FQN="clang::PostOrderCFGView::CFGBlockSet::iterator", NM="_ZN5clang16PostOrderCFGView11CFGBlockSet8iteratorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView11CFGBlockSet8iteratorE")
    //</editor-fold>
    public static class/*struct*/ iterator {
      /*typedef const CFGBlock *value_type*/
//      public final class value_type extends /*const*/ CFGBlock /*P*/ { };
      
      @Override public String toString() {
        return ""; // NOI18N
      }
    };
    
    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::CFGBlockSet::CFGBlockSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 45,
     FQN="clang::PostOrderCFGView::CFGBlockSet::CFGBlockSet", NM="_ZN5clang16PostOrderCFGView11CFGBlockSetC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView11CFGBlockSetC1Ev")
    //</editor-fold>
    public CFGBlockSet() {
      // : VisitedBlockIDs() 
      //START JInit
      this.VisitedBlockIDs = new BitVector();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::CFGBlockSet::CFGBlockSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 46,
     FQN="clang::PostOrderCFGView::CFGBlockSet::CFGBlockSet", NM="_ZN5clang16PostOrderCFGView11CFGBlockSetC1EPKNS_3CFGE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView11CFGBlockSetC1EPKNS_3CFGE")
    //</editor-fold>
    public CFGBlockSet(/*const*/ CFG /*P*/ G) {
      // : VisitedBlockIDs(G->getNumBlockIDs(), false) 
      //START JInit
      this.VisitedBlockIDs = new BitVector(G.getNumBlockIDs(), false);
      //END JInit
    }

    
    /// \brief Set the bit associated with a particular CFGBlock.
    /// This is the important method for the SetType template parameter.
    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::CFGBlockSet::insert">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 50,
     FQN="clang::PostOrderCFGView::CFGBlockSet::insert", NM="_ZN5clang16PostOrderCFGView11CFGBlockSet6insertEPKNS_8CFGBlockE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView11CFGBlockSet6insertEPKNS_8CFGBlockE")
    //</editor-fold>
    public std.pairTypeBool<NoneType> insert(/*const*/ CFGBlock /*P*/ Block) {
      // Note that insert() is called by po_iterator, which doesn't check to
      // make sure that Block is non-null.  Moreover, the CFGBlock iterator will
      // occasionally hand out null pointers for pruned edges, so we catch those
      // here.
      if (!(Block != null)) {
        return std.make_pair_E_bool(None, false); // if an edge is trivially false.
      }
      if (VisitedBlockIDs.test(Block.getBlockID())) {
        return std.make_pair_E_bool(None, false);
      }
      VisitedBlockIDs.set(Block.getBlockID());
      return std.make_pair_E_bool(None, true);
    }

    
    /// \brief Check if the bit for a CFGBlock has been already set.
    /// This method is for tracking visited blocks in the main threadsafety
    /// loop. Block must not be null.
    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::CFGBlockSet::alreadySet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 66,
     FQN="clang::PostOrderCFGView::CFGBlockSet::alreadySet", NM="_ZN5clang16PostOrderCFGView11CFGBlockSet10alreadySetEPKNS_8CFGBlockE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView11CFGBlockSet10alreadySetEPKNS_8CFGBlockE")
    //</editor-fold>
    public boolean alreadySet(/*const*/ CFGBlock /*P*/ Block) {
      return VisitedBlockIDs.test(Block.getBlockID());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::CFGBlockSet::~CFGBlockSet">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 38,
     FQN="clang::PostOrderCFGView::CFGBlockSet::~CFGBlockSet", NM="_ZN5clang16PostOrderCFGView11CFGBlockSetD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN5clang16PostOrderCFGView11CFGBlockSetD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      VisitedBlockIDs.$destroy();
      //END JDestroy
    }


    
    @Override public String toString() {
      return "" + "VisitedBlockIDs=" + VisitedBlockIDs; // NOI18N
    }
  };
/*private:*/
  /*typedef llvm::po_iterator<const CFG *, CFGBlockSet, true> po_iterator*/
//  public final class po_iterator extends po_iterator</*const*/ CFG /*P*/ , CFGBlockSet, true>{ };
  private std.vector</*const*/ CFGBlock /*P*/ > Blocks;
  
  /*typedef llvm::DenseMap<const CFGBlock *, unsigned int> BlockOrderTy*/
//  public final class BlockOrderTy extends DenseMapTypeUInt</*const*/ CFGBlock /*P*/ >{ };
  private DenseMapTypeUInt</*const*/ CFGBlock /*P*/ > BlockOrder;
/*public:*/
  /*typedef std::vector<const CFGBlock *>::reverse_iterator iterator*/
//  public final class iterator extends std.reverse_iterator</*const*/ CFGBlock /*&*/ >{ };
  /*typedef std::vector<const CFGBlock *>::const_reverse_iterator const_iterator*/
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::PostOrderCFGView">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp", line = 20,
   FQN="clang::PostOrderCFGView::PostOrderCFGView", NM="_ZN5clang16PostOrderCFGViewC1EPKNS_3CFGE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN5clang16PostOrderCFGViewC1EPKNS_3CFGE")
  //</editor-fold>
  public PostOrderCFGView(/*const*/ CFG /*P*/ cfg) {
    // : ManagedAnalysis(), Blocks(), BlockOrder() 
    //START JInit
    super();
    this.Blocks = new std.vector</*const*/ CFGBlock /*P*/ >((/*const*/ CFGBlock /*P*/ )null);
    this.BlockOrder = new DenseMapTypeUInt</*const*/ CFGBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
    CFGBlockSet BSet = null;
    try {
      Blocks.reserve(cfg.getNumBlockIDs());
      BSet/*J*/= new CFGBlockSet(cfg);
      po_iterator</*const*/ CFG /*P*/ , /*const*/ CFGBlock /*P*/ /*, true*/, CFGBlock.AdjacentBlock> I = null;
      po_iterator</*const*/ CFG /*P*/ , /*const*/ CFGBlock /*P*/ /*, true*/, CFGBlock.AdjacentBlock> E = null;
      try {
        
        for (I = po_iterator.</*const*/ CFG /*P*/ , /*const*/ CFGBlock /*P*/ /*, true*/, CFGBlock.AdjacentBlock>begin(GraphTraitsCFG$P.$GTraits(), cfg, BSet), 
            E = po_iterator.</*const*/ CFG /*P*/ , /*const*/ CFGBlock /*P*/ /*, true*/, CFGBlock.AdjacentBlock>end(GraphTraitsCFG$P.$GTraits(), cfg, BSet); I.$noteq(E); I.$preInc()) {
          BlockOrder.$set(I.$star(), Blocks.size() + 1);
          Blocks.push_back_T$RR(I.$star());
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
    } finally {
      if (BSet != null) { BSet.$destroy(); }
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 84,
   FQN="clang::PostOrderCFGView::begin", NM="_ZN5clang16PostOrderCFGView5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView5beginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ CFGBlock /*&*/ > begin() {
    return Blocks.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 85,
   FQN="clang::PostOrderCFGView::end", NM="_ZN5clang16PostOrderCFGView3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView3endEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ CFGBlock /*&*/ > end() {
    return Blocks.rend();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 87,
   FQN="clang::PostOrderCFGView::begin", NM="_ZNK5clang16PostOrderCFGView5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZNK5clang16PostOrderCFGView5beginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ CFGBlock /*&*/ > begin$Const() /*const*/ {
    return Blocks.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 88,
   FQN="clang::PostOrderCFGView::end", NM="_ZNK5clang16PostOrderCFGView3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZNK5clang16PostOrderCFGView3endEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ CFGBlock /*&*/ > end$Const() /*const*/ {
    return Blocks.rend$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 90,
   FQN="clang::PostOrderCFGView::empty", NM="_ZNK5clang16PostOrderCFGView5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZNK5clang16PostOrderCFGView5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return $eq_reverse_iterator$C(begin$Const(), end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::BlockOrderCompare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 95,
   FQN="clang::PostOrderCFGView::BlockOrderCompare", NM="_ZN5clang16PostOrderCFGView17BlockOrderCompareE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView17BlockOrderCompareE")
  //</editor-fold>
  public static class/*struct*/ BlockOrderCompare implements Compare<CFGBlock> {
    public final /*const*/ PostOrderCFGView /*&*/ POV;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::BlockOrderCompare::BlockOrderCompare">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 98,
     FQN="clang::PostOrderCFGView::BlockOrderCompare::BlockOrderCompare", NM="_ZN5clang16PostOrderCFGView17BlockOrderCompareC1ERKS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView17BlockOrderCompareC1ERKS0_")
    //</editor-fold>
    public BlockOrderCompare(final /*const*/ PostOrderCFGView /*&*/ pov) {
      // : POV(pov) 
      //START JInit
      this./*&*/POV=/*&*/pov;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::BlockOrderCompare::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp", line = 40,
     FQN="clang::PostOrderCFGView::BlockOrderCompare::operator()", NM="_ZNK5clang16PostOrderCFGView17BlockOrderCompareclEPKNS_8CFGBlockES4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZNK5clang16PostOrderCFGView17BlockOrderCompareclEPKNS_8CFGBlockES4_")
    //</editor-fold>
    public boolean $call(/*const*/ CFGBlock /*P*/ b1, 
         /*const*/ CFGBlock /*P*/ b2) /*const*/ {
      DenseMapIteratorTypeUInt</*const*/ CFGBlock /*P*/ /*P*/> b1It = POV.BlockOrder.find$Const(b1);
      DenseMapIteratorTypeUInt</*const*/ CFGBlock /*P*/ /*P*/> b2It = POV.BlockOrder.find$Const(b2);
      
      /*uint*/int b1V = (b1It.$eq(POV.BlockOrder.end$Const())) ? 0 : b1It.$arrow().second;
      /*uint*/int b2V = (b2It.$eq(POV.BlockOrder.end$Const())) ? 0 : b2It.$arrow().second;
      return $greater_uint(b1V, b2V);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::BlockOrderCompare::BlockOrderCompare">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 95,
     FQN="clang::PostOrderCFGView::BlockOrderCompare::BlockOrderCompare", NM="_ZN5clang16PostOrderCFGView17BlockOrderCompareC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView17BlockOrderCompareC1ERKS1_")
    //</editor-fold>
    public /*inline*/ BlockOrderCompare(final /*const*/ BlockOrderCompare /*&*/ $Prm0) {
      // : POV(.POV) 
      //START JInit
      this./*&*/POV=/*&*/$Prm0.POV;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::BlockOrderCompare::BlockOrderCompare">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 95,
     FQN="clang::PostOrderCFGView::BlockOrderCompare::BlockOrderCompare", NM="_ZN5clang16PostOrderCFGView17BlockOrderCompareC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN5clang16PostOrderCFGView17BlockOrderCompareC1EOS1_")
    //</editor-fold>
    public /*inline*/ BlockOrderCompare(JD$Move _dparam, final BlockOrderCompare /*&&*/$Prm0) {
      // : POV(static_cast<BlockOrderCompare &&>().POV) 
      //START JInit
      this./*&*/POV=/*&*/$Prm0.POV;
      //END JInit
     }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public boolean compare(CFGBlock a, CFGBlock b) { return $call(a, b); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "POV=" + POV; // NOI18N
    }
  };
  /*friend  struct BlockOrderCompare*/
  
  ;
  
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::getComparator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 102,
   FQN="clang::PostOrderCFGView::getComparator", NM="_ZNK5clang16PostOrderCFGView13getComparatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZNK5clang16PostOrderCFGView13getComparatorEv")
  //</editor-fold>
  public BlockOrderCompare getComparator() /*const*/ {
    return new BlockOrderCompare(/*Deref*/this);
  }

  
  // Used by AnalyisContext to construct this object.
  
  // Used by AnalyisContext to construct this object.
  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp", line = 38,
   FQN="clang::PostOrderCFGView::getTag", NM="_ZN5clang16PostOrderCFGView6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN5clang16PostOrderCFGView6getTagEv")
  //</editor-fold>
  public static /*const*/Object/*void P*/ getTag() {
    final/*static*/ Object x = getTag$$.x;
    return $AddrOf(x);
  }
  private static final class getTag$$ {
    static final/*static*/ Object x = PostOrderCFGView.class;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp", line = 31,
   FQN="clang::PostOrderCFGView::create", NM="_ZN5clang16PostOrderCFGView6createERNS_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN5clang16PostOrderCFGView6createERNS_19AnalysisDeclContextE")
  //</editor-fold>
  public static PostOrderCFGView /*P*/ create(final AnalysisDeclContext /*&*/ ctx) {
    /*const*/ CFG /*P*/ cfg = ctx.getCFG();
    if (!(cfg != null)) {
      return null;
    }
    return new PostOrderCFGView(cfg);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::PostOrderCFGView::~PostOrderCFGView">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/PostOrderCFGView.h", line = 29,
   FQN="clang::PostOrderCFGView::~PostOrderCFGView", NM="_ZN5clang16PostOrderCFGViewD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/PostOrderCFGView.cpp -nm=_ZN5clang16PostOrderCFGViewD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BlockOrder.$destroy();
    Blocks.$destroy();
    super.$destroy();
    //END JDestroy
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<CFGBlock /*P*/> iterator() { return new JavaIterator<>(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Blocks=" + Blocks // NOI18N
              + ", BlockOrder=" + BlockOrder // NOI18N
              + super.toString(); // NOI18N
  }
}
