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

package org.clang.basic.vfs.detail;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.basic.vfs.*;


/// \brief An interface for virtual file systems to provide an iterator over the
/// (non-recursive) contents of a directory.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::DirIterImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 112,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 104,
 FQN="clang::vfs::detail::DirIterImpl", NM="_ZN5clang3vfs6detail11DirIterImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail11DirIterImplE")
//</editor-fold>
public abstract class/*struct*/ DirIterImpl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::DirIterImpl::~DirIterImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 335,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 318,
   FQN="clang::vfs::detail::DirIterImpl::~DirIterImpl", NM="_ZN5clang3vfs6detail11DirIterImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail11DirIterImplD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    CurrentEntry.$destroy();
    //END JDestroy
  }

  /// \brief Sets \c CurrentEntry to the next entry in the directory on success,
  /// or returns a system-defined \c error_code.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::DirIterImpl::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 116,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 108,
   FQN="clang::vfs::detail::DirIterImpl::increment", NM="_ZN5clang3vfs6detail11DirIterImpl9incrementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail11DirIterImpl9incrementEv")
  //</editor-fold>
  public abstract /*virtual*/ std.error_code increment()/* = 0*/;

  public final Status CurrentEntry;
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::DirIterImpl::DirIterImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 112,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 104,
   FQN="clang::vfs::detail::DirIterImpl::DirIterImpl", NM="_ZN5clang3vfs6detail11DirIterImplC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail11DirIterImplC1Ev")
  //</editor-fold>
  public /*inline*/ DirIterImpl() {
    /* : CurrentEntry()*/ 
    //START JInit
    this.CurrentEntry = new Status();
    //END JInit
  }

  protected DirIterImpl(final DirIterImpl $Prm0) {
    this.CurrentEntry = new Status($Prm0.CurrentEntry);
  }
  
  protected abstract DirIterImpl clone();
  
  public String toString() {
    return "" + "CurrentEntry=" + CurrentEntry; // NOI18N
  }
}
