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

package org.clang.ast.comments;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;


/// \brief Information about a single command.
///
/// When reordering, adding or removing members please update the corresponding
/// TableGen backend.
//<editor-fold defaultstate="collapsed" desc="clang::comments::CommandInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 33,
 FQN="clang::comments::CommandInfo", NM="_ZN5clang8comments11CommandInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments11CommandInfoE")
//</editor-fold>
public class/*struct*/ CommandInfo {
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandInfo::getID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 34,
   FQN="clang::comments::CommandInfo::getID", NM="_ZNK5clang8comments11CommandInfo5getIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZNK5clang8comments11CommandInfo5getIDEv")
  //</editor-fold>
  public /*uint*/int getID() /*const*/ {
    return ID;
  }

  
  public /*const*/char$ptr/*char P*/ Name;
  
  /// Name of the command that ends the verbatim block.
  public /*const*/char$ptr/*char P*/ EndCommandName;
  
  /// DRY definition of the number of bits used for a command ID.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::CommandInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentCommandTraits.h", line = 44,
   FQN="clang::comments::CommandInfo::(anonymous)", NM="_ZN5clang8comments11CommandInfoE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments11CommandInfoE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumCommandIDBits = 20;
  /*}*/;
  
  /// The ID of the command.
  public /*uint*/int ID /*: NumCommandIDBits*/;
  
  /// Number of word-like arguments for a given block command, except for
  /// \\param and \\tparam commands -- these have special argument parsers.
  public /*JBYTE unsigned int*/ byte NumArgs /*: 4*/;
  
  /// True if this command is a inline command (of any kind).
  public /*JBIT unsigned int*/ boolean IsInlineCommand /*: 1*/;
  
  /// True if this command is a block command (of any kind).
  public /*JBIT unsigned int*/ boolean IsBlockCommand /*: 1*/;
  
  /// True if this command is introducing a brief documentation
  /// paragraph (\\brief or an alias).
  public /*JBIT unsigned int*/ boolean IsBriefCommand /*: 1*/;
  
  /// True if this command is \\returns or an alias.
  public /*JBIT unsigned int*/ boolean IsReturnsCommand /*: 1*/;
  
  /// True if this command is introducing documentation for a function
  /// parameter (\\param or an alias).
  public /*JBIT unsigned int*/ boolean IsParamCommand /*: 1*/;
  
  /// True if this command is introducing documentation for
  /// a template parameter (\\tparam or an alias).
  public /*JBIT unsigned int*/ boolean IsTParamCommand /*: 1*/;
  
  /// True if this command is \\throws or an alias.
  public /*JBIT unsigned int*/ boolean IsThrowsCommand /*: 1*/;
  
  /// True if this command is \\deprecated or an alias.
  public /*JBIT unsigned int*/ boolean IsDeprecatedCommand /*: 1*/;
  
  /// \brief True if this is a \\headerfile-like command.
  public /*JBIT unsigned int*/ boolean IsHeaderfileCommand /*: 1*/;
  
  /// True if we don't want to warn about this command being passed an empty
  /// paragraph.  Meaningful only for block commands.
  public /*JBIT unsigned int*/ boolean IsEmptyParagraphAllowed /*: 1*/;
  
  /// \brief True if this command is a verbatim-like block command.
  ///
  /// A verbatim-like block command eats every character (except line starting
  /// decorations) until matching end command is seen or comment end is hit.
  public /*JBIT unsigned int*/ boolean IsVerbatimBlockCommand /*: 1*/;
  
  /// \brief True if this command is an end command for a verbatim-like block.
  public /*JBIT unsigned int*/ boolean IsVerbatimBlockEndCommand /*: 1*/;
  
  /// \brief True if this command is a verbatim line command.
  ///
  /// A verbatim-like line command eats everything until a newline is seen or
  /// comment end is hit.
  public /*JBIT unsigned int*/ boolean IsVerbatimLineCommand /*: 1*/;
  
  /// \brief True if this command contains a declaration for the entity being
  /// documented.
  ///
  /// For example:
  /// \code
  ///   \fn void f(int a);
  /// \endcode
  public /*JBIT unsigned int*/ boolean IsDeclarationCommand /*: 1*/;
  
  /// \brief True if verbatim-like line command is a function declaration.
  public /*JBIT unsigned int*/ boolean IsFunctionDeclarationCommand /*: 1*/;
  
  /// \brief True if block command is further describing a container API; such
  /// as \@coclass, \@classdesign, etc.
  public /*JBIT unsigned int*/ boolean IsRecordLikeDetailCommand /*: 1*/;
  
  /// \brief True if block command is a container API; such as \@interface.
  public /*JBIT unsigned int*/ boolean IsRecordLikeDeclarationCommand /*: 1*/;
  
  /// \brief True if this command is unknown.  This \c CommandInfo object was
  /// created during parsing.
  public /*JBIT unsigned int*/ boolean IsUnknownCommand /*: 1*/;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public CommandInfo() {
    //=zero-initialize
  }
  public CommandInfo(char$ptr Name, char$ptr EndCommandName, int ID, int NumArgs, int IsInlineCommand, int IsBlockCommand, int IsBriefCommand, int IsReturnsCommand, int IsParamCommand, int IsTParamCommand, int IsThrowsCommand, int IsDeprecatedCommand, int IsHeaderfileCommand, int IsEmptyParagraphAllowed, int IsVerbatimBlockCommand, int IsVerbatimBlockEndCommand, int IsVerbatimLineCommand, int IsDeclarationCommand, int IsFunctionDeclarationCommand, int IsRecordLikeDetailCommand, int IsRecordLikeDeclarationCommand, int IsUnknownCommand) {
    this.Name = Name;
    this.EndCommandName = EndCommandName;
    this.ID = ID;
    this.NumArgs = (byte) NumArgs;
    this.IsInlineCommand = IsInlineCommand != 0;
    this.IsBlockCommand = IsBlockCommand != 0;
    this.IsBriefCommand = IsBriefCommand != 0;
    this.IsReturnsCommand = IsReturnsCommand != 0;
    this.IsParamCommand = IsParamCommand != 0;
    this.IsTParamCommand = IsTParamCommand != 0;
    this.IsThrowsCommand = IsThrowsCommand != 0;
    this.IsDeprecatedCommand = IsDeprecatedCommand != 0;
    this.IsHeaderfileCommand = IsHeaderfileCommand != 0;
    this.IsEmptyParagraphAllowed = IsEmptyParagraphAllowed != 0;
    this.IsVerbatimBlockCommand = IsVerbatimBlockCommand != 0;
    this.IsVerbatimBlockEndCommand = IsVerbatimBlockEndCommand != 0;
    this.IsVerbatimLineCommand = IsVerbatimLineCommand != 0;
    this.IsDeclarationCommand = IsDeclarationCommand != 0;
    this.IsFunctionDeclarationCommand = IsFunctionDeclarationCommand != 0;
    this.IsRecordLikeDetailCommand = IsRecordLikeDetailCommand != 0;
    this.IsRecordLikeDeclarationCommand = IsRecordLikeDeclarationCommand != 0;
    this.IsUnknownCommand = IsUnknownCommand != 0;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", EndCommandName=" + EndCommandName // NOI18N
              + ", ID=" + ID // NOI18N
              + ", NumArgs=" + $uchar2uint(NumArgs) // NOI18N
              + ", IsInlineCommand=" + IsInlineCommand // NOI18N
              + ", IsBlockCommand=" + IsBlockCommand // NOI18N
              + ", IsBriefCommand=" + IsBriefCommand // NOI18N
              + ", IsReturnsCommand=" + IsReturnsCommand // NOI18N
              + ", IsParamCommand=" + IsParamCommand // NOI18N
              + ", IsTParamCommand=" + IsTParamCommand // NOI18N
              + ", IsThrowsCommand=" + IsThrowsCommand // NOI18N
              + ", IsDeprecatedCommand=" + IsDeprecatedCommand // NOI18N
              + ", IsHeaderfileCommand=" + IsHeaderfileCommand // NOI18N
              + ", IsEmptyParagraphAllowed=" + IsEmptyParagraphAllowed // NOI18N
              + ", IsVerbatimBlockCommand=" + IsVerbatimBlockCommand // NOI18N
              + ", IsVerbatimBlockEndCommand=" + IsVerbatimBlockEndCommand // NOI18N
              + ", IsVerbatimLineCommand=" + IsVerbatimLineCommand // NOI18N
              + ", IsDeclarationCommand=" + IsDeclarationCommand // NOI18N
              + ", IsFunctionDeclarationCommand=" + IsFunctionDeclarationCommand // NOI18N
              + ", IsRecordLikeDetailCommand=" + IsRecordLikeDetailCommand // NOI18N
              + ", IsRecordLikeDeclarationCommand=" + IsRecordLikeDeclarationCommand // NOI18N
              + ", IsUnknownCommand=" + IsUnknownCommand; // NOI18N
  }
}
