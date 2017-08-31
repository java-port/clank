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
package org.clang.sema;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.basic.Builtin.*;
import org.clang.lex.*;
import org.clang.sema.impl.*;
import org.clang.basic.target.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaCheckingStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.target.ARM.*;
import static org.clang.basic.target.Mips.*;
import static org.clang.basic.target.NEON.*;
import static org.clang.basic.target.PPC.*;
import static org.clang.basic.target.SystemZ.*;
import static org.clang.basic.target.X86.*;
import org.llvm.support.ConvertUTFGlobals.*;
import static org.llvm.support.ConvertUTFGlobals.*;
import org.llvm.support.ConvertUTFGlobals.ConversionResult;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaChecking">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaChecking",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaCast ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema13hasCStrMethodEPKNS_4ExprE;_ZN5clang4Sema14CheckCastAlignEPNS_4ExprENS_8QualTypeENS_11SourceRangeE;_ZN5clang4Sema14CheckOtherCallEPNS_8CallExprEPKNS_17FunctionProtoTypeE;_ZN5clang4Sema15CheckObjCStringEPNS_4ExprE;_ZN5clang4Sema16CheckArrayAccessEPKNS_4ExprE;_ZN5clang4Sema16CheckArrayAccessEPKNS_4ExprES3_PKNS_18ArraySubscriptExprEbb;_ZN5clang4Sema16CheckPointerCallEPNS_9NamedDeclEPNS_8CallExprEPKNS_17FunctionProtoTypeE;_ZN5clang4Sema16DiagnoseSelfMoveEPKNS_4ExprES3_NS_14SourceLocationE;_ZN5clang4Sema17CheckFunctionCallEPNS_12FunctionDeclEPNS_8CallExprEPKNS_17FunctionProtoTypeE;_ZN5clang4Sema17SemaBuiltinAssumeEPNS_8CallExprE;_ZN5clang4Sema17SemaBuiltinSetjmpEPNS_8CallExprE;_ZN5clang4Sema17checkRetainCyclesEPNS_15ObjCMessageExprE;_ZN5clang4Sema17checkRetainCyclesEPNS_4ExprES2_;_ZN5clang4Sema17checkRetainCyclesEPNS_7VarDeclEPNS_4ExprE;_ZN5clang4Sema18CheckCompletedExprEPNS_4ExprENS_14SourceLocationEb;_ZN5clang4Sema18CheckReturnValExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbPKN4llvm11SmallVectorIPNS_4AttrELj2EEEPKNS_12FunctionDeclE;_ZN5clang4Sema18SemaBuiltinLongjmpEPNS_8CallExprE;_ZN5clang4Sema18SemaBuiltinVAStartEPNS_8CallExprE;_ZN5clang4Sema18checkUnsafeAssignsENS_14SourceLocationENS_8QualTypeEPNS_4ExprE;_ZN5clang4Sema19CheckForIntOverflowEPNS_4ExprE;_ZN5clang4Sema19CheckObjCMethodCallEPNS_14ObjCMethodDeclENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEE;_ZN5clang4Sema19FormatStringHasSArgEPKNS_13StringLiteralE;_ZN5clang4Sema19GetFormatStringTypeEPKNS_10FormatAttrE;_ZN5clang4Sema19SemaBuiltinPrefetchEPNS_8CallExprE;_ZN5clang4Sema19getFormatStringInfoEPKNS_10FormatAttrEbPNS0_16FormatStringInfoE;_ZN5clang4Sema20CheckConstructorCallEPNS_12FunctionDeclEN4llvm8ArrayRefIPKNS_4ExprEEEPKNS_17FunctionProtoTypeENS_14SourceLocationE;_ZN5clang4Sema20CheckFloatComparisonENS_14SourceLocationEPNS_4ExprES3_;_ZN5clang4Sema20CheckFormatArgumentsEN4llvm8ArrayRefIPKNS_4ExprEEEbjjNS0_16FormatStringTypeENS0_16VariadicCallTypeENS_14SourceLocationENS_11SourceRangeERNS1_14SmallBitVectorE;_ZN5clang4Sema20CheckFormatArgumentsEPKNS_10FormatAttrEN4llvm8ArrayRefIPKNS_4ExprEEEbNS0_16VariadicCallTypeENS_14SourceLocationENS_11SourceRangeERNS4_14SmallBitVectorE;_ZN5clang4Sema20GetFormatNSStringIdxEPKNS_10FormatAttrERj;_ZN5clang4Sema20SemaBuiltinMSVAStartEPNS_8CallExprE;_ZN5clang4Sema21CheckStrncatArgumentsEPKNS_8CallExprEPNS_14IdentifierInfoE;_ZN5clang4Sema21DiagnoseEmptyLoopBodyEPKNS_4StmtES3_;_ZN5clang4Sema21DiagnoseEmptyStmtBodyENS_14SourceLocationEPKNS_4StmtEj;_ZN5clang4Sema21SemaBuiltinVAStartARMEPNS_8CallExprE;_ZN5clang4Sema21SemaConvertVectorExprEPNS_4ExprEPNS_14TypeSourceInfoENS_14SourceLocationES5_;_ZN5clang4Sema22SemaBuiltinConstantArgEPNS_8CallExprEiRN4llvm6APSIntE;_ZN5clang4Sema22SemaBuiltinVAStartImplEPNS_8CallExprE;_ZN5clang4Sema22checkUnsafeExprAssignsENS_14SourceLocationEPNS_4ExprES3_;_ZN5clang4Sema23CheckBoolLikeConversionEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema23CheckMemaccessArgumentsEPKNS_8CallExprEjPNS_14IdentifierInfoE;_ZN5clang4Sema23SemaAtomicOpsOverloadedENS_12ActionResultIPNS_4ExprELb1EEENS_10AtomicExpr8AtomicOpE;_ZN5clang4Sema24CheckArgumentWithTypeTagEPKNS_23ArgumentWithTypeTagAttrEPKPKNS_4ExprE;_ZN5clang4Sema24CheckBuiltinFunctionCallEPNS_12FunctionDeclEjPNS_8CallExprE;_ZN5clang4Sema24CheckImplicitConversionsEPNS_4ExprENS_14SourceLocationE;_ZN5clang4Sema24CheckParmsForFunctionDefEN4llvm8ArrayRefIPNS_11ParmVarDeclEEEb;_ZN5clang4Sema24CheckStrlcpycatArgumentsEPKNS_8CallExprEPNS_14IdentifierInfoE;_ZN5clang4Sema24SemaBuiltinARMSpecialRegEjPNS_8CallExprEijb;_ZN5clang4Sema24SemaBuiltinAssumeAlignedEPNS_8CallExprE;_ZN5clang4Sema24SemaBuiltinShuffleVectorEPNS_8CallExprE;_ZN5clang4Sema26CheckAbsoluteValueFunctionEPKNS_8CallExprEPKNS_12FunctionDeclEPNS_14IdentifierInfoE;_ZN5clang4Sema26CheckObjCCircularContainerEPNS_15ObjCMessageExprE;_ZN5clang4Sema26CheckUnsequencedOperationsEPNS_4ExprE;_ZN5clang4Sema26RegisterTypeTagForDatatypeEPKNS_14IdentifierInfoEyNS_8QualTypeEbb;_ZN5clang4Sema27CheckARMBuiltinFunctionCallEjPNS_8CallExprE;_ZN5clang4Sema27CheckBitFieldInitializationENS_14SourceLocationEPNS_9FieldDeclEPNS_4ExprE;_ZN5clang4Sema27CheckPPCBuiltinFunctionCallEjPNS_8CallExprE;_ZN5clang4Sema27CheckX86BuiltinFunctionCallEjPNS_8CallExprE;_ZN5clang4Sema27SemaBuiltinAtomicOverloadedENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema27SemaBuiltinConstantArgRangeEPNS_8CallExprEiii;_ZN5clang4Sema27SemaBuiltinFPClassificationEPNS_8CallExprEj;_ZN5clang4Sema27SemaBuiltinUnorderedCompareEPNS_8CallExprE;_ZN5clang4Sema28CheckARMBuiltinExclusiveCallEjPNS_8CallExprEj;_ZN5clang4Sema28CheckMipsBuiltinFunctionCallEjPNS_8CallExprE;_ZN5clang4Sema28CheckNeonBuiltinFunctionCallEjPNS_8CallExprE;_ZN5clang4Sema28DiagnoseAlwaysNonNullPointerEPNS_4ExprENS1_23NullPointerConstantKindEbNS_11SourceRangeE;_ZN5clang4Sema31CheckAArch64BuiltinFunctionCallEjPNS_8CallExprE;_ZN5clang4Sema31CheckSystemZBuiltinFunctionCallEjPNS_8CallExprE;_ZN5clang4Sema32SemaBuiltinNontemporalOverloadedENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema9checkCallEPNS_9NamedDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIPKNS_4ExprEEEbNS_14SourceLocationENS_11SourceRangeENS0_16VariadicCallTypeE;_ZNK5clang4Sema30getLocationOfStringLiteralByteEPKNS_13StringLiteralEj; -static-type=Sema_SemaChecking -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaChecking extends Sema_SemaCast {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// CheckCastAlign - Implements -Wcast-align, which warns when a
/// pointer cast increases the alignment requirements.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCastAlign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9510,
 FQN="clang::Sema::CheckCastAlign", NM="_ZN5clang4Sema14CheckCastAlignEPNS_4ExprENS_8QualTypeENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema14CheckCastAlignEPNS_4ExprENS_8QualTypeENS_11SourceRangeE")
//</editor-fold>
public final void CheckCastAlign(Expr /*P*/ Op, QualType T, SourceRange TRange) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // This is actually a lot of work to potentially be doing on every
    // cast; don't do it if we're ignoring -Wcast_align (as is the default).
    if ($this().getDiagnostics().isIgnored(diag.warn_cast_align, TRange.getBegin())) {
      return;
    }
    
    // Ignore dependent types.
    if (T.$arrow().isDependentType() || Op.getType().$arrow().isDependentType()) {
      return;
    }
    
    // Require that the destination be a pointer type.
    /*const*/ PointerType /*P*/ DestPtr = T.$arrow().getAs(PointerType.class);
    if (!(DestPtr != null)) {
      return;
    }
    
    // If the destination has alignment 1, we're done.
    QualType DestPointee = DestPtr.getPointeeType();
    if (DestPointee.$arrow().isIncompleteType()) {
      return;
    }
    CharUnits DestAlign = $this().Context.getTypeAlignInChars(new QualType(DestPointee));
    if (DestAlign.isOne()) {
      return;
    }
    
    // Require that the source be a pointer type.
    /*const*/ PointerType /*P*/ SrcPtr = Op.getType().$arrow().getAs(PointerType.class);
    if (!(SrcPtr != null)) {
      return;
    }
    QualType SrcPointee = SrcPtr.getPointeeType();
    
    // Whitelist casts from cv void*.  We already implicitly
    // whitelisted casts to cv void*, since they have alignment 1.
    // Also whitelist casts involving incomplete types, which implicitly
    // includes 'void'.
    if (SrcPointee.$arrow().isIncompleteType()) {
      return;
    }
    
    CharUnits SrcAlign = $this().Context.getTypeAlignInChars(new QualType(SrcPointee));
    if (SrcAlign.$greatereq(DestAlign)) {
      return;
    }
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(TRange.getBegin(), diag.warn_cast_align)), 
                            Op.getType()), T), 
                    ((/*static_cast*//*uint*/int)($long2uint(SrcAlign.getQuantity())))), 
                ((/*static_cast*//*uint*/int)($long2uint(DestAlign.getQuantity())))), 
            TRange), Op.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// Helpers for dealing with blocks and functions.

/// CheckParmsForFunctionDef - Check that the parameters of the given
/// function are appropriate for the definition of a function. This
/// takes care of any checks that cannot be performed on the
/// declaration itself, e.g., that the types of each of the function
/// parameters are complete.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckParmsForFunctionDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9440,
 FQN="clang::Sema::CheckParmsForFunctionDef", NM="_ZN5clang4Sema24CheckParmsForFunctionDefEN4llvm8ArrayRefIPNS_11ParmVarDeclEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema24CheckParmsForFunctionDefEN4llvm8ArrayRefIPNS_11ParmVarDeclEEEb")
//</editor-fold>
public final boolean CheckParmsForFunctionDef(ArrayRef<ParmVarDecl /*P*/ > Parameters, 
                        boolean CheckParameterNames) {
  boolean HasInvalidParm = false;
  for (ParmVarDecl /*P*/ Param : Parameters) {
    // C99 6.7.5.3p4: the parameters in a parameter type list in a
    // function declarator that is part of a function definition of
    // that function shall not have incomplete type.
    //
    // This is also C++ [dcl.fct]p6.
    if (!Param.isInvalidDecl()
       && $this().RequireCompleteType(Param.getLocation(), Param.getType(), 
        diag.err_typecheck_decl_incomplete_type)) {
      Param.setInvalidDecl();
      HasInvalidParm = true;
    }
    
    // C99 6.9.1p5: If the declarator includes a parameter type list, the
    // declaration of each parameter shall include an identifier.
    if (CheckParameterNames
       && Param.getIdentifier() == null
       && !Param.isImplicit()
       && !$this().getLangOpts().CPlusPlus) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.err_parameter_name_omitted)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // C99 6.7.5.3p12:
    //   If the function declarator is not part of a definition of that
    //   function, parameters may have incomplete type and may use the [*]
    //   notation in their sequences of declarator specifiers to specify
    //   variable length array types.
    QualType PType = Param.getOriginalType();
    // FIXME: This diagnostic should point the '[*]' if source-location
    // information is added for it.
    SemaCheckingStatics.diagnoseArrayStarInParamType(/*Deref*/$this(), new QualType(PType), Param.getLocation());
    
    // MSVC destroys objects passed by value in the callee.  Therefore a
    // function definition which takes such a parameter must be able to call the
    // object's destructor.  However, we don't perform any direct access check
    // on the dtor.
    if ($this().getLangOpts().CPlusPlus && $this().Context.getTargetInfo().
        getCXXABI().
        areArgsDestroyedLeftToRightInCallee()) {
      if (!Param.isInvalidDecl()) {
        {
          /*const*/ RecordType /*P*/ RT = Param.getType().$arrow().getAs$RecordType();
          if ((RT != null)) {
            CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(RT.getDecl());
            if (!ClassDecl.isInvalidDecl()
               && !ClassDecl.hasIrrelevantDestructor()
               && !ClassDecl.isDependentContext()) {
              CXXDestructorDecl /*P*/ Destructor = $this().LookupDestructor(ClassDecl);
              $this().MarkFunctionReferenced(Param.getLocation(), Destructor);
              $this().DiagnoseUseOfDecl(Destructor, Param.getLocation());
            }
          }
        }
      }
    }
    {
      
      // Parameters with the pass_object_size attribute only need to be marked
      // constant at function definitions. Because we lack information about
      // whether we're on a declaration or definition when we're instantiating the
      // attribute, we need to check for constness here.
      /*const*/ PassObjectSizeAttr /*P*/ Attr = Param.getAttr(PassObjectSizeAttr.class);
      if ((Attr != null)) {
        if (!Param.getType().isConstQualified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track($this().Diag(Param.getLocation(), diag.err_attribute_pointers_only)), 
                    Attr.getSpelling()), 1));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  return HasInvalidParm;
}


/// Emit \p DiagID if statement located on \p StmtLoc has a suspicious null
/// statement as a \p Body, and it is located on the same line.
///
/// This helps prevent bugs due to typos, such as:
///     if (condition);
///       do_stuff();
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseEmptyStmtBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10367,
 FQN="clang::Sema::DiagnoseEmptyStmtBody", NM="_ZN5clang4Sema21DiagnoseEmptyStmtBodyENS_14SourceLocationEPKNS_4StmtEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema21DiagnoseEmptyStmtBodyENS_14SourceLocationEPKNS_4StmtEj")
//</editor-fold>
public final void DiagnoseEmptyStmtBody(SourceLocation StmtLoc, 
                     /*const*/ Stmt /*P*/ Body, 
                     /*uint*/int DiagID) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Since this is a syntactic check, don't emit diagnostic for template
    // instantiations, this just adds noise.
    if (($this().CurrentInstantiationScope != null)) {
      return;
    }
    
    // The body should be a null statement.
    /*const*/ NullStmt /*P*/ NBody = dyn_cast_NullStmt(Body);
    if (!(NBody != null)) {
      return;
    }
    
    // Do the usual checks.
    if (!SemaCheckingStatics.ShouldDiagnoseEmptyStmtBody($this().SourceMgr, new SourceLocation(StmtLoc), NBody)) {
      return;
    }
    
    $c$.clean($c$.track($this().Diag(NBody.getSemiLoc(), DiagID)));
    $c$.clean($c$.track($this().Diag(NBody.getSemiLoc(), diag.note_empty_body_on_separate_line)));
  } finally {
    $c$.$destroy();
  }
}


/// Warn if a for/while loop statement \p S, which is followed by
/// \p PossibleBody, has a suspicious null statement as a body.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseEmptyLoopBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10388,
 FQN="clang::Sema::DiagnoseEmptyLoopBody", NM="_ZN5clang4Sema21DiagnoseEmptyLoopBodyEPKNS_4StmtES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema21DiagnoseEmptyLoopBodyEPKNS_4StmtES3_")
//</editor-fold>
public final void DiagnoseEmptyLoopBody(/*const*/ Stmt /*P*/ S, 
                     /*const*/ Stmt /*P*/ PossibleBody) {
  assert (!($this().CurrentInstantiationScope != null)); // Ensured by caller
  
  SourceLocation StmtLoc/*J*/= new SourceLocation();
  /*const*/ Stmt /*P*/ Body;
  /*uint*/int DiagID;
  {
    /*const*/ ForStmt /*P*/ FS = dyn_cast_ForStmt(S);
    if ((FS != null)) {
      StmtLoc.$assignMove(FS.getRParenLoc());
      Body = FS.getBody$Const();
      DiagID = diag.warn_empty_for_body;
    } else {
      /*const*/ WhileStmt /*P*/ WS = dyn_cast_WhileStmt(S);
      if ((WS != null)) {
        StmtLoc.$assignMove(WS.getCond$Const().getSourceRange().getEnd());
        Body = WS.getBody$Const();
        DiagID = diag.warn_empty_while_body;
      } else {
        return; // Neither `for' nor `while'.
      }
    }
  }
  
  // The body should be a null statement.
  /*const*/ NullStmt /*P*/ NBody = dyn_cast_NullStmt(Body);
  if (!(NBody != null)) {
    return;
  }
  
  // Skip expensive checks if diagnostic is disabled.
  if ($this().Diags.isIgnored(DiagID, NBody.getSemiLoc())) {
    return;
  }
  
  // Do the usual checks.
  if (!SemaCheckingStatics.ShouldDiagnoseEmptyStmtBody($this().SourceMgr, new SourceLocation(StmtLoc), NBody)) {
    return;
  }
  
  // `for(...);' and `while(...);' are popular idioms, so in order to keep
  // noise level low, emit diagnostics only if for/while is followed by a
  // CompoundStmt, e.g.:
  //    for (int i = 0; i < n; i++);
  //    {
  //      a(i);
  //    }
  // or if for/while is followed by a statement with more indentation
  // than for/while itself:
  //    for (int i = 0; i < n; i++);
  //      a(i);
  boolean ProbableTypo = isa_CompoundStmt(PossibleBody);
  if (!ProbableTypo) {
    bool$ptr BodyColInvalid = create_bool$ptr();
    /*uint*/int BodyCol = $this().SourceMgr.getPresumedColumnNumber(PossibleBody.getLocStart(), 
        $AddrOf(BodyColInvalid));
    if (BodyColInvalid.$star()) {
      return;
    }
    
    bool$ptr StmtColInvalid = create_bool$ptr();
    /*uint*/int StmtCol = $this().SourceMgr.getPresumedColumnNumber(S.getLocStart(), 
        $AddrOf(StmtColInvalid));
    if (StmtColInvalid.$star()) {
      return;
    }
    if ($greater_uint(BodyCol, StmtCol)) {
      ProbableTypo = true;
    }
  }
  if (ProbableTypo) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(NBody.getSemiLoc(), DiagID)));
      $c$.clean($c$.track($this().Diag(NBody.getSemiLoc(), diag.note_empty_body_on_separate_line)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Warn if a value is moved to itself.

//===--- CHECK: Warn on self move with std::move. -------------------------===//

/// DiagnoseSelfMove - Emits a warning if a value is moved to itself.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseSelfMove">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10459,
 FQN="clang::Sema::DiagnoseSelfMove", NM="_ZN5clang4Sema16DiagnoseSelfMoveEPKNS_4ExprES3_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema16DiagnoseSelfMoveEPKNS_4ExprES3_NS_14SourceLocationE")
//</editor-fold>
public final void DiagnoseSelfMove(/*const*/ Expr /*P*/ LHSExpr, /*const*/ Expr /*P*/ RHSExpr, 
                SourceLocation OpLoc) {
  if ($this().Diags.isIgnored(diag.warn_sizeof_pointer_expr_memaccess, /*NO_COPY*/OpLoc)) {
    return;
  }
  if (!$this().ActiveTemplateInstantiations.empty()) {
    return;
  }
  
  // Strip parens and casts away.
  LHSExpr = LHSExpr.IgnoreParenImpCasts$Const();
  RHSExpr = RHSExpr.IgnoreParenImpCasts$Const();
  
  // Check for a call expression
  /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(RHSExpr);
  if (!(CE != null) || CE.getNumArgs() != 1) {
    return;
  }
  
  // Check for a call to std::move
  /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee$Const();
  if (!(FD != null) || !FD.isInStdNamespace() || !(FD.getIdentifier() != null)
     || !FD.getIdentifier().isStr(/*KEEP_STR*/"move")) {
    return;
  }
  
  // Get argument from std::move
  RHSExpr = CE.getArg$Const(0);
  
  /*const*/ DeclRefExpr /*P*/ LHSDeclRef = dyn_cast_DeclRefExpr(LHSExpr);
  /*const*/ DeclRefExpr /*P*/ RHSDeclRef = dyn_cast_DeclRefExpr(RHSExpr);
  
  // Two DeclRefExpr's, check that the decls are the same.
  if ((LHSDeclRef != null) && (RHSDeclRef != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!(LHSDeclRef.getDecl$Const() != null) || !(RHSDeclRef.getDecl$Const() != null)) {
        return;
      }
      if (LHSDeclRef.getDecl$Const().getCanonicalDecl$Const()
         != RHSDeclRef.getDecl$Const().getCanonicalDecl$Const()) {
        return;
      }
      
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(OpLoc), diag.warn_self_move)), LHSExpr.getType()), 
              LHSExpr.getSourceRange()), 
          RHSExpr.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Member variables require a different approach to check for self moves.
  // MemberExpr's are the same if every nested MemberExpr refers to the same
  // Decl and that the base Expr's are DeclRefExpr's with the same Decl or
  // the base Expr's are CXXThisExpr's.
  /*const*/ Expr /*P*/ LHSBase = LHSExpr;
  /*const*/ Expr /*P*/ RHSBase = RHSExpr;
  /*const*/ MemberExpr /*P*/ LHSME = dyn_cast_MemberExpr(LHSExpr);
  /*const*/ MemberExpr /*P*/ RHSME = dyn_cast_MemberExpr(RHSExpr);
  if (!(LHSME != null) || !(RHSME != null)) {
    return;
  }
  while ((LHSME != null) && (RHSME != null)) {
    if (LHSME.getMemberDecl().getCanonicalDecl()
       != RHSME.getMemberDecl().getCanonicalDecl()) {
      return;
    }
    
    LHSBase = LHSME.getBase();
    RHSBase = RHSME.getBase();
    LHSME = dyn_cast_MemberExpr(LHSBase);
    RHSME = dyn_cast_MemberExpr(RHSBase);
  }
  
  LHSDeclRef = dyn_cast_DeclRefExpr(LHSBase);
  RHSDeclRef = dyn_cast_DeclRefExpr(RHSBase);
  if ((LHSDeclRef != null) && (RHSDeclRef != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!(LHSDeclRef.getDecl$Const() != null) || !(RHSDeclRef.getDecl$Const() != null)) {
        return;
      }
      if (LHSDeclRef.getDecl$Const().getCanonicalDecl$Const()
         != RHSDeclRef.getDecl$Const().getCanonicalDecl$Const()) {
        return;
      }
      
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(OpLoc), diag.warn_self_move)), LHSExpr.getType()), 
              LHSExpr.getSourceRange()), 
          RHSExpr.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (isa_CXXThisExpr(LHSBase) && isa_CXXThisExpr(RHSBase)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(OpLoc), diag.warn_self_move)), LHSExpr.getType()), 
              LHSExpr.getSourceRange()), 
          RHSExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Check to see if a given expression could have '.c_str()' called on it.

/// Check if we could call '.c_str()' on an object.
///
/// FIXME: This returns the wrong results in some cases (if cv-qualifiers don't
/// allow the call, or if it would be ambiguous).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasCStrMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4831,
 FQN="clang::Sema::hasCStrMethod", NM="_ZN5clang4Sema13hasCStrMethodEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema13hasCStrMethodEPKNS_4ExprE")
//</editor-fold>
public final boolean hasCStrMethod(/*const*/ Expr /*P*/ E) {
  // JAVA: typedef llvm::SmallPtrSet<CXXMethodDecl *, 1> MethodSet
//  final class MethodSet extends SmallPtrSet<CXXMethodDecl /*P*/ >{ };
  SmallPtrSet<CXXMethodDecl /*P*/ > Results = SemaCheckingStatics.<CXXMethodDecl>CXXRecordMembersNamed(CXXMethodDecl.class, new StringRef(/*KEEP_STR*/"c_str"), /*Deref*/$this(), E.getType());
  for (SmallPtrSetIterator<CXXMethodDecl /*P*/ > MI = Results.begin(), ME = Results.end();
       MI.$noteq(ME); MI.$preInc())  {
    if ((MI.$star()).getMinRequiredArguments() == 0) {
      return true;
    }
  }
  return false;
}


/// \brief Diagnose pointers that are always non-null.
/// \param E the expression containing the pointer
/// \param NullKind NPCK_NotNull if E is a cast to bool, otherwise, E is
/// compared to a null pointer
/// \param IsEqual True when the comparison is equal to a null pointer
/// \param Range Extra SourceRange to highlight in the diagnostic
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseAlwaysNonNullPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8664,
 FQN="clang::Sema::DiagnoseAlwaysNonNullPointer", NM="_ZN5clang4Sema28DiagnoseAlwaysNonNullPointerEPNS_4ExprENS1_23NullPointerConstantKindEbNS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema28DiagnoseAlwaysNonNullPointerEPNS_4ExprENS1_23NullPointerConstantKindEbNS_11SourceRangeE")
//</editor-fold>
public final void DiagnoseAlwaysNonNullPointer(Expr /*P*/ E, 
                            Expr.NullPointerConstantKind NullKind, 
                            boolean IsEqual, SourceRange Range) {
  raw_string_ostream S = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!(E != null)) {
      return;
    }
    
    // Don't warn inside macros.
    if (E.getExprLoc().isMacroID()) {
      final /*const*/ SourceManager /*&*/ SM = $this().getSourceManager();
      if (SemaCheckingStatics.IsInAnyMacroBody(SM, E.getExprLoc())
         || SemaCheckingStatics.IsInAnyMacroBody(SM, Range.getBegin())) {
        return;
      }
    }
    E = E.IgnoreImpCasts();
    
    /*const*/boolean IsCompare = NullKind != Expr.NullPointerConstantKind.NPCK_NotNull;
    if (isa_CXXThisExpr(E)) {
      /*uint*/int DiagID = IsCompare ? diag.warn_this_null_compare : diag.warn_this_bool_conversion;
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(E.getExprLoc(), DiagID)), E.getSourceRange()), Range), IsEqual));
      return;
    }
    
    boolean IsAddressOf = false;
    {
      
      UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
      if ((UO != null)) {
        if (UO.getOpcode() != UnaryOperatorKind.UO_AddrOf) {
          return;
        }
        IsAddressOf = true;
        E = UO.getSubExpr();
      }
    }
    if (IsAddressOf) {
      PartialDiagnostic PD = null;
      try {
        /*uint*/int DiagID = IsCompare ? diag.warn_address_of_reference_null_compare : diag.warn_address_of_reference_bool_conversion;
        PD = $c$.clean(new PartialDiagnostic(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange(PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange($c$.track($this().PDiag(DiagID)), E.getSourceRange()), /*NO_COPY*/Range), 
                (IsEqual ? 1 : 0))));
        if (SemaCheckingStatics.CheckForReference(/*Deref*/$this(), E, PD)) {
          return;
        }
      } finally {
        if (PD != null) { PD.$destroy(); }
      }
    }

    final Expr E$final = E;
    T2Void<Attr> ComplainAboutNonnullParamOrCall = /*[&, &E, this, &IsCompare, &Range, &IsEqual]*/ (/*const*/ Attr /*P*/ NonnullAttr) -> {
          raw_string_ostream S$1 = null;
          try {
            boolean IsParam = isa_NonNullAttr(NonnullAttr);
            std.string Str/*J*/= new std.string();
            S$1/*J*/= new raw_string_ostream(Str);
            E$final.printPretty(S$1, (PrinterHelper /*P*/ )null, $this().getPrintingPolicy());
            /*uint*/int DiagID = IsCompare ? diag.warn_nonnull_expr_compare : diag.warn_cast_nonnull_to_bool;
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(E$final.getExprLoc(), DiagID)), IsParam), S$1.str()), 
                        E$final.getSourceRange()), Range), IsEqual));
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(NonnullAttr.getLocation(), diag.note_declared_nonnull)), IsParam));
          } finally {
            if (S$1 != null) { S$1.$destroy(); }
          }
        };
    {
      
      // If we have a CallExpr that is tagged with returns_nonnull, we can complain.
      CallExpr /*P*/ Call = dyn_cast_CallExpr(E.IgnoreParenImpCasts());
      if ((Call != null)) {
        {
          FunctionDecl /*P*/ Callee = Call.getDirectCallee();
          if ((Callee != null)) {
            {
              /*const*/ Attr /*P*/ A = Callee.getAttr(ReturnsNonNullAttr.class);
              if ((A != null)) {
                ComplainAboutNonnullParamOrCall.$call(A);
                return;
              }
            }
          }
        }
      }
    }
    
    // Expect to find a single Decl.  Skip anything more complicated.
    ValueDecl /*P*/ D = null;
    {
      DeclRefExpr /*P*/ R = dyn_cast_DeclRefExpr(E);
      if ((R != null)) {
        D = R.getDecl();
      } else {
        MemberExpr /*P*/ M = dyn_cast_MemberExpr(E);
        if ((M != null)) {
          D = M.getMemberDecl();
        }
      }
    }
    
    // Weak Decls can be null.
    if (!(D != null) || D.isWeak()) {
      return;
    }
    {
      
      // Check for parameter decl with nonnull attribute
      /*const*/ ParmVarDecl /*P*/ PV = dyn_cast_ParmVarDecl(D);
      if ((PV != null)) {
        if (($this().getCurFunction() != null)
           && !($this().getCurFunction().ModifiedNonNullParams.count(PV) != 0)) {
          {
            /*const*/ Attr /*P*/ A = PV.getAttr(NonNullAttr.class);
            if ((A != null)) {
              ComplainAboutNonnullParamOrCall.$call(A);
              return;
            }
          }
          {
            
            /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(PV.getDeclContext$Const());
            if ((FD != null)) {
              type$ptr<ParmVarDecl> ParamIter = $tryClone(llvm.find(FD.parameters$Const(), PV));
              assert ($noteq_ptr(ParamIter, FD.param_end$Const()));
              /*uint*/int ParamNo = std.distance(FD.param_begin$Const(), ParamIter);
              
              for (/*const*/ NonNullAttr /*P*/ NonNull : FD.specific_attrs(NonNullAttr.class)) {
                if (!(NonNull.args_size() != 0)) {
                  ComplainAboutNonnullParamOrCall.$call(NonNull);
                  return;
                }
                
                for (/*uint*/int ArgNo : NonNull.args()) {
                  if (ArgNo == ParamNo) {
                    ComplainAboutNonnullParamOrCall.$call(NonNull);
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
    
    QualType T = D.getType();
    /*const*/boolean IsArray = T.$arrow().isArrayType();
    /*const*/boolean IsFunction = T.$arrow().isFunctionType();
    
    // Address of function is used to silence the function warning.
    if (IsAddressOf && IsFunction) {
      return;
    }
    
    // Found nothing.
    if (!IsAddressOf && !IsFunction && !IsArray) {
      return;
    }
    
    // Pretty print the expression for the diagnostic.
    std.string Str/*J*/= new std.string();
    S/*J*/= new raw_string_ostream(Str);
    E.printPretty(S, (PrinterHelper /*P*/ )null, $this().getPrintingPolicy());
    
    /*uint*/int DiagID = IsCompare ? diag.warn_null_pointer_compare : diag.warn_impcast_pointer_to_bool;
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int AddressOf = 0;
      final /*uint*/int FunctionPointer = AddressOf + 1;
      final /*uint*/int ArrayPointer = FunctionPointer + 1;
    /*}*//*Unnamed enum*//*uint*/int DiagType;
    if (IsAddressOf) {
      DiagType = AddressOf;
    } else if (IsFunction) {
      DiagType = FunctionPointer;
    } else if (IsArray) {
      DiagType = ArrayPointer;
    } else {
      throw new llvm_unreachable("Could not determine diagnostic.");
    }
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), DiagID)), DiagType), S.str()), E.getSourceRange()), 
            Range), IsEqual));
    if (!IsFunction) {
      return;
    }
    
    // Suggest '&' to silence the function warning.
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint($c$.track($this().Diag(E.getExprLoc(), diag.note_function_warning_silence)), 
        FixItHint.CreateInsertion(E.getLocStart(), new StringRef(/*KEEP_STR*/$AMP))));
    
    // Check to see if '()' fixit should be emitted.
    QualType ReturnType/*J*/= new QualType();
    UnresolvedSet NonTemplateOverloads/*J*/= new UnresolvedSet(4);
    $this().tryExprAsCall($Deref(E), ReturnType, NonTemplateOverloads);
    if (ReturnType.isNull()) {
      return;
    }
    if (IsCompare) {
      // There are two cases here.  If there is null constant, the only suggest
      // for a pointer return type.  If the null is 0, then suggest if the return
      // type is a pointer or an integer type.
      if (!ReturnType.$arrow().isPointerType()) {
        if (NullKind == Expr.NullPointerConstantKind.NPCK_ZeroExpression
           || NullKind == Expr.NullPointerConstantKind.NPCK_ZeroLiteral) {
          if (!ReturnType.$arrow().isIntegerType()) {
            return;
          }
        } else {
          return;
        }
      }
    } else { // !IsCompare
// For function to bool, only suggest if the function pointer has bool
// return type.
      if (!ReturnType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Bool.getValue())) {
        return;
      }
    }
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint($c$.track($this().Diag(E.getExprLoc(), diag.note_function_to_function_call)), 
        FixItHint.CreateInsertion($this().getLocForEndOfToken(E.getLocEnd()), new StringRef(/*KEEP_STR*/$LPAREN_RPAREN))));
  } finally {
    if (S != null) { S.$destroy(); }
    $c$.$destroy();
  }
}


/// checkRetainCycles - Check whether an Objective-C message send
/// might create an obvious retain cycle.

/// Check a message send to see if it's likely to cause a retain cycle.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkRetainCycles">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10165,
 FQN="clang::Sema::checkRetainCycles", NM="_ZN5clang4Sema17checkRetainCyclesEPNS_15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema17checkRetainCyclesEPNS_15ObjCMessageExprE")
//</editor-fold>
public final void checkRetainCycles(ObjCMessageExpr /*P*/ msg) {
  // Only check instance methods whose selector looks like a setter.
  if (!msg.isInstanceMessage() || !SemaCheckingStatics.isSetterLikeSelector(msg.getSelector())) {
    return;
  }
  
  // Try to find a variable that the receiver is strongly owned by.
  RetainCycleOwner owner/*J*/= new RetainCycleOwner();
  if (msg.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Instance) {
    if (!SemaCheckingStatics.findRetainCycleOwner(/*Deref*/$this(), msg.getInstanceReceiver(), owner)) {
      return;
    }
  } else {
    assert (msg.getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperInstance);
    owner.Variable = $this().getCurMethodDecl().getSelfDecl();
    owner.Loc.$assignMove(msg.getSuperLoc());
    owner.Range.$assignMove(new SourceRange(msg.getSuperLoc()));
  }
  
  // Check whether the receiver is captured by any of the arguments.
  for (/*uint*/int i = 0, e = msg.getNumArgs(); i != e; ++i)  {
    {
      Expr /*P*/ capturer = SemaCheckingStatics.findCapturingExpr(/*Deref*/$this(), msg.getArg(i), owner);
      if ((capturer != null)) {
        SemaCheckingStatics.diagnoseRetainCycle(/*Deref*/$this(), capturer, owner);
        /*JAVA:return*/return;
      }
    }
  }
}


/// Check a property assign to see if it's likely to cause a retain cycle.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkRetainCycles">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10189,
 FQN="clang::Sema::checkRetainCycles", NM="_ZN5clang4Sema17checkRetainCyclesEPNS_4ExprES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema17checkRetainCyclesEPNS_4ExprES2_")
//</editor-fold>
public final void checkRetainCycles(Expr /*P*/ receiver, Expr /*P*/ argument) {
  RetainCycleOwner owner/*J*/= new RetainCycleOwner();
  if (!SemaCheckingStatics.findRetainCycleOwner(/*Deref*/$this(), receiver, owner)) {
    return;
  }
  {
    
    Expr /*P*/ capturer = SemaCheckingStatics.findCapturingExpr(/*Deref*/$this(), argument, owner);
    if ((capturer != null)) {
      SemaCheckingStatics.diagnoseRetainCycle(/*Deref*/$this(), capturer, owner);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkRetainCycles">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10198,
 FQN="clang::Sema::checkRetainCycles", NM="_ZN5clang4Sema17checkRetainCyclesEPNS_7VarDeclEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema17checkRetainCyclesEPNS_7VarDeclEPNS_4ExprE")
//</editor-fold>
public final void checkRetainCycles(VarDecl /*P*/ Var, Expr /*P*/ Init) {
  RetainCycleOwner Owner/*J*/= new RetainCycleOwner();
  if (!SemaCheckingStatics.considerVariable(Var, /*DeclRefExpr=*/ (Expr /*P*/ )null, Owner)) {
    return;
  }
  
  // Because we don't have an expression for the variable, we have to set the
  // location explicitly here.
  Owner.Loc.$assignMove(Var.getLocation());
  Owner.Range.$assignMove(Var.getSourceRange());
  {
    
    Expr /*P*/ Capturer = SemaCheckingStatics.findCapturingExpr(/*Deref*/$this(), Init, Owner);
    if ((Capturer != null)) {
      SemaCheckingStatics.diagnoseRetainCycle(/*Deref*/$this(), Capturer, Owner);
    }
  }
}


/// checkUnsafeAssigns - Check whether +1 expr is being assigned
/// to weak/__unsafe_unretained type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkUnsafeAssigns">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10255,
 FQN="clang::Sema::checkUnsafeAssigns", NM="_ZN5clang4Sema18checkUnsafeAssignsENS_14SourceLocationENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema18checkUnsafeAssignsENS_14SourceLocationENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public final boolean checkUnsafeAssigns(SourceLocation Loc, 
                  QualType LHS, Expr /*P*/ RHS) {
  Qualifiers.ObjCLifetime LT = LHS.getObjCLifetime();
  if (LT != Qualifiers.ObjCLifetime.OCL_Weak && LT != Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
    return false;
  }
  if (SemaCheckingStatics.checkUnsafeAssignObject(/*Deref*/$this(), new SourceLocation(Loc), LT, RHS, false)) {
    return true;
  }
  
  return false;
}


/// checkUnsafeExprAssigns - Check whether +1 expr is being assigned
/// to weak/__unsafe_unretained expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkUnsafeExprAssigns">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10268,
 FQN="clang::Sema::checkUnsafeExprAssigns", NM="_ZN5clang4Sema22checkUnsafeExprAssignsENS_14SourceLocationEPNS_4ExprES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema22checkUnsafeExprAssignsENS_14SourceLocationEPNS_4ExprES3_")
//</editor-fold>
public final void checkUnsafeExprAssigns(SourceLocation Loc, 
                      Expr /*P*/ LHS, Expr /*P*/ RHS) {
  QualType LHSType/*J*/= new QualType();
  // PropertyRef on LHS type need be directly obtained from
  // its declaration as it has a PseudoType.
  ObjCPropertyRefExpr /*P*/ PRE = dyn_cast_ObjCPropertyRefExpr(LHS.IgnoreParens());
  if ((PRE != null) && !PRE.isImplicitProperty()) {
    /*const*/ ObjCPropertyDecl /*P*/ PD = PRE.getExplicitProperty();
    if ((PD != null)) {
      LHSType.$assignMove(PD.getType());
    }
  }
  if (LHSType.isNull()) {
    LHSType.$assignMove(LHS.getType());
  }
  
  Qualifiers.ObjCLifetime LT = LHSType.getObjCLifetime();
  if (LT == Qualifiers.ObjCLifetime.OCL_Weak) {
    if (!$this().Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, /*NO_COPY*/Loc)) {
      $this().getCurFunction().markSafeWeakUse(LHS);
    }
  }
  if ($this().checkUnsafeAssigns(new SourceLocation(Loc), new QualType(LHSType), RHS)) {
    return;
  }
  
  // FIXME. Check for other life times.
  if (LT != Qualifiers.ObjCLifetime.OCL_None) {
    return;
  }
  if ((PRE != null)) {
    if (PRE.isImplicitProperty()) {
      return;
    }
    /*const*/ ObjCPropertyDecl /*P*/ PD = PRE.getExplicitProperty();
    if (!(PD != null)) {
      return;
    }
    
    /*uint*/int Attributes = PD.getPropertyAttributes();
    if (((Attributes & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign) != 0)) {
      // when 'assign' attribute was not explicitly specified
      // by user, ignore it and rely on property type itself
      // for lifetime info.
      /*uint*/int AsWrittenAttr = PD.getPropertyAttributesAsWritten();
      if (!((AsWrittenAttr & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign) != 0)
         && LHSType.$arrow().isObjCRetainableType()) {
        return;
      }
      {
        
        ImplicitCastExpr /*P*/ cast;
        while (((/*P*/ cast = dyn_cast_ImplicitCastExpr(RHS)) != null)) {
          if (cast.getCastKind() == CastKind.CK_ARCConsumeObject) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_arc_retained_property_assign)), 
                  RHS.getSourceRange()));
              return;
            } finally {
              $c$.$destroy();
            }
          }
          RHS = cast.getSubExpr();
        }
      }
    } else if (((Attributes & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)) {
      if (SemaCheckingStatics.checkUnsafeAssignObject(/*Deref*/$this(), new SourceLocation(Loc), Qualifiers.ObjCLifetime.OCL_Weak, RHS, true)) {
        return;
      }
    }
  }
}

//@}

//===--------------------------------------------------------------------===//
// Extra semantic analysis beyond the C type system
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getLocationOfStringLiteralByte">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 48,
 FQN="clang::Sema::getLocationOfStringLiteralByte", NM="_ZNK5clang4Sema30getLocationOfStringLiteralByteEPKNS_13StringLiteralEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZNK5clang4Sema30getLocationOfStringLiteralByteEPKNS_13StringLiteralEj")
//</editor-fold>
public final SourceLocation getLocationOfStringLiteralByte(/*const*/ StringLiteral /*P*/ SL, 
                              /*uint*/int ByteNo) /*const*/ {
  return SL.getLocationOfByte(ByteNo, $this().getSourceManager(), $this().LangOpts, 
      $this().Context.getTargetInfo());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckArrayAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9598,
 FQN="clang::Sema::CheckArrayAccess", NM="_ZN5clang4Sema16CheckArrayAccessEPKNS_4ExprES3_PKNS_18ArraySubscriptExprEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema16CheckArrayAccessEPKNS_4ExprES3_PKNS_18ArraySubscriptExprEbb")
//</editor-fold>
protected/*private*/ final void CheckArrayAccess(/*const*/ Expr /*P*/ BaseExpr, /*const*/ Expr /*P*/ IndexExpr) {
  CheckArrayAccess(BaseExpr, IndexExpr, 
                (/*const*/ ArraySubscriptExpr /*P*/ )null, 
                true, false);
}
protected/*private*/ final void CheckArrayAccess(/*const*/ Expr /*P*/ BaseExpr, /*const*/ Expr /*P*/ IndexExpr, 
                /*const*/ ArraySubscriptExpr /*P*/ ASE/*= null*/) {
  CheckArrayAccess(BaseExpr, IndexExpr, 
                ASE, 
                true, false);
}
protected/*private*/ final void CheckArrayAccess(/*const*/ Expr /*P*/ BaseExpr, /*const*/ Expr /*P*/ IndexExpr, 
                /*const*/ ArraySubscriptExpr /*P*/ ASE/*= null*/, 
                boolean AllowOnePastEnd/*= true*/) {
  CheckArrayAccess(BaseExpr, IndexExpr, 
                ASE, 
                AllowOnePastEnd, false);
}
protected/*private*/ final void CheckArrayAccess(/*const*/ Expr /*P*/ BaseExpr, /*const*/ Expr /*P*/ IndexExpr, 
                /*const*/ ArraySubscriptExpr /*P*/ ASE/*= null*/, 
                boolean AllowOnePastEnd/*= true*/, boolean IndexNegated/*= false*/) {
  IndexExpr = IndexExpr.IgnoreParenImpCasts$Const();
  if (IndexExpr.isValueDependent()) {
    return;
  }
  
  /*const*/ Type /*P*/ EffectiveType = BaseExpr.getType().$arrow().getPointeeOrArrayElementType();
  BaseExpr = BaseExpr.IgnoreParenCasts$Const();
  /*const*/ ConstantArrayType /*P*/ ArrayTy = $this().Context.getAsConstantArrayType(BaseExpr.getType());
  if (!(ArrayTy != null)) {
    return;
  }
  
  APSInt index/*J*/= new APSInt();
  if (!IndexExpr.EvaluateAsInt(index, $this().Context, Expr.SideEffectsKind.SE_AllowSideEffects)) {
    return;
  }
  if (IndexNegated) {
    index.$assignMove(index.$sub());
  }
  
  /*const*/ NamedDecl /*P*/ ND = null;
  {
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(BaseExpr);
    if ((DRE != null)) {
      ND = dyn_cast_NamedDecl(DRE.getDecl$Const());
    }
  }
  {
    /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(BaseExpr);
    if ((ME != null)) {
      ND = dyn_cast_NamedDecl(ME.getMemberDecl());
    }
  }
  if (index.isUnsigned() || !index.isNegative()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      APInt size = new APInt(ArrayTy.getSize());
      if (!size.isStrictlyPositive()) {
        return;
      }
      
      /*const*/ Type /*P*/ BaseType = BaseExpr.getType().$arrow().getPointeeOrArrayElementType();
      if (BaseType != EffectiveType) {
        // Make sure we're comparing apples to apples when comparing index to size
        long/*uint64_t*/ ptrarith_typesize = $this().Context.getTypeSize(EffectiveType);
        long/*uint64_t*/ array_typesize = $this().Context.getTypeSize(BaseType);
        // Handle ptrarith_typesize being zero, such as when casting to void*
        if (!(ptrarith_typesize != 0)) {
          ptrarith_typesize = 1;
        }
        if (ptrarith_typesize != array_typesize) {
          // There's a cast to a different size type involved
          long/*uint64_t*/ ratio = $div_ulong(array_typesize, ptrarith_typesize);
          // TODO: Be smarter about handling cases where array_typesize is not a
          // multiple of ptrarith_typesize
          if (ptrarith_typesize * ratio == array_typesize) {
            size.$starassign(new APInt(JD$UInt_ULong.INSTANCE, size.getBitWidth(), ratio));
          }
        }
      }
      if ($greater_uint(size.getBitWidth(), index.getBitWidth())) {
        index.$assign(index.zext(size.getBitWidth()));
      } else if ($less_uint(size.getBitWidth(), index.getBitWidth())) {
        size.$assignMove(size.zext(index.getBitWidth()));
      }
      
      // For array subscripting the index must be less than size, but for pointer
      // arithmetic also allow the index (offset) to be equal to size since
      // computing the next address after the end of the array is legal and
      // commonly done e.g. in C++ iterators and range-based for loops.
      if (AllowOnePastEnd ? index.ule(size) : index.ult(size)) {
        return;
      }
      
      // Also don't warn for arrays of size 1 which are members of some
      // structure. These are often used to approximate flexible arrays in C89
      // code.
      if (SemaCheckingStatics.IsTailPaddedMemberArray(/*Deref*/$this(), size, ND)) {
        return;
      }
      
      // Suppress the warning if the subscript expression (as identified by the
      // ']' location) and the index expression are both from macro expansions
      // within a system header.
      if ((ASE != null)) {
        SourceLocation RBracketLoc = $this().SourceMgr.getSpellingLoc(ASE.getRBracketLoc());
        if ($this().SourceMgr.isInSystemHeader(/*NO_COPY*/RBracketLoc)) {
          SourceLocation IndexLoc = $this().SourceMgr.getSpellingLoc(IndexExpr.getLocStart());
          if ($this().SourceMgr.isWrittenInSameFile(/*NO_COPY*/RBracketLoc, /*NO_COPY*/IndexLoc)) {
            return;
          }
        }
      }
      
      /*uint*/int DiagID = diag.warn_ptr_arith_exceeds_bounds;
      if ((ASE != null)) {
        DiagID = diag.warn_array_index_exceeds_bounds;
      }
      
      $c$.clean($this().DiagRuntimeBehavior(BaseExpr.getLocStart(), BaseExpr, 
          PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange(PartialDiagnostic.$out_PartialDiagnostic$C_uint(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track($this().PDiag(DiagID)), new StringRef(index.__toString(10, true))), 
                      new StringRef(size.__toString(10, true))), 
                  (/*uint*/int)$ulong2uint(size.getLimitedValue($uint2ulong(~0/*U*/)))), 
              IndexExpr.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int DiagID = diag.warn_array_index_precedes_bounds;
      if (!(ASE != null)) {
        DiagID = diag.warn_ptr_arith_precedes_bounds;
        if (index.isNegative()) {
          index.$assignMove(index.$sub());
        }
      }
      
      $c$.clean($this().DiagRuntimeBehavior(BaseExpr.getLocStart(), BaseExpr, 
          PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track($this().PDiag(DiagID)), new StringRef(index.__toString(10, true))), 
              IndexExpr.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  if (!(ND != null)) {
    {
      // Try harder to find a NamedDecl to point at in the note.
      /*const*/ ArraySubscriptExpr /*P*/ ASE$1;
      while (((/*P*/ ASE$1 = dyn_cast_ArraySubscriptExpr(BaseExpr)) != null)) {
        BaseExpr = ASE$1.getBase$Const().IgnoreParenCasts$Const();
      }
    }
    {
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(BaseExpr);
      if ((DRE != null)) {
        ND = dyn_cast_NamedDecl(DRE.getDecl$Const());
      }
    }
    {
      /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(BaseExpr);
      if ((ME != null)) {
        ND = dyn_cast_NamedDecl(ME.getMemberDecl());
      }
    }
  }
  if ((ND != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($this().DiagRuntimeBehavior(ND.getLocStart(), BaseExpr, 
          $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.note_array_index_out_of_bounds)), 
              ND.getDeclName())));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckArrayAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9717,
 FQN="clang::Sema::CheckArrayAccess", NM="_ZN5clang4Sema16CheckArrayAccessEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema16CheckArrayAccessEPKNS_4ExprE")
//</editor-fold>
protected/*private*/ final void CheckArrayAccess(/*const*/ Expr /*P*/ expr) {
  int AllowOnePastEnd = 0;
  while ((expr != null)) {
    expr = expr.IgnoreParenImpCasts$Const();
    switch (expr.getStmtClass()) {
     case ArraySubscriptExprClass:
      {
        /*const*/ ArraySubscriptExpr /*P*/ ASE = cast_ArraySubscriptExpr(expr);
        $this().CheckArrayAccess(ASE.getBase$Const(), ASE.getIdx$Const(), ASE, 
            AllowOnePastEnd > 0);
        return;
      }
     case OMPArraySectionExprClass:
      {
        /*const*/ OMPArraySectionExpr /*P*/ ASE = cast_OMPArraySectionExpr(expr);
        if ((ASE.getLowerBound$Const() != null)) {
          $this().CheckArrayAccess(ASE.getBase$Const(), ASE.getLowerBound$Const(), 
              /*ASE=*/ (/*const*/ ArraySubscriptExpr /*P*/ )null, AllowOnePastEnd > 0);
        }
        return;
      }
     case UnaryOperatorClass:
      {
        // Only unwrap the * and & unary operators
        /*const*/ UnaryOperator /*P*/ UO = cast_UnaryOperator(expr);
        expr = UO.getSubExpr();
        switch (UO.getOpcode()) {
         case UO_AddrOf:
          AllowOnePastEnd++;
          break;
         case UO_Deref:
          AllowOnePastEnd--;
          break;
         default:
          return;
        }
        break;
      }
     case ConditionalOperatorClass:
      {
        /*const*/ ConditionalOperator /*P*/ cond = cast_ConditionalOperator(expr);
        {
          /*const*/ Expr /*P*/ lhs = cond.getLHS();
          if ((lhs != null)) {
            $this().CheckArrayAccess(lhs);
          }
        }
        {
          /*const*/ Expr /*P*/ rhs = cond.getRHS();
          if ((rhs != null)) {
            $this().CheckArrayAccess(rhs);
          }
        }
        return;
      }
     default:
      return;
    }
  }
}


/// Given a FunctionDecl's FormatAttr, attempts to populate the FomatStringInfo
/// parameter with the FormatAttr's correct format_idx and firstDataArg.
/// Returns true when the format fits the function and the FormatStringInfo has
/// been populated.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getFormatStringInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1875,
 FQN="clang::Sema::getFormatStringInfo", NM="_ZN5clang4Sema19getFormatStringInfoEPKNS_10FormatAttrEbPNS0_16FormatStringInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema19getFormatStringInfoEPKNS_10FormatAttrEbPNS0_16FormatStringInfoE")
//</editor-fold>
protected/*private*/ static boolean getFormatStringInfo(/*const*/ FormatAttr /*P*/ Format, boolean IsCXXMember, 
                   FormatStringInfo /*P*/ FSI) {
  FSI.HasVAListArg = Format.getFirstArg() == 0;
  FSI.FormatIdx = Format.getFormatIdx() - 1;
  FSI.FirstDataArg = FSI.HasVAListArg ? 0 : Format.getFirstArg() - 1;
  
  // The way the format attribute works in GCC, the implicit this argument
  // of member functions is counted. However, it doesn't appear in our own
  // lists, so decrement format_idx in that case.
  if (IsCXXMember) {
    if (FSI.FormatIdx == 0) {
      return false;
    }
    --FSI.FormatIdx;
    if (FSI.FirstDataArg != 0) {
      --FSI.FirstDataArg;
    }
  }
  return true;
}


/// CheckFunctionCall - Check a direct function call for various correctness
/// and safety properties not strictly enforced by the C type system.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2148,
 FQN="clang::Sema::CheckFunctionCall", NM="_ZN5clang4Sema17CheckFunctionCallEPNS_12FunctionDeclEPNS_8CallExprEPKNS_17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema17CheckFunctionCallEPNS_12FunctionDeclEPNS_8CallExprEPKNS_17FunctionProtoTypeE")
//</editor-fold>
protected/*private*/ final boolean CheckFunctionCall(FunctionDecl /*P*/ FDecl, CallExpr /*P*/ TheCall, 
                 /*const*/ FunctionProtoType /*P*/ Proto) {
  boolean IsMemberOperatorCall = isa_CXXOperatorCallExpr(TheCall)
     && isa_CXXMethodDecl(FDecl);
  boolean IsMemberFunction = isa_CXXMemberCallExpr(TheCall)
     || IsMemberOperatorCall;
  VariadicCallType CallType = $this().getVariadicCallType(FDecl, Proto, 
      TheCall.getCallee());
  type$ptr<Expr /*P*/ /*P*/> Args = $tryClone(TheCall.getArgs());
  /*uint*/int NumArgs = TheCall.getNumArgs();
  if (IsMemberOperatorCall) {
    // If this is a call to a member operator, hide the first argument
    // from checkCall.
    // FIXME: Our choice of AST representation here is less than ideal.
    Args.$preInc();
    --NumArgs;
  }
  $this().checkCall(FDecl, Proto, new ArrayRef</*const*/ Expr /*P*/ >(JD$Convertible.INSTANCE, llvm.makeArrayRef(Args, NumArgs, true), true), 
      IsMemberFunction, TheCall.getRParenLoc(), 
      TheCall.getCallee().getSourceRange(), CallType);
  
  IdentifierInfo /*P*/ FnInfo = FDecl.getIdentifier();
  // None of the checks below are needed for functions that don't have
  // simple names (e.g., C++ conversion functions).
  if (!(FnInfo != null)) {
    return false;
  }
  
  $this().CheckAbsoluteValueFunction(TheCall, FDecl, FnInfo);
  if ($this().getLangOpts().ObjC1) {
    SemaCheckingStatics.DiagnoseCStringFormatDirectiveInCFAPI(/*Deref*/$this(), FDecl, Args, NumArgs);
  }
  
  /*uint*/int CMId = FDecl.getMemoryFunctionKind();
  if (CMId == 0) {
    return false;
  }
  
  // Handle memory setting and copying functions.
  if (CMId == Builtin.ID.BIstrlcpy.getValue() || CMId == Builtin.ID.BIstrlcat.getValue()) {
    $this().CheckStrlcpycatArguments(TheCall, FnInfo);
  } else if (CMId == Builtin.ID.BIstrncat.getValue()) {
    $this().CheckStrncatArguments(TheCall, FnInfo);
  } else {
    $this().CheckMemaccessArguments(TheCall, CMId, FnInfo);
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCMethodCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2194,
 FQN="clang::Sema::CheckObjCMethodCall", NM="_ZN5clang4Sema19CheckObjCMethodCallEPNS_14ObjCMethodDeclENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema19CheckObjCMethodCallEPNS_14ObjCMethodDeclENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4ExprEEE")
//</editor-fold>
protected/*private*/ final boolean CheckObjCMethodCall(ObjCMethodDecl /*P*/ Method, SourceLocation lbrac, 
                   ArrayRef</*const*/ Expr /*P*/ > Args) {
  VariadicCallType CallType = Method.isVariadic() ? VariadicCallType.VariadicMethod : VariadicCallType.VariadicDoesNotApply;
  
  $this().checkCall(Method, (/*const*/ FunctionProtoType /*P*/ )null, new ArrayRef</*const*/ Expr /*P*/ >(Args), 
      /*IsMemberFunction=*/ false, new SourceLocation(lbrac), Method.getSourceRange(), 
      CallType);
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPointerCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2206,
 FQN="clang::Sema::CheckPointerCall", NM="_ZN5clang4Sema16CheckPointerCallEPNS_9NamedDeclEPNS_8CallExprEPKNS_17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema16CheckPointerCallEPNS_9NamedDeclEPNS_8CallExprEPKNS_17FunctionProtoTypeE")
//</editor-fold>
protected/*private*/ final boolean CheckPointerCall(NamedDecl /*P*/ NDecl, CallExpr /*P*/ TheCall, 
                /*const*/ FunctionProtoType /*P*/ Proto) {
  QualType Ty/*J*/= new QualType();
  {
    /*const*/ VarDecl /*P*/ V = dyn_cast_VarDecl(NDecl);
    if ((V != null)) {
      Ty.$assignMove(V.getType().getNonReferenceType());
    } else {
      /*const*/ FieldDecl /*P*/ F = dyn_cast_FieldDecl(NDecl);
      if ((F != null)) {
        Ty.$assignMove(F.getType().getNonReferenceType());
      } else {
        return false;
      }
    }
  }
  if (!Ty.$arrow().isBlockPointerType() && !Ty.$arrow().isFunctionPointerType()
     && !Ty.$arrow().isFunctionProtoType()) {
    return false;
  }
  
  VariadicCallType CallType;
  if (!(Proto != null) || !Proto.isVariadic()) {
    CallType = VariadicCallType.VariadicDoesNotApply;
  } else if (Ty.$arrow().isBlockPointerType()) {
    CallType = VariadicCallType.VariadicBlock;
  } else { // Ty->isFunctionPointerType()
    CallType = VariadicCallType.VariadicFunction;
  }
  
  $this().checkCall(NDecl, Proto, 
      new ArrayRef</*const*/ Expr /*P*/ >(JD$Convertible.INSTANCE, llvm.makeArrayRef(TheCall.getArgs(), TheCall.getNumArgs(), true), true), 
      /*IsMemberFunction=*/ false, TheCall.getRParenLoc(), 
      TheCall.getCallee().getSourceRange(), CallType);
  
  return false;
}


/// Checks function calls when a FunctionDecl or a NamedDecl is not available,
/// such as function pointers returned from functions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOtherCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2239,
 FQN="clang::Sema::CheckOtherCall", NM="_ZN5clang4Sema14CheckOtherCallEPNS_8CallExprEPKNS_17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema14CheckOtherCallEPNS_8CallExprEPKNS_17FunctionProtoTypeE")
//</editor-fold>
protected/*private*/ final boolean CheckOtherCall(CallExpr /*P*/ TheCall, /*const*/ FunctionProtoType /*P*/ Proto) {
  VariadicCallType CallType = $this().getVariadicCallType(/*FDecl=*/ (FunctionDecl /*P*/ )null, Proto, 
      TheCall.getCallee());
  $this().checkCall(/*FDecl=*/ (NamedDecl /*P*/ )null, Proto, 
      new ArrayRef</*const*/ Expr /*P*/ >(JD$Convertible.INSTANCE, llvm.makeArrayRef(TheCall.getArgs(), TheCall.getNumArgs(), true), true), 
      /*IsMemberFunction=*/ false, TheCall.getRParenLoc(), 
      TheCall.getCallee().getSourceRange(), CallType);
  
  return false;
}


/// CheckConstructorCall - Check a constructor call for correctness and safety
/// properties not enforced by the C type system.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2136,
 FQN="clang::Sema::CheckConstructorCall", NM="_ZN5clang4Sema20CheckConstructorCallEPNS_12FunctionDeclEN4llvm8ArrayRefIPKNS_4ExprEEEPKNS_17FunctionProtoTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema20CheckConstructorCallEPNS_12FunctionDeclEN4llvm8ArrayRefIPKNS_4ExprEEEPKNS_17FunctionProtoTypeENS_14SourceLocationE")
//</editor-fold>
protected/*private*/ final void CheckConstructorCall(FunctionDecl /*P*/ FDecl, 
                    ArrayRef</*const*/ Expr /*P*/ > Args, 
                    /*const*/ FunctionProtoType /*P*/ Proto, 
                    SourceLocation Loc) {
  VariadicCallType CallType = Proto.isVariadic() ? VariadicCallType.VariadicConstructor : VariadicCallType.VariadicDoesNotApply;
  $this().checkCall(FDecl, Proto, new ArrayRef</*const*/ Expr /*P*/ >(Args), /*IsMemberFunction=*/ true, new SourceLocation(Loc), new SourceRange(), 
      CallType);
}


/// Handles the checks for format strings, non-POD arguments to vararg
/// functions, and NULL arguments passed to non-NULL parameters.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2084,
 FQN="clang::Sema::checkCall", NM="_ZN5clang4Sema9checkCallEPNS_9NamedDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIPKNS_4ExprEEEbNS_14SourceLocationENS_11SourceRangeENS0_16VariadicCallTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema9checkCallEPNS_9NamedDeclEPKNS_17FunctionProtoTypeEN4llvm8ArrayRefIPKNS_4ExprEEEbNS_14SourceLocationENS_11SourceRangeENS0_16VariadicCallTypeE")
//</editor-fold>
protected/*private*/ final void checkCall(NamedDecl /*P*/ FDecl, /*const*/ FunctionProtoType /*P*/ Proto, 
         ArrayRef</*const*/ Expr /*P*/ > Args, boolean IsMemberFunction, 
         SourceLocation Loc, SourceRange Range, 
         VariadicCallType CallType) {
  // FIXME: We should check as much as we can in the template definition.
  if ($this().CurContext.isDependentContext()) {
    return;
  }

  // Printf and scanf checking.
  SmallBitVector CheckedVarArgs/*J*/= new SmallBitVector();
  if ((FDecl != null)) {
    for (/*const*/ FormatAttr /*P*/ I : FDecl.specific_attrs(FormatAttr.class)) {
      // Only create vector if there are format attributes.
      CheckedVarArgs.resize(Args.size());

      $this().CheckFormatArguments(I, new ArrayRef</*const*/ Expr /*P*/ >(Args), IsMemberFunction, CallType, new SourceLocation(Loc), new SourceRange(Range), 
          CheckedVarArgs);
    }
  }

  // Refuse POD arguments that weren't caught by the format string
  // checks above.
  if (CallType != VariadicCallType.VariadicDoesNotApply) {
    /*uint*/int NumParams = (Proto != null) ? Proto.getNumParams() : (FDecl != null) && isa_FunctionDecl(FDecl) ? cast_FunctionDecl(FDecl).getNumParams() : (FDecl != null) && isa_ObjCMethodDecl(FDecl) ? cast_ObjCMethodDecl(FDecl).param_size() : 0;

    for (/*uint*/int ArgIdx = NumParams; $less_uint(ArgIdx, Args.size()); ++ArgIdx) {
      {
        // Args[ArgIdx] can be null in malformed code.
        /*const*/ Expr /*P*/ Arg = Args.$at(ArgIdx);
        if ((Arg != null)) {
          if (CheckedVarArgs.empty() || !CheckedVarArgs.$at$Const(ArgIdx)) {
            $this().checkVariadicArgument(Arg, CallType);
          }
        }
      }
    }
  }
  if ((FDecl != null) || (Proto != null)) {
    SemaCheckingStatics.CheckNonNullArguments(/*Deref*/$this(), FDecl, Proto, new ArrayRef</*const*/ Expr /*P*/ >(Args), new SourceLocation(Loc));

    // Type safety checking.
    if ((FDecl != null)) {
      for (/*const*/ ArgumentWithTypeTagAttr /*P*/ I : FDecl.specific_attrs(ArgumentWithTypeTagAttr.class))  {
        $this().CheckArgumentWithTypeTag(I, Args.data());
      }
    }
  }
}


/// CheckObjCString - Checks that the argument to the builtin
/// CFString constructor is correct
/// Note: It might also make sense to do the UTF-16 conversion here (would
/// simplify the backend).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3089,
 FQN="clang::Sema::CheckObjCString", NM="_ZN5clang4Sema15CheckObjCStringEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema15CheckObjCStringEPNS_4ExprE")
//</editor-fold>
protected/*private*/ final boolean CheckObjCString(Expr /*P*/ Arg) {
  Arg = Arg.IgnoreParenCasts();
  StringLiteral /*P*/ Literal = dyn_cast_StringLiteral(Arg);
  if (!(Literal != null) || !Literal.isAscii()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(Arg.getLocStart(), diag.err_cfstring_literal_not_string_constant)), 
          Arg.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (Literal.containsNonAsciiOrNull()) {
    StringRef String = Literal.getString();
    /*uint*/int NumBytes = String.size();
    SmallVectorUShort ToBuf/*J*/= new SmallVectorUShort(JD$UInt_T$C$R.INSTANCE, 128, NumBytes, (char/*UTF16*/)0);
    /*const*/char$ptr/*UTF8 P*/ FromPtr = $tryClone(reinterpret_cast(/*const*/char$ptr/*UTF8 P*/ .class, String.data()));
    ushort$ptr/*UTF16 P*/ ToPtr = $tryClone($AddrOf(ToBuf.ptr$at(0)));
    
    ConversionResult Result = ConvertUTF8toUTF16(FromPtr.$addr(), FromPtr.$add(NumBytes), 
        ToPtr.$addr(), ToPtr.$add(NumBytes), 
        ConversionFlags.strictConversion);
    // Check for conversion failure.
    if (Result != ConversionResult.conversionOK) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(Arg.getLocStart(), 
                diag.warn_cfstring_truncated)), Arg.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckBuiltinFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 717,
 FQN="clang::Sema::CheckBuiltinFunctionCall", NM="_ZN5clang4Sema24CheckBuiltinFunctionCallEPNS_12FunctionDeclEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema24CheckBuiltinFunctionCallEPNS_12FunctionDeclEjPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final ActionResultTTrue<Expr /*P*/ > CheckBuiltinFunctionCall(FunctionDecl /*P*/ FDecl, /*uint*/int BuiltinID, 
                        CallExpr /*P*/ TheCall) {
  ActionResultTTrue<Expr /*P*/ > TheCallResult/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall);
  
  // Find out if any arguments are required to be integer constant expressions.
  uint$ptr ICEArguments = create_uint$ptr(0);
  type$ref<ASTContext.GetBuiltinTypeError> Error = create_type$ref();
  $this().Context.GetBuiltinType(BuiltinID, Error, $AddrOf(ICEArguments));
  if (Error.$deref() != ASTContext.GetBuiltinTypeError.GE_None) {
    ICEArguments.$set(0); // Don't diagnose previously diagnosed errors.
  }
  
  // If any arguments are required to be ICE's, check and diagnose.
  for (/*uint*/int ArgNo = 0; ICEArguments.$star() != 0; ++ArgNo) {
    // Skip arguments not required to be ICE's.
    if ((ICEArguments.$star() & (1 << ArgNo)) == 0) {
      continue;
    }
    
    APSInt Result/*J*/= new APSInt();
    if ($this().SemaBuiltinConstantArg(TheCall, ArgNo, Result)) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    ICEArguments.$set(ICEArguments.$star() & ~(1 << ArgNo));
  }
  switch (ID.valueOf(BuiltinID)) {
   case BI__builtin___CFStringMakeConstantString:
    assert (TheCall.getNumArgs() == 1) : "Wrong # arguments to builtin CFStringMakeConstantString";
    if ($this().CheckObjCString(TheCall.getArg(0))) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_stdarg_start:
   case BI__builtin_va_start:
    if ($this().SemaBuiltinVAStart(TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__va_start:
    {
      switch ($this().Context.getTargetInfo().getTriple().getArch()) {
       case arm:
       case thumb:
        if ($this().SemaBuiltinVAStartARM(TheCall)) {
          return SemaClangGlobals.ExprError();
        }
        break;
       default:
        if ($this().SemaBuiltinVAStart(TheCall)) {
          return SemaClangGlobals.ExprError();
        }
        break;
      }
      break;
    }
   case BI__builtin_isgreater:
   case BI__builtin_isgreaterequal:
   case BI__builtin_isless:
   case BI__builtin_islessequal:
   case BI__builtin_islessgreater:
   case BI__builtin_isunordered:
    if ($this().SemaBuiltinUnorderedCompare(TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_fpclassify:
    if ($this().SemaBuiltinFPClassification(TheCall, 6)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_isfinite:
   case BI__builtin_isinf:
   case BI__builtin_isinf_sign:
   case BI__builtin_isnan:
   case BI__builtin_isnormal:
    if ($this().SemaBuiltinFPClassification(TheCall, 1)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_shufflevector:
    return $this().SemaBuiltinShuffleVector(TheCall);
   case BI__builtin_prefetch:
    // TheCall will be freed by the smart pointer here, but that's fine, since
    // SemaBuiltinShuffleVector guts it, but then doesn't release it.
    if ($this().SemaBuiltinPrefetch(TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__assume:
   case BI__builtin_assume:
    if ($this().SemaBuiltinAssume(TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_assume_aligned:
    if ($this().SemaBuiltinAssumeAligned(TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_object_size:
    if ($this().SemaBuiltinConstantArgRange(TheCall, 1, 0, 3)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_longjmp:
    if ($this().SemaBuiltinLongjmp(TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_setjmp:
    if ($this().SemaBuiltinSetjmp(TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI_setjmp:
   case BI_setjmpex:
    if (SemaCheckingStatics.checkArgCount(/*Deref*/$this(), TheCall, 1)) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    break;
   case BI__builtin_classify_type:
    if (SemaCheckingStatics.checkArgCount(/*Deref*/$this(), TheCall, 1)) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    TheCall.setType($this().Context.IntTy.$QualType());
    break;
   case BI__builtin_constant_p:
    if (SemaCheckingStatics.checkArgCount(/*Deref*/$this(), TheCall, 1)) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    TheCall.setType($this().Context.IntTy.$QualType());
    break;
   case BI__sync_fetch_and_add:
   case BI__sync_fetch_and_add_1:
   case BI__sync_fetch_and_add_2:
   case BI__sync_fetch_and_add_4:
   case BI__sync_fetch_and_add_8:
   case BI__sync_fetch_and_add_16:
   case BI__sync_fetch_and_sub:
   case BI__sync_fetch_and_sub_1:
   case BI__sync_fetch_and_sub_2:
   case BI__sync_fetch_and_sub_4:
   case BI__sync_fetch_and_sub_8:
   case BI__sync_fetch_and_sub_16:
   case BI__sync_fetch_and_or:
   case BI__sync_fetch_and_or_1:
   case BI__sync_fetch_and_or_2:
   case BI__sync_fetch_and_or_4:
   case BI__sync_fetch_and_or_8:
   case BI__sync_fetch_and_or_16:
   case BI__sync_fetch_and_and:
   case BI__sync_fetch_and_and_1:
   case BI__sync_fetch_and_and_2:
   case BI__sync_fetch_and_and_4:
   case BI__sync_fetch_and_and_8:
   case BI__sync_fetch_and_and_16:
   case BI__sync_fetch_and_xor:
   case BI__sync_fetch_and_xor_1:
   case BI__sync_fetch_and_xor_2:
   case BI__sync_fetch_and_xor_4:
   case BI__sync_fetch_and_xor_8:
   case BI__sync_fetch_and_xor_16:
   case BI__sync_fetch_and_nand:
   case BI__sync_fetch_and_nand_1:
   case BI__sync_fetch_and_nand_2:
   case BI__sync_fetch_and_nand_4:
   case BI__sync_fetch_and_nand_8:
   case BI__sync_fetch_and_nand_16:
   case BI__sync_add_and_fetch:
   case BI__sync_add_and_fetch_1:
   case BI__sync_add_and_fetch_2:
   case BI__sync_add_and_fetch_4:
   case BI__sync_add_and_fetch_8:
   case BI__sync_add_and_fetch_16:
   case BI__sync_sub_and_fetch:
   case BI__sync_sub_and_fetch_1:
   case BI__sync_sub_and_fetch_2:
   case BI__sync_sub_and_fetch_4:
   case BI__sync_sub_and_fetch_8:
   case BI__sync_sub_and_fetch_16:
   case BI__sync_and_and_fetch:
   case BI__sync_and_and_fetch_1:
   case BI__sync_and_and_fetch_2:
   case BI__sync_and_and_fetch_4:
   case BI__sync_and_and_fetch_8:
   case BI__sync_and_and_fetch_16:
   case BI__sync_or_and_fetch:
   case BI__sync_or_and_fetch_1:
   case BI__sync_or_and_fetch_2:
   case BI__sync_or_and_fetch_4:
   case BI__sync_or_and_fetch_8:
   case BI__sync_or_and_fetch_16:
   case BI__sync_xor_and_fetch:
   case BI__sync_xor_and_fetch_1:
   case BI__sync_xor_and_fetch_2:
   case BI__sync_xor_and_fetch_4:
   case BI__sync_xor_and_fetch_8:
   case BI__sync_xor_and_fetch_16:
   case BI__sync_nand_and_fetch:
   case BI__sync_nand_and_fetch_1:
   case BI__sync_nand_and_fetch_2:
   case BI__sync_nand_and_fetch_4:
   case BI__sync_nand_and_fetch_8:
   case BI__sync_nand_and_fetch_16:
   case BI__sync_val_compare_and_swap:
   case BI__sync_val_compare_and_swap_1:
   case BI__sync_val_compare_and_swap_2:
   case BI__sync_val_compare_and_swap_4:
   case BI__sync_val_compare_and_swap_8:
   case BI__sync_val_compare_and_swap_16:
   case BI__sync_bool_compare_and_swap:
   case BI__sync_bool_compare_and_swap_1:
   case BI__sync_bool_compare_and_swap_2:
   case BI__sync_bool_compare_and_swap_4:
   case BI__sync_bool_compare_and_swap_8:
   case BI__sync_bool_compare_and_swap_16:
   case BI__sync_lock_test_and_set:
   case BI__sync_lock_test_and_set_1:
   case BI__sync_lock_test_and_set_2:
   case BI__sync_lock_test_and_set_4:
   case BI__sync_lock_test_and_set_8:
   case BI__sync_lock_test_and_set_16:
   case BI__sync_lock_release:
   case BI__sync_lock_release_1:
   case BI__sync_lock_release_2:
   case BI__sync_lock_release_4:
   case BI__sync_lock_release_8:
   case BI__sync_lock_release_16:
   case BI__sync_swap:
   case BI__sync_swap_1:
   case BI__sync_swap_2:
   case BI__sync_swap_4:
   case BI__sync_swap_8:
   case BI__sync_swap_16:
    return $this().SemaBuiltinAtomicOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult));
   case BI__builtin_nontemporal_load:
   case BI__builtin_nontemporal_store:
    return $this().SemaBuiltinNontemporalOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult));
   case BI__c11_atomic_init:
    
    // C11 _Atomic operations for <stdatomic.h>.
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_init);
   case BI__c11_atomic_load:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_load);
   case BI__c11_atomic_store:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_store);
   case BI__c11_atomic_exchange:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_exchange);
   case BI__c11_atomic_compare_exchange_strong:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_compare_exchange_strong);
   case BI__c11_atomic_compare_exchange_weak:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_compare_exchange_weak);
   case BI__c11_atomic_fetch_add:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_fetch_add);
   case BI__c11_atomic_fetch_sub:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_fetch_sub);
   case BI__c11_atomic_fetch_and:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_fetch_and);
   case BI__c11_atomic_fetch_or:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_fetch_or);
   case BI__c11_atomic_fetch_xor:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__c11_atomic_fetch_xor);
   case BI__atomic_load:
    
    // GNU atomic builtins.
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_load);
   case BI__atomic_load_n:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_load_n);
   case BI__atomic_store:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_store);
   case BI__atomic_store_n:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_store_n);
   case BI__atomic_exchange:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_exchange);
   case BI__atomic_exchange_n:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_exchange_n);
   case BI__atomic_compare_exchange:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_compare_exchange);
   case BI__atomic_compare_exchange_n:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_compare_exchange_n);
   case BI__atomic_fetch_add:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_fetch_add);
   case BI__atomic_fetch_sub:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_fetch_sub);
   case BI__atomic_fetch_and:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_fetch_and);
   case BI__atomic_fetch_or:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_fetch_or);
   case BI__atomic_fetch_xor:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_fetch_xor);
   case BI__atomic_fetch_nand:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_fetch_nand);
   case BI__atomic_add_fetch:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_add_fetch);
   case BI__atomic_sub_fetch:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_sub_fetch);
   case BI__atomic_and_fetch:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_and_fetch);
   case BI__atomic_or_fetch:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_or_fetch);
   case BI__atomic_xor_fetch:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_xor_fetch);
   case BI__atomic_nand_fetch:
    return $this().SemaAtomicOpsOverloaded(new ActionResultTTrue<Expr /*P*/ >(TheCallResult), AtomicExpr.AtomicOp.AO__atomic_nand_fetch);
   case BI__builtin_annotation:
    if (SemaCheckingStatics.SemaBuiltinAnnotation(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_addressof:
    if (SemaCheckingStatics.SemaBuiltinAddressof(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_add_overflow:
   case BI__builtin_sub_overflow:
   case BI__builtin_mul_overflow:
    if (SemaCheckingStatics.SemaBuiltinOverflow(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__builtin_operator_new:
   case BI__builtin_operator_delete:
    if (!$this().getLangOpts().CPlusPlus) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track($this().Diag(TheCall.getExprLoc(), diag.err_builtin_requires_language)), 
                (BuiltinID == Builtin.ID.BI__builtin_operator_new.getValue() ? $("__builtin_operator_new") : $("__builtin_operator_delete"))), 
            /*KEEP_STR*/"C++"));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    // CodeGen assumes it can find the global new and delete to call,
    // so ensure that they are declared.
    $this().DeclareGlobalNewDelete();
    break;
   case BI__builtin___memcpy_chk:
   case BI__builtin___memmove_chk:
   case BI__builtin___memset_chk:
   case BI__builtin___strlcat_chk:
   case BI__builtin___strlcpy_chk:
   case BI__builtin___strncat_chk:
   case BI__builtin___strncpy_chk:
   case BI__builtin___stpncpy_chk:
    
    // check secure string manipulation functions where overflows
    // are detectable at compile time
    SemaCheckingStatics.SemaBuiltinMemChkCall(/*Deref*/$this(), FDecl, TheCall, 2, 3);
    break;
   case BI__builtin___memccpy_chk:
    SemaCheckingStatics.SemaBuiltinMemChkCall(/*Deref*/$this(), FDecl, TheCall, 3, 4);
    break;
   case BI__builtin___snprintf_chk:
   case BI__builtin___vsnprintf_chk:
    SemaCheckingStatics.SemaBuiltinMemChkCall(/*Deref*/$this(), FDecl, TheCall, 1, 3);
    break;
   case BI__builtin_call_with_static_chain:
    if (SemaCheckingStatics.SemaBuiltinCallWithStaticChain(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__exception_code:
   case BI_exception_code:
    if (SemaCheckingStatics.SemaBuiltinSEHScopeCheck(/*Deref*/$this(), TheCall, Scope.ScopeFlags.SEHExceptScope, 
        diag.err_seh___except_block)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__exception_info:
   case BI_exception_info:
    if (SemaCheckingStatics.SemaBuiltinSEHScopeCheck(/*Deref*/$this(), TheCall, Scope.ScopeFlags.SEHFilterScope, 
        diag.err_seh___except_filter)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BI__GetExceptionInfo:
    if (SemaCheckingStatics.checkArgCount(/*Deref*/$this(), TheCall, 1)) {
      return SemaClangGlobals.ExprError();
    }
    if ($this().CheckCXXThrowOperand(TheCall.getLocStart(), 
        $this().Context.getExceptionObjectType(FDecl.getParamDecl(0).getType()), 
        TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    
    TheCall.setType($this().Context.VoidPtrTy.$QualType());
    break;
   case BIread_pipe:
   case BIwrite_pipe:
    // Since those two functions are declared with var args, we need a semantic
    // check for the argument.
    if (SemaCheckingStatics.SemaBuiltinRWPipe(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BIreserve_read_pipe:
   case BIreserve_write_pipe:
   case BIwork_group_reserve_read_pipe:
   case BIwork_group_reserve_write_pipe:
   case BIsub_group_reserve_read_pipe:
   case BIsub_group_reserve_write_pipe:
    if (SemaCheckingStatics.SemaBuiltinReserveRWPipe(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    // Since return type of reserve_read/write_pipe built-in function is
    // reserve_id_t, which is not defined in the builtin def file , we used int
    // as return type and need to override the return type of these functions.
    TheCall.setType($this().Context.OCLReserveIDTy.$QualType());
    break;
   case BIcommit_read_pipe:
   case BIcommit_write_pipe:
   case BIwork_group_commit_read_pipe:
   case BIwork_group_commit_write_pipe:
   case BIsub_group_commit_read_pipe:
   case BIsub_group_commit_write_pipe:
    if (SemaCheckingStatics.SemaBuiltinCommitRWPipe(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BIget_pipe_num_packets:
   case BIget_pipe_max_packets:
    if (SemaCheckingStatics.SemaBuiltinPipePackets(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BIto_global:
   case BIto_local:
   case BIto_private:
    if (SemaCheckingStatics.SemaOpenCLBuiltinToAddr(/*Deref*/$this(), BuiltinID, TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BIenqueue_kernel:
    // OpenCL v2.0, s6.13.17 - Enqueue kernel functions.
    if (SemaCheckingStatics.SemaOpenCLBuiltinEnqueueKernel(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
    break;
   case BIget_kernel_work_group_size:
   case BIget_kernel_preferred_work_group_size_multiple:
    if (SemaCheckingStatics.SemaOpenCLBuiltinKernelWorkGroupSize(/*Deref*/$this(), TheCall)) {
      return SemaClangGlobals.ExprError();
    }
  }
  
  // Since the target specific builtins for each arch overlap, only check those
  // of the arch we are compiling for.
  if ($this().Context.BuiltinInfo.isTSBuiltin(BuiltinID)) {
    switch ($this().Context.getTargetInfo().getTriple().getArch()) {
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      if ($this().CheckARMBuiltinFunctionCall(BuiltinID, TheCall)) {
        return SemaClangGlobals.ExprError();
      }
      break;
     case aarch64:
     case aarch64_be:
      if ($this().CheckAArch64BuiltinFunctionCall(BuiltinID, TheCall)) {
        return SemaClangGlobals.ExprError();
      }
      break;
     case mips:
     case mipsel:
     case mips64:
     case mips64el:
      if ($this().CheckMipsBuiltinFunctionCall(BuiltinID, TheCall)) {
        return SemaClangGlobals.ExprError();
      }
      break;
     case systemz:
      if ($this().CheckSystemZBuiltinFunctionCall(BuiltinID, TheCall)) {
        return SemaClangGlobals.ExprError();
      }
      break;
     case x86:
     case x86_64:
      if ($this().CheckX86BuiltinFunctionCall(BuiltinID, TheCall)) {
        return SemaClangGlobals.ExprError();
      }
      break;
     case ppc:
     case ppc64:
     case ppc64le:
      if ($this().CheckPPCBuiltinFunctionCall(BuiltinID, TheCall)) {
        return SemaClangGlobals.ExprError();
      }
      break;
     default:
      break;
    }
  }
  
  return TheCallResult;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckARMBuiltinExclusiveCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1250,
 FQN="clang::Sema::CheckARMBuiltinExclusiveCall", NM="_ZN5clang4Sema28CheckARMBuiltinExclusiveCallEjPNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema28CheckARMBuiltinExclusiveCallEjPNS_8CallExprEj")
//</editor-fold>
protected/*private*/ final boolean CheckARMBuiltinExclusiveCall(/*uint*/int BuiltinID, CallExpr /*P*/ TheCall, 
                            /*uint*/int MaxWidth) {
  assert ((BuiltinID == ARM.BI__builtin_arm_ldrex || BuiltinID == ARM.BI__builtin_arm_ldaex || BuiltinID == ARM.BI__builtin_arm_strex || BuiltinID == ARM.BI__builtin_arm_stlex || BuiltinID == AArch64.BI__builtin_arm_ldrex || BuiltinID == AArch64.BI__builtin_arm_ldaex || BuiltinID == AArch64.BI__builtin_arm_strex || BuiltinID == AArch64.BI__builtin_arm_stlex)) : "unexpected ARM builtin";
  boolean IsLdrex = BuiltinID == ARM.BI__builtin_arm_ldrex
     || BuiltinID == ARM.BI__builtin_arm_ldaex
     || BuiltinID == AArch64.BI__builtin_arm_ldrex
     || BuiltinID == AArch64.BI__builtin_arm_ldaex;
  
  DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(TheCall.getCallee().IgnoreParenCasts());
  
  // Ensure that we have the proper number of arguments.
  if (SemaCheckingStatics.checkArgCount(/*Deref*/$this(), TheCall, IsLdrex ? 1 : 2)) {
    return true;
  }
  
  // Inspect the pointer argument of the atomic builtin.  This should always be
  // a pointer type, whose element is an integral scalar or pointer type.
  // Because it is a pointer type, we don't have to worry about any implicit
  // casts here.
  Expr /*P*/ PointerArg = TheCall.getArg(IsLdrex ? 0 : 1);
  ActionResultTTrue<Expr /*P*/ > PointerArgRes = $this().DefaultFunctionArrayLvalueConversion(PointerArg);
  if (PointerArgRes.isInvalid()) {
    return true;
  }
  PointerArg = PointerArgRes.get();
  
  /*const*/ PointerType /*P*/ pointerType = PointerArg.getType().$arrow().getAs(PointerType.class);
  if (!(pointerType != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_builtin_must_be_pointer)), 
              PointerArg.getType()), PointerArg.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // ldrex takes a "const volatile T*" and strex takes a "volatile T*". Our next
  // task is to insert the appropriate casts into the AST. First work out just
  // what the appropriate type is.
  QualType ValType = pointerType.getPointeeType();
  QualType AddrType = ValType.getUnqualifiedType().withVolatile();
  if (IsLdrex) {
    AddrType.addConst();
  }
  
  // Issue a warning if the cast is dodgy.
  CastKind CastNeeded = CastKind.CK_NoOp;
  if (!AddrType.isAtLeastAsQualifiedAs(new QualType(ValType))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CastNeeded = CastKind.CK_BitCast;
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.ext_typecheck_convert_discards_qualifiers)), 
                      PointerArg.getType()), 
                  $this().Context.getPointerType(/*NO_COPY*/AddrType)), 
              AssignmentAction.AA_Passing), PointerArg.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Finally, do the cast and replace the argument with the corrected version.
  AddrType.$assignMove($this().Context.getPointerType(/*NO_COPY*/AddrType));
  PointerArgRes.$assignMove($this().ImpCastExprToType(PointerArg, new QualType(AddrType), CastNeeded));
  if (PointerArgRes.isInvalid()) {
    return true;
  }
  PointerArg = PointerArgRes.get();
  
  TheCall.setArg(IsLdrex ? 0 : 1, PointerArg);
  
  // In general, we allow ints, floats and pointers to be loaded and stored.
  if (!ValType.$arrow().isIntegerType() && !ValType.$arrow().isAnyPointerType()
     && !ValType.$arrow().isBlockPointerType() && !ValType.$arrow().isFloatingType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_builtin_must_be_pointer_intfltptr)), 
              PointerArg.getType()), PointerArg.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // But ARM doesn't have instructions to deal with 128-bit versions.
  if ($greater_ulong_uint($this().Context.getTypeSize(new QualType(ValType)), MaxWidth)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (MaxWidth == 64) : "Diagnostic unexpectedly inaccurate";
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_exclusive_builtin_pointer_size)), 
              PointerArg.getType()), PointerArg.getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  switch (ValType.getObjCLifetime()) {
   case OCL_None:
   case OCL_ExplicitNone:
    // okay
    break;
   case OCL_Weak:
   case OCL_Strong:
   case OCL_Autoreleasing:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_arc_atomic_ownership)), 
                ValType), PointerArg.getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (IsLdrex) {
    TheCall.setType(new QualType(ValType));
    return false;
  }
  
  // Initialize the argument to be stored.
  ActionResultTTrue<Expr /*P*/ > ValArg = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall.getArg(0));
  InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, new QualType(ValType), /*consume*/ false);
  ValArg.$assignMove($this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(ValArg)));
  if (ValArg.isInvalid()) {
    return true;
  }
  TheCall.setArg(0, ValArg.get());
  
  // __builtin_arm_strex always returns an int. It's marked as such in the .def,
  // but the custom checker bypasses all default analysis.
  TheCall.setType($this().Context.IntTy.$QualType());
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckNeonBuiltinFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1185,
 FQN="clang::Sema::CheckNeonBuiltinFunctionCall", NM="_ZN5clang4Sema28CheckNeonBuiltinFunctionCallEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema28CheckNeonBuiltinFunctionCallEjPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean CheckNeonBuiltinFunctionCall(/*uint*/int BuiltinID, CallExpr /*P*/ TheCall) {
  APSInt Result/*J*/= new APSInt();
  long/*uint64_t*/ mask = 0;
  /*uint*/int TV = 0;
  int PtrArgNum = -1;
  boolean HasConstPtr = false;
  switch (BuiltinID) {
   case NEON.BI__builtin_neon_vabd_v:
    mask = 0x70607L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vabdq_v:
    mask = 0x7060700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vabs_v:
    mask = 0x60FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vabsq_v:
    mask = 0x60F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vaddhn_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vaesdq_v:
    mask = 0x1000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vaeseq_v:
    mask = 0x1000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vaesimcq_v:
    mask = 0x1000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vaesmcq_v:
    mask = 0x1000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vbsl_v:
    mask = 0xF067FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vbslq_v:
    mask = 0xF067F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcage_v:
    mask = 0xC0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcageq_v:
    mask = 0xC000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcagt_v:
    mask = 0xC0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcagtq_v:
    mask = 0xC000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcale_v:
    mask = 0xC0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcaleq_v:
    mask = 0xC000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcalt_v:
    mask = 0xC0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcaltq_v:
    mask = 0xC000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vceqz_v:
    mask = 0xF0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vceqzq_v:
    mask = 0xF000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcgez_v:
    mask = 0xF0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcgezq_v:
    mask = 0xF000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcgtz_v:
    mask = 0xF0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcgtzq_v:
    mask = 0xF000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vclez_v:
    mask = 0xF0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vclezq_v:
    mask = 0xF000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcls_v:
    mask = 0x7L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vclsq_v:
    mask = 0x700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcltz_v:
    mask = 0xF0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcltzq_v:
    mask = 0xF000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vclz_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vclzq_v:
    mask = 0x7000700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcnt_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcntq_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_f16_f32:
    mask = 0x100L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_f32_f16:
    mask = 0x20000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_f32_f64:
    mask = 0x200L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_f32_v:
    mask = 0x40004L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_f64_f32:
    mask = 0x40000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_f64_v:
    mask = 0x80008L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_n_f32_v:
    mask = 0x40004L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_n_f64_v:
    mask = 0x80008L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_n_s32_v:
    mask = 0x4L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_n_s64_v:
    mask = 0x8L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_n_u32_v:
    mask = 0x40000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_n_u64_v:
    mask = 0x80000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_s32_v:
    mask = 0x4L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_s64_v:
    mask = 0x8L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_u32_v:
    mask = 0x40000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvt_u64_v:
    mask = 0x80000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvta_s32_v:
    mask = 0x4L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvta_s64_v:
    mask = 0x8L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvta_u32_v:
    mask = 0x40000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvta_u64_v:
    mask = 0x80000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtaq_s32_v:
    mask = 0x400000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtaq_s64_v:
    mask = 0x800000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtaq_u32_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtaq_u64_v:
    mask = 0x8000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtm_s32_v:
    mask = 0x4L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtm_s64_v:
    mask = 0x8L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtm_u32_v:
    mask = 0x40000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtm_u64_v:
    mask = 0x80000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtmq_s32_v:
    mask = 0x400000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtmq_s64_v:
    mask = 0x800000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtmq_u32_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtmq_u64_v:
    mask = 0x8000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtn_s32_v:
    mask = 0x4L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtn_s64_v:
    mask = 0x8L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtn_u32_v:
    mask = 0x40000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtn_u64_v:
    mask = 0x80000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtnq_s32_v:
    mask = 0x400000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtnq_s64_v:
    mask = 0x800000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtnq_u32_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtnq_u64_v:
    mask = 0x8000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtp_s32_v:
    mask = 0x4L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtp_s64_v:
    mask = 0x8L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtp_u32_v:
    mask = 0x40000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtp_u64_v:
    mask = 0x80000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtpq_s32_v:
    mask = 0x400000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtpq_s64_v:
    mask = 0x800000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtpq_u32_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtpq_u64_v:
    mask = 0x8000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_f32_v:
    mask = 0x4000400000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_f64_v:
    mask = 0x8000800000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_f32_v:
    mask = 0x4000400000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_f64_v:
    mask = 0x8000800000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_s32_v:
    mask = 0x400000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_s64_v:
    mask = 0x800000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_u32_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_u64_v:
    mask = 0x8000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_s32_v:
    mask = 0x400000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_s64_v:
    mask = 0x800000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_u32_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtq_u64_v:
    mask = 0x8000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vcvtx_f32_v:
    mask = 0x40000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vext_v:
    mask = 0xF067FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vextq_v:
    mask = 0xF067F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vfma_lane_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vfma_laneq_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vfma_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vfmaq_lane_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vfmaq_laneq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vfmaq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vhadd_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vhaddq_v:
    mask = 0x7000700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vhsub_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vhsubq_v:
    mask = 0x7000700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vld1_dup_v:
    mask = 0xF077FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vld1_lane_v:
    mask = 0xF077FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vld1_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld1_x2_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld1_x3_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld1_x4_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld1q_dup_v:
    mask = 0xF077F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vld1q_lane_v:
    mask = 0xF077F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vld1q_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld1q_x2_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld1q_x3_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld1q_x4_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld2_dup_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld2_lane_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld2_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld2q_dup_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld2q_lane_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld2q_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld3_dup_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld3_lane_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld3_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld3q_dup_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld3q_lane_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld3q_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld4_dup_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld4_lane_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld4_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld4q_dup_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld4q_lane_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vld4q_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 1;
    HasConstPtr = true;
    break;
   case NEON.BI__builtin_neon_vmax_v:
    mask = 0x70607L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmaxnm_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmaxnmq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmaxq_v:
    mask = 0x7060700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmin_v:
    mask = 0x70607L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vminnm_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vminnmq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vminq_v:
    mask = 0x7060700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmovl_v:
    mask = 0xE000E00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmovn_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmul_lane_v:
    mask = 0x400L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmul_laneq_v:
    mask = 0x400L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmul_v:
    mask = 0x10L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmull_v:
    mask = 0xE002E00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmulq_v:
    mask = 0x1000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmulx_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vmulxq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpadal_v:
    mask = 0xE000EL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpadalq_v:
    mask = 0xE000E00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpadd_v:
    mask = 0x70207L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpaddl_v:
    mask = 0xE000EL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpaddlq_v:
    mask = 0xE000E00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpaddq_v:
    mask = 0xF060F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpmax_v:
    mask = 0x70207L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpmaxnm_v:
    mask = 0x200L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpmaxnmq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpmaxq_v:
    mask = 0x7060700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpmin_v:
    mask = 0x70207L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpminnm_v:
    mask = 0x200L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpminnmq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vpminq_v:
    mask = 0x7060700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqabs_v:
    mask = 0xFL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqabsq_v:
    mask = 0xF00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqadd_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqaddq_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqdmlal_v:
    mask = 0xC00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqdmlsl_v:
    mask = 0xC00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqdmulh_v:
    mask = 0x6L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqdmulhq_v:
    mask = 0x600000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqdmull_v:
    mask = 0xC00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqmovn_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqmovun_v:
    mask = 0x70000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqneg_v:
    mask = 0xFL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqnegq_v:
    mask = 0xF00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqrdmulh_v:
    mask = 0x6L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqrdmulhq_v:
    mask = 0x600000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqrshl_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqrshlq_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqrshrn_n_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqrshrun_n_v:
    mask = 0x70000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqshl_n_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqshl_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqshlq_n_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqshlq_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqshlu_n_v:
    mask = 0xF0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqshluq_n_v:
    mask = 0xF000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqshrn_n_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqshrun_n_v:
    mask = 0x70000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqsub_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqsubq_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbl1_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbl1q_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbl2_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbl2q_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbl3_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbl3q_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbl4_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbl4q_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbx1_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbx1q_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbx2_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbx2q_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbx3_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbx3q_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbx4_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vqtbx4q_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vraddhn_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrbit_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrbitq_v:
    mask = 0x1001100000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrecpe_v:
    mask = 0x40600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrecpeq_v:
    mask = 0x4060000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrecps_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrecpsq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrhadd_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrhaddq_v:
    mask = 0x7000700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrnd_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrnda_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndaq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndi_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndiq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndm_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndmq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndn_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndnq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndp_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndpq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndx_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrndxq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrshl_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrshlq_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrshr_n_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrshrn_n_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrshrq_n_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrsqrte_v:
    mask = 0x40600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrsqrteq_v:
    mask = 0x4060000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrsqrts_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrsqrtsq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrsra_n_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrsraq_n_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vrsubhn_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsha1su0q_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsha1su1q_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsha256h2q_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsha256hq_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsha256su0q_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsha256su1q_v:
    mask = 0x4000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vshl_n_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vshl_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vshll_n_v:
    mask = 0xE000E00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vshlq_n_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vshlq_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vshr_n_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vshrn_n_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vshrq_n_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsli_n_v:
    mask = 0xF007FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsliq_n_v:
    mask = 0xF007F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsqadd_v:
    mask = 0xF0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsqaddq_v:
    mask = 0xF000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsqrt_v:
    mask = 0x600L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsqrtq_v:
    mask = 0x60000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsra_n_v:
    mask = 0xF000FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsraq_n_v:
    mask = 0xF000F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsri_n_v:
    mask = 0xF007FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vsriq_n_v:
    mask = 0xF007F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vst1_lane_v:
    mask = 0xF077FL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vst1_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst1_x2_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst1_x3_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst1_x4_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst1q_lane_v:
    mask = 0xF077F00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vst1q_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst1q_x2_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst1q_x3_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst1q_x4_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst2_lane_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst2_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst2q_lane_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst2q_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst3_lane_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst3_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst3q_lane_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst3q_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst4_lane_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst4_v:
    mask = 0xF077FL/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst4q_lane_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vst4q_v:
    mask = 0xF077F00000000L/*ULL*/;
    PtrArgNum = 0;
    break;
   case NEON.BI__builtin_neon_vsubhn_v:
    mask = 0x70007L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtbl1_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtbl2_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtbl3_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtbl4_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtbx1_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtbx2_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtbx3_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtbx4_v:
    mask = 0x10011L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtrn_v:
    mask = 0x70237L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtrnq_v:
    mask = 0x7023700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtst_v:
    mask = 0xF0000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vtstq_v:
    mask = 0xF000000000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vuqadd_v:
    mask = 0xFL/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vuqaddq_v:
    mask = 0xF00000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vuzp_v:
    mask = 0x70237L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vuzpq_v:
    mask = 0x7023700000000L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vzip_v:
    mask = 0x70237L/*ULL*/;
    break;
   case NEON.BI__builtin_neon_vzipq_v:
    mask = 0x7023700000000L/*ULL*/;
    break;
  }
  
  // For NEON intrinsics which are overloaded on vector element type, validate
  // the immediate which specifies which variant to emit.
  /*uint*/int ImmArg = TheCall.getNumArgs() - 1;
  if ((mask != 0)) {
    if ($this().SemaBuiltinConstantArg(TheCall, ImmArg, Result)) {
      return true;
    }
    
    TV = $ulong2uint(Result.getLimitedValue(64));
    if (($greater_uint(TV, 63)) || (mask & (1L/*ULL*/ << TV)) == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_invalid_neon_type_code)), 
            TheCall.getArg(ImmArg).getSourceRange()).$bool());
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (PtrArgNum >= 0) {
    // Check that pointer arguments have the specified type.
    Expr /*P*/ Arg = TheCall.getArg(PtrArgNum);
    {
      ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(Arg);
      if ((ICE != null)) {
        Arg = ICE.getSubExpr();
      }
    }
    ActionResultTTrue<Expr /*P*/ > RHS = $this().DefaultFunctionArrayLvalueConversion(Arg);
    QualType RHSTy = RHS.get().getType();
    
    Triple.ArchType Arch = $this().Context.getTargetInfo().getTriple().getArch();
    boolean IsPolyUnsigned = Arch == Triple.ArchType.aarch64;
    boolean IsInt64Long = $this().Context.getTargetInfo().getInt64Type() == TargetInfo.IntType.SignedLong;
    QualType EltTy = SemaCheckingStatics.getNeonEltType(new NeonTypeFlags(TV), $this().Context, IsPolyUnsigned, IsInt64Long);
    if (HasConstPtr) {
      EltTy.$assignMove(EltTy.withConst());
    }
    QualType LHSTy = $this().Context.getPointerType(/*NO_COPY*/EltTy);
    AssignConvertType ConvTy;
    ConvTy = $this().CheckSingleAssignmentConstraints(new QualType(LHSTy), RHS);
    if (RHS.isInvalid()) {
      return true;
    }
    if ($this().DiagnoseAssignmentResult(ConvTy, Arg.getLocStart(), new QualType(LHSTy), new QualType(RHSTy), 
        RHS.get(), AssignmentAction.AA_Assigning)) {
      return true;
    }
  }
  
  // For NEON intrinsics which take an immediate value as part of the
  // instruction, range check them here.
  /*uint*/int i = 0;
  /*uint*/int l = 0;
  /*uint*/int u = 0;
  switch (BuiltinID) {
   default:
    return false;
   case NEON.BI__builtin_neon_vcvtq_n_f64_v:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vcvt_n_f64_v:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_s64_v:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vcvt_n_s64_v:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_u64_v:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vcvt_n_u64_v:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vget_lane_i64:
    i = 1;
    u = 0;
    break;
   case NEON.BI__builtin_neon_vgetq_lane_i64:
    i = 1;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vgetq_lane_f64:
    i = 1;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vget_lane_f64:
    i = 1;
    u = 0;
    break;
   case NEON.BI__builtin_neon_vld1_lane_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vld1q_lane_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vld2_lane_v:
    i = 4;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vld2q_lane_v:
    i = 4;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vld3_lane_v:
    i = 5;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vld3q_lane_v:
    i = 5;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vld4_lane_v:
    i = 6;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vld4q_lane_v:
    i = 6;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vcvts_n_s32_f32:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvtd_n_s64_f64:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vcvts_n_u32_f32:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvtd_n_u64_f64:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vfmad_lane_f64:
    i = 3;
    u = 0;
    break;
   case NEON.BI__builtin_neon_vfmas_lane_f32:
    i = 3;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vfmad_laneq_f64:
    i = 3;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vfmas_laneq_f32:
    i = 3;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vcvts_n_f32_u32:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvts_n_f32_s32:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvtd_n_f64_u64:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vcvtd_n_f64_s64:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vshld_n_u64:
    i = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vshld_n_s64:
    i = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vslid_n_u64:
    i = 2;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vslid_n_s64:
    i = 2;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vqdmlals_lane_s32:
    i = 3;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vqdmlalh_lane_s16:
    i = 3;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vqdmlals_laneq_s32:
    i = 3;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vqdmlalh_laneq_s16:
    i = 3;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqdmlsls_lane_s32:
    i = 3;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vqdmlslh_lane_s16:
    i = 3;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vqdmlsls_laneq_s32:
    i = 3;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vqdmlslh_laneq_s16:
    i = 3;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqrshrns_n_u32:
    i = 1;
    l = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqrshrnd_n_u64:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqrshrnh_n_u16:
    i = 1;
    l = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqrshrns_n_s32:
    i = 1;
    l = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqrshrnd_n_s64:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqrshrnh_n_s16:
    i = 1;
    l = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqrshruns_n_s32:
    i = 1;
    l = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqrshrund_n_s64:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqrshrunh_n_s16:
    i = 1;
    l = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqshlub_n_s8:
    i = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqshlus_n_s32:
    i = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqshlud_n_s64:
    i = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vqshluh_n_s16:
    i = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqshlb_n_u8:
    i = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqshls_n_u32:
    i = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqshld_n_u64:
    i = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vqshlh_n_u16:
    i = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqshlb_n_s8:
    i = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqshls_n_s32:
    i = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqshld_n_s64:
    i = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vqshlh_n_s16:
    i = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqshrns_n_u32:
    i = 1;
    l = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqshrnd_n_u64:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqshrnh_n_u16:
    i = 1;
    l = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqshrns_n_s32:
    i = 1;
    l = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqshrnd_n_s64:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqshrnh_n_s16:
    i = 1;
    l = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vqshruns_n_s32:
    i = 1;
    l = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vqshrund_n_s64:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vqshrunh_n_s16:
    i = 1;
    l = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vsrid_n_u64:
    i = 2;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vsrid_n_s64:
    i = 2;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vrshrd_n_u64:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vrshrd_n_s64:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vrsrad_n_u64:
    i = 2;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vrsrad_n_s64:
    i = 2;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vshrd_n_u64:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vshrd_n_s64:
    i = 1;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vsrad_n_u64:
    i = 2;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vsrad_n_s64:
    i = 2;
    l = 1;
    u = 63;
    break;
   case NEON.BI__builtin_neon_vdupb_lane_i8:
    i = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vduph_lane_i16:
    i = 1;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vdups_lane_i32:
    i = 1;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vdupd_lane_i64:
    i = 1;
    u = 0;
    break;
   case NEON.BI__builtin_neon_vdupd_lane_f64:
    i = 1;
    u = 0;
    break;
   case NEON.BI__builtin_neon_vdups_lane_f32:
    i = 1;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vdupb_laneq_i8:
    i = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vduph_laneq_i16:
    i = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vdups_laneq_i32:
    i = 1;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vdupd_laneq_i64:
    i = 1;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vdupd_laneq_f64:
    i = 1;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vdups_laneq_f32:
    i = 1;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vmul_lane_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vmul_laneq_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, false, true);
    break;
   case NEON.BI__builtin_neon_vset_lane_i64:
    i = 2;
    u = 0;
    break;
   case NEON.BI__builtin_neon_vsetq_lane_i64:
    i = 2;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vsetq_lane_f64:
    i = 2;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vset_lane_f64:
    i = 2;
    u = 0;
    break;
   case NEON.BI__builtin_neon_vsli_n_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vsliq_n_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vsri_n_v:
    i = 2;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vsriq_n_v:
    i = 2;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vst1_lane_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vst1q_lane_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vst2_lane_v:
    i = 3;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vst2q_lane_v:
    i = 3;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vst3_lane_v:
    i = 4;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vst3q_lane_v:
    i = 4;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vst4_lane_v:
    i = 5;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vst4q_lane_v:
    i = 5;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vcvtq_n_f32_v:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvt_n_f32_v:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_s32_v:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvt_n_s32_v:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvtq_n_u32_v:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vcvt_n_u32_v:
    i = 1;
    l = 1;
    u = 31;
    break;
   case NEON.BI__builtin_neon_vext_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vextq_v:
    i = 2;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vfmaq_lane_v:
    i = 3;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vfma_lane_v:
    i = 3;
    u = SemaCheckingStatics.RFT(TV, false, false);
    break;
   case NEON.BI__builtin_neon_vfmaq_laneq_v:
    i = 3;
    u = SemaCheckingStatics.RFT(TV, false, true);
    break;
   case NEON.BI__builtin_neon_vfma_laneq_v:
    i = 3;
    u = SemaCheckingStatics.RFT(TV, false, true);
    break;
   case NEON.BI__builtin_neon_vget_lane_i8:
    i = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vget_lane_i16:
    i = 1;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vgetq_lane_i8:
    i = 1;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vgetq_lane_i16:
    i = 1;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vgetq_lane_i32:
    i = 1;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vgetq_lane_f32:
    i = 1;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vget_lane_i32:
    i = 1;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vget_lane_f32:
    i = 1;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vqrshrn_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vqrshrun_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vqshluq_n_v:
    i = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vqshlu_n_v:
    i = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vqshlq_n_v:
    i = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vqshl_n_v:
    i = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vqshrn_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vqshrun_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vrshrn_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vrshrq_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vrshr_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vrsraq_n_v:
    i = 2;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vrsra_n_v:
    i = 2;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vset_lane_i8:
    i = 2;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vset_lane_i16:
    i = 2;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vsetq_lane_i8:
    i = 2;
    u = 15;
    break;
   case NEON.BI__builtin_neon_vsetq_lane_i16:
    i = 2;
    u = 7;
    break;
   case NEON.BI__builtin_neon_vsetq_lane_i32:
    i = 2;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vsetq_lane_f32:
    i = 2;
    u = 3;
    break;
   case NEON.BI__builtin_neon_vset_lane_i32:
    i = 2;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vset_lane_f32:
    i = 2;
    u = 1;
    break;
   case NEON.BI__builtin_neon_vshll_n_v:
    i = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vshlq_n_v:
    i = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vshl_n_v:
    i = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vshrn_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vshrq_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vshr_n_v:
    i = 1;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vsraq_n_v:
    i = 2;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
   case NEON.BI__builtin_neon_vsra_n_v:
    i = 2;
    l = 1;
    u = SemaCheckingStatics.RFT(TV, true);
    break;
  }
  
  return $this().SemaBuiltinConstantArgRange(TheCall, i, l, u + l);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckARMBuiltinFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1366,
 FQN="clang::Sema::CheckARMBuiltinFunctionCall", NM="_ZN5clang4Sema27CheckARMBuiltinFunctionCallEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema27CheckARMBuiltinFunctionCallEjPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean CheckARMBuiltinFunctionCall(/*uint*/int BuiltinID, CallExpr /*P*/ TheCall) {
  APSInt Result/*J*/= new APSInt();
  if (BuiltinID == ARM.BI__builtin_arm_ldrex
     || BuiltinID == ARM.BI__builtin_arm_ldaex
     || BuiltinID == ARM.BI__builtin_arm_strex
     || BuiltinID == ARM.BI__builtin_arm_stlex) {
    return $this().CheckARMBuiltinExclusiveCall(BuiltinID, TheCall, 64);
  }
  if (BuiltinID == ARM.BI__builtin_arm_prefetch) {
    return $this().SemaBuiltinConstantArgRange(TheCall, 1, 0, 1)
       || $this().SemaBuiltinConstantArgRange(TheCall, 2, 0, 1);
  }
  if (BuiltinID == ARM.BI__builtin_arm_rsr64
     || BuiltinID == ARM.BI__builtin_arm_wsr64) {
    return $this().SemaBuiltinARMSpecialReg(BuiltinID, TheCall, 0, 3, false);
  }
  if (BuiltinID == ARM.BI__builtin_arm_rsr
     || BuiltinID == ARM.BI__builtin_arm_rsrp
     || BuiltinID == ARM.BI__builtin_arm_wsr
     || BuiltinID == ARM.BI__builtin_arm_wsrp) {
    return $this().SemaBuiltinARMSpecialReg(BuiltinID, TheCall, 0, 5, true);
  }
  if ($this().CheckNeonBuiltinFunctionCall(BuiltinID, TheCall)) {
    return true;
  }
  
  // For intrinsics which take an immediate value as part of the instruction,
  // range check them here.
  /*uint*/int i = 0;
  /*uint*/int l = 0;
  /*uint*/int u = 0;
  switch (BuiltinID) {
   default:
    return false;
   case ARM.BI__builtin_arm_ssat:
    i = 1;
    l = 1;
    u = 31;
    break;
   case ARM.BI__builtin_arm_usat:
    i = 1;
    u = 31;
    break;
   case ARM.BI__builtin_arm_vcvtr_f:
   case ARM.BI__builtin_arm_vcvtr_d:
    i = 1;
    u = 1;
    break;
   case ARM.BI__builtin_arm_dmb:
   case ARM.BI__builtin_arm_dsb:
   case ARM.BI__builtin_arm_isb:
   case ARM.BI__builtin_arm_dbg:
    l = 0;
    u = 15;
    break;
  }
  
  // FIXME: VFP Intrinsics should error if VFP not present.
  return $this().SemaBuiltinConstantArgRange(TheCall, i, l, u + l);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAArch64BuiltinFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1413,
 FQN="clang::Sema::CheckAArch64BuiltinFunctionCall", NM="_ZN5clang4Sema31CheckAArch64BuiltinFunctionCallEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema31CheckAArch64BuiltinFunctionCallEjPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean CheckAArch64BuiltinFunctionCall(/*uint*/int BuiltinID, 
                               CallExpr /*P*/ TheCall) {
  APSInt Result/*J*/= new APSInt();
  if (BuiltinID == AArch64.BI__builtin_arm_ldrex
     || BuiltinID == AArch64.BI__builtin_arm_ldaex
     || BuiltinID == AArch64.BI__builtin_arm_strex
     || BuiltinID == AArch64.BI__builtin_arm_stlex) {
    return $this().CheckARMBuiltinExclusiveCall(BuiltinID, TheCall, 128);
  }
  if (BuiltinID == AArch64.BI__builtin_arm_prefetch) {
    return $this().SemaBuiltinConstantArgRange(TheCall, 1, 0, 1)
       || $this().SemaBuiltinConstantArgRange(TheCall, 2, 0, 2)
       || $this().SemaBuiltinConstantArgRange(TheCall, 3, 0, 1)
       || $this().SemaBuiltinConstantArgRange(TheCall, 4, 0, 1);
  }
  if (BuiltinID == AArch64.BI__builtin_arm_rsr64
     || BuiltinID == AArch64.BI__builtin_arm_wsr64) {
    return $this().SemaBuiltinARMSpecialReg(BuiltinID, TheCall, 0, 5, true);
  }
  if (BuiltinID == AArch64.BI__builtin_arm_rsr
     || BuiltinID == AArch64.BI__builtin_arm_rsrp
     || BuiltinID == AArch64.BI__builtin_arm_wsr
     || BuiltinID == AArch64.BI__builtin_arm_wsrp) {
    return $this().SemaBuiltinARMSpecialReg(BuiltinID, TheCall, 0, 5, true);
  }
  if ($this().CheckNeonBuiltinFunctionCall(BuiltinID, TheCall)) {
    return true;
  }
  
  // For intrinsics which take an immediate value as part of the instruction,
  // range check them here.
  /*uint*/int i = 0;
  /*uint*/int l = 0;
  /*uint*/int u = 0;
  switch (BuiltinID) {
   default:
    return false;
   case AArch64.BI__builtin_arm_dmb:
   case AArch64.BI__builtin_arm_dsb:
   case AArch64.BI__builtin_arm_isb:
    l = 0;
    u = 15;
    break;
  }
  
  return $this().SemaBuiltinConstantArgRange(TheCall, i, l, u + l);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMipsBuiltinFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1457,
 FQN="clang::Sema::CheckMipsBuiltinFunctionCall", NM="_ZN5clang4Sema28CheckMipsBuiltinFunctionCallEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema28CheckMipsBuiltinFunctionCallEjPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean CheckMipsBuiltinFunctionCall(/*uint*/int BuiltinID, CallExpr /*P*/ TheCall) {
  /*uint*/int i = 0;
  /*uint*/int l = 0;
  /*uint*/int u = 0;
  switch (BuiltinID) {
   default:
    return false;
   case Mips.BI__builtin_mips_wrdsp:
    i = 1;
    l = 0;
    u = 63;
    break;
   case Mips.BI__builtin_mips_rddsp:
    i = 0;
    l = 0;
    u = 63;
    break;
   case Mips.BI__builtin_mips_append:
    i = 2;
    l = 0;
    u = 31;
    break;
   case Mips.BI__builtin_mips_balign:
    i = 2;
    l = 0;
    u = 3;
    break;
   case Mips.BI__builtin_mips_precr_sra_ph_w:
    i = 2;
    l = 0;
    u = 31;
    break;
   case Mips.BI__builtin_mips_precr_sra_r_ph_w:
    i = 2;
    l = 0;
    u = 31;
    break;
   case Mips.BI__builtin_mips_prepend:
    i = 2;
    l = 0;
    u = 31;
    break;
  }
  
  return $this().SemaBuiltinConstantArgRange(TheCall, i, l, u);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSystemZBuiltinFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1516,
 FQN="clang::Sema::CheckSystemZBuiltinFunctionCall", NM="_ZN5clang4Sema31CheckSystemZBuiltinFunctionCallEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema31CheckSystemZBuiltinFunctionCallEjPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean CheckSystemZBuiltinFunctionCall(/*uint*/int BuiltinID, 
                               CallExpr /*P*/ TheCall) {
  if (BuiltinID == SystemZ.BI__builtin_tabort) {
    Expr /*P*/ Arg = TheCall.getArg(0);
    APSInt AbortCode/*J*/= new APSInt(32);
    if (Arg.isIntegerConstantExpr(AbortCode, $this().Context)
       && AbortCode.getSExtValue() >= 0 && AbortCode.getSExtValue() < 256) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(Arg.getLocStart(), diag.err_systemz_invalid_tabort_code)), 
            Arg.getSourceRange()).$bool());
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // For intrinsics which take an immediate value as part of the instruction,
  // range check them here.
  /*uint*/int i = 0;
  /*uint*/int l = 0;
  /*uint*/int u = 0;
  switch (BuiltinID) {
   default:
    return false;
   case SystemZ.BI__builtin_s390_lcbb:
    i = 1;
    l = 0;
    u = 15;
    break;
   case SystemZ.BI__builtin_s390_verimb:
   case SystemZ.BI__builtin_s390_verimh:
   case SystemZ.BI__builtin_s390_verimf:
   case SystemZ.BI__builtin_s390_verimg:
    i = 3;
    l = 0;
    u = 255;
    break;
   case SystemZ.BI__builtin_s390_vfaeb:
   case SystemZ.BI__builtin_s390_vfaeh:
   case SystemZ.BI__builtin_s390_vfaef:
   case SystemZ.BI__builtin_s390_vfaebs:
   case SystemZ.BI__builtin_s390_vfaehs:
   case SystemZ.BI__builtin_s390_vfaefs:
   case SystemZ.BI__builtin_s390_vfaezb:
   case SystemZ.BI__builtin_s390_vfaezh:
   case SystemZ.BI__builtin_s390_vfaezf:
   case SystemZ.BI__builtin_s390_vfaezbs:
   case SystemZ.BI__builtin_s390_vfaezhs:
   case SystemZ.BI__builtin_s390_vfaezfs:
    i = 2;
    l = 0;
    u = 15;
    break;
   case SystemZ.BI__builtin_s390_vfidb:
    return $this().SemaBuiltinConstantArgRange(TheCall, 1, 0, 15)
       || $this().SemaBuiltinConstantArgRange(TheCall, 2, 0, 15);
   case SystemZ.BI__builtin_s390_vftcidb:
    i = 1;
    l = 0;
    u = 4095;
    break;
   case SystemZ.BI__builtin_s390_vlbb:
    i = 1;
    l = 0;
    u = 15;
    break;
   case SystemZ.BI__builtin_s390_vpdi:
    i = 2;
    l = 0;
    u = 15;
    break;
   case SystemZ.BI__builtin_s390_vsldb:
    i = 2;
    l = 0;
    u = 15;
    break;
   case SystemZ.BI__builtin_s390_vstrcb:
   case SystemZ.BI__builtin_s390_vstrch:
   case SystemZ.BI__builtin_s390_vstrcf:
   case SystemZ.BI__builtin_s390_vstrczb:
   case SystemZ.BI__builtin_s390_vstrczh:
   case SystemZ.BI__builtin_s390_vstrczf:
   case SystemZ.BI__builtin_s390_vstrcbs:
   case SystemZ.BI__builtin_s390_vstrchs:
   case SystemZ.BI__builtin_s390_vstrcfs:
   case SystemZ.BI__builtin_s390_vstrczbs:
   case SystemZ.BI__builtin_s390_vstrczhs:
   case SystemZ.BI__builtin_s390_vstrczfs:
    i = 3;
    l = 0;
    u = 15;
    break;
  }
  return $this().SemaBuiltinConstantArgRange(TheCall, i, l, u);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckX86BuiltinFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1592,
 FQN="clang::Sema::CheckX86BuiltinFunctionCall", NM="_ZN5clang4Sema27CheckX86BuiltinFunctionCallEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema27CheckX86BuiltinFunctionCallEjPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean CheckX86BuiltinFunctionCall(/*uint*/int BuiltinID, CallExpr /*P*/ TheCall) {
  int i = 0;
  int l = 0;
  int u = 0;
  switch (BuiltinID) {
   default:
    return false;
   case X86.BI__builtin_cpu_supports:
    return SemaCheckingStatics.SemaBuiltinCpuSupports(/*Deref*/$this(), TheCall);
   case X86.BI__builtin_ms_va_start:
    return $this().SemaBuiltinMSVAStart(TheCall);
   case X86.BI__builtin_ia32_extractf64x4_mask:
   case X86.BI__builtin_ia32_extracti64x4_mask:
   case X86.BI__builtin_ia32_extractf32x8_mask:
   case X86.BI__builtin_ia32_extracti32x8_mask:
   case X86.BI__builtin_ia32_extractf64x2_256_mask:
   case X86.BI__builtin_ia32_extracti64x2_256_mask:
   case X86.BI__builtin_ia32_extractf32x4_256_mask:
   case X86.BI__builtin_ia32_extracti32x4_256_mask:
    i = 1;
    l = 0;
    u = 1;
    break;
   case X86.BI_mm_prefetch:
   case X86.BI__builtin_ia32_extractf32x4_mask:
   case X86.BI__builtin_ia32_extracti32x4_mask:
   case X86.BI__builtin_ia32_extractf64x2_512_mask:
   case X86.BI__builtin_ia32_extracti64x2_512_mask:
    i = 1;
    l = 0;
    u = 3;
    break;
   case X86.BI__builtin_ia32_insertf32x8_mask:
   case X86.BI__builtin_ia32_inserti32x8_mask:
   case X86.BI__builtin_ia32_insertf64x4_mask:
   case X86.BI__builtin_ia32_inserti64x4_mask:
   case X86.BI__builtin_ia32_insertf64x2_256_mask:
   case X86.BI__builtin_ia32_inserti64x2_256_mask:
   case X86.BI__builtin_ia32_insertf32x4_256_mask:
   case X86.BI__builtin_ia32_inserti32x4_256_mask:
    i = 2;
    l = 0;
    u = 1;
    break;
   case X86.BI__builtin_ia32_sha1rnds4:
   case X86.BI__builtin_ia32_shuf_f32x4_256_mask:
   case X86.BI__builtin_ia32_shuf_f64x2_256_mask:
   case X86.BI__builtin_ia32_shuf_i32x4_256_mask:
   case X86.BI__builtin_ia32_shuf_i64x2_256_mask:
   case X86.BI__builtin_ia32_insertf64x2_512_mask:
   case X86.BI__builtin_ia32_inserti64x2_512_mask:
   case X86.BI__builtin_ia32_insertf32x4_mask:
   case X86.BI__builtin_ia32_inserti32x4_mask:
    i = 2;
    l = 0;
    u = 3;
    break;
   case X86.BI__builtin_ia32_vpermil2pd:
   case X86.BI__builtin_ia32_vpermil2pd256:
   case X86.BI__builtin_ia32_vpermil2ps:
   case X86.BI__builtin_ia32_vpermil2ps256:
    i = 3;
    l = 0;
    u = 3;
    break;
   case X86.BI__builtin_ia32_cmpb128_mask:
   case X86.BI__builtin_ia32_cmpw128_mask:
   case X86.BI__builtin_ia32_cmpd128_mask:
   case X86.BI__builtin_ia32_cmpq128_mask:
   case X86.BI__builtin_ia32_cmpb256_mask:
   case X86.BI__builtin_ia32_cmpw256_mask:
   case X86.BI__builtin_ia32_cmpd256_mask:
   case X86.BI__builtin_ia32_cmpq256_mask:
   case X86.BI__builtin_ia32_cmpb512_mask:
   case X86.BI__builtin_ia32_cmpw512_mask:
   case X86.BI__builtin_ia32_cmpd512_mask:
   case X86.BI__builtin_ia32_cmpq512_mask:
   case X86.BI__builtin_ia32_ucmpb128_mask:
   case X86.BI__builtin_ia32_ucmpw128_mask:
   case X86.BI__builtin_ia32_ucmpd128_mask:
   case X86.BI__builtin_ia32_ucmpq128_mask:
   case X86.BI__builtin_ia32_ucmpb256_mask:
   case X86.BI__builtin_ia32_ucmpw256_mask:
   case X86.BI__builtin_ia32_ucmpd256_mask:
   case X86.BI__builtin_ia32_ucmpq256_mask:
   case X86.BI__builtin_ia32_ucmpb512_mask:
   case X86.BI__builtin_ia32_ucmpw512_mask:
   case X86.BI__builtin_ia32_ucmpd512_mask:
   case X86.BI__builtin_ia32_ucmpq512_mask:
   case X86.BI__builtin_ia32_vpcomub:
   case X86.BI__builtin_ia32_vpcomuw:
   case X86.BI__builtin_ia32_vpcomud:
   case X86.BI__builtin_ia32_vpcomuq:
   case X86.BI__builtin_ia32_vpcomb:
   case X86.BI__builtin_ia32_vpcomw:
   case X86.BI__builtin_ia32_vpcomd:
   case X86.BI__builtin_ia32_vpcomq:
    i = 2;
    l = 0;
    u = 7;
    break;
   case X86.BI__builtin_ia32_roundps:
   case X86.BI__builtin_ia32_roundpd:
   case X86.BI__builtin_ia32_roundps256:
   case X86.BI__builtin_ia32_roundpd256:
    i = 1;
    l = 0;
    u = 15;
    break;
   case X86.BI__builtin_ia32_roundss:
   case X86.BI__builtin_ia32_roundsd:
   case X86.BI__builtin_ia32_rangepd128_mask:
   case X86.BI__builtin_ia32_rangepd256_mask:
   case X86.BI__builtin_ia32_rangepd512_mask:
   case X86.BI__builtin_ia32_rangeps128_mask:
   case X86.BI__builtin_ia32_rangeps256_mask:
   case X86.BI__builtin_ia32_rangeps512_mask:
   case X86.BI__builtin_ia32_getmantsd_round_mask:
   case X86.BI__builtin_ia32_getmantss_round_mask:
    i = 2;
    l = 0;
    u = 15;
    break;
   case X86.BI__builtin_ia32_cmpps:
   case X86.BI__builtin_ia32_cmpss:
   case X86.BI__builtin_ia32_cmppd:
   case X86.BI__builtin_ia32_cmpsd:
   case X86.BI__builtin_ia32_cmpps256:
   case X86.BI__builtin_ia32_cmppd256:
   case X86.BI__builtin_ia32_cmpps128_mask:
   case X86.BI__builtin_ia32_cmppd128_mask:
   case X86.BI__builtin_ia32_cmpps256_mask:
   case X86.BI__builtin_ia32_cmppd256_mask:
   case X86.BI__builtin_ia32_cmpps512_mask:
   case X86.BI__builtin_ia32_cmppd512_mask:
   case X86.BI__builtin_ia32_cmpsd_mask:
   case X86.BI__builtin_ia32_cmpss_mask:
    i = 2;
    l = 0;
    u = 31;
    break;
   case X86.BI__builtin_ia32_xabort:
    i = 0;
    l = -128;
    u = 255;
    break;
   case X86.BI__builtin_ia32_pshufw:
   case X86.BI__builtin_ia32_aeskeygenassist128:
    i = 1;
    l = -128;
    u = 255;
    break;
   case X86.BI__builtin_ia32_vcvtps2ph:
   case X86.BI__builtin_ia32_vcvtps2ph256:
   case X86.BI__builtin_ia32_rndscaleps_128_mask:
   case X86.BI__builtin_ia32_rndscalepd_128_mask:
   case X86.BI__builtin_ia32_rndscaleps_256_mask:
   case X86.BI__builtin_ia32_rndscalepd_256_mask:
   case X86.BI__builtin_ia32_rndscaleps_mask:
   case X86.BI__builtin_ia32_rndscalepd_mask:
   case X86.BI__builtin_ia32_reducepd128_mask:
   case X86.BI__builtin_ia32_reducepd256_mask:
   case X86.BI__builtin_ia32_reducepd512_mask:
   case X86.BI__builtin_ia32_reduceps128_mask:
   case X86.BI__builtin_ia32_reduceps256_mask:
   case X86.BI__builtin_ia32_reduceps512_mask:
   case X86.BI__builtin_ia32_prold512_mask:
   case X86.BI__builtin_ia32_prolq512_mask:
   case X86.BI__builtin_ia32_prold128_mask:
   case X86.BI__builtin_ia32_prold256_mask:
   case X86.BI__builtin_ia32_prolq128_mask:
   case X86.BI__builtin_ia32_prolq256_mask:
   case X86.BI__builtin_ia32_prord128_mask:
   case X86.BI__builtin_ia32_prord256_mask:
   case X86.BI__builtin_ia32_prorq128_mask:
   case X86.BI__builtin_ia32_prorq256_mask:
   case X86.BI__builtin_ia32_psllwi512_mask:
   case X86.BI__builtin_ia32_psllwi128_mask:
   case X86.BI__builtin_ia32_psllwi256_mask:
   case X86.BI__builtin_ia32_psrldi128_mask:
   case X86.BI__builtin_ia32_psrldi256_mask:
   case X86.BI__builtin_ia32_psrldi512_mask:
   case X86.BI__builtin_ia32_psrlqi128_mask:
   case X86.BI__builtin_ia32_psrlqi256_mask:
   case X86.BI__builtin_ia32_psrlqi512_mask:
   case X86.BI__builtin_ia32_psrawi512_mask:
   case X86.BI__builtin_ia32_psrawi128_mask:
   case X86.BI__builtin_ia32_psrawi256_mask:
   case X86.BI__builtin_ia32_psrlwi512_mask:
   case X86.BI__builtin_ia32_psrlwi128_mask:
   case X86.BI__builtin_ia32_psrlwi256_mask:
   case X86.BI__builtin_ia32_psradi128_mask:
   case X86.BI__builtin_ia32_psradi256_mask:
   case X86.BI__builtin_ia32_psradi512_mask:
   case X86.BI__builtin_ia32_psraqi128_mask:
   case X86.BI__builtin_ia32_psraqi256_mask:
   case X86.BI__builtin_ia32_psraqi512_mask:
   case X86.BI__builtin_ia32_pslldi128_mask:
   case X86.BI__builtin_ia32_pslldi256_mask:
   case X86.BI__builtin_ia32_pslldi512_mask:
   case X86.BI__builtin_ia32_psllqi128_mask:
   case X86.BI__builtin_ia32_psllqi256_mask:
   case X86.BI__builtin_ia32_psllqi512_mask:
   case X86.BI__builtin_ia32_fpclasspd128_mask:
   case X86.BI__builtin_ia32_fpclasspd256_mask:
   case X86.BI__builtin_ia32_fpclassps128_mask:
   case X86.BI__builtin_ia32_fpclassps256_mask:
   case X86.BI__builtin_ia32_fpclassps512_mask:
   case X86.BI__builtin_ia32_fpclasspd512_mask:
   case X86.BI__builtin_ia32_fpclasssd_mask:
   case X86.BI__builtin_ia32_fpclassss_mask:
    i = 1;
    l = 0;
    u = 255;
    break;
   case X86.BI__builtin_ia32_palignr:
   case X86.BI__builtin_ia32_insertps128:
   case X86.BI__builtin_ia32_dpps:
   case X86.BI__builtin_ia32_dppd:
   case X86.BI__builtin_ia32_dpps256:
   case X86.BI__builtin_ia32_mpsadbw128:
   case X86.BI__builtin_ia32_mpsadbw256:
   case X86.BI__builtin_ia32_pcmpistrm128:
   case X86.BI__builtin_ia32_pcmpistri128:
   case X86.BI__builtin_ia32_pcmpistria128:
   case X86.BI__builtin_ia32_pcmpistric128:
   case X86.BI__builtin_ia32_pcmpistrio128:
   case X86.BI__builtin_ia32_pcmpistris128:
   case X86.BI__builtin_ia32_pcmpistriz128:
   case X86.BI__builtin_ia32_pclmulqdq128:
   case X86.BI__builtin_ia32_vperm2f128_pd256:
   case X86.BI__builtin_ia32_vperm2f128_ps256:
   case X86.BI__builtin_ia32_vperm2f128_si256:
   case X86.BI__builtin_ia32_permti256:
    i = 2;
    l = -128;
    u = 255;
    break;
   case X86.BI__builtin_ia32_palignr128:
   case X86.BI__builtin_ia32_palignr256:
   case X86.BI__builtin_ia32_palignr128_mask:
   case X86.BI__builtin_ia32_palignr256_mask:
   case X86.BI__builtin_ia32_palignr512_mask:
   case X86.BI__builtin_ia32_alignq512_mask:
   case X86.BI__builtin_ia32_alignd512_mask:
   case X86.BI__builtin_ia32_alignd128_mask:
   case X86.BI__builtin_ia32_alignd256_mask:
   case X86.BI__builtin_ia32_alignq128_mask:
   case X86.BI__builtin_ia32_alignq256_mask:
   case X86.BI__builtin_ia32_vcomisd:
   case X86.BI__builtin_ia32_vcomiss:
   case X86.BI__builtin_ia32_shuf_f32x4_mask:
   case X86.BI__builtin_ia32_shuf_f64x2_mask:
   case X86.BI__builtin_ia32_shuf_i32x4_mask:
   case X86.BI__builtin_ia32_shuf_i64x2_mask:
   case X86.BI__builtin_ia32_dbpsadbw128_mask:
   case X86.BI__builtin_ia32_dbpsadbw256_mask:
   case X86.BI__builtin_ia32_dbpsadbw512_mask:
    i = 2;
    l = 0;
    u = 255;
    break;
   case X86.BI__builtin_ia32_fixupimmpd512_mask:
   case X86.BI__builtin_ia32_fixupimmpd512_maskz:
   case X86.BI__builtin_ia32_fixupimmps512_mask:
   case X86.BI__builtin_ia32_fixupimmps512_maskz:
   case X86.BI__builtin_ia32_fixupimmsd_mask:
   case X86.BI__builtin_ia32_fixupimmsd_maskz:
   case X86.BI__builtin_ia32_fixupimmss_mask:
   case X86.BI__builtin_ia32_fixupimmss_maskz:
   case X86.BI__builtin_ia32_fixupimmpd128_mask:
   case X86.BI__builtin_ia32_fixupimmpd128_maskz:
   case X86.BI__builtin_ia32_fixupimmpd256_mask:
   case X86.BI__builtin_ia32_fixupimmpd256_maskz:
   case X86.BI__builtin_ia32_fixupimmps128_mask:
   case X86.BI__builtin_ia32_fixupimmps128_maskz:
   case X86.BI__builtin_ia32_fixupimmps256_mask:
   case X86.BI__builtin_ia32_fixupimmps256_maskz:
   case X86.BI__builtin_ia32_pternlogd512_mask:
   case X86.BI__builtin_ia32_pternlogd512_maskz:
   case X86.BI__builtin_ia32_pternlogq512_mask:
   case X86.BI__builtin_ia32_pternlogq512_maskz:
   case X86.BI__builtin_ia32_pternlogd128_mask:
   case X86.BI__builtin_ia32_pternlogd128_maskz:
   case X86.BI__builtin_ia32_pternlogd256_mask:
   case X86.BI__builtin_ia32_pternlogd256_maskz:
   case X86.BI__builtin_ia32_pternlogq128_mask:
   case X86.BI__builtin_ia32_pternlogq128_maskz:
   case X86.BI__builtin_ia32_pternlogq256_mask:
   case X86.BI__builtin_ia32_pternlogq256_maskz:
    i = 3;
    l = 0;
    u = 255;
    break;
   case X86.BI__builtin_ia32_pcmpestrm128:
   case X86.BI__builtin_ia32_pcmpestri128:
   case X86.BI__builtin_ia32_pcmpestria128:
   case X86.BI__builtin_ia32_pcmpestric128:
   case X86.BI__builtin_ia32_pcmpestrio128:
   case X86.BI__builtin_ia32_pcmpestris128:
   case X86.BI__builtin_ia32_pcmpestriz128:
    i = 4;
    l = -128;
    u = 255;
    break;
   case X86.BI__builtin_ia32_rndscalesd_round_mask:
   case X86.BI__builtin_ia32_rndscaless_round_mask:
    i = 4;
    l = 0;
    u = 255;
    break;
  }
  return $this().SemaBuiltinConstantArgRange(TheCall, i, l, u);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPPCBuiltinFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1473,
 FQN="clang::Sema::CheckPPCBuiltinFunctionCall", NM="_ZN5clang4Sema27CheckPPCBuiltinFunctionCallEjPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema27CheckPPCBuiltinFunctionCallEjPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean CheckPPCBuiltinFunctionCall(/*uint*/int BuiltinID, CallExpr /*P*/ TheCall) {
  /*uint*/int i = 0;
  /*uint*/int l = 0;
  /*uint*/int u = 0;
  boolean Is64BitBltin = BuiltinID == PPC.BI__builtin_divde
     || BuiltinID == PPC.BI__builtin_divdeu
     || BuiltinID == PPC.BI__builtin_bpermd;
  boolean IsTarget64Bit = $this().Context.getTargetInfo().
      getTypeWidth($this().Context.
          getTargetInfo().
          getIntPtrType()) == 64;
  boolean IsBltinExtDiv = BuiltinID == PPC.BI__builtin_divwe
     || BuiltinID == PPC.BI__builtin_divweu
     || BuiltinID == PPC.BI__builtin_divde
     || BuiltinID == PPC.BI__builtin_divdeu;
  if (Is64BitBltin && !IsTarget64Bit) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_64_bit_builtin_32_bit_tgt)), 
          TheCall.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  if ((IsBltinExtDiv && !$this().Context.getTargetInfo().hasFeature(new StringRef(/*KEEP_STR*/"extdiv")))
     || (BuiltinID == PPC.BI__builtin_bpermd
     && !$this().Context.getTargetInfo().hasFeature(new StringRef(/*KEEP_STR*/"bpermd")))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_ppc_builtin_only_on_pwr7)), 
          TheCall.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  switch (BuiltinID) {
   default:
    return false;
   case PPC.BI__builtin_altivec_crypto_vshasigmaw:
   case PPC.BI__builtin_altivec_crypto_vshasigmad:
    return $this().SemaBuiltinConstantArgRange(TheCall, 1, 0, 1)
       || $this().SemaBuiltinConstantArgRange(TheCall, 2, 0, 15);
   case PPC.BI__builtin_tbegin:
   case PPC.BI__builtin_tend:
    i = 0;
    l = 0;
    u = 1;
    break;
   case PPC.BI__builtin_tsr:
    i = 0;
    l = 0;
    u = 7;
    break;
   case PPC.BI__builtin_tabortwc:
   case PPC.BI__builtin_tabortdc:
    i = 0;
    l = 0;
    u = 31;
    break;
   case PPC.BI__builtin_tabortwci:
   case PPC.BI__builtin_tabortdci:
    return $this().SemaBuiltinConstantArgRange(TheCall, 0, 0, 31)
       || $this().SemaBuiltinConstantArgRange(TheCall, 2, 0, 31);
  }
  return $this().SemaBuiltinConstantArgRange(TheCall, i, l, u);
}


/// Check the arguments to '__builtin_va_start' or '__builtin_ms_va_start'
/// for validity.  Emit an error and return true on failure; return false
/// on success.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinVAStartImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3120,
 FQN="clang::Sema::SemaBuiltinVAStartImpl", NM="_ZN5clang4Sema22SemaBuiltinVAStartImplEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema22SemaBuiltinVAStartImplEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinVAStartImpl(CallExpr /*P*/ TheCall) {
  Expr /*P*/ Fn = TheCall.getCallee();
  if ($greater_uint(TheCall.getNumArgs(), 2)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getArg(2).getLocStart(), 
                              diag.err_typecheck_call_too_many_args)), 
                          0/*function call*/), 2), TheCall.getNumArgs()), 
              Fn.getSourceRange()), 
          new SourceRange(TheCall.getArg(2).getLocStart(), 
              ((TheCall.arg_end().$sub(1)).$star()).getLocEnd())));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if ($less_uint(TheCall.getNumArgs(), 2)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), 
                      diag.err_typecheck_call_too_few_args_at_least)), 
                  0/*function call*/), 2), TheCall.getNumArgs()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Type-check the first argument normally.
  if (SemaCheckingStatics.checkBuiltinArgument(/*Deref*/$this(), TheCall, 0)) {
    return true;
  }
  
  // Determine whether the current function is variadic or not.
  BlockScopeInfo /*P*/ CurBlock = $this().getCurBlock();
  boolean isVariadic;
  if ((CurBlock != null)) {
    isVariadic = CurBlock.TheDecl.isVariadic();
  } else {
    FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
    if ((FD != null)) {
      isVariadic = FD.isVariadic();
    } else {
      isVariadic = $this().getCurMethodDecl().isVariadic();
    }
  }
  if (!isVariadic) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(Fn.getLocStart(), diag.err_va_start_used_in_non_variadic_function)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Verify that the second argument to the builtin is the last argument of the
  // current function or method.
  boolean SecondArgIsLastNamedArgument = false;
  /*const*/ Expr /*P*/ Arg = TheCall.getArg(1).IgnoreParenCasts();
  
  // These are valid if SecondArgIsLastNamedArgument is false after the next
  // block.
  QualType Type/*J*/= new QualType();
  SourceLocation ParamLoc/*J*/= new SourceLocation();
  boolean IsCRegister = false;
  {
    
    /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(Arg);
    if ((DR != null)) {
      {
        /*const*/ ParmVarDecl /*P*/ PV = dyn_cast_ParmVarDecl(DR.getDecl$Const());
        if ((PV != null)) {
          // FIXME: This isn't correct for methods (results in bogus warning).
          // Get the last formal in the current function.
          /*const*/ ParmVarDecl /*P*/ LastArg;
          if ((CurBlock != null)) {
            LastArg = CurBlock.TheDecl.parameters().back();
          } else {
            FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
            if ((FD != null)) {
              LastArg = FD.parameters().back();
            } else {
              LastArg = $this().getCurMethodDecl().parameters().back();
            }
          }
          SecondArgIsLastNamedArgument = PV == LastArg;
          
          Type.$assignMove(PV.getType());
          ParamLoc.$assignMove(PV.getLocation());
          IsCRegister
             = PV.getStorageClass() == StorageClass.SC_Register && !$this().getLangOpts().CPlusPlus;
        }
      }
    }
  }
  if (!SecondArgIsLastNamedArgument) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(TheCall.getArg(1).getLocStart(), 
          diag.warn_second_arg_of_va_start_not_last_named_param)));
    } finally {
      $c$.$destroy();
    }
  } else if (IsCRegister || Type.$arrow().isReferenceType()
     || Type.$arrow().isPromotableIntegerType()
     || Type.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Float.getValue())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int Reason = 0;
      if (Type.$arrow().isReferenceType()) {
        Reason = 1;
      } else if (IsCRegister) {
        Reason = 2;
      }
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track($this().Diag(Arg.getLocStart(), diag.warn_va_start_type_is_undefined)), Reason));
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(ParamLoc), diag.note_parameter_type)), Type));
    } finally {
      $c$.$destroy();
    }
  }
  
  TheCall.setType($this().Context.VoidTy.$QualType());
  return false;
}


/// Check the arguments to '__builtin_va_start' for validity, and that
/// it was called from a function of the native ABI.
/// Emit an error and return true on failure; return false on success.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinVAStart">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3208,
 FQN="clang::Sema::SemaBuiltinVAStart", NM="_ZN5clang4Sema18SemaBuiltinVAStartEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema18SemaBuiltinVAStartEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinVAStart(CallExpr /*P*/ TheCall) {
  // On x86-64 Unix, don't allow this in Win64 ABI functions.
  // On x64 Windows, don't allow this in System V ABI functions.
  // (Yes, that means there's no corresponding way to support variadic
  // System V ABI functions on Windows.)
  if ($this().Context.getTargetInfo().getTriple().getArch() == Triple.ArchType.x86_64) {
    /*uint*/int OS = $this().Context.getTargetInfo().getTriple().getOS().getValue();
    CallingConv CC = CallingConv.CC_C;
    {
      /*const*/ FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
      if ((FD != null)) {
        CC = FD.getType().$arrow().getAs(FunctionType.class).getCallConv();
      }
    }
    if ((OS == Triple.OSType.Win32.getValue() && CC == CallingConv.CC_X86_64SysV)
       || (OS != Triple.OSType.Win32.getValue() && CC == CallingConv.CC_X86_64Win64)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(TheCall.getCallee().getLocStart(), 
                diag.err_va_start_used_in_wrong_abi_function)), 
            (OS != Triple.OSType.Win32.getValue())).$bool());
      } finally {
        $c$.$destroy();
      }
    }
  }
  return $this().SemaBuiltinVAStartImpl(TheCall);
}


/// Check the arguments to '__builtin_ms_va_start' for validity, and that
/// it was called from a Win64 ABI function.
/// Emit an error and return true on failure; return false on success.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinMSVAStart">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3230,
 FQN="clang::Sema::SemaBuiltinMSVAStart", NM="_ZN5clang4Sema20SemaBuiltinMSVAStartEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema20SemaBuiltinMSVAStartEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinMSVAStart(CallExpr /*P*/ TheCall) {
  // This only makes sense for x86-64.
  final /*const*/ Triple /*&*/ TT = $this().Context.getTargetInfo().getTriple();
  Expr /*P*/ Callee = TheCall.getCallee();
  if (TT.getArch() != Triple.ArchType.x86_64) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($c$.track($this().Diag(Callee.getLocStart(), diag.err_x86_builtin_32_bit_tgt)).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  // Don't allow this in System V ABI functions.
  CallingConv CC = CallingConv.CC_C;
  {
    /*const*/ FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
    if ((FD != null)) {
      CC = FD.getType().$arrow().getAs(FunctionType.class).getCallConv();
    }
  }
  if (CC == CallingConv.CC_X86_64SysV
     || (TT.getOS() != Triple.OSType.Win32 && CC != CallingConv.CC_X86_64Win64)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($c$.track($this().Diag(Callee.getLocStart(), 
          diag.err_ms_va_start_used_in_sysv_function)).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  return $this().SemaBuiltinVAStartImpl(TheCall);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinVAStartARM">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3247,
 FQN="clang::Sema::SemaBuiltinVAStartARM", NM="_ZN5clang4Sema21SemaBuiltinVAStartARMEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema21SemaBuiltinVAStartARMEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinVAStartARM(CallExpr /*P*/ Call) {
  // void __va_start(va_list *ap, const char *named_addr, size_t slot_size,
  //                 const char *named_addr);
  Expr /*P*/ Func = Call.getCallee();
  if ($less_uint(Call.getNumArgs(), 3)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(Call.getLocEnd(), 
                      diag.err_typecheck_call_too_few_args_at_least)), 
                  0/*function call*/), 3), Call.getNumArgs()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Determine whether the current function is variadic or not.
  boolean IsVariadic;
  {
    BlockScopeInfo /*P*/ CurBlock = $this().getCurBlock();
    if ((CurBlock != null)) {
      IsVariadic = CurBlock.TheDecl.isVariadic();
    } else {
      FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
      if ((FD != null)) {
        IsVariadic = FD.isVariadic();
      } else {
        ObjCMethodDecl /*P*/ MD = $this().getCurMethodDecl();
        if ((MD != null)) {
          IsVariadic = MD.isVariadic();
        } else {
          throw new llvm_unreachable("unexpected statement type");
        }
      }
    }
  }
  if (!IsVariadic) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(Func.getLocStart(), diag.err_va_start_used_in_non_variadic_function)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Type-check the first argument normally.
  if (SemaCheckingStatics.checkBuiltinArgument(/*Deref*/$this(), Call, 0)) {
    return true;
  }
  
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3278,
   FQN="", NM="_ZN5clang4Sema21SemaBuiltinVAStartARMEPNS_8CallExprE_Unnamed_struct",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema21SemaBuiltinVAStartARMEPNS_8CallExprE_Unnamed_struct")
  //</editor-fold>
   class/*struct*/ Unnamed_struct {
    public /*uint*/int ArgNo;
    public QualType Type;

    public Unnamed_struct(int ArgNo, QualType Type) {
      this.ArgNo = ArgNo;
      this.Type = Type;
    }    
    
    @Override public String toString() {
      return "" + "ArgNo=" + ArgNo // NOI18N
                + ", Type=" + Type; // NOI18N
    }
  }
Unnamed_struct ArgumentTypes[/*2*/] = new Unnamed_struct [/*2*/] {
    new Unnamed_struct(1, $this().Context.getPointerType($this().Context.CharTy.withConst())), 
    new Unnamed_struct(2, $this().Context.getSizeType().$QualType())
  };
  
  for (final Unnamed_struct AT : ArgumentTypes) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Expr /*P*/ Arg = Call.getArg(AT.ArgNo).IgnoreParens();
      if (QualType.$eq_QualType$C(Arg.getType().getCanonicalType(), AT.Type.getCanonicalType())) {
        continue;
      }
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(Arg.getLocStart(), diag.err_typecheck_convert_incompatible)), 
                                      Arg.getType()), AT.Type), 1/* different class */), 
                          0/* qualifier difference */), 3/* parameter mismatch */), 
                  AT.ArgNo + 1), Arg.getType()), AT.Type));
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// SemaBuiltinUnorderedCompare - Handle functions like __builtin_isgreater and
/// friends.  This is declared to take (...), so we have to check everything.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinUnorderedCompare">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3301,
 FQN="clang::Sema::SemaBuiltinUnorderedCompare", NM="_ZN5clang4Sema27SemaBuiltinUnorderedCompareEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema27SemaBuiltinUnorderedCompareEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinUnorderedCompare(CallExpr /*P*/ TheCall) {
  if ($less_uint(TheCall.getNumArgs(), 2)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), diag.err_typecheck_call_too_few_args)), 
                  0), 2), TheCall.getNumArgs()/*function call*/).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  if ($greater_uint(TheCall.getNumArgs(), 2)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getArg(2).getLocStart(), 
                          diag.err_typecheck_call_too_many_args)), 
                      0/*function call*/), 2), TheCall.getNumArgs()), 
          new SourceRange(TheCall.getArg(2).getLocStart(), 
              ((TheCall.arg_end().$sub(1)).$star()).getLocEnd())).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > OrigArg0 = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall.getArg(0));
  ActionResultTTrue<Expr /*P*/ > OrigArg1 = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall.getArg(1));
  
  // Do standard promotions between the two arguments, returning their common
  // type.
  QualType Res = $this().UsualArithmeticConversions(OrigArg0, OrigArg1, false);
  if (OrigArg0.isInvalid() || OrigArg1.isInvalid()) {
    return true;
  }
  
  // Make sure any conversions are pushed back into the call; this is
  // type safe since unordered compare builtins are declared as "_Bool
  // foo(...)".
  TheCall.setArg(0, OrigArg0.get());
  TheCall.setArg(1, OrigArg1.get());
  if (OrigArg0.get().isTypeDependent() || OrigArg1.get().isTypeDependent()) {
    return false;
  }
  
  // If the common type isn't a real floating type, then the arguments were
  // invalid for this operation.
  if (Res.isNull() || !Res.$arrow().isRealFloatingType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(OrigArg0.get().getLocStart(), 
                      diag.err_typecheck_call_invalid_ordered_compare)), 
                  OrigArg0.get().getType()), OrigArg1.get().getType()), 
          new SourceRange(OrigArg0.get().getLocStart(), OrigArg1.get().getLocEnd())).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// SemaBuiltinSemaBuiltinFPClassification - Handle functions like
/// __builtin_isnan and friends.  This is declared to take (...), so we have
/// to check everything. We expect the last argument to be a floating point
/// value.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinFPClassification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3345,
 FQN="clang::Sema::SemaBuiltinFPClassification", NM="_ZN5clang4Sema27SemaBuiltinFPClassificationEPNS_8CallExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema27SemaBuiltinFPClassificationEPNS_8CallExprEj")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinFPClassification(CallExpr /*P*/ TheCall, /*uint*/int NumArgs) {
  if ($less_uint(TheCall.getNumArgs(), NumArgs)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), diag.err_typecheck_call_too_few_args)), 
                  0), NumArgs), TheCall.getNumArgs()/*function call*/).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  if ($greater_uint(TheCall.getNumArgs(), NumArgs)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getArg(NumArgs).getLocStart(), 
                          diag.err_typecheck_call_too_many_args)), 
                      0/*function call*/), NumArgs), TheCall.getNumArgs()), 
          new SourceRange(TheCall.getArg(NumArgs).getLocStart(), 
              ((TheCall.arg_end().$sub(1)).$star()).getLocEnd())).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  Expr /*P*/ OrigArg = TheCall.getArg(NumArgs - 1);
  if (OrigArg.isTypeDependent()) {
    return false;
  }
  
  // This operation requires a non-_Complex floating-point number.
  if (!OrigArg.getType().$arrow().isRealFloatingType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(OrigArg.getLocStart(), 
                  diag.err_typecheck_call_invalid_unary_fp)), 
              OrigArg.getType()), OrigArg.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // If this is an implicit conversion from float -> double, remove it.
    ImplicitCastExpr /*P*/ Cast = dyn_cast_ImplicitCastExpr(OrigArg);
    if ((Cast != null)) {
      Expr /*P*/ CastArg = Cast.getSubExpr();
      if (CastArg.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Float.getValue())) {
        assert (Cast.getType().$arrow().isSpecificBuiltinType(BuiltinType.Kind.Double.getValue())) : "promotion from float to double is the only expected cast here";
        Cast.setSubExpr((Expr /*P*/ )null);
        TheCall.setArg(NumArgs - 1, CastArg);
      }
    }
  }
  
  return false;
}

// Used by C++ template instantiation.

/// SemaBuiltinShuffleVector - Handle __builtin_shufflevector.
// This is declared to take (...), so we have to check everything.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinShuffleVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3383,
 FQN="clang::Sema::SemaBuiltinShuffleVector", NM="_ZN5clang4Sema24SemaBuiltinShuffleVectorEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema24SemaBuiltinShuffleVectorEPNS_8CallExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > SemaBuiltinShuffleVector(CallExpr /*P*/ TheCall) {
  if ($less_uint(TheCall.getNumArgs(), 2)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), 
                              diag.err_typecheck_call_too_few_args_at_least)), 
                          0/*function call*/), 2), TheCall.getNumArgs()), 
              TheCall.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Determine which of the following types of shufflevector we're checking:
  // 1) unary, vector mask: (lhs, mask)
  // 2) binary, scalar mask: (lhs, rhs, index, ..., index)
  QualType resType = TheCall.getArg(0).getType();
  /*uint*/int numElements = 0;
  if (!TheCall.getArg(0).isTypeDependent()
     && !TheCall.getArg(1).isTypeDependent()) {
    QualType LHSType = TheCall.getArg(0).getType();
    QualType RHSType = TheCall.getArg(1).getType();
    if (!LHSType.$arrow().isVectorType() || !RHSType.$arrow().isVectorType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), 
                    diag.err_shufflevector_non_vector)), 
                new SourceRange(TheCall.getArg(0).getLocStart(), 
                    TheCall.getArg(1).getLocEnd()))));
      } finally {
        $c$.$destroy();
      }
    }
    
    numElements = LHSType.$arrow().getAs(VectorType.class).getNumElements();
    /*uint*/int numResElements = TheCall.getNumArgs() - 2;
    
    // Check to see if we have a call with 2 vector arguments, the unary shuffle
    // with mask.  If so, verify that RHS is an integer vector type with the
    // same number of elts as lhs.
    if (TheCall.getNumArgs() == 2) {
      if (!RHSType.$arrow().hasIntegerRepresentation()
         || RHSType.$arrow().getAs(VectorType.class).getNumElements() != numElements) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), 
                      diag.err_shufflevector_incompatible_vector)), 
                  new SourceRange(TheCall.getArg(1).getLocStart(), 
                      TheCall.getArg(1).getLocEnd()))));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (!$this().Context.hasSameUnqualifiedType(new QualType(LHSType), new QualType(RHSType))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), 
                    diag.err_shufflevector_incompatible_vector)), 
                new SourceRange(TheCall.getArg(0).getLocStart(), 
                    TheCall.getArg(1).getLocEnd()))));
      } finally {
        $c$.$destroy();
      }
    } else if (numElements != numResElements) {
      QualType eltType = LHSType.$arrow().getAs(VectorType.class).getElementType();
      resType.$assignMove($this().Context.getVectorType(new QualType(eltType), numResElements, 
              VectorType.VectorKind.GenericVector));
    }
  }
  
  for (/*uint*/int i = 2; $less_uint(i, TheCall.getNumArgs()); i++) {
    if (TheCall.getArg(i).isTypeDependent()
       || TheCall.getArg(i).isValueDependent()) {
      continue;
    }
    
    APSInt Result/*J*/= new APSInt(32);
    if (!TheCall.getArg(i).isIntegerConstantExpr(Result, $this().Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), 
                    diag.err_shufflevector_nonconstant_argument)), 
                TheCall.getArg(i).getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Allow -1 which will be translated to undef in the IR.
    if (Result.isSigned() && Result.isAllOnesValue()) {
      continue;
    }
    if ($greater_uint(Result.getActiveBits(), 64) || $greatereq_ulong_uint(Result.getZExtValue(), numElements * 2)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), 
                    diag.err_shufflevector_argument_too_large)), 
                TheCall.getArg(i).getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  SmallVector<Expr /*P*/ > exprs/*J*/= new SmallVector<Expr /*P*/ >(32, (Expr /*P*/ )null);
  
  for (/*uint*/int i = 0, e = TheCall.getNumArgs(); i != e; i++) {
    exprs.push_back(TheCall.getArg(i));
    TheCall.setArg(i, (Expr /*P*/ )null);
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ShuffleVectorExpr($this().Context, new ArrayRef<Expr /*P*/ >(exprs, true), new QualType(resType), 
                  TheCall.getCallee().getLocStart(), 
                  TheCall.getRParenLoc());
       }));
}


/// SemaConvertVectorExpr - Handle __builtin_convertvector
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaConvertVectorExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3466,
 FQN="clang::Sema::SemaConvertVectorExpr", NM="_ZN5clang4Sema21SemaConvertVectorExprEPNS_4ExprEPNS_14TypeSourceInfoENS_14SourceLocationES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema21SemaConvertVectorExprEPNS_4ExprEPNS_14TypeSourceInfoENS_14SourceLocationES5_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > SemaConvertVectorExpr(Expr /*P*/ E, TypeSourceInfo /*P*/ TInfo, 
                     SourceLocation BuiltinLoc, 
                     SourceLocation RParenLoc) {
  ExprValueKind VK = ExprValueKind.VK_RValue;
  ExprObjectKind OK = ExprObjectKind.OK_Ordinary;
  QualType DstTy = TInfo.getType();
  QualType SrcTy = E.getType();
  if (!SrcTy.$arrow().isVectorType() && !SrcTy.$arrow().isDependentType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(BuiltinLoc), 
                  diag.err_convertvector_non_vector)), 
              E.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  if (!DstTy.$arrow().isVectorType() && !DstTy.$arrow().isDependentType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(BuiltinLoc), 
              diag.err_convertvector_non_vector_type))));
    } finally {
      $c$.$destroy();
    }
  }
  if (!SrcTy.$arrow().isDependentType() && !DstTy.$arrow().isDependentType()) {
    /*uint*/int SrcElts = SrcTy.$arrow().getAs(VectorType.class).getNumElements();
    /*uint*/int DstElts = DstTy.$arrow().getAs(VectorType.class).getNumElements();
    if (SrcElts != DstElts) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(BuiltinLoc), 
                    diag.err_convertvector_incompatible_vector)), 
                E.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ConvertVectorExpr(E, TInfo, new QualType(DstTy), VK, OK, new SourceLocation(BuiltinLoc), new SourceLocation(RParenLoc));
       }));
}


/// SemaBuiltinPrefetch - Handle __builtin_prefetch.
// This is declared to take (const void*, ...) and can take two
// optional constant int args.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinPrefetch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3498,
 FQN="clang::Sema::SemaBuiltinPrefetch", NM="_ZN5clang4Sema19SemaBuiltinPrefetchEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema19SemaBuiltinPrefetchEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinPrefetch(CallExpr /*P*/ TheCall) {
  /*uint*/int NumArgs = TheCall.getNumArgs();
  if ($greater_uint(NumArgs, 3)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), 
                          diag.err_typecheck_call_too_many_args_at_most)), 
                      0/*function call*/), 3), NumArgs), 
          TheCall.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Argument 0 is checked for us and the remaining arguments must be
  // constant integers.
  for (/*uint*/int i = 1; i != NumArgs; ++i)  {
    if ($this().SemaBuiltinConstantArgRange(TheCall, i, 0, i == 1 ? 1 : 3)) {
      return true;
    }
  }
  
  return false;
}


/// SemaBuiltinAssume - Handle __assume (MS Extension).
// __assume does not evaluate its arguments, and should warn if its argument
// has side effects.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinAssume">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3519,
 FQN="clang::Sema::SemaBuiltinAssume", NM="_ZN5clang4Sema17SemaBuiltinAssumeEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema17SemaBuiltinAssumeEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinAssume(CallExpr /*P*/ TheCall) {
  Expr /*P*/ Arg = TheCall.getArg(0);
  if (Arg.isInstantiationDependent()) {
    return false;
  }
  if (Arg.HasSideEffects($this().Context)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_II(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(Arg.getLocStart(), diag.warn_assume_side_effects)), 
              Arg.getSourceRange()), 
          cast_FunctionDecl(TheCall.getCalleeDecl()).getIdentifier()));
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// Handle __builtin_assume_aligned. This is declared
/// as (const void*, size_t, ...) and can take one optional constant int arg.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinAssumeAligned">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3533,
 FQN="clang::Sema::SemaBuiltinAssumeAligned", NM="_ZN5clang4Sema24SemaBuiltinAssumeAlignedEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema24SemaBuiltinAssumeAlignedEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinAssumeAligned(CallExpr /*P*/ TheCall) {
  /*uint*/int NumArgs = TheCall.getNumArgs();
  if ($greater_uint(NumArgs, 3)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), 
                          diag.err_typecheck_call_too_many_args_at_most)), 
                      0/*function call*/), 3), NumArgs), 
          TheCall.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // The alignment must be a constant integer.
  Expr /*P*/ Arg = TheCall.getArg(1);
  
  // We can't check the value of a dependent argument.
  if (!Arg.isTypeDependent() && !Arg.isValueDependent()) {
    APSInt Result/*J*/= new APSInt();
    if ($this().SemaBuiltinConstantArg(TheCall, 1, Result)) {
      return true;
    }
    if (!Result.isPowerOf2()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), 
                diag.err_alignment_not_power_of_two)), 
            Arg.getSourceRange()).$bool());
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ($greater_uint(NumArgs, 2)) {
    ActionResultTTrue<Expr /*P*/ > Arg$1/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall.getArg(2));
    InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, 
        $this().Context.getSizeType().$QualType(), false);
    Arg$1.$assignMove($this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(Arg$1)));
    if (Arg$1.isInvalid()) {
      return true;
    }
    TheCall.setArg(2, Arg$1.get());
  }
  
  return false;
}


/// SemaBuiltinLongjmp - Handle __builtin_longjmp(void *env[5], int val).
/// This checks that the target supports __builtin_longjmp and
/// that val is a constant 1.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinLongjmp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3712,
 FQN="clang::Sema::SemaBuiltinLongjmp", NM="_ZN5clang4Sema18SemaBuiltinLongjmpEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema18SemaBuiltinLongjmpEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinLongjmp(CallExpr /*P*/ TheCall) {
  if (!$this().Context.getTargetInfo().hasSjLjLowering()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_builtin_longjmp_unsupported)), 
          new SourceRange(TheCall.getLocStart(), TheCall.getLocEnd())).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  Expr /*P*/ Arg = TheCall.getArg(1);
  APSInt Result/*J*/= new APSInt();
  
  // TODO: This is less than ideal. Overload this to take a value.
  if ($this().SemaBuiltinConstantArg(TheCall, 1, Result)) {
    return true;
  }
  if (Result.$noteq(1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_builtin_longjmp_invalid_val)), 
          new SourceRange(Arg.getLocStart(), Arg.getLocEnd())).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// SemaBuiltinSetjmp - Handle __builtin_setjmp(void *env[5]).
/// This checks that the target supports __builtin_setjmp.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinSetjmp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3733,
 FQN="clang::Sema::SemaBuiltinSetjmp", NM="_ZN5clang4Sema17SemaBuiltinSetjmpEPNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema17SemaBuiltinSetjmpEPNS_8CallExprE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinSetjmp(CallExpr /*P*/ TheCall) {
  if (!$this().Context.getTargetInfo().hasSjLjLowering()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_builtin_setjmp_unsupported)), 
          new SourceRange(TheCall.getLocStart(), TheCall.getLocEnd())).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}


/// SemaBuiltinAtomicOverloaded - We have a call to a function like
/// __sync_fetch_and_add, which is an overloaded function based on the pointer
/// type of its first argument.  The main ActOnCallExpr routines have already
/// promoted the types of arguments because all of these calls are prototyped as
/// void(...).
///
/// This function goes through and does final semantic checking for these
/// builtins,
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinAtomicOverloaded">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2653,
 FQN="clang::Sema::SemaBuiltinAtomicOverloaded", NM="_ZN5clang4Sema27SemaBuiltinAtomicOverloadedENS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema27SemaBuiltinAtomicOverloadedENS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
protected/*private*/ final ActionResultTTrue<Expr /*P*/ > SemaBuiltinAtomicOverloaded(ActionResultTTrue<Expr /*P*/ > TheCallResult) {
  CallExpr /*P*/ TheCall = (CallExpr /*P*/ )TheCallResult.get();
  DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(TheCall.getCallee().IgnoreParenCasts());
  FunctionDecl /*P*/ FDecl = cast_FunctionDecl(DRE.getDecl());
  
  // Ensure that we have at least one argument to do type inference from.
  if ($less_uint(TheCall.getNumArgs(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), diag.err_typecheck_call_too_few_args_at_least)), 
                      0), 1), TheCall.getNumArgs()), 
          TheCall.getCallee().getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Inspect the first argument of the atomic builtin.  This should always be
  // a pointer type, whose element is an integral scalar or pointer type.
  // Because it is a pointer type, we don't have to worry about any implicit
  // casts here.
  // FIXME: We don't allow floating point scalars as input.
  Expr /*P*/ FirstArg = TheCall.getArg(0);
  ActionResultTTrue<Expr /*P*/ > FirstArgResult = $this().DefaultFunctionArrayLvalueConversion(FirstArg);
  if (FirstArgResult.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  FirstArg = FirstArgResult.get();
  TheCall.setArg(0, FirstArg);
  
  /*const*/ PointerType /*P*/ pointerType = FirstArg.getType().$arrow().getAs(PointerType.class);
  if (!(pointerType != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_builtin_must_be_pointer)), 
              FirstArg.getType()), FirstArg.getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType ValType = pointerType.getPointeeType();
  if (!ValType.$arrow().isIntegerType() && !ValType.$arrow().isAnyPointerType()
     && !ValType.$arrow().isBlockPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_builtin_must_be_pointer_intptr)), 
              FirstArg.getType()), FirstArg.getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  switch (ValType.getObjCLifetime()) {
   case OCL_None:
   case OCL_ExplicitNone:
    // okay
    break;
   case OCL_Weak:
   case OCL_Strong:
   case OCL_Autoreleasing:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_arc_atomic_ownership)), 
                ValType), FirstArg.getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Strip any qualifiers off ValType.
  ValType.$assignMove(ValType.getUnqualifiedType());
  
  // The majority of builtins return a value, but a few have special return
  // types, so allow them to override appropriately below.
  QualType ResultType = new QualType(ValType);
  
  final/*static*/ /*const*//*uint*/int BuiltinIndices[/*17*/][/*5*/] = SemaBuiltinAtomicOverloaded$$.BuiltinIndices;
  
  // Determine the index of the size.
  /*uint*/int SizeIndex;
  switch ((int) $this().Context.getTypeSizeInChars(/*NO_COPY*/ValType).getQuantity()) {
   case 1:
    SizeIndex = 0;
    break;
   case 2:
    SizeIndex = 1;
    break;
   case 4:
    SizeIndex = 2;
    break;
   case 8:
    SizeIndex = 3;
    break;
   case 16:
    SizeIndex = 4;
    break;
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_builtin_pointer_size)), 
                FirstArg.getType()), FirstArg.getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Each of these builtins has one pointer argument, followed by some number of
  // values (0, 1 or 2) followed by a potentially empty varags list of stuff
  // that we ignore.  Find out which row of BuiltinIndices to read from as well
  // as the number of fixed args.
  /*uint*/int BuiltinID = FDecl.getBuiltinID();
  /*uint*/int BuiltinIndex;
  /*uint*/int NumFixed = 1;
  boolean WarnAboutSemanticsChange = false;
  switch (ID.valueOf(BuiltinID)) {
   default:
    throw new llvm_unreachable("Unknown overloaded atomic builtin!");
   case BI__sync_fetch_and_add:
   case BI__sync_fetch_and_add_1:
   case BI__sync_fetch_and_add_2:
   case BI__sync_fetch_and_add_4:
   case BI__sync_fetch_and_add_8:
   case BI__sync_fetch_and_add_16:
    BuiltinIndex = 0;
    break;
   case BI__sync_fetch_and_sub:
   case BI__sync_fetch_and_sub_1:
   case BI__sync_fetch_and_sub_2:
   case BI__sync_fetch_and_sub_4:
   case BI__sync_fetch_and_sub_8:
   case BI__sync_fetch_and_sub_16:
    BuiltinIndex = 1;
    break;
   case BI__sync_fetch_and_or:
   case BI__sync_fetch_and_or_1:
   case BI__sync_fetch_and_or_2:
   case BI__sync_fetch_and_or_4:
   case BI__sync_fetch_and_or_8:
   case BI__sync_fetch_and_or_16:
    BuiltinIndex = 2;
    break;
   case BI__sync_fetch_and_and:
   case BI__sync_fetch_and_and_1:
   case BI__sync_fetch_and_and_2:
   case BI__sync_fetch_and_and_4:
   case BI__sync_fetch_and_and_8:
   case BI__sync_fetch_and_and_16:
    BuiltinIndex = 3;
    break;
   case BI__sync_fetch_and_xor:
   case BI__sync_fetch_and_xor_1:
   case BI__sync_fetch_and_xor_2:
   case BI__sync_fetch_and_xor_4:
   case BI__sync_fetch_and_xor_8:
   case BI__sync_fetch_and_xor_16:
    BuiltinIndex = 4;
    break;
   case BI__sync_fetch_and_nand:
   case BI__sync_fetch_and_nand_1:
   case BI__sync_fetch_and_nand_2:
   case BI__sync_fetch_and_nand_4:
   case BI__sync_fetch_and_nand_8:
   case BI__sync_fetch_and_nand_16:
    BuiltinIndex = 5;
    WarnAboutSemanticsChange = true;
    break;
   case BI__sync_add_and_fetch:
   case BI__sync_add_and_fetch_1:
   case BI__sync_add_and_fetch_2:
   case BI__sync_add_and_fetch_4:
   case BI__sync_add_and_fetch_8:
   case BI__sync_add_and_fetch_16:
    BuiltinIndex = 6;
    break;
   case BI__sync_sub_and_fetch:
   case BI__sync_sub_and_fetch_1:
   case BI__sync_sub_and_fetch_2:
   case BI__sync_sub_and_fetch_4:
   case BI__sync_sub_and_fetch_8:
   case BI__sync_sub_and_fetch_16:
    BuiltinIndex = 7;
    break;
   case BI__sync_and_and_fetch:
   case BI__sync_and_and_fetch_1:
   case BI__sync_and_and_fetch_2:
   case BI__sync_and_and_fetch_4:
   case BI__sync_and_and_fetch_8:
   case BI__sync_and_and_fetch_16:
    BuiltinIndex = 8;
    break;
   case BI__sync_or_and_fetch:
   case BI__sync_or_and_fetch_1:
   case BI__sync_or_and_fetch_2:
   case BI__sync_or_and_fetch_4:
   case BI__sync_or_and_fetch_8:
   case BI__sync_or_and_fetch_16:
    BuiltinIndex = 9;
    break;
   case BI__sync_xor_and_fetch:
   case BI__sync_xor_and_fetch_1:
   case BI__sync_xor_and_fetch_2:
   case BI__sync_xor_and_fetch_4:
   case BI__sync_xor_and_fetch_8:
   case BI__sync_xor_and_fetch_16:
    BuiltinIndex = 10;
    break;
   case BI__sync_nand_and_fetch:
   case BI__sync_nand_and_fetch_1:
   case BI__sync_nand_and_fetch_2:
   case BI__sync_nand_and_fetch_4:
   case BI__sync_nand_and_fetch_8:
   case BI__sync_nand_and_fetch_16:
    BuiltinIndex = 11;
    WarnAboutSemanticsChange = true;
    break;
   case BI__sync_val_compare_and_swap:
   case BI__sync_val_compare_and_swap_1:
   case BI__sync_val_compare_and_swap_2:
   case BI__sync_val_compare_and_swap_4:
   case BI__sync_val_compare_and_swap_8:
   case BI__sync_val_compare_and_swap_16:
    BuiltinIndex = 12;
    NumFixed = 2;
    break;
   case BI__sync_bool_compare_and_swap:
   case BI__sync_bool_compare_and_swap_1:
   case BI__sync_bool_compare_and_swap_2:
   case BI__sync_bool_compare_and_swap_4:
   case BI__sync_bool_compare_and_swap_8:
   case BI__sync_bool_compare_and_swap_16:
    BuiltinIndex = 13;
    NumFixed = 2;
    ResultType.$assignMove($this().Context.BoolTy.$QualType());
    break;
   case BI__sync_lock_test_and_set:
   case BI__sync_lock_test_and_set_1:
   case BI__sync_lock_test_and_set_2:
   case BI__sync_lock_test_and_set_4:
   case BI__sync_lock_test_and_set_8:
   case BI__sync_lock_test_and_set_16:
    BuiltinIndex = 14;
    break;
   case BI__sync_lock_release:
   case BI__sync_lock_release_1:
   case BI__sync_lock_release_2:
   case BI__sync_lock_release_4:
   case BI__sync_lock_release_8:
   case BI__sync_lock_release_16:
    BuiltinIndex = 15;
    NumFixed = 0;
    ResultType.$assignMove($this().Context.VoidTy.$QualType());
    break;
   case BI__sync_swap:
   case BI__sync_swap_1:
   case BI__sync_swap_2:
   case BI__sync_swap_4:
   case BI__sync_swap_8:
   case BI__sync_swap_16:
    BuiltinIndex = 16;
    break;
  }
  
  // Now that we know how many fixed arguments we expect, first check that we
  // have at least that many.
  if ($less_uint(TheCall.getNumArgs(), 1 + NumFixed)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), diag.err_typecheck_call_too_few_args_at_least)), 
                      0), 1 + NumFixed), TheCall.getNumArgs()), 
          TheCall.getCallee().getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if (WarnAboutSemanticsChange) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocEnd(), diag.warn_sync_fetch_and_nand_semantics_change)), 
          TheCall.getCallee().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Get the decl for the concrete builtin from this, we can tell what the
  // concrete integer type we should convert to is.
  /*uint*/int NewBuiltinID = BuiltinIndices[BuiltinIndex][SizeIndex];
  /*const*/char$ptr/*char P*/ NewBuiltinName = $tryClone($this().Context.BuiltinInfo.getName(NewBuiltinID));
  FunctionDecl /*P*/ NewBuiltinDecl;
  if (NewBuiltinID == BuiltinID) {
    NewBuiltinDecl = FDecl;
  } else {
    LookupResult Res = null;
    try {
      // Perform builtin lookup to avoid redeclaring it.
      DeclarationName DN/*J*/= new DeclarationName($AddrOf($this().Context.Idents.get(/*JAVA PERF*/NewBuiltinName.$array(), NewBuiltinName.$index(), std.strlen(NewBuiltinName))));
      Res/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(DN), DRE.getLocStart(), LookupNameKind.LookupOrdinaryName);
      $this().LookupName(Res, $this().TUScope, /*AllowBuiltinCreation=*/ true);
      assert Native.$bool(Res.getFoundDecl());
      NewBuiltinDecl = dyn_cast_FunctionDecl(Res.getFoundDecl());
      if (!(NewBuiltinDecl != null)) {
        return SemaClangGlobals.ExprError();
      }
    } finally {
      if (Res != null) { Res.$destroy(); }
    }
  }
  
  // The first argument --- the pointer --- has a fixed type; we
  // deduce the types of the rest of the arguments accordingly.  Walk
  // the remaining arguments, converting them to the deduced value type.
  for (/*uint*/int i = 0; i != NumFixed; ++i) {
    ActionResultTTrue<Expr /*P*/ > Arg = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall.getArg(i + 1));
    
    // GCC does an implicit conversion to the pointer or integer ValType.  This
    // can fail in some cases (1i -> int**), check for this error case now.
    // Initialize the argument.
    InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, 
        new QualType(ValType), /*consume*/ false);
    Arg.$assignMove($this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(Arg)));
    if (Arg.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    
    // Okay, we have something that *can* be converted to the right type.  Check
    // to see if there is a potentially weird extension going on here.  This can
    // happen when you do an atomic operation on something like an char* and
    // pass in 42.  The 42 gets converted to char.  This is even more strange
    // for things like 45.123 -> char, etc.
    // FIXME: Do this check.
    TheCall.setArg(i + 1, Arg.get());
  }
  
  final ASTContext /*&*/ Context = $this().getASTContext();
  
  // Create a new DeclRefExpr to refer to the new decl.
  DeclRefExpr /*P*/ NewDRE = DeclRefExpr.Create(Context, 
      DRE.getQualifierLoc(), 
      new SourceLocation(), 
      NewBuiltinDecl, 
      /*enclosing*/ false, 
      DRE.getLocation(), 
      Context.BuiltinFnTy.$QualType(), 
      DRE.getValueKind());
  
  // Set the callee in the CallExpr.
  // FIXME: This loses syntactic information.
  QualType CalleePtrTy = Context.getPointerType(NewBuiltinDecl.getType());
  ActionResultTTrue<Expr /*P*/ > PromotedCall = $this().ImpCastExprToType(NewDRE, new QualType(CalleePtrTy), 
      CastKind.CK_BuiltinFnToFnPtr);
  TheCall.setCallee(PromotedCall.get());
  
  // Change the result type of the call to match the original value type. This
  // is arbitrary, but the codegen for these builtins ins design to handle it
  // gracefully.
  TheCall.setType(new QualType(ResultType));
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, TheCallResult);
}
private static final class SemaBuiltinAtomicOverloaded$$ {
  static final/*static*/ /*const*//*uint*/int BuiltinIndices[/*17*/][/*5*/] = new /*const*//*uint*/int [/*5*/] [/*17*/] {
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_fetch_and_add_1.getValue(), Builtin.ID.BI__sync_fetch_and_add_2.getValue(), Builtin.ID.BI__sync_fetch_and_add_4.getValue(), Builtin.ID.BI__sync_fetch_and_add_8.getValue(), Builtin.ID.BI__sync_fetch_and_add_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_fetch_and_sub_1.getValue(), Builtin.ID.BI__sync_fetch_and_sub_2.getValue(), Builtin.ID.BI__sync_fetch_and_sub_4.getValue(), Builtin.ID.BI__sync_fetch_and_sub_8.getValue(), Builtin.ID.BI__sync_fetch_and_sub_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_fetch_and_or_1.getValue(), Builtin.ID.BI__sync_fetch_and_or_2.getValue(), Builtin.ID.BI__sync_fetch_and_or_4.getValue(), Builtin.ID.BI__sync_fetch_and_or_8.getValue(), Builtin.ID.BI__sync_fetch_and_or_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_fetch_and_and_1.getValue(), Builtin.ID.BI__sync_fetch_and_and_2.getValue(), Builtin.ID.BI__sync_fetch_and_and_4.getValue(), Builtin.ID.BI__sync_fetch_and_and_8.getValue(), Builtin.ID.BI__sync_fetch_and_and_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_fetch_and_xor_1.getValue(), Builtin.ID.BI__sync_fetch_and_xor_2.getValue(), Builtin.ID.BI__sync_fetch_and_xor_4.getValue(), Builtin.ID.BI__sync_fetch_and_xor_8.getValue(), Builtin.ID.BI__sync_fetch_and_xor_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_fetch_and_nand_1.getValue(), Builtin.ID.BI__sync_fetch_and_nand_2.getValue(), Builtin.ID.BI__sync_fetch_and_nand_4.getValue(), Builtin.ID.BI__sync_fetch_and_nand_8.getValue(), Builtin.ID.BI__sync_fetch_and_nand_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_add_and_fetch_1.getValue(), Builtin.ID.BI__sync_add_and_fetch_2.getValue(), Builtin.ID.BI__sync_add_and_fetch_4.getValue(), Builtin.ID.BI__sync_add_and_fetch_8.getValue(), Builtin.ID.BI__sync_add_and_fetch_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_sub_and_fetch_1.getValue(), Builtin.ID.BI__sync_sub_and_fetch_2.getValue(), Builtin.ID.BI__sync_sub_and_fetch_4.getValue(), Builtin.ID.BI__sync_sub_and_fetch_8.getValue(), Builtin.ID.BI__sync_sub_and_fetch_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_and_and_fetch_1.getValue(), Builtin.ID.BI__sync_and_and_fetch_2.getValue(), Builtin.ID.BI__sync_and_and_fetch_4.getValue(), Builtin.ID.BI__sync_and_and_fetch_8.getValue(), Builtin.ID.BI__sync_and_and_fetch_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_or_and_fetch_1.getValue(), Builtin.ID.BI__sync_or_and_fetch_2.getValue(), Builtin.ID.BI__sync_or_and_fetch_4.getValue(), Builtin.ID.BI__sync_or_and_fetch_8.getValue(), Builtin.ID.BI__sync_or_and_fetch_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_xor_and_fetch_1.getValue(), Builtin.ID.BI__sync_xor_and_fetch_2.getValue(), Builtin.ID.BI__sync_xor_and_fetch_4.getValue(), Builtin.ID.BI__sync_xor_and_fetch_8.getValue(), Builtin.ID.BI__sync_xor_and_fetch_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_nand_and_fetch_1.getValue(), Builtin.ID.BI__sync_nand_and_fetch_2.getValue(), Builtin.ID.BI__sync_nand_and_fetch_4.getValue(), Builtin.ID.BI__sync_nand_and_fetch_8.getValue(), Builtin.ID.BI__sync_nand_and_fetch_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_val_compare_and_swap_1.getValue(), Builtin.ID.BI__sync_val_compare_and_swap_2.getValue(), Builtin.ID.BI__sync_val_compare_and_swap_4.getValue(), Builtin.ID.BI__sync_val_compare_and_swap_8.getValue(), Builtin.ID.BI__sync_val_compare_and_swap_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_bool_compare_and_swap_1.getValue(), Builtin.ID.BI__sync_bool_compare_and_swap_2.getValue(), Builtin.ID.BI__sync_bool_compare_and_swap_4.getValue(), Builtin.ID.BI__sync_bool_compare_and_swap_8.getValue(), Builtin.ID.BI__sync_bool_compare_and_swap_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_lock_test_and_set_1.getValue(), Builtin.ID.BI__sync_lock_test_and_set_2.getValue(), Builtin.ID.BI__sync_lock_test_and_set_4.getValue(), Builtin.ID.BI__sync_lock_test_and_set_8.getValue(), Builtin.ID.BI__sync_lock_test_and_set_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_lock_release_1.getValue(), Builtin.ID.BI__sync_lock_release_2.getValue(), Builtin.ID.BI__sync_lock_release_4.getValue(), Builtin.ID.BI__sync_lock_release_8.getValue(), Builtin.ID.BI__sync_lock_release_16.getValue()}, 
  new /*const*//*uint*/int [/*5*/] {Builtin.ID.BI__sync_swap_1.getValue(), Builtin.ID.BI__sync_swap_2.getValue(), Builtin.ID.BI__sync_swap_4.getValue(), Builtin.ID.BI__sync_swap_8.getValue(), Builtin.ID.BI__sync_swap_16.getValue()}
};
}


/// SemaBuiltinNontemporalOverloaded - We have a call to
/// __builtin_nontemporal_store or __builtin_nontemporal_load, which is an
/// overloaded function based on the pointer type of its last argument.
///
/// This function goes through and does final semantic checking for these
/// builtins.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinNontemporalOverloaded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3019,
 FQN="clang::Sema::SemaBuiltinNontemporalOverloaded", NM="_ZN5clang4Sema32SemaBuiltinNontemporalOverloadedENS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema32SemaBuiltinNontemporalOverloadedENS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
protected/*private*/ final ActionResultTTrue<Expr /*P*/ > SemaBuiltinNontemporalOverloaded(ActionResultTTrue<Expr /*P*/ > TheCallResult) {
  CallExpr /*P*/ TheCall = (CallExpr /*P*/ )TheCallResult.get();
  DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(TheCall.getCallee().IgnoreParenCasts());
  FunctionDecl /*P*/ FDecl = cast_FunctionDecl(DRE.getDecl());
  /*uint*/int BuiltinID = FDecl.getBuiltinID();
  assert ((BuiltinID == Builtin.ID.BI__builtin_nontemporal_store.getValue() || BuiltinID == Builtin.ID.BI__builtin_nontemporal_load.getValue())) : "Unexpected nontemporal load/store builtin!";
  boolean isStore = BuiltinID == Builtin.ID.BI__builtin_nontemporal_store.getValue();
  /*uint*/int numArgs = isStore ? 2 : 1;
  
  // Ensure that we have the proper number of arguments.
  if (SemaCheckingStatics.checkArgCount(/*Deref*/$this(), TheCall, numArgs)) {
    return SemaClangGlobals.ExprError();
  }
  
  // Inspect the last argument of the nontemporal builtin.  This should always
  // be a pointer type, from which we imply the type of the memory access.
  // Because it is a pointer type, we don't have to worry about any implicit
  // casts here.
  Expr /*P*/ PointerArg = TheCall.getArg(numArgs - 1);
  ActionResultTTrue<Expr /*P*/ > PointerArgResult = $this().DefaultFunctionArrayLvalueConversion(PointerArg);
  if (PointerArgResult.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  PointerArg = PointerArgResult.get();
  TheCall.setArg(numArgs - 1, PointerArg);
  
  /*const*/ PointerType /*P*/ pointerType = PointerArg.getType().$arrow().getAs(PointerType.class);
  if (!(pointerType != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_nontemporal_builtin_must_be_pointer)), 
              PointerArg.getType()), PointerArg.getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType ValType = pointerType.getPointeeType();
  
  // Strip any qualifiers off ValType.
  ValType.$assignMove(ValType.getUnqualifiedType());
  if (!ValType.$arrow().isIntegerType() && !ValType.$arrow().isAnyPointerType()
     && !ValType.$arrow().isBlockPointerType() && !ValType.$arrow().isFloatingType()
     && !ValType.$arrow().isVectorType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), 
                  diag.err_nontemporal_builtin_must_be_pointer_intfltptr_or_vector)), 
              PointerArg.getType()), PointerArg.getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if (!isStore) {
    TheCall.setType(new QualType(ValType));
    return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, TheCallResult);
  }
  
  ActionResultTTrue<Expr /*P*/ > ValArg = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall.getArg(0));
  InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, new QualType(ValType), /*consume*/ false);
  ValArg.$assignMove($this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(ValArg)));
  if (ValArg.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  
  TheCall.setArg(0, ValArg.get());
  TheCall.setType($this().Context.VoidTy.$QualType());
  return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, TheCallResult);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaAtomicOpsOverloaded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 2277,
 FQN="clang::Sema::SemaAtomicOpsOverloaded", NM="_ZN5clang4Sema23SemaAtomicOpsOverloadedENS_12ActionResultIPNS_4ExprELb1EEENS_10AtomicExpr8AtomicOpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema23SemaAtomicOpsOverloadedENS_12ActionResultIPNS_4ExprELb1EEENS_10AtomicExpr8AtomicOpE")
//</editor-fold>
protected/*private*/ final ActionResultTTrue<Expr /*P*/ > SemaAtomicOpsOverloaded(ActionResultTTrue<Expr /*P*/ > TheCallResult, 
                       AtomicExpr.AtomicOp Op) {
  CallExpr /*P*/ TheCall = cast_CallExpr(TheCallResult.get());
  DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(TheCall.getCallee().IgnoreParenCasts());
  
  // All these operations take one of the following forms:
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    // C    __c11_atomic_init(A *, C)
    final /*uint*/int Init = 0;
    // C    __c11_atomic_load(A *, int)
    final /*uint*/int Load = Init + 1;
    // void __atomic_load(A *, CP, int)
    final /*uint*/int LoadCopy = Load + 1;
    // void __atomic_store(A *, CP, int)
    final /*uint*/int Copy = LoadCopy + 1;
    // C    __c11_atomic_add(A *, M, int)
    final /*uint*/int Arithmetic = Copy + 1;
    // C    __atomic_exchange_n(A *, CP, int)
    final /*uint*/int Xchg = Arithmetic + 1;
    // void __atomic_exchange(A *, C *, CP, int)
    final /*uint*/int GNUXchg = Xchg + 1;
    // bool __c11_atomic_compare_exchange_strong(A *, C *, CP, int, int)
    final /*uint*/int C11CmpXchg = GNUXchg + 1;
    // bool __atomic_compare_exchange(A *, C *, CP, bool, int, int)
    final /*uint*/int GNUCmpXchg = C11CmpXchg + 1;
  /*}*//*Unnamed enum*//*uint*/int Form = Init;
  /*const*//*uint*/int NumArgs[/*9*/] = new /*const*//*uint*/int [/*9*/] {2, 2, 3, 3, 3, 3, 4, 5, 6};
  /*const*//*uint*/int NumVals[/*9*/] = new /*const*//*uint*/int [/*9*/] {1, 0, 1, 1, 1, 1, 2, 2, 3};
  // where:
  //   C is an appropriate type,
  //   A is volatile _Atomic(C) for __c11 builtins and is C for GNU builtins,
  //   CP is C for __c11 builtins and GNU _n builtins and is C * otherwise,
  //   M is C if C is an integer, and ptrdiff_t if C is a pointer, and
  //   the int parameters are for orderings.
  static_assert(AtomicExpr.AtomicOp.AO__c11_atomic_init.getValue() == 0
     && AtomicExpr.AtomicOp.AO__c11_atomic_fetch_xor.getValue() + 1
     == AtomicExpr.AtomicOp.AO__atomic_load.getValue(), $("need to update code for modified C11 atomics"));
  boolean IsC11 = Op.getValue() >= AtomicExpr.AtomicOp.AO__c11_atomic_init.getValue()
     && Op.getValue() <= AtomicExpr.AtomicOp.AO__c11_atomic_fetch_xor.getValue();
  boolean IsN = Op == AtomicExpr.AtomicOp.AO__atomic_load_n
     || Op == AtomicExpr.AtomicOp.AO__atomic_store_n
     || Op == AtomicExpr.AtomicOp.AO__atomic_exchange_n
     || Op == AtomicExpr.AtomicOp.AO__atomic_compare_exchange_n;
  boolean IsAddSub = false;
  switch (Op) {
   case AO__c11_atomic_init:
    Form = Init;
    break;
   case AO__c11_atomic_load:
   case AO__atomic_load_n:
    Form = Load;
    break;
   case AO__atomic_load:
    Form = LoadCopy;
    break;
   case AO__c11_atomic_store:
   case AO__atomic_store:
   case AO__atomic_store_n:
    Form = Copy;
    break;
   case AO__c11_atomic_fetch_add:
   case AO__c11_atomic_fetch_sub:
   case AO__atomic_fetch_add:
   case AO__atomic_fetch_sub:
   case AO__atomic_add_fetch:
   case AO__atomic_sub_fetch:
    IsAddSub = true;
   case AO__c11_atomic_fetch_and:
   case AO__c11_atomic_fetch_or:
   case AO__c11_atomic_fetch_xor:
   case AO__atomic_fetch_and:
   case AO__atomic_fetch_or:
   case AO__atomic_fetch_xor:
   case AO__atomic_fetch_nand:
   case AO__atomic_and_fetch:
   case AO__atomic_or_fetch:
   case AO__atomic_xor_fetch:
   case AO__atomic_nand_fetch:
    // Fall through.
    Form = Arithmetic;
    break;
   case AO__c11_atomic_exchange:
   case AO__atomic_exchange_n:
    Form = Xchg;
    break;
   case AO__atomic_exchange:
    Form = GNUXchg;
    break;
   case AO__c11_atomic_compare_exchange_strong:
   case AO__c11_atomic_compare_exchange_weak:
    Form = C11CmpXchg;
    break;
   case AO__atomic_compare_exchange:
   case AO__atomic_compare_exchange_n:
    Form = GNUCmpXchg;
    break;
  }
  
  // Check we have the right number of arguments.
  if ($less_uint(TheCall.getNumArgs(), NumArgs[Form])) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocEnd(), diag.err_typecheck_call_too_few_args)), 
                      0), NumArgs[Form]), TheCall.getNumArgs()), 
          TheCall.getCallee().getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  } else if ($greater_uint(TheCall.getNumArgs(), NumArgs[Form])) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getArg(NumArgs[Form]).getLocStart(), 
                          diag.err_typecheck_call_too_many_args)), 
                      0), NumArgs[Form]), TheCall.getNumArgs()), 
          TheCall.getCallee().getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Inspect the first argument of the atomic operation.
  Expr /*P*/ Ptr = TheCall.getArg(0);
  ActionResultTTrue<Expr /*P*/ > ConvertedPtr = $this().DefaultFunctionArrayLvalueConversion(Ptr);
  if (ConvertedPtr.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  
  Ptr = ConvertedPtr.get();
  /*const*/ PointerType /*P*/ pointerType = Ptr.getType().$arrow().getAs(PointerType.class);
  if (!(pointerType != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_builtin_must_be_pointer)), 
              Ptr.getType()), Ptr.getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  
  // For a __c11 builtin, this should be a pointer to an _Atomic type.
  QualType AtomTy = pointerType.getPointeeType(); // 'A'
  QualType ValType = new QualType(AtomTy); // 'C'
  if (IsC11) {
    if (!AtomTy.$arrow().isAtomicType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_op_needs_atomic)), 
                Ptr.getType()), Ptr.getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    if (AtomTy.isConstQualified()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_op_needs_non_const_atomic)), 
                Ptr.getType()), Ptr.getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    ValType.$assignMove(AtomTy.$arrow().getAs(AtomicType.class).getValueType());
  } else if (Form != Load && Form != LoadCopy) {
    if (ValType.isConstQualified()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_op_needs_non_const_pointer)), 
                Ptr.getType()), Ptr.getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // For an arithmetic operation, the implied arithmetic must be well-formed.
  if (Form == Arithmetic) {
    // gcc does not enforce these rules for GNU atomics, but we do so for sanity.
    if (IsAddSub && !ValType.$arrow().isIntegerType() && !ValType.$arrow().isPointerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_op_needs_atomic_int_or_ptr)), 
                    IsC11), Ptr.getType()), Ptr.getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    if (!IsAddSub && !ValType.$arrow().isIntegerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_op_bitwise_needs_atomic_int)), 
                    IsC11), Ptr.getType()), Ptr.getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    if (IsC11 && ValType.$arrow().isPointerType()
       && $this().RequireCompleteType(Ptr.getLocStart(), ValType.$arrow().getPointeeType(), 
        diag.err_incomplete_type)) {
      return SemaClangGlobals.ExprError();
    }
  } else if (IsN && !ValType.$arrow().isIntegerType() && !ValType.$arrow().isPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // For __atomic_*_n operations, the value type must be a scalar integral or
      // pointer type which is 1, 2, 4, 8 or 16 bytes in length.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_op_needs_atomic_int_or_ptr)), 
                  IsC11), Ptr.getType()), Ptr.getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if (!IsC11 && !AtomTy.isTriviallyCopyableType($this().Context)
     && !AtomTy.$arrow().isScalarType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // For GNU atomics, require a trivially-copyable type. This is not part of
      // the GNU atomics specification, but we enforce it for sanity.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_atomic_op_needs_trivial_copy)), 
              Ptr.getType()), Ptr.getSourceRange()));
      return SemaClangGlobals.ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  switch (ValType.getObjCLifetime()) {
   case OCL_None:
   case OCL_ExplicitNone:
    // okay
    break;
   case OCL_Weak:
   case OCL_Strong:
   case OCL_Autoreleasing:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // FIXME: Can this happen? By this point, ValType should be known
        // to be trivially copyable.
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DRE.getLocStart(), diag.err_arc_atomic_ownership)), 
                ValType), Ptr.getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // atomic_fetch_or takes a pointer to a volatile 'A'.  We shouldn't let the
  // volatile-ness of the pointee-type inject itself into the result or the
  // other operands. Similarly atomic_load can take a pointer to a const 'A'.
  ValType.removeLocalVolatile();
  ValType.removeLocalConst();
  QualType ResultType = new QualType(ValType);
  if (Form == Copy || Form == LoadCopy || Form == GNUXchg || Form == Init) {
    ResultType.$assignMove($this().Context.VoidTy.$QualType());
  } else if (Form == C11CmpXchg || Form == GNUCmpXchg) {
    ResultType.$assignMove($this().Context.BoolTy.$QualType());
  }
  
  // The type of a parameter passed 'by value'. In the GNU atomics, such
  // arguments are actually passed as pointers.
  QualType ByValType = new QualType(ValType); // 'CP'
  if (!IsC11 && !IsN) {
    ByValType.$assignMove(Ptr.getType());
  }
  
  // The first argument --- the pointer --- has a fixed type; we
  // deduce the types of the rest of the arguments accordingly.  Walk
  // the remaining arguments, converting them to the deduced value type.
  for (/*uint*/int i = 1; i != NumArgs[Form]; ++i) {
    QualType Ty/*J*/= new QualType();
    if ($less_uint(i, NumVals[Form] + 1)) {
      switch (i) {
       case 1:
        // The second argument is the non-atomic operand. For arithmetic, this
        // is always passed by value, and for a compare_exchange it is always
        // passed by address. For the rest, GNU uses by-address and C11 uses
        // by-value.
        assert (Form != Load);
        if (Form == Init || (Form == Arithmetic && ValType.$arrow().isIntegerType())) {
          Ty.$assign(ValType);
        } else if (Form == Copy || Form == Xchg) {
          Ty.$assign(ByValType);
        } else if (Form == Arithmetic) {
          Ty.$assignMove($this().Context.getPointerDiffType());
        } else {
          Expr /*P*/ ValArg = TheCall.getArg(i);
          /*uint*/int AS = 0;
          {
            // Keep address space of non-atomic pointer type.
            /*const*/ PointerType /*P*/ PtrTy = ValArg.getType().$arrow().getAs(PointerType.class);
            if ((PtrTy != null)) {
              AS = PtrTy.getPointeeType().getAddressSpace();
            }
          }
          Ty.$assignMove($this().Context.getPointerType($this().Context.getAddrSpaceQualType(ValType.getUnqualifiedType(), AS)));
        }
        break;
       case 2:
        // The third argument to compare_exchange / GNU exchange is a
        // (pointer to a) desired value.
        Ty.$assign(ByValType);
        break;
       case 3:
        // The fourth argument to GNU compare_exchange is a 'weak' flag.
        Ty.$assignMove($this().Context.BoolTy.$QualType());
        break;
      }
    } else {
      // The order(s) are always converted to int.
      Ty.$assignMove($this().Context.IntTy.$QualType());
    }
    
    InitializedEntity Entity = InitializedEntity.InitializeParameter($this().Context, new QualType(Ty), false);
    ActionResultTTrue<Expr /*P*/ > Arg = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TheCall.getArg(i));
    Arg.$assignMove($this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(Arg)));
    if (Arg.isInvalid()) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    TheCall.setArg(i, Arg.get());
  }
  
  // Permute the arguments into a 'consistent' order.
  SmallVector<Expr /*P*/ > SubExprs/*J*/= new SmallVector<Expr /*P*/ >(5, (Expr /*P*/ )null);
  SubExprs.push_back(Ptr);
  switch (Form) {
   case Init:
    // Note, AtomicExpr::getVal1() has a special case for this atomic.
    SubExprs.push_back(TheCall.getArg(1)); // Val1
    break;
   case Load:
    SubExprs.push_back(TheCall.getArg(1)); // Order
    break;
   case LoadCopy:
   case Copy:
   case Arithmetic:
   case Xchg:
    SubExprs.push_back(TheCall.getArg(2)); // Order
    SubExprs.push_back(TheCall.getArg(1)); // Val1
    break;
   case GNUXchg:
    // Note, AtomicExpr::getVal2() has a special case for this atomic.
    SubExprs.push_back(TheCall.getArg(3)); // Order
    SubExprs.push_back(TheCall.getArg(1)); // Val1
    SubExprs.push_back(TheCall.getArg(2)); // Val2
    break;
   case C11CmpXchg:
    SubExprs.push_back(TheCall.getArg(3)); // Order
    SubExprs.push_back(TheCall.getArg(1)); // Val1
    SubExprs.push_back(TheCall.getArg(4)); // OrderFail
    SubExprs.push_back(TheCall.getArg(2)); // Val2
    break;
   case GNUCmpXchg:
    SubExprs.push_back(TheCall.getArg(4)); // Order
    SubExprs.push_back(TheCall.getArg(1)); // Val1
    SubExprs.push_back(TheCall.getArg(5)); // OrderFail
    SubExprs.push_back(TheCall.getArg(2)); // Val2
    SubExprs.push_back(TheCall.getArg(3)); // Weak
    break;
  }
  if ($greatereq_uint(SubExprs.size(), 2) && Form != Init) {
    APSInt Result/*J*/= new APSInt(32);
    if (SubExprs.$at(1).isIntegerConstantExpr(Result, $this().Context)
       && !SemaCheckingStatics.isValidOrderingForOp(Result.getSExtValue(), Op)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(SubExprs.$at(1).getLocStart(), 
                diag.warn_atomic_op_has_invalid_memory_order)), 
            SubExprs.$at(1).getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  AtomicExpr /*P*/ AE = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new AtomicExpr(TheCall.getCallee().getLocStart(), 
              new ArrayRef<Expr /*P*/ >(SubExprs, true), new QualType(ResultType), Op, 
              TheCall.getRParenLoc());
   });
  if ((Op == AtomicExpr.AtomicOp.AO__c11_atomic_load
     || (Op == AtomicExpr.AtomicOp.AO__c11_atomic_store))
     && $this().Context.AtomicUsesUnsupportedLibcall(AE)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(AE.getLocStart(), diag.err_atomic_load_store_uses_lib)), 
          ((Op == AtomicExpr.AtomicOp.AO__c11_atomic_load) ? 0 : 1)));
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, AE);
}


/// SemaBuiltinConstantArg - Handle a check if argument ArgNum of CallExpr
/// TheCall is a constant expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinConstantArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3571,
 FQN="clang::Sema::SemaBuiltinConstantArg", NM="_ZN5clang4Sema22SemaBuiltinConstantArgEPNS_8CallExprEiRN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema22SemaBuiltinConstantArgEPNS_8CallExprEiRN4llvm6APSIntE")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinConstantArg(CallExpr /*P*/ TheCall, int ArgNum, 
                      final APSInt /*&*/ Result) {
  Expr /*P*/ Arg = TheCall.getArg(ArgNum);
  DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(TheCall.getCallee().IgnoreParenCasts());
  FunctionDecl /*P*/ FDecl = cast_FunctionDecl(DRE.getDecl());
  if (Arg.isTypeDependent() || Arg.isValueDependent()) {
    return false;
  }
  if (!Arg.isIntegerConstantExpr(Result, $this().Context)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(TheCall.getLocStart(), diag.err_constant_integer_arg_type)), 
              FDecl.getDeclName()), Arg.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// SemaBuiltinConstantArgRange - Handle a check if argument ArgNum of CallExpr
/// TheCall is a constant expression in the range [Low, High].
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinConstantArgRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3588,
 FQN="clang::Sema::SemaBuiltinConstantArgRange", NM="_ZN5clang4Sema27SemaBuiltinConstantArgRangeEPNS_8CallExprEiii",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema27SemaBuiltinConstantArgRangeEPNS_8CallExprEiii")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinConstantArgRange(CallExpr /*P*/ TheCall, int ArgNum, 
                           int Low, int High) {
  APSInt Result/*J*/= new APSInt();
  
  // We can't check the value of a dependent argument.
  Expr /*P*/ Arg = TheCall.getArg(ArgNum);
  if (Arg.isTypeDependent() || Arg.isValueDependent()) {
    return false;
  }
  
  // Check constant-ness first.
  if ($this().SemaBuiltinConstantArg(TheCall, ArgNum, Result)) {
    return true;
  }
  if (Result.getSExtValue() < Low || Result.getSExtValue() > High) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(TheCall.getLocStart(), diag.err_argument_invalid_range)), 
                  Low), High), Arg.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// SemaBuiltinARMSpecialReg - Handle a check if argument ArgNum of CallExpr
/// TheCall is an ARM/AArch64 special register string literal.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SemaBuiltinARMSpecialReg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 3610,
 FQN="clang::Sema::SemaBuiltinARMSpecialReg", NM="_ZN5clang4Sema24SemaBuiltinARMSpecialRegEjPNS_8CallExprEijb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema24SemaBuiltinARMSpecialRegEjPNS_8CallExprEijb")
//</editor-fold>
protected/*private*/ final boolean SemaBuiltinARMSpecialReg(/*uint*/int BuiltinID, CallExpr /*P*/ TheCall, 
                        int ArgNum, /*uint*/int ExpectedFieldNum, 
                        boolean AllowName) {
  boolean IsARMBuiltin = BuiltinID == ARM.BI__builtin_arm_rsr64
     || BuiltinID == ARM.BI__builtin_arm_wsr64
     || BuiltinID == ARM.BI__builtin_arm_rsr
     || BuiltinID == ARM.BI__builtin_arm_rsrp
     || BuiltinID == ARM.BI__builtin_arm_wsr
     || BuiltinID == ARM.BI__builtin_arm_wsrp;
  boolean IsAArch64Builtin = BuiltinID == AArch64.BI__builtin_arm_rsr64
     || BuiltinID == AArch64.BI__builtin_arm_wsr64
     || BuiltinID == AArch64.BI__builtin_arm_rsr
     || BuiltinID == AArch64.BI__builtin_arm_rsrp
     || BuiltinID == AArch64.BI__builtin_arm_wsr
     || BuiltinID == AArch64.BI__builtin_arm_wsrp;
  assert ((IsARMBuiltin || IsAArch64Builtin)) : "Unexpected ARM builtin.";
  
  // We can't check the value of a dependent argument.
  Expr /*P*/ Arg = TheCall.getArg(ArgNum);
  if (Arg.isTypeDependent() || Arg.isValueDependent()) {
    return false;
  }
  
  // Check if the argument is a string literal.
  if (!isa_StringLiteral(Arg.IgnoreParenImpCasts())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_expr_not_string_literal)), 
          Arg.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check the type of special register given.
  StringRef Reg = cast_StringLiteral(Arg.IgnoreParenImpCasts()).getString();
  SmallVector<StringRef> Fields/*J*/= new SmallVector<StringRef>(6, new StringRef());
  Reg.split(Fields, /*STRINGREF_STR*/":");
  if (Fields.size() != ExpectedFieldNum && !(AllowName && Fields.size() == 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_arm_invalid_specialreg)), 
          Arg.getSourceRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // If the string is the name of a register then we cannot check that it is
  // valid here but if the string is of one the forms described in ACLE then we
  // can check that the supplied fields are integers and within the valid
  // ranges.
  if ($greater_uint(Fields.size(), 1)) {
    boolean FiveFields = Fields.size() == 5;
    
    boolean ValidString = true;
    if (IsARMBuiltin) {
      ValidString &= Fields.$at(0).startswith_lower(/*STRINGREF_STR*/"cp")
         || Fields.$at(0).startswith_lower(/*STRINGREF_STR*/"p");
      if (ValidString) {
        Fields.$at(0).$assignMove(
            Fields.$at(0).drop_front(Fields.$at(0).startswith_lower(/*STRINGREF_STR*/"cp") ? 2 : 1)
        );
      }
      
      ValidString &= Fields.$at(2).startswith_lower(/*STRINGREF_STR*/"c");
      if (ValidString) {
        Fields.$at(2).$assignMove(Fields.$at(2).drop_front(1));
      }
      if (FiveFields) {
        ValidString &= Fields.$at(3).startswith_lower(/*STRINGREF_STR*/"c");
        if (ValidString) {
          Fields.$at(3).$assignMove(Fields.$at(3).drop_front(1));
        }
      }
    }
    
    SmallVectorInt/*5*/ Ranges/*J*/= new SmallVectorInt/*5*/(5);
    if (FiveFields) {
      Ranges.append(new$int(5, IsAArch64Builtin ? 1 : 15, 7, 7, 15, 15));
    } else {
      Ranges.append(new$int(3, 15, 7, 15));
    }
    
    for (/*uint*/int i = 0; $less_uint(i, Fields.size()); ++i) {
      int$ref IntField = create_int$ref();
      ValidString &= !Fields.$at(i).getAsInteger$Signed(10, IntField);
      ValidString &= (IntField.$deref() >= 0 && IntField.$deref() <= Ranges.$at(i));
    }
    if (!ValidString) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TheCall.getLocStart(), diag.err_arm_invalid_specialreg)), 
            Arg.getSourceRange()).$bool());
      } finally {
        $c$.$destroy();
      }
    }
  } else if (IsAArch64Builtin && Fields.size() == 1) {
    // If the register name is one of those that appear in the condition below
    // and the special register builtin being used is one of the write builtins,
    // then we require that the argument provided for writing to the register
    // is an integer constant expression. This is because it will be lowered to
    // an MSR (immediate) instruction, so we need to know the immediate at
    // compile time.
    if (TheCall.getNumArgs() != 2) {
      return false;
    }
    
    std.string RegLower = Reg.lower();
    if ($noteq_string$C_T$C$P(RegLower, /*KEEP_STR*/"spsel") && $noteq_string$C_T$C$P(RegLower, /*KEEP_STR*/"daifset") && $noteq_string$C_T$C$P(RegLower, /*KEEP_STR*/"daifclr")
       && $noteq_string$C_T$C$P(RegLower, /*KEEP_STR*/"pan") && $noteq_string$C_T$C$P(RegLower, /*KEEP_STR*/"uao")) {
      return false;
    }
    
    return $this().SemaBuiltinConstantArgRange(TheCall, 1, 0, 15);
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetFormatStringType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4015,
 FQN="clang::Sema::GetFormatStringType", NM="_ZN5clang4Sema19GetFormatStringTypeEPKNS_10FormatAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema19GetFormatStringTypeEPKNS_10FormatAttrE")
//</editor-fold>
public static Sema.FormatStringType GetFormatStringType(/*const*/ FormatAttr /*P*/ Format) {
  return new StringSwitch<FormatStringType>(Format.getType().getName()).
      Case(/*KEEP_STR*/"scanf", FormatStringType.FST_Scanf).
      Cases(/*KEEP_STR*/"printf", /*KEEP_STR*/"printf0", FormatStringType.FST_Printf).
      Cases(/*KEEP_STR*/"NSString", /*KEEP_STR*/"CFString", FormatStringType.FST_NSString).
      Case(/*KEEP_STR*/"strftime", FormatStringType.FST_Strftime).
      Case(/*KEEP_STR*/"strfmon", FormatStringType.FST_Strfmon).
      Cases(/*KEEP_STR*/"kprintf", /*KEEP_STR*/"cmn_err", /*KEEP_STR*/"vcmn_err", /*KEEP_STR*/"zcmn_err", FormatStringType.FST_Kprintf).
      Case(/*KEEP_STR*/"freebsd_kprintf", FormatStringType.FST_FreeBSDKPrintf).
      Case(/*KEEP_STR*/"os_trace", FormatStringType.FST_OSTrace).
      Default(FormatStringType.FST_Unknown);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::FormatStringHasSArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5624,
 FQN="clang::Sema::FormatStringHasSArg", NM="_ZN5clang4Sema19FormatStringHasSArgEPKNS_13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema19FormatStringHasSArgEPKNS_13StringLiteralE")
//</editor-fold>
public final boolean FormatStringHasSArg(/*const*/ StringLiteral /*P*/ FExpr) {
  // Str - The format string.  NOTE: this is NOT null-terminated!
  StringRef StrRef = FExpr.getString();
  /*const*/char$ptr/*char P*/ Str = $tryClone(StrRef.data());
  // Account for cases where the string literal is truncated in a declaration.
  /*const*/ ConstantArrayType /*P*/ T = $this().Context.getAsConstantArrayType(FExpr.getType());
  assert ((T != null)) : "String literal not of constant array type!";
  /*size_t*/int TypeSize = $ulong2uint(T.getSize().getZExtValue());
  /*size_t*/int StrLen = std.min_uint(std.max(TypeSize, ((/*size_t*/int)(1))) - 1, StrRef.size());
  return Analyze_format_stringGlobals.ParseFormatStringHasSArg(Str, Str.$add(StrLen), 
      $this().getLangOpts(), 
      $this().Context.getTargetInfo());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::GetFormatNSStringIdx">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 1930,
 FQN="clang::Sema::GetFormatNSStringIdx", NM="_ZN5clang4Sema20GetFormatNSStringIdxEPKNS_10FormatAttrERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema20GetFormatNSStringIdxEPKNS_10FormatAttrERj")
//</editor-fold>
public static boolean GetFormatNSStringIdx(/*const*/ FormatAttr /*P*/ Format, final uint$ref/*uint &*/ Idx) {
  FormatStringInfo FSI/*J*/= new FormatStringInfo();
  if ((GetFormatStringType(Format) == FormatStringType.FST_NSString)
     && getFormatStringInfo(Format, false, $AddrOf(FSI))) {
    Idx.$set(FSI.FormatIdx);
    return true;
  }
  return false;
}


/// CheckFormatArguments - Check calls to printf and scanf (and similar
/// functions) for correct use of format strings.
/// Returns true if a format string has been fully checked.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFormatArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4031,
 FQN="clang::Sema::CheckFormatArguments", NM="_ZN5clang4Sema20CheckFormatArgumentsEPKNS_10FormatAttrEN4llvm8ArrayRefIPKNS_4ExprEEEbNS0_16VariadicCallTypeENS_14SourceLocationENS_11SourceRangeERNS4_14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema20CheckFormatArgumentsEPKNS_10FormatAttrEN4llvm8ArrayRefIPKNS_4ExprEEEbNS0_16VariadicCallTypeENS_14SourceLocationENS_11SourceRangeERNS4_14SmallBitVectorE")
//</editor-fold>
protected/*private*/ final boolean CheckFormatArguments(/*const*/ FormatAttr /*P*/ Format, 
                    ArrayRef</*const*/ Expr /*P*/ > Args, 
                    boolean IsCXXMember, 
                    VariadicCallType CallType, 
                    SourceLocation Loc, SourceRange Range, 
                    final SmallBitVector /*&*/ CheckedVarArgs) {
  FormatStringInfo FSI/*J*/= new FormatStringInfo();
  if (getFormatStringInfo(Format, IsCXXMember, $AddrOf(FSI))) {
    return $this().CheckFormatArguments(new ArrayRef</*const*/ Expr /*P*/ >(Args), FSI.HasVAListArg, FSI.FormatIdx, 
        FSI.FirstDataArg, GetFormatStringType(Format), 
        CallType, new SourceLocation(Loc), new SourceRange(Range), CheckedVarArgs);
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFormatArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 4045,
 FQN="clang::Sema::CheckFormatArguments", NM="_ZN5clang4Sema20CheckFormatArgumentsEN4llvm8ArrayRefIPKNS_4ExprEEEbjjNS0_16FormatStringTypeENS0_16VariadicCallTypeENS_14SourceLocationENS_11SourceRangeERNS1_14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema20CheckFormatArgumentsEN4llvm8ArrayRefIPKNS_4ExprEEEbjjNS0_16FormatStringTypeENS0_16VariadicCallTypeENS_14SourceLocationENS_11SourceRangeERNS1_14SmallBitVectorE")
//</editor-fold>
protected/*private*/ final boolean CheckFormatArguments(ArrayRef</*const*/ Expr /*P*/ > Args, 
                    boolean HasVAListArg, /*uint*/int format_idx, 
                    /*uint*/int firstDataArg, FormatStringType Type, 
                    VariadicCallType CallType, 
                    SourceLocation Loc, SourceRange Range, 
                    final SmallBitVector /*&*/ CheckedVarArgs) {
  UncoveredArgHandler UncoveredArg = null;
  try {
    // CHECK: printf/scanf-like function is called with no format string.
    if ($greatereq_uint(format_idx, Args.size())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_missing_format_string)), Range));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    /*const*/ Expr /*P*/ OrigFormatExpr = Args.$at(format_idx).IgnoreParenCasts$Const();
    
    // CHECK: format string is not a string literal.
    //
    // Dynamically generated format strings are difficult to
    // automatically vet at compile time.  Requiring that format strings
    // are string literals: (1) permits the checking of format strings by
    // the compiler and thereby (2) can practically remove the source of
    // many format string exploits.
    
    // Format string can be either ObjC string (e.g. @"%d") or
    // C string (e.g. "%d")
    // ObjC string uses the same format specifiers as C string, so we can use
    // the same format string checking logic for both ObjC and C strings.
    UncoveredArg/*J*/= new UncoveredArgHandler();
    StringLiteralCheckType CT = SemaCheckingStatics.checkFormatStringExpr(/*Deref*/$this(), OrigFormatExpr, new ArrayRef</*const*/ Expr /*P*/ >(Args), HasVAListArg, 
        format_idx, firstDataArg, Type, CallType, 
        /*IsFunctionCall*/ true, CheckedVarArgs, 
        UncoveredArg);
    
    // Generate a diagnostic where an uncovered argument is detected.
    if (UncoveredArg.hasUncoveredArg()) {
      /*uint*/int ArgIdx = UncoveredArg.getUncoveredArg() + firstDataArg;
      assert ($less_uint(ArgIdx, Args.size())) : "ArgIdx outside bounds";
      UncoveredArg.Diagnose(/*Deref*/$this(), /*IsFunctionCall*/ true, Args.$at(ArgIdx));
    }
    if (CT != StringLiteralCheckType.SLCT_NotALiteral) {
      // Literal format string found, check done!
      return CT == StringLiteralCheckType.SLCT_CheckedLiteral;
    }
    
    // Strftime is particular as it always uses a single 'time' argument,
    // so it is safe to pass a non-literal string.
    if (Type == FormatStringType.FST_Strftime) {
      return false;
    }
    
    // Do not emit diag when the string param is a macro expansion and the
    // format is either NSString or CFString. This is a hack to prevent
    // diag when using the NSLocalizedString and CFCopyLocalizedString macros
    // which are usually used in place of NS and CF string literals.
    SourceLocation FormatLoc = Args.$at(format_idx).getLocStart();
    if (Type == FormatStringType.FST_NSString && $this().SourceMgr.isInSystemMacro(/*NO_COPY*/FormatLoc)) {
      return false;
    }
    
    // If there are no arguments specified, warn with -Wformat-security, otherwise
    // warn only with -Wformat-nonliteral.
    if (Args.size() == firstDataArg) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(FormatLoc), diag.warn_format_nonliteral_noargs)), 
            OrigFormatExpr.getSourceRange()));
        switch (Type) {
         default:
          break;
         case FST_Kprintf:
         case FST_FreeBSDKPrintf:
         case FST_Printf:
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint($c$.track($this().Diag(new SourceLocation(FormatLoc), diag.note_format_security_fixit)), 
              FixItHint.CreateInsertion(/*NO_COPY*/FormatLoc, new StringRef(/*KEEP_STR*/"\"%s\", "))));
          break;
         case FST_NSString:
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint($c$.track($this().Diag(new SourceLocation(FormatLoc), diag.note_format_security_fixit)), 
              FixItHint.CreateInsertion(/*NO_COPY*/FormatLoc, new StringRef(/*KEEP_STR*/"@\"%@\", "))));
          break;
        }
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(FormatLoc), diag.warn_format_nonliteral)), 
            OrigFormatExpr.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  } finally {
    if (UncoveredArg != null) { UncoveredArg.$destroy(); }
  }
}


// Warn when using the wrong abs() function.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAbsoluteValueFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 5954,
 FQN="clang::Sema::CheckAbsoluteValueFunction", NM="_ZN5clang4Sema26CheckAbsoluteValueFunctionEPKNS_8CallExprEPKNS_12FunctionDeclEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema26CheckAbsoluteValueFunctionEPKNS_8CallExprEPKNS_12FunctionDeclEPNS_14IdentifierInfoE")
//</editor-fold>
protected/*private*/ final void CheckAbsoluteValueFunction(/*const*/ CallExpr /*P*/ Call, 
                          /*const*/ FunctionDecl /*P*/ FDecl, 
                          IdentifierInfo /*P*/ FnInfo) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Call.getNumArgs() != 1) {
      return;
    }
    
    /*uint*/int AbsKind = SemaCheckingStatics.getAbsoluteValueFunctionKind(FDecl);
    boolean IsStdAbs = SemaCheckingStatics.IsFunctionStdAbs(FDecl);
    if (AbsKind == 0 && !IsStdAbs) {
      return;
    }
    
    QualType ArgType = Call.getArg$Const(0).IgnoreParenImpCasts$Const().getType();
    QualType ParamType = Call.getArg$Const(0).getType();
    
    // Unsigned types cannot be negative.  Suggest removing the absolute value
    // function call.
    if (ArgType.$arrow().isUnsignedIntegerType()) {
      /*const*/char$ptr/*char P*/ FunctionName = $tryClone(IsStdAbs ? $("std::abs") : $this().Context.BuiltinInfo.getName(AbsKind));
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(Call.getExprLoc(), diag.warn_unsigned_abs)), ArgType), ParamType));
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track($this().Diag(Call.getExprLoc(), diag.note_remove_abs)), 
              FunctionName), 
          FixItHint.CreateRemoval(Call.getCallee$Const().getSourceRange())));
      return;
    }
    
    // Taking the absolute value of a pointer is very suspicious, they probably
    // wanted to index into an array, dereference a pointer, call a function, etc.
    if (ArgType.$arrow().isPointerType() || ArgType.$arrow().canDecayToPointerType()) {
      /*uint*/int DiagType = 0;
      if (ArgType.$arrow().isFunctionType()) {
        DiagType = 1;
      } else if (ArgType.$arrow().isArrayType()) {
        DiagType = 2;
      }
      
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track($this().Diag(Call.getExprLoc(), diag.warn_pointer_abs)), DiagType), ArgType));
      return;
    }
    
    // std::abs has overloads which prevent most of the absolute value problems
    // from occurring.
    if (IsStdAbs) {
      return;
    }
    
    AbsoluteValueKind ArgValueKind = SemaCheckingStatics.getAbsoluteValueKind(new QualType(ArgType));
    AbsoluteValueKind ParamValueKind = SemaCheckingStatics.getAbsoluteValueKind(new QualType(ParamType));
    
    // The argument and parameter are the same kind.  Check if they are the right
    // size.
    if (ArgValueKind == ParamValueKind) {
      if ($lesseq_ulong($this().Context.getTypeSize(new QualType(ArgType)), $this().Context.getTypeSize(new QualType(ParamType)))) {
        return;
      }
      
      /*uint*/int NewAbsKind = SemaCheckingStatics.getBestAbsFunction($this().Context, new QualType(ArgType), AbsKind);
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Call.getExprLoc(), diag.warn_abs_too_small)), 
                  FDecl), ArgType), ParamType));
      if (NewAbsKind == 0) {
        return;
      }
      
      SemaCheckingStatics.emitReplacement(/*Deref*/$this(), Call.getExprLoc(), 
          Call.getCallee$Const().getSourceRange(), NewAbsKind, new QualType(ArgType));
      return;
    }
    
    // ArgValueKind != ParamValueKind
    // The wrong type of absolute value function was used.  Attempt to find the
    // proper one.
    /*uint*/int NewAbsKind = SemaCheckingStatics.changeAbsFunction(AbsKind, ArgValueKind);
    NewAbsKind = SemaCheckingStatics.getBestAbsFunction($this().Context, new QualType(ArgType), NewAbsKind);
    if (NewAbsKind == 0) {
      return;
    }
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Call.getExprLoc(), diag.warn_wrong_absolute_value_type)), 
                FDecl), ParamValueKind), ArgValueKind));
    
    SemaCheckingStatics.emitReplacement(/*Deref*/$this(), Call.getExprLoc(), 
        Call.getCallee$Const().getSourceRange(), NewAbsKind, new QualType(ArgType));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Check for dangerous or invalid arguments to memset().
///
/// This issues warnings on known problematic, dangerous or unspecified
/// arguments to the standard 'memset', 'memcpy', 'memmove', and 'memcmp'
/// function calls.
///
/// \param Call The call expression to diagnose.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMemaccessArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6126,
 FQN="clang::Sema::CheckMemaccessArguments", NM="_ZN5clang4Sema23CheckMemaccessArgumentsEPKNS_8CallExprEjPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema23CheckMemaccessArgumentsEPKNS_8CallExprEjPNS_14IdentifierInfoE")
//</editor-fold>
protected/*private*/ final void CheckMemaccessArguments(/*const*/ CallExpr /*P*/ Call, 
                       /*uint*/int BId, 
                       IdentifierInfo /*P*/ FnName) {
  assert (BId != 0);
  
  // It is possible to have a non-standard definition of memset.  Validate
  // we have enough arguments, and if not, abort further checking.
  /*uint*/int ExpectedNumArgs = (BId == Builtin.ID.BIstrndup.getValue() ? 2 : 3);
  if ($less_uint(Call.getNumArgs(), ExpectedNumArgs)) {
    return;
  }
  
  /*uint*/int LastArg = (BId == Builtin.ID.BImemset.getValue()
     || BId == Builtin.ID.BIstrndup.getValue() ? 1 : 2);
  /*uint*/int LenArg = (BId == Builtin.ID.BIstrndup.getValue() ? 1 : 2);
  /*const*/ Expr /*P*/ LenExpr = Call.getArg$Const(LenArg).IgnoreParenImpCasts$Const();
  if (SemaCheckingStatics.CheckMemorySizeofForComparison(/*Deref*/$this(), LenExpr, FnName, 
      Call.getLocStart(), Call.getRParenLoc())) {
    return;
  }
  
  // We have special checking when the length is a sizeof expression.
  QualType SizeOfArgTy = SemaCheckingStatics.getSizeOfArgType(LenExpr);
  /*const*/ Expr /*P*/ SizeOfArg = SemaCheckingStatics.getSizeOfExprArg(LenExpr);
  FoldingSetNodeID SizeOfArgID/*J*/= new FoldingSetNodeID();
  
  for (/*uint*/int ArgIdx = 0; ArgIdx != LastArg; ++ArgIdx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Expr /*P*/ Dest = Call.getArg$Const(ArgIdx).IgnoreParenImpCasts$Const();
      SourceRange ArgRange = Call.getArg$Const(ArgIdx).getSourceRange();
      
      QualType DestTy = Dest.getType();
      QualType PointeeTy/*J*/= new QualType();
      {
        /*const*/ PointerType /*P*/ DestPtrTy = DestTy.$arrow().getAs(PointerType.class);
        if ((DestPtrTy != null)) {
          PointeeTy.$assignMove(DestPtrTy.getPointeeType());
          
          // Never warn about void type pointers. This can be used to suppress
          // false positives.
          if (PointeeTy.$arrow().isVoidType()) {
            continue;
          }
          
          // Catch "memset(p, 0, sizeof(p))" -- needs to be sizeof(*p). Do this by
          // actually comparing the expressions for equality. Because computing the
          // expression IDs can be expensive, we only do this if the diagnostic is
          // enabled.
          if ((SizeOfArg != null)
             && !$this().Diags.isIgnored(diag.warn_sizeof_pointer_expr_memaccess, 
              SizeOfArg.getExprLoc())) {
            // We only compute IDs for expressions if the warning is enabled, and
            // cache the sizeof arg's ID.
            if (SizeOfArgID.$eq(new FoldingSetNodeID())) {
              SizeOfArg.Profile(SizeOfArgID, $this().Context, true);
            }
            FoldingSetNodeID DestID/*J*/= new FoldingSetNodeID();
            Dest.Profile(DestID, $this().Context, true);
            if (DestID.$eq(SizeOfArgID)) {
              // TODO: For strncpy() and friends, this could suggest sizeof(dst)
              //       over sizeof(src) as well.
              /*uint*/int ActionIdx = 0; // Default is to suggest dereferencing.
              StringRef ReadableName = FnName.getName();
              {
                
                /*const*/ UnaryOperator /*P*/ UnaryOp = dyn_cast_UnaryOperator(Dest);
                if ((UnaryOp != null)) {
                  if (UnaryOp.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
                    ActionIdx = 1; // If its an address-of operator, just remove it.
                  }
                }
              }
              if (!PointeeTy.$arrow().isIncompleteType()
                 && ($this().Context.getTypeSize(new QualType(PointeeTy)) == $this().Context.getCharWidth())) {
                ActionIdx = 2; // If the pointee's size is sizeof(char),
                // suggest an explicit length.
              }
              
              // If the function is defined as a builtin macro, do not show macro
              // expansion.
              SourceLocation SL = SizeOfArg.getExprLoc();
              SourceRange DSR = Dest.getSourceRange();
              SourceRange SSR = SizeOfArg.getSourceRange();
              final SourceManager /*&*/ SM = $this().getSourceManager();
              if (SM.isMacroArgExpansion(/*NO_COPY*/SL)) {
                ReadableName.$assignMove(Lexer.getImmediateMacroName(/*NO_COPY*/SL, SM, $this().LangOpts));
                SL.$assignMove(SM.getSpellingLoc(/*NO_COPY*/SL));
                DSR.$assignMove(new SourceRange(SM.getSpellingLoc(DSR.getBegin()), 
                        SM.getSpellingLoc(DSR.getEnd())));
                SSR.$assignMove(new SourceRange(SM.getSpellingLoc(SSR.getBegin()), 
                        SM.getSpellingLoc(SSR.getEnd())));
              }
              
              $c$.clean($this().DiagRuntimeBehavior(new SourceLocation(SL), SizeOfArg, 
                  PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange(PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType(PartialDiagnostic.$out_PartialDiagnostic$C_StringRef($c$.track($this().PDiag(diag.warn_sizeof_pointer_expr_memaccess)), 
                                      /*NO_COPY*/ReadableName), 
                                  /*NO_COPY*/PointeeTy), 
                              /*NO_COPY*/DestTy), 
                          /*NO_COPY*/DSR), 
                      /*NO_COPY*/SSR)));
              $c$.clean($this().DiagRuntimeBehavior(new SourceLocation(SL), SizeOfArg, 
                  PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange(PartialDiagnostic.$out_PartialDiagnostic$C_uint($c$.track($this().PDiag(diag.warn_sizeof_pointer_expr_memaccess_note)), 
                          ActionIdx), 
                      /*NO_COPY*/SSR)));
              
              break;
            }
          }
          
          // Also check for cases where the sizeof argument is the exact same
          // type as the memory argument, and where it points to a user-defined
          // record type.
          if (QualType.$noteq_QualType$C(SizeOfArgTy, new QualType())) {
            if (PointeeTy.$arrow().isRecordType()
               && $this().Context.typesAreCompatible(new QualType(SizeOfArgTy), new QualType(DestTy))) {
              $c$.clean($this().DiagRuntimeBehavior(LenExpr.getExprLoc(), Dest, 
                  PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange(PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType(PartialDiagnostic.$out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_QualType(PartialDiagnostic.$out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track($this().PDiag(diag.warn_sizeof_pointer_type_memaccess)), 
                                          FnName), /*NO_COPY*/SizeOfArgTy), ArgIdx), 
                              /*NO_COPY*/PointeeTy), Dest.getSourceRange()), 
                      LenExpr.getSourceRange())));
              break;
            }
          }
        } else if (DestTy.$arrow().isArrayType()) {
          PointeeTy.$assign(DestTy);
        }
      }
      if (QualType.$eq_QualType$C(PointeeTy, new QualType())) {
        continue;
      }
      
      // Always complain about dynamic classes.
      bool$ref IsContained = create_bool$ref();
      {
        /*const*/ CXXRecordDecl /*P*/ ContainedRD = SemaCheckingStatics.getContainedDynamicClass(new QualType(PointeeTy), IsContained);
        if ((ContainedRD != null)) {
          
          /*uint*/int OperationType = 0;
          // "overwritten" if we're warning about the destination for any call
          // but memcmp; otherwise a verb appropriate to the call.
          if (ArgIdx != 0 || BId == Builtin.ID.BImemcmp.getValue()) {
            if (BId == Builtin.ID.BImemcpy.getValue()) {
              OperationType = 1;
            } else if (BId == Builtin.ID.BImemmove.getValue()) {
              OperationType = 2;
            } else if (BId == Builtin.ID.BImemcmp.getValue()) {
              OperationType = 3;
            }
          }
          
          $c$.clean($this().DiagRuntimeBehavior(Dest.getExprLoc(), Dest, 
              PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange(PartialDiagnostic.$out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_NamedDecl$C$P(PartialDiagnostic.$out_PartialDiagnostic$C_int(PartialDiagnostic.$out_PartialDiagnostic$C_IdentifierInfo$C$P(PartialDiagnostic.$out_PartialDiagnostic$C_uint($c$.track($this().PDiag(diag.warn_dyn_class_memaccess)), 
                                      (BId == Builtin.ID.BImemcmp.getValue() ? ArgIdx + 2 : ArgIdx)), 
                                  FnName), (IsContained.$deref() ? 1 : 0)), ContainedRD), OperationType), 
                  Call.getCallee$Const().getSourceRange())));
        } else if (PointeeTy.hasNonTrivialObjCLifetime()
           && BId != Builtin.ID.BImemset.getValue()) {
          $c$.clean($this().DiagRuntimeBehavior(Dest.getExprLoc(), Dest, 
              PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType(PartialDiagnostic.$out_PartialDiagnostic$C_IdentifierInfo$C$P(PartialDiagnostic.$out_PartialDiagnostic$C_uint($c$.track($this().PDiag(diag.warn_arc_object_memaccess)), 
                              ArgIdx), FnName), /*NO_COPY*/PointeeTy), 
                  Call.getCallee$Const().getSourceRange())));
        } else {
          continue;
        }
      }
      
      $c$.clean($this().DiagRuntimeBehavior(Dest.getExprLoc(), Dest, 
          PartialDiagnostic.$out_PartialDiagnostic$C_FixItHint$C($c$.track($this().PDiag(diag.note_bad_memaccess_silence)), 
              FixItHint.CreateInsertion(ArgRange.getBegin(), new StringRef(/*KEEP_STR*/"(void*)")))));
      break;
    } finally {
      $c$.$destroy();
    }
  }
}


// Warn if the user has made the 'size' argument to strlcpy or strlcat
// be the size of the source, instead of the destination.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckStrlcpycatArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6326,
 FQN="clang::Sema::CheckStrlcpycatArguments", NM="_ZN5clang4Sema24CheckStrlcpycatArgumentsEPKNS_8CallExprEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema24CheckStrlcpycatArgumentsEPKNS_8CallExprEPNS_14IdentifierInfoE")
//</editor-fold>
protected/*private*/ final void CheckStrlcpycatArguments(/*const*/ CallExpr /*P*/ Call, 
                        IdentifierInfo /*P*/ FnName) {
  raw_svector_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    // Don't crash if the user has the wrong number of arguments
    /*uint*/int NumArgs = Call.getNumArgs();
    if ((NumArgs != 3) && (NumArgs != 4)) {
      return;
    }
    
    /*const*/ Expr /*P*/ SrcArg = SemaCheckingStatics.ignoreLiteralAdditions(Call.getArg$Const(1), $this().Context);
    /*const*/ Expr /*P*/ SizeArg = SemaCheckingStatics.ignoreLiteralAdditions(Call.getArg$Const(2), $this().Context);
    /*const*/ Expr /*P*/ CompareWithSrc = null;
    if (SemaCheckingStatics.CheckMemorySizeofForComparison(/*Deref*/$this(), SizeArg, FnName, 
        Call.getLocStart(), Call.getRParenLoc())) {
      return;
    }
    {
      
      // Look for 'strlcpy(dst, x, sizeof(x))'
      /*const*/ Expr /*P*/ Ex = SemaCheckingStatics.getSizeOfExprArg(SizeArg);
      if ((Ex != null)) {
        CompareWithSrc = Ex;
      } else {
        {
          // Look for 'strlcpy(dst, x, strlen(x))'
          /*const*/ CallExpr /*P*/ SizeCall = dyn_cast_CallExpr(SizeArg);
          if ((SizeCall != null)) {
            if (SizeCall.getBuiltinCallee() == Builtin.ID.BIstrlen.getValue()
               && SizeCall.getNumArgs() == 1) {
              CompareWithSrc = SemaCheckingStatics.ignoreLiteralAdditions(SizeCall.getArg$Const(0), $this().Context);
            }
          }
        }
      }
    }
    if (!(CompareWithSrc != null)) {
      return;
    }
    
    // Determine if the argument to sizeof/strlen is equal to the source
    // argument.  In principle there's all kinds of things you could do
    // here, for instance creating an == expression and evaluating it with
    // EvaluateAsBooleanCondition, but this uses a more direct technique:
    /*const*/ DeclRefExpr /*P*/ SrcArgDRE = dyn_cast_DeclRefExpr(SrcArg);
    if (!(SrcArgDRE != null)) {
      return;
    }
    
    /*const*/ DeclRefExpr /*P*/ CompareWithSrcDRE = dyn_cast_DeclRefExpr(CompareWithSrc);
    if (!(CompareWithSrcDRE != null)
       || SrcArgDRE.getDecl$Const() != CompareWithSrcDRE.getDecl$Const()) {
      return;
    }
    
    /*const*/ Expr /*P*/ OriginalSizeArg = Call.getArg$Const(2);
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_II(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(CompareWithSrcDRE.getLocStart(), diag.warn_strlcpycat_wrong_size)), 
            OriginalSizeArg.getSourceRange()), FnName));
    
    // Output a FIXIT hint if the destination is an array (rather than a
    // pointer to an array).  This could be enhanced to handle some
    // pointers if we know the actual size, like if DstArg is 'array+2'
    // we could say 'sizeof(array)-2'.
    /*const*/ Expr /*P*/ DstArg = Call.getArg$Const(0).IgnoreParenImpCasts$Const();
    if (!SemaCheckingStatics.isConstantSizeArrayWithMoreThanOneElement(DstArg.getType(), $this().Context)) {
      return;
    }
    
    SmallString/*<128>*/ sizeString/*J*/= new SmallString/*<128>*/(128);
    OS/*J*/= new raw_svector_ostream(sizeString);
    OS.$out(/*KEEP_STR*/"sizeof(");
    DstArg.printPretty(OS, (PrinterHelper /*P*/ )null, $this().getPrintingPolicy());
    OS.$out(/*KEEP_STR*/$RPAREN);
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint($c$.track($this().Diag(OriginalSizeArg.getLocStart(), diag.note_strlcpycat_wrong_size)), 
        FixItHint.CreateReplacement(OriginalSizeArg.getSourceRange(), 
            OS.str())));
  } finally {
    if (OS != null) { OS.$destroy(); }
    $c$.$destroy();
  }
}


// Warn on anti-patterns as the 'size' argument to strncat.
// The correct size argument should look like following:
//   strncat(dst, src, sizeof(dst) - strlen(dest) - 1);
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckStrncatArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6414,
 FQN="clang::Sema::CheckStrncatArguments", NM="_ZN5clang4Sema21CheckStrncatArgumentsEPKNS_8CallExprEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema21CheckStrncatArgumentsEPKNS_8CallExprEPNS_14IdentifierInfoE")
//</editor-fold>
protected/*private*/ final void CheckStrncatArguments(/*const*/ CallExpr /*P*/ CE, 
                     IdentifierInfo /*P*/ FnName) {
  raw_svector_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Don't crash if the user has the wrong number of arguments.
    if ($less_uint(CE.getNumArgs(), 3)) {
      return;
    }
    /*const*/ Expr /*P*/ DstArg = CE.getArg$Const(0).IgnoreParenCasts$Const();
    /*const*/ Expr /*P*/ SrcArg = CE.getArg$Const(1).IgnoreParenCasts$Const();
    /*const*/ Expr /*P*/ LenArg = CE.getArg$Const(2).IgnoreParenCasts$Const();
    if (SemaCheckingStatics.CheckMemorySizeofForComparison(/*Deref*/$this(), LenArg, FnName, CE.getLocStart(), 
        CE.getRParenLoc())) {
      return;
    }
    
    // Identify common expressions, which are wrongly used as the size argument
    // to strncat and may lead to buffer overflows.
    /*uint*/int PatternType = 0;
    {
      /*const*/ Expr /*P*/ SizeOfArg = SemaCheckingStatics.getSizeOfExprArg(LenArg);
      if ((SizeOfArg != null)) {
        // - sizeof(dst)
        if (SemaCheckingStatics.referToTheSameDecl(SizeOfArg, DstArg)) {
          PatternType = 1;
        } else // - sizeof(src)
        if (SemaCheckingStatics.referToTheSameDecl(SizeOfArg, SrcArg)) {
          PatternType = 2;
        }
      } else {
        /*const*/ BinaryOperator /*P*/ BE = dyn_cast_BinaryOperator(LenArg);
        if ((BE != null)) {
          if (BE.getOpcode() == BinaryOperatorKind.BO_Sub) {
            /*const*/ Expr /*P*/ L = BE.getLHS().IgnoreParenCasts();
            /*const*/ Expr /*P*/ R = BE.getRHS().IgnoreParenCasts();
            // - sizeof(dst) - strlen(dst)
            if (SemaCheckingStatics.referToTheSameDecl(DstArg, SemaCheckingStatics.getSizeOfExprArg(L))
               && SemaCheckingStatics.referToTheSameDecl(DstArg, SemaCheckingStatics.getStrlenExprArg(R))) {
              PatternType = 1;
            } else // - sizeof(src) - (anything)
            if (SemaCheckingStatics.referToTheSameDecl(SrcArg, SemaCheckingStatics.getSizeOfExprArg(L))) {
              PatternType = 2;
            }
          }
        }
      }
    }
    if (PatternType == 0) {
      return;
    }
    
    // Generate the diagnostic.
    SourceLocation SL = LenArg.getLocStart();
    SourceRange SR = LenArg.getSourceRange();
    final SourceManager /*&*/ SM = $this().getSourceManager();
    
    // If the function is defined as a builtin macro, do not show macro expansion.
    if (SM.isMacroArgExpansion(/*NO_COPY*/SL)) {
      SL.$assignMove(SM.getSpellingLoc(/*NO_COPY*/SL));
      SR.$assignMove(new SourceRange(SM.getSpellingLoc(SR.getBegin()), 
              SM.getSpellingLoc(SR.getEnd())));
    }
    
    // Check if the destination is an array (rather than a pointer to an array).
    QualType DstTy = DstArg.getType();
    boolean isKnownSizeArray = SemaCheckingStatics.isConstantSizeArrayWithMoreThanOneElement(new QualType(DstTy), 
        $this().Context);
    if (!isKnownSizeArray) {
      if (PatternType == 1) {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(SL), diag.warn_strncat_wrong_size)), SR));
      } else {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(SL), diag.warn_strncat_src_size)), SR));
      }
      return;
    }
    if (PatternType == 1) {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(SL), diag.warn_strncat_large_size)), SR));
    } else {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(SL), diag.warn_strncat_src_size)), SR));
    }
    
    SmallString/*<128>*/ sizeString/*J*/= new SmallString/*<128>*/(128);
    OS/*J*/= new raw_svector_ostream(sizeString);
    OS.$out(/*KEEP_STR*/"sizeof(");
    DstArg.printPretty(OS, (PrinterHelper /*P*/ )null, $this().getPrintingPolicy());
    OS.$out(/*KEEP_STR*/") - ");
    OS.$out(/*KEEP_STR*/"strlen(");
    DstArg.printPretty(OS, (PrinterHelper /*P*/ )null, $this().getPrintingPolicy());
    OS.$out(/*KEEP_STR*/") - 1");
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint($c$.track($this().Diag(new SourceLocation(SL), diag.note_strncat_wrong_size)), 
        FixItHint.CreateReplacement(/*NO_COPY*/SR, OS.str())));
  } finally {
    if (OS != null) { OS.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckReturnValExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6904,
 FQN="clang::Sema::CheckReturnValExpr", NM="_ZN5clang4Sema18CheckReturnValExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbPKN4llvm11SmallVectorIPNS_4AttrELj2EEEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema18CheckReturnValExprEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbPKN4llvm11SmallVectorIPNS_4AttrELj2EEEPKNS_12FunctionDeclE")
//</editor-fold>
protected/*private*/ final void CheckReturnValExpr(Expr /*P*/ RetValExp, QualType lhsType, 
                  SourceLocation ReturnLoc) {
  CheckReturnValExpr(RetValExp, lhsType, 
                  ReturnLoc, 
                  false, 
                  (/*const*/SmallVector<Attr /*P*/>/*P*/ )null, 
                  (/*const*/ FunctionDecl /*P*/ )null);
}
protected/*private*/ final void CheckReturnValExpr(Expr /*P*/ RetValExp, QualType lhsType, 
                  SourceLocation ReturnLoc, 
                  boolean isObjCMethod/*= false*/) {
  CheckReturnValExpr(RetValExp, lhsType, 
                  ReturnLoc, 
                  isObjCMethod, 
                  (/*const*/SmallVector<Attr /*P*/>/*P*/ )null, 
                  (/*const*/ FunctionDecl /*P*/ )null);
}
protected/*private*/ final void CheckReturnValExpr(Expr /*P*/ RetValExp, QualType lhsType, 
                  SourceLocation ReturnLoc, 
                  boolean isObjCMethod/*= false*/, 
                  /*const*/SmallVector<Attr /*P*/>/*P*/ Attrs/*= null*/) {
  CheckReturnValExpr(RetValExp, lhsType, 
                  ReturnLoc, 
                  isObjCMethod, 
                  Attrs, 
                  (/*const*/ FunctionDecl /*P*/ )null);
}
protected/*private*/ final void CheckReturnValExpr(Expr /*P*/ RetValExp, QualType lhsType, 
                  SourceLocation ReturnLoc, 
                  boolean isObjCMethod/*= false*/, 
                  /*const*/SmallVector<Attr /*P*/>/*P*/ Attrs/*= null*/, 
                  /*const*/ FunctionDecl /*P*/ FD/*= null*/) {
  SemaCheckingStatics.CheckReturnStackAddr(/*Deref*/$this(), RetValExp, new QualType(lhsType), new SourceLocation(ReturnLoc));
  
  // Check if the return value is null but should not be.
  if ((((Attrs != null) && hasSpecificAttr(ReturnsNonNullAttr.class, $Deref(Attrs)))
     || (!isObjCMethod && SemaCheckingStatics.isNonNullType($this().Context, new QualType(lhsType))))
     && SemaCheckingStatics.CheckNonNullExpr(/*Deref*/$this(), RetValExp)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.warn_null_ret)), 
              (isObjCMethod ? 1 : 0)), RetValExp.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++11 [basic.stc.dynamic.allocation]p4:
  //   If an allocation function declared with a non-throwing
  //   exception-specification fails to allocate storage, it shall return
  //   a null pointer. Any other allocation function that fails to allocate
  //   storage shall indicate failure only by throwing an exception [...]
  if ((FD != null)) {
    OverloadedOperatorKind Op = FD.getOverloadedOperator();
    if (Op == OverloadedOperatorKind.OO_New || Op == OverloadedOperatorKind.OO_Array_New) {
      /*const*/ FunctionProtoType /*P*/ Proto = FD.getType().$arrow().castAs(FunctionProtoType.class);
      if (!Proto.isNothrow($this().Context, /*ResultIfDependent*/ true)
         && SemaCheckingStatics.CheckNonNullExpr(/*Deref*/$this(), RetValExp)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.warn_operator_new_returns_null)), 
                  FD), $this().getLangOpts().CPlusPlus11));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


//===--- CHECK: Floating-Point comparisons (-Wfloat-equal) ---------------===//

/// Check for comparisons of floating point operands using != and ==.
/// Issue a warning if these are no self-comparisons, as they are not likely
/// to do what the programmer intended.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFloatComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 6942,
 FQN="clang::Sema::CheckFloatComparison", NM="_ZN5clang4Sema20CheckFloatComparisonENS_14SourceLocationEPNS_4ExprES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema20CheckFloatComparisonENS_14SourceLocationEPNS_4ExprES3_")
//</editor-fold>
protected/*private*/ final void CheckFloatComparison(SourceLocation Loc, Expr /*P*/ LHS, Expr /*P*/ RHS) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    Expr /*P*/ LeftExprSansParen = LHS.IgnoreParenImpCasts();
    Expr /*P*/ RightExprSansParen = RHS.IgnoreParenImpCasts();
    {
      
      // Special case: check for x == x (which is OK).
      // Do not emit warnings for such cases.
      DeclRefExpr /*P*/ DRL = dyn_cast_DeclRefExpr(LeftExprSansParen);
      if ((DRL != null)) {
        {
          DeclRefExpr /*P*/ DRR = dyn_cast_DeclRefExpr(RightExprSansParen);
          if ((DRR != null)) {
            if (DRL.getDecl() == DRR.getDecl()) {
              return;
            }
          }
        }
      }
    }
    {
      
      // Special case: check for comparisons against literals that can be exactly
      //  represented by APFloat.  In such cases, do not emit a warning.  This
      //  is a heuristic: often comparison against such literals are used to
      //  detect if a value in a variable has not changed.  This clearly can
      //  lead to false negatives.
      FloatingLiteral /*P*/ FLL = dyn_cast_FloatingLiteral(LeftExprSansParen);
      if ((FLL != null)) {
        if (FLL.isExact()) {
          return;
        }
      } else {
        FloatingLiteral /*P*/ FLR = dyn_cast_FloatingLiteral(RightExprSansParen);
        if ((FLR != null)) {
          if (FLR.isExact()) {
            return;
          }
        }
      }
    }
    {
      
      // Check for comparisons with builtin types.
      CallExpr /*P*/ CL = dyn_cast_CallExpr(LeftExprSansParen);
      if ((CL != null)) {
        if ((CL.getBuiltinCallee() != 0)) {
          return;
        }
      }
    }
    {
      
      CallExpr /*P*/ CR = dyn_cast_CallExpr(RightExprSansParen);
      if ((CR != null)) {
        if ((CR.getBuiltinCallee() != 0)) {
          return;
        }
      }
    }
    
    // Emit the diagnostic.
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_floatingpoint_eq)), 
            LHS.getSourceRange()), RHS.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// Diagnoses "dangerous" implicit conversions within the given
/// expression (which is a full expression).  Implements -Wconversion
/// and -Wsign-compare.
///
/// \param CC the "context" location of the implicit conversion, i.e.
///   the most location of the syntactic entity requiring the implicit
///   conversion
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckImplicitConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8853,
 FQN="clang::Sema::CheckImplicitConversions", NM="_ZN5clang4Sema24CheckImplicitConversionsEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema24CheckImplicitConversionsEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
protected/*private*/ final void CheckImplicitConversions(Expr /*P*/ E) {
  CheckImplicitConversions(E, new SourceLocation());
}
protected/*private*/ final void CheckImplicitConversions(Expr /*P*/ E, SourceLocation CC/*= SourceLocation()*/) {
  // Don't diagnose in unevaluated contexts.
  if ($this().isUnevaluatedContext()) {
    return;
  }
  
  // Don't diagnose for value- or type-dependent expressions.
  if (E.isTypeDependent() || E.isValueDependent()) {
    return;
  }
  
  // Check for array bounds violations in cases where the check isn't triggered
  // elsewhere for other Expr types (like BinaryOperators), e.g. when an
  // ArraySubscriptExpr is on the RHS of a variable initialization.
  $this().CheckArrayAccess(E);
  
  // This is not the right CC for (e.g.) a variable initialization.
  SemaCheckingStatics.AnalyzeImplicitConversions(/*Deref*/$this(), E, new SourceLocation(CC));
}


/// CheckBoolLikeConversion - Check conversion of given expression to boolean.
/// Input argument E is a logical expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckBoolLikeConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8873,
 FQN="clang::Sema::CheckBoolLikeConversion", NM="_ZN5clang4Sema23CheckBoolLikeConversionEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema23CheckBoolLikeConversionEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
protected/*private*/ final void CheckBoolLikeConversion(Expr /*P*/ E, SourceLocation CC) {
  /*::*/SemaCheckingStatics.CheckBoolLikeConversion(/*Deref*/$this(), E, new SourceLocation(CC));
}


/// Diagnose when expression is an integer constant expression and its evaluation
/// results in integer overflow
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckForIntOverflow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8879,
 FQN="clang::Sema::CheckForIntOverflow", NM="_ZN5clang4Sema19CheckForIntOverflowEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema19CheckForIntOverflowEPNS_4ExprE")
//</editor-fold>
protected/*private*/ final void CheckForIntOverflow(Expr /*P*/ E) {
  // Use a work list to deal with nested struct initializers.
  SmallVector<Expr /*P*/ > Exprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 2, 1, E, (Expr /*P*/ )null);
  
  do {
    Expr /*P*/ E$1 = Exprs.pop_back_val();
    if (isa_BinaryOperator(E$1.IgnoreParenCasts())) {
      E$1.IgnoreParenCasts().EvaluateForOverflow($this().Context);
      continue;
    }
    {
      
      InitListExpr /*P*/ InitList = dyn_cast_InitListExpr(E$1);
      if ((InitList != null)) {
        Exprs.append_T(InitList.inits().begin(), InitList.inits().end());
      }
    }
  } while (!Exprs.empty());
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckUnsequencedOperations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9382,
 FQN="clang::Sema::CheckUnsequencedOperations", NM="_ZN5clang4Sema26CheckUnsequencedOperationsEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema26CheckUnsequencedOperationsEPNS_4ExprE")
//</editor-fold>
protected/*private*/ final void CheckUnsequencedOperations(Expr /*P*/ E) {
  SmallVector<Expr /*P*/ > WorkList/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  WorkList.push_back(E);
  while (!WorkList.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Expr /*P*/ Item = WorkList.pop_back_val();
      $c$.clean($c$.track(new SequenceChecker(/*Deref*/$this(), Item, WorkList)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Perform semantic checks on a completed expression. This will either
/// be a full-expression or a default argument expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCompletedExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9391,
 FQN="clang::Sema::CheckCompletedExpr", NM="_ZN5clang4Sema18CheckCompletedExprEPNS_4ExprENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema18CheckCompletedExprEPNS_4ExprENS_14SourceLocationEb")
//</editor-fold>
protected/*private*/ final void CheckCompletedExpr(Expr /*P*/ E) {
  CheckCompletedExpr(E, new SourceLocation(), 
                  false);
}
protected/*private*/ final void CheckCompletedExpr(Expr /*P*/ E, SourceLocation CheckLoc/*= SourceLocation()*/) {
  CheckCompletedExpr(E, CheckLoc, 
                  false);
}
protected/*private*/ final void CheckCompletedExpr(Expr /*P*/ E, SourceLocation CheckLoc/*= SourceLocation()*/, 
                  boolean IsConstexpr/*= false*/) {
  $this().CheckImplicitConversions(E, new SourceLocation(CheckLoc));
  if (!E.isInstantiationDependent()) {
    $this().CheckUnsequencedOperations(E);
  }
  if (!IsConstexpr && !E.isValueDependent()) {
    $this().CheckForIntOverflow(E);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckBitFieldInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9400,
 FQN="clang::Sema::CheckBitFieldInitialization", NM="_ZN5clang4Sema27CheckBitFieldInitializationENS_14SourceLocationEPNS_9FieldDeclEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema27CheckBitFieldInitializationENS_14SourceLocationEPNS_9FieldDeclEPNS_4ExprE")
//</editor-fold>
/*friend*//*private*/ final void CheckBitFieldInitialization(SourceLocation InitLoc, 
                           FieldDecl /*P*/ BitField, 
                           Expr /*P*/ Init) {
  /*J:(void)*/SemaCheckingStatics.AnalyzeBitFieldAssignment(/*Deref*/$this(), BitField, Init, new SourceLocation(InitLoc));
}


/// \brief Check whether receiver is mutable ObjC container which
/// attempts to add itself into the container
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCCircularContainer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10099,
 FQN="clang::Sema::CheckObjCCircularContainer", NM="_ZN5clang4Sema26CheckObjCCircularContainerEPNS_15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema26CheckObjCCircularContainerEPNS_15ObjCMessageExprE")
//</editor-fold>
protected/*private*/ final void CheckObjCCircularContainer(ObjCMessageExpr /*P*/ Message) {
  if (!Message.isInstanceMessage()) {
    return;
  }
  
  OptionalInt ArgOpt/*J*/= new OptionalInt();
  if (!(ArgOpt.$assignMove(SemaCheckingStatics.GetNSMutableArrayArgumentIndex(/*Deref*/$this(), Message))).$bool()
     && !(ArgOpt.$assignMove(SemaCheckingStatics.GetNSMutableDictionaryArgumentIndex(/*Deref*/$this(), Message))).$bool()
     && !(ArgOpt.$assignMove(SemaCheckingStatics.GetNSSetArgumentIndex(/*Deref*/$this(), Message))).$bool()) {
    return;
  }
  
  int ArgIndex = ArgOpt.$star();
  
  Expr /*P*/ Arg = Message.getArg(ArgIndex).IgnoreImpCasts();
  {
    OpaqueValueExpr /*P*/ OE = dyn_cast_OpaqueValueExpr(Arg);
    if ((OE != null)) {
      Arg = OE.getSourceExpr().IgnoreImpCasts();
    }
  }
  if (Message.getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperInstance) {
    {
      DeclRefExpr /*P*/ ArgRE = dyn_cast_DeclRefExpr(Arg);
      if ((ArgRE != null)) {
        if (ArgRE.isObjCSelfExpr()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef($c$.track($this().Diag(Message.getSourceRange().getBegin(), 
                        diag.warn_objc_circular_container)), 
                    ArgRE.getDecl().getName()), /*STRINGREF_STR*/"super"));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  } else {
    Expr /*P*/ Receiver = Message.getInstanceReceiver().IgnoreImpCasts();
    {
      
      OpaqueValueExpr /*P*/ OE = dyn_cast_OpaqueValueExpr(Receiver);
      if ((OE != null)) {
        Receiver = OE.getSourceExpr().IgnoreImpCasts();
      }
    }
    {
      
      DeclRefExpr /*P*/ ReceiverRE = dyn_cast_DeclRefExpr(Receiver);
      if ((ReceiverRE != null)) {
        {
          DeclRefExpr /*P*/ ArgRE = dyn_cast_DeclRefExpr(Arg);
          if ((ArgRE != null)) {
            if (ReceiverRE.getDecl() == ArgRE.getDecl()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                ValueDecl /*P*/ Decl = ReceiverRE.getDecl();
                $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef($c$.track($this().Diag(Message.getSourceRange().getBegin(), 
                            diag.warn_objc_circular_container)), 
                        Decl.getName()), Decl.getName()));
                if (!ArgRE.isObjCSelfExpr()) {
                  $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef($c$.track($this().Diag(Decl.getLocation(), 
                          diag.note_objc_circular_container_declared_here)), 
                      Decl.getName()));
                }
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      } else {
        ObjCIvarRefExpr /*P*/ IvarRE = dyn_cast_ObjCIvarRefExpr(Receiver);
        if ((IvarRE != null)) {
          {
            ObjCIvarRefExpr /*P*/ IvarArgRE = dyn_cast_ObjCIvarRefExpr(Arg);
            if ((IvarArgRE != null)) {
              if (IvarRE.getDecl() == IvarArgRE.getDecl()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  ObjCIvarDecl /*P*/ Decl = IvarRE.getDecl();
                  $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef($c$.track($this().Diag(Message.getSourceRange().getBegin(), 
                              diag.warn_objc_circular_container)), 
                          Decl.getName()), Decl.getName()));
                  $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef($c$.track($this().Diag(Decl.getLocation(), 
                          diag.note_objc_circular_container_declared_here)), 
                      Decl.getName()));
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
    }
  }
}

/// \brief Register a magic integral constant to be used as a type tag.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RegisterTypeTagForDatatype">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10832,
 FQN="clang::Sema::RegisterTypeTagForDatatype", NM="_ZN5clang4Sema26RegisterTypeTagForDatatypeEPKNS_14IdentifierInfoEyNS_8QualTypeEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema26RegisterTypeTagForDatatypeEPKNS_14IdentifierInfoEyNS_8QualTypeEbb")
//</editor-fold>
public final void RegisterTypeTagForDatatype(/*const*/ IdentifierInfo /*P*/ ArgumentKind, 
                          long/*uint64_t*/ MagicValue, QualType Type, 
                          boolean LayoutCompatible, 
                          boolean MustBeNull) {
  if (!$this().TypeTagForDatatypeMagicValues.$bool()) {
    $this().TypeTagForDatatypeMagicValues.reset(new DenseMap<std.pairTypeULong</*const*/ IdentifierInfo /*P*/ >, TypeTagData>(DenseMapInfoPairTypePtrULong.$Info(), new TypeTagData()));
  }
  
  std.pairTypeULong</*const*/ IdentifierInfo /*P*/ > Magic/*J*/= new std.pairPtrULong</*const*/ IdentifierInfo /*P*/ >(JD$T$RR_T1$RR.INSTANCE, ArgumentKind, MagicValue);
  ($this().TypeTagForDatatypeMagicValues.$star()).$at_T1$C$R(Magic).$assignMove(
      new TypeTagData(new QualType(Type), LayoutCompatible, MustBeNull)
  );
}


/// \brief Peform checks on a call of a function with argument_with_type_tag
/// or pointer_with_type_tag attributes.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckArgumentWithTypeTag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 10865,
 FQN="clang::Sema::CheckArgumentWithTypeTag", NM="_ZN5clang4Sema24CheckArgumentWithTypeTagEPKNS_23ArgumentWithTypeTagAttrEPKPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN5clang4Sema24CheckArgumentWithTypeTagEPKNS_23ArgumentWithTypeTagAttrEPKPKNS_4ExprE")
//</editor-fold>
protected/*private*/ final void CheckArgumentWithTypeTag(/*const*/ ArgumentWithTypeTagAttr /*P*/ Attr, 
                        type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> ExprArgs) {
  /*const*/ IdentifierInfo /*P*/ ArgumentKind = Attr.getArgumentKind();
  boolean IsPointerAttr = Attr.getIsPointer();
  
  /*const*/ Expr /*P*/ TypeTagExpr = ExprArgs.$at(Attr.getTypeTagIdx());
  bool$ref FoundWrongKind = create_bool$ref();
  TypeTagData TypeInfo/*J*/= new TypeTagData();
  if (!SemaCheckingStatics.GetMatchingCType(ArgumentKind, TypeTagExpr, $this().Context, 
      $this().TypeTagForDatatypeMagicValues.get(), 
      FoundWrongKind, TypeInfo)) {
    if (FoundWrongKind.$deref()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(TypeTagExpr.getExprLoc(), 
                diag.warn_type_tag_for_datatype_wrong_kind)), 
            TypeTagExpr.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    return;
  }
  
  /*const*/ Expr /*P*/ ArgumentExpr = ExprArgs.$at(Attr.getArgumentIdx());
  if (IsPointerAttr) {
    {
      // Skip implicit cast of pointer to `void *' (as a function argument).
      /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(ArgumentExpr);
      if ((ICE != null)) {
        if (ICE.getType().$arrow().isVoidPointerType()
           && ICE.getCastKind() == CastKind.CK_BitCast) {
          ArgumentExpr = ICE.getSubExpr$Const();
        }
      }
    }
  }
  QualType ArgumentType = ArgumentExpr.getType();
  
  // Passing a `void*' pointer shouldn't trigger a warning.
  if (IsPointerAttr && ArgumentType.$arrow().isVoidPointerType()) {
    return;
  }
  if (TypeInfo.MustBeNull) {
    // Type tag with matching void type requires a null pointer.
    if (!(ArgumentExpr.isNullPointerConstant($this().Context, 
        Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_StringRef($c$.track($this().Diag(ArgumentExpr.getExprLoc(), 
                        diag.warn_type_safety_null_pointer_required)), 
                    ArgumentKind.getName()), 
                ArgumentExpr.getSourceRange()), 
            TypeTagExpr.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    return;
  }
  
  QualType RequiredType = new QualType(TypeInfo.Type);
  if (IsPointerAttr) {
    RequiredType.$assignMove($this().Context.getPointerType(/*NO_COPY*/RequiredType));
  }
  
  boolean mismatch = false;
  if (!TypeInfo.LayoutCompatible) {
    mismatch = !$this().Context.hasSameType(new QualType(ArgumentType), new QualType(RequiredType));
    
    // C++11 [basic.fundamental] p1:
    // Plain char, signed char, and unsigned char are three distinct types.
    //
    // But we treat plain `char' as equivalent to `signed char' or `unsigned
    // char' depending on the current char signedness mode.
    if (mismatch) {
      if ((IsPointerAttr && SemaCheckingStatics.IsSameCharType(ArgumentType.$arrow().getPointeeType(), 
          RequiredType.$arrow().getPointeeType()))
         || (!IsPointerAttr && SemaCheckingStatics.IsSameCharType(new QualType(ArgumentType), new QualType(RequiredType)))) {
        mismatch = false;
      }
    }
  } else if (IsPointerAttr) {
    mismatch = !SemaCheckingStatics.isLayoutCompatible($this().Context, 
        ArgumentType.$arrow().getPointeeType(), 
        RequiredType.$arrow().getPointeeType());
  } else {
    mismatch = !SemaCheckingStatics.isLayoutCompatible($this().Context, new QualType(ArgumentType), new QualType(RequiredType));
  }
  if (mismatch) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_II(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(ArgumentExpr.getExprLoc(), diag.warn_type_safety_type_mismatch)), 
                              ArgumentType), ArgumentKind), 
                      TypeInfo.LayoutCompatible), RequiredType), 
              ArgumentExpr.getSourceRange()), 
          TypeTagExpr.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
}

} // END OF class Sema_SemaChecking
