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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.lex.impl.ScratchBufferStatics.*;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.StringRef.*;


/// ScratchBuffer - This class exposes a simple interface for the dynamic
/// construction of tokens.  This is used for builtin macros (e.g. __LINE__) as
/// well as token pasting, etc.
//<editor-fold defaultstate="collapsed" desc="clang::ScratchBuffer">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/ScratchBuffer.h", line = 25,
 FQN="clang::ScratchBuffer", NM="_ZN5clang13ScratchBufferE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp -nm=_ZN5clang13ScratchBufferE")
//</editor-fold>
public class ScratchBuffer implements Destructors.ClassWithDestructor {
  private final SourceManager /*&*/ SourceMgr;
  /*friend*/final BumpPtrAllocator Allocator = new BumpPtrAllocator();
  private char$ptr/*char P*/ CurBuffer;
  private /*SourceLocation*/int BufferStartLoc;
  private /*uint*/int BytesUsed;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ScratchBuffer::ScratchBuffer">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp", line = 24,
   FQN = "clang::ScratchBuffer::ScratchBuffer", NM = "_ZN5clang13ScratchBufferC1ERNS_13SourceManagerE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp -nm=_ZN5clang13ScratchBufferC1ERNS_13SourceManagerE")
  //</editor-fold>
  public ScratchBuffer(SourceManager /*&*/ SM) {
    /* : SourceMgr(SM), CurBuffer(0), BufferStartLoc()*/ 
    //START JInit
    this./*&*/SourceMgr=/*&*/SM;
    this.CurBuffer = null;
    this.BufferStartLoc = SourceLocation.getInvalid();
    //END JInit
    // Set BytesUsed so that the first call to getToken will require an alloc.
    BytesUsed = ScratchBufSize;
  }

  
  /// getToken - Splat the specified text into a temporary MemoryBuffer and
  /// return a SourceLocation that refers to the token.  This is just like the
  /// previous method, but returns a location that indicates the physloc of the
  /// token.
  
  /// getToken - Splat the specified text into a temporary MemoryBuffer and
  /// return a SourceLocation that refers to the token.  This is just like the
  /// method below, but returns a location that indicates the physloc of the
  /// token.
  //<editor-fold defaultstate="collapsed" desc="clang::ScratchBuffer::getToken">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp", line = 34,
   FQN="clang::ScratchBuffer::getToken", NM="_ZN5clang13ScratchBuffer8getTokenEPKcjRS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp -nm=_ZN5clang13ScratchBuffer8getTokenEPKcjRS2_")
  //</editor-fold>
  public /*SourceLocation*/int getToken(/*const*/char$ptr/*char P*/ Buf, /*uint*/int Len, 
          char$ptr/*const char P &*/ DestPtr) {
    assert DestPtr.$isNull() : "" + DestPtr;
    if ($greater_uint(BytesUsed + Len + 2, ScratchBufSize)) {
      AllocScratchBuffer(Len + 2);
    }
    
    // Prefix the token with a \n, so that it looks like it is the first thing on
    // its own virtual line in caret diagnostics.
    CurBuffer.$set(BytesUsed++, $$LF);
    
    // Return a pointer to the character data.
    DestPtr.$assign(CurBuffer); // JAVA PERF
    // shifted from the beginning of buffer by currently used bytes 
    DestPtr.$inc(BytesUsed);
    
    // Copy the token data into the buffer.
    memcpy(DestPtr.$array(), DestPtr.$index(), Buf, 0, Len);

    // Remember that we used these bytes.
    BytesUsed += Len + 1;
    
    // Add a NUL terminator to the token.  This keeps the tokens separated, in
    // case they get relexed, and puts them on their own virtual lines in case a
    // diagnostic points to one.
    CurBuffer.$set(BytesUsed - 1, $$TERM);
    
    return SourceLocation.$getLocWithOffset(BufferStartLoc, BytesUsed - Len - 1);
  }
  
  /// THIS IS THE COPY OF ABOVE METHOD for byte[]
  //<editor-fold defaultstate="collapsed" desc="clang::ScratchBuffer::getToken">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp", line = 34,
   FQN="clang::ScratchBuffer::getToken", NM="_ZN5clang13ScratchBuffer8getTokenEPKcjRS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp -nm=_ZN5clang13ScratchBuffer8getTokenEPKcjRS2_")
  //</editor-fold>
  public /*SourceLocation*/int getToken(/*const*/byte[]/*char P*/ Buf, int idx, /*uint*/int Len, char$ptr DestPtr) {
    assert DestPtr.$isNull() : "" + DestPtr;
    if ($greater_uint(BytesUsed + Len + 2, ScratchBufSize)) {
      AllocScratchBuffer(Len + 2);
    }
    
    // Prefix the token with a \n, so that it looks like it is the first thing on
    // its own virtual line in caret diagnostics.
    CurBuffer.$set(BytesUsed++, $$LF);
    
    // Return a pointer to the character data.
    assert DestPtr != null && (CurBuffer.getClass().isAssignableFrom(DestPtr.getClass())) : "non assignable " + CurBuffer + " for " + DestPtr;
    DestPtr.$assign(CurBuffer);
    // shifted from the beginning of buffer by currently used bytes 
    DestPtr.$inc(BytesUsed);
    
    // Copy the token data into the buffer.
    memcpy(DestPtr.$array(), DestPtr.$index(), Buf, idx, Len);

    // Remember that we used these bytes.
    BytesUsed += Len + 1;
    
    // Add a NUL terminator to the token.  This keeps the tokens separated, in
    // case they get relexed, and puts them on their own virtual lines in case a
    // diagnostic points to one.
    CurBuffer.$set(BytesUsed - 1, $$TERM);
    
    return SourceLocation.$getLocWithOffset(BufferStartLoc, BytesUsed - Len - 1);
  }
  
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ScratchBuffer::AllocScratchBuffer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp", line = 60,
   FQN = "clang::ScratchBuffer::AllocScratchBuffer", NM = "_ZN5clang13ScratchBuffer18AllocScratchBufferEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ScratchBuffer.cpp -nm=_ZN5clang13ScratchBuffer18AllocScratchBufferEj")
  //</editor-fold>
  private void AllocScratchBuffer(/*uint*/int RequestLen) {
    // JAVA: remove cleaner
    std.unique_ptr<MemoryBuffer> OwnBuf = null;
    // Only pay attention to the requested length if it is larger than our default
    // page size.  If it is, we allocate an entire chunk for it.  This is to
    // support gigantic tokens, which almost certainly won't happen. :)
    if ($less_uint(RequestLen, ScratchBufSize)) {
      RequestLen = ScratchBufSize;
    }

    // Get scratch buffer. Zero-initialize it so it can be dumped into a PCH file
    // deterministically.
    OwnBuf = MemoryBuffer.getNewMemBuffer(this.Allocator, RequestLen, R$scratch_space_marker); // JAVA: use constant
    MemoryBuffer /*&*/ Buf = OwnBuf.$star();
    // JAVA: removed cleaner
    int FID = SourceMgr.createFileID(OwnBuf);
    BufferStartLoc = SourceMgr.getLocForStartOfFile(FID);
    CurBuffer = $tryClone(((/*const_cast*/char$ptr/*char P*/ )(Buf.getBufferStart())));
    BytesUsed = 0;
  }
  
  public void $destroy() {
    Allocator.$destroy();
  }
  
  public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              + ", CurBuffer=" + CurBuffer // NOI18N
              + ", BufferStartLoc=" + BufferStartLoc // NOI18N
              + ", BytesUsed=" + BytesUsed; // NOI18N
  }  
}
