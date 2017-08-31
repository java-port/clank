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
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.clang.format.*;


/// \brief Base class for classes that format one \c AnnotatedLine.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineFormatter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 473,
 FQN="clang::format::(anonymous namespace)::LineFormatter", NM="_ZN5clang6format12_GLOBAL__N_113LineFormatterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_113LineFormatterE")
//</editor-fold>
public abstract class LineFormatter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineFormatter::LineFormatter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 475,
   FQN="clang::format::(anonymous namespace)::LineFormatter::LineFormatter", NM="_ZN5clang6format12_GLOBAL__N_113LineFormatterC1EPNS0_20ContinuationIndenterEPNS0_17WhitespaceManagerERKNS0_11FormatStyleEPNS0_22UnwrappedLineFormatterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_113LineFormatterC1EPNS0_20ContinuationIndenterEPNS0_17WhitespaceManagerERKNS0_11FormatStyleEPNS0_22UnwrappedLineFormatterE")
  //</editor-fold>
  public LineFormatter(ContinuationIndenter /*P*/ Indenter, WhitespaceManager /*P*/ Whitespaces, 
      final /*const*/ FormatStyle /*&*/ Style, 
      UnwrappedLineFormatter /*P*/ BlockFormatter) {
    // : Indenter(Indenter), Whitespaces(Whitespaces), Style(Style), BlockFormatter(BlockFormatter) 
    //START JInit
    this.Indenter = Indenter;
    this.Whitespaces = Whitespaces;
    this./*&*/Style=/*&*/Style;
    this.BlockFormatter = BlockFormatter;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineFormatter::~LineFormatter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 480,
   FQN="clang::format::(anonymous namespace)::LineFormatter::~LineFormatter", NM="_ZN5clang6format12_GLOBAL__N_113LineFormatterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_113LineFormatterD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  /// \brief Formats an \c AnnotatedLine and returns the penalty.
  ///
  /// If \p DryRun is \c false, directly applies the changes.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineFormatter::formatLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 485,
   FQN="clang::format::(anonymous namespace)::LineFormatter::formatLine", NM="_ZN5clang6format12_GLOBAL__N_113LineFormatter10formatLineERKNS0_13AnnotatedLineEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_113LineFormatter10formatLineERKNS0_13AnnotatedLineEjb")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int formatLine(final /*const*/ AnnotatedLine /*&*/ Line, /*uint*/int FirstIndent, 
            boolean DryRun)/* = 0*/;

/*protected:*/
  /// \brief If the \p State's next token is an r_brace closing a nested block,
  /// format the nested block before it.
  ///
  /// Returns \c true if all children could be placed successfully and adapts
  /// \p Penalty as well as \p State. If \p DryRun is false, also directly
  /// creates changes using \c Whitespaces.
  ///
  /// The crucial idea here is that children always get formatted upon
  /// encountering the closing brace right after the nested block. Now, if we
  /// are currently trying to keep the "}" on the same line (i.e. \p NewLine is
  /// \c false), the entire block has to be kept on the same line (which is only
  /// possible if it fits on the line, only contains a single statement, etc.
  ///
  /// If \p NewLine is true, we format the nested block on separate lines, i.e.
  /// break after the "{", format all lines with correct indentation and the put
  /// the closing "}" on yet another new line.
  ///
  /// This enables us to keep the simple structure of the
  /// \c UnwrappedLineFormatter, where we only have two options for each token:
  /// break or don't break.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::LineFormatter::formatChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp", line = 509,
   FQN="clang::format::(anonymous namespace)::LineFormatter::formatChildren", NM="_ZN5clang6format12_GLOBAL__N_113LineFormatter14formatChildrenERNS0_9LineStateEbbRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/UnwrappedLineFormatter.cpp -nm=_ZN5clang6format12_GLOBAL__N_113LineFormatter14formatChildrenERNS0_9LineStateEbbRj")
  //</editor-fold>
  protected boolean formatChildren(final LineState /*&*/ State, boolean NewLine, boolean DryRun, 
                final uint$ref/*uint &*/ Penalty) {
    /*const*/ FormatToken /*P*/ LBrace = State.NextToken.getPreviousNonComment();
    final FormatToken /*&*/ Previous = /*Deref*/State.NextToken.Previous;
    if (!(LBrace != null) || LBrace.isNot(tok.TokenKind.l_brace)
       || LBrace.BlockKind != BraceBlockKind.BK_Block || Previous.Children.size() == 0) {
      // The previous token does not open a block. Nothing to do. We don't
      // assert so that we can simply call this function for all tokens.
      return true;
    }
    if (NewLine) {
      int AdditionalIndent = State.Stack.back().Indent
         - Previous.Children.$at(0).Level * Style.IndentWidth;
      
      Penalty.$set$addassign(BlockFormatter.format(Previous.Children, DryRun, AdditionalIndent, 
          /*FixBadIndentation=*/ true));
      return true;
    }
    if (Previous.Children.$at(0).First.MustBreakBefore) {
      return false;
    }
    
    // Cannot merge multiple statements into a single line.
    if ($greater_uint(Previous.Children.size(), 1)) {
      return false;
    }
    
    // Cannot merge into one line if this line ends on a comment.
    if (Previous.is_TokenKind(tok.TokenKind.comment)) {
      return false;
    }
    
    // We can't put the closing "}" on a line with a trailing comment.
    if (Previous.Children.$at(0).Last.isTrailingComment()) {
      return false;
    }
    
    // If the child line exceeds the column limit, we wouldn't want to merge it.
    // We add +2 for the trailing " }".
    if ($greater_uint(Style.ColumnLimit, 0)
       && $greater_uint(Previous.Children.$at(0).Last.TotalLength + State.Column + 2
      , Style.ColumnLimit)) {
      return false;
    }
    if (!DryRun) {
      Whitespaces.replaceWhitespace(/*Deref*/Previous.Children.$at(0).First, 
          /*Newlines=*/ 0, /*IndentLevel=*/ 0, /*Spaces=*/ 1, 
          /*StartOfTokenColumn=*/ State.Column, State.Line.InPPDirective);
    }
    Penalty.$set$addassign(formatLine(/*Deref*/Previous.Children.$at(0), State.Column + 1, DryRun));
    
    State.Column += 1 + Previous.Children.$at(0).Last.TotalLength;
    return true;
  }

  
  protected ContinuationIndenter /*P*/ Indenter;
/*private:*/
  private WhitespaceManager /*P*/ Whitespaces;
  private final /*const*/ FormatStyle /*&*/ Style;
  private UnwrappedLineFormatter /*P*/ BlockFormatter;
  
  @Override public String toString() {
    return "" + "Indenter=" + Indenter // NOI18N
              + ", Whitespaces=" + "[WhitespaceManager]" // NOI18N
              + ", Style=" + Style // NOI18N
              + ", BlockFormatter=" + BlockFormatter; // NOI18N
  }
}
