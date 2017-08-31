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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
;
import org.clang.analysis.analyses.analyze_format_string.*;
import org.clang.analysis.analyses.analyze_scanf.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.ast.AstClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckScanfHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5373,
 FQN="(anonymous namespace)::CheckScanfHandler", NM="_ZN12_GLOBAL__N_117CheckScanfHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_117CheckScanfHandlerE")
//</editor-fold>
public class CheckScanfHandler extends /*public*/ CheckFormatHandler implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckScanfHandler::CheckScanfHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5375,
   FQN="(anonymous namespace)::CheckScanfHandler::CheckScanfHandler", NM="_ZN12_GLOBAL__N_117CheckScanfHandlerC1ERN5clang4SemaEPKNS1_13StringLiteralEPKNS1_4ExprEjjPKcbN4llvm8ArrayRefIS9_EEjbNS2_16VariadicCallTypeERNSC_14SmallBitVectorERNS_19UncoveredArgHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_117CheckScanfHandlerC1ERN5clang4SemaEPKNS1_13StringLiteralEPKNS1_4ExprEjjPKcbN4llvm8ArrayRefIS9_EEjbNS2_16VariadicCallTypeERNSC_14SmallBitVectorERNS_19UncoveredArgHandlerE")
  //</editor-fold>
  public CheckScanfHandler(final Sema /*&*/ s, /*const*/ StringLiteral /*P*/ fexpr, 
      /*const*/ Expr /*P*/ origFormatExpr, /*uint*/int firstDataArg, 
      /*uint*/int numDataArgs, /*const*/char$ptr/*char P*/ beg, boolean hasVAListArg, 
      ArrayRef</*const*/ Expr /*P*/ > Args, 
      /*uint*/int formatIdx, boolean inFunctionCall, 
      Sema.VariadicCallType CallType, 
      final SmallBitVector /*&*/ CheckedVarArgs, 
      final UncoveredArgHandler /*&*/ UncoveredArg) {
    // : CheckFormatHandler(s, fexpr, origFormatExpr, firstDataArg, numDataArgs, beg, hasVAListArg, Args, formatIdx, inFunctionCall, CallType, CheckedVarArgs, UncoveredArg) 
    //START JInit
    super(s, fexpr, origFormatExpr, firstDataArg, 
        numDataArgs, beg, hasVAListArg, 
        new ArrayRef</*const*/ Expr /*P*/ >(Args), formatIdx, inFunctionCall, CallType, 
        CheckedVarArgs, UncoveredArg);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckScanfHandler::HandleScanfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5423,
   FQN="(anonymous namespace)::CheckScanfHandler::HandleScanfSpecifier", NM="_ZN12_GLOBAL__N_117CheckScanfHandler20HandleScanfSpecifierERKN5clang13analyze_scanf14ScanfSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_117CheckScanfHandler20HandleScanfSpecifierERKN5clang13analyze_scanf14ScanfSpecifierEPKcj")
  //</editor-fold>
  @Override public boolean HandleScanfSpecifier(final /*const*/ ScanfSpecifier /*&*/ FS, 
                      /*const*/char$ptr/*char P*/ startSpecifier, 
                      /*uint*/int specifierLen)/* override*/ {
    //JAVA: using namespace analyze_scanf;
    //JAVA: using namespace analyze_format_string;
    
    final /*const*/ ScanfConversionSpecifier /*&*/ CS = FS.getConversionSpecifier();
    
    // Handle case where '%' and '*' don't consume an argument.  These shouldn't
    // be used to decide if we are using positional arguments consistently.
    if (FS.consumesDataArgument()) {
      if (atFirstArg) {
        atFirstArg = false;
        usesPositionalArgs = FS.usesPositionalArg();
      } else if (usesPositionalArgs != FS.usesPositionalArg()) {
        HandlePositionalNonpositionalArgs(getLocationOfByte(CS.getStart()), 
            startSpecifier, specifierLen);
        return false;
      }
    }
    
    // Check if the field with is non-zero.
    final /*const*/ OptionalAmount /*&*/ Amt = FS.getFieldWidth();
    if (Amt.getHowSpecified() == OptionalAmount.HowSpecified.Constant) {
      if (Amt.getConstantAmount() == 0) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          final /*const*/ CharSourceRange /*&*/ R = getSpecifierRange(Amt.getStart(), 
              Amt.getConstantLength());
          EmitFormatDiagnostic($c$.track(S.PDiag(diag.warn_scanf_nonzero_width)), 
              getLocationOfByte(Amt.getStart()), 
              /*IsStringLocation*/ true, new CharSourceRange(R), 
              new ArrayRef<FixItHint>(FixItHint.CreateRemoval(/*NO_COPY*/R), false)); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!FS.consumesDataArgument()) {
      // FIXME: Technically specifying a precision or field width here
      // makes no sense.  Worth issuing a warning at some point.
      return true;
    }
    
    // Consume the argument.
    /*uint*/int argIndex = FS.getArgIndex();
    if ($less_uint(argIndex, NumDataArgs)) {
      // The check to see if the argIndex is valid will come later.
      // We set the bit here because we may exit early from this
      // function if we encounter some other error.
      CoveredArgs.set(argIndex);
    }
    
    // Check the length modifier is valid with the given conversion specifier.
    if (!FS.hasValidLengthModifier(S.getASTContext().getTargetInfo())) {
      HandleInvalidLengthModifier(FS, CS, startSpecifier, specifierLen, 
          diag.warn_format_nonsensical_length);
    } else if (!FS.hasStandardLengthModifier()) {
      HandleNonStandardLengthModifier(FS, startSpecifier, specifierLen);
    } else if (!FS.hasStandardLengthConversionCombination()) {
      HandleInvalidLengthModifier(FS, CS, startSpecifier, specifierLen, 
          diag.warn_format_non_standard_conversion_spec);
    }
    if (!FS.hasStandardConversionSpecifier(S.getLangOpts())) {
      HandleNonStandardConversionSpecifier(CS, startSpecifier, specifierLen);
    }
    
    // The remaining checks depend on the data arguments.
    if (HasVAListArg) {
      return true;
    }
    if (!CheckNumArgs(FS, CS, startSpecifier, specifierLen, argIndex)) {
      return false;
    }
    
    // Check that the argument type matches the format specifier.
    /*const*/ Expr /*P*/ Ex = getDataArg(argIndex);
    if (!(Ex != null)) {
      return true;
    }
    
    final /*const*/ ArgType /*&*/ AT = FS.getArgType(S.Context);
    if (!AT.isValid()) {
      return true;
    }
    
    ArgType.MatchKind match = AT.matchesType(S.Context, Ex.getType());
    if (match == ArgType.MatchKind.Match) {
      return true;
    }
    
    ScanfSpecifier fixedFS = new ScanfSpecifier(FS);
    boolean success = fixedFS.fixType(Ex.getType(), Ex.IgnoreImpCasts$Const().getType(), 
        S.getLangOpts(), S.Context);
    
    /*uint*/int _diag = diag.warn_format_conversion_argument_type_mismatch;
    if (match == ArgType.MatchKind.NoMatchPedantic) {
      _diag = diag.warn_format_conversion_argument_type_mismatch_pedantic;
    }
    if (success) {
      raw_svector_ostream os = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Get the fix string from the fixed format specifier.
        SmallString/*128*/ buf/*J*/= new SmallString/*128*/(128);
        os/*J*/= new raw_svector_ostream(buf);
        fixedFS.__toString(os);
        
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(_diag)), new StringRef(AT.getRepresentativeTypeName(S.Context))), 
                            Ex.getType()), /*false*/0), Ex.getSourceRange()))), 
            Ex.getLocStart(), 
            /*IsStringLocation*/ false, 
            getSpecifierRange(startSpecifier, specifierLen), 
            new ArrayRef<FixItHint>(FixItHint.CreateReplacement(getSpecifierRange(startSpecifier, specifierLen), os.str()), false)); $c$.clean();
      } finally {
        if (os != null) { os.$destroy(); }
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(_diag)), 
                                new StringRef(AT.getRepresentativeTypeName(S.Context))), 
                            Ex.getType()), /*false*/0), Ex.getSourceRange()))), 
            Ex.getLocStart(), 
            /*IsStringLocation*/ false, 
            getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckScanfHandler::HandleInvalidScanfConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5409,
   FQN="(anonymous namespace)::CheckScanfHandler::HandleInvalidScanfConversionSpecifier", NM="_ZN12_GLOBAL__N_117CheckScanfHandler37HandleInvalidScanfConversionSpecifierERKN5clang13analyze_scanf14ScanfSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_117CheckScanfHandler37HandleInvalidScanfConversionSpecifierERKN5clang13analyze_scanf14ScanfSpecifierEPKcj")
  //</editor-fold>
  @Override public boolean HandleInvalidScanfConversionSpecifier(final /*const*/ ScanfSpecifier /*&*/ FS, 
                                       /*const*/char$ptr/*char P*/ startSpecifier, 
                                       /*uint*/int specifierLen)/* override*/ {
    
    final /*const*/ ScanfConversionSpecifier /*&*/ CS = FS.getConversionSpecifier();
    
    return HandleInvalidConversionSpecifier(FS.getArgIndex(), 
        getLocationOfByte(CS.getStart()), 
        startSpecifier, specifierLen, 
        CS.getStart(), CS.getLength());
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckScanfHandler::HandleIncompleteScanList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5402,
   FQN="(anonymous namespace)::CheckScanfHandler::HandleIncompleteScanList", NM="_ZN12_GLOBAL__N_117CheckScanfHandler24HandleIncompleteScanListEPKcS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_117CheckScanfHandler24HandleIncompleteScanListEPKcS2_")
  //</editor-fold>
  @Override public void HandleIncompleteScanList(/*const*/char$ptr/*char P*/ start, 
                          /*const*/char$ptr/*char P*/ end)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      EmitFormatDiagnostic($c$.track(S.PDiag(diag.warn_scanf_scanlist_incomplete)), 
          getLocationOfByte(end), /*IsStringLocation*/ true, 
          getSpecifierRange(start, end.$sub(start))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckScanfHandler::~CheckScanfHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5373,
   FQN="(anonymous namespace)::CheckScanfHandler::~CheckScanfHandler", NM="_ZN12_GLOBAL__N_117CheckScanfHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_117CheckScanfHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
