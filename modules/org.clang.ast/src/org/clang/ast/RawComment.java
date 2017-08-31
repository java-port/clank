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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.ast.comments.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.RawCommentListStatics.*;

// end namespace comments
//<editor-fold defaultstate="collapsed" desc="clang::RawComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 28,
 FQN="clang::RawComment", NM="_ZN5clang10RawCommentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang10RawCommentE")
//</editor-fold>
public class RawComment {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::CommentKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 30,
   FQN="clang::RawComment::CommentKind", NM="_ZN5clang10RawComment11CommentKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang10RawComment11CommentKindE")
  //</editor-fold>
  public enum CommentKind implements Native.ComparableLower {
    RCK_Invalid(0), ///< Invalid comment
    RCK_OrdinaryBCPL(RCK_Invalid.getValue() + 1), ///< Any normal BCPL comments
    RCK_OrdinaryC(RCK_OrdinaryBCPL.getValue() + 1), ///< Any normal C comment
    RCK_BCPLSlash(RCK_OrdinaryC.getValue() + 1), ///< \code /// stuff \endcode
    RCK_BCPLExcl(RCK_BCPLSlash.getValue() + 1), ///< \code //! stuff \endcode
    RCK_JavaDoc(RCK_BCPLExcl.getValue() + 1), ///< \code /** stuff */ \endcode
    RCK_Qt(RCK_JavaDoc.getValue() + 1), ///< \code /*! stuff */ \endcode, also used by HeaderDoc
    RCK_Merged(RCK_Qt.getValue() + 1); ///< Two or more documentation comments merged together

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
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
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
  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::RawComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 41,
   FQN="clang::RawComment::RawComment", NM="_ZN5clang10RawCommentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang10RawCommentC1Ev")
  //</editor-fold>
  public RawComment() {
    // : Range(), RawText(), Kind(RCK_Invalid), IsAlmostTrailingComment(false) 
    //START JInit
    this.Range = new SourceRange();
    this.RawText = new StringRef();
    this.Kind = $uint2uint_3bits(CommentKind.RCK_Invalid.getValue());
    this.IsAlmostTrailingComment = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::RawComment">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 109,
   FQN="clang::RawComment::RawComment", NM="_ZN5clang10RawCommentC1ERKNS_13SourceManagerENS_11SourceRangeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang10RawCommentC1ERKNS_13SourceManagerENS_11SourceRangeEbb")
  //</editor-fold>
  public RawComment(final /*const*/ SourceManager /*&*/ SourceMgr, SourceRange SR, 
      boolean Merged, boolean ParseAllComments) {
    // : Range(SR), RawText(), RawTextValid(false), BriefTextValid(false), IsAttached(false), IsTrailingComment(false), IsAlmostTrailingComment(false), ParseAllComments(ParseAllComments) 
    //START JInit
    this.Range = new SourceRange(SR);
    this.RawText = new StringRef();
    this.RawTextValid = false;
    this.BriefTextValid = false;
    this.IsAttached = false;
    this.IsTrailingComment = false;
    this.IsAlmostTrailingComment = false;
    this.ParseAllComments = ParseAllComments;
    //END JInit
    // Extract raw comment text, if possible.
    if ($eq_SourceLocation$C(SR.getBegin(), SR.getEnd()) || getRawText(SourceMgr).empty()) {
      Kind = $uint2uint_3bits(CommentKind.RCK_Invalid.getValue());
      return;
    }
    
    // Guess comment kind.
    std.pairTypeBool<CommentKind> K = getCommentKind(new StringRef(RawText), ParseAllComments);
    
    // Guess whether an ordinary comment is trailing.
    if (ParseAllComments && isOrdinaryKind(K.first)) {
      FileID BeginFileID/*J*/= new FileID();
      /*uint*/int BeginOffset = 0;
      // JAVA: tie/untie
      // std.tie_type_uint(BeginFileID, BeginOffset).$assign(
      //     SourceMgr.getDecomposedLoc(Range.getBegin())
      // );
      final pairTypeUInt<FileID> $pair = SourceMgr.getDecomposedLoc(Range.getBegin());
      BeginFileID.$assign($pair.first);
      BeginOffset = $pair.second;
      // JAVA: end of tie/untie

      if (BeginOffset != 0) {
        bool$ptr Invalid = /*JAVA:PERF*/null;//create_bool$ptr(false);
        StringRef $Buffer = SourceMgr.getBufferData(/*NO_COPY*/BeginFileID, /*AddrOf*/Invalid);
        /*const*/char$ptr/*char P*/ Buffer = $noClone($Buffer.data()); // JAVA: onlyWhitespaceOnLineBefore doesn't change pointer
        IsTrailingComment |= (($Buffer /*JAVA:PERF*/ != SourceManager.INVALID_BUFFER_DATA) && !onlyWhitespaceOnLineBefore(Buffer, BeginOffset));
      }
    }
    if (!Merged) {
      Kind = $uint2uint_3bits(K.first.getValue());
      IsTrailingComment |= K.second;
      
      IsAlmostTrailingComment = RawText.startswith(/*STRINGREF_STR*/"//<")
         || RawText.startswith(/*STRINGREF_STR*/"/*<");
    } else {
      Kind = $uint2uint_3bits(CommentKind.RCK_Merged.getValue());
      IsTrailingComment
         = IsTrailingComment || mergedCommentIsTrailingComment(new StringRef(RawText));
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 46,
   FQN="clang::RawComment::getKind", NM="_ZNK5clang10RawComment7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment7getKindEv")
  //</editor-fold>
  public CommentKind getKind() /*const*//* __attribute__((pure))*/ {
    return CommentKind.valueOf(Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 50,
   FQN="clang::RawComment::isInvalid", NM="_ZNK5clang10RawComment9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*//* __attribute__((pure))*/ {
    return Kind == $int2uint_3bits(CommentKind.RCK_Invalid.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::isMerged">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 54,
   FQN="clang::RawComment::isMerged", NM="_ZNK5clang10RawComment8isMergedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment8isMergedEv")
  //</editor-fold>
  public boolean isMerged() /*const*//* __attribute__((pure))*/ {
    return Kind == $int2uint_3bits(CommentKind.RCK_Merged.getValue());
  }

  
  /// Is this comment attached to any declaration?
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::isAttached">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 59,
   FQN="clang::RawComment::isAttached", NM="_ZNK5clang10RawComment10isAttachedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment10isAttachedEv")
  //</editor-fold>
  public boolean isAttached() /*const*//* __attribute__((pure))*/ {
    return IsAttached;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::setAttached">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 63,
   FQN="clang::RawComment::setAttached", NM="_ZN5clang10RawComment11setAttachedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang10RawComment11setAttachedEv")
  //</editor-fold>
  public void setAttached() {
    IsAttached = true;
  }

  
  /// Returns true if it is a comment that should be put after a member:
  /// \code ///< stuff \endcode
  /// \code //!< stuff \endcode
  /// \code /**< stuff */ \endcode
  /// \code /*!< stuff */ \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::isTrailingComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 72,
   FQN="clang::RawComment::isTrailingComment", NM="_ZNK5clang10RawComment17isTrailingCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment17isTrailingCommentEv")
  //</editor-fold>
  public boolean isTrailingComment() /*const*//* __attribute__((pure))*/ {
    assert (isDocumentation());
    return IsTrailingComment;
  }

  
  /// Returns true if it is a probable typo:
  /// \code //< stuff \endcode
  /// \code /*< stuff */ \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::isAlmostTrailingComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 80,
   FQN="clang::RawComment::isAlmostTrailingComment", NM="_ZNK5clang10RawComment23isAlmostTrailingCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment23isAlmostTrailingCommentEv")
  //</editor-fold>
  public boolean isAlmostTrailingComment() /*const*//* __attribute__((pure))*/ {
    return IsAlmostTrailingComment;
  }

  
  /// Returns true if this comment is not a documentation comment.
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::isOrdinary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 85,
   FQN="clang::RawComment::isOrdinary", NM="_ZNK5clang10RawComment10isOrdinaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment10isOrdinaryEv")
  //</editor-fold>
  public boolean isOrdinary() /*const*//* __attribute__((pure))*/ {
    return ((Kind == $int2uint_3bits(CommentKind.RCK_OrdinaryBCPL.getValue())) || (Kind == $int2uint_3bits(CommentKind.RCK_OrdinaryC.getValue())))
       && !ParseAllComments;
  }

  
  /// Returns true if this comment any kind of a documentation comment.
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::isDocumentation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 91,
   FQN="clang::RawComment::isDocumentation", NM="_ZNK5clang10RawComment15isDocumentationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment15isDocumentationEv")
  //</editor-fold>
  public boolean isDocumentation() /*const*//* __attribute__((pure))*/ {
    return !isInvalid() && !isOrdinary();
  }

  
  /// Returns whether we are parsing all comments.
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::isParseAllComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 96,
   FQN="clang::RawComment::isParseAllComments", NM="_ZNK5clang10RawComment18isParseAllCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment18isParseAllCommentsEv")
  //</editor-fold>
  public boolean isParseAllComments() /*const*//* __attribute__((pure))*/ {
    return ParseAllComments;
  }

  
  /// Returns raw comment text with comment markers.
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::getRawText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 101,
   FQN="clang::RawComment::getRawText", NM="_ZNK5clang10RawComment10getRawTextERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment10getRawTextERKNS_13SourceManagerE")
  //</editor-fold>
  public StringRef getRawText(final /*const*/ SourceManager /*&*/ SourceMgr) /*const*/ {
    if (RawTextValid) {
      return new StringRef(RawText);
    }
    
    RawText.$assignMove(getRawTextSlow(SourceMgr));
    RawTextValid = true;
    return new StringRef(RawText);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 110,
   FQN="clang::RawComment::getSourceRange", NM="_ZNK5clang10RawComment14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    return new SourceRange(Range);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 111,
   FQN="clang::RawComment::getLocStart", NM="_ZNK5clang10RawComment11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return Range.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 112,
   FQN="clang::RawComment::getLocEnd", NM="_ZNK5clang10RawComment9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return Range.getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::getBriefText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 114,
   FQN="clang::RawComment::getBriefText", NM="_ZNK5clang10RawComment12getBriefTextERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment12getBriefTextERKNS_10ASTContextE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBriefText(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    if (BriefTextValid) {
      return BriefText;
    }
    
    return extractBriefText(Context);
  }

  
  /// Parse the comment, assuming it is attached to decl \c D.
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::parse">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 202,
   FQN="clang::RawComment::parse", NM="_ZNK5clang10RawComment5parseERKNS_10ASTContextEPKNS_12PreprocessorEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment5parseERKNS_10ASTContextEPKNS_12PreprocessorEPKNS_4DeclE")
  //</editor-fold>
  public FullComment /*P*/ parse(final /*const*/ ASTContext /*&*/ Context, 
       /*const*/ Preprocessor /*P*/ PP, 
       /*const*/ Decl /*P*/ D) /*const*/ {
    org.clang.ast.comments.Lexer L = null;
    Sema S = null;
    Parser P = null;
    try {
      // Make sure that RawText is valid.
      getRawText(Context.getSourceManager$Const());
      
      L/*J*/= new org.clang.ast.comments.Lexer(Context.getAllocator(), Context.getDiagnostics(), 
          Context.getCommentCommandTraits(), 
          getSourceRange().getBegin(), 
          RawText.begin(), RawText.end());
      S/*J*/= new Sema(Context.getAllocator(), Context.getSourceManager$Const(), 
          Context.getDiagnostics(), 
          Context.getCommentCommandTraits(), 
          PP);
      S.setDecl(D);
      P/*J*/= new Parser(L, S, Context.getAllocator(), Context.getSourceManager$Const(), 
          Context.getDiagnostics(), 
          Context.getCommentCommandTraits());
      
      return P.parseFullComment();
    } finally {
      if (P != null) { P.$destroy(); }
      if (S != null) { S.$destroy(); }
      if (L != null) { L.$destroy(); }
    }
  }

/*private:*/
  private SourceRange Range;
  
  private /*mutable */StringRef RawText;
  private /*mutable *//*const*/char$ptr/*char P*/ BriefText;
  
  private /*mutable *//*JBIT bool*/ boolean RawTextValid /*: 1*/; ///< True if RawText is valid
  private /*mutable *//*JBIT bool*/ boolean BriefTextValid /*: 1*/; ///< True if BriefText is valid
  
  private /*JBYTE unsigned int*/ byte Kind /*: 3*/;
  
  /// True if comment is attached to a declaration in ASTContext.
  private /*JBIT bool*/ boolean IsAttached /*: 1*/;
  
  private /*JBIT bool*/ boolean IsTrailingComment /*: 1*/;
  private /*JBIT bool*/ boolean IsAlmostTrailingComment /*: 1*/;
  
  /// When true, ordinary comments starting with "//" and "/*" will be
  /// considered as documentation comments.
  private /*JBIT bool*/ boolean ParseAllComments /*: 1*/;
  
  /// \brief Constructor for AST deserialization.
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::RawComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 147,
   FQN="clang::RawComment::RawComment", NM="_ZN5clang10RawCommentC1ENS_11SourceRangeENS0_11CommentKindEbbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang10RawCommentC1ENS_11SourceRangeENS0_11CommentKindEbbb")
  //</editor-fold>
  /*friend*/public RawComment(SourceRange SR, CommentKind K, boolean IsTrailingComment, 
      boolean IsAlmostTrailingComment, 
      boolean ParseAllComments) {
    // : Range(SR), RawText(), RawTextValid(false), BriefTextValid(false), Kind(K), IsAttached(false), IsTrailingComment(IsTrailingComment), IsAlmostTrailingComment(IsAlmostTrailingComment), ParseAllComments(ParseAllComments) 
    //START JInit
    this.Range = new SourceRange(SR);
    this.RawText = new StringRef();
    this.RawTextValid = false;
    this.BriefTextValid = false;
    this.Kind = $uint2uint_3bits(K.getValue());
    this.IsAttached = false;
    this.IsTrailingComment = IsTrailingComment;
    this.IsAlmostTrailingComment = IsAlmostTrailingComment;
    this.ParseAllComments = ParseAllComments;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::getRawTextSlow">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 151,
   FQN="clang::RawComment::getRawTextSlow", NM="_ZNK5clang10RawComment14getRawTextSlowERKNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment14getRawTextSlowERKNS_13SourceManagerE")
  //</editor-fold>
  private StringRef getRawTextSlow(final /*const*/ SourceManager /*&*/ SourceMgr) /*const*/ {
    FileID BeginFileID/*J*/= new FileID();
    FileID EndFileID/*J*/= new FileID();
    /*uint*/int BeginOffset;
    /*uint*/int EndOffset;

    // JAVA: tie/untie    
    // std.tie_type_uint(BeginFileID, BeginOffset).$assign(
    //     SourceMgr.getDecomposedLoc(Range.getBegin())
    // );
    // std.tie_type_uint(EndFileID, EndOffset).$assign(SourceMgr.getDecomposedLoc(Range.getEnd()));
    pairTypeUInt<FileID> $pair = SourceMgr.getDecomposedLoc(Range.getBegin());
    BeginFileID.$assign($pair.first);
    BeginOffset = $pair.second;
    $pair = SourceMgr.getDecomposedLoc(Range.getEnd());
    EndFileID.$assign($pair.first);
    EndOffset = $pair.second;
    // JAVA: end of tie/untie
    
    /*const*//*uint*/int Length = EndOffset - BeginOffset;
    if ($less_uint(Length, 2)) {
      return new StringRef();
    }
    
    // The comment can't begin in one file and end in another.
    assert (BeginFileID.$eq(EndFileID));
    
    bool$ptr Invalid = /*JAVA:PERF*/null; // JAVA: create_bool$ptr(false);
    
    StringRef BufferStart = SourceMgr.getBufferData(/*NO_COPY*/BeginFileID, 
        /*AddrOf*/Invalid);
    //JAVA: if (Invalid.$star()) {
    if (BufferStart /*JAVA:PERF*/== SourceManager.INVALID_BUFFER_DATA) {
      return new StringRef();
    }
    
    return new StringRef(BufferStart.data().$add(BeginOffset), Length);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::extractBriefText">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 177,
   FQN="clang::RawComment::extractBriefText", NM="_ZNK5clang10RawComment16extractBriefTextERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZNK5clang10RawComment16extractBriefTextERKNS_10ASTContextE")
  //</editor-fold>
  private /*const*/char$ptr/*char P*/ extractBriefText(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    BumpPtrAllocatorImpl Allocator = null;
    org.clang.ast.comments.Lexer L = null;
    try {
      // Make sure that RawText is valid.
      getRawText(Context.getSourceManager$Const());
      
      // Since we will be copying the resulting text, all allocations made during
      // parsing are garbage after resulting string is formed.  Thus we can use
      // a separate allocator for all temporary stuff.
      Allocator/*J*/= new BumpPtrAllocatorImpl();
      
      L/*J*/= new org.clang.ast.comments.Lexer(Allocator, Context.getDiagnostics(), 
          Context.getCommentCommandTraits(), 
          Range.getBegin(), 
          RawText.begin(), RawText.end());
      BriefParser P/*J*/= new BriefParser(L, Context.getCommentCommandTraits());
      
      /*const*/std.string Result = P.Parse();
      /*const*//*uint*/int BriefTextLength = Result.size();
      char$ptr/*char P*/ BriefTextPtr = create_char$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (Context)*/ /*FIXME 1: $array_new_uint_ASTContext$C_uint*/new$char(BriefTextLength + 1));
      memcpy(BriefTextPtr, Result.c_str(), BriefTextLength + 1);
      BriefText = $tryClone(BriefTextPtr);
      BriefTextValid = true;
      
      return BriefTextPtr;
    } finally {
      if (L != null) { L.$destroy(); }
      if (Allocator != null) { Allocator.$destroy(); }
    }
  }

  
  /*friend  class ASTReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::RawComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 28,
   FQN="clang::RawComment::RawComment", NM="_ZN5clang10RawCommentC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang10RawCommentC1ERKS0_")
  //</editor-fold>
  public /*inline*/ RawComment(final /*const*/ RawComment /*&*/ $Prm0) {
    // : Range(.Range), RawText(.RawText), BriefText(.BriefText), RawTextValid(.RawTextValid), BriefTextValid(.BriefTextValid), Kind(.Kind), IsAttached(.IsAttached), IsTrailingComment(.IsTrailingComment), IsAlmostTrailingComment(.IsAlmostTrailingComment), ParseAllComments(.ParseAllComments) 
    //START JInit
    this.Range = new SourceRange($Prm0.Range);
    this.RawText = new StringRef($Prm0.RawText);
    this.BriefText = $tryClone($Prm0.BriefText);
    this.RawTextValid = $Prm0.RawTextValid;
    this.BriefTextValid = $Prm0.BriefTextValid;
    this.Kind = $uint2uint_3bits($Prm0.Kind);
    this.IsAttached = $Prm0.IsAttached;
    this.IsTrailingComment = $Prm0.IsTrailingComment;
    this.IsAlmostTrailingComment = $Prm0.IsAlmostTrailingComment;
    this.ParseAllComments = $Prm0.ParseAllComments;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::RawComment::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/RawCommentList.h", line = 28,
   FQN="clang::RawComment::operator=", NM="_ZN5clang10RawCommentaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang10RawCommentaSEOS0_")
  //</editor-fold>
  public /*inline*/ RawComment /*&*/ $assignMove(final RawComment /*&&*/$Prm0) {
    this.Range.$assignMove($Prm0.Range);
    this.RawText.$assignMove($Prm0.RawText);
    this.BriefText = $tryClone($Prm0.BriefText);
    this.RawTextValid = $Prm0.RawTextValid;
    this.BriefTextValid = $Prm0.BriefTextValid;
    this.Kind = $uint2uint_3bits($Prm0.Kind);
    this.IsAttached = $Prm0.IsAttached;
    this.IsTrailingComment = $Prm0.IsTrailingComment;
    this.IsAlmostTrailingComment = $Prm0.IsAlmostTrailingComment;
    this.ParseAllComments = $Prm0.ParseAllComments;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected static RawComment/*P*/ $new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(BumpPtrAllocatorImpl /*&*/ Allocator, New$ConstructorCallback<RawComment/*P*/> New$DeclCtr) { return New$DeclCtr.$call(null); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Range=" + Range // NOI18N
              + ", RawText=" + RawText // NOI18N
              + ", BriefText=" + BriefText // NOI18N
              + ", RawTextValid=" + RawTextValid // NOI18N
              + ", BriefTextValid=" + BriefTextValid // NOI18N
              + ", Kind=" + $uchar2uint(Kind) // NOI18N
              + ", IsAttached=" + IsAttached // NOI18N
              + ", IsTrailingComment=" + IsTrailingComment // NOI18N
              + ", IsAlmostTrailingComment=" + IsAlmostTrailingComment // NOI18N
              + ", ParseAllComments=" + ParseAllComments; // NOI18N
  }
}
