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
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.vfs.*;

import org.clang.basic.impl.OverlayFSDirIterImpl;


/// \brief A file system that allows overlaying one \p AbstractFileSystem on top
/// of another.
///
/// Consists of a stack of >=1 \p FileSystem objects, which are treated as being
/// one merged file system. When there is a directory that exists in more than
/// one file system, the \p OverlayFileSystem contains a directory containing
/// the union of their contents.  The attributes (permissions, etc.) of the
/// top-most (most recently added) directory are used.  When there is a file
/// that exists in more than one file system, the file in the top-most file
/// system overrides the other(s).
//<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 254,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 240,
 FQN="clang::vfs::OverlayFileSystem", NM="_ZN5clang3vfs17OverlayFileSystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystemE")
//</editor-fold>
public class OverlayFileSystem extends /*public*/ FileSystem implements Destructors.ClassWithDestructor {
  /*typedef SmallVector<IntrusiveRefCntPtr<FileSystem>, 1> FileSystemList*/
//  public final class FileSystemList extends SmallVector<IntrusiveRefCntPtr<FileSystem>/*, 1*/>{ };
  /// \brief The stack of file systems, implemented as a list in order of
  /// their addition.
  private SmallVector<IntrusiveRefCntPtr<? extends FileSystem>/*, 1*/> FSList;
/*public:*/
  
  //===-----------------------------------------------------------------------===/
  // OverlayFileSystem implementation
  //===-----------------------------------------------------------------------===/
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::OverlayFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 290,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 273,
   FQN="clang::vfs::OverlayFileSystem::OverlayFileSystem", NM="_ZN5clang3vfs17OverlayFileSystemC1EN4llvm18IntrusiveRefCntPtrINS0_10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystemC1EN4llvm18IntrusiveRefCntPtrINS0_10FileSystemEEE")
  //</editor-fold>
  public OverlayFileSystem(IntrusiveRefCntPtr<? extends FileSystem> BaseFS) {
    /* : FileSystem(), FSList()*/ 
    //START JInit
    super();
    this.FSList = new SmallVector<IntrusiveRefCntPtr<? extends FileSystem>/*, 1*/>(1, new IntrusiveRefCntPtr<>());
    //END JInit
    FSList.push_back_T$RR(std.move(BaseFS));
  }

  /// \brief Pushes a file system on top of the stack.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::pushOverlay">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 294,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 277,
   FQN="clang::vfs::OverlayFileSystem::pushOverlay", NM="_ZN5clang3vfs17OverlayFileSystem11pushOverlayEN4llvm18IntrusiveRefCntPtrINS0_10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystem11pushOverlayEN4llvm18IntrusiveRefCntPtrINS0_10FileSystemEEE")
  //</editor-fold>
  public void pushOverlay(IntrusiveRefCntPtr<? extends FileSystem> FS) {
    FSList.push_back(FS);
    // Synchronize added file systems by duplicating the working directory from
    // the first one in the list.
    FS.$arrow().setCurrentWorkingDirectory(new Twine(getCurrentWorkingDirectory().get()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 284,
   FQN="clang::vfs::OverlayFileSystem::status", NM="_ZN5clang3vfs17OverlayFileSystem6statusERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystem6statusERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<Status> status(/*const*/ Twine /*&*/ Path)/* override*/ {
    // FIXME: handle symlinks that cross file systems
    for (std.reverse_iterator<IntrusiveRefCntPtr<? extends FileSystem>> I = overlays_begin(), E = overlays_end(); $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      ErrorOr<Status> Status = (I.$star()).$arrow().status(Path);
      if (Status.$bool() || $noteq_error_code(Status.getError(), errc.no_such_file_or_directory.make_error_code())) {
        return Status;
      }
    }
    return new ErrorOr<Status>(errc.no_such_file_or_directory);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::openFileForRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 311,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 294,
   FQN="clang::vfs::OverlayFileSystem::openFileForRead", NM="_ZN5clang3vfs17OverlayFileSystem15openFileForReadERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystem15openFileForReadERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<File> > openFileForRead(/*const*/ Twine /*&*/ Path)/* override*/ {
    // FIXME: handle symlinks that cross file systems
    for (std.reverse_iterator<IntrusiveRefCntPtr<? extends FileSystem>> I = overlays_begin(), E = overlays_end(); $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      ErrorOr<std.unique_ptr<File>> Result = (I.$star()).$arrow().openFileForRead(Path);
      if (Result.$bool() || $noteq_error_code(Result.getError(), errc.no_such_file_or_directory.make_error_code())) {
        return new ErrorOr<std.unique_ptr<File> >(JD$Move.INSTANCE, Result);
      }
    }
    return new ErrorOr<std.unique_ptr<File> >(errc.no_such_file_or_directory.make_error_code());
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::dir_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 397,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 380,
   FQN="clang::vfs::OverlayFileSystem::dir_begin", NM="_ZN5clang3vfs17OverlayFileSystem9dir_beginERKN4llvm5TwineERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystem9dir_beginERKN4llvm5TwineERSt10error_code")
  //</editor-fold>
  @Override public directory_iterator dir_begin(/*const*/ Twine /*&*/ Dir, 
           std.error_code /*&*/ EC)/* override*/ {
    std_ptr.shared_ptr<OverlayFSDirIterImpl> shared_ptr = new shared_ptr<>(new OverlayFSDirIterImpl(Dir, this, EC));
    return new directory_iterator(shared_ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::getCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 322,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 305,
   FQN="clang::vfs::OverlayFileSystem::getCurrentWorkingDirectory", NM="_ZNK5clang3vfs17OverlayFileSystem26getCurrentWorkingDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs17OverlayFileSystem26getCurrentWorkingDirectoryEv")
  //</editor-fold>
  @Override public ErrorOr<std.string> getCurrentWorkingDirectory() /*const*//* override*/ {
    // All file systems are synchronized, just take the first working directory.
    return FSList.front().$arrow().getCurrentWorkingDirectory();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::setCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 327,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 310,
   FQN="clang::vfs::OverlayFileSystem::setCurrentWorkingDirectory", NM="_ZN5clang3vfs17OverlayFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE")
  //</editor-fold>
  @Override public std.error_code setCurrentWorkingDirectory(/*const*/ Twine /*&*/ Path)/* override*/ {
    for (IntrusiveRefCntPtr<? extends FileSystem> /*&*/ FS : FSList)  {
      {
        std.error_code EC = FS.$arrow().setCurrentWorkingDirectory(Path);
        if (EC.$bool()) {
          return EC;
        }
      }
    }
    return std.error_code.success();
  }

  
  /*typedef FileSystemList::reverse_iterator iterator*/
//  public final class iterator extends std.reverse_iterator<iterator>{ };
  
  /// \brief Get an iterator pointing to the most recently added file system.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::overlays_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 275,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 261,
   FQN="clang::vfs::OverlayFileSystem::overlays_begin", NM="_ZN5clang3vfs17OverlayFileSystem14overlays_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystem14overlays_beginEv")
  //</editor-fold>
  public std.reverse_iterator<IntrusiveRefCntPtr<? extends FileSystem>> overlays_begin() {
    return FSList.rbegin();
  }

  
  /// \brief Get an iterator pointing one-past the least recently added file
  /// system.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::overlays_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 279,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 265,
   FQN="clang::vfs::OverlayFileSystem::overlays_end", NM="_ZN5clang3vfs17OverlayFileSystem12overlays_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystem12overlays_endEv")
  //</editor-fold>
  public std.reverse_iterator<IntrusiveRefCntPtr<? extends FileSystem>> overlays_end() {
    return FSList.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::OverlayFileSystem::~OverlayFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 254,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 240,
   FQN="clang::vfs::OverlayFileSystem::~OverlayFileSystem", NM="_ZN5clang3vfs17OverlayFileSystemD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs17OverlayFileSystemD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    FSList.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "FSList=" + FSList // NOI18N
              + super.toString(); // NOI18N
  }
}
