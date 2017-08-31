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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;


/// \brief Tracks the indent level of \c AnnotatedLines across levels.
///
/// \c nextLine must be called for each \c AnnotatedLine, after which \c
/// getIndent() will return the indent for the last line \c nextLine was called
/// with.
/// If the line is not formatted (and thus the indent does not change), calling
/// \c adjustToUnmodifiedLine after the call to \c nextLine will cause
/// subsequent lines on the same level to be indented at the same level as the
/// given line.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LevelIndentTracker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 37,
 FQN="clang::format::(anonymous namespace)::LevelIndentTracker", NM="_ZN5clang6format12_GLOBAL__N_118LevelIndentTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118LevelIndentTrackerE")
//</editor-fold>
public class LevelIndentTracker implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LevelIndentTracker::LevelIndentTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 39,
   FQN="clang::format::(anonymous namespace)::LevelIndentTracker::LevelIndentTracker", NM="_ZN5clang6format12_GLOBAL__N_118LevelIndentTrackerC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118LevelIndentTrackerC1ERKNS0_11FormatStyleERKNS0_18AdditionalKeywordsEji")
  //</editor-fold>
  public LevelIndentTracker(final /*const*/ FormatStyle /*&*/ Style, 
      final /*const*/ AdditionalKeywords /*&*/ Keywords, /*uint*/int StartLevel, 
      int AdditionalIndent) {
    // : Style(Style), Keywords(Keywords), AdditionalIndent(AdditionalIndent), IndentForLevel(), Offset(0), Indent(0) 
    //START JInit
    this./*&*/Style=/*&*/Style;
    this./*&*/Keywords=/*&*/Keywords;
    this.AdditionalIndent = AdditionalIndent;
    this.IndentForLevel = new std.vectorInt();
    /*InClass*/this.Offset = 0;
    /*InClass*/this.Indent = 0;
    //END JInit
    for (/*uint*/int i = 0; i != StartLevel; ++i)  {
      IndentForLevel.push_back_T$RR(Style.IndentWidth * i + AdditionalIndent);
    }
  }

  
  /// \brief Returns the indent for the current line.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LevelIndentTracker::getIndent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 48,
   FQN="clang::format::(anonymous namespace)::LevelIndentTracker::getIndent", NM="_ZNK5clang6format12_GLOBAL__N_118LevelIndentTracker9getIndentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZNK5clang6format12_GLOBAL__N_118LevelIndentTracker9getIndentEv")
  //</editor-fold>
  public /*uint*/int getIndent() /*const*/ {
    return Indent;
  }

  
  /// \brief Update the indent state given that \p Line is going to be formatted
  /// next.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LevelIndentTracker::nextLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 52,
   FQN="clang::format::(anonymous namespace)::LevelIndentTracker::nextLine", NM="_ZN5clang6format12_GLOBAL__N_118LevelIndentTracker8nextLineERKNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118LevelIndentTracker8nextLineERKNS0_13AnnotatedLineE")
  //</editor-fold>
  public void nextLine(final /*const*/ AnnotatedLine /*&*/ Line) {
    Offset = getIndentOffset(/*Deref*/Line.First);
    // Update the indent level cache size so that we can rely on it
    // having the right size in adjustToUnmodifiedline.
    while ($lesseq_uint(IndentForLevel.size(), Line.Level)) {
      IndentForLevel.push_back_T$RR(-1);
    }
    if (Line.InPPDirective) {
      Indent = Line.Level * Style.IndentWidth + AdditionalIndent;
    } else {
      IndentForLevel.resize(Line.Level + 1);
      Indent = getIndent(new ArrayRefInt(IndentForLevel), Line.Level);
    }
    if (((/*static_cast*/int)(Indent)) + Offset >= 0) {
      Indent += Offset;
    }
  }

  
  /// \brief Update the level indent to adapt to the given \p Line.
  ///
  /// When a line is not formatted, we move the subsequent lines on the same
  /// level to the same indent.
  /// Note that \c nextLine must have been called before this method.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LevelIndentTracker::adjustToUnmodifiedLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 73,
   FQN="clang::format::(anonymous namespace)::LevelIndentTracker::adjustToUnmodifiedLine", NM="_ZN5clang6format12_GLOBAL__N_118LevelIndentTracker22adjustToUnmodifiedLineERKNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118LevelIndentTracker22adjustToUnmodifiedLineERKNS0_13AnnotatedLineE")
  //</editor-fold>
  public void adjustToUnmodifiedLine(final /*const*/ AnnotatedLine /*&*/ Line) {
    /*uint*/int LevelIndent = Line.First.OriginalColumn;
    if (((/*static_cast*/int)(LevelIndent)) - Offset >= 0) {
      LevelIndent -= Offset;
    }
    if ((!Line.First.is_TokenKind(tok.TokenKind.comment) || IndentForLevel.$at(Line.Level) == -1)
       && !Line.InPPDirective) {
      IndentForLevel.$set(Line.Level, LevelIndent);
    }
  }

/*private:*/
  /// \brief Get the offset of the line relatively to the level.
  ///
  /// For example, 'public:' labels in classes are offset by 1 or 2
  /// characters to the left from their level.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LevelIndentTracker::getIndentOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 87,
   FQN="clang::format::(anonymous namespace)::LevelIndentTracker::getIndentOffset", NM="_ZN5clang6format12_GLOBAL__N_118LevelIndentTracker15getIndentOffsetERKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118LevelIndentTracker15getIndentOffsetERKNS0_11FormatTokenE")
  //</editor-fold>
  private int getIndentOffset(final /*const*/ FormatToken /*&*/ RootToken) {
    if (Style.Language == FormatStyle.LanguageKind.LK_Java
       || Style.Language == FormatStyle.LanguageKind.LK_JavaScript) {
      return 0;
    }
    if (RootToken.isAccessSpecifier(false)
       || RootToken.isObjCAccessSpecifier()
       || (RootToken.isOneOf(Keywords.kw_signals, Keywords.kw_qsignals)
       && (RootToken.Next != null) && RootToken.Next.is_TokenKind(tok.TokenKind.colon))) {
      return Style.AccessModifierOffset;
    }
    return 0;
  }

  
  /// \brief Get the indent of \p Level from \p IndentForLevel.
  ///
  /// \p IndentForLevel must contain the indent for the level \c l
  /// at \p IndentForLevel[l], or a value < 0 if the indent for
  /// that level is unknown.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LevelIndentTracker::getIndent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 104,
   FQN="clang::format::(anonymous namespace)::LevelIndentTracker::getIndent", NM="_ZN5clang6format12_GLOBAL__N_118LevelIndentTracker9getIndentEN4llvm8ArrayRefIiEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118LevelIndentTracker9getIndentEN4llvm8ArrayRefIiEEj")
  //</editor-fold>
  private /*uint*/int getIndent(ArrayRefInt IndentForLevel, /*uint*/int Level) {
    if (IndentForLevel.$at(Level) != -1) {
      return IndentForLevel.$at(Level);
    }
    if (Level == 0) {
      return 0;
    }
    return getIndent(new ArrayRefInt(IndentForLevel), Level - 1) + Style.IndentWidth;
  }

  
  private final /*const*/ FormatStyle /*&*/ Style;
  private final /*const*/ AdditionalKeywords /*&*/ Keywords;
  private /*const*//*uint*/int AdditionalIndent;
  
  /// \brief The indent in characters for each level.
  private std.vectorInt IndentForLevel;
  
  /// \brief Offset of the current line relative to the indent level.
  ///
  /// For example, the 'public' keywords is often indented with a negative
  /// offset.
  private int Offset/* = 0*/;
  
  /// \brief The current line's indent.
  private /*uint*/int Indent/* = 0*/;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LevelIndentTracker::~LevelIndentTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 37,
   FQN="clang::format::(anonymous namespace)::LevelIndentTracker::~LevelIndentTracker", NM="_ZN5clang6format12_GLOBAL__N_118LevelIndentTrackerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_118LevelIndentTrackerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    IndentForLevel.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Style=" + Style // NOI18N
              + ", Keywords=" + Keywords // NOI18N
              + ", AdditionalIndent=" + AdditionalIndent // NOI18N
              + ", IndentForLevel=" + IndentForLevel // NOI18N
              + ", Offset=" + Offset // NOI18N
              + ", Indent=" + Indent; // NOI18N
  }
}
