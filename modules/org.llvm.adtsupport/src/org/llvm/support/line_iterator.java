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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Casts.$char;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.LineIteratorStatics.*;


/// \brief A forward iterator which reads text lines from a buffer.
///
/// This class provides a forward iterator interface for reading one line at
/// a time from a buffer. When default constructed the iterator will be the
/// "end" iterator.
///
/// The iterator is aware of what line number it is currently processing. It
/// strips blank lines by default, and comment lines given a comment-starting
/// character.
///
/// Note that this iterator requires the buffer to be nul terminated.
//<editor-fold defaultstate="collapsed" desc="llvm::line_iterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 32,
 FQN="llvm::line_iterator", NM="_ZN4llvm13line_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvm13line_iteratorE")
//</editor-fold>
public class line_iterator implements /*public*/ std.iterator<std.forward_iterator_tag, StringRef>, type$iterator<line_iterator, StringRef> {
  private /*const*/ MemoryBuffer /*P*/ Buffer;
  private /*char*/byte CommentMarker;
  private boolean SkipBlanks;
  
  private /*uint*/int LineNumber;
  private StringRef CurrentLine;
/*public:*/
  /// \brief Default construct an "end" iterator.
  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::line_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 43,
   FQN="llvm::line_iterator::line_iterator", NM="_ZN4llvm13line_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvm13line_iteratorC1Ev")
  //</editor-fold>
  public line_iterator() {
    // : std::iterator<std::forward_iterator_tag, StringRef>(), Buffer(null), CurrentLine() 
    //START JInit
    $iterator();
    this.Buffer = null;
    this.CurrentLine = new StringRef();
    //END JInit
  }

  
  /// \brief Construct a new iterator around some memory buffer.
  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::line_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp", line = 35,
   FQN="llvm::line_iterator::line_iterator", NM="_ZN4llvm13line_iteratorC1ERKNS_12MemoryBufferEbc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvm13line_iteratorC1ERKNS_12MemoryBufferEbc")
  //</editor-fold>
  public line_iterator(final /*const*/ MemoryBuffer /*&*/ Buffer) {
    this(Buffer, true, 
      $$TERM);
  }
  public line_iterator(final /*const*/ MemoryBuffer /*&*/ Buffer, boolean SkipBlanks/*= true*/) {
    this(Buffer, SkipBlanks, 
      $$TERM);
  }
  public line_iterator(final /*const*/ MemoryBuffer /*&*/ Buffer, boolean SkipBlanks/*= true*/, 
      /*char*/byte CommentMarker/*= '\x00'*/) {
    // : std::iterator<std::forward_iterator_tag, StringRef>(), Buffer(Buffer.getBufferSize() ? &Buffer : null), CommentMarker(CommentMarker), SkipBlanks(SkipBlanks), LineNumber(1), CurrentLine(Buffer.getBufferSize() ? Buffer.getBufferStart() : null, 0) 
    //START JInit
    $iterator();
    this.Buffer = (Buffer.getBufferSize() != 0) ? $AddrOf(Buffer) : null;
    this.CommentMarker = CommentMarker;
    this.SkipBlanks = SkipBlanks;
    this.LineNumber = 1;
    this.CurrentLine = new StringRef((Buffer.getBufferSize() != 0) ? Buffer.getBufferStart() : (/*const*/char$ptr/*char P*/ )null, 
        0);
    //END JInit
    // Ensure that if we are constructed on a non-empty memory buffer that it is
    // a null terminated buffer.
    if ((Buffer.getBufferSize() != 0)) {
      assert (Buffer.getBufferEnd().$at(0) == $$TERM);
      // Make sure we don't skip a leading newline if we're keeping blanks
      if (SkipBlanks || !isAtLineEnd(Buffer.getBufferStart())) {
        advance();
      }
    }
  }

  
  /// \brief Return true if we've reached EOF or are an "end" iterator.
  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::is_at_eof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 50,
   FQN="llvm::line_iterator::is_at_eof", NM="_ZNK4llvm13line_iterator9is_at_eofEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZNK4llvm13line_iterator9is_at_eofEv")
  //</editor-fold>
  public boolean is_at_eof() /*const*/ {
    return !(Buffer != null);
  }

  
  /// \brief Return true if we're an "end" iterator or have reached EOF.
  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::is_at_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 53,
   FQN="llvm::line_iterator::is_at_end", NM="_ZNK4llvm13line_iterator9is_at_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZNK4llvm13line_iterator9is_at_endEv")
  //</editor-fold>
  public boolean is_at_end() /*const*/ {
    return is_at_eof();
  }

  
  /// \brief Return the current line number. May return any number at EOF.
  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::line_number">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 56,
   FQN="llvm::line_iterator::line_number", NM="_ZNK4llvm13line_iterator11line_numberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZNK4llvm13line_iterator11line_numberEv")
  //</editor-fold>
  public long/*int64_t*/ line_number() /*const*/ {
    return $uint2long(LineNumber);
  }

  
  /// \brief Advance to the next (non-empty, non-comment) line.
  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 59,
   FQN="llvm::line_iterator::operator++", NM="_ZN4llvm13line_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvm13line_iteratorppEv")
  //</editor-fold>
  public line_iterator /*&*/ $preInc() {
    advance();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 63,
   FQN="llvm::line_iterator::operator++", NM="_ZN4llvm13line_iteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvm13line_iteratorppEi")
  //</editor-fold>
  public line_iterator $postInc(int $Prm0) {
    line_iterator tmp/*J*/= new line_iterator(/*Deref*/this);
    advance();
    return tmp;
  }

  
  /// \brief Get the current line as a \c StringRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 70,
   FQN="llvm::line_iterator::operator*", NM="_ZNK4llvm13line_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZNK4llvm13line_iteratordeEv")
  //</editor-fold>
  public StringRef $star() /*const*/ {
    return new StringRef(CurrentLine);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 71,
   FQN="llvm::line_iterator::operator->", NM="_ZNK4llvm13line_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZNK4llvm13line_iteratorptEv")
  //</editor-fold>
  public /*const*/ StringRef /*P*/ $arrow() /*const*/ {
    return $AddrOf(CurrentLine);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 73,
   FQN="llvm::operator==", NM="_ZN4llvmeqERKNS_13line_iteratorES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvmeqERKNS_13line_iteratorES2_")
  //</editor-fold>
  public static boolean $eq_line_iterator$C(final /*const*/ line_iterator /*&*/ LHS, final /*const*/ line_iterator /*&*/ RHS) {
    return LHS.Buffer == RHS.Buffer
       && $eq_ptr(LHS.CurrentLine.begin(), RHS.CurrentLine.begin());
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 78,
   FQN="llvm::operator!=", NM="_ZN4llvmneERKNS_13line_iteratorES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvmneERKNS_13line_iteratorES2_")
  //</editor-fold>
  public static boolean $noteq_line_iterator$C(final /*const*/ line_iterator /*&*/ LHS, final /*const*/ line_iterator /*&*/ RHS) {
    return !(line_iterator.$eq_line_iterator$C(LHS, RHS));
  }

/*private:*/
  /// \brief Advance the iterator to the next line.
  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::advance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp", line = 51,
   FQN="llvm::line_iterator::advance", NM="_ZN4llvm13line_iterator7advanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvm13line_iterator7advanceEv")
  //</editor-fold>
  private void advance() {
    assert ((Buffer != null)) : "Cannot advance past the end!";
    
    /*const*/char$ptr/*char P*/ Pos = $tryClone(CurrentLine.end());
    assert ($eq_ptr(Pos, Buffer.getBufferStart()) || isAtLineEnd(Pos) || Pos.$star() == $$TERM);
    if (skipIfAtLineEnd(Pos)) {
      ++LineNumber;
    }
    if (!SkipBlanks && isAtLineEnd(Pos)) {
      // Nothing to do for a blank line.
    } else if (CommentMarker == $$TERM) {
      // If we're not stripping comments, this is simpler.
      while (skipIfAtLineEnd(Pos)) {
        ++LineNumber;
      }
    } else {
      // Skip comments and count line numbers, which is a bit more complex.
      for (;;) {
        if (isAtLineEnd(Pos) && !SkipBlanks) {
          break;
        }
        if (Pos.$star() == CommentMarker) {
          do {
            Pos.$preInc();
          } while (Pos.$star() != $$TERM && !isAtLineEnd(Pos));
        }
        if (!skipIfAtLineEnd(Pos)) {
          break;
        }
        ++LineNumber;
      }
    }
    if (Pos.$star() == $$TERM) {
      // We've hit the end of the buffer, reset ourselves to the end state.
      Buffer = null;
      CurrentLine.$assignMove(new StringRef());
      return;
    }
    
    // Measure the line.
    /*size_t*/int Length = 0;
    while (Pos.$at(Length) != $$TERM && !isAtLineEnd(Pos.$add(Length))) {
      ++Length;
    }
    
    CurrentLine.$assignMove(new StringRef(Pos, Length));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::line_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 32,
   FQN="llvm::line_iterator::line_iterator", NM="_ZN4llvm13line_iteratorC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvm13line_iteratorC1ERKS0_")
  //</editor-fold>
  public /*inline*/ line_iterator(final /*const*/ line_iterator /*&*/ $Prm0) {
    // : std::iterator<std::forward_iterator_tag, StringRef>(), Buffer(.Buffer), CommentMarker(.CommentMarker), SkipBlanks(.SkipBlanks), LineNumber(.LineNumber), CurrentLine(.CurrentLine) 
    //START JInit
    $iterator($Prm0);
    this.Buffer = $Prm0.Buffer;
    this.CommentMarker = $Prm0.CommentMarker;
    this.SkipBlanks = $Prm0.SkipBlanks;
    this.LineNumber = $Prm0.LineNumber;
    this.CurrentLine = new StringRef($Prm0.CurrentLine);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::line_iterator::line_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/LineIterator.h", line = 32,
   FQN="llvm::line_iterator::line_iterator", NM="_ZN4llvm13line_iteratorC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/LineIterator.cpp -nm=_ZN4llvm13line_iteratorC1EOS0_")
  //</editor-fold>
  public /*inline*/ line_iterator(JD$Move _dparam, final line_iterator /*&&*/$Prm0) {
    // : std::iterator<std::forward_iterator_tag, StringRef>(static_cast<line_iterator &&>()), Buffer(static_cast<line_iterator &&>().Buffer), CommentMarker(static_cast<line_iterator &&>().CommentMarker), SkipBlanks(static_cast<line_iterator &&>().SkipBlanks), LineNumber(static_cast<line_iterator &&>().LineNumber), CurrentLine(static_cast<line_iterator &&>().CurrentLine) 
    //START JInit
    $iterator(JD$Move.INSTANCE, $Prm0);
    this.Buffer = $Prm0.Buffer;
    this.CommentMarker = $Prm0.CommentMarker;
    this.SkipBlanks = $Prm0.SkipBlanks;
    this.LineNumber = $Prm0.LineNumber;
    this.CurrentLine = new StringRef(JD$Move.INSTANCE, $Prm0.CurrentLine);
    //END JInit
  }

  @Override
  public boolean $eq(Object other) {
    return $eq_line_iterator$C(this, (line_iterator) other);
  }
  
  @Override public line_iterator clone() {
    return new line_iterator(this);
  }
  
  @Override public String toString() {
    return "" + "Buffer=" + (Buffer != null ? Buffer.getBufferIdentifier() : "<null>") // NOI18N
              + ", CommentMarker=" + $char(CommentMarker) // NOI18N
              + ", SkipBlanks=" + SkipBlanks // NOI18N
              + ", LineNumber=" + LineNumber // NOI18N
              + ", CurrentLine=\n[" + CurrentLine.toJavaString() + "]"; // NOI18N
  }
}
