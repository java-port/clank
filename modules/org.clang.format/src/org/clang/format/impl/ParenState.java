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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::ParenState">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 148,
 FQN="clang::format::ParenState", NM="_ZN5clang6format10ParenStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format10ParenStateE")
//</editor-fold>
public class/*struct*/ ParenState implements Native.NativePOD<ParenState> {
  //<editor-fold defaultstate="collapsed" desc="clang::format::ParenState::ParenState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 149,
   FQN="clang::format::ParenState::ParenState", NM="_ZN5clang6format10ParenStateC1Ejjjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format10ParenStateC1Ejjjbb")
  //</editor-fold>
  public ParenState(/*uint*/int Indent, /*uint*/int IndentLevel, /*uint*/int LastSpace, 
      boolean AvoidBinPacking, boolean NoLineBreak) {
    // : Indent(Indent), IndentLevel(IndentLevel), LastSpace(LastSpace), NestedBlockIndent(Indent), FirstLessLess(0), QuestionColumn(0), ColonPos(0), StartOfFunctionCall(0), StartOfArraySubscripts(0), NestedNameSpecifierContinuation(0), CallContinuation(0), VariablePos(0), BreakBeforeClosingBrace(false), AvoidBinPacking(AvoidBinPacking), BreakBeforeParameter(false), NoLineBreak(NoLineBreak), LastOperatorWrapped(true), ContainsLineBreak(false), ContainsUnwrappedBuilder(false), AlignColons(true), ObjCSelectorNameFound(false), HasMultipleNestedBlocks(false), NestedBlockInlined(false) 
    //START JInit
    this.Indent = Indent;
    this.IndentLevel = IndentLevel;
    this.LastSpace = LastSpace;
    this.NestedBlockIndent = Indent;
    /*InClass*/this.FirstLessLess = 0;
    /*InClass*/this.QuestionColumn = 0;
    /*InClass*/this.ColonPos = 0;
    /*InClass*/this.StartOfFunctionCall = 0;
    /*InClass*/this.StartOfArraySubscripts = 0;
    /*InClass*/this.NestedNameSpecifierContinuation = 0;
    /*InClass*/this.CallContinuation = 0;
    /*InClass*/this.VariablePos = 0;
    this.BreakBeforeClosingBrace = false;
    this.AvoidBinPacking = AvoidBinPacking;
    this.BreakBeforeParameter = false;
    this.NoLineBreak = NoLineBreak;
    this.LastOperatorWrapped = true;
    this.ContainsLineBreak = false;
    this.ContainsUnwrappedBuilder = false;
    this.AlignColons = true;
    this.ObjCSelectorNameFound = false;
    this.HasMultipleNestedBlocks = false;
    this.NestedBlockInlined = false;
    //END JInit
  }

  
  /// \brief The position to which a specific parenthesis level needs to be
  /// indented.
  public /*uint*/int Indent;
  
  /// \brief The number of indentation levels of the block.
  public /*uint*/int IndentLevel;
  
  /// \brief The position of the last space on each level.
  ///
  /// Used e.g. to break like:
  /// functionCall(Parameter, otherCall(
  ///                             OtherParameter));
  public /*uint*/int LastSpace;
  
  /// \brief If a block relative to this parenthesis level gets wrapped, indent
  /// it this much.
  public /*uint*/int NestedBlockIndent;
  
  /// \brief The position the first "<<" operator encountered on each level.
  ///
  /// Used to align "<<" operators. 0 if no such operator has been encountered
  /// on a level.
  public /*uint*/int FirstLessLess/* = 0*/;
  
  /// \brief The column of a \c ? in a conditional expression;
  public /*uint*/int QuestionColumn/* = 0*/;
  
  /// \brief The position of the colon in an ObjC method declaration/call.
  public /*uint*/int ColonPos/* = 0*/;
  
  /// \brief The start of the most recent function in a builder-type call.
  public /*uint*/int StartOfFunctionCall/* = 0*/;
  
  /// \brief Contains the start of array subscript expressions, so that they
  /// can be aligned.
  public /*uint*/int StartOfArraySubscripts/* = 0*/;
  
  /// \brief If a nested name specifier was broken over multiple lines, this
  /// contains the start column of the second line. Otherwise 0.
  public /*uint*/int NestedNameSpecifierContinuation/* = 0*/;
  
  /// \brief If a call expression was broken over multiple lines, this
  /// contains the start column of the second line. Otherwise 0.
  public /*uint*/int CallContinuation/* = 0*/;
  
  /// \brief The column of the first variable name in a variable declaration.
  ///
  /// Used to align further variables if necessary.
  public /*uint*/int VariablePos/* = 0*/;
  
  /// \brief Whether a newline needs to be inserted before the block's closing
  /// brace.
  ///
  /// We only want to insert a newline before the closing brace if there also
  /// was a newline after the beginning left brace.
  public /*JBIT bool*/ boolean BreakBeforeClosingBrace /*: 1*/;
  
  /// \brief Avoid bin packing, i.e. multiple parameters/elements on multiple
  /// lines, in this context.
  public /*JBIT bool*/ boolean AvoidBinPacking /*: 1*/;
  
  /// \brief Break after the next comma (or all the commas in this context if
  /// \c AvoidBinPacking is \c true).
  public /*JBIT bool*/ boolean BreakBeforeParameter /*: 1*/;
  
  /// \brief Line breaking in this context would break a formatting rule.
  public /*JBIT bool*/ boolean NoLineBreak /*: 1*/;
  
  /// \brief True if the last binary operator on this level was wrapped to the
  /// next line.
  public /*JBIT bool*/ boolean LastOperatorWrapped /*: 1*/;
  
  /// \brief \c true if this \c ParenState already contains a line-break.
  ///
  /// The first line break in a certain \c ParenState causes extra penalty so
  /// that clang-format prefers similar breaks, i.e. breaks in the same
  /// parenthesis.
  public /*JBIT bool*/ boolean ContainsLineBreak /*: 1*/;
  
  /// \brief \c true if this \c ParenState contains multiple segments of a
  /// builder-type call on one line.
  public /*JBIT bool*/ boolean ContainsUnwrappedBuilder /*: 1*/;
  
  /// \brief \c true if the colons of the curren ObjC method expression should
  /// be aligned.
  ///
  /// Not considered for memoization as it will always have the same value at
  /// the same token.
  public /*JBIT bool*/ boolean AlignColons /*: 1*/;
  
  /// \brief \c true if at least one selector name was found in the current
  /// ObjC method expression.
  ///
  /// Not considered for memoization as it will always have the same value at
  /// the same token.
  public /*JBIT bool*/ boolean ObjCSelectorNameFound /*: 1*/;
  
  /// \brief \c true if there are multiple nested blocks inside these parens.
  ///
  /// Not considered for memoization as it will always have the same value at
  /// the same token.
  public /*JBIT bool*/ boolean HasMultipleNestedBlocks /*: 1*/;
  
  // \brief The start of a nested block (e.g. lambda introducer in C++ or
  // "function" in JavaScript) is not wrapped to a new line.
  public /*JBIT bool*/ boolean NestedBlockInlined /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::format::ParenState::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 266,
   FQN="clang::format::ParenState::operator<", NM="_ZNK5clang6format10ParenStateltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZNK5clang6format10ParenStateltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ ParenState /*&*/ Other) /*const*/ {
    if (Indent != Other.Indent) {
      return $less_uint(Indent, Other.Indent);
    }
    if (LastSpace != Other.LastSpace) {
      return $less_uint(LastSpace, Other.LastSpace);
    }
    if (NestedBlockIndent != Other.NestedBlockIndent) {
      return $less_uint(NestedBlockIndent, Other.NestedBlockIndent);
    }
    if (FirstLessLess != Other.FirstLessLess) {
      return $less_uint(FirstLessLess, Other.FirstLessLess);
    }
    if (BreakBeforeClosingBrace != Other.BreakBeforeClosingBrace) {
      return BreakBeforeClosingBrace;
    }
    if (QuestionColumn != Other.QuestionColumn) {
      return $less_uint(QuestionColumn, Other.QuestionColumn);
    }
    if (AvoidBinPacking != Other.AvoidBinPacking) {
      return AvoidBinPacking;
    }
    if (BreakBeforeParameter != Other.BreakBeforeParameter) {
      return BreakBeforeParameter;
    }
    if (NoLineBreak != Other.NoLineBreak) {
      return NoLineBreak;
    }
    if (LastOperatorWrapped != Other.LastOperatorWrapped) {
      return LastOperatorWrapped;
    }
    if (ColonPos != Other.ColonPos) {
      return $less_uint(ColonPos, Other.ColonPos);
    }
    if (StartOfFunctionCall != Other.StartOfFunctionCall) {
      return $less_uint(StartOfFunctionCall, Other.StartOfFunctionCall);
    }
    if (StartOfArraySubscripts != Other.StartOfArraySubscripts) {
      return $less_uint(StartOfArraySubscripts, Other.StartOfArraySubscripts);
    }
    if (CallContinuation != Other.CallContinuation) {
      return $less_uint(CallContinuation, Other.CallContinuation);
    }
    if (VariablePos != Other.VariablePos) {
      return $less_uint(VariablePos, Other.VariablePos);
    }
    if (ContainsLineBreak != Other.ContainsLineBreak) {
      return ContainsLineBreak;
    }
    if (ContainsUnwrappedBuilder != Other.ContainsUnwrappedBuilder) {
      return ContainsUnwrappedBuilder;
    }
    if (NestedBlockInlined != Other.NestedBlockInlined) {
      return NestedBlockInlined;
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::ParenState::ParenState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 148,
   FQN="clang::format::ParenState::ParenState", NM="_ZN5clang6format10ParenStateC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format10ParenStateC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ParenState(final /*const*/ ParenState /*&*/ $Prm0) {
    // : Indent(.Indent), IndentLevel(.IndentLevel), LastSpace(.LastSpace), NestedBlockIndent(.NestedBlockIndent), FirstLessLess(.FirstLessLess), QuestionColumn(.QuestionColumn), ColonPos(.ColonPos), StartOfFunctionCall(.StartOfFunctionCall), StartOfArraySubscripts(.StartOfArraySubscripts), NestedNameSpecifierContinuation(.NestedNameSpecifierContinuation), CallContinuation(.CallContinuation), VariablePos(.VariablePos), BreakBeforeClosingBrace(.BreakBeforeClosingBrace), AvoidBinPacking(.AvoidBinPacking), BreakBeforeParameter(.BreakBeforeParameter), NoLineBreak(.NoLineBreak), LastOperatorWrapped(.LastOperatorWrapped), ContainsLineBreak(.ContainsLineBreak), ContainsUnwrappedBuilder(.ContainsUnwrappedBuilder), AlignColons(.AlignColons), ObjCSelectorNameFound(.ObjCSelectorNameFound), HasMultipleNestedBlocks(.HasMultipleNestedBlocks), NestedBlockInlined(.NestedBlockInlined) 
    //START JInit
    this.Indent = $Prm0.Indent;
    this.IndentLevel = $Prm0.IndentLevel;
    this.LastSpace = $Prm0.LastSpace;
    this.NestedBlockIndent = $Prm0.NestedBlockIndent;
    this.FirstLessLess = $Prm0.FirstLessLess;
    this.QuestionColumn = $Prm0.QuestionColumn;
    this.ColonPos = $Prm0.ColonPos;
    this.StartOfFunctionCall = $Prm0.StartOfFunctionCall;
    this.StartOfArraySubscripts = $Prm0.StartOfArraySubscripts;
    this.NestedNameSpecifierContinuation = $Prm0.NestedNameSpecifierContinuation;
    this.CallContinuation = $Prm0.CallContinuation;
    this.VariablePos = $Prm0.VariablePos;
    this.BreakBeforeClosingBrace = $Prm0.BreakBeforeClosingBrace;
    this.AvoidBinPacking = $Prm0.AvoidBinPacking;
    this.BreakBeforeParameter = $Prm0.BreakBeforeParameter;
    this.NoLineBreak = $Prm0.NoLineBreak;
    this.LastOperatorWrapped = $Prm0.LastOperatorWrapped;
    this.ContainsLineBreak = $Prm0.ContainsLineBreak;
    this.ContainsUnwrappedBuilder = $Prm0.ContainsUnwrappedBuilder;
    this.AlignColons = $Prm0.AlignColons;
    this.ObjCSelectorNameFound = $Prm0.ObjCSelectorNameFound;
    this.HasMultipleNestedBlocks = $Prm0.HasMultipleNestedBlocks;
    this.NestedBlockInlined = $Prm0.NestedBlockInlined;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::ParenState::ParenState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.h", line = 148,
   FQN="clang::format::ParenState::ParenState", NM="_ZN5clang6format10ParenStateC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/ContinuationIndenter.cpp -nm=_ZN5clang6format10ParenStateC1EOS1_")
  //</editor-fold>
  public /*inline*/ ParenState(JD$Move _dparam, final ParenState /*&&*/$Prm0) {
    // : Indent(static_cast<ParenState &&>().Indent), IndentLevel(static_cast<ParenState &&>().IndentLevel), LastSpace(static_cast<ParenState &&>().LastSpace), NestedBlockIndent(static_cast<ParenState &&>().NestedBlockIndent), FirstLessLess(static_cast<ParenState &&>().FirstLessLess), QuestionColumn(static_cast<ParenState &&>().QuestionColumn), ColonPos(static_cast<ParenState &&>().ColonPos), StartOfFunctionCall(static_cast<ParenState &&>().StartOfFunctionCall), StartOfArraySubscripts(static_cast<ParenState &&>().StartOfArraySubscripts), NestedNameSpecifierContinuation(static_cast<ParenState &&>().NestedNameSpecifierContinuation), CallContinuation(static_cast<ParenState &&>().CallContinuation), VariablePos(static_cast<ParenState &&>().VariablePos), BreakBeforeClosingBrace(static_cast<ParenState &&>().BreakBeforeClosingBrace), AvoidBinPacking(static_cast<ParenState &&>().AvoidBinPacking), BreakBeforeParameter(static_cast<ParenState &&>().BreakBeforeParameter), NoLineBreak(static_cast<ParenState &&>().NoLineBreak), LastOperatorWrapped(static_cast<ParenState &&>().LastOperatorWrapped), ContainsLineBreak(static_cast<ParenState &&>().ContainsLineBreak), ContainsUnwrappedBuilder(static_cast<ParenState &&>().ContainsUnwrappedBuilder), AlignColons(static_cast<ParenState &&>().AlignColons), ObjCSelectorNameFound(static_cast<ParenState &&>().ObjCSelectorNameFound), HasMultipleNestedBlocks(static_cast<ParenState &&>().HasMultipleNestedBlocks), NestedBlockInlined(static_cast<ParenState &&>().NestedBlockInlined) 
    //START JInit
    this.Indent = $Prm0.Indent;
    this.IndentLevel = $Prm0.IndentLevel;
    this.LastSpace = $Prm0.LastSpace;
    this.NestedBlockIndent = $Prm0.NestedBlockIndent;
    this.FirstLessLess = $Prm0.FirstLessLess;
    this.QuestionColumn = $Prm0.QuestionColumn;
    this.ColonPos = $Prm0.ColonPos;
    this.StartOfFunctionCall = $Prm0.StartOfFunctionCall;
    this.StartOfArraySubscripts = $Prm0.StartOfArraySubscripts;
    this.NestedNameSpecifierContinuation = $Prm0.NestedNameSpecifierContinuation;
    this.CallContinuation = $Prm0.CallContinuation;
    this.VariablePos = $Prm0.VariablePos;
    this.BreakBeforeClosingBrace = $Prm0.BreakBeforeClosingBrace;
    this.AvoidBinPacking = $Prm0.AvoidBinPacking;
    this.BreakBeforeParameter = $Prm0.BreakBeforeParameter;
    this.NoLineBreak = $Prm0.NoLineBreak;
    this.LastOperatorWrapped = $Prm0.LastOperatorWrapped;
    this.ContainsLineBreak = $Prm0.ContainsLineBreak;
    this.ContainsUnwrappedBuilder = $Prm0.ContainsUnwrappedBuilder;
    this.AlignColons = $Prm0.AlignColons;
    this.ObjCSelectorNameFound = $Prm0.ObjCSelectorNameFound;
    this.HasMultipleNestedBlocks = $Prm0.HasMultipleNestedBlocks;
    this.NestedBlockInlined = $Prm0.NestedBlockInlined;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public ParenState() { }
  
  @Override
  public ParenState $assign(ParenState $Prm0) {
    this.Indent = $Prm0.Indent;
    this.IndentLevel = $Prm0.IndentLevel;
    this.LastSpace = $Prm0.LastSpace;
    this.NestedBlockIndent = $Prm0.NestedBlockIndent;
    this.FirstLessLess = $Prm0.FirstLessLess;
    this.QuestionColumn = $Prm0.QuestionColumn;
    this.ColonPos = $Prm0.ColonPos;
    this.StartOfFunctionCall = $Prm0.StartOfFunctionCall;
    this.StartOfArraySubscripts = $Prm0.StartOfArraySubscripts;
    this.NestedNameSpecifierContinuation = $Prm0.NestedNameSpecifierContinuation;
    this.CallContinuation = $Prm0.CallContinuation;
    this.VariablePos = $Prm0.VariablePos;
    this.BreakBeforeClosingBrace = $Prm0.BreakBeforeClosingBrace;
    this.AvoidBinPacking = $Prm0.AvoidBinPacking;
    this.BreakBeforeParameter = $Prm0.BreakBeforeParameter;
    this.NoLineBreak = $Prm0.NoLineBreak;
    this.LastOperatorWrapped = $Prm0.LastOperatorWrapped;
    this.ContainsLineBreak = $Prm0.ContainsLineBreak;
    this.ContainsUnwrappedBuilder = $Prm0.ContainsUnwrappedBuilder;
    this.AlignColons = $Prm0.AlignColons;
    this.ObjCSelectorNameFound = $Prm0.ObjCSelectorNameFound;
    this.HasMultipleNestedBlocks = $Prm0.HasMultipleNestedBlocks;
    this.NestedBlockInlined = $Prm0.NestedBlockInlined;
    return this;
  }

  @Override
  public ParenState clone() {
    ParenState res = new ParenState();
    res.$assign(this);
    return res;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Indent=" + Indent // NOI18N
              + ", IndentLevel=" + IndentLevel // NOI18N
              + ", LastSpace=" + LastSpace // NOI18N
              + ", NestedBlockIndent=" + NestedBlockIndent // NOI18N
              + ", FirstLessLess=" + FirstLessLess // NOI18N
              + ", QuestionColumn=" + QuestionColumn // NOI18N
              + ", ColonPos=" + ColonPos // NOI18N
              + ", StartOfFunctionCall=" + StartOfFunctionCall // NOI18N
              + ", StartOfArraySubscripts=" + StartOfArraySubscripts // NOI18N
              + ", NestedNameSpecifierContinuation=" + NestedNameSpecifierContinuation // NOI18N
              + ", CallContinuation=" + CallContinuation // NOI18N
              + ", VariablePos=" + VariablePos // NOI18N
              + ", BreakBeforeClosingBrace=" + BreakBeforeClosingBrace // NOI18N
              + ", AvoidBinPacking=" + AvoidBinPacking // NOI18N
              + ", BreakBeforeParameter=" + BreakBeforeParameter // NOI18N
              + ", NoLineBreak=" + NoLineBreak // NOI18N
              + ", LastOperatorWrapped=" + LastOperatorWrapped // NOI18N
              + ", ContainsLineBreak=" + ContainsLineBreak // NOI18N
              + ", ContainsUnwrappedBuilder=" + ContainsUnwrappedBuilder // NOI18N
              + ", AlignColons=" + AlignColons // NOI18N
              + ", ObjCSelectorNameFound=" + ObjCSelectorNameFound // NOI18N
              + ", HasMultipleNestedBlocks=" + HasMultipleNestedBlocks // NOI18N
              + ", NestedBlockInlined=" + NestedBlockInlined; // NOI18N
  }
}
