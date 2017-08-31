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
import org.llvm.adt.*;


/// Traits with an embedded ilist_node as a sentinel.
///
/// FIXME: The downcast in createSentinel() is UB.
/*template <typename NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist_embedded_sentinel_traits">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 113,
 FQN="llvm::ilist_embedded_sentinel_traits", NM="_ZN4llvm30ilist_embedded_sentinel_traitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm30ilist_embedded_sentinel_traitsE")
//</editor-fold>
public interface/*struct*/ ilist_embedded_sentinel_traits</*typename*/ NodeTy extends ilist_node<NodeTy>> extends ilist_sentinel_traits<NodeTy>  {
  /// Get hold of the node that marks the end of the list.
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_embedded_sentinel_traits::createSentinel">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 115,
   FQN="llvm::ilist_embedded_sentinel_traits::createSentinel", NM="_ZNK4llvm30ilist_embedded_sentinel_traits14createSentinelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm30ilist_embedded_sentinel_traits14createSentinelEv")
  //</editor-fold>
  public default NodeTy /*P*/ createSentinel() /*const*/ {
    return $SentinelField();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_embedded_sentinel_traits::destroySentinel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 125,
   FQN="llvm::ilist_embedded_sentinel_traits::destroySentinel", NM="_ZN4llvm30ilist_embedded_sentinel_traits15destroySentinelEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm30ilist_embedded_sentinel_traits15destroySentinelEPT_")
  //</editor-fold>
  public default void destroySentinel(NodeTy /*P*/ $Prm0) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_embedded_sentinel_traits::provideInitialHead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 127,
   FQN="llvm::ilist_embedded_sentinel_traits::provideInitialHead", NM="_ZNK4llvm30ilist_embedded_sentinel_traits18provideInitialHeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm30ilist_embedded_sentinel_traits18provideInitialHeadEv")
  //</editor-fold>
  public default NodeTy /*P*/ provideInitialHead() /*const*/ {
    return createSentinel();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_embedded_sentinel_traits::ensureHead">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 128,
   FQN="llvm::ilist_embedded_sentinel_traits::ensureHead", NM="_ZNK4llvm30ilist_embedded_sentinel_traits10ensureHeadEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZNK4llvm30ilist_embedded_sentinel_traits10ensureHeadEPT_")
  //</editor-fold>
  public default NodeTy /*P*/ ensureHead(final type$ref<NodeTy> /*P*/ /*&*/ Head) /*const*/ {
    return createSentinel();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_embedded_sentinel_traits::noteHead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 129,
   FQN="llvm::ilist_embedded_sentinel_traits::noteHead", NM="_ZN4llvm30ilist_embedded_sentinel_traits8noteHeadEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm30ilist_embedded_sentinel_traits8noteHeadEPT_S2_")
  //</editor-fold>
  public static </*typename*/ NodeTy> void noteHead(NodeTy /*P*/ $Prm0, NodeTy /*P*/ $Prm1) {
  }

/*private:*/
  /** 
   * JAVA: in C++ it's a field that contains sentinel itself (not its address), initialized via sentinel class default ctor 
   * So the descendant must create a field of type NodeTy, initialize it once and this call should return it
   */
  /*mutable */NodeTy $SentinelField();
}
