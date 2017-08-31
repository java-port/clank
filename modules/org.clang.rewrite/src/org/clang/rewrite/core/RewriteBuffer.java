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

package org.clang.rewrite.core;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.rewrite.impl.RewriterStatics.isWhitespaceExceptNL;


/// RewriteBuffer - As code is rewritten, SourceBuffer's from the original
/// input with modifications get a new RewriteBuffer associated with them.  The
/// RewriteBuffer captures the modified text itself as well as information used
/// to map between SourceLocation's in the original input and offsets in the
/// RewriteBuffer.  For example, if text is inserted into the buffer, any
/// locations after the insertion point have to be mapped.
//<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 27,
 FQN="clang::RewriteBuffer", NM="_ZN5clang13RewriteBufferE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBufferE")
//</editor-fold>
public class RewriteBuffer implements Destructors.ClassWithDestructor, Native.NativePOD<RewriteBuffer>, NativeMoveable<RewriteBuffer> {
  /*friend  class Rewriter*/
  /// Deltas - Keep track of all the deltas in the source code due to insertions
  /// and deletions.
  private DeltaTree Deltas;
  private RewriteRope Buffer;
/*public:*/
  /*typedef RewriteRope::const_iterator iterator*/
//  public final class iterator extends RopePieceBTreeIterator{ };
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 35,
   FQN="clang::RewriteBuffer::begin", NM="_ZNK5clang13RewriteBuffer5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang13RewriteBuffer5beginEv")
  //</editor-fold>
  public RopePieceBTreeIterator begin() /*const*/ {
    return Buffer.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 36,
   FQN="clang::RewriteBuffer::end", NM="_ZNK5clang13RewriteBuffer3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang13RewriteBuffer3endEv")
  //</editor-fold>
  public RopePieceBTreeIterator end() /*const*/ {
    return Buffer.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 37,
   FQN="clang::RewriteBuffer::size", NM="_ZNK5clang13RewriteBuffer4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang13RewriteBuffer4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Buffer.size();
  }

  
  /// Initialize - Start this rewrite buffer out with a copy of the unmodified
  /// input buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 41,
   FQN="clang::RewriteBuffer::Initialize", NM="_ZN5clang13RewriteBuffer10InitializeEPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer10InitializeEPKcS2_")
  //</editor-fold>
  public void Initialize(/*const*/char$ptr/*char P*/ BufStart, /*const*/char$ptr/*char P*/ BufEnd) {
    Buffer.assign(BufStart, BufEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::Initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 44,
   FQN="clang::RewriteBuffer::Initialize", NM="_ZN5clang13RewriteBuffer10InitializeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer10InitializeEN4llvm9StringRefE")
  //</editor-fold>
  public void Initialize(StringRef Input) {
    Initialize(Input.begin(), Input.end());
  }

  
  /// \brief Write to \p Stream the result of applying all changes to the
  /// original buffer.
  /// Note that it isn't safe to use this function to overwrite memory mapped
  /// files in-place (PR17960). Consider using a higher-level utility such as
  /// Rewriter::overwriteChangedFiles() instead.
  ///
  /// The original buffer is not actually changed.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 25,
   FQN="clang::RewriteBuffer::write", NM="_ZNK5clang13RewriteBuffer5writeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang13RewriteBuffer5writeERN4llvm11raw_ostreamE")
  //</editor-fold>
  public raw_ostream /*&*/ write(raw_ostream /*&*/ os) /*const*/ {
    // Walk RewriteRope chunks efficiently using MoveToNextPiece() instead of the
    // character iterator.
    for (RopePieceBTreeIterator I = begin(), E = end(); I.$noteq(E);
         I.MoveToNextPiece())  {
      os.$out(I.piece());
    }
    return os;
  }

  
  /// RemoveText - Remove the specified text.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::RemoveText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 49,
   FQN="clang::RewriteBuffer::RemoveText", NM="_ZN5clang13RewriteBuffer10RemoveTextEjjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer10RemoveTextEjjb")
  //</editor-fold>
  public void RemoveText(/*uint*/int OrigOffset, /*uint*/int Size) {
    RemoveText(OrigOffset, Size, 
            false);
  }
  public void RemoveText(/*uint*/int OrigOffset, /*uint*/int Size, 
            boolean removeLineIfEmpty/*= false*/) {
    // Nothing to remove, exit early.
    if (Size == 0) {
      return;
    }
    
    /*uint*/int RealOffset = getMappedOffset(OrigOffset, true);
    assert ($lesseq_uint(RealOffset + Size, Buffer.size())) : "Invalid location";
    
    // Remove the dead characters.
    Buffer.erase(RealOffset, Size);
    
    // Add a delta so that future changes are offset correctly.
    AddReplaceDelta(OrigOffset, -Size);
    if (removeLineIfEmpty) {
      // Find the line that the remove occurred and if it is completely empty
      // remove the line as well.
      RopePieceBTreeIterator curLineStart = begin();
      /*uint*/int curLineStartOffs = 0;
      RopePieceBTreeIterator posI = begin();
      for (/*uint*/int i = 0; i != RealOffset; ++i) {
        if (posI.$star() == $$LF) {
          curLineStart.$assign(posI);
          curLineStart.$preInc();
          curLineStartOffs = i + 1;
        }
        posI.$preInc();
      }
      
      /*uint*/int lineSize = 0;
      posI.$assign(curLineStart);
      while (posI.$noteq(end()) && isWhitespaceExceptNL(posI.$star())) {
        posI.$preInc();
        ++lineSize;
      }
      if (posI.$noteq(end()) && posI.$star() == $$LF) {
        Buffer.erase(curLineStartOffs, lineSize + 1/* + '\n'*/);
        AddReplaceDelta(curLineStartOffs, -(lineSize + 1/* + '\n'*/));
      }
    }
  }

  
  /// InsertText - Insert some text at the specified point, where the offset in
  /// the buffer is specified relative to the original SourceBuffer.  The
  /// text is inserted after the specified location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::InsertText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 92,
   FQN="clang::RewriteBuffer::InsertText", NM="_ZN5clang13RewriteBuffer10InsertTextEjN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer10InsertTextEjN4llvm9StringRefEb")
  //</editor-fold>
  public void InsertText(/*uint*/int OrigOffset, StringRef Str) {
    InsertText(OrigOffset, Str, 
            true);
  }
  public void InsertText(/*uint*/int OrigOffset, StringRef Str, 
            boolean InsertAfter/*= true*/) {
    
    // Nothing to insert, exit early.
    if (Str.empty()) {
      return;
    }
    
    /*uint*/int RealOffset = getMappedOffset(OrigOffset, InsertAfter);
    Buffer.insert(RealOffset, Str.begin(), Str.end());
    
    // Add a delta so that future changes are offset correctly.
    AddInsertDelta(OrigOffset, Str.size());
  }

  
  /// InsertTextBefore - Insert some text before the specified point, where the
  /// offset in the buffer is specified relative to the original
  /// SourceBuffer. The text is inserted before the specified location.  This is
  /// method is the same as InsertText with "InsertAfter == false".
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::InsertTextBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 73,
   FQN="clang::RewriteBuffer::InsertTextBefore", NM="_ZN5clang13RewriteBuffer16InsertTextBeforeEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer16InsertTextBeforeEjN4llvm9StringRefE")
  //</editor-fold>
  public void InsertTextBefore(/*uint*/int OrigOffset, StringRef Str) {
    InsertText(OrigOffset, new StringRef(Str), false);
  }

  
  /// InsertTextAfter - Insert some text at the specified point, where the
  /// offset in the buffer is specified relative to the original SourceBuffer.
  /// The text is inserted after the specified location.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::InsertTextAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 80,
   FQN="clang::RewriteBuffer::InsertTextAfter", NM="_ZN5clang13RewriteBuffer15InsertTextAfterEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer15InsertTextAfterEjN4llvm9StringRefE")
  //</editor-fold>
  public void InsertTextAfter(/*uint*/int OrigOffset, StringRef Str) {
    InsertText(OrigOffset, new StringRef(Str));
  }

  
  /// ReplaceText - This method replaces a range of characters in the input
  /// buffer with a new string.  This is effectively a combined "remove/insert"
  /// operation.
  
  /// ReplaceText - This method replaces a range of characters in the input
  /// buffer with a new string.  This is effectively a combined "remove+insert"
  /// operation.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::ReplaceText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 108,
   FQN="clang::RewriteBuffer::ReplaceText", NM="_ZN5clang13RewriteBuffer11ReplaceTextEjjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer11ReplaceTextEjjN4llvm9StringRefE")
  //</editor-fold>
  public void ReplaceText(/*uint*/int OrigOffset, /*uint*/int OrigLength, 
             StringRef NewStr) {
    /*uint*/int RealOffset = getMappedOffset(OrigOffset, true);
    Buffer.erase(RealOffset, OrigLength);
    Buffer.insert(RealOffset, NewStr.begin(), NewStr.end());
    if (OrigLength != NewStr.size()) {
      AddReplaceDelta(OrigOffset, NewStr.size() - OrigLength);
    }
  }

/*private:*/
  // Methods only usable by Rewriter.
  
  /// getMappedOffset - Given an offset into the original SourceBuffer that this
  /// RewriteBuffer is based on, map it into the offset space of the
  /// RewriteBuffer.  If AfterInserts is true and if the OrigOffset indicates a
  /// position where text is inserted, the location returned will be after any
  /// inserted text at the position.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::getMappedOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 97,
   FQN="clang::RewriteBuffer::getMappedOffset", NM="_ZNK5clang13RewriteBuffer15getMappedOffsetEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang13RewriteBuffer15getMappedOffsetEjb")
  //</editor-fold>
  /*friend*/ /*uint*/int getMappedOffset(/*uint*/int OrigOffset) /*const*/ {
    return getMappedOffset(OrigOffset, 
                 false);
  }
  /*friend*/ /*uint*/int getMappedOffset(/*uint*/int OrigOffset, 
                 boolean AfterInserts/*= false*/) /*const*/ {
    return Deltas.getDeltaAt(2 * OrigOffset + (AfterInserts ? 1 : 0)) + OrigOffset;
  }

  
  /// AddInsertDelta - When an insertion is made at a position, this
  /// method is used to record that information.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::AddInsertDelta">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 104,
   FQN="clang::RewriteBuffer::AddInsertDelta", NM="_ZN5clang13RewriteBuffer14AddInsertDeltaEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer14AddInsertDeltaEji")
  //</editor-fold>
  private void AddInsertDelta(/*uint*/int OrigOffset, int Change) {
    Deltas.AddDelta(2 * OrigOffset, Change);
    return;
  }

  
  /// AddReplaceDelta - When a replacement/deletion is made at a position, this
  /// method is used to record that information.
  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::AddReplaceDelta">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 110,
   FQN="clang::RewriteBuffer::AddReplaceDelta", NM="_ZN5clang13RewriteBuffer15AddReplaceDeltaEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBuffer15AddReplaceDeltaEji")
  //</editor-fold>
  private void AddReplaceDelta(/*uint*/int OrigOffset, int Change) {
    Deltas.AddDelta(2 * OrigOffset + 1, Change);
    return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::RewriteBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 27,
   FQN="clang::RewriteBuffer::RewriteBuffer", NM="_ZN5clang13RewriteBufferC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBufferC1EOS0_")
  //</editor-fold>
  public /*inline*/ RewriteBuffer(JD$Move _dparam, RewriteBuffer /*&&*/$Prm0) {
    // : Deltas(static_cast<RewriteBuffer &&>().Deltas), Buffer(static_cast<RewriteBuffer &&>().Buffer) 
    //START JInit
    this.Deltas = new DeltaTree($Prm0.Deltas);
    this.Buffer = new RewriteRope($Prm0.Buffer);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::~RewriteBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 27,
   FQN="clang::RewriteBuffer::~RewriteBuffer", NM="_ZN5clang13RewriteBufferD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBufferD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Buffer.$destroy();
    Deltas.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RewriteBuffer::RewriteBuffer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/RewriteBuffer.h", line = 27,
   FQN="clang::RewriteBuffer::RewriteBuffer", NM="_ZN5clang13RewriteBufferC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang13RewriteBufferC1Ev")
  //</editor-fold>
  public /*inline*/ RewriteBuffer() {
    // : Deltas(), Buffer() 
    //START JInit
    this.Deltas = new DeltaTree();
    this.Buffer = new RewriteRope();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public RewriteBuffer $assign(RewriteBuffer value) {
    this.Buffer = value.Buffer;
    this.Deltas = value.Deltas;
    return this;
  }
  
  @Override public RewriteBuffer clone() {
    RewriteBuffer res = new RewriteBuffer();
    res.$assign(this);
    return res;
  }

  @Override public RewriteBuffer move() {
    return new RewriteBuffer(JD$Move.INSTANCE, this);    
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Deltas=" + Deltas // NOI18N
              + ", Buffer=" + Buffer; // NOI18N
  }
}
