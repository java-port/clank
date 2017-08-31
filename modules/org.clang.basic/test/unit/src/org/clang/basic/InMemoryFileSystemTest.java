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
import org.clang.basic.vfs.*;
import org.clang.basic.vfs.directory_iterator;
import org.clank.java.*;
import org.clank.java.StdFunctionPointers.String2String;
import org.clank.java.std_errors.errc;
import static org.clank.java.std.unique_ptr;
import org.llvm.adt.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clank.support.JavaDifferentiators.*;

/**
 * extracted InMemoryFileSystemTest part:
 * corresponds to $LLVM_SRC/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp
 * @author Vladimir Voskresensky
 */
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 523,
 FQN="InMemoryFileSystemTest", NM="_Z22InMemoryFileSystemTest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_Z22InMemoryFileSystemTest")
//</editor-fold>
public class InMemoryFileSystemTest extends FileSystemTestBase {
/*protected:*/
  protected InMemoryFileSystem FS;
  protected InMemoryFileSystem NormalizedFS;
  
  //<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest::InMemoryFileSystemTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 528,
   FQN="InMemoryFileSystemTest::InMemoryFileSystemTest", NM="_ZN22InMemoryFileSystemTestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN22InMemoryFileSystemTestC1Ev")
  //</editor-fold>
  public InMemoryFileSystemTest() {
    ///* : ::Test(), FS(/*UseNormalizedPaths=*/ false), NormalizedFS(/*UseNormalizedPaths=*/ true)*/ 
    //START JInit
    super(TestState.Successful);
    this.FS = new InMemoryFileSystem(false);
    this.NormalizedFS = new InMemoryFileSystem(true);
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest::~InMemoryFileSystemTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 523,
   FQN="InMemoryFileSystemTest::~InMemoryFileSystemTest", NM="_ZN22InMemoryFileSystemTestD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN22InMemoryFileSystemTestD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    NormalizedFS.$destroy();
    FS.$destroy();
    super.$destroy();
    //END JDestroy
  }
  
  public String toString() {
    return "" + "FS=" + FS // NOI18N
              + ", NormalizedFS=" + NormalizedFS // NOI18N
              + super.toString(); // NOI18N
  }  

  @Override
  public void tearDown() {
    $destroy();
    super.tearDown();
  }
  
@Test
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest_IsEmpty_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 533,
 FQN="InMemoryFileSystemTest_IsEmpty_Test::TestBody", NM="_ZN35InMemoryFileSystemTest_IsEmpty_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN35InMemoryFileSystemTest_IsEmpty_Test8TestBodyEv")
//</editor-fold>
public void test_IsEmpty() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ErrorOr<Status> Stat = FS.status(new Twine(/*KEEP_STR*/"/a"));
    EXPECT_EQ(errc.valueOf(Stat.getError().value()),errc.no_such_file_or_directory);
    Stat.$assignMove(FS.status(new Twine(/*KEEP_STR*/$SLASH)));
    EXPECT_EQ(errc.valueOf(Stat.getError().value()),errc.no_such_file_or_directory);
  } finally {
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest_WindowsPath_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 540,
 FQN="InMemoryFileSystemTest_WindowsPath_Test::TestBody", NM="_ZN39InMemoryFileSystemTest_WindowsPath_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN39InMemoryFileSystemTest_WindowsPath_Test8TestBodyEv")
//</editor-fold>
public void test_WindowsPath() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"c:/windows/system128/foo.cpp"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$EMPTY)))));
    ErrorOr<Status> Stat = FS.status(new Twine(/*KEEP_STR*/"c:"));
    ASSERT_FALSE((Stat.getError()).$bool());
    Stat.$assignMove(FS.status(new Twine(/*KEEP_STR*/"c:/windows/system128/foo.cpp")));
    ASSERT_FALSE((Stat.getError()).$bool());
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"d:/windows/foo.cpp"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$EMPTY)))));
    Stat.$assignMove(FS.status(new Twine(/*KEEP_STR*/"d:/windows/foo.cpp")));
    ASSERT_FALSE((Stat.getError()).$bool());
  } finally {
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest_OverlayFile_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 553,
 FQN="InMemoryFileSystemTest_OverlayFile_Test::TestBody", NM="_ZN39InMemoryFileSystemTest_OverlayFile_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN39InMemoryFileSystemTest_OverlayFile_Test8TestBodyEv")
//</editor-fold>
public void test_OverlayFile() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/a"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$a)))));
    $c$.clean(NormalizedFS.addFile(new Twine(/*KEEP_STR*/"/a"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$a)))));
    ErrorOr<Status> Stat = FS.status(new Twine(/*KEEP_STR*/$SLASH));
    ASSERT_FALSE((Stat.getError()).$bool());
    Stat.$assignMove(FS.status(new Twine(/*KEEP_STR*/"/.")));
    ASSERT_FALSE((Stat).$bool());
    Stat.$assignMove(NormalizedFS.status(new Twine(/*KEEP_STR*/"/.")));
    ASSERT_FALSE((Stat.getError()).$bool());
    Stat.$assignMove(FS.status(new Twine(/*KEEP_STR*/"/a")));
    ASSERT_FALSE((Stat.getError()).$bool());
    EXPECT_EQ("/a",Stat.$arrow().getName());
  } finally {
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest_OverlayFileNoOwn_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 567,
 FQN="InMemoryFileSystemTest_OverlayFileNoOwn_Test::TestBody", NM="_ZN44InMemoryFileSystemTest_OverlayFileNoOwn_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN44InMemoryFileSystemTest_OverlayFileNoOwn_Test8TestBodyEv")
//</editor-fold>
public void test_OverlayFileNoOwn() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  unique_ptr<MemoryBuffer> Buf = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Buf = MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$a));
    FS.addFileNoOwn(new Twine(/*KEEP_STR*/"/a"), 0, Buf.get());
    ErrorOr<Status> Stat = FS.status(new Twine(/*KEEP_STR*/"/a"));
    ASSERT_FALSE((Stat.getError()).$bool());
    EXPECT_EQ("/a",Stat.$arrow().getName());
  } finally {
    if (Buf != null) { Buf.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest_OpenFileForRead_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 575,
 FQN="InMemoryFileSystemTest_OpenFileForRead_Test::TestBody", NM="_ZN43InMemoryFileSystemTest_OpenFileForRead_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN43InMemoryFileSystemTest_OpenFileForRead_Test8TestBodyEv")
//</editor-fold>
public void test_OpenFileForRead() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ErrorOr<unique_ptr<File> > File = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/a"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$a)))));
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"././c"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$c)))));
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"./d/../d"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$d)))));
    $c$.clean(NormalizedFS.addFile(new Twine(/*KEEP_STR*/"/a"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$a)))));
    $c$.clean(NormalizedFS.addFile(new Twine(/*KEEP_STR*/"././c"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$c)))));
    $c$.clean(NormalizedFS.addFile(new Twine(/*KEEP_STR*/"./d/../d"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$d)))));
    File = FS.openFileForRead(new Twine(/*KEEP_STR*/"/a"));
    EXPECT_EQ("a",($c$.track((File.$star()).$arrow().getBuffer(new Twine(/*KEEP_STR*/"ignored"))).$star()).$arrow().getBuffer());$c$.clean();
    $c$.clean(File.$assignMove($c$.track(FS.openFileForRead(new Twine(/*KEEP_STR*/"/a"))))); // Open again.
    EXPECT_EQ("a",($c$.track((File.$star()).$arrow().getBuffer(new Twine(/*KEEP_STR*/"ignored"))).$star()).$arrow().getBuffer());$c$.clean();
    $c$.clean(File.$assignMove($c$.track(NormalizedFS.openFileForRead(new Twine(/*KEEP_STR*/"/././a"))))); // Open again.
    EXPECT_EQ("a",($c$.track((File.$star()).$arrow().getBuffer(new Twine(/*KEEP_STR*/"ignored"))).$star()).$arrow().getBuffer());$c$.clean();
    $c$.clean(File.$assignMove($c$.track(FS.openFileForRead(new Twine(/*KEEP_STR*/$SLASH)))));
    EXPECT_EQ(File.getError(),errc.invalid_argument);
    $c$.clean(File.$assignMove($c$.track(FS.openFileForRead(new Twine(/*KEEP_STR*/"/b")))));
    EXPECT_EQ(File.getError(),errc.no_such_file_or_directory);
    $c$.clean(File.$assignMove($c$.track(FS.openFileForRead(new Twine(/*KEEP_STR*/"./c")))));
    ASSERT_FALSE((File).$bool());
    $c$.clean(File.$assignMove($c$.track(FS.openFileForRead(new Twine(/*KEEP_STR*/"e/../d")))));
    ASSERT_FALSE((File).$bool());
    $c$.clean(File.$assignMove($c$.track(NormalizedFS.openFileForRead(new Twine(/*KEEP_STR*/"./c")))));
    EXPECT_EQ("c",($c$.track((File.$star()).$arrow().getBuffer(new Twine(/*KEEP_STR*/"ignored"))).$star()).$arrow().getBuffer());$c$.clean();
    $c$.clean(File.$assignMove($c$.track(NormalizedFS.openFileForRead(new Twine(/*KEEP_STR*/"e/../d")))));
    EXPECT_EQ("d",($c$.track((File.$star()).$arrow().getBuffer(new Twine(/*KEEP_STR*/"ignored"))).$star()).$arrow().getBuffer());$c$.clean();
  } finally {
    if (File != null) { File.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest_DuplicatedFile_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 602,
 FQN="InMemoryFileSystemTest_DuplicatedFile_Test::TestBody", NM="_ZN42InMemoryFileSystemTest_DuplicatedFile_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN42InMemoryFileSystemTest_DuplicatedFile_Test8TestBodyEv")
//</editor-fold>
public void test_DuplicatedFile() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ASSERT_TRUE(FS.addFile(new Twine(/*KEEP_STR*/"/a"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"a"))))); $c$.clean();
    ASSERT_FALSE(FS.addFile(new Twine(/*KEEP_STR*/"/a/b"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"a"))))); $c$.clean();
    ASSERT_TRUE(FS.addFile(new Twine(/*KEEP_STR*/"/a"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"a"))))); $c$.clean();
    ASSERT_FALSE(FS.addFile(new Twine(/*KEEP_STR*/"/a"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/"b"))))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest_DirectoryIteration_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 609,
 FQN="InMemoryFileSystemTest_DirectoryIteration_Test::TestBody", NM="_ZN46InMemoryFileSystemTest_DirectoryIteration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN46InMemoryFileSystemTest_DirectoryIteration_Test8TestBodyEv")
//</editor-fold>
public void test_DirectoryIteration() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/a"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$EMPTY)))));
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/"/b/c"), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$EMPTY)))));
    
    std.error_code EC/*J*/= new std.error_code();
    directory_iterator I = FS.dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC);
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ("/a",I.$arrow().getName());
    I.increment(EC);
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ("/b",I.$arrow().getName());
    I.increment(EC);
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ(new directory_iterator(),I);
    
    I.$assignMove(FS.dir_begin(new Twine(/*KEEP_STR*/"/b"), EC));
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ("/b/c",I.$arrow().getName());
    I.increment(EC);
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ(new directory_iterator(),I);
  } finally {
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="InMemoryFileSystemTest_WorkingDirectory_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 632,
 FQN="InMemoryFileSystemTest_WorkingDirectory_Test::TestBody", NM="_ZN44InMemoryFileSystemTest_WorkingDirectory_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN44InMemoryFileSystemTest_WorkingDirectory_Test8TestBodyEv")
//</editor-fold>
public void test_WorkingDirectory() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FS.setCurrentWorkingDirectory(new Twine(/*KEEP_STR*/"/b"));
    $c$.clean(FS.addFile(new Twine(/*KEEP_STR*/$c), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(/*KEEP_STR*/$EMPTY)))));
    
    ErrorOr<Status> Stat = FS.status(new Twine(/*KEEP_STR*/"/b/c"));
    ASSERT_FALSE((Stat.getError()).$bool());
    EXPECT_EQ("c",Stat.$arrow().getName());
    EXPECT_EQ("/b",FS.getCurrentWorkingDirectory().$star());
    
    Stat.$assignMove(FS.status(new Twine(/*KEEP_STR*/$c)));
    ASSERT_FALSE((Stat.getError()).$bool());
    
    String2String ReplaceBackslashes =  (S) -> 
      {
        std.replace(S.begin(), S.end(), $$BACK_SLASH, $$SLASH);
        return new std.string(JD$Move.INSTANCE, S);
      }
;
    NormalizedFS.setCurrentWorkingDirectory(new Twine(/*KEEP_STR*/"/b/c"));
    NormalizedFS.setCurrentWorkingDirectory(new Twine(/*KEEP_STR*/$DOT));
    EXPECT_EQ("/b/c",ReplaceBackslashes.$call(new std.string(NormalizedFS.getCurrentWorkingDirectory().get())));
    NormalizedFS.setCurrentWorkingDirectory(new Twine(/*KEEP_STR*/$DOT_DOT));
    EXPECT_EQ("/b",ReplaceBackslashes.$call(new std.string(NormalizedFS.getCurrentWorkingDirectory().get())));
  } finally {
    $c$.$destroy();
  }
}
  
}
