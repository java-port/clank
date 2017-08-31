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
package org.clang.rewrite.core;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.clang.lex.llvm.ArrayRefToken;
import org.clang.lex.llvm.SmallVectorToken;
import static org.clang.rewrite.impl.HTMLRewriteStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type html">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html10EscapeTextEN4llvm9StringRefEbb;_ZN5clang4html10EscapeTextERNS_8RewriterENS_6FileIDEbb;_ZN5clang4html14AddLineNumbersERNS_8RewriterENS_6FileIDE;_ZN5clang4html14HighlightRangeERNS_13RewriteBufferEjjPKcS4_S4_;_ZN5clang4html14HighlightRangeERNS_8RewriterENS_11SourceRangeEPKcS5_;_ZN5clang4html14HighlightRangeERNS_8RewriterENS_14SourceLocationES3_PKcS5_;_ZN5clang4html15HighlightMacrosERNS_8RewriterENS_6FileIDERKNS_12PreprocessorE;_ZN5clang4html15SyntaxHighlightERNS_8RewriterENS_6FileIDERKNS_12PreprocessorE;_ZN5clang4html33AddHeaderFooterInternalBuiltinCSSERNS_8RewriterENS_6FileIDEPKc; -static-type=html -package=org.clang.rewrite.core")
//</editor-fold>
public final class html {


/// HighlightRange - Highlight a range in the source code with the specified
/// start/end tags.  B/E must be in the same file.  This ensures that
/// start/end tags are placed at the start/end of each line if the range is
/// multiline.

/// HighlightRange - Highlight a range in the source code with the specified
/// start/end tags.  B/E must be in the same file.  This ensures that
/// start/end tags are placed at the start/end of each line if the range is
/// multiline.
//<editor-fold defaultstate="collapsed" desc="clang::html::HighlightRange">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*getBufferData*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 32,
 FQN="clang::html::HighlightRange", NM="_ZN5clang4html14HighlightRangeERNS_8RewriterENS_14SourceLocationES3_PKcS5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html14HighlightRangeERNS_8RewriterENS_14SourceLocationES3_PKcS5_")
//</editor-fold>
public static void HighlightRange(Rewriter /*&*/ R, SourceLocation B, SourceLocation E, 
              /*const*/char$ptr/*char P*/ StartTag, /*const*/char$ptr/*char P*/ EndTag) {
  SourceManager /*&*/ SM = R.getSourceMgr();
  B.$assignMove(SM.getExpansionLoc(/*NO_COPY*/B));
  E.$assignMove(SM.getExpansionLoc(/*NO_COPY*/E));
  FileID FID = SM.getFileID(/*NO_COPY*/B);
  assert (SM.getFileID(/*NO_COPY*/E).$eq(FID)) : "B/E not in the same file!";
  
  /*uint*/int BOffset = SM.getFileOffset(/*NO_COPY*/B);
  /*uint*/int EOffset = SM.getFileOffset(/*NO_COPY*/E);
  
  // Include the whole end token in the range.
  EOffset += Lexer.MeasureTokenLength(/*NO_COPY*/E, R.getSourceMgr(), R.getLangOpts());
  
  boolean Invalid = false;
  StringRef BufData = SM.getBufferData(/*NO_COPY*/FID, /*AddrOf*/null/*Invalid*/);
//  if (Invalid) {
//    return;
//  }
  if (BufData == SourceManager.INVALID_BUFFER_DATA) {
    return;
  }
  /*const*/char$ptr/*char P*/ BufferStart = $tryClone(BufData.data());
  
  HighlightRange(R.getEditBuffer(new FileID(FID)), BOffset, EOffset, 
      BufferStart, StartTag, EndTag);
}


/// HighlightRange - Highlight a range in the source code with the specified
/// start/end tags.  The Start/end of the range must be in the same file.
/// This ensures that start/end tags are placed at the start/end of each line
/// if the range is multiline.
//<editor-fold defaultstate="collapsed" desc="clang::html::HighlightRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Rewrite/Core/HTMLRewrite.h", line = 40,
 FQN="clang::html::HighlightRange", NM="_ZN5clang4html14HighlightRangeERNS_8RewriterENS_11SourceRangeEPKcS5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html14HighlightRangeERNS_8RewriterENS_11SourceRangeEPKcS5_")
//</editor-fold>
public static /*inline*/ void HighlightRange(Rewriter /*&*/ R, SourceRange Range, 
              /*const*/char$ptr/*char P*/ StartTag, /*const*/char$ptr/*char P*/ EndTag) {
  HighlightRange(R, Range.getBegin(), Range.getEnd(), StartTag, EndTag);
}


/// HighlightRange - This is the same as the above method, but takes
/// decomposed file locations.

/// HighlightRange - This is the same as the above method, but takes
/// decomposed file locations.
//<editor-fold defaultstate="collapsed" desc="clang::html::HighlightRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 57,
 FQN="clang::html::HighlightRange", NM="_ZN5clang4html14HighlightRangeERNS_13RewriteBufferEjjPKcS4_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html14HighlightRangeERNS_13RewriteBufferEjjPKcS4_S4_")
//</editor-fold>
public static void HighlightRange(RewriteBuffer /*&*/ RB, /*uint*/int B, /*uint*/int E, 
              /*const*/char$ptr/*char P*/ BufferStart, 
              /*const*/char$ptr/*char P*/ StartTag, /*const*/char$ptr/*char P*/ EndTag) {
  // Insert the tag at the absolute start/end of the range.
  RB.InsertTextAfter(B, new StringRef(StartTag));
  RB.InsertTextBefore(E, new StringRef(EndTag));
  
  // Scan the range to see if there is a \r or \n.  If so, and if the line is
  // not blank, insert tags on that line as well.
  boolean HadOpenTag = true;
  
  /*uint*/int LastNonWhiteSpace = B;
  for (/*uint*/int i = B; i != E; ++i) {
    switch (BufferStart.$at(i)) {
     case '\r':
     case '\n':
      // Okay, we found a newline in the range.  If we have an open tag, we need
      // to insert a close tag at the first non-whitespace before the newline.
      if (HadOpenTag) {
        RB.InsertTextBefore(LastNonWhiteSpace + 1, new StringRef(EndTag));
      }
      
      // Instead of inserting an open tag immediately after the newline, we
      // wait until we see a non-whitespace character.  This prevents us from
      // inserting tags around blank lines, and also allows the open tag to
      // be put *after* whitespace on a non-blank line.
      HadOpenTag = false;
      break;
     case '\0':
     case ' ':
     case '\t':
     case '\f':
     case '\013'/*\v*/:
      // Ignore whitespace.
      break;
     default:
      // If there is no tag open, do it now.
      if (!HadOpenTag) {
        RB.InsertTextAfter(i, new StringRef(StartTag));
        HadOpenTag = true;
      }
      
      // Remember this character.
      LastNonWhiteSpace = i;
      break;
    }
  }
}


/// EscapeText - HTMLize a specified file so that special characters are
/// are translated so that they are not interpreted as HTML tags.
//<editor-fold defaultstate="collapsed" desc="clang::html::EscapeText">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 106,
 FQN="clang::html::EscapeText", NM="_ZN5clang4html10EscapeTextERNS_8RewriterENS_6FileIDEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html10EscapeTextERNS_8RewriterENS_6FileIDEbb")
//</editor-fold>
public static void EscapeText(Rewriter /*&*/ R, FileID FID) {
  EscapeText(R, FID, 
          false, false);
}
public static void EscapeText(Rewriter /*&*/ R, FileID FID, 
          boolean EscapeSpaces/*= false*/) {
  EscapeText(R, FID, 
          EscapeSpaces, false);
}
public static void EscapeText(Rewriter /*&*/ R, FileID FID, 
          boolean EscapeSpaces/*= false*/, boolean ReplaceTabs/*= false*/) {
  
  /*const*/ MemoryBuffer /*P*/ Buf = R.getSourceMgr().getBuffer(/*NO_COPY*/FID);
  /*const*/char$ptr/*char P*/ C = $tryClone(Buf.getBufferStart());
  /*const*/char$ptr/*char P*/ FileEnd = $tryClone(Buf.getBufferEnd());
  assert (C.$lesseq(FileEnd));
  
  RewriteBuffer /*&*/ RB = R.getEditBuffer(new FileID(FID));
  
  /*uint*/int ColNo = 0;
  for (/*uint*/int FilePos = 0; $noteq_ptr(C, FileEnd); C.$preInc() , ++FilePos) {
    switch (C.$star()) {
     default:
      ++ColNo;
      break;
     case '\n':
     case '\r':
      ColNo = 0;
      break;
     case ' ':
      if (EscapeSpaces) {
        RB.ReplaceText(FilePos, 1, new StringRef(/*KEEP_STR*/"&nbsp;"));
      }
      ++ColNo;
      break;
     case '\f':
      RB.ReplaceText(FilePos, 1, new StringRef(/*KEEP_STR*/"<hr>"));
      ColNo = 0;
      break;
     case '\t':
      {
        if (!ReplaceTabs) {
          break;
        }
        /*uint*/int NumSpaces = 8 - (ColNo & 7);
        if (EscapeSpaces) {
          RB.ReplaceText(FilePos, 1, 
              new StringRef(/*KEEP_STR*/"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;", 6 * NumSpaces));
        } else {
          RB.ReplaceText(FilePos, 1, new StringRef(/*KEEP_STR*/"        ", NumSpaces));
        }
        ColNo += NumSpaces;
        break;
      }
     case '<':
      RB.ReplaceText(FilePos, 1, new StringRef(/*KEEP_STR*/"&lt;"));
      ++ColNo;
      break;
     case '>':
      RB.ReplaceText(FilePos, 1, new StringRef(/*KEEP_STR*/"&gt;"));
      ++ColNo;
      break;
     case '&':
      RB.ReplaceText(FilePos, 1, new StringRef(/*KEEP_STR*/"&amp;"));
      ++ColNo;
      break;
    }
  }
}


/// EscapeText - HTMLized the provided string so that special characters
///  in 's' are not interpreted as HTML tags.  Unlike the version of
///  EscapeText that rewrites a file, this version by default replaces tabs
///  with spaces.
//<editor-fold defaultstate="collapsed" desc="clang::html::EscapeText">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 167,
 FQN="clang::html::EscapeText", NM="_ZN5clang4html10EscapeTextEN4llvm9StringRefEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html10EscapeTextEN4llvm9StringRefEbb")
//</editor-fold>
public static std.string EscapeText(StringRef s) {
  return EscapeText(s, false, false);
}
public static std.string EscapeText(StringRef s, boolean EscapeSpaces/*= false*/) {
  return EscapeText(s, EscapeSpaces, false);
}
public static std.string EscapeText(StringRef s, boolean EscapeSpaces/*= false*/, boolean ReplaceTabs/*= false*/) {
  raw_string_ostream os = null;
  try {
    
    /*uint*/int len = s.size();
    std.string Str/*J*/= new std.string();
    os/*J*/= new raw_string_ostream(Str);
    
    for (/*uint*/int i = 0; $less_uint(i, len); ++i) {
      
      /*char*/byte c = s.$at(i);
      switch (c) {
       default:
        os.$out_char(c);
        break;
       case ' ':
        if (EscapeSpaces) {
          os.$out(/*KEEP_STR*/"&nbsp;");
        } else {
          os.$out_char($$SPACE);
        }
        break;
       case '\t':
        if (ReplaceTabs) {
          if (EscapeSpaces) {
            for (/*uint*/int _i = 0; $less_uint(_i, 4); ++_i)  {
              os.$out(/*KEEP_STR*/"&nbsp;");
            }
          } else {
            for (/*uint*/int _i = 0; $less_uint(_i, 4); ++_i)  {
              os.$out(/*KEEP_STR*/$SPACE);
            }
          }
        } else {
          os.$out_char(c);
        }
        
        break;
       case '<':
        os.$out(/*KEEP_STR*/"&lt;");
        break;
       case '>':
        os.$out(/*KEEP_STR*/"&gt;");
        break;
       case '&':
        os.$out(/*KEEP_STR*/"&amp;");
        break;
      }
    }
    
    return new std.string(os.str());
  } finally {
    if (os != null) { os.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::html::AddLineNumbers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 226,
 FQN="clang::html::AddLineNumbers", NM="_ZN5clang4html14AddLineNumbersERNS_8RewriterENS_6FileIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html14AddLineNumbersERNS_8RewriterENS_6FileIDE")
//</editor-fold>
public static void AddLineNumbers(Rewriter /*&*/ R, FileID FID) {
  
  /*const*/ MemoryBuffer /*P*/ Buf = R.getSourceMgr().getBuffer(/*NO_COPY*/FID);
  /*const*/char$ptr/*char P*/ FileBeg = $tryClone(Buf.getBufferStart());
  /*const*/char$ptr/*char P*/ FileEnd = $tryClone(Buf.getBufferEnd());
  /*const*/char$ptr/*char P*/ C = $tryClone(FileBeg);
  RewriteBuffer /*&*/ RB = R.getEditBuffer(new FileID(FID));
  assert (C.$lesseq(FileEnd));
  
  /*uint*/int LineNo = 0;
  /*uint*/int FilePos = 0;
  while ($noteq_ptr(C, FileEnd)) {
    
    ++LineNo;
    /*uint*/int LineStartPos = FilePos;
    /*uint*/int LineEndPos = FileEnd.$sub(FileBeg);
    assert ($lesseq_uint(FilePos, LineEndPos));
    assert (C.$less(FileEnd));
    
    // Scan until the newline (or end-of-file).
    while ($noteq_ptr(C, FileEnd)) {
      /*char*/byte c = C.$star();
      C.$preInc();
      if (c == $$LF) {
        LineEndPos = FilePos++;
        break;
      }
      
      ++FilePos;
    }
    
    AddLineNumber(RB, LineNo, LineStartPos, LineEndPos);
  }
  
  // Add one big table tag that surrounds all of the code.
  RB.InsertTextBefore(0, new StringRef(/*KEEP_STR*/"<table class=\"code\">\n"));
  RB.InsertTextAfter(FileEnd.$sub(FileBeg), new StringRef(/*KEEP_STR*/"</table>"));
}

//<editor-fold defaultstate="collapsed" desc="clang::html::AddHeaderFooterInternalBuiltinCSS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 270,
 FQN="clang::html::AddHeaderFooterInternalBuiltinCSS", NM="_ZN5clang4html33AddHeaderFooterInternalBuiltinCSSERNS_8RewriterENS_6FileIDEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html33AddHeaderFooterInternalBuiltinCSSERNS_8RewriterENS_6FileIDEPKc")
//</editor-fold>
public static void AddHeaderFooterInternalBuiltinCSS(Rewriter /*&*/ R, FileID FID) {
  AddHeaderFooterInternalBuiltinCSS(R, FID, 
                                 (/*const*/char$ptr/*char P*/ )null);
}
public static void AddHeaderFooterInternalBuiltinCSS(Rewriter /*&*/ R, FileID FID, 
                                 /*const*/char$ptr/*char P*/ title/*= null*/) {
  raw_string_ostream os = null;
  try {
    
    /*const*/ MemoryBuffer /*P*/ Buf = R.getSourceMgr().getBuffer(/*NO_COPY*/FID);
    /*const*/char$ptr/*char P*/ FileStart = $tryClone(Buf.getBufferStart());
    /*const*/char$ptr/*char P*/ FileEnd = $tryClone(Buf.getBufferEnd());
    
    SourceLocation StartLoc = R.getSourceMgr().getLocForStartOfFile(/*NO_COPY*/FID);
    SourceLocation EndLoc = StartLoc.getLocWithOffset(FileEnd.$sub(FileStart));
    
    std.string s/*J*/= new std.string();
    os/*J*/= new raw_string_ostream(s);
    os.$out(/*KEEP_STR*/"<!doctype html>\n<html>\n<head>\n");
    if ((title != null)) {
      os.$out(/*KEEP_STR*/"<title>").$out(html.EscapeText(new StringRef(title))).$out(/*KEEP_STR*/"</title>\n");
    }
    
    os.$out(/*KEEP_STR*/"<style type=\"text/css\">\n body { color:#000000; background-color:#ffffff }\n body { font-family:Helvetica, sans-serif; font-size:10pt }\n h1 { font-size:14pt }\n .code { border-collapse:collapse; width:100%; }\n .code { font-family: \"Monospace\", monospace; font-size:10pt }\n .code { line-height: 1.2em }\n .comment { color: green; font-style: oblique }\n .keyword { color: blue }\n .string_literal { color: red }\n .directive { color: darkmagenta }\n .expansion { display: none; }\n .macro:hover .expansion { display: block; border: 2px solid #FF0000; padding: 2px; background-color:#FFF0F0; font-weight: normal;   -webkit-border-radius:5px;  -webkit-box-shadow:1px 1px 7px #000; position: absolute; top: -1em; left:10em; z-index: 1 } \n .macro { color: darkmagenta; background-color:LemonChiffon; position: relative }\n .num { width:2.5em; padding-right:2ex; background-color:#eeeeee }\n .num { text-align:right; font-size:8pt }\n .num { color:#444444 }\n .line { padding-left: 1ex; border-left: 3px solid #ccc }\n .line { white-space: pre }\n .msg { -webkit-box-shadow:1px 1px 7px #000 }\n .msg { -webkit-border-radius:5px }\n .msg { font-family:Helvetica, sans-serif; font-size:8pt }\n .msg { float:left }\n .msg { padding:0.25em 1ex 0.25em 1ex }\n .msg { margin-top:10px; margin-bottom:10px }\n .msg { font-weight:bold }\n .msg { max-width:60em; word-wrap: break-word; white-space: pre-wrap }\n .msgT { padding:0x; spacing:0x }\n .msgEvent { background-color:#fff8b4; color:#000000 }\n .msgControl { background-color:#bbbbbb; color:#000000 }\n .mrange { background-color:#dfddf3 }\n .mrange { border-bottom:1px solid #6F9DBE }\n .PathIndex { font-weight: bold; padding:0px 5px; margin-right:5px; }\n .PathIndex { -webkit-border-radius:8px }\n .PathIndexEvent { background-color:#bfba87 }\n .PathIndexControl { background-color:#8c8c8c }\n .PathNav a { text-decoration:none; font-size: larger }\n .CodeInsertionHint { font-weight: bold; background-color: #10dd10 }\n .CodeRemovalHint { background-color:#de1010 }\n .CodeRemovalHint { border-bottom:1px solid #6F9DBE }\n table.simpletable {\n   padding: 5px;\n   font-size:12pt;\n   margin:20px;\n   border-collapse: collapse; border-spacing: 0px;\n }\n td.rowname {\n   text-align:right; font-weight:bold; color:#444444;\n   padding-right:2ex; }\n</style>\n</head>\n<body>");
    
    // Generate header
    R.InsertTextBefore(new SourceLocation(StartLoc), new StringRef(os.str()));
    // Generate footer
    R.InsertTextAfter(new SourceLocation(EndLoc), new StringRef(/*KEEP_STR*/"</body></html>\n"));
  } finally {
    if (os != null) { os.$destroy(); }
  }
}


/// SyntaxHighlight - Relex the specified FileID and annotate the HTML with
/// information about keywords, comments, etc.

/// SyntaxHighlight - Relex the specified FileID and annotate the HTML with
/// information about keywords, macro expansions etc.  This uses the macro
/// table state from the end of the file, so it won't be perfectly perfect,
/// but it will be reasonably close.
//<editor-fold defaultstate="collapsed" desc="clang::html::SyntaxHighlight">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 357,
 FQN="clang::html::SyntaxHighlight", NM="_ZN5clang4html15SyntaxHighlightERNS_8RewriterENS_6FileIDERKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html15SyntaxHighlightERNS_8RewriterENS_6FileIDERKNS_12PreprocessorE")
//</editor-fold>
public static void SyntaxHighlight(Rewriter /*&*/ R, FileID FID, /*const*/ Preprocessor /*&*/ PP) {
  Lexer L = null;
  try {
    RewriteBuffer /*&*/ RB = R.getEditBuffer(new FileID(FID));
    
    /*const*/ SourceManager /*&*/ SM = PP.getSourceManager();
    /*const*/ MemoryBuffer /*P*/ FromFile = SM.getBuffer(/*NO_COPY*/FID);
    L/*J*/= new Lexer(/*NO_COPY*/FID, FromFile, SM, PP.getLangOpts());
    /*const*/char$ptr/*char P*/ BufferStart = $tryClone(L.getBuffer().data());
    
    // Inform the preprocessor that we want to retain comments as tokens, so we
    // can highlight them.
    L.SetCommentRetentionState(true);
    
    // Lex all the tokens in raw mode, to avoid entering #includes or expanding
    // macros.
    Token Tok/*J*/= new Token();
    L.LexFromRawLexer(Tok);
    while (Tok.isNot(tok.TokenKind.eof)) {
      // Since we are lexing unexpanded tokens, all tokens are from the main
      // FileID.
      /*uint*/int TokOffs = SM.getFileOffset(Tok.getLocation());
      /*uint*/int TokLen = Tok.getLength();
      switch (Tok.getKind()) {
       default:
        break;
       case tok.TokenKind.identifier:
        throw new llvm_unreachable("tok::identifier in raw lexing mode!");
       case tok.TokenKind.raw_identifier:
        {
          // Fill in Result.IdentifierInfo and update the token kind,
          // looking up the identifier in the identifier table.
          PP.LookUpIdentifierInfo(Tok);
          
          // If this is a pp-identifier, for a keyword, highlight it as such.
          if (Tok.isNot(tok.TokenKind.identifier)) {
            HighlightRange(RB, TokOffs, TokOffs + TokLen, BufferStart, 
                $("<span class='keyword'>"), $("</span>"));
          }
          break;
        }
       case tok.TokenKind.comment:
        HighlightRange(RB, TokOffs, TokOffs + TokLen, BufferStart, 
            $("<span class='comment'>"), $("</span>"));
        break;
       case tok.TokenKind.utf8_string_literal:
        // Chop off the u part of u8 prefix
        ++TokOffs;
        --TokLen;
       case tok.TokenKind.wide_string_literal:
       case tok.TokenKind.utf16_string_literal:
       case tok.TokenKind.utf32_string_literal:
        // Chop off the L, u, U or 8 prefix
        ++TokOffs;
        --TokLen;
       case tok.TokenKind.string_literal:
        // FIXME: Exclude the optional ud-suffix from the highlighted range.
        HighlightRange(RB, TokOffs, TokOffs + TokLen, BufferStart, 
            $("<span class='string_literal'>"), $("</span>"));
        break;
       case tok.TokenKind.hash:
        {
          // If this is a preprocessor directive, all tokens to end of line are too.
          if (!Tok.isAtStartOfLine()) {
            break;
          }
          
          // Eat all of the tokens until we get to the next one at the start of
          // line.
          /*uint*/int TokEnd = TokOffs + TokLen;
          L.LexFromRawLexer(Tok);
          while (!Tok.isAtStartOfLine() && Tok.isNot(tok.TokenKind.eof)) {
            TokEnd = SM.getFileOffset(Tok.getLocation()) + Tok.getLength();
            L.LexFromRawLexer(Tok);
          }
          
          // Find end of line.  This is a hack.
          HighlightRange(RB, TokOffs, TokEnd, BufferStart, 
              $("<span class='directive'>"), $("</span>"));
          
          // Don't skip the next token.
          continue;
        }
      }
      
      L.LexFromRawLexer(Tok);
    }
  } finally {
    if (L != null) { L.$destroy(); }
  }
}


/// HighlightMacros - This uses the macro table state from the end of the
/// file, to reexpand macros and insert (into the HTML) information about the
/// macro expansions.  This won't be perfectly perfect, but it will be
/// reasonably close.

/// HighlightMacros - This uses the macro table state from the end of the
/// file, to re-expand macros and insert (into the HTML) information about the
/// macro expansions.  This won't be perfectly perfect, but it will be
/// reasonably close.
//<editor-fold defaultstate="collapsed" desc="clang::html::HighlightMacros">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use SmallVectorToken specialization*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 446,
 FQN="clang::html::HighlightMacros", NM="_ZN5clang4html15HighlightMacrosERNS_8RewriterENS_6FileIDERKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZN5clang4html15HighlightMacrosERNS_8RewriterENS_6FileIDERKNS_12PreprocessorE")
//</editor-fold>
public static void HighlightMacros(Rewriter /*&*/ R, FileID FID, /*const*/ Preprocessor /*&*/ PP) {
  SmallVectorToken TokenStream = null;
  Lexer L = null;
  DiagnosticsEngine TmpDiags = null;
  try {
    // Re-lex the raw token stream into a token buffer.
    /*const*/ SourceManager /*&*/ SM = PP.getSourceManager();
    TokenStream/*J*/= new SmallVectorToken(16, /*PERF: new Token()*/(Token)null);
    
    /*const*/ MemoryBuffer /*P*/ FromFile = SM.getBuffer(/*NO_COPY*/FID);
    L/*J*/= new Lexer(/*NO_COPY*/FID, FromFile, SM, PP.getLangOpts());
    
    // Lex all the tokens in raw mode, to avoid entering #includes or expanding
    // macros.
    while (true) {
      Token Tok/*J*/= new Token();
      L.LexFromRawLexer(Tok);
      
      // If this is a # at the start of a line, discard it from the token stream.
      // We don't want the re-preprocess step to see #defines, #includes or other
      // preprocessor directives.
      if (Tok.is(tok.TokenKind.hash) && Tok.isAtStartOfLine()) {
        continue;
      }
      
      // If this is a ## token, change its kind to unknown so that repreprocessing
      // it will not produce an error.
      if (Tok.is(tok.TokenKind.hashhash)) {
        Tok.setKind(tok.TokenKind.unknown);
      }
      
      // If this raw token is an identifier, the raw lexer won't have looked up
      // the corresponding identifier info for it.  Do this now so that it will be
      // macro expanded when we re-preprocess it.
      if (Tok.is(tok.TokenKind.raw_identifier)) {
        PP.LookUpIdentifierInfo(Tok);
      }
      
      TokenStream.push_back_T$C$R(Tok);
      if (Tok.is(tok.TokenKind.eof)) {
        break;
      }
    }
    
    // Temporarily change the diagnostics object so that we ignore any generated
    // diagnostics from this pass.
    TmpDiags/*J*/= new DiagnosticsEngine(PP.getDiagnostics().getDiagnosticIDs(), 
        /*AddrOf*/PP.getDiagnostics().getDiagnosticOptions(), 
        new IgnoringDiagConsumer());
    
    // FIXME: This is a huge hack; we reuse the input preprocessor because we want
    // its state, but we aren't actually changing it (we hope). This should really
    // construct a copy of the preprocessor.
    Preprocessor /*&*/ TmpPP = ((/*const_cast*/Preprocessor /*&*/ )(PP));
    DiagnosticsEngine /*P*/ OldDiags = /*AddrOf*/TmpPP.getDiagnostics();
    TmpPP.setDiagnostics(TmpDiags);
    
    // Inform the preprocessor that we don't want comments.
    TmpPP.SetCommentRetentionState(false, false);
    
    // We don't want pragmas either. Although we filtered out #pragma, removing
    // _Pragma and __pragma is much harder.
    boolean PragmasPreviouslyEnabled = TmpPP.getPragmasEnabled();
    TmpPP.setPragmasEnabled(false);
    
    // Enter the tokens we just lexed.  This will cause them to be macro expanded
    // but won't enter sub-files (because we removed #'s).
    TmpPP.EnterTokenStream(new ArrayRefToken(TokenStream), false);
    
    TokenConcatenation ConcatInfo/*J*/= new TokenConcatenation(TmpPP);
    
    // Lex all the tokens.
    Token Tok/*J*/= new Token();
    TmpPP.Lex(Tok);
    while (Tok.isNot(tok.TokenKind.eof)) {
      // Ignore non-macro tokens.
      if (!Tok.getLocation().isMacroID()) {
        TmpPP.Lex(Tok);
        continue;
      }
      
      // Okay, we have the first token of a macro expansion: highlight the
      // expansion by inserting a start tag before the macro expansion and
      // end tag after it.
      std.pair<SourceLocation, SourceLocation> LLoc = SM.getExpansionRange(Tok.getLocation());
      
      // Ignore tokens whose instantiation location was not the main file.
      if (SM.getFileID(/*NO_COPY*/LLoc.first).$noteq(FID)) {
        TmpPP.Lex(Tok);
        continue;
      }
      assert (SM.getFileID(/*NO_COPY*/LLoc.second).$eq(FID)) : "Start and end of expansion must be in the same ultimate file!";
      
      std.string Expansion = EscapeText(new StringRef(TmpPP.getSpelling(Tok)));
      /*uint*/int LineLen = Expansion.size();
      
      Token PrevPrevTok/*J*/= new Token();
      Token PrevTok = new Token(Tok);
      // Okay, eat this token, getting the next one.
      TmpPP.Lex(Tok);
      
      // Skip all the rest of the tokens that are part of this macro
      // instantiation.  It would be really nice to pop up a window with all the
      // spelling of the tokens or something.
      while (!Tok.is(tok.TokenKind.eof)
         && $eq_SourceLocation$C(SM.getExpansionLoc(Tok.getLocation()), LLoc.first)) {
        // Insert a newline if the macro expansion is getting large.
        if ($greater_uint(LineLen, 60)) {
          Expansion.$addassign_T$C$P(/*KEEP_STR*/"<br>");
          LineLen = 0;
        }
        
        LineLen -= Expansion.size();
        
        // If the tokens were already space separated, or if they must be to avoid
        // them being implicitly pasted, add a space between them.
        if (Tok.hasLeadingSpace()
           || ConcatInfo.AvoidConcat(PrevPrevTok, PrevTok, Tok)) {
          Expansion.$addassign_T($$SPACE);
        }
        
        // Escape any special characters in the token text.
        Expansion.$addassign(EscapeText(new StringRef(TmpPP.getSpelling(Tok))));
        LineLen += Expansion.size();
        
        PrevPrevTok.$assign(PrevTok);
        PrevTok.$assign(Tok);
        TmpPP.Lex(Tok);
      }
      
      // Insert the expansion as the end tag, so that multi-line macros all get
      // highlighted.
      Expansion.$assignMove($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"<span class='expansion'>", Expansion), /*KEEP_STR*/"</span></span>"));
      
      HighlightRange(R, new SourceLocation(LLoc.first), new SourceLocation(LLoc.second), 
          $("<span class='macro'>"), Expansion.c_str());
    }
    
    // Restore the preprocessor's old state.
    TmpPP.setDiagnostics(/*Deref*/OldDiags);
    TmpPP.setPragmasEnabled(PragmasPreviouslyEnabled);
  } finally {
    if (TmpDiags != null) { TmpDiags.$destroy(); }
    if (L != null) { L.$destroy(); }
    if (TokenStream != null) { TokenStream.$destroy(); }
  }
}

} // END OF class html
