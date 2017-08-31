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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;


/// \brief The current state when indenting a unwrapped line.
///
/// As the indenting tries different combinations this is copied by value.
//<editor-fold defaultstate="collapsed" desc="clang::format::LineState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 310,
 FQN="clang::format::LineState", NM="_ZN5clang6format9LineStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format9LineStateE")
//</editor-fold>
public class/*struct*/ LineState implements Destructors.ClassWithDestructor {
  /// \brief The number of used columns in the current line.
  public /*uint*/int Column;
  
  /// \brief The token that needs to be next formatted.
  public FormatToken /*P*/ NextToken;
  
  /// \brief \c true if this line contains a continued for-loop section.
  public boolean LineContainsContinuedForLoopSection;
  
  /// \brief The \c NestingLevel at the start of this line.
  public /*uint*/int StartOfLineLevel;
  
  /// \brief The lowest \c NestingLevel on the current line.
  public /*uint*/int LowestLevelOnLine;
  
  /// \brief The start column of the string literal, if we're in a string
  /// literal sequence, 0 otherwise.
  public /*uint*/int StartOfStringLiteral;
  
  /// \brief A stack keeping track of properties applying to parenthesis
  /// levels.
  public std.vector<ParenState> Stack;
  
  /// \brief Ignore the stack of \c ParenStates for state comparison.
  ///
  /// In long and deeply nested unwrapped lines, the current algorithm can
  /// be insufficient for finding the best formatting with a reasonable amount
  /// of time and memory. Setting this flag will effectively lead to the
  /// algorithm not analyzing some combinations. However, these combinations
  /// rarely contain the optimal solution: In short, accepting a higher
  /// penalty early would need to lead to different values in the \c
  /// ParenState stack (in an otherwise identical state) and these different
  /// values would need to lead to a significant amount of avoided penalty
  /// later.
  ///
  /// FIXME: Come up with a better algorithm instead.
  public boolean IgnoreStackForComparison;
  
  /// \brief The indent of the first token.
  public /*uint*/int FirstIndent;
  
  /// \brief The line that is being formatted.
  ///
  /// Does not need to be considered for memoization because it doesn't change.
  public /*const*/ AnnotatedLine /*P*/ Line;
  
  /// \brief Comparison operator to be able to used \c LineState in \c map.
  //<editor-fold defaultstate="collapsed" desc="clang::format::LineState::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 358,
   FQN="clang::format::LineState::operator<", NM="_ZNK5clang6format9LineStateltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZNK5clang6format9LineStateltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ LineState /*&*/ Other) /*const*/ {
    if (NextToken != Other.NextToken) {
      return NextToken.$allocation < Other.NextToken.$allocation;
    }
    if (Column != Other.Column) {
      return $less_uint(Column, Other.Column);
    }
    if (LineContainsContinuedForLoopSection
       != Other.LineContainsContinuedForLoopSection) {
      return LineContainsContinuedForLoopSection;
    }
    if (StartOfLineLevel != Other.StartOfLineLevel) {
      return $less_uint(StartOfLineLevel, Other.StartOfLineLevel);
    }
    if (LowestLevelOnLine != Other.LowestLevelOnLine) {
      return $less_uint(LowestLevelOnLine, Other.LowestLevelOnLine);
    }
    if (StartOfStringLiteral != Other.StartOfStringLiteral) {
      return $less_uint(StartOfStringLiteral, Other.StartOfStringLiteral);
    }
    if (IgnoreStackForComparison || Other.IgnoreStackForComparison) {
      return false;
    }
    return std.$less_vector$_Tp$_Alloc$C(Stack, Other.Stack, (ParenState one, ParenState other) -> one.$less(other));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::LineState::LineState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 310,
   FQN="clang::format::LineState::LineState", NM="_ZN5clang6format9LineStateC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format9LineStateC1EOS1_")
  //</editor-fold>
  public /*inline*/ LineState(JD$Move _dparam, final LineState /*&&*/$Prm0) {
    // : Column(static_cast<LineState &&>().Column), NextToken(static_cast<LineState &&>().NextToken), LineContainsContinuedForLoopSection(static_cast<LineState &&>().LineContainsContinuedForLoopSection), StartOfLineLevel(static_cast<LineState &&>().StartOfLineLevel), LowestLevelOnLine(static_cast<LineState &&>().LowestLevelOnLine), StartOfStringLiteral(static_cast<LineState &&>().StartOfStringLiteral), Stack(static_cast<LineState &&>().Stack), IgnoreStackForComparison(static_cast<LineState &&>().IgnoreStackForComparison), FirstIndent(static_cast<LineState &&>().FirstIndent), Line(static_cast<LineState &&>().Line) 
    //START JInit
    this.Column = $Prm0.Column;
    this.NextToken = $Prm0.NextToken;
    this.LineContainsContinuedForLoopSection = $Prm0.LineContainsContinuedForLoopSection;
    this.StartOfLineLevel = $Prm0.StartOfLineLevel;
    this.LowestLevelOnLine = $Prm0.LowestLevelOnLine;
    this.StartOfStringLiteral = $Prm0.StartOfStringLiteral;
    this.Stack = new std.vector<ParenState>(JD$Move.INSTANCE, $Prm0.Stack);
    this.IgnoreStackForComparison = $Prm0.IgnoreStackForComparison;
    this.FirstIndent = $Prm0.FirstIndent;
    this.Line = $Prm0.Line;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::LineState::~LineState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 310,
   FQN="clang::format::LineState::~LineState", NM="_ZN5clang6format9LineStateD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format9LineStateD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Stack.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::LineState::LineState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 310,
   FQN="clang::format::LineState::LineState", NM="_ZN5clang6format9LineStateC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format9LineStateC1Ev")
  //</editor-fold>
  public /*inline*/ LineState() {
    // : Stack() 
    //START JInit
    this.Stack = new std.vector<ParenState>(new ParenState());
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::format::LineState::LineState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 310,
   FQN="clang::format::LineState::LineState", NM="_ZN5clang6format9LineStateC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format9LineStateC1ERKS1_")
  //</editor-fold>
  public /*inline*/ LineState(final /*const*/ LineState /*&*/ $Prm0) {
    // : Column(.Column), NextToken(.NextToken), LineContainsContinuedForLoopSection(.LineContainsContinuedForLoopSection), StartOfLineLevel(.StartOfLineLevel), LowestLevelOnLine(.LowestLevelOnLine), StartOfStringLiteral(.StartOfStringLiteral), Stack(.Stack), IgnoreStackForComparison(.IgnoreStackForComparison), FirstIndent(.FirstIndent), Line(.Line) 
    //START JInit
    this.Column = $Prm0.Column;
    this.NextToken = $Prm0.NextToken;
    this.LineContainsContinuedForLoopSection = $Prm0.LineContainsContinuedForLoopSection;
    this.StartOfLineLevel = $Prm0.StartOfLineLevel;
    this.LowestLevelOnLine = $Prm0.LowestLevelOnLine;
    this.StartOfStringLiteral = $Prm0.StartOfStringLiteral;
    this.Stack = new std.vector<ParenState>($Prm0.Stack);
    this.IgnoreStackForComparison = $Prm0.IgnoreStackForComparison;
    this.FirstIndent = $Prm0.FirstIndent;
    this.Line = $Prm0.Line;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Column=" + Column // NOI18N
              //+ ", NextToken=" + NextToken // NOI18N
              + ", LineContainsContinuedForLoopSection=" + LineContainsContinuedForLoopSection // NOI18N
              + ", StartOfLineLevel=" + StartOfLineLevel // NOI18N
              + ", LowestLevelOnLine=" + LowestLevelOnLine // NOI18N
              + ", StartOfStringLiteral=" + StartOfStringLiteral // NOI18N
              + ", Stack=" + Stack // NOI18N
              + ", IgnoreStackForComparison=" + IgnoreStackForComparison // NOI18N
              + ", FirstIndent=" + FirstIndent // NOI18N
              + ", Line=" + Line; // NOI18N
  }
}
