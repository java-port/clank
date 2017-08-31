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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.llvm.support.sys.fs;
import static org.llvm.support.sys.fs.$bitor_perms;

/**
 * extracted VirtualFileSystemTest part:
 * corresponds to $LLVM_SRC/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp
 * 
 * @author Vladimir Voskresensky
 */
//<editor-fold defaultstate="collapsed" desc="static type VirtualFileSystemTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -test=VirtualFileSystemTest")
//</editor-fold>
public final class VirtualFileSystemTest extends FileSystemTestBase {

  public VirtualFileSystemTest() {
    super(TestState.Successful);
  }

@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_StatusQueries_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 138,
 FQN="VirtualFileSystemTest_StatusQueries_Test::TestBody", NM="_ZN40VirtualFileSystemTest_StatusQueries_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN40VirtualFileSystemTest_StatusQueries_Test8TestBodyEv")
//</editor-fold>
public void test_StatusQueries() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> D = null;
  try {
    D/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    ErrorOr<Status> Status/*J*/= new ErrorOr<Status>((new std.error_code()));
    
    D.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/foo"));
    Status.$assignMove(D.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    ASSERT_FALSE((Status.getError()).$bool());
    EXPECT_TRUE(Status.$arrow().isStatusKnown());
    EXPECT_FALSE(Status.$arrow().isDirectory());
    EXPECT_TRUE(Status.$arrow().isRegularFile());
    EXPECT_FALSE(Status.$arrow().isSymlink());
    EXPECT_FALSE(Status.$arrow().isOther());
    EXPECT_TRUE(Status.$arrow().exists());
    
    D.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/bar"));
    Status.$assignMove(D.$arrow().status(new Twine(/*KEEP_STR*/"/bar")));
    ASSERT_FALSE((Status.getError()).$bool());
    EXPECT_TRUE(Status.$arrow().isStatusKnown());
    EXPECT_TRUE(Status.$arrow().isDirectory());
    EXPECT_FALSE(Status.$arrow().isRegularFile());
    EXPECT_FALSE(Status.$arrow().isSymlink());
    EXPECT_FALSE(Status.$arrow().isOther());
    EXPECT_TRUE(Status.$arrow().exists());
    
    D.$arrow().addSymlink(new StringRef(/*KEEP_STR*/"/baz"));
    Status.$assignMove(D.$arrow().status(new Twine(/*KEEP_STR*/"/baz")));
    ASSERT_FALSE((Status.getError()).$bool());
    EXPECT_TRUE(Status.$arrow().isStatusKnown());
    EXPECT_FALSE(Status.$arrow().isDirectory());
    EXPECT_FALSE(Status.$arrow().isRegularFile());
    EXPECT_TRUE(Status.$arrow().isSymlink());
    EXPECT_FALSE(Status.$arrow().isOther());
    EXPECT_TRUE(Status.$arrow().exists());
    EXPECT_TRUE(Status.$arrow().equivalent(Status.$star()));
    ErrorOr<Status> Status2 = D.$arrow().status(new Twine(/*KEEP_STR*/"/foo"));
    ASSERT_FALSE((Status2.getError()).$bool());
    EXPECT_FALSE(Status.$arrow().equivalent(Status2.$star()));
  } finally {
    if (D != null) { D.$destroy(); }
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_BaseOnlyOverlay_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 178,
 FQN="VirtualFileSystemTest_BaseOnlyOverlay_Test::TestBody", NM="_ZN42VirtualFileSystemTest_BaseOnlyOverlay_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN42VirtualFileSystemTest_BaseOnlyOverlay_Test8TestBodyEv")
//</editor-fold>
public void test_BaseOnlyOverlay() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> D = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    D/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    ErrorOr<Status> Status/*J*/= new ErrorOr<Status>((new std.error_code()));
    EXPECT_FALSE((Status.$assignMove(D.$arrow().status(new Twine(/*KEEP_STR*/"/foo")))).$bool());
    
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(D)))));
    EXPECT_FALSE((Status.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/foo")))).$bool());
    
    D.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/foo"));
    Status.$assignMove(D.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    EXPECT_FALSE((Status.getError()).$bool());
    
    ErrorOr<Status> Status2/*J*/= new ErrorOr<Status>((new std.error_code()));
    Status2.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    EXPECT_FALSE((Status2.getError()).$bool());
    EXPECT_TRUE(Status.$arrow().equivalent(Status2.$star()));
  } finally {
    if (O != null) { O.$destroy(); }
    if (D != null) { D.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_OverlayFiles_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 196,
 FQN="VirtualFileSystemTest_OverlayFiles_Test::TestBody", NM="_ZN39VirtualFileSystemTest_OverlayFiles_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN39VirtualFileSystemTest_OverlayFiles_Test8TestBodyEv")
//</editor-fold>
public void test_OverlayFiles() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Base = null;
  IntrusiveRefCntPtr<DummyFileSystem> Middle = null;
  IntrusiveRefCntPtr<DummyFileSystem> Top = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Base/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Middle/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Top/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Base)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Middle))); $c$.clean();
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Top))); $c$.clean();
    
    ErrorOr<Status> Status1/*J*/= new ErrorOr<Status>((new std.error_code())), 
        Status2/*J*/= new ErrorOr<Status>((new std.error_code())), Status3/*J*/= new ErrorOr<Status>((new std.error_code())), 
        StatusB/*J*/= new ErrorOr<Status>((new std.error_code())), StatusM/*J*/= new ErrorOr<Status>((new std.error_code())), 
        StatusT/*J*/= new ErrorOr<Status>((new std.error_code()));
    
    Base.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/foo"));
    StatusB.$assignMove(Base.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    ASSERT_FALSE((StatusB.getError()).$bool());
    Status1.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    ASSERT_FALSE((Status1.getError()).$bool());
    Middle.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/foo"));
    StatusM.$assignMove(Middle.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    ASSERT_FALSE((StatusM.getError()).$bool());
    Status2.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    ASSERT_FALSE((Status2.getError()).$bool());
    Top.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/foo"));
    StatusT.$assignMove(Top.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    ASSERT_FALSE((StatusT.getError()).$bool());
    Status3.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/foo")));
    ASSERT_FALSE((Status3.getError()).$bool());
    EXPECT_TRUE(Status1.$arrow().equivalent(StatusB.$star()));
    EXPECT_TRUE(Status2.$arrow().equivalent(StatusM.$star()));
    EXPECT_TRUE(Status3.$arrow().equivalent(StatusT.$star()));
    EXPECT_FALSE(Status1.$arrow().equivalent(Status2.$star()));
    EXPECT_FALSE(Status2.$arrow().equivalent(Status3.$star()));
    EXPECT_FALSE(Status1.$arrow().equivalent(Status3.$star()));
  } finally {
    if (O != null) { O.$destroy(); }
    if (Top != null) { Top.$destroy(); }
    if (Middle != null) { Middle.$destroy(); }
    if (Base != null) { Base.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_OverlayDirsNonMerged_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 235,
 FQN="VirtualFileSystemTest_OverlayDirsNonMerged_Test::TestBody", NM="_ZN47VirtualFileSystemTest_OverlayDirsNonMerged_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN47VirtualFileSystemTest_OverlayDirsNonMerged_Test8TestBodyEv")
//</editor-fold>
public void test_OverlayDirsNonMerged() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<DummyFileSystem> Upper = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Upper/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Upper))); $c$.clean();
    
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/lower-only"));
    Upper.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/upper-only"));
    
    // non-merged paths should be the same
    ErrorOr<Status> Status1 = Lower.$arrow().status(new Twine(/*KEEP_STR*/"/lower-only"));
    ASSERT_FALSE((Status1.getError()).$bool());
    ErrorOr<Status> Status2 = O.$arrow().status(new Twine(/*KEEP_STR*/"/lower-only"));
    ASSERT_FALSE((Status2.getError()).$bool());
    EXPECT_TRUE(Status1.$arrow().equivalent(Status2.$star()));
    
    Status1.$assignMove(Upper.$arrow().status(new Twine(/*KEEP_STR*/"/upper-only")));
    ASSERT_FALSE((Status1.getError()).$bool());
    Status2.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/upper-only")));
    ASSERT_FALSE((Status2.getError()).$bool());
    EXPECT_TRUE(Status1.$arrow().equivalent(Status2.$star()));
  } finally {
    if (O != null) { O.$destroy(); }
    if (Upper != null) { Upper.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_MergedDirPermissions_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 259,
 FQN="VirtualFileSystemTest_MergedDirPermissions_Test::TestBody", NM="_ZN47VirtualFileSystemTest_MergedDirPermissions_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN47VirtualFileSystemTest_MergedDirPermissions_Test8TestBodyEv")
//</editor-fold>
public void test_MergedDirPermissions() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<DummyFileSystem> Upper = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // merged directories get the permissions of the upper dir
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Upper/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Upper))); $c$.clean();
    
    ErrorOr<Status> Status/*J*/= new ErrorOr<Status>((new std.error_code()));
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/both"), fs.perms.owner_read);
    Upper.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/both"), $bitor_perms(/*KEEP_ENUM*/fs.perms.owner_all, /*KEEP_ENUM*/fs.perms.group_read));
    Status.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/both")));
    ASSERT_FALSE((Status.getError()).$bool());
    EXPECT_EQ(0740,Status.$arrow().getPermissions());
    
    // permissions (as usual) are not recursively applied
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/both/foo"), fs.perms.owner_read);
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/both/bar"), fs.perms.owner_write);
    Status.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/both/foo")));
    ASSERT_FALSE((Status.getError()).$bool());
    EXPECT_EQ(0400,Status.$arrow().getPermissions());
    Status.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"/both/bar")));
    ASSERT_FALSE((Status.getError()).$bool());
    EXPECT_EQ(0200,Status.$arrow().getPermissions());
  } finally {
    if (O != null) { O.$destroy(); }
    if (Upper != null) { Upper.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}

@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_BasicRealFSIteration_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 308,
 FQN="VirtualFileSystemTest_BasicRealFSIteration_Test::TestBody", NM="_ZN47VirtualFileSystemTest_BasicRealFSIteration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN47VirtualFileSystemTest_BasicRealFSIteration_Test8TestBodyEv")
//</editor-fold>
public void test_BasicRealFSIteration() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
  ScopedDir TestDirectory = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  ScopedDir _a = null;
  ScopedDir _ab = null;
  ScopedDir _c = null;
  ScopedDir _cd = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    TestDirectory/*J*/= new ScopedDir(new Twine(/*KEEP_STR*/"virtual-file-system-test"), /*Unique*/ true);
    FS = VfsGlobals.getRealFileSystem();
    
    std.error_code EC/*J*/= new std.error_code();
    directory_iterator I = FS.$arrow().dir_begin(new Twine(TestDirectory.$StringRef()), EC);
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ(new directory_iterator(),I);
    // empty directory is empty
    _a/*J*/= new ScopedDir($add_StringRef_char$ptr$C(TestDirectory.$StringRef(), /*KEEP_STR*/"/a"));
    _ab/*J*/= new ScopedDir($add_StringRef_char$ptr$C(TestDirectory.$StringRef(), /*KEEP_STR*/"/a/b"));
    _c/*J*/= new ScopedDir($add_StringRef_char$ptr$C(TestDirectory.$StringRef(), /*KEEP_STR*/"/c"));
    _cd/*J*/= new ScopedDir($add_StringRef_char$ptr$C(TestDirectory.$StringRef(), /*KEEP_STR*/"/c/d"));
    
    I.$assignMove(FS.$arrow().dir_begin(new Twine(TestDirectory.$StringRef()), EC));
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ(new directory_iterator(),I);
    // Check either a or c, since we can't rely on the iteration order.
    EXPECT_TRUE(I.$arrow().getName().endswith(/*STRINGREF_STR*/"a") || I.$arrow().getName().endswith(/*STRINGREF_STR*/"c"));
    I.increment(EC);
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ(new directory_iterator(),I);
    EXPECT_TRUE(I.$arrow().getName().endswith(/*STRINGREF_STR*/"a") || I.$arrow().getName().endswith(/*STRINGREF_STR*/"c"));
    I.increment(EC);
    EXPECT_EQ(new directory_iterator(),I);
  } finally {
    if (_cd != null) { _cd.$destroy(); }
    if (_c != null) { _c.$destroy(); }
    if (_ab != null) { _ab.$destroy(); }
    if (_a != null) { _a.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    if (TestDirectory != null) { TestDirectory.$destroy(); }
    $c$.$destroy();
  }
}

@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_BasicRealFSRecursiveIteration_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 335,
 FQN="VirtualFileSystemTest_BasicRealFSRecursiveIteration_Test::TestBody", NM="_ZN56VirtualFileSystemTest_BasicRealFSRecursiveIteration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN56VirtualFileSystemTest_BasicRealFSRecursiveIteration_Test8TestBodyEv")
//</editor-fold>
public void test_BasicRealFSRecursiveIteration() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
  ScopedDir TestDirectory = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  ScopedDir _a = null;
  ScopedDir _ab = null;
  ScopedDir _c = null;
  ScopedDir _cd = null;
  std.vectorString Contents = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    TestDirectory/*J*/= new ScopedDir(new Twine(/*KEEP_STR*/"virtual-file-system-test"), /*Unique*/ true);
    FS = VfsGlobals.getRealFileSystem();
    
    std.error_code EC/*J*/= new std.error_code();
    recursive_directory_iterator I = new recursive_directory_iterator(FS.$star(), new Twine(TestDirectory.$StringRef()), EC);
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ(new recursive_directory_iterator(),I);
    // empty directory is empty
    _a/*J*/= new ScopedDir($add_StringRef_char$ptr$C(TestDirectory.$StringRef(), /*KEEP_STR*/"/a"));
    _ab/*J*/= new ScopedDir($add_StringRef_char$ptr$C(TestDirectory.$StringRef(), /*KEEP_STR*/"/a/b"));
    _c/*J*/= new ScopedDir($add_StringRef_char$ptr$C(TestDirectory.$StringRef(), /*KEEP_STR*/"/c"));
    _cd/*J*/= new ScopedDir($add_StringRef_char$ptr$C(TestDirectory.$StringRef(), /*KEEP_STR*/"/c/d"));
    
    I = (new recursive_directory_iterator(FS.$star(), new Twine(TestDirectory.$StringRef()), EC));
    ASSERT_FALSE((EC).$bool());
    EXPECT_EQ(new recursive_directory_iterator(),I);
    
    Contents/*J*/= new std.vectorString(std.string.EMPTY);
    for (recursive_directory_iterator E = new recursive_directory_iterator(); !EC.$bool() && I.$noteq(E);
         I.increment(EC)) {
      Contents.push_back(I.$arrow().getName().$string());
    }
    
    // Check contents, which may be in any order
    EXPECT_EQ(4/*U*/,Contents.size());
    int Counts[/*4*/] = new$int(4, 0, 0, 0, 0);
    for (/*const*/std.string/*&*/ Name : Contents) {
    ASSERT_FALSE(Name.empty());
      int Index = Name.$at(Name.size() - 1) - $$a;
    ASSERT_TRUE(Index >= 0 && Index < 4);
      Counts[Index]++;
    }
    EXPECT_EQ(1,Counts[0]);
    // a
    EXPECT_EQ(1,Counts[1]);
    // b
    EXPECT_EQ(1,Counts[2]);
    // c
    EXPECT_EQ(1,Counts[3]);
  } finally {
    if (Contents != null) { Contents.$destroy(); }
    if (_cd != null) { _cd.$destroy(); }
    if (_c != null) { _c.$destroy(); }
    if (_ab != null) { _ab.$destroy(); }
    if (_a != null) { _a.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    if (TestDirectory != null) { TestDirectory.$destroy(); }
    $c$.$destroy();
  }
  // d
}

@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_OverlayIteration_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 394,
 FQN="VirtualFileSystemTest_OverlayIteration_Test::TestBody", NM="_ZN43VirtualFileSystemTest_OverlayIteration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN43VirtualFileSystemTest_OverlayIteration_Test8TestBodyEv")
//</editor-fold>
public void test_OverlayIteration() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<DummyFileSystem> Upper = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Upper/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Upper))); $c$.clean();
    
    std.error_code EC/*J*/= new std.error_code();
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC), new ArrayRef<StringRef>());
    
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/file1"));
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC), new ArrayRef<StringRef>(new StringRef(/*KEEP_STR*/"/file1")));
    
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/file2"));
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC), /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*2*/] {new StringRef("/file2"), new StringRef("/file1")})/* }*/);
    
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/dir1"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/dir1/foo"));
    Upper.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/dir2"));
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/dir2/foo"));
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/"/dir2"), EC), new ArrayRef<StringRef>(new StringRef(/*KEEP_STR*/"/dir2/foo")));
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC), /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*4*/] {new StringRef("/dir2"), new StringRef("/file2"), new StringRef("/dir1"), new StringRef("/file1")})/* }*/);
  } finally {
    if (O != null) { O.$destroy(); }
    if (Upper != null) { Upper.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_OverlayRecursiveIteration_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 418,
 FQN="VirtualFileSystemTest_OverlayRecursiveIteration_Test::TestBody", NM="_ZN52VirtualFileSystemTest_OverlayRecursiveIteration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN52VirtualFileSystemTest_OverlayRecursiveIteration_Test8TestBodyEv")
//</editor-fold>
public void test_OverlayRecursiveIteration() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<DummyFileSystem> Middle = null;
  IntrusiveRefCntPtr<DummyFileSystem> Upper = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Middle/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Upper/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Middle))); $c$.clean();
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Upper))); $c$.clean();
    
    std.error_code EC/*J*/= new std.error_code();
    checkContents(new recursive_directory_iterator(O.$star(), new Twine(/*KEEP_STR*/$SLASH), EC), 
        new ArrayRef<StringRef>());
    
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/file1"));
    checkContents(new recursive_directory_iterator(O.$star(), new Twine(/*KEEP_STR*/$SLASH), EC), 
        new ArrayRef<StringRef>(new StringRef(/*KEEP_STR*/"/file1")));
    
    Upper.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/dir"));
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/dir/file2"));
    checkContents(new recursive_directory_iterator(O.$star(), new Twine(/*KEEP_STR*/$SLASH), EC), 
        /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*3*/] {new StringRef("/dir"), new StringRef("/dir/file2"), new StringRef("/file1")})/* }*/);
    
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/dir1"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/dir1/foo"));
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/dir1/a"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/dir1/a/b"));
    Middle.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/a"));
    Middle.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/a/b"));
    Middle.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/a/b/c"));
    Middle.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/a/b/c/d"));
    Middle.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/hiddenByUp"));
    Upper.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"/dir2"));
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/dir2/foo"));
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/hiddenByUp"));
    checkContents(new recursive_directory_iterator(O.$star(), new Twine(/*KEEP_STR*/"/dir2"), EC), 
        new ArrayRef<StringRef>(new StringRef(/*KEEP_STR*/"/dir2/foo")));
    checkContents(new recursive_directory_iterator(O.$star(), new Twine(/*KEEP_STR*/$SLASH), EC), 
        /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*14*/] {
              new StringRef("/dir"), new StringRef("/dir/file2"), new StringRef("/dir2"), new StringRef("/dir2/foo"), new StringRef("/hiddenByUp"), 
              new StringRef("/a"), new StringRef("/a/b"), new StringRef("/a/b/c"), new StringRef("/a/b/c/d"), new StringRef("/dir1"), new StringRef("/dir1/a"), 
              new StringRef("/dir1/a/b"), new StringRef("/dir1/foo"), new StringRef("/file1")})/* }*/);
  } finally {
    if (O != null) { O.$destroy(); }
    if (Upper != null) { Upper.$destroy(); }
    if (Middle != null) { Middle.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_ThreeLevelIteration_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 460,
 FQN="VirtualFileSystemTest_ThreeLevelIteration_Test::TestBody", NM="_ZN46VirtualFileSystemTest_ThreeLevelIteration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN46VirtualFileSystemTest_ThreeLevelIteration_Test8TestBodyEv")
//</editor-fold>
public void test_ThreeLevelIteration() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<DummyFileSystem> Middle = null;
  IntrusiveRefCntPtr<DummyFileSystem> Upper = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Middle/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Upper/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Middle))); $c$.clean();
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Upper))); $c$.clean();
    
    std.error_code EC/*J*/= new std.error_code();
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC), new ArrayRef<StringRef>());
    
    Middle.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/file2"));
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC), new ArrayRef<StringRef>(new StringRef(/*KEEP_STR*/"/file2")));
    
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/file1"));
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/file3"));
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC), /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*3*/] {new StringRef("/file3"), new StringRef("/file2"), new StringRef("/file1")})/* }*/);
  } finally {
    if (O != null) { O.$destroy(); }
    if (Upper != null) { Upper.$destroy(); }
    if (Middle != null) { Middle.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VirtualFileSystemTest_HiddenInIteration_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 480,
 FQN="VirtualFileSystemTest_HiddenInIteration_Test::TestBody", NM="_ZN44VirtualFileSystemTest_HiddenInIteration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN44VirtualFileSystemTest_HiddenInIteration_Test8TestBodyEv")
//</editor-fold>
public void test_HiddenInIteration() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<DummyFileSystem> Middle = null;
  IntrusiveRefCntPtr<DummyFileSystem> Upper = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Middle/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Upper/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Middle))); $c$.clean();
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(Upper))); $c$.clean();
    
    std.error_code EC/*J*/= new std.error_code();
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/onlyInLow"), fs.perms.owner_read);
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/hiddenByMid"), fs.perms.owner_read);
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/hiddenByUp"), fs.perms.owner_read);
    Middle.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/onlyInMid"), fs.perms.owner_write);
    Middle.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/hiddenByMid"), fs.perms.owner_write);
    Middle.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/hiddenByUp"), fs.perms.owner_write);
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/onlyInUp"), fs.perms.owner_all);
    Upper.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"/hiddenByUp"), fs.perms.owner_all);
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), EC), 
        /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*5*/] {new StringRef("/hiddenByUp"), new StringRef("/onlyInUp"), new StringRef("/hiddenByMid"), new StringRef("/onlyInMid"), new StringRef("/onlyInLow")})/* }*/);
    {
      std.error_code _EC/*J*/= new std.error_code();
      directory_iterator I = O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), _EC), E/*J*/= new directory_iterator();
      for (; !_EC.$bool() && I.$noteq(E); I.increment(_EC))  {
        if ($eq_StringRef(I.$arrow().getName(), /*STRINGREF_STR*/"/hiddenByUp")) {
          break;
        }
      }
    EXPECT_EQ(E,I);
    EXPECT_EQ(fs.perms.owner_all,I.$arrow().getPermissions());
    }
    {
      std.error_code _EC/*J*/= new std.error_code();
      directory_iterator I = O.$arrow().dir_begin(new Twine(/*KEEP_STR*/$SLASH), _EC), E/*J*/= new directory_iterator();
      for (; !_EC.$bool() && I.$noteq(E); I.increment(_EC))  {
        if ($eq_StringRef(I.$arrow().getName(), /*STRINGREF_STR*/"/hiddenByMid")) {
          break;
        }
      }
    EXPECT_EQ(E,I);
    EXPECT_EQ(fs.perms.owner_write,I.$arrow().getPermissions());
    }
  } finally {
    if (O != null) { O.$destroy(); }
    if (Upper != null) { Upper.$destroy(); }
    if (Middle != null) { Middle.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


} // END OF class VirtualFileSystemTest

