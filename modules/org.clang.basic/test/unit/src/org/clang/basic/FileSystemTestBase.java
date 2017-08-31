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

package org.clang.basic;

import org.clang.basic.vfs.*;
import org.clang.basic.vfs.directory_iterator;
import org.clang.basic.vfs.recursive_directory_iterator;
import org.clank.java.*;
import org.clank.java.std_errors.errc;
import org.llvm.adt.*;
import org.clank.support.*;
import org.clank.support.Destructors;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.sys.*;
import static org.llvm.support.sys.fs.*;

/**
 * extracted common part:
 * corresponds to $LLVM_SRC/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp
 * 
 * @author Vladimir Voskresensky
 */
public abstract class FileSystemTestBase extends ADTSupportTestBase {
  protected FileSystemTestBase(TestState runTestsWithSpecifiedState) {
    super(runTestsWithSpecifiedState);
  }
  
//JAVA: using namespace clang
//JAVA: using namespace llvm
//JAVA: using llvm::sys::fs::UniqueID
//JAVA: UsingShadow UniqueID
//JAVA: namespace (anonymous) {
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 25,
 FQN="(anonymous namespace)::DummyFile", NM="_ZN12_GLOBAL__N_19DummyFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19DummyFileE")
//</editor-fold>
public static class/*struct*/ DummyFile extends /*public*/ File implements Destructors.ClassWithDestructor {
  public Status S;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFile::DummyFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 27,
   FQN="(anonymous namespace)::DummyFile::DummyFile", NM="_ZN12_GLOBAL__N_19DummyFileC1EN5clang3vfs6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19DummyFileC1EN5clang3vfs6StatusE")
  //</editor-fold>
  public /*explicit*/ DummyFile(Status S) {
    /* : File(), S(S)*/ 
    //START JInit
    super();
    this.S = new Status(S);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFile::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 28,
   FQN="(anonymous namespace)::DummyFile::status", NM="_ZN12_GLOBAL__N_19DummyFile6statusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19DummyFile6statusEv")
  //</editor-fold>
  @Override public ErrorOr<Status> status()/* override*/ {
    return new ErrorOr<Status>(JD$Convertible.INSTANCE, S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFile::getBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 29,
   FQN="(anonymous namespace)::DummyFile::getBuffer", NM="_ZN12_GLOBAL__N_19DummyFile9getBufferERKN4llvm5TwineExbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19DummyFile9getBufferERKN4llvm5TwineExbb")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<MemoryBuffer> > getBuffer(/*const*/ Twine /*&*/ Name, long/*int64_t*/ FileSize, boolean RequiresNullTerminator, 
           boolean IsVolatile)/* override*/ {
    throw new llvm_unreachable("unimplemented");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFile::close">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 34,
   FQN="(anonymous namespace)::DummyFile::close", NM="_ZN12_GLOBAL__N_19DummyFile5closeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19DummyFile5closeEv")
  //</editor-fold>
  @Override public std.error_code close()/* override*/ {
    return new std.error_code();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFile::~DummyFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 25,
   FQN="(anonymous namespace)::DummyFile::~DummyFile", NM="_ZN12_GLOBAL__N_19DummyFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19DummyFileD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    S.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "S=" + S // NOI18N
              + super.toString(); // NOI18N
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 37,
 FQN="(anonymous namespace)::DummyFileSystem", NM="_ZN12_GLOBAL__N_115DummyFileSystemE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystemE")
//</editor-fold>
public static class DummyFileSystem extends /*public*/ FileSystem implements Destructors.ClassWithDestructor {
  private int FSID; // used to produce UniqueIDs
  private int FileID; // used to produce UniqueIDs
  private std.mapTypeType<std.string, Status> FilesAndDirs;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::getNextFSID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 42,
   FQN="(anonymous namespace)::DummyFileSystem::getNextFSID", NM="_ZN12_GLOBAL__N_115DummyFileSystem11getNextFSIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem11getNextFSIDEv")
  //</editor-fold>
  private static int getNextFSID() {
    return getNextFSID$$.Count++;
  }
  private static final class getNextFSID$$ {
    static /*static*/ int Count = 0;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::DummyFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 48,
   FQN="(anonymous namespace)::DummyFileSystem::DummyFileSystem", NM="_ZN12_GLOBAL__N_115DummyFileSystemC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystemC1Ev")
  //</editor-fold>
  public DummyFileSystem() {
    /* : FileSystem(), FSID(getNextFSID()), FileID(0), FilesAndDirs()*/ 
    //START JInit
    super();
    this.FSID = getNextFSID();
    this.FileID = 0;
    this.FilesAndDirs = new std.mapTypeType<std.string, Status>(new Status());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::status">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 50,
   FQN="(anonymous namespace)::DummyFileSystem::status", NM="_ZN12_GLOBAL__N_115DummyFileSystem6statusERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem6statusERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<Status> status(/*const*/ Twine /*&*/ Path)/* override*/ {
    std.mapTypeType.iterator</*const*/std.string, Status> I = FilesAndDirs.find(Path.str());
    if (I.$eq(FilesAndDirs.end())) {
      return new ErrorOr<Status>(make_error_code(errc.no_such_file_or_directory));
    }
    return new ErrorOr<Status>(JD$Convertible.INSTANCE, I.$arrow().second);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::openFileForRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 57,
   FQN="(anonymous namespace)::DummyFileSystem::openFileForRead", NM="_ZN12_GLOBAL__N_115DummyFileSystem15openFileForReadERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem15openFileForReadERKN4llvm5TwineE")
  //</editor-fold>
  @Override public ErrorOr<std.unique_ptr<File> > openFileForRead(/*const*/ Twine /*&*/ Path)/* override*/ {
    ErrorOr<Status> S = status(Path);
    if (S.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ErrorOr<std.unique_ptr<File> >(JD$Convertible.INSTANCE, $c$.track(new std.unique_ptr<File>(/*{ */new DummyFile(new Status(S.$star()))/* }*/))));
      } finally {
        $c$.$destroy();
      }
    }
    return new ErrorOr<std.unique_ptr<File> >(S.getError());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::getCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 64,
   FQN="(anonymous namespace)::DummyFileSystem::getCurrentWorkingDirectory", NM="_ZNK12_GLOBAL__N_115DummyFileSystem26getCurrentWorkingDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZNK12_GLOBAL__N_115DummyFileSystem26getCurrentWorkingDirectoryEv")
  //</editor-fold>
  @Override public ErrorOr<std.string> getCurrentWorkingDirectory() /*const*//* override*/ {
    return new ErrorOr<std.string>(JD$Convertible.INSTANCE, new std.string());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::setCurrentWorkingDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 67,
   FQN="(anonymous namespace)::DummyFileSystem::setCurrentWorkingDirectory", NM="_ZN12_GLOBAL__N_115DummyFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem26setCurrentWorkingDirectoryERKN4llvm5TwineE")
  //</editor-fold>
  @Override public std.error_code setCurrentWorkingDirectory(/*const*/ Twine /*&*/ Path)/* override*/ {
    return new std.error_code();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::DirIterImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 71,
   FQN="(anonymous namespace)::DummyFileSystem::DirIterImpl", NM="_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImplE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImplE")
  //</editor-fold>
  public static class/*struct*/ DirIterImpl extends /*public*/ org.clang.basic.vfs.detail.DirIterImpl implements Destructors.ClassWithDestructor, NativeCloneable<DirIterImpl> {
    public final std.mapTypeType<std.string, Status>/*&*/ FilesAndDirs;
    public final std.mapTypeType.iterator</*const*/std.string, Status> I;
    public final std.string Path;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::DirIterImpl::isInPath">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 75,
     FQN="(anonymous namespace)::DummyFileSystem::DirIterImpl::isInPath", NM="_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImpl8isInPathEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImpl8isInPathEN4llvm9StringRefE")
    //</editor-fold>
    public boolean isInPath(StringRef S) {
      if ($less_uint(Path.size(), S.size()) && S.find(new StringRef(Path)) == 0) {
        /*uint*/int LastSep = S.find_last_of($$SLASH);
        if (LastSep == Path.size() || LastSep == Path.size() - 1) {
          return true;
        }
      }
      return false;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::DirIterImpl::DirIterImpl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 83,
     FQN="(anonymous namespace)::DummyFileSystem::DirIterImpl::DirIterImpl", NM="_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImplC1ERSt3mapISsN5clang3vfs6StatusESt4lessISsESaISt4pairIKSsS5_EEERKN4llvm5TwineE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImplC1ERSt3mapISsN5clang3vfs6StatusESt4lessISsESaISt4pairIKSsS5_EEERKN4llvm5TwineE")
    //</editor-fold>
    public DirIterImpl(std.mapTypeType<std.string, Status>/*&*/ FilesAndDirs, 
        /*const*/ Twine /*&*/ _Path) {
      /* : DirIterImpl(), FilesAndDirs(FilesAndDirs), I(FilesAndDirs.begin()), Path(_Path.str())*/ 
      //START JInit
      super();
      this./*&*/FilesAndDirs=/*&*/FilesAndDirs;
      this.I = FilesAndDirs.begin();
      this.Path = _Path.str();
      //END JInit
      for (; I.$noteq(FilesAndDirs.end()); I.$preInc()) {
        if (isInPath(new StringRef(I.$arrow().first))) {
          CurrentEntry.$assign(I.$arrow().second);
          break;
        }
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::DirIterImpl::increment">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 94,
     FQN="(anonymous namespace)::DummyFileSystem::DirIterImpl::increment", NM="_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImpl9incrementEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImpl9incrementEv")
    //</editor-fold>
    @Override public std.error_code increment()/* override*/ {
      I.$preInc();
      for (; I.$noteq(FilesAndDirs.end()); I.$preInc()) {
        if (isInPath(new StringRef(I.$arrow().first))) {
          CurrentEntry.$assign(I.$arrow().second);
          break;
        }
      }
      if (I.$eq(FilesAndDirs.end())) {
        CurrentEntry.$assignMove(new Status());
      }
      return new std.error_code();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::DirIterImpl::~DirIterImpl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 71,
     FQN="(anonymous namespace)::DummyFileSystem::DirIterImpl::~DirIterImpl", NM="_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImplD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem11DirIterImplD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      Path.$destroy();
      super.$destroy();
      //END JDestroy
    }

    private DirIterImpl(DirIterImpl $Prm0) {
      super($Prm0);
      this.FilesAndDirs = $Prm0.FilesAndDirs;
      this.I = $tryClone($Prm0.I);
      this.Path = $Prm0.Path;
    }
    
    @Override public DirIterImpl clone() { return new DirIterImpl(this); }
    
    public String toString() {
      return "" + "FilesAndDirs=" + FilesAndDirs // NOI18N
                + ", I=" + I // NOI18N
                + ", Path=" + Path // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::dir_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 108,
   FQN="(anonymous namespace)::DummyFileSystem::dir_begin", NM="_ZN12_GLOBAL__N_115DummyFileSystem9dir_beginERKN4llvm5TwineERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem9dir_beginERKN4llvm5TwineERSt10error_code")
  //</editor-fold>
  @Override public directory_iterator dir_begin(/*const*/ Twine /*&*/ Dir, 
           std.error_code /*&*/ EC)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new directory_iterator($c$.track(new std.shared_ptr<DirIterImpl>($c$.track(std.make_shared(new DirIterImpl(FilesAndDirs, Dir)))))));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::addEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 114,
   FQN="(anonymous namespace)::DummyFileSystem::addEntry", NM="_ZN12_GLOBAL__N_115DummyFileSystem8addEntryEN4llvm9StringRefERKN5clang3vfs6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem8addEntryEN4llvm9StringRefERKN5clang3vfs6StatusE")
  //</editor-fold>
  public void addEntry(StringRef Path, /*const*/ Status /*&*/ Status) {
    FilesAndDirs.$at(Path.$string()).$assign(Status);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::addRegularFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 118,
   FQN="(anonymous namespace)::DummyFileSystem::addRegularFile", NM="_ZN12_GLOBAL__N_115DummyFileSystem14addRegularFileEN4llvm9StringRefENS1_3sys2fs5permsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem14addRegularFileEN4llvm9StringRefENS1_3sys2fs5permsE")
  //</editor-fold>
  public void addRegularFile(StringRef Path) {
    addRegularFile(Path, fs.perms.all_all);
  }
  public void addRegularFile(StringRef Path, /*fs.perms*/int Perms/*= fs::all_all*/) {
    Status S/*J*/= new Status(/*NO_COPY*/Path, new UniqueID($int2ulong(FSID), $int2ulong(FileID++)), TimeValue.now(), 0, 0, 
        1024, fs.file_type.regular_file, Perms);
    addEntry(new StringRef(Path), S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::addDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 124,
   FQN="(anonymous namespace)::DummyFileSystem::addDirectory", NM="_ZN12_GLOBAL__N_115DummyFileSystem12addDirectoryEN4llvm9StringRefENS1_3sys2fs5permsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem12addDirectoryEN4llvm9StringRefENS1_3sys2fs5permsE")
  //</editor-fold>
  public void addDirectory(StringRef Path) {
    addDirectory(Path, fs.perms.all_all);
  }
  public void addDirectory(StringRef Path, /*fs.perms*/int Perms/*= fs::all_all*/) {
    Status S/*J*/= new Status(/*NO_COPY*/Path, new UniqueID($int2ulong(FSID), $int2ulong(FileID++)), TimeValue.now(), 0, 0, 
        0, fs.file_type.directory_file, Perms);
    addEntry(new StringRef(Path), S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::addSymlink">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 130,
   FQN="(anonymous namespace)::DummyFileSystem::addSymlink", NM="_ZN12_GLOBAL__N_115DummyFileSystem10addSymlinkEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystem10addSymlinkEN4llvm9StringRefE")
  //</editor-fold>
  public void addSymlink(StringRef Path) {
    Status S/*J*/= new Status(/*NO_COPY*/Path, new UniqueID($int2ulong(FSID), $int2ulong(FileID++)), TimeValue.now(), 0, 0, 
        0, fs.file_type.symlink_file, fs.perms.all_all);
    addEntry(new StringRef(Path), S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DummyFileSystem::~DummyFileSystem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 37,
   FQN="(anonymous namespace)::DummyFileSystem::~DummyFileSystem", NM="_ZN12_GLOBAL__N_115DummyFileSystemD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_115DummyFileSystemD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    FilesAndDirs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "FSID=" + FSID // NOI18N
              + ", FileID=" + FileID // NOI18N
              + ", FilesAndDirs=" + FilesAndDirs // NOI18N
              + super.toString(); // NOI18N
  }
}
//} JAVA: end of namespace (anonymous)
//JAVA: using namespace 
// end anonymous namespace
  
/*template <typename DirIter> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="checkContents">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 375,
 FQN="checkContents", NM="Tpl__ZL13checkContentsT_N4llvm8ArrayRefINS0_9StringRefEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=Tpl__ZL13checkContentsT_N4llvm8ArrayRefINS0_9StringRefEEE")
//</editor-fold>
public static </*typename*/ DirIter> void checkContents(DirIter I, ArrayRef<StringRef> ExpectedOut) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    std.error_code EC/*J*/= new std.error_code();
    SmallVector<StringRef> Expected/*J*/= new SmallVector<StringRef>(4, ExpectedOut.begin(), ExpectedOut.end(), new StringRef());
    SmallVector<std.string> InputToCheck/*J*/= new SmallVector<std.string>(4, new std.string());
    
    // Do not rely on iteration order to check for contents, sort both
    // content vectors before comparison.
    // JAVA: duplicate loops depending on iterator class
    if (I instanceof directory_iterator) {
      directory_iterator Iter = (directory_iterator)I;
      for (directory_iterator E = new directory_iterator(); !EC.$bool() && Iter.$noteq(E); Iter.increment(EC))  {
        InputToCheck.push_back(Iter.$arrow().getName().$string());
      }
    } else if (I instanceof recursive_directory_iterator) {
      recursive_directory_iterator Iter = (recursive_directory_iterator)I;
      for (recursive_directory_iterator E = new recursive_directory_iterator(); !EC.$bool() && Iter.$noteq(E); Iter.increment(EC))  {
        InputToCheck.push_back(Iter.$arrow().getName().$string());
      }
    } else {
      assert false : "Unexpected DirIter: " + I.getClass();
    }
    
    std.sort(InputToCheck.begin(), InputToCheck.end(), std.DefaultCompare.INSTANCE);
    std.sort(Expected.begin(), Expected.end(), std.DefaultCompare.INSTANCE);
    EXPECT_EQ(InputToCheck.size(),Expected.size());
    
    /*uint*/int LastElt = std.min(InputToCheck.size(), Expected.size());
    for (/*uint*/int Idx = 0; Idx != LastElt; ++Idx)  {
      EXPECT_EQ(new StringRef(InputToCheck.$at(Idx)),Expected.$at(Idx));
    }
  } finally {
    $c$.$destroy();
  }
}

//JAVA: namespace (anonymous) {
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedDir">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 286,
 FQN="(anonymous namespace)::ScopedDir", NM="_ZN12_GLOBAL__N_19ScopedDirE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19ScopedDirE")
//</editor-fold>
public static class/*struct*/ ScopedDir implements Destructors.ClassWithDestructor {
  public SmallString/*128*/ Path;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedDir::ScopedDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 288,
   FQN="(anonymous namespace)::ScopedDir::ScopedDir", NM="_ZN12_GLOBAL__N_19ScopedDirC1ERKN4llvm5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19ScopedDirC1ERKN4llvm5TwineEb")
  //</editor-fold>
  public ScopedDir(/*const*/ Twine /*&*/ Name) {
    this(Name, false);
  }
  public ScopedDir(/*const*/ Twine /*&*/ Name, boolean Unique/*= false*/) {
    /* : Path()*/ 
    //START JInit
    this.Path = new SmallString/*128*/(128);
    //END JInit
    std.error_code EC/*J*/= new std.error_code();
    if (Unique) {
      EC.$assignMove(fs.createUniqueDirectory(Name, Path));
    } else {
      Path.$assign(new StringRef(Name.str()));
      EC.$assignMove(fs.create_directory(new Twine(Path)));
    }
    if (EC.$bool()) {
      Path.$assign(/*STRINGREF_STR*/"");
    }
      EXPECT_FALSE((EC).$bool());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedDir::~ScopedDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 300,
   FQN="(anonymous namespace)::ScopedDir::~ScopedDir", NM="_ZN12_GLOBAL__N_19ScopedDirD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19ScopedDirD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ($noteq_StringRef(Path.$StringRef(), /*STRINGREF_STR*/"")) {
      EXPECT_FALSE((fs.remove(new Twine(Path.str()))).$bool());
    }
    //START JDestroy
    Path.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopedDir::operator StringRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 304,
   FQN="(anonymous namespace)::ScopedDir::operator StringRef", NM="_ZN12_GLOBAL__N_19ScopedDircvN4llvm9StringRefEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN12_GLOBAL__N_19ScopedDircvN4llvm9StringRefEEv")
  //</editor-fold>
  public StringRef $StringRef() {
    return Path.str();
  }

  
  public String toString() {
    return "" + "Path=" + Path; // NOI18N
  }
}
//} JAVA: end of namespace (anonymous)
// end anonymous namespace

//<editor-fold defaultstate="collapsed" desc="__builtin_trap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 315,
 FQN="__builtin_trap", NM="_Z14__builtin_trap",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_Z14__builtin_trap")
//</editor-fold>
public static void __builtin_trap()/* __attribute__((nothrow))*/ {
  throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
}
}
