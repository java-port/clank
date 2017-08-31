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

package org.clang.tooling;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.tooling.impl.*;
import org.clang.tooling.*;


/// \brief A trie to efficiently match against the entries of the compilation
/// database in order of matching suffix length.
///
/// When a clang tool is supposed to operate on a specific file, we have to
/// find the corresponding file in the compilation database. Although entries
/// in the compilation database are keyed by filename, a simple string match
/// is insufficient because of symlinks. Commonly, a project hierarchy looks
/// like this:
///   /<project-root>/src/<path>/<somefile>.cc      (used as input for the tool)
///   /<project-root>/build/<symlink-to-src>/<path>/<somefile>.cc (stored in DB)
///
/// Furthermore, there might be symlinks inside the source folder or inside the
/// database, so that the same source file is translated with different build
/// options.
///
/// For a given input file, the \c FileMatchTrie finds its entries in order
/// of matching suffix length. For each suffix length, there might be one or
/// more entries in the database. For each of those entries, it calls
/// \c llvm::sys::fs::equivalent() (injected as \c PathComparator). There might
/// be zero or more entries with the same matching suffix length that are
/// equivalent to the input file. Three cases are distinguished:
/// 0  equivalent files: Continue with the next suffix length.
/// 1  equivalent file:  Best match found, return it.
/// >1 equivalent files: Match is ambiguous, return error.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrie">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/FileMatchTrie.h", line = 57,
 FQN="clang::tooling::FileMatchTrie", NM="_ZN5clang7tooling13FileMatchTrieE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling13FileMatchTrieE")
//</editor-fold>
public class FileMatchTrie implements Destructors.ClassWithDestructor {
/*public:*/
  // end namespace clang
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrie::FileMatchTrie">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 164,
   FQN="clang::tooling::FileMatchTrie::FileMatchTrie", NM="_ZN5clang7tooling13FileMatchTrieC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling13FileMatchTrieC1Ev")
  //</editor-fold>
  public FileMatchTrie() {
    // : Root(new FileMatchTrieNode), Comparator(new DefaultPathComparator()) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Construct a new \c FileMatchTrie with the given \c PathComparator.
  ///
  /// The \c FileMatchTrie takes ownership of 'Comparator'. Used for testing.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrie::FileMatchTrie">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 167,
   FQN="clang::tooling::FileMatchTrie::FileMatchTrie", NM="_ZN5clang7tooling13FileMatchTrieC1EPNS0_14PathComparatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling13FileMatchTrieC1EPNS0_14PathComparatorE")
  //</editor-fold>
  public FileMatchTrie(PathComparator /*P*/ Comparator) {
    // : Root(new FileMatchTrieNode), Comparator(Comparator) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrie::~FileMatchTrie">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 170,
   FQN="clang::tooling::FileMatchTrie::~FileMatchTrie", NM="_ZN5clang7tooling13FileMatchTrieD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling13FileMatchTrieD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Insert a new absolute path. Relative paths are ignored.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrie::insert">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 174,
   FQN="clang::tooling::FileMatchTrie::insert", NM="_ZN5clang7tooling13FileMatchTrie6insertEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZN5clang7tooling13FileMatchTrie6insertEN4llvm9StringRefE")
  //</editor-fold>
  public void insert(StringRef NewPath) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Finds the corresponding file in this trie.
  ///
  /// Returns file name stored in this trie that is equivalent to 'FileName'
  /// according to 'Comparator', if it can be uniquely identified. If there
  /// are no matches an empty \c StringRef is returned. If there are ambigious
  /// matches, an empty \c StringRef is returned and a corresponding message
  /// written to 'Error'.
  //<editor-fold defaultstate="collapsed" desc="clang::tooling::FileMatchTrie::findEquivalent">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp", line = 178,
   FQN="clang::tooling::FileMatchTrie::findEquivalent", NM="_ZNK5clang7tooling13FileMatchTrie14findEquivalentEN4llvm9StringRefERNS2_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FileMatchTrie.cpp -nm=_ZNK5clang7tooling13FileMatchTrie14findEquivalentEN4llvm9StringRefERNS2_11raw_ostreamE")
  //</editor-fold>
  public StringRef findEquivalent(StringRef FileName, 
                final raw_ostream /*&*/ Error) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private FileMatchTrieNode /*P*/ Root;
  private std.unique_ptr<PathComparator> Comparator;
  
  @Override public String toString() {
    return "" + "Root=" + Root // NOI18N
              + ", Comparator=" + Comparator; // NOI18N
  }
}
