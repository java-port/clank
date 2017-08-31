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
import static org.clank.java.std.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.ErrorOr;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;


/// \brief The virtual file system interface.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 196,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 182,
 FQN="clang::vfs::FileSystem", NM="_ZN5clang3vfs10FileSystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystemE")
//</editor-fold>
public abstract class FileSystem extends /*public*/ ThreadSafeRefCountedBase<FileSystem> implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::~FileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 92,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 89,
   FQN="clang::vfs::FileSystem::~FileSystem", NM="_ZN5clang3vfs10FileSystemD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystemD0Ev")
  //</editor-fold>
  public void $destroy() {
    super.$destroy();
  }

  
  /// \brief Get the status of the entry at \p Path, if one exists.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 201,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 187,
   FQN="clang::vfs::FileSystem::status", NM="_ZN5clang3vfs10FileSystem6statusERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystem6statusERKN4llvm5TwineE")
  //</editor-fold>
  public abstract /*virtual*/ ErrorOr<Status> status(/*const*/ Twine /*&*/ Path)/* = 0*/;

  /// \brief Get a \p File object for the file at \p Path, if one exists.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::openFileForRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 203,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 189,
   FQN="clang::vfs::FileSystem::openFileForRead", NM="_ZN5clang3vfs10FileSystem15openFileForReadERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystem15openFileForReadERKN4llvm5TwineE")
  //</editor-fold>
  public abstract /*virtual*/ ErrorOr<std.unique_ptr<File> > openFileForRead(/*const*/ Twine /*&*/ Path)/* = 0*/;

  
  /// This is a convenience method that opens a file, gets its content and then
  /// closes the file.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::getBufferForFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 94,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 91,
   FQN="clang::vfs::FileSystem::getBufferForFile", NM="_ZN5clang3vfs10FileSystem16getBufferForFileERKN4llvm5TwineExbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystem16getBufferForFileERKN4llvm5TwineExbb")
  //</editor-fold>
  public final ErrorOr<std.unique_ptr<MemoryBuffer> > getBufferForFile(/*const*/ Twine /*&*/ Name) {
    return getBufferForFile(Name, -1, 
                  true, false);
  }
  public final ErrorOr<std.unique_ptr<MemoryBuffer> > getBufferForFile(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize/*= -1*/) {
    return getBufferForFile(Name, FileSize, 
                  true, false);
  }
  public final ErrorOr<std.unique_ptr<MemoryBuffer> > getBufferForFile(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize/*= -1*/, 
                  boolean RequiresNullTerminator/*= true*/) {
    return getBufferForFile(Name, FileSize, 
                  RequiresNullTerminator, false);
  }
  public ErrorOr<std.unique_ptr<MemoryBuffer> > getBufferForFile(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize/*= -1*/, 
                  boolean RequiresNullTerminator/*= true*/, boolean IsVolatile/*= false*/) {
    ErrorOr<unique_ptr<File> > F = null;
    try {
      F = openFileForRead(Name);
      if (!F.$bool()) {
        return new ErrorOr<std.unique_ptr<MemoryBuffer> >(F.getError());
      }
      
      return (F.$star()).$arrow().getBuffer(Name, FileSize, RequiresNullTerminator, IsVolatile);
    } finally {
      if (F != null) { F.$destroy(); }
    }
  }

  
  /// \brief Get a directory_iterator for \p Dir.
  /// \note The 'end' iterator is directory_iterator().
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::dir_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 200,
   FQN="clang::vfs::FileSystem::dir_begin", NM="_ZN5clang3vfs10FileSystem9dir_beginERKN4llvm5TwineERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystem9dir_beginERKN4llvm5TwineERSt10error_code")
  //</editor-fold>
  public abstract /*virtual*/ directory_iterator dir_begin(/*const*/ Twine /*&*/ Dir, 
           std.error_code /*&*/ EC)/* = 0*/;

  
  /// Set the working directory. This will affect all following operations on
  /// this file system and may propagate down for nested file systems.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::setCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 219,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 205,
   FQN="clang::vfs::FileSystem::setCurrentWorkingDirectory", NM="_ZN5clang3vfs10FileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE")
  //</editor-fold>
  public abstract /*virtual*/ std.error_code setCurrentWorkingDirectory(/*const*/ Twine /*&*/ Path)/* = 0*/;

  /// Get the working directory of this file system.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::getCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 221,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 207,
   FQN="clang::vfs::FileSystem::getCurrentWorkingDirectory", NM="_ZNK5clang3vfs10FileSystem26getCurrentWorkingDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs10FileSystem26getCurrentWorkingDirectoryEv")
  //</editor-fold>
  public abstract /*virtual*/ ErrorOr<std.string> getCurrentWorkingDirectory() /*const*//* = 0*/;

  
  /// Check whether a file exists. Provided for convenience.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::exists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 109,
   FQN="clang::vfs::FileSystem::exists", NM="_ZN5clang3vfs10FileSystem6existsERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystem6existsERKN4llvm5TwineE")
  //</editor-fold>
  public boolean exists(/*const*/ Twine /*&*/ Path) {
    ErrorOr<Status> Status = status(Path);
    return Status.$bool() && Status.$arrow().exists();
  }

  
  /// Make \a Path an absolute path.
  ///
  /// Makes \a Path absolute using the current directory if it is not already.
  /// An empty \a Path will result in the current directory.
  ///
  /// /absolute/path   => /absolute/path
  /// relative/../path => <current-directory>/relative/../path
  ///
  /// \param Path A path that is modified to be an absolute path.
  /// \returns success if \a path has been made absolute, otherwise a
  ///          platform-specific error_code.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::makeAbsolute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 104,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 101,
   FQN="clang::vfs::FileSystem::makeAbsolute", NM="_ZNK5clang3vfs10FileSystem12makeAbsoluteERN4llvm15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs10FileSystem12makeAbsoluteERN4llvm15SmallVectorImplIcEE")
  //</editor-fold>
  public std.error_code makeAbsolute(SmallString/*&*/ Path) /*const*/ {
    if (path.is_absolute(new Twine(Path))) {
      return std.error_code.success();
    }
  
    ErrorOr<std.string> WorkingDir = getCurrentWorkingDirectory();
    if (!WorkingDir.$bool()) {
      return WorkingDir.getError();
    }
    
    return fs.make_absolute(new Twine(WorkingDir.get()), Path);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::FileSystem::FileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 196,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 182,
   FQN="clang::vfs::FileSystem::FileSystem", NM="_ZN5clang3vfs10FileSystemC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs10FileSystemC1Ev")
  //</editor-fold>
  public /*inline*/ FileSystem() {
    /* : ThreadSafeRefCountedBase<FileSystem>()*/ 
    //START JInit
    super();
    //END JInit
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
