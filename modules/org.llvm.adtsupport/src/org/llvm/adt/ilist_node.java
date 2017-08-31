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

package org.llvm.adt;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;


/// ilist_node - Base class that provides next/prev services for nodes
/// that use ilist_nextprev_traits or ilist_default_traits.
///
/*template <typename NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist_node">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 47,
 FQN="llvm::ilist_node", NM="_ZN4llvm10ilist_nodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm10ilist_nodeE")
//</editor-fold>
public interface/*class*/ ilist_node</*typename*/ NodeTy extends ilist_node<NodeTy>>  extends /*private*/ ilist_half_node<NodeTy> {
  /*friend  struct ilist_nextprev_traits<NodeTy>*/
  /*friend  struct ilist_traits<NodeTy>*/
  /*friend  struct ilist_half_embedded_sentinel_traits<NodeTy>*/
  /*friend  struct ilist_embedded_sentinel_traits<NodeTy>*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node::getNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 54,
   FQN="llvm::ilist_node::getNext", NM="_ZN4llvm10ilist_node7getNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm10ilist_node7getNextEv")
  //</editor-fold>
  public/*private*/ default/*interface*/ NodeTy /*P*/ getNext() {
    return $ilist_node$Fields().Next;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node::getNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 55,
   FQN="llvm::ilist_node::getNext", NM="_ZNK4llvm10ilist_node7getNextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZNK4llvm10ilist_node7getNextEv")
  //</editor-fold>
  public/*private*/ default/*interface*/ /*const*/ NodeTy /*P*/ getNext$Const() /*const*/ {
    return $ilist_node$Fields().Next;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node::setNext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 56,
   FQN="llvm::ilist_node::setNext", NM="_ZN4llvm10ilist_node7setNextEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm10ilist_node7setNextEPT_")
  //</editor-fold>
  public/*private*/ default/*interface*/ void setNext(NodeTy /*P*/ N) {
    $ilist_node$Fields().Next = N;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node::ilist_node<NodeTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 58,
   FQN="llvm::ilist_node::ilist_node<NodeTy>", NM="_ZN4llvm10ilist_nodeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm10ilist_nodeC1Ev")
  //</editor-fold>
  public/*protected*/ default/*interface*/ ilist_node$Fields $ilist_node() {
    // : Next(null) 
    //START JInit
    return new ilist_node$Fields();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node::getIterator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 61,
   FQN="llvm::ilist_node::getIterator", NM="_ZN4llvm10ilist_node11getIteratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm10ilist_node11getIteratorEv")
  //</editor-fold>
  public default/*interface*/ ilist_iterator<NodeTy> getIterator() {
    // FIXME: Stop downcasting to create the iterator (potential UB).
    return new ilist_iterator<NodeTy>((NodeTy)this, (ilist_traits<NodeTy>)null);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node::getIterator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 65,
   FQN="llvm::ilist_node::getIterator", NM="_ZNK4llvm10ilist_node11getIteratorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZNK4llvm10ilist_node11getIteratorEv")
  //</editor-fold>
  public default/*interface*/ ilist_iterator</*const*/ NodeTy> getIterator$Const() /*const*/ {
    // FIXME: Stop downcasting to create the iterator (potential UB).
    return new ilist_iterator<NodeTy>((NodeTy)this, (ilist_traits<NodeTy>)null);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public final class ilist_node$Fields<NodeTy> extends ilist_half_node$Fields<NodeTy> {

    private ilist_node$Fields() {
      this.Next = null;
    }
    
    protected ilist_node$Fields(ilist_node$Fields<NodeTy> $Prm0) {
      super($Prm0);
      this.Prev = $Prm0.Prev;
    }
    protected ilist_node$Fields(JD$Move _dparam, ilist_node$Fields<NodeTy> $Prm0) {
      super(_dparam, $Prm0);
      this.Prev = $Prm0.Prev;
    }
    
    public/*private*/ NodeTy /*P*/ Next;

    @Override
    public String toString() {
      return "Next=" + NativeTrace.getIdentityStr(Next) + " " + super.toString();
    }
  }
  
  public default ilist_node$Fields<NodeTy> $ilist_node$Fields() {
    throw new UnsupportedOperationException("Override as final getter in derived " + this.getClass());
  }
  
  public/*protected*/ default/*interface*/ ilist_node$Fields $ilist_node(final /*const*/ ilist_node /*&*/ $Prm0) {
    $ilist_half_node($Prm0);
    return new ilist_node$Fields();
  }
  
  public/*protected*/ default/*interface*/ ilist_node$Fields $ilist_node(JD$Move _dparam, final ilist_node /*&&*/$Prm0) {
    $ilist_half_node(JD$Move.INSTANCE, $Prm0);
    return new ilist_node$Fields();
  }
  
  public /*final*/ default ilist_half_node$Fields<NodeTy> $ilist_half_node$Fields() {
    return $ilist_node$Fields();
  }
  
  public default/*interface*/ void $destroy$ilist_node() {
    
  }
  
  public default/*interface*/ void $assign$ilist_node(NodeTy $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  public default/*interface*/ void $assignMove$ilist_node(NodeTy $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////  
}
