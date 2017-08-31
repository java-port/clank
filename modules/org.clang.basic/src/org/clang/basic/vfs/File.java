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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;


/// \brief Represents an open file.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::File">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 86,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 85,
 FQN="clang::vfs::File", NM="_ZN5clang3vfs4FileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs4FileE")
//</editor-fold>
public abstract class File implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Destroy the file after closing it (if open).
  /// Sub-classes should generally call close() inside their destructors.  We
  /// cannot do that from the base class, since close is virtual.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::File::~File">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 90,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 87,
   FQN="clang::vfs::File::~File", NM="_ZN5clang3vfs4FileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs4FileD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  /// \brief Get the status of the file.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::File::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 93,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 92,
   FQN="clang::vfs::File::status", NM="_ZN5clang3vfs4File6statusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs4File6statusEv")
  //</editor-fold>
  public abstract /*virtual*/ ErrorOr<Status> status()/* = 0*/;

  /// \brief Get the name of the file
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::File::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 95,
   FQN="clang::vfs::File::getName", NM="_ZN5clang3vfs4File7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs4File7getNameEv")
  //</editor-fold>
  public /*virtual*/ ErrorOr<std.string> getName() {
    {
      ErrorOr<Status> Status = status();
      if (Status.$bool()) {
        return new ErrorOr<std.string>(JD$Convertible.INSTANCE, Status.$arrow().getName().str());
      } else {
        return new ErrorOr<std.string>(Status.getError());
      }
    }
  }
  
  /// \brief Get the contents of the file as a \p MemoryBuffer.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::File::getBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 102,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 94,
   FQN="clang::vfs::File::getBuffer", NM="_ZN5clang3vfs4File9getBufferERKN4llvm5TwineExbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs4File9getBufferERKN4llvm5TwineExbb")
  //</editor-fold>
  public final ErrorOr<std.unique_ptr<MemoryBuffer> > getBuffer(/*const*/ Twine /*&*/ Name) {
    return getBuffer(Name, -1L, true, false);
  }
  public final ErrorOr<std.unique_ptr<MemoryBuffer> > getBuffer(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize/*= -1*/) {
    return getBuffer(Name, FileSize, true, false);
  }
  public final ErrorOr<std.unique_ptr<MemoryBuffer> > getBuffer(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize/*= -1*/, 
           boolean RequiresNullTerminator/*= true*/) {
    return getBuffer(Name, FileSize, RequiresNullTerminator, false);
  }
  public abstract /*virtual*/ ErrorOr<std.unique_ptr<MemoryBuffer> > getBuffer(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize/*= -1*/, 
           boolean RequiresNullTerminator/*= true*/, boolean IsVolatile/*= false*/)/* = 0*/;

  /// \brief Closes the file.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::File::close">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 106,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 98,
   FQN="clang::vfs::File::close", NM="_ZN5clang3vfs4File5closeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs4File5closeEv")
  //</editor-fold>
  public abstract /*virtual*/ std.error_code close()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::File::File">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 86,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 85,
   FQN="clang::vfs::File::File", NM="_ZN5clang3vfs4FileC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs4FileC1Ev")
  //</editor-fold>
  public /*inline*/ File() {
  }

  
  public String toString() {
    return ""; // NOI18N
  }
}
