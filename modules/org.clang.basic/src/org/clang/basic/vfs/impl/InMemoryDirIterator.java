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

package org.clang.basic.vfs.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.clang.basic.vfs.*;
import org.clang.basic.vfs.detail.*;
import org.clang.basic.vfs.detail.impl.*;

/// Adaptor from InMemoryDir::iterator to directory_iterator.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::(anonymous namespace)::InMemoryDirIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 642,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 625,
 FQN="clang::vfs::(anonymous namespace)::InMemoryDirIterator", NM="_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIteratorE")
//</editor-fold>
public class InMemoryDirIterator extends /*public*/ DirIterImpl implements Destructors.ClassWithDestructor, NativeCloneable<InMemoryDirIterator> {
  private final std.mapTypeType.iterator</*const*/std.string, unique_ptr<InMemoryNode>> I;
  private final std.mapTypeType.iterator</*const*/std.string, unique_ptr<InMemoryNode>> E;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::(anonymous namespace)::InMemoryDirIterator::InMemoryDirIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 647,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 630,
   FQN="clang::vfs::(anonymous namespace)::InMemoryDirIterator::InMemoryDirIterator", NM="_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIteratorC1Ev")
  //</editor-fold>
  public InMemoryDirIterator() {
    /* : DirIterImpl(), I(), E()*/ 
    //START JInit
    super();
    this.I = null;
    this.E = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::(anonymous namespace)::InMemoryDirIterator::InMemoryDirIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 648,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 631,
   FQN="clang::vfs::(anonymous namespace)::InMemoryDirIterator::InMemoryDirIterator", NM="_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIteratorC1ERNS0_6detail17InMemoryDirectoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIteratorC1ERNS0_6detail17InMemoryDirectoryE")
  //</editor-fold>
  public /*explicit*/ InMemoryDirIterator(InMemoryDirectory /*&*/ Dir) {
    /* : DirIterImpl(), I(Dir.begin()), E(Dir.end())*/ 
    //START JInit
    super();
    this.I = $tryClone(Dir.begin());
    this.E = $tryClone(Dir.end());
    //END JInit
    if (I.$noteq(E)) {
      CurrentEntry.$assign(I.$arrow().second.$arrow().getStatus());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::(anonymous namespace)::InMemoryDirIterator::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 654,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 637,
   FQN="clang::vfs::(anonymous namespace)::InMemoryDirIterator::increment", NM="_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIterator9incrementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIterator9incrementEv")
  //</editor-fold>
  @Override public std.error_code increment()/* override*/ {
    I.$preInc();
    // When we're at the end, make CurrentEntry invalid and DirIterImpl will do
    // the rest.
    CurrentEntry.$assign(I.$noteq(E) ? new Status(I.$arrow().second.$arrow().getStatus()) : new Status());
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::(anonymous namespace)::InMemoryDirIterator::~InMemoryDirIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 642,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 625,
   FQN="clang::vfs::(anonymous namespace)::InMemoryDirIterator::~InMemoryDirIterator", NM="_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIteratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs12_GLOBAL__N_119InMemoryDirIteratorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  private InMemoryDirIterator(InMemoryDirIterator $Prm0) {
    super($Prm0);
    this.E = $Prm0.E;
    this.I = $tryClone($Prm0.I);
  }

  @Override public InMemoryDirIterator clone() { return new InMemoryDirIterator(this); }
    
  public String toString() {
    return "" + "I=" + I // NOI18N
              + ", E=" + E // NOI18N
              + super.toString(); // NOI18N
  }
}
