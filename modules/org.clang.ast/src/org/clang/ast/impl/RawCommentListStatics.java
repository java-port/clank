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
package org.clang.ast.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type RawCommentListStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZL14isOrdinaryKindN5clang10RawComment11CommentKindE;_ZL21onlyWhitespaceBetweenRN5clang13SourceManagerENS_14SourceLocationES2_j;_ZL26onlyWhitespaceOnLineBeforePKcj;_ZN12_GLOBAL__N_114getCommentKindEN4llvm9StringRefEb;_ZN12_GLOBAL__N_125commentsStartOnSameColumnERKN5clang13SourceManagerERKNS0_10RawCommentES6_;_ZN12_GLOBAL__N_130mergedCommentIsTrailingCommentEN4llvm9StringRefE; -static-type=RawCommentListStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class RawCommentListStatics {

/// Get comment kind and bool describing if it is a trailing comment.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getCommentKind">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 25,
 FQN="(anonymous namespace)::getCommentKind", NM="_ZN12_GLOBAL__N_114getCommentKindEN4llvm9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN12_GLOBAL__N_114getCommentKindEN4llvm9StringRefEb")
//</editor-fold>
public static std.pairTypeBool<RawComment.CommentKind> getCommentKind(StringRef Comment, 
              boolean ParseAllComments) {
  /*const*//*size_t*/int MinCommentLength = ParseAllComments ? 2 : 3;
  if (($less_uint(Comment.size(), MinCommentLength)) || Comment.$at(0) != $$SLASH) {
    return std.make_pair_E_bool(RawComment.CommentKind.RCK_Invalid, false);
  }
  
  RawComment.CommentKind K;
  if (Comment.$at(1) == $$SLASH) {
    if ($less_uint(Comment.size(), 3)) {
      return std.make_pair_E_bool(RawComment.CommentKind.RCK_OrdinaryBCPL, false);
    }
    if (Comment.$at(2) == $$SLASH) {
      K = RawComment.CommentKind.RCK_BCPLSlash;
    } else if (Comment.$at(2) == $$EXCLAMATION) {
      K = RawComment.CommentKind.RCK_BCPLExcl;
    } else {
      return std.make_pair_E_bool(RawComment.CommentKind.RCK_OrdinaryBCPL, false);
    }
  } else {
    assert ($greatereq_uint(Comment.size(), 4));
    
    // Comment lexer does not understand escapes in comment markers, so pretend
    // that this is not a comment.
    if (Comment.$at(1) != $$STAR
       || Comment.$at(Comment.size() - 2) != $$STAR
       || Comment.$at(Comment.size() - 1) != $$SLASH) {
      return std.make_pair_E_bool(RawComment.CommentKind.RCK_Invalid, false);
    }
    if (Comment.$at(2) == $$STAR) {
      K = RawComment.CommentKind.RCK_JavaDoc;
    } else if (Comment.$at(2) == $$EXCLAMATION) {
      K = RawComment.CommentKind.RCK_Qt;
    } else {
      return std.make_pair_E_bool(RawComment.CommentKind.RCK_OrdinaryC, false);
    }
  }
  /*const*/boolean TrailingComment = ($greater_uint(Comment.size(), 3)) && (Comment.$at(3) == $$LT);
  return std.make_pair_E_boolean(K, TrailingComment);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::mergedCommentIsTrailingComment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 63,
 FQN="(anonymous namespace)::mergedCommentIsTrailingComment", NM="_ZN12_GLOBAL__N_130mergedCommentIsTrailingCommentEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN12_GLOBAL__N_130mergedCommentIsTrailingCommentEN4llvm9StringRefE")
//</editor-fold>
public static boolean mergedCommentIsTrailingComment(StringRef Comment) {
  return ($greater_uint(Comment.size(), 3)) && (Comment.$at(3) == $$LT);
}


/// Returns true if R1 and R2 both have valid locations that start on the same
/// column.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::commentsStartOnSameColumn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 69,
 FQN="(anonymous namespace)::commentsStartOnSameColumn", NM="_ZN12_GLOBAL__N_125commentsStartOnSameColumnERKN5clang13SourceManagerERKNS0_10RawCommentES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN12_GLOBAL__N_125commentsStartOnSameColumnERKN5clang13SourceManagerERKNS0_10RawCommentES6_")
//</editor-fold>
public static boolean commentsStartOnSameColumn(final /*const*/ SourceManager /*&*/ SM, final /*const*/ RawComment /*&*/ R1, 
                         final /*const*/ RawComment /*&*/ R2) {
  SourceLocation L1 = R1.getLocStart();
  SourceLocation L2 = R2.getLocStart();
  bool$ptr Invalid = create_bool$ptr(false);
  /*uint*/int C1 = SM.getPresumedColumnNumber(/*NO_COPY*/L1, $AddrOf(Invalid));
  if (!Invalid.$star()) {
    /*uint*/int C2 = SM.getPresumedColumnNumber(/*NO_COPY*/L2, $AddrOf(Invalid));
    return !Invalid.$star() && (C1 == C2);
  }
  return false;
}

// unnamed namespace

/// \brief Determines whether there is only whitespace in `Buffer` between `P`
/// and the previous line.
/// \param Buffer The buffer to search in.
/// \param P The offset from the beginning of `Buffer` to start from.
/// \return true if all of the characters in `Buffer` ranging from the closest
/// line-ending character before `P` (or the beginning of `Buffer`) to `P - 1`
/// are whitespace.
//<editor-fold defaultstate="collapsed" desc="onlyWhitespaceOnLineBefore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 90,
 FQN="onlyWhitespaceOnLineBefore", NM="_ZL26onlyWhitespaceOnLineBeforePKcj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZL26onlyWhitespaceOnLineBeforePKcj")
//</editor-fold>
public static boolean onlyWhitespaceOnLineBefore(/*const*/char$ptr/*char P*/ Buffer, /*uint*/int P) {
  // Search backwards until we see linefeed or carriage return.
  for (/*uint*/int I = P; I != 0; --I) {
    /*char*/byte C = Buffer.$at(I - 1);
    if (isVerticalWhitespace(C)) {
      return true;
    }
    if (!isHorizontalWhitespace(C)) {
      return false;
    }
  }
  // We hit the beginning of the buffer.
  return true;
}


/// Returns whether `K` is an ordinary comment kind.
//<editor-fold defaultstate="collapsed" desc="isOrdinaryKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 104,
 FQN="isOrdinaryKind", NM="_ZL14isOrdinaryKindN5clang10RawComment11CommentKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZL14isOrdinaryKindN5clang10RawComment11CommentKindE")
//</editor-fold>
public static boolean isOrdinaryKind(RawComment.CommentKind K) {
  return (K == RawComment.CommentKind.RCK_OrdinaryBCPL)
     || (K == RawComment.CommentKind.RCK_OrdinaryC);
}

//<editor-fold defaultstate="collapsed" desc="onlyWhitespaceBetween">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp", line = 224,
 FQN="onlyWhitespaceBetween", NM="_ZL21onlyWhitespaceBetweenRN5clang13SourceManagerENS_14SourceLocationES2_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZL21onlyWhitespaceBetweenRN5clang13SourceManagerENS_14SourceLocationES2_j")
//</editor-fold>
public static boolean onlyWhitespaceBetween(final SourceManager /*&*/ SM, 
                     SourceLocation Loc1, SourceLocation Loc2, 
                     /*uint*/int MaxNewlinesAllowed) {
  std.pairTypeUInt<FileID> Loc1Info = SM.getDecomposedLoc(/*NO_COPY*/Loc1);
  std.pairTypeUInt<FileID> Loc2Info = SM.getDecomposedLoc(/*NO_COPY*/Loc2);
  
  // Question does not make sense if locations are in different files.
  if (Loc1Info.first.$noteq(Loc2Info.first)) {
    return false;
  }
  
  bool$ptr Invalid = /*JAVA:PERF*/null; // create_bool$ptr(false);
  StringRef $Buffer = SM.getBufferData(/*NO_COPY*/Loc1Info.first, /*AddrOf*/Invalid);
  if ($Buffer /*JAVA:PERF*/== SourceManager.INVALID_BUFFER_DATA) {
    return false;
  }
    
  /*const*/char$ptr/*char P*/ Buffer = $tryClone($Buffer.data());
  
  /*uint*/int NumNewlines = 0;
  assert ($lesseq_uint(Loc1Info.second, Loc2Info.second)) : "Loc1 after Loc2!";
  // Look for non-whitespace characters and remember any newlines seen.
  for (/*uint*/int I = Loc1Info.second; I != Loc2Info.second; ++I) {
    switch (Buffer.$at(I)) {
     default:
      return false;
     case ' ':
     case '\t':
     case '\f':
     case '\013'/*\v*/:
      break;
     case '\r':
     case '\n':
      ++NumNewlines;
      
      // Check if we have found more than the maximum allowed number of
      // newlines.
      if ($greater_uint(NumNewlines, MaxNewlinesAllowed)) {
        return false;
      }
      
      // Collapse \r\n and \n\r into a single newline.
      if (I + 1 != Loc2Info.second
         && (Buffer.$at(I + 1) == $$LF || Buffer.$at(I + 1) == $$CR)
         && Buffer.$at(I) != Buffer.$at(I + 1)) {
        ++I;
      }
      break;
    }
  }
  
  return true;
}

} // END OF class RawCommentListStatics
