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

import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.InMemoryFileSystem;
import org.clank.support.JavaCleaner;
import static org.clank.support.Native.$createJavaCleaner;
import org.junit.Test;
import org.llvm.adt.ADTAliases;
import org.llvm.adt.ADTSupportTestBase;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.raw_string_ostream;

/**
 *
 * @author vv159170
 */
public class JavaInMemoryFSTest extends ADTSupportTestBase {
  
  @Test
  public void test_getOrCreateFileID_without_MainFileID() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    IntrusiveRefCntPtr<InMemoryFileSystem> InMemoryFileSystem = null;
    FileManager Files = null;
    DiagnosticsEngine Diagnostics = null;
    SourceManager SourceMgr = null;
    raw_string_ostream OS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      InMemoryFileSystem/*J*/= new IntrusiveRefCntPtr<InMemoryFileSystem>(new InMemoryFileSystem());
      Files/*J*/= $c$.clean(new FileManager(new FileSystemOptions(), $c$.track(new IntrusiveRefCntPtr<FileSystem>(ADTAliases.JD$IntrusiveRefCntPtr$X$C.INSTANCE, InMemoryFileSystem))));
      Diagnostics/*J*/= $c$.clean(new DiagnosticsEngine($c$.track(new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs())), 
          new DiagnosticOptions()));
      SourceMgr/*J*/= new SourceManager(Diagnostics, Files);
      final String CODE = "Some\nLines\n";
      final String FILE_NAME = "<stdin>";
      $c$.clean(InMemoryFileSystem.$arrow().addFile(new Twine(/*KEEP_STR*/FILE_NAME), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(CODE), new StringRef(/*KEEP_STR*/FILE_NAME)))));
      FileEntry stdin_file_1 = Files.getFile(new StringRef(/*KEEP_STR*/FILE_NAME));
      FileID ID = SourceMgr.createFileID(stdin_file_1, new SourceLocation(), SrcMgr.CharacteristicKind.C_User);
      FileEntry stdin_file_2 = SourceMgr.getFileManager().getFile(new StringRef(/*KEEP_STR*/FILE_NAME));
      ASSERT_TRUE(stdin_file_1 == stdin_file_2);
      // query without setting main file
      FileID ID_2 = SourceMgr.getOrCreateFileID(stdin_file_2, SrcMgr.CharacteristicKind.C_User);
      ASSERT_EQ(ID, ID_2);
      StringRef MB = SourceMgr.getBufferData(/*NO_COPY*/ID);
      ASSERT_EQ(CODE, MB);
    } finally {
      if (OS != null) { OS.$destroy(); }
      if (SourceMgr != null) { SourceMgr.$destroy(); }
      if (Diagnostics != null) { Diagnostics.$destroy(); }
      if (Files != null) { Files.$destroy(); }
      if (InMemoryFileSystem != null) { InMemoryFileSystem.$destroy(); }
      $c$.$destroy();
    }    
  }
}
