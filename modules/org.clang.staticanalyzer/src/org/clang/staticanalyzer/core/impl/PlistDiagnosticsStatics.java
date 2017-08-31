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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.lex.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.basic.markup.MarkupGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type PlistDiagnosticsStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.impl.PlistDiagnosticsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZL10ReportCallRN4llvm11raw_ostreamERKN5clang4ento23PathDiagnosticCallPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjj;_ZL10ReportDiagRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsE;_ZL11ReportEventRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjjb;_ZL11ReportMacroRN4llvm11raw_ostreamERKN5clang4ento24PathDiagnosticMacroPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjj;_ZL11ReportPieceRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjjbb;_ZL17ReportControlFlowRN4llvm11raw_ostreamERKN5clang4ento30PathDiagnosticControlFlowPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEj; -static-type=PlistDiagnosticsStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class PlistDiagnosticsStatics {

//<editor-fold defaultstate="collapsed" desc="ReportControlFlow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 83,
 FQN="ReportControlFlow", NM="_ZL17ReportControlFlowRN4llvm11raw_ostreamERKN5clang4ento30PathDiagnosticControlFlowPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZL17ReportControlFlowRN4llvm11raw_ostreamERKN5clang4ento30PathDiagnosticControlFlowPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEj")
//</editor-fold>
public static void ReportControlFlow(final raw_ostream /*&*/ o, 
                 final /*const*/ PathDiagnosticControlFlowPiece /*&*/ P, 
                 final /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, 
                 final /*const*/ SourceManager /*&*/ SM, 
                 final /*const*/ LangOptions /*&*/ LangOpts, 
                 /*uint*/int indent) {
  
  Indent(o, indent).$out(/*KEEP_STR*/"<dict>\n");
  ++indent;
  
  Indent(o, indent).$out(/*KEEP_STR*/"<key>kind</key><string>control</string>\n");
  
  // Emit edges.
  Indent(o, indent).$out(/*KEEP_STR*/"<key>edges</key>\n");
  ++indent;
  Indent(o, indent).$out(/*KEEP_STR*/"<array>\n");
  ++indent;
  for (std.vector.iterator</*const*/ PathDiagnosticLocationPair /*P*/ > I = P.begin$Const(), E = P.end$Const();
       $noteq___normal_iterator$C(I, E); I.$preInc()) {
    Indent(o, indent).$out(/*KEEP_STR*/"<dict>\n");
    ++indent;
    
    // Make the ranges of the start and end point self-consistent with adjacent edges
    // by forcing to use only the beginning of the range.  This simplifies the layout
    // logic for clients.
    Indent(o, indent).$out(/*KEEP_STR*/"<key>start</key>\n");
    SourceRange StartEdge/*J*/= new SourceRange(SM.getExpansionLoc(I.$arrow().getStart().asRange().getBegin()));
    EmitRange(o, SM, Lexer.getAsCharRange(/*NO_COPY*/StartEdge, SM, LangOpts), FM, 
        indent + 1);
    
    Indent(o, indent).$out(/*KEEP_STR*/"<key>end</key>\n");
    SourceRange EndEdge/*J*/= new SourceRange(SM.getExpansionLoc(I.$arrow().getEnd().asRange().getBegin()));
    EmitRange(o, SM, Lexer.getAsCharRange(/*NO_COPY*/EndEdge, SM, LangOpts), FM, 
        indent + 1);
    
    --indent;
    Indent(o, indent).$out(/*KEEP_STR*/"</dict>\n");
  }
  --indent;
  Indent(o, indent).$out(/*KEEP_STR*/"</array>\n");
  --indent;
  
  // Output any helper text.
  final /*const*/ StringRef /*&*/ s = P.getString();
  if (!s.empty()) {
    Indent(o, indent).$out(/*KEEP_STR*/"<key>alternate</key>");
    EmitString(o, new StringRef(s)).$out_char($$LF);
  }
  
  --indent;
  Indent(o, indent).$out(/*KEEP_STR*/"</dict>\n");
}

//<editor-fold defaultstate="collapsed" desc="ReportEvent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 137,
 FQN="ReportEvent", NM="_ZL11ReportEventRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZL11ReportEventRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjjb")
//</editor-fold>
public static void ReportEvent(final raw_ostream /*&*/ o, final /*const*/ PathDiagnosticPiece /*&*/ P, 
           final /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, 
           final /*const*/ SourceManager /*&*/ SM, 
           final /*const*/ LangOptions /*&*/ LangOpts, 
           /*uint*/int indent, 
           /*uint*/int depth) {
  ReportEvent(o, P, 
           FM, 
           SM, 
           LangOpts, 
           indent, 
           depth, 
           false);
}
public static void ReportEvent(final raw_ostream /*&*/ o, final /*const*/ PathDiagnosticPiece /*&*/ P, 
           final /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, 
           final /*const*/ SourceManager /*&*/ SM, 
           final /*const*/ LangOptions /*&*/ LangOpts, 
           /*uint*/int indent, 
           /*uint*/int depth, 
           boolean isKeyEvent/*= false*/) {
  
  Indent(o, indent).$out(/*KEEP_STR*/"<dict>\n");
  ++indent;
  
  Indent(o, indent).$out(/*KEEP_STR*/"<key>kind</key><string>event</string>\n");
  if (isKeyEvent) {
    Indent(o, indent).$out(/*KEEP_STR*/"<key>key_event</key><true/>\n");
  }
  
  // Output the location.
  FullSourceLoc L = P.getLocation().asLocation();
  
  Indent(o, indent).$out(/*KEEP_STR*/"<key>location</key>\n");
  EmitLocation(o, SM, new SourceLocation(L), FM, indent);
  
  // Output the ranges (if any).
  ArrayRef<SourceRange> Ranges = P.getRanges();
  if (!Ranges.empty()) {
    Indent(o, indent).$out(/*KEEP_STR*/"<key>ranges</key>\n");
    Indent(o, indent).$out(/*KEEP_STR*/"<array>\n");
    ++indent;
    for (final /*const*/ SourceRange /*&*/ R : Ranges)  {
      EmitRange(o, SM, 
          Lexer.getAsCharRange(SM.getExpansionRange(/*NO_COPY*/R), SM, LangOpts), 
          FM, indent + 1);
    }
    --indent;
    Indent(o, indent).$out(/*KEEP_STR*/"</array>\n");
  }
  
  // Output the call depth.
  Indent(o, indent).$out(/*KEEP_STR*/"<key>depth</key>");
  EmitInteger(o, $uint2long(depth)).$out_char($$LF);
  
  // Output the text.
  assert (!P.getString().empty());
  Indent(o, indent).$out(/*KEEP_STR*/"<key>extended_message</key>\n");
  Indent(o, indent);
  EmitString(o, P.getString()).$out_char($$LF);
  
  // Output the short text.
  // FIXME: Really use a short string.
  Indent(o, indent).$out(/*KEEP_STR*/"<key>message</key>\n");
  Indent(o, indent);
  EmitString(o, P.getString()).$out_char($$LF);
  
  // Finish up.
  --indent;
  Indent(o, indent);
  o.$out(/*KEEP_STR*/"</dict>\n");
}

//<editor-fold defaultstate="collapsed" desc="ReportPiece">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 259,
 FQN="ReportPiece", NM="_ZL11ReportPieceRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjjbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZL11ReportPieceRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjjbb")
//</editor-fold>
public static void ReportPiece(final raw_ostream /*&*/ o, 
           final /*const*/ PathDiagnosticPiece /*&*/ P, 
           final /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, final /*const*/ SourceManager /*&*/ SM, 
           final /*const*/ LangOptions /*&*/ LangOpts, 
           /*uint*/int indent, 
           /*uint*/int depth, 
           boolean includeControlFlow) {
  ReportPiece(o, 
           P, 
           FM, SM, 
           LangOpts, 
           indent, 
           depth, 
           includeControlFlow, 
           false);
}
public static void ReportPiece(final raw_ostream /*&*/ o, 
           final /*const*/ PathDiagnosticPiece /*&*/ P, 
           final /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, final /*const*/ SourceManager /*&*/ SM, 
           final /*const*/ LangOptions /*&*/ LangOpts, 
           /*uint*/int indent, 
           /*uint*/int depth, 
           boolean includeControlFlow, 
           boolean isKeyEvent/*= false*/) {
  switch (P.getKind()) {
   case ControlFlow:
    if (includeControlFlow) {
      ReportControlFlow(o, cast_PathDiagnosticControlFlowPiece(P), FM, SM, 
          LangOpts, indent);
    }
    break;
   case Call:
    ReportCall(o, cast_PathDiagnosticCallPiece(P), FM, SM, LangOpts, 
        indent, depth);
    break;
   case Event:
    ReportEvent(o, cast_PathDiagnosticSpotPiece(P), FM, SM, LangOpts, 
        indent, depth, isKeyEvent);
    break;
   case Macro:
    ReportMacro(o, cast_PathDiagnosticMacroPiece(P), FM, SM, LangOpts, 
        indent, depth);
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="ReportCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 205,
 FQN="ReportCall", NM="_ZL10ReportCallRN4llvm11raw_ostreamERKN5clang4ento23PathDiagnosticCallPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZL10ReportCallRN4llvm11raw_ostreamERKN5clang4ento23PathDiagnosticCallPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjj")
//</editor-fold>
public static void ReportCall(final raw_ostream /*&*/ o, 
          final /*const*/ PathDiagnosticCallPiece /*&*/ P, 
          final /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, final /*const*/ SourceManager /*&*/ SM, 
          final /*const*/ LangOptions /*&*/ LangOpts, 
          /*uint*/int indent, 
          /*uint*/int depth) {
  IntrusiveRefCntPtr<PathDiagnosticEventPiece> callEnter = null;
  IntrusiveRefCntPtr<PathDiagnosticEventPiece> callEnterWithinCaller = null;
  IntrusiveRefCntPtr<PathDiagnosticEventPiece> callExit = null;
  try {
    
    callEnter = P.getCallEnterEvent();
    if (callEnter.$bool()) {
      ReportPiece(o, callEnter.$star(), FM, SM, LangOpts, indent, depth, true, 
          P.isLastInMainSourceFile());
    }
    
    callEnterWithinCaller = P.getCallEnterWithinCallerEvent();
    
    ++depth;
    if (callEnterWithinCaller.$bool()) {
      ReportPiece(o, callEnterWithinCaller.$star(), FM, SM, LangOpts, 
          indent, depth, true);
    }
    
    for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = P._path.begin$Const(), E = P._path.end$Const(); I.$noteq(E); I.$preInc())  {
      ReportPiece(o, I.$star().$star(), FM, SM, LangOpts, indent, depth, true);
    }
    
    --depth;
    
    callExit = P.getCallExitEvent();
    if (callExit.$bool()) {
      ReportPiece(o, callExit.$star(), FM, SM, LangOpts, indent, depth, true);
    }
  } finally {
    if (callExit != null) { callExit.$destroy(); }
    if (callEnterWithinCaller != null) { callEnterWithinCaller.$destroy(); }
    if (callEnter != null) { callEnter.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="ReportMacro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 240,
 FQN="ReportMacro", NM="_ZL11ReportMacroRN4llvm11raw_ostreamERKN5clang4ento24PathDiagnosticMacroPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZL11ReportMacroRN4llvm11raw_ostreamERKN5clang4ento24PathDiagnosticMacroPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsEjj")
//</editor-fold>
public static void ReportMacro(final raw_ostream /*&*/ o, 
           final /*const*/ PathDiagnosticMacroPiece /*&*/ P, 
           final /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, final /*const*/ SourceManager /*&*/ SM, 
           final /*const*/ LangOptions /*&*/ LangOpts, 
           /*uint*/int indent, 
           /*uint*/int depth) {
  
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = P.subPieces.begin$Const(), E = P.subPieces.end$Const();
       I.$noteq(E); I.$preInc()) {
    ReportPiece(o, I.$star().$star(), FM, SM, LangOpts, indent, depth, false);
  }
}

//<editor-fold defaultstate="collapsed" desc="ReportDiag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 253,
 FQN="ReportDiag", NM="_ZL10ReportDiagRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZL10ReportDiagRN4llvm11raw_ostreamERKN5clang4ento19PathDiagnosticPieceERKNS_8DenseMapINS2_6FileIDEjNS_12DenseMapInfoIS8_EENS_6detail12DenseMapPairIS8_jEEEERKNS2_13SourceManagerERKNS2_11LangOptionsE")
//</editor-fold>
public static void ReportDiag(final raw_ostream /*&*/ o, final /*const*/ PathDiagnosticPiece /*&*/ P, 
          final /*const*/DenseMapTypeUInt<FileID>/*&*/ FM, final /*const*/ SourceManager /*&*/ SM, 
          final /*const*/ LangOptions /*&*/ LangOpts) {
  ReportPiece(o, P, FM, SM, LangOpts, 4, 0, true);
}

} // END OF class PlistDiagnosticsStatics
