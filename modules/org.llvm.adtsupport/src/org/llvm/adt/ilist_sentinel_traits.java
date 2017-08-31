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
import org.clank.support.aliases.type$ref;


/// ilist_sentinel_traits - A fragment for template traits for intrusive list
/// that provides default sentinel implementations for common operations.
///
/// ilist_sentinel_traits implements a lazy dynamic sentinel allocation
/// strategy. The sentinel is stored in the prev field of ilist's Head.
///
/*template <typename NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist_sentinel_traits">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 75,
 FQN="llvm::ilist_sentinel_traits", NM="_ZN4llvm21ilist_sentinel_traitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm21ilist_sentinel_traitsE")
//</editor-fold>
public interface/*struct*/ ilist_sentinel_traits</*typename*/ NodeTy extends ilist_node<NodeTy>>  {
  /// createSentinel - create the dynamic sentinel
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_sentinel_traits::createSentinel">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 78,
   FQN="llvm::ilist_sentinel_traits::createSentinel", NM="_ZN4llvm21ilist_sentinel_traits14createSentinelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm21ilist_sentinel_traits14createSentinelEv")
  //</editor-fold>
  public NodeTy /*P*/ createSentinel();

  
  /// destroySentinel - deallocate the dynamic sentinel
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_sentinel_traits::destroySentinel">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 81,
   FQN="llvm::ilist_sentinel_traits::destroySentinel", NM="_ZN4llvm21ilist_sentinel_traits15destroySentinelEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm21ilist_sentinel_traits15destroySentinelEPT_")
  //</editor-fold>
  public /*interface*/ default void destroySentinel(NodeTy /*P*/ N) {
    /*delete*/Destructors.$destroy(N);
  }

  
  /// provideInitialHead - when constructing an ilist, provide a starting
  /// value for its Head
  /// @return null node to indicate that it needs to be allocated later
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_sentinel_traits::provideInitialHead">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 86,
   FQN="llvm::ilist_sentinel_traits::provideInitialHead", NM="_ZN4llvm21ilist_sentinel_traits18provideInitialHeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm21ilist_sentinel_traits18provideInitialHeadEv")
  //</editor-fold>
  public /*interface*/ default NodeTy /*P*/ provideInitialHead() {
    return null;
  }

  
  /// ensureHead - make sure that Head is either already
  /// initialized or assigned a fresh sentinel
  /// @return the sentinel
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_sentinel_traits::ensureHead">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 91,
   FQN="llvm::ilist_sentinel_traits::ensureHead", NM="_ZN4llvm21ilist_sentinel_traits10ensureHeadERPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm21ilist_sentinel_traits10ensureHeadERPT_")
  //</editor-fold>
  public /*interface*/ NodeTy /*P*/ ensureHead(final type$ref<NodeTy> /*P*/ /*&*/ Head);

  
  /// noteHead - stash the sentinel into its default location
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_sentinel_traits::noteHead">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 102,
   FQN="llvm::ilist_sentinel_traits::noteHead", NM="_ZN4llvm21ilist_sentinel_traits8noteHeadEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm21ilist_sentinel_traits8noteHeadEPT_S2_")
  //</editor-fold>
  public default void noteHead(NodeTy /*P*/ NewHead, NodeTy /*P*/ Sentinel) {
    NewHead.setPrev(Sentinel); // or should we just make it abstrct?
  }
}
