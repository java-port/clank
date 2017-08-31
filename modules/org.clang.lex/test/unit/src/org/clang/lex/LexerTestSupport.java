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

package org.clang.lex;

import org.clang.basic.DirectoryEntry;
import org.clang.basic.FileEntry;
import org.clang.basic.FileManager;
import org.clang.basic.SourceLocation;
import org.clang.basic.SourceManager;
import org.clang.basic.SrcMgr;
import org.clank.support.Converted;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.StringRef;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.sys.path;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class LexerTestSupport {

  public LexerTestSupport() {
  }
  
  public static void PrepareMainFileWithContent(String testName, FileManager FileMgr, SourceManager SourceMgr, StringRef SourceText) {
    // prepare FileEntry for source content
    StringRef sourceFileName = new StringRef(testName);
    FileEntry virtualSourceFile = FileMgr.getVirtualFile(sourceFileName, 0, 0);
    assert virtualSourceFile != null;
    MemoryBuffer /*P*/ Buf = MemoryBuffer.getMemBuffer(new StringRef(SourceText), sourceFileName).release();
    SourceMgr.overrideFileContents(virtualSourceFile, Buf, false);
    
    int mainFileID = SourceMgr.createFileID(virtualSourceFile, SourceLocation.getInvalid(), SrcMgr.CharacteristicKind.C_User);
    SourceMgr.setMainFileID(mainFileID);
    FileEntry mainFileEntry = SourceMgr.getFileEntryForID(SourceMgr.getMainFileID());
    assert mainFileEntry == virtualSourceFile;
  }

  // Register a header path as a known file and add its location
  // to search path.
  //<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PPCallbacksTest::AddFakeHeader">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp", line = 135,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/unittests/Lex/PPCallbacksTest.cpp -filter=__anonymous_namespace::PPCallbacksTest::AddFakeHeader")
  //</editor-fold>
  public static void AddFakeHeader(
          FileManager FileMgr, SourceManager SourceMgr,
          HeaderSearch /*&*/ HeaderInfo, /*const*/char$ptr/*char P*/ HeaderPath, StringRef HeaderContent, boolean IsSystemHeader) {
    // Tell FileMgr about header.
    FileEntry virtualFile = FileMgr.getVirtualFile(new StringRef(HeaderPath), 0, 0);
    // JAVA FIX: add empty content for fake file
    assert virtualFile != null;
    SourceMgr.overrideFileContents(virtualFile, MemoryBuffer.getMemBuffer(HeaderContent));
    
    // Add header's parent path to search path.
    StringRef SearchPath = path.parent_path(new StringRef(HeaderPath));
    /*const*/DirectoryEntry /*P*/ DE = FileMgr.getDirectory(SearchPath);
    DirectoryLookup DL/*J*/= new DirectoryLookup(DE, SrcMgr.CharacteristicKind.C_User, false);
    HeaderInfo.AddSearchPath(DL, IsSystemHeader);
  }  
}
