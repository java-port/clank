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
import static org.clank.java.std.*;
import org.clank.java.stdimpl.StdSetPtr;
import org.clank.java.stdimpl.aliases.StdMapPtrType;
import org.clank.java.stdimpl.aliases.StdVector;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.SmallPtrSet;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;


//<editor-fold defaultstate="collapsed" desc="static type DominanceFrontierGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="DominanceFrontierGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBaseE;_ZN4llvm21DominanceFrontierBaseINS_10BasicBlockEEE;_ZN4llvm28ForwardDominanceFrontierBaseE;_ZN4llvm28ForwardDominanceFrontierBaseINS_10BasicBlockEEE; -static-type=DominanceFrontierGlobals")
//</editor-fold>
public final class DominanceFrontierGlobals {


//===----------------------------------------------------------------------===//
/// DominanceFrontierBase - Common base class for computing forward and inverse
/// dominance frontiers for a function.
///
/*template <class BlockT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 32,
 FQN="llvm::DominanceFrontierBase", NM="_ZN4llvm21DominanceFrontierBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBaseE")
//</editor-fold>
public static class DominanceFrontierBase</*class*/ BlockT extends Value>  {
/*public:*/
  // JAVA: typedef std::set<BlockT *> DomSetType
//  public final class DomSetType extends std.setPtr<BlockT /*P*/ >{ }; // Dom set for a bb
  // JAVA: typedef std::map<BlockT *, DomSetType> DomSetMapType
//  public final class DomSetMapType extends std.map<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > >{ }; // Dom set map
/*protected:*/
  // JAVA: typedef GraphTraits<BlockT *> BlockTraits
//  public final class BlockTraits extends GraphTraits<BlockT /*P*/ >{ };
  
  protected std.mapPtrType<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > Frontiers;
  protected std.vector<BlockT /*P*/ > Roots;
  protected /*const*/boolean IsPostDominators;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::DominanceFrontierBase<BlockT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 46,
   FQN="llvm::DominanceFrontierBase::DominanceFrontierBase<BlockT>", NM="_ZN4llvm21DominanceFrontierBaseC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBaseC1Eb")
  //</editor-fold>
  public DominanceFrontierBase(boolean isPostDom) {
    // : IsPostDominators(isPostDom) 
    //START JInit
    this.IsPostDominators = isPostDom;
    //END JInit
  }

  
  /// getRoots - Return the root blocks of the current CFG.  This may include
  /// multiple blocks if we are computing post dominators.  For forward
  /// dominators, this will always be a single block (the entry node).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::getRoots">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 52,
   FQN="llvm::DominanceFrontierBase::getRoots", NM="_ZNK4llvm21DominanceFrontierBase8getRootsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase8getRootsEv")
  //</editor-fold>
  public /*inline*/ /*const*/ std.vector<BlockT /*P*/ > /*&*/ getRoots() /*const*/ {
    return Roots;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::getRoot">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 56,
   FQN="llvm::DominanceFrontierBase::getRoot", NM="_ZNK4llvm21DominanceFrontierBase7getRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase7getRootEv")
  //</editor-fold>
  public BlockT /*P*/ getRoot() /*const*/ {
    assert Native.$bool(Native.$eq(Roots.size(), 1)) : "Should always have entry node!";
    return Roots.$at(0);
  }

  
  /// isPostDominator - Returns true if analysis based of postdoms
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::isPostDominator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 63,
   FQN="llvm::DominanceFrontierBase::isPostDominator", NM="_ZNK4llvm21DominanceFrontierBase15isPostDominatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase15isPostDominatorEv")
  //</editor-fold>
  public boolean isPostDominator() /*const*/ {
    return IsPostDominators;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 67,
   FQN="llvm::DominanceFrontierBase::releaseMemory", NM="_ZN4llvm21DominanceFrontierBase13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    Frontiers.clear();
  }

  
  // Accessor interface:
  // JAVA: typedef typename DomSetMapType::iterator iterator
//  public final class iterator extends  std.map.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > >{ };
  // JAVA: typedef typename DomSetMapType::const_iterator const_iterator
//  public final class const_iterator extends  std.map.const_iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 74,
   FQN="llvm::DominanceFrontierBase::begin", NM="_ZN4llvm21DominanceFrontierBase5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase5beginEv")
  //</editor-fold>
  public  StdMapPtrType.iterator<BlockT, setPtr<BlockT>> begin() {
    return Frontiers.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 75,
   FQN="llvm::DominanceFrontierBase::begin", NM="_ZNK4llvm21DominanceFrontierBase5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase5beginEv")
  //</editor-fold>
  public  StdMapPtrType.iterator<BlockT, setPtr<BlockT>> begin$Const() /*const*/ {
    return Frontiers.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 76,
   FQN="llvm::DominanceFrontierBase::end", NM="_ZN4llvm21DominanceFrontierBase3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase3endEv")
  //</editor-fold>
  public  StdMapPtrType.iterator<BlockT, setPtr<BlockT>> end() {
    return Frontiers.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 77,
   FQN="llvm::DominanceFrontierBase::end", NM="_ZNK4llvm21DominanceFrontierBase3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase3endEv")
  //</editor-fold>
  public  StdMapPtrType.iterator<BlockT, setPtr<BlockT>> end$Const() /*const*/ {
    return Frontiers.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::find">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 78,
   FQN="llvm::DominanceFrontierBase::find", NM="_ZN4llvm21DominanceFrontierBase4findEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase4findEPT_")
  //</editor-fold>
  public  StdMapPtrType.iterator<BlockT, setPtr<BlockT>> find(BlockT /*P*/ B) {
    return Frontiers.find(B);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::find">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 79,
   FQN="llvm::DominanceFrontierBase::find", NM="_ZNK4llvm21DominanceFrontierBase4findEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase4findEPT_")
  //</editor-fold>
  public  StdMapPtrType.iterator<BlockT, setPtr<BlockT>> find$Const(BlockT /*P*/ B) /*const*/ {
    return Frontiers.find(B);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::addBasicBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 81,
   FQN="llvm::DominanceFrontierBase::addBasicBlock", NM="_ZN4llvm21DominanceFrontierBase13addBasicBlockEPT_RKSt3setIS2_St4lessIS2_ESaIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase13addBasicBlockEPT_RKSt3setIS2_St4lessIS2_ESaIS2_EE")
  //</editor-fold>
  public  StdMapPtrType.iterator<BlockT, setPtr<BlockT>> addBasicBlock(BlockT /*P*/ BB, final /*const*/ std.setPtr<BlockT /*P*/ > /*&*/ frontier) {
    assert Native.$bool(Native.$eq(find(BB), end())) : "Block already in DominanceFrontier!";
    return Frontiers.insert(std.make_pair_Ptr_T(BB, frontier)).first;
  }

  
  /// removeBlock - Remove basic block BB's frontier.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::removeBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 42,
   FQN="llvm::DominanceFrontierBase::removeBlock", NM="_ZN4llvm21DominanceFrontierBase11removeBlockEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase11removeBlockEPT_")
  //</editor-fold>
  public void removeBlock(BlockT /*P*/ BB) {
    assert Native.$bool(Native.$noteq(find(BB), end())) : "Block is not in DominanceFrontier!";
    for ( StdMapPtrType.iterator<BlockT, setPtr<BlockT>> I = begin(), E = end(); Native.$noteq(I, E); I.$preInc())  {
      I.$star().second.erase(BB);
    }
    Frontiers.erase(BB);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::addToFrontier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 50,
   FQN="llvm::DominanceFrontierBase::addToFrontier", NM="_ZN4llvm21DominanceFrontierBase13addToFrontierENSt3mapIPT_St3setIS3_St4lessIS3_ESaIS3_EES6_SaISt4pairIKS3_S8_EEE8iteratorES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase13addToFrontierENSt3mapIPT_St3setIS3_St4lessIS3_ESaIS3_EES6_SaISt4pairIKS3_S8_EEE8iteratorES3_")
  //</editor-fold>
  public void addToFrontier( std.mapTypePtr.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > I, 
               BlockT /*P*/ Node) {
    assert Native.$bool(Native.$noteq(I, end())) : "BB is not in DominanceFrontier!";
    assert Native.$bool(I.$star().second.count(Node)) : "Node is not in DominanceFrontier of BB";
    I.$star().second.erase(Node);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::removeFromFrontier">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 58,
   FQN="llvm::DominanceFrontierBase::removeFromFrontier", NM="_ZN4llvm21DominanceFrontierBase18removeFromFrontierENSt3mapIPT_St3setIS3_St4lessIS3_ESaIS3_EES6_SaISt4pairIKS3_S8_EEE8iteratorES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase18removeFromFrontierENSt3mapIPT_St3setIS3_St4lessIS3_ESaIS3_EES6_SaISt4pairIKS3_S8_EEE8iteratorES3_")
  //</editor-fold>
  public void removeFromFrontier( std.mapTypePtr.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > I, 
                    BlockT /*P*/ Node) {
    assert Native.$bool(Native.$noteq(I, end())) : "BB is not in DominanceFrontier!";
    assert Native.$bool(I.$star().second.count(Node)) : "Node is not in DominanceFrontier of BB";
    I.$star().second.erase(Node);
  }

  
  /// compareDomSet - Return false if two domsets match. Otherwise
  /// return true;
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::compareDomSet">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 66,
   FQN="llvm::DominanceFrontierBase::compareDomSet", NM="_ZNK4llvm21DominanceFrontierBase13compareDomSetERSt3setIPT_St4lessIS3_ESaIS3_EERKS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase13compareDomSetERSt3setIPT_St4lessIS3_ESaIS3_EERKS7_")
  //</editor-fold>
  public boolean compareDomSet(final std.setPtr<BlockT /*P*/ > /*&*/ DS1, 
               final /*const*/ std.setPtr<BlockT /*P*/ > /*&*/ DS2) /*const*/ {
    std.setPtr<BlockT /*P*/ > tmpSet = new setPtr<>();
    for (BlockT /*P*/ BB : DS2)  {
      tmpSet.insert(BB);
    }
    
    for ( std.setPtr.iterator<BlockT /*P*/ > I = DS1.begin(), E = DS1.end();
         Native.$noteq(I, E);) {
      BlockT /*P*/ Node = $Deref(I.$postInc());
      if (Native.$eq(tmpSet.erase(Node), 0)) {
        // Node is in DS1 but tnot in DS2.
        return true;
      }
    }
    if (Native.$not(tmpSet.empty())) {
      // There are nodes that are in DS2 but not in DS1.
      return true;
    }
    
    // DS1 and DS2 matches.
    return false;
  }

  
  /// compare - Return true if the other dominance frontier base matches
  /// this dominance frontier base. Otherwise return false.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 91,
   FQN="llvm::DominanceFrontierBase::compare", NM="_ZNK4llvm21DominanceFrontierBase7compareERNS_21DominanceFrontierBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase7compareERNS_21DominanceFrontierBaseIT_EE")
  //</editor-fold>
  public boolean compare(final DominanceFrontierBase<BlockT> /*&*/ Other) /*const*/ {
    std.mapTypePtr<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > tmpFrontiers = new mapTypePtr<>();
    for ( StdMapPtrType.iterator<BlockT, setPtr<BlockT>> I = Other.begin(), 
        E = Other.end();
         Native.$noteq(I, E); I.$preInc())  {
      tmpFrontiers.insert(std.make_pair_T_Ptr(I.$star().first, I.$star().second));
    }
    
    for ( std.mapTypePtr.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > I = tmpFrontiers.begin(), 
        E = tmpFrontiers.end();
         Native.$noteq(I, E);) {
      BlockT /*P*/ Node = I.$star().first;
      StdMapPtrType.iterator<BlockT, setPtr<BlockT>> DFI = find(Node);
      if (Native.$eq(DFI, end())) {
        return true;
      }
      if (compareDomSet(I.$star().second, DFI.$star().second)) {
        return true;
      }
      
      I.$preInc();
      tmpFrontiers.erase(Node);
    }
    if (Native.$not(tmpFrontiers.empty())) {
      return true;
    }
    
    return false;
  }

  
  /// print - Convert to human readable form
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::print">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 121,
   FQN="llvm::DominanceFrontierBase::print", NM="_ZNK4llvm21DominanceFrontierBase5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    for ( StdMapPtrType.iterator<BlockT, setPtr<BlockT>> I = begin(), E = end(); Native.$noteq(I, E); I.$preInc()) {
      OS.$out(/*KEEP_STR*/"  DomFrontier for BB ");
      if (I.$star().first != null) {
        I.$star().first.printAsOperand(OS, false);
      } else {
        OS.$out(/*KEEP_STR*/" <<exit node>>");
      }
      OS.$out(/*KEEP_STR*/" is:\t");
      
      final /*const*/ std.setPtr<BlockT /*P*/ > /*&*/ BBs = I.$star().second;
      
      for (/*const*/ BlockT /*P*/ BB : BBs) {
        OS.$out_char($$SPACE);
        if (BB != null) {
          BB.printAsOperand(OS, false);
        } else {
          OS.$out(/*KEEP_STR*/"<<exit node>>");
        }
      }
      OS.$out_char($$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 145,
   FQN="llvm::DominanceFrontierBase::dump", NM="_ZNK4llvm21DominanceFrontierBase4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    print(dbgs());
  }

  public /*inline*/ DominanceFrontierBase(JavaDifferentiators.JD$Move _dparam, final DominanceFrontierBase /*&&*/$Prm0) {
    this.Frontiers = Native.$tryMove($Prm0.Frontiers);
    this.IsPostDominators = $Prm0.IsPostDominators;
    this.Roots = $Prm0.Roots.move();
  }

  @Override public String toString() {
    return "" + "Frontiers=" + Frontiers // NOI18N
              + ", Roots=" + Roots // NOI18N
              + ", IsPostDominators=" + IsPostDominators; // NOI18N
  }
}

//===-------------------------------------
/// DominanceFrontier Class - Concrete subclass of DominanceFrontierBase that is
/// used to compute a forward dominator frontiers.
///
/*template <class BlockT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ForwardDominanceFrontierBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 115,
 FQN="llvm::ForwardDominanceFrontierBase", NM="_ZN4llvm28ForwardDominanceFrontierBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28ForwardDominanceFrontierBaseE")
//</editor-fold>
public static class ForwardDominanceFrontierBase</*class*/ BlockT extends Value>  extends /*public*/ DominanceFrontierBase<BlockT> {
/*private:*/
  // JAVA: typedef GraphTraits<BlockT *> BlockTraits
//  public final class BlockTraits extends GraphTraits<BlockT /*P*/ >{ };
/*public:*/
  // JAVA: typedef DominatorTreeBase<BlockT> DomTreeT
//  public final class DomTreeT extends DominatorTreeBase<BlockT>{ };
  // JAVA: typedef DomTreeNodeBase<BlockT> DomTreeNodeT
//  public final class DomTreeNodeT extends DomTreeNodeBase<BlockT>{ };
  // JAVA: typedef typename DominanceFrontierBase<BlockT>::DomSetType DomSetType
//  public final class DomSetType extends  DominanceFrontierBase.DomSetType<BlockT>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ForwardDominanceFrontierBase::ForwardDominanceFrontierBase<BlockT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 125,
   FQN="llvm::ForwardDominanceFrontierBase::ForwardDominanceFrontierBase<BlockT>", NM="_ZN4llvm28ForwardDominanceFrontierBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28ForwardDominanceFrontierBaseC1Ev")
  //</editor-fold>
  public ForwardDominanceFrontierBase() {
    // : DominanceFrontierBase<BlockT>(false) 
    //START JInit
    /*ParenListExpr*/super(false);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ForwardDominanceFrontierBase::analyze">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 127,
   FQN="llvm::ForwardDominanceFrontierBase::analyze", NM="_ZN4llvm28ForwardDominanceFrontierBase7analyzeERNS_17DominatorTreeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28ForwardDominanceFrontierBase7analyzeERNS_17DominatorTreeBaseIT_EE")
  //</editor-fold>
  public void analyze(final DominatorTreeBase<BlockT> /*&*/ DT) {
    this.Roots = DT.getRoots();
    assert Native.$bool(Native.$eq(this.Roots.size(), 1)) : "Only one entry block for forward domfronts!";
    calculate(DT, DT.$at(this.Roots.$at(0)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ForwardDominanceFrontierBase::calculate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 151,
   FQN="llvm::ForwardDominanceFrontierBase::calculate", NM="_ZN4llvm28ForwardDominanceFrontierBase9calculateERKNS_17DominatorTreeBaseIT_EEPKNS_15DomTreeNodeBaseIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28ForwardDominanceFrontierBase9calculateERKNS_17DominatorTreeBaseIT_EEPKNS_15DomTreeNodeBaseIS2_EE")
  //</editor-fold>
  public /*const*/std.setPtr<BlockT/*P*/>/*&*/ calculate(final /*const*/ DominatorTreeBase<BlockT> /*&*/ DT, 
           /*const*/ DomTreeNodeBase<BlockT> /*P*/ Node) {
    BlockT /*P*/ BB = Node.getBlock();
     setPtr<BlockT> /*P*/ Result = null;
    
    std.vector<DFCalculateWorkObject<BlockT> > workList = new vector<DFCalculateWorkObject<BlockT>>(new DFCalculateWorkObject());
    SmallPtrSet<BlockT /*P*/ >/*<32>*/ visited = new SmallPtrSet<BlockT /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
    
    workList.push_back(new DFCalculateWorkObject<BlockT>(BB, null, Node, null));
    do {
      DFCalculateWorkObject<BlockT> /*P*/ currentW = $AddrOf(workList.back());
      assert Native.$bool(currentW) : "Missing work object.";
      
      BlockT /*P*/ currentBB = currentW.currentBB;
      BlockT /*P*/ parentBB = currentW.parentBB;
      /*const*/ DomTreeNodeBase<BlockT> /*P*/ currentNode = currentW.Node;
      /*const*/ DomTreeNodeBase<BlockT> /*P*/ parentNode = currentW.parentNode;
      assert Native.$bool(currentBB) : "Invalid work object. Missing current Basic Block";
      assert Native.$bool(currentNode) : "Invalid work object. Missing current Node";
      final  setPtr<BlockT> /*&*/ S = this.Frontiers.$at(currentBB);
      
      // Visit each block only once.
      if (visited.insert(currentBB).second) {
        // Loop over CFG successors to calculate DFlocal[currentNode]
        for (TerminatorInst.SuccIterator<TerminatorInst, BasicBlock> SI = GraphTraitsBasicBlock$P.$GTraits().child_begin((BasicBlock)currentBB), 
            SE =  GraphTraitsBasicBlock$P.$GTraits().child_end((BasicBlock)currentBB);
             Native.$noteq_iter(SI, SE); SI.$postInc()) {
          // Does Node immediately dominate this successor?
          if (Native.$noteq(DT.$at((BlockT)SI.$star()).getIDom(), currentNode)) {
            S.insert((BlockT)SI.$star());
          }
        }
      }
      
      // At this point, S is DFlocal.  Now we union in DFup's of our children...
      // Loop through and visit the nodes that Node immediately dominates (Node's
      // children in the IDomTree)
      boolean visitChild = false;
      for ( StdVector.iterator<DomTreeNodeBase<BlockT>> NI = currentNode.begin(), 
          NE = currentNode.end();
           Native.$noteq(NI, NE); NI.$preInc()) {
        DomTreeNodeBase<BlockT> /*P*/ IDominee = NI.$star();
        BlockT /*P*/ childBB = IDominee.getBlock();
        if (Native.$eq(visited.count(childBB), 0)) {
          workList.push_back(new DFCalculateWorkObject<BlockT>(childBB, currentBB, IDominee, currentNode));
          visitChild = true;
        }
      }
      
      // If all children are visited or there is any child then pop this block
      // from the workList.
      if (!visitChild) {
        if (Native.$not(parentBB)) {
          Result = $AddrOf(S);
          break;
        }
        
          StdSetPtr.iterator<BlockT> CDFI = S.begin();
          StdSetPtr.iterator<BlockT> CDFE = S.end();
        final  setPtr<BlockT> /*&*/ parentSet = this.Frontiers.$at(parentBB);
        for (; Native.$noteq(CDFI, CDFE); CDFI.$preInc()) {
          if (Native.$not(DT.properlyDominates(parentNode, DT.$at(CDFI.$star())))) {
            parentSet.insert(CDFI.$star());
          }
        }
        workList.pop_back();
      }
    } while (Native.$not(workList.empty()));
    
    return $Deref(Result);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public void $destroy() {
  }

  public /*inline*/ ForwardDominanceFrontierBase(JavaDifferentiators.JD$Move _dparam, final ForwardDominanceFrontierBase /*&&*/$Prm0) {
    super(_dparam, $Prm0);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class DominanceFrontierGlobals
