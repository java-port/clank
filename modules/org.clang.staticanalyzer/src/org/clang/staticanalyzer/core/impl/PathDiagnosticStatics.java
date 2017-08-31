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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.core.impl.PathDiagnosticStatics.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type PathDiagnosticStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.impl.PathDiagnosticStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL11compareCallRKN5clang4ento23PathDiagnosticCallPieceES3_;_ZL11comparePathRKN5clang4ento10PathPiecesES3_;_ZL12compareMacroRKN5clang4ento24PathDiagnosticMacroPieceES3_;_ZL12comparePieceRKN5clang4ento19PathDiagnosticPieceES3_;_ZL13describeClassRN4llvm11raw_ostreamEPKN5clang13CXXRecordDeclENS_9StringRefE;_ZL16describeCodeDeclRN4llvm11raw_ostreamEPKN5clang4DeclEbNS_9StringRefE;_ZL17StripTrailingDotsN4llvm9StringRefE;_ZL17compute_path_sizeRKN5clang4ento10PathPiecesERj;_ZL18compareControlFlowRKN5clang4ento30PathDiagnosticControlFlowPieceES3_;_ZL20getLocationForCallerPKN5clang17StackFrameContextEPKNS_15LocationContextERKNS_13SourceManagerE;_ZL22getValidSourceLocationPKN5clang4StmtEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEEb;_ZL31getFirstStackedCallToHeaderFilePN5clang4ento23PathDiagnosticCallPieceERKNS_13SourceManagerE;_ZL7compareRKN5clang4ento14PathDiagnosticES3_; -static-type=PathDiagnosticStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class PathDiagnosticStatics {

//<editor-fold defaultstate="collapsed" desc="StripTrailingDots">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 43,
 FQN="StripTrailingDots", NM="_ZL17StripTrailingDotsN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL17StripTrailingDotsN4llvm9StringRefE")
//</editor-fold>
public static StringRef StripTrailingDots(StringRef s) {
  for (/*size_t*/int i = s.size(); i != 0; --i)  {
    if (s.$at(i - 1) != $$DOT) {
      return s.substr(0, i);
    }
  }
  return new StringRef(/*KEEP_STR*/$EMPTY);
}

//<editor-fold defaultstate="collapsed" desc="getFirstStackedCallToHeaderFile">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 121,
 FQN="getFirstStackedCallToHeaderFile", NM="_ZL31getFirstStackedCallToHeaderFilePN5clang4ento23PathDiagnosticCallPieceERKNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL31getFirstStackedCallToHeaderFilePN5clang4ento23PathDiagnosticCallPieceERKNS_13SourceManagerE")
//</editor-fold>
public static PathDiagnosticCallPiece /*P*/ getFirstStackedCallToHeaderFile(PathDiagnosticCallPiece /*P*/ CP, 
                               final /*const*/ SourceManager /*&*/ SMgr) {
  SourceLocation CallLoc = new SourceLocation(JD$Move.INSTANCE, CP.callEnter.asLocation());
  
  // If the call is within a macro, don't do anything (for now).
  if (CallLoc.isMacroID()) {
    return null;
  }
  assert (SMgr.isInMainFile(/*NO_COPY*/CallLoc)) : "The call piece should be in the main file.";
  
  // Check if CP represents a path through a function outside of the main file.
  if (!SMgr.isInMainFile(/*NO_COPY*/CP.callEnterWithin.asLocation())) {
    return CP;
  }
  
  final /*const*/ PathPieces /*&*/ Path = CP._path;
  if (Path.empty()) {
    return null;
  }
  {
    
    // Check if the last piece in the callee path is a call to a function outside
    // of the main file.
    PathDiagnosticCallPiece /*P*/ CPInner = dyn_cast_PathDiagnosticCallPiece(Path.back$Const().$star());
    if ((CPInner != null)) {
      return getFirstStackedCallToHeaderFile(CPInner, SMgr);
    }
  }
  
  // Otherwise, the last piece is in the main file.
  return null;
}

//<editor-fold defaultstate="collapsed" desc="comparePath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 360,
 FQN="comparePath", NM="_ZL11comparePathRKN5clang4ento10PathPiecesES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL11comparePathRKN5clang4ento10PathPiecesES3_")
//</editor-fold>
public static OptionalBool comparePath(final /*const*/ PathPieces /*&*/ X, final /*const*/ PathPieces /*&*/ Y) {
  if (X.size() != Y.size()) {
    return new OptionalBool(JD$T$RR.INSTANCE, $less_uint(X.size(), Y.size()));
  }
  
  std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> X_I = X.begin$Const();
  std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> X_end = X.end$Const();
  std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> Y_I = Y.begin$Const();
  std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> Y_end = Y.end$Const();
  
  for (; X_I.$noteq(X_end) && Y_I.$noteq(Y_end); X_I.$preInc() , Y_I.$preInc()) {
    OptionalBool b = comparePiece(X_I.$star().$star(), Y_I.$star().$star());
    if (b.hasValue()) {
      return new OptionalBool(JD$T$C$R.INSTANCE, b.getValue());
    }
  }
  
  return new OptionalBool(None);
}

//<editor-fold defaultstate="collapsed" desc="compareControlFlow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 280,
 FQN="compareControlFlow", NM="_ZL18compareControlFlowRKN5clang4ento30PathDiagnosticControlFlowPieceES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL18compareControlFlowRKN5clang4ento30PathDiagnosticControlFlowPieceES3_")
//</editor-fold>
public static OptionalBool compareControlFlow(final /*const*/ PathDiagnosticControlFlowPiece /*&*/ X, 
                  final /*const*/ PathDiagnosticControlFlowPiece /*&*/ Y) {
  FullSourceLoc XSL = X.getStartLocation().asLocation();
  FullSourceLoc YSL = Y.getStartLocation().asLocation();
  if (FullSourceLoc.$noteq_FullSourceLoc$C(XSL, YSL)) {
    return new OptionalBool(JD$T$RR.INSTANCE, XSL.isBeforeInTranslationUnitThan(/*NO_COPY*/YSL));
  }
  FullSourceLoc XEL = X.getEndLocation().asLocation();
  FullSourceLoc YEL = Y.getEndLocation().asLocation();
  if (FullSourceLoc.$noteq_FullSourceLoc$C(XEL, YEL)) {
    return new OptionalBool(JD$T$RR.INSTANCE, XEL.isBeforeInTranslationUnitThan(/*NO_COPY*/YEL));
  }
  return new OptionalBool(None);
}

//<editor-fold defaultstate="collapsed" desc="compareMacro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 294,
 FQN="compareMacro", NM="_ZL12compareMacroRKN5clang4ento24PathDiagnosticMacroPieceES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL12compareMacroRKN5clang4ento24PathDiagnosticMacroPieceES3_")
//</editor-fold>
public static OptionalBool compareMacro(final /*const*/ PathDiagnosticMacroPiece /*&*/ X, 
            final /*const*/ PathDiagnosticMacroPiece /*&*/ Y) {
  return comparePath(X.subPieces, Y.subPieces);
}

//<editor-fold defaultstate="collapsed" desc="compareCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 299,
 FQN="compareCall", NM="_ZL11compareCallRKN5clang4ento23PathDiagnosticCallPieceES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL11compareCallRKN5clang4ento23PathDiagnosticCallPieceES3_")
//</editor-fold>
public static OptionalBool compareCall(final /*const*/ PathDiagnosticCallPiece /*&*/ X, 
           final /*const*/ PathDiagnosticCallPiece /*&*/ Y) {
  FullSourceLoc X_CEL = X.callEnter.asLocation();
  FullSourceLoc Y_CEL = Y.callEnter.asLocation();
  if (FullSourceLoc.$noteq_FullSourceLoc$C(X_CEL, Y_CEL)) {
    return new OptionalBool(JD$T$RR.INSTANCE, X_CEL.isBeforeInTranslationUnitThan(/*NO_COPY*/Y_CEL));
  }
  FullSourceLoc X_CEWL = X.callEnterWithin.asLocation();
  FullSourceLoc Y_CEWL = Y.callEnterWithin.asLocation();
  if (FullSourceLoc.$noteq_FullSourceLoc$C(X_CEWL, Y_CEWL)) {
    return new OptionalBool(JD$T$RR.INSTANCE, X_CEWL.isBeforeInTranslationUnitThan(/*NO_COPY*/Y_CEWL));
  }
  FullSourceLoc X_CRL = X.callReturn.asLocation();
  FullSourceLoc Y_CRL = Y.callReturn.asLocation();
  if (FullSourceLoc.$noteq_FullSourceLoc$C(X_CRL, Y_CRL)) {
    return new OptionalBool(JD$T$RR.INSTANCE, X_CRL.isBeforeInTranslationUnitThan(/*NO_COPY*/Y_CRL));
  }
  return comparePath(X._path, Y._path);
}

//<editor-fold defaultstate="collapsed" desc="comparePiece">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 316,
 FQN="comparePiece", NM="_ZL12comparePieceRKN5clang4ento19PathDiagnosticPieceES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL12comparePieceRKN5clang4ento19PathDiagnosticPieceES3_")
//</editor-fold>
public static OptionalBool comparePiece(final /*const*/ PathDiagnosticPiece /*&*/ X, 
            final /*const*/ PathDiagnosticPiece /*&*/ Y) {
  if (X.getKind() != Y.getKind()) {
    return new OptionalBool(JD$T$RR.INSTANCE, X.getKind().getValue() < Y.getKind().getValue());
  }
  
  FullSourceLoc XL = X.getLocation().asLocation();
  FullSourceLoc YL = Y.getLocation().asLocation();
  if (FullSourceLoc.$noteq_FullSourceLoc$C(XL, YL)) {
    return new OptionalBool(JD$T$RR.INSTANCE, XL.isBeforeInTranslationUnitThan(/*NO_COPY*/YL));
  }
  if ($noteq_StringRef(X.getString(), Y.getString())) {
    return new OptionalBool(JD$T$RR.INSTANCE, $less_StringRef(X.getString(), Y.getString()));
  }
  if (X.getRanges().size() != Y.getRanges().size()) {
    return new OptionalBool(JD$T$RR.INSTANCE, $less_uint(X.getRanges().size(), Y.getRanges().size()));
  }
  
  final /*const*/ SourceManager /*&*/ SM = XL.getManager();
  
  for (/*uint*/int i = 0, n = X.getRanges().size(); $less_uint(i, n); ++i) {
    SourceRange XR = new SourceRange(X.getRanges().$at(i));
    SourceRange YR = new SourceRange(Y.getRanges().$at(i));
    if (XR.$noteq(YR)) {
      if ($noteq_SourceLocation$C(XR.getBegin(), YR.getBegin())) {
        return new OptionalBool(JD$T$RR.INSTANCE, SM.isBeforeInTranslationUnit(XR.getBegin(), YR.getBegin()));
      }
      return new OptionalBool(JD$T$RR.INSTANCE, SM.isBeforeInTranslationUnit(XR.getEnd(), YR.getEnd()));
    }
  }
  switch (X.getKind()) {
   case ControlFlow:
    return compareControlFlow(cast_PathDiagnosticControlFlowPiece(X), 
        cast_PathDiagnosticControlFlowPiece(Y));
   case Event:
    return new OptionalBool(None);
   case Macro:
    return compareMacro(cast_PathDiagnosticMacroPiece(X), 
        cast_PathDiagnosticMacroPiece(Y));
   case Call:
    return compareCall(cast_PathDiagnosticCallPiece(X), 
        cast_PathDiagnosticCallPiece(Y));
  }
  throw new llvm_unreachable("all cases handled");
}

//<editor-fold defaultstate="collapsed" desc="compare">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 376,
 FQN="compare", NM="_ZL7compareRKN5clang4ento14PathDiagnosticES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL7compareRKN5clang4ento14PathDiagnosticES3_")
//</editor-fold>
public static boolean compare(final /*const*/ PathDiagnostic /*&*/ X, final /*const*/ PathDiagnostic /*&*/ Y) {
  FullSourceLoc XL = X.getLocation().asLocation();
  FullSourceLoc YL = Y.getLocation().asLocation();
  if (FullSourceLoc.$noteq_FullSourceLoc$C(XL, YL)) {
    return XL.isBeforeInTranslationUnitThan(/*NO_COPY*/YL);
  }
  if ($noteq_StringRef(X.getBugType(), Y.getBugType())) {
    return $less_StringRef(X.getBugType(), Y.getBugType());
  }
  if ($noteq_StringRef(X.getCategory(), Y.getCategory())) {
    return $less_StringRef(X.getCategory(), Y.getCategory());
  }
  if ($noteq_StringRef(X.getVerboseDescription(), Y.getVerboseDescription())) {
    return $less_StringRef(X.getVerboseDescription(), Y.getVerboseDescription());
  }
  if ($noteq_StringRef(X.getShortDescription(), Y.getShortDescription())) {
    return $less_StringRef(X.getShortDescription(), Y.getShortDescription());
  }
  if (X.getDeclWithIssue() != Y.getDeclWithIssue()) {
    /*const*/ Decl /*P*/ XD = X.getDeclWithIssue();
    if (!(XD != null)) {
      return true;
    }
    /*const*/ Decl /*P*/ YD = Y.getDeclWithIssue();
    if (!(YD != null)) {
      return false;
    }
    SourceLocation XDL = XD.getLocation();
    SourceLocation YDL = YD.getLocation();
    if ($noteq_SourceLocation$C(XDL, YDL)) {
      final /*const*/ SourceManager /*&*/ SM = XL.getManager();
      return SM.isBeforeInTranslationUnit(/*NO_COPY*/XDL, /*NO_COPY*/YDL);
    }
  }
  std.deque.iterator<std.string> XI = X.meta_begin();
  std.deque.iterator<std.string> XE = X.meta_end();
  std.deque.iterator<std.string> YI = Y.meta_begin();
  std.deque.iterator<std.string> YE = Y.meta_end();
  if ($sub__Deque_iterator$_Tp$_Ref$_Ptr$C(XE, XI) != $sub__Deque_iterator$_Tp$_Ref$_Ptr$C(YE, YI)) {
    return ($sub__Deque_iterator$_Tp$_Ref$_Ptr$C(XE, XI)) < ($sub__Deque_iterator$_Tp$_Ref$_Ptr$C(YE, YI));
  }
  for (; $noteq__Deque_iterator$_Tp$_Ref$_Ptr$C(XI, XE); XI.$preInc() , YI.$preInc()) {
    if ($noteq_string$C(XI.$star(), YI.$star())) {
      return $less_string$C((XI.$star()), (YI.$star()));
    }
  }
  OptionalBool b = comparePath(X._path, Y._path);
  assert (b.hasValue());
  return b.getValue();
}


//===----------------------------------------------------------------------===//
// PathDiagnosticLocation methods.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="getValidSourceLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 497,
 FQN="getValidSourceLocation", NM="_ZL22getValidSourceLocationPKN5clang4StmtEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL22getValidSourceLocationPKN5clang4StmtEN4llvm12PointerUnionIPKNS_15LocationContextEPNS_19AnalysisDeclContextEEEb")
//</editor-fold>
public static SourceLocation getValidSourceLocation(/*const*/ Stmt /*P*/ S, 
                      PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > LAC) {
  return getValidSourceLocation(S, 
                      LAC, 
                      false);
}
public static SourceLocation getValidSourceLocation(/*const*/ Stmt /*P*/ S, 
                      PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > LAC, 
                      boolean UseEnd/*= false*/) {
  SourceLocation L = UseEnd ? S.getLocEnd() : S.getLocStart();
  assert (!LAC.isNull()) : "A valid LocationContext or AnalysisDeclContext should be passed to PathDiagnosticLocation upon creation.";
  
  // S might be a temporary statement that does not have a location in the
  // source code, so find an enclosing statement and use its location.
  if (!L.isValid()) {
    AnalysisDeclContext /*P*/ ADC;
    if ((LAC.is(/*const*/ LocationContext /*P*/.class) != 0)) {
      ADC = LAC.get(/*const*/ LocationContext /*P*/.class).getAnalysisDeclContext();
    } else {
      ADC = LAC.get(AnalysisDeclContext /*P*/.class);
    }
    
    final ParentMap /*&*/ PM = ADC.getParentMap();
    
    /*const*/ Stmt /*P*/ Parent = S;
    do {
      Parent = PM.getParent_Stmt$C$P(Parent);
      
      // In rare cases, we have implicit top-level expressions,
      // such as arguments for implicit member initializers.
      // In this case, fall back to the start of the body (even if we were
      // asked for the statement end location).
      if (!(Parent != null)) {
        /*const*/ Stmt /*P*/ Body = ADC.getBody();
        if ((Body != null)) {
          L.$assignMove(Body.getLocStart());
        } else {
          L.$assignMove(ADC.getDecl().getLocEnd());
        }
        break;
      }
      
      L.$assignMove(UseEnd ? Parent.getLocEnd() : Parent.getLocStart());
    } while (!L.isValid());
  }
  
  return L;
}

//<editor-fold defaultstate="collapsed" desc="getLocationForCaller">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 539,
 FQN="getLocationForCaller", NM="_ZL20getLocationForCallerPKN5clang17StackFrameContextEPKNS_15LocationContextERKNS_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL20getLocationForCallerPKN5clang17StackFrameContextEPKNS_15LocationContextERKNS_13SourceManagerE")
//</editor-fold>
public static PathDiagnosticLocation getLocationForCaller(/*const*/ StackFrameContext /*P*/ SFC, 
                    /*const*/ LocationContext /*P*/ CallerCtx, 
                    final /*const*/ SourceManager /*&*/ SM) {
  final /*const*/ CFGBlock /*&*/ Block = $Deref(SFC.getCallSiteBlock());
  CFGElement Source = Block.$at(SFC.getIndex());
  switch (Source.getKind()) {
   case Statement:
    return new PathDiagnosticLocation(Source.castAs(CFGStmt.class).getStmt(), 
        SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, CallerCtx));
   case Initializer:
    {
      final /*const*/ CFGInitializer /*&*/ Init = Source.castAs(CFGInitializer.class);
      return new PathDiagnosticLocation(Init.getInitializer().getInit(), 
          SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, CallerCtx));
    }
   case AutomaticObjectDtor:
    {
      final /*const*/ CFGAutomaticObjDtor /*&*/ Dtor = Source.castAs(CFGAutomaticObjDtor.class);
      return PathDiagnosticLocation.createEnd(Dtor.getTriggerStmt(), 
          SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, CallerCtx));
    }
   case DeleteDtor:
    {
      final /*const*/ CFGDeleteDtor /*&*/ Dtor = Source.castAs(CFGDeleteDtor.class);
      return new PathDiagnosticLocation(Dtor.getDeleteExpr(), SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, CallerCtx));
    }
   case BaseDtor:
   case MemberDtor:
    {
      /*const*/ AnalysisDeclContext /*P*/ CallerInfo = CallerCtx.getAnalysisDeclContext();
      {
        /*const*/ Stmt /*P*/ CallerBody = CallerInfo.getBody();
        if ((CallerBody != null)) {
          return PathDiagnosticLocation.createEnd(CallerBody, SM, new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, CallerCtx));
        }
      }
      return PathDiagnosticLocation.create(CallerInfo.getDecl(), SM);
    }
   case TemporaryDtor:
   case NewAllocator:
    throw new llvm_unreachable("not yet implemented!");
  }
  throw new llvm_unreachable("Unknown CFGElement kind");
}

//<editor-fold defaultstate="collapsed" desc="describeClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 907,
 FQN="describeClass", NM="_ZL13describeClassRN4llvm11raw_ostreamEPKN5clang13CXXRecordDeclENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL13describeClassRN4llvm11raw_ostreamEPKN5clang13CXXRecordDeclENS_9StringRefE")
//</editor-fold>
public static /*inline*/ void describeClass(final raw_ostream /*&*/ Out, /*const*/ CXXRecordDecl /*P*/ D) {
  describeClass(Out, D, 
             new StringRef());
}
public static /*inline*/ void describeClass(final raw_ostream /*&*/ Out, /*const*/ CXXRecordDecl /*P*/ D, 
             StringRef Prefix/*= StringRef()*/) {
  if (!(D.getIdentifier() != null)) {
    return;
  }
  $out_raw_ostream_NamedDecl$C(Out.$out(/*NO_COPY*/Prefix).$out_char($$SGL_QUOTE), $Deref(D)).$out_char($$SGL_QUOTE);
}

//<editor-fold defaultstate="collapsed" desc="describeCodeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 914,
 FQN="describeCodeDecl", NM="_ZL16describeCodeDeclRN4llvm11raw_ostreamEPKN5clang4DeclEbNS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL16describeCodeDeclRN4llvm11raw_ostreamEPKN5clang4DeclEbNS_9StringRefE")
//</editor-fold>
public static boolean describeCodeDecl(final raw_ostream /*&*/ Out, /*const*/ Decl /*P*/ D, 
                boolean ExtendedDescription) {
  return describeCodeDecl(Out, D, 
                ExtendedDescription, 
                new StringRef());
}
public static boolean describeCodeDecl(final raw_ostream /*&*/ Out, /*const*/ Decl /*P*/ D, 
                boolean ExtendedDescription, 
                StringRef Prefix/*= StringRef()*/) {
  if (!(D != null)) {
    return false;
  }
  if (isa_BlockDecl(D)) {
    if (ExtendedDescription) {
      Out.$out(/*NO_COPY*/Prefix).$out(/*KEEP_STR*/"anonymous block");
    }
    return ExtendedDescription;
  }
  {
    
    /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(D);
    if ((MD != null)) {
      Out.$out(/*NO_COPY*/Prefix);
      if (ExtendedDescription && !MD.isUserProvided()) {
        if (MD.isExplicitlyDefaulted()) {
          Out.$out(/*KEEP_STR*/"defaulted ");
        } else {
          Out.$out(/*KEEP_STR*/"implicit ");
        }
      }
      {
        
        /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(MD);
        if ((CD != null)) {
          if (CD.isDefaultConstructor()) {
            Out.$out(/*KEEP_STR*/"default ");
          } else if (CD.isCopyConstructor()) {
            Out.$out(/*KEEP_STR*/"copy ");
          } else if (CD.isMoveConstructor()) {
            Out.$out(/*KEEP_STR*/"move ");
          }
          
          Out.$out(/*KEEP_STR*/"constructor");
          describeClass(Out, MD.getParent$Const(), new StringRef(/*KEEP_STR*/" for "));
        } else if (isa_CXXDestructorDecl(MD)) {
          if (!MD.isUserProvided()) {
            Out.$out(/*KEEP_STR*/"destructor");
            describeClass(Out, MD.getParent$Const(), new StringRef(/*KEEP_STR*/" for "));
          } else {
            // Use ~Foo for explicitly-written destructors.
            $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/$SGL_QUOTE), $Deref(MD)).$out(/*KEEP_STR*/$SGL_QUOTE);
          }
        } else if (MD.isCopyAssignmentOperator()) {
          Out.$out(/*KEEP_STR*/"copy assignment operator");
          describeClass(Out, MD.getParent$Const(), new StringRef(/*KEEP_STR*/" for "));
        } else if (MD.isMoveAssignmentOperator()) {
          Out.$out(/*KEEP_STR*/"move assignment operator");
          describeClass(Out, MD.getParent$Const(), new StringRef(/*KEEP_STR*/" for "));
        } else {
          if ((MD.getParent$Const().getIdentifier() != null)) {
            $out_raw_ostream_NamedDecl$C($out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/$SGL_QUOTE), $Deref(MD.getParent$Const())).$out(/*KEEP_STR*/$COLON_COLON), $Deref(MD)).$out(/*KEEP_STR*/$SGL_QUOTE);
          } else {
            $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/$SGL_QUOTE), $Deref(MD)).$out(/*KEEP_STR*/$SGL_QUOTE);
          }
        }
      }
      
      return true;
    }
  }
  
  $out_raw_ostream_NamedDecl$C(Out.$out(/*NO_COPY*/Prefix).$out_char($$SGL_QUOTE), cast_NamedDecl($Deref(D))).$out_char($$SGL_QUOTE);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="compute_path_size">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1033,
 FQN="compute_path_size", NM="_ZL17compute_path_sizeRKN5clang4ento10PathPiecesERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZL17compute_path_sizeRKN5clang4ento10PathPiecesERj")
//</editor-fold>
public static void compute_path_size(final /*const*/ PathPieces /*&*/ pieces, final uint$ref/*uint &*/ size) {
  for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> it = pieces.begin$Const(), 
      et = pieces.end$Const(); it.$noteq(et); it.$preInc()) {
    /*const*/ PathDiagnosticPiece /*P*/ piece = it.$arrow().get();
    {
      /*const*/ PathDiagnosticCallPiece /*P*/ cp = dyn_cast_PathDiagnosticCallPiece(piece);
      if ((cp != null)) {
        compute_path_size(cp._path, size);
      } else {
        size.$set$preInc();
      }
    }
  }
}

} // END OF class PathDiagnosticStatics
