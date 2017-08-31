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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstRTTI.*;

/// Any part of the comment.
/// Abstract class.
//<editor-fold defaultstate="collapsed" desc="clang::comments::Comment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 53,
 FQN="clang::comments::Comment", NM="_ZN5clang8comments7CommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE")
//</editor-fold>
public class Comment {
/*protected:*/
  /// Preferred location to show caret.
  protected SourceLocation Loc;
  
  /// Source range of this AST node.
  protected SourceRange Range;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::CommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 61,
   FQN="clang::comments::Comment::CommentBitfields", NM="_ZN5clang8comments7Comment16CommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment16CommentBitfieldsE")
  //</editor-fold>
  protected static class CommentBitfields {
    /*friend  class Comment*/
    
    /// Type of this AST node.
    private /*JBYTE unsigned int*/ byte Kind /*: 8*/;
    
    @Override public String toString() {
      return "" + "Kind=" + CommentKind.valueOf($uchar2uint(Kind)); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 67,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumCommentBits = 8;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::InlineContentCommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 69,
   FQN="clang::comments::Comment::InlineContentCommentBitfields", NM="_ZN5clang8comments7Comment29InlineContentCommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment29InlineContentCommentBitfieldsE")
  //</editor-fold>
  protected static class InlineContentCommentBitfields {
    /*friend  class InlineContentComment*/
    
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumCommentBits*/;
    
    /// True if there is a newline after this inline content node.
    /// (There is no separate AST node for a newline.)
    protected/*private*/ /*JBIT unsigned int*/ boolean HasTrailingNewline /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", HasTrailingNewline=" + HasTrailingNewline; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 78,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumInlineContentCommentBits = NumCommentBits + 1;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::TextCommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 80,
   FQN="clang::comments::Comment::TextCommentBitfields", NM="_ZN5clang8comments7Comment20TextCommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment20TextCommentBitfieldsE")
  //</editor-fold>
  protected static class TextCommentBitfields {
    /*friend  class TextComment*/
    
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumInlineContentCommentBits*/;
    
    /// True if \c IsWhitespace field contains a valid value.
    protected/*private*/ /*mutable *//*JBIT unsigned int*/ boolean IsWhitespaceValid /*: 1*/;
  
    /// True if this comment AST node contains only whitespace.
    protected/*private*/ /*mutable *//*JBIT unsigned int*/ boolean IsWhitespace /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", IsWhitespaceValid=" + IsWhitespaceValid // NOI18N
                + ", IsWhitespace=" + IsWhitespace; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 91,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumTextCommentBits = NumInlineContentCommentBits + 2;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::InlineCommandCommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 93,
   FQN="clang::comments::Comment::InlineCommandCommentBitfields", NM="_ZN5clang8comments7Comment29InlineCommandCommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment29InlineCommandCommentBitfieldsE")
  //</editor-fold>
  protected static class InlineCommandCommentBitfields {
    /*friend  class InlineCommandComment*/
    
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumInlineContentCommentBits*/;
    
    protected/*private*/ /*JBYTE unsigned int*/ byte RenderKind /*: 2*/;
    protected/*private*/ /*uint*/int CommandID /*: CommandInfo.NumCommandIDBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", RenderKind=" + $uchar2uint(RenderKind) // NOI18N
                + ", CommandID=" + CommandID; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 101,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum3")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumInlineCommandCommentBits = NumInlineContentCommentBits + 2
       + CommandInfo.NumCommandIDBits;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::HTMLTagCommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 104,
   FQN="clang::comments::Comment::HTMLTagCommentBitfields", NM="_ZN5clang8comments7Comment23HTMLTagCommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment23HTMLTagCommentBitfieldsE")
  //</editor-fold>
  protected static class HTMLTagCommentBitfields {
    /*friend  class HTMLTagComment*/
    
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumInlineContentCommentBits*/;
    
    /// True if we found that this tag is malformed in some way.
    protected/*private*/ /*JBIT unsigned int*/ boolean IsMalformed /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", IsMalformed=" + IsMalformed; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 112,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum4",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum4")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumHTMLTagCommentBits = NumInlineContentCommentBits + 1;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::HTMLStartTagCommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 114,
   FQN="clang::comments::Comment::HTMLStartTagCommentBitfields", NM="_ZN5clang8comments7Comment28HTMLStartTagCommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment28HTMLStartTagCommentBitfieldsE")
  //</editor-fold>
  protected static class HTMLStartTagCommentBitfields {
    /*friend  class HTMLStartTagComment*/
    
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumHTMLTagCommentBits*/;
    
    /// True if this tag is self-closing (e. g., <br />).  This is based on tag
    /// spelling in comment (plain <br> would not set this flag).
     protected/*private*/ /*JBIT unsigned int*/ boolean IsSelfClosing /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", IsSelfClosing=" + IsSelfClosing; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 123,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum5",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum5")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumHTMLStartTagCommentBits = NumHTMLTagCommentBits + 1;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::ParagraphCommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 125,
   FQN="clang::comments::Comment::ParagraphCommentBitfields", NM="_ZN5clang8comments7Comment25ParagraphCommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment25ParagraphCommentBitfieldsE")
  //</editor-fold>
  protected static class ParagraphCommentBitfields {
    /*friend  class ParagraphComment*/
    
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumCommentBits*/;
    
    /// True if \c IsWhitespace field contains a valid value.
    protected/*private*/ /*mutable *//*JBIT unsigned int*/ boolean IsWhitespaceValid /*: 1*/;
    
    /// True if this comment AST node contains only whitespace.
    protected/*private*/ /*mutable *//*JBIT unsigned int*/ boolean IsWhitespace /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", IsWhitespaceValid=" + IsWhitespaceValid // NOI18N
                + ", IsWhitespace=" + IsWhitespace; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 136,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum6",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum6")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumParagraphCommentBits = NumCommentBits + 2;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::BlockCommandCommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 138,
   FQN="clang::comments::Comment::BlockCommandCommentBitfields", NM="_ZN5clang8comments7Comment28BlockCommandCommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment28BlockCommandCommentBitfieldsE")
  //</editor-fold>
  protected static class BlockCommandCommentBitfields {
    /*friend  class BlockCommandComment*/
    
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumCommentBits*/;
    
    protected/*private*/ /*uint*/int CommandID /*: CommandInfo.NumCommandIDBits*/;
    
    /// Describes the syntax that was used in a documentation command.
    /// Contains values from CommandMarkerKind enum.
    protected/*private*/ /*JBIT unsigned int*/ boolean CommandMarker /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", CommandID=" + CommandID // NOI18N
                + ", CommandMarker=" + CommandMarker; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 149,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum7",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum7")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumBlockCommandCommentBits = NumCommentBits
       + CommandInfo.NumCommandIDBits + 1;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::ParamCommandCommentBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 152,
   FQN="clang::comments::Comment::ParamCommandCommentBitfields", NM="_ZN5clang8comments7Comment28ParamCommandCommentBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment28ParamCommandCommentBitfieldsE")
  //</editor-fold>
  protected static class ParamCommandCommentBitfields {
    /*friend  class ParamCommandComment*/
    
    private /*uint*/int Unnamed_field /*: NumBlockCommandCommentBits*/;
    
    /// Parameter passing direction, see ParamCommandComment::PassDirection.
    protected/*private*/ /*JBYTE unsigned int*/ byte Direction /*: 2*/;
  
    /// True if direction was specified explicitly in the comment.
    protected/*private*/ /*JBIT unsigned int*/ boolean IsDirectionExplicit /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + Unnamed_field // NOI18N
                + ", Direction=" + $uchar2uint(Direction) // NOI18N
                + ", IsDirectionExplicit=" + IsDirectionExplicit; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 163,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_enum8",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_enum8")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumParamCommandCommentBits = NumBlockCommandCommentBits + 3;
  /*}*/;
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 165,
   FQN="clang::comments::Comment::(anonymous)", NM="_ZN5clang8comments7CommentE_Unnamed_union10",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentE_Unnamed_union10")
  //</editor-fold>
  protected static class/*union*/ Unnamed_union10 {
    public final CommentBitfields CommentBits = new CommentBitfields();
    public final InlineContentCommentBitfields InlineContentCommentBits = new InlineContentCommentBitfields();
    public final TextCommentBitfields TextCommentBits = new TextCommentBitfields();
    public final InlineCommandCommentBitfields InlineCommandCommentBits = new InlineCommandCommentBitfields();
    public final HTMLTagCommentBitfields HTMLTagCommentBits = new HTMLTagCommentBitfields();
    public final HTMLStartTagCommentBitfields HTMLStartTagCommentBits = new HTMLStartTagCommentBitfields();
    public final ParagraphCommentBitfields ParagraphCommentBits = new ParagraphCommentBitfields();
    public final BlockCommandCommentBitfields BlockCommandCommentBits = new BlockCommandCommentBitfields();
    public final ParamCommandCommentBitfields ParamCommandCommentBits = new ParamCommandCommentBitfields();
    
    @Override public String toString() {
      return "" + "CommentBits=" + CommentBits // NOI18N
                + ", InlineContentCommentBits=" + InlineContentCommentBits // NOI18N
                + ", TextCommentBits=" + TextCommentBits // NOI18N
                + ", InlineCommandCommentBits=" + InlineCommandCommentBits // NOI18N
                + ", HTMLTagCommentBits=" + HTMLTagCommentBits // NOI18N
                + ", HTMLStartTagCommentBits=" + HTMLStartTagCommentBits // NOI18N
                + ", ParagraphCommentBits=" + ParagraphCommentBits // NOI18N
                + ", BlockCommandCommentBits=" + BlockCommandCommentBits // NOI18N
                + ", ParamCommandCommentBits=" + ParamCommandCommentBits; // NOI18N
    }
  };
  protected final Unnamed_union10 Unnamed_field2 = new Unnamed_union10();
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::setSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 177,
   FQN="clang::comments::Comment::setSourceRange", NM="_ZN5clang8comments7Comment14setSourceRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment14setSourceRangeENS_11SourceRangeE")
  //</editor-fold>
  protected void setSourceRange(SourceRange SR) {
    Range.$assign(SR);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 181,
   FQN="clang::comments::Comment::setLocation", NM="_ZN5clang8comments7Comment11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment11setLocationENS_14SourceLocationE")
  //</editor-fold>
  protected void setLocation(SourceLocation L) {
    Loc.$assign(L);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::CommentKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 186,
   FQN="clang::comments::Comment::CommentKind", NM="_ZN5clang8comments7Comment11CommentKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7Comment11CommentKindE")
  //</editor-fold>
  public enum CommentKind implements Native.ComparableLower {
    NoCommentKind(0),
    BlockCommandCommentKind(NoCommentKind.getValue() + 1),
    ParamCommandCommentKind(BlockCommandCommentKind.getValue() + 1),
    TParamCommandCommentKind(ParamCommandCommentKind.getValue() + 1),
    VerbatimBlockCommentKind(TParamCommandCommentKind.getValue() + 1),
    VerbatimLineCommentKind(VerbatimBlockCommentKind.getValue() + 1),
    FirstBlockCommandCommentConstant(CommentKind.BlockCommandCommentKind.getValue()),
    LastBlockCommandCommentConstant(CommentKind.VerbatimLineCommentKind.getValue()),
    ParagraphCommentKind(LastBlockCommandCommentConstant.getValue() + 1),
    FirstBlockContentCommentConstant(CommentKind.BlockCommandCommentKind.getValue()),
    LastBlockContentCommentConstant(CommentKind.ParagraphCommentKind.getValue()),
    FullCommentKind(LastBlockContentCommentConstant.getValue() + 1),
    HTMLEndTagCommentKind(FullCommentKind.getValue() + 1),
    HTMLStartTagCommentKind(HTMLEndTagCommentKind.getValue() + 1),
    FirstHTMLTagCommentConstant(CommentKind.HTMLEndTagCommentKind.getValue()),
    LastHTMLTagCommentConstant(CommentKind.HTMLStartTagCommentKind.getValue()),
    InlineCommandCommentKind(LastHTMLTagCommentConstant.getValue() + 1),
    TextCommentKind(InlineCommandCommentKind.getValue() + 1),
    FirstInlineContentCommentConstant(CommentKind.HTMLEndTagCommentKind.getValue()),
    LastInlineContentCommentConstant(CommentKind.TextCommentKind.getValue()),
    VerbatimBlockLineCommentKind(LastInlineContentCommentConstant.getValue() + 1),
    FirstCommentConstant(CommentKind.BlockCommandCommentKind.getValue()),
    LastCommentConstant(CommentKind.VerbatimBlockLineCommentKind.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CommentKind valueOf(int val) {
      CommentKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CommentKind[] VALUES;
      private static final CommentKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CommentKind kind : CommentKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CommentKind[min < 0 ? (1-min) : 0];
        VALUES = new CommentKind[max >= 0 ? (1+max) : 0];
        for (CommentKind kind : CommentKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private CommentKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CommentKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CommentKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::Comment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 197,
   FQN="clang::comments::Comment::Comment", NM="_ZN5clang8comments7CommentC1ENS1_11CommentKindENS_14SourceLocationES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang8comments7CommentC1ENS1_11CommentKindENS_14SourceLocationES3_")
  //</editor-fold>
  public Comment(CommentKind K, 
      SourceLocation LocBegin, 
      SourceLocation LocEnd) {
    // : Loc(LocBegin), Range(SourceRange(LocBegin, LocEnd)) 
    //START JInit
    this.Loc = new SourceLocation(LocBegin);
    this.Range = new SourceRange(/*NO_COPY*/LocBegin, /*NO_COPY*/LocEnd);
    //END JInit
    Unnamed_field2.CommentBits.Kind = $uint2uint_8bits(K.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::getCommentKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 204,
   FQN="clang::comments::Comment::getCommentKind", NM="_ZNK5clang8comments7Comment14getCommentKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment14getCommentKindEv")
  //</editor-fold>
  public CommentKind getCommentKind() /*const*/ {
    return /*static_cast*/CommentKind.valueOf($8bits_uint2uint(Unnamed_field2.CommentBits.Kind));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::getCommentKindName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 22,
   FQN="clang::comments::Comment::getCommentKindName", NM="_ZNK5clang8comments7Comment18getCommentKindNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments7Comment18getCommentKindNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getCommentKindName() /*const*/ {
    switch (getCommentKind()) {
     case NoCommentKind:
      return $("NoCommentKind");
     case BlockCommandCommentKind:
      return $("BlockCommandComment");
     case ParamCommandCommentKind:
      return $("ParamCommandComment");
     case TParamCommandCommentKind:
      return $("TParamCommandComment");
     case VerbatimBlockCommentKind:
      return $("VerbatimBlockComment");
     case VerbatimLineCommentKind:
      return $("VerbatimLineComment");
     case ParagraphCommentKind:
      return $("ParagraphComment");
     case FullCommentKind:
      return $("FullComment");
     case HTMLEndTagCommentKind:
      return $("HTMLEndTagComment");
     case HTMLStartTagCommentKind:
      return $("HTMLStartTagComment");
     case InlineCommandCommentKind:
      return $("InlineCommandComment");
     case TextCommentKind:
      return $("TextComment");
     case VerbatimBlockLineCommentKind:
      return $("VerbatimBlockLineComment");
    }
    throw new llvm_unreachable("Unknown comment kind!");
  }


  
  
  //===----------------------------------------------------------------------===//
  // Comment method implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2525,
   FQN="clang::comments::Comment::dump", NM="_ZNK5clang8comments7Comment4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs(), (/*const*/ CommandTraits /*P*/ )null, (/*const*/ SourceManager /*P*/ )null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::dumpColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2541,
   FQN="clang::comments::Comment::dumpColor", NM="_ZNK5clang8comments7Comment9dumpColorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment9dumpColorEv")
  //</editor-fold>
  public void dumpColor() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper D = null;
    try {
      /*const*/ FullComment /*P*/ FC = dyn_cast_FullComment(this);
      D/*J*/= new ASTDumper(llvm.errs(), (/*const*/ CommandTraits /*P*/ )null, (/*const*/ SourceManager /*P*/ )null, /*ShowColors*/ true);
      D.dumpFullComment(FC);
    } finally {
      if (D != null) { D.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2529,
   FQN="clang::comments::Comment::dump", NM="_ZNK5clang8comments7Comment4dumpERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment4dumpERKNS_10ASTContextE")
  //</editor-fold>
  public void dump(final /*const*/ ASTContext /*&*/ Context) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs(), $AddrOf(Context.getCommentCommandTraits()), 
        $AddrOf(Context.getSourceManager$Const()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2534,
   FQN="clang::comments::Comment::dump", NM="_ZNK5clang8comments7Comment4dumpERN4llvm11raw_ostreamEPKNS0_13CommandTraitsEPKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment4dumpERN4llvm11raw_ostreamEPKNS0_13CommandTraitsEPKNS_13SourceManagerE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS, /*const*/ CommandTraits /*P*/ Traits, 
      /*const*/ SourceManager /*P*/ SM) /*const*/ {
    ASTDumper D = null;
    try {
      /*const*/ FullComment /*P*/ FC = dyn_cast_FullComment(this);
      D/*J*/= new ASTDumper(OS, Traits, SM);
      D.dumpFullComment(FC);
    } finally {
      if (D != null) { D.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 216,
   FQN="clang::comments::Comment::getSourceRange", NM="_ZNK5clang8comments7Comment14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 218,
   FQN="clang::comments::Comment::getLocStart", NM="_ZNK5clang8comments7Comment11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 222,
   FQN="clang::comments::Comment::getLocEnd", NM="_ZNK5clang8comments7Comment9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 226,
   FQN="clang::comments::Comment::getLocation", NM="_ZNK5clang8comments7Comment11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  
  /*typedef Comment *const *child_iterator*/
//  public final class child_iterator extends type$ptr<Comment/*P*/> { };
  // end unnamed namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 69,
   FQN="clang::comments::Comment::child_begin", NM="_ZNK5clang8comments7Comment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments7Comment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    switch (getCommentKind()) {
     case NoCommentKind:
      throw new llvm_unreachable("comment without a kind");
     case BlockCommandCommentKind:
      return ((/*static_cast*//*const*/ BlockCommandComment /*P*/ )(this)).child_begin();
     case ParamCommandCommentKind:
      return ((/*static_cast*//*const*/ ParamCommandComment /*P*/ )(this)).child_begin();
     case TParamCommandCommentKind:
      return ((/*static_cast*//*const*/ TParamCommandComment /*P*/ )(this)).child_begin();
     case VerbatimBlockCommentKind:
      return ((/*static_cast*//*const*/ VerbatimBlockComment /*P*/ )(this)).child_begin();
     case VerbatimLineCommentKind:
      return ((/*static_cast*//*const*/ VerbatimLineComment /*P*/ )(this)).child_begin();
     case ParagraphCommentKind:
      return ((/*static_cast*//*const*/ ParagraphComment /*P*/ )(this)).child_begin();
     case FullCommentKind:
      return ((/*static_cast*//*const*/ FullComment /*P*/ )(this)).child_begin();
     case HTMLEndTagCommentKind:
      return ((/*static_cast*//*const*/ HTMLEndTagComment /*P*/ )(this)).child_begin();
     case HTMLStartTagCommentKind:
      return ((/*static_cast*//*const*/ HTMLStartTagComment /*P*/ )(this)).child_begin();
     case InlineCommandCommentKind:
      return ((/*static_cast*//*const*/ InlineCommandComment /*P*/ )(this)).child_begin();
     case TextCommentKind:
      return ((/*static_cast*//*const*/ TextComment /*P*/ )(this)).child_begin();
     case VerbatimBlockLineCommentKind:
      return ((/*static_cast*//*const*/ VerbatimBlockLineComment /*P*/ )(this)).child_begin();
    }
    throw new llvm_unreachable("Unknown comment kind!");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 83,
   FQN="clang::comments::Comment::child_end", NM="_ZNK5clang8comments7Comment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments7Comment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    switch (getCommentKind()) {
     case NoCommentKind:
      throw new llvm_unreachable("comment without a kind");
     case BlockCommandCommentKind:
      return ((/*static_cast*//*const*/ BlockCommandComment /*P*/ )(this)).child_end();
     case ParamCommandCommentKind:
      return ((/*static_cast*//*const*/ ParamCommandComment /*P*/ )(this)).child_end();
     case TParamCommandCommentKind:
      return ((/*static_cast*//*const*/ TParamCommandComment /*P*/ )(this)).child_end();
     case VerbatimBlockCommentKind:
      return ((/*static_cast*//*const*/ VerbatimBlockComment /*P*/ )(this)).child_end();
     case VerbatimLineCommentKind:
      return ((/*static_cast*//*const*/ VerbatimLineComment /*P*/ )(this)).child_end();
     case ParagraphCommentKind:
      return ((/*static_cast*//*const*/ ParagraphComment /*P*/ )(this)).child_end();
     case FullCommentKind:
      return ((/*static_cast*//*const*/ FullComment /*P*/ )(this)).child_end();
     case HTMLEndTagCommentKind:
      return ((/*static_cast*//*const*/ HTMLEndTagComment /*P*/ )(this)).child_end();
     case HTMLStartTagCommentKind:
      return ((/*static_cast*//*const*/ HTMLStartTagComment /*P*/ )(this)).child_end();
     case InlineCommandCommentKind:
      return ((/*static_cast*//*const*/ InlineCommandComment /*P*/ )(this)).child_end();
     case TextCommentKind:
      return ((/*static_cast*//*const*/ TextComment /*P*/ )(this)).child_end();
     case VerbatimBlockLineCommentKind:
      return ((/*static_cast*//*const*/ VerbatimBlockLineComment /*P*/ )(this)).child_end();
    }
    throw new llvm_unreachable("Unknown comment kind!");
  }


  
  // TODO: const child iterator
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Comment::child_count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 235,
   FQN="clang::comments::Comment::child_count", NM="_ZNK5clang8comments7Comment11child_countEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang8comments7Comment11child_countEv")
  //</editor-fold>
  public /*uint*/int child_count() /*const*/ {
    return child_end().$sub(child_begin());
  }

  
  @Override public String toString() {
    return "" + "Loc=" + Loc // NOI18N
              + ", Range=" + Range // NOI18N
              + ", Unnamed_field2=" + Unnamed_field2; // NOI18N
  }
}
