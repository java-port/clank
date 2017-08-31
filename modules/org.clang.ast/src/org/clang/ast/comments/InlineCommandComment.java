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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// A command with word-like arguments that is considered inline content.
//<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 303,
 FQN="clang::comments::InlineCommandComment", NM="_ZN5clang8comments20InlineCommandCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineCommandCommentE")
//</editor-fold>
public class InlineCommandComment extends /*public*/ InlineContentComment {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::Argument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 305,
   FQN="clang::comments::InlineCommandComment::Argument", NM="_ZN5clang8comments20InlineCommandComment8ArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineCommandComment8ArgumentE")
  //</editor-fold>
  public static class/*struct*/ Argument {
    public SourceRange Range;
    public StringRef Text;
    
    //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::Argument::Argument">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 309,
     FQN="clang::comments::InlineCommandComment::Argument::Argument", NM="_ZN5clang8comments20InlineCommandComment8ArgumentC1ENS_11SourceRangeEN4llvm9StringRefE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineCommandComment8ArgumentC1ENS_11SourceRangeEN4llvm9StringRefE")
    //</editor-fold>
    public Argument(SourceRange Range, StringRef Text) {
      // : Range(Range), Text(Text) 
      //START JInit
      this.Range = new SourceRange(Range);
      this.Text = new StringRef(Text);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Range=" + Range // NOI18N
                + ", Text=" + Text; // NOI18N
    }
  };
  
  /// The most appropriate rendering mode for this command, chosen on command
  /// semantics in Doxygen.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::RenderKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 314,
   FQN="clang::comments::InlineCommandComment::RenderKind", NM="_ZN5clang8comments20InlineCommandComment10RenderKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineCommandComment10RenderKindE")
  //</editor-fold>
  public enum RenderKind implements Native.ComparableLower {
    RenderNormal(0),
    RenderBold(RenderNormal.getValue() + 1),
    RenderMonospaced(RenderBold.getValue() + 1),
    RenderEmphasized(RenderMonospaced.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RenderKind valueOf(int val) {
      RenderKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RenderKind[] VALUES;
      private static final RenderKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RenderKind kind : RenderKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RenderKind[min < 0 ? (1-min) : 0];
        VALUES = new RenderKind[max >= 0 ? (1+max) : 0];
        for (RenderKind kind : RenderKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private RenderKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((RenderKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((RenderKind)obj).value);}
    //</editor-fold>
  };
/*protected:*/
  /// Command arguments.
  protected ArrayRef<Argument> Args;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::InlineCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 326,
   FQN="clang::comments::InlineCommandComment::InlineCommandComment", NM="_ZN5clang8comments20InlineCommandCommentC1ENS_14SourceLocationES2_jNS1_10RenderKindEN4llvm8ArrayRefINS1_8ArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineCommandCommentC1ENS_14SourceLocationES2_jNS1_10RenderKindEN4llvm8ArrayRefINS1_8ArgumentEEE")
  //</editor-fold>
  public InlineCommandComment(SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      /*uint*/int CommandID, 
      RenderKind RK, 
      ArrayRef<Argument> Args) {
    // : InlineContentComment(InlineCommandCommentKind, LocBegin, LocEnd), Args(Args) 
    //START JInit
    super(CommentKind.InlineCommandCommentKind, new SourceLocation(LocBegin), new SourceLocation(LocEnd));
    this.Args = new ArrayRef<Argument>(Args);
    //END JInit
    Unnamed_field2.InlineCommandCommentBits.RenderKind = $uint2uint_2bits(RK.getValue());
    Unnamed_field2.InlineCommandCommentBits.CommandID = CommandID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 337,
   FQN="clang::comments::InlineCommandComment::classof", NM="_ZN5clang8comments20InlineCommandComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments20InlineCommandComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.InlineCommandCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 341,
   FQN="clang::comments::InlineCommandComment::child_begin", NM="_ZNK5clang8comments20InlineCommandComment11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment11child_beginEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_begin() /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 343,
   FQN="clang::comments::InlineCommandComment::child_end", NM="_ZNK5clang8comments20InlineCommandComment9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment9child_endEv")
  //</editor-fold>
  public type$ptr<Comment/*P*/> child_end() /*const*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::getCommandID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 345,
   FQN="clang::comments::InlineCommandComment::getCommandID", NM="_ZNK5clang8comments20InlineCommandComment12getCommandIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment12getCommandIDEv")
  //</editor-fold>
  public /*uint*/int getCommandID() /*const*/ {
    return Unnamed_field2.InlineCommandCommentBits.CommandID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::getCommandName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 349,
   FQN="clang::comments::InlineCommandComment::getCommandName", NM="_ZNK5clang8comments20InlineCommandComment14getCommandNameERKNS0_13CommandTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment14getCommandNameERKNS0_13CommandTraitsE")
  //</editor-fold>
  public StringRef getCommandName(final /*const*/ CommandTraits /*&*/ Traits) /*const*/ {
    return new StringRef(Traits.getCommandInfo(getCommandID()).Name);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::getCommandNameRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 353,
   FQN="clang::comments::InlineCommandComment::getCommandNameRange", NM="_ZNK5clang8comments20InlineCommandComment19getCommandNameRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment19getCommandNameRangeEv")
  //</editor-fold>
  public SourceRange getCommandNameRange() /*const*/ {
    return new SourceRange(getLocStart().getLocWithOffset(-1), 
        getLocEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::getRenderKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 358,
   FQN="clang::comments::InlineCommandComment::getRenderKind", NM="_ZNK5clang8comments20InlineCommandComment13getRenderKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment13getRenderKindEv")
  //</editor-fold>
  public RenderKind getRenderKind() /*const*/ {
    return /*static_cast*/RenderKind.valueOf(Unnamed_field2.InlineCommandCommentBits.RenderKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 362,
   FQN="clang::comments::InlineCommandComment::getNumArgs", NM="_ZNK5clang8comments20InlineCommandComment10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return Args.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::getArgText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 366,
   FQN="clang::comments::InlineCommandComment::getArgText", NM="_ZNK5clang8comments20InlineCommandComment10getArgTextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment10getArgTextEj")
  //</editor-fold>
  public StringRef getArgText(/*uint*/int Idx) /*const*/ {
    return new StringRef(Args.$at(Idx).Text);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::InlineCommandComment::getArgRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 370,
   FQN="clang::comments::InlineCommandComment::getArgRange", NM="_ZNK5clang8comments20InlineCommandComment11getArgRangeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments20InlineCommandComment11getArgRangeEj")
  //</editor-fold>
  public SourceRange getArgRange(/*uint*/int Idx) /*const*/ {
    return new SourceRange(Args.$at(Idx).Range);
  }

  
  @Override public String toString() {
    return "" + "Args=" + Args // NOI18N
              + super.toString(); // NOI18N
  }
}
