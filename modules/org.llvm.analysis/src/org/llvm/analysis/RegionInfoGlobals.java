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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type RegionInfoGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="RegionInfoGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseE;_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEE;_ZN4llvm14RegionInfoBaseE;_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEE;_ZN4llvm14RegionNodeBaseE;_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEE; -static-type=RegionInfoGlobals")
//</editor-fold>
public final class RegionInfoGlobals {


/// @brief A RegionNode represents a subregion or a BasicBlock that is part of a
/// Region.
/*template <class Tr> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase">
@Converted(kind = Converted.Kind.DUMMY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 110,
 FQN="llvm::RegionNodeBase", NM="_ZN4llvm14RegionNodeBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionNodeBaseE")
//</editor-fold>
public static class RegionNodeBaseT</*class*/ Tr>  {
}

//===----------------------------------------------------------------------===//
/// @brief A single entry single exit Region.
///
/// A Region is a connected subgraph of a control flow graph that has exactly
/// two connections to the remaining graph. It can be used to analyze or
/// optimize parts of the control flow graph.
///
/// A <em> simple Region </em> is connected to the remaining graph by just two
/// edges. One edge entering the Region and another one leaving the Region.
///
/// An <em> extended Region </em> (or just Region) is a subgraph that can be
/// transform into a simple Region. The transformation is done by adding
/// BasicBlocks that merge several entry or exit edges so that after the merge
/// just one entry and one exit edge exists.
///
/// The \e Entry of a Region is the first BasicBlock that is passed after
/// entering the Region. It is an element of the Region. The entry BasicBlock
/// dominates all BasicBlocks in the Region.
///
/// The \e Exit of a Region is the first BasicBlock that is passed after
/// leaving the Region. It is not an element of the Region. The exit BasicBlock,
/// postdominates all BasicBlocks in the Region.
///
/// A <em> canonical Region </em> cannot be constructed by combining smaller
/// Regions.
///
/// Region A is the \e parent of Region B, if B is completely contained in A.
///
/// Two canonical Regions either do not intersect at all or one is
/// the parent of the other.
///
/// The <em> Program Structure Tree</em> is a graph (V, E) where V is the set of
/// Regions in the control flow graph and E is the \e parent relation of these
/// Regions.
///
/// Example:
///
/// \verbatim
/// A simple control flow graph, that contains two regions.
///
///        1
///       / |
///      2   |
///     / \   3
///    4   5  |
///    |   |  |
///    6   7  8
///     \  | /
///      \ |/       Region A: 1 -> 9 {1,2,3,4,5,6,7,8}
///        9        Region B: 2 -> 9 {2,4,5,6,7}
/// \endverbatim
///
/// You can obtain more examples by either calling
///
/// <tt> "opt -regions -analyze anyprogram.ll" </tt>
/// or
/// <tt> "opt -view-regions-only anyprogram.ll" </tt>
///
/// on any LLVM file you are interested in.
///
/// The first call returns a textual representation of the program structure
/// tree, the second one creates a graphical representation using graphviz.
/*template <class Tr> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::RegionBase">
@Converted(kind = Converted.Kind.DUMMY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 247,
 FQN="llvm::RegionBase", NM="_ZN4llvm10RegionBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseE")
//</editor-fold>
public static class RegionBaseT</*class*/ Tr>  extends /*public*/ RegionNodeBaseT<Tr> implements Destructors.ClassWithDestructor {

    @Override
    public void $destroy() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }

//===----------------------------------------------------------------------===//
/// @brief Analysis that detects all canonical Regions.
///
/// The RegionInfo pass detects all canonical regions in a function. The Regions
/// are connected using the parent relation. This builds a Program Structure
/// Tree.
/*template <class Tr> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 653,
 FQN="llvm::RegionInfoBase", NM="_ZN4llvm14RegionInfoBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseE")
//</editor-fold>
public abstract static class RegionInfoBaseT</*class*/ Tr>  implements Destructors.ClassWithDestructor {
}
//<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 979,
 FQN="llvm::RegionBase<RegionTraitsFunction>", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEE")
//</editor-fold>
public static class RegionBase extends /*public*/ RegionNodeBaseT<RegionTraitsFunction> implements Destructors.ClassWithDestructor {
  // JAVA: typedef typename RegionTraitsFunction::FuncT FuncT
//  public final class FuncT extends Function{ };
  // JAVA: typedef typename RegionTraitsFunction::BlockT BlockT
//  public final class BlockT extends BasicBlock{ };
  // JAVA: typedef typename RegionTraitsFunction::RegionInfoT RegionInfoT
//  public final class RegionInfoT extends RegionInfo{ };
  // JAVA: typedef typename RegionTraitsFunction::RegionT RegionT
//  public final class RegionT extends Region{ };
  // JAVA: typedef typename RegionTraitsFunction::RegionNodeT RegionNodeT
//  public final class RegionNodeT extends RegionNode{ };
  // JAVA: typedef typename RegionTraitsFunction::DomTreeT DomTreeT
//  public final class DomTreeT extends DominatorTree{ };
  // JAVA: typedef typename RegionTraitsFunction::LoopT LoopT
//  public final class LoopT extends Loop{ };
  // JAVA: typedef typename RegionTraitsFunction::LoopInfoT LoopInfoT
//  public final class LoopInfoT extends LoopInfo{ };
  // JAVA: typedef typename RegionTraitsFunction::InstT InstT
//  public final class InstT extends Instruction{ };
  
  // JAVA: typedef GraphTraits<BlockT *> BlockTraits
//  public final class BlockTraits extends GraphTraitsBasicBlock$P{ };
  // JAVA: typedef GraphTraits<Inverse<BlockT *> > InvBlockTraits
//  public final class InvBlockTraits extends GraphTraitsInverse$BasicBlock$P{ };
  // JAVA: typedef typename BlockTraits::ChildIteratorType SuccIterTy
//  public final class SuccIterTy extends TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock>{ };
  // JAVA: typedef typename InvBlockTraits::ChildIteratorType PredIterTy
//  public final class PredIterTy extends PredIterator<BasicBlock, Value.user_iterator_impl<User> >{ };
  
  /*friend  class RegionInfoBase<RegionTraitsFunction>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::RegionBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 265,
//   FQN="llvm::RegionBase<RegionTraitsFunction>::RegionBase", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEC1ERKS4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEC1ERKS4_")
//  //</editor-fold>
//  protected/*private*/ RegionBase(final /*const*/ RegionBase<RegionTraitsFunction> /*&*/ $Prm0) {  throw new UnsupportedOperationException("Deleted");}
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::operator=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 266,
//   FQN="llvm::RegionBase<RegionTraitsFunction>::operator=", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEaSERKS4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEaSERKS4_")
//  //</editor-fold>
//  protected/*private*/ /*const*/ RegionBase<RegionTraitsFunction> /*&*/ $assign(final /*const*/ RegionBase<RegionTraitsFunction> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  private RegionInfo /*P*/ RI;
  private DominatorTree /*P*/ DT;
  private BasicBlock /*P*/ exit;
  
  // JAVA: typedef std::vector<std::unique_ptr<RegionT> > RegionSet
//  public final class RegionSet extends std.vector<std.unique_ptr<Region>>{ };
  private std.vector<std.unique_ptr<Region>> children;
  
  // JAVA: typedef std::map<BlockT *, RegionNodeT *> BBNodeMapT
//  public final class BBNodeMapT extends std.map<BasicBlock /*P*/ , RegionNode /*P*/ >{ };
  private /*mutable */std.mapPtrPtr<BasicBlock /*P*/ , RegionNode /*P*/ > BBNodeMap;
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::verifyBBInRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 236,
   FQN="llvm::RegionBase<RegionTraitsFunction>::verifyBBInRegion", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16verifyBBInRegionEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16verifyBBInRegionEPNS_10BasicBlockE")
  //</editor-fold>
  private void verifyBBInRegion(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::verifyWalk">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 262,
   FQN="llvm::RegionBase<RegionTraitsFunction>::verifyWalk", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE10verifyWalkEPNS_10BasicBlockEPSt3setIS6_St4lessIS6_ESaIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE10verifyWalkEPNS_10BasicBlockEPSt3setIS6_St4lessIS6_ESaIS6_EE")
  //</editor-fold>
  private void verifyWalk(BasicBlock /*P*/ BB, std.setPtr<BasicBlock /*P*/ > /*P*/ visited) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::verifyRegionNest">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 290,
   FQN="llvm::RegionBase<RegionTraitsFunction>::verifyRegionNest", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16verifyRegionNestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16verifyRegionNestEv")
  //</editor-fold>
  private void verifyRegionNest() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::RegionBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 34,
   FQN="llvm::RegionBase<RegionTraitsFunction>::RegionBase", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEC1EPNS_10BasicBlockES6_PNS_10RegionInfoEPNS_13DominatorTreeEPNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEEC1EPNS_10BasicBlockES6_PNS_10RegionInfoEPNS_13DominatorTreeEPNS_6RegionE")
  //</editor-fold>
  public RegionBase(BasicBlock /*P*/ Entry, BasicBlock /*P*/ Exit, RegionInfo /*P*/ RInfo, DominatorTree /*P*/ dt, 
      Region /*P*/ Parent) {
    // : RegionNodeBase<RegionTraitsFunction>(Parent, Entry, 1), RI(RInfo), DT(dt), exit(Exit), children(), BBNodeMap() 
    //super(Parent, Entry, true);
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::~RegionBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 40,
   FQN="llvm::RegionBase<RegionTraitsFunction>::~RegionBase", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEED0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEED0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 315,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getEntry", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8getEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8getEntryEv")
  //</editor-fold>
  public BasicBlock /*P*/ getEntry() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::replaceEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 53,
   FQN="llvm::RegionBase<RegionTraitsFunction>::replaceEntry", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE12replaceEntryEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE12replaceEntryEPNS_10BasicBlockE")
  //</editor-fold>
  public void replaceEntry(BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::replaceExit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 58,
   FQN="llvm::RegionBase<RegionTraitsFunction>::replaceExit", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11replaceExitEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11replaceExitEPNS_10BasicBlockE")
  //</editor-fold>
  public void replaceExit(BasicBlock /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::replaceEntryRecursive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 64,
   FQN="llvm::RegionBase<RegionTraitsFunction>::replaceEntryRecursive", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE21replaceEntryRecursiveEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE21replaceEntryRecursiveEPNS_10BasicBlockE")
  //</editor-fold>
  public void replaceEntryRecursive(BasicBlock /*P*/ NewEntry) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::replaceExitRecursive">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 83,
   FQN="llvm::RegionBase<RegionTraitsFunction>::replaceExitRecursive", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE20replaceExitRecursiveEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE20replaceExitRecursiveEPNS_10BasicBlockE")
  //</editor-fold>
  public void replaceExitRecursive(BasicBlock /*P*/ NewExit) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getExit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 352,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getExit", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE7getExitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE7getExitEv")
  //</editor-fold>
  public BasicBlock /*P*/ getExit() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getParent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 357,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getParent", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE9getParentEv")
  //</editor-fold>
  public Region /*P*/ getParent() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 363,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getNode", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE7getNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE7getNodeEv")
  //</editor-fold>
  public RegionNode /*P*/ getNode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getDepth">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 430,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getDepth", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8getDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8getDepthEv")
  //</editor-fold>
  public /*uint*/int getDepth() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::isTopLevelRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 378,
   FQN="llvm::RegionBase<RegionTraitsFunction>::isTopLevelRegion", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16isTopLevelRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16isTopLevelRegionEv")
  //</editor-fold>
  public boolean isTopLevelRegion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getExpandedRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 440,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getExpandedRegion", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE17getExpandedRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE17getExpandedRegionEv")
  //</editor-fold>
  public Region /*P*/ getExpandedRegion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getEnteringBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 161,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getEnteringBlock", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16getEnteringBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16getEnteringBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ getEnteringBlock() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getExitingBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 182,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getExitingBlock", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE15getExitingBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE15getExitingBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ getExitingBlock() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::isSimple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 206,
   FQN="llvm::RegionBase<RegionTraitsFunction>::isSimple", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8isSimpleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8isSimpleEv")
  //</editor-fold>
  public boolean isSimple() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getNameStr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 211,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getNameStr", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE10getNameStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE10getNameStrEv")
  //</editor-fold>
  public std.string getNameStr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getRegionInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 414,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getRegionInfo", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE13getRegionInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE13getRegionInfoEv")
  //</editor-fold>
  public RegionInfo /*P*/ getRegionInfo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::PrintStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 417,
   FQN="llvm::RegionBase<RegionTraitsFunction>::PrintStyle", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE10PrintStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE10PrintStyleE")
  //</editor-fold>
  public enum PrintStyle implements Native.NativeUIntEnum {
    PrintNone(0),
    PrintBB(PrintNone.getValue() + 1),
    PrintRN(PrintBB.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PrintStyle valueOf(int val) {
      PrintStyle out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PrintStyle[] VALUES;
      private static final PrintStyle[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PrintStyle kind : PrintStyle.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PrintStyle[min < 0 ? (1-min) : 0];
        VALUES = new PrintStyle[max >= 0 ? (1+max) : 0];
        for (PrintStyle kind : PrintStyle.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private PrintStyle(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 473,
   FQN="llvm::RegionBase<RegionTraitsFunction>::print", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE5printERNS_11raw_ostreamEbjNS4_10PrintStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE5printERNS_11raw_ostreamEbjNS4_10PrintStyleE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, boolean print_tree, /*uint*/int level, 
       PrintStyle Style) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 510,
   FQN="llvm::RegionBase<RegionTraitsFunction>::dump", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 102,
   FQN="llvm::RegionBase<RegionTraitsFunction>::contains", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8containsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8containsEPKNS_10BasicBlockE")
  //</editor-fold>
  public boolean contains(/*const*/ BasicBlock /*P*/ B) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 442,
   FQN="llvm::RegionBase<RegionTraitsFunction>::contains", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8containsEPKNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8containsEPKNS_6RegionE")
  //</editor-fold>
  public boolean contains(/*const*/ Region /*P*/ SubRegion) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 457,
   FQN="llvm::RegionBase<RegionTraitsFunction>::contains", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8containsEPKNS_11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8containsEPKNS_11InstructionE")
  //</editor-fold>
  public boolean contains(/*const*/ Instruction /*P*/ Inst) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 119,
   FQN="llvm::RegionBase<RegionTraitsFunction>::contains", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8containsEPKNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE8containsEPKNS_4LoopE")
  //</editor-fold>
  public boolean contains(/*const*/ Loop /*P*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::outermostLoopInRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 141,
   FQN="llvm::RegionBase<RegionTraitsFunction>::outermostLoopInRegion", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE21outermostLoopInRegionEPNS_4LoopE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE21outermostLoopInRegionEPNS_4LoopE")
  //</editor-fold>
  public Loop /*P*/ outermostLoopInRegion(Loop /*P*/ L) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::outermostLoopInRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 153,
   FQN="llvm::RegionBase<RegionTraitsFunction>::outermostLoopInRegion", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE21outermostLoopInRegionEPNS_8LoopInfoEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE21outermostLoopInRegionEPNS_8LoopInfoEPNS_10BasicBlockE")
  //</editor-fold>
  public Loop /*P*/ outermostLoopInRegion(LoopInfo /*P*/ LI, BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getSubRegionNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 323,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getSubRegionNode", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16getSubRegionNodeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE16getSubRegionNodeEPNS_10BasicBlockE")
  //</editor-fold>
  public Region /*P*/ getSubRegionNode(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 358,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getNode", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE7getNodeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE7getNodeEPNS_10BasicBlockE")
  //</editor-fold>
  public RegionNode /*P*/ getNode(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::getBBNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 343,
   FQN="llvm::RegionBase<RegionTraitsFunction>::getBBNode", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE9getBBNodeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE9getBBNodeEPNS_10BasicBlockE")
  //</editor-fold>
  public RegionNode /*P*/ getBBNode(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::addSubRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 376,
   FQN="llvm::RegionBase<RegionTraitsFunction>::addSubRegion", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE12addSubRegionEPNS_6RegionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE12addSubRegionEPNS_6RegionEb")
  //</editor-fold>
  public void addSubRegion(Region /*P*/ SubRegion) {
    addSubRegion(SubRegion, false);
  }
  public void addSubRegion(Region /*P*/ SubRegion, boolean moveChildren/*= false*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::removeSubRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 418,
   FQN="llvm::RegionBase<RegionTraitsFunction>::removeSubRegion", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE15removeSubRegionEPNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE15removeSubRegionEPNS_6RegionE")
  //</editor-fold>
  public Region /*P*/ removeSubRegion(Region /*P*/ Child) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::transferChildrenTo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 367,
   FQN="llvm::RegionBase<RegionTraitsFunction>::transferChildrenTo", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE18transferChildrenToEPNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE18transferChildrenToEPNS_6RegionE")
  //</editor-fold>
  public void transferChildrenTo(Region /*P*/ To) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::verifyRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 278,
   FQN="llvm::RegionBase<RegionTraitsFunction>::verifyRegion", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE12verifyRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE12verifyRegionEv")
  //</editor-fold>
  public void verifyRegion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::clearNodeCache">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 516,
   FQN="llvm::RegionBase<RegionTraitsFunction>::clearNodeCache", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE14clearNodeCacheEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE14clearNodeCacheEv")
  //</editor-fold>
  public void clearNodeCache() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // JAVA: typedef typename RegionSet::iterator iterator
//  public final class iterator extends std.vector.iterator<unique_ptr<Region> /*P*/>{ };
  // JAVA: typedef typename RegionSet::const_iterator const_iterator
//  public final class const_iterator extends std.vector.iterator</*const*/unique_ptr<Region> /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 548,
   FQN="llvm::RegionBase<RegionTraitsFunction>::begin", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE5beginEv")
  //</editor-fold>
  public std.vector.iterator<unique_ptr<Region> /*P*/> begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 549,
   FQN="llvm::RegionBase<RegionTraitsFunction>::end", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE3endEv")
  //</editor-fold>
  public std.vector.iterator<unique_ptr<Region> /*P*/> end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 551,
   FQN="llvm::RegionBase<RegionTraitsFunction>::begin", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE5beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/unique_ptr<Region> /*P*/> begin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 552,
   FQN="llvm::RegionBase<RegionTraitsFunction>::end", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE3endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/unique_ptr<Region> /*P*/> end$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // JAVA: typedef block_iterator_wrapper<false> block_iterator
//  public final class block_iterator extends block_iterator_wrapper<false>{ };
  // JAVA: typedef block_iterator_wrapper<true> const_block_iterator
//  public final class const_block_iterator extends block_iterator_wrapper<true>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::block_begin">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 597,
//   FQN="llvm::RegionBase<RegionTraitsFunction>::block_begin", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11block_beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11block_beginEv")
//  //</editor-fold>
//  public block_iterator_wrapper<false> block_begin() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::block_end">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 599,
//   FQN="llvm::RegionBase<RegionTraitsFunction>::block_end", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE9block_endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE9block_endEv")
//  //</editor-fold>
//  public block_iterator_wrapper<false> block_end() {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
//  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::block_begin">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 601,
//   FQN="llvm::RegionBase<RegionTraitsFunction>::block_begin", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11block_beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11block_beginEv")
//  //</editor-fold>
//  public block_iterator_wrapper<true> block_begin$Const() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::block_end">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 604,
//   FQN="llvm::RegionBase<RegionTraitsFunction>::block_end", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE9block_endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE9block_endEv")
//  //</editor-fold>
//  public block_iterator_wrapper<true> block_end$Const() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  // JAVA: typedef iterator_range<block_iterator> block_range
//  public final class block_range extends iterator_range<BasicBlock /*P*/ >{ };
  // JAVA: typedef iterator_range<const_block_iterator> const_block_range
//  public final class const_block_range extends iterator_range<BasicBlock /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::blocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 610,
   FQN="llvm::RegionBase<RegionTraitsFunction>::blocks", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE6blocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE6blocksEv")
  //</editor-fold>
  public /*inline*/ iterator_range<BasicBlock /*P*/ > blocks() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::blocks">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 617,
   FQN="llvm::RegionBase<RegionTraitsFunction>::blocks", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE6blocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE6blocksEv")
  //</editor-fold>
  public /*inline*/ iterator_range<BasicBlock /*P*/ > blocks$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // JAVA: typedef df_iterator<RegionNodeT *, SmallPtrSet<RegionNodeT *, 8>, false, GraphTraits<RegionNodeT *> > element_iterator
//  public final class element_iterator extends df_iterator<RegionNode /*P*/ , RegionNode /*P*/ , RegionNode /*P*/ >{ };
  
  // JAVA: typedef df_iterator<const RegionNodeT *, SmallPtrSet<const RegionNodeT *, 8>, false, GraphTraits<const RegionNodeT *> > const_element_iterator
//  public final class const_element_iterator extends df_iterator</*const*/ RegionNode /*P*/ , /*const*/ RegionNode /*P*/ , /*const*/ RegionNode /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::element_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 299,
   FQN="llvm::RegionBase<RegionTraitsFunction>::element_begin", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE13element_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE13element_beginEv")
  //</editor-fold>
  public df_iterator<RegionNode /*P*/ , RegionNode /*P*/ , RegionNode /*P*/ > element_begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::element_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 304,
   FQN="llvm::RegionBase<RegionTraitsFunction>::element_end", NM="_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11element_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11element_endEv")
  //</editor-fold>
  public df_iterator<RegionNode /*P*/ , RegionNode /*P*/ , RegionNode /*P*/ > element_end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::element_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 309,
   FQN="llvm::RegionBase<RegionTraitsFunction>::element_begin", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE13element_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE13element_beginEv")
  //</editor-fold>
  public df_iterator</*const*/ RegionNode /*P*/ , /*const*/ RegionNode /*P*/ , /*const*/ RegionNode /*P*/ > element_begin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionBase<RegionTraitsFunction>::element_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 316,
   FQN="llvm::RegionBase<RegionTraitsFunction>::element_end", NM="_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11element_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm10RegionBaseINS_12RegionTraitsINS_8FunctionEEEE11element_endEv")
  //</editor-fold>
  public df_iterator</*const*/ RegionNode /*P*/ , /*const*/ RegionNode /*P*/ , /*const*/ RegionNode /*P*/ > element_end$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "RI=" + RI // NOI18N
              + ", DT=" + DT // NOI18N
              + ", exit=" + exit // NOI18N
              + ", children=" + children // NOI18N
              + ", BBNodeMap=" + BBNodeMap // NOI18N
              + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 980,
 FQN="llvm::RegionNodeBase<RegionTraitsFunction>", NM="_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEE")
//</editor-fold>
public static class RegionNodeBase {
  /*friend  class RegionBase<RegionTraitsFunction>*/
/*public:*/
  // JAVA: typedef typename RegionTraitsFunction::BlockT BlockT
//  public final class BlockT extends BasicBlock{ };
  // JAVA: typedef typename RegionTraitsFunction::RegionT RegionT
//  public final class RegionT extends Region{ };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::RegionNodeBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 119,
//   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::RegionNodeBase", NM="_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEC1ERKS4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEC1ERKS4_")
//  //</editor-fold>
//  protected/*private*/ RegionNodeBase(final /*const*/ RegionNodeBase<RegionTraitsFunction> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::operator=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 120,
//   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::operator=", NM="_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEaSERKS4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEaSERKS4_")
//  //</editor-fold>
//  protected/*private*/ /*const*/ RegionNodeBase<RegionTraitsFunction> /*&*/ $assign(final /*const*/ RegionNodeBase<RegionTraitsFunction> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
//
//  private PointerIntPair<BasicBlock /*P*/ , 1, boolean> entry;
  private Region /*P*/ parent;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::RegionNodeBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 147,
   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::RegionNodeBase", NM="_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEC1EPNS_6RegionEPNS_10BasicBlockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEEC1EPNS_6RegionEPNS_10BasicBlockEb")
  //</editor-fold>
  protected /*inline*/ RegionNodeBase(Region /*P*/ Parent, BasicBlock /*P*/ Entry, 
      boolean isSubRegion) {
    // : entry(Entry, isSubRegion), parent(Parent) 
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::getParent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 160,
   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::getParent", NM="_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE9getParentEv")
  //</editor-fold>
  public /*inline*/ Region /*P*/ getParent() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::getEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 168,
   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::getEntry", NM="_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE8getEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE8getEntryEv")
  //</editor-fold>
  public /*inline*/ BasicBlock /*P*/ getEntry() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::getNodeAs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 176,
   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::getNodeAs", NM="Tpl__ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE9getNodeAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=Tpl__ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE9getNodeAsEv")
  //</editor-fold>
  public /*inline*/ </*class*/ T> T /*P*/ getNodeAs() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::isSubRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 182,
   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::isSubRegion", NM="_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE11isSubRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE11isSubRegionEv")
  //</editor-fold>
  public /*inline*/ boolean isSubRegion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::getNodeAs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 950,
   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::getNodeAs", NM="_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE9getNodeAsINS_10BasicBlockEEEPT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE9getNodeAsINS_10BasicBlockEEEPT_v")
  //</editor-fold>
  public /*inline*/ BasicBlock /*P*/ getNodeAs$BasicBlock() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::RegionNodeBase<RegionTraitsFunction>::getNodeAs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 958,
   FQN="llvm::RegionNodeBase<RegionTraitsFunction>::getNodeAs", NM="_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE9getNodeAsINS_6RegionEEEPT_v",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionNodeBaseINS_12RegionTraitsINS_8FunctionEEEE9getNodeAsINS_6RegionEEEPT_v")
  //</editor-fold>
  public /*inline*/ Region /*P*/ getNodeAs$Region() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "entry="// + entry // NOI18N
              + ", parent=" + parent; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 981,
 FQN="llvm::RegionInfoBase<RegionTraitsFunction>", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEE")
//</editor-fold>
public abstract static class RegionInfoBase implements Destructors.ClassWithDestructor {
  // JAVA: typedef typename RegionTraitsFunction::BlockT BlockT
//  public final class BlockT extends BasicBlock{ };
  // JAVA: typedef typename RegionTraitsFunction::FuncT FuncT
//  public final class FuncT extends Function{ };
  // JAVA: typedef typename RegionTraitsFunction::RegionT RegionT
//  public final class RegionT extends Region{ };
  // JAVA: typedef typename RegionTraitsFunction::RegionInfoT RegionInfoT
//  public final class RegionInfoT extends RegionInfo{ };
  // JAVA: typedef typename RegionTraitsFunction::DomTreeT DomTreeT
//  public final class DomTreeT extends DominatorTree{ };
  // JAVA: typedef typename RegionTraitsFunction::DomTreeNodeT DomTreeNodeT
//  public final class DomTreeNodeT extends DomTreeNodeBase$BasicBlock{ };
  // JAVA: typedef typename RegionTraitsFunction::PostDomTreeT PostDomTreeT
//  public final class PostDomTreeT extends PostDominatorTree{ };
  // JAVA: typedef typename RegionTraitsFunction::DomFrontierT DomFrontierT
//  public final class DomFrontierT extends DominanceFrontier{ };
  // JAVA: typedef GraphTraits<BlockT *> BlockTraits
//  public final class BlockTraits extends GraphTraitsBasicBlock$P{ };
  // JAVA: typedef GraphTraits<Inverse<BlockT *> > InvBlockTraits
//  public final class InvBlockTraits extends GraphTraitsInverse$BasicBlock$P{ };
  // JAVA: typedef typename BlockTraits::ChildIteratorType SuccIterTy
//  public final class SuccIterTy extends TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock>{ };
  // JAVA: typedef typename InvBlockTraits::ChildIteratorType PredIterTy
//  public final class PredIterTy extends PredIterator<BasicBlock, Value.user_iterator_impl<User> >{ };
  
  /*friend  class RegionInfo*/
  /*friend  class MachineRegionInfo*/
  // JAVA: typedef DenseMap<BlockT *, BlockT *> BBtoBBMap
//  public final class BBtoBBMap extends DenseMap<BasicBlock /*P*/ , BasicBlock /*P*/ >{ };
  // JAVA: typedef DenseMap<BlockT *, RegionT *> BBtoRegionMap
//  public final class BBtoRegionMap extends DenseMap<BasicBlock /*P*/ , Region /*P*/ >{ };
  // JAVA: typedef SmallPtrSet<RegionT *, 4> RegionSet
//  public final class RegionSet extends SmallPtrSet<Region /*P*/ , 4>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::RegionInfoBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 533,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::RegionInfoBase", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEC1Ev")
  //</editor-fold>
  protected RegionInfoBase() {
    // : TopLevelRegion(null), BBtoRegion() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::~RegionInfoBase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 537,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::~RegionInfoBase", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEED0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEED0Ev")
  //</editor-fold>
  public/*private*/ /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::RegionInfoBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 677,
//   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::RegionInfoBase", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEC1ERKS4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEC1ERKS4_")
//  //</editor-fold>
//  protected/*private*/ RegionInfoBase(final /*const*/ RegionInfoBase<RegionTraitsFunction> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::operator=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 678,
//   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::operator=", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEaSERKS4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEaSERKS4_")
//  //</editor-fold>
//  protected/*private*/ /*const*/ RegionInfoBase<RegionTraitsFunction> /*&*/ $assign(final /*const*/ RegionInfoBase<RegionTraitsFunction> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
//  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::RegionInfoBase">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 680,
//   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::RegionInfoBase", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEC1EOS4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEC1EOS4_")
//  //</editor-fold>
//  private RegionInfoBase(JD$Move _dparam, final RegionInfoBase<RegionTraitsFunction> /*&&*/Arg) {
//    // : DT(std::move(Arg.DT)), PDT(std::move(Arg.PDT)), DF(std::move(Arg.DF)), TopLevelRegion(std::move(Arg.TopLevelRegion)), BBtoRegion(std::move(Arg.BBtoRegion)) 
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::operator=">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 686,
//   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::operator=", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEaSEOS4_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEaSEOS4_")
//  //</editor-fold>
//  private RegionInfoBase<RegionTraitsFunction> /*&*/ $assignMove(final RegionInfoBase<RegionTraitsFunction> /*&&*/RHS) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  private DominatorTree /*P*/ DT;
  private PostDominatorTree /*P*/ PDT;
  private DominanceFrontier /*P*/ DF;
  private Region /*P*/ TopLevelRegion;
/*private:*/
  private DenseMap<BasicBlock /*P*/ , Region /*P*/ > BBtoRegion;
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::wipe">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 711,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::wipe", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE4wipeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE4wipeEv")
  //</editor-fold>
  private void wipe() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::verifyBBMap">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 542,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::verifyBBMap", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE11verifyBBMapEPKNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE11verifyBBMapEPKNS_6RegionE")
  //</editor-fold>
  private void verifyBBMap(/*const*/ Region /*P*/ R) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::isCommonDomFrontier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 557,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::isCommonDomFrontier", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE19isCommonDomFrontierEPNS_10BasicBlockES6_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE19isCommonDomFrontierEPNS_10BasicBlockES6_S6_")
  //</editor-fold>
  private boolean isCommonDomFrontier(BasicBlock /*P*/ BB, BasicBlock /*P*/ entry, BasicBlock /*P*/ exit) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::isRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 571,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::isRegion", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE8isRegionEPNS_10BasicBlockES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE8isRegionEPNS_10BasicBlockES6_")
  //</editor-fold>
  private boolean isRegion(BasicBlock /*P*/ entry, BasicBlock /*P*/ exit) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::insertShortCut">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 614,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::insertShortCut", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14insertShortCutEPNS_10BasicBlockES6_PNS_8DenseMapIS6_S6_NS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_S6_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14insertShortCutEPNS_10BasicBlockES6_PNS_8DenseMapIS6_S6_NS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_S6_EEEE")
  //</editor-fold>
  private void insertShortCut(BasicBlock /*P*/ entry, BasicBlock /*P*/ exit, DenseMap<BasicBlock /*P*/ , BasicBlock /*P*/ > /*P*/ ShortCut) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getNextPostDom">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 633,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getNextPostDom", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14getNextPostDomEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_8DenseMapIPS6_SA_NS_12DenseMapInfoISA_EENS_6detail12DenseMapPairISA_SA_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14getNextPostDomEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_8DenseMapIPS6_SA_NS_12DenseMapInfoISA_EENS_6detail12DenseMapPairISA_SA_EEEE")
  //</editor-fold>
  private DomTreeNodeBase<BasicBlock> /*P*/ getNextPostDom(DomTreeNodeBase<BasicBlock> /*P*/ N, DenseMap<BasicBlock /*P*/ , BasicBlock /*P*/ > /*P*/ ShortCut) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::isTrivialRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 644,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::isTrivialRegion", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15isTrivialRegionEPNS_10BasicBlockES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15isTrivialRegionEPNS_10BasicBlockES6_")
  //</editor-fold>
  private boolean isTrivialRegion(BasicBlock /*P*/ entry, BasicBlock /*P*/ exit) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::createRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 657,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::createRegion", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE12createRegionEPNS_10BasicBlockES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE12createRegionEPNS_10BasicBlockES6_")
  //</editor-fold>
  private Region /*P*/ createRegion(BasicBlock /*P*/ entry, BasicBlock /*P*/ exit) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::findRegionsWithEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 679,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::findRegionsWithEntry", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE20findRegionsWithEntryEPNS_10BasicBlockEPNS_8DenseMapIS6_S6_NS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_S6_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE20findRegionsWithEntryEPNS_10BasicBlockEPNS_8DenseMapIS6_S6_NS_12DenseMapInfoIS6_EENS_6detail12DenseMapPairIS6_S6_EEEE")
  //</editor-fold>
  private void findRegionsWithEntry(BasicBlock /*P*/ entry, DenseMap<BasicBlock /*P*/ , BasicBlock /*P*/ > /*P*/ ShortCut) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::scanForRegions">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 720,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::scanForRegions", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14scanForRegionsERS2_PNS_8DenseMapIPNS_10BasicBlockES8_NS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_S8_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14scanForRegionsERS2_PNS_8DenseMapIPNS_10BasicBlockES8_NS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_S8_EEEE")
  //</editor-fold>
  private void scanForRegions(final Function /*&*/ F, DenseMap<BasicBlock /*P*/ , BasicBlock /*P*/ > /*P*/ ShortCut) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getTopMostParent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 734,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getTopMostParent", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE16getTopMostParentEPNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE16getTopMostParentEPNS_6RegionE")
  //</editor-fold>
  private Region /*P*/ getTopMostParent(Region /*P*/ region) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::buildRegionsTree">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 742,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::buildRegionsTree", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE16buildRegionsTreeEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE16buildRegionsTreeEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_6RegionE")
  //</editor-fold>
  private void buildRegionsTree(DomTreeNodeBase<BasicBlock> /*P*/ N, Region /*P*/ region) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::updateStatistics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 760,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::updateStatistics", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE16updateStatisticsEPNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE16updateStatisticsEPNS_6RegionE")
  //</editor-fold>
  protected/*private*/ abstract /*virtual*/ void updateStatistics(Region /*P*/ R)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::calculate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 909,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::calculate", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE9calculateERS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE9calculateERS2_")
  //</editor-fold>
  private void calculate(final Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  public static boolean VerifyRegionInfo = false;
  //public static  Region.PrintStyle printStyle = RegionBase.<RegionTraitsFunction>PrintStyle.PrintNone;
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 780,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::print", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 788,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::dump", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 792,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::releaseMemory", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getRegionFor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 813,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getRegionFor", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE12getRegionForEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE12getRegionForEPNS_10BasicBlockE")
  //</editor-fold>
  public Region /*P*/ getRegionFor(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::setRegionFor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 819,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::setRegionFor", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE12setRegionForEPNS_10BasicBlockEPNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE12setRegionForEPNS_10BasicBlockEPNS_6RegionE")
  //</editor-fold>
  public void setRegionFor(BasicBlock /*P*/ BB, Region /*P*/ R) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::operator[]">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 824,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::operator[]", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEixEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEEixEPNS_10BasicBlockE")
  //</editor-fold>
  public Region /*P*/ $at(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getMaxRegionExit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 829,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getMaxRegionExit", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE16getMaxRegionExitEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE16getMaxRegionExitEPNS_10BasicBlockE")
  //</editor-fold>
  public BasicBlock /*P*/ getMaxRegionExit(BasicBlock /*P*/ BB) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getCommonRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 871,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getCommonRegion", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15getCommonRegionEPNS_6RegionES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15getCommonRegionEPNS_6RegionES6_")
  //</editor-fold>
  public Region /*P*/ getCommonRegion(Region /*P*/ A, Region /*P*/ B) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getCommonRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 814,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getCommonRegion", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15getCommonRegionEPNS_10BasicBlockES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15getCommonRegionEPNS_10BasicBlockES6_")
  //</editor-fold>
  public Region /*P*/ getCommonRegion(BasicBlock /*P*/ A, BasicBlock /*P*/ B) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getCommonRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 885,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getCommonRegion", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15getCommonRegionERNS_15SmallVectorImplIPNS_6RegionEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15getCommonRegionERNS_15SmallVectorImplIPNS_6RegionEEE")
  //</editor-fold>
  public Region /*P*/ getCommonRegion_SmallVectorImpl$RegionT$P(final SmallVectorImpl<Region /*P*/ > /*&*/ Regions) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getCommonRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 897,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getCommonRegion", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15getCommonRegionERNS_15SmallVectorImplIPNS_10BasicBlockEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE15getCommonRegionERNS_15SmallVectorImplIPNS_10BasicBlockEEE")
  //</editor-fold>
  public Region /*P*/ getCommonRegion_SmallVectorImpl$BlockT$P(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ BBs) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::getTopLevelRegion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 830,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::getTopLevelRegion", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE17getTopLevelRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE17getTopLevelRegionEv")
  //</editor-fold>
  public Region /*P*/ getTopLevelRegion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::clearNodeCache">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 835,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::clearNodeCache", NM="_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14clearNodeCacheEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14clearNodeCacheEv")
  //</editor-fold>
  public void clearNodeCache() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfoBase<RegionTraitsFunction>::verifyAnalysis">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfoImpl.h", line = 800,
   FQN="llvm::RegionInfoBase<RegionTraitsFunction>::verifyAnalysis", NM="_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14verifyAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZNK4llvm14RegionInfoBaseINS_12RegionTraitsINS_8FunctionEEEE14verifyAnalysisEv")
  //</editor-fold>
  public void verifyAnalysis() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "DT=" + DT // NOI18N
              + ", PDT=" + PDT // NOI18N
              + ", DF=" + DF // NOI18N
              + ", TopLevelRegion=" + TopLevelRegion // NOI18N
              + ", BBtoRegion=" + BBtoRegion; // NOI18N
  }
}
} // END OF class RegionInfoGlobals
