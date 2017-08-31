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

/// ilist_half_node - Base class that provides prev services for sentinels.
///
/*template <typename NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist_half_node">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 27,
 FQN="llvm::ilist_half_node", NM="_ZN4llvm15ilist_half_nodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm15ilist_half_nodeE")
//</editor-fold>
public interface/*class*/ ilist_half_node</*typename*/ NodeTy>  {
  /*friend  struct ilist_traits<NodeTy>*/
  /*friend  struct ilist_half_embedded_sentinel_traits<NodeTy>*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_half_node::getPrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 33,
   FQN="llvm::ilist_half_node::getPrev", NM="_ZN4llvm15ilist_half_node7getPrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm15ilist_half_node7getPrevEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ NodeTy /*P*/ getPrev() {
    return $ilist_half_node$Fields().Prev;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_half_node::getPrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 34,
   FQN="llvm::ilist_half_node::getPrev", NM="_ZNK4llvm15ilist_half_node7getPrevEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZNK4llvm15ilist_half_node7getPrevEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ /*const*/ NodeTy /*P*/ getPrev$Const() /*const*/ {
    return $ilist_half_node$Fields().Prev;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_half_node::setPrev">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 35,
   FQN="llvm::ilist_half_node::setPrev", NM="_ZN4llvm15ilist_half_node7setPrevEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm15ilist_half_node7setPrevEPT_")
  //</editor-fold>
  public/*protected*/ default/*interface*/ void setPrev(NodeTy /*P*/ P) {
    $ilist_half_node$Fields().Prev = P;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_half_node::ilist_half_node<NodeTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 36,
   FQN="llvm::ilist_half_node::ilist_half_node<NodeTy>", NM="_ZN4llvm15ilist_half_nodeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm15ilist_half_nodeC1Ev")
  //</editor-fold>
  public/*protected*/ default/*interface*/ ilist_half_node$Fields<NodeTy> $ilist_half_node() {
    // : Prev(null) 
    //START JInit
    return new ilist_half_node$Fields<NodeTy>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public/*protected*/ default/*interface*/ ilist_half_node$Fields<NodeTy> $ilist_half_node(final /*const*/ ilist_half_node<NodeTy> /*&*/ $Prm0) {
    return new ilist_half_node$Fields<NodeTy>($Prm0.$ilist_half_node$Fields());
  }
  
  public/*protected*/ default/*interface*/ ilist_half_node$Fields<NodeTy> $ilist_half_node(JD$Move _dparam, final ilist_half_node<NodeTy> /*&&*/$Prm0) {
    return new ilist_half_node$Fields<NodeTy>(_dparam, $Prm0.$ilist_half_node$Fields());
  }
  
  public /*final*/ static class ilist_half_node$Fields<NodeTy> {
    public/*private*/ NodeTy /*P*/ Prev;
    
    protected ilist_half_node$Fields() {
      this.Prev = null;
    }
    
    protected ilist_half_node$Fields(ilist_half_node$Fields<NodeTy> $Prm0) {
      this.Prev = $Prm0.Prev;
    }
    
    protected ilist_half_node$Fields(JD$Move _dparam, ilist_half_node$Fields<NodeTy> $Prm0) {
      this.Prev = $Prm0.Prev;
    }

    @Override
    public String toString() {
      return "Prev=" + NativeTrace.getIdentityStr(Prev);
    }
  }
  
  public default ilist_half_node$Fields<NodeTy> $ilist_half_node$Fields() {
    throw new UnsupportedOperationException("Override as final getter in derived " + this.getClass());
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
}
