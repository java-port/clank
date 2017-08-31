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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.rewrite.core.*;
import org.clang.rewrite.impl.*;
import org.clang.lex.*;
import static org.clang.rewrite.impl.RewriterStatics.*;


/// Rewriter - This is the main interface to the rewrite buffers.  Its primary
/// job is to dispatch high-level requests to the low-level RewriteBuffers that
/// are involved.
//<editor-fold defaultstate="collapsed" desc="clang::Rewriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 31,
 FQN="clang::Rewriter", NM="_ZN5clang8RewriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8RewriterE")
//</editor-fold>
public class Rewriter implements Destructors.ClassWithDestructor {
  private SourceManager /*P*/ SourceMgr;
  private /*const*/ LangOptions /*P*/ LangOpts;
  private std.mapTypeType<FileID, RewriteBuffer> RewriteBuffers;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::RewriteOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 36,
   FQN="clang::Rewriter::RewriteOptions", NM="_ZN5clang8Rewriter14RewriteOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter14RewriteOptionsE")
  //</editor-fold>
  public static class/*struct*/ RewriteOptions {
    /// \brief Given a source range, true to include previous inserts at the
    /// beginning of the range as part of the range itself (true by default).
    public boolean IncludeInsertsAtBeginOfRange;
    /// \brief Given a source range, true to include previous inserts at the
    /// end of the range as part of the range itself (true by default).
    public boolean IncludeInsertsAtEndOfRange;
    /// \brief If true and removing some text leaves a blank line
    /// also remove the empty line (false by default).
    public boolean RemoveLineIfEmpty;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::RewriteOptions::RewriteOptions">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 47,
     FQN="clang::Rewriter::RewriteOptions::RewriteOptions", NM="_ZN5clang8Rewriter14RewriteOptionsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter14RewriteOptionsC1Ev")
    //</editor-fold>
    public RewriteOptions() {
      // : IncludeInsertsAtBeginOfRange(true), IncludeInsertsAtEndOfRange(true), RemoveLineIfEmpty(false) 
      //START JInit
      this.IncludeInsertsAtBeginOfRange = true;
      this.IncludeInsertsAtEndOfRange = true;
      this.RemoveLineIfEmpty = false;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::RewriteOptions::RewriteOptions">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 36,
     FQN="clang::Rewriter::RewriteOptions::RewriteOptions", NM="_ZN5clang8Rewriter14RewriteOptionsC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter14RewriteOptionsC1ERKS1_")
    //</editor-fold>
    public /*inline*/ RewriteOptions(/*const*/ RewriteOptions /*&*/ $Prm0) {
      // : IncludeInsertsAtBeginOfRange(.IncludeInsertsAtBeginOfRange), IncludeInsertsAtEndOfRange(.IncludeInsertsAtEndOfRange), RemoveLineIfEmpty(.RemoveLineIfEmpty) 
      //START JInit
      this.IncludeInsertsAtBeginOfRange = $Prm0.IncludeInsertsAtBeginOfRange;
      this.IncludeInsertsAtEndOfRange = $Prm0.IncludeInsertsAtEndOfRange;
      this.RemoveLineIfEmpty = $Prm0.RemoveLineIfEmpty;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::RewriteOptions::RewriteOptions">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 36,
     FQN="clang::Rewriter::RewriteOptions::RewriteOptions", NM="_ZN5clang8Rewriter14RewriteOptionsC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter14RewriteOptionsC1EOS1_")
    //</editor-fold>
    public /*inline*/ RewriteOptions(JD$Move _dparam, RewriteOptions /*&&*/$Prm0) {
      // : IncludeInsertsAtBeginOfRange(static_cast<RewriteOptions &&>().IncludeInsertsAtBeginOfRange), IncludeInsertsAtEndOfRange(static_cast<RewriteOptions &&>().IncludeInsertsAtEndOfRange), RemoveLineIfEmpty(static_cast<RewriteOptions &&>().RemoveLineIfEmpty) 
      //START JInit
      this.IncludeInsertsAtBeginOfRange = $Prm0.IncludeInsertsAtBeginOfRange;
      this.IncludeInsertsAtEndOfRange = $Prm0.IncludeInsertsAtEndOfRange;
      this.RemoveLineIfEmpty = $Prm0.RemoveLineIfEmpty;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "IncludeInsertsAtBeginOfRange=" + IncludeInsertsAtBeginOfRange // NOI18N
                + ", IncludeInsertsAtEndOfRange=" + IncludeInsertsAtEndOfRange // NOI18N
                + ", RemoveLineIfEmpty=" + RemoveLineIfEmpty; // NOI18N
    }
  };
  
  /*typedef std::map<FileID, RewriteBuffer>::iterator buffer_iterator*/
//  public final class buffer_iterator extends std.map.iterator<FileID, RewriteBuffer>{ };
  /*typedef std::map<FileID, RewriteBuffer>::const_iterator const_buffer_iterator*/
//  public final class const_buffer_iterator extends std.map.iterator<FileID, RewriteBuffer>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::Rewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 56,
   FQN="clang::Rewriter::Rewriter", NM="_ZN5clang8RewriterC1ERNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8RewriterC1ERNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public /*explicit*/ Rewriter(SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LO) {
    // : SourceMgr(&SM), LangOpts(&LO), RewriteBuffers() 
    //START JInit
    this.SourceMgr = /*AddrOf*/SM;
    this.LangOpts = /*AddrOf*/LO;
    this.RewriteBuffers = new std.mapTypeType<FileID, RewriteBuffer>(FileID.COMPARATOR, new RewriteBuffer());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::Rewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 58,
   FQN="clang::Rewriter::Rewriter", NM="_ZN5clang8RewriterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8RewriterC1Ev")
  //</editor-fold>
  public /*explicit*/ Rewriter() {
    // : SourceMgr(null), LangOpts(null), RewriteBuffers() 
    //START JInit
    this.SourceMgr = null;
    this.LangOpts = null;
    this.RewriteBuffers = new std.mapTypeType<FileID, RewriteBuffer>(FileID.COMPARATOR, new RewriteBuffer());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::setSourceMgr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 60,
   FQN="clang::Rewriter::setSourceMgr", NM="_ZN5clang8Rewriter12setSourceMgrERNS_13SourceManagerERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter12setSourceMgrERNS_13SourceManagerERKNS_11LangOptionsE")
  //</editor-fold>
  public void setSourceMgr(SourceManager /*&*/ SM, /*const*/ LangOptions /*&*/ LO) {
    SourceMgr = /*AddrOf*/SM;
    LangOpts = /*AddrOf*/LO;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::getSourceMgr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 64,
   FQN="clang::Rewriter::getSourceMgr", NM="_ZNK5clang8Rewriter12getSourceMgrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZNK5clang8Rewriter12getSourceMgrEv")
  //</editor-fold>
  public SourceManager /*&*/ getSourceMgr() /*const*/ {
    return /*Deref*/SourceMgr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 65,
   FQN="clang::Rewriter::getLangOpts", NM="_ZNK5clang8Rewriter11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZNK5clang8Rewriter11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return /*Deref*/LangOpts;
  }

  
  /// isRewritable - Return true if this location is a raw file location, which
  /// is rewritable.  Locations from macros, etc are not rewritable.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::isRewritable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 69,
   FQN="clang::Rewriter::isRewritable", NM="_ZN5clang8Rewriter12isRewritableENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter12isRewritableENS_14SourceLocationE")
  //</editor-fold>
  public static boolean isRewritable(SourceLocation Loc) {
    return Loc.isFileID();
  }

  
  /// getRangeSize - Return the size in bytes of the specified range if they
  /// are in the same file.  If not, this returns -1.
  
  /// getRangeSize - Return the size in bytes of the specified range if they
  /// are in the same file.  If not, this returns -1.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::getRangeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 157,
   FQN="clang::Rewriter::getRangeSize", NM="_ZNK5clang8Rewriter12getRangeSizeENS_11SourceRangeENS0_14RewriteOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang8Rewriter12getRangeSizeENS_11SourceRangeENS0_14RewriteOptionsE")
  //</editor-fold>
  public int getRangeSize(SourceRange Range) /*const*/ {
    return getRangeSize(Range, new RewriteOptions());
  }
  public int getRangeSize(SourceRange Range, RewriteOptions opts/*= RewriteOptions()*/) /*const*/ {
    return getRangeSize(CharSourceRange.getTokenRange(/*NO_COPY*/Range), new RewriteOptions(opts));
  }


  
  //===----------------------------------------------------------------------===//
  // Rewriter class
  //===----------------------------------------------------------------------===//
  
  /// getRangeSize - Return the size in bytes of the specified range if they
  /// are in the same file.  If not, this returns -1.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::getRangeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 124,
   FQN="clang::Rewriter::getRangeSize", NM="_ZNK5clang8Rewriter12getRangeSizeERKNS_15CharSourceRangeENS0_14RewriteOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang8Rewriter12getRangeSizeERKNS_15CharSourceRangeENS0_14RewriteOptionsE")
  //</editor-fold>
  public int getRangeSize(/*const*/ CharSourceRange /*&*/ Range) /*const*/ {
    return getRangeSize(Range, 
              new RewriteOptions());
  }
  public int getRangeSize(/*const*/ CharSourceRange /*&*/ Range, 
              RewriteOptions opts/*= RewriteOptions()*/) /*const*/ {
    if (!isRewritable(Range.getBegin())
       || !isRewritable(Range.getEnd())) {
      return -1;
    }
    
    FileID StartFileID/*J*/= new FileID(), EndFileID/*J*/= new FileID();
    /*uint*/int StartOff, EndOff;
    
    StartOff = getLocationOffsetAndFileID(Range.getBegin(), StartFileID);
    EndOff = getLocationOffsetAndFileID(Range.getEnd(), EndFileID);
    if (StartFileID.$noteq(EndFileID)) {
      return -1;
    }
    
    // If edits have been made to this buffer, the delta between the range may
    // have changed.
    std.mapTypeType.iterator<FileID, RewriteBuffer> I = RewriteBuffers.find$Const(StartFileID);
    if (I.$noteq(RewriteBuffers.end$Const())) {
      /*const*/ RewriteBuffer /*&*/ RB = I.$arrow().second;
      EndOff = RB.getMappedOffset(EndOff, opts.IncludeInsertsAtEndOfRange);
      StartOff = RB.getMappedOffset(StartOff, !opts.IncludeInsertsAtBeginOfRange);
    }
    
    // Adjust the end offset to the end of the last token, instead of being the
    // start of the last token if this is a token range.
    if (Range.isTokenRange()) {
      EndOff += Lexer.MeasureTokenLength(Range.getEnd(), /*Deref*/SourceMgr, /*Deref*/LangOpts);
    }
    
    return EndOff - StartOff;
  }


  
  /// getRewrittenText - Return the rewritten form of the text in the specified
  /// range.  If the start or end of the range was unrewritable or if they are
  /// in different buffers, this returns an empty string.
  ///
  /// Note that this method is not particularly efficient.
  ///
  
  /// getRewrittenText - Return the rewritten form of the text in the specified
  /// range.  If the start or end of the range was unrewritable or if they are
  /// in different buffers, this returns an empty string.
  ///
  /// Note that this method is not particularly efficient.
  ///
  
  /// getRewrittenText - Return the rewritten form of the text in the specified
  /// range.  If the start or end of the range was unrewritable or if they are
  /// in different buffers, this returns an empty string.
  ///
  /// Note that this method is not particularly efficient.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::getRewrittenText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 168,
   FQN="clang::Rewriter::getRewrittenText", NM="_ZNK5clang8Rewriter16getRewrittenTextENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang8Rewriter16getRewrittenTextENS_11SourceRangeE")
  //</editor-fold>
  public std.string getRewrittenText(SourceRange Range) /*const*/ {
    if (!isRewritable(Range.getBegin())
       || !isRewritable(Range.getEnd())) {
      return new std.string(/*KEEP_STR*/$EMPTY);
    }
    
    FileID StartFileID/*J*/= new FileID(), EndFileID/*J*/= new FileID();
    /*uint*/int StartOff, EndOff;
    StartOff = getLocationOffsetAndFileID(Range.getBegin(), StartFileID);
    EndOff = getLocationOffsetAndFileID(Range.getEnd(), EndFileID);
    if (StartFileID.$noteq(EndFileID)) {
      return new std.string(/*KEEP_STR*/$EMPTY); // Start and end in different buffers.
    }
    
    // If edits have been made to this buffer, the delta between the range may
    // have changed.
    std.mapTypeType.iterator<FileID, RewriteBuffer> I = RewriteBuffers.find$Const(StartFileID);
    if (I.$eq(RewriteBuffers.end$Const())) {
      // If the buffer hasn't been rewritten, just return the text from the input.
      /*const*/char$ptr/*char P*/ Ptr = $tryClone(SourceMgr.getCharacterData(Range.getBegin()));
      
      // Adjust the end offset to the end of the last token, instead of being the
      // start of the last token.
      EndOff += Lexer.MeasureTokenLength(Range.getEnd(), /*Deref*/SourceMgr, /*Deref*/LangOpts);
      return new std.string(Ptr, Ptr.$add(EndOff).$sub(StartOff));
    }
    
    /*const*/ RewriteBuffer /*&*/ RB = I.$arrow().second;
    EndOff = RB.getMappedOffset(EndOff, true);
    StartOff = RB.getMappedOffset(StartOff);
    
    // Adjust the end offset to the end of the last token, instead of being the
    // start of the last token.
    EndOff += Lexer.MeasureTokenLength(Range.getEnd(), /*Deref*/SourceMgr, /*Deref*/LangOpts);
    
    // Advance the iterators to the right spot, yay for linear time algorithms.
    RopePieceBTreeIterator Start = RB.begin();
    std.advance(Start, StartOff);
    RopePieceBTreeIterator End = new RopePieceBTreeIterator(Start);
    std.advance(End, EndOff - StartOff);
    
    return new std.string(/*NO_COPY*/Start, /*NO_COPY*/End);
  }


  
  /// InsertText - Insert the specified string at the specified location in the
  /// original buffer.  This method returns true (and does nothing) if the input
  /// location was not rewritable, false otherwise.
  ///
  /// \param indentNewLines if true new lines in the string are indented
  /// using the indentation of the source line in position \p Loc.
  
  /// InsertText - Insert the specified string at the specified location in the
  /// original buffer.  This method returns true (and does nothing) if the input
  /// location was not rewritable, false otherwise.
  ///
  /// \param indentNewLines if true new lines in the string are indented
  /// using the indentation of the source line in position \p Loc.
  
  /// InsertText - Insert the specified string at the specified location in the
  /// original buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::InsertText">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 238,
   FQN="clang::Rewriter::InsertText", NM="_ZN5clang8Rewriter10InsertTextENS_14SourceLocationEN4llvm9StringRefEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang8Rewriter10InsertTextENS_14SourceLocationEN4llvm9StringRefEbb")
  //</editor-fold>
  public boolean InsertText(SourceLocation Loc, StringRef Str) {
    return InsertText(Loc, Str, 
            true, false);
  }
  public boolean InsertText(SourceLocation Loc, StringRef Str, 
            boolean InsertAfter/*= true*/) {
    return InsertText(Loc, Str, 
            InsertAfter, false);
  }
  public boolean InsertText(SourceLocation Loc, StringRef Str, 
            boolean InsertAfter/*= true*/, boolean indentNewLines/*= false*/) {
    if (!isRewritable(new SourceLocation(Loc))) {
      return true;
    }
    FileID FID/*J*/= new FileID();
    /*uint*/int StartOffs = getLocationOffsetAndFileID(new SourceLocation(Loc), FID);
    
    SmallString/*128*/ indentedStr/*J*/= new SmallString/*128*/(128);
    if (indentNewLines && Str.find($$LF) != StringRef.npos) {
      StringRef MB = SourceMgr.getBufferData(/*NO_COPY*/FID);
      
      /*uint*/int lineNo = SourceMgr.getLineNumber(/*NO_COPY*/FID, StartOffs) - 1;
      // JAVA
      /*const*/ final SrcMgr.SLocEntry SLocEntry = SourceMgr.getSLocEntry(/*NO_COPY*/FID);
      /*const*/ SrcMgr.ContentCache /*P*/ Content = SourceMgr.getContentCache(SLocEntry.getFile());
      /*uint*/int lineOffs = Content.SourceLineCache[lineNo];
      
      // Find the whitespace at the start of the line.
      StringRef indentSpace/*J*/= new StringRef();
      {
        /*uint*/int i = lineOffs;
        while (isWhitespaceExceptNL(MB.$at(i))) {
          ++i;
        }
        indentSpace.$assignMove(MB.substr(lineOffs, i - lineOffs));
      }
      
      SmallVector<StringRef> lines/*J*/= new SmallVector<StringRef>(4, new StringRef());
      Str.split(lines, /*STRINGREF_STR*/"\n");
      
      for (/*uint*/int i = 0, e = lines.size(); i != e; ++i) {
        indentedStr.$addassign(/*NO_COPY*/lines.$at(i));
        if ($less_uint(i, e - 1)) {
          indentedStr.$addassign($$LF);
          indentedStr.$addassign(/*NO_COPY*/indentSpace);
        }
      }
      Str.$assignMove(indentedStr.str());
    }
    
    getEditBuffer(new FileID(FID)).InsertText(StartOffs, new StringRef(Str), InsertAfter);
    return false;
  }


  
  /// InsertTextAfter - Insert the specified string at the specified location in
  ///  the original buffer.  This method returns true (and does nothing) if
  ///  the input location was not rewritable, false otherwise.  Text is
  ///  inserted after any other text that has been previously inserted
  ///  at the some point (the default behavior for InsertText).
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::InsertTextAfter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 102,
   FQN="clang::Rewriter::InsertTextAfter", NM="_ZN5clang8Rewriter15InsertTextAfterENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter15InsertTextAfterENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public boolean InsertTextAfter(SourceLocation Loc, StringRef Str) {
    return InsertText(new SourceLocation(Loc), new StringRef(Str));
  }

  
  /// \brief Insert the specified string after the token in the
  /// specified location.
  
  /// \brief Insert the specified string after the token in the
  /// specified location.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::InsertTextAfterToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 279,
   FQN="clang::Rewriter::InsertTextAfterToken", NM="_ZN5clang8Rewriter20InsertTextAfterTokenENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang8Rewriter20InsertTextAfterTokenENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public boolean InsertTextAfterToken(SourceLocation Loc, StringRef Str) {
    if (!isRewritable(new SourceLocation(Loc))) {
      return true;
    }
    FileID FID/*J*/= new FileID();
    /*uint*/int StartOffs = getLocationOffsetAndFileID(new SourceLocation(Loc), FID);
    RewriteOptions rangeOpts/*J*/= new RewriteOptions();
    rangeOpts.IncludeInsertsAtBeginOfRange = false;
    StartOffs += getRangeSize(new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc), new RewriteOptions(rangeOpts));
    getEditBuffer(new FileID(FID)).InsertText(StartOffs, new StringRef(Str), /*InsertAfter*/ true);
    return false;
  }


  
  /// InsertText - Insert the specified string at the specified location in the
  /// original buffer.  This method returns true (and does nothing) if the input
  /// location was not rewritable, false otherwise.  Text is
  /// inserted before any other text that has been previously inserted
  /// at the some point.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::InsertTextBefore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 115,
   FQN="clang::Rewriter::InsertTextBefore", NM="_ZN5clang8Rewriter16InsertTextBeforeENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter16InsertTextBeforeENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public boolean InsertTextBefore(SourceLocation Loc, StringRef Str) {
    return InsertText(new SourceLocation(Loc), new StringRef(Str), false);
  }

  
  /// RemoveText - Remove the specified text region.
  
  /// RemoveText - Remove the specified text region.
  
  /// RemoveText - Remove the specified text region.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::RemoveText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 291,
   FQN="clang::Rewriter::RemoveText", NM="_ZN5clang8Rewriter10RemoveTextENS_14SourceLocationEjNS0_14RewriteOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang8Rewriter10RemoveTextENS_14SourceLocationEjNS0_14RewriteOptionsE")
  //</editor-fold>
  public boolean RemoveText(SourceLocation Start, /*uint*/int Length) {
    return RemoveText(Start, Length, 
            new RewriteOptions());
  }
  public boolean RemoveText(SourceLocation Start, /*uint*/int Length, 
            RewriteOptions opts/*= RewriteOptions()*/) {
    if (!isRewritable(new SourceLocation(Start))) {
      return true;
    }
    FileID FID/*J*/= new FileID();
    /*uint*/int StartOffs = getLocationOffsetAndFileID(new SourceLocation(Start), FID);
    getEditBuffer(new FileID(FID)).RemoveText(StartOffs, Length, opts.RemoveLineIfEmpty);
    return false;
  }


  
  /// \brief Remove the specified text region.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::RemoveText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 124,
   FQN="clang::Rewriter::RemoveText", NM="_ZN5clang8Rewriter10RemoveTextENS_15CharSourceRangeENS0_14RewriteOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter10RemoveTextENS_15CharSourceRangeENS0_14RewriteOptionsE")
  //</editor-fold>
  public boolean RemoveText(CharSourceRange range) {
    return RemoveText(range, 
            new RewriteOptions());
  }
  public boolean RemoveText(CharSourceRange range, 
            RewriteOptions opts/*= RewriteOptions()*/) {
    return RemoveText(range.getBegin(), getRangeSize(range, new RewriteOptions(opts)), new RewriteOptions(opts));
  }

  
  /// \brief Remove the specified text region.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::RemoveText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 130,
   FQN="clang::Rewriter::RemoveText", NM="_ZN5clang8Rewriter10RemoveTextENS_11SourceRangeENS0_14RewriteOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter10RemoveTextENS_11SourceRangeENS0_14RewriteOptionsE")
  //</editor-fold>
  public boolean RemoveText(SourceRange range) {
    return RemoveText(range, new RewriteOptions());
  }
  public boolean RemoveText(SourceRange range, RewriteOptions opts/*= RewriteOptions()*/) {
    return RemoveText(range.getBegin(), getRangeSize(new SourceRange(range), new RewriteOptions(opts)), new RewriteOptions(opts));
  }

  
  /// ReplaceText - This method replaces a range of characters in the input
  /// buffer with a new string.  This is effectively a combined "remove/insert"
  /// operation.
  
  /// ReplaceText - This method replaces a range of characters in the input
  /// buffer with a new string.  This is effectively a combined "remove/insert"
  /// operation.
  
  /// ReplaceText - This method replaces a range of characters in the input
  /// buffer with a new string.  This is effectively a combined "remove/insert"
  /// operation.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::ReplaceText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 303,
   FQN="clang::Rewriter::ReplaceText", NM="_ZN5clang8Rewriter11ReplaceTextENS_14SourceLocationEjN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang8Rewriter11ReplaceTextENS_14SourceLocationEjN4llvm9StringRefE")
  //</editor-fold>
  public boolean ReplaceText(SourceLocation Start, /*uint*/int OrigLength, 
             StringRef NewStr) {
    if (!isRewritable(new SourceLocation(Start))) {
      return true;
    }
    FileID StartFileID/*J*/= new FileID();
    /*uint*/int StartOffs = getLocationOffsetAndFileID(new SourceLocation(Start), StartFileID);
    
    getEditBuffer(new FileID(StartFileID)).ReplaceText(StartOffs, OrigLength, new StringRef(NewStr));
    return false;
  }


  
  /// ReplaceText - This method replaces a range of characters in the input
  /// buffer with a new string.  This is effectively a combined "remove/insert"
  /// operation.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::ReplaceText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 143,
   FQN="clang::Rewriter::ReplaceText", NM="_ZN5clang8Rewriter11ReplaceTextENS_11SourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter11ReplaceTextENS_11SourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  public boolean ReplaceText(SourceRange range, StringRef NewStr) {
    return ReplaceText(range.getBegin(), getRangeSize(new SourceRange(range)), new StringRef(NewStr));
  }

  
  /// ReplaceText - This method replaces a range of characters in the input
  /// buffer with a new string.  This is effectively a combined "remove/insert"
  /// operation.
  
  /// ReplaceText - This method replaces a range of characters in the input
  /// buffer with a new string.  This is effectively a combined "remove/insert"
  /// operation.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::ReplaceText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 313,
   FQN="clang::Rewriter::ReplaceText", NM="_ZN5clang8Rewriter11ReplaceTextENS_11SourceRangeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang8Rewriter11ReplaceTextENS_11SourceRangeES1_")
  //</editor-fold>
  public boolean ReplaceText(SourceRange range, SourceRange replacementRange) {
    if (!isRewritable(range.getBegin())) {
      return true;
    }
    if (!isRewritable(range.getEnd())) {
      return true;
    }
    if (replacementRange.isInvalid()) {
      return true;
    }
    SourceLocation start = range.getBegin();
    /*uint*/int origLength = getRangeSize(new SourceRange(range));
    /*uint*/int newLength = getRangeSize(new SourceRange(replacementRange));
    FileID FID/*J*/= new FileID();
    /*uint*/int newOffs = getLocationOffsetAndFileID(replacementRange.getBegin(), 
        FID);
    StringRef MB = SourceMgr.getBufferData(/*NO_COPY*/FID);
    return ReplaceText(new SourceLocation(start), origLength, MB.substr(newOffs, newLength));
  }


  
  /// \brief Increase indentation for the lines between the given source range.
  /// To determine what the indentation should be, 'parentIndent' is used
  /// that should be at a source location with an indentation one degree
  /// lower than the given range.
  
  /// \brief Increase indentation for the lines between the given source range.
  /// To determine what the indentation should be, 'parentIndent' is used
  /// that should be at a source location with an indentation one degree
  /// lower than the given range.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::IncreaseIndentation">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 327,
   FQN="clang::Rewriter::IncreaseIndentation", NM="_ZN5clang8Rewriter19IncreaseIndentationENS_15CharSourceRangeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang8Rewriter19IncreaseIndentationENS_15CharSourceRangeENS_14SourceLocationE")
  //</editor-fold>
  public boolean IncreaseIndentation(CharSourceRange range, 
                     SourceLocation parentIndent) {
    if (range.isInvalid()) {
      return true;
    }
    if (!isRewritable(range.getBegin())) {
      return true;
    }
    if (!isRewritable(range.getEnd())) {
      return true;
    }
    if (!isRewritable(new SourceLocation(parentIndent))) {
      return true;
    }
    
    FileID StartFileID/*J*/= new FileID(), EndFileID/*J*/= new FileID(), parentFileID/*J*/= new FileID();
    /*uint*/int StartOff, EndOff, parentOff;
    
    StartOff = getLocationOffsetAndFileID(range.getBegin(), StartFileID);
    EndOff = getLocationOffsetAndFileID(range.getEnd(), EndFileID);
    parentOff = getLocationOffsetAndFileID(new SourceLocation(parentIndent), parentFileID);
    if (StartFileID.$noteq(EndFileID) || StartFileID.$noteq(parentFileID)) {
      return true;
    }
    if ($greater_uint(StartOff, EndOff)) {
      return true;
    }
    
    FileID FID = new FileID(StartFileID);
    StringRef MB = SourceMgr.getBufferData(/*NO_COPY*/FID);
    
    /*uint*/int parentLineNo = SourceMgr.getLineNumber(/*NO_COPY*/FID, parentOff) - 1;
    /*uint*/int startLineNo = SourceMgr.getLineNumber(/*NO_COPY*/FID, StartOff) - 1;
    /*uint*/int endLineNo = SourceMgr.getLineNumber(/*NO_COPY*/FID, EndOff) - 1;
    
    /*const*/ final SrcMgr.SLocEntry SLocEntry = SourceMgr.getSLocEntry(/*NO_COPY*/FID);
    /*const*/ SrcMgr.ContentCache /*P*/ Content = SourceMgr.getContentCache(SLocEntry.getFile());
    
    // Find where the lines start.
    /*uint*/int parentLineOffs = Content.SourceLineCache[parentLineNo];
    /*uint*/int startLineOffs = Content.SourceLineCache[startLineNo];
    
    // Find the whitespace at the start of each line.
    StringRef parentSpace/*J*/= new StringRef(), startSpace/*J*/= new StringRef();
    {
      /*uint*/int i = parentLineOffs;
      while (isWhitespaceExceptNL(MB.$at(i))) {
        ++i;
      }
      parentSpace.$assignMove(MB.substr(parentLineOffs, i - parentLineOffs));
      
      i = startLineOffs;
      while (isWhitespaceExceptNL(MB.$at(i))) {
        ++i;
      }
      startSpace.$assignMove(MB.substr(startLineOffs, i - startLineOffs));
    }
    if ($greatereq_uint(parentSpace.size(), startSpace.size())) {
      return true;
    }
    if (!startSpace.startswith(/*NO_COPY*/parentSpace)) {
      return true;
    }
    
    StringRef indent = startSpace.substr(parentSpace.size());
    
    // Indent the lines between start/end offsets.
    RewriteBuffer /*&*/ RB = getEditBuffer(new FileID(FID));
    for (/*uint*/int lineNo = startLineNo; $lesseq_uint(lineNo, endLineNo); ++lineNo) {
      /*uint*/int offs = Content.SourceLineCache[lineNo];
      /*uint*/int i = offs;
      while (isWhitespaceExceptNL(MB.$at(i))) {
        ++i;
      }
      StringRef origIndent = MB.substr(offs, i - offs);
      if (origIndent.startswith(/*NO_COPY*/startSpace)) {
        RB.InsertText(offs, new StringRef(indent), /*InsertAfter=*/ false);
      }
    }
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::IncreaseIndentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 157,
   FQN="clang::Rewriter::IncreaseIndentation", NM="_ZN5clang8Rewriter19IncreaseIndentationENS_11SourceRangeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter19IncreaseIndentationENS_11SourceRangeENS_14SourceLocationE")
  //</editor-fold>
  public boolean IncreaseIndentation(SourceRange range, SourceLocation parentIndent) {
    return IncreaseIndentation(CharSourceRange.getTokenRange(/*NO_COPY*/range), 
        new SourceLocation(parentIndent));
  }

  
  /// getEditBuffer - This is like getRewriteBufferFor, but always returns a
  /// buffer, and allows you to write on it directly.  This is useful if you
  /// want efficient low-level access to apis for scribbling on one specific
  /// FileID's buffer.
  
  /// getEditBuffer - This is like getRewriteBufferFor, but always returns a
  /// buffer, and allows you to write on it directly.  This is useful if you
  /// want efficient low-level access to apis for scribbling on one specific
  /// FileID's buffer.
  
  /// getEditBuffer - Get or create a RewriteBuffer for the specified FileID.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::getEditBuffer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 223,
   FQN="clang::Rewriter::getEditBuffer", NM="_ZN5clang8Rewriter13getEditBufferENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang8Rewriter13getEditBufferENS_6FileIDE")
  //</editor-fold>
  public RewriteBuffer /*&*/ getEditBuffer(FileID FID) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.mapTypeType.iterator<FileID, RewriteBuffer> I = RewriteBuffers.lower_bound(FID);
      if (I.$noteq(RewriteBuffers.end()) && I.$arrow().first.$eq(FID)) {
        return I.$arrow().second;
      }
      $c$.clean(I = (RewriteBuffers.insert(std.make_pair($Clone(FID), $Move($c$.track(new RewriteBuffer())))).first));
      
      StringRef MB = SourceMgr.getBufferData(/*NO_COPY*/FID);
      I.$arrow().second.Initialize(MB.begin(), MB.end());
      
      return I.$arrow().second;
    } finally {
      $c$.$destroy();
    }
  }


  
  /// getRewriteBufferFor - Return the rewrite buffer for the specified FileID.
  /// If no modification has been made to it, return null.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::getRewriteBufferFor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 170,
   FQN="clang::Rewriter::getRewriteBufferFor", NM="_ZNK5clang8Rewriter19getRewriteBufferForENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZNK5clang8Rewriter19getRewriteBufferForENS_6FileIDE")
  //</editor-fold>
  public /*const*/ RewriteBuffer /*P*/ getRewriteBufferFor(FileID FID) /*const*/ {
    std.mapTypeType.iterator<FileID, RewriteBuffer> I = RewriteBuffers.find$Const(FID);
    return I.$eq(RewriteBuffers.end$Const()) ? null : /*AddrOf*/I.$arrow().second;
  }

  
  // Iterators over rewrite buffers.
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::buffer_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 177,
   FQN="clang::Rewriter::buffer_begin", NM="_ZN5clang8Rewriter12buffer_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter12buffer_beginEv")
  //</editor-fold>
  public std.mapTypeType.iterator<FileID, RewriteBuffer> buffer_begin() {
    return RewriteBuffers.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::buffer_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 178,
   FQN="clang::Rewriter::buffer_end", NM="_ZN5clang8Rewriter10buffer_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8Rewriter10buffer_endEv")
  //</editor-fold>
  public std.mapTypeType.iterator<FileID, RewriteBuffer> buffer_end() {
    return RewriteBuffers.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::buffer_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 179,
   FQN="clang::Rewriter::buffer_begin", NM="_ZNK5clang8Rewriter12buffer_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZNK5clang8Rewriter12buffer_beginEv")
  //</editor-fold>
  public std.mapTypeType.iterator<FileID, RewriteBuffer> buffer_begin$Const() /*const*/ {
    return RewriteBuffers.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::buffer_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 180,
   FQN="clang::Rewriter::buffer_end", NM="_ZNK5clang8Rewriter10buffer_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZNK5clang8Rewriter10buffer_endEv")
  //</editor-fold>
  public std.mapTypeType.iterator<FileID, RewriteBuffer> buffer_end$Const() /*const*/ {
    return RewriteBuffers.end$Const();
  }

  
  /// overwriteChangedFiles - Save all changed files to disk.
  ///
  /// Returns true if any files were not saved successfully.
  /// Outputs diagnostics via the source manager's diagnostic engine
  /// in case of an error.
  
  /// overwriteChangedFiles - Save all changed files to disk.
  ///
  /// Returns true if any files were not saved successfully.
  /// Outputs diagnostics via the source manager's diagnostic engine
  /// in case of an error.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::overwriteChangedFiles">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 446,
   FQN="clang::Rewriter::overwriteChangedFiles", NM="_ZN5clang8Rewriter21overwriteChangedFilesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN5clang8Rewriter21overwriteChangedFilesEv")
  //</editor-fold>
  public boolean overwriteChangedFiles() {
    bool$ref AllWritten = create_bool$ref(true);
    for (std.mapTypeType.iterator<FileID, RewriteBuffer> I = buffer_begin(), E = buffer_end(); I.$noteq(E); I.$preInc()) {
      AtomicallyMovedFile File = null;
      try {
        /*const*/ FileEntry /*P*/ Entry = getSourceMgr().getFileEntryForID(/*NO_COPY*/I.$arrow().first);
        File/*J*/= new AtomicallyMovedFile(getSourceMgr().getDiagnostics(), new StringRef(Entry.getName()), 
            AllWritten);
        if (File.ok()) {
          I.$arrow().second.write(File.getStream());
        }
      } finally {
        if (File != null) { File.$destroy(); }
      }
    }
    return !AllWritten.$deref();
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::getLocationOffsetAndFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 212,
   FQN="clang::Rewriter::getLocationOffsetAndFileID", NM="_ZNK5clang8Rewriter26getLocationOffsetAndFileIDENS_14SourceLocationERNS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZNK5clang8Rewriter26getLocationOffsetAndFileIDENS_14SourceLocationERNS_6FileIDE")
  //</editor-fold>
  private /*uint*/int getLocationOffsetAndFileID(SourceLocation Loc, 
                            FileID /*&*/ FID) /*const*/ {
    assert (Loc.isValid()) : "Invalid location";
    std.pairTypeUInt<FileID> V = SourceMgr.getDecomposedLoc(/*NO_COPY*/Loc);
    FID.$assign(V.first);
    return V.second;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Rewriter::~Rewriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/Rewriter.h", line = 31,
   FQN="clang::Rewriter::~Rewriter", NM="_ZN5clang8RewriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN5clang8RewriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    RewriteBuffers.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SourceMgr=" + NativeTrace.getIdentityStr(SourceMgr) // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", RewriteBuffers=" + RewriteBuffers; // NOI18N
  }
}
