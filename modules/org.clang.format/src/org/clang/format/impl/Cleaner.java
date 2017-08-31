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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.basic.*;
import org.clang.format.*;
import org.clang.format.java.FormatFunctionPointers.*;


// This class clean up the erroneous/redundant code around the given ranges in
// file.
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 984,
 FQN="clang::format::(anonymous namespace)::Cleaner", NM="_ZN5clang6format12_GLOBAL__N_17CleanerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17CleanerE")
//</editor-fold>
public class Cleaner extends /*public*/ TokenAnalyzer implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::Cleaner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 986,
   FQN="clang::format::(anonymous namespace)::Cleaner::Cleaner", NM="_ZN5clang6format12_GLOBAL__N_17CleanerC1ERKNS0_11EnvironmentERKNS0_11FormatStyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17CleanerC1ERKNS0_11EnvironmentERKNS0_11FormatStyleE")
  //</editor-fold>
  public Cleaner(final /*const*/ Environment /*&*/ Env, final /*const*/ FormatStyle /*&*/ Style) {
    // : TokenAnalyzer(Env, Style), DeletedTokens(FormatTokenLess(Env.getSourceManager())), DeletedLines() 
    //START JInit
    super(Env, Style);
    this.DeletedTokens = new std.setPtr<FormatToken /*P*/ >(new FormatTokenLess(Env.getSourceManager()));
    this.DeletedLines = new std.setUInt();
    //END JInit
  }

  
  // FIXME: eliminate unused parameters.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::analyze">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 991,
   FQN="clang::format::(anonymous namespace)::Cleaner::analyze", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner7analyzeERNS0_14TokenAnnotatorERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEERNS0_16FormatTokenLexerERSt3setINS_7tooling11ReplacementESt4lessISF_ESaISF_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner7analyzeERNS0_14TokenAnnotatorERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEERNS0_16FormatTokenLexerERSt3setINS_7tooling11ReplacementESt4lessISF_ESaISF_EE")
  //</editor-fold>
  @Override public std.setType<Replacement> analyze(final TokenAnnotator /*&*/ Annotator, 
         final SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ AnnotatedLines, 
         final FormatTokenLexer /*&*/ Tokens, final std.setType<Replacement> /*&*/ Result)/* override*/ {
    // FIXME: in the current implementation the granularity of affected range
    // is an annotated line. However, this is not sufficient. Furthermore,
    // redundant code introduced by replacements does not necessarily
    // intercept with ranges of replacements that result in the redundancy.
    // To determine if some redundant code is actually introduced by
    // replacements(e.g. deletions), we need to come up with a more
    // sophisticated way of computing affected ranges.
    AffectedRangeMgr.computeAffectedLines(AnnotatedLines.begin(), 
        AnnotatedLines.end());
    
    checkEmptyNamespace(AnnotatedLines);
    
    for (AnnotatedLine /*P*/ /*&*/ Line : AnnotatedLines) {
      if (Line.Affected) {
        cleanupRight(Line.First, tok.TokenKind.comma, tok.TokenKind.comma);
        cleanupRight(Line.First, TokenType.TT_CtorInitializerColon, tok.TokenKind.comma);
        cleanupLeft(Line.First, TokenType.TT_CtorInitializerComma, tok.TokenKind.l_brace);
        cleanupLeft(Line.First, TokenType.TT_CtorInitializerColon, tok.TokenKind.l_brace);
      }
    }
    
    return generateFixes();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::containsOnlyComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1020,
   FQN="clang::format::(anonymous namespace)::Cleaner::containsOnlyComments", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner20containsOnlyCommentsERKNS0_13AnnotatedLineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner20containsOnlyCommentsERKNS0_13AnnotatedLineE")
  //</editor-fold>
  private boolean containsOnlyComments(final /*const*/ AnnotatedLine /*&*/ Line) {
    for (FormatToken /*P*/ Tok = Line.First; Tok != null; Tok = Tok.Next) {
      if (Tok.isNot(tok.TokenKind.comment)) {
        return false;
      }
    }
    return true;
  }

  
  // Iterate through all lines and remove any empty (nested) namespaces.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::checkEmptyNamespace">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1029,
   FQN="clang::format::(anonymous namespace)::Cleaner::checkEmptyNamespace", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner19checkEmptyNamespaceERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner19checkEmptyNamespaceERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEE")
  //</editor-fold>
  private void checkEmptyNamespace(final SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ AnnotatedLines) {
    for (int i = 0, e = AnnotatedLines.size(); i != e; ++i) {
      final AnnotatedLine /*&*/ Line = /*Deref*/AnnotatedLines.$at(i);
      if (Line.startsWith(tok.TokenKind.kw_namespace)
         || Line.startsWith(tok.TokenKind.kw_inline, tok.TokenKind.kw_namespace)) {
        
        uint$ref i_ref = create_uint$ref(i);
        checkEmptyNamespace(AnnotatedLines, i, i_ref);
        i = i_ref.$deref();
      }
    }
    
    for (/*uint*/int Line : DeletedLines) {
      FormatToken /*P*/ Tok = AnnotatedLines.$at(Line).First;
      while ((Tok != null)) {
        deleteToken(Tok);
        Tok = Tok.Next;
      }
    }
  }

  
  // The function checks if the namespace, which starts from \p CurrentLine, and
  // its nested namespaces are empty and delete them if they are empty. It also
  // sets \p NewLine to the last line checked.
  // Returns true if the current namespace is empty.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::checkEmptyNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1051,
   FQN="clang::format::(anonymous namespace)::Cleaner::checkEmptyNamespace", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner19checkEmptyNamespaceERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEEjRj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner19checkEmptyNamespaceERN4llvm15SmallVectorImplIPNS0_13AnnotatedLineEEEjRj")
  //</editor-fold>
  private boolean checkEmptyNamespace(final SmallVectorImpl<AnnotatedLine /*P*/ > /*&*/ AnnotatedLines, 
                     /*uint*/int CurrentLine, final uint$ref/*uint &*/ NewLine) {
    /*uint*/int InitLine = CurrentLine;
    /*uint*/int End = AnnotatedLines.size();
    if (Style.BraceWrapping.AfterNamespace) {
      // If the left brace is in a new line, we should consume it first so that
      // it does not make the namespace non-empty.
      // FIXME: error handling if there is no left brace.
      if (!AnnotatedLines.$at(++CurrentLine).startsWith(tok.TokenKind.l_brace)) {
        NewLine.$set(CurrentLine);
        return false;
      }
    } else if (!AnnotatedLines.$at(CurrentLine).endsWith(tok.TokenKind.l_brace)) {
      return false;
    }
    while ($less_uint(++CurrentLine, End)) {
      if (AnnotatedLines.$at(CurrentLine).startsWith(tok.TokenKind.r_brace)) {
        break;
      }
      if (AnnotatedLines.$at(CurrentLine).startsWith(tok.TokenKind.kw_namespace)
         || AnnotatedLines.$at(CurrentLine).startsWith(tok.TokenKind.kw_inline, 
          tok.TokenKind.kw_namespace)) {
        if (!checkEmptyNamespace(AnnotatedLines, CurrentLine, NewLine)) {
          return false;
        }
        CurrentLine = NewLine.$deref();
        continue;
      }
      if (containsOnlyComments(/*Deref*/AnnotatedLines.$at(CurrentLine))) {
        continue;
      }
      
      // If there is anything other than comments or nested namespaces in the
      // current namespace, the namespace cannot be empty.
      NewLine.$set(CurrentLine);
      return false;
    }
    
    NewLine.$set(CurrentLine);
    if ($greatereq_uint(CurrentLine, End)) {
      return false;
    }
    
    // Check if the empty namespace is actually affected by changed ranges.
    if (!AffectedRangeMgr.affectsCharSourceRange(CharSourceRange.getCharRange(AnnotatedLines.$at(InitLine).First.Tok.getLocation(), 
            AnnotatedLines.$at(CurrentLine).Last.Tok.getEndLoc()))) {
      return false;
    }
    
    for (/*uint*/int i = InitLine; $lesseq_uint(i, CurrentLine); ++i) {
      DeletedLines.insert_T$C$R(i);
    }
    
    return true;
  }

  
  // Checks pairs {start, start->next},..., {end->previous, end} and deletes one
  // of the token in the pair if the left token has \p LK token kind and the
  // right token has \p RK token kind. If \p DeleteLeft is true, the left token
  // is deleted on match; otherwise, the right token is deleted.
  //</*typename*/ LeftKind/* = TokenKind*/, /*typename*/ RightKind/* = TokenKind*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::cleanupPair">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1109,
   FQN="clang::format::(anonymous namespace)::Cleaner::cleanupPair", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupPairINS_3tok9TokenKindES5_EEvPNS0_11FormatTokenET_T0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupPairINS_3tok9TokenKindES5_EEvPNS0_11FormatTokenET_T0_b")
  //</editor-fold>
  private void cleanupPair(FormatToken /*P*/ Start, /*tok.TokenKind*/char LK, /*tok.TokenKind*/char RK, 
             boolean DeleteLeft) {
    FormatToken2FormatToken NextNotDeleted = /*[this]*/ (final /*const*/ FormatToken /*&*/ Tok) -> {
          for (FormatToken /*P*/ Res = Tok.Next; (Res != null); Res = Res.Next)  {
            if (!Res.is_TokenKind(tok.TokenKind.comment)
               && DeletedTokens.find(Res).$eq(DeletedTokens.end())) {
              return Res;
            }
          }
          return null;
        };
    for (FormatToken /*P*/ Left = Start; (Left != null);) {
      FormatToken /*P*/ Right = NextNotDeleted.$call(/*Deref*/Left);
      if (!(Right != null)) {
        break;
      }
      if (Left.is_TokenKind(LK) && Right.is_TokenKind(RK)) {
        deleteToken(DeleteLeft ? Left : Right);
        // If the right token is deleted, we should keep the left token
        // unchanged and pair it with the new right token.
        if (!DeleteLeft) {
          continue;
        }
      }
      Left = Right;
    }
  }
  //</*typename*/ LeftKind/* = TokenType*/, /*typename*/ RightKind/* = TokenKind*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::cleanupPair">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1109,
   FQN="clang::format::(anonymous namespace)::Cleaner::cleanupPair", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupPairINS0_9TokenTypeENS_3tok9TokenKindEEEvPNS0_11FormatTokenET_T0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupPairINS0_9TokenTypeENS_3tok9TokenKindEEEvPNS0_11FormatTokenET_T0_b")
  //</editor-fold>
  private void cleanupPair(FormatToken /*P*/ Start, TokenType LK, /*tok.TokenKind*/char RK, 
             boolean DeleteLeft) {
    FormatToken2FormatToken NextNotDeleted = /*[this]*/ (final /*const*/ FormatToken /*&*/ Tok) -> {
          for (FormatToken /*P*/ Res = Tok.Next; (Res != null); Res = Res.Next)  {
            if (!Res.is_TokenKind(tok.TokenKind.comment)
               && DeletedTokens.find(Res).$eq(DeletedTokens.end())) {
              return Res;
            }
          }
          return null;
        };
    for (FormatToken /*P*/ Left = Start; (Left != null);) {
      FormatToken /*P*/ Right = NextNotDeleted.$call(/*Deref*/Left);
      if (!(Right != null)) {
        break;
      }
      if (Left.is_TokenType(LK) && Right.is_TokenKind(RK)) {
        deleteToken(DeleteLeft ? Left : Right);
        if (!DeleteLeft) {
          continue;
        }
      }
      Left = Right;
    }
  }
//  /*template <typename LeftKind, typename RightKind> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::cleanupPair">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1109,
//   FQN="clang::format::(anonymous namespace)::Cleaner::cleanupPair", NM="Tpl__ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupPairEPNS0_11FormatTokenET_T0_b",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupPairEPNS0_11FormatTokenET_T0_b")
//  //</editor-fold>
//  private </*typename*/ LeftKind, /*typename*/ RightKind> void cleanupPair(FormatToken /*P*/ Start, LeftKind LK, RightKind RK, 
//             boolean DeleteLeft) {
//    FormatToken2FormatToken NextNotDeleted = /*[this]*/ (final /*const*/ FormatToken /*&*/ Tok) -> {
//          for (FormatToken /*P*/ Res = Tok.Next; (Res != null); Res = Res.Next)  {
//            if (!Res.is_TokenKind(tok.TokenKind.comment)
//               && DeletedTokens.find(Res).$eq(DeletedTokens.end())) {
//              return Res;
//            }
//          }
//          return null;
//        };
//    for (FormatToken /*P*/ Left = Start; (Left != null);) {
//      auto /*P*/ Right = NextNotDeleted.$call(/*Deref*/Left);
//      if (Native.$not(Right)) {
//        break;
//      }
//      if (Native.$bool(Left.is(LK)) && Native.$bool(Right.is(RK))) {
//        deleteToken(DeleteLeft ? Left : Right);
//        if (!DeleteLeft) {
//          continue;
//        }
//      }
//      Left = Right;
//    }
//  }

  
  //</*typename*/ LeftKind/* = TokenType*/, /*typename*/ RightKind/* = TokenKind*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::cleanupLeft">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1134,
   FQN="clang::format::(anonymous namespace)::Cleaner::cleanupLeft", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupLeftINS0_9TokenTypeENS_3tok9TokenKindEEEvPNS0_11FormatTokenET_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupLeftINS0_9TokenTypeENS_3tok9TokenKindEEEvPNS0_11FormatTokenET_T0_")
  //</editor-fold>
  private void cleanupLeft(FormatToken /*P*/ Start, TokenType LK, /*tok.TokenKind*/char RK) {
    cleanupPair(Start, LK, RK, /*DeleteLeft=*/ true);
  }
//  /*template <typename LeftKind, typename RightKind> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::cleanupLeft">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1134,
//   FQN="clang::format::(anonymous namespace)::Cleaner::cleanupLeft", NM="Tpl__ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupLeftEPNS0_11FormatTokenET_T0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN5clang6format12_GLOBAL__N_17Cleaner11cleanupLeftEPNS0_11FormatTokenET_T0_")
//  //</editor-fold>
//  private </*typename*/ LeftKind, /*typename*/ RightKind> void cleanupLeft(FormatToken /*P*/ Start, LeftKind LK, RightKind RK) {
//    cleanupPair(Start, LK, RK, true);
//  }

  
  //</*typename*/ LeftKind/* = TokenKind*/, /*typename*/ RightKind/* = TokenKind*/> 
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::cleanupRight">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1139,
   FQN="clang::format::(anonymous namespace)::Cleaner::cleanupRight", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner12cleanupRightINS_3tok9TokenKindES5_EEvPNS0_11FormatTokenET_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner12cleanupRightINS_3tok9TokenKindES5_EEvPNS0_11FormatTokenET_T0_")
  //</editor-fold>
  private void cleanupRight(FormatToken /*P*/ Start, /*tok.TokenKind*/char LK, /*tok.TokenKind*/char RK) {
    cleanupPair(Start, LK, RK, /*DeleteLeft=*/ false);
  }
  //</*typename*/ LeftKind/* = TokenType*/, /*typename*/ RightKind/* = TokenKind*/> 
//<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::cleanupRight">
  @Converted(kind = Converted.Kind.INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1139,
   FQN="clang::format::(anonymous namespace)::Cleaner::cleanupRight", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner12cleanupRightINS0_9TokenTypeENS_3tok9TokenKindEEEvPNS0_11FormatTokenET_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner12cleanupRightINS0_9TokenTypeENS_3tok9TokenKindEEEvPNS0_11FormatTokenET_T0_")
  //</editor-fold>
  private void cleanupRight(FormatToken /*P*/ Start, TokenType LK, /*tok.TokenKind*/char RK) {
    cleanupPair(Start, LK, RK, false);
  }
//  /*template <typename LeftKind, typename RightKind> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::cleanupRight">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1139,
//   FQN="clang::format::(anonymous namespace)::Cleaner::cleanupRight", NM="Tpl__ZN5clang6format12_GLOBAL__N_17Cleaner12cleanupRightEPNS0_11FormatTokenET_T0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=Tpl__ZN5clang6format12_GLOBAL__N_17Cleaner12cleanupRightEPNS0_11FormatTokenET_T0_")
//  //</editor-fold>
//  private </*typename*/ LeftKind, /*typename*/ RightKind> void cleanupRight(FormatToken /*P*/ Start, LeftKind LK, RightKind RK) {
//    cleanupPair(Start, LK, RK, false);
//  }

  
  // Delete the given token.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::deleteToken">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1144,
   FQN="clang::format::(anonymous namespace)::Cleaner::deleteToken", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner11deleteTokenEPNS0_11FormatTokenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner11deleteTokenEPNS0_11FormatTokenE")
  //</editor-fold>
  private /*inline*/ void deleteToken(FormatToken /*P*/ Tok) {
    if ((Tok != null)) {
      DeletedTokens.insert_T$C$R(Tok);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::generateFixes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1149,
   FQN="clang::format::(anonymous namespace)::Cleaner::generateFixes", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner13generateFixesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner13generateFixesEv")
  //</editor-fold>
  private std.setType<Replacement> generateFixes() {
    std.setType<Replacement> Fixes = null;
    std.vector<FormatToken /*P*/ > Tokens = null;
    try {
      Fixes/*J*/= new std.setType<Replacement>();
      Tokens/*J*/= new std.vector<FormatToken /*P*/ >((FormatToken /*P*/ )null);
      std.copy(DeletedTokens.begin(), DeletedTokens.end(), 
          std.back_inserter(Tokens));
      
      // Merge multiple continuous token deletions into one big deletion so that
      // the number of replacements can be reduced. This makes computing affected
      // ranges more efficient when we run reformat on the changed code.
      /*uint*/int Idx = 0;
      while ($less_uint(Idx, Tokens.size())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*uint*/int St = Idx;
          /*uint*/int End = Idx;
          while ($less_uint((End + 1), Tokens.size())
             && Tokens.$at(End).Next == Tokens.$at(End + 1)) {
            End++;
          }
          CharSourceRange SR = CharSourceRange.getCharRange(Tokens.$at(St).Tok.getLocation(), 
              Tokens.$at(End).Tok.getEndLoc());
          $c$.clean(Fixes.insert_T$RR($c$.track(new Replacement(Env.getSourceManager(), SR, new StringRef(/*KEEP_STR*/$EMPTY)))));
          Idx = End + 1;
        } finally {
          $c$.$destroy();
        }
      }
      
      return new std.setType<Replacement>(JD$Move.INSTANCE, Fixes);
    } finally {
      if (Tokens != null) { Tokens.$destroy(); }
      if (Fixes != null) { Fixes.$destroy(); }
    }
  }

  
  // Class for less-than inequality comparason for the set `RedundantTokens`.
  // We store tokens in the order they appear in the translation unit so that
  // we do not need to sort them in `generateFixes()`.
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::FormatTokenLess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1177,
   FQN="clang::format::(anonymous namespace)::Cleaner::FormatTokenLess", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner15FormatTokenLessE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner15FormatTokenLessE")
  //</editor-fold>
  private static class/*struct*/ FormatTokenLess implements binary_functionArgArg2Bool<FormatToken, FormatToken> {
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::FormatTokenLess::FormatTokenLess">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1178,
     FQN="clang::format::(anonymous namespace)::Cleaner::FormatTokenLess::FormatTokenLess", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner15FormatTokenLessC1ERKNS_13SourceManagerE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner15FormatTokenLessC1ERKNS_13SourceManagerE")
    //</editor-fold>
    public FormatTokenLess(final /*const*/ SourceManager /*&*/ SM) {
      // : SM(SM) 
      //START JInit
      this./*&*/SM=/*&*/SM;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::FormatTokenLess::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1180,
     FQN="clang::format::(anonymous namespace)::Cleaner::FormatTokenLess::operator()", NM="_ZNK5clang6format12_GLOBAL__N_17Cleaner15FormatTokenLessclEPKNS0_11FormatTokenES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZNK5clang6format12_GLOBAL__N_17Cleaner15FormatTokenLessclEPKNS0_11FormatTokenES6_")
    //</editor-fold>
    public boolean $call(/*const*/ FormatToken /*P*/ LHS, /*const*/ FormatToken /*P*/ RHS) /*const*/ {
      return SM.isBeforeInTranslationUnit(LHS.Tok.getLocation(), 
          RHS.Tok.getLocation());
    }

    public final /*const*/ SourceManager /*&*/ SM;
    //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::FormatTokenLess::FormatTokenLess">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 1177,
     FQN="clang::format::(anonymous namespace)::Cleaner::FormatTokenLess::FormatTokenLess", NM="_ZN5clang6format12_GLOBAL__N_17Cleaner15FormatTokenLessC1ERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17Cleaner15FormatTokenLessC1ERKS3_")
    //</editor-fold>
    public /*inline*/ FormatTokenLess(final /*const*/ FormatTokenLess /*&*/ $Prm0) {
      // : SM(.SM) 
      //START JInit
      this./*&*/SM=/*&*/$Prm0.SM;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "SM=" + "[SourceManager]"; // NOI18N
    }
  };
  
  // Tokens to be deleted.
  private std.setPtr<FormatToken /*P*/ > DeletedTokens;
  // The line numbers of lines to be deleted.
  private std.setUInt DeletedLines;
  //<editor-fold defaultstate="collapsed" desc="clang::format::(anonymous namespace)::Cleaner::~Cleaner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 984,
   FQN="clang::format::(anonymous namespace)::Cleaner::~Cleaner", NM="_ZN5clang6format12_GLOBAL__N_17CleanerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN5clang6format12_GLOBAL__N_17CleanerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DeletedLines.$destroy();
    DeletedTokens.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "DeletedTokens=" + DeletedTokens // NOI18N
              + ", DeletedLines=" + DeletedLines // NOI18N
              + super.toString(); // NOI18N
  }
}
