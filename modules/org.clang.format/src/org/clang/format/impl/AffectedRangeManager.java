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

package org.clang.format.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.h", line = 26,
 FQN="clang::format::AffectedRangeManager", NM="_ZN5clang6format20AffectedRangeManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp -nm=_ZN5clang6format20AffectedRangeManagerE")
//</editor-fold>
public class AffectedRangeManager implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager::AffectedRangeManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.h", line = 28,
   FQN="clang::format::AffectedRangeManager::AffectedRangeManager", NM="_ZN5clang6format20AffectedRangeManagerC1ERKNS_13SourceManagerEN4llvm8ArrayRefINS_15CharSourceRangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp -nm=_ZN5clang6format20AffectedRangeManagerC1ERKNS_13SourceManagerEN4llvm8ArrayRefINS_15CharSourceRangeEEE")
  //</editor-fold>
  public AffectedRangeManager(final /*const*/ SourceManager /*&*/ SourceMgr, 
      /*const*/ArrayRef<CharSourceRange> Ranges) {
    // : SourceMgr(SourceMgr), Ranges(Ranges.begin(), Ranges.end()) 
    //START JInit
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this.Ranges = new SmallVector<CharSourceRange/*,8*/>(JD$T.INSTANCE, 8, Ranges.begin(), Ranges.end(), new CharSourceRange());
    //END JInit
  }

  
  // Determines which lines are affected by the SourceRanges given as input.
  // Returns \c true if at least one line between I and E or one of their
  // children is affected.
  //<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager::computeAffectedLines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp", line = 23,
   FQN="clang::format::AffectedRangeManager::computeAffectedLines", NM="_ZN5clang6format20AffectedRangeManager20computeAffectedLinesEPPNS0_13AnnotatedLineES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp -nm=_ZN5clang6format20AffectedRangeManager20computeAffectedLinesEPPNS0_13AnnotatedLineES4_")
  //</editor-fold>
  public boolean computeAffectedLines(type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                      type$ptr<AnnotatedLine /*P*/ /*P*/> E) {
    boolean SomeLineAffected = false;
    /*const*/ AnnotatedLine /*P*/ PreviousLine = null;
    while ($noteq_ptr(I, E)) {
      AnnotatedLine /*P*/ Line = I.$star();
      Line.LeadingEmptyLinesAffected = affectsLeadingEmptyLines(/*Deref*/Line.First);
      
      // If a line is part of a preprocessor directive, it needs to be formatted
      // if any token within the directive is affected.
      if (Line.InPPDirective) {
        FormatToken /*P*/ Last = Line.Last;
        type$ptr<AnnotatedLine /*P*/ /*P*/> PPEnd = $tryClone(I.$add(1));
        while ($noteq_ptr(PPEnd, E) && !(PPEnd.$star()).First.HasUnescapedNewline) {
          Last = (PPEnd.$star()).Last;
          PPEnd.$preInc();
        }
        if (affectsTokenRange(/*Deref*/Line.First, /*Deref*/Last, 
            /*IncludeLeadingNewlines=*/ false)) {
          SomeLineAffected = true;
          markAllAsAffected(I, PPEnd);
        }
        I = $tryClone(PPEnd);
        continue;
      }
      if (nonPPLineAffected(Line, PreviousLine)) {
        SomeLineAffected = true;
      }
      
      PreviousLine = Line;
      I.$preInc();
    }
    return SomeLineAffected;
  }

  
  // Returns true if 'Range' intersects with one of the input ranges.
  //<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager::affectsCharSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp", line = 60,
   FQN="clang::format::AffectedRangeManager::affectsCharSourceRange", NM="_ZN5clang6format20AffectedRangeManager22affectsCharSourceRangeERKNS_15CharSourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp -nm=_ZN5clang6format20AffectedRangeManager22affectsCharSourceRangeERKNS_15CharSourceRangeE")
  //</editor-fold>
  public boolean affectsCharSourceRange(final /*const*/ CharSourceRange /*&*/ Range) {
    for (type$ptr<CharSourceRange> I = $tryClone(Ranges.begin$Const()), 
        /*P*/ E = $tryClone(Ranges.end$Const());
         $noteq_ptr(I, E); I.$preInc()) {
      if (!SourceMgr.isBeforeInTranslationUnit(Range.getEnd(), I./*->*/$star().getBegin())
         && !SourceMgr.isBeforeInTranslationUnit(I./*->*/$star().getEnd(), Range.getBegin())) {
        return true;
      }
    }
    return false;
  }

/*private:*/
  // Returns true if the range from 'First' to 'Last' intersects with one of the
  // input ranges.
  //<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager::affectsTokenRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp", line = 72,
   FQN="clang::format::AffectedRangeManager::affectsTokenRange", NM="_ZN5clang6format20AffectedRangeManager17affectsTokenRangeERKNS0_11FormatTokenES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp -nm=_ZN5clang6format20AffectedRangeManager17affectsTokenRangeERKNS0_11FormatTokenES4_b")
  //</editor-fold>
  private boolean affectsTokenRange(final /*const*/ FormatToken /*&*/ First, 
                   final /*const*/ FormatToken /*&*/ Last, 
                   boolean IncludeLeadingNewlines) {
    SourceLocation Start = First.WhitespaceRange.getBegin();
    if (!IncludeLeadingNewlines) {
      Start.$assignMove(Start.getLocWithOffset(First.LastNewlineOffset));
    }
    SourceLocation End = Last.getStartOfNonWhitespace();
    End.$assignMove(End.getLocWithOffset(Last.TokenText.size()));
    CharSourceRange Range = CharSourceRange.getCharRange(/*NO_COPY*/Start, /*NO_COPY*/End);
    return affectsCharSourceRange(Range);
  }

  
  // Returns true if one of the input ranges intersect the leading empty lines
  // before 'Tok'.
  //<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager::affectsLeadingEmptyLines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp", line = 84,
   FQN="clang::format::AffectedRangeManager::affectsLeadingEmptyLines", NM="_ZN5clang6format20AffectedRangeManager24affectsLeadingEmptyLinesERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp -nm=_ZN5clang6format20AffectedRangeManager24affectsLeadingEmptyLinesERKNS0_11FormatTokenE")
  //</editor-fold>
  private boolean affectsLeadingEmptyLines(final /*const*/ FormatToken /*&*/ Tok) {
    CharSourceRange EmptyLineRange = CharSourceRange.getCharRange(Tok.WhitespaceRange.getBegin(), 
        Tok.WhitespaceRange.getBegin().getLocWithOffset(Tok.LastNewlineOffset));
    return affectsCharSourceRange(EmptyLineRange);
  }

  
  // Marks all lines between I and E as well as all their children as affected.
  //<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager::markAllAsAffected">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp", line = 91,
   FQN="clang::format::AffectedRangeManager::markAllAsAffected", NM="_ZN5clang6format20AffectedRangeManager17markAllAsAffectedEPPNS0_13AnnotatedLineES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp -nm=_ZN5clang6format20AffectedRangeManager17markAllAsAffectedEPPNS0_13AnnotatedLineES4_")
  //</editor-fold>
  private void markAllAsAffected(type$ptr<AnnotatedLine /*P*/ /*P*/> I, 
                   type$ptr<AnnotatedLine /*P*/ /*P*/> E) {
    while ($noteq_ptr(I, E)) {
      (I.$star()).Affected = true;
      markAllAsAffected((I.$star()).Children.begin(), (I.$star()).Children.end());
      I.$preInc();
    }
  }

  
  // Determines whether 'Line' is affected by the SourceRanges given as input.
  // Returns \c true if line or one if its children is affected.
  //<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager::nonPPLineAffected">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp", line = 101,
   FQN="clang::format::AffectedRangeManager::nonPPLineAffected", NM="_ZN5clang6format20AffectedRangeManager17nonPPLineAffectedEPNS0_13AnnotatedLineEPKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.cpp -nm=_ZN5clang6format20AffectedRangeManager17nonPPLineAffectedEPNS0_13AnnotatedLineEPKS2_")
  //</editor-fold>
  private boolean nonPPLineAffected(AnnotatedLine /*P*/ Line, /*const*/ AnnotatedLine /*P*/ PreviousLine) {
    boolean SomeLineAffected = false;
    Line.ChildrenAffected
       = computeAffectedLines(Line.Children.begin(), Line.Children.end());
    if (Line.ChildrenAffected) {
      SomeLineAffected = true;
    }
    
    // Stores whether one of the line's tokens is directly affected.
    boolean SomeTokenAffected = false;
    // Stores whether we need to look at the leading newlines of the next token
    // in order to determine whether it was affected.
    boolean IncludeLeadingNewlines = false;
    
    // Stores whether the first child line of any of this line's tokens is
    // affected.
    boolean SomeFirstChildAffected = false;
    
    for (FormatToken /*P*/ Tok = Line.First; (Tok != null); Tok = Tok.Next) {
      // Determine whether 'Tok' was affected.
      if (affectsTokenRange(/*Deref*/Tok, /*Deref*/Tok, IncludeLeadingNewlines)) {
        SomeTokenAffected = true;
      }
      
      // Determine whether the first child of 'Tok' was affected.
      if (!Tok.Children.empty() && Tok.Children.front().Affected) {
        SomeFirstChildAffected = true;
      }
      
      IncludeLeadingNewlines = Tok.Children.empty();
    }
    
    // Was this line moved, i.e. has it previously been on the same line as an
    // affected line?
    boolean LineMoved = (PreviousLine != null) && PreviousLine.Affected
       && Line.First.NewlinesBefore == 0;
    
    boolean IsContinuedComment = Line.First.is_TokenKind(tok.TokenKind.comment) && Line.First.Next == null
       && $less_uint(Line.First.NewlinesBefore, 2) && (PreviousLine != null)
       && PreviousLine.Affected && PreviousLine.Last.is_TokenKind(tok.TokenKind.comment);
    if (SomeTokenAffected || SomeFirstChildAffected || LineMoved
       || IsContinuedComment) {
      Line.Affected = true;
      SomeLineAffected = true;
    }
    return SomeLineAffected;
  }

  
  private final /*const*/ SourceManager /*&*/ SourceMgr;
  private /*const*/SmallVector<CharSourceRange/*,8*/> Ranges;

  //<editor-fold defaultstate="collapsed" desc="clang::format::AffectedRangeManager::~AffectedRangeManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/AffectedRangeManager.h", line = 26,
   FQN="clang::format::AffectedRangeManager::~AffectedRangeManager", NM="_ZN5clang6format20AffectedRangeManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format20AffectedRangeManagerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Ranges.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "SourceMgr=" + "[SourceManager]" // NOI18N
              + ", Ranges=" + Ranges; // NOI18N
  }
}
