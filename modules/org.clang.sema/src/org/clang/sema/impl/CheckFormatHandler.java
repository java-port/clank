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

package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.basic.java.RangeBase;
import org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder;
import org.llvm.support.ConvertUTFGlobals.*;
import org.llvm.support.sys.locale;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4129,
 FQN="(anonymous namespace)::CheckFormatHandler", NM="_ZN12_GLOBAL__N_118CheckFormatHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandlerE")
//</editor-fold>
public class CheckFormatHandler extends /*public*/ FormatStringHandler implements Destructors.ClassWithDestructor {
/*protected:*/
  protected final Sema /*&*/ S;
  protected /*const*/ StringLiteral /*P*/ FExpr;
  protected /*const*/ Expr /*P*/ OrigFormatExpr;
  protected /*const*//*uint*/int FirstDataArg;
  protected /*const*//*uint*/int NumDataArgs;
  protected /*const*/char$ptr/*char P*/ Beg; // Start of format string.
  protected /*const*/boolean HasVAListArg;
  protected ArrayRef</*const*/ Expr /*P*/ > Args;
  protected /*uint*/int FormatIdx;
  protected SmallBitVector CoveredArgs;
  protected boolean usesPositionalArgs;
  protected boolean atFirstArg;
  protected boolean inFunctionCall;
  protected Sema.VariadicCallType CallType;
  protected final SmallBitVector /*&*/ CheckedVarArgs;
  protected final UncoveredArgHandler /*&*/ UncoveredArg;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::CheckFormatHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4149,
   FQN="(anonymous namespace)::CheckFormatHandler::CheckFormatHandler", NM="_ZN12_GLOBAL__N_118CheckFormatHandlerC1ERN5clang4SemaEPKNS1_13StringLiteralEPKNS1_4ExprEjjPKcbN4llvm8ArrayRefIS9_EEjbNS2_16VariadicCallTypeERNSC_14SmallBitVectorERNS_19UncoveredArgHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandlerC1ERN5clang4SemaEPKNS1_13StringLiteralEPKNS1_4ExprEjjPKcbN4llvm8ArrayRefIS9_EEjbNS2_16VariadicCallTypeERNSC_14SmallBitVectorERNS_19UncoveredArgHandlerE")
  //</editor-fold>
  public CheckFormatHandler(final Sema /*&*/ s, /*const*/ StringLiteral /*P*/ fexpr, 
      /*const*/ Expr /*P*/ origFormatExpr, /*uint*/int firstDataArg, 
      /*uint*/int numDataArgs, /*const*/char$ptr/*char P*/ beg, boolean hasVAListArg, 
      ArrayRef</*const*/ Expr /*P*/ > Args, 
      /*uint*/int formatIdx, boolean inFunctionCall, 
      Sema.VariadicCallType callType, 
      final SmallBitVector /*&*/ CheckedVarArgs, 
      final UncoveredArgHandler /*&*/ UncoveredArg) {
    // : FormatStringHandler(), S(s), FExpr(fexpr), OrigFormatExpr(origFormatExpr), FirstDataArg(firstDataArg), NumDataArgs(numDataArgs), Beg(beg), HasVAListArg(hasVAListArg), Args(Args), FormatIdx(formatIdx), CoveredArgs(), usesPositionalArgs(false), atFirstArg(true), inFunctionCall(inFunctionCall), CallType(callType), CheckedVarArgs(CheckedVarArgs), UncoveredArg(UncoveredArg) 
    //START JInit
    super();
    this./*&*/S=/*&*/s;
    this.FExpr = fexpr;
    this.OrigFormatExpr = origFormatExpr;
    this.FirstDataArg = firstDataArg;
    this.NumDataArgs = numDataArgs;
    this.Beg = $tryClone(beg);
    this.HasVAListArg = hasVAListArg;
    this.Args = new ArrayRef</*const*/ Expr /*P*/ >(Args);
    this.FormatIdx = formatIdx;
    this.CoveredArgs = new SmallBitVector();
    this.usesPositionalArgs = false;
    this.atFirstArg = true;
    this.inFunctionCall = inFunctionCall;
    this.CallType = callType;
    this./*&*/CheckedVarArgs=/*&*/CheckedVarArgs;
    this./*&*/UncoveredArg=/*&*/UncoveredArg;
    //END JInit
    CoveredArgs.resize(numDataArgs);
    CoveredArgs.reset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::DoneProcessing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4392,
   FQN="(anonymous namespace)::CheckFormatHandler::DoneProcessing", NM="_ZN12_GLOBAL__N_118CheckFormatHandler14DoneProcessingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler14DoneProcessingEv")
  //</editor-fold>
  public void DoneProcessing() {
    // Does the number of data arguments exceed the number of
    // format conversions in the format string?
    if (!HasVAListArg) {
      // Find any arguments that weren't covered.
      CoveredArgs.flip();
      int notCoveredArg = CoveredArgs.find_first();
      if (notCoveredArg >= 0) {
        assert ($less_uint((/*uint*/int)notCoveredArg, NumDataArgs));
        UncoveredArg.Update(notCoveredArg, OrigFormatExpr);
      } else {
        UncoveredArg.setAllCovered();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandleIncompleteSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4252,
   FQN="(anonymous namespace)::CheckFormatHandler::HandleIncompleteSpecifier", NM="_ZN12_GLOBAL__N_118CheckFormatHandler25HandleIncompleteSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler25HandleIncompleteSpecifierEPKcj")
  //</editor-fold>
  @Override public void HandleIncompleteSpecifier(/*const*/char$ptr/*char P*/ startSpecifier, 
                           /*uint*/int specifierLen)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      EmitFormatDiagnostic($c$.track(S.PDiag(diag.warn_printf_incomplete_specifier)), 
          getLocationOfByte(startSpecifier), 
          /*IsStringLocation*/ true, 
          getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandleInvalidLengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4260,
   FQN="(anonymous namespace)::CheckFormatHandler::HandleInvalidLengthModifier", NM="_ZN12_GLOBAL__N_118CheckFormatHandler27HandleInvalidLengthModifierERKN5clang21analyze_format_string15FormatSpecifierERKNS2_19ConversionSpecifierEPKcjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler27HandleInvalidLengthModifierERKN5clang21analyze_format_string15FormatSpecifierERKNS2_19ConversionSpecifierEPKcjj")
  //</editor-fold>
  public void HandleInvalidLengthModifier(final /*const*/ FormatSpecifier /*&*/ FS, 
                             final /*const*/ ConversionSpecifier /*&*/ CS, 
                             /*const*/char$ptr/*char P*/ startSpecifier, /*uint*/int specifierLen, /*uint*/int DiagID) {
    //JAVA: using namespace analyze_format_string;
    
    final /*const*/ LengthModifier /*&*/ LM = FS.getLengthModifier();
    CharSourceRange LMRange = getSpecifierRange(LM.getStart(), LM.getLength());
    
    // See if we know how to fix this length modifier.
    Optional<LengthModifier> FixedLM = FS.getCorrectedLengthModifier();
    if (FixedLM.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C(PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(DiagID)), LM.__toString()), CS.__toString()))), 
            getLocationOfByte(LM.getStart()), 
            /*IsStringLocation*/ true, 
            getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
        
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track(S.Diag(getLocationOfByte(LM.getStart()), diag.note_format_fix_specifier)), 
                FixedLM.$arrow().__toString()), 
            FixItHint.CreateReplacement(/*NO_COPY*/LMRange, new StringRef(FixedLM.$arrow().__toString()))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        FixItHint Hint/*J*/= new FixItHint();
        if (DiagID == diag.warn_format_nonsensical_length) {
          Hint.$assignMove(FixItHint.CreateRemoval(/*NO_COPY*/LMRange));
        }
        
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C(PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(DiagID)), LM.__toString()), CS.__toString()))), 
            getLocationOfByte(LM.getStart()), 
            /*IsStringLocation*/ true, 
            getSpecifierRange(startSpecifier, specifierLen), 
            new ArrayRef<FixItHint>(Hint, false)); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandleNonStandardLengthModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4294,
   FQN="(anonymous namespace)::CheckFormatHandler::HandleNonStandardLengthModifier", NM="_ZN12_GLOBAL__N_118CheckFormatHandler31HandleNonStandardLengthModifierERKN5clang21analyze_format_string15FormatSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler31HandleNonStandardLengthModifierERKN5clang21analyze_format_string15FormatSpecifierEPKcj")
  //</editor-fold>
  public void HandleNonStandardLengthModifier(final /*const*/ FormatSpecifier /*&*/ FS, 
                                 /*const*/char$ptr/*char P*/ startSpecifier, /*uint*/int specifierLen) {
    //JAVA: using namespace analyze_format_string;
    
    final /*const*/ LengthModifier /*&*/ LM = FS.getLengthModifier();
    CharSourceRange LMRange = getSpecifierRange(LM.getStart(), LM.getLength());
    
    // See if we know how to fix this length modifier.
    Optional<LengthModifier> FixedLM = FS.getCorrectedLengthModifier();
    if (FixedLM.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(diag.warn_format_non_standard)), 
                        LM.__toString()), 0))), 
            getLocationOfByte(LM.getStart()), 
            /*IsStringLocation*/ true, 
            getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
        
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track(S.Diag(getLocationOfByte(LM.getStart()), diag.note_format_fix_specifier)), 
                FixedLM.$arrow().__toString()), 
            FixItHint.CreateReplacement(/*NO_COPY*/LMRange, new StringRef(FixedLM.$arrow().__toString()))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(diag.warn_format_non_standard)), 
                        LM.__toString()), 0))), 
            getLocationOfByte(LM.getStart()), 
            /*IsStringLocation*/ true, 
            getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandleNonStandardConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4324,
   FQN="(anonymous namespace)::CheckFormatHandler::HandleNonStandardConversionSpecifier", NM="_ZN12_GLOBAL__N_118CheckFormatHandler36HandleNonStandardConversionSpecifierERKN5clang21analyze_format_string19ConversionSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler36HandleNonStandardConversionSpecifierERKN5clang21analyze_format_string19ConversionSpecifierEPKcj")
  //</editor-fold>
  public void HandleNonStandardConversionSpecifier(final /*const*/ ConversionSpecifier /*&*/ CS, 
                                      /*const*/char$ptr/*char P*/ startSpecifier, /*uint*/int specifierLen) {
    //JAVA: using namespace analyze_format_string;
    
    // See if we know how to fix this conversion specifier.
    Optional<ConversionSpecifier> FixedCS = CS.getStandardSpecifier();
    if (FixedCS.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(diag.warn_format_non_standard)), 
                        CS.__toString()), /*conversion specifier*/ 1))), 
            getLocationOfByte(CS.getStart()), 
            /*IsStringLocation*/ true, 
            getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
        
        CharSourceRange CSRange = getSpecifierRange(CS.getStart(), CS.getLength());
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track(S.Diag(getLocationOfByte(CS.getStart()), diag.note_format_fix_specifier)), 
                FixedCS.$arrow().__toString()), 
            FixItHint.CreateReplacement(/*NO_COPY*/CSRange, new StringRef(FixedCS.$arrow().__toString()))));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(diag.warn_format_non_standard)), 
                        CS.__toString()), /*conversion specifier*/ 1))), 
            getLocationOfByte(CS.getStart()), 
            /*IsStringLocation*/ true, 
            getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandlePosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4351,
   FQN="(anonymous namespace)::CheckFormatHandler::HandlePosition", NM="_ZN12_GLOBAL__N_118CheckFormatHandler14HandlePositionEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler14HandlePositionEPKcj")
  //</editor-fold>
  @Override public void HandlePosition(/*const*/char$ptr/*char P*/ startPos, 
                /*uint*/int posLen)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      EmitFormatDiagnostic($c$.track(S.PDiag(diag.warn_format_non_standard_positional_arg)), 
          getLocationOfByte(startPos), 
          /*IsStringLocation*/ true, 
          getSpecifierRange(startPos, posLen)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandleInvalidPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4359,
   FQN="(anonymous namespace)::CheckFormatHandler::HandleInvalidPosition", NM="_ZN12_GLOBAL__N_118CheckFormatHandler21HandleInvalidPositionEPKcjN5clang21analyze_format_string15PositionContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler21HandleInvalidPositionEPKcjN5clang21analyze_format_string15PositionContextE")
  //</editor-fold>
  @Override public void HandleInvalidPosition(/*const*/char$ptr/*char P*/ startPos, /*uint*/int posLen, 
                       PositionContext p)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_uint($c$.track(S.PDiag(diag.warn_format_invalid_positional_specifier)), 
                  (/*uint*/int)p.getValue()))), 
          getLocationOfByte(startPos), /*IsStringLocation*/ true, 
          getSpecifierRange(startPos, posLen)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandleZeroPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4368,
   FQN="(anonymous namespace)::CheckFormatHandler::HandleZeroPosition", NM="_ZN12_GLOBAL__N_118CheckFormatHandler18HandleZeroPositionEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler18HandleZeroPositionEPKcj")
  //</editor-fold>
  @Override public void HandleZeroPosition(/*const*/char$ptr/*char P*/ startPos, 
                    /*uint*/int posLen)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      EmitFormatDiagnostic($c$.track(S.PDiag(diag.warn_format_zero_positional_specifier)), 
          getLocationOfByte(startPos), 
          /*IsStringLocation*/ true, 
          getSpecifierRange(startPos, posLen)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandleNullChar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4376,
   FQN="(anonymous namespace)::CheckFormatHandler::HandleNullChar", NM="_ZN12_GLOBAL__N_118CheckFormatHandler14HandleNullCharEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler14HandleNullCharEPKc")
  //</editor-fold>
  @Override public void HandleNullChar(/*const*/char$ptr/*char P*/ nullCharacter)/* override*/ {
    if (!isa_ObjCStringLiteral(OrigFormatExpr)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // The presence of a null character is likely an error.
        EmitFormatDiagnostic($c$.track(S.PDiag(diag.warn_printf_format_string_contains_null_char)), 
            getLocationOfByte(nullCharacter), /*IsStringLocation*/ true, 
            getFormatStringRange()); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /*template <typename Range> TEMPLATE*/
  
  /// \brief If the format string is not within the funcion call, emit a note
  /// so that the function call and string are in diagnostic messages.
  ///
  /// \param InFunctionCall if true, the format string is within the function
  /// call and only one diagnostic message will be produced.  Otherwise, an
  /// extra note will be emitted pointing to location of the format string.
  ///
  /// \param ArgumentExpr the expression that is passed as the format string
  /// argument in the function call.  Used for getting locations when two
  /// diagnostics are emitted.
  ///
  /// \param PDiag the callee should already have provided any strings for the
  /// diagnostic message.  This function only adds locations and fixits
  /// to diagnostics.
  ///
  /// \param Loc primary location for diagnostic.  If two diagnostics are
  /// required, one will be at Loc and a new SourceLocation will be created for
  /// the other one.
  ///
  /// \param IsStringLocation if true, Loc points to the format string should be
  /// used for the note.  Otherwise, Loc points to the argument list and will
  /// be used with PDiag.
  ///
  /// \param StringRange some or all of the string to highlight.  This is
  /// templated so it can accept either a CharSourceRange or a SourceRange.
  ///
  /// \param FixIt optional fix it hint for the format string.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::EmitFormatDiagnostic">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use extracted Range interface and special $out for Range*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4560,
   FQN="(anonymous namespace)::CheckFormatHandler::EmitFormatDiagnostic", NM="Tpl__ZN12_GLOBAL__N_118CheckFormatHandler20EmitFormatDiagnosticERN5clang4SemaEbPKNS1_4ExprERKNS1_17PartialDiagnosticENS1_14SourceLocationEbT_N4llvm8ArrayRefINS1_9FixItHintEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=Tpl__ZN12_GLOBAL__N_118CheckFormatHandler20EmitFormatDiagnosticERN5clang4SemaEbPKNS1_4ExprERKNS1_17PartialDiagnosticENS1_14SourceLocationEbT_N4llvm8ArrayRefINS1_9FixItHintEEE")
  //</editor-fold>
  public static </*typename*/ Range extends RangeBase> void EmitFormatDiagnostic(final Sema /*&*/ S, boolean InFunctionCall, /*const*/ Expr /*P*/ ArgumentExpr, 
                      final /*const*/ PartialDiagnostic /*&*/ PDiag, SourceLocation Loc, boolean IsStringLocation, 
                      Range StringRange) {
    EmitFormatDiagnostic(S, InFunctionCall, ArgumentExpr, 
                      PDiag, Loc, IsStringLocation, 
                      StringRange, new ArrayRef<FixItHint>(None, false));
  }
  public static </*typename*/ Range extends RangeBase> void EmitFormatDiagnostic(final Sema /*&*/ S, boolean InFunctionCall, /*const*/ Expr /*P*/ ArgumentExpr, 
                      final /*const*/ PartialDiagnostic /*&*/ PDiag, SourceLocation Loc, boolean IsStringLocation, 
                      Range StringRange, ArrayRef<FixItHint> FixIt/*= None*/) {
    if (InFunctionCall) {
      /*const*/ Sema.SemaDiagnosticBuilder /*&*/  D = null;
      try {
        /*final */ D = S.Diag(new SourceLocation(Loc), PDiag);
        $out_SemaDiagnosticBuilder_Range(D, StringRange);
        $out_SemaDiagnosticBuilder_ArrayRef$FixItHint(D, FixIt);
      } finally {
        if (D != null) { D.$destroy(); }
      }
    } else {
      /*const*/ Sema.SemaDiagnosticBuilder /*&*/  Note = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder_SourceRange($c$.track(S.Diag(IsStringLocation ? ArgumentExpr.getExprLoc() : new SourceLocation(Loc), PDiag)), 
            ArgumentExpr.getSourceRange()));

        /*final */ Note = S.Diag(IsStringLocation ? new SourceLocation(Loc) : StringRange.getBegin(), 
            diag.note_format_string_defined);

        $out_SemaDiagnosticBuilder_Range(Note, StringRange);
        $out_SemaDiagnosticBuilder_ArrayRef$FixItHint(Note, FixIt);
      } finally {
        if (Note != null) { Note.$destroy(); }
        $c$.$destroy();
      }
    }
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandleInvalidConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4431,
   FQN="(anonymous namespace)::CheckFormatHandler::HandleInvalidConversionSpecifier", NM="_ZN12_GLOBAL__N_118CheckFormatHandler32HandleInvalidConversionSpecifierEjN5clang14SourceLocationEPKcjS4_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler32HandleInvalidConversionSpecifierEjN5clang14SourceLocationEPKcjS4_j")
  //</editor-fold>
  protected boolean HandleInvalidConversionSpecifier(/*uint*/int argIndex, 
                                  SourceLocation Loc, 
                                  /*const*/char$ptr/*char P*/ startSpec, 
                                  /*uint*/int specifierLen, 
                                  /*const*/char$ptr/*char P*/ csStart, 
                                  /*uint*/int csLen) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean keepGoing = true;
      if ($less_uint(argIndex, NumDataArgs)) {
        // Consider the argument coverered, even though the specifier doesn't
        // make sense.
        CoveredArgs.set(argIndex);
      } else {
        // If argIndex exceeds the number of data arguments we
        // don't issue a warning because that is just a cascade of warnings (and
        // they may have intended '%%' anyway). We don't want to continue processing
        // the format string after this point, however, as we will like just get
        // gibberish when trying to match arguments.
        keepGoing = false;
      }
      
      StringRef Specifier/*J*/= new StringRef(csStart, csLen);
      
      // If the specifier in non-printable, it could be the first byte of a UTF-8
      // sequence. In that case, print the UTF-8 code point. If not, print the byte
      // hex value.
      std.string CodePointStr/*J*/= new std.string();
      if (!locale.isPrint(csStart.$star())) {
        raw_string_ostream OS = null;
        try {
          uint$ptr CodePoint = create_uint$ptr();
          /*const*/type$ptr<char$ptr>/*UTF8 P P*/ B = $tryClone(((/*const*/type$ptr<char$ptr>/*UTF8 P P*/ )reinterpret_cast(/*const*/type$ptr.class, csStart.$addr())));
          /*const*/char$ptr/*UTF8 P*/ E = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, csStart.$add(csLen)));
          ConversionResult Result = llvm.convertUTF8Sequence(B, E, $AddrOf(CodePoint), ConversionFlags.strictConversion);
          if (Result != ConversionResult.conversionOK) {
            /*uchar*/byte FirstChar = csStart.$star();
            CodePoint.$set((int/*UTF32*/)$uchar2uint(FirstChar));
          }
          
          OS/*J*/= new raw_string_ostream(CodePointStr);
          if ($less_uint(CodePoint.$star(), 256)) {
            OS.$out(/*KEEP_STR*/"\\x").$out(llvm.format_uint(/*KEEP_STR*/"%02x", CodePoint));
          } else if ($lesseq_uint(CodePoint.$star(), 0xFFFF)) {
            OS.$out(/*KEEP_STR*/"\\u").$out(llvm.format_uint(/*KEEP_STR*/"%04x", CodePoint));
          } else {
            OS.$out(/*KEEP_STR*/"\\U").$out(llvm.format_uint(/*KEEP_STR*/"%08x", CodePoint));
          }
          OS.flush();
          Specifier.$assignMove(new StringRef(CodePointStr));
        } finally {
          if (OS != null) { OS.$destroy(); }
        }
      }
      
      EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_format_invalid_conversion)), /*NO_COPY*/Specifier))), new SourceLocation(Loc), 
          /*IsStringLocation*/ true, getSpecifierRange(startSpec, specifierLen)); $c$.clean();
      
      return keepGoing;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::HandlePositionalNonpositionalArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4490,
   FQN="(anonymous namespace)::CheckFormatHandler::HandlePositionalNonpositionalArgs", NM="_ZN12_GLOBAL__N_118CheckFormatHandler33HandlePositionalNonpositionalArgsEN5clang14SourceLocationEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler33HandlePositionalNonpositionalArgsEN5clang14SourceLocationEPKcj")
  //</editor-fold>
  protected void HandlePositionalNonpositionalArgs(SourceLocation Loc, 
                                   /*const*/char$ptr/*char P*/ startSpec, 
                                   /*uint*/int specifierLen) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      EmitFormatDiagnostic($c$.track(S.PDiag(diag.warn_format_mix_positional_nonpositional_args)), 
          new SourceLocation(Loc), /*isStringLoc*/ true, getSpecifierRange(startSpec, specifierLen)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::getFormatStringRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4233,
   FQN="(anonymous namespace)::CheckFormatHandler::getFormatStringRange", NM="_ZN12_GLOBAL__N_118CheckFormatHandler20getFormatStringRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler20getFormatStringRangeEv")
  //</editor-fold>
  protected SourceRange getFormatStringRange() {
    return OrigFormatExpr.getSourceRange();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::getSpecifierRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4237,
   FQN="(anonymous namespace)::CheckFormatHandler::getSpecifierRange", NM="_ZN12_GLOBAL__N_118CheckFormatHandler17getSpecifierRangeEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler17getSpecifierRangeEPKcj")
  //</editor-fold>
  protected CharSourceRange getSpecifierRange(/*const*/char$ptr/*char P*/ startSpecifier, /*uint*/int specifierLen) {
    SourceLocation Start = getLocationOfByte(startSpecifier);
    SourceLocation End = getLocationOfByte(startSpecifier.$add(specifierLen).$sub(1));
    
    // Advance the end SourceLocation by one due to half-open ranges.
    End.$assignMove(End.getLocWithOffset(1));
    
    return CharSourceRange.getCharRange(/*NO_COPY*/Start, /*NO_COPY*/End);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::getLocationOfByte">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4248,
   FQN="(anonymous namespace)::CheckFormatHandler::getLocationOfByte", NM="_ZN12_GLOBAL__N_118CheckFormatHandler17getLocationOfByteEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler17getLocationOfByteEPKc")
  //</editor-fold>
  protected SourceLocation getLocationOfByte(/*const*/char$ptr/*char P*/ x) {
    return S.getLocationOfStringLiteralByte(FExpr, x.$sub(Beg));
  }

  
  
  // Note that this may return NULL if there was an error parsing or building
  // one of the argument expressions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::getDataArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4388,
   FQN="(anonymous namespace)::CheckFormatHandler::getDataArg", NM="_ZNK12_GLOBAL__N_118CheckFormatHandler10getDataArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZNK12_GLOBAL__N_118CheckFormatHandler10getDataArgEj")
  //</editor-fold>
  protected /*const*/ Expr /*P*/ getDataArg(/*uint*/int i) /*const*/ {
    return Args.$at(FirstDataArg + i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::CheckNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4499,
   FQN="(anonymous namespace)::CheckFormatHandler::CheckNumArgs", NM="_ZN12_GLOBAL__N_118CheckFormatHandler12CheckNumArgsERKN5clang21analyze_format_string15FormatSpecifierERKNS2_19ConversionSpecifierEPKcjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandler12CheckNumArgsERKN5clang21analyze_format_string15FormatSpecifierERKNS2_19ConversionSpecifierEPKcjj")
  //</editor-fold>
  protected boolean CheckNumArgs(final /*const*/ FormatSpecifier /*&*/ FS, 
              final /*const*/ ConversionSpecifier /*&*/ CS, 
              /*const*/char$ptr/*char P*/ startSpecifier, /*uint*/int specifierLen, /*uint*/int argIndex) {
    if ($greatereq_uint(argIndex, NumDataArgs)) {
      PartialDiagnostic PDiag = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        PDiag = $c$.clean(FS.usesPositionalArg() ? new PartialDiagnostic((PartialDiagnostic.$out_PartialDiagnostic$C_uint(PartialDiagnostic.$out_PartialDiagnostic$C_uint($c$.track(S.PDiag(diag.warn_printf_positional_arg_exceeds_data_args)), 
                    (argIndex + 1)), NumDataArgs))) : S.PDiag(diag.warn_printf_insufficient_data_args));
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic(PDiag)), getLocationOfByte(CS.getStart()), /*IsStringLocation*/ true, 
            getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
        
        // Since more arguments than conversion tokens are given, by extension
        // all arguments are covered, so mark this as so.
        UncoveredArg.setAllCovered();
        return false;
      } finally {
        if (PDiag != null) { PDiag.$destroy(); }
        $c$.$destroy();
      }
    }
    return true;
  }

  
  /*template <typename Range> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::EmitFormatDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4523,
   FQN="(anonymous namespace)::CheckFormatHandler::EmitFormatDiagnostic", NM="Tpl__ZN12_GLOBAL__N_118CheckFormatHandler20EmitFormatDiagnosticEN5clang17PartialDiagnosticENS1_14SourceLocationEbT_N4llvm8ArrayRefINS1_9FixItHintEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=Tpl__ZN12_GLOBAL__N_118CheckFormatHandler20EmitFormatDiagnosticEN5clang17PartialDiagnosticENS1_14SourceLocationEbT_N4llvm8ArrayRefINS1_9FixItHintEEE")
  //</editor-fold>
  protected </*typename*/ Range extends RangeBase> void EmitFormatDiagnostic(PartialDiagnostic PDiag, 
                      SourceLocation Loc, 
                      boolean IsStringLocation, 
                      Range StringRange) {
    EmitFormatDiagnostic(PDiag, 
                      Loc, 
                      IsStringLocation, 
                      StringRange, 
                      new ArrayRef<FixItHint>(None, false));
  }
  protected </*typename*/ Range extends RangeBase> void EmitFormatDiagnostic(PartialDiagnostic PDiag, 
                      SourceLocation Loc, 
                      boolean IsStringLocation, 
                      Range StringRange, 
                      ArrayRef<FixItHint> FixIt/*= None*/) {
    EmitFormatDiagnostic(S, inFunctionCall, Args.$at(FormatIdx), PDiag, 
        Loc, IsStringLocation, StringRange, FixIt);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckFormatHandler::~CheckFormatHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4129,
   FQN="(anonymous namespace)::CheckFormatHandler::~CheckFormatHandler", NM="_ZN12_GLOBAL__N_118CheckFormatHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckFormatHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CoveredArgs.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", FExpr=" + FExpr // NOI18N
              + ", OrigFormatExpr=" + OrigFormatExpr // NOI18N
              + ", FirstDataArg=" + FirstDataArg // NOI18N
              + ", NumDataArgs=" + NumDataArgs // NOI18N
              + ", Beg=" + Beg // NOI18N
              + ", HasVAListArg=" + HasVAListArg // NOI18N
              + ", Args=" + Args // NOI18N
              + ", FormatIdx=" + FormatIdx // NOI18N
              + ", CoveredArgs=" + CoveredArgs // NOI18N
              + ", usesPositionalArgs=" + usesPositionalArgs // NOI18N
              + ", atFirstArg=" + atFirstArg // NOI18N
              + ", inFunctionCall=" + inFunctionCall // NOI18N
              + ", CallType=" + CallType // NOI18N
              + ", CheckedVarArgs=" + CheckedVarArgs // NOI18N
              + ", UncoveredArg=" + "[UncoveredArgHandler]" // NOI18N
              + super.toString(); // NOI18N
  }
}
