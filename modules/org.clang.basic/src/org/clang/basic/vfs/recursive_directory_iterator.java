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

package org.clang.basic.vfs;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.adt.*;



/// \brief An input iterator over the recursive contents of a virtual path,
/// similar to llvm::sys::fs::recursive_directory_iterator.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 163,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 154,
 FQN="clang::vfs::recursive_directory_iterator", NM="_ZN5clang3vfs28recursive_directory_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs28recursive_directory_iteratorE")
//</editor-fold>
public class recursive_directory_iterator implements Destructors.ClassWithDestructor, Native.NativeComparable<recursive_directory_iterator> {
  /*typedef std::stack<directory_iterator, std::vector<directory_iterator> > IterState*/
//  public final class IterState extends std.stack<directory_iterator>{ };
  
  private FileSystem /*P*/ FS;
  private std.shared_ptr<std.stack<directory_iterator>/*, std::vector<directory_iterator>*/> State; // Input iterator semantics on copy.
  
/*public:*/
  // Input iterator semantics on copy.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator::recursive_directory_iterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1785,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1544,
   FQN="clang::vfs::recursive_directory_iterator::recursive_directory_iterator", NM="_ZN5clang3vfs28recursive_directory_iteratorC1ERNS0_10FileSystemERKN4llvm5TwineERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs28recursive_directory_iteratorC1ERNS0_10FileSystemERKN4llvm5TwineERSt10error_code")
  //</editor-fold>
  public recursive_directory_iterator(FileSystem /*&*/ FS_, 
      /*const*/ Twine /*&*/ Path, 
      std.error_code /*&*/ EC) {
    /* : FS(&FS_), State()*/ 
    //START JInit
    this.FS = $AddrOf(FS_);
    this.State = new std.shared_ptr<>();
    //END JInit
    directory_iterator I = FS.dir_begin(Path, EC);
    if (!EC.$bool() && I.$noteq(new directory_iterator())) {
      State.$assign(new shared_ptr<std.stack<directory_iterator>>(new std.stack<directory_iterator>((null))));
      State.$arrow().push(new directory_iterator(I));
    }
  }
  /// \brief Construct an 'end' iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator::recursive_directory_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 174,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 165,
   FQN="clang::vfs::recursive_directory_iterator::recursive_directory_iterator", NM="_ZN5clang3vfs28recursive_directory_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang3vfs28recursive_directory_iteratorC1Ev")
  //</editor-fold>
  public recursive_directory_iterator() {
    /* : State()*/ 
    //START JInit
    this.State = new std.shared_ptr<std.stack<directory_iterator>>();
    //END JInit
  }

  
  /// \brief Equivalent to operator++, with an error code.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1796,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1555,
   FQN="clang::vfs::recursive_directory_iterator::increment", NM="_ZN5clang3vfs28recursive_directory_iterator9incrementERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs28recursive_directory_iterator9incrementERSt10error_code")
  //</editor-fold>
  public recursive_directory_iterator/*&*/ increment(std.error_code /*&*/ EC) {
    directory_iterator End = null;
    try {
      assert ((FS != null) && State.$bool() && !State.$arrow().empty()) : "incrementing past end";
      assert (State.$arrow().top().$arrow().isStatusKnown()) : "non-canonical end iterator";
      End/*J*/= new directory_iterator();
      if (State.$arrow().top().$arrow().isDirectory()) {
        directory_iterator I = FS.dir_begin(new /*const*/ Twine(State.$arrow().top().$arrow().getName()), EC);
        if (EC.$bool()) {
          return /*Deref*/this;
        }
        if (I.$noteq(End)) {
          State.$arrow().push(I);
          return /*Deref*/this;
        }
      }
      while (!State.$arrow().empty() && State.$arrow().top().increment(EC).$eq(End)) {
        State.$arrow().pop();
      }
      if (State.$arrow().empty()) {
        State.reset(); // end iterator
      }

      return /*Deref*/this;
    } finally {
      if (End != null) { End.$destroy(); }
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 170,
   FQN="clang::vfs::recursive_directory_iterator::operator*", NM="_ZNK5clang3vfs28recursive_directory_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZNK5clang3vfs28recursive_directory_iteratordeEv")
  //</editor-fold>
  public /*const*/ Status /*&*/ $star() /*const*/ {
    return State.$arrow().top().$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 180,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 171,
   FQN="clang::vfs::recursive_directory_iterator::operator->", NM="_ZNK5clang3vfs28recursive_directory_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZNK5clang3vfs28recursive_directory_iteratorptEv")
  //</editor-fold>
  public /*const*/ Status /*P*/ $arrow() /*const*/ {
    return $AddrOf(State.$arrow().top().$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 173,
   FQN="clang::vfs::recursive_directory_iterator::operator==", NM="_ZNK5clang3vfs28recursive_directory_iteratoreqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZNK5clang3vfs28recursive_directory_iteratoreqERKS1_")
  //</editor-fold>
  public boolean $eq(/*const*/recursive_directory_iterator/*&*/ Other) /*const*/ {
    return State.$not() && Other.State.$not() || (State.$arrow() == Other.State.$arrow()); // identity
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 176,
   FQN="clang::vfs::recursive_directory_iterator::operator!=", NM="_ZNK5clang3vfs28recursive_directory_iteratorneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZNK5clang3vfs28recursive_directory_iteratorneERKS1_")
  //</editor-fold>
  public boolean $noteq(/*const*/recursive_directory_iterator/*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  /// \brief Gets the current level. Starting path is at level 0.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::recursive_directory_iterator::level">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 189,
   FQN="clang::vfs::recursive_directory_iterator::level", NM="_ZNK5clang3vfs28recursive_directory_iterator5levelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs28recursive_directory_iterator5levelEv")
  //</editor-fold>
  public int level() /*const*/ {
    assert ((State.$arrow().size() != 0)) : "Cannot get level without any iteration state";
    return State.$arrow().size() - 1;
  }

  @Override
  public void $destroy() {
    if (State != null) { 
      State.$destroy();
    }
  }
  
  public String toString() {
    return "" + "FS=" + FS // NOI18N
              + ", State=" + State; // NOI18N
  }
}
