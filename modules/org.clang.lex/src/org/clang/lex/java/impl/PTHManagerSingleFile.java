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

package org.clang.lex.java.impl;

import org.clang.lex.java.impl.PTHStringIdLookup;
import org.clang.lex.java.PTHManagerDriver;
import org.clang.basic.FileSystemStatCache;
import org.clang.basic.IdentifierInfo;
import org.clang.basic.IdentifierIterator;
import org.clang.lex.PTHLexer;
import org.clang.lex.PTHManager;
import static org.clank.java.std.strlen;
import org.clank.java.std_ptr;
import static org.clank.support.Casts.$char;
import org.clank.support.Converted;
import static org.clank.support.NativeType.sizeof$uint32;
import org.clank.support.aliases.char$ptr;
import org.llvm.adt.StringRef;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.llvm;
import static org.llvm.support.llvm.support.aligned;

/**
 * PTHManager to handle just one cached file and delegating IdentifierInfo 
 * creation to parent PTHManagerDriver.
 * @author Vladimir Voskresensky
 */
public final class PTHManagerSingleFile extends PTHManager {

  private final PTHManagerDriver parentManager;

  public PTHManagerSingleFile(PTHManagerDriver parentManager,
          /*const*/MemoryBuffer buf,
          PTHFileLookup fileLookup, /*const*/ char$ptr/*uchar P*/ idDataTable,
          IdentifierInfo /*P*/[] perIDCache,
          PTHStringIdLookup stringIdLookup, /*uint*/int numIds,
          /*const*/ char$ptr/*uchar P*/ spellingBase, /*const*/ char$ptr/*char P*/ originalSourceFile) {
    super(buf, fileLookup, idDataTable, perIDCache, stringIdLookup, numIds, spellingBase, originalSourceFile);
    assert parentManager != null;
    this.parentManager = parentManager;
  }

  @Override
  public PTHLexer CreateLexer(int FID) {
    // must be always successful 
    assert PP != null : "have you forgot to call setPreprocessor after initialization of this PTHManager?";
    PTHLexer Lexer = super.CreateLexer(FID);
    assert Lexer != null : "can not create Lexer for " + FID;
    return Lexer;
  }

  @Override
  public IdentifierInfo GetIdentifierInfo(int PersistentID) {
    // Check if the IdentifierInfo has already been resolved.
    IdentifierInfo /*P*/ II = PerIDCache[(int)PersistentID];
    if ((II != null)) {
      return II;
    }
    // ask from PP using ID spelling stored in PTH
    IdentifierInfo ppII = LazilyCreateIdentifierInfo(PersistentID);
    return ppII;
  }

  @Override
  public std_ptr.unique_ptr<FileSystemStatCache> createStatCache() {
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public IdentifierInfo get(char$ptr Name, int Len) {
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public IdentifierInfo get(byte[] Name, int NameStIndex, int Len) {
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public char$ptr getOriginalSourceFile() {
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public IdentifierIterator getIdentifiers() {
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public boolean equals(Object obj) {
    throw new UnsupportedOperationException("Should not be called");
  }

  @Override
  public int hashCode() {
    throw new UnsupportedOperationException("Should not be called");
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // 
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::LazilyCreateIdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED, optimized = Converted.Optimization.COMPLEX, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 559,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 560,
   FQN = "clang::PTHManager::LazilyCreateIdentifierInfo", NM = "_ZN5clang10PTHManager26LazilyCreateIdentifierInfoEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager26LazilyCreateIdentifierInfoEj")
  //</editor-fold>
  private IdentifierInfo /*P*/ LazilyCreateIdentifierInfo(/*uint*/int PersistentID) {
    assert true : "This is the light copy of LazilyCreateIdentifierInfo";
    
    // Look in the PTH file for the string data for the IdentifierInfo object.
    /*const*/int/*uchar P*/ TableEntry = /*IdDataTable.$add*/(sizeof$uint32() * PersistentID);
    char$ptr bufferStart = Buf.getBufferStart();
    byte[] $IDSpellingBuffer = bufferStart.$array();
    /*const*/int/*uchar P*/ IDSpellingDataOffset = bufferStart.$index() +
            /*Buf.getBufferStart().$add*/(llvm.support.endian.read_uint32(llvm.support.endianness.little, aligned, IdDataTable, TableEntry));
                                             // PERF: TableEntry += sizeof$uint32();//shift index
    assert (IDSpellingDataOffset < (Buf.getBufferEnd().$index())) : (IDSpellingDataOffset) + " vs. " + Buf.getBufferEnd().$index();
    
    assert ($IDSpellingBuffer[IDSpellingDataOffset] != '\0');
    // Len is encoded in the previous two bytes according to PTHIdentifierTableTrait.EmitKeyDataLength
    assert IDSpellingDataOffset >= 2 : "must have two bytes prefix with len " + IDSpellingDataOffset;
    int Len = ($char($IDSpellingBuffer[IDSpellingDataOffset-2]) | ($char($IDSpellingBuffer[IDSpellingDataOffset-1]) << 8)) - 1;
    
    assert strlen($IDSpellingBuffer, IDSpellingDataOffset) == Len : "check wasn't here, but could it be non null-termed string?" + Len + " vs. " + new StringRef($IDSpellingBuffer, IDSpellingDataOffset, Len);

    // use spelling to lookup real II
    IdentifierInfo ppII = parentManager.getPPIdentifierInfo($IDSpellingBuffer, IDSpellingDataOffset, Len);
    // Store the new IdentifierInfo in the cache.
    PerIDCache[PersistentID] = ppII;
    return ppII;
  }
  
  @Override
  public String toString() {
    return "PTHManagerSingleFile{" + super.toString() + '}';
  }
    
}
