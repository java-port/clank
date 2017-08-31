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

import static org.clang.basic.VirtualFileSystemTest.checkContents;
import org.clang.basic.vfs.File;
import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.OverlayFileSystem;
import org.clang.basic.vfs.Status;
import org.clank.java.std;
import org.clank.support.JavaCleaner;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.literal_constants.$EMPTY;
import static org.clank.support.literal_constants.$LSQUARE_RSQUARE;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.support.ErrorOr;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.SMDiagnostic;
import org.junit.Test;
import static org.clang.basic.vfs.VfsGlobals.getVFSFromYAML;
import org.clang.basic.vfs.recursive_directory_iterator;
import org.clank.java.std_errors.errc;
import static org.clank.java.std.unique_ptr;
import org.llvm.adt.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.sys.*;
import org.clank.support.JavaDifferentiators.*;

/**
 * extracted VFSFromYAMLTest part:
 * corresponds to $LLVM_SRC/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp
 * @author Vladimir Voskresensky
 */

// NOTE: in the tests below, we use '//root/' as our root directory, since it is
// a legal *absolute* path on Windows as well as *nix.
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 659,
 FQN="VFSFromYAMLTest", NM="_Z15VFSFromYAMLTest",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_Z15VFSFromYAMLTest")
//</editor-fold>
public class VFSFromYAMLTest extends FileSystemTestBase {
/*public:*/
  public int NumDiagnostics;
  
  //<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest::SetUp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 663,
   FQN="VFSFromYAMLTest::SetUp", NM="_ZN15VFSFromYAMLTest5SetUpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN15VFSFromYAMLTest5SetUpEv")
  //</editor-fold>
  @Override public void SetUp()/* override*/ {
    NumDiagnostics = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest::CountingDiagHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 665,
   FQN="VFSFromYAMLTest::CountingDiagHandler", NM="_ZN15VFSFromYAMLTest19CountingDiagHandlerERKN4llvm12SMDiagnosticEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN15VFSFromYAMLTest19CountingDiagHandlerERKN4llvm12SMDiagnosticEPv")
  //</editor-fold>
  public static void CountingDiagHandler(/*const*/ SMDiagnostic /*&*/ $Prm0, Object/*void P*/ Context) {
    VFSFromYAMLTest /*P*/ Test = ((/*static_cast*/VFSFromYAMLTest /*P*/ )(Context));
    ++Test.NumDiagnostics;
  }

  
  //<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest::getFromYAMLRawString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 670,
   FQN="VFSFromYAMLTest::getFromYAMLRawString", NM="_ZN15VFSFromYAMLTest20getFromYAMLRawStringEN4llvm9StringRefENS0_18IntrusiveRefCntPtrIN5clang3vfs10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN15VFSFromYAMLTest20getFromYAMLRawStringEN4llvm9StringRefENS0_18IntrusiveRefCntPtrIN5clang3vfs10FileSystemEEE")
  //</editor-fold>
  public IntrusiveRefCntPtr<FileSystem> getFromYAMLRawString(StringRef Content, 
                      IntrusiveRefCntPtr<FileSystem> ExternalFS) {
    std.unique_ptr<MemoryBuffer> Buffer = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Buffer = MemoryBuffer.getMemBuffer(new StringRef(Content));
      return $c$.clean(getVFSFromYAML($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(Buffer))), VFSFromYAMLTest::CountingDiagHandler, new StringRef(/*KEEP_STR*/$EMPTY), this, 
          $c$.track(new IntrusiveRefCntPtr<FileSystem>(ExternalFS))));
    } finally {
      if (Buffer != null) { Buffer.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest::getFromYAMLString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 678,
   FQN="VFSFromYAMLTest::getFromYAMLString", NM="_ZN15VFSFromYAMLTest17getFromYAMLStringEN4llvm9StringRefENS0_18IntrusiveRefCntPtrIN5clang3vfs10FileSystemEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN15VFSFromYAMLTest17getFromYAMLStringEN4llvm9StringRefENS0_18IntrusiveRefCntPtrIN5clang3vfs10FileSystemEEE")
  //</editor-fold>
  public IntrusiveRefCntPtr<FileSystem> getFromYAMLString(StringRef Content) {
    return getFromYAMLString(Content, 
                   new IntrusiveRefCntPtr<FileSystem>(new DummyFileSystem()));
  }
  public IntrusiveRefCntPtr<FileSystem> getFromYAMLString(StringRef Content, 
                   IntrusiveRefCntPtr<FileSystem> ExternalFS/*= new DummyFileSystem()*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string VersionPlusContent/*J*/= new std.string(/*KEEP_STR*/"{\n  'version':0,\n");
      $addassign_str_StringRef(VersionPlusContent, Content.slice(Content.find($$LCURLY) + 1, StringRef.npos));
      return $c$.clean(getFromYAMLRawString(new StringRef(VersionPlusContent), $c$.track(new IntrusiveRefCntPtr<FileSystem>(ExternalFS))));
    } finally {
      $c$.$destroy();
    }
  }

  
  // This is intended as a "XFAIL" for windows hosts.
  //<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest::supportsSameDirMultipleYAMLEntries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 687,
   FQN="VFSFromYAMLTest::supportsSameDirMultipleYAMLEntries", NM="_ZN15VFSFromYAMLTest34supportsSameDirMultipleYAMLEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN15VFSFromYAMLTest34supportsSameDirMultipleYAMLEntriesEv")
  //</editor-fold>
  public boolean supportsSameDirMultipleYAMLEntries() {
    Triple Host/*J*/= new Triple(new Twine(Triple.normalize(new StringRef(sys.getProcessTriple()))));
    return !Host.isOSWindows();
  }

  //<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest::~VFSFromYAMLTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 659,
   FQN="VFSFromYAMLTest::~VFSFromYAMLTest", NM="_ZN15VFSFromYAMLTestD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN15VFSFromYAMLTestD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest::VFSFromYAMLTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 659,
   FQN="VFSFromYAMLTest::VFSFromYAMLTest", NM="_ZN15VFSFromYAMLTestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN15VFSFromYAMLTestC1Ev")
  //</editor-fold>
  public /*inline*/ VFSFromYAMLTest() {
    /* : ::Test()*/ 
    //START JInit
    super(TestState.Successful);
    //END JInit
  }

  
  public String toString() {
    return "" + "NumDiagnostics=" + NumDiagnostics // NOI18N
              + super.toString(); // NOI18N
  }

  @Override
  public void tearDown() {
    $destroy();
    super.tearDown();
  }
  

@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_BasicVFSFromYAML_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 693,
 FQN="VFSFromYAMLTest_BasicVFSFromYAML_Test::TestBody", NM="_ZN37VFSFromYAMLTest_BasicVFSFromYAML_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN37VFSFromYAMLTest_BasicVFSFromYAML_Test8TestBodyEv")
//</editor-fold>
public void test_BasicVFSFromYAML() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<FileSystem> FS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FS/*J*/= new IntrusiveRefCntPtr<FileSystem>();
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/$EMPTY)))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/$LSQUARE_RSQUARE)))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"'string'")))));
    EXPECT_EQ(null,FS.get());
    EXPECT_EQ(3,NumDiagnostics);
  } finally {
    if (FS != null) { FS.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_MappedFiles_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 704,
 FQN="VFSFromYAMLTest_MappedFiles_Test::TestBody", NM="_ZN32VFSFromYAMLTest_MappedFiles_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN32VFSFromYAMLTest_MappedFiles_Test8TestBodyEv")
//</editor-fold>
public void test_MappedFiles() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  ErrorOr<unique_ptr<File> > OpenedF = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/foo/bar/a"));
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
       "{ 'roots': [\n"
     + "{\n"
     + "  'type': 'directory',\n"
     + "  'name': '//root/',\n"
     + "  'contents': [ {\n"
     + "                  'type': 'file',\n"
     + "                  'name': 'file1',\n"
     + "                  'external-contents': '//root/foo/bar/a'\n"
     + "                },\n"
     + "                {\n"
     + "                  'type': 'file',\n"
     + "                  'name': 'file2',\n"
     + "                  'external-contents': '//root/foo/b'\n"
     + "                }\n"
     + "              ]\n"
     + "}\n"
     + "]\n"
     + "}"
    ), 
        $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(FS.get() != null);
    
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(FS))); $c$.clean();
    
    // file
    ErrorOr<Status> S = O.$arrow().status(new Twine(/*KEEP_STR*/"//root/file1"));
    ASSERT_FALSE((S.getError()).$bool());
    EXPECT_EQ("//root/foo/bar/a",S.$arrow().getName());
    EXPECT_TRUE(S.$arrow().IsVFSMapped);
    
    ErrorOr<Status> SLower = O.$arrow().status(new Twine(/*KEEP_STR*/"//root/foo/bar/a"));
    EXPECT_EQ("//root/foo/bar/a",SLower.$arrow().getName());
    EXPECT_TRUE(S.$arrow().equivalent(SLower.$star()));
    EXPECT_FALSE((SLower.$arrow().IsVFSMapped));
    
    // file after opening
    OpenedF = O.$arrow().openFileForRead(new Twine(/*KEEP_STR*/"//root/file1"));
    ASSERT_FALSE((OpenedF.getError()).$bool());
    ErrorOr<Status> OpenedS = (OpenedF.$star()).$arrow().status();
    ASSERT_FALSE((OpenedS.getError()).$bool());
    EXPECT_EQ("//root/foo/bar/a",OpenedS.$arrow().getName());
    EXPECT_TRUE(OpenedS.$arrow().IsVFSMapped);
    
    // directory
    S.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"//root/")));
    ASSERT_FALSE((S.getError()).$bool());
    EXPECT_TRUE(S.$arrow().isDirectory());
    EXPECT_TRUE(S.$arrow().equivalent(O.$arrow().status(new Twine(/*KEEP_STR*/"//root/")).$star()));
    // non-volatile UniqueID
    
    // broken mapping
    EXPECT_EQ(O.$arrow().status(new Twine(/*KEEP_STR*/"//root/file2")).getError(),errc.no_such_file_or_directory);
    EXPECT_EQ(0, NumDiagnostics);
  } finally {
    if (OpenedF != null) { OpenedF.$destroy(); }
    if (O != null) { O.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_CaseInsensitive_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 764,
 FQN="VFSFromYAMLTest_CaseInsensitive_Test::TestBody", NM="_ZN36VFSFromYAMLTest_CaseInsensitive_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN36VFSFromYAMLTest_CaseInsensitive_Test8TestBodyEv")
//</editor-fold>
public void test_CaseInsensitive() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/foo/bar/a"));
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
        "{ 'case-sensitive': 'false',\n"
      + "  'roots': [\n"
      + "{\n"
      + "  'type': 'directory',\n"
      + "  'name': '//root/',\n"
      + "  'contents': [ {\n"
      + "                  'type': 'file',\n"
      + "                  'name': 'XX',\n"
      + "                  'external-contents': '//root/foo/bar/a'\n"
      + "                }\n"
      + "              ]\n"
      + "}]}"
    ), 
        $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(FS.get() != null);
    
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(FS))); $c$.clean();
    
    ErrorOr<Status> S = O.$arrow().status(new Twine(/*KEEP_STR*/"//root/XX"));
    ASSERT_FALSE((S.getError()).$bool());
    
    ErrorOr<Status> SS = O.$arrow().status(new Twine(/*KEEP_STR*/"//root/xx"));
    ASSERT_FALSE((SS.getError()).$bool());
    EXPECT_TRUE(S.$arrow().equivalent(SS.$star()));
    SS.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"//root/xX")));
    EXPECT_TRUE(S.$arrow().equivalent(SS.$star()));
    SS.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"//root/Xx")));
    EXPECT_TRUE(S.$arrow().equivalent(SS.$star()));
    EXPECT_EQ(0, NumDiagnostics);
  } finally {
    if (O != null) { O.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_CaseSensitive_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 800,
 FQN="VFSFromYAMLTest_CaseSensitive_Test::TestBody", NM="_ZN34VFSFromYAMLTest_CaseSensitive_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN34VFSFromYAMLTest_CaseSensitive_Test8TestBodyEv")
//</editor-fold>
public void test_CaseSensitive() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/foo/bar/a"));
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
      "{ 'case-sensitive': 'true',\n"
    + "  'roots': [\n"
    + "{\n"
    + "  'type': 'directory',\n"
    + "  'name': '//root/',\n"
    + "  'contents': [ {\n"
    + "                  'type': 'file',\n"
    + "                  'name': 'XX',\n"
    + "                  'external-contents': '//root/foo/bar/a'\n"
    + "                }\n"
    + "              ]\n"
    + "}]}"
    ), 
        $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(FS.get() != null);
    
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(FS))); $c$.clean();
    
    ErrorOr<Status> SS = O.$arrow().status(new Twine(/*KEEP_STR*/"//root/xx"));
    EXPECT_EQ(SS.getError(),errc.no_such_file_or_directory);
    SS.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"//root/xX")));
    EXPECT_EQ(SS.getError(),errc.no_such_file_or_directory);
    SS.$assignMove(O.$arrow().status(new Twine(/*KEEP_STR*/"//root/Xx")));
    EXPECT_EQ(SS.getError(),errc.no_such_file_or_directory);
    EXPECT_EQ(0, NumDiagnostics);
  } finally {
    if (O != null) { O.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_IllegalVFSFile_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 832,
 FQN="VFSFromYAMLTest_IllegalVFSFile_Test::TestBody", NM="_ZN35VFSFromYAMLTest_IllegalVFSFile_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN35VFSFromYAMLTest_IllegalVFSFile_Test8TestBodyEv")
//</editor-fold>
public void test_IllegalVFSFile() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    
    // invalid YAML at top-level
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/"{]"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    EXPECT_EQ(null,FS.get());
    // invalid YAML in roots
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[}"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    // invalid YAML in directory
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'name': 'foo', 'type': 'directory', 'contents': [}"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    
    // invalid configuration
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'knobular': 'true', 'roots':[] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'case-sensitive': 'maybe', 'roots':[] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    
    // invalid roots
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':'' }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':{} }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    
    // invalid entries
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'type': 'other', 'name': 'me', 'contents': '' }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'type': 'file', 'name': [], 'external-contents': 'other' }"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'type': 'file', 'name': 'me', 'external-contents': [] }"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'type': 'file', 'name': 'me', 'external-contents': {} }"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'type': 'directory', 'name': 'me', 'contents': {} }"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'type': 'directory', 'name': 'me', 'contents': '' }"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'thingy': 'directory', 'name': 'me', 'contents': [] }"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    
    // missing mandatory fields
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'type': 'file', 'name': 'me' }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'type': 'file', 'external-contents': 'other' }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[ { 'name': 'me', 'contents': [] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    
    // duplicate keys
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[], 'roots':[] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'case-sensitive':'true', 'case-sensitive':'true', 'roots':[] }"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots':[{'name':'me', 'name':'you', 'type':'file', 'external-contents':'blah' } ] }"), 
            $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    
    // missing version
    $c$.clean(FS.$assign($c$.track(getFromYAMLRawString(new StringRef(/*KEEP_STR*/"{ 'roots':[] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    
    // bad version number
    $c$.clean(FS.$assign($c$.track(getFromYAMLRawString(new StringRef(/*KEEP_STR*/"{ 'version':'foo', 'roots':[] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLRawString(new StringRef(/*KEEP_STR*/"{ 'version':-1, 'roots':[] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    $c$.clean(FS.$assign($c$.track(getFromYAMLRawString(new StringRef(/*KEEP_STR*/"{ 'version':100000, 'roots':[] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    EXPECT_EQ(null,FS.get());
    EXPECT_EQ(24,NumDiagnostics);
  } finally {
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_UseExternalName_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 923,
 FQN="VFSFromYAMLTest_UseExternalName_Test::TestBody", NM="_ZN36VFSFromYAMLTest_UseExternalName_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN36VFSFromYAMLTest_UseExternalName_Test8TestBodyEv")
//</editor-fold>
public void test_UseExternalName() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/external/file"));
    
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
      "{ 'roots': [\n"
    + "  { 'type': 'file', 'name': '//root/A',\n"
    + "    'external-contents': '//root/external/file'\n"
    + "  },\n"
    + "  { 'type': 'file', 'name': '//root/B',\n"
    + "    'use-external-name': true,\n"
    + "    'external-contents': '//root/external/file'\n"
    + "  },\n"
    + "  { 'type': 'file', 'name': '//root/C',\n"
    + "    'use-external-name': false,\n"
    + "    'external-contents': '//root/external/file'\n"
    + "  }\n"
    + "] }"
    ), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(null != FS.get());
    
    // default true
    EXPECT_EQ("//root/external/file",FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/A")).$arrow().getName());
    // explicit
    EXPECT_EQ("//root/external/file",FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/B")).$arrow().getName());
    EXPECT_EQ("//root/C",FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/C")).$arrow().getName());
    
    // global configuration
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'use-external-names': false,\n  'roots': [\n  { 'type': 'file', 'name': '//root/A',\n    'external-contents': '//root/external/file'\n  },\n  { 'type': 'file', 'name': '//root/B',\n    'use-external-name': true,\n    'external-contents': '//root/external/file'\n  },\n  { 'type': 'file', 'name': '//root/C',\n    'use-external-name': false,\n    'external-contents': '//root/external/file'\n  }\n] }"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    ASSERT_TRUE(null != FS.get());
    
    // default
    EXPECT_EQ("//root/A",FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/A")).$arrow().getName());
    // explicit
    EXPECT_EQ("//root/external/file",FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/B")).$arrow().getName());
    EXPECT_EQ("//root/C",FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/C")).$arrow().getName());
  } finally {
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_MultiComponentPath_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 974,
 FQN="VFSFromYAMLTest_MultiComponentPath_Test::TestBody", NM="_ZN39VFSFromYAMLTest_MultiComponentPath_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN39VFSFromYAMLTest_MultiComponentPath_Test8TestBodyEv")
//</editor-fold>
public void test_MultiComponentPath() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/other"));
    
    // file in roots
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
        "{ 'roots': [\n"
      + "  { 'type': 'file', 'name': '//root/path/to/file',\n"
      + "    'external-contents': '//root/other' }]\n"
      + "}"            
    ), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(null != FS.get());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path/to/file")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path/to")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/")).getError()).$bool());
    
    // at the start
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots': [\n  { 'type': 'directory', 'name': '//root/path/to',\n    'contents': [ { 'type': 'file', 'name': 'file',\n                    'external-contents': '//root/other' }]}]\n}"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    ASSERT_TRUE(null != FS.get());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path/to/file")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path/to")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/")).getError()).$bool());
    
    // at the end
    $c$.clean(FS.$assign($c$.track(getFromYAMLString(new StringRef(/*KEEP_STR*/"{ 'roots': [\n  { 'type': 'directory', 'name': '//root/',\n    'contents': [ { 'type': 'file', 'name': 'path/to/file',\n                    'external-contents': '//root/other' }]}]\n}"), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))))));
    ASSERT_TRUE(null != FS.get());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path/to/file")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path/to")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/")).getError()).$bool());
  } finally {
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_TrailingSlashes_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 1017,
 FQN="VFSFromYAMLTest_TrailingSlashes_Test::TestBody", NM="_ZN36VFSFromYAMLTest_TrailingSlashes_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN36VFSFromYAMLTest_TrailingSlashes_Test8TestBodyEv")
//</editor-fold>
public void test_TrailingSlashes() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/other"));
    
    // file in roots
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
        "{ 'roots': [\n"
      + "  { 'type': 'directory', 'name': '//root/path/to////',\n"
      + "    'contents': [ { 'type': 'file', 'name': 'file',\n"
      + "                    'external-contents': '//root/other' }]}]\n"
      + "}"            
      ), $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(null != FS.get());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path/to/file")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path/to")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/path")).getError()).$bool());
    EXPECT_FALSE((FS.$arrow().status(new Twine(/*KEEP_STR*/"//root/")).getError()).$bool());
  } finally {
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_DirectoryIteration_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 1035,
 FQN="VFSFromYAMLTest_DirectoryIteration_Test::TestBody", NM="_ZN39VFSFromYAMLTest_DirectoryIteration_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN39VFSFromYAMLTest_DirectoryIteration_Test8TestBodyEv")
//</editor-fold>
public void test_DirectoryIteration() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"//root/"));
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"//root/foo"));
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"//root/foo/bar"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/foo/bar/a"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/foo/bar/b"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/file3"));
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
          "{ 'use-external-names': false,\n"
        + "  'roots': [\n"
        + "{\n"
        + "  'type': 'directory',\n"
        + "  'name': '//root/',\n"
        + "  'contents': [ {\n"
        + "                  'type': 'file',\n"
        + "                  'name': 'file1',\n"
        + "                  'external-contents': '//root/foo/bar/a'\n"
        + "                },\n"
        + "                {\n"
        + "                  'type': 'file',\n"
        + "                  'name': 'file2',\n"
        + "                  'external-contents': '//root/foo/bar/b'\n"
        + "                }\n"
        + "              ]\n"
        + "}\n"
        + "]\n"
        + "}"            
    ), 
        $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(FS.get() != null);
    
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(FS))); $c$.clean();
    
    std.error_code EC/*J*/= new std.error_code();
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/"//root/"), EC), 
        /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*4*/] {new StringRef("//root/file1"), new StringRef("//root/file2"), new StringRef("//root/file3"), new StringRef("//root/foo")})/* }*/);
    
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/"//root/foo/bar"), EC), 
        /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*2*/] {new StringRef("//root/foo/bar/a"), new StringRef("//root/foo/bar/b")})/* }*/);
  } finally {
    if (O != null) { O.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_DirectoryIterationSameDirMultipleEntries_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 1078,
 FQN="VFSFromYAMLTest_DirectoryIterationSameDirMultipleEntries_Test::TestBody", NM="_ZN61VFSFromYAMLTest_DirectoryIterationSameDirMultipleEntries_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN61VFSFromYAMLTest_DirectoryIterationSameDirMultipleEntries_Test8TestBodyEv")
//</editor-fold>
public void test_DirectoryIterationSameDirMultipleEntries() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // https://llvm.org/bugs/show_bug.cgi?id=27725
    if (!supportsSameDirMultipleYAMLEntries()) {
      return;
    }
    
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"//root/zab"));
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"//root/baz"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/zab/a"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/zab/b"));
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
        "{ 'use-external-names': false,\n"
      + "  'roots': [\n"
      + "{\n"
      + "  'type': 'directory',\n"
      + "  'name': '//root/baz/',\n"
      + "  'contents': [ {\n"
      + "                  'type': 'file',\n"
      + "                  'name': 'x',\n"
      + "                  'external-contents': '//root/zab/a'\n"
      + "                }\n"
      + "              ]\n"
      + "},\n"
      + "{\n"
      + "  'type': 'directory',\n"
      + "  'name': '//root/baz/',\n"
      + "  'contents': [ {\n"
      + "                  'type': 'file',\n"
      + "                  'name': 'y',\n"
      + "                  'external-contents': '//root/zab/b'\n"
      + "                }\n"
      + "              ]\n"
      + "}\n"
      + "]\n"
      + "}"
    ), 
        $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(FS.get() != null);
    
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(FS))); $c$.clean();
    
    std.error_code EC/*J*/= new std.error_code();
    
    checkContents(O.$arrow().dir_begin(new Twine(/*KEEP_STR*/"//root/baz/"), EC), 
        /*{ */new ArrayRef<StringRef>(new /*const*/ StringRef [/*2*/] {new StringRef("//root/baz/x"), new StringRef("//root/baz/y")})/* }*/);
  } finally {
    if (O != null) { O.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}


@Test
//<editor-fold defaultstate="collapsed" desc="VFSFromYAMLTest_RecursiveDirectoryIterationLevel_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp", line = 1126,
 FQN="VFSFromYAMLTest_RecursiveDirectoryIterationLevel_Test::TestBody", NM="_ZN53VFSFromYAMLTest_RecursiveDirectoryIterationLevel_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Basic/VirtualFileSystemTest.cpp -nm=_ZN53VFSFromYAMLTest_RecursiveDirectoryIterationLevel_Test8TestBodyEv")
//</editor-fold>
public void test_RecursiveDirectoryIterationLevel() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  IntrusiveRefCntPtr<DummyFileSystem> Lower = null;
  IntrusiveRefCntPtr<FileSystem> FS = null;
  IntrusiveRefCntPtr<OverlayFileSystem> O = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    Lower/*J*/= new IntrusiveRefCntPtr<DummyFileSystem>(new DummyFileSystem());
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"//root/a"));
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"//root/a/b"));
    Lower.$arrow().addDirectory(new StringRef(/*KEEP_STR*/"//root/a/b/c"));
    Lower.$arrow().addRegularFile(new StringRef(/*KEEP_STR*/"//root/a/b/c/file"));
    FS = $c$.clean(getFromYAMLString(new StringRef(/*KEEP_STR*/
        "{ 'use-external-names': false,\n"
      + "  'roots': [\n"
      + "{\n"
      + "  'type': 'directory',\n"
      + "  'name': '//root/a/b/c/',\n"
      + "  'contents': [ {\n"
      + "                  'type': 'file',\n"
      + "                  'name': 'file',\n"
      + "                  'external-contents': '//root/a/b/c/file'\n"
      + "                }\n"
      + "              ]\n"
      + "},\n"
      + "]\n"
      + "}"
    ), 
        $c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower))));
    ASSERT_TRUE(FS.get() != null);
    
    O/*J*/= $c$.clean(new IntrusiveRefCntPtr<OverlayFileSystem>(new OverlayFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>(Lower)))));
    O.$arrow().pushOverlay($c$.track(new IntrusiveRefCntPtr<FileSystem>(FS))); $c$.clean();
    
    std.error_code EC/*J*/= new std.error_code();
    
    // Test recursive_directory_iterator level()
    recursive_directory_iterator I = new recursive_directory_iterator(O.$star(), new Twine(/*KEEP_STR*/"//root"), EC), E/*J*/= new recursive_directory_iterator();
    ASSERT_FALSE((EC).$bool());
    for (int l = 0; I.$noteq(E); I.increment(EC) , ++l) {
      ASSERT_FALSE((EC).$bool());
      EXPECT_EQ(I.level(),l);
    }
    EXPECT_EQ(I,E);
  } finally {
    if (O != null) { O.$destroy(); }
    if (FS != null) { FS.$destroy(); }
    if (Lower != null) { Lower.$destroy(); }
    $c$.$destroy();
  }
}
  
}
