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

package org.clang.tooling.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.impl.*;
import org.clang.tooling.*;

/// \brief A node of the \c FileMatchTrie.
///
/// Each node has storage for up to one path and a map mapping a path segment to
/// child nodes. The trie starts with an empty root node.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrieNode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 38,
 FQN="clang::tooling::FileMatchTrieNode", NM="_ZN5clang7tooling17FileMatchTrieNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling17FileMatchTrieNodeE")
//</editor-fold>
public class FileMatchTrieNode implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Inserts 'NewPath' into this trie. \c ConsumedLength denotes
  /// the number of \c NewPath's trailing characters already consumed during
  /// recursion.
  ///
  /// An insert of a path
  /// 'p'starts at the root node and does the following:
  /// - If the node is empty, insert 'p' into its storage and abort.
  /// - If the node has a path 'p2' but no children, take the last path segment
  ///   's' of 'p2', put a new child into the map at 's' an insert the rest of
  ///   'p2' there.
  /// - Insert a new child for the last segment of 'p' and insert the rest of
  ///   'p' there.
  ///
  /// An insert operation is linear in the number of a path's segments.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrieNode::insert">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 54,
   FQN="clang::tooling::FileMatchTrieNode::insert", NM="_ZN5clang7tooling17FileMatchTrieNode6insertEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling17FileMatchTrieNode6insertEN4llvm9StringRefEj")
  //</editor-fold>
  public void insert(StringRef NewPath) {
    insert(NewPath, 0);
  }
  public void insert(StringRef NewPath, /*uint*/int ConsumedLength/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Tries to find the node under this \c FileMatchTrieNode that best
  /// matches 'FileName'.
  ///
  /// If multiple paths fit 'FileName' equally well, \c IsAmbiguous is set to
  /// \c true and an empty string is returned. If no path fits 'FileName', an
  /// empty string is returned. \c ConsumedLength denotes the number of
  /// \c Filename's trailing characters already consumed during recursion.
  ///
  /// To find the best matching node for a given path 'p', the
  /// \c findEquivalent() function is called recursively for each path segment
  /// (back to fron) of 'p' until a node 'n' is reached that does not ..
  /// - .. have children. In this case it is checked
  ///   whether the stored path is equivalent to 'p'. If yes, the best match is
  ///   found. Otherwise continue with the parent node as if this node did not
  ///   exist.
  /// - .. a child matching the next path segment. In this case, all children of
  ///   'n' are an equally good match for 'p'. All children are of 'n' are found
  ///   recursively and their equivalence to 'p' is determined. If none are
  ///   equivalent, continue with the parent node as if 'n' didn't exist. If one
  ///   is equivalent, the best match is found. Otherwise, report and ambigiuity
  ///   error.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrieNode::findEquivalent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 99,
   FQN="clang::tooling::FileMatchTrieNode::findEquivalent", NM="_ZNK5clang7tooling17FileMatchTrieNode14findEquivalentERKNS0_14PathComparatorEN4llvm9StringRefERbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZNK5clang7tooling17FileMatchTrieNode14findEquivalentERKNS0_14PathComparatorEN4llvm9StringRefERbj")
  //</editor-fold>
  public StringRef findEquivalent(final /*const*/ PathComparator /*&*/ Comparator, 
                StringRef FileName, 
                final bool$ref/*bool &*/ IsAmbiguous) /*const*/ {
    return findEquivalent(Comparator, 
                FileName, 
                IsAmbiguous, 
                0);
  }
  public StringRef findEquivalent(final /*const*/ PathComparator /*&*/ Comparator, 
                StringRef FileName, 
                final bool$ref/*bool &*/ IsAmbiguous, 
                /*uint*/int ConsumedLength/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// \brief Gets all paths under this FileMatchTrieNode.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrieNode::getAll">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 137,
   FQN="clang::tooling::FileMatchTrieNode::getAll", NM="_ZNK5clang7tooling17FileMatchTrieNode6getAllERSt6vectorIN4llvm9StringRefESaIS4_EENS3_22StringMapConstIteratorIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZNK5clang7tooling17FileMatchTrieNode6getAllERSt6vectorIN4llvm9StringRefESaIS4_EENS3_22StringMapConstIteratorIS1_EE")
  //</editor-fold>
  private void getAll(final std.vector<StringRef> /*&*/ Results, 
        StringMapConstIterator<FileMatchTrieNode> Except) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // The stored absolute path in this node. Only valid for leaf nodes, i.e.
  // nodes where Children.empty().
  private std.string Path;
  
  // The children of this node stored in a map based on the next path segment.
  private StringMap<FileMatchTrieNode> Children;
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrieNode::~FileMatchTrieNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 38,
   FQN="clang::tooling::FileMatchTrieNode::~FileMatchTrieNode", NM="_ZN5clang7tooling17FileMatchTrieNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling17FileMatchTrieNodeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrieNode::FileMatchTrieNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 38,
   FQN="clang::tooling::FileMatchTrieNode::FileMatchTrieNode", NM="_ZN5clang7tooling17FileMatchTrieNodeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling17FileMatchTrieNodeC1Ev")
  //</editor-fold>
  public /*inline*/ FileMatchTrieNode() {
    // : Path(), Children() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Path=" + Path // NOI18N
              + ", Children=" + Children; // NOI18N
  }
}
