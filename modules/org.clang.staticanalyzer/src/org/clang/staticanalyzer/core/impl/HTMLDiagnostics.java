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

package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.lex.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.rewrite.core.RewriteBuffer;
import org.clang.rewrite.core.Rewriter;
import org.clang.rewrite.core.html;
import org.clang.staticanalyzer.core.StaticanalyzerClangGlobals;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 42,
 FQN="(anonymous namespace)::HTMLDiagnostics", NM="_ZN12_GLOBAL__N_115HTMLDiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN12_GLOBAL__N_115HTMLDiagnosticsE")
//</editor-fold>
public class HTMLDiagnostics extends /*public*/ PathDiagnosticConsumer implements Destructors.ClassWithDestructor {
  private std.string Directory;
  private boolean createdDir;
  private boolean noDir;
  private final /*const*/ Preprocessor /*&*/ PP;
  private final AnalyzerOptions /*&*/ AnalyzerOpts;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics::HTMLDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 76,
   FQN="(anonymous namespace)::HTMLDiagnostics::HTMLDiagnostics", NM="_ZN12_GLOBAL__N_115HTMLDiagnosticsC1ERN5clang15AnalyzerOptionsERKSsRKNS1_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN12_GLOBAL__N_115HTMLDiagnosticsC1ERN5clang15AnalyzerOptionsERKSsRKNS1_12PreprocessorE")
  //</editor-fold>
  public HTMLDiagnostics(final AnalyzerOptions /*&*/ AnalyzerOpts, 
      final /*const*/std.string/*&*/ prefix, 
      final /*const*/ Preprocessor /*&*/ pp) {
    // : PathDiagnosticConsumer(), Directory(prefix), createdDir(false), noDir(false), PP(pp), AnalyzerOpts(AnalyzerOpts) 
    //START JInit
    super();
    this.Directory = new std.string(prefix);
    this.createdDir = false;
    this.noDir = false;
    this./*&*/PP=/*&*/pp;
    this./*&*/AnalyzerOpts=/*&*/AnalyzerOpts;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics::~HTMLDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 50,
   FQN="(anonymous namespace)::HTMLDiagnostics::~HTMLDiagnostics", NM="_ZN12_GLOBAL__N_115HTMLDiagnosticsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN12_GLOBAL__N_115HTMLDiagnosticsD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    FlushDiagnostics((PathDiagnosticConsumer.FilesMade /*P*/ )null);
    //START JDestroy
    Directory.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  
  //===----------------------------------------------------------------------===//
  // Report processing.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics::FlushDiagnosticsImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 93,
   FQN="(anonymous namespace)::HTMLDiagnostics::FlushDiagnosticsImpl", NM="_ZN12_GLOBAL__N_115HTMLDiagnostics20FlushDiagnosticsImplERSt6vectorIPKN5clang4ento14PathDiagnosticESaIS6_EEPNS3_22PathDiagnosticConsumer9FilesMadeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN12_GLOBAL__N_115HTMLDiagnostics20FlushDiagnosticsImplERSt6vectorIPKN5clang4ento14PathDiagnosticESaIS6_EEPNS3_22PathDiagnosticConsumer9FilesMadeE")
  //</editor-fold>
  @Override public void FlushDiagnosticsImpl(final std.vector</*const*/ PathDiagnostic /*P*/ > /*&*/ Diags, 
                      PathDiagnosticConsumer.FilesMade /*P*/ filesMade)/* override*/ {
    for (std.vector.iterator</*const*/ PathDiagnostic /*P*/ > it = Diags.begin(), 
        et = Diags.end(); $noteq___normal_iterator$C(it, et); it.$preInc()) {
      ReportDiag($Deref(it.$star()), filesMade);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 55,
   FQN="(anonymous namespace)::HTMLDiagnostics::getName", NM="_ZNK12_GLOBAL__N_115HTMLDiagnostics7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZNK12_GLOBAL__N_115HTMLDiagnostics7getNameEv")
  //</editor-fold>
  @Override public StringRef getName() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/"HTMLDiagnostics");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics::ProcessMacroPiece">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 570,
   FQN="(anonymous namespace)::HTMLDiagnostics::ProcessMacroPiece", NM="_ZN12_GLOBAL__N_115HTMLDiagnostics17ProcessMacroPieceERN4llvm11raw_ostreamERKN5clang4ento24PathDiagnosticMacroPieceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN12_GLOBAL__N_115HTMLDiagnostics17ProcessMacroPieceERN4llvm11raw_ostreamERKN5clang4ento24PathDiagnosticMacroPieceEj")
  //</editor-fold>
  public /*uint*/int ProcessMacroPiece(final raw_ostream /*&*/ os, 
                   final /*const*/ PathDiagnosticMacroPiece /*&*/ P, 
                   /*uint*/int num) {
    
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = P.subPieces.begin$Const(), E = P.subPieces.end$Const();
         I.$noteq(E); I.$preInc()) {
      {
        
        /*const*/ PathDiagnosticMacroPiece /*P*/ MP = dyn_cast_PathDiagnosticMacroPiece(I.$star().$arrow());
        if ((MP != null)) {
          num = ProcessMacroPiece(os, $Deref(MP), num);
          continue;
        }
      }
      {
        
        PathDiagnosticEventPiece /*P*/ EP = dyn_cast_PathDiagnosticEventPiece(I.$star().$arrow());
        if ((EP != null)) {
          os.$out(/*KEEP_STR*/"<div class=\"msg msgEvent\" style=\"width:94%; margin-left:5px\"><table class=\"msgT\"><tr><td valign=\"top\"><div class=\"PathIndex PathIndexEvent\">");
          HTMLDiagnosticsStatics.EmitAlphaCounter(os, num++);
          os.$out(/*KEEP_STR*/"</div></td><td valign=\"top\">").$out(
              html.EscapeText(EP.getString())
          ).$out(
              /*KEEP_STR*/"</td></tr></table></div>\n"
          );
        }
      }
    }
    
    return num;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics::HandlePiece">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 347,
   FQN="(anonymous namespace)::HTMLDiagnostics::HandlePiece", NM="_ZN12_GLOBAL__N_115HTMLDiagnostics11HandlePieceERN5clang8RewriterENS1_6FileIDERKNS1_4ento19PathDiagnosticPieceEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN12_GLOBAL__N_115HTMLDiagnostics11HandlePieceERN5clang8RewriterENS1_6FileIDERKNS1_4ento19PathDiagnosticPieceEjj")
  //</editor-fold>
  public void HandlePiece(final Rewriter /*&*/ R, FileID BugFileID, 
             final /*const*/ PathDiagnosticPiece /*&*/ P, 
             /*uint*/int num, /*uint*/int max) {
    raw_string_ostream os = null;
    try {
      
      // For now, just draw a box above the line in question, and emit the
      // warning.
      FullSourceLoc Pos = P.getLocation().asLocation();
      if (!Pos.isValid()) {
        return;
      }
      
      final SourceManager /*&*/ SM = R.getSourceMgr();
      assert ($AddrOf(Pos.getManager()) == $AddrOf(SM)) : "SourceManagers are different!";
      std.pairTypeUInt<FileID> LPosInfo = SM.getDecomposedExpansionLoc(/*NO_COPY*/Pos);
      if (LPosInfo.first.$noteq(BugFileID)) {
        return;
      }
      
      /*const*/ MemoryBuffer /*P*/ Buf = SM.getBuffer(/*NO_COPY*/LPosInfo.first);
      /*const*/char$ptr/*char P*/ FileStart = $tryClone(Buf.getBufferStart());
      
      // Compute the column number.  Rewind from the current position to the start
      // of the line.
      /*uint*/int ColNo = SM.getColumnNumber(/*NO_COPY*/LPosInfo.first, LPosInfo.second);
      /*const*/char$ptr/*char P*/ TokInstantiationPtr = $tryClone(Pos.getExpansionLoc().getCharacterData());
      /*const*/char$ptr/*char P*/ LineStart = $tryClone(TokInstantiationPtr.$sub(ColNo));
      
      // Compute LineEnd.
      /*const*/char$ptr/*char P*/ LineEnd = $tryClone(TokInstantiationPtr);
      /*const*/char$ptr/*char P*/ FileEnd = $tryClone(Buf.getBufferEnd());
      while (LineEnd.$star() != $$LF && $noteq_ptr(LineEnd, FileEnd)) {
        LineEnd.$preInc();
      }
      
      // Compute the margin offset by counting tabs and non-tabs.
      /*uint*/int PosNo = 0;
      for (/*const*/char$ptr/*char P*/ c = $tryClone(LineStart); $noteq_ptr(c, TokInstantiationPtr); c.$preInc())  {
        PosNo += c.$star() == $$TAB ? 8 : 1;
      }
      
      // Create the html for the message.
      /*const*/char$ptr/*char P*/ Kind = null;
      switch (P.getKind()) {
       case Call:
        throw new llvm_unreachable("Calls should already be handled");
       case Event:
        Kind = $("Event");
        break;
       case ControlFlow:
        Kind = $("Control");
        break;
       case Macro:
        // Setting Kind to "Control" is intentional.
        Kind = $("Control");
        break;
      }
      
      std.string sbuf/*J*/= new std.string();
      os/*J*/= new raw_string_ostream(sbuf);
      
      os.$out(/*KEEP_STR*/"\n<tr><td class=\"num\"></td><td class=\"line\"><div id=\"");
      if (num == max) {
        os.$out(/*KEEP_STR*/"EndPath");
      } else {
        os.$out(/*KEEP_STR*/"Path").$out_uint(num);
      }
      
      os.$out(/*KEEP_STR*/"\" class=\"msg");
      if (Native.$bool(Kind)) {
        os.$out(/*KEEP_STR*/" msg").$out(Kind);
      }
      os.$out(/*KEEP_STR*/"\" style=\"margin-left:").$out_uint(PosNo).$out(/*KEEP_STR*/"ex");
      
      // Output a maximum size.
      if (!isa_PathDiagnosticMacroPiece(P)) {
        // Get the string and determining its maximum substring.
        final /*const*/ StringRef /*&*/ Msg = P.getString();
        /*uint*/int max_token = 0;
        /*uint*/int cnt = 0;
        /*uint*/int len = Msg.size();
        
        // JAVA: iterate string
        std.string $Msg$string = Msg.$string();
        for (int i = 0; i < $Msg$string.size(); i++) {
          byte C = $Msg$string.$at(i);
          switch (C) {
           default:
            ++cnt;
            continue;
           case ' ':
           case '\t':
           case '\n':
            if ($greater_uint(cnt, max_token)) {
              max_token = cnt;
            }
            cnt = 0;
          }
        }
        if ($greater_uint(cnt, max_token)) {
          max_token = cnt;
        }
        
        // Determine the approximate size of the message bubble in em.
        /*uint*/int em;
        /*const*//*uint*/int max_line = 120;
        if ($greatereq_uint(max_token, max_line)) {
          em = $div_uint(max_token, 2);
        } else {
          /*uint*/int characters = max_line;
          /*uint*/int lines = $div_uint(len, max_line);
          if ($greater_uint(lines, 0)) {
            for (; $greater_uint(characters, max_token); --characters)  {
              if ($greater_uint($div_uint(len, characters), lines)) {
                ++characters;
                break;
              }
            }
          }
          
          em = $div_uint(characters, 2);
        }
        if ($less_uint(em, $div_uint(max_line, 2))) {
          os.$out(/*KEEP_STR*/"; max-width:").$out_uint(em).$out(/*KEEP_STR*/"em");
        }
      } else {
        os.$out(/*KEEP_STR*/"; max-width:100em");
      }
      
      os.$out(/*KEEP_STR*/"\">");
      if ($greater_uint(max, 1)) {
        os.$out(/*KEEP_STR*/"<table class=\"msgT\"><tr><td valign=\"top\">");
        os.$out(/*KEEP_STR*/"<div class=\"PathIndex");
        if (Native.$bool(Kind)) {
          os.$out(/*KEEP_STR*/" PathIndex").$out(Kind);
        }
        os.$out(/*KEEP_STR*/"\">").$out_uint(num).$out(/*KEEP_STR*/"</div>");
        if ($greater_uint(num, 1)) {
          os.$out(/*KEEP_STR*/"</td><td><div class=\"PathNav\"><a href=\"#Path").$out_uint(
              (num - 1)
          ).$out(
              /*KEEP_STR*/"\" title=\"Previous event ("
          ).$out_uint(
              (num - 1)
          ).$out(
              /*KEEP_STR*/")\">&#x2190;</a></div></td>"
          );
        }
        
        os.$out(/*KEEP_STR*/"</td><td>");
      }
      {
        
        /*const*/ PathDiagnosticMacroPiece /*P*/ MP = dyn_cast_PathDiagnosticMacroPiece($AddrOf(P));
        if ((MP != null)) {
          
          os.$out(/*KEEP_STR*/"Within the expansion of the macro '");
          {
            Lexer rawLexer = null;
            try {
              FullSourceLoc L = MP.getLocation().asLocation().getExpansionLoc();
              assert (L.isFileID());
              StringRef BufferInfo = L.getBufferData();
              std.pairTypeUInt<FileID> LocInfo = L.getDecomposedLoc();
              /*const*/char$ptr/*char P*/ MacroName = $tryClone(BufferInfo.data().$add(LocInfo.second));
              rawLexer/*J*/= new Lexer(SM.getLocForStartOfFile(/*NO_COPY*/LocInfo.first), PP.getLangOpts(), 
                  BufferInfo.begin(), MacroName, BufferInfo.end());
              
              Token TheTok/*J*/= new Token();
              rawLexer.LexFromRawLexer(TheTok);
              for (/*uint*/int i = 0, n = TheTok.getLength(); $less_uint(i, n); ++i)  {
                os.$out_char(MacroName.$at(i));
              }
            } finally {
              if (rawLexer != null) { rawLexer.$destroy(); }
            }
          }
          
          os.$out(/*KEEP_STR*/"':\n");
          if ($greater_uint(max, 1)) {
            os.$out(/*KEEP_STR*/"</td>");
            if ($less_uint(num, max)) {
              os.$out(/*KEEP_STR*/"<td><div class=\"PathNav\"><a href=\"#");
              if (num == max - 1) {
                os.$out(/*KEEP_STR*/"EndPath");
              } else {
                os.$out(/*KEEP_STR*/"Path").$out_uint((num + 1));
              }
              os.$out(/*KEEP_STR*/"\" title=\"Next event (").$out_uint(
                  (num + 1)
              ).$out(
                  /*KEEP_STR*/")\">&#x2192;</a></div></td>"
              );
            }
            
            os.$out(/*KEEP_STR*/"</tr></table>");
          }
          
          // Within a macro piece.  Write out each event.
          ProcessMacroPiece(os, $Deref(MP), 0);
        } else {
          os.$out(html.EscapeText(P.getString()));
          if ($greater_uint(max, 1)) {
            os.$out(/*KEEP_STR*/"</td>");
            if ($less_uint(num, max)) {
              os.$out(/*KEEP_STR*/"<td><div class=\"PathNav\"><a href=\"#");
              if (num == max - 1) {
                os.$out(/*KEEP_STR*/"EndPath");
              } else {
                os.$out(/*KEEP_STR*/"Path").$out_uint((num + 1));
              }
              os.$out(/*KEEP_STR*/"\" title=\"Next event (").$out_uint(
                  (num + 1)
              ).$out(
                  /*KEEP_STR*/")\">&#x2192;</a></div></td>"
              );
            }
            
            os.$out(/*KEEP_STR*/"</tr></table>");
          }
        }
      }
      
      os.$out(/*KEEP_STR*/"</div></td></tr>");
      
      // Insert the new html.
      /*uint*/int DisplayPos = LineEnd.$sub(FileStart);
      SourceLocation Loc = SM.getLocForStartOfFile(/*NO_COPY*/LPosInfo.first).getLocWithOffset(DisplayPos);
      
      R.InsertTextBefore(new SourceLocation(Loc), new StringRef(os.str()));
      
      // Now highlight the ranges.
      ArrayRef<SourceRange> Ranges = P.getRanges();
      for (type$ptr<SourceRange> I = $tryClone(Ranges.begin()), 
          /*P*/ E = $tryClone(Ranges.end()); $noteq_ptr(I, E); I.$preInc()) {
        HighlightRange(R, new FileID(LPosInfo.first), new SourceRange(I.$star()));
      }
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics::HighlightRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 598,
   FQN="(anonymous namespace)::HTMLDiagnostics::HighlightRange", NM="_ZN12_GLOBAL__N_115HTMLDiagnostics14HighlightRangeERN5clang8RewriterENS1_6FileIDENS1_11SourceRangeEPKcS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN12_GLOBAL__N_115HTMLDiagnostics14HighlightRangeERN5clang8RewriterENS1_6FileIDENS1_11SourceRangeEPKcS7_")
  //</editor-fold>
  public void HighlightRange(final Rewriter /*&*/ R, FileID BugFileID, 
                SourceRange Range) {
    HighlightRange(R, BugFileID, 
                Range, 
                $("<span class=\"mrange\">"), 
                $("</span>"));
  }
  public void HighlightRange(final Rewriter /*&*/ R, FileID BugFileID, 
                SourceRange Range, 
                /*const*/char$ptr/*char P*/ HighlightStart/*= "<span class=\"mrange\">"*/) {
    HighlightRange(R, BugFileID, 
                Range, 
                HighlightStart, 
                $("</span>"));
  }
  public void HighlightRange(final Rewriter /*&*/ R, FileID BugFileID, 
                SourceRange Range, 
                /*const*/char$ptr/*char P*/ HighlightStart/*= "<span class=\"mrange\">"*/, 
                /*const*/char$ptr/*char P*/ HighlightEnd/*= "</span>"*/) {
    final SourceManager /*&*/ SM = R.getSourceMgr();
    final /*const*/ LangOptions /*&*/ LangOpts = R.getLangOpts();
    
    SourceLocation InstantiationStart = SM.getExpansionLoc(Range.getBegin());
    /*uint*/int StartLineNo = SM.getExpansionLineNumber(/*NO_COPY*/InstantiationStart);
    
    SourceLocation InstantiationEnd = SM.getExpansionLoc(Range.getEnd());
    /*uint*/int EndLineNo = SM.getExpansionLineNumber(/*NO_COPY*/InstantiationEnd);
    if ($less_uint(EndLineNo, StartLineNo)) {
      return;
    }
    if (SM.getFileID(/*NO_COPY*/InstantiationStart).$noteq(BugFileID)
       || SM.getFileID(/*NO_COPY*/InstantiationEnd).$noteq(BugFileID)) {
      return;
    }
    
    // Compute the column number of the end.
    /*uint*/int EndColNo = SM.getExpansionColumnNumber(/*NO_COPY*/InstantiationEnd);
    /*uint*/int OldEndColNo = EndColNo;
    if ((EndColNo != 0)) {
      // Add in the length of the token, so that we cover multi-char tokens.
      EndColNo += Lexer.MeasureTokenLength(Range.getEnd(), SM, LangOpts) - 1;
    }
    
    // Highlight the range.  Make the span tag the outermost tag for the
    // selected range.
    SourceLocation E = InstantiationEnd.getLocWithOffset(EndColNo - OldEndColNo);
    
    html.HighlightRange(R, new SourceLocation(InstantiationStart), new SourceLocation(E), HighlightStart, HighlightEnd);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HTMLDiagnostics::ReportDiag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp", line = 102,
   FQN="(anonymous namespace)::HTMLDiagnostics::ReportDiag", NM="_ZN12_GLOBAL__N_115HTMLDiagnostics10ReportDiagERKN5clang4ento14PathDiagnosticEPNS2_22PathDiagnosticConsumer9FilesMadeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/HTMLDiagnostics.cpp -nm=_ZN12_GLOBAL__N_115HTMLDiagnostics10ReportDiagERKN5clang4ento14PathDiagnosticEPNS2_22PathDiagnosticConsumer9FilesMadeE")
  //</editor-fold>
  public void ReportDiag(final /*const*/ PathDiagnostic /*&*/ D, 
            PathDiagnosticConsumer.FilesMade /*P*/ filesMade) {
    PathPieces _path = null;
    Rewriter R = null;
    raw_fd_ostream os = null;
    try {
      
      // Create the HTML directory if it is missing.
      if (!createdDir) {
        createdDir = true;
        {
          std.error_code ec = fs.create_directories(new Twine(Directory));
          if (ec.$bool()) {
            llvm.errs().$out(/*KEEP_STR*/"warning: could not create directory '").$out(
                Directory
            ).$out(/*KEEP_STR*/"': ").$out(ec.message()).$out_char($$LF);
            
            noDir = true;
            
            return;
          }
        }
      }
      if (noDir) {
        return;
      }
      
      // First flatten out the entire path to make it easier to use.
      _path = D._path.flatten(/*ShouldFlattenMacros=*/ false);
      
      // The path as already been prechecked that all parts of the path are
      // from the same file and that it is non-empty.
      final /*const*/ SourceManager /*&*/ SMgr = _path.front().$arrow().getLocation().getManager();
      assert (!_path.empty());
      FileID FID = _path.front().$arrow().getLocation().asLocation().getExpansionLoc().getFileID();
      assert (FID.isValid());
      
      // Create a new rewriter to generate HTML.
      R/*J*/= new Rewriter(((/*const_cast*/SourceManager /*&*/ )(SMgr)), PP.getLangOpts());
      
      // Get the function/method name
      SmallString/*<128>*/ declName/*J*/= new SmallString/*<128>*/(128, new StringRef(/*KEEP_STR*/$unknown));
      int offsetDecl = 0;
      {
        /*const*/ Decl /*P*/ DeclWithIssue = D.getDeclWithIssue();
        if ((DeclWithIssue != null)) {
          {
            /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(DeclWithIssue);
            if ((ND != null)) {
              declName.$assign(new StringRef(ND.getDeclName().getAsString()));
            }
          }
          {
            
            /*const*/ Stmt /*P*/ Body = DeclWithIssue.getBody();
            if ((Body != null)) {
              // Retrieve the relative position of the declaration which will be used
              // for the file name
              FullSourceLoc L/*J*/= new FullSourceLoc(SMgr.getExpansionLoc(/*NO_COPY*/_path.back().$arrow().getLocation().asLocation()), 
                  SMgr);
              FullSourceLoc FunL/*J*/= new FullSourceLoc(SMgr.getExpansionLoc(Body.getLocStart()), SMgr);
              offsetDecl = L.getExpansionLineNumber() - FunL.getExpansionLineNumber();
            }
          }
        }
      }
      
      // Process the path.
      /*uint*/int n = _path.size();
      /*uint*/int max = n;
      
      for (std.reverse_iterator</*const*/ IntrusiveRefCntPtr<PathDiagnosticPiece> /*&*/ > I = new std.reverse_iterator</*const*/ IntrusiveRefCntPtr<PathDiagnosticPiece> /*&*/ >(JD$Reverse_iterator$_Iter$C.INSTANCE, _path.rbegin()), 
          E = new std.reverse_iterator</*const*/ IntrusiveRefCntPtr<PathDiagnosticPiece> /*&*/ >(JD$Reverse_iterator$_Iter$C.INSTANCE, _path.rend());
           $noteq_reverse_iterator$C(I, E); I.$preInc() , --n)  {
        HandlePiece(R, new FileID(FID), I.$star().$star(), n, max);
      }
      
      // Add line numbers, header, footer, etc.
      
      // unsigned FID = R.getSourceMgr().getMainFileID();
      html.EscapeText(R, new FileID(FID));
      html.AddLineNumbers(R, new FileID(FID));
      
      // If we have a preprocessor, relex the file and syntax highlight.
      // We might not have a preprocessor if we come from a deserialized AST file,
      // for example.
      html.SyntaxHighlight(R, new FileID(FID), PP);
      html.HighlightMacros(R, new FileID(FID), PP);
      
      // Get the full directory name of the analyzed file.
      /*const*/ FileEntry /*P*/ Entry = SMgr.getFileEntryForID(/*NO_COPY*/FID);
      
      // This is a cludge; basically we want to append either the full
      // working directory if we have no directory information.  This is
      // a work in progress.
      SmallString/*<0>*/ DirName/*J*/= new SmallString/*<0>*/(0);
      if (path.is_relative(new Twine(Entry.getName()))) {
        fs.current_path(DirName);
        DirName.$addassign($$SLASH);
      }
      
      int LineNumber = _path.back().$arrow().getLocation().asLocation().getExpansionLineNumber();
      int ColumnNumber = _path.back().$arrow().getLocation().asLocation().getExpansionColumnNumber();
      {
        raw_string_ostream os$1 = null;
        try {
          std.string s/*J*/= new std.string();
          os$1/*J*/= new raw_string_ostream(s);
          
          os$1.$out(/*KEEP_STR*/"<!-- REPORTHEADER -->\n").$out(
              /*KEEP_STR*/"<h3>Bug Summary</h3>\n<table class=\"simpletable\">\n<tr><td class=\"rowname\">File:</td><td>"
          ).$out(
              html.EscapeText(DirName.$StringRef())
          ).$out(
              html.EscapeText(new StringRef(Entry.getName()))
          ).$out(
              /*KEEP_STR*/"</td></tr>\n<tr><td class=\"rowname\">Location:</td><td><a href=\"#EndPath\">line "
          ).$out_int(
              LineNumber
          ).$out(
              /*KEEP_STR*/", column "
          ).$out_int(
              ColumnNumber
          ).$out(
              /*KEEP_STR*/"</a></td></tr>\n<tr><td class=\"rowname\">Description:</td><td>"
          ).$out(
              D.getVerboseDescription()
          ).$out(/*KEEP_STR*/"</td></tr>\n");
          
          // Output any other meta data.
          for (std.deque.iterator<std.string> I = D.meta_begin(), E = D.meta_end();
               $noteq__Deque_iterator$_Tp$_Ref$_Ptr$C(I, E); I.$preInc()) {
            os$1.$out(/*KEEP_STR*/"<tr><td></td><td>").$out(html.EscapeText(new StringRef(I.$star()))).$out(/*KEEP_STR*/"</td></tr>\n");
          }
          
          os$1.$out(/*KEEP_STR*/"</table>\n<!-- REPORTSUMMARYEXTRA -->\n<h3>Annotated Source Code</h3>\n");
          
          R.InsertTextBefore(SMgr.getLocForStartOfFile(/*NO_COPY*/FID), new StringRef(os$1.str()));
        } finally {
          if (os$1 != null) { os$1.$destroy(); }
        }
      }
      {
        raw_string_ostream os$1 = null;
        try {
          std.string s/*J*/= new std.string();
          os$1/*J*/= new raw_string_ostream(s);
          
          StringRef BugDesc = D.getVerboseDescription();
          if (!BugDesc.empty()) {
            os$1.$out(/*KEEP_STR*/"\n<!-- BUGDESC ").$out(/*NO_COPY*/BugDesc).$out(/*KEEP_STR*/" -->\n");
          }
          
          StringRef BugType = D.getBugType();
          if (!BugType.empty()) {
            os$1.$out(/*KEEP_STR*/"\n<!-- BUGTYPE ").$out(/*NO_COPY*/BugType).$out(/*KEEP_STR*/" -->\n");
          }
          
          PathDiagnosticLocation UPDLoc = D.getUniqueingLoc();
          FullSourceLoc L/*J*/= new FullSourceLoc(SMgr.getExpansionLoc(/*NO_COPY*/UPDLoc.isValid() ? UPDLoc.asLocation() : D.getLocation().asLocation()), 
              SMgr);
          /*const*/ Decl /*P*/ DeclWithIssue = D.getDeclWithIssue();
          
          StringRef BugCategory = D.getCategory();
          if (!BugCategory.empty()) {
            os$1.$out(/*KEEP_STR*/"\n<!-- BUGCATEGORY ").$out(/*NO_COPY*/BugCategory).$out(/*KEEP_STR*/" -->\n");
          }
          
          os$1.$out(/*KEEP_STR*/"\n<!-- BUGFILE ").$out(DirName).$out(Entry.getName()).$out(/*KEEP_STR*/" -->\n");
          
          os$1.$out(/*KEEP_STR*/"\n<!-- FILENAME ").$out(path.filename(new StringRef(Entry.getName()))).$out(/*KEEP_STR*/" -->\n");
          
          os$1.$out(/*KEEP_STR*/"\n<!-- FUNCTIONNAME ").$out(declName).$out(/*KEEP_STR*/" -->\n");
          
          os$1.$out(/*KEEP_STR*/"\n<!-- ISSUEHASHCONTENTOFLINEINCONTEXT ").$out(
              StaticanalyzerClangGlobals.GetIssueHash(SMgr, L, D.getCheckName(), D.getBugType(), DeclWithIssue, 
                  PP.getLangOpts())
          ).$out(/*KEEP_STR*/" -->\n");
          
          os$1.$out(/*KEEP_STR*/"\n<!-- BUGLINE ").$out_int(
              LineNumber
          ).$out(
              /*KEEP_STR*/" -->\n"
          );
          
          os$1.$out(/*KEEP_STR*/"\n<!-- BUGCOLUMN ").$out_int(
              ColumnNumber
          ).$out(
              /*KEEP_STR*/" -->\n"
          );
          
          os$1.$out(/*KEEP_STR*/"\n<!-- BUGPATHLENGTH ").$out_uint(_path.size()).$out(/*KEEP_STR*/" -->\n");
          
          // Mark the end of the tags.
          os$1.$out(/*KEEP_STR*/"\n<!-- BUGMETAEND -->\n");
          
          // Insert the text.
          R.InsertTextBefore(SMgr.getLocForStartOfFile(/*NO_COPY*/FID), new StringRef(os$1.str()));
        } finally {
          if (os$1 != null) { os$1.$destroy(); }
        }
      }
      
      // Add CSS, header, and footer.
      html.AddHeaderFooterInternalBuiltinCSS(R, new FileID(FID), Entry.getName());
      
      // Get the rewrite buffer.
      /*const*/ RewriteBuffer /*P*/ Buf = R.getRewriteBufferFor(new FileID(FID));
      if (!(Buf != null)) {
        llvm.errs().$out(/*KEEP_STR*/"warning: no diagnostics generated for main file.\n");
        return;
      }
      
      // Create a path for the target HTML file.
      int$ref FD = create_int$ref();
      SmallString/*<128>*/ Model/*J*/= new SmallString/*<128>*/(128);
      SmallString/*<128>*/ ResultPath/*J*/= new SmallString/*<128>*/(128);
      if (!AnalyzerOpts.shouldWriteStableReportFilename()) {
        path.append(Model, new Twine(Directory), new Twine(/*KEEP_STR*/"report-%%%%%%.html"));
        {
          std.error_code EC = fs.make_absolute(Model);
          if (EC.$bool()) {
            llvm.errs().$out(/*KEEP_STR*/"warning: could not make '").$out(Model).$out(
                /*KEEP_STR*/"' absolute: "
            ).$out(EC.message()).$out_char($$LF);
            return;
          }
        }
        {
          std.error_code EC = fs.createUniqueFile(new Twine(Model), FD, ResultPath);
          if (EC.$bool()) {
            llvm.errs().$out(/*KEEP_STR*/"warning: could not create file in '").$out(Directory).$out(
                /*KEEP_STR*/"': "
            ).$out(EC.message()).$out_char($$LF);
            return;
          }
        }
      } else {
        int i = 1;
        std.error_code EC/*J*/= new std.error_code();
        do {
         org.clank.java.io.basic_stringstream filename = null;
          try {
            // Find a filename which is not already used
            filename/*J*/= new org.clank.java.io.basic_stringstream();
            Model.$assign(/*STRINGREF_STR*/"");
            $out_os_char$ptr$C($out_os_char$ptr$C($out_os_char$ptr$C($out_os_char$ptr$C($out_os_char$ptr$C($out_os_string$C(org.clank.java.io.$out_os_char$ptr$C(filename, /*KEEP_STR*/"report-"), 
                                    path.filename(new StringRef(Entry.getName())).str()), 
                                /*KEEP_STR*/"-"), declName.c_str()), 
                        /*KEEP_STR*/"-").$out_int(offsetDecl), 
                    /*KEEP_STR*/"-").$out_int(i), /*KEEP_STR*/".html");
            path.append(Model, new Twine(Directory), 
                new Twine(filename.str()));
            EC.$assignMove(fs.openFileForWrite(new Twine(Model), 
                    FD, 
                    org.llvm.support.sys.fs.$bitor_OpenFlags(/*KEEP_ENUM*/fs.OpenFlags.F_RW, 
                        /*KEEP_ENUM*/fs.OpenFlags.F_Excl)));
            if (EC.$bool() && org.clank.java.std_errors.$noteq_error_code$C(EC, new std.error_code(errc.file_exists))) {
              llvm.errs().$out(/*KEEP_STR*/"warning: could not create file '").$out(Model).$out(
                  /*KEEP_STR*/"': "
              ).$out(EC.message()).$out_char($$LF);
              return;
            }
            i++;
          } finally {
            if (filename != null) { filename.$destroy(); }
          }
        } while (EC.$bool());
      }
      
      os/*J*/= new raw_fd_ostream(FD.$deref(), true);
      if ((filesMade != null)) {
        filesMade.addDiagnostic(D, getName(), 
            path.filename(ResultPath.$StringRef()));
      }

      // Emit the HTML to disk.
      for (org.clang.rewrite.core.RopePieceBTreeIterator I = Buf.begin(), E = Buf.end(); I.$noteq(E); I.$preInc())  {
        os.$out_char(I.$star());
      }
    } finally {
      if (os != null) { os.$destroy(); }
      if (R != null) { R.$destroy(); }
      if (_path != null) { _path.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "Directory=" + Directory // NOI18N
              + ", createdDir=" + createdDir // NOI18N
              + ", noDir=" + noDir // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", AnalyzerOpts=" + AnalyzerOpts // NOI18N
              + super.toString(); // NOI18N
  }
}
