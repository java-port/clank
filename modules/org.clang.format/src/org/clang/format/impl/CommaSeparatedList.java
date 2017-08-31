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
import static org.clank.java.io.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.format.*;
import static org.clang.format.impl.FormatStatics.*;
import org.clank.support.Native.NativePOD;

//<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 515,
 FQN="clang::format::CommaSeparatedList", NM="_ZN5clang6format18CommaSeparatedListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedListE")
//</editor-fold>
public class CommaSeparatedList extends /*public*/ TokenRole implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::CommaSeparatedList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 517,
   FQN="clang::format::CommaSeparatedList::CommaSeparatedList", NM="_ZN5clang6format18CommaSeparatedListC1ERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedListC1ERKNS0_11FormatStyleE")
  //</editor-fold>
  public CommaSeparatedList(final /*const*/ FormatStyle /*&*/ Style) {
    // : TokenRole(Style), Commas(), ItemLengths(), Formats(), HasNestedBracedList(false) 
    //START JInit
    super(Style);
    this.Commas = new SmallVector</*const*/ FormatToken /*P*/ >(8, (/*const*/ FormatToken /*P*/ )null);
    this.ItemLengths = new SmallVectorUInt(8, 0);
    this.Formats = new SmallVector<ColumnFormat>(4, new ColumnFormat());
    this.HasNestedBracedList = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::precomputeFormattingInfos">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 146,
   FQN="clang::format::CommaSeparatedList::precomputeFormattingInfos", NM="_ZN5clang6format18CommaSeparatedList25precomputeFormattingInfosEPKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList25precomputeFormattingInfosEPKNS0_11FormatTokenE")
  //</editor-fold>
  @Override public void precomputeFormattingInfos(/*const*/ FormatToken /*P*/ Token)/* override*/ {
    std.vectorUInt/*uint*/ MinSizeInColumn = null;
    try {
      // FIXME: At some point we might want to do this for other lists, too.
      if (!(Token.MatchingParen != null)
         || !Token.isOneOf(tok.TokenKind.l_brace, TokenType.TT_ArrayInitializerLSquare)) {
        return;
      }
      
      // In C++11 braced list style, we should not format in columns unless they
      // have many items (20 or more) or we allow bin-packing of function call
      // arguments.
      if (Style.Cpp11BracedListStyle && !Style.BinPackArguments
         && $less_uint(Commas.size(), 19)) {
        return;
      }
      
      // Limit column layout for JavaScript array initializers to 20 or more items
      // for now to introduce it carefully. We can become more aggressive if this
      // necessary.
      if (Token.is_TokenType(TokenType.TT_ArrayInitializerLSquare) && $less_uint(Commas.size(), 19)) {
        return;
      }
      
      // Column format doesn't really make sense if we don't align after brackets.
      if (Style.AlignAfterOpenBracket == FormatStyle.BracketAlignmentStyle.BAS_DontAlign) {
        return;
      }
      
      FormatToken /*P*/ ItemBegin = Token.Next;
      while (ItemBegin.isTrailingComment()) {
        ItemBegin = ItemBegin.Next;
      }
      SmallVectorBool MustBreakBeforeItem/*J*/= new SmallVectorBool(8, false);
      
      // The lengths of an item if it is put at the end of the line. This includes
      // trailing comments which are otherwise ignored for column alignment.
      SmallVectorUInt EndOfLineItemLength/*J*/= new SmallVectorUInt(8, 0);
      
      boolean HasSeparatingComment = false;
      for (/*uint*/int i = 0, e = Commas.size() + 1; i != e; ++i) {
        // Skip comments on their own line.
        while (ItemBegin.HasUnescapedNewline && ItemBegin.isTrailingComment()) {
          ItemBegin = ItemBegin.Next;
          HasSeparatingComment = $greater_uint(i, 0);
        }
        
        MustBreakBeforeItem.push_back(ItemBegin.MustBreakBefore);
        if (ItemBegin.is_TokenKind(tok.TokenKind.l_brace)) {
          HasNestedBracedList = true;
        }
        /*const*/ FormatToken /*P*/ ItemEnd = null;
        if (i == Commas.size()) {
          ItemEnd = Token.MatchingParen;
          /*const*/ FormatToken /*P*/ NonCommentEnd = ItemEnd.getPreviousNonComment();
          ItemLengths.push_back(CodePointsBetween(ItemBegin, NonCommentEnd));
          if (Style.Cpp11BracedListStyle
             && !ItemEnd.Previous.isTrailingComment()) {
            // In Cpp11 braced list style, the } and possibly other subsequent
            // tokens will need to stay on a line with the last element.
            while ((ItemEnd.Next != null) && !ItemEnd.Next.CanBreakBefore) {
              ItemEnd = ItemEnd.Next;
            }
          } else {
            // In other braced lists styles, the "}" can be wrapped to the new line.
            ItemEnd = Token.MatchingParen.Previous;
          }
        } else {
          ItemEnd = Commas.$at(i);
          // The comma is counted as part of the item when calculating the length.
          ItemLengths.push_back(CodePointsBetween(ItemBegin, ItemEnd));
          
          // Consume trailing comments so the are included in EndOfLineItemLength.
          if ((ItemEnd.Next != null) && !ItemEnd.Next.HasUnescapedNewline
             && ItemEnd.Next.isTrailingComment()) {
            ItemEnd = ItemEnd.Next;
          }
        }
        EndOfLineItemLength.push_back(CodePointsBetween(ItemBegin, ItemEnd));
        // If there is a trailing comma in the list, the next item will start at the
        // closing brace. Don't create an extra item for this.
        if (ItemEnd.getNextNonComment() == Token.MatchingParen) {
          break;
        }
        ItemBegin = ItemEnd.Next;
      }
      
      // Don't use column layout for lists with few elements and in presence of
      // separating comments.
      if ($less_uint(Commas.size(), 5) || HasSeparatingComment) {
        return;
      }
      if (Token.NestingLevel != 0 && Token.is_TokenKind(tok.TokenKind.l_brace) && $less_uint(Commas.size(), 19)) {
        return;
      }
      
      // We can never place more than ColumnLimit / 3 items in a row (because of the
      // spaces and the comma).
      /*uint*/int MaxItems = $div_uint(Style.ColumnLimit, 3);
      MinSizeInColumn/*J*/= new std.vectorUInt/*uint*/();
      MinSizeInColumn.reserve(MaxItems);
      for (/*uint*/int Columns = 1; $lesseq_uint(Columns, MaxItems); ++Columns) {
        ColumnFormat Format = null;
        try {
          Format/*J*/= new ColumnFormat();
          Format.Columns = Columns;
          Format.ColumnSizes.resize(Columns);
          MinSizeInColumn.assign(Columns, UINT_MAX);
          Format.LineCount = 1;
          boolean HasRowWithSufficientColumns = false;
          /*uint*/int Column = 0;
          for (/*uint*/int i = 0, e = ItemLengths.size(); i != e; ++i) {
            assert ($less_uint(i, MustBreakBeforeItem.size()));
            if (MustBreakBeforeItem.$at(i) || Column == Columns) {
              ++Format.LineCount;
              Column = 0;
            }
            if (Column == Columns - 1) {
              HasRowWithSufficientColumns = true;
            }
            /*uint*/int Length = (Column == Columns - 1) ? EndOfLineItemLength.$at(i) : ItemLengths.$at(i);
            Format.ColumnSizes.$set(Column, std.max(Format.ColumnSizes.$at(Column), Length));
            MinSizeInColumn.$set(Column, std.min_uint(MinSizeInColumn.$at(Column), Length));
            ++Column;
          }
          // If all rows are terminated early (e.g. by trailing comments), we don't
          // need to look further.
          if (!HasRowWithSufficientColumns) {
            break;
          }
          Format.TotalWidth = Columns - 1; // Width of the N-1 spaces.
          
          for (/*uint*/int i = 0; $less_uint(i, Columns); ++i)  {
            Format.TotalWidth += Format.ColumnSizes.$at(i);
          }
          
          // Don't use this Format, if the difference between the longest and shortest
          // element in a column exceeds a threshold to avoid excessive spaces.
          final int Columns_final = Columns;
          final ColumnFormat Format_final = Format;
          std.vectorUInt/*uint*/ MinSizeInColumn_final = MinSizeInColumn;
          VoidBoolPredicate preficate = /*[&, &Columns, &Format, &MinSizeInColumn]*/() -> {
                for (/*uint*/int i = 0; $less_uint(i, Columns_final - 1); ++i)  {
                  if ($greater_uint(Format_final.ColumnSizes.$at(i) - MinSizeInColumn_final.$at(i), 10)) {
                    return true;
                  }
                }
                return false;
              };
          if (preficate.$call()) {
            continue;
          }
          
          // Ignore layouts that are bound to violate the column limit.
          if ($greater_uint(Format.TotalWidth, Style.ColumnLimit)) {
            continue;
          }
          
          Formats.push_back_T$C$R(Format);
        } finally {
          if (Format != null) { Format.$destroy(); }
        }
      }
    } finally {
      if (MinSizeInColumn != null) { MinSizeInColumn.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::formatAfterToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 75,
   FQN="clang::format::CommaSeparatedList::formatAfterToken", NM="_ZN5clang6format18CommaSeparatedList16formatAfterTokenERNS0_9LineStateEPNS0_20ContinuationIndenterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList16formatAfterTokenERNS0_9LineStateEPNS0_20ContinuationIndenterEb")
  //</editor-fold>
  @Override public /*uint*/int formatAfterToken(final LineState /*&*/ State, 
                  ContinuationIndenter /*P*/ Indenter, 
                  boolean DryRun)/* override*/ {
    if (State.NextToken == null || !(State.NextToken.Previous != null)) {
      return 0;
    }
    
    // Ensure that we start on the opening brace.
    /*const*/ FormatToken /*P*/ LBrace = State.NextToken.Previous.getPreviousNonComment();
    if (!(LBrace != null) || !LBrace.isOneOf(tok.TokenKind.l_brace, TokenType.TT_ArrayInitializerLSquare)
       || LBrace.BlockKind == BraceBlockKind.BK_Block || LBrace.Type == TokenType.TT_DictLiteral
       || LBrace.Next.Type == TokenType.TT_DesignatedInitializerPeriod) {
      return 0;
    }
    
    // Calculate the number of code points we have to format this list. As the
    // first token is already placed, we have to subtract it.
    /*uint*/int RemainingCodePoints = Style.ColumnLimit - State.Column + State.NextToken.Previous.ColumnWidth;
    
    // Find the best ColumnFormat, i.e. the best number of columns to use.
    /*const*/ ColumnFormat /*P*/ Format = getColumnFormat(RemainingCodePoints);
    // If no ColumnFormat can be used, the braced list would generally be
    // bin-packed. Add a severe penalty to this so that column layouts are
    // preferred if possible.
    if (!(Format != null)) {
      return 10000;
    }
    
    // Format the entire list.
    /*uint*/int Penalty = 0;
    /*uint*/int Column = 0;
    /*uint*/int Item = 0;
    while (State.NextToken != LBrace.MatchingParen) {
      boolean NewLine = false;
      /*uint*/int ExtraSpaces = 0;
      
      // If the previous token was one of our commas, we are now on the next item.
      if ($less_uint(Item, Commas.size()) && State.NextToken.Previous == Commas.$at(Item)) {
        if (!State.NextToken.isTrailingComment()) {
          ExtraSpaces += Format.ColumnSizes.$at$Const(Column) - ItemLengths.$at(Item);
          ++Column;
        }
        ++Item;
      }
      if (Column == Format.Columns || State.NextToken.MustBreakBefore) {
        Column = 0;
        NewLine = true;
      }
      
      // Place token using the continuation indenter and store the penalty.
      Penalty += Indenter.addTokenToState(State, NewLine, DryRun, ExtraSpaces);
    }
    return Penalty;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::formatFromToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 130,
   FQN="clang::format::CommaSeparatedList::formatFromToken", NM="_ZN5clang6format18CommaSeparatedList15formatFromTokenERNS0_9LineStateEPNS0_20ContinuationIndenterEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList15formatFromTokenERNS0_9LineStateEPNS0_20ContinuationIndenterEb")
  //</editor-fold>
  @Override public /*uint*/int formatFromToken(final LineState /*&*/ State, 
                 ContinuationIndenter /*P*/ Indenter, 
                 boolean DryRun)/* override*/ {
    if (HasNestedBracedList) {
      State.Stack.back().AvoidBinPacking = true;
    }
    return 0;
  }

  
  /// \brief Adds \p Token as the next comma to the \c CommaSeparated list.
  //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::CommaFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 529,
   FQN="clang::format::CommaSeparatedList::CommaFound", NM="_ZN5clang6format18CommaSeparatedList10CommaFoundEPKNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList10CommaFoundEPKNS0_11FormatTokenE")
  //</editor-fold>
  @Override public void CommaFound(/*const*/ FormatToken /*P*/ Token)/* override*/ {
    Commas.push_back(Token);
  }

/*private:*/
  /// \brief A struct that holds information on how to format a given list with
  /// a specific number of columns.
  //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::ColumnFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 536,
   FQN="clang::format::CommaSeparatedList::ColumnFormat", NM="_ZN5clang6format18CommaSeparatedList12ColumnFormatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList12ColumnFormatE")
  //</editor-fold>
  private static class/*struct*/ ColumnFormat implements NativePOD<ColumnFormat>, Destructors.ClassWithDestructor {
    /// \brief The number of columns to use.
    public /*uint*/int Columns;
    
    /// \brief The total width in characters.
    public /*uint*/int TotalWidth;
    
    /// \brief The number of lines required for this format.
    public /*uint*/int LineCount;
    
    /// \brief The size of each column in characters.
    public SmallVectorUInt ColumnSizes;
    //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::ColumnFormat::ColumnFormat">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 536,
     FQN="clang::format::CommaSeparatedList::ColumnFormat::ColumnFormat", NM="_ZN5clang6format18CommaSeparatedList12ColumnFormatC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList12ColumnFormatC1EOS2_")
    //</editor-fold>
    public /*inline*/ ColumnFormat(JD$Move _dparam, final ColumnFormat /*&&*/$Prm0) {
      // : Columns(static_cast<ColumnFormat &&>().Columns), TotalWidth(static_cast<ColumnFormat &&>().TotalWidth), LineCount(static_cast<ColumnFormat &&>().LineCount), ColumnSizes(static_cast<ColumnFormat &&>().ColumnSizes) 
      //START JInit
      this.Columns = $Prm0.Columns;
      this.TotalWidth = $Prm0.TotalWidth;
      this.LineCount = $Prm0.LineCount;
      this.ColumnSizes = new SmallVectorUInt(JD$Move.INSTANCE, $Prm0.ColumnSizes);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::ColumnFormat::ColumnFormat">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 536,
     FQN="clang::format::CommaSeparatedList::ColumnFormat::ColumnFormat", NM="_ZN5clang6format18CommaSeparatedList12ColumnFormatC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList12ColumnFormatC1Ev")
    //</editor-fold>
    public /*inline*/ ColumnFormat() {
      // : ColumnSizes() 
      //START JInit
      this.ColumnSizes = new SmallVectorUInt(8, 0);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::ColumnFormat::ColumnFormat">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 536,
     FQN="clang::format::CommaSeparatedList::ColumnFormat::ColumnFormat", NM="_ZN5clang6format18CommaSeparatedList12ColumnFormatC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList12ColumnFormatC1ERKS2_")
    //</editor-fold>
    public /*inline*/ ColumnFormat(final /*const*/ ColumnFormat /*&*/ $Prm0) {
      // : Columns(.Columns), TotalWidth(.TotalWidth), LineCount(.LineCount), ColumnSizes(.ColumnSizes) 
      //START JInit
      this.Columns = $Prm0.Columns;
      this.TotalWidth = $Prm0.TotalWidth;
      this.LineCount = $Prm0.LineCount;
      this.ColumnSizes = new SmallVectorUInt($Prm0.ColumnSizes);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::ColumnFormat::~ColumnFormat">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 536,
     FQN="clang::format::CommaSeparatedList::ColumnFormat::~ColumnFormat", NM="_ZN5clang6format18CommaSeparatedList12ColumnFormatD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedList12ColumnFormatD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      ColumnSizes.$destroy();
      //END JDestroy
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public ColumnFormat $assign(ColumnFormat other) {
      this.ColumnSizes.$assign(other.ColumnSizes);
      this.Columns = other.Columns;
      this.LineCount = other.LineCount;
      this.TotalWidth = other.TotalWidth;
      return this;
    }
    
    @Override
    public ColumnFormat clone() {
      return new ColumnFormat(this);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Columns=" + Columns // NOI18N
                + ", TotalWidth=" + TotalWidth // NOI18N
                + ", LineCount=" + LineCount // NOI18N
                + ", ColumnSizes=" + ColumnSizes; // NOI18N
    }
  };
  
  /// \brief Calculate which \c ColumnFormat fits best into
  /// \p RemainingCharacters.
  //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::getColumnFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp", line = 284,
   FQN="clang::format::CommaSeparatedList::getColumnFormat", NM="_ZNK5clang6format18CommaSeparatedList15getColumnFormatEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZNK5clang6format18CommaSeparatedList15getColumnFormatEj")
  //</editor-fold>
  private /*const*/ CommaSeparatedList.ColumnFormat /*P*/ getColumnFormat(/*uint*/int RemainingCharacters) /*const*/ {
    /*const*/ ColumnFormat /*P*/ BestFormat = null;
    for (std.reverse_iterator</*const*/ ColumnFormat> I = Formats.rbegin$Const(), 
        E = Formats.rend$Const();
         $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      if ($lesseq_uint(I.$arrow().TotalWidth, RemainingCharacters)) {
        if ((BestFormat != null) && $greater_uint(I.$arrow().LineCount, BestFormat.LineCount)) {
          break;
        }
        BestFormat = /*AddrOf*/I.$star();
      }
    }
    return BestFormat;
  }

  
  /// \brief The ordered \c FormatTokens making up the commas of this list.
  private SmallVector</*const*/ FormatToken /*P*/ > Commas;
  
  /// \brief The length of each of the list's items in characters including the
  /// trailing comma.
  private SmallVectorUInt ItemLengths;
  
  /// \brief Precomputed formats that can be used for this list.
  private SmallVector<ColumnFormat> Formats;
  
  private boolean HasNestedBracedList;
  //<editor-fold defaultstate="collapsed" desc="clang::format::CommaSeparatedList::~CommaSeparatedList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.h", line = 515,
   FQN="clang::format::CommaSeparatedList::~CommaSeparatedList", NM="_ZN5clang6format18CommaSeparatedListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/FormatToken.cpp -nm=_ZN5clang6format18CommaSeparatedListD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Formats.$destroy();
    ItemLengths.$destroy();
    Commas.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Commas=" + Commas // NOI18N
              + ", ItemLengths=" + ItemLengths // NOI18N
              + ", Formats=" + Formats // NOI18N
              + ", HasNestedBracedList=" + HasNestedBracedList // NOI18N
              + super.toString(); // NOI18N
  }
}
