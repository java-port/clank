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
import static org.clank.support.NativePointer.*;
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
import org.clang.analysis.analyses.analyze_printf.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaCheckingStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4584,
 FQN="(anonymous namespace)::CheckPrintfHandler", NM="_ZN12_GLOBAL__N_118CheckPrintfHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandlerE")
//</editor-fold>
public class CheckPrintfHandler extends /*public*/ CheckFormatHandler implements Destructors.ClassWithDestructor {
  private boolean ObjCContext;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::CheckPrintfHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4588,
   FQN="(anonymous namespace)::CheckPrintfHandler::CheckPrintfHandler", NM="_ZN12_GLOBAL__N_118CheckPrintfHandlerC1ERN5clang4SemaEPKNS1_13StringLiteralEPKNS1_4ExprEjjbPKcbN4llvm8ArrayRefIS9_EEjbNS2_16VariadicCallTypeERNSC_14SmallBitVectorERNS_19UncoveredArgHandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandlerC1ERN5clang4SemaEPKNS1_13StringLiteralEPKNS1_4ExprEjjbPKcbN4llvm8ArrayRefIS9_EEjbNS2_16VariadicCallTypeERNSC_14SmallBitVectorERNS_19UncoveredArgHandlerE")
  //</editor-fold>
  public CheckPrintfHandler(final Sema /*&*/ s, /*const*/ StringLiteral /*P*/ fexpr, 
      /*const*/ Expr /*P*/ origFormatExpr, /*uint*/int firstDataArg, 
      /*uint*/int numDataArgs, boolean isObjC, 
      /*const*/char$ptr/*char P*/ beg, boolean hasVAListArg, 
      ArrayRef</*const*/ Expr /*P*/ > Args, 
      /*uint*/int formatIdx, boolean inFunctionCall, 
      Sema.VariadicCallType CallType, 
      final SmallBitVector /*&*/ CheckedVarArgs, 
      final UncoveredArgHandler /*&*/ UncoveredArg) {
    // : CheckFormatHandler(s, fexpr, origFormatExpr, firstDataArg, numDataArgs, beg, hasVAListArg, Args, formatIdx, inFunctionCall, CallType, CheckedVarArgs, UncoveredArg), ObjCContext(isObjC) 
    //START JInit
    super(s, fexpr, origFormatExpr, firstDataArg, 
        numDataArgs, beg, hasVAListArg, new ArrayRef</*const*/ Expr /*P*/ >(Args), 
        formatIdx, inFunctionCall, CallType, CheckedVarArgs, 
        UncoveredArg);
    this.ObjCContext = isObjC;
    //END JInit
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandleInvalidPrintfConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4646,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandleInvalidPrintfConversionSpecifier", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler38HandleInvalidPrintfConversionSpecifierERKN5clang14analyze_printf15PrintfSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler38HandleInvalidPrintfConversionSpecifierERKN5clang14analyze_printf15PrintfSpecifierEPKcj")
  //</editor-fold>
  @Override public boolean HandleInvalidPrintfConversionSpecifier(final /*const*/ PrintfSpecifier /*&*/ FS, 
                                        /*const*/char$ptr/*char P*/ startSpecifier, 
                                        /*uint*/int specifierLen)/* override*/ {
    final /*const*/ PrintfConversionSpecifier /*&*/ CS = FS.getConversionSpecifier();
    
    return HandleInvalidConversionSpecifier(FS.getArgIndex(), 
        getLocationOfByte(CS.getStart()), 
        startSpecifier, specifierLen, 
        CS.getStart(), CS.getLength());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandlePrintfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4869,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandlePrintfSpecifier", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler21HandlePrintfSpecifierERKN5clang14analyze_printf15PrintfSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler21HandlePrintfSpecifierERKN5clang14analyze_printf15PrintfSpecifierEPKcj")
  //</editor-fold>
  @Override public boolean HandlePrintfSpecifier(final /*const*/ PrintfSpecifier /*&*/ FS, 
                       /*const*/char$ptr/*char P*/ startSpecifier, 
                       /*uint*/int specifierLen)/* override*/ {
    //JAVA: using namespace analyze_format_string;
    //JAVA: using namespace analyze_printf;
    final /*const*/ PrintfConversionSpecifier /*&*/ CS = FS.getConversionSpecifier();
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
    
    // First check if the field width, precision, and conversion specifier
    // have matching data arguments.
    if (!HandleAmount(FS.getFieldWidth(), /* field width */ 0, 
        startSpecifier, specifierLen)) {
      return false;
    }
    if (!HandleAmount(FS.getPrecision(), /* precision */ 1, 
        startSpecifier, specifierLen)) {
      return false;
    }
    if (!CS.consumesDataArgument()) {
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
    
    // FreeBSD kernel extensions.
    if (CS.getKind() == ConversionSpecifier.Kind.FreeBSDbArg
       || CS.getKind() == ConversionSpecifier.Kind.FreeBSDDArg) {
      // We need at least two arguments.
      if (!CheckNumArgs(FS, CS, startSpecifier, specifierLen, argIndex + 1)) {
        return false;
      }
      
      // Claim the second argument.
      CoveredArgs.set(argIndex + 1);
      
      // Type check the first argument (int for %b, pointer for %D)
      /*const*/ Expr /*P*/ Ex = getDataArg(argIndex);
      final /*const*/ ArgType /*&*/ AT = (CS.getKind() == ConversionSpecifier.Kind.FreeBSDbArg) ? new ArgType(new CanQual<Type>(S.Context.IntTy)) : new ArgType(ArgType.Kind.CPointerTy);
      if (AT.isValid() && !(AT.matchesType(S.Context, Ex.getType()).getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_format_conversion_argument_type_mismatch)), 
                                  new StringRef(AT.getRepresentativeTypeName(S.Context))), Ex.getType()), 
                          /*false*/0), Ex.getSourceRange()))), 
              Ex.getLocStart(), /*IsStringLocation*/ false, 
              getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Type check the second argument (char * for both %b and %D)
      Ex = getDataArg(argIndex + 1);
      final /*const*/ ArgType /*&*/ AT2 = new ArgType(ArgType.Kind.CStrTy);
      if (AT2.isValid() && !(AT2.matchesType(S.Context, Ex.getType()).getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_format_conversion_argument_type_mismatch)), 
                                  new StringRef(AT2.getRepresentativeTypeName(S.Context))), Ex.getType()), 
                          /*false*/0), Ex.getSourceRange()))), 
              Ex.getLocStart(), /*IsStringLocation*/ false, 
              getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      
      return true;
    }
    
    // Check for using an Objective-C specific conversion specifier
    // in a non-ObjC literal.
    if (!ObjCContext && CS.isObjCArg()) {
      return HandleInvalidPrintfConversionSpecifier(FS, startSpecifier, 
          specifierLen);
    }
    
    // Check for invalid use of field width
    if (!FS.hasValidFieldWidth()) {
      HandleInvalidAmount(FS, FS.getFieldWidth(), /* field width */ 0, 
          startSpecifier, specifierLen);
    }
    
    // Check for invalid use of precision
    if (!FS.hasValidPrecision()) {
      HandleInvalidAmount(FS, FS.getPrecision(), /* precision */ 1, 
          startSpecifier, specifierLen);
    }
    
    // Check each flag does not conflict with any other component.
    if (!FS.hasValidThousandsGroupingPrefix()) {
      HandleFlag(FS, FS.hasThousandsGrouping(), startSpecifier, specifierLen);
    }
    if (!FS.hasValidLeadingZeros()) {
      HandleFlag(FS, FS.hasLeadingZeros(), startSpecifier, specifierLen);
    }
    if (!FS.hasValidPlusPrefix()) {
      HandleFlag(FS, FS.hasPlusPrefix(), startSpecifier, specifierLen);
    }
    if (!FS.hasValidSpacePrefix()) {
      HandleFlag(FS, FS.hasSpacePrefix(), startSpecifier, specifierLen);
    }
    if (!FS.hasValidAlternativeForm()) {
      HandleFlag(FS, FS.hasAlternativeForm(), startSpecifier, specifierLen);
    }
    if (!FS.hasValidLeftJustified()) {
      HandleFlag(FS, FS.isLeftJustified(), startSpecifier, specifierLen);
    }
    
    // Check that flags are not ignored by another flag
    if (FS.hasSpacePrefix().$bool() && FS.hasPlusPrefix().$bool()) { // ' ' ignored by '+'
      HandleIgnoredFlag(FS, FS.hasSpacePrefix(), FS.hasPlusPrefix(), 
          startSpecifier, specifierLen);
    }
    if (FS.hasLeadingZeros().$bool() && FS.isLeftJustified().$bool()) { // '0' ignored by '-'
      HandleIgnoredFlag(FS, FS.hasLeadingZeros(), FS.isLeftJustified(), 
          startSpecifier, specifierLen);
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
    
    /*const*/ Expr /*P*/ Arg = getDataArg(argIndex);
    if (!(Arg != null)) {
      return true;
    }
    
    return checkFormatExpr(FS, startSpecifier, specifierLen, Arg);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::checkFormatExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*unfold std.tie*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5113,
   FQN="(anonymous namespace)::CheckPrintfHandler::checkFormatExpr", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler15checkFormatExprERKN5clang14analyze_printf15PrintfSpecifierEPKcjPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler15checkFormatExprERKN5clang14analyze_printf15PrintfSpecifierEPKcjPKNS1_4ExprE")
  //</editor-fold>
  public boolean checkFormatExpr(final /*const*/ PrintfSpecifier /*&*/ FS, 
                 /*const*/char$ptr/*char P*/ StartSpecifier, 
                 /*uint*/int SpecifierLen, 
                 /*const*/ Expr /*P*/ E) {
    //JAVA: using namespace analyze_format_string;
    //JAVA: using namespace analyze_printf;
    // Now type check the data expression that matches the
    // format specifier.
    final /*const*/ ArgType /*&*/ AT = FS.getArgType(S.Context, 
        ObjCContext);
    if (!AT.isValid()) {
      return true;
    }
    
    QualType ExprTy = E.getType();
    {
      /*const*/ TypeOfExprType /*P*/ TET;
      while (((/*P*/ TET = dyn_cast_TypeOfExprType(ExprTy)) != null)) {
        ExprTy.$assignMove(TET.getUnderlyingExpr().getType());
      }
    }
    
    ArgType.MatchKind match = AT.matchesType(S.Context, new QualType(ExprTy));
    if (match == ArgType.MatchKind.Match) {
      return true;
    }
    {
      
      // Look through argument promotions for our error message's reported type.
      // This includes the integral and floating promotions, but excludes array
      // and function pointer decay; seeing that an argument intended to be a
      // string has type 'char [6]' is probably more confusing than 'char *'.
      /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(E);
      if ((ICE != null)) {
        if (ICE.getCastKind() == CastKind.CK_IntegralCast
           || ICE.getCastKind() == CastKind.CK_FloatingCast) {
          E = ICE.getSubExpr$Const();
          ExprTy.$assignMove(E.getType());
          
          // Check if we didn't match because of an implicit cast from a 'char'
          // or 'short' to an 'int'.  This is done because printf is a varargs
          // function.
          if ($eq_QualType$C(ICE.getType(), S.Context.IntTy.$QualType())
             || $eq_QualType$C(ICE.getType(), S.Context.UnsignedIntTy.$QualType())) {
            // All further checking is done on the subexpression.
            if ((AT.matchesType(S.Context, new QualType(ExprTy)).getValue() != 0)) {
              return true;
            }
          }
        }
      } else {
        /*const*/ CharacterLiteral /*P*/ CL = dyn_cast_CharacterLiteral(E);
        if ((CL != null)) {
          // Special case for 'a', which has type 'int' in C.
          // Note, however, that we do /not/ want to treat multibyte constants like
          // 'MooV' as characters! This form is deprecated but still exists.
          if ($eq_QualType$C(ExprTy, S.Context.IntTy.$QualType())) {
            if (llvm.isUIntN($ulong2uint(S.Context.getCharWidth()), $uint2ulong(CL.getValue()))) {
              ExprTy.$assignMove(S.Context.CharTy.$QualType());
            }
          }
        }
      }
    }
    
    // Look through enums to their underlying type.
    boolean IsEnum = false;
    {
      /*const*/ EnumType /*P*/ EnumTy = ExprTy.$arrow().<EnumType>getAs$EnumType();
      if ((EnumTy != null)) {
        ExprTy.$assignMove(EnumTy.getDecl().getIntegerType());
        IsEnum = true;
      }
    }
    
    // %C in an Objective-C context prints a unichar, not a wchar_t.
    // If the argument is an integer of some kind, believe the %C and suggest
    // a cast instead of changing the conversion specifier.
    QualType IntendedTy = new QualType(ExprTy);
    if (ObjCContext
       && FS.getConversionSpecifier().getKind() == ConversionSpecifier.Kind.CArg) {
      if (ExprTy.$arrow().isIntegralOrUnscopedEnumerationType()
         && !ExprTy.$arrow().isCharType()) {
        LookupResult Result = null;
        try {
          // 'unichar' is defined as a typedef of unsigned short, but we should
          // prefer using the typedef if it is visible.
          IntendedTy.$assignMove(S.Context.UnsignedShortTy.$QualType());
          {
            
            // While we are here, check if the value is an IntegerLiteral that happens
            // to be within the valid range.
            /*const*/ IntegerLiteral /*P*/ IL = dyn_cast_IntegerLiteral(E);
            if ((IL != null)) {
              final /*const*/ APInt /*&*/ V = IL.getValue();
              if ($lesseq_uint_ulong(V.getActiveBits(), S.Context.getTypeSize(new QualType(IntendedTy)))) {
                return true;
              }
            }
          }
          
          Result/*J*/= new LookupResult(S, new DeclarationName($AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"unichar")))), E.getLocStart(), 
              Sema.LookupNameKind.LookupOrdinaryName);
          if (S.LookupName(Result, S.getCurScope())) {
            NamedDecl/*P*/ ND = Result.getFoundDecl();
            {
              TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(ND);
              if ((TD != null)) {
                if ($eq_QualType$C(TD.getUnderlyingType(), IntendedTy)) {
                  IntendedTy.$assignMove(S.Context.getTypedefType(TD));
                }
              }
            }
          }
        } finally {
          if (Result != null) { Result.$destroy(); }
        }
      }
    }
    
    // Special-case some of Darwin's platform-independence types by suggesting
    // casts to primitive types that are known to be large enough.
    boolean ShouldNotPrintDirectly = false;
    StringRef CastTyName/*J*/= new StringRef();
    if (S.Context.getTargetInfo().getTriple().isOSDarwin()) {
      QualType CastTy/*J*/= new QualType();
//      std.tie(CastTy, CastTyName).$assign_pair$_U1$_U2(shouldNotPrintDirectly(S.Context, new QualType(IntendedTy), E));
      // JAVA: unfold std.tie
      std.pair<QualType, StringRef> $pair = shouldNotPrintDirectly(S.Context, new QualType(IntendedTy), E);
      CastTy.$assign($pair.first);
      CastTyName.$assign($pair.second);
      if (!CastTy.isNull()) {
        IntendedTy.$assign(CastTy);
        ShouldNotPrintDirectly = true;
      }
    }
    
    // We may be able to offer a FixItHint if it is a supported type.
    PrintfSpecifier fixedFS = new PrintfSpecifier(FS);
    boolean success = fixedFS.fixType(new QualType(IntendedTy), S.getLangOpts(), 
        S.Context, ObjCContext);
    if (success) {
      raw_svector_ostream os = null;
      try {
        // Get the fix string from the fixed format specifier
        SmallString/*16*/ buf/*J*/= new SmallString/*16*/(16);
        os/*J*/= new raw_svector_ostream(buf);
        fixedFS.__toString(os);
        
        CharSourceRange SpecRange = getSpecifierRange(StartSpecifier, SpecifierLen);
        if ($eq_QualType$C(IntendedTy, ExprTy) && !ShouldNotPrintDirectly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int _diag = diag.warn_format_conversion_argument_type_mismatch;
            if (match == ArgType.MatchKind.NoMatchPedantic) {
              _diag = diag.warn_format_conversion_argument_type_mismatch_pedantic;
            }
            // In this case, the specifier is wrong and should be changed to match
            // the argument.
            EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(_diag)), 
                                    new StringRef(AT.getRepresentativeTypeName(S.Context))), 
                                /*NO_COPY*/IntendedTy), (IsEnum ? 1 : 0)), E.getSourceRange()))), 
                E.getLocStart(), 
                /*IsStringLocation*/ false, new CharSourceRange(SpecRange), 
                new ArrayRef<FixItHint>(FixItHint.CreateReplacement(/*NO_COPY*/SpecRange, os.str()), false)); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        } else {
          raw_svector_ostream CastFix = null;
          try {
            // The canonical type for formatting this value is different from the
            // actual type of the expression. (This occurs, for example, with Darwin's
            // NSInteger on 32-bit platforms, where it is typedef'd as 'int', but
            // should be printed as 'long' for 64-bit compatibility.)
            // Rather than emitting a normal format/argument mismatch, we want to
            // add a cast to the recommended type (and correct the format string
            // if necessary).
            SmallString/*16*/ CastBuf/*J*/= new SmallString/*16*/(16);
            CastFix/*J*/= new raw_svector_ostream(CastBuf);
            CastFix.$out(/*KEEP_STR*/$LPAREN);
            IntendedTy.print(CastFix, S.Context.getPrintingPolicy());
            CastFix.$out(/*KEEP_STR*/$RPAREN);
            
            SmallVector<FixItHint> Hints/*J*/= new SmallVector<FixItHint>(4, new FixItHint());
            if (!(AT.matchesType(S.Context, new QualType(IntendedTy)).getValue() != 0)) {
              Hints.push_back_T$RR(FixItHint.CreateReplacement(/*NO_COPY*/SpecRange, os.str()));
            }
            {
              
              /*const*/ CStyleCastExpr /*P*/ CCast = dyn_cast_CStyleCastExpr(E);
              if ((CCast != null)) {
                // If there's already a cast present, just replace it.
                SourceRange CastRange/*J*/= new SourceRange(CCast.getLParenLoc(), CCast.getRParenLoc());
                Hints.push_back_T$RR(FixItHint.CreateReplacement(/*NO_COPY*/CastRange, CastFix.str()));
              } else if (!requiresParensToAddCast(E)) {
                // If the expression has high enough precedence,
                // just write the C-style cast.
                Hints.push_back_T$RR(FixItHint.CreateInsertion(E.getLocStart(), 
                        CastFix.str()));
              } else {
                // Otherwise, add parens around the expression as well as the cast.
                CastFix.$out(/*KEEP_STR*/$LPAREN);
                Hints.push_back_T$RR(FixItHint.CreateInsertion(E.getLocStart(), 
                        CastFix.str()));
                
                SourceLocation After = S.getLocForEndOfToken(E.getLocEnd());
                Hints.push_back_T$RR(FixItHint.CreateInsertion(/*NO_COPY*/After, new StringRef(/*KEEP_STR*/$RPAREN)));
              }
            }
            if (ShouldNotPrintDirectly) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // The expression has a type that should not be printed directly.
                // We extract the name from the typedef because we don't want to show
                // the underlying type in the diagnostic.
                StringRef Name/*J*/= new StringRef();
                {
                  /*const*/ TypedefType /*P*/ TypedefTy = dyn_cast_TypedefType(ExprTy);
                  if ((TypedefTy != null)) {
                    Name.$assignMove(TypedefTy.getDecl().getName());
                  } else {
                    Name.$assign(CastTyName);
                  }
                }
                EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_format_argument_needs_cast)), 
                                        /*NO_COPY*/Name), /*NO_COPY*/IntendedTy), (IsEnum ? 1 : 0)), 
                            E.getSourceRange()))), 
                    E.getLocStart(), /*IsStringLocation=*/ false, 
                    new CharSourceRange(SpecRange), new ArrayRef<FixItHint>(Hints, false)); $c$.clean();
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // In this case, the expression could be printed using a different
                // specifier, but we've decided that the specifier is probably correct 
                // and we should cast instead. Just use the normal warning message.
                EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_format_conversion_argument_type_mismatch)), 
                                        new StringRef(AT.getRepresentativeTypeName(S.Context))), /*NO_COPY*/ExprTy), (IsEnum ? 1 : 0)), 
                            E.getSourceRange()))), 
                    E.getLocStart(), /*IsStringLocation*/ false, 
                    new CharSourceRange(SpecRange), new ArrayRef<FixItHint>(Hints, false)); $c$.clean();
              } finally {
                $c$.$destroy();
              }
            }
          } finally {
            if (CastFix != null) { CastFix.$destroy(); }
          }
        }
      } finally {
        if (os != null) { os.$destroy(); }
      }
    } else {
      final /*const*/ CharSourceRange /*&*/ CSR = getSpecifierRange(StartSpecifier, 
          SpecifierLen);
      // Since the warning for passing non-POD types to variadic functions
      // was deferred until now, we emit a warning for non-POD
      // arguments here.
      switch (S.isValidVarArgType(ExprTy)) {
       case VAK_Valid:
       case VAK_ValidInCXX11:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int _diag = diag.warn_format_conversion_argument_type_mismatch;
            if (match == ArgType.MatchKind.NoMatchPedantic) {
              _diag = diag.warn_format_conversion_argument_type_mismatch_pedantic;
            }
            
            EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_CharSourceRange$C($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(_diag)), new StringRef(AT.getRepresentativeTypeName(S.Context))), /*NO_COPY*/ExprTy), 
                                (IsEnum ? 1 : 0)), CSR), E.getSourceRange()))), 
                E.getLocStart(), /*IsStringLocation*/ false, new CharSourceRange(CSR)); $c$.clean();
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case VAK_Undefined:
       case VAK_MSVCUndefined:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_CharSourceRange$C($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_uint($c$.track(S.PDiag(diag.warn_non_pod_vararg_with_format_string)), 
                                            S.getLangOpts().CPlusPlus11 ? 1 : 0), 
                                        /*NO_COPY*/ExprTy), 
                                    CallType.getValue()), 
                                new StringRef(AT.getRepresentativeTypeName(S.Context))), 
                            CSR), 
                        E.getSourceRange()))), 
                E.getLocStart(), /*IsStringLocation*/ false, new CharSourceRange(CSR)); $c$.clean();
            checkForCStrMembers(AT, E);
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case VAK_Invalid:
        if (ExprTy.$arrow().isObjCObjectType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_CharSourceRange$C($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_uint($c$.track(S.PDiag(diag.err_cannot_pass_objc_interface_to_vararg_format)), 
                                            S.getLangOpts().CPlusPlus11 ? 1 : 0), 
                                        /*NO_COPY*/ExprTy), 
                                    CallType.getValue()), 
                                new StringRef(AT.getRepresentativeTypeName(S.Context))), 
                            CSR), 
                        E.getSourceRange()))), 
                E.getLocStart(), /*IsStringLocation*/ false, new CharSourceRange(CSR)); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // FIXME: If this is an initializer list, suggest removing the braces
            // or inserting a cast to the target type.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getLocStart(), diag.err_cannot_pass_to_vararg_format)), 
                                isa_InitListExpr(E)), ExprTy), CallType), 
                    AT.getRepresentativeTypeName(S.Context)), 
                E.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        break;
      }
      assert ($less_uint(FirstDataArg + FS.getArgIndex(), CheckedVarArgs.size())) : "format string specifier index out of range";
      CheckedVarArgs.set(FirstDataArg + FS.getArgIndex()); // .$assign(/*KEEP_BOOL*/true);
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandleAmount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4659,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandleAmount", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler12HandleAmountERKN5clang21analyze_format_string14OptionalAmountEjPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler12HandleAmountERKN5clang21analyze_format_string14OptionalAmountEjPKcj")
  //</editor-fold>
  public boolean HandleAmount(final /*const*/ OptionalAmount /*&*/ Amt, 
              /*uint*/int k, /*const*/char$ptr/*char P*/ startSpecifier, 
              /*uint*/int specifierLen) {
    if (Amt.hasDataArgument()) {
      if (!HasVAListArg) {
        /*uint*/int argIndex = Amt.getArgIndex();
        if ($greatereq_uint(argIndex, NumDataArgs)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_uint($c$.track(S.PDiag(diag.warn_printf_asterisk_missing_arg)), 
                        k))), 
                getLocationOfByte(Amt.getStart()), 
                /*IsStringLocation*/ true, 
                getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
            // Don't do any more checking.  We will just emit
            // spurious errors.
            return false;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Type check the data argument.  It should be an 'int'.
        // Although not in conformance with C99, we also allow the argument to be
        // an 'unsigned int' as that is a reasonably safe case.  GCC also
        // doesn't emit a warning for that case.
        CoveredArgs.set(argIndex);
        /*const*/ Expr /*P*/ Arg = getDataArg(argIndex);
        if (!(Arg != null)) {
          return false;
        }
        
        QualType T = Arg.getType();
        
        final /*const*/ ArgType /*&*/ AT = Amt.getArgType(S.Context);
        assert (AT.isValid());
        if (!(AT.matchesType(S.Context, new QualType(T)).getValue() != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_uint($c$.track(S.PDiag(diag.warn_printf_asterisk_wrong_type)), 
                                    k), new StringRef(AT.getRepresentativeTypeName(S.Context))), 
                            /*NO_COPY*/T), Arg.getSourceRange()))), 
                getLocationOfByte(Amt.getStart()), 
                /*IsStringLocation*/ true, 
                getSpecifierRange(startSpecifier, specifierLen)); $c$.clean();
            // Don't do any more checking.  We will just emit
            // spurious errors.
            return false;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandleInvalidAmount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4707,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandleInvalidAmount", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler19HandleInvalidAmountERKN5clang14analyze_printf15PrintfSpecifierERKNS1_21analyze_format_string14OptionalAmountEjPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler19HandleInvalidAmountERKN5clang14analyze_printf15PrintfSpecifierERKNS1_21analyze_format_string14OptionalAmountEjPKcj")
  //</editor-fold>
  public void HandleInvalidAmount(final /*const*/ PrintfSpecifier /*&*/ FS, 
                     final /*const*/ OptionalAmount /*&*/ Amt, 
                     /*uint*/int type, 
                     /*const*/char$ptr/*char P*/ startSpecifier, 
                     /*uint*/int specifierLen) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final /*const*/ PrintfConversionSpecifier /*&*/ CS = FS.getConversionSpecifier();
      
      FixItHint fixit = Amt.getHowSpecified() == OptionalAmount.HowSpecified.Constant ? FixItHint.CreateRemoval(getSpecifierRange(Amt.getStart(), 
              Amt.getConstantLength())) : new FixItHint();
      
      EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_char$ptr$C($out_PartialDiagnostic$C_uint($c$.track(S.PDiag(diag.warn_printf_nonsensical_optional_amount)), 
                      type), CS.__toString()))), 
          getLocationOfByte(Amt.getStart()), 
          /*IsStringLocation*/ true, 
          getSpecifierRange(startSpecifier, specifierLen), 
          new ArrayRef<FixItHint>(fixit, false)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandleFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4730,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandleFlag", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler10HandleFlagERKN5clang14analyze_printf15PrintfSpecifierERKNS1_21analyze_format_string12OptionalFlagEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler10HandleFlagERKN5clang14analyze_printf15PrintfSpecifierERKNS1_21analyze_format_string12OptionalFlagEPKcj")
  //</editor-fold>
  public void HandleFlag(final /*const*/ PrintfSpecifier /*&*/ FS, 
            final /*const*/ OptionalFlag /*&*/ flag, 
            /*const*/char$ptr/*char P*/ startSpecifier, 
            /*uint*/int specifierLen) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Warn about pointless flag with a fixit removal.
      final /*const*/ PrintfConversionSpecifier /*&*/ CS = FS.getConversionSpecifier();
      EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_char$ptr$C($out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(diag.warn_printf_nonsensical_flag)), 
                      flag.__toString()), CS.__toString()))), 
          getLocationOfByte(flag.getPosition()), 
          /*IsStringLocation*/ true, 
          getSpecifierRange(startSpecifier, specifierLen), 
          new ArrayRef<FixItHint>(FixItHint.CreateRemoval(getSpecifierRange(flag.getPosition(), 1)), false)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandleIgnoredFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4746,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandleIgnoredFlag", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler17HandleIgnoredFlagERKN5clang14analyze_printf15PrintfSpecifierERKNS1_21analyze_format_string12OptionalFlagES9_PKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler17HandleIgnoredFlagERKN5clang14analyze_printf15PrintfSpecifierERKNS1_21analyze_format_string12OptionalFlagES9_PKcj")
  //</editor-fold>
  public void HandleIgnoredFlag(final /*const*/ PrintfSpecifier /*&*/ FS, 
                   final /*const*/ OptionalFlag /*&*/ ignoredFlag, 
                   final /*const*/ OptionalFlag /*&*/ flag, 
                   /*const*/char$ptr/*char P*/ startSpecifier, 
                   /*uint*/int specifierLen) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Warn about ignored flag with a fixit removal.
      EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_char$ptr$C($out_PartialDiagnostic$C_char$ptr$C($c$.track(S.PDiag(diag.warn_printf_ignored_flag)), 
                      ignoredFlag.__toString()), flag.__toString()))), 
          getLocationOfByte(ignoredFlag.getPosition()), 
          /*IsStringLocation*/ true, 
          getSpecifierRange(startSpecifier, specifierLen), 
          new ArrayRef<FixItHint>(FixItHint.CreateRemoval(getSpecifierRange(ignoredFlag.getPosition(), 1)), false)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  // Check if a (w)string was passed when a (w)char* was needed, and offer a
  // better diagnostic if so. AT is assumed to be valid.
  // Returns true when a c_str() conversion method is found.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::checkForCStrMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4845,
   FQN="(anonymous namespace)::CheckPrintfHandler::checkForCStrMembers", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler19checkForCStrMembersERKN5clang21analyze_format_string7ArgTypeEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler19checkForCStrMembersERKN5clang21analyze_format_string7ArgTypeEPKNS1_4ExprE")
  //</editor-fold>
  public boolean checkForCStrMembers(final /*const*/ ArgType /*&*/ AT, /*const*/ Expr /*P*/ E) {
    /*typedef llvm::SmallPtrSet<CXXMethodDecl *, 1> MethodSet*/
//    final class MethodSet extends SmallPtrSet<CXXMethodDecl /*P*/ >{ };
        
    SmallPtrSet<CXXMethodDecl /*P*/ > Results = SemaCheckingStatics.<CXXMethodDecl>CXXRecordMembersNamed(CXXMethodDecl.class, new StringRef(/*KEEP_STR*/"c_str"), S, E.getType());

    for (SmallPtrSetIterator<CXXMethodDecl /*P*/ > MI = Results.begin(), ME = Results.end();
         MI.$noteq(ME); MI.$preInc()) {
      /*const*/ CXXMethodDecl /*P*/ Method = MI.$star();
      if (Method.getMinRequiredArguments() == 0
         && (AT.matchesType(S.Context, Method.getReturnType()).getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXME: Suggest parens if the expression needs them.
          SourceLocation EndLoc = S.getLocForEndOfToken(E.getLocEnd());
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getLocStart(), diag.note_printf_c_str)), 
                  /*KEEP_STR*/"c_str()"), 
              FixItHint.CreateInsertion(/*NO_COPY*/EndLoc, new StringRef(/*KEEP_STR*/".c_str()"))));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return false;
  }

  
  
  //  void EmitFormatDiagnostic(PartialDiagnostic PDiag, SourceLocation StringLoc,
  //                            bool IsStringLocation, Range StringRange,
  //                            ArrayRef<FixItHint> Fixit = None);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandleEmptyObjCModifierFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4766,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandleEmptyObjCModifierFlag", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler27HandleEmptyObjCModifierFlagEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler27HandleEmptyObjCModifierFlagEPKcj")
  //</editor-fold>
  @Override public void HandleEmptyObjCModifierFlag(/*const*/char$ptr/*char P*/ startFlag, 
                             /*uint*/int flagLen)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Warn about an empty flag.
      EmitFormatDiagnostic($c$.track(S.PDiag(diag.warn_printf_empty_objc_flag)), 
          getLocationOfByte(startFlag), 
          /*IsStringLocation*/ true, 
          getSpecifierRange(startFlag, flagLen)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandleInvalidObjCModifierFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4775,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandleInvalidObjCModifierFlag", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler29HandleInvalidObjCModifierFlagEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler29HandleInvalidObjCModifierFlagEPKcj")
  //</editor-fold>
  @Override public void HandleInvalidObjCModifierFlag(/*const*/char$ptr/*char P*/ startFlag, 
                               /*uint*/int flagLen)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Warn about an invalid flag.
      CharSourceRange Range = getSpecifierRange(startFlag, flagLen);
      StringRef flag/*J*/= new StringRef(startFlag, flagLen);
      EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(diag.warn_printf_invalid_objc_flag)), /*NO_COPY*/flag))), 
          getLocationOfByte(startFlag), 
          /*IsStringLocation*/ true, 
          new CharSourceRange(Range), new ArrayRef<FixItHint>(FixItHint.CreateRemoval(/*NO_COPY*/Range), false)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::HandleObjCFlagsWithNonObjCConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4786,
   FQN="(anonymous namespace)::CheckPrintfHandler::HandleObjCFlagsWithNonObjCConversion", NM="_ZN12_GLOBAL__N_118CheckPrintfHandler36HandleObjCFlagsWithNonObjCConversionEPKcS2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandler36HandleObjCFlagsWithNonObjCConversionEPKcS2_S2_")
  //</editor-fold>
  @Override public void HandleObjCFlagsWithNonObjCConversion(/*const*/char$ptr/*char P*/ flagsStart, /*const*/char$ptr/*char P*/ flagsEnd, /*const*/char$ptr/*char P*/ conversionPosition)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Warn about using '[...]' without a '@' conversion.
      CharSourceRange Range = getSpecifierRange(flagsStart, flagsEnd.$sub(flagsStart) + 1);
      /*Unnamed enum*//*uint*/int _diag = diag.warn_printf_ObjCflags_without_ObjCConversion;
      EmitFormatDiagnostic($c$.track(new PartialDiagnostic($out_PartialDiagnostic$C_StringRef($c$.track(S.PDiag(_diag)), new StringRef(conversionPosition, 1)))), 
          getLocationOfByte(conversionPosition), 
          /*IsStringLocation*/ true, 
          new CharSourceRange(Range), new ArrayRef<FixItHint>(FixItHint.CreateRemoval(/*NO_COPY*/Range), false)); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckPrintfHandler::~CheckPrintfHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4584,
   FQN="(anonymous namespace)::CheckPrintfHandler::~CheckPrintfHandler", NM="_ZN12_GLOBAL__N_118CheckPrintfHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_118CheckPrintfHandlerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ObjCContext=" + ObjCContext // NOI18N
              + super.toString(); // NOI18N
  }
}
