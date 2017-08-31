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

package org.clang.basic.vfs.detail.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;


/// Adapt a InMemoryFile for VFS' File interface.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 442,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 425,
 FQN="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor", NM="_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptorE")
//</editor-fold>
public class InMemoryFileAdaptor extends /*public*/ File implements Destructors.ClassWithDestructor {
  private InMemoryFile /*&*/ Node;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::InMemoryFileAdaptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 446,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 429,
   FQN="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::InMemoryFileAdaptor", NM="_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptorC1ERNS2_12InMemoryFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptorC1ERNS2_12InMemoryFileE")
  //</editor-fold>
  public /*explicit*/ InMemoryFileAdaptor(InMemoryFile /*&*/ Node) {
    /* : File(), Node(Node)*/ 
    //START JInit
    super();
    this./*&*/Node=/*&*/Node;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 448,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 431,
   FQN="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::status", NM="_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptor6statusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptor6statusEv")
  //</editor-fold>
  @Override public ErrorOr<Status> status()/* override*/ {
    return new ErrorOr<Status>(new Status(Node.getStatus()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::getBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 449,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 432,
   FQN="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::getBuffer", NM="_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptor9getBufferERKN4llvm5TwineExbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptor9getBufferERKN4llvm5TwineExbb")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<MemoryBuffer> > getBuffer(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize, boolean RequiresNullTerminator, 
           boolean IsVolatile)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      MemoryBuffer /*P*/ Buf = Node.getBuffer();
      return $c$.clean(new ErrorOr<std.unique_ptr<MemoryBuffer> >($c$.track(MemoryBuffer.getMemBuffer(Buf.getBuffer(), new StringRef(Buf.getBufferIdentifier()), RequiresNullTerminator))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::close">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 456,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 439,
   FQN="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::close", NM="_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptor5closeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptor5closeEv")
  //</editor-fold>
  @Override public std.error_code close()/* override*/ {
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::~InMemoryFileAdaptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 442,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 425,
   FQN="clang::vfs::detail::(anonymous namespace)::InMemoryFileAdaptor::~InMemoryFileAdaptor", NM="_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail12_GLOBAL__N_119InMemoryFileAdaptorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "Node=" + Node // NOI18N
              + super.toString(); // NOI18N
  }
}
