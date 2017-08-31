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

package org.clang.basic.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import org.llvm.support.sys.fs;

/// \brief The file system according to your operating system.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFileSystem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 196,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 180,
 FQN="(anonymous namespace)::RealFileSystem", NM="_ZN12_GLOBAL__N_114RealFileSystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_114RealFileSystemE")
//</editor-fold>
public class RealFileSystem extends /*public*/ FileSystem implements Destructors.ClassWithDestructor {
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFileSystem::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 207,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 191,
   FQN="(anonymous namespace)::RealFileSystem::status", NM="_ZN12_GLOBAL__N_114RealFileSystem6statusERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_114RealFileSystem6statusERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<Status> status(/*const*/ Twine /*&*/ Path)/* override*/ {
    fs.file_status RealStatus/*J*/= new fs.file_status();
    {
      std.error_code EC = fs.status(Path, RealStatus);
      if (EC.$bool()) {
        return new ErrorOr<Status>(new std.error_code(EC));
      }
    }
    return new ErrorOr<Status>(JD$Convertible.INSTANCE, Status.copyWithNewName(RealStatus, new StringRef(Path.str())));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFileSystem::openFileForRead">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 198,
   FQN="(anonymous namespace)::RealFileSystem::openFileForRead", NM="_ZN12_GLOBAL__N_114RealFileSystem15openFileForReadERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_114RealFileSystem15openFileForReadERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<File> > openFileForRead(/*const*/ Twine /*&*/ Name)/* override*/ {
    int$ref FD = create_int$ref();
    SmallString/*256*/ RealName/*J*/= new SmallString/*256*/(256);
    {
      std.error_code EC = fs.openFileForRead(Name, FD, $AddrOf(RealName));
      if (EC.$bool()) {
        return new ErrorOr<std.unique_ptr<File> >(new std.error_code(EC));
      }
    }
    return new ErrorOr<std.unique_ptr<File> >(new std.unique_ptr<File>(new RealFile(FD.$deref(), new StringRef(Name.str()), RealName.str())));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFileSystem::dir_begin">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 282,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 265,
   FQN="(anonymous namespace)::RealFileSystem::dir_begin", NM="_ZN12_GLOBAL__N_114RealFileSystem9dir_beginERKN4llvm5TwineERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_114RealFileSystem9dir_beginERKN4llvm5TwineERSt10error_code")
  //</editor-fold>
  @Override public directory_iterator dir_begin(/*const*/ Twine /*&*/ Dir, 
           std.error_code /*&*/ EC)/* override*/ {
    return new directory_iterator(std.make_shared(new RealFSDirIter(Dir, EC)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFileSystem::getCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 223,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 206,
   FQN="(anonymous namespace)::RealFileSystem::getCurrentWorkingDirectory", NM="_ZNK12_GLOBAL__N_114RealFileSystem26getCurrentWorkingDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_114RealFileSystem26getCurrentWorkingDirectoryEv")
  //</editor-fold>
  @Override public ErrorOr<std.string> getCurrentWorkingDirectory() /*const*//* override*/ {
    SmallString/*256*/ Dir/*J*/= new SmallString/*256*/(256);
    {
      std.error_code EC = fs.current_path(Dir);
      if (EC.$bool()) {
        return new ErrorOr<std.string>(new std.error_code(EC));
      }
    }
    return new ErrorOr<std.string>(JD$Convertible.INSTANCE, Dir.str().str());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFileSystem::setCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 230,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 213,
   FQN="(anonymous namespace)::RealFileSystem::setCurrentWorkingDirectory", NM="_ZN12_GLOBAL__N_114RealFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_114RealFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE")
  //</editor-fold>
  @Override public std.error_code setCurrentWorkingDirectory(/*const*/ Twine /*&*/ Path)/* override*/ {
    // FIXME: chdir is thread hostile; on the other hand, creating the same
    // behavior as chdir is complex: chdir resolves the path once, thus
    // guaranteeing that all subsequent relative path operations work
    // on the same path the original chdir resulted in. This makes a
    // difference for example on network filesystems, where symlinks might be
    // switched during runtime of the tool. Fixing this depends on having a
    // file system abstraction that allows openat() style interactions.
    SmallString/*256*/ Storage/*J*/= new SmallString/*256*/(256);
    StringRef Dir = Path.toNullTerminatedStringRef(Storage);
    {
      int Err = /*::*/chdir(Dir.data());
      if ((Err != 0)) {
        return new std.error_code(Err, std.generic_category());
      }
    }
    return std.error_code.success();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFileSystem::~RealFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 196,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 180,
   FQN="(anonymous namespace)::RealFileSystem::~RealFileSystem", NM="_ZN12_GLOBAL__N_114RealFileSystemD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_114RealFileSystemD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RealFileSystem::RealFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 196,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 180,
   FQN="(anonymous namespace)::RealFileSystem::RealFileSystem", NM="_ZN12_GLOBAL__N_114RealFileSystemC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_114RealFileSystemC1Ev")
  //</editor-fold>
  public /*inline*/ RealFileSystem() {
    /* : FileSystem()*/ 
    //START JInit
    super();
    //END JInit
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
