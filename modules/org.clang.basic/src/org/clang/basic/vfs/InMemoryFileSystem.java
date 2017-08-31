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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.io.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;
import static org.clang.basic.vfs.VfsGlobals.*;
import org.clang.basic.vfs.detail.*;
import org.clang.basic.vfs.detail.impl.*;
import org.clang.basic.vfs.impl.*;
import static org.clang.basic.vfs.impl.VfsStatics.*;
import org.llvm.support.sys.TimeValue;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;
import org.llvm.support.sys.path.const_iterator;

// end namespace detail

/// An in-memory file system.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 287,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 273,
 FQN="clang::vfs::InMemoryFileSystem", NM="_ZN5clang3vfs18InMemoryFileSystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystemE")
//</editor-fold>
public class InMemoryFileSystem extends /*public*/ FileSystem implements Destructors.ClassWithDestructor {
  private std.unique_ptr<InMemoryDirectory> Root;
  private std.string WorkingDirectory;
  private boolean UseNormalizedPaths/* = true*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::InMemoryFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 495,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 478,
   FQN="clang::vfs::InMemoryFileSystem::InMemoryFileSystem", NM="_ZN5clang3vfs18InMemoryFileSystemC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystemC1Eb")
  //</editor-fold>
  public InMemoryFileSystem() {
    this(true);
  }
  public InMemoryFileSystem(boolean UseNormalizedPaths/*= true*/) {
    /* : FileSystem(), Root(new InMemoryDirectory(Status("", getNextVirtualUniqueID(), TimeValue::MinTime(), 0, 0, 0, fs::file_type::directory_file, fs::perms::all_all))), WorkingDirectory(), UseNormalizedPaths(UseNormalizedPaths)*/ 
    //START JInit
    super();
    this.Root = new std.unique_ptr<InMemoryDirectory>(new InMemoryDirectory(new Status(new StringRef(/*KEEP_STR*/$EMPTY), getNextVirtualUniqueID(), TimeValue.MinTime(), 
                0, 0, 0, fs.file_type.directory_file, 
                fs.perms.all_all)));
    this.WorkingDirectory = new std.string();
    this.UseNormalizedPaths = UseNormalizedPaths;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::~InMemoryFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 502,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 485,
   FQN="clang::vfs::InMemoryFileSystem::~InMemoryFileSystem", NM="_ZN5clang3vfs18InMemoryFileSystemD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystemD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    WorkingDirectory.$destroy();
    Root.$destroy();
    super.$destroy();
    //END JDestroy
  }

  /// Add a buffer to the VFS with a path. The VFS owns the buffer.
  /// \return true if the file was successfully added, false if the file already
  /// exists in the file system with different contents.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::addFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 508,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 491,
   FQN="clang::vfs::InMemoryFileSystem::addFile", NM="_ZN5clang3vfs18InMemoryFileSystem7addFileERKN4llvm5TwineElSt10unique_ptrINS2_12MemoryBufferESt14default_deleteIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystem7addFileERKN4llvm5TwineElSt10unique_ptrINS2_12MemoryBufferESt14default_deleteIS7_EE")
  //</editor-fold>
  public boolean addFile(/*const*/ Twine /*&*/ P, long/*time_t*/ ModificationTime, 
         std.unique_ptr<MemoryBuffer> Buffer) {
    SmallString/*128*/ Path/*J*/= new SmallString/*128*/(128);
    P.toVector(Path);
    
    // Fix up relative paths. This just prepends the current working directory.
    std.error_code EC = makeAbsolute(Path);
    assert (!EC.$bool());
//    (void)EC;
    if (useNormalizedPaths()) {
      path.remove_dots(Path, /*remove_dot_dot=*/ true);
    }
    if (Path.empty()) {
      return false;
    }
    
    InMemoryDirectory /*P*/ Dir = Root.get();
    const_iterator I = path.begin(Path.$StringRef()), E = path.end(Path.$StringRef());
    while (true) {
      StringRef Name = new StringRef(I.$star());
      InMemoryNode /*P*/ Node = Dir.getChild(new StringRef(Name));
      I.$preInc();
      if (!(Node != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (I.$eq(E)) {
            // End of the path, create a new file.
            // FIXME: expose the status details in the interface.
            Status Stat/*J*/= new Status(new StringRef(P.str()), getNextVirtualUniqueID(), 
                new TimeValue(ModificationTime, 0), 0, 0, 
                $uint2ulong(Buffer.$arrow().getBufferSize()), 
                fs.file_type.regular_file, 
                fs.perms.all_all);
            $c$.clean(Dir.addChild(new StringRef(Name), $c$.track(new std.unique_ptr<InMemoryNode>($c$.track(llvm.make_unique(new InMemoryFile(std.move(Stat), std.move(Buffer))))))));
            return true;
          }
          
          // Create a new directory. Use the path up to here.
          // FIXME: expose the status details in the interface.
          Status Stat/*J*/= new Status(new StringRef(Path.str().begin(), Name.end().$sub(Path.str().begin())), 
              getNextVirtualUniqueID(), new TimeValue(ModificationTime, 0), 
              0, 0, $uint2ulong(Buffer.$arrow().getBufferSize()), 
              fs.file_type.directory_file, fs.perms.all_all);
          $c$.clean(Dir = cast(InMemoryDirectory.class, Dir.addChild(new StringRef(Name), $c$.track(new std.unique_ptr<InMemoryNode>($c$.track(llvm.make_unique(new InMemoryDirectory(std.move(Stat)))))))));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      {
        
        InMemoryDirectory /*P*/ NewDir = dyn_cast(InMemoryDirectory.class, Node);
        if ((NewDir != null)) {
          Dir = NewDir;
        } else {
          assert (isa(InMemoryFile.class, Node)) : "Must be either file or directory!";
          
          // Trying to insert a directory in place of a file.
          if (I.$noteq(E)) {
            return false;
          }
          
          // Return false only if the new file is different from the existing one.
          return $eq_StringRef(cast(InMemoryFile.class, Node).getBuffer().getBuffer(), 
              Buffer.$arrow().getBuffer());
        }
      }
    }
  }

  /// Add a buffer to the VFS with a path. The VFS does not own the buffer.
  /// \return true if the file was successfully added, false if the file already
  /// exists in the file system with different contents.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::addFileNoOwn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 573,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 556,
   FQN="clang::vfs::InMemoryFileSystem::addFileNoOwn", NM="_ZN5clang3vfs18InMemoryFileSystem12addFileNoOwnERKN4llvm5TwineElPNS2_12MemoryBufferE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystem12addFileNoOwnERKN4llvm5TwineElPNS2_12MemoryBufferE")
  //</editor-fold>
  public boolean addFileNoOwn(/*const*/ Twine /*&*/ P, long/*time_t*/ ModificationTime, 
              MemoryBuffer /*P*/ Buffer) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(addFile(P, ModificationTime, 
          $c$.track(MemoryBuffer.getMemBuffer(Buffer.getBuffer(), new StringRef(Buffer.getBufferIdentifier())))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 504,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 487,
   FQN="clang::vfs::InMemoryFileSystem::toString", NM="_ZNK5clang3vfs18InMemoryFileSystem8toStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs18InMemoryFileSystem8toStringEv")
  //</editor-fold>
  public std.string __toString() /*const*/ {
    return Root.$arrow().__toString(/*Indent=*/ 0);
  }

  /// Return true if this file system normalizes . and .. in paths.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::useNormalizedPaths">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 307,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 293,
   FQN="clang::vfs::InMemoryFileSystem::useNormalizedPaths", NM="_ZNK5clang3vfs18InMemoryFileSystem18useNormalizedPathsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs18InMemoryFileSystem18useNormalizedPathsEv")
  //</editor-fold>
  public boolean useNormalizedPaths() /*const*/ {
    return UseNormalizedPaths;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 618,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 601,
   FQN="clang::vfs::InMemoryFileSystem::status", NM="_ZN5clang3vfs18InMemoryFileSystem6statusERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystem6statusERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<Status> status(/*const*/ Twine /*&*/ Path)/* override*/ {
    ErrorOr<InMemoryNode /*P*/ > Node = lookupInMemoryNode(/*Deref*/this, Root.get(), Path);
    if (Node.$bool()) {
      return new ErrorOr<Status>(new Status((Node.$star()).getStatus()));
    }
    return new ErrorOr<Status>(Node.getError());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::openFileForRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 625,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 608,
   FQN="clang::vfs::InMemoryFileSystem::openFileForRead", NM="_ZN5clang3vfs18InMemoryFileSystem15openFileForReadERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystem15openFileForReadERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<File> > openFileForRead(/*const*/ Twine /*&*/ Path)/* override*/ {
    ErrorOr<InMemoryNode /*P*/ > Node = lookupInMemoryNode(/*Deref*/this, Root.get(), Path);
    if (!Node.$bool()) {
      return new ErrorOr<std.unique_ptr<File> >(Node.getError());
    }
    {
      
      // When we have a file provide a heap-allocated wrapper for the memory buffer
      // to match the ownership semantics for File.
      InMemoryFile /*P*/ F = dyn_cast(InMemoryFile.class, Node.$star());
      if ((F != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new ErrorOr<std.unique_ptr<File> >($c$.track(new std.unique_ptr<File>(new InMemoryFileAdaptor($Deref(F))))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // FIXME: errc::not_a_file?
    return new ErrorOr<std.unique_ptr<File> >(make_error_code(errc.invalid_argument));
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::dir_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 664,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 647,
   FQN="clang::vfs::InMemoryFileSystem::dir_begin", NM="_ZN5clang3vfs18InMemoryFileSystem9dir_beginERKN4llvm5TwineERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystem9dir_beginERKN4llvm5TwineERSt10error_code")
  //</editor-fold>
  @Override public directory_iterator dir_begin(/*const*/ Twine /*&*/ Dir, 
           std.error_code /*&*/ EC)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ErrorOr<InMemoryNode /*P*/ > Node = lookupInMemoryNode(/*Deref*/this, Root.get(), Dir);
      if (!Node.$bool()) {
        EC.$assignMove(Node.getError());
        return $c$.clean(new directory_iterator(std.make_shared(new InMemoryDirIterator())));
      }
      {
        
        InMemoryDirectory /*P*/ DirNode = dyn_cast(InMemoryDirectory.class, Node.$star());
        if ((DirNode != null)) {
          return $c$.clean(new directory_iterator(std.make_shared(new InMemoryDirIterator($Deref(DirNode)))));
        }
      }
      
      EC.$assignMove(make_error_code(errc.not_a_directory));
      return $c$.clean(new directory_iterator($c$.track(new std.shared_ptr<DirIterImpl>($c$.track(std.make_shared(new InMemoryDirIterator()))))));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::getCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 313,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 299,
   FQN="clang::vfs::InMemoryFileSystem::getCurrentWorkingDirectory", NM="_ZNK5clang3vfs18InMemoryFileSystem26getCurrentWorkingDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs18InMemoryFileSystem26getCurrentWorkingDirectoryEv")
  //</editor-fold>
  @Override public ErrorOr<std.string> getCurrentWorkingDirectory() /*const*//* override*/ {
    return new ErrorOr<std.string>(new std.string(WorkingDirectory));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::InMemoryFileSystem::setCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 679,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 662,
   FQN="clang::vfs::InMemoryFileSystem::setCurrentWorkingDirectory", NM="_ZN5clang3vfs18InMemoryFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18InMemoryFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE")
  //</editor-fold>
  @Override public std.error_code setCurrentWorkingDirectory(/*const*/ Twine /*&*/ P)/* override*/ {
    SmallString/*128*/ Path/*J*/= new SmallString/*128*/(128);
    P.toVector(Path);
    
    // Fix up relative paths. This just prepends the current working directory.
    std.error_code EC = makeAbsolute(Path);
    assert (!EC.$bool());
//    (void)EC;
    if (useNormalizedPaths()) {
      path.remove_dots(Path, /*remove_dot_dot=*/ true);
    }
    if (!Path.empty()) {
      WorkingDirectory.$assignMove(Path.str().$string());
    }
    return new std.error_code();
  }
  
  public String toString() {
    return "" + "Root=" + Root // NOI18N
              + ", WorkingDirectory=" + WorkingDirectory // NOI18N
              + ", UseNormalizedPaths=" + UseNormalizedPaths // NOI18N
              + super.toString(); // NOI18N
  }
}
