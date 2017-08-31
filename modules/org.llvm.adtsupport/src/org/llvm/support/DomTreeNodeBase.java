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

import static org.clank.support.Native.$Deref;
import java.util.Iterator;
import org.clank.java.*;
import static org.clank.java.std.$noteq___normal_iterator$C;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;


/// \brief Base class for the actual dominator tree node.
/*template <class NodeT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase">
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION/*based on DomTreeNodeBase<BasicBlock> from IR*/,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 69,
 FQN="llvm::DomTreeNodeBase", NM="_ZN4llvm15DomTreeNodeBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm15DomTreeNodeBaseE")
//</editor-fold>
public class DomTreeNodeBase</*class*/ NodeT>  implements Iterable</*const*/ DomTreeNodeBase<NodeT> /*P*/>, Destructors.ClassWithDestructor {
  protected/*private*/ NodeT /*P*/ TheBB;
  protected/*private*/ DomTreeNodeBase<NodeT> /*P*/ IDom;
  /*friend*/public/*private*/ std.vector<DomTreeNodeBase<NodeT> /*P*/ > Children;
  /*friend*/public/*private*/ /*mutable */int DFSNumIn;
  /*friend*/public/*private*/ /*mutable */int DFSNumOut;
  
  /*friend template <class N> class DominatorTreeBase*/
  /*friend  struct PostDominatorTree*/
/*public:*/
  // JAVA: typedef typename std::vector<DomTreeNodeBase<NodeT> *>::iterator iterator
//  public final class iterator extends std.vector.iterator<DomTreeNodeBase<NodeT> /*P*/ >{ };
  // JAVA: typedef typename std::vector<DomTreeNodeBase<NodeT> *>::const_iterator const_iterator
//  public final class const_iterator extends  std.vector.const_iterator<DomTreeNodeBase<NodeT> /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 83,
   FQN="llvm::DomTreeNodeBase::begin", NM="_ZN4llvm15DomTreeNodeBase5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm15DomTreeNodeBase5beginEv")
  //</editor-fold>
  public std.vector.iterator<DomTreeNodeBase<NodeT> /*P*/ > begin() {
    return Children.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 84,
   FQN="llvm::DomTreeNodeBase::end", NM="_ZN4llvm15DomTreeNodeBase3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm15DomTreeNodeBase3endEv")
  //</editor-fold>
  public std.vector.iterator<DomTreeNodeBase<NodeT> /*P*/ > end() {
    return Children.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 85,
   FQN="llvm::DomTreeNodeBase::begin", NM="_ZNK4llvm15DomTreeNodeBase5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase5beginEv")
  //</editor-fold>
  public  std.vector.iterator<DomTreeNodeBase<NodeT> /*P*/ > begin$Const() /*const*/ {
    return Children.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 86,
   FQN="llvm::DomTreeNodeBase::end", NM="_ZNK4llvm15DomTreeNodeBase3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase3endEv")
  //</editor-fold>
  public  std.vector.iterator<DomTreeNodeBase<NodeT> /*P*/ > end$Const() /*const*/ {
    return Children.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::getBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 88,
   FQN="llvm::DomTreeNodeBase::getBlock", NM="_ZNK4llvm15DomTreeNodeBase8getBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase8getBlockEv")
  //</editor-fold>
  public NodeT /*P*/ getBlock() /*const*/ {
    return TheBB;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::getIDom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 89,
   FQN="llvm::DomTreeNodeBase::getIDom", NM="_ZNK4llvm15DomTreeNodeBase7getIDomEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase7getIDomEv")
  //</editor-fold>
  public DomTreeNodeBase<NodeT> /*P*/ getIDom() /*const*/ {
    return IDom;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::getChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 90,
   FQN="llvm::DomTreeNodeBase::getChildren", NM="_ZNK4llvm15DomTreeNodeBase11getChildrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase11getChildrenEv")
  //</editor-fold>
  public /*const*/ std.vector<DomTreeNodeBase<NodeT> /*P*/ > /*&*/ getChildren() /*const*/ {
    return Children;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::DomTreeNodeBase<NodeT>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 94,
   FQN="llvm::DomTreeNodeBase::DomTreeNodeBase<NodeT>", NM="_ZN4llvm15DomTreeNodeBaseC1EPT_PNS_15DomTreeNodeBaseIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm15DomTreeNodeBaseC1EPT_PNS_15DomTreeNodeBaseIS1_EE")
  //</editor-fold>
  public DomTreeNodeBase(NodeT /*P*/ BB, DomTreeNodeBase<NodeT> /*P*/ iDom) {
    // : TheBB(BB), IDom(iDom), Children(), DFSNumIn(-1), DFSNumOut(-1) 
    //START JInit
    this.TheBB = /*ParenListExpr*/BB;
    this.IDom = /*ParenListExpr*/iDom;
    this.Children = new std.vector<DomTreeNodeBase<NodeT> /*P*/>((DomTreeNodeBase<NodeT> /*P*/)null);
    this.DFSNumIn = -1;
    this.DFSNumOut = -1;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::addChild">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 97,
   FQN="llvm::DomTreeNodeBase::addChild", NM="_ZN4llvm15DomTreeNodeBase8addChildESt10unique_ptrINS_15DomTreeNodeBaseIT_EESt14default_deleteIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm15DomTreeNodeBase8addChildESt10unique_ptrINS_15DomTreeNodeBaseIT_EESt14default_deleteIS5_EE")
  //</editor-fold>
  public <T extends DomTreeNodeBase<NodeT>> std.unique_ptr<T> addChild(std.unique_ptr<T> C) {
    Children.push_back_T$RR(C.get());
    return new std.unique_ptr<T>(JD$Move.INSTANCE, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::getNumChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 103,
   FQN="llvm::DomTreeNodeBase::getNumChildren", NM="_ZNK4llvm15DomTreeNodeBase14getNumChildrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase14getNumChildrenEv")
  //</editor-fold>
  public /*size_t*/int getNumChildren() /*const*/ {
    return Children.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::clearAllChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 105,
   FQN="llvm::DomTreeNodeBase::clearAllChildren", NM="_ZN4llvm15DomTreeNodeBase16clearAllChildrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm15DomTreeNodeBase16clearAllChildrenEv")
  //</editor-fold>
  public void clearAllChildren() {
    Children.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,//based on instantiation
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 107,
   FQN="llvm::DomTreeNodeBase::compare", NM="_ZNK4llvm15DomTreeNodeBase7compareEPKNS_15DomTreeNodeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase7compareEPKNS_15DomTreeNodeBaseIT_EE")
  //</editor-fold>
  public boolean compare(/*const*/ DomTreeNodeBase<NodeT> /*P*/ Other) /*const*/ {
    if (getNumChildren() != Other.getNumChildren()) {
      return true;
    }
    
    SmallPtrSet</*const*/ NodeT /*P*/ > OtherChildren/*J*/= new SmallPtrSet</*const*/ NodeT /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    for (/*const*/ DomTreeNodeBase<NodeT> /*P*/ I : $Deref(Other)) {
      /*const*/ NodeT /*P*/ Nd = I.getBlock();
      OtherChildren.insert(Nd);
    }
    
    for (/*const*/ DomTreeNodeBase<NodeT> /*P*/ I : /*Deref*/this) {
      /*const*/ NodeT /*P*/ N = I.getBlock();
      if (OtherChildren.count(N) == 0) {
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::setIDom">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 125,
   FQN="llvm::DomTreeNodeBase::setIDom", NM="_ZN4llvm15DomTreeNodeBase7setIDomEPNS_15DomTreeNodeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm15DomTreeNodeBase7setIDomEPNS_15DomTreeNodeBaseIT_EE")
  //</editor-fold>
  public void setIDom(DomTreeNodeBase<NodeT> /*P*/ NewIDom) {
    assert ((IDom != null)) : "No immediate dominator?";
    if (IDom != NewIDom) {
      std.vector.iterator<DomTreeNodeBase<NodeT> /*P*/> I = std.find(IDom.Children.begin(), IDom.Children.end(), this, true);
      assert ($noteq___normal_iterator$C(I, IDom.Children.end())) : "Not in immediate dominator children set!";
      // I am no longer your child...
      IDom.Children.erase(new std.vector.iterator</*const*/DomTreeNodeBase<NodeT> /*P*/>(I));
      
      // Switch to new dominator
      IDom = NewIDom;
      IDom.Children.push_back_T$RR(this);
    }
  }

  
  /// getDFSNumIn/getDFSNumOut - These return the DFS visitation order for nodes
  /// in the dominator tree. They are only guaranteed valid if
  /// updateDFSNumbers() has been called.
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::getDFSNumIn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 144,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", old_line = 143,
   FQN="llvm::DomTreeNodeBase::getDFSNumIn", NM="_ZNK4llvm15DomTreeNodeBase11getDFSNumInEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase11getDFSNumInEv")
  //</editor-fold>
  public /*uint*/int getDFSNumIn() /*const*/ {
    return DFSNumIn;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::getDFSNumOut">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", old_line = 144,
   FQN="llvm::DomTreeNodeBase::getDFSNumOut", NM="_ZNK4llvm15DomTreeNodeBase12getDFSNumOutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase12getDFSNumOutEv")
  //</editor-fold>
  public /*uint*/int getDFSNumOut() /*const*/ {
    return DFSNumOut;
  }

/*private:*/
  // Return true if this node is dominated by other. Use this only if DFS info
  // is valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase::DominatedBy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/GenericDomTree.h", old_line = 149,
   FQN="llvm::DomTreeNodeBase::DominatedBy", NM="_ZNK4llvm15DomTreeNodeBase11DominatedByEPKNS_15DomTreeNodeBaseIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZNK4llvm15DomTreeNodeBase11DominatedByEPKNS_15DomTreeNodeBaseIT_EE")
  //</editor-fold>
  /*friend*/public/*private*/ boolean DominatedBy(/*const*/ DomTreeNodeBase<NodeT> /*P*/ other) /*const*/ {
    return this.DFSNumIn >= other.DFSNumIn
       && this.DFSNumOut <= other.DFSNumOut;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //<editor-fold defaultstate="collapsed" desc="llvm::DomTreeNodeBase<NodeT>::~DomTreeNodeBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 32,
   FQN="llvm::DomTreeNodeBase<NodeT>::~DomTreeNodeBase", NM="_ZN4llvm15DomTreeNodeBaseINS_10BasicBlockEED0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm15DomTreeNodeBaseINS_10BasicBlockEED0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Children.$destroy();
    //END JDestroy
  }
  
  @Override
  public Iterator<DomTreeNodeBase<NodeT>> iterator() {
    return new JavaIterator<DomTreeNodeBase<NodeT>>(begin(), end());
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "TheBB=" + TheBB // NOI18N
              + ", IDom=" + IDom // NOI18N
              + ", Children=" + Children // NOI18N
              + ", DFSNumIn=" + DFSNumIn // NOI18N
              + ", DFSNumOut=" + DFSNumOut; // NOI18N
  }
}
