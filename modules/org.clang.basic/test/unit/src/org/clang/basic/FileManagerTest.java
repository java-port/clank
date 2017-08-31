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

import org.junit.Test;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.llvm.support.sys.fs;

//<editor-fold defaultstate="collapsed" desc="static type FileManagerTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -test=FileManagerTest")
//</editor-fold>
public final class FileManagerTest extends ADTSupportTestBase {

//JAVA: using namespace llvm
//JAVA: using namespace clang
//JAVA: namespace (anonymous) {

// Used to create a fake file system for running the tests with such
// that the tests are not affected by the structure/contents of the
// file system on the machine running the tests.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FakeStatCache">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 25,
 FQN="(anonymous namespace)::FakeStatCache", NM="_ZN12_GLOBAL__N_113FakeStatCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_113FakeStatCacheE")
//</editor-fold>
public static class FakeStatCache extends /*public*/ FileSystemStatCache implements Destructors.ClassWithDestructor {
/*private:*/
  // Maps a file/directory path to its desired stat result.  Anything
  // not in this map is considered to not exist in the file system.
  private StringMap<FileData> StatCalls;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FakeStatCache::InjectFileOrDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 31,
   FQN="(anonymous namespace)::FakeStatCache::InjectFileOrDirectory", NM="_ZN12_GLOBAL__N_113FakeStatCache21InjectFileOrDirectoryEPKcmb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_113FakeStatCache21InjectFileOrDirectoryEPKcmb")
  //</editor-fold>
  private void InjectFileOrDirectory(/*const*/char$ptr/*char P*/ Path, long/*ino_t*/ INode, boolean IsFile) {
    FileData Data = null;
    try {
      Data/*J*/= new FileData();
      Data.Name.$assign(Path);
      Data.Size = 0;
      Data.ModTime = 0;
      Data.UniqueID.$assignMove(new fs.UniqueID(1, INode));
      Data.IsDirectory = !IsFile;
      Data.IsNamedPipe = false;
      Data.InPCH = false;
      StatCalls.$at(new StringRef(/*STRINGREF_STR*/Path)).$assign(Data);
    } finally {
      if (Data != null) { Data.$destroy(); }
    }
  }

/*public:*/
  // Inject a file with the given inode value to the fake file system.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FakeStatCache::InjectFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 45,
   FQN="(anonymous namespace)::FakeStatCache::InjectFile", NM="_ZN12_GLOBAL__N_113FakeStatCache10InjectFileEPKcm",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_113FakeStatCache10InjectFileEPKcm")
  //</editor-fold>
  public void InjectFile(/*const*/char$ptr/*char P*/ Path, long/*ino_t*/ INode) {
    InjectFileOrDirectory(Path, INode, /*IsFile=*/ true);
  }

  
  // Inject a directory with the given inode value to the fake file system.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FakeStatCache::InjectDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 50,
   FQN="(anonymous namespace)::FakeStatCache::InjectDirectory", NM="_ZN12_GLOBAL__N_113FakeStatCache15InjectDirectoryEPKcm",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_113FakeStatCache15InjectDirectoryEPKcm")
  //</editor-fold>
  public void InjectDirectory(/*const*/char$ptr/*char P*/ Path, long/*ino_t*/ INode) {
    InjectFileOrDirectory(Path, INode, /*IsFile=*/ false);
  }

  
  // Implement FileSystemStatCache::getStat().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FakeStatCache::getStat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 55,
   FQN="(anonymous namespace)::FakeStatCache::getStat", NM="_ZN12_GLOBAL__N_113FakeStatCache7getStatEPKcRN5clang8FileDataEbPSt10unique_ptrINS3_3vfs4FileESt14default_deleteIS8_EERNS7_10FileSystemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_113FakeStatCache7getStatEPKcRN5clang8FileDataEbPSt10unique_ptrINS3_3vfs4FileESt14default_deleteIS8_EERNS7_10FileSystemE")
  //</editor-fold>
  @Override public LookupResult getStat(/*const*/char$ptr/*char P*/ Path, int aPathLen, FileData /*&*/ Data, boolean isFile, 
         std.unique_ptr<File> /*P*/ F, 
         FileSystem /*&*/ FS)/* override*/ {
    if (StatCalls.count(new StringRef(Path)) != 0) {
      Data.$assign(StatCalls.$at(/*STRINGREF_STR*/Path));
      return LookupResult.CacheExists;
    }
    
    return LookupResult.CacheMissing; // This means the file/directory doesn't exist.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FakeStatCache::~FakeStatCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 25,
   FQN="(anonymous namespace)::FakeStatCache::~FakeStatCache", NM="_ZN12_GLOBAL__N_113FakeStatCacheD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_113FakeStatCacheD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    StatCalls.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FakeStatCache::FakeStatCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 25,
   FQN="(anonymous namespace)::FakeStatCache::FakeStatCache", NM="_ZN12_GLOBAL__N_113FakeStatCacheC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_113FakeStatCacheC1Ev")
  //</editor-fold>
  public /*inline*/ FakeStatCache() {
    /* : FileSystemStatCache(), StatCalls()*/ 
    //START JInit
    super();
    this.StatCalls = new StringMap<FileData>(new FileData());
    //END JInit
  }

  
  public String toString() {
    return "" + "StatCalls=" + StatCalls // NOI18N
              + super.toString(); // NOI18N
  }
}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest::FileManagerTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 70,
   FQN="(anonymous namespace)::FileManagerTest::FileManagerTest", NM="_ZN12_GLOBAL__N_115FileManagerTestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_115FileManagerTestC1Ev")
  //</editor-fold>
  public FileManagerTest() {
    /* : ::Test(), options(), manager(options)*/ 
    //START JInit
    super();
    this.options = new FileSystemOptions();
    this.manager = new FileManager(options);
    //END JInit
  }

  @Override
  public void tearDown() {
    this.$destroy();
    super.tearDown();
  }
  
  protected FileSystemOptions options;
  protected FileManager manager;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest::~FileManagerTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 68,
   FQN="(anonymous namespace)::FileManagerTest::~FileManagerTest", NM="_ZN12_GLOBAL__N_115FileManagerTestD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_115FileManagerTestD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    manager.$destroy();
    options.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "options=" + options // NOI18N
              + ", manager=" + manager // NOI18N
              + super.toString(); // NOI18N
  }


// When a virtual file is added, its getDir() field is set correctly
// (not NULL, correct name).

  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_getVirtualFileSetsTheDirFieldCorrectly_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 79,
   FQN="(anonymous namespace)::FileManagerTest_getVirtualFileSetsTheDirFieldCorrectly_Test::TestBody", NM="_ZN12_GLOBAL__N_159FileManagerTest_getVirtualFileSetsTheDirFieldCorrectly_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_159FileManagerTest_getVirtualFileSetsTheDirFieldCorrectly_Test8TestBodyEv")
  //</editor-fold>
  public void test_getVirtualFileSetsTheDirFieldCorrectly() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ FileEntry /*P*/ file = manager.getVirtualFile(new StringRef(/*KEEP_STR*/"foo.cpp"), 42, 0);
      ASSERT_TRUE(file != null);

      /*const*/ DirectoryEntry /*P*/ dir = file.getDir();
      ASSERT_TRUE(dir != null);
      EXPECT_EQ(".",dir.getName());

      file = manager.getVirtualFile(new StringRef(/*KEEP_STR*/"x/y/z.cpp"), 42, 0);
      ASSERT_TRUE(file != null);

      dir = file.getDir();
      ASSERT_TRUE(dir != null);
      EXPECT_EQ("x/y",dir.getName());
    } finally {
      $c$.$destroy();
    }
  }


  // Before any virtual file is added, no virtual directory exists.
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_NoVirtualDirectoryExistsBeforeAVirtualFileIsAdded_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 96,
   FQN="(anonymous namespace)::FileManagerTest_NoVirtualDirectoryExistsBeforeAVirtualFileIsAdded_Test::TestBody", NM="_ZN12_GLOBAL__N_170FileManagerTest_NoVirtualDirectoryExistsBeforeAVirtualFileIsAdded_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_170FileManagerTest_NoVirtualDirectoryExistsBeforeAVirtualFileIsAdded_Test8TestBodyEv")
  //</editor-fold>
  public void test_NoVirtualDirectoryExistsBeforeAVirtualFileIsAdded() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // An empty FakeStatCache causes all stat calls made by the
      // FileManager to report "file/directory doesn't exist".  This
      // avoids the possibility of the result of this test being affected
      // by what's in the real file system.
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>($c$.track(llvm.make_unique(new FakeStatCache()))))); $c$.clean();
      EXPECT_EQ(null,manager.getDirectory(new StringRef(/*KEEP_STR*/"virtual/dir/foo")));
      EXPECT_EQ(null,manager.getDirectory(new StringRef(/*KEEP_STR*/"virtual/dir")));
      EXPECT_EQ(null,manager.getDirectory(new StringRef(/*KEEP_STR*/"virtual")));
    } finally {
      $c$.$destroy();
    }
  }


  // When a virtual file is added, all of its ancestors should be created.
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_getVirtualFileCreatesDirectoryEntriesForAncestors_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 109,
   FQN="(anonymous namespace)::FileManagerTest_getVirtualFileCreatesDirectoryEntriesForAncestors_Test::TestBody", NM="_ZN12_GLOBAL__N_170FileManagerTest_getVirtualFileCreatesDirectoryEntriesForAncestors_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_170FileManagerTest_getVirtualFileCreatesDirectoryEntriesForAncestors_Test8TestBodyEv")
  //</editor-fold>
  public void test_getVirtualFileCreatesDirectoryEntriesForAncestors() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Fake an empty real file system.
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>($c$.track(llvm.make_unique(new FakeStatCache()))))); $c$.clean();

      manager.getVirtualFile(new StringRef(/*KEEP_STR*/"virtual/dir/bar.h"), 100, 0);
      EXPECT_EQ(null,manager.getDirectory(new StringRef(/*KEEP_STR*/"virtual/dir/foo")));

      /*const*/ DirectoryEntry /*P*/ dir = manager.getDirectory(new StringRef(/*KEEP_STR*/"virtual/dir"));
      ASSERT_TRUE(dir != null);
      EXPECT_EQ("virtual/dir",dir.getName());

      dir = manager.getDirectory(new StringRef(/*KEEP_STR*/$virtual));
      ASSERT_TRUE(dir != null);
      EXPECT_EQ("virtual",dir.getName());
    } finally {
      $c$.$destroy();
    }
  }


  // getFile() returns non-NULL if a real file exists at the given path.
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_getFileReturnsValidFileEntryForExistingRealFile_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 126,
   FQN="(anonymous namespace)::FileManagerTest_getFileReturnsValidFileEntryForExistingRealFile_Test::TestBody", NM="_ZN12_GLOBAL__N_168FileManagerTest_getFileReturnsValidFileEntryForExistingRealFile_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_168FileManagerTest_getFileReturnsValidFileEntryForExistingRealFile_Test8TestBodyEv")
  //</editor-fold>
  public void test_getFileReturnsValidFileEntryForExistingRealFile() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr<FakeStatCache> statCache = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Inject fake files into the file system.
      statCache = llvm.make_unique(new FakeStatCache());
      statCache.$arrow().InjectDirectory($SLASH_TMP, 42);
      statCache.$arrow().InjectFile($("/tmp/test"), 43);

      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>(std.move(statCache)))); $c$.clean();

      /*const*/ FileEntry /*P*/ file = manager.getFile(new StringRef(/*KEEP_STR*/"/tmp/test"));
      ASSERT_TRUE(file != null);
      EXPECT_EQ("/tmp/test",file.getName());

      /*const*/ DirectoryEntry /*P*/ dir = file.getDir();
      ASSERT_TRUE(dir != null);
      EXPECT_EQ("/tmp",dir.getName());
    } finally {
      if (statCache != null) { statCache.$destroy(); }
      $c$.$destroy();
    }
  }


  // getFile() returns non-NULL if a virtual file exists at the given path.
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_getFileReturnsValidFileEntryForExistingVirtualFile_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 160,
   FQN="(anonymous namespace)::FileManagerTest_getFileReturnsValidFileEntryForExistingVirtualFile_Test::TestBody", NM="_ZN12_GLOBAL__N_171FileManagerTest_getFileReturnsValidFileEntryForExistingVirtualFile_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_171FileManagerTest_getFileReturnsValidFileEntryForExistingVirtualFile_Test8TestBodyEv")
  //</editor-fold>
  public void test_getFileReturnsValidFileEntryForExistingVirtualFile() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Fake an empty real file system.
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>($c$.track(llvm.make_unique(new FakeStatCache()))))); $c$.clean();

      manager.getVirtualFile(new StringRef(/*KEEP_STR*/"virtual/dir/bar.h"), 100, 0);
      /*const*/ FileEntry /*P*/ file = manager.getFile(new StringRef(/*KEEP_STR*/"virtual/dir/bar.h"));
      ASSERT_TRUE(file != null);
      EXPECT_EQ("virtual/dir/bar.h",file.getName());

      /*const*/ DirectoryEntry /*P*/ dir = file.getDir();
      ASSERT_TRUE(dir != null);
      EXPECT_EQ("virtual/dir",dir.getName());
    } finally {
      $c$.$destroy();
    }
  }


  // getFile() returns different FileEntries for different paths when
  // there's no aliasing.
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_getFileReturnsDifferentFileEntriesForDifferentFiles_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 176,
   FQN="(anonymous namespace)::FileManagerTest_getFileReturnsDifferentFileEntriesForDifferentFiles_Test::TestBody", NM="_ZN12_GLOBAL__N_172FileManagerTest_getFileReturnsDifferentFileEntriesForDifferentFiles_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_172FileManagerTest_getFileReturnsDifferentFileEntriesForDifferentFiles_Test8TestBodyEv")
  //</editor-fold>
  public void test_getFileReturnsDifferentFileEntriesForDifferentFiles() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr<FakeStatCache> statCache = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Inject two fake files into the file system.  Different inodes
      // mean the files are not symlinked together.
      statCache = llvm.make_unique(new FakeStatCache());
      statCache.$arrow().InjectDirectory($DOT, 41);
      statCache.$arrow().InjectFile($("foo.cpp"), 42);
      statCache.$arrow().InjectFile($("bar.cpp"), 43);
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>(std.move(statCache)))); $c$.clean();

      /*const*/ FileEntry /*P*/ fileFoo = manager.getFile(new StringRef(/*KEEP_STR*/"foo.cpp"));
      /*const*/ FileEntry /*P*/ fileBar = manager.getFile(new StringRef(/*KEEP_STR*/"bar.cpp"));
      ASSERT_TRUE(fileFoo != null);
      ASSERT_TRUE(fileBar != null);
      EXPECT_NE(fileFoo,fileBar);
    } finally {
      if (statCache != null) { statCache.$destroy(); }
      $c$.$destroy();
    }
  }


  // getFile() returns NULL if neither a real file nor a virtual file
  // exists at the given path.
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_getFileReturnsNULLForNonexistentFile_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 194,
   FQN="(anonymous namespace)::FileManagerTest_getFileReturnsNULLForNonexistentFile_Test::TestBody", NM="_ZN12_GLOBAL__N_157FileManagerTest_getFileReturnsNULLForNonexistentFile_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_157FileManagerTest_getFileReturnsNULLForNonexistentFile_Test8TestBodyEv")
  //</editor-fold>
  public void test_getFileReturnsNULLForNonexistentFile() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr<FakeStatCache> statCache = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Inject a fake foo.cpp into the file system.
      statCache = llvm.make_unique(new FakeStatCache());
      statCache.$arrow().InjectDirectory($DOT, 41);
      statCache.$arrow().InjectFile($("foo.cpp"), 42);
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>(std.move(statCache)))); $c$.clean();

      // Create a virtual bar.cpp file.
      manager.getVirtualFile(new StringRef(/*KEEP_STR*/"bar.cpp"), 200, 0);

      /*const*/ FileEntry /*P*/ file = manager.getFile(new StringRef(/*KEEP_STR*/"xyz.txt"));
      EXPECT_EQ(null,file);
    } finally {
      if (statCache != null) { statCache.$destroy(); }
      $c$.$destroy();
    }
  }


  // getFile() returns the same FileEntry for real files that are aliases.
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_getFileReturnsSameFileEntryForAliasedRealFiles_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 213,
   FQN="(anonymous namespace)::FileManagerTest_getFileReturnsSameFileEntryForAliasedRealFiles_Test::TestBody", NM="_ZN12_GLOBAL__N_167FileManagerTest_getFileReturnsSameFileEntryForAliasedRealFiles_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_167FileManagerTest_getFileReturnsSameFileEntryForAliasedRealFiles_Test8TestBodyEv")
  //</editor-fold>
  public void test_getFileReturnsSameFileEntryForAliasedRealFiles() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr<FakeStatCache> statCache = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Inject two real files with the same inode.
      statCache = llvm.make_unique(new FakeStatCache());
      statCache.$arrow().InjectDirectory($("abc"), 41);
      statCache.$arrow().InjectFile($("abc/foo.cpp"), 42);
      statCache.$arrow().InjectFile($("abc/bar.cpp"), 42);
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>(std.move(statCache)))); $c$.clean();
      EXPECT_EQ(manager.getFile(new StringRef(/*KEEP_STR*/"abc/foo.cpp")),manager.getFile(new StringRef(/*KEEP_STR*/"abc/bar.cpp")));
    } finally {
      if (statCache != null) { statCache.$destroy(); }
      $c$.$destroy();
    }
  }


  // getFile() returns the same FileEntry for virtual files that have
  // corresponding real files that are aliases.
  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_getFileReturnsSameFileEntryForAliasedVirtualFiles_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 226,
   FQN="(anonymous namespace)::FileManagerTest_getFileReturnsSameFileEntryForAliasedVirtualFiles_Test::TestBody", NM="_ZN12_GLOBAL__N_170FileManagerTest_getFileReturnsSameFileEntryForAliasedVirtualFiles_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_170FileManagerTest_getFileReturnsSameFileEntryForAliasedVirtualFiles_Test8TestBodyEv")
  //</editor-fold>
  public void test_getFileReturnsSameFileEntryForAliasedVirtualFiles() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr<FakeStatCache> statCache = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Inject two real files with the same inode.
      statCache = llvm.make_unique(new FakeStatCache());
      statCache.$arrow().InjectDirectory($("abc"), 41);
      statCache.$arrow().InjectFile($("abc/foo.cpp"), 42);
      statCache.$arrow().InjectFile($("abc/bar.cpp"), 42);
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>(std.move(statCache)))); $c$.clean();

      manager.getVirtualFile(new StringRef(/*KEEP_STR*/"abc/foo.cpp"), 100, 0);
      manager.getVirtualFile(new StringRef(/*KEEP_STR*/"abc/bar.cpp"), 200, 0);
      EXPECT_EQ(manager.getFile(new StringRef(/*KEEP_STR*/"abc/foo.cpp")),manager.getFile(new StringRef(/*KEEP_STR*/"abc/bar.cpp")));
    } finally {
      if (statCache != null) { statCache.$destroy(); }
      $c$.$destroy();
    }
  }

  ;
  @Test
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FileManagerTest_addRemoveStatCache_Test::TestBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp", line = 240,
   FQN="(anonymous namespace)::FileManagerTest_addRemoveStatCache_Test::TestBody", NM="_ZN12_GLOBAL__N_139FileManagerTest_addRemoveStatCache_Test8TestBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/FileManagerTest.cpp -nm=_ZN12_GLOBAL__N_139FileManagerTest_addRemoveStatCache_Test8TestBodyEv")
  //</editor-fold>
  public void test_addRemoveStatCache() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    unique_ptr<FakeStatCache> statCacheOwner = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>($c$.track(llvm.make_unique(new FakeStatCache()))))); $c$.clean();
      statCacheOwner = llvm.make_unique(new FakeStatCache());
      FakeStatCache /*P*/ statCache = statCacheOwner.get();
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>(std.move(statCacheOwner)))); $c$.clean();
      manager.addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>($c$.track(llvm.make_unique(new FakeStatCache()))))); $c$.clean();
      manager.removeStatCache(statCache);
    } finally {
      if (statCacheOwner != null) { statCacheOwner.$destroy(); }
      $c$.$destroy();
    }
  }

//} JAVA: end of namespace (anonymous)
//JAVA: using namespace 
} // END OF class FileManagerTest
