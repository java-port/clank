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
import org.llvm.adt.*;


/// An ilist node that can access its parent list.
///
/// Requires \c NodeTy to have \a getParent() to find the parent node, and the
/// \c ParentTy to have \a getSublistAccess() to get a reference to the list.
/*template <typename NodeTy, typename ParentTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_with_parent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 75,
 FQN="llvm::ilist_node_with_parent", NM="_ZN4llvm22ilist_node_with_parentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_ZN4llvm22ilist_node_with_parentE")
//</editor-fold>
public interface/*class*/ ilist_node_with_parent</*typename*/ NodeTy extends ilist_node<NodeTy>, /*typename*/ ParentTy>  extends /*public*/ ilist_node<NodeTy> {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_with_parent::ilist_node_with_parent<NodeTy, ParentTy>">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 78,
   FQN="llvm::ilist_node_with_parent::ilist_node_with_parent<NodeTy, ParentTy>", NM="_ZN4llvm22ilist_node_with_parentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_ZN4llvm22ilist_node_with_parentC1Ev")
  //</editor-fold>
  public/*protected*/ default/*interface*/ ilist_node$Fields $ilist_node_with_parent()/* = default*/ {
    return $ilist_node();
  }


/*private:*/
  /// Forward to NodeTy::getParent().
  ///
  /// Note: do not use the name "getParent()".  We want a compile error
  /// (instead of recursion) when the subclass fails to implement \a
  /// getParent().
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_with_parent::getNodeParent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 86,
   FQN="llvm::ilist_node_with_parent::getNodeParent", NM="_ZNK4llvm22ilist_node_with_parent13getNodeParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_ZNK4llvm22ilist_node_with_parent13getNodeParentEv")
  //</editor-fold>
  public/*private*/ default/*interface*/ /*const*/ ParentTy /*P*/ getNodeParent() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  /// @name Adjacent Node Accessors
  /// @{
  /// \brief Get the previous node, or \c nullptr for the list head.
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_with_parent::getPrevNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 94,
   FQN="llvm::ilist_node_with_parent::getPrevNode", NM="_ZN4llvm22ilist_node_with_parent11getPrevNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_ZN4llvm22ilist_node_with_parent11getPrevNodeEv")
  //</editor-fold>
  public default/*interface*/ NodeTy /*P*/ getPrevNode() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \brief Get the previous node, or \c nullptr for the list head.
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_with_parent::getPrevNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 102,
   FQN="llvm::ilist_node_with_parent::getPrevNode", NM="_ZNK4llvm22ilist_node_with_parent11getPrevNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_ZNK4llvm22ilist_node_with_parent11getPrevNodeEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ NodeTy /*P*/ getPrevNode$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Get the next node, or \c nullptr for the list tail.
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_with_parent::getNextNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 107,
   FQN="llvm::ilist_node_with_parent::getNextNode", NM="_ZN4llvm22ilist_node_with_parent11getNextNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_ZN4llvm22ilist_node_with_parent11getNextNodeEv")
  //</editor-fold>
  public default/*interface*/ NodeTy /*P*/ getNextNode() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// \brief Get the next node, or \c nullptr for the list tail.
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_node_with_parent::getNextNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist_node.h", line = 115,
   FQN="llvm::ilist_node_with_parent::getNextNode", NM="_ZNK4llvm22ilist_node_with_parent11getNextNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_ZNK4llvm22ilist_node_with_parent11getNextNodeEv")
  //</editor-fold>
  public default/*interface*/ /*const*/ NodeTy /*P*/ getNextNode$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public default void $destroy$ilist_node_with_parent() {}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
/// @}
}
