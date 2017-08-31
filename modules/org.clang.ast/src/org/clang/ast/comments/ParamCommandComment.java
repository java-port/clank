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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// Doxygen \\param command.
//<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 717,
 FQN="clang::comments::ParamCommandComment", NM="_ZN5clang8comments19ParamCommandCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandCommentE")
//</editor-fold>
public class ParamCommandComment extends /*public*/ BlockCommandComment {
/*private:*/
  /// Parameter index in the function declaration.
  private /*uint*/int ParamIndex;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 723,
   FQN="clang::comments::ParamCommandComment::(anonymous)", NM="_ZN5clang8comments19ParamCommandCommentE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandCommentE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum/* : unsigned int*/ implements Native.ComparableLower {
    InvalidParamIndex(~0/*U*/),
    VarArgParamIndex(~0/*U*//*InvalidParamIndex*/ - 1/*U*/);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::ParamCommandComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 728,
   FQN="clang::comments::ParamCommandComment::ParamCommandComment", NM="_ZN5clang8comments19ParamCommandCommentC1ENS_14SourceLocationES2_jNS0_17CommandMarkerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandCommentC1ENS_14SourceLocationES2_jNS0_17CommandMarkerKindE")
  //</editor-fold>
  public ParamCommandComment(SourceLocation LocBegin, 
      SourceLocation LocEnd, 
      /*uint*/int CommandID, 
      CommandMarkerKind CommandMarker) {
    // : BlockCommandComment(ParamCommandCommentKind, LocBegin, LocEnd, CommandID, CommandMarker), ParamIndex(InvalidParamIndex) 
    //START JInit
    super(CommentKind.ParamCommandCommentKind, new SourceLocation(LocBegin), new SourceLocation(LocEnd), 
        CommandID, CommandMarker);
    this.ParamIndex = Unnamed_enum.InvalidParamIndex.getValue();
    //END JInit
    Unnamed_field2.ParamCommandCommentBits.Direction = $uint2uint_2bits(PassDirection.In.getValue());
    Unnamed_field2.ParamCommandCommentBits.IsDirectionExplicit = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 739,
   FQN="clang::comments::ParamCommandComment::classof", NM="_ZN5clang8comments19ParamCommandComment7classofEPKNS0_7CommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandComment7classofEPKNS0_7CommentE")
  //</editor-fold>
  public static boolean classof(/*const*/ Comment /*P*/ C) {
    return C.getCommentKind() == CommentKind.ParamCommandCommentKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::PassDirection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 743,
   FQN="clang::comments::ParamCommandComment::PassDirection", NM="_ZN5clang8comments19ParamCommandComment13PassDirectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandComment13PassDirectionE")
  //</editor-fold>
  public enum PassDirection implements Native.ComparableLower {
    In(0),
    Out(In.getValue() + 1),
    InOut(Out.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static PassDirection valueOf(int val) {
      PassDirection out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final PassDirection[] VALUES;
      private static final PassDirection[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (PassDirection kind : PassDirection.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new PassDirection[min < 0 ? (1-min) : 0];
        VALUES = new PassDirection[max >= 0 ? (1+max) : 0];
        for (PassDirection kind : PassDirection.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private PassDirection(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((PassDirection)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((PassDirection)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::getDirectionAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 117,
   FQN="clang::comments::ParamCommandComment::getDirectionAsString", NM="_ZN5clang8comments19ParamCommandComment20getDirectionAsStringENS1_13PassDirectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandComment20getDirectionAsStringENS1_13PassDirectionE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getDirectionAsString(PassDirection D) {
    switch (D) {
     case In:
      return $("[in]");
     case Out:
      return $("[out]");
     case InOut:
      return $("[in,out]");
    }
    throw new llvm_unreachable("unknown PassDirection");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::getDirection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 751,
   FQN="clang::comments::ParamCommandComment::getDirection", NM="_ZNK5clang8comments19ParamCommandComment12getDirectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment12getDirectionEv")
  //</editor-fold>
  public PassDirection getDirection() /*const*//* __attribute__((pure))*/ {
    return /*static_cast*/PassDirection.valueOf(Unnamed_field2.ParamCommandCommentBits.Direction);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::isDirectionExplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 755,
   FQN="clang::comments::ParamCommandComment::isDirectionExplicit", NM="_ZNK5clang8comments19ParamCommandComment19isDirectionExplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment19isDirectionExplicitEv")
  //</editor-fold>
  public boolean isDirectionExplicit() /*const*//* __attribute__((pure))*/ {
    return Unnamed_field2.ParamCommandCommentBits.IsDirectionExplicit;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::setDirection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 759,
   FQN="clang::comments::ParamCommandComment::setDirection", NM="_ZN5clang8comments19ParamCommandComment12setDirectionENS1_13PassDirectionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandComment12setDirectionENS1_13PassDirectionEb")
  //</editor-fold>
  public void setDirection(PassDirection Direction, boolean Explicit) {
    Unnamed_field2.ParamCommandCommentBits.Direction = $uint2uint_2bits(Direction.getValue());
    Unnamed_field2.ParamCommandCommentBits.IsDirectionExplicit = Explicit;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::hasParamName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 764,
   FQN="clang::comments::ParamCommandComment::hasParamName", NM="_ZNK5clang8comments19ParamCommandComment12hasParamNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment12hasParamNameEv")
  //</editor-fold>
  public boolean hasParamName() /*const*/ {
    return $greater_uint(getNumArgs(), 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::getParamName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp", line = 324,
   FQN="clang::comments::ParamCommandComment::getParamName", NM="_ZNK5clang8comments19ParamCommandComment12getParamNameEPKNS0_11FullCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment12getParamNameEPKNS0_11FullCommentE")
  //</editor-fold>
  public StringRef getParamName(/*const*/ FullComment /*P*/ FC) /*const*/ {
    assert (isParamIndexValid());
    if (isVarArgParam()) {
      return new StringRef(/*KEEP_STR*/$ELLIPSIS);
    }
    return FC.getDeclInfo().ParamVars.$at(getParamIndex()).getName();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::getParamNameAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 770,
   FQN="clang::comments::ParamCommandComment::getParamNameAsWritten", NM="_ZNK5clang8comments19ParamCommandComment21getParamNameAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment21getParamNameAsWrittenEv")
  //</editor-fold>
  public StringRef getParamNameAsWritten() /*const*/ {
    return new StringRef(Args.$at(0).Text);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::getParamNameRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 774,
   FQN="clang::comments::ParamCommandComment::getParamNameRange", NM="_ZNK5clang8comments19ParamCommandComment17getParamNameRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment17getParamNameRangeEv")
  //</editor-fold>
  public SourceRange getParamNameRange() /*const*/ {
    return new SourceRange(Args.$at(0).Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::isParamIndexValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 778,
   FQN="clang::comments::ParamCommandComment::isParamIndexValid", NM="_ZNK5clang8comments19ParamCommandComment17isParamIndexValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment17isParamIndexValidEv")
  //</editor-fold>
  public boolean isParamIndexValid() /*const*//* __attribute__((pure))*/ {
    return ParamIndex != Unnamed_enum.InvalidParamIndex.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::isVarArgParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 782,
   FQN="clang::comments::ParamCommandComment::isVarArgParam", NM="_ZNK5clang8comments19ParamCommandComment13isVarArgParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment13isVarArgParamEv")
  //</editor-fold>
  public boolean isVarArgParam() /*const*//* __attribute__((pure))*/ {
    return ParamIndex == Unnamed_enum.VarArgParamIndex.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::setIsVarArgParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 786,
   FQN="clang::comments::ParamCommandComment::setIsVarArgParam", NM="_ZN5clang8comments19ParamCommandComment16setIsVarArgParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandComment16setIsVarArgParamEv")
  //</editor-fold>
  public void setIsVarArgParam() {
    ParamIndex = Unnamed_enum.VarArgParamIndex.getValue();
    assert (isParamIndexValid());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::getParamIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 791,
   FQN="clang::comments::ParamCommandComment::getParamIndex", NM="_ZNK5clang8comments19ParamCommandComment13getParamIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZNK5clang8comments19ParamCommandComment13getParamIndexEv")
  //</editor-fold>
  public /*uint*/int getParamIndex() /*const*//* __attribute__((pure))*/ {
    assert (isParamIndexValid());
    assert (!isVarArgParam());
    return ParamIndex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::ParamCommandComment::setParamIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Comment.h", line = 797,
   FQN="clang::comments::ParamCommandComment::setParamIndex", NM="_ZN5clang8comments19ParamCommandComment13setParamIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Comment.cpp -nm=_ZN5clang8comments19ParamCommandComment13setParamIndexEj")
  //</editor-fold>
  public void setParamIndex(/*uint*/int Index) {
    ParamIndex = Index;
    assert (isParamIndexValid());
    assert (!isVarArgParam());
  }

  
  @Override public String toString() {
    return "" + "ParamIndex=" + ParamIndex // NOI18N
              + super.toString(); // NOI18N
  }
}
