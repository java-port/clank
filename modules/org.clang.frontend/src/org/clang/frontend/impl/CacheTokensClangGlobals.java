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
package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type CacheTokensClangGlobals">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*new method*/,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN5clang11CacheTokensERNS_12PreprocessorEPN4llvm17raw_pwrite_streamE; -static-type=CacheTokensClangGlobals -package=org.clang.frontend.impl")
//</editor-fold>
public final class CacheTokensClangGlobals {

// JAVA: introduced new method to allow caching only one FileEntry
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static void CacheTokens(Preprocessor /*&*/ PP, raw_fd_ostream /*P*/ OS, /*FileID*/int FID, 
        std.string MainFilePath, boolean needComments, boolean needIncompleteTokenState) {
  PTHWriter PW = null;
  try {
    // Create the PTHWriter.
    PW/*J*/= new PTHWriter(/*Deref*/OS, PP, needComments, needIncompleteTokenState);
    
    // Generate the PTH file.
    PW.GeneratePTH(MainFilePath, FID);
  } finally {
    if (PW != null) { PW.$destroy(); }
  }
}

/// Cache tokens for use with PCH. Note that this requires a seekable stream.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::CacheTokens">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 573,
 FQN="clang::CacheTokens", NM="_ZN5clang11CacheTokensERNS_12PreprocessorEPN4llvm17raw_pwrite_streamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN5clang11CacheTokensERNS_12PreprocessorEPN4llvm17raw_pwrite_streamE")
//</editor-fold>
public static void CacheTokens(Preprocessor /*&*/ PP, raw_pwrite_stream /*P*/ OS) {
  PTHWriter PW = null;
  unique_ptr<StatListener> StatCacheOwner = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Get the name of the main file.
    /*const*/ SourceManager /*&*/ SrcMgr = PP.getSourceManager();
    /*const*/ FileEntry /*P*/ MainFile = SrcMgr.getFileEntryForID(SrcMgr.getMainFileID());
    SmallString/*128*/ MainFilePath/*J*/= new SmallString/*128*/(new StringRef(MainFile.getName()), 128);
    
    fs.make_absolute(MainFilePath);
    
    // Create the PTHWriter.
    PW/*J*/= new PTHWriter(/*Deref*/OS, PP);
    
    // Install the 'stat' system call listener in the FileManager.
    StatCacheOwner = llvm.make_unique(new StatListener(PW.getPM()));
    StatListener /*P*/ StatCache = StatCacheOwner.get();
    PP.getFileManager().addStatCache($c$.track(new std.unique_ptr<FileSystemStatCache>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(StatCacheOwner))), 
        /*AtBeginning=*/ true); $c$.clean();
    
    // Lex through the entire file.  This will populate SourceManager with
    // all of the header information.
    Token Tok/*J*/= new Token();
    PP.EnterMainSourceFile();
    do {
      PP.Lex(Tok);
    } while (Tok.isNot(tok.TokenKind.eof));
    
    // Generate the PTH file.
    PP.getFileManager().removeStatCache(StatCache);
    PW.GeneratePTH(MainFilePath.str());
  } finally {
    if (StatCacheOwner != null) { StatCacheOwner.$destroy(); }
    if (PW != null) { PW.$destroy(); }
    $c$.$destroy();
  }
}

} // END OF class CacheTokensClangGlobals
