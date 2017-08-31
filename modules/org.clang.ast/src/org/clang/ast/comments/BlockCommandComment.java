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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// A command that has zero or more word-like arguments (number of word-like
/// arguments depends on command name) and a paragraph as an argument
/// (e. g., \\brief).
//<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 602,
 FQN="clang::comments::BlockCommandComment", NM="_ZN5clang8comments19BlockCommandCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandCommentE")
//</editor-fold>
public class BlockCommandComment extends /*public*/ BlockContentComment {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::Argument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 604,
   FQN="clang::comments::BlockCommandComment::Argument", NM="_ZN5clang8comments19BlockCommandComment8ArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandComment8ArgumentE")
  //</editor-fold>
  public static class/*struct*/ Argument {
    public SourceRange Range;
    public StringRef Text;
    
    //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::Argument::Argument">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 608,
     FQN="clang::comments::BlockCommandComment::Argument::Argument", NM="_ZN5clang8comments19BlockCommandComment8ArgumentC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandComment8ArgumentC1Ev")
    //</editor-fold>
    public Argument() {
      // : Range(), Text() 
      //START JInit
      this.Range = new SourceRange();
      this.Text = new StringRef();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::Argument::Argument">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 609,
     FQN="clang::comments::BlockCommandComment::Argument::Argument", NM="_ZN5clang8comments19BlockCommandComment8ArgumentC1ENS_11SourceRangeEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandComment8ArgumentC1ENS_11SourceRangeEN4llvm9StringRefE")
    //</editor-fold>
    public Argument(SourceRange Range, StringRef Text) {
      // : Range(Range), Text(Text) 
      //START JInit
      this.Range = new SourceRange(Range);
      this.Text = new StringRef(Text);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::Argument::~Argument">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 604,
     FQN="clang::comments::BlockCommandComment::Argument::~Argument", NM="_ZN5clang8comments19BlockCommandComment8ArgumentD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments19BlockCommandComment8ArgumentD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::Argument::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 604,
     FQN="clang::comments::BlockCommandComment::Argument::operator=", NM="_ZN5clang8comments19BlockCommandComment8ArgumentaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentParser.cpp -nm=_ZN5clang8comments19BlockCommandComment8ArgumentaSEOS2_")
    //</editor-fold>
    public /*inline*/ Argument /*&*/ $assignMove(final Argument /*&&*/$Prm0) {
      this.Range.$assignMove($Prm0.Range);
      this.Text.$assignMove($Prm0.Text);
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Range=" + Range // NOI18N
                + ", Text=" + Text; // NOI18N
    }
  };
/*protected:*/
  /// Word-like arguments.
  protected ArrayRef<Argument> Args;
  
  /// Paragraph argument.
  protected ParagraphComment /*P*/ Paragraph;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::BlockCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 619,
   FQN="clang::comments::BlockCommandComment::BlockCommandComment", NM="_ZN5clang8comments19BlockCommandCommentC1ENS0_7Comment11CommentKindENS_14SourceLocationES4_jNS0_17CommandMarkerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandCommentC1ENS0_7Comment11CommentKindENS_14SourceLocationES4_jNS0_17CommandMarkerKindE")
  //</editor-fold>
  protected BlockCommandComment(CommentKind K, 
      SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      /*uint*/int CommandID, 
      CommandMarkerKind CommandMarker) {
    // : BlockContentComment(K, LocBegin, LocEnd), Args(), Paragraph(null) 
    //START JInit
    super(K, new SourceLocation(LocBegin), new SourceLocation(LocEnd));
    this.Args = new ArrayRef<Argument>(false);
    this.Paragraph = null;
    //END JInit
    setLocation(getCommandNameBeginLoc());
    Unnamed_field2.BlockCommandCommentBits.CommandID = CommandID;
    Unnamed_field2.BlockCommandCommentBits.CommandMarker = $uint2uint_1bit(CommandMarker.getValue());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::BlockCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 632,
   FQN="clang::comments::BlockCommandComment::BlockCommandComment", NM="_ZN5clang8comments19BlockCommandCommentC1ENS_14SourceLocationES2_jNS0_17CommandMarkerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandCommentC1ENS_14SourceLocationES2_jNS0_17CommandMarkerKindE")
  //</editor-fold>
  public BlockCommandComment(SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      /*uint*/int CommandID, 
      CommandMarkerKind CommandMarker) {
    // : BlockContentComment(BlockCommandCommentKind, LocBegin, LocEnd), Args(), Paragraph(null) 
    //START JInit
    super(CommentKind.BlockCommandCommentKind, new SourceLocation(LocBegin), new SourceLocation(LocEnd));
    this.Args = new ArrayRef<Argument>(false);
    this.Paragraph = null;
    //END JInit
    setLocation(getCommandNameBeginLoc());
    Unnamed_field2.BlockCommandCommentBits.CommandID = CommandID;
    Unnamed_field2.BlockCommandCommentBits.CommandMarker = $uint2uint_1bit(CommandMarker.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 643,
   FQN="clang::comments::BlockCommandComment::classof", NM="_ZN5clang8comments19BlockCommandComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind().getValue() >= CommentKind.FirstBlockCommandCommentConstant.getValue()
       && C.getCommentKind().getValue() <= CommentKind.LastBlockCommandCommentConstant.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::child_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 648,
   FQN="clang::comments::BlockCommandComment::child_begin", NM="_ZNK5clang8comments19BlockCommandComment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    return create_type$ptr(Paragraph);//(type$ptr<Comment/*P*/> )reinterpret_cast(type$ptr.class, /*AddrOf*/Paragraph));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::child_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 652,
   FQN="clang::comments::BlockCommandComment::child_end", NM="_ZNK5clang8comments19BlockCommandComment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    return create_type$ptr((Comment)Paragraph).$add(1);//((type$ptr<Comment/*P*/> )reinterpret_cast(type$ptr.class, /*AddrOf*/Paragraph.$add(1)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getCommandID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 656,
   FQN="clang::comments::BlockCommandComment::getCommandID", NM="_ZNK5clang8comments19BlockCommandComment12getCommandIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment12getCommandIDEv")
  //</editor-fold>
  public /*uint*/int getCommandID() /*const*/ {
    return Unnamed_field2.BlockCommandCommentBits.CommandID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getCommandName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 660,
   FQN="clang::comments::BlockCommandComment::getCommandName", NM="_ZNK5clang8comments19BlockCommandComment14getCommandNameERKNS0_13CommandTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment14getCommandNameERKNS0_13CommandTraitsE")
  //</editor-fold>
  public StringRef getCommandName(final /*const*/ CommandTraits /*&*/ Traits) /*const*/ {
    return new StringRef(Traits.getCommandInfo(getCommandID()).Name);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getCommandNameBeginLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 664,
   FQN="clang::comments::BlockCommandComment::getCommandNameBeginLoc", NM="_ZNK5clang8comments19BlockCommandComment22getCommandNameBeginLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment22getCommandNameBeginLocEv")
  //</editor-fold>
  public SourceLocation getCommandNameBeginLoc() /*const*/ {
    return getLocStart().getLocWithOffset(1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getCommandNameRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 668,
   FQN="clang::comments::BlockCommandComment::getCommandNameRange", NM="_ZNK5clang8comments19BlockCommandComment19getCommandNameRangeERKNS0_13CommandTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment19getCommandNameRangeERKNS0_13CommandTraitsE")
  //</editor-fold>
  public SourceRange getCommandNameRange(final /*const*/ CommandTraits /*&*/ Traits) /*const*/ {
    StringRef Name = getCommandName(Traits);
    return new SourceRange(getCommandNameBeginLoc(), 
        getLocStart().getLocWithOffset(1 + Name.size()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 674,
   FQN="clang::comments::BlockCommandComment::getNumArgs", NM="_ZNK5clang8comments19BlockCommandComment10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return Args.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getArgText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 678,
   FQN="clang::comments::BlockCommandComment::getArgText", NM="_ZNK5clang8comments19BlockCommandComment10getArgTextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment10getArgTextEj")
  //</editor-fold>
  public StringRef getArgText(/*uint*/int Idx) /*const*/ {
    return new StringRef(Args.$at(Idx).Text);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getArgRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 682,
   FQN="clang::comments::BlockCommandComment::getArgRange", NM="_ZNK5clang8comments19BlockCommandComment11getArgRangeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment11getArgRangeEj")
  //</editor-fold>
  public SourceRange getArgRange(/*uint*/int Idx) /*const*/ {
    return new SourceRange(Args.$at(Idx).Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::setArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 686,
   FQN="clang::comments::BlockCommandComment::setArgs", NM="_ZN5clang8comments19BlockCommandComment7setArgsEN4llvm8ArrayRefINS1_8ArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandComment7setArgsEN4llvm8ArrayRefINS1_8ArgumentEEE")
  //</editor-fold>
  public void setArgs(ArrayRef<Argument> A) {
    Args.$assign(A);
    if ($greater_uint(Args.size(), 0)) {
      SourceLocation NewLocEnd = Args.back().Range.getEnd();
      if (NewLocEnd.isValid()) {
        setSourceRange(new SourceRange(getLocStart(), /*NO_COPY*/NewLocEnd));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getParagraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 695,
   FQN="clang::comments::BlockCommandComment::getParagraph", NM="_ZNK5clang8comments19BlockCommandComment12getParagraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment12getParagraphEv")
  //</editor-fold>
  public ParagraphComment /*P*/ getParagraph() /*const*//* __attribute__((pure))*/ {
    return Paragraph;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::hasNonWhitespaceParagraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 699,
   FQN="clang::comments::BlockCommandComment::hasNonWhitespaceParagraph", NM="_ZNK5clang8comments19BlockCommandComment25hasNonWhitespaceParagraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment25hasNonWhitespaceParagraphEv")
  //</editor-fold>
  public boolean hasNonWhitespaceParagraph() /*const*/ {
    return (Paragraph != null) && !Paragraph.isWhitespace();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::setParagraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 703,
   FQN="clang::comments::BlockCommandComment::setParagraph", NM="_ZN5clang8comments19BlockCommandComment12setParagraphEPNS0_16ParagraphCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19BlockCommandComment12setParagraphEPNS0_16ParagraphCommentE")
  //</editor-fold>
  public void setParagraph(ParagraphComment /*P*/ PC) {
    Paragraph = PC;
    SourceLocation NewLocEnd = PC.getLocEnd();
    if (NewLocEnd.isValid()) {
      setSourceRange(new SourceRange(getLocStart(), /*NO_COPY*/NewLocEnd));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::BlockCommandComment::getCommandMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 710,
   FQN="clang::comments::BlockCommandComment::getCommandMarker", NM="_ZNK5clang8comments19BlockCommandComment16getCommandMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19BlockCommandComment16getCommandMarkerEv")
  //</editor-fold>
  public CommandMarkerKind getCommandMarker() /*const*//* __attribute__((pure))*/ {
    return /*static_cast*/CommandMarkerKind.valueOf($bool2uint(Unnamed_field2.BlockCommandCommentBits.CommandMarker));
  }

  
  @Override public String toString() {
    return "" + "Args=" + Args // NOI18N
              + ", Paragraph=" + Paragraph // NOI18N
              + super.toString(); // NOI18N
  }
}
