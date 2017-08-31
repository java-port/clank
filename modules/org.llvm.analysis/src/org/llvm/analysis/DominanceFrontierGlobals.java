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


//<editor-fold defaultstate="collapsed" desc="static type DominanceFrontierGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="DominanceFrontierGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBaseE;_ZN4llvm21DominanceFrontierBaseINS_10BasicBlockEEE;_ZN4llvm28ForwardDominanceFrontierBaseE;_ZN4llvm28ForwardDominanceFrontierBaseINS_10BasicBlockEEE; -static-type=DominanceFrontierGlobals")
//</editor-fold>
public final class DominanceFrontierGlobals {


//===----------------------------------------------------------------------===//
/// DominanceFrontierBase - Common base class for computing forward and inverse
/// dominance frontiers for a function.
///
/*template <class BlockT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 32,
 FQN="llvm::DominanceFrontierBase", NM="_ZN4llvm21DominanceFrontierBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBaseE")
//</editor-fold>
public static class DominanceFrontierBase</*class*/ BlockT>  {
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
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 46,
   FQN="llvm::DominanceFrontierBase::DominanceFrontierBase<BlockT>", NM="_ZN4llvm21DominanceFrontierBaseC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBaseC1Eb")
  //</editor-fold>
  public DominanceFrontierBase(boolean isPostDom) {
    // : IsPostDominators(isPostDom) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getRoots - Return the root blocks of the current CFG.  This may include
  /// multiple blocks if we are computing post dominators.  For forward
  /// dominators, this will always be a single block (the entry node).
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::getRoots">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 52,
   FQN="llvm::DominanceFrontierBase::getRoots", NM="_ZNK4llvm21DominanceFrontierBase8getRootsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase8getRootsEv")
  //</editor-fold>
  public /*inline*/ /*const*/ std.vector<BlockT /*P*/ > /*&*/ getRoots() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::getRoot">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 56,
   FQN="llvm::DominanceFrontierBase::getRoot", NM="_ZNK4llvm21DominanceFrontierBase7getRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase7getRootEv")
  //</editor-fold>
  public BlockT /*P*/ getRoot() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isPostDominator - Returns true if analysis based of postdoms
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::isPostDominator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 63,
   FQN="llvm::DominanceFrontierBase::isPostDominator", NM="_ZNK4llvm21DominanceFrontierBase15isPostDominatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase15isPostDominatorEv")
  //</editor-fold>
  public boolean isPostDominator() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::releaseMemory">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 67,
   FQN="llvm::DominanceFrontierBase::releaseMemory", NM="_ZN4llvm21DominanceFrontierBase13releaseMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase13releaseMemoryEv")
  //</editor-fold>
  public void releaseMemory() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Accessor interface:
  // JAVA: typedef typename DomSetMapType::iterator iterator
//  public final class iterator extends  std.map.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > >{ };
  // JAVA: typedef typename DomSetMapType::const_iterator const_iterator
//  public final class const_iterator extends  std.map.const_iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > >{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 74,
   FQN="llvm::DominanceFrontierBase::begin", NM="_ZN4llvm21DominanceFrontierBase5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase5beginEv")
  //</editor-fold>
  public  std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 75,
   FQN="llvm::DominanceFrontierBase::begin", NM="_ZNK4llvm21DominanceFrontierBase5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase5beginEv")
  //</editor-fold>
  public  std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > begin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 76,
   FQN="llvm::DominanceFrontierBase::end", NM="_ZN4llvm21DominanceFrontierBase3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase3endEv")
  //</editor-fold>
  public  std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 77,
   FQN="llvm::DominanceFrontierBase::end", NM="_ZNK4llvm21DominanceFrontierBase3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase3endEv")
  //</editor-fold>
  public  std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > end$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::find">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 78,
   FQN="llvm::DominanceFrontierBase::find", NM="_ZN4llvm21DominanceFrontierBase4findEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase4findEPT_")
  //</editor-fold>
  public  std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > find(BlockT /*P*/ B) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::find">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 79,
   FQN="llvm::DominanceFrontierBase::find", NM="_ZNK4llvm21DominanceFrontierBase4findEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase4findEPT_")
  //</editor-fold>
  public  std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > find$Const(BlockT /*P*/ B) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::addBasicBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 81,
   FQN="llvm::DominanceFrontierBase::addBasicBlock", NM="_ZN4llvm21DominanceFrontierBase13addBasicBlockEPT_RKSt3setIS2_St4lessIS2_ESaIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase13addBasicBlockEPT_RKSt3setIS2_St4lessIS2_ESaIS2_EE")
  //</editor-fold>
  public  std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > addBasicBlock(BlockT /*P*/ BB, final /*const*/ std.setPtr<BlockT /*P*/ > /*&*/ frontier) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// removeBlock - Remove basic block BB's frontier.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::removeBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 42,
   FQN="llvm::DominanceFrontierBase::removeBlock", NM="_ZN4llvm21DominanceFrontierBase11removeBlockEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase11removeBlockEPT_")
  //</editor-fold>
  public void removeBlock(BlockT /*P*/ BB) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::addToFrontier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 50,
   FQN="llvm::DominanceFrontierBase::addToFrontier", NM="_ZN4llvm21DominanceFrontierBase13addToFrontierENSt3mapIPT_St3setIS3_St4lessIS3_ESaIS3_EES6_SaISt4pairIKS3_S8_EEE8iteratorES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase13addToFrontierENSt3mapIPT_St3setIS3_St4lessIS3_ESaIS3_EES6_SaISt4pairIKS3_S8_EEE8iteratorES3_")
  //</editor-fold>
  public void addToFrontier( std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > I, 
               BlockT /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::removeFromFrontier">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 58,
   FQN="llvm::DominanceFrontierBase::removeFromFrontier", NM="_ZN4llvm21DominanceFrontierBase18removeFromFrontierENSt3mapIPT_St3setIS3_St4lessIS3_ESaIS3_EES6_SaISt4pairIKS3_S8_EEE8iteratorES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm21DominanceFrontierBase18removeFromFrontierENSt3mapIPT_St3setIS3_St4lessIS3_ESaIS3_EES6_SaISt4pairIKS3_S8_EEE8iteratorES3_")
  //</editor-fold>
  public void removeFromFrontier( std.mapPtrType.iterator<BlockT /*P*/ , std.setPtr<BlockT /*P*/ > > I, 
                    BlockT /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// compareDomSet - Return false if two domsets match. Otherwise
  /// return true;
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::compareDomSet">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 66,
   FQN="llvm::DominanceFrontierBase::compareDomSet", NM="_ZNK4llvm21DominanceFrontierBase13compareDomSetERSt3setIPT_St4lessIS3_ESaIS3_EERKS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase13compareDomSetERSt3setIPT_St4lessIS3_ESaIS3_EERKS7_")
  //</editor-fold>
  public boolean compareDomSet(final std.setPtr<BlockT /*P*/ > /*&*/ DS1, 
               final /*const*/ std.setPtr<BlockT /*P*/ > /*&*/ DS2) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// compare - Return true if the other dominance frontier base matches
  /// this dominance frontier base. Otherwise return false.
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::compare">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 91,
   FQN="llvm::DominanceFrontierBase::compare", NM="_ZNK4llvm21DominanceFrontierBase7compareERNS_21DominanceFrontierBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase7compareERNS_21DominanceFrontierBaseIT_EE")
  //</editor-fold>
  public boolean compare(final DominanceFrontierBase<BlockT> /*&*/ Other) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// print - Convert to human readable form
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 121,
   FQN="llvm::DominanceFrontierBase::print", NM="_ZNK4llvm21DominanceFrontierBase5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DominanceFrontierBase::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 145,
   FQN="llvm::DominanceFrontierBase::dump", NM="_ZNK4llvm21DominanceFrontierBase4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZNK4llvm21DominanceFrontierBase4dumpEv")
  //</editor-fold>
  public void dump() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
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
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 115,
 FQN="llvm::ForwardDominanceFrontierBase", NM="_ZN4llvm28ForwardDominanceFrontierBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28ForwardDominanceFrontierBaseE")
//</editor-fold>
public static class ForwardDominanceFrontierBase</*class*/ BlockT>  extends /*public*/ DominanceFrontierBase<BlockT> {
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
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 125,
   FQN="llvm::ForwardDominanceFrontierBase::ForwardDominanceFrontierBase<BlockT>", NM="_ZN4llvm28ForwardDominanceFrontierBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28ForwardDominanceFrontierBaseC1Ev")
  //</editor-fold>
  public ForwardDominanceFrontierBase() {
    // : DominanceFrontierBase<BlockT>(false) 
    /*ParenListExpr*/super(false);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ForwardDominanceFrontierBase::analyze">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontier.h", line = 127,
   FQN="llvm::ForwardDominanceFrontierBase::analyze", NM="_ZN4llvm28ForwardDominanceFrontierBase7analyzeERNS_17DominatorTreeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28ForwardDominanceFrontierBase7analyzeERNS_17DominatorTreeBaseIT_EE")
  //</editor-fold>
  public void analyze(final DominatorTreeBase<BlockT> /*&*/ DT) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ForwardDominanceFrontierBase::calculate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DominanceFrontierImpl.h", line = 151,
   FQN="llvm::ForwardDominanceFrontierBase::calculate", NM="_ZN4llvm28ForwardDominanceFrontierBase9calculateERKNS_17DominatorTreeBaseIT_EEPKNS_15DomTreeNodeBaseIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm28ForwardDominanceFrontierBase9calculateERKNS_17DominatorTreeBaseIT_EEPKNS_15DomTreeNodeBaseIS2_EE")
  //</editor-fold>
  public /*const*/std.setPtr<BlockT/*P*/>/*&*/ calculate(final /*const*/ DominatorTreeBase<BlockT> /*&*/ DT, 
           /*const*/ DomTreeNodeBase<BlockT> /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class DominanceFrontierGlobals
