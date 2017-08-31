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

package org.clang.analysis.analyses.consumed;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.analyses.consumed.*;

//<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 198,
 FQN="clang::consumed::ConsumedBlockInfo", NM="_ZN5clang8consumed17ConsumedBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfoE")
//</editor-fold>
public class ConsumedBlockInfo implements Destructors.ClassWithDestructor {
  private std.vector<std.unique_ptr<ConsumedStateMap>> StateMapsArray;
  private std.vectorUInt/*uint*/ VisitOrder;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::ConsumedBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 203,
   FQN="clang::consumed::ConsumedBlockInfo::ConsumedBlockInfo", NM="_ZN5clang8consumed17ConsumedBlockInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfoC1Ev")
  //</editor-fold>
  public ConsumedBlockInfo() {
    // : StateMapsArray(), VisitOrder()/* = default*/ 
    //START JInit
    this.StateMapsArray = new std.vector<std.unique_ptr<ConsumedStateMap>>(new std.unique_ptr<ConsumedStateMap>());
    this.VisitOrder = new std.vectorUInt/*uint*/();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 204,
   FQN="clang::consumed::ConsumedBlockInfo::operator=", NM="_ZN5clang8consumed17ConsumedBlockInfoaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfoaSEOS1_")
  //</editor-fold>
  public ConsumedBlockInfo /*&*/ $assignMove(final ConsumedBlockInfo /*&&*/Other) {
    StateMapsArray.$assignMove(std.move(Other.StateMapsArray));
    VisitOrder.$assignMove(std.move(Other.VisitOrder));
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::ConsumedBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 210,
   FQN="clang::consumed::ConsumedBlockInfo::ConsumedBlockInfo", NM="_ZN5clang8consumed17ConsumedBlockInfoC1EjPNS_16PostOrderCFGViewE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfoC1EjPNS_16PostOrderCFGViewE")
  //</editor-fold>
  public ConsumedBlockInfo(/*uint*/int NumBlocks, PostOrderCFGView /*P*/ SortedGraph) {
    // : StateMapsArray(NumBlocks), VisitOrder(NumBlocks, 0) 
    //START JInit
    this.StateMapsArray = new std.vector<std.unique_ptr<ConsumedStateMap>>(NumBlocks, new std.unique_ptr<ConsumedStateMap>());
    this.VisitOrder = new std.vectorUInt/*uint*/(NumBlocks, 0);
    //END JInit
    /*uint*/int VisitOrderCounter = 0;
    for (std.reverse_iterator</*const*/ CFGBlock /*&*/ > BI = SortedGraph.begin(), 
        BE = SortedGraph.end(); $noteq_reverse_iterator$C(BI, BE); BI.$preInc()) {
      VisitOrder.$set((BI.$star()).getBlockID(), VisitOrderCounter++);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::allBackEdgesVisited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1032,
   FQN="clang::consumed::ConsumedBlockInfo::allBackEdgesVisited", NM="_ZN5clang8consumed17ConsumedBlockInfo19allBackEdgesVisitedEPKNS_8CFGBlockES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfo19allBackEdgesVisitedEPKNS_8CFGBlockES4_")
  //</editor-fold>
  public boolean allBackEdgesVisited(/*const*/ CFGBlock /*P*/ CurrBlock, 
                     /*const*/ CFGBlock /*P*/ TargetBlock) {
    assert ((CurrBlock != null)) : "Block pointer must not be NULL";
    assert ((TargetBlock != null)) : "TargetBlock pointer must not be NULL";
    
    /*uint*/int CurrBlockOrder = VisitOrder.$at(CurrBlock.getBlockID());
    for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > PI = $tryClone(TargetBlock.pred_begin$Const()), 
        /*P*/ PE = $tryClone(TargetBlock.pred_end$Const()); $noteq_ptr(PI, PE); PI.$preInc()) {
      if (((PI.$star().$CFGBlock$P()) != null) && $less_uint(CurrBlockOrder, VisitOrder.$at((PI.$star()).$arrow().getBlockID()))) {
        return false;
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::addInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1047,
   FQN="clang::consumed::ConsumedBlockInfo::addInfo", NM="_ZN5clang8consumed17ConsumedBlockInfo7addInfoEPKNS_8CFGBlockEPNS0_16ConsumedStateMapERSt10unique_ptrIS5_St14default_deleteIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfo7addInfoEPKNS_8CFGBlockEPNS0_16ConsumedStateMapERSt10unique_ptrIS5_St14default_deleteIS5_EE")
  //</editor-fold>
  public void addInfo(/*const*/ CFGBlock /*P*/ Block, ConsumedStateMap /*P*/ StateMap, 
         final std.unique_ptr<ConsumedStateMap> /*&*/ OwnedStateMap) {
    assert ((Block != null)) : "Block pointer must not be NULL";
    
    final unique_ptr<ConsumedStateMap> /*&*/ Entry = StateMapsArray.$at(Block.getBlockID());
    if (Entry.$bool()) {
      Entry.$arrow().intersect($Deref(StateMap));
    } else if (OwnedStateMap.$bool()) {
      Entry.$assignMove(std.move(OwnedStateMap));
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Entry.$assignMove($c$.track(llvm.make_unique(new ConsumedStateMap($Deref(StateMap))))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::addInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1063,
   FQN="clang::consumed::ConsumedBlockInfo::addInfo", NM="_ZN5clang8consumed17ConsumedBlockInfo7addInfoEPKNS_8CFGBlockESt10unique_ptrINS0_16ConsumedStateMapESt14default_deleteIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfo7addInfoEPKNS_8CFGBlockESt10unique_ptrINS0_16ConsumedStateMapESt14default_deleteIS6_EE")
  //</editor-fold>
  public void addInfo(/*const*/ CFGBlock /*P*/ Block, 
         std.unique_ptr<ConsumedStateMap> StateMap) {
    assert ((Block != null)) : "Block pointer must not be NULL";
    
    final unique_ptr<ConsumedStateMap> /*&*/ Entry = StateMapsArray.$at(Block.getBlockID());
    if (Entry.$bool()) {
      Entry.$arrow().intersect(StateMap.$star());
    } else {
      Entry.$assignMove(std.move(StateMap));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::borrowInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1077,
   FQN="clang::consumed::ConsumedBlockInfo::borrowInfo", NM="_ZN5clang8consumed17ConsumedBlockInfo10borrowInfoEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfo10borrowInfoEPKNS_8CFGBlockE")
  //</editor-fold>
  public ConsumedStateMap /*P*/ borrowInfo(/*const*/ CFGBlock /*P*/ Block) {
    assert ((Block != null)) : "Block pointer must not be NULL";
    assert (StateMapsArray.$at(Block.getBlockID()).$bool()) : "Block has no block info";
    
    return StateMapsArray.$at(Block.getBlockID()).get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::discardInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1084,
   FQN="clang::consumed::ConsumedBlockInfo::discardInfo", NM="_ZN5clang8consumed17ConsumedBlockInfo11discardInfoEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfo11discardInfoEPKNS_8CFGBlockE")
  //</editor-fold>
  public void discardInfo(/*const*/ CFGBlock /*P*/ Block) {
    StateMapsArray.$at(Block.getBlockID()).$assign_nullptr_t(null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::getInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1088,
   FQN="clang::consumed::ConsumedBlockInfo::getInfo", NM="_ZN5clang8consumed17ConsumedBlockInfo7getInfoEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfo7getInfoEPKNS_8CFGBlockE")
  //</editor-fold>
  public std.unique_ptr<ConsumedStateMap> getInfo(/*const*/ CFGBlock /*P*/ Block) {
    assert ((Block != null)) : "Block pointer must not be NULL";
    
    final unique_ptr<ConsumedStateMap> /*&*/ Entry = StateMapsArray.$at(Block.getBlockID());
    return isBackEdgeTarget(Block) ? llvm.make_unique(new ConsumedStateMap(Entry.$star())) : new unique_ptr<ConsumedStateMap>(JD$Move.INSTANCE, std.move(Entry));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::isBackEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1097,
   FQN="clang::consumed::ConsumedBlockInfo::isBackEdge", NM="_ZN5clang8consumed17ConsumedBlockInfo10isBackEdgeEPKNS_8CFGBlockES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfo10isBackEdgeEPKNS_8CFGBlockES4_")
  //</editor-fold>
  public boolean isBackEdge(/*const*/ CFGBlock /*P*/ From, /*const*/ CFGBlock /*P*/ To) {
    assert ((From != null)) : "From block must not be NULL";
    assert ((To != null)) : "From block must not be NULL";
    
    return $greater_uint(VisitOrder.$at(From.getBlockID()), VisitOrder.$at(To.getBlockID()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::isBackEdgeTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp", line = 1104,
   FQN="clang::consumed::ConsumedBlockInfo::isBackEdgeTarget", NM="_ZN5clang8consumed17ConsumedBlockInfo16isBackEdgeTargetEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfo16isBackEdgeTargetEPKNS_8CFGBlockE")
  //</editor-fold>
  public boolean isBackEdgeTarget(/*const*/ CFGBlock /*P*/ Block) {
    assert ((Block != null)) : "Block pointer must not be NULL";
    
    // Anything with less than two predecessors can't be the target of a back
    // edge.
    if ($less_uint(Block.pred_size(), 2)) {
      return false;
    }
    
    /*uint*/int BlockVisitOrder = VisitOrder.$at(Block.getBlockID());
    for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > PI = $tryClone(Block.pred_begin$Const()), 
        /*P*/ PE = $tryClone(Block.pred_end$Const()); $noteq_ptr(PI, PE); PI.$preInc()) {
      if (((PI.$star().$CFGBlock$P()) != null) && $less_uint(BlockVisitOrder, VisitOrder.$at((PI.$star()).$arrow().getBlockID()))) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::consumed::ConsumedBlockInfo::~ConsumedBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/Consumed.h", line = 198,
   FQN="clang::consumed::ConsumedBlockInfo::~ConsumedBlockInfo", NM="_ZN5clang8consumed17ConsumedBlockInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/Consumed.cpp -nm=_ZN5clang8consumed17ConsumedBlockInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VisitOrder.$destroy();
    StateMapsArray.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "StateMapsArray=" + StateMapsArray // NOI18N
              + ", VisitOrder=" + VisitOrder; // NOI18N
  }
}
